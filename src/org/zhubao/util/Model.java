/**
 * 
 */
package org.zhubao.util;

import java.util.List;

/**
 * @author Jason.Zhu
 * @date   2014-3-19
 * @email jasonzhu@augmentum.com.cn
 */
public class Model {

	private String name;
	private String tableName;
	private String pkName;
	private List<Attr> attrs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Attr> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<Attr> attrs) {
		this.attrs = attrs;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getPkName() {
		return pkName;
	}
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", tableName=" + tableName + ", pkName="
				+ pkName + ", attrs=" + attrs + "]";
	}
	
}
