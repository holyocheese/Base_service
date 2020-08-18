package com.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "path")
public class FileStorageProperties {
	
    private String appPath;
    
    private String firmwarePath;

	public String getAppPath() {
		return appPath;
	}

	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}

	public String getFirmwarePath() {
		return firmwarePath;
	}

	public void setFirmwarePath(String firmwarePath) {
		this.firmwarePath = firmwarePath;
	}

    
}
