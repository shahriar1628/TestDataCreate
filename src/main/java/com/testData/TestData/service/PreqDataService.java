package com.testData.TestData.service;

import com.testData.TestData.model.PrequisiteData;
import com.testData.TestData.model.Property;
import com.testData.TestData.repository.PrequisiteDataRepo;
import com.testData.TestData.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreqDataService {

    @Autowired
    private PrequisiteDataRepo prequisiteDataRepo;

    public void createOrUpdatePrequisiteData(PrequisiteData prequisiteData) {
        prequisiteDataRepo.save(prequisiteData) ;
    }


    public PrequisiteData getPrequisiteData(Long id) {
        return prequisiteDataRepo.findById(id).orElse(null) ;
    }


}
