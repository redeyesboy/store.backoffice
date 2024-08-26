package co.kr.store.bo.core.config.database;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Primary @Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Primary @Bean
	DataSource dataSource(HikariConfig hikariConfig) {
		return new HikariDataSource(hikariConfig);
	}

	@Primary @Bean
	PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		dataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(false);
		return dataSourceTransactionManager;
	}

}
