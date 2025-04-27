/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/SterilizationFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/SterilizationCostQueryCriteria.jsp?function_id="+function_id;
}

function apply() {
	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
   var errorPage	=	"../../eCommon/jsp/error.jsp";
  
   if(f_query_add_mod.SterilizationHeader.document.sterilization_header.group_desc.disabled==true)
   {
	var frmObj	= f_query_add_mod.location.href.indexOf(".jsp");
	
		var canProcess = false;
		var formObject = f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost ;
		var total_checkboxes = formObject.count.value;
	
	if( f_query_add_mod.SterilizationHeader.document.sterilization_header.select_val.value==0 &&	  f_query_add_mod.SterilizationHeader.document.sterilization_header.delete_val.value==0){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('ATLEAST_ONE_SELECTED','SS');	 
			return;
	}else		{
		var formObj		=	 f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost ;
		var formarray = new Array ( f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost );
	   	var fields=new Array();
		var blankObject	=	null;
		var countArr=0;
		var endVal;
		
		if(parseInt(formObj.end.value)>parseInt(formObj.totalRecords.value))
			endVal=formObj.totalRecords.value;
		else
			endVal=formObj.end.value;
	
		fields=countCheckbox(endVal,"parent",formObj.start.value);
	
	

		if(checkFieldsSterilizationCost(fields))
		{
			if( f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.choosen_link.value=="select"){
				if(pageUpdateApplybySterileCost()){
					
						var responseText=formApply( formarray,SS_CONTROLLER) ;
						responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
						eval( responseText) ;

						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
				}
				if( result ) {
					onSuccess();
				}
			
				
			}
		}
		else{
				alertMSG(endVal,"parent",formObj.start.value);
  		    }
	   }
     
    }
	else
	{
		if(f_query_add_mod.SterilizationHeader.document.sterilization_header.group_desc.value=="")
		{
          message=getMessage("GROUP_NOT_BLANK","SS");
		  messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + message;
		}
		else{
         message=getMessage("INVALID_GROUP_CODE","SS");
		 messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + message;
		}
	}
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("sterilizationcostquery")==-1) )
        return true;
    else
        return false;
}
function reset() {


    if(f_query_add_mod.document.query_form!=null){
		f_query_add_mod.document.query_form.reset();
	 }
	 else{
	 	  if(f_query_add_mod.SterilizationHeader.document.sterilization_header.group_desc.disabled==false)
	       {
		     f_query_add_mod.SterilizationHeader.document.sterilization_header.reset();
           }
		   else
		   {
            f_query_add_mod.SterilizationCostAddModify.formSterilizationCost.reset();
		   }
	    }


}

function onSuccess() {

	var formobj= f_query_add_mod.SterilizationCostAddModify.formSterilizationCost;
	temp_jsp="SterilizationCostLoadData.jsp?group_code="+formobj.group_code.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		
		f_query_add_mod.location.href="../../eSS/jsp/SterilizationFrame.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 

}

async function searchCode( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.sterilization_header.locale.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = parent.SterilizationHeader.document.sterilization_header.SQL_SS_GROUP_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
		objDesc.disabled=true;
		parent.SterilizationHeader.document.sterilization_header.group_search.disabled=true;

		temp_jsp="SterilizationCostLoadData.jsp?group_code="+returnedValues[0];

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		
		parent.SterilizationCostAddModify.location.href="../../eSS/jsp/SterilizationCostAddModify.jsp?group_code="+objCode.value+"&mode="+parent.SterilizationHeader.document.sterilization_header.mode.value;
	} 
}

function formFocus(){
	if(parent.SterilizationCostAddModify.document.formSterilizationCost.mode.value==MODE_INSERT)
		parent.SterilizationCostAddModify.document.formSterilizationCost.group_desc.focus();
	else
		parent.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost.focus();
}

function Modify(obj){
	var group_code=obj.cells[0].innerText;
	var sterile_type=obj.cells[2].innerText;
	document.location.href="../../eSS/jsp/SterilizationCostAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&group_code="+group_code+"&sterile_type="+sterile_type;
}


function assignValue(obj){
	if(obj.checked){
		obj.value="Y";
	parent.SterilizationHeader.document.sterilization_header.select_val.value=parseInt(parent.SterilizationHeader.document.sterilization_header.select_val.value)+1;
	}else{
		obj.value="N";
		parent.SterilizationHeader.document.sterilization_header.select_val.value=parseInt(parent.SterilizationHeader.document.sterilization_header.select_val.value)-1;

	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function pageUpdateApplybySterileCost(){
		

	var formObjSterile		=	 f_query_add_mod.SterilizationCostAddModify.formSterilizationCost ;
	var initString = unescape(formObjSterile.initString.value );
	
	var finalString="";
	var fm=parseInt(formObjSterile.start.value);
	var tom=parseInt(formObjSterile.end.value);

	var count=parseInt(formObjSterile.count.value);
	if(count!=tom){
		tom=count;
	} 
	finalString=unescape(formFinalString(fm,tom,"parent","select",formObjSterile.totalRecords.value));
	
	xmlStr=formXMLString(initString,finalString,"bygroup","select");
	var result=formValidation("select",xmlStr,formObjSterile);

	return result;
}

function formFinalString(fm,tom,pos_ref,mode,totalRecords){
	var count_page	=1;
	var finalString	="";
	
	var form_position="SterilizationCostAddModify.formSterilizationCost";

	if(parseInt(tom)>parseInt(totalRecords))
		tom=totalRecords;
	
	if(pos_ref=="parent"){
			var val1_frame	="	 f_query_add_mod."+form_position+".sterile_cost";
			var val2_frame	="	 f_query_add_mod."+form_position+".process";
			var val3_frame	="	 f_query_add_mod."+form_position+".sterile_type";
			var val4_frame	="	 f_query_add_mod."+form_position+".sterile_desc";
			var val5_frame	="	 f_query_add_mod."+form_position+".delete_row";
	}
	else if(pos_ref=="nextprev"){
			var val1_frame	="	parent."+form_position+".sterile_cost";
			var val2_frame	="	parent."+form_position+".process";
			var val3_frame	="	parent."+form_position+".sterile_type";
			var val4_frame	="	parent."+form_position+".sterile_desc";
			var val5_frame	="	parent."+form_position+".delete_row";
	}

	for(var i=fm;i<tom;i++){
	var val1 = eval(val1_frame+i);
	var val2 = eval(val2_frame+i);
	var val3 = eval(val3_frame+i);
	var val4 = eval(val4_frame+i);
	var val5 = eval(val5_frame+i);

	if(count_page==1){
		finalString=val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value;
	}
	else{
		finalString+="~"+val1.value+"|"+val2.value+"|"+val3.value+"|"+val4.value+"|"+val5.value;
	}
	count_page++;
	}
	
	
   	return escape(finalString);
}

function activeLink() {
	formObj=parent.SterilizationCostAddModify.formSterilizationCost;

	if(formObj.start.value != 0 ){
			parent.SterilizationCostAddModify.document.getElementById("prev").style.visibility='visible';
	}
	else{
			parent.SterilizationCostAddModify.document.getElementById("prev").style.visibility='hidden';
	}

	if(  !((parseInt(formObj.start.value) +parseInt(formObj.displaySize.value))>= formObj.totalRecords.value ))
		parent.SterilizationCostAddModify.document.getElementById("next").style.visibility='visible';
	else
		parent.SterilizationCostAddModify.document.getElementById("next").style.visibility='hidden';
}

function goNext(source_mode) {
	formObj=parent.SterilizationCostAddModify.formSterilizationCost;
	start = parseInt( formObj.start.value) +parseInt( formObj.displaySize.value ) ;
	end = parseInt( formObj.end.value )+ parseInt(formObj.displaySize.value ) ;
	commonPrevNext(formObj,"nextprev");
}	

function goPrev(source_mode) {
	formObj=parent.SterilizationCostAddModify.formSterilizationCost;
	start = parseInt( formObj.start.value  )-parseInt(  formObj.displaySize.value)  ;
	end = parseInt( formObj.end.value )- parseInt(formObj.displaySize.value ) ;
	commonPrevNext(formObj,"nextprev");
}	


function formXMLString(initString,finalString,source,mode){
	var init_string=new Array();
	var final_string=new Array();
	
	init_string=initString.split("~");
	final_string=finalString.split("~");
	var xmlStr ="<root><SEARCH ";
	
	for(var i=0;i<final_string.length;i++){
		var sep_init_string=new Array();
		var sep_final_string=new Array();
		sep_init_string=init_string[i].split("|");

		sep_final_string=final_string[i].split("|");
		
			if( ((sep_init_string[1]) == (sep_final_string[1])) && ((sep_init_string[0]) == (sep_final_string[0]))  ){
			
			}
			else{
				
					xmlStr += " SHORT_DESC"+i+"=\""+ checkSplChar((sep_init_string[3])) + "\" ";
					xmlStr += " STERILE_TYPE"+i+"=\""+ (sep_final_string[2]) + "\" ";
					xmlStr += " STERILE_COST"+i+"=\""+ (sep_final_string[0])+"\"";
					xmlStr += " PREV_PROCESS"+i+"=\""+ (sep_init_string[1])+"\"";
					xmlStr += " DELETE_ROW"+i+"=\""+ (sep_final_string[4])+"\"";
					xmlStr += " PROCESS"+i+"=\""+ (sep_final_string[1])+"\"";
					xmlStr += " DBVAL"+i+"=\""+ (sep_init_string[5])+"\"";
			}
	}
	xmlStr +=" /></root>";
	
return xmlStr;
}

function checkSplChar( val ) {
    var result = "" ;
    var ch = "" ;

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    return result ;
}


function formValidation(mode,xmlStr,formObj){
	var temp_jsp="";
	temp_jsp="SterilizationCostValidation.jsp?start="+formObj.start.value+"&end="+formObj.end.value+"&totalRecords="+formObj.totalRecords.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}

function checkFieldsSterilizationCost( fields ) {
	var errors = "" ;
	var  countError=0;
	for( var i=0; i<fields.length; i++ ) {
		if( trimCheck(fields[i].value) )
		{
			fields[i].value = trimString(fields[i].value);
		}
		else{
			++countError;
		}
	}
	if(countError > 0) {
		return false ;
	}
	return true;
}

function makeEnable(obj,target){
	if(obj.value=="Y")
	{
		var txtObj = eval("parent.SterilizationCostAddModify.document.formSterilizationCost."+target);
		txtObj.disabled=false;
		txtObj.value="";
	 }
	else{
		var txtObj = eval("parent.SterilizationCostAddModify.document.formSterilizationCost."+target);
		txtObj.disabled=true;
		txtObj.value="";
	}
}
function countCheckbox(endVal,pos_ref,startVal){
	var countArr=0;
	var fields=new Array();
	for(var rowIndex=startVal;rowIndex<endVal;rowIndex++){
			if(pos_ref=="parent"){
				if(eval(" f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.process"+rowIndex).value=="Y"){
					fields[countArr] = eval(" f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex);
					countArr++;
				}
			}
			else{
					if(eval("parent.SterilizationCostAddModify.document.formSterilizationCost.process"+rowIndex).value=="Y"){
					fields[countArr] = eval("parent.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex);
					countArr++;
				}
			}
	}
	return fields;
}

function alertMSG(endVal,pos_ref,startVal){
	var fields=new Array();
	countArr=0;
		for(var rowIndex=startVal;rowIndex<endVal;rowIndex++)	{
			if(pos_ref=="parent"){	if(eval(" f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.process"+rowIndex).value=="Y"){
					if(eval(" f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex).value==""){
						fields[countArr] = eval(" f_query_add_mod.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex);
						break;
					}
				}
			}
			else{	if(eval("parent.SterilizationCostAddModify.document.formSterilizationCost.process"+rowIndex).value=="Y"){
					if(eval("parent.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex).value==""){
						fields[countArr] = eval("parent.SterilizationCostAddModify.document.formSterilizationCost.sterile_cost"+rowIndex);
						break;
					}
				}
			}
		 }
		message=getMessage("STERILE_COST_NOT_BLANK","SS" );
		fields[countArr].select();
		fields[countArr].focus();

		if(pos_ref=="parent")
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		else
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
}

function commonPrevNext(formObj,post_ref){
	
	var initString = unescape(formObj.initString.value );
	var fields=new Array();
	var endVal;
	if(parseInt(formObj.end.value)>parseInt(formObj.totalRecords.value))
			endVal=formObj.totalRecords.value;
	else
			endVal=formObj.end.value;

			fields=countCheckbox(endVal,post_ref,formObj.start.value);
			
	if(checkFieldsSterilizationCost(fields)){
		finalString=unescape(formFinalString( formObj.start.value,formObj.end.value,"nextprev","select",formObj.totalRecords.value));
		xmlStr=formXMLString(initString,finalString,"bygroup","select");
		formValidation("select",xmlStr,formObj);	

		if(formObj.mode.value==MODE_INSERT)
			modeVal=MODE_INSERT;
		else
			modeVal=MODE_MODIFY;
		
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
		parent.SterilizationCostAddModify.location.href="../../eSS/jsp/SterilizationCostAddModify.jsp?group_code="+formObj.group_code.value+"&mode="+modeVal+"&from="+start+"&to="+end;
	}
	else{
		alertMSG(endVal,post_ref,formObj.start.value);
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("sterilizationcostquery")==-1) )
		return true;
	else
		return false;
}

function assignValue1(obj){
	if(obj.checked){
		obj.value="Y";
	parent.SterilizationHeader.document.sterilization_header.delete_val.value=parseInt(parent.SterilizationHeader.document.sterilization_header.delete_val.value)+1;
	}else{
		obj.value="N";
		parent.SterilizationHeader.document.sterilization_header.delete_val.value=parseInt(parent.SterilizationHeader.document.sterilization_header.delete_val.value)-1;

	}
}

