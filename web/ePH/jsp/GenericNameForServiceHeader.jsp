<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html> 
<head>
	<%
        request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	   // 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String disabled					="";
String chk_dflt_c					="";
String chk_dflt_cn					="";
String bean_id					= "genericnameforservice" ;
String bean_name				= "ePH.GenericNameforServiceBean";
String facility_id				= (String)session.getValue( "facility_id" );
String sql_ph_am_service_select_lookup	= "";
String sql_ph_generic_name_select_lookup="";
String sql_ph_am_service_ip_op_lookup="";
String from_source	= request.getParameter( "from_source" );
GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name, request ) 
;

//Clear the bean
bean.clear();
bean.setLanguageId(locale);

boolean ip_yn=bean.ip_yn();
if(ip_yn){
	chk_dflt_c="";
	chk_dflt_cn="checked";
	disabled="";
	}else{
	chk_dflt_c="checked";
	chk_dflt_cn="";
	disabled="disabled";
}

sql_ph_am_service_ip_op_lookup=PhRepository.getPhKeyValue("SQL_PH_AM_SERVICE_IP_OP_LOOKUP");
sql_ph_am_service_select_lookup=PhRepository.getPhKeyValue("SQL_PH_AM_SERVICE_SELECT_LOOKUP");
sql_ph_generic_name_select_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT_LOOKUP");

//set the login facility id for qry execution
bean.setLoginFacilId((String)session.getValue("facility_id"));

%>
<form name="genericnameforservice_header" id="genericnameforservice_header" >
  <table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
	<tr><td colspan="6"></td></tr><tr><td colspan="6"></td></tr><tr><td colspan="6"></td></tr>
<%
if(from_source.equals( "byservice" )){
%>
	<tr>
	<td class="label"  width="5%"><input type="radio" name="choose_service" id="choose_service" <%=chk_dflt_c%> value="C" ></td><td class="label"  width="15%"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
		<td class="label" width="5%"><input type="radio" name="choose_service" id="choose_service"  <%=disabled%> <%=chk_dflt_cn%> value="CN" ></input></td><td class="label"  nowrap width="25%">
		<fmt:message key="ePH.ClinicNursingUnit.label" bundle="${ph_labels}"/></td>

		<td  class="label" width="15%">
		<fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td  width="30%">&nbsp;
			<input type="hidden" name="service_code" id="service_code" value="">
			<input type="text" name="service_desc" id="service_desc" value="" size="40" maxlength="40" ><input type="button" class="button" name="serviceCodeSearch" id="serviceCodeSearch" value="?" onClick="searchCode(service_desc)" align="left">&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<script>document.genericnameforservice_header.service_desc.focus();</script>

	<%
	}else{
	%>
		<tr>
		<td  class="label" width="30%">
		<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		<td  width="60%">&nbsp;
			<input type="hidden" name="generic_id" id="generic_id" value="" >
			<input type="text" name="generic_name" id="generic_name" value="" size="40" maxlength="40" ><input type="button" class="button" name="genericIdSearch" id="genericIdSearch" value="?" onClick="searchCode(generic_name)" align="left">&nbsp; <img src="../../eCommon/images/mandatory.gif"></img> 
		</td>
	 </tr>
	 <script>document.genericnameforservice_header.generic_name.focus();</script>
	<%
		}
	%>
	<tr>
		<td colspan="2"></td></tr><tr><td colspan="2"></td></tr><tr><td colspan="2"></td>
	</tr>
  </table>
  <input type="hidden" value="<%=from_source%>" name="from_source">
  <input type="hidden" name="sql_ph_am_service_select_lookup" id="sql_ph_am_service_select_lookup" value="<%=sql_ph_am_service_select_lookup%>">
   <input type="hidden" name="sql_ph_am_service_ip_op_lookup" id="sql_ph_am_service_ip_op_lookup" value="<%=sql_ph_am_service_ip_op_lookup%>">
   <input type="hidden" name="sql_ph_generic_name_select_lookup" id="sql_ph_generic_name_select_lookup" value="<%=sql_ph_generic_name_select_lookup%>">
  <input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
  <input type="hidden" name="locale" id="locale" value="<%=locale%>">
 </form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

