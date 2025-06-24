package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet {
	private String name;		// 행성 이름
	private double distance;	// 태양으로부터의 거리(단위 : 억 km)
	private boolean habitable;	// 거주 가능 여부
}
