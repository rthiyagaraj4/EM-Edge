/**
 Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
---------------------------------------------------------------------------------------------
1            V201118            8071/74237        MOHE-CRF-0050.4     		 Mohana Priya K
2            V210106            12438          BL-MOHE-CRF-0050.4-US001 and US002/02-Invoice Reports     Mohana Priya K
 * 
 */

function reset(){
	invoice_report.location.reload();
}

function fnClearCode(obj){
		obj.value = '';
}

function ReportListchange(val){
	var posted=document.getElementById('posted').checked;
	var unposted=document.getElementById('unposted').checked;
	if(val.value=='INRSUMINV' || (val.value=='INRSTDFT' && unposted==true)){
		document.getElementById('vst_fm_date').disabled=true;
		document.getElementById('vst_to_date').disabled=true;
		document.getElementById('vstfm').disabled=true;
		document.getElementById('vstto').disabled=true;
		document.getElementById('disc_fm_date').disabled=true;
		document.getElementById('disc_to_date').disabled=true;
		document.getElementById('disfm').disabled=true;
		document.getElementById('disto').disabled=true;
	}
	else if(val.value=='INRSTDFT' && posted==true){
		document.getElementById('vst_fm_date').disabled=false;
		document.getElementById('vst_to_date').disabled=false;
		document.getElementById('vstfm').disabled=false;
		document.getElementById('vstto').disabled=false;
		document.getElementById('disc_fm_date').disabled=false;
		document.getElementById('disc_to_date').disabled=false;
		document.getElementById('disfm').disabled=false;
		document.getElementById('disto').disabled=false;
	}
}

function dateRegEx(e){  //Added for Character Restriction in date field
  var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
  if (e.value.search(pattern)===0){
    return true;
  }
  else {
    alert("Please provide valid date in format dd/mm/yyyy");
    document.getElementById(e.id).focus();
    return false; 
  } 
}

//Effective From and ToDate Logic
function toFromDateChk(obj,from,to){	
	if(!(obj.value==""))
	{		
		var locale    =  document.forms[0].locale.value;
		var effFromDt=from.value;
		var effToDt=to.value;
	
		if(validDate(obj.value,"DMY",locale))
		{  
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL6015",'BL'));
				obj.value = '';
				return false;
			}
			
			if(effFromDt != '' && effToDt !=''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}				
			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date,from,to)
{		
	var locale    = document.forms[0].locale.value;
	var effFromDt=from.value;
	var effToDt=to.value;
	
	if(entered_date.value!="")
	{   
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(effFromDt!=getCurrentDate('DMY',locale) && isAfterNow(effFromDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				entered_date.value='';
				return false;
			}			
			if(effToDt != '' && effFromDt!=''){    
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
					alert(getMessage("BL7060",'BL'));
					entered_date.value='';
					return false;
			}
			else{
					return true;
			 }
			}	
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

//Effective From and ToDate Logic
function run(){ 
	var formsObj      =  parent.content.invoice_report.document.forms[0];
    var p_report_id	  =  formsObj.Report_list.value;
	var EpisodeType   =  formsObj.EpisodeType.value;
	var posted  	  =  formsObj.posted.checked;
	var from_mon      =  formsObj.from_mon.value;
	var from_yr       =  formsObj.from_yr.value;
	var to_mon        =  formsObj.to_mon.value;
	var to_yr   	  =  formsObj.to_yr.value;
	var p_fm_date     =  formsObj.fm_date.value;
	var p_to_date 	  =  formsObj.to_date.value;
	var vst_fm_date   =  formsObj.vst_fm_date.value;
	var vst_to_date   =  formsObj.vst_to_date.value;                                   
	var disc_fm_date  =  formsObj.disc_fm_date.value;
	var disc_to_date  =  formsObj.disc_to_date.value;
	var custGrpCode	  =  formsObj.custGrpCode.value;
	var custGrpDesc   =  formsObj.custGrpDesc.value;
	var payerCode	  =  formsObj.payercode.value;
	var payerDesc     =  formsObj.payerDesc.value;
	
	var locale        =  formsObj.locale.value;
	var loggedUserId  =  formsObj.p_user_name.value;
	var session_id    =  formsObj.p_session_id.value;
	var facility_id    =  formsObj.facilityId.value;
	var p_module_id   =  formsObj.p_module_id.value;
	var p_pgm_date    =  formsObj.p_pgm_date.value;
	var reporttype='M';
	var approved='Y';
	var billingclss='**';
	if(posted==true){
		posted='Y';
	}else{
		posted='N';
	}
		
	if(from_mon=='0' && from_yr=='0' && to_mon=='0' && to_yr=='0'){
		if(p_fm_date=='' || p_to_date==''){
			alert(getMessage("BL0738",'BLEXT'));   //V201214
			return false;	
		}
	}else{  //V201208
		if(from_mon=='0' || from_yr=='0' || to_mon=='0' || to_yr=='0'){  
			alert(getMessage("BL0738",'BLEXT'));    //V201214
			return false;	
		}
	}
	if(vst_fm_date==''){
		vst_fm_date =vst_fm_date.replace(/\#/g,' ');	
		vst_fm_date =vst_fm_date.replace(/\&/g,' ');	
		formsObj.vst_fm_date.value = vst_fm_date;
	}
	
	if(vst_to_date==''){
		vst_to_date =vst_to_date.replace(/\#/g,' ');	
		vst_to_date =vst_to_date.replace(/\&/g,' ');	
		formsObj.vst_to_date.value = vst_to_date;
	}
	
	if(custGrpCode=='' || custGrpDesc==''){
		formsObj.custGrpCode.focus();
		alert(getMessage("BL00948",'BL'));
		return false;	
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&facility_id="+facility_id+"&p_report_id="+p_report_id+"&param1="+custGrpCode +
	"&param2="+payerCode+
	"&param7="+loggedUserId +
	"&param8="+reporttype +"&param9="+approved +"&param10="+posted +
	"&param11="+billingclss ;
	
	if(p_report_id=="INRSTDFT"){
		if(from_mon!='0' && from_yr!='0' && to_mon!='0' && to_yr!='0'){
			param1=param1+"&param14="+from_mon +"&param15="+from_yr+"&param16="+to_mon +"&param17="+to_yr +"&param18="+EpisodeType;
		}else{
			param1=param1+"&param3="+p_fm_date  +"&param4="+p_to_date +"&param18="+EpisodeType; //V210106
		}
	}else{
		if(from_mon!='0' && from_yr!='0' && to_mon!='0' && to_yr!='0'){
			param1=param1+"&param12="+from_mon +"&param13="+from_yr+"&param14="+to_mon +"&param15="+to_yr +"&param16="+EpisodeType ;
		}else{
			param1=param1+"&param3="+p_fm_date  +"&param4="+p_to_date +"&param16="+EpisodeType; //V210106
		}
	}
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLCommonReportValidation.jsp?func_mode=col_sum"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retVal2 = retVal.replace(/<!DOCTYPE html>[\s\S]*?/, "").trim();
	var retValArr = retVal2.split(":::");
	var pgm_id=p_report_id;	
	
	if(retValArr.length == 2){	
		session_id = retValArr[0];
		p_pgm_date = retValArr[1];
		
		var htmlVal = "<html><body>";
		htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='P_facility_id' id='P_facility_id' value='"+facility_id+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
		htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgm_id+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
		htmlVal += "<input type='hidden' name='P_SESSION_ID' id='P_SESSION_ID' value='"+session_id+"'>";
		htmlVal += "<input type='hidden' name='P_PGM_DATE' id='P_PGM_DATE' value='"+p_pgm_date+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
		htmlVal += "</form></body></html>";
		
		dummy_frame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
		dummy_frame.document.dummy_frm.submit();		 
	}
	else{
		alert(retValArr[1]); 
	}
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

