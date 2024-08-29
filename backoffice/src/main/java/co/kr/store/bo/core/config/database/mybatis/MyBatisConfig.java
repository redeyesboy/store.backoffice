package co.kr.store.bo.core.config.database.mybatis;

import javax.sql.DataSource;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

import co.kr.store.bo.common.Constants;
import co.kr.store.bo.core.config.database.annotation.StoreMapper;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@MapperScan(
	basePackages = Constants.BASE_PACKAGE
	, annotationClass = StoreMapper.class
	, sqlSessionTemplateRef = "sqlSessionTemplate"
)
public class MyBatisConfig {

	private final ApplicationContext applicationContext;

	@Primary @Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setCacheEnabled(false);
		configuration.setDefaultExecutorType(ExecutorType.REUSE);
		configuration.setDefaultStatementTimeout(25);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setCallSettersOnNulls(true);
		Resource[] mapperLocations = ArrayUtils.addAll(
			applicationContext.getResources("classpath:/mapper/store/**/*.xml")
		);
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfiguration(configuration);
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);
		return sqlSessionFactoryBean.getObject();
	}

	@Primary @Bean
	SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
