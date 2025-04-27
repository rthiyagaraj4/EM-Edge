<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
     request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src='../../eMR/js/MRProcedureList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String queryString=request.getQueryString();
%>

<BODY onload="tab_click('demogrp_tab')"  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='consultation_form' id='consultation_form'>
<a name="customlist" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' title='Custom List'>
				<a class='tabClicked' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' title='Search'>
				<a class='tabA' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabAspan'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>			
		</ul>
<BR><BR>
<a name="search" ></a> 
	<ul id="tablist" class="tablist">
		<li class='tablistitem' title='Custom List'>
				<a class='tabA' id="demogrp_tab"  onclick="tab_click('demogrp_tab')">
					<span class='tabAspan'><fmt:message key="Common.CustomList.label" bundle="${common_labels}" /></span>
				</a>
			</li>
		<li class='tablistitem' title='Search'>
				<a class='tabClicked' id="cmodeaddr_tab" onclick="tab_click('cmodeaddr_tab')">
					<span class='tabSpanclicked'><fmt:message key="Common.search.label" bundle="${common_labels}" /></span>
				</a>
			</li>			
		</ul>
<table  width='100%' cellspacing='0%' cellpadding='0%'>
<input type="hidden" name="query_string" id="query_string" value='<%=queryString%>'>
</table>
</BODY>
</html>

