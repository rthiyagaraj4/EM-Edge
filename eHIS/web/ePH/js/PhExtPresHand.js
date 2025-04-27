//saved on 04/11.2005
function run() {
	var frmObject = f_query_add_mod.document.formPhExtPresHandCriteria;
	var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value+"'"+frmObject.language_id.value+"'";
	f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value="";
	if(f_query_add_mod.document.formPhExtPresHandCriteria) {
	var fields= new Array (frmObject.enq_date_from,frmObject.enq_date_to);
	var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"));
	
	var fac= f_query_add_mod.document.formPhExtPresHandCriteria.facility_code.value;

	f_query_add_mod.document.formPhExtPresHandCriteria.p_facility_code.value=fac;

	var facid =  f_query_add_mod.document.formPhExtPresHandCriteria.p_facility_id.value;
	if(checkFields(fields,names,messageFrame)){
		if(fac ==""){
		f_query_add_mod.document.formPhExtPresHandCriteria.p_facility_code.value="";}
	else {

		f_query_add_mod.document.formPhExtPresHandCriteria.p_facility_code.value=fac;}

			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_from, f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_to, messageFrame ) ) 
			{
			if(f_query_add_mod.document.formPhExtPresHandCriteria.p_report_type.value =="1")
				{
			f_query_add_mod.document.formPhExtPresHandCriteria.p_frdate.value=f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_from.value;//p_enq_date_from to enq_date_from for HSA-SCF-0061 [IN:050147] 
			f_query_add_mod.document.formPhExtPresHandCriteria.p_todate.value=f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_to.value;//p_enq_date_to to enq_date_to for HSA-SCF-0061 [IN:050147] 
			var locale=frmObject.p_language_id.value;
					frmObject.p_enq_date_from.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en");
					frmObject.p_enq_date_to.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en");
					frmObject.p_frdate.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en"); //Added for HSA-SCF-0061 [IN:050147]
					frmObject.p_todate.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en"); //Added for HSA-SCF-0061 [IN:050147]
			f_query_add_mod.document.formPhExtPresHandCriteria.p_report_id.value="PHEXTPRESHAND";
         		}
			else if(f_query_add_mod.document.formPhExtPresHandCriteria.p_report_type.value =="2")
			{
			f_query_add_mod.document.formPhExtPresHandCriteria.p_report_id.value="PHEXTPRESHANDS";
			f_query_add_mod.document.formPhExtPresHandCriteria.p_frdate.value=f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_from.value;//p_enq_date_from to enq_date_from for HSA-SCF-0061 [IN:050147] 
			f_query_add_mod.document.formPhExtPresHandCriteria.p_todate.value=f_query_add_mod.document.formPhExtPresHandCriteria.enq_date_to.value;//p_enq_date_to to enq_date_to for HSA-SCF-0061 [IN:050147] 
			var locale=frmObject.p_language_id.value;
					frmObject.p_enq_date_from.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en");
					frmObject.p_enq_date_to.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en");
					frmObject.p_frdate.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en"); //Added for HSA-SCF-0061 [IN:050147]
					frmObject.p_todate.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en"); //Added for HSA-SCF-0061 [IN:050147]
			}
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.formPhExtPresHandCriteria.submit();
			}
		}
		f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value = temp_qry_1;
}
}

function reset() {
    f_query_add_mod.formPhExtPresHandCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.enq_date_from;
	to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.enq_date_to;
	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame)) {
		result	=	true;
	}
	else {
		result  = false;
	}
	alert(result);
	return result;
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}



function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
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

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH")+" + 1");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}



/*function validate_date(Obj,ref) {
                

	if (CheckDate(Obj)){//p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification
	 if(ref == "TO_DT_GR_EQ_FM_DT"){
	  from = document.forms[0].enq_date_to;
	  to = document.forms[0].enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT1"){
	  from = document.forms[0].enq_date_from;
	  to = document.forms[0].enq_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM"){
	  from = parent.frames[1].document.forms[0].enq_date_to;
	  to = parent.frames[1].document.forms[0].enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
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
}
}


function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(invaldt);
			to.select();
			to.focus();
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt)){		
			validate_date(to,'TO_DATE_LESS_FROM')
			return true;
		}
   
	}
	return true;
}

function CheckDateT(obj){//Added for DateConversion identification
	
	var locale=document.formPhExtPresHandCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
*/
//START ML-MMOH-SCF-2364, ML-BRU-SCF-2212
function checkDate(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var fromDt = document.getElementById("enq_date_from");
		var toDt = document.getElementById("enq_date_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(fromDt.value != "" || toDt.value != "")
			{
				validateFromToDates(fromDt,toDt,format,locale);
			}
		}		
	}
}

function validateFromToDates(from,to,format,locale)
{
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						to.select();
						to.focus();
						return false;
				   }
				}
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
		}
}
//END ML-MMOH-SCF-2364, ML-BRU-SCF-2212
