/**
 * 
 */
package org.zhubao.controller;

import java.util.Date;

import org.zhubao.model.Game;
import org.zhubao.model.User;
import org.zhubao.vo.ResponseVo;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

/**
 * @author Jason.Zhu
 * @date 2014-3-12
 * @email jasonzhu@augmentum.com.cn
 */
@ControllerBind(controllerKey = "/", viewPath = "/page/common/")
public class CommonController extends Controller {

	public void index() {
		System.out.println(Game.dao.findByAttrUnique("gameName", "First"));
		System.out.println(Game.dao.findByList());
		render("index.jsp");
	}

	public void login() {
		render("login.jsp");
	}

	public void doLogin() {
		String username = getPara("username");
		String password = getPara("password");
		String msg = "success";
		boolean success = true;
		User user = null;
		try {
			user = User.dao.login(username, password);
		} catch (Exception e) {
			msg = e.getMessage();
			success = false;
			redirect("/login");
		}
		setSessionAttr("user", user);
		user.set("lastLoginDate", new Date());
		user.update();
		renderJson(new ResponseVo(success, msg));
	}
}
