package com.testData.TestData.service;

import com.testData.TestData.model.Lease;
import com.testData.TestData.model.Property;
import com.testData.TestData.repository.LeaseRepo;
import com.testData.TestData.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    @Autowired
    private LeaseRepo leaseRepo;

    public void createOrUpdateLease(Lease lease) {
        leaseRepo.save(lease) ;
    }

    public Lease getLeaseByLeaseCode(String code) {
       return   leaseRepo.findOneByLeaseCode(code).orElse(null);
    }

    public Lease getLease(Long id) {
        return leaseRepo.findById(id).orElse(null) ;
    }


}
