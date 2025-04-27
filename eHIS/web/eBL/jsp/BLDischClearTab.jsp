<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eBL/js/BLDischClear.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String mode	= request.getParameter("mode") == null ? "" : request.getParameter("mode");

	try{
		
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="onLoad()">
<form name="BlDischargeClearanceTab" id="BlDischargeClearanceTab" >
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			<li class="tablistitem" title='<fmt:message key="eBL.GEN_DISC_CLEARANCE.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('GenDiscClearance')" class="tabA" id="GenDiscClearance">
					<span class="tabAspan" id="GenDiscClearancespan">
						<fmt:message key="eBL.GEN_DISC_CLEARANCE.label" bundle="${bl_labels}"/>
					</span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.REP_CAN_DISC_CLEARANCE.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('CancelDiscClearance')" class="tabA" id="CancelDiscClearance"  >
					<span class="tabAspan" id="CancelDiscClearancespan">
						<fmt:message key="eBL.REP_CAN_DISC_CLEARANCE.label" bundle="${bl_labels}"/>
					</span>
				</a>
			</li>				
		</ul>
	</td>
</tr>
<input type='hidden' name='last_link' id='last_link' value="GenDiscClearance"/>
<input type='hidden' name='mode' id='mode' value="<%=mode%>" />
<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
</table>
<script>
changeMainTabClass("GenDiscClearance",parent.BLDischClearTabs)</script> 

</form>
</body>
<%
	}catch(Exception e)	{
		System.err.println("Exception in BLDischargeClearanceTab.jsp : "+e);
	}finally{
		
	}
%>		
</html>

