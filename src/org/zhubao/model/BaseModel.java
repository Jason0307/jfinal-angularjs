/**
 * 
 */
package org.zhubao.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.zhubao.util.ConstantsUtil;
import org.zhubao.vo.GridModelVo;
import org.zhubao.vo.RecordVo;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author Jason.Zhu
 * @date 2014-3-20
 * @email jasonzhu@augmentum.com.cn
 */
public abstract class BaseModel<M extends BaseModel<?>> extends Model<M> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String tableName;
	private String pkName;
	private String LIST_SQL = null;
	private String QUERY_ATTR_SQL = null;

	@SuppressWarnings("unchecked")
	public BaseModel() {
		Class<M> modelClass = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		tableName = modelClass.getAnnotation(TableBind.class).tableName();
		pkName = modelClass.getAnnotation(TableBind.class).pkName();
		LIST_SQL = "SELECT * FROM " + tableName;
		QUERY_ATTR_SQL = "SELECT * FROM " + tableName + " WHERE {0} = ?";
	}

	/**
	 * Find the unique record by the attr in the database
	 * 
	 * @param attr
	 * @param value
	 * @return
	 */
	public Record findByAttrUnique(String attr, String value) {
		Record record = Db.findFirst(
				MessageFormat.format(QUERY_ATTR_SQL, attr), value);
		return record;
	}
	
	public List<Record> findByAttrList(String attr,String value){
		List<Record> records = new ArrayList<Record>();
		records = Db.find(
				MessageFormat.format(QUERY_ATTR_SQL, attr), value);
		return records;
	}

	/**
	 * Find all the records in the database
	 * 
	 * @return
	 */
	public GridModelVo findByPagination(int page,int pagesize,String qtype,String query,String sortname,String sortorder) {
		GridModelVo gridModelVo = new GridModelVo();
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		if(!StringUtils.isBlank(query)){
			sb.append(" WHERE ").append(qtype).append(" = ? ");
			params.add(query);
		}
		if(!StringUtils.isBlank(sortname)){
			sb.append(" ORDER BY ").append(sortname).append(" ").append(sortorder);
		}
		
		Page<Record> pager = Db.paginate(page, pagesize, "SELECT *", "FROM " + tableName
				+ sb.toString(),params.toArray());
		List<Record> records = pager.getList();
		List<RecordVo> recordVos = new ArrayList<RecordVo>();
		if (!records.isEmpty()) {
			for (Record record : records) {
				RecordVo vo = new RecordVo();
				vo.setId(record.get(pkName).toString());
				Map<String,Object> map = new HashMap<>();
				for(String column : record.getcolumnNames()){
					Object value = record.get(column);
					if(hasIcon(column)){
						value = "<img src=\"/"+record.get(column)+"\">";
					}
					map.put(column, value);
				}
				vo.setCell(map);
				recordVos.add(vo);
			}
		}
		gridModelVo.setPage(pager.getPageNumber());
		gridModelVo.setRows(recordVos);
		gridModelVo.setTotal(pager.getTotalRow());
		return gridModelVo;
	}

	/**
	 * @param column
	 * @return
	 */
	private boolean hasIcon(String column) {
		boolean result = false;
		String[] iconChars = ConstantsUtil.IMAGE_COLUMN.split(",");
		for(String iconColumn : iconChars){
			if(column.contains(iconColumn)){
				result = true;
				break;
			}
		}
		return result;
	}

	public List<Record> findByList() {
		List<Record> records = new ArrayList<Record>();
		records = Db.find(LIST_SQL);
		return records;
	}

	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}
	
	public abstract List<String> showAttrs();
}
