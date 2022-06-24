package com.easybroker.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author  ngonzalez
 */

@Data
public class ResponseBetaBroker {
	private Pagination pagination;
	private List<Content> content;
}
