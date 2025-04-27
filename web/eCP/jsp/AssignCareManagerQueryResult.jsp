<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
--%>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/AssignCareManager.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<center>
		<form name='assign_cp_mgr_result' id='assign_cp_mgr_result' method='post'>
		<table cellpadding=0 cellspacing=0 border=1 width='100%'>
		<th><fmt:message key="eCP.CarePlanManager.label" bundle="${cp_labels}"/></th>
		<th><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eCP.PeriodUpto.label" bundle="${cp_labels}"/></th>
		<tr></tr>


<%
	
	Connection cnACM = null;
	PreparedStatement pstmtACM = null;
	ResultSet rsACM = null;

	String strMPCDId		= "";
	String strPatientId		= "";
	String strQuery			= "";
	String strClassValue	= "";
	String strCPMgrName		= "";
	String strCPMgrFrom		= "";
	String strCPMgrUpto		= "";
	String strCPId			= "";

	int nRowCtr			= 0;
	
	try
	{
		strMPCDId	= request.getParameter("mdcp_id");
		strCPId		= request.getParameter("cp_id");
		strPatientId = request.getParameter("patient_id");		
		if(strMPCDId == null) 
			strMPCDId = "";

		if(strPatientId == null) 
			strPatientId = "";

		if(strCPId == null) 
			strCPId = "";


		cnACM = ConnectionManager.getConnection(request);

//		strQuery = "SELECT A.CARE_MANAGER_ID code,B.practitioner_name description,TO_CHAR(A.EFF_DATE_FROM,'DD/MM/YYYY HH24:MI') EFFFROM, TO_CHAR(A.EFF_DATE_TO,'DD/MM/YYYY HH24:MI') EFFUPTO  from CP_PAT_CARE_PLAN_MANAGER A, 	am_practitioner B where A.CARE_PLAN_ID = ? AND A.PATIENT_ID = ? AND upper(B.practitioner_id) = upper(A.CARE_MANAGER_ID) ORDER BY A.EFF_DATE_FROM,A.CARE_MANAGER_ID,A.SRL_NO ";
		strQuery = "SELECT A.CARE_MANAGER_ID code,B.practitioner_name description,TO_CHAR(A.EFF_DATE_FROM,'DD/MM/YYYY HH24:MI') EFFFROM, TO_CHAR(A.EFF_DATE_TO,'DD/MM/YYYY HH24:MI') EFFUPTO  FROM CP_PAT_CARE_PLAN_MANAGER A, 	am_practitioner_lang_vw B WHERE A.CARE_PLAN_ID = ? AND A.PATIENT_ID = ? AND UPPER(B.practitioner_id) = UPPER(A.CARE_MANAGER_ID) AND b.language_id = ? ORDER BY A.EFF_DATE_FROM,A.CARE_MANAGER_ID,A.SRL_NO";
		
		pstmtACM = cnACM.prepareStatement(strQuery);
		pstmtACM.setString(1, strCPId.trim());
		pstmtACM.setString(2, strPatientId.trim());
		pstmtACM.setString(3, locale);

		rsACM = pstmtACM.executeQuery();

		while (rsACM.next() )
		{
			if(nRowCtr%2==0) 
				strClassValue = "QRYEVEN";
			else 
				strClassValue = "QRYODD";
			
			strCPMgrName	= rsACM.getString(2);
			strCPMgrFrom	= com.ehis.util.DateUtils.convertDate(rsACM.getString(3),"DMYHM","en",locale);
			if(rsACM.getString(4) == null || rsACM.getString(4).equals(""))
				strCPMgrUpto	= "&nbsp";
			else
				strCPMgrUpto	= com.ehis.util.DateUtils.convertDate(rsACM.getString(4),"DMYHM","en",locale);

			if(strCPMgrUpto == null)
				strCPMgrUpto = "";
			%>
				<tr>
					<td class = '<%=strClassValue%>'><%=strCPMgrName%> </td>
					<td class = '<%=strClassValue%>'><%=strCPMgrFrom%> </td>
					<td class = '<%=strClassValue%>'><%=strCPMgrUpto%> </td>
				</tr>

			<%

			nRowCtr++;

		}
		%>
			</table>
			<%
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
</form>
</body>
</html>

