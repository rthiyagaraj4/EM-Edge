/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		 	Edit history        Name			       Rev.Date		     Rev.Nam			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
31/07/2017							Shazana hasan							        				MMS-DM-CRF-099.2(Added Look Up screen for GRN item label)

--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/




var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";

function reset(){
	f_query_add_mod.location.reload();
}

async function searchCodeItem( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]   = "language_id";
	dataValueArray[0]   = document.forms[0].p_language_id.value;
	dataTypeArray[0]    = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
 	var arr=ret1.split(",");
 	if(arr[1]==undefined) 
	{
 		arr[0]="";	
 		arr[1]="";	
	}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[0];
	} 
}


async function searchCodeItemClass( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value+"'"+document.forms[0].p_language_id.value+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}
//Adding start for MMS-DM-CRF-099.2
async function searchGrnNum (obj,obj1) 
{

	alert;
	var dialogHeight = "70vh";
	var dialogWidth = "80vw";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll=no; status=no";
	var arguments = "";
	//window.showModalDialog("../../eST/jsp/ViewGRNSCriteria.jsp?title_name=Search GRN", arguments, features);
	returnedValues =await  window.showModalDialog("../../eST/jsp/ViewItemLabelGRNMain.jsp?title_name=Search GRN", arguments, features);
	if((returnedValues != null) && (returnedValues != "") )  {
		var retArr=returnedValues.split(":");
		obj.value = retArr[0];
		obj1.value= retArr[1];
	}  
}
//Adding end for MMS-DM-CRF-099.2
function GRNChecked(){ 
   var formObj=document.formItemLabelCriteria;
   formObj.radio3.checked=false;
   formObj.p_fm_item_code.value="";
   formObj.p_fm_item_code.disabled=true;
   formObj.p_fm_sr2.disabled=true;
   formObj.p_to_item_code.value="";
   formObj.p_to_item_code.disabled=true;
   formObj.p_to_sr2.disabled=true;
   formObj.p_doc_type_code.disabled=false;
   formObj.p_doc_no.disabled=false;
   if(formObj.site.value==true)// Added by Shazana for MMS-DM-CRF-099.2
   formObj.p_grn_no.disabled=false;
   formObj.P_no_labels.disabled=true;
   formObj.P_no_labels.value="";
   formObj.p_report_id.value="STBITLBL";
   document.getElementById("no_of_cp_mnd").style.visibility="hidden";
   document.getElementById("doc_type_mnd").style.visibility="visible";
   document.getElementById("print_report").style.visibility="visible";
   document.getElementById("view_report").style.visibility="visible";
   document.getElementById("store_lb").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   document.getElementById("p_store_code_lb").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   document.getElementById("store_img").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   formObj.radio4.checked=false;//Added for NMC-JD-CRF-0208
	parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = true;
}

function ITEMChecked(){ 
   var formObj=document.formItemLabelCriteria;
   formObj.p_fm_item_code.disabled=false;
   formObj.radio1.checked=false;
   formObj.p_fm_sr2.disabled=false;
   formObj.p_to_item_code.disabled=false;
   formObj.p_to_sr2.disabled=false;
   formObj.p_doc_type_code.disabled=true;
   formObj.p_doc_type_code.value="";
   formObj.p_doc_no.disabled=true;
   if(formObj.site.value==true) // Added by Shazana for MMS-DM-CRF-099.2
   formObj.p_grn_no.disabled=true;
   formObj.p_doc_no.value="";
   formObj.P_no_labels.disabled=false;
   formObj.p_report_id.value="STBITLB2";
   document.getElementById("no_of_cp_mnd").style.visibility="visible";
   document.getElementById("doc_type_mnd").style.visibility="hidden";
   document.getElementById("print_report").style.visibility="hidden";
   document.getElementById("view_report").style.visibility="hidden";
   document.getElementById("store_lb").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   document.getElementById("p_store_code_lb").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   document.getElementById("store_img").style.visibility="hidden";//Added for NMC-JD-CRF-0208
   formObj.radio4.checked=false;//Added for NMC-JD-CRF-0208
	parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = false;
}

function STOREChecked(){ 
   var formObj=document.formItemLabelCriteria;
   formObj.p_fm_item_code.disabled=false;
   formObj.radio1.checked=false;
   formObj.radio3.checked=false;
   formObj.p_fm_sr2.disabled=false;
   formObj.p_to_item_code.disabled=false;
   formObj.p_to_sr2.disabled=false;
   formObj.p_doc_type_code.disabled=true;
   formObj.p_doc_type_code.value="";
   formObj.p_doc_no.disabled=true;
   if(formObj.site.value==true) // Added by Shazana for MMS-DM-CRF-099.2
   formObj.p_grn_no.disabled=true;
   formObj.p_doc_no.value="";
   formObj.P_no_labels.disabled=true;
   formObj.p_report_id.value="STBITLBL3";
   //document.getElementById("no_of_cp_mnd").style.visibility="visible";
   document.getElementById("doc_type_mnd").style.visibility="hidden";
   document.getElementById("print_report").style.visibility="hidden";
   document.getElementById("view_report").style.visibility="visible";
   document.getElementById("store_lb").style.visibility="visible";
   document.getElementById("p_store_code_lb").style.visibility="visible";
   document.getElementById("store_img").style.visibility="visible";
	parent.commontoolbarFrame.document.CommonToolbar_form.run.disabled = false;
}

function run(){       
	var formObj=  f_query_add_mod.document.formItemLabelCriteria;
/*    var obj1 = f_query_add_mod.document.formItemLabelCriteria.radio1.status;

	if (obj1 == true){
		
		var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_doc_no);
		var names = new Array(getLabel("Common.DocType.label", "Common"),getLabel("Common.DocNo.label", "Common"));
		var blankObject = checkFields1(arrayObject, names, messageFrame);
		if (blankObject == true){}
//			formObj.submit();
///Changed By Mahesh on 4/28/2008 to submit values in loop for item label		
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlDoc.loadXML(getXMLString(null));
			xmlHttp.open("POST", "../../eST/jsp/ItemLabelValidate.jsp?validate=RUN_REPORT&doc_no="+formObj.p_doc_no.value+"&doc_type_code="+formObj.p_doc_type_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			alert(responseText);
			eval(responseText);
	}else{*/
	if(formObj.radio4.checked ==true){
		var arrayObject = new Array(formObj.p_store_code);
		var names = new Array(getLabel("Common.Store.label","Common"));
	 }else{
		 var arrayObject = new Array(formObj.P_no_labels);
		 var names = new Array(getLabel("eST.NoofCopies.label","ST"));
	 }
		var blankObject = checkFields1(arrayObject, names, messageFrame);
		if (blankObject == true)
			if (isSTValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label","Common"), messageFrame)) {
					formObj.action="../../eCommon/jsp/report_options.jsp";

    		formObj.target="messageFrame"; 
				formObj.submit();	
			}				
	//}
}
function checkFields1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else{
			var msg_1=getLabel("Common.Cannotbeblank.label", "Common");
			errors +=" APP-000001 "+  names[i] +"   "+msg_1 + "<br>" ;
		}
    }
    if ( errors.length != 0 ) {
        
		/*var expand_value;
		var type_value;
		var buttonobj_value;
buttonobj_value=parent.parent.frames[0].document.forms[0].home;
parent.parent.parent.frames[1].expand_val.expandState=0;
if(parent.parent.parent.frames[1].expand_val.expandState=="0")
		{
		parent.parent.parent.frames[1].expand(buttonobj_value,type_value,"cm");
		}
		var expand =parent.parent.parent.frames[1].expand_val.expandState;*/
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
       return false ;
		//alert(parent.parent.parent.frames[1].type_val.value);

//	if(parent.parent.frames[0].document.forms[0].home.value=="")
    }
    return true ;
}
function printReports(){
	if(confirm("Print Label(s)")){
		var formObj=  document.formItemLabelCriteria;
		formObj.print_report.disabled = true;
		formObj.view_report.disabled = true;
		formObj.P_OFFLINE.value = "N";//Added By Rabbani #Inc no: 49630 on 16-Jun-2014
		var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_doc_no);
		var names = new Array(getLabel("Common.DocType.label", "Common"),getLabel("Common.DocNo.label", "Common"));
		var blankObject = checkFields1(arrayObject, names, parent.messageFrame);
		if (blankObject == true){
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlStr = getXMLString(formObj);
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eST/jsp/ItemLabelValidate.jsp?validate=RUN_REPORT&doc_no="+formObj.p_doc_no.value+"&doc_type_code="+formObj.p_doc_type_code.value, false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			eval(responseText);
			if(result){
				alert("REPORT_SUBMITTED","ST");
				document.location.reload();
			}
		}
	}else{
		return;
	}
}
function viewLabels(){
	var formObj=  document.formItemLabelCriteria;
	if(formObj.radio4.checked ==true){
		var arrayObject = new Array(formObj.p_store_code);
		var names = new Array(getLabel("Common.Store.label","Common"));
	 }else{
	var arrayObject = new Array(formObj.p_doc_type_code,formObj.p_doc_no);
	var names = new Array(getLabel("Common.DocType.label", "Common"),getLabel("Common.DocNo.label", "Common"));
	 }
	var blankObject = checkFields1(arrayObject, names, parent.messageFrame);
	if (blankObject == true)
		formObj.submit();
}
