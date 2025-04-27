<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File Not returned to mrd
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='/eCIS/common/html/ecis.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='/eCIS/common/js/common.js'></script>
	<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileNotReturnedToMRD.js'></SCRIPT>
 <head>
 
 <iframe name='commontoolbarFrame' id='commontoolbarFrame' 
        src='<%=source%>' scrolling='no' frameborder='0' 
        noresize style='height:7vh; width:100vw; margin: 0; padding: 0;'></iframe>

<iframe name='searchFrame' id='searchFrame' 
        src='../../eFM/jsp/QueryFMFileNotReturnedToMRDSearch.jsp' 
        scrolling='no' frameborder='0' noresize 
        style='height:15vh; width:100vw; margin: 0; padding: 0;'></iframe>

<iframe name='searchResultFrame' id='searchResultFrame' 
        src='../../eCommon/html/blank.html' frameborder='0' 
        scrolling='no' noresize style='height:65vh; width:100vw; margin: 0; padding: 0;'></iframe>

<iframe name='searchColorFrame' id='searchColorFrame' 
        src='../../eFM/jsp/FMColorFile.jsp?p_param=QUERYMRD' 
        frameborder='0' scrolling='no' noresize 
        style='height:4vh; width:100vw; margin: 0; padding: 0;'></iframe>

<iframe name='messageFrame' id='messageFrame' 
        src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' 
        noresize style='position: absolute; bottom: 0; left: 0; width: 100vw; height: 7vh; border: none;'></iframe>



   

