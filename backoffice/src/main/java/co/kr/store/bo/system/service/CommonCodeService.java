package co.kr.store.bo.system.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.kr.store.bo.common.Constants;
import co.kr.store.bo.common.exception.BizException;
import co.kr.store.bo.common.utils.CodeUtils;
import co.kr.store.bo.common.utils.ObjectUtils;
import co.kr.store.bo.common.utils.service.CodeUtilsService;
import co.kr.store.bo.core.dto.domain.CodeBas;
import co.kr.store.bo.system.dao.CommonCodeDao;
import co.kr.store.bo.system.dto.CommonCodeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommonCodeService {

	private final CommonCodeDao commonCodeDao;

	@Transactional
	public CommonCodeDto getGroupCommonCode(CommonCodeDto reqDto) {
		return commonCodeDao.selectGroupCommonCode(reqDto);
	}

	@Transactional
	public List<CommonCodeDto> getGroupCommonCodeList(CommonCodeDto reqDto) {
		int totalCount = commonCodeDao.selectGroupCommonCodeListCount(reqDto);
		reqDto.setTotalCount(totalCount);
		return commonCodeDao.selectGroupCommonCodeList(reqDto);
	}

	@Transactional
	public List<CommonCodeDto> getCommonCodeList(CommonCodeDto reqDto) {
		return commonCodeDao.selectCommonCodeList(reqDto);
	}

	@Transactional
	public void saveCommonCode(CommonCodeDto reqDto) {
		this.saveGroupCommonCode(reqDto);
		List<CommonCodeDto> list = reqDto.getList();
		if ( ObjectUtils.isNotEmpty(list) ) {
			for ( CommonCodeDto commonCodeDto : list ) {
				commonCodeDto.setCodeIdx(reqDto.getCodeIdx());
				this.saveCommonCodeTxn(commonCodeDto);
				CodeUtils.refreshCommonCode(reqDto.getCodeId(), commonCodeDto.getCodeId());
			}
		}
		CodeUtils.refreshCommonCodeList(reqDto.getCodeId());
	}

	@Transactional
	private void saveGroupCommonCode(CommonCodeDto reqDto) {
		String mode = reqDto.getMode();
		if ( Constants.MODE_DELETE.equals(mode) ) {
			commonCodeDao.deleteCodeBas(reqDto.toCodeBas());
			commonCodeDao.deleteCodeTxn(reqDto.toCodeTxn());
		} else if ( Constants.MODE_CREATE.equals(mode) ) {
			CommonCodeDto searchReqDto = new CommonCodeDto();
			searchReqDto.setCodeId(reqDto.getCodeId());
			CommonCodeDto searchResDto = commonCodeDao.selectGroupCommonCode(searchReqDto);
			if ( ObjectUtils.isNotEmpty(searchResDto) ) {
				throw new BizException("동일한 그룹코드가 존재합니다.");
			}
			CodeBas codeBas = reqDto.toCodeBas();
			commonCodeDao.insertCodeBas(codeBas);
			reqDto.setCodeIdx(codeBas.getCodeIdx());
		} else if ( Constants.MODE_UPDATE.equals(mode) ) {
			commonCodeDao.updateCodeBas(reqDto.toCodeBas());
		}
	}

	@Transactional
	private void saveCommonCodeTxn(CommonCodeDto reqDto) {
		String mode = reqDto.getMode();
		if ( Constants.MODE_DELETE.equals(mode) ) {
			commonCodeDao.deleteCodeTxn(reqDto.toCodeTxn());
		} else if ( Constants.MODE_CREATE.equals(mode) ) {
			CommonCodeDto searchReqDto = new CommonCodeDto();
			searchReqDto.setCodeId(reqDto.getCodeId());
			commonCodeDao.insertCodeTxn(reqDto.toCodeTxn());
		} else if ( Constants.MODE_UPDATE.equals(mode) ) {
			commonCodeDao.updateCodeTxn(reqDto.toCodeTxn());
		}
	}

}
