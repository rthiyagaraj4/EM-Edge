/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common ;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import webbeans.eCommon.*;//Changed on 03/07/13 against UAT5 - Connection Issue

public class BookingBillingManager {
	private HashMap<String,String> comon_hdr=new HashMap<String,String>();
	private ArrayList<String> audit_flds = new ArrayList<String>();
	private HashMap<String,HashMap> oper_map=new HashMap<String,HashMap>();
	private  BookingBillingManager(HashMap commonData){
		//login_by_id-->0 1-->login_at_ws_no  2--> login_facility_id
		audit_flds = (ArrayList)commonData.get("mandatory_flds");
		comon_hdr = (HashMap)commonData.get("booking_hdr");
		oper_map = (HashMap)commonData.get("post_oper_dtls");
	}

	//This method provide a starting point for calling  billing related procedures.
	public  boolean processBilling(Connection conn)
	{
		//checks billing is installed
		if(!isBillingInstalled())
			return true;
		//return "SUCCESS" string if procedure is executed successfully.
		if(!"RECORD_INSERTED".equals(GeneratePatientBill(conn))) 
				return false;
		//return "RECORD_INSERTED" string if procedure is executed successfully.
		if(!"RECORD_INSERTED".equals(callBillRecord(conn)))
		{
			tearDown();
			return false;
		}
		return true;
	}

	/*This method clears the collection classes used in the instance level*/
	public void tearDown(){
		comon_hdr.clear();
		audit_flds.clear();
		oper_map.clear();
	}

	/*This method is used to initialize the Data passed from EJB */
	public static BookingBillingManager intializeBookingBillingManager(HashMap commonData){
		return new BookingBillingManager(commonData);
	}
	/*public static BookingBillingManager intializeBillingManager(HashMap map,HashMap commonData){
		return new BookingBillingManager(map,commonData);
	}*/

	//Billing Installed or not is checked
	private boolean isBillingInstalled(){
		String facility_id  = (String)  audit_flds.get(2);
		Connection con = null;
		CallableStatement cstmt = null;
		String bl_installed="";
		String err_text = "";
		String bl_interface="";
		boolean flag = false;
		String status="";
		try{
			 //con = ConnectionDispenser.getConnection();//Connection Issue
			 con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection
			//for checking whether the Billing module is installed or not
			//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
			cstmt=con.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,facility_id );
			cstmt.setString(2,facility_id );
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
			cstmt.execute();
			status = nullSafe(cstmt.getString(5));
			if("Y".equals(status) ){
				err_text = cstmt.getString(8);
			}else{
				bl_installed	= nullSafe(cstmt.getString(3));
				bl_interface	 = nullSafe(cstmt.getString(4));
				flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
			}
		}catch(Exception e){
			e.printStackTrace();
	   }finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
			//con.close();
		}catch(Exception e){
		e.printStackTrace();
		}
	}
	return flag;
 }

public String GeneratePatientBill(Connection con){
	//String  panel_str_new = ""; //Commented Against AAKH-ICN-0008
	String err_desc			= "";
	String oper_desc		= "";
	String panel_str		= "";
	String bill_str="";
	String rate		= "";
	String bl_strerrorlevel="";
	String bl_strsysmessageid="";
	String bl_strerrortext="";
	String fpp_category="N";
	String fpp_yn="N";
	//Connection con = null;
    CallableStatement cstmt = null;
	String facility_id		=   audit_flds.get(2);
	String patient_id		=comon_hdr.get("patient_id") ;
	String episode_id		= comon_hdr.get("episode_id") ;
	String patient_class	= comon_hdr.get("episode_type") ;
	String ws_no			=    audit_flds.get(1); ;
	String start_time =comon_hdr.get("start_time").split(" ")[1];
	String oper_date		=comon_hdr.get("booking_date")+" "+start_time;
	String surgeon_code		=comon_hdr.get("surgeonCode") ;
	String visit_id			=comon_hdr.get("visitid") ;
	String order_id			=comon_hdr.get("orderid") ;
	String v_stage         ="ORD";//if it is from booking -- "ORD"// check-In--"REG"
	String pract_code_val = "";
	String[] charge_arr=null;
	String[] pract_arr=null;

	String bl_episode_type  = BillingUtil.getBillingEpisodeType(patient_class);
	HashMap<String,String> map = new HashMap<String,String>();
	int size = oper_map.size();
//	con=ConnectionManager.getConnection();//Changed on 03/07/13 against UAT5 - Connection

	try {
		cstmt=con.prepareCall("{call OT_BILLING_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_number(?),?,?,?,?,?)}");
	for(int i=1;i<=size;i++)
	{
		  map = oper_map.get(""+i);
		  panel_str=map.get("panel_str");
		if(panel_str !="" || !panel_str.equals("") )
		{
			pract_arr=panel_str.split("#");
			pract_code_val=pract_arr[5];

		}


 String overridden_excl_incl_ind="";
String action_reason_code="";
 bill_str= map.get("bill_str");
	if(bill_str !="" || !bill_str.equals("") )
		{
		  charge_arr=bill_str.split("::");
		  overridden_excl_incl_ind=charge_arr[4];
	      action_reason_code=charge_arr[7];
		}
		  oper_desc=map.get("operation_desc") ;
		  fpp_yn=map.get("fpp_yn") ;
		  fpp_category=map.get("fpp_category") ;
		  rate=checkForNull(map.get("rate") );
		  cstmt.setString(1,facility_id );						//v_facility_id					 VARCHAR2,
		  cstmt.setString(2,patient_id );						//v_patient_id				 VARCHAR2,
		  cstmt.setString(3,episode_id );						//v_episode_id				 VARCHAR2,
		  cstmt.setString(4,visit_id );							//v_visit                                         VARCHAR2,
		  cstmt.setString(5,order_id );	//v_order_id                                    VARCHAR2,
		  cstmt.setString(6,map.get("order_line_num"));//v_ord_line_no                                VARCHAR2,
		  cstmt.setString(7,map.get("oper_code") );	//v_oper_code				  VARCHAR2,
		  cstmt.setString(8,"Y" ); //bl_interfaced_yn			//v_bl_interfaced				  VARCHAR2,
		  cstmt.setString(9,bl_episode_type );					//v_bl_episode_type			  VARCHAR2,
		  cstmt.setString(10,order_id);						//v_oper_request_num			  VARCHAR2,
		  cstmt.setString(11,map.get("order_line_num"));//v_line_num					  VARCHAR2,
		  cstmt.setString(12,v_stage );							//v_stage					  VARCHAR2,
		  cstmt.setString(13,oper_date );						//v_oper_date				  VARCHAR2, -- FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'
			if(!pract_code_val.equals("") ||!pract_code_val.equals(null) )
			{
					cstmt.setString(14,pract_code_val);
			}else
			{
					cstmt.setString(14,surgeon_code );
			}
		  cstmt.setString(15,ws_no ) ;							//v_ws_no					  VARCHAR2,
		  cstmt.setString(16,null) ;							//v_catalog_code			IN OUT VARCHAR2,
		  cstmt.setString(17, oper_desc );	//v_oper_desc				   VARCHAR2,
		  cstmt.setString(18, panel_str);		//panel Str		//v_revised_billing_details			   VARCHAR2,
		  cstmt.registerOutParameter(19,Types.VARCHAR);			//v_serv_panel_ind			OUT      VARCHAR2,
		  cstmt.registerOutParameter(20,Types.VARCHAR);			//v_blng_srvc_code			OUT      VARCHAR2,
		  cstmt.registerOutParameter(21,Types.VARCHAR);			//v_charge_stage			OUT      VARCHAR2,
		  cstmt.registerOutParameter(22,Types.VARCHAR);			//err_code		//		v_err_code				OUT      VARCHAR2,
		  cstmt.registerOutParameter(23,Types.VARCHAR);			//sys_mesg_id	//		v_sys_message_id		OUT      VARCHAR2,
		  cstmt.registerOutParameter(24,Types.VARCHAR);			//error_text	//		v_error_text			OUT      VARCHAR2,
		  cstmt.registerOutParameter(25,Types.VARCHAR);			//		v_preapp_msg	OUT      VARCHAR2,
		  cstmt.registerOutParameter(26,Types.VARCHAR);			//		v_excl_msg	OUT      VARCHAR2,
		  cstmt.registerOutParameter(27,Types.VARCHAR);			//LANG_ERR_MSG_ID	//		V_LANG_ERR_MSG_ID		OUT	    VARCHAR2,
		  cstmt.setString(28,"N");								//FUTURE_ORDER_YN	//		P_FUTURE_ORDER_YN		VARCHAR2 DEFAULT 'N'
		  cstmt.setString(29,rate);// rate
		  cstmt.setString(30,"OR");// Newly Added Parameter on 15/12/08

		     if(("null").equals(overridden_excl_incl_ind))
				{
					cstmt.setString(31,"") ;
				}
				else
				{
					cstmt.setString(31,overridden_excl_incl_ind) ;	//overridden_excl_incl_ind	  VARCHAR2 default null
				}

				if(("null").equals(action_reason_code))
				{
					cstmt.setString(32,"") ;
				}
				else
				{
					cstmt.setString(32,action_reason_code) ;	//action_reason_code	  VARCHAR2 default null
				}
				cstmt.setString( 33,  fpp_yn ) ;						 
				cstmt.setString( 34,  fpp_category ) ;
		  cstmt.execute();
		  bl_strerrorlevel = checkForNull(cstmt.getString(22));
		  bl_strsysmessageid = checkForNull(cstmt.getString(23));
		  bl_strerrortext = checkForNull(cstmt.getString(24));
		  err_desc=ErrorUtil.decodeProcedureErrorMsg(bl_strerrorlevel,bl_strsysmessageid,bl_strerrortext,"GeneratePatientBill()");
		}//end for
	}catch(Exception e){
		System.err.println("229::Booking Billing Manager Err Msg in GeneratePatientBill "+e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			map.clear();
			if(cstmt!=null) cstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
}
	System.err.println("239,err_desc==="+err_desc);
	return err_desc;
}

private String callBillRecord(Connection con){	
	String err_desc="";
	String error_text="";
	String err_level="";
	String sys_message_id="";
	//String login_user			=audit_flds.get(0); //Commented Against AAKH-ICN-0008
	String client_ip_address	= audit_flds.get(1);
	String facility_id			= audit_flds.get(2);
	String patient_id			= comon_hdr.get("patient_id") ;
	String episode_id		    = comon_hdr.get("episode_id") ;
	String patient_class	    = comon_hdr.get("episode_type") ;
	String visit_id			    =checkForNull(comon_hdr.get("visitid") );
	String order_id             = comon_hdr.get("orderid");
	String bl_episode_type = BillingUtil.getBillingEpisodeType(patient_class);
	CallableStatement cstmt = null;
	try{
		cstmt=con.prepareCall("{call OT_BILLING_PACKAGE.OT_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,patient_id );
		cstmt.setString(3,bl_episode_type );
		cstmt.setString(4,episode_id );
		cstmt.setString(5,visit_id );
		cstmt.setString(6,order_id ) ;
		cstmt.setString(7,order_id) ;
		cstmt.setString(8,client_ip_address );//out parameters
		cstmt.registerOutParameter(9,Types.VARCHAR);//v_err_code 
		cstmt.registerOutParameter(10,Types.VARCHAR);//v_sys_message_id
		cstmt.registerOutParameter(11,Types.VARCHAR);//v_error_text
		cstmt.registerOutParameter(12,Types.VARCHAR);//LANG_ERR_MESG_ID NOT ADDED IN THE PROCEDURE
		cstmt.setString(13,"OR" );
		cstmt.execute();
		err_level = checkForNull(cstmt.getString(9));
		sys_message_id = checkForNull(cstmt.getString(10));
		error_text = checkForNull(cstmt.getString(11));
		err_desc=ErrorUtil.decodeProcedureErrorMsg(err_level,sys_message_id,error_text,"callBillRecord()");
	}catch(Exception e){
		System.err.println("Booking Billing Manager Err Msg in callBillRecord "+e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
		}catch(Exception e){ 
			System.err.println("347::Booking Billing Manager Err Msg in GeneratePatientBill "+e.getMessage());
			e.printStackTrace();
			}
	}
   return err_desc;
}

//Filtering the null value and "null" string
private String nullSafe(String s){
	return s!= null && s.intern()!="null" ? s : "";
}

public String checkForNull(String str){
	return (  str!=null && str.intern()!="null" )?str.trim():"";
 }
};
