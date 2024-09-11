package co.kr.store.bo.common.exception;

import lombok.Getter;

public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private String code;

	@Getter
	private String message;

	public BizException() {
		super();
	}

	public BizException(String message) {
		super();
		this.message = message;
	}

	public BizException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
