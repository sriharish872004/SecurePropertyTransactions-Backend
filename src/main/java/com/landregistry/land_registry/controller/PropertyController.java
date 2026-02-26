package com.landregistry.land_registry.controller;

import com.landregistry.land_registry.dto.AddPropertyRequest;
import com.landregistry.land_registry.model.Property;
import com.landregistry.land_registry.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    public String addProperty(
            @RequestParam String title,
            @RequestParam String location,
            @RequestParam Double price,
            @RequestParam Double area,
            @RequestParam MultipartFile image,
            Authentication authentication
    ) {
        String ownerEmail = authentication.getName();

        propertyService.addProperty(
                title,
                location,
                price,
                area,
                image,
                ownerEmail
        );

        return "Property added successfully";
    }

    @GetMapping("/available")
    public List<Property> getAvailableProperties() {
        return propertyService.getAvailableProperties();
    }
}
