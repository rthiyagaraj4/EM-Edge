  
var function_id = "" ;
var result1 = false ;
var message = "" ;
var flag = "" ;
var bean_id="";
var bean_name="";
var gloabl_code="";
var gloabl_description="";
var gloabl_infocode="";
var gloabl_infodescription="";
var invalidCode="";

function create() {
f_query_add_mod.location.href="../../ePH/jsp/DrugInformationSourceFrames.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugInformationSourceQueryCriteria.jsp?function_id="+function_id ;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
	f_query_add_mod.location.reload();
	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

function DurationValidate(obj){
	if(obj.value!="" && obj!=null)	{
		if(parseInt(document.dispense_rules.max_durn_for_disp.value)<parseInt(obj.value)){
			var message=getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.value="";
			obj.focus();
			}
			else{
			var message="";
			}
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ((url.indexOf("queryresult.jsp")==-1) &&(url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
			return true;
	else
		return false;
}

function check(objval, objnum)	{

	
	var obj = eval("document.frmdrugsourceresult.info_eff_status"+objnum);
	
	if (trimCheck(objval)){
		obj.checked=true;
		eval("document.frmdrugsourceresult.info_eff_status"+objnum).value = "E";
	}else{
		
		obj.checked=false;
		eval("document.frmdrugsourceresult.info_eff_status"+objnum).value = "D";
	}
}


function resetColorCode(obj)
{	
	
	//alert("obj====>" +obj.value);
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.drug_information_detail.document.frmdrugsourceresult ;
	arrPKFieldNames[0]	=	"info_code";
	arrPKFieldNames[1]	=	"seq_no";
	
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function displayrows(){
	

	var formObj = document.frmdruginformationsourceAddModify ;
	var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);
	var names= new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.DisplaySequence.label","PH"));

	if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) {
		if(formObj.eff_status.checked ==true)
			formObj.eff_status.value = "E" ;
		else
			formObj.eff_status.value = "D" ;
		var code		 = formObj.code.value;
		var description  = formObj.description.value;
		var seq_no		 = formObj.display_sequence_no.value;
		var eff_status	 = formObj.eff_status.value;
		var bean_id = formObj.bean_id.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		
		xmlStr ="<root><SEARCH " ;
		xmlStr += "code=\""+formObj.code.value +"\" " ;
		xmlStr += "seq_no=\""+formObj.display_sequence_no.value + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugInformationSourceValidate.jsp?&bean_id="+bean_id+"&validate=code"  , false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		var code_val	='';
		var seq_val		='';
		
		eval(responseText );
//	alert(responseText);
		if(code_val == 'Y' && seq_val == 'Y'){
				var msg = getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+formObj.code.value+"<br>"+"APP-00124 Duplicate sequence number not allowd: "+formObj.display_sequence_no.value;
				parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			formObj.code.focus();
			return false;

		}else if(code_val == 'Y'){
			var msg = getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+formObj.code.value;
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			formObj.code.focus();
			return false;

		}else if(seq_val == 'Y'){
			var msg = getMessage("DUPLICATE_SEQ_NOT","PH")+formObj.display_sequence_no.value;
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			formObj.display_sequence_no.focus();
			return false;

		}
		parent.drug_information_detail.location.href	="../../ePH/jsp/DrugInformationSourceResult.jsp?mode="+MODE_INSERT+"&code="+code+"&description="+description+"&display_sequence_no="+seq_no+"&eff_status="+eff_status;
		parent.parent.messageFrame.location.href	="../../eCommon/jsp/MstCodeError.jsp";
	}
}

function chkzero(obj,count)
 { 
	 var obj1 = eval("document.frmdrugsourceresult.info_eff_status"+count);

	 if(obj.value =="0" || obj.value=="")
	 {   
		
		if(obj1.checked)
		{ 
		 
			alert(getMessage("SEQ_NOT_BLANK","PH"));
			obj.focus();
		}
	 }else{
		if(!CheckNum(obj)){
			
			
			return false
		}
	 }
// }
 }

function chkzero1(obj)
 { 

	
	 if(obj.value =="0" || obj.value=="")
	 {   
		
		 alert(getMessage("SEQ_NOT_BLANK","PH"));
		 obj.focus();
		
	 }else{
		if(!CheckNum(obj)){
			
			
			
			return false
		}
	 }

 }
 function checkText(obj,count)
 { 
	    //alert("obj====" +obj.value+ "count====>" +count);
	
	 var obj1=eval("document.frmdrugsourceresult.info_code"+count);
	 var obj2=eval("document.frmdrugsourceresult.info_short_desc"+count);
	 var obj3=eval("document.frmdrugsourceresult.seq_no"+count);
	// alert("obj1=====>" +obj1.value);
	 //alert("obj2====>" +obj2.value);
	 if(obj.checked)
		{
			var frmobj=parent.drug_information_detail.document.frmdrugsourceresult;
			/*var message="";
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			var fields		=	new Array	(frmobj.info_code,frmobj.info_short_desc);
		
			var names	    =	new Array	(getLabelgetLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));	
		
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				frmobj.submit();
			}*/
			if(obj1.value==''|| obj1.value==null)
			{
				
				var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		        msg = msg.replace('$', getLabel("Common.code.label","Common"));
		        alert(msg);
				obj.checked=false;
				
			}
			if(obj2.value==''|| obj2.value==null)
			{
				var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		        msg = msg.replace('$', getLabel("Common.description.label","Common"));
		        alert(msg);
				obj.checked=false;
			}
			if(obj3.value==''|| obj3.value==null)
			{
				alert(getMessage("SEQ_NOT_BLANK","PH"));
				obj.checked=false;
			}
		}
 }



/*
function apply(){
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var mode = f_query_add_mod.drug_information_header.document.frmdruginformationsourceAddModify.mode.value;
	

	if(mode == MODE_MODIFY || mode == '2'){
		applymodify();
		return ;
	}
	if( mode == MODE_INSERT ||  mode == '1' ) {
		var formObj = f_query_add_mod.drug_information_header.document.frmdruginformationsourceAddModify ;
		var formObjDetail= f_query_add_mod.drug_information_detail.document.frmdrugsourceresult ;
		
		
		var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);
		var names = new Array ( "Code","Description","DisplaySequence");
		if(checkFieldsofMst( fields, names, messageFrame)) {
			
			gloabl_code = formObj.code.value;
			gloabl_description = formObj.description.value;

			var flag_val=false;	
			if(formObjDetail){
			
			if(formObj.eff_status.checked==true)
				formObjDetail.eff_status.value	= "E";
			else
				formObjDetail.eff_status.value	= "D";

			formObjDetail.code.value = formObj.code.value;
			formObjDetail.description.value = formObj.description.value;
			formObjDetail.display_sequence_no.value =formObj.display_sequence_no.value;
			
			
			for(var i=0;i<10;i++){
				if(eval("formObjDetail.info_eff_status"+i).checked == true && eval("formObjDetail.info_code"+i).value != "" )
					eval("formObjDetail.info_eff_status"+i).value= "E" ;
				else
					eval("formObjDetail.info_eff_status"+i).value= "D" ;

				if(trimCheck(eval("formObjDetail.info_code"+i).value)){
					flag_val= true;
					break;
				}
			}
			if(flag_val == false){
				var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;	
				return false;

			}
			
			var arrFieldName		=	new Array();
			var arrFieldName1		=	new Array();
			var arrLegends			=	new Array();
			var arrLegends1			=	new Array();
			var arrPKFieldNames		=	new Array();
			var arrPKFieldNames1	=	new Array();

			arrFieldName[0]			=	"info_code";
			arrFieldName[1]			=	"info_short_desc";
			arrFieldName1[0]		=	"seq_no";
			
			arrLegends[0]			=	"Code";
			arrLegends[1]			=	"Description";
			arrLegends1[0]			=	"Sequence No";
			
			arrPKFieldNames[0]		=	"info_code";
			arrPKFieldNames1[0]		=	"seq_no";
	
			var	result_chk	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);
			
			if(result_chk){
				result_chk	=	validateMandatoryFields(formObjDetail,arrFieldName1,arrLegends1,arrPKFieldNames1);
				if(!result_chk)
					return false;

				eval(formApply( formObjDetail,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
				if(result_chk) {
					onSuccess();		
				}else if(invalidCode != "" && invalidCode != "null"){
					showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
				}
			}
			}else if(formObjDetail == "undefined" || formObjDetail == undefined ){
				var msg = "Atleast_one_details_record_has_to_be_entered";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;	
				return false;
			}
		}
	}

}
*/

function applymodify(){
	
	var formObj =f_query_add_mod.drug_information_header.document.frmdruginformationsourceAddModify ;
	var formObjDetail =f_query_add_mod.drug_information_detail.document.frmdrugsourceresult  ;
	
	var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);
	var names= new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.DisplaySequence.label","PH"));
	
	var qry_string = "";
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		
		gloabl_code = formObj.code.value;
		gloabl_description = formObj.description.value;

		var temp_seq_no = formObjDetail.display_sequence_no.value;
		formObjDetail.description.value = formObj.description.value;
		
		if(temp_seq_no == formObj.display_sequence_no.value)
			formObjDetail.info_dup_chk.value = 'N'
		else{
			formObjDetail.info_dup_chk.value = 'Y'
			formObjDetail.display_sequence_no.value =formObj.display_sequence_no.value;
		}

		if(formObj.eff_status.checked==true)
		 	formObjDetail.eff_status.value	= "E";
		else
			formObjDetail.eff_status.value	= "D";

		qry_string += "mode=2";
		qry_string += "&code="+formObjDetail.code.value;
		qry_string += "&description="+formObjDetail.description.value;
		qry_string += "&display_sequence_no="+formObjDetail.display_sequence_no.value;
		qry_string += "&eff_status="+formObjDetail.eff_status.value;

		var count = formObjDetail.totalRecords.value;
		
		for(var i=0;i<count;i++){
			if(eval("formObjDetail.info_eff_status"+i).checked == true && eval("formObjDetail.info_code"+i).value != "" )
				eval("formObjDetail.info_eff_status"+i).value= "E" ;
			else
				eval("formObjDetail.info_eff_status"+i).value= "D" ;

		}
		
		var arrFieldName		=	new Array();
		var arrLegends			=	new Array();
		var arrPKFieldNames		=	new Array();
		
		arrFieldName[0]			=	"seq_no";
		arrFieldName[1]			=	"info_short_desc";
		
		arrLegends[0]			=	"Sequence No";
		arrLegends[1]			=	"Description";
		
		arrPKFieldNames[0]		=	"seq_no";

		var	result_chk	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);
		
		if(result_chk){
			eval(formApply( formObjDetail,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if(result1) {
			f_query_add_mod.location.href="../../ePH/jsp/DrugInformationSourceFrames.jsp?"+qry_string;

			
			}else{
				formObj.display_sequence_no.focus();
				formObj.display_sequence_no.select();
				formObjDetail.display_sequence_no.value = temp_seq_no;
			}
		}
	}
}

function onSuccess() {
	create();
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}


function apply(){
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var mode = f_query_add_mod.drug_information_header.document.frmdruginformationsourceAddModify.mode.value;
	

	if(mode == MODE_MODIFY || mode == '2'){
		applymodify();
		return ;
	}
	if( mode == MODE_INSERT ||  mode == '1' ) {
		
		var formObj = f_query_add_mod.drug_information_header.document.frmdruginformationsourceAddModify ;
		var formObjDetail= f_query_add_mod.drug_information_detail.document.frmdrugsourceresult ;
		
		
		var fields = new Array ( formObj.code ,formObj.description,formObj.display_sequence_no);
		var names= new Array (getLabel("Common.code.label","Common"), getLabel("Common.description.label","Common"),getLabel("ePH.DisplaySequence.label","PH"));
		
		if(checkFieldsofMst( fields, names, messageFrame)) {
			
			
			
			gloabl_code = formObj.code.value;
			gloabl_description = formObj.description.value;

			var flag_val=false;	
			if(formObjDetail){
			
			if(formObj.eff_status.checked==true)
				formObjDetail.eff_status.value	= "E";
			else
				formObjDetail.eff_status.value	= "D";
			
			formObjDetail.code.value = formObj.code.value;
			formObjDetail.description.value = formObj.description.value;
			formObjDetail.display_sequence_no.value =formObj.display_sequence_no.value;
			/**************/
			var bean_id = formObj.bean_id.value ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			
			xmlStr ="<root><SEARCH " ;
			xmlStr += "code=\""+formObj.code.value +"\" " ;
			xmlStr += "seq_no=\""+formObj.display_sequence_no.value + "\" ";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DrugInformationSourceValidate.jsp?&bean_id="+bean_id+"&validate=code"  , false ) ;

			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			var code_val	='';
			var seq_val		='';
//			alert(responseText);
			eval(responseText );
		
			if(code_val == 'Y' && seq_val == 'Y'){
				var msg = getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+formObj.code.value+"<br>"+"APP-00124 Duplicate sequence number not allowd: "+formObj.display_sequence_no.value;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				formObj.code.focus();
				return false;

			}else if(code_val == 'Y'){
				var msg = getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+formObj.code.value;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				formObj.code.focus();
				return false;

			}else if(seq_val == 'Y'){
				var msg =getMessage("DUPLICATE_SEQ_NOT","PH")+formObj.display_sequence_no.value;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				formObj.display_sequence_no.focus();
				return false;

			}
			/*************/
			for(var i=0;i<10;i++){
				if(eval("formObjDetail.info_eff_status"+i).checked == true && eval("formObjDetail.info_code"+i).value != "" )
					eval("formObjDetail.info_eff_status"+i).value= "E" ;
				else
					eval("formObjDetail.info_eff_status"+i).value= "D" ;

				if(trimCheck(eval("formObjDetail.info_code"+i).value)){
					flag_val= true;
					break;
				}
			}
			if(flag_val == false){
				var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;	
				return false;

			}
			
			var arrFieldName		=	new Array();
			var arrFieldName1		=	new Array();
			var arrLegends			=	new Array();
			var arrLegends1			=	new Array();
			var arrPKFieldNames		=	new Array();
			var arrPKFieldNames1	=	new Array();

			arrFieldName[0]			=	"info_code";
			arrFieldName[1]			=	"info_short_desc";
			arrFieldName1[0]		=	"seq_no";
			
			arrLegends[0]			=	"Code";
			arrLegends[1]			=	"Description";
			arrLegends1[0]			=	"Sequence No";
			
			arrPKFieldNames[0]		=	"info_code";
			arrPKFieldNames1[0]		=	"seq_no";
	
			var	result_chk	=	validateMandatoryFields(formObjDetail,arrFieldName,arrLegends,arrPKFieldNames);
			
			if(result_chk){
				result_chk	=	validateMandatoryFields(formObjDetail,arrFieldName1,arrLegends1,arrPKFieldNames1);
				if(!result_chk)
					return false;

				eval(formApply( formObjDetail,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
				if(result_chk) {
					onSuccess();		
				}else if(invalidCode != "" && invalidCode != "null"){
					showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
				}
			}
			}else if(formObjDetail == "undefined" || formObjDetail == undefined ){
				var msg = getMessage("ONE_RECORD_SELECT","PH");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;	
				return false;
			}
		}
	}

}  
