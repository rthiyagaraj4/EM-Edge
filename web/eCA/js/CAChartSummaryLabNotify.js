/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        	Rev.Date	Rev.Name 	Description
---------------------------------------------------------------------------------------------------------------
20/04/2016	IN059255		Karthi L							 		ML-MMOH-CRF-0329.1
28/06/2018	IN065341		Prakash C	29/06/2018	Ramesh G	MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------------
*/

var l=0;
var m= 0;
var message="";
var result="";
// ML-MMOH-CRF-0329.1 - Start
//IN065341 starts
//function callAuditWindow(bean_id, bean_name, patient_id, orderId, accssion_num){
async function callAuditWindow(bean_id, bean_name, patient_id, orderId, accssion_num,called_from,RepDb,clob_data,facility_id){
	
	//var finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId+"&accssion_num="+accssion_num;
	var finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId+"&accssion_num="+accssion_num+"&called_from="+called_from+"&RepDb="+RepDb+"&clob_data="+clob_data+"&facility_id="+facility_id;
//IN065341 ends	
	var dialogHeight ='80vh' ;
	var dialogWidth = '80vw' ; 
	var dialogTop	= '';
	var dialogLeft = '' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderHistoryFrameset.jsp?"+finalString,arguments,features);
	document.location.reload();
}

async function callRvwResultsWindow(histRecType, contrSysId, contrSysEventCode, accessionNum, reviewType, createDateTime){
	var retVal;
	var dialogHeight	= '9' ;
	var dialogWidth 	= '30' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments		= "";
	var finalString     = "";
	retVal 				=await top.window.showModalDialog("../../eCA/jsp/CALabNotifyResultsReview.jsp?"+finalString,arguments,features);
	//document.location.href = document.location.href;
	
//	if(retVal == undefined || retVal == 'undefined') retVal = "X";
//	top.window.close();
	
}
//ML-MMOH-CRF-0329.1 reviewResults
function reviewResults(histRecType, contrSysId, contrSysEventCode, accessionNum, notifyAlert, eventCode, caNormalcyInd, practitionerId, loginUserId) {
	//alert('histRecType ' + histRecType + ', contrSysId ' + contrSysId +' , contrSysEventCode ' + contrSysEventCode + ', accessionNum ' + accessionNum + ', notifyAlert '+  notifyAlert + ', eventCode ' + eventCode + ', caNormalcyInd ' + caNormalcyInd + ', practitionerId ' +  practitionerId + ', loginUserId '+ loginUserId);
	var bean_id = "CAChartSummaryLabNotifyBean";
	var bean_name = "eCA.CAChartSummaryLabNotifyBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+ bean_id + "\" ";
	xmlStr += " p_bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_histRecType=\""+ histRecType + "\" ";
	xmlStr += " p_contrSysId=\""+ contrSysId + "\" ";
	xmlStr += " p_contrSysEventCode=\""+ contrSysEventCode + "\" ";
	xmlStr += " p_accessionNum=\""+ accessionNum + "\" ";
	xmlStr += " p_eventCode=\""+ eventCode + "\" ";
	xmlStr += " p_notifyAlert=\""+ notifyAlert + "\" ";
	xmlStr += " p_caNormalcyInd=\""+ caNormalcyInd + "\" ";
	xmlStr += " p_practitionerId=\""+ practitionerId + "\" ";
	xmlStr += " p_loginUserId=\""+ loginUserId + "\" ";
	xmlStr += " p_validate=\"SET_LAB_NOTIFY_FIELDS\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eCA/jsp/CAChartSummLabNotifyIntrmdate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	document.location.href = document.location.href;
}
function completeReview(){
	var reviewComments = document.getElementById("reviewResultsRemark").review_remarks.value;
	var bean_id = "CAChartSummaryLabNotifyBean";
	var bean_name = "eCA.CAChartSummaryLabNotifyBean";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+ bean_id + "\" ";
	xmlStr += " p_bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_reviewRemarks=\""+ reviewComments + "\" "; 
	xmlStr += " p_validate=\"COMPLETE_REVIEW\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eCA/jsp/CAChartSummLabNotifyIntrmdate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
function reviewCompletedStatus(reviewStatus){
	alert(reviewStatus);
	if(reviewStatus != null){
		window.close();
	}
}
// Code for forward Practitioner

async function callForwardReview() {
    var bean_id = "CAChartSummaryLabNotifyBean";
	var bean_name = "eCA.CAChartSummaryLabNotifyBean";
	
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " p_bean_id=\""+ bean_id + "\" ";
	xmlStr += " p_bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_validate=\"FORWARD_PRACT\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eCA/jsp/CAChartSummLabNotifyIntrmdate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
		
	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title 	= '';
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
    var arguments 	= "";
    var retVals = await window.showModalDialog("CAReviewResultsForwardPractFrameset.jsp",arguments,features);
    
	if (retVals != null && retVals != '' && retVals == 'true')
		var confirmFlag = confirm(getMessage("CONFIRM_COMPLETE_REVIEW","OR"));
	if (confirmFlag) {
		completeReview();
	}
}

function forwardToPract() {
	var formObj     = parent.ReviewResultsForwardPract.document.review_results_forward_pract_dtl;
	
	eval(formApply( formObj,OR_CONTROLLER)) ;
	var temp=message;
	if((temp.value)=="RECORD_ALREADY_EXISTS")
		alert(temp);
		else
	alert(temp);
	if(result){
	window.returnValue = "true";
	window.close();
	}
}
function assignResult(_result, _message, _flag, _code){
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;
}
function searchPractitioner() 
{
	var formObj     = parent.ReviewResultsForwardPractSearch.document.review_result_forward_pract_search;
	var finalString = "" + formObj.qry_string.value;
	var	search_by = formObj.searchBy.value;
	var search_criteria = formObj.search_criteria.value;

	finalString += "&practitioner_name=" + encodeURIComponent(formObj.practitioner_name.value)+"&search_by="+search_by+"&search_criteria="+search_criteria;
	parent.ReviewResultsForwardPract.document.location.href = "CAReviewResultsForwardPract.jsp?" + finalString;
}
function resetForwardPage()
{
	document.review_result_forward_pract_search.reset();
	parent.ReviewResultsForwardPractHeader.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsForwardPract.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsForwardPractBtn.location.href = "../../eCommon/html/blank.html" 
}
function focusOnResult()
{
	parent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled=false;
}	

function searchbutton()
{
	var formObj=parent.ReviewResultsForwardPractSearch.document.review_result_forward_pract_search;
	formObj.search.disabled=false;
}	

function chk(Obj){  
	
formObj=parent.ReviewResultsForwardPractBtn.document.review_result_forward_pract_btn;
		if(Obj.checked==true)
			l=l+1;
		else if(Obj.checked==false)
			m=m+1;
		if(l>m)
		 formObj.ok.disabled=false;
		else
		formObj.ok.disabled=true;
	}

function alignHeading()
{
	if(parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader")!=null)
	{
				parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").width =	eval(document.getElementById("detailTab").offsetWidth);
				for (j=0; j < document.getElementById("detailTab").rows(0).cells.length; j++) 
				{
					var wid=eval(document.getElementById("detailTab").rows(0).cells(j).offsetWidth);
					
					if(parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").rows(0).cells(j) != null)
					{
						parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").rows(0).cells(j).width=wid;
					}
				}
		}
		
	}

function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.ReviewResultsForwardPractHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.ReviewResultsForwardPractHeader.document.body.scrollLeft=temp;
	}
}
	
