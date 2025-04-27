/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA.PatHighRisk;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;

public interface PatHighRiskManagerLocal extends EJBLocalObject {

	public java.util.HashMap insertPatHighRisk
	(
							java.util.Properties p,
							String	  patientid,
							String	  highriskcode,
							String	  onsetdate ,
							String	  remarks,
							String	  practid,
							String	  facilityid ,
							String	  locncode,
							String	  locntype ,
							String	  temp_encounterid ,
							String	  addedAtWorkstation,
							String	  addedFacilityId,
							String	  locale,
							String    date_type
						 ) ;

	public java.util.HashMap updatePatHighRisk(
			java.util.Properties p,
			String    patientid,
			String	  highriskcode,
			String    closedate ,
			String	  remarks,
			String	  practid,
			String	  facilityid ,
			String	  locncode,
			String	  locntype ,
			String	  temp_encounterid ,
			String	  addedAtWorkstation,
			String	  addedFacilityId,
							String	  locale,
							String srlno
						 ); // additional parameter srlno added for IN037071
}
