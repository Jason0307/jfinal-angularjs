/**
 * 
 */
package org.zhubao.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * @author Jason.Zhu
 * @date 2013-12-25
 * @email jasonzhu@augmentum.com.cn
 */
public class LoginValidator extends Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jfinal.validate.Validator#validate(com.jfinal.core.Controller)
	 */
	@Override
	protected void validate(Controller c) {
		validateRequired("username", "msg",
				"Username or password should be given!");
		validateRequired("password", "msg",
				"Username or password should be given!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jfinal.validate.Validator#handleError(com.jfinal.core.Controller)
	 */
	@Override
	protected void handleError(Controller c) {
		c.keepPara("username");
		c.render("/page/common/login.jsp");

	}

}