var message = "" ;
var result = false ;
var flag="";
var mode="";
function create() 
	{
		
		f_query_add_mod.location.href	=	"../../ePH/jsp/SlidingScaleTmplFrame.jsp?mode="+MODE_INSERT;
	}
function query() 
	{
     
	 f_query_add_mod.location.href	=	"../../ePH/jsp/SlidingScaleTmplQueryCriteria.jsp?mode="+MODE_MODIFY;
	}
//To reset the form
	function reset(){
		
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if(url.indexOf("slidingscaletmplquerycriteria")!=-1)
			 //f_query_add_mod.location.reload();
			 f_query_add_mod.location.href	=	"../../ePH/jsp/SlidingScaleTmplQueryCriteria.jsp?mode="+MODE_MODIFY;
		else if(url.indexOf("slidingscaletmplframe")!=-1){
			
			if(f_query_add_mod.f_sliding_scale_temp.document.SlidingScaleTmplDetails.mode.value == MODE_INSERT){
			 f_query_add_mod.location.href		=	"../../ePH/jsp/SlidingScaleTmplFrame.jsp?mode="+MODE_INSERT;
			}else{
				f_query_add_mod.location.reload(); //for modification mode
			}
		}else{}
	
}
//To apply the changes  in to Database
function apply() {
	var result1=false;
	var errorPage = "../../eCommon/jsp/error.jsp";
	var msg=getMessage("CANNOT_PROCEED","ph");

	if (!checkIsValidForProceed()) 
			{
				
				
	     		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
				result1= false ;
		} 
	else if(f_query_add_mod.f_sliding_scale_temp == undefined){
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
	result1= false;
	}
	else if (f_query_add_mod.f_sliding_scale_temp.document.SlidingScaleTmplDetails == null) {
       messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ msg;
		result1= false;
	}else{
	
	var formObj = f_query_add_mod.f_sliding_scale_temp.document.forms[0];
	
	var arrayObject = new Array(formObj.template_id, formObj.templateDesc,formObj.rangeUOM_desc,formObj.adminUnitUOM_desc);
	var names = new Array(getLabel("Common.TemplateID.label","Common"), getLabel("Common.description.label", "Common"),getLabel("ePH.RangeUOM.label", "PH"),getLabel("ePH.AdminUnitsUOM.label", "PH"));
	
    
	if (f_query_add_mod.checkFields(arrayObject,names,messageFrame)) {
	
		var formObj1 = f_query_add_mod.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails;
		
		var canProcess = formObj1.records.value;
		
		if (parseInt(canProcess) == 0) {
			 message=getMessage("ATLEAST_ONE_RECORD_ENTERED_IN_RANGE_DETAILS","ph");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" +message //getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
			result1= false;
		} else {
			var responseText = formApply(formObj, PH_CONTROLLER);
			eval(responseText);
			 messageFrame.location.href = errorPage + "?err_num=" + message;
			if (result) {
				onSuccess();
				result1=true;
			}
		}
		
	}else{
		result1= false;
	}
	}
return result1;
}
//Check for special char
function specialChar(formObj)
	{
		if(!CheckChars(formObj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		formObj.value = '';
		formObj.focus();
		return false;
	}
	}



function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) ) //insert mode
				return true;
		else
				return false;
}	
	
function assignResult( _result, _message, _flag )
	{
		result		 = _result ;
		message		 = _message ;
		flag		 = _flag ;
		
	}

function reset1() {
	f_query_add_mod.location.reload();
}
function onSuccess() {
    
	f_query_add_mod.location.href = "../../ePH/jsp/SlidingScaleTmplFrame.jsp?mode="+MODE_INSERT;;
}
//For rande cancel button
function cancel(formObj){
   var obj= document.formSlidingScaleTmplRange; 
   obj.reset();
	obj.index.value=-1;
   obj.adminUnits.value="";
   obj.fromUOM.value="";
   obj.toUOM.value="";
   obj.informPractitioner.value="N";
   obj.remarks.value="";

   parent.f_temp_range.location.href = "../../ePH/jsp/SlidingScaleTmplRange.jsp?mode=" + MODE_INSERT +"&informPractitioner=N&focusflag=focusflag"
   //obj.fromUOM.focus();
   
}
//To reflect The UOM Changes in page
function changeUnit() {
	 var obj= parent.f_sliding_scale_temp.document.SlidingScaleTmplDetails;
     var obj2= parent.f_temp_range.document.formSlidingScaleTmplRange;
     // var obj3= parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails;
	 if(obj != null){
	 var rangeunit		=	obj.rangeUOM_desc.value;
	 var adminunit		=	obj.adminUnitUOM_desc.value;
	 var mode=obj.mode.value;
	 
	 if(obj2 !=null){

		parent.f_temp_range.document.getElementById('range_unit_from').innerText=" "+rangeunit;
		parent.f_temp_range.document.getElementById('range_unit_to').innerText=" "+rangeunit;
		parent.f_temp_range.document.getElementById('admin_unit').innerText=" "+adminunit;
		/*if(obj3 !=null){
			parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails.rangeUnite.innerText="( "+rangeunit+" )";
		    parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails.rangeUnite.innerText="( "+rangeunit+" )";
		    parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails.adminUnit.innerText="( "+adminunit+" )";

		}*/
		
		if(mode!=1){
		//parent.f_temp_range.document.formSlidingScaleTmplRange.fromUOM.focus();
		}
	 }
      
	 }
}
//For check box of sliding Scale details
function assignValue(obj) {
	if (obj.checked == true) {
		obj.value = "E";
		
	} else {
		obj.value = "D";
		
	}
	document.SlidingScaleTmplDetails.eff_statusTemp.value = obj.value;
}
//For check box of sliding Scale Range 
function assignInfoPractitioner(obj) {
	if (obj.checked == true) {
		obj.value = "Y";	
	} else {
		obj.value = "N";	
	}
	
	
}

//For check box of range details list
function assignValueTobean(obj,index) {
	if (obj.checked == true) {
		obj.value = "E";
	} else {
		obj.value = "D";
	}
	var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		
        var  xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../ePH/jsp/SlidingScaleTmplValidate.jsp?validate=UPDATE_STATUS&index="+index+"&eff_status="+obj.value, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		eval(responseText);
		return result;
		
}
function EnableDisableUOM(){
	//alert("EnableDisableUOM");
	    var formObj1 = parent.f_sliding_scale_temp.document.SlidingScaleTmplDetails;
		var formObj = parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails;
		var noOfRow = formObj.records.value;

		var arrayObject = new Array(formObj1.rangeUOM_desc,formObj1.adminUnitUOM_desc);
		var names = new Array(getLabel("ePH.RangeUOM.label", "PH"),getLabel("ePH.AdminUnitsUOM.label", "PH"));
		var blankObject = checkFields(arrayObject, names, parent.parent.messageFrame);
		//alert(blankObject+"----noOfRow---->"+noOfRow);
		if (blankObject) {
          //alert("inside if");
			if(noOfRow > 0){
				formObj1.rangeUOM_desc.disabled=true;
				formObj1.adminUnitUOM_desc.disabled=true;

			}else{
				formObj1.rangeUOM_desc.disabled=false;
				formObj1.adminUnitUOM_desc.disabled=false;
			}

		}else{
          //alert("inside else");
         return false;
		}
		return true;
}
//To add in range details list.
function addToRangeDetails(obj,formObj1){
    var formObj1 = parent.f_sliding_scale_temp.document.SlidingScaleTmplDetails;
     var formObj = parent.f_temp_range.document.formSlidingScaleTmplRange;
	
    
	var arrayObject = new Array(formObj.fromUOM,  formObj.adminUnits);
	var names = new Array(getLabel("ePH.FROMRANGE.label", "Ph"), getLabel("ePH.ADMINVALUE.label", "ph"));
	var formObjDtl = parent.f_temp_range_detail.document.formSlidingScaleTmplRangeDetails;
	
   //For inform Practitioner
   var infoPractitioner=formObj.informPractitioner.value;
    var adminUnit  = formObj.adminUnits.value; //For checking null

	var rangeUom=formObj1.rangeUOM_desc.value;
		
	var adminUnitUOM=formObj1.adminUnitUOM_desc.value;
	var remarks=formObj.remarks.value

		var  rangeUOM_desc				=	encodeURIComponent(rangeUom,"UTF-8");
		var  adminUnitUOM_desc			=	encodeURIComponent(adminUnitUOM,"UTF-8");
		remarks			=	encodeURIComponent(remarks,"UTF-8");
    if(formObj.informPractitioner.value== "Y" && adminUnit==""){
			adminUnit="0";
			arrayObject = new Array(formObj.fromUOM);
			names = new Array(getLabel("ePH.FROMRANGE.label", "Ph"));
	}
    
	var blankObject = checkFields(arrayObject, names, parent.parent.messageFrame);
	if (blankObject){
		 if(compareToAndFormValue()){
             
			  var touom  = formObj.toUOM.value; //For checking null
         if(formObj.toUOM.value=="")
				touom="0";
			  
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var  xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
     /* parent.f_temp_range.location.href = "../../ePH/jsp/SlidingScaleTmplValidate.jsp?validate=ADD_TO_LIST&"+"from_uom="+formObj.fromUOM.value+"&to_uom="+touom+"&admin_units="+adminUnit+"&eff_status=E"+"&index="+formObj.index.value+"&db_action="+formObj.db_action.value+"&informPractitioner="+formObj.informPractitioner.value+"&remarks="+formObj.remarks.value
			+"&adminUnitUOM_desc="+formObj1.adminUnitUOM_desc.value+"&rangeUOM_desc="+formObj1.rangeUOM_desc.value;
		*/	
        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open("POST", "../../ePH/jsp/SlidingScaleTmplValidate.jsp?validate=ADD_TO_LIST&"+"from_uom="+formObj.fromUOM.value+"&to_uom="+touom+"&admin_units="+adminUnit+"&eff_status=E"+"&index="+formObj.index.value+"&db_action="+formObj.db_action.value+"&informPractitioner="+formObj.informPractitioner.value+"&remarks="+remarks
			+"&adminUnitUOM_desc="+adminUnitUOM_desc+"&rangeUOM_desc="+rangeUOM_desc, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		eval(responseText);
		if (result) {
			
			 var obj= document.formSlidingScaleTmplRange;
            obj.reset();
            obj.adminUnits.value="";
            obj.fromUOM.value="";
            obj.toUOM.value="";
			obj.informPractitioner.value="N";
			obj.remarks.value="";
			obj.index.value="-1";
			
			parent.f_temp_range_detail.location.href = "../../ePH/jsp/SlidingScaleTmplRangeDetails.jsp?mode=" + MODE_INSERT+"&adminUnitUOM_desc="+adminUnitUOM_desc+"&rangeUOM_desc="+rangeUOM_desc;	
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			parent.f_temp_range.location.href = "../../ePH/jsp/SlidingScaleTmplRange.jsp?mode=" + MODE_INSERT +"&informPractitioner=N&focusflag=focusflag"
          	//parent.f_temp_range.document.formSlidingScaleTmplRange.fromUOM.focus();
			//formObj1.template_id.disabled=true;
			//formObj1.templateDesc.disabled=true;
			formObj1.rangeUOM_desc.disabled=true;
			formObj1.adminUnitUOM_desc.disabled=true;
			//alert(parent.f_temp_range.document.formSlidingScaleTmplRange.fromUOM.value);

		}
		if (!result) {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage(message, "PH");
			//obj.fromUOM.focus();

		}

	}else{
     return false;
	}
	}else{
		return false;
	}
	
}

function test(obj,mode){
	if(obj.value=="OK"){
	var obj= document.formSlidingScaleTmplRange;
	obj.fromUOM.focus();
	return ;
	}
}
//To midify  range Details
function ModifyData(index, obj, from_uom,to_uom,admin_units,informPractitioner,remarks) {
	var from_uom = obj.cells[1].innerText;
	var admin_units = obj.cells[3].innerText;
	var remarks		= obj.cells[5].innerText;
	var eff_status = obj.cells[6].innerText;
	
   parent.f_temp_range.location.href = "../../ePH/jsp/SlidingScaleTmplRange.jsp?mode=" + MODE_MODIFY+ "&function_id=" + parent.parent.function_id +"&from_uom="+from_uom+"&to_uom="+to_uom+"&admin_units="+admin_units+"&eff_status=D"+"&index="+index+"&db_action="+"&remarks="+remarks+"&informPractitioner="+informPractitioner+"&focusflag=focusflag";
}

//TO modify the entair row or Query result page
function ModifyRow(obj) {
		
		var template_id					=	obj.cells[0].innerText;
		var templateDesc		        =	obj.cells[1].innerText;
		var rangeUom					=	obj.cells[2].innerText;
		var adminUnitUOM				=	obj.cells[3].innerText;
		var eff_statusTemp				=	obj.cells[4].textContent;
		
		var  rangeUOM_desc				=	encodeURIComponent(rangeUom,"UTF-8");
		var  adminUnitUOM_desc			=	encodeURIComponent(adminUnitUOM,"UTF-8");	
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/SlidingScaleTmplFrame.jsp?mode="+MODE_MODIFY+"&function_id=" + parent.parent.function_id+"&template_id="+template_id+"&templateDesc="+templateDesc+"&rangeUOM_desc="+rangeUOM_desc+"&adminUnitUOM_desc="+adminUnitUOM_desc+"&eff_statusTemp="+eff_statusTemp;

}
//for to and form value comparisation of range 
function compareToAndFormValue(){
	
  var formObj    = parent.f_temp_range.document.formSlidingScaleTmplRange;
   var from_uom  = formObj.toUOM.value;
	var to_uom   = formObj.fromUOM.value;
	var value    = false;
	
   if(from_uom != "" && to_uom != "" ){
	   
	 var toRange=parseFloat(formObj.toUOM.value)
	 var formRange=parseFloat(formObj.fromUOM.value)

   if(  toRange >0 && formRange > toRange){
	   /************/   //To Display Message to should be gratter then form range
	   var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
            var name=getLabel("Common.Range.label","Common");
			var rangeto=getLabel("Common.to.label","Common")+" "+name;
			error=error.replace("$",rangeto);
			error=error.replace("#",name);
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
	   /************/
	  //parent.parent.messageFrame.location.href  = "../../eCommon/jsp/error.jsp?err_num= "+getMessage("TO_UOM_MUST_GRT_THAN_FROM_FROMUOM",'PH');
       formObj.toUOM.select();
	   formObj.toUOM.focus();
	   value= false
   }
   else{
	   parent.parent.messageFrame.location.href  = "../../eCommon/jsp/error.jsp?err_num= ";
	   value= true;
   }
	 }else{
       parent.parent.messageFrame.location.href  = "../../eCommon/jsp/error.jsp?err_num= ";
	   value=true;
   }
   return value;
 }
 
//function copy from O:\eHIS\web\eSS/jsSsCommon.js(174,10):function checkDoubleFormat(fld, e, maxInt, deci)
function checkDoubleFormat(obj){
    if(!isValidDoubleFormat(obj)){
        alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
		    obj.value="";
        obj.focus();
        return false;
    }
}
//"O:\eHIS\web\eSS/jsSsCommon.js"(461,10):function checkDoubleFormat(obj)
function isValidDoubleFormat(Obj){
	var str = Obj.value;
	var validDoubleExists = true;
	var totalDecimal	=	0;
	for (u=0;u<str.length;u++){
		if (str.charCodeAt(u)==46) {
			totalDecimal++;
			if(totalDecimal>1){
				validDoubleExists  = false;
				break;
			}
		}
		if (!(((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||(str.charCodeAt(u)==46))){
			validDoubleExists  = false;
			break;
		}
	
		
		}
		
		return validDoubleExists ;
}
//
function loadTemplateDetail(template_id,rangeUom,adminUom){
	
		var encounter_id = document.prescription_sliding_scale_remarks.encounter_id.value;
		var patient_id = document.prescription_sliding_scale_remarks.patient_id.value;
		var drug_code = document.prescription_sliding_scale_remarks.drug_code.value;
	    var srl_no    = document.prescription_sliding_scale_remarks.srl_no.value;//Added for ARYU-SCF-0053
		var rangeUom = encodeURIComponent(rangeUom,"UTF-8");
		parent.f_sliding_scale_dtls.location.href="../../ePH/jsp/PrescriptionSlidingScaleTmplDtl.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&template_id="+template_id+"&rangeUom="+rangeUom+"&adminUom="+adminUom+"&drug_code="+drug_code+"&srl_no="+srl_no;// srl_no Added for ARYU-SCF-0053
	
}

function loadTemplateDetailChange(template_id,rangeUom,adminUom,i,mode){
if(confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"))){
	var encounter_id = document.prescription_sliding_scale_remarks.encounter_id.value;
	var patient_id = document.prescription_sliding_scale_remarks.patient_id.value;
	var drug_code = document.prescription_sliding_scale_remarks.drug_code.value;
	var srl_no    = document.prescription_sliding_scale_remarks.srl_no.value;//Added for ARYU-SCF-0053
	var rangeUom = encodeURIComponent(rangeUom,"UTF-8");

	parent.f_sliding_scale_dtls.location.href="../../ePH/jsp/PrescriptionSlidingScaleTmplDtl.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&template_id="+template_id+"&rangeUom="+rangeUom+"&adminUom="+adminUom+"&mode="+mode+"&drug_code="+drug_code+"&srl_no="+srl_no;// srl_no Added for ARYU-SCF-0053
	document.prescription_sliding_scale_remarks.currTemplate_id.value = i;
}else{
	i = document.prescription_sliding_scale_remarks.currTemplate_id.value;
	eval("document.prescription_sliding_scale_remarks.tmpl["+i+"]").checked=true;
}

}

function ValidateRange(validate, i, formObj){
	if(document.prescription_sliding_scale_remarks_Dtl.validate.value == "" || document.prescription_sliding_scale_remarks_Dtl.validate.value == validate){
	var prevTo = 0.0;
	var nextFrom = 0.0;
	var noOfTemplates = formObj.noOfTemplates.value;
	var frm =	0.0;
	var to = 	0.0;
	var units = 	0.0;	
	if(i != 0 ){
		j = i-1;
		prevTo = eval("document.prescription_sliding_scale_remarks_Dtl.range_to"+j+".value");
	}

	if(i < noOfTemplates-1){
		k = new Number(i)+1;
		nextFrom = eval("document.prescription_sliding_scale_remarks_Dtl.range_from"+k+".value");
	}
	var frm =	eval("document.prescription_sliding_scale_remarks_Dtl.range_from"+i+".value");
	var to = 	eval("document.prescription_sliding_scale_remarks_Dtl.range_to"+i+".value");
	var units = 	eval("document.prescription_sliding_scale_remarks_Dtl.admin_units"+i+".value");
	
	frm = parseFloat(frm);
	to = parseFloat(to);
	if(isNaN(frm))
		frm=0;
	if(isNaN(to))
		to=0;
	if(isNaN(prevTo))
		prevTo=0;
	if(isNaN(nextFrom))
		nextFrom=0;

	//alert("from=" + frm + "==to==" + to + "==next from==" + nextFrom + "==prevTo = " + prevTo);
	
	if(i !=0 && frm == 0)
	{
		document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
		alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		eval("document.prescription_sliding_scale_remarks_Dtl.range_from"+i+".select()");
		return false;
	}
	else if (frm == 0 && to == 0)
	{
		document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
		alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		if(i==0)
			eval("document.prescription_sliding_scale_remarks_Dtl.range_to"+i+".select()");
		else
			eval("document.prescription_sliding_scale_remarks_Dtl.range_from"+i+".select()");
		return false;
	}	
	else if (i > 0 && frm <= prevTo )
	{
		document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
		alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		eval("document.prescription_sliding_scale_remarks_Dtl.range_from"+i+".select()");
		return false;
	}
	else if (i < noOfTemplates-1 && (to >= nextFrom || to<= frm)) 
	{
		document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
		alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		eval("document.prescription_sliding_scale_remarks_Dtl.range_to"+i+".select()");
		return false;
	}
	else if (i != noOfTemplates-1 && !(to > 0) )
	{
		document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
		alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		eval("document.prescription_sliding_scale_remarks_Dtl.range_to"+i+".select()");
		return false;
	}
	/*else if(units >= 999999.999) //code added by Rawther for inc : 28430
	{
	     document.prescription_sliding_scale_remarks_Dtl.validate.value = validate;
	      alert(getMessage("INVALID_SLIDING_SCALE_TEMPLATE_RANGE","PH"));
		  eval("document.prescription_sliding_scale_remarks_Dtl.admin_units"+i).value="";
          eval("document.prescription_sliding_scale_remarks_Dtl.admin_units"+i+".focus()");
          return false;
	}*/
	else
		document.prescription_sliding_scale_remarks_Dtl.validate.value ="";
	}

}

function ValidateAdminUnits(obj)
{
	if(obj.value == null || obj.value == "")
		{
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
			msg = msg.replace("{1}",getLabel("ePH.AdminUnits.label","PH"));
			alert(msg);
			obj.value = "";
			obj.focus();

		}

}
