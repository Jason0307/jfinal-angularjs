/**
 * 
 */
package org.zhubao.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.zhubao.vo.GameResultVo;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author Jason.Zhu
 * @date 2014-3-25
 * @email jasonzhu@augmentum.com.cn
 */
public class JsonUtil {

	private static Logger log = Logger.getLogger(JsonUtil.class);
	@SuppressWarnings("unchecked")
	public static <T> T parseRequestJson(HttpServletRequest request,
			Class<T> objectClass) {

		Enumeration<String> enumStrs = request.getParameterNames();
		StringBuilder jsonData = new StringBuilder();
		while (enumStrs.hasMoreElements()) {
			jsonData.append(enumStrs.nextElement());
		}
		ObjectMapper ob = new ObjectMapper();
		T object = null;
		try {
			if (Model.class.isAssignableFrom(objectClass)) {
				Model<?> model = (Model<?>) objectClass.newInstance();
				Map<String, Object> attrMap = ob.readValue(jsonData.toString(),
						Map.class);
				Set<Entry<String, Object>> entrySet = attrMap.entrySet();
				for (Iterator<Entry<String, Object>> iter = entrySet.iterator(); iter
						.hasNext();) {
					Entry<String, Object> entry = iter.next();
					String attr = entry.getKey();
					Object attrValue = entry.getValue();
					model.set(attr, attrValue);
				}
				object = (T) model;
			} else {
				object = ob.readValue(jsonData.toString(), objectClass);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return object;
	}
	/**
	 * @param para
	 * @param class1
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static GameResultVo parseStringToVo(String data,
			Class<GameResultVo> clazz) throws Exception {
		ObjectMapper ob = new ObjectMapper();
		if(!StringUtils.isBlank(data)){
			GameResultVo gameResultVo = ob.readValue(data, clazz);
			return gameResultVo;
		}
		return null;
	}
}
