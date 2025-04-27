/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false
var message = "" ;
var flag = "" ;
var objVal = ""
var qry_string = "";


function loadPage(obj){
	objVal = obj.value;
	parent.user_for_reporting_bottom.location.href = "../../eOR/jsp/UserForReportingAddModifyBottom.jsp?mode="+MODE_INSERT+"&function_id="+function_id +"&type="+objVal;
}

function create(){
//	alert((eval("3")=="3")+"value of equality operateor");
	f_query_add_mod.location.href = "../../eOR/jsp/UserForReportingAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}


function query() {
	f_query_add_mod.location.href='../../eOR/jsp/UserForReportingQueryCriteria.jsp?function_id='+function_id ;
}


function deleterecord(){
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObjTop = f_query_add_mod.user_for_reporting_top.document.user_for_reporting_top;
	var mode = "";
	if(formObjTop){
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
		
	
	if(f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting.mode.value != MODE_INSERT){
		f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting.mode.value = MODE_DELETE;
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		//alert("confirm_val="+confirm_val);
		if(confirm_val){
			eval(formApply( f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting,OR_CONTROLLER));
			f_query_add_mod.location.href = "../../eOR/jsp/UserForReportingAddModify.jsp?mode="+MODE_INSERT;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//alert("result="+result);
			if( result ) {
				onSuccess();
			}
		}else{
			f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting.mode.value = MODE_MODIFY;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
		}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}


function apply(){
	
	
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
//	var mode = null
	var formObjTop = f_query_add_mod.user_for_reporting_top.document.user_for_reporting_top;
	var formObj = f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting;

	var mode = "";
	if(formObjTop){
		mode = formObjTop.mode.value;
	}else{
		mode = 2;
	}


	if((mode == "1") &&(formObjTop.radio_but[0].checked || formObjTop.radio_but[1].checked)){
	//	alert("line91");
		if(formObjTop.radio_but[0].checked && formObj.practitioner.value == ""){
			//alert("line93")
			var msg3 =  getMessage('PRACT_NOT_BLANK','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg3;
			return false
		}

		if(formObjTop.radio_but[1].checked && formObj.responsibility.value == ""){
		//	alert("line100")
			var msg3 = getMessage('RESP_NOT_BLANK','OR')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg3;
			return false
		}
	}else if(mode == "1"){
	//	alert("line106")
		var msgs1 =  getMessage('SELECT_RESP_OR_PRACT','OR')
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msgs1;
		return false
	}


	var fields = new Array ( formObj.order_category
						,formObj.order_type
						,formObj.privilege
						);

	var names = new Array ( getLabel("Common.OrderCategory.label","Common")
				,getLabel("Common.OrderType.label","Common")
				,getLabel("eOR.Privilege.label","OR")
				);

	if(f_query_add_mod.user_for_reporting_bottom.checkFieldsofMst( fields, names, messageFrame)) {
		var selFlag = false;
		var bean_id		= formObj.bean_id.value;
		var bean_name	= formObj.bean_name.value;
		var xmlStr ="<root><SEARCH ";
		
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		
		xmlStr +=" /></root>";
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","UserForReportingValidateOrderable.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	//	alert( responseText ) ;
		eval(responseText);
		
		if(!selFlag)
		{
			var msg = getMessage("CLICK_ONE_ORDERABLE","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return false;
		}
		
		if(mode == "2"){

			if(formObj.pract_display){
				qry_string =  "mode=2&pract_id="+formObj.practitioner.value+"&pract_name="+formObj.pract_display.value+"&ord_cat_desc="+formObj.ord_cat_display.value+"&ord_cat="+formObj.order_category.value+"&ord_typ_code_val="+formObj.order_type_display.value+"&order_type="+formObj.order_type.value+"&user_category="+formObj.privilege.value+"&security_level="+formObj.security_level.value+"&order_category="+formObj.order_cat.value
				//alert(qry_string)

			} else if(formObj.resp_display){
				qry_string =  "mode=2&resp_id="+formObj.responsibility.value+"&resp_name="+formObj.resp_display.value+"&ord_cat_desc="+formObj.ord_cat_display.value+"&ord_cat="+formObj.order_category.value+"&ord_typ_code_val="+formObj.order_type.value+"&order_type="+formObj.order_type_display.value+"&user_category="+formObj.privilege.value+"&security_level="+formObj.security_level.value+"&order_category="+formObj.order_cat.value
                //alert(qry_string)
			}
		
		}

		if ((formObj.rist_perform_loc_chk_val.value == "Y") && (formObj.listValues.value == "")) {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("AT_LEAST_ONE_PERFORMING_LOCATION",'OR');
			return false;
		}
		
		eval(formApply( f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting,OR_CONTROLLER));
		//f_query_add_mod.user_for_reporting_top.document.user_for_reporting_top;
		//f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting;

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			//alert("success")
			onSuccess();
		}
	}
}


function reset(){
	//alert("in reset()");
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
//alert("url="+url);
	if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		return ;
	if(f_query_add_mod.user_for_reporting_top){
		//alert("1111");
		if( f_query_add_mod.user_for_reporting_top.document.user_for_reporting_top){
			//alert("2222222");
			 f_query_add_mod.user_for_reporting_top.document.user_for_reporting_top.reset();
			 f_query_add_mod.user_for_reporting_bottom.location.href='../../eCommon/html/blank.html'
		}/* else if( f_query_add_mod.user_for_reporting_top.document.user_for_reporting_bottom){
			if(f_query_add_mod.user_for_reporting_bottom.document.forms[0].name == "user_for_reporting"){
				 f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting.reset();
				 clearList( "f_query_add_mod.user_for_reporting_bottom.document" )
			}
		}*/
		else{
		//alert("f_query_add_mod.user_for_reporting_bottom.document.forms[0].name="+f_query_add_mod.user_for_reporting_bottom.document.forms[0].name);
			if(f_query_add_mod.user_for_reporting_bottom.document.forms[0].name == "user_for_reporting"){
					//alert("3333333");
					f_query_add_mod.user_for_reporting_bottom.location.reload();
				//	f_query_add_mod.user_for_reporting_bottom.document.forms[0].reset();
		}

		}
	}else{
		//alert("444444");
		f_query_add_mod.document.forms[0].reset();
	}
}


function onSuccess() {
	var mode = f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting.mode.value;
	if( mode == "1" ) {
		formReset();
		f_query_add_mod.location.href = "../../eOR/jsp/UserForReportingAddModify.jsp?mode="+MODE_INSERT;
	}
	if(mode == "2"){

		f_query_add_mod.location.href='../../eOR/jsp/UserForReportingAddModify.jsp?'+qry_string ;
	}

}


function formReset () {
		//alert("in formReset()");
    formObj = f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting;
	if(objVal =="practioner"){
		formObj.practitioner.value		= "";
	}else if(objVal =="responsibility"){
		formObj.responsibility.value	= "";
	}
	formObj.order_category.value	= "";
	formObj.order_type.value		= "";
	formObj.privilege.value			= "";
	formObj.security_level.value	= "";
	formObj.mode.value				= "";

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}


function populateOrderTyoes(ord_cat){

	if( ord_cat.value == "" ) {
		clearList("document")
	}
	var bean_id = document.user_for_reporting.bean_id.value ;
	var localeName=document.user_for_reporting.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserForReportingValidate.jsp?bean_id=" + bean_id + "&validate=ord_cat"+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.user_for_reporting.order_type.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".user_for_reporting.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".user_for_reporting.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".user_for_reporting.order_type.add(opt)") ;
}



function clearL2List( docObj ) {
	var len = eval(docObj+".user_for_reporting.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".user_for_reporting.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".user_for_reporting.order_type.add(opt)") ;

	tp = "All" ;
	opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".user_for_reporting.order_type.add(opt)") ;
}

function allowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=49 ) && ( key<58 ) ) ) {
       return false;
   }
}




function checkPositiveNumber(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			return false;
		}
   }
}

/************************************************************************/
async function show_practtioner_window(target){

/*var argumentArray  = new Array() ;
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


retVal = await CommonLookup( "", argumentArray );
var str =unescape(retVal);
var arr = str.split(",");
if(retVal != null && retVal != ""){
	target.value = arr[1];
	parent.frames[1].document.user_for_reporting.practitioner.value=arr[0];
	parent.frames[1].document.user_for_reporting.practitioner_desc.focus();
}
*/
    var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";

	practName_FName		= target.name;		// object name
	practName_FValue	= target.value;
	practId_FName		= document.user_for_reporting.practitioner.value;
	
	var sql				= user_for_reporting.prac_sql.value;
	var sql2			= user_for_reporting.prac_sql1.value;
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
function PractLookupRetVal(retVal,target)
{
 	if(retVal != null && retVal != "")
		{
			arr=retVal.split("~");
			document.user_for_reporting.practitioner.value=arr[0];
			document.user_for_reporting.practitioner_desc.value = arr[1];
			document.user_for_reporting.practitioner_desc.focus();
 		}
		/*else
		{
			document.user_for_reporting.practitioner.value="";
			document.user_for_reporting.practitioner.focus();
		}*/
 }
function clickCheck(chk) {
	if (chk.checked == true) {
		chk.value = 'Y';
		document.getElementById("rist_perform_loc_chk_val").value = 'Y';
		//document.getElementById("rist_perform_loc_td").innerHTML = "&nbsp;<input type='button' name='Performing_Locations' id='Performing_Locations'  value='Performing Locations' class='BUTTON' onClick='clickButton()'>";
	} else {
		chk.value = 'N';
		document.getElementById("rist_perform_loc_chk_val").value = 'N';
		document.getElementById("finalString").value = "";
		document.getElementById("listValues").value = "";
		//document.getElementById("rist_perform_loc_td").innerHTML = '&nbsp;';
	}
	if (document.getElementById("rist_perform_loc_chk_val").value == 'Y') {
		document.getElementById("rist_perform_loc_td").innerHTML = "<Input type='checkbox' name='rist_perform_loc_chk' id='rist_perform_loc_chk' value='Y' onClick='clickCheck(this)' checked>&nbsp;<input type='button' name='Performing_Locations' id='Performing_Locations'  value='Performing Locations' class='BUTTON' onClick='clickButton()'>";
	} else {
		document.getElementById("rist_perform_loc_td").innerHTML = "<Input type='checkbox' name='rist_perform_loc_chk' id='rist_perform_loc_chk' value='N' onClick='clickCheck(this)'>&nbsp;";
	}
}

async function clickButton() {
	var dialogHeight 	= '65vh';
	var dialogWidth		= '55vw';
	var dialogTop		= '10';
	var dialogLeft		= '157';

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

	var arguments = "";
	var formObjTop = parent.user_for_reporting_top.document.user_for_reporting_top;
//	var formObj = f_query_add_mod.user_for_reporting_bottom.document.user_for_reporting;
	var formObj = document.user_for_reporting;
	var mode = formObj.mode.value;
	
	if (formObj.practitioner != null) {
		var fields = new Array ( formObj.practitioner,formObj.order_category);
		var names = new Array ( getLabel("Common.practitioner.label","Common"),getLabel("Common.OrderCategory.label","Common"));
	} else {
		var fields = new Array ( formObj.responsibility,formObj.order_category);
		var names = new Array ( getLabel("Common.responsibility.label","Common"),getLabel("Common.OrderCategory.label","Common") );
	}

	if(!checkFieldsofMst( fields, names,parent.parent.messageFrame)) {
		return false;
	}else{
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	if (formObj.finalString) {
		finalString =formObj.finalString.value;
		
		arguments = formObj.finalString.value;
        if(finalString != null) {
			if(mode == "1"){
				if (formObjTop.radio_but[0].checked )
					finalString += "&practitioner_id="+formObj.practitioner.value;
				//alert("practitioner_id="+formObj.practitioner.value);
				else if (formObjTop.radio_but[1].checked )
					finalString += "&responsibility="+formObj.responsibility.value;
				//alert("responsibility="+formObj.responsibility.value);}
			}else if(mode == "2"){
				if(formObj.pract_display)
					finalString += "&practitioner_id="+formObj.practitioner.value;
				else if(formObj.resp_display)
					finalString += "&responsibility="+formObj.responsibility.value;}
			finalString += "&order_category=" + formObj.order_category.value;//alert(finalString);
			finalString += "&bean_id="+formObj.bean_id.value;
			finalString += "&bean_name" + formObj.bean_name.value;
			//alert(finalString);
			var retVals = await window.showModalDialog("../../eOR/jsp/UserForReportingFrameset.jsp?finalString="+finalString,arguments,features);
			//alert("retVals   :"+retVals);
			if(retVals != null){ // && retVals != ""
				formObj.listValues.value = retVals;
				formObj.finalString.value = retVals;
			//	alert('formObj.listValues.value1='+formObj.listValues.value);
			}else{
				formObj.listValues.value = formObj.finalString.value;
				//alert('formObj.listValues.value2='+formObj.listValues.value);
			}
		}
	}
}

function populatePerformingLocns(obj){

	if( obj.value == "" || document.list_dtl.order_category.value) {
		clearPerformingLocnList("document")
	}
	var bean_id = document.list_dtl.bean_id.value ;
	var localeName= document.list_dtl.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += document.list_dtl.order_category.name + "=\""+ document.list_dtl.order_category.value + "\" ";
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserForReportingValidate.jsp?bean_id=" + bean_id + "&validate=performing_locn"+"&localName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}

function addPerformingLocnList(code,value) {
	var element = parent.list_bottom.document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.list_bottom.document.list_dtl.performing_locn.add(element);
}

function clearPerformingLocnList( docObj ) {
	var len = eval(docObj+".list_dtl.performing_locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".list_dtl.performing_locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".list_dtl.performing_locn.add(opt)") ;
}

function chkMandatory() {
	var formObj = document.list_dtl;
	if (!checkField(formObj.performing_facility,"Performing Facility")) {
		return false;
	} else if (!checkField(formObj.performing_locn,"Performing Location")) {
		return false;
	} else {
		var finalString = "";
		dontChk = document.list_dtl.dontChk.value ;
		if(parent.list_top.facility_id_arr.length>0){
			for(count=0; count<parent.list_top.facility_id_arr.length; count++){
				count = parseInt(count);
				dontChk = parseInt(dontChk)
				if(count != dontChk){
					if(parent.list_top.facility_id_arr[count] == document.list_dtl.performing_facility.value &&
					parent.list_top.location_id_arr[count] == document.list_dtl.performing_locn.value){
						alert(getMessage("DUPLICATE_PERFORMING_LOCATION","OR"));
						document.list_dtl.performing_facility.value= "";
						clearPerformingLocnList("document");
						parent.list_bottom.list_dtl.dontChk.value = '';
						document.list_dtl.performing_facility.focus();
						return false;
					}
				}
			}
		}
		for (count = 0;count<parent.list_top.facility_id_arr.length;count++) {
			count = parseInt(count);
			dontChk = parseInt(dontChk)
			if(count != dontChk){
				finalString += parent.list_top.facility_id_arr[count] + "~" + parent.list_top.facility_name_arr[count]+"~";
				finalString += parent.list_top.location_id_arr[count] + "~" + parent.list_top.location_name_arr[count]+"`";
			}
		}
		finalString += document.list_dtl.performing_facility.value + "~" + eval("document.list_dtl.facility_name"+document.list_dtl.performing_facility.value).value+"~";
		finalString += document.list_dtl.performing_locn.value + "~" + eval("document.list_dtl.location_name"+document.list_dtl.performing_locn.value).value;

		document.list_dtl.performing_facility.value = "";
		clearPerformingLocnList("document");
		document.list_dtl.finalString.value = finalString;

		parent.list_top.document.location.href="../jsp/UserForReportingFrameTop.jsp?finalString="+
		encodeURIComponent(finalString)+"&order_category="+document.list_dtl.order_category.value+"&bean_id="+document.list_dtl.bean_id.value;


	}
}

function changeLocnName(obj) {
	var count = obj.value;
	parent.list_dtl.location_name.value = eval("parent.list_dtl.location_name"+obj.value).value;
}

function onLoadDef(){//Fill the Array's  when the  Category is Laboratory

}

function populateVals(val,finalString,obj,k){
	parent.list_bottom.list_dtl.performing_facility.value = parent.list_top.facility_id_arr[k];
	parent.list_bottom.list_dtl.dontChk.value = k;

	var bean_id = document.list_top.bean_id.value ;
	var localeName= document.list_top.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += document.list_top.order_category.name + "=\""+ document.list_top.order_category.value + "\" ";
	xmlStr += "performing_facility=\""+ facility_id_arr[k] +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserForReportingValidate.jsp?bean_id=" + bean_id + "&validate=performing_locn"+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	parent.list_bottom.list_dtl.performing_locn.value = location_id_arr[k];
}

function closeWindow(){
	var finalString = "";
	/*if(parent.list_top.facility_id_arr.length>0){
		for (count = 0;count<parent.list_top.facility_id_arr.length;count++) {
			finalString += parent.list_top.facility_id_arr[count] + "~" + parent.list_top.facility_name_arr[count]+"~";
			finalString += parent.list_top.location_id_arr[count] + "~" + parent.list_top.location_name_arr[count]+"`";
		}
	}
	document.list_dtl.finalString.value = finalString;*/
	//alert(window.dialogArguments);
	document.list_dtl.finalString.value = window.dialogArguments;
	window.returnValue = document.list_dtl.finalString.value
	window.close();
}

function takeValues(){
	var finalString = "";
	if(parent.list_top.facility_id_arr.length>0){
		for (count = 0;count<parent.list_top.facility_id_arr.length;count++) {
			finalString += parent.list_top.facility_id_arr[count] + "~" + parent.list_top.facility_name_arr[count]+"~";
			finalString += parent.list_top.location_id_arr[count] + "~" + parent.list_top.location_name_arr[count]+"`";
		}
	}
	document.list_dtl.finalString.value = finalString;
	window.returnValue = document.list_dtl.finalString.value;
	window.close();
}

function removeValues(){

var tmp_facility_id_arr		= new Array();
var tmp_facility_name_arr	= new Array();
var tmp_location_id_arr		= new Array();
var tmp_location_name_arr	= new Array();

var count = 0;

	if(document.list_dtl.performing_facility.value == "" ){
		alert(getMessage('SELECT_TO_CLEAR','OR'));
		return false;
	}

	dontChk = document.list_dtl.dontChk.value ;
	for(i=0; i<parent.list_top.facility_id_arr.length; i++){
		//alert(dontChk)
		if( (dontChk == "") || (i != dontChk)){
			//alert('comes here'+i)
			tmp_facility_id_arr[count] =  parent.list_top.facility_id_arr[i]
			tmp_facility_name_arr[count] =  parent.list_top.facility_name_arr[i]
			tmp_location_id_arr[count] =  parent.list_top.location_id_arr[i]
			tmp_location_name_arr[count] =  parent.list_top.location_name_arr[i]
			count++;
		}
	}
	parent.list_top.facility_id_arr		= tmp_facility_id_arr;
	parent.list_top.facility_name_arr	= tmp_facility_name_arr;
	parent.list_top.location_id_arr		= tmp_location_id_arr;
	parent.list_top.location_name_arr	= tmp_location_name_arr;

//	alert(desc_arr + " == " +seq_arr)
	var finalString = "";
	if(parent.list_top.facility_id_arr.length>0){
		for(count=0; count<parent.list_top.facility_id_arr.length; count++){
			finalString += parent.list_top.facility_id_arr[count]+"~"+parent.list_top.facility_name_arr[count]+"~"+parent.list_top.location_id_arr[count]+"~"+parent.list_top.location_name_arr[count]+"`"
			//+"~"+parent.list_top.position_arr[count]+"`"
		}
	}

	document.list_dtl.finalString.value = finalString;

	parent.list_top.document.location.href="../../eOR/jsp/UserForReportingFrameTop.jsp?finalString="+
	finalString+"&order_category="+document.list_dtl.order_category.value+"&bean_id="+document.list_dtl.bean_id.value;

	document.list_dtl.performing_facility.value = "";
	clearPerformingLocnList("document");
}

/***************************************************************************************/
/***************************************************************************************/
async function Orderable(){
	
			var dialogHeight ='70vh' 
			var dialogWidth = '70vw' ;
			var dialogTop	= '10';
			var dialogLeft = '30';

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";

		var ord_category_text=document.user_for_reporting.order_category[document.user_for_reporting.order_category.selectedIndex].text;
		var ord_category_value=document.user_for_reporting.order_category.value

		var ord_type_value=document.user_for_reporting.order_type.value
		var ord_type_text=document.user_for_reporting.order_type[document.user_for_reporting.order_type.selectedIndex].text;
				
		var function_id	= document.user_for_reporting.function_id.value;
		var mode = document.user_for_reporting.mode.value;
		
 
			if(ord_category_value==""){
			message=getMessage( "ORDER_CATEGORY","OR");
			alert(message);
			}else
			var retVals =await top.window.showModalDialog("../../eOR/jsp/UserForReportingFrame.jsp?ord_category_text="+ord_category_text+"&ord_category_value="+ord_category_value+"&ord_type_value="+ord_type_value+"&ord_type_text="+encodeURIComponent(ord_type_text)+"&function_id="+function_id+"&mode="+mode,arguments,features);

		/*	if(retVals!=null){
			
				document.user_for_reporting.ord_type_text.value=retVals[0];	
				document.user_for_reporting.ord_type_value.value=retVals[1];			
				document.user_for_reporting.ord_cat_text.value=retVals[2];			
				document.user_for_reporting.ord_cat_value.value=retVals[3];
				document.user_for_reporting.catalog_desc.value=retVals[4];

			
				
			}	*/
}

/***************************************************************************************/
async function orderableModify(){

			var dialogHeight ='65vh' 
			var dialogWidth = '55vw' ;
			var dialogTop	= '10';
			var dialogLeft = '30';

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";

		var ord_category_text=document.user_for_reporting.ord_cat_display.value;
		var ord_category_value=document.user_for_reporting.order_category.value;

		var ord_type_value=document.user_for_reporting.order_type.value;
		var ord_type_text=document.user_for_reporting.order_type_display.value;
	
		var function_id	= document.user_for_reporting.function_id.value;
		var mode = document.user_for_reporting.mode.value;

		
		
	
			var retVals = await window.showModalDialog("../../eOR/jsp/UserForReportingFrame.jsp?ord_category_text="+ord_category_text+"&ord_category_value="+ord_category_value+"&ord_type_value="+ord_type_value+"&ord_type_text="+encodeURIComponent(ord_type_text)+"&function_id="+function_id+"&mode="+mode,arguments,features);

			if(retVals!=null){
			
				document.user_for_reporting.ord_type_text.value=retVals[0];	
				document.user_for_reporting.ord_type_value.value=retVals[1];			
				document.user_for_reporting.ord_cat_text.value=retVals[2];			
				document.user_for_reporting.ord_cat_value.value=retVals[3];
				document.user_for_reporting.catalog_desc.value=retVals[4];

								
			}


}

/**********************Check for Valid Operation***************************/
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
/********Called to clear MultiRecordBean on Change of the Order Type**********/  
function ClearBean()
{

	var ord_type=document.user_for_reporting.order_type
	var ord_type_text=document.user_for_reporting.order_type[document.user_for_reporting.order_type.selectedIndex].text;

	var bean_id = document.user_for_reporting.bean_id.value ;
	var localeName= document.user_for_reporting.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_type.name +"=\""+ ord_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserForReportingOrderableValidate.jsp?bean_id=" + bean_id+"&validate=ord_type"+"&localeName="+localeName , false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
//	alert(responseText);

}

/*********************************************************************************/

/*function show_practtioner_window()	{

	var formObj = document.user_for_reporting;

			var retVal = 	""; //new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var search_code="";
			var search_desc="";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;

			var tit="Practitioner"
			var sql="SELECT practitioner_id,practitioner_name FROM am_practitioner";
			search_code="practitioner_id";
			search_desc= "practitioner_name";

			retVal = 	window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);


			if (!(retVal == null)) {
				var vals=retVal.split("/")	;
				parent.frames[1].document.user_for_reporting.practitioner.value=unescape(vals[0]);
			}
			parent.frames[1].document.user_for_reporting.practitioner.focus();
}

  */

