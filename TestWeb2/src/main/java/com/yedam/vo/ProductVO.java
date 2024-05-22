package com.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode, price;
	private String productName;
	private String addDate;
	private String mainCategory;
	private String subCategory;
	private String productImg;
}
