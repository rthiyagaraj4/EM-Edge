/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;

import java.util.*;
import java.io.*;
public class WriteOffGroupListBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_code;
	private String group_type;
	private String description;
	private String tray_no;
	private String write_off_reason_code;
	private String write_off_reason_desc;
	private String remarks;
	private String write_off_cost;
	private String mode;
	private String linen_applicable_yn;//mmoh-crf-1661 
	
	

	public String getLinen_applicable_yn() {
		return linen_applicable_yn;
	}

	public void setLinen_applicable_yn(String linen_applicable_yn) {
		this.linen_applicable_yn = linen_applicable_yn;
	}//end  

	public String getGroup_code() {
		 return group_code;
	}
	
	public String getGroup_type() {
		 return group_type;
	}

	public String getDescription() {
		 return description;
	}
	
	public String getTray_no() {
		 return tray_no;
	}

	public String getWrite_off_reason_code() {
		 return write_off_reason_code;
	}

	public String getWriteOffReasonDesc() {
		 return write_off_reason_desc;
	}
	
	public String getRemarks() {
		 return remarks;
	}
	
	public String getWrite_off_cost (){
		return this.write_off_cost;
	}

	public void setGroup_code(String group_code) {
		 this.group_code =  group_code.toUpperCase();
	}

	public void setGroup_type(String group_type) {
		 this.group_type =  group_type.toUpperCase();
	}

	public void setDescription(String description) {
		 this.description =  description;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no =  tray_no;
	}

	public void setWrite_off_reason_code(String write_off_reason_code) {
		 this.write_off_reason_code =  write_off_reason_code.toUpperCase();
	}

	public void setWrite_off_reason_desc(String write_off_reason_desc) {
		 this.write_off_reason_desc =  write_off_reason_desc;
	}
	
		public void setRemarks(String remarks) {
		 this.remarks =  checkForNull(remarks);
		 
	}

	public void setWrite_off_cost (String write_off_cost) {
		this.write_off_cost = write_off_cost;
		//this.write_off_cost = CommonBean.setNumber (write_off_cost,3 );
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}
	
	public String getMode() {
		 return mode;
	}

	public String getGroup_type_List(){
		if(getLinen_applicable_yn()!=null && getLinen_applicable_yn().equals("Y")){ 
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;", getGroup_type()); 
		}
		else{
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;", getGroup_type()); 
		}
	}

		public String getGroup_type_Text(String group_type){
			//System.out.println("AAA"+group_type);
		return group_type.equals("E")?"Set":group_type.equals("T")?"Tray":group_type.equals("P")?"Soft Pack":group_type.equals("L")?"Linen":"Single";//modified for ML-MMOH-CRF-1661
	}


	public void clear(){
		group_type	  ="";    
		group_code	  ="";    
		description   ="";          
		tray_no="";       
		write_off_reason_code   ="";          
		write_off_reason_desc="";          
		//write_off_reason_code_desc="";
		write_off_cost ="";
		remarks="";
		mode          ="";        
		linen_applicable_yn = "";//MMOH-CRF-1661 
	}

	public String getWrite_off_reason_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()), getWrite_off_reason_code ());
	}


	public HashMap toHashMap(){
		HashMap hmReturn	 =	new HashMap();
		hmReturn.put("group_code",		getGroup_code());
		hmReturn.put("group_type",		getGroup_type());
		hmReturn.put("description",	getDescription());
		hmReturn.put("tray_no",		new Long(getTray_no()));
		hmReturn.put("write_off_reason_code",		getWrite_off_reason_code());
		hmReturn.put("remarks",		getRemarks());
		hmReturn.put("mode",			getMode          ());
		hmReturn.put("write_off_cost",			getWrite_off_cost());
		return hmReturn;
	}

	
		public boolean isTrayGroupInArrayList(ArrayList alGroupList, String stTray_no, String stGroup_code, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alGroupList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alGroupList.get(i)).get("group_code").toString().equals(stGroup_code) ) {
				if ( ((HashMap)alGroupList.get(i)).get("tray_no").toString().equals(stTray_no) ) {
					result=true;
					break;
				}
			}
		}
		return result;
	}
//	dataMap.put("SQL_SS_WRITE_OFF_HDR_SELECT_SINGLE","SELECT	TO_CHAR(doc_date,'dd/mm/yyyy') doc_date, store_code,  doc_ref, entry_completed_yn, finalized_yn, added_by_id FROM ss_write_off_hdr WHERE facility_id = ? AND doc_type_code = ? AND doc_no=? ");
	public boolean isEntryCompleted(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
	//	//System.err.println("before");
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_SELECT_SINGLE"),alParameters);
	//			//System.err.println("after");
		return hmResult.get("ENTRY_COMPLETED_YN").toString().equals("Y");
	}

	public void initialize(HashMap hmRequestGroupItem){
		setGroup_code(hmRequestGroupItem.get("group_code").toString()	);
		setGroup_type	 ((String)hmRequestGroupItem.get("group_type")	);
		setDescription   (hmRequestGroupItem.get("description").toString()	);
		setTray_no(hmRequestGroupItem.get("tray_no").toString()		);
		setWrite_off_reason_code(hmRequestGroupItem.get("write_off_reason_code").toString()		);
		setWrite_off_reason_desc(hmRequestGroupItem.get("write_off_reason_desc").toString()			);
		setRemarks(checkForNull((String)hmRequestGroupItem.get("remarks")).toString()			);
		setMode          (hmRequestGroupItem.get("mode").toString()			);
		setWrite_off_cost (checkForNull((String)hmRequestGroupItem.get("write_off_cost")).toString()			);
	}

		public String getWriteOffCost(String group_code, String tray_no) throws Exception {
        java.sql.Connection connection = null ;
        java.sql.CallableStatement callableStatement = null;
		String totalCost = null;
		try{
			connection = getConnection();
			callableStatement	=	connection.prepareCall("{ call ? := SS_GET_TRAY_COST(?,?) }");
			callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
			callableStatement.setString (2, group_code);
			callableStatement.setLong (3, Long.parseLong(tray_no) );
			callableStatement.execute();
			totalCost =""+callableStatement.getDouble(1);

		}
		catch(Exception exception){
			exception.printStackTrace();
			//System.err.println(exception);
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return totalCost;
    }
}
