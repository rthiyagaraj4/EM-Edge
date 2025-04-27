<!DOCTYPE html>
<!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201021            74212       MOHE-CRF-0050.2      Mohana Priya K
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
<script language="JavaScript" src="../../eBL/js/BLDrugsPenalityReport.js"></script>
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
	String applyMode	=	new String();
	String locale		=	"";
	String facilityId	=	"";
	String loggedInUser	=	"";
	String p_user_name	= (String) session.getValue( "login_user" );
	String mode		=	"";
	String isUserCanAcess	=	"";
	String p_pgm_date="";

	try  
	{		 
		sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" ) ;
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLCollectionSummaryForm" id="BLCollectionSummaryForm" id="BLCollectionSummaryForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
</tr>	
</TABLE>
<br>
<table cellpadding='10' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td  class="label" width="10%">
			<fmt:message key="eBL.frmbilldate.label" bundle="${bl_labels}"/>
		</td>
		<td  class='fields'>
			<input type="text" name="fm_bill_date" id="fm_bill_date" id="fm_bill_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].fm_bill_date);return dateRegEx(this)' > &nbsp; <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fm_bill_date');"> <img src='../../eCommon/images/mandatory.gif'> 
		</td>
		<td  class="label" width="10%">
			<fmt:message key="eBL.tobilldate.label" bundle="${bl_labels}"/>
		</td>
		<td class='fields'>
			<input type="text"  name="to_bill_date" id="to_bill_date"  id="to_bill_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_bill_date);return dateRegEx(this)' > &nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_bill_date');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="eBL.FromBillNo.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="fromBill" id="fromBill"	 		id="fromBill"		value=""> 
			<input type="text" name="FromBillNo" id="FromBillNo" id="FromBillNo"  size="20"  maxlength="40"  onBlur="ChangeUpperCase( this );if(this.value!='') frmBillNOLookup();else  FromBillNo.value ='';"  onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  >	
			<input type='button' class='button' name="Frmbillbut" id="Frmbillbut" value='?' onClick="return frmBillNOLookup()"  tabindex='2'/>	
		</td>
		<td  class="label" width="10%"><fmt:message key="eBL.ToBillNo.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="Tobill" id="Tobill"	 		id="Tobill"		value=""> 			
			<input type="text" name="ToBillNo" id="ToBillNo" id="ToBillNo"  size="20"  maxlength="40"  onBlur="ChangeUpperCase( this );if(this.value!='') toBillNOLookup();else  ToBillNo.value ='';"  >	
			<input type='button' class='button' name="Tobillbut" id="Tobillbut" value='?' onClick="return toBillNOLookup()"  tabindex='2'/>	
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eBL.FromCustomer.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="customer" id="customer" id="customer"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') customerLookup();else  customer.value ='';"  >	
			<input type='button' class='button' name="customerbut" id="customerbut" value='?' onClick="return customerLookup()"  tabindex='2'/>	
			<input type="hidden" name="cust_" id="cust_"	 		id="cust_"		value=""> 			
			
		</td> 
		<td  class="label" width="10%"><fmt:message key="eBL.ToCustomer.label" bundle="${bl_labels}"/></td>
			<td>
				<input type="text" name="tocustomer" id="tocustomer" id="tocustomer"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') tocustomerLookup();else  tocustomer.value ='';"  >	
			<input type='button' class='button' name="tocustomerbut" id="tocustomerbut" value='?' onClick="return tocustomerLookup()"  tabindex='2'/>	
			<input type="hidden" name="cust_to" id="cust_to"	 		id="cust_to"		value=""> 			
			
			</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eBL.FromPolicy.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="FromPolicy" id="FromPolicy" id="FromPolicy"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') frmpolicyLookup();else  FromPolicy.value ='';" >	
			<input type='button' class='button' name="Frompolbut" id="Frompolbut" value='?' onClick="return frmpolicyLookup()"  tabindex='2'/>	
			<input type="hidden" name="fromPol" id="fromPol"	 		id="fromPol"		value=""> 			
			</td>
		
		<td  class="label" width="10%"><fmt:message key="eBL.ToPolicy.label" bundle="${bl_labels}"/></td>
			<td>
				<input type="text" name="ToPolicy" id="ToPolicy" id="ToPolicy"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') topolicyLookup();else  ToPolicy.value ='';"  >	
			<input type='button' class='button' name="Topolbut" id="Topolbut" value='?' onClick="return topolicyLookup()"  tabindex='2'/>	
			<input type="hidden" name="toPol" id="toPol"	 		id="toPol"		value=""> 			
		</td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="eBL.FromPatientID.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="FromPat" id="FromPat"	 		id="FromPat"		value=""> 
			<input type="text" name="FromPatientID" id="FromPatientID" id="FromPatientID"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') fromPatIDLookup();else  FromPatientID.value ='';" >
			<input type='button' class='button' name="FromPatbut" id="FromPatbut" value='?' onClick="return fromPatIDLookup()"  tabindex='2'/>	
		</td>
		 
		<td  class="label" ><fmt:message key="eBL.ToPatientID.label" bundle="${bl_labels}"/></td>
			<td>
			<input type="text" name="ToPat_" id="ToPat_"	 		id="ToPat_"		value=""> 	
			<input type="text" name="ToPatientID" id="ToPatientID" id="ToPatientID"  size="30"  maxlength="50"  onBlur="ChangeUpperCase(		this );if(this.value!='') toPatIDLookup();else  ToPatientID.value ='';"  >	
			<input type='button' class='button' name="ToPat" id="ToPat" value='?' onClick="return toPatIDLookup()"  tabindex='2'/>	
		</td>
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLDRGPNL" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facilityId%>"	>
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type="hidden" name="p_episode_id" id="p_episode_id" 	value="">
	<input type="hidden" name="p_visit_id" id="p_visit_id" 	id="p_visit_id"		value="" >
	<input type="hidden" name="p_patient_id" id="p_patient_id"	id="p_patient_id" value=""	>
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">
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


			 

