<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eBL/js/AddModifyPatFinDetails.js' language='Javascript'></script>
<script> 
var alternate_id_cont_yn = "Y";
</script>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
     
String locale			= (String)session.getAttribute("LOCALE");
String sStyle			=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute(
"PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE")
:"IeStyle.css";
out.println("<html><head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");
out.println("<script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>\n"+
			"<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>");
out.println("<script>");
out.println("var alert_yn='Y'") ;
out.println("	function get_message_text(message,moduleid,prompt)");
out.println("	{");
out.println("		var message_text;");
out.println("		message_text = getMessage(message,moduleid);");
out.println("	    return message_text;");
out.println("	}");
out.println("	function get_message_text1(message,moduleid,prompt)");
out.println("	{");
out.println("		var message_text;");
out.println("		message_text = getMessage(message,moduleid);");
out.println("	    return message_text;");
out.println("	}");
out.println("</script>");
out.println("</head>");
out.println("<form name='ae_validations_form' id='ae_validations_form'  method='post' target='messageFrame'>	<input type='hidden' name='deceased' id='deceased' value='N'><input type='hidden' name='suspended' id='suspended' value='N'><input type='hidden' name='inactive' id='inactive' value='N'>");

        Connection con               = null;
    	PreparedStatement pstmt		 = null,pstmt1 = null,deceased_pstmt =	null;
        ResultSet rset               = null,deceased_rslt =	null;
		ResultSet     rs              = null;
		String patientId			 = "";
		String patient_id			 = request.getParameter("P_Patient_ID");
		String patFlag               = checkForNull(request.getParameter("patFlag"));
			String lastvist="";
	// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
	
		String max_hrs_for_re_attend  =request.getParameter("max_hrs_for_re_attend");
		 Double max_hrs_for_re_attend1 = new Double(max_hrs_for_re_attend);
		   
	//end CRF  Bru-HIMS-CRF-152 [IN030272]

		
		String pat_id				 = checkForNull(request.getParameter("P_Patient_ID"));
		String referral_id			 = checkForNull(request.getParameter("referal_id"));
		String params			     = checkForNull(request.getParameter("params"));
		String facility_id			 = (String)session.getValue("facility_id");
		String bl_install_yn         = (String)session.getValue("bl_operational");
		char alert_yn				 = 'Y';
	    String warning_text			 = "";
		String prompt				 = "";
	    String beginHtml			 = "<html><script>";
	    String endHtml			     = "</script></html>";
        String HcExpired             = "N";
		String episodeValidation	 =  checkForNull(request.getParameter("episodeValidation"));
		String oper_stn_id			 = checkForNull(request.getParameter("oper_stn_id"));

		//String p_alt_id2_type		 = checkForNull(request.getParameter("p_alt_id2_type"));
		//String p_alt_id3_type		 = checkForNull(request.getParameter("p_alt_id3_type"));
		//String p_alt_id4_type		 = checkForNull(request.getParameter("p_alt_id4_type"));
		String entitlement_by_cat_yn = checkForNull(request.getParameter("entitlement_by_cat_yn"));
		String nat_id_prompt		 = checkForNull(request.getParameter("nat_id_prompt"));

		String q_clinic_code = "";
		String q_appt_ref_no = "";
		String reg_attendance_for_inpat_yn =  checkForNull(request.getParameter("attendance_for_inpat_yn"));
        String national_id_no	=	checkForNull(request.getParameter("National_Id_No"));
		String national_id_flag	=	checkForNull(request.getParameter("National_Id_Flag"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String frameRef				= checkForNull(request.getParameter("frameRef"),"top.content");
		String invoke_from	=	checkForNull(request.getParameter("invoke_from"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		String nat_ID_sql	=	"";
		String deceased_count	=	"";
		String deceased_sql		=	"";
		String practName	= "";
		String clinicName	= "";
		String visit_status			  = "";
		//String practitioner_name	  = "";
		String patient_class		  = "";
		String visit_adm_date_time	  = "";
		double prev_visit_hrs    = 0d;
		PreparedStatement nat_ID_pstmt	=	null;
		ResultSet nat_ID_rs	=	null;
		boolean isUHID_valid_appl = false; // Added by mujafar for AMRI-CRF-0357 
		Boolean isNationalIdValidationAppl = false; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148

		try{
                con = ConnectionManager.getConnection(request);

		
		/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
		JSONObject aeParamJson		= new JSONObject();
		aeParamJson					= eAE.AECommonBean.getAEParam(con, facility_id);
		isUHID_valid_appl  = CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

		isNationalIdValidationAppl = CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION"); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	
		String invokeRecallForAE	= (String)aeParamJson.get("invokeRecallForAE");
		/*End ML-MMOH-CRF-0657*/
		boolean isInvokeChngPatDtls  = CommonBean.isSiteSpecific(con, "MP","MP_RESIDENCY_NAT_ALT1_ID_MAND"); // Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226]
		boolean isChkMPParamMandFlds = CommonBean.isSiteSpecific(con, "MP", "MP_CHK_MAND_FLDS"); /*Added by Dharma on 15th May 2020 against KDAH-CRF-0522.1*/
		boolean isNatIdAltIdMandVisaType = CommonBean.isSiteSpecific(con, "MP", "MP_VAL_VISA_TYPE");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
		boolean isCountryRegionValAppl = CommonBean.isSiteSpecific(con, "MP", "CHECK_COUNTRY_REGION");//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1

/*	  pstmt=con.prepareStatement("SELECT ALT_ID1_TYPE, ALT_ID2_TYPE, ALT_ID3_TYPE, ALT_ID4_TYPE,ENTITLEMENT_BY_PAT_CAT_YN,NAT_ID_PROMPT FROM MP_PARAM WHERE MODULE_ID='MP' ");

rset = pstmt.executeQuery();

if(rset!=null)
{
while(rset.next())
{           
p_alt_id2_type        = rset.getString(2);
p_alt_id3_type        = rset.getString(3);
p_alt_id4_type        = rset.getString(4);
entitlement_by_cat_yn = rset.getString("ENTITLEMENT_BY_PAT_CAT_YN");
nat_id_prompt = rset.getString("NAT_ID_PROMPT")==null?"":rset.getString("NAT_ID_PROMPT");
if(entitlement_by_cat_yn == null) entitlement_by_cat_yn="N";
}
}
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close(); 
*/


    try{

		 if (national_id_flag.equals("Y")) {
			   try	{
			 	  if(!pat_id.equals("")) {
					  patient_id = pat_id;
				  } else {
					  nat_ID_sql	=	"select patient_id from mp_patient where national_id_no = '"+national_id_no+"'";
					  nat_ID_pstmt	=	con.prepareStatement(nat_ID_sql);
					  nat_ID_rs		=	nat_ID_pstmt.executeQuery();
					  if(nat_ID_rs.next()) {
						patient_id=nat_ID_rs.getString(1);
					  }	else {
						out.println(beginHtml+"var msg = getMessage('INVALID_VALUE','COMMON'); msg = msg.replace('#','"+nat_id_prompt+"'); alert(msg);"+endHtml);
						out.println(beginHtml+"enableAll();"+endHtml);
					 }	
				}
			 }	catch(Exception e) {
					{e.printStackTrace(); }
			 }	finally	{
					 if(nat_ID_pstmt!=null)nat_ID_pstmt.close();
					 if(nat_ID_rs!=null)nat_ID_rs.close();
			 }

		} else {

              
		try 
			{              
			  if(!pat_id.equals(""))
              {
               patient_id = pat_id;
              }
			  else
			  {	
				  StringBuffer sqlPR = new StringBuffer();
				  //sqlPR.append("select 1 from PR_REFERRAL_REGISTER a, op_clinic b  where a.REFERRAL_ID= ? and a.STATUS!='C' AND a.TO_FACILITY_ID=b.FACILITY_ID AND A.TO_LOCN_CODE=b.CLINIC_CODE AND b.LEVEL_OF_CARE_IND='E'");
				  sqlPR.append("select 1 from PR_REFERRAL_REGISTER a where a.REFERRAL_ID= ? and a.STATUS!='C' AND A.TO_LOCN_TYPE='C'   AND A.TO_FACILITY_ID ='"+facility_id+"' AND (A.TO_LOCN_CODE IS NULL OR (A.TO_LOCN_CODE IS NOT NULL AND 'E'= (SELECT LEVEL_OF_CARE_IND FROM OP_CLINIC WHERE FACILITY_ID=a.TO_FACILITY_ID AND CLINIC_CODE=A.TO_LOCN_CODE) ))");
				  pstmt1  = con.prepareStatement(sqlPR.toString());
				  pstmt1.setString(1, referral_id);

				  rs = pstmt1.executeQuery();     
                  if(!rs.next()) 
                  {
					  out.println(beginHtml+"alert(get_message_text('INVALID_REF_ID','OP'));"+endHtml);
					  out.println(beginHtml+"enableAll();"+endHtml);
				  if(rs!=null)rs.close();
                  if(pstmt1!=null)pstmt1.close();
				  
				  }
				  else
				  {
					  StringBuffer sqlPR1 = new StringBuffer();
				      sqlPR1.append("select patient_id from pr_referral_register where ");
				      sqlPR1.append("referral_id= ? ");
				      pstmt1  = con.prepareStatement(sqlPR1.toString());
				      pstmt1.setString(1, referral_id);

				      rs = pstmt1.executeQuery();     
						if (rs!=null) 
						{
						 while (rs.next())
							{
							 patientId = rs.getString("patient_id");   
							}
						}
						if(patientId == null) patientId = "";
						/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
						/*Modified by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
						if(patientId.equals(""))
							{
                            out.println("<script language = 'JavaScript'> async function toSetPatID(){ var pat_id='';var patientID=''; pat_id= await show_patwindowReferral('"+q_clinic_code+"','"+q_appt_ref_no+"','"+referral_id+"'); console.log(pat_id); if(pat_id!=null && pat_id!='x'){ var patFlag=pat_id.charAt(0); if(patFlag=='Y'){  patientID=pat_id.substring(1,pat_id.length);pat_id=patientID;}else{patFlag='N'; patientID=pat_id}top.content.frames[1].frames[0].document.forms[0].patient_id.value=patientID;top.content.frames[1].frames[0].document.forms[0].patFlag.value=patFlag; top.content.frames[1].frames[0].document.forms[0].referal_id.onblur(); var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\"){var cnt_yn=followUpCount(pat_id); if(cnt_yn == \"Y\") {var enc_id=showFollowUpEncounters(pat_id); top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"&enc_id='+enc_id+'&invoke_recall='+invoke_recall+''}else{top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"'}}else{top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patientID;top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID='+patientID+'&oper_stn_id="+oper_stn_id+"&patFlag='+patFlag+'&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&params=\""+params+"\"'}}else{top.content.frames[1].frames[0].document.forms[0].referal_id.value='';top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;top.content.frames[1].frames[0].document.forms[0].referal_id.disabled=false;top.content.frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;top.content.frames[1].frames[0].document.forms[0].eReg.disabled=false;top.content.frames[1].frames[0].document.forms[0].patient_id.focus();top.content.frames[1].frames[0].document.forms[0].search.disabled=false;top.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;top.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html';top.content.frames[1].frames[2].location.href='../../eCommon/html/blank.html';}} toSetPatID();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
							
							}
							else
							{ 
								patient_id = patientId;
							}
						  }
					  }
					  if(rs!=null)rs.close();
                      if(pstmt1!=null)pstmt1.close();
				  }
          catch(Exception e) {e.printStackTrace();}

	  }

      if(episodeValidation!=null && !episodeValidation.equals("YES")) {

		  webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		  patdata.setFacility_id(facility_id);
		  String patientIdStatus = patdata.CheckStatus(con,patient_id);			   
		  prompt = patient_id;
         if(!patient_id.equals(""))
		 {	  
		   if(patientIdStatus.equals("BLACKLISTED_PATIENT")) {
			    out.println(beginHtml+"alert(get_message_text('BLACKLISTED_PATIENT','MP','"+prompt+"'))"+endHtml);
				alert_yn = 'N';
				if(invoke_from.equals("EMER_REGN_NB")){%>
					<script>
						parent.window.close();
					</script>
				<%}

			} else if (patientIdStatus.equals("SUSPENDED")) {
				//out.println("<script>var ret=window.confirm(get_message_text1('PAT_SUSPENDED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].suspended.value='Y';</script>");
				%>
				<script>

				if(window.confirm(get_message_text1('PAT_SUSPENDED_CONTINUE','AE'))){
				}else{
					setValue();
					<%if(invoke_from.equals("EMER_REGN_NB")){%>
						parent.window.close();
						alert_yn = 'N'; 
					<%}%>
				}
				document.forms[0].suspended.value='Y';
				</script>
			<%} else if (patientIdStatus.equals("DECEASED")) {
				/*The Query serves to  Restrict Patient Registration to one time (Avoding Duplications) for same Patient(ID) Thursday, March 04, 2010 19744 */ 
				deceased_sql	=	"select count(*) from pr_encounter where patient_id = ? and ( brought_dead_yn = 'Y'or deceased_date_time is not null) and visit_status !='99' ";
				deceased_pstmt	=	con.prepareStatement(deceased_sql);
				deceased_pstmt.setString(1,patient_id);
				deceased_rslt	=	deceased_pstmt.executeQuery();	
				if (deceased_rslt.next())
				deceased_count	=	deceased_rslt.getString("count(*)");				
				if (deceased_count.equals("0")) {
					//out.println("<script>var ret=window.confirm(get_message_text1('PAT_DECEASED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].deceased.value='Y';</script>");
					%>
					<script>
					if(window.confirm(get_message_text1('PAT_DECEASED_CONTINUE','AE'))){
					}else{
						setValue();
						<%if(invoke_from.equals("EMER_REGN_NB")){%>
							parent.window.close();
							alert_yn = 'N'; 
						<%}%>
					}
					document.forms[0].deceased.value='Y';
					</script>
					
					
				<%} else {
					out.println("<script>alert(get_message_text1('VISIT_ALRDY_REGISTERED','AE'))</script>");
					alert_yn = 'N'; 
					
					%>
					<script>
					<%if(invoke_from.equals("EMER_REGN_NB")){%>
						parent.window.close();
					<%}else{%>
						top.content.frames[1].frames[0].document.forms[0].patient_id.value='';
						<%}%>
					</script>
					<%
				}
			     if (deceased_pstmt!=null) deceased_pstmt.close();
			     if (deceased_rslt!=null) deceased_rslt.close();   // end 19744		
			} else if (patientIdStatus.equals("INACTIVE")) {
					//out.println("<script>var ret=window.confirm(get_message_text1('PAT_INACTIVATED_CONTINUE','AE')); if(!ret){setValue();}document.forms[0].inactive.value='Y';</script>");
					%>
					<script>
					if(window.confirm(get_message_text1('PAT_INACTIVATED_CONTINUE','AE'))){
					}else{
						setValue();
						<%if(invoke_from.equals("EMER_REGN_NB")){%>
							parent.window.close();
							alert_yn = 'N';
						<%}%>
					}
					document.forms[0].inactive.value='Y';
				</script>
			<%} else if ( patientIdStatus.equals("INVALID_PATIENT")) {
					/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start*/
					String chkPatDispArch=patdata.checkPatientDisposeArchive(con,patient_id);
					if(chkPatDispArch.equals("D")){
						%>
						<script>
						async function AEERegisterAttnValidationfn(){
									if(confirm(getMessage('PAT_DISPOSED_REGISTER','MP'))){	
										var retVal =  new String();
										var dialogTop   = "65";
										var dialogHeight    = "44vh" ; //30.5
										var dialogWidth = "65vw" ;
										var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
										var arguments = "" ;
										var function_id = 'VISIT_REGISTRATION';
										var url="../../eMP/jsp/PatientRegistrationMain.jsp?&module_id=MP&function_id="+function_id+"&function_type=F&access=YYYNN&func_act=Visitreg";
										retVal =await window.showModalDialog(url,arguments,features);
										if(retVal){
											if( retVal != null || retVal.length != 0)
												parent.close();
												 top.content.frames[1].frames[0].document.forms[0].patient_id.value =retVal;
												 top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
										}   
									}else{
										 top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
										 top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
												}
						}
						AEERegisterAttnValidationfn();
								</script>
						<%
						alert_yn = 'N';
					}else if(chkPatDispArch.equals("I")){ %>
					<script>
						if(confirm(getMessage('PAT_ACTIVATE','MP'))){	
							var xmlDoc = "";
							var xmlHttp = new XMLHttpRequest();
							xmlStr ='<root><SEARCH /></root>';
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?action=activate_pat&patientId=<%=patient_id%>',false);
							xmlHttp.send(xmlDoc);
							responseText=xmlHttp.responseText;
							responseText = trimString(responseText);
							top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
						}else{
							 top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
							 top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
						}
					</script>
					<%
						alert_yn = 'N';
					}else{
						/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End*/
					out.println(beginHtml+"alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'))"+endHtml);
					alert_yn = 'N';
					}//Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
			} else if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 ) {
					StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
					String valid_patient_id = token.nextToken();		
					valid_patient_id = token.nextToken(); 				//patient_id =  valid_patient_id ;
					alert_yn = 'N';
		%><script>			
						var error= getMessage( "PATIENT_MERGED_VALID",'MP');
						error = error.replace('#',"<%=valid_patient_id%>");				
						top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;
					    top.content.frames[1].frames[0].document.forms[0].patient_id.value = "<%=valid_patient_id%>"							
						top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
						top.content.frames[1].frames[0].document.forms[0].patient_id.select();
						alert(error);	
			</script> 
		<%					
			} else if (patientIdStatus != "") {			
				//warning_text+=patientIdStatus+ "<br>";
				warning_text=warning_text + patientIdStatus+ "<br>";
			}

			/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/ 
			String errMsg					= "";
			//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022 - isNatIdAltIdMandVisaType
			if((isInvokeChngPatDtls || isNatIdAltIdMandVisaType ) && alert_yn != 'N'){

				JSONObject patDtlsObj	= new JSONObject();
				patDtlsObj						= eMP.MPCommonBean.chkNatIDAltIDAvail(con, patient_id,locale);
				String natId					= (String)patDtlsObj.get("national_id_no");
				String natIddft				    = (String)patDtlsObj.get("national_id_no_dft");//Maheshwaran added AAKH-CRF-0168 as on 19-11-2022
				String altId1					= (String)patDtlsObj.get("alt_id1_no");
				String altId2					= (String)patDtlsObj.get("alt_id2_no");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				String pat_dtls_unknown_yn		= (String)patDtlsObj.get("pat_dtls_unknown_yn");
				String citizen_yn				= (String)patDtlsObj.get("citizen_yn");
				String altId1Desc				= (String)patDtlsObj.get("alt_id1_type_desc");
				String altId2Desc				= (String)patDtlsObj.get("alt_id2_type_desc");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				String natIdPrompt				= (String)patDtlsObj.get("nat_id_prompt"); 
				String showAlert				= (String)patDtlsObj.get("showAlert"); 
				String visa_type				= (String)patDtlsObj.get("visa_type");//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				JSONObject MPParamJSONObj1 = new JSONObject();
				MPParamJSONObj1 = eMP.MPCommonBean.getMPAuditTrailDetails(con);
				String dft_national_id = (String)MPParamJSONObj1.get("dft_national_id");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
				if(visa_type.equals(""))
				visa_type="W";
				if(pat_dtls_unknown_yn.equals("N")  && showAlert.equals("Y")){
					if(isInvokeChngPatDtls)
					{
						if(citizen_yn.equals("Y") && natId.equals("")){
							errMsg	= natIdPrompt;
						}else if(citizen_yn.equals("N") && altId1.equals("")  ){
							errMsg	= altId1Desc;
						}
					}
					//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
						if(isNatIdAltIdMandVisaType)
							{
							if((citizen_yn.equals("Y") && !dft_national_id.equals("")) || (citizen_yn.equals("N") &&  !dft_national_id.equals("") && (visa_type.equals("") || visa_type.equals("W"))))
								{
								//National ID null	
								if(natId.equals("")  )
									{						
									if(!altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= natIdPrompt;									
										}
									if(altId1.equals("") && !altId2.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!altId1.equals("") && (altId2.equals("") && !dft_national_id.equals(natIddft)))	
										{
										errMsg	= natIdPrompt+"/"+altId2Desc;									
										}	
								
									}
								//Alt ID1 null		
								if(altId1.equals(""))
									{						
									if(!natId.equals("") && !altId2.equals(""))	
										{
										errMsg	= altId1Desc;									
										}
									if(natId.equals("") && !altId2.equals(""))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!natId.equals("") && (altId2.equals("") && dft_national_id.equals(natId)))	
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}	
									}
								//Alt ID2 null		
								if(altId2.equals("") )
									{						
									if(!natId.equals("") && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId2Desc;									
										}
									if(natId.equals("") && natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId2Desc;								
										}	
									if(natId.equals("") && !natIddft.equals("")  && !altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId2Desc;								
										}	
									if(natId.equals("") && !altId1.equals("") && !dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt;								
										}	
									if(natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc;								
										}	
									if(!natId.equals("") && altId1.equals("") && dft_national_id.equals(natIddft))		
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}
									if(!natId.equals("") && altId1.equals("") && !dft_national_id.equals(natIddft))		
										{
										errMsg	= altId1Desc;									
										}
										//newly added
									if(natId.equals("")  && natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= natIdPrompt+"/"+altId1Desc+"/"+altId2Desc;									
										}	
									if(natId.equals("")  && !natIddft.equals("")   && altId1.equals("") && dft_national_id.equals(natIddft))	
										{
										errMsg	= altId1Desc+"/"+altId2Desc;									
										}		
									}
	
								}
							else if(citizen_yn.equals("N"))
								{
								if(visa_type.equals("V"))
									{
									if(altId1.equals("") && !altId2.equals(""))
										{
										errMsg	= altId1Desc;	
										}	
									if(!altId1.equals("") && altId2.equals(""))
										{
										errMsg	= altId2Desc;	
										}		
									if(altId1.equals("") && altId2.equals(""))
										{
										errMsg	= altId1Desc+"/"+altId2Desc;		
										}
																		
									}														
								} 	
							
							}
					if(!errMsg.equals("")){
					alert_yn = 'N';
					%>
						<script>
							var message= getMessage('NATID_ALTID_NOT_AVAILABLE_UPDATE','MP'); 
							message = message.replace('#','<%=errMsg%>');
							shoModalCall('<%=patient_id%>');
						</script>
					<%
						
					}
				}
			}

		/*Added by Dharma on 25th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/ 
		
		/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
		if(isCountryRegionValAppl && alert_yn != 'N'){

			JSONObject SMSiteJSONObj = new JSONObject();
			SMSiteJSONObj = eSM.SMCommonBean.getSMSiteParamDetails(con);
			String region_prompt = (String)SMSiteJSONObj.get("region_prompt");

			JSONObject MPParamJSONObj = new JSONObject();
			MPParamJSONObj = eMP.MPCommonBean.getMPAuditTrailDetails(con);
			String country_reqd_yn = (String)MPParamJSONObj.get("country_reqd_yn");
			String region_reqd_yn = (String)MPParamJSONObj.get("region_reqd_yn");

			JSONObject PatAddrJSONObj = new JSONObject();
			PatAddrJSONObj = eMP.MPCommonBean.getMPPatContactDetails(con,patient_id);
			String country_code = (String)PatAddrJSONObj.get("country_code");	
			String region_code = (String)PatAddrJSONObj.get("region_code");

			String dispMsg = "";

			if(country_code.equals("") || region_code.equals(""))
			{
				if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("N") && country_code.equals(""))
				{
					dispMsg = "Y";%>
					<script>
					var message = getMessage('MAND_VALIDATION_TRANS','MP'); 
					message = message.replace('#',getLabel('Common.country.label','Common'));
					</script>
				<%}
				else if(country_reqd_yn.equals("N") && region_reqd_yn.equals("Y") && region_code.equals(""))
				{
					dispMsg = "Y";%>
					<script>
					var message = getMessage('MAND_VALIDATION_TRANS','MP'); 
					message = message.replace('#','<%=region_prompt%>');
					</script>
				<%}
				else if(country_reqd_yn.equals("Y") && region_reqd_yn.equals("Y"))
				{
					if(country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";%>
						<script>
						var cr_prompt = getLabel('Common.country.label','Common')+' '+getLabel('Common.and.label','Common')+' '+'<%=region_prompt%>';
						var message = getMessage('MAND_VALIDATION_TRANS','MP'); 
						message = message.replace('#',cr_prompt);
						</script>
					<%}
					else if(country_code.equals("") && !region_code.equals(""))
					{
						dispMsg = "Y";%>
						<script>
						var message = getMessage('MAND_VALIDATION_TRANS','MP'); 
						message = message.replace('#',getLabel('Common.country.label','Common'));
						</script>
					<%}
					else if(!country_code.equals("") && region_code.equals(""))
					{
						dispMsg = "Y";%>
						<script>
						var message = getMessage('MAND_VALIDATION_TRANS','MP'); 
						message = message.replace('#','<%=region_prompt%>');
						</script>
					<%}
				}else
				{
					dispMsg = "";
				}
			}

			if(!dispMsg.equals("")){%>
				<script>
				async function AEERegisterAttnValidationfn1(){
				if(confirm(message)){
					
					var dialogTop   = '-13px'; //65
					var dialogHeight    = '94vh' ; //44
					var dialogWidth = '75vw' ;//65
					var features  = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no; scroll=no';
					var arguments = '' ;
					var retVal = '';;
					var url='../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&load_tab=CONTACT_ADDR_TAB&Patient_ID=<%=patient_id%>';
					retVal =await  window.showModalDialog(url,arguments,features);
					if(retVal){
						//Below Modified by Suji Keerthi for PAS-AE-AE Transaction-Register Attendance
						if(top.content.frames[1].frames[0].document.forms[0].National_Id_No.value!=""){
								top.content.frames[1].frames[0].document.forms[0].patient_id.value = '<%=patient_id%>';
								if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!="")
							       top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
						           else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!="")
							          top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();
								
								}else{
									if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!="")
							          top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
						              else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!="")
							             top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();
								}	
					}else{
						<%if(invoke_from.equals("EMER_REGN_NB")){%>
							//parent.window.close();
							window.document.getElementById('dialog_tag').close();
							
						<%}else{%>
							top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
							top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
						<%}%>
					}
				}else{
					<%if(invoke_from.equals("EMER_REGN_NB")){%>
							//parent.window.close();
							window.document.getElementById('dialog_tag').close();
							<%}else{%>
							top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
							top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
						<%}%>
				}
				}
				AEERegisterAttnValidationfn1();
				</script>
			<%
				alert_yn = 'N';
			}
		}
		/*End AAKH-CRF-0128.1*/

		/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 Start*/
		String strMPParamMandFlds	= "";
		if(isChkMPParamMandFlds && alert_yn != 'N') {
				strMPParamMandFlds				= eMP.MPCommonBean.chkMPMandFieldsForEncCreation(con, patient_id, locale);
				if(!strMPParamMandFlds.equals("Y")){
					errMsg	= strMPParamMandFlds;
				}
				if(!errMsg.equals("")) {
				%> 
					<script>
						var message=getMessage('NATID_ALTID_NOT_AVAILABLE','MP'); 
						message = message.replace('#','<%=errMsg%>');
						alert(message);
					</script> 
				<%
					alert_yn = 'N';
				%>
					<script>
						top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
						top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
					</script>
				<%
				}else {
					alert_yn = 'Y';
				}
			}
		/*Added By Dharma on 15th May 2020 against KDAH-CRF-0522.1 End*/

		
			 String alternateIdStatus = "";
			 String in_pat_status = "";
	// Check for the INPATIENT
	
		  if(alert_yn != 'N') 
		  {
			 in_pat_status = patdata.CheckInPatient(con,patient_id,facility_id);
			
			/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			if(isNationalIdValidationAppl)
			{
				JSONObject valJSONObj	= new JSONObject();
				valJSONObj				= eMP.MPCommonBean.getNationalIdValidationYN(con, patient_id, facility_id, "AE");
				String validate_yn		= (String)valJSONObj.get("validate_yn");
				String national_id		= (String)valJSONObj.get("national_id");
				String chk_citizen_yn	= (String)valJSONObj.get("citizen_yn");

				if(validate_yn.equals("Y") && national_id.equals("") && chk_citizen_yn.equals("Y"))
				{
				%> 
					<script>alert(getMessage("VALIDATE_NATIONAL_ID",'MP'));</script> 
				<%
					alert_yn = 'N';
				%>
					<script>
						top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
						top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
					</script>
				<%
				}else
				{
					alert_yn = 'Y';
				}

				if(alert_yn == 'N')
				{
					alternateIdStatus = "";
					in_pat_status="";
				}
			}
			/*End MO-CRF-20148*/

			


	//if(isUHID_valid_appl  )		 
	 if(isUHID_valid_appl && bl_install_yn.equals("Y") )
	
		{
							String UHIDValidCount = "0";
							String UHIDValidCount_tmp = "";
							String pat_ser_grp_code = "";
					try{
							
							
						 UHIDValidCount_tmp	= eMP.MPCommonBean.getUHIDValidCount(con,patient_id,facility_id);
						String arr_temp[] = UHIDValidCount_tmp.split("~~");
						UHIDValidCount = arr_temp[0];
						if(arr_temp.length>1)
							pat_ser_grp_code = arr_temp[1];
						
						
						if(UHIDValidCount.equals("0"))
						{
							
							
					
					%>
							
							<script>
								
								if(confirm(getMessage('UHID_EXPIRED','MP'))){	
									var check = blUHIDBillchk('<%=patient_id%>','AE_REGISTER_ATTN','AE','<%=pat_ser_grp_code%>');	
										
										if(check == 'Y')
										{
										if(top.content.frames[1].frames[0].document.forms[0].patient_id.value!="")
											top.content.frames[1].frames[0].document.forms[0].patient_id.onblur();
										else if(top.content.frames[1].frames[0].document.forms[0].referal_id.value!="")
											top.content.frames[1].frames[0].document.forms[0].referal_id.onblur();
										}
										else{
											<%
										alert_yn = 'N';
										%>
										
										top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
										top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
											
										}
										
										
										
									}else{									
										<%
										alert_yn = 'N';
										%>
										
										top.content.frames[1].frames[0].document.forms[0].patient_id.value="";
										top.content.frames[1].frames[0].document.forms[0].patient_id.focus();
										
									}
								</script>
							
							<%

					
						
						}
						else
						{
							 
							
							 
						}
						
							}
							catch(Exception e1) {
										e1.printStackTrace();
								 } 
				if(alert_yn == 'N'){
					alternateIdStatus = "";
					in_pat_status="";
				}
				
			
				
			
		}
			 
			 
		  }		  		  
			
		   if(in_pat_status.equals("CURRENTLY_IN_PATIENT")) {
               if(reg_attendance_for_inpat_yn.equals("Y")) {				out.println(beginHtml+"if(alternate_id_cont_yn==\"Y\")alert(get_message_text('CURRENTLY_IN_PATIENT','Common','"+prompt+"'))"+endHtml);
			    alert_yn = 'Y';
				} else {					out.println(beginHtml+"if(alternate_id_cont_yn==\"Y\")alert(get_message_text('REG_ATTEN_NOT_ALLOWED_FOR_CURR_INPAT','AE','"+prompt+"'))"+endHtml);
					alert_yn = 'N';
					%><script>
					top.content.frames[1].frames[0].document.forms[0].patient_id.value='';
					</script><%
				}
			}
		  // Check for the Alternate Id
		  if (alert_yn != 'N') 
		  {
			  alternateIdStatus = patdata.CheckAlternateId(con,patient_id,locale);
		  }
		 
	//added  for billing interface on 8/26/2003	  
	//Added New 08/03/2006
     HcExpired = "N";
	  if(!alternateIdStatus.equals(""))
	  {
		char val=alternateIdStatus.charAt(0);
		
		if(val == 'W')
		{
			String val1=alternateIdStatus.substring(2,alternateIdStatus.length());
			out.println("<html><script>var contyn = confirm(\""+val1+"\");  if(!contyn) setValue();</script></html>");
		}else if(val =='C')
		{			
			String val1=alternateIdStatus.substring(1,alternateIdStatus.length());
			out.println("<html><script>alert(\""+val1+"\");setValue();</script></html>");
		}else 
		{
			String val1=alternateIdStatus.substring(2,alternateIdStatus.length());
			out.println("<html><script>alert(\""+val1+"\");</script></html>");
		}
	  }

 // Start (venkat s) for PE_EXE ae regn attn function (merged two quries)
			try
			{	 

				StringBuffer sqlClinc = new StringBuffer();
				sqlClinc.append(" Select OP_GET_DESC.OP_CLINIC(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1') CLINIC_NAME,");
				// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				sqlClinc.append("  AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME,TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI')VISIT_ADM_DATE_TIME,");
				//end CRF  Bru-HIMS-CRF-152 [IN030272]

				sqlClinc.append(" (SYSDATE - (VISIT_ADM_DATE_TIME)) * 24 prev_visit_hrs,");
				sqlClinc.append(" visit_status,");
				sqlClinc.append(" patient_class,");
				sqlClinc.append(" case when TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) then 1 else 0 end is_current_date");
				sqlClinc.append(" from PR_ENCOUNTER where FACILITY_ID = ? AND PATIENT_ID = ?");
				sqlClinc.append("  ORDER BY prev_visit_hrs desc");

				// sqlClinc.append("Select OP_GET_DESC.OP_CLINIC(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','1') CLINIC_NAME, AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME from PR_ENCOUNTER where FACILITY_ID = ? AND PATIENT_ID = ? and trunc(visit_adm_date_time)=trunc(sysdate) and patient_class in ('OP','EM') ");

				
				

				  pstmt  = con.prepareStatement(sqlClinc.toString());
				  pstmt.setString(1, facility_id);
				  pstmt.setString(2, patient_id);

				  rset = pstmt.executeQuery();     
                  if(rset!=null)
                  {
                    while(rset.next())
                    {           
					practName		= rset.getString("PRACTITIONER_NAME");
					if(practName == null) practName = "";
					clinicName	= rset.getString("CLINIC_NAME");
					if(clinicName == null) clinicName = "";
					prev_visit_hrs = rset.getDouble("prev_visit_hrs");
					visit_status = rset.getString("visit_status");
					patient_class = rset.getString("patient_class");
					visit_adm_date_time = rset.getString("is_current_date");
					// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
					lastvist=rset.getString("visit_adm_date_time");
			//end CRF  Bru-HIMS-CRF-152 [IN030272]
				
					

				  }
				  
				 
                  } // End of if
				  
				  
				if (rset != null)   rset .close();
				if (pstmt != null) pstmt.close();
				if((sqlClinc != null) && (sqlClinc.length() > 0))
				 {
					sqlClinc.delete(0,sqlClinc.length());
				 }
           }
           catch(Exception e) {e.printStackTrace();}
 // End (venkat s) for PE_EXE ae regn attn function (merged two quries)





	//Ends Here 08/03/2006
	// To Inform the User, that this patient has already visited the Clinic
	
	 // below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				   Double my_value = new  Double(prev_visit_hrs);
				   
			     //end CRF  Bru-HIMS-CRF-152 [IN030272]
	if(!(alert_yn=='N'))
	 {
	 out.println("<script>  var mess	= ''; </script>");
	
	if( ( max_hrs_for_re_attend1 > my_value) && (patient_class.equals("EM") || patient_class.equals("OP")) &&  (!(clinicName.equals("")))) // Start (venkat s) for PE_EXE ae regn attn function
		 {
	  //AE_ALREADY_VISIT_LOCN
		 %>
		 <script>  
		  var practname		= "<%=practName%>" ;	
		  var clinicname	= "<%=clinicName%>" ;
		  var lastvist="<%=lastvist%>";
		  mess = get_message_text1("AE_ALREADY_VISIT_LOCN","AE")+"  "+clinicname+" "+"on"+" "+lastvist+"\n";

		 if(mess != '' && alert_yn == 'Y') 
		  {
			  alert(mess);
		  }
		 </script>
			
        <% 
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		/*out.println("<script> top.content.frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> top.content.frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");*/
		out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");
/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		}
		} // End of if
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		/*out.println("<script> top.content.frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> top.content.frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");*/
		out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].prev_visit_hrs.value='"+prev_visit_hrs+"' </script>");
        out.println("<script> "+frameRef+".frames[1].frames[0].document.forms[0].visit_status.value='"+visit_status+"' </script>");
		/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
		// end (venkat s) for PE_EXE ae_regn_attn function
		out.println(beginHtml);

	if(!(alert_yn=='N'))
	{
			String nat_id_no  = "";
			//out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.value='"+patient_id+"'");
			out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.value='"+patient_id+"'");/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/
			out.println("ChangePatVisHid("+frameRef+");"); // added by munisekhar for MMS-QH-CRF-0162
			pstmt  = con.prepareStatement("select national_id_no from mp_patient where patient_id = '"+patient_id+"'");
			rset = pstmt.executeQuery();     
			if(rset!=null && rset.next()) {
				nat_id_no = rset.getString("national_id_no") == null?"":rset.getString("national_id_no");
			}
			if(!nat_id_no.equals("")) {
				//out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_No){top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'}");
				out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No){"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'}");/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/
				//out.println("top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='"+nat_id_no+"'");
			}
			if (rset != null)   rset .close();
			if (pstmt != null) pstmt.close();
		//added for billing on 8/26/2003
			if(bl_install_yn.equals("Y")) {
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
					/*out.println("if(alternate_id_cont_yn == \"N\"){		top.content.frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{  top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"';}");*/
					/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					out.println("if(alternate_id_cont_yn == \"N\"){		"+frameRef+".frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\") {var cnt_yn=followUpCount('"+patient_id+"'); if(cnt_yn == \"Y\") { var enc_id=showFollowUpEncounters('"+patient_id+"');"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&enc_id='+enc_id+'&invoke_recall='+invoke_recall+'';}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"';}}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&"+params+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"';}}");
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
			} else {
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
					/*out.println("if(alternate_id_cont_yn == \"N\"){  top.content.frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var deceased =document.forms[0].deceased.value; top.content.frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';top.content.frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}");*/
					/*Modified by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					out.println("if(alternate_id_cont_yn == \"N\"){  "+frameRef+".frames[1].location.href='../../eAE/jsp/AERegisterAttnFrameset.jsp?params="+params+"';}else{var deceased =document.forms[0].deceased.value; var invoke_recall = '"+invokeRecallForAE+"'; if(invoke_recall == \"Y\") {var cnt_yn=followUpCount('"+patient_id+"'); if(cnt_yn == \"Y\") {var enc_id=showFollowUpEncounters('"+patient_id+"');"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' &enc_id='+enc_id+'&invoke_recall='+invoke_recall+' ';}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}}else{"+frameRef+".frames[1].frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id="+patient_id+"';"+frameRef+".frames[1].frames[2].location.href='../../eAE/jsp/AERegisterAttnResult.jsp?Patient_ID="+patient_id+"&referral_id="+referral_id+"&frameRef="+frameRef+"&invoke_from="+invoke_from+"&entitlement_by_cat_yn="+entitlement_by_cat_yn+"&oper_stn_id="+oper_stn_id+"&patFlag="+patFlag+"&"+params+"&deceased='+deceased+' ';}}");
					/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
			}	
    } else {
				/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
				 /*out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.value='';"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].referal_id.disabled=false;"); out.println("top.content.frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;");
				 out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_No) 			  {top.content.frames[1].frames[0].document.forms[0].National_Id_No.value='';				 top.content.frames[1].frames[0].document.forms[0].National_Id_No.disabled=false;}"); 				 out.println("if(top.content.frames[1].frames[0].document.forms[0].National_Id_Button){top.content.frames[1].frames[0].document.forms[0].National_Id_Button.disabled=false;}");
				 out.println("top.content.frames[1].frames[0].document.forms[0].eReg.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.focus();"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_id.select();"); 
				 out.println("top.content.frames[1].frames[0].document.forms[0].search.disabled=false;");	
				 out.println("top.content.frames[1].frames[0].document.forms[0].patient_search.disabled=false;");	
				 out.println("top.content.frames[1].frames[1].location.href='../../eCommon/html/blank.html'");
				 out.println("top.content.frames[1].frames[2].location.href='../../eCommon/html/blank.html'");*/
				//out.println("async function forShowModalCall () {");
				//out.println("var ret =  await shoModalCall();	");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].referal_id.value='';"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].referal_id.disabled=false;"); out.println(""+frameRef+".frames[1].frames[0].document.forms[0].ref_id_search.disabled=false;");
				out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No) 			  {"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.value='';				 "+frameRef+".frames[1].frames[0].document.forms[0].National_Id_No.disabled=false;}"); 				 out.println("if("+frameRef+".frames[1].frames[0].document.forms[0].National_Id_Button){"+frameRef+".frames[1].frames[0].document.forms[0].National_Id_Button.disabled=false;}");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].eReg.disabled=false;");
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.value='';"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.focus();"); 
				
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_id.select();"); 
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].search.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[0].document.forms[0].patient_search.disabled=false;");	
				out.println(""+frameRef+".frames[1].frames[1].location.href='../../eCommon/html/blank.html'");
				out.println(""+frameRef+".frames[1].frames[2].location.href='../../eCommon/html/blank.html'");
				 //out.println("forShowModalCall("+frameRef+");
				/*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
	   	  }
  	
			//out.println("top.content.frames[2].location.href='../../eAE/jsp/AERegAttnMsgBlank.jsp';");	   
			out.println(""+frameRef+".frames[2].location.href='../../eAE/jsp/AERegAttnMsgBlank.jsp';");	 /*Modified by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148]*/  
		out.println(endHtml);
	  }
   }
%>


	 </form>
	 </body>
<%
	    }
		 catch(Exception e)
		{
			e.printStackTrace();
		 }
	    }
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,request);
		}
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
%>

</html>

