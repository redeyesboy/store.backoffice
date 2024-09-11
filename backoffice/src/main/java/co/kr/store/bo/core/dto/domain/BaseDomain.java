package co.kr.store.bo.core.dto.domain;

import co.kr.store.bo.common.utils.AuthUtils;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter(value = AccessLevel.PRIVATE)
@Setter(value = AccessLevel.PRIVATE)
@ToString(callSuper = false)
public class BaseDomain {

	@Builder.Default
	private String delYn = "N";
	@Builder.Default
	private String regId = String.valueOf(AuthUtils.getId());
	@Builder.Default
	private String udtId = String.valueOf(AuthUtils.getId());

}
