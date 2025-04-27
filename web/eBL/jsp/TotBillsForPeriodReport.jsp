<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201027            74212       MOHE-CRF-0050.2          Ram kumar S
-----------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "  
contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>	
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/TotBillsForPeriodReport.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
		thead td, thead td.locked	{ 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale	=	"";
	String facilityId	=	"";
	String loggedInUser	=  (String) session.getValue("login_user");	
	try  
	{
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String)session.getValue("facility_id");
%>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BillsPeriodSummaryForm" id="BillsPeriodSummaryForm" id="BillsPeriodSummaryForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<table width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" >Report Criteria </td>
</tr>	
</table>
<br>
<table cellpadding='5' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td  class="label" width="10%">
			<fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/></td>
		<td><select name="EpisodeType" id="EpisodeType" id="EpisodeType" style="width: 120px;">       
			  <option value="Select">-Select-</option>
              <option value="A" selected>All</option>
              <option value="R" >Referral</option>
              <option value="E" >Emergency</option>
              <option value="O" >Outpatient</option>
              <option value="I" >Inpatient</option>
              <option value="D" >Daycare</option>
              </select>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
		<td  class="label" width="10%"><fmt:message key="eBL.BillingType.label" bundle="${bl_labels}"/></td>
		<td><select name="BillingType" id="BillingType" id="BillingType" onchange="billTypeChange(this)" style="width: 120px;">       
			  <option value="Select" >-Select-</option>
              <option value="C" >Cash</option>
              <option value="R" >Credit</option>
              <option value="A" selected>Both</option>
              </select>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
		<td  class="label" width="10%"><fmt:message key="eBL.frmbilldate.label" bundle="${bl_labels}"/></td>
			<td  class='fields'>
				<input type="text" name="fm_bill_date" id="fm_bill_date" id="fm_bill_date" size="15" maxlength='10' value='' onBlur='return dateRegEx(this);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_bill_date');">
			</td>
		 <td  class="label" width="10%"><fmt:message key="eBL.tobilldate.label" bundle="${bl_labels}"/>
			<td>
				<input type="text"  name="to_bill_date" id="to_bill_date"  id="to_bill_date"   size="15" maxlength='10' value='' onBlur='return dateRegEx(this);' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_bill_date');">
			</td>
		</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="eBL.PostedBillsOnly.label" bundle="${bl_labels}"/></td>
		<td  class='fields'>
			<input type="checkbox" name="postBillsOnly" id="postBillsOnly" id="postBillsOnly" />
		</td>
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	>	
	<input type="hidden" name="p_user_id" id="p_user_id" 	id="p_user_id" value="<%=loggedInUser%>"	>
</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BLCollectSumryReport.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>	 

