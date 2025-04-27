<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src="../js/MOPrintExportationDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%	
     Connection con 			= null;
	 java.sql.Statement stmt				= null;
	 ResultSet rset			    = null;
	 StringBuffer sql			= new StringBuffer();
     String	facilityId 			= (String) session.getValue( "facility_id" ) ;
	 String p_user_name			= (String) session.getValue( "login_user" ) ;
	 String patientid			= request.getParameter("param");
	 String first				= request.getParameter("first");
	 //int chkpoi					= 0;
	 //int zx						= 0;
	 if(patientid==null)		patientid = "";
	 if(first==null)			first	  = "";
  try
  {
     String p_module_id =	"MO";
     String p_report_id =	"MOBEXDOC";
	 sql.setLength(0);
	 if(rset!=null)  rset.close();
	 if(stmt!=null) stmt.close();
%>
<body OnMouseDown='CodeArrest()'  onKeyDown="lockKey()">
<br><br>
<form name="repExpDoc" id="repExpDoc" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<input type=hidden name ="facilityId" value='<%=facilityId%>'>
<input type=hidden name ="patientid" value='<%=patientid%>'>
<input type="hidden" name="first" id="first" value="<%=first%>">
<table border="0" cellpadding="3" cellspacing="0" align='center' width='80%'>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr><td class='label' width='20%'></td>
	<td class='querydata' width='30%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='querydata' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>	  
	  <td class='LABEL' ><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_REGISTRATION_NO' id='P_FM_REGISTRATION_NO'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search" id="patient_search" class='BUTTON' value="?" onClick="searchCode(this, P_FM_REGISTRATION_NO);" >
	  </td>	
	  <td class='fields'><input type='text'  name='P_TO_REGISTRATION_NO' id='P_TO_REGISTRATION_NO'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search1" id="patient_search1" class='BUTTON' value="?" onClick="searchCode(this, P_TO_REGISTRATION_NO);" >
	  </td>
	</tr>
	<tr>	  
	  <td class='LABEL' ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_REGN_DATE_TIME' id='P_FM_REGN_DATE_TIME'  onblur='validDateObj(this,"DMY",localeName);'  size="10" maxlength="10"    ><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].P_TO_REGN_DATE_TIME.select();return showCalendar('P_FM_REGN_DATE_TIME', null,null );"style="cursor='hand'">
	  </td>	
	  <td class='fields' ><input type='text'  name='P_TO_REGN_DATE_TIME' id='P_TO_REGN_DATE_TIME'  onblur='validDateObj(this,"DMY",localeName);'  size="10" maxlength="10"    ><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].P_TO_REGN_DATE_TIME.select();return showCalendar('P_TO_REGN_DATE_TIME', null, null );"style="cursor='hand'">
	  </td>
	</tr>
	<tr>	  
	  <td class='LABEL'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_PATIENT_ID' id='P_FM_PATIENT_ID'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search2" id="patient_search2" class='BUTTON' value="?" onClick="searchCode(this,P_FM_PATIENT_ID);" >
	  </td><td class='fields' ><input type='text'  name='P_TO_PATIENT_ID' id='P_TO_PATIENT_ID'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search3" id="patient_search3" class='BUTTON' value="?" onClick="searchCode(this,P_TO_PATIENT_ID);" >
	  </td>
	</tr>
    <input type="hidden" name="valid" id="valid"		value="Y"></table>
<br>	
	<%
	%>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facilityId%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
	<input type="hidden" name="p_registration_no" id="p_registration_no"	value="<%=patientid%>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
 </form>
</body>
<% 
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
 } 
 catch(Exception e){ out.println("Main "+e);}
 finally
 {
   ConnectionManager.returnConnection(con,request);
 }
%>
</html>

