package co.kr.store.bo.common.utils.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import co.kr.store.bo.common.Constants;
import co.kr.store.bo.common.utils.dao.CodeUtilsDao;
import co.kr.store.bo.common.utils.dto.CommonCodeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeUtilsService {

	private final CodeUtilsDao codeUtilsDao;

	@Cacheable(cacheNames = Constants.CACHE_NAME_COMMON_CODE, key = "#reqDto.getCacheKey()", cacheManager = Constants.DEFAULT_CACHE_MANAGER)
	public List<CommonCodeDto> selectCommonCodeList(CommonCodeDto reqDto) {
		return codeUtilsDao.selectCommonCodeList(reqDto);
	}

	@Cacheable(cacheNames = Constants.CACHE_NAME_COMMON_CODE, key = "#reqDto.getCacheKey()", cacheManager = Constants.DEFAULT_CACHE_MANAGER)
	public CommonCodeDto selectCommonCode(CommonCodeDto reqDto) {
		return codeUtilsDao.selectCommonCode(reqDto);
	}

	@CacheEvict(cacheNames = Constants.CACHE_NAME_COMMON_CODE, key = "#reqDto.getCacheKey()", cacheManager = Constants.DEFAULT_CACHE_MANAGER)
	public void deleteCommonCodeCache(CommonCodeDto reqDto) {
		log.info("DELETE CACHE KEY :: {}::{}", Constants.CACHE_NAME_COMMON_CODE, reqDto.getCacheKey());
	}

}
