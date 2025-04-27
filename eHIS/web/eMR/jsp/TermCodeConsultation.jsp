<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>
<script>
 function Call() {
	 parent.frames[1].location.href='TermCodeCustomList.jsp?<%=queryString%>'
 }

 function CallSearch() {
 	 parent.frames[1].location.href='TermCodeSearchProblem.jsp?<%=queryString%>'
 }

 function CallSelect() {
	 	 parent.frames[1].location.href='TermCodeSearchScreenFrmes.jsp?<%=queryString%>'
 }

 var currentTab = new String();
 currentTab = "demogrp_tab";

 function tab_click(objName) {
 		// FIRST CHANGE THE CURRENT SELECTED TAB
 		changeTab(objName);
/*
 		if (objName == 'demogrp_tab')
 			parent.group_head.moveToTab(1);
 		else if (objName == 'cmodeaddr_tab')
 			parent.group_head.moveToTab(2);
 		else if (objName == 'rlcnts_tab')
 			parent.group_head.moveToTab(3);

*/
}

function changeTab(TabName)	{
	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
		 if (currentTab == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom List_click.gif';
		else if (currentTab == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search_click.gif';
		else if (currentTab == 'rlcnts_tab')
			document.getElementById("rlcnts_tab").src = '../../eCA/images/Select_click.gif';


	// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

		if (TabName == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom_List.gif';
		else if (TabName == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search.gif';
		else if (TabName == 'rlcnts_tab')
			document.getElementById("rlcnts_tab").src = '../../eCA/images/Select.gif';


	// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
		currentTab = TabName;
}

</script>

<body onload="tab_click('demogrp_tab')" onKeyDown='lockKey()'>
 <table  width='100%' cellspacing='0%' cellpadding='0%'>
<tr>
<td align='left' class='BODYCOLORFILLED'>
<a href=	"javascript:tab_click('demogrp_tab')" alt='Custom List'><img name='demogrp_tab' border='0' src='../../eCA/images/Custom List_click.gif' alt='Custom List' onClick='Call(this)'></img></a>

<a href="javascript:tab_click('cmodeaddr_tab')" alt='Search' ><img name='cmodeaddr_tab' border='0' src='../../eCA/images/Search_click.gif' alt='Search' onclick='CallSearch(this)'></img></a>

<a href="javascript:tab_click('rlcnts_tab')" alt='Select'><img name='rlcnts_tab' border='0' src='../../eCA/images/Select_click.gif'  onclick='CallSelect(this)' alt='Select'></img></a>

</tr>
</table>

</BODY>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

