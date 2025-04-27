var function_id = "PH_DRUG_QUOTA_LIMIT";
var result = false;
var message = "";
var flag = "";
var row= 1;
var MODE_INSERT=1;

function create() {
	f_query_add_mod.location.href = "../../ePH/jsp/DrugQuotaLimitFrame.jsp?function_id=" + function_id + "&mode="+ MODE_INSERT;
	}
function reset() {
	
	var formSpec =f_query_add_mod.frameDrugQuotaLimitDetail.document.formSpecialityDetail;
	var formElements = formSpec.elements;
	var querymode;
	for (var i = 0; i < formElements.length; i++) {
		if(formElements[i].name.indexOf('query') !== -1)
		 {
		     querymode= formElements[i].value;
		 }
		
	}
	if(querymode==0){ 
	commontoolbarFrame.location.reload();
	f_query_add_mod.location.href = "../../ePH/jsp/DrugQuotaLimitFrame.jsp?function_id=" + function_id + "&mode="+ MODE_INSERT;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" 
    }
	else
		{
		commontoolbarFrame.location.reload();
		f_query_add_mod.location.reload();
		messageFrame.location.href = "../../eCommon/jsp/error.jsp"
		}
	
}
function apply() {
	  //alert("--apply--");
	  var formObj =f_query_add_mod.frameDrugQuotaLimitHeader.document.formDrugQuotaLimit;
	  var formSpec =f_query_add_mod.frameDrugQuotaLimitDetail.document.formSpecialityDetail;
	  var formElements = formSpec.elements;
		var element="";
		var oneSpeciality=false;
		var rowsMorethanOne=false;
		var querymode;
		
		 //DRUG CANNOT BE BLANK
		 //At least one Speciality should be included for associating it to a drugâ??
		 //Quota and AdditionalQuota cannot be 0 or blank
		 for (var i = 0; i < formElements.length; i++) {
			 if(formElements[i].name.indexOf('splName')!==-1){
				 oneSpeciality=true}

			 if (formElements[i].name.indexOf('row_no') !== -1) {
				 if (formElements[i].value > 1) {
					 rowsMorethanOne = true;
				 }
			 }

			 if(formElements[i].name.indexOf('query') !== -1)
			 {
				 querymode= formElements[i].value;
			 }
			 if(formElements[i].name=='drug_code' && (formElements[i].value ==''|| formElements[i].value == "" ||formElements[i].value == null ||formElements[i].value == 'null'))
			 {
				 var msg =getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.DrugName.label","Common"))));
				// var msg = getLabel("ePH.DispensedDrugName.label", "PH") + " " + getLabel("Common.Cannotbeblank.label", "Common");
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
				 return;
			 }
		 
		 if (formElements[i].name.indexOf('quota') !== -1) {	
			 if( formElements[i].value == 0 || formElements[i].value =='' || formElements[i].value ==null)
			 {
				 if(formElements[i].name.indexOf('additional_quota_limit') !==-1)
				 {
					 //var msg =getMessage("ADDITIONAL_QUOTA_LIMIT_CANT_BE_BLANK","PH");
					 var msg =getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("ePH.AdditionalQuotaLimit.label","PH"))));
				 }
				 else{
					 //var msg =getMessage("QUOTA_LIMIT_CANT_BE_BLANK","PH");
					 var msg =getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("ePH.QuotaLimit.label","PH"))));
				 }
				 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
				 return;
			 }
		 }
}
		 if(querymode==0 && !oneSpeciality )
		 {
		 var msg =getMessage("SPECIALITY_EXIST","PH");
		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
		 return;
		 }
		 else if(querymode>0 && !rowsMorethanOne)
		 {
		     var msg =getMessage("SPECIALITY_EXIST","PH");
			 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
			 return; 
		 }
		 
		 var responseText = formApply(formSpec, PH_CONTROLLER);
		 //alert("responseText"+responseText);
		 var r=responseText.indexOf("assignResult(");
		 var s=responseText.slice(r+13,r+17);
		 var msg;
		 if(s=='true')
			 {
			 msg =getMessage("RECORD_MODIFIED","PH");
			 }
		 else
			 {
			 msg =getMessage("TRANSACTION_FAILED","PH");
			 }
		 afterApply(msg);
		 
	  }

function afterApply(msg){
	 commontoolbarFrame.location.reload();
     f_query_add_mod.location.href = "../../ePH/jsp/DrugQuotaLimitFrame.jsp?function_id=" + function_id + "&mode="+ MODE_INSERT;
	 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + msg;
    }

async function DrugSearchForQuotaLimit(obj) {
	 // var formObj = document.frames.formDrugQuotaLimit;
	  
	  var formObj =  document.getElementById('formDrugQuotaLimit');
	  var drugCode = formObj.drug_code.value;

	  var arrDrug = await searchDrugName1(obj);
	 
	  var ret1=unescape(arrDrug);
	 arr=ret1.split(",");
	 
	  if (arrDrug !== "" && arrDrug != null) {
	    formObj.drug_code.value = arr[0];
	    formObj.drug_desc.value = arr[1];
	   // formObj.drug_desc.disabled = true;
		callDetail(arrDrug[0],arrDrug[1]);
		//alert("after callDetail form"+formObj.drug_desc.value);
	  }
	}	


function onSuccess() {
	var mode = f_query_add_mod.document.formDrugQuotaLimit.mode.value;
	  if (mode === MODE_INSERT) {
            create();
         } else{
		f_query_add_mod.location.href = "../../eCommon/html/blank.html";
	}
}


function clearDrugRelatedFields(obj) {

	var formObj = document.frames.formDrugQuotaLimit;

	if (obj == "onBlur") {
		if (formObj.drug_desc.value == "") {
			formObj.drug_code.value = "";
		}
	} else if (obj == "keyDown") {
		formObj.drug_code.value = "";
	}
}

async function populateSpl() {
	  var drugName = document.forms[0].drug_desc.value;
	  var drugCode = document.forms[0].drug_code.value;
	  if (drugName === "" || drugCode ==="") {
		    var msg =getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.DrugName.label","Common"))));
		    alert(msg);
		    return;
		  }

    var target = document.forms[0].splName;
	  var title = getLabel("ePH.Speciality.label", "common");
	  var sql = "SELECT speciality_code code, short_desc description FROM am_speciality WHERE eff_status='E' AND UPPER(speciality_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER BY 2";
	  var argArray = new Array();
	  var namesArray = new Array();
	  var valuesArray = new Array();
	  var datatypesArray = new Array();
	  var parNameArray = new Array();
	  var parValueArray = new Array();
	  argArray[0] = "";
	  argArray[1] = namesArray;
	  argArray[2] = valuesArray;
	  argArray[3] = datatypesArray;
	  argArray[4] = "1,2";
	  argArray[5] = target.value;
	  argArray[6] = DESC_LINK;
	  argArray[7] = CODE_DESC;
	  argArray[12] = "SQL_SPECIALITY_LOOKUP_SELECT";
	  argArray[13] = "eCA.Common.CaRepository";
	  argArray[14] = parNameArray;
	  argArray[15] = parValueArray;
	  
	  var retVal = await CommonLookup(title, argArray);
	  addRow(retVal);
	}

function resetValues() {
//parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function setValue() {
	document.forms[0].flag.value = '';
}
function chekcSplTxt(txtSpl) {
	if (txtSpl.value == '') {
		parent.frames[0].document.forms[0].spl_code.value = '';
	}
}

function confirmReset(index) {
	form = parent.frames[1].document.forms[0];
	var setLimitByRadios = form.elements('set_limit_by_' + index);
	var quotaLimitInput = form.elements("quota_limit" + index);
	var additionalQuotaLimitInput = form.elements('additional_quota_limit'+ index);
	var resetLink = form.elements('resetLink' + index);

	if (setLimitByRadios[0].checked) {
		if (quotaLimitInput.value === "" || quotaLimitInput.value === "0"|| additionalQuotaLimitInput.value === "" || additionalQuotaLimitInput.value === "0") {
			alert("Quota Limit and Additional Quota Limit cannot be blank or 0.");
			return;
		}

		var confirmation = confirm("The defined quota will be reset from start. Do you want to continue?");

		if (confirmation) {
			form.elements('resetClicked'+index).value ='Yes' ;
		} 
	}
}
function isNumber(evt) {
	if(evt!=null && evt!=undefined){
	  var charCode = (evt.which) ? evt.which : evt.keyCode;
	  var inputValue = String.fromCharCode(charCode);

	  if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	    return false;
	  }
	  return true;
	}
}

function deleteSelectedSpecialties() {
  form = parent.frames[1].document.forms[0];
	var table = parent.frames[1].document.getElementById('specialityTable');
	var formElements = form.elements;
	var row = []; // Declare row outside the loop
	var k = 0; // Initialize k outside the loop

	// Iterate through the form elements
	for (var i = 0; i < formElements.length; i++) {
	    if (formElements[i].name.indexOf('select') !== -1) {
	        if (formElements[i].checked == true) {
	            delete_spec = true;
	            row[k++] = parseInt(formElements[i].name.slice(6));
	        }
	    }
	}
	for (var j = k-1; j >=0; j--) {
	    table.deleteRow(row[j]);
	}
}	
function callDetail(drug_code,drug_desc) {
	parent.location.href ="../../ePH/jsp/DrugQuotaLimitFrame.jsp?function_id=" + function_id + "&mode="+ MODE_INSERT+"&drug_code=" +drug_code + "&drug_desc="+drug_desc;
}
function addRow(speciality) {

	if (speciality != null && speciality != '') {
		form=parent.frames[1].document.forms[0];
		var table = parent.frames[1].document.getElementById('specialityTable');
		var tbody = table.getElementsByTagName('tbody')[0];
		//var tabRow = form.elements['row_no'].value;
		//var tabRow = document.getElementById("row_no");
 
		var tabRow = parent.frames[1].document.getElementsByName("row_no");
		
		if (tabRow) {
			
             tabRow = tabRow.value;
		}
		
		if (tabRow > row) {
			row = tabRow;
		}
		var specialityRowExist=false; 
		var formElements = form.elements;
		// Iterate through the form elements
		for (var i = 0; i < formElements.length; i++) {
			if (formElements[i].name.indexOf('splName') !== -1) {	
				if( formElements[i].value == speciality[1])
				{
					specialityRowExist=true;
					break;
				}
			}
		}
		
		if(specialityRowExist)
		{
			alert(getMessage("SPECIALITY_IN_LIST","PH"));
		}
		else{
			var classvalue;
			if (row==0|| row% 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			// Create a new row
			var newRow = document.createElement('tr');
			// Create the first cell with the input textbox
			var cell1 = document.createElement('td');
			var textbox = document.createElement('input');
			textbox.type = 'text';
			textbox.name = 'splName' + row;
			textbox.size = '25';
			textbox.maxLength = '20';
			textbox.value = speciality[1];
			textbox.disabled = true;
			var specialityCode =document.createElement('input');
			specialityCode.type = 'hidden'
			specialityCode.name = 'splCode'+ row;
			specialityCode.value = speciality[0];
			cell1.className = classvalue; 
			cell1.style.textAlign = 'right';
			cell1.appendChild(textbox);
			cell1.appendChild(specialityCode);


			// Create the second cell with the radio buttons
			var cell2 = document.createElement('td');
			var radio1 = document.createElement('input');
			radio1.type = 'radio';
			radio1.name = 'set_limit_by_' + row;
			radio1.value = 'patient';
			radio1.setAttribute('data-row', row); 
			radio1.onclick =function(){ toggleLinkVisibilityForDynamicallyAddedRows(this.getAttribute('data-row'),radio1)};
			cell2.appendChild(radio1);
			cell2.appendChild(document.createTextNode('Patient'));
			var radio2 = document.createElement('input');
			radio2.type = 'radio';
			radio2.name = 'set_limit_by_' + row;
			radio2.value = 'quantity';
			//radio2.checked = true;
			radio2.defaultChecked = true;
			radio2.setAttribute('data-row', row); 							 
			//alert("radio2"+ radio2.checked);
			radio2.onclick = function(){ toggleLinkVisibilityForDynamicallyAddedRows(this.getAttribute('data-row'),radio1)};
			cell2.className = classvalue; 
			cell2.style.textAlign = 'right';
			cell2.appendChild(radio2);
			cell2.appendChild(document.createTextNode('Quantity'));
			// Create the third cell with the quota_limit input textbox
			var cell3 = document.createElement('td');
			var quotaLimitTextbox = document.createElement('input');
			quotaLimitTextbox.type = 'text';
			quotaLimitTextbox.name = 'quota_limit' + row;
			quotaLimitTextbox.value = '';
			quotaLimitTextbox.size = '5';
			quotaLimitTextbox.maxLength = '3';
			quotaLimitTextbox.onkeypress = function(event) {
				return isNumber(event);
			};
			quotaLimitTextbox.onchange = function() {
				return isNotZero(this);
			};
			cell3.className = classvalue; 
			cell3.style.textAlign = 'right';
			cell3.appendChild(quotaLimitTextbox);
			// Create the fourth cell with the additional_quota_limit input textbox
			var cell4 = document.createElement('td');
			var additionalQuotaLimitTextbox = document.createElement('input');
			additionalQuotaLimitTextbox.type = 'text';
			additionalQuotaLimitTextbox.name = 'additional_quota_limit' + row;
			additionalQuotaLimitTextbox.value = '';
			additionalQuotaLimitTextbox.size = '5';
			additionalQuotaLimitTextbox.maxLength = '3';
			additionalQuotaLimitTextbox.onkeypress = function(event) {
				return isNumber(event);
			};
			additionalQuotaLimitTextbox.onchange = function() {
				return isNotZero(this);
			};
			cell4.className = classvalue; 
			cell4.style.textAlign = 'right';
			cell4.appendChild(additionalQuotaLimitTextbox);
			// Create the fifth cell with the Reset link
			var cell5 = document.createElement('td');
			var resetLink = document.createElement('a');
			resetLink.href = '#';
			resetLink.name = 'resetLink' + row;
			resetLink.style.display= 'none';							
			resetLink.className = 'reset-link';
			resetLink.setAttribute('data-row', row); 								
			resetLink.onclick = function() {
			confirmResetForDynamicallyAddedRows(this.getAttribute('data-row'),radio1);
			};
			resetLink.appendChild(document.createTextNode('Reset'));
			var resetClicked =document.createElement('input');
            resetClicked.type = 'hidden'
            resetClicked.name = 'resetClicked'+ row;
            resetClicked.value = 'No';
			cell5.className = classvalue; 
			cell5.style.textAlign = 'right';
			cell5.appendChild(resetLink);
			cell5.appendChild(resetClicked);
			// Create the sixth cell with the checkbox
			var cell6 = document.createElement('td');
			var checkbox = document.createElement('input');
			checkbox.type = 'checkbox';
			checkbox.name = 'select'+row;
			cell6.className = classvalue; 
			cell6.style.textAlign = 'right';
			cell6.appendChild(checkbox);
			// Add all the cells to the new row
			newRow.appendChild(cell1);
			newRow.appendChild(cell2);
			newRow.appendChild(cell3);
			newRow.appendChild(cell4);
			newRow.appendChild(cell5);
			newRow.appendChild(cell6);

			// Add the new row to the table
			tbody.appendChild(newRow);
			row++;
			//form.elements['row_no'].value=row;
			parent.frames[1].document.getElementsByName("row_no").value=row;
		}

	}
}
function toggleLinkVisibility(rowNumber) {
	form = parent.frames[1].document.forms[0];
	var table = parent.frames[1].document.getElementById('specialityTable');
	var formElements = form.elements;
	var setLimitByRadios;
	var resetClicked;
	// Iterate through the form elements
	for (var i = 0; i < formElements.length; i++) {
	    if (formElements[i].name.indexOf("set_limit_by_" + rowNumber) !== -1) {
	    	setLimitByRadios=formElements[i];
	    }
	    if (formElements[i].name.indexOf('resetClicked' + rowNumber) !== -1) {
	    	resetClicked=formElements[i];
	    }
	}
    //alert(setLimitByRadios.name+ resetClicked.name);
    var parentTd = resetClicked.parentNode;
    var resetLink =findResetLink(parentTd);
     if(resetLink!=null && resetLink !=undefined){
    	 var patientRadio = document.getElementsByName('set_limit_by_' + rowNumber)[0];
    	 //alert("patientRadio.checked ="+patientRadio.checked);
         if (patientRadio.checked) {
             resetLink.style.display = 'block';
         } else {
											   
             resetLink.style.display = 'none';
         }
    
	}
}
function getSplCode(objCode) {
        if ( document.forms[0].splCode!=null &&document.forms[0].splCode!=undefined) {
                document.forms[0].splCode.value = '';
        } else {
                populateSpl();
        }
}
async function searchDrugName1(obj){

	var formObj = document.formDrugQuotaLimit;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.sql_ph_drug_query_select1.value+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
    
	return retVal;

}

function isNotZero(fld) {
    var input = fld.value;
    if (isNaN(input) || input > 999|| input==0) {
          // If input is not valid, set input field value to an empty string
          fld.value = "";
        }
}

function findResetLink(parentTd) {
    var children = parentTd.childNodes;
    for (var i = 0; i < children.length; i++) {
        var child = children[i];
        if (child.nodeName === 'A' && child.className === 'reset-link') {
            return child; // Found the reset link
        }
    }
    return null; // Reset link not found
}
function toggleLinkVisibilityForDynamicallyAddedRows(rowNumber,radioButton) {

	    var form = parent.frames[1].document.forms[0];
	    var table = parent.frames[1].document.getElementById('specialityTable');
	    var formElements = form.elements;
	    var setLimitByRadios;
		var resetClicked;
		// Iterate through the form elements
		for (var i = 0; i < formElements.length; i++) {
		    if (formElements[i].name.indexOf("set_limit_by_" + rowNumber) !== -1) {
		    	setLimitByRadios=formElements[i];
		    }
		    if (formElements[i].name.indexOf('resetClicked' + rowNumber) !== -1) {
		    	resetClicked=formElements[i];
		    }
		}

	    // Find the parent <td> of the resetClicked input to locate the reset link
	    var parentTd = resetClicked.parentNode;
	    var resetLink = findResetLink(parentTd);

	    if (resetLink != null && resetLink != undefined) {
	        if (radioButton.checked) {
	            resetLink.style.display = 'block';
	        } else {
	            resetLink.style.display = 'none';
	        }
	    }
}

function confirmResetForDynamicallyAddedRows(index,radioButton) {
	
	var quotaLimitInput;
	var additionalQuotaLimitInput;
	var resetLink;
	var resetClicked;
	var form = parent.frames[1].document.forms[0];
    var formElements = form.elements;
	// Iterate through the form elements
	for (var i = 0; i < formElements.length; i++) {
	    if (formElements[i].name.indexOf("quota_limit" + index) !== -1) {
	    	quotaLimitInput=formElements[i];
	    }
	    if (formElements[i].name.indexOf('additional_quota_limit'+ index) !== -1) {
	    	additionalQuotaLimitInput=formElements[i];
	    }
	    if (formElements[i].name.indexOf('resetLink' + index) !== -1) {
	    	resetLink=formElements[i];
	    }
	    if (formElements[i].name.indexOf('resetClicked'+index) !== -1) {
	    	resetClicked=formElements[i];
	    }
	}

	if (radioButton.checked) {
		if (quotaLimitInput.value === "" || quotaLimitInput.value === "0"|| additionalQuotaLimitInput.value === "" || additionalQuotaLimitInput.value === "0") {
			alert("APP-PH753 Quota Limit and Additional Quota Limit cannot be blank or 0.");
			return;
		}
														   
		var confirmation = confirm("The defined quota will be reset from start. Do you want to continue?");

		if (confirmation) {
															
			resetClicked.value ='Yes' ;

		} 
	}
}
