/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*	Module			: ePH
	Function		: Drug Information Enquiry
	Class Name		: DrugInfoEnquiryManager
	Created By		: Karabi Sarma
	Created Date	: 
*/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/13/2017      63877   		chithra      UnusedLocal variable
---------------------------------------------------------------------------------------------------------------
*/
package ePH.DrugInfoEnquiry ;

import java.rmi.* ;
import java.sql.* ;
import javax.ejb.* ;
import java.io.* ;
import java.util.* ;
import ePH.Common.PhEJBSessionAdapter ;
/**
*
* @ejb.bean
*	name="DrugInfoEnquiry"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="DrugInfoEnquiry"
*	local-jndi-name="DrugInfoEnquiry"
*	impl-class-name="ePH.DrugInfoEnquiry.DrugInfoEnquiryManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.DrugInfoEnquiry.DrugInfoEnquiryLocal"
*	remote-class="ePH.DrugInfoEnquiry.DrugInfoEnquiryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.DrugInfoEnquiry.DrugInfoEnquiryLocalHome"
*	remote-class="ePH.DrugInfoEnquiry.DrugInfoEnquiryHome"
*	generate= "local,remote"
*
*
*/

public class DrugInfoEnquiryManager extends PhEJBSessionAdapter {
	Properties prop=null;
	HashMap				IR_FLAG		=	new HashMap();
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert (HashMap tabData , HashMap sqlMap ) {
		
		//String debug =""; Unused local variable INC63877
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "In Insert ") ;
		map.put("msgid","INSERT");
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		PreparedStatement pstmt1	=	null ;
		PreparedStatement pstmt2	=	null ;
		PreparedStatement pstmt3	=	null ;
		//ResultSet resultSet3		=	null ;  Unused local variable INC63877
		boolean insert_rec_1		=	false;
		boolean insert_rec_2		=	false;
		boolean insert_rec_3		=	false;
		boolean insert_rec_4		=	false;
		boolean insert_rec_5		=	false;
		//boolean insert_rec_6		=	false;Unused local variable INC63877
		boolean insert_rec_7		=	false;
		boolean insert_rec_8		=	false;
		int result					=	0;
		//String resp_time			=	"" ; Unused local variable INC63877
		CallableStatement	cstmt_insert	=null;
		CallableStatement	cstmt_insert1	=null;
		CallableStatement	cstmt_insert2	=null;
		String success1				=	"";
		String success				=	"";

		String  facility_id				= ((String) tabData.get("facility_id"))==null?"":(String) tabData.get("facility_id");
		String facility_name			= ((String) tabData.get("facility_name"))==null?"":(String) tabData.get("facility_name");
		String pract_name				= ((String) tabData.get("Pract_name"))==null?"":(String) tabData.get("Pract_name");
		String pract_id					= ((String) tabData.get("pract_id"))==null?"":(String) tabData.get("pract_id");
		String designation				= ((String) tabData.get("designation"))==null?"":(String) tabData.get("designation");
		String pract_type				= ((String) tabData.get("pract_type"))==null?"":(String) tabData.get("pract_type");
		String priority					= ((String) tabData.get("priority"))==null?"":(String) tabData.get("priority");
		String other_priority			= ((String) tabData.get("other_priority"))==null?"":(String) tabData.get("other_priority");
		String enq_dt					= ((String) tabData.get("enq_dt"))==null?"":(String) tabData.get("enq_dt");
		String request_mode				= ((String) tabData.get("request_mode"))==null?"":(String) tabData.get("request_mode");
		String other_request_mode		= ((String) tabData.get("other_mode"))==null?"":(String) tabData.get("other_mode");
		String  addr_line1				= ((String) tabData.get("line1"))==null?"":(String) tabData.get("line1");
		String  rep_addr_line1			= ((String) tabData.get("rep_line1"))==null?"":(String) tabData.get("rep_line1");
		String  addr_line2				= ((String) tabData.get("line2"))==null?"":(String) tabData.get("line2");
		String  rep_addr_line2			= ((String) tabData.get("rep_line2"))==null?"":(String) tabData.get("rep_line2");
		String  addr_line3				= ((String) tabData.get("line3"))==null?"":(String) tabData.get("line3");
		String  rep_addr_line3			= ((String) tabData.get("rep_line3"))==null?"":(String) tabData.get("rep_line3");
		String  addr_line4				= ((String) tabData.get("line4"))==null?"":(String) tabData.get("line4");
		String  rep_addr_line4			= ((String) tabData.get("rep_line4"))==null?"":(String) tabData.get("rep_line4");
		String  tel_num					= ((String) tabData.get("tel_num"))==null?"":(String) tabData.get("tel_num");
		String  rep_tel_num				= ((String) tabData.get("rep_tel_num"))==null?"":(String) tabData.get("rep_tel_num");
		String  fac_num					= ((String) tabData.get("fac_num"))==null?"":(String) tabData.get("fac_num");
		String  rep_fac_num				= ((String) tabData.get("rep_fac_num"))==null?"":(String) tabData.get("rep_fac_num");
		String  email 					= ((String) tabData.get("email"))==null?"":(String) tabData.get("email");
		String  rep_email				= ((String) tabData.get("rep_email"))==null?"":(String) tabData.get("rep_email"); 
		//String  function_id				= ((String) tabData.get("function_id"))==null?"":(String) tabData.get("function_id");  //Commented for Common-ICN-0048
		
		//String  logged_fc_name			= ((String) tabData.get("logged_fc_name"))==null?"":(String) tabData.get("logged_fc_name");  //Commented for Common-ICN-0048
		//String  Sysdate					= ((String) tabData.get("sysdate"))==null?"":(String) tabData.get("sysdate");  //Commented for Common-ICN-0048
		//Request Form
		String  Request_dtl				= ((String) tabData.get("Request_dtl"))==null?"":(String) tabData.get("Request_dtl");
		String  p_user_name				= ((String) tabData.get("p_user_name"))==null?"":(String) tabData.get("p_user_name");
		String Req_catg					= ((String) tabData.get("Req_catg"))==null?"":(String) tabData.get("Req_catg");
		//Patient Form
		String  patient_id				= ((String) tabData.get("patient_id"))==null?"":(String) tabData.get("patient_id");
		String  patient_name			= ((String) tabData.get("patient_name"))==null?"":(String) tabData.get("patient_name");
		String  age						= ((String) tabData.get("age"))==null?"":(String) tabData.get("age");
		String  age_unit						= ((String) tabData.get("age_unit"))==null?"":(String) tabData.get("age_unit");
		String  gender					= ((String) tabData.get("gender"))==null?"":(String) tabData.get("gender");
		String  ethnic_grp				= ((String) tabData.get("ethnic_grp"))==null?"":(String) tabData.get("ethnic_grp");
		String  drug_desc				= ((String) tabData.get("drug_desc"))==null?"":(String) tabData.get("drug_desc");
		String  food_desc				= ((String) tabData.get("food_desc"))==null?"":(String) tabData.get("food_desc");
		String  other_desc				= ((String) tabData.get("other_desc"))==null?"":(String) tabData.get("other_desc");
		//Response form
		String  Response_dtl			= ((String) tabData.get("Response_dtl"))==null?"":(String) tabData.get("Response_dtl");
		String  response_remarks		= ((String) tabData.get("response_remarks"))==null?"":(String) tabData.get("response_remarks");
		//String  respond_btn				= ((String) tabData.get("respond"))==null?"":(String) tabData.get("respond");  //Commented for Common-ICN-0048
		String  response_dt				= ((String) tabData.get("response_dt"))==null?"":(String) tabData.get("response_dt");
		String  verified_by				= ((String) tabData.get("verified_by"))==null?"":(String) tabData.get("verified_by");
		String  Info_src				= ((String) tabData.get("Info_src"))==null?"":(String) tabData.get("Info_src");
		//String signed_by					= ((String) tabData.get("Signed_by"))==null?"":(String) tabData.get("Signed_by"); //Commented for Common-ICN-0048
		String signed_date_time					= ((String) tabData.get("Signed_Date_Time"))==null?"":(String) tabData.get("Signed_Date_Time");
		String login_facility_id	=		 ((String) tabData.get("login_facility_id"))==null?"":(String) tabData.get("login_facility_id");
		String login_by_id			= ((String) tabData.get("login_by_id"))==null?"":(String) tabData.get("login_by_id");
		String login_at_ws_no = ((String) tabData.get("login_at_ws_no"))==null?"":(String) tabData.get("login_at_ws_no");

		String Resp_Days = ((String) tabData.get("Resp_Days"))==null?"":(String) tabData.get("Resp_Days");
		String Resp_Hrs = ((String) tabData.get("Resp_Hrs"))==null?"":(String) tabData.get("Resp_Hrs");
		String Resp_Mins = ((String) tabData.get("Resp_Mins"))==null?"":(String) tabData.get("Resp_Mins");
		String Confidential_YN =((String) tabData.get("Confidential_YN"))==""?"N":(String) tabData.get("Confidential_YN");
		String Signed_verify_remarks =((String) tabData.get("Signed_verify_remarks"))==null?"":(String) tabData.get("Signed_verify_remarks");
		prop = (Properties)tabData.get( "properties" );	
	
		String Enquiry_num			="";
		StringTokenizer st3			=null;
		ArrayList ReqCatg_sys		= new ArrayList();
		String Req_catg_Sys			="";
		ArrayList ReqCatg			= new ArrayList();
	
		if(!Req_catg.equals("")){
			StringTokenizer st			= new StringTokenizer(Req_catg,"$");
			while (st.hasMoreTokens()){
				Req_catg_Sys =st.nextToken();
				st3			= new StringTokenizer(Req_catg_Sys,"**");
				while(st3.hasMoreTokens()){
					ReqCatg.add(st3.nextToken());
					ReqCatg_sys.add(st3.nextToken());
				}
			}
		}
		int no_of_catg					=	ReqCatg.size();
		String InfoSrc_str				=	"";
	//	ArrayList InfoSrc				=	 new ArrayList(); Unused local variable INC63877
		ArrayList InfoSrc_code			=	new ArrayList();
		StringTokenizer st2				=	null;
		if(!Info_src.equals("")){
			StringTokenizer st1			= new StringTokenizer(Info_src,"$");
			while (st1.hasMoreTokens()){
				InfoSrc_str=st1.nextToken();
				st2	=new StringTokenizer(InfoSrc_str,"**");
				while(st2.hasMoreTokens()){
					InfoSrc_code.add(st2.nextToken());
				}
			}
		}
		int no_of_info_src	=InfoSrc_code.size();
		try{
			connection = getConnection( prop ) ;
			pstmt1 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_HDR_SEQ_NO_SELECT")); 
			resultSet	= pstmt1.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				Enquiry_num	=resultSet.getString(1);
			}
			closeStatement(pstmt1);
			closeResultSet(resultSet);
			if(Enquiry_num==null) Enquiry_num="";
			if(!Enquiry_num.equals("")){
				pstmt = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_HDR_INSERT"));
				//pstmt = connection.prepareStatement("INSERT INTO PH_DRUG_ENQ_INFO_HDR(ENQUIRY_NO, SOURCE_OF_REQUEST,SOURCE_OF_REQUEST_DESC, ENQUIRER_ID, ENQUIRER_NAME, ENQUIRER_TYPE_CODE, ENQUIRER_TYPE_DESC, ENQUIRER_OTH, REQUEST_PRIORITY, REQUEST_OTH, ENQUIRY_DATE_TIME, REQUEST_MODE, REQUEST_MODE_DESC, CONTACT_ADDR1, CONTACT_ADDR2, CONTACT_ADDR3, CONTACT_ADDR4, CONTACT_TEL, CONTACT_FAX, CONTACT_EMAIL, REPLY_ADDR1, REPLY_ADDR2, REPLY_ADDR3, REPLY_ADDR4, REPLY_TEL, REPLY_FAX, REPLY_EMAIL, REQUEST_DTLS, ENQUIRY_RECD_BY, PATIENT_ID, PATIENT_NAME, PATIENT_AGE, PATIENT_AGE_UNIT, PATIENT_GENDER, PATIENT_ETHNIC_GRP, ALLERGY_DRUG, ALLERGY_FOOD, ALLERGY_OTH, RESPONSE_DTLS, REMARKS, RESPONSE_DATE_TIME, REPLIED_BY, VERIFIED_BY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,VERIFIED_DATE_TIME,RESPONDE_DAYS, RESPONSE_HOURS, RESPONSE_MINUTES,Confidential_YN) VALUES (?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?)"); 
				pstmt.setString(1,Enquiry_num);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,facility_name);
				pstmt.setString(4,pract_id);
				pstmt.setString(5,pract_name);
				pstmt.setString(6,pract_type);
				if(pract_type.equals("")){
					pstmt.setString(7,"");
					pstmt.setString(8,designation);
				}
				else{
					pstmt.setString(7,designation);
					pstmt.setString(8,"");
				}
				pstmt.setString(9,priority);
				pstmt.setString(10,other_priority);
				pstmt.setString(11,enq_dt);
				pstmt.setString(12,request_mode);
				pstmt.setString(13,other_request_mode);
				pstmt.setString(14,addr_line1);
				pstmt.setString(15,addr_line2);
				pstmt.setString(16,addr_line3);
				pstmt.setString(17,addr_line4);
				pstmt.setString(18,tel_num);
				pstmt.setString(19,fac_num);
				pstmt.setString(20,email);
				pstmt.setString(21,rep_addr_line1);
				pstmt.setString(22,rep_addr_line2);
				pstmt.setString(23,rep_addr_line3);
				pstmt.setString(24,rep_addr_line4);
				pstmt.setString(25,rep_tel_num);
				pstmt.setString(26,rep_fac_num);
				pstmt.setString(27,rep_email);
				pstmt.setString(28,Request_dtl);
				pstmt.setString(29,p_user_name);
				pstmt.setString(30,patient_id);
				pstmt.setString(31,patient_name);
				pstmt.setString(32,age);
				pstmt.setString(33,age_unit);
				pstmt.setString(34,gender);
				pstmt.setString(35,ethnic_grp);
				pstmt.setString(36,drug_desc);
				pstmt.setString(37,food_desc);
				pstmt.setString(38,other_desc);
				pstmt.setString(39,Response_dtl);
				pstmt.setString(40,response_remarks);
				if(!response_dt.equals("")){
					pstmt.setString(41,response_dt);
					pstmt.setString(42,login_by_id);
				}
				else{
					pstmt.setString(41,"");
					pstmt.setString(42,"");
				}
				if(!response_dt.equals("")){
					if(verified_by.equals("Y")){
						pstmt.setString(43,p_user_name);
					}
					else{
						pstmt.setString(43,"");
					}
				}
				else{
					pstmt.setString(43,"");
				}
				pstmt.setString(44,login_by_id);
				pstmt.setString(45,login_at_ws_no);
				pstmt.setString(46,login_facility_id);
				pstmt.setString(47,login_by_id);
				pstmt.setString(48,login_at_ws_no);
				pstmt.setString(49,login_facility_id);
				if(!response_dt.equals("")){
					if(verified_by.equals("Y")){
						pstmt.setString(50,signed_date_time);
					}
					else{
						pstmt.setString(50,"");
					}
				}
				else{
					pstmt.setString(50,"");
				}
				
				if(!response_dt.equals("")){
					pstmt.setString(51,Resp_Days);
					pstmt.setString(52,Resp_Hrs);
					pstmt.setString(53,Resp_Mins);
				}
				else{
					pstmt.setString(51,"0");
					pstmt.setString(52,"0");
					pstmt.setString(53,"0");
				}
				pstmt.setString(54,Confidential_YN);
				pstmt.setString(55,Signed_verify_remarks);

				result=pstmt.executeUpdate() ;
				
				if(result >0){
					insert_rec_1=true;
				}
				else{
					insert_rec_1=false;
				}
			}
			closeStatement(pstmt);
			if(insert_rec_1){
				cstmt_insert = connection.prepareCall("{call PH_DRUG_INFO_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
				cstmt_insert.setString(1, Enquiry_num);
				cstmt_insert.setString(2, enq_dt);
				cstmt_insert.setString(3, "@!");
				cstmt_insert.setString(4, "Y");
				cstmt_insert.setString(5, "Y");
				cstmt_insert.setString(6, login_at_ws_no);
				cstmt_insert.setString(7, login_facility_id);
				cstmt_insert.setString(8, login_at_ws_no);
				cstmt_insert.setString(9, login_facility_id);
				cstmt_insert.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert.execute();
				success1	= cstmt_insert.getString(10);
				if(success1.equals("Y")){
					insert_rec_4=true;
				}
				else{
					insert_rec_4=false;
				}
	            closeStatement(cstmt_insert);
			}

			if(insert_rec_4){
				cstmt_insert1 = connection.prepareCall("{call PH_DRUG_MTHLY_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
				cstmt_insert1.setString(1, Enquiry_num);
				cstmt_insert1.setString(2, enq_dt);
				cstmt_insert1.setString(3, "@!");
				cstmt_insert1.setString(4, "Y");
				cstmt_insert1.setString(5, "Y");
				cstmt_insert1.setString(6, login_at_ws_no);
				cstmt_insert1.setString(7, login_facility_id);
				cstmt_insert1.setString(8, login_at_ws_no);
				cstmt_insert1.setString(9, login_facility_id);
				cstmt_insert1.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert1.execute();
				success	= cstmt_insert1.getString(10);
				if(success.equals("Y")){
					insert_rec_5=true;
				}
				else{
					insert_rec_5=false;
				}
              closeStatement(cstmt_insert1);		
			}
			if(insert_rec_5){
				pstmt2 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT")); 
				for(int num=0;num<no_of_catg;num++){
					pstmt2.setString(1,Enquiry_num);
					pstmt2.setString(2,(String)ReqCatg.get(num));
					pstmt2.setString(3,login_by_id);
					pstmt2.setString(4,login_at_ws_no);
					pstmt2.setString(5,login_facility_id);
					pstmt2.setString(6,login_by_id);
					pstmt2.setString(7,login_at_ws_no);
					pstmt2.setString(8,login_facility_id);
					
					pstmt2.addBatch() ;		
					success="";
					cstmt_insert1 = connection.prepareCall("{call PH_DRUG_INFO_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
					cstmt_insert1.setString(1, Enquiry_num);
					cstmt_insert1.setString(2, enq_dt);
					cstmt_insert1.setString(3, (String)ReqCatg.get(num));
					cstmt_insert1.setString(4, (String)ReqCatg_sys.get(num));
					cstmt_insert1.setString(5, "N");
					cstmt_insert1.setString(6, login_at_ws_no);
					cstmt_insert1.setString(7, login_facility_id);
					cstmt_insert1.setString(8, login_at_ws_no);
					cstmt_insert1.setString(9, login_facility_id);
					cstmt_insert1.registerOutParameter(10, Types.VARCHAR);
					cstmt_insert1.execute();
					success	= cstmt_insert1.getString(10);
					//System.err.println("success ::"+success);
					if(success.equals("Y")){
						insert_rec_7=true;
					}
					else{
						insert_rec_7=false;
					}
					closeStatement(cstmt_insert1);
					cstmt_insert2= connection.prepareCall("{call PH_DRUG_MTHLY_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
					cstmt_insert2.setString(1, Enquiry_num);
					cstmt_insert2.setString(2, enq_dt);
					cstmt_insert2.setString(3, (String)ReqCatg.get(num));
					cstmt_insert2.setString(4, (String)ReqCatg_sys.get(num));
					cstmt_insert2.setString(5, "N");
					cstmt_insert2.setString(6, login_at_ws_no);
					cstmt_insert2.setString(7, login_facility_id);
					cstmt_insert2.setString(8, login_at_ws_no);
					cstmt_insert2.setString(9, login_facility_id);
					cstmt_insert2.registerOutParameter(10, Types.VARCHAR);
					cstmt_insert2.execute();
					success	= cstmt_insert2.getString(10);
					//System.err.println("success ::"+success);
					if(success.equals("Y")){
						insert_rec_8=true;
					}
					else{
						insert_rec_8=false;
					}
					closeStatement(cstmt_insert2);
				}
				int[] result_insert_1= pstmt2.executeBatch();
				for (int i=0;i<result_insert_1.length ;i++ ){
					if(result_insert_1[i]<0  && result_insert_1[i] != -2 ){
						insert_rec_2=false;
				
						break;
					}
					else{
					insert_rec_2=true;
					}
				}
                closeStatement(cstmt_insert1);    
				closeStatement(cstmt_insert2);
				closeStatement(pstmt2);
			}
			if(insert_rec_2 && insert_rec_7 &&insert_rec_8){
				if(no_of_info_src >0){
					pstmt3 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT")); 
					for(int num=0;num<no_of_info_src;num+=2){
						pstmt3.setString(1,Enquiry_num);
						pstmt3.setString(2,(String)InfoSrc_code.get(num));
						pstmt3.setString(3,(String)InfoSrc_code.get(num+1));
						pstmt3.setString(4,login_by_id);
						pstmt3.setString(5,login_at_ws_no);
						pstmt3.setString(6,login_facility_id);
						pstmt3.setString(7,login_by_id);
						pstmt3.setString(8,login_at_ws_no);
						pstmt3.setString(9,login_facility_id);
						pstmt3.addBatch() ;			
					}
					int[] result_insert_2= pstmt3.executeBatch();
					for (int i=0;i<result_insert_2.length ;i++ ){
						if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
							insert_rec_3=false;
							break;
						}
						else{
						insert_rec_3=true;
						}
					}
					closeStatement(pstmt3);
				}
				else{
					insert_rec_3=true;
				}
			}
			if(insert_rec_2 && insert_rec_1 && insert_rec_3 && insert_rec_7 && insert_rec_8 && insert_rec_5 && insert_rec_4){
				connection.commit();
				map.put("result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
			}
			else{
			try{
				connection.rollback();
				map.put( "result", new Boolean( false) ) ;
				map.put("msgid","Failed");
				throw new EJBException("Error: Error while verification.");
			}
			catch(Exception es){
				es.printStackTrace() ;
			
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw new EJBException("Error: Error while verification.");
		}
		finally {
			try {
				closeResultSet( resultSet ) ;				
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( cstmt_insert1 ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( cstmt_insert2 ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection,prop );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
			
		return map;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete (HashMap tabData , HashMap sqlMap ){
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "In Insert ") ;
		map.put("msgid","INSERT");
		return map;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify (HashMap tabData , HashMap sqlMap ){
		//String debug		= "UPDATE METHOD IN EJB";  Unused local variable INC63877
		String success					= "";
	//	String success1					="";   Unused local variable INC63877
		String success2					= "";
  		String success3					= "";
 		//String success4		="";  Unused local variable INC63877
    	//String success5		="";  Unused local variable INC63877

		Connection connection		=	null ;
		CallableStatement cstmt_insert1 =null;
		CallableStatement cstmt_insert =null;
		CallableStatement cstmt_insert3 =null;
		CallableStatement cstmt_insert2 =null;
	//	CallableStatement cstmt_insert4 =null;   Unused local variable INC63877
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		PreparedStatement pstmt1	=	null ;
		PreparedStatement pstmt2	=	null ;
		PreparedStatement pstmt3	=	null ;
		PreparedStatement pstmt4	=	null ;
		ResultSet resultSet3		=	null ;      
		PreparedStatement pstmt5	=	null ;
		PreparedStatement pstmt6	 =	null ;
		//String sqlQry				=	"";  Unused local variable INC63877
		
		boolean insert_rec_1		=	false;
		boolean insert_rec_2		=	false;
		boolean insert_rec_3		=	false;
		boolean insert_rec_4		=	false;
		boolean insert_rec_5		=	false;
		boolean insert_rec_6		=	false;
		boolean insert_rec_7		=	false;
		boolean insert_rec_8		=	false;
		int result					=	0;
		int result2					=	0;
		int result3					=	0;
		//String resp_time			=	"" ;   Unused local variable INC63877
		
		HashMap map			= new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "BEAN STARTS") ;
		map.put("msgid","INSERT");
		 //System.err.println(" sdfsdf sdfsdfsdfsdf "+tabData);

		String  facility_id				= ((String) tabData.get("facility_id"))==null?"":(String) tabData.get("facility_id");
		String facility_name			= ((String) tabData.get("facility_name"))==null?"":(String) tabData.get("facility_name");
		String pract_name				= ((String) tabData.get("Pract_name"))==null?"":(String) tabData.get("Pract_name");
		String Enquiry_num				= ((String) tabData.get("Enquiry_Num"))==null?"":(String) tabData.get("Enquiry_Num");
	
		String pract_id					= ((String) tabData.get("pract_id"))==null?"":(String) tabData.get("pract_id");
		String designation				= ((String) tabData.get("designation"))==null?"":(String) tabData.get("designation");
		String pract_type				= ((String) tabData.get("pract_type"))==null?"":(String) tabData.get("pract_type");
		String priority					= ((String) tabData.get("priority"))==null?"":(String) tabData.get("priority");
		String Confidential_YN			= ((String) tabData.get("Confidential_YN "))==""?"N":(String) tabData.get("Confidential_YN");
		
		String other_priority			= ((String) tabData.get("other_priority"))==null?"":(String) tabData.get("other_priority");
		String enq_dt					= ((String) tabData.get("enq_dt"))==null?"":(String) tabData.get("enq_dt");
		String request_mode				= ((String) tabData.get("request_mode"))==null?"":(String) tabData.get("request_mode");
		String other_request_mode		= ((String) tabData.get("other_mode"))==null?"":(String) tabData.get("other_mode");
		String  addr_line1				= ((String) tabData.get("line1"))==null?"":(String) tabData.get("line1");
		String  rep_addr_line1			= ((String) tabData.get("rep_line1"))==null?"":(String) tabData.get("rep_line1");
		String  addr_line2				= ((String) tabData.get("line2"))==null?"":(String) tabData.get("line2");
		String  rep_addr_line2			= ((String) tabData.get("rep_line2"))==null?"":(String) tabData.get("rep_line2");
		String  addr_line3				= ((String) tabData.get("line3"))==null?"":(String) tabData.get("line3");
		String  rep_addr_line3			= ((String) tabData.get("rep_line3"))==null?"":(String) tabData.get("rep_line3");
		String  addr_line4				= ((String) tabData.get("line4"))==null?"":(String) tabData.get("line4");
		String  rep_addr_line4			= ((String) tabData.get("rep_line4"))==null?"":(String) tabData.get("rep_line4");
		String  tel_num					= ((String) tabData.get("tel_num"))==null?"":(String) tabData.get("tel_num");
		String  rep_tel_num				= ((String) tabData.get("rep_tel_num"))==null?"":(String) tabData.get("rep_tel_num");
		String  fac_num					= ((String) tabData.get("fac_num"))==null?"":(String) tabData.get("fac_num");
		String  rep_fac_num				= ((String) tabData.get("rep_fac_num"))==null?"":(String) tabData.get("rep_fac_num");
		String  email 					= ((String) tabData.get("email"))==null?"":(String) tabData.get("email");
		String  rep_email				= ((String) tabData.get("rep_email"))==null?"":(String) tabData.get("rep_email");
//		String  function_id				= ((String) tabData.get("function_id"))==null?"":(String) tabData.get("function_id");  //Commented for Common-ICN-0048
		
		//String  logged_fc_name			= ((String) tabData.get("logged_fc_name"))==null?"":(String) tabData.get("logged_fc_name");  //Commented for Common-ICN-0048
	//	String  Sysdate					= ((String) tabData.get("sysdate"))==null?"":(String) tabData.get("sysdate");  //Commented for Common-ICN-0048

		//Request Form
		String  Request_dtl				= ((String) tabData.get("Request_dtl"))==null?"":(String) tabData.get("Request_dtl");
		String  p_user_name				= ((String) tabData.get("p_user_name"))==null?"":(String) tabData.get("p_user_name");
			
		String Req_catg					= ((String) tabData.get("Req_catg"))==null?"":(String) tabData.get("Req_catg");
		//Patient Form
		String  patient_id				= ((String) tabData.get("patient_id"))==null?"":(String) tabData.get("patient_id");
		String  patient_name			= ((String) tabData.get("patient_name"))==null?"":(String) tabData.get("patient_name");
		String  age						= ((String) tabData.get("age"))==null?"":(String) tabData.get("age");
		String  age_unit						= ((String) tabData.get("age_unit"))==null?"":(String) tabData.get("age_unit");
		String  gender					= ((String) tabData.get("gender"))==null?"":(String) tabData.get("gender");
		String  ethnic_grp				= ((String) tabData.get("ethnic_grp"))==null?"":(String) tabData.get("ethnic_grp");
		String  drug_desc				= ((String) tabData.get("drug_desc"))==null?"":(String) tabData.get("drug_desc");
		String  food_desc				= ((String) tabData.get("food_desc"))==null?"":(String) tabData.get("food_desc");
		String  other_desc				= ((String) tabData.get("other_desc"))==null?"":(String) tabData.get("other_desc");

		//Response form
		String  Response_dtl			= ((String) tabData.get("Response_dtl"))==null?"":(String) tabData.get("Response_dtl");
		String  response_remarks		= ((String) tabData.get("response_remarks"))==null?"":(String) tabData.get("response_remarks");
		//String  respond_btn				= ((String) tabData.get("respond"))==null?"":(String) tabData.get("respond");  //Commented for Common-ICN-0048
		String  response_dt				= ((String) tabData.get("response_dt"))==null?"":(String) tabData.get("response_dt");
		String  verified_by				= ((String) tabData.get("verified_by"))==null?"":(String) tabData.get("verified_by");
		String  Info_src				= ((String) tabData.get("Info_src"))==null?"":(String) tabData.get("Info_src");
		
		//String signed_by				= ((String) tabData.get("Signed_by"))==null?"":(String) tabData.get("Signed_by");  //Commented for Common-ICN-0048
		String signed_date_time			= ((String) tabData.get("Signed_Date_Time"))==null?"":(String) tabData.get("Signed_Date_Time");
		String login_facility_id		= ((String) tabData.get("login_facility_id"))==null?"":(String) tabData.get("login_facility_id");
		String login_by_id				= ((String) tabData.get("login_by_id"))==null?"":(String) tabData.get("login_by_id");

		String login_at_ws_no			= ((String) tabData.get("login_at_ws_no"))==null?"":(String) tabData.get("login_at_ws_no");

		String Resp_Days				= ((String) tabData.get("Resp_Days"))==null?"":(String) tabData.get("Resp_Days");
		String Resp_Hrs					= ((String) tabData.get("Resp_Hrs"))==null?"":(String) tabData.get("Resp_Hrs");
		String Resp_Mins				= ((String) tabData.get("Resp_Mins"))==null?"":(String) tabData.get("Resp_Mins");
		String prev_enquiry_date		= ((String) tabData.get("prev_enquiry_date"))==null?"":(String) tabData.get("prev_enquiry_date");
		String Signed_verify_remarks	= ((String) tabData.get("Signed_verify_remarks"))==null?"":(String) tabData.get("Signed_verify_remarks");

		Properties prop=null;
		prop = (Properties)tabData.get( "properties" );	
	
		ArrayList ReqCatg			= new ArrayList();
		StringTokenizer st3			=null;
		ArrayList ReqCatg_sys		= new ArrayList();
		String Req_catg_Sys			="";
		
		if(!Req_catg.equals("")){
			StringTokenizer st			= new StringTokenizer(Req_catg,"$");
			while (st.hasMoreTokens()){
				Req_catg_Sys =st.nextToken();
				st3			= new StringTokenizer(Req_catg_Sys,"**");
				while(st3.hasMoreTokens()){
					ReqCatg.add(st3.nextToken());
					ReqCatg_sys.add(st3.nextToken());
				}
			}
		}
		int no_of_catg					=	ReqCatg.size();

		String InfoSrc_str				=	"";
		// ArrayList InfoSrc				=	 new ArrayList();   Unused local variable INC63877
		ArrayList InfoSrc_code			=	new ArrayList();
		StringTokenizer st2				=	null;
		if(!Info_src.equals("")){
			StringTokenizer st1			= new StringTokenizer(Info_src,"$");
			while (st1.hasMoreTokens()){
				InfoSrc_str=st1.nextToken();
				st2	=new StringTokenizer(InfoSrc_str,"**");
				while(st2.hasMoreTokens()){
					InfoSrc_code.add(st2.nextToken());
				}
			}
		}
		int no_of_info_src	=InfoSrc_code.size();
		try{
			connection			= getConnection(prop) ;
			if(Enquiry_num==null) 
				Enquiry_num="";
			if(!Enquiry_num.equals("")){
				cstmt_insert1 = connection.prepareCall("{call PH_DRUG_DLY_INFO_UPD_PROC(?,?,?,?,?)}");
				cstmt_insert1.setString(1, Enquiry_num);
				cstmt_insert1.setString(2, prev_enquiry_date);
				cstmt_insert1.setString(3, "Y");
				cstmt_insert1.setString(4, "Y");
				cstmt_insert1.registerOutParameter(5, Types.VARCHAR);
				cstmt_insert1.execute();
				success	= cstmt_insert1.getString(5);
				if(success.equals("Y")){
					insert_rec_4=true;
				}
				else{
					insert_rec_4=false;
				}
				closeStatement(cstmt_insert1);

				if(insert_rec_4){
					cstmt_insert = connection.prepareCall("{call PH_DRUG_MTHLY_INFO_UPD_PROC(?,?,?,?,?)}");
					cstmt_insert.setString(1, Enquiry_num);
					cstmt_insert.setString(2, prev_enquiry_date);
					cstmt_insert.setString(3, "Y");
					cstmt_insert.setString(4, "Y");
					cstmt_insert.registerOutParameter(5, Types.VARCHAR);
					cstmt_insert.execute();
					success	= cstmt_insert.getString(5);
					if(success.equals("Y")){
						insert_rec_5=true;
					}
					else{
						insert_rec_5=false;
					}
					closeStatement(cstmt_insert);
				}
				if(insert_rec_5){
					pstmt  = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_HDR_UPDATE")); 
					//SQL_PH_DRUG_ENQ_INFO_HDR_UPDATE
					pstmt.setString(1,facility_id);
					pstmt.setString(2,facility_name);
					pstmt.setString(3,pract_id);
					pstmt.setString(4,pract_name);
					pstmt.setString(5,pract_type);
					if(pract_type.equals("")){
						pstmt.setString(6,"");
						pstmt.setString(7,designation);
					}
					else{
						pstmt.setString(6,designation);
						pstmt.setString(7,"");
					}
					pstmt.setString(8,priority);
					pstmt.setString(9,other_priority);
					pstmt.setString(10,enq_dt);
					pstmt.setString(11,request_mode);
					pstmt.setString(12,other_request_mode);
					pstmt.setString(13,addr_line1);
					pstmt.setString(14,addr_line2);
					pstmt.setString(15,addr_line3);
					pstmt.setString(16,addr_line4);
					pstmt.setString(17,tel_num);
					pstmt.setString(18,fac_num);
					pstmt.setString(19,email);
					pstmt.setString(20,rep_addr_line1);
					pstmt.setString(21,rep_addr_line2);
					pstmt.setString(22,rep_addr_line3);
					pstmt.setString(23,rep_addr_line4);
					pstmt.setString(24,rep_tel_num);
					pstmt.setString(25,rep_fac_num);
					pstmt.setString(26,rep_email);
					pstmt.setString(27,Request_dtl);
					pstmt.setString(28,p_user_name);
					pstmt.setString(29,patient_id);
					pstmt.setString(30,patient_name);
					pstmt.setString(31,age);
					pstmt.setString(32,age_unit);
					pstmt.setString(33,gender);
					pstmt.setString(34,ethnic_grp);
					pstmt.setString(35,drug_desc);
					pstmt.setString(36,food_desc);
					pstmt.setString(37,other_desc);
					pstmt.setString(38,Response_dtl);
					pstmt.setString(39,response_remarks);
					if(!response_dt.equals("")){
						pstmt.setString(40,response_dt);
						pstmt.setString(41,login_by_id.trim());
					}
					else{
						pstmt.setString(40,"");
						pstmt.setString(41,"");
					}
					if(!response_dt.equals("")){
						if(verified_by.equals("Y")){
							pstmt.setString(42,p_user_name);
						}
						else{
							pstmt.setString(42,"");
						}
					}
					else{
						pstmt.setString(42,"");
					}
					if(!response_dt.equals("")){
						if(verified_by.equals("Y")){
							pstmt.setString(43,signed_date_time);
						}
						else{
							pstmt.setString(43,"");
						}
					}
					else{
							pstmt.setString(43,"");
					}
		
					pstmt.setString(44,login_by_id);
					pstmt.setString(45,login_at_ws_no);
					pstmt.setString(46,login_facility_id);
					if(response_dt.equals("")){
						pstmt.setString(47,"0");
						pstmt.setString(48,"0");
						pstmt.setString(49,"0");
					}
					else{
						pstmt.setString(47,Resp_Days);
						pstmt.setString(48,Resp_Hrs);
						pstmt.setString(49,Resp_Mins);
					}
					pstmt.setString(50,Confidential_YN);
					pstmt.setString(51,Signed_verify_remarks);			
					pstmt.setString(52,Enquiry_num);
					result=pstmt.executeUpdate() ;
					if(result >0){
						insert_rec_1=true;
					}
					else{
						insert_rec_1=false;
					}
					closeStatement(pstmt);
				}
			}
			if(insert_rec_1){
				cstmt_insert2 = connection.prepareCall("{call PH_DRUG_INFO_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
				cstmt_insert2.setString(1, Enquiry_num);
				cstmt_insert2.setString(2, enq_dt);
				cstmt_insert2.setString(3, "@!");
				cstmt_insert2.setString(4, "Y");
				cstmt_insert2.setString(5, "Y");
				cstmt_insert2.setString(6, login_at_ws_no);
				cstmt_insert2.setString(7, login_facility_id);
				cstmt_insert2.setString(8, login_at_ws_no);
				cstmt_insert2.setString(9, login_facility_id);
				cstmt_insert2.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert2.execute();
				success2	= cstmt_insert2.getString(10);
				if(success2.equals("Y")){
					insert_rec_6=true;
				}
				else{
					insert_rec_6=false;
				}
				closeStatement(cstmt_insert2);
			}
			if(insert_rec_6){
				cstmt_insert3 = connection.prepareCall("{call PH_DRUG_MTHLY_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
				cstmt_insert3.setString(1, Enquiry_num);
				cstmt_insert3.setString(2, enq_dt);
				cstmt_insert3.setString(3, "@!");
				cstmt_insert3.setString(4, "Y");
				cstmt_insert3.setString(5, "Y");
				cstmt_insert3.setString(6, login_at_ws_no);
				cstmt_insert3.setString(7, login_facility_id);
				cstmt_insert3.setString(8, login_at_ws_no);
				cstmt_insert3.setString(9, login_facility_id);
				
				cstmt_insert3.registerOutParameter(10, Types.VARCHAR);
				cstmt_insert3.execute();
				success3	= cstmt_insert3.getString(10);
				if(success3.equals("Y")){
					insert_rec_7=true;
				}
				else{
					insert_rec_7=false;
				}
				closeStatement(cstmt_insert3);
			}

			if(insert_rec_7){
				cstmt_insert1 = connection.prepareCall("{call PH_DRUG_DLY_INFO_UPD_PROC(?,?,?,?,?)}");
				cstmt_insert1.setString(1, Enquiry_num);
				cstmt_insert1.setString(2, prev_enquiry_date);
				cstmt_insert1.setString(3, "N");
				cstmt_insert1.setString(4, "N");
				cstmt_insert1.registerOutParameter(5, Types.VARCHAR);
				cstmt_insert1.execute();
				success	= cstmt_insert1.getString(5);
				//System.err.println("success 728::"+success);
				if(success.equals("Y")){
					insert_rec_8=true;
				}
				else{
					insert_rec_8=false;
				}
			}
			closeStatement(cstmt_insert1);
			if(insert_rec_8){
				cstmt_insert = connection.prepareCall("{call PH_DRUG_MTHLY_INFO_UPD_PROC(?,?,?,?,?)}");
				cstmt_insert.setString(1, Enquiry_num);
				cstmt_insert.setString(2, prev_enquiry_date);
				cstmt_insert.setString(3, "N");
				cstmt_insert.setString(4, "N");
				cstmt_insert.registerOutParameter(5, Types.VARCHAR);
				cstmt_insert.execute();
				success	= cstmt_insert.getString(5);
	
				pstmt4 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_DELETE")); 
				pstmt4.setString(1,Enquiry_num);
				result2	= pstmt4.executeUpdate() ;
				closeStatement(pstmt4);
				
				if(result2 >0){
					pstmt2 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT")); 
					for(int num=0;num<no_of_catg;num++){
						pstmt2.setString(1,Enquiry_num);
						pstmt2.setString(2,(String)ReqCatg.get(num));
						pstmt2.setString(3,login_by_id);
						pstmt2.setString(4,login_at_ws_no);
						pstmt2.setString(5,login_facility_id);
						pstmt2.setString(6,login_by_id);
						pstmt2.setString(7,login_at_ws_no);
						pstmt2.setString(8,login_facility_id);
						
						pstmt2.addBatch() ;			

						cstmt_insert2 = connection.prepareCall("{call PH_DRUG_INFO_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
						cstmt_insert2.setString(1, Enquiry_num);
						cstmt_insert2.setString(2, enq_dt);
						cstmt_insert2.setString(3, (String)ReqCatg.get(num));
						cstmt_insert2.setString(4, (String)ReqCatg_sys.get(num));
						cstmt_insert2.setString(5, "N");
						cstmt_insert2.setString(6, login_at_ws_no);
						cstmt_insert2.setString(7, login_facility_id);
						cstmt_insert2.setString(8, login_at_ws_no);
						cstmt_insert2.setString(9, login_facility_id);
						cstmt_insert2.registerOutParameter(10, Types.VARCHAR);
						cstmt_insert2.execute();
						success	= cstmt_insert2.getString(10);
						closeStatement(cstmt_insert2);

						cstmt_insert3 = connection.prepareCall("{call PH_DRUG_MTHLY_STATS_PROC(?,?,?,?,?,?,?,?,?,?)}");
						cstmt_insert3.setString(1, Enquiry_num);
						cstmt_insert3.setString(2, enq_dt);
						cstmt_insert3.setString(3, (String)ReqCatg.get(num));
						cstmt_insert3.setString(4, (String)ReqCatg_sys.get(num));
						cstmt_insert3.setString(5, "N");
						cstmt_insert3.setString(6, login_at_ws_no);
						cstmt_insert3.setString(7, login_facility_id);
						cstmt_insert3.setString(8, login_at_ws_no);
						cstmt_insert3.setString(9, login_facility_id);
						cstmt_insert3.registerOutParameter(10, Types.VARCHAR);
						cstmt_insert3.execute();
						success	= cstmt_insert3.getString(10);
						closeStatement(cstmt_insert3);
					}
					int[] result_insert_1= pstmt2.executeBatch();
					for (int i=0;i<result_insert_1.length ;i++ ){
						if(result_insert_1[i]<0  && result_insert_1[i] != -2 ){
							insert_rec_2=false;
							break;
						}
						else{
							insert_rec_2=true;
						}
					}
					closeStatement(pstmt2);
				}
			}
			closeStatement(cstmt_insert);
			if(insert_rec_2){
				pstmt6 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_SELECT1")); 
				pstmt6.setString(1,Enquiry_num);
				resultSet3	= pstmt6.executeQuery() ;
				if(resultSet3 !=null && resultSet3.next()){
					pstmt5 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_DELETE")); 
					pstmt5.setString(1,Enquiry_num);
					result3	= pstmt5.executeUpdate() ;
				}
				closeResultSet(resultSet3);
				closeStatement(pstmt6);
				closeStatement(pstmt5);

 				if(no_of_info_src >0){
					pstmt3 = connection.prepareStatement((String)sqlMap.get("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT")); 
					for(int num=0;num<no_of_info_src;num+=2){
						pstmt3.setString(1,Enquiry_num);
						pstmt3.setString(2,(String)InfoSrc_code.get(num));
						pstmt3.setString(3,(String)InfoSrc_code.get(num+1));
						pstmt3.setString(4,login_by_id);
						pstmt3.setString(5,login_at_ws_no);
						pstmt3.setString(6,login_facility_id);
						pstmt3.setString(7,login_by_id);
						pstmt3.setString(8,login_at_ws_no);
						pstmt3.setString(9,login_facility_id);
						pstmt3.addBatch() ;		
					}
					int[] result_insert_2= pstmt3.executeBatch();
					for (int i=0;i<result_insert_2.length ;i++ ){
						if(result_insert_2[i]<0  && result_insert_2[i] != -2 ){
							insert_rec_3=false;
							break;
						}
						else{
						insert_rec_3=true;
						}
					}
					closeStatement(pstmt3);
				}
				else{
					insert_rec_3=true;
				}
			}
			if(insert_rec_2 && insert_rec_1 && insert_rec_3 && insert_rec_4 && insert_rec_5 && insert_rec_6 && insert_rec_7 && insert_rec_8){
				connection.commit();
				map.put("result", new Boolean( true ) ) ;
				map.put("msgid","RECORD_INSERTED" ) ;
				
			}
			else{
				try{				
					connection.rollback();
					map.put( "result", new Boolean( false) ) ;
					map.put("msgid","Modify");
					throw new EJBException("Error: Error while verification.");
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;				
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt3 ) ;
				closeStatement( cstmt_insert ) ;
				closeStatement( cstmt_insert1 ) ;
				closeStatement( cstmt_insert2 ) ;
				closeStatement( cstmt_insert3 ) ;
            	closeConnection( connection,prop );
			}
			catch(Exception es) { }
		}
		return map;
	}
}
