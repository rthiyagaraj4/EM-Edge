<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RegisterOrder.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="eOR.ReferralText.label" bundle="${or_labels}"/>
	</title>

</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";
	
	RegisterOrder bean 	= (RegisterOrder)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(localeName);
	String ref_form_id = request.getParameter("id");

	String textSelected = (request.getParameter("textSelected").equals("")) ? "":request.getParameter("textSelected");

	String ref_form_text = "";
	
	if(textSelected.equalsIgnoreCase("true"))
		ref_form_text = (String ) bean.getRefFormContent();
	else
		ref_form_text = (String ) bean.getRefFormContent(ref_form_id);
		//System.err.println("CT else @@ "  + consent_text);
	
%>
<form name='formRefusalText' id='formRefusalText' id="" target='' action=''>
	<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' align="center">
			<tr>
			<td width="90%" class="label">
			<textarea name="referral_form_text" rows="20" cols="90" readonly><%=ref_form_text%></textarea>
			</td>	
		</tr>
		<tr>
			<td class="button">
			<input type="button" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='setContent();'></td>
		</tr>
	</table>
	
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<Input name='ref_form_id' id='ref_form_id' type='hidden' value='<%=ref_form_id%>'>
	<Input name='ref_form_content' id='ref_form_content' type='hidden' value='<%=ref_form_text%>'>

</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


