function validSplchars(obj){	
	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Patient ID";									
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else{
		obj.select();
		obj.focus();
		parent.frames[2].location = "../../eCommon/html/blank.html";
		return false;
	}
}
function validatePatientId(obj){
	
	var patId = obj.value;
	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatId' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(responseText!=""){
			var msg = getMessage("INVALID_PATIENT","MP");
			alert(msg);
			obj.select();
			obj.focus();
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}
	}
}
function showLookUp(val){
    
	if(val == 'P'){
		var patientid=PatientSearch('','','','','','','Y','','','OTHER');
		if(patientid != null)
			document.getElementById("patient_id").value = patientid;
    }
}
function doDateValidations(obj){
	if(obj.value!=''){
		if(validDateObj(obj,'DMY',localeName)){
			chkWithCurrDate(obj);
		}else{
			parent.frames[2].location = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ; 
		}	
	}
}
function chkWithCurrDate(obj){
	
	if(obj.value!=''){
		
		if(isBeforeNow(TrimStr(obj.value),"DMY",localeName)){
			return true ;
		}else{
			var msg			= getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;
			var trnDate		= "";
			if (obj.name=='trn_from_date')
				trnDate		= (getLabel("Common.from.label","Common")+" "+getLabel("Common.TransactionDate.label","Common"));
			else if(obj.name=='trn_to_date')
				trnDate		= (getLabel("Common.to.label","Common")+" "+getLabel("Common.TransactionDate.label","Common"));
			var currDate	= getLabel("Common.CurrentDate.label","Common");	
			msg				= msg.replace('$',trnDate);
			msg				= msg.replace('#',currDate);
			alert(msg);
			obj.select();
			obj.focus();
			parent.BackDatedConsResult.location.href="../../eCommon/html/blank.html" ;
			return false ;
		}
	}			
}
function dispResult(){
	
	var fields = new Array(document.forms[0].trn_from_date,document.forms[0].trn_to_date);
	var names  = new Array(getLabel("Common.from.label","Common")+" "+getLabel("Common.TransactionDate.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.TransactionDate.label","Common"));	
	if(checkFields(fields, names, parent.messageFrame)){
		
		if(isBefore(document.forms[0].trn_from_date.value, document.forms[0].trn_to_date.value, "DMY", localeName ) ){
			var patientId		= document.forms[0].patient_id.value;
			var trn_from_date	= document.forms[0].trn_from_date.value;
			var trn_to_date		= document.forms[0].trn_to_date.value;
			parent.BackDatedConsResult.location.href	= '../../eAE/jsp/AEQueryBackdatedConsResult.jsp?&patient_id='+patientId+'&trn_from_date='+trn_from_date+'&trn_to_date='+trn_to_date+'';
			parent.messageFrame.location.href			= '../../eCommon/jsp/error.jsp';
		}else{
			var str		= getLabel("Common.TransactionDate.label","Common");
			var error	= getMessage("REMARKS_MUST_GR_EQUAL","common");
			error		= error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error		= error.replace("#",str);
			parent.BackDatedConsResult.location.href="../../eCommon/html/blank.html" ;
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
	}else{
		parent.BackDatedConsResult.location.href="../../eCommon/html/blank.html" ;
	}
}
function reset(){
	parent.frames[2].location.reload();
}
function clearResult(){
	parent.BackDatedConsResult.location.href="../../eCommon/html/blank.html" ;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ; 
}
