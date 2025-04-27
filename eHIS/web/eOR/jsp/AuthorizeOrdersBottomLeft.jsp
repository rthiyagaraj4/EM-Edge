<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
?             	100            	?	        ?				?				created
17/01/2014		IN041996		Karthi L	21/01/2014		Dinesh			In CA-Summary Menu -Speciality- Pending Auth(9) - 																				Currently the count in this link is based on 																					patient's speciality only. 							
------------------------------------------------------------------------------------------------------------------------------
-->

<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.AuthoriseOrders"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_AuthoriseOrder" ;
	String bean_name = "eOR.AuthoriseOrders";
	//String disabled = "" ;
	/* Mandatory checks end */	
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";

	/*Added by Uma on 9/29/2009 for PMG-CRF-0641*/
	String PrivilegeApplicabilityAuth = (String) session.getValue("PrivilegeApplicabilityAuth");
	if(PrivilegeApplicabilityAuth == null || PrivilegeApplicabilityAuth.equals("null")) PrivilegeApplicabilityAuth ="N"; else PrivilegeApplicabilityAuth = PrivilegeApplicabilityAuth.trim();
	/*Ends Here*/

	Properties properties			= (Properties) session.getValue( "jdbc" );

	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter		= request.getParameter("filter");
	String Inc_Force_Auth		= request.getParameter("Inc_Force_Auth");
	String auth_filter		= request.getParameter("auth_filter");


	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	if(filter == null || filter.equals("null")) filter =""; else filter = filter.trim();
	if(Inc_Force_Auth == null || Inc_Force_Auth.equals("null")) Inc_Force_Auth =""; else Inc_Force_Auth = Inc_Force_Auth.trim();
	if(auth_filter == null || auth_filter.equals("null")) auth_filter =""; else auth_filter = auth_filter.trim();

	//AuthoriseOrders bean = (AuthoriseOrders)getBeanObject( bean_id, bean_name, request ) ;

	//String  auth_yn = bean.getAuthYN(practitioner_id,resp_id) ;
	String slClassValue = "";
	int total = 0;

	bean.setLanguageId(localeName);

	ArrayList PriorityData = bean.getStatusByPriority(properties,facility_id,source_type,source_code,practitioner_id,resp_id,patientId,period_from,period_to,"PO",filter,PrivilegeApplicabilityAuth,Inc_Force_Auth,auth_filter) ;
	ArrayList CategoryData = bean.getStatusByCategory(properties,facility_id,source_type,source_code,practitioner_id,resp_id,patientId,period_from,period_to,"PO",filter,PrivilegeApplicabilityAuth,Inc_Force_Auth,auth_filter) ;
%>
<form name='authorise_order_priority' id='authorise_order_priority' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=1 width="100%" align="center" class="grid">
	<tr>
		<td class="COLUMNHEADER"><fmt:message key="eOR.StatusByPriority.label" bundle="${or_labels}"/></td>
	</tr>

		<%
			for( int i=0 ; i< PriorityData.size() ; i++ ) {
				String[] record = (String[])PriorityData.get(i);
				int len=record[0].length();
				String subrec=record[0].substring(1,len);
				
				if(record[0].charAt(0)=='R'){
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					
				}
					else if(record[0].charAt(0)=='U')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					

				}
					else if(record[0].charAt(0)=='S')
				{
					
					record[0]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels").concat(subrec);
					//record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Stat.label","or_labels");
				}
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				total += Integer.parseInt(record[1]);

		%>

				<tr><td class='<%=slClassValue%>'><font size=1><a class="gidLink"  href='AuthorizeOrdersBottomRight.jsp?priority=<%=record[2]%>&priority_desc=<%=record[0]%>&total_recs=<%=record[1]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%=record[0]%></a><b>(<%=Integer.parseInt(record[1])%>)</b></font></td></tr> <!-- modified for IN041996 -->
				<!--<tr><td class='<%//=slClassValue%>'><font size=1><a class="gidLink"  href='AuthorizeOrdersBottomRight.jsp?priority=<%//=record[2]%>&priority_desc=<%//=record[0]%>&total_recs=<%//=record[1]%>&source_type=<%//=source_type%>&source_code=<%//=source_code%>&patientId=<%//=patientId%>&period_from=<%//=period_from%>&period_to=<%//=period_to%>&filter=<%//=filter%>"&auth_filter=<%//=auth_filter%>&Inc_Force_Auth=<%//=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%//=record[0]%></a><b>(<%//=Integer.parseInt(record[1])%>)</b></font></td></tr> --><!-- commented for IN041996 -->
				
		<%
			}
		%>
		<%if(total !=0){%>
		<tr><td class='cagroup' bgcolor='#D5E2E5'>
			<!-- <a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?order_by=P&total_recs=<%//=total%>&source_type=<%//=source_type%>&source_code=<%//=source_code%>&patientId=<%//=patientId%>&period_from=<%//=period_from%>&period_to=<%//=period_to%>&filter=<%//=filter%>"&auth_filter=<%//=auth_filter%>&Inc_Force_Auth=<%//=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%//=total%>)</B></a> --> <!-- commented for IN041996 -->
			<a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?order_by=P&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a> <!-- modified for IN041996 -->

			</td></tr>
		<%}%>

	<tr>
		<td class=COLUMNHEADER><fmt:message key="eOR.StatusByCategory.label" bundle="${or_labels}"/></td>
	</tr>
		<%
		total = 0;
		for( int i=0 ; i< CategoryData.size() ; i++ ) {
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				String[] record = (String[])CategoryData.get(i);
				total += Integer.parseInt(record[2]);

				//PriorityData.clear();
				//CategoryData.clear();

		%>

				<tr><td class='<%=slClassValue%>'><font size=1><a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?ord_cat=<%=record[1]%>&ord_cat_desc=<%=record[0]%>&total_recs=<%=record[2]%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%=record[0]%></a><b>(<%=Integer.parseInt(record[2])%>)</b></font></td></tr>  <!-- modified for IN041996 -->
				
				<!-- <tr><td class='<%=slClassValue%>'><font size=1><a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?ord_cat=<%//=record[1]%>&ord_cat_desc=<%//=record[0]%>&total_recs=<%//=record[2]%>&source_type=<%//=source_type%>&source_code=<%//=source_code%>&patientId=<%//=patientId%>&period_from=<%//=period_from%>&period_to=<%//=period_to%>&filter=<%//=filter%>"&auth_filter=<%//=auth_filter%>&Inc_Force_Auth=<%//=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%//=record[0]%></a><b>(<%//=Integer.parseInt(record[2])%>)</b></font></td></tr> --> <!-- commented for IN041996 -->

		<%
			}
		%>
			<!--<tr><td class='cagroup' ><%if(total !=0){%><a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?order_by=O&total_recs=<%//=total%>&source_type=<%//=source_type%>&source_code=<%//=source_code%>&patientId=<%//=patientId%>&period_from=<%//=period_from%>&period_to=<%//=period_to%>&filter=<%//=filter%>"&auth_filter=<%//=auth_filter%>&Inc_Force_Auth=<%//=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%}%><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%//=total%>)</B></a></font></td></tr> --> <!-- commented for IN041996 -->
			
			<tr><td class='cagroup' bgcolor='#D5E2E5'><%if(total !=0){%><a class="gridLink" href='AuthorizeOrdersBottomRight.jsp?order_by=O&total_recs=<%=total%>&source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&auth_filter=<%=auth_filter%>&Inc_Force_Auth=<%=Inc_Force_Auth%>' target='AuthorizeOrdersBottomRight'><%}%><fmt:message key="Common.all.label" bundle="${common_labels}"/><B>(<%=total%>)</B></a></font></td></tr> <!-- modified for IN041996 -->
</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="help_function_id" id="help_function_id" value="AUTHORIZE_ORDERS">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>
</body>
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

