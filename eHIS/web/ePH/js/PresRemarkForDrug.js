var message = "" ;
var result=false;

function create(){
	f_query_add_mod.location.href="../../ePH/jsp/PresRemarkForDrugFrames.jsp?mode="+MODE_INSERT;
}

function query(){
	f_query_add_mod.location.href="../../ePH/jsp/PresRemarkForDrugQueryCriteria.jsp?mode="+MODE_MODIFY;
}

function getSearchResult(obj){
	var formObj=document.PresRemarkForDrugHeaderForm;
	var drug_code = formObj.drugSearch.value;
	var route_code = formObj.route.value;
	var form_code = obj.value;
	var fields = new Array (formObj.drugSearch);
	var names = new Array (getLabel("ePH.DrugSearchText.label","PH"));
	var messageFrame	=	parent.parent.messageFrame;
	
	if( ( form_code=='' ||route_code=='' )&& drug_code != ''){
		alert(getMessage('PH_SELECT_DRUG','PH'));	
		return false;
	}
	else if(parent.f_query_add_Header.checkFieldsofMst( fields, names, messageFrame)){
		disableMainForm();
		var mode=document.PresRemarkForDrugHeaderForm.mode.value;
		var drugSearch=document.PresRemarkForDrugHeaderForm.drugSearch.value;
		var drug_code=document.PresRemarkForDrugHeaderForm.drug_code.value;
		parent.f_query_add_details.location.href="../../ePH/jsp/PresRemarkForDrugDetail.jsp?routecode="+route_code+"&formcode="+form_code+"&drugSearch="+encodeURIComponent(drugSearch)+"&drug_code="+drug_code+"&mode="+mode+"&search=new";
		return true;
	}
	else
		return false;
}

function disableMainForm(){
	var arrObj =document.PresRemarkForDrugHeaderForm.elements;
    for(var i=0;i<arrObj.length;i++)
	   arrObj[i].disabled=true;
}

async function searchDrug(obj){
	var language_id=document.PresRemarkForDrugHeaderForm.language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var form_Code=PresRemarkForDrugHeaderForm.form_code.value;
    var route_Code=PresRemarkForDrugHeaderForm.route.value;
	var sql_order_type = document.PresRemarkForDrugHeaderForm.sql_Pres_Remark_for_drug_LookUp.value; 
    var language_id=document.PresRemarkForDrugHeaderForm.language_id.value;
 
    sql_order_type=sql_order_type.replace("#","'"+language_id+"'");
	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2,3";
	argumentArray[5]   = document.PresRemarkForDrugHeaderForm.drugSearch.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.DrugSearch.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != '' && retVal != undefined){
		document.PresRemarkForDrugHeaderForm.drugSearch.value = arr[1] ;
		document.PresRemarkForDrugHeaderForm.drug_code.value = arr[0];
		formSearch(arr[0]);
	}
}

async function searchItem(obj){  
	var language_id=document.PresRemarkForDrugHeaderForm.language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var sql_order_type=document.PresRemarkForDrugHeaderForm.sql_Pres_Remark_for_drug_LookUp1.value
	sql_order_type=sql_order_type.replace("#","'"+language_id+"'");
	sql_order_type=sql_order_type.replace("#","'"+language_id+"'");
	sql_order_type=sql_order_type.replace("#","'"+language_id+"'");

	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = document.PresRemarkForDrugHeaderForm.PrescriptionRemarks.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;

	retVal = await CommonLookup( getLabel("ePH.PrescriptionRemarks.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		document.PresRemarkForDrugHeaderForm.PrescriptionRemarks.value = arr[1] ;
		document.PresRemarkForDrugHeaderForm.Prescription_code.value = arr[0];
  }
  sample(arr[0]);
}

function formSearch(obj){
	var drug_code=obj;
	var bean_id		="PresRemarkForDrugBean";
	var bean_name	="ePH.PresRemarkForDrugBean";	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PresRemarkForDrugValidate.jsp?func_mode=remarksCodeSearch&drug_code="+drug_code,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function loadIntoLocation(objCode,objDesc,fntColor,backgrndColor,defaultRoute){ // color parameters added for CRF RUT-CRF-0034.1[IN:037389]
	var formObj = document.PresRemarkForDrugHeaderForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (objCode) ;
	element.text		=  (objDesc) ;
	if (element.value == defaultRoute){
		element.selected = true;
	}
	element.style.color=fntColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	element.style.backgroundColor=backgrndColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	formObj.route.add(element);
}
function loadIntoLocationAll(){
	var formObj = document.PresRemarkForDrugHeaderForm;
	var element = document.createElement('OPTION') ;
	element.value		=  ("All") ;
	element.text		=  ("All") ;
	formObj.route.add(element);
}

function formValues(form,form_code){
 
   if(form == null)
	   form="";
   else
	   form=form;
	
	if((form!=null)&&(form!='null'))
		document.PresRemarkForDrugHeaderForm.Forms.value=form;
	if((form_code!=null)&&(form_code!='null'))
		document.PresRemarkForDrugHeaderForm.form_code.value=form_code;
}

function reset(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("presremarkfordrugquerycriteria")!=-1)){
		f_query_add_mod.document.query_form.reset();
	}
	else if ((url.indexOf("presremarkfordrugframes")!=-1)){
		if(f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm.mode.value == 1){
			f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm.reset();
			f_query_add_mod.f_query_add_details.location.href="../../eCommon/html/blank.html";
			var arrObj =f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm.elements;
			
			for(var i=0;i<arrObj.length;i++){
				arrObj[i].disabled=false;
			}
			removeObj();
		}
		else {
			f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm.reset();
		}
	}
}
function removeObj(){
	var obj= "f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm."+"route";
	var length = eval(obj).options.length;
	for(var i=0;i<parseInt(length);i++){	
		eval(obj).remove('OPTION') ;		
	}
}

function Modify(obj,eff_status,route_code,form_code, route_color){
	var drug_code					=	obj.cells[0].innerText;
	var drug_desc					=	obj.cells[1].innerText;
	var form_desc					=	obj.cells[2].innerText;
	var remarks_desc				=	obj.cells[3].innerText;
	var route_desc					=	obj.cells[4].innerText;
	parent.f_query_add_mod.location.href	=	"../../ePH/jsp/PresRemarkForDrugFrames.jsp?mode="+MODE_MODIFY+"&drug_code="+drug_code+"&drug_desc="+encodeURIComponent(drug_desc)+"&remarks_desc="+encodeURIComponent(remarks_desc)+"&route_code="+route_code+"&form_code="+form_code+"&eff_status="+eff_status+"&form_desc="+encodeURIComponent(form_desc)+"&route_desc="+encodeURIComponent(route_desc)+"&reoute_color="+route_color;
}

function submitPrevNext(from, to,flag){  
	document.PresRemarkForDrugDetailForm.from.value = from;
	document.PresRemarkForDrugDetailForm.to.value = to;
	document.PresRemarkForDrugDetailForm.submit();
}

function remarksCheck(obj, remarks_code,count){
	var formObj = 'document.PresRemarkForDrugDetailForm.modeOpn';
	dbTextObj = eval(formObj+count);
	dbText = dbTextObj.value;
	if(obj.checked == true)
		obj.value = "Y";
	else
		obj.value = "N";

	var bean_id		="PresRemarkForDrugBean";
	var bean_name	="ePH.PresRemarkForDrugBean";	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PresRemarkForDrugValidate.jsp?func_mode=PrescriptionRemarksCheck&remarks_code="+remarks_code+"&selected="+ obj.value+"&remarkscnt="+count+"&dbAction="+dbText,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function remarksDefaultCheck(obj, remarks_code, remarksCount){
	if(obj.checked == true)
		 obj.value="Y";
	else
		obj.value="N";
	prescriptionReamrksDisable(obj,remarks_code);
    var bean_id		="PresRemarkForDrugBean";
	var bean_name	="ePH.PresRemarkForDrugBean";	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PresRemarkForDrugValidate.jsp?func_mode=DefaultRemarkCheck&remarks_code="+remarks_code+"&defaultselected="+ obj.value+"&remarkscnt="+remarksCount,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function prescriptionReamrksDisable(obj,remarks_code){
	var listLength = document.PresRemarkForDrugDetailForm.remarksCnt.value;
	var checkboxObj="document.PresRemarkForDrugDetailForm.DefaultRemark";
	var colIndex=0;
	while(colIndex<listLength){
	   tempName = checkboxObj+colIndex
	   checkboxName = eval(tempName).name
	   if (checkboxName != obj.name){ 
			eval(tempName).checked= false;
			eval(tempName).value='N'
			if (!obj.checked){
				eval(tempName).disabled = false;
				eval(tempName).checked= false;
				eval(tempName).value='N'
			}
	    }
		colIndex++;
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("remarkfordrugheader")==-1) && (url.indexOf("remarkfordrugquery")==-1))
		return true;
	else
		return false;
}

function apply(){
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var formObj=f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm;
	var fields = new Array (formObj.drugSearch);
	var names = new Array (getLabel("ePH.DrugSearchText.label","PH"));
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var frmObj1=f_query_add_mod.f_query_add_Header.document.PresRemarkForDrugHeaderForm;
		var frmObj2=f_query_add_mod.f_query_add_details.document.PresRemarkForDrugDetailForm;
		mode=frmObj2.mode.value;
		if(mode!=null){
			if(mode=="2"){
			
				eval(formApply(frmObj2,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if( result ) {
					f_query_add_mod.f_query_add_Header.location.reload();
					f_query_add_mod.f_query_add_details.location.href="../../eCommon/html/blank.html";
				}
			}
		}
		if(mode=="1"){
			eval(formApply(frmObj1,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				f_query_add_mod.f_query_add_Header.location.reload();
				f_query_add_mod.f_query_add_details.location.href="../../eCommon/html/blank.html";
			}
		}
	}
 }

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function charsCapsSpaceDotCamasOnly(){
	if(event.keyCode >=65 && event.keyCode<=90)
		event.keyCode = event.keyCode;
	else if(event.keyCode >=97 && event.keyCode<=122)
		event.keyCode = event.keyCode;
	else if(event.keyCode >=48 && event.keyCode<=57)
		event.keyCode = event.keyCode;
	else 
		event.keyCode=0;
 }

function DrugValue(obj){
	var frmObj=document.PresRemarkForDrugDetailForm;
	if(obj.checked==false)
		document.PresRemarkForDrugDetailForm.chekvalue.value="D";
	else
		document.PresRemarkForDrugDetailForm.chekvalue.value="E";
}
