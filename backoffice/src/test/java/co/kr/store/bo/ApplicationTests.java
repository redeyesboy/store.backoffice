package co.kr.store.bo;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import co.kr.store.bo.common.utils.CodeUtils;
import co.kr.store.bo.common.utils.RedisUtils;
import co.kr.store.bo.system.dto.CommonCodeDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ApplicationTests {

	@Autowired
	@Qualifier("jasyptEncryptor")
	private PooledPBEStringEncryptor encryptor;

	@Test
	void codeTest() {
		log.info("XXXXXXXXXX :: {}"
		,CodeUtils.getCommonCodeList("1111111111111")
				);


		log.info("XXXXXXXXXX222222222 :: {}"
				,CodeUtils.getCommonCodeList("1111111111111")
						);

		log.info("XXXXXXXXXX33333333333 :: {}"
				,CodeUtils.getCommonCodeList("1111111111111", null)
						);

		log.info("XXXXXXXXXX44444444444 :: {}"
				,CodeUtils.getCommonCodeList("1111111111111", null)
						);
	}

//	@Test
	void jasyptEncryption() {

		String value = "test_value";
		String encValue = encryptor.encrypt(value);
		String decValue = encryptor.decrypt(encValue);

		log.info("Value:: {}", value);
		log.info("EncValue:: {}", encValue);
		log.info("DecValue:: {}", decValue);

	}

//	@Test
	void redisTemplateTest() {

		String key = "re_key";
		CommonCodeDto value1 = new CommonCodeDto();
		value1.setCodeNm("TEST");
		List<CommonCodeDto> value = new ArrayList<CommonCodeDto>();
		value.add(value1);

		RedisUtils.set(key, value);
		log.info("bf Value:: {}", RedisUtils.get(key));

//		RedisUtils.delete(key);
//		log.info("af Value:: {}", RedisUtils.get(key));

		RedisUtils.delete("001");

		log.info("af Value:: {}", RedisUtils.get("001", "01"));

		RedisUtils.set("001", "01", value);


		log.info("bf Value:: {}", RedisUtils.get("001", "01"));

	}

}
