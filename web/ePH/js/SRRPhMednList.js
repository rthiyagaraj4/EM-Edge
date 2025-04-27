function showResults(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";
	var locale = formObj.language_id.value;
	var patient_id = formObj.p_patient_id.value;
	var p_pres_id = formObj.p_pres_id.value;
	var p_encounter= formObj.p_encounter.value;

	var p_disp_locn_code = formObj.p_disp_locn_code.value;
	var p_locn_type = formObj.p_locn_type.value;

	var p_locn_code = formObj.locn_code.value;
	var p_tokfr = formObj.p_tokfr.value;
	
	var p_tokto = formObj.p_tokto.value;

	var p_fill_id = formObj.p_fill_id.value;

	var p_fr_disp_date = formObj.p_fr_disp_date.value;
	fr_dispdate=convertDate(p_fr_disp_date,"DMY",locale); 
	var p_to_disp_date = formObj.p_to_disp_date.value;
	to_dispdate=convertDate(p_to_disp_date,"DMY",locale); 

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
	
	
	var fields = new Array (formObj.p_fr_disp_date,formObj.p_to_disp_date,formObj.p_disp_locn_code);
	var names= new Array (getLabel("ePH.DispensedDateFrom.label","PH"), getLabel("ePH.DispensedDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{ 

		//Addedd=================================================================================

if(!isBefore(formObj.p_to_disp_date.value,formObj.currentdate.value,"DMY",document.forms[0].p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}

    if(!isBefore(formObj.p_fr_disp_date.value,formObj.p_to_disp_date.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
	}

	//Ends==============================================================
		if(parent.f_query_add_mod.CheckString1("TokenNo./DailySeqNo", parent.f_query_add_mod.document.SRRPhMednListCriteriaForm.p_tokfr,parent.f_query_add_mod.document.SRRPhMednListCriteriaForm.p_tokto, parent.messageFrame) )					
				{
		if(doDateCheck(formObj.p_fr_disp_date,formObj.p_to_disp_date,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRPhMednListResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_dispdate="+fr_dispdate+"&to_dispdate="+to_dispdate+"&p_pres_id="+p_pres_id+"&p_tokto="+p_tokto+"&p_tokfr="+p_tokfr+"&p_disp_locn_code="+p_disp_locn_code+"&p_locn_code="+p_locn_code+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter+"&p_fill_id="+p_fill_id;
		formObj.print.disabled=false;
		parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp";
				}else{
		formObj.print.disabled=true;

				}

	 }else{
	  parent.f_query_results.location.href='../../eCommon/html/blank.html';
	 }

       
}
function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}
function DateCheck(from,to) {

   /* var fromarray;
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
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

                to.select();
                to.focus();
				return false;

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
	/*if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
	}*/
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
    return true;
}
function validate_date(Obj,ref) {
                

	/*if (CheckDate1(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_to_disp_date;
	  to = document.forms[0].p_fr_disp_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_disp_date;
	  to = document.forms[0].p_to_disp_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_to_disp_date;
	  to = document.forms[0].p_fr_disp_date;
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
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';
            from.select();
 		    from.focus();
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}*/
if(document.forms[0].p_fr_disp_date.value=='' || document.forms[0].p_to_disp_date.value=='')
{ 
					return false;
}
else{
	if(!isBefore(document.forms[0].p_fr_disp_date.value,document.forms[0].p_to_disp_date.value,"DMY",document.forms[0].p_language_id.value)) {
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
	var formObj = document.frames.SRRPhMednListCriteriaForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}



function locationLookup(target){
	var formObj = document.frames.SRRPhMednListCriteriaForm;
	var p_locn_type=formObj.p_locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (p_locn_type!=""){
		if (p_locn_type=="N"){
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
		}else if (p_locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
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
		}
	}else{
		formObj.p_locn_type.focus()
	}
}


function SubmitLink(from,to,patient_id,p_fr_pre,fr_dispdate,to_dispdate,p_encounter,p_disp_locn_code,p_tokfr,p_tokto,locn_type,p_locn_code,p_fill_id){
	var obj=parent.f_query_results.document.forms[0];


	obj.from.value=from;
	obj.to.value=to;
 	obj.patient_id.value=patient_id;
	obj.fr_dispdate.value=fr_dispdate;
	obj.to_dispdate.value=to_dispdate;
	obj.p_encounter.value=p_encounter;
	obj.p_tokto.value=p_tokto;
	obj.p_tokfr.value=p_tokfr;
	obj.p_fr_pre.value=p_fr_pre;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.locn_type.value=locn_type;
	obj.p_locn_code.value=p_locn_code;
	obj.p_fill_id.value=p_fill_id;
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
			val = eval("document.SRRPhMednListResultForm.prescription_"+index).value;
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
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_MEDICATION",false);
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

//alert("Inside calvalidation==obj===294===>" +obj.value+ "facility_id===|" +facility_id+ "|====record_cnt====|" +record_cnt+ "|==pre_id==|" +pre_id);	
	var k=0;
	var formObjcheck	 = parent.f_query_results.document.forms[0];
				prescription_id =pre_id+"#"+record_cnt;

	   if (obj.checked){
		this.value = "Y";
		mode = "ADD_ELEMENT"
	   }else{
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
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=RECORDS_FOR_MEDICATION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);  
}
function showPrint(facility_id){
//alert("inside showPrint=====325==>" +facility_id);
	var ResultObj = parent.f_query_results.document.forms[0];

	var allElements = ResultObj.elements;
	var cnt = 0;
	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			if (allElements[i].checked)
			{
				cnt++;
			}
		 }
		}

	if (cnt == 0)  
	{
	alert("APP-ST0178 Atleast one Record should be selected");
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
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=PRINT_FOR_MEDICATION",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);         
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
