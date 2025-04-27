<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
<% 

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eST/js/PfReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>	
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formPfReportsCriteria" id="formPfReportsCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
<br><br><br><br>
<table cellpadding="0" cellspacing="0"  border="0" width="70%" align="center">
<TH  colspan='3' height='4' ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
<tr>
	<td colspan='3' class='label' height='2'>&nbsp;&nbsp;</td>
</tr>
	<tr>
        <td  class="label">&nbsp;<fmt:message key="Common.PFReports.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align="left" ><SELECT name="pf_report_id" id="pf_report_id" onChange="loadPage()" >
	   	<OPTION VALUE="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </OPTION>
	   	<OPTION VALUE="STPROCBYMST"><fmt:message key="eST.ValueOfProcurementMadeByMedicalStore.label" bundle="${st_labels}"/> </OPTION>
	  	<OPTION VALUE="STWSMFGREPK"><fmt:message key="eST.WardSupplyManufacturingAndRepackingOutput.label" bundle="${st_labels}"/></OPTION>
		<OPTION VALUE="STGRNSTDRGS"><fmt:message key="eST.ReportOnGRNStatisticsForDrugs.label" bundle="${st_labels}"/></OPTION>
		</SELECT>&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
</tr>

<tr>
	<td colspan='3' class='label' height='2'>&nbsp;&nbsp;</td>
</tr>

<tr>
	<td  class="label"  nowrap>&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;</td>  
	<td class="fields"  >
	<input type='text' class='DATE' name='p_date_from' id='p_date_from' size='8' value="" maxlength="10" Onblur="CheckDate(this); ">
	<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('p_date_from');"></IMG>
	<img  align='center'src='../../eCommon/images/mandatory.gif'>
	</img>&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
	<input type='text' class='DATE' name='p_date_to' id='p_date_to' size='8' value="" maxlength="10" Onblur="CheckDate(this);">
	<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('p_date_to');" ></IMG>
	<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
	</td>
 </tr>
<tr>
	<td colspan='3' class='label' height='2'>&nbsp;&nbsp;</td>
</tr>

		<tr id='rp4'  style="display:none">
		<td  align="right"  class=label><fmt:message key="Common.Top.label" bundle="${common_labels}"/>&nbsp;</td>
		<td align="left"  class="fields" >
		<input type="text" name="p_count" id="p_count" class="NUMBER"  value="" size=3 maxlength="5" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);">
		&nbsp;<fmt:message key="eST.PurchaseValueItems.label" bundle="${st_labels}"/>
		<img  align='center'src='../../eCommon/images/mandatory.gif'>
	    </img>
		</td></tr> 
<tr>
	<td colspan='3' id='rp3' style="display:none" class='label' height='2'>&nbsp;&nbsp;</td>
</tr>

  <tr id='rp1' align="right" style="display:none">
    <td class="label" name="rep_opt"  >
	<fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/>&nbsp;</td>
	<td  align="left" class="fields" >
		<SELECT name="p_report_opt" id="p_report_opt" >
			<OPTION VALUE="A"><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="B"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/> </OPTION>
			<OPTION VALUE="C"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
	   </SELECT>
   </td>
  </tr>



<tr>
	<td colspan='3' id='rp6' style="display:none" class='label' height='2'>&nbsp;&nbsp;</td>
</tr>
</table>
 	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="ST">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
</form>
</body>
</html>

