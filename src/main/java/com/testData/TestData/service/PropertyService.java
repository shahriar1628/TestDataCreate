package com.testData.TestData.service;

import com.testData.TestData.model.Property;
import com.testData.TestData.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    public void createOrUpdateProperty(Property property) {
        propertyRepo.save(property) ;
    }

    public Property getPropertyByPropertyCode(String code) {
       return  propertyRepo.findOneByPropertyCode(code).orElse(null);
    }

    public Property getProperty(Long id) {
        return propertyRepo.findById(id).orElse(null) ;
    }
}
