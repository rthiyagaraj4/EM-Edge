function readCarderData()
	{
	$.ajax({  
	url:'http://localhost:80/PapService/publicData',  
	type:'post',  
	headers :{'Content-Type' :'application/json'},
	body :null,
	success: function(data) {
	window.opener.getMyKadValue(data);
	window.close();
	} ,
	error: function(jqXHR, textStatus, errorThrown) {	 
	alert('Card Reading Failed');	
	/*var	  data1 =	{
    "AuthenticationStatus": true,
    "Description": "Successfully read public data",
    "LogData": "Successfully read public data",
    "PublicData": {
        "ArabicFullName": "منتصر عبدالقادر عبدالرحيم   عثمان ",
        "CardHolderDataSf5Signature": null,
        "CardNumber": "117812420",
        "CardSerialNumber": "05 83 2C D8 29 42 00 02",
        "CompanyName": "Ain Al Khaleej Hospital",
        "CompanyNameArabic": "Ain Al Khaleej Hospital",
        "DateOfBirth": "09\/09\/1991",
        "DateOfGraduation": "",
        "DegreeDescription": "",
        "DegreeDescriptionArabic": "",
        "ExpiryDate": "22\/09\/2023",
        "FamilyId": "",
        "FieldOfStudy": "Unspecified",
        "FieldOfStudyArabic": "غير محدد",
        "FieldOfStudyCode": "00",
        "FingerData": [
            {
                "FingerIndex": 6,
                "FingerText": "LeftThumb"
            },
            {
                "FingerIndex": 9,
                "FingerText": "RightIndex"
            }
        ],
        "FullName": "MONTASIR ABDALGADIR ABDALRAHIM   OSMAN ",
        "HomeAddressAreaArabic": "بوحريبة",
        "HomeAddressAreaCode": "0547",
        "HomeAddressAreaEnglish": "Abu Hraiba",
        "HomeAddressBuildingName": "",
        "HomeAddressBuildingNameArabic": "",
        "HomeAddressCityArabic": "العين",
        "HomeAddressCityCode": "07",
        "HomeAddressCityDescription": "Al Ain",
        "HomeAddressEmail": "ham@gmail.com",
        "HomeAddressEmirateArabic": "ابو ظبي",
        "HomeAddressEmirateDescription": "Abu Dhabi",
        "HomeAddressFlatNumber": "",
        "HomeAddressLandPhoneNumber": "31111111",
        "HomeAddressLocationCode": "",
        "HomeAddressMobilePhoneNumber": "971504106824",
        "HomeAddressPoBox": "222666",
        "HomeAddressStreet": "",
        "HomeAddressStreetArabic": "",
        "HomeAddressStreetEnglish": "",
        "HomeAddressTypeCode": "01",
        "HusbandIdNumber": "",
        "IDType": "IL",
        "IdNumber": "784199169067156",
        "IssueDate": "23\/09\/2021",
        "MaritalStatus": "01",
        "MotherFirstName": "MRS",
        "MotherFullNameArabic": "السيدة",
        "Nationality": "Sudan",
        "NationalityAR": "السودان",
        "NationalityCode": "SDN",
        "Occupation": "System Administrator",
        "OccupationArabic": "مدير نظم",
        "OccupationCode": "1",
        "OccupationFieldCode": "00",
        "OccupationType": "Unspecified",
        "OccupationTypeArabic": "غير محدد",
        "PassportCountryCode": "SDN",
        "PassportCountryCodeArabic": "السودان",
        "PassportCountryDescription": "Sudan",
        "PassportExpiryDate": "27\/12\/2022",
        "PassportIssueDate": "28\/12\/2017",
        "PassportNumber": "P04369785",
        "PassportTypeCode": "01",
       "PlaceOfBirth": "KSA",
        "PlaceOfBirthAR": "السعوديه",
        "PlaceOfStudyArabic": "السودان",
        "PlaceOfStudyEnglish": "Sudan",
        "QualificationLeveArabic": "",
        "QualificationLevelCode": "08",
        "QualificationLevelDescription": "",
        "ResidencyExpiryDate": "22\/09\/2023",
        "ResidencyNumber": "1522021237419",
        "ResidencyType": "02",
        "Sex": "M",
        "SponsorName": "مستشفى عين الخليج",
        "SponsorTypeCode": "06",
        "SponsorUnifiedNumber": "140642",
        "Title": "No Title",
        "TitleArabic": "ليس لديه لقب",
        "WorkAddressAddressTypeCode": "03",
        "WorkAddressAreaArabic": "",
        "WorkAddressAreaCode": "",
        "WorkAddressAreaEnglish": "",
        "WorkAddressBuildingNameArabic": "",
        "WorkAddressBuildingNameEnglish": "",
        "WorkAddressCityArabic": "",
        "WorkAddressCityCode": "",
        "WorkAddressCityEnglish": "",
        "WorkAddressCompanyNameArabic": null,
        "WorkAddressCompanyNameEnglish": null,
        "WorkAddressEmail": "",
        "WorkAddressEmirateArabic": "",
        "WorkAddressEmirateEnglish": "",
        "WorkAddressEmiratesCode": null,
        "WorkAddressLandPhoneNumber": "",
        "WorkAddressLocationCode": "",
        "WorkAddressMobilePhoneNumber": "",
        "WorkAddressPoBox": "",
        "WorkAddressStreetArabic": "",
        "WorkAddressStreetEnglish": ""
    }
}
*/
	//window.opener.getMyKadValue(data1);
	//window.opener.getMyKadValue(data);
	window.close();
    }
      });  
	}
	var ValidationStatus="false";
function ScanWithBiometric()
	{
	
/*	var jsonObject="";
	 jsonObject = { 
	"Status": "true",
    "ValidationStatus": "true",
	"Description": "OK"
};*/
	var fingerIndex=document.getElementById("fingerIndex").value;
	if(fingerIndex!="0") 
		{
		$.ajax({  
		url:'http://localhost:80/PapService/processFingerprint',  
		type:'post',  
		headers :{'Content-Type' :'application/json'},
		body : fingerIndex,
		success: function(data) 
			{
			validationStatus=data.validationStatus;
			document.getElementById("successMsg").style.display = "block"; 
			document.getElementById("successMsg").style.visibility="visible";	
			document.getElementById("reasonnId").style.visibility="hidden";		
			document.getElementById("fingerScanId").style.visibility="hidden";	
			document.getElementById("reasonnId").style.display = "none";
			document.getElementById("fingerScanId").style.display = "none";
			window.opener.getMyKadValue1('true');
			window.close();		
			} ,
		error: function(jqXHR, textStatus, errorThrown) 
			{
		//	alert('Finger Print Authentication Failed');
			validationStatus='false';
			document.getElementById("failureMsg").style.display = "block"; 
			document.getElementById("fingerScanId").style.display = "none";
			document.getElementById("reasonnId").style.visibility="visible";
			document.getElementById("reasonnId").style.display = "block"; 
			document.getElementById("fingerScanId").style.visibility="hidden";
			document.getElementById("failureMsg").style.visibility="visible";		
			window.opener.getMyKadValue1('false');
			//window.close();	
			}
		}); 
	  	}	
	}
function enablereasonsubmitbutton()
	{	
	var biometric_reason=document.getElementById("biometric_reason").value;
	if(biometric_reason=="")
		{
		document.getElementById("SubmitReasonButton").disabled=true;
		}
	else
		{
		document.getElementById("SubmitReasonButton").disabled=false;
		}	
	}
function SaveBiometricReason()
	{
	document.Biometric_Authentication_form.submit();
	window.close();
	}	