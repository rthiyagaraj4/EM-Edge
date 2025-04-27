<!DOCTYPE html>
<!--
Sr No        Version         TFS              SCF/CRF           			Developer Name
----------------------------------------------------------------------------------------------
1			27/08/13						Acts as create and Modify screen	rponraj2
2	     	V210629			19830			MMS-ME-SCF-0028-TF         			MuthukumarN
3			 V211109		7871			MMS-QH-CRF-0128				   Manivel Natarajan
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.AdditionalServiceDetailsBean "  contentType="text/html;charset=UTF-8" %> 
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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/AdditionalServiceDetailsScript.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var headTop = -1;
var FloatHead1;
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
	
/*	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
*/
function lockbackSpace()
{
	   var mode = document.mode.value;
	 if(mode=='modify' && window.event.keyCode==8)
	  {
	   //return false;
	  }
}
		
function disableCreate()
{
	parent.parent.commontoolbarFrame.CommonToolbar_form.create.disabled=true;
	parent.parent.commontoolbarFrame.CommonToolbar_form.apply.disabled=true;
	parent.parent.commontoolbarFrame.CommonToolbar_form.reset.disabled=true;
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
	String locale	=	"";
	String facilityId	=	"";

	boolean isPkgGrpEnabledYN = false; // V211109
	String disabledForPackageGroup = ""; // V211109	
	int pkgGrpEnabledCount = 0;
	Connection con = null;
	ResultSet rs= null;
	PreparedStatement pstmt = null;
	try  
	{		 
		sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale 	= 	(String)session.getAttribute("LOCALE");
		facilityId	=   (String) session.getValue( "facility_id" );
		con = ConnectionManager.getConnection(request);
		//V211109
		try{
			String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'PACK_GRP_SETUP_AMD_PD'";
			System.out.println("sql for Package Group Function Control:"+sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			if(rs.next())
			{
				pkgGrpEnabledCount=rs.getInt(1);
				System.out.println("count for Package Group Function Control:"+pkgGrpEnabledCount);
			}		
			
			if(pkgGrpEnabledCount > 0)
				isPkgGrpEnabledYN = true;
			else
				isPkgGrpEnabledYN = false;
		}catch(Exception e){
			System.out.println("Exception in Package Group Function Control Query :"+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();		
		}	
		
%>
<body   onMouseDown="CodeArrest();" onKeyDown= "lockKey();"    onSelect="codeArrestThruSelect();" onload ="disableCreate();">
<form id="additionServiceDetailsSearch" name="additionServiceDetailsSearch" id="additionServiceDetailsSearch" >	
	<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
		<tr>			
			<th  align="left" class="columnheader" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		</tr>		
	</TABLE>	
	<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
	 <tr>
			<td class="label" width="16%"><fmt:message key="eBL.ServiceInd.label" bundle="${bl_labels}"/></td>
			<td width="16%">
			<Select id="service_ind" name="service_ind" id="service_ind" onChange= "serviceindreset();"> 
			<!-- Commented against V210629 <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels }"></fmt:message></option> -->
				<option value="A"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="BSG"><fmt:message key="eBL.BillingServiceGroup.label" bundle="${bl_labels}"></fmt:message></option>
				<option value="BSC"><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"></fmt:message></option>
				<option value="B"><fmt:message key="eBL.BillingService.label" bundle="${bl_labels}"></fmt:message></option>
				<%if(isPkgGrpEnabledYN){%>
				<option value="PG"><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"></fmt:message></option>
				<%}%>
			</select> 
			<!-- <img src='../../eCommon/images/mandatory.gif'> -->
			</td>
			<td nowrap class="label" width="16%"><fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels}"/></td>
			<td nowrap class="fields" colspan="2" width="16%">
				<input type="text" name="service_code" id="service_code" id="service_code" disabled  maxlength="100"  onblur="serviceCodeLookUpCode();" onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  >	
				<input type='button' class='button' name="servicecodebut" id="servicecodebut" id="servicecodebut" value='?' disabled="true" onClick="return serviceCodeLookUp()"/>
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->	
			</td>
			<td nowrap class="label" width="16%"><fmt:message key="eBL.ServiceDescription.label" bundle="${bl_labels}"/></td>
			<td nowrap class="fields" colspan="3" width="16%">
				<input type="text" name="service_description" id="service_description" id="service_description"   disabled  maxlength="100"  onblur="serviceCodeLookUp();" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );"/>	
				<!-- <img src='../../eCommon/images/mandatory.gif'> -->
			</td>
			<td class="label" colspan='4'></td>
		 </tr>
		 <tr>
			<td nowrap class="label" ><fmt:message key="eBL.PriceInd.label" bundle="${bl_labels}"/></td>
			<td nowrap class='fields'>
			<Select id="price_ind" name="price_ind" id="price_ind" onChange= "priceindreset();">
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels }"></fmt:message></option>
				<option value="S"><fmt:message key="Common.Standard.label" bundle="${common_labels }"></fmt:message></option>
				<option value="C"><fmt:message key="Common.Customer.label" bundle="${common_labels }"></fmt:message></option>
				<option value="B"><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"></fmt:message></option>
				<option value="P"><fmt:message key="eBL.HCMasterPriceClass.label" bundle="${bl_labels}"></fmt:message></option>
			</select>	
<!-- 				<img src='../../eCommon/images/mandatory.gif'> -->
			</td>
			<td nowrap class="label" ><fmt:message key="eBL.PriceIndCode.label" bundle="${bl_labels}"/></td>
			<td nowrap class="fields" colspan="2">
				<input type="text" name="price_code" id="price_code" id="price_code"   maxlength="100"  disabled onBlur="priceIndCodeLookupCode();"   onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type='button' class='button' name="priceindbut" id="priceindbut" id="priceindbut" value='?' disabled="true" onClick="return priceIndCodeLookup()" >
				
			</td>
			<td nowrap class="label"><fmt:message key="eBL.PriceIndDescription.label" bundle="${bl_labels}"/></td>
			<td nowrap class="fields" colspan="3">
			<input type="text" name="price_description" id="price_description" id="price_description"  disabled  maxlength="100"  onBlur="ChangeUpperCase( this );return priceIndCodeLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" />
			</td>
			<td class="label" colspan="4">
		 </tr>
		 <tr>
			<td nowrap class="label" ><fmt:message key="eBL.BillingClass.label" bundle="${bl_labels}"/></td>
			<td nowrap class='fields' >
				<input type="text" name="bilng_class" id="bilng_class" id="bilng_class" 		 maxlength="30"  value='All Billing Class'  onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="billclass" id="billclass" value='?' onClick="return billingClassLookup();"  /> 
				<input type='hidden' name='billing_class' id='billing_class'	id='billing_class' 			value='A' >
				<input type='hidden' name='billing_code' id='billing_code'	id='billing_code' value='**' >
				<!--<img src='../../eCommon/images/mandatory.gif'> bilng_class-->
			</td>
			<td nowrap class="label" ><fmt:message key="eBL.ValidFrom.label" bundle="${bl_labels}"/> 
			<td nowrap class='fields' colspan="2">
				<input type='text' name='Effective_from' id='Effective_from' id="Effective_from" maxlength="10"  onBlur="return validDateChk(this)">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
			</td>
			<td nowrap class="label" ><fmt:message key="eBL.ValidTo.label" bundle="${bl_labels}"/></td>
			<td nowrap class='fields' colspan="3">
				<input type='text' name='Effective_to' id='Effective_to' id="Effective_to" maxlength="10" onBlur="return validDateChk(this)">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">
				<%-- <img src='../../eCommon/images/mandatory.gif'> --%>
			</td>
			<td class="label" colspan='4'></td>				
		 </tr>
		 <tr>
			<td nowrap class="label" ><fmt:message key="eBL.ChargeType.label" bundle="${bl_labels}"/></td>
			<td>
			<Select id="charge_type" name="charge_type" id="charge_type">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="R">Rate</option>
				<option value="F">Factor</option>
			</select>	
			</td>
			<td nowrap class="label" ><fmt:message key="eBL.DiscExists.label" bundle="${bl_labels}"/></td>
			<td nowrap width="60%" align='left' class="fields" colspan="2">	
				<input type="checkbox" id="Desc" name="Desc" id="Desc" value="Y">
			</td>					
			<td nowrap class="label" colspan='3'><fmt:message key="eBL.DiscApplicability.label" bundle="${bl_labels}"/></td>
			<td>
				<Select id="disc_applicability" name="disc_applicability" id="disc_applicability">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="X">Only Payer</option>
				<option value="C">Only Patient</option>
				<option value="P">Payable Amount</option>
				<option value="T">Total Amount</option>
			</select>
			</td>
			<td nowrap class="label" colspan='4'>
			<input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Search" onclick="showPriceDetails();"  />
			<input type="button" class='button' name="reset" id="reset"	id="reset"   value="Reset" onclick="resetFields();"  />
			</td>			
		 </tr>			
	</table>	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
	<%-- 	<input type='hidden' name='mode' id='mode' value="<%=mode%>" > --%>	
</body>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdditionalServiceDetailsSearch.jsp::"+e);
		e.printStackTrace();
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
</html>

