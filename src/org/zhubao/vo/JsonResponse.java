/**
 * 
 */
package org.zhubao.vo;

/**
 * @author Jason.Zhu
 * @date   2014-4-22
 * @email jasonzhu@augmentum.com.cn
 */
public class JsonResponse {

	private Object response;
    private int status;
    private String additionalInfo;
	
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	
}
