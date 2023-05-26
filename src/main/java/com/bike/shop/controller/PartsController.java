package com.bike.shop.controller;



import com.bike.shop.PartsFeign;
import com.bike.shop.model.PartsModel;
import com.bike.shop.service.PartsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("pecas")
public class PartsController {
    @Autowired
    public PartsFeign partsFeign;
    @Autowired
    public PartsService partsService;
    List<PartsModel> pecaModel;

    @GetMapping()
    public List<PartsModel> listParts() {


        pecaModel = partsFeign.listParts();


        return pecaModel;

    }
}

