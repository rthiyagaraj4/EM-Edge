<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* ,java.sql.*, eCommon.Common.*,java.util.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	
<%
		request.setCharacterEncoding("UTF-8");
		String locale						=		(String)session.getAttribute("LOCALE");
		String sStyle						=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/RequestStatus.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//	java.util.HashMap defaultParameter		=		null;
	String bean_id							=		"requestStatusBean";
	String bean_name						=		"eSS.RequestStatusBean";
//	String disabled							=		"";
//	String facility_id						=		(String) session.getValue("facility_id");

	RequestStatusBean bean					=		(RequestStatusBean) getBeanObject( bean_id, bean_name,  request);	
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap alstartdate           = bean.getDurationforStartDate();
    String to_date			  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String from_date		  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

%>
<body onload='FocusFirstElement();showTrayDtl();' onMouseDown="CodeArrest()">
	
	<form name="RequestStatusQuery" id="RequestStatusQuery" action="../../eSS/jsp/RequestStatusQueryResult.jsp" method="post" target="qryResultRequestStatus">
	<br>
			<table border="0" cellpadding="0" cellspacing="0" width='100%'>
				<tr>
					<td colspan='6'>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><input type="text" maxLength=10 size=10 name="from_date" id="from_date" value= "<%=from_date%>" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');"></img><%=bean.getImage("M")%></td>
					<td class=label ><fmt:message key="Common.todate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label ><input type="text" maxLength=10 size=10 name="to_date" id="to_date" value= "<%=to_date%>" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');"></img></td>
					<td " class="label" ><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="entry_completed_yn" id="entry_completed_yn" >
					<%=bean.getEntered_List()%>
					</select></td>
				</tr>
				<tr>
				    
					<td  class="label" ><fmt:message key="eSS.Authorization.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td>&nbsp;<select name="authorized_yn" id="authorized_yn" >
					<%=bean.getAuthorized_List()%>
					</select></td>
				
					<td  class="label" ><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td>&nbsp;<select name="issued_yn" id="issued_yn" >
					<%=bean.getIssued_List()%>
					</select></td>
					<td  class="label" ><fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="cancelled_yn" id="cancelled_yn" >
					<%=bean.getCancelled_List()%>
					</select></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eSS.ReqByStore.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><select name="req_by_store" id="req_by_store" > <%=bean.getReqByStores()%></select>&nbsp;</td>
					<td class=label  ><fmt:message key="eSS.ReqOnStore.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><select name="req_on_store" id="req_on_store" > <%=bean.getReqOnStores()%></select>&nbsp;</td>
					<td  class="label" ><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="req_type" id="req_type" >
					<%=bean.getRequest_Type_List()%>
					</select></td>
									
				</tr>
				<tr><td colspan='10'>&nbsp;</td>
				</tr>
				<tr>
				<td colspan='5' >&nbsp;</td>
					<td colspan='6' ><input type="button" value="Search" class="BUTTON" onClick="showTrayDtl();"></td>
				</tr>
			</table>
				<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="1,2,3">
				<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
				<input type="hidden" name="p_system_date" id="p_system_date"			value="<%=to_date%>">
		</form>
		
	</body>
</html>

