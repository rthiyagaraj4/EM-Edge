function showResults(){
	 var formObj = parent.f_query_add_mod.document.forms[0];
	var fr_dispdate="";
	var to_dispdate ="";

	var locale = formObj.language_id.value;
	var patient_id = formObj.p_patient_id.value;
	var p_pres_id = formObj.p_pres_id.value;

	
	var p_encounter= formObj.p_encounter.value;
	var p_medretno= formObj.p_medretno.value;

	var p_retndisp = formObj.p_retndisp.value;
	var p_locn_type = formObj.p_locn_type.value;
	var p_locn_code = formObj.locn_code.value;

	var p_fr_retn_date = formObj.p_fr_retn_date.value;
	fr_dispdate=convertDate(p_fr_retn_date,"DMY",locale); 
	var p_to_rtn_date = formObj.p_to_rtn_date.value;
	to_dispdate=convertDate(p_to_rtn_date,"DMY",locale); 

	
	var fields = new Array (formObj.p_patient_id,formObj.p_fr_retn_date,formObj.p_to_rtn_date);
	var names= new Array (getLabel("Common.patientId.label","Common"),getLabel("ePH.ReturnDateFrom.label","PH"), getLabel("ePH.ReturnDateTo.label","PH"));

	if(checkFields(fields,names,parent.messageFrame)) 
	{
		if(!isBefore(formObj.p_to_rtn_date.value,formObj.sysdate.value,"DMY",formObj.language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

		if(!isBefore(formObj.p_fr_retn_date.value,formObj.p_to_rtn_date.value,"DMY",formObj.language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}
		if(doDateCheck(formObj.p_fr_retn_date,formObj.p_to_rtn_date,parent.messageFrame) )		parent.f_query_results.location.href="../../ePH/jsp/SRRPhMednRtnResult.jsp?patient_id="+patient_id+"&locale="+locale+"&fr_retndate="+fr_dispdate+"&to_retndate="+to_dispdate+"&p_locn_code="+p_locn_code+"&p_medretno="+p_medretno+"&p_pres_id="+p_pres_id+"&p_retn_locn_code="+p_retndisp+"&p_locn_type="+p_locn_type+"&p_encounter="+p_encounter;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
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

function resetLocation(){
	var formObj = document.frames.SRRPhMednRtnCriteriaForm;
	formObj.locn_code.value="";
	formObj.p_locn_code.value="";
}

function locationLookup(target){
	var formObj = document.frames.SRRPhMednRtnCriteriaForm;
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
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_to_rtn_date;
	  to = document.forms[0].p_fr_retn_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fr_retn_date;
	  to = document.forms[0].p_to_rtn_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_to_rtn_date;
	  to = document.forms[0].p_fr_retn_date;
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
if(document.forms[0].p_fr_retn_date.value=='' || document.forms[0].p_to_rtn_date.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].p_fr_retn_date.value,document.forms[0].p_to_rtn_date.value,"DMY",document.forms[0].p_language_id.value)) {
			
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

function SubmitLink(from,to,patient_id,p_pres_id,fr_retndate,to_retndate,p_encounter,p_retn_locn_code,p_locn_type,p_locn_code){
	var obj=document.frames.SRRPhMednRtnResult;
	
	obj.from.value=from;
	obj.to.value=to;
	obj.patient_id.value=patient_id;
	obj.p_pres_id.value=p_pres_id;
	obj.fr_retndate.value=fr_retndate;
	obj.to_retndate.value=to_retndate;
	obj.p_encounter.value=p_encounter;
	obj.p_retn_locn_code.value=p_retn_locn_code;
	obj.p_locn_type.value=p_locn_type;
	obj.p_locn_code.value=p_locn_code;
	obj.submit();
}

function showPrintReport(rtnnum, rtndate,rtn_disp_locn){
var frmObject = parent.f_query_add_mod.document.SRRPhMednRtnCriteriaForm;

var p_rtndate  = rtndate;
var p_rtn_disp_locn  = rtn_disp_locn;

frmObject.p_report_id.value="PHPRMDRT";
/*frmObject.P_rtn_med_no.value=rtnnum;
Changed Hidden var name on 28/7/2010 for Medication Return Voucher Report  */
frmObject.p_rtn_medn_no.value=rtnnum;
frmObject.p_rtn_date.value=p_rtndate;

frmObject.p_rtn_disp_locn.value=p_rtn_disp_locn;



	frmObject.submit();
}
