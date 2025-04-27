function CheckDateT(obj){
	
	var locale=document.formPhDispLabelCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			//obj.focus();
			return false;
		}
	}
	return true;
	/*else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}*/
}

/*
function DateCheck(from,to) {
    var fromarray;
    var toarray;
    var fromdate =from.value;
    var todate = to.value ;
      if(fromdate.length > 0 && todate.length > 0 ) {
    	fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(invaldt);
			to.value=""
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
function validate_date(Obj,ref) {
	
	if (CheckDate(Obj)){//from_dt to p_from_dt AND dt_to to p_dt_to Added for DateConversion identification 
		if(ref == "TO_DT_GR_EQ_FM_DT"){
			from = document.forms[0].p_dt_to;
			to = document.forms[0].p_from_dt;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
			from = document.forms[0].p_from_dt;
			to = document.forms[0].p_dt_to;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DATE_LESS_FROM"){
			from = parent.frames[1].document.forms[0].p_dt_to;
			to = parent.frames[1].document.forms[0].p_from_dt;
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
				from.value="";
				from.focus();
				return true ;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)){
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
				return true;
			} 
		}
		if(Obj.value!=""){
			if(parent.frames[1].document.formPhDispLabelCriteria.p_report_type.value =='2'){
				if(Obj.name=='p_enq_date_from')
					calcFromDate(Obj);
				else
					calcToDate(Obj);
			}
		}
		return true;
	}
}*/

function run() {
	var frmObject = f_query_criteria.document.formPhDispLabelCriteria;
	messageFrame.location.href="../../eCommon/jsp/error.jsp?" ;
	var fields = new Array (frmObject.p_disp_locn_code ,frmObject.p_from_dt,frmObject.p_dt_to);
	var names   = new Array(getLabel("ePH.DispenseLocation.label","common"),getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common")) ;
	
	if(f_query_criteria.checkFields( fields, names, messageFrame)){
		if(!isBefore(frmObject.p_from_dt.value,frmObject.currentdate.value,"DMY",frmObject.p_language_id.value)){//from_dt to p_from_dt AND dt_to to p_dt_to Added for DateConversion identification 
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;
		}
		else{
			var locale = frmObject.locale.value;
			 frmObject.from_dt.value=convertDate(frmObject.p_from_dt.value,'DMY',locale,"en");
			 frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");
			 frmObject.action="../../eCommon/jsp/report_options.jsp";
			 frmObject.target="messageFrame";
			 frmObject.submit();
		}
	}
}


function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
	   return false;
   }
}

function reset() {
    f_query_criteria.formPhDispLabelCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//START ML-BRU-SCF-2212
function checkDate(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var fromDt = document.getElementById("p_from_dt");
		var toDt = document.getElementById("p_dt_to");
		
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
				//from.select();
				from.value=" ";
				to.value=" ";
				//from.focus();
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
							//to.select();
							to.value=" ";
							//to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						//to.select();
						to.value=" ";
						//to.focus();
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
					//to.select();
					to.value=" ";
					//to.focus();
					return false;
				}
			}
		}
}
//END ML-BRU-SCF-2212
