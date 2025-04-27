<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
--------------------------------------------------------------------------------------------------------
?            100            ?           		created
08/12/2011	 IN29788		MenakaV	 			Patient Id length should be changed based on the MP Parameter
												Setup (maximum up to 12 chrs).
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
20/01/2017		IN061898	Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
02/06/2017		IN064447	Raja S			02/06/2017		Ramesh G			Alpha - REGRESSION-CA-Patient Chart Task List-Specimen orders not displayed.
---------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facility_id = (String)session.getValue("facility_id");
String practitioner_id =	(String) session.getValue("ca_practitioner_id");
//String persist="false";
LinkedHashMap hash_values			= new LinkedHashMap();
hash_values=patTask.get_hash();
String c_location_type=(String)hash_values.get("c_location_type");
String c_locn_code=(String)hash_values.get("c_locn_code");

//added for IN011043 .... start
if(c_locn_code.equals("")||c_locn_code==null)
{
 c_locn_code= request.getParameter("location_code") == null ? "" : request.getParameter("location_code");
}
//added for IN011043 .... end
String c_locn_desc=(String)hash_values.get("c_locn_desc");
String c_patient_id=(String)hash_values.get("c_patient_id");
String c_taskList_flag=(String)hash_values.get("c_taskListFlag");
String c_search=patTask.checkForNull((String)hash_values.get("c_search"));
String patient_id=patTask.checkForNull(request.getParameter("patient_id"));
String patIDLength = patTask.getPatientIDLength();//IN29788
//IN064447 starts
if(patient_id.equals("") || c_taskList_flag.equals("T"))
	{
//IN064447 Ends
//IN061898 Changes Starts
String[] def_Nurs_unit = new String[2];

try{
	String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	String login_user	= (String)session.getValue("login_user");
	String resp_id	= (String)session.getValue("responsibility_id");

	def_Nurs_unit=patTask.getTaskListQLinkValue(ql_ref,default_yn,c_location_type,login_user,resp_id,locale);

	if(def_Nurs_unit[0]!=null && def_Nurs_unit[1]!=null)
	{
		c_locn_desc=def_Nurs_unit[1];
		c_locn_code=def_Nurs_unit[0];
		
	}
	
}catch (Exception e)
{
	e.printStackTrace();
}
//IN061898 changes Ends
//IN064447 starts
}
//IN064447 ends
%>
<form name='TaskPatientSearchForm' id='TaskPatientSearchForm'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' align=center>
<%
if(patient_id.equals("") || c_taskList_flag.equals("T"))
{
%>
<tr>
<td class='fields'><SELECT name="location_type" id="location_type" onChange='populateSourceLocation(this)' style="height: 22px; width: 150px">
				<!--<option value=''><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp-&nbsp<fmt:message key="Common.all.label" bundle="${common_labels}"/></option> -->
				<option value='C' <%=c_location_type.equals("C")?"selected":""%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value='N' <%=c_location_type.equals("N")?"selected":c_location_type.equals("")?"selected":""%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<!--<option value="R" <%=c_location_type.equals("R")?"selected":""%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option> -->
			</SELECT><img src="../../eCommon/images/mandatory.gif" align=center></td></tr>
	<tr><td>		
	<input type='text' name='locn_code' id='locn_code' value="<%=c_locn_desc%>" onBlur='populateMoveLoaction1(locn_code,locn)'  size="10" maxlength='' style="height: 22px; width: 150px"><input type='button' id='location_lookup' name='searchLook' id='searchLook' value='?'  class='button' onClick="populateMoveLoaction(locn_code,locn)"><img src="../../eCommon/images/mandatory.gif" align=center><input type="hidden" name="locn" id="locn" value="<%=c_locn_code%>">
		</td>
</tr>
<td class="fields"><fmt:message key="eCA.Show.label" bundle="${ca_labels}"/>
<input type="radio" name="search" id="search" value='A' <%=c_search.equals("A")?"checked":"checked"%> onClick="checkSearch(this)" nowrap><fmt:message key="eCA.AllPatients.label" bundle="${ca_labels}"/></td></tr>
<tr><td class="fields">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="search" id="search" value='S'  onClick="checkSearch(this)" <%=c_search.equals("S")?"checked":""%> nowrap><fmt:message key="Common.SearchPatient.label" bundle="${common_labels}"/></td></tr>
<tr><td class='fields'><input type="text" id='patient_id' name="patient_search" id="patient_search" value="<%=c_patient_id%>" onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);validatePatId(this)' size='<%=patIDLength%>' maxlength='<%=patIDLength%>' <%=c_search.equals("S")?"":"disabled"%>><!-- IN29788--><input type=button name='ActSearch' id='ActSearch' value='?'  class=button tabIndex="4" onClick="callPatientSearch()" <%=c_search.equals("S")?"":"disabled"%>><input type="hidden"  name="patientname" id="patientname" value=""><img id="patient_id_img" src="../../eCommon/images/mandatory.gif" style='<%=c_search.equals("S")?"display":"display:none"%>'></td></tr>
<tr><td class="button" align="right"><input type="button" class='button' name='searchbutton' id='searchbutton' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateValues()'></td></tr>
<!--<input type="hidden" name="clinic_sql" id="clinic_sql" value="select CLINIC_CODE code,LONG_DESC description from op_clinic_lang_vw A,CA_PRACT_BY_LOCN B where A.FACILITY_ID='<%=facility_id%>' AND A.EFF_STATUS='E' AND A.LANGUAGE_ID=? AND B.PRACTITIONER_ID='<%=practitioner_id%>' AND B.LOCN_TYPE='C' AND B.FACILITY_ID=A.FACILITY_ID AND A.CLINIC_CODE=B.LOCN_CODE  and upper(A.CLINIC_CODE) like upper(?) and upper(A.LONG_DESC) like upper(?)">-->
<input type="hidden" name="clinic_sql" id="clinic_sql" value="Select locn_code code,
OP_GET_DESC.OP_CLINIC('<%=facility_id%>',locn_code,'<%=locale%>','1') description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(OP_GET_DESC.OP_CLINIC('<%=facility_id%>',locn_code,'<%=locale%>','1') ) like upper(?) AND practitioner_id= '<%=practitioner_id%>' and locn_type = 'C' and facility_id = '<%=facility_id%>' and PATIENT_CLASS in('OP','EM') order by 2
">
<!--<input type="hidden" name="nursing_sql" id="nursing_sql" value="select NURSING_UNIT_CODE code ,LONG_DESC description from Ip_NURSING_UNIT_lang_vw A,CA_PRACT_BY_LOCN B where A.FACILITY_ID='<%=facility_id%>' AND EFF_STATUS='E' AND LANGUAGE_ID=? AND B.PRACTITIONER_ID='<%=practitioner_id%>' AND B.LOCN_TYPE='W' AND B.FACILITY_ID=A.FACILITY_ID AND A.NURSING_UNIT_CODE=B.LOCN_CODE  and upper(A.NURSING_UNIT_CODE) like upper(?) and upper(A.LONG_DESC) like upper(?)"> -->
<input type="hidden" name="nursing_sql" id="nursing_sql" value="Select locn_code code,
IP_GET_DESC.IP_NURSING_UNIT('<%=facility_id%>',locn_code,'<%=locale%>','1') description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(IP_GET_DESC.IP_NURSING_UNIT('<%=facility_id%>',locn_code,'<%=locale%>','1') ) like upper(?) AND practitioner_id= '<%=practitioner_id%>' and locn_type ='W' and facility_id = '<%=facility_id%>' and PATIENT_CLASS in ('IP','DC') order by 2">

<input type="hidden" name="referral_sql" id="referral_sql" value="select REFERRAL_CODE code ,LONG_DESC description from AM_REFERRAL_LANG_VW where EFF_STATUS='E' AND LANGUAGE_ID=?  and upper(REFERRAL_CODE) like upper(?) and upper(LONG_DESC) like upper(?)">
<input type="hidden" name="localeName" id="localeName" value="<%=locale%>">
<input type="hidden" name="search_T" id="search_T" value="<%=c_search.equals("")?"A":c_search%>">
<input type="hidden" name="TaskListFlag" id="TaskListFlag" value="T">
<%}
else{
	%>
	<tr><td class='fields'></td></tr>
	<input type="hidden" name="locn_code" id="locn_code" value="">
	<input type="hidden" name="locn" id="locn" value="<%=c_locn_code%>">
	<input type="hidden" name="location_type" id="location_type" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="searchbutton" id="searchbutton" value="">
	<input type="hidden" name="localeName" id="localeName" value="<%=locale%>">	
	<input type="hidden" name="search_T" id="search_T" value="">
	<input type="hidden"  name="patientname" id="patientname" value="">
	<input type="hidden" name="TaskListFlag" id="TaskListFlag" value="P">
	<%}%>
</form>

</body>
</html>
<%putObjectInBean("patTask",patTask,session);%>


