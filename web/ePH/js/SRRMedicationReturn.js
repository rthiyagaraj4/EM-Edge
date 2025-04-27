 function showResults(){
	 var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";

	var locale = formObj.language_id.value;
	var patient_id = formObj.p_patient_id.value;
	var p_pres_id = formObj.p_pres_id.value;

	
	var p_encounter= formObj.p_encounter.value;
	var p_ret_doc_no= formObj.p_ret_doc_no.value;

	var p_ret_to_disp_locn_code = formObj.p_ret_to_disp_locn_code.value;
	var p_locn_type = formObj.p_locn_type.value;
	var p_locn_code = formObj.locn_code.value;

	var p_fr_retn_date = formObj.p_fr_retn_date1.value;
	//alert("formObj.p_fr_retn_date1.value=====>" +formObj.p_fr_retn_date1.value);
	fr_dispdate=convertDate(p_fr_retn_date,"DMY",locale); 
	var p_to_rtn_date = formObj.p_to_rtn_date1.value;
	to_dispdate=convertDate(p_to_rtn_date,"DMY",locale); 
	//Addedd=====================================
	if(document.forms[0].p_fr_retn_date1.value!='' && document.forms[0].p_to_rtn_date1.value!='')
	{ 
			if(!isBefore(formObj.p_to_rtn_date1.value,formObj.sysdate.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

		if(!isBefore(formObj.p_fr_retn_date1.value,formObj.p_to_rtn_date1.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}
	}
	
	
	var fields = new Array (formObj.p_patient_id,formObj.p_fr_retn_date1,formObj.p_to_rtn_date1);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.ReturnDateFrom.label","PH"), getLabel("ePH.ReturnDateTo.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{
		
		if(doDateCheck(formObj.p_fr_retn_date1,formObj.p_to_rtn_date1,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRphMedicationReturnResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_retndate="+fr_dispdate+"&to_retndate="+to_dispdate+"&p_locn_code="+p_locn_code+"&p_ret_doc_no="+p_ret_doc_no+"&p_pres_id="+p_pres_id+"&p_ret_to_disp_locn_code="+p_ret_to_disp_locn_code+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	}

}
function callPatientLookup(){

	var formObj = parent.f_query_add_mod.document.forms[0];
	//alert("formObj=====>" +formObj.name);
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_patient_id.value = patient_id;
		formObj.p_patient_id.focus();
     }
}

function resetLocation(){
	var formObj = document.frames.SRRPhMedicationnReturnCriteriaForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}

function locationLookup(target){
	//alert("SRRPhMedicationnReturnCriteriaForm");
	var formObj = document.frames.SRRPhMedicationnReturnCriteriaForm;
	//alert("formObj==>" +formObj.name);
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

			var retVal = await CommonLookup(  getLabel("Common.Location.label","Common"), argumentArray );
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

			var retVal = await CommonLookup(  getLabel("Common.Location.label","Common"), argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.p_locn_type.focus()
	}
}
function DateCheck(from,to) {

    if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
    return true;
}
function validate_date(Obj,ref) {
    //alert("Obj=================127===>" +Obj.value+ "ref=====127==>" +ref);           

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_to_rtn_date1;
	  to = document.forms[0].p_fr_retn_date1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_retn_date1;
	  to = document.forms[0].p_to_rtn_date1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
		alert("1");
	  from = document.forms[0].p_to_rtn_date1;
	  to = document.forms[0].p_fr_retn_date1;
	  alert("from========150===>" +from.value);
	  alert("to========150===>" +to.value);
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
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/
//alert("document.forms[0].p_fr_retn_date1.value====177==="+ document.forms[0].p_fr_retn_date1.value);
//alert("document.forms[0].p_to_rtn_date1.value====178==="+ document.forms[0].p_to_rtn_date1.value);
/*if(!isBefore(document.forms[0].p_fr_retn_date1.value,document.forms[0].p_to_rtn_date1.value,"DMY",document.forms[0].p_language_id.value)) {
			//alert("document.forms[0].p_fr_retn_date1.value====179==="+ document.forms[0].p_fr_retn_date1.value);
			//alert("document.forms[0].p_to_rtn_date1.value====180==="+ document.forms[0].p_to_rtn_date1.value);
			if(document.forms[0].p_to_rtn_date1.value=='')
			return false;

	
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}*/
	if(document.forms[0].p_fr_retn_date1.value=='' || document.forms[0].p_to_rtn_date1.value=='')
	{ 
					return false;
	}
	else{
		if(!isBefore(document.forms[0].p_fr_retn_date1.value,document.forms[0].p_to_rtn_date1.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}
	return true;
}
function reset() {
		f_query_add_mod.document.forms[0].reset();
		f_query_results.document.location.href="../../eCommon/html/blank.html"
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

}

function SubmitLink(from,to,patient_id,p_pres_id,fr_retndate,to_retndate,p_encounter,p_ret_to_disp_locn_code,p_locn_type,p_locn_code){
	var obj=document.frames.SRRPhMedicationnReturnResult;
	
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.p_pres_id.value=p_pres_id;
	obj.fr_retndate.value=fr_retndate;
	obj.to_retndate.value=to_retndate;
	obj.p_encounter.value=p_encounter;
	obj.p_ret_to_disp_locn_code.value=p_ret_to_disp_locn_code;
	obj.p_locn_type.value=p_locn_type;
	obj.p_locn_code.value=p_locn_code;
	obj.submit();
}

function showPrintReport(rtnnum, rtndate,rtn_disp_locn){
//alert("rtnnum=====|" +rtnnum+ "|----rtndate====|" +rtndate+ "|====rtn_disp_locn====|" +rtn_disp_locn+ "==|");	
var frmObject = parent.f_query_add_mod.document.SRRPhMedicationnReturnCriteriaForm;
var locale = frmObject.language_id.value;
var p_rtndate  = rtndate;
var p_rtn_disp_locn_code  = rtn_disp_locn;
//convertDate(p_fr_retn_date,"DMY",locale);
var P_FRM_RETN_DAT=convertDate(frmObject.p_fr_retn_date1.value,"DMY",locale,"en"); //Added Variables for the incident num:25238==By Sandhya
var P_TO_RETN_DATE=convertDate(frmObject.p_to_rtn_date1.value,"DMY",locale,"en");
//alert("P_FRM_RETN_DAT=====>" +P_FRM_RETN_DAT);
//alert("P_TO_RETN_DATE=====>" +P_TO_RETN_DATE);

frmObject.p_report_id.value="PHPRMDRTBYWARD";

frmObject.p_ret_doc_no.value=rtnnum;

frmObject.p_rtn_date.value=p_rtndate;


frmObject.p_rtn_disp_locn_code.value=p_rtn_disp_locn_code;
frmObject.p_fr_retn_date.value=P_FRM_RETN_DAT;
frmObject.p_to_rtn_date.value=P_TO_RETN_DATE;
//alert("frmObject.p_fr_retn_date.value=====>" +frmObject.p_fr_retn_date.value);
//alert("frmObject.p_to_rtn_date.value=====>" +frmObject.p_to_rtn_date.value);



	frmObject.submit();
	//parent.f_query_add_mod.location.reload();
	//parent.f_query_results.location.reload();
}




function allowPositiveNumber() {
	
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}
