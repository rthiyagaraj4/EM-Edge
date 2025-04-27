/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;

import java.util.Hashtable;
/*
 * This class stores all the static SQL Query data.
 */
public class XISQLSet 
{
  static Hashtable hashMap = new Hashtable();
  static String columnDelimiter=",";
  
  static
  {

	/* code inserted by Neelkamal Pyla --------------------------------------------*/
		
    // Administer Server Process
		  hashMap.put("ADMINSERVERPROCESS",
			"SELECT J.JOB,J.WHAT,J.LOG_USER,TO_CHAR(J.LAST_DATE,'DD/MM/YYYY HH24:MI') LAST_DATE,TO_CHAR(J.NEXT_DATE,'DD/MM/YYYY HH24:MI:SS') NEXT_DATE,DECODE(nvl(null,'0'),'Idle','Running')J_STATUS,DECODE(NVL(J.FAILURES,0),0,'Success','Failed') PREV_STATUS ,J.INTERVAL FROM DBA_JOBS j WHERE (UPPER(WHAT)) NOT LIKE 'XHGEN_CREATOR%'");

	/***** New Transaction Queries based on Views *****/
	     
 /*   // Requisitions Header
		 hashMap.put("REQHDR","SELECT  REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,REQUEST_STATUS,DOC_TYPE_CODE FROM XI_PO_HDR_VW A WHERE  A.DOC_TYP = 'REQ'"); */

    // Requisitions Header
		 hashMap.put("REQHDR","SELECT  REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,STATUS_DESC,DOC_TYPE_CODE FROM XI_PO_REQ_HDR_VW A WHERE  A.DOC_TYP = 'REQ'");

    // Reciepts Header with Req
//			 hashMap.put("RECWRH","SELECT  REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,REQUEST_STATUS,DOC_TYPE_CODE FROM XI_RecWReq_HDR_VW A WHERE  A.DOC_TYP = 'RECWR'");

    // Reciepts Header with Req
			 hashMap.put("RECWRH","SELECT  REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,STATUS_DESC,DOC_TYPE_CODE FROM XI_GRN_HDR_WITH_REQ_VW A WHERE  A.DOC_TYP = 'RECWR'");

    // Reciepts Header without Req
  //			 hashMap.put("RECWORH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,REQUEST_STATUS,DOC_TYPE_CODE FROM XI_RecWOReq_HDR_VW A WHERE  A.DOC_TYP = 'RECWOR'");

    // Reciepts Header without Req
  			 hashMap.put("RECWORH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,STATUS_DESC,DOC_TYPE_CODE FROM XI_GRN_HDR_WITH_OUT_REQ_VW A WHERE  A.DOC_TYP = 'RECWOR'");

    // Returns Header with GRN
	//		 hashMap.put("RETWGRNH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,REQUEST_STATUS,DOC_TYPE_CODE FROM  XI_RetWGRN_HDR_VW A WHERE  A.DOC_TYP = 'RETWGRN'");

    // Returns Header with GRN
			 hashMap.put("RETWGRNH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,STATUS_DESC,DOC_TYPE_CODE FROM  XI_GRN_RET_HDR_VW A WHERE  A.DOC_TYP = 'RETWGRN'");

    // Returns Header without GRN
// 			 hashMap.put("RETWOGRNH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,REQUEST_STATUS,DOC_TYPE_CODE  FROM XI_RetWOGRN_HDR_VW A WHERE  A.DOC_TYP = 'RETWOGRN'");

	// Returns Header without GRN
 			 hashMap.put("RETWOGRNH","SELECT REQ_NUM,REQ_DATE,REQ_BY_ORGANIZATION_ID,PUR_DEPT_CODE,STATUS_DESC,DOC_TYPE_CODE  FROM XI_NON_GRN_RET_HDR_VW A WHERE  A.DOC_TYP = 'RETWOGRN'");

//XI_PO_HDR_VW
   // Requisitions Detail
 			 hashMap.put("REQDTL","SELECT a.req_line_num,a.item_code,a.short_desc,a.item_ord_qty,a.item_app_qty,a.grn_gen_uom_qty FROM XI_PO_REQ_DTL_VW A WHERE  A.DOC_TYP = 'REQ'");

    // Reciepts Detail with Req
 	//		 hashMap.put("RECWRD","SELECT doc_srl_no,a.item_code,a.short_desc,a.grn_item_qty FROM XI_RecWReq_DTL_VW A WHERE  A.DOC_TYP = 'RECWR'");

    // Reciepts Detail with Req
 			 hashMap.put("RECWRD","SELECT doc_srl_no,a.item_code,a.short_desc,a.grn_item_qty FROM XI_GRN_DTL_WITH_REQ_VW A WHERE  A.DOC_TYP = 'RECWR'");


    // Reciepts Detail without Req
  	//		 hashMap.put("RECWORD","SELECT doc_srl_no,a.item_code,a.short_desc,a.grn_item_qty FROM XI_RecWOReq_DTL_VW A WHERE  A.DOC_TYP = 'RECWOR'");

    // Reciepts Detail without Req
  			 hashMap.put("RECWORD","SELECT doc_srl_no,a.item_code,a.short_desc,a.grn_item_qty FROM XI_GRN_DTL_WITH_OUT_REQ_VW A WHERE  A.DOC_TYP = 'RECWOR'");			 
 		
    // Returns Detail with GRN
// 			 hashMap.put("RETWGRND","SELECT doc_srl_no,a.item_code,a.short_desc,a.item_ret_qty FROM XI_RetWGRN_DTL_VW A WHERE  A.DOC_TYP = 'RETWGRN'");

 		
    // Returns Detail with GRN
 			 hashMap.put("RETWGRND","SELECT doc_srl_no,a.item_code,a.short_desc,a.item_ret_qty FROM XI_GRN_RET_DTL_VW A WHERE  A.DOC_TYP = 'RETWGRN'");

    // Returns Detail without GRN
 //			 hashMap.put("RETWOGRND","SELECT doc_srl_no,a.item_code,a.short_desc,a.item_ret_qty FROM XI_RetWOGRN_DTL_VW A WHERE  A.DOC_TYP = 'RETWOGRN'");

     // Returns Detail without GRN
 			 hashMap.put("RETWOGRND","SELECT doc_srl_no,a.item_code,a.short_desc,a.item_ret_qty FROM XI_NON_GRN_RET_DTL_VW A WHERE  A.DOC_TYP = 'RETWOGRN'");

    /*******  End of Transaction Status Queries  ************/

    // Query Item Status
		  hashMap.put("ITEMSTATUS","SELECT a.item_code,a.short_desc,a.xi_item_category_code,a.xi_organization_id,b.stock_avail_yn FROM xi_item a,xi_qry_org_itm_status b WHERE a.xi_organization_id=b.organization_id");

    // Query Organization Wise Item Status
//		  hashMap.put("ORGWSITEMSTATUS","SELECT a.item_code,a.item_description,b.xi_item_category_code,a.organization_id,a.stock_avail_yn FROM xi_qry_org_itm_status a,xi_item b");

    // Query Organization Wise Item Status
		  hashMap.put("ORGWSITEMSTATUS","SELECT ITEM_CODE,ITEM_DESCRIPTION,XI_ITEM_CATEGORY_CODE,ORGANIZATION_ID,STOCK_AVAIL_YN FROM XI_ORG_ITEM_STATUS_VW");

	/* End of the code inserted by Neelkamal Pyla --------------------------------------------*/

	/* code inserted by Lakshman --------------------------------------------*/
//		 hashMap.put("NEWARRAIVALITEM","select XI_ITEM_CODE,XI_ITEM_DESCRIPTION,XI_ITEM_CATEGORY_CODE,TO_CHAR(added_date,'DD/MM/YYYY HH24:MI'),XI_ORGANIZATION_ID from XI_ITEM");

// Added by Neelkamal on Nov 11
		 hashMap.put("NEWARRAIVALITEM","select XI_ITEM_CODE,XI_ITEM_DESCRIPTION,XI_ITEM_CATEGORY_CODE,TO_CHAR(added_date,'DD/MM/YYYY HH24:MI'),XI_ORGANIZATION_ID from XI_NEW_ITEM_ARRIVALS_VW");		 

	/* End of the code inserted by Lakshman --------------------------------------------*/

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
