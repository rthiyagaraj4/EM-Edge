/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
  *Module			:	eSS
  *Function		:	Surgery Type
 
package eSS ;
import java.util.HashMap;

public class SurgeryTypeBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{
	public SurgeryTypeBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_COUNT");
		super.codeFieldName = "surgery_type";
	}
	
	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }
} */

package eSS;

import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.*;

public class SurgeryTypeBean extends eSS.Common.SsAdapter implements java.io.Serializable{

	protected int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));

	private String []code = new String[RECORD_SIZE];
	private String []long_desc  = new String[RECORD_SIZE];
	private String []short_desc = new String[RECORD_SIZE];
	private String []surg_name = new String[RECORD_SIZE];
	private String []eff_status = new String[RECORD_SIZE];
	private String []surg_desc = new String[RECORD_SIZE];
	private String []nature_type = new String[RECORD_SIZE];
	private String []DBeff_status = new String[RECORD_SIZE];

	
	public SurgeryTypeBean() {

	}

	/* Set Methods Start */
	public void setCode(int index, String code) {
			this.code[index]		=	(code != null)?code.toUpperCase():null; 
	}

	public void setLong_desc(int index, String long_desc) {
			this.long_desc[index]		=	long_desc; 
	}

	public void setShort_desc(int index, String short_desc) {
			this.short_desc[index]		=	short_desc; 
	}

	public void setSurg_name(int index, String surg_name) {
			this.surg_name[index]		=	surg_name;
	}

	public void setEff_status(int index, String eff_status) {
			this.eff_status[index]		=	eff_status;
	}
	
	public void setDBEff_status(int index, String DBeff_status) {
		this.DBeff_status[index]		=	DBeff_status;
	}
	
	public void setSurg_desc(int index, String surg_desc) {
		this.surg_desc[index]		=	surg_desc;
	}
	
	public void setNature_type(int index, String nature_type) {
		this.nature_type[index]		=	nature_type;
	}

	/* Set Methods End */

	/* Get Methods Start */
	public String getCode(int index) {
		return this.code[index];
	}

	public String getLong_desc(int index) {
		return this.long_desc[index];
	}

	public String getShort_desc(int index) {
		return this.short_desc[index];
	}
	public String getSurg_name(int index) {
		return this.surg_name[index];
	}

	public String getEff_status(int index) {
		return this.eff_status[index];
	}
	public String getDBEff_status(int index) {
		return this.DBeff_status[index];
	}
	
	public String getSurg_desc(int index) {
		return this.surg_desc[index];
	}
	
	public String getNature_type(int index) {
		return this.nature_type[index];
	}
	/* Get Methods End */

	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear();
		for (int index=0;index<RECORD_SIZE;index++)
		{
			code[index]	 = "";
			long_desc[index] = "";
			short_desc[index] = "";
			surg_name[index]  = "";
			eff_status[index] = "D";
			DBeff_status[index] = "D";
		}
	}

	public void setAll(Hashtable recordSet) {
		for (int index=0;index<RECORD_SIZE;index++) {
			String tempCode	=	(String)recordSet.get("code_"+index);
			String tempLong_desc	=	(String)recordSet.get("long_desc_"+index);
			String tempShort_desc	=	(String)recordSet.get("short_desc_"+index);
			String tempSurg_name	=	(String)recordSet.get("surgery_type_search_"+index);
			String tempEff_status	=	(String)recordSet.get("eff_status_"+index);
			
			if((tempCode== null) || (tempCode.equals(""))) {
				setCode	(index, null);
				setLong_desc	(index, null);
				setShort_desc	(index, null);
				setSurg_name	(index,null);
				setEff_status(index, null);
				continue; 
			}

			setCode	(index, tempCode);
			setLong_desc	(index, tempLong_desc	);
			setShort_desc	(index, tempShort_desc	);
			setSurg_name	(index, tempSurg_name	);
			if(tempEff_status==null || tempEff_status.trim().equals(""))
				setEff_status	(index, "D");
			else
				setEff_status	(index, tempEff_status);
		}
	}

	public HashMap insert() {
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		hmResult.put("result", new Boolean(false));

		for (int index=0;index<RECORD_SIZE;index++) {
			if((getCode(index) == null) || (getCode(index).equals(""))) 
					continue;
			ArrayList alInsertRecord        =       new ArrayList();
			alInsertRecord.add(getCode(index));
			alInsertRecord.add(getLong_desc(index));
			alInsertRecord.add(getShort_desc(index));
			alInsertRecord.add(getEff_status(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);

			alInsertRecord.add(getSurg_name(index));
			
			alInsertData.add(alInsertRecord);
			//For duplicate check
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(getCode(index));
			alWhereData.add(duplicateValue);
	}

		hmSQLMap.put("InsertSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_INSERT")); 
		hmSQLMap.put("SelectSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_COUNT")); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("WhereData",alWhereData);
		hmTableData.put("InsertData",alInsertData);

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
				hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"SS"));
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get( "msgid" ),"Common"));
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) ) ;
				} else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		return hmResult;
	}


	public HashMap modify() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		hmResult.put("result", new Boolean(false));

		alModifyData.add(long_desc[0]);
		alModifyData.add(short_desc[0]);
		alModifyData.add(eff_status[0]);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id	);
		alModifyData.add(surg_name[0]);
		
		alModifyData.add(code[0]);
		
		hmSQLMap.put("ModifySQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_UPDATE")); 

		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(((Boolean) hmResult.get("result")).booleanValue())	
			{
				hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"SS"));
			}
			else
			{
			    hmResult.put( "message", (String)hmResult.get( "msgid" ) ) ;
				
			}
			
		} 
		catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.getMessage());
			}
		}
		return hmResult;
	}

	public String paramsInBean() {
		StringBuffer arrayContent = new StringBuffer();
		for (int index=0;index<RECORD_SIZE;index++) {
			arrayContent.append("Record :"+ (index + 1) +" :: ");
			arrayContent.append(code [index]	+"=	");
			arrayContent.append(long_desc[index]+"=");
			arrayContent.append(short_desc[index]+"=");
			arrayContent.append(surg_name[index]+"=");
			arrayContent.append(eff_status[index]+"=");	
			arrayContent.append("<BR>");
		}	
		return arrayContent.toString();
	}

	/* Added by Martin */
	public void loadData() throws Exception {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SURGERY_TYPE_SELECT_SINGLE")); 
			pstmt.setString(1, getLanguageId());
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, code[0]);
			
			resultSet = pstmt.executeQuery();
			if ((resultSet != null) && (resultSet.next())) {
				setCode(0,resultSet.getString("surgery_type"));
				setLong_desc(0,resultSet.getString("long_desc"));
				setShort_desc(0,resultSet.getString("short_desc"));
				setEff_status(0,resultSet.getString("eff_status"));
				setSurg_name(0,resultSet.getString("surgery_nature_code"));
				setSurg_desc(0,resultSet.getString("surg_desc"));
				setNature_type(0,resultSet.getString("nature_type"));
				
				setDBEff_status(0,resultSet.getString("eff_status"));
			}
		} 
		catch (Exception e)	{
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	public HashMap validate()  {
        HashMap map = new HashMap() ;
       // ArrayList alParameters	=	new ArrayList(); //Comented by sakti as this is unused against inc#48061 
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success" ) ;
        
        //Added by sakti not to proceed for duplicate SURGERY_NATURE_CODE against KDAH_CRF_0247
        if(getEff_status(0).equals("E") && getDBEff_status(0).equals("D") && mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) { 
        try{
        	if (!fetchRecord("SELECT COUNT(*) COUNT FROM ss_surgery_type WHERE SURGERY_NATURE_CODE = ? and eff_status='E'",getSurg_name(0) ).get("COUNT").toString().equals("0")) {
				map.put("result", super.FALSE );
				map.put("message", getMessage(getLanguageId(),"SURG_NAME_ALREADY_LINKED","SS") );
		}
        }catch (Exception exception) {
			exception.printStackTrace();
			}
        }
               
        return map ;
    } 
}
