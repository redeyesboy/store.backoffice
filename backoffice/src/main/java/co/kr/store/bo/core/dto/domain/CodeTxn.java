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
public class CodeTxn extends BaseDomain {

	private Integer codeTxnIdx;
	private Integer codeIdx;
	private String codeId;
	private String codeNm;
	private String useYn;
	private int dispOrd;
	private String refVal01;
	private String refVal02;
	private String refVal03;
	private String refVal04;
	private String refVal05;

}
