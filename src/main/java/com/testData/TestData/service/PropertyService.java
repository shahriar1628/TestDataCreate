package com.testData.TestData.service;

import com.testData.TestData.model.PrequisiteData;
import com.testData.TestData.model.Property;
import com.testData.TestData.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private PreqDataService preqDataService ;

    public void createOrUpdateProperty(Property property) {
        boolean isNew = property.getId() == 0 ? true : false   ;
        propertyRepo.save(property) ;
        if(isNew)
            preqDataService.createPrequisiteData("property",property.getId());

    }

    public Property getPropertyByPropertyCode(String code) {
       return  propertyRepo.findOneByPropertyCode(code).orElse(null);
    }

    public Property getProperty(Long id) {
        return propertyRepo.findById(id).orElse(null) ;
    }
}
