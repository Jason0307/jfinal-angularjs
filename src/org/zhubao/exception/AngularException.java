/**
 * 
 */
package org.zhubao.exception;

import org.zhubao.util.ExceptionMapping;

/**
 * @author Jason.Zhu
 * @date 2014-3-13
 * @email jasonzhu@augmentum.com.cn
 */
public class AngularException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer errorCode;

	public AngularException() {
		super();

		this.errorCode = 0;
	}

	public AngularException(Integer errorCode) {

		super(ExceptionMapping.lookUpErrorMessage(errorCode));

		this.errorCode = errorCode;
	}

	public AngularException(String msg, Integer errorCode) {
		super(msg);

		this.errorCode = errorCode;
	}

	public AngularException(String msg, Throwable cause, Integer errorCode) {
		super(msg, cause);

		this.errorCode = errorCode;
	}

	public AngularException(Throwable cause, Integer errorCode) {
		super(cause);

		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpStatusCode() {
		ExceptionMapping map = ExceptionMapping.getInstance();
		String code = map.getString(errorCode
				+ ExceptionMapping.HTTP_STATUS_SUFFIX);
		if (code == null) {
			return ExceptionMapping.lookUpHttpStatusCode(this);
		} else {
			return Integer.parseInt(code);
		}
	}

}
