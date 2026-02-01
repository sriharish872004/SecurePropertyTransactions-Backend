package com.landregistry.land_registry.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    @Indexed(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private Role role; // ADMIN or OWNER

    private boolean enabled = true;
}

