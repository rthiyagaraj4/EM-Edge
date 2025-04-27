<!DOCTYPE html>
<%/*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/%>

<%-- JSP Page specific attributes st art --%> 
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,java.text.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	
	String mode="1"; 
	String	bean_id			=	"QueryPatientDrugProfileBean" ;
	String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
	String patient_id=request.getParameter("patient_id");
	//SimpleDateFormat dtTimeSystemFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= dtSystemFormat.format(date_time); 
	//String dt_from	= request.getParameter("dt_from");
	//String dt_to	= request.getParameter("dt_to");
	QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	bean.setMode( mode ) ;
%>
<html>
<title><fmt:message key="ePH.ADDEXTERNALDRUG.label" bundle="${ph_labels}"/></title>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	    <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			<style>
textarea {
  resize: none;
}
</style>
</head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="PatientExternalDrug" id="PatientExternalDrug">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
            <td  class="LABEL"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
			<td align="left" width="80%">&nbsp;&nbsp;<input type="text" maxlength="60" size="15" name="drug_desc" id="drug_desc" value=""><input type="button" class="button" value="?"   onClick="DrugsearchCode(this);"onfocus="DrugsearchCode(this);"  ><img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif"><input type="hidden" name="drug_code" id="drug_code" value="">
			</td>
			
			<td class="LABEL" nowrap ><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
			<!-- added for IN070786 start-->
      	  	<td align="left" nowrap width="80%">&nbsp;&nbsp;<input type="text" maxlength="60" size="40" name="pract_name" id="pract_name"   value=""><input type="button" class="button" value="?"   onClick="PrescribeSearchCode(this);"onfocus="PrescribeSearchCode(this);">
      	  	<!-- <img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif"> --><!-- COMMENTED FOR MMS-KH-CRF-0016.1 -->
      	  	<input type="hidden" name="pract_id" id="pract_id" value=""><!-- added FOR MMS-KH-CRF-0016.1 -->
			</td>
	</tr>
	<tr>
		<td class="LABEL" ><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
						<td align="left" width="80%">&nbsp;
						<select name="route_code" id="route_code" >
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>

						</select>
						</td>
						<td class="LABEL" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td align="left" >&nbsp;&nbsp;<select name="frequency" id="frequency" >
						<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
					</td>
	</tr>
					<tr>
						<td class="LABEL"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
						<td  align="left" width="80%">&nbsp;
						<select name="dosage" id="dosage" onChange="dosageChange(this);" style="width:100;" >
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>

						</select>
						<input type="text"  name="qty_value" id="qty_value" size="10" maxlength="13" class="NUMBER" >

							<select name="qty_desc" id="qty_desc" style="width:110;" >
							
							<option VALUE="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
							</select>
						</td>
						<!-- addedd for IN070786 end -->
						
					</tr>
     <tr>
         <td class="LABEL" nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		 <td class="LABEL">&nbsp;&nbsp;<input type="text" name="dt_from" id="dt_from" 
		 Onblur='ValidateTime(this, "<%=Sysdate%>")' value="" maxlength="16" size="13" >
		 <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('dt_from',null,'hh:mm');document.getElementById('dt_from').focus();return false;"><img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
		 </td>
		 <td class="LABEL" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		 <td class="LABEL">&nbsp;&nbsp;<input type="text" name="dt_to" id="dt_to" value="" maxlength="16" size="13" Onblur='ValidatetoTime(this)'>
		 <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('dt_to',null,'hh:mm');document.getElementById('dt_to').focus();return false;">
		 </td>
      </tr>
	 
	  <tr>
	    <td class="LABEL" nowrap ><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></td>
		<td colspan="4">&nbsp;&nbsp;<textarea cols="60" rows="5" maxlength="4000" size="400"
		name="Instructions" onBlur="checkMaxLength(Instructions)"></textarea><img src="../../eCommon/images/mandatory.gif"></td>
	  </tr>

	  <tr>
	  <td colspan='4' align="right"><input type="button" class="button" name="RECORD" id="RECORD" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="AddDrugRecord()">
</table>
 
 <input type="hidden" name="SQL_PH_DRUG_SEARCH_DRUG" id="SQL_PH_DRUG_SEARCH_DRUG" value="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' and DRUG_YN='Y' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = ">
<input type="hidden" name="SQL_PH_DISP_LOCN_SELECT" id="SQL_PH_DISP_LOCN_SELECT" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT10_A")%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode"		value="<%= mode %>">	
<input type="hidden" name="patient_id" id="patient_id"		value="<%= patient_id %>">	
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">

<input type="hidden" name="form_code" id="form_code"		value=""><!-- added for IN070786 -->	

</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

