/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function populateValues()
{
	var formObj=parent.ViewResultsSearch.document.view_results_search;
	var fromDate = formObj.period_from
	var toDate = formObj.period_to
	formObj.selectmode.value= formObj.result_type.value;
		
	if(!trimCheck(fromDate.value))
	{
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK"));
		parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value))
	{
		alert(getMessage("TO_DT_NOT_BLANK"));
		parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(doDateCheckOR(fromDate,toDate) == 1)
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT"));
		parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	if(document.forms[0].encounter_chk.checked == true)
		document.forms[0].encounter_chk.value='Y'
	else
		document.forms[0].encounter_chk.value='N'
	qry_string = "normalcy_ind="+parent.ViewResultsSearch.document.view_results_search.normalcy_ind.value+"&result_type="+parent.ViewResultsSearch.document.view_results_search.result_type.value+"&patientId="+parent.ViewResultsSearch.document.view_results_search.patient_id.value+"&facilityid="+parent.ViewResultsSearch.document.view_results_search.facilityid.value
	qry_string += "&encounter_id="+parent.ViewResultsSearch.document.view_results_search.encounter_id.value
	qry_string += "&encounter_chk="+parent.ViewResultsSearch.document.view_results_search.encounter_chk.value
	qry_string += "&groupby="+parent.ViewResultsSearch.document.view_results_search.group_by.value
	qry_string += "&period_from="+parent.ViewResultsSearch.document.view_results_search.period_from.value
	qry_string += "&period_to="+parent.ViewResultsSearch.document.view_results_search.period_to.value
	qry_string += "&selectmode="+parent.ViewResultsSearch.document.view_results_search.selectmode.value
	
	parent.ViewResultsSearch.document.view_results_search.search_btn.disabled =true;
	parent.ViewResultsHeader.location.href = "../jsp/ViewResultsHeader.jsp?"+qry_string
	parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
} 

function clearValues()
{
	document.view_results_search.search_btn.disabled =false;
	parent.ViewResultsSearch.document.forms[0].reset();
	parent.ViewResultsHeader.location.href = "../../eCommon/html/blank.html"
	parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
}

function setCheck()
{
	if(document.forms[0].encounter_chk.checked == true)
	document.forms[0].encounter_chk.value='Y'
	else
	document.forms[0].encounter_chk.value='N'
}

function checkDateRange(fromDate,toDate)
{
	if(doDateCheckOR(fromDate,toDate) == 1)
	{
		alert(getMessage("TO_DT_GR_EQ_FM_DT"));
		parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
		parent.ViewResultsSearch.document.view_results_search.period_to.value = fromDate.value;
		toDate.focus();
		return false ;
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function checkWithSysDate(obj)
{
	var currDate = parent.ViewResultsSearch.document.view_results_search.sys_date;
	if(doDateCheckOR(obj,currDate) == 1)
	{
		alert("APP-00043 Date cannot be greater than System Date");
		obj.value = currDate.value;
		obj.focus();
		return false ;
	}
}

async function viewComments(i)
{
	var result = eval("document.view_results_dtl.result_str"+i+".value");
	var retVal;
	var dialogHeight	= '9' ;
	var dialogWidth 	= '30' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;
	arguments 			= result ;
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../eOR/jsp/OrderEntryComments.jsp?hdg_name="+hdg_name,arguments,features);
}

async function viewClobData(accession_num)
{
		var dialogHeight ='30' ;
		var dialogWidth = '38' ;
		var dialogTop	= '189';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "accession_num="+ escape(accession_num);
		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewResultClobData.jsp?"+finalString,arguments,features);
}

async function viewClobDataHtm(accession_num)
{
		var dialogHeight ='30' ;
		var dialogWidth = '38' ;
		var dialogTop	= '189';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "accession_num="+ escape(accession_num);
 		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewResultClobDataHtm.jsp?"+finalString,arguments,features);
}

async function viewFlowSheet(index)
{
	var dialogHeight ='45' ;
	var dialogWidth = '60' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;

	var title 	= ''
	var from_function = "SearchResult"
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments 	= "";
	var patient_id	= parent.ViewResultsDetail.document.view_results_dtl.patientId.value
	var event_code	= eval("parent.ViewResultsDetail.document.view_results_dtl.event_code"+index).value
	var event_group	= eval("parent.ViewResultsDetail.document.view_results_dtl.event_group"+index).value
	var event_class	= eval("parent.ViewResultsDetail.document.view_results_dtl.event_class"+index).value
	var hist_rec_type	= eval("parent.ViewResultsDetail.document.view_results_dtl.hist_rec_type"+index).value

	qryString = "p_patient_id="+patient_id+"&p_event_code="+event_code+"&p_event_group="+event_group+"&p_event_class="+event_class+"&p_hist_rec_type="+hist_rec_type+"&p_called_from=OR";

	var abnormalFlag = confirm("Do you want see  Abnormal Result Only ?");
	if (abnormalFlag) {
		qryString += "&abnormal=Y";
	}

	var retVals = await window.showModalDialog("../../eCA/jsp/FlowSheet.jsp?"+qryString,arguments,features);
}
