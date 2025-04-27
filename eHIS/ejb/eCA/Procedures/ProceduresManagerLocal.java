/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.Procedures;

import java.util.HashMap;
import java.util.Properties;
import javax.ejb.EJBLocalObject;

public abstract interface ProceduresManagerLocal extends EJBLocalObject
{
	public java.util.HashMap insertProcedure(
            java.util.Properties p,
            String temp_encounter_id,
            String practitioner_id,
            String patient_id,
            String proc_code,
            String proc_date,
            String record_type,
            String cause_indicator,
            String proc_code_scheme,
            String proc_narration,
            String hpi,
            String proc_summary,
            String findings,
            String impression,
            String disposition,
            String added_at_ws_no,
            String added_facility_id,
            String patient_class,
            String order_id,
            String order_line_num,
			String	enddate,					
			String	practitioner1,			    
			String	anaesthetists1,		    
			String	anaesthetists2,		    
			String	anaesthetists3,		    
			String	scrubnurse,			    
			String	anaesthesia,			    
			String	anaesthesDet,		    
			String	indication,				    
			String	monitor,					    
			String	events	,					    
			String	postProcedure,		    
			String	specimen,				    
			String	locale,
			String  laterality,
			String  location,
			String  practitioner2,
			String  accession_number,
			String classifition_type//36285
         ) ;

	public java.util.HashMap updateProcedure(
			java.util.Properties p,
            String encounter_id,
            String practitioner_id,
            String patient_id,
            String proc_code,
            String proc_date,
            String proc_narration,
            String hpi,
            String proc_summary,
            String findings,
            String impression,
            String disposition,
            String modified_at_ws_no,
            String modified_facility_id,
			String modified_by_id,
			String srl_no,
			String	enddate,					
			String	practitioner1,			    
			String	anaesthetists1,		    
			String	anaesthetists2,		    
			String	anaesthetists3,		    
			String	scrubnurse,			    
			String	anaesthesia,			    
			String	anaesthesDet,		    
			String	indication,				    
			String	monitor,					    
			String	events	,					    
			String	postProcedure,		    
			String	specimen,
			String	errorRemarks,
			String  locale,
			String  laterality,
			String  location,
			String  practitioner2 ,
			String  accession_number,
			String classifition_type//36285

            );
}
