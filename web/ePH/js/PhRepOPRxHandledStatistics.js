function run() {
	var frmObject = f_query_add_mod.document.formRepOPRXHandledStatCriteria;
	if (f_query_add_mod.document.formRepOPRXHandledStatCriteria) {
		locale = frmObject.p_language_id.value;
		var fields=new Array();
		var names=new Array();
		fields[0]=frmObject.frm_date;
		fields[1]=frmObject.to_date;
		names[0]=getLabel("Common.DateFrom.label","Common");
		names[1]=getLabel("Common.DateTo.label","Common");
		if (checkFields(fields, names, messageFrame)) {
			frmObject.p_frm_date.value=convertDate(frmObject.frm_date.value,'DMY',locale,"en");
			frmObject.p_to_date.value=convertDate(frmObject.to_date.value,'DMY',locale,"en");
			if(dateCheckWithCurrDate('F') && dateCheckWithCurrDate('T') && validateProcessDt())
			{	frmObject.action="../../eCommon/jsp/report_options.jsp";
				frmObject.target="messageFrame";
				frmObject.submit();
				
			}	
		}
	}
}

function CheckDateT(obj){
	var locale=document.formRepOPRXHandledStatCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			return false;
		}
	}
	else {
		obj.value = convertDate(obj, 'DMY', locale, 'en');
	}
	return true;
}

function reset() {
	f_query_add_mod.formRepOPRXHandledStatCriteria.reset();
	messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
}

function validateProcessDt(){
	var frmObject = document.formRepOPRXHandledStatCriteria;
	if(frmObject == null || frmObject == undefined)
		frmObject = f_query_add_mod.document.formRepOPRXHandledStatCriteria;
	var from =frmObject.frm_date ;
	var to= frmObject.to_date ;
	var sysdt= frmObject.sysdate;
	var fromarray;
	var toarray;
	var fromdate1 = from.value ;
	var todate1 = sysdt.value ;
	var todt= to.value;
	if(fromdate1.length > 0 && todt.length > 0 ){
		fromarray = fromdate1.split("/");
		toarray = todt.split("/");
		var fromdat = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todat = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(fromdat) > Date.parse(todat)){
			var msg=alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
			frmObject.to_date.value="";
			frmObject.to_date.focus();
			return false;								
		}
		else if(Date.parse(todat) <= Date.parse(fromdat));
			return true;
	}
}

function dateCheckWithCurrDate(callFrom){
	var frmObject = document.formRepOPRXHandledStatCriteria;
	var msgFrame = parent.messageFrame;
	if(frmObject == null || frmObject == undefined)
		frmObject = f_query_add_mod.document.formRepOPRXHandledStatCriteria;
	if(msgFrame == null || msgFrame == undefined)
		msgFrame = messageFrame;

	var chkDate ="";
	var currDate= frmObject.sysdate.value;
	var locale= frmObject.p_language_id.value;
	var errors ="";
	if(callFrom=='F')
		chkDate = frmObject.frm_date.value ;
	else
		chkDate = frmObject.to_date.value ;
	if(chkDate.length > 0 && currDate.length > 0 ){   
		if(!isBefore(chkDate,currDate,"DMY",locale)) {				
			if(callFrom=='F'){
				frmObject.frm_date.value="";
				errors=getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH") ;
			}
			else{
				frmObject.to_date.value="";
				errors=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH") ;
			}
			msgFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
		else{
			msgFrame.location.href = "../../eCommon/jsp/error.jsp?";
			return true;
		}
	}		
	return false;
}	

function populateDispLocn(facility_id){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest(); 
	var disp_locn_category = "OP";
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "facility_id =\"" + facility_id + "\" " ;
	xmlStr+= "disp_locn_category =\"" + disp_locn_category + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhReportsValidation.jsp?validate=getDispLocByFacilityId",false ) ; 
	xmlHttp.send( xmlDoc ) ; 
	responseText=xmlHttp.responseText ;
	eval( responseText );
}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= decodeURIComponent(desc) ;
	document.formRepOPRXHandledStatCriteria.p_disp_locn_code.add(element);
}

function clearList(){
	var len			= document.formRepOPRXHandledStatCriteria.p_disp_locn_code.options.length;
	for(var i=0;i<len;i++) {
		document.formRepOPRXHandledStatCriteria.p_disp_locn_code.remove("p_disp_locn_code") ;
	}
	var tp = "   --- Select ---     " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formRepOPRXHandledStatCriteria.p_disp_locn_code.add(opt);
}

function validate_date() {
	var from = parent.frames[1].document.forms[0].frm_date;
	var	to = parent.frames[1].document.forms[0].to_date;
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	}
	
	if(from.value!=""){
		if(parent.frames[1].document.formRepOPRXHandledStatCriteria.p_cal_by_type.value =='M'){
			calcFromDate(from);
		}
	}
	return true;
}

function calcFromDate(obj){
	var blank = obj.value;
	if( blank == ""){
		alert(getMessage("DATE_CANT_BE_BLANK","PH"));
		return false;
	}
	if(!CheckDateT(obj))
		return false;
	if(parent.frames[1].document.formRepOPRXHandledStatCriteria.p_cal_by_type.value != 'M')
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
	parent.frames[1].document.formRepOPRXHandledStatCriteria.frm_date.value=finalDt ;
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
