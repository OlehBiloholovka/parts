package com.example.parts.repository;

import com.example.parts.domain.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Long> {
    @Query(value = "SELECT MIN(part.quantity) from part where part.needed = TRUE", nativeQuery = true)
    Integer getComputers();
}
