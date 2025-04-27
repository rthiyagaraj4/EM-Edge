
<%

/**
 *	MODULE			:	Medical Records..(MR)
 *	Function Name	:	Medical Report
 *	[Request/Prepare/Status/Forward/Receive/Deliver/Revise]
 *	Created On		:	22 JULY 2004
 *	Created By		:	SRIDHAR R

 *	CALL_FUNCTION && REQUEST_STATUS
	******************************
 *	MEDICAL_REPORT_REQUEST 	-  1
 *	MEDICAL_REPORT_STATUS 	-  2
 *  	FORWARD_TO_HOD		-  9 Added By Dharma
 *  	REQUEST_RETURNED	-  10 Added By Dharma 
 * 	 REQUEST_ACCEPTED	-  11 Added By Dharma
 *	FORWARD_MEDICAL_REPORT	-  3
 *	PREPARE_MEDICAL_REPORT	-  4
 *	RECEIVE_MEDICAL_REPORT 	-  5
 *	DELIVER_MEDICAL_REPORT 	-  6
 *	REVISE_MEDICAL_REPORT 	-  7
**/
//isAcceptRequestByPractAppl - Used for ML-MMOH-CRF-1473 & ML-MMOH-CRF-1314 - Dharma
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,org.json.simple.*,webbeans.op.CurrencyFormat,blopin.*,eCommon.XSSRequestWrapper" %>
<% String Facility_Id = (String) session.getValue("facility_id");%>
<% String locale = (String) session.getValue("LOCALE");%>
<% String loginUser = (String) session.getValue("login_user");%> <!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719-->
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
   java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" );//Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905
%>

<html>
<head>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eMR/js/MedRecRequestButtons.js" language='javascript'></script>
	<script src="../../eMR/js/MedRecRequestDetails.js" language='javascript'></script>
	<script src="../../eMR/js/MRPractitionerComponent.js" language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
		
<script>

 

function allowAlphaNumeric(event){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function CheckNumberFormat(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
	{
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED","SM"));
            obj.value= "";
            obj.focus();
            return false;
        }
    }
}
/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
async function showChecklistDetails(isDisable)
{ 
	
	var request_type= document.forms[0].req_type.value;  // added by mujafar for ML-MMOH-CRF-0762
	var requestor_code = document.forms[0].hdd_requestor_code.value; // added by mujafar for ML-MMOH-CRF-0762
	
	
	
	
	var call_function	= document.forms[0].call_function.value; 
    	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "0vh"; 
	var dialogHeight = "50vh";
	var dialogWidth	 = "35vw";
	//Modified the condition by Kamatchi S ML-MMOH-CRF-1464
	if(document.forms[0].classification_appl_yn.value=="true")
	{
		dialogHeight	= "50vh"; // modified by mujafar for ML-MMOH-CRF-0762
		dialogWidth		= "35vw";
	}
	else
	{
		dialogHeight	= "50vh";	
		dialogWidth		= "35vw";
	}
	var status			= "no";
	var arguments	= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;
	
	if(document.forms[0].classification_appl_yn.value == "true"  )
	{ // added by mujafar for ML-MMOH-CRF-0762		
				if(document.forms[0].req_type.value == "")
				{
					
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				var msgg = msg.replace("$",getLabel("eMR.RequestorType.label","MR"));
				
				alert(msgg);
				return;	
				}
				if(document.forms[0].req_type.value != "")
				{  
					if(document.forms[0].req_type_status.value =="" || document.forms[0].req_type_status.value == "O" )
					{ 
						if(document.forms[0].classification_ind.value == "" || document.forms[0].classification_ind.value == "O")
						if(document.forms[0].requestor_desc.value == "")
						{ 
							var msg1 = getMessage("CAN_NOT_BE_BLANK","COMMON");
							var msgg1 = msg1.replace("$",getLabel("Common.Requestor.label","Common"));
					
							alert(msgg1);
							return;	
							
						}
					}
					
				}
				
				
				
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH request_type=\""+request_type+"\" requestor_code=\""+requestor_code+"\" action='ChecklistCount' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		 
		if(responseText == 0)alert(getMessage('CHK_LIST_NOT_DEFINED','MR'));
		
		
	
		if(responseText > 0)
		{
			retVal=await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?request_id="+document.forms[0].request_id.value+"&call_function="+document.forms[0].call_function.value+"&requestor_desc="+document.forms[0].requestor_desc.value+"+&req_code="+document.forms[0].hdd_requestor_code.value+"+&req_type="+document.forms[0].req_type.value+"+&classification_appl_yn="+document.forms[0].classification_appl_yn.value+"+&toShow=ChecklistDetails&call_function="+document.forms[0].call_function.value+"&isDisable="+isDisable+"&arrgu="+document.forms[0].ret_val1.value,arguments,features);
			 // modified by mujafar for ML-MMOH-CRF-0762
			if(retVal != undefined)
				document.forms[0].ret_val1.value= retVal;
				
		}
				
	}
	
	else
	{
	retVal=await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=ChecklistDetails&call_function="+document.forms[0].call_function.value+"&isDisable="+isDisable+"&arrgu="+document.forms[0].ret_val.value,arguments,features);
	if(retVal != undefined)
	document.forms[0].ret_val.value= retVal;
	} // added by mujafar for ML-MMOH-CRF-0762 end
	
	
}
/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/

function populateRecptDate(obj, dateObj, dateImg)
{
	if(document.forms[0].medrep_pay_int_mode.value == "X")
	{
		if(document.forms[0].call_function.value  == "MEDICAL_REPORT_REQUEST")
		{
			if(obj != "")
			{

				//dateObj.value = document.forms[0].sysdate.value;
				dateObj.value = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName);

			}
			else
				dateObj.value = "";
		}
		else if(document.forms[0].call_function.value  == "MEDICAL_REPORT_STATUS")
		{
			if(obj != "")
			{
				dateObj.disabled = false;
				dateImg.disabled = false;
				dateObj.focus();
			}
			else
			{
				dateObj.value = "";
				dateObj.disabled = true;
				dateImg.disabled = true;
			}
		}
	}
}



function validateRecptDateTime(from,to)
{
	from = from.value;
	to   = to.value;
	var a=  from.split(" ");
	splitdate=a[0];
	splittime=a[1];
	var splitdateA =splitdate.split("/");
	var splittimeA= splittime.split(":");
	var from_date  =new Date(eval(splitdateA[2]), eval(splitdateA[1])-1, eval(splitdateA[0]), eval(splittimeA[0]), eval(splittimeA[1]));

	var b=  to.split(" ");
	splitdate=b[0];
	splittime=b[1];
	var splitdateB =splitdate.split("/");
	var splittimeB= splittime.split(":");
	var to_date  =new Date(eval(splitdateB[2]), eval(splitdateB[1])-1, eval(splitdateB[0]), eval(splittimeB[0]), eval(splittimeB[1]));

	if(Date.parse(to_date) <= Date.parse(from_date))
		return false;
	else
		return true;
}


function recptDateValidations(obj, reqDate, sysDate)
{
	//var result = "Pass";
	//var recptDate = obj.value;
	//var systemDate = sysDate.value;
	var requestDate = reqDate.value;

	/*if(recptDate != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.value = "";
			result = "Fail";
			obj.focus();
			return ;
		}
	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.value = "";
		//result = "Fail";
		//obj.focus();
		return false;
	}
	//if(result == "Pass" && recptDate != '')
	else
	{
			var greg_receiptDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			if(isAfterNow(greg_receiptDateTime,'DMYHM','en'))
			//if(validateRecptDateTime(sysDate,obj))
			{
				var error=getMessage("MRDATE1_GT_DATE2","MR");
				error= error.replace('$',getLabel("Common.receiptdate.label","Common"));
				error= error.replace('#',getLabel("Common.SystemDateTime.label","Common"));
				alert(error);
				//Receipt date shud nnot be greater than system date ...
				obj.value = "";
				//obj.focus();
				return false;
			}
			//else if(validateRecptDateTime(obj,reqDate))
			else if(isBefore(greg_receiptDateTime,requestDate,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_LT_DATE2","MR");
				error= error.replace('$',getLabel("Common.receiptdate.label","Common"));
				error= error.replace('#',getLabel("Common.RequestDate.label","Common"));
				alert(error);
				//Receipt date shud not be lass than Request date ...
				obj.value = "";
				//obj.focus();
				return false;
			}
			else
				return true;
	}
}
// added for ML-MMOH-CRF-0704 START
function isHoliday(obj)
{ 
	if(document.forms[0].isMedicalReportDurationAppl.value == "true" && document.forms[0].appl_status.value == '2' )
	{
		
		var appl_col_date = obj.value ;
		var appl_type_val = document.forms[0].appl_type.value;
		var appl_col_flag = 'C';
		if(appl_col_date!="")
		{
		
		
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH appl_col_date=\""+appl_col_date+"\" appl_type_val=\""+appl_type_val+"\" appl_col_flag=\""+appl_col_flag+"\" action='isHoliday' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		
		if(responseText == "Entered date is Holiday"){
			var msg = getMessage("ENTER_DATE_HOLIDAY","MR");
			alert(msg);
			obj.value="";
			obj.focus();
			
		}
		
		}
		
	}
	
}
function chkCollectDate2()
{
	if((document.forms[0].isMedicalReportDurationAppl && document.forms[0].isMedicalReportDurationAppl.value == "true") && (document.forms[0].appl_status &&document.forms[0].appl_status.value == '2'))
	{ 
	document.forms[0].appl_comp_date.onblur();
	}
}
function compare_from(from,to)
{ 
if(document.forms[0].isMedicalReportDurationAppl.value == "true" && document.forms[0].appl_status.value == '2' )
	{
		if(from.value!="" && to.value!="" )
		{ 
	
			if(isBefore(from.value,to.value,'DMYHM',localeName)==false)
				{
				var error=getMessage("MRDATE1_LT_DATE2",'MR');
				error= error.replace('$',getLabel("eMR.CollectDate.label","MR"));
				error= error.replace('#',getLabel("eMR.ApplicationCompletionDates.label","MR"));
				alert(error);
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
	}
}
function validate_date_from(from)
{
	if(document.forms[0].isMedicalReportDurationAppl.value == "true" && document.forms[0].appl_status.value == '2' )
	{
		var sys=document.forms[0].sysdate;
		if(from.value!="")
		{
			if(!validDateObj(from,"DMYHM",localeName)){
					from.value="";
					return ;
			}
		var obj1=convertDate(from.value,"DMYHM",localeName,"en");
			if(isBefore(sys.value,obj1,'DMYHM',localeName)==false){
				var error=getMessage("MRDATE1_LT_DATE2",'MR');
									
				if(from.name == "appln_col_date") 
					{
						error= error.replace('$',getLabel("eMR.ApplicationCompletionDates.label","MR"));
						error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					else
					{
						error= error.replace('$',getLabel("eMR.CollectDate.label","MR"));
						error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					alert(error);
					from.value="";
					from.select();	
					return false;
			 }
				else
					return true;

		}
	}
}
function chkCollectDate1(obj)
{
	
	if(document.forms[0].isMedicalReportDurationAppl.value == "true" && document.forms[0].appl_status.value == '2' )
	{
	
	
	var ret_collect_date = chkCollectDate(obj);
	
		if(ret_collect_date != 'Entered date is Holiday')
		document.forms[0].collection_date.value = ret_collect_date;
		else
		document.forms[0].collection_date.value ="";
		if(document.forms[0].collection_date.value  != 'undefined')
		document.forms[0].collect_date.value = document.forms[0].collection_date.value;
	}
}

function chkCollectDate(obj)
{ 
	if(document.forms[0].isMedicalReportDurationAppl.value == "true" && document.forms[0].appl_status.value == '2' )
	{ 
		
		var appl_col_date = obj.value ;
		
		var appl_type_val = document.forms[0].appl_type.value;
		var appl_col_flag = 'A';
		if(appl_col_date!="")
		{ 
		
		
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH appl_col_date=\""+appl_col_date+"\" appl_type_val=\""+appl_type_val+"\" appl_col_flag=\""+appl_col_flag+"\" action='calCollectDate' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		
		if(responseText == "Entered date is Holiday"){
			var msg = getMessage("ENTER_DATE_HOLIDAY","MR");
			alert(msg);
			obj.value="";
			obj.focus();
			
		}
		else{
			
			
		}
		
		return responseText;
		
		}
		
		
		
	}
	
}
// added for ML-MMOH-CRF-0704 END
function CheckZeroVal(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 && obj.value==0) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}


function enableOtherDetails(name, value)
{
	medrep_pay_int_mode = document.forms[0].medrep_pay_int_mode.value;
	if(medrep_pay_int_mode == "X")
	{
		if(name == 'charges_appllicable')
		{
			if(value =='Y')
			{
				document.getElementById('amount').value = "";
				document.getElementById('amount').disabled = false;
				document.getElementById("chargeImg2").style.visibility = "visible";
				document.getElementById('recp_no').value = "";
				document.getElementById('recp_no').disabled = false;
				document.getElementById('recp_dat').value = "";
				document.getElementById('recp_dat').disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].amount.value = "";
				document.forms[0].amount.disabled = true;
				document.getElementById("chargeImg2").style.visibility = "hidden";
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
		}
		else if(name == 'additional_charges')
		{
			if(value =='Y')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = false;
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = false;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.forms[0].add_amount.value = "";
				document.forms[0].add_amount.disabled = true;
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
		}
	}
	else if(medrep_pay_int_mode == "B")
	{
		if(name == 'charges_appllicable')
		{
			if(value =='Y')
			{
				document.getElementById('amount').value = "";
				document.getElementById('amount').disabled = false;
				document.getElementById("chargeImg2").style.visibility = "visible;";
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.getElementById('amount').value = "";
				document.getElementById('amount').disabled = true;
				document.getElementById("chargeImg2").style.visibility = "hidden";
				document.forms[0].recp_no.value = "";
				document.forms[0].recp_no.disabled = true;
				document.forms[0].recp_dat.value = "";
				document.forms[0].recp_dat.disabled = true;
				document.getElementById("recp_dat_img").disabled = true;
			}
		}
		else if(name == 'additional_charges')
		{
			if(value =='Y')
			{
				document.getElementById('add_amount').value = "";
				document.getElementById('add_amount').disabled = false;
				document.getElementById("addtlChargeImg2").style.visibility = "visible";
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
			else if(value =='N' || value =='')
			{
				document.getElementById('add_amount').value = "";
				document.getElementById('add_amount').disabled = true;
				document.getElementById("addtlChargeImg2").style.visibility = "hidden";
				document.forms[0].add_recp_no.value = "";
				document.forms[0].add_recp_no.disabled = true;
				document.forms[0].add_recp_dat.value = "";
				document.forms[0].add_recp_dat.disabled = true;
				document.getElementById("add_recp_dat_img").disabled = true;
			}
		}	
	}
}


async function showDateDetails()
{
	var call_function	= document.forms[0].call_function.value;

	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "0vh";
	var dialogHeight	= "39vh";
	var dialogWidth		= "40vw";
	var status			= "no";
	var arguments	= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

	retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&call_function="+document.forms[0].call_function.value+"&PrepareDate="+document.forms[0].prepareDate.value+"&applCompletionDate="+document.forms[0].applCompletionDate.value+"&RequestDate="+document.forms[0].RequestDate.value+"&ReceivedDate="+document.forms[0].ReceivedDate.value+"&applSubmissionDate="+document.forms[0].applSubmissionDate.value+"&DeliveredDate="+document.forms[0].DeliveredDate.value,arguments,features);
}


async function showChargeDetails()
{
	var call_function	= document.forms[0].call_function.value;

	var retVal			= new String();
	var center			= "3" ;
	var dialogTop		= "0vh";
	var dialogHeight	= "39vh";
	var dialogWidth		= "40vw";
	var status			= "no";
	var arguments	= "" ;
	var features		= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status=no; dialogTop:"+dialogTop;

	retVal =await window.showModalDialog("../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&call_function="+document.forms[0].call_function.value+"&charges_appl_yn="+document.forms[0].hdd_charges_appl_yn.value+"&addl_charges_yn="+document.forms[0].hdd_addl_charges_yn.value+"&receipt_no="+document.forms[0].hdd_receipt_no.value+"&addl_receipt_no="+document.forms[0].hdd_addl_receipt_no.value+"&amount="+document.forms[0].hdd_amount.value+"&addl_amount="+document.forms[0].hdd_addl_amount.value+"&receipt_date="+document.forms[0].hdd_receipt_date.value+"&addl_receipt_date="+document.forms[0].hdd_addl_receipt_date.value,arguments,features);
}


function disableAll()
{
	var call_function	= document.forms[0].call_function.value;
	if(call_function == "MEDICAL_REPORT_CANCELLED")
	{ 
		document.forms[0].appl_type.disabled = true;
		document.forms[0].appln_date.disabled = true;
		document.forms[0].ApplnImg.disabled = true;
		document.forms[0].appl_name.disabled = true;
		document.forms[0].appl_refno.disabled = true;
		document.forms[0].relationship_type.disabled = true;
		document.forms[0].relationship.disabled = true;
		document.forms[0].req_type.disabled = true;
		document.forms[0].requestor_desc.disabled = true;
		document.forms[0].search_Requestor.disabled = true;
		if(document.forms[0].cons_letter)
			document.forms[0].cons_letter.disabled = true;
		document.forms[0].for_attn.disabled = true;
		document.forms[0].appl_no.disabled = true;
		document.forms[0].charges_appllicable.disabled = true;
		document.forms[0].additional_charges.disabled = true;
		document.forms[0].amount.disabled = true;
		document.forms[0].add_amount.disabled = true;
		document.forms[0].recp_no.disabled = true;
		document.forms[0].add_recp_no.disabled = true;
		document.forms[0].recp_dat.disabled = true;
		document.forms[0].recp_dat_img.disabled = true;
		document.forms[0].add_recp_dat.disabled = true;
		document.forms[0].add_recp_dat_img.disabled = true;
		document.forms[0].appl_status.disabled = true;
		document.forms[0].pract_desc.disabled = true;
		document.forms[0].pract_id_search.disabled = true;
		document.forms[0].reqd_docs.disabled = true;
		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		var isIncompReqCancelApplicable = document.forms[0].isIncompReqCancelApplicable.value;
		var requestStatus				= document.forms[0].requestStatus.value;
		if(isIncompReqCancelApplicable == "true" && requestStatus == "8"){
			document.getElementById("appln_col1").innerText = getLabel("Common.cancelledby.label","Common");
			document.getElementById("appln_col2").innerText = document.forms[0].cancelledBy.value;
			//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108
			//document.getElementById("cncl_date_lbl").innerText = getLabel("Common.cancelled.label","Common")+" "+getLabel("Common.on.label","Common");
			document.getElementById("cncl_date_lbl").innerText = getLabel("Common.CancelledOn.label","Common");
			document.getElementById("cncl_date").innerText = document.forms[0].cancelledDate.value;
			
			document.getElementById('hideRow').style.display = "block";
			document.getElementById("cncl_reason_lbl").innerText = getLabel("Common.ReasonforCancellation.label","Common");
			document.getElementById("cancel_reason").style.visibility = "visible";
			document.forms[0].cancel_reason.disabled = true;
			var reasonCode		= document.forms[0].cancelledReason.value;
			for(var i=0;i<document.forms[0].cancel_reason.options.length;i++ )
			{
				if(document.forms[0].cancel_reason.options[i].value == reasonCode)
					document.forms[0].cancel_reason.options[i].selected=true;
			}
		}
		/*End*/
	}
	
}

function showMsgSpecialty(){
	 var specialtyEffStatus = document.forms[0].specialtyEffStatus.value;
	 var specialtyMRApplYN = document.forms[0].specialtyMRApplYN.value;
	 var Splcode			= document.forms[0].Splcode.value;
	 
	 
	 if(Splcode!=""){
	 	if(specialtyEffStatus!="E" ||specialtyMRApplYN!="Y" ){
	 		var msg = getMessage("SPL_NOT_COFIGURED","MR");
			var msgg = msg.replace("#",document.forms[0].dept_spl.value);
			document.forms[0].Splcode.value = "";
			document.forms[0].dept_spl.value ="";
			alert(msgg);
			return;
	 	}
	 }
	 
	

}


/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
function transMode()
{
	var call_function = document.forms[0].call_function.value;
	var isChckLstApplicable = document.forms[0].isChckLstApplicable.value;
	if(isChckLstApplicable == "true") {
		if(call_function == "DELIVER_MEDICAL_REPORT" || call_function == "MEDICAL_REPORT_COMPLETED") { 
			document.forms[0].applic_mode.value		= document.forms[0].applicationMode.value;
			document.forms[0].collectn_mode.value	= document.forms[0].collectionMode.value;
			document.forms[0].notific_mode.value	= document.forms[0].notificationMode.value;
			
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(call_function == "MEDICAL_REPORT_COMPLETED"){
			var Despatch_mode	= document.forms[0].Despatch_mode.value;
			if(Despatch_mode=="P"){
				document.getElementById("natIDRow").style.display	= 'block';
				document.getElementById("lblDelDateTD").style.display	= 'block';
				document.getElementById("fldDelDateTD").style.display	= 'block';
				document.getElementById("altIDRow").style.display	= 'block';
				document.getElementById("lblDatePostedTD").style.display	= 'none';
				document.getElementById("fldDatePostedTD").style.display	= 'none';
				document.getElementById("postAgeNoRow").style.display = 'none';
				
			}else if(Despatch_mode=="O"){
				document.getElementById("natIDRow").style.display	= 'none';
				document.getElementById("lblDelDateTD").style.display	= 'none';
				document.getElementById("fldDelDateTD").style.display	= 'none';
				document.getElementById("altIDRow").style.display	= 'none';
				document.getElementById("lblDatePostedTD").style.display	= 'block';
				document.getElementById("fldDatePostedTD").style.display	= 'block';
				document.getElementById("postAgeNoRow").style.display = 'block';

			}
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/

	}
}
/*ML-MMOH-CRF-0963 START*/
function frwdtoPractMedicalReport()
{
	   
if(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value=="true")
{
	if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true )
	{
		  if(document.forms[0].remarks){
				document.forms[0].remarks.value="";
				document.forms[0].remarks.disabled = true;
			}
			if(document.forms[0].fwd_pract_desc){
									   
				document.forms[0].fwd_pract_desc.disabled = true;
			}
						
			if(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = true; 
			
			
			if(document.forms[0].prep_pract_desc){
				document.forms[0].prep_pract_desc.value=""; 					   
				document.forms[0].prep_pract_desc.disabled = true;
			}
			if(document.forms[0].prep_practitioner_id) document.forms[0].prep_practitioner_id.value="";		
			
			if(document.forms[0].prep_pract_id_search) document.forms[0].prep_pract_id_search.disabled = true; 
			if(document.forms[0].prep_pract_desc_Img) document.forms[0].prep_pract_desc_Img.style.visibility = "hidden";  
			
			if(document.forms[0].prepare_date)  document.forms[0].prepare_date.disabled = true;
        
		    document.getElementById("cancelby_medical_report").innerText = getLabel("Common.cancelledby.label","Common");
			document.getElementById("cancelby_med_rep_user").innerText = document.forms[0].loginUser.value;
			//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108
			//document.getElementById("cancelon_medical_report").innerText = getLabel("Common.cancelled.label","Common")+" "+getLabel("Common.on.label","Common");
			document.getElementById("cancelon_medical_report").innerText = getLabel("Common.CancelledOn.label","Common");
				
			document.getElementById("cancelondate_medical_report").innerText = getCurrentDate("DMYHM","en");
			
			document.getElementById("cancel_medrep_reason").innerText = getLabel("Common.ReasonforCancellation.label","Common");
			if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").style.visibility = "visible";
			document.getElementById("cancel_medical_rep_reason_img").style.visibility = "visible";
			
			if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="Y";
			
				
		}if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==false)
		{
		    if(document.forms[0].remarks) document.forms[0].remarks.disabled = false;			
			
			
			
			
			if(document.forms[0].fwd_pract_desc) document.forms[0].fwd_pract_desc.disabled = false;
							
			if(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = false; 
			
			if(document.forms[0].prepare_date)  document.forms[0].prepare_date.disabled = false;
			if(document.forms[0].prep_pract_desc){
				document.forms[0].prep_pract_desc.value=""; 					   
				document.forms[0].prep_pract_desc.disabled = false;
			}
			if(document.forms[0].prep_pract_id_search) document.forms[0].prep_pract_id_search.disabled = false; 
			if(document.forms[0].prep_pract_desc_Img) document.forms[0].prep_pract_desc_Img.style.visibility = "visible";
			
			document.getElementById("cancelby_medical_report").innerText = "";
			document.getElementById("cancelby_med_rep_user").innerText = "";
			document.getElementById("cancelon_medical_report").innerText = "";
			document.getElementById("cancelondate_medical_report").innerText = "";
			document.getElementById("cancel_medrep_reason").innerText = "";
			if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").options[0].selected=true;
			document.getElementById("cancel_medical_rep_reason").style.visibility = "hidden";
			document.getElementById("cancel_medical_rep_reason_img").style.visibility = "hidden";
			 if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="N"; 			
			
		}
	}
	
	
	
	
}


/*ML-MMOH-CRF-0963 END*/
/*Below line added for this CRF ML-MMOH-CRF-0712*/
function medicalReport(){ 
	var isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;
	if(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value=="true"){
		if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true ){
				/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 Start*/
			    /*if(document.forms[0].appl_type) document.forms[0].appl_type.disabled = true;										
				if(document.forms[0].appln_date) document.forms[0].appln_date.disabled = true;	               				
				if(document.forms[0].ApplnImg) document.forms[0].ApplnImg.disabled = true;
				if(document.forms[0].appl_name) document.forms[0].appl_name.disabled = true;
				if(document.forms[0].appl_refno) document.forms[0].appl_refno.disabled = true;
				if(document.forms[0].relationship_type) document.forms[0].relationship_type.disabled = true;
				if(document.forms[0].relationship) document.forms[0].relationship.disabled = true;
				if(document.forms[0].req_type) document.forms[0].req_type.disabled = true;
				if(document.forms[0].requestor_desc) document.forms[0].requestor_desc.disabled = true;
				if(document.forms[0].search_Requestor) document.forms[0].search_Requestor.disabled = true;
				if(document.forms[0].cons_letter) document.forms[0].cons_letter.disabled = true;
				if(document.forms[0].for_attn) document.forms[0].for_attn.disabled = true;
				if(document.forms[0].appl_no) document.forms[0].appl_no.disabled = true;*/
				/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 End*/
				if(document.forms[0].rep_type){
				       document.forms[0].rep_type.value="";
				       document.forms[0].rep_type.disabled = true;
				}
			
				if(document.forms[0].dept_spl){ 
					if(isSpecialtyDefaultApp=="false"){
				       document.forms[0].dept_spl.value="";
					}
				       document.forms[0].dept_spl.disabled = true;
				}
				if(document.forms[0].search_spl) document.forms[0].search_spl.disabled = true;
				if(document.forms[0].remarks){
				       document.forms[0].remarks.value=""; 
				       document.forms[0].remarks.disabled = true;
				}
				if(document.forms[0].fwd_hod_desc){
				       document.forms[0].fwd_hod_desc.value="";
				       document.forms[0].fwd_hod_desc.disabled = true;
				}
				if(document.forms[0].fwd_hod_id_search) document.forms[0].fwd_hod_id_search.disabled = true;
				
					//added by mujafar for ML-MMOH-CRF-0716
					if((document.forms[0].call_function.value =="FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_MRD") && document.forms[0].isMedicalTeamApplicable.value == "true") // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					{ 
					if(document.getElementById("medical_team_val"))
					{document.getElementById("medical_team_val").options[0].selected=true;
					document.getElementById("medical_team_val").disabled = true;
					}
					
					if(document.getElementById("medical_team_val1")){document.getElementById("medical_team_val1").options[0].selected=true;
					document.getElementById("medical_team_val1").disabled = true;
					}
					}
				
				if(document.forms[0].inform_hod_desc){
				       document.forms[0].inform_hod_desc.value="";
				       document.forms[0].inform_hod_desc.disabled = true;
				}
				if(document.forms[0].inform_hod_pract_id_search) document.forms[0].inform_hod_pract_id_search.disabled = true;
				if(document.forms[0].pract_desc) document.forms[0].pract_desc.disabled = true;
				if(document.forms[0].pract_id_search) document.forms[0].pract_id_search.disabled = true;
								
		
				document.getElementById("cancelby_medical_report").innerText = getLabel("Common.cancelledby.label","Common");
				document.getElementById("cancelby_med_rep_user").innerText = document.forms[0].loginUser.value;
				//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108
				//document.getElementById("cancelon_medical_report").innerText = getLabel("Common.cancelled.label","Common")+" "+getLabel("Common.on.label","Common");
				document.getElementById("cancelon_medical_report").innerText = getLabel("Common.CancelledOn.label","Common");
				//document.getElementById("cancelondate_medical_report").innerText = document.forms[0].sysdate.value;				
				document.getElementById("cancelondate_medical_report").innerText = getCurrentDate("DMYHM","en");
				
				document.getElementById("cancel_medrep_reason").innerText = getLabel("Common.ReasonforCancellation.label","Common");
				if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").style.visibility = "visible";
				document.getElementById("cancel_medical_rep_reason_img").style.visibility = "visible";	
				/*if(document.getElementById("appl_type_mandatory"))document.getElementById("appl_type_mandatory").style.visibility = "hidden"; 				
				if(document.getElementById("appl_date_madndatory")) document.getElementById("appl_date_madndatory").style.visibility = "hidden";*/				
				if(document.getElementById("ReportTypeImg")) document.getElementById("ReportTypeImg").style.visibility = "hidden"; 
				if(document.getElementById("DeptImg")) document.getElementById("DeptImg").style.visibility = "hidden";
                if(document.getElementById("fwd_hod_img")) document.getElementById("fwd_hod_img").style.visibility = "hidden";	
                if(document.getElementById("inform_hod_img")) document.getElementById("inform_hod_img").style.visibility = "hidden"; 
				if(document.forms[0].fwd_hod_id)document.forms[0].fwd_hod_id.value="";
				if(document.forms[0].inform_hod_practitioner_id)document.forms[0].inform_hod_practitioner_id.value="";
				
				/*isSpecialtyDefaultApp condition added By Dharma on 3rd Dec 2019 against ML-MMOH-CRF-1454*/
				if(isSpecialtyDefaultApp=="false"){
					if(document.forms[0].Splcode)document.forms[0].Splcode.value="";
				}
				if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="Y";
    				
				
		}if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==false){
		      /*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 Start*/
			    /*if(document.forms[0].appl_type) document.forms[0].appl_type.disabled = false;				
				if(document.forms[0].appln_date) document.forms[0].appln_date.disabled = false;				
				if(document.forms[0].ApplnImg) document.forms[0].ApplnImg.disabled = false;
				if(document.forms[0].appl_name) document.forms[0].appl_name.disabled = false;
				if(document.forms[0].appl_refno) document.forms[0].appl_refno.disabled = false;
				if(document.forms[0].relationship_type) document.forms[0].relationship_type.disabled = false;
				if(document.forms[0].relationship) document.forms[0].relationship.disabled = false;
				if(document.forms[0].req_type) document.forms[0].req_type.disabled = false;
				if(document.forms[0].requestor_desc) document.forms[0].requestor_desc.disabled = false;
				if(document.forms[0].search_Requestor) document.forms[0].search_Requestor.disabled = false;
				if(document.forms[0].cons_letter) document.forms[0].cons_letter.disabled = false;
				if(document.forms[0].for_attn) document.forms[0].for_attn.disabled = false;
				if(document.forms[0].appl_no) document.forms[0].appl_no.disabled = false;*/
				/*Commented By Dharma on 18th Dec 2019 against  ML-MMOH-CRF-1454 End*/
				if(document.forms[0].rep_type) document.forms[0].rep_type.disabled = false;
				if(document.forms[0].dept_spl) document.forms[0].dept_spl.disabled = false;
				if(document.forms[0].search_spl) document.forms[0].search_spl.disabled = false;
				if(document.forms[0].remarks) document.forms[0].remarks.disabled = false;
				if(document.forms[0].fwd_hod_desc) document.forms[0].fwd_hod_desc.disabled = false;
				if(document.forms[0].fwd_hod_id_search) document.forms[0].fwd_hod_id_search.disabled = false;
				//if(document.forms[0].reqd_docs) document.forms[0].reqd_docs.disabled = false;
				if((document.forms[0].call_function.value =="FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_MRD" )&& document.forms[0].isMedicalTeamApplicable.value == "true")
				{ //added by mujafar for ML-MMOH-CRF-0716
				// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					document.getElementById("medical_team_val").disabled = false;
					document.getElementById("medical_team_val1").disabled = false;
				}
				if(document.forms[0].inform_hod_desc) document.forms[0].inform_hod_desc.disabled = false;
				if(document.forms[0].inform_hod_pract_id_search) document.forms[0].inform_hod_pract_id_search.disabled = false;
				if(document.forms[0].pract_desc) document.forms[0].pract_desc.disabled = false;
				if(document.forms[0].pract_id_search) document.forms[0].pract_id_search.disabled = false;		
		
				document.getElementById("cancelby_medical_report").innerText = "";
				document.getElementById("cancelby_med_rep_user").innerText = "";
				document.getElementById("cancelon_medical_report").innerText = "";
				document.getElementById("cancelondate_medical_report").innerText = "";
				document.getElementById("cancel_medrep_reason").innerText = "";
				if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").options[0].selected=true;
				document.getElementById("cancel_medical_rep_reason").style.visibility = "hidden";
				document.getElementById("cancel_medical_rep_reason_img").style.visibility = "hidden";
				
				/*if(document.getElementById("appl_type_mandatory"))document.getElementById("appl_type_mandatory").style.visibility = "visible"; 				
				if(document.getElementById("appl_date_madndatory")) document.getElementById("appl_date_madndatory").style.visibility = "visible";*/				
				
				if(document.getElementById("ReportTypeImg")) document.getElementById("ReportTypeImg").style.visibility = "visible"; 
				if(document.getElementById("DeptImg")) document.getElementById("DeptImg").style.visibility = "visible";
                if(document.getElementById("fwd_hod_img")) document.getElementById("fwd_hod_img").style.visibility = "visible";	
                if(document.getElementById("inform_hod_img")) document.getElementById("inform_hod_img").style.visibility = "visible";
				
				if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="N";
				
		}
	}
}


function frwdtoHodMedicalReport(){   
if(document.forms[0].isMedicalReportRequest && document.forms[0].isMedicalReportRequest.value=="true"){
	if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==true ){
		  if(document.forms[0].remarks){
				document.forms[0].remarks.value="";
				document.forms[0].remarks.disabled = true;
			}
			
			if(document.forms[0].img_remarks && document.forms[0].status && document.forms[0].status.value=="R"){ 
				document.getElementById("img_remarks").style.visibility = "hidden"; 				
		    }
			
			if(document.forms[0].status_imag){ 
				document.getElementById("status_imag").style.visibility = "hidden"; 	
				document.forms[0].status.disabled = true;
			}	
			// Added by Shaik Mujafar for ML-MMOH-CRF-0713 start
			if(document.forms[0].isRejectRequestApplicable.value=="true" && document.forms[0].reject_medical_rep_reason && document.forms[0].status.value=="R"){ 
					
				document.forms[0].reject_medical_rep_reason.disabled = true;
				document.forms[0].reject_medical_rep_reason_img.style.visibility = "hidden";
			}	
			// end
			if(document.forms[0].fwd_pract_desc){
				document.forms[0].fwd_pract_desc.value=""; 					   
				document.forms[0].fwd_pract_desc.disabled = true;
			}
			if(document.forms[0].fwd_practitioner_id) document.forms[0].fwd_practitioner_id.value="";				
			if(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = true; 
			if(document.forms[0].ack_hod_co_ord_desc){
				document.forms[0].ack_hod_co_ord_desc.value=""; 					   
				document.forms[0].ack_hod_co_ord_desc.disabled = true;
			}
			if(document.forms[0].ack_hod_co_ord_id) document.forms[0].ack_hod_co_ord_id.value="";				
			if(document.forms[0].ack_hod_co_ord_search) document.forms[0].ack_hod_co_ord_search.disabled = true;				
			if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "hidden";
			
			
			if(document.forms[0].isMedicalTeamApplicable.value == "true")
			{ //added by mujafar for ML-MMOH-CRF-0716
				
				
					document.getElementById("medical_team_val_ack").options[0].selected=true;
					document.getElementById("medical_team_val_ack").disabled = true;
				
			}
				
			if(document.forms[0].inform_to_pract_desc){
				document.forms[0].inform_to_pract_desc.value=""; 					   
				document.forms[0].inform_to_pract_desc.disabled = true;
			}
			if(document.forms[0].inform_to_pract_id) document.forms[0].inform_to_pract_id.value="";				
			if(document.forms[0].inform_to_pract_search) document.forms[0].inform_to_pract_search.disabled = true;	
			if(document.getElementById("informtopract_img"))
			document.getElementById("informtopract_img").style.visibility = "hidden";	
        
		    document.getElementById("cancelby_medical_report").innerText = getLabel("Common.cancelledby.label","Common");
			document.getElementById("cancelby_med_rep_user").innerText = document.forms[0].loginUser.value;
			//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108
			//document.getElementById("cancelon_medical_report").innerText = getLabel("Common.cancelled.label","Common")+" "+getLabel("Common.on.label","Common");
			document.getElementById("cancelon_medical_report").innerText = getLabel("Common.CancelledOn.label","Common");
			//document.getElementById("cancelondate_medical_report").innerText = document.forms[0].sysdate.value;		
			document.getElementById("cancelondate_medical_report").innerText = getCurrentDate("DMYHM","en");
			
			document.getElementById("cancel_medrep_reason").innerText = getLabel("Common.ReasonforCancellation.label","Common");
			if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").style.visibility = "visible";
			document.getElementById("cancel_medical_rep_reason_img").style.visibility = "visible";
			
			if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="Y";
			
				
		}if(document.forms[0].cancel_medical_report && document.forms[0].cancel_medical_report.checked==false){
		    if(document.forms[0].remarks) document.forms[0].remarks.disabled = false;			
			if(document.forms[0].status)  document.forms[0].status.disabled = false;
			
			if(document.forms[0].status_imag){ 
				document.getElementById("status_imag").style.visibility = "visible"; 				
			}	
			if(document.forms[0].status && document.forms[0].status.value=="A" || document.forms[0].status && document.forms[0].status.value=="S"){ // modified by mujafar for ML-MMOH-CRF-0718
			if(document.forms[0].fwd_pract_desc) document.forms[0].fwd_pract_desc.disabled = false;
			if(document.forms[0].fwd_practitioner_id) document.forms[0].fwd_practitioner_id.value="";				
			if(document.forms[0].fwd_pract_id_search) document.forms[0].fwd_pract_id_search.disabled = false; 
			if(document.forms[0].ack_hod_co_ord_desc) document.forms[0].ack_hod_co_ord_desc.disabled = false;   
			
			if(document.forms[0].isMedicalTeamApplicable.value == "true")
			{ //added by mujafar for ML-MMOH-CRF-0716
				
				
					document.getElementById("medical_team_val_ack").options[0].selected=true;
					document.getElementById("medical_team_val_ack").disabled = false;
				
			}
			if(document.forms[0].ack_hod_co_ord_id) document.forms[0].ack_hod_co_ord_id.value="";				
			if(document.forms[0].ack_hod_co_ord_search) document.forms[0].ack_hod_co_ord_search.disabled = false;				
			if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "visible";				
			if(document.forms[0].inform_to_pract_desc) document.forms[0].inform_to_pract_desc.disabled = false; 					   
			if(document.forms[0].inform_to_pract_id) document.forms[0].inform_to_pract_id.value="";				
			if(document.forms[0].inform_to_pract_search) document.forms[0].inform_to_pract_search.disabled = false;
			if(document.getElementById("informtopract_img"))
			document.getElementById("informtopract_img").style.visibility = "visible";
			if(document.forms[0].status && document.forms[0].status.value=="S" && document.forms[0].isSelfStatusMRPApplicable.value == "true")
			{ // added by mujafar for ML-MMOH-CRF-0718 
			var loginID=document.forms[0].loginUserID.value;
			if(loginID!="")
			getSelfPractitioner(loginID);	
			}
				
			}
			if(document.forms[0].img_remarks && document.forms[0].status && document.forms[0].status.value=="R"){ 
				document.getElementById("img_remarks").style.visibility = "visible"; 				
		    }
			// Added by Shaik Mujafar for ML-MMOH-CRF-0713 start
			if(document.forms[0].isRejectRequestApplicable.value=="true" && document.forms[0].reject_medical_rep_reason && document.forms[0].status.value=="R"){
					
				document.forms[0].reject_medical_rep_reason.disabled = false;
				document.forms[0].reject_medical_rep_reason_img.style.visibility = "visible";
			}	
			// end
			document.getElementById("cancelby_medical_report").innerText = "";
			document.getElementById("cancelby_med_rep_user").innerText = "";
			document.getElementById("cancelon_medical_report").innerText = "";
			document.getElementById("cancelondate_medical_report").innerText = "";
			document.getElementById("cancel_medrep_reason").innerText = "";
			if(document.getElementById("cancel_medical_rep_reason"))document.getElementById("cancel_medical_rep_reason").options[0].selected=true;
			document.getElementById("cancel_medical_rep_reason").style.visibility = "hidden";
			document.getElementById("cancel_medical_rep_reason_img").style.visibility = "hidden";

            if(document.forms[0].medRequestChkbox) document.forms[0].medRequestChkbox.value="N"; 			
			
		}
	}
}
//End this CRF ML-MMOH-CRF-0712 
</script>
</head>
<%//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Statement appl_typeStmt = null;
	ResultSet appl_typeRS = null;

	Statement oth_stmt = null;
	ResultSet oth_rset = null;
	StringBuffer sqlBuff=new StringBuffer();
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	String medrep_pay_int_mode = "X";
	
	String no_of_days = "";
	String SystemDate		= "";
	String SystemDate_display = "";
	String disable1="";
	Boolean isIncompReqCancelApplicable = false;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	Boolean   isRejectRequestApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	Boolean isMedicalReportDurationAppl = false; //  Added by Shaik Mujafar for ML-MMOH-CRF-0704

	Boolean isChckLstApplicable = false; //Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708
	
	Boolean isMedicalReportRequest = false; //Added for this CRF ML-MMOH-CRF-0712
	
	Boolean isSelfStatusMRPApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0718
	Boolean isRejectReportApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0714
	Boolean isMedicalTeamApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0716	
	boolean increasedaddressLength = false; //Added for this CRF ML-MMOH-CRF-0860.2
	Boolean classification_appl_yn = false; //Added for this CRF ML-MMOH-CRF-0762
	Boolean isAcceptRequestByPractAppl = false; // added by mujafar for ML-MMOH-CRF-1315
	/*Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 Start*/
	String mr_hdr_line7 = "";
	boolean isOurRefApplicable = false; 
	String ourRefDtlsDisp		= "";
	/*Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 End*/
	/*Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454 Start*/
	boolean isSpecialtyDefaultApp	= false;
	String specialtyCodeMedicalTeam	= "";
	String specialtyEffStatus		= "";
	String specialtyMRApplYN		= "";
	/*Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454 End*/
	String delivery_remarks		= "";//Added By Dharma on 15th Apr 2020 against  ML-MMOH-CRF-1314
	int tot_amount				= 0;
	boolean isRequestorAddrDispApp	= false;//Added By Dharma on 13th Dec 2019 against  ML-MMOH-CRF-1362
	
	//Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905
	boolean isOutstandingAmtMedRepAppl = false;
	String bl_install_yn = checkForNull((String)session.getValue("bl_operational"));
	double outst_amt = 0;
	String outst_amt1 = "0";

	//Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906
	Boolean isPatDtlMedRepAppl = false;
	String patt_name		= "";
	String patient_gender	= "";
	String patient_age		= "";
    String genderdesc		= "";

try 
{
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isMedicalReportDurationAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","HOLIDAY_DURATION"); //  Added by Shaik Mujafar for ML-MMOH-CRF-0704
	isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isSelfStatusMRPApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MRP_STATUS_SELF"); //Added by Shaik Mujafar for ML-MMOH-CRF-0718
	isRejectReportApplicable =     eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //  Added by Mujafar for ML-MMOH-CRF-0714
	isChckLstApplicable = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHCKLST_TRANS_MODE_MED_REPORT");//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	isMedicalTeamApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MEDICAL_TEAM_APPLICABLE"); //Added by Shaik Mujafar for ML-MMOH-CRF-0716
	classification_appl_yn =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","CLASSIFICATION_APPL_YN"); // added by mujafar for ML-MMOH-CRF-0762 start
	isOurRefApplicable =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","OUR_REF_APPL_YN"); //Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
	isRequestorAddrDispApp =   eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_REQUESTOR_ADDR_DISPLAY_YN"); //Added By Dharma on 13th Dec 2019 against  ML-MMOH-CRF-1362
	String next_of_kin_name = "";
	isSpecialtyDefaultApp	= 	eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MR_SPECIALTY_DEF_APPL_YN"); //Added By Dharma on 4th Dec 2019 against  ML-MMOH-CRF-1454
	String next_of_kin_relation_code=""; // added by mujafar for ML-MMOH-CRF-0762
	String next_of_kin_nat_id_no= "";
	String oth_alt_id_type="";
	String oth_alt_id_no="";
	String next_of_kin_alt_id_type = "";
	String next_of_kin_alt_id_no = ""; // added by mujafar for ML-MMOH-CRF-0762 end
	
	isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ACCEPT_REJECT_BY_PRACT_APPL"); // added by mujafar for ML-MMOH-CRF-1315
	
	
	//Below line added for this CRF ML-MMOH-CRF-0712
	isMedicalReportRequest = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CANCEL_MEDICAL_REQUEST");	
	
	//Added for this CRF ML-MMOH-CRF-0860.2
    increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");

	isOutstandingAmtMedRepAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","OUTSTANDING_AMT_MED_REP"); //Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905
	
	/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
	JSONArray TransApplModeJsonArr = new JSONArray();
	TransApplModeJsonArr  = eMR.MRCommonBean.getTransModeListForApplMode(con);

	JSONArray TransCollModeJsonArr = new JSONArray();
	TransCollModeJsonArr  = eMR.MRCommonBean.getTransModeListForCollMode(con);	
	
	JSONArray TransNotifiModeJsonArr = new JSONArray();
	TransNotifiModeJsonArr  = eMR.MRCommonBean.getTransModeListForNotifiMode(con);
	/*ML-MMOH-CRF-0708 End*/	
	String params		= request.getQueryString();

	String PatientId	= checkForNull(request.getParameter("PatientId"));

	//Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906
	isPatDtlMedRepAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MR", "DIS_PATDTL_MEDREP_FUN");
	JSONObject Json	= eMR.MRCommonBean.getPatDtlMedRep(con,locale,PatientId);
	patt_name = (String) Json.get("patient_name");
	patient_gender = (String) Json.get("patient_gender");
	patient_age = (String) Json.get("patient_age");
	

	/*Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905*/
	if(bl_install_yn.equals("Y"))
	{
		BLFunctionalValidation blFunction = new BLFunctionalValidation();
		Hashtable blData = new Hashtable();
		blData.put("patient",PatientId);
		blData.put("facilityid",Facility_Id);
		blData.put("bl_install_yn",bl_install_yn);
		blData.put("bl_interface_yn",'Y');
		Hashtable blResult = blFunction.billPatientService(propertiesBill,con,blData); 

		if (blResult != null)
			outst_amt = ((Float)blResult.get("outst_amt")).floatValue();
		else
			outst_amt = 0;
				
		blFunction = null;
		blData.clear();
		blResult.clear();
		
		outst_amt1 = ""+outst_amt;
		CurrencyFormat cf1 = new CurrencyFormat();
		outst_amt1 = cf1.formatCurrency(outst_amt1, 2);
	}
	/*End ML-MMOH-CRF-1905*/

	try
	{	
		
		String mrParamSql = " select mr_hdr_line7,medrep_pay_int_mode, to_char(sysdate,'dd/mm/yyyy hh24:mi')SystemDate from MR_PARAMETER ";
		if (rs != null) rs.close();

		rs	=	stmt.executeQuery(mrParamSql);
		if (rs.next() && rs != null)
		{
			medrep_pay_int_mode = rs.getString("medrep_pay_int_mode");
			SystemDate = rs.getString("SystemDate");
			ourRefDtlsDisp	= checkForNull(rs.getString("mr_hdr_line7"));
			if(!ourRefDtlsDisp.equals("")){
				ourRefDtlsDisp	= ourRefDtlsDisp+"-"+PatientId;
			}
		}
		
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in MR_PARAMETER Query : "+e);
		e.printStackTrace();
	}

	
	
	//String patientId	= checkForNull(request.getParameter("patientId"));

	
	String encounterid	= checkForNull(request.getParameter("encounter_id"));
	String LastDet	= checkForNull(request.getParameter("LastDet"));
	//String call_function	= checkForNull(request.getParameter("call_function"));



	String new_func_id	= checkForNull(request.getParameter("new_func_id"));
	String finalSelect	= checkForNull(request.getParameter("finalSelect"));
	//String chkSelect	= checkForNull(request.getParameter("chkSelect"));
	String request_id	= checkForNull(request.getParameter("request_id"));

	

	String selitem		= checkForNull(request.getParameter("selitem"));
	String from			= checkForNull(request.getParameter("from"));

	String to			= checkForNull(request.getParameter("to"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String call_function= checkForNull(request.getParameter("call_function"));
	String dis = "";
	String disabled = "";
	
	String dis_req = ""; // added by mujafar for ML-MMOH-CRF-0762
	
	SystemDate_display = DateUtils.convertDate(SystemDate,"DMYHM","en",locale);
	if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD")  || call_function.equals("REQUEST_RETURNED")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		dis = "";
	else
		dis = "disabled";
	
	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708	
	String disableModes = "";
	if(call_function.equals("MEDICAL_REPORT_COMPLETED"))
	{
		disableModes = "disabled";
	}else{
		disableModes = "";
	}

	String disabledAttribute = "";
	if(call_function.equals("MEDICAL_REPORT_REQUEST") || call_function.equals("MEDICAL_REPORT_STATUS"))
		disabledAttribute = "";
	else
		disabledAttribute = "disabled";

	if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		//disabled = "";
	      disable1 = "disabled";
	else
		//disabled = "disabled";
	    disable1 = "";
	
	/*Added By Dharma on Dec 8th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	//if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(!call_function.equals("MEDICAL_REPORT_REQUEST"))	
		disabled = "disabled";
	else
		 disabled = "";
	/*Added By Dharma on Dec 8th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
	
	/*Below line addded for this CRF ML-MMOH-CRF-0712*/
	  String visibility_img ="style='visibility:visible'";
	  if(isMedicalReportRequest && (call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD")) ){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	      visibility_img ="style='visibility:hidden'";
	  }
	//End this CRF ML-MMOH-CRF-0712
	
	String addr_line1 = "";			String addr_line2 = "";
	String addr_line3 = "";			String addr_line4 = "";
	String res_town_code = "";		String res_town_desc = "";
	String res_area_code = "";		String res_area_desc = "";
	String region_code = "";		String region_desc = "";
	String postal_code = "";		
	String res_country_desc = "";
	String res_country_code = "";	String mail_addr_line1 = "";
	String mail_addr_line2 = "";	String mail_addr_line3 = "";
	String mail_addr_line4 = "";	String mail_res_town_code = "";
	String mail_res_town_desc = "";	String mail_res_area_code = "";
	String mail_res_area_desc = "";	String mail_postal_code = "";
	String mail_region_code = "";	String mail_region_desc = "";
	String mail_country_code = "";	String mail_country_desc = "";
	String contact1_no = "";		
	String contact2_no = "";
	String email = "";


	/*ADDRESS for NKIN*/
	String nkin_addr_line1 = ""; 	String nkin_addr_line2 = ""; 
	String nkin_addr_line3 = ""; 	String nkin_addr_line4 = ""; 
	String nkin_res_town_desc = ""; String nkin_res_town_code = ""; 
	String nkin_res_area_desc = ""; String nkin_res_area_code = ""; 
	String nkin_region_desc = ""; 	String nkin_region_code = ""; 
	String nkin_postal_code = ""; 	String nkin_country_desc = ""; 
	String nkin_country_code = ""; 	
	/*ADDRESS for FTON*/
	String fton_addr_line1 = ""; 	String fton_addr_line2 = ""; 
	String fton_addr_line3 = ""; 	String fton_addr_line4 = ""; 
	String fton_res_town_desc = ""; String fton_res_town_code = ""; 
	String fton_res_area_desc = ""; String fton_res_area_code = ""; 
	String fton_region_desc = ""; 
	String fton_region_code = ""; 	String fton_postal_code = ""; 
	String fton_country_desc = ""; 	String fton_country_code = ""; 
	/*ADDRESS for EMPLR*/
	String emplr_addr_line1 = ""; 	String emplr_addr_line2 = ""; 
	String emplr_addr_line3 = ""; 	String emplr_addr_line4 = ""; 
	String emplr_res_town_desc = "";String emplr_res_town_code = ""; 
	String emplr_res_area_desc = "";String emplr_res_area_code = ""; 
	String emplr_region_desc = ""; 	String emplr_region_code = ""; 
	String emplr_postal_code = ""; 	String emplr_country_desc = ""; 
	String emplr_country_code = ""; 	
	//Maheshwaran K added for the ML-MMOH-CRF-0391
	String forwarded_hod_cord_id="";
	String forwarded_hod_cord_date="";
	String forwarded_hod_cord_name = "";
	String inform_hod_cord_id="";
	String forwarded_medical_team=""; //added by mujafar for ML-MMOH-CRF-0716
	String forwarded_medical_team_desc = ""; //added by mujafar for ML-MMOH-CRF-0710
	String inform_medical_team=""; //added by mujafar for ML-MMOH-CRF-0716
	String inform_hod_cord_name="";
	String PREPARE_PRACT_NAME="";
	String accept_national_id_no_yn	= "";
	String accession_num	= "";	
	String alt_id1_no		= "";
	String alt_id1_type		= "";	
	String CollectDate		= "";
	String CollectDate_Converted = "";
	String Medical_members	= "";	
	String nat_id_prompt	= "";	
	String nat_id_length    = ""; // added by mujafar for ML-MMOH-CRF-0762 start
	String accept_oth_alt_id_yn = "";
	StringBuffer sqlAlt = new StringBuffer(); // added by mujafar for ML-MMOH-CRF-0762 end
	String national_id_no	= "";
	String Pat_name			= "";
	String patient_name		= "";	
	String pract_code		= "";
	String Pract_name		= "";	
	String prepareDate		= "";
	String prepareDate_Converted = "";
	String RecdDate			= "";
	String RecdDate_Converted = "";
	String remarks			= "";
	String remarks_hod = ""; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	String remarks_pract = "";
	String Pract_Assign_Date="";
	String reqDate			= "";
	String reqDate_converted= "";
	String Request_desc		= "";
	String requestor_code	= "";	
	String revised_collect_date = "";
	String revised_collect_date_converted = "";
	String team_code		= "";	
	String team_desc		= "";

	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

	String self_contact_no1		= "";
	String self_contact_no2		= "";
	String self_appl_email_id	= "";

	String nkin_contact_no1		= "";
	String nkin_contact_no2		= "";
	String nkin_appl_email_id	= "";

	String fton_contact_no1		= "";
	String fton_contact_no2		= "";
	String fton_appl_email_id	= "";

	String emplr_contact_no1	= "";
	String emplr_contact_no2	= "";

	/*ML-MMOH-CRF-0707*/

/********************************************************************/
//VALUES TO BE FETCHED FORM HDR_VW AND ASSIGN TO FIELDS...
/********************************************************************/
	String relationship_type	= ""; 		
	String relationship_code	= "";		String requestor_desc		= ""; 
	String appl_type_code		= ""; 		String appl_no				= ""; 
	String applicant_name		= ""; 		String application_date		= ""; 
	String cons_letter			= ""; 		String application_ref_no	= ""; 
	String for_attn_of			= ""; 		String report_type_code		= ""; 
	String specialty_code		= ""; 		String indicator			= ""; 
	String requestor_type_ind = ""; // added by mujafar for ML-MMOH-CRF-0762
	String required_docs		= ""; 		String appl_completion_date	= ""; 
	String forwarded_pract_name = "";		String requesting_pract_name= "";
	String forwarded_pract_id   = "";		String requesting_pract_id  = "";
	String event_status			= "";		String amount				= "";
	String receipt_no			= "";		String receipt_date			= "";
	String addl_amount			= "";		String addl_receipt_no		= "";
	String addl_receipt_date	= "";		String charges_appl_yn		= "N";
	String addl_charges_yn		= "N";		String ca_install_yn		= "";
	String delivered_date		= "";		String applSubmissionDate	= "";
	String posted_date			= "";		String dispatch_mode		= "";
	String sec_file_no			= "";		String report_taken_by		= "";
	String rtb_national_id_no	= "";		String rtb_alt_id_type		= "";
	String rtb_alt_id__no		= "";		String receipt_date_converted = "";
	String addl_receipt_date_converted = "";String delivered_date_converted = "";
	
	String pat_national_id_no=""; // added by mujafar for ML-MMOH-CRF-0762 start
	String next_of_nat_id_no = "";
	String pat_other_alt_id_type = "";
	String pat_other_alt_id_no = "";
	String next_of_other_alt_id_type = "";
	String next_of_other_alt_id_no = "";
	String classification_ind = "";
	int count = 0;
			String		nat_id = "";
			String		oth_alt_type="";
			String		oth_alt_id = ""; // added by mujafar for ML-MMOH-CRF-0762 end
	
	/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
	String cancelledDate	= "";
	String cancelledBy		= "";
	String cancelledReason	= "";
	String loginUserName	= "";
	String req_status		= "";
	/*End*/

	/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
	String applicationMode	= "";
	String collectionMode	= "";
	String notificationMode	= "";
	/*ML-MMOH-CRF-0708 End*/

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	String requestor_type_desc	= "";

	/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	String chklst_payment				= "N";
	String chklst_consent_fr_embsy		= "N";
	String chklst_stat_dec				= "N";
	String chklst_marital_cert			= "N";
	String chklst_consent_fr_pat		= "N";
	String chklst_ident_doc				= "N";
	String ack_hod_cord_id				= "";  
	String ack_medical_team =""; //added by mujafar for ML-MMOH-CRF-0716
	String ack_hod_cord_name			= "";
	String inform_to_pract_id			= "";
	String inform_to_pract_name			= "";
	String specialty_short_desc			= "";
	/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/

	/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
	String	collection_date				= "";
	/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
	
	// added by mujafar for ML-MMOH-CRF-0762 start
		String check_list1_status = "N";
		String check_list2_status = "N";
		String check_list3_status= "N";
		String check_list4_status= "N";
		String check_list5_status= "N";
		String check_list6_status= "N";
		String check_list7_status= "N";
		String check_list8_status= "N";
		String check_list9_status= "N";
		String check_list10_status= "N";
		//Added by Kamatchi S for ML-MMOH-CRF-1464 start
		String check_list11_status= "N";
		String check_list12_status= "N";
		String check_list13_status= "N";
		String check_list14_status= "N";
		String check_list15_status= "N";
		String check_list16_status= "N";
		String check_list17_status= "N";
		String check_list18_status= "N";
		String check_list19_status= "N";
		String check_list20_status= "N";
		String check_list21_status= "N";
		String check_list22_status= "N";
		String check_list23_status= "N";
		String check_list24_status= "N";
		String check_list25_status= "N";
		//Added by Kamatchi S for ML-MMOH-CRF-1464 end
		JSONObject jsonObj1 = eMR.MRCommonBean.getCheckListStatus(con,PatientId,request_id,Facility_Id);
		//below lines modified for ML-MMOH-CRF-1464 by Kamatchi S
		check_list1_status = checkForNull(((String) jsonObj1.get("check_list1_status")),"N");
		check_list2_status = checkForNull(((String) jsonObj1.get("check_list2_status")),"N");
		check_list3_status = checkForNull(((String) jsonObj1.get("check_list3_status")),"N");
		check_list4_status = checkForNull(((String) jsonObj1.get("check_list4_status")),"N");
		check_list5_status = checkForNull(((String) jsonObj1.get("check_list5_status")),"N");
		check_list6_status = checkForNull(((String) jsonObj1.get("check_list6_status")),"N");
		check_list7_status = checkForNull(((String) jsonObj1.get("check_list7_status")),"N");
		check_list8_status = checkForNull(((String) jsonObj1.get("check_list8_status")),"N");
	    check_list9_status = checkForNull(((String) jsonObj1.get("check_list9_status")),"N");
        check_list10_status= checkForNull(((String) jsonObj1.get("check_list10_status")),"N");
		//Added by Kamatchi S for ML-MMOH-CRF-1464 Start
        check_list11_status= checkForNull(((String) jsonObj1.get("check_list11_status")),"N");
        check_list12_status= checkForNull(((String) jsonObj1.get("check_list12_status")),"N");
		check_list13_status= checkForNull(((String) jsonObj1.get("check_list13_status")),"N");
        check_list14_status= checkForNull(((String) jsonObj1.get("check_list14_status")),"N");
        check_list15_status= checkForNull(((String) jsonObj1.get("check_list15_status")),"N");
        check_list16_status= checkForNull(((String) jsonObj1.get("check_list16_status")),"N");
        check_list17_status= checkForNull(((String) jsonObj1.get("check_list17_status")),"N");
        check_list18_status= checkForNull(((String) jsonObj1.get("check_list18_status")),"N");
        check_list19_status= checkForNull(((String) jsonObj1.get("check_list19_status")),"N");
        check_list20_status= checkForNull(((String) jsonObj1.get("check_list20_status")),"N");
        check_list21_status= checkForNull(((String) jsonObj1.get("check_list21_status")),"N");
        check_list22_status= checkForNull(((String) jsonObj1.get("check_list22_status")),"N");
        check_list23_status= checkForNull(((String) jsonObj1.get("check_list23_status")),"N");
        check_list24_status= checkForNull(((String) jsonObj1.get("check_list24_status")),"N");
        check_list25_status= checkForNull(((String) jsonObj1.get("check_list25_status")),"N");
		//Added by Kamatchi S for ML-MMOH-CRF-1464 end
		//Commented for ML-MMOH-CRF-1464
		/*if(check_list1_status == null || check_list1_status.equals("")) check_list1_status = "N"; 
		if(check_list2_status == null || check_list2_status.equals("")) check_list2_status = "N"; 
		if(check_list3_status == null || check_list3_status.equals("")) check_list3_status = "N"; 
		if(check_list4_status == null || check_list4_status.equals("")) check_list4_status = "N"; 
		if(check_list5_status == null || check_list5_status.equals("")) check_list5_status = "N"; 
		if(check_list6_status == null || check_list6_status.equals("")) check_list6_status = "N"; 
		if(check_list7_status == null || check_list7_status.equals("")) check_list7_status = "N"; 
		if(check_list8_status == null || check_list8_status.equals("")) check_list8_status = "N"; 
		if(check_list9_status == null || check_list9_status.equals("")) check_list9_status = "N"; 
		if(check_list10_status == null || check_list10_status.equals("")) check_list10_status = "N"; */

	try
	{	
		String CAinstall = " select install_yn FROM SM_MODULE WHERE module_id = 'CA' ";
		stmt = con.createStatement();
		rs	=	stmt.executeQuery(CAinstall);

		if ((rs != null) && (rs.next()))
		{
			ca_install_yn = rs.getString("install_yn");
			if(ca_install_yn == null) ca_install_yn ="N";
			
		}
		if(rs	 != null)   rs.close();
		if(stmt	 != null)   stmt.close();

		if(call_function.equals("ACCEPTED_BY_PRACTITIONER")||call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT"))
		{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
			sqlBuff.append("select a.EVENT_STATUS, a.ACCESSION_NUM from CA_ENCNTR_NOTE a ");
			sqlBuff.append(" where a.patient_id='"+PatientId+"' and a.ACCESSION_NUM= ");
			sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
			sqlBuff.append("facility_id='"+Facility_Id+"' and patient_id ='"+PatientId+"'");
			sqlBuff.append(" and REQUEST_ID ='"+request_id+"')");

			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlBuff.toString());
			if (rs.next() && rs != null)
			{
				accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
				event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
			}
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 1 : "+e);
		e.printStackTrace();
	}
	try
	{
		if(!request_id.equals(""))
		{
			if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());

			sqlBuff.append(" SELECT ");
			sqlBuff.append("		Addl_Amount,");
			sqlBuff.append("        Addl_Charges_yn,");
			sqlBuff.append("        Addl_Receipt_No,");
			sqlBuff.append("        Am_Get_desc.Am_medical_team(Prepare_Team_Id,'"+Facility_Id+"','"+locale+"','1') Team_Short_desc,");
			sqlBuff.append("        Am_Get_desc.Am_practitioner(Forwarded_prAct_Id,'"+locale+"','1') Forwarded_prAct_Name,");
			sqlBuff.append("        Am_Get_desc.Am_practitioner(RequestIng_prAct_Id,'"+locale+"','1') RequestIng_prAct_Name,");
			sqlBuff.append("        Specialty_Code,Am_Get_desc.Am_speciality(Specialty_Code,'"+locale+"','1') Specialty_Short_desc,");
			if(isSpecialtyDefaultApp){
				
				sqlBuff.append(" (SELECT eff_status FROM am_speciality WHERE speciality_code = SPECIALTY_CODE ) specialtyEffStatus, ");
				sqlBuff.append(" (SELECT MR_APPL_YN FROM am_speciality WHERE speciality_code = SPECIALTY_CODE ) specialtyMRApplYN, ");
			}
			
			sqlBuff.append("        Amount,");
			sqlBuff.append("        Applicant_Name,");
			sqlBuff.append("        Application_ref_No,");
			sqlBuff.append("        Charges_apPl_yn,");
			sqlBuff.append("        Consent_Letter_apPl,");
			sqlBuff.append("        Dispatch_Mode, ");
			sqlBuff.append("        For_Attn_Of,");
			sqlBuff.append("        Forwarded_prAct_Id,");
			sqlBuff.append("        Patient_Name,");
			sqlBuff.append("        Prepare_Team_Id,");
			sqlBuff.append("        Prepare_prAct_Id,");
			sqlBuff.append("        Receipt_No,");
			sqlBuff.append("        Relationship_Code,");
			sqlBuff.append("        Relationship_Type,");
			sqlBuff.append("        Remarks,");
			sqlBuff.append("        remarks_hod,"); // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			sqlBuff.append("        remarks_pract,");
			
			sqlBuff.append("        To_char(PRACT_ASSIGN_DATE,'dd/mm/yyyy hh24:mi') Pract_Assign_Date,");
			
			
			sqlBuff.append("        Report_Taken_By,");
			sqlBuff.append("        Report_Type_Code,");
			sqlBuff.append("        RequestIng_prAct_Id,");
			sqlBuff.append("        a.RequestOr_Code,");
			sqlBuff.append("    MR_GET_DESC.MR_REQUESTOR('"+Facility_Id+"',a.RequestOr_Code,'"+locale+"','2')requestor_short_desc,");
			sqlBuff.append("        Required_Docs,");
			sqlBuff.append("        To_char(Addl_Receipt_Date,'dd/mm/yyyy hh24:mi') Addl_Receipt_Date,");
			sqlBuff.append("        To_char(Application_Date,'dd/mm/yyyy hh24:MI') Application_Date,");
			sqlBuff.append("        To_char(Collect_Date,'dd/mm/yyyy hh24:mi') Collect_Date,");
			sqlBuff.append("        To_char(Delivered_Date,'dd/mm/yyyy hh24:mi') Delivered_Date,");
			sqlBuff.append("        To_char(Posted_Date,'dd/mm/yyyy hh24:mi') Posted_Date,");
			sqlBuff.append("        To_char(Prepared_Date,'dd/mm/yyyy hh24:mi') Prepared_Date,");
			sqlBuff.append("        To_char(Receipt_Date,'dd/mm/yyyy hh24:mi') Receipt_Date,");
			sqlBuff.append("        To_char(Received_Date,'dd/mm/yyyy hh24:mi') Received_Date,");
			sqlBuff.append("        To_char(Request_Date,'dd/mm/yyyy hh24:mi') Request_Date,");
			sqlBuff.append("        To_char(Revised_Collect_Date,'dd/mm/yyyy hh24:mi') Revised_Collect_Date,");
			sqlBuff.append("        To_char(apPl_Completion_Date,'dd/mm/yyyy hh24:mi') apPl_Completion_Date,");
			sqlBuff.append("        To_char(apPl_Submitted_Date,'dd/mm/yyyy hh24:mi') apPlSubmissionDate,");
			sqlBuff.append("        Trunc(Nvl(Delivered_Date,SYSDATE) - Received_Date) Delivered,");
			sqlBuff.append("        Trunc(Prepared_Date - apPl_Completion_Date) No_Of_Days,");
			/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
			sqlBuff.append("        To_char(cancelled_date,'dd/mm/yyyy hh24:mi') cancelled_date,");
			sqlBuff.append("        cancel_reason_code, sm_get_desc.sm_appl_user(cancelled_by,'"+locale+"','1') cancelled_by,");
			sqlBuff.append("        sm_get_desc.sm_appl_user('"+loginUser+"','"+locale+"','1') loginUserName,");
			/*End*/
			/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
			sqlBuff.append("        application_mode,");
			sqlBuff.append("        collection_mode,");
			sqlBuff.append("        notification_mode,");
			/*ML-MMOH-CRF-0708 End*/
			sqlBuff.append("        apPl_No,");
			sqlBuff.append("        apPl_Type_Code,");
			/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
			sqlBuff.append("        c.indicator, (select long_desc from mr_requestor_type where REQUESTOR_TYPE_CODE = c.indicator) indicator_desc,a.REQUESTOR_TYPE_IND,(select CLASSIFICATION_IND from mr_requestor_type WHERE requestor_type_code = A.REQUESTOR_TYPE_IND )classification_ind,NATIONAL_ID_NO,NEXT_NATIONAL_ID_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO,NEXT_OTH_ALT_ID_TYPE,NEXT_OTH_ALT_ID_NO, "); // added by mujafar for ML-MMOH-CRF-0762
			sqlBuff.append("        rtb_national_id_no,");
			sqlBuff.append("        rTb_alt_Id_Type,");
			sqlBuff.append("        rTb_alt_Id__No,");
			sqlBuff.append("        sec_File_No, ");
			//Maheshwarn K added for ML-MMOH-CRF-0391	
			sqlBuff.append("        FORWARDED_HOD_CORD_ID,	INFORM_HOD_CORD_ID,FORWARDED_MEDICAL_TEAM,(select SHORT_DESC from am_medical_team where FACILITY_ID= a.FACILITY_ID and team_id=a.forwarded_medical_team )forwarded_medical_team_desc,INFORM_MEDICAL_TEAM,to_char(FORWARDED_HOD_CORD_DATE,'dd/mm/yyyy hh24:mi') FORWARDED_HOD_CORD_DATE, "); //added by mujafar for ML-MMOH-CRF-0716		
			sqlBuff.append("   (CASE   WHEN inform_hod_cord_id IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = inform_hod_cord_id) END ) inform_hod_cord_name , (CASE   WHEN forwarded_hod_cord_id IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = forwarded_hod_cord_id) END ) forwarded_hod_cord_name , (CASE   WHEN PREPARE_PRACT_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = PREPARE_PRACT_ID) END ) PREPARE_PRACT_NAME , ACK_HOD_CORD_ID,ACK_MEDICAL_TEAM,INFORM_TO_PRACT_ID, (CASE   WHEN ACK_HOD_CORD_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = ACK_HOD_CORD_ID) END ) ack_hod_cord_name, (CASE   WHEN INFORM_TO_PRACT_ID IS NOT NULL  THEN (SELECT practitioner_name   FROM am_practitioner  WHERE practitioner_id = INFORM_TO_PRACT_ID) END ) inform_to_pract_name ,");
			// ML-MMOH-CRF-0391 Ends
			sqlBuff.append("		chklst_consent_fr_pat, chklst_ident_doc, chklst_marital_cert, chklst_stat_dec, chklst_consent_fr_embsy,chklst_payment ");//Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157]
			sqlBuff.append(" ,OTHER_APPLICATION_REF_NO ");//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
			sqlBuff.append(" ,delivery_remarks ");//Added By Dharma on 15th Apr 2020 against ML-MMOH-CRF-1314
			sqlBuff.append(" ,(nvl(amount,0) + nvl(addl_amount,0)) tot_amount ");
			sqlBuff.append(" FROM ");
			sqlBuff.append(" MR_REPORT_REQUEST_HDR a, MR_REQUESTOR c ");
			sqlBuff.append(" WHERE  a.Facility_Id = '"+Facility_Id+"'");
			sqlBuff.append("        AND a.Patient_Id = '"+PatientId+"'");
			sqlBuff.append("        AND a.Request_Id = '"+request_id+"'");
			sqlBuff.append("        AND c.REQUESTOR_CODE (+) = a.REQUESTOR_CODE ");
			
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlBuff.toString());
			if (rs.next() && rs != null)
			{
				Request_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
				
				if(!(reqDate==null || reqDate.equals("")))
					reqDate_converted	= DateUtils.convertDate(reqDate,"DMYHM","en",locale);

				remarks					= checkForNull(rs.getString("REMARKS"));
				remarks_hod             = checkForNull(rs.getString("remarks_hod")); // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				remarks_pract             = checkForNull(rs.getString("remarks_pract"));
				Pract_Assign_Date = checkForNull(rs.getString("Pract_Assign_Date"));
				application_date		= checkForNull(rs.getString("application_date")); 
				if(!(application_date==null || application_date.equals("")))
				application_date		= DateUtils.convertDate(application_date,"DMYHM","en",locale);


				RecdDate				= checkForNull(rs.getString("RECEIVED_DATE")); 
				if(!(RecdDate==null || RecdDate.equals("")))
				RecdDate_Converted		= DateUtils.convertDate(RecdDate,"DMYHM","en",locale);

				revised_collect_date	= checkForNull(rs.getString("REVISED_COLLECT_DATE"));
				if(!(revised_collect_date==null || revised_collect_date.equals("")))
				revised_collect_date_converted= DateUtils.convertDate(revised_collect_date,"DMYHM","en",locale);

				prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
				if(!(prepareDate==null || prepareDate.equals("")))
				prepareDate_Converted= DateUtils.convertDate(prepareDate,"DMYHM","en",locale);

				team_desc				= checkForNull(rs.getString("TEAM_SHORT_DESC"));
				Pat_name				= checkForNull(rs.getString("PATIENT_NAME"));
				applSubmissionDate		= checkForNull(rs.getString("applSubmissionDate"));

				CollectDate				= checkForNull(rs.getString("COLLECT_DATE"));
				if(!(CollectDate==null || CollectDate.equals("")))
					CollectDate_Converted	= DateUtils.convertDate(CollectDate,"DMYHM","en",locale);

				/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
				cancelledDate			= checkForNull(rs.getString("cancelled_date"));
				cancelledBy				= checkForNull(rs.getString("cancelled_by"));
				cancelledReason			= checkForNull(rs.getString("cancel_reason_code"));
				loginUserName			= checkForNull(rs.getString("loginUserName"));
				/*End*/

				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				applicationMode			= checkForNull(rs.getString("application_mode"));
				collectionMode			= checkForNull(rs.getString("collection_mode"));
				notificationMode		= checkForNull(rs.getString("notification_mode"));
				/*ML-MMOH-CRF-0708 End*/
				
				appl_completion_date	= checkForNull(rs.getString("appl_completion_date"));
				team_code				= checkForNull(rs.getString("PREPARE_TEAM_ID"));
				pract_code				= checkForNull(rs.getString("PREPARE_PRACT_ID"));
				requestor_code			= checkForNull(rs.getString("REQUESTOR_CODE"));
				amount					= checkForNull(rs.getString("AMOUNT"));
				receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));

				receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
				if(!(receipt_date == null || receipt_date.equals("")))
				receipt_date_converted	= DateUtils.convertDate(receipt_date,"DMYHM","en",locale);

				addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
				addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));
				
				tot_amount				= rs.getInt("tot_amount");

				addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
				if(!(addl_receipt_date == null || addl_receipt_date.equals("")))
				addl_receipt_date_converted = DateUtils.convertDate(addl_receipt_date,"DMYHM","en",locale);

				charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"),"N");
				addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"),"N");
				relationship_type		= checkForNull(rs.getString("RELATIONSHIP_TYPE"));
				relationship_code		= checkForNull(rs.getString("RELATIONSHIP_CODE"));  
				requestor_desc			= checkForNull(rs.getString("REQUESTOR_SHORT_DESC"));
				appl_type_code			= checkForNull(rs.getString("APPL_TYPE_CODE"));
				appl_no					= checkForNull(rs.getString("APPL_NO"));
				applicant_name			= checkForNull(rs.getString("APPLICANT_NAME"));
				cons_letter				= checkForNull(rs.getString("CONSENT_LETTER_APPL"));
				application_ref_no		= checkForNull(rs.getString("APPLICATION_REF_NO"));
				for_attn_of				= checkForNull(rs.getString("FOR_ATTN_OF"));
				report_type_code		= checkForNull(rs.getString("REPORT_TYPE_CODE"));
				specialty_short_desc	= checkForNull(rs.getString("SPECIALTY_SHORT_DESC"));
				specialty_code			= checkForNull(rs.getString("Specialty_Code"));
				
				if(isSpecialtyDefaultApp){
					specialtyCodeMedicalTeam	= specialty_code;
					specialtyEffStatus	= checkForNull(rs.getString("specialtyEffStatus"));
					specialtyMRApplYN	= checkForNull(rs.getString("specialtyMRApplYN"));
					
				}
				
				indicator				= checkForNull(rs.getString("indicator"));
				/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
					requestor_type_ind= checkForNull(rs.getString("REQUESTOR_TYPE_IND")); // added by mujafar for ML-MMOH-CRF-0762 start
					
					JSONArray checkListJsonArr = new JSONArray();
					checkListJsonArr							= eMR.MRCommonBean.getChecklistValues(con,requestor_type_ind,requestor_code);
			
					 count = checkListJsonArr.size();
					
					
					
					pat_national_id_no= checkForNull(rs.getString("NATIONAL_ID_NO"));
					next_of_nat_id_no= checkForNull(rs.getString("NEXT_NATIONAL_ID_NO"));
					pat_other_alt_id_type= checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
					pat_other_alt_id_no= checkForNull(rs.getString("OTH_ALT_ID_NO"));
					next_of_other_alt_id_type= checkForNull(rs.getString("NEXT_OTH_ALT_ID_TYPE"));
					next_of_other_alt_id_no= checkForNull(rs.getString("NEXT_OTH_ALT_ID_NO"));
					classification_ind = checkForNull(rs.getString("classification_ind"));
					
					if(classification_appl_yn)
					{ 
					
						if(classification_ind.equals("N"))
						{
							nat_id = next_of_nat_id_no;
							oth_alt_type = next_of_other_alt_id_type;
							oth_alt_id = next_of_other_alt_id_no;
							
						}
						else
						if(classification_ind.equals("P"))
						{
							nat_id = pat_national_id_no;
							oth_alt_type=pat_other_alt_id_type;
							oth_alt_id = pat_other_alt_id_no;
							
						}
						
						
						if(call_function.equals("MEDICAL_REPORT_REQUEST") )
						dis_req = "";
						else
						dis_req = "disabled";
						
						
					
					}
					
					
					// added by mujafar for ML-MMOH-CRF-0762 end
					
					
					
					
				requestor_type_desc		= checkForNull(rs.getString("indicator_desc"));
				required_docs			= checkForNull(rs.getString("required_docs"));
							
				forwarded_pract_name	= checkForNull(rs.getString("FORWARDED_PRACT_NAME"));
				requesting_pract_name	= checkForNull(rs.getString("REQUESTING_PRACT_NAME"));
				forwarded_pract_id		= checkForNull(rs.getString("FORWARDED_PRACT_ID"));
				requesting_pract_id		= checkForNull(rs.getString("REQUESTING_PRACT_ID"));

				delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
				if(!(delivered_date == null || delivered_date.equals("")))
				delivered_date_converted = DateUtils.convertDate(delivered_date,"DMYHM","en",locale);

				posted_date				= checkForNull(rs.getString("POSTED_DATE"));
				if(!(posted_date == null || posted_date.equals("")))
					posted_date			= DateUtils.convertDate(posted_date,"DMYHM","en",locale);

				dispatch_mode			= checkForNull(rs.getString("DISPATCH_MODE"));
				sec_file_no				= checkForNull(rs.getString("SEC_FILE_NO"));
				report_taken_by			= checkForNull(rs.getString("REPORT_TAKEN_BY"));
				rtb_national_id_no		= checkForNull(rs.getString("RTB_NATIONAL_ID_NO"));
				rtb_alt_id_type			= checkForNull(rs.getString("RTB_ALT_ID_TYPE"));
				rtb_alt_id__no			= checkForNull(rs.getString("RTB_ALT_ID__NO"));
				no_of_days				= checkForNull(rs.getString("no_of_days"));

				/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
				chklst_consent_fr_pat	= checkForNull(rs.getString("chklst_consent_fr_pat"),"N");
				chklst_ident_doc		= checkForNull(rs.getString("chklst_ident_doc"),"N");
				chklst_marital_cert		= checkForNull(rs.getString("chklst_marital_cert"),"N");
				chklst_stat_dec			= checkForNull(rs.getString("chklst_stat_dec"),"N");
				chklst_consent_fr_embsy	=checkForNull(rs.getString("chklst_consent_fr_embsy"),"N");
				chklst_payment			= checkForNull(rs.getString("chklst_payment"),"N");
				ack_hod_cord_id			= checkForNull(rs.getString("ack_hod_cord_id"));
				ack_medical_team        = checkForNull(rs.getString("ack_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				ack_hod_cord_name		= checkForNull(rs.getString("ack_hod_cord_name"));
				ourRefDtlsDisp			 = checkForNull(rs.getString("OTHER_APPLICATION_REF_NO"));//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
				delivery_remarks		 = checkForNull(rs.getString("delivery_remarks"));//Added By Dharma on Apr 15th 2020 against ML-MMOH-CRF-1314
				inform_to_pract_id		= checkForNull(rs.getString("inform_to_pract_id"));
				inform_to_pract_name	= checkForNull(rs.getString("inform_to_pract_name"));
				/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
				//Maheshwaran K added for ML-MMOH-CRF-0391
				forwarded_hod_cord_date	= checkForNull(rs.getString("FORWARDED_HOD_CORD_DATE"));
				forwarded_hod_cord_id	= checkForNull(rs.getString("FORWARDED_HOD_CORD_ID"));
				forwarded_hod_cord_name	= checkForNull(rs.getString("FORWARDED_HOD_CORD_NAME"));
				inform_hod_cord_id	= checkForNull(rs.getString("INFORM_HOD_CORD_ID"));
				inform_hod_cord_name	= checkForNull(rs.getString("INFORM_HOD_CORD_NAME"));
				forwarded_medical_team = checkForNull(rs.getString("forwarded_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				forwarded_medical_team_desc = checkForNull(rs.getString("forwarded_medical_team_desc"));
				inform_medical_team = checkForNull(rs.getString("inform_medical_team")); //added by mujafar for ML-MMOH-CRF-0716
				PREPARE_PRACT_NAME	= checkForNull(rs.getString("PREPARE_PRACT_NAME"));
				
				
			}
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query 2 : "+e);
		e.printStackTrace();
	}

	try
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		
		String patSql=" select alt_id1_no, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, national_id_no, oth_alt_id_no, oth_alt_id_type from MP_PATIENT where patient_id='"+PatientId+"' ";


		stmt= con.createStatement();
		rs	= stmt.executeQuery(patSql);
		
		if(rs.next() && rs != null)
		{
			patient_name	= checkForNull(rs.getString("PATIENT_NAME"));
			national_id_no	= checkForNull(rs.getString("NATIONAL_ID_NO"));
			alt_id1_no		= checkForNull(rs.getString("ALT_ID1_NO"));
			oth_alt_id_type= checkForNull(rs.getString("oth_alt_id_type")); // added by mujafar for ML-MMOH-CRF-0762
			oth_alt_id_no  = checkForNull(rs.getString("oth_alt_id_no")); // added by mujafar for ML-MMOH-CRF-0762
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
	catch(Exception e) 
	{
		//out.println("Exception in Query 3 : "+e);
		e.printStackTrace();
	}

	try
	{
		String contactSql=" SELECT a.short_desc, b.nat_id_prompt,b.nat_id_length, b.accept_national_id_no_yn, b.alt_id1_type, b.accept_oth_alt_id_yn FROM MP_ALTERNATE_ID_TYPE_LANG_VW a , MP_PARAM b WHERE a.alt_id_type = b.alt_id1_type and b.module_id='MP' and a.language_id='"+locale+"' "; 

		stmt= con.createStatement();
		rs	= stmt.executeQuery(contactSql);

		if(rs.next() && rs != null)
		{
			nat_id_prompt			= checkForNull(rs.getString("nat_id_prompt"));
			accept_national_id_no_yn= checkForNull(rs.getString("accept_national_id_no_yn"));
			alt_id1_type			= checkForNull(rs.getString("short_desc"));
			nat_id_length           = checkForNull(rs.getString("nat_id_length")); // added by mujafar for ML-MMOH-CRF-0762
			accept_oth_alt_id_yn    = checkForNull(rs.getString("accept_oth_alt_id_yn")); // added by mujafar for ML-MMOH-CRF-0762
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 4 : "+e);
		e.printStackTrace();
	}

	try
	{
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
/*
		sqlBuff.append(" SELECT ");
		sqlBuff.append("		Contact1_Region_Code,");
		sqlBuff.append("        Contact1_res_Area_Code,");
		sqlBuff.append("        Contact1_res_Town_Code,");
		sqlBuff.append("        Contact2_Region_Code,");
		sqlBuff.append("        Contact2_res_Area_Code,");
		sqlBuff.append("        Contact2_res_Town_Code,");
		sqlBuff.append("        Contact3_Region_Code,");
		sqlBuff.append("        Contact3_res_Area_Code,");
		sqlBuff.append("        Contact3_res_Town_Code,");
		sqlBuff.append("        Mail_Addr_Line1,");
		sqlBuff.append("        Mail_Addr_Line2,");
		sqlBuff.append("        Mail_Addr_Line3,");
		sqlBuff.append("        Mail_Addr_Line4,");
		sqlBuff.append("        Mail_Country_Code,");
		sqlBuff.append("        Mail_Postal_Code,");
		sqlBuff.append("        Mail_Region_Code,");
		sqlBuff.append("        Mail_res_Area,");
		sqlBuff.append("        Mail_res_Town,");
		sqlBuff.append("        Orn_tel_No,");
		sqlBuff.append("        RESI_POSTAL_CODE,");
		sqlBuff.append("        Region_Code,");
		sqlBuff.append("        eMail_Id,");
		sqlBuff.append("        emPlr_Addr_Line1,");
		sqlBuff.append("        emPlr_Addr_Line2,");
		sqlBuff.append("        emPlr_Addr_Line3,");
		sqlBuff.append("        emPlr_Addr_Line4,");
		sqlBuff.append("        emPlr_Country_Code,");
		sqlBuff.append("        emPlr_Postal_Code,");
		sqlBuff.append("        fTon_Addr_Line1,");
		sqlBuff.append("        fTon_Addr_Line2,");
		sqlBuff.append("        fTon_Addr_Line3,");
		sqlBuff.append("        fTon_Addr_Line4,");
		sqlBuff.append("        fTon_Area_desc,");
		sqlBuff.append("        fTon_Country_Code,");
		sqlBuff.append("        fTon_Postal_Code,");
		sqlBuff.append("        mp_Get_desc.Mp_country(emPlr_Country_Code,'"+locale+"','2') emPlr_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(fTon_Country_Code,'"+locale+"','1') Mail_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(fTon_Country_Code,'"+locale+"','1') fTon_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(resi_Country_Code,'"+locale+"','2') nKin_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_country(resi_Country_Code,'"+locale+"','2') resi_Country_Name,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact1_Region_Code,'"+locale+"','2') nKin_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact2_Region_Code,'"+locale+"','2') fTon_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Contact3_Region_Code,'"+locale+"','2') emPlr_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Mail_Region_Code,'"+locale+"','2') Mail_Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_region(Region_Code,'"+locale+"','1') Region_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Contact1_res_Area_Code,'"+locale+"','2') nKin_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Contact3_res_Area_Code,'"+locale+"','2') emPlr_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(Mail_res_Area,'"+locale+"','2') Mail_res_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_area(res_Area_Code,'"+locale+"','2') res_Area_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact1_res_Town_Code,'"+locale+"','2') nKin_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact2_res_Town_Code,'"+locale+"','2') fTon_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Contact3_res_Town_Code,'"+locale+"','2') emPlr_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(Mail_res_Town,'"+locale+"','2') Mail_res_Town_desc,");
		sqlBuff.append("        mp_Get_desc.Mp_res_town(res_Town_Code,'"+locale+"','2') res_Town_desc,");
		sqlBuff.append("        nKin_Addr_Line1,");
		sqlBuff.append("        nKin_Addr_Line2,");
		sqlBuff.append("        nKin_Addr_Line3,");
		sqlBuff.append("        nKin_Addr_Line4,");
		sqlBuff.append("        nKin_Country_Code,");
		sqlBuff.append("        nKin_Postal_Code,");
		sqlBuff.append("        prn_tel_No,");
		sqlBuff.append("        res_Area_Code,");
		sqlBuff.append("        res_Town_Code,");
		sqlBuff.append("        resi_Addr_Line1,");
		sqlBuff.append("        resi_Addr_Line2,");
		sqlBuff.append("        resi_Addr_Line3,");
		sqlBuff.append("        resi_Addr_Line4,");
		sqlBuff.append("        resi_Country_Code");
		sqlBuff.append(" FROM ");
		sqlBuff.append("		MP_CHG_PAT_DTLS_VW");
		sqlBuff.append(" WHERE  ");
		sqlBuff.append("		Patient_Id = '"+patientId+"' ");
*/

		sqlBuff.append(" SELECT PAT_RL_CON.CONTACT1_RELATION next_of_kin_relation_code,PAT_RL_CON.CONTACT1_REGION_CODE,PAT_RL_CON.contact1_name next_of_kin_name,PAT_RL_CON.CONTACT1_NAT_ID_NO next_of_kin_nat_id_no,PAT_RL_CON.CONTACT1_OTH_ALT_ID_TYPE next_of_kin_alt_id_type,PAT_RL_CON.CONTACT1_OTH_ALT_ID_NO next_of_kin_alt_id_no ,PAT_RL_CON.CONTACT1_RES_AREA_CODE, PAT_RL_CON.CONTACT1_RES_TOWN_CODE, PAT_RL_CON.CONTACT2_REGION_CODE, PAT_RL_CON.CONTACT2_RES_AREA_CODE, PAT_RL_CON.CONTACT2_RES_TOWN_CODE, PAT_RL_CON.CONTACT3_REGION_CODE, PAT_RL_CON.CONTACT3_RES_AREA_CODE, PAT_RL_CON.CONTACT3_RES_TOWN_CODE, PAT_ADDR.ADDR2_LINE1 Mail_Addr_Line1, PAT_ADDR.ADDR2_LINE2 Mail_Addr_Line2, PAT_ADDR.ADDR2_LINE3 Mail_Addr_Line3, PAT_ADDR.ADDR2_LINE4 Mail_Addr_Line4, PAT_ADDR.COUNTRY2_CODE Mail_Country_Code, PAT_ADDR.POSTAL2_CODE Mail_Postal_Code, PAT_ADDR.REGION2_CODE Mail_Region_Code, PAT_ADDR.RES_AREA2_CODE Mail_res_Area, PAT_ADDR.RES_TOWN2_CODE Mail_res_Town, PATIENT.CONTACT2_NO Orn_tel_No, PAT_ADDR.POSTAL1_CODE RESI_POSTAL_CODE, PATIENT.REGION_CODE Region_Code, PATIENT.EMAIL_ID eMail_Id, PAT_RL_CON.ADDR3_LINE1 emPlr_Addr_Line1, PAT_RL_CON.ADDR3_LINE2 emPlr_Addr_Line2, PAT_RL_CON.ADDR3_LINE3 emPlr_Addr_Line3, PAT_RL_CON.ADDR3_LINE4 emPlr_Addr_Line4, PAT_RL_CON.COUNTRY3_CODE emPlr_Country_Code, PAT_RL_CON.POSTAL3_CODE emPlr_Postal_Code, PAT_RL_CON.ADDR2_LINE1 fTon_Addr_Line1, PAT_RL_CON.ADDR2_LINE2 fTon_Addr_Line2, PAT_RL_CON.ADDR2_LINE3 fTon_Addr_Line3, PAT_RL_CON.ADDR2_LINE4 fTon_Addr_Line4, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT2_RES_AREA_CODE, '"+locale+"', '1') fTon_Area_desc, PAT_RL_CON.COUNTRY2_CODE fTon_Country_Code, PAT_RL_CON.POSTAL2_CODE fTon_Postal_Code, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY3_CODE, '"+locale+"', '1') emPlr_Country_Name, mp_Get_desc.Mp_country(PAT_ADDR.COUNTRY2_CODE, '"+locale+"', '1') Mail_Country_Name, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY2_CODE, '"+locale+"', '1') fTon_Country_Name, mp_Get_desc.Mp_country(PAT_RL_CON.COUNTRY1_CODE, '"+locale+"', '2') nKin_Country_Name, mp_Get_desc.Mp_country(PAT_ADDR.COUNTRY1_CODE, '"+locale+"', '2') resi_Country_Name, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT1_REGION_CODE, '"+locale+"', '2') nKin_Region_desc, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT2_REGION_CODE, '"+locale+"', '2') fTon_Region_desc, mp_Get_desc.Mp_region(PAT_RL_CON.CONTACT3_REGION_CODE, '"+locale+"', '2') emPlr_Region_desc, mp_Get_desc.Mp_region(PAT_ADDR.REGION2_CODE, '"+locale+"', '2') Mail_Region_desc, mp_Get_desc.Mp_region(Region_Code, '"+locale+"', '1') Region_desc, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT1_RES_AREA_CODE, '"+locale+"', '2') nKin_Area_desc, mp_Get_desc.Mp_res_area(PAT_RL_CON.CONTACT3_RES_AREA_CODE, '"+locale+"', '2') emPlr_Area_desc, mp_Get_desc.Mp_res_area(PAT_ADDR.RES_AREA2_CODE, '"+locale+"', '2') Mail_res_Area_desc, mp_Get_desc.Mp_res_area(res_Area_Code, '"+locale+"', '2') res_Area_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT1_RES_TOWN_CODE, '"+locale+"', '1') nKin_Town_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT2_RES_TOWN_CODE, '"+locale+"', '2') fTon_Town_desc, mp_Get_desc.Mp_res_town(PAT_RL_CON.CONTACT3_RES_TOWN_CODE, '"+locale+"', '2') emPlr_Town_desc, mp_Get_desc.Mp_res_town(PAT_ADDR.RES_TOWN2_CODE, '"+locale+"', '2') Mail_res_Town_desc, mp_Get_desc.Mp_res_town(res_Town_Code, '"+locale+"', '2') res_Town_desc, PAT_RL_CON.ADDR1_LINE1 nKin_Addr_Line1, PAT_RL_CON.ADDR1_LINE2 nKin_Addr_Line2, PAT_RL_CON.ADDR1_LINE3 nKin_Addr_Line3, PAT_RL_CON.ADDR1_LINE4 nKin_Addr_Line4, PAT_RL_CON.COUNTRY1_CODE nKin_Country_Code, PAT_RL_CON.POSTAL1_CODE nKin_Postal_Code, PATIENT.CONTACT1_NO prn_tel_No, PATIENT.RES_AREA_CODE res_Area_Code, PATIENT.RES_TOWN_CODE res_Town_Code, PAT_ADDR.ADDR1_LINE1 resi_Addr_Line1, PAT_ADDR.ADDR1_LINE2 resi_Addr_Line2, PAT_ADDR.ADDR1_LINE3 resi_Addr_Line3, PAT_ADDR.ADDR1_LINE4 resi_Addr_Line4, PAT_ADDR.COUNTRY1_CODE resi_Country_Code, "); 
		 // MODIFIED by mujafar for ML-MMOH-CRF-0762
		
		//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
		sqlBuff.append(" PATIENT.CONTACT1_NO self_contact_no1, PATIENT.CONTACT2_NO self_contact_no2, PATIENT.EMAIL_ID self_appl_email_id, PAT_RL_CON.CONTACT1_MOB_TEL_NO nkin_contact_no2, PAT_RL_CON.RES1_TEL_NO nkin_contact_no1, PAT_RL_CON.CONTACT1_EMAIL_ID nkin_appl_email_id, PAT_RL_CON.CONTACT2_MOB_TEL_NO fton_contact_no2, PAT_RL_CON.RES2_TEL_NO fton_contact_no1, PAT_RL_CON.CONTACT2_EMAIL_ID fton_appl_email_id, PAT_RL_CON.RES3_TEL_NO emplr_contact_no1, PAT_RL_CON.OFF3_TEL_NO emplr_contact_no2 ");
		
		sqlBuff.append(" FROM MP_PATIENT PATIENT, MP_PAT_ADDRESSES PAT_ADDR, MP_PAT_REL_CONTACTS PAT_RL_CON WHERE PATIENT.PATIENT_ID = PAT_ADDR.PATIENT_ID(+) AND PATIENT.PATIENT_ID = PAT_RL_CON.PATIENT_ID(+) AND PATIENT.Patient_Id = '"+PatientId+"'  ");

		stmt= con.createStatement();
		rs	= stmt.executeQuery(sqlBuff.toString());

		if(rs.next() && rs != null)
		{
			addr_line1	= checkForNull(rs.getString("resi_addr_line1"));
			addr_line2	= checkForNull(rs.getString("resi_addr_line2"));
			addr_line3	= checkForNull(rs.getString("resi_addr_line3"));
			addr_line4	= checkForNull(rs.getString("resi_addr_line4"));
			contact1_no = checkForNull(rs.getString("prn_tel_no")); 
			contact2_no = checkForNull(rs.getString("orn_tel_no")); 
			email = checkForNull(rs.getString("email_id")); 
			emplr_addr_line1 = checkForNull(rs.getString("EMPLR_ADDR_LINE1")); 
			emplr_addr_line2 = checkForNull(rs.getString("EMPLR_ADDR_LINE2")); 
			emplr_addr_line3 = checkForNull(rs.getString("EMPLR_ADDR_LINE3")); 
			emplr_addr_line4 = checkForNull(rs.getString("EMPLR_ADDR_LINE4")); 
			emplr_country_code = checkForNull(rs.getString("EMPLR_COUNTRY_CODE")); 
			emplr_country_desc = checkForNull(rs.getString("EMPLR_COUNTRY_NAME")); 
			emplr_postal_code = checkForNull(rs.getString("EMPLR_POSTAL_CODE")); 
			emplr_region_code = checkForNull(rs.getString("CONTACT3_REGION_CODE")); 
			emplr_region_desc = checkForNull(rs.getString("EMPLR_REGION_DESC")); 
			emplr_res_area_code = checkForNull(rs.getString("CONTACT3_RES_AREA_CODE")); 
			emplr_res_area_desc = checkForNull(rs.getString("EMPLR_AREA_DESC")); 
			emplr_res_town_code = checkForNull(rs.getString("CONTACT3_RES_TOWN_CODE")); 
			emplr_res_town_desc = checkForNull(rs.getString("EMPLR_TOWN_DESC")); 
			fton_addr_line1 = checkForNull(rs.getString("FTON_ADDR_LINE1")); 
			fton_addr_line2 = checkForNull(rs.getString("FTON_ADDR_LINE2")); 
			fton_addr_line3 = checkForNull(rs.getString("FTON_ADDR_LINE3")); 
			fton_addr_line4 = checkForNull(rs.getString("FTON_ADDR_LINE4")); 
			fton_country_code = checkForNull(rs.getString("FTON_COUNTRY_CODE")); 
			fton_country_desc = checkForNull(rs.getString("FTON_COUNTRY_NAME")); 
			fton_postal_code = checkForNull(rs.getString("FTON_POSTAL_CODE")); 
			fton_region_code = checkForNull(rs.getString("CONTACT2_REGION_CODE")); 
			fton_region_desc = checkForNull(rs.getString("FTON_REGION_DESC")); 
			fton_res_area_code = checkForNull(rs.getString("CONTACT2_RES_AREA_CODE")); 
			fton_res_area_desc = checkForNull(rs.getString("FTON_AREA_DESC")); 
			fton_res_town_code = checkForNull(rs.getString("CONTACT2_RES_TOWN_CODE")); 
			fton_res_town_desc = checkForNull(rs.getString("FTON_TOWN_DESC")); 
			mail_addr_line1 = checkForNull(rs.getString("mail_addr_line1")); 
			mail_addr_line2 = checkForNull(rs.getString("mail_addr_line2")); 
			mail_addr_line3 = checkForNull(rs.getString("mail_addr_line3")); 
			mail_addr_line4 = checkForNull(rs.getString("mail_addr_line4")); 
			mail_country_code = checkForNull(rs.getString("mail_country_code")); 
			mail_country_desc = checkForNull(rs.getString("mail_country_name")); 
			mail_postal_code = checkForNull(rs.getString("mail_postal_code")); 
			mail_region_code = checkForNull(rs.getString("mail_region_code")); 
			mail_region_desc = checkForNull(rs.getString("mail_region_desc")); 
			mail_res_area_code = checkForNull(rs.getString("mail_res_area")); 
			mail_res_area_desc = checkForNull(rs.getString("mail_res_area_desc")); 
			mail_res_town_code = checkForNull(rs.getString("mail_res_town")); 
			mail_res_town_desc = checkForNull(rs.getString("mail_res_town_desc")); 
			nkin_addr_line1 = checkForNull(rs.getString("NKIN_ADDR_LINE1")); 
			nkin_addr_line2 = checkForNull(rs.getString("NKIN_ADDR_LINE2")); 
			nkin_addr_line3 = checkForNull(rs.getString("NKIN_ADDR_LINE3")); 
			nkin_addr_line4 = checkForNull(rs.getString("NKIN_ADDR_LINE4")); 
			nkin_country_code = checkForNull(rs.getString("NKIN_COUNTRY_CODE")); 
			nkin_country_desc = checkForNull(rs.getString("NKIN_COUNTRY_NAME")); 
			nkin_postal_code = checkForNull(rs.getString("NKIN_POSTAL_CODE")); 
			nkin_region_code = checkForNull(rs.getString("CONTACT1_REGION_CODE")); 
			nkin_region_desc = checkForNull(rs.getString("NKIN_REGION_DESC")); 
			nkin_res_area_code = checkForNull(rs.getString("CONTACT1_RES_AREA_CODE")); 
			nkin_res_area_desc = checkForNull(rs.getString("NKIN_AREA_DESC")); 
			nkin_res_town_code = checkForNull(rs.getString("CONTACT1_RES_TOWN_CODE")); 
			nkin_res_town_desc = checkForNull(rs.getString("NKIN_TOWN_DESC")); 
			postal_code = checkForNull(rs.getString("resi_postal_code")); 
			region_code		= checkForNull(rs.getString("region_code"));
			region_desc		= checkForNull(rs.getString("region_desc"));
			res_area_code	= checkForNull(rs.getString("res_area_code"));
			res_area_desc	= checkForNull(rs.getString("res_area_desc"));
			res_country_code = checkForNull(rs.getString("resi_country_code")); 
			res_country_desc = checkForNull(rs.getString("resi_country_name")); 
			res_town_code	= checkForNull(rs.getString("res_town_code"));
			res_town_desc	= checkForNull(rs.getString("res_town_desc"));

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

			self_contact_no1		= checkForNull(rs.getString("self_contact_no1"));
			self_contact_no2		= checkForNull(rs.getString("self_contact_no2"));
			self_appl_email_id		= checkForNull(rs.getString("self_appl_email_id"));

			nkin_contact_no1		= checkForNull(rs.getString("nkin_contact_no1"));
			nkin_contact_no2		= checkForNull(rs.getString("nkin_contact_no2")); 
			nkin_appl_email_id		= checkForNull(rs.getString("nkin_appl_email_id")); 

			fton_contact_no1		= checkForNull(rs.getString("fton_contact_no1"));
			fton_contact_no2		= checkForNull(rs.getString("fton_contact_no2"));
			fton_appl_email_id		= checkForNull(rs.getString("fton_appl_email_id")); 

			emplr_contact_no1		= checkForNull(rs.getString("emplr_contact_no1"));
			emplr_contact_no2		= checkForNull(rs.getString("emplr_contact_no2"));

			/*ML-MMOH-CRF-0707*/
			next_of_kin_name  = checkForNull(rs.getString("next_of_kin_name")); // added by mujafar for ML-MMOH-CRF-0762 start
			next_of_kin_nat_id_no = checkForNull(rs.getString("next_of_kin_nat_id_no"));
			next_of_kin_alt_id_type = checkForNull(rs.getString("next_of_kin_alt_id_type"));
			next_of_kin_relation_code = checkForNull(rs.getString("next_of_kin_relation_code")); // added by mujafar for ML-MMOH-CRF-0762
			next_of_kin_alt_id_no   = checkForNull(rs.getString("next_of_kin_alt_id_no")); // added by mujafar for ML-MMOH-CRF-0762 end
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception e) 
	{
		//out.println("Exception in Query 6 : "+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
%>

<script>
function setDate(Status)
{	
	var isIncompReqCancelApplicable = document.forms[0].isIncompReqCancelApplicable.value;//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	var isChckLstApplicable = document.forms[0].isChckLstApplicable.value;//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	var isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;
	if(isSpecialtyDefaultApp == "true"){
		if(document.forms[0].dept_spl!=null){
			document.forms[0].dept_spl.disabled= false;
			document.forms[0].search_spl.disabled= false;
			document.getElementById("DeptImg").style.visibility = "visible";
			document.forms[0].pract_desc.disabled= false;
			document.forms[0].pract_id_search.disabled= false;
		}
		
	}
	if(Status == '1')
	{ 
		document.getElementById("collectImg").style.visibility = "Hidden";
		document.forms[0].collect_date.value = "";
		document.forms[0].collect_date.disabled = true;
		document.getElementById("collect_img").disabled = true;
		

		// below if-else block added by mujafar for ML-MMOH-CRF-0704
			if(document.forms[0].isMedicalReportDurationAppl.value == "true")
			{
				document.getElementById("appln_col1").innerHTML=getLabel("eMR.ApplicationCompletionDates.label","MR");
				document.getElementById("appln_col2").innerHTML="<input type='text' id ='appl_comp_date' name='appln_col_date' id='appln_col_date'  maxlength=16 size=16 onblur ='' onKeyPress='return(ChkDateNumberInput(this,event,2))' value ='' style='visibility:hidden' ><img src='../../eCommon/images/CommonCalendar.gif'  id='application_date_img' onClick='document.forms[0].appln_col_date.focus();return  showCalendar('appl_comp_date',null,'hh:mm');' style='visibility:hidden' /><img src='../../eCommon/images/mandatory.gif' align='center' id='applCompImg'   style='visibility:hidden'></img>";
				document.getElementById('appln_col1').style.display = "none";
		        document.getElementById('appln_col2').style.display = "none";
			}
			else
			{
				document.getElementById("appln_col1").innerText = "";
				document.getElementById("appln_col2").innerText = "";
			}
		
		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		if(isIncompReqCancelApplicable == "true"){
			document.getElementById("cncl_date_lbl").innerText = "";
			document.getElementById("cncl_date").innerText = "";
			
			document.getElementById('hideRow').style.display = "none";
			document.getElementById("cncl_reason_lbl").innerText = "";
			document.getElementById("cancel_reason").style.visibility = "hidden";
			document.getElementById("cancel_reason_img").style.visibility = "hidden";
		}
		/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		if(isChckLstApplicable == "true"){
			document.getElementById('hideFields').style.display = "none";
			document.getElementById("appl_mode_lbl").innerText = "";
			document.getElementById("application_mode").style.visibility = "hidden";
			document.getElementById("appl_mode_img").style.visibility = "hidden";
			document.getElementById("collec_mode_lbl").innerText = "";
			document.getElementById("collection_mode").style.visibility = "hidden";
			document.getElementById("collec_mode_img").style.visibility = "hidden";
			document.getElementById("notifi_mode_lbl").innerText = "";
			document.getElementById("notification_mode").style.visibility = "hidden";
			document.getElementById("notifi_mode_img").style.visibility = "hidden";
		}
		/*ML-MMOH-CRF-0708 End*/

	}
	else if(Status == '2')
	{   
		document.getElementById("collectImg").style.visibility = "visible";
		
		/*Modified by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
		document.forms[0].collect_date.disabled = false;
		document.getElementById("collect_img").disabled = false;

		document.getElementById("appln_col1").innerText = getLabel("eMR.ApplicationCompletionDates.label","MR");
		
		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		if(isIncompReqCancelApplicable == "true"){
			document.getElementById("cncl_date_lbl").innerText = "";
			document.getElementById("cncl_date").innerText = "";
			
			document.getElementById('hideRow').style.display = "none";
			document.getElementById("cncl_reason_lbl").innerText = "";
			document.getElementById("cancel_reason").style.visibility = "hidden";
			document.getElementById("cancel_reason_img").style.visibility = "hidden";
		}
		/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		if(isChckLstApplicable == "true"){
			document.getElementById('hideFields').style.display = "block";
			document.getElementById("appl_mode_lbl").innerText = getLabel("Common.ApplicationMode.label","Common");
			document.getElementById("application_mode").style.visibility = "visible";
			document.getElementById("appl_mode_img").style.visibility = "visible";
			document.getElementById("collec_mode_lbl").innerText = getLabel("Common.CollectionMode.label","Common");
			document.getElementById("collection_mode").style.visibility = "visible";
			document.getElementById("collec_mode_img").style.visibility = "visible";
			document.getElementById("notifi_mode_lbl").innerText = getLabel("Common.NotificationMode.label","Common");
			document.getElementById("notification_mode").style.visibility = "visible";
			document.getElementById("notifi_mode_img").style.visibility = "visible";
		}
		/*ML-MMOH-CRF-0708 End*/

		// below if-else block added by mujafar for ML-MMOH-CRF-0704
		if(document.forms[0].isMedicalReportDurationAppl.value == "true")  
		{
		document.getElementById('appln_col1').innerHTML= getLabel("eMR.ApplicationCompletionDates.label","MR");
		
			document.getElementById("appln_col2").innerHTML="<input type='text' id ='appl_comp_date' name='appln_col_date' id='appln_col_date'  maxlength=16 size=16 onblur =\"validate_date_from(this);chkCollectDate1(this); \" onKeyPress=\"return(ChkDateNumberInput(this,event,2))\" value ='' style='visibility:hidden' ><img src='../../eCommon/images/CommonCalendar.gif'  id='application_date_img' onClick=\"document.forms[0].appln_col_date.focus();return  showCalendar('appl_comp_date',null,'hh:mm');\" style='visibility:hidden' /><img src='../../eCommon/images/mandatory.gif' align='center' id='applCompImg'   style='visibility:hidden'></img>";
		document.getElementById('appln_col1').style.display = "block";
		document.getElementById('appln_col2').style.display = "block";
		
		document.getElementById('appl_comp_date').style.visibility="visible";
		document.getElementById('application_date_img').style.visibility="visible";   
		document.getElementById('applCompImg').style.visibility="visible";
		document.forms[0].appln_col_date.value = document.forms[0].SystemDate_display.value;
		
		document.forms[0].appl_comp_dat.value=document.forms[0].appln_col_date.value;
		
		var ret_collect_date = chkCollectDate(document.forms[0].appln_col_date);
		
		if(ret_collect_date != 'Entered date is Holiday')
		document.forms[0].collection_date.value = ret_collect_date;
		else
		document.forms[0].collection_date.value ="";
	
	if(document.forms[0].collection_date.value  != 'undefined')
		document.forms[0].collect_date.value = document.forms[0].collection_date.value;
		}
		else
		{
			document.getElementById("appln_col2").innerText = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName);
			
			document.forms[0].collect_date.value = document.forms[0].collection_date.value;
		}
		
	}
	else
	{ 
		document.getElementById("collectImg").style.visibility = "hidden";
		document.forms[0].collect_date.value = "";
		document.forms[0].collect_date.disabled = true;
		document.getElementById("collect_img").disabled = true;
		/*Added by Dharma on 19th Dec 2019 against ML-MMOH-CRF-1454 Start*/
		if(isSpecialtyDefaultApp == "true"){
			if(document.forms[0].dept_spl!=null){
				document.forms[0].dept_spl.disabled= true;
				document.forms[0].search_spl.disabled= true;
				document.getElementById("DeptImg").style.visibility = "hidden";
				document.forms[0].pract_desc.disabled= true;
				/*document.forms[0].pract_desc.value = '';
				document.forms[0].practitioner_id.value='';*/
				document.forms[0].pract_id_search.disabled= true;
			}
			
		}
		/*Added by Dharma on 19th Dec 2019 against ML-MMOH-CRF-1454 End*/
		
		/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
		
		if(isIncompReqCancelApplicable == "true"){ 
			if(Status == '3'){  // below 4 lines modified by mujafar for ML-MMOH-CRF-0704
				document.getElementById("appln_col1").innerHTML = getLabel("Common.cancelledby.label","Common");
				document.getElementById("appln_col2").innerHTML = document.forms[0].loginUser.value;
				document.getElementById('appln_col1').style.display = "block";
		        document.getElementById('appln_col2').style.display = "block";
				//Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108
				//document.getElementById("cncl_date_lbl").innerText = getLabel("Common.cancelled.label","Common")+" "+getLabel("Common.on.label","Common");
				document.getElementById("cncl_date_lbl").innerText = getLabel("Common.CancelledOn.label","Common");
				document.getElementById("cncl_date").innerText = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName);
				
				document.getElementById('hideRow').style.display = "block";
				document.getElementById("cncl_reason_lbl").innerText = getLabel("Common.ReasonforCancellation.label","Common");
				document.getElementById("cancel_reason").style.visibility = "visible";
				document.getElementById("cancel_reason_img").style.visibility = "visible";

				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				if(isChckLstApplicable == "true"){
					document.getElementById('hideFields').style.display = "none";
					document.getElementById("appl_mode_lbl").innerText = "";
					document.getElementById("application_mode").style.visibility = "hidden";
					document.getElementById("appl_mode_img").style.visibility = "hidden";
					document.getElementById("collec_mode_lbl").innerText = "";
					document.getElementById("collection_mode").style.visibility = "hidden";
					document.getElementById("collec_mode_img").style.visibility = "hidden";
					document.getElementById("notifi_mode_lbl").innerText = "";
					document.getElementById("notification_mode").style.visibility = "hidden";
					document.getElementById("notifi_mode_img").style.visibility = "hidden";
				}
				/*ML-MMOH-CRF-0708 End*/

			}else{
				// below if-else block added by mujafar for ML-MMOH-CRF-0704
				if(document.forms[0].isMedicalReportDurationAppl.value == "true")
				{
				document.getElementById("appln_col1").innerHTML=getLabel("eMR.ApplicationCompletionDates.label","MR");
				document.getElementById("appln_col2").innerHTML="<input type='text' id ='appl_comp_date' name='appln_col_date' id='appln_col_date'  maxlength=16 size=16 onblur ='' onKeyPress='return(ChkDateNumberInput(this,event,2))' value ='' style='visibility:hidden' ><img src='../../eCommon/images/CommonCalendar.gif'  id='application_date_img' onClick='document.forms[0].appln_col_date.focus();return  showCalendar('document.forms[0].appl_comp_date',null,'hh:mm');' style='visibility:hidden' /><img src='../../eCommon/images/mandatory.gif' align='center' id='applCompImg'   style='visibility:hidden'></img><input type='hidden'  id='applcompdat' name='appl_comp_dat' id='appl_comp_dat' size=15 maxlength=15 value=''>";
				document.getElementById('appln_col1').style.display = "none";
		        document.getElementById('appln_col2').style.display = "none";
				}
				else
				{
				document.getElementById("appln_col1").innerText = "";
				document.getElementById("appln_col2").innerText = "";
				}
				
				document.getElementById("cncl_date_lbl").innerText = "";
				document.getElementById("cncl_date").innerText = "";

				document.getElementById('hideRow').style.display = "none";
				document.getElementById("cncl_reason_lbl").innerText = "";
				document.getElementById("cancel_reason").style.visibility = "hidden";
				document.getElementById("cancel_reason_img").style.visibility = "hidden";

				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				if(isChckLstApplicable == "true"){
					document.getElementById('hideFields').style.display = "none";
					document.getElementById("appl_mode_lbl").innerText = "";
					document.getElementById("application_mode").style.visibility = "hidden";
					document.getElementById("appl_mode_img").style.visibility = "hidden";
					document.getElementById("collec_mode_lbl").innerText = "";
					document.getElementById("collection_mode").style.visibility = "hidden";
					document.getElementById("collec_mode_img").style.visibility = "hidden";
					document.getElementById("notifi_mode_lbl").innerText = "";
					document.getElementById("notification_mode").style.visibility = "hidden";
					document.getElementById("notifi_mode_img").style.visibility = "hidden";
				}
				/*ML-MMOH-CRF-0708 End*/
			}
		}/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		else if(isChckLstApplicable == "true"){
			document.getElementById('hideFields').style.display = "none";
			document.getElementById("appl_mode_lbl").innerText = "";
			document.getElementById("application_mode").style.visibility = "hidden";
			document.getElementById("appl_mode_img").style.visibility = "hidden";
			document.getElementById("collec_mode_lbl").innerText = "";
			document.getElementById("collection_mode").style.visibility = "hidden";
			document.getElementById("collec_mode_img").style.visibility = "hidden";
			document.getElementById("notifi_mode_lbl").innerText = "";
			document.getElementById("notification_mode").style.visibility = "hidden";
			document.getElementById("notifi_mode_img").style.visibility = "hidden";
		}
		/*ML-MMOH-CRF-0708 End*/
		else{ 
			// below if-else block added by mujafar for ML-MMOH-CRF-0704
			if(document.forms[0].isMedicalReportDurationAppl.value == "true")
			{
				
			
			document.getElementById("appln_col1").innerHTML= getLabel("eMR.ApplicationCompletionDates.label","MR");
			document.getElementById("appln_col2").innerHTML="<input type='text' id ='appl_comp_date' name='appln_col_date' id='appln_col_date'  maxlength=16 size=16 onblur ='' onKeyPress='return(ChkDateNumberInput(this,event,2))' value ='' style='visibility:hidden' ><img src='../../eCommon/images/CommonCalendar.gif'  id='application_date_img' onClick='document.forms[0].appln_col_date.focus();return  showCalendar('appl_comp_date',null,'hh:mm');' style='visibility:hidden' /><img src='../../eCommon/images/mandatory.gif' align='center' id='applCompImg'   style='visibility:hidden'></img><input type='hidden'  id='applcompdat' name='appl_comp_dat' id='appl_comp_dat' size=15 maxlength=15 value='<%=SystemDate%>'>";
			document.getElementById('appln_col1').style.display = "none";
		    document.getElementById('appln_col2').style.display = "none";
			}
			else{
				document.getElementById("appln_col1").innerText = "";
				document.getElementById("appln_col2").innerText = "";
			}
		}
		/*End*/
	}
}

// Added by Sridhar on 7 AUG 2004
// Function will check for empty values before calling up the common lookup func..
function beforeGetAuthorised(target_id,target)
{
	if(document.forms[0].Authorised_hid.value != document.forms[0].authorised_by.value)
	{
		if(document.forms[0].authorised_by.value != "")
			 getAuthoriser(target_id,target);
	}
}

async function getAuthoriser(target_id,target)
{
	var facility_id = document.forms[0].facility_id.value;
	var title = getLabel("Common.authorizedby.label","Common");
	var locale = document.forms[0].locale.value;
	var argumentArray=new Array(8);
 
	argumentArray[0] = " select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where LANGUAGE_ID ='"+locale+"' and EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;

			
	var retVal=await CommonLookup(title,argumentArray);
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Authorised_hid.value	= arr[0];
		document.forms[0].authorised_by.value	= arr[1];
		/*document.forms[0].authorised_by.focus();
		document.forms[0].Authorised_hid.value	= document.forms[0].Authorised_hid.value;*/
	}
	else
	{
		document.forms[0].Authorised_hid.value	= "";		
		document.forms[0].authorised_by.value	= "";
	}
}


async function ShowEncounter()
{
	/*var parem = "<%=call_function%>";
	alert(parem)*/
	
		var encounterid=document.forms[0].encounterid.value;
			
			var LastDet=document.forms[0].LastDet.value
				var call_function=document.forms[0].call_function.value
	
	var retVal		= new String();
	var dialogHeight= "80vh";
	var dialogWidth	= "80vw";		
	var dialogTop	= "72";
	var center		= "";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=auto; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ; 
<%	if(!request_id.equals(""))
	{	
	%>
		retVal = await window.showModalDialog("../../eMR/jsp/vwMedRecEncounterDetails.jsp?<%=params%>&PatientId=<%=PatientId%>&selitem=<%=selitem%>&from=<%=from%>&to=<%=to%>&finalSelect=<%=finalSelect%>&chkSelect=<%=finalSelect%>&call_function=<%=call_function%>&request_id=<%=request_id%>",arguments,features);
<%	}			
	else
	{	%>
		
		
		retVal =await  window.showModalDialog("../../eMR/jsp/MedRecRequestResult.jsp?<%=params%>&flag=true&request_id=<%=request_id%>",arguments,features);

	<%}%>
}

</script>
<!--Onload Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708-->
<%
StringBuffer requestorType=new StringBuffer("RequestorTypeValue();");
if(call_function.equals("MEDICAL_REPORT_CANCELLED")){ 
	requestorType.append("disableAll();");
}if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))  {
	requestorType.append("transMode();");
}
if(call_function.equals("MEDICAL_REPORT_STATUS") && isSpecialtyDefaultApp)  {
	requestorType.append("showMsgSpecialty();");	
}
JSONArray medicalrepteamJsonArr 		= new JSONArray();
JSONArray medicalrepteamJsonArrView 	= new JSONArray();
if(isMedicalTeamApplicable) {
	medicalrepteamJsonArr  		= eMR.MRCommonBean.getMedicalTeamList(con,Facility_Id,specialtyCodeMedicalTeam,"E",locale);//Modified By Dharma on 9th Dec 2019 against ML-MMOH-CRF-1454
	medicalrepteamJsonArrView  	= eMR.MRCommonBean.getMedicalTeamList(con,Facility_Id,specialtyCodeMedicalTeam,"",locale);//Modified By Dharma on 9th Dec 2019 against ML-MMOH-CRF-1454
}



%>
<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()' onload="<%=requestorType.toString()%>">
<form name='MedicalRecordReqForm' id='MedicalRecordReqForm'  method=post target='messageFrame'>  <!-- target added by Sangeetha for ML-MMOH-SCF-0669 --> 

<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
	<%	if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{	%>
			<td class='label' width="25%" >&nbsp;</td>
			<td class=querydata width="25%" >&nbsp;</td>
	<%	}
		else
		{	%>
			<td class='label' width="25%" ><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></td>
			<td class=querydata width="25%" ><%=request_id%></td>
	<%	}	%>
		<input type=hidden name="reg_no" id="reg_no" size=15 maxlength=15 readonly value="<%=request_id%>" >
			<td class='label' width="25%" ><fmt:message key="Common.regndatetime.label" bundle="${common_labels}"/></td>

<%		if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{	%>
			<td class='querydata' width="25%" ><%=SystemDate_display%></td>
	<%	}else{	%>
			<td class='querydata' width="25%" ><%=reqDate_converted%></td>
	<%	}	%>
</tr>

<!-- Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906 -->
<%if(isPatDtlMedRepAppl){%>
<tr>
	<td class="label" width="25%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class=querydata width="25%" ><%=PatientId%></td>
</tr>
<tr>
	<td class="label" width="25%" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class=querydata colspan = '3' width="25%" style='word-wrap:break-word;width:700px;'><%=patt_name%></td>
</tr>
<tr>
	<td class="label" width="25%" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td> 
	<% if(patient_gender.equals("M"))
		{
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}
		else if(patient_gender.equals("F")) {
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		else if(patient_gender.equals("U")) {
			genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
     %>
	 <td class=querydata width="25%" ><%=genderdesc%></td>
		
    <td class="label" width="25%" ><fmt:message key="Common.age.label" bundle="${common_labels}"/> </td>
	<td class=querydata width="25%" ><%=patient_age%>Y</td>
</tr>
<%}%>
<!-- End ML-MMOH-CRF-1906 -->

</table>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	
</table>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
	<%	if(accept_national_id_no_yn.equals("Y"))
		{	%>
			<td  class='label' width="25%"  ><%=nat_id_prompt%></td>
			<td  class='querydata' width="25%" ><%=national_id_no%></td>
	<%	}else{	%>
			<td class='label' width="25%" >&nbsp;</td>
			<td class='label' width="25%" >&nbsp;</td>
	<%	}	%>

	<%	if(!alt_id1_type.equals(""))
		{	%>
			<td  class='label' width="25%" ><%=alt_id1_type%></td>
			<td  class='querydata' width="25%" ><%=alt_id1_no%></td>
	<%	}else{	%>
				<td class='label' width="25%" >&nbsp;</td>
				<td class='label' width="25%" >&nbsp;</td>
	<%	}	%>
	</tr>
	<tr>
		<td class=DEFAULTBLANKROW2PT colspan='3' width="100%" >&nbsp;</td>
		<td  class=label nowrap><a href="javascript:ShowEncounter();"><fmt:message key="eMR.ViewEncounterDetails.label" bundle="${mr_labels}"/></a></td>
	</tr>
</table>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
<tr><td class=DEFAULTBLANKROW2PT colspan='4' ></td></tr>
<tr>
	<td colspan='5' class="columnheader"><fmt:message key="eMR.ApplicantInformation.label" bundle="${mr_labels}"/></td>
</tr>
<tr>
	<td width="25%" class='label'><fmt:message key="eMR.ApplicationType.label" bundle="${mr_labels}"/></td>
	<td width="25%" class="fields"><select name="appl_type" id="appl_type" <%=disabled%>  onchange="chkCollectDate2();" >
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
	<%				
		String data = "";
		String code = "";
		String sel = "";

		appl_typeStmt=con.createStatement();
		appl_typeRS=appl_typeStmt.executeQuery(" select appl_type_code, short_desc from MR_APPL_TYPE_LANG_VW where eff_status = 'E' and language_id = '"+locale+"' order by SHORT_DESC ");
		if(appl_typeRS!=null)
		{
			sel="";
			while(appl_typeRS.next())
			{
				data = appl_typeRS.getString("SHORT_DESC");
				code = appl_typeRS.getString("APPL_TYPE_CODE");
				if(appl_type_code.equals(code))
					sel = "selected";
				else
					sel="";

				out.println("<option value='"+code+"' "+sel+">"+data+"</option>");
			}
		}	
		
		if(appl_typeRS != null)appl_typeRS.close();
		if(appl_typeStmt != null)appl_typeStmt.close();
	
		%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center' id="appl_type_mandatory" 
		name="appl_type_mandatory" <%=visibility_img%> ></img></td> 
		<!--Modified for this CRF ML-MMOH-CRF-0712--> 
		<td width="25%"  class="label"  nowrap><fmt:message key="eMR.LetterDateTime.label" bundle="${mr_labels}"/></td>
		<td width="25%"  class="fields"  >
		<!-- Added By Dharma on 20th Dec 2019 against ML-MMOH-CRF-1454 Start -->
		<%
		String letterDateTime	= application_date;
		if(call_function.equals("MEDICAL_REPORT_REQUEST")){
			letterDateTime	= SystemDate_display;
		}
		%>
		<!-- Added By Dharma on 20th Dec 2019 against ML-MMOH-CRF-1454 End -->
		<!--	Below Line is commented by Akhilesh because unnecessary function is called --> 
		<!--<input type="text" <%=disabled%> id='applnDt' name="appln_date" maxlength=16 size=16 onblur="chkDateVal(this);CompareRegnDate(this,document.forms[0].sysdate);" value="<%=SystemDate_display%>"> -->
		<input type="text" <%=disabled%> id='applnDt' name="appln_date" maxlength=16 size=16 onblur="CompareRegnDate(this,document.forms[0].sysdate);" value="<%=letterDateTime%>"><img id="ApplnImg" src="../../eCommon/images/CommonCalendar.gif" <%=disabled%> onClick="document.forms[0].appln_date.focus();return showCalendar('applnDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center'   id="appl_date_madndatory" name="appl_date_madndatory" <%=visibility_img%> ></img></td>
		<!--Modified for this CRF ML-MMOH-CRF-0712--> 
</tr>

<tr>
<%

if(!classification_appl_yn) // added by mujafar for ML-MMOH-CRF-0762 start
{
%>
	<td class='label'><fmt:message key="eMR.ApplicantName.label" bundle="${mr_labels}"/></td>
	<td class="fields" ><input type=text name="appl_name" id="appl_name"   size=30 maxlength=80 <%=disabled%>  value="<%=applicant_name%>" ><input type = 'hidden' name = 'applname' value="<%=applicant_name%>" /></td>
<%}
//else block commented By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
/*else
{
%>

<td class='label'>&nbsp;</td>
	<td class="fields" >&nbsp;</td>

<%} // added by mujafar for ML-MMOH-CRF-0762 end
*/
%>


	<td class='label' ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
	<!--Modified by Ashwini on 11-Oct-2019 for ML-MMOH-CRF-1359-->
	
	<td class="fields">
	
	<%if(isSpecialtyDefaultApp){%>
		<input type=text name="appl_refno" id="appl_refno" size=25 maxlength=30  <%=disabled%> value="<%=application_ref_no%>" onKeyup="return ChangeUpperCase(this);" onblur = "ChangeUpperCase(this);" />
	<%}else{ %>
		<input type=text name="appl_refno" id="appl_refno" size=15 maxlength=15 <%=disabled%>  value="<%=application_ref_no%>" onKeyPress="return MedRecReqCheckForSpecChars(event);" onblur = "SpeCharCheck(this);">
	<%}%>
	</td>
	<!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 Start -->
	<% 
	
	if(isOurRefApplicable){%>
		<td class='label'><fmt:message key="eMR.OurReferenceNo.label" bundle="${mr_labels}"/></td>
		<td class="fields"  nowrap ><b><%=ourRefDtlsDisp%></b></td>
		
	<%}%>
	<!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 End -->
</tr>
<%if(classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762
		
	%>

<tr>
	<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
	<td class='label' width="23%" ><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/></td>
	<td class="fields" width="27%" >
		<select name="req_type" id="req_type" <%=dis_req%> style="width:150px;" onchange="document.forms[0].requestor_desc.value='';document.forms[0].Requestor_Code.value='';EnDisRelation(this.value);">
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			%>
		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center' id="requestorTypeImg" style="visibility:visible" ></img>
	</td>  

	<td class='label' width="25%" ><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
	<td class='fields' width="10%" ><input type=text name="requestor_desc" id="requestor_desc" size=20 maxlength=15 onblur="beforeLookupSearch();" <%=dis_req%>  value="<%=requestor_desc%>" ><input type=button class=button name='search_Requestor' id='search_Requestor' value='?' onclick="LookupSearch()" <%=dis_req%>><input type=hidden name="Requestor_desc_hid" id="Requestor_desc_hid" value=''><input type=hidden name="Requestor_Code" id="Requestor_Code" value="<%=requestor_code%>"><input type=hidden name="requestor_validation" id="requestor_validation" value=""><img src='../../eCommon/images/mandatory.gif' align='center' id="requestorImg" style="visibility:hidden" ></img></td>
	
	
	<td class='fields' width="15%" align=left><input type=text name="appl_name" id="appl_name"   size=20 maxlength=80 <%=dis_req%>  value="<%=applicant_name%>" ><input type = 'hidden' name = 'applname' value="<%=applicant_name%>" /></td>
	
	
	</tr>

<%} // added by mujafar for ML-MMOH-CRF-0762 end

%>
<tr>
	<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
	<%if(isChckLstApplicable){
	if(!classification_appl_yn) 
	{ // added by mujafar for ML-MMOH-CRF-0762
		%>
	<td  class='label'>
		<!--Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108-->
		<!--<fmt:message key="Common.Application.label" bundle="${common_labels}"/> <fmt:message key="Common.category1.label" bundle="${common_labels}"/>-->
		<fmt:message key="Common.ApplicationCategory.label" bundle="${common_labels}"/>
	</td>
	<%}}else{%>
	<td  class='label'><fmt:message key="Common.RelationshipType.label" bundle="${common_labels}"/></td>
	<%}%>
	<%
	if(!classification_appl_yn)
	{ // added by mujafar for ML-MMOH-CRF-0762
	%>
	<td class="fields">
		<select name="relationship_type" id="relationship_type"  onchange="populateApplName(this.value);enDisRequestor(this.value);popApplAddress(this.value)" <%=disabled%> onmousewheel='return false;'>
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='0'><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
		<option value='1'><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option>
		<option value='2'><fmt:message key="Common.employer.label" bundle="${common_labels}"/></option>
		<option value='3'><fmt:message key="Common.self.label" bundle="${common_labels}"/></option>
		<option value='4'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</select>
	</td>
<%	
if(!call_function.equals(""))
{
	if(relationship_type.equals(""))
		out.println("<script>document.getElementById('relationship_type').options[0].selected=true;</script>");
	else if(relationship_type.equals("0"))
		out.println("<script>document.getElementById('relationship_type').options[1].selected=true;</script>");	
	else if(relationship_type.equals("1"))
		out.println("<script>document.getElementById('relationship_type').options[2].selected=true;</script>");
	else if(relationship_type.equals("2"))
		out.println("<script>document.getElementById('relationship_type').options[3].selected=true;</script>");
	else if(relationship_type.equals("3"))
		out.println("<script>document.getElementById('relationship_type').options[4].selected=true;</script>");
	else if(relationship_type.equals("4"))
		out.println("<script>document.getElementById('relationship_type').options[5].selected=true;</script>");
}	%>
	<%}%>

	<td  class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class="fields"><select name='relationship' id='relationship' <%=disable1%> <%=disabled%>>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%
		String rel_sel ="";                                     
		String rel_data ="";                                     
		String rel_code ="";    
		
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();

		String rel_sql = " select relationship_code, short_desc from MP_RELATIONSHIP_LANG_VW where eff_status='E' and language_id = '"+locale+"' order by short_desc ";

		stmt = con.createStatement();
		rs = stmt.executeQuery (rel_sql) ;
		if(rs != null)
		{
			while(rs.next())
			{
				rel_data = rs.getString("SHORT_DESC");
				rel_code = rs.getString("relationship_code");
					if(relationship_code.equals(rel_code))
						rel_sel = "selected";
					else
						rel_sel="";
	
				out.println("<option value='"+rel_code+"' "+rel_sel+">"+rel_data+"</option>");
			}
		}	
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
%>
	</select><img src='../../eCommon/images/mandatory.gif' align='center' id="relationImg" style="visibility:hidden" ></img></td>
	
	<%if(classification_appl_yn)
	{ // added by mujafar for ML-MMOH-CRF-0762
		 if(accept_national_id_no_yn.equals("Y") ){
		%>
		<td class='LABEL' width='25%'><%=nat_id_prompt%>&nbsp;</td>
		<td class='fields' width='25%'><input type='text'  name="contact2_nat_id_no" id="contact2_nat_id_no"  <%=dis_req%>  value = "<%=nat_id%>" onkeypress='return allowValidNumber(this,event,2, 0);'  maxlength='<%=nat_id_length%>' onblur="makeValidString(this);"  size='20'  ></td>



		 <%}}%>
	
</tr>
<%
if(classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762 start
	
	if(accept_oth_alt_id_yn.equals("Y")){%>
	
          <tr>
		  <td class='label' width='25%'>&nbsp;</td>
		   <td  class='fields'  width='25%'>&nbsp;</td>
		  <td class='label' width='25%'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
              <td  class='fields'  >
					<select name='contact1_oth_alt_id_type' id='contact1_oth_alt_id_type' onChange='enableOtherAltIdText(this.value)' <%=dis_req%>  > 
  						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<%
					  sqlAlt.append("select alt_id_type,mp_get_desc.mp_alternate_id_type(alt_id_type,'"+locale+"','1') short_desc from  mp_alternate_id_type where  alt_id_type not in (select alt_id1_type   from mp_param where module_id='MP' union select  nvl(alt_id2_type,1) from mp_param where module_id='MP' union  select nvl(alt_id3_type,2) from mp_param where module_id='MP' union select nvl(alt_id4_type,3) from  mp_param where module_id='MP') and eff_status='E' order by 2");
					  oth_stmt = con.createStatement();
					  oth_rset = oth_stmt.executeQuery(sqlAlt.toString());	
				
					  if(oth_rset != null)
					  {
						while (oth_rset.next())
						{          
						  out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\" >"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
						}
					  }
                     if(oth_rset!=null) oth_rset.close();
                     if(oth_stmt!=null) oth_stmt.close();

				    %>
					</select>
					</td>
                      <td class='fields' >  <input type='text' name='contact1_oth_alt_id_no' id='contact1_oth_alt_id_no' <%=dis_req%> value='' maxlength='20' size='20' onblur='makeValidString(this);'   value = "">
              </td>
		  </tr>
		  
		  <%
}} // added by mujafar for ML-MMOH-CRF-0762 end
%>

<%if(!classification_appl_yn)
{ // added by mujafar for ML-MMOH-CRF-0762
%>
<tr>
	<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
	<td class='label'><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/></td>
	<td class="fields">
		<select name="req_type" id="req_type" <%=disabled%> onchange="document.forms[0].requestor_desc.value='';document.forms[0].Requestor_Code.value='';EnDisRelation(this.value);">
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
				JSONArray RequestorTypeJsonArr = new JSONArray();
				RequestorTypeJsonArr  = eMR.MRCommonBean.getRequestorTypeForRequestor(con);

				for(int i = 0 ; i < RequestorTypeJsonArr.size() ; i++) 
				{
					JSONObject json	= (JSONObject)RequestorTypeJsonArr.get(i);
					String requestor_type_code  = (String) json.get("requestor_type_code");
					String long_desc  = (String) json.get("long_desc");
					out.println("<option value='"+requestor_type_code+ "'>"+long_desc+"</option>");	
				}		
			%>
		</select>
	</td>  

	<td class='label'><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
	<td class="fields"><input type=text name="requestor_desc" id="requestor_desc" size=15 maxlength=15 onblur="beforeLookupSearch();" <%=disabled%>  value="<%=requestor_desc%>" ><input type=button class=button name='search_Requestor' id='search_Requestor' value='?' onclick="LookupSearch()" <%=disabled%>><input type=hidden name="Requestor_desc_hid" id="Requestor_desc_hid" value=''><input type=hidden name="Requestor_Code" id="Requestor_Code" value=""><input type=hidden name="requestor_validation" id="requestor_validation" value=""><img src='../../eCommon/images/mandatory.gif' align='center' id="requestorImg" style="visibility:hidden" ></img></td>
</tr>
<%}%>
<tr>
<%
//Below Condition Added By Dharma on Apr 9th against ML-MMOH-CRF-1314	
if(!isAcceptRequestByPractAppl){%>
	<td class='label'><fmt:message key="eMR.ConsentLetter.label" bundle="${mr_labels}"/></td>
	<td class="fields">
		<SELECT name="cons_letter" id="cons_letter" <%=disabled%>>
		<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='0'><fmt:message key="Common.available.label" bundle="${common_labels}"/></option>
		<option value='1'><fmt:message key="Common.notavailable.label" bundle="${common_labels}"/></option>
		<option value='2'><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
		</SELECT>
	</td>
<%
	if(!call_function.equals(""))
	{	
		if(cons_letter.equals(""))
			out.println("<script>document.getElementById('cons_letter').options[0].selected=true;</script>");
		if(cons_letter.equals("0"))
			out.println("<script>document.getElementById('cons_letter').options[1].selected=true;</script>");
		else if(cons_letter.equals("1"))
			out.println("<script>document.getElementById('cons_letter').options[2].selected=true;</script>");
		else if(cons_letter.equals("2"))
			out.println("<script>document.getElementById('cons_letter').options[3].selected=true;</script>");
	}

	if(call_function.equals("MEDICAL_REPORT_STATUS"))
		out.println("<script>document.getElementById('cons_letter').disabled=false;</script>");
}
%>
	<td class='label'><fmt:message key="eMR.Attentionto.label" bundle="${mr_labels}"/></td>
	<td class="fields" ><input type=text name="for_attn" id="for_attn" size=25 maxlength=50 <%=disabled%>  value="<%=for_attn_of%>" onblur="tab_click('requestor_details')"></td>
<%
//Below Condition Added By Dharma on Apr 9th against ML-MMOH-CRF-1314	
if(!isAcceptRequestByPractAppl){%>
</tr>
<tr>
	<td class="label">&nbsp;</td>
	<td class="label">&nbsp;</td>
<%}%>
	<td  class='label'><fmt:message key="eMR.ApplicationNo.label" bundle="${mr_labels}"/></td>
	<!--Modified by Ashwini on 11-Oct-2019 for ML-MMOH-CRF-1359-->
	<td class="fields"><input type=text name="appl_no" id="appl_no" size=15 maxlength=15 <%=disabled%>  value="<%=appl_no%>" onKeyPress="return MedRecReqCheckForSpecChars(event);" onblur = "SpeCharCheck(this);"></td>
</tr>
	<tr>
<%	if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_REPORT_STATUS"))
	
	{	%>
		<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->
		<td class="button"><input type="button" name="checkList" id="checkList" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")%>" class='button' onclick="showChecklistDetails('Y');"></td>
		<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->
		
		<td class="button" ><input type="button" name="Dates" id="Dates" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")%>" class='button' onclick="showDateDetails();" ></td>
		<td class="button" ><input type="button" name="Charges" id="Charges" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")%>" class='button' onclick="showChargeDetails();" ></td>
		<td class="button"><input type="button" name="appl_addr" id="appl_addr" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")%>" class='button' <%if(!classification_appl_yn){%>onclick="DisplayApplAddress(relationship_type.value);"<%}else{%>onclick="DisplayAddress();" <%}%> onblur="tab_click('requestor_details')"></td> 

<%	}else{%>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->
		<%if(call_function.equals("MEDICAL_REPORT_STATUS")){%>
			<td class="button"><input type="button" name="checkList" id="checkList" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")%>" class='button' onclick="showChecklistDetails('N');"></td>
		<%}else{%>
			<td class="label">&nbsp;</td>
		<%}%>
		<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->
		
		<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
		<%if(isChckLstApplicable){%>
		<%if(call_function.equals("MEDICAL_REPORT_REQUEST")){%>
			<td class="button"><input type="button" name="checkList" id="checkList" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CheckList.label","mr_labels")%>" class='button' onclick="showChecklistDetails('N');"></td>
		<%}%>
		<%}%>

		<td class="button"><input type="button" name="appl_addr" id="appl_addr"  <%=disable1%>   value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicantAddress.label","mr_labels")%>" class='button' <%if(!classification_appl_yn){%>onclick="DisplayApplAddress(relationship_type.value);"<%}else{%>onclick="DisplayAddress();" <%}%> onblur="tab_click('requestor_details')"></td> 
<%	}	%>
	</tr>
</table>

<%	if(call_function.equals("MEDICAL_REPORT_REQUEST") || call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
	{	%>
	<table border="0" width="100%" cellspacing='0' cellpadding='3'>
		<tr>
			<td class="columnheader" colspan='4'><fmt:message key="Common.Charges.label" bundle="${common_labels}"/></td>
		</tr>
		
		<!--Added By Ashwini on 20-Jun-2022 for ML-MMOH-CRF-1905-->
		<% if(isOutstandingAmtMedRepAppl){ %>
		<tr>
			<td width="25%" class='label'>     
				<fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/>&nbsp;
			</td> 
			<td width='25%' class='fields' style='position:relative;'>
				<% if (bl_install_yn.equals("Y") && (outst_amt > 0)) {%>
					<b><%=outst_amt1%></b>
				<% } %>
			</td>
		</tr>
		<% } %>
		<!--End ML-MMOH-CRF-1905-->

		<tr>
			<td  width="25%" class='label'><fmt:message key="eMR.ChargesApplicable.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><select name="charges_appllicable" id="charges_appllicable" onchange="enableOtherDetails(this.name,this.value)">
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg1"></img></td>


			<td width="25%" class='label'><fmt:message key="eMR.AdditionalCharges.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><select name="additional_charges" id="additional_charges"  <%=disabledAttribute%> onchange="enableOtherDetails(this.name,this.value)">
				<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg1" ></img></td>
		</tr>
		<tr>
			<td  class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name='amount' id='amount' size=15 maxlength=13  value="<%=amount%>" disabled
			onBlur="CheckZeroVal(this);CheckNumberFormat(this);allowValidNumber(this,event,10,2);return fillDecimal(this,10,2);" onKeyPress="ChkDateNumberInput(this,event,2); return allowValidNumber(this,event,10,2);"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg2"></img></td>

			<td class='label'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name='add_amount'  id='add_amount' size=15 maxlength=13 disabled value="<%=addl_amount%>" onKeyPress="ChkDateNumberInput(this,event,2); return allowValidNumber(this,event,10,2)" onBlur="CheckZeroVal(this);CheckNumberFormat(this);allowValidNumber(this,event,10,2);return fillDecimal(this,10,2);"><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg2"></img></td>	
		</tr>
		<tr>
			<td class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name=recp_no id=recp_no size=15 maxlength=15 disabled value="<%=receipt_no%>" onblur=populateRecptDate(this.value,document.forms[0].recp_dat,document.getElementById("recp_dat_img"))><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg3"></img></td>

			<td class='label'><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name=add_recp_no id=add_recp_no size=15 maxlength=15 disabled value="<%=addl_receipt_no%>" onblur=populateRecptDate(this.value,document.forms[0].add_recp_dat,document.getElementById("add_recp_dat_img"))><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="addtlChargeImg3"></img></td>
		</tr>
		<tr>			
			<td class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name=recp_dat id=recp_dat size=16 maxlength=16 onblur="recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)" disabled value="<%=receipt_date_converted%>"><img disabled src="../../eCommon/images/CommonCalendar.gif" id="recp_dat_img" onClick="document.forms[0].recp_dat.focus();return showCalendar('recp_dat',null,'hh:mm');"<%=disabled%>/><img src='../../eCommon/images/mandatory.gif' align='center'  style="visibility:hidden" id="chargeImg4"></img></td>

			<td class='label'><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type=text name=add_recp_dat id=add_recp_dat size=16 maxlength=16 onblur="recptDateValidations(this,document.forms[0].request_date,document.forms[0].sysdate)" disabled value="<%=addl_receipt_date_converted%>"><img disabled src="../../eCommon/images/CommonCalendar.gif" id="add_recp_dat_img" onClick="document.forms[0].add_recp_dat.focus();return showCalendar('add_recp_dat',null,'hh:mm');" disabled ><img src='../../eCommon/images/mandatory.gif' align='center' style="visibility:hidden" id="addtlChargeImg4"></img></td>
		</tr>

<%
		if(!call_function.equals(""))
		{	%>
			<script>
				
				document.forms[0].charges_appllicable.value = "<%=charges_appl_yn%>";
				document.forms[0].additional_charges.value = "<%=addl_charges_yn%>";
			</script>
	<%	}	%>
		<script>
			if(document.forms[0].charges_appllicable.value == "Y")
			{
				if("<%=medrep_pay_int_mode%>" == "X")
				{
					document.forms[0].amount.disabled = false;
					document.forms[0].recp_no.disabled = false;
					document.forms[0].recp_dat.disabled = false;
					document.getElementById("recp_dat_img").disabled = false;
				}
				else if("<%=medrep_pay_int_mode%>" == "B")
				{
					document.forms[0].amount.disabled = false;
				}
			}
		</script>

		<script>
			if(document.forms[0].additional_charges.value == "Y")
			{
				if("<%=medrep_pay_int_mode%>" == "X")
				{
					document.forms[0].add_amount.disabled = false;
					document.forms[0].add_recp_no.disabled = false;
					document.forms[0].add_recp_dat.disabled = false;
					document.getElementById("add_recp_dat_img").disabled = false;
				}
				else if("<%=medrep_pay_int_mode%>" == "B")
				{
					document.forms[0].add_amount.disabled = false;
				}
			}
		</script>
	<%	
		if(call_function.equals("MEDICAL_REPORT_REQUEST"))
		{
			for( int i=0; i<10; i++)
			{
				out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
			}
		}
%>		</table>
<%	}	

/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
else
{ %>
	<input type='hidden' name='charges_appllicable' id='charges_appllicable' value='<%=charges_appl_yn%>'>
<% }
/*End ML-MMOH-CRF-0722*/

if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
{	%>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	<tr><td class="columnheader" colspan=4>&nbsp;</td></tr>
<%}
if(!call_function.equals("MEDICAL_REPORT_STATUS") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_REPORT_CANCELLED"))
{	%>
	<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	<%
	if(isAcceptRequestByPractAppl)
	{// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		
	%>
	<tr><td class="columnheader" colspan=5>
	<!--Modified By Dharma on Apr 9th 2020 against ML-MMOH-CRF-1314-->
	<!--<fmt:message key="eMR.MedicalRecordTask.label" bundle="${mr_labels}"/>-->
	<%if(call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED")){%>
		<fmt:message key="eMR.ApplicationStatus.label" bundle="${mr_labels}"/>
	<%}else{%>
		<fmt:message key="eMR.MedicalRecordTask.label" bundle="${mr_labels}"/>
	<%}%>
	</td></tr>
	<%}else{%>
	<tr><td class="columnheader" colspan=4>&nbsp;</td></tr>
	<%}%>
	
	<tr>
		<td class="label" width="25%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td  class="fields" width="25%">
			<SELECT name="rep_type" id="rep_type" <%=dis%> >
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
	<%
		if(ca_install_yn.equals("Y"))
		{
			Statement stm = null;
			ResultSet rss = null;
			String repType_sel = "";
			try
			{
				String sqlrep = " select NOTE_TYPE, NOTE_TYPE_DESC from CA_NOTE_TYPE where note_group_id in (select note_group from ca_note_group where appl_task_id = 'MR_MEDICAL_REPORT') and EFF_STATUS = 'E' order by NOTE_TYPE_DESC ";
				stm = con.createStatement();
				rss = stm.executeQuery(sqlrep);
				if(rss!=null)
				{
					while(rss.next())
					{
						String repcode = rss.getString("NOTE_TYPE");
						String repdesc = rss.getString("NOTE_TYPE_DESC");
						if(report_type_code.equals(repcode))
							repType_sel = "selected";
						else
							repType_sel="";

						out.println("<option value='"+repcode+"' "+repType_sel+">"+repdesc+"</option>");
					}
				}
			}
			catch(Exception e)
			{
				//out.println("Exception in rep_type : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rss!=null) rss.close();
				if(stm!=null) stm.close();
			}
		}
		%>
			</SELECT><img src='../../eCommon/images/mandatory.gif' align='center' id="ReportTypeImg" <%=visibility_img%>></img></td>
			<!-- Modified By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start-->   
			<!--<td width="25%" class='label'>&nbsp;</td>
			<td width="25%" class='label'>&nbsp;</td>-->
			<%
			if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") || call_function.equals("RECEIVE_MEDICAL_REPORT") && isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714
			//String selectStatus	= "";
			String enableStatus	= "";
			if(call_function.equals("REQUEST_ACCEPTED")){
				enableStatus	= "disabled";
			}
			
			%>
				<td width="25%" class='label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class='label'>
					<select name="status" id="status"  onchange="check_status();" <%=enableStatus%>>
						<option value='A' selected><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></option>
						<option value='R' ><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
			<%if(call_function.equals("FORWARD_TO_HOD") && isSelfStatusMRPApplicable){ // added by mujafar for ML-MMOH-CRF-0718 %>
			<option value='S' ><fmt:message key="eMR.SelfPrepare.label" bundle="${mr_labels}"/></option>
			<%}%>
						
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' name="status_imag" id="status_imag" ></img>
					<!--Added for this CRF ML-MMOH-CRF-0712-->
				</td>
			<%}else{%>
				<td width="25%" class='label'>&nbsp;</td>
				<td width="25%" class='label'>&nbsp;</td>
			<%}
			
			}else{
				if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD")|| call_function.equals("REQUEST_RETURNED")){	
				%>
				<td width="7%" class='label'>&nbsp;</td><%}%>
			<td  class='label' width="25%" ><fmt:message key="eMR.DepartmentSpecialty.label" bundle="${mr_labels}"/></td>
			<td  class="fields" width="25%" ><input <%=dis%> type=text name="dept_spl" size=15 maxlength=15  value="<%=specialty_short_desc%>" onblur="BeforeGetSpecialtyValue(this, '<%=Facility_Id%>');" ><input type=hidden class=label name="Splcode" id="Splcode" value="<%=specialty_code%>"><input <%=dis%> type=button class=button name='search_spl' value='?' onclick="getSpecialtyValue(dept_spl, '<%=Facility_Id%>')" ><img src='../../eCommon/images/mandatory.gif' align='center' id="DeptImg"   style="visibility:hidden"></img></td>
			
			
			<%}%>
			<!-- Modified By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] End--> 
		</tr>
		<!--Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708-->
		<%if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))
		{
			if(isChckLstApplicable){%>
			<tr>
				<td class='label' width="25%" ><fmt:message key="Common.ApplicationMode.label" bundle="${common_labels}"/></td>
				<td class='querydata' width="25%" > 
					<!--<select name="applic_mode" id="applic_mode" <%=disableModes%>>-->
					<select name="applic_mode" id="applic_mode" disabled>
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%
								for(int i = 0 ; i < TransApplModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransApplModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							%>
					</select>
					<!--<%if(call_function.equals("DELIVER_MEDICAL_REPORT")){%>
					<img src='../../eCommon/images/mandatory.gif' align='center'></img>
					<%}%>-->
				</td>
				<td class='label' width="25%" ><fmt:message key="Common.CollectionMode.label" bundle="${common_labels}"/></td>
				<td class='querydata' width="25%" >
					<!--<select name="collectn_mode" id="collectn_mode" <%=disableModes%>>-->
					<select name="collectn_mode" id="collectn_mode" disabled>
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%
								for(int i = 0 ; i < TransCollModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransCollModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							%>
					</select>
					<!--
					<%if(call_function.equals("DELIVER_MEDICAL_REPORT")){%>
					<img src='../../eCommon/images/mandatory.gif' align='center'></img>
					<%}%>
					-->
				</td>				
			</tr>
			<tr>
			<td class='label'  width="25%" ><fmt:message key="Common.NotificationMode.label" bundle="${common_labels}"/></td>
			<td class='querydata'>
				<!--<select name="notific_mode" id="notific_mode" <%=disableModes%>>-->
				<select name="notific_mode" id="notific_mode" disabled>
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
						<%
							for(int i = 0 ; i < TransNotifiModeJsonArr.size() ; i++) 
								{
								JSONObject json	= (JSONObject)TransNotifiModeJsonArr.get(i);
								String transport_mode  = (String) json.get("transport_mode");;
								String short_desc  = (String) json.get("short_desc");;
								out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
								}		
						%>
				</select>
				<!--
				<%if(call_function.equals("DELIVER_MEDICAL_REPORT")){%>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				<%}%>-->
			</td>
			<td width="25%">&nbsp;</td>
			<td width="25%">&nbsp;</td>
			</tr>
			<%}
		}%>
		<!--ML-MMOH-CRF-0708 End-->
		
		<tr>
			<%if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			%>
			<td  class='label' ><fmt:message key="eMR.DepartmentSpecialty.label" bundle="${mr_labels}"/></td>
			<td  class="fields"><input <%=dis%> type=text name="dept_spl" size=15 maxlength=15  value="<%=specialty_short_desc%>" onblur="BeforeGetSpecialtyValue(this, '<%=Facility_Id%>');" ><input type=hidden class=label name="Splcode" id="Splcode" value="<%=specialty_code%>"><input <%=dis%> type=button class=button name='search_spl' value='?' onclick="getSpecialtyValue(dept_spl, '<%=Facility_Id%>')" ><img src='../../eCommon/images/mandatory.gif' align='center' id="DeptImg"   style="visibility:hidden"></img></td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<%}else{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
				
				
				
				if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED"))
				{%>
				<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" colspan="2" class="fields"><input type='text'  id='fwd_hod_desc' name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' ><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' id = 'fwd_hod_id_search' name='fwd_hod_id_search' id='fwd_hod_id_search' value='?' class='button' onClick='getPractID(this);' >
		<%if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
		<select name="medical_team_val" id="medical_team_val" id="medical_team_val" onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								
									for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArr.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										out.println("<option value='"+teamCode+ "' title='"+pract_list+"'>"+teamDesc+"</option>");
										
								}		
					%>
				</select>
		
		<%}%>	
			
		&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="fwd_hod_img" name="fwd_hod_img"></img></td>	
		<td class="label" width="25%" ><fmt:message key="eMR.ForwardedHODDate.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td><td nowrap class='querydata' id='forward1' width='25%' >&nbsp;<%=SystemDate%><input type='hidden' name='forwarded_hod_cord_date' id='forwarded_hod_cord_date' value='<%=SystemDate%>'></td>
		
			</tr>
			<tr>
			<td class="label" width="25%" ><fmt:message key="eMR.InformToHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" colspan="2"  class="fields"><input type='text' id='inform_hod_desc'  name='inform_hod_desc' id='inform_hod_desc' size='30' maxlength='30' onblur='BeforeInformGetPractitioner();' value='<%=inform_hod_cord_name%>' ><input type='hidden' name='inform_hod_practitioner_id' id='inform_hod_practitioner_id' value='<%=inform_hod_cord_id%>'><input type='button' id='inform_hod_pract_id_search' name='inform_hod_pract_id_search' id='inform_hod_pract_id_search' value='?' class='button' onClick='getPractID(this);' >
			<%if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
			<select name="medical_team_val1" id="medical_team_val1" id="medical_team_val1" onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
									for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArr.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										out.println("<option value='"+teamCode+ "' title='"+pract_list+"'>"+teamDesc+"</option>");
										
								}
					%>
				</select>
			<%}%>
			
			</td>
			
		<td align='right' class='label' width='25%' ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='25%'><%=requesting_pract_name%>&nbsp;</td>
			
					
					
				<%}
				else if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") ) {
					
					
					
					String dis_inf_hod = ""; //added by mujafar for ML-MMOH-CRF-1279 
				String dis_inf_team = "";
				if(!inform_hod_cord_id.equals("") && inform_medical_team.equals(""))
					dis_inf_team = "disabled";
				if(inform_hod_cord_id.equals("") && !inform_medical_team.equals(""))
					dis_inf_hod = "disabled"; 
			%>		
					
			<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="35%" class="fields"><input type='text'  name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' disabled><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' name='fwd_hod_id_search' id='fwd_hod_id_search' value='?' class='button' onClick='getPractID(this);' disabled >
				
				<%if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
		<select name="medical_team_val" id="medical_team_val" id="medical_team_val"   <%=disabled%> onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
																
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++)	{
									JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
									String teamCode  = (String) json1.get("team_id");
									String teamDesc  = (String) json1.get("short_desc");
									String pract_list  = (String) json1.get("pract_list");
									if(forwarded_medical_team.equals(teamCode))
										sel_1 = "selected";
									else
										sel_1 = "";
									out.println("<option value='"+teamCode+ "'  "+sel_1+"   title='"+pract_list+"'>"+teamDesc+"</option>");
									
							}
								
								
								
					%>
				</select>
		
		<%}%>	
				
			
				
				</td>
		
		
		
		</tr>
		<tr>
		
			<td class="label" width="25%"><fmt:message key="eMR.InformToHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields"><input type='text'  name='inform_hod_desc2' id='inform_hod_desc2' <%=dis_inf_hod%> size='30' maxlength='30' onblur='BeforeInformGetPractitioner();' value='<%=inform_hod_cord_name%>'   ><input type='hidden' name='inform_hod_practitioner_id2' id='inform_hod_practitioner_id2' value='<%=inform_hod_cord_id%>'><input type='button' name='inform_hod_pract_id_search2' id='inform_hod_pract_id_search2' <%=dis_inf_hod%> value='?' class='button'  onClick='getPractID(this);' >
				
				
				
				<%if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
		<select name="medical_team_val2" id="medical_team_val2" id="medical_team_val2"  <%=dis_inf_team%>   onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
																
								String sel_2 = "";
								
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(inform_medical_team.equals(teamCode))
											sel_2 = "selected";
										else
											sel_2 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_2+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					%>
				</select>
		
		<%}%>	
				</td>
			<%if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_RETURNED")
					|| call_function.equals("REQUEST_ACCEPTED") ){
				
				%>
		<td align='right' class='label' width='25%' ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='25%'><%=requesting_pract_name%>&nbsp;</td>
			<%}%>
			</tr>
<!-- -->

<%}}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
%>
			</tr>
<%
		if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REQUEST_RETURNED"))
			out.println("<script>document.getElementById('DeptImg').style.visibility = 'visible';</script>");		
%>
	<%	if(new_func_id.equals("APP_FOR_MED_BOARD"))
		{
		%>
		<tr>
			<td class='label' ><fmt:message key="eMR.MedicalBoardMembers.label" bundle="${mr_labels}"/></td>
			<td class="fields" colspan=3 ><textarea name='MedicalMembers' rows=2 cols='60' onblur= "makeValidString(this);chklim(this,200)" value="" ></textarea></td>
		</tr>
	<%	}	%>
		
	</table>

	<table border="0" width="100%" cellspacing='0' cellpadding='4'>
		
			
			<%
	if(isAcceptRequestByPractAppl)
	{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	 String mrd_disp="";
	 if(!(call_function.equals("FORWARD_MEDICAL_REPORT")|| call_function.equals("REJECTED_BY_PRACT_TO_MRD") )) mrd_disp= "disabled";

	%>
	
	
	
	<%	/////////////////////////////// DISPLAY ONLY ////////////////////////
if(call_function.equals("PREPARE_MEDICAL_REPORT") || 
call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") ||
call_function.equals("REVISE_MEDICAL_REPORT")  ||
call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("ACCEPTED_BY_PRACTITIONER") )
{	
if(isAcceptRequestByPractAppl){
%>
	<tr>
		<td class="label" width="25%"><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td class="fields" width="20%"><input type="text" name="disp_col_date" id="disp_col_date" maxlength=16 size=16 value ="<%=CollectDate_Converted%>" disabled ><img src="../../eCommon/images/CommonCalendar.gif" disabled></td>
<%	if(!revised_collect_date.equals(""))
	{	%>
		<td class="label" width="20%"><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/></td>
		<TD class='QueryData' width="30%"><%=revised_collect_date_converted%></td>
<%	}else{	%>
		<td class="label" width="25%" >&nbsp;</td>
		<td class='label' width="25%" >&nbsp;</td>
<%	}	%>
	</tr>
	<%
}}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
%>

<tr>
	<td class="label" width="25%" ><fmt:message key="eMR.MRDRemarks.label" bundle="${mr_labels}"/></td>
	<td colspan="" class="fields" width="25%" ><textarea name='remarks' rows=2 cols='40' colspan='2' <%=mrd_disp%>  onblur="makeValidString(this);chklim(this,200);tab_click('report_details');"  ><%=remarks%></textarea>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="img_remarks"   style="visibility:hidden"></img></td>
	<td class="label" width="25%" >&nbsp;</td>
	<td class="label" width="25%" >&nbsp;</td>
	</tr>





<%



	if(!(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_REPORT"))){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316

	 if(!call_function.equals("REJECTED_BY_PRACT_TO_MRD"))
	 {%>
	<tr><td class="columnheader" colspan=5 width='100%' >
	<%if(isAcceptRequestByPractAppl && ((call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))&& !called_from.equals("CA"))){%>	 
		
		<fmt:message key="eMR.DeliveryDetails.label" bundle="${mr_labels}"/>

	<%}else{%>
		 <fmt:message key="eMR.HODCoordinatorTask.label" bundle="${mr_labels}"/>
	<%}%>
	</td></tr>

	<%
	 }
if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD")  || call_function.equals("REQUEST_ACCEPTED") || call_function.equals("RECEIVE_MEDICAL_REPORT") && isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714
			
			String enableStatus	= "";
			if(call_function.equals("REQUEST_ACCEPTED")){
				enableStatus	= "disabled";
			}
			

			
			%>  <tr>
				<td width="25%" class='label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class='fields'>
				<%if(call_function.equals("RECEIVE_MEDICAL_REPORT")){%>
					<select name="status" id="status"  onchange="check_status();" <%=enableStatus%>>
						<option value='A' selected><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></option>
						<option value='R' ><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
				
				<%}else{%>
				<select name="status" id="status"  onchange="check_status1();" <%=enableStatus%>>
						<option value='A' selected><fmt:message key="eMR.AcceptedbyHOD.label" bundle="${mr_labels}"/></option>
						<option value='R' ><fmt:message key="eMR.RejectedbyHOD.label" bundle="${mr_labels}"/></option>
				
				<%}%>
				
			<%if((call_function.equals("FORWARD_TO_HOD")|| call_function.equals("REJECTED_BY_PRACT_TO_HOD") )&& isSelfStatusMRPApplicable){ // added by mujafar for ML-MMOH-CRF-0718 %>
			<option value='S' ><fmt:message key="eMR.SelfPrepare.label" bundle="${mr_labels}"/></option>
			<%}%>
						
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' name="status_imag" id="status_imag" ></img>
					<!--Added for this CRF ML-MMOH-CRF-0712-->
				</td>
				<%if(!call_function.equals("RECEIVE_MEDICAL_REPORT")){%>
				<td class='label' id="collectImg5" width='23%'  ><span id="acc" ><fmt:message key="Common.AcceptDateTime.label" bundle="${common_labels}"/></span><span id="rej" Style="display:none;"><fmt:message key="Common.RejectDateTime.label" bundle="${common_labels}"/></span>&nbsp; </td>
				<td nowrap class='querydata'   id="collectImg6"   width='25%' >&nbsp;<%=SystemDate%></td><input type='hidden' name='accpt_rejct_date' id='accpt_rejct_date' value='<%=SystemDate%>'> 
				<%}else{%>
				<td class="label" width="25%" >&nbsp;</td>
				<td class='fields' width="25%" >&nbsp;</td>
				<%}%>
				
			</tr>
			
			<%
				if(isRejectRequestApplicable && (call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED")) )
				{ // added by mujafar for ML-MMOH-CRF-0713
				// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
			%>
			<tr>
			<td  class='label' id="accept1"  width="25%">
				<span id="asnpract" ><fmt:message key="eMR.AssignReAssignPractitioner.label" bundle="${mr_labels}"/></span><span id="reject_reason_1" Style="display:none;" ><fmt:message key="Common.ReasonforRejection.label" bundle="${common_labels}"/></span>
			</td>
			<td class="fields" id="accept2"  width="25%" >			
				<input type='text' name='fwd_pract_desc' id='fwd_pract_desc' size='30' maxlength='30' onblur='BeforeFwdGetPractitioner();' value="" ><input type='hidden' name='fwd_practitioner_id' id='fwd_practitioner_id' value=""><input type='button' name='fwd_pract_id_search' id='fwd_pract_id_search' value='?' class='button' onClick='getPractID(this);' >
			</td>
			
				<td nowrap class='querydata' width='25%' name="reject_medrep_reason_desc" id="reject_medrep_reason_desc"  style="display:none;" >
			<select name="reject_medical_rep_reason" id="reject_medical_rep_reason" style="visibility:hidden;width:150px;" > <!-- added by mujafar for ML-MMOH-CRF-0716 -->
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								JSONArray medicalreprejectreasonJsonArr = new JSONArray();
								medicalreprejectreasonJsonArr  = eMR.MRCommonBean.getRejectReasonList(con);	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalreprejectreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='reject_medical_rep_reason_img' align='center'></img>
			</td>
			
			
			<td width='25%' align='center' class='label' width='25%' id="reject_by_1" style="display:none;">
				<fmt:message key="eMR.RejectedBy.label" bundle="${mr_labels}"/>
			</td> <!-- label changed for ML-MMOH-CRF-0713 -->
			<td width='25%'  class='QueryData'  colspan='8' align='left' id="reject_by_2" style="display:none;">
				<%=loginUser%>
			</td> 
			
			<td class='label' id="practImg1" width='23%'  >
			<span id="pracdate" Style="display:none;" ><fmt:message key="eMR.PractitionerAssignedDate.label" bundle="${mr_labels}"/></span>
			</td>
			<td nowrap class='querydata'   id="practImg2" Style="display:none;"   width='25%' >
				<span   id='pract_ass_date' name='pract_ass_date'  readonly  ></span>
			</td>
			<input type='hidden' name='pract_assign_date' id='pract_assign_date' value=''  >
			</tr>
							<%
				String dis_ack_hod = ""; //added by mujafar for ML-MMOH-CRF-0716 start
				String dis_ack_team = "";
				if(!ack_hod_cord_id.equals("") && ack_medical_team.equals(""))
					dis_ack_team = "disabled";
				if(ack_hod_cord_id.equals("") && !ack_medical_team.equals(""))
					dis_ack_hod = "disabled"; //added by mujafar for ML-MMOH-CRF-0716 end
				
				%>
		   
		   <tr>    
				<td class="label" width="25%"><fmt:message key="eMR.AcknowledgedByHODCoordinator.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields"><input type='text' <%=dis_ack_hod%>  name='ack_hod_co_ord_desc' size='30' maxlength='30' onblur='BeforeGetAckHOD();' value='<%=ack_hod_cord_name%>'  /><input type='hidden' name='ack_hod_co_ord_id' id='ack_hod_co_ord_id' value='<%=ack_hod_cord_id%>'><input type='button' name="ack_hod_co_ord_search" id="ack_hod_co_ord_search" value='?' <%=dis_ack_hod%> class='button' onClick='getPractID(this);'  > <!-- added by mujafar for ML-MMOH-CRF-0716 -->
				<%--
				<%if((call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") ) && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
				<select name="medical_team_val_ack" id="medical_team_val_ack" id="medical_team_val_ack" onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
														
								for(int i = 0 ; i < medicalrepteamJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalrepteamJsonArr.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										out.println("<option value='"+teamCode+ "' title='"+pract_list+"'>"+teamDesc+"</option>");
										
								}		
					%>
				</select>
		
			<%}%>	
				
			<%if(call_function.equals("REQUEST_ACCEPTED") && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716 %>	
					<select name="medical_team_val_ack_1" id="medical_team_val_ack_1" id="medical_team_val_ack_1"  <%=dis_ack_team%>   onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
														
								String sel_3 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(ack_medical_team.equals(teamCode))
											sel_3 = "selected";
										else
											sel_3 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_3+" title = '"+pract_list+"'>"+teamDesc+"</option>");
										
								}
					%>
				</select>
		
				<%}%>			
				&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="acknow_coordinator_img" name="acknow_coordinator_img"></img>
				--%>
				</td>
				
	
				<td class="label" width="25%"><fmt:message key="eMR.InformToPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields">&nbsp;<input type='text'  name='inform_to_pract_desc' id='inform_to_pract_desc' size='30' maxlength='30' onblur='BeforeInformToPract();' value='<%=inform_to_pract_name%>' ><input type='hidden' name='inform_to_pract_id' id='inform_to_pract_id' value='<%=inform_to_pract_id%>'><input type='button' name='inform_to_pract_search' id='inform_to_pract_search' value='?' class='button' onClick='getPractID(this);' >&nbsp;<!-- <img src='../../eCommon/images/mandatory.gif'align='center' id="informtopract_img" name="informtopract_img"></img> --></td>			
				
			</tr>
		<%}%>
			
<%}
if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") ||call_function.equals("REQUEST_ACCEPTED")||call_function.equals("REQUEST_RETURNED"))
{
	String selectStatus	= "";
				if(!call_function.equals("FORWARD_TO_HOD") && !call_function.equals("REJECTED_BY_PRACT_TO_HOD") && !call_function.equals("REQUEST_ACCEPTED")){
					
				selectStatus	= "disabled";
			}
%>
	<tr>	
		<td class="label" width="25%" ><fmt:message key="eMR.HODCoordinatorRemarks.label" bundle="${mr_labels}"/></td>
	<td colspan="" class="fields" width="25%" ><textarea name='remarks_hod' rows=2 cols='40' <%=selectStatus%>  onblur="makeValidString(this);chklim(this,200);tab_click('report_details');"  ><%=remarks_hod%></textarea></td>
	
	</tr>
<%
	}
}%>
	<%}else{%>
	<tr>
	<td class='label'  width="25%" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td colspan="3" class="fields"  ><textarea name='remarks' rows=2 cols='60'  onblur="makeValidString(this);chklim(this,200);tab_click('report_details');"  ><%=remarks%></textarea>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="img_remarks"   style="visibility:hidden"></img></td>
	</tr>
	<%}%>
		
		
	<%} %>

	
     
	 
	<%	if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED"))
		{	
		
	%>
		<!--Maheshwaran K added for the ML-MMOH-CRF-0391 starts-->
		<table border="0" width="100%" cellspacing='0' cellpadding='4'>
		
			<tr>  
			<%if(!isAcceptRequestByPractAppl){
			// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			%>
			<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" colspan="2" class="fields">&nbsp;<input type='text'  id='fwd_hod_desc' name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' ><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' id = 'fwd_hod_id_search' name='fwd_hod_id_search' id='fwd_hod_id_search' value='?' class='button' onClick='getPractID(this);' >
			&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="fwd_hod_img" name="fwd_hod_img"></img></td> <!--Modified for this CRF ML-MMOH-CRF-0712-->
			<td width='30%' colspan='6'>&nbsp;</td>
				<td width='20%' colspan='6'>&nbsp;</td>	
	        </tr>

		    <tr>
			<td class="label" width='25%' ><fmt:message key="eMR.RequiredDocuments.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td><td   class="fields" colspan="3" width='57%'>&nbsp;<textarea   name='reqd_docs'  id='reqd_docs' rows=2 cols='60' colspan="3" onblur="makeValidString(this);chklim(this,100);tab_click('report_details');"  disabled></textarea></td>
				<td width='20%' colspan='8'>&nbsp;</td>
				
		</tr>

		<tr>
			<td class="label" width="25%" ><fmt:message key="eMR.InformToHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" colspan="2"  class="fields">&nbsp;<input type='text' id='inform_hod_desc'  name='inform_hod_desc' id='inform_hod_desc' size='30' maxlength='30' onblur='BeforeInformGetPractitioner();' value='<%=inform_hod_cord_name%>' ><input type='hidden' name='inform_hod_practitioner_id' id='inform_hod_practitioner_id' value='<%=inform_hod_cord_id%>'><input type='button' id='inform_hod_pract_id_search' name='inform_hod_pract_id_search' id='inform_hod_pract_id_search' value='?' class='button' onClick='getPractID(this);' >
			&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' name="inform_hod_img" id="inform_hod_img"></img></td> <!--Modified for this CRF ML-MMOH-CRF-0712 -->
			<td width='30%' colspan='6'>&nbsp;</td>
				<td width='20%' colspan='6'>&nbsp;</td>	
			
				
           </tr>

		 <tr>  
			<td class="label" width="25%" ><fmt:message key="eMR.ForwardedHODDate.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td><td nowrap class='querydata' id='forward1' width='25%' >&nbsp;<%=SystemDate%><input type='hidden' name='forwarded_hod_cord_date' id='forwarded_hod_cord_date' value='<%=SystemDate%>'></td>
			<td align='right' class='label' width='25%' ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='25%'><%=requesting_pract_name%>&nbsp;</td>			
		</tr>
		<tr>
				<td class='label' id="collectImg5" width='23%'  >
				<span id="acc" ><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></span>
				<span id="rej" Style="display:none;"><fmt:message key="Common.Reject.label" bundle="${common_labels}"/>
				</span>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}" /> 
				</td>
				<td nowrap class='querydata'   id="collectImg6"   width='25%' >&nbsp;<%=SystemDate%></td><input type='hidden' name='accpt_rejct_date' id='accpt_rejct_date' value='<%=SystemDate%>'> 
				<td id="collectImg7" width='23%' style="display:none;" >&nbsp;</td>
				<td id="collectImg8" width='25%' style="display:none;" >&nbsp;</td>
				
			</tr>
		<%}%>

	
			
  <!--Below line added for this CRF ML-MMOH-CRF-0712-->
	<%
	
	if(isMedicalReportRequest && (call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD"))){
	// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	//Modified By Dharma on 25th Mar 2020 against ML-MMOH-CRF-1473
	%>
	<tr>  
			<td class="label" width="25%" >
			<!--Modified By Dharma against ML-MMOH-CRF-0717 [IN:062396] on 23rd July 2108-->
			<!--<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;-->
			<fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/></td>
			<td nowrap class='querydata' width='25%' >&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='checkbox' name="cancel_medical_report" id="cancel_medical_report" id="cancel_medical_report" onclick="<%if(call_function.equals("FORWARD_TO_HOD")){%>cancelMedicalReport();<%}else{%>medicalReport();<%}%>"></td>
			<td align='right' class='label' width='25%'  id="cancelby_medical_report">&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='20%' id="cancelby_med_rep_user" style='word-wrap: break-word;width:275px'>&nbsp;</td>			
		</tr>
        <tr>  
			<td class="label" width="25%" name="cancel_medrep_reason" id="cancel_medrep_reason" >&nbsp;&nbsp;</td>
			<td nowrap class='querydata' width='25%' name="cancel_medrep_reason_desc" id="cancel_medrep_reason_desc" >
			<select name="cancel_medical_rep_reason" id="cancel_medical_rep_reason" style="visibility:hidden">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								JSONArray medicalrepreasonJsonArr = new JSONArray();
								medicalrepreasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < medicalrepreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalrepreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='cancel_medical_rep_reason_img' align='center'></img>
			</td>
			<td align='right' class='label' width='25%' name="cancelon_medical_report" id="cancelon_medical_report">&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='20%' name="cancelondate_medical_report" id="cancelondate_medical_report">&nbsp;</td>		
	</tr>			
	<%}%>

</table>

		<%	}
	else if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REQUEST_ACCEPTED") ) 
	{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	
	%>
	 <%if(!isAcceptRequestByPractAppl){
		
		%>
			<tr>    
			
				<td  class='label' width="25%"><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/></td>
				<td class="fields" width="25%"><input type='text' name='fwd_pract_desc' id='fwd_pract_desc' size='30' maxlength='30' onblur='BeforeFwdGetPractitioner();' value="" ><input type='hidden' name='fwd_practitioner_id' id='fwd_practitioner_id' value=""><input type='button' name='fwd_pract_id_search' id='fwd_pract_id_search' value='?' class='button' onClick='getPractID(this);' ></td>
				<td width='30%' colspan='6'>&nbsp;</td>
				<td width='20%' colspan='6'>&nbsp;</td>						
           </tr>
			<tr>  
				
				<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="35%" class="fields">&nbsp;<input type='text'  name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' disabled><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' name='fwd_hod_id_search' id='fwd_hod_id_search' value='?' class='button' onClick='getPractID(this);' disabled >
				</td>
           </tr>
			<!--Below line alignment for RequestedPractitioner column-->
			<tr>    
				<td class="label" width="25%"><fmt:message key="eMR.InformToHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields">&nbsp;<input type='text'  name='inform_hod_desc' id='inform_hod_desc' size='30' maxlength='30' onblur='BeforeInformGetPractitioner();' value='<%=inform_hod_cord_name%>' disabled ><input type='hidden' name='inform_hod_practitioner_id' id='inform_hod_practitioner_id' value='<%=inform_hod_cord_id%>'><input type='button' name='inform_hod_pract_id_search' id='inform_hod_pract_id_search' value='?' class='button' disabled onClick='getPractID(this);' >
				</td>
				<td width='25%' align='center' class='label' ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
				<td width='25%'  class='QueryData'  colspan='8' align='left'><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onblur='BeforeGetPractitioner();' value="<%=requesting_pract_name%>" disabled><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=requesting_pract_id%>"><input type='button' name='pract_id_search' id='pract_id_search' width='25%'  value='?' class='button' onClick='getPractID(this);' disabled></td>						
           </tr>
		   <%
		  		String dis_ack_hod = ""; //added by mujafar for ML-MMOH-CRF-0716 start
				String dis_ack_team = "";
				if(!ack_hod_cord_id.equals("") && ack_medical_team.equals(""))
					dis_ack_team = "disabled";
				if(ack_hod_cord_id.equals("") && !ack_medical_team.equals(""))
					dis_ack_hod = "disabled"; //added by mujafar for ML-MMOH-CRF-0716 end
				
				%>
		   <tr>    
				<td class="label" width="25%"><fmt:message key="eMR.AcknowledgedByHODCoordinator.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields">&nbsp;<input type='text' <%=dis_ack_hod%>  name='ack_hod_co_ord_desc' size='30' maxlength='30' onblur='BeforeGetAckHOD();' value='<%=ack_hod_cord_name%>'  /><input type='hidden' name='ack_hod_co_ord_id' id='ack_hod_co_ord_id' value='<%=ack_hod_cord_id%>'><input type='button' name="ack_hod_co_ord_search" id="ack_hod_co_ord_search" value='?' <%=dis_ack_hod%> class='button' onClick='getPractID(this);'  > <!-- added by mujafar for ML-MMOH-CRF-0716 -->
				&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="acknow_coordinator_img" name="acknow_coordinator_img"></img></td>
				<!-- commented and below code added by mujafar for ML-MMOH-CRF-0713 -->
				<!--<td width='30%' colspan='6'>&nbsp;</td>
				<td width='20%' colspan='6'>&nbsp;</td>   -->
			
           </tr>
	
		   <tr> 
				
				<td class="label" width="25%"><fmt:message key="eMR.InformToPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="25%" class="fields">&nbsp;<input type='text'  name='inform_to_pract_desc' id='inform_to_pract_desc' size='30' maxlength='30' onblur='BeforeInformToPract();' value='<%=inform_to_pract_name%>' ><input type='hidden' name='inform_to_pract_id' id='inform_to_pract_id' value='<%=inform_to_pract_id%>'><input type='button' name='inform_to_pract_search' id='inform_to_pract_search' value='?' class='button' onClick='getPractID(this);' >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' id="informtopract_img" name="informtopract_img"></img></td>
							
				
		   </tr>
		   <tr>
				<td class='label' id="collectImg5" width='23%'  >
				<span id="acc" ><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></span>
				<span id="rej" Style="display:none;"><fmt:message key="Common.Reject.label" bundle="${common_labels}"/>
				</span>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}" /> 
				</td>
				<td nowrap class='querydata'   id="collectImg6"   width='25%' >&nbsp;<%=SystemDate%></td><input type='hidden' name='accpt_rejct_date' id='accpt_rejct_date' value='<%=SystemDate%>'> 
				<td id="collectImg7" width='23%' style="display:none;" >&nbsp;</td>
				<td id="collectImg8" width='25%' style="display:none;" >&nbsp;</td>
				
			</tr>
			<%}
				if(isRejectRequestApplicable && call_function.equals("FORWARD_TO_HOD") ) {	
				%>
					<tr>
				<td width='25%' align='center' class='label' width='25%' id="reject_on_1" style="display:none;" ><fmt:message key="eMR.RejectedOn.label" bundle="${mr_labels}"/><input type='hidden' name='accpt_rejct_date1' id='accpt_rejct_date1' value='<%=SystemDate%>'></td> <!-- label changed for ML-MMOH-CRF-0713 -->
				<td width='25%'  class='QueryData'  colspan='8' align='left' id="reject_on_2" style="display:none;"><%=SystemDate%></td>
				</tr>
				<%}%>
			<!--Below line added for this CRF ML-MMOH-CRF-0712-->

	
	
<!--End this CRF ML-MMOH-CRF-0712-->
		
	<%}%>
</table>

<table border="0" width="100%" cellspacing='0' cellpadding='3'>
<%	
String selectStatus_C="";
if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
	{	

	/*
	SRR20056-SCF-2925 Friday, April 03, 2009
	*/
	req_status=checkForNull(request.getParameter("req_status"));
	
	String selectStatus_I="";
	 if(req_status.equals("7"))
		 selectStatus_I="selected";
	 if(req_status.equals("8") || req_status.equals("99")) //Modified by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719
		 selectStatus_C="selected";
	 /*
	SRR20056-SCF-2925 Friday, April 03, 2009
	*/

		 %>
		<tr>
			<td class='label' ><fmt:message key="eMR.ApplicationStatus.label" bundle="${mr_labels}"/></td>
			<td class="fields"><select name="appl_status" id="appl_status" onchange="setDate(this.value)">
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='2'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value='1' <%=selectStatus_I%>><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			<option value='3'<%=selectStatus_C%>><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif' id='appln_status_Img' align='center'></img></td>
			<td width="25%" class='label' id='appln_col1' ></td>
			<!-- below if-else block added by mujafar for ML-MMOH-CRF-0704 -->
			<%if(isMedicalReportDurationAppl)
			{
				%>
			<td width="25%" class='querydata' id='appln_col2'><input type="text" id ='appl_comp_date' name='appln_col_date' id='appln_col_date'  maxlength=16 size=16 onblur ="" onKeyPress="return(ChkDateNumberInput(this,event,2))" value ="" style="visibility:hidden" ><img src="../../eCommon/images/CommonCalendar.gif"  id='application_date_img' onClick="document.forms[0].appln_col_date.focus();return  showCalendar('appl_comp_date',null,'hh:mm');" style="visibility:hidden" /><img src='../../eCommon/images/mandatory.gif' align='center' id="applCompImg"   style="visibility:hidden"></img></td> 
			<%
			}
			else
			{
			%>
			<td width="25%" class='querydata' id='appln_col2' ></td>
			<%
			collection_date =  eCommon.Common.CommonBean.getCollectionDate(con);
			}
			
			%>
			<input type=hidden  id='applcompdat' name="appl_comp_dat" id="appl_comp_dat" size=15 maxlength=15 value='<%=SystemDate%>'>
		</tr>
<% //collection_date =  eCommon.Common.CommonBean.getCollectionDate(con);/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
%>	<input type="hidden" name="collection_date" id="collection_date" value="<%=collection_date%>">	
		<tr>
			<td class="label"  nowrap width="25%"><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/></td>
			<td class="fields">
			<!-- Below code is commented by Akhilesh because unnecessary function is calling -->
			<!--<input type="text" id='collectDt' name="collect_date" id="collect_date" disabled maxlength=16 size=16 onblur ="chkDateVal(this);CompareSysDate(this,document.forms[0].sysdate);" onKeyPress="return(ChkDateNumberInput(this,event,2))" value =""> --> 
			<!--onblur modified by mujafar for  ML-MMOH-CRF-0704 -->
			<input type="text" id='collectDt' name="collect_date" id="collect_date" disabled maxlength=16 size=16 onblur ="if('<%=isMedicalReportDurationAppl%>'){validate_date_from(this);compare_from(appln_col_date,this);}CompareSysDate(this,document.forms[0].sysdate);isHoliday(this);" onKeyPress="return(ChkDateNumberInput(this,event,2))" value =""><img src="../../eCommon/images/CommonCalendar.gif" disabled id='collect_img' onClick="document.forms[0].collect_date.focus();return  showCalendar('collectDt',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center' id="collectImg"   style="visibility:hidden"></img></td>
			<!--<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>-->
			<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->
			<% if(isIncompReqCancelApplicable){ %>
				<td width="25%" class='label' id='cncl_date_lbl' ></td>
				<td width="25%" class='querydata' id='cncl_date' >
				<input type=hidden  id='cancelDate' name="cancelDate" id="cancelDate" size=15 maxlength=15 value='<%=SystemDate%>'></td>
			<% } %>
			<!--End-->
		</tr>
		
		<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
		<%if(isChckLstApplicable){%>
			<tbody id='hideFields' style="display:none;">
				<tr>
					<td width="25%" class='label' id='appl_mode_lbl'></td>
					<td class='querydata' id='appl_mode' >
					<select name="application_mode" id="application_mode" style="visibility:hidden" >
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%
								for(int i = 0 ; i < TransApplModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransApplModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='appl_mode_img' align='center'></img>
					</td>
				</tr>
				<tr>
					<td width="25%" class='label' id='collec_mode_lbl'></td>
					<td class='querydata' id='collec_mode' >
					<select name="collection_mode" id="collection_mode" style="visibility:hidden" >
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%
								for(int i = 0 ; i < TransCollModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransCollModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='collec_mode_img' align='center'></img>
					</td>
						
					<td width="25%" class='label' id='notifi_mode_lbl'></td>
					<td class='querydata' id='notifi_mode' >
					<select name="notification_mode" id="notification_mode" style="visibility:hidden" >
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
							<%	
								for(int i = 0 ; i < TransNotifiModeJsonArr.size() ; i++) 
									{
									JSONObject json	= (JSONObject)TransNotifiModeJsonArr.get(i);
									String transport_mode  = (String) json.get("transport_mode");;
									String short_desc  = (String) json.get("short_desc");;
									out.println("<option value='"+transport_mode+ "'>"+short_desc+"</option>");	
									}		
							%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='notifi_mode_img' align='center'></img>
					</td>
				</tr>
			</tbody>
		<%}%>	
			<!--ML-MMOH-CRF-0708 End-->

		<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->
		<% if(isIncompReqCancelApplicable){ %>
		</table>
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
		<tbody id='hideRow' style="display:none;">
			<tr>
				<td width="25%" class='label' id='cncl_reason_lbl' ></td>
				<td class='querydata' id='cncl_reason' >
				<select name="cancel_reason" id="cancel_reason" style="visibility:hidden" >
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								JSONArray reasonJsonArr = new JSONArray();
								reasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < reasonJsonArr.size() ; i++) 
								{
										JSONObject json	= (JSONObject)reasonJsonArr.get(i);
										String reasonCode  = (String) json.get("reasonCode");;
										String reasonDesc  = (String) json.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='cancel_reason_img' align='center'></img>
				</td>
			</tr>
		</tbody>
		</table>
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
		<% } %>
		<!--End-->
<%		}	
		// commented for ML-MMOH-CRF-0391
		if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		//if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		{	%>
		<!-- Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start-->
		<%if(isSpecialtyDefaultApp){%>
		<tr>
			<td class='label' width="25%"><fmt:message key="eMR.DepartmentSpecialty.label" bundle="${mr_labels}"/></td>
			<td class="fields"><input type=text name="dept_spl" id="dept_spl" size=15 maxlength=15<%if(!selectStatus_C.equals("")){ %> disabled<%} %>  value="<%=specialty_short_desc%>" onblur="BeforeGetSpecialtyValue(this, '<%=Facility_Id%>');" ><input type=hidden class=label name="Splcode" id="Splcode" value="<%=specialty_code%>"><input type=button class=button name='search_spl' id='search_spl' value='?' onclick="getSpecialtyValue(dept_spl, '<%=Facility_Id%>')" ><img src='../../eCommon/images/mandatory.gif' align='center' id="DeptImg"></img></td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<!-- Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End-->
		<%} %>
		<tr>
			<td class='label' width="25%"><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
			<td class="fields"><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onblur='BeforeGetPractitioner();' value="<%=requesting_pract_name%>" ><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=requesting_pract_id%>"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick='getPractID(this);' ></td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
	<%	}	
		if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REQUEST_RETURNED"))
		{	
			for( int i=0; i<10; i++)
			{
				out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
			}
		}

		if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
		{	%>
		<tr>
			<td  class='label' width="25%"><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
			<td class='QueryData' width="25%"><%=requesting_pract_name%></td>
			<td class="label" width="18%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
			<td width="32%" class="fields" nowrap>&nbsp;<input type='text'  name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' disabled /><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>' /><input type='button' name='fwd_hod_id_search' id='fwd_hod_id_search' value='?' class='button' onClick='getPractID(this);' disabled />
			<%if(isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				disabled = "disabled";
				%>	
				<select name="medical_team_val" id="medical_team_val" id="medical_team_val"   <%=disabled%>  onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
																
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title= '"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					%>
				</select><%}%>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
	<%	}

		if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
		{	
		if(!isAcceptRequestByPractAppl){
	%>
		<tr>
			<td class='label'  ><fmt:message key="eMR.RequiredDocuments.label" bundle="${mr_labels}"/></td>
			<td class="fields" colspan="3" ><textarea name='reqd_docs' id='reqd_docs' style="resize: none;" rows=2 cols='60' onblur="makeValidString(this);chklim(this,100);tab_click('report_details');"  > </textarea></td>
		</tr>
<%
		}
	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	}
}	%>
</table>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	
<%	/////////////////////////////// DISPLAY ONLY ////////////////////////
if(call_function.equals("PREPARE_MEDICAL_REPORT") || 
call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") ||
call_function.equals("REVISE_MEDICAL_REPORT")  ||
call_function.equals("QUERY_DELAY_IN_MRR") )
{	
if(!isAcceptRequestByPractAppl)
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
%>
	<tr>
		<td class="label" width="25%"><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td class="fields" width="25%"><input type="text" name="disp_col_date" id="disp_col_date" maxlength=16 size=16 value ="<%=CollectDate_Converted%>" disabled ><img src="../../eCommon/images/CommonCalendar.gif" disabled></td>
<%	if(!revised_collect_date.equals(""))
	{	%>
		<td class="label" width="20%"><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/></td>
		<td class='QueryData' width="30%"><%=revised_collect_date_converted%></td>
<%	}else{	%>
		<td class=label>&nbsp;</td>
		<td class=label>&nbsp;</td>
<%	}	%>
	</tr>
<%
}	
}if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) 
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	/*Added By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] Start*/
		String isDisabledFwdPract	= "";
		//if(!called_from.equals("CA")) //Commented By Dharma on 19th Dec 2019 aginst ML-MMOH-CRF-1454
			isDisabledFwdPract		= "disabled";
	/*Added By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155] End*/
	
	%>
	<tr>
	<%if(isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	%>
		<td  class='label' width="25%"><fmt:message key="eMR.AssignReAssignPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<%}else{%>
	<td  class='label' width="25%"><fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<%}%>
		<td class="fields" width="25%">
		<input type='text' name='fwd_pract_desc' id='fwd_pract_desc' size='30' maxlength='30' onblur='BeforeFwdGetPractitioner();' value="<%=forwarded_pract_name%>" <%=isDisabledFwdPract%>><input type='hidden' name='fwd_practitioner_id' id='fwd_practitioner_id' value="<%=forwarded_pract_id%>"><input type='button' name='fwd_pract_id_search' id='fwd_pract_id_search' value='?' class='button' onClick='getPractID(this);' <%=isDisabledFwdPract%>> <img src='../../eCommon/images/mandatory.gif' align='center'></img>
		
		</td>
		<%if(!isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		%>
		<td  class='label' width="25%" ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="fields" width="25%"><input type='text' name='prep_pract_desc' id='prep_pract_desc' size='30' maxlength='30' onblur='BeforePrepGetPractitioner();' value="<%=PREPARE_PRACT_NAME%>" ><input type='hidden' name='prep_practitioner_id' id='prep_practitioner_id' value="<%=pract_code%>" ><input type='button' name='prep_pract_id_search' id='prep_pract_id_search' value='?' class='button' onClick='getPractID(this);' ><img src='../../eCommon/images/mandatory.gif' style="visibility:visible" id='prep_pract_desc_Img' align='center'></img></td> <!-- style added by mujafar for ML-MMOH-CRF-0963 -->
		
		<%}else{%>
		<td class='label'  width='25%'  >
			<fmt:message key="eMR.PractitionerAssignedDate.label" bundle="${mr_labels}"/>
			</td>
			<td nowrap class='querydata'      width='25%' ><%=Pract_Assign_Date%></td>
		<%}%>
		
	</tr>
	<%if(isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	%>
	<tr>    
			<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td>
			<td width="33%" class="fields"><input type='text'  name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' disabled><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' name='fwd_hod_search' id='fwd_hod_search' value='?' class='button' onClick='getPractID(this);' disabled>
			
			
			<%if((call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				
				disabled = "disabled";
				
				
				%>	
		<select name="medical_team_val" id="medical_team_val" id="medical_team_val"   <%=disabled%>  style="width:120px;" onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								
								String sel_1 = "";
								
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					%>
				</select>
		
		<%}%>
			&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				<td width='20%' colspan='6' >&nbsp;</td>
				<td width='10%' colspan='6' >&nbsp;</td>						
           </tr>
	
	
	<%}%>
	<%if(!isAcceptRequestByPractAppl){
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	%>
	<tr>
		<td class="label"  width="25%"><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td class="fields" width="25%">
		<!-- Below code is commented by Akhilesh because unnecessary function is calling -->
		<!--<input type="text" id='prepareDt' name="prepare_date" id="prepare_date" maxlength=16 size=16 onblur="chkDateVal(this);CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);" value ="<%=SystemDate%>"> -->
		<input type="text" id='prepareDt' name="prepare_date" id="prepare_date" maxlength=16 size=16 onblur="CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);" value ="<%=SystemDate_display%>"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].prepare_date.focus();return showCalendar('prepareDt',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' id='prepare_date_Img' align='center'></img></td>
		<td align='right' class='label' width='25%' ><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td>
		<td class="fields" width="25%"><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onblur='BeforeGetPractitioner();' value="<%=requesting_pract_name%>" disabled><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=requesting_pract_id%>"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick='getPractID(this);' disabled></td>
			
	</tr>
	<tr>    
			<td class="label" width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/>&nbsp;&nbsp;&nbsp;</td><td width="33%" class="fields">&nbsp;<input type='text'  name='fwd_hod_desc' id='fwd_hod_desc' size='30' maxlength='30' onblur='BeforeFwdGetFwdHod();' value='<%=forwarded_hod_cord_name%>' disabled><input type='hidden' name='fwd_hod_id' id='fwd_hod_id' value='<%=forwarded_hod_cord_id%>'><input type='button' name='fwd_hod_search' id='fwd_hod_search' value='?' class='button' onClick='getPractID(this);' disabled>
			
			
			<%if(call_function.equals("PREPARE_MEDICAL_REPORT") && isMedicalTeamApplicable) { //added by mujafar for ML-MMOH-CRF-0716
				
				disabled = "disabled";
				
				
				%>	
		<select name="medical_team_val" id="medical_team_val" id="medical_team_val"   <%=disabled%>  style="width:120px;" onchange="mrteam_change()">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								
								String sel_1 = "";
								for(int i = 0 ; i < medicalrepteamJsonArrView.size() ; i++) {
										JSONObject json1	= (JSONObject)medicalrepteamJsonArrView.get(i);
										String teamCode  = (String) json1.get("team_id");
										String teamDesc  = (String) json1.get("short_desc");
										String pract_list  = (String) json1.get("pract_list");
										
										if(forwarded_medical_team.equals(teamCode))
											sel_1 = "selected";
										else
											sel_1 = "";
										out.println("<option value='"+teamCode+ "'  "+sel_1+" title='"+pract_list+"' >"+teamDesc+"</option>");
										
								}
					%>
				</select>
		
		<%}%>
			&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				<td width='20%' colspan='6' >&nbsp;</td>
				<td width='10%' colspan='6' >&nbsp;</td>						
           </tr>

		    <tr>
			<td class="label" width="25%" ><fmt:message key="eMR.RequiredDocuments.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</td><td   class="fields" colspan="3" width='57%'>&nbsp;<textarea   name='reqd_docs' id='reqd_docs' rows=2 cols='60' colspan="3" onblur="makeValidString(this);chklim(this,100);tab_click('report_details');"  disabled></textarea></td>
				<td width='20%' colspan='8'>&nbsp;</td>
				
		</tr>
<%}else{
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
%>
<tr>	
		<td class="label" width="25%" ><fmt:message key="eMR.HODCoordinatorRemarks.label" bundle="${mr_labels}"/></td>
	<td colspan="" class="fields"  ><textarea name='remarks_hod' rows=2 cols='40' disabled  onblur="makeValidString(this);chklim(this,200);tab_click('report_details');"  ><%=remarks_hod%></textarea></td>
	
	</tr>


<%}%>
<%/*
}
	if(call_function.equals("PREPARE_MEDICAL_REPORT") && called_from.equals("CA"))
	{	*/%>				
<%	
	
	// below if else block added by mujafar for ML-MMOH-CRF-0963
	if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(isMedicalReportRequest && call_function.equals("PREPARE_MEDICAL_REPORT") && called_from.equals("CA"))
	{ 
		%>
		<tr>  
			<td class="label" width="25%" ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
			<td nowrap class='querydata' width='25%' >
			<input type='checkbox' name="cancel_medical_report" id="cancel_medical_report" id="cancel_medical_report" onclick="frwdtoPractMedicalReport()"></td>
			<td align='right' class='label' width='25%'  id="cancelby_medical_report">&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='20%' id="cancelby_med_rep_user" style='word-wrap: break-word;width:275px'>&nbsp;</td>			
		</tr>
        <tr>  
			<td class="label" width="25%" name="cancel_medrep_reason" id="cancel_medrep_reason" >&nbsp;&nbsp;</td>
			<td nowrap class='querydata' width='25%' name="cancel_medrep_reason_desc" id="cancel_medrep_reason_desc" >
			<select name="cancel_medical_rep_reason" id="cancel_medical_rep_reason" style="visibility:hidden">
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								JSONArray medicalrepreasonJsonArr = new JSONArray();
								medicalrepreasonJsonArr  = eMR.MRCommonBean.getReasonList(con);	
								
								for(int i = 0 ; i < medicalrepreasonJsonArr.size() ; i++) 
								{
										JSONObject json1	= (JSONObject)medicalrepreasonJsonArr.get(i);
										String reasonCode  = (String) json1.get("reasonCode");;
										String reasonDesc  = (String) json1.get("reasonDesc");;
										out.println("<option value='"+reasonCode+ "'>"+reasonDesc+"</option>");
										
								}		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='cancel_medical_rep_reason_img' align='center'></img>
			</td>
			<td align='right' class='label' width='25%' name="cancelon_medical_report" id="cancelon_medical_report">&nbsp;&nbsp;</td>
			<td class='QueryData'  colspan='8' align='left' width='20%' name="cancelondate_medical_report" id="cancelondate_medical_report">&nbsp;</td>		
	</tr>
		
		
		<%
	}
	else
	{
	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	} 	
	}
	}

if(isAcceptRequestByPractAppl){
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
%>
<tr>
<td class="columnheader" colspan=5>
<!--<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Task.label" bundle="${common_labels}"/>-->
<fmt:message key="eMR.PractitionerTask.label" bundle="${mr_labels}"/>
</td>
</tr>
<tr>
<td width="25%" class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td width="25%" class='label'>
					<select name="prac_status" id="prac_status"  onchange="check_pract_status();" >
						<option value='AP' selected><fmt:message key="eMR.AcceptedbyPractitioner.label" bundle="${mr_labels}"/></option>
						<option value='RM' ><fmt:message key="eMR.RejectedbyPractitionertoMRD.label" bundle="${mr_labels}"/></option>
						<option value='RH' ><fmt:message key="eMR.RejectedbyPractitionertoHOD.label" bundle="${mr_labels}"/></option>	
					</select>
					
				</td>
				<td class="label"   width="25%"><span id="prep_date" Style="display:inline;" ><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></span><span id="prep_date1" Style="display:none;" ><fmt:message key="Common.ReasonforRejection.label" bundle="${common_labels}"/></span><span id="prep_date2" Style="display:none;" ><fmt:message key="eMR.ReasonforReturn.label" bundle="${mr_labels}"/></span></td>
		<td class="fields"  width="25%">
		<span id="prep_date3" Style="display:inline;" ><input type="text" id='prepareDt' name="prepare_date" id="prepare_date" maxlength=16 size=16 onblur="CompareReqDate(this,document.forms[0].request_date);CompareSysDatePrp(this);CompareCollectDate(document.forms[0].hdd_CollectDate,this);" value ="<%=SystemDate_display%>"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].prepare_date.focus();return showCalendar('prepareDt',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' id='prepare_date_Img' align='center'></img></span>
		<span id="prep_date4" Style="display:none;" >
		<select name="reject_medical_rep_reason_1" id="reject_medical_rep_reason_1"  >
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								/*JSONArray medicalreprejectreasonJsonArr_1 = new JSONArray();
								medicalreprejectreasonJsonArr_1  = eMR.MRCommonBean.getRejectReportReasonList(con);	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr_1.size() ; i++) 
								{
										JSONObject json11	= (JSONObject)medicalreprejectreasonJsonArr_1.get(i);
										String reasonCode1  = (String) json11.get("reasonCode");;
										String reasonDesc1  = (String) json11.get("reasonDesc");;
										out.println("<option value='"+reasonCode1+ "'>"+reasonDesc1+"</option>");
										
								}*/		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'   id='reject_medical_rep_reason_img_1' align='center'></img>
		</span>
		</td>
				
</tr>
<tr>
<td  class='label' width="25%" ><span id="Prep" Style="display:inline;" ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${common_labels}"/> </span><span id="Rejec" Style="display:none;"><fmt:message key="eMR.Rejectedbypractitioner.label" bundle="${mr_labels}"/></span><span id="Returnb" Style="display:none;"><fmt:message key="eMR.Returnedbypractitioner.label" bundle="${mr_labels}"/></span></td>
<td class="QueryData" width="25%">&nbsp;<%=loginUserName%><input type='hidden' name='prep_practitioner_id' id='prep_practitioner_id' value="<%=loginUser%>" ></td>
<!-- loginUserName Modified By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 -->
<td class='label'  width='25%'  ><span id="Prep1" Style="display:inline;" >
<fmt:message key="Common.AcceptDateTime.label" bundle="${common_labels}"/></span>
<span id="Rejec1" Style="display:none;"><fmt:message key="Common.RejectDateTime.label" bundle="${common_labels}"/></span>
<span id="Returnb1" Style="display:none;"><fmt:message key="Common.returned.label" bundle="${common_labels}"/> <fmt:message key="Common.datetime.label" bundle="${common_labels}" /> </span>&nbsp;
</td><td nowrap class='querydata'  width='25%' >&nbsp;<%=SystemDate%></td>
<input type='hidden' name='acc_rej_ret_date' id='acc_rej_ret_date' value='<%=SystemDate%>'> 

</tr>
<tr>
<td class="label" width="25%" >
	<!--<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>-->
	<fmt:message key="eMR.PractitionerRemarks.label" bundle="${mr_labels}"/>
	</td>
	<td colspan="" class="fields" width="25%" ><textarea name='remarks_pract' rows=2 cols='40'   onblur="makeValidString(this);chklim(this,200);tab_click('report_details');"  ><%=remarks_pract%></textarea></td>

</tr>
<!-- commented by mujafar for ML-MMOH-CRF-1279
<tr>
<td class="label" width='25%' ><fmt:message key="eMR.RequiredDocuments.label" bundle="${mr_labels}"/></td>
<td   class="fields" colspan="3" width='25%'><textarea   name='reqd_docs' rows=2 cols='60' colspan="3" onblur="makeValidString(this);chklim(this,100);tab_click('report_details');"  disabled></textarea></td>
</tr>
-->
<%}
}else if(call_function.equals("RECEIVE_MEDICAL_REPORT")) 
{	%>
	<tr>
		<td class="label" width="20%" nowrap><fmt:message key="eMR.ReportPreparedDate.label" bundle="${mr_labels}"/></td>
		<td class='querydata' width="15%"><%=prepareDate_Converted%></td>
		<td class="label" id="receive_date_chk_1" width="20%" nowrap>
		<%if(isAcceptRequestByPractAppl){%>
			<fmt:message key="eMR.ReportCompletionDate.label" bundle="${mr_labels}"/>
		<%}else{%>
			<fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/>
		<%}%>
		</td> <!-- added by mujafar for ML-MMOH-CRF-0714 -->
		<td class="fields" id="receive_date_chk_2" width="25%"><input type="text" id='ReceiveDt' name="receive_date" id="receive_date" maxlength=16 size=16 onblur ="chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);" value =""><img src="../../eCommon/images/CommonCalendar.gif" id='ReceiveDt_img'  onClick="document.forms[0].receive_date.focus();return showCalendar('ReceiveDt',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' id='receive_date_Img' align='center'></img></td>
	</tr>
	<tr>
		<td class="label"  nowrap><fmt:message key="eMR.DaystoComplete.label" bundle="${mr_labels}"/></td> 
		<td class='querydata' ><%=no_of_days%></td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td  class='label' width="25%">
		<!-- Below Condition Added By Dharma on 26th Mar 2020 against ML-MMOH-CRF-1473-->
		<%if(isAcceptRequestByPractAppl){%>
		<fmt:message key="eMR.AssignReAssignPractitioner.label" bundle="${mr_labels}"/>
		<%}else{%>
		<fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/>
		<%}%>
		&nbsp;&nbsp;&nbsp;</td>
		<td class="QueryData" width="25%"><%=forwarded_pract_name%></td>
		<td  class='label' width="20%" ><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="QueryData" width="25%"><%=PREPARE_PRACT_NAME%></td>
	</tr>
	<%if(isRejectReportApplicable) { // added by mujafar for ML-MMOH-CRF-0714%>
	<tr>
	<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
	<td width='20%' align='center' class='label' width='25%' id="reject_by_3" style="display:none;"><fmt:message key="eMR.RejectedBy.label" bundle="${mr_labels}"/></td> <!-- label changed for ML-MMOH-CRF-0713 -->
	<td width='30%'  class='QueryData'  colspan='8' align='left' id="reject_by_4" style="display:none;"><%=loginUser%></td> 
	</tr>
	<tr>
	<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
	<td width='20%' align='center' class='label' width='25%' id="reject_on_3" style="display:none;" ><fmt:message key="eMR.RejectedOn.label" bundle="${mr_labels}"/><input type='hidden' name='accpt_rejct_date1' id='accpt_rejct_date1' value='<%=SystemDate%>'></td> <!-- label changed for ML-MMOH-CRF-0713 -->
	<td width='30%'  class='QueryData'  colspan='8' align='left' id="reject_on_4" style="display:none;"><%=SystemDate%></td>
	</tr>
	<tr>
	<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
	<td width='20%' align='center' class='label' width='25%' id="reject_reason_3" style="display:none;" ><fmt:message key="Common.ReasonforRejection.label" bundle="${common_labels}"/></td>
				<td nowrap class='querydata' width='30%' name="reject_medrep_reason_desc_1" id="reject_medrep_reason_desc_1"  style="display:none;" >
			<select name="reject_medical_rep_reason_1" id="reject_medical_rep_reason_1" style="visibility:hidden" >
					<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
					<%
								JSONArray medicalreprejectreasonJsonArr_1 = new JSONArray();
								medicalreprejectreasonJsonArr_1  = eMR.MRCommonBean.getRejectReportReasonList(con,"reject");	
								
								for(int i = 0 ; i < medicalreprejectreasonJsonArr_1.size() ; i++) 
								{
										JSONObject json11	= (JSONObject)medicalreprejectreasonJsonArr_1.get(i);
										String reasonCode1  = (String) json11.get("reasonCode");;
										String reasonDesc1  = (String) json11.get("reasonDesc");;
										out.println("<option value='"+reasonCode1+ "'>"+reasonDesc1+"</option>");
										
								}		
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:hidden"  id='reject_medical_rep_reason_img_1' align='center'></img>
			</td>
	
	</tr>
	<%}%>
<%
	for( int i=0; i<10; i++)
	{
		out.println("<tr><td class=label colspan='4'>&nbsp;</td></tr>");
	}
%>
</table>
<%	
}else if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED"))
{	%>
<table border="0" width="100%" cellspacing='0' cellpadding='3'>
	<!-- Below Condition Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 -->
	<%if(!isAcceptRequestByPractAppl){%>
	<tr>
			<td class="label"  width="25%"><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></td> 
			<TD class='querydata' width="25%"><%=prepareDate_Converted%></td>
			<td class="label"  nowrap width="25%"><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
			<TD class='querydata' width="25%"><%=RecdDate_Converted%></td>
	</tr>
	
	<tr>
		<td class="label"  nowrap><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/></td>
		<td class="fields">
			<input type="text" id='deliveredDt' name="delivered_date" id="delivered_date" maxlength=16 size=16 onblur ="chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);" value ="<%=delivered_date_converted%>" />
			<img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].delivered_date.focus();return showCalendar('deliveredDt',null,'hh:mm');" id='del_img'></img>
			<img src='../../eCommon/images/mandatory.gif' id='delivered_date_Img' align='center'></img>
		</td>
		
		
		
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		
	</tr>
	<%}%>
	<tr>
		<%if(isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		%>
		<td class='label' nowrap><fmt:message key="eMR.DeliveryMode.label" bundle="${mr_labels}"/></td>
		<%}else{%>
		<td class='label' nowrap><fmt:message key="eMR.DeliverDispatchMode.label" bundle="${mr_labels}"/></td>
		<%}%>
		<td class="fields">
			<select name="Despatch_mode" id="Despatch_mode" onchange="enableDisableObjs(this.value)" onblur="tab_click('report_details');" <%=disableModes%>>
			<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%if(isAcceptRequestByPractAppl){%>
				<option value='P'><fmt:message key="eMR.Counter.label" bundle="${mr_labels}"/></option>
				<option value='O'><fmt:message key="eMR.Post.label" bundle="${mr_labels}"/></option>
			<%}else{%>
				<option value='P'><fmt:message key="Common.Personal.label" bundle="${common_labels}"/></option>
				<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			<%}%>
			</select>
			<script>document.forms[0].Despatch_mode.value = "<%=dispatch_mode%>";</script> <%if(isAcceptRequestByPractAppl){%><img src='../../eCommon/images/mandatory.gif' ></img><%}%></td>
		<td  class='label' id="lblDatePostedTD"><fmt:message key="eMR.DatePosted.label" bundle="${mr_labels}"/></td>
		<td class="fields" id="fldDatePostedTD"><input disabled type="text" id='postedDt' name="posted_date" id="posted_date" maxlength=16 size=16 onblur="chkDateVal(this);" value="<%=posted_date%>"  <%=disableModes%> ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].posted_date.focus();return showCalendar('postedDt',null,'hh:mm');" id='postImg' disabled > <%if(isAcceptRequestByPractAppl){%><img src='../../eCommon/images/mandatory.gif' ></img><%}%></td>
		<!-- isAcceptRequestByPractAppl condition added by Dharma on 29th Sep 2020 against Incident 74135-->
		<%if(isAcceptRequestByPractAppl){%>
		<td class="label"  nowrap id="lblDelDateTD" style="display:none;"><fmt:message key="eMR.DeliveredDate.label" bundle="${mr_labels}"/></td>
		<td class="fields" id="fldDelDateTD" style="display:none;" ><input type="text" id='deliveredDt' name="delivered_date" id="delivered_date" maxlength=16 size=16 onblur ="chkDateVal(this);validateDate(this);CompareSysforRecdDate(this);" value ="<%=delivered_date_converted%>"  <%=disableModes%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].delivered_date.focus();return showCalendar('deliveredDt',null,'hh:mm');" id="del_img" ><img src='../../eCommon/images/mandatory.gif' id='delivered_date_Img' align='center'></img></td>
		<%}%>
	</tr>
	<tr id="natIDRow" style = 'display:block;'>
<%	if(accept_national_id_no_yn.equals("Y"))
	{	%>
		<td  class='label'><%=nat_id_prompt%></td>
		<td  class="fields"><input type=text name="del_nric_no" id="del_nric_no" size="20" maxlength="20" value="<%=rtb_national_id_no%>" onBlur="CheckNumberFormat(this);" onKeyPress='return(ChkNumberInput(this,event,0))' disabled ></td>
<%	}else{	%>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
<%	}	%>
		<td  class='label' nowrap><fmt:message key="eMR.ReportTakenBy.label" bundle="${mr_labels}"/></td>
		<td  class="fields"><input type=text name="report_taken" id="report_taken" size='20' value="<%=report_taken_by%>" maxlength="30" disabled ></td>


	</tr>
	<tr id ='altIDRow' style = 'display:block;'>
		<td  class='label'><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
		<td  class="fields"><select name="del_oth_alt_type" id="del_oth_alt_type" Disabled onchange='if(this.value!=""){document.forms[0].del_oth_alt_id.value = "";document.forms[0].del_oth_alt_id.disabled=false;}else{document.forms[0].del_oth_alt_id.value = "";document.forms[0].del_oth_alt_id.disabled=true}'>
			 <option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----
		 <%
				String altIDsql = " select alt_id_type, long_desc short_desc from MP_ALTERNATE_ID_TYPE_LANG_VW where alt_id_type not in (select alt_id1_type from mp_param union select nvl(alt_id2_type,1) from MP_PARAM union select nvl(alt_id3_type,2) from MP_PARAM union select nvl(alt_id4_type,3) from MP_PARAM ) and eff_status = 'E' and language_id = '"+locale+"' order by 2 ";

				oth_stmt = con.createStatement();
				oth_rset = oth_stmt.executeQuery(altIDsql);	
				if(oth_rset != null)
				{
					while (oth_rset.next())
					{
						out.println ( "<Option value=\""+oth_rset.getString("alt_id_type")+"\">"+oth_rset.getString("SHORT_DESC")+"</Option>" ) ;
					}
				}
			
			if(oth_rset != null) oth_rset.close();
			if(oth_stmt != null) oth_stmt.close();

%>		</select>
		<script>
			document.forms[0].del_oth_alt_type.value="<%=rtb_alt_id_type%>";
		</script>
		</td>
		<td  class='label'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>	
		<td class="fields"><input type=text name="del_oth_alt_id" id="del_oth_alt_id" size='20' maxlength="20"  value="<%=rtb_alt_id__no%>" disabled onblur="tab_click('report_details');validateSplchars(this)" ></td>		
	</tr>
	<tr id="postAgeNoRow" style = 'display:block;'>
		<%if(isAcceptRequestByPractAppl){
		// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		%>
		<td  class='label'><fmt:message key="eMR.PostageNo.label" bundle="${mr_labels}"/></td>
		<td class="fields">
		<!--onKeyPress='return allowAlphaNumeric(event)' Removed By Dharma on Apr 15th 2020 against ML-MMOH-CRF-1314 -->
		<input type=text name="file_no" id="file_no" size='20' maxlength="30" value="<%=sec_file_no%>" disabled  onblur="tab_click('report_details')"><%if(isAcceptRequestByPractAppl){%><img src='../../eCommon/images/mandatory.gif' ></img><%}%>		
		</td>
		<%}else{%>
		<td  class='label'><fmt:message key="eMR.SectionFileNo.label" bundle="${mr_labels}"/></td>
		<td class="fields"><input type=text name="file_no" id="file_no" size='20' maxlength="20" value="<%=sec_file_no%>" disabled onKeyPress='return(ChkNumberInput(this,event,0))' onblur="tab_click('report_details')"></td>
		<%}%>
		<td  class='label'>&nbsp;</td>
		<td class="fields"><input class=button type="button" name="address" id="address" <%if(isAcceptRequestByPractAppl){%>value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliveryPostageAddress.label","mr_labels")%>"  <%}else{%>value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliveryDispatchAdd.label","mr_labels")%>"<%}%>onclick="popAddress();" disabled></td>
		
	</tr>
	<tr>
		<td  class='label' width="25%">
		<!-- Below Condition Added By Dharma on 26th Mar 2020 against ML-MMOH-CRF-1473-->
		<%if(isAcceptRequestByPractAppl){%>
		<fmt:message key="eMR.AssignReAssignPractitioner.label" bundle="${mr_labels}"/>
		<%}else{%>
		<fmt:message key="eMR.ForwardedPractitioner.label" bundle="${mr_labels}"/>
		<%}%>
		</td>
		<td class="QueryData" width="25%"><%=forwarded_pract_name%></td>
		<td  class='label' width="25%"><fmt:message key="eMR.PreparedbyPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="QueryData" width="25%"><%=PREPARE_PRACT_NAME%></td>
	</tr>
	<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 Start-->
	<%if(isAcceptRequestByPractAppl){%>
	<tr>
			<td class="label"  width="25%"><fmt:message key="Common.PrepareDate.label" bundle="${common_labels}"/></td>
			<TD class='querydata' width="25%"><%=prepareDate_Converted%></td>
			<td class="label"  nowrap width="25%">
			<!--<fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/>-->
			<fmt:message key="eMR.ReportCompletionDate.label" bundle="${mr_labels}"/>
			
			</td>
			<TD class='querydata' width="25%"><%=RecdDate_Converted%></td>
	</tr>
	<%}%>
	<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 End-->
	<tr>
		<td  class='label' width="25%"><fmt:message key="eMR.RequestedPractitioner.label" bundle="${mr_labels}"/></td>
		<td class="QueryData" width="25%"><%=requesting_pract_name%></td>
		<td  class='label' width="25%"><fmt:message key="eMR.ForwardedHOD.label" bundle="${mr_labels}"/></td>
		<td class="QueryData" width="25%"><%=forwarded_hod_cord_name%><%=forwarded_medical_team_desc%></td> <!-- modified by mujafar for ML-MMOH-CRF-0716 -->
	</tr>
	<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 Start-->
	<%if(isAcceptRequestByPractAppl){%>

	<tr>
		<td class='label'  width="25%" ><fmt:message key="eMR.DeliveryRemarks.label" bundle="${mr_labels}"/></td>
		<td colspan="3" class="fields"><textarea name='delivery_remarks' rows=2 cols='60'  onblur="makeValidString(this);chklim(this,200);" <%=disableModes%> ><%=delivery_remarks%></textarea>&nbsp;</td>
	</tr>
	<%}%>
	<!-- Added By Dharma on 13th Apr 2020 against ML-MMOH-CRF-1314 End-->
	
</table>
<%	} if(call_function.equals("REVISE_MEDICAL_REPORT")) {	%>  
		<table border="0" width="100%" cellspacing='0' cellpadding='3'>
			<tr>
				<td class="label"  nowrap width="25%"><fmt:message key="eMR.RevisedCollectDate.label" bundle="${mr_labels}"/></td>
				<td class="fields" width="25%"><input type="text" id='RevisedCollectdDt' name="revised_collect_date" id="revised_collect_date" maxlength=16 size=16 onblur="chkDateVal(this);validateDate(this);" value =""><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].revised_collect_date.focus();return showCalendar('RevisedCollectdDt',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				<td class="label" width="25%"><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
				<td class="fields" width="25%"><input type="text" name="authorised_by" id="authorised_by" maxlength=16 size=16 value="" onBlur='beforeGetAuthorised(document.forms[0].Authorised_hid,this);'><input type=button class=button name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].authorised_by)"><img src='../../eCommon/images/mandatory.gif' align='center'></img><input type=hidden name="Authorised_hid" id="Authorised_hid" value=''></td>
			</tr>
			<%
				for( int i=0; i<10; i++) {
					out.println("<tr><td class=label colspan='4'>&nbsp;</td>");
				}
			%>
		</table>
<% } %>
<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->  
<input type="hidden" name="cancelledBy" id="cancelledBy" value="<%=cancelledBy%>" >
<input type="hidden" name="cancelledDate" id="cancelledDate" value="<%=cancelledDate%>" >
<input type="hidden" name="cancelledReason" id="cancelledReason" value="<%=cancelledReason%>" >
<input type='hidden' name='loginUser' id='loginUser' value='<%=loginUserName%>'>
<input type='hidden' name='isIncompReqCancelApplicable' id='isIncompReqCancelApplicable' value='<%=isIncompReqCancelApplicable%>'>
<input type='hidden' name='requestStatus' id='requestStatus' value='<%=req_status%>'>
<!--End--> 
<input type='hidden' name='isAcceptRequestByPractAppl' id='isAcceptRequestByPractAppl' value='<%=isAcceptRequestByPractAppl%>'><!-- added by mujafar for ML-MMOH-CRF-1316 -->
<!-- added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 -->
<input type='hidden' name='loginUserID' id='loginUserID' value='<%=loginUser%>'><!-- added by mujafar for ML-MMOH-CRF-0718 -->
<input type='hidden' name='isSelfStatusMRPApplicable' id='isSelfStatusMRPApplicable' value='<%=isSelfStatusMRPApplicable%>'> <!-- added by mujafar for ML-MMOH-CRF-0718 --> 
<input type='hidden' name='isMedicalTeamApplicable' id='isMedicalTeamApplicable' value='<%=isMedicalTeamApplicable%>'> <!-- added by mujafar for ML-MMOH-CRF-0716 -->

<input type='hidden' name='isRejectRequestApplicable' id='isRejectRequestApplicable' value='<%=isRejectRequestApplicable%>'> <!-- added by mujafar for ML-MMOH-CRF-0713 -->
<input type='hidden' name='isRejectReportApplicable' id='isRejectReportApplicable' value='<%=isRejectReportApplicable%>'> <!-- added by mujafar for ML-MMOH-CRF-0714 -->
<input type='hidden' name='isMedicalReportDurationAppl' id='isMedicalReportDurationAppl' value='<%=isMedicalReportDurationAppl%>'> <!-- added by mujafar for ML-MMOH-CRF-0704 -->	
<input type="hidden" name="medrep_pay_int_mode" id="medrep_pay_int_mode" value="<%=medrep_pay_int_mode%>" >
<input type="hidden" name="prepareDate" id="prepareDate" value="<%=prepareDate%>" >
<input type="hidden" name="applCompletionDate" id="applCompletionDate" value="<%=appl_completion_date%>" >
<input type="hidden" name="RequestDate" id="RequestDate" value="<%=reqDate%>" >
<input type="hidden" name="ReceivedDate" id="ReceivedDate" value="<%=RecdDate%>" >
<input type="hidden" name="DeliveredDate" id="DeliveredDate" value="<%=delivered_date%>" >
<input type="hidden" name="applSubmissionDate" id="applSubmissionDate" value="<%=applSubmissionDate%>" >

<input type="hidden" name="hdd_charges_appl_yn" id="hdd_charges_appl_yn" value="<%=charges_appl_yn%>" >
<input type="hidden" name="hdd_addl_charges_yn" id="hdd_addl_charges_yn" value="<%=addl_charges_yn%>" >
<input type="hidden" name="hdd_receipt_no" id="hdd_receipt_no" value="<%=receipt_no%>" >
<input type="hidden" name="hdd_addl_receipt_no" id="hdd_addl_receipt_no" value="<%=addl_receipt_no%>" >
<input type="hidden" name="hdd_amount" id="hdd_amount" value="<%=amount%>" >
<input type="hidden" name="hdd_addl_amount" id="hdd_addl_amount" value="<%=addl_amount%>" >
<input type="hidden" name="hdd_receipt_date" id="hdd_receipt_date" value="<%=receipt_date%>" >
<input type="hidden" name="hdd_addl_receipt_date" id="hdd_addl_receipt_date" value="<%=addl_receipt_date%>" >
<input type='hidden' name="isSpecialtyDefaultApp" id="isSpecialtyDefaultApp" value="<%=isSpecialtyDefaultApp%>" />
<input type='hidden' name="specialtyEffStatus" id="specialtyEffStatus" value="<%=specialtyEffStatus%>" />
<input type='hidden' name="specialtyMRApplYN" id="specialtyMRApplYN" value="<%=specialtyMRApplYN%>" />

<input type='hidden' name='isRequestorAddrDispApp' id='isRequestorAddrDispApp' value='<%=isRequestorAddrDispApp%>'> <!-- Added By Dharma on 13th Dec 2019 against ML-MMOH-CRF-1362 -->
<!--Below line added for this CRF ML-MMOH-CRF-0712-->  
<input type="hidden" name="isMedicalReportRequest" id="isMedicalReportRequest" value="<%=isMedicalReportRequest%>" > 
<input type="hidden" name="medRequestChkbox" id="medRequestChkbox" value="N"> 
<!--End this CRF ML-MMOH-CRF-0712-->
	
	
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='patientId' id='patientId' value="<%=PatientId%>">
	<input type='hidden' name='next_of_kin_name' id='next_of_kin_name' value="<%=next_of_kin_name%>">  <!-- added by mujafar for ML-MMOH-CRF-0762  start-->
	<input type='hidden' name='next_of_kin_nat_id_no' id='next_of_kin_nat_id_no' value="<%=next_of_kin_nat_id_no%>">
	<input type='hidden' name='next_of_kin_alt_id_type' id='next_of_kin_alt_id_type' value="<%=next_of_kin_alt_id_type%>"> 
	<input type='hidden' name='next_of_kin_relation_code' id='next_of_kin_relation_code' value="<%=next_of_kin_relation_code%>"> 
	<input type='hidden' name='next_of_kin_alt_id_no' id='next_of_kin_alt_id_no' value="<%=next_of_kin_alt_id_no%>"> 
	<input type='hidden' name='classification_ind' id='classification_ind' value="<%=classification_ind%>"> 
	<input type='hidden'  name="ret_val1" id="ret_val1"  value="<%=check_list1_status%>~<%=check_list2_status%>~<%=check_list3_status%>~<%=check_list4_status%>~<%=check_list5_status%>~<%=check_list6_status%>~<%=check_list7_status%>~<%=check_list8_status%>~<%=check_list9_status%>~<%=check_list10_status%>~<%=check_list11_status%>~<%=check_list12_status%>~<%=check_list13_status%>~<%=check_list14_status%>~<%=check_list15_status%>~<%=check_list16_status%>~<%=check_list17_status%>~<%=check_list18_status%>~<%=check_list19_status%>~<%=check_list20_status%>~<%=check_list21_status%>~<%=check_list22_status%>~<%=check_list23_status%>~<%=check_list24_status%>~<%=check_list25_status%>" > <!-- added by mujafar for ML-MMOH-CRF-0762 end --><!--Modified by mujafar for ML-MMOH-CRF-0762 -->
	<input type='hidden' name='encounterid' id='encounterid' value="<%=encounterid%>">
	<input type='hidden' name='LastDet' id='LastDet' value="<%=LastDet%>">
	

	<input type='hidden' name='facility_id' id='facility_id' value="<%=Facility_Id%>"> 
	<input type='hidden' name='request_id' id='request_id' value="<%=request_id%>">
	<input type='hidden' name='EncounterIDS' id='EncounterIDS' value="">
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>">
	<input type='hidden' name='sysdate' id='sysdate' value='<%=SystemDate%>'>
	<input type='hidden' name='SystemDate_display' id='SystemDate_display' value='<%=SystemDate_display%>'>
	<input type='hidden' name='request_date' id='request_date' value='<%=reqDate%>'>
	<input type='hidden' name='hdd_Request_desc' id='hdd_Request_desc' value="<%=Request_desc%>">
	<input type='hidden' name='hdd_Medical_members' id='hdd_Medical_members' value="<%=Medical_members%>">
	<input type='hidden' name='hdd_Pract_name' id='hdd_Pract_name' value="<%=Pract_name%>">
	<input type='hidden' name='hdd_team_desc' id='hdd_team_desc' value="<%=team_desc%>">
	<input type='hidden' name='hdd_CollectDate' id='hdd_CollectDate' value="<%=CollectDate%>">
	<input type='hidden' name='hdd_PrepareDate' id='hdd_PrepareDate' value="<%=prepareDate%>">
	<input type='hidden' name='hdd_RecieveDate' id='hdd_RecieveDate' value="<%=RecdDate%>">
	<input type='hidden' name='hdd_remarks' id='hdd_remarks' value="<%=remarks%>">
	<input type='hidden' name='hdd_requestor_code' id='hdd_requestor_code' value="<%=requestor_code%>">
	<input type='hidden' name='hdd_team_code' id='hdd_team_code' value="<%=team_code%>">
	<input type='hidden' name='hdd_pract_code' id='hdd_pract_code' value="<%=pract_code%>">
	<input type='hidden' name='accession_num' id='accession_num' value="<%=accession_num%>">
	<input type='hidden' name='event_status' id='event_status' value="<%=event_status%>">
	<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
	<input type='hidden' name='new_func_id' id='new_func_id' value="<%=new_func_id%>">
	<input type='hidden' name='old_revised_collect_date' id='old_revised_collect_date' value="<%=revised_collect_date%>">
	<input type='hidden' name='mode' id='mode' value="insert"> <!-- used for address --> 

	<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start--> 
	<input type=hidden  name="ret_val" id="ret_val"  value="<%=chklst_consent_fr_pat%>~<%=chklst_ident_doc%>~<%=chklst_marital_cert%>~<%=chklst_stat_dec%>~<%=chklst_consent_fr_embsy%>~<%=chklst_payment%>" />
	<!--Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] End-->

	<!--Added By Ashwini on 21-Aug-2017 for	ML-MMOH-CRF-0708-->
	<input type='hidden' name='isChckLstApplicable' id='isChckLstApplicable' value="<%=isChckLstApplicable%>">
	<input type="hidden" name="applicationMode" id="applicationMode" value="<%=applicationMode%>" >
	<input type="hidden" name="collectionMode" id="collectionMode" value="<%=collectionMode%>" >
	<input type="hidden" name="notificationMode" id="notificationMode" value="<%=notificationMode%>" >
	<!--ML-MMOH-CRF-0708 End-->

<%	if(!revised_collect_date.equals(""))
	{	%>
			<input type='hidden' name='hid_revised_collect_date' id='hid_revised_collect_date' value="<%=revised_collect_date%>">
<%	}	%>

<!-- ===== Common address component fields ===== -->
	<input type='hidden' name='change_address' id='change_address' value=''>
	<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
	<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
	<input type='hidden' name='addr1_type' id='addr1_type' value=''>
	<input type='hidden' name='addr_line1' id='addr_line1' value='' >
	<input type='hidden' name='addr_line2' id='addr_line2' value='' >
	<input type='hidden' name='addr_line3' id='addr_line3' value='' >
	<input type='hidden' name='addr_line4' id='addr_line4' value='' >
	<input type='hidden' name='res_town_code' id='res_town_code' value='' >
	<input type='hidden' name='res_town_desc' id='res_town_desc' value='' >
	<input type='hidden' name='res_area_code' id='res_area_code' value=''>
	<input type='hidden' name='res_area_desc' id='res_area_desc' value=''>
	<input type='hidden' name='postal_code' id='postal_code' value='' >	
	<input type='hidden' name='region_code' id='region_code' value='' >	
	<input type='hidden' name='region_desc' id='region_desc' value='' >	
	<input type='hidden' name='country_code' id='country_code' value='' >
	<input type='hidden' name='country_desc' id='country_desc' value=''>
	<input type='hidden' name='contact1_name' id='contact1_name' value=''>
	<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>
	<input type='hidden' name='addr2_type' id='addr2_type' value=''>
	<input type='hidden' name='mail_addr_line1' id='mail_addr_line1'  value=''>
	<input type='hidden' name='mail_addr_line2' id='mail_addr_line2'  value=''>
	<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value='' >
	<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='' >
	<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value=''>
	<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value='' >
	<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='' >
	<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value='' >
	<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='' >
	<input type='hidden' name='mail_region_code' id='mail_region_code' value='' >
	<input type='hidden' name='mail_region_desc' id='mail_region_desc' value='' >
	<input type='hidden' name='mail_country_code' id='mail_country_code' value=''>
	<input type='hidden' name ='mail_country_desc' value=''>
	<input type='hidden' name='contact2_name' id='contact2_name' value=''>
	<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>
	<input type='hidden' name='contact1_no' id='contact1_no' value=''>
	<input type='hidden' name='contact2_no' id='contact2_no' value=''>
	<input type='hidden' name='email' id='email' value=''>
	<input type='hidden' name='Pat_name' id='Pat_name' value='<%=Pat_name%>'>
	<input type='hidden' name='patient_name' id='patient_name' value='<%=patient_name%>'>
	<input type='hidden' name='classification_appl_yn' id='classification_appl_yn' value='<%=classification_appl_yn%>'> <!-- added by mujafar for ML-MMOH-CRF-0762 start -->
	<input type='hidden' name='national_id_no' id='national_id_no' value='<%=national_id_no%>'>
	<input type='hidden' name='oth_alt_id_type' id='oth_alt_id_type' value='<%=oth_alt_id_type%>'>
	<input type='hidden' name='oth_alt_id_no' id='oth_alt_id_no' value='<%=oth_alt_id_no%>'>
	<input type='hidden' name='req_type_status' id='req_type_status' value=''>
	<input type='hidden' name='oth_alt_type' id='oth_alt_type' value='<%=oth_alt_type%>'> 
	<input type='hidden' name='oth_alt_id' id='oth_alt_id' value='<%=oth_alt_id%>' > 
	<input type='hidden' name='count' id='count' value='<%=count%>' > <!-- added by mujafar for ML-MMOH-CRF-0762 end -->

	<!-- ADDRESS FIELDS FOR APPLICANT ... -->
	<input type='hidden' name='appl_addr_line1' id='appl_addr_line1' value="<%=addr_line1%>" >
	<input type='hidden' name='appl_addr_line2' id='appl_addr_line2' value="<%=addr_line2%>" >
	<input type='hidden' name='appl_addr_line3' id='appl_addr_line3' value="<%=addr_line3%>" >
	<input type='hidden' name='appl_addr_line4' id='appl_addr_line4' value="<%=addr_line4%>" >
	<input type='hidden' name='appl_res_town_code' id='appl_res_town_code' value="<%=res_town_code%>" >
	<input type='hidden' name='appl_res_town_desc' id='appl_res_town_desc' value="<%=res_town_desc%>" >
	<input type='hidden' name='appl_res_area_code' id='appl_res_area_code' value="<%=res_area_code%>" >
	<input type='hidden' name='appl_res_area_desc' id='appl_res_area_desc' value="<%=res_area_desc%>" >
	<input type='hidden' name='appl_region_code' id='appl_region_code' value="<%=region_code%>" >
	<input type='hidden' name='appl_region_desc' id='appl_region_desc' value="<%=region_desc%>" >
	<input type='hidden' name='appl_postal_code' id='appl_postal_code' value="<%=postal_code%>" >
	<input type='hidden' name='appl_postal_desc' id='appl_postal_desc' value="<%=postal_code%>" >
	<input type='hidden' name='appl_country_desc' id='appl_country_desc' value="<%=res_country_desc%>" >
	<input type='hidden' name='appl_country_code' id='appl_country_code' value="<%=res_country_code%>" >

	<!-- ADDRESS FIELDS FOR OTHERS ... -->
	<input type='hidden' name='Oth_appl_addr_line1' id='Oth_appl_addr_line1' value="">
	<input type='hidden' name='Oth_appl_addr_line2' id='Oth_appl_addr_line2' value="">
	<input type='hidden' name='Oth_appl_addr_line3' id='Oth_appl_addr_line3' value="">
	<input type='hidden' name='Oth_appl_addr_line4' id='Oth_appl_addr_line4' value="">
	<input type='hidden' name='Oth_appl_res_town_desc' id='Oth_appl_res_town_desc' value="">
	<input type='hidden' name='Oth_appl_res_town_code' id='Oth_appl_res_town_code' value="">
	<input type='hidden' name='Oth_appl_res_area_desc' id='Oth_appl_res_area_desc' value="">
	<input type='hidden' name='Oth_appl_res_area_code' id='Oth_appl_res_area_code' value="">
	<input type='hidden' name='Oth_appl_region_desc' id='Oth_appl_region_desc' value="">
	<input type='hidden' name='Oth_appl_region_code' id='Oth_appl_region_code' value="">
	<input type='hidden' name='Oth_appl_postal_desc' id='Oth_appl_postal_desc' value="">
	<input type='hidden' name='Oth_appl_postal_code' id='Oth_appl_postal_code' value="">
	<input type='hidden' name='Oth_appl_country_desc' id='Oth_appl_country_desc' value="">
	<input type='hidden' name='Oth_appl_country_code' id='Oth_appl_country_code' value="">

	<!-- ADDRESS FIELDS FOR PERSONAL DELIVERY ... -->
	<input type='hidden' name='personal_del_addr_line1' id='personal_del_addr_line1' value="<%=addr_line1%>">
	<input type='hidden' name='personal_del_addr_line2' id='personal_del_addr_line2' value="<%=addr_line2%>">
	<input type='hidden' name='personal_del_addr_line3' id='personal_del_addr_line3' value="<%=addr_line3%>">
	<input type='hidden' name='personal_del_addr_line4' id='personal_del_addr_line4' value="<%=addr_line4%>">
	<input type='hidden' name='personal_del_res_town_desc' id='personal_del_res_town_desc' value="<%=res_town_desc%>">
	<input type='hidden' name='personal_del_res_town_code' id='personal_del_res_town_code' value="<%=res_town_code%>">
	<input type='hidden' name='personal_del_res_area_desc' id='personal_del_res_area_desc' value="<%=res_area_desc%>">
	<input type='hidden' name='personal_del_res_area_code' id='personal_del_res_area_code' value="<%=res_area_code%>">
	<input type='hidden' name='personal_del_region_desc' id='personal_del_region_desc' value="<%=region_desc%>">
	<input type='hidden' name='personal_del_region_code' id='personal_del_region_code' value="<%=region_code%>">
	<input type='hidden' name='personal_del_postal_desc' id='personal_del_postal_desc' value="<%=postal_code%>">
	<input type='hidden' name='personal_del_postal_code' id='personal_del_postal_code' value="<%=postal_code%>">
	<input type='hidden' name='personal_del_country_desc' id='personal_del_country_desc' value="<%=res_country_desc%>">
	<input type='hidden' name='personal_del_country_code' id='personal_del_country_code' value="<%=res_country_code%>">


<!-- ADDRESS FIELDS FOR Requestor DELIVERY ... -->
	<input type='hidden' name='requestor_addr_line1' id='requestor_addr_line1' value="<%=addr_line1%>">
	<input type='hidden' name='requestor_addr_line2' id='requestor_addr_line2' value="<%=addr_line2%>">
	<input type='hidden' name='requestor_addr_line3' id='requestor_addr_line3' value="<%=addr_line3%>">
	<input type='hidden' name='requestor_addr_line4' id='requestor_addr_line4' value="<%=addr_line4%>">
	<input type='hidden' name='requestor_res_town_desc' id='requestor_res_town_desc' value="<%=res_town_desc%>">
	<input type='hidden' name='requestor_res_town_code' id='requestor_res_town_code' value="<%=res_town_code%>">
	<input type='hidden' name='requestor_res_area_desc' id='requestor_res_area_desc' value="<%=res_area_desc%>">
	<input type='hidden' name='requestor_res_area_code' id='requestor_res_area_code' value="<%=res_area_code%>">
	<input type='hidden' name='requestor_region_desc' id='requestor_region_desc' value="<%=region_desc%>">
	<input type='hidden' name='requestor_region_code' id='requestor_region_code' value="<%=region_code%>">
	<input type='hidden' name='requestor_postal_desc' id='requestor_postal_desc' value="<%=postal_code%>">
	<input type='hidden' name='requestor_postal_code' id='requestor_postal_code' value="<%=postal_code%>">
	<input type='hidden' name='requestor_country_desc' id='requestor_country_desc' value="<%=res_country_desc%>">
	<input type='hidden' name='requestor_country_code' id='requestor_country_code' value="<%=res_country_code%>">

	<!-- ADDRESS FIELDS FOR OTHER DELIVERY ... -->
	<input type='hidden' name='other_del_addr_line1' id='other_del_addr_line1' value="<%=addr_line1%>">
	<input type='hidden' name='other_del_addr_line2' id='other_del_addr_line2' value="<%=addr_line2%>">
	<input type='hidden' name='other_del_addr_line3' id='other_del_addr_line3' value="<%=addr_line3%>">
	<input type='hidden' name='other_del_addr_line4' id='other_del_addr_line4' value="<%=addr_line4%>">
	<input type='hidden' name='other_del_res_town_desc' id='other_del_res_town_desc' value="<%=res_town_desc%>">
	<input type='hidden' name='other_del_res_town_code' id='other_del_res_town_code' value="<%=res_town_code%>">
	<input type='hidden' name='other_del_res_area_desc' id='other_del_res_area_desc' value="<%=res_area_desc%>">
	<input type='hidden' name='other_del_res_area_code' id='other_del_res_area_code' value="<%=res_area_code%>">
	<input type='hidden' name='other_del_region_desc' id='other_del_region_desc' value="<%=region_desc%>">
	<input type='hidden' name='other_del_region_code' id='other_del_region_code' value="<%=region_code%>">
	<input type='hidden' name='other_del_postal_desc' id='other_del_postal_desc' value="<%=postal_code%>">
	<input type='hidden' name='other_del_postal_code' id='other_del_postal_code' value="<%=postal_code%>">
	<input type='hidden' name='other_del_country_desc' id='other_del_country_desc' value="<%=res_country_desc%>">
	<input type='hidden' name='other_del_country_code' id='other_del_country_code' value="<%=res_country_code%>">

	<!-- ADDRESS FIELDS FOR NKIN ...  -->
	<input type='hidden' name='nkin_addr_line1' id='nkin_addr_line1' value="<%=nkin_addr_line1%>">
	<input type='hidden' name='nkin_addr_line2' id='nkin_addr_line2' value="<%=nkin_addr_line2%>">
	<input type='hidden' name='nkin_addr_line3' id='nkin_addr_line3' value="<%=nkin_addr_line3%>">
	<input type='hidden' name='nkin_addr_line4' id='nkin_addr_line4' value="<%=nkin_addr_line4%>">
	<input type='hidden' name='nkin_res_town_desc' id='nkin_res_town_desc' value="<%=nkin_res_town_desc%>">
	<input type='hidden' name='nkin_res_town_code' id='nkin_res_town_code' value="<%=nkin_res_town_code%>">
	<input type='hidden' name='nkin_res_area_desc' id='nkin_res_area_desc' value="<%=nkin_res_area_desc%>">
	<input type='hidden' name='nkin_res_area_code' id='nkin_res_area_code' value="<%=nkin_res_area_code%>">
	<input type='hidden' name='nkin_region_desc' id='nkin_region_desc' value="<%=nkin_region_desc%>">
	<input type='hidden' name='nkin_region_code' id='nkin_region_code' value="<%=nkin_region_code%>">
	<input type='hidden' name='nkin_postal_desc' id='nkin_postal_desc' value="<%=nkin_postal_code%>"> 
	<input type='hidden' name='nkin_postal_code' id='nkin_postal_code' value="<%=nkin_postal_code%>"> 
	<input type='hidden' name='nkin_country_desc' id='nkin_country_desc' value="<%=nkin_country_desc%>"> 
	<input type='hidden' name='nkin_country_code' id='nkin_country_code' value="<%=nkin_country_code%>"> 

	<!-- ADDRESS FIELDS FOR FTON ...  -->
	<input type='hidden' name='fton_addr_line1' id='fton_addr_line1' value="<%=fton_addr_line1%>">
	<input type='hidden' name='fton_addr_line2' id='fton_addr_line2' value="<%=fton_addr_line2%>">
	<input type='hidden' name='fton_addr_line3' id='fton_addr_line3' value="<%=fton_addr_line3%>">
	<input type='hidden' name='fton_addr_line4' id='fton_addr_line4' value="<%=fton_addr_line4%>">
	<input type='hidden' name='fton_res_town_desc' id='fton_res_town_desc' value="<%=fton_res_town_desc%>">
	<input type='hidden' name='fton_res_town_code' id='fton_res_town_code' value="<%=fton_res_town_code%>">
	<input type='hidden' name='fton_res_area_desc' id='fton_res_area_desc' value="<%=fton_res_area_desc%>">
	<input type='hidden' name='fton_res_area_code' id='fton_res_area_code' value="<%=fton_res_area_code%>">
	<input type='hidden' name='fton_region_desc' id='fton_region_desc' value="<%=fton_region_desc%>">
	<input type='hidden' name='fton_region_code' id='fton_region_code' value="<%=fton_region_code%>">
	<input type='hidden' name='fton_postal_desc' id='fton_postal_desc' value="<%=fton_postal_code%>"> 
	<input type='hidden' name='fton_postal_code' id='fton_postal_code' value="<%=fton_postal_code%>"> 
	<input type='hidden' name='fton_country_desc' id='fton_country_desc' value="<%=fton_country_desc%>"> 
	<input type='hidden' name='fton_country_code' id='fton_country_code' value="<%=fton_country_code%>"> 

	<!-- ADDRESS FIELDS FOR EMPLR ...  -->
	<input type='hidden' name='emplr_addr_line1' id='emplr_addr_line1' value="<%=emplr_addr_line1%>">
	<input type='hidden' name='emplr_addr_line2' id='emplr_addr_line2' value="<%=emplr_addr_line2%>">
	<input type='hidden' name='emplr_addr_line3' id='emplr_addr_line3' value="<%=emplr_addr_line3%>">
	<input type='hidden' name='emplr_addr_line4' id='emplr_addr_line4' value="<%=emplr_addr_line4%>">
	<input type='hidden' name='emplr_res_town_desc' id='emplr_res_town_desc' value="<%=emplr_res_town_desc%>">
	<input type='hidden' name='emplr_res_town_code' id='emplr_res_town_code' value="<%=emplr_res_town_code%>">
	<input type='hidden' name='emplr_res_area_desc' id='emplr_res_area_desc' value="<%=emplr_res_area_desc%>">
	<input type='hidden' name='emplr_res_area_code' id='emplr_res_area_code' value="<%=emplr_res_area_code%>">
	<input type='hidden' name='emplr_region_desc' id='emplr_region_desc' value="<%=emplr_region_desc%>">
	<input type='hidden' name='emplr_region_code' id='emplr_region_code' value="<%=emplr_region_code%>">
	<input type='hidden' name='emplr_postal_desc' id='emplr_postal_desc' value="<%=emplr_postal_code%>"> 
	<input type='hidden' name='emplr_postal_code' id='emplr_postal_code' value="<%=emplr_postal_code%>"> 
	<input type='hidden' name='emplr_country_desc' id='emplr_country_desc' value="<%=emplr_country_desc%>"> 
	<input type='hidden' name='emplr_country_code' id='emplr_country_code' value="<%=emplr_country_code%>"> 
<!-- ===== Common address component fields ===== -->

	<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
	<input type='hidden' name='indicator_req' id='indicator_req' value="<%=indicator%>">  
	<input type='hidden' name='requestor_type_ind' id='requestor_type_ind' value="<%=requestor_type_ind%>"> <!-- added by mujafar for ML-MMOH-CRF-0762  -->

	<!--Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707-->

	<input type='hidden' name='self_contact_no1' id='self_contact_no1' value="<%=self_contact_no1%>">
	<input type='hidden' name='self_contact_no2' id='self_contact_no2' value="<%=self_contact_no2%>">
	<input type='hidden' name='self_appl_email_id' id='self_appl_email_id' value="<%=self_appl_email_id%>">

	<input type='hidden' name='nkin_contact_no1' id='nkin_contact_no1' value="<%=nkin_contact_no1%>">
	<input type='hidden' name='nkin_contact_no2' id='nkin_contact_no2' value="<%=nkin_contact_no2%>">
	<input type='hidden' name='nkin_appl_email_id' id='nkin_appl_email_id' value="<%=nkin_appl_email_id%>">

	<input type='hidden' name='fton_contact_no1' id='fton_contact_no1' value="<%=fton_contact_no1%>">
	<input type='hidden' name='fton_contact_no2' id='fton_contact_no2' value="<%=fton_contact_no2%>">
	<input type='hidden' name='fton_appl_email_id' id='fton_appl_email_id' value="<%=fton_appl_email_id%>">

	<input type='hidden' name='emplr_contact_no1' id='emplr_contact_no1' value="<%=emplr_contact_no1%>">
	<input type='hidden' name='emplr_contact_no2' id='emplr_contact_no2' value="<%=emplr_contact_no2%>">
	<input type='hidden' name='emplr_appl_email_id' id='emplr_appl_email_id' value="">

	<input type='hidden' name='other_contact_no1' id='other_contact_no1' value="">
	<input type='hidden' name='other_contact_no2' id='other_contact_no2' value="">
	<input type='hidden' name='other_appl_email_id' id='other_appl_email_id' value="">

	<input type='hidden' name='requestor_contact_no1' id='requestor_contact_no1' value="">
	<input type='hidden' name='requestor_contact_no2' id='requestor_contact_no2' value="">
	<input type='hidden' name='requestor_appl_email_id' id='requestor_appl_email_id' value="">
	
	<input type='hidden' name='other_application_ref_no' id='other_application_ref_no' value="<%=ourRefDtlsDisp%>"><!-- Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 -->
	<!--ML-MMOH-CRF-0707-->
	
	<input type='hidden' name='temp_pract' id='temp_pract' value=""> <!--added by mujafar for ML-MMOH-CRF-1302 -->
	
	<!--Below line added for this ML-MMOH-CRF-0860.2-->
	<input type='hidden' name='increasedaddressLength' id='increasedaddressLength' value="<%=increasedaddressLength%>"> 
	<!--End this ML-MMOH-CRF-0860.2-->
	<input type='hidden' name='tot_amount' id='tot_amount' value="<%=tot_amount %>" />
	
<script>
// Patient Address Details for Button ...
	//parent.DetailFrame.document.MedicalRecordReqForm.charges_appllicable= "<%=charges_appl_yn%>";
	document.forms[0].addr_line1.value="<%=addr_line1%>";
	document.forms[0].addr_line2.value="<%=addr_line2%>";
	document.forms[0].addr_line3.value="<%=addr_line3%>";
	document.forms[0].addr_line4.value="<%=addr_line4%>";
	document.forms[0].res_town_code.value="<%=res_town_code%>";
	document.forms[0].res_town_desc.value="<%=res_town_desc%>";
	document.forms[0].res_area_code.value="<%=res_area_code%>";
	document.forms[0].res_area_desc.value="<%=res_area_desc%>";
	document.forms[0].region_code.value="<%=region_code%>";
	document.forms[0].region_desc.value="<%=region_desc%>";
	document.forms[0].country_code.value="<%=res_country_code%>";
	document.forms[0].country_desc.value="<%=res_country_desc%>";
	document.forms[0].postal_code.value="<%=postal_code%>";
	document.forms[0].contact1_name.value="";
	document.forms[0].addr2_type.value="";
	document.forms[0].mail_addr_line1.value="<%=mail_addr_line1%>";
	document.forms[0].mail_addr_line2.value="<%=mail_addr_line2%>";
	document.forms[0].mail_addr_line3.value="<%=mail_addr_line3%>";
	document.forms[0].mail_addr_line4.value="<%=mail_addr_line4%>";
	document.forms[0].mail_res_town_code.value="<%=mail_res_town_code%>";
	document.forms[0].mail_res_town_desc.value="<%=mail_res_town_desc%>";
	document.forms[0].mail_res_area_code.value="<%=mail_res_area_code%>";
	document.forms[0].mail_res_area_desc.value="<%=mail_res_area_desc%>";
	document.forms[0].mail_postal_code.value="<%=mail_postal_code%>";
	document.forms[0].mail_region_code.value="<%=mail_region_code%>";
	document.forms[0].mail_region_desc.value="<%=mail_region_desc%>";
	document.forms[0].mail_country_code.value="<%=mail_country_code%>";
	document.forms[0].mail_country_desc.value="<%=mail_country_desc%>";
	document.forms[0].contact2_name.value="";
	document.forms[0].contact1_no.value="<%=contact1_no%>";
	document.forms[0].contact2_no.value="<%=contact2_no%>";	
	document.forms[0].email.value="<%=email%>";
	/*parent.DetailFrame.document.MedicalRecordReqForm.addr_line1="<%=addr_line1%>";
	parent.DetailFrame.document.MedicalRecordReqForm.addr_line2="<%=addr_line2%>";
	parent.DetailFrame.document.MedicalRecordReqForm.addr_line3="<%=addr_line3%>";
	parent.DetailFrame.document.MedicalRecordReqForm.addr_line4="<%=addr_line4%>";
	parent.DetailFrame.document.MedicalRecordReqForm.res_town_code="<%=res_town_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.res_town_desc="<%=res_town_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.res_area_code="<%=res_area_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.res_area_desc="<%=res_area_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.region_code="<%=region_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.region_desc="<%=region_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.country_code="<%=res_country_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.country_desc="<%=res_country_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.postal_code="<%=postal_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.contact1_name="";
	parent.DetailFrame.document.MedicalRecordReqForm.addr2_type="";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line1="<%=mail_addr_line1%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line2="<%=mail_addr_line2%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line3="<%=mail_addr_line3%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_addr_line4="<%=mail_addr_line4%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_res_town_code="<%=mail_res_town_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_res_town_desc="<%=mail_res_town_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_res_area_code="<%=mail_res_area_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_res_area_desc="<%=mail_res_area_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_country_code="<%=mail_country_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_postal_code="<%=mail_postal_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_region_code="<%=mail_region_code%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_region_desc="<%=mail_region_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.mail_country_desc="<%=mail_country_desc%>";
	parent.DetailFrame.document.MedicalRecordReqForm.contact2_name="";
	parent.DetailFrame.document.MedicalRecordReqForm.contact1_no="<%=contact1_no%>";
	parent.DetailFrame.document.MedicalRecordReqForm.contact2_no="<%=contact2_no%>";
	parent.DetailFrame.document.MedicalRecordReqForm.email="<%=email%>";*/
// End of Address Details Display 
</script>

<%


}catch(Exception e)
{
	//out.println("err in try catch : "+e.toString());
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>


</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

