package com.landregistry.land_registry.dto;

import lombok.Data;

@Data
public class AddPropertyRequest {

    private String title;
    private String location;
    private double area;
    private double price;
}
