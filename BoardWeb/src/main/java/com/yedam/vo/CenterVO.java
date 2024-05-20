package com.yedam.vo;

import lombok.Data;

@Data
public class CenterVO {
	private int id;
	private String centerName, sido, 
				   address, centerType, 
				   createdAt, facilityName,
				   lat, lng,org,
				   phoneNumber, sigungu,
				   updatedAt, zipCode;
}
