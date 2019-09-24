package com.liu.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Emp {
    private Integer age;
    private String sex;
    private BigDecimal salary;
    private Integer empId;
    private Integer deptId;
    private String name;

    private Dept dept;


}
