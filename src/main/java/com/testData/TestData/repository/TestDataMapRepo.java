package com.testData.TestData.repository;

import com.testData.TestData.model.Property;
import com.testData.TestData.model.TestDataMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestDataMapRepo extends JpaRepository<TestDataMap,Long>{
}
