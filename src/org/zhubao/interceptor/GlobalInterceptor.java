/**
 * 
 */
package org.zhubao.interceptor;

import java.util.Locale;

import org.zhubao.util.ConstantsUtil;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Const;
import com.jfinal.core.Controller;
import com.jfinal.i18n.I18N;

/**
 * @author Jason.Zhu
 * @date 2014-3-14
 * @email jasonzhu@augmentum.com.cn
 */

public class GlobalInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller c = ai.getController();
		c.setAttr("I18N", I18N.me());
		String tmp = c.getCookie(Const.I18N_LOCALE);
		Locale locale = c.getRequest().getLocale();
		String i18n = "zh_CN";
		if (null != locale) {
			if(ConstantsUtil.LOCALE_CHINA_COOKIE.equals(locale.getLanguage())){
				i18n = ConstantsUtil.LOCALE_CHINA;
			}else{
				i18n = ConstantsUtil.LOCALE_US;
			}
		}
		System.out.println("i18n : " + i18n);
		System.out.println("temp : " + tmp);
		if (!i18n.equals(tmp)) {
			ai.getController().setCookie(Const.I18N_LOCALE, i18n,
					Const.DEFAULT_I18N_MAX_AGE_OF_COOKIE);
		}
		ai.invoke();
	}

}