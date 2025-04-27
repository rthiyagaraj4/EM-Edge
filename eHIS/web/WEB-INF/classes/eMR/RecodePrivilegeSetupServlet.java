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

public class RecodePrivilegeSetupServlet extends HttpServlet
{

	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;

	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";

	//String stage_code="";
	String stage_description	= "";
	String srl_no						= "";
	String color_ind					= "";
	String text_color				= "";
	String specific_indicator	= "";
	String cutoff_period			= "";
	String days_fromVisit		= "";
	String allow_auth				= "";
	String confirm_not_appl         =""; // added by mujafar for ML-MMOH-CRF-0878
	String isConfirmApplicable      = "";
	String action_ifnot_done	= "";
	//String term_set="";
	//String term_code="";
	//String term_desc="";
	String diagnosis_clasifi		= "";
	String accuracy					= "";
	String severity					= "";
	String priority					= "";
	String onset_type				= "";
	String onset_date				= "";
	String applicable_side		= "";
	String status						= "";
	String asOn_Date				= "";
	String remarks					= "";
	String mode						= "";
	String list_auth_users		= "";
	String code_xtn_yn			= "";
	String laterality_yn			= "";
	String proc_remarks_yn	= "";
	String proc_status_yn		= "";//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
	
	String enc_stage="";  /* HAS-CRF-300 */
	String chife_compln=""; /* HAS-CRF-300 */
	String notify=""; /* HAS-CRF-300 */

	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	String inpatient_appl="";
	String daycare_appl="";
	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	


public void init(ServletConfig config)throws ServletException{
	super.init(config);
	this.config = config;
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws javax.servlet.ServletException,IOException{
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
		try
		{
			String _update_mode_yn=checkForNull(request.getParameter("_update_mode_yn"));
			if(_update_mode_yn.equals("update_db"))
				 modify_recordPrivilegeSetUp(request,response);
				
				else
			insert_recordPrivilegeSetUp(request,response);
			
		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of RecordPrevilagesetupServlet.java"+e);
			
			e.printStackTrace();
		}
	}//end of doPost()
	

public void doGet(HttpServletRequest request,HttpServletResponse response)throws javax.servlet.ServletException,IOException{

	try
		{
			
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}
		catch(Exception e){
			//out.println("Exception in doGet() of RecodePrivilegeSetupServlet.java"+e);
			e.printStackTrace();
		}

}
public void insert_recordPrivilegeSetUp(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
	
	Connection con =null;
	boolean flag=true;
try{
	    HashMap RecodePrivilegeSetup=new HashMap();

		

		con = ConnectionManager.getConnection(request);

	    added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 

		//stage_code = checkForNull(request.getParameter("stage_code"));
		stage_description = checkForNull(request.getParameter("stage_description"));
		int srl_no = Integer.parseInt(checkForNull(request.getParameter("srl_no")));
		
		
		
		color_ind = checkForNull(request.getParameter("color_ind"));
		text_color = checkForNull(request.getParameter("text_color"));
		specific_indicator = checkForNull(request.getParameter("specific_indicator"));
		cutoff_period = checkForNull(request.getParameter("cutoff_period"));
		int cut_period=0;
		if(cutoff_period.equals("")){
			cut_period=0;
		}
		
		days_fromVisit = checkForNull(request.getParameter("days_fromVisit"));
		int days_visit=0;
		if(days_fromVisit.equals("")){
			days_visit=0;
		}
		allow_auth = checkForNull(request.getParameter("allow_auth"));
		confirm_not_appl = checkForNull(request.getParameter("confirm_not_appl"));
		isConfirmApplicable = checkForNull(request.getParameter("isConfirmApplicable")); // added by mujafar for ML-MMOH-CRF-0878
		action_ifnot_done = checkForNull(request.getParameter("action_ifnot_done"));
		//term_set = checkForNull(request.getParameter("term_set"));
		//term_code = checkForNull(request.getParameter("term_code"));
		//term_desc = checkForNull(request.getParameter("term_desc"));
		diagnosis_clasifi	= checkForNull(request.getParameter("diagnosis_clasifi"),"N");
		accuracy				= checkForNull(request.getParameter("accuracy"),"N");
		severity				= checkForNull(request.getParameter("severity"),"N");
		priority					= checkForNull(request.getParameter("priority"),"N");
		onset_type			= checkForNull(request.getParameter("onset_type"),"N");
		onset_date			= checkForNull(request.getParameter("onset_date"),"N");
		applicable_side		= checkForNull(request.getParameter("applicable_side"),"N");
		status					= checkForNull(request.getParameter("status"),"N");
		remarks				= checkForNull(request.getParameter("remarks"),"N");
		asOn_Date			= checkForNull(request.getParameter("asOn_Date"),"N");
		/*Added For SRR-CRF-303.1 (Procedure) on 12/3/2009*/
		laterality_yn			= checkForNull(request.getParameter("laterality_yn"),"N");
		code_xtn_yn		= checkForNull(request.getParameter("code_xtn_yn"),"N");
		proc_remarks_yn	= checkForNull(request.getParameter("proc_remarks_yn"),"N");
		/*Added On 2/15/2010 for SRR-CRF-303.2(IN015597)*/
		proc_status_yn	= checkForNull(request.getParameter("proc_status_yn"),"N");

		list_auth_users		= checkForNull(request.getParameter("list_auth_users"));
		
		/* Below lines added by Venkatesh.S against HAS-CRF-300 */
        enc_stage		= checkForNull(request.getParameter("enc_stage"),"N");
        chife_compln	= checkForNull(request.getParameter("chife_compln"),"N");
        notify	= checkForNull(request.getParameter("notify"),"N");
		/* END HAS-CRF-300 */

		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		inpatient_appl = request.getParameter("inpatient_appl")==null?"N":request.getParameter("inpatient_appl");
		daycare_appl = request.getParameter("daycare_appl")==null?"N":request.getParameter("daycare_appl");
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		
		//RecodePrivilegeSetup.put("STAGE_CODE",stage_code);
		RecodePrivilegeSetup.put("STAGE_NO",srl_no);
		RecodePrivilegeSetup.put("STAGE_DESC",stage_description);

		RecodePrivilegeSetup.put("COLOUR_IND",color_ind);
		RecodePrivilegeSetup.put("TEXT_COLOUR_IND",text_color);
		RecodePrivilegeSetup.put("SPECIFIC_IND",specific_indicator);

		// modified for Date:Friday, February 12, 2010 icn:241

		if(!cutoff_period.equals(""))
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_VSTCMPL",cutoff_period);
		else
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_VSTCMPL",cut_period);
         if(!days_fromVisit.equals(""))
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_DISC",days_fromVisit);
		else
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_DISC",days_visit);
		
		RecodePrivilegeSetup.put("ACTION_IF_NOT_DONE",action_ifnot_done);
		
		if(isConfirmApplicable.equals("true")) // added by mujafar for ML-MMOH-CRF-0878
		RecodePrivilegeSetup.put("CONFIRM_APPL",confirm_not_appl);	
		
		RecodePrivilegeSetup.put("ALLOW_AUTHORIZATION_YN",allow_auth);
		//RecodePrivilegeSetup.put("TERM_SET_APPL_YN",term_set);
		//RecodePrivilegeSetup.put("TERM_CODE_APPL_YN",term_code);
		//RecodePrivilegeSetup.put("TERM_DESC_APPL_YN",term_desc);
		RecodePrivilegeSetup.put("DIAG_CLASS_APPL_YN",diagnosis_clasifi);
		RecodePrivilegeSetup.put("ACCURACY_APPL_YN",accuracy);
		RecodePrivilegeSetup.put("SEVERITY_APPL_YN",severity);
		RecodePrivilegeSetup.put("PRIORITY_APPL_YN",priority);
		RecodePrivilegeSetup.put("ONSET_TYPE_APPL_YN",onset_type);
		RecodePrivilegeSetup.put("ONSET_DATE_APPL_YN",onset_date);
		RecodePrivilegeSetup.put("APPLICABLE_SIDE_APPL_YN",applicable_side);
		RecodePrivilegeSetup.put("STATUS_APPL_YN",status);
		RecodePrivilegeSetup.put("REMARKS_APPL_YN",remarks);
		RecodePrivilegeSetup.put("AS_ON_DATE_APPL_YN",asOn_Date);
		RecodePrivilegeSetup.put("LATERALITY_APPL_YN",laterality_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("CODE_EXTENSION_APPL_YN",code_xtn_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("PROC_REMARKS_APPL_YN",proc_remarks_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("PROC_STATUS_APPL_YN",proc_status_yn);////Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
		/* Below lines added by Venkatesh.S against HAS-CRF-300 */
		RecodePrivilegeSetup.put("ENC_STAGE_YN",enc_stage);
	    RecodePrivilegeSetup.put("CHIFE_COMP_YN",chife_compln);
	    RecodePrivilegeSetup.put("NOTIFIY_YN",notify);
		/* END HAS-CRF-300 */
		RecodePrivilegeSetup.put("ADDED_BY_ID",added_by_id);
        RecodePrivilegeSetup.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        RecodePrivilegeSetup.put("ADDED_AT_WS_NO",added_at_ws_no);
        RecodePrivilegeSetup.put("ADDED_FACILITY_ID",added_facility_id);
        RecodePrivilegeSetup.put("MODIFIED_BY_ID",modified_by_id);
        RecodePrivilegeSetup.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        RecodePrivilegeSetup.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        RecodePrivilegeSetup.put("MODIFIED_FACILITY_ID",modified_facility_id);

		//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
		RecodePrivilegeSetup.put("INPATIENT_APPL_YN",inpatient_appl);
        RecodePrivilegeSetup.put("DAYCARE_APPL_YN",daycare_appl);
		//Added by KAMATCHI S for ML-MMOH-CRF-1581 END

		String dupfields[] = {"STAGE_NO"};
		String tabname="MR_RECODE_PRIVI_SETUP";

		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = prop;
			argArray[1] = RecodePrivilegeSetup;
			argArray[2] = dupfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = prop.getClass();
			paramArray[1] = RecodePrivilegeSetup.getClass();
			paramArray[2] = dupfields.getClass();
			paramArray[3] = tabname.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			boolean inserted = (((Boolean)results.get("status")).booleanValue());
			String error = (String) results.get("error") ;
			 if ( inserted )
			 {
				   if(specific_indicator.equals("*ALL")){

					String error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					
			  }
			 else{
					String user_id="";
					String user_name="";
					String auth_user="";
					StringBuffer _sqlDtl=new StringBuffer();
					int insert_records=0;

					try{
						PreparedStatement pstmt = null;
						
			            
							if (!list_auth_users.equals("")){
							   StringTokenizer splitedtoken = null;
								String tokenvalue = "";
								tokenvalue="";
								int i = 0;
							   StringTokenizer token1=new StringTokenizer(list_auth_users,"~");
								while(token1.hasMoreTokens()){
										i++ ;
										tokenvalue      = token1.nextToken();
										splitedtoken=new StringTokenizer(tokenvalue,"`");
									while (splitedtoken.hasMoreTokens()){
										user_id		=	splitedtoken.nextToken();
										user_name			=	splitedtoken.nextToken();
										auth_user			=	splitedtoken.nextToken();
										try{
										if(_sqlDtl.length() > 0) _sqlDtl.delete(0,_sqlDtl.length());
										 _sqlDtl=_sqlDtl.append("Insert into MR_RECODE_PRIVI_SETUP_DTL (STAGE_NO,FACILITY_ID,APPL_USER_ID,AUTHORIZE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
										 pstmt = con.prepareStatement( _sqlDtl.toString() ) ;
										 pstmt.setInt(1, srl_no);
										pstmt.setString(2, added_facility_id);
										pstmt.setString(3, user_id);
										pstmt.setString(4, auth_user);
										pstmt.setString(5, added_by_id);
										pstmt.setString(6, added_at_ws_no);
										pstmt.setString(7, added_facility_id);
										pstmt.setString(8, modified_by_id);
										pstmt.setString(9, modified_facility_id);
										pstmt.setString(10, modified_at_ws_no);

										 insert_records=pstmt.executeUpdate();
										 if(insert_records>0){
											 con.commit();
											 flag=true;
										 }
										 else
											 flag=false;

										//if(pstmt!=null)pstmt=null;
										if(pstmt!=null)pstmt.close();
										}
										catch(Exception e){
											//out.println("Exception raised in servlet when inserting the MR_RECODE_PRIVI_SETUP_DTL table");
											e.printStackTrace();

										}
				                   }
			                   }
							}
					}
					catch(Exception exp){
						//out.println("From Servlet--Calling MR_RECODE_PRIVI_SETUP_DTL:"+exp);
						  exp.printStackTrace();
						  
						  String error_value = "0" ;
						  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}


					if(flag){
						String error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
					else{
						String error_value = "0" ;
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
             }
			}
 		    else
			{
				    String error_value = "0" ;
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
   			if ( results != null ) results.clear();
		 }
		 catch(Exception exp)
		 {
			  //out.println("From Servlet--Calling EJB:"+exp);
			  exp.printStackTrace();
			  String error = "Error ";
			  String error_value = "0" ;
			  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		 }
		 //if(con!=null)con.close(); //Commented for checkstyle
		  if(con!=null) ConnectionManager.returnConnection(con,request); //Added for checkstyle
	}
	catch(Exception e)
	{
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}//end of catch
}
boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
/*
  This method implemeting for Modify the RecordPrivilegeSet up
*/
public void modify_recordPrivilegeSetUp(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
	
	Connection con =null;
	boolean flag=true;
try{
	    HashMap RecodePrivilegeSetup=new HashMap();
		con = ConnectionManager.getConnection(request);
	    added_by_id		= (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
		//stage_code = checkForNull(request.getParameter("stage_code"));
		stage_description = checkForNull(request.getParameter("stage_description"));
		int stage_no			= Integer.parseInt(checkForNull(request.getParameter("srl_no")));
		color_ind				= checkForNull(request.getParameter("color_ind"));
		text_color				= checkForNull(request.getParameter("text_color"));
		specific_indicator = checkForNull(request.getParameter("specific_indicator"));
		cutoff_period		= checkForNull(request.getParameter("cutoff_period"));
		int cut_period		= 0;
		if(cutoff_period.equals("")){
			cut_period=0;
		}
		days_fromVisit		= checkForNull(request.getParameter("days_fromVisit"));
		int days_visit		= 0;
		if(days_fromVisit.equals("")){
			days_visit			= 0;
		}
		allow_auth			= checkForNull(request.getParameter("allow_auth"));
		confirm_not_appl = checkForNull(request.getParameter("confirm_not_appl"));
		isConfirmApplicable = checkForNull(request.getParameter("isConfirmApplicable")); // added by mujafar for ML-MMOH-CRF-0878
		action_ifnot_done = checkForNull(request.getParameter("action_ifnot_done"));
		//term_set = checkForNull(request.getParameter("term_set"));
		//term_code = checkForNull(request.getParameter("term_code"));
		//term_desc = checkForNull(request.getParameter("term_desc"));
		diagnosis_clasifi	= checkForNull(request.getParameter("diagnosis_clasifi"),"N");
		accuracy				= checkForNull(request.getParameter("accuracy"),"N");
		severity				= checkForNull(request.getParameter("severity"),"N");
		priority					= checkForNull(request.getParameter("priority"),"N");
		onset_type			= checkForNull(request.getParameter("onset_type"),"N");
		onset_date			= checkForNull(request.getParameter("onset_date"),"N");
		applicable_side		= checkForNull(request.getParameter("applicable_side"),"N");
		status					= checkForNull(request.getParameter("status"),"N");
		remarks				= checkForNull(request.getParameter("remarks"),"N");
		asOn_Date			= checkForNull(request.getParameter("asOn_Date"),"N");
		/*Added For SRR-CRF-303.1 (Procedure) on 12/3/2009*/
		laterality_yn			= checkForNull(request.getParameter("laterality_yn"),"N");
		code_xtn_yn		= checkForNull(request.getParameter("code_xtn_yn"),"N");
		proc_remarks_yn	= checkForNull(request.getParameter("proc_remarks_yn"),"N");
		/*Added On 2/15/2010 for SRR-CRF-303.2(IN015597)*/
		proc_status_yn	= checkForNull(request.getParameter("proc_status_yn"),"N");

		list_auth_users		= checkForNull(request.getParameter("list_auth_users"));
		//RecodePrivilegeSetup.put("STAGE_CODE",stage_code);
		RecodePrivilegeSetup.put("STAGE_DESC",stage_description);
		/*if(!srl_no.equals(" "))
		RecodePrivilegeSetup.put("SERIAL_NO",srl_no);
		else
			RecodePrivilegeSetup.put("SERIAL_NO",srl_no_num);
			*/
			
       /* Below lines added by Venkatesh.S against HAS-CRF-300 */
        enc_stage		= checkForNull(request.getParameter("enc_stage"),"N");
        chife_compln	= checkForNull(request.getParameter("chife_compln"),"N");
        notify	= checkForNull(request.getParameter("notify"),"N");
		/* END HAS-CRF-300 */

		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
		inpatient_appl = request.getParameter("inpatient_appl")==null?"N":request.getParameter("inpatient_appl");
		daycare_appl = request.getParameter("daycare_appl")==null?"N":request.getParameter("daycare_appl");
		/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

			
		RecodePrivilegeSetup.put("COLOUR_IND",color_ind);
		RecodePrivilegeSetup.put("TEXT_COLOUR_IND",text_color);
		RecodePrivilegeSetup.put("SPECIFIC_IND",specific_indicator);

		//Date:Friday, February 12, 2010 icn:241

		if(!cutoff_period.equals(""))
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_VSTCMPL",cutoff_period);
		else
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_VSTCMPL",cut_period);
         if(!days_fromVisit.equals(""))
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_DISC",days_fromVisit);
		else
		RecodePrivilegeSetup.put("CF_PR_FR_RECODE_DYS_FM_DISC",days_visit);
		
		RecodePrivilegeSetup.put("ACTION_IF_NOT_DONE",action_ifnot_done);
		RecodePrivilegeSetup.put("ALLOW_AUTHORIZATION_YN",allow_auth);
		
		if(isConfirmApplicable.equals("true")) // added by mujafar for ML-MMOH-CRF-0878
		RecodePrivilegeSetup.put("CONFIRM_APPL",confirm_not_appl);
		
		//RecodePrivilegeSetup.put("TERM_SET_APPL_YN",term_set);
		//RecodePrivilegeSetup.put("TERM_CODE_APPL_YN",term_code);
		//RecodePrivilegeSetup.put("TERM_DESC_APPL_YN",term_desc);
		RecodePrivilegeSetup.put("DIAG_CLASS_APPL_YN",diagnosis_clasifi);
		RecodePrivilegeSetup.put("ACCURACY_APPL_YN",accuracy);
		RecodePrivilegeSetup.put("SEVERITY_APPL_YN",severity);
		RecodePrivilegeSetup.put("PRIORITY_APPL_YN",priority);
		RecodePrivilegeSetup.put("ONSET_TYPE_APPL_YN",onset_type);
		RecodePrivilegeSetup.put("ONSET_DATE_APPL_YN",onset_date);
		RecodePrivilegeSetup.put("APPLICABLE_SIDE_APPL_YN",applicable_side);
		RecodePrivilegeSetup.put("STATUS_APPL_YN",status);
		RecodePrivilegeSetup.put("REMARKS_APPL_YN",remarks);
		RecodePrivilegeSetup.put("AS_ON_DATE_APPL_YN",asOn_Date);
		RecodePrivilegeSetup.put("LATERALITY_APPL_YN",laterality_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("CODE_EXTENSION_APPL_YN",code_xtn_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("PROC_REMARKS_APPL_YN",proc_remarks_yn);//Added On 12/8/2009 For SRR-CRF-303.1
		RecodePrivilegeSetup.put("PROC_STATUS_APPL_YN",proc_status_yn);////Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
       /* Below lines added by Venkatesh.S against HAS-CRF-300 */
		RecodePrivilegeSetup.put("ENC_STAGE_YN",enc_stage);
		RecodePrivilegeSetup.put("CHIFE_COMP_YN",chife_compln);
		RecodePrivilegeSetup.put("NOTIFIY_YN",notify);
        /*END HAS-CRF-300 */
		RecodePrivilegeSetup.put("ADDED_BY_ID",added_by_id);
        RecodePrivilegeSetup.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        RecodePrivilegeSetup.put("ADDED_AT_WS_NO",added_at_ws_no);
        RecodePrivilegeSetup.put("ADDED_FACILITY_ID",added_facility_id);
        RecodePrivilegeSetup.put("MODIFIED_BY_ID",modified_by_id);
        RecodePrivilegeSetup.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
        RecodePrivilegeSetup.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
        RecodePrivilegeSetup.put("MODIFIED_FACILITY_ID",modified_facility_id);

		//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
		RecodePrivilegeSetup.put("INPATIENT_APPL_YN",inpatient_appl);
        RecodePrivilegeSetup.put("DAYCARE_APPL_YN",daycare_appl);
		//Added by KAMATCHI S for ML-MMOH-CRF-1581 END

       HashMap dupfields=new HashMap();
		dupfields.put("STAGE_NO",stage_no);
		String tabname="MR_RECODE_PRIVI_SETUP";
		try{
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = prop;
			argArray[1] = RecodePrivilegeSetup;
			argArray[2] = dupfields;
			argArray[3] = tabname;
			Class [] paramArray = new Class[4];
			paramArray[0] = prop.getClass();
			paramArray[1] = RecodePrivilegeSetup.getClass();
			paramArray[2] = dupfields.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				boolean updated = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			 if ( updated ){
				 PreparedStatement pstmt = null;
				 ResultSet rset		= null;
				 StringBuffer _sqlDtl=new StringBuffer();
				 String facilityId = (String)session.getValue("facility_id");
				 //int count=0;
				 int del=0;
				   if(specific_indicator.equals("*ALL")){
					   if(_sqlDtl.length() > 0) _sqlDtl.delete(0,_sqlDtl.length());
					   _sqlDtl.append("DELETE FROM MR_RECODE_PRIVI_SETUP_DTL WHERE STAGE_NO=?  and FACILITY_ID = ? ");
					   pstmt=con.prepareStatement(_sqlDtl.toString());
					   
						 pstmt.setInt(1, stage_no);
						 pstmt.setString(2, facilityId);
					   
		                del = pstmt.executeUpdate();
						if(del>0)con.commit(); 
						if(pstmt!=null)pstmt.close();
						  if(rset!=null)rset = null;
						  if(con!=null)con=null;
					String error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			  }else{
					String user_id="";
					String user_name="";
					String auth_user="";
					int insert_records=0;
					try{
			             if(_sqlDtl.length() > 0) _sqlDtl.delete(0,_sqlDtl.length());
						  _sqlDtl.append("DELETE FROM MR_RECODE_PRIVI_SETUP_DTL WHERE STAGE_NO= ? and FACILITY_ID = ? ");
						   pstmt=con.prepareStatement(_sqlDtl.toString());
						   pstmt.setInt(1, stage_no);
						   pstmt.setString(2, facilityId);
		                    del = pstmt.executeUpdate();
								if(del>0)con.commit(); 
						  if(pstmt!=null)pstmt.close();
						  if(rset!=null)rset = null;
						  if (!list_auth_users.equals("")){
							   StringTokenizer splitedtoken = null;
								String tokenvalue = "";
								tokenvalue="";
								int i = 0;
							   StringTokenizer token1=new StringTokenizer(list_auth_users,"~");
								while(token1.hasMoreTokens()){
										i++ ;
										tokenvalue      = token1.nextToken();
										splitedtoken=new StringTokenizer(tokenvalue,"`");
										while (splitedtoken.hasMoreTokens()){
											user_id		=	splitedtoken.nextToken();
											user_name			=	splitedtoken.nextToken();
											auth_user			=	splitedtoken.nextToken();
											try{
											if(_sqlDtl.length() > 0) _sqlDtl.delete(0,_sqlDtl.length());
											 _sqlDtl=_sqlDtl.append("Insert into MR_RECODE_PRIVI_SETUP_DTL (STAGE_NO,FACILITY_ID,APPL_USER_ID,AUTHORIZE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values(? ,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
											 pstmt = con.prepareStatement(_sqlDtl.toString()) ;
											    pstmt.setInt(1, stage_no);
												pstmt.setString(2, added_facility_id);
												pstmt.setString(3, user_id);
												pstmt.setString(4, auth_user);
												pstmt.setString(5, added_by_id);
												pstmt.setString(6, added_at_ws_no);
												pstmt.setString(7, added_facility_id);
												pstmt.setString(8, modified_by_id);
												pstmt.setString(9, modified_facility_id);
												pstmt.setString(10, modified_at_ws_no);
											 insert_records=pstmt.executeUpdate();
											 con.commit();
											 if(pstmt!=null)pstmt.close();
											 if(insert_records>0){
												 flag=true;
											 }else{
												 flag=false;
											 }
										}catch(Exception e){
												//out.println("Exception raised in servlet when inserting the MR_RECODE_PRIVI_SETUP_DTL table");
												e.printStackTrace();
											}
					                   }
				                   }
							}if(pstmt!=null)pstmt=null;
						}catch(Exception exp){
							//out.println("From Servlet--Calling MR_RECODE_PRIVI_SETUP_DTL:"+exp);
							exp.printStackTrace();
							 String error_value = "0" ;
							 response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
					if(flag){
						String error_value= "1";
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}else{
						String error_value = "0" ;
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
             }
			 if(pstmt!=null)pstmt=null;
			}else{
				    String error_value = "0" ;
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
   			if ( results != null ) results.clear();
		 }catch(Exception exp){
			 // out.println("From Servlet--Calling EJB:"+exp);
			  exp.printStackTrace();
			  String error = "Error ";
			  String error_value = "0" ;
			  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		 }
		 
		//if(con!=null)con.close();//Commented for checkstyle
		if(con!=null) ConnectionManager.returnConnection(con,request); //Added for checkstyle for COMMON-ICN-0056
	}catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		e.printStackTrace();
	}//end of catch
}
public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	

}
