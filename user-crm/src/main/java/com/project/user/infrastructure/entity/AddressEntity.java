package com.project.user.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address_entity")
public class AddressEntity {

    @Id
    private String id;
    private String userId;
    private String street;
    private Long number;
    private String neighborhood;
    private String complement;
    private String city;
    private String zipcode;
}
