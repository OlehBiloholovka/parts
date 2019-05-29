package com.example.parts.service;

import com.example.parts.domain.Part;

import java.util.List;

public interface PartService {
    List<Part> getAllParts();
    Part savePart(Part part);
    void deletePart(Long partId);
    Integer getComputers();
}
