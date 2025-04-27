//Patient Search from common.js
function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}
function DateCheck(from,to) {

    /*var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
      			fromarray = fromdate.split("/");

			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;

                alert(invaldt);
				to.select();
                to.focus();
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';
            return false; 
 

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
	*/
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
	//ADDEd by Naveen
	/*if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}*/
return true;
}
function validate_date(Obj,ref) {
                
	/*if (CheckDate1(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_disp_date_from;
	  to = document.forms[0].p_disp_date_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');

	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');

	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			  from.select();
               from.focus();
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

 		   // from.focus();
		     return false;

		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {

	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}

	return true;
}*/
//ADDED By Naveen
if(document.forms[0].p_disp_date_from.value=='' || document.forms[0].p_disp_date_to.value=='')
{ 
					return false;
}
else{
	if(!isBefore(document.forms[0].p_disp_date_from.value,document.forms[0].p_disp_date_to.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}
}
	return true;
}
function reset() {
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].print.disabled=true;
	f_query_results.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function resetLocation(){
	var formObj = parent.f_query_add_mod.document.forms[0];  
	formObj.locn_code.value="";
	formObj.locn_name.value="";
}
function locationLookup(target){
	var formObj = parent.f_query_add_mod.document.forms[0];

	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = CommonLookup(getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
function showResult(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var adr_reported_date_from="";
	var adr_reported_date_to ="";
	var locale = formObj.language_id.value;
	var patient_id = formObj.p_patient_id.value;
	adr_reported_date_from = formObj.p_disp_date_from.value;
	adr_reported_date_from=convertDate(adr_reported_date_from,"DMY",locale); 
	adr_reported_date_to = formObj.p_disp_date_to.value;
	adr_reported_date_to=convertDate(adr_reported_date_to,"DMY",locale); 
	var p_fr_pre = formObj.p_fr_pre.value;
	var p_to_pre = formObj.p_to_pre.value;
	var token_no_from = formObj.token_no_from.value;
	var token_no_to= formObj.token_no_to.value;
	var p_encounter= formObj.p_encounter.value;
	var p_disp_locn_code= formObj.p_disp_locn_code.value;
	var locn_type = formObj.locn_type.value;
	var locn_code = formObj.locn_code.value;

//================================================================================================================
if(document.forms[0].p_disp_date_from.value!='' && document.forms[0].p_disp_date_to.value!='')
{ 
					
	if(!isBefore(formObj.p_disp_date_to.value,formObj.currentdate.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(formObj.p_disp_date_from.value,formObj.p_disp_date_to.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}
}
//=====================================================================================================================	

	bean_id		  =	parent.f_query_add_mod.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_add_mod.document.forms[0].bean_name.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=CLEAR",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);  

    var fields = new Array (formObj.p_disp_date_from,formObj.p_disp_date_to);
	var names= new Array (getLabel("ePH.DispensedDateFrom.label","PH"), getLabel("ePH.DispensedDateTo.label","PH"));
		if(checkFields(fields,names,parent.messageFrame)) 
		{
		
					

		if(parent.f_query_add_mod.CheckString1("PrescriptionID", parent.f_query_add_mod.document.formSRRCertificateforReimbursement.p_fr_pre,parent.f_query_add_mod.document.formSRRCertificateforReimbursement.p_to_pre, parent.messageFrame) )					
				{
	   if(parent.f_query_add_mod.CheckString1("Token No", parent.f_query_add_mod.document.formSRRCertificateforReimbursement.token_no_from,parent.f_query_add_mod.document.formSRRCertificateforReimbursement.token_no_to, parent.messageFrame) )					
				{
					parent.f_query_results.location.href="../../ePH/jsp/SRRCertificateforReimbursementQueryResult.jsp?patient_id="+patient_id+"&locale="+locale+"&adr_reported_date_from="+adr_reported_date_from+"&adr_reported_date_to="+adr_reported_date_to+"&p_fr_pre="+p_fr_pre+"&p_to_pre="+p_to_pre+"&token_no_from="+token_no_from+"&token_no_to="+token_no_to+"&p_encounter="+p_encounter+"&p_disp_locn_code="+p_disp_locn_code+"&locn_type="+locn_type+"&locn_code="+locn_code;
					formObj.print.disabled=false;
		            parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			}else{
				
              formObj.print.disabled=true;

			}
		
         }else{
			 
			formObj.print.disabled=true;

		 }
				
	}else{
		
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	}

}
function isValidFromToField(fromObj, toObj){
	var bReturn	= true;
	var stFromValue	=	fromObj.value;
	var stToValue	=	toObj.value;

	if(stFromValue!="" && stToValue!="")
	{
	   var arFromDate	= stFromValue.split(":");
       var arToDate	= stToValue.split(":");
		if( parseInt(arFromDate[0]) > parseInt(arToDate[0]))
		{
			bReturn=false;
		}
	    if ( (!bReturn) ){
		var phMessage	=	"PrescriptionID To  should be greater than or equal to PrescriptionID From "
		alert(phMessage);
		toObj.select();
		toObj.focus();
	}
	return bReturn;
	
	}
}

function SubmitLink(from,to,patient_id,p_fr_pre,p_to_pre,adr_reported_date_from,adr_reported_date_to,p_encounter,p_disp_locn_code,token_no_from,token_no_to,locn_type,locn_code){
	var obj=parent.f_query_results.document.forms[0];


	obj.from.value=from;
	obj.to.value=to;

   

	obj.patient_id.value=patient_id;
	obj.adr_reported_date_from.value=adr_reported_date_from;
	obj.adr_reported_date_to.value=adr_reported_date_to;
	obj.p_encounter.value=p_encounter;
	obj.token_no_from.value=token_no_from;
	obj.token_no_to.value=token_no_to;
	obj.p_fr_pre.value=p_fr_pre;
	obj.p_to_pre.value=p_to_pre;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.locn_type.value=locn_type;
	obj.locn_code.value=locn_code;
	obj.submit();
}
function chkall(formObject) {
	var allElements = formObject.elements;
	var ischecked = formObject.selectall_yn.checked;
	var prescription_id = "";
	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;			
			index = objName.substring(objName.lastIndexOf("_yn")+3,objName.length);			
			allElements[i].checked = ischecked;
			val = eval("document.SRRCertiforReimbursementQueryResultForm.prescription_"+index).value;
			if (prescription_id == "")
				prescription_id =val+"#"+index;
			else
				prescription_id =prescription_id+"~"+val+"#"+index;		
		}
	}

	if (formObject.selectall_yn.checked)
	{
		mode = "ADD_ELEMENT_ALL";
	}else{
		mode = "REMOVE_ELEMENT_ALL";
	}

	bean_id		  =	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";	
	xmlStr += " prescription_id=\""+prescription_id+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);  
	
}
 function assignValue(obj){
	if(obj.checked==true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
} 

function calvalidation(obj,facility_id,record_cnt,pre_id){

	
	var k=0;
	var formObjcheck	 = parent.f_query_results.document.forms[0];
		prescription_id =pre_id+"#"+record_cnt;

	var checked_yn ="N";
	   if (obj.checked){
	//	checked_yn ="Y";
		this.value = "Y";
		mode = "ADD_ELEMENT"
	   }else{
	//	checked_yn ="N";
		this.value = "N";
		mode = "REMOVE_ELEMENT"
	   }
	  
	bean_id		  =	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr += " record_cnt=\""+record_cnt+"\"";
	//xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " prescription_id=\""+prescription_id+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_CERTIFREIMBURSEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);  
}

function showPrint(facility_id){
var cnt=0;
   Obj=parent.f_query_results.document.forms[0];
	elements=   Obj.elements
   for (i = 1; i < elements.length; i++) {

		if (elements[i].type == "checkbox") {
			if (elements[i].checked)
			{
				cnt++;
			}
		}	
		
		}
	if (cnt == 0)  
	{
	 var Msg=getMessage("NO_RECORDS_FOR_PRINT",'PH');
	 alert(Msg);
	 return false;
	} 

 	bean_id		  =	parent.f_query_results.document.forms[0].bean_id.value;
	bean_name       =	parent.f_query_results.document.forms[0].bean_name.value;

	 


	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
//	xmlStr += " record_cnt=\""+record_cnt+"\"";
//	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=PRINT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);   
	parent.f_query_add_mod.document.formSRRCertificateforReimbursement.search.click(); //Added by Naveen for the incident num:23238 in spira on 2/sep/2010

 

	
}
function CheckString1(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(parseInt(fromobj.value) <= parseInt(toobj.value)) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

            return false;
        }
    }
    else {
        return true;
    }
}
 function CheckDate1(Object2,focusflag) {

	 var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}


    if (ChkDate(Object2) == false) {
        alert(getMessage("INVALID_DATE_FMT", "SM"));
		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

        if (datefield.value != undefined && focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}

