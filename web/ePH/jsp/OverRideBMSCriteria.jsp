<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		 = (String) session.getValue("facility_id");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--  <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>--> <!-- commented for MOHE-SCF-0276 -->
	<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	
	<script language="javascript" src="../js/OverRideBMS.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
	String bean_id				= "OverRideBMSBean";
	String bean_name			= "ePH.OverRideBMSBean";
	OverRideBMSBean bean		= (OverRideBMSBean)getBeanObject( bean_id, bean_name, request );
	bean.clear();

	bean.setMode(CommonRepository.getCommonKeyValue("MODE_MODIFY"));
		bean.setLanguageId(locale);
	ArrayList disp_locn		=	bean.getDispLocns();
 
%>
						
<form name="formOverRideBMS" id="formOverRideBMS">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
		<td  class="label"><fmt:message key="ePH.DispensedDateFrom.label" bundle="${ph_labels}"/></td>
		<td class="fields"><input type="text" name="dt_from" id="dt_from" value="" maxlength="10" size="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">  <!--CheckDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for RollForward from SRR - SRR20056-SCF-9379 [IN056774] -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" ><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
		<td  class="label"><fmt:message key="ePH.DispensedDateTo.label" bundle="${ph_labels}"/></td>
		<td class ="fields"><input type="text" name="dt_to" id="dt_to" value="" maxlength="10" size="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">  <!--CheckDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for RollForward from SRR - SRR20056-SCF-9379 [IN056774] -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" ><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
   	
</tr>
<tr>
		<td class="label" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td><input type="text" name="disp_locn" id="disp_locn" size="20" onKeyPress=""><INPUT TYPE="button" name="drug_lookup" id="drug_lookup" VALUE="?" CLASS="button"  onClick="searchDispLocn(disp_locn)" ><input type="hidden" name="disp_code" id="disp_code"><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
		
		<td align="right" colspan="2"> 
			<input type="button" name="btnSearch" id="btnSearch" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" class="button" onClick="callResultPage()">&nbsp;&nbsp;
		</td>
</tr>
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
</table>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

