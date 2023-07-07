package com.bike.shop.service;




import com.bike.shop.model.PartsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "pecas",url = "localhost:8081/pecas/listar")
public interface PartsFeign {
    @GetMapping
    List<PartsModel> listParts();

}