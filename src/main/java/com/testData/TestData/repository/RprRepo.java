package com.testData.TestData.repository;

import com.testData.TestData.model.Property;
import com.testData.TestData.model.Rpr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RprRepo extends JpaRepository<Rpr,Long>{
}
