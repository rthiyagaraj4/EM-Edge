<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
18/12/2013  IN045729    Chowminya		Appointments slip showing a blank page for radiology orders Multi-facility
--------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
15/08/2016		IN059315		Raja S										When an appointment is given is RIS PACS for a radiology order placed from eHIS the order status in eHIS changes to Appointment Scheduled. But the actual appointment display is in order comments and in the Audit trail.
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
--------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<!--<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %> //Commented for IN059315 -->
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> <!--Added for IN059315 -->
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String appt_ref_num 			= request.getParameter("appt_ref_num");
String appt_date				= request.getParameter("appt_date");
String appt_locn	 			= request.getParameter("appt_locn");
String appt_resched_yn			= request.getParameter("appt_resched_yn");
String appt_resched_reason		= request.getParameter("appt_resched_reason");
String no_of_reschedules		= request.getParameter("no_of_reschedules");
String cont_order_ind			= request.getParameter("cont_order_ind");
String parent_order_id			= request.getParameter("parent_order_id");
//String parent_order_line_num	= request.getParameter("parent_order_line_num");//IN64543
String parent_order_line_num	= (request.getParameter("parent_order_line_num")==null||request.getParameter("parent_order_line_num").equals(""))?"1":request.getParameter("parent_order_line_num");////IN64543
String bean_id					= request.getParameter("bean_id");
String bean_name				= request.getParameter("bean_name");
String function_from			= request.getParameter("function_from");
String order_category			= request.getParameter("order_category");
String performing_facility_id	= request.getParameter("performing_facility_id");//IN045729
// IN059315 starts
//String item_narration			= request.getParameter("item_narration");//IN64543
Connection con = null; 
Boolean custSpecificFlg=false;
try
{
	con 	= ConnectionManager.getConnection(request);
	custSpecificFlg = CommonBean.isSiteSpecific(con, "CA","APPSCHEDULE_RD_RISPACS");
}
catch(Exception e) {
	e.printStackTrace();
}finally
{
	if(con != null) ConnectionManager.returnConnection(con, request);
}
//IN059315 Ends

String item_narration = "";//IN64543

if(appt_ref_num == null || appt_ref_num.equals("null"))	appt_ref_num = "";
if(appt_date == null || appt_date.equals("null"))	appt_date = "";
if(appt_locn == null || appt_locn.equals("null"))	appt_locn = "";
if(appt_resched_yn == null || appt_resched_yn.equals("null"))	appt_resched_yn = "N";
if(appt_resched_reason == null || appt_resched_reason.equals("null"))	appt_resched_reason = "";
if(no_of_reschedules == null || no_of_reschedules.equals("null"))	no_of_reschedules = "";
if(cont_order_ind == null || cont_order_ind.equals("null"))	cont_order_ind = "";
if(parent_order_id == null || parent_order_id.equals("null"))	parent_order_id = "";
if(parent_order_line_num == null || parent_order_line_num.equals("null"))	parent_order_line_num = "";
if(bean_id == null || bean_id.equals("null"))	bean_id = "";
if(bean_name == null || bean_name.equals("null"))	bean_name = "";
if(function_from == null || function_from.equals("null"))	function_from = "";
if(order_category == null || order_category.equals("null"))	order_category = "";
if(performing_facility_id == null || performing_facility_id.equals("null"))	performing_facility_id = "";//IN045729
if(item_narration == null || item_narration.equals("null"))	item_narration = ""; //IN059315

java.util.ArrayList	AppointmentDetails = new java.util.ArrayList();

if (appt_ref_num.equals("") && (!(function_from.equalsIgnoreCase("DO") || function_from.equalsIgnoreCase("CO")))) {
	if (!(cont_order_ind.equalsIgnoreCase("DO") || cont_order_ind.equalsIgnoreCase("CO"))) {
		if (function_from.equalsIgnoreCase("View") || function_from.equalsIgnoreCase("Cancel")) {
			//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
			ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);

			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);

			// persistence
			putObjectInBean(bean_id,bean,request);

		} else if (function_from.equalsIgnoreCase("ReviewStatus")) {
			//ReviewStatusBean bean = (ReviewStatusBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
			ReviewStatusBean bean = (ReviewStatusBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);

			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);

			// persistence
			putObjectInBean(bean_id,bean,request);

		} else if (function_from.equalsIgnoreCase("Complete")) {
			//CompleteOrderBean bean = (CompleteOrderBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
			CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);

			AppointmentDetails = (java.util.ArrayList)bean.getApptDetails(parent_order_id,parent_order_line_num);

			// persistence
			putObjectInBean(bean_id,bean,request);
		}
	}
} else if (!appt_ref_num.equals("")){
	String [] record 	= new String[6];
	record[0]			= appt_ref_num;
	record[1]			= appt_date;
  	record[2]			= appt_locn;
	record[3]			= appt_resched_yn;
	record[4]			= appt_resched_reason;
	record[5]			= no_of_reschedules;
	AppointmentDetails.add(record);
}

//IN64543, starts
String view_bean_id = "Or_ViewOrder" ;
String view_bean_name = "eOR.ViewOrder";
ViewOrder view_bean = (ViewOrder)getBeanObject(view_bean_id, view_bean_name, request);
item_narration = view_bean.getApptDtlsFromComments(parent_order_id, parent_order_line_num);
putObjectInBean(view_bean_id,view_bean,request);
//IN64543, ends
%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="Appointment" id="Appointment" METHOD=POST ACTION="">
<%if (AppointmentDetails.size() == 1) {%>
<Script>parent.dialogHeight = 12</Script>
<%}%>
<table cellpadding=3 cellspacing=0 border=0 align=center WIDTH='100%'>
<%if(!(custSpecificFlg  && !("".equals(item_narration)))) { %>  <!--Added for IN059315 -->
<%for(int i=0;i < AppointmentDetails.size();i++) {
	String[] record		= (String [])AppointmentDetails.get(i);
	appt_ref_num 		= record[0];
	appt_date			= record[1];
	appt_locn			= record[2];
	appt_resched_yn		= record[3];
	appt_resched_reason	= record[4];
	no_of_reschedules	= record[5];
 
%>
<tr><td class='label'><fmt:message key="eOR.AppointmentReferenceNumber.label" bundle="${or_labels}"/></TD><td class='data'><B><%=appt_ref_num%></B></td><td class='label'><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></TD><td class='data'><B><%=com.ehis.util.DateUtils.convertDate(appt_date,"DMYHM","en",localeName)%></B></td></tr>
<tr style="line-height:1"><td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
</tr>
<tr><td class='label'><fmt:message key="eOR.AppointmentLocation.label" bundle="${or_labels}"/></TD><td class='data' colspan="3"><B><%=appt_locn%></B></td></tr>
<tr style="line-height:1"><td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
</tr>
<tr><td class='label'><fmt:message key="eOR.AppointmentRescheduled.label" bundle="${or_labels}"/></TD><td class='data'><B><%=(appt_resched_yn.equals("Y")?"Yes":"No")%></B></td>
<td class="label"></td>
<td class="label"></td>
</tr>
 <% if(appt_resched_yn!=null && appt_resched_yn.equals("Y")) { %>
<tr style="line-height:1"><td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
</tr>
<tr><td  class='label'><fmt:message key="Common.RescheduledReason.label" bundle="${common_labels}"/></TD><td class='data' colspan="3"><B><%=appt_resched_reason%></B></td>
</tr>

<tr style="line-height:1"><td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
	<td class="label"></td>
</tr>
<tr>
<td class='label'><fmt:message key="eOR.NoofReschedules.label" bundle="${or_labels}"/></TD><td class='data' ><B><%=no_of_reschedules%></B></td>
<td class="label"></td>
<td class="label"></td>
</tr>
<% } %>
<%}%>
<%--<tr><td align='right' class='label'>Appointment Date:&nbsp;</TD><td align='left'><B><%=appt_date%></B></td><TD>&nbsp;</TD><TD>&nbsp;</TD></tr>--%>

<TR style="line-height:1">
	<TD></TD>
	<TD></TD>
	<TD></TD>
	<TD></TD>
</TR>

<%--<tr><TD>&nbsp;</TD><TD>&nbsp;</TD><td align=right><INPUT TYPE="button"  class="button" value="Close" onClick='window.close()'></td></tr>--%>

 	<input type="hidden" name="appt_ref_num" id="appt_ref_num" value="<%=appt_ref_num%>">
 	<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
 	<input type="hidden" name="performing_facility_id" id="performing_facility_id" value="<%=performing_facility_id%>"><!-- IN045729 -->
<!--Added for IN059315 starts -->
<%}else{%>	
<tr>
<td><%=item_narration%></td>
</tr>
<%}%>
<!--Added for IN059315 Ends-->
 </table>
</FORM>
<%
}
catch(Exception e)
{e.printStackTrace();}
%>
</BODY>
</HTML>

