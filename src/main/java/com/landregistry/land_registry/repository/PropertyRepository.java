package com.landregistry.land_registry.repository;

import com.landregistry.land_registry.model.Property;
import com.landregistry.land_registry.model.PropertyStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PropertyRepository extends MongoRepository<Property, String> {

    List<Property> findByStatus(PropertyStatus status);

    List<Property> findByOwnerEmail(String ownerEmail);
}
