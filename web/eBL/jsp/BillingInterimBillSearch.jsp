
<!-- 
Sr No           Version             Incident			SCF/CRF                      Developer Name
1               V201218             IN73702        MMS-DM-CRF-0100.1         		Palani Narayanan
-->

<%@ page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean "  contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	String calledForm = (String) request.getParameter("calledForm");
	if(calledForm == null) {
		calledForm = "";
	}
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingInterimBillScript.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
 <script language='javascript' src='../../eBL/js/json2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
	var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var PAYER_LOOKUP_RECORD_PREAPPROVAL				=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var POLICY_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP	=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP")%>";
	var headTop = -1;
	var FloatHead1;
/*function onloadRequestStatus()
{	
	document.forms[0].request_status.value='*';
	if(document.forms[0].calledForm.value == "serviceApprStatus") {
		document.forms[0].order_status.value='*';
	}
}*/

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

function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}else if(responseText=="Y"){
			LoadPatientName(patient_id);
		}
	}
}     

async function PatientIdLookup()
{	

	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
}	

function LoadPatientName(pat_id)
{
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
	for(var i=0;i<response.length;i++)
	{
		document.getElementById("patient_name").value = response[i];
	}
		ChangeUpperCase(document.getElementById('patient_name'));
	}
	}
		xmlhttp.open("POST","../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId="+pat_id,true);
		xmlhttp.send(null);
}		
function validateMenuIntrem()
	{	
		var facilityId= document.getElementById("facilityId").value;
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateBlIntreamBillMenuDisableOrEnable&facilityId="+facilityId ;
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
		var responseText = trimString(xmlHttp.responseText);
		if(responseText=='N')
		{ 	
			alert("APP-BL0929 Interim Bill Authorization Cannot Be Applicable"); 
			parent.parent.frames[2].commontoolbarFrame.document.location.reload();
			document.location.href="../../eCommon/html/blank.html";
						
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
	String locale		=	"";
	String facilityId	=	"";
	String mode			=	"";
	mode				=	"";
	String isUserCanAcess =	"";
	String bean_id		=	"";
	String bean_name	=	"";
	ArrayList episodeTypeList	=	null;
	int defaultDate = 1;
	String restrictDate = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String sql="";
	int pat_id_len = 0;

	try
	{
		con = ConnectionManager.getConnection();
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();

		if (rst != null && rst.next())
		{
			pat_id_len = rst.getInt("patient_id_length");
		}
		} catch(Exception e) {
			pat_id_len = 15;
			out.println(e.toString());
			e.printStackTrace();
		}
	finally 
	{
		try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rst != null) {
					rst.close();
				}
				ConnectionManager.returnConnection(con);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

try  
{	 
	sStyle 					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 					= 	(String)session.getAttribute("LOCALE");
	facilityId				=    (String) session.getValue( "facility_id" ) ;
	String auth 			=	checkForNull((String)session.getAttribute("auth2"));
	bean_id					= 	"RecordApprovalPatientDataBean" ;
	bean_name				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess				= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	episodeTypeList				=	recordApprovalPatientDataBean.populateEpisodeTypeList(facilityId, locale);
	%>
<body   onMouseDown="CodeArrest();" onKeyDown= "lockKey();"    onLoad="validateMenuIntrem();"  onSelect="codeArrestThruSelect();">
	<form id="interimBill" name="interimBill" id="interimBill" >	
	
		<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
		<tr>
			 	<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" 		maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
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
					<select id="episode_type" name="episode_type" id="episode_type"  style="width: 130px;">
					
					<%
					for(int index=0;index<episodeTypeList.size();index++)
					{
					if(episodeTypeList.get(index).equals("IP"))
					{%>
							<option value="<%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %>" selected><%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %> </option>
					<%} else if(episodeTypeList.get(index).equals("DC")){ 
					
					%>
						<option value="<%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %>" ><%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %> </option>
					<%
					}
					}
					%>	
					</select>
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return enCounterIdLookup()"  tabindex='2'>					
				</td>
				<td class="label" colspan='2'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td>
					<input type="text" name="speciality" id="speciality" id="speciality"    maxlength="100"  onBlur="ChangeUpperCase( this );return specialityLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return specialityLookup()"  tabindex='2'/>
				</td>				
				<td class="label" colspan='3'>				
		</tr>
		<tr>
			 	<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='fields' >
					<input type="text" name="payer_group" id="payer_group" id="payer_group" 		 maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /><img src='../../eCommon/images/mandatory.gif'>	
					</td>				
				 	<td class="label" colspan="2" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="payer" id="payer" id="payer" 		 maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup()"  tabindex='2' />				
				</td>
				<td class="label" ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="policy" id="policy" id="policy"    maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup()"  tabindex='2'/>					
				</td>
		</tr>
			<td class="fields" colspan="2">
			</td>
			<td class="fields" colspan="2">
			</td>
			<td class="fields" colspan="2">
			</td>
			<td class="label" colspan='3'>
				<input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Search" onclick="showRecordApprovalPatientDeatils();"  />
			</td>	
		</tr>
		</table>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId'  value="<%=facilityId%>" >
		<input type='hidden' name='selectAllFlag' id='selectAllFlag' id='selectAllFlag' value="N" >
		<input type='hidden' name='selectArrFlag' id='selectArrFlag' id='selectArrFlag' value="" >
		<input type='hidden' name='selectArrUnSlectFlag' id='selectArrUnSlectFlag' id='selectArrUnSlectFlag' value="" >
		<input type='hidden' name='selectJsonArrFlag' id='selectJsonArrFlag' id='selectJsonArrFlag' value="" >
		<input type='hidden' name='authorizedUserId' id='authorizedUserId' id="authorizedUserId" value="N">
		<input type='hidden' name='authorizedUserName' id='authorizedUserName' id="authorizedUserName" value="">
		<input type='hidden' name='mainAuth' id='mainAuth' id="mainAuth" value="">
		<input type='hidden' name='privilegeYN' id='privilegeYN' id="privilegeYN" value="">
		<input type='hidden' name='selectAllPrevFlag' id='selectAllPrevFlag' id="selectAllPrevFlag" value="">
		<input type='hidden' name='facilityIdnew' id='facilityIdnew' id='facilityId'  value="<%=facilityId%>" >
		
		</body>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in BillingRecordApprovalSearch.jsp::"+e);
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
</form>
</html>

