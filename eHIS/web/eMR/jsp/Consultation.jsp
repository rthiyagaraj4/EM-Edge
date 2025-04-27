<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	request.setCharacterEncoding("UTF-8");
	String term_set_id =checkForNull(request.getParameter("term_set_id"));
	//String queryString=request.getQueryString();
	//out.println("<script>alert(\""+request.getQueryString()+"\")</script>");
%>

<body onload="tab_click('demogrp_tab')" onKeyDown="lockKey()">
<form name='consultation_form' id='consultation_form'>
<a name="select"  id='Select'></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' id='Custom List' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' id='Search' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' title='Level'>
				<a class='tabA' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabAspan'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' id='Select' title='Select'>
				<a class='tabClicked' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
		<BR><BR>
		<a name="search" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' id='Custom List' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem'  id='Search' title='Search'>
				<a class='tabClicked' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' id='Level' title='Level'>
				<a class='tabA' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabAspan'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' id='Select' title='Select'>
				<a class='tabA' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabAspan'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
		<BR><BR>
		<a name="customlist" id="customlist" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem'  id='Custom List' title='Custom List'>
				<a class='tabClicked' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' id='Search' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' id='Level' title='Level'>
				<a class='tabA' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabAspan'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' id='Select' title='Select'>
				<a class='tabA' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabAspan'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
		<BR><BR>
	<a name="Level" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' id='Custom List' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' id='Search' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			<% if(!(term_set_id !=null && term_set_id.equals("ICD10"))){%>
			<li class='tablistitem' id='Level' title='Level'>
				<a class='tabClicked' id="level_tab" onclick="tab_click('level_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.Level.label" bundle="${common_labels}" /></span>
				</a>
			</li>
			 <% } %>
			<li class='tablistitem' id='Select' title='Select'>
				<a class='tabA' id="rlcnts_tab" onclick="tab_click('rlcnts_tab')">
					<span class='tabAspan'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		</ul>
		<BR><BR>
<table  width='100%' cellspacing='0%' cellpadding='0%'>
<!--<td align='left' class='BODYCOLORFILLED'>
<a href=	"javascript:tab_click('demogrp_tab')" alt='Custom List'><img name='demogrp_tab' border='0' src='../../eCA/images/Custom List_click.gif' alt='Custom List' onClick='Call(this)'></img></a><a href="javascript:tab_click('cmodeaddr_tab')" alt='Search' ><img name='cmodeaddr_tab' border='0' src='../../eCA/images/Search_click.gif' alt='Search' onclick='CallSearch(this)'></img></a><a href="javascript:tab_click('rlcnts_tab')" alt='Select'><img name='rlcnts_tab' border='0' src='../../eCA/images/Select_click.gif'  onclick='CallSelect(this)' alt='Select'></img></a>
-->

<input type="hidden" name="query_string" id="query_string" value='<%=request.getQueryString()%>'>
</table>
</form>
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

