package com.testData.TestData.service;

import com.testData.TestData.model.Property;
import com.testData.TestData.model.Rpr;
import com.testData.TestData.repository.PropertyRepo;
import com.testData.TestData.repository.RprRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RprService {

    @Autowired
    private RprRepo rprRepo ;
    @Autowired
    private PreqDataService preqDataService ;

    public void createOrUpdateRpr(Rpr rpr) {
        boolean isNew = rpr.getId() ==0 ? true : false ;
        rprRepo.save(rpr) ;
        if(isNew)
            preqDataService.createPrequisiteData("rpr",rpr.getId());
    }

    public Rpr getRpr(Long id) {
        return rprRepo.findById(id).orElse(null) ;
    }

}
