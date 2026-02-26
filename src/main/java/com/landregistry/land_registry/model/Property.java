package com.landregistry.land_registry.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "properties")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    private String id;

    private String title;
    private String location;
    private double area;
    private double price;

    private String imageUrl;

    private String ownerEmail;

    private PropertyStatus status;
}
