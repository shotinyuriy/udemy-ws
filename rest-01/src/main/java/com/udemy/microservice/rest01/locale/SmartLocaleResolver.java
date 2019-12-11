package com.udemy.microservice.rest01.locale;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class SmartLocaleResolver extends AcceptHeaderLocaleResolver {
	
	private final Logger LOGGER = LoggerFactory.getLogger(SmartLocaleResolver.class); 
	
	final List<Locale> LOCALES = Arrays.asList(
			new Locale("en"),
			new Locale("es"),
			new Locale("fr"),
			new Locale("es", "MX"),
			new Locale("zh"),
			new Locale("ja")
	);
	
	public SmartLocaleResolver() {
		super();
	}

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		LOGGER.info("START resolveLocale");
		String acceptLanguage = request.getHeader("Accept-Language");
		LOGGER.info("acceptLanguage="+acceptLanguage);
		Locale defaultLocale = this.getDefaultLocale();
		if (defaultLocale != null && StringUtils.isEmpty(acceptLanguage)) {
			LOGGER.info("END resolveLocale");
			return this.getDefaultLocale();
		}

		List<Locale.LanguageRange> languageRange = Locale.LanguageRange.parse(acceptLanguage);
		Locale foundLocale = Locale.lookup(languageRange, LOCALES);
		LOGGER.info("END resolveLocale");
		return foundLocale;
	}
}
