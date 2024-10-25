package com.project.user.infrastructure.repository;

import com.project.user.infrastructure.entity.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
}
