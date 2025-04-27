
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
04/02/13      100         Rajesh varadharajan  created
Acts as create and Modify screen for Receipt Nature
called on click of create button from common tool bar
on submission (apply) request will be submitte dto ReceiptNatureServlet
-----------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*" contentType="text/html;charset=UTF-8" %> 
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
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL	=	"<%="ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL"%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL	=	"<%="PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL"%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL			=	"<%="PAYER_LOOKUP_RECORD_PREAPPROVAL"%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL		=	"<%="POLICY_LOOKUP_RECORD_PREAPPROVAL"%>";	
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
		  }
	  }
	  async function PatientIdLookup()
		{	
					var pat_id=await PatientSearch();		
					var frm = document.forms[0];
					if( pat_id != null ){
						document.getElementById("patient_id").value = pat_id ;
						getPatDetails();
					}					
					else{
						frm.patient_id.value = '';
						frm.ageY.value = '';
						frm.ageM.value =  '';
						frm.ageD.value =  '';
						frm.gender.value = '';
						frm.patient_name.value =  '';
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



try  
{
	 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String PatIDLen = "";

try{
  con = ConnectionManager.getConnection(request);
	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=con.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
	{
     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
 catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("exception 2 in OperationProcedureHdr.jsp "+ee);
 }finally{
	if(rs!=null) rs.close();
	if(pstmt !=null) pstmt.close();
	   ConnectionManager.returnConnection(con, request);
}
		
%>
<body  onLoad="disableButtons();" onMouseDown="CodeArrest();"  onKeyDown= "lockKey();"    onSelect="codeArrestThruSelect();">
	<form id="frmEncounterHeader" name="frmEncounterHeader" id="frmEncounterHeader" target='messageFrame'>	

	
	
		<TABLE width="100%" CELLSPACING=0 cellpadding='0' align='center'>
			<tr >
			<td  class="columnheader" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>		
</TABLE>	
		<table cellpadding='0' cellspacing=0 width="100%" align="center" border=0>
							
				
			 <tr>
			 	<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=PatIDLen%>" 
						onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter('patId');} ">
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();defaultEncounter();"  tabindex='2' />
					<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="patient_name" id="patient_name" id="patient_name"  disabled  maxlength="100"  onBlur="ChangeUpperCase( this );"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
						
				</td>
				<td class="label" colspan='3'></td>
				
			 </tr>
			  <tr>
			 	<td class="label" ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select id="episode_type" name="episode_type" id="episode_type"  style="width: 70px;" onchange='defaultEncounter("epsdType");'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="eBL.OP.label" bundle="${bl_labels}"/></option>
					<option value="I"><fmt:message key="eBL.IP.label" bundle="${bl_labels}"/></option>
					<option value="D"><fmt:message key="eBL.DC.label" bundle="${bl_labels}"/></option>
					<option value="E"><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
					<option value="R"><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
				<td class="label" ><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					Y <input type='text' disabled size='2' name='ageY' id='ageY'> - M <input type='text' disabled size='2' name='ageM' id='ageM'> - D <input type='text' disabled size='2' name='ageD' id='ageD'> 
					
							</td>
				<td class="label" colspan='3'></td>
				
			 </tr>
			  <tr>
			 	<td class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="episode_id" id="episode_id" id="episode_id"  maxlength="30"  onBlur="if(this.value!=''){ episodeLookup(episode_id,hdnEpisode_id); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id'>
					<input type='button' class='button' name="episode_idbut" id="episode_idbut" value='?' onClick="episodeLookup(episode_id,hdnEpisode_id)"  tabindex='2' /> 
					<img src='../../eCommon/images/mandatory.gif'>	
				</td>
				
			<td class="label" ><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<select id="gender" name="gender" id="gender" disabled>
					<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>	
					<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					</select>	
				</td>			
			 </tr>
			 <tr>
		
				<td class="label" ><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text' name='Effective_from' id='Effective_from' maxlength="10"  size='10' onblur='isValidDate(this);'>
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>	
				
				<td class="label"> <fmt:message key="eBL.RecalculationCharges.label" bundle="${bl_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="recalc_charges" id="recalc_charges" disabled id="recalc_charges" />		
				</td>
				<td class="label" colspan='3'>
					<input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"  disabled value="Modify" onclick="authUser();"  />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class='button' name="search" id="search"	id="search"   value="Search" onclick="showPatientData();"  />
				</td>
			 </tr>				
		</table>
		
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type='hidden' name='auth' id='auth' value='N'>
		<input type='hidden' name='payerGroup' id='payerGroup' value="" >
		<input type='hidden' name='payer' id='payer' value="" >
		<input type='hidden' name='policy' id='policy' value="" >
		<input type='hidden' name='policyValidation' id='policyValidation' value="" >
		
		<input type='hidden' name='visitId' id='visitId' value="" >
		<input type='hidden' name='acctSeq' id='acctSeq' value="" >
		<input type='hidden' name='priority' id='priority' value="" >
		<input type='hidden' name='policyNo' id='policyNo' value="" >
		<input type='hidden' name='episodeType' id='episodeType' value="" >
		<input type='hidden' name='episodeId' id='episodeId' value="" >

		<input type='hidden' name='enteredPatient' id='enteredPatient' value=''>
		<input type='hidden' name='enteredEpisode' id='enteredEpisode' value=''>

		<input type='hidden' name='defaultPatient' id='defaultPatient' value=''>
		<input type='hidden' name='apprvl' id='apprvl' value='N'>

</body>
<%
}
catch(Exception e)
{
	System.out.println("Exception in EncounterSpecPolicyDefnSrchCreteria.jsp::"+e);
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

