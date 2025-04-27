/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var invalidCode = null;

function returnToResultReporting(resultReportingURL, freqExplApplies)
{
	var from=document.result_entry_btn.from.value;
	if(from=="TaskList")
	{
		top.content.workAreaFrame.location.href="../../eCA/jsp/TaskList.jsp?"+resultReportingURL+"&backfrom=ResultEntry";

	}
	else
	{
	var header_values = document.result_entry_btn.header_values.value;
	//alert("in result entry js file header_values=="+header_values)
	if(parent.ResultEntryReport.location.href.indexOf('blank.html') >= 1)
	{		
		freqExplApplies = '';	// This will take the screen to Result Reporting on second click to cancel.
		
		while(resultReportingURL.indexOf("&showRecordButton=N") >= 1)
			resultReportingURL = resultReportingURL.replace("&showRecordButton=N","");
		
		while(resultReportingURL.indexOf("&freqExplApplies=Y") >= 1)
			resultReportingURL = resultReportingURL.replace("&freqExplApplies=Y","");
		
		while(resultReportingURL.indexOf("&requestFrom=FE") >= 1)
			resultReportingURL = resultReportingURL.replace("&requestFrom=FE","");
		
		//alert(resultReportingURL);
	}
	
	if(freqExplApplies == 'Y')
	{
		resetAllChildOrderRows();
		parent.ResultEntryReport.location.href = '../../eCommon/html/blank.html';
		if(parent.ResultEntryHeader)
			parent.ResultEntryHeader.location.href = '../../eCommon/html/blank.html';
		parent.ResultEntryDtl.location.href = '../../eCommon/html/blank.html';
		parent.ResultEntryBtn.location.href = 'ResultEntryBtn.jsp?'+resultReportingURL+'&freqExplApplies=Y&showRecordButton=N';
	}
	else if(resultReportingURL.indexOf("requestFrom") >= 0)
	{
		//alert("This is from authorization.");
		top.content.workAreaFrame.location.href="ReportAuthorization.jsp?&header_values="+header_values+"&CancelFlag=Y";
		//parent.window.returnValue = "";
		//parent.window.close();
	}
	else{
		var option_id  = parent.ResultEntryBtn.document.forms[0].option_id.value ;
	//alert("option_id="+"ResultReporting.jsp?"+resultReportingURL+"&CanelFlag=Y&option_id="+option_id);
	//alert(resultReportingURL);
	if(resultReportingURL.indexOf("&CanelFlag=Y") != -1)
		resultReportingURL = resultReportingURL.substr(0,resultReportingURL.indexOf("&CanelFlag=Y"));
	

	//resultReportingURL = resultReportingURL.substr(resultReportingURL.indexOf("&CanelFlag=Y"),resultReportingURL.length-1);
	if(top.content)
		
		top.content.workAreaFrame.location.href="ResultReporting.jsp?"+resultReportingURL+"&CanelFlag=Y&option_id="+option_id;
	
	else{
	
		parent.window.returnValue = "";
		parent.window.close();
	}
	//parent.parent.thirdframe.location.href="ResultReporting.jsp?CanelFlag=Y&option_id="+option_id;
	}
	}
}
function callClose(){
	//alert("here");
/*	var procFrmObj = parent.proc_detail.document.result_entry_proclink;
	
	var chk_val= procFrmObj.chk_val.value;
	var proc_scheme_code= procFrmObj.proc_scheme_code.value;
	var proc_link_resulting_option_result=procFrmObj.proc_link_resulting_option_result.value;

	var retval=new Array();
	retval[0]= proc_link_resulting_option_result;
	retval[1]= chk_val;
	retval[2]= proc_scheme_code;

	window.returnValue = retval;
	window.close();*/
}

function callRetainStatus(obj){
	
	var procFrmObj = parent.proc_detail.document.result_entry_proclink;
	var count = procFrmObj.totalRecs.value;
	//eval("procFrmObj.default_yn"+0).value = "R";
	var chk_val="",proc_code="";
	var retval= new Array();var atLeastOne=false; var optional=false;
	var cnt = procFrmObj.cnt.value;
	for(var i=0;i<=cnt;i++){
		var grp_cnt= eval("procFrmObj.grp_cnt"+i).value ;atLeastOne= false;
		for(var j=0;j<grp_cnt;j++){
			//alert(eval("procFrmObj.proc_link_resulting_option"+i+j).value);
			//alert(eval("procFrmObj.proc_chk"+i+j).checked);
			//alert(atLeastOne);
			if(eval("procFrmObj.proc_link_resulting_option"+i+j).value == "M" && eval("procFrmObj.proc_chk"+i+j).checked == true && atLeastOne == false)
			{
				retval[0] = "O";
				atLeastOne= true;
				optional=true;
				break;
			}else if(eval("procFrmObj.proc_link_resulting_option"+i+j).value == "M" && eval("procFrmObj.proc_chk"+i+j).checked == false && atLeastOne == false)
			{
				retval[0] = "M" ;
				optional=false;
			}
			else
			{
				retval[0] = "O";
				optional=true;
			}
		}
		if(!atLeastOne && !optional){
			//alert(getMessage("ATLEAST_ONE_RECORD","OR"));
			alert(getMessage("ATLEAST_ONE_PROC_CODE","OR"));
			//alert("AP-OR00257 Select Atleast One Mandatory Field");
			return false;
		}
	}
	
	for(var i=0;i<=cnt;i++){
		var grp_cnt= eval("procFrmObj.grp_cnt"+i).value ;
		for(var j=0;j<grp_cnt;j++){
			if(eval("procFrmObj.proc_chk"+i+j).checked == true){
				//alert(j);
				chk_val += "Y"+"~";
				proc_code +=eval("procFrmObj.line_srl_num"+i+j).value+"~"+eval("procFrmObj.parent_srl_no"+i+j).value+"~"+eval("procFrmObj.proc_scheme"+i+j).value+"~"+eval("procFrmObj.proc_code"+i+j).value+"*";
			}else
				chk_val += "N"+"~";
		}
	}
	
	//alert(proc_code);
	//alert("=="+obj+"==");
	if(obj == ''){
		retval[1]=chk_val;
		retval[2]=proc_code;
		var retVal = retval[0]+"&"+retval[1]+"&"+retval[2];
		//window.returnValue = retval;
		window.returnValue = retVal;
	}else{
		var order_id = procFrmObj.order_id.value;
		var order_type_code = procFrmObj.order_type_code.value;
		var patient_id = procFrmObj.patient_id.value;
		var patient_class = procFrmObj.patient_class.value;
		var encounter_id = procFrmObj.encounter_id.value;
		//alert("=="+order_type_code+"---");
		var bean_id = "Or_ResultReporting" ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += "order_id=\""+ order_id +"\" " ;
		xmlStr += "order_type_code=\""+ order_type_code +"\" " ;
		//xmlStr += "report_srl_no=\"1\" " ;
		xmlStr += "proc_scheme_code=\""+ proc_code +"\" " ;
		xmlStr += "patient_id=\""+ patient_id +"\" " ;
		xmlStr += "patient_class=\""+ patient_class +"\" " ;
		xmlStr += "encounter_id=\""+ encounter_id +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ResultReportingValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=procedureLink&flag=true", false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText )
		window.returnValue = "success";
	}
	window.close();
	
}
function callDisable(){
	var procFrmObj = parent.proc_detail.document.result_entry_proclink;
	var count = procFrmObj.totalRecs.value;
	var atLeastOne=false;
	var cnt = procFrmObj.cnt.value;
		
	for(var i=0;i<=cnt;i++){
		var grp_cnt= eval("procFrmObj.grp_cnt"+i).value ;
		for(var j=0;j<grp_cnt;j++){
			if(eval("procFrmObj.proc_chk"+i+j).checked == true && eval("procF8/26/2009rmObj.proc_chk"+i+j).disabled == true){
				atLeastOne= true;
			
			}else{
				atLeastOne= false;
				break;
			}
				
		}
	}
	if(atLeastOne){
		parent.proc_btn.document.result_entry_proc_btn.record.style.visibility = "hidden";

	}
}


function showDesc(val){
	//alert(val);

}
async function callProcLink1(){
	var detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl;
	if(!detailFrmObj)
		return false;

	var orderId = detailFrmObj.order_id.value;
	var order_catalog_code="";
	
	var dialogHeight		= '50vh';
	var dialogWidth			= '65vw';
	var dialogTop			= '231';
	var dialogLeft			= '213' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var finalString	= "orderId="+ orderId;
	finalString += "&chk_val="+detailFrmObj.chk_val.value;
	finalString += "&proc_scheme_code="+detailFrmObj.proc_scheme_code.value;
	finalString += "&order_type_code="+detailFrmObj.order_type_code.value;
	finalString += "&patient_id="+detailFrmObj.patient_id.value;
	finalString += "&patient_class="+detailFrmObj.patient_class.value;
	finalString += "&encounter_id="+detailFrmObj.encounter_id.value;
	finalString += "&win_close=Y";

	var retVals ;
	retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryProcedureLinkFrameset.jsp?"+finalString,arguments,features);
	
	if(retVals != "" && retVals != "undefined" && retVals != undefined){

		var retVals1 = retVals.split("&");
		detailFrmObj.proc_link_resulting_option_result.value=retVals1[0];
		detailFrmObj.chk_val.value=retVals1[1];
		detailFrmObj.proc_scheme_code.value=retVals1[2];
		btnFormObj= parent.ResultEntryBtn.document;
		if(retVals[0]!="M"){//proc_link_resulting_option_result
			//btnFormObj.all.proc_link.style.backgroundColor = 'blue'
			btnFormObj.all.proc_link_buttons.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='"+getLabel("eOR.ProcedureLink.label","OR")+"' class='button' onClick='callProcLink()'>"
		}else{
			btnFormObj.all.proc_link.style.backgroundColor = 'red'
			//btnFormObj.all.proc_link.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='Procedure Link' style='background-color:red' onClick='callProcLink()'>"
		}// change the color
	}
	

}
async function callProcLink(){
	var detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl;
	if(!detailFrmObj)
		return false;

	var orderId = detailFrmObj.order_id.value;
	var order_catalog_code="";
	
	var dialogHeight		= '40vh';
	var dialogWidth			= '60vw';
	var dialogTop			= '231';
	var dialogLeft			= '213' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var finalString	= "orderId="+ orderId;
	finalString += "&chk_val="+detailFrmObj.chk_val.value;
	finalString += "&proc_scheme_code="+detailFrmObj.proc_scheme_code.value;
	finalString += "&order_type_code="+detailFrmObj.order_type_code.value;
	finalString += "&patient_id="+detailFrmObj.patient_id.value;
	finalString += "&patient_class="+detailFrmObj.patient_class.value;
	finalString += "&encounter_id="+detailFrmObj.encounter_id.value;

	var retVals ;
	retVals =await window.showModalDialog("../../eOR/jsp/ResultEntryProcedureLinkFrameset.jsp?"+finalString,arguments,features);
	
	if(retVals != "" && retVals != "undefined" && retVals != undefined){

		var retVals1 = retVals.split("&");
		detailFrmObj.proc_link_resulting_option_result.value=retVals1[0];
		detailFrmObj.chk_val.value=retVals1[1];
		detailFrmObj.proc_scheme_code.value=retVals1[2];
		btnFormObj= parent.ResultEntryBtn.document;
		if(retVals[0]!="M"){//proc_link_resulting_option_result
			//btnFormObj.all.proc_link.style.backgroundColor = 'blue'
			btnFormObj.all.proc_link_buttons.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='"+getLabel("eOR.ProcedureLink.label","OR")+"'  class='button' onClick='callProcLink()'>"
		}else{
			btnFormObj.all.proc_link.style.backgroundColor = 'red'
			//btnFormObj.all.proc_link.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='Procedure Link' style='background-color:red' onClick='callProcLink()'>"
		}// change the color
	}
	

}

function recordResultEntry(resultReportingURL, freqExplApplies)
{
	//alert(eval('parent.ResultEntryDtl.document.result_entry_dtl.result_'+0).value);
//alert("=="+resultReportingURL+"=="+freqExplApplies);

if(parent.ResultEntryBtn.document.result_entry_btn)
	{
		var header_values=parent.ResultEntryBtn.document.result_entry_btn.header_values.value;
	}else if(document.result_entry_btn)
	{
		var header_values = document.result_entry_btn.header_values.value;
	}
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	reportFrmObj = parent.ResultEntryReport.document.result_entry_report

	var reportAuthorizationFlag	= "0";	
	//Checking for the mandatory fields.
	if(!detailFrmObj){
		alert(getMessage("NO_RECORDS_TO_RECORD","OR"));
		return false;
	}
	totalRecs = detailFrmObj.total_recs.value;	

	//alert(trimCheck(reportFrmObj.practitioner_desc.value));
	if(!trimCheck(reportFrmObj.practitioner_desc.value))
		reportFrmObj.practitioner.value = "";
	//alert("reportFrmObj.practitioner.value"+reportFrmObj.practitioner.value)
	if(reportFrmObj.practitioner.value=="")
	{
		//alert("Please enter Reporting Practitioner");
		alert(getMessage("ENTER_RPT_PRACT","OR"));
		reportFrmObj.practitioner_desc.value = "";
		reportFrmObj.practitioner_desc.focus();
		return false;
	}
	if(detailFrmObj.proc_link_resulting_option_result.value=="M" && detailFrmObj.proc_link_applicable_result.value == "R")
	{
		if(parent.ResultEntryDtl.document.result_entry_dtl.reporting_date.value != "")
			callProcLink1();
		else{
			alert(getMessage("PROCEDURE_LINK_MAND","OR"));
			return false;
		}
	}
	for(i=0; i<totalRecs; i++)
	{
		mandatoryField = eval('detailFrmObj.mandatory_'+i);
		resultField = eval('detailFrmObj.result_'+i);
		if(mandatoryField.value=='Y' && resultField.value=='')
		{
			//alert('Fill all mandatory fields.');
			alert(getMessage("ALL_MAND_FIELDS","OR"));
			resultField.focus();
			return false;
		}
		
		if(eval('detailFrmObj.resulted_yn'+i).value == "Y" && eval('detailFrmObj.practitioner_id'+i).value =='')
		{
			alert(getMessage("ENTER_RPT_PRACT","OR"));
			eval('detailFrmObj.practitioner_desc'+i).focus();
			return false;
		}
	}
	
	// Checking for the serial number.
	srl_number = detailFrmObj.report_srl_no.value;

	
	if(srl_number.indexOf('C')>=0)
		detailFrmObj.report_srl_no.value = srl_number.substr(1,srl_number.length);

	// Setting the values of the variables in the report form to detail form hidden variables.
	var hidden_auth_reqd_yn = "N";
	if(reportFrmObj.hidden_auth_reqd_yn)
		hidden_auth_reqd_yn = reportFrmObj.hidden_auth_reqd_yn.value;
	//alert("hidden_auth_reqd_yn ==="+hidden_auth_reqd_yn);
	detailFrmObj.rpt_pract_id.value = reportFrmObj.practitioner.value;	
	if(hidden_auth_reqd_yn=='Y')
		detailFrmObj.rpt_authreq_yn.value = reportFrmObj.hidden_auth_reqd_yn.value;
	else
		detailFrmObj.rpt_authreq_yn.value = reportFrmObj.auth_reqd_yn.value;
	detailFrmObj.rpt_authreq_yn_db.value = reportFrmObj.auth_reqd_yn_db.value;
	detailFrmObj.rpt_result_type.value = reportFrmObj.rslt_type.value;
	detailFrmObj.rpt_result_status.value = reportFrmObj.rslt_status.value;
	detailFrmObj.rpt_Order_Status.value = reportFrmObj.order_status.value;
	detailFrmObj.encounter_id.value = reportFrmObj.encounter_id.value;
	detailFrmObj.patient_id.value	= reportFrmObj.patient_id.value;
	bean_id							= detailFrmObj.bean_id.value;
	
	//alert("parent_order_id==="+parent.ResultEntryTop.document.getElementById("parent_order_id").value);
	//alert("order_id==="+detailFrmObj.order_id.value);
	
	if(parent.ResultEntryTop.document.getElementById("parent_order_id").value !="")
	detailFrmObj.parent_order_id.value	= parent.ResultEntryTop.document.getElementById("parent_order_id").value;

	// posting the form values to set in the bean.
	//alert(detailFrmObj.value)
	var formReply = formApply(detailFrmObj,OH_CONTROLLER);
	//alert("403 formReply:=="+formReply);
	formReply = formReply.replace("\n","");
	eval(formReply);
	// throwing the page back to the ResultReporting page.
	//alert('1 -- ' + resultReportingURL);
	
	if(parent.ResultEntryReport.location.href.indexOf('blank.html') >= 1)
	{
	//alert('2 -removing freq from url- ' + resultReportingURL);
		freqExplApplies = '';	// This will take the screen to Result Reporting on click to record.
		while(resultReportingURL.indexOf("&showRecordButton=N") >= 1)
			resultReportingURL = resultReportingURL.replace("&showRecordButton=N","");
		while(resultReportingURL.indexOf("&freqExplApplies=Y") >= 1)
			resultReportingURL = resultReportingURL.replace("&freqExplApplies=Y","");
		while(resultReportingURL.indexOf("&requestFrom=FE") >= 1)
			resultReportingURL = resultReportingURL.replace("&requestFrom=FE","");
	}

	//alert('3 -- ' + resultReportingURL);
	var LastChildCompleted = false;
	if(freqExplApplies == 'Y')
	{
	//alert('4 -- ' + resultReportingURL);
		resetAllChildOrderRows();
		parent.ResultEntryFrequency.location.reload();
		parent.ResultEntryReport.location.href = '../../eCommon/html/blank.html';
		if(parent.ResultEntryHeader)
			parent.ResultEntryHeader.location.href = '../../eCommon/html/blank.html';
		parent.ResultEntryDtl.location.href = '../../eCommon/html/blank.html';
		parent.ResultEntryBtn.location.href = 'ResultEntryBtn.jsp?'+resultReportingURL+'&freqExplApplies=Y&showRecordButton=N';

		//alert("Order Status = " + detailFrmObj.rpt_result_status.value);
		//alert("Child Order = " + detailFrmObj.child_order_index.value);
		if (detailFrmObj.rpt_result_status.value=='3' && detailFrmObj.child_order_index.value=='L')
		{
			LastChildCompleted = true;
			//alert("It should be thrown back to result reporting");
		}
	}
	if(freqExplApplies!='Y' || LastChildCompleted)
	{
		//alert('5 -- ' + resultReportingURL);
		while(resultReportingURL.indexOf("&showRecordButton=N") >= 1)
			resultReportingURL = resultReportingURL.replace("&showRecordButton=N","");
		while(resultReportingURL.indexOf("&freqExplApplies=Y") >= 1)
			resultReportingURL = resultReportingURL.replace("&freqExplApplies=Y","");
		while(resultReportingURL.indexOf("&requestFrom=FE") >= 1)
			resultReportingURL = resultReportingURL.replace("&requestFrom=FE","");

		if(resultReportingURL.indexOf("requestFrom") >= 0)
		{
			//alert('6 -- ' + resultReportingURL);
			//alert("This is from authorization.");
			//alert("QueryString is := "+resultReportingURL);
			reportAuthorizationFlag	= "1";
			if (messageGlobal != "") {
				//if(messageGlobal in orMessageArray)
				/*if( getMessage(messageGlobal,"OR") != "" )
				{
				
					messageGlobal = getMessage(messageGlobal,"OR");
				}
				else if (messageGlobal.indexOf("<br>") != -1) {
				
					messageGlobal = messageGlobal.substring(0,messageGlobal.indexOf("<br>"))
				}*/
					
				alert(messageGlobal);
			}
			//parent.window.returnValue = messageGlobal;
			//parent.window.close();
			top.content.workAreaFrame.location.href="ReportAuthorization.jsp?&header_values="+header_values+"&CancelFlag=Y";
			resultPrinting(bean_id);
		}
		else
		{
			
	//alert('7 -- ' + resultReportingURL);
			var option_id  = parent.ResultEntryBtn.document.forms[0].option_id.value ;
			//alert("QueryString is := "+resultReportingURL);
			//alert("here1==="+top.content)
			if(top.content) {
				//alert("here")
			/*	if(messageGlobal in orMessageArray) //"OR_STATUS_CHANGED"
					alert(getMessage(messageGlobal,"OR"));
				else
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			 */
			  //alert("ResultReporting.jsp?"+resultReportingURL+"&CanelFlag=Y&option_id="+option_id)   ;
				var confirm_val ="";
				if( parent.ResultEntryReport.document.result_entry_report.result_status.value != "Completed" && parent.ResultEntryReport.document.result_entry_report.rslt_status.value != "3" && eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+0).value != ""){
					confirm_val  = window.confirm(getMessage("CONTINUE_RESULT_REPORT","OR"));
				
				if(confirm_val)
					parent.ResultEntryDtl.location.reload();
				else
					top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";

			 }else
				{
				 confirm_val = false;}
			
				//	alert("from =TaskList="+parent.ResultEntryBtn.document.forms[0].from.value);
				var valFrom = parent.ResultEntryBtn.document.forms[0].from.value;
				 if(!confirm_val) {		
					 if (valFrom == "TaskList")					
						 top.content.workAreaFrame.location.href="../../eCA/jsp/TaskList.jsp?"+resultReportingURL+"&backfrom=ResultEntry";
					 else
						 top.content.workAreaFrame.location.href="ResultReporting.jsp?"+resultReportingURL+"&CanelFlag=Y&option_id="+option_id;					 
				 }
		  	} else {
		  		if (messageGlobal != "") {
					//if(messageGlobal in orMessageArray)
					/*if( getMessage(messageGlobal,"OR") != "" )
						messageGlobal = getMessage(messageGlobal);
					else if (messageGlobal.indexOf("<br>") != -1) {
						messageGlobal = messageGlobal.substring(0,messageGlobal.indexOf("<br>"))
					}*/
					alert(messageGlobal);
				}
				//parent.window.returnValue = messageGlobal;
				if(detailFrmObj.order_line_num.value!=null && detailFrmObj.order_line_num.value!="" && detailFrmObj.order_line_num.value!="null")
				{
				var order_line=parseInt(detailFrmObj.order_line_num.value);
				//order_line=order_line-1;
				//alert(eval('detailFrmObj.result_status'+order_line).value);
				//alert("Returning value: "+eval('detailFrmObj.forOT'+order_line).value);
				//alert("order_line="+order_line);
				parent.window.returnValue=eval('detailFrmObj.forOT'+order_line).value;
				}
				parent.window.close();
		  	}
			//alert("here111")
			resultPrinting(bean_id);
		}
	}

	 //Line Added to Show the Operation Completed Successfully ....Msg for scheduled Orders
	if (reportAuthorizationFlag == "0") {
		if (top.content){
			if(document.result_entry_btn)
			{
			
				var from=document.result_entry_btn.from.value;
				if(from=="TaskList")
				{
					alert(messageGlobal);
					top.content.workAreaFrame.location.href="../../eCA/jsp/TaskList.jsp?"+resultReportingURL+"&backfrom=ResultEntry";
		
					return false;
				}
			}
			if(messageGlobal != "") //"OR_STATUS_CHANGED"
				alert(messageGlobal);
			else
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		}
	}

}

function updateindex(ORline,obj)
{
var detailFrmObj=parent.ResultEntryDtl.document.result_entry_dtl;
eval('detailFrmObj.forOT'+ORline).value=obj.value;
}

function resultPrinting(bean_id){
     var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
 	 xmlStr ="<root><SEARCH " ;
	 xmlStr +=" /></root>" ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open( "POST", "ResultFormPrinting.jsp?bean_id="+bean_id, true ) ;
	 xmlHttp.send( xmlDoc ) ;
}
 

function assignResult(res,msg,mod,invCode){
	//alert(res+","+msg+","+mod+","+invCode);
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}

/**************************************************************************/
var g_index;
function show_practitioner_window(target,chkval,index){

g_index=index;

/*var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

//alert(parent.ResultEntryReport.document.result_entry_report)

argumentArray[0]   = parent.ResultEntryReport.document.result_entry_report.prac_sql.value;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";
//argumentArray[5]   = target.value ;
argumentArray[5]   = "" ;
argumentArray[6]   = CODE_LINK ;
argumentArray[7]   = CODE_DESC ;


retVal = await CommonLookup( "Practitioner", argumentArray );

if(retVal != null && retVal != ""){
	target.value = retVal[1];
	target.focus();
	parent.ResultEntryReport.document.result_entry_report.practitioner.value=retVal[0];
}*/
	if(!trimCheck(target.value) && chkval == "")
		return false;
	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";
	

	practName_FName		= target.name;		// object name
	practName_FValue	= target.value;	
	if(index)
	practId_FName		= eval("document.result_entry_dtl.practitioner_id"+index).value;
	else
	practId_FName		= document.result_entry_report.practitioner.value;
	//alert(parent.ResultEntryReport.document.result_entry_report.localeName.value)

	var localeName		= parent.ResultEntryReport.document.result_entry_report.localeName.value;
	var sql				= parent.ResultEntryReport.document.result_entry_report.prac_sql.value;
	var sql2			= parent.ResultEntryReport.document.result_entry_report.prac_sql2.value;
	var splty			= "";
	var facility_id		= "";
	//facility_id		= facilityID;
	// here not needed job_title , gender, practitioner_type, specialty-code
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	for(var x=0;x<3;x++)
	{
	sql=sql.replace('?',"'"+localeName+"'");
	sql2=sql2.replace('?',"'"+localeName+"'");
	}
	//alert(sql);
	//alert(sql2);
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + splty+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText	= xmlHttp.responseText;
	responseText	= trimString(responseText);
	//alert(responseText);
	eval(responseText);

}
function PractLookupRetVal(retVal,target)
{
	
 	if(retVal != null && retVal != "")
	{
		arr=retVal.split("~");
		
		if(!g_index){
			document.result_entry_report.practitioner.value=arr[0];
			document.result_entry_report.practitioner_desc.value = arr[1];
			//var confirm = window.confirm(getMessage("OR_REPORT_PRACT_CHANGE_TO_OTHER","OR"));
			var confirm = false;
			if(confirm){
				for(i=0;i<parent.ResultEntryDtl.document.result_entry_dtl.total_recs.value ;i++){
					if(eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+i).value != "3"){
						eval("parent.ResultEntryDtl.document.result_entry_dtl.practitioner_id"+i).value = arr[0] ;
						eval("parent.ResultEntryDtl.document.result_entry_dtl.practitioner_desc"+i).value = arr[1] ;
					}
				}
			}
			document.result_entry_report.practitioner_desc.focus();
		}else{
			
			eval("document.result_entry_dtl.practitioner_id"+g_index).value=arr[0];
			eval("document.result_entry_dtl.practitioner_desc"+g_index).value = arr[1];
			//eval("document.result_entry_dtl.practitioner_desc"+g_index).focus();
			var count = 0;
			for(i=0;i<parent.ResultEntryDtl.document.result_entry_dtl.total_recs.value;i++){
				
				if (eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+i).value != "3" ||(eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+i).value == "3" && !eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+i).disabled ))
				{
					count++;
					if(count > 1)
						break;
				}
			}
			
			if(count <= 1)
				return false;

			//var confirm = window.confirm(getMessage("OR_REPORT_PRACT_CHANGE_TO_OTHER","OR"));
			var confirm = false;
			if(confirm){
				for(i=0;i<parent.ResultEntryDtl.document.result_entry_dtl.total_recs.value ;i++){
					if(eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+i).value != "3"){
						eval("parent.ResultEntryDtl.document.result_entry_dtl.practitioner_id"+i).value = arr[0] ;
						eval("parent.ResultEntryDtl.document.result_entry_dtl.practitioner_desc"+i).value = arr[1] ;
					}
				}
			}
		}
	}else{
		if(!g_index){
			document.result_entry_report.practitioner_desc.value="";
			document.result_entry_report.practitioner_desc.focus();
		}else{
			eval("document.result_entry_dtl.practitioner_desc"+g_index).focus();
		}
	}
 }
 /************************************************************************/
 /*								 OLD LOOK UP COMMENTED
function show_practitioner_window()	{
	var retVal = ""; //new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var search_code="";
	var search_desc="";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;

	var tit="Practitioner"
	var sql="SELECT practitioner_id,practitioner_name FROM am_practitioner";
	//var sql="select practitioner_id, practitioner_name from am_practitioner where eff_status='E' ";
	search_code="practitioner_id";
	search_desc= "practitioner_name";

	//retVal =
	window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

	alert(retVal)
	if (!(retVal == null)) {
		var vals=retVal.split("/")	;

		parent.ResultEntryReport.document.result_entry_report.practitioner.value=unescape(vals[1]);



	}
	parent.ResultEntryReport.document.result_entry_report.practitioner.focus();
}*/
/****************************************************************************/

function setResultStatus(code)
{
	if(code!='')
	{
		if(code=='C')
			parent.ResultEntryReport.document.result_entry_report.result_status.value=getLabel("Common.completed.label","Common");
		else if(code=='P')
			parent.ResultEntryReport.document.result_entry_report.result_status.value=getLabel("Common.InProcess.label","COMMON");
	}
}

function checkSrvStatusChange()
{
	//alert('Change in srv status');
	notApplicable = 0;
	normal = 0;
	abNormal = 0;
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	totalRecs = detailFrmObj.total_recs.value;
	
	for(i=0; i<totalRecs; i++)
	{
		selectElement = eval("detailFrmObj.srv_stat_"+i)


		if(selectElement.value=='')
			notApplicable++;
		else if(selectElement.value=='N')
			normal++;
		else //if(selectElement.value=='A')
			abNormal++;

	}

	if(notApplicable==totalRecs)
	{	
		if(reportFrmObj && reportFrmObj.srv_status)
			reportFrmObj.srv_status.value=getLabel("Common.notapplicable.label","Common");
		if(reportFrmObj && reportFrmObj.rslt_type)
			reportFrmObj.rslt_type.value='';
	}
	else if (abNormal > 0)
	{
		if(reportFrmObj && reportFrmObj.srv_status)
			reportFrmObj.srv_status.value=getLabel("Common.Abnormal.label","Common");
		if(reportFrmObj && reportFrmObj.rslt_type)
			reportFrmObj.rslt_type.value='A';
	}
	else if (normal > 0)
	{
		if(reportFrmObj && reportFrmObj.srv_status)
			reportFrmObj.srv_status.value=getLabel("Common.Normal.label","Common");
		if(reportFrmObj && reportFrmObj.rslt_type)
			reportFrmObj.rslt_type.value='N';
	}
	else
	{
		if(reportFrmObj && reportFrmObj.srv_status)
			reportFrmObj.srv_status.value=getLabel("Common.CriticallyAbnormal.label","COMMON");
		if(reportFrmObj && reportFrmObj.rslt_type)
			reportFrmObj.rslt_type.value='A';
	}
}

function changeStatusToPartial(index)
{
	index = parseInt(index);
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	totalRecs = detailFrmObj.total_recs.value;
	changedStatusElement = eval("detailFrmObj.result_status"+index);
	if(changedStatusElement.type=='hidden' && changedStatusElement.value=='1')
	{
		
		index = parseInt(index);
	
		//alert('For hidden variable starting from '+index);

		for(k=index; k >= 0; k--)
		{
			//alert("looping up "+k);
			statusElement = eval("detailFrmObj.result_status"+k);
			if(statusElement.type=='hidden')
				statusElement.value='2';
			else if (statusElement.type=='select-one')
			{
				statusElement.selectedIndex=1;
				//alert('Select element found so breaking the loop at '+k+' after changing it.');
				break;
			}
		}

		for(i=(index+1); i < totalRecs; i++)
		{
			//alert("-looping down "+i);
			statusElement = eval("detailFrmObj.result_status"+i);
			if(statusElement.type=='hidden')
				statusElement.value='2';
			else if (statusElement.type=='select-one')
			{
				//alert('Select element found so breaking the loop at '+i);
				break;
			}
		}
	}
	else if (changedStatusElement.type=='select-one' && changedStatusElement.value=='1')
		changedStatusElement.selectedIndex=1;

	checkStatusChange();
}

function checkStatusChange()
{
	complete = 0;
	inprogress = 0;
	partial = 0;
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	totalRecs = detailFrmObj.total_recs.value;
	var storedVal='';
	//var pract_desc= reportFrmObj.practitioner_desc.value;
	//var pract_id = reportFrmObj.practitioner.value;
	for(i=0; i<totalRecs; i++)
	{
		/*if ( eval("detailFrmObj.practitioner_desc"+i).value == "" )
		{
			eval("detailFrmObj.practitioner_desc"+i).value = pract_desc;
			eval("detailFrmObj.practitioner_id"+i).value = pract_id;
		}*/
		//if ( eval("detailFrmObj.practitioner_desc"+i).value == "" )
		//setPractitionerID(i);
		selectElement = eval("detailFrmObj.result_status"+i)
		if(selectElement.type=='select-one') {
			//alert('1');
			storedVal = selectElement.value;
			//alert("storedVal="+storedVal);
		} else if(selectElement.type=='hidden') {
			//alert('2');
			selectElement.value = storedVal;
			//alert("storedVal="+storedVal);
			//alert("selectElement.value="+selectElement.value);
		}

		if(selectElement.value=='1')
			inprogress++;
		else if(selectElement.value=='2')
			partial++;
		else if(selectElement.value=='3')
			complete++;
	}
	if(inprogress==totalRecs)
	{
		if(reportFrmObj && reportFrmObj.order_status && reportFrmObj.order_status.type=='select-one')
		{
			reportFrmObj.order_status.selectedIndex=0;
			reportFrmObj.order_status.disabled=true;
		}
		if(reportFrmObj){
		reportFrmObj.result_status.value=getLabel("Common.InProgress.label","Common");
		reportFrmObj.rslt_status.value='1';
		}
		//setOrderStatus('P');
	}
	else if(complete==totalRecs)
	{
		
		if(reportFrmObj && ((reportFrmObj.requestFrom.value!="RA") || reportFrmObj.rslt_status.value!="3"))
			if(reportFrmObj && reportFrmObj.order_status && reportFrmObj.order_status.type=='select-one')
				reportFrmObj.order_status.disabled=false;
		if(reportFrmObj){
		reportFrmObj.result_status.value=getLabel("Common.completed.label","Common");
		reportFrmObj.rslt_status.value='3';
		}
	}
	else// if(partial>=1)
	{
		if(reportFrmObj && reportFrmObj.order_status && reportFrmObj.order_status.type=='select-one')
		{
			reportFrmObj.order_status.selectedIndex=0;
			reportFrmObj.order_status.disabled=true;
		}
		//alert('here');
		if(reportFrmObj){
		reportFrmObj.result_status.value=getLabel("eOR.Partial.label","OR");
		reportFrmObj.rslt_status.value='2';
		}
		
	}
			
	//alert('finally completed='+complete+", inprogress="+inprogress+", partial="+partial+",totalRecs="+totalRecs);
}

function checkMandatory(){
 	detailFrmObj							= parent.ResultEntryDtl.document.result_entry_dtl
 	btnFormObj								= parent.ResultEntryBtn.document.result_entry_btn
 	var proc_link_applicable				= detailFrmObj.proc_link_applicable_result.value;
	var proc_link_resulting_option_result	= detailFrmObj.proc_link_resulting_option_result.value;
	var reporting_date						= detailFrmObj.reporting_date.value;
	
	if(btnFormObj){
//proc_link_applicable = "D";
//alert("=="+proc_link_applicable+"==");
//alert(proc_link_resulting_option_result)
//alert("=reporting_date==="+reporting_date+"=proc_link_applicable==="+proc_link_applicable+"==");
//alert("=proc_link_resulting_option_result==="+proc_link_resulting_option_result+"======");
		if(proc_link_applicable=="R"){
			btnFormObj.all.proc_link.style.visibility = 'visible'
			if(proc_link_resulting_option_result=="M"){
				//btnFormObj.all.proc_link_buttons.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='Procedure Link' class='IP_RedButton' onClick='callProcLink()'>";
				btnFormObj.all.proc_link_buttons.innerHTML = "<INPUT id='proc_link' name='ProcLink' id='ProcLink' TYPE='button' value='"+getLabel("eOR.ProcedureLink.label","OR")+"' class='button' onClick='callProcLink()'>";
				if(reporting_date == "")
					btnFormObj.all.proc_link.style.backgroundColor = 'red'
	 		} // change the color
 		} //then display the button 
		else
		{//alert("inside");
			btnFormObj.all.proc_link.style.visibility = 'hidden';
		}
	}
    				
}
async function viewHeaderComments(orderId)
{
	var dialogHeight ='35vh' ;
	var dialogWidth = '50vw' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var finalString	= "orderId="+ orderId;

	var retVals = await window.showModalDialog("../../eOR/jsp/ViewHeaderComment.jsp?"+finalString,arguments,features);

	if(retVals != ""){
		//parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value = retVals;
		//parent.f_query_add_mod.document.Order_Entry_Format_Item.finalString.value = retVals;
	}
}

async function viewResultTemplate(template_id, msr_id, msr_desc, index, readonly)
{
			index = parseInt(index);
		formObj = parent.ResultEntryDtl.document.result_entry_dtl;
		resultElement = eval('parent.ResultEntryDtl.document.result_entry_dtl.result_'+index);
		//alert("result element"+resultElement.value);
		var dialogHeight ='50vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '150';
		var dialogLeft = '0' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		//alert("in js: msr_desc"+msr_desc.value);
		var finalString	= "template_id="+ template_id+"&msr_id="+msr_id+"&msr_desc="+msr_desc+"&row_index="+index+"&readonly="+readonly+"&data_from="+resultElement.value;
		//alert("template_id"+template_id.value);
		//alert("msr_id."+msr_id.value);
		//alert("msr_desc"+msr_desc);
		//alert("readonly"+readonly.value);
		//alert("row_index"+index.value);
		//alert("data_from"+resultElement.value);


		var retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryTemplate.jsp?"+finalString,arguments,features);

		if((retVals != null)&&(retVals != "")){
			//alert('Ok setting ' +retVals);
			resultElement.value = retVals;
			changeStatusToPartial(index);
			setPractitionerID(index);
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
		}else
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "N";
		
}

var window_obj;
var ord_id1;
var note_type1;
var index1;
function callClinicalNotes(note_type,patient_id,patient_class,encounterId,orderId,index,accession_num,url){
	//alert("accession_num"+accession_num);
		index = parseInt(index);
	if( (!eval("parent.ResultEntryDtl.document.getElementById("note_hyper")"+index).disabled && accession_num == '' && eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).value != '3') || (parent.ResultEntryReport.document.result_entry_report.result_status.value == "Partial" && accession_num != '' && eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).value == '2') || accession_num == '' ){

			//var accession_num	 = parent.ResultEntryDtl.document.result_entry_dtl.accession_num.value;
			if(eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index).value != "" && eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).value != '2'){
				accession_num = eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index).value;
			}
			var note_signed		 = '';
			ord_id1				 = orderId ;
			note_type1			 = note_type;
			index1				 = index;
			//alert (document.body.offsetWidth);
			if(document.body.offsetWidth > 1024){
				var dialogTop	 = "30";
				var dialogHeight = "700";
				var dialogWidth	 = "1010";
			}else{
				var dialogTop	 = "7";
				var dialogHeight = "700";
				var dialogWidth	 = "1010";
			}
			var features	 = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";
			var arguments	 = "Window_for_"+patient_id;
			var action_url	 = url+"?title=Clinical Note&note_type="+note_type+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_id="+encounterId+"&encounter_id="+encounterId+ "&Field_Ref=parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index+"&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num+"&window_close=Y&note_signed="+ note_signed+"&appl_task_id=RESULT_REPORTING&function_id=SPCL_NOTE&window_close=Y&contr_mod_accession_num="+orderId;
			//var action_url	 = "../../eCA/jsp/RecClinicalNotesModal.jsp?title=Clinical Note&note_type="+note_type+"&patient_id="+patient_id+"&patient_class="+patient_class+"&episode_id="+encounterId+"&encounter_id="+encounterId+ "&Field_Ref=parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index+"&function_id=SPCL_NOTE&event_class=PHY$&accession_num="+accession_num+"&window_close=Y&note_signed="+ note_signed+"&appl_task_id=CLINICAL_NOTES&function_id=SPCL_NOTE&window_close=Y&contr_mod_accession_num="+orderId;
			//alert(parent.ResultEntryReport.document.result_entry_report.result_status.value+"==accession_num="+accession_num+"===");
			if(eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).value == '2' && (accession_num != '' || eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index).value != "" )){
				action_url +="&operation_mode=Update" ; 
			}
			//alert(action_url);
			//alert(window_obj);
			/*if(window_obj != null)
				//window_obj.close();
			else*/
				window_obj = window.open(action_url,arguments,features);
			
			//ret_inter=setInterval('updateAccession();', 2500);
			ret_inter	= setInterval('updateAccession();', 1000);
			//alert("ret_inter==="+ret_inter);
			
		}else{
			if(accession_num !="" || eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index).value != ""){
				if(accession_num == "")
					accession_num = eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index).value;
				showNotes(accession_num);// call Notes in view mode
			}
		}
	setPractitionerID(index);		
}
var ret_inter;
function updateAccession(){
	var orderId = ord_id1;
	if(orderId !="" && eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index1).value != ""){
		//alert("got the accession num..NT."+note_type1+"=AN="+ eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index1).value+"=OID="+orderId)
		
		var event_status="";	
		//eval("parent.ResultEntryDtl.document.getElementById("note_hyper")"+index1).disabled= true;

		if(window_obj.closed){
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			
			var bean_id = "Or_ResultEntry";
			var bean_name = "eOR.ResultEntryBean";
			//var accession_num = parent.ResultEntryDtl.document.result_entry_dtl.accession_num.value;
			var accession_num =eval("parent.ResultEntryDtl.document.result_entry_dtl.accession_num"+index1).value;
			xmlStr					= "<root><SEARCH " ;
			xmlStr					+= "accession_num=\"" +accession_num +"\" ";
			xmlStr 					+=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOR/jsp/ResultentryValidate.jsp?validate=NOTE_EVENT_STATUS&bean_id="+bean_id+"&bean_name="+bean_name,false);
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText );
			
			//alert(event_status);
			if( event_status == "RECORD_COMPLETE"){
				eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index1).options[2].selected = 'selected' ;
				eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index1).disabled= true;
				//parent.ResultEntryReport.document.result_entry_report.result_status.value="Completed";
				//parent.ResultEntryReport.document.result_entry_report.rslt_status.value='3';
			}else{
				eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index1).options[1].selected = 'selected' ;
				eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index1).disabled= true;
				//parent.ResultEntryReport.document.result_entry_report.result_status.value="Partial";
				//parent.ResultEntryReport.document.result_entry_report.rslt_status.value='2';
			}
			checkStatusChange();
			setPractitionerID(index1);
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index1).value = "Y";

			clearInterval(ret_inter);
			var resultReportingURL	 = parent.ResultEntryBtn.document.result_entry_btn.resultReportingURL.value
			var freqExplApplies		 = parent.ResultEntryBtn.document.result_entry_btn.freqExplApplies.value
			//if(parent.ResultEntryReport.document.result_entry_report.result_status.value == "Completed" && parent.ResultEntryReport.document.result_entry_report.rslt_status.value == "3")
			recordResultEntry(resultReportingURL,freqExplApplies); 
		}else
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index1).value = "N";
			
	}
	
}
// Calling the Notes View
async function showNotes(accession_num) {
 	var dialogHeight ='45vh' ;
	var dialogWidth = '55vw' ;
	var dialogTop	= '129';
	var dialogLeft	= '11' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments = "";
	var retVals = await window.showModalDialog("../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num="+escape(accession_num),arguments,features);
}
async function viewCultureTest(template_id, msr_id, msr_desc, index, readonly, order_id, report_srl_no, chart_result_type)
{
	/*alert('template_id='+template_id);
	alert('msr_id='+msr_id);
	alert('msr_desc='+msr_desc);
	alert('index='+index);
	alert('readonly='+readonly);
	alert('order_id='+order_id);
	alert('report_srl_no='+report_srl_no);
	alert('chart_result_type='+chart_result_type);*/
	

			index = parseInt(index);
		formObj = parent.ResultEntryDtl.document.result_entry_dtl;
		templateTitle = msr_desc;
		
		resultElement = eval('parent.ResultEntryDtl.document.result_entry_dtl.result_'+index);
		//alert(resultElement.value);
		var dialogHeight ='50vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '150';
		var dialogLeft = '0' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "template_id="+ template_id+"&msr_id="+msr_id+"&msr_desc="+msr_desc+"&index="+index+"&readonly="+readonly+"&data_from="+escape(encodeURIComponent(resultElement.value))+"&order_id="+order_id+"&report_srl_no="+report_srl_no+"&chart_result_type="+chart_result_type+"&title="+templateTitle;
		//alert(finalString);

		//var retVals = window.showModalDialog("../../eOR/jsp/ResultEntryCultureTest.jsp?"+finalString,arguments,features);ResultEntryCultureTestFrameset.jsp
		var retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryCultureTestFrameset.jsp?"+finalString,arguments,features);

		if((retVals != null)&&(retVals != "")){
			//alert('Ok setting ' +retVals);
			resultElement.value = retVals;
			//alert(resultElement.value);
			changeStatusToPartial(index);
			setPractitionerID(index);
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
		}else
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "N";
}

/*function viewTemplate(template_id, msr_id, msr_desc, index, readonly, order_id, report_srl_no, chart_result_type)
{
		formObj = parent.ResultEntryDtl.document.result_entry_dtl;
		templateTitle = msr_desc;
		resultElement = eval('parent.ResultEntryDtl.document.result_entry_dtl.result_'+index);
		//alert(resultElement.value);
		var dialogHeight ='26' ;
		var dialogWidth = '50' ;
		var dialogTop	= '150';
		var dialogLeft = '0' ;
		var title = ''

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 		var arguments = "";
		var finalString	= "template_id="+ template_id+"&msr_id="+msr_id+"&msr_desc="+msr_desc+"&index="+index+"&readonly="+readonly+"&data_from="+escape(resultElement.value)+"&order_id="+order_id+"&report_srl_no="+report_srl_no+"&chart_result_type="+chart_result_type+"&title="+escape(templateTitle);
		//alert(finalString);
		var retVals = window.showModalDialog("../../eOR/jsp/ResultEntryTemplateFrameSet.jsp?"+finalString,arguments,features);
 		if((retVals != null)&&(retVals != "")){
			//alert('Ok setting ' +retVals);
			resultElement.value = retVals;
			//alert(resultElement.value);
			changeStatusToPartial(index);
			showPreview(index);
		}
}
*/

/*function saveResultData()
{
	//alert('Saving result COB Data.');
	topformObj = parent.ResultEntryTmplTop.document.result_entry_template_top;
	eval(formApply(topformObj,"ResultEntryTemplateSave.jsp"))
	parent.window.returnValue = 'B';

	parent.window.close();
}*/

function addTemplateText()
{

	formObjTop = parent.ResultEntryTmplTop.document.result_entry_template_top
	formObjRight = parent.ResultEntryTmplRight.document.result_entry_template_right
	if(formObjRight.text2)
	{
		//formObjTop.templateText.value = formObjTop.templateText.value + formObjRight.text2.value;
		formObjTop.templateText.focus();
		formObjTop.document.execCommand("paste","", formObjRight.text2.value);
	}

}

/*function openPreview(){
		var qry_string	=	parent.ResultTemplateHdr.result_template_hdr.qry_string.value;
		var htmlString	=	parent.ResultTemplateHdr.result_template_hdr.document.getElementById("template").innerHTML;
		var bean_id		=	parent.ResultTemplateHdr.result_template_hdr.bean_id.value;
		var bean_name	=	parent.ResultTemplateHdr.result_template_hdr.bean_name.value;
		var index		=	parent.ResultTemplateHdr.result_template_hdr.index.value;
 		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		if( htmlString!=null && htmlString!= ""){
	   		while (htmlString.indexOf('\"') != -1 )
			{
				htmlString = htmlString.replace("\"",">>");
		    }
		}
   		xmlStr					= "<root><SEARCH " ;
		//xmlStr				+= "qry_string=\"" +checkSpl(qry_string) +"\" ";
		xmlStr					+= "index=\"" +checkSpl(index) +"\" ";
		xmlStr					+= "htmlString=\""+checkSpl(htmlString)+"\" ";
 		xmlStr 					+=" /></root>" ;
  		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST","../../eOR/jsp/ResultentryValidate.jsp?validate=CONVERT_XML&bean_id="+bean_id+"&bean_name="+bean_name,false);
		 xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText );
 
		 //document.getElementById("close_save").disabled	= true;
		parent.ResultTemplateHdr.document.result_template_hdr.submit();
	 //return xmlHttp.responseText  ;
		 
*/
		/*var htmlString	=	parent.ResultTemplateHdr.result_template_hdr.document.getElementById("template").innerHTML;
  	    var dialogHeight ='26' ;
		var dialogWidth = '50' ;
		var dialogTop	= '150';
		var dialogLeft = '0' ;
		var title = ''

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 		var arguments = "";
		var finalString	= "qry_string="+escape(qry_string);
		//alert(finalString);
		var retVals = window.showModalDialog("../../eOR/jsp/ResultEntryTemplateFrameSet.jsp?"+finalString,arguments,features);
		*/
/*
}
function showPreview(index){
		//formObj = parent.ResultEntryDtl.document.result_entry_dtl;
 		//resultElement = eval('parent.ResultEntryDtl.document.result_entry_dtl.result_'+index);
  		var dialogHeight ='26' ;
		var dialogWidth = '50' ;
		var dialogTop	= '150';
		var dialogLeft = '0' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "index="+index;
	 
		var retVals = window.showModalDialog("../../eOR/jsp/ResultEntryPreview.jsp?"+finalString,arguments,features);
}
*/

function checkValidations(obj, result_type, count){
	if(result_type=="C"){
		if(obj.checked==true){
			obj.value = "Y";
		} else {
			obj.value = "N";
		}
	}

}


function clickTemplateText(index)
{
		index = parseInt(index);
	formObjBlock = parent.ResultEntryTmplBlock.document.result_entry_template_block
	formObjRight = parent.ResultEntryTmplRight.document.result_entry_template_right

	hiddenTextElement = eval("formObjBlock.hiddentext_"+index)
	formObjRight.all.id_td.innerHTML = '<TEXTAREA NAME="text2" ROWS="8" COLS="53">'+hiddenTextElement.value+'</TEXTAREA>'
	//formObjRight.text2.value = hiddenTextElement.value;
}

function checkOnBodyLoad()
{
	//alert("checking");
	checkMandatory();
	checkStatusChange();
	checkSrvStatusChange();

	
	
	//detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	//if(detailFrmObj.mode.value=='0')
	//	parent.ResultEntryBtn.document.getElementById("id_buttons").innerHTML='';

}

function authoriseLinkClicked()
{
	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
		getMessage("AUTH_RESULT","OR")
	//confirmation = confirm('You are allowed to authorize this result.\n Authorize now ?')
	confirmation = confirm(getMessage("AUTH_RESULT","OR"));
	if(confirmation)
	{
		//Changing the image and the link text in the report form.
		parent.ResultEntryReport.document.getElementById("id_authorise").innerHTML = "<font size=1><img src='../images/Authorized.gif'> &nbsp;<B>"+getLabel("Common.Authorized.label","Common")+"</B></font>"
		totalRecs = detailFrmObj.total_recs.value;
		total_auth_imgs = detailFrmObj.total_auth_imgs.value

		//Setting the hidden variable to 'Y' which will be passed to the detail form on submission.
		reportFrmObj.auth_reqd_yn.value = 'Y';

		//Changing the image in each row of the detail form.
		for(i=0; i<total_auth_imgs; i++)
		{
			authImg = eval('parent.ResultEntryDtl.document.getElementById("id_auth_img_")'+i);
			authImg.src='../images/Authorized.gif';
		}
		//Setting all the hidden variables for each row to 'Y' in detail form.
		for(i=0; i<totalRecs; i++)
		{
			hiddenAuth = eval('detailFrmObj.auth_reqd_'+i);
			hiddenAuth.value = 'Y';
		}
	}
}

function showReportNo(order_id, report_no)
{
	detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl
	reportFrmObj = parent.ResultEntryReport.document.result_entry_report
	//alert(order_id+", "+report_no);

	if(report_no.indexOf('C')==0)
	{
		//reportFrmObj.result_status.value='In Progress';
		parent.ResultEntryReport.location.href = 'ResultEntryReport.jsp?orderId='+order_id+'&report_srl_no='+report_no.substr(1,report_no.length);
		parent.ResultEntryDtl.location.href = 'ResultEntryDetail.jsp?orderId='+order_id+'&report_srl_no='+report_no.substr(1,report_no.length);
		parent.ResultEntryBtn.document.getElementById("id_buttons").innerHTML='<INPUT TYPE="button" value="<fmt:message key="Common.record.label" bundle="${common_labels}"/>" class="button" onClick=\'recordResultEntry("<%=resultReportingURL%>")\'><INPUT TYPE="button" value="<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>" class="button" onClick=\'returnToResultReporting("<%=resultReportingURL%>")\'>';
	}
	else
	{
		//alert(report_no.indexOf('C'));
		//reportFrmObj.result_status.value='Completed';
		parent.ResultEntryReport.location.href = 'ResultEntryReport.jsp?orderId='+order_id+'&report_srl_no='+report_no;
		parent.ResultEntryDtl.location.href = 'ResultEntryDetail.jsp?orderId='+order_id+'&report_srl_no='+report_no;
		//parent.ResultEntryBtn.document.result_entry_btn.record.type='hidden';
		parent.ResultEntryBtn.document.getElementById("id_buttons").innerHTML='';
	}

}

function onListChange(index)
{
		index = parseInt(index);
	formObj = parent.ResultEntryDtl.document.result_entry_dtl
	listElement = eval("formObj.result_"+index);
	selectElement = eval("formObj.srv_stat_"+index);
	if (listElement.value!=""){
		selectElement.disabled=false;
		//setPractitionerID(index);
		eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
	}else{
		selectElement.disabled=true;
		eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "N";
	}
	changeStatusToPartial(index);
}

async function viewOrderFormatLineCmts(index, readonly){
		index = parseInt(index);
		var dialogHeight ='35vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//alert(readonly);
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		commentElement = eval('parent.ResultEntryDtl.document.result_entry_dtl.result_comments_'+index)
		line_narration = commentElement.value;
		//alert('Line naration is for '+index+' - '+line_narration);
		var arguments = "";
		var finalString	= "line_narration="+ encodeURIComponent(line_narration) + "&readonly=" + readonly;

		var retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryLineComment.jsp?"+finalString,arguments,features);
//alert("Returned -- "+retVals)
		if((retVals != null)&&(retVals != "")){
			commentElement.value=retVals
			//parent.f_query_add_mod.document.Order_Entry_Format_Item.listValues.value = retVals;
			//parent.f_query_add_mod.document.Order_Entry_Format_Item.finalString.value = retVals;
		}
}
async function viewReasonforRequest(orderId){
		var dialogHeight ='40vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		//alert(readonly);
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		
		var arguments = "";
		var finalString	= "&readonly=readOnly&orderId="+orderId;

		var retVals = await window.showModalDialog("../../eOR/jsp/TDMReasonforrequest.jsp?"+finalString,arguments,features);
		
}

function checkDate(obj, index)
{
		index = parseInt(index);
	if(obj.readOnly)	return;
	if(obj.value=="" )
		return

	if(obj.value.length > 0){
		changeStatusToPartial(index);
		//setPractitionerID(index);
		eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
	}else
		eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "N";

	if(!checkDt(obj.value))
	{
		//alert('Invalid Date Format')
		alert(getMessage("INVALID_DATE_FMT","OR"));
		obj.focus();
		return false;
	}
/*
	if(obj.value.length > 0)
	{
		changeStatusToPartial(index);
		return;
	}
*/
}

function checkTime(obj, index)
{
	index = parseInt(index);
	if(obj.readOnly)	return;
	if(obj.value=="")
		return;
	if(obj.value.length > 0)
		changeStatusToPartial(index)
	if(!chkTime(obj.value))
	{
		//alert('Invalid Time Format')
		alert(getMessage("INVALID_TIME_FMT","OR"));
		obj.focus();
		return false;
	}
	//setPractitionerID(index);
	eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
}

function checkreDateTime(obj,index)
{
		index = parseInt(index);
	if(obj.readOnly)	return;
	if(obj.value=="")
		return;
	if(obj.value.length > 0)
		changeStatusToPartial(index)
	if(!doDateTimeChk(obj)){
	//if(!checkDt(obj.value)){
		alert(getMessage("INVALID_DATE_TIME_FMT","OR"));
		obj.focus();
		return false;
	}
	//setPractitionerID(index);
	eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
}
		/*
		objvalue = obj.value;
		datePart = objvalue.substr(0,10)
		timePart = objvalue.substr(11,15)
		alert("Date is "+datePart+" Time is "+timePart)
		if(!chkTime(timePart))
		{
			alert(getMessage("INVALID_DATE_FMT","OR"));
			obj.focus();
			return false;
		}
		if(!checkDt(datePart))
		{
			alert(getMessage("INVALID_DATE_FMT","OR"));
			obj.focus();
			return false;
		}*/

function onCheckBoxResultChange(index)
{
	changeStatusToPartial(index);
	//setPractitionerID(index);
	eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
}

function checkNumericResult(index){
			index = parseInt(index);
	formObj = parent.ResultEntryDtl.document.result_entry_dtl	;
	resultElement = eval("formObj.result_"+index)



	if(isNaN(resultElement.value)){
			resultElement.value = "";
	}



	/*var flds=new Array(resultElement);
	var name=new Array("Result");
	if(!SpecialCharCheck(flds,name,parent.parent.parent.messageframe,"A","../../eCommon/jsp/MstCodeError.jsp")){
			return false
	}*/

	/*for (u=0;u<resultElement.value.length;u++){
		if( ! ( (( resultElement.value.charCodeAt(u)>=48 ) && ( resultElement.value.charCodeAt(u)<58 ) ) || (resultElement.value.charCodeAt(u) == 46)) ) {
			alert("Invalid Number");
			return false;
        }
    }*/

	if(resultElement.readOnly)	return;
	if (resultElement.value=="")	return; //resultElement.value="0";
	result	= parseFloat(trimString(resultElement.value));


	//resultElement.value = result
	IntResult = parseInt(trimString(resultElement.value));


	tempResult = resultElement.value;

	resultFloatStr = "";
	resultIntStr = tempResult;
	if(tempResult.indexOf(".")>=0)
	{
		resultFloatStr = tempResult.substr(tempResult.indexOf(".")+1, tempResult.length-1)
		resultIntStr = tempResult.substr(0, tempResult.indexOf("."))

	}
	if(resultIntStr.length==0)
		resultIntStr="0";

/*Checking for the decimals constraint.*/
	num_digits_dec = parseInt(trimString(eval("formObj.num_digits_dec_"+index).value));

	if(parseInt(resultFloatStr)==0)
	{
		resultFloatStr = "";
		result = IntResult;
		resultElement.value = IntResult;
	}

	if(resultFloatStr.length > num_digits_dec)
	{
		message = getMessage('VARIABLE_DEC_DIGIT','OR');
		alert(message.replace("@",num_digits_dec));
		resultElement.focus();
		return;
	}

/*Checking for the number of digits constraint.*/
	resultIntLength = resultIntStr.length;
	num_digits_min = parseInt(trimString(eval("formObj.num_digits_min_"+index).value));
	num_digits_max = parseInt(trimString(eval("formObj.num_digits_max_"+index).value));


	if(resultIntLength < num_digits_min)
	{
		message = getMessage('RSLT_NOT_LESS_DIGIT','OR');
		alert(message.replace("@",num_digits_min));
		resultElement.focus();
		return;
	}
	else if(resultIntLength > num_digits_max)
	{
		message = getMessage('RSLT_NOT_MORE_DIGIT','OR');
		alert(message.replace("@",num_digits_max));
		resultElement.focus();
		return;
	}

/*Checking for the range constraint and setting the status according to the filled result.*/

	/*num_digits_min_points = parseInt(trimString(eval("formObj.num_crit_low_points_"+index).value));//before 28.12.2004
	num_digits_max_points = parseInt(trimString(eval("formObj.num_crit_high_points_"+index).value));//before 28.12.2004*/

	num_digits_min_points = trimString(eval("formObj.num_crit_low_points_"+index).value);//modified by Kavitha.K 28.12.2004
	num_digits_max_points = trimString(eval("formObj.num_crit_high_points_"+index).value);//modified by Kavitha.K 28.12.2004

	

	if(num_digits_min_points=='')	num_digits_min_points='0';
	if(num_digits_max_points=='')	num_digits_max_points='0';

	if(trimString(eval("formObj.num_crit_low_"+index).value)!="")
	{
		/*num_crit_low = parseInt(trimString(eval("formObj.num_crit_low_"+index).value));
		num_crit_high = parseInt(trimString(eval("formObj.num_crit_high_"+index).value));//original---before 28.12.2004*/
		
		num_crit_low = trimString(eval("formObj.num_crit_low_"+index).value);//modified by Kavitha.K on 28.12.2004
		num_crit_high = trimString(eval("formObj.num_crit_high_"+index).value);//modified by Kavitha.K on 28.12.2004

		

		selectElement = eval("formObj.srv_stat_"+index)



		if(result < num_crit_low)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 3
			checkSrvStatusChange();
			//alert('crit low');
		}
		else if ((num_crit_low <= result) && (result < num_digits_min_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 2
			checkSrvStatusChange();
			//alert('Normal Low');
		}
		else if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 1
				checkSrvStatusChange();
			//alert('Normal');
		}
		else if ((num_digits_max_points < result) && (result <= num_crit_high))
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 4
			checkSrvStatusChange();
			//alert('Normal high');
		}
		else if (num_crit_high < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 5
			checkSrvStatusChange();
			//alert('crit high');
		}
	}else
	{
		selectElement = eval("formObj.srv_stat_"+index)//added by Kavitha.K 28.12.2004
		
		if ((num_digits_min_points <= result) && (result <= num_digits_max_points))
		{
			
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 1
			checkSrvStatusChange();
			//alert('Normal');
		}

		//added by Kavitha.K 28.12.2004
		else if (result < num_digits_min_points)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 2
			checkSrvStatusChange();
			//alert('Normal Low');
		}else if (num_digits_max_points < result)
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
				selectElement.selectedIndex = 4
			checkSrvStatusChange();
			//alert('Normal high');
		}
		//end of added by Kavitha.K 28.12.2004

		else
		{
			if(!(num_digits_min_points=='0' && num_digits_max_points=='0'))
			selectElement.selectedIndex = 5
			checkSrvStatusChange();
			//alert('crit high');
		}

	}
	if(resultElement.value.length > 0)
		changeStatusToPartial(index);

	//setPractitionerID(index);
	eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
}

function checkLineComment(obj)
{
	if(obj.value.length >= 255)
	{
		alert(getMessage("COMMENT_CANT_EXCEED_255","OR"));
		return false;
	}
	window.returnValue = obj.value;
	window.close();
}

function CheckMaxLength(obj,max) {
	if(obj.value.length >= max)
	{
		//alert("APP-SM0045 - Text cannot exceed " + max  + " characters");
		
		var msg=getMessage("TEXT_MAX","OR");
		msg=msg.replace('1',max);
		alert(msg);
		return false;
	} else return true;
}

function showChildOrder(queryString, index, showRecordBtn, reportingDate, endDate)
{
		index = parseInt(index);
	var totalrecs = parent.ResultEntryFrequency.document.result_entry_frequency.totalrecs.value;
	resetAllChildOrderRows();
	eval('document.getElementById("row_")'+index).className = "CLICKED";
	queryString = queryString + '&requestFrom=FE';
	parent.ResultEntryReport.location.href = 'ResultEntryReport.jsp?' + queryString;
	if(parent.ResultEntryHeader)
		parent.ResultEntryHeader.location.href = 'ResultEntryHeader.jsp?' + queryString;
	if((index == totalrecs) && (endDate!='') && (endDate!='null'))
	{	// this is the last child for the order.
		parent.ResultEntryDtl.location.href = 'ResultEntryDetail.jsp?' + queryString + '&child_order_index=L&child_reporting_date=' + reportingDate;
	}
	else if((index == totalrecs) && ( (endDate=='') || (endDate=='null') ))
	{	// Frequency explosion is required after this child order.
		parent.ResultEntryDtl.location.href = 'ResultEntryDetail.jsp?' + queryString + '&child_order_index=F&child_reporting_date=' + reportingDate;
	}
	else
	{	// This is a normal child order.
		parent.ResultEntryDtl.location.href = 'ResultEntryDetail.jsp?' + queryString + '&child_order_index=' + index + '&child_reporting_date=' + reportingDate;
	}

	if(showRecordBtn == 'N')
	{
		if((queryString.indexOf('&showRecordButton=N') < 0))
			queryString = queryString + '&showRecordButton=N';

	} else
	{
		while(queryString.indexOf('&showRecordButton=N') >= 0)
			queryString.replace('&showRecordButton=N','');
	}

//   alert(document.forms[0].option_id.value);

	parent.ResultEntryBtn.location.href = 'ResultEntryBtn.jsp?'+queryString+'&freqExplApplies=Y'+'&option_id='+
	document.forms[0].option_id.value;
	top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;


}

function showMouseOverEffect(index)
{
		index = parseInt(index);
	if(eval('document.getElementById("row_")'+index).className != "CLICKED")
		eval('document.getElementById("row_")'+index).className = "NORMAL";
}

function showMouseOutEffect(index)
{
		index = parseInt(index);
	if(eval('document.getElementById("row_")'+index).className != "CLICKED")
		eval('document.getElementById("row_")'+index).className = "";
}

function resetAllChildOrderRows()
{
	var totalrecs = parent.ResultEntryFrequency.document.result_entry_frequency.totalrecs.value;
	for(i=1; i<=totalrecs; i++)
		eval('parent.ResultEntryFrequency.document.getElementById("row_")'+i).className = "";
}


// Called on click of the Allergies button
async function callAllergies(patient_id)
{
	var retVal 			= 	new String();
	var dialogHeight 	= "50vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&modal_yn=Y&patient_id="+patient_id,arguments,features);
}

// Called on click of the Vitals button in the Place Order
async function callActive(patient_id,encounter_id)
{
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "OR";
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	var retVal 			= new String();
	var dialogHeight 	= "50vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
}

// Called on click of the Drug Profile button in the Place Order
async function callDrugProfile(patient_id)
{
	var retVal 			= new String();
	var dialogHeight 	= "40vh" ;
	var dialogWidth  	= "100vw" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=Dispense",arguments,features);
}

// Call the Order Format Items Line Level
async function viewOrderFormatLineDtl(orderId,lineId){
	var dialogHeight 	= "45vh";
	var dialogWidth	 	= "65vw";
	var dialogTop		= "100";
	var dialogLeft 		= "12" ;
	var title 			= "";
	var features 	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";dialogTitle:"+title+"; scroll=yes; status=no";
	var arguments 	= "";
	var finalString	= "orderId="+ orderId+"&lineId="+lineId;
	var retVal 		= await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);
}

// Call the Order Format Header Level
async function viewOrderFormat(orderId){
	var dialogHeight 	= "45vh";
	var dialogWidth	 	= "65vw";
	var dialogTop		= "100";
	var dialogLeft 		= "12" ;
	var title 			= "";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";dialogTitle:"+title+"; scroll=yes; status=no";
	var arguments = "";
	var finalString	= "orderId="+ orderId;
	var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);
}

function saveResultData(){
	document.getElementById("Select").disabled = true;
	document.getElementById("Ok").disabled = true;
	document.getElementById("Close").disabled = true;
	//alert(parent.ResultEntryTmplTop.document.result_entry_template_top.templateText.value);
	parent.ResultEntryTmplTop.document.result_entry_template_top.submit();
	//parent.window.close();
}

function saveTemplate(){
 //	document.getElementById("close_save").disabled = true;
//	parent.ResultTemplateHdr.document.result_template_hdr.submit();
}


function enterCheck() {
	if (event.keyCode == 13) {
 		event.keyCode = "";
 	}
 }

function checkValid(obj,event,val1,val2) {
	if (event.keyCode == 13) {
 		event.keyCode = "";
 		return;
 	} else {
 		return allowValidNumber(obj,event,val1,val2);
 	}
}

async function viewOrderFormat(orderId){
		var dialogHeight ='45vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;
		var title	    = 'Order Format'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "orderId="+ orderId;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);
}

async function viewOrderFormatLineDtl(orderId){
		var dialogHeight  ='45vh' ;
		var dialogWidth   = '65vw' ;
		var dialogTop	  = '129';
		var dialogLeft    = '11' ;
		var title		  = 'Order Line Format'
		var features	  = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments	  = "";
		/*var total_recs	  = "";
		var Resulttext	  =  new Array();
		var j			  = 0;
		Resulttext[0]	  = "<html><body><form name=\"form1\" >";

		if(parent.ResultEntryDtl)
		{
				total_recs			= parent.ResultEntryDtl.document.result_entry_dtl.total_recs.value;
				Resulttext[1]		= "<input type=\"hidden\" name=\"total_recs\" value=\""+total_recs+"\">";
				for(i=0;i<total_recs;i++){
					result_comments = eval("parent.ResultEntryDtl.document.result_entry_dtl.result_comments_"+i+".value");
					line_srl_num	= eval("parent.ResultEntryDtl.document.result_entry_dtl.line_srl_num_"+i+".value");
					Resulttext[j++]	= "<input type=\"hidden\" name=\""+orderId+line_srl_num+"\" value=\""+result_comments+"\">";
				}
		}
		Resulttext[j++]				= "</form></body></html>";
		var finalString				= "orderId="+ orderId;
		var arguments				= HTMLText;
  		var retVal 					= window.showModalDialog( "../../eOR/jsp/ResultEntryViewOrderFormatFrame.jsp?"+finalString,arguments,features);
		*/
		var finalString				= "orderId="+orderId+"&called_from=RESULT_ENTRY";
		var retVal 					= await window.showModalDialog( "../../eOR/jsp/ResultEntryViewOrderFormatFrame.jsp?"+finalString,arguments,features);
		//var retVal 					= window.showModalDialog( "../../eOR/jsp/ViewOrderFormatFrame.jsp?"+finalString,arguments,features);
}

function organismReqdClick() {
	//alert('in'+document.result_culture_test_hdr.antibiotic_organism_reqd_yn.value);
	var obj = document.result_culture_test_hdr.antibiotic_organism_reqd_yn;
	//if (obj.checked == true) {
	if (obj.value == 'Y') {
		obj.value = 'Y';
		finalString	= document.result_culture_test_hdr.qry_string.value;
		finalString += "&antibiotic_organism_reqd_yn=" + document.result_culture_test_hdr.antibiotic_organism_reqd_yn.value;
		finalString += "&remarks=" + document.result_culture_test_hdr.remarks.value;
		parent.ResultCultureTest.location.href = "ResultEntryCultureTest.jsp?"+finalString;
	} else {
		obj.value = 'N';
		parent.ResultCultureTest.location.href = "../../eCommon/html/blank.html";
	}
}

function organismClick(obj) {
	var antibiotic_length = document.result_culture_test.antibiotic_length.value;
	var horizontal_heading = parent.ResultCultureTestHdr.document.result_culture_test_hdr.horizontal_heading.value;
	//alert(obj.value);
	var val = obj.name;
	val	= val.substring(val.length-1,val.length);
	if (obj.value == "") {
		for (i = 0; i < antibiotic_length; i++) {
			//alert(eval("document.result_culture_test.anti"+i+""+val).name)
			if (eval("document.result_culture_test.anti"+i+""+val)) {
				eval("document.result_culture_test.anti"+i+""+val).value = '';
				eval("document.result_culture_test.anti"+i+val).disabled = true;
			}
		}

		val = parseInt(val) + 1;
		var  chart_no_columns = document.result_culture_test.chart_no_columns.value;
		//alert(val);
		for(i = val; i < chart_no_columns; i++) {
            eval("document.result_culture_test.organism"+i).value = '';
            eval("document.result_culture_test.organism"+i).disabled = true;

            for (j = 0; j < antibiotic_length; j++) {
				if (eval("document.result_culture_test.anti"+j+""+i)) {
					eval("document.result_culture_test.anti"+j+""+i).value = '';
					eval("document.result_culture_test.anti"+j+""+i).disabled = true;
				}
			}
		}
	} else {
		//alert('in');
		var  chart_no_columns = document.result_culture_test.chart_no_columns.value;
		for (i = 0; i < chart_no_columns; i++) {
			if (eval("document.result_culture_test.organism"+i)) {
				if ((i != parseInt(val)) && (eval("document.result_culture_test.organism"+i).value == obj.value)) {
					//alert("Organism cannot duplicate");
					var message = getMessage("DUPLICATE_ORGANISM","OR");
					message     = message.replace("@",horizontal_heading);
					alert(message);
					obj.value = "";

					for (i = 0; i < antibiotic_length; i++) {
						//alert(eval("document.result_culture_test.anti"+i+""+val).name)
						if (eval("document.result_culture_test.anti"+i+""+val)) {
							eval("document.result_culture_test.anti"+i+""+val).value = '';
							eval("document.result_culture_test.anti"+i+val).disabled = true;
						}
					}

					val = parseInt(val) + 1;
					var  chart_no_columns = document.result_culture_test.chart_no_columns.value;
					//alert(val);
					for(i = val; i < chart_no_columns; i++) {
			            eval("document.result_culture_test.organism"+i).value = '';
			            eval("document.result_culture_test.organism"+i).disabled = true;

			            for (j = 0; j < antibiotic_length; j++) {
							if (eval("document.result_culture_test.anti"+j+""+i)) {
								eval("document.result_culture_test.anti"+j+""+i).value = '';
								eval("document.result_culture_test.anti"+j+""+i).disabled = true;
							}
						}
					}

					obj.focus();
					return;
				}
			}
		}


		for (i = 0; i < antibiotic_length; i++) {
			if (eval("document.result_culture_test.anti"+i+""+val)) {
				eval("document.result_culture_test.anti"+i+""+val).disabled = false;
			}
		}
	}
}

function antibioticClick(obj) {
	var antibiotic_length = document.result_culture_test.antibiotic_length.value;
	var val = obj.name;
	val = val.substring(val.length-1,val.length);
	//alert(val);
	var count = 0;
	if (obj.value == "") {
		for (i = 0; i < antibiotic_length; i++) {
			if (eval("document.result_culture_test.anti"+i+""+val))
			if (eval("document.result_culture_test.anti"+i+""+val).value != '')
				count++;
		}
	} else {
		//for (i = 0; i < antibiotic_length; i++) {
		//	if (eval("document.result_culture_test.anti"+i+""+val).value != '')
				count++;
		//}
	}

	if (count > 0) {
		if (document.result_culture_test.organism_string.value == '') {
			document.result_culture_test.organism_string.value = "'" + eval("document.result_culture_test.organism"+val).value + "'";
		} else {
			document.result_culture_test.organism_string.value += ",'" + eval("document.result_culture_test.organism"+val).value + "'";
		}
		val = parseInt(val) + 1;
		var  chart_no_columns = document.result_culture_test.chart_no_columns.value;
		//alert(val);
		if (val < chart_no_columns) {
            eval("document.result_culture_test.organism"+val).disabled = false;
		}
	} else {
		val = parseInt(val) + 1;
		var  chart_no_columns = document.result_culture_test.chart_no_columns.value;
		//alert(val);
		for(i = val; i < chart_no_columns; i++) {
            eval("document.result_culture_test.organism"+i).value = '';
            eval("document.result_culture_test.organism"+i).disabled = true;

            for (j = 0; j < antibiotic_length; j++) {
				if (eval("document.result_culture_test.anti"+j+""+i)) {
					eval("document.result_culture_test.anti"+j+""+i).value = '';
					eval("document.result_culture_test.anti"+j+""+i).disabled = true;
				}
			}
		}
	}
}

function addOrganismList(code,value,index) {
	//alert('1');
		index = parseInt(index);
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	//alert('2');
	//alert(eval("document.result_culture_test.organism"+index).name);
	eval("document.result_culture_test.organism"+index).add(element);
	//alert('3');
}

function clearList( docObj,index ) {
		index = parseInt(index);
	var len = eval(docObj + ".result_culture_test.organism"+index + ".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".result_culture_test.organism"+index + ".remove(\"atc_class_l2_code\")") ;
	}
	var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".result_culture_test.organism"+index + ".add(opt)") ;

}

function previewCultureTest() {
	var formObj	= parent.ResultCultureTest.result_culture_test;
	var formObj1 = parent.ResultCultureTestHdr.result_culture_test_hdr;
	//formObj.submit();
	doPreview(formObj,formObj1);
}

async function doPreview(frmObj,frmObj1){
	doPreviewSync(frmObj,frmObj1);
	var finalString = "chart_result_type="+frmObj1.all.chart_result_type.value;
	//alert(finalString);
	var dialogHeight ='50vh' ;
	var dialogWidth = '65vw' ;
	var dialogTop	= '150';
	var dialogLeft = '70' ;
	var title	    = 'Order Format'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var retVals = await window.showModalDialog("../../eOR/jsp/ResultEntryCultureTestPreviewFrameset.jsp?"+finalString,arguments,features);
	
}  

function storeCultureTest() {
	var formObj	= parent.ResultCultureTest.result_culture_test;
	var formObj1 = parent.ResultCultureTestHdr.result_culture_test_hdr;
	var previewText = doSync(formObj,formObj1);
	window.returnValue = previewText;
	window.close();
}
/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj,frmObj1){
 var xmlDoc="";
 var xmlHttp = new XMLHttpRequest();
 var  xmlString = buildXml(frmObj,frmObj1);
 xmlDoc.loadXML(xmlString);
 //alert(xmlString);
 xmlHttp.open("POST","../../eOR/jsp/ResultentryValidate.jsp?validate=SYNC_CULTURE_TEST&bean_id="+frmObj1.bean_id.value,false);
 xmlHttp.send(xmlDoc);
 //alert(xmlHttp.responseText );
 return xmlHttp.responseText  ;

}

function doPreviewSync(frmObj,frmObj1){
 var xmlDoc="";
 var xmlHttp = new XMLHttpRequest();
 var  xmlString = buildXml(frmObj,frmObj1);
 xmlDoc.loadXML(xmlString);
 //alert(xmlString);
 xmlHttp.open("POST","../../eOR/jsp/ResultentryValidate.jsp?validate=PREVIEW_CULTURE_TEST&bean_id="+frmObj1.bean_id.value,false);
 xmlHttp.send(xmlDoc);
 //alert(xmlHttp.responseText );
 return xmlHttp.responseText  ;

}
/***************************************************************************/
function buildXml(frmObj,frmObj1){


    //var arrObj = frmObj.elements;

    var frmObjs = new Array()
    /*if(frmObj.name == null)
        frmObjs = frmObj ;
    else*/ {
		if (frmObj) {
			frmObjs[0] = frmObj ;
			frmObjs[1] = frmObj1;
		} else {
			frmObjs[0] = frmObj1 ;
		}
		//alert('here');
    }
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				//if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
					//xmlStr+= arrObj[i].name+"=\""+ val + "\" ";
			}
		}
	}

    xmlStr +=" /></root>";

	//alert(xmlStr);
	return xmlStr;

}

function checkChartTemplateTime(obj) {
	if(!chkTime(obj.value))
	{
		//alert('Invalid Time Format')
		alert(getMessage("INVALID_TIME_FMT","OR"));
		obj.focus();
		return false;
	}
}

function checkClick(obj) {
	if (obj.checked == true) {
		obj.value = 'Y';
	} else {
		obj.value = '';
	}
}

/****************************************************************************/
function syncStatus(flag) {
//	alert(flag);
	return flag ;
}
async function callPatientHistory(patient_id){
		var dialogHeight ='55vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;


		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var ammend_called_from="existing_order";
 		var retVals = await window.showModalDialog("../../eCA/jsp/EncounterInDialog.jsp?patient_id="+patient_id+"&called_from=OR",arguments,features);
}

async function callMenuFunctions(colval1,colval,orderId,encounterId,sex,patient_id,procedure_code,patient_class,image_ref,ord_cat,order_status,order_line_num,performing_facility,performing_location_type,performing_location,int_or_ext,sent_out_flag,patient_dtls,discr_msr_id,proc_code_scheme){
 		

		
		var dialogHeight ='45vh' ;
		var dialogWidth = '55vw' ;
		var dialogTop	= '100';
		var dialogLeft = '30' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(colval)+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&image_ref="+image_ref+"&patient_dtls="+patient_dtls+"&patient_class="+patient_class;

		finalString += "&from=header&cont_order_ind=CO&cancel_type=CN&ord_cat="+ord_cat+"&order_status="+order_status+"&val1="+ord_cat+"&ord_cat_id="+ord_cat;
        var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

        var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
	
 		
}
 
function setPractitionerID(index){
	index = parseInt(index);
	var detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl	;
	//if(eval("detailFrmObj.result_status"+index).value != 3 ){
		
		reportFrmObj	 = parent.ResultEntryReport.document.result_entry_report
		var pract_desc	 = reportFrmObj.practitioner_desc.value;
		var pract_id	 = reportFrmObj.practitioner.value;
		if ( eval("detailFrmObj.practitioner_desc"+index).value == "" )
		{
			eval("detailFrmObj.practitioner_desc"+index).value	 = pract_desc;
			eval("detailFrmObj.practitioner_id"+index).value	 = pract_id;
		}

	//}
}
function clearpractID(index){
		index = parseInt(index);
	var detailFrmObj = parent.ResultEntryDtl.document.result_entry_dtl	;
	if (!eval("detailFrmObj.practitioner_desc"+index).readOnly &&  eval("detailFrmObj.practitioner_desc"+index).value == "" ){
		eval("detailFrmObj.practitioner_id"+index).value	 = "";
	}

}

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,order_category,colval,colval1,sex,order_set_id)
{
	var dialogTop   = "300";
	var dialogLeft   = "40vh";
	var dialogHeight= "65vw" ;
	var dialogWidth = "60" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id+"&order_category="+order_category;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		//finalString += "&location_details=" + location_details;
		//finalString += "&priority=" + Priority;
		finalString += "&patient_class=" + patient_class;
		//finalString += "&order_type_code=" + order_type_code;
		//finalString += "&source_type=" + source_type;
		//finalString += "&source_code=" + source_code;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;


	var arguments	= "";
	var retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

/*function alignHeading()
{

	if(parent.ResultEntryHeader.document.getElementById("tableheader")!=null)
	{
				parent.ResultEntryHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				
				for (j=0; j < document.getElementById("tableresult").rows(0).cells.length-3; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows(0).cells(j).offsetWidth);
					
					if(parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
					{
						parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
					}
				}
				if(parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(5) != null && document.getElementById("tableresult").rows(0).cells(5) !=null && document.getElementById("tableresult").rows(0).cells(6)!=null)
				{
						parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(5).width=(eval(document.getElementById("tableresult").rows(0).cells(5).offsetWidth)+eval(document.getElementById("tableresult").rows(0).cells(6).offsetWidth));
				}
				if(parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(6) != null && document.getElementById("tableresult").rows(0).cells(7)!=null )
				{
						parent.ResultEntryHeader.document.getElementById("tableheader").rows(0).cells(6).width=eval(document.getElementById("tableresult").rows(0).cells(7).offsetWidth);
				}
		}
		
}*/

/*function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;
	
	if(parent.ResultEntryHeader)
	{
		if(parent.ResultEntryHeader.location.href.indexOf(".jsp") != -1)
		{
			parent.ResultEntryHeader.document.body.scrollLeft=temp;
		}
	}
}*/

async function callCharting(chart_id,patient_id,patient_class,encounterId,orderId,index,accession_num,order_line_num,dateTime,url)
{
	var dialogHeight ='55vh' ;
	var dialogWidth = '65vw' ;
	var dialogTop	= '100';
	var status			= "no";
	var arguments		= "" ;
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	//var dateTime		= '';//'20/12/2006 09:30';
	var facility_id		= parent.ResultEntryDtl.document.result_entry_dtl.facility_id.value;
	//var order_line_num	= eval(index)+1;
	//alert("dateTime"+dateTime);
	//alert("order_line_num"+order_line_num);
	
	
	//var chart_id  		=note_type ;//eval("parent.ResultEntryDtl.document.result_entry_dtl.msr_id_"+index).value;
	var action_url		=	'../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&module_id=OR&p_start_date_time='+dateTime+'&Chart_Id='+chart_id+'&episode_id='+trimString(encounterId)+'&encounter_id='+trimString(encounterId)+'&facility_id='+facility_id+'&contr_mod_accession_num='+orderId+'!'+order_line_num;
	
	var retVal			= await window.showModalDialog(action_url,arguments,features);


	var chart_status	= "";
	var bean_id 		= "Or_ResultEntry";
	var bean_name		= "eOR.ResultEntryBean";
		
	var xmlDoc		 = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr		 = "<root><SEARCH " ;
		xmlStr		+= "accession_num=\"" +accession_num +"\" ";
		xmlStr		+= "orderId=\"" +orderId +"\" ";
		xmlStr		+= "order_line_num=\"" +order_line_num +"\" ";
		xmlStr		+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/ResultentryValidate.jsp?validate=CHART_RECORDING&bean_id="+bean_id+"&bean_name="+bean_name,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText );
	
	if( chart_status == "CHART_RECORDED"){

		//if(parent.ResultEntryReport.document.result_entry_report.result_status.value != "Completed" && parent.ResultEntryReport.document.result_entry_report.rslt_status.value != "3" || !eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).disabled){
			//eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).options[2].selected = 'selected' ;
			//eval("parent.ResultEntryDtl.document.result_entry_dtl.result_status"+index).disabled= true;
		
			//var resultReportingURL	 = //parent.ResultEntryBtn.document.result_entry_btn.resultReportingURL.value
			//var freqExplApplies		 = parent.ResultEntryBtn.document.result_entry_btn.freqExplApplies.value
			
			checkStatusChange();
			setPractitionerID(index);
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "Y";
		
			//recordResultEntry(resultReportingURL,freqExplApplies); 
		}else
			eval('parent.ResultEntryDtl.document.result_entry_dtl.resulted_yn'+index).value = "N";

	}	

//}

