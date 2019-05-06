package com.vma.rxjdbc.autoconfigure;

import java.util.concurrent.TimeUnit;

import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.pool.DatabaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Database.class)
@EnableConfigurationProperties(RxJdbcProperties.class)
public class RxJdbcAutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(RxJdbcAutoConfiguration.class);

	@Autowired
	private RxJdbcProperties properties;

	@Bean
	@ConditionalOnMissingBean
	public Database database() {
		logger.debug("{}", properties);

		final Database db = Database.nonBlocking().url(properties.getUrl()).user(properties.getUsername())
				.password(properties.getPassword()).healthCheck(getHealthCheck(properties.getDatabaseType()))
				.maxIdleTime(properties.getMaxIdleTimeout(), TimeUnit.MINUTES)
				.idleTimeBeforeHealthCheck(properties.getIdleTimeoutBeforeHealthCheck(), TimeUnit.SECONDS)
				.connectionRetryInterval(properties.getConnectionRetryInterval(), TimeUnit.SECONDS)
				.maxPoolSize(properties.getMaxIdleTimeout()).build();
		logger.info("RxJdbc database instance successfully created.");

		return db;
	}

	private DatabaseType getHealthCheck(String name) {
		DatabaseType result;
		
		switch (name.toLowerCase()) {
		case "oracle":
			result = DatabaseType.ORACLE;
			break;
		case "hsqldb":
			result = DatabaseType.HSQLDB;
			break;
		case "h2":
			result = DatabaseType.H2;
			break;
		case "sql_server":
			result = DatabaseType.SQL_SERVER;
			break;
		case "mysql":
			result = DatabaseType.MYSQL;
			break;
		case "postgres":
			result = DatabaseType.POSTGRES;
			break;
		case "sqlite":
			result = DatabaseType.SQLITE;
			break;
		case "db2":
			result = DatabaseType.DB2;
			break;
		case "derby":
			result = DatabaseType.DERBY;
			break;
		case "informix":
			result = DatabaseType.INFORMIX;
			break;
		default:
			result = DatabaseType.OTHER;
			break;
		}
		logger.debug("Database health check [{}]", result);

		return result;
	}
}
