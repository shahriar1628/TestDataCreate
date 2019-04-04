package com.testData.TestData.repository;

import com.testData.TestData.model.Property;
import com.testData.TestData.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpaceRepo extends JpaRepository<Space,Long>{
     Optional<Space> findOneBySpaceName(String spaceName);
}
