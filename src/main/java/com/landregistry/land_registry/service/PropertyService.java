package com.landregistry.land_registry.service;

import com.landregistry.land_registry.dto.AddPropertyRequest;
import com.landregistry.land_registry.model.Property;
import com.landregistry.land_registry.model.PropertyStatus;
import com.landregistry.land_registry.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    private static final String DEFAULT_IMAGE =
            "https://images.unsplash.com/photo-1568605114967-8130f3a36994";

    public void addProperty(
            String title,
            String location,
            Double price,
            Double area,
            MultipartFile image,
            String ownerEmail
    ) {
        try {

            String uploadDir = "uploads/";
            File directory = new File(uploadDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            Files.copy(image.getInputStream(), filePath);

            Property property = Property.builder()
                    .title(title)
                    .location(location)
                    .price(price)
                    .area(area)
                    .ownerEmail(ownerEmail)
                    .imageUrl("/uploads/" + fileName)
                    .build();

            propertyRepository.save(property);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed");
        }
    }

    public List<Property> getAvailableProperties() {
        return propertyRepository.findByStatus(PropertyStatus.AVAILABLE);
    }
}
