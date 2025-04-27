/**
Sr No       Version        Incident        SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1           V210401						MOHE-CRF-0063-TF-US001      Shikha Seth
2			V210517			16591		MOHE-CRF-0055.1				Nandhini M
3			V210528			18965		MOHE-CRF-0055.1-TP-US001	MuthukumarN
4			V210615			20139	    MOHE-CRF-0055.2			    Mohana Priya K
 */

function reset()
{
	var fetch='';
	summaryreport.location.replace="../../eBL/jsp/BLGenerateEClaims.jsp?fetchoption="+fetch; //V210615
	//summaryreport.location.reload();//Commented V210615
}


//bill From and ToDate Logic 
function toFromDateChk(obj)
{	
	var effFromDt =document.forms[0].fm_bill_date.value;
	
	if(effFromDt=='')
	{
		//alert("APP-BL0878 Bill Date cannot be null");
		alert(getMessage("BL0940","BLEXT")); //V210627
		document.getElementById("fm_bill_date").focus();
	  	return false;
	}
	
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].fm_bill_date.value;
		var effToDt =document.forms[0].to_bill_date.value;
		
		if(validDate(obj.value,"DMY",locale))
		{
			/*if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				obj.value = '';
				return false;
				
			}*/
			
			if(effFromDt != ''){
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
			if(effFromDt=='' && effToDt==''){
  				alert("APP-BL0878 Bill Date cannot be null");
  			  	return false;
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
  	var locale=document.forms[0].locale.value;
  	var effFromDt =document.forms[0].fm_bill_date.value;
  	var effToDt =document.forms[0].to_bill_date.value;
			
  	if(entered_date.value!="")
  	{
  		if(validDate(entered_date.value,'DMY',locale))
  		{
  			if(!isBeforeNow(entered_date.value,'DMY',locale)){
  				alert(getMessage("BL9114",'BL'));
  				entered_date.value='';
  				return false;
  			}		
  			if(effToDt != ''){
  				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{
  					alert(getMessage("BL7060",'BL'));
  					entered_date.value='';
  					return false;
				}
				else{
						return true;
				}
  			}			
  			if(effFromDt=='' && effToDt==''){
  				alert(getMessage('BL0878','BLEXT'));
				document.getElementById("to_bill_date").focus();
  			  	return false;
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
//bill From and ToDate Logic

//Encounter From and ToDate Logic //V210615 Starts
function toFromEncDateChk(obj)
{	
	var encFromDt =document.forms[0].fm_enc_date.value;
	
	if(encFromDt=='')
	{
		//alert("APP-BL0878 Bill Date cannot be null");
		alert(getMessage("BL00916","BL")); //V210627
		document.getElementById("fm_enc_date").focus();
	  	return false;
	}
	
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var encFromDt =document.forms[0].fm_enc_date.value;
		var encToDt =document.forms[0].to_enc_date.value;
		
		if(validDate(obj.value,"DMY",locale))
		{
			/*if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				obj.value = '';
				return false;
				
			}*/
			
			if(encFromDt != ''){
				if((!isBefore(encFromDt,encToDt,'DMY',locale)))
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
			if(encFromDt=='' && encToDt==''){
  				alert("APP-BL0878 Bill Date cannot be null");
  			  	return false;
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

function checkEncDateBL(entered_date)
{		
  	var locale=document.forms[0].locale.value;
  	var encFromDt =document.forms[0].fm_enc_date.value;
  	var encToDt =document.forms[0].to_enc_date.value;
			
  	if(entered_date.value!="")
  	{
  		if(validDate(entered_date.value,'DMY',locale))
  		{
  			if(!isBeforeNow(entered_date.value,'DMY',locale)){
  				alert(getMessage("BL9114",'BL'));
  				entered_date.value='';
  				return false;
  			}		
  			if(encToDt != ''){
  				if((!isBefore(encFromDt,encToDt,'DMY',locale)))
				{
  					alert(getMessage("BL7060",'BL'));
  					entered_date.value='';
  					return false;
				}
				else{
						return true;
				}
  			}			
  			if(encFromDt=='' && encToDt==''){
  				alert(getMessage('BL0878','BLEXT'));
				document.getElementById("to_enc_date").focus();
  			  	return false;
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
//Encounter From and To Date Logic //V210615 Ends

function dateRegEx(e)
{  //Added for Character Restriction in date field
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

function run()  
{
	var formsObj = parent.content.summaryreport.document.forms[0];		
	var locale=formsObj.locale.value;
	var facility_id=formsObj.facilityid.value;
	var episode_type=formsObj.episode_type.value;
	/*var month_year ="";
	if (formsObj.Month.value >9)
		month_year=formsObj.Year.value+""+formsObj.Month.value;
	else
		month_year=formsObj.Year.value+"0"+formsObj.Month.value;*/
	var p_report_id=formsObj.p_C_report_id.value;
	var locale=formsObj.locale.value;
	var session_id=formsObj.p_session_id.value;
	var p_module_id=formsObj.p_module_id.value; 
	//var p_fetch_data_by='E'; //Added against new parameter for MOHE-CRF-0055.1 //Commented V210615
	var p_fetch_data_by=formsObj.fetch_option.value;//V210615
	var loggedUserId = formsObj.p_user_name.value;
	var eclaim_report_option = formsObj.eclaim_report_option.value;
	//V210615 Starts
	var effFromDt ="";
	var effToDt ="";
	if(p_fetch_data_by=='B'){
		effFromDt =formsObj.fm_bill_date.value;
		effToDt =formsObj.to_bill_date.value;	
		if(effFromDt=='')
		{
			alert(getMessage("BL0940","BLEXT"));
			formsObj.fm_bill_date.focus();
			return false;
		}
		else if(effToDt==''){
			alert(getMessage("BL0941","BLEXT"));//20836 -> BL00941
			formsObj.to_bill_date.focus();
			return false;
		}	
	}else{
		effFromDt =formsObj.fm_enc_date.value;
		effToDt =formsObj.to_enc_date.value;	
		if(effFromDt=='')
		{
			alert(getMessage("BL00916","BL"));
			formsObj.fm_enc_date.focus();
			return false;
		}
		else if(effToDt==''){
			alert(getMessage("BL00917","BL"));
			formsObj.to_enc_date.focus();
			return false;
		}	
	}
	//V210615 Ends
/*	if(effFromDt=='')
	{
		alert(getMessage("BL00916","BL"));
		formsObj.fm_bill_date.focus();
		return false;
	}
	else if(effToDt==''){
		alert(getMessage("BL00917","BL"));
		formsObj.to_bill_date.focus();
		return false;
	}	*/ //Commented V210615
	var starr = effFromDt.split("/");
	var enarr = effToDt.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var daysDiff;
	var timeDiff;
	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
	var actualDays = 31;
	if(daysDiff > actualDays)
	{
		alert(getMessage("BL0939",'BLEXT'));//V210615
		//alert(getMessage("BL00918",'BL')); //Commented V210615
		return false;
	}
	if (eclaim_report_option = 'R') 
	{		
		p_report_id=formsObj.p_R_report_id.value;
		
	}else if (eclaim_report_option = 'C') {
		p_report_id=formsObj.p_C_report_id.value;
	}
	//var pgm_id=p_report_id;

	if(episode_type==undefined || episode_type=='')
	{
		alert(getMessage("BL00028","BL"));
		return false;
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
		
	var htmlVal = "<html><body>";
	htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
	htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'>";
	htmlVal += "<input type='hidden' name='p_episode_type' id='p_episode_type' value='"+episode_type+"'>";
	htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
	htmlVal += "<input type='hidden' name='p_enc_from_dt' id='p_enc_from_dt' value='"+effFromDt+"'>";
	htmlVal += "<input type='hidden' name='p_enc_to_dt' id='p_enc_to_dt' value='"+effToDt+"'>";
	htmlVal += "<input type='hidden' name='p_fetch_data_by' id='p_fetch_data_by' value='"+p_fetch_data_by+"'>";
	htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
	//htmlVal += "<input type='hidden' name='p_year_month' id='p_year_month' value='"+month_year+"'>";	
	htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
	htmlVal += "</form></body></html>";
	 
	dummy_frame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
	dummy_frame.document.dummy_frm.submit();
}	

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

/*function callExcelDisplay(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var facilityId=document.getElementById('facilityid').value;
	var episode_type=document.getElementById('episode_type').value;
	var effFromDt =formsObj.fm_bill_date.value;
	var effToDt =formsObj.to_bill_date.value;
	/*var month_year ="";
	if (document.getElementById('Month').value >9)
	month_year=document.getElementById('Year').value+""+document.getElementById('Month').value;
	else
		month_year=document.getElementById('Year').value+"0"+document.getElementById('Month').value;

	var err_msg="";
	var err_code="";
	
	if(episode_type==undefined || episode_type=='')
	{
		alert(getMessage("BL00028","BL"));
		return false;
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&p_facility_id="+facilityId+"&p_date_from="+effFromDt+"&p_date_to="+effToDt+"&p_episode_type="+episode_type+"&p_language_id="+locale ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLGenerateEClaimValidation.jsp?func_mode=insert"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split(":::");
	
	if(retValArr[0] ==''){	
			tmpformObj = document.BLGenerateEClaims;
			tmpformObj.noOfCols.value = "20";
			tmpformObj.method ="post";
			tmpformObj.action="../../servlet/eBL.BLGenerateEClaimservlet";
			tmpformObj.target = "messageFrame";
			tmpformObj.submit();
			parent.window.frames["summaryreport"].location.href = 'BLGenerateEClaims.jsp';
	}else{
			alert(retValArr[1]);
		}
}*/

function getFacility(obj,code,val) {		
	var loc_code_desc = '';
	var loc_code_link = ''
	var locale = document.forms[0].locale.value;	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var loc_code_desc = '';
	var loc_code_link = ''
		
	/* Commented against VPN Issue V210528
	sql="select description,code from (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"') "+
	" union select 'All Facility' description, '**' code  from dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
	" order by 2";*/
	
	sql="SELECT  facility_name description, facility_id code "+
		"FROM bl_sm_facility_param_lang_vw "+
		"WHERE UPPER (facility_name) LIKE UPPER (?) AND UPPER (facility_id) LIKE UPPER (?) "+
		"AND UPPER (language_id) = UPPER ('"+locale+"') "+
		"ORDER BY 2 ";//V210528

	title = 'Facility';
	loc_code_desc = DESC_CODE;
	loc_code_link = DESC_LINK;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;		
		if (val==1) {
			argumentArray[4] = "1,2";	
			argumentArray[5] = code;		
		}
		if (val==2) {
			argumentArray[4] = "2,1";	
			argumentArray[5] = obj.value;
		}
		argumentArray[6] = loc_code_link;
		argumentArray[7] = loc_code_desc;
		returnedValues = CommonLookup(title, argumentArray );		
		if((returnedValues != null) && (returnedValues != "") )  {							
			$('#facilityidName').val(returnedValues[1]);
			$('#facilityid').val( returnedValues[0]);
		}	
}

function clearCode(obj){
	obj.value = '';
}

//V210615
function fetchDataBy(){
	var fetch =document.forms[0].fetch_option.value;
	parent.summaryreport.location.replace="../../eBL/jsp/BLGenerateEClaims.jsp?fetchoption="+fetch;
}

