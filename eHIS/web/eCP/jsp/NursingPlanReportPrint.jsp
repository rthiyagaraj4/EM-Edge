<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
21/05/2018 		IN067697		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/01
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.*, eCP.*, eMR.*, eCA.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@page  import="java.util.*,eOR.* ,webbeans.eCommon.ConnectionManager ,eOR.Common.*" %>
<%
	 request.setCharacterEncoding("UTF-8");

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id = "CP_ReportBean" ;
	String bean_name = "eCP.ReportBean";
	ReportBean bean = (ReportBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCP/js/NursingPlanReport.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String date_from="",date_to="";
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String userName = (String)session.getValue("appl_user_name");//IN067697
%>
	<form name="NursingPlanReportPrint" id="NursingPlanReportPrint" target="messageFrame">
		<table border=0 width='100%' cellPadding="3" cellSpacing="0"  align='center'>
		<tr>
			<td colspan=4 align='right'><INPUT TYPE="button" name="printRep" id="printRep" class="button" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onclick="printFun();"></td><!-- IN067697 controlling print button -->
		</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="p_userName" id="p_userName" value="<%=userName%>"><!-- IN067697 -->
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	</form>
	</body>
</html>

