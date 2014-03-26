/**
 * 
 */
package org.zhubao.controller;



import org.zhubao.generate.model.User;
import org.zhubao.vo.TestVo;

import com.jfinal.ext.route.ControllerBind;

/**
 * 
 * @author Jason.Zhu
 * @date   2014-3-24
 * @email jasonzhu@augmentum.com.cn
 */

@ControllerBind(controllerKey = "/test",viewPath = "/page/test/")
public class TestController extends BaseController<User>{

	public void testJson(){
		render("json.jsp");
	}
	public void json(){
		System.out.println(parseRequestJson(TestVo.class));
		renderJson("{\"success\":true}");
	}
	
}
