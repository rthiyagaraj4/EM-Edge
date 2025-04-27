<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"   contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> <!-- To display the calendar --> 
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOR/js/ConsentDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<!-- NO style sheet is used, that is why this piece of code is kept here -->
  	<style type='text/css'>
		ADDRESS{font-style: NORMAL;} 
 	</style>
   </head>
   <title><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></title>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%

    request.setCharacterEncoding("UTF-8");
    String bean_id				=	request.getParameter("bean_id");
    String bean_name			=	request.getParameter("bean_name");
    if(bean_id ==null || bean_name==null)
	   return;
	
	String order_id				=	request.getParameter("order_id");
	String order_line_num		=	request.getParameter("order_line_num");
	String patient_id			=	request.getParameter("patient_id");
	String srl_no				=	request.getParameter("srl_no");
	String report_type			=	request.getParameter("report_type");
	String consent_ref_id		=	request.getParameter("consent_ref_id"); 
	System.out.println("order_id"+order_id);
	System.out.println("order_line_num"+order_line_num);
	System.out.println("patient_id"+patient_id);
	System.out.println("srl_no"+srl_no);
	System.out.println("report_type"+report_type);
	System.out.println("consent_ref_id"+consent_ref_id);
	if(report_type==null) report_type = "";
	if(consent_ref_id==null) consent_ref_id = "";
     // As of now from consent_orders
 	ReprintFormsBean bean		= (ReprintFormsBean)getBeanObject( bean_id, bean_name ,request) ; 
	bean.setLanguageId(localeName);
	String reprint_details		= "";
	if(report_type.equals("C"))
		reprint_details			= bean.getConsentDetails(order_id, order_line_num,consent_ref_id);
	else if(report_type.equals("X"))  // Referral
		reprint_details			= bean.getReferralDetails(order_id, order_line_num);
	else if(report_type.equals("S"))    // Refusal
		reprint_details			= bean.getRefusalDetails(order_id, order_line_num, patient_id, srl_no);
 
   	if(reprint_details==null)	reprint_details ="";
	//reprint_details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +reprint_details  ;
	reprint_details				= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>"  +reprint_details  ;
 %>


<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">


<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td class="LABELLEFT">&nbsp;</td>
	</tr>
   	<tr>
		<td class="LABELLEFT"><font size='2'><%=reprint_details%></font></td>
		
 	</tr>
	<tr>
		<td class="LABELLEFT">&nbsp;</td>
	</tr>
</table>
</form>

</body>

<%
 	reprint_details = null;
%>

</html>

