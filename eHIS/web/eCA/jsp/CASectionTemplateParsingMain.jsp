<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<TITLE><fmt:message key="eCA.ParsingSectionTemplate.label" bundle="${ca_labels}"/></TITLE>
				
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
String param = request.getQueryString();
		String src = url + param;
//		out.println("<script>alert('"+src+"');</script>");

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="JavaScript" src ="../../eCA/js/CASectionTemplateParsing.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




		
</HEAD>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=src%>' scrolling = "no" noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='templateParsingFrame' id='templateParsingFrame' src='../../eCommon/html/blank.html' frameborder="no" scrolling="yes" noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>	

</HTML>

