package com.bike.shop.repository;

import com.bike.shop.model.MaintenanceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceOrderRepository extends JpaRepository <MaintenanceOrder,Long> {
}
