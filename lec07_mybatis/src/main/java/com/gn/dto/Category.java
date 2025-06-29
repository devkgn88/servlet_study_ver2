package com.gn.dto;

import lombok.Data;

@Data
public class Category {
    private int code;      // category_code 컬럼과 매핑
    private String name;   // category_name 컬럼과 매핑
    private String desc;   // category_desc 컬럼과 매핑
}
