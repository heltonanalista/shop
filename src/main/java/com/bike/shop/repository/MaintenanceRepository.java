package com.bike.shop.repository;

import com.bike.shop.model.MaintenanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceModel,Long> {
}
