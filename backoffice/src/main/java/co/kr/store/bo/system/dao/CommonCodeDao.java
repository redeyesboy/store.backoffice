package co.kr.store.bo.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.store.bo.core.config.database.annotation.StoreMapper;
import co.kr.store.bo.core.dto.domain.CodeBas;
import co.kr.store.bo.core.dto.domain.CodeTxn;
import co.kr.store.bo.system.dto.CommonCodeDto;

@StoreMapper
@Mapper
public interface CommonCodeDao {

	CommonCodeDto selectGroupCommonCode(CommonCodeDto reqDto);

	int selectGroupCommonCodeListCount(CommonCodeDto reqDto);

	List<CommonCodeDto> selectGroupCommonCodeList(CommonCodeDto reqDto);

	List<CommonCodeDto> selectCommonCodeList(CommonCodeDto reqDto);

	int insertCodeBas(CodeBas entity);

	int updateCodeBas(CodeBas entity);

	int deleteCodeBas(CodeBas entity);

	int insertCodeTxn(CodeTxn entity);

	int updateCodeTxn(CodeTxn entity);

	int deleteCodeTxn(CodeTxn entity);

}
