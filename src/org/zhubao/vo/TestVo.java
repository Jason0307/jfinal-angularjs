/**
 * 
 */
package org.zhubao.vo;

/**
 * @author Jason.Zhu
 * @date   2014-3-25
 * @email jasonzhu@augmentum.com.cn
 */
public class TestVo {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestVo [name=" + name + ", age=" + age + "]";
	}
	
	
}
