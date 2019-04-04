package com.testData.TestData.service;

import com.testData.TestData.model.Property;
import com.testData.TestData.model.TestDataMap;
import com.testData.TestData.repository.PropertyRepo;
import com.testData.TestData.repository.TestDataMapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataMapService {

    @Autowired
    private TestDataMapRepo testDataMapRepo ;

    public void createOrUpdateTestDataMap(TestDataMap testDataMap) {
        testDataMapRepo.save(testDataMap) ;
    }

    public TestDataMap getTestDataMap(Long id) {
        return testDataMapRepo.findById(id).orElse(null) ;
    }



}
