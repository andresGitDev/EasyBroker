package com.easybroker.models;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author  ngonzalez
 */

@Data
public class Pagination {
	private Integer limit;
	private Integer page;
	private Integer total;
	private Optional<String> next_page;
}
