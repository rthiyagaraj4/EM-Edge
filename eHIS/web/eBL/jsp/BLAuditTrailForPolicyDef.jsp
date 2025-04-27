<!DOCTYPE html>
<!-- Created jsp against NMC-JD-CRF-0010.1 -->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "  contentType="text/html;charset=UTF-8" %> 
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
<script language="JavaScript" src="../../eBL/js/BlAuditTrailRptCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
<script>
	var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var PAYER_LOOKUP_RECORD_PREAPPROVAL					=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var POLICY_LOOKUP_RECORD_PREAPPROVAL				=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
	
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
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;">
 <form name="BLAuditTrailForPolicyDefForm" id="BLAuditTrailForPolicyDefForm" id="BLAuditTrailForPolicyDefForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" >Report Criteria </td>
</tr>	
</TABLE>
<br>
<table cellpadding='5' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td  class="label" width="10%"><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
			<td  class='fields'>
				<input type="text" name="payer_grp_desc" id="payer_grp_desc" id="payer_grp_desc" size="30" maxlength="50"  onBlur="ChangeUpperCase( this ); if(this.value!='') payerGroupLookup();else {p_payer_grp_code.value='';cust_desc.value='';p_cust_code.value='';} "   >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /> 
				<input type="hidden" name="p_payer_grp_code" id="p_payer_grp_code" 			id="p_payer_grp_code"		value="">
				<img src='../../eCommon/images/mandatory.gif'>
			</td>
		
		<td  class="label" width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/>
			<td>
				<input type="text" name="cust_desc" id="cust_desc" id="cust_desc" 	size="30" maxlength="50"  onBlur="ChangeUpperCase( this ); if(this.value!='') payerLookup(p_payer_grp_code);else  p_cust_code.value= '';" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup(p_payer_grp_code)"  tabindex='2' />
				<input type="hidden" name="p_cust_code" id="p_cust_code" 				id="p_cust_code"			value=""> 
				<img src='../../eCommon/images/mandatory.gif'>
			</td>
		</td>
		<td  class="label" colspan='3' width='10%'></td>				
	</tr>

	<tr>
		<td  class="label" ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
		<td  class='fields'>
			<input type="text" name="policy_desc" id="policy_desc" id="policy_desc"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') policyLookup();else  p_policy_type_code.value ='';"  >	
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup(p_payer_grp_code,p_cust_code)"  tabindex='2'/>	
			<input type="hidden" name="p_policy_type_code" id="p_policy_type_code"	 		id="p_policy_type_code"		value=""> 			
			<img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class="label"><fmt:message key="eBL.ModifiedDateRange.label" bundle="${bl_labels}"/></td>
		<td>
			<input type="text" name="p_fm_date" id="p_fm_date" id="p_fm_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].p_fm_date);return dateRegEx(this)' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date');"><img src='../../eCommon/images/mandatory.gif'> -
			<input type="text"  name="p_to_date" id="p_to_date"  id="p_to_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].p_to_date);return dateRegEx(this)' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
		</td> 
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRPLADT" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="p_facility_id" id="p_facility_id" 	id="p_facility_id" value="<%=facilityId%>"	>
	<input type="hidden" name="p_episode_id" id="p_episode_id" 	value="">
	<input type="hidden" name="p_visit_id" id="p_visit_id" 	id="p_visit_id"		value="" >
	<input type="hidden" name="p_patient_id" id="p_patient_id"	id="p_patient_id" value=""	>
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BlAuditTrailForPolicyDef.jsp::"+e);
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


			 

