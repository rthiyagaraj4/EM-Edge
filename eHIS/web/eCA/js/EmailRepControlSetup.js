var messageFrameReference = parent.parent.messageFrame;
function reset() 
{
	f_query_add_mod.EmailRepControlSetupHdrFrame.document.forms[0].reset();
	f_query_add_mod.EmailRepControlSetupDtlFrame.document.forms[0].reset();

}
function populateReportId(obj){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "module_id=\""+obj.value+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EmailRepControlSetupIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
function clearReportId( docObj ) 
{
	var len = eval(docObj+".EmailRepControlSetupHdrForm.report_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".EmailRepControlSetupHdrForm.report_id.remove(\"report_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".EmailRepControlSetupHdrForm.report_id.add(opt)") ;
}
function addReportId(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.EmailRepControlSetupHdrForm.report_id.add(element);
}
function populateFormVals(module_id,report_id){
//if(module_id !=null && module_id.value!="" && report_id !=null && report_id.value!="")
//{
	parent.EmailRepControlSetupDtlFrame.location.href="../../eCA/jsp/EmailRepControlSetupDtl.jsp?module_id="+module_id.value+"&report_id="+report_id.value;	
	messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="; //Bru-HIMS-CRF-024 [IN030465]
//}
}

function chkObj(obj){
if(obj.checked==true){

	obj.value ="Y";
}else
	obj.value="N";
}

function apply()
{
	 var status = "";
	if(f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.email_to_pat_id_yn){
		if(f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.email_to_pat_id_yn.value== 'Y' || f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.email_to_regd_id_yn.value== 'Y' || f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.email_to_any_id_yn.value== 'Y'){
			status = "S";  
		}else{
			status = "F"; 
	    }
	}
		
	if(f_query_add_mod.EmailRepControlSetupHdrFrame.document.EmailRepControlSetupHdrForm != null){
		var fields = new Array (f_query_add_mod.EmailRepControlSetupHdrFrame.document.EmailRepControlSetupHdrForm.module_id,f_query_add_mod.EmailRepControlSetupHdrFrame.document.EmailRepControlSetupHdrForm.report_id);
		var names = new Array ( getLabel("Common.Module.label","COMMON"),getLabel("Common.report.label","COMMON"));
		//Bru-HIMS-CRF-024 Start.[IN030465]
		var module_id = f_query_add_mod.EmailRepControlSetupHdrFrame.document.EmailRepControlSetupHdrForm.module_id.value;
		var report_id = f_query_add_mod.EmailRepControlSetupHdrFrame.document.EmailRepControlSetupHdrForm.report_id.value;
		var recipients_id = f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.email_to_pat_id_yn.value;
		//IN044085 Start.
		//if(module_id=="CA" && report_id=="CANFREP"){
		if(module_id=="CA" && report_id!="AHCLINREP"){
		//IN044085 End.
			if(recipients_id==""){
				var errorMessage = "";
				errorMsg = getMessage("MIN_ONE_EMAILID_SEL_REQ","CA");
				messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
				commontoolbarFrame.location.reload();
				return false;
			}		
		}
		//if(f_query_add_mod.EmailRepControlSetupDtlFrame.checkFieldsofMst( fields, names, messageFrame)) {
		if(f_query_add_mod.EmailRepControlSetupDtlFrame.checkFieldsofMst( fields, names, messageFrameReference)) {
		//Bru-HIMS-CRF-024 End.[IN030465]			
			if(status == "F"){
			   var errorMessage = "";
			   errorMsg = getMessage("MIN_ONE_EMAILID_SEL_REQ","CA");
			   messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg //Bru-HIMS-CRF-024 [Ramesh]
			   commontoolbarFrame.location.reload();
			   return false;		 
			}else{
				f_query_add_mod.EmailRepControlSetupDtlFrame.document.EmailRepControlSetupDtlForm.submit();    
			}
		}
	}
}
function onSuccess()
{	
	f_query_add_mod.location.reload();	

}


function checkdefault(obj)
{
var object_id = obj.id;
 if(obj.checked == true)
 {
	if(object_id == 'AP')
	{ 
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.pat_body_text_ref.disabled=false;
		document.EmailRepControlSetupDtlForm.email_to_pat_id_yn1.value="Y";
	}
	else if(object_id == 'AR')
	{
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.disabled=false;
		document.EmailRepControlSetupDtlForm.email_to_regd_id_yn1.value="Y";
		//Bru-HIMS-CRF-024 Start.[IN030465]
		//IN044085 Start.
		//if(document.EmailRepControlSetupDtlForm.module_id.value=="CA" && document.EmailRepControlSetupDtlForm.report_id.value=="CANFREP"){
		if(document.EmailRepControlSetupDtlForm.module_id.value=="CA" && document.EmailRepControlSetupDtlForm.report_id.value!="AHCLINREP"){
		//IN044085 End.
			document.getElementById("ATRNF").style.display = '';
			document.getElementById("ATRNF1").style.display = '';
		}		
		//Bru-HIMS-CRF-024 End.[IN030465]
	}
	else if(object_id == 'AE')
	{
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.any_id_body_text_ref.disabled=false;
		document.EmailRepControlSetupDtlForm.email_to_any_id_yn1.value="Y";
	}
 }else{
	if(object_id == 'AP'){
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.checked=false;
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.disabled=true;
		document.EmailRepControlSetupDtlForm.pat_body_text_ref.checked=false;
		document.EmailRepControlSetupDtlForm.pat_body_text_ref.value="";
		document.EmailRepControlSetupDtlForm.pat_body_text_ref.disabled=true;
		document.EmailRepControlSetupDtlForm.email_to_pat_id_yn1.value="N";
	}else if(object_id == 'AR'){
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.checked=false;
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.disabled=true;
		document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.checked=false;
		document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.value="";
		document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.disabled=true;
		document.EmailRepControlSetupDtlForm.email_to_regd_id_yn1.value="N";
		//Bru-HIMS-CRF-024 Start.[IN030465]
		//IN044085 Start.
		//if(document.EmailRepControlSetupDtlForm.module_id.value=="CA" && document.EmailRepControlSetupDtlForm.report_id.value=="CANFREP"){
		if(document.EmailRepControlSetupDtlForm.module_id.value=="CA" && document.EmailRepControlSetupDtlForm.report_id.value!="AHCLINREP"){
		//IN044085 End.
			document.getElementById("ATRNF").style.display = 'none';
			document.getElementById("ATRNF1").style.display = 'none';
			document.EmailRepControlSetupDtlForm.recipients_id.value="";
		}
		//Bru-HIMS-CRF-024 End.[IN030465]
	}else if(object_id == 'AE'){
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.checked=false;
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.disabled=true;
		document.EmailRepControlSetupDtlForm.any_id_body_text_ref.checked=false;
		document.EmailRepControlSetupDtlForm.any_id_body_text_ref.value="";
		document.EmailRepControlSetupDtlForm.any_id_body_text_ref.disabled=true;
		document.EmailRepControlSetupDtlForm.email_to_any_id_yn1.value="N";
	}
 }
}

function Assigndefault(obj)
{
	var object_id = obj.id;
   if(obj.checked == true)
   {
	if(object_id == 'APD'){
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.value="Y";
	}
	else if(object_id == 'ARD'){
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.value="Y";	
	}
	else if(object_id == 'AED'){
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.disabled=false;
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.value="Y";
	}
	else if(object_id == 'APD1'){
		document.EmailRepControlSetupDtlForm.pat_body_text_ref.disabled=false;
		//document.EmailRepControlSetupDtlForm.pat_body_text_ref.value="Y";
	}
	else if(object_id == 'ARD1'){
		document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.disabled=false;
		//document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.value="Y";
	}
	else if(object_id == 'AED1'){
		document.EmailRepControlSetupDtlForm.any_id_body_text_ref.disabled=false;
		//document.EmailRepControlSetupDtlForm.any_id_body_text_ref.value="Y";
	}
   }
   else
   {
	
	  if(object_id == 'APD'){
		document.EmailRepControlSetupDtlForm.very_reqd_pat_yn.value="N";
	}
	else if(object_id == 'ARD'){
		document.EmailRepControlSetupDtlForm.very_reqd_regd_id_yn.value="N";	
	}
	else if(object_id == 'AED'){
		document.EmailRepControlSetupDtlForm.very_reqd_any_id_yn.value="N";
	}
	//else if(object_id == 'APD1'){
		//document.EmailRepControlSetupDtlForm.pat_body_text_ref.value="N";
	//}
	//else if(object_id == 'ARD1'){
		//document.EmailRepControlSetupDtlForm.regd_id_body_text_ref.value="N";
	//}
	//else if(object_id == 'AED1'){
		//document.EmailRepControlSetupDtlForm.any_id_body_text_ref.value="N";
	//}
   }
}

async function disclaimerText()
{
	var disclimer_id = document.forms[0].disclimer_id.value;
	var dialogHeight ='12' ;
	var dialogWidth = '30' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal = await window.showModalDialog("../../eCA/jsp/NoteTypeDisclaimerView.jsp?rem='"+disclimer_id+"'",arguments,features);
	
}
//Bru-HIMS-CRF-024 Start.[IN030465]
async function getRecipientsId(){	
	var dialogHeight ='32' ;
	var dialogWidth = '30' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var retVal =await  window.showModalDialog("../../eCA/jsp/EmailRecipientsControl.jsp?recipients_id="+document.EmailRepControlSetupDtlForm.recipients_id.value,arguments,features);
	if(retVal!=undefined){
		
		document.EmailRepControlSetupDtlForm.recipients_id.value=retVal;
	}
} 
function CheckForSpeChar(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = '`~!@#$%^&*()_+={[]}|;"\'<,.>?';
	var whichCode = (window.event)==null ? event.which : event.keyCode;	
	key = String.fromCharCode(whichCode);  // Get key value from key code	
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}
//Bru-HIMS-CRF-024 End.[IN030465]
