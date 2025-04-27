<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
		String cname=request.getParameter("cname")==null?"":request.getParameter("cname");
		String Patient_ID= request.getParameter("patient_id");
		if(Patient_ID == null) Patient_ID="";
		String function_id= request.getParameter("option_id");
		if(function_id == null) function_id="";
		/*Below line added for ML-MMOH-CRF-0860.2*/
		String alternate_id =request.getParameter("alternate_id")==null?"":request.getParameter("alternate_id");
		
%>
	<head>
		<title><fmt:message key="Common.Demographics.label" bundle="${common_labels}"/></title>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<iframe name='detail' id='detail' src='../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID=<%=Patient_ID%>&function_id=<%=function_id%>
			&alternate_id=<%=alternate_id%>' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING='no' style='height:100vh;width:100vw'></iframe>
</html>

