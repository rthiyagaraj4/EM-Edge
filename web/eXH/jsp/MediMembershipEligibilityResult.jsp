<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>

<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>

<script language="javascript">

function funSubmit()
{
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action = '../../eXH/jsp/MediMembershipEligibilityResult.jsp';
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.target="resultFrame";
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.submit();
}

function funAction(typ)
{  
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action_type.value = typ;
	funSubmit();
}

//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/MediMembershipEligibilityResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

async function checkEligibility(obj)
{	
	//alert(obj);
	//var checkType = "";
	
	//var checkTypeButtons = document.getElementsByName('CheckType');
	
	//for(var i = 0; i < checkTypeButtons.length; i++){
	//	if(checkTypeButtons[i].checked){
		//	checkType = checkTypeButtons[i].value;
		//}
	/*}

	var patient_name = obj.getAttribute('pat_name');
	var patient_id = obj.getAttribute('patient_id');
	var encounterId = obj.getAttribute('encounterId');
	var pat_cls_episode = obj.getAttribute('patient_class_episode');
	var episode_id = obj.getAttribute('episode_id');

	var pat_dob = obj.getAttribute('pat_dob');
	var national_id = obj.getAttribute('national_id');
	var sex = obj.getAttribute('sex');
	var visit_adm_dt_time = obj.getAttribute('visit_adm_dt_time');
	var locationType = obj.getAttribute('location_type');
	var locationCode = obj.getAttribute('location_code');
	var service_code = obj.getAttribute('service_code');
	var speciality_code = obj.getAttribute('speciality_code');
	var cust_code = obj.getAttribute('cust_code');
	var facilityId = obj.getAttribute('facility_id');
	var firstName = obj.getAttribute('first_name');
	var secondName = obj.getAttribute('second_name');
	var initial = obj.getAttribute('initial');
	var familyName=obj.getAttribute('familyName');
	var membership_no = obj.getAttribute('membership_no');

	var wca_no = obj.getAttribute('wca_number');
	var dependant_number = obj.getAttribute('dependant_number');
	var dependant_relationship = obj.getAttribute('dependant_relationship');
	var destination_code = obj.getAttribute('destCode');

	var visit_id = obj.getAttribute('visitId');
	var episode_type = obj.getAttribute('episodeType');


	var request_status = obj.getAttribute('request_status');
	var auth_num = obj.getAttribute('auth_num');
	var approval_status = obj.getAttribute('approval_status');
	var warn_code = obj.getAttribute('warn_code');
	var warn_desc = obj.getAttribute('warn_desc');
*/
    var admission_type = document.forms[0].admission_type.value;
	//var destination_code = document.forms[0].dest_code.value;

    var checkType = "";
	var patientData="";
	var checkedValue = null; 
	var checkBoxes = document.getElementsByName('checkbox');
	var selectedIndex = 0;
	var count = 0;

	var authnumname = "";
	var destcodename = "";
	
	var authnum = "";
	var destcode = "";

	
	var event_type = "";
	var approval_status = "";

	var national_id = "";
	//var destcode = "";

	var responseMessage = "";
	
	for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
			selectedIndex = i;
			count++;
		}
	}
	var national_id_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.national_id"+selectedIndex);
	var destination_code_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.dest_code"+selectedIndex);

	national_id = national_id_obj.value;
	destcode = destination_code_obj.value;

	var event_type_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.event_type"+selectedIndex);
	var approval_status_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.approval_status"+selectedIndex);

	event_type = event_type_obj.value;
	approval_status = approval_status_obj.value;
    
    if(count == 0 || checkedValue == null)
	{
         alert("APP-XH0071 Please select at least one Patient.");
		 return;
	}
	if(count > 1)
	{
         alert("APP-XH0072 More than one Patient cannot be processed, please select only one Patient.");
		 return;
	}
   /*if(!((event_type != "IEC") && (event_type != "UEC"))){
		if(!(approval_status != "A"))
		{ 
			alert("APP-XH0069 Eligiblity Check Has been Successfully done for this Patient.");
			return;
		}
	}*/
	if(!(obj != "IDC")){
		if(!(national_id != null && national_id != "" && national_id != " "))
		{ 
			alert("APP-XH0073 National ID number is not available for this Patient, Kindly update the National ID number in the Change Patient Details, before you proceed with ID Check.");
			return;
		}
	}

   var settlement_ind_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.settlement_ind"+selectedIndex);
   var settlement_ind = settlement_ind_obj.value;

   var billing_grp_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.billing_grp"+selectedIndex);
   var billing_grp = billing_grp_obj.value;

   var cust_code_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.cust_code"+selectedIndex);
   var cust_code = cust_code_obj.value;

   var visit_date_obj = eval ("document.PAYER_CHECK_ELIGIBILITY_FORM.this_date"+selectedIndex);
   var visit_date = visit_date_obj.value;

   var destAlertMessage = "";
   var eventName = "";

   if (obj == "IDC")
		 eventName = "ID Check";

   if (obj == "FAM")
		 eventName = "FAM Check";

   if (obj == "UEC")
		 eventName = "Un-Insured Eligibility Check";

   if (obj == "IEC")
		 eventName = "Insured Eligibility Check";

	if(!(destcode != null && destcode != "" && destcode != " "))
	{ 
		if (settlement_ind == "C")
		{
			destAlertMessage = "APP-XH0074 Billing Group "+billing_grp+" is not mapped to Destination Code pertaining to process "+eventName+" dated "+visit_date;
		}
		if ((settlement_ind == "X") || (settlement_ind == "R"))
		{
			destAlertMessage = "APP-XH0074 Customer Code "+cust_code+" is not mapped to Destination Code pertaining to process "+eventName+" dated "+visit_date;
		}
		alert(destAlertMessage);
		return;
	}
    checkedValue = checkedValue.replace("#checkType#",obj);
	checkedValue = checkedValue.replace("#admission_type#",admission_type);

	var dialogHeight = "55vh";    // have to remove 
	var dialogWidth  = "75vw";
	var dialogTop    = "130";
	var title="Patient Eligibility Check ";
	title=encodeURIComponent(title);
    checkedValue = checkedValue.replace("#title#",title);

	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	/* var params= "title="+title+"&pid="+patient_id+"&eid="+encounter_id+"&nuc="+nursing_unit_code+"&pst="+pStartDate+"&ped="+pEndDate+"&pn="+pat_name+"&pdob="+pat_dob+"&ni="+national_id+"&pcn="+pat_contactno+"&mcn="+membership_no+"&phn="+policy_holder_name+"&pln="+policy_number+"&pdc="+provider_code+"&sc="+service_code+"&pyc="+payer_code+"&ptc="+policy_type_code+"&bgi="+billing_group_id+"&pgd="+p_g_desc+"&prio="+priority+"&pyname="+payerName+"&vdt="+visit_adm_date_time+"&eff="+effectiveFrom+"&eft="+effectiveTo+"&bgd="+billing_group_desc+"&ofd="+operating_facility_id+"&epid="+episode_id+"&vsid="+visit_id;  */
     
	var params=checkedValue; /*"title="+title+"&pname="+patient_name+"&pcepisode="+pat_cls_episode+"&epid="+episode_id+"&pdob="+pat_dob+"&nid="+national_id+"&sex="+sex+"&vadmitdt="+visit_adm_dt_time+"&locType="+locationType+"&loccd="+locationCode+"&fcid="+facilityId+"&fname="+firstName+"&sname="+secondName+"&initial="+initial+"&familyName="+familyName+"&memno="+membership_no+"&wca="+wca_no+"&depNum="+dependant_number+"&depRel="+dependant_relationship+"&checkType="+checkType+"&pid="+patient_id+"&scode="+service_code+"&encounterId="+encounterId+"&speciality_code="+speciality_code+"&destCode="+destination_code+"&custCode="+cust_code+"&admission_type="+admission_type+"&episode_type="+episode_type+"&visit_id="+visit_id+"&request_status="+request_status+"&auth_num="+auth_num+"&approval_status="+approval_status+"&warn_code="+warn_code+"&warn_desc="+warn_desc; 
	*/	

	var arguments = new Array();
	var url = "../../eXH/jsp/MediClaimsEligibilityPopUp.jsp?" +params;
	
	var retVal = await window.showModalDialog(url,arguments,features);
	parent.resultFrame.location.reload();
}

function includeBoxChecked() {

	if (document.forms[0].includeMastercheckbox.checked == true) {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = true;
			}
		} else if (document.forms[0].gatewayservers.length == undefined) {
			document.forms[0].includeCheckbox.checked = true;
		}
	}
	else {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = false;
			}
		} else if (document.forms[0].includeCheckbox.length == undefined) {
			document.forms[0].includeCheckbox.checked = false;
		}
	}
	return true;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >
<form name="PAYER_CHECK_ELIGIBILITY_FORM" id="PAYER_CHECK_ELIGIBILITY_FORM" method="POST" action=''  >
<%
	String order = "";
	String orderBy = "";
	String action_type=null;
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null ;
	String rs_patientId="",rs_episodeId = "",rs_encounter_id = "", rs_billNumber = "", rs_sex = "", rs_nationalId = "", rs_visitAdmissionDate = "", rs_patientName = "", rs_encounterId = "", rs_episodeType = "", rs_visitId = "";
	String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "", rs_billGrpId = "", rs_settleInd = "", rs_thisDate = "";
	String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="", rs_event_type = "" ,rs_event_type_desc = "";

	String checkboxvalue ="",checkboxname ="";

	HttpSession httpSession = request.getSession(false);
	String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
	String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
	String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
	String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
	String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	String encounter_id = XHDBAdapter.checkNull(request.getParameter("encounter_id"));

	String admission_from_dt = XHDBAdapter.checkNull(request.getParameter("admission_from_dt"));

	String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

	String rs_approval_status = "", rs_approval_status_desc= "";

	if(admission_from_dt!="" && admission_from_dt!=null)
	{
	   admission_from_dt = admission_from_dt+ " 00:00:00";
	}

	String admission_to_dt = XHDBAdapter.checkNull(request.getParameter("admission_to_dt"));
	if(admission_to_dt!="" && admission_to_dt!=null)
	{
	   admission_to_dt =admission_to_dt + " 23:59:59";
	}

	//String patient_class_orderby = XHDBAdapter.checkNull(request.getParameter("patient_class_orderby"));
	String eligibility_action_type = XHDBAdapter.checkNull(request.getParameter("eligibility_action_type"));
	String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));

	String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));

	String dest_code = "";

	if(isDebugYN.equals("Y")){
	System.out.println("MediClaimsEligibilityPopUp.jsp:::customer_id....."+customer_id);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::patient_id....."+patient_id);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::admission_from_dt....."+admission_from_dt+" admission_to_dt :::: "+admission_to_dt );
	System.out.println("MediClaimsEligibilityPopUp.jsp:::admission_type....."+admission_type +" eligibility_status_type ::: "+eligibility_status_type);
	System.out.println("MediClaimsEligibilityPopUp.jsp:::EpisodeID....."+episode_id +" EpisodeType ::: "+episode_type);
    }
	/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

	boolean  boolToggle = true;
	String strTDClass = "";
	String whereClause = "";
	int totalRecords=0;

	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	try
	{ 
		conn = ConnectionManager.getConnection(request);

				
		if("1".equalsIgnoreCase(admission_type))
		{
			
			if(isDebugYN.equals("Y")){
				System.out.println("preadmission.. patient id..."+patient_id);
			}
                        whereClause = " where NVL(TRANS_TYPE,'ELCREQ') = 'ELCREQ' ";
			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				whereClause = whereClause + " AND PATIENT_ID =  '#patient_id' ";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				whereClause = whereClause + " AND CUST_GROUP_CODE =  '#customer_group' ";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				whereClause = whereClause + " AND CUST_CODE =  '#customer_id' ";  
			}
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
			{
				whereClause = whereClause + " AND APPROVAL_STATUS = '#eligibility_status_type' ";  
			}
			request.setAttribute(XHQueryRender.strQueryId,"PREADMISSIONELIGIBILITYCHECK");	
		}
		else
		{
			whereClause = " where NVL(TRANS_TYPE,'ELCREQ') = 'ELCREQ' ";
			if(isDebugYN.equals("Y")){
				System.out.println("on admission.. patient id..."+patient_id);
			}

			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				whereClause = whereClause + " AND PATIENT_ID =  '#patient_id' ";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				whereClause = whereClause + " AND CUST_CODE =  '#customer_id' ";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				whereClause = whereClause + " AND CUST_GROUP_CODE =  '#customer_group' ";
			}
			if(episode_id != null && episode_id != "" && episode_id != " ")
			{
				whereClause = whereClause + " AND episode_id=  '#episode_id' ";
			}
			
			if(admission_from_dt!="" && admission_from_dt!=null && admission_to_dt!="" && admission_to_dt!=null){
				
			//whereClause = whereClause + " And TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('#admission_from_dt','DD/MM/YYYY HH24:MI:SS') AND TO_Date('#admission_to_dt', 'DD/MM/YYYY HH24:MI:SS')";

			whereClause = whereClause + " And TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+admission_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+admission_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			}
			
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
			{
				whereClause = whereClause + " AND APPROVAL_STATUS =  '#eligibility_status_type' ";  
			}
			/*if(patient_class_orderby != null && patient_class_orderby != "" && patient_class_orderby != " ")
			{
				whereClause = whereClause + " Order by "+patient_class_orderby;
			}*/
			request.setAttribute(XHQueryRender.strQueryId,"ONADMISSIONELIGIBILITYCHECK");
		}
		
		if(isDebugYN.equals("Y")){
			System.out.println("whereClause....."+whereClause);
		}
		request.setAttribute(XHQueryRender.col,"43"); 
		request.setAttribute(XHQueryRender.maxRec,"7");
		request.setAttribute(XHQueryRender.whereClause,whereClause);
		HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
		//String sqlQuery= XHQueryRender.sqlQuery;	
		//System.out.println("sqlQuery... "+sqlQuery);
		ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
		ArrayList arrCol = null;
		boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
		boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
		if(isDebugYN.equals("Y")) System.out.println("boolPrevious...."+String.valueOf(boolPrevious));
		if(isDebugYN.equals("Y")) System.out.println("boolNext...."+String.valueOf(boolNext));
		String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		if (boolPrevious == true)
		{
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
		}
		else
		{
			strPrevious = " ";
		}
		if (boolNext== true)
		{
			strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
		}
		else
		{
			strNext  = " ";
		}
		if(isDebugYN.equals("Y")){
			System.out.println("action_type in jsp...."+action_type);
		}
	
     %> 
		    <input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>		     
			<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id %> >			
			<input type='hidden' name='patient_class_episode' id='patient_class_episode' value=<%=patient_class_episode%>>
			<input type='hidden' name='episode_id' id='episode_id' value=<%=episode_id %>>
		 	<input type='hidden' name='episode_type' id='episode_type' value=<%=episode_type %>>
			<input type='hidden' name='admission_from_dt' id='admission_from_dt' value=<%=admission_from_dt %>>
			<input type='hidden' name='admission_to_dt' id='admission_to_dt' value=<%=admission_to_dt %>>
			
			<input type='hidden' name='admission_type' id='admission_type' value=<%=admission_type%>>

			<input type='hidden' name='encounter_id' id='encounter_id' value=<%=encounter_id%>>
			
			<input type='hidden' name='pat_name' id='pat_name' value="">
			<input type='hidden' name='pat_dob' id='pat_dob' value="">
			<input type='hidden' name='national_id' id='national_id' value="">
			<input type='hidden' name='sex' id='sex' value=""> 
			 
			<input type='hidden' name='visit_adm_dt_time' id='visit_adm_dt_time' value="">
			<input type='hidden' name='location_type' id='location_type' value="">
			
			<input type='hidden' name='location_code' id='location_code' value="">
			<input type='hidden' name='service_code' id='service_code' value="">
			<input type='hidden' name='speciality_code' id='speciality_code' value="">
			<input type='hidden' name='cust_code' id='cust_code' value="">
			 
		   <input type='hidden' name='facility_id' id='facility_id' value="">
		   <input type='hidden' name='encounter_id' id='encounter_id' value="">
		   <input type='hidden' name='first_name' id='first_name' value="">
		   <input type='hidden' name='second_name' id='second_name' value="">
		   <input type='hidden' name='initial' id='initial' value="">
			   
		   <input type='hidden' name='encounter_id' id='encounter_id' value="">
		   <input type='hidden' name='first_name' id='first_name' value="">
		   <input type='hidden' name='second_name' id='second_name' value="">
		   <input type='hidden' name='initial' id='initial' value="">

		   <input type='hidden' name='membership_no' id='membership_no' value="">
		   <input type='hidden' name='wca_number' id='wca_number' value="">
		   <input type='hidden' name='dependant_number' id='dependant_number' value="">
		   <input type='hidden' name='dependant_relationship' id='dependant_relationship' value="">

	 <%

		if(arrRow.size()==0)
		{
		%>	
			<script>
			//	parent.f_query_footer.location.href='../../eCommon/html/blank.html';
				alert('APP-002415 Query caused no records to be retrieved');
				history.go(-1);
				/*var function_id=parent.document.getElementById("function_id").value;
				parent.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
				parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';	   */
				parent.resultFrame.location.href='../../eCommon/html/blank.html';

			</script>
																						
			<%
		}
		else
		{
			
		%> 

	<fieldset>
		<table cellspacing=0 cellpadding=5 width='100%' align=right border=0>
			<tr>
				<td>			
				</td>
				<td>			
				</td>
			</tr>		
			<tr>
				<td align=center>
		       
					<!--<input type="radio" name="CheckType" id="CheckType" id="CheckType" value="IDC" checked> ID Check					
					<input type="radio" name="CheckType" id="CheckType" id="CheckType" value="FAM" > Fam Check
					<input type="radio" name="CheckType" id="CheckType" id="CheckType" value="UEC"> Uninsured Eligibility Check
					<input type="radio" name="CheckType" id="CheckType" id="CheckType" value="IEC"> Eligibility Check
					-->
				</td>
				<td align=right>
					<!-- <input class='BUTTON' type="button"  ID="eligibility_check" name=eligibility_check value='Eligibility Check' onClick="eligibilityCheck()">	 -->	
				</td>
			</tr>		
			<tr>
				<td>
				</td>
			</tr>		
		</table>	
	</fieldset>
	
	<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
	<tr>
		<td colspan="27" class="COLUMNHEADER" align='center'>Membership Eligibility Check</td>
	</tr>
	<tr>	   
		<td align="right" class="CAGROUP" > 
		 <input class='BUTTON' type="button"  ID="search" name=search value='ID Check' onClick="checkEligibility('IDC')">
		        <input class='BUTTON' type="button"  ID="search" name=search value='FAM Check' onClick="checkEligibility('FAM')">
		        <input class='BUTTON' type="button"  ID="search" name=search value='UnInsured Check' onClick="checkEligibility('UEC')">
		        <input class='BUTTON' type="button"  ID="search" name=search value='Insured Check' onClick="checkEligibility('IEC')">
		</td>
         <td align="right" class="CAGROUP" > 
			<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
			<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
		</td>
	</tr>
	</table>

	<div id="left_child" style="display:inline;">
	<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' border=1 align=center>	
		<tr>
			
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
			</td>

			<td class='COLUMNHEADER' width='16%'>
				<font color=white><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></font>
			</td>
			
			<td class='COLUMNHEADER' width='8%'>
				<font color=white ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></font>
			</td>
			
			<td class='COLUMNHEADER' width='5%'>
				<font color=white><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='8%'>
				<font color=white><fmt:message key="eMP.NationalID.label" bundle="${mp_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='8%'>
				<font color=white><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='9%'>
				<font color=white><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></font>
			</td>
			
			<!--
			<td class='COLUMNHEADER' width='6%'>
				<font color=white>Location Type </font>
			</td>
			-->

			<td class='COLUMNHEADER' width='9%'>
				<font color=white><fmt:message key="Common.service.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='9%'>
				<font color=white><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='12%'>
				<font color=white><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='12%'>
				<font color=white>Eligiblity Type</font>
			</td>
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/> </font>
			</td>

			<td class='COLUMNHEADER' width='8%'>
			</td>
			
		 <!--	<td class='COLUMNHEADER' width='3%' align="center">
				<input type="checkbox" onchange="includeBoxChecked()" onclick="includeBoxChecked()" id="includeMastercheckbox" name="includeMastercheckbox" id="includeMastercheckbox">
			</td>  -->
						
		</tr>

		<%
		totalRecords=0;

		for (int j=0; j<arrRow.size();j++)
		{
            rs_event_type_desc = "";
			rs_approval_status_desc = "";

			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}

			rs_custCode = arrCol.get(12).equals("null")?"":(String)arrCol.get(12); 

			rs_billGrpId = arrCol.get(39).equals("null")?"":(String)arrCol.get(39);

			rs_settleInd = arrCol.get(40).equals("null")?"":(String)arrCol.get(40);

			if(isDebugYN.equals("Y")){
				System.out.println(" ::: RS_CUSTCODE ::: "+rs_custCode);
				System.out.println(" ::: RS_BILLGRPID ::: "+rs_billGrpId);
				System.out.println(" ::: RS_SETTLEIND ::: "+rs_settleInd);
			}

			rs_destCode = getDestinationCode(rs_settleInd, rs_custCode, rs_billGrpId );

			if(isDebugYN.equals("Y")){
				System.out.println(" ::: RS_DESTCODE ::: "+rs_destCode);
			}
		%>

		<tr>
		<td  <%=strTDClass%> align="left" >
		 <% rs_patientId = arrCol.get(1).equals("null")?"":(String)arrCol.get(1); %>
         <font size=2>&nbsp;<%=rs_patientId%>
		 <input type='hidden' name='p_patientId' id='p_patientId' value="<%=rs_patientId%>" >
		</td>

		<td <%=strTDClass%> align="left">
			 <% 
			
				rs_patientName = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
				
				rs_firstName = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
				rs_secondName = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
				rs_intial = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
				rs_dob = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
				rs_familyName = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
				rs_thisDate = arrCol.get(41).equals("null")?"":(String)arrCol.get(41);
		
			%>
			<font size=2>&nbsp;<%=rs_patientName%>
			<input type='hidden' name='p_patientName' id='p_patientName' value="<%=rs_patientName%>" >

			<input type='hidden' name='p_firstName' id='p_firstName' value="<%=rs_firstName%>" >
			<input type='hidden' name='p_secondName' id='p_secondName' value="<%=rs_secondName%>" >
			<input type='hidden' name='p_intial' id='p_intial' value="<%=rs_intial%>" >
			<input type='hidden' name='p_dob' id='p_dob' value="<%=rs_dob%>" >
			<input type='hidden' name='p_familyName' id='p_familyName' value="<%=rs_familyName%>" >
		</td>

		<td <%=strTDClass%> align="left">
			 <% rs_episodeId = arrCol.get(2).equals("null")?"":(String)arrCol.get(2); %>
			 <% rs_visitId = arrCol.get(27).equals("null")?"":(String)arrCol.get(27); %>
			 <% rs_episodeType = arrCol.get(26).equals("null")?"":(String)arrCol.get(26); %>
    		 <% rs_encounter_id = arrCol.get(42).equals("null")?"":(String)arrCol.get(42); %>
		    <font size=2>&nbsp;<%=rs_episodeId%>
			<input type='hidden' name='p_episodeId' id='p_episodeId' value="<%=rs_episodeId%>" >
		</td>
		
		<td <%=strTDClass%> align="left">
			 <% rs_sex = arrCol.get(4).equals("null")?"":(String)arrCol.get(4); 
		     if(rs_sex.equals("F")){%>
				<font size=2><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			 <%}
			 if(rs_sex.equals("M")){%>
				<font size=2><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			 <%}%>
			 <input type='hidden' name='p_sex' id='p_sex' value="<%=rs_sex%>" >
		</td>
		<td <%=strTDClass%> align="left">
			<% rs_nationalId = arrCol.get(5).equals("null")?"":(String)arrCol.get(5); %>
			<font size=2>&nbsp;<%=rs_nationalId%>
			<input type='hidden' name='p_nationalId' id='p_nationalId' value="<%=rs_nationalId%>" >
		</td>
		<td <%=strTDClass%> align="left">
			<% rs_patientClass = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
			 if(rs_patientClass.equals("OP")){%>
				<font size=2><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
			 <%}
			 if(rs_patientClass.equals("IP")){%>
				<font size=2><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
			 <%}
			 if(rs_patientClass.equals("EM")){%>
				<font size=2><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			 <%}
			 if(rs_patientClass.equals("DC")){%>
				<font size=2><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
			 <%}
			 %>
			<input type='hidden' name='p_patientClass' id='p_patientClass' value="<%=rs_patientClass%>" >
		</td>
		<td <%=strTDClass%> align="left">
			<% rs_visitAdmissionDate = arrCol.get(7).equals("null")?"":(String)arrCol.get(7); %>
			<font size=2>&nbsp;<%=rs_visitAdmissionDate%>
			<input type='hidden' name='p_visitAdmissionDate' id='p_visitAdmissionDate' value="<%=rs_visitAdmissionDate%>" >
		</td>
		<!--
		<td <%=strTDClass%> align="left">
			 <% rs_locationType = arrCol.get(8).equals("null")?"":(String)arrCol.get(8); %>
			<font size=2>&nbsp;<%=rs_locationType%>
			<input type='hidden' name='p_locationType' id='p_locationType' value="<%=rs_locationType%>" >
		</td>
		-->
		<td <%=strTDClass%> align="left">
			 <% rs_serviceCode = arrCol.get(10).equals("null")?"":(String)arrCol.get(10); %>
			<font size=2>&nbsp;<%=arrCol.get(23).equals("null")?"":(String)arrCol.get(23)%>
			<input type='hidden' name='p_serviceCode' id='p_serviceCode' value="<%=rs_serviceCode%>" >
		</td>
		<td <%=strTDClass%> align="left">
			 <% rs_specialityCode = arrCol.get(11).equals("null")?"":(String)arrCol.get(11); %>
			<font size=2>&nbsp;<%=arrCol.get(22).equals("null")?"":(String)arrCol.get(22)%>
			<input type='hidden' name='p_specialityCode' id='p_specialityCode' value="<%=rs_specialityCode%>" >
		</td>
		<td <%=strTDClass%> align="left">
			 <% 
				System.out.println(" ::: Customer Code ::: "+arrCol.size());
				rs_custCode = arrCol.get(12).equals("null")?"":(String)arrCol.get(12); 
				System.out.println(" ::: Customer Code ::: "+rs_custCode);
				%>
			 <% 
				//rs_destCode = arrCol.get(25).equals("null")?"":(String)arrCol.get(25); 
				//System.out.println(" ::: Destination Code ::: "+rs_destCode);
				%>
			<% 
				rs_event_type = arrCol.get(34).equals("null")?"":(String)arrCol.get(34); 
				System.out.println(" ::: Event Type ::: "+rs_event_type);
                if(rs_event_type.equals("IDC"))rs_event_type_desc = "ID Check";
				if(rs_event_type.equals("FAM"))rs_event_type_desc = "FAM Check";
                if(rs_event_type.equals("UEC"))rs_event_type_desc = "UnInsured Check";
                if(rs_event_type.equals("IEC"))rs_event_type_desc = "Insured Check";

				
			%>
			<font size=2>&nbsp;<%=arrCol.get(24).equals("null")?"":(String)arrCol.get(24)%>
			<input type='hidden' name='p_custCode' id='p_custCode' value="<%=rs_custCode%>" >
			<input type='hidden' name='p_destCode' id='p_destCode' value="<%=rs_destCode%>" >
		</td>
		<td <%=strTDClass%> align="left">
			<font size=2>&nbsp;<%=rs_event_type_desc%>
			<input type='hidden' name='p_event_type' id='p_event_type' value="<%=rs_event_type%>" >
		</td>
	  <!-- 	<td  align="center">			
			 <input type="checkbox"  id="includeCheckbox" name="includeCheckbox" id="includeCheckbox">
		</td>  -->

		<td  <%=strTDClass%> align="center">
			<% 
				rs_approval_status = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);

				if (rs_approval_status.equals("A"))
					rs_approval_status_desc = "Authorized";
				if (rs_approval_status.equals("R"))
					rs_approval_status_desc = "Rejected";
				if (rs_approval_status.equals("99"))
					rs_approval_status_desc = "Network Error - No response File";
				if (rs_approval_status.equals("F"))
					rs_approval_status_desc = "Failed";
				if (!(rs_approval_status.length()>0))
					rs_approval_status_desc = "";
			%>
			 <font size=2>&nbsp;<%=rs_approval_status_desc%>
			<input type='hidden' name='dest_code<%=j%>' id='dest_code<%=j%>' value='<%=rs_destCode%>'>
		    <input type='hidden' name='national_id<%=j%>' id='national_id<%=j%>' value='<%=rs_nationalId%>'>
			<input type='hidden' name='event_type<%=j%>' id='event_type<%=j%>' value='<%=arrCol.get(34)%>'>
			<input type='hidden' name='approval_status<%=j%>' id='approval_status<%=j%>' value='<%=rs_approval_status%>'>
			<input type='hidden' name='settlement_ind<%=j%>' id='settlement_ind<%=j%>' value='<%=rs_settleInd%>'>
			<input type='hidden' name='billing_grp<%=j%>' id='billing_grp<%=j%>' value='<%=rs_billGrpId%>'>
			<input type='hidden' name='cust_code<%=j%>' id='cust_code<%=j%>' value='<%=rs_custCode%>'>
			<input type='hidden' name='this_date<%=j%>' id='this_date<%=j%>' value='<%=rs_thisDate%>'>
		</td> 
        <%
			checkboxvalue = "title=#title#&pname="+rs_patientName+"&pcepisode="+arrCol.get(2)+"&epid="+rs_episodeId+"&pdob="+rs_dob+"&nid="+rs_nationalId+"&sex="+rs_sex+"&vadmitdt="+rs_visitAdmissionDate+"&locType="+rs_locationType+"&loccd="+arrCol.get(9)+""+"&fcid="+arrCol.get(0)+""+"&fname="+rs_firstName+"&sname="+rs_secondName+"&initial="+rs_intial+"&familyName="+rs_familyName+"&memno="+arrCol.get(17)+"&wca="+arrCol.get(18)+"&depNum="+arrCol.get(19)+"&depRel="+arrCol.get(20)+"&checkType=#checkType#&pid="+rs_patientId+"&scode="+rs_serviceCode+"&encounterId="+rs_encounter_id+"&speciality_code="+rs_specialityCode+"&destCode="+rs_destCode+"&custCode="+rs_custCode+"&admission_type=#admission_type#&episode_type="+rs_episodeType+"&visit_id="+rs_visitId+"&request_status="+arrCol.get(28)+"&auth_num="+arrCol.get(29)+"&approval_status="+arrCol.get(30)+"&warn_code="+arrCol.get(31)+"&warn_desc="+arrCol.get(32)+"&event_type="+arrCol.get(34)+"&m_surname="+arrCol.get(37)+"&m_initial="+arrCol.get(38)+"&blng_grp_id="+rs_billGrpId+"&settlement_ind="+rs_settleInd;
			checkboxname = "secChk"+j;
		%>
		<td <%=strTDClass%> align="center" >
          <input type='checkbox'  name='<%=checkboxname%>' id='<%=checkboxname%>' value='<%=checkboxvalue%>' > 
			

		</td>
		 </tr>
		<%
			totalRecords++;
		}
			}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

 }catch(Exception e1)
			{
			 out.println("(MediMembershipEligibilityResult.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>

<%!
	public String getDestinationCode(String settlementInd, String custCode, String billGrpId)
	{

		Connection dbConn = null;
		ResultSet rsdest=null;
		PreparedStatement pstmt = null;

		String query = "", l_where_values = "", l_destination_code = "", l_app_msg = "";

		l_app_msg = " ::: Inside getDestinationCode ::: ";
		System.out.println(l_app_msg);
		
		try
		{
			dbConn =  ConnectionManager.getConnection();

			if (settlementInd.equals("X") || settlementInd.equals("R"))
			{	
				l_app_msg = " ::: Inside BL_CUST_DEST_MST ::: ";
				System.out.println(l_app_msg);	

				query = "select DESTINATION_CODE_SAP from BL_CUST_DEST_MST "
							+" where "
							+"	 CUST_CODE = ? and trunc(SYSDATE) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

				l_where_values = custCode;

			}
			else if (settlementInd.equals("C"))
			{
				l_app_msg = " ::: Inside BL_BLNG_GRP_DEST_MST ::: ";
				System.out.println(l_app_msg);	

				query = "select DESTINATION_CODE_SAP from BL_BLNG_GRP_DEST_MST "
							+" where "
							+"	 BLNG_GRP_ID = ? and trunc(SYSDATE) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

				l_where_values = billGrpId;
			}

			l_app_msg = " ::: Inside GETDESTINATIONCODE Query ::: "+query+ " ::: L_WHERE_VALUES ::: "+l_where_values;
			System.out.println(l_app_msg);
			
			pstmt = dbConn.prepareStatement(query);
			pstmt.setString(1, l_where_values);
			rsdest = pstmt.executeQuery();
			while(rsdest.next())
			{
			   l_destination_code = rsdest.getString("DESTINATION_CODE_SAP");
			}
			
		}
		catch(Exception e)
		{
			l_destination_code = "Error in "+ l_app_msg + " : " +  e.getMessage();

			return l_destination_code;
		}
		finally
		{			
			XHUtil.closeDBResources(rsdest, pstmt, dbConn);
		}	
		
		l_app_msg = " ::: L_DESTINATION_CODE ::: "+l_destination_code;
		System.out.println(l_app_msg);

		return l_destination_code;

	}
%>

</table>
<input type='hidden' name='dest_code' id='dest_code' value=<%=rs_destCode%>>
</form>
</body>
</html>

