<!DOCTYPE html>
 <!--This file is saved on 28/10/2005--> 
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
            request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/QueryDispDrugPatient.js"></script> 
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script> 
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9385 [IN:056579]  -->
    

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";

	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request ) ;
     bean.setLanguageId(locale);


	String drug_query=PhRepository.getPhKeyValue( "SQL_QUERY_DISP_DRUG_BY_PATIENT" );
%>
<form name="FormQueryDispDrugPatient" id="FormQueryDispDrugPatient" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" topmargin="0">
<tr>
<td colspan=7>&nbsp;</td>
</tr>
<tr >
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;
<input type=text size="18" name="Patient_Id" id="Patient_Id"  maxlength="<%=bean.getPatientIDLength()%>"           onKeyPress="changeToUpper()" onblur="Duplicatecheck();"><INPUT TYPE="button" name="Patient_Id_Button" id="Patient_Id_Button" VALUE="?" CLASS="button" onClick="callPatientSearch(document.FormQueryDispDrugPatient.Patient_Id)"  >	 <!--  onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->
	<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif" >
		</td>
		<td class="label" colspan=2><fmt:message key="ePH.DispenseDateFrom.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;
		<input type=text  name="Dispense_Date_From" id="Dispense_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_From');" ><!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9385 [IN:056579]  -->
		<input type=text  name="Dispense_Date_To" id="Dispense_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_To');" ><!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9385 [IN:056579]  -->
		</td>
		
		</tr>
		<tr>
		<td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td  class="label">&nbsp;&nbsp;
		<input type=radio name="searchby" id="searchby" value="D" checked><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/><input type=radio name="searchby" id="searchby" value="T" ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>
		</td>
		<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
		<td colspan=4>&nbsp;&nbsp;&nbsp;
	<input type=text  maxlength="40" size="40" name="Drug_Name" id="Drug_Name" onblur="cleardrugname(this)"><INPUT TYPE="button" name="Drug_Name_Button" id="Drug_Name_Button" VALUE="?" CLASS="button"  onClick="searchDrugName(document.FormQueryDispDrugPatient)" >
		</td>
</tr>
<tr>
<td colspan=6 align="right">	<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
</tr>
</table>
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="Drug_Code" id="Drug_Code" >
<INPUT TYPE="hidden" name="drug_query" id="drug_query" value="<%=drug_query%>" >
<INPUT TYPE="hidden" name="locale" id="locale" value="<%=locale%>" > 

</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

