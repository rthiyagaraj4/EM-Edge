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
<html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/AssignCareManager.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection cnACM = null;
	PreparedStatement pstmtACM = null;
	ResultSet rsACM = null;
	
	String strMDCPId	= "";
	String strPatientId = "";
	String strQuery = "";

	try
	{
		strPatientId        = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

		if(strPatientId==null) 
			strPatientId = "";

		cnACM = ConnectionManager.getConnection(request);

		// Query to get the Care Plan Id for the Patient
		strQuery =  "SELECT MD_CARE_PLAN_ID FROM CP_PAT_MD_CARE_PLAN WHERE PATIENT_ID=? AND STATUS='A'";


		pstmtACM = cnACM.prepareStatement(strQuery);
		pstmtACM.setString(1, strPatientId.trim());

		rsACM = pstmtACM.executeQuery();
	
		if( rsACM.next() )
			strMDCPId = rsACM.getString(1);
	}
	catch (Exception eACM)
	{
		//out.println(eACM);//COMMON-ICN-0181
         eACM.printStackTrace();//COMMON-ICN-0181
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
<form name='assign_care_manager' id='assign_care_manager'>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center'>
<tr>
</tr>
<tr>
		<td class="label" align='right' width='22%'><fmt:message key="eCP.CarePlans.label" bundle="${cp_labels}"/></td>
		<td class="label" align='left' >&nbsp;
		<input type=text name="care_plan_desc" id="care_plan_desc" size=60 maxlength=60 onBlur="viewCarePlans('T',care_plan_desc);">&nbsp;<input type=button class=button value="?" name="assign_cp_mgr_button" id="assign_cp_mgr_button" onclick="viewCarePlans('B',care_plan_desc);">
		<input type="hidden" name ="care_plan_id">
		</td>
</tr>
</table>
<input type ="hidden" name ="patient_id" value = '<%=strPatientId%>'>
<input type ="hidden" name ="mdcp_id"	value = '<%=strMDCPId%>'>
</form>
</body>
</html>





