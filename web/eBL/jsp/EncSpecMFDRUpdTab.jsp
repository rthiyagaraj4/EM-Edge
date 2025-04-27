<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230228							MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getParameter("title") %></title>
</head>
<%
	String params	= request.getQueryString() == null ? "" : request.getQueryString();
	String mode	= request.getParameter("mode") == null ? "" : request.getParameter("mode");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmEncSpecMFDRUpdTab" id="frmEncSpecMFDRUpdTab"  >
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			
				<li class="tablistitem" title='Services and Item'>
				<a class="tabA" id="ServicesAndItemsCategoryDetails"  >
					<span class="tabAspan" id="ServicesAndItemsCategoryDetailsspan">
						<fmt:message key="eBL.ServicesandItem.label" bundle="${bl_labels}"/>
					</span>
				</a>
				</li> 
				
		</ul>
	</td>
</tr>
<input type='hidden' name='mode' id='mode' value="<%=mode%>" />
<input type="hidden" name="params" id="params" value=<%=params%>>
</table> 
</form>
</body>
</html>

