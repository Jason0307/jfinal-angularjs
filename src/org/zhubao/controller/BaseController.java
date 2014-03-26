/**
 * 
 */
package org.zhubao.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.zhubao.model.BaseModel;
import org.zhubao.util.ConstantsUtil;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author Jason.Zhu
 * @date 2014-3-21
 * @email jasonzhu@augmentum.com.cn
 */
public class BaseController<M extends Model<M>> extends Controller {

	private BaseModel<?> dao;
    private static Logger log = Logger.getLogger(BaseController.class);
	
	@SuppressWarnings("unchecked")
	public BaseController() {

		Class<M> modelClass = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			dao = (BaseModel<?>) modelClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			log.error(e.getMessage(),e);
		}
	}

	public void list() {
		int page = getParaToInt("page", ConstantsUtil.DEFAULT_PAGE_SIZE);
		int pagesize = getParaToInt("rp", ConstantsUtil.DEFAULT_PAGE_SIZE);
		String qtype = getPara("qtype");
		String query = getPara("query");
		String sortname = getPara("sortname");
		String sortorder = getPara("sortorder");
		renderJson(dao.findByPagination(page,pagesize,qtype,query,sortname,sortorder));
	}
	
	public void index(){
		Object[] arr =  dao.showAttrs().toArray();
		StringBuilder sb = new StringBuilder();
		if(0 != arr.length){
			for(int i = 0; i < arr.length; i++){
				sb.append(arr[i]);
				if(1 != (arr.length -i)){
					sb.append(",");
				}
			}
		}
		setAttr("attrs", sb.toString());
		render("index.jsp");
	}
	
	@SuppressWarnings({"unchecked" })
	public <T> T parseRequestJson(Class<T> objectClass) {
		HttpServletRequest request = getRequest();
		Enumeration<String> enumStrs = request.getParameterNames();
		StringBuilder jsonData = new StringBuilder();
		while(enumStrs.hasMoreElements()){
			jsonData.append(enumStrs.nextElement());
		}
		ObjectMapper ob = new ObjectMapper();
		T object  = null;
		try {
			if(objectClass.newInstance() instanceof Model){
				Model<?> model = (Model<?>) objectClass.newInstance();
				Map<String,Object> attrMap = ob.readValue(jsonData.toString(), Map.class);
				Set<Entry<String,Object>> entrySet = attrMap.entrySet();
				for(Iterator<Entry<String,Object>> iter = entrySet.iterator();iter.hasNext();){
					Entry<String,Object> entry = iter.next();
					String attr = entry.getKey();
					Object attrValue = entry.getValue();
					model.set(attr, attrValue);
				}
				object = (T) model;
			}else{
				object = ob.readValue(jsonData.toString(), objectClass);
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		return object;
	}
	
}
