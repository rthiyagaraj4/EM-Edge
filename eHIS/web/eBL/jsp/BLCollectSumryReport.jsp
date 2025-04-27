<!DOCTYPE html>
<!-- 
Sr No        Version          Incident/TFS       SCF/CRF             				Developer Name
-----------------------------------------------------------------------------------------------------
1            V201021           74212/4939        MOHE-CRF-0050.2     				 Mohana Priya K
2			 V201124			8733		BL-MOHE-CRF-0050.2-US001/01-MIS 
											Reports-Collection Summary for a Period  Mohana Priya K
------------------------------------------------------------------------------------------------------
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
<script language="JavaScript" src="../../eBL/js/BLCollectSumryReport.js"></script>
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
//V201124 starts
function focus_val(){
	document.getElementById("fm_bill_date").focus();
}

function mand_fld(){ 
	var effFromDt = document.forms[0].fm_bill_date.value;
	var effToDt   = document.forms[0].to_bill_date.value;
	if(effFromDt==''){
		document.getElementById("fm_bill_date").focus();    //V201123
		alert(getMessage("BL00948",'BL'));
		return false;
	}
	else if( effToDt==''){
		document.getElementById("to_bill_date").focus();
		alert(getMessage("BL00948",'BL'));
	  	return false;
	}else{
		return true;
		}
}
//V201124 ends
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
	String applyMode	=	new String();
	String locale		=	"";
	String facilityId	=	"";
	String loggedInUser	=	"";
	String mode			=	"";
	mode	=	"";
	String isUserCanAcess	=	"";
	String authorized		=	"";
	String p_user_name		= (String) session.getValue( "login_user" );
	Connection con	= null;
	PreparedStatement pstmt = null;
	ResultSet resultSet		= null;
	String session_id="";
	String p_pgm_date="";
	String value2="Y";
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" );
		con=ConnectionManager.getConnection(request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onLoad="focus_val();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;"><!--V201124-->
 <form name="BLCollectionSummaryForm" id="BLCollectionSummaryForm" id="BLCollectionSummaryForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
</tr>	
</TABLE>
<br>
<table cellpadding='5' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
			<td  class="label" width="17%">
				<fmt:message key="eBL.frmbilldate.label" bundle="${bl_labels}"/>
			</td>
			<td class='fields'>
				<input type="text" name="fm_bill_date" id="fm_bill_date" id="fm_bill_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].fm_bill_date);return dateRegEx(this)' >
				&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_bill_date');"><img src='../../eCommon/images/mandatory.gif'> 
			</td>
			
			<td  class="label" width="17%">
				<fmt:message key="eBL.tobilldate.label" bundle="${bl_labels}"/>
			</td>
			<td>
				<input type="text"  name="to_bill_date" id="to_bill_date"  id="to_bill_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_bill_date);return dateRegEx(this)' >
					&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_bill_date');"><img src='../../eCommon/images/mandatory.gif'>
			</td>		
	</tr>	

	<tr>
		<td  class="label" ><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
		<td  class='fields' colspan='2'>  <!--V201124-->
			<input type="text" name="cash_count" id="cash_count"	id="cash_count"	value="" onClick="mand_fld();">		
			<input type="text" name="cash_counter" id="cash_counter" id="cash_counter"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') counterLookup();else  cash_count.value ='';" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onClick="mand_fld();" >	
			<input type='button' class='button' name="cashcounterbut" id="cashcounterbut" value='?' onClick="if(mand_fld()){return counterLookup();}"/>	
		</td>
	</tr>

	<tr>
		<td class="label">
			<fmt:message key="Common.user.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' colspan='2'> <!--V201124-->
			<input type="text" name="user_" id="user_"	 		id="user_"		value="" onClick="mand_fld();"> 			<input type="text" name="user" id="user" id="user"  size="30"  maxlength="50" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!='') userLookup();else  user_.value ='';" onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  >	
			<input type='button' class='button' name="userbut" id="userbut" value='?' onClick="if(mand_fld()){return userLookup();}"/>	
		</td>		
	</tr>

	<tr>
	<td></td>
		<td class="label" align='center' colspan="2"> <!--V201124-->
			<input type="checkbox" name="zero_bill" id="zero_bill"  id="zero_bill" onclick="if(mand_fld()){zero_bill_also();} else{document.forms[0].zero_bill.checked=true;}" value="<%=value2%>" checked>&nbsp;
			<fmt:message key="eBL.Zero_bill_Also.label" bundle="${bl_labels}"/>
	   </td>
	   <td></td>
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRCLSUM" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facilityId%>"	>
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="<%=session_id%>">	
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
</form>
</BODY>
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


			 

