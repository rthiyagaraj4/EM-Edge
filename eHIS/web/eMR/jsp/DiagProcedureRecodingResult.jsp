<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedicalReportReq" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%	String locale = (String)session.getAttribute("LOCALE");
		String loginUser = (String)session.getValue("login_user");
%>

<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String call_from		=checkForNull(request.getParameter("call_from"));
String title				= request.getParameter("title")==null?"":request.getParameter("title");	
String locn_type	= "";		
String locn_code	= "";		
String classValue	= "";
String attend_practitioner_id  = "";
StringBuffer sqlbuff	= new StringBuffer();
String FacilityId			= (String) session.getValue( "facility_id" ) ;	
String criteria			= request.getParameter("criteria")==null?"":request.getParameter("criteria");
if(criteria == null) criteria="";
String jsp_name		=request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
String finalSelect		="";
String temp1				="";
String temp2				="";
String enc_temp		="";
String pat_temp		="";
String finalSelect1		="";
String status				="";
String stage_no			="";
String search_by		="";
//int fetchRecord			=0;
String loc_type			="";
String sel_cnt			= request.getParameter("sel_cnt")==null?"":request.getParameter("sel_cnt");
String oper_stn_id		= request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
String speciality_val  = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
String selectAll_yn	= request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");
if(selectAll_yn == null) selectAll_yn="";
finalSelect					= request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
if(finalSelect == null) finalSelect="";
String chkSelect		= request.getParameter("chkSelect")==null?"":request.getParameter("chkSelect");
if(chkSelect == null) chkSelect="";
finalSelect=request.getParameter("finalSelect1")==null?"":request.getParameter("finalSelect1");
if(finalSelect1 == null) finalSelect1="";
status=request.getParameter("status")==null?"":request.getParameter("status");
if(status == null) status="";
stage_no=request.getParameter("stage_no")==null?"":request.getParameter("stage_no");
if(stage_no == null) stage_no="";
search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");
if(search_by == null) search_by="";
String Enc_Type = request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");
String orderBy=checkForNull(request.getParameter("orderBy"));
String time_period_col="";
if(Enc_Type.equals("IP")||Enc_Type.equals("DC")){
	time_period_col="CF_PR_FR_RECODE_DYS_FM_DISC";
}else{
	time_period_col="CF_PR_FR_RECODE_DYS_FM_VSTCMPL";
}
if(orderBy.equals("")|| orderBy.equals("ET")) {
	if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
		orderBy = " to_char(a.admission_date_time,'dd/mm/yyyy hh24:mi') desc";
	}else{
		orderBy = " to_char(a.queue_date,'dd/mm/yyyy hh24:mi') desc";
	}
}else if(orderBy.equals("ED")) {
	if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
			orderBy = "a.admission_date_time asc";
	}else{
		orderBy = "a.queue_date asc";
	}
}
String Patient_ID="";
String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
if(alt_id1_exp_date == null) 
alt_id1_exp_date="";
else
alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");

String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
if(alt_id2_exp_date == null) 
alt_id2_exp_date="";
else
alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");

String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");
if(!(p_discharge_date_from==null || p_discharge_date_from.equals(""))){
	if(p_discharge_date_from.length() >10){
		p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMYHM",locale,"en");
	}else{
		p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMY",locale,"en");
	}
}
String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");

if(!(p_discharge_date_to==null || p_discharge_date_to.equals(""))){
	if(p_discharge_date_to.length() >10)
		p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMYHM",locale,"en");
	else
		p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMY",locale,"en");
}
String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
if(national_id_no == null) national_id_no="";
String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
if(alt_id1_no == null) alt_id1_no="";
String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
if(alt_id2_no == null) alt_id2_no="";
String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
if(alt_id3_no == null) alt_id3_no="";
String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
if(alt_id4_no == null) alt_id4_no="";
String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
if(other_alt_type == null) other_alt_type="";
String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
if(other_alt_Id == null) other_alt_Id="";
temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
if(temp1 == null) temp1="";
temp2=request.getParameter("temp2")==null?"":request.getParameter("temp2");
if(temp2 == null) temp2="";
enc_temp=request.getParameter("enc_temp")==null?"":request.getParameter("enc_temp");
if(enc_temp == null) enc_temp="";
pat_temp=request.getParameter("pat_temp")==null?"":request.getParameter("pat_temp");
if(pat_temp == null) pat_temp="";
String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
String flag="";
flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");
String  req_start   =   "", req_end     =   "";
String  checkedOnes         =   "";

req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

if( jsp_name == null) jsp_name="";
String window_styl=request.getParameter("window_styl");
if( window_styl == null) window_styl="";
String close_yn	=request.getParameter("close_yn");
if( close_yn == null) close_yn="";
String win_top =request.getParameter("win_top");
if( win_top == null) win_top="";
String win_height =request.getParameter("win_height");
if(win_height ==null) win_height="";
String dialogTop =request.getParameter("dialogTop");
if(dialogTop ==null) dialogTop="";
String win_width =request.getParameter("win_width");
if( win_width == null) win_width="";
String modal=request.getParameter("modal");
if(modal == null) modal="";
String module=request.getParameter("module");
if(module == null) module="";
String model_window=request.getParameter("model_window");
if( model_window == null) model_window="";
String function_id=request.getParameter("function_id");
if( function_id == null) function_id="";

String prog_id=request.getParameter("prog_id");
if( prog_id == null) prog_id="";
String Encounter_ID="";

String p_practitioner_id=request.getParameter("practitioner_id");
if( p_practitioner_id == null) p_practitioner_id="";

String call_function=request.getParameter("call_function");
if(call_function == null) call_function="";

//out.println("call_function==="+call_function);
String no_of_days			=request.getParameter("no_of_days");
if(no_of_days == null) no_of_days="";

String PatientId		=	request.getParameter("PatientId") ;
if(PatientId	== null || PatientId.equals("null"))		
PatientId = "";	

if(call_function.equals("REPRINT_PAT_VAL"))
{
PatientId= "";
}
String EncounterId		=	request.getParameter("p_encounter_id") ;

if(EncounterId	== null || EncounterId.equals("null"))		
EncounterId = "";

String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";


String recode_action =	request.getParameter("action_if_not_done") ;
if(recode_action	== null || recode_action.equals("null"))recode_action = "";


String DischargeDate	=	request.getParameter("DischargeDate") ;
if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";



String Discharge	=	request.getParameter("discharge_val") ;
if(Discharge	== null || Discharge.equals("null"))Discharge = "";

String reportname	=	request.getParameter("reportname") ;
if(reportname	== null || reportname.equals("null"))reportname = "";

String allow_recode_diag_yn=request.getParameter("allow_recode_diag_yn") ;
if(allow_recode_diag_yn	== null || allow_recode_diag_yn.equals("null"))allow_recode_diag_yn = "";
String allow_recode_proc_yn=request.getParameter("allow_recode_proc_yn") ;
if(allow_recode_proc_yn	== null || allow_recode_proc_yn.equals("null"))allow_recode_proc_yn = "";
String allow_ot_proc_recode_yn=request.getParameter("allow_ot_proc_recode_yn") ;
if(allow_ot_proc_recode_yn	== null || allow_ot_proc_recode_yn.equals("null"))allow_ot_proc_recode_yn = "";
String allow_non_ot_proc_recode_yn=request.getParameter("allow_non_ot_proc_recode_yn") ;
if(allow_non_ot_proc_recode_yn	== null || allow_non_ot_proc_recode_yn.equals("null"))allow_non_ot_proc_recode_yn = "";
String whereClause = request.getParameter("whereclause");
if(whereClause	== null || whereClause.equals("null"))	{
	whereClause= "";
}else
{
//sql = whereClause;
}

String join_mp_pat="N";

String from = checkForNull(request.getParameter( "from" )) ;
String to = checkForNull(request.getParameter( "to" )) ;
String modal_yn = checkForNull(request.getParameter("modal_yn")) ;
String increment_rec_count = checkForNull(request.getParameter("increment_rec_count"),"N") ;
String display_select_btn = "inline";
//String install_yn="";
//if(modal_yn.equals("Y"))
//install_yn =checkForNull(request.getParameter( "bl_install_yn" )) ;

int start = 0 ;
int end = 0 ;
int i=1;
//int k=0;
int totalRecords=0;
totalRecords=Integer.parseInt(checkForNull(request.getParameter("totalRecords"),"0"));
//out.println("<script>alert(\""+end+"\");</script>");

//if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
//if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }

if ( from == null )
start = 1 ;
else
{
if(from.equals(""))start=1;
else
start = Integer.parseInt( from ) ;
}

if ( to == null )
end = 10 ;
else
{
if(to.equals(""))end=10;
else
end = Integer.parseInt( to ) ;
}

//out.println("<script>alert(\""+start+"\");</script>");
//out.println("<script>alert(\""+end+"\");</script>");

PreparedStatement pstmt		= null;
ResultSet rs				= null;
Statement stmt_bl			= null;
ResultSet rs_bl				= null;
Boolean isDischargeDateApplicable = false ;// Added for ML-MMOH-CRF-1499 on 15-APR-2020 By KAMATCHI S
Connection conn = ConnectionManager.getConnection(request);	
//Statement stmt = conn.createStatement();
try
{
		isDischargeDateApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "DISCHARGE_DATE_APPLICABLE");// Added for ML-MMOH-CRF-1499 on 15-APR-2020 By KAMATCHI S
		/*String tmp_stg_no="";
		String sql20="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+loginUser+"' AND FACILITY_ID='"+FacilityId+"'";
		pstmt = conn.prepareStatement(sql20);
		rs = pstmt.executeQuery();	

		while(rs.next()){
		tmp_stg_no = rs.getString("STAGE_NO");

		}



		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		if(tmp_stg_no.equals("")){

		String sql_st="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP WHERE SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC";
		pstmt = conn.prepareStatement(sql_st);

		rs = pstmt.executeQuery();	

		if(rs.next()){
		stage_no = rs.getString("STAGE_NO");

		}



		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();

		}else{
		stage_no=tmp_stg_no;
		}
		*/

		//Check for bl_interfaced_yn condition.......added by kishore
		/*
			if(!modal_yn.equals("Y"))
		{
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from IP_PARAM where facility_id='"+FacilityId+"'";
		try
		{
		stmt_bl=conn.createStatement();
		rs_bl=stmt_bl.executeQuery(query_bl_interface);
		if(rs_bl.next())
		{
		install_yn=rs_bl.getString("bl_interfaced_yn");
		}

		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		}	
		*/
		/*try{
			stmt_bl=conn.createStatement();
			rs_bl=stmt_bl.executeQuery("SELECT ACTION_IF_NOT_DONE FROM mr_recode_privi_setup WHERE  STAGE_NO='"+stage_no+"'");
			if (rs_bl.next() && rs_bl != null){
				recode_action = rs_bl.getString(1);
			}
			if(rs_bl!=null) rs_bl.close();
			if(stmt_bl!=null) stmt_bl.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			if(rs_bl!=null) rs_bl.close();
			if(stmt_bl!=null) stmt_bl.close();
		}
		*/
		%>
		<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
		<HTML>
				<head>
					<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
					<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eMR/js/DiagProcedureRecoding.js" language="javascript"></script>
					<script src="../../eOA/js/QueryLocnForDay.js" language="javascript"></script>
					<script src="../../eOP/js/menu.js" language="javascript"></script>
					<script src="../../eCommon/js/common.js" language="javascript"></script>
					<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
				</head>
				<body OnMouseDown='CodeArrest();' onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown='lockKey()'>
						<form name='DiagProcedureRecodingResult' id='DiagProcedureRecodingResult'  action="../../eMR/jsp/DiagProcedureRecodingResult.jsp" method="post"  >
								<%
								String flagSelect = checkForNull(request.getParameter("clear"));

								if(!flagSelect.equals(""))
								MedicalReportReq.clearAll();

								if(from != null && to != null){
									int j=0;
									for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
										if(request.getParameter("select_chk"+(i)) != null){
											checkedOnes = request.getParameter("select_val"+(i));
											if(!(MedicalReportReq.containsObject(checkedOnes))){
												MedicalReportReq.putObject(checkedOnes);
											}
											j++;
										}
									}	
									out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
									out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
								}
								i = 1 ;
								StringBuffer strbuff = new StringBuffer();
								//String Where  = "";
								//Where  = " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ";
								//strbuff.append(" where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"'");
								strbuff.append(" where a.facility_id='"+FacilityId+"'");
								if(!PatientId.equals("")){
									//Where  = Where +" and b.patient_id like '"+PatientId+"' ";
									strbuff.append("and a.patient_id = '"+PatientId+"'");
								}
								
								if ( !(Enc_Type == null || Enc_Type.equals("")) ){
									//Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"') ";
									strbuff.append("and a.PATIENT_CLASS = '"+Enc_Type+"'");
								}

								if ( !(speciality_val == null || speciality_val.equals("")) ){
									//Where = Where + " and a.SPECIALTY_CODE like upper('"+speciality_val+"')  ";
									if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
										strbuff.append("and a.SPECIALTY_CODE = '"+speciality_val+"'");
									}else{
										strbuff.append("and a.SPECIALITY_CODE = '"+speciality_val+"'");
									}
								}

								if(Enc_Type.equals("IP") || Enc_Type.equals("DC") || Enc_Type.equals("EM") || Enc_Type.equals("OP")){
									//if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) ){
										//Where  = Where +" and trunc(a.DISCHARGE_DATE_TIME) >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy')";
											strbuff.append("and trunc(a.DISCHARGE_DATE_TIME) between to_date('"+p_discharge_date_from+"','dd/mm/yyyy') and to_date('"+p_discharge_date_to+"','dd/mm/yyyy')");
									//}
									//if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) ){
										//Where  = Where +" and trunc(a.DISCHARGE_DATE_TIME) <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy')";
										//strbuff.append("and trunc(a.DISCHARGE_DATE_TIME) <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy')");
									//}				
								}


								if ( !(location_code == null || location_code.equals("")) ){
									//Where = Where + " and a.Assign_Care_Locn_Code like upper('"+location_code+"')  ";
									if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
											strbuff.append("and a.nursing_unit_Code = '"+location_code+"'");
									}else{
										strbuff.append("and a.Locn_Code = '"+location_code+"'");
									}
								}

								if ( !(EncounterId == null || EncounterId.equals("")) ){
									//Where = Where + " and upper(a.encounter_id) like upper('"+EncounterId+"%') ";
									strbuff.append("and a.encounter_id='"+EncounterId+"'");
								}

								if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals(""))){
									//Where = Where + " and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
									if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
										strbuff.append("and a.admission_date_time between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy') +0.9999");
									}else{
										strbuff.append("and a.queue_date between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy') +0.9999");
									}
								}

								if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && (alt_id2_exp_date == null || alt_id2_exp_date.equals(""))){
									//Where = Where + " and trunc(a.visit_adm_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')";
									if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
										strbuff.append("and trunc(a.admission_date_time) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')");
									}else{
										strbuff.append("and trunc(a.queue_date) >= to_date('"+alt_id1_exp_date+"','dd/mm/yyyy')");
									}
								}
								if ( (alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals(""))){
									//Where = Where + " and trunc(a.visit_adm_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
									if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
										strbuff.append("and trunc(a.admission_date_time) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
									}else{
										strbuff.append("and trunc(a.queue_date) <= to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')");
									}
								}
								//Where  = Where +"   and (a.facility_id,a.Assign_Care_Locn_Type,a.Assign_Care_Locn_Code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id =(select OPER_STN_ID from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+FacilityId+"' and facility_id='"+FacilityId+"' AND trunc(SYSDATE) BETWEEN trunc (NVL(eff_date_from,SYSDATE))AND trunc (NVL(eff_date_to,SYSDATE))) and appl_user_id = '"+loginUser+"' ";
								
								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
									strbuff.append("and (a.facility_id,'N',a.nursing_unit_Code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id =(select OPER_STN_ID from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+FacilityId+"' and facility_id='"+FacilityId+"' AND trunc(SYSDATE) BETWEEN trunc (NVL(eff_date_from,SYSDATE))AND trunc (NVL(eff_date_to,SYSDATE))) and appl_user_id = '"+loginUser+"'");
								}else{
									strbuff.append("and (a.facility_id,a.Locn_Type,a.Locn_Code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id =(select OPER_STN_ID from am_user_for_oper_stn where appl_user_id='"+loginUser+"' and facility_id='"+FacilityId+"' and facility_id='"+FacilityId+"' AND trunc(SYSDATE) BETWEEN trunc (NVL(eff_date_from,SYSDATE))AND trunc (NVL(eff_date_to,SYSDATE))) and appl_user_id = '"+loginUser+"'");
								}

								

								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
								//Where  = Where +" and diag_proc_recode_for_ip_yn = 'Y'  ) ";
								strbuff.append("and diag_proc_recode_for_ip_yn = 'Y'  )");
								}
								if(Enc_Type.equals("EM") || Enc_Type.equals("OP")){
								//Where  = Where +" and  DIAG_PROC_RECODE_FOR_OP_YN='Y'  ) ";
								strbuff.append("and  DIAG_PROC_RECODE_FOR_OP_YN='Y'  )");
								}
								strbuff.append(" AND A.FACILITY_ID=MR_HDR.FACILITY_ID AND A.ENCOUNTER_ID= MR_HDR.ENCOUNTER_ID ");
								if(!stage_no.equals("1") && recode_action.equals("S")){
									search_by="M";
								}


								if(status.equals("")){
									//Where  = Where +" AND EXISTS(SELECT facility_id, encounter_id FROM MR_DIAG_PROC_RECODING_HDR WHERE patient_id=a.patient_id AND facility_id = a.facility_id AND encounter_id = a.encounter_id and status!='E')  ";
									strbuff.append("AND EXISTS(SELECT facility_id, encounter_id FROM MR_DIAG_PROC_RECODING_HDR WHERE patient_id=a.patient_id AND facility_id = a.facility_id AND encounter_id = a.encounter_id and status!='E')");
								}else if(status.equals("PR")){
									if(search_by.equals("M") || search_by.equals("S")) {
										if(stage_no.equals("1")) {
											//Where  = Where +" AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((  nvl(proc_dtl.contr_mod_id,'**') != 'OT'  and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level2_status is null and d.level3_status is null and (d.level1_status is null and d.curr_level = 0) )  ";
											strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");

											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y')) ");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((  nvl(proc_dtl.contr_mod_id,'**') != 'OT'  and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))
												
											strbuff.append(" and d.level2_status is null and d.level3_status is null and (d.level1_status is null and d.curr_level = 0) )");
										}else if(stage_no.equals("2")) {
											//Where  = Where +" AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) AND level3_status IS NULL AND (   (level1_status = 'C' AND level2_status IS NULL) OR (    (level2_status IS NULL and(level1_status IS NULL OR level1_status = 'S')) AND EXISTS (select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	)) )  ";
											strbuff.append("AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");
											}
											
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											strbuff.append(" AND level3_status IS NULL AND (   (level1_status = 'C' AND level2_status IS NULL) OR (    (level2_status IS NULL and(level1_status IS NULL OR level1_status = 'S')) AND EXISTS (select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	)) )");

										}else if(stage_no.equals("3")) {
											//Where  = Where +" AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and level3_status is null and (level1_status = 'C' or ((level1_status is null or level1_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end)))	or (level2_status = 'C' or ((level2_status is null or level2_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 2 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	)) ))  ";
											strbuff.append("AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											strbuff.append("  and level3_status is null and (level1_status = 'C' or ((level1_status is null or level1_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end)))	and (level2_status = 'C' or ((level2_status is null or level2_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 2 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	)) ))");
										}
									} else if(search_by.equals("A")) {
										if(stage_no.equals("2")) {
											//Where  = Where +"AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and (d.level2_status is null and d.level3_status is null and ((d.level1_status is null and d.curr_level = 0)) or (d.level1_status = 'C' and d.level2_status is null or (level2_status IS NULL and (d.level1_status is null or d.level1_status = 'S') 	)) ) )   ";
											//					strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and (d.level2_status is null and d.level3_status is null and ((d.level1_status is null and d.curr_level = 0)) or (d.level1_status = 'C' and d.level2_status is null or (level2_status IS NULL and (d.level1_status is null or d.level1_status = 'S') 	)) ) )  ");
											strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											
											//strbuff.append("and (d.level2_status is null and d.level3_status is null /*and ((d.level1_status is null and d.curr_level = 0))*/ or (d.level1_status = 'C' and d.level2_status is null or (level2_status IS NULL and (d.level1_status is null or d.level1_status = 'S') 	)) ) ) AND EXISTS (select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )  ");

											strbuff.append(" AND level3_status IS NULL AND ((level1_status = 'C' AND level2_status IS NULL) OR (    (level2_status IS NULL and(level1_status IS NULL OR (level1_status = 'S'  and not exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1)) and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)) )))))) ");


										}else if(stage_no.equals("3")) {
											//Where  = Where +" AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and level3_status is null and (level1_status = 'C' or ((level1_status is null or level1_status = 'S') )	or (level2_status = 'C' or ((level2_status is null or level2_status = 'S') 	)) ))  ";
											strbuff.append("AND EXISTS (SELECT facility_id, encounter_id from mr_diag_proc_recoding_hdr where FACILITY_ID = a.FACILITY_ID AND ENCOUNTER_ID = a.ENCOUNTER_ID and status!='E' ");
											
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											
											strbuff.append(" and level3_status is null and (level1_status = 'C' or ((level1_status is null or (level1_status = 'S' and  not exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1)) and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)) )) or (level2_status = 'C' or ((level2_status is null or (level2_status = 'S' and not exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=2)) and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)))))))))");

//											strbuff.append(" and level3_status is null and (level1_status = 'C' or ((level1_status is null or level1_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 1 and                    trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end))) AND (level2_status = 'C' or ((level2_status is null or level2_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 2 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then  trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else                    trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	))))") 	;

											//strbuff.append(" and level3_status is null and (level1_status = 'C' or ((level1_status is null or level1_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 1 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end)))	or (level2_status = 'C' or ((level2_status is null or level2_status = 'S') and exists( select 1 from mr_recode_privi_setup where stage_no = 2 and  trunc(sysdate) >= (case when a.patient_class In ('OP','EM') then trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_vstcmpl else trunc(a.discharge_date_time) +  cf_pr_fr_recode_dys_fm_disc  end) )	)) ))");

										}
									}
								}else if(status.equals("PC") || search_by.equals("S")){
									if(search_by.equals("M")) {
												if(stage_no.equals("1")) {
													//Where  = Where +"AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and (d.level2_status is null and d.level3_status is null and (d.level1_status IN ('S','R'))) ) ";
													strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
													
													if(allow_recode_proc_yn.equals("N")){
														strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
													}

													if(allow_recode_diag_yn.equals("N")){

														strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

														if(allow_ot_proc_recode_yn.equals("N")){
															strbuff.append(" and  contr_mod_id != 'OT' )");
														}

														if(allow_non_ot_proc_recode_yn.equals("N")){

															strbuff.append(" and  contr_mod_id = 'OT' )");
														}

														if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
															strbuff.append(")");
														}

														strbuff.append(")");

													}
													//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
														
													
													strbuff.append(" and (d.level2_status is null and d.level3_status is null and (d.level1_status IN ('S','R'))) )");
												}else if(stage_no.equals("2")) {
													//Where  = Where +"AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and (d.level3_status is null and (d.level2_status IN ('S','R'))) ) ";
													strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
													
													if(allow_recode_proc_yn.equals("N")){
														strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
													}

													if(allow_recode_diag_yn.equals("N")){

														strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

														if(allow_ot_proc_recode_yn.equals("N")){
															strbuff.append(" and  contr_mod_id != 'OT' )");
														}

														if(allow_non_ot_proc_recode_yn.equals("N")){

															strbuff.append(" and  contr_mod_id = 'OT' )");
														}

														if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
															strbuff.append(")");
														}

														strbuff.append(")");

													}
													
													//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
														
													
													strbuff.append(" and (d.level3_status is null and (d.level2_status IN ('S','R'))) ) ");
												}else if(stage_no.equals("3")) {
													//Where  = Where +"AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level3_status IN ('S','R') ) ";
													strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
													
													if(allow_recode_proc_yn.equals("N")){
														strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
													}

													if(allow_recode_diag_yn.equals("N")){

														strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

														if(allow_ot_proc_recode_yn.equals("N")){
															strbuff.append(" and  contr_mod_id != 'OT' )");
														}

														if(allow_non_ot_proc_recode_yn.equals("N")){

															strbuff.append(" and  contr_mod_id = 'OT' )");
														}

														if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
															strbuff.append(")");
														}

														strbuff.append(")");

													}

													//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))
														
													strbuff.append("  and d.level3_status IN ('S','R') ) ");
												}
											}else if(search_by.equals("A")) {
												if(stage_no.equals("2")) {
													//Where  = Where +"AND EXISTS (SELECT d.facility_id, d.encounter_id FROM mr_diag_proc_recoding_hdr d WHERE d.facility_id = a.facility_id AND d.encounter_id = a.encounter_id AND d.status != 'E'   and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) AND ((    d.level2_status IS NULL AND d.level3_status IS NULL AND d.level1_status IN ('S','R')) OR     (d.level3_status IS NULL AND d.level2_status IN ('S','R')))) ";

													strbuff.append("AND EXISTS (SELECT d.facility_id, d.encounter_id FROM mr_diag_proc_recoding_hdr d WHERE d.facility_id = a.facility_id AND d.encounter_id = a.encounter_id AND d.status != 'E' ");
													
													if(allow_recode_proc_yn.equals("N")){
														strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
													}

													if(allow_recode_diag_yn.equals("N")){

														strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

														if(allow_ot_proc_recode_yn.equals("N")){
															strbuff.append(" and  contr_mod_id != 'OT' )");
														}

														if(allow_non_ot_proc_recode_yn.equals("N")){

															strbuff.append(" and  contr_mod_id = 'OT' )");
														}

														if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
															strbuff.append(")");
														}

														strbuff.append(")");

													}

													//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
														
													strbuff.append("  AND ((d.level2_status IS NULL AND d.level3_status IS NULL AND (d.level1_status IN ('S') and exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) > trunc(sysdate-(SELECT  "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1)) and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)) ) OR  (d.level3_status IS NULL AND d.level2_status IN ('S','R')))))");
												}else if(stage_no.equals("3")) {
													//Where  = Where +"AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and ((d.level2_status is null and d.level3_status is null and d.level1_status IN ('S','R')) or(d.level3_status is null and d.level2_status IN ('S','R')) or(d.level3_status IN ('S','R'))) ) ";
													strbuff.append("AND EXISTS (SELECT d.FACILITY_ID, d.ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
													
													if(allow_recode_proc_yn.equals("N")){
														strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
													}

													if(allow_recode_diag_yn.equals("N")){

														strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

														if(allow_ot_proc_recode_yn.equals("N")){
															strbuff.append(" and  contr_mod_id != 'OT' )");
														}

														if(allow_non_ot_proc_recode_yn.equals("N")){

															strbuff.append(" and  contr_mod_id = 'OT' )");
														}

														if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
															strbuff.append(")");
														}

														strbuff.append(")");

													}
													//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
														
													//strbuff.append("  and ((d.level2_status is null and d.level3_status is null and d.level1_status IN ('S','R')) or(d.level3_status is null and d.level2_status IN ('S','R')) or(d.level3_status IN ('S','R'))) )");
													strbuff.append("  AND ((d.level2_status IS NULL AND d.level3_status IS NULL AND (d.level1_status IN ('S') and exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) > trunc(sysdate-(SELECT  "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1)) and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)) ) OR  (d.level3_status IS NULL AND (d.level2_status IN ('S') and exists (select 1 from dual where trunc(A.DISCHARGE_DATE_TIME) >trunc(sysdate-(SELECT  "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=2))and trunc(A.DISCHARGE_DATE_TIME) <= trunc(sysdate)) ) )))) ");
												}
										}
								}
								else if(status.equals("C")){
									if(search_by.equals("M")) {
										if(stage_no.equals("1")) {
											//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level2_status is null and d.level3_status is null and (d.level1_status = 'C') ) ";
											strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
													
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											strbuff.append("  and d.level2_status is null and d.level3_status is null and (d.level1_status = 'C') )");
										}else if(stage_no.equals("2")) {
											//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level3_status is null and (d.level2_status = 'C') ) ";
											strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											strbuff.append(" and d.level3_status is null and (d.level2_status = 'C') )");
										}else if(stage_no.equals("3")) {
											//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))and d.level3_status = 'C' ) ";
											strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))
												
											strbuff.append(" and d.level3_status = 'C' )");
										}
									}
								}
								else if(status.equals("A")){
									if(search_by.equals("M") || search_by.equals("S")) {
									if(stage_no.equals("1")) {
										//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level2_status is null and d.level3_status is null and (d.level1_status = 'A') ) ";
										strbuff.append(" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
										
										if(allow_recode_proc_yn.equals("N")){
											strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
										}

										if(allow_recode_diag_yn.equals("N")){

											strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

											if(allow_ot_proc_recode_yn.equals("N")){
												strbuff.append(" and  contr_mod_id != 'OT' )");
											}

											if(allow_non_ot_proc_recode_yn.equals("N")){

												strbuff.append(" and  contr_mod_id = 'OT' )");
											}

											if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
												strbuff.append(")");
											}

											strbuff.append(")");

										}
										//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
											
										strbuff.append(" and d.level2_status is null and d.level3_status is null and (d.level1_status = 'A') )");
									}else if(stage_no.equals("2")) {
										//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level3_status is null and (d.level2_status = 'A') ) ";
										strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
										
										if(allow_recode_proc_yn.equals("N")){
											strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
										}

										if(allow_recode_diag_yn.equals("N")){

											strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

											if(allow_ot_proc_recode_yn.equals("N")){
												strbuff.append(" and  contr_mod_id != 'OT' )");
											}

											if(allow_non_ot_proc_recode_yn.equals("N")){

												strbuff.append(" and  contr_mod_id = 'OT' )");
											}

											if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
												strbuff.append(")");
											}

											strbuff.append(")");

										}
										//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))
											
										strbuff.append(" and d.level3_status is null and (d.level2_status = 'A') )");
									}else if(stage_no.equals("3")) {
										//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and d.level3_status = 'A' ) ";
										strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
										
										if(allow_recode_proc_yn.equals("N")){
											strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
										}

										if(allow_recode_diag_yn.equals("N")){

											strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

											if(allow_ot_proc_recode_yn.equals("N")){
												strbuff.append(" and  contr_mod_id != 'OT' )");
											}

											if(allow_non_ot_proc_recode_yn.equals("N")){

												strbuff.append(" and  contr_mod_id = 'OT' )");
											}

											if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
												strbuff.append(")");
											}

											strbuff.append(")");

										}
										//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
											
										strbuff.append(" and d.level3_status = 'A' ) ");
									}
									}else if(search_by.equals("A")) {
										if(stage_no.equals("2")) {
											//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))  and ((d.level2_status is null and d.level3_status is null and d.level1_status = 'A') or (d.level3_status is null and d.level2_status = 'A')) ) ";
											strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y'))))  
												
											strbuff.append(" and ((d.level2_status is null and d.level3_status is null and d.level1_status = 'A') or (d.level3_status is null and d.level2_status = 'A')) )");
										} else if(stage_no.equals("3")) {

											//Where  = Where +" AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E'  and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) and ((d.level2_status is null and d.level3_status is null and d.level1_status = 'A') or (d.level3_status is null and d.level2_status = 'A') or d.level3_status = 'A')) ";
											strbuff.append("AND EXISTS (SELECT FACILITY_ID, ENCOUNTER_ID from mr_diag_proc_recoding_hdr d where  d.FACILITY_ID = a.FACILITY_ID AND d.ENCOUNTER_ID = a.ENCOUNTER_ID and d.status!='E' ");
											
											if(allow_recode_proc_yn.equals("N")){
												strbuff.append("and (exists ( select 1 from mr_diagnosis_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id and ACTIVE_YN='Y'))");
											}

											if(allow_recode_diag_yn.equals("N")){

												strbuff.append("and (exists ( select 1 from mr_procedure_recoding_dtl where facility_id = a.facility_id and encounter_id = a.encounter_id  and ACTIVE_YN='Y'  ");

												if(allow_ot_proc_recode_yn.equals("N")){
													strbuff.append(" and  contr_mod_id != 'OT' )");
												}

												if(allow_non_ot_proc_recode_yn.equals("N")){

													strbuff.append(" and  contr_mod_id = 'OT' )");
												}

												if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
													strbuff.append(")");
												}

												strbuff.append(")");

											}
											
											//and (exists ( select 1 from mr_diagnosis_recoding_dtl, mr_parameter param where facility_id = a.facility_id and encounter_id = a.encounter_id and param.ALLOW_RECODE_DIAG_YN = 'Y' and ACTIVE_YN='Y') or exists (SELECT 1 FROM mr_procedure_recoding_dtl proc_dtl, mr_parameter param WHERE proc_dtl.facility_id = a.facility_id   AND proc_dtl.encounter_id = a.encounter_id AND param.allow_recode_proc_yn = 'Y' AND proc_dtl.active_yn = 'Y' AND ((nvl(proc_dtl.contr_mod_id,'**') != 'OT' and param.ALLOW_NON_OT_PROC_RECODE_YN ='Y') OR (proc_dtl.CONTR_MOD_ID ='OT' and param.ALLOW_OT_PROC_RECODE_YN ='Y')))) 
												
											strbuff.append("  and ((d.level2_status is null and d.level3_status is null and d.level1_status = 'A') or (d.level3_status is null and d.level2_status = 'A') or d.level3_status = 'A'))");
										}
									}
								} 
								
								if ( !(national_id_no == null || national_id_no.equals("")) ){
									//Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
									strbuff.append("and upper(b.NATIONAL_ID_NO) = upper('"+national_id_no+"%')");
									join_mp_pat="Y";
								}
								if ( !(alt_id1_no == null || alt_id1_no.equals("")) ){
									//Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
									strbuff.append("and upper(b.alt_id1_no) = upper('"+alt_id1_no+"%')");
									join_mp_pat="Y";
								}
								if ( !(alt_id2_no == null || alt_id2_no.equals("")) ){
									//Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
									strbuff.append("and upper(b.alt_id2_no) = upper('"+alt_id2_no+"%') ");
									join_mp_pat="Y";
								}
								if ( !(alt_id3_no == null || alt_id3_no.equals("")) ){
									//Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
									strbuff.append("and upper(b.alt_id3_no) = upper('"+alt_id3_no+"%')");
									join_mp_pat="Y";
								}
								if ( !(alt_id4_no == null || alt_id4_no.equals("")) ){
									//Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
									strbuff.append("and upper(b.alt_id4_no) = upper('"+alt_id4_no+"%')");
									join_mp_pat="Y";
								}

								if ( !(other_alt_type == null || other_alt_type.equals("")) ){
									//Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
									strbuff.append("and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%')");
									join_mp_pat="Y";
								}
								if ( !(other_alt_Id == null || other_alt_Id.equals(""))){
									//Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
									strbuff.append("and upper(b.oth_alt_Id_no) = upper('"+other_alt_Id+"%')");
									join_mp_pat="Y";
								}

								if(join_mp_pat.equals("Y")){
									strbuff.append(" and a.patient_id=b.patient_id ");
								}
								if ( !(orderBy == null || orderBy.equals("")) ){
									//Where = Where + " order by "+orderBy+" ";
									strbuff.append("order by "+orderBy+" ");
								}

//								int maxRecord = 0;
								if(!modal_yn.equals("Y"))
								{
								if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
								/*sqlbuff.append("select count(1) from  PR_ENCOUNTER a, MP_PATIENT b");

								//if(!call_function.equals("DIAG_RECODE"))
								sqlbuff.append(strbuff.toString());
								//	else
								//		sqlbuff.append(recode_where.toString());

								if(rs != null)rs.close();
								if(pstmt  != null)pstmt.close();
								
								pstmt = conn.prepareStatement(sqlbuff.toString());
								rs = pstmt.executeQuery();
								if(rs.next())
								maxRecord = rs.getInt(1);*/

								}
								if(rs != null)rs.close();
								if(pstmt  != null)pstmt.close();

								if(stage_no.equals("")){%>
									<script>
										alert(getMessage("RECODE_PRIVILEGE_NOT_DEFINED","MR"));parent.frames[2].location.href='../../eCommon/html/blank.html';document.location.href='../../eCommon/jsp/dmenu.jsp';
									</script> 	
								<%}
								//out.println("k====****"+k);
//								StringBuffer sqlCount=new StringBuffer();
								/*sqlCount.append("select count(*) count FROM PR_ENCOUNTER a, MP_PATIENT b");
								//sqlCount.append(Where);
								//if(!call_function.equals("DIAG_RECODE"))
								sqlCount.append(strbuff.toString());
								//else
								//	sqlCount.append(recode_where.toString());
								pstmt = conn.prepareStatement(sqlCount.toString());
								rs = pstmt.executeQuery();
								rs.next();
								fetchRecord=rs.getString("count");
								int fetchRecord1=Integer.parseInt(fetchRecord);*/
								
								
								//sqlbuff.append(" SELECT   a.Patient_Id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy') Discharge_Date_Time FROM PR_ENCOUNTER a");

								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
									sqlbuff.append(" SELECT   a.Patient_Id, To_char(a.admission_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2')  Speciality_desc, a.Specialty_Code Specialty_Code, ");
								}else{
									sqlbuff.append(" SELECT   a.Patient_Id, To_char(a.queue_date,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, AM_GET_DESC.AM_SPECIALITY(a.Speciality_Code,'"+locale+"','2')  Speciality_desc, a.Speciality_Code Specialty_Code, ");
								}
									
								
								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
									sqlbuff.append("IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.nursing_unit_Code,'"+locale+"','2') Locn_desc,a.nursing_unit_Code Locn_Code,");
								}else{
									sqlbuff.append("OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Locn_Code,'"+locale+"','1') Locn_desc,a.Locn_Code Locn_Code,");
								}
									
								 
									
								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
									sqlbuff.append("AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1')  Practitioner_Name,a.attend_practitioner_id, a.Room_num Room_No, a.Bed_num Bed_No,");
								}else{
									
									sqlbuff.append("AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_Id,'"+locale+"','1')  Practitioner_Name,a.practitioner_id attend_practitioner_id, a.Room_num Room_No, a.ae_bed_no Bed_No,");
								}

								//Added for this SCF SKR-SCF-0972 [IN:047723]
								if(Enc_Type.equals("IP") || Enc_Type.equals("DC")){
									sqlbuff.append("AM_GET_DESC.AM_CARE_LOCN_TYPE('N','"+locale+"','1') Locn_Type,'N' loc_type, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy') Discharge_Date_Time,To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_datetime_display,mr_hdr.LEVEL1_STATUS,mr_hdr.LEVEL2_STATUS,mr_hdr.LEVEL3_STATUS,  COUNT(*) OVER () rowCount FROM IP_PATIENT_LAST_ENCOUNTER a,MR_DIAG_PROC_RECODING_HDR mr_hdr");

								}else{
									sqlbuff.append("AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Locn_Type,'"+locale+"','1') Locn_Type,a.Locn_Type loc_type, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy') Discharge_Date_Time,To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_datetime_display,mr_hdr.LEVEL1_STATUS,mr_hdr.LEVEL2_STATUS,mr_hdr.LEVEL3_STATUS,  COUNT(*) OVER () rowCount FROM OP_PATIENT_QUEUE a,MR_DIAG_PROC_RECODING_HDR mr_hdr");
								}
								
								if(join_mp_pat.equals("Y")){
									sqlbuff.append(", MP_PATIENT b ");
								}
								sqlbuff.append(strbuff.toString());
							
								//		stmt = conn.prepareStatement(sqlbuff.toString());
								/*rs = stmt.executeQuery(sqlbuff.toString());
								rs.last();
								fetchRecord = rs.getRow();
								rs.beforeFirst();*/
								//stmt_bl=conn.createStatement();
								System.out.println(" ********************* Inside DiagProcedureRecodingResult JSP 1226 sqlbuff.toString() : "+sqlbuff.toString());
								pstmt = conn.prepareStatement(sqlbuff.toString());
								rs		 = pstmt.executeQuery();
								int maxRecords=0;
								int nRowCount =0; //Added this line SKR-SCF-0972 [IN:047723]
								//		int fetchRecord1=Integer.parseInt(fetchRecord);
//								int fetchRecord1=fetchRecord;
				
						//		out.println("fetchRecord===="+fetchRecord);
						//		out.println("fetchRecord1===="+fetchRecord1);
							%>
										<script>
											if(parent.document.getElementById('frmst_1'))	
											parent.document.getElementById('frmst_1').rows='0%,0%,15%,*%,10%,0%,0%'
										</script>
										<%
										if(!title.equals("")){
											out.println("<title>"+title+"</title>");
										}
										if(call_from.equals("MAIN")){
											title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterdetails.label","common_labels");
											out.println("<title>"+title+"</title>");
										}
										//	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
										/*		sqlbuff.append("select a.patient_id, b.patient_name, decode(b.sex,'M','Male','F','Female','U','Unknown')gender,");
										sqlbuff.append(" to_char(b.date_of_birth,'dd/mm/yy')birth_date,  ");
										sqlbuff.append(" to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date,");
										sqlbuff.append(" a.encounter_id, (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality WHERE speciality_code = a.specialty_code)END) speciality_desc,");
										sqlbuff.append(" a.specialty_code specialty_code,");
										sqlbuff.append("(CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) WHEN assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) END ) locn_desc,");
										sqlbuff.append(" a.assign_care_locn_code locn_code,");
										sqlbuff.append("(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name, a.assign_room_num room_no, a.assign_bed_num bed_no, DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit') locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,(CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END ) patient_class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b ");
										*/

										//old - sqlbuff.append(" SELECT a.Patient_Id, b.Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yy') Birth_Date, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc, a.Specialty_Code Specialty_Code, (CASE WHEN a.Assign_Care_Locn_Type = 'C' THEN OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','2') WHEN Assign_Care_Locn_Type = 'N' THEN IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2') END) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, (CASE WHEN a.Patient_Class IS NOT NULL  THEN AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') END) Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yy hh24:mi') Discharge_Date_Time FROM PR_ENCOUNTER a, MP_PATIENT b ");

										//sqlbuff.append(" SELECT a.Patient_Id, b.Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yy') Birth_Date, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+locale+"','2') Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type,'N',(IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE, '"+locale+"', '2'),   OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','2')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1')Practitioner_Name, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,'"+locale+"','1') Locn_Type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yy hh24:mi') Discharge_Date_Time FROM   PR_ENCOUNTER a, MP_PATIENT b ");

										//sqlbuff.append(" SELECT   a.Patient_Id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time FROM PR_ENCOUNTER a, MP_PATIENT b ");
										/*Commented On 10/24/2009 For Open Connection Issues.
										if(rs != null)rs.close();
										if(pstmt  != null)pstmt.close();*/
										/*StringBuffer sqlCount=new StringBuffer();
										sqlCount.append("select count(*) count FROM PR_ENCOUNTER a, MP_PATIENT b");
										//sqlCount.append(Where);
										//if(!call_function.equals("DIAG_RECODE"))
										sqlCount.append(strbuff.toString());
										//else
										//	sqlCount.append(recode_where.toString());

										pstmt = conn.prepareStatement(sqlCount.toString());
										rs = pstmt.executeQuery();
										rs.next();
										fetchRecord=rs.getString("count");
										// out.println("fetchRecord===="+fetchRecord);*/

										//		sqlbuff.append(" SELECT   a.Patient_Id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))Patient_Name, b.Sex Gender, To_char(b.Date_Of_Birth,'dd/mm/yyyy') Birth_Date, GET_AGE(b.DATE_OF_BIRTH) AGE, To_char(a.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Encounter_Date, a.Encounter_Id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc, a.Specialty_Code Specialty_Code, DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','1')) Locn_desc, a.Assign_Care_Locn_Code Locn_Code, (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name,(CASE WHEN a.Attend_Practitioner_Id IS NOT NULL THEN (select pract_type from am_practitioner where practitioner_id=a.Attend_Practitioner_Id) ELSE '' END) Pract_type,a.attend_practitioner_id, a.Assign_Room_num Room_No, a.Assign_Bed_num Bed_No, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type,a.Assign_Care_Locn_Type loc_type, b.alt_Id1_No alt_Id1_No, b.alt_Id2_No alt_Id2_No, b.alt_Id3_No alt_Id3_No, b.alt_Id4_No alt_Id4_No, AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.Patient_Class Patient_Class_Code, To_char(a.Discharge_Date_Time,'dd/mm/yyyy') Discharge_Date_Time FROM PR_ENCOUNTER a, MP_PATIENT b ");

										//		sqlbuff.append(strbuff.toString());
										/*if(!call_function.equals("DIAG_RECODE"))
										sqlbuff.append(Where);
										else
										sqlbuff.append(recode_where.toString());*/
										/*if(rs != null)rs.close();
										if(pstmt  != null)pstmt.close();
										pstmt = conn.prepareStatement(sqlbuff.toString());
										rs = pstmt.executeQuery();*/
										if(!flag.equals("true")){%>
											<table width='100%' id="navigate_table" style="display:none">
												<tr>
													<table align='right' border='0' >
														<tr>
														<%
															if ( !(start <= 1)){%>
															<td align ='right' id='prev'><A HREF='javascript:submitPrevNext("<%=(start-10)%>","<%=(end-10)%>","Previous")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>				
															<%}%>
															<td align ='right' id='next' style="display:none"><A HREF='javascript:submitPrevNext("<%=(start+10)%>","<%=(end+10)%>","Next")' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
														</tr>
													</table>
												</tr>
											</table>
											<br>
											<br>
											<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
												<thead id="table_header" style="display:">
													<th align='center' nowrap>&nbsp;</th>
													<th align='center' nowrap><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
													<% if(isDischargeDateApplicable){// Added for ML-MMOH-CRF-1499 on 15-APR-2020 By KAMATCHI S %>
													<th align='center' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
													<% } %>
													<th align='center' nowrap><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></th>
													<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
												</thead>
												<br>
										<%
											String chkAttribute = "";
											if (rs != null){
												if ( start != 1 ){
													for( int j=1; j<start; i++,j++ ){
														
														rs.next() ;
													}
												}
												while(rs.next() && i<=end){
													nRowCount = Integer.parseInt(rs.getString("rowCount"));//Added for this SCF SKR-SCF-0972 [IN:047723]
													if(maxRecords==0){
														%>
														<SCRIPT LANGUAGE="JavaScript">
														<!--
															document.getElementById("navigate_table").style.display="inline";
															document.getElementById("table_header").style.display="";
														//-->
														</SCRIPT>
													<%}
													if ( i % 2 == 0 ){
														classValue = "QRYEVENSMALL" ;
													}else{
														classValue = "QRYODDSMALL" ;
													}
													Patient_ID=rs.getString("patient_id");	
													//String Patient_Name=rs.getString("patient_name");				
													//String conGender=rs.getString("gender");				
													//String Date_of_Birth=rs.getString("birth_date");				
													//String Age=rs.getString("AGE");				
													String Patient_Class		=rs.getString("patient_class");	
													String Encounter_Date	=rs.getString("encounter_date");
													Encounter_ID				=rs.getString("encounter_id");			
													String con_Speciality		=rs.getString("speciality_desc");
													String specialty_code	=checkForNull(rs.getString("specialty_code"));	
													String con_Location		=rs.getString("locn_desc");		
													String con_Practitioner	=rs.getString("practitioner_name");	
													attend_practitioner_id	=rs.getString("attend_practitioner_id");
													String room_no				=checkForNull(rs.getString("room_no"));	
													String bed_no				=checkForNull(rs.getString("bed_no"));	
													locn_type						=checkForNull(rs.getString("locn_type"));		
													locn_code						=rs.getString("locn_code");			
													String Encounter_Type = rs.getString("locn_type");
													String Patient_Class_code	 =rs.getString("patient_class_code");
													String level1_status = "";
													String level2_status = "";
													String level3_status = "";
													String Encounter_Date_display = "";
													String Dis_dateTime =	rs.getString("discharge_date_time");	
													String Discharge_datetime_display =	rs.getString("Discharge_datetime_display");	// Added for ML-MMOH-CRF-1499 By Kamatchi S on 21-APR-2020
													/*Modified on 9/23/2010 for SCF*/
													level1_status=checkForNull(rs.getString("LEVEL1_STATUS"));
													level2_status=checkForNull(rs.getString("LEVEL2_STATUS"));
													level3_status=checkForNull(rs.getString("LEVEL3_STATUS"));
													//String pract_type = checkForNull(rs.getString("Pract_type"));
													loc_type			=checkForNull(rs.getString("loc_type"));
													String pat_det=Patient_ID+"`"+Encounter_ID;
													if(MedicalReportReq.containsObject(pat_det))  
													chkAttribute = "CHECKED";
													else
													chkAttribute="";
													out.println("<input type='hidden' name='select_val"+i+"' id='select_val"+i+"' value='"+pat_det+"'>");
													int recordIndex = MedicalReportReq.indexOfObject(pat_det);
													if(recordIndex!=-1)
													if(chkAttribute.equals("CHECKED")){
															MedicalReportReq.removeObject(recordIndex);
													}
													String Lvl_disp="";
													/*if(call_function.equals("DIAG_RECODE") && search_by.equals("A")){
														stmt_bl=conn.createStatement();
														String level_st="select  LEVEL1_STATUS,LEVEL2_STATUS,LEVEL3_STATUS  from MR_DIAG_PROC_RECODING_HDR WHERE  FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+Encounter_ID+"'";
														
														rs_bl=stmt_bl.executeQuery(level_st);
														if (rs_bl.next() && rs_bl != null){
															level1_status = checkForNull(rs_bl.getString("LEVEL1_STATUS"));
															level2_status = checkForNull(rs_bl.getString("LEVEL2_STATUS"));
															level3_status = checkForNull(rs_bl.getString("LEVEL3_STATUS"));
														}
														if(rs_bl!=null) rs_bl.close();
														if(stmt_bl!=null) stmt_bl.close();*/
														String level_st="select 1 from dual where to_date('"+Dis_dateTime+"','dd/mm/yyyy') > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1)) and to_date('"+Dis_dateTime+"','dd/mm/yyyy') <= trunc(sysdate)";
														String level2_st="select 2 from dual where to_date('"+Dis_dateTime+"','dd/mm/yyyy') > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=1))  and to_date('"+Dis_dateTime+"','dd/mm/yyyy') <= trunc(sysdate) or  to_date('"+Dis_dateTime+"','dd/mm/yyyy') > trunc(sysdate-(SELECT "+time_period_col+"  FROM mr_recode_privi_setup where stage_no=2)) and  to_date('"+Dis_dateTime+"','dd/mm/yyyy') <= trunc(sysdate)";
														String level_status_ind="";
														if(search_by.equals("A")){
															if(stage_no.equals("2")){
																if(level1_status.equals("")|| level1_status.equals("S")){
																	stmt_bl=conn.createStatement();
																	rs_bl=stmt_bl.executeQuery(level_st);
																	if (rs_bl.next() && rs_bl != null){
																		level_status_ind=checkForNull(rs_bl.getString("1"));
																	}
																}
																if(level_status_ind.equals("1")){
																		Lvl_disp="pending1";
																}
															}else if(stage_no.equals("3")){
																if((level1_status.equals("")|| level1_status.equals("S"))||(level2_status.equals("")|| level2_status.equals("S"))){
																	stmt_bl=conn.createStatement();
																	rs_bl=stmt_bl.executeQuery(level2_st);
																	if (rs_bl.next() && rs_bl != null){
																		level_status_ind=checkForNull(rs_bl.getString("2"));
																	}
																}
																if(level_status_ind.equals("2")){
																		Lvl_disp="pending2";
																}

															}

																/*Lvl_disp="pending1";
																else if(level1_status.equals("S"))
																Lvl_disp="pc_l1";
																else if(level1_status.equals("A"))
																Lvl_disp="auth_l1";
																else if(level2_status.equals(""))
																Lvl_disp="pending2";
																else if(level2_status.equals("S"))
																Lvl_disp="pc_l2";
																else if(level2_status.equals("A"))
																Lvl_disp="auth_l2";
																else if(level3_status.equals(""))
																Lvl_disp="pending3";
																else if(level3_status.equals("S"))
																Lvl_disp="pc_l3";
																else if(level3_status.equals("A"))
																Lvl_disp="auth_l3";*/
																pat_det=pat_det+"`"+Lvl_disp;
																	//if(stage_no.equals("1")){
																	//pat_det=pat_det+level1_status;
																	//}else if(stage_no.equals("2")){
																	//pat_det=pat_det+level2_status;
																	//}else if(stage_no.equals("3")){
																	//pat_det=pat_det+level3_status;
																	//}
													}

													if(Patient_ID==null || Patient_ID.equals("null"))		    
													Patient_ID = "";
													//if(Patient_Name==null||Patient_Name.equals("null"))				
													//Patient_Name = "";
													//if(conGender==null	      || conGender.equals("null"))		    
													//conGender = "";
													//if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
													//Date_of_Birth = "";
													if(Patient_Class==null	  || Patient_Class.equals("null"))
													Patient_Class = "";
													if(Encounter_Date==null|| Encounter_Date.equals("null")){
														Encounter_Date = "";
														Encounter_Date_display = "";
													}else{
														Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
													}
													// Added for ML-MMOH-CRF-1499 on 21-APR-2020 By KAMATCHI S
													if(isDischargeDateApplicable){
													if(Dis_dateTime==null|| Dis_dateTime.equals("null")){
														Dis_dateTime = "";
														Discharge_datetime_display = "&nbsp;";
													}
													else
													{
														Discharge_datetime_display = DateUtils.convertDate(Discharge_datetime_display,"DMYHM","en",locale);
													}
													}
													
													
													
													if(Encounter_ID==null	  || Encounter_ID.equals("null"))
													Encounter_ID = "";
													if(con_Speciality==null	  || con_Speciality.equals("null"))
													con_Speciality = "&nbsp;";
													if(con_Location==null	  || con_Location.equals("null"))
													con_Location = "&nbsp;";
													if(con_Practitioner==null || con_Practitioner.equals("null"))
													con_Practitioner = "&nbsp;";
													if(room_no==null || room_no.equals("null"))
													room_no = "&nbsp;";
													if(bed_no==null || bed_no.equals("null"))
													bed_no = "&nbsp;";
													if(locn_type==null || locn_type.equals("null"))
													locn_type = "&nbsp;";
													if(Encounter_Type==null || Encounter_Type.equals("null"))
													Encounter_Type = "&nbsp;";
													out.println("<tr>");
													if(call_from!=null && call_from.equals("MAIN")){%>
													<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;" onclick="closeWindowval('<%=Encounter_ID%>','<%=Patient_ID%>','N','<%=Patient_Class_code%>');" >+</td>
													<%}else{
													out.println("<td  class='"+classValue+"'>");
													//out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"','"+call_function+"','"+install_yn+"')\">");
													out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"','"+call_function+"')\">");
													out.print("+</a></td>");
													}
													out.println("<td nowrap class='"+classValue+"'><input type='checkbox' name='select_chk"+i+"' id='select_chk"+i+"' value='"+pat_det+"' "+chkAttribute+" onClick='enableSelect(this,"+i+");chkCount();'></td>");
													//out.println("<script>alert(\""+conGender+"\");</script>");
													out.println("<input type='hidden' name='Pid"+i+"' id='Pid"+i+"' value='"+Patient_ID+"'>");
													out.println("<input type='hidden' name='encid"+i+"' id='encid"+i+"' value='"+Encounter_ID+"'>");
													//out.println("<input type='text' name='gender"+i+"' id='gender"+i+"' value='"+conGender+"'>");
													//out.println("<input type='text' name='Date_of_Birth"+i+"' id='Date_of_Birth"+i+"' value='"+Date_of_Birth+"'>");
													//out.println("<input type='text' name='Age"+i+"' id='Age"+i+"' value='"+Age+"'>");
													out.println("<input type='hidden' name='specialty_code"+i+"' id='specialty_code"+i+"' value='"+specialty_code+"'>");
													out.println("<input type='hidden' name='Patient_Class"+i+"' id='Patient_Class"+i+"' value='"+Enc_Type+"'>");
													out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
													if(!call_function.equals("QUERY_MARK_MLC_OSCC")){
														out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
													}
													// Added for ML-MMOH-CRF-1499 on 15-APR-2020 By KAMATCHI S
													if(isDischargeDateApplicable){
													out.println("<td nowrap class='"+classValue+"'>"+Discharge_datetime_display+"</td>");
													}
													out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
													out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
													out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
													out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
													
																										%>
													<td nowrap class='<%=classValue%>'>&nbsp;<%=room_no%></td> 
													<td nowrap class='<%=classValue%>'>&nbsp;<%=bed_no%></td>
													<%
													out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
													out.println("</tr>");
													i++;
													maxRecords++;
													//k++;
													//out.println("k=="+k);
												}//While Closed
												if(increment_rec_count.equals("Y")){
													totalRecords=(maxRecords+totalRecords);
												}
											}//RS Closed
//											if(rs != null)rs.close();
//											if(pstmt  != null)pstmt.close();
											%>
										</table>
										<%}else{ //if(flag.equals("true"))
											/// DISPLAY IN MODAL WINDOW
											%>
											<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
												<TR><td colspan=6 class="white">&nbsp;</td></TR>
											</table>
											<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
												<TR>
													<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td> 
													<td class="COLUMNHEADER" nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td> 
													<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
													<td class="COLUMNHEADER" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
													<td class="COLUMNHEADER" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
													<th class="COLUMNHEADER" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
													<th class="COLUMNHEADER" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
													<th class="COLUMNHEADER" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
												</TR>
											<input type='hidden' name='tempIDS' id='tempIDS'  >
											<input type='hidden' name='encIDS' id='encIDS' >
											<%
											if(!chkSelect.equals("SELECTALL")){
												TreeMap ssm=new TreeMap();
												String selitem="";
												selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
												selitem=selitem.substring(1);
												selitem=selitem.substring(0,selitem.length()-1);
												StringTokenizer st=new StringTokenizer(chkSelect,"~");
												int temp=st.countTokens();
												String practId="";
												/*String objName="";*/
												String enable_dis="";
												for(int u2=0;u2<temp;u2++){
													String st2=st.nextToken();
													StringTokenizer st1=new StringTokenizer(st2,"$");
													practId=st1.nextToken();
													st1.nextToken();
													enable_dis=st1.nextToken();
													if(enable_dis.equals("E")){
														ssm.put(practId,practId);
													}else{
														if(ssm.containsKey(practId))
														ssm.remove(practId);
													}
												}
												if (rs != null){
													int clsCnt=1;
													while(rs.next()){
														if(ssm.containsKey(new String(i+""))){
															if ( clsCnt % 2 == 0 ){
																classValue = "QRYEVENSMALL" ;
															}else{
																classValue = "QRYODDSMALL" ;
															}
															Patient_ID=rs.getString("patient_id");				
															//String Patient_Name=rs.getString("patient_name");				
															//String conGender=rs.getString("gender");				
															//String Date_of_Birth=rs.getString("birth_date");				
															//String Age=rs.getString("AGE");				
															String Patient_Class=rs.getString("patient_class");	
															String Encounter_Date=rs.getString("encounter_date");				
															Encounter_ID=rs.getString("encounter_id");				
															String con_Speciality=rs.getString("speciality_desc");				
															String con_Location=rs.getString("locn_desc");				
															String con_Practitioner=rs.getString("practitioner_name");				
															attend_practitioner_id=rs.getString("attend_practitioner_id");		
															locn_type=rs.getString("locn_type");	
															String Encounter_Date_display = "";
															if(locn_type==null	      || locn_type.equals("null"))		    
															locn_type = "";
															String Dis_dateTime =	rs.getString("discharge_date_time");	
															String Dis_dateTime_display = "";
															if(Dis_dateTime==null	      || Dis_dateTime.equals("null")){
																Dis_dateTime = "&nbsp;";
																Dis_dateTime_display = "&nbsp;";
															}else{
																Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);
															}
															if(Patient_ID==null	      || Patient_ID.equals("null"))		    
															Patient_ID = "";
															//if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
															//if(conGender==null	      || conGender.equals("null"))		    
															//conGender = "&nbsp";
															//if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
															//if(Age==null	  || Age.equals("null"))		Age = "&nbsp;";
															if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
															if(Encounter_Date==null	  || Encounter_Date.equals("null")){
																Encounter_Date = "";
																Encounter_Date_display = "";
															}else{
																Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
															}
															if(Encounter_ID==null	  || Encounter_ID.equals("null"))		Encounter_ID = "";
															if(con_Speciality==null	  || con_Speciality.equals("null"))		con_Speciality = "&nbsp;";
															if(con_Location==null	  || con_Location.equals("null"))		con_Location = "&nbsp;";
															if(con_Practitioner==null || con_Practitioner.equals("null"))	con_Practitioner = "&nbsp;";
															out.println("<tr>");				
															out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
															out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
															out.println("</tr>");
															clsCnt++;
															%>
															<script>
																enc_id	= '<%=rs.getString("encounter_id")%>';
																document.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+"|";
															</script>
														<%
														}//ssm.containsKey Closed;
														i++;
													}//While Closed;
													if(clsCnt == 1){
														out.println("<script>alert(getMessage('ENC_CANNOT_BLANK','MR'));parent.window.close();</script>");
													}
												}//Checking rs.next();
											}//CheckslctClosed
											else if(chkSelect.equals("SELECTALL")){
												if (rs != null){
													int clsCnt=1;
													while(rs.next()){
														if ( clsCnt % 2 == 0 ){
															classValue = "QRYEVENSMALL" ;
														}else{
															classValue = "QRYODDSMALL" ;
														}
														Patient_ID=rs.getString("patient_id");				
														//String Patient_Name=rs.getString("patient_name");				
														//String conGender=rs.getString("gender");				
														//String Date_of_Birth=rs.getString("birth_date");				
														//String Age=rs.getString("AGE");				
														String Patient_Class=rs.getString("patient_class");	
														String Encounter_Date=rs.getString("encounter_date");				
														Encounter_ID=rs.getString("encounter_id");				
														String con_Speciality=rs.getString("speciality_desc");				
														String con_Location=rs.getString("locn_desc");				
														String con_Practitioner=rs.getString("practitioner_name");			
														attend_practitioner_id=rs.getString("attend_practitioner_id");			
														locn_type=rs.getString("locn_type");
														String Encounter_Date_display = "";
														if(locn_type==null || locn_type.equals("null"))		    
														locn_type = "";
														String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
														String Dis_dateTime_display = "&nbsp;";
														if(Dis_dateTime==null	      || Dis_dateTime.equals("null")){
															Dis_dateTime = "&nbsp;";
															Dis_dateTime_display = "&nbsp;";
														}else{
															Dis_dateTime_display = DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);
														}
														if(Patient_ID==null	      || Patient_ID.equals("null"))		    
														Patient_ID = "";
														//if(Patient_Name==null	  || Patient_Name.equals("null"))
														//Patient_Name = "";
														//if(conGender==null	      || conGender.equals("null"))		    
														//conGender = "";
														//if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
														//Date_of_Birth = "";
														//if(Age==null	  || Age.equals("null"))
														//Age = "";
														if(Patient_Class==null	  || Patient_Class.equals("null"))
														Patient_Class = "";
														if(Encounter_Date==null	  || Encounter_Date.equals("null"))	{
															Encounter_Date = "";
															Encounter_Date_display = "";
														}else{
															Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
														}
														if(Encounter_ID==null	  || Encounter_ID.equals("null"))
														Encounter_ID = "";
														if(con_Speciality==null	  || con_Speciality.equals("null"))
														con_Speciality = "";
														if(con_Location==null	  || con_Location.equals("null"))
														con_Location = "";
														if(con_Practitioner==null || con_Practitioner.equals("null"))
														con_Practitioner = "";
														out.println("<tr>");				
														out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
														out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime_display+"</td>");
														out.println("</tr>");
														%>
														<script>
															enc_id	= "<%=Encounter_ID%>";
															document.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+"|";
														</script>
														<%	
														clsCnt++;
														i++;
													}
												}//If Closed
												if(rs != null)rs.close();
												if(pstmt  != null)pstmt.close();
											}// E.O SelectAll
											%>
											</TABLE>

										<%}//Else Closed
										%>
										<input type='hidden' name='stage_no' id='stage_no' value="<%=stage_no%>">
										<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
										<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
										<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
										<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
										<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
										<input type='hidden' name='module' id='module' value="<%=module%>" >
										<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
										<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
										<input type='hidden' name='no_of_days' id='no_of_days' value="<%=no_of_days%>" >
										<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
										<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
										<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
										<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
										<input type='hidden' name='PatientId' id='PatientId' value="<%=PatientId%>">
										<input type='hidden' name='from' id='from' value="<%=start%>" >
										<input type='hidden' name='call_from' id='call_from' value="<%=call_from%>" >
										<input type='hidden' name='to' id='to' value="<%=end%>" >
										<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
										<input type='hidden' name='temp1' id='temp1' value='<%=temp1%>'>
										<input type='hidden' name='criteria' id='criteria' value='<%=criteria%>'>
										<input type='hidden' name='lstPatientClass' id='lstPatientClass' value="<%=Enc_Type%>" >
										<input type='hidden' name='orderBy' id='orderBy' value="<%=orderBy%>" >
										<input type='hidden' name='alt_id1_exp_date' id='alt_id1_exp_date' value="<%=alt_id1_exp_date%>" >
										<input type='hidden' name='alt_id2_exp_date' id='alt_id2_exp_date' value="<%=alt_id2_exp_date%>" >
										<input type='hidden' name='p_discharge_date_from' id='p_discharge_date_from' value="<%=p_discharge_date_from%>" >
										<input type='hidden' name='p_discharge_date_to' id='p_discharge_date_to' value="<%=p_discharge_date_to%>" >
										<input type='hidden' name='encounterId' id='encounterId' value="<%=Encounter_ID%>" >
										<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
										<input type='hidden' name="selectAll_yn" id="selectAll_yn" value="<%=selectAll_yn%>">
										<input type='hidden' name="hddEncID" id="hddEncID" value="">
										<input type='hidden' name="p_encounter_id" id="p_encounter_id" value="<%=EncounterId%>">
										<input type='hidden' name="FacilityId" id="FacilityId" value="<%=FacilityId%>">
										<input type='hidden' name="marked_status" id="marked_status" value="<%=mlc_oscc%>">
										<input type='hidden' name="attend_practitioner_id" id="attend_practitioner_id" value="<%=attend_practitioner_id%>">
										<input type='hidden' name="Enc_id" id="Enc_id" value="">
										<input type='hidden' name="EncounterId" id="EncounterId" value="">
										<input type='hidden' name="Pat_id" id="Pat_id" value="<%=PatientId%>">
										<input type='hidden' name="temp2" id="temp2" value="<%=temp2%>">
										<input type='hidden' name="enc_temp" id="enc_temp" value="<%=enc_temp%>">
										<input type='hidden' name="pat_temp" id="pat_temp" value="<%=pat_temp%>">
										<input type='hidden' name='finalSelect1' id='finalSelect1' value='<%=finalSelect1%>'>
										<input type='hidden' name='status' id='status' value='<%=status%>'>
										<input type='hidden' name='Patient_ID' id='Patient_ID' value='<%=Patient_ID%>'>
										<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_val%>'>
										<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
										<input type='hidden' name='sel_cnt' id='sel_cnt' value='<%=sel_cnt%>'>
										<input type='hidden' name='enc_cnt' id='enc_cnt' value='<%=maxRecords%>'>
										<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecords%>'>
										<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
										<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
										<input type='hidden' name='reportname' id='reportname' value='<%=reportname%>'>
										<input type='hidden' name='facility_id' id='facility_id' value='<%=FacilityId%>'>
										<input type='hidden' name='start' id='start' value='<%=start%>'>
										<input type='hidden' name='end' id='end' value='<%=end%>'>
										<input type='hidden' name='totalRecords' id='totalRecords' value='<%=totalRecords%>'>
										<input type='hidden' name='increment_rec_count' id='increment_rec_count' value=''>
										<input type='hidden' name='location_code' id='location_code' value='<%=location_code%>'>
										<br>
										<%
//								}
								if(!finalSelect.equals("SELECTALL")){
									StringTokenizer st=new StringTokenizer(finalSelect,"~");
									String objName="";
									String enable_dis="";
									int temp=st.countTokens();
									for(int u2=0;u2<temp;u2++){
										String st2=st.nextToken();
										StringTokenizer st1=new StringTokenizer(st2,"$");
										//st1.nextToken();
										objName=st1.nextToken();
										enable_dis=st1.nextToken();
										if(enable_dis.equals("E"))
										out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
										//else
										//out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
									}
								}
								%>
								<%if (maxRecords==0 && !modal_yn.equals("Y")){
										display_select_btn="none";
									%>					
									<script>
										console.log("Inside DiagProcedureRecoding JSP 1849 - No Records Returned"); alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'
										if(parent.frames[3].name!='messageFrame'&& parent.frames[3].document.forms[0].showPrevDtls){
											parent.frames[3].document.forms[0].showPrevDtls.disabled=true;
										}
									</script>
							<%}
								boolean flag1 = false;
								//if ( maxRecords<10 || (!rs.next()) ) {
								//above line commented and below line added SKR-SCF-0972 [IN:047723]
								if ( maxRecords<10 || (end >= nRowCount) ) {
								%>
								<script >
									if (document.getElementById("next")){
										document.getElementById("next").style.display='none';
									}
								</script>
								<% flag1 = true;
										} else {%>
								<script >
										if (document.getElementById("next")){
											document.getElementById("next").style.display='inline';
										}
								</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



								<%}%>

								<table align='right'>
									<tr>
										<td >&nbsp;</td>
										<td >&nbsp;</td>
										<td class='label' >&nbsp;</td>
										<td class="button" style="display:<%=display_select_btn%>"><input type='button' name='select_but' id='select_but' id='select1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Select.label","mr_labels")%>' onClick="recodeModal('<%=totalRecords%>');"></td>
									</tr>
								</table>
								
						<%}catch ( Exception e ){ 
							e.printStackTrace();
						}
						finally{
							if ( pstmt != null ) pstmt.close() ;
							if ( rs != null ) rs.close() ;
							ConnectionManager.returnConnection(conn,request);
							session.setAttribute("MedicalReportReq", MedicalReportReq);
						}
						%>
						<%!
						public static String checkForNull(String inputString){
							return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
						}
						public static String checkForNull(String inputString, String defaultValue){
							return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
						}
						%>
				</form>
		</body>
</html>

