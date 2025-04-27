/* 
Sr No        Version          Incident/TFS      SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201104            5475        MOHE-CRF-0050.3     	 Mohana Priya K
2			 V201124			8638	BL-MOHE-CRF-0050.3 US001/
										01-Unbilled Report 3T        Mohana Priya K
*/

function reset()
{
	unbillreport.location.reload();
}

//Effective From and ToDate Logic
function toFromDateChk(obj){	
	if(!(obj.value=="")){		
		var locale    =  document.forms[0].locale.value;
		var effFromDt =  document.forms[0].fm_bill_date.value;
		var effToDt   =  document.forms[0].to_bill_date.value;
		
		if(validDate(obj.value,"DMY",locale)){  
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL6015",'BL'));
				obj.value = '';
				return false;
			}
			if(effFromDt != '' && effToDt !=''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){		
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}else
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

function checkDateBL(entered_date)
{		
	var locale    = document.forms[0].locale.value;
	var effFromDt = document.forms[0].fm_bill_date.value;
	var effToDt   = document.forms[0].to_bill_date.value;
	
	if(entered_date.value!=""){   
		if(validDate(entered_date.value,'DMY',locale)){
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
	}else
	{
		return true;
	}
}
//Effective From and ToDate Logic

function focus_val(){  //V201124
	document.getElementById("cut_off_date").focus();
}

function cut_off(entered_date){
	var cutoff    = document.forms[0].cut_off_date.value;
	var locale    = document.forms[0].locale.value;
	if(entered_date.value!="") {   	
		if(validDate(entered_date.value,'DMY',locale)){
			if(cutoff!=getCurrentDate('DMY',locale) && isAfterNow(cutoff,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				entered_date.value = '';
				return false;
			}
		}else
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

function run(){	
	var formsObj      =  parent.content.unbillreport.document.forms[0];
	var p_fm_date	  =  formsObj.fm_bill_date.value;
	var p_to_date     =  formsObj.to_bill_date.value;
	var facility_id   =  formsObj.facilityId.value;
	var p_report_id   =  formsObj.p_report_id.value;
	var locale        =  formsObj.locale.value;
	var session_id    =  formsObj.p_session_id.value;
	var p_module_id   =  formsObj.p_module_id.value;
	var p_pgm_date    =  formsObj.p_pgm_date.value;
	var Frm_Pat_no    =  formsObj.Frm_Pat_no.value;
	var To_Pat_no	  =  formsObj.To_Pat_no.value;
	var EpisodeType   =  formsObj.EpisodeType.value;
	var Frm_bill_Gp   =  formsObj.Frm_bill_Gp.value;
	var To_bill_Gp	  =  formsObj.To_bill_Gp.value;
	var fm_CustCode	  =  formsObj.fm_CustCode.value;
	var To_CustCode	  =  formsObj.To_CustCode.value;
	var cut_off_date  =  formsObj.cut_off_date.value;
	var loggedUserId  =  formsObj.p_user_name.value;
	var inc_ip_dc_pat =  formsObj.inc_cur_ip_dc_pat.value;
	var inc_Zero_rec  =  formsObj.inc_Zero_rec.value;
	var today = new Date();   //V201124
	var curdate = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();  //V201124
	
	if(EpisodeType!='I' && EpisodeType!='O' && EpisodeType!='R' && EpisodeType!='E' && EpisodeType!='D'){
		alert(getMessage("BL4151",'BL'));
		return false;	
	}
	 
	if(Frm_Pat_no==''){
		Frm_Pat_no =Frm_Pat_no.replace(/\#/g,' ');	
		Frm_Pat_no =Frm_Pat_no.replace(/\&/g,' ');	
		formsObj.Frm_Pat_no.value = Frm_Pat_no;
	}
	if(To_Pat_no==''){
		To_Pat_no =To_Pat_no.replace(/\#/g,' ');	
		To_Pat_no =To_Pat_no.replace(/\&/g,' ');	
		formsObj.To_Pat_no.value = To_Pat_no;
	}
	if(Frm_bill_Gp==''){
		Frm_bill_Gp =Frm_bill_Gp.replace(/\#/g,' ');	
		Frm_bill_Gp =Frm_bill_Gp.replace(/\&/g,' ');	
		formsObj.Frm_bill_Gp.value = Frm_bill_Gp;
	}
	if(To_bill_Gp==''){
		To_bill_Gp =To_bill_Gp.replace(/\#/g,' ');	
		To_bill_Gp =To_bill_Gp.replace(/\&/g,' ');	
		formsObj.To_bill_Gp.value = To_bill_Gp;
	}

	if(fm_CustCode==''){
		fm_CustCode =fm_CustCode.replace(/\#/g,' ');	
		fm_CustCode =fm_CustCode.replace(/\&/g,' ');	
		formsObj.fm_CustCode.value = fm_CustCode;
	}
	if(To_CustCode==''){
		To_CustCode =To_CustCode.replace(/\#/g,' ');	
		To_CustCode =To_CustCode.replace(/\&/g,' ');	
		formsObj.To_CustCode.value = To_CustCode;
	}
	
	//V201124 STARTS
	if(cut_off_date==''){  
		document.getElementById("cut_off_date").focus();
		alert(getMessage("BL00948",'BL'));
		return false;	
	}
	if(p_fm_date==''){
		p_fm_date = curdate;
	}
	if(p_to_date==''){
		p_to_date = curdate;
	}
	//V201124 ENDS
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&facility_id="+facility_id+"&p_report_id="+p_report_id+"&param1="+Frm_Pat_no+
	"&param2="+To_Pat_no +
	"&param3="+cut_off_date  +
	"&param4="+EpisodeType +"&param5="+inc_ip_dc_pat +
	"&param6="+inc_Zero_rec +"&param8="+p_fm_date +"&param9="+p_to_date +
	"&param10="+Frm_bill_Gp +"&param11="+To_bill_Gp +"&param12="+fm_CustCode+"&param13="+To_CustCode ;

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
		htmlVal += "<input type='hidden' name='session_id' id='session_id' value='"+session_id+"'>";
		htmlVal += "<input type='hidden' name='pgm_date' id='pgm_date' value='"+p_pgm_date+"'>";
		htmlVal += "<input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";  
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
		htmlVal += "</form></body></html>";
	
		dummy_frame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
		dummy_frame.document.dummy_frm.submit();		 
	}
	else{
		alert(retValArr[1]); 
	}
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function PatientLookup(sqlselect, obj, code){
	var facility = document.forms[0].facilityId.value;
	var locale   = document.forms[0].locale.value;
    var formObj  = document.forms[0];
  
    var title = "";
	var sql   = "";
	
	sql="select short_name description,patient_id code from mp_patient_mast where UPPER (short_name) LIKE UPPER (?) AND UPPER (patient_id) LIKE UPPER (?)  order by 1 ";
	switch (sqlselect) {
     case 1:  {	 
	   title	= 	getLabel("eBL.FrmPatno.label", 'bl');
	   break;
	 }
     case 2:
		{  
			title = getLabel("eBL.ToPatno.label", 'bl');
             break;
		}
	 }
	    var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "2,1";
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;

	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		obj.value			=   retVal[1];
		code.value 			= 	retVal[0];
	}
	else
	{
        obj.value = '';
        code.value = '';
	}
}

function BillGpLookup(sqlselect, obj, code){
	var facility = document.forms[0].facilityId.value;
	var locale   = document.forms[0].locale.value;
    var formObj  = document.forms[0];
  
    var title	="";
	var sql     ="";
	
	 sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where nvl(status,'X') != 'S' and upper(language_id) = upper('" +
		locale +
		"') AND UPPER (blng_grp_id) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?)  order by 1  ";
	switch (sqlselect) {
     case 1: {	 
    		title		= 	getLabel("eBL.FrmBillingGrp.label", 'bl');
    	 	break;
	 }
     case 2:
		{  
			title = getLabel("eBL.ToBillingGrp.label", 'bl');
             break;
		}
	 }
	    var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		argumentArray[0] = sql;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[1] = dataNameArray;
	    argumentArray[4] = "1,2";
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;

	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		obj.value			=   retVal[1];
		code.value 				= 	retVal[0];
	}
	else
	{
        obj.value = '';
        code.value = '';
	}
}

function CustCodeLookup(sqlselect, obj, code){
	var facility	= document.forms[0].facilityId.value;
	var locale		= document.forms[0].locale.value;
    var formObj	    = document.forms[0];
    var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    var title	="";
	var sql="";
	sql="select cust_code code,long_name description from ar_customer_lang_vw where upper(language_id) = upper('" +
	locale +
	"')  and UPPER (cust_code) LIKE UPPER (?) AND UPPER (long_name) LIKE UPPER (?) order by 1 ";	 

	 switch (sqlselect) {
     case 1:  {
    	 	title	= 	getLabel("eBL.FrmCustCode.label", 'bl');
    	 	break;
	 }
     case 2:
		{
			title = getLabel("eBL.ToCustCode.label", 'bl');
             break;
		}
	 }
	
	argumentArray[0] = sql;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[1] = dataNameArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		obj.value			=   retVal[1];
		code.value 			= 	retVal[0];
	}
	else
	{
        obj.value = '';
        code.value = '';
	}
}

function include_cur_pat(){
	var cutoff    = document.forms[0].cut_off_date.value;
	var check=document.getElementById('inc_cur_ip_dc_pat').checked;
	if(check=='true' || check==true){
		document.getElementById('inc_cur_ip_dc_pat').value='Y';
	}else{
		document.getElementById('inc_cur_ip_dc_pat').value='N';
	}
}

function include_Zero_rec(){
	var cutoff    = document.forms[0].cut_off_date.value;
	var check=document.getElementById('inc_Zero_rec').checked;
	if(check=='true' || check==true){
		document.getElementById('inc_Zero_rec').value='Y';
	}else{
		document.getElementById('inc_Zero_rec').value='N';
	}
}

function isBeforefm(from,to){
	if(from>to){
		return false;
	}else 
		return true;
}

function toFromCheck(option){
	var formsObj = document.forms[0];
	var Frm_Pat_no   = formsObj.Frm_Pat_no.value;
	var To_Pat_no	 = formsObj.To_Pat_no.value;
	var Frm_bill_Gp	 = formsObj.Frm_bill_Gp.value;
	var To_bill_Gp	 = formsObj.To_bill_Gp.value;
	var fm_CustCode	 = formsObj.fm_CustCode.value;
	var To_CustCode	 = formsObj.To_CustCode.value;
   
if(option==1){ 
 if(Frm_Pat_no != '' && To_Pat_no !=''){
		if((!isBeforefm(Frm_Pat_no,To_Pat_no)))
		{	
			alert(getMessage("BL7060",'BL'));
			formsObj.To_Pat_no.value = '';
			return false;
		}
		else
		{			
			return true;
		}	
	}
 }
if(option==2){
	if(Frm_bill_Gp != '' && To_bill_Gp !=''){
		if((!isBeforefm(Frm_bill_Gp,To_bill_Gp)))
		{		
			alert(getMessage("BL7060",'BL'));
			formsObj.To_bill_Gp.value = '';
			return false;
		}
		else
		{			
			return true;
		}
		
	}
}			
if(option==3){
    if(fm_CustCode != '' && To_CustCode !=''){  
		if((!isBeforefm(fm_CustCode,To_CustCode)))
		{		
			alert(getMessage("BL7060",'BL'));
			formsObj.To_CustCode.value = '';
			//formObj.To_code.value='';
			return false;
		}
		else
		{			
			return true;
		}
	}
	}
}

function episodeTpyeChange(val){
	var type=document.getElementById('EpisodeType').value;
	if(type=='I' || type=='D'){
		document.getElementById('inc_cur_ip_dc_pat').disabled=false;
	}else{
		document.getElementById('inc_cur_ip_dc_pat').checked=false;
		document.getElementById('inc_cur_ip_dc_pat').disabled=true;
	}		
}


