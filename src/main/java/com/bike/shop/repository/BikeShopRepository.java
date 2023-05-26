package com.bike.shop.repository;

import com.bike.shop.model.BikeShopModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeShopRepository extends JpaRepository<BikeShopModel,Long> {
}
