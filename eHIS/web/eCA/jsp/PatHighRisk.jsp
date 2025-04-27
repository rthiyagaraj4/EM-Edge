<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created									
07/01/2013	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.

21/01/2013    IN037021		Ramesh Kannnan S 	Alpha-CA-View Alerts-User is unable to view the recorded High  
                                                Risk Conditions. 										
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
--------------------------------------------------------------------------------------------------------------------
-->
<html>
<%@page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>

	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String P_patient_id			= request.getParameter("patient_id");
	String P_locn_type			= request.getParameter("location_type");
	String P_access_type		= "E";
	String P_access_data		= "HR";
	String P_patient_type		= request.getParameter("Patient_Type");
	String context					= (String)request.getParameter("PQ");
	if (context==null) context="Y";
	String P_encounter_id	= request.getParameter("episode_id");
	String P_clinic_code		= request.getParameter("location_code");
	String P_practitioner_id = (String) session.getValue("ca_practitioner_id");
    String func=request.getParameter("Fn_Name"); 
	String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
	String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
	String option_id=request.getParameter("option_id");
	if(option_id==null) option_id="";	

	String P_radio_par = request.getParameter("radio_par");
	String P_jsp_name = request.getParameter("jsp_name");
	//CHL-CRF Start. [IN035950]
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");//CHL-CRF [IN035950]
	if(p_called_from_widget.equals("CA_HIGH_RISK")){
	%>
	<TITLE>High Risk Conditions</TITLE>
	<%
	}
	//CHL-CRF End.[IN035950]
	//out.println(option_id);

	//if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1"))
	//P_jsp_name = "PaintPatHighRisk.jsp";

	//if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1"))//Nijitha
	if(option_id.equals("RECORD_HIGH_RISK")|| option_id.equals("RECORD_HIGH_RISK1") || option_id.equals("CHART_SUMMARY"))//Nijitha
	P_jsp_name = "PaintPatHighRisk.jsp";

	//out.println(P_jsp_name);
	String P_pr =request.getParameter("pr");
	String dob = request.getParameter("Dob");
	
	
	Connection con = null; 
	PreparedStatement stmt=null;
	ResultSet rset=null ;
	java.util.Properties p	=	(java.util.Properties) session.getValue( "jdbc" );
	String loginuser			=	p.getProperty( "login_user" ) ;
	String facilityId 				= (String) session.getValue( "facility_id" ) ;
%>


<form name= 'f' >
<%
try{

	con = ConnectionManager.getConnection(request);
	int a = 0;
	String sql = "Select '1' from mr_user_access_rights_vw where appl_user_id = ? and access_type = 'E' and patient_type ='C' and access_scope= 'HR' and facility_id = ? ";

	stmt=con.prepareStatement(sql);
	stmt.setString(1,loginuser);
	stmt.setString(2,facilityId);
	rset=stmt.executeQuery();
	if(!(rset.next())){
					a=1;
	}
%>
<input type="hidden" name="res" id="res" value="<%=a%>" >
<script>
async function show_window()
{
		var val1 = '<%=P_access_type%>' ;
		var val2 = '<%=P_access_data%>' ;
		var val3 = '<%=P_patient_type%>' ;
		var val = val1+'/'+val2+'/'+val3;

		var retVal = 	new String();
		var dialogHeight= "175px" ;
		var dialogWidth	= "320px" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments	= "" ;
		retVal = await window.showModalDialog("AuthorizeMRAccessFrame.jsp?constr="+val,arguments,features);
		if(retVal == "T" ){
				
				if('<%=func%>'=="Ass"){				
					
				parent.frames[0].location.href='../../eCA/jsp/<%=P_jsp_name%>?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&dob=<%=dob%>';

				parent.frames[1].location.href='../../eCA/jsp/addModifyPatProblem.jsp?stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&P_context=<%=context%>&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>';

				parent.frames[2].document.forms[0].authorize.value='Normal Mode'
						}
						else
						{
							if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
							{	
								
								self.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&dob=<%=dob%>';
							}
							else
							{		
									//top.content.workAreaFrame.document.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&dob=<%=dob%>';//Commented IN035950 
									//IN035950 Starts
									if(null!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.document.location)
									{
									top.content.workAreaFrame.document.location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&dob=<%=dob%>';
									}
									else
									{ 
									window.location.href ='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=Y&Locn_Code=<%=P_clinic_code%>&Locn_Type=<%=P_locn_type%>&dob=<%=dob%>&p_called_from_widget=<%=p_called_from_widget%>';
									}
									//IN035950 Ends
							}
					}
		}
		else
				{
					if ('<%=P_jsp_name%>' == "PatAlertHighRiskMainFrame.jsp")
					{
						parent.frames[2].radio_high_risk.high_risk_button.checked=false;
						window.location.href="../../eCA/jsp/blank.jsp";
					}
					else if ('<%=P_jsp_name%>' == "PatProblemQueryResult.jsp")
					{
							parent.frames[0].location.href='../../eCA/jsp/<%=P_jsp_name%>?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&radio_par=<%=P_radio_par%>&pr=<%=P_pr%>&f_authorize_yn=N&dob=<%=dob%>';
					}

				}
}
	if (document.f.res.value == 0){
			window.setTimeout("show_window();",1000);
	}else{
		//alert(getMessage("CA_HIGH_RISK_PREV","CA"));
		alert(getMessage("CA_HIGH_RISK_PREV_RECORD","CA"));//IN037021

			if('<%=func%>'=="Ass")
			{
			
			}
	}
</script>
<%
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
} 
catch(Exception e )
{
	//out.println("Exception @ try"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

%>
</form>
</body>

