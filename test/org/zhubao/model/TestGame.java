/**
 * 
 */
package org.zhubao.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jason.Zhu
 * @date   2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
public class TestGame extends BaseTest<Game>{

	@Test
	public void testFindGame(){
		Game game = Game.dao.findById(1);
		System.out.println(game);
		assertNotNull(game);
	}
}
