/**
 * 
 */
package org.zhubao.vo;

/**
 * @author Jason.Zhu
 * @date   2014-3-13
 * @email jasonzhu@augmentum.com.cn
 */
public class ResponseVo {

	private boolean success;
	private String msg;
	
	/**
	 * 
	 */
	public ResponseVo() {
		super();
	}
	/**
	 * @param success
	 * @param msg
	 */
	public ResponseVo(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResponseVo [success=" + success + ", msg=" + msg + "]";
	}
	
	
	
}
