<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
	String queryString=request.getQueryString();

%>
<script>
function Call() {
	 parent.frames[1].location.href='SearchProcedureCustomListMain.jsp?<%=queryString%>'
 }

 function CallSearch() {
 	 parent.frames[1].location.href='SearchProc.jsp?<%=queryString%>'
 }

var currentTab = new String();
 currentTab = "demogrp_tab";
 function tab_click(objName) {
	 changeTab(objName);
 }

function changeTab(TabName)	{
	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
		 if (currentTab == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom List_click.gif';
		else if (currentTab == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search_click.gif';
// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

		if (TabName == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom_List.gif';
		else if (TabName == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search.gif';
//FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
		currentTab = TabName;
}
</script>
<BODY onload="tab_click('demogrp_tab')"  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<table  width='100%' cellspacing='0%' cellpadding='3%'>
<tr><td >
<a href="javascript:tab_click('demogrp_tab')" alt='Custom List'><img name='demogrp_tab' border='0' src='../../eCA/images/Custom List_click.gif' alt='Custom List' onClick='Call(this)'></img></a><a href="javascript:tab_click('cmodeaddr_tab')" alt='Search' ><img name='cmodeaddr_tab' border='0' src='../../eCA/images/Search_click.gif' alt='Search' onclick='CallSearch(this)'></img></a>
</td>
</tr>
</table>
</BODY>
</html>

