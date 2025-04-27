async function showPatientIDLookUp() {
	var patid=await PatientSearch();
	if( patid ==null)patid="";
	document.forms[0].patientId.value = patid;
	document.forms[0].patientId.focus();
}

function callSearch(){

	var patientId			= document.forms[0].patientId.value;
	var encounterType		= document.forms[0].encounterType.value;
	var encounterId			= document.forms[0].encounterId.value;
	var isPanCardAvailableYN	= document.forms[0].isPanCardAvailableYN.value;
	if(patientId==""){
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel('Common.patientId.label','Common'));
		alert(error);
	}else{
		parent.frames[2].location.href = '../../eMP/jsp/Form60SearchResults.jsp?patientId='+patientId+'&encounterType='+encounterType+'&encounterId='+encounterId+'&isPanCardAvailableYN='+isPanCardAvailableYN;
	}
}

async function showModalCurEnc(enc,patid,patclass) { 
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "80vh";
	var dialogWidth	= "65vw";
	var dialogTop = "0vh" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid+"&Patient_Class="+patclass,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}

function fnShowNoRecords(){
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	parent.frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
}

async function fnOpenForm60Window(encounterId,patientId,form60Status,facilityId,episodeId,episodeType,opEpisodeVisitNum){
	
	var retVal	= new String();
	var dialogHeight= "80vh";
	var dialogWidth	= "80vw";
	var dialogTop = "0vh" ;
	var center = "" ;
	var status="no";
	var arguments	= "" ;
		
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ;  status:" + status  + "; dialogTop :" + dialogTop ;
	var callurl="../../eMP/jsp/addModifyForm60Frameset.jsp?encounterId="+encounterId+"&patientId="+patientId+"&status="+form60Status+"&facilityId="+facilityId+"&episodeId="+episodeId+"&episodeType="+episodeType+"&opEpisodeVisitNum="+opEpisodeVisitNum;
	retVal =await window.showModalDialog(callurl,arguments,features);
	
		if(retVal!=null){ 
			parent.frames[2].document.location.reload();
		}
}

function fnSave(){
	document.forms[0].form60Status.value="D";
	
	if(document.forms[0].status.value==""){
		document.forms[0].operation.value	= "insert";
	}else{
		document.forms[0].operation.value	= "modify";
	}
	document.forms[0].action="../../servlet/eMP.MPForm60Servlet";
	document.forms[0].submit();	
}

function fnFinalize(){
	

document.forms[0].form60Status.value="F";

var isAppliedForPan = document.forms[0].isAppliedForPan.value;

var fatherFirstName = getLabel('eMP.Father.label','MP') + " " + getLabel('Common.FirstName.label','common');
var fatherMiddleName = getLabel('eMP.Father.label','MP') + " " + getLabel('eMP.MiddleName.label','MP');
var fatherSurname = getLabel('eMP.Father.label','MP') + " " + getLabel('eMP.Surname.label','MP');
var TownCity = getLabel('eMP.TownCity.label','MP');
var District = getLabel('eMP.District.label','MP');
var State = getLabel('Common.State.label','common');
var country = getLabel('Common.country.label','common');
var Pincode = getLabel('eMP.Pincode.label','MP');
var TelephoneNumber = getLabel('eAM.TelephoneNumber.label','AM');
var MobileNo = getLabel('eMP.MobileNo.label','MP');
var isSubmit		= "false";
var error			 = "";




	if(document.form60AddModify.firstName.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',getLabel('Common.FirstName.label','common'));
			error = error + "<br>" ;
	}
	if(document.form60AddModify.middleName.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',getLabel('eMP.MiddleName.label','MP'));
			error = error + "<br>" ;
	}
	if(document.form60AddModify.surname.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',getLabel('eMP.Surname.label','MP'));
			error = error + "<br>" ;
	}
	if(document.form60AddModify.dobInsOfDec.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',getLabel('eMP.DobInsOfDec.label','MP'));
			error = error + "<br>" ;
	}

	if(document.form60AddModify.fatherFirstName.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',fatherFirstName);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.fatherMiddleName.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',fatherMiddleName);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.fatherSurname.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',fatherSurname);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.townCity.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',TownCity);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.district.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',District);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.state.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',State);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.country.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',country);
			error = error + "<br>" ;
	}

	if(document.form60AddModify.pinCode.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',Pincode);
			error = error + "<br>" ;
	}

	if(document.form60AddModify.telephoneNo.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',TelephoneNumber);
			error = error + "<br>" ;
	}
	if(document.form60AddModify.mobileNo.value==""){
			error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$',getLabel('eMP.MobileNo.label','MP'));
			error = error + "<br>" ;
	}

	if(isAppliedForPan == "Y"){
		var PANAcknowledgement = getLabel('eMP.PANAcknowledgement.label','MP');
		var PANDateOfApplication = getLabel('eMP.PANDateOfApplication.label','MP');
		if(document.form60AddModify.PANAcknowledgement.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',PANAcknowledgement);
				error = error + "<br>" ;
		}
		if(document.form60AddModify.PANDateOfApplication.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',PANDateOfApplication);
				error = error + "<br>" ;
		}

	} else{
		if(document.form60AddModify.estAgriIncome.value=="" &&  document.form60AddModify.estNonAgriIncome.value==""){
			error = error+ getMessage("EST_AGRI_INCOME_NON_INCOME","MP");
			error = error.replace('$',getLabel('eMP.EstimatedAgriculturalIncome.label','MP'));
			error = error.replace('#',getLabel('eMP.EstimatedNonAgriculturalIncome.label','MP'));
			error = error + "<br>" ;
		}
		var SupportIdentifyProof = getLabel('eMP.SupportIdentifyProof.label','MP');
		var SupportOfAddress	= getLabel('eMP.SupportOfAddress.label','MP');
		var DocumentIdentificationNumber = getLabel('eMP.DocumentIdentificationNumber.label','MP');
		var NameAndAddressOfAuthority = getLabel('eMP.NameAndAddressOfAuthority.label','MP');
	

		if(document.form60AddModify.idProofDocCode.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',SupportIdentifyProof);
				error = error + "<br>" ;
		}
		if(document.form60AddModify.idProofDocIdNo.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',DocumentIdentificationNumber);
				error = error + "<br>" ;
		}
		if(document.form60AddModify.idProofNameAddOfAuthority.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',NameAndAddressOfAuthority);
				error = error + "<br>" ;
		}
		if(document.form60AddModify.addProofDocCode.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',SupportOfAddress);
				error = error + "<br>" ;
		}

		if(document.form60AddModify.addProofDocIdNo.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',DocumentIdentificationNumber);
				error = error + "<br>" ;
		}

		if(document.form60AddModify.addProofNameAddOfAuthority.value==""){
				error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
				error = error.replace('$',NameAndAddressOfAuthority);
				error = error + "<br>" ;
		}
		
	}
	if(error!=""){
		parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
	}else{
		document.forms[0].form60Status.value="F";
		if(document.forms[0].status.value==""){
			document.forms[0].operation.value	= "insert";
		}else{
			document.forms[0].operation.value	= "modify";
		}
		document.forms[0].action="../../servlet/eMP.MPForm60Servlet";
		document.forms[0].submit();
	}



	
}

function onSuccess(){

	alert(getMessage("RECORD_INSERTED",'SM'));
	parent.window.close();
	
	
}

function onSuccessCancel(){
	alert(getMessage("FORM60_CANCELED",'MP'));
	frames[2].location.reload();

	
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
		/* if (pat_status=="SUSPENDED"){  
				 ErrorMessage= getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="DECEASED"){
				 ErrorMessage= getMessage('PAT_DECEASED_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="SECURED"){
				 ErrorMessage= getMessage('SECURED_NOT_ALLOWED','COMMON'); 
			  }else if (pat_status=="INACTIVE"){
				 ErrorMessage= getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'); 
			  }else if (pat_status=="BLACKLISTED_PATIENT"){
				 ErrorMessage= getMessage('BLACKLISTED_PATIENT','MP'); 
			  }else*/ if ( pat_status=="INVALID_PATIENT"){
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

function PanCardAvailCheck(obj){
	var patientId			= obj.value;
	if(patientId!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PanCardAvailCheck' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		/*if(responseText == "Y"){
			var msg = getMessage("PANCARD_AVAILABLE_NO_FORM60","MP");
			alert(msg);
			obj.value="";
			obj.focus();
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}*/
		document.forms[0].isPanCardAvailableYN.value	= responseText;
	}
}

function CheckForPipeChars(event){
		var strCheck = '|,~,=,#';	
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return false ;
}

function NumberCheck(event)
{
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function SplCharCheck(event)
{
	var strCheck = '0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function validSplchars(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="PAN Acknowledgement";									
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function ChecksplCharsAlphabet(Obj){	
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
			if(!((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57)))
			{
				specCharsExist = true;
				break;
			}
        }
        if(specCharsExist == true){
			alert(getMessage("RESTRICT_ALPHBET_SPLCHAR","MP"));
			Obj.value="";
			Obj.focus();
		}
    }



  function fnCancelForm60(facilityId,episodeId,episodeType,opEpisodeVisitNum,status,encounterId,ackNO){

	if(status=="F"){
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH facilityId=\""+facilityId+"\" episodeId=\""+episodeId+"\" episodeType=\""+episodeType+"\" opEpisodeVisitNum=\""+opEpisodeVisitNum+"\" encounterId=\""+encounterId+"\" ackNO=\""+ackNO+"\" action='validateForm60' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMP/jsp/MPIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		var billGenYN	= TrimStr(responseText);

		if(billGenYN=="Y"){
			alert(getMessage("FORM60_CAN_NOT_CANCELED",'MP'));
		}else{
			if(confirm(getMessage("CANCEL_FORM60","MP"))){
				document.forms[0].operation.value = "cancel";
				document.forms[0].ACKNOWLEDG_NO_FORM60.value = ackNO;
				document.forms[0].encounterId.value = encounterId;
				document.forms[0].method="POST";
				document.forms[0].action="../../servlet/eMP.MPForm60Servlet";
				document.forms[0].submit();
			}
		}
	}else{
		if(confirm(getMessage("CANCEL_FORM60","MP"))){
				document.forms[0].operation.value = "cancel";
				document.forms[0].ACKNOWLEDG_NO_FORM60.value = ackNO;
				document.forms[0].encounterId.value = encounterId;
				document.forms[0].method="POST";
				document.forms[0].action="../../servlet/eMP.MPForm60Servlet";
				document.forms[0].submit();
		}
	}
	 
 }


  function openReport(encounterId,patientId,facilityId,episodeId,episodeType,opEpisodeVisitNum){
		var HTMLVal = new String();
		document.forms[0].p_encounter_id.value = encounterId;
		document.forms[0].p_facility_id.value = facilityId;
		document.forms[0].p_patient_id.value = patientId;
		document.forms[0].p_episode_type.value = episodeType;
		document.forms[0].p_episode_id.value = episodeId;
		document.forms[0].p_visit_id.value = opEpisodeVisitNum;
		document.forms[0].method="GET";
		document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		document.forms[0].submit();
  }

  function reset(){
	frames[1].location.reload();
	frames[2].location.href = '../../eCommon/html/blank.html';
	frames[3].location.href = '../../eCommon/jsp/error.jsp'
  }

  function ZeroCheck(obj2){ 	 
	if(obj2.value!=""){
		if (obj2.value <= 0){
			var msg = getMessage("ZERO_CHECK","MP");
			if(obj2.name == document.form60AddModify.AdharNoIssuedByUIDAI.name)
				msg = msg.replace("$",getLabel('eMP.AdharNoIssuedByUIDAI.label','MP') );
		   if(obj2.name == document.form60AddModify.PANAcknowledgement.name)
				msg = msg.replace("$",getLabel('eMP.PANAcknowledgement.label','MP') );
		   if(obj2.name == document.form60AddModify.noOfPersonsInvolved.name)
				msg = msg.replace("$",getLabel('eMP.NumberOfPersonInvolved.label','MP') );
		   if(obj2.name == document.form60AddModify.amountOfTransaction.name){
				msg = msg.replace("$",getLabel('eMP.AmountOfTransaction.label','MP') );
		   }
			alert(msg);
			obj2.value="";
			obj2.focus();		
		}	
	}
}
function checkDigitCount(obj3){
	var digits = obj3.value;
	var message = getMessage("PAN_AADHAR_DIGIT_CHK","MP");
	var showalert	= "N"
	if(obj3.value!=""){
		if(obj3.name == document.form60AddModify.AdharNoIssuedByUIDAI.name)	{
			if(digits.length < 12){
				message = message.replace("$",getLabel('eMP.AdharNoIssuedByUIDAI.label','MP'));
				message = message.replace("#","12" );
				showalert	= "Y";
			}
		}else if(obj3.name == document.form60AddModify.PANAcknowledgement.name) {
			if(digits.length < 16){
			message = message.replace("$",getLabel('eMP.PANAcknowledgement.label','MP') );
			message = message.replace("#","16" );
				showalert	= "Y";
			}
		}
		if(showalert=="Y"){
			alert(message);
			obj3.value="";
			obj3.focus();
		}
	}

}
function fnSetValue(val){

	document.forms[0].isAppliedForPan.value = val;	

	var isAppliedForPan = document.forms[0].isAppliedForPan.value;
	
	if(isAppliedForPan == "N")
		{
			document.forms[0].estAgriIncome.disabled = false;
			document.forms[0].estNonAgriIncome.disabled = false;

			document.forms[0].idProofNameAddOfAuthority.disabled = false;
			document.forms[0].idProofDocIdNo.disabled = false;
			document.forms[0].idProofDocCode.disabled = false;

			document.forms[0].addProofNameAddOfAuthority.disabled = false;
			document.forms[0].addProofDocIdNo.disabled = false;
			document.forms[0].addProofDocCode.disabled = false;
			
			document.forms[0].PANAcknowledgement.value = "";
			document.forms[0].PANAcknowledgement.disabled = true;
			document.forms[0].PANDateOfApplication.value = "";
			document.forms[0].PANDateOfApplication.disabled = true;

			document.getElementById("mndt_panACK").style.visibility = 'hidden';
			document.getElementById("mndt_panDate").style.visibility = 'hidden';
			document.getElementById("DatePick").style.visibility = 'hidden';

			document.getElementById("IdName").style.visibility = 'visible';
			document.getElementById("IdNumb").style.visibility = 'visible';
			document.getElementById("IdProof").style.visibility = 'visible';

			document.getElementById("AddName").style.visibility = 'visible';
			document.getElementById("AddNumb").style.visibility = 'visible';
			document.getElementById("AddProof").style.visibility = 'visible';

			document.getElementById("mndt_agri").style.visibility = 'visible';
			document.getElementById("mndt_nonagri").style.visibility = 'visible';

		}
	if(isAppliedForPan == "Y")
		{
			document.forms[0].estAgriIncome.value = "";
			document.forms[0].estAgriIncome.disabled = true;
			document.forms[0].estNonAgriIncome.value= "";
			document.forms[0].estNonAgriIncome.disabled = true;
			
			document.forms[0].idProofNameAddOfAuthority.value= "";
			document.forms[0].idProofNameAddOfAuthority.disabled = true;
			document.forms[0].idProofDocIdNo.value = "";
			document.forms[0].idProofDocIdNo.disabled = true;
			document.forms[0].idProofDocCode.value = "";
			document.forms[0].idProofDocCode.disabled = true;
			
			document.forms[0].addProofNameAddOfAuthority.value = "";
			document.forms[0].addProofNameAddOfAuthority.disabled = true;
			document.forms[0].addProofDocIdNo.value = "";
			document.forms[0].addProofDocIdNo.disabled = true;
			document.forms[0].addProofDocCode.value = "";
			document.forms[0].addProofDocCode.disabled = true;

			document.forms[0].PANAcknowledgement.disabled = false;
			document.forms[0].PANDateOfApplication.disabled = false;

			document.getElementById("mndt_panACK").style.visibility = 'visible';
			document.getElementById("mndt_panDate").style.visibility = 'visible';
			document.getElementById("DatePick").style.visibility = 'visible';

			document.getElementById("IdName").style.visibility = 'hidden';
			document.getElementById("IdNumb").style.visibility = 'hidden';
			document.getElementById("IdProof").style.visibility = 'hidden';

			document.getElementById("AddName").style.visibility = 'hidden';
			document.getElementById("AddNumb").style.visibility = 'hidden';
			document.getElementById("AddProof").style.visibility = 'hidden';

			document.getElementById("mndt_agri").style.visibility = 'hidden';
			document.getElementById("mndt_nonagri").style.visibility = 'hidden';
		} 
}

function validDateObjform60(date, format, locale){
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
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				date.value="";
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

function validate_date(obj) {
		
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {

				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				obj.value="";
				return false ;
			}
		}
  }


 function callCheckMaxLen(obj,maxSize) {

		var legendName = getLabel('eMP.NameAndAddressOfAuthority.label','MP') ;
        if ( obj.value.length > maxSize ) {
			var error = getMessage('REMARKS_SHOULD_LS_EQUAL','COMMON');
			error = error.replace('$',legendName);
			error = error.replace('#',maxSize);
			alert(error);
			obj.focus();
			obj.value=obj.value.substring(0,maxSize);
			return false;
        }
}



