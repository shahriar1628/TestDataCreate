package com.testData.TestData;

import com.testData.TestData.model.*;
import com.testData.TestData.repository.PreqExecutionHistoryRepo;
import com.testData.TestData.repository.PrequisiteDataRepo;
import com.testData.TestData.repository.PropertyRepo;
import com.testData.TestData.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataApplicationTests {

	@Autowired
	private PropertyService propertyService;
	@Autowired
	private LeaseService leaseService;
	@Autowired
	private SpaceService spaceService;
	@Autowired
	private RprService rprService;
	@Autowired
	private PreqDataService preqDataService ;
	@Autowired
	private TestDataMapService testDataMapService ;
	@Autowired
	private PreqExecutionHistoryService preqExecutionHistoryService ;

	@Test
	public void contextLoads() {

	}

	@Test
	public void checkingTestData() {
		Property property = new Property();
		property.setPropertyCode("test");
		property.setPropertyNmae("test");
		propertyService.createOrUpdateProperty(property);
		assert(propertyService.getPropertyByPropertyCode("test").getPropertyCode().equals("test"));

		Lease lease =  new Lease() ;
		lease.setLeaseNmae("test");
		lease.setLeaseCode("test");
		leaseService.createOrUpdateLease(lease);
		assert(leaseService.getLeaseByLeaseCode("test").getLeaseCode().equals("test"));

		Space space =  new Space() ;
		space.setSpaceName("test");
		spaceService.createOrUpdateSpace(space);
		assert(spaceService.getSpaceBySpaceName("test").getSpaceName().equals("test"));

		Rpr rpr =  new Rpr() ;
		rpr.setSpaceName("test");
		rprService.createOrUpdateRpr(rpr);
		assert(rprService.getRpr((long) 1).getSpaceName().equals("test"));
	}

	@Test
	public void checkingConditionData() {

		TestDataMap testDataMap = new TestDataMap() ;
		testDataMap.setPreqId(1);
		testDataMap.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap);
		assert(testDataMapService.getTestDataMap((long) 1).getTestCaseId().equals("1010123"));

		PrequisiteData prequisiteData = new PrequisiteData() ;
		prequisiteData.setDataId((long) 12) ;
		prequisiteData.setType("property");
		preqDataService.createOrUpdatePrequisiteData(prequisiteData);
		assert(preqDataService.getPrequisiteData((long) 1).getType().equals("property"));

		PreqExecutionHistory preqExecutionHistory =  new PreqExecutionHistory() ;
		preqExecutionHistory.setEnvironment("qa2");
		preqExecutionHistory.setClientId("10101");
		preqExecutionHistory.setCreationTime(LocalDateTime.now());
		preqExecutionHistory.setPassed(false);
		preqExecutionHistory.setPreqId(10101);
		preqExecutionHistoryService.createOrUpdatePreqExecutionHistory(preqExecutionHistory);
		assert(preqExecutionHistoryService.getPreqExecutionHistory((long) 1).getClientId().equals("10101"));

		

	}






}
