package com.tyss.springbootproduct.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_details")
public class ProductInfo {

	@Column
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Column 
	private String description; 
	
	@Column 
	private String imageUrl;
	
	
}
