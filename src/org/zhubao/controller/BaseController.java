/**
 * 
 */
package org.zhubao.controller;

import java.lang.reflect.ParameterizedType;

import org.zhubao.model.BaseModel;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author Jason.Zhu
 * @date 2014-3-21
 * @email jasonzhu@augmentum.com.cn
 */
public class BaseController<M extends Model<M>> extends Controller {

	private BaseModel<?> dao;

	@SuppressWarnings("unchecked")
	public BaseController() {

		Class<M> modelClass = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			dao = (BaseModel<?>) modelClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
		}
	}

	public void list() {
		renderJson(dao.findByList());
	}
}
