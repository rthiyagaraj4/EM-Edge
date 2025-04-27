<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V201216             11086        NMC-JD-CRF-0087-TF-US001         Mohana Priya K
2			 V210630			 21001 		  NMC-JD-SCF-0210	   	           Mohana Priya K
 -->


<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.Common.*,com.ehis.util.*,eBL.*,eMR.*" contentType="text/html;charset=UTF-8" %>
<%@page import="eBL.BLReportIdMapper"%>
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
<script language="JavaScript" src="../../eBL/js/BLEclaimRpt.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL				=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
var RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP	=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP")%>";

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
String locale			=	"";
String facilityId		=	"";
//String isUserCanAcess	=	"";//V210630

try  
{	
    	HttpSession httpSession = request.getSession(false);  //V210630
	sStyle 				=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 				= 	(String)session.getAttribute("LOCALE");
	System.err.println("locale,69-->"+locale);
	//facilityId			=   (String) session.getValue( "facility_id" ) ;
	facilityId			=   (String) httpSession.getValue( "facility_id" ) ; //V210630
	System.err.println("facilityId,72-->"+facilityId);
	//isUserCanAcess		= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	//V210630	
%>

<body onMouseDown="CodeArrest();" onKeyDown= "lockKey();" onSelect="codeArrestThruSelect();">
<form id="eclaim" name="eclaim" id="eclaim">
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
<tr>
	<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/>
	</td>
</tr>		
</TABLE>	
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
	<tr>
		<td class="label" >
			<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			<input type="text" name="patient_id" id="patient_id" id="patient_id" 		 maxlength="30"  onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"     tabindex='2' />
		</td>
		<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class="fields" colspan="2">
			<input type="text" name="patient_name" id="patient_name" id="patient_name"    maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >	
		</td>
		<td class="label" colspan='3'></td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select id="episode_type" name="episode_type" id="episode_type"  style="width: 120px;">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="O" >OP</option>
				<option value="E" >EM</option>	
			</select><img src='../../eCommon/images/mandatory.gif'>		
		</td>
		<td class="label" >
			<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" colspan="2">
			<input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return enCounterIdLookup()"  tabindex='2'>
		</td>
		<td class="label" colspan='3'>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td>
			<input type="text" name="speciality" id="speciality" id="speciality"    maxlength="100"  onBlur="ChangeUpperCase( this );return specialityLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return specialityLookup()"  tabindex='2'/>
		</td>
		<td class="label" colspan='3'>
	</tr>
	 <tr>
		<td class="label" >
			<fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>
		</td>
		<td class='fields' >
			<input type="text" name="payer_group" id="payer_group" id="payer_group" 		 maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /> 
			<img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class="label" >
			<fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' colspan="2">
			<input type="text" name="fm_date" id="fm_date" id="fm_date" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].fm_date,fm_date,to_date);return dateRegEx(this)' >
				&nbsp; <img src="../../eCommon/images/CommonCalendar.gif" id=fmdate onClick="return showCalendar('fm_date');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class="label" colspan="3">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
		<td >
				<input type="text"  name="to_date" id="to_date"  id="to_date"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].to_date,fm_date,to_date);return dateRegEx(this)' >
				&nbsp; <img src="../../eCommon/images/CommonCalendar.gif" id=todate onClick="return showCalendar('to_date');" border="0"><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class="label" colspan='3'></td>
				
	 </tr>
	 <tr>
	 	<td class="label" >
	 		<fmt:message key="Common.Payer.label" bundle="${common_labels}"/>
	 	</td>
		<td class='fields'>
			<input type="text" name="payer" id="payer" id="payer" 		 maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup()"  tabindex='2' />
		</td>
		<td class="label" >
			<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
		</td>
		<td class="fields" colspan="2">
			<input type="text" name="policy" id="policy" id="policy"    maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup()"  tabindex='2'/>
		</td>
		<td class='fields' width="18%" > 
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='Export Excel' onClick="callExcelDisplay();" width="15" height="15" title='<fmt:message key="eOT.ReportinExcelFormat.Label" bundle="${ot_labels}"/>'  >
		</td>
	 </tr>			
</table>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='patient_id' id='patient_id' id='patient_id' value=''>
		<input type='hidden' name='patient_name' id='patient_name' id='patient_name' value=''>
		<input type='hidden' name='episode_type' id='episode_type' id='episode_type' value=''>
		<input type='hidden' name='encounter_id' id='encounter_id' id='encounter_id' value=''>
		<input type='hidden' name='speciality' id='speciality' id='speciality' value=''>
		<input type='hidden' name='payer_group' id='payer_group' id='payer_group' value=''>
		<input type='hidden' name='Effective_from' id='Effective_from' id='Effective_from' value=''>
		<input type='hidden' name='Effective_to' id='Effective_to' id='Effective_to' value=''>
		<input type='hidden' name='payer' id='payer' id='payer' value=''>
		<input type='hidden' name='policy' id='policy' id='policy' value=''>
		<input type='hidden' name='noOfCols' id='noOfCols' value=''>	
	</form>
</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in BLEclaimReport.jsp::"+e);
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

