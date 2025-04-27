<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="beanCalendarObj" scope="page" class="eOR.OrderEntryCalendarBean"/> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="ot_view_dtl" id="ot_view_dtl" target="messageFrame" >
	<table cellpadding=0 cellspacing=0 border=1 width="98%" class="grid" >
<%   request.setCharacterEncoding("UTF-8");
	String[] records				= null;				
	String patient_id				= request.getParameter("patient_id");
	if(patient_id==null)			patient_id = "";
	String classValue				= "";
		beanCalendarObj.setLanguageId(localeName);

	ArrayList ViewApptDetails 		= beanCalendarObj.getApptDetails(patient_id);
	if(ViewApptDetails!=null) {  
%>
	<tr>
		<td class=' COLUMNHEADER ' width="15%"><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class=' COLUMNHEADER ' width="7%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER ' width="15%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER ' width="28%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER ' width="18%"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class=' COLUMNHEADER ' width="15%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
<%		for(int i=0; i<ViewApptDetails.size(); i++){
		records = (String[])ViewApptDetails.get(i);
      /*  if(i % 2 == 0){
			classValue = "QRYEVEN";
		}else{
			classValue = "QRYODD";
		}*/
		classValue="gridData";
%>
	<tr>
		<td width="15%" class="<%=classValue%>" nowrap><font size=1><%=beanCalendarObj.checkForNull(records[0],"")%></font></td>
		<td width="7%" class="<%=classValue%>"><font size=1><%=beanCalendarObj.checkForNull(records[2],"")%></font></td>
		<td width="28%" class="<%=classValue%>"><font size=1><%=beanCalendarObj.checkForNull(records[10],"")%></font></td>
		<td width="28%" class="<%=classValue%>"><font size=1><%=beanCalendarObj.checkForNull(records[7],"")%></font></td>
		<td width="18%" class="<%=classValue%>"><font size=1><%=beanCalendarObj.checkForNull(records[9],"")%></font></td>
		<td width="15%" class="<%=classValue%>"><font size=1><%=beanCalendarObj.checkForNull(records[6],"")%></font></td>
	</tr>
<%	 }
	}else { %>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		</script>
<%	} %>

<%
		// Nullifying the objects
		if(ViewApptDetails!=null) {
			ViewApptDetails.clear(); ViewApptDetails= null;
		}
%>
	</form>
</body>
</html>

