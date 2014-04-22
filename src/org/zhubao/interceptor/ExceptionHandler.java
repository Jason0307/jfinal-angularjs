/**
 * 
 */
package org.zhubao.interceptor;

import org.zhubao.exception.AngularException;
import org.zhubao.vo.JsonResponse;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 * @author Jason.Zhu
 * @date 2014-4-22
 * @email jasonzhu@augmentum.com.cn
 */
public class ExceptionHandler implements Interceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jfinal.aop.Interceptor#intercept(com.jfinal.core.ActionInvocation)
	 */
	@Override
	public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
		try {
			ai.invoke();
		} catch (Exception e) {
			AngularException ex = (AngularException) e;
			JsonResponse jsonResponse = new JsonResponse();
			jsonResponse.setStatus(ex.getErrorCode());
			jsonResponse.setAdditionalInfo(e.getMessage());
			controller.renderJson(jsonResponse);
		}

	}
}
