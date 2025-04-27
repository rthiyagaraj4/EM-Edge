function run(){
	//alert('Submit button clicked! Form is valid.');
	var reportType = document.getElementById("ReportType").value;
	
	if(reportType == ""){
		alert(getMessage("BL1418","BLEXT"));
		return false;
	}
    getSessionID();		//first passing all the UI fields to BL_INSERT_SY_PROG_PARAM table and get the sessionID and PGM date
	reportPopup("Report Options");			//display the report options
}

function getCurrentDate() {
    var today = new Date();
    return today.toISOString(); // Directly return ISO string including date and time
}

function convertDateFormat(dateStr) {
    // Check if the dateStr is a valid ISO 8601 date-time string
    if (!dateStr || typeof dateStr !== 'string') {
        throw new Error('Invalid date string');
    }

    // Create a Date object from the ISO 8601 string
    const date = new Date(dateStr);

    // Extract day, month, year, hours, and minutes
    const day = date.getUTCDate().toString().padStart(2, '0');
    const month = (date.getUTCMonth() + 1).toString().padStart(2, '0'); // Months are zero-based
    const year = date.getUTCFullYear();
    const hours = date.getUTCHours().toString().padStart(2, '0');
    const minutes = date.getUTCMinutes().toString().padStart(2, '0');
	console.log("return value= " + `${day}/${month}/${year} ${hours}:${minutes}`);
    // Return the formatted date and time string
    return `${day}/${month}/${year} `;
	
}

function dateValidation(option) {
    var EffectiveDateInput = document.getElementById('EffectiveDate').value.trim();
    var EffectiveDateToInput = document.getElementById('EffectiveDateTo').value.trim();
	
	var CreatedAmendedDateInput = document.getElementById('CreatedAmendedDate').value.trim();
    var CreatedAmendedDateToInput = document.getElementById('CreatedAmendedDateTo').value.trim();
    
    console.log("EffectiveDateInput: " + EffectiveDateInput);
    console.log("EffectiveDateToInput: " + EffectiveDateToInput);
	
	 if (option == 1) {
        // Convert date strings to Date objects for comparison
        var effectiveDate = new Date(EffectiveDateInput);
        var effectiveDateTo = new Date(EffectiveDateToInput);

        if (EffectiveDateInput && EffectiveDateToInput) {
            if (isNaN(effectiveDate.getTime()) || isNaN(effectiveDateTo.getTime())) {
                console.log('Invalid date format.');
                alert(getMessage("INVALID_DATE_FMT", "SM").trim());
                //alert('Please enter valid dates.');
                return false;
            }

            if (effectiveDate > effectiveDateTo) {
                console.log('alert condition met.');
                alert(getMessage("BL00613", 'BL'));
                //document.getElementById('EffectiveDate').value = "";
				document.getElementById('EffectiveDateTo').value = "";
                document.getElementById('EffectiveDateTo').focus();
                return false; 
            } else {
                return true;
            }
        }
    }
	
	if (option == 2) {
        // Convert date strings to Date objects for comparison
        var createdAmendedDate = new Date(CreatedAmendedDateInput);
        var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);

        if (CreatedAmendedDateInput && CreatedAmendedDateToInput) {
            if (isNaN(createdAmendedDate.getTime()) || isNaN(createdAmendedDateTo.getTime())) {
                console.log('Invalid date format.');
                //alert('Please enter valid dates.');
                alert(getMessage("INVALID_DATE_FMT", "SM").trim());
                return false;
            }

            if (createdAmendedDate > createdAmendedDateTo) {
                console.log('alert condition met.');
                alert(getMessage("BL00613", 'BL'));
                //document.getElementById('CreatedAmendedDate').value = "";
				document.getElementById('CreatedAmendedDateTo').value = "";
                document.getElementById('CreatedAmendedDateTo').focus();
                return false; 
            } else {
                return true;
            }
        }
    }
	
	if (option == 3) {
    // Convert date strings to Date objects for comparison
    var createdAmended = new Date(CreatedAmendedDateInput);
    var currentDate = new Date(getCurrentDate()); // Ensure getCurrentDate() is called

    if (CreatedAmendedDateInput) {
        if (isNaN(createdAmended.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmended > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('CreatedAmendedDate').value = getCurrentDate(); // Ensure getCurrentDate() is called
            document.getElementById('CreatedAmendedDate').focus();
            return false; 
        } else {
            return true;
        }
    }
}

if (option == 4) {
    // Convert date strings to Date objects for comparison
    var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);
    var currentDate = new Date(getCurrentDate()); // Ensure getCurrentDate() is called

    if (CreatedAmendedDateToInput) {
        if (isNaN(createdAmendedDateTo.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmendedDateTo > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('CreatedAmendedDateTo').value = getCurrentDate(); // Ensure getCurrentDate() is called
            document.getElementById('CreatedAmendedDateTo').focus();
            return false; 
        } else {
            return true;
        }
    }
}

}

function drugDateValidation(option) {
	var CreatedAmendedDateInput = document.getElementById('drugInputCreatedAmendedDate').value.trim();
    var CreatedAmendedDateToInput = document.getElementById('drugInputToCreatedAmendedDate').value.trim();
	
	if (option == 2) {
        // Convert date strings to Date objects for comparison
        var createdAmendedDate = new Date(CreatedAmendedDateInput);
        var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);

        if (CreatedAmendedDateInput && CreatedAmendedDateToInput) {
            if (isNaN(createdAmendedDate.getTime()) || isNaN(createdAmendedDateTo.getTime())) {
                console.log('Invalid date format.');
                //alert('Please enter valid dates.');
                alert(getMessage("INVALID_DATE_FMT", "SM").trim());
                return false;
            }

            if (createdAmendedDate > createdAmendedDateTo) {
                console.log('alert condition met.');
                alert(getMessage("BL00613", 'BL'));
                document.getElementById('drugInputToCreatedAmendedDate').value = "";
                document.getElementById('drugInputToCreatedAmendedDate').focus();
                return false; 
            } else {
                return true;
            }
        }
    }
	
	if (option == 3) {
    // Convert date strings to Date objects for comparison
    var createdAmended = new Date(CreatedAmendedDateInput);
    var currentDate = new Date(getCurrentDate()); 

    if (CreatedAmendedDateInput) {
        if (isNaN(createdAmended.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmended > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('drugInputCreatedAmendedDate').value = getCurrentDate(); 
            document.getElementById('drugInputCreatedAmendedDate').focus();
            return false; 
        } else {
            return true;
        }
    }
}
	
	
if (option == 4) {
    // Convert date strings to Date objects for comparison
    var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);
    var currentDate = new Date(getCurrentDate()); // Ensure getCurrentDate() is called

    if (CreatedAmendedDateToInput) {
        if (isNaN(createdAmendedDateTo.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmendedDateTo > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('drugInputToCreatedAmendedDate').value = getCurrentDate(); // Ensure getCurrentDate() is called
            document.getElementById('drugInputToCreatedAmendedDate').focus();
            return false; 
        } else {
            return true;
        }
    }
}
	
}

function consumableDateValidation(option) {
	var CreatedAmendedDateInput = document.getElementById('consumableInputCreatedAmendedDate').value.trim();
    var CreatedAmendedDateToInput = document.getElementById('consumableInputToCreatedAmendedDate').value.trim();
	
	if (option == 2) {
        // Convert date strings to Date objects for comparison
        var createdAmendedDate = new Date(CreatedAmendedDateInput);
        var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);

        if (CreatedAmendedDateInput && CreatedAmendedDateToInput) {
            if (isNaN(createdAmendedDate.getTime()) || isNaN(createdAmendedDateTo.getTime())) {
                console.log('Invalid date format.');
                //alert('Please enter valid dates.');
                alert(getMessage("INVALID_DATE_FMT", "SM").trim());
                return false;
            }

            if (createdAmendedDate > createdAmendedDateTo) {
                console.log('alert condition met.');
                alert(getMessage("BL00613", 'BL'));
                document.getElementById('consumableInputToCreatedAmendedDate').value = "";
                document.getElementById('consumableInputToCreatedAmendedDate').focus();
                return false; 
            } else {
                return true;
            }
        }
    }
	
	if (option == 3) {
    // Convert date strings to Date objects for comparison
    var createdAmended = new Date(CreatedAmendedDateInput);
    var currentDate = new Date(getCurrentDate()); 

    if (CreatedAmendedDateInput) {
        if (isNaN(createdAmended.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmended > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('consumableInputCreatedAmendedDate').value = getCurrentDate(); 
            document.getElementById('consumableInputCreatedAmendedDate').focus();
            return false; 
        } else {
            return true;
        }
    }
}

if (option == 4) {
    // Convert date strings to Date objects for comparison
    var createdAmendedDateTo = new Date(CreatedAmendedDateToInput);
    var currentDate = new Date(getCurrentDate()); // Ensure getCurrentDate() is called

    if (CreatedAmendedDateToInput) {
        if (isNaN(createdAmendedDateTo.getTime())) {
            console.log('Invalid date format.');
            //alert('Please enter valid dates.');
            alert(getMessage("INVALID_DATE_FMT", "SM").trim());
            return false;
        }

        if (createdAmendedDateTo > currentDate) {
            console.log('alert condition met.');
            alert(getMessage("BL6015", 'BL'));
            document.getElementById('consumableInputToCreatedAmendedDate').value = getCurrentDate(); // Ensure getCurrentDate() is called
            document.getElementById('consumableInputToCreatedAmendedDate').focus();
            return false; 
        } else {
            return true;
        }
    }
}
	
}



function isBeforefm(from,to){
	if(from>to){
		return false;
	}else 
		return true;
}
function consumableValidateInputs(option){
	var consumableCreatedAmendedbyInput = document.getElementById('consumableInputCreatedAmendedby').value.trim();
	var consumableCreatedAmendedbyToInput = document.getElementById('consumableInputToCreatedAmendedby').value.trim();
	
	var consumableBillingServiceInput = document.getElementById('consumableInputBillingServiceItemCode').value.trim();
	var consumableBillingServiceToInput = document.getElementById('consumableInputToBillingServiceItemCode').value.trim();
	
	if (option == 1) {
        
        if (consumableCreatedAmendedbyInput !== '' && consumableCreatedAmendedbyToInput !== '') {
            if (!isBeforefm(consumableCreatedAmendedbyInput, consumableCreatedAmendedbyToInput)) {
                console.log('Billing service code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	if (option == 2) {
      
        if (consumableBillingServiceInput !== '' && consumableBillingServiceToInput !== '') {
            if (!isBeforefm(consumableBillingServiceInput, consumableBillingServiceToInput)) {
                console.log('Billing service code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	return true;
}

function drugvalidateInputs(option){
	var drugCreatedAmendedbyInput = document.getElementById('drugInputCreatedAmendedby').value.trim();
	var drugCreatedAmendedbyToInput = document.getElementById('drugInputToCreatedAmendedby').value.trim();
	
	var drugBillingServiceInput = document.getElementById('drugInputBillingServiceItemCode').value.trim();
	var drugBillingServiceToInput = document.getElementById('drugInputToBillingServiceItemCode').value.trim();
	
	
	if (option == 1) {
        // drugCreatedAmendedbyToInput Validation
        if (drugCreatedAmendedbyInput !== '' && drugCreatedAmendedbyToInput !== '') {
            if (!isBeforefm(drugCreatedAmendedbyInput, drugCreatedAmendedbyToInput)) {
                console.log('Billing service code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	if (option == 2) {
        // drugBillingServiceInput Validation
        if (drugBillingServiceInput !== '' && drugBillingServiceToInput !== '') {
            if (!isBeforefm(drugBillingServiceInput, drugBillingServiceToInput)) {
                console.log('Billing service code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	return true;
	
}

function validateInputs(option){
    var customerCodeInput = document.getElementById('CustomerCode').value.trim();
    var customerCodeToInput = document.getElementById('CustomerCodeTo').value.trim();
    
    var BillingServiceInput = document.getElementById('BillingServiceItemCode').value.trim();
    var BillingServiceToInput = document.getElementById('BillingServiceItemCodeTo').value.trim();
	
	
	
	var BillingGroupFromInput = document.getElementById('BillingGroupFrom').value.trim();
	var BillingGroupToInput = document.getElementById('BillingGroupTo').value.trim();

	var BillingClassInput = document.getElementById('BillingClass').value.trim();
	var BillingClassToInput = document.getElementById('BillingClassTo').value.trim();
	
	var CreatedAmendedbyInput = document.getElementById('CreatedAmendedby').value.trim();
	var CreatedAmendedbyToInput = document.getElementById('CreatedAmendedbyTo').value.trim();
	
	
    
    console.log("customerCodeInput: " + customerCodeInput);
    console.log("customerCodeToInput: " + customerCodeToInput);
    console.log("BillingServiceInput: " + BillingServiceInput);
    console.log("BillingServiceToInput: " + BillingServiceToInput);

    if (option == 1) {
        // Customer Code Validation
        if (customerCodeInput !== '' && customerCodeToInput !== '') {
            if (!isBeforefm(customerCodeInput, customerCodeToInput)) {
                console.log('Customer code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
				customerCodeToInput.value = ''; 
				// Reset input values
               /* var CustomerCodeInput = document.querySelector('#CustomerCode');
                if (CustomerCodeInput) {
                    CustomerCodeInput.value = ''; // Clear the input field
                }
                customerCodeInput = ''; // Ensure the variable is also cleared
                
				
				var CustomerCodeToInput = document.querySelector('#CustomerCodeTo');
                if (CustomerCodeToInput) {
                    CustomerCodeToInput.value = ''; // Clear the input field
                }
                CustomerCodeToInput = ''; // Ensure the variable is also cleared*/
				
                isPopupShown = false; // Ensure the popup status is reset
				isCustomerCodeToPopupShown= false;
				return false;
				
				
            } else {
                return true; 
            }
        }
    }
    
    if (option == 2) {
        // Billing Service Code Validation
        if (BillingServiceInput !== '' && BillingServiceToInput !== '') {
            if (!isBeforefm(BillingServiceInput, BillingServiceToInput)) {
                console.log('Billing service code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	if (option == 3) {
        // Billing Group Validation
        if (BillingGroupFromInput !== '' && BillingGroupToInput !== '') {
            if (!isBeforefm(BillingGroupFromInput, BillingGroupToInput)) {
                console.log('Billing group code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }

	if (option == 4) {
        // Billing Class Validation
        if (BillingClassInput !== '' && BillingClassToInput !== '') {
            if (!isBeforefm(BillingClassInput, BillingClassToInput)) {
                console.log('Billing class code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }
	
	if (option == 5) {
        // Created Amendedby Validation
        if (CreatedAmendedbyInput !== '' && CreatedAmendedbyToInput !== '') {
            if (!isBeforefm(CreatedAmendedbyInput, CreatedAmendedbyToInput)) {
                console.log('Billing class code alert condition met.');
                alert(getMessage("BL7060", 'BL'));
                return false;
            } else {
                return true; 
            }
        }
    }

   
    console.log('No matching option or fields are empty.');
    return true; // Assume validation succeeded if no option matches
}

function handleBlur(event){
	
	if( $("#CustomerCode").val() != "" || $("#CustomerCodeTo").val() != ""){
		$("#BillingGroupFrom").attr("disabled", true).val("");
        $("#fromBillingGroup").attr("disabled", true).addClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", true).val("");
        $("#toBillingGroup").attr("disabled", true).addClass("disabled-button");
	} else if( $("#BillingGroupFrom").val() != "" || $("#BillingGroupTo").val() != ""){
		$("#CustomerCode").attr("disabled", true).val("");
        $("#fromCustomerCode").attr("disabled", true).addClass("disabled-button");

        $("#CustomerCodeTo").attr("disabled", true).val("");
        $("#toCustomerCode").attr("disabled", true).addClass("disabled-button");
	}
	else{
		// Enable 
        $("#CustomerCode").attr("disabled", false).val("");
        $("#fromCustomerCode").attr("disabled", false).removeClass("disabled-button");
        
        $("#CustomerCodeTo").attr("disabled", false).val("");
        $("#toCustomerCode").attr("disabled", false).removeClass("disabled-button");
        
        $("#BillingGroupFrom").attr("disabled", false).val("");
        $("#fromBillingGroup").attr("disabled", false).removeClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", false).val("");
        $("#toBillingGroup").attr("disabled", false).removeClass("disabled-button");
		
		
		}
	
}

function PriceIndicatorOnChange(event) {
    const selectedValue = event.target.value;
    
    //Standard Price logic
    if (selectedValue === 'P' || selectedValue === 'C' || selectedValue === 'B') {
        $("#StandardPrice").attr("disabled", false);
    } else {
        $("#StandardPrice").prop('checked', false);
        $("#StandardPrice").attr("disabled", true);
    }

    if (selectedValue === 'P' || selectedValue === 'S') {
        $("#CustomerCode").attr("disabled", true).val("");
        $("#fromCustomerCode").attr("disabled", true).addClass("disabled-button");

        $("#CustomerCodeTo").attr("disabled", true).val("");
        $("#toCustomerCode").attr("disabled", true).addClass("disabled-button");

        $("#BillingGroupFrom").attr("disabled", true).val("");
        $("#fromBillingGroup").attr("disabled", true).addClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", true).val("");
        $("#toBillingGroup").attr("disabled", true).addClass("disabled-button");
    } else if (selectedValue === 'C') {
        $("#BillingGroupFrom").attr("disabled", true).val("");
        $("#fromBillingGroup").attr("disabled", true).addClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", true).val("");
        $("#toBillingGroup").attr("disabled", true).addClass("disabled-button");
        
        $("#CustomerCode").attr("disabled", false).val("");
        $("#fromCustomerCode").attr("disabled", false).removeClass("disabled-button");

        $("#CustomerCodeTo").attr("disabled", false).val("");
        $("#toCustomerCode").attr("disabled", false).removeClass("disabled-button");
    } else if (selectedValue === 'B') {
        $("#BillingGroupFrom").attr("disabled", false).val("");
        $("#fromBillingGroup").attr("disabled", false).removeClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", false).val("");
        $("#toBillingGroup").attr("disabled", false).removeClass("disabled-button");
        
        $("#CustomerCode").attr("disabled", true).val("");
        $("#fromCustomerCode").attr("disabled", true).addClass("disabled-button");

        $("#CustomerCodeTo").attr("disabled", true).val("");
        $("#toCustomerCode").attr("disabled", true).addClass("disabled-button");
    } else {
        // Enable 
        $("#CustomerCode").attr("disabled", false).val("");
        $("#fromCustomerCode").attr("disabled", false).removeClass("disabled-button");
        
        $("#CustomerCodeTo").attr("disabled", false).val("");
        $("#toCustomerCode").attr("disabled", false).removeClass("disabled-button");
        
        $("#BillingGroupFrom").attr("disabled", false).val("");
        $("#fromBillingGroup").attr("disabled", false).removeClass("disabled-button");
        
        $("#BillingGroupTo").attr("disabled", false).val("");
        $("#toBillingGroup").attr("disabled", false).removeClass("disabled-button");
    }
}


function customerCodeLookup(searchBy, searchCriteria, searchText, type) {
    // Create and show the processing message
    var processingMessage = document.createElement('div');
    processingMessage.id = 'processingMessage';
    processingMessage.textContent = 'Processing, please wait...';
    document.body.appendChild(processingMessage);

    // Construct the query string
    var paramString = [
        "search_text=" + encodeURIComponent(searchText),
        "searchBy=" + encodeURIComponent(searchBy),
        "search_criteria=" + encodeURIComponent(searchCriteria),
        "type=" + encodeURIComponent(type) // Add type parameter
    ].join("&");

    // Create XMLHttpRequest object
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "../../eBL/jsp/BLServItemPriceListLookupAjax.jsp?" + paramString, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

    // Define callback function to handle the response
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            var responseText = xhr.responseText;
            //console.log("Raw response from server: " + responseText);

            // Remove the processing message
            if (processingMessage) {
                document.body.removeChild(processingMessage);
            }

            if (xhr.status === 200) {
                try {
                    // Parse JSON response
                    var data = JSON.parse(responseText);
                    //console.log("Parsed JSON data: " + data);

                    var htmlContent = '';

                    if (data.length === 1) {
                        // Directly update the input and close popup if there's only one result
                        updateInputAndClosePopup(data[0].code);
                        return; // Exit function 
                    }

                    if (data.length > 0) {    
                        htmlContent = 
                            '<div class="results-grid">' +
                                '<div class="results-grid-header">' +
                                    /*'<div class="results-grid-item header">S.No</div>' +*/
                                    '<div class="results-grid-item header">Code</div>' +
                                    '<div class="results-grid-item header">Description</div>' +
                                '</div>' +
                                '<div class="results-grid-body">';

                        // Loop through data and add serial numbers
                        for (var i = 0; i < data.length; i++) {
                            var serialNumber = i + 1;
                            htmlContent += 
                                '<div class="results-grid-row">' +
                                    /*'<div class="results-grid-item">' + serialNumber + '</div>' +*/
                                    '<div class="results-grid-item">' +
                                        '<a href="#" class="result-code" data-value="' + data[i].code + '">' + data[i].code + '</a>' +
                                    '</div>' +
                                    '<div class="results-grid-item">' + data[i].description + '</div>' +
                                '</div>';
                        }

                        htmlContent += '</div>'; // Close results-grid-body
                    } else {
                        htmlContent = '<div class="error-message-search">No data found.</div>';
                    }

                    // Find the results container and update its content
                    var resultsContainer = document.querySelector('#resultsContainer');
                    if (resultsContainer) {
                        resultsContainer.innerHTML = htmlContent;

                        // Add event listeners to hyperlinks
                        var codeLinks = document.querySelectorAll('.result-code');

                        for (var j = 0; j < codeLinks.length; j++) {
                            codeLinks[j].addEventListener('click', function(e) {
                                e.preventDefault(); // Prevent the default link behavior
                                updateInputAndClosePopup(this.getAttribute('data-value'));
                            });
                        }
                    } else {
                        console.error('Results container not found.');
                    }
                } catch (e) {
                    console.error("Error parsing JSON response: ", e);
                    var resultsContainer = document.querySelector('#resultsContainer');
                    if (resultsContainer) {
                        resultsContainer.innerHTML = "<div>Error processing response. Received: " + responseText + "</div>";
                    }
                }
            } else {
                console.error("AJAX request failed: " + xhr.statusText);
                var resultsContainer = document.querySelector('#resultsContainer');
                if (resultsContainer) {
                    resultsContainer.innerHTML = "<div>Error retrieving data from server!</div>";
                }
            }
        }
    };

    // Send the request
    xhr.send();

    // Define the function to update input and close the popup
    function updateInputAndClosePopup(value) {
        var customerCodeInput;
        // Variable to hold the method
        var selectedMethod;
        switch(type) {
            case 'fromCustomerCode':
                customerCodeInput = document.querySelector('#CustomerCode');
                selectedMethod = () => validateInputs("1");
                break;
            case 'toCustomerCode':
                customerCodeInput = document.querySelector('#CustomerCodeTo');
                selectedMethod = () => validateInputs("1");
                break;
            case 'fromBillingService':
                customerCodeInput = document.querySelector('#BillingServiceItemCode');
                selectedMethod = () => validateInputs("2");
                break;
            case 'toBillingService':
                customerCodeInput = document.querySelector('#BillingServiceItemCodeTo');
                selectedMethod = () => validateInputs("2");
                break;
            case 'fromBillingGroup':
                customerCodeInput = document.querySelector('#BillingGroupFrom');
                selectedMethod = () => validateInputs("3");
                break;
            case 'toBillingGroup':
                customerCodeInput = document.querySelector('#BillingGroupTo');
                selectedMethod = () => validateInputs("3");
                break;
            case 'fromBillingClass':
                customerCodeInput = document.querySelector('#BillingClass');
                selectedMethod = () => validateInputs("4");
                break;
            case 'toBillingClass':
                customerCodeInput = document.querySelector('#BillingClassTo');
                selectedMethod = () => validateInputs("4");
                break;
            case 'fromAmendedby':
                customerCodeInput = document.querySelector('#CreatedAmendedby');
                selectedMethod = () => validateInputs("5");
                break;
            case 'toAmendedby':
                customerCodeInput = document.querySelector('#CreatedAmendedbyTo');
                selectedMethod = () => validateInputs("5");
                break;
            case 'fromDrugAmendedby':
                customerCodeInput = document.querySelector('#drugInputCreatedAmendedby');
                selectedMethod = () => drugvalidateInputs("1");
                break;
            case 'toDrugAmendedby':
                customerCodeInput = document.querySelector('#drugInputToCreatedAmendedby');
                selectedMethod = () => drugvalidateInputs("1");
                break;
            case 'fromDrugBillingService':
                customerCodeInput = document.querySelector('#drugInputBillingServiceItemCode');
                selectedMethod = () => drugvalidateInputs("2");
                break;
            case 'toDrugBillingService':
                customerCodeInput = document.querySelector('#drugInputToBillingServiceItemCode');
                selectedMethod = () => drugvalidateInputs("2");
                break;
            case 'fromConsumableCreatedAmendedby':
                customerCodeInput = document.querySelector('#consumableInputCreatedAmendedby');
                selectedMethod = () => consumableValidateInputs("1");
                break;
            case 'toConsumableCreatedAmendedby':
                customerCodeInput = document.querySelector('#consumableInputToCreatedAmendedby');
                selectedMethod = () => consumableValidateInputs("1");
                break;
            case 'fromConsumableBillingService':
                customerCodeInput = document.querySelector('#consumableInputBillingServiceItemCode');
                selectedMethod = () => consumableValidateInputs("2");
                break;
            case 'toConsumableBillingService':
                customerCodeInput = document.querySelector('#consumableInputToBillingServiceItemCode');
                selectedMethod = () => consumableValidateInputs("2");
                break;
            default:
                console.error('Unknown type: ' + type);
                return;
        }

    if (customerCodeInput) {
        customerCodeInput.value = value;

        // Close the popup first
        var popup = document.querySelector('.popup');
        if (popup) {
            document.body.removeChild(popup);
        }

       
        setTimeout(function() {
            console.log("Value is selected in LOV, calling validation!!!");
            var returnFlag = selectedMethod();
            console.log("returnFlag=" + returnFlag);

            if (!returnFlag) {
               
                customerCodeInput.value = "";
                
            }
        }, 300); 
    } else {
        console.error('Input field not found for type: ' + type);
    }

    }
}


function showPopup(type, searchText) {
    // Create popup container
    var popup = document.createElement('div');
    popup.className = 'popup';

    // Heading text mapping
    var headingMap = {
        'fromCustomerCode': 'From Customer Code',
        'toCustomerCode': 'To Customer Code',
        'fromBillingGroup': 'From Billing Group',
        'toBillingGroup': 'To Billing Group',
        'fromBillingService': 'From Billing Service / Item Code',
        'toBillingService': 'To Billing Service / Item Code',
        'fromBillingClass': 'From Billing Class',
        'toBillingClass': 'To Billing Class',
        'fromAmendedby': 'From Created / Amended by',
        'toAmendedby': 'To Created / Amended by',
        'fromDrugAmendedby': 'From Created / Amended by',
        'toDrugAmendedby': 'To Created / Amended by',
        'fromDrugBillingService': 'From Billing Service / Item Code',
        'toDrugBillingService': 'To Billing Service / Item Code',
        'fromConsumableBillingService': 'From Billing Service / Item Code',
        'toConsumableBillingService': 'To Billing Service / Item Code',
        'fromConsumableCreatedAmendedby': 'From Created / Amended by',
        'toConsumableCreatedAmendedby': 'To Created / Amended by'
    };

    var headingText = headingMap[type];

    if (!headingText) {
        console.error('Unknown type:', type);
        return;
    }
	
	 // Define which inputs this popup should manage
    var inputMapping = {
        'fromCustomerCode': ['#CustomerCode'],
        'toCustomerCode': ['#CustomerCodeTo'],
        'fromBillingGroup': ['#BillingGroupFrom'],
        'toBillingGroup': ['#BillingGroupTo'],
        'fromBillingService': ['#BillingServiceItemCode'],
        'toBillingService': ['#BillingServiceItemCodeTo'],
        'fromBillingClass': ['#BillingClass'],
        'toBillingClass': ['#BillingClassTo'],
        'fromAmendedby': ['#CreatedAmendedby'],
        'toAmendedby': ['#CreatedAmendedbyTo'],
        'fromDrugAmendedby': ['#drugInputCreatedAmendedby'],
        'toDrugAmendedby': ['#drugInputToCreatedAmendedby'],
        'fromDrugBillingService': ['#drugInputBillingServiceItemCode'],
        'toDrugBillingService': ['#drugInputToBillingServiceItemCode'],
        'fromConsumableBillingService': ['#consumableInputBillingServiceItemCode'],
        'toConsumableBillingService': ['#consumableInputToBillingServiceItemCode'],
        'fromConsumableCreatedAmendedby': ['#consumableInputCreatedAmendedby'],
        'toConsumableCreatedAmendedby': ['#consumableInputToCreatedAmendedby']
    };

    var managedInputs = inputMapping[type] || [];


    // Debug log to check the searchText value
    console.log('Search text:', searchText);

    // Construct popup HTML
    var popupHtml = 
        '<div class="popup-header">' +
            '<p class="popupheading-text">' + headingText + '</p>' +
            '<div class="popup-container">' +
                '<div class="popup-content">' +
                    '<span class="popup-close"></span>' +
                    
                    '<div class="form-input additionalInput">' +
                        '<select class="inputselect" style="width: 150px;" name="searchBy" id="searchBy">' +
                            '<option value="selectCode" selected>Code</option>' +
                            '<option value="selectdesc">Description</option>' +
                        '</select>' +
                        '<label class="label-select" for="searchBy">Search By</label>' +
                    '</div>' +
                    
                    '<div class="form-input additionalInput">' +
                        '<select class="inputselect" style="width: 150px;" name="searchCriteria" id="searchCriteria">' +
                            '<option value="starts_with" selected>Starts With</option>' +
                            '<option value="ends_with">Ends With</option>' +
                            '<option value="contains">Contains</option>' +
                        '</select>' +
                        '<label class="label-select" for="searchCriteria">Search Criteria</label>' +
                    '</div>' +
                    
                    '<div class="form-input additionalInput">' +
                        '<input class="floating-input" style="width: 150px;" type="text" id="searchtext" value="' + (searchText ? escapeHtml(searchText) : '') + '">' +
                        '<label class="floating-label" for="searchtext">Search Text</label>' +
                        '<span id="searchtext-error" class="error-message"></span>' +
                    '</div>' +
                    
                '</div>' +
            '</div>' +
            
            '<div class="button-container">' +
                '<div><button class="btn btn-primary" type="button" id="searchBtn">Search</button></div>' +
                '<div><button class="btn btn-primary" type="button" id="resetBtn">Reset</button></div>' +
            '</div>' +
            '<div id="resultsContainer" class="results-container">' +
            // Results will be injected here
            '</div>' +
        '</div>';

    // Add HTML to popup
    popup.innerHTML = popupHtml;
    document.body.appendChild(popup);

 var closeButton = popup.querySelector('.popup-close');
    closeButton.addEventListener('click', function() {
        // Remove the popup
        document.body.removeChild(popup);

        // Clear and reset fields in the popup
        var searchByInput = document.querySelector('#searchBy');
        var searchCriteriaInput = document.querySelector('#searchCriteria');
        var searchTextInput = document.querySelector('#searchtext');

        if (searchByInput) searchByInput.value = 'selectdesc'; // Reset to default value
        if (searchCriteriaInput) searchCriteriaInput.value = 'starts_with'; // Reset to default value
        if (searchTextInput) searchTextInput.value = ''; // Clear the text

        // Clear only the input fields associated with this popup
        managedInputs.forEach(function(selector) {
            var inputField = document.querySelector(selector);
            if (inputField) {
                inputField.value = ''; // Clear the text
            }
        });

        // Manually trigger handleBlur function to manage the enabled/disabled state
        handleBlur();

        // Reset the popup shown flag
       // isPopupShown = false;
    });

    // Event listener for the search button
    var searchBtn = popup.querySelector('#searchBtn');
    searchBtn.addEventListener('click', function() {
        performSearch();
    });

    // Event listener for the reset button
    var resetBtn = popup.querySelector('#resetBtn');
    resetBtn.addEventListener('click', function() {
        document.querySelector('#searchBy').value = 'selectCode';
        document.querySelector('#searchCriteria').value = 'starts_with';
        document.querySelector('#searchtext').value = '';
        
        var resultsContainer = document.querySelector('#resultsContainer');
        if (resultsContainer) {
            resultsContainer.innerHTML = '';
        }

        var errorSpan = document.querySelector('#searchtext-error');
        errorSpan.textContent = '';
        errorSpan.style.display = 'none';
    });

   /* // Automatically perform search with debounce
    var searchInput = document.querySelector('#searchtext');
    var debounceTimeout;
    searchInput.addEventListener('input', function() {
        clearTimeout(debounceTimeout);
        debounceTimeout = setTimeout(function() {
            performSearch();
        }, 300); // Adjust delay as needed
    });

    // Perform search when input field loses focus
    searchInput.addEventListener('blur', function() {
        performSearch();
    }); 

    // Perform search immediately if searchText is provided
    if (searchText && searchText.trim().length > 0) {
        performSearch();
    }
	*/
    function performSearch() {
        var searchBy = document.querySelector('#searchBy').value;
        var searchCriteria = document.querySelector('#searchCriteria').value;
        var searchText = document.querySelector('#searchtext').value.trim();
        var errorSpan = document.querySelector('#searchtext-error');

        errorSpan.textContent = '';
        errorSpan.style.display = 'none';

        if (searchText.length > 15) {
            errorSpan.textContent = 'Max 15 characters allowed';
            errorSpan.style.display = 'block';
            return;
        }

        /*if (searchText.length >= 0) {*/
            customerCodeLookup(searchBy, searchCriteria, searchText, type);
       /* }*/
    }
    
    //when popup open search button click by default
    performSearch();
}

// Function to escape HTML special characters
function escapeHtml(text) {
    var map = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#039;'
    };
    return text.replace(/[&<>"']/g, function(m) { return map[m]; });
}

/*            // Function to show popup
                function showPopup() {
                    var popup = document.createElement('div');
                    popup.className = 'popup';
                    popup.innerHTML = '<div class="popup-header">' +
                        '<p class="popupheading-text">Search Customer Code</p>' +
                        '<div class="popup-container">' +
                            '<div class="popup-content">' +
                                '<span class="popup-close"></span>' +
                                
                                '<div class="form-input additionalInput">' +
                                    '<select class="inputselect" style="width: 150px;" name="searchBy" id="searchBy" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" value="">' +
                                        '<option value="">Select</option>' +
                                        '<option value="option1">Code</option>' +
                                        '<option value="option2">Description</option>' +
                                    '</select>' +
                                    '<label class="label-select" for="searchBy">Search By</label>' +
                                '</div>' +
                                
                                '<div class="form-input additionalInput">' +
                                    '<select class="inputselect" style="width: 150px;" name="searchCriteria" id="searchCriteria" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" value="">' +
                                        '<option value="">Select</option>' +
                                        '<option value="option1">Starts With </option>' +
                                        '<option value="option2">Ends With</option>' +
                                        '<option value="option3">Contains</option>' +
                                    '</select>' +
                                    '<label class="label-select" for="searchCriteria">Search Criteria</label>' +
                                '</div>' +
                                
                                '<div class="form-input additionalInput">' +
                                    '<input class="floating-input" style="width: 150px;" type="text" placeholder="" id="searchtext" name="searchtext">' +
                                    '<label class="floating-label" for="searchtext">Search Text</label>' +
                                '</div>' +
                                
                        '</div>' +
                        '</div>' +
                        
                        '<div class="button-container">'+
                        '<div>'+ '<button action="" class="btn btn-primary"  type="button">Search</button>'+
                		'</div>'+
                        
                		'<div>'+ '<button action="" class="btn btn-primary"  type="button">Reset</button>'+
                		'</div>'+
                        
                        '</div>';

                    
                    document.body.appendChild(popup);

                    // Close popup on click
                    var closeButton = popup.querySelector('.popup-close');
                    closeButton.addEventListener('click', function() {
                        document.body.removeChild(popup);
                    });
                    
                }
*/
function reset() {
    location.reload(); // Reloads the entire page
}


function validateCustomerCode() {
    // Get the input field value
    var inputField = document.getElementById('CustomerCode');
    var inputValue = inputField.value.trim();
    
    // Check if the value is equal to "siraj"
    if (inputValue.toLowerCase() === 'jpnind') {
        return true; // Validation passed
    } else {
        //alert('CustomerCode Input must be "JPNIND"');
        alert(getMessage("BL1419","BLEXT"));
        return false; // Validation failed
    }
}


   
        var initialFileFormatOptions = '<option value="pdf">PDF</option><option value="spreadsheet">Spreadsheet</option>';
        var fileOptionsForFile = '<option value="pdf">PDF</option><option value="html">HTML</option><option value="rtf">RTF</option><option value="xml">XML</option><option value="spreadsheet">Spreadsheet</option>';

        function reportPopup(headingText) {
            var popup = document.createElement('div');
            popup.className = 'popup';
            popup.innerHTML = '<div class="popup-header" style="max-width: 370px;">' +
                '<p class="popupheading-text">Report Options</p>' +
                '<div class="popup-container">' +
                    '<div class="popup-content">' +
                        '<span class="popup-close"></span>' +
                        '<div class="form-input additionalInput">' +
                            '<select class="inputselect" style="width: 150px;" name="report_option" id="report_option" onclick="this.setAttribute(\'value\', this.value);" onchange="updateForm(this.value);">' +
                                '<option value="V">View</option>' +
                                '<option value="P">Printer</option>' +
                                '<option value="F">File</option>' +
                            '</select>' +
                            '<label class="label-select" for="report_option">Report Option</label>' +
                        '</div>' +
                        '<div class="form-input additionalInput" id="fileFormatContainer">' +
                            '<select class="inputselect" style="width: 150px;" name="fileFormat" id="fileFormat">' +
                                initialFileFormatOptions +
                            '</select>' +
                            '<label class="label-select" for="fileFormat">File Format</label>' +
                        '</div>' +
                        '<div class="form-input additionalInput" id="fileNameContainer">' +
                            '<input class="floating-input" style="width: 320px;" type="text" placeholder="" id="fileName" name="fileName">' +
                            '<label class="floating-label" for="fileName">File Name</label>' +
                        '</div>' +
                    '</div>' +
                '</div>' +
                '<div class="button-container">' +
                    '<div><button id="okBtn" class="btn btn-primary" type="button">Ok</button></div>' +
                    '<div><button id="cancelBtn" class="btn btn-primary" type="button">Cancel</button></div>' +
                '</div>';
            document.body.appendChild(popup);

            localStorage.setItem('originalPageURL', window.location.href);

            var closeButton = popup.querySelector('.popup-close');
            closeButton.addEventListener('click', function() {
                closePopup(popup);
            });

            var okBtn = popup.querySelector('#okBtn');
            okBtn.addEventListener('click', function() {
                //alert("Ok Button Clicked!!");
				generateDetailsForReport();
				
            });

            var cancelBtn = popup.querySelector('#cancelBtn');
            cancelBtn.addEventListener('click', function() {
                closePopup(popup);
            });

            updateForm(document.getElementById('report_option').value);
        }
        function generateURl(){
        	var reportURL = "";
        	var destype = "";
            var file_name_dir = "";
            var desname = "";
            var trade_name = "N";
            var prcInd = "";
        	var prcInd1 = "";
        	
        	var reportType = document.getElementById("ReportType").value;
        	var report_option = document.getElementById('report_option').value;
            var desformat = document.getElementById('fileFormat').value;
            var fileName = document.getElementById('fileName').value;
            var p_report_id = document.getElementById("p_report_id").value;
			var reportServer = $('#reportserver').val();
			var server = $('#server').val();
			var report = $('#report').val();
			var reportServerEnableFlag = $('#reportServerEnableFlag').val();
			var report_dir = $('#report_dir').val();
			
			//alert("In generateURl: "+report_option+", "+desformat+", "+fileName+"reportServer: "+reportServer+", reportServerEnableFlag: "+reportServerEnableFlag);
			
			var extension = "" ;
			if ( desformat == "pdf" )	extension = ".pdf" ;
			if ( desformat == "htmlcss" ) extension = ".html" ;
			if ( desformat == "rtf" )	extension = ".rtf" ;
			if ( desformat == "xml" )	extension = ".xml" ;
			if ( desformat == "spreadsheet" )	extension = ".xls" ;
			
			reportURL = reportServer +
		     "?server=" + encodeURIComponent(server) +
		     "&report=" + encodeURIComponent(report) +
			 "&recursive_load=no" ;
			
			if (report_option === 'V') {
				 file_name_dir = report+'_' + getFormattedDate() + extension ;
				 desname = report_dir + file_name_dir;
				 
				 if(reportServerEnableFlag == 'Y')
					{
						destype	= "file" ;	
						reportURL = reportURL + "&destype=" + encodeURIComponent(destype) +
						 "&desformat=" + encodeURIComponent(desformat) +
					     "&desname=" + desname +
					     "&filename=" +encodeURIComponent(file_name_dir) ;
					}
					else {
						destype	= "cache" ;
						reportURL = reportURL + "&destype=" + encodeURIComponent(destype) +
						"&desformat=" + encodeURIComponent(desformat) ;
					}
				
			}else if (report_option === 'P') { 
					var myRegExp = /\\/g ;
					var printerName = $('#queue_name').val();
					printerName = printerName.replace( myRegExp, "\\\\" ) ;
					//report_server_form.queue_name.value = printerName ;
					
					// By sbchand end on 20th June, 2001

					destype	= "printer" ;
					desname = printerName;
					//params=params.toUpperCase();
					//params=params+"+P_LANGUAGE_ID="+locale;
					
					reportURL = reportURL + "&destype=" + encodeURIComponent(destype) +
				    "&desname=" + desname +
				    "&copies=" + $('#copies').val() +
					"&background=yes";		//Copies included in the parameter

					 //alert('Sending report to printer');
			} else if (report_option === 'F') {
					
					 //alert('Saving report as file: ' + fileName + '.' + extension);
					 //reportServerEnableFlag = 'Y';
					//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
					if(reportServerEnableFlag == 'Y')
					{
						destype	= 	"file" ;
						file_name_dir = report + '_' + fileName + extension;
						desname = report_dir + file_name_dir;
						
						reportURL = reportURL + "&destype=" + encodeURIComponent(destype) +
						"&desformat=" + encodeURIComponent(desformat) +
						"&filename=" + file_name_dir +	    //File Path has been mapped to save the file in directoy for MOHE-SCF-0147
					    "&desname="	 +desname +
					    "&background=yes";
					}
					else 
					{
						destype	= 	"file" ;
						//report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;
						desname = report_dir + fileName  + extension;
						
						reportURL = reportURL + "&destype=" + encodeURIComponent(destype) +
						"&desformat=" + encodeURIComponent(desformat) +
					    "&desname="	 +desname +
					    "&background=yes";
	
					}
				
				 } 
			 	//alert('Generated URL with report option : ' + reportURL);
				//console.log("url:"+reportURL);
			
			 	//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Ends
				if( $('#rep_server_key').val() == ''){ //PMG2012-CRF-0027 IN:037658
					//url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					reportURL = reportURL + "&userid=" + $('#userid').val() ;
				}else{
					//url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					reportURL = reportURL + "&cmdkey=" + $('#rep_server_key').val() ;
				}	
             
				reportURL = reportURL + "&SELF_SUBMIT=" + encodeURIComponent("YES")+
			     "&REPORT_OPTION="+ encodeURIComponent(report_option) +
			     "&P_LANGUAGE_ID="+ encodeURIComponent($('#locale').val())+
			     "&P_REPORT_ID=" + encodeURIComponent(p_report_id) +
			     "&P_MODULE_ID=" + encodeURIComponent($('#p_module_id').val())+
			     
			     "&SESSION_ID=" + encodeURIComponent($('#p_session_id').val())+
			     "&PGM_DATE=" + encodeURIComponent($('#p_pgm_date').val()) +
			     "&PGM_ID=" + encodeURIComponent(p_report_id)+
			     "&P_USER_ID=" + encodeURIComponent($('#p_user_name').val());
			     
			     
			   
				if(reportType == "option1"){
					
					var PriceIndicator = $('#PriceIndicator').val();
					if(PriceIndicator == "A"){
						prcInd = '!';
						prcInd1 = '~';
					} 	
					else{
						prcInd = PriceIndicator;
						prcInd1 = PriceIndicator;
					}
					
					reportURL = reportURL + "&P_PGM_ID=" + encodeURIComponent(p_report_id) +
					"&P_SESSION_ID=" + encodeURIComponent($('#p_session_id').val())+
				    "&P_PGM_DATE=" + encodeURIComponent($('#p_pgm_date').val()) +
				    "&PRICE_IND=" + encodeURIComponent(prcInd) +
				    "&PRICE_IND1=" + encodeURIComponent(prcInd1) +
					"&P_FACILITY_ID=" + encodeURIComponent($('#service_Facility_ID').val())+
			     "&ND_FACILITY_ID=" + encodeURIComponent($('#service_Facility_ID').val())+
				    "&ACTIVE=" + encodeURIComponent($('#status').val());
				}
				
				if(reportType == "option2"){
					var isChecked = $("#checkboxByNameTradeBatch").is(":checked");
					if(isChecked) trade_name = "Y";
					
					reportURL = reportURL + "&PRICE_IND=" + encodeURIComponent($('#price_ind').val()) +
					"&TRADE_NAME=" + encodeURIComponent(trade_name) +
					"&P_FACILITY_ID=" + encodeURIComponent($('#drugInput2FacilityID').val())+
			     "&ND_FACILITY_ID=" + encodeURIComponent($('#drugInput2FacilityID').val())+
					"&ACTIVE=" + encodeURIComponent($('#drugInput1status').val());
				}
				
				if(reportType == "option3"){
					var isChecked = $("#consumablecheckboxByNameTradeBatch").is(":checked");
					if(isChecked) trade_name = "Y";
					
					reportURL = reportURL + "&PRICE_IND=" + encodeURIComponent($('#price_ind').val()) +
					"&TRADE_NAME=" + encodeURIComponent(trade_name) +
					"&P_FACILITY_ID=" + encodeURIComponent($('#consumableInput2FacilityID').val())+
			     "&ND_FACILITY_ID=" + encodeURIComponent($('#consumableInput2FacilityID').val())+
					"&ACTIVE=" + encodeURIComponent($('#consumableInput1status').val());
				}
				
				if(reportServerEnableFlag != 'Y'){
					if ( report_option == "F" || report_option == "P" )
						reportURL = reportURL + "&closeWindow=true" ;
				}	
			 console.log("Final URL: "+reportURL);
             //alert("finalURL: "+reportURL);
             
	var  screenHeight = "500px";
	var  screenWidth = "700px";
	var features = "location=50px,height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes,fullscreen=yes, location=no, toolbar=no";
	// Generate a unique name for the new tab
	var uniqueTabName = 'Report_' + new Date().getTime(); // Using timestamp for uniqueness

	// Open the new tab with the unique name
	var reportWindow = window.open(reportURL, uniqueTabName, features);

	// Assuming closePopup is a function you want to call here
	var popup = document.body.querySelector('.popup');
	closePopup(popup);
}
        
function updateForm(selectedOption) {
	var fileFormatSelect = document.getElementById('fileFormat');
	var fileFormatContainer = document.getElementById('fileFormatContainer');
	var fileNameContainer = document.getElementById('fileNameContainer');
	var fileNameInput = document.getElementById('fileName');

	if (selectedOption === 'V') {
		fileFormatContainer.style.display = 'block'; 
		fileNameContainer.style.display = 'none'; 
		fileFormatSelect.disabled = false; 
		fileFormatSelect.innerHTML = initialFileFormatOptions; 
	} else if (selectedOption === 'P') {
		fileFormatContainer.style.display = 'none';
		fileNameContainer.style.display = 'none'; 
	} else if (selectedOption === 'F') {
		fileFormatContainer.style.display = 'block'; 
		fileNameContainer.style.display = 'block';
		fileFormatSelect.disabled = false; 
		fileNameInput.disabled = false; 
		fileNameInput.value = getFormattedDate(); 
		fileFormatSelect.innerHTML = fileOptionsForFile; 
	} else {
		fileFormatContainer.style.display = 'none'; 
		fileNameContainer.style.display = 'none'; 
	}
}

function getFormattedDate() {
	var now = new Date();
	var year = now.getFullYear();
	var month = ('0' + (now.getMonth() + 1)).slice(-2);
	var day = ('0' + now.getDate()).slice(-2);
	var hours = ('0' + now.getHours()).slice(-2);
	var minutes = ('0' + now.getMinutes()).slice(-2);
	var seconds = ('0' + now.getSeconds()).slice(-2);
	return year + month + day + hours + minutes + seconds;
}

function closePopup(popup) {
	document.body.removeChild(popup);
	/*var originalURL = localStorage.getItem('originalPageURL');
	if (originalURL) {
		window.location.href = originalURL;
	}*/
}
function generateDetailsForReport() {
	var report_option = document.getElementById('report_option').value;
	var fileFormat = document.getElementById('fileFormat').value;
	var fileName = document.getElementById('fileName').value;
	var p_report_id = document.getElementById("p_report_id").value;
	var p_module_id = document.getElementById("p_module_id").value;
	  
	var facility_id = document.getElementById("facilityId").value;
	var reportType = document.getElementById("ReportType").value;


	if (reportType === "option1") {
		facility_id = document.getElementById("service_Facility_ID").value;
	} else if (reportType === "option2") {
		facility_id = document.getElementById("drugInput2FacilityID").value;
	} else if (reportType === "option3") {
		facility_id = document.getElementById("consumableInput2FacilityID").value;
	}
	//alert("Updated Facility ID: " + facility_id);	
	var params = $('#params').val();
	//console.log(params);
	var locale = $('#locale').val();
	var self_submit = $('#self_submit').val();
	
	var destype = $('#destype').val();
	var userid = $('#userid').val();
	var reportURL = "";
	/*alert("report_option: "+report_option);
	alert("fileFormat: "+fileFormat);
	alert("fileName: "+fileName);
	alert("locale: "+locale);*/

	var paramString = [
		"report_option=" + encodeURIComponent(report_option),
		"fileFormat=" + encodeURIComponent(fileFormat),
		"fileName=" + encodeURIComponent(fileName),
		"params=" + encodeURIComponent(params),
		"self_submit=" + encodeURIComponent(self_submit),
		"locale=" + encodeURIComponent(locale),
		"p_report_id=" + encodeURIComponent(p_report_id),
		"p_module_id=" + encodeURIComponent(p_module_id),
		"facility_id=" + encodeURIComponent(facility_id)
		].join("&");


	//alert('Parameter String: ' + paramString);
	console.log(paramString);
		
		$.ajax({
		    type: "GET", 
		    url: "../../eBL/jsp/BLServItemReportOptions.jsp",
		    data: paramString,
		    success: function(response) {
			//alert("response: "+response);
			try{
			   	 var data = JSON.parse($.trim(response));
				 //alert("After parsing: " +data.reportServer);
				 if (data.status === '1') {
					 reportServer = data.reportServer;
					$("#reportserver").val(data.reportServer);
					$("#report").val(data.report);
					$("#server").val(data.server);
					$("#copies").val(data.copies);
					$("#queue_name").val(data.queue_name);
					$("#rep_server_key").val(data.rep_server_key);
					$("#reportServerEnableFlag").val(data.reportServerEnableFlag);					
					$("#report_dir").val(data.report_dir);
					$('#userid').val(data.userid);
					var finalURL = generateURl();
					
				 }else{
					 if(data.message != ""){
						 alert(data.message);
						 console.error('Error in server response:', data.message);
					 }
			     }
			 
			}catch(e) {
					//alert("Error getting while parsing the response data."+e);
					alert(e);
			}
		
		},
		error: function(error) {
		    	//alert("Error while getting data from the server! "+error);
				alert(error);
		    }
		});
		   
	}

	function getSessionID(){
		var FrmCustCode;
		var ToCustCode;
		var FrmBillingGrp;
		var ToBillingGrp;
		var FrmBillingCls;
		var ToBillingCls;
		var frmBillingServ;
		var toBillingServ;
		var frmEffDate;
		var toEffDate;
		var frmCreateAmendBy;
		var toCreateAmendBy;
		var frmCreateAmendDate;
		var toCreateAmendDate;
		var groupby;
		var standardPrice="";
		
		var reportType = document.getElementById("ReportType").value;
		
		if(reportType == "option1"){
			 PriceIndicator = document.getElementById("PriceIndicator").value;
			
			 FrmCustCode = document.getElementById("CustomerCode").value;
			FrmCustCode = (FrmCustCode=="" || FrmCustCode==null) ? '!!!!!!!!' : FrmCustCode;
			
			 ToCustCode = document.getElementById("CustomerCodeTo").value;
			ToCustCode = (ToCustCode=="" || ToCustCode==null) ? '~~~~~~~~' : ToCustCode;
			
			 FrmBillingGrp = document.getElementById("BillingGroupFrom").value;
			FrmBillingGrp = (FrmBillingGrp=="" || FrmBillingGrp==null) ? '!!!!' : FrmBillingGrp;
			
			 ToBillingGrp = document.getElementById("BillingGroupTo").value;
			ToBillingGrp = (ToBillingGrp=="" || ToBillingGrp==null) ? '~~~~' : ToBillingGrp;
			
			 FrmBillingCls = document.getElementById("BillingClass").value;
			FrmBillingCls = (FrmBillingCls=="" || FrmBillingCls==null) ? '!!!!!!!' : FrmBillingCls;
			
			 ToBillingCls = document.getElementById("BillingClassTo").value;
			ToBillingCls = (ToBillingCls=="" || ToBillingCls==null) ? '~~~~~~~' : ToBillingCls;
			
			
			 frmEffDate = document.getElementById("EffectiveDate").value;
			frmEffDate = (frmEffDate=="" || frmEffDate==null) ? '01/01/1800' : convertDateFormat(frmEffDate);
			
			 toEffDate = document.getElementById("EffectiveDateTo").value;
			toEffDate = (toEffDate=="" || toEffDate==null) ? '31/12/4712' : convertDateFormat(toEffDate);
			
			frmBillingServ = document.getElementById("BillingServiceItemCode").value;
			frmBillingServ = (frmBillingServ=="" || frmBillingServ==null) ? '!!!!!!!!!!' : frmBillingServ;
			
			toBillingServ = document.getElementById("BillingServiceItemCodeTo").value;
			toBillingServ = (toBillingServ=="" || toBillingServ==null) ? '~~~~~~~~~~' : toBillingServ;

			frmCreateAmendBy = document.getElementById("CreatedAmendedby").value;
			frmCreateAmendBy = (frmCreateAmendBy=="" || frmCreateAmendBy==null) ? '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' : frmCreateAmendBy;
			
			toCreateAmendBy = document.getElementById("CreatedAmendedbyTo").value;
			toCreateAmendBy = (toCreateAmendBy=="" || toCreateAmendBy==null) ? '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~' : toCreateAmendBy;
			
			frmCreateAmendDate = document.getElementById("CreatedAmendedDate").value;
			frmCreateAmendDate = (frmCreateAmendDate=="" || frmCreateAmendDate==null) ? '01/01/1800' : convertDateFormat(frmCreateAmendDate);
			
			toCreateAmendDate = document.getElementById("CreatedAmendedDateTo").value;
			toCreateAmendDate = (toCreateAmendDate=="" || toCreateAmendDate==null) ? '31/12/4712' : convertDateFormat(toCreateAmendDate);

			
			groupby = document.getElementById("GroupBy").value;
			
			
			if($("#StandardPrice").prop('checked') == true){
				standardPrice="Y";
			}else{
				standardPrice="N";
			}
			
		}
		if(reportType == "option2"){
			frmBillingServ = document.getElementById("drugInputBillingServiceItemCode").value;
			frmBillingServ = (frmBillingServ=="" || frmBillingServ==null) ? '!!!!!!!!!!!!!!!!!!!!' : frmBillingServ;
			
			toBillingServ = document.getElementById("drugInputToBillingServiceItemCode").value;
			toBillingServ = (toBillingServ=="" || toBillingServ==null) ? '~~~~~~~~~~~~~~~~~~~~' : toBillingServ;

			frmCreateAmendBy = document.getElementById("drugInputCreatedAmendedby").value;
			frmCreateAmendBy = (frmCreateAmendBy=="" || frmCreateAmendBy==null) ? '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' : frmCreateAmendBy;
			
			toCreateAmendBy = document.getElementById("drugInputToCreatedAmendedby").value;
			toCreateAmendBy = (toCreateAmendBy=="" || toCreateAmendBy==null) ? '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~' : toCreateAmendBy;
			
			frmCreateAmendDate = document.getElementById("drugInputCreatedAmendedDate").value;
			frmCreateAmendDate = (frmCreateAmendDate=="" || frmCreateAmendDate==null) ? '01/01/1800' : convertDateFormat(frmCreateAmendDate);
			
			toCreateAmendDate = document.getElementById("drugInputToCreatedAmendedDate").value;
			toCreateAmendDate = (toCreateAmendDate=="" || toCreateAmendDate==null) ? '31/12/4712' : convertDateFormat(toCreateAmendDate);

		}
		if(reportType == "option3"){
			frmBillingServ = document.getElementById("consumableInputBillingServiceItemCode").value;
			frmBillingServ = (frmBillingServ=="" || frmBillingServ==null) ? '!!!!!!!!!!!!!!!!!!!!' : frmBillingServ;
			
			toBillingServ = document.getElementById("consumableInputToBillingServiceItemCode").value;
			toBillingServ = (toBillingServ=="" || toBillingServ==null) ? '~~~~~~~~~~~~~~~~~~~~' : toBillingServ;

			frmCreateAmendBy = document.getElementById("consumableInputCreatedAmendedby").value;
			frmCreateAmendBy = (frmCreateAmendBy=="" || frmCreateAmendBy==null) ? '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!' : frmCreateAmendBy;
			
			toCreateAmendBy = document.getElementById("consumableInputToCreatedAmendedby").value;
			toCreateAmendBy = (toCreateAmendBy=="" || toCreateAmendBy==null) ? '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~' : toCreateAmendBy;
			
			frmCreateAmendDate = document.getElementById("consumableInputCreatedAmendedDate").value;
			frmCreateAmendDate = (frmCreateAmendDate=="" || frmCreateAmendDate==null) ? '01/01/1800' : convertDateFormat(frmCreateAmendDate);
			
			toCreateAmendDate = document.getElementById("consumableInputToCreatedAmendedDate").value;
			toCreateAmendDate = (toCreateAmendDate=="" || toCreateAmendDate==null) ? '31/12/4712' : convertDateFormat(toCreateAmendDate);

		}
		
		var p_report_id = document.getElementById("p_report_id").value;
		var p_module_id = document.getElementById("p_module_id").value;
		
		// Retrieve the facility_id based on the reportType
		var reportType = document.getElementById("ReportType").value;
		var facility_id;

		if (reportType === "option1") {
			facility_id = document.getElementById("service_Facility_ID").value;
		} else if (reportType === "option2") {
			facility_id = document.getElementById("drugInput2FacilityID").value;
		} else if (reportType === "option3") {
			facility_id = document.getElementById("consumableInput2FacilityID").value;
		} else {
			facility_id = $("#facilityId").val(); // Default to this if reportType doesn't match
		}

		console.log("Facility ID before AJAX request: ", facility_id); // Log the facility_id
	
		var session_id;
		var pgm_date;
		$.ajax({
			type:"GET",
			url:"../jsp/TotBillForPeriodCommon.jsp",
			data:"func_mode=PriceListServices"+
				"&p_report_id="+p_report_id+
				"&param1="+frmCreateAmendBy+
				"&param2="+toCreateAmendBy+
				"&param3="+frmBillingServ+
				"&param4="+toBillingServ+
				"&param5="+frmCreateAmendDate+
				"&param6="+toCreateAmendDate+
				"&param7="+FrmCustCode+
				"&param8="+ToCustCode+
				"&param9="+FrmBillingGrp+
				"&param10="+ToBillingGrp+
				"&param11="+FrmBillingCls+
				"&param12="+ToBillingCls+
				"&param13="+frmEffDate+
				"&param14="+toEffDate+
				"&param15="+groupby+
				"&param16="+standardPrice+
				"&facility_id=" + facility_id, // Include facility_id here
				
			dataType:"text",
			async:false,
			success: function(data){
				var retVal = trimString(data).split(":::");
				if(retVal.length == 2){
					session_id = trimString(retVal[0]);
					pgm_date = trimString(retVal[1]);
					//alert("session_id: "+session_id+", pgm_date: "+pgm_date);
					$('#p_session_id').val(session_id);
					$('#p_pgm_date').val(pgm_date);
				}
				
			},
				error: function(data){
					 alert(data);
			}
		});	
	}
