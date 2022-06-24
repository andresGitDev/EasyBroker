package com.easybroker.models;

import lombok.Data;

/**
 * 
 * @author  ngonzalez
 */

@Data
public class Content {
	private String agent;
	private String public_id;
	private String title;
	private String title_image_full;
	private String title_image_thumb;
	private Integer bedrooms;
	private Integer bathrooms;
	private Integer parking_spaces;
	private String location;
	private String property_type;
	private Object operations;
	private String updated_at;
	private Boolean show_prices;
}
