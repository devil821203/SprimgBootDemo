package org.example.demo.configuration;

import lombok.Data;

@Data
public class ConnectionInfo {
    private String driverClassName;
    private String jdbcUrl;
    private String url;
    private String username;
    private String pazzword;
    private Integer maximumPoolSize;

}
