package com.udemy.microservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeService;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean currencyExchange = responseEntity.getBody();

		CurrencyConversionBean currencyConversion = new CurrencyConversionBean(currencyExchange.getId(), from, to,
				currencyExchange.getConversionMultiple(), quantity,
				quantity.multiply(currencyExchange.getConversionMultiple()), currencyExchange.getPort());
		
		logger.info("{}", currencyConversion);

		return currencyConversion;
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean currencyExchange = currencyExchangeService.retrieveExchangeValue(from, to);

		CurrencyConversionBean currencyConversion = new CurrencyConversionBean(currencyExchange.getId(), from, to,
				currencyExchange.getConversionMultiple(), quantity,
				quantity.multiply(currencyExchange.getConversionMultiple()), currencyExchange.getPort());

		logger.info("{}", currencyConversion);
		
		return currencyConversion;
	}
}
