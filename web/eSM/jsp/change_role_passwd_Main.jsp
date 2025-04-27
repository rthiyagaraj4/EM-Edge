<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/></title>
<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
			
</head>
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String ObjVal = request.getParameter("ObjVal"); 	
	String  idH1 = request.getParameter("idH1");
	String  idH2 = request.getParameter("idH2");
	String  idH3 = request.getParameter("idH3");
	
	String  pw1 = request.getParameter("pw1");
	String  pw2 = request.getParameter("pw2");
	String  pw3 = request.getParameter("pw3");
	
	String  enab1 = request.getParameter("enab1");
	String  enab2 = request.getParameter("enab2");
	String  enab3 = request.getParameter("enab3");
	
	
%>

	<iframe name='cancel_role_form' id='cancel_role_form' 	 src="change_role_passwd.jsp?ObjVal=<%=ObjVal%>&idH1=<%=idH1%>&idH2=<%=idH2%>&idH3=<%=idH3%>&pw1=<%=pw1%>&pw2=<%=pw2%>&pw3=<%=pw3%>&enab1=<%=enab1%>&enab2=<%=enab2%>&enab3=<%=enab3%>" frameborder=0 scrolling='auto' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame1' id='messageFrame1' 	 src="../../eCommon/jsp/error.jsp" frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>

</html>

