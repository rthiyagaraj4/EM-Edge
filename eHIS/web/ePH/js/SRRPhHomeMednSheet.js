function reset() {
		f_query_add_mod.SRRPhHomeMednSheetForm.reset();
	    f_query_results.location.href	="../../eCommon/html/blank.html";
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function showResults(){
	
	 var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";

	var locale = formObj.language_id.value;
	var patient_id = formObj.p_pat_id.value;
	var p_pres_id = formObj.p_pres_id.value;
	var p_tokfr = formObj.p_tokfr.value;

	
	var p_tokto = formObj.p_tokto.value;
	var p_encounter= formObj.p_encounter.value;

	var p_disp_locn_code = formObj.p_disp_locn_code.value;
	var p_locn_type = formObj.p_locn_type.value;

	var p_locn_code = formObj.locn_code.value;
	var p_fr_disp_date = formObj.p_fr_disp_date1.value;
	fr_dispdate=convertDate(p_fr_disp_date,"DMY",locale); 
	var p_to_disp_date = formObj.p_to_disp_date1.value;
	to_dispdate=convertDate(p_to_disp_date,"DMY",locale); 


	
	var fields = new Array (formObj.p_fr_disp_date1,formObj.p_to_disp_date1,formObj.p_disp_locn_code);
	var names= new Array (getLabel("ePH.DispensedDateFrom.label","PH"), getLabel("ePH.DispensedDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{ 
		//Addedd=================================================================================

		if(!isBefore(formObj.p_to_disp_date1.value,formObj.currentdate.value,"DMY",document.forms[0].language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

	 if(!isBefore(formObj.p_fr_disp_date1.value,formObj.p_to_disp_date1.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}	

	//Ends==============================================================

		if(parent.f_query_add_mod.CheckString("Token No", parent.f_query_add_mod.document.SRRPhHomeMednSheetForm.p_tokfr,parent.f_query_add_mod.document.SRRPhHomeMednSheetForm.p_tokto, parent.messageFrame) )					
				{


		if(doDateCheck(formObj.p_fr_disp_date1,formObj.p_to_disp_date1,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRPhHomeMednSheetResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_dispdate="+fr_dispdate+"&to_dispdate="+to_dispdate+"&p_pres_id="+p_pres_id+"&p_locn_code="+p_locn_code+"&p_disp_locn_code="+p_disp_locn_code+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter+"&p_tokto="+p_tokto+"&p_tokfr="+p_tokfr;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
	}else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	}

}

function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_pat_id.value = patient_id;
		formObj.p_pat_id.focus();
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
                to.select();
                to.focus();

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
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
			return false
		}
	}
    return true;
}
function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_to_disp_date1;
	  to = document.forms[0].p_fr_disp_date1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_disp_date1;
	  to = document.forms[0].p_to_disp_date1;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_to_disp_date1;
	  to = document.forms[0].p_fr_disp_date1;
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
if(document.forms[0].p_fr_disp_date1.value=='' || document.forms[0].p_to_disp_date1.value=='')
{ 
					return false;
}
else{
if(!isBefore(document.forms[0].p_fr_disp_date1.value,document.forms[0].p_to_disp_date1.value,"DMY",document.forms[0].language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
			alert(errors);
			return false;
			
	}
}
	return true;
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
	var formObj = document.frames.SRRPhHomeMednSheetForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}

function locationLookup(target){
	var formObj = document.frames.SRRPhHomeMednSheetForm;
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
function SubmitLink(from,to,patient_id,p_pres_id,fr_dispdate,to_dispdate,p_encounter,p_facility_id,p_disp_locn_code,p_tokfr,p_tokto,p_locn_type,p_locn_code){
	
	var obj=document.frames.SRRPhHomeMednSheetResult;
	

	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.p_pres_id.value=p_pres_id;
	obj.fr_dispdate.value=fr_dispdate;
	obj.to_dispdate.value=to_dispdate;
	obj.p_encounter.value=p_encounter;
	obj.p_facility_id.value=p_facility_id;
	obj.p_disp_locn_code.value=p_disp_locn_code;
	obj.p_tokfr.value=p_tokfr;
	obj.p_tokto.value=p_tokto;
	obj.p_locn_type.value=p_locn_type;
	obj.p_locn_code.value=p_locn_code;
	
	obj.submit();
}

function showPrintReport(disp_date,seq_tokn,pat_id){
	var formObj = parent.f_query_add_mod.SRRPhHomeMednSheetForm;
	var locale = formObj.language_id.value;
	//alert("220");	
	formObj.p_disp_date.value = disp_date ;
	formObj.p_seq_token_no.value = seq_tokn ;
	formObj.p_patient_id.value = pat_id ;
	var P_FRM_DISPN_DATE=convertDate(formObj.p_fr_disp_date1.value,"DMY",locale,"en"); //Added Variables for the incident num:25344==By Sandhya
	var P_TO_DISPN_DATE=convertDate(formObj.p_to_disp_date1.value,"DMY",locale,"en");

	

	formObj.p_report_id.value = "PHHOMMED" ;
	formObj.p_fr_disp_date.value=P_FRM_DISPN_DATE;
	formObj.p_to_disp_date.value=P_TO_DISPN_DATE;
	
	//alert("formObj.p_fr_disp_date.value=====>" +formObj.p_fr_disp_date.value);
	//alert("formObj.p_to_disp_date.value=====>" +formObj.p_to_disp_date.value);
	parent.f_query_add_mod.document.SRRPhHomeMednSheetForm.submit();
}
