/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------
Date			 Edit History      Name		Rev.Date	Rev.Name       Description
--------------------------------------------------------------------------------------------------------
?					100            ?													created
8/1/2014	  LICN_1			Karthi			8/1/2014	Dinesh T			MMS Internal Issue.
--------------------------------------------------------------------------------------------------------
*/
var associatedMeasureCount = 0; // LICN_1
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/TermCodeEvalMeasureFrameset.jsp";
	document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="84vh";
	/*document.getElementById("f_query_add_mod_detail").style.height="300px";*/
	document.getElementById("messageFrame").style.height="7vh";
}

function apply()
{
	
	//changing on 18/11/08
	if (! checkIsValidForProceed() ) {
		message  = getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	
	if (!checkIsValidForProceed2()){	
		var frmobj=f_query_add_mod.f_query_header.document.TermcodeEvalMeasureHeaderForm;
		var fields = new Array (frmobj.terminologySet,frmobj.type,frmobj.termCodeDesc);
		var names = new Array (getLabel("Common.TerminologySet.label","Common"),getLabel("Common.type.label","Common"),getLabel("Common.TerminologyCode.label","Common"));
		// LICN_1 - Start
		/*		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame)) 
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		*/	
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame)) {
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCP/jsp/TermCodeEvalMeasureValidate.jsp?validate=COUNTRECORD", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
		if(associatedMeasureCount == 0) {
				message = getMessage("TERM_SET_MANDATORY","CP");
				parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return false ;
		}
		//LICN_1 - End
	}
	var formobj=f_query_add_mod.f_query_result.document.termCodeEvalMeasureResultForm;
	if(f_query_add_mod.f_query_result.document.termCodeEvalMeasureResultForm)
	{
		formobj.submit();
	}
}
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed2()
{	
	var url = f_query_add_mod.f_query_result.location.href;
		url = url.toLowerCase();
		
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 )) {
				return false; //	LICN_1
			//return true; 	//LICN_1
		}		
		else {
			return false;
		}	
}
 // LICN_1 - START
function selectedRecordCounts(count){
	associatedMeasureCount = count;
}

function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		f_query_add_mod.location.href="../../eCP/jsp/TermCodeEvalMeasureFrameset.jsp";		
	}
}

function onSuccess()
{
	create();
	
}

function getLevels(obj)
{
	var termSetid=obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/TermCodeEvalMeasureValidate.jsp?termSetid="+termSetid+"&validate=LEVEL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function assignLevels(values){
	var levels=values.split("||");
	var frmobj=document.TermcodeEvalMeasureHeaderForm;
	var obj = eval(frmobj.type);
	clearData(obj);
	if(levels[1]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("D");
		opt.text =getLabel("Common.diagnosis.label","Common");
		obj.add(opt);
	}
		if(levels[2]=='Y'){
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("P");
		opt.text =getLabel("Common.Procedure.label","Common");
		obj.add(opt);
	}
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}


function loaddetails()
{
	formobj=document.TermcodeEvalMeasureHeaderForm;
	if(!(formobj.terminologySet.value=="" || formobj.type.value=="" || formobj.termCode.value=="")){
		parent.f_query_result.location.href="../../eCP/jsp/TermCodeEvalMeasureResult.jsp?termSet="+formobj.terminologySet.value+"&termCode="+formobj.termCode.value+"&loadvalue=1";
		parent.f_query_detail.location.href="../../eCP/jsp/TermCodeEvalMeasureAddModify.jsp?termSet="+formobj.terminologySet.value+"&termCode="+formobj.termCode.value;
		formobj.Associate.disabled=true;
	}
}

function CheckNumber(obj,lowest,highest) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
	{
        value=obj.value;
		low=parseInt(lowest);
		high=parseInt(highest);
		if(value<low || value>high)
		{
			message  =getMessage("RANGE_1_TO_100","CP");
			alert(message);
			obj.value="";
			 obj.select();
             obj.focus();
             return false;
		}
    }
    else
	{
        if ( obj.value.length > 0 ) 
		{
            alert(getMessage("NUM_ALLOWED","CP"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

async function termCodeLookup(target)
{
	formobj=document.TermcodeEvalMeasureHeaderForm;
	termsetobj=eval("formobj.terminologySet");
	termsettypeobj=eval("formobj.type");
	if(checkField(termsetobj,getLabel("Common.TerminologySet.label","Common"))){
		if(checkField(termsettypeobj,getLabel("eCP.TerminologySetType.label","CP"))){
			var termSet=formobj.terminologySet.value;
			var type=formobj.type.value;
			var tablename="MR_"+type+"_"+termSet+"_VW";
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
 			argumentArray[0] ="SELECT TERM_CODE CODE, SHORT_DESC DESCRIPTION FROM "+tablename+" WHERE UPPER(TERM_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY SHORT_DESC";
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2"; 
			argumentArray[5] = target.value.toUpperCase();
			//alert("5555555");
			argumentArray[6] = CODE_LINK;	//CODE_LINK
			argumentArray[7] = CODE_DESC;	//CODE_DESC
			retVal = await CommonLookup(getLabel("Common.TerminologyCode.label","Common"), argumentArray );
			if(retVal != null && retVal != "") {
				var ret1=unescape(retVal);
				 var arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					}
				target.value = arr[1] ;
				formobj.termCode.value = arr[0];
			}
		}
	}
}

function addtoList()
{
	formobj=document.termCodeEvalAddmodifyForm;
	var messageFrame=parent.parent.messageFrame;
	var termSet=formobj.termSet.value;
	var termCode=formobj.termCode.value;
	var fields = new Array ( formobj.id,
							 formobj.Desc,
							 formobj.score,
							 formobj.seq_no
						);
	var names=new Array(getLabel("Common.identification.label","Common"),
						getLabel("Common.description.label","Common"),
						getLabel("eCP.CutOffScore.label","CP"),
						getLabel("Common.SequenceNo.label","Common")								
						);
	if(parent.f_query_detail.checkFieldsofMst( fields, names, messageFrame))
	{
		//alert("inside if");
		parent.parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp"+"";	
		var argument="validate=INSERTVALUE&termSet="+termSet+"&termCode="+termCode+"&id="+formobj.id.value+"&Desc="+formobj.Desc.value+"&score="+formobj.score.value+"&seq_no="+formobj.seq_no.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCP/jsp/TermCodeEvalMeasureValidate.jsp?"+argument, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);
		parent.f_query_result.location.href="../../eCP/jsp/TermCodeEvalMeasureResult.jsp?termSet="+termSet+"&termCode="+termCode;
		parent.f_query_detail.location.href="../../eCP/jsp/TermCodeEvalMeasureAddModify.jsp?termSet="+termSet+"&termCode="+termCode;
	}
}

function loadIddetails(id,desc,score,seqno)
{
	//formobj=parent.f_query_result.document.termCodeEvalMeasureResultForm;
	var formobj=document.termCodeEvalMeasureResultForm;
	//alert(formobj);
	var termSet=formobj.termSet.value;
	var termCode=formobj.termCode.value;
	parent.f_query_detail.location.href="../../eCP/jsp/TermCodeEvalMeasureAddModify.jsp?termSet="+termSet+"&termCode="+termCode+"&id="+id+"&Desc="+desc+"&score="+score+"&seq_no="+seqno;

}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function clearAll(){
	formobj=document.termCodeEvalAddmodifyForm;
	formobj.id.disabled=false;
	formobj.id.value="";
	formobj.Desc.value="";
	formobj.score.value="";
	formobj.seq_no.value="";
}

function deletefrmList()
{
	formobj=document.termCodeEvalAddmodifyForm;
	var termSet=formobj.termSet.value;
	var termCode=formobj.termCode.value;
	var argument="validate=DELETEVALUE&termSet="+termSet+"&termCode="+termCode+"&id="+formobj.id.value+"&Desc="+formobj.Desc.value+"&score="+formobj.score.value+"&seq_no="+formobj.seq_no.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCP/jsp/TermCodeEvalMeasureValidate.jsp?"+argument, false);
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText);
		parent.f_query_result.location.href="../../eCP/jsp/TermCodeEvalMeasureResult.jsp?termSet="+termSet+"&termCode="+termCode;
		parent.f_query_detail.location.href="../../eCP/jsp/TermCodeEvalMeasureAddModify.jsp?termSet="+termSet+"&termCode="+termCode;
}

