package com.adsandboards.web.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JacksonObjectMapper extends ObjectMapper {

	public JacksonObjectMapper() {
		configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}
}