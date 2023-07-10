package com.bike.shop.repository;

import com.bike.shop.model.BikeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeOrderRepository extends JpaRepository<BikeOrder,Long> {
}
