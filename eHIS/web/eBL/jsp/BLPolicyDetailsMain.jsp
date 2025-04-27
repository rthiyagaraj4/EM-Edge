<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
//The following changes are done for Internationalisation Process
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");

	String cust_code=request.getParameter("cust_code");
	String policy_code=request.getParameter("policy_code");
	String clinic_code = request.getParameter("clinic_code");
	String visit_type_code = request.getParameter("visit_type_code");
	

	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	if(clinic_code==null) clinic_code = "";
	if(visit_type_code==null) visit_type_code = "";
	
	//out.println("<script>alert('"+cust_code+"')</script>");
	//out.println("<script>alert('"+policy_code+"')</script>");
	//out.println("<script>alert('"+clinic_code+"')</script>");
	//out.println("<script>alert('"+visit_type_code+"')</script>");

	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	policy_code = java.net.URLEncoder.encode(policy_code);
%>
<head>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<!-- 	<title>Policy Details</title> -->
 	<title><fmt:message key="eBL.POLICY_DTL.label" bundle="${bl_labels}"/></title>
	</head>

<iframe SRC="BLPolicyDetailsCriteria.jsp?cust_code=<%=cust_code%>&policy_code=<%=policy_code%>&clinic_code=<%=clinic_code%>&visit_type_code=<%=visit_type_code%>" name='frame1' id='frame1' frameborder=0 scrolling='yes' noresize style='height:28vh;width:100vw'></iframe>
	<iframe SRC="BLPolicyDetailsResults.jsp?cust_code=<%=cust_code%>&policy_code=<%=policy_code%>" frameborder=0 name='frame2' id='frame2' scrolling='no' noresize style='height:66vh;width:100vw'></iframe>
	<iframe SRC="BLPolicyDetailsClose.jsp" frameborder=0 name='frame3' id='frame3' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>


