/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.PatAllergy;

import java.rmi.* ;
import javax.ejb.* ;

import java.sql.* ;

public interface PatAllergyManagerLocal extends EJBLocalObject {
public java.util.HashMap insertPatAllergy(
							java.util.Properties p,
							String	  patientid,
							String	  allergytypecode,
							String    allergyclass,
							String    allergicitem,
							String    generic_id,
							String	  onsetdate ,
							String	  remarks,
							String	  practid,
							String	  facilityid ,
							String	  locncode,
							String	  locntype ,
							String	  encounterid ,
							String	  addedAtWorkstation,
							String	  addedFacilityId,
							String	  drug_code,
							String	  allergytypecode2,
							String	  allergytypecode3
						 ) ;

public java.util.HashMap updatePatAllergy(
							java.util.Properties p,
							String	  patientid,
							String  	  srlno,
							//String    allergyclass,
							String	  allergicitem,
							//String    generic_id,
     						//String	  onsetdate ,
							String    remarks,
							String    closedate ,
							String	  practid,
							String	  facilityid ,
							String	  locncode,
							String	  locntype ,
							String	  encounterid ,
							String	  addedAtWorkstation,
							String	  addedFacilityId,
							//String	  drug_code,
							String errorRemarks
						 ) ;
}

