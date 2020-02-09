package com.tyss.productrestapi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_info")
public class ProductInfoBean {

	@Id
	@GeneratedValue
	@Column
	private int id;

	@Column
	private String productName;

	@Column
	private double price;

	@Column
	private int quantity;

	@Column
	private String description;

	@Column
	private String imageUrl;

}
