package com.micro.accounts.DTO;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
public record accountContactInfo(String message, Map<String,String>contactDetails,String onCallSupport) {

}
