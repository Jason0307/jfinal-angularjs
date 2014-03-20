/**
 * 
 */
package org.zhubao.util;

import java.text.MessageFormat;

/**
 * @author Jason.Zhu
 * @date   2014-3-20
 * @email jasonzhu@augmentum.com.cn
 */
public class TestUtil {

	public static void main(String[] args) {
		String s = "SELECT * FROM z_game WHERE {0} = ?";
		System.out.println(MessageFormat.format(s, "gameName"));
	}
}
