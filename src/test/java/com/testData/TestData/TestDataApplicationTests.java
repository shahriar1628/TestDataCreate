package com.testData.TestData;

import com.testData.TestData.model.*;
import com.testData.TestData.repository.PreqExecutionHistoryRepo;
import com.testData.TestData.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Priority;
import java.time.LocalDateTime;
import java.util.List;

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
	@Autowired
	private PreqExecutionHistoryRepo preqExecutionHistoryRepo ;

	@Test
	public void contextLoads() {

	}

	@Test
	public void checkingTestData() {
		Property property = new Property();
		property.setPropertyCode("test");
		property.setPropertyNmae("test");
		propertyService.createOrUpdateProperty(property);
		property.setPropertyNmae("test2");
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
		rpr.setChargeType("test");
		rprService.createOrUpdateRpr(rpr);
		assert(rprService.getRpr((long) 1).getSpaceName().equals("test"));


		Property property2 = new Property();
		property2.setPropertyCode("test3");
		property2.setPropertyNmae("test3");
		propertyService.createOrUpdateProperty(property2);
	}

	@Test
	public void checkingConditionData() {

		TestDataMap testDataMap = new TestDataMap() ;
		testDataMap.setPreqId(1);
		testDataMap.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap);

		TestDataMap testDataMap2 = new TestDataMap() ;
		testDataMap2.setPreqId(2);
		testDataMap2.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap2);

		TestDataMap testDataMap3 = new TestDataMap() ;
		testDataMap3.setPreqId(3);
		testDataMap3.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap3);

		TestDataMap testDataMap4 = new TestDataMap() ;
		testDataMap4.setPreqId(4);
		testDataMap4.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap4);


		TestDataMap testDataMap5 = new TestDataMap() ;
		testDataMap5.setPreqId(5);
		testDataMap5.setTestCaseId("1010123");
		testDataMapService.createOrUpdateTestDataMap(testDataMap5);

		TestDataMap testDataMap6 = new TestDataMap() ;
		testDataMap6.setPreqId(1);
		testDataMap6.setTestCaseId("1010124");
		testDataMapService.createOrUpdateTestDataMap(testDataMap6);



		 List<Property> records =  testDataMapService.getPropertyRecordsByTcId("1010123") ;
		 assert(records.get(0).getPropertyCode().equals("test"));
		assert(records.get(1).getPropertyCode().equals("test3"));
		List<Lease> leases =  testDataMapService.getLeaseRecordsByTcId("1010123") ;
		assert(leases.get(0).getLeaseCode().equals("test"));
		List<Space> spaces =  testDataMapService.getSpaceRecordsByTcId("1010123") ;
		assert(spaces.get(0).getSpaceName().equals("test"));
		List<Rpr> rprs =  testDataMapService.getRprRecordsByTcId("1010123") ;
		assert(rprs.get(0).getSpaceName().equals("test"));

		 records =  testDataMapService.getPropertyRecordsByTcId("1010124") ;
		assert(records.get(0).getPropertyCode().equals("test"));






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

		PreqExecutionHistory preqExecutionHistory2 =  new PreqExecutionHistory() ;
		preqExecutionHistory2.setEnvironment("qa2");
		preqExecutionHistory2.setClientId("10101");
		preqExecutionHistory2.setCreationTime(LocalDateTime.now().plusDays(1));
		preqExecutionHistory2.setPassed(true);
		preqExecutionHistory2.setPreqId(10101);

		preqExecutionHistoryService.createOrUpdatePreqExecutionHistory(preqExecutionHistory);
		preqExecutionHistoryService.createOrUpdatePreqExecutionHistory(preqExecutionHistory2);


		assert(preqExecutionHistoryService.getPreqExecutionHistory(10101,"10101","qa2").isPassed());
		testPreqExecutionHistory();

	}



	public void testPreqExecutionHistory() {


		NotExecutedPreqData notExecutedPreqData =  testDataMapService.getNotExecutedPreqData("1010123","100010","uat",100);
		assert (!notExecutedPreqData.isAnyPreqFailed()) ;
		assert (notExecutedPreqData.getPropertyList().size()==2);
		assert (notExecutedPreqData.getLeaseList().size()==1);
		assert (notExecutedPreqData.getSpaceList().size()==1);
		assert (notExecutedPreqData.getRprList().size()==1);

		notExecutedPreqData =  testDataMapService.getNotExecutedPreqData("10101222","100010","uat",100);
		assert (!notExecutedPreqData.isAnyPreqFailed()) ;
		assert (notExecutedPreqData.getPropertyList().size()==0);
		assert (notExecutedPreqData.getLeaseList().size()==0);
		assert (notExecutedPreqData.getSpaceList().size()==0);
		assert (notExecutedPreqData.getRprList().size()==0);


		PreqExecutionHistory preqExecutionHistory2 =  new PreqExecutionHistory() ;
		preqExecutionHistory2.setEnvironment("uat");
		preqExecutionHistory2.setClientId("100010");
		preqExecutionHistory2.setCreationTime(LocalDateTime.now().minusDays(3));
		preqExecutionHistory2.setPassed(false);
		preqExecutionHistory2.setPreqId(1);

		preqExecutionHistoryService.createOrUpdatePreqExecutionHistory(preqExecutionHistory2);

		assert(!preqExecutionHistoryService.getPreqExecutionHistory(1,"100010","uat").isPassed());

		 notExecutedPreqData =  testDataMapService.getNotExecutedPreqData("1010123","100010","uat",1);
		assert (!notExecutedPreqData.isAnyPreqFailed()) ;
		assert (notExecutedPreqData.getPropertyList().size()==2);
		assert (notExecutedPreqData.getLeaseList().size()==1);
		assert (notExecutedPreqData.getSpaceList().size()==1);
		assert (notExecutedPreqData.getRprList().size()==1);
	}


}
