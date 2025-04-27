/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;
import java.util.Hashtable;
import java.util.Enumeration;

public class BTMasterTableList
{
 private static Hashtable hashtableList = new Hashtable();
 
 static
 {
  hashtableList.put("query","INSERT INTO SY_PROG_PARAM(PGM_ID, SESSION_ID, PGM_DATE, PARAM1, PARAM2, PARAM3, PARAM4,PARAM5,PARAM6,PARAM7) VALUES('#PGM_ID',#SESSION_ID, '#PGM_DATE', '#PARAM1','#PARAM2',  '#SPECIMEN_NO','#UNIT_NO','#PRODUCT_CODE','#PARAM3','#PARAM4')");

  hashtableList.put("update","update BT_UNIT_REQUEST_DTL set TRANSFUSE_PRACT_ID2='#TRANSFUSE_PRACT_ID',TRANSFUSE_ST_DATE_TIME=to_Date('#TRANSFUSE_ST_DATE_TIME','dd/mm/yyyy'),TRANSFUSE_EN_DATE_TIME=to_Date('#TRANSFUSE_EN_DATE_TIME','dd/mm/yyyy'),TRANSFUSED_VOL=#CURRENT_VOLUME,REQUEST_FOR_ISSUE_BY='#login_user',REACTION_CODE='#REACTION_CODE',IGNORE_REMARKS='#TRANSFUSION_REMARKS' where ROWID='#ROW_ID'");
  }
 
 public static String frameMasterInsertQuery(String sqlKey,Hashtable masterData,Hashtable commonData)
 {
	  
		 StringBuffer strMaster=new StringBuffer(""+hashtableList.get(sqlKey));
		 String value="";

	 Enumeration enum1= masterData.keys();
	   while(enum1.hasMoreElements())
	 {
		    value=""+enum1.nextElement();
	    	eBT.BTStatementUtils.replace(strMaster,"#"+value,""+eBT.BTStatementUtils.checkNull(masterData,value));
	 }
	 if(commonData!=null)
	 {		
	  enum1=commonData.keys();
	   while(enum1.hasMoreElements())
	 {
		    value=""+enum1.nextElement();
	    	eBT.BTStatementUtils.replace(strMaster,"#"+value,""+eBT.BTStatementUtils.checkNull(commonData,value));
	 }
	 }

		return strMaster.toString();
 }

}

