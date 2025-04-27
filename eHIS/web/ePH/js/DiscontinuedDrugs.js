 //saved on 07.01.2009
function run() {	
	var frmObject = f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria;
	if(f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria) {
		var fields= new Array (frmObject.P_DATE_FROM1, frmObject.P_DATE_TO1,frmObject.P_NURSING_UNIT);
		var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.nursingUnit.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {

         frmObject.P_DATE_FROM.value = convertDate(frmObject.P_DATE_FROM1.value,'DMY',frmObject.p_language_id.value,'en');
         frmObject.P_DATE_TO.value  =  convertDate(frmObject.P_DATE_TO1.value,'DMY',frmObject.p_language_id.value,'en');

			if( f_query_add_mod.DateCheck(f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.P_DATE_FROM1,
				                          f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.P_DATE_TO1, messageFrame) ) {
				f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.submit();
			}
		}
	}
}

function reset() {
	
//To reset all the value
    f_query_add_mod.formPhRepAdministrationNotRecordedCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage()	{

  var result	=	false;
  frm_obj		=	f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.P_DATE_FROM1;
  to_obj		=	f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.P_DATE_TO1;
  msg_frame		=	messageFrame;

  if(DateCheck(frm_obj,to_obj,msg_frame) )		 {
      result	=	true;
	 }
	else
	 {
	  result  = false;
	  }
	 alert(result);
return result;
}


function searchCode( target ) {
    var language_id=document.formPhRepAdministrationNotRecordedCriteria.locale.value;

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] = f_query_add_mod.document.formPhRepAdministrationNotRecordedCriteria.SQL_PH_MED_ADMIN_SELECT2.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value; 
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray = CommonLookup(getLabel("Common.nursingUnit.label","Common"), argumentArray );

	if(retArray != null && retArray != "" ) {
		target.value = retArray[0];	/* if code need to be returned */
		target.focus();
	}
}



function GoBack() {
	alert(getMessage("PH_MEDN_ADM_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}




/*function ValidateFrom(from,to,en) {
	var result	=	true;
	if(to.value!="")
	  {
		if(!doDateTimeChk(to))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
			}
		else
		if(!ValidateDateTime(from,to)) {
			alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
			to.select();
			result	=	false;
		}
		else
		{
			if(!ValidateDateTime(to,en)) {
				alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
				to.select();
				result	=	false;
			}
		}
	}

return result;
}
*//*
function ValidateTo(from,to,en) {
	var result	=	true;
	if(to.value!="")
	  {
		if(!doDateTimeChk(to))
			{
			alert(getMessage("INVALID_DATE_TIME","PH"));
			to.focus;
			}
		else
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false; 
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
			to.focus();
		}
	}
	  }
return result;
}*/

function searchCode(target,objIdentify){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   = document.getElementById("SQL_PH_MED_ADMIN_APPL_USERS").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = CommonLookup(getLabel("Common.AdministeredBy.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		target.value = retVal[1] ;
	}	
}

//for patient lookup
function callPatientSearch(target){

	var patient_id = PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;
 }
}
function checkDate(obj){
	if(obj.value!=""){
	if(!(checkDt(obj.value))){
		obj.value="";
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("INVALID_DATE_FMT","SM")
		obj.focus();
		return false;
    }
    else{
        return true;
	}

	}
}
//To check difference between two date.
function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
      			fromarray = fromdate.split("/");

			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) < Date.parse(fromdt)) 
            {
 
                parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT","PH")
                 to.select();
                 to.focus();       
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) {
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp'
				return true;
			}
    }
    return true;
}

