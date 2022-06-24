package com.easybroker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybroker.constants.Constants;
import com.easybroker.services.BrokerBetaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(Constants.PATH_REQUEST)
public class BrokerBetaController {
	
	private BrokerBetaService brokerBetaService;
	
	@GetMapping(value = Constants.GET_PROPERTIES, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getProperties() {
		return brokerBetaService.getProperties();
	}
}
