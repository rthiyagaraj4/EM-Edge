<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");%> 
<% 
	request.setCharacterEncoding("UTF-8"); 
	String display_clos_btn=request.getParameter("display_clos_btn");
	if(display_clos_btn==null||display_clos_btn.equals("null")){
		display_clos_btn="Y";
	}
%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED.
*	Application		:	eMR.
*	Purpose 		:	This page is used in CA.
*	Created By		:	Vinay.
*	Created On		:	07 Feb 2005.
--%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='f_term_result_header' id='f_term_result_header' 	src='../../eMR/jsp/SelectTermCodeResultHeader.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
<iframe name='f_term_code_result' id='f_term_code_result' 	src='../../eMR/jsp/SelectTermCodeResult.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto' style='height:50vh;width:100vw'></iframe>
	<iframe name='f_term_selected_frms' id='f_term_selected_frms' 	src='../../eMR/jsp/SelectTermCodeSelectionFrameset.jsp?<%=request.getQueryString()%>' frameborder=0 noresize style='height:30vh;width:98vw'></iframe>
	<iframe name='f_sel_term_buttons' id='f_sel_term_buttons' 	src='../../eMR/jsp/SelectTermCodeButtons.jsp?display_clos_btn=<%=display_clos_btn%>' frameborder=0 noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:40vh;width:100vw'></iframe>
</head>
</html>

