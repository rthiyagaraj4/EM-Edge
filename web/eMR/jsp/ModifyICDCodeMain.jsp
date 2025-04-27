<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title><fmt:message key="Common.ICD.label" bundle="${common_labels}"/>
</title>

	<%
      String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMR/js/ICDCode.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
request.setCharacterEncoding("UTF-8");
String diag_srl_no=request.getParameter("diag_srl_no");
String eff_status=request.getParameter("eff_status");
String code_ind=request.getParameter("code_ind");
if ((code_ind==null) || (code_ind.equals("")) ||	(code_ind.equals("null")))
	code_ind="";
%>
<iframe name='add' id='add' 	src='../../eMR/jsp/ModifyICDCode.jsp?code_ind=<%=code_ind%>&diag_srl_no=<%=diag_srl_no%>&eff_status=<%=eff_status%>' frameborder=0 scrolling="no" style='height:95vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
</html>

