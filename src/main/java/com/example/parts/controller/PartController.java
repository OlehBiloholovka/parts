package com.example.parts.controller;

import com.example.parts.domain.Part;
import com.example.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
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
    public void deletePart(@RequestBody Part part) {
        partService.deletePart(part);
    }
}
