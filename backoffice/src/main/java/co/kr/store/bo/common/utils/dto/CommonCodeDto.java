package co.kr.store.bo.common.utils.dto;

import java.io.Serializable;

import co.kr.store.bo.common.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = false)
public class CommonCodeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String grpCodeId;

	@Getter @Setter
	private String codeId;

	@Getter
	private String codeNm;

	@Getter
	private String refVal01;

	@Getter
	private String refVal02;

	@Getter
	private String refVal03;

	@Getter
	private String refVal04;

	@Getter
	private String refVal05;

	@Getter @Setter
	private String useYn;

	@Setter
	private String cacheKey;

	public String getCacheKey() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.grpCodeId);
		if ( StringUtils.isNotEmpty(this.codeId) ) {
			sb.append("-");
			sb.append(this.codeId);
		}
		sb.append("-");
		sb.append(StringUtils.nvl(this.useYn, "X"));
		return sb.toString();
	}

}
