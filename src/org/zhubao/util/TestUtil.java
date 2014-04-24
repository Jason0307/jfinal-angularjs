/**
 * 
 */
package org.zhubao.util;

import com.jfinal.kit.PathKit;



/**
 * @author Jason.Zhu
 * @date 2014-3-20
 * @email jasonzhu@augmentum.com.cn
 */
public class TestUtil {
	
	void testPublic(){
		System.out.println("sss");
		
	}

	public static void main(String[] args) throws Exception{
		/*String jobName = "123";
		String job = "org.zhubao.util.TestJob";
		QuartzManager.addJob(jobName, job, "0/1 * * * * ?"); */
		System.out.println(PathKit.getWebRootPath());
	}
}
