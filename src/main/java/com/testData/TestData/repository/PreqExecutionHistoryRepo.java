package com.testData.TestData.repository;

import com.testData.TestData.model.PreqExecutionHistory;
import com.testData.TestData.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreqExecutionHistoryRepo extends JpaRepository<PreqExecutionHistory,Long>{
}
