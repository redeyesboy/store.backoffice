package co.kr.store.bo.system.dto;

import co.kr.store.bo.core.dto.BaseDto;
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

	private String grpCodeId;
	private String grpCodeNm;
	private String useYn;
	private String grpCodeDesc;
	private String codeId;
	private String codeNm;
	private int dispOrd;
	private String refVal01;
	private String refVal02;
	private String refVal03;
	private String refVal04;
	private String refVal05;

}
