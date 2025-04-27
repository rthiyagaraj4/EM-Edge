var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_arc_code = "";

function create() 
{
	//alert("Inside create");
	f_query_add_mod.location.href="../../ePH/jsp/AdminRouteCategoryAddModify.jsp?mode="+MODE_INSERT;
}

function query() 
{
	//alert("Inside Query Mode");
	//f_query_add_mod.location.href="../../ePH/jsp/ADRTypeQueryCriteria.jsp" ;
	f_query_add_mod.location.href="../../ePH/jsp/AdminRouteCategoryQueryCriteria.jsp" ;
}

function deleterecord()
{

}

function apply() 
{
	//alert("inside apply in create mode");
	if(!checkIsValidForProceed())
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	var mode = f_query_add_mod.document.frmARCAddModify.mode.value;
	//alert("mode----->" +mode);

	if( mode == MODE_INSERT || mode == MODE_MODIFY ) 
	{
		//var formObj = f_query_add_mod.document.frmADRTypeAddModify ;
		var formObj = f_query_add_mod.document.frmARCAddModify ;
		//var fields = new Array ( formObj.adr_code ,formObj.adr_desc);
		//alert("formObj.arc_code--->" +formObj.arc_code.value);
		//alert("formObj.arc_desc--->" +formObj.arc_desc.value);
		var fields = new Array ( formObj.arc_code ,formObj.arc_desc);
		//var names= new Array (getLabel("ePH.ADRTypeCode.label","PH"), getLabel("ePH.ADRTypeDescription.label","PH"));
		var names= new Array (getLabel("ePH.AdminRouteCategoryCode.label","PH"), getLabel("ePH.AdminRouteCategoryDescription.label","PH"));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			global_arc_code = formObj.arc_code.value;
			//alert("global_arc_code---->" +global_arc_code);
			//global_adr_code = formObj.adr_code.value;
			eval(formApply( f_query_add_mod.document.frmARCAddModify,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if( result ) {
				onSuccess();		
			}
		}
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

/*function reset() {
	//alert("inside Reset function");
	var obj		=	f_query_add_mod.document.frmARCAddModify;
	//alert("obj---->" +obj.name);
	obj.arc_code.value					=	"";
	obj.arc_desc.value					=	"";
	obj.eff_status.checked				=  true;
	//var url = f_query_add_mod.location.href;
	//alert("url---->" +url);
	//url = url.toLowerCase();
	
	/*if ( (url.indexOf("adrtypequerycriteria")!=-1) ) {
		alert("");
		f_query_add_mod.document.query_form.reset();
	}

	//else if ( (url.indexOf("adrtypeaddmodify")!=-1) ) {
	else if ( (url.indexOf("ARCAddModify")!=-1) ) {
		if(f_query_add_mod.document.frmARCAddModify.mode.value == MODE_INSERT){
			alert("if");
			formReset() ;
		}
		else {
			alert("else");
			f_query_add_mod.document.frmARCAddModify.reset();
		}
	}
}*/
function reset() {
	//alert("inside rest func--->");
	var url = f_query_add_mod.location.href;
	//alert("URL--->" +url);
	url = url.toLowerCase();
	//alert("url-100->" +url);
	
	//if ( (url.indexOf("adrtypequerycriteria")!=-1) ) {
	if ( (url.indexOf("adminroutecategoryquerycriteria")!=-1) ) {
		//alert("inside query mode if");
		f_query_add_mod.document.query_form.reset();
	}

	//else if ( (url.indexOf("adrtypeaddmodify")!=-1) ) {
	else if ( (url.indexOf("adminroutecategoryaddmodify")!=-1) ) {
		//alert("else----AdminRouteCategoryAddModify");
		if(f_query_add_mod.document.frmARCAddModify.mode.value == MODE_INSERT){
			//alert("if insert mode going to formreset function");
				formReset() ;
		}
		else {
			f_query_add_mod.document.frmARCAddModify.reset();
		}
	}
}
function formReset()
{
	//alert("inside formReset");
	var obj=f_query_add_mod.document.frmARCAddModify;
	//alert("obj---->" +obj.value);
	obj.arc_code.value = "";
	obj.arc_desc.value = "";
	obj.eff_status.checked = true;
}

function onSuccess() {
	var mode = f_query_add_mod.document.frmARCAddModify.mode.value;
	//alert("mode--in Onsucess function--->" +mode);
    if( mode == MODE_INSERT ) {
		//alert("105");
        f_query_add_mod.document.frmARCAddModify.reset();
    }
    else if(mode == MODE_MODIFY ){
		f_query_add_mod.document.location.href="../../ePH/jsp/AdminRouteCategoryAddModify.jsp?arc_code="+global_arc_code+"&mode="+MODE_MODIFY;
    }
}
function Modify(arc_code) {
	document.location.href="../../ePH/jsp/AdminRouteCategoryAddModify.jsp?arc_code="+arc_code+"&mode="+MODE_MODIFY;
}
function checkIsValidForProceed() {
	//alert("Inside this");
	var url = f_query_add_mod.location.href;
	//alert("URl===>" +url);
	url = url.toLowerCase();
	//alert("URl22222===>" +url);
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("adminroutecategoryquerycriteria")==-1) )
		return true;
	else
		return false;
}
function beforePost(str){
	//alert("Reason Codes::"+str);
}

function ReasonCodeCheck(obj){
	if(!CheckChars(obj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
function toUpper(obj) {
	//alert("obj--->" +obj.value);
	obj.value=obj.value.toUpperCase();
}

function ChkMaxLen(lab,obj,max,mode) {

	if(obj.value.length >= max) {
		alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH")+ max  + getLabel("ePH.characters.label","PH") );
		obj.select();
		return false;
	} 
	else 
		return true;
}