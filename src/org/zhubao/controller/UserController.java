/**
 * 
 */
package org.zhubao.controller;

import java.util.Date;
import java.util.List;

import org.zhubao.generate.model.User;

import com.jfinal.ext.route.ControllerBind;

/**
 * @author Jason.Zhu
 * @date 2014-3-12
 * @email jasonzhu@augmentum.com.cn
 */
@ControllerBind(controllerKey = "/user", viewPath = "/page/user/")
public class UserController extends BaseController<User> {

	public void json() {
		List<User> users = User.dao.find("SELECT * FROM z_user");
		renderJson(users);
	}

	public void pie(){
		render("pie.jsp");
	}
	
	public void pieData(){
		renderJson(User.dao.getPieData());
	}
	
	public void add() {
		String username = getPara("username");
		String email = getPara("email");
		String password = getPara("password");
		String icon = getPara("icon");
		User user = new User();
		user.set("username", username).set("password", password)
				.set("email", email).set("icon", icon).set("birth", new Date())
				.set("createdDate", new Date()).set("updateDate", new Date())
				.save();
		json();
	}

	public void update() {
		// JsonUtil.parseRequestJson(getRequest(), User.class).update();
		int userId = getParaToInt("userId", 0);
		User user = User.dao.findById(userId);
		String username = getPara("username");
		String email = getPara("email");
		String icon = getPara("icon");
		user.set("username", username).set("email", email).set("icon", icon)
				.set("updateDate", new Date()).update();
		json();
	}

	public void delete() {
		int userId = getParaToInt("ids", 0);
		User.dao.findById(userId).delete();
		json();
	}
}
