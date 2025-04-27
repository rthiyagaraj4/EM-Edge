// var to store a flag indicating whether user has pressed enter key
var keyActionInProgress = false;

// flag to store the page loading status
var pageLoadInProgress = false;

function showManageSpecimen(facilityId,facilityIdRequestKey,responsibilityId,
		respRequestKey,taskId,taskRequestKey){
	// this function launches the manage specimen functionality from CA module
	
	// first validate whether the caller responsibility has access to CA module
	// below code is for AJAX response handling
	var xmlHttp = getHttpObject();
	// AJAX call is synchronous 
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.cataskaccess.servlet.CATaskAccessServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = ''+facilityIdRequestKey+'='+facilityId;
	params += '&'+respRequestKey+'='+responsibilityId;
	params += '&'+taskRequestKey+'='+taskId;
	xmlHttp.send(params);
	
	// handle the AJAX response
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		 
		var errorMessage = '';
		var oprValidity = '';
		var accessCheckedPassed = true;
		// iterate through the json objects and get data
		for(count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			
			oprValidity = dataObj[count].taskAccessResult;
			if(oprValidity){
				oprValidity = trimText(oprValidity);
			}
			// if error message is filled, then show it
			// no need to get other data
			if((errorMessage.length > 0) && (oprValidity.length > 0)){
				// failure scenario - need to show an alert message
				alert(errorMessage);
				accessCheckedPassed = false;
				break;
			}
		}
		
		// accessing manage specimen is not possible - exit from function
		if(accessCheckedPassed == false){
			return;
		}
		
		// launch manage specimen page
		/*var URL = "../../eOR/jsp/SpecimenOrder.jsp";
		URL += "?p_called_from_ca=N&option_id=SPECIMEN_REGISTER_ORDER&show_message_frame=Y";*/
		
		var URL = "IPABMManageSpecimenWrapper.jsp";
		//var URL = "IPABMManageSpecimen.jsp";
		URL += "?p_called_from_ca=N&option_id=SPECIMEN_REGISTER_ORDER";
		
		//alert(URL);
		
		//alert(URL);
		var arguments   = "" ;
		var dialogHeight= "80" ;//"29"
		var dialogWidth	= "100" ;//"42"
		var dialogTop	= "70";
		var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";
		var retVal =    window.showModalDialog(URL,arguments,features);
	}
}


function getHttpObject(){
	// this function is used to form an xmlhttprequest object instance and return it
	// this object is used by the caller in an Ajax call
	// the formation is based on the window type
	var xmlHttp = new XMLHttpRequest();
	/*if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}*/
	
	return xmlHttp;
}

function patientSrchKeyAction(event,obj,facilityId){
	// this function is invoked when user presses a button during patient search
	// in turn calls the patientSearch() js function
	var x = event || window.event;
	var key = (x.keyCode || x.which);
	// this signifies enter key is pressed 
	// patient id is searched after user presses enter button
	if(key == 13 || key == 3){
		keyActionInProgress = true;
		if(validSplchars(obj)){
			patientSearch(obj,facilityId);	
		}
		
		keyActionInProgress = false;
	}
	return true;
}

function patientSrchBlurAction(obj,facilityId){
	// this function is for patient search functionality
	// is invoked on the onblur event
	// in turn calls the patientSearch() js function
	if(keyActionInProgress == true){
		return;
	}
	
	ChangeUpperCase(obj);
	if(validSplchars(obj)){
		patientSearch(obj,facilityId);	
	}
	
}


function patientSearch(obj,facilityId){
	// this function is for patient search functionality
	// takes the text field object, facility id as input
	
	// validate if the global variable is set with value
	// if not, it implies user has not selected a nursing unit at all
	// patient search cannot be done in this case
	if(!(selectedNursingUnit)){
		//alert('Cannot perform patient search-internal system error. Please select a nursing unit to load the floor plan view');
		return;
	}
	
	var tempSelectedNU = selectedNursingUnit;
	tempSelectedNU = trimText(tempSelectedNU);
	// this check is done in case when user has selected "select"
	// in the NU combo - in such a case, patient search should
	// not be invoked
	// the above should be done when patient search text field
	// is empty
	
	// patient id is obtained from obj
	var patId = '';
	if(obj){
		patId = obj.value;
		patId = trimText(patId);
	}
	// if below check passes, then no need to search patient
	if((tempSelectedNU.length == 0) && (patId.length == 0)){
		return;
	}
	
	
	// now comes the main processing part
	if(obj){
		if(patId.length == 0){
			// need to revert the border of the previous searched patient
			var roomNumComp = window.parent.adv_bed_mgmt.document.getElementById("roomNumInSearch");
			var roomNumVal = '';
			if(roomNumComp){
				roomNumVal = roomNumComp.value;
			}
			var bedNumComp = window.parent.adv_bed_mgmt.document.getElementById("bedNumInSearch");
			var bedNumVal = '';
			if(bedNumComp){
				bedNumVal = bedNumComp.value;
			}
			
			var oldRoomBedComb = roomNumVal + bedNumVal;
			/*var oldRoomBedDiv = window.parent.adv_bed_mgmt.document.getElementById(oldRoomBedComb);
			if(oldRoomBedDiv){
				//oldRoomBedDiv.style.border = "";
				oldRoomBedDiv.className = "bedWOHighlight";
				//alert('old bed is set with style');
			}*/
			
			// revert the style of the inner div first
			var oldBedInnerDiv = window.parent.adv_bed_mgmt.document.getElementById("innerDiv_"+oldRoomBedComb);
			if(oldBedInnerDiv){
				oldBedInnerDiv.className = "bedinnerdiv";
				oldBedInnerDiv.style.borderLeft = 'none';
				oldBedInnerDiv.style.borderRight = 'none';
			}
			
			// also need to change the style class for the <b> tags at the top and bottom
			// top <b> tags
			var oldBedTopBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("btopfirst_"+oldRoomBedComb);
			if(oldBedTopBFirstComp){
				oldBedTopBFirstComp.className = "bedtopone";
			}
			var oldBedTopBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("btopsecond_"+oldRoomBedComb);
			if(oldBedTopBSecondComp){
				oldBedTopBSecondComp.className = "bedtoptwo";
			}
			var oldBedTopBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("btopthird_"+oldRoomBedComb);
			if(oldBedTopBThirdComp){
				oldBedTopBThirdComp.className = "bedtopthree";
			}
			
			var oldBedTopBFourComp = window.parent.adv_bed_mgmt.document.getElementById("btopfour_"+oldRoomBedComb);
			if(oldBedTopBFourComp){
				oldBedTopBFourComp.className = "bedtopfour";
			}
			
			var oldBedTopBLastComp = window.parent.adv_bed_mgmt.document.getElementById("btoplast_"+oldRoomBedComb);
			if(oldBedTopBLastComp){
				oldBedTopBLastComp.className = "bedtopfive";
			}
			
			
			// bottom <b> tags
			var oldBedBottomBLastComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomlast_"+oldRoomBedComb);
			if(oldBedBottomBLastComp){
				oldBedBottomBLastComp.className = "bedbottomfive";
			}
			var oldBedBottomBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfirst_"+oldRoomBedComb);
			if(oldBedBottomBFirstComp){
				oldBedBottomBFirstComp.className = "bedbottomone";
			}
			var oldBedBottomBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomsecond_"+oldRoomBedComb);
			if(oldBedBottomBSecondComp){
				oldBedBottomBSecondComp.className = "bedbottomtwo";
			}
			var oldBedBottomBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomthird_"+oldRoomBedComb);
			if(oldBedBottomBThirdComp){
				oldBedBottomBThirdComp.className = "bedbottomthree";
			}
			
			var oldBedBottomBFourComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfour_"+oldRoomBedComb);
			if(oldBedBottomBFourComp){
				oldBedBottomBFourComp.className = "bedbottomfour";
			}
				
			// scroll the window to (0,0)
			var floorDiv = window.parent.adv_bed_mgmt.document.getElementById("floorWrapper");
			if(floorDiv){
				floorDiv.scrollTop = 0;
				floorDiv.scrollLeft = 0;
			}
			
			return;
		}
	}else{
		return;
	}
		
	// call the function which will actually perform the search	
	performPatientSearch(patId,facilityId);
}

function performPatientSearch(patId,facilityId){
	// this function performs the patient search functionality
	// takes the patient id and facility id as input
	// internally AJAX mechanism is used to get the bed number
	// and highlight an appropriate bed
	// this function is also designed keeping reuse in mind
	
	// below code is for AJAX response handling
	var xmlHttp = getHttpObject();
	
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.patientsearch.servlet.PatientSearchServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = 'patientId='+patId+'&facilityId='+facilityId;
	xmlHttp.send(params);
	
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		 
		var errorMessage = '';
		var patientId = '';
		var nursingUnitCode = '';
		var roomNum = '';
		var bedNum = '';
		//alert(objLength);
		// iterate through the json objects and get data
		for(count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			// if error message is filled, then show it
			// no need to get other data
			if(errorMessage.length > 0){
				// failure scenario - need to show an alert message
				alert(errorMessage);
				break;
			}
			// get other data
			patientId = dataObj[count].patientId;
			if(patientId){
				patientId = trimText(patientId);	
			}
			// just get the nursing unit code now - trim later
			nursingUnitCode = dataObj[count].nursingUnitCode;
			roomNum = dataObj[count].roomNumber;
			if(roomNum){
				roomNum = trimText(roomNum);
			}
			bedNum = dataObj[count].bedNumber;
			if(bedNum){
				bedNum = trimText(bedNum);
			}
		}
		
		// now there is a need to load the nursing unit code
		if(nursingUnitCode && (errorMessage.length == 0)){
			nursingUnitCode = trimText(nursingUnitCode);
			// patient's nursing unit is not the current one
			// so load the page
			var tempSelNU = selectedNursingUnit;
			tempSelNU = trimText(tempSelNU);
			if((tempSelNU.length == 0) || (selectedNursingUnit != nursingUnitCode)){
				//alert('selected nursing unit is different from obtained one '+selectedNursingUnit+' || '+nursingUnitCode);
				// need to iterate through the nursing unit combo and select the one which equals
				// the nursing unit
				parent.serachFrame.document.getElementById("nursing_unit").value = nursingUnitCode;
				// set the nursing unit value to global var
				selectedNursingUnit = nursingUnitCode;
				
				// there is a need to set extra parameters to bed mgmt main GUI 
				// along with nursing unit - the parameters to be set are
				// flag for patient search, patient id
				var bedMgmtURL = "../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+nursingUnitCode;
				//var bedMgmtURL = "../../eIP/jsp/IPAdvBedMgmtNew.jsp?nursingUnit="+nursingUnitCode;
				bedMgmtURL += "&patientSearch=Y&patientIdInSearch="+patientId;
				bedMgmtURL += "&roomNumInSearch="+roomNum+"&bedNumInSearch="+bedNum;
				//alert(bedMgmtURL);
				parent.adv_bed_mgmt.location.href=bedMgmtURL;
								
			}else{
				// need to revert the border of the previous searched patient
				// for this get the room number and the bed number
				// and search for the bed component based on room number and bed number
				// once the old bed is obtained, clear its style
				var roomNumComp = window.parent.adv_bed_mgmt.document.getElementById("roomNumInSearch");
				var roomNumVal = '';
				if(roomNumComp){
					roomNumVal = roomNumComp.value;
				}
				var bedNumComp = window.parent.adv_bed_mgmt.document.getElementById("bedNumInSearch");
				var bedNumVal = '';
				if(bedNumComp){
					bedNumVal = bedNumComp.value;
				}
				
				var oldRoomBedComb = roomNumVal + bedNumVal;
				oldRoomBedComb = trimText(oldRoomBedComb);
				if(oldRoomBedComb.length > 0){
					var oldRoomBedDiv = window.parent.adv_bed_mgmt.document.getElementById(oldRoomBedComb);
					if(oldRoomBedDiv){
						//oldRoomBedDiv.style.border = "";
						oldRoomBedDiv.className = "bedWOHighlight";
						
						/*oldRoomBedDiv.style.borderLeft = 'none';
						oldRoomBedDiv.style.borderRight = 'none';*/
						//alert('old bed is set with style');
					}
					
					// revert the style of the inner div first
					var oldBedInnerDiv = window.parent.adv_bed_mgmt.document.getElementById("innerDiv_"+oldRoomBedComb);
					if(oldBedInnerDiv){
						oldBedInnerDiv.className = "bedinnerdiv";
						
						oldBedInnerDiv.style.borderLeft = 'none';
						oldBedInnerDiv.style.borderRight = 'none';
					}
					
					// also need to change the style class for the <b> tags at the top and bottom
					// top <b> tags
					var oldBedTopBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("btopfirst_"+oldRoomBedComb);
					if(oldBedTopBFirstComp){
						oldBedTopBFirstComp.className = "bedtopone";
					}
					var oldBedTopBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("btopsecond_"+oldRoomBedComb);
					if(oldBedTopBSecondComp){
						oldBedTopBSecondComp.className = "bedtoptwo";
					}
					var oldBedTopBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("btopthird_"+oldRoomBedComb);
					if(oldBedTopBThirdComp){
						oldBedTopBThirdComp.className = "bedtopthree";
					}
					var oldBedTopBFourComp = window.parent.adv_bed_mgmt.document.getElementById("btopfour_"+oldRoomBedComb);
					if(oldBedTopBFourComp){
						oldBedTopBFourComp.className = "bedtopfour";
					}
					var oldBedTopBLastComp = window.parent.adv_bed_mgmt.document.getElementById("btoplast_"+oldRoomBedComb);
					if(oldBedTopBLastComp){
						oldBedTopBLastComp.className = "bedtopfive";
					}
					
					// bottom <b> tags
					var oldBedBottomBLastComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomlast_"+oldRoomBedComb);
					if(oldBedBottomBLastComp){
						oldBedBottomBLastComp.className = "bedbottomfive";
					}
					var oldBedBottomBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfirst_"+oldRoomBedComb);
					if(oldBedBottomBFirstComp){
						oldBedBottomBFirstComp.className = "bedbottomone";
					}
					var oldBedBottomBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomsecond_"+oldRoomBedComb);
					if(oldBedBottomBSecondComp){
						oldBedBottomBSecondComp.className = "bedbottomtwo";
					}
					var oldBedBottomBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomthird_"+oldRoomBedComb);
					if(oldBedBottomBThirdComp){
						oldBedBottomBThirdComp.className = "bedbottomthree";
					}
					
					var oldBedBottomBFourComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfour_"+oldRoomBedComb);
					if(oldBedBottomBFourComp){
						oldBedBottomBFourComp.className = "bedbottomfour";
					}
				}
				
				// there is also a need to reset the patient id stored
				// as a hidden var
				var patIdInSrchComp = window.parent.adv_bed_mgmt.document.getElementById("patientIdInSearch");
				if(patIdInSrchComp){
					patIdInSrchComp.value = patientId;
				}
				
				// there is a need to set the patient search YN hidden parameter
				// with value "Y"
				var patSrchYNComp = window.parent.adv_bed_mgmt.document.getElementById("patientSearch");
				if(patSrchYNComp){
					patSrchYNComp.value = 'Y';
				}
				
				// now code to set the bed where the current searched patient
				// with highlight style
				var roomBedComb = roomNum + bedNum;
				// change the style of the inner div
				var newBedInnerDiv = window.parent.adv_bed_mgmt.document.getElementById("innerDiv_"+roomBedComb);
				if(newBedInnerDiv){
					newBedInnerDiv.style.borderLeft = 'none';
					newBedInnerDiv.style.borderRight = 'none';
					//newBedInnerDiv.className = "bedhighlightinnerdiv";
					newBedInnerDiv.style.borderLeft = '2px solid #000000';
					newBedInnerDiv.style.borderRight = '2px solid #000000';
				}
				
				// also need to change the style class for the <b> tags at the top and bottom
				var newBedTopBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("btopfirst_"+roomBedComb);
				if(newBedTopBFirstComp){
					newBedTopBFirstComp.className = "bedhighlighttopone";
				}
				var newBedTopBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("btopsecond_"+roomBedComb);
				if(newBedTopBSecondComp){
					newBedTopBSecondComp.className = "bedhighlighttoptwo";
				}
				var newBedTopBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("btopthird_"+roomBedComb);
				if(newBedTopBThirdComp){
					newBedTopBThirdComp.className = "bedhighlighttopthree";
				}
				
				var newBedTopBFourthComp = window.parent.adv_bed_mgmt.document.getElementById("btopfour_"+roomBedComb);
				if(newBedTopBFourthComp){
					newBedTopBFourthComp.className = "bedhighlighttopfour";
				}
				
				var newBedTopBLastComp = window.parent.adv_bed_mgmt.document.getElementById("btoplast_"+roomBedComb);
				if(newBedTopBLastComp){
					newBedTopBLastComp.className = "bedhighlighttopfive";
				}
				
				var newBedBottomBLastComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomlast_"+roomBedComb);
				if(newBedBottomBLastComp){
					newBedBottomBLastComp.className = "bedhighlightbottomfive";
				} 
				var newBedBottomBFirstComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfirst_"+roomBedComb);
				if(newBedBottomBFirstComp){
					newBedBottomBFirstComp.className = "bedhighlightbottomone";
				}
				var newBedBottomBSecondComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomsecond_"+roomBedComb);
				if(newBedBottomBSecondComp){
					newBedBottomBSecondComp.className = "bedhighlightbottomtwo";
				}
				var newBedBottomBThirdComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomthird_"+roomBedComb);
				if(newBedBottomBThirdComp){
					newBedBottomBThirdComp.className = "bedhighlightbottomthree";
				}
				
				var newBedBottomBFourComp = window.parent.adv_bed_mgmt.document.getElementById("bbottomfour_"+roomBedComb);
				if(newBedBottomBFourComp){
					newBedBottomBFourComp.className = "bedhighlightbottomfour";
				}
				
				// now there is a need to reset the old room and bed number components
				if(roomNumComp){
					roomNumComp.value = roomNum;
				}
				if(bedNumComp){
					bedNumComp.value = bedNum;
				}
				
				// need to scroll the window to the appropriate location
				scrollToSearchedPatient();
			}
		}else{
			// when code comes here - the patient being searched is not valid
			// if there is a previous successful patient search 
			// then the high lighted bed should be made normal
			// need to revert the border of the previous searched patient
			var roomNumComp2 = window.parent.adv_bed_mgmt.document.getElementById("roomNumInSearch");
			var roomNumVal2 = '';
			if(roomNumComp2){
				roomNumVal2 = roomNumComp2.value;
			}
			var bedNumComp2 = window.parent.adv_bed_mgmt.document.getElementById("bedNumInSearch");
			var bedNumVal2 = '';
			if(bedNumComp2){
				bedNumVal2 = bedNumComp2.value;
			}
			// check and reset the styles of previously searched patient
			if(roomNumVal2.length > 0 && bedNumVal2.length > 0){
				var oldRoomBedComb2 = roomNumVal2 + bedNumVal2;
				
				// revert the style of the inner div first
				var oldBedInnerDiv2 = window.parent.adv_bed_mgmt.document.getElementById("innerDiv_"+oldRoomBedComb2);
				if(oldBedInnerDiv2){
					oldBedInnerDiv2.className = "bedinnerdiv";
					oldBedInnerDiv2.style.borderLeft = 'none';
					oldBedInnerDiv2.style.borderRight = 'none';
				}
				
				// also need to change the style class for the <b> tags at the top and bottom
				// top <b> tags
				var oldBedTopBFirstComp2 = window.parent.adv_bed_mgmt.document.getElementById("btopfirst_"+oldRoomBedComb2);
				if(oldBedTopBFirstComp2){
					oldBedTopBFirstComp2.className = "bedtopone";
				}
				var oldBedTopBSecondComp2 = window.parent.adv_bed_mgmt.document.getElementById("btopsecond_"+oldRoomBedComb2);
				if(oldBedTopBSecondComp2){
					oldBedTopBSecondComp2.className = "bedtoptwo";
				}
				var oldBedTopBThirdComp2 = window.parent.adv_bed_mgmt.document.getElementById("btopthird_"+oldRoomBedComb2);
				if(oldBedTopBThirdComp2){
					oldBedTopBThirdComp2.className = "bedtopthree";
				}
				var oldBedTopBFourComp2 = window.parent.adv_bed_mgmt.document.getElementById("btopfour_"+oldRoomBedComb2);
				if(oldBedTopBFourComp2){
					oldBedTopBFourComp2.className = "bedtopfour";
				}
				
				var oldBedTopBLastComp2 = window.parent.adv_bed_mgmt.document.getElementById("btoplast_"+oldRoomBedComb2);
				if(oldBedTopBLastComp2){
					oldBedTopBLastComp2.className = "bedtopfive";
				}
				
				
				// bottom <b> tags
				var oldBedBottomBLastComp2 = window.parent.adv_bed_mgmt.document.getElementById("bbottomlast_"+oldRoomBedComb2);
				if(oldBedBottomBLastComp2){
					oldBedBottomBLastComp2.className = "bedbottomfive";
				}
				var oldBedBottomBFirstComp2 = window.parent.adv_bed_mgmt.document.getElementById("bbottomfirst_"+oldRoomBedComb2);
				if(oldBedBottomBFirstComp2){
					oldBedBottomBFirstComp2.className = "bedbottomone";
				}
				var oldBedBottomBSecondComp2 = window.parent.adv_bed_mgmt.document.getElementById("bbottomsecond_"+oldRoomBedComb2);
				if(oldBedBottomBSecondComp2){
					oldBedBottomBSecondComp2.className = "bedbottomtwo";
				}
				var oldBedBottomBThirdComp2 = window.parent.adv_bed_mgmt.document.getElementById("bbottomthird_"+oldRoomBedComb2);
				if(oldBedBottomBThirdComp2){
					oldBedBottomBThirdComp2.className = "bedbottomthree";
				}
				var oldBedBottomBFourComp2 = window.parent.adv_bed_mgmt.document.getElementById("bbottomfour_"+oldRoomBedComb2);
				if(oldBedBottomBFourComp2){
					oldBedBottomBFourComp2.className = "bedbottomfour";
				}
			}
			
		}
			
	}
	
}

function scrollToSearchedPatient(){
	// this function scrolls the bed management page to the bed where
	// the currently searched patient is present
	
	// need to revert the border of the previous searched patient
	var roomNumComp = window.parent.adv_bed_mgmt.document.getElementById("roomNumInSearch");
	var roomNumVal = '';
	if(roomNumComp){
		roomNumVal = roomNumComp.value;
		roomNumVal = trimText(roomNumVal);
	}
	var bedNumComp = window.parent.adv_bed_mgmt.document.getElementById("bedNumInSearch");
	var bedNumVal = '';
	if(bedNumComp){
		bedNumVal = bedNumComp.value;
		bedNumVal = trimText(bedNumVal);
	}
	
	// now set the border style of the bed where
	// searched patient is located
	if(roomNumVal.length > 0 && bedNumVal.length > 0){
		var roomBedComb = roomNumVal + bedNumVal;
		var bedDiv = window.parent.adv_bed_mgmt.document.getElementById(roomBedComb);
		var roomDiv = window.parent.adv_bed_mgmt.document.getElementById(roomNumVal);
		if(bedDiv && roomDiv){
			var w=window.innerWidth
			||  window.parent.adv_bed_mgmt.document.documentElement.clientWidth
			||  window.parent.adv_bed_mgmt.document.body.clientWidth;
			var h=window.innerHeight
			||  window.parent.adv_bed_mgmt.document.documentElement.clientHeight
			||  window.parent.adv_bed_mgmt.document.body.clientHeight;
			//alert(bedDiv.style.top+' || '+bedDiv.style.left+' || '+bedDiv.style.width+' || '+bedDiv.style.height+' || window width='+w+' || window height='+h+' || '+roomDiv.style.top+' || '+roomDiv.style.left+' || '+roomDiv.style.height+' || '+roomDiv.style.width);
			var bedTopStr = bedDiv.style.top;
			var bedLeftStr = bedDiv.style.left;
			var bedWidthStr = bedDiv.style.width;
			var bedHeightStr = bedDiv.style.height;
			var roomTopStr = roomDiv.style.top;
			var roomLeftStr = roomDiv.style.left;
			var roomWidthStr = roomDiv.style.width;
			var roomHeightStr = roomDiv.style.height;
			//alert(bedTopStr+'||'+bedLeftStr+'||'+bedWidthStr+'||'+bedHeightStr+'||'+roomTopStr+'||'+roomLeftStr+'||'+roomWidthStr+'||'+roomHeightStr);
			
			var bedTop = stringToNumber(bedTopStr);
			var bedLeft = stringToNumber(bedLeftStr);
			var bedWidth = stringToNumber(bedWidthStr);
			var bedHeight = stringToNumber(bedHeightStr);
			var roomTop = stringToNumber(roomTopStr);
			var roomLeft = stringToNumber(roomLeftStr);
			var roomWidth = stringToNumber(roomWidthStr);
			var roomHeight = stringToNumber(roomHeightStr);
			
			var xposition = 0;
			var yposition = 0;
			if((roomLeft + bedLeft + bedWidth) > w ){
				xposition = roomLeft + bedLeft; 
			}
			if((roomTop + bedTop + bedHeight) > h){
				yposition = roomTop + bedTop;
			}
			
			// this code will enable the scrolling
			setTimeout(function(){
				var floorDiv = window.parent.adv_bed_mgmt.document.getElementById("floorWrapper");
				if(floorDiv){
					//alert('before scroll');
					floorDiv.scrollTop = yposition;
					floorDiv.scrollLeft = xposition;
				}
			},1);
		}
	}
	
	
}

function stringToNumber(strVal){
	// this function converts a string to an integer value
	var numVal = 0;
	try{
		numVal = parseInt(strVal);
	}catch(err){
		numVal = 0;
	}
	
	return numVal;
}

function patientSearchOnMainPageRefresh(patId,facilityId){
	// this function handles the patient search when bed management main
	// GUI is refreshed - at this time, there is a need to get the nursing
	// unit to which searched patient belongs	
	
	var nuCode = '';
	
	// below code is for AJAX response handling
	var xmlHttp = getHttpObject();
	
	
	// AJAX call is synchronous 
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.patientsearch.servlet.PatientSearchServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = 'patientId='+patId+'&facilityId='+facilityId;
	xmlHttp.send(params);
	
	// handle the AJAX response
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		 
		var errorMessage = '';
		var nursingUnitCode = '';
		 			
		// iterate through the json objects and get data
		for(count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			// if error message is filled, then show it
			// no need to get other data
			if(errorMessage.length > 0){
				// failure scenario - need to show an alert message
				// alert(errorMessage);
				break;
			}
			
			// just get the nursing unit code now - trim later
			nursingUnitCode = dataObj[count].nursingUnitCode;
			if(nursingUnitCode){
				nursingUnitCode = trimText(nursingUnitCode);
				nuCode = nursingUnitCode;
			}
		}
	}
	
	return nuCode;
}




function trimText(textVal){
	// this function trims the input text
	var tempVal = textVal;
	tempVal = tempVal.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,'').replace(/\s+/g,' ');
  	 return tempVal;
}

function hotStateImage(obj)
{
	obj.className = 'imageClass2';
}

function restorePrevState(obj)
{
	obj.className = 'imageClass1';
}

function loadMainPageInSteps(){
	// this function will load the GBM main page
	// in steps
	
	pageLoadInProgress = true;
	// first mask the different frames
	maskCriteriaFrame();
	//maskBedsFrame();
	//showMessageInStatusFrame(1,'Page is loading...');
	
	// there is a need to validate if the nursing unit is configured
	// this can be done by checking the bed count
	// a nursing unit is configured if it has at least 1 bed
	var totalBedsCntComp = window.parent.adv_bed_mgmt.document.getElementById("totalBedCount");
	var totalBedsCntStr = '';
	var totalBedsCnt = 0;
	if(totalBedsCntComp){
		totalBedsCntStr = totalBedsCntComp.value;
		if(totalBedsCntStr.length > 0){
			totalBedsCnt = stringToNumber(totalBedsCntStr);	
		}
		
		if(totalBedsCnt == 0){
			showOriginalStatusFrame();
			pageLoadInProgress = false;
			unmaskCriteriaFrame();
			return;
		}
	}
	
	// second call the functions which will fetch data from backend
	// bed status first
	var statusRetVal = getBedStatus();
	
	var iconRetVal = 0;
	if(statusRetVal == 1){
		// bed icon section status
		iconRetVal = getBedIconSectionStatus();		
	}

	// show the legend frame
	if((statusRetVal == 1) && (iconRetVal == 1)){
		showOriginalStatusFrame();	
	}
	
	// last unmask the different frames
	unmaskCriteriaFrame();
	
	pageLoadInProgress = false;
}


function maskCriteriaFrame(){
	// this function masks the criteria frame components
	
	/*var criteriaMaskDiv = window.parent.serachFrame.document.getElementById("criteriaMaskDiv");
	if(criteriaMaskDiv){
		criteriaMaskDiv.className = "showmaskstyle";
		alert('mask style set');
	}*/
	
	var nursingUnitCombo = window.parent.serachFrame.document.getElementById("nursingunitcombo");
	if(nursingUnitCombo){
		nursingUnitCombo.disabled = true;
	}
	
	var patientIdText = window.parent.serachFrame.document.getElementById("patient_id");
	if(patientIdText){
		patientIdText.disabled = true;
	}
	
	var patientSrchButton = window.parent.serachFrame.document.getElementById("patient_search");
	if(patientSrchButton){
		patientSrchButton.disabled = true;
	}
	
}


function unmaskCriteriaFrame(){
	var nursingUnitCombo = window.parent.serachFrame.document.getElementById("nursingunitcombo");
	if(nursingUnitCombo){
		nursingUnitCombo.disabled = false;
	}
	
	var patientIdText = window.parent.serachFrame.document.getElementById("patient_id");
	if(patientIdText){
		patientIdText.disabled = false;
	}
	
	var patientSrchButton = window.parent.serachFrame.document.getElementById("patient_search");
	if(patientSrchButton){
		patientSrchButton.disabled = false;
	}
}

function showMessageInStatusFrame(messageType,message){
	// this function shows a message in the message panel
	// in the main GUI
	// message type = 1 -> information message
	// message type = 2 -> error message
	var param = '';
	if(messageType == 1){
		param = 'infoMessage=';
	}else if(messageType == 2){
		param = 'errorMessage=';
	}
	
	//param += '&';
	param += message;
	
	var url = '../../eIP/jsp/IPAdvBedMgmtMessagePanel.jsp?'+param;
	//var panel = window.parent.status
	window.parent.legendFrame.location.href=url;
}

function showOriginalStatusFrame(){
	// this function shows the original status frame
	/*var url = '../../eIP/jsp/IPAdvBedMgmtColorSchema.jsp';*/
	var url = '../../eIP/jsp/IPAdvBedMgmtLegendPanel.jsp';
	window.parent.legendFrame.location.href=url;
}



function getBedStatus(){
	// this function gets the bed statuses 
	
	// first get nursing unit value
	var tempNU = '';
	var nursingUnitCombo = window.parent.serachFrame.document.getElementById("nursingunitcombo");
	if(nursingUnitCombo){
		tempNU = nursingUnitCombo.value;
		tempNU = trimText(tempNU);
		//alert(tempNU);
	}
	/*if(selectedNursingUnit){
		tempNU = selectedNursingUnit;
		tempNU = trimText(tempNU);
		alert(tempNU);
	}*/
	
	// get facility id
	var facilityIdComp = window.parent.adv_bed_mgmt.document.getElementById("facility_id");
	var facilityId = '';
	if(facilityIdComp){
		facilityId = facilityIdComp.value;
	}
	
	// get total bed count
	var totalBedCntComp = window.parent.adv_bed_mgmt.document.getElementById("totalBedCount");
	var totalBedCntStr = '0';
	if(totalBedCntComp){
		totalBedCntStr = totalBedCntComp.value; 
	}
	
	// need to call servlet through AJAX with synchronous mode
	var xmlHttp = getHttpObject();
	// AJAX call is synchronous 
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.floorlayout.servlet.BedStatusServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = 'facility_id'+'='+facilityId;
	params += '&nursingUnitCode='+tempNU;
	params += '&bedCount='+totalBedCntStr;
	xmlHttp.send(params);

	var errorMessage = '';
	// handle the AJAX response
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		//alert('in here');
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		 
		// safe approach
		if(objLength == 0){
			errorMessage = 'Could not retrieve complete bed information.';
			showMessageInStatusFrame(2,errorMessage);
			return 0;	
		}
		
		var nursingUnitCode = '';
		
		var roomNum = '';
		var bedNum = '';
		var bColor = '';
		var bedTxtColor	= '';//Added By Dharma on 16th Mar 2016
		
		// iterate through the json objects and get data
		for(count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			
			// if error message is filled, then show it
			// no need to get other data
			if(errorMessage.length > 0){
				// this can be done by loading error JSP at legend panel 
				showMessageInStatusFrame(2,errorMessage);
				return 0;
				//break;
			}
			
			// reset the values
			roomNum = '';
			bedNum = '';
			bColor = '';
			bedTxtColor	= '';//Added By Dharma on 16th Mar 2016
			roomNum = dataObj[count].roomNumber;
			if(roomNum){
				roomNum = trimText(roomNum);
			}
			
			bedNum = dataObj[count].bedNumber;
			if(bedNum){
				bedNum = trimText(bedNum);
			}
			
			bColor = dataObj[count].bedColor;
			if(bColor){
				bColor = trimText(bColor);
			}
			//Added By Dharma on 16th Mar 2016 Start
			bedTxtColor = dataObj[count].bedTxtColor;
			if(bedTxtColor){
				bedTxtColor = trimText(bedTxtColor);
			}
			//Added By Dharma on 16th Mar 2016 End
			// set the background color of the main bed div
			var bedDivEle = window.parent.adv_bed_mgmt.document.getElementById('innerDiv_'+roomNum+bedNum);
			if(bedDivEle){
				bedDivEle.style.backgroundColor = '#'+bColor;
				bedDivEle.style.color = '#'+bedTxtColor;//Added By Dharma on 16th Mar 2016
				bedDivEle.style.borderLeft = '1px solid #'+bColor;
				bedDivEle.style.borderRight = '1px solid #'+bColor;
				//alert('set the bed div style');
			}
			
			// now the bed top and bottom crumbs
			var bTopFirstEle = window.parent.adv_bed_mgmt.document.getElementById('btopfirst_'+(roomNum+bedNum));
			if(bTopFirstEle){
				bTopFirstEle.style.backgroundColor = '#'+bColor;
			}
			var bTopSecEle = window.parent.adv_bed_mgmt.document.getElementById('btopsecond_'+(roomNum+bedNum));
			if(bTopSecEle){
				bTopSecEle.style.backgroundColor = '#'+bColor;
			} 
			var bTopThirdEle = window.parent.adv_bed_mgmt.document.getElementById('btopthird_'+(roomNum+bedNum));
			if(bTopThirdEle){
				bTopThirdEle.style.backgroundColor = '#'+bColor;
			}
			var bTopFourEle = window.parent.adv_bed_mgmt.document.getElementById('btopfour_'+(roomNum+bedNum));
			if(bTopFourEle){
				bTopFourEle.style.backgroundColor = '#'+bColor;
			}
			var bTopLastEle = window.parent.adv_bed_mgmt.document.getElementById('btoplast_'+(roomNum+bedNum));
			if(bTopLastEle){
				bTopLastEle.style.backgroundColor = '#'+bColor;
			}
			
			var bBottomFirstEle = window.parent.adv_bed_mgmt.document.getElementById('bbottomfirst_'+(roomNum+bedNum));
			if(bBottomFirstEle){
				bBottomFirstEle.style.backgroundColor = '#'+bColor;
			}
			var bBottomSecEle = window.parent.adv_bed_mgmt.document.getElementById('bbottomsecond_'+(roomNum+bedNum));
			if(bBottomSecEle){
				bBottomSecEle.style.backgroundColor = '#'+bColor;
			}
			var bBottomThirdEle = window.parent.adv_bed_mgmt.document.getElementById('bbottomthird_'+(roomNum+bedNum));
			if(bBottomThirdEle){
				bBottomThirdEle.style.backgroundColor = '#'+bColor;
			}
			var bBottomFourEle = window.parent.adv_bed_mgmt.document.getElementById('bbottomfour_'+(roomNum+bedNum));
			if(bBottomFourEle){
				bBottomFourEle.style.backgroundColor = '#'+bColor;
			}
			var bBottomLastEle = window.parent.adv_bed_mgmt.document.getElementById('bbottomlast_'+(roomNum+bedNum));
			if(bBottomLastEle){
				bBottomLastEle.style.backgroundColor = '#'+bColor;
			}
			
		}
		
		return 1;
		
		//alert('set the status of all beds');
	}else{
		// hard coding error message for testing purpose
		errorMessage = 'Could not retrieve complete bed information.';
		showMessageInStatusFrame(2,errorMessage);
		return 0;
	}
	
}

function getBedIconSectionStatus(){
	// this function gets the bed icon section status
	
	// first get nursing unit value
	var tempNU = '';
	var nursingUnitCombo = window.parent.serachFrame.document.getElementById("nursingunitcombo");
	if(nursingUnitCombo){
		tempNU = nursingUnitCombo.value;
		tempNU = trimText(tempNU);
	}
	
	// get facility id
	var facilityIdComp = window.parent.adv_bed_mgmt.document.getElementById("facility_id");
	var facilityId = '';
	if(facilityIdComp){
		facilityId = facilityIdComp.value;
	}
	
	// need to call servlet through AJAX
	var xmlHttp = getHttpObject();
	// AJAX call is synchronous 
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.floorlayout.servlet.BedIconSectionServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = 'facility_id'+'='+facilityId;
	params += '&nursingUnitCode='+tempNU;
	xmlHttp.send(params);
	
	var errorMessage = '';
	// handle the AJAX response
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		
		//alert(responseText);
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		//alert('in here');
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		
		// safe approach
		if(objLength == 0){
			errorMessage = 'Could not retrieve complete bed information.';
			showMessageInStatusFrame(2,errorMessage);
			return 0;	
		}
		
		var nursingUnitCode = '';
		
		var roomNum = '';
		var bedNum = '';
		var encId = '';
		var kAllergy = '';
		var bExists = '';
		var futBookStr = '';
		var futBook = 0;
		var medOverDueStr = '';
		var medOverDue = 0;
		var abnormalResStr = '';
		var abnormalRes = 0;
		var pubResStr = '';
		var pubRes = 0;
		var ordersStr = '';
		var orders = 0;
		
		//alert(objLength);
		
		// iterate through the json objects and get data
		for(count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			
			// if error message is filled, then show it
			// no need to get other data
			if(errorMessage.length > 0){
				// this can be done by loading error JSP instead of legend panel
				showMessageInStatusFrame(2,errorMessage);
				return 0;
				break;
			}
			
			// reset the values
			roomNum = '';
			bedNum = '';
			encId = '';
			kAllergy = '';
			bExists = '';
			futBookStr = '';
			futBook = 0;
			medOverDueStr = '';
			medOverDue = 0;
			abnormalResStr = '';
			abnormalRes = 0;
			pubResStr = '';
			pubRes = 0;
			ordersStr = '';
			orders = 0;
			
			roomNum = dataObj[count].roomNumber;
			if(roomNum){
				roomNum = trimText(roomNum);
			}
			
			bedNum = dataObj[count].bedNumber;
			if(bedNum){
				bedNum = trimText(bedNum);
			}
			
			encId = dataObj[count].encounterId;
			// get the different icon section data
			// known allergy
			kAllergy = dataObj[count].knownAllergy;
			if(kAllergy){
				kAllergy = trimText(kAllergy);
				if((kAllergy == 'Y') || (kAllergy == 'y')){
					 var kAllergyIcon = window.parent.adv_bed_mgmt.document.getElementById('kAllergy_'+(roomNum+bedNum));
					 if(kAllergyIcon){
						 kAllergyIcon.style.visibility = '';
					 }
				}
			}
			
			// bill exists
			bExists = dataObj[count].billExists;
			if(bExists){
				bExists = trimText(bExists);
				// value 'Y' or 'y' is to be checked
				if((bExists == 'Y') || (bExists == 'y')){
					 var bExistsIcon = window.parent.adv_bed_mgmt.document.getElementById('bExists_'+(roomNum+bedNum));
					 if(bExistsIcon){
						 bExistsIcon.style.visibility = '';
					 }
				}
			}
			// future bookings 
			futBookStr = dataObj[count].futureBookingCnt;
			if(futBookStr){
				//futBookStr = trimText(futBookStr);
				futBook = stringToNumber(futBookStr);
				if(futBook > 0){
					var fbookIcon = window.parent.adv_bed_mgmt.document.getElementById('fbook_'+(roomNum+bedNum));
					 if(fbookIcon){
						 fbookIcon.style.visibility = '';
					 }
				}
			}
			// now it is combination of icons
			medOverDueStr = dataObj[count].medOverDueCnt;
			if(medOverDueStr){
				//medOverDueStr = trimText(medOverDueStr);
				medOverDue = stringToNumber(medOverDueStr);
			}
			abnormalResStr = dataObj[count].abnormalResultsCnt;
			if(abnormalResStr){
				//abnormalResStr = trimText(abnormalResStr);
				abnormalRes = stringToNumber(abnormalResStr);
			}
			pubResStr = dataObj[count].pubResultsCnt;
			if(pubResStr){
				//pubResStr = trimText(pubResStr);
				pubRes = stringToNumber(pubResStr);
			}
			
			// for test purpose - should be deleted after testing
			/*var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
			if(aux1Comp){
				aux1Comp.className = "ipicon";
				var img = document.createElement("IMG");
			    img.src = "../../eIP/images/mod_abresults_pubresults.png";
			    aux1Comp.appendChild(img);
			}*/
			
			// now compute the different auxillary icons
			// this is done as a combination
			if((medOverDue > 0) && (abnormalRes > 0 ) && (pubRes > 0)){
				var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
				if(aux1Comp){
					aux1Comp.className = "ipicon";
					var img = document.createElement("IMG");
				    img.src = "../../eIP/images/mod_abresults_pubresults.png";
				    aux1Comp.appendChild(img);
				}
			}else{
				if((medOverDue > 0) && (abnormalRes > 0 )){
					var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
					if(aux1Comp){
						aux1Comp.className = "ipicon";
						var img = document.createElement("IMG");
					    img.src = "../../eIP/images/mod_abresults.png";
					    aux1Comp.appendChild(img);
					}
				}else if((medOverDue > 0) && (pubRes > 0)){
					var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
					if(aux1Comp){
						aux1Comp.className = "ipicon";
						var img = document.createElement("IMG");
					    img.src = "../../eIP/images/mod_pubresults.png";
					    aux1Comp.appendChild(img);
					}
				}else if((abnormalRes > 0 ) && (pubRes > 0)){
					var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
					if(aux1Comp){
						aux1Comp.className = "ipicon";
						var img = document.createElement("IMG");
					    img.src = "../../eIP/images/abresults_pubresults.png";
					    aux1Comp.appendChild(img);
					}
				}else{
					// now individual status
					if(medOverDue > 0){
						var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
						if(aux1Comp){
							aux1Comp.className = "ipicon";
							var img = document.createElement("IMG");
						    img.src = "../../eIP/images/mod.png";
						    aux1Comp.appendChild(img);
						}
					}
					if(abnormalRes > 0 ){
						var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
						if(aux1Comp){
							aux1Comp.className = "ipicon";
							var img = document.createElement("IMG");
						    img.src = "../../eIP/images/abresults.png";
						    aux1Comp.appendChild(img);
						}
					}
					if(pubRes > 0){
						var aux1Comp = window.parent.adv_bed_mgmt.document.getElementById('aux1_'+(roomNum+bedNum));
						if(aux1Comp){
							aux1Comp.className = "ipicon";
							var img = document.createElement("IMG");
						    img.src = "../../eIP/images/pubresults.png";
						    aux1Comp.appendChild(img);
						}
					}
				}
			}
			
			// finally outstanding orders
			ordersStr = dataObj[count].ordersCnt;
			if(ordersStr){
				orders = stringToNumber(ordersStr);
				if(orders > 0){
					var ordersIcon = window.parent.adv_bed_mgmt.document.getElementById('pendorders_'+(roomNum+bedNum));
					 if(ordersIcon){
						 ordersIcon.style.visibility = '';
					 }
				}
			}

			
		}
		
		return 1;
		
	}else{
		// hard coding error message for testing purpose
		errorMessage = 'Could not retrieve complete bed information.';
		showMessageInStatusFrame(2,errorMessage);
		return 0;
	}
	
}

