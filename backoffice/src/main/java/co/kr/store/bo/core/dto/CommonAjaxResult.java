package co.kr.store.bo.core.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import co.kr.store.bo.common.utils.StringUtils;
import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = false)
public class CommonAjaxResult implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_SUCCESS_STATUS = String.valueOf(HttpStatus.OK.value());
	public static final String DEFAULT_FAIL_STATUS = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
	public static final String DEFAULT_SUCCESS_CODE = "SS";
	public static final String DEFAULT_FAIL_CODE = "FF";
	public static final String DEFAULT_FAIL_MESSAGE = "죄송합니다. 잠시 후 다시 시도해 주세요.";

	@Getter
	private String status;

	@Getter
	private String code;

	@Getter
	private String message;

	@Getter
	private Map<String, Object> data = new HashMap<String, Object>();

	public CommonAjaxResult() {
		this.success();
	}

	public CommonAjaxResult(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public void success() {
		this.status = CommonAjaxResult.DEFAULT_SUCCESS_STATUS;
		this.code = CommonAjaxResult.DEFAULT_SUCCESS_CODE;
		this.message = "";
	}

	public void fail() {
		this.fail(CommonAjaxResult.DEFAULT_FAIL_STATUS, CommonAjaxResult.DEFAULT_FAIL_CODE, CommonAjaxResult.DEFAULT_FAIL_MESSAGE);
	}

	public void fail(String message) {
		this.fail(CommonAjaxResult.DEFAULT_FAIL_STATUS, CommonAjaxResult.DEFAULT_FAIL_CODE, message);
	}

	public void fail(String code, String message) {
		this.fail(CommonAjaxResult.DEFAULT_FAIL_STATUS, code, message);
	}

	public void fail(String status, String code, String message) {
		this.status = StringUtils.nvl(status, CommonAjaxResult.DEFAULT_FAIL_STATUS);
		this.code = StringUtils.nvl(code, CommonAjaxResult.DEFAULT_FAIL_CODE);
		this.message = StringUtils.nvl(message, CommonAjaxResult.DEFAULT_FAIL_MESSAGE);
	}

	public void set(String key, Object value) {
		this.data.put(key, value);
	}

	public Object get(String key) {
		return this.data.get(key);
	}

}
