/**
 * 
 */
package org.zhubao.model;

import java.util.Map;

import org.zhubao.exception.AngularException;
import org.zhubao.util.ErrorCodeConstant;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author Jason.Zhu
 * @date 2014-3-12
 * @email jasonzhu@augmentum.com.cn
 */
@TableBind(tableName = "z_user", pkName = "userId")
public class User extends Model<User> {
	private static final long serialVersionUID = 1L;
	public static User dao = new User();

	public User findByUsername(String username) {
		User user = User.dao.findFirst(
				"SELECT * FROM z_user WHERE username = ?", username);
		if (null != user) {
			return user;
		}
		throw new AngularException(ErrorCodeConstant.USER_NOT_EXIST);
	}

	public User login(String username, String password) {
		User user = findByUsername(username);
		if (password.equals(user.get("password"))) {
			return user;
		}
		throw new AngularException(ErrorCodeConstant.LOGIN_VALID);
	}
	
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}
}
