<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	%>
<html>
<head>
	<title><fmt:message key="Common.complete.label" bundle="${common_labels}"/> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../../eOR/js/CompleteOrder.js"></script> 
 	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="completeRemarks" id="completeRemarks">
<%
	String dispMand = "style='display:none'";
	String curr_sys_date_sec       = request.getParameter("curr_sys_date_sec");
	if (curr_sys_date_sec == null) curr_sys_date_sec = "";
	String curr_sys_date      = request.getParameter("curr_sys_date");
	if (curr_sys_date == null) curr_sys_date = "";
	String order_complete_date       = request.getParameter("order_complete_date");
	if (order_complete_date == null) order_complete_date = "";
	if	(order_complete_date.equals("")) order_complete_date=curr_sys_date_sec;
	String start_date_time       = request.getParameter("start_date_time");
	if (start_date_time == null) start_date_time = "";
    //String complete_date        = request.getParameter("complete_date");
	//if (complete_date == null) complete_date = curr_sys_date;
    String complete_remarks 	= request.getParameter("complete_remarks");   
	if (complete_remarks == null) complete_remarks = "";
	 String complete_remarks_mand_yn 	= request.getParameter("complete_remarks_mand_yn")==null?"": request.getParameter("complete_remarks_mand_yn");
	 if(complete_remarks_mand_yn.equals("Y"))
		dispMand = "style='display:inline'";
%>
<Table cellpadding=3 cellspacing=0 border='0' width='100%' height='100%' align='center'>
<tr><td class='label'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
<td class="fields"><input type="text" name="order_complete_date" id="order_complete_date" size="19" maxlength="19" value="<%=order_complete_date%>" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="document.completeRemarks.order_complete_date.focus();return showCalendar('order_complete_date',null,'hh:mm:ss');"  style='cursor:pointer'><img src="../../eCommon/images/mandatory.gif" <%=dispMand%>><input type=hidden name=curr_sys_date value="<%=curr_sys_date%>"><input type=hidden name=start_date_time value="<%=start_date_time%>" ></td></tr>
<tr><td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class="fields" ><TextArea rows='8' cols='30' style="margin-top:19px" name='complete_remarks' id='complete_remarks' value='' onBlur='chkRemarksLength();makeValidString(this)'><%=complete_remarks%></TextArea><img src="../../eCommon/images/mandatory.gif" align="center" <%=dispMand%>>
</td></tr>
<%--<tr><td class='label'>Date</td><td><input type="text" name="complete_date" id="complete_date" size="16" maxlength="16" value="<%=complete_date%>" onBlur="checkValidDateTime(this)" ><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('complete_date',null,'hh:mm');" style='cursor:pointer'>
</td></tr>--%>
<TR align='right'><TD  colspan='2' class='button'><Input class='button' type='button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick="closeRemarks('<%=complete_remarks_mand_yn%>')"></TD></TR>
<input type="hidden" name="complete_remarks_mand_yn" id="complete_remarks_mand_yn" value="<%=complete_remarks_mand_yn%>">
<Table>

</Form>
</Body>
</Html>

