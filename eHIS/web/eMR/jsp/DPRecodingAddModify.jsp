<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,org.json.simple.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE");%> 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
</head>
<script>
function imposeMaxLength(obj,maxlength){
	return (obj.value.length < maxlength);

}
</script>
<%	

/* In Below lines variables ared added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
 String	enc_stage_yn	="N";
 String inpatient_appl_yn = "N";// Added by KAMATCHI S for ML-MMOH-CRF-1581 
 String daycare_appl_yn = "N";//Added by KAMATCHI S for ML-MMOH-CRF-1581
 String isInpatientDaycare="N";//Added by KAMATCHI S for ML-MMOH-CRF-1581
 String diagstagecode	="";
 String diastgSel_1		=""; 
 String diastgSel_2		="";
 String diastgSel_3		="";
 String  chife_compln_yn="N";
 String complaint_Desc	= ""; 
 String complaint_id	="";
 boolean firstTime  = true;
 String _complaint_Desc ="";
 String _complaint_id 	=""; 
 String  notify_yn	   ="N";
 String email_yn	   ="";
 String default_note_type="";
 String notifiable_code="";
 String email_sel_yn	 ="";
 String deflt_note_type="";
 String diag_enc_level="N";
 String notifiable_form_mand_yn="N"; 
String specialty_code="";
String notifiable_frm_mand_gif="";
 /*HSA-CRF-300 end*/
 String stage_no = "";
 String confirm_appl         = ""; // added by mujafar for ML-MMOH-CRF-0878
 String temp_code = "";
 String dflt_termset = "";
 String Pat_id = "";
 String gender = "";
 String age = "";
 String dob = "";
 String spec_code = "";
 String EncounterId = "";
 String Patient_Class = "";
 String diag_class_appl_yn = "";
 String accuracy_appl_yn = "";
 String severity_appl_yn = "";
 String priority_appl_yn = "";
 String onset_type_appl_yn = "";
 String onset_date_appl_yn = "";
 String applicable_side_appl_yn = "";
 String status_appl_yn = "";
 String as_on_date_appl_yn = "";
 String remarks_appl_yn = "";
 String tcode = "";
 String setcode = "";
 String sel_code = "";
 String sel_code1 = "";
 String dflt_values = "";
 String diag_class_code = "";
 String curr_accuracy_code = "";
 String curr_severity = "";
 String curr_priority = "";
 String curr_onset_type = "";
 String curr_onset_date = "";
 String status = "";
 String status_date = "";
 String applicable_side = "";
 String curr_remarks = "";
 String caused_death = "";
 String occur_srl_no = "";
 String recode_status = "";

 String sevr_L_select = "";
 String sevr_D_select = "";
 String sevr_S_select = "";
 String sevr_E_select = "";
 String type_A_select = "";
 String type_C_select = "";
 String type_N_select = "";
 String stus_A_select = "";
 String stus_R_select = "";
 String stus_X_select = "";
 String stus_E_select = "";
 String applicable_l = "";
 String applicable_r = "";
 String applicable_b = "";
 String applicable_n = "";
 String orig_termset = "";
 String orig_termcode = "";
 String l1_termCode = "";
 //String cnt_flag = "";
String currentdateTime = "";
String currentdate = "";
String currentTime = "";
String procedure_yn = "";
String newCode_yn = "";
String newCode_st = "";
String diag_code_st = "";
String chk_yn = "";
String sel_srl_no="";
String sel_status="";
String sel_satus_vals="";
String sel_stages_vals="";
String sel_term_code="";
String sel_grp_vals="";
String sel_term_set="";
String diagnosis_by_long_desc_yn="N";//Maheshwaran K added for HSA-CRF-0234

String action="";
String DB_Recode_Stages="";///For Insersion OF Recoding Record Greater level  
String DB_Recode_Status="";///For Insersion OF Recoding Record Greater level  
String DB_Recode_Grpvals="";///For Insersion OF Recoding Record Greater level  
String prin_diag="";
String mode="";
String modify_temp_code="";
String modify_diag_val="";
String modify_diag_long_desc="";
String modify_proc_long_desc="";
String modify_proc_val="";
String fields_dis="";
String short_desc						="";
//String modify_term_code="";
String modify_proc_code			="";
String rmrk_disabl						= "";
boolean show_code_xtn			=false;
String code_extn_dtl					="";
String laterality_ind					="";//Added On 12/12/2009 For SRR-CRF-303.1
String proc_srt_dt_time			="";//Added On 12/12/2009 For SRR-CRF-303.1
String proc_end_dt_time			="";//Added On 12/12/2009 For SRR-CRF-303.1
String sel_mod_id						="";
String sel_cont_mod_id				="";
String sel_cod_xtn					="";
//String sel_acess_num="";
String sel_cod_xtn_dtl				="";
String sel_laterality_ind				=""; //Added On 12/12/2009 for SRR-CRF-303.1
String sel_proc_srt_dt_time		=""; //Added On 12/14/2009 for SRR-CRF-303.1
String sel_proc_end_dt_time		=""; //Added On 12/14/2009 for SRR-CRF-303.1
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");//Added On 7/13/2009
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");//Added On 7/13/2009
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/13/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/13/2009
String p_proc_filter	= "";//Added On 7/13/2009
String hideExtn			= "";//Added On 7/13/2009
String disabled			= "";//Added On 7/13/2009
String OT_selcted		= "";//Added On 7/13/2009
//String Nonot_disabled	= "";//Added On 7/13/2009
String Nonot_selected		= "";//Added On 7/13/2009
String contr_mod_id			="";
String sel_mod_id_dmy		="";
int ot_count						=0;
int nonot_count				=0;
String Both						="N";
String proc_type_val		="";
String drg_calculation_yn	= "";
String free_text_yn			= "";
String mr_param_proc_type		=	"";
String exclude_orig_code			=	"";
String disp_in							=	"";
String code_xtn_appl_yn			=	"";
String laterality_appl_yn			=	"";
String proc_remarks_appl_yn	=	"";
String pat_visit_dt_time			=	""; // Added on 12/11/2009
String pat_disch_dt_time			=	""; // Added on 12/11/2009
String proc_status_appl_yn		=	""; //Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
String dagger_independent_yn	=	"";
String modify_term_set				=	"";
String long_desc						=	"";
String display_long_desc			=	"none";

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false; 
Boolean isEncounterStage = false;//Added by KAMATCHI S for ML-MMOH-CRF-1581
String tdesc = "";
String term_code_desc = "";
String sel_desc = "";
String sel_desc_trim = "";
String rec_doc_desc = "";
String doc_desc_visibile_yn = "";

String sel_mod_id_temp = "";
String sel_cod_xtn_temp = "";
String free_text_temp = "";
String term_sht_desc  = checkForNull(request.getParameter("term_sht_desc")); // added by mujafar for ML-MMOH-CRF-1281 
String isMultiDescAppl = "";
String includevisibility="visibility:hidden"; 

int i			= 0;
int srl_no  = 0;
int temp	= 0;

Connection conn=null;
try{

 specialty_code							= request.getParameter("specialty_code");// HSA-CRF-300
 stage_no							= request.getParameter("stage_no");
 confirm_appl         = checkForNull(request.getParameter("confirm_appl")); // added by mujafar for ML-MMOH-CRF-0878
 procedure_yn					= checkForNull(request.getParameter("procedure_yn"));
 temp_code						= checkForNull(request.getParameter("temp_code"));
 dflt_termset						= request.getParameter("dflt_termset");
 Pat_id								= request.getParameter("Pat_id");
 gender								= request.getParameter("gender");
 age									= request.getParameter("age");
 dob									= request.getParameter("dob");
 spec_code						= request.getParameter("spec_code");
 EncounterId						= request.getParameter("EncounterId");
 Patient_Class					= request.getParameter("Patient_Class");
 caused_death					= request.getParameter("caused_death");
 recode_status					= request.getParameter("recode_status");
 newCode_yn					= checkForNull(request.getParameter("newCode_yn"));
 l1_termCode					= request.getParameter("l1_termCode");
 chk_yn							= request.getParameter("chk_yn");
 DB_Recode_Stages			= request.getParameter("DB_Recode_Stages");///For Insersion OF Recoding Record Greater level 
 DB_Recode_Status			= request.getParameter("DB_Recode_Status");///For Insersion OF Recoding Record Greater level 
 DB_Recode_Grpvals		= request.getParameter("DB_Recode_Grpvals");///For Insersion OF Recoding Record Greater level 
 allow_recode_diag_yn		= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
 allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
 prin_diag							= checkForNull(request.getParameter("prin_diag"));
 mode								= checkForNull(request.getParameter("mode"));
 modify_temp_code			= checkForNull(request.getParameter("modify_temp_code"));
 modify_proc_code			= checkForNull(request.getParameter("modify_proc_code"));
 code_extn_dtl					= checkForNull(request.getParameter("code_extn_dtl"));
 laterality_ind					= checkForNull(request.getParameter("laterality_ind"));//Added For 12/12/2009 For SRR-CRF-303.1
// proc_srt_dt_time				= checkForNull(request.getParameter("proc_srt_dt_time"));//Added For 12/12/2009 For SRR-CRF-303.1
// proc_end_dt_time			= checkForNull(request.getParameter("proc_end_dt_time"));//Added For 12/12/2009 For SRR-CRF-303.1
 contr_mod_id					= checkForNull(request.getParameter("contr_mod_id"));
 /*F.Y.I:
	1.There will be a  Value for  pat_visit_dt_time only in case of Procedure (Newcode/Recode)
*/
 pat_visit_dt_time= checkForNull(request.getParameter("pat_visit_dt_time")); //Added On 12/11/2009 For SRR-CRF-303.1
 pat_disch_dt_time= checkForNull(request.getParameter("pat_disch_dt_time")); //Added On 12/11/2009 For SRR-CRF-303.1
 dagger_independent_yn= checkForNull(request.getParameter("dagger_independent_yn"),"N"); //Added On 12/11/2009 For SRR-CRF-303.2
 isMultiDescAppl = checkForNull(request.getParameter("isMultiDescAppl")); // added by mujafar for ML-MMOH-CRF-1281 
 
 if(chk_yn == null)
 chk_yn="N";
 conn = ConnectionManager.getConnection(request);	
 PreparedStatement pstmt		= null;
 ResultSet rs				= null;
 ResultSet rset				= null;
 //Statement stmt		= null;
 
 JSONObject DescriptionJsonObj		= new JSONObject(); // added by mujafar for ML-MMOH-CRF-1281 
 JSONArray DescriptionJsonArray = new JSONArray();
 JSONObject termCodeCountObj = new JSONObject();
  int descCount=0;


 doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269

 isEncounterStage =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TERM_RECODE_DIAG"); //Added by KAMATCHI  S for ML-MMOH-CRF-1581

if(newCode_yn.equals("Y")){
	newCode_st="disabled";
	action="New";
}else if(mode.equals("Modify")){
	temp_code	=	modify_temp_code;
	action="DiagModify";
}else if(mode.equals("ProcModify")){
	temp_code	=	modify_proc_code;
	rmrk_disabl="disabled";
	show_code_xtn=true;
	action="ProcModify";
}else{
	newCode_st="";
	action="Recode";
}
if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
	p_proc_filter ="B";
//	hideExtn="hidden";
	disabled="";
//	Nonot_disabled="";
	OT_selcted="";
	Nonot_selected="";
}else if(allow_ot_proc_recode_yn.equals("Y")){
	p_proc_filter	="O";
//	hideExtn="visible";
	disabled	="disabled";
	OT_selcted	="selected";
//	Nonot_disabled	="disabled";

}else if(allow_non_ot_proc_recode_yn.equals("Y")){
	p_proc_filter	="N";
//	hideExtn="hidden";
//	OT_disabled	="";
	OT_selcted	="";
	disabled	="disabled";
	Nonot_selected	="selected";
}

try{
	//String sql2="SELECT DIAG_CLASS_APPL_YN,ACCURACY_APPL_YN,SEVERITY_APPL_YN,PRIORITY_APPL_YN,ONSET_TYPE_APPL_YN,ONSET_DATE_APPL_YN,APPLICABLE_SIDE_APPL_YN,STATUS_APPL_YN,AS_ON_DATE_APPL_YN ,REMARKS_APPL_YN,LATERALITY_APPL_YN,CODE_EXTENSION_APPL_YN,PROC_REMARKS_APPL_YN,PROC_STATUS_APPL_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+stage_no+" AND ADDED_FACILITY_ID='"+p_facility_id+"'";
	/* In Below lines querie modified by venkatesh.s against HAS-CRF-300*/
	/* Below query is modified for ML-MMOH-CRF-1581 by KAMATCHI S */
	String sql2="SELECT DIAG_CLASS_APPL_YN,ACCURACY_APPL_YN,SEVERITY_APPL_YN,PRIORITY_APPL_YN,ONSET_TYPE_APPL_YN,ONSET_DATE_APPL_YN,APPLICABLE_SIDE_APPL_YN,STATUS_APPL_YN,AS_ON_DATE_APPL_YN ,REMARKS_APPL_YN,LATERALITY_APPL_YN,CODE_EXTENSION_APPL_YN,PROC_REMARKS_APPL_YN,PROC_STATUS_APPL_YN,ENC_STAGE_YN,CHIFE_COMP_YN,NOTIFIY_YN,INPATIENT_APPL_YN,DAYCARE_APPL_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+stage_no+" ";
	pstmt = conn.prepareStatement(sql2);
	rs = pstmt.executeQuery();	

	while(rs.next()) {
		  diag_class_appl_yn		= rs.getString("DIAG_CLASS_APPL_YN");
		  accuracy_appl_yn		= rs.getString("ACCURACY_APPL_YN");
		  severity_appl_yn		= rs.getString("SEVERITY_APPL_YN");
		  priority_appl_yn			= rs.getString("PRIORITY_APPL_YN");
  		  onset_date_appl_yn	= rs.getString("ONSET_DATE_APPL_YN");
  		  as_on_date_appl_yn	= rs.getString("AS_ON_DATE_APPL_YN");
		  onset_type_appl_yn	= rs.getString("ONSET_TYPE_APPL_YN");
		  applicable_side_appl_yn		= rs.getString("APPLICABLE_SIDE_APPL_YN");
		  status_appl_yn			= rs.getString("STATUS_APPL_YN");
		  remarks_appl_yn		= rs.getString("REMARKS_APPL_YN");
		  laterality_appl_yn		= rs.getString("LATERALITY_APPL_YN");
		  code_xtn_appl_yn		= rs.getString("CODE_EXTENSION_APPL_YN");
		  proc_remarks_appl_yn	= rs.getString("PROC_REMARKS_APPL_YN");
		  proc_status_appl_yn		= rs.getString("PROC_STATUS_APPL_YN"); //Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
		  enc_stage_yn		    = rs.getString("ENC_STAGE_YN");/*HSA-CRF-300*/
		  chife_compln_yn		= rs.getString("CHIFE_COMP_YN"); /*HSA-CRF-300*/
		  notify_yn		        = rs.getString("NOTIFIY_YN");/*HSA-CRF-300*/
		  inpatient_appl_yn		= rs.getString("INPATIENT_APPL_YN");//Added by KAMATCHI S for ML-MMOH-CRF-1581
		  daycare_appl_yn       = rs.getString("DAYCARE_APPL_YN");//Added by KAMATCHI S for ML-MMOH-CRF-1581
	}

		//Condition Added by KAMATCHI S for ML-MMOH-CRF-1581
		if(isEncounterStage && enc_stage_yn.equals("Y") && ((inpatient_appl_yn.equals("Y") && Patient_Class.equals("IP")) ||  (daycare_appl_yn.equals("Y") && Patient_Class.equals("DC")) ))
		{
			isInpatientDaycare="Y";
		}
	
	String sno = "";
	String testno = "";
	//out.println("<script>alert(\"chk_yn :"+chk_yn+"\");</script>");
/*if(mode.equals("Modify")){
	temp_code	=	modify_temp_code;
}else if(mode.equals("ProcModify")){
	temp_code	=	modify_proc_code;
	rmrk_disabl="disabled";
	show_code_xtn=true; 
}*/
//Maheshwaran K added diagnosis_by_long_desc_yn in the query for HSA-CRF-0234

/* In Below query NOTIFIABLE_FORM_MAND_YN and DIAG_ENC_LEVEL  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 */
String sql_param="SELECT diagnosis_by_long_desc_yn,DRG_CALCULATION_YN,DF_NEW_PROC_TYPE_FR_RECODE,EXCLUDE_ORIG_CODE,NOTIFIABLE_FORM_MAND_YN,DIAG_ENC_LEVEL,(select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual) sdate FROM MR_PARAMETER"; 
    
	pstmt = conn.prepareStatement(sql_param);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		drg_calculation_yn		= checkForNull(rs.getString("DRG_CALCULATION_YN"));
		mr_param_proc_type	= checkForNull(rs.getString("DF_NEW_PROC_TYPE_FR_RECODE"));
		exclude_orig_code		= checkForNull(rs.getString("EXCLUDE_ORIG_CODE"),"N");
		diagnosis_by_long_desc_yn		= checkForNull(rs.getString("diagnosis_by_long_desc_yn"),"N");

		currentdateTime	= rs.getString("sdate");
		currentdate		= currentdateTime.substring(0,10);
		currentdate		=DateUtils.convertDate(currentdate,"DMY" ,"en",locale);
		currentTime		= currentdateTime.substring(11);
		
		notifiable_form_mand_yn			=checkForNull(rs.getString("NOTIFIABLE_FORM_MAND_YN")); //HAS-CRF-300
		diag_enc_level					=checkForNull(rs.getString("DIAG_ENC_LEVEL"));//HAS-CRF-300
	
		
	}

	if(newCode_yn.equals(""))
	{
	
		if(!chk_yn.equals("")){
			StringTokenizer st=new StringTokenizer(chk_yn,",");
			int test=st.countTokens();
			String t1="";

			for(int r2=0;r2<test;r2++){
				t1=st.nextToken();
				//out.println("<script>alert(\"t1 :"+t1+"\");</script>");

				 StringTokenizer st8=new StringTokenizer(temp_code,"~");
				 temp=st8.countTokens();

				for(int u2=0;u2<temp;u2++){
					String st2=st8.nextToken();
					StringTokenizer st1=new StringTokenizer(st2,"$");

					testno=st1.nextToken().trim();
						//out.println("<script>alert(\"testno :"+testno+"\");</script>");

					tcode=st1.nextToken().trim();

					sel_term_code=tcode+","+sel_term_code;

					setcode=st1.nextToken().trim();
					sel_term_set=setcode+","+sel_term_set;
					sel_status=st1.nextToken().trim();
					sel_srl_no=st1.nextToken().trim()+","+sel_srl_no;
					sel_satus_vals=st1.nextToken()+","+sel_satus_vals;
					sel_stages_vals=st1.nextToken()+","+sel_stages_vals;
					sel_grp_vals=st1.nextToken().trim()+","+sel_grp_vals;
					sel_mod_id_temp=st1.nextToken().trim()+","+sel_mod_id_temp;
					sel_cod_xtn_temp=st1.nextToken().trim()+","+sel_cod_xtn_temp;
					free_text_temp=st1.nextToken().trim()+","+free_text_temp;

					/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
					tdesc=st1.nextToken().trim();
					tdesc=java.net.URLDecoder.decode(tdesc);
					term_code_desc=tdesc+","+term_code_desc;
					/*End ML-MMOH-CRF-1269*/

					if(!t1.equals(testno))	{
						//out.println("<script>alert(\"here :"+testno+"\");</script>");
						if(procedure_yn.equals("Y")){
							sno = st1.nextToken().trim();
							st1.nextToken().trim();
							sel_cont_mod_id	=st1.nextToken().trim();
							sel_mod_id=sel_cont_mod_id+","+sel_mod_id;
							//Changed by Kamatchi S
							sel_cod_xtn=tdesc+","+sel_cod_xtn;
							st1.nextToken().trim();
//							sel_acess_num=st1.nextToken().trim()+","+sel_acess_num;
							sel_cod_xtn_dtl	= st1.nextToken().trim();
							sel_laterality_ind	= st1.nextToken().trim();
							sel_proc_srt_dt_time	= st1.nextToken().trim();
							sel_proc_end_dt_time	= st1.nextToken().trim();
						}

				
						if(procedure_yn.equals("Y")){
							if(u2 == 0)	{
								sel_code = tcode.trim()+","+setcode+","+sno;
								sel_code1 = tcode.trim();
								dflt_values="Y";
							}else{
								sel_code = sel_code+","+tcode.trim()+","+setcode+","+sno;
								sel_code1 = sel_code1+","+tcode.trim();
								dflt_values="N";
							}


						}else{

							if(u2 == 0){
								sel_code = tcode.trim()+","+setcode;
								sel_code1 = tcode.trim();
								sel_desc = tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
								dflt_values="Y";
							}else{
								sel_code = sel_code+","+tcode.trim()+","+setcode;
								sel_code1 = sel_code1+","+tcode.trim();
								sel_desc = sel_desc+","+tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
								dflt_values="N";
							}
						}
					}
				}

			}
		}else{

			StringTokenizer st8=new StringTokenizer(temp_code,"~");
			 temp=st8.countTokens();


			for(int u2=0;u2<temp;u2++){
				String st2=st8.nextToken();
				StringTokenizer st1=new StringTokenizer(st2,"$");

				testno=st1.nextToken().trim();

				tcode=st1.nextToken().trim();

				setcode=st1.nextToken().trim();
				
				sel_term_code=tcode+","+sel_term_code;
				sel_term_set=setcode+","+sel_term_set;

					sel_status=st1.nextToken().trim();
					sel_srl_no=st1.nextToken().trim()+","+sel_srl_no;
					sel_satus_vals=st1.nextToken()+","+sel_satus_vals;
					sel_stages_vals=st1.nextToken()+","+sel_stages_vals;
					sel_grp_vals=st1.nextToken().trim()+","+sel_grp_vals;
					sel_mod_id_temp=st1.nextToken().trim()+","+sel_mod_id_temp;
					sel_cod_xtn_temp=st1.nextToken().trim()+","+sel_cod_xtn_temp;
					free_text_temp=st1.nextToken().trim()+","+free_text_temp;

					/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
					tdesc=st1.nextToken().trim();
					tdesc=java.net.URLDecoder.decode(tdesc);
					term_code_desc=tdesc+","+term_code_desc;
					/*End ML-MMOH-CRF-1269*/

				//if(!t1.equals(testno))
				//{
				if(procedure_yn.equals("Y")){
					sno = st1.nextToken().trim();
					st1.nextToken().trim();
					sel_cont_mod_id	=st1.nextToken().trim();
					sel_mod_id=sel_cont_mod_id+","+sel_mod_id;
					//Changed by Kamatchi S
					sel_cod_xtn=tdesc+","+sel_cod_xtn;
					st1.nextToken().trim();
//					sel_acess_num=st1.nextToken().trim()+","+sel_acess_num;
					sel_cod_xtn_dtl=st1.nextToken().trim();
					sel_laterality_ind=st1.nextToken().trim();//Added On 12/12/2009 For SRR-CRF-303.1
					sel_proc_srt_dt_time	= st1.nextToken().trim();//Added On 12/14/2009 For SRR-CRF-303.1
					sel_proc_end_dt_time	= st1.nextToken().trim();//Added On 12/14/2009 For SRR-CRF-303.1

					sel_mod_id_dmy=sel_mod_id;

				}
				if(procedure_yn.equals("Y")){
					if(u2 == 0)	{
						sel_code = tcode.trim()+","+setcode+","+sno;
						sel_code1 = tcode.trim();
						dflt_values="Y";
					}else{
						sel_code = sel_code+","+tcode.trim()+","+setcode+","+sno;
						sel_code1 = sel_code1+","+tcode.trim();
						dflt_values="N";
					}


				}else{

					if(u2 == 0){
						sel_code = tcode.trim()+","+setcode;
						sel_code1 = tcode.trim();
						sel_desc = tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
						dflt_values="Y";
					}else{
						sel_code = sel_code+","+tcode.trim()+","+setcode;
						sel_code1 = sel_code1+","+tcode.trim();
						sel_desc = sel_desc+","+tdesc.trim();//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
						dflt_values="N";
					}
				}
			}
		}	

		if(temp > 1)
			newCode_st="disabled";
		else
			newCode_st="";

	if(sel_code.equals(""))
	{
		%>
		<script>
		parent.RecodeScreen.rows="47%,47%,5%,0%";
		</script>

	<%}
}
		/*if(!procedure_yn.equals("Y")){
			stmt = conn.createStatement();
			String DEATH_DATE_SQL = "SELECT TO_CHAR(DECEASED_DATE_TIME,'DD/MM/YYYY HH24:MI')DECEASED_DATE_TIME FROM PR_ENCOUNTER WHERE ENCOUNTER_ID='"+EncounterId+"' AND FACILITY_ID='"+p_facility_id+"' " ;
			rset	  = stmt.executeQuery(DEATH_DATE_SQL);
			if (rset.next()){
				deceased_date_time	= checkForNull(rset.getString("DECEASED_DATE_TIME"));
			}
		}
		if ( rset != null ) rset.close();*/

		/*stmt = conn.createStatement();
		String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
		rset	  = stmt.executeQuery(getDate);
		if (rset.next())
		{
			currentdateTime	= rset.getString("sdate");
			currentdate		= currentdateTime.substring(0,10);
			currentdate		=DateUtils.convertDate(currentdate,"DMY" ,"en",locale);
			currentTime		= currentdateTime.substring(11);
		}
		if ( rset != null ) rset.close();
		*/
		if(!newCode_yn.equals("Y")){
			StringTokenizer sel_mod_id_dmy_st= new StringTokenizer(sel_mod_id_dmy,",");
			while(sel_mod_id_dmy_st.hasMoreTokens()){
				if(sel_mod_id_dmy_st.nextToken().equals("OT")){
					ot_count++;
					proc_type_val="OT";
				}else{
					nonot_count++;
//					proc_type_val="";
					Both	 ="Y";
				}
			}

			StringTokenizer sel_cd_st= new StringTokenizer(sel_term_code,",");
			StringTokenizer sel_termset_st= new StringTokenizer(sel_term_set,",");
			StringTokenizer sel_srlno_st= new StringTokenizer(sel_srl_no,",");



			String def_srl_no=sel_srlno_st.nextToken();
			String def_cd=sel_cd_st.nextToken();
			String def_set=sel_termset_st.nextToken();
			modify_term_set=def_set;
//			String pat_visit_dt_time			= "";
//			String pat_discharge_dt_time	= "";
//			String def_set_mod_id=sel_mod_id_dmy_st.nextToken();
			if(procedure_yn.equals("Y")){

				/*String VISIT_DISCHARGE_SQL="SELECT TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI')VISIT_ADM_DATE_TIME,TO_CHAR(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI')DISCHARGE_DATE_TIME FROM PR_ENCOUNTER WHERE  FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"' AND PATIENT_ID='"+Pat_id+"' ";
				pstmt = conn.prepareStatement(VISIT_DISCHARGE_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					pat_visit_dt_time= checkForNull(rs.getString("VISIT_ADM_DATE_TIME"));
					pat_discharge_dt_time= checkForNull(rs.getString("DISCHARGE_DATE_TIME"));
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();*/

				String sql3_for_proc="SELECT A.remarks,B.SHORT_DESC,B.LONG_DESC FROM MR_PROCEDURE_RECODING_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and  A.proc_code='"+def_cd+"' and A.PROC_CODE_SCHEME ='"+def_set+"' and A.STAGE_SRL_NO='"+def_srl_no+"' AND A.PROC_CODE=B.TERM_CODE AND  A.PROC_CODE_SCHEME=B.TERM_SET_ID";
				pstmt = conn.prepareStatement(sql3_for_proc);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					  curr_remarks	= checkForNull(rs.getString("remarks"));
					  short_desc		= checkForNull(rs.getString("SHORT_DESC"));
					  long_desc		= checkForNull(rs.getString("LONG_DESC"));
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();

				 if(mode.equals("ProcModify")){
					fields_dis="disabled";
					modify_proc_val=def_cd;
					modify_proc_long_desc=long_desc;
				}else{
					short_desc="";
					fields_dis="";
					modify_proc_val="";
					modify_proc_long_desc="";
			}
		}else{  
		           /* In Below lines query  added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
				String sql3_for_diag="SELECT A.DIAG_CLASS_CODE,A.ACCURACY_CODE,A.SEVERITY,A.PRIORITY,A.ONSET_TYPE,to_char(A.ONSET_DATE,'dd/mm/yyyy HH24:mi') ONSET_DATE ,A.APPLICABLE_SIDE,A.STATUS,to_char(A.AS_ON_DATE,'dd/mm/yyyy') AS_ON_DATE,A.REMARKS,B.SHORT_DESC,B.LONG_DESC,B.FREE_TEXT_YN,A.TERM_CODE_SHORT_DESC,A.OCCUR_SRL_NO, A.ENC_STAGE ,A.NOTIFICATION_CODE,A.DOCTORS_DESCRIPTION FROM MR_DIAGNOSIS_RECODING_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and  A.term_code='"+def_cd+"' and  A.term_set_id='"+def_set+"' and A.STAGE_SRL_NO='"+def_srl_no+"' AND A.TERM_CODE=B.TERM_CODE AND A.TERM_SET_ID=B.TERM_SET_ID ";
				/*DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
				
			   //out.println("<script>alert(\"sql3.))...:"+sql3+"\");</script>");
                    
					
				pstmt = conn.prepareStatement(sql3_for_diag);
				rs = pstmt.executeQuery();	
				

				while(rs.next()){
					  //orig_termset = checkForNull(rs.getString("PROC_CODE_SCHEME"));
					 // orig_termcode = checkForNull(rs.getString("PROC_CODE"));
					  diag_class_code			= checkForNull(rs.getString("diag_class_code"));
					  curr_accuracy_code		= checkForNull(rs.getString("accuracy_code"));
					  curr_severity				= checkForNull(rs.getString("severity"));
					  curr_priority				= checkForNull(rs.getString("priority"));
					  curr_onset_type			= checkForNull(rs.getString("onset_type"));
					  curr_onset_date			= checkForNull(rs.getString("onset_date"));
						curr_onset_date			=DateUtils.convertDate(curr_onset_date,"DMYHM","en",locale); 
					  applicable_side			= checkForNull(rs.getString("applicable_side"));
					  status					= checkForNull(rs.getString("status"));
					  status_date				= checkForNull(rs.getString("AS_ON_DATE"));
					  status_date				=	DateUtils.convertDate(status_date,"DMY","en",locale); 
					  curr_remarks				= checkForNull(rs.getString("remarks"));
					  free_text_yn				= checkForNull(rs.getString("FREE_TEXT_YN"));
					  if(free_text_yn.equals("Y")){
						  short_desc			= checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
					  }else{
						  short_desc			= checkForNull(rs.getString("SHORT_DESC"));
					  }
					  
				
				term_sht_desc		= checkForNull(rs.getString("TERM_CODE_SHORT_DESC")); //  added by mujafar for ML-MMOH-CRF-1281
			 
					  occur_srl_no				= checkForNull(rs.getString("OCCUR_SRL_NO"));
					  long_desc					= checkForNull(rs.getString("LONG_DESC"));
				           diagstagecode		= checkForNull(rs.getString("ENC_STAGE"));//HAS-CRF-300
					   notifiable_code			= checkForNull(rs.getString("NOTIFICATION_CODE"));//HAS-CRF-300

					   rec_doc_desc				= checkForNull(rs.getString("DOCTORS_DESCRIPTION"));//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
				      
				}
				
			/*For Modifing The Diag.Classification Code Disabling the Fields And Painting the Desc  as Follows */
			if(mode.equals("Modify")){
				fields_dis="disabled";
				modify_diag_val=def_cd;
//				modify_diag_long_desc=long_desc;
				modify_diag_long_desc=def_cd+","+def_set;
			}else{
				short_desc="";
				fields_dis="";
				modify_diag_val="";
				modify_diag_long_desc="";
			}
	
if(isMultiDescAppl.equals("true") && mode.equals("Modify") && procedure_yn.equals("N") ) //  added by mujafar for ML-MMOH-CRF-1281
 {
 
		
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(conn,def_set,tcode);
		DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		

		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}
	
	if(descCount==1)
		includevisibility="visibility:visible";
}
			
		}
		
	}
} catch(Exception e)
{
	//out.println("here"+e.toString());
	e.printStackTrace();
}
		if(curr_severity.equals("L"))
			sevr_L_select = "selected";
		else if(curr_severity.equals("D"))
			sevr_D_select = "selected";
		else if(curr_severity.equals("S"))
			sevr_S_select = "selected";
		else if(curr_severity.equals("E"))
			sevr_E_select = "selected";


		if(curr_onset_type.equals("A"))
			type_A_select = "selected";
		else if(curr_onset_type.equals("C"))
			type_C_select = "selected";
		else 
			type_N_select = "selected";


		if(status.equals("A"))
			stus_A_select = "selected";
		else if(status.equals("R"))
			stus_R_select = "selected";
		else if(status.equals("X"))
			stus_X_select = "selected";
		else if(status.equals("E"))
			stus_E_select = "selected";

		if(applicable_side.equals("L"))
			applicable_l = "selected";
		else if(applicable_side.equals("R"))
			applicable_r = "selected";
		else if(applicable_side.equals("B"))
			applicable_b = "selected";
		else if(applicable_side.equals("N"))
			applicable_n = "selected";

			if(occur_srl_no.equals(""))
				occur_srl_no="1";
				
				

/*F.Y.I:For SRR-CRF-303.1,Procedure Type ,Code extention and Laterality was introduced.*/
	/*----For New Procedure---*/
	String disp_mand			 =	"";
	String disp_recode		 =	"";
	String ot_selected			 =	"";
	String not_selected		 =	"";
	String opt_selected		 =	"";
	String open_dt_times	 =	"style='visibility:hidden;display:none'";
	String lbl_in_time			 =	"";
	String lbl_out_time		 =	"";
	String open_chk_mand	 =	"hidden";
	String proc_type_hid_yn =	"N";
if(newCode_yn.equals("Y")){
	if(mr_param_proc_type.equals("NA")){
			proc_type_hid_yn		= "Y";
			hideExtn		 ="";
			opt_selected ="selected";
			disp_mand	 ="visible";
			open_dt_times	 =	"style='visibility:hidden;display:none'";
	}else{
			proc_type_hid_yn = "N";
			hideExtn		="disabled";
			disp_mand	="hidden";
		if(mr_param_proc_type.equals("OT")){
			ot_selected		="selected";
			proc_type_val	="OT";
			open_dt_times ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
			open_chk_mand	= "visible";

		}else if(mr_param_proc_type.equals("NO")){
			not_selected		 ="selected";
			open_dt_times  ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");

		}
	}
}else{
		if(ot_count>1){
			code_extn_dtl			="";
			laterality_ind	 			="";
			proc_srt_dt_time	 	= "";
			proc_end_dt_time	= "";
			ot_selected		="selected";
			open_dt_times	="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
			open_chk_mand	= "visible";
		}else if(nonot_count>1){
			code_extn_dtl			="";
			laterality_ind	 			="";
			proc_srt_dt_time	 	= "";
			proc_end_dt_time	= "";
			not_selected		 ="selected";
			open_dt_times  ="style='visibility:visible;display:inline'";
			lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
			lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
		}else{
				if(ot_count==1){
					ot_selected	    ="selected";
					open_dt_times ="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
					open_chk_mand	= "visible";
				}else if(nonot_count==1){
					not_selected		="selected";
					open_dt_times	="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
				}
				if(sel_cont_mod_id.equals("XT")){
					contr_mod_id	="";
				}else{
					contr_mod_id=sel_cont_mod_id;
				}
				if(sel_cod_xtn_dtl.equals("01")){
					code_extn_dtl	="";
				}else{
					code_extn_dtl=sel_cod_xtn_dtl;
				}
				if(sel_laterality_ind.equals("01")){
					laterality_ind	="";
				}else{
					laterality_ind=sel_laterality_ind;
				}
				if(sel_proc_srt_dt_time.equals("01")){
					proc_srt_dt_time	="";
				}else{
					proc_srt_dt_time=sel_proc_srt_dt_time;
				}
				if(sel_proc_end_dt_time.equals("01")){
					proc_end_dt_time	="";
				}else{
					proc_end_dt_time=sel_proc_end_dt_time;
				}

				if(sel_cont_mod_id.equals("OT")){
					ot_selected		="selected";
					open_dt_times	="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkindatetime.label","mr_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.checkoutdatetime.label","mr_labels");
					open_chk_mand	= "visible";
				}else{
					not_selected		 ="selected";
					open_dt_times  ="style='visibility:visible;display:inline'";
					lbl_in_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels");
					lbl_out_time		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddatetime.label","common_labels");
					disp_mand		 = "visible";
				}
		}
		if(Both.equals("Y")){
			hideExtn	="disabled";
		if(ot_count>0 && nonot_count>0){
			proc_type_hid_yn  ="Y";
			disp_in="Y";
			disp_mand		 ="visible";
			open_dt_times	 =	"style='visibility:hidden;display:none'";
			opt_selected		  ="selected";
			ot_selected		  ="";
			not_selected		  ="";
			hideExtn			  ="";
			code_extn_dtl	  ="";
			laterality_ind		  ="";
			proc_srt_dt_time	 =	"";
			proc_end_dt_time =	"";

		}else{
			disp_in			="N";
			disp_recode	="N";
			hideExtn		="disabled";
		}
		}else{
			hideExtn		 = "disabled";
			disp_mand	 ="hidden";
		}
}
/****/
String build_diag_class_type="";
/*F.Y.I:For SRR-CRF-303.2[15597],Review Status.*/
		if(proc_status_appl_yn.equals("A")){
			stus_A_select = "selected";
		}else if(status.equals("X")){
			stus_X_select = "selected";
		}

/*F.Y.I:For SRR-CRF-303.2[15597],Review Status.*/
String exculde_list_item	="NO";
String dis_status		 ="disabled";
if(action.equals("DiagModify")||action.equals("ProcModify") ){
		if(sel_status.equals("Review") && exclude_orig_code.equals("Y")){
			dis_status ="";
			exculde_list_item	="YES";
		}
/*F.Y.I:
	1.Added Long Desc when there is no difference between short_desc and long_desc then long_desc link wouldn't display.
	2.Added On 3/11/2010.
	3.Site Enhancement.
*/
	if(!(short_desc.equals(long_desc))&&!(modify_diag_val.equals("*OTH"))){
		display_long_desc ="inline";
	}

	} 
	
%> 

<body onKeyDown='lockKey()'>
<form name='DiagProcAddModify' id='DiagProcAddModify' action='../../servlet/eMR.DiagProcRecodingServlet' onLoad='chkDiag();' method='post' target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width="100%">
		<tr><td class='PANELTOOLBAR' colspan='6'><fmt:message key="Common.ProblemAssessment.label" bundle="${common_labels}"/></td>
		</tr>
		<%
		if(!newCode_yn.equals("Y")){
		%>
		<tr>
			<td class='label'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Items.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='sel_item1' id='sel_item1' value='<%=sel_code1%>' readonly></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<%}
		else{%>
				<input type='hidden' name='sel_item1' id='sel_item1' value=''>
		<%}%>
		<tr>
		<%
		if(procedure_yn.equals("Y")){
				String QUERY_FOR_DLFT_TMSET ="";
				if(action.equals("ProcModify")){
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE TERM_SET_ID='"+modify_term_set+"'";
				}else{
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN='Y' and RECODERS_APPL_YN='Y'" ;
				}
				%>
				<td class='label' width='12%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${common_labels}"/></td>
				<td width='18%' class='fields'>
				<%
				pstmt = conn.prepareStatement(QUERY_FOR_DLFT_TMSET);
				rset = pstmt.executeQuery();
				%>
				<select name="code_set" id="code_set">
				<!-- <option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> -->
				<%
				while(rset.next()){	
					dflt_termset=rset.getString("TERM_SET_ID");%>
					<option value='<%=rset.getString("TERM_SET_ID")%>' selected><%=rset.getString("TERM_SET_DESC")%></option>
				<%}
				}else{%>
				<td class='label' width='12%'><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></td>
				<td width='18%' class='fields'>
				<select name="code_set" id="code_set"> 
				<!-- <option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> -->
				<%
				String QUERY_FOR_DLFT_TMSET ="";
				if(action.equals("DiagModify")){
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE TERM_SET_ID='"+modify_term_set+"'";
				}else{
					QUERY_FOR_DLFT_TMSET="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE DIAG_SPEC_YN='Y' AND RECODERS_APPL_YN='Y'" ;
				}
				
				pstmt = conn.prepareStatement(QUERY_FOR_DLFT_TMSET);
				rset = pstmt.executeQuery();
				while(rset.next()){
				dflt_termset=rset.getString("TERM_SET_ID");%>
				<option value='<%=rset.getString("TERM_SET_ID")%>' selected> <%=rset.getString("TERM_SET_DESC")%></option>
				<%}
			}
			if(!dflt_termset.equals("")){
				diag_code_st="";
				//			fields_dis="";
			}else{
				diag_code_st="disabled";
				//			fields_dis="disabled";
			}
		%>
		</select><img  src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<tr>
		<%
			if(procedure_yn.equals("Y")){%>
			<td class='label' colspan='1' ><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
				<input type='text' name='diagprob_code' id='diagprob_code' size='5' onblur='getDescription(1);' value="<%=modify_proc_val%>" <%=fields_dis%>>&nbsp;<input type="text"  name="diagprob_desc" id="diagprob_desc" value="<%=short_desc%>" size="22" readonly onblur=''  <%=fields_dis%>><input type='button' class='button' value='?' onclick='callTermCode(1);' <%=diag_code_st%> <%=fields_dis%>><img  src='../../eCommon/images/mandatory.gif'><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_0" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_proc_long_desc%>','0')" ><b>!</b></a></span>&nbsp;<input type='button' class='button' value='+' onclick='addTermSet(<%=i%>);' <%=newCode_st%> <%=fields_dis%> <%=diag_code_st%>><input type="hidden" name='long_desc_val_0' id='long_desc_val_0' value="<%=modify_proc_long_desc%>"/>
			</td>
			<input type='hidden' name="hid_diagprob_code_0" id="hid_diagprob_code_0" value="<%=modify_proc_val%>">
			<td class='label' width='12%' nowrap>
			<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields' width='18%'>
						<select name="proc_type" id="proc_type" <%=hideExtn%> onchange="showProcdatestimes(this)" >
							<option value=""<%=opt_selected%>>---Select---</option>
							<option value="OT" <%=ot_selected%>><fmt:message key="eMR.OT.label" bundle="${mr_labels}" /></option>
							<option value="NO" <%=not_selected%>><fmt:message key="eMR.NonOT.label" bundle="${mr_labels}" /></option>
						</select>&nbsp;<img  src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>

		<tr id='t1' style='visibility:hidden;display:none'>
			<td class='label' width='12%' ></td>
			<td class='fields' width='18%'><input type='textbox' name='diagprob_code1' id='diagprob_code1' size='5' onblur='getDescription(2);'>&nbsp;<input type="text"  name="diagprob_desc1" id="diagprob_desc1" value="" size=22 readonly onblur=''><input type='button' class='button' value='?' onclick='callTermCode(2);' >&nbsp;&nbsp;<span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_1" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_proc_long_desc%>','1')"><b>!</b></a></span>&nbsp;<input type='hidden' name="hid_diagprob_code_1" id="hid_diagprob_code_1" value=""><input type="hidden" name='long_desc_val_1' id='long_desc_val_1' value=""/></td>
		</tr>
		<tr id='t2' style='visibility:hidden;display:none'>
			<td class='label' width='12%' ></td>
			<td class='fields' width='18%'><input type='textbox' name='diagprob_code2' id='diagprob_code2' size='5' onblur='getDescription(3);'>&nbsp;<input type="text"  name="diagprob_desc2" id="diagprob_desc2" value="" size=22 readonly onblur=''><input type='button' class='button' value='?' onclick='callTermCode(3);'>&nbsp;&nbsp;<span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_2" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_proc_long_desc%>','2')"><b>!</b></a></span>&nbsp;<input type='hidden' name="hid_diagprob_code_2" id="hid_diagprob_code_2" value=""><input type="hidden" name='long_desc_val_2' id='long_desc_val_2' value=""/></td>
		</tr>
		<tr>
				<%
						 if(code_xtn_appl_yn.equals("Y")){%>
								<td class='label' width='12%'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ext.label" bundle="${common_labels}"/></td>
								<td class='fields' width='18%'>
										<input type="text"  name="proc_cd_xtn" id="proc_cd_xtn" value="<%=code_extn_dtl%>" size='2' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);'>
								</td>
						<%}else{%>
									<input type="hidden"  name="proc_cd_xtn" id="proc_cd_xtn" value="<%=code_extn_dtl%>" >
							<%} if(laterality_appl_yn.equals("Y")){%>
									<td class='label' width='12%'><fmt:message key="eMR.Laterality.label" bundle="${mr_labels}"/></td>
									<td class='fields' width='18%'>
									<select name="proc_laterality" id="proc_laterality" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
												<option value="L"><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
												<option value="R"><fmt:message key="Common.Right.label" bundle="${common_labels}"/></option>
												<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
												<option value="N"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
										</select>
								</td>						
						<%}else{%>
							<input type="hidden"  name="proc_laterality" id="proc_laterality" value="<%=laterality_ind%>" >
						<%}%>
				<SCRIPT LANGUAGE="JavaScript">
				<!--
						if('<%=laterality_appl_yn%>'=="Y"){
							populateLateralityVal('<%=laterality_ind%>');
					}
				//-->
				</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		</tr>
		<tr  id="proc_dt_times" <%=open_dt_times%>>
			<td class='label' colspan='1' nowrap><label id="id_start_dt_time"><%=lbl_in_time%></label></td>
			<td class='spanData'   colspan='2' nowrap>
				<input type="text"  name="start_dt_time" id="start_dt_time" value="<%=proc_srt_dt_time%>" size='18' maxlength='18' onblur="procDateValidation(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('start_dt_time','dd/mm/yyyy','hh:24mi');"/></select><img id='start_mand'  src='../../eCommon/images/mandatory.gif' style="visibility:<%=open_chk_mand%>">
				<span >
					<label id="id_end_dt_time" ><%=lbl_out_time%></label>&nbsp;<input type="text"  name="end_dt_time" id="end_dt_time" value="<%=proc_end_dt_time%>" size='18'  maxlength='18' onblur="procDateValidation(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('end_dt_time','dd/mm/yyyy','hh:24mi');"/><img id='end_mand'   src='../../eCommon/images/mandatory.gif' style="visibility:<%=open_chk_mand%>">			
				</span>
			</td>
		</tr>
		<%if(proc_status_appl_yn.equals("Y")){%>
			<tr> 
				<td class="label" width='12%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width='18%' class='fields'><select name="status" id="status" <%=dis_status%>>
				<option value='A' <%=	stus_A_select%>><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
				<%if(exculde_list_item.equals("YES")){%>
					<option value='X' <%=stus_X_select%>><fmt:message key="eMR.Excludecodes.label" bundle="${mr_labels}"/></option>
				<%}%>
				</select><img  src='../../eCommon/images/mandatory.gif'>
				</td>
		<%
			}else{%>
				<input type='hidden' name='status' id='status' value='<%=status%>'>
			<%}
			if(proc_remarks_appl_yn.equals("Y")){%>
			<tr>
				<td class='label' width='12%'><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/> <!-- MODIFIED by mujafar for ML-MMOH-CRF-1270 -->
				</td><td class='fields' width='18%'><textarea name="remarks"  rows="2" cols="40" maxlength='30' onBlur="makeValidString(this);checkMaxLimitOfRemark(this);checkQuote();" onkeypress="return imposeMaxLength(this, 30);"><%=curr_remarks%></textarea></td>
			</tr>
		<%}else{%>
				<input type='hidden' name='remarks' id='remarks' value='<%=curr_remarks%>'>
		<%}%>
	<%// End Of Else;
	}else{%>
		<td class='label' width='12%' ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
		<td class='fields' width='32%'>
			<input type='textbox' name='diagprob_code' id='diagprob_code' size='5' onblur='if(document.forms[0].dflt_termset.value != "")getDescription(1);' value="<%=modify_diag_val%>" <%=fields_dis%>>&nbsp;<input type="text"  name="diagprob_desc" id="diagprob_desc" value="<%=short_desc%>" size=22 readonly onblur='' <%=fields_dis%>><input type='button' class='button' value='?' onclick='show_window(1);' <%=diag_code_st%> <%=fields_dis%>><img  src='../../eCommon/images/mandatory.gif'>&nbsp;<span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_0" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_diag_long_desc%>','0')"><b>!</b></a></span>&nbsp;<input type='button' class='button' value='+' onclick='recordSupportDiagnosis(0,"<%=EncounterId%>","<%=Pat_id%>");' name="spprt_diag_btn_0" <%=diag_code_st%> disabled title="Supporting Diagnosis" >&nbsp;<input id='addDiag' type='button' class='button' value='+' onclick='addTermSet(<%=i%>);' <%=newCode_st%> <%=fields_dis%> <%=diag_code_st%>> <input type='hidden' name="code_indicator_0" id="code_indicator_0" value="">
		</td>
		<input type='hidden' name="record_assosicate_codes_0" id="record_assosicate_codes_0" value="">
		<input type='hidden' name="hid_diagprob_code_0" id="hid_diagprob_code_0" value="<%=modify_diag_val%>">
		<input type="hidden" name='long_desc_val_0' id='long_desc_val_0' value="<%=modify_diag_long_desc%>"/>
		
				<!--  added by mujafar for ML-MMOH-CRF-1281 -->
		
		<td class='label' width='12%' id='other_disp1' name='other_disp1' style ="<%=includevisibility%>" ><fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>s </td>
		<td class='fields' width='20%' id='other_disp2' name='other_disp2' style ="<%=includevisibility%>" >
		<select name='term_oth_desc' id='term_oth_desc' id='term_oth_desc' style='width:100' <%=includevisibility%> >
		<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
		<%if(descCount==1){
			
			JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);
							String chk_val = "";
							String descriptions="";
							for(int ii=1;ii<=10;ii++)
							{   chk_val = "";
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+ii));
								if(!descriptions.equals(""))
								{
								if(term_sht_desc.equals(descriptions))chk_val = "selected";
									
			%>
				<option value="<%=descriptions%>" <%=chk_val%> > <%=descriptions%></option>

							<%	}
							}
		}%>
		</select><img src= '../../eCommon/images/mandatory.gif'></img></td>
		
		<!--   added by mujafar for ML-MMOH-CRF-1281 -->
		
		
		
		</tr>
		<tr id='t1' style='visibility:hidden;display:none'>
			<td class='label' width='12%' ></td>
			<td class='fields' width='32%'>
				<input type='textbox' name='diagprob_code1' id='diagprob_code1' size='5' onblur='getDescription(2);'>&nbsp;<input type="text"  name="diagprob_desc1" id="diagprob_desc1" value="" size=22 readonly onblur=''><input type='button' class='button' value='?' onclick='show_window(2);' >&nbsp;&nbsp;&nbsp;&nbsp;<span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_1" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_diag_long_desc%>','1')"><b>!</b></a></span>&nbsp;<input type='button' class='button' name="spprt_diag_btn_1" id="spprt_diag_btn_1" value='+' onclick='recordSupportDiagnosis(1,"<%=EncounterId%>","<%=Pat_id%>");' <%=diag_code_st%> disabled title="Supporting Diagnosis" >&nbsp;<input type='hidden' name="code_indicator_1" id="code_indicator_1" value="">&nbsp;<input type='hidden' name="record_assosicate_codes_1" id="record_assosicate_codes_1" value="">&nbsp;<input type='hidden' name="hid_diagprob_code_1" id="hid_diagprob_code_1" value="">	<input type="hidden" name='long_desc_val_1' id='long_desc_val_1' value=""/>

		</td>
		</tr>
		<tr id='t2' style='visibility:hidden;display:none'>
			<td class='label' width='12%' ></td>
			<td class='fields' width='32%'>
				<input type='textbox' name='diagprob_code2' id='diagprob_code2' size='5' onblur='getDescription(3);'>&nbsp;<input type="text"  name="diagprob_desc2" id="diagprob_desc2" value="" size=22 readonly onblur=''><input type='button' class='button' value='?' onclick='show_window(3);' >&nbsp;&nbsp;&nbsp;&nbsp;<span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" id="long_desc_2" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=modify_diag_long_desc%>','2')"><b>!</b></a></span>&nbsp;<input type='button' name="spprt_diag_btn_2" id="spprt_diag_btn_2" class='button' value='+' onclick='recordSupportDiagnosis(2,"<%=EncounterId%>","<%=Pat_id%>");' <%=diag_code_st%> disabled title="Supporting Diagnosis" >&nbsp;<input type='hidden' name="code_indicator_2" id="code_indicator_2" value="">&nbsp;<input type='hidden' name="record_assosicate_codes_2" id="record_assosicate_codes_2" value="">&nbsp;<input type='hidden' name="hid_diagprob_code_2" id="hid_diagprob_code_2" value=""><input type="hidden" name='long_desc_val_2' id='long_desc_val_2' value=""/>

			</td>
		</tr>
		
		<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
		<%if(doctorsDescription && !newCode_yn.equals("Y")){
			if(mode.equals("Modify"))
			{
				sel_desc_trim = rec_doc_desc;
				if(!("").equals(sel_desc_trim))
				{
					doc_desc_visibile_yn = "visible";
				}else
				{
					doc_desc_visibile_yn = "hidden";
				}
			}else
			{
			if(sel_desc.length() <= 100)
			{
				sel_desc_trim = sel_desc;
			}else
			{
				sel_desc_trim = sel_desc.substring(0, 100);
				}
			}
		%>
		<tr>
			<td class='label' width='12%'><fmt:message key="eMR.DoctorDesc.label" bundle="${mr_labels}"/></td>
			<td class='fields' width='18%'><textarea name="doctor_desc"  rows="2" cols="55" maxlength='100' onBlur="makeValidString(this);checkMaxLimitOfDoctorsDesc(this);" onkeypress="return imposeMaxLength(this, 100);" <%=fields_dis%>><%=sel_desc_trim%></textarea><img  style="visibility:<%=doc_desc_visibile_yn%>" src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<%}%>
		<!--End ML-MMOH-CRF-1269-->

		<!-- In Below lines added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 -->
		<!-- Below condition is changed for ML-MMOH-CRF-1581 BY KAMATCHI S-->
		 <% if((enc_stage_yn.equals("Y") && Patient_Class.equals("IP") && !isEncounterStage)  || isInpatientDaycare.equals("Y")  ){%> 
		<tr>
		<td class='label' width='12%' id='enc_stage_tab_id'  style=''><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}" /></td>		
		<td class='fields' width='18%' id='enc_stage_tab_id1'  style=''><select name='diag_stage' id='diag_stage' ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%String enc_stg_sql	="SELECT list_value FROM mr_term_set_crit_for_pc WHERE  patient_class='"+Patient_Class+"' AND criteria IN ('ENCOUNTER_STAGE')";
		ArrayList enc_stg_list=new ArrayList(); 
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		pstmt = conn.prepareStatement(enc_stg_sql);
		rset = pstmt.executeQuery();
		while(rset.next()){
		enc_stg_list.add(checkForNull(rset.getString("list_value")));
		}		
		if(!(diagstagecode==null || diagstagecode.equals("")))
			{
			if(diagstagecode.equals("A"))
			diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
			diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
			diastgSel_3="selected";
			}		
		for(int ij=0;ij<enc_stg_list.size();ij++)
			{
			String list_value="";	
			String list_value1="";
			list_value=checkForNull((String) enc_stg_list.get(ij)); 			
		if(list_value.equals("ADMISSION"))
			{ 
			list_value="A";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_1+"  />"+list_value1 );
			}
		if(list_value.equals("INTERMEDIATE"))
			{
			list_value="I";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_2+"   />"+list_value1 );
			}
		if(list_value.equals("DISCHARGE"))
			{
			list_value="D";
			list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			out.print("<option value='"+list_value+"' "+diastgSel_3+"  />"+list_value1 );
			}
			}
		 if(rset!=null) rset.close();
		%>
		</select><img src= '../../eCommon/images/mandatory.gif' id='enc_stage_tab_img'></td></tr>		
		 <%}%>
		 <%
		 if(chife_compln_yn.equals("Y")){		 
		  StringBuffer sql = new StringBuffer(); 
	sql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and a.occur_srl_no='"+occur_srl_no+"'");
			if(!modify_diag_val.equals("*OTH"))
				sql.append("and a.term_code = ? "); 
			else
				sql.append("and a.term_code_short_desc = ? "); 
			sql.append("order by a.onset_date desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,p_facility_id);
			pstmt.setString(3,EncounterId);
			pstmt.setString(4,dflt_termset);
			if(!modify_diag_val.equals("*OTH"))
				pstmt.setString(5,modify_diag_val); 
			else
				pstmt.setString(5,short_desc);				
				rset = pstmt.executeQuery();
			while(rset.next())
				{ 
				complaint_Desc		= rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
				complaint_id		= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
				if(firstTime)
				{
					_complaint_Desc = _complaint_Desc + "" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "" +complaint_id +"";
				}
				else
				{
					_complaint_Desc = _complaint_Desc + ";" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "$" +complaint_id +"";
				}
				firstTime = false;
			}
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();  
		  %>  
		  <tr>  
		<td class = 'label' width='12%'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
			<td class='fields' width='18%'><textarea type='textarea' name='complaint_desc' value='' readonly ><%=_complaint_Desc%></textarea><input type='hidden' name='complaint_id' id='complaint_id' value='<%=_complaint_id%>'></input><input type='button' name='ComplaintSrch' id='ComplaintSrch' value='?'  OnClick='selectProblem();' class='button'  <% if(!mode.equals("Modify")){ %>disabled<%}%> ></input></td>
		 <%}else{%> 
		 <tr>
		   <td class = 'label' width='12%' colspan='2'></td>  
		  <% }if(notify_yn.equals("Y")){
		  //added by Sangeetha for ML-MMOH-CRF-0547
		  Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","TYPES_OF_NOTIFICATION_FORM"); 
		  if(legendChangeAsTypesOfNotiForm){
		  %>   
		  <td  class="label" width='20%' ><fmt:message key="eMR.TypesofNotification.label" bundle="${mr_labels}"/> </td>
		  <% }
		  else{%>
	      <td  class="label" width='20%' ><fmt:message key="eMR.WorkRelated.label" bundle="${mr_labels}"/></td><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
		  <% } %>
			<td  class="fields" width='20%' >   
			<select name="notification_setup" id="notification_setup" onchange='EnableNotifySetup()'  >   
			 <OPTION value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
			 <% try 
				{ 
				String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE,DEFAULT_NOTE_TYPE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'"; //senthil modified				
				pstmt = conn.prepareStatement(notify_sql);
				rset=pstmt.executeQuery();
				while(rset.next()) 
					{
					String notify_code=rset.getString("NOTIFICATION_CODE");
					String notify_desc=rset.getString("SHORT_DESC");
					email_yn=rset.getString("EMAIL_APPLICABLE");
					default_note_type=rset.getString("DEFAULT_NOTE_TYPE")==null?"":rset.getString("DEFAULT_NOTE_TYPE");		
              	if(notifiable_code.equals(notify_code))
						{
						email_sel_yn=email_yn;
						deflt_note_type=default_note_type; //Added Senthil
						out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"' selected>"+notify_desc+"</option>");
						}
					else{	
					out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"'>"+notify_desc+"</option>");	
					}
					}
				if(pstmt!=null) pstmt.close();
				if(rset	!= null)   rset.close();
				}
			catch(Exception e)
				{
				e.printStackTrace();
				}%>
			</select>  
		</td> </tr>	 
	     <%}%>
	<%}%>
	 	<% 
		if(!procedure_yn.equals("Y") || procedure_yn.equals("")){
			if(diag_class_appl_yn.equals("Y")){%>
		<tr>	
			<td  class="label" width='20%' id='diag_classf_legend'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Classification.label" bundle="${common_labels}"/>
			</td>
			<td  class="fields" width='20%' >
				<select name="diag_classfication" id="diag_classfication"  id='diag_classf_desc' onchange="restirctPrimaryDiag(this)">
					<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
					String sql1="SELECT A.DIAG_CLASS_CODE, A.SHORT_DESC,A.DIAG_CLASS_TYPE FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND B.TERM_SET_ID='"+dflt_termset+"' AND A.EFF_STATUS='E' ORDER BY A.SHORT_DESC";
					pstmt = conn.prepareStatement(sql1);
					rset = pstmt.executeQuery();
					int ii=1;
					while( rset.next() ){
						String  _diagcode = rset.getString( "DIAG_CLASS_CODE" ) ;
						String  _shortdesc=rset.getString("SHORT_DESC");
						String  _diagtype=rset.getString("DIAG_CLASS_TYPE");
						//out.println("<script>alert(\"_diagcode :"+_diagcode+"\");</script>");
						if(prin_diag.equals("Y") && _diagtype.equals("PD")){
						}else{
							if(diag_class_code.equals(_diagcode)){
								out.println("<option value ='"+_diagcode+"$"+_diagtype+"' selected>"+_shortdesc+"</option>");
								build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_"+ii+"' id='diag_class_type_"+ii+"'value='"+_diagtype+"'>";
							}else{
								out.println("<option value ='"+_diagcode+"$"+_diagtype+"'>"+_shortdesc+"</option>");
								build_diag_class_type	=	build_diag_class_type+"<input type='hidden' name='diag_class_type_"+ii+"' id='diag_class_type_"+ii+"'value='"+_diagtype+"'>";
							}
						}
						ii++;
					}
					if(rset != null) rset.close();
					%>
				</select>
			</td>
			<span><%=build_diag_class_type%></span>
		<%
		}
			

			if(accuracy_appl_yn.equals("Y")){%>
				<td  class="label" width='20%' ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
				<td class='fields' width='20%'><select name="accuracy" id="accuracy" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
					String sql_accuracy	="select a.accuracy_code||'='||a.accuracy_indicator accuracy_code1, a.accuracy_code, mr_get_desc.MR_ACCURACY(b.accuracy_code,'"+locale+"',2) short_desc,b.DFLT_VALUE_YN from MR_ACCURACY a , mr_term_set_crit_for_pc b where  a.eff_status='E' AND a.accuracy_code=b.accuracy_code and b.patient_class='"+Patient_Class+"' and b.criteria='ACCURACY' order by a.short_desc";
					pstmt = conn.prepareStatement(sql_accuracy);
					rset = pstmt.executeQuery();	
					while(rset.next()){	 
						String accr_desc = rset.getString("short_desc");
						String codes = rset.getString("accuracy_code");
						if(curr_accuracy_code.equals(codes)){
							out.print("<option value='"+codes+"' selected />"+accr_desc );
						}else{
							out.print("<option value='"+codes+"'/>"+accr_desc );
						}
				}
				if(rset != null) rset.close();
		%>
		</select><img  src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<%
			}else{%>
				<input type='hidden' name='accuracy' id='accuracy' value='<%=curr_accuracy_code%>'>
			<%}
				if(severity_appl_yn.equals("Y")){%>
				<tr>
					<td class="label"><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
					<td class='fields' width='18%'><select name="severity" id="severity" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<option value='D' <%=sevr_D_select%>><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
					<option value='L' <%=sevr_L_select%>><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
					<option value='S' <%=sevr_S_select%>><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
					<option value='E' <%=sevr_E_select%>><fmt:message key="eMR.Extreme.label" bundle="${mr_labels}"/></option>
					</select><img  src='../../eCommon/images/mandatory.gif'>
					</td>
			<%}else{%>
				<input type='hidden' name='severity' id='severity' value='<%=curr_severity%>'>
			<%}
			if(priority_appl_yn.equals("Y")){%>
				<td class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td class='fields' width='18%'><select name="priority" id="priority" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
					String sql_priority	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+Patient_Class+"' and criteria='PRIORITY'";
					pstmt = conn.prepareStatement(sql_priority);
					rset = pstmt.executeQuery();
				while(rset.next()){	
				String list_value="";
				//String dflt_value_yn = "";
				String list_value1="";
				list_value=rset.getString("list_value");
				//dflt_value_yn=rset.getString("dflt_value_yn");
				if(list_value.equals("NORMAL")){
					list_value="N";
					list_value1="Normal";
				}
				if(list_value.equals("HIGH")){
					list_value="H";
					list_value1="High";
				}
				if(list_value.equals("CRITICAL")){
					list_value="C";
					list_value1="Critical";
				}
				
				if(curr_priority.equals(list_value)){
						out.print("<option value='"+list_value+"' selected />"+list_value1 );
					}else{
						out.print("<option value='"+list_value+"'/>"+list_value1 );
					}

			}
			if(rset != null) rset.close();

			
			%>
			</select><img  src='../../eCommon/images/mandatory.gif'>
			</td>
		</tr>
		<%
			}
			else
			{%>
				<input type='hidden' name='priority' id='priority' value='<%=curr_priority%>'>

			<%}


			if(onset_type_appl_yn.equals("Y"))
			{
		%>
		<tr>	
			<td class='label' width='12%' id="onset_type_tabid" style='' ><fmt:message key="eMR.OnsetType.label" bundle="${mr_labels}"/></td>
			<td width='18%' class='fields'><select name="onset_type" id="onset_type" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option><option value='N' <%=type_N_select%> ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option><option value='A' <%=type_A_select%> ><fmt:message key="eMR.Acute.label" bundle="${mr_labels}"/></option><option  value='C' <%=type_C_select%> ><fmt:message key="eMR.Chronic.label" bundle="${mr_labels}"/></option>
			</select><img  src='../../eCommon/images/mandatory.gif'>
			</td>
			<%
			}
			else
			{%>
				<input type='hidden' name='onset_type' id='onset_type' value='<%=curr_onset_type%>'>

			<%}


			if(onset_date_appl_yn.equals("Y"))
			{	
			
			%>
			<td width='20%' class='label' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='onset_date' id='onset_date'  value='<%=curr_onset_date%>' id='date1' size='18' maxlength='18' Onblur="validateDatetime(this,getLabel('Common.onsetdate.label','Common'))" <%=fields_dis%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('onset_date','dd/mm/yyyy','hh:24mi');" <%=fields_dis%>/><img  src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<%
			}
			else
			{%>
				<input type='hidden' name='onset_date' id='onset_date' value='<%=curr_onset_date%>'>

			<%}


			if(status_appl_yn .equals("Y")){
		%>
			<tr> 
				<td class="label" width='12%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width='18%' class='fields'><select name="status" id="status" <%=dis_status%>>
				<option value='A' <%=stus_A_select%>><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
				<%if(exculde_list_item.equals("YES")){%>
					<option value='X' <%=stus_X_select%>><fmt:message key="eMR.Excludecodes.label" bundle="${mr_labels}"/></option>
				<%}%>
				</select><img  src='../../eCommon/images/mandatory.gif'>
				</td>
		<%
			}else{%>
				<input type='hidden' name='status' id='status' value='<%=status%>'>
			<%}
			if(as_on_date_appl_yn  .equals("Y")){%>
			<td class='label' width='20%' ><fmt:message key="Common.Ason.label" bundle="${common_labels}"/></td>
			<td width='20%' class='fields'><input type='text' name='status_date' id='status_date' size='18' maxlength='18' value='<%=status_date%>' Onblur="validateDate(this,getLabel('Common.Ason.label','Common'))" <%=fields_dis%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('status_date');" <%=fields_dis%>/><img  src='../../eCommon/images/mandatory.gif'>
			</td>
		</tr>
		<%
			}
			else
			{%>
				<input type='hidden' name='status_date' id='status_date' value='<%=status_date%>'>

			<%}

		%>
			<%if(applicable_side_appl_yn.equals("Y")){%>
			<tr>
				<td class='label'><fmt:message key="eMR.ApplicableSide.label" bundle="${mr_labels}"/></td>
				<td class='fields'><select name="applicable_side" id="applicable_side"><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<option value='L' <%=applicable_l%>><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
				<option  value='R' <%=applicable_r%>><fmt:message key="Common.Right.label" bundle="${common_labels}"/></option>
				<option value='B' <%=applicable_b%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option value='N' <%=applicable_n%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			</tr>

			<%}else{%>
					<input type='hidden' name='applicable_side' id='applicable_side' value='<%=applicable_side%>'>
			<%}%>	
		<%if(remarks_appl_yn.equals("Y")){%>
			<tr>
				<td class='label' width='12%'><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/><!-- modified by mujafar for ML-MMOH-CRF-1270 -->
				</td><td class='fields' width='18%'><textarea name="remarks"  rows="2" cols="40" maxlength='30' onBlur="makeValidString(this);checkMaxLimitOfRemark(this);checkQuote();" onkeypress="return imposeMaxLength(this, 30);" <%=rmrk_disabl%>><%=curr_remarks%></textarea></td>
			</tr>
		<%}else{%>
				<input type='hidden' name='remarks' id='remarks' value='<%=curr_remarks%>'>
		<%}%>
<%}%>


		<tr>
			<td width='20%' class='label'></td>
			<td width='20%' class='label'></td>
			<%
			if(newCode_yn.equals("Y"))
			{
				DB_Recode_Status	="";
				DB_Recode_Stages	="";
			%>
			<td width='20%'><input type='button' name='Save' id='Save' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='recodeVal();'>&nbsp;<!-- <input type='button' name='reset' id='reset' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' onclick='resetAddModify();' class='button'> --><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>'  class='button' onclick="resetProcdatetimes()"></td>
			<%
			}
			else
			{
			%>
			<td width='20%'><input type='button' name='Save' id='Save' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='recodeVal();'>&nbsp;<!-- <input type='button' name='reset' id='reset' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>' onclick='resetAddModify();' class='button'> --><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>'  class='button' onclick="resetProcdatetimes()"></td>
			<%}%>
		<tr>
	</table>
	<input type='hidden' name='dumy_onset' id='dumy_onset' value="">
	<input type='hidden' name='sel_code' id='sel_code' value='<%=sel_code%>'>
	<input type='hidden' name='sel_code1' id='sel_code1' value='<%=sel_code1%>'>
	<input type='hidden' name='Pat_id' id='Pat_id' value='<%=Pat_id%>'>
	<input type='hidden' name='gender' id='gender' value='<%=gender%>'>
	<input type='hidden' name='age' id='age' value='<%=age%>'>
	<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
	<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=spec_code%>'>
	<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=loginUser%>'>
	<input type='hidden' name='dflt_termset' id='dflt_termset' value='<%=dflt_termset%>'>
	<input type='hidden' name='EncounterId' id='EncounterId' value='<%=EncounterId%>'>
	<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
	<input type='hidden' name='stage_no' id='stage_no' value='<%=stage_no%>'>
	<input type='hidden' name='confirm_appl' id='confirm_appl' value="<%=confirm_appl%>"> <!-- added by mujafar for ML-MMOH-CRF-0878 -->
	<input type='hidden' name='caused_death' id='caused_death' value='N'>
	<input type='hidden' name='occur_srl_no' id='occur_srl_no' value='<%=occur_srl_no%>'>
	<input type='hidden' name='recode_status' id='recode_status' value='<%=recode_status%>'>
	<input type='hidden' name='orig_termset' id='orig_termset' value='<%=orig_termset%>'>
	<input type='hidden' name='orig_termcode' id='orig_termcode' value='<%=orig_termcode%>'>
	<input type='hidden' name='procedure_yn' id='procedure_yn' value='<%=procedure_yn%>'>
	<input type='hidden' name='newCode_yn' id='newCode_yn' value='<%=newCode_yn%>'>
	<input type='hidden' name='accuracy_appl_yn' id='accuracy_appl_yn' value='<%=accuracy_appl_yn%>'>
	<input type='hidden' name='severity_appl_yn' id='severity_appl_yn' value='<%=severity_appl_yn%>'>
	<input type='hidden' name='priority_appl_yn' id='priority_appl_yn' value='<%=priority_appl_yn%>'>
	<input type='hidden' name='onset_date_appl_yn' id='onset_date_appl_yn' value='<%=onset_date_appl_yn%>'>
	<input type='hidden' name='as_on_date_appl_yn' id='as_on_date_appl_yn' value='<%=as_on_date_appl_yn%>'>
	<input type='hidden' name='i' id='i' value=''>
	<input type='hidden' name='termcode_cnt' id='termcode_cnt' value=''>		
	<input type='hidden' name='sel_item' id='sel_item' value='<%=sel_code%>'>
	<input type='hidden' name='sel_srl_no' id='sel_srl_no' value='<%=sel_srl_no%>'>
	<input type='hidden' name='sel_term_code' id='sel_term_code' value='<%=sel_term_code%>'>
	<input type='hidden' name='sel_term_set' id='sel_term_set' value='<%=sel_term_set%>'>
	<input type='hidden' name='activity' id='activity' value='<%=action%>'>

	<input type='hidden' name='currentdate' id='currentdate' value='<%=currentdate%>'>
	<input type='hidden' name='onset_type_appl_yn' id='onset_type_appl_yn' value='<%=onset_type_appl_yn%>'>
	<input type='hidden' name='status_appl_yn' id='status_appl_yn' value='<%=status_appl_yn%>'>
	<input type='hidden' name='proc_status_appl_yn' id='proc_status_appl_yn' value='<%=proc_status_appl_yn%>'>
	<input type='hidden' name='sel_stages_val' id='sel_stages_val' value='<%=sel_stages_vals%>'>
	<input type='hidden' name='sel_status' id='sel_status' value='<%=sel_satus_vals%>'>
	<input type='hidden' name='grpby_val' id='grpby_val' value='<%=sel_grp_vals%>'>
	<input type='hidden' name='sel_mod_id' id='sel_mod_id' value='<%=sel_mod_id%>'><!-- Added On 7/10/2009 -->
	<input type='hidden' name='sel_cod_xtn' id='sel_cod_xtn' value='<%=sel_cod_xtn%>'><!-- Added On 7/10/2009 -->
	<input type='hidden' name='sel_cod_xtn_dtl' id='sel_cod_xtn_dtl' value='<%=sel_cod_xtn_dtl%>'><!-- Added On 7/10/2009 -->
	<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'>
	<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<!-- Added On 12/12/2009 for SRR-CRF-303.1 -->
	<input type='hidden' name='pat_visit_dt_time' id='pat_visit_dt_time' value='<%=pat_visit_dt_time%>'>
	<input type='hidden' name='pat_disch_dt_time' id='pat_disch_dt_time' value='<%=pat_disch_dt_time%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='proc_type_hid_yn' id='proc_type_hid_yn' value='<%=proc_type_hid_yn%>'>
	<input type='hidden' name='laterality_ind' id='laterality_ind' value='<%=laterality_ind%>'>
	<!-- Added For 303.1 -->
	<input type='hidden' name='proc_srt_dt_hid' id='proc_srt_dt_hid' value="Y">
	<input type='hidden' name='proc_end_dt_hid' id='proc_end_dt_hid' value="Y">
	<!-- Added For 303.2 -->
	<input type='hidden' name='dagger_independent_yn_0' id='dagger_independent_yn_0' value="<%=dagger_independent_yn%>">
	<input type='hidden' name='dagger_independent_yn_1' id='dagger_independent_yn_1' value="N">
	<input type='hidden' name='dagger_independent_yn_2' id='dagger_independent_yn_2' value="N">
	<input type='hidden' name='hdr_modified_dt' id='hdr_modified_dt' value="">
	<!--//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234-->
	<input type='hidden' name='diagnosis_by_long_desc_yn' id='diagnosis_by_long_desc_yn' value="<%=diagnosis_by_long_desc_yn%>">
	 <!--Below lines hidden fields are added against HAS-CRF-300 -->
    <input type='hidden' name='diag_enc_level' id='diag_enc_level' value="<%=diag_enc_level%>">
	<input type='hidden' name='notifiable_form_mand_yn' id='notifiable_form_mand_yn' value="<%=notifiable_form_mand_yn%>"/>   
	<input type='hidden' name='notifiable_code' id='notifiable_code' value='<%=notifiable_code%>'></input>
	<input type='hidden' name='email_yn' id='email_yn' value='<%=email_sel_yn%>'></input>
	<input type='hidden' name='default_note_type' id='default_note_type' value='<%=default_note_type%>'></input> 
    <input type='hidden' name='specialty_code' id='specialty_code' value="<%=specialty_code%>">
	<input type='hidden' name='diagprob_short_desc' id='diagprob_short_desc' value='<%=short_desc%>'></input> 
     <!--END HAS-CRF-300 -->	

	<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
	<input type='hidden' name='doctorsDescription' id='doctorsDescription' value='<%=doctorsDescription%>'></input> 
	<input type='hidden' name='isMultiDescAppl' id='isMultiDescAppl' value='<%=isMultiDescAppl%>'></input> <!--added by mujafar for ML-MMOH-CRF-1281 -->
</form>
</body>
</html>
<%
}catch( Exception ex){
	ex.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);

}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

