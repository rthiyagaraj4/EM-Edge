/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result = false;
var radioval = "D";
var CODE_DESC       = "CODE_DESC" ;
var DESC_CODE       = "DESC_CODE" ;
function create() {
	f_query_add_mod.location.href="../../eSS/jsp/SurgeryTypeAddModifyMultiple.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/SurgeryTypeQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY ;
}


function apply() {
if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
    formObj =   f_query_add_mod.document.forms[0];

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    
	
	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }

    var mode = formObj.mode.value;
    if( mode == MODE_INSERT )
    {
    	arrFieldName[0]         =   "code_";
        arrFieldName[1]         =   "long_desc_";
        arrFieldName[2]         =   "short_desc_";
        if(formObj.surg_nature_link_to_OT_yn.value == "Y"){
        arrFieldName[3]         =   "surg_name_";//Added by sakti against KDAH-CRF-0247
        }

        arrLegends[0]           =   getLabel("Common.code.label","Common");
        arrLegends[1]           =   getLabel("Common.longdescription.label","Common");
        arrLegends[2]           =   getLabel("Common.shortdescription.label","Common");
        if(formObj.surg_nature_link_to_OT_yn.value == "Y"){
        arrLegends[3]           =   getLabel("eSS.SurgeryName.label","SS");//Added by sakti against KDAH-CRF-0247
        }

        var arrPKFieldNames     =   new Array();
        arrPKFieldNames[0]      =   "code_";

	//Added by sakti against KDAH-CRF-0247
		var totalRecords = formObj.totalRecords.value;
		for(var i=0;i<totalRecords;i++ ){
			 var OTsurg_code = eval("formObj.surgery_type_search_"+i).value;
			 var OTsurg_desc = eval("formObj.surg_name_"+i).value;
			 if(OTsurg_code == "" && OTsurg_desc !="" ){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("INVALID_SURG_NAME","SS");
				eval("formObj.surg_name_"+i).focus();
				return;
			 }
		 }
       //Added ends

        /*resetDuplicateClass(formObj,arrPKFieldNames);
        var blankObj  =   checkSSFields( arrFieldName, arrLegends, messageFrame);
        if (blankObj){
            eval(formApply(formObj,SS_CONTROLLER));

            if( result ) {

                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
                onSuccess();
            }
            if( invalidCode != "null" && invalidCode != "" ){
                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+":-"+invalidCode;
                showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
                }
        }
        else
        {
            return false;
        }*/
		var validateResult = validateSSMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
		if(validateResult) {
			eval(formApply(formObj,SS_CONTROLLER).replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, ""));
			if( result ) {
				onSuccess();
			}				
			if( invalidCode != "null" && invalidCode != "" ){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message+":-"+invalidCode;
				return; //Added By Sakti Sankar against Inc#28682

				//Commented by Sakti Sankar against inc#28682 
				//showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame); 
			}
			else {
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
			}
		}
    }

   if( mode == MODE_MODIFY )
    {
       var frmobj = f_query_add_mod.document.formSurgeryType;

		var errorPage	=	"../../eCommon/jsp/error.jsp";
		 if(frmobj.surg_nature_link_to_OT_yn.value == "Y"){
				var fields = new Array (formObj.code_0, formObj.long_desc_0, formObj.short_desc_0,formObj.surg_name_0);//Added by sakti against KDAH-CRF-0247
				var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("eSS.SurgeryName.label","SS"));
		 }else{
				var fields = new Array (formObj.code_0, formObj.long_desc_0, formObj.short_desc_0);
				var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
		}

       
		
			 if (checkSSFields( fields, names, messageFrame))
		 {
				 responseText = formApply(frmobj,SS_CONTROLLER);
				eval(responseText);

			messageFrame.location.href = errorPage+"?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
		 }
    }

}

function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("surgerytypequery")==-1) )
        return true;
    else
        return false;
}

function isInArray(_array, _value) {
	var found	=	false;
	for (index=0;index<_array.length ;index++ ) 
		if(_array[index]==_value){
			found=true;
			break;
		}
	return found;
}

function reset() {
	if (f_query_add_mod.document.formSurgeryType!=null)	{
		f_query_add_mod.document.location.reload();
		f_query_add_mod.FocusFirstElement();
	}
	if(f_query_add_mod.document.query_form!=null)
		f_query_add_mod.document.query_form.reset();
	
}

function searchSurgeryName(code,desc) {

	var retval = callNatureTypeSearchWindow(code,desc);
	
	if (retval !=undefined) {
		
			code.value = retval[0];
			desc.value = retval[1];
			desc.readOnly= true;
	}
	
}

function onSuccess() {
	var mode = f_query_add_mod.document.formSurgeryType.mode.value;
	if( mode == MODE_INSERT ) {
		reset();
	}
	else{ 
		f_query_add_mod.document.location.reload();
	}
}

function Modify(obj){
	
	var surgery_type=obj.cells[0].innerText;
	
	document.location.href="../../eSS/jsp/SurgeryTypeAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&surgery_type="+surgery_type;
}

function resetColorCode(obj){
    var arrPKFieldNames = new Array();
    var formObj = parent.f_query_add_mod.document.formSurgeryType;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}



//Added by sakti against KDAH-CRF-0247



async function callNatureTypeSearchWindow(code,desc,nature) {
	
	var retval = await window.showModalDialog("../../eSS/jsp/OTSurgeryNameSearchFrame.jsp?&typed_text="+desc.value ,"", "dialogHeight:500px; dialogWidth:800px; center:0; status: no; dialogLeft :200; dialogTop :100;");
	
	if (retval !=undefined) {
		 var totalRecords = document.formSurgeryType.totalRecords.value;
		 if(totalRecords >0){
		 for(var i=0;i<totalRecords;i++ ){
			 var surg_code = eval("document.formSurgeryType.surgery_type_search_"+i).value;
			 if(surg_code == retval[0]){
				alert(getMessage("DUPLICATE_SURG_NAME_NOT_ALLOWED","SS"));
				return;
			 }
		 }
			code.value = retval[0];
			desc.value = retval[1];
			desc.value = decodeURIComponent(desc.value,"UTF-8");
			desc.value = desc.value.replace(/\+/g,' ');
			desc.readOnly= true;
		}else{
			code.value = retval[0];
			desc.value = retval[1];
			desc.value = decodeURIComponent(desc.value,"UTF-8");
			desc.value = desc.value.replace(/\+/g,' ');
			nature.value = retval[2];
			desc.readOnly= true;
		}
	}
}


function searchVals() {
	var search_text = document.OTSurgeryNameSearchCriteria_Form.search_text.value;
	parent.frameOTSurgeryNameSearchResult.document.location.href = "../../eSS/jsp/OTSurgeryNameSearchResult.jsp?radioval=" + radioval+"&search_text="+search_text;
}

function storeVal(currad) {
    radioval=currad.value;
}

function ModifySearch(code,desc,nature){
   var retVal = code + "~" + desc+ "~" + nature ;
   parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = retVal.split("~");
   parent.parent.document.getElementById("dialog_tag").close(); 
   // top.window.returnValue = retVal.split("~"); 
   // top.close();
}



function Setsurgdesc(surg_desc,short_desc,long_desc){
	document.formSurgeryType.surg_name_0.value = decodeURIComponent(surg_desc.value,"UTF-8");
	document.formSurgeryType.surg_name_0.value = document.formSurgeryType.surg_name_0.value.replace(/\+/g,' ');
	document.formSurgeryType.short_desc_0.value = decodeURIComponent(short_desc.value,"UTF-8");
	document.formSurgeryType.short_desc_0.value = document.formSurgeryType.short_desc_0.value.replace(/\+/g,' ');
	document.formSurgeryType.long_desc_0.value = decodeURIComponent(long_desc.value,"UTF-8");
	document.formSurgeryType.long_desc_0.value = document.formSurgeryType.long_desc_0.value.replace(/\+/g,' ');
} 
//for locking backspace key and enter key
 function isNumberKey(evt)
{

    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode == 8 || charCode == 13) 
    	return false;

  } //Added ends
