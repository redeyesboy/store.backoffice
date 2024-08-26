package co.kr.store.bo.core.config.encryption;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

	@Bean
	@ConfigurationProperties(prefix = "jasypt.encryptor")
	SimpleStringPBEConfig simpleStringPBEConfig() {
		return new SimpleStringPBEConfig();
	}

	@Bean(name = "jasyptEncryptor")
	StringEncryptor stringEncryptor(SimpleStringPBEConfig simpleStringPBEConfig) {
		PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
		pooledPBEStringEncryptor.setConfig(simpleStringPBEConfig);
		return pooledPBEStringEncryptor;
	}

}
