package co.kr.store.bo.common.utils;

import java.util.List;

import co.kr.store.bo.common.utils.dto.CommonCodeDto;
import co.kr.store.bo.common.utils.service.CodeUtilsService;

public class CodeUtils {

	public static List<CommonCodeDto> getCommonCodeList(String grpCodeId) {
		return CodeUtils.getCommonCodeList(grpCodeId, "Y");
	}

	public static List<CommonCodeDto> getCommonCodeList(String grpCodeId, String useYn) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		reqDto.setUseYn(StringUtils.nvl(useYn, "N"));
		return CodeUtils.getCommonCodeList(reqDto);
	}

	public static List<CommonCodeDto> getCommonCodeList(CommonCodeDto reqDto) {
		CodeUtilsService service = BeanUtils.getBean(CodeUtilsService.class);
		return service.selectCommonCodeList(reqDto);
	}

	public static CommonCodeDto getCommonCode(String grpCodeId, String codeId) {
		return CodeUtils.getCommonCode(grpCodeId, codeId, "Y");
	}

	public static CommonCodeDto getCommonCode(String grpCodeId, String codeId, String useYn) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		reqDto.setCodeId(codeId);
		reqDto.setUseYn(StringUtils.nvl(useYn, "N"));
		return CodeUtils.getCommonCode(reqDto);
	}

	public static CommonCodeDto getCommonCode(CommonCodeDto reqDto) {
		CodeUtilsService service = BeanUtils.getBean(CodeUtilsService.class);
		return service.selectCommonCode(reqDto);
	}

}
