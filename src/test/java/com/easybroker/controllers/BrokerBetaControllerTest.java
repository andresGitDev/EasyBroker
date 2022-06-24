package com.easybroker.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.easybroker.constants.Constants;
import com.easybroker.services.BrokerBetaService;

/**
 * Tests for {@link BrokerBetaController}
 *
 * @author  ngonzalez
 */

@SpringBootTest
@AutoConfigureMockMvc
public class BrokerBetaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
	private BrokerBetaService brokerBetaService;

	@Test
	public void getPropertiesAndReturnOK() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(Constants.PATH_REQUEST.concat(Constants.GET_PROPERTIES))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
	}

	@Test
	public void getPropertiesAndReturnMethodNotAllowed() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(Constants.PATH_REQUEST.concat(Constants.GET_PROPERTIES))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isMethodNotAllowed());
	}
}
