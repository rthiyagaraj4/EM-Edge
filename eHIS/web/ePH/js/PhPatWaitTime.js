var message		= "" ;
function reset() {
	//frames[1].location.href="../../ePH/jsp/DrugInfoEnqDtlRepCriteria.jsp";
	frames[1].document.formPhWaitTimeCriteria.reset();
}

function run() {
	var frmObject =frames[1].document.formPhWaitTimeCriteria;
	if(frames[1].document.formPhWaitTimeCriteria) {//p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification
		var fields= new Array (frmObject.enq_date_from, frmObject.enq_date_to);
		var names= new Array (getLabel("ePH.EnquiryDateFrom.label","PH"), getLabel("ePH.EnquiryDateTo.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
			frames[1].document.formPhWaitTimeCriteria.from_dt.value=frames[1].document.formPhWaitTimeCriteria.enq_date_from.value;
			frames[1].document.formPhWaitTimeCriteria.to_dt.value=frames[1].document.formPhWaitTimeCriteria.enq_date_to.value;
			if(frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="1")
				frames[1].document.formPhWaitTimeCriteria.p_report_id.value="PHPTWAITTIME";
			else if(frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="2")
				frames[1].document.formPhWaitTimeCriteria.p_report_id.value="PHPTWAITTIMEM";
			var locale = frmObject.language_id.value;
		   	if(locale!='en'){
				frmObject.p_enq_date_from.value=convertDate(frmObject.enq_date_from.value,'DMY',locale,"en");
				frmObject.p_enq_date_to.value=convertDate(frmObject.enq_date_to.value,'DMY',locale,"en");
				frmObject.from_dt.value=frmObject.p_enq_date_from.value;
				frmObject.to_dt.value=frmObject.p_enq_date_to.value;
		   	}
		   	frmObject.action="../../eCommon/jsp/report_options.jsp";
		   	frmObject.target="messageFrame";
			frmObject.submit();
		}
	}
}


function setdate(obj){//p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification
	if(!CheckDate(obj))
		return false;
	if(obj.name =="enq_date_from"&& parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="1")
	   parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=obj.value ;
	else if (obj.name == 'enq_date_to'&& parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value =='1')
		parent.frames[1].document.formPhWaitTimeCriteria.enq_date_from.value=obj.value ;
}

function calcToDate(obj){

	var blank = obj.value;
	if( blank == ""){
		alert(getMessage("DATE_CANT_BE_BLANK","PH"));
		return false;
	}
	/*if(!CheckDate(obj))
		return false;

	if(parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value != '2')
		return false;*/
	var start_date	=	obj.value;
	var fromarray;
	var finalDt="";
	var finalDt1="";

	if(start_date.length > 0){
		fromarray = start_date.split("/");
	}
	var dt = LastDateofMonth(""+fromarray[1]+"/"+fromarray[2]+"/"+fromarray[0]);
	var date= ""+dt+"";
	var month= ""+fromarray[1]+"";
	
	if(date.length == 1)
		date="0"+date;
	if(month.length == 1)
		month="0"+month;
	
	finalDt += date + "/";
	finalDt += month + "/";
	finalDt += fromarray[2];
	finalDt1 += 01+ "/";
	finalDt1 += month + "/";
	finalDt1 += fromarray[2];
	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=finalDt ;
	parent.frames[1].document.formPhWaitTimeCriteria.focus();

}	

function LastDateofMonth(Object) {
    var strDate;
    var strMonth;
    var strYear;
    var datefield = Object;
    var strDateArray = new Array();
    strDate = datefield;

    strDateArray = strDate.split("/");
    strMonth = strDateArray[0];
    strYear = strDateArray[1];

    if  (strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12)
        return 31;
    else if (strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11)
        return 30;
    else if (strMonth == 2) {
        if (LeapYear(strYear) == true) 
            return 29;
        else 
            return 28;
    }
}

function calcFromDate(obj){
	var blank = obj.value;
	if( blank == ""){
		alert(getMessage("DATE_CANT_BE_BLANK","PH"));
		return false;
	}
	if(!CheckDate(obj))
		return false;
	if(parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value != '2')
		return false;

	var to_date	=	obj.value;
	
	if(to_date.length > 0){
		fromarray = to_date.split("/");
	}

	var dt = LastDateofMonth(""+fromarray[1]+"/"+fromarray[2]+"/"+fromarray[0]);
    var dt1="";

	var finalDt1="";
	finalDt1 += dt + "/";
	finalDt1 += fromarray[1] + "/";
	finalDt1 += fromarray[2];
	if( fromarray[0] <= dt)
		dt1= "1";

	var date= ""+dt1+"";
	var month= ""+fromarray[1]+"";
	
	if(date.length == 1)
		date="0"+date;
	if(month.length == 1)
		month="0"+month;
	
	var finalDt="";
	finalDt += date + "/";
	finalDt += month + "/";
	finalDt += fromarray[2];
	parent.frames[1].document.formPhWaitTimeCriteria.enq_date_from.value=finalDt ;
	//parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=finalDt1 ;
}

function setTOandFromDate(obj){
	parent.frames[1].document.formPhWaitTimeCriteria.enq_date_from.value="" ;
	parent.frames[1].document.formPhWaitTimeCriteria.enq_date_to.value="" ;
}

function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}
/*
function validate_date(Obj,ref) {
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
			if(parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value =='2'){
				if(Obj.name=='enq_date_from')
					calcFromDate(Obj);
				else
					calcToDate(Obj);
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

function CheckDateT(obj){
	var locale=document.formPhWaitTimeCriteria.p_language_id.value;
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
}*/
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
