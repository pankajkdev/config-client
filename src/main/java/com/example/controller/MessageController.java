package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feature.MyFeature;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RefreshScope
public class MessageController {

	@Value("${testProp:Some default value}")
	private String message;

	@RequestMapping("/message")
	public String getMessage() {
		return message;
	}
	
	@RequestMapping("/featureState")
	public Map<String, Boolean> getFeatureState() {
		Map<String, Boolean> featureState = new HashMap<>();
		featureState.put(MyFeature.FEATURE_ONE.name(), MyFeature.FEATURE_ONE.isActive());
		featureState.put(MyFeature.FEATURE_TWO.name(), MyFeature.FEATURE_TWO.isActive());
		
		featureState.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
		return featureState;
	}
	
}
