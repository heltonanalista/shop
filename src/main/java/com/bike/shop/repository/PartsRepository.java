package com.bike.shop.repository;

import com.bike.shop.model.PartsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends JpaRepository<PartsModel,Long> {
}
