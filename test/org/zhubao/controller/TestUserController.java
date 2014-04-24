/**
 * 
 */
package org.zhubao.controller;

import org.junit.Test;
import org.zhubao.config.AngularConfig;

import com.jfinal.ext.test.ControllerTestCase;

/**
 * @author Jason.Zhu
 * @date   2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
public class TestUserController extends ControllerTestCase<AngularConfig>{

	
	@Test
	public void testUserList(){
		String url = "/index";
		String s = use(url).invoke();
		System.out.println(s);
	}
}
