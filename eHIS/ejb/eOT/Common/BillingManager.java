/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT.Common ;
import webbeans.eCommon.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.Types; 
import java.util.ArrayList;

public class BillingManager{
	private HashMap comon_hdr=new HashMap();
	private ArrayList audit_flds = new ArrayList();
	private HashMap oper_map=new HashMap();

	private BillingManager(HashMap commonData){
		audit_flds.add((String)commonData.get("login_user"));
		audit_flds.add((String)commonData.get("login_at_ws_no"));
		audit_flds.add((String)commonData.get("facility_id"));
	}

	private BillingManager(HashMap tabData,HashMap commonData){
		audit_flds.add((String)commonData.get("login_user"));
		audit_flds.add((String)commonData.get("login_at_ws_no"));
		audit_flds.add((String)commonData.get("facility_id"));
		oper_map  =  tabData;
		comon_hdr = BillingUtil.getCommonHdr((String) audit_flds.get(2),(String) oper_map.get("oper_num"));
	}

	//This method provide a starting point for calling  billing related procedures.
	//public  boolean processBilling(HashMap CommonData, String key,String nursing_doc_comp_yn, String process_yn){
	public  String processBilling1(HashMap CommonData, String key,String nursing_doc_comp_yn, String process_yn,Connection con){
		boolean flag=true;
		//Connection con = null;
		String err_msg="RECORD_INSERTED";
        try{
		//con = ConnectionManager.getConnection();
		//checks billing is installed
		if(! isBillingInstalled(con)) return err_msg;//true

		//return "SUCCESS" string if procedure is executed successfully.
		if(process_yn.equals("N")){
			err_msg=GeneratePatientBill(con);
			if(!"RECORD_INSERTED".equals(err_msg) ) {
				tearDown("38");
				System.err.println("Rollback GeneratePatientBill");
				con.rollback();
				flag=false;
			}
		}
		//return "RECORD_INSERTED" string if procedure is executed successfully.
		/* commented and below condition is added by bshankar.
		if(! "RECORD_INSERTED".equals(callBillRecord() ) ) {
			tearDown();
			return false;
		}
		*/
		//if(nursing_doc_comp_yn.equals("Y") && process_yn.equals("Y")){ commented by sathish instrcuted by dilip on 10/02/2009 against SPR-6089
		if(flag==true)
		{
		if(nursing_doc_comp_yn.equals("Y") ){
			err_msg=callBillRecord(CommonData,con);
			if(! "RECORD_INSERTED".equals(err_msg) ) {
				tearDown("51");
				System.err.println("Rollback callBillRecord");
				con.rollback();
				flag=false;
			}
		}
		}
		 if(flag==true) 
		 {
			//con.commit();
			err_msg="RECORD_INSERTED";
		 }
		}catch(Exception e){
		e.printStackTrace();
	    }finally{
		try{
			//if(con!=null) con.close();
		}catch(Exception e){e.printStackTrace();}
	    }
		return err_msg;
	}

public  boolean processBilling(HashMap CommonData, String key,String nursing_doc_comp_yn, String process_yn, Connection con){

		Connection connection = null;
		try
		{		
		//checks billing is installed
		if(! isBillingInstalled()) return true;//true

		//return "SUCCESS" string if procedure is executed successfully.
		if(process_yn.equals("N")){
			if(!"SUCCESS".equals(GeneratePatientBill(con)) ) {
				tearDown("38");
				return false;
			}
		}
		//return "RECORD_INSERTED" string if procedure is executed successfully.
		/* commented and below condition is added by bshankar.
		if(! "RECORD_INSERTED".equals(callBillRecord() ) ) {
			tearDown();
			return false;
		}
		*/
		//if(nursing_doc_comp_yn.equals("Y") && process_yn.equals("Y")){ commented by sathish instrcuted by dilip on 10/02/2009 against SPR-6089
		if(nursing_doc_comp_yn.equals("Y") ){
			if(! "RECORD_INSERTED".equals(callBillRecord(CommonData) ) ) {
				tearDown("51");
				return false;
			}
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
				ConnectionManager.returnConnection(connection);
		}
		return true;
	}

	/*This method clears the collection classes used in the instance level*/
	public void tearDown(String line_number){
		//comon_hdr.clear();
		//audit_flds.clear();
		//oper_map.clear();
	}

	/*This method is used to initialize the Data passed from EJB */
//	public static BillingManager intializeBillingManager(HashMap commonData){
//		return new BillingManager(commonData);
//	}


	public static BillingManager intializeBillingManager(HashMap map,HashMap commonData){
		return new BillingManager(map,commonData);
	}

	//Billing Installed or not is checked
	private boolean isBillingInstalled(Connection con){
		String facility_id  = (String)  audit_flds.get(2);
		//Connection con = null;
		CallableStatement cstmt = null;
		String bl_installed="";
		String err_text = "";
		String bl_interface="";
		boolean flag = false;
		String status="";
		try{
			 //con = ConnectionManager.getConnection();
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
			//con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	return flag;
 }

private String GeneratePatientBill(Connection con){
	String err_text			= "";
	String err_desc		= "";
	String err_code		= "";
	//String oper_desc		= "";
	String[] charge_arr=null;
	String mesg_id			= "";
	String login_by_id			  =   (String) audit_flds.get(0);	//login_by_id
	String ws_no				  =   (String)audit_flds.get(1);	//login_at_ws_no
	String facility_id			  =  (String) audit_flds.get(2);	//login_facility_id ;
	String patient_id			  = (String)comon_hdr.get("patient_id") ;
	String episode_id		      = (String)comon_hdr.get("episode_id") ;
	String episode_type		  = (String)comon_hdr.get("episode_type") ;
	String patient_class	      = (String)comon_hdr.get("patient_class") ;
	String encounter_id		  = (String)comon_hdr.get("encounter_id") ;
	String bl_episode_type    = BillingUtil.getBillingEpisodeType(patient_class,episode_type);
	String oper_date		      = (String)comon_hdr.get("surgery_date") ;
	String surgeon_code		  = (String)comon_hdr.get("surgeon_code") ;
	String visit_id			      = nullSafe((String)comon_hdr.get("visit_id")) ;
	String oper_num			  = (String)comon_hdr.get("oper_num");
	String oper_code			  = (String)oper_map.get("oper_code");
	String order_id               = (String)comon_hdr.get("order_id") ;
	String order_line_num      = BillingUtil.getOrderLineNumber(facility_id,oper_num,oper_code);
	String accessory_type	   = (String) oper_map.get("accessory_type");
	String accessory_code	   = "";
	switch(accessory_type.charAt(0)){
		case 'I': accessory_code =(String)oper_map.get("instr_code");
					accessory_type = "S";
					break;
		case 'E': accessory_code =(String)oper_map.get("equip_code");
					//accessory_type = "B";
					accessory_type = "E";
					break;
		case 'B': accessory_code =(String)oper_map.get("equip_code");
					//accessory_type = "B";
					accessory_type = "E";
					break;
		case 'P': accessory_code =(String)oper_map.get("package_code");
					accessory_type = "C";
					break;
		case 'S': accessory_code =(String)oper_map.get("implant_code");
					accessory_type = "I";
					break;
	}
	String  qty = (String) oper_map.get("quantity");
	qty = "".equals(nullSafe(qty))?"1":qty;
	String  bill_sub_regn_num = (String) oper_map.get("BillRegnNum");
	String  bill_sub_regn_line_num = (String) oper_map.get("BillRegnLineNum");
	String db_mode =  (String) oper_map.get("db_mode");
	String nursing_doc_comp_yn=( String ) oper_map.get( "nursing_doc" );
	//String  stage  =("Y".equals(nursing_doc_comp_yn) && "D".equals(db_mode))?"OTC":( ("Y".equals(nursing_doc_comp_yn) && ( "I".equals(db_mode) || "U".equals(db_mode))))?"OTF":"OTR";

	String  stage  ="D".equals(db_mode)?"OTC":("Y".equals(nursing_doc_comp_yn))?"OTF":"OTR";
	//String catalog_code = accessory_type+"#"+accessory_code;
	//Connection con= null;
	CallableStatement cstmt = null;
//	HashMap hash = null;
	String panel_str = "";
	String bill_str = "";
	String pract_code_val = "";
	String desiredDate = "";
	String checkInTime = "";
	String customerId = "";
	String[] pract_arr=null;
	int bill_str_index;
  int loop_count=2;
	try{
		
//		if(con == null)
//			con = ConnectionManager.getConnection();
		cstmt=con.prepareCall("{call  OT_BL_ACCESSORIES_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//if(stage.equals("OTC")){
		//	loop_count=1;
		//}
		loop_count=1;
		for(int j=0;j<loop_count;j++){
		//Call the interface rec procedure twice. Ist time with OTR and next with OTF. In case its OTC, call only once with OTC.
			if(!stage.equals("OTC"))
			{
				if(nursing_doc_comp_yn.equals("Y"))
					stage="OTF";
				else
					stage="OTR";
			}

			panel_str = (String)oper_map.get("panel_str");
			desiredDate =  (String)oper_map.get("desiredDate");
			checkInTime =  (String)oper_map.get("checkInTime");
			customerId =  (String)oper_map.get("customerId");
			if(panel_str!= null && !panel_str.equals("") && !panel_str.equals("null"))
			{
				panel_str = java.net.URLDecoder.decode(panel_str);
				pract_arr=panel_str.split("#");
				if(pract_arr.length>=6)
				pract_code_val=pract_arr[5];
			}
			cstmt.setString(1,facility_id );		//v_facility_id  VARCHAR2,
			cstmt.setString(2,patient_id );			//patient_id     VARCHAR2,
			cstmt.setString(3,episode_id );			//episode_id     VARCHAR2,
			cstmt.setString(4,encounter_id );		//encounter_id   VARCHAR2,
			cstmt.setString(5,visit_id );			//visit_id       VARCHAR2,
			cstmt.setString(6,order_id );			//order_id       VARCHAR2,
			cstmt.setString(7,order_line_num);		//order_line_num	//v_order_line_num                 VARCHAR2,
			cstmt.setString(8,accessory_type );	//accessory_type VARCHAR2, -- Consumable -> C , Equipment-->B, CSSD --> S ,Implant-->I
			cstmt.setString(9,accessory_code );		//accessory_code              VARCHAR2,
			cstmt.setString(10,"Y" );				//bl_interfaced_yn	//bl_interfaced               VARCHAR2,
			cstmt.setString(11,bl_episode_type );	//bl_episode_type             VARCHAR2,
			cstmt.setString(12,bill_sub_regn_num );		//bill_sub_regn_num           VARCHAR2,
			cstmt.setString(13,bill_sub_regn_line_num );//bill_sub_regn_line_num	  VARCHAR2,
			cstmt.setString(14,stage );					//stage                 VARCHAR2, -- OTR (REQUESTING STAGE) , OTF (FINALISATION)
			cstmt.setString(15,oper_date );				//oper_date                   VARCHAR2, -- FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'
            
			if(!pract_code_val.equals("") ||!pract_code_val.equals(null) )
				cstmt.setString(16,pract_code_val );
			else
				cstmt.setString(16,surgeon_code );

			//cstmt.setString(16,surgeon_code );			//phy_id                      VARCHAR,
			cstmt.setString(17,ws_no ) ;				//ws_no                       VARCHAR2,
			cstmt.setString(18,login_by_id ) ;			//login user                  VARCHAR2,
			cstmt.setString(19,null) ;					//catalog_code       IN OUT   VARCHAR2
			
			panel_str = panel_str==null?"":panel_str;
			panel_str = panel_str.equals("null")?"":panel_str;
			if(!panel_str.equals(""))
			{
				panel_str = java.net.URLDecoder.decode(panel_str);
				cstmt.setString(20,panel_str) ;					//revised_billing_details	  VARCHAR2,--pass null
			}
			else
				cstmt.setString(20,null) ;					//revised_billing_details	  VARCHAR2,--pass null

			cstmt.registerOutParameter(21,Types.VARCHAR);	//serv_panel_ind     OUT      VARCHAR2,
			cstmt.registerOutParameter(22,Types.VARCHAR);	//blng_srvc_code     OUT      VARCHAR2,
			cstmt.registerOutParameter(23,Types.VARCHAR);	//charge_stage       OUT      VARCHAR2,
			cstmt.registerOutParameter(24,Types.VARCHAR); //err_code		err_code      OUT      VARCHAR2,
			cstmt.registerOutParameter(25,Types.VARCHAR); //sys_mesg_id	sys_message_id     OUT      VARCHAR2,
			cstmt.registerOutParameter(26,Types.VARCHAR); //error_text		error_text         OUT      VARCHAR2,
			cstmt.registerOutParameter(27,Types.VARCHAR);	//preapp_msg         OUT      VARCHAR2,
			cstmt.registerOutParameter(28,Types.VARCHAR);	//excl_msg           OUT      VARCHAR2,
			cstmt.registerOutParameter(29,Types.VARCHAR); //lang_err_mesg LANG_ERR_MSG_ID    OUT	    VARCHAR2*/
			cstmt.setString(30,qty) ;		//quantity
            
			bill_str = (String)oper_map.get("bill_str");
			bill_str = bill_str==null?"":bill_str;
			bill_str = bill_str.equals("null")?"":bill_str;
			if(!bill_str.equals(""))
			{
				bill_str_index = bill_str.indexOf("::");
				charge_arr=bill_str.split("::");
				String overridden_excl_incl_ind=charge_arr[5];
	            String action_reason_code=charge_arr[8];  
				bill_str = bill_str.substring(0,bill_str_index);
				cstmt.setString(31,bill_str) ;	//changed_total_payable_amount	  VARCHAR2
                if(("null").equals(overridden_excl_incl_ind))
					cstmt.setString(32,"") ;
				else 
					cstmt.setString(32,overridden_excl_incl_ind) ;	//overridden_excl_incl_ind	  VARCHAR2 default null

				if(("null").equals(action_reason_code))
					cstmt.setString(33,"") ;
				else
					cstmt.setString(33,action_reason_code) ;	//action_reason_code	  VARCHAR2 default null
			}
			else
			{
				cstmt.setString(31,null) ;		//changed_total_payable_amount	  VARCHAR2,--pass null
				cstmt.setString(32,null) ;		//overridden_excl_incl_ind	  VARCHAR2,--pass null
				cstmt.setString(33,null) ;		//action_reason_code	  VARCHAR2,--pass null
			}
				if(desiredDate != null && desiredDate.trim().length() > 0)
					cstmt.setString(34, desiredDate);
				else
					cstmt.setString(34, null);
			cstmt.execute();
			err_code=nullSafe(cstmt.getString(24));
			//err_text=nullSafe(cstmt.getString(25));
			err_text+=nullSafe(cstmt.getString(26));
			mesg_id = nullSafe(cstmt.getString(25));
			//System.err.println("err_text GeneratePatientBill 295 err_text "+err_text);
			//System.err.println("err_text GeneratePatientBill 295  mesg_id "+mesg_id);
			if(!err_text.equals(""))
			{
				err_desc+=ErrorUtil.getMessage(mesg_id);
				err_text="";
			}else{
				//con.commit();
				err_desc+=err_text;
			}
		}
	 }catch(Exception e){
		err_desc=e.getMessage();
		e.printStackTrace();
	 }finally{
		try{
			if(cstmt!=null) cstmt.close();
//			if(con!=null)   con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	return (err_desc.equals(""))?"RECORD_INSERTED":err_desc;
}

private String callBillRecord(HashMap CommonData,Connection con){
	//Connection con = null;
	CallableStatement cstmt = null;
	String err_text	="";
	String sys_message_id="";
	String err_desc="";
	String err_code="";
	 //BillManager comon_hdr-->{episode_type=I, surgeon_code=KATHRINA, visit_id=1, episode_id=10004366, surgery_date=07/08/2007, patient_class=IP, patient_id=Z100000012, order_id=OTIP00000006126, encounter_id=10004366}
    String login_user             =	(String)CommonData.get("login_user");
	String client_ip_address	  = (String)CommonData.get("login_at_ws_no");
	String facility_id			  = (String)CommonData.get("facility_id");
	HashMap	comon_hdr_local		  = BillingUtil.getCommonHdr(facility_id,(String) CommonData.get("oper_num"));
	String patient_id			  = (String)comon_hdr_local.get("patient_id") ;
	String episode_id		      = (String)comon_hdr_local.get("episode_id") ;
	String episode_type			  = (String)comon_hdr_local.get("episode_type") ;
	String patient_class	      = (String)comon_hdr_local.get("patient_class") ;
	String visit_id			      = (String)comon_hdr_local.get("visit_id") ;
	String order_id               = (String)comon_hdr_local.get("order_id");
	//String oper_num               = (String)comon_hdr_local.get("oper_num"); //Common-ICN-0055
	String  bill_sub_regn_num = (String) oper_map.get("BillRegnNum");
	String bl_episode_type = BillingUtil.getBillingEpisodeType(patient_class,episode_type);
	
    int loop_count=1;
	try{
		//con = ConnectionManager.getConnection();
		for(int j=0;j<loop_count;j++){ 
		cstmt=con.prepareCall("{call OT_BL_ACCESSORIES_PACKAGE.OT_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,patient_id );
		cstmt.setString(3,bl_episode_type );
		cstmt.setString(4,episode_id );
		cstmt.setString(5,visit_id );
		cstmt.setString(6,order_id ) ;
		cstmt.setString(7,bill_sub_regn_num) ; // OLD CODE WAS PASSING THE BILLING_REGN_NUM FOR EACH RECORD
		//cstmt.setString(7,oper_num) ; // CHANGED TO OLD CODE BY SATHISH INSTRCUTED BY DILIP AGAINST SPR-6089 PASS THE OPER_NUM AND QUERY FOR EAC ACCESSORY USING THE OPER_NUM AND ORDER_ID
		cstmt.setString(8,client_ip_address );
		cstmt.setString(9,login_user );
		//out parameters
		cstmt.registerOutParameter(10,Types.VARCHAR);
		cstmt.registerOutParameter(11,Types.VARCHAR);
		cstmt.registerOutParameter(12,Types.VARCHAR);
		cstmt.registerOutParameter(13,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		//err_code=nullSafe(cstmt.getString(9));
		//sys_message_id=( nullSafe( cstmt.getString(12) ).equals("") )?"RECORD_INSERTED":cstmt.getString(12);
		
		err_code= nullSafe(cstmt.getString(10));
		sys_message_id=nullSafe(cstmt.getString(11));
		err_text = nullSafe(cstmt.getString(12));

		err_desc=ErrorUtil.getMessage(err_code);

		

		String err_msg =("".equals(sys_message_id))?"RECORD_INSERTED":ErrorUtil.getMessage(sys_message_id); 
		err_msg = ("".equals(err_text) && "RECORD_INSERTED".equals(err_msg) )?"RECORD_INSERTED":(!"".equals(sys_message_id))?err_msg:err_text;

		if(!"RECORD_INSERTED".equals(err_msg))
		err_desc=err_msg;
		

		if("".equals(err_desc))
		err_desc="RECORD_INSERTED";

		//System.err.println("err_text callBillRecord 365 err_desc "+err_desc);

		/*if(err_desc.equals("RECORD_INSERTED")){
			con.commit();
		}else{
			con.rollback();
		}*/
	  }
	}catch(Exception e){
		err_desc=e.getMessage();
		System.err.println("Billing Manager Err Msg in callBillRecord "+e);
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			//if(con!=null) con.close();
		}catch(Exception e){e.printStackTrace();}
	}
   return err_desc;
}
private boolean isBillingInstalled(){

	    //System.err.println("isBillingInstalledv For Record Nursing Notes and Record Surgeon Notes");
		String facility_id  = (String)  audit_flds.get(2);
		Connection con = null;
		CallableStatement cstmt = null;
		String bl_installed="";
		String err_text = "";
		String bl_interface="";
		boolean flag = false;
		String status="";
		try{
			 con = ConnectionManager.getConnection();
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
			//con.close();
			if(con != null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
		}catch(Exception e){e.printStackTrace();}
	}
	return flag;
 }

/*private String GeneratePatientBill(){

	//System.err.println(" In GeneratePatientBill  For Record Nursing and Record Surgeon Notes");
	String err_text			= "";
	String err_desc		= "";
	//String oper_desc		= "";
	String[] charge_arr=null;
	String mesg_id			= "";
	String login_by_id			  =   (String) audit_flds.get(0);	//login_by_id
	String ws_no				  =   (String)audit_flds.get(1);	//login_at_ws_no
	String facility_id			  =  (String) audit_flds.get(2);	//login_facility_id ;
	String patient_id			  = (String)comon_hdr.get("patient_id") ;
	String episode_id		      = (String)comon_hdr.get("episode_id") ;
	String episode_type		  = (String)comon_hdr.get("episode_type") ;
	String patient_class	      = (String)comon_hdr.get("patient_class") ;
	String encounter_id		  = (String)comon_hdr.get("encounter_id") ;
	String bl_episode_type    = BillingUtil.getBillingEpisodeType(patient_class,episode_type);
	String oper_date		      = (String)comon_hdr.get("surgery_date") ;
	String surgeon_code		  = (String)comon_hdr.get("surgeon_code") ;
	String visit_id			      = nullSafe((String)comon_hdr.get("visit_id")) ;
	String oper_num			  = (String)comon_hdr.get("oper_num");
	String oper_code			  = (String)oper_map.get("oper_code");
	String order_id               = (String)comon_hdr.get("order_id") ;
	String order_line_num      = BillingUtil.getOrderLineNumber(facility_id,oper_num,oper_code);
	String accessory_type	   = (String) oper_map.get("accessory_type");
	String accessory_code	   = "";
	switch(accessory_type.charAt(0)){
		case 'I': accessory_code =(String)oper_map.get("instr_code");
					accessory_type = "S";
					break;
		case 'E': accessory_code =(String)oper_map.get("equip_code");
					//accessory_type = "B";
					accessory_type = "E";
					break;
		case 'B': accessory_code =(String)oper_map.get("equip_code");
					//accessory_type = "B";
					accessory_type = "E";
					break;
		case 'P': accessory_code =(String)oper_map.get("package_code");
					accessory_type = "C";
					break;
		case 'S': accessory_code =(String)oper_map.get("implant_code");
					accessory_type = "I";
					break;
	}
	String  qty = (String) oper_map.get("quantity");
	qty = "".equals(nullSafe(qty))?"1":qty;
	String  bill_sub_regn_num = (String) oper_map.get("BillRegnNum");
	String  bill_sub_regn_line_num = (String) oper_map.get("BillRegnLineNum");
	String db_mode =  (String) oper_map.get("db_mode");
	String nursing_doc_comp_yn=( String ) oper_map.get( "nursing_doc" );
	//String  stage  =("Y".equals(nursing_doc_comp_yn) && "D".equals(db_mode))?"OTC":( ("Y".equals(nursing_doc_comp_yn) && ( "I".equals(db_mode) || "U".equals(db_mode))))?"OTF":"OTR";

	String  stage  ="D".equals(db_mode)?"OTC":("Y".equals(nursing_doc_comp_yn))?"OTF":"OTR";
	//String catalog_code = accessory_type+"#"+accessory_code;
	Connection con= null;
	CallableStatement cstmt = null;
//	HashMap hash = null;
	String panel_str = "";
	String bill_str = "";
	String pract_code_val = "";
	String[] pract_arr=null;
	int bill_str_index;
  int loop_count=2;
	try{
		
		con = ConnectionManager.getConnection();
		cstmt=con.prepareCall("{call  OT_BL_ACCESSORIES_PACKAGE.BL_INTERFACE_OPER_VALIDATION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//if(stage.equals("OTC")){
		//	loop_count=1;
		//}
		loop_count=1;
		for(int j=0;j<loop_count;j++){ 
		//Call the interface rec procedure twice. Ist time with OTR and next with OTF. In case its OTC, call only once with OTC.
			if(!stage.equals("OTC")){
				if(nursing_doc_comp_yn.equals("Y")){
					stage="OTF";
				}else{
					stage="OTR";
				}
			}

panel_str = (String)oper_map.get("panel_str");
panel_str = java.net.URLDecoder.decode(panel_str);
	if(panel_str!= null || !panel_str.equals("") || !panel_str.equals("null"))
		{
			pract_arr=panel_str.split("#");
			pract_code_val=pract_arr[5];
		}
			cstmt.setString(1,facility_id );		//v_facility_id  VARCHAR2,
			cstmt.setString(2,patient_id );			//patient_id     VARCHAR2,
			cstmt.setString(3,episode_id );			//episode_id     VARCHAR2,
			cstmt.setString(4,encounter_id );		//encounter_id   VARCHAR2,
			cstmt.setString(5,visit_id );			//visit_id       VARCHAR2,
			cstmt.setString(6,order_id );			//order_id       VARCHAR2,
			cstmt.setString(7,order_line_num);		//order_line_num	//v_order_line_num                 VARCHAR2,
			cstmt.setString(8,accessory_type );	//accessory_type VARCHAR2, -- Consumable -> C , Equipment-->B, CSSD --> S ,Implant-->I
			cstmt.setString(9,accessory_code );		//accessory_code              VARCHAR2,
			cstmt.setString(10,"Y" );				//bl_interfaced_yn	//bl_interfaced               VARCHAR2,
			cstmt.setString(11,bl_episode_type );	//bl_episode_type             VARCHAR2,
			cstmt.setString(12,bill_sub_regn_num );		//bill_sub_regn_num           VARCHAR2,
			cstmt.setString(13,bill_sub_regn_line_num );//bill_sub_regn_line_num	  VARCHAR2,
			cstmt.setString(14,stage );					//stage                 VARCHAR2, -- OTR (REQUESTING STAGE) , OTF (FINALISATION)
			cstmt.setString(15,oper_date );				//oper_date                   VARCHAR2, -- FORMAT SHOULD BE 'DD/MM/YYYY HH24:MI'

			if(!pract_code_val.equals("") ||!pract_code_val.equals(null) )
			{
			
					cstmt.setString(16,pract_code_val );

			}else
			{
					cstmt.setString(16,surgeon_code );

			}


			//cstmt.setString(16,surgeon_code );			//phy_id                      VARCHAR,
			cstmt.setString(17,ws_no ) ;				//ws_no                       VARCHAR2,
			cstmt.setString(18,login_by_id ) ;			//login user                  VARCHAR2,
			cstmt.setString(19,null) ;					//catalog_code       IN OUT   VARCHAR2
			
			panel_str = panel_str==null?"":panel_str;
			panel_str = panel_str.equals("null")?"":panel_str;
			if(!panel_str.equals("")){
				panel_str = java.net.URLDecoder.decode(panel_str);
				cstmt.setString(20,panel_str) ;					//revised_billing_details	  VARCHAR2,--pass null
			}else{
				cstmt.setString(20,null) ;					//revised_billing_details	  VARCHAR2,--pass null
			}
			cstmt.registerOutParameter(21,Types.VARCHAR);	//serv_panel_ind     OUT      VARCHAR2,
			cstmt.registerOutParameter(22,Types.VARCHAR);	//blng_srvc_code     OUT      VARCHAR2,
			cstmt.registerOutParameter(23,Types.VARCHAR);	//charge_stage       OUT      VARCHAR2,
			cstmt.registerOutParameter(24,Types.VARCHAR); //err_code		err_code      OUT      VARCHAR2,
			cstmt.registerOutParameter(25,Types.VARCHAR); //sys_mesg_id	sys_message_id     OUT      VARCHAR2,
			cstmt.registerOutParameter(26,Types.VARCHAR); //error_text		error_text         OUT      VARCHAR2,
			cstmt.registerOutParameter(27,Types.VARCHAR);	//preapp_msg         OUT      VARCHAR2,
			cstmt.registerOutParameter(28,Types.VARCHAR);	//excl_msg           OUT      VARCHAR2,
			cstmt.registerOutParameter(29,Types.VARCHAR); //lang_err_mesg LANG_ERR_MSG_ID    OUT	    VARCHAR2
			cstmt.setString(30,qty) ;		//quantity
            
			bill_str = (String)oper_map.get("bill_str");
			bill_str = bill_str==null?"":bill_str;
			bill_str = bill_str.equals("null")?"":bill_str;
			if(!bill_str.equals("")){
				bill_str_index = bill_str.indexOf("::");
				charge_arr=bill_str.split("::");
				String overridden_excl_incl_ind=charge_arr[5];
	            String action_reason_code=charge_arr[8];  
				bill_str = bill_str.substring(0,bill_str_index);
				cstmt.setString(31,bill_str) ;	//changed_total_payable_amount	  VARCHAR2
                if(("null").equals(overridden_excl_incl_ind))
				{
				cstmt.setString(32,"") ;
				}
				else 
				{
				cstmt.setString(32,overridden_excl_incl_ind) ;	//overridden_excl_incl_ind	  VARCHAR2 default null
				}

				if(("null").equals(action_reason_code))
				{
				cstmt.setString(33,"") ;
				}
				else
				{
				cstmt.setString(33,action_reason_code) ;	//action_reason_code	  VARCHAR2 default null
				}
			}else{
				cstmt.setString(31,null) ;		//changed_total_payable_amount	  VARCHAR2,--pass null
				cstmt.setString(32,null) ;		//overridden_excl_incl_ind	  VARCHAR2,--pass null
				cstmt.setString(33,null) ;		//action_reason_code	  VARCHAR2,--pass null
			}
			cstmt.execute();
			err_text+=nullSafe(cstmt.getString(24));
			err_text+=nullSafe(cstmt.getString(25));
			err_text+=nullSafe(cstmt.getString(26));
			mesg_id = nullSafe(cstmt.getString(25));
			if(!err_text.equals("")){
				err_desc+=BillingUtil.getMessage(mesg_id);
				err_text="";
			}else{
				con.commit();
			}
		}
	 }catch(Exception e){
		err_desc=e.getMessage();
		e.printStackTrace();
	 }finally{
		try{
			if(cstmt!=null) cstmt.close();
			if(con!=null)   con.close();
		}catch(Exception e){e.printStackTrace();}
	}
	return (err_desc.equals(""))?"SUCCESS":err_desc;
}*/

private String callBillRecord(HashMap CommonData){

	//System.err.println(" In callBillRecord  For Record Nursing and Record Surgeon Notes");
	Connection con = null;
	CallableStatement cstmt = null;
	String err_desc="";
	 //BillManager comon_hdr-->{episode_type=I, surgeon_code=KATHRINA, visit_id=1, episode_id=10004366, surgery_date=07/08/2007, patient_class=IP, patient_id=Z100000012, order_id=OTIP00000006126, encounter_id=10004366}
    String login_user             =	(String)CommonData.get("login_user");
	String client_ip_address	  = (String)CommonData.get("login_at_ws_no");
	String facility_id			  = (String)CommonData.get("facility_id");
	HashMap	comon_hdr_local		  = BillingUtil.getCommonHdr(facility_id,(String) CommonData.get("oper_num"));
	String patient_id			  = (String)comon_hdr_local.get("patient_id") ;
	String episode_id		      = (String)comon_hdr_local.get("episode_id") ;
	String episode_type			  = (String)comon_hdr_local.get("episode_type") ;
	String patient_class	      = (String)comon_hdr_local.get("patient_class") ;
	String visit_id			      = (String)comon_hdr_local.get("visit_id") ;
	String order_id               = (String)comon_hdr_local.get("order_id");
	//String oper_num               = (String)comon_hdr_local.get("oper_num"); //Common-ICN-0055
	String  bill_sub_regn_num = (String) oper_map.get("BillRegnNum");
	String bl_episode_type = BillingUtil.getBillingEpisodeType(patient_class,episode_type);
	
    int loop_count=1;
	try{
		con = ConnectionManager.getConnection();
		for(int j=0;j<loop_count;j++){ 
		cstmt=con.prepareCall("{call OT_BL_ACCESSORIES_PACKAGE.OT_BL_INTERFACED_REC(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,patient_id );
		cstmt.setString(3,bl_episode_type );
		cstmt.setString(4,episode_id );
		cstmt.setString(5,visit_id );
		cstmt.setString(6,order_id ) ;
		cstmt.setString(7,bill_sub_regn_num) ; // OLD CODE WAS PASSING THE BILLING_REGN_NUM FOR EACH RECORD
		//cstmt.setString(7,oper_num) ; // CHANGED TO OLD CODE BY SATHISH INSTRCUTED BY DILIP AGAINST SPR-6089 PASS THE OPER_NUM AND QUERY FOR EAC ACCESSORY USING THE OPER_NUM AND ORDER_ID
		cstmt.setString(8,client_ip_address );
		cstmt.setString(9,login_user );
		//out parameters
		cstmt.registerOutParameter(10,Types.VARCHAR);
		cstmt.registerOutParameter(11,Types.VARCHAR);
		cstmt.registerOutParameter(12,Types.VARCHAR);
		cstmt.registerOutParameter(13,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		//err_code=nullSafe(cstmt.getString(9));
		err_desc=( nullSafe( cstmt.getString(12) ).equals("") )?"RECORD_INSERTED":cstmt.getString(12);
		if(err_desc.equals("RECORD_INSERTED")){
			con.commit();
		}else{
			con.rollback();
		}
	  }
	}catch(Exception e){
		err_desc=e.getMessage();
		System.err.println("Billing Manager Err Msg in callBillRecord "+e);
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con);//Changed on 02/07/13 against UAT5 - Connection Issue
			//con.close();
		}catch(Exception e){e.printStackTrace();}
	}
   return err_desc;
}

//Filtering the null value and "null" string
	 private String nullSafe(String s){
        return s!= null && s.intern()!="null" ? s : "";
    }


};
