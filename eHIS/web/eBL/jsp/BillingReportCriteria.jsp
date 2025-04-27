

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "  contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script language="JavaScript" src="../../eBL/js/ReportCriteriaScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL					=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL				=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
var RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP		=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP")%>";
var RECORD_REPORT_CRITERIA_PRACTIONER_LOOKUP		=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_PRACTIONER_LOOKUP")%>";
var RECORD_REPORT_CRITERIA_EPISODE_NO_LOOKUP		=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_EPISODE_NO_LOOKUP")%>";
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
	
	/*function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }*/

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	  async function PatientIdLookup()
		{
			alert("inside PatientIdLookup 88");
		 
					var pat_id=await PatientSearch();		
					if( pat_id != null )						
					document.getElementById("patient_id").value = pat_id ;
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
String applyMode																			=	new String();
String locale																				=	"";
String facilityId																			=	"";
String loggedInUser																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
String modifyStatus     																	=	"";
ArrayList		episodeTypeList																=	null;
String authorized																			=	"";



try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	System.out.println("facilityId in BillingReportCriteria.jsp::"+facilityId);
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
		
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
<br>
<br>
<form name="BillingReportCriteriaForm" id="BillingReportCriteriaForm" id="BillingReportCriteriaForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 


<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
				<td  class="columnheader" >Report Criteria </td>
			</tr>	
</TABLE>	
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
										
			 <tr>
			 	<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			 	
			 	
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" 		 maxlength="30"  onBlur="ChangeUpperCase(this),primaryPatValidation(this);if(this.value=='') return PatientIdLookup();"    onKeyPress="return CheckForSpecChars(event);" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"  tabindex='2' />
				</td>
				
				<td class="label" colspan='3'></td>
				
			 </tr>
			 <tr>
			 	<td class="label" ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select id="episode_type" name="episode_type" id="episode_type"  style="width: 120px;" Onchange="changeEpisode();">
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="OP">OP</option>
					<option value="IP">IP</option>
					<option value="EM">EM</option>
					<option value="DC">DC</option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>		
				 <input type = 'hidden' name = 'p_episode_type'  value ="">
				</td>
				
				<td class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="episode_id" id="episode_id"  	value=""	 maxlength="30"  onBlur="ChangeUpperCase( this ); if(this.value!='') episodeNoLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return episodeNoLookup()"  tabindex='2' />
				</td>
				 
				<td class="label" colspan='3'></td>
				
			 </tr>
			 <tr>
			 	<td class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="p_physician" id="p_physician" id="p_physician"    maxlength="100"  onBlur="ChangeUpperCase( this ); if(this.value!='') practionerLookup(); else p_physician_id.value='';"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return practionerLookup()"  tabindex='2'/>
					<input type="hidden" name="p_physician_id" id="p_physician_id" 				id="p_physician_id"			value="">
				</td>
				
				<!-- <td class="label" colspan='3'></td>  -->
				
			 </tr>
			  <tr>
			 	<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='fields'>
					<input type="text" name="payer_grp_desc" id="payer_grp_desc" id="payer_grp_desc" 		 maxlength="30"  onBlur="ChangeUpperCase( this ); if(this.value!='') payerGroupLookup();else {p_payer_grp_code.value='';cust_desc.value='';p_cust_code.value='';} "    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /> 
					<input type="hidden" name="p_payer_grp_code" id="p_payer_grp_code" 			id="p_payer_grp_code"		value="">
				</td>
				<td class="label" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="cust_desc" id="cust_desc" id="cust_desc" 		 maxlength="30"  onBlur="ChangeUpperCase( this ); if(this.value!='') payerLookup(p_payer_grp_code);else  p_cust_code.value= '';"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup(p_payer_grp_code)"  tabindex='2' />
					<input type="hidden" name="p_cust_code" id="p_cust_code" 				id="p_cust_code"			value=""> 
				
				</td>


				<td class="label" colspan='3'></td>
				
			 </tr>
			 <tr>
			 	<td class="label" ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="policy_desc" id="policy_desc" id="policy_desc"    maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!='') policyLookup();else  p_policy_type_code.value ='';"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup()"  tabindex='2'/>	
					<input type="hidden" name="p_policy_type_code" id="p_policy_type_code"	 		id="p_policy_type_code"		value=""> 						
				</td>
				<td class="label" >Episode Duration</td>
				<td class="label" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text' name='p_fm_date' id='p_fm_date' id="p_fm_date" maxlength="10"  >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date');"  onKeyPress="return lockbackSpace();">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text' name='p_to_date' id='p_to_date' id="p_to_date" maxlength="10" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date');"  onKeyPress="return lockbackSpace();">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				
				<!-- <td class="label" colspan='3'></td>  -->
				
			 </tr>
			 <tr>
			 <td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="specialty_desc" id="specialty_desc" id="specialty_desc"    maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!='') specialityLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return specialityLookup()"  tabindex='2'/>
					<input type="hidden" name="p_specialty_code" id="p_specialty_code" 			id="p_specialty_code"		value="">
					
				</td>
			 	<td class="label" ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan='2'>
					<select id="sum_yn" name="sum_yn" id="sum_yn"  style="width: 120px;">					
					<option value="INRUCAF">UCAF</option>
					<option value="INRDCAF">DCAF</option>
					</select>			
				</td>
			 </tr>


			
			
		</table>
		<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
		<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<!--			<input type='hidden' name='mode' id='mode'		id='mode' 			value="<%=mode%>" 		>	-->
		<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="IN"				>
		<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value=""				>
		<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""				> 
		
		
		<input type="hidden" name="p_facility_id" id="p_facility_id" 				id="p_facility_id" 			value="<%=facilityId%>"	>
		<input type="hidden" name="p_episode_id" id="p_episode_id" 							value=""				>
		<input type="hidden" name="p_visit_id" id="p_visit_id" 				id="p_visit_id"			value=""				>
		 <input type="hidden" name="p_patient_id" id="p_patient_id" 				id="p_patient_id"			value=""				>
		
<!--		<input type="hidden" name="p_patient_id" id="p_patient_id" 				id="p_patient_id"			value=""				>
		<input type="hidden" name="p_episode_type" id="p_episode_type" 				id="p_episode_type"			value=""				> 
		<input type="hidden" name="p_episode_id" id="p_episode_id" 				id="p_episode_id" 			value=""				>
		<input type="hidden" name="p_physician_id" id="p_physician_id" 				id="p_physician_id"			value=""				>
		<input type="hidden" name="p_fm_date" id="p_fm_date" 					id="p_fm_date"				value=""				> 
		<input type="hidden" name="p_to_date" id="p_to_date" 					id="p_to_date" 				value=""				>
		<input type="hidden" name="p_payer_grp_code" id="p_payer_grp_code" 			id="p_payer_grp_code"		value=""				>
		<input type="hidden" name="p_policy_type_code" id="p_policy_type_code"	 		id="p_policy_type_code"		value=""				> 
		<input type="hidden" name="p_cust_code" id="p_cust_code" 				id="p_cust_code"			value=""				> 
		<input type="hidden" name="p_specialty_code" id="p_specialty_code" 			id="p_specialty_code"		value=""				> 
		<input type="hidden" name="p_language_Id" id="p_language_Id" 				id="p_language_Id"			value="<%=locale%>">  -->
</form>
</BODY>
<%
}
catch(Exception e)
{
	System.out.println("Exception in BillingReportCriteria.jsp::"+e);
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


