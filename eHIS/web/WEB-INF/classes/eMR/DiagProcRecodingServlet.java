/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
//import eMR.RecDiagnosis.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public class DiagProcRecodingServlet extends javax.servlet.http.HttpServlet	
{



	PrintWriter out;
	Properties p;
	HttpSession session   = null;



	Connection con =null;
	PreparedStatement pstmt2			= null;
	PreparedStatement pstmt			= null;
	ResultSet rs					= null;
	StringBuffer sql1 = new StringBuffer();
//	CallableStatement cs = null;
	java.util.HashMap results = new java.util.HashMap() ;


	String x_facility_id = "";
	String client_ip_address = "";
	String addedById = "";
	String locale = "";
	String term_set = "";
	String term_set_code = "";
	String term_set_code1 = "";
	String term_set_code2 = "";
	String term_set_code3 = "";
	String diag_classfication = "";
	String accuracy_code = "";
	String severity_code = "";
	String priority_code = "";
	String onset_type = "";
	String onset_date = "";
	String status = "";
	String status_date = "";
	String applicable_side = "";
	String remarks = "";
	String patient_id = "";
	String encounter_id = "";
	String occur_srl_no = "";
	String stage_srl_no = "";
	String stage_no = "";
	String caused_death = "";
	String recode_status = "";
	String recode_status_chk = "";
    String err_value = "";
    String error = "";
    String orig_termset = "";
    String orig_termcode = "";
	String c1 = "";
	String t1 = "";
	String s1 = "";
	String sel_item = "";
	String sttermcode_cnt = "";
	String st_cnt = "";
	String procedure_yn = "";
	String recode_chk = "";
	String Patient_Class = "";
	String bl_install_yn = "";
	String p_episode_type = "";
	String recal_yn = "";
	int termcode_cnt = 0;
	int srl_no = 0;
	String srl_temp = "";
	String sql2 = "";
	String dflt_termset = "";
	int stage_srl_disp = 0;
	int count_loop = 0;
	String newCode_yn="";
	String sel_term_code="";
	String sel_term_set="";
	int count_selected=0;
	String orig_sel_termcd="";
	String orig_sel_termset="";
	String action="";
	String Confirm_Dig_Data="";
	String Confirm_Proc_Data="";
	String sel_proc_srl_no="";
	String marked_err_diagvals="";
	String sel_status="";
	String grpby_val="";
	String sel_stages_val="";
	String diag_stage_values_cnfrm="";
	String proc_stage_values_cnfrm="";
	String diag_group_values_cnfrm="";
	String diag_group_seq_values_cnfrm="";
	String proc_group_values_cnfrm		="";
	String proc_group_seq_values_cnfrm="";
	String diag_status_values_cnfrm		="";
	String proc_status_values_cnfrm		="";
	String drgMdc			="";
	String warn				="";
	String drg_drg			="";
	String drg_wtlos		="";
	String drg_rw			="";
	String drg_ot				="";
	String drg_adrrw		="";
	String drg_error		="";
	String drg_result_code	="";//Added On 3/17/2010 for Site Enhancement.
	String diag_new_seq		="";
	String proc_new_seq	="";
	String prin_trm_code	="";
	String prin_srl_no			="";
	String final_diag_confirm_yn	 ="";
	String final_proc_confirm_yn ="";
	String final_Diag_group_yn	="";	//Added On 7/2/2009
	String final_Proc_group_yn	="";	//Added On 7/2/2009
	String stage_auth			="";
	String Mode					="";				 //Added On 7/3/2009.
	String sel_mod_id			="";		//Added On 7/3/2009.
	String sel_cod_xtn		="";	   //Added On 7/3/2009.
//	String sel_acess_num="";//Added On 7/10/2009
//	String sel_cod_xtn_dtl="";//Added On 7/10/2009.
	String proc_type			="";		//Added On 7/13/2009.
	String code_extn_dtl		="";		//Added On 7/3/2009.
	String laterality_ind		="";		 //Added On 12/15/2009 12:06 PM For SRR-CRF-303.1
	String proc_srt_dt_time	="";	 //Added On 12/15/2009 12:06 PM For SRR-CRF-303.1
	String proc_end_dt_time	="";	//Added On 12/15/2009 12:06 PM For SRR-CRF-303.1
	String drg_err_message		="";
	String drg_warn_message ="";
	String rep_EncounterId		="";
	String rep_Pat_id				="";
	String rep_language_id		="";
	String rep_facility_id			="";
	String practitioner_id			=""; //Added On 11/3/2009;
	String record_assosicate_codes_0	=""; //Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
	String record_assosicate_codes_1	=""; //Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
	String record_assosicate_codes_2	=""; //Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
	String group_seq_no_data	=""; //Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
	String support_seq_no_data	=""; //Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
	HashMap  supp_diag_map = null;
	ArrayList hdr_status_list =null;
	String L1_hdr_status	 ="";
	String L2_hdr_status	 ="";
	String L3_hdr_status	 ="";
	String curr_level		 ="";
	String hdr_modified_dt_qr ="";

	String hdr_modified_dt		  =""; //Added On 2/26/2010 for Cocurrent Users
	String episode_no				  =""; //Added On 6/21/2010 Generate Invoice for Other than IP
    String encounter_stage="";
	String complaint_id="";
	String notifiable_code="";
	String accuracy       ="";
	String notification_setup  ="";
//	int res1 = 0;
//	int res2 = 0;
//	int res3 = 0;
	int stg_srl_number = 0;
	String group_YN=""; 
	String sel_srl_no="";
	String diagprob_desc =""; //HAS-CRF-300
	String diagprob_short_desc="";//HAS-CRF-300
	 String  termset_id="";//HAS-CRF-300
	 String term_oth_desc=""; // added by mujafar for ML-MMOH-CRF-1281
	 String isMultiDescAppl="";
	 

	 String  doctor_desc = "";//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269

	boolean inserted = false;

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		supp_diag_map = new	HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session		= req.getSession(false);
		this.x_facility_id		= (String)session.getValue("facility_id") ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		locale					= p.getProperty("LOCALE");
		this.client_ip_address	= this.p.getProperty("client_ip_address");
		addedById		 = p.getProperty( "login_user" ) ;
       this.out               = res.getWriter() ;
       patient_id = checkForNull(req.getParameter("Pat_id"));
		encounter_id = checkForNull(req.getParameter("EncounterId"));
		stage_no = checkForNull(req.getParameter("stage_no"));
		term_set = checkForNull(req.getParameter("code_set"));
	    term_set_code1 = checkForNull(req.getParameter("diagprob_code"));  
		term_set_code2 = checkForNull(req.getParameter("diagprob_code1"));
		term_set_code3 = checkForNull(req.getParameter("diagprob_code2"));
		diag_classfication = checkForNull(req.getParameter("diag_classfication"));
		diagprob_short_desc = checkForNull(req.getParameter("diagprob_short_desc"));//HAS-CRF-300
		 diagprob_desc = checkForNull(req.getParameter("diagprob_desc"));//HAS-CRF-300
		term_oth_desc =    checkForNull(req.getParameter("term_oth_desc")); //  Added by mujafar for ML-MMOH-CRF-1281 US3
		 isMultiDescAppl = checkForNull(req.getParameter("isMultiDescAppl"));
		 
		 
		//String hid_diagprob_code_0 = checkForNull(req.getParameter("hid_diagprob_code_0"));//HAS-CRF-300 //Commented by Suji Keerthi for Connection error
		//String long_desc_val_0 = checkForNull(req.getParameter("long_desc_val_0"));//HAS-CRF-300 //Commented by Suji Keerthi for Connection error

		doctor_desc = checkForNull(req.getParameter("doctor_desc")).replaceAll("'","''"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269

		if(!diag_classfication.equals("")){
			diag_classfication=diag_classfication.substring(0,diag_classfication.indexOf("$"));
		}
		accuracy_code		= checkForNull(req.getParameter("accuracy"));
		severity_code		= checkForNull(req.getParameter("severity"));
		priority_code		= checkForNull(req.getParameter("priority"));
		onset_type			= checkForNull(req.getParameter("onset_type"));
		onset_date			= checkForNull(req.getParameter("onset_date"));
		onset_date			=DateUtils.convertDate(onset_date,"DMYHM",locale,"en");
		status					= checkForNull(req.getParameter("status"));
		status_date			= checkForNull(req.getParameter("status_date"));
		status_date			=DateUtils.convertDate(status_date,"DMY",locale,"en");
		applicable_side		= checkForNull(req.getParameter("applicable_side"));
		remarks				= (checkForNull(req.getParameter("remarks")));
		
		caused_death	= checkForNull(req.getParameter("caused_death"));
		occur_srl_no		= checkForNull(req.getParameter("occur_srl_no"));
		recode_status	= checkForNull(req.getParameter("recode_status"));
		orig_termset		= checkForNull(req.getParameter("orig_termset"));
		orig_termcode  = checkForNull(req.getParameter("orig_termcode"));
		sel_item			= checkForNull(req.getParameter("sel_item"));
		procedure_yn	= checkForNull(req.getParameter("procedure_yn"));
		sttermcode_cnt = checkForNull(req.getParameter("termcode_cnt"));
		Patient_Class	= checkForNull(req.getParameter("Patient_Class"));
		bl_install_yn		= checkForNull(req.getParameter("bl_install_yn"));
		recal_yn			= checkForNull(req.getParameter("recal_yn"));
		newCode_yn	= checkForNull(req.getParameter("newCode_yn"));
		sel_srl_no			= checkForNull(req.getParameter("sel_srl_no"));
		sel_term_code	= checkForNull(req.getParameter("sel_term_code"));
		sel_term_set		= checkForNull(req.getParameter("sel_term_set")); 
		action				= checkForNull(req.getParameter("activity"));
		Mode				= checkForNull(req.getParameter("mode"));				//For Modification Of Diag Classificaton 
		code_extn_dtl	= checkForNull(req.getParameter("proc_cd_xtn"));	//For Modification Of Procedure  Classificaton 
		laterality_ind	 	= checkForNull(req.getParameter("proc_laterality"));// Added on 12/15/2009 11:58 AM for SRR-CRF-303.1
		proc_type		= checkForNull(req.getParameter("proc_type"));		// Added on7/13/2009
		proc_srt_dt_time	= checkForNull(req.getParameter("start_dt_time"));	// Added on 12/15/2009 12:00 PM for SRR-CRF-303.1
		proc_srt_dt_time	= DateUtils.convertDate(proc_srt_dt_time,"DMYHM",locale,"en");	// Added on 12/15/2009 12:00 PM for SRR-CRF-303.1
		proc_end_dt_time= checkForNull(req.getParameter("end_dt_time"));		// Added on 12/15/2009 12:00 PM for SRR-CRF-303.1
		proc_end_dt_time= DateUtils.convertDate(proc_end_dt_time,"DMYHM",locale,"en");;		// Added on 12/15/2009 12:00 PM for SRR-CRF-303.1
		sel_mod_id			= checkForNull(req.getParameter("sel_mod_id"));		//Added On 7/10/2009
		sel_cod_xtn			= checkForNull(req.getParameter("sel_cod_xtn"));	//Added On 7/10/2009
		record_assosicate_codes_0	= checkForNull(req.getParameter("record_assosicate_codes_0"));	//Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
		record_assosicate_codes_1	= checkForNull(req.getParameter("record_assosicate_codes_1"));	//Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
		record_assosicate_codes_2	= checkForNull(req.getParameter("record_assosicate_codes_2"));	//Added On 2/4/2010 for SRR-CRF-303.2[IN015597]
		
		/*has-crf-300*/
		encounter_stage	= checkForNull(req.getParameter("diag_stage")); 
		complaint_id	= checkForNull(req.getParameter("complaint_id"));
		notifiable_code	= checkForNull(req.getParameter("notifiable_code"));
		
		// code changed by Vedesh A D for Edge Conversion
		
		String iss_sStyle= req.getParameter("rep_sStyle") != null ? req.getParameter("rep_sStyle") : "IeStyle.css";
		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+iss_sStyle+"'></link>");
		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
		out.println("async function DiagProcRecodingHTML() { ");
		out.println("var frame ='';  ");
		out.println("if(top.window.document.getElementById('dialog-body')){");
		out.println("frame = 	top.window.document.querySelectorAll('#dialog-body')[top.window.document.querySelectorAll('#dialog-body').length-1].contentWindow; }");
		out.println("else{frame= parent;}");
		int cd_key=0;
		if(!record_assosicate_codes_0.equals("")){
			cd_key	=0;
			supp_diag_map.put(cd_key,record_assosicate_codes_0);
		}
		if(!record_assosicate_codes_1.equals("")){
			cd_key	=1;
			supp_diag_map.put(cd_key,record_assosicate_codes_1);
		}
		if(!record_assosicate_codes_2.equals("")){
			cd_key	=2;
			supp_diag_map.put(cd_key,record_assosicate_codes_2);
		}
		Confirm_Dig_Data	= checkForNull(req.getParameter("Confirm_Dig_Data"));////TheseDiagnosis For only doing Confirmation
		Confirm_Proc_Data	= checkForNull(req.getParameter("Confirm_Proc_Data"));////These Procedure For only doing Confirmation
		sel_proc_srl_no		= checkForNull(req.getParameter("sel_proc_srl_no"));//These Srl No For only doing Confirmation
		marked_err_diagvals= checkForNull(req.getParameter("marked_err_diagvals"));
		sel_status					= checkForNull(req.getParameter("sel_status"));
		grpby_val					= checkForNull(req.getParameter("grpby_val"));
		sel_stages_val			= checkForNull(req.getParameter("sel_stages_val"));
		diag_stage_values_cnfrm	 = checkForNull(req.getParameter("diag_stage_values_cnfrm"));
		proc_stage_values_cnfrm	 = checkForNull(req.getParameter("proc_stage_values_cnfrm"));
		diag_group_values_cnfrm	 = checkForNull(req.getParameter("diag_group_values_cnfrm"));
		diag_group_seq_values_cnfrm	= checkForNull(req.getParameter("diag_group_seq_values_cnfrm"));
		proc_group_values_cnfrm		= checkForNull(req.getParameter("proc_group_values_cnfrm"));
		proc_group_seq_values_cnfrm	= checkForNull(req.getParameter("proc_group_seq_values_cnfrm"));
		diag_status_values_cnfrm			= checkForNull(req.getParameter("diag_status_values_cnfrm"));
		proc_status_values_cnfrm		= checkForNull(req.getParameter("proc_status_values_cnfrm"));

		drgMdc	= checkForNull(req.getParameter("drgMdc"));
		warn			= checkForNull(req.getParameter("warn"));
		drg_drg	= checkForNull(req.getParameter("drg_drg"));
		drg_wtlos = checkForNull(req.getParameter("drg_wtlos"));
		drg_rw		= checkForNull(req.getParameter("drg_rw"));
		drg_ot		= checkForNull(req.getParameter("drg_ot"));
		drg_adrrw	= checkForNull(req.getParameter("drg_adrrw"));
		drg_error		= checkForNull(req.getParameter("drg_error"));
		drg_result_code		= checkForNull(req.getParameter("drg_result_code"));// Added On 3/17/2010 For Site Enhancement.
		drg_err_message		=checkForNull(req.getParameter("drg_error_desc")); //Added On 10/26/2009
		drg_warn_message	=checkForNull(req.getParameter("drgwarn_desc")); //Added On  10/26/2009

		diag_new_seq	 = checkForNull(req.getParameter("diag_new_seq"));
		proc_new_seq	 = checkForNull(req.getParameter("proc_new_seq"));
		prin_trm_code  = checkForNull(req.getParameter("principal_diag"));
		prin_srl_no		= checkForNull(req.getParameter("prin_stg_srl_no"));
	
		final_diag_confirm_yn	=checkForNull(req.getParameter("final_diag_confirm_yn"));
		final_proc_confirm_yn	=checkForNull(req.getParameter("final_proc_confirm_yn"));
		final_Diag_group_yn		=checkForNull(req.getParameter("final_Diag_group_yn"));//Added On 7/2/2009
		final_Proc_group_yn	=checkForNull(req.getParameter("final_Proc_group_yn"));//Added On 7/2/2009
		stage_auth					=checkForNull(req.getParameter("stage_auth"));
		group_seq_no_data		=checkForNull(req.getParameter("group_seq_no_data"));//Added On 2/16/2010 for SRR-CRF-303.2[IN015597]
		support_seq_no_data	=checkForNull(req.getParameter("support_seq_no_data"));//Added On 2/16/2010 for SRR-CRF-303.2[IN015597]
		hdr_modified_dt			=checkForNull(req.getParameter("hdr_modified_dt"));//Added On 2/26/2010 for Cocurrent Users.
		if(sttermcode_cnt != "")
			termcode_cnt = Integer.parseInt(sttermcode_cnt);
		srl_temp		= checkForNull(req.getParameter("srl_no"));
		dflt_termset = checkForNull(req.getParameter("dflt_termset"));
		if(srl_temp != "")
			srl_no = Integer.parseInt(srl_temp);

		if(Patient_Class.equals("IP")){
			p_episode_type="I";
		}else if(Patient_Class.equals("EM")){
			p_episode_type="E";
		}else if(Patient_Class.equals("DC")){
			p_episode_type="D";
		}else if(Patient_Class.equals("OP")){
			p_episode_type="O";
		}
			if(p_episode_type.equals("I") || p_episode_type.equals("D" )){
				episode_no	= encounter_id;
			}else{
				if(encounter_id.length()>8){
					episode_no = encounter_id.substring(0,8);
				}
			}
		if(termcode_cnt == 0)		{
			if (term_set_code2 == "" && term_set_code3 == ""){
				termcode_cnt=1;
			}else if (term_set_code2 == "" || term_set_code3 == ""){
				termcode_cnt=2;
			}else{
				termcode_cnt=3;
			}

		}
		/*if(Mode.equals("Modify")){
			action="Modify";
		}else if(Mode.equals("ProcModify")){
			action="ProcModify";
		}*/
			/*To Get Function Role Id from Appl User*/
		String allow_single_user	 =	restrictMultiuser(encounter_id,hdr_modified_dt,req);
		String multi_user_error	= "";
		if(allow_single_user.equals("00")){
				try{
					con = ConnectionManager.getConnection(req);
					String FUNC_ROLE_SQL	 =	"SELECT FUNC_ROLE,FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID='"+addedById+"'";
					pstmt  = con.prepareStatement(FUNC_ROLE_SQL);
					rs		  = pstmt.executeQuery();
					while(rs.next()){
						practitioner_id=checkForNull(rs.getString("FUNC_ROLE_ID"));
					}
						if(pstmt!=null)pstmt.close();
						if(rs!=null)rs.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}finally{
						if(con != null){
							ConnectionManager.returnConnection(con,p);
						}
					}

				try{							   
					this.out = res.getWriter();
					if(action.equals("New") || action.equals("Recode")){
						RecodeAddModify(req,res);
					}else if(action.equals("DiagModify")){
						RecodeModifyDiagnosis(req,res);
					}else if(action.equals("ProcModify")){
						RecodeModifyProcedure(req,res);
					}else if(action.equals("Complete")){
						RecodeCompletion(req,res);
					}else if(action.equals("Reject")){
						RecodeRejection(req,res);
					}else if(action.equals("Confirm")){
						RecodeConfirmation(req,res);
					}else if(action.equals("MarkError")){
						RecodeMarkError(req,res);
					}else if(action.equals("Authorize")){
						RecodeAuthorize(req,res);
					}else if(action.equals("RejectDRG")){
						RejectDRG(req,res);
					}else if(action.equals("SaveDRG")){
						SaveDRG(req,res);
					}else if(action.equals("ReCalculateDRG")){
						ReCalculateDRG(req,res);
					}else if(action.equals("RejectDiagnosis")){
						RejectDiagnosis(req,res);
					}else if(action.equals("RejectProcedure")){
						RejectProcedure(req,res);
					}else if(action.equals("OpenReport")){
						doOnlineReports(req);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(allow_single_user.equals("01")){
			/*F.Y.I:The Below JS function will Displays the Error message and reload the respective pages. */
			 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
			L1_hdr_status	 = (String)hdr_status_list.get(0);
			L2_hdr_status	 = (String)hdr_status_list.get(1);
			L3_hdr_status	 = (String)hdr_status_list.get(2);
			curr_level			 = (String)hdr_status_list.get(3);
			hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
			out.print("frame.parent.frames[1].getErrorMessage('"+stage_no+"','"+patient_id+"','"+encounter_id+"','"+dflt_termset+"','"+Patient_Class+"','"+L1_hdr_status+"','"+L2_hdr_status+"','"+L3_hdr_status+"','"+curr_level+"','"+hdr_modified_dt_qr+"');");
		}else if(allow_single_user.equals("02")){
			multi_user_error	="Exception While restricting multiusers acessing the same encounter.";
			out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");
		}
		out.println("} DiagProcRecodingHTML();</script><body></body></html>");
	}
private void RecodeMarkError(HttpServletRequest req, HttpServletResponse res)
   {
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			ResultSet rslt=null;
			String err1="";
			String err2="";

			int diag_errcnt =0;
			//int res2 =0;
			int upt_hdr_cnt =0;
			int asst_cd_cnt =0;
			//int count	=0;
			String histry_term_code	=	"";
			String histry_srl_no	=	"";
			boolean inserted=false;

			if(procedure_yn.equals("Y")){  /// marking err for procedure
			  /// marking err for Procedure
				//if(stage_no.equals(DB_Stage_NO)){   // marking error by same level user

				StringTokenizer st_sel=new StringTokenizer(sel_srl_no,",");
				StringTokenizer st_sel_status=new StringTokenizer(sel_status,",");
				StringTokenizer st_sel_codes=new StringTokenizer(marked_err_diagvals,",");
				StringTokenizer st_sel_groups=new StringTokenizer(grpby_val,",");
				StringTokenizer st_sel_stages=new StringTokenizer(sel_stages_val,",");
				String code_val="";
				String Group_val="";
				String st_sel_srl_no="";
				String status_val="";
				String stage_val="";
				while(st_sel_groups.hasMoreTokens()){
						stage_val=st_sel_stages.nextToken();
						Group_val=	st_sel_groups.nextToken();
						//if(stage_no.equals(stage_val)){ 												

							if(Group_val.equals("Y")){  // when single is selected  ...  multiple to one recoding where group_YN=Y
									st_sel_srl_no	 =	st_sel.nextToken();
									status_val		 =	st_sel_status.nextToken();
									code_val		 =	st_sel_codes.nextToken();

									String tmp_srl_no="";
									String tmp_status="";
									String tmp_codes="";
									
									String sql_selct_group_vals	="SELECT PROC_CODE,STAGE_SRL_NO,RECODE_STATUS FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND PROC_CODE="+code_val+" AND GROUP_YN='Y' ";

									marked_err_diagvals="";
									pstmt = con.prepareStatement( sql_selct_group_vals );
									rslt = pstmt.executeQuery();
									while(rslt.next()){
										tmp_srl_no	 = tmp_srl_no+"'"+rslt.getString("STAGE_SRL_NO")+"',";
										tmp_status	 = tmp_status+""+rslt.getString("RECODE_STATUS")+",";
										tmp_codes	 = tmp_codes+"'"+rslt.getString("PROC_CODE")+"',";
									}

									if(rslt!=null)rslt.close();

									tmp_srl_no	= tmp_srl_no.substring(0,tmp_srl_no.length()-1);
									tmp_status	= tmp_status.substring(0,tmp_status.length()-1);
									tmp_codes	= tmp_codes.substring(0,tmp_codes.length()-1);
									StringTokenizer st_sel_tmp_code=new StringTokenizer(tmp_codes,",");
									StringTokenizer st_sel_tmp_srl_no=new StringTokenizer(tmp_srl_no,",");
//									String tempo_trm_cd=""; Commented For Open Connection Issues 10/22/2009

						inner:		while(st_sel_tmp_srl_no.hasMoreTokens()){
										
										String cd_tk=st_sel_tmp_code.nextToken();
										String srl_tk=st_sel_tmp_srl_no.nextToken();

										

										if(Integer.parseInt(stage_no)==Integer.parseInt(stage_val)){ // checking the stage value of teh line item and teh logged n user

												String updt_diag_markerr="update MR_PROCEDURE_RECODING_DTL set RECODE_STATUS='E',ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and ENCOUNTER_ID='"+encounter_id+"' and PROC_CODE = "+cd_tk+" AND STAGE_SRL_NO = "+srl_tk+"  and ACTIVE_YN='Y' AND GROUP_YN='Y'";
												pstmt = con.prepareStatement( updt_diag_markerr );
												diag_errcnt = pstmt.executeUpdate();
												if(pstmt!=null)pstmt.close();
												if(diag_errcnt>0){

//														String history_code_sql	 =	"SELECT ORIG_PROC_CODE_SCHEME PROC_CODE,STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  AND ACTIVE_YN='N' AND STAGE_SRL_NO IN (SELECT STAGE_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+srl_tk+" AND ENCOUNTER_ID='"+encounter_id+"') ";
														String orig_rep_no="";
														String history_code_sql	 =	"SELECT ORIG_PROC_CODE PROC_CODE,STAGE_SRL_NO,nvl(orig_rep_srl,'0') orig_rep_srl FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  AND ACTIVE_YN='N' AND STAGE_SRL_NO IN (SELECT STAGE_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+srl_tk+" AND ENCOUNTER_ID='"+encounter_id+"') ";
														pstmt = con.prepareStatement( history_code_sql );
														 rslt = pstmt.executeQuery();
//														histry_term_code="";
//														histry_srl_no="";
														int orig_rep_number=0;
														 if(rslt.next()){
															histry_term_code="";
															histry_srl_no="";
															histry_term_code="'"+rslt.getString("PROC_CODE")+"'";
															histry_srl_no="'"+rslt.getString("STAGE_SRL_NO")+"'";
															orig_rep_number=rslt.getInt("orig_rep_srl");
															if(orig_rep_number>0){
																orig_rep_no="'"+rslt.getString("orig_rep_srl")+"'";
															}
														 }
														//histry_term_code=histry_term_code.substring(0,histry_term_code.length()-1);
														//histry_srl_no=histry_srl_no.substring(0,histry_srl_no.length()-1);
														if(pstmt!=null)pstmt.close();
														if(rslt!=null)rslt.close();
														String history_code_active_sql="SELECT count(*) count_active FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and proc_code in (SELECT ORIG_proc_CODE FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+srl_tk+" AND ENCOUNTER_ID='"+encounter_id+"' and proc_CODE="+code_val+")  AND ACTIVE_YN='Y' and recode_status !='E' AND STAGE_NO ='"+stage_no+"' ";
														if(orig_rep_number>0){
															history_code_active_sql=history_code_active_sql+"and orig_rep_srl="+orig_rep_no;
														}
														
													
													int act_count=0;
													pstmt = con.prepareStatement( history_code_active_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														act_count=Integer.parseInt(rslt.getString("count_active"));
													 }
													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													if(act_count>0){
														err1=code_val;
														err2=histry_term_code;
														inserted=false;
														break;
													}


														if(!histry_term_code.equals("")){
															String  histry_grp_sq_no="";
															String  sql_update_associate_codes="";
															String grp_seq_no_sql	=	"SELECT GROUP_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO = "+histry_srl_no+"";
															pstmt = con.prepareStatement( grp_seq_no_sql );
															 rslt = pstmt.executeQuery();
	//															histry_term_code="";
	//															histry_srl_no="";
															 while(rslt.next()){
																histry_grp_sq_no=checkForNull(rslt.getString("GROUP_SEQ_NO"));
//																histry_srl_no="'"+rslt.getString("STAGE_SRL_NO")+"'";
															 }
															if(pstmt!=null)pstmt.close();
															if(rslt!=null)rslt.close();

															if(!histry_grp_sq_no.equals("")){
															 //sql_update_associate_codes	="UPDATE MR_PROCEDURE_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  GROUP_SEQ_NO = '"+histry_grp_sq_no+"' ";
															 sql_update_associate_codes	="UPDATE MR_PROCEDURE_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  GROUP_SEQ_NO = '"+histry_grp_sq_no+"' and proc_code in (select orig_proc_code from MR_PROCEDURE_RECODING_DTL where stage_seq_no= "+histry_srl_no+" and FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"')";
															}else{
															 sql_update_associate_codes	="UPDATE MR_PROCEDURE_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO = "+histry_srl_no+"";
															}

															pstmt = con.prepareStatement( sql_update_associate_codes );
															asst_cd_cnt = pstmt.executeUpdate();
															if(pstmt!=null)pstmt.close();

													}//End Of Checking histry_term_code


														if(asst_cd_cnt>0){
															inserted=true;
														}else{
															inserted=false;
															break;
														}
												}

												
										}

											


										}// while loop				
									


							}else{		// group not equal to Y			

								st_sel_srl_no	 =	st_sel.nextToken();
								status_val		 =	st_sel_status.nextToken();
								code_val		 =	st_sel_codes.nextToken();

								if(Integer.parseInt(stage_no)==Integer.parseInt(stage_val)){ // checking the stage value of teh line item and teh logged n user
									/*
											Added On 2/15/2010  For 303.2 #IN015597.
											1.Even Though New codes can be mark as error
										*/
										String error_dtl	="";
										if(status_val.equals("N")){
												error_dtl ="N";
										}
										String updt_diag_markerr="update MR_PROCEDURE_RECODING_DTL set RECODE_STATUS='E',ACTIVE_YN='N',ERROR_DTL='"+error_dtl+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' WHERE FACILITY_ID= '"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND PROC_CODE ="+code_val+" AND STAGE_SRL_NO ='"+st_sel_srl_no+"'  and ACTIVE_YN='Y'";

										pstmt = con.prepareStatement( updt_diag_markerr );
										diag_errcnt = pstmt.executeUpdate();
										if(pstmt!=null)pstmt.close();


										if(diag_errcnt>0){
											
											if(status_val.equals("R")){  // if marking error for new code no further action. else teh following logic
												int count=0;
												if(Group_val.equals("X")){  // checking all elements in a group of "X" are marked error

													String grp_yn_sql	=	"SELECT COUNT(*)  FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND GROUP_YN='X' AND RECODE_STATUS!='E'  AND STAGE_SEQ_NO IN (SELECT STAGE_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'   AND STAGE_SRL_NO ='"+st_sel_srl_no+"' AND ENCOUNTER_ID='"+encounter_id+"')";
													pstmt = con.prepareStatement( grp_yn_sql );
													rslt = pstmt.executeQuery();

													if(rslt!=null&&rslt.next()){
														count	=	rslt.getInt(1);
													}

													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

												} // end group X check


												if(count==0){ //  no other related records 
													String orig_rep_no="";
													String history_code_sql="SELECT PROC_CODE,STAGE_SRL_NO,nvl(orig_rep_srl,'0') orig_rep_srl  FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  AND ACTIVE_YN='N' AND STAGE_SRL_NO IN (SELECT STAGE_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ='"+st_sel_srl_no+"' AND ENCOUNTER_ID='"+encounter_id+"') ";
													
													histry_term_code="";
													histry_srl_no="";
													int orig_rep_number=0;

													pstmt = con.prepareStatement( history_code_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														histry_term_code=histry_term_code+"'"+rslt.getString("PROC_CODE")+"',";
														histry_srl_no=histry_srl_no+"'"+rslt.getString("STAGE_SRL_NO")+"',";
														orig_rep_number=rslt.getInt("orig_rep_srl");
														if(orig_rep_number>0){
															orig_rep_no="'"+rslt.getString("orig_rep_srl")+"'";
														}

													 }
													histry_term_code=histry_term_code.substring(0,histry_term_code.length()-1);
													histry_srl_no=histry_srl_no.substring(0,histry_srl_no.length()-1);
													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													String history_code_active_sql="";
													if(Group_val.equals("X")){ 
													history_code_active_sql="SELECT count(*) count_active FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and proc_code in (SELECT ORIG_proc_CODE FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+st_sel_srl_no+" AND ENCOUNTER_ID='"+encounter_id+"' and proc_CODE="+code_val+" and group_yn!='X')  AND ACTIVE_YN='Y' and recode_status !='E' AND STAGE_NO ='"+stage_no+"' ";
													}else{
													history_code_active_sql="SELECT count(*) count_active FROM MR_PROCEDURE_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and proc_code in (SELECT ORIG_proc_CODE FROM MR_PROCEDURE_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+st_sel_srl_no+" AND ENCOUNTER_ID='"+encounter_id+"' and proc_CODE="+code_val+")  AND ACTIVE_YN='Y' and recode_status !='E' AND STAGE_NO ='"+stage_no+"' ";
													}
													if(orig_rep_number>0){
														history_code_active_sql=history_code_active_sql+"and orig_rep_srl="+orig_rep_no;
													}													
													int act_count=0;

													pstmt = con.prepareStatement( history_code_active_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														act_count=Integer.parseInt(rslt.getString("count_active"));
													 }
													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													if(act_count>0){
														err1=code_val;
														err2=histry_term_code;
														inserted=false;
														break;
													}


													if(!histry_term_code.equals("")){
														String sql_update_associate_codes	="UPDATE MR_PROCEDURE_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND PROC_CODE IN("+histry_term_code+") AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO IN ("+histry_srl_no+")";

														pstmt = con.prepareStatement( sql_update_associate_codes );
														asst_cd_cnt = pstmt.executeUpdate();
														if(pstmt!=null)pstmt.close();

														if(asst_cd_cnt>0){										
															inserted=true;
														}else{

															inserted=false;
															break;
																 
														}

													}

												}else{  // count check
													inserted=true;
												}

											}else{ // end checking status
												inserted=true;
											}						


										}else{
											inserted=false;
											break;									
										}
								}
				
							}// check for group Y

						//}else{  // marking error by higher level user
						//}

				}// while

					if(inserted){
						

						String sql_update_hdr="";

						if(stage_no.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}
						pstmt = con.prepareStatement( sql_update_hdr );
						upt_hdr_cnt = pstmt.executeUpdate();

						if(pstmt!=null)pstmt.close();
					}
					if(upt_hdr_cnt>0){
						err_value="1";
						con.commit();
						hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
						L1_hdr_status	 = (String)hdr_status_list.get(0);
						L2_hdr_status	 = (String)hdr_status_list.get(1);
						L3_hdr_status	 = (String)hdr_status_list.get(2);
						curr_level			 = (String)hdr_status_list.get(3);
						hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
						Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						error = (String)hashtable1.get("message");
						out.print("alert('"+error+"')");

						if(stage_no.equals("1")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("2")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("3")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}

						out.println("frame.parent.frames[1].onSuccess();");


						out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
						
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

						if ( hashtable1 != null ) {
							hashtable1.clear();
						}
					}else{
						error="";
						err1=err1.substring(1,err1.length());
						err1=err1.substring(0,err1.length()-1);
						err2=err2.substring(1,err2.length());
						err2=err2.substring(0,err2.length()-1);
						out.println("frame.parent.frames[1].enable_mrk_err('"+err1+"','"+err2+"','P');");
						err_value="0";
						con.rollback();
						//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?\";");
					}		
				
				

			}else{  /// marking err for diagnosis

				//if(stage_no.equals(DB_Stage_NO)){   // marking error by same level user

				StringTokenizer st_sel=new StringTokenizer(sel_srl_no,",");
				StringTokenizer st_sel_status=new StringTokenizer(sel_status,",");
				StringTokenizer st_sel_codes=new StringTokenizer(marked_err_diagvals,",");
				StringTokenizer st_sel_groups=new StringTokenizer(grpby_val,",");
				StringTokenizer st_sel_stages=new StringTokenizer(sel_stages_val,",");
				String code_val="";
				String Group_val="";
				String st_sel_srl_no="";
				String status_val="";
				String stage_val="";

				while(st_sel_groups.hasMoreTokens()){
						
						stage_val=st_sel_stages.nextToken();
						Group_val=	st_sel_groups.nextToken();
						//if(stage_no.equals(stage_val)){ 												

							if(Group_val.equals("Y")){  // when single is selected  ...  multiple to one recoding where group_YN=Y
									st_sel_srl_no	 =	st_sel.nextToken();
									status_val		 =	st_sel_status.nextToken();
									code_val		 =	st_sel_codes.nextToken();

									String tmp_srl_no="";
									String tmp_status="";
									String tmp_codes="";
									
									String sql_selct_group_vals	="SELECT TERM_CODE,STAGE_SRL_NO,recode_status FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND TERM_CODE="+code_val+" and group_yn='Y' ";

									marked_err_diagvals="";
									pstmt = con.prepareStatement( sql_selct_group_vals );
									rslt = pstmt.executeQuery();

									while(rslt.next()){
										tmp_srl_no	 = tmp_srl_no+"'"+rslt.getString("STAGE_SRL_NO")+"',";
										tmp_status	 = tmp_status+""+rslt.getString("recode_status")+",";
										tmp_codes= tmp_codes+"'"+rslt.getString("TERM_CODE")+"',";
									}

									if(rslt!=null)rslt.close();

									tmp_srl_no	= tmp_srl_no.substring(0,tmp_srl_no.length()-1);
									tmp_status	= tmp_status.substring(0,tmp_status.length()-1);
									tmp_codes	= tmp_codes.substring(0,tmp_codes.length()-1);
									StringTokenizer st_sel_tmp_code=new StringTokenizer(tmp_codes,",");
									StringTokenizer st_sel_tmp_srl_no=new StringTokenizer(tmp_srl_no,",");

//									String tempo_trm_cd=""; Commented For Open Connection Issues 10/22/2009

						inner:		while(st_sel_tmp_srl_no.hasMoreTokens()){
										
										String cd_tk=st_sel_tmp_code.nextToken();
										String srl_tk=st_sel_tmp_srl_no.nextToken();

										

										if(Integer.parseInt(stage_no)==Integer.parseInt(stage_val)){ // checking the stage value of teh line item and teh logged n user

												String updt_diag_markerr="update MR_DIAGNOSIS_RECODING_DTL set RECODE_STATUS='E',ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and ENCOUNTER_ID='"+encounter_id+"' and term_code = "+cd_tk+" AND STAGE_SRL_NO = "+srl_tk+"  and ACTIVE_YN='Y' and group_YN='Y'";

												pstmt = con.prepareStatement( updt_diag_markerr );
												diag_errcnt = pstmt.executeUpdate();
												if(pstmt!=null)pstmt.close();


												if(diag_errcnt>0){

														
														String orig_rep_no="";
														String history_code_sql	 =	"SELECT ORIG_TERM_CODE  TERM_CODE,STAGE_SRL_NO,nvl(orig_rep_srl,'0') orig_rep_srl  FROM MR_DIAGNOSIS_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  AND ACTIVE_YN='N' AND STAGE_SRL_NO IN (SELECT STAGE_SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+srl_tk+" AND ENCOUNTER_ID='"+encounter_id+"') ";

														int orig_rep_number=0;
														pstmt = con.prepareStatement( history_code_sql );
														 rslt = pstmt.executeQuery();
//															histry_term_code="";
//															histry_srl_no="";
														 while(rslt.next()){
															histry_term_code="'"+rslt.getString("TERM_CODE")+"'";
															histry_srl_no="'"+rslt.getString("STAGE_SRL_NO")+"'";
															orig_rep_number=rslt.getInt("orig_rep_srl");
															if(orig_rep_number>0){
																orig_rep_no="'"+rslt.getString("orig_rep_srl")+"'";
															}
														 }
														//histry_term_code=histry_term_code.substring(0,histry_term_code.length()-1);
														//histry_srl_no=histry_srl_no.substring(0,histry_srl_no.length()-1);
														if(pstmt!=null)pstmt.close();
														if(rslt!=null)rslt.close();


													String history_code_active_sql="SELECT count(*) count_active FROM MR_DIAGNOSIS_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and term_code in (SELECT ORIG_TERM_CODE FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+srl_tk+" AND ENCOUNTER_ID='"+encounter_id+"' and term_CODE="+code_val+")  AND ACTIVE_YN='Y' and recode_status !='E' AND ORIG_TERM_CODE!='*OTH'  AND STAGE_NO ='"+stage_no+"'";
													
													if(orig_rep_number>0){
														if(histry_term_code.equals("'*OTH'")){
															history_code_active_sql=history_code_active_sql+"and orig_rep_srl="+orig_rep_no;
														}
													}
													
													
													int act_count=0;

													pstmt = con.prepareStatement( history_code_active_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														act_count=Integer.parseInt(rslt.getString("count_active"));
													 }

													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													if(act_count>0){
														err1=code_val;
														err2=histry_term_code;
														inserted=false;
														break;
													}


														if(!histry_term_code.equals("")){
															String  histry_grp_sq_no="";
															String  sql_update_associate_codes="";
															String grp_seq_no_sql	=	"SELECT GROUP_SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO = "+histry_srl_no+"";

															pstmt = con.prepareStatement( grp_seq_no_sql );
															 rslt = pstmt.executeQuery();
	//															histry_term_code="";
	//															histry_srl_no="";
															 while(rslt.next()){
																histry_grp_sq_no=checkForNull(rslt.getString("GROUP_SEQ_NO"));
//																histry_srl_no="'"+rslt.getString("STAGE_SRL_NO")+"'";
															 }

															if(pstmt!=null)pstmt.close();
															if(rslt!=null)rslt.close();

															if(!histry_grp_sq_no.equals("")){
															 sql_update_associate_codes	="UPDATE MR_DIAGNOSIS_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  GROUP_SEQ_NO = '"+histry_grp_sq_no+"' and term_code in (select orig_term_code from MR_DIAGNOSIS_RECODING_DTL where stage_seq_no= "+histry_srl_no+" and FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"')" ;
															}else{
															 sql_update_associate_codes	="UPDATE MR_DIAGNOSIS_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO = "+histry_srl_no+"";
															}

															pstmt = con.prepareStatement( sql_update_associate_codes );
															asst_cd_cnt = pstmt.executeUpdate();
															if(pstmt!=null)pstmt.close();

													}

														if(asst_cd_cnt>0){
															inserted=true;
														}else{
															inserted=false;
															break;
														}
												}

												
										}

											


										}// while loop				
									


							}else{		// group not equal to Y			

								st_sel_srl_no	 =	st_sel.nextToken();
								status_val		 =	st_sel_status.nextToken();
								code_val		 =	st_sel_codes.nextToken();

								if(Integer.parseInt(stage_no)==Integer.parseInt(stage_val)){ // checking the stage value of teh line item and teh logged n user
										/*
											Added On 2/15/2010  For 303.2 #IN015597.
											1.Even Though New codes can be mark as error
										*/
										String error_dtl	="";
										if(status_val.equals("N")){
												error_dtl ="N";
										}
										String updt_diag_markerr="update MR_DIAGNOSIS_RECODING_DTL set RECODE_STATUS='E',ACTIVE_YN='N',ERROR_DTL='"+error_dtl+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and ENCOUNTER_ID='"+encounter_id+"' and term_code ="+code_val+" AND STAGE_SRL_NO ='"+st_sel_srl_no+"'  and ACTIVE_YN='Y'";

										pstmt = con.prepareStatement( updt_diag_markerr );
										diag_errcnt = pstmt.executeUpdate();
										if(pstmt!=null)pstmt.close();


										if(diag_errcnt>0){
											
											if(status_val.equals("R")){  // if marking error for new code no further action. else teh following logic
												int count=0;
												if(Group_val.equals("X")){  // checking all elements in a group of "X" are marked error

													String grp_yn_sql	=	"SELECT COUNT(*)  FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND GROUP_YN='X' AND RECODE_STATUS!='E'  AND STAGE_SEQ_NO IN (SELECT STAGE_SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'   AND STAGE_SRL_NO ='"+st_sel_srl_no+"' AND ENCOUNTER_ID='"+encounter_id+"')";

													pstmt = con.prepareStatement( grp_yn_sql );
													rslt = pstmt.executeQuery();

													if(rslt!=null&&rslt.next()){
														count	=	rslt.getInt(1);
													}

													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

												} // end group X check


												if(count==0){ //  no other related records 
													String orig_rep_no="";
													String history_code_sql="SELECT TERM_CODE,STAGE_SRL_NO,nvl(orig_rep_srl,'0') orig_rep_srl  FROM MR_DIAGNOSIS_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  AND ACTIVE_YN='N' AND STAGE_SRL_NO IN (SELECT STAGE_SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ='"+st_sel_srl_no+"' AND ENCOUNTER_ID='"+encounter_id+"') ";
													
													histry_term_code="";
													histry_srl_no="";
													int orig_rep_number=0;

													pstmt = con.prepareStatement( history_code_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														histry_term_code=histry_term_code+"'"+rslt.getString("TERM_CODE")+"',";
														histry_srl_no=histry_srl_no+"'"+rslt.getString("STAGE_SRL_NO")+"',";
														orig_rep_number=rslt.getInt("orig_rep_srl");
														if(orig_rep_number>0){
															orig_rep_no="'"+rslt.getString("orig_rep_srl")+"'";
														}	
													 }
													histry_term_code=histry_term_code.substring(0,histry_term_code.length()-1);
													histry_srl_no=histry_srl_no.substring(0,histry_srl_no.length()-1);

													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													String history_code_active_sql="";
													
													if(Group_val.equals("X")){ 
														history_code_active_sql="SELECT count(*) count_active FROM MR_DIAGNOSIS_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and term_code in (SELECT ORIG_TERM_CODE FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+st_sel_srl_no+" AND ENCOUNTER_ID='"+encounter_id+"' and term_CODE="+code_val+" and group_yn!='X')  AND ACTIVE_YN='Y' and recode_status !='E' AND ORIG_TERM_CODE!='*OTH'  AND STAGE_NO ='"+stage_no+"' ";
													}else{
														history_code_active_sql="SELECT count(*) count_active FROM MR_DIAGNOSIS_RECODING_DTL WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"'  and term_code in (SELECT ORIG_TERM_CODE FROM MR_DIAGNOSIS_RECODING_DTL WHERE  FACILITY_ID='"+x_facility_id+"'  AND STAGE_SRL_NO ="+st_sel_srl_no+" AND ENCOUNTER_ID='"+encounter_id+"' and term_CODE="+code_val+")  AND ACTIVE_YN='Y' and recode_status !='E' AND ORIG_TERM_CODE!='*OTH' AND STAGE_NO ='"+stage_no+"' ";
													}	
													if(orig_rep_number>0){
														if(histry_term_code.equals("'*OTH'")){
															history_code_active_sql=history_code_active_sql+"and orig_rep_srl="+orig_rep_no;
														}
													}													
													int act_count=0;

													pstmt = con.prepareStatement( history_code_active_sql );
													 rslt = pstmt.executeQuery();
													 while(rslt.next()){
														act_count=Integer.parseInt(rslt.getString("count_active"));
													 }
													if(pstmt!=null)pstmt.close();
													if(rslt!=null)rslt.close();

													if(act_count>0){
														err1=code_val;
														err2=histry_term_code;
														inserted=false;
														break;
													}

													

													if(!histry_term_code.equals("")){
														String sql_update_associate_codes	="UPDATE MR_DIAGNOSIS_RECODING_DTL  SET  ACTIVE_YN='Y',confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  WHERE  FACILITY_ID='"+x_facility_id+"'  AND  TERM_CODE IN("+histry_term_code+") AND ENCOUNTER_ID='"+encounter_id+"' and  STAGE_SRL_NO IN ("+histry_srl_no+")";

														pstmt = con.prepareStatement( sql_update_associate_codes );
														asst_cd_cnt = pstmt.executeUpdate();
														if(pstmt!=null)pstmt.close();

														if(asst_cd_cnt>0){										
															inserted=true;
														}else{

															inserted=false;
															break;
																 
														}

													}

												}else{  // count check
													inserted=true;
												}

											}else{ // end checking status
												inserted=true;
											}						


										}else{
											inserted=false;
											break;									
										}
								}
				
							}// check for group Y

						//}else{  // marking error by higher level user
							

						//}

				}// while

					if(inserted){
						
						String sql_update_hdr="";

						if(stage_no.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}

						
						pstmt = con.prepareStatement( sql_update_hdr );
						upt_hdr_cnt = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();

						
					}
					if(upt_hdr_cnt>0){

						err_value="1";
						con.commit();
						hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
						L1_hdr_status	 = (String)hdr_status_list.get(0);
						L2_hdr_status	 = (String)hdr_status_list.get(1);
						L3_hdr_status	 = (String)hdr_status_list.get(2);
						curr_level			 = (String)hdr_status_list.get(3);
						hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
						Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						error = (String)hashtable1.get("message");
						out.print("alert('"+error+"')");

						if(stage_no.equals("1")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("2")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("3")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}

						out.println("frame.parent.frames[1].onSuccess();");


						out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
						
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

						if ( hashtable1 != null ) {
							hashtable1.clear();
						}
					}else{
						error="";
						err_value="0";
						err1=err1.substring(1,err1.length());
						err1=err1.substring(0,err1.length()-1);
						err2=err2.substring(1,err2.length());
						err2=err2.substring(0,err2.length()-1);
						out.println("frame.parent.frames[1].enable_mrk_err('"+err1+"','"+err2+"','D','"+dflt_termset+"');");
						con.rollback();
						//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?\";");

					}		
				
				
			}  // checking for proc/diag


		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();
		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
}


private void RecodeConfirmation(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			ResultSet rslt=null;

			int res1 =0;
			//int res2 =0;
			int res3 =0;
			


			String error="";

			if(!Confirm_Dig_Data.equals("")){
				int ins_count=0;


				StringTokenizer diag_codes= new StringTokenizer(Confirm_Dig_Data,",");
				StringTokenizer diag_srl_no= new StringTokenizer(sel_srl_no,",");
				StringTokenizer diag_stage_no= new StringTokenizer(diag_stage_values_cnfrm,",");
				StringTokenizer diag_grp= new StringTokenizer(diag_group_values_cnfrm,",");
				StringTokenizer diag_grp_seq_no= new StringTokenizer(diag_group_seq_values_cnfrm,",");
				StringTokenizer diag_status_vals= new StringTokenizer(diag_status_values_cnfrm,",");
				String diag_recode_status="";  


				int stge_srlno_diag=0;
				String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1 STAGE_SRL_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
				pstmt = con.prepareStatement( stge_srlno_sql );
				rslt = pstmt.executeQuery();
				while(rslt.next()){
					stge_srlno_diag=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
				}
				if(pstmt!=null)pstmt.close();
				if(rslt!=null)rslt.close();

				while(diag_codes.hasMoreTokens()){
					
					String dg_cd		 =diag_codes.nextToken();
					String dg_slno	 =diag_srl_no.nextToken();
					String dg_stgno	 =diag_stage_no.nextToken();
					String dg_grp	 =diag_grp.nextToken();
					String dg_grp_seq	  =diag_grp_seq_no.nextToken();
					String dg_status	   =diag_status_vals.nextToken();


					if(Integer.parseInt(stage_no) > Integer.parseInt(dg_stgno)){
						if(dg_status.equals("R")){
							diag_recode_status ="O";
						}else{
							diag_recode_status=dg_status;
						}
						/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
						String ins_new="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE)  select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stge_srlno_diag+", "+stge_srlno_diag+", 'N', '"+diag_recode_status+"', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'Y', 'Y', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, 'H','',ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,'"+notifiable_code+"' from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and term_code="+dg_cd+" and stage_srl_no="+dg_slno;



						 
						 pstmt = con.prepareStatement( ins_new );
						 ins_count	= pstmt.executeUpdate();



						 if(pstmt!=null)pstmt.close();
						 stge_srlno_diag=stge_srlno_diag+1;
						 if(ins_count<=0){
							 error="Y";
							 break;
						 }

					}else{
						String sql_diag_confirm="";
						if(dg_grp.equals("Y")){
							sql_diag_confirm="update MR_DIAGNOSIS_RECODING_DTL set CONFIRM_YN='Y',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and group_seq_no ="+dg_grp_seq+" and ACTIVE_YN='Y'";
						}else{
							sql_diag_confirm="update MR_DIAGNOSIS_RECODING_DTL set CONFIRM_YN='Y',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";
						}


						//STAGE_NO='"+stage_no+"',--to discuss
						pstmt = con.prepareStatement( sql_diag_confirm );
						 res1 = pstmt.executeUpdate();


						if(pstmt!=null)pstmt.close();
						if(res1<=0){
							 error="Y";
							  break;
						 }
					}

				}// while loop	for diag			
				
			} // check any diag selected fpr confirm


			if(!Confirm_Proc_Data.equals("")){

				int ins_count=0;
				StringTokenizer proc_codes= new StringTokenizer(Confirm_Proc_Data,",");
				StringTokenizer proc_srl_no= new StringTokenizer(sel_proc_srl_no,",");
				StringTokenizer proc_stage_no= new StringTokenizer(proc_stage_values_cnfrm,",");
				StringTokenizer proc_grp= new StringTokenizer(proc_group_values_cnfrm,",");
				StringTokenizer proc_grp_seq_no= new StringTokenizer(proc_group_seq_values_cnfrm,",");
				StringTokenizer proc_status_vals= new StringTokenizer(proc_status_values_cnfrm,",");
				String proc_recode_status="";  
				/*StringTokenizer proc_sel_mod_id= new StringTokenizer(sel_mod_id,",");
				StringTokenizer proc_sel_cod_xtn= new StringTokenizer(sel_cod_xtn,",");
				String db_sel_acess_num	=sel_acess_num.replace("||","$");
				StringTokenizer proc_sel_acess_num= new StringTokenizer(db_sel_acess_num,",");
				StringTokenizer proc_sel_cod_xtn_dtl= new StringTokenizer(sel_cod_xtn,",");*/
				int stge_srlno_proc=0;
				String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1 STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
				pstmt = con.prepareStatement( stge_srlno_sql );
				rslt = pstmt.executeQuery();
				while(rslt.next()){
					stge_srlno_proc=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
				}
				if(pstmt!=null)pstmt.close();
				if(rslt!=null)rslt.close();
				while(proc_codes.hasMoreTokens()){ 

					String proc_cd		= proc_codes.nextToken();
					String proc_slno	= proc_srl_no.nextToken();
					String proc_stgno	= proc_stage_no.nextToken();
					String pr_grp			= proc_grp.nextToken();
					String pr_grp_seq	= proc_grp_seq_no.nextToken();
					String proc_status	= proc_status_vals.nextToken();

				/*	String pr_contr_mod_id=proc_sel_mod_id.nextToken();
					String pr_code_xtn_yn=proc_sel_cod_xtn.nextToken();
					String pr_acess_num=proc_sel_acess_num.nextToken();
					String pr_cod_xtn_dtl=proc_sel_cod_xtn_dtl.nextToken();
					if(pr_contr_mod_id.equals("'XT'")){
						pr_contr_mod_id="";
					}
					if(pr_acess_num.equals("00")){
						pr_acess_num="";
					}
					if(pr_cod_xtn_dtl.equals("01")){
						pr_cod_xtn_dtl="";
					}

*/
					if(Integer.parseInt(stage_no) > Integer.parseInt(proc_stgno)){
						if(proc_status.equals("R")){
							proc_recode_status ="O";
						}else{
							proc_recode_status=proc_status;
						}
						String ins_new="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select  FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME,  ORIG_PROC_CODE, "+stage_no+", "+stge_srlno_proc+", "+stge_srlno_proc+", 'N', '"+proc_recode_status+"', PROC_CODE_SCHEME, PROC_CODE,REMARKS,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND, 'Y', 'Y', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, 'H','',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL WHERE  ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"' and PROC_CODE="+proc_cd+" and STAGE_SRL_NO="+proc_slno;
						 pstmt = con.prepareStatement( ins_new );
						 ins_count	= pstmt.executeUpdate();
						 if(pstmt!=null)pstmt.close();
						 stge_srlno_proc=stge_srlno_proc+1;
						 if(ins_count<=0){
							 error="Y";
							 break;
						 }

					}else{
						String sql_proc_confirm="";
						if(pr_grp.equals("Y")){
//							sql_proc_confirm="update MR_PROCEDURE_RECODING_DTL set CONFIRM_YN='Y',CONTR_MOD_ID='"+pr_contr_mod_id+"',CODE_EXTN_YN='"+pr_code_xtn_yn+"',ACCESSION_NUM='"+pr_acess_num+"', CODE_EXTN_DTL='"+pr_cod_xtn_dtl+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and group_seq_no ="+pr_grp_seq+" and ACTIVE_YN='Y'";
							sql_proc_confirm="update MR_PROCEDURE_RECODING_DTL set CONFIRM_YN='Y',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and group_seq_no ="+pr_grp_seq+" and ACTIVE_YN='Y'";

						}else{
//							sql_proc_confirm="update MR_PROCEDURE_RECODING_DTL set CONFIRM_YN='Y',CONTR_MOD_ID='"+pr_contr_mod_id+"',CODE_EXTN_YN='"+pr_code_xtn_yn+"',ACCESSION_NUM='"+pr_acess_num+"', CODE_EXTN_DTL='"+pr_cod_xtn_dtl+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";
							sql_proc_confirm="update MR_PROCEDURE_RECODING_DTL set CONFIRM_YN='Y',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";

						}

						//STAGE_NO='"+stage_no+"',--to discuss
						pstmt = con.prepareStatement( sql_proc_confirm );
						 res1 = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();
						if(res1<=0){
							 error="Y";
							  break;
						 }
					}

				}// while loop	for proc			
				
			} // check any proc selected fpr confirm




			if(error.equals("")){
					
					String sql_update_hdr="";

					if(stage_no.equals("1")){
						sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("2")){
						sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("3")){
						sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}
					


					pstmt = con.prepareStatement( sql_update_hdr );
					res3 = pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();


			}


			if(res3!=0){
				err_value="1";
				con.commit();
				hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				out.print("alert('"+error+"')");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}
				
				out.println("frame.parent.frames[1].onSuccess();");

				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();


		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}

private void SaveDRG(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			ResultSet rslt=null;
			
		
			int drg_count=0;
			String drg_count_sql	=	"SELECT  count(*) count FROM MR_ENCOUNTER_DRG_INFO WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
			pstmt = con.prepareStatement( drg_count_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				drg_count=Integer.parseInt(rslt.getString("count"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();

			int ins_count=1;

			if(drg_count>0){

				ins_count=0;

				String del_drg="delete FROM MR_ENCOUNTER_DRG_INFO WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
				pstmt = con.prepareStatement( del_drg );
				ins_count = pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
			}

						

			if(ins_count!=0)	{	
				ins_count=0;
				String sql_save_drg="insert into MR_ENCOUNTER_DRG_INFO  (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, PATIENT_CLASS, CAL_LOS, DRG_CODE, MDC_CODE, ERROR_CODE, WARNING_CODE, RESULT_CODE, RELATIVE_WEIGHT, WEIGHT_LOS, OVER_STAT_DAYS, ADJUSTED_RELATIVE_WEIGHT, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,ERROR_MESSAGE,WARN_MESSAGE) values ('"+x_facility_id+"','"+encounter_id+"','"+patient_id+"','"+Patient_Class+"','','"+drg_drg+"','"+drgMdc+"','"+drg_error+"','"+warn+"','"+drg_result_code+"','"+drg_rw+"','"+drg_wtlos+"','"+drg_ot+"','"+drg_adrrw+"','"+addedById+"',sysdate,'"+client_ip_address+"','"+x_facility_id+"','"+addedById+"',sysdate,'"+client_ip_address+"','"+x_facility_id+"','"+drg_err_message+"','"+drg_warn_message+"')";
				
				pstmt = con.prepareStatement( sql_save_drg );
				ins_count = pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
			}


			if(ins_count!=0){
				String UPDT_HDR="update MR_DIAG_PROC_RECODING_HDR set MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_BY_ID='"+addedById+"',MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				pstmt = con.prepareStatement( UPDT_HDR );
				int upt_hdr_count = pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();
				if(upt_hdr_count!=0){
					err_value="1";
					con.commit();
					hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
					L1_hdr_status	 = (String)hdr_status_list.get(0);
					L2_hdr_status	 = (String)hdr_status_list.get(1);
					L3_hdr_status	 = (String)hdr_status_list.get(2);
					curr_level			 = (String)hdr_status_list.get(3);
					hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
					Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error = (String)hashtable1.get("message");
					out.print("alert('"+error+"')");
					doOnlineReports(req);
					/*if(stage_no.equals("1")){
					out.println("<script> parent.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					out.println("<script> parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					}else if(stage_no.equals("2")){
					out.println("<script> parent.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					out.println("<script> parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					}else if(stage_no.equals("3")){
					out.println("<script> parent.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					out.println("<script> parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"\"</script>");
					}*/
					out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&open_recal_drg=Y&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
					out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");
					if ( hashtable1 != null ) {
						hashtable1.clear();
					}
					}else{
						err_value="0";
						con.rollback();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
					}
			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			 }
		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();
		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}

private void RejectDRG(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int res1=0;

			//ResultSet rslt=null;
			String error="";
			ResultSet rslt=null;
			String sqlbl = "{? = call BL_GENERATE_INVOICE.RECALCULATE_DRG(?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sqlbl);
			cs.registerOutParameter(1,java.sql.Types.VARCHAR);
			cs.setString(2, x_facility_id);
			cs.setString(3, patient_id);
			cs.setString(4, p_episode_type);
			cs.setLong(5, Integer.parseInt(episode_no));
			cs.registerOutParameter(6,java.sql.Types.VARCHAR);
			cs.registerOutParameter(7,java.sql.Types.VARCHAR);
			cs.registerOutParameter(8,java.sql.Types.VARCHAR);
			cs.executeUpdate();
//			 String bl_val = cs.getString(1);Commented For Open Connection Issues 10/22/2009
//			 String err_lev = cs.getString(6);Commented For Open Connection Issues 10/22/2009
			 String sys_msg_id = checkForNull(cs.getString(7),"");
//			 String err_txt = cs.getString(8);Commented For Open Connection Issues 10/22/2009
			if(cs != null)
				cs.close();
			 //if (sys_msg_id != null){
			 if (! sys_msg_id.equals("")){
					java.util.Locale loc = new java.util.Locale(locale);
					java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
					String blmessage = (String) messages.getString(sys_msg_id);
					//sb.append(blmessage);
					//err_value="0";
					//con.rollback();
				
				 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
					out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
					out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( blmessage, "UTF-8" )+"&err_value=0"+"\";");

//					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(blmessage,"UTF-8"));	
			}else{
				if(stage_auth.equals("D")){  // rejection at higher stage
					if(!Confirm_Dig_Data.equals("")){
						int stge_srlno=0;
						String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1  STAGE_SRL_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
						pstmt = con.prepareStatement( stge_srlno_sql );
						rslt = pstmt.executeQuery();
						while(rslt.next()){
							stge_srlno=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
						}
						if(pstmt!=null)pstmt.close();
						if(rslt!=null)rslt.close();

//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
						StringTokenizer diag_srl_no= new StringTokenizer(sel_srl_no,",");
						StringTokenizer diag_codes= new StringTokenizer(Confirm_Dig_Data,",");
//						StringTokenizer diag_cnfrm_yn= new StringTokenizer(final_diag_confirm_yn,",");
						StringTokenizer diag_group_yn= new StringTokenizer(final_Diag_group_yn,",");
						StringTokenizer diag_group_seq_no= new StringTokenizer(group_seq_no_data,",");
						StringTokenizer diag_support_seq_no= new StringTokenizer(support_seq_no_data,",");


						//int seq_no_diag=1;

						
						while(diag_srl_no.hasMoreTokens()){ 

							String dg_slno=diag_srl_no.nextToken();
							String dg_cd=diag_codes.nextToken();
							String dg_grp_yn=diag_group_yn.nextToken();
							String dg_grp_seq_no=diag_group_seq_no.nextToken();
							String dg_spprt_seq_no=diag_support_seq_no.nextToken();
//							String sql_diag_seq_rej="";


							String ins_diag_after_rej="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,NOTIFICATION_CODE) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'O', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'Y', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','',ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,NOTIFICATION_CODE from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and stage_srl_no="+dg_slno+" ";
							stge_srlno=stge_srlno+1;
							pstmt = con.prepareStatement( ins_diag_after_rej );
							res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(res1<=0){
								 error="Y";
								  break;
							 }
							String ADDL_CRITERIA="";
							if(dg_grp_yn.equals("Y")){
								ADDL_CRITERIA="GROUP_SEQ_NO='"+dg_grp_seq_no+"' ";
							}else{
								ADDL_CRITERIA="SUPPORT_SEQ_NO="+dg_spprt_seq_no+" ";
							}

							String sql_supp_diag_trx_rej	 ="update MR_RECODE_SUPPORT_DIAG set TRX_NO ='',INT_SEQ_NO='', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and TERM_CODE ="+dg_cd+" and "+ADDL_CRITERIA+" ";
							pstmt = con.prepareStatement( sql_supp_diag_trx_rej );
							res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							/*if(res1<=0){
								 error="Y";
								  break;
							 }*/

						} // while loop
					}
					if(!Confirm_Proc_Data.equals("")){
							int stge_srlno=0;
						String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1  STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
						pstmt = con.prepareStatement( stge_srlno_sql );
						rslt = pstmt.executeQuery();
						while(rslt.next()){
							stge_srlno=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
						}
						if(pstmt!=null)pstmt.close();
						if(rslt!=null)rslt.close();

//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
						StringTokenizer proc_srl_no= new StringTokenizer(sel_proc_srl_no,",");


//						int seq_no_proc=1;Commented For Open Connection Issues 10/22/2009
						

						//int seq_no_diag=1;

						
						while(proc_srl_no.hasMoreTokens()){ 

							String proc_slno=proc_srl_no.nextToken();

							String ins_proc_after_rej="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select FACILITY_ID, ENCOUNTER_ID, PATIENT_ID,  SRL_NO, ORIG_PROC_CODE_SCHEME,  ORIG_PROC_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'O', PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID,PROC_DATE,LATERALITY_IND, 'Y', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL WHERE  ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"' AND STAGE_SRL_NO="+proc_slno+"";
							stge_srlno=stge_srlno+1;
							pstmt = con.prepareStatement( ins_proc_after_rej );
							res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(res1<=0){
								 error="Y";
								  break;
							 }



						} // while loop

					}
					

				}else{ // rejection at same stage


					if(!Confirm_Dig_Data.equals("")){

//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
						StringTokenizer diag_codes= new StringTokenizer(Confirm_Dig_Data,",");
						StringTokenizer diag_srl_no= new StringTokenizer(sel_srl_no,",");
						StringTokenizer diag_cnfrm_yn= new StringTokenizer(final_diag_confirm_yn,",");
						StringTokenizer diag_group_yn= new StringTokenizer(final_Diag_group_yn,",");
						StringTokenizer diag_group_seq_no= new StringTokenizer(group_seq_no_data,",");
						StringTokenizer diag_support_seq_no= new StringTokenizer(support_seq_no_data,",");
						String db_grp_seqno="";
//						String db_stg_srlno="";
						 

						//int seq_no_diag=1;

						
						while(diag_codes.hasMoreTokens()){ 

							String dg_cd=diag_codes.nextToken();
							String dg_slno=diag_srl_no.nextToken();
							String dg_cnf_yn=diag_cnfrm_yn.nextToken();
							String dg_grp_yn=diag_group_yn.nextToken();
							String dg_grp_seq_no=diag_group_seq_no.nextToken();
							String dg_spprt_seq_no=diag_support_seq_no.nextToken();
							String sql_diag_seq_rej="";
							if(dg_cnf_yn.equals("Y")){
								if(dg_grp_yn.equals("Y")){
									String sql_diag_grp_seqno="SELECT GROUP_SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and TERM_CODE ="+dg_cd+"  AND STAGE_SRL_NO="+dg_slno+" AND GROUP_YN='Y'  ";

									pstmt = con.prepareStatement( sql_diag_grp_seqno );
									rslt	 = pstmt.executeQuery();
									while(rslt.next()){
										db_grp_seqno	=	db_grp_seqno+"'"+rslt.getString("GROUP_SEQ_NO")+"',";

//										db_stg_srlno		=	db_stg_srlno+"'"+rslt.getString("STAGE_SRL_NO")+"',";
									}
									/*Added  For Open Connection Issues 10/22/2009*/
										if(rslt!=null){
											rslt.close();
										}
										db_grp_seqno=db_grp_seqno.substring(0,db_grp_seqno.length()-1);

//										db_stg_srlno=db_stg_srlno.substring(0,db_stg_srlno.length()-1);
									sql_diag_seq_rej ="UPDATE MR_DIAGNOSIS_RECODING_DTL set TRX_NO ='',CONFIRM_YN='N', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and TERM_CODE ="+dg_cd+" AND GROUP_SEQ_NO in ("+db_grp_seqno+") and ACTIVE_YN='Y' ";
								}else{
								sql_diag_seq_rej="update MR_DIAGNOSIS_RECODING_DTL set TRX_NO ='',CONFIRM_YN='N', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";
								}
								pstmt = con.prepareStatement( sql_diag_seq_rej );
								res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
								if(res1<=0){
									 error="Y";
									  break;
								 }

								String sql_del_diagnosis="delete from  mr_diagnosis_recoding_dtl where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and confirm_YN='N' and active_YN='Y' and sequenced_YN='H'";
								//String sql_updt_diagnosis="update   mr_diagnosis_recoding_dtl set recode_status='X' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and confirm_YN='N' and active_YN='Y' and sequenced_YN='H' ";

								pstmt = con.prepareStatement( sql_del_diagnosis );
								 res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
							}else{
								sql_diag_seq_rej="update MR_DIAGNOSIS_RECODING_DTL set TRX_NO ='', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";

								pstmt = con.prepareStatement( sql_diag_seq_rej );
								res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
								if(res1<=0){
									 error="Y";
									  break;
								 }
							}
							String ADDL_CRITERIA="";
							if(dg_grp_yn.equals("Y")){
								ADDL_CRITERIA="GROUP_SEQ_NO='"+dg_grp_seq_no+"' ";
							}else{
								ADDL_CRITERIA="SUPPORT_SEQ_NO="+dg_spprt_seq_no+" ";
							}
							String sql_supp_diag_trx_rej	 ="update MR_RECODE_SUPPORT_DIAG set TRX_NO ='',INT_SEQ_NO='', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and TERM_CODE ="+dg_cd+" and "+ADDL_CRITERIA+" ";
							pstmt = con.prepareStatement( sql_supp_diag_trx_rej );
							res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							/*if(res1<=0){
								 error="Y";
								  break;
							 }*/

						}// while loop	for diag		
							

						
					} // check any diag selected fpr confirm

					if(!Confirm_Proc_Data.equals("")){

//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
						StringTokenizer proc_codes= new StringTokenizer(Confirm_Proc_Data,",");
						StringTokenizer proc_srl_no= new StringTokenizer(sel_proc_srl_no,",");
						StringTokenizer proc_cnfrm_yn= new StringTokenizer(final_proc_confirm_yn,",");
						StringTokenizer proc_group_yn= new StringTokenizer(final_Proc_group_yn,",");

						String db_grp_seqno="";
//						String db_stg_srlno="";


//						int seq_no_proc=1;Commented For Open Connection Issues 10/22/2009
						
						while(proc_codes.hasMoreTokens()){ 

							String proc_cd =proc_codes.nextToken();
							String proc_slno =proc_srl_no.nextToken();
							String proc_cnf_yn=proc_cnfrm_yn.nextToken();
							String proc_grp_yn=proc_group_yn.nextToken();

							String sql_proc_seq_rej="";
							if(proc_cnf_yn.equals("Y")){
								if(proc_grp_yn.equals("Y")){
									String sql_diag_grp_seqno="SELECT GROUP_SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and PROC_CODE ="+proc_cd+" AND STAGE_SRL_NO="+proc_slno+" AND GROUP_YN='Y' ";
									pstmt = con.prepareStatement( sql_diag_grp_seqno );
									rslt	 = pstmt.executeQuery();
									while(rslt.next()){
										db_grp_seqno	=	db_grp_seqno+"'"+rslt.getString("GROUP_SEQ_NO")+"',";
//										db_stg_srlno		=	db_stg_srlno+"'"+rslt.getString("STAGE_SRL_NO")+"',";
									}
										db_grp_seqno=db_grp_seqno.substring(0,db_grp_seqno.length()-1);
//										db_stg_srlno=db_stg_srlno.substring(0,db_stg_srlno.length()-1);
									/*Added For 10/22/2009*/
									if(rslt!=null){
										rslt.close();
									}
									sql_proc_seq_rej ="UPDATE MR_PROCEDURE_RECODING_DTL set TRX_NO ='',CONFIRM_YN='N', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and PROC_CODE ="+proc_cd+" AND GROUP_SEQ_NO in ("+db_grp_seqno+") AND ACTIVE_YN='Y'" ;
								}else{
								sql_proc_seq_rej="update MR_PROCEDURE_RECODING_DTL set TRX_NO ='',CONFIRM_YN='N', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";
								}
								pstmt = con.prepareStatement( sql_proc_seq_rej );
								 res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
								if(res1<=0){
									 error="Y";
									  break;
								 }

								 String sql_del_procedure="delete from mr_procedure_recoding_dtl  where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and confirm_YN='N' and active_YN='Y' and sequenced_YN='H'";
								 //String sql_updt_procedure="update  mr_procedure_recoding_dtl set recode_status='X'  where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and confirm_YN='N' and active_YN='Y' and sequenced_YN='H'";

								pstmt = con.prepareStatement( sql_del_procedure );
								 res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();

								
							}else{
								sql_proc_seq_rej="update MR_PROCEDURE_RECODING_DTL set TRX_NO ='',CONFIRM_YN='N', MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";
								pstmt = con.prepareStatement( sql_proc_seq_rej );
								 res1 = pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
								if(res1<=0){
									 error="Y";
									  break;
								 }
							}
										
							
						}// while loop	for proc						
						
					} // check any proc selected fpr auth
				}

				int res2=0;
				if(error.equals("")){
					String sql_del_drg= "delete from  MR_ENCOUNTER_DRG_INFO where  FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
					pstmt = con.prepareStatement( sql_del_drg);
					res2 = pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();

					String sql_update_hdr_rej="";
					//String getHdr_status_sql	=	"select nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS from MR_DIAG_PROC_RECODING_HDR where  FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
					//String L1_stat="";
					//String L2_stat="";
					//String L3_stat="";
					//pstmt = con.prepareStatement( getHdr_status_sql );
					//rslt = pstmt.executeQuery();
					//while(rslt.next()){
						//L1_stat =rslt.getString("LEVEL1_STATUS");
						//L2_stat =rslt.getString("LEVEL2_STATUS");
						//L3_stat =rslt.getString("LEVEL3_STATUS");
					//}
					//if(pstmt!=null)pstmt.close();
					//if(rslt!=null)rslt.close();

					if(stage_no.equals("1")){
						sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='N',LEVEL1_STATUS='S', CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("2")){
						//if(L1_stat.equals("A")){
							//L1_stat="C";
						//}
						sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='N',LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("3")){
						//if(L1_stat.equals("A")){
							//L1_stat="C";
						//}
						//if(L2_stat.equals("A")){
							//L2_stat="C";
						//}
						sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='N',LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}
				
					pstmt = con.prepareStatement( sql_update_hdr_rej );
					res2 = pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
				}

				if(res2!=0){
					err_value="1";
					con.commit();
						hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
						L1_hdr_status	 = (String)hdr_status_list.get(0);
						L2_hdr_status	 = (String)hdr_status_list.get(1);
						L3_hdr_status	 = (String)hdr_status_list.get(2);
						curr_level			 = (String)hdr_status_list.get(3);
						hdr_modified_dt_qr	= (String)hdr_status_list.get(4);

					Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error = (String)hashtable1.get("message");

					out.print("alert('"+error+"');");


					if(stage_no.equals("1")){
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}

					out.println("frame.parent.frames[1].onSuccess();");


					out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
					
					out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

					if ( hashtable1 != null ) {
						hashtable1.clear();
					}

					}else{
					err_value="0";
					con.rollback();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
				}
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();


		}
		finally{

			
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}




private void ReCalculateDRG(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int res1=0;

			ResultSet rslt=null;
			String error="";
			String proceed="Y";
			String drg_active_YN="";
			String drg_active_sql	=	"select nvl(ADDL_FIELD1,'N') drg_active_YN from XB_PARAM";
			pstmt = con.prepareStatement( drg_active_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				drg_active_YN =rslt.getString("drg_active_YN");
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();

			if(Patient_Class.equals("IP") && drg_active_YN.equals("N")){
				proceed="N";
			}
			if(proceed.equals("N")){
				Hashtable hashtable1 = MessageManager.getMessage(locale, "MR_DRG_INACT","MR");
				error = (String)hashtable1.get("message");

				out.print("alert('"+error+"');");
				out.println("frame.parent.frames[1].enable_auth();");

				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");
			}else{

				String sqlbl = "{? = call BL_GENERATE_INVOICE.RECALCULATE_DRG(?,?,?,?,?,?,?)}";
				CallableStatement cs = con.prepareCall(sqlbl);
				cs.registerOutParameter(1,java.sql.Types.VARCHAR);

				cs.setString(2, x_facility_id);
				cs.setString(3, patient_id);
				cs.setString(4, p_episode_type);//Added on 6/21/2010 for Dynamic pat_Class
				cs.setInt(5, Integer.parseInt(encounter_id));
				cs.registerOutParameter(6,java.sql.Types.VARCHAR);
				cs.registerOutParameter(7,java.sql.Types.VARCHAR);
				cs.registerOutParameter(8,java.sql.Types.VARCHAR);
				cs.executeUpdate();
//				 String bl_val = cs.getString(1); Commented For Open Connection Issues 10/22/2009
//				 String err_lev = cs.getString(6); Commented For Open Connection Issues 10/22/2009
				 String sys_msg_id = checkForNull(cs.getString(7),"");
//				 String err_txt = cs.getString(8);Commented For Open Connection Issues 10/22/2009
				if(cs != null)
				cs.close();
				// if (sys_msg_id != null){
				 if (! sys_msg_id.equals("")){
						java.util.Locale loc = new java.util.Locale(locale);
						java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
						String blmessage = (String) messages.getString(sys_msg_id);
						//sb.append(blmessage);

						//err_value="0";
						//con.rollback();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(blmessage,"UTF-8"));	

					}else{

					if(!Confirm_Dig_Data.equals("")){

						int indx=Confirm_Dig_Data.indexOf(",");
						if(indx <0){
							Confirm_Dig_Data=Confirm_Dig_Data+",";
							sel_srl_no=sel_srl_no+",";
							diag_new_seq="'1',";
						}
//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
						StringTokenizer diag_codes= new StringTokenizer(Confirm_Dig_Data,",");
						StringTokenizer diag_srl_no= new StringTokenizer(sel_srl_no,",");
						StringTokenizer diag_seq_numbers= new StringTokenizer(diag_new_seq,",");
						StringTokenizer diag_group_yn= new StringTokenizer(final_Diag_group_yn,",");
						StringTokenizer diag_group_seq_no= new StringTokenizer(group_seq_no_data,",");
						StringTokenizer diag_support_seq_no= new StringTokenizer(support_seq_no_data,",");


						
						
						while(diag_codes.hasMoreTokens()){ 

							String dg_cd					= diag_codes.nextToken();
							String dg_slno				= diag_srl_no.nextToken();
							String dg_seqno			= diag_seq_numbers.nextToken();
							String dg_grp_yn			= diag_group_yn.nextToken();
							String dg_grp_seq_no	= diag_group_seq_no.nextToken();
							String dg_spprt_seq_no=diag_support_seq_no.nextToken();


										
							String sql_diag_recal="update MR_DIAGNOSIS_RECODING_DTL set TRX_NO = "+dg_seqno+",MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";

							//STAGE_NO='"+stage_no+"',--to discuss
							pstmt = con.prepareStatement( sql_diag_recal );
							 res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(res1<=0){
								 error="Y";
								  break;
							 }
//							String ADDL_CRITERIA="";
							String tem_seq_no	= dg_seqno.substring(1,dg_seqno.length()-1);
							int temp_seq_no		= Integer.parseInt(tem_seq_no);
							int ins_sts=0;
							ins_sts=UpdateTRXnoforSupprtdiagnosis(dg_cd,dg_spprt_seq_no,dg_grp_yn,dg_grp_seq_no,temp_seq_no);
							if(ins_sts==11){
								error="Y";
								break;
							}


						}// while loop	for diag			
						
					} // check any diag selected fpr confirm


					if(!Confirm_Proc_Data.equals("")){

//						int ins_count=0;Commented For Open Connection Issues 10/22/2009
							int indx=Confirm_Proc_Data.indexOf(",");
						if(indx <0){
							Confirm_Proc_Data=Confirm_Proc_Data+",";
							sel_proc_srl_no=sel_proc_srl_no+",";
							proc_new_seq="'1',";
						}
						StringTokenizer proc_codes= new StringTokenizer(Confirm_Proc_Data,",");
						StringTokenizer proc_srl_no= new StringTokenizer(sel_proc_srl_no,",");
						StringTokenizer proc_seq_numbers= new StringTokenizer(proc_new_seq,",");

//						int seq_no_proc=1;Commented For Open Connection Issues 10/22/2009
						
						while(proc_codes.hasMoreTokens()){ 

							String proc_cd =proc_codes.nextToken();
							String proc_slno =proc_srl_no.nextToken();
							String proc_seqno=proc_seq_numbers.nextToken();

										
							String sql_proc_recal="update MR_PROCEDURE_RECODING_DTL set TRX_NO ="+proc_seqno+",MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";

							//STAGE_NO='"+stage_no+"',--to discuss
							pstmt = con.prepareStatement( sql_proc_recal );
							 res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(res1<=0){
								 error="Y";
								  break;
							 }


						}// while loop	for proc			
						
					} // check any proc selected fpr auth

					int res2=0;
					if(error.equals("")){

						String sql_update_hdr_rej="";

						if(stage_no.equals("1")){
							sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='Y',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("2")){
							sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='Y',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}else if(stage_no.equals("3")){
							sql_update_hdr_rej="update MR_DIAG_PROC_RECODING_HDR set TRX_NO='',SEQUENCED_YN='Y',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

						}
						pstmt = con.prepareStatement( sql_update_hdr_rej );
						res2 = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();
					}

					if(res2!=0){
						err_value="1";
						con.commit();
						hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
						L1_hdr_status	 = (String)hdr_status_list.get(0);
						L2_hdr_status	 = (String)hdr_status_list.get(1);
						L3_hdr_status	 = (String)hdr_status_list.get(2);
						curr_level			 = (String)hdr_status_list.get(3);
						hdr_modified_dt_qr	= (String)hdr_status_list.get(4);

				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						error = (String)hashtable1.get("message");

						//out.print("<script>alert('"+error+"')</script>");


						if(stage_no.equals("1")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}
						out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");

						out.println("frame.parent.frames[1].onSuccess_Auth('IP','Y');");

						
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

						if ( hashtable1 != null ) {
							hashtable1.clear();
						}

						}else{
						err_value="0";
						con.rollback();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
					}
				}
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();


		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}


	private void RecodeAuthorize(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int res1=0;

			ResultSet rslt=null;
			String error="";
			String proceed="Y";
			String DRG_CALCULATION_YN="N";

			
			String drg_active_YN="";
			String drg_active_sql	=	"select nvl(ADDL_FIELD1,'N') drg_active_YN from XB_PARAM";
			pstmt = con.prepareStatement( drg_active_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				drg_active_YN =rslt.getString("drg_active_YN");
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();

			if(Patient_Class.equals("IP") && drg_active_YN.equals("N")){
				proceed="N";
			}

			String drg_calcyn_sql	=	"select nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN from mr_parameter";
			pstmt = con.prepareStatement( drg_calcyn_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				DRG_CALCULATION_YN =rslt.getString("DRG_CALCULATION_YN");
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();

			if(DRG_CALCULATION_YN.equals("N")){
				proceed="Y";
			}

			if(proceed.equals("N")){
				Hashtable hashtable1 = MessageManager.getMessage(locale, "MR_DRG_INACT","MR");
				error = (String)hashtable1.get("message");

				out.print("alert('"+error+"');");
				out.println("frame.parent.frames[1].enable_auth();");

				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

			}else{



				if(!Confirm_Dig_Data.equals("")){

//					int ins_count=0;Commented For Open Connection Issues 10/22/2009

	
					StringTokenizer diag_codes= new StringTokenizer(Confirm_Dig_Data,",");
					StringTokenizer diag_srl_no= new StringTokenizer(sel_srl_no,",");
					StringTokenizer diag_grp_yn= new StringTokenizer(final_Diag_group_yn,",");
					StringTokenizer diag_grp_seq_no= new StringTokenizer(group_seq_no_data,",");
					StringTokenizer diag_support_seq_no= new StringTokenizer(support_seq_no_data,",");
					int seq_no_diag=2;
					//String seq_no_sql	=	"SELECT  nvl(max(TRX_NO),0)+1 SEQ_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
					//pstmt = con.prepareStatement( seq_no_sql );
					//rslt = pstmt.executeQuery();
					//while(rslt.next()){
						//seq_no_diag =Integer.parseInt(rslt.getString("SEQ_NO"));
					//}
					//if(pstmt!=null)pstmt.close();
					//if(rslt!=null)rslt.close();
					String sql_diag_seq_auth="";
					while(diag_codes.hasMoreTokens()){ 

						String dg_cd				 = diag_codes.nextToken();
						String dg_slno			 = diag_srl_no.nextToken();
						String dg_grp_yn		 = diag_grp_yn.nextToken();
						String dg_grp_seqno	 = diag_grp_seq_no.nextToken();
						String dg_spprt_seqno	 = diag_support_seq_no.nextToken();

						int ins_sts	=0;
						
						if(dg_cd.equals(prin_trm_code) && dg_slno.equals(prin_srl_no)){
							int	 prim_seq_no =1;
							sql_diag_seq_auth="update MR_DIAGNOSIS_RECODING_DTL set TRX_NO =1,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";
							ins_sts=UpdateTRXnoforSupprtdiagnosis(dg_cd,dg_spprt_seqno,dg_grp_yn,dg_grp_seqno,prim_seq_no);
						}else{
							sql_diag_seq_auth="update MR_DIAGNOSIS_RECODING_DTL set TRX_NO = "+seq_no_diag+",MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and term_code ="+dg_cd+" and STAGE_SRL_NO ="+dg_slno+" and ACTIVE_YN='Y'";
							ins_sts=UpdateTRXnoforSupprtdiagnosis(dg_cd,dg_spprt_seqno,dg_grp_yn,dg_grp_seqno,seq_no_diag);
							seq_no_diag=seq_no_diag+1;
						}

						if(ins_sts!=11){
							pstmt = con.prepareStatement( sql_diag_seq_auth );
							 res1 = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();
							if(res1<=0){
								 error="Y";
								  break;
							 }
						}else{
							 error="Y";
							  break;
						}//Successful Updation of TRX Nos for Support Diagnosis
					}// while loop	for diag			
				} // check any diag selected fpr confirm
				if(!Confirm_Proc_Data.equals("")){
//					int ins_count=0;Commented For Open Connection Issues 10/22/2009
					StringTokenizer proc_codes= new StringTokenizer(Confirm_Proc_Data,",");
					StringTokenizer proc_srl_no= new StringTokenizer(sel_proc_srl_no,",");

					int seq_no_proc=0;
					String seq_no_sql	=	"SELECT  nvl(max(TRX_NO),0)+1 SEQ_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and stage_no='"+stage_no+"'  ";
					pstmt = con.prepareStatement( seq_no_sql );
					rslt = pstmt.executeQuery();
					while(rslt.next()){
						seq_no_proc=Integer.parseInt(rslt.getString("SEQ_NO"));
					}
					if(pstmt!=null)pstmt.close();
					if(rslt!=null)rslt.close();
					while(proc_codes.hasMoreTokens()){ 
						String proc_cd =proc_codes.nextToken();
						String proc_slno =proc_srl_no.nextToken();
						String sql_proc_seq_auth="update MR_PROCEDURE_RECODING_DTL set TRX_NO ="+seq_no_proc+",MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and proc_code ="+proc_cd+" and STAGE_SRL_NO ="+proc_slno+" and ACTIVE_YN='Y'";

						//STAGE_NO='"+stage_no+"',--to discuss
						pstmt = con.prepareStatement( sql_proc_seq_auth );
						 res1 = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();
						if(res1<=0){
							 error="Y";
							  break;
						 }
						seq_no_proc=seq_no_proc+1;

					}// while loop	for proc			
					
				} // check any proc selected fpr auth

				int res2=0;
				if(error.equals("")){
					String sql_update_hdr_auth="";

					if(stage_no.equals("1")){
						sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='A',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("2")){
						sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='A',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}else if(stage_no.equals("3")){
						sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='A',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

					}

					pstmt = con.prepareStatement( sql_update_hdr_auth );
					res2 = pstmt.executeUpdate();
					}

				if(res2!=0){

					// Code added on 2nd Feb 2011 to support Cancer Centre Interface
		
					CallableStatement cncr_call = con.prepareCall("{call XHMR.CANCERTRG(?,?,?,?,?)}");				
					cncr_call.setString(1,patient_id);
					cncr_call.setString(2,encounter_id);
					cncr_call.setString(3,x_facility_id);
					cncr_call.registerOutParameter(4,java.sql.Types.VARCHAR);
					cncr_call.registerOutParameter(5,java.sql.Types.VARCHAR);


					cncr_call.execute();
					String cncr_call_errortxt = "";
					cncr_call_errortxt=cncr_call.getString(4);
					//String cncr_call_evtfire = cncr_call.getString(5);

					if(cncr_call_errortxt== null)
						cncr_call_errortxt="";

					if(cncr_call != null) cncr_call.close();

					if(cncr_call_errortxt != null && cncr_call_errortxt.equals("")) { // end code change  in else part to support Cancer Centre Interface	 				

						err_value="1";
						con.commit();
						hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
						L1_hdr_status	 = (String)hdr_status_list.get(0);
						L2_hdr_status	 = (String)hdr_status_list.get(1);
						L3_hdr_status	 = (String)hdr_status_list.get(2);
						curr_level			 = (String)hdr_status_list.get(3);
						hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
						Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						error = (String)hashtable1.get("message");

						if(!Patient_Class.equals("IP")){
							out.print("alert('"+error+"');");
						}else{
							if(DRG_CALCULATION_YN.equals("N")){
								out.print("alert('"+error+"');");
							}else{
								Hashtable hashtable2 = MessageManager.getMessage(locale, "MRDRG_INVOKE","MR");
								error = (String)hashtable2.get("message");							
								out.print("alert('"+error+"');");
							}
						}

						if(stage_no.equals("1")){
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
							out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
							out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						}

						out.println("frame.parent.frames[1].onSuccess_Auth('"+Patient_Class+"','"+DRG_CALCULATION_YN +"');");


						out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
						
						out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

						if ( hashtable1 != null ) {
							hashtable1.clear();
						}
					}else{ // else part for cancer center interfacing
						err_value="0";
						con.rollback();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+cncr_call_errortxt);	 	 
					}

				}else{
					err_value="0";
					con.rollback();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
				}
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();


		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}





	private void RecodeCompletion(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			String sql_update_hdr="";

			if(stage_no.equals("1")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='C',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

			}else if(stage_no.equals("2")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='C',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

			}else if(stage_no.equals("3")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='C',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

			}

			pstmt = con.prepareStatement( sql_update_hdr );
			int res2 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}
			if(res2!=0){
				err_value="1";
				con.commit();
				 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				out.print("alert('"+error+"');");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}

				out.println("frame.parent.frames[1].onSuccess();");


				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){

				ex.printStackTrace();
			}
//				out.println("Exception in DiagProcRecodingServlet RecodeConmpletion()"+e.toString());
				e.printStackTrace();
				error=e.getMessage();
		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}

	private void RecodeRejection(HttpServletRequest req, HttpServletResponse res){  // on clik of reject button after doing completion
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			String sql_update_hdr="";
			String sql_update_diagnosis="update mr_diagnosis_recoding_dtl set confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and stage_no= '"+stage_no+"' and confirm_YN='Y' and active_YN='Y'";
			String sql_update_procedure="update mr_procedure_recoding_dtl set confirm_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and stage_no= '"+stage_no+"' and confirm_YN='Y' and active_YN='Y'";
			String sql_update_diagnosis_1="update mr_diagnosis_recoding_dtl set recode_status='O',sequenced_YN='' ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and stage_no= '"+stage_no+"' and confirm_YN='N' and active_YN='Y' and sequenced_YN='H'";
			String sql_update_procedure_1="update mr_procedure_recoding_dtl set recode_status='O',sequenced_YN='' , MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"'  where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and stage_no= '"+stage_no+"' and confirm_YN='N' and active_YN='Y' and sequenced_YN='H'";
			if(stage_no.equals("1")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
			}else if(stage_no.equals("2")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

			}else if(stage_no.equals("3")){
				sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

			}
			int res1=0;
			int res2=0;
			int res3=0;
			int res1_1=0;
			int res2_2=0;
			

			pstmt = con.prepareStatement( sql_update_diagnosis );
			res1 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}
			pstmt = con.prepareStatement( sql_update_procedure );
			res2 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}
			pstmt = con.prepareStatement( sql_update_diagnosis_1 );
			res1_1 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}

			pstmt = con.prepareStatement( sql_update_procedure_1 );
			res2_2 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}
			pstmt = con.prepareStatement( sql_update_hdr );
			res3 = pstmt.executeUpdate();
			if(pstmt!=null){
				pstmt.close();
			}

			if( res1 !=0 || res2!=0 || res1_1!=0 || res2_2!=0 || res3!=0){
			//if( res3!=0){
				
				err_value="1";
				con.commit();
				 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				out.print("alert('"+error+"');");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}
				
				out.println("frame.parent.frames[1].onSuccess();");

				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
			}
//			out.println("Exception in DiagProcRecodingServlet RecodeRejection()"+e.toString());
			e.printStackTrace();
			error=e.getMessage();
		}
		finally{
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}
private void RecodeModifyDiagnosis(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int res1=0;
			int res3=0;
			StringTokenizer st_sel=new StringTokenizer(sel_srl_no,",");
//			StringTokenizer st_sel_dummy=new StringTokenizer(sel_srl_no,",");
			StringTokenizer st_sel_tcode=new StringTokenizer(sel_term_code,",");
//			StringTokenizer st_sel_tset=new StringTokenizer(sel_term_set,","); Commented For Open Connection Issues 10/22/2009
			StringTokenizer st_sel_stages=new StringTokenizer(sel_stages_val,",");
//			StringTokenizer st_sel_stages_dummy=new StringTokenizer(sel_stages_val,",");
//			StringTokenizer st_sel_status=new StringTokenizer(sel_status,",");
//			StringTokenizer st_sel_status_dummy=new StringTokenizer(sel_status,",");
			StringTokenizer st_sel_groups=new StringTokenizer(grpby_val,",");
//			StringTokenizer st_sel_tcode_dummy=new StringTokenizer(sel_term_code,",");

			String sql_stg_srl_no_diag ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
			pstmt2 = con.prepareStatement(sql_stg_srl_no_diag) ;
			rs = pstmt2.executeQuery();
			
			while(rs.next()){
				stage_srl_no = rs.getString("srl_no");						
			}
			stg_srl_number=Integer.parseInt( stage_srl_no );
								
			if(rs != null) rs.close();
			if(pstmt2 != null) pstmt2.close();

			String curr_line_stg		="";
			String sel_srl_no			="";
			String sql_rec_diagclas	="";
			String orig_sel_termcd	="";
			String Group_YN			="";
			curr_line_stg			=	st_sel_stages.nextToken();
			sel_srl_no				=	st_sel.nextToken();
			orig_sel_termcd	=	st_sel_tcode.nextToken(); 
			Group_YN			=	st_sel_groups.nextToken();
			if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg)){
					String ex_active_yn	= "Y";
					String error_dtl	 	= "";
					if(status.equals("X")){
						ex_active_yn ="N";
						error_dtl		 ="X";
					}

				if(Group_YN.equals("Y")){
						String group_seq_no="";
						String sql_group_seq_no ="select GROUP_SEQ_NO  from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' and TERM_CODE='"+orig_sel_termcd+"' and STAGE_SRL_NO='"+sel_srl_no+"' ";
						pstmt2 = con.prepareStatement(sql_group_seq_no) ;
						rs = pstmt2.executeQuery();
						while(rs.next()){
							group_seq_no = rs.getString("GROUP_SEQ_NO");						
						}
						if(rs != null) rs.close();
						if(pstmt2 != null) pstmt2.close();
						/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
					 sql_rec_diagclas	="UPDATE MR_DIAGNOSIS_RECODING_DTL  SET DIAG_CLASS_CODE='"+diag_classfication+"', ACCURACY_CODE='"+accuracy_code+"', SEVERITY='"+severity_code+"', PRIORITY='"+priority_code+"', ONSET_TYPE='"+onset_type+"', APPLICABLE_SIDE='"+applicable_side+"', STATUS='"+status+"', REMARKS='"+remarks+"',RECORDED_DATE_TIME=sysdate, PRACTITIONER_ID='"+practitioner_id+"',ACTIVE_YN='"+ex_active_yn+"',ERROR_DTL='"+error_dtl+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+x_facility_id+"',ENC_STAGE='"+encounter_stage+"' ,NOTIFICATION_CODE='"+notifiable_code+"'  " ;   
					 
					if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1281
					{
						String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
						sql_rec_diagclas = sql_rec_diagclas + " , TERM_CODE_SHORT_DESC='"+term_oth_desc_temp+"'  " ;
						
					}
					 
					 sql_rec_diagclas = sql_rec_diagclas +" WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND GROUP_SEQ_NO='"+group_seq_no+"'  ";
				}else{     
				/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				 sql_rec_diagclas	="UPDATE MR_DIAGNOSIS_RECODING_DTL  SET DIAG_CLASS_CODE='"+diag_classfication+"', ACCURACY_CODE='"+accuracy_code+"', SEVERITY='"+severity_code+"', PRIORITY='"+priority_code+"', ONSET_TYPE='"+onset_type+"', APPLICABLE_SIDE='"+applicable_side+"', STATUS='"+status+"', REMARKS='"+remarks+"',RECORDED_DATE_TIME=sysdate, PRACTITIONER_ID='"+practitioner_id+"',ACTIVE_YN='"+ex_active_yn+"',ERROR_DTL='"+error_dtl+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+x_facility_id+"' ,ENC_STAGE='"+encounter_stage+"' ,NOTIFICATION_CODE='"+notifiable_code+"' " ;
				
				if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true")) // added by mujafar for ML-MMOH-CRF-1281
				{
						String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
						sql_rec_diagclas = sql_rec_diagclas + " , TERM_CODE_SHORT_DESC='"+term_oth_desc_temp+"'  " ;
						
				}
				
				 sql_rec_diagclas = sql_rec_diagclas + " WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND STAGE_SRL_NO='"+sel_srl_no+"' ";
				}
				res1=0; 
				pstmt = con.prepareStatement( sql_rec_diagclas );
				res1 = pstmt.executeUpdate(); 
				/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
						  if( res1>0) 
						   {
				 Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,orig_sel_termcd,term_set,occur_srl_no,diagprob_short_desc,patient_id,status,con);
						   }
				 /*END HAS-CRF-300*/
				if(pstmt!=null){
					pstmt.close();
				}

			}else{//Higer Level Modification
						String ex_active_yn	= "Y";
						String error_dtl	 		= "";
						if(status.equals("X")){
							ex_active_yn ="N";
							error_dtl		 ="X";
						}
						/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
						 sql_rec_diagclas="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,ERROR_DTL,SUPPORT_SEQ_NO,enc_stage,notification_code) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stg_srl_number+", "+stg_srl_number+", 'N', 'O', TERM_SET_ID, TERM_CODE, '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"',  '"+onset_type+"', ONSET_DATE, '"+applicable_side+"', '"+status+"', AS_ON_DATE, CAUSE_OF_DEATH, '"+remarks+"', ACCESSION_NUM,sysdate,  '"+practitioner_id+"', '"+ex_active_yn+"', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','',ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,'"+error_dtl+"',SUPPORT_SEQ_NO,ENC_STAGE,'"+notifiable_code+"'  from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and FACILITY_ID='"+x_facility_id+"' AND TERM_CODE='"+orig_sel_termcd+"' AND STAGE_SRL_NO='"+sel_srl_no+"'";
						res1=0;
						pstmt = con.prepareStatement( sql_rec_diagclas );
						res1 = pstmt.executeUpdate(); 
						/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
						if( res1>0) 
						   {
				 Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,orig_sel_termcd,term_set,occur_srl_no,diagprob_short_desc,patient_id,status,con);
						   }
						 /* END HAS-CRF-300 */
						if(pstmt!=null){
							pstmt.close();
						}
			}
				/*if(res1>0){
					inserted = true;
				}else{
					inserted = false;
				}*/

			if(res1 != 0){  // updating header with status and the current stage.
				String sql_update_hdr="";
				if(stage_no.equals("1")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}else if(stage_no.equals("2")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}else if(stage_no.equals("3")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}
				res3=0;
				pstmt = con.prepareStatement( sql_update_hdr );
				res3 = pstmt.executeUpdate();
				if(res3 != 0){
				inserted = true;
				}else{
				inserted = false;
				}
			}
			if(pstmt!=null)pstmt.close();
			if(inserted == true){
				err_value="1";
				con.commit();  // to be removed. for checking
				//con.rollback();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				out.print(";alert('"+error+"');");
				 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}

				out.println("frame.parent.frames[1].onSuccess();");

				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");

				out.println("frame.frames[5].location.href=\"../eCommon/html/blank.html?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}


			}catch(Exception ex ){
					ex.printStackTrace();
			}finally{
				if(con != null)
					ConnectionManager.returnConnection(con,p);
			}

}
private void RecodeModifyProcedure(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			int res1=0;
			int res3=0;
			StringTokenizer st_sel=new StringTokenizer(sel_srl_no,",");
//			StringTokenizer st_sel_dummy=new StringTokenizer(sel_srl_no,",");
			StringTokenizer st_sel_tcode=new StringTokenizer(sel_term_code,",");
//			StringTokenizer st_sel_tset=new StringTokenizer(sel_term_set,","); Commented For Open Connection Issues 10/22/2009
			StringTokenizer st_sel_stages=new StringTokenizer(sel_stages_val,",");
//			StringTokenizer st_sel_stages_dummy=new StringTokenizer(sel_stages_val,",");
//			StringTokenizer st_sel_status=new StringTokenizer(sel_status,",");
//			StringTokenizer st_sel_status_dummy=new StringTokenizer(sel_status,",");
			StringTokenizer st_sel_groups=new StringTokenizer(grpby_val,",");
//			StringTokenizer st_sel_tcode_dummy=new StringTokenizer(sel_term_code,",");

			String sql_stg_srl_no_diag ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";

			pstmt2 = con.prepareStatement(sql_stg_srl_no_diag) ;
			rs = pstmt2.executeQuery();
			
			while(rs.next()){
				stage_srl_no = rs.getString("srl_no");						
			}
			stg_srl_number=Integer.parseInt( stage_srl_no );
								
			if(rs != null) rs.close();
			if(pstmt2 != null) pstmt2.close();

			String curr_line_stg		="";
			String sel_srl_no			="";
			String sql_proc_modify	="";
			String orig_sel_termcd	="";
			String Group_YN			="";
			curr_line_stg			=	st_sel_stages.nextToken();
			sel_srl_no				=	st_sel.nextToken();
			orig_sel_termcd	=	st_sel_tcode.nextToken();
			Group_YN			=	st_sel_groups.nextToken();
			if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg)){
					String ex_active_yn	= "Y";
					String error_dtl	 	= "";
					if(status.equals("X")){
						ex_active_yn ="N";
						error_dtl		 ="X";
					}
				if(Group_YN.equals("Y")){
						String group_seq_no="";
						String sql_group_seq_no ="select GROUP_SEQ_NO  from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' and PROC_CODE='"+orig_sel_termcd+"' and STAGE_SRL_NO='"+sel_srl_no+"' ";
						pstmt2 = con.prepareStatement(sql_group_seq_no) ;
						rs = pstmt2.executeQuery();
						while(rs.next()){
							group_seq_no = rs.getString("GROUP_SEQ_NO");						
						}
						if(rs != null) rs.close();
						if(pstmt2 != null) pstmt2.close();

					 sql_proc_modify	="UPDATE MR_PROCEDURE_RECODING_DTL  SET CODE_EXTN_DTL='"+code_extn_dtl+"', PROC_DATE=sysdate,REMARKS='"+remarks+"',PRACTITIONER_ID='"+practitioner_id+"',LATERALITY_IND='"+laterality_ind+"',PROC_CHECKIN_START_DATE_TIME=to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),PROC_CHECKOUT_END_DATE_TIME=to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'),STATUS='"+status+"',ACTIVE_YN='"+ex_active_yn+"',ERROR_DTL='"+error_dtl+"',MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+x_facility_id+"'  WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND GROUP_SEQ_NO='"+group_seq_no+"' ";
				}else{
					 sql_proc_modify	="UPDATE MR_PROCEDURE_RECODING_DTL  SET CODE_EXTN_DTL='"+code_extn_dtl+"', PROC_DATE=sysdate,REMARKS='"+remarks+"',PRACTITIONER_ID='"+practitioner_id+"',LATERALITY_IND='"+laterality_ind+"',PROC_CHECKIN_START_DATE_TIME=to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),PROC_CHECKOUT_END_DATE_TIME=to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'),STATUS='"+status+"',ACTIVE_YN='"+ex_active_yn+"',ERROR_DTL='"+error_dtl+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+x_facility_id+"'  WHERE FACILITY_ID='"+x_facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND STAGE_SRL_NO='"+sel_srl_no+"' ";
				}
				res1=0;
				pstmt = con.prepareStatement( sql_proc_modify );
				res1 = pstmt.executeUpdate(); 
				if(pstmt!=null){
					pstmt.close();
				}
			}else{//Higer Level Modification
						String ex_active_yn	= "Y";
						String error_dtl	 	= "";
						if(status.equals("X")){
							ex_active_yn ="N";
							error_dtl		 ="X";
						}
						 sql_proc_modify="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME,ERROR_DTL) select FACILITY_ID, ENCOUNTER_ID,PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE,"+stage_no+", "+stg_srl_number+", "+stg_srl_number+", 'N', 'O',PROC_CODE_SCHEME, PROC_CODE, '"+remarks+"','"+practitioner_id+"',sysdate,'"+laterality_ind+"','"+ex_active_yn+"','N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','','"+status+"', ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, '"+code_extn_dtl+"',ORIG_REP_SRL,to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'),'"+error_dtl+"' from MR_PROCEDURE_RECODING_DTL where  encounter_id='"+encounter_id+"' and FACILITY_ID='"+x_facility_id+"' AND PROC_CODE='"+orig_sel_termcd+"' AND STAGE_SRL_NO='"+sel_srl_no+"'";

						res1=0;
						pstmt = con.prepareStatement( sql_proc_modify );
						res1 = pstmt.executeUpdate(); 

			}
				/*if(res1>0){
					inserted = true;
				}else{
					inserted = false;
				}*/
			if(res1 != 0){  // updating header with status and the current stage.
				String sql_update_hdr="";
				if(stage_no.equals("1")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}else if(stage_no.equals("2")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}else if(stage_no.equals("3")){
					sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
				}
				res3=0;
				pstmt = con.prepareStatement( sql_update_hdr );
				res3 = pstmt.executeUpdate();
				if(res3 != 0){
				inserted = true;
				}else{
				inserted = false;
				}
				if(pstmt!=null)pstmt.close();
			}
			if(inserted == true){
					err_value="1";
					con.commit();  // to be removed. for checking
					 hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
					L1_hdr_status	 = (String)hdr_status_list.get(0);
					L2_hdr_status	 = (String)hdr_status_list.get(1);
					L3_hdr_status	 = (String)hdr_status_list.get(2);
					curr_level			 = (String)hdr_status_list.get(3);
					hdr_modified_dt_qr	= (String)hdr_status_list.get(4);

					//con.rollback();
					Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error = (String)hashtable1.get("message");
					out.print("alert('"+error+"');");
					if(stage_no.equals("1")){
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
						out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
						out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					}
					out.println("frame.parent.frames[1].onSuccess();");
					out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");

					out.println("frame.frames[5].location.href=\"../eCommon/html/blank.html?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"\";");

					out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

					if ( hashtable1 != null ) {
					hashtable1.clear();
				}
			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}
		}catch(Exception ex ){
				ex.printStackTrace();
		}finally{
			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
}

	private void RecodeAddModify(HttpServletRequest req, HttpServletResponse res){
		try	{
			
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			int res1=0;
			int res2=0;
			int res3=0;

			StringTokenizer st_sel=new StringTokenizer(sel_srl_no,",");
			StringTokenizer st_sel_dummy=new StringTokenizer(sel_srl_no,",");
			StringTokenizer st_sel_tcode=new StringTokenizer(sel_term_code,",");
			StringTokenizer st_sel_tset=new StringTokenizer(sel_term_set,",");

			StringTokenizer st_sel_stages=new StringTokenizer(sel_stages_val,",");
			StringTokenizer st_sel_stages_dummy=new StringTokenizer(sel_stages_val,",");
		

//			StringTokenizer st_sel_status=new StringTokenizer(sel_status,",");Commented For Open Connection Issues 10/22/2009
//			StringTokenizer st_sel_status_dummy=new StringTokenizer(sel_status,",");Commented For Open Connection Issues 10/22/2009

			StringTokenizer st_sel_groups=new StringTokenizer(grpby_val,",");
			StringTokenizer st_sel_tcode_dummy=new StringTokenizer(sel_term_code,",");
//			StringTokenizer st_sel_mod_id=new StringTokenizer(sel_mod_id,",");Commented For Open Connection Issues 10/22/2009
			StringTokenizer st_sel_cod_xtn=new StringTokenizer(sel_cod_xtn,",");
////			String db_sel_access_num=sel_acess_num.replace("|","$");
//			StringTokenizer st_sel_acess_num=new StringTokenizer(db_sel_access_num,",");
//			StringTokenizer st_sel_cod_xtn_dtl=new StringTokenizer(sel_cod_xtn_dtl,",");

			count_selected=st_sel_tcode.countTokens();
			if(newCode_yn.equals("Y")){  // adding new code

				if(procedure_yn.equals("Y")){	 //adding a new procedure

					String sql_stg_srl_no_proc ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
					pstmt2 = con.prepareStatement(sql_stg_srl_no_proc) ;
					rs = pstmt2.executeQuery();
					
					while(rs.next()){
						stage_srl_no = rs.getString("srl_no");						
					}
					stg_srl_number=Integer.parseInt( stage_srl_no );
					
					if(rs != null) rs.close();
					if(pstmt2 != null) pstmt2.close();
					
							/*if(code_extn_dtl.equals("XT")){
									code_extn_dtl="";
								}*/
/*
	F.Y.I:This function was  modified on 12/15/2009 for SRR-CRF-303.1.
	1.Inserting laterality,check/start date and time & check out/end date and time.
*/
					String sql_ins_new_proc="insert into MR_PROCEDURE_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO,STAGE_SEQ_NO,GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,ACTIVE_YN,CONTR_MOD_ID,CODE_EXTN_DTL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME,STATUS) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+term_set+"', '"+term_set_code1+"', '"+stage_no+"', "+stg_srl_number+","+stg_srl_number+", 'N','N','"+term_set+"','"+term_set_code1+"', '"+remarks+"','"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'"+laterality_ind+"','Y','"+proc_type+"','"+code_extn_dtl+"',to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'),'"+status+"')";
					pstmt = con.prepareStatement( sql_ins_new_proc );
					res1 = pstmt.executeUpdate(); 
					if(res1 != 0){ //updating header with status and the current stage.
						String sql_update_hdr="";
						
						if(stage_no.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}
					
						pstmt = con.prepareStatement( sql_update_hdr );
						int res0 = pstmt.executeUpdate();
						if(res0 != 0){
							inserted = true;
						}else{
							inserted = false;
						}

						
					}else{
						inserted = false;
					}
					if(pstmt != null) pstmt.close();
					
				}else{  // adding a new diagnosis

					String sql_stg_srl_no_diag ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
						
					pstmt2 = con.prepareStatement(sql_stg_srl_no_diag) ;
					rs = pstmt2.executeQuery();
					
					while(rs.next()){
						stage_srl_no = rs.getString("srl_no");						
					}
					stg_srl_number=Integer.parseInt( stage_srl_no );	

					if(rs != null) rs.close();
					if(pstmt2 != null) pstmt2.close();
				
					String sql_ins_new_diag=""; // added by mujafar for ML-MMOH-CRF-1281
					if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true"))
					{
						String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
					sql_ins_new_diag="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,SUPPORT_SEQ_NO,enc_stage,notification_code,TERM_CODE_SHORT_DESC) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+term_set+"', '"+term_set_code1+"', '"+stage_no+"', "+stg_srl_number+", "+stg_srl_number+",'N','N', '"+term_set+"','"+term_set_code1+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+term_oth_desc_temp+"')";
						
						
					}
					else
					{
	         /* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
					sql_ins_new_diag="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,SUPPORT_SEQ_NO,enc_stage,notification_code) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+term_set+"', '"+term_set_code1+"', '"+stage_no+"', "+stg_srl_number+", "+stg_srl_number+",'N','N', '"+term_set+"','"+term_set_code1+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"')";
					}
					pstmt = con.prepareStatement( sql_ins_new_diag );
					res1 = pstmt.executeUpdate(); 
//					int supp_res	=0;
					int k=0;
					if(res1 != 0){ //updating header with status and the current stage.
						if(!supp_diag_map.isEmpty()){
//							int supp_diag_status=Recordsupportdiagnosis(k,term_set,term_set_code1,occur_srl_no,stage_no,stg_srl_number,"");
							Recordsupportdiagnosis(k,term_set,term_set_code1,occur_srl_no,stage_no,stg_srl_number,"");
						}
						String sql_update_hdr="";
						if(stage_no.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}
						pstmt = con.prepareStatement( sql_update_hdr );
						int res0 = pstmt.executeUpdate();
						if(res0 != 0){
						/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
						Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,term_set_code1,term_set,occur_srl_no,diagprob_desc,patient_id,status,con);
							inserted = true;
						}else{
							inserted = false;
						}
						}else{
							inserted = false;
						}
						if(pstmt != null) pstmt.close();
				}
			}else{// recoding and exiting code
				if(procedure_yn.equals("Y")){	 //recoding  procedure

					String sql_stg_srl_no_diag ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
						
					pstmt2 = con.prepareStatement(sql_stg_srl_no_diag) ;
					rs = pstmt2.executeQuery();
					
					while(rs.next()){
						stage_srl_no = rs.getString("srl_no");						
					}
					stg_srl_number=Integer.parseInt( stage_srl_no );
										
					if(rs != null) rs.close();
					if(pstmt2 != null) pstmt2.close();

					String new_term_code="";
					String curr_line_stg="";
//					String line_contr_mod_id="";
					String line_code_xtn_yn="";
//					String line_acess_num="";
//					String line_code_xtn_dtl="";
					if(count_selected==1){  // only one diagnosis is selcted for recoding

						curr_line_stg=st_sel_stages.nextToken();
//						line_contr_mod_id=st_sel_mod_id.nextToken();
//						line_code_xtn_yn=st_sel_cod_xtn.nextToken();
						String sql_grp_x_seqno="";
						String grp_seq_no	    ="";
						String grp_x_seqno	    ="";
						if(termcode_cnt>1){
							sql_grp_x_seqno	="select nvl(max(GROUP_SEQ_NO),0)+1 GROUP_SEQ_NO from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
							pstmt2 = con.prepareStatement(sql_grp_x_seqno) ;
							rs = pstmt2.executeQuery();
							while(rs.next()){
								grp_seq_no = rs.getString("GROUP_SEQ_NO");						
							}
						}
						int tm_stg_srl_no=0;
						for(int k=0;k<termcode_cnt;k++){ // recoding for one to one or one to many

							if(k==0){
								new_term_code=term_set_code1;
							}else if(k==1){
								new_term_code=term_set_code2;
							}else if(k==2){
								new_term_code=term_set_code3;
							}
							
							if(termcode_cnt>1){
								group_YN="X";
							}else{
								group_YN="N";
							}	
							
							if(k==0){
								orig_sel_termcd=st_sel_tcode.nextToken();
								orig_sel_termset=st_sel_tset.nextToken();
								sel_srl_no=st_sel.nextToken();
								/*line_contr_mod_id=st_sel_mod_id.nextToken();
								if(line_contr_mod_id.equals("XT")){
									line_contr_mod_id="";
								}*/
								line_code_xtn_yn	=	st_sel_cod_xtn.nextToken();

								/*line_acess_num		=	st_sel_acess_num.nextToken();
								if(line_acess_num.equals("00")){
									line_acess_num	 =	"";
								}*/
								/*line_code_xtn_dtl	=	st_sel_cod_xtn_dtl.nextToken();
								if(line_code_xtn_dtl.equals("01")){
									line_code_xtn_dtl	 =	"";
								}*/

							}
				
					if(group_YN.equals("X")){
						grp_x_seqno	 =grp_seq_no;
					}else{
						grp_x_seqno="";
					}						
						
							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ // same level recoding

									String sql_rec_diag="insert into  MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO,STAGE_SEQ_NO,GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,ACTIVE_YN,GROUP_SEQ_NO,CONTR_MOD_ID,CODE_EXTN_YN, CODE_EXTN_DTL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) values ('"+x_facility_id+"', '"+encounter_id+"','"+patient_id+"',  '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+remarks+"',  '"+addedById+"',sysdate,'"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'"+laterality_ind+"','Y','"+grp_x_seqno+"','"+proc_type+"','"+line_code_xtn_yn+"','"+code_extn_dtl+"',to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'))";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag );
									res1 = pstmt.executeUpdate(); 
									stg_srl_number=stg_srl_number+1;
							}else{  // higher level recoding
								if(k==0){
									 tm_stg_srl_no=stg_srl_number;
									String sql_rec_diag1="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select FACILITY_ID, ENCOUNTER_ID,PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, "+stage_no+",  "+stg_srl_number+","+stg_srl_number+",'N', 'O', PROC_CODE_SCHEME, PROC_CODE, REMARKS,  PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,'N','N','"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','"+grp_x_seqno+"',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and proc_code='"+orig_sel_termcd+"' and stage_srl_no='"+sel_srl_no+"'";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag1 );
									res1 = pstmt.executeUpdate(); 
									if(pstmt !=null) pstmt.close();

									stg_srl_number=stg_srl_number+1;

								}else{
									res1=1;
								}
									if(res1 >0){

//										int tm_stg_srl_no=stg_srl_number;
										int stg_seq_no=tm_stg_srl_no;
//										stg_srl_number=stg_srl_number+1;

									


										String sql_rec_diag2="insert into  MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID,PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO,STAGE_SEQ_NO,GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,ACTIVE_YN,CONTR_MOD_ID,CODE_EXTN_YN, CODE_EXTN_DTL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME)  values ('"+x_facility_id+"', '"+encounter_id+"','"+patient_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+stg_seq_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+remarks+"',  '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'"+laterality_ind+"','Y','"+proc_type+"','"+line_code_xtn_yn+"','"+code_extn_dtl+"',to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'))";

										res1=0;
										pstmt = con.prepareStatement( sql_rec_diag2 );
										res1 = pstmt.executeUpdate(); 
										if(pstmt !=null) pstmt.close();

										stg_srl_number=stg_srl_number+1;

									}


							}


							if(res1== 0){
								break;
							}
			

						}// recoding for one to one or one to many
					}else{ // multiple procedure selected for recoding to single

						String group_seq_no="";
					
						String sql_group_seq_no ="select nvl(max(GROUP_SEQ_NO),0)+1 GROUP_SEQ_NO from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
						pstmt2 = con.prepareStatement(sql_group_seq_no) ;
						rs = pstmt2.executeQuery();
						
						while(rs.next()){
							group_seq_no = rs.getString("GROUP_SEQ_NO");						
						}
						
											
						if(rs != null) rs.close();
						if(pstmt2 != null) pstmt2.close();

						while(st_sel_tcode.hasMoreTokens()){ // recoding many to one

							orig_sel_termcd=st_sel_tcode.nextToken();
							orig_sel_termset=st_sel_tset.nextToken();
							sel_srl_no=st_sel.nextToken();
							curr_line_stg=st_sel_stages.nextToken();
							/*line_contr_mod_id=st_sel_mod_id.nextToken();
							if(line_contr_mod_id.equals("XT")){
								line_contr_mod_id="";
							}*/
							line_code_xtn_yn=st_sel_cod_xtn.nextToken();
							/*line_acess_num		=	st_sel_acess_num.nextToken();
							if(line_acess_num.equals("00")){
								line_acess_num	 =	"";
							}*/
							/*line_code_xtn_dtl	=	st_sel_cod_xtn_dtl.nextToken();
							if(line_code_xtn_dtl.equals("01")){
								line_code_xtn_dtl	 =	"";
							}*/
						
							new_term_code=term_set_code1;
							group_YN="Y";
							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ // same level recoding
									String sql_rec_diag_multi_one="insert into  MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO,STAGE_SEQ_NO,GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,ACTIVE_YN,GROUP_SEQ_NO,CONTR_MOD_ID, CODE_EXTN_YN, CODE_EXTN_DTL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME,STATUS) values ( '"+x_facility_id+"', '"+encounter_id+"','"+patient_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+remarks+"',  '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'"+laterality_ind+"','Y',"+group_seq_no+",'"+proc_type+"','"+line_code_xtn_yn+"','"+code_extn_dtl+"',to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'),'"+status+"')";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag_multi_one );
									res1 = pstmt.executeUpdate(); 
									stg_srl_number=stg_srl_number+1;
							}else{   /// higher level recoding
									
									String sql_rec_diag1="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select FACILITY_ID, ENCOUNTER_ID,PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, "+stage_no+",  "+stg_srl_number+","+stg_srl_number+",'N', 'O', PROC_CODE_SCHEME, PROC_CODE, REMARKS,  PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,'N','N','"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and proc_code='"+orig_sel_termcd+"' and stage_srl_no='"+sel_srl_no+"'";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag1 );
									res1 = pstmt.executeUpdate(); 
									if(pstmt !=null) pstmt.close();
									if(res1 >0){
										int tm_stg_srl_no=stg_srl_number;
										stg_srl_number=stg_srl_number+1;
											String sql_rec_diag_multi_one="insert into  MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID,PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO,STAGE_SEQ_NO,GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,PROC_DATE,LATERALITY_IND,ACTIVE_YN,GROUP_SEQ_NO,CONTR_MOD_ID, CODE_EXTN_YN,CODE_EXTN_DTL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) values ( '"+x_facility_id+"', '"+encounter_id+"', '"+patient_id+"','"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+tm_stg_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+remarks+"',  '"+addedById+"',sysdate,'"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'"+laterality_ind+"','Y',"+group_seq_no+",'"+proc_type+"','"+line_code_xtn_yn+"','"+code_extn_dtl+"',to_date('"+proc_srt_dt_time+"','dd/mm/yyyy hh24:mi'),to_date('"+proc_end_dt_time+"','dd/mm/yyyy hh24:mi'))";
											res1=0;
											pstmt = con.prepareStatement( sql_rec_diag_multi_one );
											res1 = pstmt.executeUpdate(); 
											if(pstmt !=null) pstmt.close();
											stg_srl_number=stg_srl_number+1;
									}
							}

							if(res1== 0){
								break;
							}
						
						}  // loop end
					}// end check for one selection or multiple selection




					if(res1 != 0){
						 
						while(st_sel_dummy.hasMoreTokens()){  // updating status to inactive for the selcted diagnosis. 
							sel_srl_no=st_sel_dummy.nextToken();
							curr_line_stg=st_sel_stages_dummy.nextToken();
							String grp_status=st_sel_groups.nextToken();
							String tc_code=st_sel_tcode_dummy.nextToken();
//							String curr_sel_status =st_sel_status_dummy.nextToken();Commented For Open Connection Issues 10/22/2009
							String stage_serial_number="";
							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ // same level recoding
									if(grp_status.equals("Y")){
									String sql_srl_no ="select stage_srl_no  from MR_PROCEDURE_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' and proc_code='"+tc_code+"' and group_YN='Y'" ;
									pstmt2 = con.prepareStatement(sql_srl_no) ;
									rs = pstmt2.executeQuery();
									while(rs.next()){
										stage_serial_number = rs.getString("stage_srl_no");						
										String sql_update_cur_active="update MR_PROCEDURE_RECODING_DTL set ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO ='"+stage_serial_number+"'";
										res2=0;
										pstmt = con.prepareStatement( sql_update_cur_active );
										res2 = pstmt.executeUpdate();
									}
//									stage_serial_number=stage_serial_number.substring(0,stage_serial_number.length()-1);

														
									if(rs != null) rs.close();
									if(pstmt2 != null) pstmt2.close();
								}else{
									stage_serial_number=sel_srl_no;
									String sql_update_cur_active="update MR_PROCEDURE_RECODING_DTL set ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO ='"+sel_srl_no+"'";
									res2=0;
									pstmt = con.prepareStatement( sql_update_cur_active );
									res2 = pstmt.executeUpdate();
								}

								
								if(res2== 0){
									break;
								}
							}else{
								res2=1;
							}/*else{
								if(curr_sel_status.equals("N")){
									String sql_update_cur_active="update MR_PROCEDURE_RECODING_DTL set RECODE_STATUS='F',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO="+sel_srl_no+"";
									res2=0;
									pstmt = con.prepareStatement( sql_update_cur_active );
									res2 = pstmt.executeUpdate();
									if(res2== 0){
										break;
									}
								}else{
									res2=0;
								}
							}*/
						}
						if(res2 != 0){  // updating header with status and the current stage.
								String sql_update_hdr="";
								if(stage_no.equals("1")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}else if(stage_no.equals("2")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}else if(stage_no.equals("3")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}

								res3=0;
								pstmt = con.prepareStatement( sql_update_hdr );
								res3 = pstmt.executeUpdate();
								if(res3 != 0){
									inserted = true;
								}else{
									inserted = false;
								}
						}
						
					}else{
						inserted = false;
					}
					if(pstmt != null) pstmt.close();
			}else{ //recoding  diagnosis
					int supp_stg_srl_no=0;
					String sql_stg_srl_no_diag ="select nvl(max(STAGE_SRL_NO),0)+1 srl_no from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
					pstmt2 = con.prepareStatement(sql_stg_srl_no_diag) ;
					rs = pstmt2.executeQuery();
						while(rs.next()){
						stage_srl_no = rs.getString("srl_no");						
					}
					stg_srl_number=Integer.parseInt( stage_srl_no );
										
					if(rs != null) rs.close();
					if(pstmt2 != null) pstmt2.close();

					String new_term_code="";
					
					String curr_line_stg="";
					if(count_selected==1){  // only one diagnosis is selcted for recoding

						curr_line_stg=st_sel_stages.nextToken();
						String sql_grp_x_seqno="";
						String grp_seq_no		   ="";
						String grp_x_seqno		   ="";
						if(termcode_cnt>1){
							sql_grp_x_seqno	="select nvl(max(GROUP_SEQ_NO),0)+1 GROUP_SEQ_NO from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
							pstmt2 = con.prepareStatement(sql_grp_x_seqno) ;
							rs = pstmt2.executeQuery();
							while(rs.next()){
								grp_seq_no = rs.getString("GROUP_SEQ_NO");						
							}

						}
						int tm_stg_srl_no=0;
						for(int k=0;k<termcode_cnt;k++){ // recoding for one to one or one to many

							if(k==0){
								new_term_code=term_set_code1;
							}else if(k==1){
								new_term_code=term_set_code2;
							}else if(k==2){
								new_term_code=term_set_code3;
							}
							
							if(termcode_cnt>1){
								group_YN="X";
							}else{
								group_YN="N";
							}	
							
							if(k==0){
								orig_sel_termcd=st_sel_tcode.nextToken();
								orig_sel_termset=st_sel_tset.nextToken();
								sel_srl_no=st_sel.nextToken();

							}						
							
							if(group_YN.equals("X")){
								grp_x_seqno	 =grp_seq_no;
							}else{
								grp_x_seqno="";
							} 
							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ 
							     // same level recoding
								 /* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
									String sql_rec_diag= ""; // added by mujafar for ML-MMOH-CRF-1281
									
									if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true"))
									{
										String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
										
										sql_rec_diag="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO ,enc_stage,notification_code,DOCTORS_DESCRIPTION,TERM_CODE_SHORT_DESC) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y','"+grp_x_seqno+"',"+stg_srl_number+" ,'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"','"+term_oth_desc_temp+"')"; //doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
										
										
									}
									else
									{
									
									sql_rec_diag="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO ,enc_stage,notification_code,DOCTORS_DESCRIPTION) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y','"+grp_x_seqno+"',"+stg_srl_number+" ,'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"')"; //doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
									}
									
									res1=1;
									pstmt = con.prepareStatement( sql_rec_diag );
									res1 = pstmt.executeUpdate(); 
									supp_stg_srl_no	= stg_srl_number;// This Stage Srl Number will be passed to Support Diagnosis part.
									stg_srl_number=stg_srl_number+1;
									if(!supp_diag_map.isEmpty()){
										if(res1>0){
											Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,"");
										}
									}
								/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
					    	if(res1 > 0)
				        	{	
							Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,term_set_code1,term_set,occur_srl_no,diagprob_desc,patient_id,status,con); 
						     }
							/* END HAS-CRF-300 */		
							}else{  // higher level recoding
								if(k==0){
									 tm_stg_srl_no=stg_srl_number;
									 /* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
									 
									String sql_rec_diag1="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,enc_stage,notification_code) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stg_srl_number+", "+stg_srl_number+", 'N', 'O', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'N', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','"+grp_x_seqno+"',ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and term_code='"+orig_sel_termcd+"' and stage_srl_no='"+sel_srl_no+"'";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag1 );
									res1 = pstmt.executeUpdate(); 
									if(pstmt !=null) pstmt.close();
									stg_srl_number=stg_srl_number+1;
					/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				            if(res1 > 0){
							Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,term_set_code1,term_set,occur_srl_no,diagprob_desc,patient_id,status,con);
						   }
								/* END HAS-CRF-300 */
								}else{
									res1=1;
								}
									if(res1 >0){
										 int stg_seq_no=tm_stg_srl_no; 
									   /* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
										
										String sql_rec_diag2=""; // added by mujafar for ML-MMOH-CRF-1281
										if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true"))
										{
											String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
										sql_rec_diag2="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,SUPPORT_SEQ_NO, ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION,TERM_CODE_SHORT_DESC) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+stg_seq_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"','"+term_oth_desc_temp+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
											
										}
										else
										{
									   
										sql_rec_diag2="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,SUPPORT_SEQ_NO, ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+stg_seq_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
										}
										res1=0;
										pstmt = con.prepareStatement( sql_rec_diag2 );
										res1 = pstmt.executeUpdate(); 
										if(pstmt !=null) pstmt.close();
										supp_stg_srl_no	 = stg_srl_number;
										stg_srl_number=stg_srl_number+1;
										if(!supp_diag_map.isEmpty()){
											if(res1>0){
												Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,"");
											}
										}
									}
							}


							if(res1== 0){
								break;
							}
						}// recoding for one to one or one to many
					}else{ // multiple diagnosis selected for recoding to single
						int k=0;
						String group_seq_no="";
					
						String sql_group_seq_no ="select nvl(max(GROUP_SEQ_NO),0)+1 GROUP_SEQ_NO from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
						pstmt2 = con.prepareStatement(sql_group_seq_no) ;
						rs = pstmt2.executeQuery();
						while(rs.next()){
							group_seq_no = rs.getString("GROUP_SEQ_NO");						
						}
																	
						if(rs != null) rs.close();
						if(pstmt2 != null) pstmt2.close();
							while(st_sel_tcode.hasMoreTokens()){ // recoding many to one

							orig_sel_termcd=st_sel_tcode.nextToken();
							orig_sel_termset=st_sel_tset.nextToken();
							sel_srl_no=st_sel.nextToken();
							curr_line_stg=st_sel_stages.nextToken();
							
							new_term_code=term_set_code1;
														
							group_YN="Y";

							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ // same level recoding
			/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
									String sql_rec_diag_multi_one=""; // added by mujafar for ML-MMOH-CRF-1281
									if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true"))
									{
										String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
										sql_rec_diag_multi_one="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION,TERM_CODE_SHORT_DESC) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+group_seq_no+","+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"','"+term_oth_desc_temp+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
										
									}
									
									
									else{
									sql_rec_diag_multi_one="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+sel_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+group_seq_no+","+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
									}
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag_multi_one );
									res1 = pstmt.executeUpdate(); 
									supp_stg_srl_no	 = stg_srl_number;
									stg_srl_number=stg_srl_number+1;
									if(!supp_diag_map.isEmpty()){
										if(res1>0 && k==0){
//											int supp_diag_status=Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,group_seq_no);
										Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,group_seq_no);
										}
									}
							}else{   /// higher level recoding
									/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
									String sql_rec_diag1="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stg_srl_number+", "+stg_srl_number+", 'N', 'O', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'N', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '', '','',ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and term_code='"+orig_sel_termcd+"' and stage_srl_no='"+sel_srl_no+"'";
									res1=0;
									pstmt = con.prepareStatement( sql_rec_diag1 );
									res1 = pstmt.executeUpdate(); 
									if(pstmt !=null) pstmt.close();
									if(res1 >0){
										int tm_stg_srl_no=stg_srl_number;
										stg_srl_number=stg_srl_number+1;
										/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
										String sql_rec_diag_multi_one=""; // added by mujafar for ML-MMOH-CRF-1281
										if(!term_oth_desc.equals("") && term_set.equals("ICD10") && isMultiDescAppl.equals("true"))
										{
											String term_oth_desc_temp = term_oth_desc.replaceAll("'","''");
											sql_rec_diag_multi_one="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION,TERM_CODE_SHORT_DESC) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+tm_stg_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+group_seq_no+","+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"','"+term_oth_desc_temp+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
											
										}
										
										else{
										sql_rec_diag_multi_one="insert into  MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO,GROUP_YN,RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SEQUENCED_YN,PRACTITIONER_ID,RECORDED_DATE_TIME,ACTIVE_YN,GROUP_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE,DOCTORS_DESCRIPTION) values ('"+patient_id+"', '"+x_facility_id+"', '"+encounter_id+"', '"+occur_srl_no+"', '"+orig_sel_termset+"', '"+orig_sel_termcd+"', '"+stage_no+"', "+stg_srl_number+", "+tm_stg_srl_no+",'"+group_YN+"','R', '"+term_set+"','"+new_term_code+"', '"+diag_classfication+"', '"+accuracy_code+"', '"+severity_code+"', '"+priority_code+"', '"+onset_type+"', to_date('"+onset_date+"','dd/mm/yyyy hh24:MI'), '"+applicable_side+"', '"+status+"', to_date('"+status_date+"','dd/mm/yyyy'), '"+caused_death+"', '"+remarks+"', '', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',sysdate, '"+client_ip_address+"', '"+x_facility_id+"','','"+practitioner_id+"',sysdate,'Y',"+group_seq_no+","+stg_srl_number+",'"+encounter_stage+"','"+notifiable_code+"','"+doctor_desc+"')";//doctor_desc Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
										}
										res1=0;
										pstmt = con.prepareStatement( sql_rec_diag_multi_one );
										try{
											res1 = pstmt.executeUpdate(); 
										}catch(Exception exx){
											exx.printStackTrace();
										}
										if(pstmt !=null) pstmt.close();
										supp_stg_srl_no = stg_srl_number;
										stg_srl_number	  = stg_srl_number+1;
										if(!supp_diag_map.isEmpty()){
											if(res1>0 && k==0){
//												int supp_diag_status=Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,group_seq_no);
												Recordsupportdiagnosis(k,term_set,new_term_code,occur_srl_no,stage_no,supp_stg_srl_no,group_seq_no);
											}
										}
										/* In Below lines  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
									  if(res1>0){
									  Record_ChiefComplient(req,complaint_id,x_facility_id,encounter_id,term_set_code1,term_set,occur_srl_no,diagprob_desc,patient_id,status,con);
									  }
									/* END HAS-CRF-300 */
									}

							}

							if(res1== 0){
								break;
							}
						k++;}  // loop end
					}// end check for one selection or multiple selection
					if(res1 != 0){
							while(st_sel_dummy.hasMoreTokens()){  // updating status to inactive for the selcted diagnosis. 
							sel_srl_no=st_sel_dummy.nextToken();
							curr_line_stg=st_sel_stages_dummy.nextToken();
							String grp_status=st_sel_groups.nextToken();
							String tc_code=st_sel_tcode_dummy.nextToken();
//							String curr_sel_status =st_sel_status_dummy.nextToken();Commented For Open Connection Issues 10/22/2009
							String stage_serial_number="";
							if(Integer.parseInt(stage_no)==Integer.parseInt(curr_line_stg) ){ // same level recoding
								if(grp_status.equals("Y")){
									String sql_srl_no ="select stage_srl_no  from MR_DIAGNOSIS_RECODING_DTL where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' and term_code='"+tc_code+"' and group_YN='Y'" ;
									pstmt2 = con.prepareStatement(sql_srl_no) ;
									rs = pstmt2.executeQuery();
									
									while(rs.next()){
										stage_serial_number = rs.getString("stage_srl_no");						
									
										String sql_update_cur_active="update MR_DIAGNOSIS_RECODING_DTL set ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO ='"+stage_serial_number+"'";
										res2=0;
										pstmt = con.prepareStatement( sql_update_cur_active );
										res2 = pstmt.executeUpdate();
										}
									if(rs != null) rs.close();
									if(pstmt2 != null) pstmt2.close();
								}else{
									stage_serial_number=sel_srl_no;
									String sql_update_cur_active="update MR_DIAGNOSIS_RECODING_DTL set ACTIVE_YN='N',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO ='"+sel_srl_no+"'";
									res2=0;
									pstmt = con.prepareStatement( sql_update_cur_active );
									res2 = pstmt.executeUpdate();
								}
								if(res2== 0){
									break;
								}
							}else{
								res2=1;// Added On 8/17/2009
							}

							
							/*else{
								if(curr_sel_status.equals("N")){
									String sql_update_cur_active="update MR_DIAGNOSIS_RECODING_DTL set RECODE_STATUS='F',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"' and STAGE_SRL_NO="+sel_srl_no+"";

									
									res2=0;
									pstmt = con.prepareStatement( sql_update_cur_active );
									res2 = pstmt.executeUpdate();
									if(res2== 0){
										break;
									}
								}else{
									res2=1;
								}
							}*/

						}

						if(res2 != 0){  // updating header with status and the current stage.
							

								String sql_update_hdr="";

								if(stage_no.equals("1")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}else if(stage_no.equals("2")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}else if(stage_no.equals("3")){
									sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

								}

							
								res3=0;
								pstmt = con.prepareStatement( sql_update_hdr );
								res3 = pstmt.executeUpdate();
								if(res3 != 0){
									inserted = true;
								}else{
									inserted = false;
								}
						}
						
					}else{
						inserted = false;
					}
					if(pstmt != null) pstmt.close();
					


					
				}
			}


			if(inserted == true){
				err_value="1";
				con.commit();  // to be removed. for checking
				hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				//con.rollback();
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");
				out.print("alert('"+error+"');");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("parent.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}

				out.println("frame.frames[1].onSuccess();");

				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");

				out.println("frame.frames[5].location.href=\"../eCommon/html/blank.html?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
//			out.println("Exception in DiagProcRecodingServlet RecodeAddModify()"+e.toString());
			e.printStackTrace();
			error=e.getMessage();


		}
		//Added for check style
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
			
		}


		
	}



	private void RejectDiagnosis(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			ResultSet rslt=null;
			String error="";
			int stge_srlno=0;
			int res1=0;
			int res2=0;

			String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1  STAGE_SRL_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
			pstmt = con.prepareStatement( stge_srlno_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				stge_srlno=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			String sql_active	=	"SELECT STAGE_SRL_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and Recode_status in ('R','O','N') and active_YN='Y'";
			pstmt = con.prepareStatement( sql_active );
			rslt = pstmt.executeQuery();
			ArrayList active_array=new ArrayList();

			while(rslt.next()){
				active_array.add(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			int srl_no=0;
			for(int j=0;j<active_array.size();j++){
				srl_no=Integer.parseInt((String) active_array.get(j));
/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				String ins_active_err__diag="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO, ENC_STAGE,NOTIFICATION_CODE) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'Z', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'N', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, SEQUENCED_YN,GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and stage_srl_no='"+srl_no+"' ";
				res1=0;
				pstmt = con.prepareStatement( ins_active_err__diag );
				res1 = pstmt.executeUpdate(); 
				if(pstmt !=null) pstmt.close();
				
				if(res1>0){
				}else{
					error="Y";
					break;

				}
				stge_srlno=stge_srlno+1;



			}




			String sql_originals	=	"SELECT STAGE_SRL_NO FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and stage_no='0' and status='A' ";
			pstmt = con.prepareStatement( sql_originals );
			rslt = pstmt.executeQuery();
			ArrayList orig_array=new ArrayList();

			while(rslt.next()){
				orig_array.add(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			srl_no=0;
			for(int i=0;i<orig_array.size();i++){
				srl_no=Integer.parseInt((String) orig_array.get(i));
/* In Below query ENC_STAGE and NOTIFICATION_CODE  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				String ins_orig_diag="insert into MR_DIAGNOSIS_RECODING_DTL (PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID, ORIG_TERM_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY, ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME, PRACTITIONER_ID, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE) select PATIENT_ID, FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO, ORIG_TERM_SET_ID,  ORIG_TERM_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'O', TERM_SET_ID, TERM_CODE, DIAG_CLASS_CODE, ACCURACY_CODE, SEVERITY, PRIORITY,  ONSET_TYPE, ONSET_DATE, APPLICABLE_SIDE, STATUS, AS_ON_DATE, CAUSE_OF_DEATH, REMARKS, ACCESSION_NUM, RECORDED_DATE_TIME,  PRACTITIONER_ID, 'Y', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, SEQUENCED_YN,GROUP_SEQ_NO,ORIG_REP_SRL,TERM_CODE_SHORT_DESC,RECORDED_FROM_DEATH_REG_YN, DEATH_REG_SEQ_NO,SUPPORT_SEQ_NO,ENC_STAGE,NOTIFICATION_CODE from MR_DIAGNOSIS_RECODING_DTL where  encounter_id='"+encounter_id+"' and facility_id='"+x_facility_id+"' and stage_srl_no='"+srl_no+"' and stage_no='0'";
				res1=0;
				pstmt = con.prepareStatement( ins_orig_diag );
				res1 = pstmt.executeUpdate(); 
				if(pstmt !=null) pstmt.close();
				
				if(res1>0){
				}else{
					error="Y";
					break;

				}
				stge_srlno=stge_srlno+1;



			}


			if(error.equals("")){
				String sql_update_hdr_auth="";

				if(stage_no.equals("1")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}else if(stage_no.equals("2")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}else if(stage_no.equals("3")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}

				
				pstmt = con.prepareStatement( sql_update_hdr_auth );
				res2 = pstmt.executeUpdate();
				if(pstmt!=null){
					pstmt.close();
				}
			}

			if(res2!=0){
				err_value="1";
				con.commit();
				hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");

				out.print("alert('"+error+"');");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}

				out.println("frame.parent.frames[1].onSuccess();");


				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();
		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}


	private void RejectProcedure(HttpServletRequest req, HttpServletResponse res){
		try	{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			ResultSet rslt=null;
			String error="";
			int stge_srlno=0;
			int res1=0;
			int res2=0;

			String stge_srlno_sql	=	"SELECT  nvl(max(STAGE_SRL_NO),0)+1  STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"'  ";
			pstmt = con.prepareStatement( stge_srlno_sql );
			rslt = pstmt.executeQuery();
			while(rslt.next()){
				stge_srlno=Integer.parseInt(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			String sql_active	=	"SELECT STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and Recode_status in ('R','O','N') and active_YN='Y'";
			pstmt = con.prepareStatement( sql_active );
			rslt = pstmt.executeQuery();
			ArrayList active_array=new ArrayList();

			while(rslt.next()){
				active_array.add(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			int srl_no=0;
			for(int j=0;j<active_array.size();j++){
				srl_no=Integer.parseInt((String) active_array.get(j));

				String ins_active_err__proc="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select FACILITY_ID, ENCOUNTER_ID, PATIENT_ID,  SRL_NO, ORIG_PROC_CODE_SCHEME,  ORIG_PROC_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'Z', PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID,PROC_DATE,LATERALITY_IND, 'N', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, SEQUENCED_YN,'',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL WHERE  ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"' AND STAGE_SRL_NO='"+srl_no+"'";
				res1=0;
				pstmt = con.prepareStatement( ins_active_err__proc );
				res1 = pstmt.executeUpdate(); 
				if(pstmt !=null) pstmt.close();
				
				if(res1>0){
				}else{
					error="Y";
					break;

				}
				stge_srlno=stge_srlno+1;
			}

			String sql_originals	=	"SELECT STAGE_SRL_NO FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+x_facility_id+"'  AND ENCOUNTER_ID='"+encounter_id+"' and stage_no='0' and status='A' ";
			pstmt = con.prepareStatement( sql_originals );
			rslt = pstmt.executeQuery();
			ArrayList orig_array=new ArrayList();

			while(rslt.next()){
				orig_array.add(rslt.getString("STAGE_SRL_NO"));
			}
			if(pstmt!=null)pstmt.close();
			if(rslt!=null)rslt.close();
			srl_no=0;
			for(int i=0;i<orig_array.size();i++){
				srl_no=Integer.parseInt((String) orig_array.get(i));

				String ins_orig_proc="insert into MR_PROCEDURE_RECODING_DTL (FACILITY_ID, ENCOUNTER_ID, PATIENT_ID, SRL_NO, ORIG_PROC_CODE_SCHEME, ORIG_PROC_CODE, STAGE_NO, STAGE_SRL_NO, STAGE_SEQ_NO, GROUP_YN, RECODE_STATUS, PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID, PROC_DATE, LATERALITY_IND, ACTIVE_YN, CONFIRM_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, TRX_NO, SEQUENCED_YN, GROUP_SEQ_NO,STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME) select FACILITY_ID, ENCOUNTER_ID, PATIENT_ID,  SRL_NO, ORIG_PROC_CODE_SCHEME,  ORIG_PROC_CODE, "+stage_no+", "+stge_srlno+", "+stge_srlno+", 'N', 'O', PROC_CODE_SCHEME, PROC_CODE, REMARKS, PRACTITIONER_ID,PROC_DATE,LATERALITY_IND, 'Y', 'N', '"+addedById+"', sysdate, '"+client_ip_address+"', '"+x_facility_id+"', '"+addedById+"',  sysdate, '"+client_ip_address+"', '"+x_facility_id+"', TRX_NO, SEQUENCED_YN,'',STATUS, ORDER_ID, ORDER_LINE_NUM, CONTR_MOD_ID, PERFORMED_LOC_IND, ACCESSION_NUM, PROC_PERF_FACILITY, PROC_PERF_LOCN_CODE,CODE_EXTN_YN, CODE_EXTN_DTL,ORIG_REP_SRL,PROC_CHECKIN_START_DATE_TIME,PROC_CHECKOUT_END_DATE_TIME from MR_PROCEDURE_RECODING_DTL WHERE  ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+x_facility_id+"' AND STAGE_SRL_NO='"+srl_no+"' and stage_no='0' ";
				res1=0;
				pstmt = con.prepareStatement( ins_orig_proc );
				res1 = pstmt.executeUpdate(); 
				if(pstmt !=null) pstmt.close();
				
				if(res1>0){
				}else{
					error="Y";
					break;

				}
				stge_srlno=stge_srlno+1;
			}


			if(error.equals("")){
				String sql_update_hdr_auth="";

				if(stage_no.equals("1")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}else if(stage_no.equals("2")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}else if(stage_no.equals("3")){
					sql_update_hdr_auth="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' where FACILITY_ID= '"+x_facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";

				}

				pstmt = con.prepareStatement( sql_update_hdr_auth );
				res2 = pstmt.executeUpdate();
				if(pstmt!=null){
					pstmt.close();
				}
			}

			if(res2!=0){
				err_value="1";
				con.commit();
				hdr_status_list=getAllhdrstatus(encounter_id,x_facility_id,req);
				L1_hdr_status	 = (String)hdr_status_list.get(0);
				L2_hdr_status	 = (String)hdr_status_list.get(1);
				L3_hdr_status	 = (String)hdr_status_list.get(2);
				curr_level			 = (String)hdr_status_list.get(3);
				hdr_modified_dt_qr	= (String)hdr_status_list.get(4);
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)hashtable1.get("message");

				out.print("alert('"+error+"');");

				if(stage_no.equals("1")){
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("2")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}else if(stage_no.equals("3")){                                                                                                                                                                                                                                                                                                                           
					out.println("frame.frames[2].location.href=\"../eMR/jsp/DPRecodingDiag1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
					out.println("frame.frames[3].location.href=\"../eMR/jsp/DPRecodingProc1.jsp?mode=Y&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&dflt_termset="+dflt_termset+"&Patient_Class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"\";");
				}

				out.println("frame.parent.frames[1].onSuccess();");


				out.println("frame.frames[4].location.href=\"../eMR/jsp/DPRecodingButton.jsp?mode=Y&execute_hdr_qry=N&stage_no="+stage_no+"&Pat_id="+patient_id+"&EncounterId="+encounter_id+"&pat_class="+Patient_Class+"&L1_hdr_status="+L1_hdr_status+"&L2_hdr_status="+L2_hdr_status+"&L3_hdr_status="+L3_hdr_status+"&curr_level="+curr_level+"&hdr_modified_dt_qr="+hdr_modified_dt_qr+"\";");
				
				out.println("frame.frames[6].location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=0"+"\";");

				if ( hashtable1 != null ) {
					hashtable1.clear();
				}

			}else{
				err_value="0";
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+URLEncoder.encode(error,"UTF-8"));	 	 
			}

		}catch (Exception e){
			try{
				con.rollback();

			}catch(Exception ex){
					ex.printStackTrace();
			}
			e.printStackTrace();
			error=e.getMessage();


		}
		finally{

			if(con != null)
				ConnectionManager.returnConnection(con,p);
		}
			
	}


	private void doOnlineReports(HttpServletRequest request) throws ServletException, IOException, SQLException

{
		StringBuffer htmlFor =new StringBuffer();
		htmlFor.setLength(0);
		String reportParamNames = "";
		String reportParamValues = "";
//		String encounter_id = "";
//		String facility_id = "";
//		String patient_id = "";
//		String p_language_id = "";		
//		String mode = "";		
		//String p_locn_code="";
		//String p_locn_type="";

		//PrintWriter out = response.getWriter();
		try
		{
			
		
		String iss_facility_id = request.getParameter( "rep_facility_id" ) ;
		String iss_patient_id = request.getParameter("rep_Pat_id");
		String iss_encounter_id = request.getParameter("rep_EncounterId");
//		String iss_p_language_id = request.getParameter("rep_language_id");
		//String iss_sStyle=request.getParameter("rep_sStyle");

		
		String sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID = 'MRDGRCSM'";	
		
		reportParamNames = "p_encounter_id,p_facility_id,p_patient_id";
		reportParamValues = ""+iss_encounter_id+","+iss_facility_id+","+iss_patient_id+"";

			//htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+iss_sStyle+"'></link>");
			//htmlFor.append("</head><body class	='message'>");
			//htmlFor.append( "<script language	= 'JavaScript'>");
			htmlFor.append("  var dialogHeight	= '50vh';");
			htmlFor.append("  var dialogWidth	= '50vw';");
			htmlFor.append("  var dialogTop		= '58';");
			htmlFor.append("  var arguments		=	'';");
			htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&EncounterId="+iss_encounter_id+"&Patient_ID="+iss_patient_id+"';");
			htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
			htmlFor.append("retVal = await window.showModalDialog(getUrl,arguments,features);");
			//htmlFor.append(" </script>");


			out.println(htmlFor.toString());
			//out.println("</body></html>");

			//if(!mode.equals("report")){
				//out.println("<script> parent.parent.frames[1].onSuccess_DRG();</script>");
			//}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
}
public String restrictMultiuser(String class_encounter_id,String hdr_modified_dt,HttpServletRequest req){
		con = ConnectionManager.getConnection(req);
		String proceed	 = "00";//To Allow only Single User
	try{
		String HDR_MODIFY_DT_SQL	= "UPDATE MR_DIAG_PROC_RECODING_HDR SET MODIFIED_DATE=SYSDATE ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+x_facility_id+"' WHERE ENCOUNTER_ID='"+class_encounter_id+"' AND FACILITY_ID ='"+x_facility_id+"' AND MODIFIED_DATE=to_date('"+hdr_modified_dt+"','dd/mm/yyyy hh24:mi:sssss')";
		pstmt =con.prepareStatement(HDR_MODIFY_DT_SQL);
		int dummy_hdr =pstmt.executeUpdate();

		if(pstmt!=null){
			pstmt.close();
		}
		if(dummy_hdr>0){
			proceed = "00";//To Allow only Single User
			con.commit();
		}else{
			proceed	= "01";//To Allow only Single User
		}
	}catch(Exception ex){

		proceed="02";//Some exception was occured.
		ex.printStackTrace();
		try{
			con.rollback();
		}catch(Exception ee){}
	}finally{
			if(con != null){
				ConnectionManager.returnConnection(con,p);
		}
	}

	return proceed;
}
public int Recordsupportdiagnosis(int k,String term_set,String new_term_code,String occur_srl_no,String stage_no,int support_seq_no,String group_seq_no){
		int supp_res	=0;
		int srl_no		=0;
		try{
				if(supp_diag_map.containsKey(k)){
					String sql_srl_no ="select nvl(max(SRL_NO),0)+1 srl_no from MR_RECODE_SUPPORT_DIAG where encounter_id='"+encounter_id+"' and facility_id= '"+x_facility_id+"' ";
					pstmt		= con.prepareStatement(sql_srl_no );
					rs				= pstmt.executeQuery(); 
					while(rs.next()){
						srl_no	=rs.getInt("srl_no");
					}
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
					String map_assosicate_codes	= (String)supp_diag_map.get(k);
					StringTokenizer  str_ary= new StringTokenizer(map_assosicate_codes,"|@");
					while(str_ary.hasMoreTokens()){
						String	code_buf =str_ary.nextToken();
						StringTokenizer  str_ary_code= new StringTokenizer(code_buf,"$*");
						while(str_ary_code.hasMoreTokens()){
							String supp_code				=	str_ary_code.nextToken();
							String supp_code_set		=	str_ary_code.nextToken();
							String supp_code_desc		=	str_ary_code.nextToken();
							String sql_ins_new_suppdiag="insert into MR_RECODE_SUPPORT_DIAG (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO,TERM_SET_ID,TERM_CODE,SUPP_TERM_CODE,SUPP_TERM_SET_ID,TERM_CODE_SHORT_DESC, STAGE_NO, SUPPORT_SEQ_NO,SRL_NO,STATUS,GROUP_SEQ_NO,TRX_NO,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
							pstmt		= con.prepareStatement( sql_ins_new_suppdiag );
							 pstmt.setString(1,patient_id);
							 pstmt.setString(2,x_facility_id);
							 pstmt.setString(3,encounter_id);
							 pstmt.setString(4,occur_srl_no);
							 pstmt.setString(5,term_set);
							 pstmt.setString(6,new_term_code);
							 pstmt.setString(7,supp_code);
							 pstmt.setString(8,supp_code_set);
							 pstmt.setString(9,supp_code_desc);
							 pstmt.setString(10,stage_no);
							 pstmt.setInt(11,support_seq_no);
							 pstmt.setInt(12,srl_no);
							 pstmt.setString(13,"Y");
							 pstmt.setString(14,group_seq_no);
							 pstmt.setString(15,"");
							 pstmt.setString(16,addedById);
							 pstmt.setString(17,client_ip_address);
							 pstmt.setString(18,x_facility_id);
							 pstmt.setString(19,addedById);
							 pstmt.setString(20,client_ip_address);
							 pstmt.setString(21,x_facility_id);
							supp_res	= pstmt.executeUpdate(); 
							srl_no++;
						}
						 if(pstmt!=null)pstmt.close();
					}
				}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return supp_res;
}

public int UpdateTRXnoforSupprtdiagnosis(String term_code,String support_seq_no,String group_yn,String group_seq_no,int main_trx_no){
	int updt_sts=0;
	try{
			String ADDL_CRITERIA="";
			int count	=0;
			if(group_yn.equals("Y")){
				ADDL_CRITERIA	="GROUP_SEQ_NO='"+group_seq_no+"'";
			}else{
				ADDL_CRITERIA	="SUPPORT_SEQ_NO="+support_seq_no+"";
			}

			String COUNT_SQL="SELECT COUNT(*) COUNT FROM MR_RECODE_SUPPORT_DIAG WHERE TERM_CODE="+term_code+" AND  "+ADDL_CRITERIA+" AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+x_facility_id+"' ";
			pstmt		= con.prepareStatement(COUNT_SQL );
			rs				= pstmt.executeQuery(); 
			while(rs.next()){
				count	=rs.getInt("COUNT");
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

			if(count>0){
				String srl_no_data	="";
				String SRL_NO_SQL="SELECT SRL_NO  FROM MR_RECODE_SUPPORT_DIAG WHERE TERM_CODE="+term_code+" AND  "+ADDL_CRITERIA+" AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+x_facility_id+"' order by srl_no asc ";
				pstmt		= con.prepareStatement(SRL_NO_SQL );
				rs				= pstmt.executeQuery(); 
				while(rs.next()){
					srl_no_data	=srl_no_data+rs.getString("SRL_NO")+",";
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
					srl_no_data = srl_no_data.substring(0,srl_no_data.length()-1); 
					StringTokenizer supprt_srl_no = new StringTokenizer(srl_no_data,",");
					String supp_srl_no ="";
					String str_in_seq_no	= "";
					double db_int_seq_no	= 0.0;
				for(int kk=1;kk<=count;kk++){
					 supp_srl_no	= supprt_srl_no.nextToken();
					if(main_trx_no!=99999){
						 str_in_seq_no	= Integer.toString(main_trx_no)+"."+Integer.toString(kk);
						db_int_seq_no=Double.parseDouble(str_in_seq_no);
					}
					String UPDT_TRX_NO_SQL = "UPDATE MR_RECODE_SUPPORT_DIAG SET TRX_NO='"+main_trx_no+"',INT_SEQ_NO='"+db_int_seq_no+"',ADDED_BY_ID='"+addedById+"',ADDED_DATE=SYSDATE,ADDED_AT_WS_NO='"+client_ip_address+"',ADDED_FACILITY_ID='"+x_facility_id+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+x_facility_id+"' WHERE TERM_CODE="+term_code+" AND "+ADDL_CRITERIA+" AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+x_facility_id+"' AND STATUS='Y' AND SRL_NO='"+supp_srl_no+"'  ";
					pstmt		= con.prepareStatement(UPDT_TRX_NO_SQL );
					updt_sts	= pstmt.executeUpdate(); 
					if(pstmt!=null)pstmt.close();
				}
			}

	}catch(Exception ex){
		ex.printStackTrace();
		updt_sts=11;
	}
	return updt_sts;

}
public ArrayList getAllhdrstatus(String encounter_id,String facility_id,HttpServletRequest req){
	Connection conn=null;
	ArrayList hdr_sts_list = new ArrayList();
	try{
				conn = ConnectionManager.getConnection(req);
				String L1_hdr_sts	 ="";
				String L2_hdr_sts	 ="";
				String L3_hdr_sts	 ="";
				String curr_lvl		 ="";
				String hdr_modified_dte	="";
				String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+facility_id+"' AND ENCOUNTER_ID='"+encounter_id+"'";
				pstmt = conn.prepareStatement(sql_hdr_sts);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					L1_hdr_sts	= rs.getString("LEVEL1_STATUS");
					L2_hdr_sts	= rs.getString("LEVEL2_STATUS");
					L3_hdr_sts	= rs.getString("LEVEL3_STATUS");
					curr_lvl			= rs.getString("CURR_LEVEL");
					hdr_modified_dte	= rs.getString("MODIFIED_DATE");
					hdr_sts_list.add(L1_hdr_sts);
					hdr_sts_list.add(L2_hdr_sts);
					hdr_sts_list.add(L3_hdr_sts);
					hdr_sts_list.add(curr_lvl);
					hdr_sts_list.add(hdr_modified_dte);
				}
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
	}finally{
			if(conn != null){
				ConnectionManager.returnConnection(conn,p);
		}
	}
	return hdr_sts_list;  
}
/* In Below Method  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
public void Record_ChiefComplient(HttpServletRequest req,String complaint_id,String x_facility_id,String encounter_id,String diagprob_code,String termset_id,String occur_srl_no,String diagprob_short_desc, String patient_id,String status, Connection con) 
{ 
       //Connection con=null; //Commented for checkstyle
         try{
            //con = ConnectionManager.getConnection(req); //Commented for checkstyle by suji
             String n_code				= "";
			 boolean first_time			= true;
			 String chief_compl_code_list="";
			 int count					= 0;
			 String complaint			= "";
			 String comp_onset_date_time	= "";
			StringBuffer n_code_list	= new StringBuffer();
	        StringBuffer sbSql			= new StringBuffer();
			StringBuffer sbMsg			= new StringBuffer();
		    boolean	result				= true ;
			  sbSql.setLength(0);
		sbSql.append("select a.complaint_id complaint_id from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and occur_srl_no = ? ");
	                        if(!diagprob_code.equals("*OTH")){ 
								sbSql.append("and a.term_code = ? ");
							}else{
								sbSql.append("and a.term_code_short_desc = ? ");
							} 
						  pstmt = con.prepareStatement(sbSql.toString()); 
							
							pstmt.setString(1,x_facility_id);
							pstmt.setString(2,encounter_id);
							pstmt.setString(3,termset_id);
							pstmt.setString(4,occur_srl_no);  
							if(!diagprob_code.equals("*OTH")){ 
								pstmt.setString(5,diagprob_code);  
							}else{
								pstmt.setString(5,diagprob_short_desc); 
							}
					       rs = pstmt.executeQuery();
							 while(rs.next()){
								n_code = rs.getString(1); 
								if(first_time){
									
									chief_compl_code_list="'"+n_code+"',";
//									
								}else{
									
									chief_compl_code_list=chief_compl_code_list+"'"+n_code+"',";
								}
								first_time = false;
							}
						 if(chief_compl_code_list!=""){  
								chief_compl_code_list =chief_compl_code_list.substring(0,chief_compl_code_list.length()-1);
							}
							n_code_list.append("("+chief_compl_code_list+")") ;
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							sbSql.setLength(0); 
														
							if(chief_compl_code_list!=""){
									sbSql.append("delete from pr_diagnosis_compl_enc_dtl where ");
									sbSql.append(" facility_id=? and encounter_id=? and term_set_id=?");
									sbSql.append(" and occur_srl_no = ? ");
									if(!diagprob_code.equals("*OTH")){
										sbSql.append("and term_code = ? ");
									}else{
										sbSql.append("and term_code_short_desc = ? ");
									}
									sbSql.append(" and complaint_id in ");
									sbSql.append(n_code_list.toString()); 
		//							n_code_list=null;
									n_code_list.setLength(0);//Changed on 9/2/2010 for  Incident 23579
									chief_compl_code_list="";
									try{
										pstmt = con.prepareStatement(sbSql.toString());
										pstmt.setString(1,x_facility_id);
										pstmt.setString(2,encounter_id);
										pstmt.setString(3,termset_id);
										pstmt.setString(4,occur_srl_no);	
										if(!diagprob_code.equals("*OTH")){
											pstmt.setString(5,diagprob_code);
										}else{ 
											pstmt.setString(5,diagprob_short_desc);
										}
										count=0;
										count = pstmt.executeUpdate();
										 if(count>0){
									     con.commit(); 
								             }
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									}
									catch (Exception e){
										e.printStackTrace(); 
									}
							}
							
						     StringTokenizer complaintToken = new StringTokenizer(complaint_id, "$");
						  
							 
						while (complaintToken.hasMoreTokens()){
							complaint = complaintToken.nextToken();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							 sbSql.append("select to_char(onset_datetime,'dd/mm/yyyy HH24:MI') onset_date_time from ca_encntr_chief_complaint a where facility_id=? and encounter_id=? and complaint_id=?");
							 pstmt = con.prepareStatement( sbSql.toString() );
							 pstmt.setString( 1, x_facility_id) ;
							 pstmt.setString( 2, encounter_id) ;
							 pstmt.setString( 3, complaint) ;
							rs	= pstmt.executeQuery();
							if(rs.next() && rs!= null){ 
								comp_onset_date_time =checkForNull(rs.getString("onset_date_time"));
							}
							 if(rs != null) rs.close();
							 if(pstmt != null) pstmt.close();
							//if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
							sbSql.setLength(0);
							sbSql.append("insert into pr_diagnosis_compl_enc_dtl"); 
							sbSql.append("(facility_id,encounter_id,patient_id,");
							sbSql.append("term_set_id,term_code,term_code_short_desc,");
							sbSql.append("occur_srl_no,complaint_id,onset_date,staus,");
							sbSql.append("added_by_id,added_date,added_at_ws_no,added_facility_id,");
							sbSql.append("modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)");
							sbSql.append("values");
							sbSql.append("(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,");
							//sbSql.append("(?,?,?,?,?,?,?,?,?,?,?,sysdate,");
							sbSql.append("?,?,?,sysdate,?,?)");
							pstmt2 = con.prepareStatement( sbSql.toString() );
							pstmt2.setString	(1,  x_facility_id ) ;
							pstmt2.setString	(2,  encounter_id) ;
							pstmt2.setString	(3,  patient_id ) ;
							pstmt2.setString	(4,  termset_id ) ;
							pstmt2.setString	(5,  diagprob_code ) ;
							pstmt2.setString	(6,  diagprob_short_desc ) ;
							pstmt2.setString	(7,  occur_srl_no ) ;
							pstmt2.setString	(8,  complaint ) ;
							pstmt2.setString	(9,  comp_onset_date_time ) ;
							pstmt2.setString	(10, status ) ;
							pstmt2.setString (11, addedById);
							pstmt2.setString (12, client_ip_address);
							pstmt2.setString (13, x_facility_id);
							pstmt2.setString (14, addedById);
							pstmt2.setString (15, client_ip_address);
							pstmt2.setString (16, x_facility_id);
							count=0;
							
							try{
								count	= pstmt2.executeUpdate();
								if(pstmt2 != null) pstmt2.close();
								if(count>0){
									result = true; 
									con.commit();
								}else {
									result = false;
									sbMsg.append("Exception in inserting into pr_diagnosis_compl_enc_dtl : ");
								}
							}
							catch(SQLException sqle1){
								con.rollback();
								sbMsg.append("Exception in inserting into pr_diagnosis_compl_enc_dtl : " + sqle1.getMessage());
								result = false;
							}
						}
							
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(pstmt2 != null) pstmt2.close();
						
						
	           }catch(Exception ex){
			  ex.printStackTrace();
			  } 
			  //finally{
			  //if(con != null){
			  //ConnectionManager.returnConnection(con,p);
			  //}
			  //}  

      }

/* END HAS-CRF-300 */


	public static String checkForNull(String s){
        return s != null && !s.equals("null") ? s : "";
    }
	
	public static String checkForNull(String inputString, String defaultValue) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}
}
