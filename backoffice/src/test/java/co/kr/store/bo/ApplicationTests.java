package co.kr.store.bo;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ApplicationTests {

	@Autowired
	@Qualifier("jasyptEncryptor")
	private PooledPBEStringEncryptor encryptor;

	@Test
	void jasyptEncryption() {

		String value = "test_value";
		String encValue = encryptor.encrypt(value);
		String decValue = encryptor.decrypt(encValue);

		log.info("Value:: {}", value);
		log.info("EncValue:: {}", encValue);
		log.info("DecValue:: {}", decValue);

	}

}
