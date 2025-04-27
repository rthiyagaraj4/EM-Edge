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
<!-- 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCP/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/AssignCareManager.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>

	function callMeOnClick(cpid)
	{
		window.opener.assign_care_manager.care_plan_id.value = "abcd";

		var patient_id = document.forms[0].patient_id.value;

		var url = '../../eCP/jsp/AssignCareManagerQueryResult.jsp?mode=view&patient_id='+patient_id+'&cpid='+cpid;
		var url1 = '../../eCP/jsp/AssignCareManagerAddModify.jsp?mode=New&patient_id='+patient_id+'&cpid='+cpid;
		var url2 = '../../eCP/jsp/AssignCareManagerToolbar.jsp';

		window.opener.parent.frames[1].frames[0].location.href = url;
		window.opener.parent.frames[1].frames[1].location.href = url1;
		window.opener.parent.frames[1].frames[2].location.href = url2;
	}

</script>
<%
		Connection cnACM = null;
		PreparedStatement pstmtACM = null;
		ResultSet rsACM = null;
		
		String strClassValue	= "";
		String strCPId		= "";
		String strGoalSt	= "";
		String strMPCDId	= "";
		String strPatientId = "";
		String strQuery		= "";

		int nRowCtr	=	0;


%>
<body>
	<center>
		<form name='assign_cp_mgr_lookup' id='assign_cp_mgr_lookup' method='post'>
		<table cellpadding=0 cellspacing=2 border=1 width='100%'>
		<th><fmt:message key="eCP.CarePlanId.label" bundle="${cp_labels}"/></th>
		<th><fmt:message key="eCP.GoalStatement.label" bundle="${cp_labels}"/></th>
	<%
		

		strMPCDId		= request.getParameter("mdcpid");
		strPatientId	= request.getParameter("patient_id");

		strQuery = "select CARE_PLAN_ID,GOAL_STATEMENT from CP_PAT_CARE_PLAN where MD_CARE_PLAN_ID=? and 						current_status in ('O','F') ";

		try
		{
			cnACM = ConnectionManager.getConnection(request);

			pstmtACM = cnACM.prepareStatement(strQuery);
			pstmtACM.setString(1, strMPCDId.trim());

			rsACM = pstmtACM.executeQuery();

			while ( rsACM.next() )
			{	
				strCPId		= rsACM.getString(1);
				strGoalSt	= rsACM.getString(2);
				
				if(nRowCtr%2==0) 
					strClassValue = "QRYEVEN";
				else 
					strClassValue = "QRYODD";

				%>
					<tr>
							<td class='<%=strClassValue%>'><a href='javascript:callMeOnClick("<%=strCPId%>")'><%=strCPId%></a>
							</td>
							<td class='<%=strClassValue%>'><%=strGoalSt%></td>
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
		//out.println(eACM);//common-icn-0181
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
<input type ="button" name ="btnTemp" id ="btnTemp" value ='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick = "callMeOnClick(345)">
<input type ="hidden" name ="patient_id" id ="patient_id" value = '<%=strPatientId%>'>
</form>
</body>
</html>

