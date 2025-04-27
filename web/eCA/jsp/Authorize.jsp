<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       		Edit History     	 	  Name        		Description
-----------------------------------------------------------------------
21/01/2013    	 IN037021			 Ramesh Kannnan S 		Alpha-CA-View Alerts-User is unable to view the recorded High  
                                                            Risk Conditions. 
-----------------------------------------------------------------------
-->

<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>

<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
    Connection con = null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//	String locale = (String) p.getProperty("LOCALE");
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
    String func=request.getParameter("Fn_Name");
	String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String QueryString = request.getParameter("QueryString")==null?"":request.getParameter("QueryString");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
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

	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");
%>
<form name= 'f' >
<%
try{
	int a = 0;

	//String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'HR' and facility_id=?" ; 
	String sql = " Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'V' and patient_type ='C' and access_scope= 'HR' and facility_id=?" ; //IN037021

	pstmt=con.prepareStatement(sql);
	pstmt.setString(1,loginuser);
	pstmt.setString(2,facilityId);
	
	rset=pstmt.executeQuery();

	if(!(rset.next()))
			a=1;
%>
<input type="hidden" name="res" id="res" value="<%=a%>" >
<script>

async function show_window()
{
		var called_from_ip = "<%=called_from_ip%>";
		var val1 = '<%=P_access_type%>' ;
		var val2 = '<%=P_access_data%>' ;
		var val3 = '<%=P_patient_type%>' ;
		var val = val1+'/'+val2+'/'+val3;
       
		var retVal = 	new String();
		var dialogHeight= "9" ;
		var dialogWidth	= "25" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
		retVal =await window.showModalDialog("../../eCA/jsp/AuthorizeMRAccessFrame.jsp?constr="+val,arguments,features);

		if(retVal == "T" )
		{
			if('<%=func%>'=="Ass")
			{
				var diag_code=parent.addModifyPatProblem.document.forms[0].code.value;

				if(parent.addModifyPatProblem.document.forms[0].diag_stage)
					var diag_stage=parent.addModifyPatProblem.document.forms[0].diag_stage.value;
				
				var diagtype=parent.addModifyPatProblem.document.forms[0].diag_type.value;
				
				parent.PatProblemQueryResult.location.href='../../eCA/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>';
				parent.addModifyPatProblem.location.href="../../eCA/jsp/addModifyPatProblem.jsp?diag_code="+diag_code+"&diagtype="+diagtype+"&diag_stage="+diag_stage+"&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&QueryString=" + escape('<%=QueryString%>') + "&Sex=<%=sex%>&Dob=<%=dob%>&retVal_auth=T&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>&state=<%=state%>";
				parent.PatProblemQueryTools.document.forms[0].authorize.value=getLabel("Common.Normal.label","Common")+ " " + getLabel("Common.mode.label","Common");
			}
			else
			{
				if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
				{
					if(called_from_ip == "Y")
					{
						parent.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=getLabel("Common.Normal.label","Common")+ " " + getLabel("Common.mode.label","Common");
						parent.PatAlertHighRiskMainFrame.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>"&Sex=<%=sex%>&Dob=<%=dob%>";';								
					}
					else
					{
						top.content.workAreaFrame.PatAlertQueryHighRiskResult.document.forms[0].high_risk_button.value=getLabel("Common.Normal.label","Common") + " " + getLabel("Common.mode.label","Common")
						top.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>';
					}
				}
				else
				{
					top.content.workAreaFrame.PatAlertQueryAllergyClass.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>';
				}
			}
		}
		else
		{
			if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
			{
				if(called_from_ip == "N")
				{
					top.content.workAreaFrame.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;
					window.location.href="../../eCA/jsp/blank.jsp";
				}
				else
				{
					parent.PatAlertQueryHighRiskResult.radio_high_risk.high_risk_button.checked=false;						
				}
			}
			else if ('<%=P_jsp_name%>' == "PatProblemQueryResult.jsp")
			{
				if(called_from_ip == "N")
				{
					top.content.workAreaFrame.PatProblemQueryResult.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>';
					top.content.workAreaFrame.addModifyPatProblem.document.forms[0].code.value="";
				}
				else
				{
					parent.PatProblemQueryResult.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=N&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sex=<%=sex%>&Dob=<%=dob%>&code_indicator=<%=code_indicator%>&associate_codes=<%=associate_codes%>';					
				}
			}
		}
}

if (document.f.res.value == 0)
		window.setTimeout("show_window();",1000);
else
	alert(getMessage("DIAG_AUTH_REQD","CA"));		
</script>
<%
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();

} //end try
catch(Exception e ){
	//out.println("Exception in Authorize.jsp"+e.toString());//COMMON-ICN-0181
	 e.printStackTrace();//COMMON-ICN-0181
}
finally{
//	if(stmt!=null) stmt.close();
	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>

