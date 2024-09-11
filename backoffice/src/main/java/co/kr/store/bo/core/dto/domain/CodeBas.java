package co.kr.store.bo.core.dto.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter(value = AccessLevel.PRIVATE)
@ToString(callSuper = true)
public class CodeBas extends BaseDomain {

	private Integer codeIdx;
	private String codeId;
	private String codeNm;
	private String codeDesc;
	private String useYn;

}
