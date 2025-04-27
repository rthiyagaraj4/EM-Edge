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
package eIPAD.pendingresults;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This model class stores the pending results for
 * a patient and is used in the pending results for review
 * @author GRamamoorthy
 *
 */
public class PendingResultForPatient implements Serializable {
	
	/**
	 * Stores the pending results for a patient
	 */
	private Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient = new HashMap<ResultCategory, List<ResultDetail>>();
	
	/**
	 * Stores the patient detail for which this result
	 * is stored
	 */
	private PatientDetail patientDetail = null;

	/**
	 * Default constructor of the class
	 */
	public PendingResultForPatient() {
	}

	/**
	 * @return the pendingResultMapForPatient
	 */
	public Map<ResultCategory, List<ResultDetail>> getPendingResultMapForPatient() {
		return pendingResultMapForPatient;
	}

	/**
	 * @param pendingResultMapForPatient the pendingResultMapForPatient to set
	 */
	public void setPendingResultMapForPatient(
			Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient) {
		this.pendingResultMapForPatient = pendingResultMapForPatient;
	}

	/**
	 * @return the patientDetail
	 */
	public PatientDetail getPatientDetail() {
		return patientDetail;
	}

	/**
	 * @param patientDetail the patientDetail to set
	 */
	public void setPatientDetail(PatientDetail patientDetail) {
		this.patientDetail = patientDetail;
	}
	
	/**
	 * 
	 * @param resultCategory
	 * @return
	 */
	public int getPatientRecordCountForCategory(ResultCategory resultCategory){
		int recordCount = 0;
		if(pendingResultMapForPatient.containsKey(resultCategory)){
			List<ResultDetail> resultDetailList = pendingResultMapForPatient.get(resultCategory);
			if(resultDetailList != null){
				recordCount = resultDetailList.size();
			}
		}
		
		return recordCount;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPendingRecordCountForPatient(){
		int recordCount = 0;
		Set<Entry<ResultCategory, List<ResultDetail>>> resultEntries = pendingResultMapForPatient
				.entrySet();
		if(resultEntries == null){
			return recordCount;
		}
		Iterator<Entry<ResultCategory, List<ResultDetail>>> resultIterator = resultEntries
				.iterator();
		if(resultIterator == null){
			return recordCount;
		}
		Entry<ResultCategory, List<ResultDetail>> entry = null;
		List<ResultDetail> resultDetailList = null;
		while(resultIterator.hasNext()){
			entry = resultIterator.next();
			resultDetailList = entry.getValue();
			if(resultDetailList != null){
				recordCount += resultDetailList.size();
			}
		}
		return recordCount;
	}
	

}
