package com.testData.TestData.repository;

import com.testData.TestData.model.Lease;
import com.testData.TestData.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeaseRepo extends JpaRepository<Lease,Long>{
     Optional<Lease> findOneByLeaseCode(String leaseCode);
}
