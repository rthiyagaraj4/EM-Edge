<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210111             7339  	       	MOHE-CRF-0050		           Mohana Priya K
-->

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="fnShowMainTabDetails('Dailydayclrpt')">
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
<tr>
	<td  class="columnheader">
		<fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/>
	</td>
</tr>		
</TABLE>	
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">	
  <tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			<li class="tablistitem" title='<fmt:message key="eBL.Dailydayclrpt.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('Dailydayclrpt')" class="tabClicked" id="Dailydayclrpt">
					<span class="tabSpanclicked" id="Dailydayclrptspan">
						<fmt:message key="eBL.Dailydayclrpt.label" bundle="${bl_labels}"/>
					</span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.setupsplgrp.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('setupsplgrp')" class="tabA" id="setupsplgrp" >
					<span class="tabAspan" id="setupsplgrpspan">					
						<fmt:message key="eBL.setupsplgrp.label" bundle="${bl_labels}"/>					
					</span>
				</a>
			</li>
		</ul>
	</td>	
  </tr>
</table>
</body>
<input type="hidden" name="called" id="called" id="called" value="abc">
</html>

