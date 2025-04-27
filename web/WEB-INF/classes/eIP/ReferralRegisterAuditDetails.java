/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.Connection; 
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;

/*Below method retrive the audit Trails from DB and set the value in bean setter method and bean Object added into the ArryList  */

public class ReferralRegisterAuditDetails implements Serializable
{

  public static ArrayList getAuditTrail(Connection con,String referralId,java.util.Properties p) throws Exception{

    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	ReferralRegisterAuditBean  ReferralAuditBean=null;
 
 
	String locale = p.getProperty("LOCALE");
		
try{
		arrayList=new ArrayList();
		//Below query modified for this CRF ML-MMOH-CRF-0566 US3
		
		sqlQuery="select sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'"+locale+"',1) user_name, TO_CHAR (MODIFIED_DATE, 'DD/MM/YYYY HH24:MI') modifieddate, TO_CHAR (TRANS_DATE_TIME, 'DD/MM/YYYY HH24:MI') trans_date_time, BEDSIDE_REF_REVIEW_STATUS, cancel_reject_reason_code, TO_CHAR(referral_date, 'DD/MM/YYYY HH24:MI') referral_datetime, am_get_desc.am_practitioner(practitioner_id,'"+locale+"','1') referredfrom_pract_name, am_get_desc.am_practitioner(to_pract_id,'"+locale+"','1') referredto_pract_name, am_get_desc.am_contact_reason(cancel_reject_reason_code,'"+locale+"','1') cancel_reject_reason_desc from PR_REFERRAL_REG_AUDIT where REFERRAL_ID=? order by MODIFIED_DATE";
		pstmt = con.prepareStatement(sqlQuery);	
		pstmt.setString(1, referralId);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next()){
		  ReferralAuditBean=new ReferralRegisterAuditBean();
		  ReferralAuditBean.setUserName(checkForNull(rs.getString("user_name")));
		  ReferralAuditBean.setPerformedDate(checkForNull(rs.getString("modifieddate")));
		 // ReferralAuditBean.setPerformedDate(checkForNull(rs.getString("trans_date_time"))); //Added for this CRF ML-MMOH-CRF-0566 US3
		  ReferralAuditBean.setReviewStatus(checkForNull(rs.getString("BEDSIDE_REF_REVIEW_STATUS")));
		  //Added for this CRF ML-MMOH-CRF-0566 US3
		  ReferralAuditBean.setCancelrejectreason(checkForNull(rs.getString("cancel_reject_reason_code")));
		  ReferralAuditBean.setCancelrejectdatetime(checkForNull(rs.getString("referral_datetime"))); 
		  ReferralAuditBean.setReffrompractitioner(checkForNull(rs.getString("referredfrom_pract_name")));
		  ReferralAuditBean.setReftopractitioner(checkForNull(rs.getString("referredto_pract_name")));
		  ReferralAuditBean.setCancelrejectreasondesc(checkForNull(rs.getString("cancel_reject_reason_desc"))); 
		  //End ML-MMOH-CRF-0566 US3
		  arrayList.add(ReferralAuditBean);
		 }
		 if(rs != null) rs.close() ; //Added for checkstyle

	}catch(Exception e){
		e.printStackTrace();
	}
	return arrayList;
}



public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}	
	
			
}
