package com.foodconnect.controller;

import com.foodconnect.entity.Orphanage;
import com.foodconnect.service.OrphanageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orphanages")
@CrossOrigin(origins = "*")
public class OrphanageController {

    private final OrphanageService service;

    public OrphanageController(OrphanageService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Orphanage> searchOrphanages(@RequestParam(name = "village") String village) {
        return service.getOrphanagesByVillage(village);
    }

    @PostMapping("/add")
    public Orphanage addOrphanage(@RequestBody Orphanage orphanage) {
        return service.saveOrphanage(orphanage);
    }

    @GetMapping("/all")
    public List<Orphanage> getAll() {
        return service.getAllOrphanages();
    }
}
