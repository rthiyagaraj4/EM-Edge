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
async function showLookUp(val){
    
	if(val == 'P'){
		var patientid= await PatientSearch('','','','','','','Y','','','OTHER');
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
			var modDate		= "";
			if (obj.name=='mod_from_date')
				modDate		= (getLabel("Common.from.label","Common")+" "+getLabel("Common.Modified.label","Common")+" "+getLabel("Common.date.label","Common"));
			else if(obj.name=='mod_to_date')
				modDate		= (getLabel("Common.to.label","Common")+" "+getLabel("Common.Modified.label","Common")+" "+getLabel("Common.date.label","Common"));
			var currDate	= getLabel("Common.CurrentDate.label","Common");	
			msg				= msg.replace('$',modDate);
			msg				= msg.replace('#',currDate);
			alert(msg);
			obj.select();
			obj.focus();
			parent.MedRepAuditResult.location.href="../../eCommon/html/blank.html" ;
			return false ;
		}
	}			
}
function dispResult(){
	
	var fields = new Array(document.forms[0].mod_from_date,document.forms[0].mod_to_date);
	var names  = new Array(getLabel("Common.from.label","Common")+" "+getLabel("Common.Modified.label","Common")+" "+getLabel("Common.date.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.Modified.label","Common")+" "+getLabel("Common.date.label","Common"));	
	if(checkFields(fields, names, parent.messageFrame)){
		
		if(isBefore(document.forms[0].mod_from_date.value, document.forms[0].mod_to_date.value, "DMY", localeName ) ){
			var patientId		= document.forms[0].patient_id.value;
			var mod_from_date	= document.forms[0].mod_from_date.value;
			var mod_to_date		= document.forms[0].mod_to_date.value;
			parent.MedRepAuditResult.location.href	= '../../eMR/jsp/MRQueryMedRepAuditResult.jsp?&patient_id='+patientId+'&mod_from_date='+mod_from_date+'&mod_to_date='+mod_to_date+'';
			parent.messageFrame.location.href			= '../../eCommon/jsp/error.jsp';
		}else{
			var str		= getLabel("Common.Modified.label","Common")+" "+getLabel("Common.date.label","Common");
			var error	= getMessage("REMARKS_MUST_GR_EQUAL","common");
			error		= error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error		= error.replace("#",str);
			parent.MedRepAuditResult.location.href="../../eCommon/html/blank.html" ;
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
	}else{
		parent.MedRepAuditResult.location.href="../../eCommon/html/blank.html" ;
	}
}
function reset(){
	parent.frames[2].location.reload();
}
function clearResult(){
	parent.MedRepAuditResult.location.href="../../eCommon/html/blank.html" ;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ; 
}
