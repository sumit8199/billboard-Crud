package com.example.billboard.service;

import com.example.billboard.entity.Billboard;
import com.example.billboard.repository.BillboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardService {

    private final BillboardRepository repository;

    public BillboardService(BillboardRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Billboard create(Billboard billboard) {
        return repository.save(billboard);
    }

    // READ ALL
    public List<Billboard> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Billboard getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billboard not found with id: " + id));
    }

    // UPDATE
    public Billboard update(Long id, Billboard updated) {
        Billboard existing = getById(id);

        existing.setTitle(updated.getTitle());
        existing.setLocation(updated.getLocation());
        existing.setPrice(updated.getPrice());
        existing.setActive(updated.getActive());
        existing.setType(updated.getType());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Billboard not found with id: " + id);
        }
        repository.deleteById(id);
    }
}