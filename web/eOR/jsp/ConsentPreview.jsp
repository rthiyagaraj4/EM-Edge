<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> <!-- To display the calendar --> 
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ConsentDetails.js"></script>
	<!-- added for multi consent changes 04/05/2007 -->
	<script Language="vbscript">
		Dim WSHShell
		Dim myHeader
		Dim myFooter
		Set WSHShell = CreateObject("WScript.Shell")
		'myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
		'myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")

		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&b&d"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&bPage &p of &P"

		Sub ResetHeader()
			Dim WSHShell
			Set WSHShell = CreateObject("WScript.Shell")
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", myHeader
			WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", myFooter
		End Sub

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- end of 04/05/2007 -->
	<!-- NO style sheet is used, that is why this piece of code is kept here -->
  	<style type='text/css'>
		ADDRESS{font-style: NORMAL;} 
		INPUT.TEXT_DISPLAY
		{
			background:white;  
			color: RED ;
 			border-style: none;
		}
		
		
 	</style>
  
   <title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
    </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="focusPreviewFrameset()">

<%
	request.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String bean_id				=	request.getParameter("bean_id");
    String bean_name			=	request.getParameter("bean_name");
    if(bean_id ==null || bean_name==null)
	   return;
	
	String index				=	request.getParameter("index");
	String consent_form_id		=	request.getParameter("consent_form_id");
	String new_consent_format_id=   request.getParameter("new_consent_format_id");
	String new_consent_format_label=   request.getParameter("new_consent_format_label");
	//added for multi consent on 04/05/2007
	String order_id				=   request.getParameter("order_id");
	String order_line_num		=   request.getParameter("order_line_num");
	String consent_ref_id		=   request.getParameter("consent_ref_id");
//end of 04/05/2007
     // As of now from consent_orders
 	ConsentOrders bean			= (ConsentOrders)getBeanObject( bean_id, bean_name ,request) ; 
	HashMap consentDetail		= bean.getConsentDetail();
	String consent_details		= (String)consentDetail.get(index+consent_form_id);
	//added for multi consent on 04/05/2007
	if( order_id != null && order_line_num != null){
		consent_details			= bean.getConsentDetails(order_id,order_line_num,consent_ref_id,consent_form_id);
	}
	//end of multi consent
 	if(consent_details==null)	consent_details ="";

	//consent_details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +consent_details  ;
	consent_details				= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>"  +consent_details  ;
	System.out.println("consent_details    :    "+consent_details);
	 %>


<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">


<table cellpadding=3 cellspacing=0 border=0  style='table-layout: fixed;' >	
   	<tr>		
		<td align=left id="consent_details"><font size='2'><%=consent_details%></font></td> 		
 	</tr>
	<tr>
		<td></td>
	</tr>
</table>
	<input type="hidden" name ="bean_id" value="<%=bean_id%>">
	<input type="hidden" name ="bean_name" value="<%=bean_name%>">
	<input type="hidden" name ="new_consent_format_id" value="<%=new_consent_format_id%>">
 	<input type="hidden" name ="new_consent_format_label" value="<%=new_consent_format_label%>">
 	<input type="hidden" name ="index" value="<%=index%>">
	
</form>

</body>

</html>
<%
	consentDetail = null;
	consent_details = null;
%>

