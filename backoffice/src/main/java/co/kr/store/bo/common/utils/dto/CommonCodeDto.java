package co.kr.store.bo.common.utils.dto;

import java.io.Serializable;

import co.kr.store.bo.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(callSuper = false)
public class CommonCodeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String grpCodeId;

	private String codeId;

	private String codeNm;

	private String refVal01;

	private String refVal02;

	private String refVal03;

	private String refVal04;

	private String refVal05;

	private String useYn;

	private String cacheKey;

	public String getCacheKey() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.grpCodeId);
		if ( StringUtils.isNotEmpty(this.codeId) ) {
			sb.append("-");
			sb.append(this.codeId);
		}
		sb.append("-");
		sb.append(StringUtils.nvl(this.useYn));
		this.cacheKey = sb.toString();
		return cacheKey;
	}

}
