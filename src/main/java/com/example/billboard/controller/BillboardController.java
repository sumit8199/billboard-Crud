package com.example.billboard.controller;

import com.example.billboard.entity.Billboard;
import com.example.billboard.service.BillboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billboards")
public class BillboardController {

    private final BillboardService service;

    public BillboardController(BillboardService service) {
        this.service = service;
    }

    @PostMapping
    public Billboard create(@RequestBody Billboard billboard) {
        return service.create(billboard);
    }

    @GetMapping
    public List<Billboard> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Billboard getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Billboard update(@PathVariable Long id,
                            @RequestBody Billboard billboard) {
        return service.update(id, billboard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}