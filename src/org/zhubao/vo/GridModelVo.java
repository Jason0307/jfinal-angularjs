/**
 * 
 */
package org.zhubao.vo;

import java.util.List;

/**
 * @author Jason.Zhu
 * @date   2014-3-21
 * @email jasonzhu@augmentum.com.cn
 */
public class GridModelVo {

	private int page;
	private int total;
	private List<RecordVo> rows;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<RecordVo> getRows() {
		return rows;
	}
	public void setRows(List<RecordVo> rows) {
		this.rows = rows;
	}
	
	
	
}
