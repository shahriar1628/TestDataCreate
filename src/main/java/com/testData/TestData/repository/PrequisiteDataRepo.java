package com.testData.TestData.repository;

import com.testData.TestData.model.PrequisiteData;
import com.testData.TestData.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrequisiteDataRepo extends JpaRepository<PrequisiteData,Long>{
}
