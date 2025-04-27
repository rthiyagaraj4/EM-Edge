<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
    String locale			= (String)session.getAttribute("LOCALE");
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>

	 <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!--<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
<%

	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String nursing_unit		=	request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	String admin_date		=	request.getParameter("admin_date")==null?"":request.getParameter("admin_date");
	String called_from		=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String patient_class	=	request.getParameter("patient_class")==null?"":(request.getParameter("patient_class").trim());
	
	//31686  Start
		String compressed = request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");
		if("Y".equals(compressed)){
			patient_id = new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}
		//31686 End.

	String bean_id				= "QueryMednAdminChartBean";
	String bean_name			= "ePH.QueryMednAdminChartBean";
	QueryMednAdminChartBean bean = (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);

%>
	<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
		<form name="FormQueryMednAdminChart" id="FormQueryMednAdminChart" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr>	
				<td  class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<input type="text" name="Patient_Id" id="Patient_Id" size="20" 
					maxlength="<%=bean.getPatientIDLength()%>" value="<%=patient_id%>" onKeyPress="uppercase()" onBlur="Duplicatecheck();defaultEncounter(this.value,'<%=bean.getPatientIDLength()%>')"> <!-- bean.getPatientIDLength() added ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] --><!--  Duplicatecheck(); added for ML-BRU-SCF-0621[IN036565]-->
					<INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button" 
					onClick="callPatientSearch(document.FormQueryMednAdminChart.Patient_Id)" >&nbsp;<img src="../../eCommon/images/mandatory.gif">
				</td>
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td >
				<!--&nbsp;&nbsp;<input type="text" name="Encounter_Id" id="Encounter_Id" onBlur="CheckPositiveNum(this);" size="15"  maxlength=15 >  for ML-BRU-SCF-0499[IN035594] -->		
				<!--added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365]--start-->
					<select name="Encounter_Id" id="Encounter_Id"  onChange="setEncDtl(this);"> 
						<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>		
					</select>		
				<!--added for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] --End -->
				</td>
			</tr>
			<tr>  
				<td align="right" colspan="6"><input type="button" class="button" name="search" id="search"	value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
			</tr>
			<input type="hidden" name="patient_class" id="patient_class" value='<%=patient_class%>'>
			<input type="hidden" name="encounterId" id="encounterId" value=''> <!--  added  for ML-BRU-SCF-0499[IN035594] and SKR-SCF-0721[IN036365] -->
			<input type="hidden" name="called_from" id="called_from" value='<%=called_from%>'>
		</table>
	</form>
</body>
<script>
	callMednResult('<%=called_from%>');
</script>
<% putObjectInBean(bean_id,bean,request); %>
</html>

