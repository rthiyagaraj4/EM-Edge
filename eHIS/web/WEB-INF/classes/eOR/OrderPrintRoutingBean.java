/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created 
22/04/2014    IN042962		 Chowminya      CRF:Print Order Sheet From Existing Orders										
-----------------------------------------------------------------------
*/
package eOR;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;

import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class OrderPrintRoutingBean extends OrAdapter implements java.io.Serializable {

	String operating_facility_id="";
	String order_type_code = "";
	String patient_class = "";//
	String print_consent_yn = "";
	String consent_routing_queue_1 = "";
	String consent_routing_queue_2 = "";
	String consent_routing_queue_dflt="";
	String consent_urg_stat_queue_1="";
	String consent_urg_stat_queue_2="";
	String consent_urg_stat_queue_dflt="";
	String print_ord_dest_yn="";
	String ord_dest_routine_queue_1="";
	String ord_dest_routine_queue_2="";
	String ord_dest_routine_queue_dflt="";
	String ord_dest_stat_queue_1="";
	String ord_dest_stat_queue_2="";
	String ord_dest_stat_queue_dflt="";
	String print_res_at_dept_yn="";
	String print_ord_at_src_yn="";
	String res_dept_routing_queue_1="";
	String res_dept_routing_queue_2="";
	String res_dept_routing_queue_dflt="";
	String res_dept_stat_queue_1="";
	String res_dept_stat_queue_2="";
	String res_dept_stat_queue_dflt="";
	String print_res_patloc_yn="N";
	String print_res_at_othloc="";
	String othloc_queue_name="";
	String print_res_for_disch_pat="";
	String dish_pat_queue_name="";
	String order_type_instruction="";
	String performing_location_code = "";
	String print_cons_at_src_yn="";
	String print_refu_at_src_yn="";
	String print_refusal_at_dest_yn="";
	String refusal_dest_routine_queue_1="";
	String refusal_dest_routine_queue_2="";
	String refusal_dest_rout_queue_dflt="";
	String refusal_dest_stat_queue_1="";
	String refusal_dest_stat_queue_2="";
	String refusal_dest_stat_queue_dflt="";
	String PRINT_RES_FOR_DISCH_PAT_LOCN="";

	//added on 9.11.2004
	String print_referral_at_src_yn="";
	String print_referral_at_dest_yn="";
	String referral_dest_routine_queue_1="";
	String referral_dest_routine_queue_2="";
	String referral_dest_rout_queue_dflt="";
	String referral_dest_stat_queue_1="";
	String referral_dest_stat_queue_2="";
	String referral_dest_stat_queue_dflt="";

	// end of added on 9.11.2004


//	Hashtable multipleMap=null;
	StringBuffer traceVals = new StringBuffer();
	
	String print_dept_loc1 = "";
	String print_dept_loc2 = "";
	String print_urg_dept_loc1 ="";
	String print_urg_dept_loc2 ="";
	String print_report_dept_loc_radio ="";
	String print_report_urg_dept_loc_radio = "";
	String print_option = "";//IN042962
	

	//////////////////
	
	////////////////////
	///////////////// set method of this function class for all variable
	public void set_print_dept_loc1(String print_dept_loc1)
	{
		this.print_dept_loc1 = print_dept_loc1;
	}
	public void set_print_dept_loc2(String print_dept_loc2)
	{
		this.print_dept_loc2 = print_dept_loc2;
	}
	//////////////////////
	public void set_print_urg_dept_loc1(String print_urg_dept_loc1)
	{
		this.print_urg_dept_loc1 = print_urg_dept_loc1;
	}
	public void set_print_urg_dept_loc2(String print_urg_dept_loc2)
	{
		this.print_urg_dept_loc2 = print_urg_dept_loc2;
	}

	//////////////////////////
public void set_print_report_dept_loc_radio(String print_report_dept_loc_radio)
	{
		this.print_report_dept_loc_radio = print_report_dept_loc_radio;
	}


	public void set_print_report_urg_dept_loc_radio(String print_report_urg_dept_loc_radio)
	{
		this.print_report_urg_dept_loc_radio = print_report_urg_dept_loc_radio;
	}
///////////////////////////////////
    public void setdisloc(String PRINT_RES_FOR_DISCH_PAT_LOCN)
	{
	this.PRINT_RES_FOR_DISCH_PAT_LOCN=PRINT_RES_FOR_DISCH_PAT_LOCN;
	}

	public void setPrintResForDischPat(String print_res_for_disch_pat)
	{
	this.print_res_for_disch_pat=print_res_for_disch_pat;
	}

	public void setDishPatQueueName(String dish_pat_queue_name)
		{
		this.dish_pat_queue_name=dish_pat_queue_name;
		}

	public void setOthLocQueueName(String othloc_queue_name){
		this.othloc_queue_name=othloc_queue_name;
		}

	public void setPrintResAtOthloc(String print_res_at_othloc)
		{
		this.print_res_at_othloc=print_res_at_othloc;
		}

	public void setPrintOrdAtSrcYn(String print_ord_at_src_yn)
	{
	this.print_ord_at_src_yn=print_ord_at_src_yn;
	}

	public void setPrintOrdAtConsentSrcYn(String print_cons_at_src_yn)
	{
	this.print_cons_at_src_yn=print_cons_at_src_yn;
	}

	public void setPrintOrdAtRefusalSrcYn(String print_refu_at_src_yn)
	{
	this.print_refu_at_src_yn=print_refu_at_src_yn;
	}

	//added on 9.11.2004

	public void setPrintOrdAtReferralSrcYn(String print_referral_at_src_yn)
	{
	this.print_referral_at_src_yn=print_referral_at_src_yn;
	}

//end of added by on  9.11.2004

	public void setOperatingFacilityId(String facility_id){
		this.operating_facility_id = facility_id;
	}

	public void setOrderTypeCode(String order_type_code){
		this.order_type_code = order_type_code;
	}

	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}

		public void setPrintConsentYn(String print_consent_yn){
		this.print_consent_yn = print_consent_yn;
	}

	public void setConsentRoutineQueue1(String consent_routing_queue_1){
		this.consent_routing_queue_1 = consent_routing_queue_1;
	}

	public void setConsentRoutineQueue2(String consent_routine_queue_2){
		this.consent_routing_queue_2 = consent_routine_queue_2;
	}

	 public void setConsentRoutingQueueD(String  consent_routine_queue_dflt){
			this.consent_routing_queue_dflt=consent_routine_queue_dflt;
	 }

public void setConsentUrgStatQueue1(String consent_urg_stat_queue_1){
this.consent_urg_stat_queue_1=consent_urg_stat_queue_1;
}

public void setConsentUrgStatQueue2(String consent_urg_stat_queue_2){
this.consent_urg_stat_queue_2=consent_urg_stat_queue_2;
}

public void setConsentUrgStatQueueD(String consent_urg_stat_queue_D){
this.consent_urg_stat_queue_dflt=consent_urg_stat_queue_D;
}

public void setRefusalPrintOrdDestYn(String print_refusal_at_dest_yn){
	this.print_refusal_at_dest_yn=print_refusal_at_dest_yn;
}

public void setRefusalDestRoutineQueue1(String  refusal_dest_routine_queue_1){
this. refusal_dest_routine_queue_1= refusal_dest_routine_queue_1;
}
public void setRefusalDestRoutineQueue2(String refusal_dest_routine_queue_2){
	this.refusal_dest_routine_queue_2=refusal_dest_routine_queue_2;
}
public void setRefusalDestRoutineQueueDflt(String refusal_dest_rout_queue_dflt){
this.refusal_dest_rout_queue_dflt=refusal_dest_rout_queue_dflt;
}
public void setRefusalDestStatQueue1(String refusal_dest_stat_queue_1){
this.refusal_dest_stat_queue_1=refusal_dest_stat_queue_1;
}
public void setRefusalDestStatQueue2(String refusal_dest_stat_queue_2){
this.refusal_dest_stat_queue_2=refusal_dest_stat_queue_2;
}
public void setRefusalDestStatQueueDflt(String refusal_dest_stat_queue_dflt){
this.refusal_dest_stat_queue_dflt=refusal_dest_stat_queue_dflt;
}

//added on 9.11.2004

public void setReferralPrintOrdDestYn(String print_referral_at_dest_yn){
	this.print_referral_at_dest_yn=print_referral_at_dest_yn;
}

public void setReferralDestRoutineQueue1(String  referral_dest_routine_queue_1){
this. referral_dest_routine_queue_1= referral_dest_routine_queue_1;
}
public void setReferralDestRoutineQueue2(String referral_dest_routine_queue_2){
	this.referral_dest_routine_queue_2=referral_dest_routine_queue_2;
}
public void setReferralDestRoutineQueueDflt(String referral_dest_rout_queue_dflt){
this.referral_dest_rout_queue_dflt=referral_dest_rout_queue_dflt;
}
public void setReferralDestStatQueue1(String referral_dest_stat_queue_1){
this.referral_dest_stat_queue_1=referral_dest_stat_queue_1;
}
public void setReferralDestStatQueue2(String referral_dest_stat_queue_2){
this.referral_dest_stat_queue_2=referral_dest_stat_queue_2;
}
public void setReferralDestStatQueueDflt(String referral_dest_stat_queue_dflt){
this.referral_dest_stat_queue_dflt=referral_dest_stat_queue_dflt;
}

//end of added on 9.11.2004

public void setPrintOrdDestYn(String print_ord_dest_yn){
	this.print_ord_dest_yn=print_ord_dest_yn;
}

public void setOrdDestRoutineQueue1(String ord_dest_routine_queue_1){
this.ord_dest_routine_queue_1=ord_dest_routine_queue_1;
}
public void setOrdDestRoutineQueue2(String ord_dest_routine_queue_2){
	this.ord_dest_routine_queue_2=ord_dest_routine_queue_2;
}
public void setOrdDestRoutineQueueDflt(String ord_dest_routine_queue_dflt){
this.ord_dest_routine_queue_dflt=ord_dest_routine_queue_dflt;
}
public void setOrdDestStatQueue1(String ord_dest_stat_queue_1){
this.ord_dest_stat_queue_1=ord_dest_stat_queue_1;
}
public void setOrdDestStatQueue2(String ord_dest_stat_queue_2){
this.ord_dest_stat_queue_2=ord_dest_stat_queue_2;
}
public void setOrdDestStatQueueDflt(String ord_dest_stat_queue_dflt){
this.ord_dest_stat_queue_dflt=ord_dest_stat_queue_dflt;
}
public void setPrintResAtDeptYn(String print_res_at_dept_yn){
this.print_res_at_dept_yn=print_res_at_dept_yn;
}

public void setResDeptRoutingQueue1(String res_dept_routing_queue_1){
this.res_dept_routing_queue_1=res_dept_routing_queue_1;
}

public void setResDeptRoutingQueue2(String res_dept_routing_queue_2){
this.res_dept_routing_queue_2=res_dept_routing_queue_2;
}

public void setResDeptRoutingQueueD(String res_dept_routing_queue_d){
this.res_dept_routing_queue_dflt=res_dept_routing_queue_d;
}

	public void setResDeptStatQueue1(String res_dept_stat_queue_1){
	this.res_dept_stat_queue_1=res_dept_stat_queue_1;
	}

public void setResDeptStatQueue2(String res_dept_stat_queue_1){
	this.res_dept_stat_queue_2=res_dept_stat_queue_1;
	}

	public void setResDeptStatQueueD(String res_dept_stat_queue_d){
	this.res_dept_stat_queue_dflt=res_dept_stat_queue_d;
	}



	public void setOrderTypeInstruction(String order_type_instruction){
		this.order_type_instruction = order_type_instruction;
	}

	public void setPrintResPatlocYn(String print_res_patloc_yn){
this.print_res_patloc_yn=print_res_patloc_yn;
}
	public void setPerforming_location_code(String performing_location_code){
		this.performing_location_code=performing_location_code;
	}
	//IN042962
	public void setPrint_option(String print_option){
		this.print_option=print_option;
	}
	




////////////////getter method for all variable of this function

	public String getOperatingFacilityId(){
		return this.operating_facility_id;
	}

	public String getOrderTypeCode(){
		return order_type_code;
	}

	public String getPatientClass(){
		return patient_class;
	}
	//////////////////////////////////////////////
	public String getprint_dept_loc1(){
		
		return this.print_dept_loc1;
	
	}
	public String getprint_dept_loc2(){
		
		return this.print_dept_loc2;
	
	}
	public String getprint_report_dept_loc_radio(){
		
		return this.print_report_dept_loc_radio;
	
	}

public String getprint_urg_dept_loc1(){
		
		return this.print_urg_dept_loc1;
	
	}
	public String getprint_urg_dept_loc2(){
		
		return this.print_urg_dept_loc2;
	
	}
	public String getprint_report_urg_dept_loc_radio(){
		
		return this.print_report_urg_dept_loc_radio;
	
	}


	//////////////////////////////////////////////
	public String getdisloc()
	{
	return PRINT_RES_FOR_DISCH_PAT_LOCN;
	}
	
	public String getPrintOrdAtSrcYn(){return this.print_ord_at_src_yn;}

	public String getPrintOrdAtConsentSrcYn(){return this.print_cons_at_src_yn;}

	public String getPrintOrdAtRefusalSrcYn(){return this.print_refu_at_src_yn;}

	public String getPrintOrdAtReferralSrcYn(){return this.print_referral_at_src_yn;}
	
	public String getOrderTypeInstruction(){
		return order_type_instruction;
	}

	public String getPrintConsentYn(){
		return print_consent_yn;
	}

	public String getConsentRoutineQueue1(){
		return consent_routing_queue_1;
	}

	public String getConsentRoutineQueue2(){
		return consent_routing_queue_2;
	}


	public String getConsentUrgStatQueue1(){
		return consent_urg_stat_queue_1;
	}

		public String getConsentUrgStatQueue2(){
		return consent_urg_stat_queue_2;
	}
	public String getprint_ord_dest_yn(){
	return this.print_ord_dest_yn;
}
	public String getRefusalPrintOrdDestYn(){
	return this.print_refusal_at_dest_yn;
}

public String getRefusalDestRoutineQueue1(){
return this. refusal_dest_routine_queue_1;
}
public String getRefusalDestRoutineQueue2(){
return this.refusal_dest_routine_queue_2;
}
public String getRefusalDestRoutineQueueDflt(){
return this.refusal_dest_rout_queue_dflt;
}
public String getRefusalDestStatQueue1(){
return this.refusal_dest_stat_queue_1;
}
public String getRefusalDestStatQueue2(){
return this.refusal_dest_stat_queue_2;
}
public String getRefusalDestStatQueueDflt(){
return this.refusal_dest_stat_queue_dflt;
}

//added on 9.11.2004

public String getReferralPrintOrdDestYn(){
	return this.print_referral_at_dest_yn;
}
public String getReferralDestRoutineQueue1(){
return this. referral_dest_routine_queue_1;
}
public String getReferralDestRoutineQueue2(){
return this.referral_dest_routine_queue_2;
}
public String getReferralDestRoutineQueueDflt(){
return this.referral_dest_rout_queue_dflt;
}
public String getReferralDestStatQueue1(){
return this.referral_dest_stat_queue_1;
}
public String getReferralDestStatQueue2(){
return this.referral_dest_stat_queue_2;
}
public String getReferralDestStatQueueDflt(){
return this.referral_dest_stat_queue_dflt;
}

//end of added on 9.11.2004

public String getOrdDestRoutineQueue1(){
return this.ord_dest_routine_queue_1;
}
public String getOrdDestRoutineQueue2(){
	return this.ord_dest_routine_queue_2;
}
public String getOrdDestRoutineQueueDflt(){
return this.ord_dest_routine_queue_dflt;
}
public String getOrdDestStatQueue1(){
 return this.ord_dest_stat_queue_1;
}
public String getOrdDestStatQueue2(){
 return this.ord_dest_stat_queue_2;
}

public String getOrdDestStatQueueDflt(){
 return this.ord_dest_stat_queue_dflt;
}
public String getPrintResAtDeptYn(){
return this.print_res_at_dept_yn;
}

public String getResDeptRoutingQueue1(){
return this.res_dept_routing_queue_1;
}


public String getResDeptRoutingQueue2(){
return this.res_dept_routing_queue_2;
}




public String getResDeptStatQueue1(){
return 	this.res_dept_stat_queue_1;
	}
	public String getResDeptStatQueue2(){
return 	this.res_dept_stat_queue_2;
	}

public String  getResDeptRoutingQueueD(){
return this.res_dept_routing_queue_dflt;
}


	public String getPrintResPatlocYn(){
return this.print_res_patloc_yn;
}

public String getResDeptStatQueueD(){
	return this.res_dept_stat_queue_dflt;
	}

	public String getPerforming_location_code(){
		return this.performing_location_code;
	}
	//IN042962
	public String getPrint_option(){
		return this.print_option;
	}
	



public String getComboString()throws Exception {
Connection 	connection  = null;
java.sql.ResultSet rs	= null;
java.sql.PreparedStatement pstmt		= null;
	try {
		connection  = getConnection();
		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST"));
		pstmt.setString(1,language_id);
		rs		= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();

		while (rs.next()){
				String  codeCol			    = ChkDef.defaultString(rs.getString(2));
				String  codeDesc			= ChkDef.defaultString(rs.getString(1));
			    sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 return str.substring(0, str.length()-1);
	}catch(Exception e){
		System.out.println(e.getMessage());
		return null;
	}finally{
		
		closeResultSet( rs ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection);

	}
}

   /*ADDED BY SIVA KUMAR 20/8/2003 FOR ADDING CATEGORY FUNCTIONALITY*/
   	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}
    public ArrayList getOrderTypeData(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(order_category.equals(""))
			order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_ORD_ORDER_TYPE_SELECT") ) ;
			pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}
   /*END ADDING BY SIVA KUMAR 20/8/2003*/

	public ArrayList getPrintOrders() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList printOrders = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_ORD_CODE_SELECT")) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("order_type_code");
				record[1] = resultSet.getString("short_desc");
				printOrders.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return printOrders;
	}
	///////////////////////////////////////
	public ArrayList getUpdateRecord(String order_code ,String patintClass,String facilityId) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList allValue=new ArrayList();
		
		try {
		connection = getConnection() ;
		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_CLASS_QUERY_UPDATE_SELECT1")) ;
		pstmt.setString(1,order_code);
		pstmt.setString(2,patintClass);
		pstmt.setString(3,facilityId);
		//	allValue.add(order_code);
		//	allValue.add(patintClass);
		//	allValue.add(facilityId);
		resultSet = pstmt.executeQuery() ;

			//ResultSetMetaData rsmd = resultSet.getMetaData();
					//allValue.add(rsmd.getColumnCount());
			while ( resultSet != null && resultSet.next() )
				{

					allValue.add((String)resultSet.getString(1));
					allValue.add((String)resultSet.getString(2));
					allValue.add((String)resultSet.getString(3));
					allValue.add((String)resultSet.getString(4));
					allValue.add((String)resultSet.getString(5));
					allValue.add((String)resultSet.getString(6));
					allValue.add((String)resultSet.getString(7));
					allValue.add((String)resultSet.getString(8));
					allValue.add((String)resultSet.getString(9));
					allValue.add((String)resultSet.getString(10));
					allValue.add((String)resultSet.getString(11));
					allValue.add((String)resultSet.getString(12));
					allValue.add((String)resultSet.getString(13));
					allValue.add((String)resultSet.getString(14));
					allValue.add((String)resultSet.getString(15));
					allValue.add((String)resultSet.getString(16));
					allValue.add((String)resultSet.getString(17));
					allValue.add((String)resultSet.getString(18));
					allValue.add((String)resultSet.getString(19));
					allValue.add((String)resultSet.getString(20));
					allValue.add((String)resultSet.getString(21));
					allValue.add((String)resultSet.getString(22));
					allValue.add((String)resultSet.getString(23));
					allValue.add((String)resultSet.getString(24));
					allValue.add((String)resultSet.getString(25));
					allValue.add((String)resultSet.getString(26));
					allValue.add((String)resultSet.getString(27));
					allValue.add((String)resultSet.getString(28));
					allValue.add((String)resultSet.getString(29));
					allValue.add((String)resultSet.getString(30));
					allValue.add((String)resultSet.getString(31));
					allValue.add((String)resultSet.getString(32));
					allValue.add((String)resultSet.getString(33));
					allValue.add((String)resultSet.getString(34));
					allValue.add((String)resultSet.getString(35));
					allValue.add((String)resultSet.getString(36));
					allValue.add((String)resultSet.getString(37));
					allValue.add((String)resultSet.getString(38));
					allValue.add((String)resultSet.getString(39));
					allValue.add((String)resultSet.getString(40));
					allValue.add((String)resultSet.getString(41));
					allValue.add((String)resultSet.getString(42));
					allValue.add((String)resultSet.getString(43));
					allValue.add((String)resultSet.getString(44));
					allValue.add((String)resultSet.getString(45));
					allValue.add((String)resultSet.getString(46));
					allValue.add((String)resultSet.getString(47));
					allValue.add((String)resultSet.getString(48));
					allValue.add((String)resultSet.getString(49));
					allValue.add((String)resultSet.getString(50));
					allValue.add((String)resultSet.getString(51));
					allValue.add((String)resultSet.getString(52));
					allValue.add((String)resultSet.getString(53));
					allValue.add((String)resultSet.getString(54));//IN042962	
					
			}
		} catch ( Exception e )	{
			allValue.add(e);
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return allValue;
	}

//////////////////////////////////////////
	public ArrayList getPrintClass() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList printClass = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST")) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("short_desc");
				record[1] = resultSet.getString("patient_class");
				printClass.add(record);
			}
			String record[] = new String[2];
			record[0]="All";
			record[1]="*A";
			printClass.add(record);
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return printClass;
	}


//////////////////////////////////////////////////

	public String getLocation() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRINT_LOCATION")) ;
			pstmt.setString(1,operating_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				//String record = new String();
				LocationClass = resultSet.getString("print_res_at_othloc");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		return LocationClass;
	}

/////////////////////////////////////////////////////////
	public String getLocationForDisPat() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_DISPH_LOCATION")) ;
			pstmt.setString(1,operating_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("print_res_for_disch_pat");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		return LocationClass;
	}
	////////////////////////
	public String getPrintAtDept() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_PRINT_DESTN") ) ;
			pstmt.setString(1,operating_facility_id);

			resultSet = pstmt.executeQuery() ;
			//System.out.println("####operating_facility_id,befer resultset="+operating_facility_id);
			if ( resultSet != null && resultSet.next() ) {
				//System.out.println("####operating_facility_id="+operating_facility_id);
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_RES_AT_DEPT_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		//System.out.println("###in OrderPrintingRoutingBean.java,LocationClass="+LocationClass);
	return LocationClass;
	}
////////////////

public String getPrintAtRefusalDest() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;

			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_REFUSAL_DESTN") ) ;
			pstmt.setString(1,operating_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_REFU_AT_DEST_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		return LocationClass;
	}
//added by on 9.11.2004

public String getPrintAtReferralDest() throws Exception {
Connection connection 		= null;
PreparedStatement pstmt 	= null;
ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_REFERRAL_DESTN") ) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_REFERRAL_AT_DEST_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}

/////////////////end of added on 9.11.2004
public String getPrintAtDest() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_ORD_DESTN")) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_ORD_AT_DEST_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}
//////////////////
public String getPrintConsYn() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_PRINT_CONS")) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_CONS_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}
/////////////////
public String getPrintAtSrc() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_ORD_SRC") ) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_ORD_AT_SRC_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}
//////////////////
public String getPrintAtConsentSrc() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_CONS_SRC") ) ;
			pstmt.setString(1, login_facility_id); 
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_CONS_AT_SRC_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}
//////////////////////////
public String getPrintAtRefusalSrc() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_REFUSAL_SRC") ) ;
			pstmt.setString(1, login_facility_id);

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_REFU_AT_SRC_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
	return LocationClass;
	}
//added on 9.11.2004
	public String getPrintAtReferralSrc() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String LocationClass = "N";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_REFERRAL_SRC") ) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass = resultSet.getString("PRINT_REFERRAL_AT_SRC_YN");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
	return LocationClass;
	}
/////////////////end of added on 9.11.2004

	public String[] getDefaultLocation() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String[] LocationClass = new String[2];
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTH_QUEUE")) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
			//	String record = new String();
				LocationClass[0] = resultSet.getString("OTHLOC_QUEUE_NAME");
				LocationClass[1] = resultSet.getString("DISCH_PAT_QUEUE_NAME");

			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		return LocationClass;
	}

///////////////////////////////////////////////////////

public ArrayList getLocationSpecific() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList LocationClass = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT")) ;
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,operating_facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString(1);
				record[1] = resultSet.getString(2);
				LocationClass.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}
/*Added By Siva Kumr for Location Type Enhancements - 28/8/2003*/
public ArrayList getLocationSpecific(String locType) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList LocationClass = new ArrayList();
		try {
			connection = getConnection() ;
            if (locType != null && locType.equals("C")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTC")) ;
                pstmt.setString(1,operating_facility_id);
            }
            else if (locType != null && locType.equals("N")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTN")) ;
                pstmt.setString(1,operating_facility_id);
            }
            else {
                pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT")) ;
                pstmt.setString(1,operating_facility_id);
                pstmt.setString(2,operating_facility_id);
            }
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[3];
				record[0] = resultSet.getString("location_code");
				record[1] = resultSet.getString("location_desc");
                record[2] = resultSet.getString("Locn_Type");
                //System.out.println("Loc_Type" + record[2]);
				LocationClass.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
return LocationClass;
	}

////////////////End of Addition by Siva Kumar///////////////////////////////

public ArrayList getLocationSpecificForDisch() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList LocationClass = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_DISCHG_PAT_PRINT")) ;
			pstmt.setString(1,operating_facility_id);
//			pstmt.setString(2,facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString(1);
				record[1] = resultSet.getString(2);
				LocationClass.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
			
		}
		return LocationClass;

	}

// SQL_OR_PRINT_CLASS_SELECT="select short_desc,patient_class from am_patient_class select 'All'  short_desc,'*A' from dual order by1

///////////////////////

/*		dataMap.put("SQL_OR_ORDER_PRINT_LOCATION_INSERT",
"insert into or_order_type_routing
(order_type_code,
operating_facility_id,
patient_class,
print_consent_yn
,consent_routing_queue_1
,consent_routing_queue_2
,consent_routing_queue_dflt
,consent_urg_stat_queue_1
,consent_urg_stat_queue_2
,consent_urg_stat_queue_dflt
,print_ord_dest_yn
,ord_dest_routine_queue_1
,ord_dest_routine_queue_2
,ord_dest_routine_queue_dflt
,ord_dest_stat_queue_1
,ord_dest_stat_queue_2
,ord_dest_stat_queue_dflt
,print_ord_at_src_yn
,print_res_at_dept_yn
,res_dept_routing_queue_1
,res_dept_routing_queue_2
,res_dept_routing_queue_dflt
,res_dept_stat_queue_1
,res_dept_stat_queue_2
,res_dept_stat_queue_dflt
,print_res_patloc_yn
,print_res_at_othloc
,othloc_queue_name
,print_res_for_disch_pat
,dish_pat_queue_name
,order_type_instruction
,added_by_id
,added_at_ws_no
,added_facility_id
,modified_by_id
,modified_at_ws_no
,modified_facility_id
,added_date
,modified_date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)");
*/
/////////////////////
	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData=new ArrayList();

		insertData.add(order_type_code);

		insertData.add(operating_facility_id);
		insertData.add(patient_class);

		insertData.add(print_consent_yn);
		insertData.add(consent_routing_queue_1 ) ;
		insertData.add(consent_routing_queue_2 ) ;
		insertData.add(consent_routing_queue_dflt ) ;
		insertData.add(consent_urg_stat_queue_1 ) ;
		insertData.add(consent_urg_stat_queue_2);
		insertData.add(consent_urg_stat_queue_dflt);
		insertData.add(print_ord_dest_yn);
		insertData.add(ord_dest_routine_queue_1);
		insertData.add(ord_dest_routine_queue_2 ) ;
		insertData.add(ord_dest_routine_queue_dflt ) ;
		insertData.add(ord_dest_stat_queue_1 ) ;
		insertData.add(ord_dest_stat_queue_2 ) ;
		insertData.add(ord_dest_stat_queue_dflt);
		insertData.add(print_ord_at_src_yn);
		insertData.add(print_res_at_dept_yn);
		insertData.add(res_dept_routing_queue_1);
		insertData.add(res_dept_routing_queue_2 ) ;
		insertData.add(res_dept_routing_queue_dflt ) ;
		insertData.add(res_dept_stat_queue_1 ) ;
		insertData.add(res_dept_stat_queue_2 ) ;
		insertData.add(res_dept_stat_queue_dflt);
		insertData.add(print_res_patloc_yn ) ;
		insertData.add(print_res_at_othloc ) ;
		insertData.add(othloc_queue_name ) ;
		insertData.add(print_res_for_disch_pat ) ;
		insertData.add(dish_pat_queue_name ) ;
		insertData.add(order_type_instruction ) ;
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(performing_location_code);
		insertData.add(print_cons_at_src_yn);
		insertData.add(print_refu_at_src_yn);
		insertData.add(print_refusal_at_dest_yn);
		insertData.add(refusal_dest_routine_queue_1);
		insertData.add(refusal_dest_routine_queue_2);
		insertData.add(refusal_dest_rout_queue_dflt);
		insertData.add(refusal_dest_stat_queue_1);
		insertData.add(refusal_dest_stat_queue_2);
		insertData.add(refusal_dest_stat_queue_dflt);
		insertData.add(PRINT_RES_FOR_DISCH_PAT_LOCN);
		insertData.add(print_dept_loc1);
		insertData.add(print_dept_loc2);
		insertData.add(print_report_dept_loc_radio);
		insertData.add(print_urg_dept_loc1);
		insertData.add(print_urg_dept_loc2);
		insertData.add(print_report_urg_dept_loc_radio);

//added on 9.11.2004

		insertData.add(print_referral_at_src_yn);
		insertData.add(print_referral_at_dest_yn);
		insertData.add(referral_dest_routine_queue_1);
		insertData.add(referral_dest_routine_queue_2);
		insertData.add(referral_dest_rout_queue_dflt);
		insertData.add(referral_dest_stat_queue_1);
		insertData.add(referral_dest_stat_queue_2);
		insertData.add(referral_dest_stat_queue_dflt);
		insertData.add(print_option);//IN042962
		//end of added on 9.11.2004

try{
	//insert into or_order_type_routing(order_type_code,	operating_facility_id,patient_class,print_consent_yn,consent_routing_queue_1,consent_routing_queue_2,consent_routing_queue_dflt,consent_urg_stat_queue_1,consent_urg_stat_queue_2,consent_urg_stat_queue_dflt,print_ord_dest_yn,ord_dest_routine_queue_1,ord_dest_routine_queue_2,ord_dest_routine_queue_dflt,ord_dest_stat_queue_1,ord_dest_stat_queue_2,ord_dest_stat_queue_dflt,print_ord_at_src_yn,print_res_at_dept_yn,res_dept_routing_queue_1,res_dept_routing_queue_2,res_dept_routing_queue_dflt,res_dept_stat_queue_1,res_dept_stat_queue_2,res_dept_stat_queue_dflt,print_res_patloc_yn,print_res_at_othloc,othloc_queue_name,print_res_for_disch_pat,dish_pat_queue_name,order_type_instruction,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)")
	    sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_ORDER_PRINT_LOCATION_INSERT") );
sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_ORDER_PRINT_ROUTING_DUPLICATE_CHK"));
}catch(Exception e){System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;}


	/*(?,?,?,?,?
		,?,?,?,?,?
		,?,?,?,?,?
		,?,?,?,?,?
		,?,?,?,?,?
		,?,?,?,?,?
		,?,?,?,?,?
		,?,?,sysdate,sysdate)*/
		whereData.add(order_type_code);
		whereData.add(patient_class);
		whereData.add(login_facility_id);

		traceVals.append("calling get result method");
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		tabData.put( "WhereData",whereData);
		map.put("traceVal", tabData.toString());

		//System.out.println("=====tabData==="+tabData);
		//System.out.println("=====sqlMap==="+sqlMap);
		return getResult(tabData,sqlMap) ;



	}




	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList modifyData = new ArrayList() ;

		modifyData.add(print_consent_yn);
		modifyData.add(consent_routing_queue_1 ) ;
		modifyData.add(consent_routing_queue_2 ) ;
		modifyData.add(consent_routing_queue_dflt ) ;
		modifyData.add(consent_urg_stat_queue_1 ) ;
		modifyData.add(consent_urg_stat_queue_2);
		modifyData.add(consent_urg_stat_queue_dflt);
		modifyData.add(print_ord_dest_yn);
		modifyData.add(ord_dest_routine_queue_1);
		modifyData.add(ord_dest_routine_queue_2 ) ;
		modifyData.add(ord_dest_routine_queue_dflt ) ;
		modifyData.add(ord_dest_stat_queue_1 ) ;
		modifyData.add(ord_dest_stat_queue_2 ) ;
		modifyData.add(ord_dest_stat_queue_dflt);
		modifyData.add(print_ord_at_src_yn);
		modifyData.add(print_res_at_dept_yn);
		modifyData.add(res_dept_routing_queue_1);
		modifyData.add(res_dept_routing_queue_2 ) ;
		modifyData.add(res_dept_routing_queue_dflt ) ;
		modifyData.add(res_dept_stat_queue_1 ) ;
		modifyData.add(res_dept_stat_queue_2 ) ;
		modifyData.add(res_dept_stat_queue_dflt);
		modifyData.add(print_res_patloc_yn ) ;
		modifyData.add(print_res_at_othloc ) ;
		modifyData.add(othloc_queue_name ) ;
		modifyData.add(print_res_for_disch_pat ) ;
		modifyData.add(dish_pat_queue_name ) ;
		modifyData.add(order_type_instruction ) ;
		modifyData.add(performing_location_code);
		
		modifyData.add(print_cons_at_src_yn);
		modifyData.add(print_refu_at_src_yn);
		modifyData.add(print_refusal_at_dest_yn);
		modifyData.add(refusal_dest_routine_queue_1);
		modifyData.add(refusal_dest_routine_queue_2);
		modifyData.add(refusal_dest_rout_queue_dflt);
		modifyData.add(refusal_dest_stat_queue_1);
		modifyData.add(refusal_dest_stat_queue_2);
		modifyData.add(refusal_dest_stat_queue_dflt);
		modifyData.add(PRINT_RES_FOR_DISCH_PAT_LOCN);
		modifyData.add(print_dept_loc1);
		modifyData.add(print_dept_loc2);
		modifyData.add(print_report_dept_loc_radio);
		modifyData.add(print_urg_dept_loc1);
		modifyData.add(print_urg_dept_loc2);
		modifyData.add(print_report_urg_dept_loc_radio);

//added on  9.11.2004

		modifyData.add(print_referral_at_src_yn);
		modifyData.add(print_referral_at_dest_yn);
		modifyData.add(referral_dest_routine_queue_1);
		modifyData.add(referral_dest_routine_queue_2);
		modifyData.add(referral_dest_rout_queue_dflt);
		modifyData.add(referral_dest_stat_queue_1);
		modifyData.add(referral_dest_stat_queue_2);
		modifyData.add(referral_dest_stat_queue_dflt);
		modifyData.add(print_option);//IN042962
		//end of added on 9.11.2004
		
		modifyData.add(order_type_code);
		modifyData.add(patient_class);
		modifyData.add(operating_facility_id);
		try{
	    sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_PRINT_CLASS_QUERY_UPDATE_NEW" ));
		}catch(Exception e){System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;}

		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
		map.put("traceVal", tabData.toString());
		return getResult(tabData,sqlMap) ;
		//return map;


	}

	public HashMap delete(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList deleteData = new ArrayList() ;

		deleteData.add(order_type_code);
		deleteData.add(patient_class);
		deleteData.add(operating_facility_id);
		deleteData.add(performing_location_code);
		//System.out.println("order_type_code="+order_type_code+",patient_class="+patient_class+",operating_facility_id="+operating_facility_id+",performing_location_code="+performing_location_code);

		try{
	    	sqlMap.put("DeleteSQL",OrRepository.getOrKeyValue("SQL_OR_PRINT_CLASS_QUERY_DELETE" ));
		}catch(Exception e){System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;}

		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteData",deleteData);
		map.put("traceVal", tabData.toString());
		return getResult(tabData,sqlMap) ;
		//return map;

	}

/**********This Method  Actually Calls the EJB's Method ********************/

private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;
		traceVals.append("  ::in the  get result method::");
		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;
			*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		    Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				// conversions map = remote.delete(tabData, sqlMap ) ;
				//return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				//traceVals.append("calling  insert of single table handler");
				//conversions map = remote.insert(tabData, sqlMap ) ;
			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				//conversions map = remote.modify(tabData, sqlMap ) ;
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
			argArray		= null;
			paramArray	= null;


			
			String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		//System.out.println("===result==="+result);
		 if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			//System.out.println("===coming here===");
			map.put( "result", new Boolean( false ) ) ;
			//System.out.println("==message=="+message);
			
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				//System.out.println("===message==="+message);
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				
				//System.out.println("===map=="+map);
				//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
			//System.out.println("inMessage:"+message);
			map.put("traceVals",traceVals);
			//System.out.println("inTraceVal:"+traceVals);
			

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		
	  }finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}
return map;
 }//End of Method
///////// set all method

	public void setAll( Hashtable recordSet ) {
		setMode((String)recordSet.get("mode"));
//		if(!(recordSet==null)){
		//multipleMap=recordSet;
//		}
		///////
		if(recordSet.containsKey("print_dept_loc111")){
		set_print_dept_loc1(nullCheck(((String)recordSet.get("print_dept_loc111")).trim()));}

		if(recordSet.containsKey("print_dept_loc211")){
		set_print_dept_loc2(nullCheck(((String)recordSet.get("print_dept_loc211")).trim()));}


		if(recordSet.containsKey("print_report_dept_loc_radio11")){
		set_print_report_dept_loc_radio(nullCheck(((String)recordSet.get("print_report_dept_loc_radio11")).trim()));}

if(recordSet.containsKey("print_urg_dept_loc111")){
		set_print_urg_dept_loc1(nullCheck(((String)recordSet.get("print_urg_dept_loc111")).trim()));}

		if(recordSet.containsKey("print_urg_dept_loc211")){
		set_print_urg_dept_loc2(nullCheck(((String)recordSet.get("print_urg_dept_loc211")).trim()));}

		if(recordSet.containsKey("print_report_urg_dept_loc_radio11")){
		set_print_report_urg_dept_loc_radio(nullCheck(((String)recordSet.get("print_report_urg_dept_loc_radio11")).trim()));}
		//////


		if(recordSet.containsKey("disPatLoc")){
		setdisloc(nullCheck(((String)recordSet.get("disPatLoc")).trim()));}
		
		if(recordSet.containsKey("order_type_code")){
		setOrderTypeCode(nullCheck(((String)recordSet.get("order_type_code")).trim()));}


		if(recordSet.containsKey("operating_facility_id")){
		setOperatingFacilityId(nullCheck(((String)recordSet.get("operating_facility_id")).trim()));}


		if(recordSet.containsKey("patient_class")){
		setPatientClass(nullCheck(((String)recordSet.get("patient_class")).trim()));}


		if(recordSet.containsKey("print_consent_form_order")){
		setPrintConsentYn(((String)recordSet.get("print_consent_form_order")).trim());
		}
		
		if(recordSet.containsKey("print_at_refu_dest1")){
		setRefusalPrintOrdDestYn(((String)recordSet.get("print_at_refu_dest1")).trim());
		}
		if(recordSet.containsKey("print_rout_ref_loc1")){
		setRefusalDestRoutineQueue1(nullCheck(((String)recordSet.get("print_rout_ref_loc1")).trim()));}

		if(recordSet.containsKey("print_rout_ref_loc2")){
		setRefusalDestRoutineQueue2(nullCheck(((String)recordSet.get("print_rout_ref_loc2")).trim()));}
			
		if(recordSet.containsKey("refusal_dest_rout_queue_dflt")){
		setRefusalDestRoutineQueueDflt(nullCheck(((String)recordSet.get("refusal_dest_rout_queue_dflt")).trim()));}
			
		if(recordSet.containsKey("print_urg_ref_loc1")){
		setRefusalDestStatQueue1(nullCheck(((String)recordSet.get("print_urg_ref_loc1")).trim()));}
			
		if(recordSet.containsKey("print_urg_ref_loc2")){
		setRefusalDestStatQueue2(nullCheck(((String)recordSet.get("print_urg_ref_loc2")).trim()));}
			
		if(recordSet.containsKey("refusal_dest_stat_queue_dflt")){
		setRefusalDestStatQueueDflt(nullCheck(((String)recordSet.get("refusal_dest_stat_queue_dflt")).trim()));}
		
		//added on 9.11.2004
			
		if(recordSet.containsKey("print_at_referral_dest1")){
		setReferralPrintOrdDestYn(((String)recordSet.get("print_at_referral_dest1")).trim());
		}
		if(recordSet.containsKey("print_rout_referral_loc1")){
		setReferralDestRoutineQueue1(nullCheck(((String)recordSet.get("print_rout_referral_loc1")).trim()));}

		if(recordSet.containsKey("print_rout_referral_loc2")){
		setReferralDestRoutineQueue2(nullCheck(((String)recordSet.get("print_rout_referral_loc2")).trim()));}
			
		if(recordSet.containsKey("referral_dest_rout_queue_dflt")){
		setReferralDestRoutineQueueDflt(nullCheck(((String)recordSet.get("referral_dest_rout_queue_dflt")).trim()));}
			
		if(recordSet.containsKey("print_urg_referral_loc1")){
		setReferralDestStatQueue1(nullCheck(((String)recordSet.get("print_urg_referral_loc1")).trim()));}
			
		if(recordSet.containsKey("print_urg_referral_loc2")){
		setReferralDestStatQueue2(nullCheck(((String)recordSet.get("print_urg_referral_loc2")).trim()));}
			
		if(recordSet.containsKey("referral_dest_stat_queue_dflt")){
		setReferralDestStatQueueDflt(nullCheck(((String)recordSet.get("referral_dest_stat_queue_dflt")).trim()));}
			
	//end of added on 9.11.2004

		if(recordSet.containsKey("consent_rout_loc1")){
		setConsentRoutineQueue1(nullCheck(((String)recordSet.get("consent_rout_loc1")).trim()));}


		if(recordSet.containsKey("consent_rout_loc2")){
		setConsentRoutineQueue2(nullCheck(((String)recordSet.get("consent_rout_loc2")).trim()));}


		if(recordSet.containsKey("consent_routing_queue_dflt")){
		setConsentRoutingQueueD(nullCheck(((String)recordSet.get("consent_routing_queue_dflt")).trim()));
		}


		if(recordSet.containsKey("consent_urg_loc1")){
		setConsentUrgStatQueue1(nullCheck(((String)recordSet.get("consent_urg_loc1")).trim()));}


		if(recordSet.containsKey("consent_urg_loc2")){
		setConsentUrgStatQueue2(nullCheck(((String)recordSet.get("consent_urg_loc2")).trim()));}


		if(recordSet.containsKey("consent_urg_stat_queue_dflt")){
		setConsentUrgStatQueueD(nullCheck(((String)recordSet.get("consent_urg_stat_queue_dflt")).trim()));}


		if(recordSet.containsKey("print_at_dest1")){
		setPrintOrdDestYn(nullCheck(((String)recordSet.get("print_at_dest1")).trim()));
		}


		if(recordSet.containsKey("print_rout_loc1")){
		setOrdDestRoutineQueue1(nullCheck(((String)recordSet.get("print_rout_loc1")).trim()));}


		if(recordSet.containsKey("print_rout_loc2")){
		setOrdDestRoutineQueue2(nullCheck(((String)recordSet.get("print_rout_loc2")).trim()));}


		if(recordSet.containsKey("ord_dest_routine_queue_dflt")){
		setOrdDestRoutineQueueDflt(nullCheck(((String)recordSet.get("ord_dest_routine_queue_dflt")).trim()));}


		if(recordSet.containsKey("print_urg_loc1")){
		setOrdDestStatQueue1(nullCheck(((String)recordSet.get("print_urg_loc1")).trim()));}


		if(recordSet.containsKey("print_urg_loc2")){
		setOrdDestStatQueue2(nullCheck(((String)recordSet.get("print_urg_loc2")).trim()));}


		if(recordSet.containsKey("ord_dest_stat_queue_dflt")){
		setOrdDestStatQueueDflt(nullCheck(((String)recordSet.get("ord_dest_stat_queue_dflt")).trim()));}


		if(recordSet.containsKey("printatsource1")){
		setPrintOrdAtSrcYn(nullCheck((String)recordSet.get("printatsource1")).trim());}
		
		if(recordSet.containsKey("printatconsentsource1")){
		setPrintOrdAtConsentSrcYn(nullCheck((String)recordSet.get("printatconsentsource1")).trim());}

		if(recordSet.containsKey("printatrefusalsource1")){
		setPrintOrdAtRefusalSrcYn(nullCheck((String)recordSet.get("printatrefusalsource1")).trim());}

		if(recordSet.containsKey("printatreferralsource1")){
		setPrintOrdAtReferralSrcYn(nullCheck((String)recordSet.get("printatreferralsource1")).trim());}


		if(recordSet.containsKey("print_at_dept_new"))
			{
				setPrintResAtDeptYn(nullCheck((String)recordSet.get("print_at_dept_new")).trim());
			}


		if(recordSet.containsKey("print_dept_loc1")){
		setResDeptRoutingQueue1(nullCheck(((String)recordSet.get("print_dept_loc1")).trim()));}


		if(recordSet.containsKey("print_dept_loc2")){
		setResDeptRoutingQueue2(nullCheck(((String)recordSet.get("print_dept_loc2")).trim()));}


		if(recordSet.containsKey("res_dept_routing_queue_dflt")){
		setResDeptRoutingQueueD(nullCheck(((String)recordSet.get("res_dept_routing_queue_dflt")).trim()));}


		if(recordSet.containsKey("print_urg_dept_loc2")){
		setResDeptStatQueue2(nullCheck(((String)recordSet.get("print_urg_dept_loc2")).trim()));}

		if(recordSet.containsKey("print_urg_dept_loc1")){
			setResDeptStatQueue1(nullCheck(((String)recordSet.get("print_urg_dept_loc1")).trim()));}

		if(recordSet.containsKey("res_dept_stat_queue_dflt")){
			setResDeptStatQueueD(nullCheck(((String)recordSet.get("res_dept_stat_queue_dflt")).trim()));}



		if(recordSet.containsKey("otherloc")){
		setPrintResAtOthloc(nullCheck(((String)recordSet.get("otherloc")).trim()));
		}


		if(recordSet.containsKey("print_res_at_othloc")){
		setOthLocQueueName(nullCheck(((String)recordSet.get("print_res_at_othloc")).trim()));
		}

		if(recordSet.containsKey("otherlocdis")){
		setPrintResForDischPat(nullCheck(((String)recordSet.get("otherlocdis")).trim()));
		}


		if(recordSet.containsKey("print_des_at_othloc")){
		setDishPatQueueName(nullCheck(((String)recordSet.get("print_des_at_othloc")).trim()));
		}


		if(recordSet.containsKey("order_type_instruction")){
		setOrderTypeInstruction(nullCheck(((String)recordSet.get("order_type_instruction")).trim()));
		}

		if(recordSet.containsKey("performing_location_code")){
		setPerforming_location_code(nullCheck(((String)recordSet.get("performing_location_code")).trim()));
		}
		//IN042962
		if(recordSet.containsKey("print_option")){
			setPrint_option(nullCheck(((String)recordSet.get("print_option")).trim()));
		}
		

	}

	private String nullCheck(String check){
	return ((check.equals("")||check==null))? (""):(check);
	}

	public ArrayList getPerformingLocn(String orderType,String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList LocationClass = new ArrayList();
		try {
		//	boolean installed = false;
			connection = getConnection() ;

			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_PRINT_ROUTING_PERFORMING_LOCN")) ;

			pstmt.setString(1,facility_id);
            pstmt.setString(2,orderType);

            resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("short_desc");
				record[1] = resultSet.getString("code");
                LocationClass.add(record);
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
			
		}
	return LocationClass;
	}

}
