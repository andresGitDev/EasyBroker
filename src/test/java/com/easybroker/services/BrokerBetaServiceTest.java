package com.easybroker.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Tests for {@link BrokerBetaService}
 *
 * @author ngonzalez
 */

@SpringBootTest
public class BrokerBetaServiceTest {

    @Autowired
    private BrokerBetaService brokerBetaService;

    @Test
    public void getProperties() {
    	ResponseEntity<List<String>> response = brokerBetaService.getProperties();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().isEmpty()).isEqualTo(Boolean.FALSE);
    }
    
    @Test
    public void getPropertiesAndReturnBadRequest() {
    	ReflectionTestUtils.setField(brokerBetaService, "API_URL", new String());
    	ResponseEntity<List<String>> response = brokerBetaService.getProperties();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody().isEmpty()).isEqualTo(Boolean.FALSE);
    }
    
    @Test
    public void getPropertiesAndReturnUnauthorized() {
    	ReflectionTestUtils.setField(brokerBetaService, "API_KEY", new String());
    	ResponseEntity<List<String>> response = brokerBetaService.getProperties();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(response.getBody().isEmpty()).isEqualTo(Boolean.FALSE);
    }


    
}
