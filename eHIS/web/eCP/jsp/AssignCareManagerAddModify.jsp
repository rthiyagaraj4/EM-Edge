<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
--%>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/AssignCareManager.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	Connection cnACM = null;
	PreparedStatement pstmtACM = null;
	ResultSet rsACM = null;

	String facility_id=(String)session.getValue("facility_id");

	String strQuery		= "";
	String strCurDate	= "";
	String strMPCDId	= "";
	String strPatientId	= "";
	String strCPId		= "";

	try
	{
		strMPCDId = request.getParameter("mdcp_id");
		strCPId   = request.getParameter("cp_id");
		strPatientId = request.getParameter("patient_id");		
		if(strMPCDId == null)
			strMPCDId = "";

		if(strCPId == null)
			strCPId = "";

		if(strPatientId == null)
			strPatientId = "";

		cnACM = ConnectionManager.getConnection(request);
		strQuery = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') AS CURDATE FROM DUAL";
		pstmtACM = cnACM.prepareStatement(strQuery);
		rsACM = pstmtACM.executeQuery();

		if(rsACM.next() )
		{
			strCurDate = com.ehis.util.DateUtils.convertDate(rsACM.getString(1),"DMYHM","en",locale);
		}
	}
	catch (Exception eACM)
	{
		out.println(eACM);
	}
	finally
	{
		try
		{
			if(rsACM != null)
				rsACM.close();

			if(pstmtACM != null)
				pstmtACM.close();

			if(cnACM != null)
				ConnectionManager.returnConnection(cnACM);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}	
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name ="assign_cmgr_addmodify" id ="assign_cmgr_addmodify" method = "post" action = "../../servlet/eCP.AssignCareManagerServlet" target = 'messageFrame'>
<table border='0' cellpadding='0' cellspacing='0' width="100%" align="center">
<tr>
	<th align='left'><fmt:message key="eCP.AssignNewCarePlanManager.label" bundle="${cp_labels}"/></th>
	<th></th><th></th><th></th><th></th><th></th>
	</tr>
	<tr></tr><tr></tr>	<tr></tr><tr></tr>	<tr></tr><tr></tr>	<tr></tr><tr></tr>	<tr></tr><tr></tr>
</table>

<table border='0' cellpadding='0' cellspacing='2' width="65%" align="center">
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>">
<tr>
	<td  colspan=1 class=label><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
	<td align="left" colspan=6 class="label"><input type="text"  align = left name="assign_cmgr_desc" id="assign_cmgr_desc" size="50" maxlength="55" onBlur="viewAssignMgr('T',assign_cmgr_desc)">
	<input type=button class=button value="?" name="assign_cp_mgr_button" id="assign_cp_mgr_button" onclick="viewAssignMgr('B',assign_cmgr_desc)">
	<input type ="hidden" name ="assign_cpmgr_id">
	</td>
</tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>
<tr><td class=label colspan = 6></td></tr>

	<td align=right class=label width="25%"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td><input type="text"  name="cm_frdate" id="cm_frdate" size="17" value = '<%=strCurDate%>' readonly maxlength="10"></td>
	<td align=right class=label width="18%"><fmt:message key="eCP.PeriodUpto.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
	<td><input type="text"  name="cm_todate" id="cm_todate" size="17" readonly maxlength="10">
	</td>
</tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>
<tr><td colspan = 6></td></tr>

</table>
<input type ="hidden" name ="patient_id"	value = '<%=strPatientId%>'>
<input type ="hidden" name ="cp_id"			value = '<%=strCPId%>'>
<input type ="hidden" name ="mdcp_id"		value = '<%=strMPCDId%>'>
<input type ="hidden" name ="locale"		value = '<%=locale%>'>
</form>
</body>
</html>

