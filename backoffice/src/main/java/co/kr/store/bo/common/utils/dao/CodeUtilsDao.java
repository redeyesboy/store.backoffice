package co.kr.store.bo.common.utils.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.store.bo.common.utils.dto.CommonCodeDto;
import co.kr.store.bo.core.config.database.annotation.StoreMapper;

@Mapper
@StoreMapper
public interface CodeUtilsDao {

	List<CommonCodeDto> selectCommonCodeList(CommonCodeDto reqDto);

	CommonCodeDto selectCommonCode(CommonCodeDto reqDto);

}
