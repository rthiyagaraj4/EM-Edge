
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
10/04/13      100         Bmohankumar  created
Acts as create and Modify screen for BillingRecordApprovalSearch.jsp
Sr No       Version             Incident              SCF/CRF                        Developer Name
1 			V201022             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2 			V201027             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
3			V220905				  33891		         TH-KW-CRF-0093                     Mohanapriya K
4 			 V221227			33882				TH-KW-CRF-0084					Mohanapriya K
6			 V230814 								NMC-JD-CRF-0102.2
-----------------------------------------------------------------------------------------------
-->

<%@ page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean "  contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String calledForm = (String) request.getParameter("calledForm");//Added By Aravindh/11-04-2018/MMS-DM-CRF-0125
	if(calledForm == null) {
		calledForm = ""; 
	}
	//V221227
	String patientid	="";
	String patientname ="";
	String encounterid ="";
	String episode_type ="";
	String payer_group  ="";
	String payer		="";
	String policy		="";
	String Effective_from="";
	String Effective_to	="";
	String speciality="";//V230814
	String Status="";
	
	String disableTrack="";
	String isVisible="";
	String params=request.getQueryString();
			
	System.err.println("params3 "+params);
	System.err.println("params3 "+request.getParameter("Speciality"));
	if(calledForm.equals("ApprStsTrack") || calledForm.equals("preAuthStsTrack")){//V230814
		disableTrack="disabled";
		isVisible="Style='display:none'"; //V230518-AAKH-CRF-0152
		patientid	=checkForNull(request.getParameter("patientId"));
		patientname =checkForNull(request.getParameter("patient_name"));
		encounterid =checkForNull(request.getParameter("encounter_id"));
		episode_type =checkForNull(request.getParameter("episode_type"));
		payer_group  =checkForNull(request.getParameter("payer_group"));
		payer		=checkForNull(request.getParameter("payer"));
		policy		=checkForNull(request.getParameter("policy"));
		Effective_from=checkForNull(request.getParameter("Effective_from"));
		Effective_to	=checkForNull(request.getParameter("Effective_to"));
		speciality	=checkForNull(request.getParameter("Speciality"));
		System.err.println("speciality "+speciality);
		Status=checkForNull(request.getParameter("Status"),"*");
		System.err.println("Status "+Status);
	}
	
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
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
	var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var PAYER_LOOKUP_RECORD_PREAPPROVAL				=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var POLICY_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
	var RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP	=	"<%=BlRepository.getBlKeyValue("RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP")%>";
	var headTop = -1;
	var FloatHead1;

function onloadRequestStatus()
{	
	document.forms[0].request_status.value='*';
	if(document.getElementById('calledForm').value == "serviceApprStatus") {
		document.forms[0].order_status.value='*';//Added By Aravindh/11-04-2018/MMS-DM-CRF-0125
	}
	else if(document.getElementById('calledForm').value == "ApprStsTrack" || document.getElementById('calledForm').value == "preAuthStsTrack") { //V221227

		 document.forms[0].patient_id.value=document.getElementById("patientid").value;
		 document.forms[0].patient_name.value=document.getElementById("patientname").value;
		 document.forms[0].encounter_id.value=document.getElementById("encounterid").value;
		 if(document.getElementById("episodetype").value==''){
			 document.forms[0].episode_type.value="";
		 }else{
			document.forms[0].episode_type.value=document.getElementById("episodetype").value;
		 }
		
		 document.forms[0].payer_group.value=document.getElementById("payergroup").value;
		 document.forms[0].payer.value=document.getElementById("payer_").value;
		 document.forms[0].policy.value=document.getElementById("policy_").value;
		 document.forms[0].Effective_from.value=document.getElementById("Effectivefrom").value;
		 document.forms[0].Effective_to.value=document.getElementById("Effectiveto").value;
		 document.forms[0].speciality.value=document.getElementById("speciality_val").value;//V230814
		 document.forms[0].request_status.value=document.getElementById("Status").value;
			 
		 showRecordApprovalPatientDeatils();
	}
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
	
/*	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
*/
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
//alert("inside BillingRecordApprovalSearch 194");
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
	else {
        document.getElementById('patient_name').value = '';
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
		//alert(response);
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
//String applyMode	=	new String();
String locale		=	"";
String facilityId	=	"";
//String loggedInUser =	"";
String mode			=	"";
mode				=	"";
String isUserCanAcess =	"";
String bean_id		=	"";
String bean_name	=	"";
//String modifyStatus	=	"";
ArrayList episodeTypeList	=	null;

//AAKH SCF 222
int defaultDate = 1;
String restrictDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;
boolean enableMCNNumber = false;//V220905
String enableMCNNumberYN = ""; //V220905

/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/starts */
String sql="";
int pat_id_len = 0;

try
{
	con = ConnectionManager.getConnection();
	sql ="select patient_id_length from mp_param";

	pstmt = con.prepareStatement(sql);
	rst = pstmt.executeQuery();

	if (rst != null && rst.next() )
	{
		pat_id_len = rst.getInt("patient_id_length") ;
	}
	} catch(Exception e) {
		pat_id_len = 15;//Setting Default Value if exception occured
		//out.println(e.toString());
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
/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/ends */
try {		
		con = ConnectionManager.getConnection();
		enableMCNNumber = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_MCN_REQ_NUM_FOR_SERV_APPR");
		if(enableMCNNumber){
			enableMCNNumberYN ="Y";
		} else{
			enableMCNNumberYN ="N";
		}		
		System.err.println("enableMCNNumber "+enableMCNNumber);
	} catch(Exception ex) {
		ex.printStackTrace();
		System.err.println("exception while checking enableMCNNumber function control-"+ex.toString());
	}finally{
	ConnectionManager.returnConnection(con);
}
	//V220905
try{
	con = ConnectionManager.getConnection();
	pstmt = con.prepareStatement("Select REC_APPRVL_DATE_DEFLT, REC_APPRVL_DATE_RESTRCT from bl_parameters");
	rst = pstmt.executeQuery();
	if(rst != null){
		while(rst.next()){
			defaultDate = rst.getInt("REC_APPRVL_DATE_DEFLT");
			restrictDate = rst.getString("REC_APPRVL_DATE_RESTRCT");			
			
			if(defaultDate == 0){
				defaultDate = 1;
			}
			
			if(restrictDate == null || "null".equals(restrictDate)){
				restrictDate = "";
			}
		}
	}
}
catch(Exception e){
	e.printStackTrace();
	System.err.println("Exception in getting days params from BL Parameter - >"+e);
	defaultDate = 1;
	restrictDate = "";
}
finally{
	pstmt = null;
	rst = null;
	ConnectionManager.returnConnection(con);
}
//AAKH SCF 222
try  
{	 
	sStyle 										=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 					= 	(String)session.getAttribute("LOCALE");
	facilityId				=   (String) session.getValue( "facility_id" ) ;	
	bean_id					= 	"RecordApprovalPatientDataBean" ;
	bean_name				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	episodeTypeList																			=	recordApprovalPatientDataBean.populateEpisodeTypeList(facilityId, locale);			
	
	/* Karthik added for adding Package Association along with subscription MMS-QH-CRF-0165 - Starts*/
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate=dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, -(defaultDate-1)); 
	String sevenDaysBeforeDate=dateFormat.format(cal.getTime());
	/* Karthik added for adding Package Association along with subscription MMS-QH-CRF-0165 - Ends*/
			
%>
<body   onMouseDown="CodeArrest();" onKeyDown= "lockKey();"    onLoad="onloadRequestStatus();"  onSelect="codeArrestThruSelect();">
	<form id="recordApproval" name="recordApproval" id="recordApproval" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >		<!-- V201022 modified -->	
		<TABLE width="100%" CELLSPACING=0 cellpadding='0' align='center'>
			<tr >
			<%	//V201027 start				
				if(calledForm.equals("serviceApprStatusReport") ) { 
			%>
			<td  class="columnheader" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
			<%
			}else{//V201027 end%>
			<td  class="columnheader" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
			<%
			}//V201027 added
			%>
			</tr>		
</TABLE>	
		<table cellpadding=2 cellspacing=0 width="100%" align="center" border=0>

				
			 <tr>
			 	<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" 	<%=disableTrack%>	maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"  <%=disableTrack%>   tabindex='2' />
				</td>
				<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="4">
					<input type="text" name="patient_name" id="patient_name" id="patient_name"  <%=disableTrack%>  maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >	
						
				</td>
				<td class="label" colspan='3'></td>
				
			 </tr>
			  <tr>
			 	<td class="label" ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select id="episode_type" name="episode_type" id="episode_type" <%=disableTrack%> style="width: 120px;">
					
					<%	//V201027 start				
						if(calledForm.equals("serviceApprStatusReport") ) { 
					%>
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<%
					}else{//V201027 end%>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
					}//V201027 added
					%>
					
					<%
					for(int index=0;index<episodeTypeList.size();index++)
					{
					System.err.println("episodeTypeList.get(index) "+episodeTypeList.get(index));
					%>
						<option value="<%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %>" ><%=episodeTypeList.get(index) != null ? episodeTypeList.get(index) : "" %> </option>
					<%
					}
					%>	
					</select>
					<img src='../../eCommon/images/mandatory.gif'>		
				</td>
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="encounter_id" id="encounter_id" id="encounter_id" <%=disableTrack%>  maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return enCounterIdLookup()" <%=disableTrack%> tabindex='2'>
					
				</td>
				<td class="label" colspan='3'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td>
				<input type="text" name="speciality" id="speciality" id="speciality"  <%=disableTrack%>  maxlength="100"  onBlur="ChangeUpperCase( this );return specialityLookup();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return specialityLookup()" <%=disableTrack%> tabindex='2'/>
				</td>
				<td class="label" colspan='3'>
				
			 </tr>
			  <tr>
			 	<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='fields' >
					<input type="text" name="payer_group" id="payer_group" id="payer_group" 	<%=disableTrack%>	 maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()" <%=disableTrack%> tabindex='2' />
					<%	//V201027 start				
						if(calledForm.equals("serviceApprStatusReport") ) { 
					%>
						<img src='../../eCommon/images/mandatory.gif'>
					<%
					}//V201027 end
					%>
					 
				</td>
				<td class="label" ><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
				<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan="2">
					<input type='text' name='Effective_from' id='Effective_from' id="Effective_from" <%=disableTrack%> maxlength="10"  onBlur="isValidDate(this)" value="<%=sevenDaysBeforeDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  <%=disableTrack%>  onKeyPress="return lockbackSpace();">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" colspan="3"><fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
				<td >
					<input type='text' name='Effective_to' id='Effective_to' id="Effective_to" <%=disableTrack%> maxlength="10" onBlur="isValidDate(this)" value="<%=todaysDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');" <%=disableTrack%> onKeyPress="return lockbackSpace();">
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" colspan='3'></td>
				
			 </tr>
			 <tr>
			 	<td class="label" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type="text" name="payer" id="payer" id="payer" 		 maxlength="30" <%=disableTrack%>  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup()"  <%=disableTrack%> tabindex='2' />
				
				</td>
				<td class="label" ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="policy" id="policy" id="policy"    maxlength="100"  <%=disableTrack%> onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  >	
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup()"  <%=disableTrack%> tabindex='2'/>
					
				</td>
				<td class="label" colspan='3'><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></td>
				<td>
				<Select id="request_status" name="request_status" id="request_status" id='request_status' <%=disableTrack%>>
						<option value="*">All</option> <!-- Added by vijay for  MMS-DM-CRF-0077  -->
						<option value="A">Approved</option>
						<option value="R">Rejected</option>
						<option value="P">Pending</option>
						<option value="S">Send to Insurance</option>
						<option value="H">Hold</option>
						<option value="C">Clarification</option>
				</select>
				</td>
				<td class="label" colspan='3'>
				<%
				/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if-condition */
				if(!calledForm.equals("serviceApprStatus") && !calledForm.equals("serviceApprStatusReport") ) { //V201022 modified
				%>
				<input type="button" <%=isVisible%> class='button' name="add_mod"	id="add_mod"   value="Search" <%=disableTrack%> onclick="showRecordApprovalPatientDeatils();"  />
				<%
				}
				%>
				</td>	
			 </tr>
			 
			 <!-- Added By Aravindh/11-04-2018/MMS-DM-CRF-0125 -->
			<%
			if(calledForm.equals("serviceApprStatus") ) { 
			%>
			 <tr>
				<td class="label"><fmt:message key="eBL.SERVICE_GROUP.label"
						bundle="${bl_labels}" /></td>
				<td class='fields'><input type="text" name="service_group" id="service_group"
					id="service_group" maxlength="30"
					onBlur="ChangeUpperCase( this );if(this.value!=''){serviceLookUp(service_group, 'G');}"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?'
					onClick="return  serviceLookUp(service_group, 'G');" tabindex='2' /></td>
				<td class="label"><fmt:message
						key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}" /></td>
				<td class='fields' colspan="2"><input type="text" name="service_classification" id="service_classification"
					id="service_classification" maxlength="30"
					onBlur="ChangeUpperCase( this );if(this.value!=''){serviceLookUp(service_classification, 'C');}"
					onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?'
					onClick="return serviceLookUp(service_classification, 'C');" tabindex='2' /></td>
				<td class="label" colspan="3"><fmt:message
						key="Common.OrderStatus.label" bundle="${common_labels}" /></td>
				<td><Select id="order_status" name="order_status" id="order_status" style="width: 130px;">
						<option value="*"><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
						<option value="B"><fmt:message key="eBL.Billed.label" bundle="${bl_labels}" /></option>
						<option value="U"><fmt:message key="eBL.UNBILLED_NEW.label" bundle="${bl_labels}" /></option>
				</select></td>				
				<td class="label" colspan='3'>
					<input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Search" onclick="showRecordApprovalPatientDeatils();"  />
				</td>				
			</tr>
			<%
			}
			%>		
			
		</table>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type='hidden' name='defaultDate' id='defaultDate' id='defaultDate' value='<%=defaultDate %>'>
		<input type='hidden' name='restrictDate' id='restrictDate' id='restrictDate' value='<%=restrictDate %>'>
		<input type='hidden' name='calledForm' id='calledForm' id='calledForm' value='<%=calledForm %>'><!-- Added By Aravindh/11-04-2018/MMS-DM-CRF-0125 -->
		<input type='hidden' name='serviceGroupHid' id='serviceGroupHid' id='serviceGroupHid' value='' /><!-- Added V180524-Aravindh/MMS-DM-CRF-0125 -->
		<input type='hidden' name='serviceClassficationHid' id='serviceClassficationHid' id='serviceClassficationHid' value='' /><!-- Added V180524-Aravindh/MMS-DM-CRF-0125 -->
		<input type='hidden' name='orderStatusHid' id='orderStatusHid' id='orderStatusHid' value='' /><!-- Added V180524-Aravindh/MMS-DM-CRF-0125 -->
		<!-- V201022 start -->
		<input type="hidden" name="enableMCNNumber" id="enableMCNNumber" id="enableMCNNumber" 	value="<%=enableMCNNumberYN%>"><!-- V220909 -->
		<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL">
		<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRSRAPS">
		<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value="BLRSRAPS"> 
		<!-- V201022 end -->
		<!-- V221227 start -->
		<input type="hidden" name="patientid" id="patientid" id="patientid" 	value="<%=patientid%>">
		<input type="hidden" name="patientname" id="patientname" id="patientname" 	value="<%=patientname%>">
		<input type="hidden" name="encounterid" id="encounterid" id="encounterid"	value="<%=encounterid%>">
		<input type="hidden" name="episodetype" id="episodetype" id="episodetype"			value="<%=episode_type%>"> 
		<input type="hidden" name="payergroup" id="payergroup" id="payergroup" 	value="<%=payer_group%>">
		<input type="hidden" name="payer_" id="payer_" id="payer_" 	value="<%=payer%>">
		<input type="hidden" name="policy_" id="policy_" id="policy_"	value="<%=policy%>">
		<input type="hidden" name="Effectivefrom" id="Effectivefrom" id="Effectivefrom"			value="<%=Effective_from%>"> 
		<input type="hidden" name="Effectiveto" id="Effectiveto" id="Effectiveto"			value="<%=Effective_to%>"> 
		<!-- V221227 end -->	    
		<input type="hidden" name="speciality_val" id="speciality_val" id="speciality_val" 	value="<%=speciality%>"><!-- V230814 -->
		<input type="hidden" name="Status" id="Status" id="Status"			value="<%=Status%>"> <!-- V230814 -->
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
</html>

