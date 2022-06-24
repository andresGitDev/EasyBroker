package com.easybroker.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.easybroker.models.Content;
import com.easybroker.models.ResponseBetaBroker;

import lombok.extern.java.Log;

@Log
@Service
public class BrokerBetaService {

	@Value("${api.url}")
	private String API_URL;

	@Value("${api.key}")
	private String API_KEY;

	@Autowired 
	private RestTemplate restTemplate;

	  
	@SuppressWarnings("static-access")
	public ResponseEntity<List<String>> getProperties() {
		HttpHeaders headers = authenticateAndBuildHttpHeaders();
		try {
			ResponseEntity<ResponseBetaBroker> responseBetaBroker = 
					restTemplate.exchange(
						API_URL, 
						HttpMethod.GET, 
						new HttpEntity<>(headers),
						ResponseBetaBroker.class);
			List<String> titles = responseBetaBroker.getBody().getContent().stream()
					.map(Content::getTitle)
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.toList());
			log.info(titles.stream().collect(Collectors.joining(",")));
			return new ResponseEntity<List<String>>(HttpStatus.OK)
					.of(Optional.ofNullable(titles));
		}
		catch (IllegalArgumentException e) {
			log.severe(e.getMessage());
			return new ResponseEntity<List<String>>(
					Stream.of(e.getMessage()).collect(Collectors.toList()),
					HttpStatus.BAD_REQUEST);
		}
		catch (RestClientException e) {
			log.severe(e.getMessage());
			return new ResponseEntity<List<String>>(
					Stream.of(e.getMessage()).collect(Collectors.toList()),
					HttpStatus.UNAUTHORIZED);
		}
	}

	private HttpHeaders authenticateAndBuildHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-Authorization", API_KEY);
		httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		return httpHeaders;
	}

}
