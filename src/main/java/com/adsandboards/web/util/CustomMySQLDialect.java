package com.adsandboards.web.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class CustomMySQLDialect extends MySQL5InnoDBDialect {

	public CustomMySQLDialect() {
		super();
		registerFunction("date_add_interval", new SQLFunctionTemplate(StandardBasicTypes.DATE, "date_add(?1, INTERVAL ?2 ?3)"));
	}

}