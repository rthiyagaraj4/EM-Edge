  //saved on 26/10/2005
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var qry_string = "";

/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var formObjHeader		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null; 
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../ePH/jsp/StressFactorAddModify.jsp?mode=1&function_id="+function_id;
}
/******************************************************************************/
function query() {
f_query_add_mod.location.href="../../ePH/jsp/StressFactorQueryCriteria.jsp?function_id="+function_id;
}
/******************************************************************************/
function apply() {
	getHandle();
	var mode
	
	if( headerDoc.mode)
		mode = headerDoc.mode
	else 
		mode = detailDoc.mode

	if(mode.value == "2") {//in Update mode
		applyModify();
		return ;
	}
	

	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"stress_related_option";
	arrFieldName[1]			=	"weightage";

	arrLegends[0]			=	"Stress Related Option"; 
	arrLegends[1]			=	"Weightage";    


//	var formObj				=	f_query_add_mod.document.formMasterCode ;
	
	
	resetDuplicateClass( formObjHeader, arrPKFieldNames );
	

	var	result1	=	validateMandatoryFields(formObjHeader,arrFieldName,arrLegends,arrPKFieldNames);

	if(result1)	{
		
		
		//alert(formApply(formObjHeader,PH_CONTROLLER));
		eval(formApply(formObjHeader,PH_CONTROLLER));	

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;

		
		if(resultGlobal) {
			onSuccess();
		}else if(invalidCode != "" && invalidCode != "null"){
			showDuplicates(formObjHeader,arrPKFieldNames,invalidCode,"0",messageFrame );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal+":-"+invalidCode;
		}
	}
}


function deleterecord(){
	getHandle();
//	alert(formObjHeader.mode.value+"mode"+MODE_INSERT);
	if(formObjHeader.mode.value != MODE_INSERT){
		formObjHeader.mode.value = MODE_DELETE;
		if(formObjHeader.system_defined_yn.value=='Y'){ 
			var msg1 =  getMessage('SYSTEM_DEFINED_CANNOT_DELETE','PH')
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
			return false
		}
		
		if (confirm(getMessage("DELETE_RECORD",'Common')))
		 {
		eval(formApply( formObjHeader,PH_CONTROLLER) );
		}
		//alert(formApply( formObjHeader,PH_CONTROLLER) );
		f_query_add_mod.location.href = "../../ePH/jsp/StressFactorAddModify.jsp?mode="+MODE_INSERT; 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if( resultGlobal ) {
			onSuccess();
		}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
}


/******************************************************************************/
function onSuccess() {
	if(flagGlobal == "insert"  || flagGlobal == "delete" ){
		f_query_add_mod.location.href = "../../ePH/jsp/StressFactorAddModify.jsp?mode=1&function_id="+function_id;
	}else{//Update Mode
		f_query_add_mod.document.location.href="../../ePH/jsp/StressFactorAddModify.jsp?"+qry_string;
	}	
}
/******************************************************************************/
function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode
		if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Tick_Sheets_update"){//Update mode
		formObjDetailUpdate.reset();
		return ;
		}
	getHandleHeader();
	formObjHeader.reset();
	}else{//Query Mode
	f_query_add_mod.document.forms[0].reset(); //reset in query mode
	}
	
	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}
/******************************************************************************/
function applyModify(){
getHandle();

qry_string = "mode=2&function_id="+function_id+"&srl_no="+formObjHeader.srl_no.value


	//alert(formApply(formObjHeader,PH_CONTROLLER));
	eval(formApply(formObjHeader,PH_CONTROLLER));	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;

	if(resultGlobal) {
		onSuccess();
	}
}

function checkRange(obj,count){
	getHandle();
	weightage_val = eval("formObjHeader.weightage"+count).value;
	if(weightage_val != "")
		if(!(parseFloat(weightage_val) >= 1 && parseFloat(weightage_val) <= 2 )){
			alert(getMessage('RANGE_BETWEEN_ONE_AND_TWO','PH'));
			obj.value=""; //Edge it is getting into loop.
			obj.select()
			return false
		}
	if(formObjHeader.default_yn_exists.value=="0"){
		enableCheckbox(obj,count)
	}
}


function enableCheckbox(obj, count){
	getHandle();
//	alert('enable block');
//	alert('ena1 1`11' + eval("formObjHeader.stress_related_option"+count).value);
//	alert('enabl  2222 k'+ eval("formObjHeader.weightage"+count).value);

	if(formObjHeader.default_yn_exists.value != "1"){
		if((eval("formObjHeader.stress_related_option"+count).value != "") && (eval("formObjHeader.weightage"+count).value != "")){
			eval("formObjHeader.default_yn"+count).disabled = false
			
		}else{
			eval("formObjHeader.default_yn"+count).checked = false
			eval("formObjHeader.default_yn"+count).disabled = true
		}
	}else{
			eval("formObjHeader.default_yn"+count).disabled = true
	}
}

function checkThis(count){
	getHandle();
	var total_records = eval("formObjHeader.totalRecords").value
	for (i=0;i< total_records; i++ ){
		if(eval("formObjHeader.default_yn"+i).disabled == false)
			eval("formObjHeader.default_yn"+i).checked = false
	}
	alert("191");
	eval("formObjHeader.default_yn"+count).checked = true

}
function checkRangeOnModify(obj){
	getHandle();
	weightage_val = eval("formObjHeader.weightage").value;
	if(weightage_val != "")
		if(!(parseFloat(weightage_val) >= 1 && parseFloat(weightage_val) <= 2 )){
			alert('Range is between 1 and 2');
			obj.select()
		}
}



/*********************Header Handle*****************************/
function getHandle(){

 headerDoc	     =f_query_add_mod.document ;	
 formObjHeader   =headerDoc.stree_factor_insert ;
}

/*function beforePost(str){
	alert(str);
}
*/
