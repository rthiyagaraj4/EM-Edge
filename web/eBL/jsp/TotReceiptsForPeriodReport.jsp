<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201028            74212       MOHE-CRF-0050.2      	Shikha Seth
1            V201118            74212       MOHE-CRF-0050.2      	Shikha Seth
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
<script language="JavaScript" src="../../eBL/js/TotReceiptsForPeriodReport.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#posted_bills_only').change(function(){		
		if($(this).prop('checked')){
			$(this).val('Y');   
		}else{
			$(this).val('N');	
		}
	});
});
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function processScroll()
{
	if (headTop < 0)
	{
		saveHeadPos();
	}
	if (headTop>0)
	{
		if (document.documentElement && document.documentElement.scrollTop)
			theTop = document.documentElement.scrollTop;
		else if (document.body)
			theTop = document.body.scrollTop;

		if (theTop>headTop)
			FloatHead1.style.top = (theTop-headTop) + 'px';
		else
			FloatHead1.style.top = '0px';
	}
}

function saveHeadPos()
{
	parTable = document.getElementById("divHeadSep");
	if (parTable != null)
	{
		headTop = parTable.offsetTop + 3;
		FloatHead1 = document.getElementById("heading");
		FloatHead1.style.position = "relative";
	}
}

function lockbackSpace()
{
	var mode = document.mode.value;
	if(mode=='modify' && window.event.keyCode==8)
	{
		//return false;
	}
}
</script>
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
	String applyMode				=	new String();
	String locale					=	"";
	String facilityId			=	"";
	String loggedInUser				=	"";
	String mode				=	"";
	mode		=	"";
	String isUserCanAcess		=	"";
	String bean_id			=	"";
	String bean_name		=	"";
	String modifyStatus    			=	"";
	ArrayList		episodeTypeList			=	null;
	String authorized		=	"";

	try  
	{		 
		sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" ) ;
		loggedInUser = (String) session.getValue( "login_user" );
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLReceiptForPeriodForm" id="BLReceiptForPeriodForm" id="BLReceiptForPeriodForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>	
	<td  class="columnheader" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
</tr>	
</TABLE>
<br>
<table cellpadding='3' cellspacing='0' width="100%" align="center" border='0'>	
<tr>
			 	<td class="label" style="width:30%"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='fields' style="width:20%">
					<select id="episode_type" name="episode_type" id="episode_type"  style="width: 120px;">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
						<option value="E"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>  <!--V201118 modified -->
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>						
					</select>	
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
				
				
			 	<td class="label" style="width:30%"><fmt:message key="eBL.RECEIPT_REFUND.label" bundle="${bl_labels}"/></td>
				<td class='fields' style="width:20%">
					<select id="receipt_refund" name="receipt_refund" id="receipt_refund"  style="width: 120px;">
						<option value="R"><fmt:message key="eBL.RECEIPT.label" bundle="${bl_labels}"/></option>
						<option value="F"><fmt:message key="eBL.REFUND.label" bundle="${bl_labels}"/></option>
						<option value="B"><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>						
					</select>	
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
			</tr>

	<tr>
		<td  class="label" width="30%"><fmt:message key="eBL.RECEIPT_REFUND.label" bundle="${bl_labels}"/> <fmt:message key="eBL.FromreceiptDate.label" bundle="${bl_labels}"/></td>
			<td  class='fields' style="width:20%">
				<input type="text" name="fm_receipt_date" id="fm_receipt_date" id="fm_receipt_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].fm_receipt_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_receipt_date');"> 
			</td>
		
		 <td  class="label" width="30%"><fmt:message key="eBL.RECEIPT_REFUND.label" bundle="${bl_labels}"/> <fmt:message key="eBL.ToreceiptDate.label" bundle="${bl_labels}"/></td>
		 	<td class='fields' style="width:20%">
				<input type="text"  name="to_receipt_date" id="to_receipt_date"  id="to_receipt_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_receipt_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_receipt_date');">			
		</td>		
	</tr>
	
	<tr>
		<td class="label" style="width:30%"><fmt:message key="eBL.PostedBillsOnly.label" bundle="${bl_labels}"/> </td>
		<td style="width:20%"><input height="15" type="checkbox" name="posted_bills_only" id="posted_bills_only" id="posted_bills_only" value="N"></td>		
	</tr>
	
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRRESFP" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value="BLRRESFP"	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facilityId%>"	>	
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
	<input type='hidden' name="loggedInUser" id="loggedInUser"	id="loggedInUser" 	value="<%=loggedInUser%>" >	
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in ToReceiptsForPeriodReport.jsp::"+e);
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

