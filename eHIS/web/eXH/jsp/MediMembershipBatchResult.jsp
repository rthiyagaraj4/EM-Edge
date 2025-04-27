<!DOCTYPE html>
<HTML> 
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter" %>

<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

System.out.println(" ::: sStyle ::: "+sStyle);
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
<style>
.left_child{
	overflow-y:auto;
 }
</style>
<script language="javascript">

function funSubmit()
{
	parent.resultFrame.PAYER_CHECK_BATCH_FORM.action = '../../eXH/jsp/MediMembershipBatchResult.jsp';
	parent.resultFrame.PAYER_CHECK_BATCH_FORM.target="resultFrame";
	parent.resultFrame.PAYER_CHECK_BATCH_FORM.submit();
}

function funAction(typ)
{  
	parent.resultFrame.PAYER_CHECK_BATCH_FORM.action_type.value = typ;
	funSubmit();
} 
//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/MediMembershipBatchResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}
function EclaimsTrx(obj)
{	
	var checkType = "";
	var patientData="";
	var checkedValue = null; 
	var checkBoxes = document.getElementsByName('checkbox');
	var selectedIndex = 0;
	var count = 0;
	var trans_Id = "";

	var authnumname = "";
	var destcodename = "";
	
	var authnum = "";
	var destcode = "";

	var responseMessage = "", validate = "";
	var docTypeCode = ""; var docNo = ""; var checkedValue = ""; var selectedValue = "";

	for (var i = 0; i < parent.patientClaimsArray.length; i++)
	{		
		selectedValue = "";
		selectedValue = parent.patientClaimsArray[i].selected_value;
		if(selectedValue == "Y")
		{
			count++;
		}
	
	} 

	if(count == 0)
	{
         alert("APP-XH0070 Please select at least one Bill Number.");
		 return;
	}

	var user_id = document.getElementById("userid").value;
	var ws_no = document.getElementById("wsno").value;

	for (var i = 0; i < parent.patientClaimsArray.length; i++)
	{
		docTypeCode = ""; docNo = ""; checkedValue = ""; selectedValue = "";
		docTypeCode = parent.patientClaimsArray[i].doc_type_code;
		docNo = parent.patientClaimsArray[i].doc_num;
		checkedValue = parent.patientClaimsArray[i].checked_value;
		selectedValue = parent.patientClaimsArray[i].selected_value;

		if (selectedValue == "Y")
		{
			checkedValue = checkedValue.replace("#USER_ID#",user_id);
			checkedValue = checkedValue.replace("#WS_NO#",ws_no);
			checkedValue = checkedValue.replace("#REQUEST#",obj);

			validate = ValidateTransaction(checkedValue);

			var responseData = "";
			responseData = validate.split("$!^");

			if (responseData.length > 0)
			{			
				if (responseData[0] == "True")
				{
					responseMessage = EClaimsTransaction(checkedValue);
				}
			}
		}

	}
	

	/*	
	for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
			selectedIndex = i;
			count++;
		}
	} 

	if(count == 0 || checkedValue == null)
	{
         alert("APP-XH0070 Please select at least one Bill Number.");
		 return;
	}
	document.forms[0].dataElements.value = checkedValue;
    for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
			checkedValue = checkedValue.replace("#REQUEST#",obj);
			validate = ValidateTransaction(checkedValue);
            
			var responseData = "";
			responseData = validate.split("$!^");

			if (responseData.length > 0)
			{
				var authnumobj = eval ("document.PAYER_CHECK_BATCH_FORM.authnum"+selectedIndex);
				var destcodeobj = eval ("document.PAYER_CHECK_BATCH_FORM.destcode"+selectedIndex);
                
				authnum = authnumobj.value;
				destcode = destcodeobj.value;

			    responseMessage = EClaimsTransaction(checkedValue);
			}
		}
	}

	*/
	alert("APP-XH0070 Batch Processing Successfully Completed.");
	parent.resultFrame.location.reload();
}
async function ViewTransDetails(obj){

	var Patient_id = obj.getAttribute('patient_id');
	var Episode_id = obj.getAttribute('episode_id');
	var Visit_id = obj.getAttribute('visit_id');
	var doc_num = obj.getAttribute('doc_num');
	var trans_type = "ECLREQ";
	var bill_doc_code = obj.getAttribute('bill_doc_code');
	dialogHeight = "35vh";    // have to remove 
	dialogWidth  = "55vw";
	dialogTop    = "50";	
	
	var title="Previous Transaction Details ";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:yes" ;

	// we need to send required values which is need to be compared from existing and responseMsg
	if(Patient_id != null && Patient_id != "" && Patient_id != " ")
	{
		var arguments = new Array();
		var url = "../../eXH/jsp/MediClaimsTransDetailsPopup.jsp?Patient_id="+Patient_id+"&Episode_id="+Episode_id+"&Visit_id="+Visit_id+"&doc_num="+doc_num+"&bill_doc_code="+bill_doc_code+"&trans_type="+trans_type;
		await window.showModalDialog(url,arguments,features);
	}
	else
	{
		alert("APP-XH0070 Response is not available");
	}
}
function ValidateTransaction(dataElements)
{
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'POST',
		cache: false,
		
		data: {
				callType: 'ECLAIMVAL',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},		
		dataType: 'text',
		async: false
	});
	
	return responseMsg;

} 

function EClaimsTransaction(dataElements)
{
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'POST',
		cache: false,
		
		data: {
				callType: 'ECLAIMSBATCH',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},		
		dataType: 'text',
		async: false
	});
	
	return responseMsg;

} 

function ParseCheckResponse(responseMsg){

	var responseData = "";
	var existingData = "";
	responseData = responseMsg.split("$!^");
    
	if (responseData.length > 0)
	{
		document.forms[0].transID.value = responseData[1];
	}

	if(responseData[0] == "E")
	{
		alert("APP-XH0070 "+responseData[3]);
	}
	if(responseData[0] == "S")
	{
		DetailsPopUp(responseData[1]);
	}

	//parent.resultFrame.location.reload();

}

async function DetailsPopUp(transID)
{
    var dialogHeight = "40vh";    // have to remove 
	var dialogWidth  = "65vw";
	var dialogTop    = "120";
	var title="Patient EClaims Response ";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:yes" ;

	// we need to send required values which is need to be compared from existing and responseMsg
	if(transID != null && transID != "" && transID != " ")
    {
		var arguments = new Array();
		arguments[0]=transID;
		var url = "../../eXH/jsp/MediQueryResponsePopUp.jsp?trans_num="+transID;
		var retVal = await window.showModalDialog(url,arguments,features);
	}
	else
	{
		alert("APP-XH0070 Response is not available");
	}
}

function FetchResponse(){
	
	//DetailsPopUp("55");
	//return;

	var checkedValue = ""; 
	var checkBoxes = document.getElementsByName('checkbox');
	
	for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
		}
	}
	
	checkedValue = document.forms[0].dataElements.value;

	checkedValue = checkedValue.replace("ECLREQ","ECLRES");

	var transid = document.forms[0].transID.value;

	checkedValue = checkedValue.replace("<TRANS_ID>XXX","<TRANS_ID>"+transid);

	responseMessage = EClaimsTransaction(checkedValue);	
	//ParseCheckResponse(responseMessage);
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
function CheckAll()
{
	if (parent.patientClaimsArray.length>0)
	{
		var confirmFlag = confirm(" All the selected/de-selected bill numbers selection/de-selection will be lost, Click OK to continue or Cancel to return");
		if (!(confirmFlag)) {
			if(document.getElementById('allCheck').checked==true)			
				document.getElementById('allCheck').checked= false;
			else
				document.getElementById('allCheck').checked= true;

			return;
		}
	}

	var checkBoxes = document.getElementsByName('checkbox');
	if(document.getElementById('allCheck').checked==true)
	{
		for(var i = 0; i < checkBoxes.length; i++)
		{
			checkBoxes[i].checked=true;
	    } 
	}
	else
	{
		for(var i = 0; i < checkBoxes.length; i++)
		{
			checkBoxes[i].checked=false;
	    } 
	}

	var qry = document.getElementById("batchqry").value;

	var batchres=EClaimsBatchRecords(qry);

	batchres = batchres.replace("[", "");
	batchres = batchres.replace("]", "");

	parent.patientClaimsArray = new Array();

	var billObj = new Object();
	var billArray = new Array();
	var billDetailsArray = new Array();

	billArray = batchres.split(",");

	if (billArray.length>0)
	{
		for (var j=0; j<billArray.length; j++)
		{
			billDetailsArray = new Array();
			billObj = new Object();
			billDetailsArray = billArray[j].split("**");

			if (billDetailsArray.length>0)
			{
				billObj.doc_type_code = billDetailsArray[0];
				billObj.doc_num = billDetailsArray[1];
				billObj.checked_value = billDetailsArray[2];
				if(document.getElementById('allCheck').checked==true)
				{
					billObj.selected_value = "Y";
				}
				else
				{
					billObj.selected_value = "N";
				}


				parent.patientClaimsArray.push(billObj);
			}

		}

	}

	//parent.patientClaimsArray = batchres.split(",");
}
function toggle(doc_num)
{
	 if( document.getElementById("hidethis"+doc_num).style.display=='none' ){
	   document.getElementById("hidethis"+doc_num).style.display = 'table'; // set to table-row instead of an empty string
	 }else{
	   document.getElementById("hidethis"+doc_num).style.display = 'none';
	 }
}

function EClaimsBatchRecords(dataElements)
{
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'POST',
		cache: false,
		
		data: {
				callType: 'ECLAIMSBATCHREC',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},		
		dataType: 'text',
		async: false
	});
	
	return responseMsg;
} 

function setPatientClaimsArray(obj, index)
{
	var docTypeCode = document.getElementById("doctypecode"+index).value;
	var docNo = document.getElementById("docno"+index).value;
	var checkedValue = document.getElementById("secChk"+index).value;

	var i = -1;
	var arrayIndex = -1;

	var billObj = new Object();
	var selectedCount = 0;
	
	if (parent.patientClaimsArray.length>0)
	{
		for (i=0; i<parent.patientClaimsArray.length; i++)
		{	
			
			var arrDocTYpeCode = parent.patientClaimsArray[i].doc_type_code;
			var arrDocNum = parent.patientClaimsArray[i].doc_num;

			arrDocTYpeCode = trimString(arrDocTYpeCode);

			arrDocNum = trimString(arrDocNum);

			if (arrDocTYpeCode == docTypeCode)
			{
				if (arrDocNum == docNo)
				{
					arrayIndex = i;
					break;
				}
			}
		}
		
	}
		
	if (obj.checked)
	{
		if (parent.patientClaimsArray.length>0)
		{
			
			if ( arrayIndex != -1)
			{
				parent.patientClaimsArray[arrayIndex].selected_value = "Y";
			}
			/*
			else
			{
				billObj = new Object();

				billObj.doc_type_code = docTypeCode;
				billObj.doc_num = docNo;
				billObj.checked_value = checkedValue;
				billObj.selected_value = "Y";

				parent.patientClaimsArray.push(billObj);
			}
			*/
		}
		else
		{
			parent.patientClaimsArray = new Array();
			billObj = new Object();

			billObj.doc_type_code = docTypeCode;
			billObj.doc_num = docNo;
			billObj.checked_value = checkedValue;
			billObj.selected_value = "Y";

			parent.patientClaimsArray.push(billObj);
			
		}
	}
	

	if (!(obj.checked))
	{	
		if (parent.patientClaimsArray.length>0)
		{
			if ( arrayIndex != -1)
			{
				parent.patientClaimsArray[arrayIndex].selected_value = "N";
			}
		}
		document.getElementById('allCheck').checked = false;
	}

	var checkBoxes = document.getElementsByName('checkbox');

	for(var i = 0; i < checkBoxes.length; i++)
	{
		docNo = ""; docTypeCode = "";
		docNo = document.getElementById("docno"+i).value;
		docTypeCode = document.getElementById("doctypecode"+i).value;

		for (var j=0; j<parent.patientClaimsArray.length; j++)
		{

			var arrDocTYpeCode = parent.patientClaimsArray[j].doc_type_code;
			var arrDocNum = parent.patientClaimsArray[j].doc_num;
			var arrDocSel = parent.patientClaimsArray[j].selected_value;

			arrDocTYpeCode = trimString(arrDocTYpeCode);
			arrDocNum = trimString(arrDocNum);

			if (arrDocTYpeCode == docTypeCode)
			{
				if (arrDocNum == docNo)
				{
					if (arrDocSel == "Y")
					{							
						selectedCount = selectedCount + 1;
						break;
					}
				}
			}
		} 	
	}

	var rowCountValue = document.getElementById("arrRowSize").value;

	if (selectedCount == rowCountValue)
		document.getElementById('allCheck').checked= true;
	else
		document.getElementById('allCheck').checked= false;
	
}

//function selectBillNo()
$(document).ready(function() 
{
	var rowCountValue = document.getElementById("arrRowSize").value;

	var docTypeCode = "";
	var docNo = "";
	var checkBoxes = document.getElementsByName('checkbox');

	var qry = document.getElementById("batchqry").value;
	var batchres = "";

	var selectedCount = 0;

	if (!(parent.patientClaimsArray.length>0))
	{
		batchres=EClaimsBatchRecords(qry);

		batchres = batchres.replace("[", "");
		batchres = batchres.replace("]", "");

		parent.patientClaimsArray = new Array();

		var billObj = new Object();
		var billArray = new Array();
		var billDetailsArray = new Array();

		billArray = batchres.split(",");

		if (billArray.length>0)
		{
			for (var j=0; j<billArray.length; j++)
			{
				billDetailsArray = new Array();
				billObj = new Object();
				billDetailsArray = billArray[j].split("**");
				
				if (billDetailsArray.length>0)
				{
					billObj.doc_type_code = billDetailsArray[0];
					billObj.doc_num = billDetailsArray[1];
					billObj.checked_value = billDetailsArray[2];
					billObj.selected_value = "N";

					parent.patientClaimsArray.push(billObj);
				}
			}
		}
	}


	if (parent.patientClaimsArray.length>0)
	{
		for(var i = 0; i < checkBoxes.length; i++)
		{
			docNo = ""; docTypeCode = "";
			docNo = document.getElementById("docno"+i).value;
			docTypeCode = document.getElementById("doctypecode"+i).value;

			for (var j=0; j<parent.patientClaimsArray.length; j++)
			{

				var arrDocTYpeCode = parent.patientClaimsArray[j].doc_type_code;
				var arrDocNum = parent.patientClaimsArray[j].doc_num;
				var arrDocSel = parent.patientClaimsArray[j].selected_value;
				

				arrDocTYpeCode = trimString(arrDocTYpeCode);
				arrDocNum = trimString(arrDocNum);

				if (arrDocTYpeCode == docTypeCode)
				{
					if (arrDocNum == docNo)
					{
						if (arrDocSel == "Y")
						{							
							selectedCount = selectedCount + 1;
							document.getElementById("secChk"+i).checked = true;
							break;
						}
					}
				}
			} 	
		}		
		
		if (selectedCount == rowCountValue)
			document.getElementById('allCheck').checked= true;
		else
			document.getElementById('allCheck').checked= false;

	}
	
});

function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(startPos, endPos + 1);

    return outString;
}



</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >
<form name="PAYER_CHECK_BATCH_FORM" id="PAYER_CHECK_BATCH_FORM" method="POST" action=''  >
<%
	String order = "";
	String orderBy = "";
	String action_type=null;
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null ;
    ArrayList group= new ArrayList();

	String rs_patient_id ="",rs_first_name = "", rs_family_name = "", rs_sex = "", rs_episode_id = "", rs_encounter_id = "", rs_patient_class = ""; 
	String rs_visit_adm_date_time="",rs_visit_adm_type = "", rs_service_code = "", rs_discharge_date_time = "", rs_operating_facility_id = "", rs_doc_type_code = "" ; 
	String rs_doc_num = "", rs_doc_date = "", rs_bill_from_date = "", rs_bill_to_date = "", rs_visit_id = "", rs_cust_code = "", rs_blng_grp_id = "", rs_cust_name = "",  rs_bill_amount = "", rs_settleInd = "", rs_billGrpId = "", l_where_values = "", rs_visit_date = "", l_app_msg = "";

	String rs_credit_auth_ref = "", rs_credit_auth_date = "", rs_membership_num_sap = "", rs_dependant_num_sap = "", rs_dependant_relation_sap = "", rs_wca_number_sap = "",rs_membership_surname = "",rs_membership_initial = "";

	String rs_claim_type = "";

	String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "" ;
	String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="", rs_patient_idnum = "";

	String l_event_trans_query = "",l_event_trans_type = "", l_case_trans_no = "",l_approval_trans_status = "",l_approval_trans_status_desc = "";
	String l_rev_event_type = "", l_rev_case_no = "",l_rev_approval_status = "",l_rev_claim_no = "";
	String l_episode_type = "";
	String checkboxvalue = "";
	String l_item_line_query = "";
	HttpSession httpSession = request.getSession(false);
	int l_rev_srl_no = 0;

	String loginfacility = (String) session.getValue("facility_id");
	String user_id	= (String)session.getValue("login_user") ;
	Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
	String AddedAtWsNo     =  p.getProperty("client_ip_address");

	int billDetailsRowCount = 0;

    String patient_group_flag = "" , episode_group_flag = "",currentSubGroup ="",prevSubGroup ="",emptySubGroup="";
	String billing_group = XHDBAdapter.checkNull(request.getParameter("billing_group"));
    String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
	String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
	String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
	String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
	String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));

	String admission_from_dt = XHDBAdapter.checkNull(request.getParameter("adm_from_dt"));

	//String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

    String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));


    String val_func = (XHUtil.singleParamExeQry("SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG where  ELEMENT_ID = 'VAL_FUNCTION' and SEGMENT_ID = 'ECL'"));


	if(admission_from_dt!="" && admission_from_dt!=null)
	{
	   admission_from_dt = admission_from_dt+ " 00:00:00";
	}

	String admission_to_dt = XHDBAdapter.checkNull(request.getParameter("adm_to_dt"));
	if(admission_to_dt!="" && admission_to_dt!=null)
	{
	   admission_to_dt =admission_to_dt + " 23:59:59";
	}
     String bill_from = XHDBAdapter.checkNull(request.getParameter("bill_from"));
	String bill_to = XHDBAdapter.checkNull(request.getParameter("bill_to"));

	//String patient_class_orderby = XHDBAdapter.checkNull(request.getParameter("patient_class_orderby"));
	//String eligibility_action_type = XHDBAdapter.checkNull(request.getParameter("eligibility_action_type"));
	String event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));
	String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));
    
	//String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));


	String dest_code = "";
    String Checkboxname = "";
	System.out.println("MeditMembershipBatchResult.jsp:::isDebugYN....."+isDebugYN);

	if(isDebugYN.equals("Y")){
	System.out.println("MeditMembershipBatchResult.jsp:::customer_id....."+customer_id);
	System.out.println("MeditMembershipBatchResult.jsp:::patient_id....."+patient_id);
	System.out.println("MeditMembershipBatchResult.jsp:::admission_from_dt....."+admission_from_dt+" admission_to_dt :::: "+admission_to_dt );
	System.out.println("MeditMembershipBatchResult.jsp:::bill_from....."+bill_from+" bill_to :::: "+bill_to );
	System.out.println("MeditMembershipBatchResult.jsp:: event_type ::: "+event_type);
	System.out.println("MeditMembershipBatchResult.jsp:: eligibility_status_type ::: "+eligibility_status_type);
	System.out.println("MeditMembershipBatchResult.jsp:: val_func ::: "+val_func);

    }
	/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

	boolean  boolToggle = true;
	String strTDClass = "";
	String whereClause = "";
	int totalRecords=0;

	Connection dbConn = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	ResultSet rsevent=null;
	ResultSet rsdest=null;
	String l_event_query = "", l_cla_image_str = "", l_rev_image_str = "", l_eoc_image_str = "", l_event_type = "", l_image_str = "", query = "",l_img_vw_dtl_str = "";

	int l_claims_count = 0, l_reversal_count = 0, l_eoc_count = 0;
	int l_srl_no = 0 , l_srl_trans_no = 0;

	String l_case_no = "",l_trans_ref_no = "0", l_approval_status = "", l_claim_no = "", l_approval_status_desc = "";

	String l_rej_image_str = "";

	String trans_type = XHDBAdapter.checkNull(request.getParameter("trans_type"));
	String event_type_trans = XHDBAdapter.checkNull(request.getParameter("event_type"));

	try
	{ 
		conn = ConnectionManager.getConnection(request);

		whereClause = " ";
		int where_flag = 0;

		// For LMP5038-SCF-0232 - Condition 99 added CLA and CLE
        if(trans_type.equals("ECL") && (event_type_trans.equals("CLA"))){
			whereClause =" where (EVENT_TYPE is null or (EVENT_TYPE in( 'CLA','CLE') and APPROVAL_STATUS in('R','F','99')) or (EVENT_TYPE = 'REV' and APPROVAL_STATUS = 'A') and EVENT_TYPE != 'EOC')";
		}
		// For LMP5038-SCF-0232 - Condition 99 removed from CLA & CLE  - Condition 99 added in REV
		if(trans_type.equals("ECL") && event_type_trans.equals("REV")){
			whereClause =" where ((EVENT_TYPE in ( 'CLA','CLE') and APPROVAL_STATUS in('A','P','W')) or (EVENT_TYPE = 'EOC') or (EVENT_TYPE = 'REV' and APPROVAL_STATUS in ('R','F','99')))";
		}
		// For LMP5038-SCF-0232 - Condition 99 removed from CLA & REV - Condition 99 added in EOC.
		if(trans_type.equals("ECL") && event_type_trans.equals("EOC")){
			whereClause =" where ((EVENT_TYPE = 'CLA')  and APPROVAL_STATUS in ('A','P','W') ) or (EVENT_TYPE = 'REV' and APPROVAL_STATUS not in ('P','A')) or (EVENT_TYPE = 'EOC' and APPROVAL_STATUS in ('R','F','99')) and (EVENT_TYPE != 'CLE')";
		}
		// For LMP5038-SCF-0232 - Condition 99 added from CLA & CLE 
		if(trans_type.equals("ECL") && event_type_trans.equals("CLE")){
			whereClause =" where (EVENT_TYPE is null or (EVENT_TYPE in('CLA','CLE') and APPROVAL_STATUS in('R','F','99')) or (EVENT_TYPE = 'REV' and APPROVAL_STATUS = 'A') and (EVENT_TYPE != 'EOC'))";
		}
		if(patient_id != null && patient_id != "" && patient_id != " ")
		{
			 whereClause = whereClause + "  and PATIENT_ID =  '#patient_id' ";
		}

		if(billing_group != null && billing_group != "" && billing_group != " ")
		{
			whereClause = whereClause + " and BLNG_GRP_ID = '#billing_group' ";

		}

		if(customer_group != null && customer_group != "" && customer_group != " ")
		{
			whereClause = whereClause + " and CUST_GRP_CODE = '#customer_group' ";

		}

		if(customer_id != null && customer_id != "" && customer_id != " ")
		{
			whereClause = whereClause + " and CUST_CODE = '#customer_id' ";

		}

		if(episode_id != null && episode_id != "" && episode_id != " ")
		{
			whereClause = whereClause + " and episode_id=  '#episode_id' ";

		}
		if(admission_from_dt!="" && admission_from_dt!=null && admission_to_dt!="" && admission_to_dt!=null){
				
		    whereClause = whereClause + " and TO_Date(VISIT_ADM_DATE_TIME,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+admission_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+admission_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";

		}
		if(bill_from!="" && bill_from!=null && bill_to!="" && bill_to!=null){
				
		    whereClause = whereClause + " and DOC_NUM BETWEEN '#bill_from' AND '#bill_to' ";

		}

		whereClause = whereClause + " order by PATIENT_ID, PATIENT_NAME, SEX, EPISODE_ID, VISIT_ADM_DATE_TIME ";
		/*if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " ")
		{
			if(where_flag>0)whereClause = whereClause + " AND APPROVAL_STATUS =  NVL('#eligibility_status_type',APPROVAL_STATUS)";
			else whereClause = whereClause + " APPROVAL_STATUS =  NVL('#eligibility_status_type',APPROVAL_STATUS)";
			where_flag=where_flag+1;

		}
		*/
        currentSubGroup = patient_group_flag +""+episode_group_flag;
		request.setAttribute(XHQueryRender.strQueryId,"MEDICLAIMSBATCHPROCESS");
		
		if(isDebugYN.equals("Y")){
			System.out.println("whereClause....."+whereClause);
		}
		request.setAttribute(XHQueryRender.col,"39"); 
		request.setAttribute(XHQueryRender.maxRec,"10");
		request.setAttribute(XHQueryRender.whereClause,whereClause);
		HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
		String sqlQuery= XHQueryRender.sqlQuery;	
		if(isDebugYN.equals("Y"))
			System.out.println("sqlQuery... "+sqlQuery);

		ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
		
		ArrayList arrCol = null;
		boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
		boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
		//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
		//if(isDebugYN)System.out.println("boolNext...."+boolNext);
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
		%> 
		<input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>		     
		<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id %> >			
		<input type='hidden' name='patient_class_episode' id='patient_class_episode' value=<%=patient_class_episode%>>
		<input type='hidden' name='episode_id' id='episode_id' value=<%=episode_id %>>
		<input type='hidden' name='episode_type' id='episode_type' value=<%=episode_type %>>
		<input type='hidden' name='admission_from_dt' id='admission_from_dt' value=<%=admission_from_dt %>>
		<input type='hidden' name='admission_to_dt' id='admission_to_dt' value=<%=admission_to_dt %>>
		<input type='hidden' name='val_func' id='val_func' value='<%=val_func%>'>		     
				
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
		<input type='hidden' name='transID' id='transID' value="">
		<input type='hidden' name='dataElements' id='dataElements' value="">

		<%

		if(arrRow.size()==0)
		{
		%>	
			<script>
				alert('APP-002415 Query caused no records to be retrieved');
				history.go(-1);
				parent.resultFrame.location.href='../../eCommon/html/blank.html';
			</script>
																						
		<%
		}
		else
		{
		%> 		
		<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
		<tr>
			<td colspan="27" class="COLUMNHEADER" align='center'>EClaims Transactions</td>
		</tr>
		<tr>	   
			<td align="right" class="CAGROUP" width="80%" >
				<input class='BUTTON' type="button"  ID="search" name=search value='Eclaims Trx' onClick="EclaimsTrx('<%=event_type%>')">	
				<!--<input class='BUTTON' type="button"  ID="search" name=search value='Reversal Trx' onClick="EclaimsTrx('REV')">			
				<input class='BUTTON' type="button"  ID="search" name=search value='EOC Trx' onClick="EclaimsTrx('EOC')">
				-->
			</td>
			<td align="right" class="CAGROUP" width="20%" >
				<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
				<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
			</td>
		</tr>
		</table>

		<div id="left_child" class="left_child">
		<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' border=1 align=center>	
			<tr>
				
				<td class='COLUMNHEADER' width='10%'>
					<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
				</td>

				<td class='COLUMNHEADER' width='25%'>
					<font color=white><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></font>
				</td>
				<td class='COLUMNHEADER' width='10%'>
					<font color=white><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></font>
				</td>
				<td class='COLUMNHEADER' width='15%'>
					<font color=white ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></font>
				</td>
				<td class='COLUMNHEADER' width='15%'>
					<font color=white><fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></font>
				</td>	
				<td class='COLUMNHEADER' width='25%'>
					<font color=white><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></font>
				</td>	
			</tr>
			<!--  ---->
			<tr>
				<td colspan = "7">
					<table  cellspacing="0" cellpadding="3" width="100%" border="1" align="center" style="height:10px;overflow-y:scroll;">
						<tr>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%' align="center">
								<font color=white>Select ALL</font><input type='checkbox' id='allCheck' name='allCheck' id='allCheck' value='allCheck' onClick='CheckAll()'>	
							</td>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%'>
								<font color=white><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
								<font color=white><fmt:message key="eBL.BILL_DOC_TYPE.label" bundle="${bl_labels}"/></font>
							</td>							
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white><fmt:message key="eBL.billfromdate.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white ><fmt:message key="eBL.billtodate.label" bundle="${bl_labels}"/></font>
							</td>	
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white><fmt:message key="eBL.BILL_DATE.label" bundle="${bl_labels}"/></font>
							</td>		
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
								<font color=white ><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></font>
							</td>	
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='8%'>
								<font color=white ><fmt:message key="Common.Event.label" bundle="${common_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/></font>
							</td>	
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='8%'>
								<font color=white ><fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="Common.History.label" bundle="${common_labels}"/></font>
							</td>	
						</tr>
					</table>
				</td>
			</tr>
			<!--  ---->
			<%
			Map cmp = new HashMap();

			totalRecords=0;

			billDetailsRowCount = arrRow.size();
			int j = 0;
            String hideTable = "style='display:none;'";

			dbConn = ConnectionManager.getConnection();

			for (j=0; j<arrRow.size();j++)
			{
				l_image_str = "";
				arrCol = (ArrayList)arrRow.get(j);
				rs_patient_id = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);				
				rs_first_name = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
				rs_family_name = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
				rs_sex = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
				rs_episode_id= arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
				rs_encounter_id = arrCol.get(5).equals("null")?"":(String)arrCol.get(5);
				rs_patient_class= arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
				rs_visit_adm_date_time = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
				rs_visit_adm_type = arrCol.get(8).equals("null")?"":(String)arrCol.get(8);				
				rs_service_code = arrCol.get(9).equals("null")?"":(String)arrCol.get(9);
				rs_discharge_date_time = arrCol.get(10).equals("null")?"":(String)arrCol.get(10);
				rs_operating_facility_id= arrCol.get(11).equals("null")?"":(String)arrCol.get(11);

				rs_doc_type_code= arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
				rs_doc_num = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
				rs_doc_date = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
				rs_bill_from_date= arrCol.get(15).equals("null")?"":(String)arrCol.get(15);				
				rs_bill_to_date = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
				rs_visit_id = arrCol.get(17).equals("null")?"":(String)arrCol.get(17);
				rs_cust_code= arrCol.get(18).equals("null")?"":(String)arrCol.get(18);
				rs_blng_grp_id= arrCol.get(19).equals("null")?"":(String)arrCol.get(19);

				rs_credit_auth_ref = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
				rs_credit_auth_date= arrCol.get(21).equals("null")?"":(String)arrCol.get(21);				
				rs_membership_num_sap = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
				rs_dependant_num_sap = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
				rs_dependant_relation_sap= arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
				rs_wca_number_sap= arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
				//rs_destCode = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
				rs_cust_name = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);
				rs_bill_amount = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
				rs_patient_idnum = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
				rs_membership_surname = arrCol.get(35).equals("null")?"":(String)arrCol.get(35);
				rs_membership_initial = arrCol.get(36).equals("null")?"":(String)arrCol.get(36);
				rs_settleInd = arrCol.get(37).equals("null")?"":(String)arrCol.get(37);
				rs_visit_date = arrCol.get(38).equals("null")?"":(String)arrCol.get(38);

				if (rs_patient_class.equals("OP")) {
					l_episode_type = "O";
				}
				if (rs_patient_class.equals("EM")) {
					l_episode_type = "E";
				}
				if (rs_patient_class.equals("IP")) {
					l_episode_type = "I";
				}
				if (rs_patient_class.equals("DC")) {
					l_episode_type = "D";
				}
				if (rs_patient_class.equals("")) {
					l_episode_type = "X";
				}

				if (rs_settleInd.equals("X") || rs_settleInd.equals("R"))
				{	
					l_app_msg = " ::: Inside BL_CUST_DEST_MST ::: ";
					if(isDebugYN.equals("Y"))
						System.out.println(l_app_msg);	

					query = "select DESTINATION_CODE_SAP, CLAIM_TYPE from BL_CUST_DEST_MST a, pr_encounter b"
								+" where "
								+"	 B.PATIENT_ID = ? and B.EPISODE_ID = ? and  CUST_CODE = ? and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

					l_where_values = rs_cust_code;

				}
				else if (rs_settleInd.equals("C"))
				{
					l_app_msg = " ::: Inside BL_BLNG_GRP_DEST_MST ::: ";
					if(isDebugYN.equals("Y"))
					System.out.println(l_app_msg);	

					query = "select DESTINATION_CODE_SAP, CLAIM_TYPE from BL_BLNG_GRP_DEST_MST a, pr_encounter b"
								+" where "
								+"	 B.PATIENT_ID = ? and B.EPISODE_ID = ? and  BLNG_GRP_ID = ? and  trunc(VISIT_ADM_DATE_TIME) between EFF_FROM_DATE and NVL(EFF_TO_DATE, SYSDATE) ";

					l_where_values = rs_blng_grp_id;
				}

				l_app_msg = " ::: Inside GETDESTINATIONCODE Query ::: "+query+ " ::: RS_PATIENT_ID ::: "+rs_patient_id+ " ::: RS_EPISODE_ID ::: "+rs_episode_id+ " ::: L_WHERE_VALUES ::: "+l_where_values;
				
				
				pstmt = dbConn.prepareStatement(query);
				pstmt.setString(1, rs_patient_id);
				pstmt.setString(2, rs_episode_id);
				pstmt.setString(3, l_where_values);
				rsdest = pstmt.executeQuery();
				while(rsdest.next())
				{
				   rs_destCode = rsdest.getString("DESTINATION_CODE_SAP");
				   rs_claim_type = rsdest.getString("CLAIM_TYPE");
				}

				l_app_msg = " ::: Inside RS_DESTCODE ::: "+rs_destCode+" ::: RS_CLAIM_TYPE ::: "+rs_claim_type;
				
				/*
				l_event_query = "select  facility_id, doc_type_code, doc_num, "
								+" NVL(SUM(DECODE(event_type, 'CLA', 1)),0) CLAIMS , "
								+" NVL(SUM(DECODE(event_type, 'REV', 1)),0) REVERSAL, "
								+" NVL(SUM(DECODE(event_type, 'EOC', 1)),0) EOC  "
								+" from xf_eclaims_trx_hdr where FACILITY_ID = ? and PATIENT_ID =  ? and EPISODE_ID = ? and VISIT_ID = ? "
								+" and doc_type_code = ? and doc_num = ? and event_type in ('CLA', 'REV', 'EOC') "
								+" group by facility_id, doc_type_code, doc_num";
				*/


				l_event_type = "";l_srl_no = 0; l_case_no = ""; l_approval_status = ""; l_claim_no = ""; l_approval_status_desc = "";

				// For LMP5038-SCF-0232 - Condition 99 removed in APPROVAL_STATUS in('P','W','A','99')

				l_event_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, a.trans_type, a.event_type, SRL_NO, CASE_NUM, CLAIM_NUM, APPROVAL_STATUS, 						B.STATUS_DESC "
								+"  from xf_eclaims_trx_hdr a, XH_TRANS_STATUS b "
								+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
								+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
								+"							and DOC_TYPE_CODE = ? and DOC_NUM = ? and APPROVAL_STATUS in('P','W','A'))"  
								+"			AND  A.APPROVAL_STATUS = B.STATUS_CODE(+) AND B.TRANS_EVENT = 'ECL' AND B.TRANS_TYPE = A.EVENT_TYPE ";

				//System.out.println("l_event_query...."+l_event_query);

				pstmt = dbConn.prepareStatement(l_event_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_patient_id);
				pstmt.setString(3, rs_episode_id);
				pstmt.setString(4, rs_visit_id);
				pstmt.setString(5, rs_doc_type_code);
				pstmt.setInt(6, Integer.parseInt(rs_doc_num));

				rsevent = pstmt.executeQuery();

				while(rsevent.next())
				{
				   l_event_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE"); 
				   l_srl_no =  rsevent.getInt("SRL_NO");
				   l_case_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
				   l_approval_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
				   l_claim_no = rsevent.getString("CLAIM_NUM")==null?"":rsevent.getString("CLAIM_NUM"); 
				   l_approval_status_desc = rsevent.getString("STATUS_DESC")==null?"":rsevent.getString("STATUS_DESC");
				}
				l_trans_ref_no = String.valueOf(l_srl_no);

				if(isDebugYN.equals("Y"))						//System.out.println("l_event_type...."+l_event_type+"..l_srl_no.."+l_srl_no+"..l_case_no.."+l_case_no+"..l_approval_status.."+l_approval_status+"..l_claim_no.."+l_claim_no+"..l_trans_ref_no.."+l_trans_ref_no);				

				rs = null;				

				l_event_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, "
										+"  nvl(APPROVAL_STATUS,'N') APPROVAL_STATUS "
										+"  from xf_eclaims_trx_hdr "
										+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
										+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
										+"								and DOC_TYPE_CODE = ? and DOC_NUM = ?) ";
										

				pstmt = dbConn.prepareStatement(l_event_trans_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_patient_id);
				pstmt.setString(3, rs_episode_id);
				pstmt.setString(4, rs_visit_id);
				pstmt.setString(5, rs_doc_type_code);
				pstmt.setInt(6, Integer.parseInt(rs_doc_num));

				rsevent = pstmt.executeQuery();

                l_event_trans_type = ""; l_srl_trans_no = 0; l_case_trans_no = ""; l_approval_trans_status ="";

				while(rsevent.next())
				{
				   l_event_trans_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE");  
				   l_srl_trans_no = rsevent.getInt("SRL_NO");
				   l_case_trans_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
				   l_approval_trans_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
				}
				
				if (!(l_event_type.length()>0))
				{
					l_event_type = l_event_trans_type;
					l_srl_no = l_srl_trans_no;
					l_approval_status = l_approval_trans_status; 
					l_claim_no = l_case_trans_no;
				}


				String l_status_code = "N", l_status_type = "CLA", l_trans_event = "ECL";

				if (l_event_trans_type.equals("CLA"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "CLA";
					}
					*/
					
					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}

					if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
					{
						l_status_code = l_approval_trans_status;
						l_status_type = "CLA";
						l_trans_event = "ERA";
					}
				}

				if (l_event_trans_type.equals("REV"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "CLA";
					}
					*/

					if (l_approval_trans_status.equals("A"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}
				}

				if (l_event_trans_type.equals("EOC"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "EOC";
					}
					*/

					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P"))
					{
						l_status_code = "P";
						l_status_type = "EOC";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "P";
						l_status_type = "CLA";
					}
				}

				if (l_event_trans_type.equals("CLE"))
				{
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") added
					if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F") || l_approval_trans_status.equals("99"))
					{
						l_status_code = "N";
						l_status_type = "CLA";
					}
					
					// For LMP5038-SCF-0232 - Condition l_approval_trans_status.equals("99") commented
					/*
					if (l_approval_trans_status.equals("99"))
					{
						l_status_code = "S";
						l_status_type = "EOC";
					}
					*/
					
					if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
					{
						l_status_code = "P";
						l_status_type = "EOC";
					}

					if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
					{
						l_status_code = l_approval_trans_status;
						l_status_type = "CLA";
						l_trans_event = "ERA";
					}
				}

				rsevent = null;
				
				String l_status_query = "";

				l_status_query = "Select STATUS_DESC from  XH_TRANS_STATUS "										
										+"	where TRANS_EVENT = ? AND TRANS_TYPE = ? AND STATUS_CODE = ? ";
										
				pstmt = dbConn.prepareStatement(l_status_query);
				pstmt.setString(1, l_trans_event);
				pstmt.setString(2, l_status_type);
				pstmt.setString(3, l_status_code);				

				rsevent = pstmt.executeQuery();

				l_approval_status_desc ="";

				while(rsevent.next())
				{				   
				   l_approval_status_desc = rsevent.getString("STATUS_DESC")==null?"":rsevent.getString("STATUS_DESC"); 
				}            
              
				rs = null;

				/*

				l_item_line_query = "Select a.operating_facility_id, a.PATIENT_ID, a.EPISODE_ID, a.EPISODE_TYPE, a.VISIT_ID, NULL CLINICIAN, "
									+"			c.BILL_DOC_TYPE_CODE, c.BILL_DOC_NUM, rownum, "
									+"			c.SERV_QTY, c.BLNG_SERV_CODE, d.long_desc, c.SERV_ITEM_CODE, c.SERV_ITEM_DESC,TO_CHAR (c.SERVICE_DATE,'DD/MM/YYYY hh24:mi:ss') SERVICE_DATE, "
									+"			TO_CHAR (c.org_gross_charge_amt, 9999990.99) org_gross_charge_amt,TO_CHAR (c.org_disc_amt, 9999990.99) org_disc_amt,TO_CHAR (c.org_net_charge_amt, 9999990.99) org_net_charge_amt,TO_CHAR (c.ADJ_GROSS_CHARGE_AMT, 9999990.99) ADJ_GROSS_CHARGE_AMT,TO_CHAR (c.ADJ_DISC_AMT, 9999990.99) ADJ_DISC_AMT,TO_CHAR (c.ADJ_NET_CHARGE_AMT, 9999990.99) ADJ_NET_CHARGE_AMT, "
									+"			c.TRX_DOC_REF, c.TRX_DOC_REF_LINE_NUM, c.TRX_DOC_REF_SEQ_NUM, TO_CHAR (c.BASE_CHARGE_AMT, 9999990.99) BASE_CHARGE_AMT, c.TRX_DATE, NULL UPFS_CODE "
									+"	from       bl_bill_hdr a, bl_patient_charges_folio c, bl_blng_serv d "
									+"	 WHERE a.operating_facility_id = c.operating_facility_id "
									+"			AND a.doc_type_code = c.bill_doc_type_code "
									+"			AND a.doc_num = c.bill_doc_num "
									+"			AND a.patient_id = c.patient_id "
									+"			AND a.episode_id = c.episode_id "
									+"			AND a.episode_type = c.episode_type "
									+" 			AND c.blng_serv_code = d.blng_serv_code "
									+"			AND c.trx_status IS NULL "
									+"			and a.operating_facility_id = ? "
									+"			and c.BILL_DOC_TYPE_CODE = ? "
									+"			and c.BILL_DOC_NUM = ? ";	

				*/
									
				l_item_line_query = "Select operating_facility_id, PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, NULL CLINICIAN, BILL_DOC_TYPE_CODE, "
									+"	BILL_DOC_NUM, rownum, SERV_QTY, BLNG_SERV_CODE, SERV_DESC, SERV_ITEM_CODE, SERV_ITEM_DESC, "
									+"	TO_CHAR (SERVICE_DATE,'DD/MM/YYYY hh24:mi:ss') SERVICE_DATE, "			
									+"	TO_CHAR (org_gross_charge_amt, 9999990.99) org_gross_charge_amt, "
									+"	TO_CHAR (org_disc_amt, 9999990.99) org_disc_amt, "
									+"	TO_CHAR (org_net_charge_amt, 9999990.99) org_net_charge_amt, "
									+"	TO_CHAR (ADJ_GROSS_CHARGE_AMT, 9999990.99) ADJ_GROSS_CHARGE_AMT, "
									+"	TO_CHAR (ADJ_DISC_AMT, 9999990.99) ADJ_DISC_AMT, "
									+"	TO_CHAR (ADJ_NET_CHARGE_AMT, 9999990.99) ADJ_NET_CHARGE_AMT, 	"		
									+"	TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, TRX_DOC_REF_SEQ_NUM, "
									+"	TO_CHAR (BASE_CHARGE_AMT, 9999990.99) BASE_CHARGE_AMT, TRX_DATE, NULL UPFS_CODE "
									+"	from   XF_ECLAIMS_BILL_DETAILS_VW "
									+" WHERE  operating_facility_id = ? 	"		
									+"		and BILL_DOC_TYPE_CODE = ? 		"	
									+"		and BILL_DOC_NUM = ?			";

		
				pstmt = dbConn.prepareStatement(l_item_line_query);
				pstmt.setString(1, rs_operating_facility_id);
				pstmt.setString(2, rs_doc_type_code);
				pstmt.setInt(3, Integer.parseInt(rs_doc_num));
				rs = pstmt.executeQuery();				

				while(rsevent.next())
				{
				   l_claims_count = rsevent.getInt("CLAIMS");
				   l_reversal_count = rsevent.getInt("REVERSAL");
				   l_eoc_count = rsevent.getInt("EOC");
				}
				
				if ((l_status_type.equals("CLA") || l_event_type.equals("CLE")) && l_status_code.equals("S"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Submit.png' alt='"+l_approval_status_desc+"'> ";

				if ((l_status_type.equals("CLA") || l_event_type.equals("CLE")) && l_status_code.equals("N"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Pending.PNG' alt='"+l_approval_status_desc+"'> ";

				if ((l_status_type.equals("CLA") || l_status_type.equals("CLE")) && l_status_code.equals("P"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsClaims_Success.PNG' alt='"+l_approval_status_desc+"'> ";

				if (l_status_type.equals("EOC") && l_status_code.equals("P"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsEOC_Success.PNG' alt='"+l_approval_status_desc+"'> ";

				if (l_trans_event.equals("ERA") && l_status_type.equals("CLA"))
					l_image_str  = "<input type='image' id='claims_img' src='../../eCommon/images/EClaimsERA_Success.PNG' alt='"+l_approval_status_desc+"'> ";

					
				l_img_vw_dtl_str = "<input type='image' id='claims_img' src='../../eXH/images/blist.gif' alt='View History' style='width:20px; height: 20px;' onClick='ViewTransDetails(this)'   patient_id='"+rs_patient_id+"' episode_id='"+rs_episode_id+"'  visit_id='"+rs_visit_id+"' doc_num='"+rs_doc_num+"'  bill_doc_code='"+rs_doc_type_code+"'> ";

				currentSubGroup =rs_patient_id+"@"+rs_first_name+"@"+rs_sex+"@"+rs_episode_id+"@"+rs_visit_adm_date_time;
					
				if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){
					if (j>0) {
						out.println("</table>");
						out.println("</td>");
						out.println("</tr>");
					}
					String str="";	
					%>
					<tr width='100%' id = 'trGrpHeader<%=j%>' >								
					<td width='300' style='display:block' class='CAGROUP' ><%=rs_patient_id%></td>
					<td width='300' style='display:block' class='CAGROUP'><%=rs_first_name%></td>
					<td width='300' style='display:block' class='CAGROUP'><%=rs_sex%></td>
					<td width='300' style='display:block' class='CAGROUP'><%=rs_episode_id%></td>
					<td width='300' style='display:block' class='CAGROUP'> <%=rs_visit_adm_date_time%> </td>
					<td width='300' style='display:block' class='CAGROUP'> <%=rs_cust_name%> </td>
					</tr>
					<tr>
					<td colspan = "7">
					<table  cellspacing="0" cellpadding="3" width="100%" border="1" align="center" style="height:10px;overflow-y:scroll;">
						<!--
						<tr>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%' align="center">
								<%
								if(j==0)
								%>
									<font color=white>Select ALL</font><input type='checkbox' id='allCheck' name='allCheck' id='allCheck' value='allCheck' onClick='CheckAll()'>	
								<%
								else	
								%>
									<font color=white><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font>	
							</td>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='8%'>
								<font color=white><fmt:message key="eBL.BILL_NO.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
								<font color=white><fmt:message key="eBL.BILL_DOC_TYPE.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='12%'>
								<font color=white><fmt:message key="eBL.billfromdate.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white><fmt:message key="eBL.billtodate.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white ><fmt:message key="eBL.BILL_DATE.label" bundle="${bl_labels}"/></font>
							</td>			
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='10%'>
								<font color=white ><fmt:message key="eBL.BILLED_AMT.label" bundle="${bl_labels}"/></font>
							</td>	
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white ><fmt:message key="Common.Event.label" bundle="${common_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/></font>
							</td>	
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white ><fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="Common.History.label" bundle="${common_labels}"/></font>
							</td>	
						</tr>
						-->
						<tr>
						<%
					}
					else
					{
					  %>
						<tr>
					   <%
					}

					checkboxvalue = "<PATIENT_ID>"+rs_patient_id+"$!^<ENCOUNTER_ID>"+rs_encounter_id+"$!^<EPISODE_ID>"+rs_episode_id+"$!^<VISIT_ID>"+rs_visit_id+"$!^<EPISODE_TYPE>"+l_episode_type+"$!^<REQUEST>#REQUEST#$!^<REQUEST_TYPE>ECLREQ$!^<MEMBER_ID>"+rs_membership_num_sap+"$!^<DEPD_CODE>"+rs_dependant_num_sap+"$!^<DEPD_RELN>"+rs_dependant_relation_sap+"$!^<CUST_CD>"+rs_cust_code+"$!^<DEST_CD>"+rs_destCode+"$!^<USER>"+user_id+"$!^<FACILITY_ID>"+rs_operating_facility_id+"$!^<TRANS_ID>XXX$!^<WCA_NUM>"+rs_wca_number_sap+"$!^<WS_NO>"+AddedAtWsNo+"$!^<BILL_DOC_TYPE_CODE>"+rs_doc_type_code+"$!^<BILL_DOC_NO>"+rs_doc_num+"$!^<AUTHORIZATION_NUM>"+rs_credit_auth_ref+"$!^<BILL_DATE>"+rs_doc_date+"$!^<TRANS_REF_ID>"+l_trans_ref_no+"$!^<PATIENT_ID_NUM>"+rs_patient_idnum+"$!^<EVENT_TYPE>"+l_event_type+"$!^<MEMBER_SURNAME>"+rs_membership_surname+"$!^<MEMBER_INITIAL>"+rs_membership_initial+"$!^<BLNG_GRP_ID>"+rs_blng_grp_id+"$!^<SETTLEMENT_IND>"+rs_settleInd+"$!^<CLAIM_TYPE>"+rs_claim_type+"$!^";
					l_rej_image_str = "<img src='../../eXH/images/ViewDetails.gif' style='width:15px; height: 15px;margin-top :-15px;' alt='View Line Details' align='right' onClick=\"toggle('"+rs_doc_num+"')\"/>";

					Checkboxname = "Check"+j;
					%>
					<td class='gridData' width='8%'  align='center'> <input type='checkbox' id='checkbox' name='secChk<%=j%>' id='secChk<%=j%>' value='<%=checkboxvalue%>' onClick='setPatientClaimsArray(this,<%=j%>)'> </td>
					<td  class='gridData'  width='8%'> <%=rs_doc_num%> <%=l_rej_image_str%> </td>
					<td  class='gridData'  width='10%'> <%=rs_doc_type_code%> </td>
					<td  class='gridData'  width='15%'> <%=rs_doc_date%> </td>
					<td  class='gridData'  width='15%'> <%=rs_bill_from_date%> </td>
					<td  class='gridData'  width='15%'> <%=rs_bill_to_date%> </td>
					<td  class='gridNumericData' align="right"  width='10%'> <%=rs_bill_amount%> </td>
					<td  class='gridData'  width='8%'> <%=l_image_str%>&nbsp;</td>
					<td  class='gridData'  width='8%'> <%=l_img_vw_dtl_str%></td>
					
					<input type='hidden' name='authnum<%=j%>' id='authnum<%=j%>' value='<%=rs_credit_auth_ref%>'>	
					<input type='hidden' name='destcode<%=j%>' id='destcode<%=j%>' value='<%=rs_destCode%>'>	
					<input type='hidden' name='transID<%=j%>' id='transID<%=j%>' value='<%=l_srl_no%>'>	
					<input type='hidden' name='event_type<%=j%>' id='event_type<%=j%>' value='<%=l_event_type%>'>
					<input type='hidden' name='approval_status<%=j%>' id='approval_status<%=j%>' value='<%=l_approval_status%>'>
					<input type='hidden' name='settlement_ind<%=j%>' id='settlement_ind<%=j%>' value='<%=rs_settleInd%>'> 
					<input type='hidden' name='billing_grp<%=j%>' id='billing_grp<%=j%>' value='<%=rs_blng_grp_id%>'> 
					<input type='hidden' name='cust_code<%=j%>' id='cust_code<%=j%>' value='<%=rs_cust_code%>'>
					<input type='hidden' name='visit_date<%=j%>' id='visit_date<%=j%>' value='<%=rs_visit_date%>'>
					<input type='hidden' name='trans_Id<%=j%>' id='trans_Id<%=j%>' value='<%=l_srl_trans_no%>'>
					<input type='hidden' name='approvalStatus<%=j%>' id='approvalStatus<%=j%>' value='<%=l_approval_trans_status%>'>
					<input type='hidden' name='eventType<%=j%>' id='eventType<%=j%>' value='<%=l_event_trans_type%>'>
					<input type='hidden' name='transrefno<%=j%>' id='transrefno<%=j%>' value='<%=l_trans_ref_no%>'>
					<input type='hidden' name='doctypecode<%=j%>' id='doctypecode<%=j%>' value='<%=rs_doc_type_code%>'>
					<input type='hidden' name='docno<%=j%>' id='docno<%=j%>' value='<%=rs_doc_num%>'>
					<input type='hidden' name='rev_event_type<%=j%>' id='rev_event_type<%=j%>' value='<%=l_rev_event_type%>'>
					<input type='hidden' name='rev_approval_status<%=j%>' id='rev_approval_status<%=j%>' value='<%=l_rev_approval_status%>'>
					</tr>
					<%
					String id="hidethis"+rs_doc_num;
					%>
					<tr id = "<%=id%>" <%=hideTable%>>
				    <td colspan = "9" align="right" >
						<table  cellspacing="0" cellpadding="3" width="95%" border="1" align="right" style="height:10px;overflow-y:scroll;">
						<tr>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='10%'>
								<font color=white><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER' style="font-size:11px;" width='4%'>
								<font color=white><fmt:message key="eBL.IRBDocLineNo.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='8%'>
								<font color=white><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='15%'>
								<font color=white><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='6%'>
								<font color=white><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='6%'>
								<font color=white><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></font>
							</td>
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='6%'>
								<font color=white ><fmt:message key="eBL.NET_CHARGE.label" bundle="${bl_labels}"/></font>
							</td>		
							<td class='COLUMNSUBHEADER'  style="font-size:11px;" width='8%'>
								<font color=white ><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></font>
							</td>		
							
						</tr>
						<%
						while(rs.next())
				        {
						%>
						    <tr>
							<td  class='gridData'> <%=rs.getString(22)%> </td>
							<td  class='gridData'> <%=rs.getString(23)%> </td>
							<td  class='gridData' > <%=rs.getString(11)%> </td>
							<td  class='gridData' > <%=rs.getString(12)%> </td>
							<td  class='gridNumericData' align="right"> <%=rs.getString(16)%> </td>
							<td  class='gridNumericData' align="right"> <%=rs.getString(17)%> </td>
							<td  class='gridNumericData' align="right"> <%=rs.getString(18)%> </td>
							<td  class='gridData' align="center"> <%=rs.getString(15)%> </td>
							</tr>
						<%
						}

						try {
							if (rs != null) {
								rs.close();
							}
						}
						catch(Exception exp) {
							System.out.println(" Error in closing rs ::: "+exp.getMessage());	
						}
						%>
						</table>
				<%

				if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

				}
				prevSubGroup = currentSubGroup; 
				l_event_type = "";l_srl_no = 0; l_case_no = ""; l_approval_status = ""; l_claim_no = "";
				l_event_trans_type = "";l_srl_trans_no = 0;l_case_trans_no = "";l_approval_trans_status ="";
			}
			if ((j>0) && (j==billDetailsRowCount)){
				%>
				</table>
				</td>
				</tr>
		<%
		}
			
		%>
		</table>
		</div>
		<input type="hidden" name="batchqry" id="batchqry" value="<%=sqlQuery%>">
		<input type="hidden" name="userid" id="userid" value="<%=user_id%>">
		<input type="hidden" name="wsno" id="wsno" value="<%=AddedAtWsNo%>">
		<input type="hidden" name="event_type" id="event_type" value="<%=event_type%>">
		<input type="hidden" name="arrRowSize" id="arrRowSize" value="<%=arrRow.size()%>">

		<%

	}
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
	if(resultsQry!=null) resultsQry.clear();
		
	}
	catch(Exception e1)
	{
	  System.out.println("(MediMembershipBatchResult.jsp:Exception) "+e1);
	  e1.printStackTrace(System.err);
	}
	finally
	{
	  ConnectionManager.returnConnection(conn);
	  ConnectionManager.returnConnection(dbConn);
	}
%>
</form>
</body>
</html>

