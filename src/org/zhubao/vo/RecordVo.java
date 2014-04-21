/**
 * 
 */
package org.zhubao.vo;

import java.util.Map;


/**
 * @author Jason.Zhu
 * @date   2014-3-21
 * @email jasonzhu@augmentum.com.cn
 */
public class RecordVo {

	private String id;
	private Map<String,Object> cell;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getCell() {
		return cell;
	}
	public void setCell(Map<String, Object> cell) {
		this.cell = cell;
	}
	

}
