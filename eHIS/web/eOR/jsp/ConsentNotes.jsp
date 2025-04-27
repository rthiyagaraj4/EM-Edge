<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ConsentNotes.jsp-->





<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<title><fmt:message key="eOR.ConsentNotes.label" bundle="${or_labels}"/> </title>
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


	<script language="javascript" src="../../eOR/js/ConsentDetails.js"></script>
	
	
</head>
<%
String order_id = request.getParameter("order_id");
String index = request.getParameter("index");
String bean_id = request.getParameter("bean_id");
String bean_name = request.getParameter("bean_name");
String order_catalog_code = request.getParameter("order_catalog_code");
String order_catalog_desc = request.getParameter("order_catalog_desc");

//int indexInt = Integer.parseInt(index);

if(order_id == null || order_id.equals("null")) order_id =" "; else order_id = order_id.trim();
if(order_catalog_code == null || order_catalog_code.equals("null")) order_catalog_code =" "; else order_catalog_code = order_catalog_code.trim();
if(order_catalog_desc == null || order_catalog_desc.equals("null")) order_catalog_desc =" "; else order_catalog_desc = order_catalog_desc.trim();


ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,bean_name , request ) ;
HashMap consent= (HashMap)bean.getConsentDetail();
String Consent= ""; 

if(Consent == null || Consent.equals("null")) Consent =" "; else Consent = Consent.trim();
 
 /*if(Consent_detail != ""){
	Consent_detail = java.net.URLDecoder.decode(Consent_detail);
}*/

int count = 0;
String catalog_code = "",catalog_desc = "";

%>

<body   OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='formConsentNotes' id='formConsentNotes' >
<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
<%
 if(!order_catalog_code.equals("") && !order_catalog_desc.equals("") ){
	 StringTokenizer stOrder = new StringTokenizer(order_catalog_code,"||");
	 StringTokenizer stOrder1 = new StringTokenizer(order_catalog_desc,"||");
	 while(stOrder.hasMoreTokens())
	 {
		 catalog_code = stOrder.nextToken();
		 catalog_desc = stOrder1.nextToken();
	 	 Consent = (String)consent.get(index+catalog_code);
		 if(Consent == null)
			 Consent="";
		 else
			 Consent = Consent.trim();
%>
	<tr>
		<td class="Label"><%=catalog_desc%> </td>
	</tr>
	<tr>
		<td class="Label"></td>
	</tr>
<tr>
		<td class='fields'><TEXTAREA NAME="consent_form_text<%=count%>" ROWS="15" COLS="78"     onBlur='makeValidString(this)' ALIGN='ABSMIDDLE'><%=Consent%></TEXTAREA>
		<input type='hidden' name="catalog_code<%=count%>" id="catalog_code<%=count%>" value="<%=catalog_code%>">
		
		</td>
</tr>
<%  count++;
    } %>
<% } else { %>
<tr>
		<td class='fields'><TEXTAREA NAME="consent_form_text" ROWS="15" COLS="78"     onBlur='makeValidString(this)' ALIGN='ABSMIDDLE'><%=(consent.get(index)==null?"":consent.get(index))%></TEXTAREA>
		</td>
</tr>
<%	} %>
<tr>
	<td  class='button' valign='bottom' ><INPUT TYPE='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' Onclick='onCloseNotes()'><INPUT TYPE='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick='window.close()'></td></tr>

	</table>

	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
	<input type='hidden' name='index' id='index' value='<%=index%>'>
	<input type='hidden' name="count" id="count" value="<%=count%>">
	<input type='hidden' name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
	

</form>
<body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

