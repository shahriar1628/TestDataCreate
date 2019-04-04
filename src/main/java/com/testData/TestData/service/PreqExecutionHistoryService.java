package com.testData.TestData.service;

import com.testData.TestData.model.PreqExecutionHistory;
import com.testData.TestData.model.Property;
import com.testData.TestData.repository.PreqExecutionHistoryRepo;
import com.testData.TestData.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreqExecutionHistoryService {

    @Autowired
    private PreqExecutionHistoryRepo preqExecutionHistoryRepo ;

    public void createOrUpdatePreqExecutionHistory(PreqExecutionHistory preqExecutionHistory) {
        preqExecutionHistoryRepo.save(preqExecutionHistory) ;
    }

    public PreqExecutionHistory getPreqExecutionHistory(Long id) {
       return preqExecutionHistoryRepo.findById(id).orElse(null);
    }


}
