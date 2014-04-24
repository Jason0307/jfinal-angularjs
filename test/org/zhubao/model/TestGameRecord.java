/**
 * 
 */
package org.zhubao.model;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jason.Zhu
 * @date 2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
@RunWith(JMock.class)
public class TestGameRecord {
	Mockery context = new JUnit4Mockery();

	@Test
	public void testGameRecord() {
		/*final User user = context.mock(User.class);
		context.checking(new Expectations() {
			{
				oneOf(user).findById(1);
			}
		});*/
	}
}
