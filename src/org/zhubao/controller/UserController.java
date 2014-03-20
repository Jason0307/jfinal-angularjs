/**
 * 
 */
package org.zhubao.controller;

import java.util.Date;
import java.util.List;

import org.zhubao.model.User;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

/**
 * @author Jason.Zhu
 * @date 2014-3-12
 * @email jasonzhu@augmentum.com.cn
 */
@ControllerBind(controllerKey = "/user", viewPath = "/page/user/")
public class UserController extends Controller {

	public void json() {
		List<User> users = User.dao.find("SELECT * FROM z_user");
		renderJson(users);
	}

	public void listUser() {

	}

	public void index() {
		render("index.jsp");
	}

	public void add() {
		String username = getPara("username");
		String email = getPara("email");
		String password = getPara("password");
		String icon = "";
		User user = new User();
		user.set("username", username).set("password", password)
				.set("email", email).set("icon", icon).set("birth", new Date())
				.set("createdDate", new Date()).set("updateDate", new Date())
				.save();
		json();
	}

	public void update() {

		User user = getModel(User.class);
		System.out.println(user.get("username"));
	}

	public void delete() {

	}
}
