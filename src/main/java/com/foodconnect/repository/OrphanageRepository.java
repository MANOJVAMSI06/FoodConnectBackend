package com.foodconnect.repository;

import com.foodconnect.entity.Orphanage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrphanageRepository extends JpaRepository<Orphanage, Long> {
    List<Orphanage> findByVillageContainingIgnoreCase(String village);
}
