<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/OncologyRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String showButtons		= request.getParameter("showButtons") == null ? "":request.getParameter("showButtons");
	String displayOverride  = "display:none";
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="oncologyDrugDetailButtons" id="oncologyDrugDetailButtons">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>

<%
	if (showButtons.equals("Y")) {
		String limit_ind	= request.getParameter("limit_ind");
		String allergy_yn	= request.getParameter("allergy_yn");
		String current_rx	= request.getParameter("current_rx");
	
		if (limit_ind.equals("N") || allergy_yn.equals("Y") || current_rx.equals("Y")) {
			displayOverride = "";
		}
		else {
			displayOverride = "display:none";
		}
%>
		<td id="over_ride"  style="<%=displayOverride%>" width="20%" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" NOWRAP><a href id="override_link" CLASS="MENUHIGHERLEVELLINK" STYLE="color:white" onMouseOver="changeCursor(this);" onClick="showOverRideRemarks()"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></a></td>
		<td id="over_ride_mand" style="<%=displayOverride%>" width="5%">&nbsp;<img src="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></TD>

		<td width="75%"  >
		</TD>

<%
	}
	else {
%>

		<td height="20">&nbsp;</td>

<%
	}
%>

	</tr>
	</table>
</form>
</body>
</html>

