var pat_name_in_loc_lang = new Array ();
var kPatientFullName = "";
var kFirstName = "";
var kSecondName = "";
var kThirdName = "";
var kFamilyName = "";
var kSex = "";
var kDob = "";
var kHouse = "";
var kStreet = "";
var kLandmark = "";
var kLocation_addr = "";
var kSubdist = "";
var kDistrict = "";
var kPostalCode = "";
var kPostOffice = "";
var kUID = "";

var kState = "";
var kPhoneNumber = "";
var kEmail = "";
var kVtc = "";
var kStatus = "";
var kAddhaarRequestID = "";

var kAadharPatPhotoStr = "";

function eKYCmp()
{
	var national_id = document.getElementById("national_id_no1").value;
	var national_id_prompt = document.getElementById("nat_id_prompt").value;
	var request_id = "";
	var eKYCFuncParam = "";

	if(national_id == "" || national_id == null)
	{
		alert("Enter the "+national_id_prompt+" ");
		document.getElementById("national_id_no1").focus();
		return;
	}

	var validate_flag = document.getElementById("aadhaarStatus").value;
	var aadhaar_id = document.getElementById("aadhaarID").value;

	var patient_name = "";

	eKYCFuncParam = getKYCFuncParam();

	if (national_id == aadhaar_id)
	{
		if (validate_flag == "Y")
		{
			patient_name = getPatientName();
			var r = confirm(national_id_prompt+" "+national_id+" entered for the patient "+patient_name+" has been validated.\nDo you want to validate again?");
			if (r == true)
			{
				request_id = getKYCRequestid();
				
				if (eKYCFuncParam == "0")
				{
					var responseMsg = getKYCDetails(request_id, national_id);
				}
				if (eKYCFuncParam == "1")
				{
					var responseMsg = Aadhaar_Request_1(request_id, national_id);
				}
				
			}
		}
		else
		{
			request_id = getKYCRequestid();
			
			if (eKYCFuncParam == "0")
			{
				var responseMsg = getKYCDetails(request_id, national_id);
			}
			if (eKYCFuncParam == "1")
			{
				var responseMsg = Aadhaar_Request_1(request_id, national_id);
			}

		}
	}
	else
	{
		request_id = getKYCRequestid();		
		if (eKYCFuncParam == "0")
		{
			var responseMsg = getKYCDetails(request_id, national_id);
		}
		if (eKYCFuncParam == "1")
		{
			var responseMsg = Aadhaar_Request_1(request_id, national_id);
		}
	}
}

function getPatientName()
{
	var patient_name = "";

	if(document.getElementById("first_name"))
	{
        patient_name = document.getElementById("first_name").value;
	}

	if(document.getElementById("second_name"))
	{
       patient_name = patient_name + " "+document.getElementById("second_name").value;
	}	

	if(document.getElementById("third_name"))
	{
       patient_name = patient_name + " "+document.getElementById("third_name").value;
	}

	if(document.getElementById("family_name"))
	{
		patient_name = patient_name + " "+document.getElementById("family_name").value;
	}

	return patient_name;
}


//To get request id from servlet call 
function getKYCRequestid()
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.AadhaarRequest',
		type: 'POST',
		cache: false,
		data: {
				CallType: 'GET_REQUEST_ID'
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   
   return responseMsg;

}

//To get request id from servlet call 
function getKYCFuncParam()
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.AadhaarRequest',
		type: 'POST',
		cache: false,
		data: {
				CallType: 'GET_EKYC_FUNC_PARAM'
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
   
   return responseMsg;

}

//To get request id from servlet call 
function getKYCDetails(Request_Id, Aadhaar_Id)
{
	var responseMsg="";
	var data1=true;

	$.ajax({
		url: '../../servlet/eXH.AadhaarResponse',
		type: 'POST',
		cache: false,
		data: {
				callType:	'KYC',
				request_id:	Request_Id,
				aadhaar_id:	Aadhaar_Id
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});   
   
   if(responseMsg =="S"){
        eKYCmp11(Aadhaar_Id,Request_Id);
	}
	else
	{
		document.getElementById("aadhaarStatus").value = "N";
		document.getElementById("aadhaarTransId").value = "";
		document.getElementById("aadhaarID").value = "";
		alert("Error occurred while validating EKYC");
	}

}


async function Aadhaar_Request_1(Request_Id, Aadhaar_Id)
{	

	//var url = "http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=KH&EM_USER_ID=SURESHM&AADHAAR_NO=523261344811&REQUEST_ID=12345678";
	var url = "../../eXH/jsp/EMeKYCRequest.jsp?AADHAAR_NO="+Aadhaar_Id+"&REQUEST_ID="+Request_Id;

	var errMessage = "";

	var dialogTop   = "10";			     
	var dialogHeight= "9" ;
	var dialogWidth = "27" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;

	var response =await window.showModalDialog(url, arguments, features);
    if(response =="true"){
       await eKYCmp11(Aadhaar_Id,Request_Id);
	}
	else
	{
		document.getElementById("aadhaarStatus").value = "N";
		document.getElementById("aadhaarTransId").value = "";
		document.getElementById("aadhaarID").value = "";
		alert("Error occurred while validating EKYC");
	}

}

//prithivi
function eKYCmp11(Aadhaar_Id,Request_Id)
{
	var nationalID=Aadhaar_Id;
	var responseJson;
    
	var response = eKYCsample(Aadhaar_Id,Request_Id);
	kAddhaarRequestID = "";


    var responseMsg = response.split("$!^");

	if(responseMsg[0]=="S")
	{
		if(responseMsg[4] == "success" || responseMsg[4] == "SUCCESS")
		{
			parseKYCvalues(responseMsg[2]);
			kAddhaarRequestID = responseMsg[3];

			var kycConfig = getKYCconfigValue();

			var CalledFromFunction = document.getElementById("CalledFromFunction").value;

			if(CalledFromFunction == "ChangePatDtls")
			{
				// This loop is for change patient details		
				
				if(kycConfig == "0")
				{
					eKYCValidationWithEM();
				}
				else if(kycConfig == "1")
				{
					placeAadhaarStatus();
					placeKYCvalues();
					clearValues();
				}
				else if(kycConfig == "2")
				{
					placeAadhaarStatus();
				}		
				
			}
			else
			{
				// This is for patient registration

				if(kycConfig == "0")
				{
					eKYCValidationWithEM();
				}
				else if(kycConfig == "1")
				{
					placeAadhaarStatus();
					placeKYCvalues();
					clearValues();
				}	
				else if(kycConfig == "2")
				{
					placeAadhaarStatus();
				}
			}
		}
		else
		{
			alert("Error occurred in Aadhaar Validation : "+responseMsg[5]);
		}
	}
}
function eKYCsample(Aadhaar_Id,Request_Id){
   var responseMsg="";
   var data1 = true;
	$.ajax({
		url: '../../servlet/eXH.AadhaarRequest',
		type: 'POST',
		cache: false,
		data: {
				CallType: 'FETCHRESPONSE',
				request_id:	Request_Id,
				aadhaar_id:	Aadhaar_Id
		}, 
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});
	return responseMsg;
}

function parseKYCvalues(responseMsg)
{
	try
	{
		var json_obj = JSON.parse(responseMsg); //parse JSON

		kPatientFullName = json_obj.kycDetails.name;

		kPatientFullName = trimString(kPatientFullName); // trimString added to check for space.
		kStatus = json_obj.errorCode;	
		
	    var names = json_obj.kycDetails.name;

		names = trimString(names);
		var namesArr = names.split(" ");
		var namesArrLength = namesArr.length;

		if(namesArr!=null && namesArrLength > 0)
		{
			if(namesArrLength >= 3)
			{
				kFirstName = namesArr[0];
				kSecondName = namesArr[1];
				kFamilyName = namesArr[2];
			}
			else if(namesArrLength == 2)
			{
				kFirstName = namesArr[0];
				kSecondName = "";
				kFamilyName = namesArr[1];
			}
			else
			{
				kFirstName = namesArr[0];
				kSecondName = "";
				kFamilyName = "";
			}
		} 

		kSex = json_obj.kycDetails.gender;
		kDob = json_obj.kycDetails.dob;

		kUID = json_obj.kycDetails.uid;

		if(kDob!=null)
		{
			kDob = kDob.replace("-","/");
			kDob = kDob.replace("-","/");
			kDob = kDob.replace("-","/");
		}
		else
		{
			kDob = "";
		}

		kHouse = json_obj.kycDetails.house;
		if(kHouse == null || kHouse == "undefined")
		{
			kHouse = "";
		}
		
		kStreet = json_obj.kycDetails.street;
		if(kStreet == null || kStreet == "undefined")
		{
			kStreet = "";
		}
		
		kLandmark = json_obj.kycDetails.landMark;
		if(kLandmark == null || kLandmark == "undefined")
		{
			kLandmark = "";
		}
		
		kLocation_addr = json_obj.kycDetails.location;
		if(kLocation_addr == null || kLocation_addr == "undefined")
		{
			kLocation_addr = "";
		}
		
		kSubdist = json_obj.kycDetails.subdist;
		if(kSubdist == null || kSubdist == "undefined")
		{
			kSubdist = "";
		}
		
		kDistrict = json_obj.kycDetails.district;
		if(kDistrict == null || kDistrict == "undefined")
		{
			kDistrict = "";
		}
		
		kPostalCode = json_obj.kycDetails.postalCode;
		if(kPostalCode == null || kPostalCode == "undefined")
		{
			kPostalCode = "";
		}

		kPostOffice = json_obj.kycDetails.postOffice;
		if(kPostOffice == null || kPostOffice == "undefined")
		{
			kPostOffice = "";
		}
		
		kState = json_obj.kycDetails.state;
		if(kState == null || kState == "undefined")
		{
			kState = "";
		}
		
		kPhoneNumber = json_obj.kycDetails.phone;
		if(kPhoneNumber == null || kPhoneNumber == "undefined")
		{
			kPhoneNumber = "";
		}
		
		kEmail = json_obj.kycDetails.emailAddress;
		if(kEmail == null || kEmail == "undefined")
		{
			kEmail = "";
		}
		kAadharPatPhotoStr = json_obj.kycDetails.photo;
		if(kAadharPatPhotoStr == null || kAadharPatPhotoStr == "undefined")
		{
			kAadharPatPhotoStr = "";
		}

		kVtc = json_obj.kycDetails.vtc;
		if(kVtc == null || kVtc == "undefined")
		{
			kVtc = "";
		}
	}	
	catch(e1)
	{

	}
	return;
}

async function eKYCValidationWithEM()
{
	var retVal="";
	var emValuesFlag = "N";

	var aFirstName = "";
	if(document.getElementById("first_name"))
		aFirstName=document.getElementById("first_name").value;

    var aSecondName = "";
    if(document.getElementById("second_name"))
		aSecondName=document.getElementById("second_name").value;

    var aThirdName = "";
    if(document.getElementById("third_name"))
		aThirdName=document.getElementById("third_name").value;

	var aFamilyName = "";
    if(document.getElementById("family_name"))
		aFamilyName=document.getElementById("family_name").value;

	var aadharId=document.getElementById("national_id_no1").value;

	var aDOB = "";
	if(document.getElementById("date_of_birth"))
		aDOB=document.getElementById("date_of_birth").value;

	var aGender = "";
	if(document.getElementById("sex"))
		aGender=document.getElementById("sex").value;

	var aEmail = "";
	if(document.getElementById("email"))
		aEmail=document.getElementById("email").value;

	var aMobile = "";
	if(document.getElementById("contact2_no"))
		aMobile=document.getElementById("contact2_no").value;

	var addr1 = "";
	if(document.getElementById("r_addr_line1"))
		addr1=document.getElementById("r_addr_line1").value;

	var addr2 = "";
	if(document.getElementById("r_addr_line2"))
		addr2=document.getElementById("r_addr_line2").value;

	var addr3 = "";
	if(document.getElementById("r_addr_line3"))
		addr3=document.getElementById("r_addr_line3").value;

	var addr4 = "";
	if(document.getElementById("r_addr_line4"))
		addr4=document.getElementById("r_addr_line4").value;

	var aDistrict = "";
	if(document.getElementById("r_area_code"))
		aDistrict=document.getElementById("r_area_code").value;

	var aState = "";
	if(document.getElementById("r_region_code"))
		aState=document.getElementById("r_region_code").value;

	var aPostalCode = "";
	if(document.getElementById("r_postal_code1"))
		aPostalCode=document.getElementById("r_postal_code1").value;

	if (aFirstName.length > 0 || aSecondName.length > 0 || aThirdName.length > 0 || aFamilyName.length > 0 || aDOB.length > 0 || aGender.length > 0 || addr1.length > 0 ||addr2.length > 0 || addr3.length > 0 || addr4.length > 0  || aDistrict.length > 0 || aState.length > 0 || aPostalCode.length > 0)
	{
		if (aFirstName != kFirstName)
		{
			emValuesFlag = "Y";
		}	

		if (aSecondName != kSecondName)
		{
			emValuesFlag = "Y";
		}	
		
		if (aThirdName != kThirdName)
		{
			emValuesFlag = "Y";
		}
		if (aFamilyName != kFamilyName)
		{
			emValuesFlag = "Y";
		}

		if (aDOB != kDob)
		{
			emValuesFlag = "Y";
		}	
		if (aGender != kSex)
		{
			emValuesFlag = "Y";
		}

		if (addr1 != kHouse)
		{
			emValuesFlag = "Y";
		}	
		if (addr2 != kStreet)
		{
			emValuesFlag = "Y";
		}
		
		if (addr3 != kLandmark)
		{
			emValuesFlag = "Y";
		}
		if (addr4 != kPostOffice)
		{
			emValuesFlag = "Y";
		}
		if (aDistrict != kDistrict)
		{
			emValuesFlag = "Y";
		}
		if (aState != kState)
		{
			emValuesFlag = "Y";
		}
		if (aPostalCode != kPostalCode)
		{
			emValuesFlag = "Y";
		}
	}
	
	var params = "aFirstName="+aFirstName+"&aSecondName="+aSecondName+"&aThirdName="+aThirdName+"&aFamilyName="+aFamilyName+"&aDOB="+aDOB+"&aGen="+aGender+"&aMail="+aEmail+"&aMob="+aMobile+"&adr1="+addr1+"&adr2="+addr2+"&adr3="+addr3+"&adr4="+addr4+"&aDist="+aDistrict+"&aState="+aState+"&aPC="+aPostalCode+"&kFirstName="+kFirstName+"&kSecondName="+kSecondName+"&kThirdName="+kThirdName+"&kFamilyName="+kFamilyName+"&kName="+kPatientFullName+"&kGen="+kSex+"&kDob="+kDob+"&kAdr1="+kHouse+"&kAdr2="+kStreet+"&kAdr3="+kLandmark+"&kAdr5="+kSubdist+"&kAdr4="+kPostOffice+"&kDist="+kDistrict+"&kPC="+kPostalCode+"&kState="+kState+"&kMob="+kPhoneNumber+"&kEmail="+kEmail+"&aadharId="+aadharId;

	if (emValuesFlag == "Y")
	{	
		var dialogHeight = "60";			    
		var dialogWidth  = "50";
		var dialogTop    = "50";
		var dialogLeft   = "60";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;center:yes;" ;

		var url = "../../eXH/jsp/EkycComparisonPopup.jsp?"+params;
		
		retVal =await window.showModalDialog(url,"eKYC",features);

		if(retVal!=null && retVal!= undefined)
		{
			var arr=new Array();
			arr=retVal.split("^~^");

			if(arr.length == 15)
			{
				await placeAadhaarStatus();
				await placeKYCValidatedvalues(arr);
			}
			else
			{
				if (arr[0] == "Save")
				{
					await placeAadhaarStatus();
				}
				clearValues();				
			}
		}
	}
	else
	{
		placeAadhaarStatus();
		placeKYCvalues();
		clearValues();
	}
}

function placeKYCvalues()
{
	if(document.getElementById("first_name"))document.getElementById("first_name").value = kFirstName;
	if(document.getElementById("second_name"))document.getElementById("second_name").value = kSecondName;
	if(document.getElementById("third_name"))document.getElementById("second_name").value = kThirdName;
	if(document.getElementById("family_name"))document.getElementById("family_name").value = kFamilyName;

	document.getElementById("sex").value = kSex;
			
	if(document.getElementById("date_of_birth"))document.getElementById("date_of_birth").value = kDob;

	if(kDob!=null && kDob!="")
	{
		if(document.getElementById("date_of_birth"))
		{
			gotoNext(document.forms[0].date_of_birth);
			disableEnableYMDH(document.forms[0].date_of_birth);
			calc_hij(document.forms[0].date_of_birth);
		}
	}

	if(document.getElementById("r_addr_line1"))document.getElementById("r_addr_line1").value = kHouse;

	if(document.getElementById("r_addr_line2"))document.getElementById("r_addr_line2").value = kStreet;

	if(document.getElementById("r_addr_line3"))document.getElementById("r_addr_line3").value = kLandmark;
	
	//if(document.getElementById("r_addr_line4"))document.getElementById("r_addr_line4").value = kSubdist;

	//if(document.getElementById("r_addr_line4"))document.getElementById("r_addr_line4").value = kDistrict;
	if(document.getElementById("r_addr_line4"))document.getElementById("r_addr_line4").value = kPostOffice;
		
	var postalCodeVal = "";

	if(document.getElementById("r_postal_code1"))
	{
		if(document.getElementById("r_postal_code1").value != kPostalCode)
		{
			if(kPostalCode != null || kPostalCode != "")
			{
				searchCommonCodeInt('postal_code', kPostalCode, 'Postal Code', 'parent.parent.messageFrame', 'en');
			}
		}
	}

	//if(document.getElementById("r_region_code"))document.getElementById("r_region_code").value = kState;

	if(document.getElementById("contact2_no"))document.getElementById("contact2_no").value = kPhoneNumber;

	if(document.getElementById("alt_id2_no"))document.getElementById("alt_id2_no").value = kPhoneNumber;

	if(document.getElementById("aadharPatPhotoStr"))
	{
		document.getElementById("aadharPatPhotoStr").value = kAadharPatPhotoStr;
	}
	
	if(document.getElementById("email"))document.getElementById("email").value = kEmail;
}


//var retVal="#firstname^~^#dob^~^#gender^~^#mobile^~^#mail^~^#addr1^~^#addr2^~^#addr3^~^#addr4^~^#district^~^#state^~^#postalcode^~^#secondname^~^#thirdname";
function placeKYCValidatedvalues(arr)
{
	
	if(document.getElementById("first_name"))document.getElementById("first_name").value = arr[0];
	if(document.getElementById("second_name"))document.getElementById("second_name").value = arr[12];
	if(document.getElementById("third_name"))document.getElementById("third_name").value = arr[13];
	if(document.getElementById("family_name"))document.getElementById("family_name").value = arr[14];

	document.getElementById("sex").value = arr[2];
			
	if(document.getElementById("date_of_birth"))document.getElementById("date_of_birth").value = arr[1];
	if(arr[1]!=null && arr[1]!="")
	{
		if(document.getElementById("date_of_birth"))
		{
			gotoNext(document.forms[0].date_of_birth);
			disableEnableYMDH(document.forms[0].date_of_birth);
			calc_hij(document.forms[0].date_of_birth);
		}
	}

	if(document.getElementById("r_addr_line1"))document.getElementById("r_addr_line1").value = arr[5];

	if(document.getElementById("r_addr_line2"))document.getElementById("r_addr_line2").value = arr[6];

	if(document.getElementById("r_addr_line3"))document.getElementById("r_addr_line3").value = arr[7];
	
	if(document.getElementById("r_addr_line4"))document.getElementById("r_addr_line4").value = arr[8]; //district

	var postalCodeVal = "";

	if(document.getElementById("r_postal_code1"))
	{
		if(document.getElementById("r_postal_code1").value != arr[11])
		{
			if(arr[11] != null || arr[11] != "")
			{
				searchCommonCodeInt('postal_code', arr[11], 'Postal Code', 'parent.parent.messageFrame', 'en');
			}
		}
	}

	if(document.getElementById("contact2_no"))document.getElementById("contact2_no").value = arr[3]; //mobile number

	if(document.getElementById("alt_id2_no") && document.getElementById("alt_id2_no").disabled == false)
	{
		document.getElementById("alt_id2_no").value = arr[3]; //mobile number
	}

	//if(document.getElementById("aadharPatPhotoStr"))document.getElementById("aadharPatPhotoStr").value = kAadharPatPhotoStr; // no need for change patient details
    
	if(document.getElementById("email"))document.getElementById("email").value = arr[4];

}

function getKYCconfigValue()
{
	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEMKYCapplication',
		type: 'GET',
		cache: false,
		data: {
				callType:'GetKYCconfigValue'
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	return responseMsg;
}

function clearValues()
{
	 kPatientFullName = "";
	 kSex = "";
	 kDob = "";
	 kUID = "";
	 kHouse = "";
	 kStreet = "";
	 kLandmark = "";
	 kLocation_addr = "";
	 kSubdist = "";
	 kDistrict = "";
	 kPostalCode = "";
	 kState = "";
	 kPhoneNumber = "";
	 kEmail = "";
	 kAadharPatPhotoStr = "";
}


function replaceValues()
{
	var retVal="#firstname^~^#dob^~^#gender^~^#mobile^~^#mail^~^#addr1^~^#addr2^~^#addr3^~^#addr4^~^#district^~^#state^~^#postalcode^~^#secondname^~^#thirdname^~^#familyname";
	var checkedVal = false;

    if(document.getElementById("firstNameCheck"))
	{
        if(document.getElementById("firstNameCheck").checked == true)
		{
             retVal = retVal.replace("#firstname",document.forms[0].kFirstName.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#firstname",document.forms[0].aFirstName.value);
		}
	}
	else
	{
		retVal = retVal.replace("#firstname",document.forms[0].aFirstName.value);
	}

	if(document.getElementById("secondNameCheck"))
	{
        if(document.getElementById("secondNameCheck").checked == true)
		{
             retVal = retVal.replace("#secondname",document.forms[0].kSecondName.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#secondname",document.forms[0].aSecondName.value);
		}
	}
	else
	{
		retVal = retVal.replace("#secondname",document.forms[0].aSecondName.value);
	}

	if(document.getElementById("thirdNameCheck"))
	{
        if(document.getElementById("thirdNameCheck").checked == true)
		{
             retVal = retVal.replace("#thirdname",document.forms[0].kThirdName.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#thirdname",document.forms[0].aThirdName.value);
		}
	}
	else
	{
		retVal = retVal.replace("#thirdname",document.forms[0].aThirdName.value);
	}

	if(document.getElementById("familyNameCheck"))
	{
        if(document.getElementById("familyNameCheck").checked == true)
		{
             retVal = retVal.replace("#familyname",document.forms[0].kFamilyName.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#familyname",document.forms[0].aFamilyName.value);
		}
	}
	else
	{
		retVal = retVal.replace("#familyname",document.forms[0].aFamilyName.value);
	}

	if(document.getElementById("dobCheck"))
	{
        if(document.getElementById("dobCheck").checked == true)
		{
             retVal = retVal.replace("#dob",document.forms[0].kDOB.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#dob",document.forms[0].aDOB.value);
		}
	}
	else
	{
		retVal = retVal.replace("#dob",document.forms[0].aDOB.value);
	}

	if(document.getElementById("genderCheck"))
	{
        if(document.getElementById("genderCheck").checked == true)
		{
             retVal = retVal.replace("#gender",document.forms[0].kGender.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#gender",document.forms[0].aGender.value);
		}
	}
	else
	{
		retVal = retVal.replace("#gender",document.forms[0].aGender.value);
	}

	if(document.getElementById("mailCheck"))
	{
        if(document.getElementById("mailCheck").checked == true)
		{
             retVal = retVal.replace("#mail",document.forms[0].kMail.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#mail",document.forms[0].aMail.value);
		}
	}
	else
	{
		retVal = retVal.replace("#mail",document.forms[0].aMail.value);
	}

	if(document.getElementById("mobileNumCheck"))
	{
        if(document.getElementById("mobileNumCheck").checked == true)
		{
             retVal = retVal.replace("#mobile",document.forms[0].kMobile.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#mobile",document.forms[0].aMobile.value);
		}
	}
	else
	{
		retVal = retVal.replace("#mobile",document.forms[0].aMobile.value);
	}

	if(document.getElementById("addr1Check"))
	{
        if(document.getElementById("addr1Check").checked == true)
		{
             retVal = retVal.replace("#addr1",document.forms[0].kAddress1.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#addr1",document.forms[0].address1.value);
		}
	}
	else
	{
		retVal = retVal.replace("#addr1",document.forms[0].address1.value);
	}

	if(document.getElementById("addr2Check"))
	{
        if(document.getElementById("addr2Check").checked == true)
		{
             retVal = retVal.replace("#addr2",document.forms[0].kAddress2.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#addr2",document.forms[0].address2.value);
		}
	}
	else
	{
		retVal = retVal.replace("#addr2",document.forms[0].address2.value);
	}

	if(document.getElementById("addr3Check"))
	{
        if(document.getElementById("addr3Check").checked == true)
		{
             retVal = retVal.replace("#addr3",document.forms[0].kAddress3.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#addr3",document.forms[0].address3.value);
		}
	}
	else
	{
		retVal = retVal.replace("#addr3",document.forms[0].address3.value);
	}

	if(document.getElementById("addr4Check"))
	{
        if(document.getElementById("addr4Check").checked == true)
		{
             retVal = retVal.replace("#addr4",document.forms[0].kAddress4.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#addr4",document.forms[0].address4.value);
		}
	}
	else
	{
		retVal = retVal.replace("#addr4",document.forms[0].address4.value);
	}

	if(document.getElementById("districtCheck"))
	{
        if(document.getElementById("districtCheck").checked == true)
		{
            retVal = retVal.replace("#district",document.forms[0].kDistrict.value);
			checkedVal = true;
		}
		else
		{
            retVal = retVal.replace("#district",document.forms[0].aDistrict.value);
		}
	}
	else
	{
		retVal = retVal.replace("#district",document.forms[0].aDistrict.value);
	}

	if(document.getElementById("stateCheck"))
	{
        if(document.getElementById("stateCheck").checked == true)
		{
             retVal = retVal.replace("#state",document.forms[0].kState.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#state",document.forms[0].aState.value);
		}
	}
	else
	{
		retVal = retVal.replace("#state",document.forms[0].aState.value);
	}

	if(document.getElementById("postalCodeCheck"))
	{
        if(document.getElementById("postalCodeCheck").checked == true)
		{
             retVal = retVal.replace("#postalcode",document.forms[0].kPostalCode.value);
			 checkedVal = true;
		}
		else
		{
             retVal = retVal.replace("#postalcode",document.forms[0].aPostalCode.value);
		}
	}
	else
	{
		retVal = retVal.replace("#postalcode",document.forms[0].aPostalCode.value);
	}

    if(checkedVal == false)
	{
       alert("Select atleast one value to be replaced");
	   return;
	}
	else
	{
		window.returnValue = retVal;
		window.close();
	}
	 
}

//String res_town = "<input align='left' type='text' name='r_town_code' id='r_town_code'  size='60'  maxlength='60' onBlur=\"if(this.value != ''){ searchCommonCode(town_code[0],r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')}else{clearCommonCode(r_town_code)}\" tabindex='@'><input type='button' name='town_code' id='town_code' value='?' class='button' onclick=\"searchCommonCode(this,r_town_code,'"+res_town_prompt+"','"+messageFrame+"','"+locale+"')\"  tabindex='@'>";	
//prithivi
function searchCommonCodeInt(objName,target,title,messageFrame,locale){ 
	var retVal	= new String();                
	var tit		= title;

	retVal	= AddressLookup( tit, objName ,target);
	var arr	= new Array();
    if(retVal != null && retVal != ""){  
		var ret1 = unescape(retVal);
		arr = ret1.split("::");
		if(objName == 'postal_code'){
			document.forms[0].r_postal_code1.value= arr[1];	
			document.forms[0].r_postal_code.value= arr[0];	
			sendToValidation(7, document.forms[0].r_postal_code,messageFrame);
		}else if(objName == 'area_code'){			
			document.forms[0].r_area_code.value= arr[1];	
			document.forms[0].r_area.value= arr[0];	
			sendToValidation(7, document.forms[0].r_area_code,messageFrame);
		}else if(objName == 'region_code'){
			document.forms[0].r_region_code.value= arr[1];	
			var prev_region = document.forms[0].r_region.value;
			document.forms[0].r_region.value= arr[0];
			sendToValidation('7', document.forms[0].r_region_code,messageFrame,prev_region);
		}
	}else{  
		if(objName == 'postal_code'){
			document.forms[0].r_postal_code1.value= "";	
			document.forms[0].r_postal_code.value='';
		}else if(objName == 'region_code'){
			document.forms[0].r_region_code.value= "";	
			document.forms[0].r_region.value = '';
		}else if(objName == 'area_code'){
			document.forms[0].r_area_code.value= "";	
			document.forms[0].r_area.value= '';
		}
	}
} 

function sendToValidation(Val,areaobj,messageFrame)  
{
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	if ( Val == 7 )
	{
        if(areaobj.value !='')
        {           
			if(messageFrame=="parent.parent.messageFrame")
			{
			xmlStr+=" process_id=\"7\"";
			}
			else
			{
			xmlStr+=" process_id=\"20\"";
			}

			var mode =areaobj.name
			
			if (mode=="r_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("r_region").value+"\"";				
			}
				
			if( mode=="m_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("m_region").value+"\"";
			}
				
			if( mode=="contact1_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("n_region").value+"\"";
			}
				
			if( mode=="contact2_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("f_region").value+"\"";
			}
				
			if( mode=="contact3_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("e_region").value+"\"";
			}
				
			if (mode=="r_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("r_area").value+"\"";
				
			if( mode=="m_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("m_area").value+"\"";
				
			if( mode=="contact1_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("n_area").value+"\"";
				
			if( mode=="contact2_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("f_area").value+"\"";
				
			if( mode=="contact3_res_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("e_area").value+"\"";
				
			if (mode=="r_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("r_town").value+"\"";
				
			if( mode=="m_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("m_town").value+"\"";
				
			if( mode=="contact1_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("n_town").value+"\"";
				
			if( mode=="contact2_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("f_town").value+"\"";
				
			if( mode=="contact3_res_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("e_town").value+"\"";	


		    //Below line added for ML-MMOH-CRF-0601
            if (mode=="a_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("a_town").value+"\"";	
    
            if( mode=="a_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("a_area").value+"\"";
				
			if (mode=="a_region_code") 
				xmlStr+=" region_code=\""+document.getElementById("a_region").value+"\"";	
			 //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
			if( mode=="n_contact_ma_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("nkma_town").value+"\"";

            if( mode=="n_contac_region_code") {
				xmlStr+=" region_code=\""+document.getElementById("contact1_region").value+"\"";
			}

			if( mode=="n_contact_ma_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("nkma_area").value+"\"";

			if( mode=="fst_to_no_ma_town_code")
				xmlStr+=" res_town_code=\""+document.getElementById("contact2_res_town").value+"\"";

            if( mode=="fst_to_no_ma_reg_cod") {
				xmlStr+=" region_code=\""+document.getElementById("contact2_region").value+"\"";
			}

			if( mode=="fst_to_no_ma_area_code")
				xmlStr+=" res_area_code=\""+document.getElementById("contact2_res_area").value+"\"";
			
		   //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
				
				
			if (mode=="alt_postal_code" || mode=="r_postal_code" || mode=="m_postal_code" || mode=="next_postal_code" || mode=="n_ma_postal_code" || mode=="fst_no_ma_pos_cod" || mode=="first_postal_code" || mode=="employ_postal_code") //Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008
				xmlStr+=" postal_code=\""+areaobj.value+"\"";
				
			 //End this ML-MMOH-CRF-0601	
			           
			xmlStr+=" mode=\""+mode+"\"";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);
        }        
	} 
}

function clearCommonCode(target){

	if(target.name == 'r_postal_code1')
	{
		document.forms[0].r_postal_code.value='';
	}
	else if(target.name == 'm_postal_code1')
	{
		document.forms[0].m_postal_code.value='';
	}
	else if(target.name == 'next_postal_code1')
	{
		document.forms[0].next_postal_code.value='';
	}
	 //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name == 'n_ma_postal_code1')
	{
	document.forms[0].n_ma_postal_code.value='';
	}
				 
	else if(target.name == 'fst_no_ma_pos_cod1')
	{
	document.forms[0].fst_no_ma_pos_cod.value='';
	}
    //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name == 'first_postal_code1')
	{
		document.forms[0].first_postal_code.value='';
	}
	else if(target.name == 'employ_postal_code1')
	{
		document.forms[0].employ_postal_code.value='';
	}
	else if(target.name == 'r_area_code')
	{
		document.forms[0].r_area.value= '';
	}
	else if(target.name == 'm_area_code')
	{
		document.forms[0].m_area.value = '';
	}
	else if(target.name == 'contact1_res_area_code')
	{
		document.forms[0].n_area.value = '';
	}
	//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
    else if(target.name == 'n_contact_ma_area_code')
	{
	document.forms[0].nkma_area.value = '';
	}
    //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name == 'contact2_res_area_code')
	{
		document.forms[0].f_area.value = '';
	}
	else if(target.name == 'contact3_res_area_code')
	{
		document.forms[0].e_area.value = '';
	}
	else if(target.name == 'r_region_code')
	{
		document.forms[0].r_region.value = '';
	}
	else if(target.name == 'm_region_code')
	{
		document.forms[0].m_region.value = '';
	}
	else if(target.name == 'contact1_region_code')
	{
		document.forms[0].n_region.value = '';
	}
    //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
    else if(target.name == 'n_contac_region_code')
	{
	document.forms[0].contact1_region.value = '';
	}
    //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name=='contact2_region_code')
	{
		document.forms[0].f_region.value = '';
	}
	else if(target.name == 'contact3_region_code')
	{
		document.forms[0].e_region.value = '';
	}
	else if(target.name == 'r_town_code')
	{
		document.forms[0].r_town.value = '';
	}
	else if(target.name == 'm_town_code')
	{
		document.forms[0].m_town.value = '';
	}
	else if(target.name == 'contact1_res_town_code')
	{
		document.forms[0].n_town.value= '';
	}
	//Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name == 'n_contact_ma_town_code')
	{
	document.forms[0].nkma_town.value = '';
	}
    //Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
	else if(target.name == 'contact2_res_town_code')
	{
		document.forms[0].f_town.value = '';
	}
	else if(target.name == 'contact3_res_town_code')
	{
		document.forms[0].e_town.value = '';
	}
}


function getMPaddressInfo(searchType,fieldValue)
{
	var tableId="";
	var appId = "AADHAAR";
	if(searchType == "areacode")
	{
       tableId = "MP_RES_AREA";
	}
	else if(searchType == "postalcode")
	{
		tableId = "MP_POSTAL_CODE";
	}
	else if(searchType == "regioncode")
	{
		tableId = "MP_REGION";
	}
	else if(searchType == "towncode")	
	{
		tableId = "MP_RES_TOWN";
	}

	var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeEGLapplication',
		type: 'GET',
		cache: false,
		data: {
				callType: 'GetTranslationData',
				tableId: tableId,
				appId: appId,
				fieldValue: fieldValue
		},
		success: function (data1) {
			responseMsg = data1;
		},
		dataType: 'text',
		async: false
	});  
	return responseMsg;
}

function placeAadhaarStatus()
{
	if (kStatus == "00")
	{
		alert(" Aadhaar Card has been successfully validated for "+kFirstName+" "+kFamilyName);
		document.getElementById("aadhaarStatus").value = "Y";
		document.getElementById("aadhaarTransId").value = kAddhaarRequestID;
		document.getElementById("aadhaarID").value = kUID;
		
	}
	else
	{
		document.getElementById("aadhaarStatus").value = "N";
		document.getElementById("aadhaarTransId").value = "";
		document.getElementById("aadhaarID").value = "";
	}
}

function saveValidation()
{
	var retVal="Save^~^";
	window.returnValue = retVal;
	window.close();
	
}

function cancelValidation()
{
	var retVal="Cancel^~^";
	window.returnValue = retVal;
	window.close();
	
}





