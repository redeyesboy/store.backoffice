package co.kr.store.bo.common.utils.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import co.kr.store.bo.common.utils.dao.CodeUtilsDao;
import co.kr.store.bo.common.utils.dto.CommonCodeDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeUtilsService {

	private final CodeUtilsDao codeUtilsDao;

	@Cacheable(value = "CommonCode", key = "#reqDto.getCacheKey()", cacheManager = "cacheManager")
	public List<CommonCodeDto> selectCommonCodeList(CommonCodeDto reqDto) {
		return codeUtilsDao.selectCommonCodeList(reqDto);
	}

	@Cacheable(value = "CommonCode", key = "#reqDto.getCacheKey()", cacheManager = "cacheManager")
	public CommonCodeDto selectCommonCode(CommonCodeDto reqDto) {
		return codeUtilsDao.selectCommonCode(reqDto);
	}

}
