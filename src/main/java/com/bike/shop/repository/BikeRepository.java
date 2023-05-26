package com.bike.shop.repository;

import com.bike.shop.model.BikeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<BikeModel,Long> {
}
