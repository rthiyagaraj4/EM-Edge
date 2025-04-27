<!DOCTYPE html>
<!-- 
Sr No        Version           Incident/TFS        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201109            74212/5289       MOHE-CRF-0050.2      	Shikha Seth
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
<script language="javascript" src="../../eBL/js/CashCollectionPeriodReport.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#CancelledDocsOnly').change(function(){		
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
function loadBody() {

}

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
</head>

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
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" ) ;
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onload="document.CashCollectionPeriod.fm_report_date.focus()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
<form name="CashCollectionPeriod" id="CashCollectionPeriod" id="CashCollectionPeriod"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" >Report Criteria </td>
</tr>	
</TABLE>
<br>
<table cellpadding='5' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td  class="label" width="20%"><fmt:message key="eBL.frmReportdate.label" bundle="${bl_labels}"/></td>
			<td  class="fields" width="30%">
				<input type="text" name="fm_report_date" id="fm_report_date" id="fm_report_date" size="20" maxlength='20' value='' onBlur='return checkDateBL(document.forms[0].fm_report_date);return dateRegEx(this) ' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_report_date','','HH:MIN');"><img src='../../eCommon/images/mandatory.gif'> 				
			</td>
		
		 <td  class="label" width="20%"><fmt:message key="eBL.toReportdate.label" bundle="${bl_labels}"/>
			<td class="fields" width="30%">
				<input type="text"  name="to_report_date" id="to_report_date"  id="to_report_date"   size="20" maxlength='20' value='' onBlur='return toFromDateChk(document.forms[0].to_report_date);return dateRegEx(this)' >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_report_date','','HH:MIN');"><img src='../../eCommon/images/mandatory.gif'>
			</td>
		</td>		
	</tr>
	
	<tr>
		<td  class="label" width="20%"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/> <fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="fm_cash_counter1" id="fm_cash_counter1" id="fm_cash_counter1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') counterLookup_fm();else  fm_cash_counter.value =''; fm_cash_counter1.value='';"  >	
			<input type='button' class='button' name="cashcounterbut" id="cashcounterbut" value='?' onClick="return counterLookup_fm()"  tabindex='2'/>	
			<input type="hidden" name="fm_cash_counter" id="fm_cash_counter"	 		id="fm_cash_counter"		value=""> 					
		</td>
		
		<td  class="label" width="20%"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/> <fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="to_cash_counter1" id="to_cash_counter1" id="to_cash_counter1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') counterLookup();else  to_cash_counter.value ='';to_cash_counter1.value ='';"  >	
			<input type='button' class='button' name="cashcounterbut1" id="cashcounterbut1" value='?' onClick="return counterLookup()"  tabindex='2'/>	
			<input type="hidden" name="to_cash_counter" id="to_cash_counter"	 		id="to_cash_counter"		value=""> 						
		</td>
	</tr>
	
	<tr>
		<td class="label" width="20%"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/> <fmt:message key="eBL.REC_NATURE.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="30%">
			<input type="text" name="fm_recpt_nature1" id="fm_recpt_nature1" id="fm_recpt_nature1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') recptNatureFM();else  fm_recpt_nature.value =''; fm_recpt_nature1.value='';"  >	
			<input type='button' class='button' name="recpt_nature_fm" id="recpt_nature_fm" value='?' onClick="return recptNatureFM()"  tabindex='2'/>	
			<input type="hidden" name="fm_recpt_nature" id="fm_recpt_nature"	 		id="fm_recpt_nature"		value=""> 			
			</td>	
		<td class="label" width="20%"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/> <fmt:message key="eBL.REC_NATURE.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="30%">
			<input type="text" name="to_recpt_nature1" id="to_recpt_nature1" id="to_recpt_nature1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') recptNatureTO();else  to_recpt_nature.value ='';to_recpt_nature1.value ='';"  >	
			<input type='button' class='button' name="recpt_nature_to" id="recpt_nature_to" value='?' onClick="return recptNatureTO()"  tabindex='2'/>	
			<input type="hidden" name="to_recpt_nature" id="to_recpt_nature"	 		id="to_recpt_nature"		value=""> 			
			</td>				
	</tr>

	<tr>
		<td  class="label" width="20%"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/> <fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="fm_recpt_type1" id="fm_recpt_type1" id="fm_recpt_type1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') recptTypeFM();else  fm_recpt_type.value ='';fm_recpt_type1.value ='';"  >	
			<input type='button' class='button' name="recpt_type_fm" id="recpt_type_fm" value='?' onClick="return recptTypeFM()"  tabindex='2'/>	
			<input type="hidden" name="fm_recpt_type" id="fm_recpt_type"	 		id="fm_recpt_type"		value=""> 						
		</td>
		
		<td  class="label" width="20%"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/> <fmt:message key="eBL.RECEIPT_TYPE.label" bundle="${bl_labels}"/></td>
		<td  class="fields" width="30%">
			<input type="text" name="to_recpt_type1" id="to_recpt_type1" id="to_recpt_type1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') recptTypeTO();else  to_recpt_type.value ='';to_recpt_type1.value ='';"  >	
			<input type='button' class='button' name="recpt_type_to" id="recpt_type_to" value='?' onClick="return recptTypeTO()"  tabindex='2'/>	
			<input type="hidden" name="to_recpt_type" id="to_recpt_type"	 		id="to_recpt_type"		value=""> 						
		</td>
	</tr>
	<tr>
		<td class="label" width="20%"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/> <fmt:message key="eBL.IRBSettlementType.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="30%">
			<input type="text" name="fm_stlmnt_type1" id="fm_stlmnt_type1" id="fm_stlmnt_type1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') stlmntTypeFM();else  fm_stlmnt_type.value ='';"  >	
			<input type='button' class='button' name="stlmnt_type_fm" id="stlmnt_type_fm" value='?' onClick="return stlmntTypeFM()"  tabindex='2'/>	
			<input type="hidden" name="fm_stlmnt_type" id="fm_stlmnt_type"	 		id="fm_stlmnt_type"		value=""> 			
			</td>	
		<td class="label" width="20%"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/> <fmt:message key="eBL.IRBSettlementType.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="30%">
			<input type="text" name="to_stlmnt_type1" id="to_stlmnt_type1" id="to_stlmnt_type1"  size="20"  maxlength="20"  onBlur="ChangeUpperCase( this );if(this.value!='') stlmntTypeTO();else  to_stlmnt_type.value ='';"  >	
			<input type='button' class='button' name="stlmnt_type_to" id="stlmnt_type_to" value='?' onClick="return stlmntTypeTO()"  tabindex='2'/>	
			<input type="hidden" name="to_stlmnt_type" id="to_stlmnt_type"	 		id="to_stlmnt_type"		value=""> 			
			</td>				
	</tr>
	
	<tr>
		<td class="label" width="20%"><fmt:message key="eBL.CancelledDocsOnly.label" bundle="${bl_labels}"/> </td>
		<td class="fields" width="30%"><input height="15" type="checkbox" name="CancelledDocsOnly" id="CancelledDocsOnly" id="CancelledDocsOnly" value="N"></td>		
	</tr>
	<tr>
		<td class="label" width="20%"><fmt:message key="eBL.ReceiptsRefundsBoth.label" bundle="${bl_labels}"/></td>
		<td class="fields" width="30%">
			<select id="ReceiptsRefundsBoth" name="ReceiptsRefundsBoth" id="ReceiptsRefundsBoth"  style="width: 120px;">
				<option value="R">Receipts Only</option>
				<option value="F">Refunds Only</option>
				<option value="B"><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>
			</select>				
		</td>
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRCASPR" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value="BLRCASPR"	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facilityId%>"	>	
	<input type="hidden" name="FUNCTION_ID" id="FUNCTION_ID" 	id="FUNCTION_ID" value="BL_REP_CASH_COLL_FOR_PERIOD"	>		
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in CashCollectionPeriodReport.jsp::"+e);
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


			 

