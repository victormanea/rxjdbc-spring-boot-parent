package com.vma.rxjdbc.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="spring.datasource.rxjdbc")
public class RxJdbcProperties {

	private String url;

	private String username;

	private String password;

	private int maxIdleTimeout;

	private String databaseType;

	private int idleTimeoutBeforeHealthCheck;

	private int connectionRetryInterval;

	private int maxPoolSize;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxIdleTimeout() {
		return maxIdleTimeout;
	}

	public void setMaxIdleTimeout(int maxIdleTimeout) {
		this.maxIdleTimeout = maxIdleTimeout;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public int getIdleTimeoutBeforeHealthCheck() {
		return idleTimeoutBeforeHealthCheck;
	}

	public void setIdleTimeoutBeforeHealthCheck(int idleTimeoutBeforeHealthCheck) {
		this.idleTimeoutBeforeHealthCheck = idleTimeoutBeforeHealthCheck;
	}

	public int getConnectionRetryInterval() {
		return connectionRetryInterval;
	}

	public void setConnectionRetryInterval(int connectionRetryInterval) {
		this.connectionRetryInterval = connectionRetryInterval;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	@Override
	public String toString() {
		return "RxJdbcProperties [url=" + url + ", username=" + username + ", password=" + password
				+ ", maxIdleTimeout=" + maxIdleTimeout + ", databaseType=" + databaseType
				+ ", idleTimeoutBeforeHealthCheck=" + idleTimeoutBeforeHealthCheck + ", connectionRetryInterval="
				+ connectionRetryInterval + ", maxPoolSize=" + maxPoolSize + "]";
	}
	
}
