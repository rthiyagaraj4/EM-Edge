/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB; 

import java.util.Hashtable;
/*
 * This class stores all the static SQL Query data.
 */
public class XBSQLSet 
{
  static Hashtable hashMap = new Hashtable();
  static String columnDelimiter=",";
  
  static
  { 

	/* code inserted by Neelkamal Pyla --------------------------------------------*/
		
    // Administer Server Process
		  hashMap.put("MASTERSETUP",
			" SELECT  a.EBILLING_MODULE_TYPE,a.EBILLING_MODULE_TYPE_DESC,a.PAYER_GROUP_CODE,b.long_desc,a.PAYER_CODE,c.short_name,a.POLICY_TYPE_CODE,d.short_desc,a.EPISODE_TYPE,a.ENABLED_YN,a.facility_id,e.facility_name FROM xb_ebilling_module_type a,AR_CUST_GROUP b,AR_CUSTOMER c,BL_INS_POLICY_TYPES d,SM_FACILITY_PARAM e WHERE a.payer_group_code = b.cust_group_code(+) AND    a.payer_code = c.CUST_CODE(+) AND a.POLICY_TYPE_CODE = d.POLICY_TYPE_CODE(+)  AND a.FACILITY_ID = e.facility_id AND upper(a.EBILLING_MODULE_TYPE) LIKE upper('#module_type%') AND upper(a.PAYER_GROUP_CODE) LIKE upper('#payer_group_desc%')   AND upper(a.PAYER_CODE) LIKE upper('#payer_desc%')   AND upper(a.POLICY_TYPE_CODE) LIKE upper('#policy_desc%')  AND upper(a.EPISODE_TYPE) = NVL(upper('#episode_type'),a.EPISODE_TYPE) AND upper(a.ENABLED_YN) = NVL(upper('#enabled_yn'),a.ENABLED_YN)  ORDER BY EBILLING_MODULE_TYPE");


		  hashMap.put("EXPORTFILES",
				" SELECT A.EVENT_TYPE,B.EVENT_NAME,A.SENT_FILE_ID,TO_CHAR(A.SENT_DATE,'DD/MM/YYYY HH24:MI:SS'),operating_facility_id,doc_ref_num,reply_file_id,TO_CHAR(A.reply_date,'DD/MM/YYYY HH24:MI:SS') FROM XB_SENT_FILE_DTLS A,XH_EVENT_TYPE B ");
  }
 
  /**
	 * Static method which return the query string depending on passed query id  
	 * @param  String id  
	 * @return String  
	 */

  public synchronized static String getSQL(String id)
  {
    return((String)hashMap.get(id));
  }

  /**
	 * Static method which returns the columnDelimiter 
	 * @return String  
	 */

  public synchronized static String getDelimiter()
  {
    return(columnDelimiter);
  }
  
 
}//end of class
