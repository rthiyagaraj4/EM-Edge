  //saved on 04/11.2005
function run() {

	var frmObject = f_query_add_mod.document.formPhBalMednHand;
	if(f_query_add_mod.document.formPhBalMednHand) {
	var fields= new Array (frmObject.enq_date_from,frmObject.enq_date_to);
	var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"));
	var fac= f_query_add_mod.document.formPhBalMednHand.p_facility_code.value;

	if(checkFields(fields,names,messageFrame) ) {
	/*if(f_query_add_mod.document.formPhBalMednHand.p_facility_code.value=="")
		f_query_add_mod.document.formPhBalMednHand.p_facility_id.value="";
	else 
		f_query_add_mod.document.formPhBalMednHand.p_facility_id.value=fac;*/

	f_query_add_mod.document.formPhBalMednHand.p_frdate.value = frmObject.enq_date_from.value;
	f_query_add_mod.document.formPhBalMednHand.p_todate.value = frmObject.enq_date_to.value;
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhBalMednHand.enq_date_from, f_query_add_mod.document.formPhBalMednHand.enq_date_to, messageFrame ) ) {//p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification
			     var locale=frmObject.p_language_id.value;
			   if(locale!='en'){
					frmObject.p_enq_date_from.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en");
					frmObject.p_enq_date_to.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en");
			      }
			   		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			   		f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.formPhBalMednHand.submit();
				}
				
			}
		}
}




function reset() {
		f_query_add_mod.document.formPhBalMednHand.p_enq_date_from.value=""; f_query_add_mod.document.formPhBalMednHand.p_enq_date_to.value = "";
    f_query_add_mod.formPhBalMednHand.reset();
	var frmobj=f_query_add_mod.document.formPhBalMednHand; 
//	frmobj.loc_name.disabled=true;
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}



function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}

/*
function validate_date(Obj,ref) {
                

	if (CheckDate(Obj)){//p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].enq_date_to;
	  to = document.forms[0].enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].enq_date_from;
	  to = document.forms[0].enq_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
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
function CheckDateT(obj){ //Added for DateConversion identification
	
	var locale=document.formPhBalMednHand.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	return true;
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

