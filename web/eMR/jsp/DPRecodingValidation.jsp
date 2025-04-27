<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,org.json.simple.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onKeyDown='lockKey()'>

<%
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale					= (String) session.getValue( "LOCALE" ) ;
  //String locale = (String)session.getAttribute("LOCALE"); 


	Connection con = null; 
	PreparedStatement stmt1=null;
//	PreparedStatement stmt_appln_yn=null;
	PreparedStatement stmt=null;
	ResultSet rs1 = null;
//	ResultSet rs_appln_yn = null;
	ResultSet rs = null;

//	StringBuffer sql = new StringBuffer();
	String Pat_id = "";
	String term_set_id = "";
	String term_set_code = "";
	String Age = "";
	String dob = "";
	String sex = "";
//	String age_group_appl_yn = "";
//	String age_spec_ind_val = "";
	String short_desc = "";
	String long_desc = "";
	String select_yn = "";
	String mode = "";
	//String diag_class_code = "";
	//String curr_accuracy_code = "";
	//String curr_severity = "";
	//String curr_priority = "";
	//String curr_onset_type = "";
	//String curr_onset_date = "";
	//String status = "";
	//String status_date = "";
	//String applicable_side = "";
	//String curr_remarks = "";
	//String caused_death = "";
	//String occur_srl_no = "";
	String recode_status = "";
	String orig_termset = "";
	String orig_termcode = "";
	String descIndex = "";
	String temp_code = "";
	String drg_flag = "";
	String authorize_item = "";
	//String p_episode_type = "";


	String EncounterId = "";
	String Pat_name = "";
	String Patient_Class = "";
	String Pat_familyname = "";
	String Pat_visit = "";
	String Pat_disch = "";
	String drg_temp = "";
	String Pat_los = "";
	String drg_val = "";
	//String tot_cnt = "";
	String requestSyntax = "";
	String responseSyntax = "";
	String st3 = "";
	String st4 = "";
	String st5 = "";
	String st6 = "";
	String procedure_yn = "";
	//int srl_no = 0;
	//String proc_code_scheme = "";
	//String proc_code = "";
	String sequenced_yn = "";
	String newcodeYN="";
	String stage_no="";
	String proc_chk_dates="";
	String field_names		 =	"";
	String proc_srt_dt		 =	"";
	String proc_end_dt	 =	"";
	String code_indicator	 =	"";
	String dagger_independent_yn	 =	"";
	boolean disp_err	 =	true;//Added On 3/10/2010 for [IN019951]
	boolean disp_age_err	=	true;//Added On 3/10/2010 for [IN019951]
	String isMultiDescAppl = ""; // added by mujafar for ML-MMOH-CRF-1281


	int maxrecord = 0;
	int recordcnt = 0;

	Pat_id = request.getParameter("Pat_id");
	term_set_id = checkForNull(request.getParameter("term_set_id"));
	term_set_code = request.getParameter("term_set_code");
	Age = request.getParameter("Age");
	dob = request.getParameter("Dob");
	sex = checkForNull(request.getParameter("Sex"));
	mode = checkForNull(request.getParameter("mode"));
	descIndex = checkForNull(request.getParameter("descIndex"));
	recode_status = checkForNull(request.getParameter("recode_status"));
	orig_termset = checkForNull(request.getParameter("orig_termset"));
	orig_termcode = checkForNull(request.getParameter("orig_termcode"));
	temp_code = checkForNull(request.getParameter("temp_code"));
	EncounterId = request.getParameter("EncounterId");
	Pat_name = request.getParameter("Pat_name");
	Pat_familyname = checkForNull(request.getParameter("Pat_familyname"));
	Pat_visit = request.getParameter("Pat_visit");
	Pat_disch = request.getParameter("Pat_disch");
	drg_temp = request.getParameter("drg_temp");
	Pat_los = request.getParameter("Pat_los");
	procedure_yn = checkForNull(request.getParameter("procedure_yn"));
	Patient_Class = checkForNull(request.getParameter("Patient_Class"));
	authorize_item = checkForNull(request.getParameter("authorize_item"));
	drg_flag = checkForNull(request.getParameter("drg_flag"));
	sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
	newcodeYN= checkForNull(request.getParameter("newcodeYN"));
	String validCode= checkForNull(request.getParameter("validCode"));
	stage_no= checkForNull(request.getParameter("stage_no"));
	proc_chk_dates= checkForNull(request.getParameter("proc_chk_dates"));
	field_names= checkForNull(request.getParameter("field_names"));
	proc_srt_dt= checkForNull(request.getParameter("proc_srt_dt"));
	proc_end_dt= checkForNull(request.getParameter("proc_end_dt"));
	isMultiDescAppl = checkForNull(request.getParameter("isMultiDescAppl")); // added by mujafar for ML-MMOH-CRF-1281

try
	{
		con = ConnectionManager.getConnection(request);
		
		// added by mujafar for ML-MMOH-CRF-1281 START
		
		int descCount=0;
		JSONObject DescriptionJsonObj		= new JSONObject();
		DescriptionJsonObj = eMR.MRCommonBean.getTermCodeDescription(con,term_set_id,term_set_code);
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		JSONObject termCodeCountObj = new JSONObject();
		Integer termCodeCount =0;
		String multi_desc_yn = "N";
		if(DescriptionJsonArray.size() > 0)
		{
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		multi_desc_yn = checkForNull((String)termCodeCountObj.get("multi_desc_yn"));
		if(isMultiDescAppl.equals("true") && termCodeCount == 1 && multi_desc_yn.equals("Y")) descCount = 1;
		}
		StringTokenizer validCodeStr=new StringTokenizer(validCode,"$");
int placerInd	=0;
boolean proceed=false;
	if(mode.equals("ValidateDesc")){
		while(validCodeStr.hasMoreTokens()){
			term_set_code	= validCodeStr.nextToken();
			placerInd++;
			int active_term_count = 0;
			//int rec_term_count = 0;
			String sql_recode_exist="";
			if(procedure_yn.equals("Y")){
				sql_recode_exist="select count(*) from mr_procedure_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and proc_code_scheme='"+term_set_id+"' and proc_code in ('"+term_set_code+"') and active_yn='Y' and stage_no='"+stage_no+"'";
			}else{
				sql_recode_exist="select count(*) from mr_diagnosis_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and term_set_id='"+term_set_id+"' and term_code in ('"+term_set_code+"') and active_yn='Y' and stage_no='"+stage_no+"' ";
			}
			stmt1 = con.prepareStatement(sql_recode_exist);
			rs1 =  stmt1.executeQuery();
			if(rs1.next()){
				active_term_count=rs1.getInt(1);
			}
			if(active_term_count==0){
				String sql_cnt="";
				String err="";
				if(procedure_yn.equals("Y")){
					err=" 'MR_INVALID_PROC_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}else{
					err=" 'INVALID_DIAG_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}
				stmt1 = con.prepareStatement(sql_cnt);
				stmt1.setString(1,term_set_code);
				stmt1.setString(2,term_set_id);
				stmt1.setString(3,locale);
				rs1 =  stmt1.executeQuery();
				int maxrecord1=0;
				if(rs1!=null){
					while(rs1.next()){
						short_desc = rs1.getString("short_desc");
						long_desc = rs1.getString("long_desc");
						select_yn = rs1.getString("select_yn");
						maxrecord1++;
					}
				}
				if(rs1 != null) rs1.close();
				if(maxrecord1 == 0){
					if(placerInd==1){
						out.print("<script>alert(getMessage("+err+"))</script>");
						%>
						<script>
							parent.frames[5].document.forms[0].diagprob_code.value='';
							parent.frames[5].document.forms[0].diagprob_desc.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
							parent.frames[5].document.forms[0].diagprob_code.focus();
							parent.frames[5].document.getElementById("long_desc_0").style.display='none';
							parent.frames[5].document.forms[0].long_desc_val_0.value='';
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
							}
						</script>
					<%}else if(placerInd==2){
						out.print("<script>alert(getMessage("+err+"))</script>");
						%>
						<script>
							parent.frames[5].document.forms[0].diagprob_code1.value='';
							parent.frames[5].document.forms[0].diagprob_desc1.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
							parent.frames[5].document.forms[0].diagprob_code1.focus();
							parent.frames[5].document.getElementById("long_desc_1").style.display='none';
							parent.frames[5].document.forms[0].long_desc_val_1.value='';
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
							}
						</script>
					<%}else if(placerInd==3){
					out.print("<script>alert(getMessage("+err+"))</script>");
					%>
						<script>
							parent.frames[5].document.forms[0].diagprob_code2.value='';
							parent.frames[5].document.forms[0].diagprob_desc2.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
							parent.frames[5].document.forms[0].diagprob_code2.focus();
							parent.frames[5].document.getElementById("long_desc_2").style.display='none';
							parent.frames[5].document.forms[0].long_desc_val_2.value='';
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
							}
							</script>
					<%}%>
					<script>
						parent.frames[5].document.forms[0].Save.disabled=false;
						parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";
					</script>
				<%}else{//Valid Code
						if(!procedure_yn.equals("Y")){  // to be executed only for diagnosis .
							if(select_yn.equals("Y")){
								//String QUERY_FOR_VALID_CODE= "SELECT SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)";

								String QUERY_FOR_VALID_CODE= "SELECT COUNT(*) COUNT,SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_LANG_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND LANGUAGE_ID=? AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL) group by SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN";

								stmt = con.prepareStatement(QUERY_FOR_VALID_CODE);
								stmt.setString(1,term_set_id);
								stmt.setString(2,term_set_code);
								stmt.setString(3,locale);
								stmt.setString(4,sex);
								stmt.setString(5,dob);
								rs = stmt.executeQuery();
								int recordcnt1=0;
								int age_count=0;
								if(rs!=null && rs.next()){
									age_count	= rs.getInt("COUNT");
									short_desc		= checkForNull(rs.getString("SHORT_DESC"));
									long_desc			= checkForNull(rs.getString("LONG_DESC"));
									code_indicator = checkForNull(rs.getString("CODE_INDICATOR"));
									dagger_independent_yn = checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"),"N");
									recordcnt1++;
									/*Added On 2/16/2010  For Srr-CRF-303.2(IN015597)*/
									if((code_indicator.equals("A") || code_indicator.equals("E")) && !dagger_independent_yn.equals("Y") ){
										recordcnt1=0;
										disp_err =false;
									}
									if(rs!=null) rs.close();
									if(stmt!=null) stmt.close();
								}
								if(disp_err){
									
									/*String QUERY_FOR_PAT_AGE="SELECT COUNT(*) COUNT FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
									stmt = con.prepareStatement(QUERY_FOR_PAT_AGE);
									stmt.setString(1,term_set_id);
									stmt.setString(2,term_set_code);
									stmt.setString(3,sex);
									stmt.setString(4,dob);
									rs = stmt.executeQuery();
									if(rs.next()){
										age_count	= rs.getInt("COUNT");
									}
									*/
									if(age_count==0){
										recordcnt1=0;
										disp_age_err =false;
									}
									//if(rs!=null) rs.close();
									//if(stmt!=null) stmt.close();
								}
								if(recordcnt1 == 0){
									if(placerInd==1){								
										if(!disp_err){%>
											<script>
												alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
												parent.frames[5].document.forms[0].diagprob_code.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
												parent.frames[5].document.forms[0].diagprob_code.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
												parent.frames[5].document.getElementById("long_desc_0").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_0.value='';
											</script>
										<%}else if(!disp_age_err){%>
											<script>
												alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
												parent.frames[5].document.forms[0].diagprob_code.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
												parent.frames[5].document.forms[0].diagprob_code.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
												parent.frames[5].document.getElementById("long_desc_0").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_0.value='';
											</script>
										<%}
									}else if(placerInd==2){
										if(!disp_err){%>
											<script>
												alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
												parent.frames[5].document.forms[0].diagprob_code1.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
												parent.frames[5].document.forms[0].diagprob_code1.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
												parent.frames[5].document.getElementById("long_desc_1").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_1.value='';
											</script>
										<%}else if(!disp_age_err){%>
											<script>
												alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
												parent.frames[5].document.forms[0].diagprob_code1.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
												parent.frames[5].document.forms[0].diagprob_code1.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
												parent.frames[5].document.getElementById("long_desc_1").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_1.value='';
											</script>
										<%}
									}else if(placerInd==3){
									if(!disp_err){%>
											<script>
												alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
												parent.frames[5].document.forms[0].diagprob_code2.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
												parent.frames[5].document.forms[0].diagprob_code2.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
												parent.frames[5].document.getElementById("long_desc_2").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_2.value='';
											</script>
										<%}else if(!disp_age_err){%>
											<script>
												alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
												parent.frames[5].document.forms[0].diagprob_code2.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
												parent.frames[5].document.forms[0].diagprob_code2.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
												parent.frames[5].document.getElementById("long_desc_2").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_2.value='';
											</script>
										<%}
								}%>
								<script>
									parent.frames[5].document.forms[0].Save.disabled=false;
									parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";
								</script>
								<%}else{
										String long_desc_params	=term_set_code+","+term_set_id;
										int support_diag_cnt = getSupprtDiagCnt(term_set_id,term_set_code,con);
										if(placerInd==1){%>
											<script>
												parent.frames[5].document.forms[0].diagprob_desc.value="<%=short_desc%>";
												parent.frames[5].document.forms[0].diagprob_code.value="<%=term_set_code%>";
												parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "<%=term_set_code%>";
												if("<%=short_desc%>"!="<%=long_desc%>"){
													parent.frames[5].document.getElementById("long_desc_0").style.display="inline";
													parent.frames[5].document.forms[0].long_desc_val_0.value="<%=long_desc_params%>";
												}else{
													parent.frames[5].document.getElementById("long_desc_0").style.display="none";
													parent.frames[5].document.forms[0].long_desc_val_0.value='';
												}
												parent.frames[5].document.forms[0].dagger_independent_yn_0.value="<%=dagger_independent_yn%>";
												if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
													if('<%=support_diag_cnt%>'!=0){
														parent.frames[5].document.forms[0].code_indicator_0.value="<%=code_indicator%>";
														parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=false;
													}else{
														parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
													}
												}else{
													parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
												}												
											</script>
									<%}else if(placerInd==2){%>
											<script>
												parent.frames[5].document.forms[0].diagprob_desc1.value="<%=short_desc%>";
												parent.frames[5].document.forms[0].diagprob_code1.value="<%=term_set_code%>";
												parent.frames[5].document.forms[0].hid_diagprob_code_1.value = "<%=term_set_code%>";
												if("<%=short_desc%>"!="<%=long_desc%>"){
													parent.frames[5].document.getElementById("long_desc_1").style.display="inline";
													parent.frames[5].document.forms[0].long_desc_val_1.value="<%=long_desc_params%>";
												}else{
													parent.frames[5].document.getElementById("long_desc_1").style.display="none";
													parent.frames[5].document.forms[0].long_desc_val_1.value='';
												}
												parent.frames[5].document.forms[0].dagger_independent_yn_1.value="<%=dagger_independent_yn%>";
												if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
													if('<%=support_diag_cnt%>'!=0){
														parent.frames[5].document.forms[0].code_indicator_1.value="<%=code_indicator%>";
														parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=false;
													}else{
														parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
													}
												}else{
													parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
												}
											</script>
									<%}else if(placerInd==3){%>
											<script>
												parent.frames[5].document.forms[0].diagprob_desc2.value="<%=short_desc%>";
												parent.frames[5].document.forms[0].diagprob_code2.value="<%=term_set_code%>";
												parent.frames[5].document.forms[0].hid_diagprob_code_2.value = "<%=term_set_code%>";
												if("<%=short_desc%>"!="<%=long_desc%>"){
													parent.frames[5].document.getElementById("long_desc_2").style.display="inline";
													parent.frames[5].document.forms[0].long_desc_val_2.value="<%=long_desc_params%>";
												}else{
													parent.frames[5].document.getElementById("long_desc_2").style.display="none";
													parent.frames[5].document.forms[0].long_desc_val_2.value='';
												}
												parent.frames[5].document.forms[0].dagger_independent_yn_2.value="<%=dagger_independent_yn%>";
												if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
													if('<%=support_diag_cnt%>'!=0){
														parent.frames[5].document.forms[0].code_indicator_2.value="<%=code_indicator%>";
														parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=false;
													}else{
														parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
													}
												}else{
													parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
												}
											</script>
									<%}
										proceed =true;
								}
							}else{%>
								<script>
									alert(getMessage("CODE_NOT_SELECTABLE","MR"));
									parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
								</script>
								<%
								if(placerInd==1){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc.value="";
										parent.frames[5].document.forms[0].diagprob_code.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "";
										parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
									</script>
							<%}else if(placerInd==2){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc1.value="";
										parent.frames[5].document.forms[0].diagprob_code1.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_1.value = "";
										parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
									</script>
							<%}else if(placerInd==3){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc2.value="";
										parent.frames[5].document.forms[0].diagprob_code2.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_2.value = "";
										parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
									</script>
							<%}
							}
						}else{//Procedure YN
							String proc_long_desc_params=term_set_code+","+term_set_id;
							if(select_yn.equals("Y")){
								if(placerInd==1){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_0.value="<%=term_set_code%>";
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_0").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_0.value="<%=proc_long_desc_params%>";
										}else{
											parent.frames[5].document.getElementById("long_desc_0").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_0.value='';
										}

									</script>
								<%}else if(placerInd==2){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc1.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code1.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_1.value="<%=term_set_code%>";
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_1").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_1.value="<%=proc_long_desc_params%>";
										}else{
											parent.frames[5].document.getElementById("long_desc_1").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_1.value='';
										}
									</script>
								<%}	else if(placerInd==3){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc2.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code2.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_2.value="<%=term_set_code%>";
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_2").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_2.value="<%=proc_long_desc_params%>";

										}else{
											parent.frames[5].document.getElementById("long_desc_2").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_2.value='';
										}
									</script>
								<%}
								proceed=true;
							}else{%>
								<script>
									alert(getMessage("CODE_NOT_SELECTABLE","MR"));											parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
								</script>
								<%
								if(placerInd==1){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc.value="";
										parent.frames[5].document.forms[0].diagprob_code.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_0.value="";
									</script>
							<%}else if(placerInd==2){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc1.value="";
										parent.frames[5].document.forms[0].diagprob_code1.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_1.value="";
									</script>
							<%}else if(placerInd==3){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc2.value="";
										parent.frames[5].document.forms[0].diagprob_code2.value="";
										parent.frames[5].document.forms[0].hid_diagprob_code_2.value="";
									</script>
								<%}
							}
						}//Procedure YN =Y;
				}
			}else{%>
				<script>
					alert(getMessage('ACT_DIAG_PROC_CODE','MR'));
				</script>				
				<%if(descIndex.equals("1")){%>
					<script>
						parent.frames[5].document.forms[0].diagprob_desc.value='';
						parent.frames[5].document.forms[0].diagprob_code.value='';
						parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
						parent.frames[5].document.forms[0].diagprob_code.focus();
						parent.frames[5].document.getElementById("long_desc_0").style.display='none';
						parent.frames[5].document.forms[0].long_desc_val_0.value='';
						if('<%=procedure_yn%>'!="Y"){
							parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
					}
					</script>
				<%}else if(descIndex.equals("2")){%>
					<script>
						parent.frames[5].document.forms[0].diagprob_desc1.value='';
						parent.frames[5].document.forms[0].diagprob_code1.value='';
						parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
						parent.frames[5].document.forms[0].diagprob_code.focus();
						parent.frames[5].document.getElementById("long_desc_1").style.display='none';
						parent.frames[5].document.forms[0].long_desc_val_1.value='';
						if('<%=procedure_yn%>'!="Y"){
							parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
					}
					</script>
				<%}else if(descIndex.equals("3")){%>
					<script>
						parent.frames[5].document.forms[0].diagprob_desc2.value='';
						parent.frames[5].document.forms[0].diagprob_code2.value='';
						parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
						parent.frames[5].document.forms[0].diagprob_code3.focus();
						parent.frames[5].document.getElementById("long_desc_2").style.display='none';
						parent.frames[5].document.forms[0].long_desc_val_2.value='';
						if('<%=procedure_yn%>'!="Y"){
							parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
					}
				</script>
				<%}%>
				<script>
					parent.frames[5].document.forms[0].Save.disabled=false;
					parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";
				</script>
			<%}
	}//End Of While
		if(proceed){%>
			<script>submit();</script><!-- Submit Should Come -->
			<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
		<%}
	}//End OF ValidateDesc By Clicking Record Button

	else  if(mode.equals("recode"))  {
		  int active_term_count = 0;
		  //int rec_term_count = 0;
			String sql_recode_exist="";
			if(procedure_yn.equals("Y")){
				sql_recode_exist="select count(*) from mr_procedure_recoding_dtl where patient_id='"+Pat_id+"' and facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and proc_code_scheme='"+term_set_id+"' and proc_code='"+term_set_code+"' and active_yn='Y' and stage_no='"+stage_no+"' ";
			}else{
				sql_recode_exist="select count(*) from mr_diagnosis_recoding_dtl A ,mr_term_code B where A.patient_id='"+Pat_id+"' and A.facility_id='"+p_facility_id+"' and A.encounter_id='"+EncounterId+"' and A.term_set_id='"+term_set_id+"' and A.term_code='"+term_set_code+"' and A.active_yn='Y' and B.free_text_yn='N' and A.term_code=B.term_code and stage_no='"+stage_no+"'";
			}
			stmt1 = con.prepareStatement(sql_recode_exist);
			rs1 =  stmt1.executeQuery();
			if(rs1.next()){
				active_term_count=rs1.getInt(1);
			}
		if(active_term_count==0){
				String sql_cnt="";
				String err="";
				if(procedure_yn.equals("Y")){
					 err=" 'MR_INVALID_PROC_CODE','MR' ";
					sql_cnt="select short_desc ,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW where term_code = ? and term_set_id=? and eff_status='E' and language_id=? " ; 
				}else{
					 err=" 'INVALID_DIAG_CODE','MR' ";
					sql_cnt="select short_desc,long_desc,select_yn from MR_D_"+term_set_id+"_LANG_VW  where term_code = ? and term_set_id=? and free_text_yn='N' and eff_status='E' and language_id=? " ;
				}
				stmt1 = con.prepareStatement(sql_cnt);
				stmt1.setString(1,term_set_code);
				stmt1.setString(2,term_set_id);
				stmt1.setString(3,locale);
				rs1 =  stmt1.executeQuery();
				while(rs1.next()){
						short_desc = rs1.getString("short_desc");
						long_desc = rs1.getString("long_desc");
						select_yn = rs1.getString("select_yn");
						maxrecord++;
				}
				if(rs1 != null) rs1.close();
				if(maxrecord == 0){
					if(descIndex.equals("1")){
						out.print("<script>alert(getMessage("+err+"))</script>");
					%>
						<script>
							parent.frames[5].document.forms[0].diagprob_code.value='';
							parent.frames[5].document.forms[0].diagprob_desc.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
							parent.frames[5].document.forms[0].diagprob_code.focus();
							parent.frames[5].document.getElementById("long_desc_0").style.display='none';
							parent.frames[5].document.forms[0].long_desc_val_0.value='';
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
							}
						</script>
					<%}else if(descIndex.equals("2")){
						out.print("<script>alert(getMessage("+err+"))</script>");
						%>
							<script>
								parent.frames[5].document.forms[0].diagprob_code1.value='';
								parent.frames[5].document.forms[0].diagprob_code1.focus();
								parent.frames[5].document.forms[0].diagprob_desc1.value='';
								parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
								parent.frames[5].document.getElementById("long_desc_1").style.display='none';
								parent.frames[5].document.forms[0].long_desc_val_1.value='';
								if('<%=procedure_yn%>'!="Y"){
									parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
								}
							</script>

					<%}else if(descIndex.equals("3")){
							out.print("<script>alert(getMessage("+err+"))</script>");
							%>
							<script>
								parent.frames[5].document.forms[0].diagprob_code2.value='';
								parent.frames[5].document.forms[0].diagprob_code2.focus();
								parent.frames[5].document.forms[0].diagprob_desc2.value='';
								parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
								parent.frames[5].document.getElementById("long_desc_2").style.display='none';
								parent.frames[5].document.forms[0].long_desc_val_2.value='';
								if('<%=procedure_yn%>'!="Y"){
									parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
								}
							</script>
					<%}%>
						<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script><%

				}else{

					if(!procedure_yn.equals("Y")){  // to be executed only for diagnosis .
						if(select_yn.equals("Y")){
							/*String sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
							stmt_appln_yn = con.prepareStatement(sql_appln_yn);
							stmt_appln_yn.setString(1,term_set_id);
							rs_appln_yn = stmt_appln_yn.executeQuery();
							while(rs_appln_yn.next()){
								age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN");
							}
							if(rs_appln_yn!=null)  rs_appln_yn.close();
							if(stmt_appln_yn!=null)  stmt_appln_yn.close();
							if(age_group_appl_yn.equals("Y")){}*/
								//String QUERY_FOR_VALID_CODE= "SELECT SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?)";
								String QUERY_FOR_VALID_CODE= "SELECT COUNT(*) COUNT ,SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN FROM MR_D_"+term_set_id+"_LANG_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND LANGUAGE_ID=? AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL) group by SHORT_DESC,LONG_DESC,CODE_INDICATOR,NOTIFIABLE_YN,DAGGER_INDEPENDENT_YN";

								stmt = con.prepareStatement(QUERY_FOR_VALID_CODE);
								stmt.setString(1,term_set_id);
								stmt.setString(2,term_set_code);
								stmt.setString(3,locale);
								stmt.setString(4,sex);
								stmt.setString(5,dob);
								rs = stmt.executeQuery();
								int age_count	=0;

								if(rs!=null && rs.next()){
									age_count	= rs.getInt("COUNT");
									short_desc		= checkForNull(rs.getString("SHORT_DESC"));
									long_desc			= checkForNull(rs.getString("LONG_DESC"));
									code_indicator = checkForNull(rs.getString("CODE_INDICATOR"));
									dagger_independent_yn = checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"),"N");
									recordcnt++;
									/*Added On 2/16/2010  For Srr-CRF-303.2(IN015597)*/
									if((code_indicator.equals("A") || code_indicator.equals("E")) && !dagger_independent_yn.equals("Y") ){
										recordcnt=0;
										disp_err =false;
									}
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
								}

								
								if(disp_err){
									
									/*String QUERY_FOR_PAT_AGE="SELECT COUNT(*) COUNT FROM MR_D_"+term_set_id+"_VW A WHERE TERM_SET_ID =? AND TERM_CODE=UPPER(?) and eff_status='E' AND (GENDER_SPEC_IND = ? OR GENDER_SPEC_IND IS NULL) AND (1 = (SELECT CHECK_AGE_BETWEEN (TO_DATE(?,'DD-MM-YYYY'),MIN_AGE,AGE_UNIT,MAX_AGE + 1,AGE_UNIT_MAX) FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE = A.AGE_SPEC_IND) OR A.AGE_SPEC_IND IS NULL)";
									stmt = con.prepareStatement(QUERY_FOR_PAT_AGE);
									stmt.setString(1,term_set_id);
									stmt.setString(2,term_set_code);
									stmt.setString(3,sex);
									stmt.setString(4,dob);
									rs = stmt.executeQuery();
									if(rs.next()){
										 age_count	= rs.getInt("COUNT");
									}*/

									if(age_count==0){
										recordcnt=0;
										disp_age_err =false;
									}
									//if(rs!=null) rs.close();
									//if(stmt!=null) stmt.close();
								}

									

								if(recordcnt == 0){
									if(descIndex.equals("1")){								
										if(!disp_err){%>
											<script>
												alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
												parent.frames[5].document.forms[0].diagprob_code.value='';
												parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
												parent.frames[5].document.forms[0].diagprob_code.focus();
												parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
												parent.frames[5].document.getElementById("long_desc_0").style.display='none';
												parent.frames[5].document.forms[0].long_desc_val_0.value='';
											</script>
										<%}else if(!disp_age_err){%>
										<script>
											alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
											parent.frames[5].document.forms[0].diagprob_code.value='';
											parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
											parent.frames[5].document.forms[0].diagprob_code.focus();
											parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
											parent.frames[5].document.getElementById("long_desc_0").style.display='none';
											parent.frames[5].document.forms[0].long_desc_val_0.value='';
										</script>
										<%}
									}else if(descIndex.equals("2")){
										if(!disp_err){%>
										<script>
											alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
											parent.frames[5].document.forms[0].diagprob_code1.value='';
											parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
											parent.frames[5].document.forms[0].diagprob_code1.focus();
											parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
											parent.frames[5].document.getElementById("long_desc_1").style.display='none';
											parent.frames[5].document.forms[0].long_desc_val_1.value='';
										</script>
										<%}else if(!disp_age_err){%>
										<script>
											alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
											parent.frames[5].document.forms[0].diagprob_code1.value='';
											parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
											parent.frames[5].document.forms[0].diagprob_code1.focus();
											parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
											parent.frames[5].document.getElementById("long_desc_1").style.display='none';
											parent.frames[5].document.forms[0].long_desc_val_1.value='';
										</script>
									<%}
									}else if(descIndex.equals("3")){
										if(!disp_err){%>
										<script>
											alert(getMessage('RECORDING_SUPPRT_DIAG_NOT_ALLOWED','MR'));
											parent.frames[5].document.forms[0].diagprob_code2.value='';
											parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
											parent.frames[5].document.forms[0].diagprob_code2.focus();
											parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
											parent.frames[5].document.getElementById("long_desc_2").style.display='none';
											parent.frames[5].document.forms[0].long_desc_val_2.value='';
										</script>
										<%}else if(!disp_age_err){%>
										<script>
											alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));
											parent.frames[5].document.forms[0].diagprob_code2.value='';
											parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
											parent.frames[5].document.forms[0].diagprob_code2.focus();
											parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
											parent.frames[5].document.getElementById("long_desc_2").style.display='none';
											parent.frames[5].document.forms[0].long_desc_val_2.value='';
										</script>
									<%}
									}
									%><script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script><%
								}else{
									int support_diag_cnt = getSupprtDiagCnt(term_set_id,term_set_code,con);
									String long_desc_params = term_set_code+","+term_set_id;
									if(descIndex.equals("1")){
									%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_0.value="<%=term_set_code%>";
										/* In Below line ComplaintSrch added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
										if(parent.frames[5].document.forms[0].ComplaintSrch) // added for existing issue while testing Ml_mmoh_crf-0878
										parent.frames[5].document.forms[0].ComplaintSrch.disabled=false; 
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_0").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_0.value="<%=long_desc_params%>";
										}else{
											parent.frames[5].document.getElementById("long_desc_0").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_0.value='';
										}
										parent.frames[5].document.forms[0].dagger_independent_yn_0.value="<%=dagger_independent_yn%>";
										if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
											if('<%=support_diag_cnt%>'!=0){
												parent.frames[5].document.forms[0].code_indicator_0.value="<%=code_indicator%>";
												parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=false;
											}else{
												parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
											}
										}else{
											parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
										}
										
										// ADDED BY MUJAFAR FOR ML-MMOH-CRF-1281 START
										
											<%if(descCount>0){%>
						if(parent.frames[5].document.getElementById('other_disp1')) // Added by mujafar for ML-MMOH-CRF-1281 US3
						{
						parent.frames[5].document.getElementById('other_disp1').style.visibility='visible'; 
						parent.frames[5].document.getElementById('other_disp2').style.visibility='visible';
						
						var select = parent.frames[5].document.forms[0].term_oth_desc;
						
						 if (select.type!='hidden')
						{
							
							while (select.options.length > 0 )
							select.remove(select.options[0]);
							var element =parent.frames[5].document.createElement('OPTION');
							element.text = '-----'+getLabel("Common.defaultSelect.label","Common")+'----- ';
							element.value= '';
							parent.frames[5].document.forms[0].term_oth_desc.add(element);
							<%
							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);

							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								
							%>	
							var element =parent.frames[5].document.createElement('OPTION');
							element.text = "<%=descriptions%>";//  description<%=i%>
							element.value= "<%=descriptions%>";
							if(element.value!='')
							parent.frames[5].document.forms[0].term_oth_desc.add(element);
							<%
							}	
							%>
				   
					
					     }	

	



						}
					<%}
					else{
					%>
						
						if(parent.frames[5].document.getElementById('other_disp1'))
						{
						parent.frames[5].document.getElementById('other_disp1').style.visibility='hidden'; 
						parent.frames[5].document.getElementById('other_disp2').style.visibility='hidden';
						
						var select = parent.frames[5].document.forms[0].term_oth_desc;
						
						 if (select.type!='hidden')
						{
							
							while (select.options.length > 0 )
							select.remove(select.options[0]);
							var element =parent.frames[5].document.createElement('OPTION');
							element.text = '-----'+getLabel("Common.defaultSelect.label","Common")+'----- ';
							element.value= '';
							parent.frames[5].document.forms[0].term_oth_desc.add(element);
							<%
							JSONObject temCodeDescListObj = new JSONObject();
							if(DescriptionJsonArray.size() > 0)
							temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);
							String descriptions="";
							for(int i=1;i<=10;i++)
							{
								descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
								System.out.println("descriptions else:"+descriptions);
							%>	
							var element =parent.frames[5].document.createElement('OPTION');
							element.text = "<%=descriptions%>";
							element.value= "<%=descriptions%>";
							if(element.value!='')
							parent.frames[5].document.forms[0].term_oth_desc.add(element);
							<%
							}	
							%>
					     }	
						}
						<%
						}	
						%>
									
									</script>
								<%}
									else if(descIndex.equals("2")){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc1.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code1.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_1.value="<%=term_set_code%>";
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_1").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_1.value="<%=long_desc_params%>";
										}else{
											parent.frames[5].document.getElementById("long_desc_1").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_1.value='';
										}
										parent.frames[5].document.forms[0].dagger_independent_yn_1.value="<%=dagger_independent_yn%>";										if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
											if('<%=support_diag_cnt%>'!=0){
												parent.frames[5].document.forms[0].code_indicator_1.value="<%=code_indicator%>";
												parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=false;
											}else{
												parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
											}
										}else{
											parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
										}
									</script>
									<%}else if(descIndex.equals("3")){%>
									<script>
										parent.frames[5].document.forms[0].diagprob_desc2.value="<%=short_desc%>";
										parent.frames[5].document.forms[0].diagprob_code2.value="<%=term_set_code%>";
										parent.frames[5].document.forms[0].dagger_independent_yn_2.value="<%=dagger_independent_yn%>";
										parent.frames[5].document.forms[0].hid_diagprob_code_2.value="<%=term_set_code%>";
										if("<%=short_desc%>"!="<%=long_desc%>"){
											parent.frames[5].document.getElementById("long_desc_2").style.display="inline";
											parent.frames[5].document.forms[0].long_desc_val_2.value="<%=long_desc_params%>";
										}else{
											parent.frames[5].document.getElementById("long_desc_2").style.display="none";
											parent.frames[5].document.forms[0].long_desc_val_2.value='';
										}
										parent.frames[5].document.forms[0].dagger_independent_yn_2.value="<%=dagger_independent_yn%>";
										if('<%=code_indicator%>'=="D" || '<%=code_indicator%>'=="C"){
											if('<%=support_diag_cnt%>'!=0){
												parent.frames[5].document.forms[0].code_indicator_2.value="<%=code_indicator%>";
												parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=false;
											}else{
												parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
											}
										}else{
											parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
										}
									</script>
									<%}%>
										<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
									<%
									}
					}else{%>
							<script>
								alert(getMessage("CODE_NOT_SELECTABLE","MR"));	
							</script>

							<%if(descIndex.equals("1")){%>
								<script>
									parent.frames[5].document.forms[0].diagprob_desc.value="";
									parent.frames[5].document.forms[0].diagprob_code.value="";
									parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "";
									parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;

								</script>
							<%}
							else if(descIndex.equals("2"))
							{%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc1.value="";
								parent.frames[5].document.forms[0].diagprob_code1.value="";
								parent.frames[5].document.forms[0].hid_diagprob_code_1.value = "";
								parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
							</script>
							<%}else if(descIndex.equals("3")){%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc2.value="";
								parent.frames[5].document.forms[0].diagprob_code2.value="";
								parent.frames[5].document.forms[0].hid_diagprob_code_2.value = "";
								parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
							</script>
							<%}%>
								<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
							<%
							}
				}else{
					String proc_long_desc_params =term_set_code+","+term_set_id;
					if(select_yn.equals("Y")){
						if(descIndex.equals("1")){%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc.value="<%=short_desc%>";
								parent.frames[5].document.forms[0].diagprob_code.value="<%=term_set_code%>";
								parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "<%=term_set_code%>";
								if("<%=short_desc%>"!="<%=long_desc%>"){
									parent.frames[5].document.getElementById("long_desc_0").style.display="inline";
									parent.frames[5].document.forms[0].long_desc_val_0.value="<%=proc_long_desc_params%>";
								}else{
									parent.frames[5].document.getElementById("long_desc_0").style.display="none";
									parent.frames[5].document.forms[0].long_desc_val_0.value='';
								}
							</script>
						<%}else if(descIndex.equals("2")){%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc1.value="<%=short_desc%>";
								parent.frames[5].document.forms[0].diagprob_code1.value="<%=term_set_code%>";
								parent.frames[5].document.forms[0].hid_diagprob_code_1.value = "<%=term_set_code%>";
								if("<%=short_desc%>"!="<%=long_desc%>"){
									parent.frames[5].document.getElementById("long_desc_1").style.display="inline";
									parent.frames[5].document.forms[0].long_desc_val_1.value="<%=proc_long_desc_params%>";
								}else{
									parent.frames[5].document.getElementById("long_desc_1").style.display="none";
									parent.frames[5].document.forms[0].long_desc_val_1.value='';
								}
							</script>
						<%}	else if(descIndex.equals("3")){%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc2.value="<%=short_desc%>";
								parent.frames[5].document.forms[0].diagprob_code2.value="<%=term_set_code%>";
								parent.frames[5].document.forms[0].hid_diagprob_code_2.value = "<%=term_set_code%>";
								if("<%=short_desc%>"!="<%=long_desc%>"){
									parent.frames[5].document.getElementById("long_desc_2").style.display="inline";
									parent.frames[5].document.forms[0].long_desc_val_2.value="<%=proc_long_desc_params%>";
								}else{
									parent.frames[5].document.getElementById("long_desc_2").style.display="none";
									parent.frames[5].document.forms[0].long_desc_val_2.value='';
								}
							</script>
						<%}%>
							<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
						<%
					}else{%>
							<script>
								alert(getMessage("CODE_NOT_SELECTABLE","MR"));	
							</script>
							<%if(descIndex.equals("1")){%>
								<script>
									parent.frames[5].document.forms[0].diagprob_desc.value="";
									parent.frames[5].document.forms[0].diagprob_code.value="";
									parent.frames[5].document.forms[0].hid_diagprob_code_0.value = "";
								</script>
							<%}
							else if(descIndex.equals("2"))
							{%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc1.value="";
								parent.frames[5].document.forms[0].diagprob_code1.value="";
								parent.frames[5].document.forms[0].hid_diagprob_code_1.value="";
							</script>
							<%}else if(descIndex.equals("3")){%>
							<script>
								parent.frames[5].document.forms[0].diagprob_desc2.value="";
								parent.frames[5].document.forms[0].diagprob_code2.value="";
								parent.frames[5].document.forms[0].hid_diagprob_code_2.value="";
							</script>
							<%}%>
								<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
							<%
							}
				}
			}
		}else{%>
				<script>
					alert(getMessage('ACT_DIAG_PROC_CODE','MR'));
				</script>				
				<%if(descIndex.equals("1")){%>
						<script>
							parent.frames[5].document.forms[0].diagprob_desc.value='';
							parent.frames[5].document.forms[0].diagprob_code.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_0.value='';
							parent.frames[5].document.forms[0].diagprob_code.focus();
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_0.disabled=true;
							}
						</script>
				<%}else if(descIndex.equals("2")){%>
						<script>
							parent.frames[5].document.forms[0].diagprob_desc1.value='';
							parent.frames[5].document.forms[0].diagprob_code1.value='';
							parent.frames[5].document.forms[0].hid_diagprob_code_1.value='';
							parent.frames[5].document.forms[0].diagprob_code.focus();
							if('<%=procedure_yn%>'!="Y"){
								parent.frames[5].document.forms[0].spprt_diag_btn_1.disabled=true;
							}
						</script>
				<%}else if(descIndex.equals("3")){%>
					  <script>
					   parent.frames[5].document.forms[0].diagprob_desc2.value='';
					   parent.frames[5].document.forms[0].diagprob_code2.value='';
					   parent.frames[5].document.forms[0].hid_diagprob_code_2.value='';
					   parent.frames[5].document.forms[0].diagprob_code3.focus();
					   if('<%=procedure_yn%>'!="Y"){
							parent.frames[5].document.forms[0].spprt_diag_btn_2.disabled=true;
					   }
					  </script>
				<%}%>
				<script>parent.frames[6].location.href="../../eCommon/jsp/MstCodeError.jsp";</script>
		<%
		}

	}else if(mode.equals("DRG") && Patient_Class.equals("IP")){%>

		  <script>
			parent.frames[2].document.forms[0].recal_yn.value = "Y";
			parent.frames[2].document.forms[0].sequenced_yn.value = "<%=sequenced_yn%>";
			parent.frames[2].document.forms[0].authorize_item.value = "<%=authorize_item%>";
			parent.frames[2].document.forms[0].drg_temp.value = "<%=drg_temp%>";



		</script>
		  <%
			 StringTokenizer st8=new StringTokenizer(drg_temp,"~");
			 int temp=st8.countTokens();
				
			for(int u2=0;u2<temp;u2++)
			{
				 String st2=st8.nextToken();
				 StringTokenizer st1=new StringTokenizer(st2,"&");
				while(st1.hasMoreTokens())
				{
					 st3=st1.nextToken();
					 st4=st1.nextToken();
					 st5=st1.nextToken();
					 st6=st1.nextToken();

				}
				
			}

			int asc1=11;
			char c=(char) asc1;
			


			drg_val=c+"DRG|"+Pat_id+"|"+EncounterId+"|"+Pat_name+"|"+Pat_familyname+"|"+Pat_visit+"|"+Pat_disch+"|"+Age+"|"+sex+"|"+Pat_los+"|||"+st4+"|"+st6+"|||||||||||||||||||||||63255|"+dob+"|0|"+Age;

					

			requestSyntax = "####$#Siriraj Hosp - Devlopment DB#%#DRG Segment|hn|an|name|surname|dateadm|datedsc|age|sex|los|discht|pdx|sdx1|sdx2|sdx3|sdx4|sdx5|sdx6|sdx7|sdx8|sdx9|sdx10|sdx11|sdx12|proc1|proc2|proc3|proc4|proc5|proc6|proc7|proc8|proc9|proc10|proc11|proc12|totalcost|Drg|Rw|Ot|Wtlos|Mdc|Err|Warn|Result|dob|admwt|Callos|ageday|Adjrw";

			responseSyntax = "####$#Siriraj Hosp - Devlopment DB#%#DRG Segment|hn|an|name|surname|dateadm|datedsc|age|sex|los|discht|pdx|sdx1|sdx2|sdx3|sdx4|sdx5|sdx6|sdx7|sdx8|sdx9|sdx10|sdx11|sdx12|proc1|proc2|proc3|proc4|proc5|proc6|proc7|proc8|proc9|proc10|proc11|proc12|totalcost|Drg|Rw|Ot|Wtlos|Mdc|Err|Warn|Result|dob|admwt|Callos|ageday|Adjrw";
	
			/*out.println("<script>alert(\"drg_val  :"+drg_val+"\");</script>");
			out.println("<script>alert(\"requestSyntax  :"+requestSyntax+"\");</script>");
			out.println("<script>alert(\"responseSyntax  :"+responseSyntax+"\");</script>");
			out.println("<script>alert(\"authorize_item  :"+authorize_item+"\");</script>");*/
			%>
			<script>
				
				//parent.frames[2].document.forms[0].action="../../servlet/eMR.DiagProcRecodingServlet";
				//parent.frames[2].document.forms[0].target="messageFrame";
				parent.frames[2].document.forms[0].action="../../servlet/eMR.DRGCalculationServlet";
				parent.frames[2].document.forms[0].target="messageFrame";
				parent.frames[2].document.forms[0].submit();
			</script>
<%

	  }else if(mode.equals("RemoveSessionVals")){
		  session.removeAttribute("allow_recode_diag_yn");
		  session.removeAttribute("allow_recode_proc_yn");
		  session.removeAttribute("allow_ot_proc_recode_yn");
		  session.removeAttribute("allow_non_ot_proc_recode_yn");
		  session.removeAttribute("drg_calculation_yn");
		  session.removeValue("practitioner_type");
		  session.removeValue("ca_practitioner_id");
		  session.removeAttribute("MedicalReportReq");


	  }else if(mode.equals("VALIDATE_DT_TM")){
		  String status="";
		  String RANGE_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_chk_dates+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
		  stmt1=con.prepareStatement(RANGE_SQL);
		  rs1=stmt1.executeQuery();
		  while(rs1.next()){
				status	=	checkForNull(rs1.getString("STATUS"));
		  }
		  if(status.equals("")){%>	
			  <script>
					var error=getMessage("DATE_BTWN_ENC_PERIOD_RANGE","MR") ;
					var proc_type			= parent.frames[5].document.forms[0].proc_type.value;
					var start_dt_time		= parent.frames[5].document.forms[0].start_dt_time;
					var end_dt_time		= parent.frames[5].document.forms[0].end_dt_time;
					var start_dt_tm_lbl	= "";
					var end_dt_tm_lbl	= "";
					if(proc_type=="OT"){
						if('<%=field_names%>'=="start_dt_time"){
							start_dt_tm_lbl	 = getLabel("eMR.checkindatetime.label","MR");
							error	 = error.replace("$",start_dt_tm_lbl)
							alert(error)
							parent.frames[5].document.forms[0].start_dt_time.value="";
							parent.frames[5].document.forms[0].start_dt_time.focus();
							parent.frames[5].document.forms[0].proc_srt_dt_hid.value="Y";
						}else if('<%=field_names%>'=="end_dt_time"){
							end_dt_tm_lbl	 = getLabel("eMR.checkoutdatetime.label","MR");
							error	 = error.replace("$",end_dt_tm_lbl)
							alert(error)
							parent.frames[5].document.forms[0].end_dt_time.value="";
							parent.frames[5].document.forms[0].end_dt_time.focus();
							parent.frames[5].document.forms[0].proc_end_dt_hid.value="Y";
					}
				}else if(proc_type=="NO"){
						if('<%=field_names%>'=="start_dt_time"){
							start_dt_tm_lbl	 = getLabel("Common.startdatetime.label","Common");
							error	 = error.replace("$",start_dt_tm_lbl)
							alert(error)
							parent.frames[5].document.forms[0].start_dt_time.value="";
							parent.frames[5].document.forms[0].start_dt_time.focus();
							parent.frames[5].document.forms[0].proc_srt_dt_hid.value="Y";
						}else if('<%=field_names%>'=="end_dt_time"){
							end_dt_tm_lbl	 = getLabel("Common.enddatetime.label","Common");
							error	 = error.replace("$",end_dt_tm_lbl)
							alert(error)
							parent.frames[5].document.forms[0].end_dt_time.value="";
							parent.frames[5].document.forms[0].end_dt_time.focus();
							parent.frames[5].document.forms[0].proc_end_dt_hid.value="Y";

					}
				}
//					parent.frames[6].location.href="../../eCommon/jsp/error.jsp?err_num="+error ;
			 </script>
		<%}
		  if(rs1 != null) rs1.close();
		  if(stmt1 != null) stmt1.close();
	  }else if(mode.equals("VALIDATE_DT_TM_ON_RECORD")){
		  boolean proceed_1 =	true;
		  String strt_dt_status	="";
		  String end_dt_status	="";
		  String STRT_DT_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_srt_dt+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
		  stmt1=con.prepareStatement(STRT_DT_SQL);
		  rs1=stmt1.executeQuery();
		  if(rs1.next()&& rs1!=null){
				strt_dt_status	=	checkForNull(rs1.getString("STATUS"));
				if(strt_dt_status.equals("")){
					proceed_1	=	false;%>
					  <script>
							parent.frames[5].document.forms[0].proc_srt_dt_hid.value="N";
					  </script>
				<%}else{
						proceed_1	=	true;%>
						  <script>
								parent.frames[5].document.forms[0].proc_srt_dt_hid.value="Y";
						  </script>
				<%}					  
				}else{%>
						  <script>
								parent.frames[5].document.forms[0].proc_srt_dt_hid.value="N";
						  </script>
					<%}
		  if(proceed_1){
			  if(!proc_end_dt.equals("")){
			  String END_DT_SQL	="SELECT 1 STATUS FROM PR_ENCOUNTER WHERE PATIENT_ID ='"+Pat_id+"'  AND ENCOUNTER_ID ='"+EncounterId+"' AND TO_DATE('"+proc_end_dt+"','DD/MM/YYYY HH24:MI') BETWEEN VISIT_ADM_DATE_TIME AND DISCHARGE_DATE_TIME";
				stmt1=con.prepareStatement(END_DT_SQL);
				rs1=stmt1.executeQuery();
				if(rs1.next()&&rs1!=null){
					end_dt_status	=	checkForNull(rs1.getString("STATUS"));
				if(end_dt_status.equals("")){
					proceed_1	=	false;%>
					<script>
					parent.frames[5].document.forms[0].proc_end_dt_hid.value="N";
					</script>
				<%}else{
						proceed_1	=	true;%>
						<script>
						parent.frames[5].document.forms[0].proc_end_dt_hid.value="Y";
						</script>
				<%}					  
				}else{%>
						  <script>
								parent.frames[5].document.forms[0].proc_end_dt_hid.value="N";
						  </script>
					<%}
			  }
		  }
	  }

	}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
//			session.setAttribute("mr_requestText", drg_val);
//			session.setAttribute("mr_requestSyntax", requestSyntax);
//			session.setAttribute("mr_responseSyntax", responseSyntax);
//			session.setAttribute("drg_flag", drg_flag);

		}

			%>
</body>
</html>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

<%!
	public int  getSupprtDiagCnt(String term_set,String term_code,Connection con){
		int support_diag_cnt=0;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql_sprt_diag	=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
		try{
			stmt  = con.prepareStatement(sql_sprt_diag);
			rs		 = stmt.executeQuery();
			while(rs.next()){
					support_diag_cnt=rs.getInt("COUNT");
			}
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
		}catch(Exception ex){
			support_diag_cnt=0;
			ex.printStackTrace();
		}
			return support_diag_cnt;
	}
%>

