package com.example.parts.repository;

import com.example.parts.domain.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Long> {
}
