//Created by Ashwini on 05-May-2017 for ML-MMOH-CRF-0698
async function callSearchScreen()
{
	var patientid= await PatientSearch('','','','','','','Y','','','OTHER');;
	if(patientid !=null)
	document.forms[0].PatientId.value = patientid;
	document.forms[0].PatientId.focus();		 
}

function validatePatientId(obj) 
{
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}

	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}
	}
}

function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].to_enc_date.focus();
			document.forms[0].to_enc_date.select();
		}
	}
}

function validDateObj(date, format, localeName)
{
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(localeName=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}
		if(checkFlag){
			if(!validDate(date.value,format,localeName)){
				if(top.header != null){
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				date.select();
				date.focus();
				return false;
			}else{
			   	validate_date(date);
				return true;
				
			}
		}else{
			var msg=getMessage("INVALID_VALUE", "COMMON");
			alert(msg.replace('#',getLabel("Common.date.label","Common")));
			date.select();
			date.focus();
			return false;
		}
	}	
}

function validate_date(obj) 
{	
	if(obj.value!=''){

		if(isBeforeNow(obj.value,"DMY",localeName))
			return true;
		else {

			alert(getMessage("DATE_NOT_GREATER_SYSDATE","COMMON"));
			obj.select();
			obj.focus();
			obj.value="";
			return false ;
		}
	}
}

function year_check(from,to)
{
	if(from.value!="" && to.value!="")
	{
	var year_count=yearsBetween(from.value,to.value,'DMY',localeName);	
	if(year_count >= 1)
		{
			var error = getMessage('HOLIDAY_GREATER_THAN_YEAR','OA');	
			alert(error);
			document.forms[0].to_enc_date.focus();
			document.forms[0].to_enc_date.select();
			tosubmit=false;
		}else
		{
			tosubmit=true;
		}
}
}

function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function searchResult()
{
	
	var from				= document.forms[0].frm_enc_date.value ;
	var to					= document.forms[0].to_enc_date.value ;
	var patientid		    = document.forms[0].PatientId.value;
	var encounType			= document.forms[0].enc_type.value;
	var	nextRecord			= '';
	var	previousRecord		= '';
	var	validFile			= "true";

	if((from == "") && (to == ""))
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.encounterdate.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);	
		
	}
	else if(from == "")
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', "From "+getLabel("Common.encounterdate.label","Common"));
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);	
		
	}else if(to == "")
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', "To "+getLabel("Common.encounterdate.label","Common"));	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
		alert(error);		
	}
	else
	{
		var callvalue = parent.frames[2].document.location.href='../../eMR/jsp/ConfirmVisitAdmsnResult.jsp?from='+from+'&to='+to+'&patientid='+patientid+'&encounType='+encounType;	
		parent.frames[3].document.location.href='../../eCommon/jsp/error.jsp';
	}
									
}

function showReport(patientId,i) 	
{
	document.forms[0].p_patient_id.value = patientId;
	/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start*/
	var form = document.forms[0];
    var elementName = "ref_dtls_" + i;
    //var refNo = form[elementName].value;
   // var refNo = document.getElementById(elementName).value;
	//document.forms[0].p_reference_no.value	= refNo;
	/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End*/ 
	document.forms[0].method="GET";
	document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	document.forms[0].submit();
}

function fnSetvalue(type)
{
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}

//End ML-MMOH-CRF-0698


