/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package portalrefimpl.result.viewresult;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import portalrefimpl.result.viewresult.response.TestResult;

/**
 * This class controls the caching action done for the test results
 * @author GRamamoorthy
 *
 */
public class TestResultCacheManager {

	/**
	 * static instance of this class
	 */
	private static TestResultCacheManager s_instance = null;
	
	private static int MAX_TRIES = 3;
	
	private static int MAX_WAITTIME_IN_MILLIS = 1000;
	
	/**
	 * Map holding the test result data with patient id as the key
	 */
	private Map<String, List<TestResultCache>> patientTestResultMap = new LinkedHashMap<String, List<TestResultCache>>();
	
	/**
	 * 	private constructor 
	 */
	private TestResultCacheManager(){
		// does nothing
	}
	
	/**
	 * main method to get the instance of this class
	 * @return
	 */
	public static TestResultCacheManager getInstance(){
		if(s_instance == null){
			s_instance = new TestResultCacheManager();
		}
		
		return s_instance;
	}
	
	/**
	 * This method removes a patient's data
	 * This method is very important and needs to be called
	 * from the logout code
	 * @param patientId
	 */
	public void removePatientData(String patientId){
		patientTestResultMap.remove(patientId);
	}
	
	/**
	 * This method refreshes the patient data
	 * @param patientId
	 * @param testResults
	 */
	/*public void refreshPatientData(String patientId,List<TestResultCache> testResults){
		// if patient id is 
		if(!patientTestResultMap.containsKey(patientId)){
			patientTestResultMap.put(patientId, testResults);
		}else{
			List<TestResultCache> resultList = patientTestResultMap.get(patientId);
			
		}
	}*/
	
	/**
	 * This method adds an order id to data already present for a patient
	 * This method should be called first before the test results
	 * for a patient is retrieved
	 * @param patientId
	 * @param orderId
	 */
	public void addOrderToPatient(String patientId,String orderId){
		List<TestResultCache> resultList = null;
		
		if(!patientTestResultMap.containsKey(patientId)){
			resultList = new ArrayList<TestResultCache>();
			patientTestResultMap.put(patientId, resultList);
		}else{
			resultList = patientTestResultMap.get(patientId);
			if(resultList == null){
				resultList = new ArrayList<TestResultCache>();
				patientTestResultMap.put(patientId, resultList);
			}
			/*
			if(resultList != null){
				boolean orderFound = false;
				for(TestResultCache cache : resultList){
					if(cache.getOrderId().equals(orderId)){
						
					}
				}
			}*/
		}
		
		// check if the order is already present
		// then there is no need to get the test result data
		// for this order 
		if(isOrderPresent(orderId, resultList)){
			return;
		}
		// first create a new testresultcache instance
		// and add it to the list
		TestResultCache cacheObj = new TestResultCache();
		cacheObj.setOrderId(orderId);
		
		resultList.add(cacheObj);
		// second spawn a thread to fetch the test result
		TestResultRetrieveRequest request = new TestResultRetrieveRequest();
		request.setOrderId(orderId);
		request.setPatientId(patientId);
		TestResultThread testResultThread = new TestResultThread(
				request, cacheObj);
		Thread threadInst = new Thread(testResultThread);
		threadInst.start();
		
	}
	
	/**
	 * 
	 * @param orderId
	 * @param testResultCacheList
	 * @return
	 */
	private boolean isOrderPresent(String orderId,List<TestResultCache> testResultCacheList){
		boolean orderPresent = false;
		// list can never be null - hence check whether it is empty
		if(orderId == null || orderId.trim().equals("") || testResultCacheList.isEmpty()){
			return orderPresent;
		}
		String existingOrderId = null;
		// iterate through the test result list and check
		// if any of the cache objects already have an orderid
		// same as the one given as input to this method
		for(TestResultCache resultCacheObj : testResultCacheList){
			existingOrderId = resultCacheObj.getOrderId();
			if(orderId.equalsIgnoreCase(existingOrderId)){
				orderPresent = true;
				break;
			}
		}
		
		return orderPresent;
	}
	
	
	/**
	 * This method adds the test results for an order and for a patient
	 * to the map contained in this class 
	 * @param patientId
	 * @param orderId
	 * @param testResults
	 */
	public void addTestResults(String patientId,String orderId,List<TestResult> testResults){
		// safe check - nothing can be done
		if ((patientId == null || patientId.trim().equals(""))
				|| (orderId == null || orderId.trim().equals(""))
				|| (testResults == null || testResults.isEmpty())) {
			return;
		}
		// patient id has to be found in the map
		if(patientTestResultMap.containsKey(patientId)){
			List<TestResultCache> testResultCacheList = patientTestResultMap.get(patientId);
			if(testResultCacheList != null){
				boolean orderFound = false;
				TestResultCache cacheObj = null;
				for(TestResultCache testResultCache : testResultCacheList){
					if(orderId.equals(testResultCache.getOrderId())){
						testResults = testResultCache.getTestResultList();
						cacheObj = testResultCache;
						orderFound = true;
						break;
					}
				}
				// if the order is found, then simply add the test results
				// to the cache object
				// if not, then initialize the cache object and add it to the cache
				// object list - add the cache object list to the map
				if(orderFound){
					cacheObj.setTestResultList(testResults);
				}else{
					cacheObj = new TestResultCache(orderId,testResults);
					testResultCacheList.add(cacheObj);
					patientTestResultMap.put(patientId, testResultCacheList);
				}
				
			}
		}
		
	}
	
	
	/**
	 * This method gets the test results for a patient
	 * given the patient id and the order id
	 * @param patientId
	 * @param orderId
	 * @return
	 */
	public TestResultCache getTestResultsForPatient(String patientId,String orderId){
		List<TestResult> testResults = new ArrayList<TestResult>();
		TestResultCache testResultCache = null;
		if((patientId == null || patientId.trim().equals("")) || (orderId == null || orderId.trim().equals(""))){
			return testResultCache;
		}
		// get the test results only when the map contains the patient id
		if(patientTestResultMap.containsKey(patientId)){
			List<TestResultCache> testResultCacheList = patientTestResultMap.get(patientId);
			if(testResultCacheList != null){
				boolean orderFound = false;
				//TestResultCache cacheObj = null;
				for(TestResultCache cache : testResultCacheList){
					if(orderId.equals(cache.getOrderId())){
						testResults = cache.getTestResultList();
						//cacheObj = cache;
						testResultCache = cache;
						orderFound = true;
						break;
					}
				}
				// this case has to be handled
				// case - when the test results are being retrieved and the 
				// simultaneously a request for getting the test result is fired
				if(orderFound && (testResults == null || testResults.isEmpty())){
					System.out.println("Going to wait and try to get the data once again");
					int itr = 0;
					for(;itr<MAX_TRIES;itr++){
						try {
							Thread.sleep(MAX_WAITTIME_IN_MILLIS);
						} catch (InterruptedException e) {
							// cannot do much
						}
						
						// finally get the test results from the cache object
						// if this is also null or empty then nothing can be done
						testResults = testResultCache.getTestResultList(); //cacheObj.getTestResultList();
						if(testResults != null && !testResults.isEmpty()){
							break;
						}
						
					}
					// this is only to know that we have not got data
					if((itr == MAX_TRIES) && (testResults == null || testResults.isEmpty())){
						System.out.println("fully expired the waiting time");	
					}
				}
				
			}
		}
		
		return testResultCache;
		//return testResults;
	}
	
	
}
