 /*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
14/10/2019	IN071513		Ramesh G		14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
06/04/2020	IN072674	    Durga Natarajan	07/04/2020		Ramesh G		MMS-KH-CRF-0032
14/07/2022  33870           Twinkle Shah       21/07/2022		Ramesh G        ML-MMOH-CRF-1763
10/03/2022  36285            Hariharan k      		        Ramesh G        MMs-DM-CRF-0221.v1.0(003)
16/10/2023  32902              Ranjith P R      17/10/2023		Ramesh G        MMS-DM-CRF-0210
---------------------------------------------------------------------------------------------------------------
*/
function reset() {
	f_query_add_mod.document.caParamForFacilityForm.reset();
}

function onSuccess() 
{
	f_query_add_mod.location.reload();
}
function apply() {
	//IN072674 starts
	var flag=false;	
	//if(f_query_add_mod.document.forms[0].document.getElementById("ackVitals_SiteFlag").value!="false"){
	if(f_query_add_mod.document.getElementById('ackVitals_SiteFlag').value!="false"){
		if(f_query_add_mod.document.getElementById("ThirdParty_Vitals_Time_Dur").value!="")
			flag=true;
		else {	
			var errors = "" ;	
			var i="Difference of Time Period  ";
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent([i])))+"<br>";
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
			return false ;
		}//IN072674 ends
	}
	f_query_add_mod.document.caParamForFacilityForm.submit();
}
function logoClinicalNotes(logoValue){
	document.caParamForFacilityForm.logo_site_facility.value=logoValue;
}
//IN072674 starts
function DifferenceofTimePeriod(obj){
	
	document.caParamForFacilityForm.ThirdParty_Vitals_Time_Dur.value=obj.value;
}
function isValidInteger(obj) {
	
	var key = window.event.keyCode;
	if(!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
} 
function checkForMandatory(obj){
	     var errors = "" ;	
		  var i="Difference of Time Period ";
		   if(obj.value==""){
			 errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent([i])))+"<br>";
				parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
			 obj.focus();
			
		 }
	}
function copyPasteChk(obj){
	var difftimeperiod="";
	var string=obj.value;
	var strCheck = "0123456789";
	for(i=0;i<string.length;i++)
		{
		if (strCheck.indexOf(string.charAt(i)) == -1) {
			difftimeperiod=difftimeperiod;
        }
		else{
			difftimeperiod+=string.charAt(i);
		}
		}
	
	obj.value= difftimeperiod; 
}

function zerocheck()
{
var minutes =document.getElementById("Differenceof_TimePeriod").value;

if(minutes< 1)
		{
			alert(getMessage("CA_THIRDPARTY_VITALS_TIME_DUR",'CA'));
			document.getElementById("Differenceof_TimePeriod").select();
			document.getElementById("Differenceof_TimePeriod").focus();
		}
}
// IN072674 ends

// 33870 start.
function defaultLoggedPractitionerByLocation(obj)
{
	if(obj.checked)
		document.caParamForFacilityForm.pract_loc_default_yn.value = 'Y';
	else
	document.caParamForFacilityForm.pract_loc_default_yn.value = 'N';
}
//33870 end.

//36285 start.
function enablePrimaryAndSecondaryProcedure(obj)
{
	if(obj.checked)
		document.caParamForFacilityForm.en_pri_sec_proc_yn.value = 'Y';
	else
	document.caParamForFacilityForm.en_pri_sec_proc_yn.value = 'N';
}
//36285 end.

//32902 start.
function hidePatientsForUnauthorizedPractitioners(obj)
{
	if(obj.checked)
		document.caParamForFacilityForm.hide_pat_unauth_pract_yn.value = 'Y';
	else
	document.caParamForFacilityForm.hide_pat_unauth_pract_yn.value = 'N';
}
//32902 end.

