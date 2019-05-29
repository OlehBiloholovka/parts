package com.example.parts.serviceImpl;

import com.example.parts.domain.Part;
import com.example.parts.repository.PartRepository;
import com.example.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }

    @Override
    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void deletePart(Long partId) {
        Optional<Part> byId = partRepository.findById(partId);
        byId.ifPresent(partRepository::delete);
    }

    @Override
    public Integer getComputers() {
        return partRepository.getComputers();
    }
}
