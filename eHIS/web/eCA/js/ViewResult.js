/**
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
--------------------------------------------------------------------------------------------------------------
11/06/2013  	IN039414      		Ramesh G		Result Widget->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result	
15/11/2013 		IN035717			vijayakumark	Alpha-OR- View Results Records not displayed in Practitioner s Desktop
26/02/2018		IN066119		Raja S		26/02/2018		Ramesh G		ML-MMOH-CRF-1024
--------------------------------------------------------------------------------------------------------------
*/ 
var message="";
var result="";
var l=0;
	var m=0; 
function populateValues(){
	
	var fields = new Array (parent.ReviewResultsSearch.document.review_result_search.patientId );
	var names = new Array ( getLabel("Common.patientId.label","Common"));	
		if(SpecialCharCheck(fields,names,"","A","")){
			var formObj=parent.ReviewResultsSearch.document.review_result_search;
			var fromDate = formObj.period_from
			var toDate = formObj.period_to
			
			if(!trimCheck(fromDate.value)){
				alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
				parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
				return false
			}

			if(!trimCheck(toDate.value)){
				alert(getMessage("TO_DT_NOT_BLANK","SM"));
				parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
				return false
			}

			//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
				return false ;
			}
			qry_string = "priority="+parent.ReviewResultsSearch.document.review_result_search.priority.value+"&normalcy_ind="+parent.ReviewResultsSearch.document.review_result_search.normalcy_ind.value+"&result_type="+parent.ReviewResultsSearch.document.review_result_search.result_type.value+"&patientId="+parent.ReviewResultsSearch.document.review_result_search.patientId.value+"&event_class="+parent.ReviewResultsSearch.document.review_result_search.event_class.value
			qry_string += "&groupby="+parent.ReviewResultsSearch.document.review_result_search.group_by.value
			qry_string += "&patient_class="+parent.ReviewResultsSearch.document.review_result_search.patient_class.value
			qry_string += "&period_from="+parent.ReviewResultsSearch.document.review_result_search.period_from.value
			qry_string += "&period_to="+parent.ReviewResultsSearch.document.review_result_search.period_to.value
			qry_string += "&ca_normalcy_ind="+parent.ReviewResultsSearch.document.review_result_search.ca_normalcy_ind.value
			qry_string += "&encounter_id="+parent.ReviewResultsSearch.document.review_result_search.encounter_id.value
			qry_string += "&status_crit="+parent.ReviewResultsSearch.document.review_result_search.status_crit.value
			qry_string += "&relationship_id="+parent.ReviewResultsSearch.document.review_result_search.relationship_id.value
			
			if(parent.ReviewResultsSearch.document.review_result_search.curr_enc.checked)
			{
				curr_enc="Y";
			}
			else
			{
				curr_enc="N";
			}
			qry_string += "&curr_enc="+curr_enc ;
			

			//qry_string += "&modal=Y";
			//alert(top.content.name);
			parent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =true;
			parent.ReviewResultsHeader.location.href = "../jsp/ViewResultsHeader.jsp?"+qry_string
			parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
			/* IN035717 starts here */
			parent.ReviewResultsBtn.location.href = "../jsp/ViewResultsToolbar.jsp"
			//parent.ReviewResultsBtn.location.href = "../jsp/ViewResultsToolbar.jsp?option_id="+parent.ReviewResultsSearch.document.review_result_search.option_id.value;			
			/* IN035717 ends here */
	}
} 

function clearValues(){
	document.review_result_search.search_btn.disabled =false;
	parent.ReviewResultsSearch.document.forms[0].reset();
	parent.ReviewResultsHeader.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsBtn.location.href = "../../eCommon/html/blank.html"

}

function clickAll(){
	if(document.review_results_hdg.select_all.checked == true){
	   var retVal = clickHeader(document.review_results_hdg.select_all);
	   if (retVal != null) {
    		for(cnt=0; cnt<parent.ReviewResultsResult.document.review_results_dtl.total_recs.value; cnt++){
    			val = eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+cnt);
    			remarks = eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+cnt);
    			if(!val.disabled)
				{
					val.checked = true;
				}
    			remarks.value = retVal;
    		}
		} else {
		  document.review_results_hdg.select_all.checked = false;
		}
	}else{
		for(cnt=0; cnt<parent.ReviewResultsResult.document.review_results_dtl.total_recs.value; cnt++){
			val = eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+cnt);
			remarks = eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+cnt);
			val.checked = false;
			remarks.value = "";
		}
	}
}


function completeReview(){
	var no_of_checked = 0;
	var formObj 		= parent.ReviewResultsResult.document.review_results_dtl
	var formObjSearch 	= parent.ReviewResultsSearch.document.review_result_search
	practitioner_id 	= formObj.practitioner_id.value

	priority			= formObjSearch.priority.value
	normalcy_ind		= formObjSearch.normalcy_ind.value
	result_type			= formObjSearch.result_type.value
	patientId			= formObjSearch.patientId.value
	event_class			= formObjSearch.event_class.value

	qry_string = "../jsp/ViewResultsDetail.jsp?practitioner_id="+practitioner_id+"&priority="+priority+"&normalcy_ind="+normalcy_ind+"&result_type="+result_type+"&patientId="+patientId+"&event_class="+event_class

	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+cnt);

		if(val.checked == true) {
		      val.value="Y";
			no_of_checked++;
		}
	}

	if(parseInt(no_of_checked) == 0){
		alert(getMessage("CHECK_ATLEAST_ONE_EVENT","OR"));
		return false
	}

		eval(formApply( parent.ReviewResultsResult.document.review_results_dtl,OR_CONTROLLER)) ;
		if( invalidCode != "" && invalidCode!=null){// in orMessageArray){ //"OR_STATUS_CHANGED"
			parent.ReviewResultsResult.document.getElementById("status"+invalidCode).className="orcancel";
			alert(getMessage(message,"Common"));
			return false;
		}else
		{  if(top.content!=null){
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			}
			else
			{
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			}
		}
		if( result ) {
			onSuccess();
		}
	//document.location.reload();
	populateValues();

}

function assignResult(_result, _message, _flag, _code){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;
}

function onSuccess() {
	parent.frames[2].location.href=qry_string
}

function clearChecked(){
	parent.ReviewResultsHeader.document.review_results_hdg.reset()
	parent.ReviewResultsResult.document.review_results_dtl.reset()
}


async function viewClobData(accession_num){
		
		//row_index = unescape(row_index)
		var dialogHeight ='65vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '';
		var dialogLeft = '' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "accession_num="+ escape(accession_num);
		
		//var retVals = window.showModalDialog("../../eCA/jsp/ViewResultClobData.jsp?"+finalString,arguments,features); //IN039414
		var retVals = await top.window.showModalDialog("../../eCA/jsp/ViewResultClobDataMain.jsp?"+finalString,arguments,features); //IN039414
		
}

async function viewComments(i){ 
	var result = eval("document.review_results_dtl.result_str"+i+".value");
	var retVal;
	var dialogHeight	= '30vh' ;
	var dialogWidth 	= '35vw' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;
	arguments 			= result ;
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../eCA/jsp/ViewResultOrderEntryComments.jsp?hdg_name="+encodeURIComponent(hdg_name),arguments,features);
}

//this is used for patient ID search
async function callPatientSearch(){
	var pat_id =  await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

async function viewClobDataHtm(accession_num){
		//row_index = unescape(row_index)
		var dialogHeight ='100vh' ;
		var dialogWidth = '75vw' ;
		var dialogTop	= '189';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "accession_num="+encodeURIComponent(accession_num);
		//alert("ViewResult.js-->"+finalString)
		var retVals = await window.showModalDialog("../../eCA/jsp/ViewResultClobDataHtm.jsp?"+finalString,arguments,features);
}

function addEventClass(code,value) {
	var element 	= document.createElement('OPTION') ;
	element.value 	= code ;
	element.text 	= value ;
	document.review_result_search.event_class.add(element);
}

function clearList(  ) {
	var len = eval("document.review_result_search.event_class.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.review_result_search.event_class.remove(\"event_class\")") ;
	}
	var tp 		= "----------- "+getLabel("Common.defaultSelect.label","Common")+" -----------" ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval("document.review_result_search.event_class.add(opt)") ;
}


function populateEventClass( obj ) {
	
	if(obj.value!='')
	{
	var bean_id 	= document.review_result_search.bean_id.value ;
	var localeName=document.review_result_search.localeName.value;
	var bean_name 	= document.review_result_search.bean_name.value ;
	var xmlDoc 		= "";
	var xmlHttp 	= new XMLHttpRequest();
	xmlStr			= "<root><SEARCH " ;
	xmlStr 			+= obj.name+"=\""+ obj.value +"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ViewResultsValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&func_mode=EVENT_CLASS&localeName="+localeName, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	}
	else
	{
		clearList( );
	}
	
}

async function clickHeader(obj) {
    if (obj.checked == true) {
        var dialogHeight= '35vh' ;
        var dialogWidth = '39vw' ;
        var dialogTop	= '290';
        var dialogLeft 	= '280' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
        var arguments 	= "";
        obj.value = "Y";
		//var review_remarks	= eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+rec_num).value

		var retVals = await window.showModalDialog("../../eCA/jsp/ViewResultsRemarks.jsp",arguments,features);
		if (retVals != null) return retVals
    }
}
function clickChk(rec_num){
	
	//var kk=eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).checked;
	if(eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).checked == true ){
		   eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).value = "Y";	
		   parent.ReviewResultsResult.document.getElementById("remark_td"+rec_num).innerHTML="<font size='1'><a class='gridLink' href=\"javascript:clickLine('"+rec_num+"')\">"+getLabel('Common.remarks.label','Common')+"</a></font>";			
	}else{
		//IN066119 starts
		if(eval("parent.ReviewResultsResult.document.review_results_dtl.headval"+rec_num)!=undefined){
			headvalue =eval("parent.ReviewResultsResult.document.review_results_dtl.headval"+rec_num).value;
			document.getElementById("maingrp"+headvalue).checked= false;
		}
		//IN066119 ends
		 eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).value = "N";
		 parent.ReviewResultsResult.document.getElementById("remark_td"+rec_num).innerHTML="&nbsp";	
		 eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+rec_num).value="";
	}

}
//IN066119 starts
async function checkgroup(rec_num){
	var formObj     = parent.ReviewResultsResult.document.review_results_dtl;
	var flag=false;
	tempval = document.getElementById("maingrp"+rec_num).checked;
	if(tempval == true)
	{
		for(cnt=0; cnt<formObj.total_recs.value; cnt++)
		{
			val = document.getElementById("subgrp"+rec_num+cnt);
			if(val!=undefined )
			{
				if(!val.disabled)
				{
					flag=true;
				}
				else{
					if(!flag == true)
						flag=false;
				}
				
			}
		}
	}
	if(flag == false && tempval == true){
		alert("All the Sub Event has been disabled");
		document.getElementById("maingrp"+rec_num).checked= false;
		return;
	}

	if(tempval == true)
	{
		var retVal = await clickSubGrpRemarks();
		for(cnt=0; cnt<formObj.total_recs.value; cnt++)
		{
			val = document.getElementById("subgrp"+rec_num+cnt);
			remarks = document.getElementById("subgrp_remarks"+rec_num+cnt);
			if(val!=undefined )
			{
				if(!val.disabled)
				{
					val.checked = true;
					remarks.value =retVal;
				}
			}
		}
	}
	else
	{
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = document.getElementById("subgrp"+rec_num+cnt);
			remarks = document.getElementById("subgrp_remarks"+rec_num+cnt);
			if(val!=undefined && (!val.disabled)){
				val.checked = false;
				remarks.value ="";
			}
		}

	}
	
}
async function clickSubGrpRemarks() { 
        var dialogHeight= '35vh' ;
        var dialogWidth = '39vw' ;
        var dialogTop	= '290';
        var dialogLeft 	= '280' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
        var arguments 	= "";

		var retVals = await window.showModalDialog("../../eCA/jsp/ViewResultsRemarks.jsp",arguments,features);
		if (retVals != null) return retVals
}
//IN066119 ends
async function clickLine(rec_num){
    if(eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).checked == true ){
  		var dialogHeight= '35vh' ;
        var dialogWidth = '37vw' ;
        var dialogTop	= '290';
        var dialogLeft = '280' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
        var arguments 	= "";
        eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).value = "Y";
		var review_remarks	= eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+rec_num).value

		var retVals = await window.showModalDialog("../../eCA/jsp/ViewResultsRemarks.jsp?&review_remarks="+encodeURIComponent(review_remarks),arguments,features);
		if (retVals != null) {
			var total_recs = parent.ReviewResultsResult.document.review_results_dtl.total_recs.value;
            for (i=0;i < total_recs;i++) {
            	var val	= eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+i);
            	var chkVal	= eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+i);
            	if ((chkVal.checked == true) && (val.value == ''))
            		eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+i).value = retVals
			//eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+rec_num).value = retVals
			}
        }
	} else {
	   eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+rec_num).value = 'N';
	  
	}
}

function closeRemarks() {
    //if (document.reviewRemarks.review_remarks.value == "") {
    //    alert("Remarks cannot be blank");
    //    return false;
    //} else {
        window.returnValue = document.reviewRemarks.review_remarks.value;
		//alert( "in js"+document.reviewRemarks.review_remarks.value);
        window.close();
    //}
}

function chkRemarksLength() {
    if (document.reviewRemarks.review_remarks.value.length > 2000) {
        alert(getMessage("REVIEW_REMARKS_MAX_LENGTH","OR"));
        return false;
    }
}

async function viewFlowSheet(index) {
    //if (eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+index).checked == true)
    {
        var patient_id = "";
        var flag = true;
        for (i = 0; i < parent.ReviewResultsResult.document.review_results_dtl.total_recs.value;i++) {
            if (eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+i).checked == true && flag) {
                patient_id = eval("parent.ReviewResultsResult.document.review_results_dtl.patient_id"+i).value;
                for (j = i; j < parent.ReviewResultsResult.document.review_results_dtl.total_recs.value;j++) {
                    //alert("patient_id="+patient_id+",pat_id="+eval("parent.ReviewResultsResult.document.review_results_dtl.patient_id"+j).value);
                    if ((eval("parent.ReviewResultsResult.document.review_results_dtl.patient_id"+j).value != patient_id && eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+j).checked == true) && flag) {
                        flag = false;
                        alert(getMessage("REVIEW_RESULTS_PREVIOUS_ORDERS","OR"));
                        //return false;
                    }
                }
            }
        }
        //alert("success");
        if (flag) {
            var dialogHeight ='100vh' ;
    		var dialogWidth = '80vw' ;
    		var dialogTop	= '129';
    		var dialogLeft = '30' ;

            var title 	= ''
            var from_function = "SearchResult"
            var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
            var arguments 	= "";
            var patient_id	= eval("parent.ReviewResultsResult.document.review_results_dtl.patient_id"+index).value
    		var event_code	= eval("parent.ReviewResultsResult.document.review_results_dtl.event_code"+index).value
    		var event_group	= eval("parent.ReviewResultsResult.document.review_results_dtl.event_group"+index).value
    		var event_class	= eval("parent.ReviewResultsResult.document.review_results_dtl.event_class_code"+index).value
    		var hist_rec_type	= eval("parent.ReviewResultsResult.document.review_results_dtl.hist_rec_type"+index).value

            qryString = "p_patient_id="+patient_id+"&p_event_code="+event_code+"&p_event_group="+event_group+"&p_event_class="+event_class+"&p_hist_rec_type="+hist_rec_type+"&p_called_from=OR";
						
            var abnormalFlag = confirm(getMessage("CONFIRM_ABNORMAL_RESULT","OR"));
            if (abnormalFlag) {
                qryString += "&abnormal=Y";
            }

    		var retVals = await top.window.showModalDialog("../../eCA/jsp/FlowSheet.jsp?"+qryString,arguments,features);
		}
    }

}

async function callForward() {

    var formObj     = parent.ReviewResultsResult.document.review_results_dtl;
	var localeName=document.review_result_btn.localeName.value;
    var bean_id 	= formObj.bean_id.value ;
	var bean_name 	= formObj.bean_name.value ;
	var total_recs  = formObj.total_recs.value;

    var count       = 0;
	
	var xmlDoc 		= "";
	var xmlHttp 	= new XMLHttpRequest() ;
	xmlStr			= "<root><SEARCH " ;

	for (i=0;i<total_recs;i++) {
	   if (eval("formObj.chk"+i).checked == true) {
	       xmlStr 			+= "hist_rec_type"+count+"=\""+ eval("formObj.hist_rec_type"+i).value +"\" " ;
	       xmlStr 			+= "contr_sys_id"+count+"=\""+ eval("formObj.contr_sys_id"+i).value +"\" " ;
	       xmlStr 			+= "accession_num"+count+"=\""+ eval("formObj.accession_num"+i).value +"\" " ;
	       xmlStr 			+= "review_type"+count+"=\""+ eval("formObj.review_type"+i).value +"\" " ;
	       xmlStr 			+= "event_code"+count+"=\""+ eval("formObj.event_code"+i).value +"\" " ;
		   xmlStr 			+= "normalcy_ind"+count+"=\""+ eval("formObj.normalcy_ind"+i).value +"\" " ;
		   
		   count++;
		  // alert("finalString="+finalString);
	   }
	}
	
	if (count <= 0) {
		alert(getMessage("CHECK_ATLEAST_ONE_EVENT","OR"));
		return false
	} else {
	    xmlStr 			+= "total_recs=\""+ count +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ViewResultsValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&func_mode=FORWARD_PRACT&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//eval( responseText ) ;
		var dialogHeight ='100vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '0px';
		var dialogLeft = '30' ;
		var title 	= '';
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	    var arguments 	= "";
	    var retVals = await window.showModalDialog("ViewResultsForwardPractFrameset.jsp",arguments,features);
		if (retVals != null && retVals != '' && retVals == 'true')
			var confirmFlag = confirm(getMessage("CONFIRM_COMPLETE_REVIEW","OR"));
			if (confirmFlag) {
				completeReview();
				formObj.reset();
			}/*else{
				for (j=0;j<total_recs;j++) {		
				eval("parent.ReviewResultsResult.document.review_results_dtl.chk"+j).value = "N";
				eval("parent.ReviewResultsResult.document.getElementById("remark_td")"+j).innerHTML="&nbsp";	
				eval("parent.ReviewResultsResult.document.review_results_dtl.review_remarks"+j).value="";	
		}
			}*/
	    
		
		
    }
}

function forwardToPract() {
	//alert("in forwardToPract");
    var formObj     = parent.ReviewResultsForwardPract.document.review_results_forward_pract_dtl;
	
    //alert(formObj.value);
	//var bean_id 	= formObj.bean_id.value ;
	//var bean_name 	= formObj.bean_name.value ;
	//var total_recs  = formObj.total_recs.value;

    var count       = 0;

	var xmlDoc 		= "";
	var xmlHttp 	= new XMLHttpRequest();
	//alert ("here 1");
/*	xmlStr			= "<root><SEARCH " ;

	for (i=0;i<total_recs;i++) {
	   if (eval("formObj.chk"+i).checked == true) {
	       xmlStr 			+= "pract_id"+count+"=\""+ eval("formObj.pract_id"+i).value +"\" " ;
	       count++;
	   }
	}

    xmlStr 			+= "total_recs=\""+ count +"\" " ;
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReviewResultsValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&func_mode=INSERT_FORWARD_PRACT", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert( responseText ) ;
	var msg="";
	eval( responseText ) ;
	//alert(getMessage('RECORD_MODIFIED'))
	alert(getMessage(msg))*/
	eval(formApply( formObj,OR_CONTROLLER)) ;
	//eval(formApply( formObj,'../../eOR/jsp/OrController.jsp')) ;
	//alert("here 2");
	//var index = message.lastIndexOf(".");
	//message = message.substring(0,index);
	//if(message!="")
	var temp=message;
	
	if((temp.value)=="RECORD_ALREADY_EXISTS")
		alert(temp);
		else
	alert(temp);
	if(result){
	window.returnValue = "true";
	window.close();
	}
	//else
	//window.returnValue = "false";
	
}

function searchPractitioner() {
	var formObj     = parent.ReviewResultsForwardPractSearch.document.review_result_forward_pract_search;
	formObj.search.disabled=true;
	var	search_by = formObj.searchBy.value;
	var search_criteria = formObj.search_criteria.value;
	var finalString = "" + formObj.qry_string.value;
	finalString += "&practitioner_name=" + encodeURIComponent(formObj.practitioner_name.value)+"&search_by="+search_by+"&search_criteria="+search_criteria;
	//alert("on click of search button,finalString="+finalString);
	parent.ReviewResultsForwardPract.document.location.href = "ViewResultsForwardPract.jsp?" + finalString;
}

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var localeName = eval("document."+from+".localeName")
	//	alert(fromDate.value);
	//	alert(toDate.value);

	//if(chckDate2(obj)){ //  this method is from ValidateControl.js// removed on 14/02/2007 while doing thai date validations
	if(validDateObj(obj,"DMY",localeName.value)){// function in DateUtils.js added for thai date validations

		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js// removed on 14/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){//this function is available in eCommon/js/DateUtils.js
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			//obj.focus()
			obj.value="";
			return false
		}
	}else{
	parent.ReviewResultsSearch.document.review_result_search.period_to.value=parent.ReviewResultsSearch.document.review_result_search.temp_last_week_date.value;

	}
}

function chckDate(Object2,focusflag)
{
	var localeName = parent.ReviewResultsSearch.document.review_result_search.localeName.value
//if(CheckDate(Object2,focusflag)==false)// revomed while thai date validations
if(validDateObj(Object2,"DMY",localeName)==false)// thai date validations 16/02/2007. function from DateUtils.js
	{
	parent.ReviewResultsSearch.document.review_result_search.period_from.value=parent.ReviewResultsSearch.document.review_result_search.temp_curr_week_date.value;
	}
}
/* removed on 14/02/2007 while doing thai date validations start*/
/*function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{
	parent.ReviewResultsSearch.document.review_result_search.period_to.value=parent.ReviewResultsSearch.document.review_result_search.temp_last_week_date.value;
	}
}*/
/* removed on 14/02/2007 while doing thai date validations end*/

function focusOnResult()
{
	parent.ReviewResultsHeader.document.review_results_hdg.select_all.disabled=false;
}	

function searchbutton() //Added by Prasad on 23/2/2007
{
	var formObj=parent.ReviewResultsForwardPractSearch.document.review_result_forward_pract_search;
	formObj.search.disabled=false;
}	

function chk(Obj)
{  //Added by Prasad on 23/2/2007
	
		formObj=parent.ReviewResultsForwardPractBtn.document.review_result_forward_pract_btn;
		if(Obj.checked==true)
			l=l+1;
		else if(Obj.checked==false)
			m=m+1;
		if(formObj)
		{
			if(l>m)
			 formObj.ok.disabled=false;
			else
			formObj.ok.disabled=true;
		}
}

function alignHeading()
{
	if(parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader")!=null)
	{
				parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").width =	eval(document.getElementById("detailTab").offsetWidth);
				for (j=0; j < document.getElementById("detailTab").rows[0].cells.length; j++) 
				{
					var wid=eval(document.getElementById("detailTab").rows[0].cells[j].offsetWidth);
					
					if(parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").rows[0].cells[j] != null)
					{
						parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader").rows[0].cells[j].width=wid;
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

function OrAllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}

function displayRecords(start, end, checkbox_name, form_name){
 		var formObj					= eval("document."+form_name);
 		if(formObj){

			formObj.from.value		= start;
			formObj.to.value		= end;
   			var checked_items		= 0;
			var get_confirmation	= true;

  			if(checkbox_name!=""){
	 			for(cnt=0; cnt<formObj.total_recs.value; cnt++){
					if( eval("formObj"+"."+checkbox_name+cnt)){
					val = eval("formObj"+"."+checkbox_name+cnt);
   					if(val.checked == true){
						checked_items++;
					}
				}
				}
				if(parseInt(checked_items) > 0){
					 get_confirmation = confirm(getMessage("VIEW_CONFIRM","OR"))
 				}  
			} // End of if checkbox_name
			if(get_confirmation)
				formObj.submit();
	 	} // End of formObj
 } // End of displayRecords

 function resetForwardPage()
{
	document.review_result_forward_pract_search.reset();
	parent.ReviewResultsForwardPractHeader.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsForwardPract.location.href = "../../eCommon/html/blank.html"
	parent.ReviewResultsForwardPractBtn.location.href = "../../eCommon/html/blank.html" 
}

