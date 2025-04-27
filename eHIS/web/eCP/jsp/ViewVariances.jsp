<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
%>
	<iframe name='f_query_header' id='f_query_header' 	src='../../eCP/jsp/ViewVariancesTitle.jsp' scrolling = 'no' frameborder=0 noresize style='height:6vh;width:100vw'></iframe>
		 <iframe name='f_query_detail' id='f_query_detail' src='../../eCP/jsp/ViewVariancesResult.jsp?patient_id=<%=patient_id%>' scrolling = 'auto' frameborder=0 noresize style='height:94vh;width:100vw'></iframe>
	
</HEAD>
</HTML>

