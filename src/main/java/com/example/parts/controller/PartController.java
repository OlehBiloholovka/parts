package com.example.parts.controller;

import com.example.parts.domain.Part;
import com.example.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/parts")
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @PostMapping("/parts")
    public Part addPart(@RequestBody Part part) {
        return partService.savePart(part);
    }

    @PostMapping("/parts/delete")
    public void deletePart(@RequestBody Long partId) {
        partService.deletePart(partId);
    }

    @GetMapping("/parts/computers")
    public Integer getComputers() {
        return partService.getComputers();
    }
}
