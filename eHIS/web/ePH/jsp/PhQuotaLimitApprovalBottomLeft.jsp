<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
%>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="ePH.QuotaLimitApprovalOrders"/>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PhQuotaLimitApproval.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
		
		String practitioner_id = (String)session.getValue("ca_practitioner_id");
		String facility_id = (String)session.getValue("facility_id");
		String resp_id = (String)session.getValue("responsibility_id");
		if(resp_id== null)resp_id = "";
		
		Properties properties			= (Properties) session.getValue( "jdbc" );

		String source_type		= request.getParameter( "source_type" ) ;
		String source_code		= request.getParameter( "source_code" ) ;
		String patientId  	    = request.getParameter("patientId");
		String period_from		= request.getParameter("period_from");
		String period_to		= request.getParameter("period_to");
		String specialtyCode		= request.getParameter("specialtyCode");


		if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
		if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
		if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
		if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
		if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
		if(specialtyCode == null || specialtyCode.equals("null")) specialtyCode =""; else specialtyCode = specialtyCode.trim();
		
		String slClassValue = "";
		int total = 0;

		bean.setLanguageId(localeName);

		ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,"PQ",specialtyCode) ;
		
	%>
		<form name='QuotaLimitApprovalBottomLeftFrm' id='QuotaLimitApprovalBottomLeftFrm' target='messageFrame' >
			<table cellpadding=3 cellspacing=0 border=1 width="100%" align="center" class="grid">
				<tr>
					<td class="columnheader"><fmt:message key="eOR.StatusByPriority.label" bundle="${or_labels}"/></td>
				</tr>

				<%
				for( int i=0 ; i< PriorityData.size() ; i++ ) {
					String[] record = (String[])PriorityData.get(i);
					int len=record[0].length();
					String subrec=record[0].substring(1,len);							
					if(record[0].charAt(0)=='R'){
						record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels").concat(subrec);					
					}else if(record[0].charAt(0)=='U'){					
						record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels").concat(subrec);
					}else if(record[0].charAt(0)=='S'){					
						record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels").concat(subrec);
					}
					slClassValue="gridData";
					total += Integer.parseInt(record[1]);
				%>
					<tr>
						<td class='<%=slClassValue%>'>
							<font size=1><a class="gidLink"  href='PhQuotaLimitApprovalBottomRight.jsp?priority=<%=record[2]%>&priority_desc=<%=record[0]%>&total_recs=<%=record[1]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>' target='QuotaLimitApprovalBottomRight'><%=record[0]%></a><b>(<%=Integer.parseInt(record[1])%>)</b></font>
						</td>
					</tr>				
				<%
				}
				if(total !=0){%>
					<tr>
						<td class='cagroup' >
							<a class="gridLink" href='PhQuotaLimitApprovalBottomRight.jsp?order_by=P&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>' target='QuotaLimitApprovalBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a>
						</td>
					</tr>
				<%}%>						
			</table>

			<!--<input type="hidden" name="help_function_id" id="help_function_id" value="AUTHORIZE_ORDERS">-->
		</form>
	</body>
</html>

