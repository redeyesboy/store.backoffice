package co.kr.store.bo.system.dto;

import java.util.List;

import co.kr.store.bo.core.dto.BaseDto;
import co.kr.store.bo.core.dto.domain.CodeBas;
import co.kr.store.bo.core.dto.domain.CodeTxn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter @Setter
@ToString(callSuper = true)
public class CommonCodeDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Integer codeIdx;
	private Integer codeTxnIdx;
	private String grpCodeId;
	private String grpCodeNm;
	private String useYn;
	private String grpCodeDesc;
	private String codeDesc;
	private String codeId;
	private String codeNm;
	private int dispOrd;
	private String refVal01;
	private String refVal02;
	private String refVal03;
	private String refVal04;
	private String refVal05;
	private String div;
	private String value;
	private List<CommonCodeDto> list;

	public CodeBas toCodeBas() {
		return CodeBas.builder()
			.codeIdx(codeIdx)
			.codeId(codeId)
			.codeNm(codeNm)
			.codeDesc(codeDesc)
			.useYn(useYn)
			.build();
	}

	public CodeTxn toCodeTxn() {
		return CodeTxn.builder()
			.codeTxnIdx(codeTxnIdx)
			.codeIdx(codeIdx)
			.codeId(codeId)
			.codeNm(codeNm)
			.useYn(useYn)
			.dispOrd(dispOrd)
			.refVal01(refVal01)
			.refVal02(refVal02)
			.refVal03(refVal03)
			.refVal04(refVal04)
			.refVal05(refVal05)
			.build();
	}

}
