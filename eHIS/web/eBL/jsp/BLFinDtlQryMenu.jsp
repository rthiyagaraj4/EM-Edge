<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<head>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%
		String params = request.getQueryString() ;
%>


<!--<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="../../eCommon/jsp/commonToolbar.jsp?"<%=params %>  frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
 <iframe name='qry_det_tab' id='qry_det_tab' 	src='BLFinDtlQryMenuTab.jsp' frameborder=0 scrolling='no' noresize style='height:2vh;width:100vw'></iframe>
<iframe name='qry_det_tab_body' id='qry_det_tab_body'		src='BLFinDtlQryMenuTabBody.jsp?tab_chk=pymtdet_tab' frameborder=0 scrolling='no' style='height:30vh;width:100vw' ></iframe>
 <iframe name='qry_det' id='qry_det' 	src='BLFinDtlQryMenuFrame.jsp' frameborder=0 scrolling='no' noresize style='height:58vh;width:100vw'></iframe>

<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:5vh;width:100vw'></iframe>


