<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String p_wkstation_id	= p.getProperty("client_ip_address");
	String p_module_id		= "MR" ;
	String p_report_id		= "MRIPCSOBD" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	
	
	<script src="../../eCommon/js/CommonCalendar.js"></script> 
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	  function chkyear_fut(obj)
	  {
		  var sysdate=document.forms[0].sysdate.value;
		  var splitdatesys = sysdate.split("/");
		  var sys_date=splitdatesys[2];
		  if(eval(obj.value)>sys_date)
		  {
			var msg=getMessage("MRDATE1_GT_DATE2",'MR');
			msg=msg.replace('$',getLabel("Common.CensusYear.label","Common"));
			msg=msg.replace('#',getLabel("Common.CurrentYear.label","Common"));
			alert(msg);
			document.forms[0].census_date.focus();
			document.forms[0].census_date.select();
		  }
	  }
	</script>
</HEAD>
<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()'>
<br>
<br>
<form name="repIPAnnualCensusofBedFormPD" id="repIPAnnualCensusofBedFormPD" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	%>  
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="Common.CensusYear.label" bundle="${common_labels}"/> &nbsp;</td>
					<td width='25%'  >
						<input type=text id="census_date" name='p_census_date' id='p_census_date' size="4" onblur="CheckYear(this);chkyear_fut(this);" maxlength="4" align="center" onkeypress="return ValidStringrepIPAnnual(event)" ><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date','y',null);"/>
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_wkstation_id" id="p_wkstation_id"	value="<%= p_wkstation_id %>">
	<input type='hidden' name='sysdate' id='sysdate' value = "<%=currentdate%>"></input>
</form>
</BODY>
</HTML>

