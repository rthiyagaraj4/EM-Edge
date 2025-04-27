var messageFrameReference = parent.parent.messageFrame;
function reset() 
{
	f_query_add_mod.UserPrvlgToVeryEmailHdrFrame.document.forms[0].reset();
	f_query_add_mod.UserPrvlgToVeryEmailHdrFrame.document.UserPrvlgToVeryEmailHdrForm.module_id.disabled = false;
	f_query_add_mod.UserPrvlgToVeryEmailHdrFrame.document.UserPrvlgToVeryEmailHdrForm.report_id.disabled = false;
	f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.location.href="../../eCommon/html/blank.html"

}
function populateReportId(obj){
	//alert('module_id'+obj.value);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "searchKey=\"hdrPage\" " ;
	xmlStr += "module_id=\""+obj.value+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserPrvlgToVeryEmailIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ); 
}
function clearReportId( docObj ) 
{
	var len = eval(docObj+".UserPrvlgToVeryEmailHdrForm.report_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".UserPrvlgToVeryEmailHdrForm.report_id.remove(\"report_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".UserPrvlgToVeryEmailHdrForm.report_id.add(opt)") ;
}
function addReportId(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.UserPrvlgToVeryEmailHdrForm.report_id.add(element);
}
function populateFormVals(){
	var module_id = document.UserPrvlgToVeryEmailHdrForm.module_id.value;
	var report_id = document.UserPrvlgToVeryEmailHdrForm.report_id.value;
	var searchText = document.UserPrvlgToVeryEmailHdrForm.search_text.value;
	var searchCriteria = document.UserPrvlgToVeryEmailHdrForm.search_criteria.value;
	var searchBy;

	if(document.UserPrvlgToVeryEmailHdrForm.radSearch[0].checked == true) 
		searchBy = document.UserPrvlgToVeryEmailHdrForm.radSearch[0].value;
	else if(document.UserPrvlgToVeryEmailHdrForm.radSearch[1].checked == true)
		searchBy = document.UserPrvlgToVeryEmailHdrForm.radSearch[1].value;


	if(module_id == '' || module_id == "")
	{
		 alert(getMessage("MODULE_CANT_BE_BLANK","SM"));
		 return
	}else if(report_id == '' || report_id == "")
	{
		 alert(getMessage("REPORT_CANT_BE_BLANK","CA"));
		 return
	}
	else
	{
		document.UserPrvlgToVeryEmailHdrForm.module_id.disabled = true;
		document.UserPrvlgToVeryEmailHdrForm.report_id.disabled = true;
		/******************/
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += "searchKey=\"dtlPage\" " ;
		xmlStr += "module_id=\""+module_id+"\" " ;
		xmlStr += "report_id=\""+report_id+"\" " ;
		xmlStr += "chkUnchk=\"Y\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "UserPrvlgToVeryEmailIntermediate.jsp",false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		/******************/
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.UserPrvlgToVeryEmailDtlFrame.location.href = '../../eCA/jsp/UserPrvlgToVeryEmailDtl.jsp?module_id='+module_id+'&report_id='+report_id+'&searchBy='+searchBy+'&searchText='+searchText+'&searchCriteria='+searchCriteria;
	 }

}
function addIDToBean(selObj,userID)
 {
	var chkUnchk = "";
	if(selObj.checked == true)
		  chkUnchk = "Y";
	else
		  chkUnchk = "N";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "searchKey=\"chkUnchkItem\" " ;
	xmlStr += "chkUnchk=\""+chkUnchk+"\" " ;
	xmlStr += "userID=\""+userID+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "UserPrvlgToVeryEmailIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );

 }
function chkObj(obj){
if(obj.checked==true){

	obj.value ="Y";
}else
	obj.vlaue="N";
}

function apply()
{	
	if(f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.document.UserPrvlgToVeryEmailDtlForm !=null){
	var fields = new Array (f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.document.UserPrvlgToVeryEmailDtlForm.module_id,f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.document.UserPrvlgToVeryEmailDtlForm.report_id);

	var names = new Array ( getLabel("Common.Module.label","COMMON"),
							getLabel("Common.report.label","COMMON"));

	if(f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.document.UserPrvlgToVeryEmailDtlForm != null)
	 {
		if(f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.document.UserPrvlgToVeryEmailDtlForm.submit();
		}
	 }
	}else{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}
function onSuccess()
{	

	f_query_add_mod.UserPrvlgToVeryEmailHdrFrame.location.href="../../eCA/jsp/UserPrvlgToVeryEmailHdr.jsp";
	f_query_add_mod.UserPrvlgToVeryEmailDtlFrame.location.href="../../eCommon/html/blank.html"

}
