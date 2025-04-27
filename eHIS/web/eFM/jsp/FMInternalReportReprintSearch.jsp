<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	24/06/2001
	 Module Name 	   :	FM\File Code report
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src="../../eFM/js/FMInternalReportReprint.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<BODY onMouseDown="CodeArrest();"  onKeyDown = 'lockKey();'>
<form name="ReportSearch" id="ReportSearch" action="" method="post" target="messageFrame">
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<BR>
<div align="left">
<table border="0" cellpadding="3" cellspacing="0"  align='center' width='50%'>
<!--<tr><td width='10%' height="0.5" colspan="4">&nbsp;</td></tr>-->
<tr>
	  <td width='20%' >&nbsp;</td>
      <td class="label" width='30%'><fmt:message key="eFM.OnlineReport.label" bundle="${fm_labels}"/></td>
      <td class='fields' width='40%'><select name="ReportName" id="ReportName" onChange="codeCheck(this.value);" >
	   <option value='' selected>------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------------</option>
	   <option value='FMBMRPLA' ><fmt:message key="eFM.OPPullingList.label" bundle="${fm_labels}"/></option>
	   <option value='FMBPULST' ><fmt:message key="eFM.OPConfirmedFileList.label" bundle="${fm_labels}"/></option>
	   <option value='FMBATRCD' ><fmt:message key="eFM.OPTracerCard.label" bundle="${fm_labels}"/></option>
	   <option value='OP' ><fmt:message key="eFM.AppointmentReqSlip.label" bundle="${fm_labels}"/></option>
	   <option value='FMBMRPLI' ><fmt:message key="eFM.IPPullingList.label" bundle="${fm_labels}"/></option>
	   <option value='FMBPULST1' ><fmt:message key="eFM.IPConfirmedFileList.label" bundle="${fm_labels}"/></option>
	   <option value='FMBATRCI' ><fmt:message key="eFM.IPTracerCard.label" bundle="${fm_labels}"/></option>
	  <option value='IP' ><fmt:message key="eFM.BookingReqSlip.label" bundle="${fm_labels}"/></option>
	   <option value='FMBISSCD' ><fmt:message key="eFM.IssueTracerCard.label" bundle="${fm_labels}"/></option>
	   <option value='RE' ><fmt:message key="eFM.PrintPatientFileRequestSlip.label" bundle="${fm_labels}"/></option>
	   </select></td> 
	  
	   <td width='10%' >&nbsp</td></tr>
 </tr>
</table>
</div>
</form>
</body>
 </html>

