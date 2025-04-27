/**
 * 
Sr No        Version           Incident/TFS        SCF/CRF           		  		Developer Name
----------------------------------------------------------------------------------------------------
1            V201021            74212/4939        MOHE-CRF-0050.2      		  		 Mohana Priya K
2			 V201124			8733		BL-MOHE-CRF-0050.2-US001/01-MIS 
											Reports-Collection Summary for a Period  Mohana Priya K
-----------------------------------------------------------------------------------------------------			*/

function reset()
{
	summaryreport.location.reload();
}

//Effective From and ToDate Logic
function toFromDateChk(obj){
	if(!(obj.value=="")){		
		var locale    =document.forms[0].locale.value;
		var effFromDt =document.forms[0].fm_bill_date.value;
		var effToDt	  =document.forms[0].to_bill_date.value;
		if(effFromDt==''){  //V201124
			document.getElementById("fm_bill_date").focus(); 
			document.forms[0].to_bill_date.value='';
			alert(getMessage("BL00948",'BL'));
  			  	return false;
		}
		if(validDate(obj.value,"DMY",locale)){
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				obj.value = '';
				return false;
			}
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){		
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}
				else{			
					return true;
				}
			}		
			if(effFromDt=='' && effToDt==''){
				alert(getMessage("BL00948",'BL'));
  			  	return false;
  			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else{
		return true;
	}
}


function checkDateBL(entered_date){		
  	var locale		=document.forms[0].locale.value;
  	var effFromDt 	=document.forms[0].fm_bill_date.value;
  	var effToDt	    =document.forms[0].to_bill_date.value;
  	if(entered_date.value!=""){
  		if(validDate(entered_date.value,'DMY',locale)){
  			if(!isBeforeNow(entered_date.value,'DMY',locale)){
  				alert(getMessage("BL9114",'BL'));
  				entered_date.value='';
  				return false;
  			}			
  			if(effToDt != ''){
  				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
  					alert(getMessage("BL7060",'BL'));
  					entered_date.value='';
  					return false;
  			}
				else{
  					return true;
				}
  			}	
  			if(effFromDt=='' && effToDt==''){   //V201124
				document.getElementById("fm_bill_date").focus(); 
  				alert(getMessage("BL00948",'BL'));
  			  	return false;
  			}
  		}
  		else{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			entered_date.value='';
  			return false;
  		}
  	}
  	else{
  		return true;
  	}
}
//Effective From and ToDate Logic


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


function counterLookup(){
	var facility=document.forms[0].facilityId.value;
    var formObj = document.forms[0];
	var sql="";
	
	sql="select cash_counter_code code, short_desc description from bl_cash_counter WHERE upper(operating_facility_id) = '"+facility+"' AND UPPER (cash_counter_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) " ;
	var title									= 	getLabel("eBL.CASH_COUNTER.label", 'bl'); //V201117
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.cash_counter.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != ""){
		formObj.cash_count.value			=   retVal[0];
		formObj.cash_counter.value 			= 	retVal[1];
	}
	else{
		formObj.cash_count.value			=   "";
		formObj.cash_counter.value 			= 	"";
		
	}
 }
	

function userLookup(){
	 var formObj =document.forms[0];
	sql="SELECT APPL_USER_ID code,APPL_USER_NAME description FROM  SM_APPL_USER where UPPER (APPL_USER_ID) LIKE UPPER (?) AND UPPER (APPL_USER_NAME) LIKE UPPER (?) ORDER BY 2 "; 
	var title									= 	getLabel("Common.username.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var user								    =	document.getElementById('user'); 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.user.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != ""){
		formObj.user_.value			=   retVal[0];
		formObj.user.value 			= 	retVal[1];
	}
	else{
		formObj.user_.value			=   "";
		formObj.user.value 			= 	"";
	}
}

function zero_bill_also(){ 
	var check=document.getElementById('zero_bill').checked;
	if(check=='true' || check==true){
		document.getElementById('zero_bill').value='Y';
		}
	else{
		document.getElementById('zero_bill').value='N';
	}
}

function run(){	
  var formsObj 		=parent.content.summaryreport.document.forms[0];
  var p_fm_date		=formsObj.fm_bill_date.value;
  var p_to_date 	=formsObj.to_bill_date.value;
  var facility_id	=formsObj.facilityId.value;
  var p_report_id	=formsObj.p_report_id.value;
  var locale		=formsObj.locale.value;
  var session_id	=formsObj.p_session_id.value;
  var p_module_id	=formsObj.p_module_id.value;
  var p_pgm_date	=formsObj.p_pgm_date.value;
  var cash_counter	=formsObj.cash_count.value; 
  var user			=formsObj.user.value; 
  var usercode		=formsObj.user_.value;  //V201124
  var loggedUserId 	=formsObj.p_user_name.value;
  var Zero_bill		=formsObj.zero_bill.value; 
 //V201124 starts
  if(p_fm_date==''){
		formsObj.fm_bill_date.focus();    
		alert(getMessage("BL00948",'BL'));
		return false;
	}
	else if( p_to_date==''){
		formsObj.to_bill_date.focus();
		alert(getMessage("BL00948",'BL'));
	  	return false;
	}
  
  //V201124 ends
	if(cash_counter==''){
		cash_counter =cash_counter.replace(/\#/g,' ');	
		cash_counter =cash_counter.replace(/\&/g,' ');	
		formsObj.cash_counter.value = cash_counter;
	}
	if(user==''){
		user =user.replace(/\#/g,' ');	
		user =user.replace(/\&/g,' ');	
		formsObj.user.value = user;
	}
	var pgm_id=p_report_id;	
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	
	var param1 = "&p_report_id="+p_report_id+"&param1="+cash_counter+
	"&param2="+usercode +
	"&param3="+p_fm_date  +
	"&param4="+p_to_date +"&param5=" +loggedUserId; //V201124
		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLCommonReportValidation.jsp?func_mode=col_sum"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split(":::");
	
	if(retValArr.length == 2){	
		session_id = retValArr[0];
		p_pgm_date = retValArr[1];
		
	var htmlVal = "<html><body>";
	htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
	htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'>";
	htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
	htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+pgm_id+"'>";
	htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
	htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
	htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+p_pgm_date+"'>";
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

