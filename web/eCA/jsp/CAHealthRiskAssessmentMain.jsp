<!DOCTYPE html>
<%/* 
---------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History   	Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------
15/03/2013		IN030469			Ramesh G		Continuous and opportunistic screening for diseases will be performed if the patient fits the criteria. 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        	Rev.date		Rev.name	Description
-------------------------------------------------------------------------------------------------------------------------------------														The general practitioner will be alerted if such patients attend the clinic.   	
28/06/2018	IN065341	Prakash C	29/06/2018		Ramesh G	MMS-DM-CRF-0115																					 
---------------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String title = request.getParameter("title");//Title Added for widget
String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");//IN065341
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<TITLE><%=title%></TITLE><!--Nijitha Title Added for widget-->

<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%//IN065341 starts
if(called_from.equals("CDR")){%>
	<FRAMESET ROWS="100%" frameborder=0 framespacing=0 >
<%}else{%>
<FRAMESET ROWS="70%,30%" frameborder=0 framespacing=0 ><!--existing line-->
<%}//IN065341 ends%>
	<FRAMESET cols='32%,43%,25%' frameborder=1 id=frameSetIdSection>
		<FRAME SRC="../../eCA/jsp/CAHealthRiskAssessmentDiagnosis.jsp?<%=request.getQueryString()%>" NAME="CAHealthRiskAssessmentDiagnosisFrm" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize>
		<FRAME SRC="../../eCommon/html/blank.html" NAME="CAHealthRiskAssessmentGraphFrm" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize>
		<FRAME SRC="../../eCommon/html/blank.html" NAME="CAHealthRiskAssessmentHealthRiskFactorsFrm" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize>
	</FRAMESET>
<%if(!called_from.equals("CDR")){%>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="CAHealthRiskAssessmentOrderCatalogFrm" scrolling='no' MARGINWIDTH='0px' MARGINHEIGHT='0px' frameborder='0' noresize>
<%}%>
</FRAMESET>
</HTML>
