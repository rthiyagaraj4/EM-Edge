var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugSynonymAddModify.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugSynonymQueryFrame.jsp?mode="+MODE_MODIFY;
}


function apply() {
	message="";
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	formObj	=	f_query_add_mod.document.frmDrugSynonymAddModify;
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
   
	arrFieldName[0]			=	"DrugName_";
	arrFieldName[1]			=	"DrugSynonymDesc_";

	var drug_code=getLabel("Common.Drug.label","Common");
	var common_desc=getLabel("ePH.CommonName.label","PH");
	arrLegends[0]			=	drug_code;
	arrLegends[1]			=	common_desc;

	var arrPKFieldNames		=	new Array();
	arrPKFieldNames[0]		=	"DrugName_";
	arrPKFieldNames[1]		=	"DrugSynonymDesc_";
	var mode = formObj.mode.value;
	if( mode == MODE_INSERT )
	{
		//resetDuplicateClass(formObj,arrPKFieldNames,'0');
		var	result	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,'0');
		if (result){
			for(i=0;i<10;i++){
				EffStatus= eval("formObj.EffStatus"+i).value;
				if(EffStatus =='E'){
					descObj=eval("formObj.DrugSynonymDesc_"+i);
					DrugCode=eval("formObj.DrugCode_"+i).value;
					DrugSynonymDesc = trimString(descObj.value);
					if(DrugCode == ""){
						var msg = getMessage("PH_DRUG_SELECTED_FROM_LOOKUP", "PH")+" @ index"+(i+1);
						alert(msg);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
						eval("formObj.DrugName_"+i).focus();
						return false;
					}
					if( DrugSynonymDesc =="" || DrugSynonymDesc.length <3){
						var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
						msg = msg.replace('$', getLabel("ePH.CommonName.label","PH"));
						alert(msg);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
						descObj.focus();
						return false;
					}
				}
			}
			eval(formApply(formObj,PH_CONTROLLER));
			if( result1 ) {
				onSuccess();
			}
		}
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
	}
	if( mode == MODE_MODIFY ) {
		DrugSynonymDesc = trimString(formObj.DrugSynonymDesc.value);
		label=  getLabel("ePH.CommonName.label","PH");
		if(DrugSynonymDesc ==''){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', label);
			alert(msg);
			return false;
		}
		else{
			if(DrugSynonymDesc.length < 3 ){
				var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
				msg = msg.replace('$', label);
				alert(msg);
				formObj.DrugSynonymDesc.focus();
				return false;
			}
			eval(formApply(formObj,PH_CONTROLLER ));
			if( result1 ) {
				onSuccess();
			}
		}
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if (url.indexOf("query")!=-1) {
		f_query_add_mod.drugSynonymQueryCriteria.document.frmDrugSynonymQueryCriteria.reset()
		//f_query_add_mod.drugSynonymQueryCriteria.document.frmDrugSynonymQueryCriteria.reload();
		f_query_add_mod.drugSynonymQueryResult.location.href="../../eCommon/html/blank.html";
	}
	else if (url.indexOf("addmodify")!=-1) {
		f_query_add_mod.document.frmDrugSynonymAddModify.reset();
		
	}
}
function onSuccess() {
	var url = f_query_add_mod.location.href;
	formObj	=	f_query_add_mod.document.frmDrugSynonymAddModify;
	var mode = formObj.mode.value;
	if( mode == MODE_INSERT ) {
		formObj.reset();
		//formObj.reload();
		formObj.DrugName_0.focus();
	}
	else if(mode == MODE_MODIFY ){
		DrugName = formObj.DrugName.value;
		DrugCode = formObj.DrugCode.value;
		SrlNo = formObj.SrlNo.value;
		DrugSynonymType = formObj.DrugSynonymType.value;
		EffStatus = formObj.EffStatus.value;
		DrugSynonymDesc = formObj.DrugSynonymDesc.value;
		f_query_add_mod.location.href="../../ePH/jsp/DrugSynonymAddModify.jsp?DrugName="+DrugName+"&DrugCode="+DrugCode+"&mode="+MODE_MODIFY+"&SrlNo="+SrlNo+"&DrugSynonymType="+DrugSynonymType+"&EffStatus="+EffStatus+"&DrugSynonymDesc="+DrugSynonymDesc;
	}
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
		return true;
	else
		return false;
}

async function searchDrugName(index){
	if(index!=undefined && index !=''){
		formObj=document.frmDrugSynonymAddModify;
		var objDrug = eval("formObj.DrugName_"+index);
		var retVal=await DrugSearch("D",objDrug);
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "" )  {
			eval("formObj.DrugCode_"+index).value=arr[0];
			eval("formObj.DrugName_"+index).value=arr[1];
			eval("formObj.SynonymTypeCode_"+index).value=arr[0];
			eval("formObj.EffStatus"+index).value = "E";
			eval("formObj.EffStatus"+index).checked = true;
		}
		else{
			eval("formObj.DrugCode_"+index).value="";
			eval("formObj.DrugName_"+index).value="";
			eval("formObj.SynonymTypeCode_"+index).value="";
			eval("formObj.EffStatus"+index).value = "D";
			eval("formObj.EffStatus"+index).checked = false;
			eval("formObj.DrugName_"+index).value="";
			eval("formObj.DrugName_"+index).focus();
		}
	}
	else{
		formObj=document.frmDrugSynonymQueryCriteria;
		var objDrug = formObj.DrugName;
		var retVal=await DrugSearch("D",objDrug);
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "" ){
			formObj.DrugCode.value=arr[0];
			formObj.DrugName.value=arr[1];
			formObj.btnSearch.value="";
			formObj.btnSearch.focus();
		}
	}
}

function searchDrugSynonyms(){
	DrugCode = document.frmDrugSynonymQueryCriteria.DrugCode.value;
	DrugName = document.frmDrugSynonymQueryCriteria.DrugName.value;
	DrugSynonymType = document.frmDrugSynonymQueryCriteria.DrugSynonymType.value;
	if(DrugCode==''){
		alert(getMessage("PH_ATLEAST_ONE_DRUG_SELECTED","PH"));
		document.frmDrugSynonymQueryCriteria.DrugName.value="";
		document.frmDrugSynonymQueryCriteria.DrugName.focus();
		return false;
	}
	mode = document.frmDrugSynonymQueryCriteria.mode.value;
	parent.drugSynonymQueryResult.location.href = "../../ePH/jsp/DrugSynonymQueryResult.jsp?DrugCode="+DrugCode+"&DrugName="+DrugName+"&DrugSynonymType="+DrugSynonymType+"&mode="+mode;
}
function modify(index){
	if(index!=undefined && index !=''){
		formObj=document.frmDrugSynonymQueryResult;
		var DrugName  =encodeURIComponent(formObj.DrugName.value,'UTF-8') ;
		var DrugCode=	formObj.DrugCode.value;
		var SrlNo=	eval("formObj.SrlNo"+index).value;
		var DrugSynonymType = 	formObj.DrugSynonymType.value;
		var EffStatus=	eval("formObj.EffStatus"+index).value;
		var DrugSynonymDesc= encodeURIComponent(eval("formObj.DrugSynonymDesc"+index).value,'UTF-8') ;
		var mode =	formObj.mode.value ;
		parent.parent.f_query_add_mod.location.href="../../ePH/jsp/DrugSynonymAddModify.jsp?DrugName="+DrugName+"&DrugCode="+DrugCode+"&mode="+MODE_MODIFY+"&DrugName="+DrugName+"&SrlNo="+SrlNo+"&DrugSynonymType="+DrugSynonymType+"&EffStatus="+EffStatus+"&DrugSynonymDesc="+DrugSynonymDesc;
	}
}

function selectRec(checkObj){
	if(checkObj.checked==true)
		checkObj.value = 'E';
	else
		checkObj.value='D';
}

function minLengthValidate(descObj){
	DrugSynonymDesc = trimString(descObj.value);
	if( DrugSynonymDesc =="" || DrugSynonymDesc.length <3){
		var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
		msg = msg.replace('$', getLabel("ePH.CommonName.label","PH"));
		alert(msg);
		descObj.focus();
		return false;
	}
}