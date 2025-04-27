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
	//ADDED=======================================================================================	
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
	//=========================================================================================
	

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
	}
	return true;
}*/
//===============================================================================================================================
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

	  	f_query_results.document.location.href="../../eCommon/html/blank.html"
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

			var retVal = await CommonLookup( getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
}
function searchPractitionerName(obj) {
	var val = obj.value;
	if(val=="" || val == null)
		val ="";

	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var lan_id=document.SRRPhDispLabelQueryCriteria.language_id.value;
	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= document.SRRPhDispLabelQueryCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= document.SRRPhDispLabelQueryCriteria.p_facility_id.value;
	dataTypeArray[1]	= STRING ;
	var sql = "SELECT DISTINCT A.PRACTITIONER_ID CODE,B.PRACTITIONER_NAME DESCRIPTION FROM AM_PRACT_FOR_FACILITY A,AM_PRACTITIONER_LANG_VW B,SM_FACILITY_FOR_USER C WHERE A.PRACTITIONER_ID=B.PRACTITIONER_ID  AND C.FACILITY_ID=A.FACILITY_ID  AND UPPER(APPL_USER_ID)LIKE UPPER(?) AND UPPER(A.FACILITY_ID) LIKE UPPER(?)  AND A.PRACTITIONER_ID LIKE UPPER(?) AND UPPER(B.PRACTITIONER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID ="+"'"+lan_id+"'";
	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = val;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.practitionerid.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
        	var formObj = parent.f_query_add_mod.document.forms[0];
			formObj.pract_code.value=returnedValues[0];
		     obj.value = returnedValues[1];
		}
}
function showResult(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var adr_reported_date_from="";
	var adr_reported_date_to ="";
	var locale = formObj.language_id.value;
	var patient_id = formObj.p_patient_id.value;
	adr_reported_date_from = formObj.p_disp_date_from.value;	adr_reported_date_from=convertDate(adr_reported_date_from,"DMY",locale); 
	adr_reported_date_to = formObj.p_disp_date_to.value;
	adr_reported_date_to=convertDate(adr_reported_date_to,"DMY",locale); 
	var prescription_id = formObj.prescription_id.value;
	var p_token_no_from = formObj.p_token_no_from.value;
	var p_token_no_to = formObj.p_token_no_to.value;
	var p_encounter= formObj.encounter_id.value;
	var pract_code= formObj.pract_code.value;
	var p_disp_locn_code= formObj.p_disp_locn_code.value;
	var locn_type = formObj.locn_type.value;
	var locn_code = formObj.locn_code.value; 
	var p_fill_id = formObj.p_fill_id.value; 
	var p_langue = formObj.p_langue.value; 
	var p_printall_yn = formObj.p_printall_yn.value; 
//Added=======
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

//Ends========================================

	var fields = new Array (formObj.p_patient_id,formObj.p_disp_date_from,formObj.p_disp_date_to,formObj.p_disp_locn_code);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.DispenseDateFrom.label","PH"), getLabel("Common.todate.label","Common"),getLabel("ePH.DispenseLocation.label","PH"));
	if(checkFields(fields,names,parent.messageFrame)) 
	{
			

if(parent.f_query_add_mod.CheckString1("TokenNo./DailySeqNo", parent.f_query_add_mod.document.SRRPhDispLabelQueryCriteria.p_token_no_from,parent.f_query_add_mod.document.SRRPhDispLabelQueryCriteria.p_token_no_to, parent.messageFrame) )					
				{
		parent.f_query_results.location.href="../../ePH/jsp/SRRPhDispLabelQueryResult.jsp?patient_id="+patient_id+"&locale="+locale+"&adr_reported_date_from="+adr_reported_date_from+"&adr_reported_date_to="+adr_reported_date_to+"&p_token_no_from="+p_token_no_from+"&p_token_no_to="+p_token_no_to+"&prescription_id="+prescription_id+"&pract_code="+pract_code+"&p_encounter="+p_encounter+"&p_disp_locn_code="+p_disp_locn_code+"&locn_type="+locn_type+"&locn_code="+locn_code+"&p_fill_id="+p_fill_id+"&p_langue="+p_langue+"&p_printall_yn="+p_printall_yn;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
				}
	    }else{
		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

		}

}
function assignValue()
{
	//alert(document.SRRPhDispLabelQueryCriteria.p_printall_yn.checked)
	if(document.SRRPhDispLabelQueryCriteria.p_printall_yn.checked==true)
	{
		parent.f_query_add_mod.document.forms[0].p_printall_yn.value="Y";

	}else{
		document.SRRPhDispLabelQueryCriteria.p_printall_yn.value="N";

		}
}


function SubmitLink(from,to,patient_id,p_token_no_from,p_token_no_to,adr_reported_date_from,adr_reported_date_to,p_encounter,p_disp_locn_code,pract_code,prescription_id,locn_type,locn_code,p_fill_id){

	var obj=parent.f_query_results.document.forms[0];


	obj.from.value=from;
	obj.to.value=to;


    obj.patient_id.value=patient_id;
	obj.adr_reported_date_from.value=adr_reported_date_from;
	obj.adr_reported_date_to.value=adr_reported_date_to;
	obj.p_encounter.value=p_encounter;
	obj.p_token_no_from.value=p_token_no_from;
	obj.p_token_no_to.value=p_token_no_to;
	
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.locn_type.value=locn_type;
	obj.locn_code.value=locn_code;
	obj.pract_code.value=pract_code;
	obj.prescription_id.value=prescription_id;
	obj.p_fill_id.value=p_fill_id;
	obj.submit();
}

function showPrintReport(order_date,patient_id,order_id,func_name,p_disp_locn_code,p_token_dly_seq_no,p_langue){
		
	 if(func_name=="CR") {
		showCurrentRx(patient_id,'',order_date,'IP',order_id,p_disp_locn_code,p_token_dly_seq_no,p_langue);
	}
}
async function showCurrentRx(patient_id,encounter_id,order_date,pat_class,order_id,p_disp_locn_code,p_token_dly_seq_no,p_langue){
		
	encounter_id = "DUMMYENCOUNTERID";
	var dialogHeight	= "40vh" ;
	var dialogWidth		= "70vw" ;
	var dialogTop		= "250" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	
//	alert("=====|"+p_token_dly_seq_no+"2"+"|==========");	
	 if(escape(p_token_dly_seq_no)=='%A0') {
		p_token_dly_seq_no='';
	}
	//alert("../../ePH/jsp/SRRPrescriptionActiveOrderDetailsFrame.jsp?orderid="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&p_order_date="+order_date+"&patient_class="+pat_class+"&p_disp_locn_code="+p_disp_locn_code+"&p_langue="+p_langue+"&p_token_dly_seq_no="+trimString(p_token_dly_seq_no),arguments,features);
		retVal				=await window.showModalDialog("../../ePH/jsp/SRRPrescriptionActiveOrderDetailsFrame.jsp?orderid="+order_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&p_order_date="+order_date+"&patient_class="+pat_class+"&p_disp_locn_code="+p_disp_locn_code+"&p_langue="+p_langue+"&p_token_dly_seq_no="+trimString(p_token_dly_seq_no),arguments,features);
}

 function assignValue_inner(obj){
	if(obj.checked==true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
} 

function calvalidation(formobj,obj,facility_id,record_cnt,pre_id){
	
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

     bean_id		  =	formobj.bean_id.value;
	bean_name       =	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
//	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " prescription_id=\""+prescription_id+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); //DRUG_MEDICAL

	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=DRUG_MEDICAL",false);
	xmlHttp.send(xmlDoc);

	eval(xmlHttp.responseText);   
}

function showPrint(formobj,facility_id){

	headerObj=parent.document.frames[0].activeOrderDetailsForm


	//orderid=headerObj.orderid.value
	//order_type=headerObj.order_type.value
	//	alert(order_type);
	var allElements = headerObj.elements;
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
	 var Msg=getMessage("NO_RECORDS_FOR_PRINT",'PH');
	 alert(Msg);
	 return false;
	}  

//alert("cnt====365==>" +cnt);
 	bean_id		  =	formobj.bean_id.value;
	bean_name       =	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
//	xmlStr += " record_cnt=\""+record_cnt+"\"";
//	xmlStr += " checked_yn=\""+checked_yn+"\""; 
	xmlStr +=" /></root>";
	//alert("xmlStr======377==>" +xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=PRINT_FOR_DRUG_MEDICAL",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	window.close();
}
function chkall_durg(formObject) {
//alert("Inside chkall_durg==>" +formObject.name);
		 var checked_yn ="N";


	var allElements = formObject.elements;
	var ischecked = formObject.selectall_yn.checked;
//	alert(ischecked);
	var prescription_id = "";

	for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			allElements[i].checked = ischecked;

          index = objName.substring(objName.lastIndexOf("_yn")+3,objName.length);
		  val =eval(formObject.name+".prescription_0").value;
			if (prescription_id == "")
				prescription_id =val+"#"+index;
			else
				prescription_id =prescription_id+"~"+val+"#"+index;		
		}
	}
    if (formObject.selectall_yn.checked)
	{
	  mode = "ADD_ELEMENT_ALL";
	  checked_yn ="Y";
	}else{
		checked_yn ="N";
	//	this.value = "N";
		mode = "REMOVE_ELEMENT_ALL"
	}

  prescription_id ="";

	bean_id		  =	formObject.bean_id.value;
	bean_name       =	formObject.bean_name.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " prescription_id=\""+prescription_id+"\"";
	//alert("xmlStr======429====>" +xmlStr);
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=DRUG_MEDICAL ",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText); 
	

}
function getallreusult(formObject,obj){
     var checked_yn ="N";

	if(obj.checked)
	{
       	  checked_yn ="Y";
		  obj.value="Y";
		  formObject.print.disabled=false;
	}
	else{
		  obj.value="N";
          formObject.print.disabled=true;
	  }
  
   mode = "ADD_ALL_RESULTQUERY_ELEMENT";

	bean_id		  =	formObject.bean_id.value;
	bean_name       =	formObject.bean_name.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=DRUG_MEDICAL",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);


}

function Print_All(formobj,facility_id){
//p_printall_yn
var disp_srl_no=parent.f_query_results.SRRPhDispLabelQueryResult.disp_srl_no.value;	//Added for SKR-SCF-0589[Inc:34387]
var dispdtl_no=parent.f_query_results.SRRPhDispLabelQueryResult.dispdtl_no.value;		//Added for SKR-SCF-0589[Inc:34387]
var order_line_status=parent.f_query_results.SRRPhDispLabelQueryResult.order_line_status.value;		//Added for SKR-SCF-0589[Inc:34387]
    
 p_printall_yn	=	formobj.p_printall_yn.value;
   if(p_printall_yn =='Y')
	{

    bean_id		  =	formobj.bean_id.value;
	bean_name       =	formobj.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " disp_srl_no=\""+disp_srl_no+"\"";//Added for SKR-SCF-0589[Inc:34387]
	xmlStr += " dispdtl_no=\""+dispdtl_no+"\"";//Added for SKR-SCF-0589[Inc:34387]
	xmlStr += " order_line_status=\""+order_line_status+"\"";//Added for SKR-SCF-0589[Inc:34387]
//	xmlStr += " mode=\""+mode+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRPhRepTokenSeriesValidation.jsp?validate=PRINT_ALL_RESULTQUERY_ELEMENT",false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);   
	}

}

function loadprint(formobj){
    formobj.print.disabled=true;
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
