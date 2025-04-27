 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

26/04/2023  40016           Ranjith P R       27/04/2023         Ramesh Goli        ML-MMOH-CRF-1823                 
----------------------------------------------------------------------------------------------------------------------------------------------------------	
 */
/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
var objVal = ""


function loadPage(obj){
	objVal = obj.value;
	parent.user_for_review_top2.location.href = "../../eOR/jsp/UserForReviewAddModifyTop2.jsp?mode=1&function_id="+function_id+"&type="+objVal;
	parent.reason_for_review_bottom.location.href = "../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function loadValues(obj){

	if(obj.name == 'responsibility'){
		//objVal = obj.name
		parent.reason_for_review_bottom.location.href = "../../eOR/jsp/UserForReviewAddModifyBottom.jsp?mode=1&function_id="+function_id+"&resp_id="+obj.value;
	}
	if(obj.name == 'practitioner_desc'){
		var praccode =document.user_for_review.practitioner.value;
		if(praccode!="")
		{
		parent.reason_for_review_bottom.location.href = "../../eOR/jsp/UserForReviewAddModifyBottom.jsp?mode=1&function_id="+function_id+"&pract_id="+praccode;
		}
		else
		{
				parent.reason_for_review_bottom.location.href = "../../eCommon/html/blank.html";
		}
	}
}


function create(){
	f_query_add_mod.location.href = "../../eOR/jsp/UserForReviewAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}


function query() {
f_query_add_mod.location.href='../../eOR/jsp/UserForReviewQueryCriteria.jsp?function_id='+function_id ;
	}


function deleterecord(){
	
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var mode =null;
	if(f_query_add_mod.user_for_review_top1){
		var formObjFirst = 	f_query_add_mod.user_for_review_top1.document.user_for_review_top1 ;
		mode = formObjFirst.mode.value;
	}

	if(f_query_add_mod.user_for_review_top2.document.forms[0]) {
		var formObj=f_query_add_mod.user_for_review_top2.document.user_for_review ;
		mode = formObj.mode.value;
	}
	
	if(mode == "1"){
			message  = getMessage("NOT_VALID_DELETE","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	var formObj = f_query_add_mod.user_for_review_top2.document.user_for_review ;
	var formObj1 = f_query_add_mod.reason_for_review_bottom.document.user_for_review_dtl ;

	if(formObj1.mode.value != MODE_INSERT){

		//alert(formObj1.mode.value);
		//formObj1.mode.value = MODE_DELETE;

		if(formObj.responsibility){
			formObj1.responsibility.value = formObj.responsibility.value
		}
		if(formObj.practitioner){
			formObj1.practitioner.value = formObj.practitioner.value
		}
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		
		if(confirm_val){
			formObj1.mode.value = MODE_DELETE;
			//alert("inside");
			eval(	formApply( f_query_add_mod.reason_for_review_bottom.document.user_for_review_dtl,OR_CONTROLLER) );
			f_query_add_mod.location.href = "../../eOR/jsp/UserForReviewAddModify.jsp?mode="+MODE_INSERT;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return;
		}
		
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}


function apply() {

	
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

var mode = null;

if(f_query_add_mod.user_for_review_top1){
var formObjFirst = 	f_query_add_mod.user_for_review_top1.document.user_for_review_top1 ;
mode = formObjFirst.mode.value;
}

if(f_query_add_mod.user_for_review_top2.document.forms[0]) {
var formObj=f_query_add_mod.user_for_review_top2.document.user_for_review ;
mode = formObj.mode.value;
}

var formObj1= f_query_add_mod.reason_for_review_bottom.document.user_for_review_dtl ;

 if((mode == "1") &&(formObjFirst.radio_but[0].checked || formObjFirst.radio_but[1].checked)){
		if(formObjFirst.radio_but[0].checked && formObj.practitioner.value == ""){
			var msg3 =  getMessage('PRACT_NOT_BLANK','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg3;
			return false
		}else if(formObjFirst.radio_but[0].checked && formObj.practitioner.value != ""){
			formObj1.practitioner.value = formObj.practitioner.value
		}

		if(formObjFirst.radio_but[1].checked && formObj.responsibility.value == ""){
			var msg3 = getMessage('RESP_NOT_BLANK','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg3;
			return false
		}else if(formObjFirst.radio_but[1].checked && formObj.responsibility.value != ""){
			formObj1.responsibility.value = formObj.responsibility.value
		}
	}else if(mode == "1"){
		var msgs1 =  getMessage('SELECT_RESP_OR_PRACT','OR')
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msgs1;
		return false
	}


	if(mode == "2" && formObj.practitioner){
			formObj1.practitioner.value = formObj.practitioner.value

	}else if(mode == "2" && formObj.responsibility){
			formObj1.responsibility.value = formObj.responsibility.value

	}

	var finalString="";

		var totalChk = formObj1.totalSize.value

		var scopeChecked = "";
		var finalScope	= "";
		var allOrderCats = ""
		var ordCat		= "";
		var auth		= ""
		var finalAuth		= "";
		var co_sign		= ""
		var final_co_sign		= "";
		var sp_appr		= ""
		var final_sp_appr		= "";
		var qu_appr		= ""//40016
		var final_qu_appr		= "";//40016
		var chkAuth = "N";
		var chkCosign = "N";
		var chkSpAppr = "N";
		var chkQuAppr = "N";//40016
		for(i=0; i<totalChk; i++){
			ordCat = eval("formObj1.ordCat"+i).value
			allOrderCats = allOrderCats+ordCat+"~"

			//auth = "N"
			if(eval("formObj1.auth"+i).checked == true) {
				auth = "Y"
				chkAuth = "Y";
			}
			else 
				auth = "N"
			finalAuth = finalAuth+auth+"~"


			//co_sign = "N"
			if(eval("formObj1.co_sign"+i).checked == true) {
				co_sign = "Y"
				chkCosign = "Y";
			}
			else 
				co_sign = "N"
			final_co_sign = final_co_sign+co_sign+"~"

			//sp_appr = "N"
			if(eval("formObj1.sp_appr"+i).checked == true) {
				sp_appr = "Y"
				chkSpAppr = "Y";
			}
			else 
				sp_appr = "N"
			final_sp_appr = final_sp_appr+sp_appr+"~"
			//40016 starts
			if(formObj1.siteQuotaLimitYN.value=='true')
 			{
				if (eval("formObj1.qu_appr" + i).checked == true) {
					qu_appr = "Y";
					chkQuAppr = "Y";
				} else
					qu_appr = "N";
			}
			else{
			qu_appr="N";
			}
			final_qu_appr = final_qu_appr+qu_appr+"~"
			//40016 ends

		}
 //   alert("@@@@@@@@@");
    //if(chkAuth == "N" && chkCosign == "N" && chkSpAppr == "N")
    //{
	   // message  = getMessage("ATLEAST_ONE_SELECTED","OR");
	    //messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	    //return false;
   // }
        
	//else
	//{
		if(allOrderCats != ""){
			allOrderCats=allOrderCats.substring(0,allOrderCats.length-1);
		}
		if(finalAuth != ""){
			finalAuth=finalAuth.substring(0,finalAuth.length-1);
		}
		if(final_co_sign != ""){
			final_co_sign=final_co_sign.substring(0,final_co_sign.length-1);
		}
		if(final_sp_appr != ""){
			final_sp_appr=final_sp_appr.substring(0,final_sp_appr.length-1);
		}
		//40016 start
		if(final_qu_appr != ""){
			final_qu_appr=final_qu_appr.substring(0,final_qu_appr.length-1);
		}
		//40016 end

		formObj1.allOrderCats.value = allOrderCats ;
		formObj1.allFinalAuth.value = finalAuth ;
		formObj1.allFinalCo_sign.value = final_co_sign ;
		formObj1.allFinalSp_appr.value = final_sp_appr ;
		formObj1.allFinalQu_appr.value = final_qu_appr ;//40016

		if(formObj.responsibility){
			qry_string =  "mode=2&resp_id="+formObj.responsibility.value
		}
		if(formObj.practitioner){
			qry_string =  "mode=2&pract_id="+formObj.practitioner.value
		}
			
		eval(formApply( f_query_add_mod.reason_for_review_bottom.document.user_for_review_dtl,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	//}

}


function reset(){
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
	if(f_query_add_mod.user_for_review_top1 || f_query_add_mod.user_for_review_top2 ){
	   var mode = f_query_add_mod.frames[0].document.forms[0].mode.value ;

		if(mode == 1){
		var formObj = f_query_add_mod.user_for_review_top1.document.user_for_review_top1;
		if(f_query_add_mod.user_for_review_top2 && (formObj.radio_but[0].checked == true || formObj.radio_but[1].checked == true) ){
				if(f_query_add_mod.user_for_review_top2.document.forms[0].name == "user_for_review" ){
					f_query_add_mod.user_for_review_top1.document.user_for_review_top1.reset();
					f_query_add_mod.user_for_review_top2.location.href = "../../eCommon/html/blank.html";
					f_query_add_mod.reason_for_review_bottom.location.href = "../../eCommon/html/blank.html";
				}
			}
		}else{ //Update Mode

		  f_query_add_mod.frames[0].document.forms[0].reset();
		  f_query_add_mod.frames[1].document.forms[0].reset();
		}

	}else{
		f_query_add_mod.document.forms[0].reset();
	}
}



function onSuccess() {

	var mode =  null ;

	if(f_query_add_mod.user_for_review_top1 || f_query_add_mod.user_for_review_top2 ){
	mode = f_query_add_mod.frames[0].document.forms[0].mode.value ;
	}else{
	mode = f_query_add_mod.reason_for_review_bottom.document.user_for_review_dtl.mode.value;
	}

	if( mode == "1" ) {
	create();
	//f_query_add_mod.reason_for_review_bottom.location.href="../../eOR/jsp/UserForReviewAddModifyBottom.jsp?"+qry_string;
	}
	if(mode == "2"){
		f_query_add_mod.reason_for_review_bottom.location.href='../../eOR/jsp/UserForReviewAddModifyBottom.jsp?'+qry_string ;
	}

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
/************************************************************************/
function show_practtioner_window(target){

/*
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;


argumentArray[0]   = parent.frames[1].document.getElementById("prac_sql").value;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";
argumentArray[5]   = target.value ;
argumentArray[6]   = CODE_LINK ;
argumentArray[7]   = CODE_DESC ;


retVal = await CommonLookup( "Practitioner", argumentArray );

if(retVal != null && retVal != ""){
	target.value = retVal[1];
	parent.frames[1].document.user_for_review.practitioner.value=retVal[0];
	parent.frames[1].document.user_for_review.practitioner_desc.focus();
}
	*/
	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";

	practName_FName		= target.name;		// object name
	practName_FValue	= target.value;
	practId_FName		= document.user_for_review.practitioner.value;
	
	var sql				= user_for_review.prac_sql.value;
	var sql2			= user_for_review.prac_sql1.value;
	var splty			= "";
	var facility_id		= "";
	//facility_id		= facilityID;
	// here not needed job_title , gender, practitioner_type, specialty-code
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
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
	eval(practSearch(encodeURIComponent(practName_FName),encodeURIComponent(practName_FValue),splty,responseText));
}

function CheckForNotChars(event){  //added by prasad
    if( (event.keyCode < 97) && (event.keyCode > 122) )
		return (event.keyCode);
	else
		return false ;
}

function PractLookupRetVal(retVal,target)
{
 	if(retVal != null && retVal != "")
	{
		arr=retVal.split("~");
		document.user_for_review.practitioner.value=arr[0];
		document.user_for_review.practitioner_desc.value = arr[1];
		document.user_for_review.practitioner_desc.focus();
	}
	/*else
	{
		document.user_for_review.practitioner_desc.value="";
		document.user_for_review.practitioner_desc.focus();
	}*/
 }
/**********************Check for Valid Operation*******************************/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/******************************************************************************/

/*function show_practtioner_window()	{

			alert("here wrong");
	var formObj = document.user_for_review;

			var retVal = 	""; //new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var search_code="";
			var search_desc="";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;

			var tit="Practitioner"
			var sql="SELECT practitioner_id code,practitioner_name description   FROM am_practitioner";
			search_code ="practitioner_id";
			search_desc = "practitioner_name";

			retVal =	window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			alert(retVal)

			if (!(retVal == null)) {
				var vals=retVal.split("/")	;
				parent.frames[1].document.user_for_review.practitioner.value=unescape(vals[0]);
				parent.frames[1].document.user_for_review.practitioner_desc.value=unescape(vals[1]);
			}

			parent.frames[1].document.user_for_review.practitioner_desc.focus();

} */
async function practSearch(practName_FName,practName_FValue,splty,responseText) {
 
	var retVal = 	new String();
 
	var dialogTop = "10px" ;
 
	var dialogHeight= "500px" ;
 
	var dialogWidth	= "800px" ;
 
	if(responseText =="true") {        	
 
	    dialogWidth="700px";
 
	}
 
	var status = "no";
 
	var arguments	= "" ;
 
	var tit="Pract Search";
 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var sqlArray= new Array();
 
	//var objName="<%=practName_FName%>";
 
	var objName=practName_FName;
 
    arguments='';
 
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
 
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
 
	PractLookupRetVal(retVal,objName); 	
 
}