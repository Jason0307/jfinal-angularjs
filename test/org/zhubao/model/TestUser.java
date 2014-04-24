/**
 * 
 */
package org.zhubao.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author Jason.Zhu
 * @date 2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
public class TestUser extends BaseTest<User> {

	@Test
	public void testFindUser() {
		User user = User.dao.findByUsername("jason");
		System.out.println(user);
		assertNotNull(user);
	}
}
