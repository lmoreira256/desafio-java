package com.evoluum.desafio.gateway;

import org.springframework.web.client.RestTemplate;

public class RequestResource {

	public static String request(String url) {
		try {
			RestTemplate restTemplate = new RestTemplate();

			return restTemplate.getForObject(url, String.class);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
