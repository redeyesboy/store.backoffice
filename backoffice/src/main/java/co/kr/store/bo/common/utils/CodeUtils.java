package co.kr.store.bo.common.utils;

import java.util.List;

import co.kr.store.bo.common.utils.dto.CommonCodeDto;
import co.kr.store.bo.common.utils.service.CodeUtilsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeUtils {

	public static List<CommonCodeDto> getCommonCodeList(String grpCodeId) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		reqDto.setUseYn("Y");
		return CodeUtils.getCommonCodeList(reqDto);
	}

	public static List<CommonCodeDto> getAllCommonCodeList(String grpCodeId) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		return CodeUtils.getCommonCodeList(reqDto);
	}

	public static List<CommonCodeDto> getCommonCodeList(CommonCodeDto reqDto) {
		CodeUtilsService service = BeanUtils.getBean(CodeUtilsService.class);
		return service.selectCommonCodeList(reqDto);
	}

	public static CommonCodeDto getCommonCode(String grpCodeId, String codeId) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		reqDto.setCodeId(codeId);
		return CodeUtils.getCommonCode(reqDto);
	}

	public static CommonCodeDto getCommonCode(CommonCodeDto reqDto) {
		CodeUtilsService service = BeanUtils.getBean(CodeUtilsService.class);
		return service.selectCommonCode(reqDto);
	}

	public static void refreshCommonCodeList(String grpCodeId) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		CodeUtils.deleteCommonCodeCache(reqDto);
		reqDto.setUseYn("Y");
		CodeUtils.deleteCommonCodeCache(reqDto);
	}

	public static void refreshCommonCode(String grpCodeId, String codeId) {
		CommonCodeDto reqDto = new CommonCodeDto();
		reqDto.setGrpCodeId(grpCodeId);
		reqDto.setCodeId(codeId);
		CodeUtils.deleteCommonCodeCache(reqDto);
	}

	public static void deleteCommonCodeCache(CommonCodeDto reqDto) {
		CodeUtilsService service = BeanUtils.getBean(CodeUtilsService.class);
		service.deleteCommonCodeCache(reqDto);
	}

}
