package com.bike.shop.service;
import com.bike.shop.model.PartsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient("supply")
public interface PartsFeign {
    @RequestMapping("/pecas/listar")
    List<PartsModel> listParts();
}