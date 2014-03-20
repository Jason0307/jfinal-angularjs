/**
 * 
 */
package org.zhubao.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Const;
import com.jfinal.core.Controller;
import com.jfinal.i18n.I18N;

/**
 * @author Jason.Zhu
 * @date   2014-3-14
 * @email jasonzhu@augmentum.com.cn
 */

public class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller c = ai.getController();
		c.setAttr("I18N", I18N.me());
		String tmp = c.getCookie(Const.I18N_LOCALE);
		String i18n = c.getRequest().getLocale().toString();
		if (!i18n.equals(tmp)) {
			ai.getController().setCookie(Const.I18N_LOCALE, i18n,
					Const.DEFAULT_I18N_MAX_AGE_OF_COOKIE);
		}
		ai.invoke();

	}

}