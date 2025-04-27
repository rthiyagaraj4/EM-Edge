<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="ePH.DispensedDrugDetails.label" bundle="${ph_labels}"/></title>
	<%
request.setCharacterEncoding("UTF-8");

		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	
	<script language="javascript" src="../js/OverRideBMS.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
	String bean_id				= "OverRideBMSBean";
	String bean_name			= "ePH.OverRideBMSBean";
	OverRideBMSBean bean		= (OverRideBMSBean)getBeanObject( bean_id, bean_name, request );
     bean.setLanguageId(locale);
	String order_id				= request.getParameter("order_id");
	String ord_line_no			= request.getParameter("ord_line_no");	
	String pres_drug			= request.getParameter("pres_drug");
	String pres_qty				= request.getParameter("pres_qty");

	ArrayList disp_dtls			= bean.getDispDetails(order_id,ord_line_no);
	String classValue			=	"";
	float disp_strength			=	0.0f;
	String pres_strength		= bean.getPresStrength(pres_drug,pres_qty);
%>
<form name="formOverRideBMSAlternate" id="formOverRideBMSAlternate">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<th width="80%"><fmt:message key="ePH.DispDrug.label" bundle="${ph_labels}"/></th>
	<th width="10%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
	<th width="10%">Disp Qty</th>
<% for(int i=0; i<disp_dtls.size(); i+=5) { 
			if(i%2==0)
			classValue = "QRYEVENSMALL";
		else
			classValue = "QRYODDSMALL";
%>
  <tr>
  <td class="<%=classValue%>"><%=(String)disp_dtls.get(i)%></td>
  <td class="<%=classValue%>"><%=(String)disp_dtls.get(i+1)%>&nbsp;<%=(String)disp_dtls.get(i+2)%></td>
  <td class="<%=classValue%>"><%=(String)disp_dtls.get(i+3)%>&nbsp;<%=(String)disp_dtls.get(i+4)%></td>
  </tr>
<% disp_strength	+=	Float.parseFloat((String)disp_dtls.get(i+1))*Integer.parseInt((String)disp_dtls.get(i+3));
	} 
%>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<tr>
	<th><fmt:message key="ePH.PrescribedStrength.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;<%=pres_strength%></th>
	<th><fmt:message key="ePH.DispensedStrength.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;<%=disp_strength%></th>
	<% 
		float pres_str	= Float.parseFloat(pres_strength.substring(0,pres_strength.indexOf(" ")));
	%>
	<th>Balance Qty:&nbsp;&nbsp;<%=Math.floor((pres_str-disp_strength)/pres_str)%></th>
</tr>
</table>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

