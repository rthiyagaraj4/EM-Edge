<!DOCTYPE html>
<html>
<%@ page import="java.util.*"%>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8"); %>

<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>

<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../eXH/js/drginterface.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
try
{
HashMap map = (HashMap)request.getAttribute("results");

String drgMdc = (String)map.get("mdc");
String drgVal = (String)map.get("drg");
String drgRw = (String)map.get("rw");
String drgWtlos = (String)map.get("wtlos");
String drgOt = (String)map.get("ot");
String drgAdjrw = (String)map.get("adjrw");
String drgError = (String)map.get("err");
String drgWarn = (String)map.get("warn");
String callos = (String)map.get("Callos");
String result = (String)map.get("result");
String drgException = (String)map.get("drgErrMsg");
String drgStatus = (String)map.get("drgErrCode");
%>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="chkExceptions();">
<FORM name="drg_query_results_form" id="drg_query_results_form" method="post">

<DIV ID="drgResultsDiv">
<TABLE cellspacing='0' cellpadding='0' width='100%' align=center>
<TR><TD colspan="8" class='fields'>&nbsp;</TD></TR>
<!-- <TR><TD colspan="8" class="HEADER"><CENTER><FONT size="4"><fmt:message key="eMR.DRGResults.label" bundle="${mr_labels}"/></CENTER></TD></TR> -->
<TR><TD colspan="8" class="HEADER"><CENTER><FONT size="4">DRG Results</CENTER></TD></TR>
<TR><TD colspan="8" class='fields'>&nbsp;</TD></TR>
<TR>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.MDC.label" bundle="${mr_labels}"/></TD>	-->
	<TD class="label" COLSPAN="1">MDC</TD>
	<TD colspan="7" class='fields'><INPUT TYPE="text" name="drg_mdc" id="drg_mdc" ID="drg_mdc" VALUE="<%=drgMdc%>" DISABLED></TD></TR>
<TR>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.DRG.label" bundle="${mr_labels}"/></TD>	-->
	<TD class="label" COLSPAN="1">DRG</TD>
	<TD class='fields' colspan="7"><INPUT TYPE="text" name="drg_drg" id="drg_drg" ID="drg_drg" VALUE="<%=drgVal%>" DISABLED></TD>
</TR>
<TR>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.RW.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">RW</TD>
	<TD class='fields' COLSPAN="1"><INPUT TYPE="text" name="drg_rw" id="drg_rw" ID="drg_rw" VALUE="<%=drgRw%>" DISABLED></TD>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.WTLOS.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">WTLOS</TD>
	<TD class='fields' COLSPAN="1"><INPUT TYPE="text" name="drg_wtlos" id="drg_wtlos" ID="drg_wtlos" VALUE="<%=drgWtlos%>" DISABLED></TD>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.OT.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">OT</TD>
	<TD class='fields' COLSPAN="1"><INPUT TYPE="text" name="drg_ot" id="drg_ot" ID="drg_ot" VALUE="<%=drgOt%>" DISABLED></TD>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.AdjRW.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">Adj RW"</TD>
	<TD class='fields' COLSPAN="1"><INPUT TYPE="text" name="drg_adrrw" id="drg_adrrw" ID="drg_adrrw" VALUE="<%=drgAdjrw%>" DISABLED></TD>
</TR>
<TR>
	<TD class="label" COLSPAN="1"><fmt:message key="Common.Error.label" bundle="${common_labels}"/></TD>
	<TD class='fields' colspan="1"><INPUT TYPE="text" name="drg_error" id="drg_error" ID="drg_error" VALUE="<%=drgError%>" DISABLED></TD>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.CallOS.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">Call OS</TD>
	<TD class='fields' colspan="5"><INPUT TYPE="text" name="drg_callos" id="drg_callos" ID="drg_callos" VALUE="<%=callos%>" DISABLED></TD>
</TR>
<TR>
<!--	<TD class="label" COLSPAN="1"><fmt:message key="eMR.WARN.label" bundle="${mr_labels}"/></TD> -->
	<TD class="label" COLSPAN="1">WARN</TD>
	<TD class='fields' colspan="1"><INPUT TYPE="text" name="drg_warn" id="drg_warn" ID="drg_warn" VALUE="<%=drgWarn%>" DISABLED></TD>
	<TD class="label" COLSPAN="1"><fmt:message key="Common.Result.label" bundle="${common_labels}"/></TD>
	<TD class='fields' colspan="5"><INPUT TYPE="text" name="drg_result" id="drg_result" ID="drg_result" VALUE="<%=result%>" DISABLED></TD>
</TR>

<TR><TD colspan="8">&nbsp;</TD></TR>
</TABLE>
</DIV>
<!--
<TABLE cellspacing='0' cellpadding='0' width='100%' align=center>
<TR>	
	<TD><INPUT TYPE="submit" VALUE="SAVE"></TD>
	<TD><INPUT TYPE="button" VALUE="CLOSE" onClick="window.close();"></TD>
</TR>
</TABLE>
-->
<INPUT TYPE="hidden" name="drgstatus" id="drgstatus" ID="drgstatus" VALUE="<%=drgStatus%>">
<INPUT TYPE="hidden" name="drgexception" id="drgexception" ID="drgexception" VALUE="<%=drgException%>">
</FORM>
</BODY>

<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
%>
</html>

