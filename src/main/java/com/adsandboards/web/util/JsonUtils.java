package com.adsandboards.web.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public final class JsonUtils {

	private JsonUtils() {
	}

	public static String toJson(Object value) throws JsonGenerationException,
			JsonMappingException, IOException {
		JacksonObjectMapper mapper = new JacksonObjectMapper();
		return mapper.writeValueAsString(value);
	}

}