<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210119              7339  	       	MOHE-CRF-0050		           Mohana Priya K
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eBL/js/dailycashTabFrame.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="fnShowMainTabDetails('reportservgp')">
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">	
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
				<li class="tablistitem" title=<fmt:message key="eBL.Reportingservgrp.label" bundle="${bl_labels}"/>>
				<a onclick="fnShowMainTabDetails('reportservgp')" class="tabClicked" id="reportservgp">
					<span class="tabSpanclicked" id="reportservgpspan">
						<fmt:message key="eBL.Reportingservgrp.label" bundle="${bl_labels}"/>
						</span></a>
			</li>
			<li class="tablistitem" title=<fmt:message key="eBL.Assocservrptservgrp.label" bundle="${bl_labels}"/>>
				<a onclick="fnShowMainTabDetails('assocservgp')" class="tabA" id="assocservgp" >
					<span class="tabAspan" id="assocservgpspan">					
					<fmt:message key="eBL.Assocservrptservgrp.label" bundle="${bl_labels}"/>					
					</span></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>
<input type="hidden" name="called" id="called" id="called" value="setgrptab">
</body>
</html>

