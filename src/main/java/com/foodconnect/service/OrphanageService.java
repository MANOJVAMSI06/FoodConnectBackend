package com.foodconnect.service;

import com.foodconnect.entity.Orphanage;
import com.foodconnect.repository.OrphanageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrphanageService {

    @Autowired
    private OrphanageRepository orphanageRepository;

    public List<Orphanage> getOrphanagesByVillage(String village) {
        return orphanageRepository.findByVillageContainingIgnoreCase(village);
    }

    public Orphanage saveOrphanage(Orphanage orphanage) {
        return orphanageRepository.save(orphanage);
    }

    public List<Orphanage> getAllOrphanages() {
        return orphanageRepository.findAll();
    }
}
