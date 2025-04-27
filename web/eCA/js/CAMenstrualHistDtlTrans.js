/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/

function submitPage() {
	var pat_id = PatientSearch();
	if (pat_id != null)
		document.getElementById('patient_id').value = pat_id;
}



function submitPage() {
	var patient_id = MenstrualHistDtlQueryForm.patient_id.value;
	var facility_id = MenstrualHistDtlQueryForm.facility_id.value;
	var language_id = MenstrualHistDtlQueryForm.language_id.value;
	var option_id = MenstrualHistDtlQueryForm.option_id.value;

	if (patient_id == "") {
		var msg = getMessage("CAN_NOT_BE_BLANK", "common");
		msg = msg.replace("$", "Patient ID");
		alert(msg);
		MenstrualHistDtlQueryForm.patient_id.focus();
		return;
	} else {
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PAT_VALID_YN\"";
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " facilityID=\"" + facility_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var checkValidPat = trimString(xmlHttp.responseText);
		if (checkValidPat == "0") {
			alert(getMessage('NOT_VALID_PATID','CA'));
			parent.MenstrualHistDtlResultFrame.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href = "../../eCommon/html/blank.html";
			return;
		}
		if(patient_id !='')
		 {
	     document.getElementById('patient_id').disabled = true;    
		 document.getElementById('patient_search').disabled = true;
	     }
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PATIENT_RANGE\"";  
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " facilityID=\"" + facility_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var age = trimString(xmlHttp.responseText);
		if (age == "N") {
			alert(getMessage('PAT_RANGE_OUT_ALLOWED','CA'));
			parent.MenstrualHistDtlResultFrame.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href = "../../eCommon/html/blank.html";
			return;
		}
		var xmlStr = "<root><SEARCH ";
		xmlStr += " p_action=\"CHK_PATIENT_GENDER\"";  
		xmlStr += " patient_id=\"" + patient_id + "\" ";
		xmlStr += " facilityID=\"" + facility_id + "\" ";
		xmlStr += " /></root>";
		var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		var responseText = xmlHttp.responseText;
		var gender = trimString(xmlHttp.responseText);
		
		if (gender == "N") {
			alert(getMessage('GENDER_IS_NOT_FEMALE','CA'));
			parent.MenstrualHistDtlResultFrame.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.location.href = "../../eCommon/html/blank.html";
			return;
		}
		 var xmlStr = "<root><SEARCH ";
	        xmlStr += " p_action=\"CHK_PATIENT_AVAILABLE\"";  
	        xmlStr += " patient_id=\"" + patient_id + "\" ";
	        xmlStr += " facilityID=\"" + facility_id + "\" ";
	        xmlStr += " /></root>";
	       var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
	        var xmlDoc="";
	        var xmlHttp = new XMLHttpRequest();
	        xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	        xmlHttp.open("POST", temp_jsp, false);
	        xmlHttp.send(xmlDoc);submitPage
	        var responseText = xmlHttp.responseText;
	        // Parse the response to extract the three values
	        var patientData = responseText.split(",");
	        var patient_id = patientData[0];
	        var encounter_id = patientData[1];
	        var episode_id = patientData[2];
	        if (patient_id == "0" || encounter_id == undefined || encounter_id == null || encounter_id === "" || episode_id == undefined || episode_id == null || episode_id === "") {
	            alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "common"));
	            parent.MenstrualHistDtlResultFrame.location.href = "../../eCommon/html/blank.html";
	            parent.messageFrame.location.href = "../../eCommon/html/blank.html";
	            return;
	        }

	        // Build the query string with the retrieved patient data
	    var params = '?patient_id=' + patient_id + '&facility_id=' + facility_id + '&language_id=' + language_id + '&checkValidPat=' + checkValidPat + '&encounter_id=' + encounter_id + '&episode_id=' + episode_id + '&option_id=' + option_id;
	    parent.MenstrualHistDtlResultFrame.location.href = '../../eCA/jsp/CAMenstrualHistDetail.jsp'+params;
		parent.messageFrame.location.href = "../../eCommon/html/blank.html";
	}

}

function clear1(){
	var called_form=document.getElementById('called_form').value;
	var module_id=document.getElementById('module_id').value;


	if(called_form === "PAS_TRANSCATION_INVOKING"){
	   document.getElementById('scanGestationWeeks').value = "";
	    document.getElementById('scanGestationDays').value = "";
	    document.getElementById('unsureDate').value = "";
	    document.getElementById('redd').value = "";
	    document.getElementById('gestationPogWeeks').value = "";
	    document.getElementById('gestationPogDays').value = "";
	    if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
	    document.getElementById('unsureDeliveryMiscarrageType').value = "";
	    document.getElementById('unsureDeliveryMiscarrageType').disabled=true;

	    }
	    document.getElementById('unsureDeliveryMiscarrageDate').value = "";
	    document.getElementById('remarkUnsure').value = "";

	}
	else{
	parent.location.reload();
	}
}




function Check_Date(objText,locale) {
	var lmpDate = document.getElementById("lmpDate").value;

	if (objText.value != '') {
		if(validDate(objText.value,"DMY",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_FMT","CA"));
			objText.select();
			objText.focus();
			objText.value='';
			return false;
		}
		if (!(isBeforeNow(objText.value, "DMY", locale))) {
			var msgref = getMessage("STRT_DT_NOT_SYS_DT", "CA");
			msgref = msgref.replace('Start Date/Time','LMP Date');
			msgref = msgref.replace('Date/Time','Date');
			alert(msgref);
			objText.select();
			objText.focus();
			objText.value='';
			return false;
		}
		
	}
	
}



function CheckForNumsAndColon(event) {
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function Check_Date1(objText, locale) {
    var lmpDeliveryMiscarrageDate = document.getElementById("lmpDeliveryMiscarrageDate").value;
    var lmpDeliveryMiscarrageType = document.getElementById("lmpDeliveryMiscarrageType").value;  // Added this line

    if (objText.value != '') {
        // Validate if the date is in a correct format
        if (validDate(objText.value, "DMY", locale) == false) {
            alert(getMessage("INVALID_DATE_FMT", "CA"));
            objText.select();
            objText.focus();
            objText.value = '';
            return false;
        }
        
        // Check if the date is before the current date
        if (!(isBeforeNow(objText.value, "DMY", locale))) {
            var msgref = getMessage("STRT_DT_NOT_SYS_DT", "CA");
            
            // Handle the type of date (Delivery or Miscarriage)
            if (lmpDeliveryMiscarrageType == "D") {
                msgref = msgref.replace('Start Date/Time', 'Delivery Date');
            } else {
                msgref = msgref.replace('Start Date/Time', 'Miscarriage Date');
            }
            
            // Replace 'Date/Time' in the message
            msgref = msgref.replace('Date/Time', 'Date');
            alert(msgref);
            objText.select();
            objText.focus();
            objText.value = '';
            return false;
        }
    }
}

function Check_Date2(objText, locale) {
    var unsureDeliveryMiscarrageDate = document.getElementById("unsureDeliveryMiscarrageDate").value;
    var unsureDeliveryMiscarrageType = document.getElementById("unsureDeliveryMiscarrageType").value;  // Added this line

    if (objText.value != '') {
        // Validate if the date is in a correct format
        if (validDate(objText.value, "DMY", locale) == false) {
            alert(getMessage("INVALID_DATE_FMT", "CA"));
            objText.select();
            objText.focus();
            objText.value = '';
            return false;
        }
        
        // Check if the date is before the current date
        if (!(isBeforeNow(objText.value, "DMY", locale))) {
            var msgref = getMessage("STRT_DT_NOT_SYS_DT", "CA");
            
            // Handle the type of date (Delivery or Miscarriage)
            if (unsureDeliveryMiscarrageType == "D") {
                msgref = msgref.replace('Start Date/Time', 'Delivery Date');
            } else {
                msgref = msgref.replace('Start Date/Time', 'Miscarriage Date');
            }
            
            // Replace 'Date/Time' in the message
            msgref = msgref.replace('Date/Time', 'Date');
            alert(msgref);
            objText.select();
            objText.focus();
            objText.value = '';
            return false;
        }
    }
}



function CheckForNumsAndColon1(event) {
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}

function showCalendarValidate1(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}


function apply() {
	var lmpDate = document.getElementById("lmpDate").value;
	var lmpDeliveryMiscarrageDate = document.getElementById("lmpDeliveryMiscarrageDate").value;
    var lmpDeliveryMiscarrageType = document.getElementById('lmpDeliveryMiscarrageType').value;
    var mode1 = document.getElementById('mode1').value;
    var remarkLmp = document.getElementById('remarkLmp').value;
    var previousLmpDate = document.getElementById('pervious_lmp_Date').value;
    var previousRemarkLmp = document.getElementById('pervious_remark_lmp').value;
	var called_form=document.getElementById('called_form').value
	var eddDate=document.getElementById('eddDate').value
	var gestationPoaWeek=document.getElementById('gestationPoaWeek').value
	var gestationPoaDays=document.getElementById('gestationPoaDays').value

	if (lmpDate === "") {
        alert(getMessage("LMP_BLANK", "CA"));
        return;  
    }
	
	if (lmpDeliveryMiscarrageType !== "" && lmpDeliveryMiscarrageDate === "") {
        var msgref=getMessage("DILEVERY_MISCARRIAGE_BLANK", "CA");
		alert(msgref);
        return;
    }
	
    var modifyRemark = "";
    if (mode1 === "modify" && (lmpDate !== previousLmpDate || remarkLmp !== previousRemarkLmp)) {
        modifyRemark = openModifyRemarksPopUp();
        // If no remark is returned, stop the process
        if (!modifyRemark) {
            return; // Stop execution if no remark was provided
        }
    }
    
    
	  // Enable disabled fields temporarily
	  document.getElementById('eddDate').disabled = false;
	  document.getElementById('gestationPoaWeek').disabled = false;
	  document.getElementById('gestationPoaDays').disabled = false;
	  
	document.forms[0].action = "../../servlet/eCA.CAMenstrualHistTranscationDtlServlet?modifyRemark=" + encodeURIComponent(modifyRemark);
	document.MenstrualHistDtlBottomForm.target="messageFrame";
	document.MenstrualHistDtlBottomForm.method="post";
	document.MenstrualHistDtlBottomForm.submit();
	  // Re-disable the fields after submission (optional)
	  document.getElementById('eddDate').disabled = true;
	  document.getElementById('gestationPoaWeek').disabled = true;
	  document.getElementById('gestationPoaDays').disabled = true;
	  if(called_form === "PAS_TRANSCATION_INVOKING"){
      /*parent.MenstrualHistDtlResultFrame.close();
      parent.MenstrualHistDtlTopFrame.close();
      parent.MenstrualHistDtlBottomFrame.close();*/
		  window.returnValue = { lmpDate: lmpDate, gestationPoaWeek: gestationPoaWeek, gestationPoaDays: gestationPoaDays, eddDate: eddDate, lmpDeliveryMiscarrageType: lmpDeliveryMiscarrageType, lmpDeliveryMiscarrageDate: lmpDeliveryMiscarrageDate };
		        window.close(); // Close the modal dialog
	}
}


function isValidInteger(obj) {
	var key = window.event.keyCode;
	if(!(key >= 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
} 



function checkFields() {

 
	var lmpDate = document.getElementById('lmpDate').value;
    var eddDate = document.getElementById('eddDate').value;
    var gestationPoaWeek = document.getElementById('gestationPoaWeek').value;
    var gestationPoaDays = document.getElementById('gestationPoaDays').value;
    var lmpDeliveryMiscarrageDate = document.getElementById('lmpDeliveryMiscarrageDate');
    var mandatoryIcon = document.getElementById('mandatoryIcon');
    var lmpDeliveryMiscarrageType = document.getElementById('lmpDeliveryMiscarrageType');
    
    var module_id = document.getElementById('module_id').value;
	 var called_form = document.getElementById('called_form').value;
	 
    
    if (module_id == "REGISTER_NEWBORN" || module_id == "MAINTAIN_BIRTH") {
    	lmpDeliveryMiscarrageType.disabled = true;
    	lmpDeliveryMiscarrageType.value="Delivery";
    	if(lmpDate && eddDate  && gestationPoaWeek && gestationPoaDays)
    		{
    			lmpDeliveryMiscarrageDate.disabled = false;  
    			mandatoryIcon.style.display = 'inline';
    		}
    	else
    		{
    			lmpDeliveryMiscarrageDate.disabled = true; // Disable the date input field
            	mandatoryIcon.style.display = 'none'; // Hide the mandatory icon
    		}
	} else if ( lmpDate && eddDate  && gestationPoaWeek && gestationPoaDays ) {
		lmpDeliveryMiscarrageType.disabled = false;
	} else {
		lmpDeliveryMiscarrageType.disabled = true;
	}

    
/*    if (lmpDate && eddDate && gestationPoaWeek && gestationPoaDays) {
    	lmpDeliveryMiscarrageType.disabled = false;
    } else {
    	lmpDeliveryMiscarrageType.disabled = true;
    }*/
    
}

function toggleDeliveryMiscarrageDate() {
    var lmpDeliveryMiscarrageType = document.getElementById('lmpDeliveryMiscarrageType').value;
    var lmpDeliveryMiscarrageDate = document.getElementById('lmpDeliveryMiscarrageDate');
    var mandatoryIcon = document.getElementById('mandatoryIcon');

    lmpDeliveryMiscarrageDate.value = '';
    
    // Check if a valid option is selected
    if (lmpDeliveryMiscarrageType!== '') {
    	lmpDeliveryMiscarrageDate.disabled = false;  // Enable the date input field
        mandatoryIcon.style.display = 'inline'; // Show the mandatory icon
    } else {
    	lmpDeliveryMiscarrageDate.disabled = true; // Disable the date input field
        mandatoryIcon.style.display = 'none'; // Hide the mandatory icon
    }
}



function toggleUnSureDeliveryMiscarrageDate() {
    var unsureDeliveryMiscarrageType = document.getElementById('unsureDeliveryMiscarrageType').value;
    var unsureDeliveryMiscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate');
    var mandatoryIcons = document.getElementById('mandatoryIcons');

    unsureDeliveryMiscarrageDate.value = '';
    
    // Check if a valid option is selected
    if (unsureDeliveryMiscarrageType!== '') {
    	unsureDeliveryMiscarrageDate.disabled = false;  // Enable the date input field
    	mandatoryIcons.style.display = 'inline'; // Show the mandatory icon
    } else {
    	unsureDeliveryMiscarrageDate.disabled = true; // Disable the date input field
    	mandatoryIcons.style.display = 'none'; // Hide the mandatory icon
    }
}



function loadLmpDate() {
    var lmpDate = document.getElementById('lmpDate').value;
    var  patient_id= document.getElementsByName('patient_id').value;
    var cutOffDeliveryLmp = parseInt(document.getElementById('cutOffDeliveryLmp').value); // Convert to integer
    var cutOffMiscarriageLmp = parseInt(document.getElementById('cutOffMiscarriageLmp').value); // Convert to integer
    var delivery_miscarrage_type_value = document.getElementById('delivery_miscarrage_type_value').value;
    var delivery_miscarrage_date_value = document.getElementById('delivery_miscarrage_date_value').value;
    var exisiting_delivery_miscarrage_date_value = document.getElementById('exisiting_delivery_miscarrage_date_value').value;
    var exisiting_delivery_miscarrage_type_value = document.getElementById('exisiting_delivery_miscarrage_type_value').value;
    var selected_Values = document.getElementById('selected_Values').value;
    var module_id = document.getElementById('module_id').value;

    if (lmpDate === "") {
    	clearLmpField();
        return; // Stop further execution
    }
    
    if (delivery_miscarrage_type_value === "D" && delivery_miscarrage_date_value !== "") {
        var deliveryDateObj = parseDate(delivery_miscarrage_date_value); 
        var lmpDateObj = parseDate(lmpDate);

        if (lmpDateObj.getTime() <= deliveryDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_DELIVERY", "CA")); // Validation message
            document.getElementById('lmpDate').value = ""; // Clear the LMP field
            clearLmpField();
            return; // Stop further execution
        }
    }

    if (delivery_miscarrage_type_value === "M" && delivery_miscarrage_date_value !== "") {
        var miscarriageDateObj = parseDate(delivery_miscarrage_date_value); 
        var lmpDateObj = parseDate(lmpDate);

        if (lmpDateObj.getTime() <= miscarriageDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_MISCARRIAGE", "CA")); // Validation message
            document.getElementById('lmpDate').value = ""; // Clear the LMP field
            clearLmpField();
            return; // Stop further execution
        }
    }
    
    if (delivery_miscarrage_type_value === "D" && delivery_miscarrage_date_value !== "") {
    	 var deliveryDateObj = parseDate(delivery_miscarrage_date_value); 
    	    var lmpDateObj = parseDate(lmpDate); 
    	    var cutoffDays = parseInt(cutOffDeliveryLmp, 10); // Ensure cutoff value is an integer
    	    var minAllowedDate = new Date(deliveryDateObj);
    	    minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
    	 
    	    if (lmpDateObj.getTime() <= minAllowedDate.getTime()) {
    	        alert(getMessage("LMP_DATE_CUTOFF_DELIVERY","CA")); // Validation message
    	        document.getElementById('lmpDate').value = ""; // Clear the LMP field
    	        clearLmpField();
    	        return; // Stop further execution
    	    } 
    }
    
    
    if (delivery_miscarrage_type_value === "M" && delivery_miscarrage_date_value !== "") {
   	 var deliveryDateObj = parseDate(delivery_miscarrage_date_value); 
   	    var lmpDateObj = parseDate(lmpDate); 

   	    var minAllowedDate = new Date(deliveryDateObj);
   	    var cutoffDays = parseInt(cutOffMiscarriageLmp, 10); // Ensure cutoff value is an integer
   	    
   	    minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
   
   	    if (lmpDateObj.getTime() <= minAllowedDate.getTime()) {
   	        alert(getMessage("LMP_DATE_CUTOFF_MISCARRAGE","CA")); // Validation message
   	        document.getElementById('lmpDate').value = ""; // Clear the LMP field
   	        clearLmpField();
   	        return; // Stop further execution
   	    } 
   }
   
    if (exisiting_delivery_miscarrage_type_value === "D" && exisiting_delivery_miscarrage_date_value !== "") {
        var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
        var lmpDateObj = parseDate(lmpDate);

        if (lmpDateObj.getTime() <= deliveryDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_DELIVERY", "CA")); // Validation message
            document.getElementById('lmpDate').value = ""; // Clear the LMP field
            clearLmpField();
            return; // Stop further execution
        }
    }
    
    
    if (exisiting_delivery_miscarrage_type_value === "M" && exisiting_delivery_miscarrage_date_value !== "") {
        var miscarriageDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
        var lmpDateObj = parseDate(lmpDate);

        if (lmpDateObj.getTime() <= miscarriageDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_MISCARRIAGE", "CA")); // Validation message
            document.getElementById('lmpDate').value = ""; // Clear the LMP field
            clearLmpField();
            return; // Stop further execution
        }
    }
    
    
    if (exisiting_delivery_miscarrage_type_value === "D" && exisiting_delivery_miscarrage_date_value !== "") {
   	 var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
   	    var lmpDateObj = parseDate(lmpDate); 
   	    var cutoffDays = parseInt(cutOffDeliveryLmp, 10); // Ensure cutoff value is an integer
   	    var minAllowedDate = new Date(deliveryDateObj);
   	    minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
   	 
   	    if (lmpDateObj.getTime() <= minAllowedDate.getTime()) {
   	        alert(getMessage("LMP_DATE_CUTOFF_DELIVERY","CA")); // Validation message
   	        document.getElementById('lmpDate').value = ""; // Clear the LMP field
   	        clearLmpField();
   	        return; // Stop further execution
   	    } 
   }
    
    
    if (exisiting_delivery_miscarrage_type_value === "M" && exisiting_delivery_miscarrage_date_value !== "") {
      	 var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
      	    var lmpDateObj = parseDate(lmpDate); 

      	    var minAllowedDate = new Date(deliveryDateObj);
      	    var cutoffDays = parseInt(cutOffMiscarriageLmp, 10); // Ensure cutoff value is an integer
      	    
      	    minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
      
      	    if (lmpDateObj.getTime() <= minAllowedDate.getTime()) {
      	        alert(getMessage("LMP_DATE_CUTOFF_MISCARRAGE","CA")); // Validation message
      	        document.getElementById('lmpDate').value = ""; // Clear the LMP field
      	        clearLmpField();
      	        return; // Stop further execution
      	    } 
      }

    
    var xmlStr = "<root><SEARCH ";
    xmlStr += " p_action=\"CHK_LMP_DATE\"";
    xmlStr += " patient_id=\"" + patient_id + "\" ";
    xmlStr += " lmp_date=\"" + lmpDate + "\" "; // Send LMP date to the server
    xmlStr += " /></root>";

    var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    /*var responseText = xmlHttp.responseText;
    var xmlResponse = new ActiveXObject("Microsoft.XMLDOM");
    xmlResponse.async = false;
    xmlResponse.loadXML(responseText);
    var edd = xmlResponse.getElementsByTagName("edd")[0].text;
    var gestationWeeks = xmlResponse.getElementsByTagName("gestationWeeks")[0].text;
    var gestationDays = xmlResponse.getElementsByTagName("gestationDays")[0].text;*/
	
	var responseText = xmlHttp.responseText;

// Check if responseText contains valid XML
if (responseText) {
    var parser = new DOMParser();
    var xmlResponse = parser.parseFromString(responseText, "application/xml");

    var edd = xmlResponse.getElementsByTagName("edd")[0].textContent;
    var gestationWeeks = xmlResponse.getElementsByTagName("gestationWeeks")[0].textContent;
    var gestationDays = xmlResponse.getElementsByTagName("gestationDays")[0].textContent;
} else {
    console.error("Invalid XML response.");
}

    
    document.getElementById('eddDate').value = edd;
    document.getElementsByName('gestationPoaWeek')[0].value = gestationWeeks;
    document.getElementsByName('gestationPoaDays')[0].value = gestationDays;
    
    checkFields();

}


function unSurucheckFields() {
	 var scanGestationWeeks = document.getElementById('scanGestationWeeks').value;
	 var scanGestationDays = document.getElementById('scanGestationDays').value;
	 var unsureDate =document.getElementById('unsureDate').value;
	 var redd = document.getElementById('redd').value;
	 var gestationPogWeeks = document.getElementById('gestationPogWeeks').value;
	 var gestationPogDays = document.getElementById('gestationPogDays').value;
	 var unsureDeliveryMiscarrageType = document.getElementById('unsureDeliveryMiscarrageType');
	 var module_id = document.getElementById('module_id').value;
	 var called_form = document.getElementById('called_form').value;
	 
	 var unsureDeliveryMiscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate');
	    var mandatoryIcons = document.getElementById('mandatoryIcons');
	    
  /*  if (scanGestationWeeks && scanGestationDays && unsureDate && redd && gestationPogWeeks && gestationPogDays) {
    	unsureDeliveryMiscarrageType.disabled = false;
    } else {
    	unsureDeliveryMiscarrageType.disabled = true;
    }*/
	 
	 if (module_id == "REGISTER_NEWBORN" || module_id == "MAINTAIN_BIRTH") {
		    unsureDeliveryMiscarrageType.disabled = true;
		    unsureDeliveryMiscarrageType.value="Delivery";
		    if(scanGestationWeeks && scanGestationDays && unsureDate && redd && gestationPogWeeks && gestationPogDays)
    		{
		    	unsureDeliveryMiscarrageDate.disabled = false;  // Enable the date input field
		    	mandatoryIcons.style.display = 'inline'; // Show the mandatory icon
    		}
    	else
    		{
    			unsureDeliveryMiscarrageDate.disabled = true; // Disable the date input field
    		    mandatoryIcons.style.display = 'none'; // Hide the mandatory icon
    		}
		} else if ( scanGestationWeeks && scanGestationDays && unsureDate && redd && gestationPogWeeks && gestationPogDays) {
		    unsureDeliveryMiscarrageType.disabled = false;
		} else {
		    unsureDeliveryMiscarrageType.disabled = true;
		}

}



function unSureDate(obj) {
    var scanGestationWeeks = document.getElementById('scanGestationWeeks').value;
    var scanGestationDays = document.getElementById('scanGestationDays').value;
    var  patient_id= document.getElementsByName('patient_id').value;
    
 
    if(scanGestationWeeks=="" && scanGestationDays=="")
    	{
    	clearUnSuruField();
    	}
  
    var xmlStr = "<root><SEARCH ";
    xmlStr += " p_action=\"CHK_UNSURE_PRE_DATE\"";
    xmlStr += " patient_id=\"" + patient_id + "\" ";
    xmlStr += " scanGestationWeeks=\"" + scanGestationWeeks + "\" ";
    xmlStr += " scanGestationDays=\"" + scanGestationDays + "\" "; 
    xmlStr += " /></root>";

    var temp_jsp = "../../eCA/jsp/CAMenstrualHistDtlIntermediate.jsp";
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = xmlHttp.responseText;
    var xmlResponse = new ActiveXObject("Microsoft.XMLDOM");
    xmlResponse.async = false;
    xmlResponse.loadXML(responseText);
    var lmpDate = xmlResponse.getElementsByTagName("lmpDate")[0].text;
    var reddDate = xmlResponse.getElementsByTagName("reddDate")[0].text;
    var pogWeeks = xmlResponse.getElementsByTagName("gestationWeeks")[0].text;
    var pogDays = xmlResponse.getElementsByTagName("gestationDays")[0].text;
    
    
    document.getElementById('unsureDate').value = lmpDate;
    document.getElementsByName('redd')[0].value = reddDate;
    document.getElementsByName('gestationPogWeeks')[0].value = pogWeeks;
    document.getElementsByName('gestationPogDays')[0].value = pogDays;

    unSurucheckFields();
    setInterval(checkForChanges, 1000);
    

}



function remarksvalidation()
{
	  var remarkLmp = document.getElementById('remarkLmp').value;

	  if (remarkLmp.length > 150) {
	        alert(getMessage("MENS_REMARK_LIMIT","CA"));
	    	document.getElementById("remarkLmp").select();
			return false;
	        }
}


function remarksvalidation1()
{
	  var remarkUnsure = document.getElementById('remarkUnsure').value;
	   if (remarkUnsure.length > 150) {
	        alert(getMessage("MENS_REMARK_LIMIT","CA"));
	        document.getElementById("remarkUnsure").select();
			return false;
	        }
}


function clearLmpField()
{
	var module_id=document.getElementById('module_id').value;
	
	document.getElementById('eddDate').value = "";
    document.getElementById('gestationPoaWeek').value = "";
    document.getElementById('gestationPoaDays').value = "";
    if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
    document.getElementById('lmpDeliveryMiscarrageType').value="";
    document.getElementById('lmpDeliveryMiscarrageType').disabled=true;
    }
    document.getElementById('lmpDeliveryMiscarrageDate').value="";
    document.getElementById('lmpDeliveryMiscarrageDate').disabled=true;	
    document.getElementById('mandatoryIcon').style.display = 'none';
}

function clearUnSuruField() { 
	var module_id=document.getElementById('module_id').value;
    // Clear input fields
    document.getElementById('scanGestationWeeks').value = "";
    document.getElementById('scanGestationDays').value = "";
    document.getElementById('unsureDate').value = "";
    document.getElementById('redd').value = "";
    document.getElementById('gestationPogWeeks').value = "";
    document.getElementById('gestationPogDays').value = "";
    if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
    document.getElementById('unsureDeliveryMiscarrageType').value = "";
    }
    document.getElementById('unsureDeliveryMiscarrageDate').value = "";

    // Disable elements
    var miscarrageType = document.getElementById('unsureDeliveryMiscarrageType');
    var miscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate');
    
    if (miscarrageType) {
        miscarrageType.disabled = true;
    }
    if (miscarrageDate) {
        miscarrageDate.disabled = true;
    }

    // Hide mandatory icons
    var mandatoryIcons = document.getElementById('mandatoryIcons');
    if (mandatoryIcons) {
        mandatoryIcons.style.display = 'none';
    }
}

function parseDate(dateString) {
    // Split the date string into components using '/' as the delimiter
    var parts = dateString.split('/');
    // Create a new Date object with year, month, and day
    // Month is zero-based in JavaScript Date object, so we subtract 1 from the month
    return new Date(parts[2], parts[1] - 1, parts[0]);
}

function dateValidation() {
    var lmpDate = document.getElementById('lmpDate').value;
    var eddDate = document.getElementById('eddDate').value;
    var lmpDeliveryMiscarrageDate = document.getElementById('lmpDeliveryMiscarrageDate').value;
    var lmpDeliveryMiscarrageType = document.getElementById('lmpDeliveryMiscarrageType').value;
    var cutOffBackdate = document.getElementById('cutOffBackdate').value;
    var cutOffDeliveryDate = document.getElementById('cutOffDeliveryDate').value;
    var finalize_yn = document.getElementById('finalize_yn').value;
    var eventStatus_validation = document.getElementById('eventStatus_validation').value;
    var delivery_miscarrage_date_validation = document.getElementById('delivery_miscarrage_date_validation').value;
    var multibirthvalue = document.getElementById('multibirthvalue').value;
    var module_id = document.getElementById('module_id').value;


    // Parse the date strings to Date objects
    var lmpDateObj = parseDate(lmpDate);
    var eddDateObj = parseDate(eddDate);
    var lmpDeliveryMiscarrageDateObj = parseDate(lmpDeliveryMiscarrageDate);
    var delivery_miscarrage_date_validationObj = parseDate(delivery_miscarrage_date_validation);
    
    
    if (eventStatus_validation === "E" && multibirthvalue === "Y" && finalize_yn === "N" && (module_id === "REGISTER_NEWBORN" || module_id === "MAINTAIN_BIRTH")) {
        if (lmpDeliveryMiscarrageDateObj.getTime() >= delivery_miscarrage_date_validationObj.getTime()) {
        	  var msgref = getMessage("EARLIER_BIRTH_VALIDATION", "CA");
              msgref = msgref.replace('$', 'delivery_miscarrage_date_validation');
              alert(msgref);
            document.getElementById('lmpDeliveryMiscarrageDate').value = "";
            return;
        }
    }



    if (lmpDeliveryMiscarrageType === 'D') {        
        if (cutOffBackdate == 0) {
            // If cutOffBackdate is 0, lmpDeliveryMiscarrageDate must equal eddDate
            if (lmpDeliveryMiscarrageDateObj.getTime() < eddDateObj.getTime()) {
                alert(getMessage("CUT_OFF_BACKDATE_EDD_DELIVERY", "CA"));
                document.getElementById('lmpDeliveryMiscarrageDate').value = "";
                return;
            }
        } else if (cutOffBackdate > 0) {
            // Calculate the minimum allowed date
            var minDateAllowed = new Date(eddDateObj);
            minDateAllowed.setDate(minDateAllowed.getDate() - cutOffBackdate);

            // Check if lmpDeliveryMiscarrageDate is less than the minimum allowed date
            if (lmpDeliveryMiscarrageDateObj.getTime() < minDateAllowed.getTime()) {
                alert(getMessage("CUT_OFF_BACKDATE_EDD_DELIVERY", "CA"));
                document.getElementById('lmpDeliveryMiscarrageDate').value = "";
                return;
            }
        }
    }
    
    if (lmpDeliveryMiscarrageType === 'D') {  // Delivery event
        if (cutOffDeliveryDate == 0) {  // Example 1: Cut-off period is zero days
            // Delivery date must be exactly the same as EDD/REDD
            if (lmpDeliveryMiscarrageDateObj.getTime() > eddDateObj.getTime()) {
                alert(getMessage("CUT_OFF_FUTURE__EDD_DELIVERY", "CA"));  // Show validation message
                document.getElementById('lmpDeliveryMiscarrageDate').value = "";  // Clear invalid date
                return;
            }
        } else if (cutOffDeliveryDate > 0) {  // Example 2: Cut-off period > 0 (e.g., 7 days)
            // Calculate the latest allowed delivery date
            var maxAllowedDate = new Date(eddDateObj);
            maxAllowedDate.setDate(maxAllowedDate.getDate() + parseInt(cutOffDeliveryDate));

            // Check if delivery date is beyond the allowed range
            if (lmpDeliveryMiscarrageDateObj.getTime() > maxAllowedDate.getTime()) {
                alert(getMessage("CUT_OFF_FUTURE__EDD_DELIVERY", "CA"));  // Show validation message
                document.getElementById('lmpDeliveryMiscarrageDate').value = "";  // Clear invalid date
                return;
            }
        }
    }

    
    // Condition when lmpDeliveryMiscarrageType is 'D' (Delivery)
    if (lmpDeliveryMiscarrageType === 'D') {
        // Check if lmpDeliveryMiscarrageDate is less than or equal to lmpDate
        if (lmpDeliveryMiscarrageDateObj <= lmpDateObj) {
            var msgref = getMessage("DILEVERY_MISCARRIAGE_LESS_THAN_LMP", "CA");
            alert(msgref);
            document.getElementById('lmpDeliveryMiscarrageDate').value = "";
            return;
        }
    }

    // Condition when lmpDeliveryMiscarrageType is 'M' (Miscarriage)
    if (lmpDeliveryMiscarrageType === 'M') {
        // Check if lmpDeliveryMiscarrageDate is less than lmpDate
        if (lmpDeliveryMiscarrageDateObj < lmpDateObj) {
            var msgref = getMessage("DILEVERY_MISCARRIAGE_LESS_THAN_LMP", "CA");
            msgref = msgref.replace('Delivery Date', 'Miscarriage Date');
            msgref = msgref.replace('or equal to', '');
            alert(msgref);
            document.getElementById('lmpDeliveryMiscarrageDate').value = "";
            return;
        }

        // Check if lmpDeliveryMiscarrageDate is greater than edd_Date
        if (lmpDeliveryMiscarrageDateObj > eddDateObj) {
            var msgref = getMessage("DILEVERY_MISCARRIAGE_GREATER_THAN_EDD", "CA");
            alert(msgref);
            document.getElementById('lmpDeliveryMiscarrageDate').value = "";
            return;
        }
    }
}



function dateValidation1() {
    var unsureDate = document.getElementById('unsureDate').value;
    var redd = document.getElementById('redd').value;
    var unsureDeliveryMiscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate').value;
    var unsureDeliveryMiscarrageType = document.getElementById('unsureDeliveryMiscarrageType').value;
    var cutOffBackdate = document.getElementById('cutOffBackdate').value;
    var cutOffDeliveryDate = document.getElementById('cutOffDeliveryDate').value;
    var finalize_yn = document.getElementById('finalize_yn').value;
    var eventStatus_validation = document.getElementById('eventStatus_validation').value;
    var delivery_miscarrage_date_validation = document.getElementById('delivery_miscarrage_date_validation').value;
    var multibirthvalue = document.getElementById('multibirthvalue').value;
    var module_id = document.getElementById('module_id').value;
    // Parse the date strings to Date objects
    var unsureDateObj = parseDate(unsureDate);
    var reddObj = parseDate(redd);
    var unsureDeliveryMiscarrageDateObj = parseDate(unsureDeliveryMiscarrageDate);
   var delivery_miscarrage_date_validationObj = parseDate(delivery_miscarrage_date_validation);

   if (eventStatus_validation === "E" && multibirthvalue === "Y" && finalize_yn === "N" && (module_id === "REGISTER_NEWBORN" || module_id === "MAINTAIN_BIRTH")) {
       if (unsureDeliveryMiscarrageDateObj.getTime() >= delivery_miscarrage_date_validationObj.getTime()) {
       	  var msgref = getMessage("EARLIER_BIRTH_VALIDATION", "CA");
             msgref = msgref.replace('$', 'delivery_miscarrage_date_validation');
             alert(msgref);
           document.getElementById('lmpDeliveryMiscarrageDate').value = "";
           return;
       }
   }
   
    
   if (unsureDeliveryMiscarrageType === 'D') {        
       if (cutOffBackdate == 0) {
           // If cutOffBackdate is 0, lmpDeliveryMiscarrageDate must equal eddDate
           if (unsureDeliveryMiscarrageDateObj.getTime() < reddObj.getTime()) {
               alert(getMessage("CUT_OFF_BACKDATE_REDD_DELIVERY", "CA"));
               document.getElementById('unsureDeliveryMiscarrageDate').value = "";
               return;
           }
       } else if (cutOffBackdate > 0) {
           // Calculate the minimum allowed date
           var minDateAllowed = new Date(reddObj);
           minDateAllowed.setDate(minDateAllowed.getDate() - cutOffBackdate);

           // Check if lmpDeliveryMiscarrageDate is less than the minimum allowed date
           if (unsureDeliveryMiscarrageDateObj.getTime() < minDateAllowed.getTime()) {
               alert(getMessage("CUT_OFF_BACKDATE_REDD_DELIVERY", "CA"));
               document.getElementById('unsureDeliveryMiscarrageDate').value = "";
               return;
           }
       }
   }

    if (unsureDeliveryMiscarrageType === 'D') { // Delivery event
        if (cutOffDeliveryDate == 0) {  // Example 1: Cut-off period is zero days
            // Delivery date must be exactly the same as EDD/REDD
            if (unsureDeliveryMiscarrageDateObj.getTime() > reddObj.getTime()) { 
                alert(getMessage("CUT_OFF_FUTURE__REDD_DELIVERY", "CA"));  // Show validation message
                document.getElementById('unsureDeliveryMiscarrageDate').value = "";  // Clear invalid date
                return;
            }
        } else if (cutOffDeliveryDate > 0) {  // Example 2: Cut-off period > 0 (e.g., 7 days)
            // Calculate the latest allowed delivery date
            var maxAllowedDate = new Date(reddObj);
            maxAllowedDate.setDate(maxAllowedDate.getDate() + parseInt(cutOffDeliveryDate));

            // Check if delivery date is beyond the allowed range
            if (unsureDeliveryMiscarrageDateObj.getTime() > maxAllowedDate.getTime()) {
                alert(getMessage("CUT_OFF_FUTURE__REDD_DELIVERY", "CA"));  // Show validation message
                document.getElementById('unsureDeliveryMiscarrageDate').value = "";  // Clear invalid date
                return;
            }
        }
    }

    // Check if unsureDeliveryMiscarrageDate is less than or equal to unsureDate based on type
    if (unsureDeliveryMiscarrageType == "D" && unsureDeliveryMiscarrageDateObj <= unsureDateObj) {
        var msgref = getMessage("DILEVERY_MISCARRIAGE_LESS_THAN_LMP", "CA");
        msgref = msgref.replace('Delivery Date', 'Delivery Date'); // You might not need to replace this
        alert(msgref);
        document.getElementById('unsureDeliveryMiscarrageDate').value = "";
        return;  
    }
    
    if (unsureDeliveryMiscarrageType == "M" && unsureDeliveryMiscarrageDateObj < unsureDateObj) {
        var msgref = getMessage("DILEVERY_MISCARRIAGE_LESS_THAN_LMP", "CA");
        msgref = msgref.replace('Delivery Date', 'Miscarriage Date');
        msgref = msgref.replace('or equal to', '');
        alert(msgref);
        document.getElementById('unsureDeliveryMiscarrageDate').value = "";
        return;  
    }

    // Check if unsureDeliveryMiscarrageDate is greater than redd when type is 'M'
    if (unsureDeliveryMiscarrageDateObj > reddObj && unsureDeliveryMiscarrageType === 'M') {
        var msgref = getMessage("DILEVERY_MISCARRIAGE_GREATER_THAN_EDD", "CA");
        msgref = msgref.replace('Miscarriage Date', 'Miscarriage Date'); // You might not need to replace this
        msgref = msgref.replace('EDD', 'REDD');
        alert(msgref);
        document.getElementById('unsureDeliveryMiscarrageDate').value = "";
        return;  
    }
}


function selectRadio(value) {
    var eventStatus = parent.frames['MenstrualHistDtlResultFrame'].document.forms['CAMenstrualHistDtlResultForm'].eventStatus.value;

    	if(eventStatus=="Active")
    	{
    	 alert(getMessage("EXISTING_ACTIVE_RECORDS_MENSTRUAL", "CA"));
    	  document.getElementById('radio_event_L').checked = false;
          document.getElementById('radio_event_U').checked = false;
    	 return;
    	}
	
	
	if (value === 'U') {
	var lmpDate,eddDate,gestationPoaWeek,gestationPoaDays,lmpDeliveryMiscarrageType,lmpDeliveryMiscarrageDate,remarkLmp;
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDate){ 
    	lmpDate = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDate.value;
    }

    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].eddDate){ 
     eddDate = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].eddDate.value;
    }
    
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaWeek){ 
     gestationPoaWeek = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaWeek.value;
    }
    
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaDays){ 
     gestationPoaDays = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaDays.value;
    }
    
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageType){ 
    lmpDeliveryMiscarrageType = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageType.value;
    }
    
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageDate){ 
    lmpDeliveryMiscarrageDate = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageDate.value;
    }
    
    if(parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].remarkLmp){ 
    remarkLmp = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].remarkLmp.value;
    }

    if (lmpDate !== '' || eddDate !== '' || gestationPoaWeek !== '' || gestationPoaDays !== '' || lmpDeliveryMiscarrageType !== '' || lmpDeliveryMiscarrageDate !== '' || remarkLmp !== '') {
    	var confirmClear = confirm(getMessage("ALL_VALUES_VALIDATING", "CA"));
        if (confirmClear) {
          // Clear fields if the user confirms
        	clearFields(value);
            // Switch to the 'U' condition
            switchToCondition(value);
        } else {
          // If user cancels, stop further execution
        	  document.getElementById('radio_event_L').checked = true;  // Check L radio button
              document.getElementById('radio_event_U').checked = false;
          return false;
        }
    	
	 }
    switchToCondition(value);
  }
	 else{
		 var scanGestationWeeks = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].scanGestationWeeks.value;
		 var scanGestationDays = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].scanGestationDays.value;
		 var unsureDate = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDate.value;
		 var redd = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].redd.value;
		 var gestationPogWeeks = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPogWeeks.value;
		 var gestationPogDays = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPogDays.value;
		 var unsureDeliveryMiscarrageType = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDeliveryMiscarrageType.value;
		 var unsureDeliveryMiscarrageDate = parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDeliveryMiscarrageDate.value;

		 if (scanGestationWeeks !== '' || scanGestationDays !== '' || unsureDate !== '' || redd !== '' || gestationPogWeeks !== '' || gestationPogDays !== '' || unsureDeliveryMiscarrageType !== '' || unsureDeliveryMiscarrageDate !== '') {
		    	var confirmClear = confirm(getMessage("ALL_VALUES_VALIDATING", "CA"));
		        if (confirmClear) {
		          // Clear fields if the user confirms
		        	clearFields(value);
		            // Switch to the 'U' condition
		            switchToCondition(value);
		        } else {
		          // If user cancels, stop further execution
		            document.getElementById('radio_event_U').checked = true; // Check U radio button
	                document.getElementById('radio_event_L').checked = false;
		          return false;
		        }
		    	
			 }
		    switchToCondition(value);
	 }
}
	 
	 
	 
function clearFields(value) {
if(value === 'U'){
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDate.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].eddDate.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaWeek.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPoaDays.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageType.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].lmpDeliveryMiscarrageDate.value = '';
	parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].remarkLmp.value = '';
}
else
	{
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].scanGestationWeeks.value;
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].scanGestationDays.value;
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDate.value;
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].redd.value;
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPogWeeks.value;
	 parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].gestationPogDays.value;
	 parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDeliveryMiscarrageType.value;
	  parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].unsureDeliveryMiscarrageDate.value;
	}
}



//Function to handle switching to 'U' condition
function switchToCondition(value) {
	var patient_id =parent.frames['MenstrualHistDtlTopFrame'].document.forms['MenstrualHistDtlTopForm'].patient_id.value;
	var option_id =parent.frames['MenstrualHistDtlTopFrame'].document.forms['MenstrualHistDtlTopForm'].option_id.value;
	var episode_id=document.forms['MenstrualHistDtlTopForm'].episode_id.value;
	var encounter_id=document.forms['MenstrualHistDtlTopForm'].encounter_id.value;
	var called_form=document.forms['MenstrualHistDtlTopForm'].called_form.value;
	var module_id=document.forms['MenstrualHistDtlTopForm'].module_id.value;
    parent.MenstrualHistDtlBottomFrame.location.href = "CAMenstrualHistDtlBottom.jsp?selectedValue=" + value + "&patient_id=" + patient_id + "&option_id=" + option_id + "&encounter_id=" + encounter_id + "&episode_id=" + episode_id+ "&called_form=" + called_form+ "&module_id=" +module_id;
}



function clearAll(){
	
	var called_form=document.getElementById('called_form').value;
	var module_id=document.getElementById('module_id').value;

	if(called_form === "PAS_TRANSCATION_INVOKING"){
	document.getElementById('lmpDate').value = "";
	document.getElementById('eddDate').value = "";
    document.getElementById('gestationPoaWeek').value = "";
    document.getElementById('gestationPoaDays').value = "";
    if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
    document.getElementById('lmpDeliveryMiscarrageType').value="";
    document.getElementById('lmpDeliveryMiscarrageType').disabled=true;
    }
    document.getElementById('lmpDeliveryMiscarrageDate').value="";
    document.getElementById('lmpDeliveryMiscarrageDate').disabled=true;	
    document.getElementById('mandatoryIcon').style.display = 'none';
    document.getElementById('remarkLmp').value="";

	}
	else
	{
	parent.location.reload();
	}
}




function reset1(){
	parent.location.reload();
}



function onSuccess()
{
parent.frames[3].MenstrualHistDtlResultFrame.location.reload(); 
}


function openLMPDetails(patient_id,selectedValue,Lmp_Date,edd,gestation_poa,delivery_miscarrage_type,delivery_miscarrage_date,remarks,srl_no)
{
var option_id = document.CAMenstrualHistDtlResultForm.option_id.value;
var encounter_id = document.CAMenstrualHistDtlResultForm.encounter_id.value;
var episode_id = document.CAMenstrualHistDtlResultForm.episode_id.value;
var called_form = document.CAMenstrualHistDtlResultForm.called_form.value;
var module_id = document.CAMenstrualHistDtlResultForm.module_id.value;
parent.MenstrualHistDtlTopFrame.location.href ="CAMenstrualHistDtlTop.jsp?mode1=modify&selectedValue=" +selectedValue;
parent.MenstrualHistDtlBottomFrame.location.href="CAMenstrualHistDtlBottom.jsp?mode1=modify&patient_id="+patient_id+"&selectedValue="+selectedValue+"&lmp_Date="+Lmp_Date+"&edd_Date="+edd+"&gestation_poa="+gestation_poa+"&lmp_Delivery_Miscarrage_Type="+delivery_miscarrage_type+"&lmp_Delivery_Miscarrage_Date="+delivery_miscarrage_date+"&remark_lmp="+encodeURIComponent(remarks)+"&option_id="+option_id+"&srl_no="+srl_no+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&called_form="+called_form+"&module_id="+module_id; 
}



function openUSODDetails(patient_id,selectedValue,scan_gestation,unsure_date,redd,gestation_pog,delivery_miscarrage_type,delivery_miscarrage_date,remarks,srl_no)
{
var option_id = document.CAMenstrualHistDtlResultForm.option_id.value;
var encounter_id = document.CAMenstrualHistDtlResultForm.encounter_id.value;
var episode_id = document.CAMenstrualHistDtlResultForm.episode_id.value;
var called_form = document.CAMenstrualHistDtlResultForm.called_form.value;
var module_id = document.CAMenstrualHistDtlResultForm.module_id.value;
parent.MenstrualHistDtlTopFrame.location.href ="CAMenstrualHistDtlTop.jsp?mode1=modify&selectedValue=" +selectedValue;
parent.MenstrualHistDtlBottomFrame.location.href="CAMenstrualHistDtlBottom.jsp?mode1=modify&patient_id="+patient_id+"&selectedValue="+selectedValue+"&scan_gestation="+scan_gestation+"&unsure_date="+unsure_date+"&redd_date="+redd+"&gestation_pog="+gestation_pog+"&unsure_delivery_miscarrage_type="+delivery_miscarrage_type+"&unsure_delivery_miscarrage_date="+delivery_miscarrage_date+"&remark_unsure="+encodeURIComponent(remarks)+"&option_id="+option_id+"&srl_no="+srl_no+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&called_form="+called_form+"&module_id="+module_id;
}



function openRemarksPopup(remarks,event_remarks,srl_no,patient_id){
	var dialogHeight= "10" ;
    var dialogWidth = "30" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var title="Remark";
	var arg = "";
	 window.showModalDialog("../../eCA/jsp/CAMenstrualRemark.jsp?remarks="+encodeURIComponent(remarks)+"&event_remarks="+event_remarks+"&srl_no="+srl_no+"&patient_id="+patient_id,arguments,features);	
}


function openRemarksAuditPopup(remarks,srl_no,patient_id){
	var dialogHeight= "10" ;
    var dialogWidth = "30" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var title="Remark";
	var arg = "";
	 window.showModalDialog("../../eCA/jsp/CAMenstrualRemark.jsp?remarks="+encodeURIComponent(remarks)+"&srl_no="+srl_no+"&patient_id="+patient_id,arguments,features);	
}


function openRemarksModifiedPopup(modifiedRemarks){
	var dialogHeight= "10" ;
    var dialogWidth = "30" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arg = "";
	 window.showModalDialog("../../eCA/jsp/CAMenstrualRemark.jsp?modifiedRemarks="+encodeURIComponent(modifiedRemarks),arguments,features);	
}





function checkForChanges() {
 	var cutOffDeliveryLmp = parseInt(document.getElementById('cutOffDeliveryLmp').value); // Convert to integer
  	 var delivery_miscarrage_type_value = document.getElementById('delivery_miscarrage_type_value').value;
  	 var delivery_miscarrage_date_value = document.getElementById('delivery_miscarrage_date_value').value;
  	 var exisiting_delivery_miscarrage_type_value = document.getElementById('exisiting_delivery_miscarrage_type_value').value;
  	 var exisiting_delivery_miscarrage_date_value = document.getElementById('exisiting_delivery_miscarrage_date_value').value;
	 var unsureDate =document.getElementById('unsureDate').value;
	 var selected_Values = document.getElementById('selected_Values').value;
	 var cutOffMiscarriageLmp = parseInt(document.getElementById('cutOffMiscarriageLmp').value); // Convert to integer

	  if (delivery_miscarrage_type_value === "D" && delivery_miscarrage_date_value !== "") {
	        var deliveryDateObj = parseDate(delivery_miscarrage_date_value); 
	        var unsureDateObj = parseDate(unsureDate);

	        // Check if LMP date is after delivery date
	        if (unsureDateObj.getTime() <= deliveryDateObj.getTime()) {
	            alert(getMessage("LMP_DATE_GREATER_SCAN_DELIVERY", "CA")); // Validation message
	            document.getElementById('unsureDate').value = ""; // Clear the LMP field
	            clearUnSuruField();
	            return; // Stop further execution
	        }
	    }

	    if (delivery_miscarrage_type_value === "M" && delivery_miscarrage_date_value !== "") {
	        var miscarriageDateObj = parseDate(delivery_miscarrage_date_value); 
	        var unsureDateObj = parseDate(unsureDate);

	        // Check if LMP date is after miscarriage date
	        if (unsureDateObj.getTime() <= miscarriageDateObj.getTime()) {
	            alert(getMessage("LMP_DATE_GREATER_SCAN_MISCARRIAGE", "CA")); // Validation message
	            document.getElementById('unsureDate').value = ""; // Clear the LMP field
	            clearUnSuruField();
	            return; // Stop further execution
	        }
	    }
	    
	    

    if (delivery_miscarrage_type_value === "D" && delivery_miscarrage_date_value !== "") {
     var deliveryDateObj = parseDate(delivery_miscarrage_date_value);
      var unsureDateObj = parseDate(unsureDate);

           // Calculate the minimum allowed date based on the cutoff period
       var minAllowedDate = new Date(deliveryDateObj);
       var cutoffDays = cutOffDeliveryLmp; // Use the dynamically provided cutoff value

       minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
           // Check if the LMP date is beyond the minimum allowed date
        if (unsureDateObj.getTime() <= minAllowedDate.getTime()) {
         alert(getMessage("LMP_DATE_CUTOFF_SCAN_DELIVERY", "CA")); // Validation message
          document.getElementById('unsureDate').value = ""; // Clear the LMP field
          clearUnSuruField(); // Clear related fields
            return; // Stop further execution
           }
       }
    

    if ( delivery_miscarrage_type_value === "M" && delivery_miscarrage_date_value !== "") {
     var deliveryDateObj = parseDate(delivery_miscarrage_date_value);
      var unsureDateObj = parseDate(unsureDate);

           // Calculate the minimum allowed date based on the cutoff period
       var minAllowedDate = new Date(deliveryDateObj);
       var cutoffDays = cutOffMiscarriageLmp; // Use the dynamically provided cutoff value

       minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
           // Check if the LMP date is beyond the minimum allowed date
        if (unsureDateObj.getTime() <= minAllowedDate.getTime()) {
         alert(getMessage("LMP_DATE_CUTOFF_SCAN_MISCARRAGE", "CA")); // Validation message
          document.getElementById('unsureDate').value = ""; // Clear the LMP field
          clearUnSuruField(); // Clear related fields
            return; // Stop further execution
           }
       }
    
    if (exisiting_delivery_miscarrage_type_value === "D" && exisiting_delivery_miscarrage_date_value !== "") {
        var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
        var unsureDateObj = parseDate(unsureDate);

        // Check if LMP date is after delivery date
        if (unsureDateObj.getTime() <= deliveryDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_SCAN_DELIVERY", "CA")); // Validation message
            document.getElementById('unsureDate').value = ""; // Clear the LMP field
            clearUnSuruField();
            return; // Stop further execution
        }
    }
    
    
    if (exisiting_delivery_miscarrage_type_value === "M" && exisiting_delivery_miscarrage_date_value !== "") {
        var miscarriageDateObj = parseDate(exisiting_delivery_miscarrage_date_value); 
        var unsureDateObj = parseDate(unsureDate);

        // Check if LMP date is after miscarriage date
        if (unsureDateObj.getTime() <= miscarriageDateObj.getTime()) {
            alert(getMessage("LMP_DATE_GREATER_SCAN_MISCARRIAGE", "CA")); // Validation message
            document.getElementById('unsureDate').value = ""; // Clear the LMP field
            clearUnSuruField();
            return; // Stop further execution
        }
    }
    
    if (exisiting_delivery_miscarrage_type_value === "D" && exisiting_delivery_miscarrage_date_value !== "") {
        var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value);
         var unsureDateObj = parseDate(unsureDate);

              // Calculate the minimum allowed date based on the cutoff period
          var minAllowedDate = new Date(deliveryDateObj);
          var cutoffDays = cutOffDeliveryLmp; // Use the dynamically provided cutoff value

          minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
              // Check if the LMP date is beyond the minimum allowed date
           if (unsureDateObj.getTime() <= minAllowedDate.getTime()) {
            alert(getMessage("LMP_DATE_CUTOFF_SCAN_DELIVERY", "CA")); // Validation message
             document.getElementById('unsureDate').value = ""; // Clear the LMP field
             clearUnSuruField(); // Clear related fields
               return; // Stop further execution
              }
          }
    
    
    if (exisiting_delivery_miscarrage_type_value === "D" && exisiting_delivery_miscarrage_date_value !== "") {
        var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value);
         var unsureDateObj = parseDate(unsureDate);

              // Calculate the minimum allowed date based on the cutoff period
          var minAllowedDate = new Date(deliveryDateObj);
          var cutoffDays = cutOffDeliveryLmp; // Use the dynamically provided cutoff value

          minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
              // Check if the LMP date is beyond the minimum allowed date
           if (unsureDateObj.getTime() <= minAllowedDate.getTime()) {
            alert(getMessage("LMP_DATE_CUTOFF_SCAN_DELIVERY", "CA")); // Validation message
             document.getElementById('unsureDate').value = ""; // Clear the LMP field
             clearUnSuruField(); // Clear related fields
               return; // Stop further execution
              }
          }
       

    if ( exisiting_delivery_miscarrage_type_value === "M" && exisiting_delivery_miscarrage_date_value !== "") {
     var deliveryDateObj = parseDate(exisiting_delivery_miscarrage_date_value);
      var unsureDateObj = parseDate(unsureDate);

           // Calculate the minimum allowed date based on the cutoff period
       var minAllowedDate = new Date(deliveryDateObj);
       var cutoffDays = cutOffMiscarriageLmp; // Use the dynamically provided cutoff value

       minAllowedDate.setDate(minAllowedDate.getDate() + cutoffDays); // Add cutoff days
           // Check if the LMP date is beyond the minimum allowed date
        if (unsureDateObj.getTime() <= minAllowedDate.getTime()) {
         alert(getMessage("LMP_DATE_CUTOFF_SCAN_MISCARRAGE", "CA")); // Validation message
          document.getElementById('unsureDate').value = ""; // Clear the LMP field
          clearUnSuruField(); // Clear related fields
            return; // Stop further execution
           }
       }
    
}

function apply1() {
	var called_form=document.getElementById('called_form').value
	var unsureDate = document.getElementById("unsureDate").value;
    var scanGestationWeeks = document.getElementById("scanGestationWeeks").value;
    var unsureDeliveryMiscarrageDate = document.getElementById("unsureDeliveryMiscarrageDate").value;
    var scanGestationDays = document.getElementById("scanGestationDays").value;
    var unsureDeliveryMiscarrageType = document.getElementById('unsureDeliveryMiscarrageType').value;
    var mode1 = document.getElementById('mode1').value;
    var previousRemarksUnsure = document.getElementById("pervious_remark_unsure").value;
    var previousScanGestationDays = document.getElementById('pervious_scan_gestation_days').value;
    var previousScanGestationWeeks = document.getElementById('pervious_scan_gestation_weeks').value;
    var remark_Unsure = document.getElementById('remarkUnsure').value;
    var gestationPogWeeks=document.getElementById('gestationPogWeeks').value
	var gestationPogDays=document.getElementById('gestationPogDays').value
	var redd=document.getElementById('redd').value

    // Validation checks
    
  	  
    if (scanGestationDays === "" && scanGestationWeeks !== "") {
        alert(getMessage("SCAN_GES_DAYS_BLANK", "CA"));
        return;         
    } else if (scanGestationWeeks === "" && scanGestationDays !== "") {
        alert(getMessage("SCAN_GES_WEEKS_BLANK", "CA"));
        return;
    } else if (scanGestationWeeks === "" && scanGestationDays === "") {
        alert(getMessage("SCAN_BLANK", "CA"));
        return;
    }

    // Continue with the rest of your logic here

    
    if (unsureDeliveryMiscarrageType !== "" && unsureDeliveryMiscarrageDate === "") {
        var msgref = getMessage("DILEVERY_MISCARRIAGE_BLANK", "CA");
        alert(msgref);
        return;
    }

    // Check if mode1 is "modify" and open the dialog
    var modifyRemark = "";
    if (mode1 === "modify" && (remark_Unsure !== previousRemarksUnsure || scanGestationDays !== previousScanGestationDays || scanGestationWeeks !== previousScanGestationWeeks)) {
        modifyRemark = openModifyRemarksPopUp();
        // If no remark is returned, stop the process
        if (!modifyRemark) {
            return; // Stop execution if no remark was provided
        }
    }

    
    // Enable disabled fields temporarily
    document.getElementById('unsureDate').disabled = false;
    document.getElementById('redd').disabled = false;
    document.getElementById('gestationPogWeeks').disabled = false;
    document.getElementById('gestationPogDays').disabled = false;

    // Set form action and submission parameters
    document.forms[0].action = "../../servlet/eCA.CAMenstrualHistTranscationDtlServlet?modifyRemark=" + encodeURIComponent(modifyRemark);
    document.MenstrualHistDtlBottomForm.target = "messageFrame";
    document.MenstrualHistDtlBottomForm.method = "post";
    document.MenstrualHistDtlBottomForm.submit();

    // Disable fields and close the window after a short delay to ensure form submission
        document.getElementById('unsureDate').disabled = true;
        document.getElementById('redd').disabled = true;
        document.getElementById('gestationPogWeeks').disabled = true;
        document.getElementById('gestationPogDays').disabled = true;
        
        if(called_form === "PAS_TRANSCATION_INVOKING"){
            /*parent.MenstrualHistDtlResultFrame.close();
            parent.MenstrualHistDtlTopFrame.close();
            parent.MenstrualHistDtlBottomFrame.close();*/
      		  window.returnValue = { lmpDate: unsureDate, gestationPoaWeek: gestationPogWeeks, gestationPoaDays: gestationPogDays, eddDate: redd, lmpDeliveryMiscarrageType: unsureDeliveryMiscarrageType, lmpDeliveryMiscarrageDate: unsureDeliveryMiscarrageDate };
      		        window.close(); // Close the modal dialog
      	}
  }

function openModifyRemarksPopUp() {
    var dialogTop = "450";
    var dialogHeight = "10";
    var dialogWidth = "30";
    var dialogStatus = "no";
    var arguments = "";

    var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; scroll=no; status=" + dialogStatus;
    // Show modal dialog and wait for return value
    var modifyRemark = window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlModifyRemarks.jsp", arguments, features);
    return modifyRemark; // Return the remark from the dialog
}

function onsubmitRemarks() {
    var modifyRemark = document.CAMenstrualHistDtlRemarksForm.modifyRemark.value;
    if (!modifyRemark) {
        alert(getMessage("MODIFIED_REMARKS_BLANK", "CA"));
        return false; // Prevent closing the dialog if no remark
    }

    // Close the dialog and return the remark
    window.returnValue = modifyRemark; // Set return value for confirmation
    window.close();
}




function openAuditTrailPopup(patient_id,selectedValue,srl_no)
{
	var dialogHeight= "10" ;
    var dialogWidth = "60" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arg = "";
	 window.showModalDialog("../../eCA/jsp/CAMenstrualHistTransAuditTrail.jsp?patient_id="+patient_id+"&selectedValue="+selectedValue+"&srl_no="+srl_no,arguments,features);	
}


function markAsErrorLMP(patient_id,selectedValue, srl_no) {	
	var called_form=document.getElementById('called_form').value

	var confirmation = confirm(getMessage("CONFRIMATION_ERROR", "CA"));
    if (confirmation) {
    	   var mode1 = "modifyEventStatus";
           var error_remarks="";
           if (mode1 === "modifyEventStatus") {
           	error_remarks = openErrorRemarksPopUp();
               // If no remark is returned, stop the process
               if (!error_remarks) {
                   return; // Stop execution if no remark was provided
               }
           }
     //   var mode1 = "modifyEventStatus"
       var encounter_id = document.CAMenstrualHistDtlResultForm.encounter_id.value;
       var episode_id = document.CAMenstrualHistDtlResultForm.episode_id.value;
      document.forms[0].action = "../../servlet/eCA.CAMenstrualHistTranscationDtlServlet?srl_no=" + srl_no +"&patient_id=" +patient_id +"&selectedValue=" + selectedValue+"&error_remarks=" + encodeURIComponent(error_remarks) +"&mode1=" + mode1+"&encounter_id=" + encounter_id +"&episode_id=" + episode_id;
      document.CAMenstrualHistDtlResultForm.target="messageFrame";
    	document.CAMenstrualHistDtlResultForm.method="post";
    	document.CAMenstrualHistDtlResultForm.submit();
    	
        if(called_form === "PAS_TRANSCATION_INVOKING"){
            /*parent.MenstrualHistDtlResultFrame.close();
            parent.MenstrualHistDtlTopFrame.close();
            parent.MenstrualHistDtlBottomFrame.close();*/
      		        window.returnValue = {
      		        		error_remarks: error_remarks
      		        };
      		        window.close(); // Close the modal dialog
      	}
    }
}


function markAsErrorUSOD(patient_id, selectedValue,srl_no) { 
	
	var called_form=document.getElementById('called_form').value

	 var confirmation = confirm(getMessage("CONFRIMATION_ERROR", "CA"));
    if (confirmation) {
 	   var mode1 = "modifyEventStatus";
       var error_remarks="";
       if (mode1 === "modifyEventStatus") {
       	error_remarks = openErrorRemarksPopUp();
           // If no remark is returned, stop the process
           if (!error_remarks) {
               return; // Stop execution if no remark was provided
           }
       }
       
       var encounter_id = document.CAMenstrualHistDtlResultForm.encounter_id.value;
       var episode_id = document.CAMenstrualHistDtlResultForm.episode_id.value;
       document.forms[0].action = "../../servlet/eCA.CAMenstrualHistTranscationDtlServlet?srl_no=" + srl_no +"&patient_id=" +patient_id +"&selectedValue=" + selectedValue +"&error_remarks=" + encodeURIComponent(error_remarks) +"&mode1=" + mode1+"&encounter_id=" + encounter_id +"&episode_id=" + episode_id;
    	document.CAMenstrualHistDtlResultForm.target="messageFrame";
    	document.CAMenstrualHistDtlResultForm.method="post";
    	document.CAMenstrualHistDtlResultForm.submit();
    	
    	
        if(called_form === "PAS_TRANSCATION_INVOKING"){
            /*parent.MenstrualHistDtlResultFrame.close();
            parent.MenstrualHistDtlTopFrame.close();
            parent.MenstrualHistDtlBottomFrame.close();*/
      		        window.returnValue = {
      		        		error_remarks: error_remarks
      		        };
      		        window.close(); // Close the modal dialog
      	}
    }
}


function openErrorRemarksPopUp() {
    var dialogTop = "450";
    var dialogHeight = "10";
    var dialogWidth = "30";
    var dialogStatus = "no";
    var arguments = "";

    var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; scroll=no; status=" + dialogStatus;
    
    // Show modal dialog and wait for return value
    var error_remarks = window.showModalDialog("../../eCA/jsp/CAMenstrualHistDtlErrorRemarks.jsp", arguments, features);
    
    return error_remarks; // Return the remark from the dialog
}



function onsubmitErrorRemarks() {
    var error_remarks = document.CAMenstrualHistDtlErrorRemarksForm.error_remarks.value;
    if (!error_remarks) {
    	  alert(getMessage("MARK_ERROR_REMARKS_BLANK", "CA"));
        return;
    }
    // Close the dialog and return the remark
    window.returnValue = error_remarks; // Set return value for confirmation
    window.close();
}


function onValidationErrorRemarks()
{
    var error_remarks = document.CAMenstrualHistDtlErrorRemarksForm.error_remarks.value;

	 if (error_remarks.length > 100) {
         alert(getMessage("MENS_ERR_REMARK_LIMIT","CA"));
         document.CAMenstrualHistDtlErrorRemarksForm.error_remarks.select();
         return;
     }	
}


function onValidationModifyRemarks()
{
	var modifyRemark = document.CAMenstrualHistDtlRemarksForm.modifyRemark.value;

	 if (modifyRemark.length > 100) {
       alert(getMessage("MENS_ERR_REMARK_LIMIT","CA"));
       document.CAMenstrualHistDtlRemarksForm.modifyRemark.select();
        return;
    }
}


function openErrorRemarksView(patient_id,srl_no) {
    var dialogHeight = "15";
    var dialogWidth = "30";
    var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + ";status=no";

    // Concatenate the parameters to the URL
    var url = "../../eCA/jsp/CAMenstrualErrorRemarkView.jsp?patient_id=" +patient_id +"&srl_no=" +srl_no;
    // Pass the URL with parameters to showModalDialog
    window.showModalDialog(url, arguments, features);
}


function markAsErrorRecord()
{
	
var called_form=document.getElementById('called_form').value
var patient_id =parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].patient_id.value;
var srl_no =parent.frames['MenstrualHistDtlBottomFrame'].document.forms['MenstrualHistDtlBottomForm'].srl_no.value;
	 var error_remarks="";
	 var mode1 = "modifyEventStatus1";
     if (mode1 === "modifyEventStatus1") {
     	error_remarks = openErrorRemarksPopUp();
         // If no remark is returned, stop the process
         if (!error_remarks) {
             return; // Stop execution if no remark was provided
         }
     }
//   var mode1 = "modifyEventStatus"

var  params = "&mode1=" + mode1+"&patient_id=" + patient_id+"&srl_no=" + srl_no+"&error_remarks="+encodeURIComponent(error_remarks);
  document.forms[0].action = "../../servlet/eCA.CAMenstrualHistTranscationDtlServlet?params=" +params;
	document.MenstrualHistDtlBottomForm.target="messageFrame";
	document.MenstrualHistDtlBottomForm.method="post";
	document.MenstrualHistDtlBottomForm.submit();
	
	
    if(called_form === "PAS_TRANSCATION_INVOKING"){
        /*parent.MenstrualHistDtlResultFrame.close();
        parent.MenstrualHistDtlTopFrame.close();
        parent.MenstrualHistDtlBottomFrame.close();*/
  		        window.returnValue = {
  		        		error_remarks: error_remarks
  		        };
  		        window.close(); // Close the modal dialog
  	}

}

