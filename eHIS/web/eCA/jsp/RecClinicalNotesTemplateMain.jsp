<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
	String	operation_mode	=	"",	modal_title	=	"";
	String	template_title	=	"";

	operation_mode	=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");
	template_title	=	(request.getParameter("template_title")==null)	?	""	:	request.getParameter("template_title");

	if(operation_mode.equals("TemplateView"))
		modal_title	=	"Template Preview";
	else
		modal_title	=	template_title;

	

%>
<title><%=modal_title%></title>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
	//out.println("Query String : "+request.getQueryString());
	String height1="";
	String height2="";
	String height3="";
	String height4="";
	if(operation_mode.equals("TemplateView"))
	{
		height1="89vh";
		height2="0vh";
		height3="8vh";
		height4="0vh";
%>
<!--  
<frameset rows='87%,6%,8%,0%' framespacing='0'>
	<frame name="RecClinicalNotesTemplateFrame" frameborder="NO" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplateView.jsp?<%=request.getQueryString()%>"></frame>
	<frame name="RecClinicalNotesTemplateTBFrame" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplatePreviewView.jsp"></frame>-->

	<iframe name="RecClinicalNotesTemplateFrame" id="RecClinicalNotesTemplateFrame" style="height:<%=height1%>;width:98vw" frameborder="NO" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplateView.jsp?<%=request.getQueryString()%>"></iframe>
	<iframe name="RecClinicalNotesTemplateTBFrame" id="RecClinicalNotesTemplateTBFrame" style="height:<%=height2%>;width:98vw" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplatePreviewView.jsp"></iframe>
<%
	}
	else
	{
		height1="86vh";
		height2="0vh";
		height3="0vh";
		height4="0vh";
%>
<!-- <frameset rows='100%,0%,0%,0%' framespacing='0'>
	<frame name="RecClinicalNotesTemplateFrame" frameborder="NO" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplate.jsp?<%=request.getQueryString()%>"></frame>
	<frame name="RecClinicalNotesTemplateTBFrame" frameborder="no" scrolling="no" noresize src="../../eCommon/html/blank.html"></frame> -->
<!--<frame name="RecClinicalNotesTemplateTBFrame" frameborder="no" scrolling="no" noresize src="../../eCA/html/RecClinicalNotesTemplateOper.html"></frame> -->

	<iframe name="RecClinicalNotesTemplateFrame" id="RecClinicalNotesTemplateFrame" style="height:<%=height1%>;width:98vw" frameborder="NO" scrolling="auto" noresize src="../../eCA/jsp/RecClinicalNotesTemplate.jsp?<%=request.getQueryString()%>"></iframe>
	<iframe name="RecClinicalNotesTemplateTBFrame" id="RecClinicalNotesTemplateTBFrame" style="height:<%=height2%>;width:98vw" frameborder="no" scrolling="no" noresize src="../../eCommon/html/blank.html"></iframe>
<%
}
%>
	<iframe name="messageframe" id="messageframe" style="height:<%=height3%>;width:98vw" frameborder="no" scrolling="auto" noresize src="../../eCommon/jsp/error.jsp"></iframe>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" style="height:<%=height4%>;width:98vw" frameborder="no" scrolling="no" noresize src="../../eCommon/jsp/error.jsp"></iframe>
<!-- </frameset>  -->

</html>
