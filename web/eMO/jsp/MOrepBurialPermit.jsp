<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
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
<script language='javascript' src='../../eCommon/js/CommonLookup.js'> </script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eMO/js/MOPrintBurialPermit.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>

<body OnMouseDown='CodeArrest()'  onKeyDown="lockKey()">
<br><br>
<form name="repBurialPermit" id="repBurialPermit" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload='firstfocus();'>

<%	
	
	String	facilityId 		    = (String) session.getValue( "facility_id" ) ;
	String p_user_name			= (String) session.getValue( "login_user" ) ;
	String p_module_id			=	"MO";
	String p_report_id			=	"MOBBUPER";
		 
	String patientid			= request.getParameter("param");
	if(patientid==null)			patientid = "";
	String first = request.getParameter("first");
	if(first==null) first = "";
	
	
	Connection con							= null;
    ResultSet vrs							= null;
	java.sql.Statement stmt1                = null;
	String max_size_burial_permit_no = "";
	con			=	ConnectionManager.getConnection(request);
	/*Added by santhosh for ML-MMOH-CRF-1947 Start*/
	Boolean maxSizeBurialPermitAppl = false;
	 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
	stmt1 = con.createStatement();
	vrs = stmt1.executeQuery("select NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a where  a.facility_id='"+facilityId+"' ");
	while(vrs.next())
	{
	   max_size_burial_permit_no = (maxSizeBurialPermitAppl)?vrs.getString("MAX_SIZE_BURIAL_PERMIT_NO"):"16";
	}
	if(vrs!=null) vrs.close();
	if(stmt1!=null) stmt1.close();
	
	/*END*/
	
	%>
<input type=hidden	  name ="facilityId"  value='<%=facilityId%>'>
<input type=hidden	  name ="patientid"	  value='<%=patientid%>'>
<input type="hidden"  name ="first"		  value="<%=first%>">    
	<table border="0" cellpadding="3" cellspacing="0" align='center' width='80%'>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr><td class='label' width='20%'></td>
	<td class='querydata' width='30%'><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
	<td class='querydata' width='30%'><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
	</tr>
	<tr>	  
	  <td class='LABEL'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_REGISTRATION_NO' id='P_FM_REGISTRATION_NO'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search" id="patient_search" class='BUTTON' value="?" onClick="searchCode(this, P_FM_REGISTRATION_NO);" >
	  </td>	
	  <td class='fields' ><input type='text'  name='P_TO_REGISTRATION_NO' id='P_TO_REGISTRATION_NO'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search1" id="patient_search1" class='BUTTON' value="?" onClick="searchCode(this, P_TO_REGISTRATION_NO);" >
	  </td>
	</tr>
	<tr>	  
	  <td class='LABEL' ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_REGN_DATE_TIME' id='P_FM_REGN_DATE_TIME'  onblur='validDateObj(this,"DMY",localeName);'  size="10" maxlength="10"   ><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].P_TO_REGN_DATE_TIME.select();return showCalendar('P_FM_REGN_DATE_TIME', null, null );"style="cursor='hand'">
	  </td>	
	  <td class='fields'><input type='text'  name='P_TO_REGN_DATE_TIME' id='P_TO_REGN_DATE_TIME'  onblur='validDateObj(this,"DMY",localeName);'  size="10" maxlength="10"    ><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].P_TO_REGN_DATE_TIME.select();return showCalendar('P_TO_REGN_DATE_TIME', null, null );" style="cursor='hand'">
	  </td>
	</tr>
	<tr>	  
	  <td class='LABEL' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
  	  <td class='fields' ><input type='text'  name='P_FM_PATIENT_ID' id='P_FM_PATIENT_ID'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search2" id="patient_search2" class='BUTTON' value="?" onClick="searchCode(this,P_FM_PATIENT_ID);" >
	  </td>	
	  <td class='fields' ><input type='text'  name='P_TO_PATIENT_ID' id='P_TO_PATIENT_ID'    size="18" maxlength="16"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search3" id="patient_search3" class='BUTTON' value="?" onClick="searchCode(this,P_TO_PATIENT_ID);" >
	  </td>
	</tr>
    <tr>	  
	  <td class='LABEL' ><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></td><!--maxlength="16" canged to max_size_burial_permit_no, Added by santhosh for ML-MMOH-CRF-1947-->
  	  <td class='fields' ><input type='text'  name='P_FM_BURIAL_PERMIT_NO' id='P_FM_BURIAL_PERMIT_NO'    size="18" maxlength="<%=max_size_burial_permit_no%>"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search4" id="patient_search4" class='BUTTON' value="?" onClick="searchCode(this,P_FM_BURIAL_PERMIT_NO);" >
	  </td>	
	  <td class='fields' ><input type='text'  name='P_TO_BURIAL_PERMIT_NO' id='P_TO_BURIAL_PERMIT_NO'    size="18" maxlength="<%=max_size_burial_permit_no%>"  onKeyPress="return(CheckForSpecChars(event))"  ><input type="button" name="patient_search5" id="patient_search5" class='BUTTON' value="?" onClick="searchCode(this,P_TO_BURIAL_PERMIT_NO);" >
	  </td>
	</tr>
    <input type="hidden" name="valid" id="valid"		value="Y">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facilityId%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name" 		value="<%=p_user_name%>">
	<br>
	</form>
</body>
</html>

