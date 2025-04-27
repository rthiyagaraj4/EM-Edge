/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class TermSetServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String termset_id = "";
	String termset_desc = "";
	String diag_spec="";
	String proc_spec="";
	String build_stat="";
	String build_eoc="";
	String priority_appl="";
	String agegroup_appl="";
	String nature_appl="";
	String factors_appl="";
	String notification_appl="";
	String sensitivity_appl="";
	String severity_appl="";
	String onsettype_appl="";
	String enc_stage_appl_yn="";
	String cutoff_period="";
	String cutoff_unit="";
	String classification_level="";
	String eff_status = "";
	String level1_desc="";
	String level1_codelength="";
	String level2_desc="";
	String level2_codelength="";
	String level3_desc="";
	String level3_codelength="";
	String level4_desc="";
	String level4_codelength="";
	String level5_desc="";
	String level5_codelength="";
	String level6_desc="";
	String level6_codelength="";
	String level7_desc="";
	String level7_codelength="";
	String level8_desc="";
	String level8_codelength="";
	String level9_desc="";
	String level9_codelength="";
	String level10_desc="";
	String level10_codelength="";

	String added_by_id = "";
	//String addedDate = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	String error_value = "0";
	String diag_class_appl = "";
	String appl_for_recoders = "";
	String free_txt_appl = "";

	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	String inpatient_appl="";
	String daycare_appl="";
	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	
	String diag_classification_mand="";  //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020
	
	
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

    HashMap TermsetValues=new HashMap();

	public void init(ServletConfig config)throws ServletException{

		super.init(config);
		this.config = config;
	}

//end of init()

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
		{
		this.out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		session = request.getSession(false);

		this.prop = (java.util.Properties)session.getValue("jdbc");
		this.added_facility_id = (String)session.getValue("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id		= (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
		try{
			mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			if(mode.equals("1")) insert(request,response);
     		if(mode.equals("2")) modify(request,response);

		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of TermSetServlet.java"+e);
			e.printStackTrace();
		}
		finally{
			if ( TermsetValues != null) TermsetValues.clear();
		}
	}//end of doPost()

public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException{
	try{
		this.out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		doPost(request,response);
	}
	catch(Exception e){
		//out.println("Exception in doGet() of TermSetServlet.java"+e);
		e.printStackTrace();
	}
}//end of doGet()

//***********Start of Insert************************

private void insert(HttpServletRequest request,HttpServletResponse response){
	try{
		added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		//addedDate = dateFormat.format(new java.util.Date());
		added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 

		termset_id = request.getParameter("TermSet_ID")==null?"":request.getParameter("TermSet_ID");  
		termset_desc = request.getParameter("TermSet_Desc")==null?"":request.getParameter("TermSet_Desc");
		diag_spec = request.getParameter("Diag_Spec_yn")==null?"N":request.getParameter("Diag_Spec_yn");
		proc_spec = request.getParameter("Proc_Spec_yn")==null?"N":request.getParameter("Proc_Spec_yn");
		build_stat = request.getParameter("Build_Statistics_yn")==null?"N":request.getParameter("Build_Statistics_yn");
		build_eoc = request.getParameter("Build_Episode_yn")==null?"N":request.getParameter("Build_Episode_yn");
		classification_level = request.getParameter("Classification_Levels")==null?"":request.getParameter("Classification_Levels");
		priority_appl = request.getParameter("Priority_yn")==null?"N":request.getParameter("Priority_yn");
		agegroup_appl = request.getParameter("Age_Group_yn")==null?"N":request.getParameter("Age_Group_yn");
		nature_appl = request.getParameter("Diag_Nature_yn")==null?"N":request.getParameter("Diag_Nature_yn");
		factors_appl = request.getParameter("Diag_Factor_yn")==null?"N":request.getParameter("Diag_Factor_yn");
		notification_appl = request.getParameter("Notification_yn")==null?"N":request.getParameter("Notification_yn");
		sensitivity_appl = request.getParameter("Sensitivity_yn")==null?"N":request.getParameter("Sensitivity_yn");
		severity_appl = request.getParameter("Severity_yn")==null?"N":request.getParameter("Severity_yn");
		onsettype_appl = request.getParameter("Onset_Type_yn")==null?"N":request.getParameter("Onset_Type_yn");
		enc_stage_appl_yn = request.getParameter("enc_stage_appl_yn")==null?"N":request.getParameter("enc_stage_appl_yn");
		cutoff_period = request.getParameter("CutOff_Period")==null?"":request.getParameter("CutOff_Period");
		cutoff_unit = request.getParameter("CutOff_Unit")==null?"":request.getParameter("CutOff_Unit");
		eff_status = request.getParameter("eff_status_yn")==null?"D":request.getParameter("eff_status_yn");

		level1_desc = request.getParameter("Description1")==null?"":request.getParameter("Description1");
		level1_codelength = request.getParameter("CodeLength1")==null?"":request.getParameter("CodeLength1");
		level2_desc = request.getParameter("Description2")==null?"":request.getParameter("Description2");
		level2_codelength = request.getParameter("CodeLength2")==null?"":request.getParameter("CodeLength2");
		level3_desc = request.getParameter("Description3")==null?"":request.getParameter("Description3");
    	level3_codelength = request.getParameter("CodeLength3")==null?"":request.getParameter("CodeLength3");
		level4_desc = request.getParameter("Description4")==null?"":request.getParameter("Description4");
		level4_codelength = request.getParameter("CodeLength4")==null?"":request.getParameter("CodeLength4");
		level5_desc = request.getParameter("Description5")==null?"":request.getParameter("Description5");
    	level5_codelength = request.getParameter("CodeLength5")==null?"":request.getParameter("CodeLength5");
		level6_desc = request.getParameter("Description6")==null?"":request.getParameter("Description6");
		level6_codelength = request.getParameter("CodeLength6")==null?"":request.getParameter("CodeLength6");
		level7_desc = request.getParameter("Description7")==null?"":request.getParameter("Description7");
		level7_codelength = request.getParameter("CodeLength7")==null?"":request.getParameter("CodeLength7");
		level8_desc = request.getParameter("Description8")==null?"":request.getParameter("Description8");
		level8_codelength = request.getParameter("CodeLength8")==null?"":request.getParameter("CodeLength8");
		level9_desc = request.getParameter("Description9")==null?"":request.getParameter("Description9");
		level9_codelength = request.getParameter("CodeLength9")==null?"":request.getParameter("CodeLength9");
		level10_desc = request.getParameter("Description10")==null?"":request.getParameter("Description10");
    	level10_codelength = request.getParameter("CodeLength10")==null?"":request.getParameter("CodeLength10");
		diag_class_appl   = request.getParameter("diag_class_appl")==null?"N":request.getParameter("diag_class_appl");
		/*Getting the parameter for Application readcoders 12/18/2008 */
		appl_for_recoders   = request.getParameter("appl_for_recoders")==null?"N":request.getParameter("appl_for_recoders");	

		/* 12/18/2008 end here*/
/*
			PMG20099-CRF-0089-MR Free Text Enhance ment. Monday, June 22, 2009
*/
		free_txt_appl   = request.getParameter("free_txt_appl")==null?"N":request.getParameter("free_txt_appl");


		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		inpatient_appl = request.getParameter("inpatient_appl_yn")==null?"N":request.getParameter("inpatient_appl_yn");
		daycare_appl = request.getParameter("daycare_appl_yn")==null?"N":request.getParameter("daycare_appl_yn");
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		
		diag_classification_mand   = request.getParameter("diagnosis_class_mand_yn")==null?"N":request.getParameter("diagnosis_class_mand_yn"); //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 

        TermsetValues.put("TERM_SET_ID",termset_id);
        TermsetValues.put("TERM_SET_DESC",termset_desc);
        TermsetValues.put("DIAG_SPEC_YN",diag_spec);
        TermsetValues.put("PROC_SPEC_YN",proc_spec);
        TermsetValues.put("INCL_FOR_STATS_YN",build_stat);
        TermsetValues.put("BUILD_EOC_YN",build_eoc);
        TermsetValues.put("DEFN_LEVELS",classification_level);
        TermsetValues.put("PRIORITY_APPL_YN",priority_appl);
        TermsetValues.put("AGE_GROUP_APPL_YN",agegroup_appl);
        TermsetValues.put("NATURE_APPL_YN",nature_appl);
        TermsetValues.put("FACTORS_APPL_YN",factors_appl);
        TermsetValues.put("NOTIFICATION_APPL_YN",notification_appl);
        TermsetValues.put("SENSITIVITY_APPL_YN",sensitivity_appl);
        TermsetValues.put("SEVERITY_APPL_YN",severity_appl);
        TermsetValues.put("ONSET_TYPE_APPL_YN",onsettype_appl);
        TermsetValues.put("ENC_STAGE_APPL_YN",enc_stage_appl_yn);
        TermsetValues.put("ONSET_TYPE_CUTOFF_PRD",cutoff_period);
        TermsetValues.put("ONSET_TYPE_CUTOFF_UNIT",cutoff_unit);
		TermsetValues.put("LEVEL_1_DESC",level1_desc);          
		TermsetValues.put("LEVEL_1_CODE_LENGTH",level1_codelength); 
		TermsetValues.put("LEVEL_2_DESC",level2_desc);          
		TermsetValues.put("LEVEL_2_CODE_LENGTH",level2_codelength);	
		TermsetValues.put("LEVEL_3_DESC",level3_desc);          
		TermsetValues.put("LEVEL_3_CODE_LENGTH",level3_codelength);	
        TermsetValues.put("LEVEL_4_DESC",level4_desc);          
		TermsetValues.put("LEVEL_4_CODE_LENGTH",level4_codelength);	
        TermsetValues.put("LEVEL_5_DESC",level5_desc);          
		TermsetValues.put("LEVEL_5_CODE_LENGTH",level5_codelength);	
        TermsetValues.put("LEVEL_6_DESC",level6_desc);          
		TermsetValues.put("LEVEL_6_CODE_LENGTH",level6_codelength);	
        TermsetValues.put("LEVEL_7_DESC",level7_desc);          
		TermsetValues.put("LEVEL_7_CODE_LENGTH",level7_codelength);	
        TermsetValues.put("LEVEL_8_DESC",level8_desc);          
		TermsetValues.put("LEVEL_8_CODE_LENGTH",level8_codelength);
        TermsetValues.put("LEVEL_9_DESC",level9_desc);          
		TermsetValues.put("LEVEL_9_CODE_LENGTH",level9_codelength);	
        TermsetValues.put("LEVEL_10_DESC",level10_desc);          
		TermsetValues.put("LEVEL_10_CODE_LENGTH",level10_codelength);		
		TermsetValues.put("DIAG_CLASS_APPL_YN",diag_class_appl);
		TermsetValues.put("RECODERS_APPL_YN ",appl_for_recoders);
		TermsetValues.put("FREE_TEXT_APPLICABLE_YN ",free_txt_appl);


		TermsetValues.put("EFF_STATUS",eff_status);
		TermsetValues.put("ADDED_BY_ID",added_by_id);
        TermsetValues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        TermsetValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        TermsetValues.put("ADDED_FACILITY_ID",added_facility_id);
        TermsetValues.put("MODIFIED_BY_ID",modified_by_id);
        TermsetValues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        TermsetValues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        TermsetValues.put("MODIFIED_FACILITY_ID",modified_facility_id);
		//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
		TermsetValues.put("INPATIENT_APPL_YN",inpatient_appl);
        TermsetValues.put("DAYCARE_APPL_YN",daycare_appl);
		//Added by KAMATCHI S for ML-MMOH-CRF-1581 END
        
        TermsetValues.put("DIAGNOSIS_CLASS_MAND_YN",diag_classification_mand); //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 
        
		String tabname="MR_TERM_SET";
		String dupfields[] = {"TERM_SET_ID"};
		try
		{
		boolean local_ejbs = false;
			
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[4];
		argArray[0] = prop;
		argArray[1] = TermsetValues;
		argArray[2] = dupfields;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = prop.getClass();
		paramArray[1] = TermsetValues.getClass();
		paramArray[2] = dupfields.getClass();
		paramArray[3] = tabname.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		boolean inserted = (((Boolean)results.get("status")).booleanValue());
        String error = (String) results.get("error") ;
         if ( inserted )
		 {
				error_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		  }
		  else
		  {
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		   }
		if ( results != null) results.clear();
		}
		catch(Exception exp)
		{
		         // out.println("From Servlet--Calling EJB:"+exp);
                  exp.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
	}
		catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}//end of catch
}//end of insert

//*******************************************************************************
public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		try{	

			added_by_id 	= prop.getProperty( "login_user" ) ;
			added_facility_id=(String)session.getValue("facility_id");
			

			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
		    modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = added_facility_id ;
			appl_for_recoders="";
			

		termset_id = request.getParameter("TermSet_ID")==null?"":request.getParameter("TermSet_ID");  
		termset_desc = request.getParameter("TermSet_Desc")==null?"":request.getParameter("TermSet_Desc");
		diag_spec = request.getParameter("diag_spec")==null?"N":request.getParameter("diag_spec");
		proc_spec = request.getParameter("proc_spec")==null?"N":request.getParameter("proc_spec");
		build_stat = request.getParameter("build_stat")==null?"N":request.getParameter("build_stat");
		build_eoc = request.getParameter("build_eoc")==null?"N":request.getParameter("build_eoc");
		classification_level = request.getParameter("classification_level1")==null?"":request.getParameter("classification_level1");
		priority_appl = request.getParameter("priority")==null?"N":request.getParameter("priority");
		agegroup_appl = request.getParameter("agegroup")==null?"N":request.getParameter("agegroup");
		nature_appl = request.getParameter("nature")==null?"N":request.getParameter("nature");
		factors_appl = request.getParameter("factors")==null?"N":request.getParameter("factors");
		notification_appl = request.getParameter("notification")==null?"N":request.getParameter("notification");
		sensitivity_appl = request.getParameter("sensitivity")==null?"N":request.getParameter("sensitivity");
		severity_appl = request.getParameter("severity")==null?"N":request.getParameter("severity");
		onsettype_appl = request.getParameter("onset_type")==null?"N":request.getParameter("onset_type");
		enc_stage_appl_yn = request.getParameter("enc_stage_appl_yn")==null?"N":request.getParameter("enc_stage_appl_yn");
		cutoff_period = request.getParameter("CutOff_Period")==null?"":request.getParameter("CutOff_Period");
		cutoff_unit = request.getParameter("cutoff_unit1")==null?"":request.getParameter("cutoff_unit1");
		eff_status = request.getParameter("eff_status_yn")==null?"D":request.getParameter("eff_status_yn");

		level1_desc = request.getParameter("Description1")==null?"":request.getParameter("Description1");
		level1_codelength = request.getParameter("CodeLength1")==null?"":request.getParameter("CodeLength1");
		level2_desc = request.getParameter("Description2")==null?"":request.getParameter("Description2");
		level2_codelength = request.getParameter("CodeLength2")==null?"":request.getParameter("CodeLength2");
		level3_desc = request.getParameter("Description3")==null?"":request.getParameter("Description3");
    	level3_codelength = request.getParameter("CodeLength3")==null?"":request.getParameter("CodeLength3");
		level4_desc = request.getParameter("Description4")==null?"":request.getParameter("Description4");
		level4_codelength = request.getParameter("CodeLength4")==null?"":request.getParameter("CodeLength4");
		level5_desc = request.getParameter("Description5")==null?"":request.getParameter("Description5");
    	level5_codelength = request.getParameter("CodeLength5")==null?"":request.getParameter("CodeLength5");
		level6_desc = request.getParameter("Description6")==null?"":request.getParameter("Description6");
		level6_codelength = request.getParameter("CodeLength6")==null?"":request.getParameter("CodeLength6");
		level7_desc = request.getParameter("Description7")==null?"":request.getParameter("Description7");
		level7_codelength = request.getParameter("CodeLength7")==null?"":request.getParameter("CodeLength7");
		level8_desc = request.getParameter("Description8")==null?"":request.getParameter("Description8");
		level8_codelength = request.getParameter("CodeLength8")==null?"":request.getParameter("CodeLength8");
		level9_desc = request.getParameter("Description9")==null?"":request.getParameter("Description9");
		level9_codelength = request.getParameter("CodeLength9")==null?"":request.getParameter("CodeLength9");
		level10_desc = request.getParameter("Description10")==null?"":request.getParameter("Description10");
    	level10_codelength = request.getParameter("CodeLength10")==null?"":request.getParameter("CodeLength10");
		diag_class_appl   = request.getParameter("diag_class_appl")==null?"N":request.getParameter("diag_class_appl");

		/*Getting the parameter for Application readcoders 12/18/2008 */
		appl_for_recoders   = request.getParameter("appl_for_recoders")==null?"N":request.getParameter("appl_for_recoders");
		/* 12/18/2008 end here*/
/*  
FD-PMG20099-CRF-0089-MR   Monday, June 22, 2009 Enhancement.
*/
		free_txt_appl   = request.getParameter("free_txt_appl")==null?"N":request.getParameter("free_txt_appl");

		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		inpatient_appl = request.getParameter("inpatient_appl_yn")==null?"N":request.getParameter("inpatient_appl_yn");
		daycare_appl = request.getParameter("daycare_appl_yn")==null?"N":request.getParameter("daycare_appl_yn");
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		
		diag_classification_mand   = request.getParameter("diagnosis_class_mand_yn")==null?"N":request.getParameter("diagnosis_class_mand_yn");//Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020
		

		HashMap TermSetModifyValues=new HashMap();

        TermSetModifyValues.put("TERM_SET_ID",termset_id);
        TermSetModifyValues.put("TERM_SET_DESC",termset_desc);
        TermSetModifyValues.put("DIAG_SPEC_YN",diag_spec);
        TermSetModifyValues.put("PROC_SPEC_YN",proc_spec);
        TermSetModifyValues.put("INCL_FOR_STATS_YN",build_stat);
        TermSetModifyValues.put("BUILD_EOC_YN",build_eoc);
        TermSetModifyValues.put("DEFN_LEVELS",classification_level);
        TermSetModifyValues.put("PRIORITY_APPL_YN",priority_appl);
        TermSetModifyValues.put("AGE_GROUP_APPL_YN",agegroup_appl);
        TermSetModifyValues.put("NATURE_APPL_YN",nature_appl);
        TermSetModifyValues.put("FACTORS_APPL_YN",factors_appl);
        TermSetModifyValues.put("NOTIFICATION_APPL_YN",notification_appl);
        TermSetModifyValues.put("SENSITIVITY_APPL_YN",sensitivity_appl);
        TermSetModifyValues.put("SEVERITY_APPL_YN",severity_appl);
        TermSetModifyValues.put("ONSET_TYPE_APPL_YN",onsettype_appl);
        TermSetModifyValues.put("ENC_STAGE_APPL_YN",enc_stage_appl_yn);
        TermSetModifyValues.put("ONSET_TYPE_CUTOFF_PRD",cutoff_period);
        TermSetModifyValues.put("ONSET_TYPE_CUTOFF_UNIT",cutoff_unit);
		TermSetModifyValues.put("LEVEL_1_DESC",level1_desc);          
		TermSetModifyValues.put("LEVEL_1_CODE_LENGTH",level1_codelength); 
		TermSetModifyValues.put("LEVEL_2_DESC",level2_desc);          
		TermSetModifyValues.put("LEVEL_2_CODE_LENGTH",level2_codelength);	
		TermSetModifyValues.put("LEVEL_3_DESC",level3_desc);          
		TermSetModifyValues.put("LEVEL_3_CODE_LENGTH",level3_codelength);	
        TermSetModifyValues.put("LEVEL_4_DESC",level4_desc);          
		TermSetModifyValues.put("LEVEL_4_CODE_LENGTH",level4_codelength);	
        TermSetModifyValues.put("LEVEL_5_DESC",level5_desc);          
		TermSetModifyValues.put("LEVEL_5_CODE_LENGTH",level5_codelength);	
        TermSetModifyValues.put("LEVEL_6_DESC",level6_desc);          
		TermSetModifyValues.put("LEVEL_6_CODE_LENGTH",level6_codelength);	
        TermSetModifyValues.put("LEVEL_7_DESC",level7_desc);          
		TermSetModifyValues.put("LEVEL_7_CODE_LENGTH",level7_codelength);	
        TermSetModifyValues.put("LEVEL_8_DESC",level8_desc);          
		TermSetModifyValues.put("LEVEL_8_CODE_LENGTH",level8_codelength);
        TermSetModifyValues.put("LEVEL_9_DESC",level9_desc);          
		TermSetModifyValues.put("LEVEL_9_CODE_LENGTH",level9_codelength);	
        TermSetModifyValues.put("LEVEL_10_DESC",level10_desc);          
		TermSetModifyValues.put("LEVEL_10_CODE_LENGTH",level10_codelength);
		TermSetModifyValues.put("DIAG_CLASS_APPL_YN",diag_class_appl);
		TermSetModifyValues.put("RECODERS_APPL_YN ",appl_for_recoders);
		TermSetModifyValues.put("FREE_TEXT_APPLICABLE_YN ",free_txt_appl);

		TermSetModifyValues.put("EFF_STATUS",eff_status);
		TermSetModifyValues.put("ADDED_BY_ID",added_by_id);
        TermSetModifyValues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        TermSetModifyValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        TermSetModifyValues.put("ADDED_FACILITY_ID",added_facility_id);
        TermSetModifyValues.put("MODIFIED_BY_ID",modified_by_id);
        TermSetModifyValues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        TermSetModifyValues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        TermSetModifyValues.put("MODIFIED_FACILITY_ID",modified_facility_id);

		//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
		TermSetModifyValues.put("INPATIENT_APPL_YN",inpatient_appl);
        TermSetModifyValues.put("DAYCARE_APPL_YN",daycare_appl);
		//Added by KAMATCHI S for ML-MMOH-CRF-1581 END
        
        TermSetModifyValues.put("DIAGNOSIS_CLASS_MAND_YN",diag_classification_mand); //Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 

		HashMap pkfields=new HashMap();
		pkfields.put("TERM_SET_ID",termset_id);

		try
		{
		String tabname="MR_TERM_SET";

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);

		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = prop;
		argArray[1] = TermSetModifyValues;
		argArray[2] = pkfields;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = prop.getClass();
		paramArray[1] = TermSetModifyValues.getClass();
		paramArray[2] = pkfields.getClass();
		paramArray[3] = tabname.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		String error_value = "0" ;
		boolean updated = (((Boolean)results.get("status")).booleanValue());
        String error = (String) results.get("error") ;
         if ( updated )
		   {
				error_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		   }
		   else
		   {
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		   }
		if ( results != null) results.clear();	
		}
		catch(Exception exp)
		{
                  exp.printStackTrace();
				  String error =exp.getMessage();
				  String error_value = "0" ;
			      response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		if ( TermSetModifyValues != null) TermSetModifyValues.clear();
		if ( pkfields != null) pkfields.clear();	
	}
		catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}//end of catch
}
	
}
