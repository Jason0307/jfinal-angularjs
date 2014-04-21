/**
 * 
 */
package org.zhubao.util;


/**
 * @author Jason.Zhu
 * @date 2014-3-20
 * @email jasonzhu@augmentum.com.cn
 */
public class TestUtil {

	public static void main(String[] args) {
		String jobName = "123";
		String job = "org.zhubao.util.TestJob";
		QuartzManager.addJob(jobName, job, "0/1 * * * * ?"); 
		
	}
}
