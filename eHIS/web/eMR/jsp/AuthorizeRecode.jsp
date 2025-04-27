<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

</head>

<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    Connection con = null;
	
	String P_patient_id = request.getParameter("Patient_Id");
	String P_encounter_id = request.getParameter("Encounter_Id");
	String P_practitioner_id = request.getParameter("Practitioner_Id");
	String P_clinic_code = request.getParameter("Clinic_Code");
	String P_locn_type = request.getParameter("Location_Type");
	String P_access_type = request.getParameter("Access_Type");
	
	String P_access_data = request.getParameter("Access_Data");
	String P_patient_type = request.getParameter("Patient_Type");
	String patient_class    = request.getParameter("patient_class");
	String context=request.getParameter("Context");
	String practitioner_type	=	request.getParameter("practitioner_type");
	if(practitioner_type.equals(""))	
		practitioner_type = ((String)session.getValue("practitioner_type"));

    String func=request.getParameter("Fn_Name");
	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String QueryString = request.getParameter("QueryString")==null?"":request.getParameter("QueryString");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
	String calledFromDeathReg = request.getParameter("calledFromDeathReg")==null?"N":request.getParameter("calledFromDeathReg");
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String associate_codes = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	String P_radio_par = request.getParameter("radio_par");
	String P_jsp_name = request.getParameter("jsp_name");
	String P_pr =request.getParameter("pr");

	String dob   = request.getParameter("Dob");	
	String sex   = request.getParameter("Sex");	
	String state=request.getParameter("function")==null?"":request.getParameter("function");

	if(context!=null)
	{
			if(context.equals("PatientQueue")	)
					P_patient_type="O";
			else
					P_patient_type="C"; 
	}


    con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rset=null ;

	Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");

	
		
%>
<form name= 'f' >
<%
try{

       /*Below line added for this CRF GDOH-CRF-0082*/			
		boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
	   //End GDOH-CRF-0082  

	int a = 0;
	/*Access_scope was changed from "HR" to "SD" in the query for the SKR-SCF-0492 (IN032655) by Maheshwaran K as on 08/05/2012*/
	String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'SD' and facility_id=?" ;
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1,loginuser);
	pstmt.setString(2,facilityId);
	rset=pstmt.executeQuery();
	
	
	if(!(rset.next()))
	{
			a=1;
	}
%>
<input type="hidden" name="res" id="res" value="<%=a%>" >
<script>
async function show_window()
{	
		//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
        var termset_id = parent.RecDiagnosisAddModify.document.forms[0].code_set.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH termset_id=\""+termset_id+"\" action='getFreeTextApplYN' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../jsp/MRIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		var free_text_applicable_yn	= trimString(responseText);
		//End ML-MMOH-SCF-2123
		
		var called_from_ip = "<%=called_from_ip%>";
		var val1 = '<%=P_access_type%>' ;
		var val2 = '<%=P_access_data%>' ;
		var val3 = '<%=P_patient_type%>' ;
		var val = val1+'/'+val2+'/'+val3;
      
		var retVal = 	new String();
		var dialogHeight= "188px" ;
		var dialogWidth	= "350px" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;

		
		retVal = await window.showModalDialog("../../eMR/jsp/AuthorizeMRAccessFrame.jsp?constr="+val,arguments,features);
		
		      
		
		if(retVal == "T" )
	{
		if('<%=func%>'=="Ass")
						{
							
				//var diag_code=parent.addModifyPatProblem.document.forms[0].code.value;
				var diag_code;
				if(parent.RecDiagnosisAddModify!=null)
					diag_code=parent.RecDiagnosisAddModify.document.forms[0].diag_code.value;
				else if(parent.addModifyPatProblem!=null)
					diag_code=parent.addModifyPatProblem.document.forms[0].code.value;
				
				//if(parent.addModifyPatProblem.document.forms[0].diag_stage)
						//var diag_stage=parent.addModifyPatProblem.document.forms[0].diag_stage.value;
				//if(parent.RecDiagnosisAddModify.document.forms[0].diag_stage)
					//var diag_stage=parent.RecDiagnosisAddModify.document.forms[0].diag_stage.value;
				//var diagtype=parent.addModifyPatProblem.document.forms[0].diag_type.value;
				//var diagtype=parent.RecDiagnosisAddModify.document.forms[0].diag_type.value;
				//var state=parent.addModifyPatProblem.document.forms[0].function_name.value;
				//var trn_srl_no=parent.addModifyPatProblem.document.forms[0].trn_srl_no.value;
				//var trn_srl_no=parent.RecDiagnosisAddModify.document.forms[0].trn_srl_no.value;
				
							//parent.PatProblemQueryResult.location.href='../../eMR/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>';

							parent.RecDiagnosisCurrentDiag.location.href='../../eMR/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>&Logical_Seq=&Function=<%=state%>&episode_type=&visit_adm_date=&relationship_id=&term_code=&term_set_id=&practitioner_type=<%=practitioner_type%>';

								//parent.addModifyPatProblem.location.href="../../eMR/jsp/DiagRecodeaddModifyPatProblem.jsp?diag_code="+diag_code+"&diagtype="+diagtype+"&diag_stage="+diag_stage+"&trn_srl_no="+trn_srl_no+"&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&QueryString=" + escape('<%=QueryString%>') + "&Sex=<%=sex%>&Dob=<%=dob%>&retVal_auth=T&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&data_state=<%=state%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>";
							//parent.PatProblemQueryTools.document.forms[0].authorize.value='Normal Mode'


							//parent.RecDiagnosisAddModify.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?diag_code="+diag_code+"&diagtype=&diag_stage=&trn_srl_no=&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&QueryString=" + escape('<%=QueryString%>') + "&Sex=<%=sex%>&Dob=<%=dob%>&retVal_auth=T&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&data_state=<%=state%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>&Logical_Seq=&Function=<%=state%>&episode_type=&visit_adm_date=&relationship_id=&occur_srl_no=&term_code=&term_set_id=";
						
							if(parent.RecDiagnosisAddModify!=null)
							{
								parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel('Common.Normal.label','Common')+' '+getLabel('Common.mode.label','Common');
								parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Normal Mode';
							}
							else if(parent.addModifyPatProblem!=null)
							{
								parent.PatProblemQueryTools.document.forms[0].authorize.value= getLabel('Common.Normal.label','Common')+' '+getLabel('Common.mode.label','Common');
								parent.PatProblemQueryTools.document.forms[0].mode.value='Normal Mode';
							}

					
						}
						else
						{
							//Need to check below code in v3 MR module
							if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
							{
							
								if(called_from_ip == "Y"){
									parent.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value='Normal Mode'	;
									parent.PatAlertHighRiskMainFrame.location.href='../../eMR/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>"&Sex=<%=sex%>&Dob=<%=dob%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>";';								
								}else{
									top.content.workAreaFrame.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value='Normal Mode'	;
									top.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href='../../eMR/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>';
								}
							}
							else
							{
	top.content.workAreaFrame.PatAlertQueryAllergyClass.location.href='../../eMR/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>';
							}
					}
		}
		else
				{
					
					//Need to check below code in v3 MR module
					if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
					{
						if(called_from_ip == "N"){
							top.content.workAreaFrame.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;
							window.location.href="../../eCA/jsp/blank.jsp";
						}else{
							parent.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;						
						}
					}
					//else if ('<%=P_jsp_name%>' == "DiagRecodePatProblemQueryResult.jsp")
					else if ('<%=P_jsp_name%>' == "RecDiagnosisCurrentDiag.jsp" || '<%=P_jsp_name%>' == "DiagRecodePatProblemQueryResult.jsp")
					{
							
							

					if(called_from_ip == "N"){
//parent.PatProblemQueryResult.location.href='../../eMR/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>';

						//parent.RecDiagnosisCurrentDiag.location.href='../../eMR/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&Logical_Seq=&episode_type=&visit_adm_date=&Locn_Code=&relationship_id=&Locn_Type=<%=P_locn_type%>&P_context=<%=context%>&practitioner_type=&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&term_code=&Clinic_Code=<%=P_clinic_code%>&term_set_id=&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&modal_yn=<%=modal_yn%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&Function=<%=state%>&practitioner_type=<%=practitioner_type%>';
					}else{
					

//parent.PatProblemQueryResult.location.href='../../eMR/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>';		
		
		//parent.RecDiagnosisCurrentDiag.location.href='../../eMR/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&episode_type=&visit_adm_date=&Locn_Code=&relationship_id=&Locn_Type=<%=P_locn_type%>&P_context=<%=context%>&practitioner_type=&term_code=&term_set_id=&Logical_Seq=&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&modal_yn=<%=modal_yn%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&Function=<%=state%>&practitioner_type=<%=practitioner_type%>';			
					}
						if(parent.RecDiagnosisAddModify!=null)
						{
							//9/19/2009 14614
							if(parent.RecDiagnosisAddModify.document.forms[0].mode.value != 'modify')
							{
								parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value="";
								parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value="";	
								
								if(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==""&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled) 
								{
									//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
									if(free_text_applicable_yn == 'Y'){
										parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false;
									}else{
										parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=true;
									}//End ML-MMOH-SCF-2123
								} 
								
								//parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.disabled=false; //added for this CRF Bru-HIMS-CRF-024.2
								
							}
							//Monday, August 03, 2009 commented for 13271 parent.RecDiagnosisAddModify.document.forms[0].accuracy.value="";
							parent.RecDiagnosisAddModify.document.forms[0].ntf_button.style.visibility='hidden';
							parent.RecDiagnosisAddModify.document.forms[0].AddAssociateCodes.disabled=true;
							
							/*Below line added for this CRF Bru-HIMS-CRF-024.2*/							
							if((parent.RecDiagnosisAddModify.document.forms[0].notification_setup&&parent.RecDiagnosisAddModify.document.forms[0].notification_setup.value!='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value=='')&&(parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_desc.value==''))
		                    {  
			                    parent.RecDiagnosisAddModify.document.forms[0].Addnotification.disabled=true;
		                    }
							   //End Bru-HIMS-CRF-024.2	
                           
                            //Below line added for this CRF GDOH-CRF-0082
							
							//if("<%=diagnosisPmb%>"=="true" ){
							 if("<%=diagnosisPmb%>"=="true" &&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code&&parent.RecDiagnosisAddModify.document.forms[0].diagprob_code.value==""){
                               							 
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='hidden';						
								parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML="";
							}
		                    //End GDOH-CRF-0082							   
														
							parent.RecDiagnosisAddModify.document.forms[0].exclamation.style.visibility='hidden';
							parent.RecDiagnosisAddModify.document.forms[0].high_risk.style.visibility='hidden'; // Saanthaa
						}
						else if(parent.addModifyPatProblem!=null)
						{
							parent.addModifyPatProblem.document.forms[0].Description1.value="";
							parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden';
							parent.addModifyPatProblem.document.forms[0].exclamation.style.visibility='hidden';
						}
					}
				}

}

	
	if (document.f.res.value == 0)
			window.setTimeout("show_window();",1000);
	else
	{
		alert(getMessage("DIAG_AUTH_REQD",'CA'));		
	}
</script>
<%
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();

} //end try
catch(Exception e ){
	/* out.println("Exception in Authorize.jsp"+e.toString()); */ e.printStackTrace();}
finally{
//	if(stmt!=null) stmt.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>

