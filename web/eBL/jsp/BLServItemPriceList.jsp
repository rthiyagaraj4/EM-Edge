<!DOCTYPE html>
<html style="background: #F7F7F7; margin:10px;">
<head>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
    <%
    /* String sStyle = (session.getAttribute("PREFERRED_STYLE") != null && !((String)session.getAttribute("PREFERRED_STYLE")).isEmpty()) ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyleBL.css";
    String locale = 	(String)session.getAttribute("LOCALE"); */
    String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
    %>
    <%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
    
    
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyleBL.css'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
    <script language='javascript' src='../js/BLServItemPriceList.js'></script>
	<script language='javascript' src='../../eCommon/js/jquery.js'></script>
    
   <%@ page import="java.net.URLDecoder, java.io.UnsupportedEncodingException" %>
    
    
	
    <%
    
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String serviceFacilityID = "";
    String p_user_name = (String) session.getValue("login_user");
    String servicePriceIndicator = "";
    String serviceStatus="";
    String serviceGroupBy="";
    String moduleId =request.getParameter("module_id");// "BL";
    if (moduleId == null) moduleId = "BL";
    String listRef = "PRICE_IND";
   
    String statuslistRef = "STATUS_IND";
    String groupBylistRef = "GROUP_BY";
    String facilityID = "";
    String facilityId = "";
    String locale = 	(String)session.getAttribute("LOCALE"); 
	 String languageId =locale; // "EN";
	String params           = request.getQueryString();
	System.out.println("params 303 =" + params);
	String facilityDecodedValue ="";
	String facilityRawValue = (String) session.getValue("facility_id");
	String reportServer	= (String) session.getValue( "report_server" ) ;
	System.err.println("reportServer: "+reportServer);
	 
	try {
		 facilityDecodedValue = URLDecoder.decode(facilityRawValue, "UTF-8");
		System.out.println("facilityDecodedValue: " + facilityDecodedValue);
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	String facility = facilityDecodedValue.replaceAll("<[^>]*>", "").trim();
	System.out.println("facility value: " + facility);
    
   
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    PreparedStatement pstmt1 = null;
    ResultSet rs1 = null;
    
    PreparedStatement pstmt2 = null;
    ResultSet rs2 = null;
    
    PreparedStatement pstmt3 = null;
    ResultSet rs3 = null;
    
    try {
        conn = ConnectionManager.getConnection(request);
        
        //sStyle 	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    	locale = 	(String)session.getAttribute("LOCALE");
        System.out.println("Locale = "+locale);
    	facilityId =   (String) session.getValue( "facility_id" ) ;
    	if(facilityId == null) facilityId="";
    	System.out.println("facilityId  "+facilityId);
    	String loginUser	= (String) session.getValue("login_user");
    	if(loginUser == null) loginUser="";
    	System.out.println("loginUser  "+loginUser);
    	
    	String str_module_id     =  request.getParameter("module_id");	
    	if(str_module_id == null) str_module_id="";
    	System.out.println("str_module_id  "+str_module_id);
        
        
        // Set serviceFacilityID and servicePriceIndicator
        serviceFacilityID = request.getParameter("service_Facility_ID");
        servicePriceIndicator = request.getParameter("PriceIndicator");
        serviceStatus = request.getParameter("status");
        serviceGroupBy = request.getParameter("GroupBy");
        
        facilityID=   (String) session.getValue( "facility_id" ) ;
    	/* System.out.println("facilityId in BLServItemPriceList.jsp::"+facilityID); */
    	    	
    	String decodedFacilityID = URLDecoder.decode(facilityID, "UTF-8");
    	System.out.println("Decoded facilityId: " + decodedFacilityID); 
    	System.err.println("p_user_name=" + p_user_name);
		if(!"".equals(p_user_name) && p_user_name != null)
			p_user_name = p_user_name.toUpperCase();
		
        // Prepare and execute first query for facilityid
        pstmt = conn.prepareStatement("SELECT a.acc_entity_name AS name, a.acc_entity_id AS id " +
                "FROM sy_acc_entity a, sm_facility_for_user b " +
                "WHERE b.facility_id = a.acc_entity_id " +
                "AND b.appl_user_id = UPPER(?) " +
                "ORDER BY a.acc_entity_name");
        pstmt.setString(1, p_user_name);
        rs = pstmt.executeQuery();
        System.err.println("rs=" + rs);
        
        // Prepare and execute second query priceindicator
        pstmt1 = conn.prepareStatement(
                "SELECT NVL(B.LIST_ELMT_LABEL, A.LIST_ELMT_LABEL) AS LIST_ELMT_LABEL, A.LIST_ELMT_VALUE " +
                "FROM SM_LIST_ITEM A LEFT JOIN SM_LIST_ITEM_DESC B " +
                "ON A.MODULE_ID = B.MODULE_ID AND A.LIST_REF = B.LIST_REF AND A.LIST_SRL_NO = B.LIST_SRL_NO " +
                "WHERE A.MODULE_ID = ? " +
                "AND A.LIST_REF = ? " +
                "AND UPPER(NVL(B.LANGUAGE_ID, ?)) = UPPER(?) " +
                "ORDER BY A.LIST_SRL_NO");
        pstmt1.setString(1, moduleId); 
        pstmt1.setString(2, listRef); 
        pstmt1.setString(3, languageId);
        pstmt1.setString(4, languageId);
        rs1 = pstmt1.executeQuery();
         System.out.println("rs1 =" + rs1);
     // Prepare and execute query for status 
        pstmt2 = conn.prepareStatement(
                "SELECT NVL(B.LIST_ELMT_LABEL, A.LIST_ELMT_LABEL) AS LIST_ELMT_LABEL, A.LIST_ELMT_VALUE " +
                "FROM SM_LIST_ITEM A LEFT JOIN SM_LIST_ITEM_DESC B " +
                "ON A.MODULE_ID = B.MODULE_ID AND A.LIST_REF = B.LIST_REF AND A.LIST_SRL_NO = B.LIST_SRL_NO " +
                "WHERE A.MODULE_ID = ? " +
                "AND A.LIST_REF = ? " +
                "AND UPPER(NVL(B.LANGUAGE_ID, ?)) = UPPER(?) " +
                "ORDER BY A.LIST_SRL_NO");
    		 
        pstmt2.setString(1, moduleId); 
        pstmt2.setString(2, statuslistRef); 
        pstmt2.setString(3, languageId);
        pstmt2.setString(4, languageId);
        rs2 = pstmt2.executeQuery();
        
     // Prepare and execute query for groupBy 
        pstmt3 = conn.prepareStatement(
                "SELECT NVL(B.LIST_ELMT_LABEL, A.LIST_ELMT_LABEL) AS LIST_ELMT_LABEL, A.LIST_ELMT_VALUE " +
                "FROM SM_LIST_ITEM A LEFT JOIN SM_LIST_ITEM_DESC B " +
                "ON A.MODULE_ID = B.MODULE_ID AND A.LIST_REF = B.LIST_REF AND A.LIST_SRL_NO = B.LIST_SRL_NO " +
                "WHERE A.MODULE_ID = ? " +
                "AND A.LIST_REF = ? " +
                "AND UPPER(NVL(B.LANGUAGE_ID, ?)) = UPPER(?) " +
                "ORDER BY A.LIST_SRL_NO");
    		 
        pstmt3.setString(1, moduleId); 
        pstmt3.setString(2, groupBylistRef); 
        pstmt3.setString(3, languageId);
        pstmt3.setString(4, languageId);
        rs3 = pstmt3.executeQuery();
        
        
        // Process result sets to generate serviceFacility and drugFacility JSON
        StringBuilder jsonBuilder = new StringBuilder();
        boolean flag = true;
        
        if (rs != null) {
            jsonBuilder.append("[");
            while (rs.next()) {
                if (!flag) {
                    jsonBuilder.append(",");
                }
                String id = rs.getString("id");
                String name = rs.getString("name");
                
                // varruct JSON object manually
                jsonBuilder.append("{\"value\":\"").append(id).append("\",\"label\":\"").append(name).append("\"}");
                
                flag = false;
            }
            jsonBuilder.append("]");
        }
        
        String serviceFacilityJSON = jsonBuilder.toString();
        String drugFacilityJSON = jsonBuilder.toString();
		String consumableFacilityJSON = jsonBuilder.toString();
        System.err.println("serviceFacilityJSON=" + serviceFacilityJSON);
        System.err.println("drugFacilityJSON=" + drugFacilityJSON); 
        
        // Process rs1 to generate PriceIndicator query JSON
        StringBuilder jsonBuilder2 = new StringBuilder();
        boolean flag2 = true;
        
        if (rs1 != null) {
            jsonBuilder2.append("[");
            while (rs1.next()) {
                if (!flag2) {
                    jsonBuilder2.append(",");
                }
                
                String LIST_ELMT_LABEL = rs1.getString("LIST_ELMT_LABEL");
                String LIST_ELMT_VALUE = rs1.getString("LIST_ELMT_VALUE");
                
                jsonBuilder2.append("{\"LIST_REF\":\"").append(listRef)
                .append("\",\"LIST_ELMT_LABEL\":\"").append(LIST_ELMT_LABEL)
                .append("\",\"LIST_ELMT_VALUE\":\"").append(LIST_ELMT_VALUE)
                .append("\"}");

                
                flag2 = false;
            }
            jsonBuilder2.append("]");
        }
        
        String ServicePriceIndicatorJSON = jsonBuilder2.toString();
        System.out.println("ServicePriceIndicatorJSON=" + ServicePriceIndicatorJSON); 
        
     // Process rs2 to generate serviceStatus and drugStatus query JSON
        StringBuilder jsonBuilder3 = new StringBuilder();
        boolean flag3 = true;
        
        if (rs2 != null) {
            jsonBuilder3.append("[");
            while (rs2.next()) {
                if (!flag3) {
                    jsonBuilder3.append(",");
                }
                
                String LIST_ELMT_LABEL = rs2.getString("LIST_ELMT_LABEL");
                String LIST_ELMT_VALUE = rs2.getString("LIST_ELMT_VALUE");
                
                jsonBuilder3.append("{\"LIST_REF\":\"").append(listRef)
                .append("\",\"LIST_ELMT_LABEL\":\"").append(LIST_ELMT_LABEL)
                .append("\",\"LIST_ELMT_VALUE\":\"").append(LIST_ELMT_VALUE)
                
                .append("\"}");

                
                flag3 = false;
            }
            jsonBuilder3.append("]");
        }
        
        String ServiceStatusJSON = jsonBuilder3.toString();
        String drugStatusJSON = jsonBuilder3.toString();
		String consumableStatusJSON = jsonBuilder3.toString();
        /* System.out.println("ServiceStatusJSON=" + ServiceStatusJSON);
        System.out.println("drugStatusJSON=" + drugStatusJSON); */
        
     // Process rs3 to generate groupBy query JSON
        StringBuilder jsonBuilder4 = new StringBuilder();
        boolean flag4 = true;
        
        if (rs3 != null) {
            jsonBuilder4.append("[");
            while (rs3.next()) {
                if (!flag4) {
                    jsonBuilder4.append(",");
                }
                
                String LIST_ELMT_LABEL = rs3.getString("LIST_ELMT_LABEL");
                String LIST_ELMT_VALUE = rs3.getString("LIST_ELMT_VALUE");
                
                jsonBuilder4.append("{\"LIST_REF\":\"").append(listRef)
                .append("\",\"LIST_ELMT_LABEL\":\"").append(LIST_ELMT_LABEL)
                .append("\",\"LIST_ELMT_VALUE\":\"").append(LIST_ELMT_VALUE)
                
                .append("\"}");

                
                flag4 = false;
            }
            jsonBuilder4.append("]");
        }
        
        String ServicegroupByJSON = jsonBuilder4.toString();
        /* System.out.println("ServicegroupByJSON=" + ServicegroupByJSON); */
        
        

	%>
    
    
    
    <script type="text/javascript" >
        // Embed the facilityId from JSP into JavaScript
        var facilityId = "<%= facilityId %>";
        console.log("Facility ID from Javascript:", facilityId);
        var facility = "<%= facility %>"; 
		 console.log("facility=",facility);
        var locale = "<%= locale %>";
        console.log("Locale from Javascript:", locale);
		
        
    </script>
    <script src="../js/BLServItemPriceList.js" type="text/javascript"></script>
    
        <script> 	
	     // Function to populate the ServiceFacilityID select element
       		
		
	function populateServiceFacilityID(serviceFacilityJSONOptions1) {
    var ServiceFacilityIDSelect = document.getElementById("service_Facility_ID");
    ServiceFacilityIDSelect.innerHTML = '';
    
    serviceFacilityJSONOptions1.forEach(function(option) {
        var selected = option.value === facility ? ' selected' : '';
        ServiceFacilityIDSelect.innerHTML += '<option value="' + option.value + '"' + selected + '>' + option.label + '</option>';
    });
}

	function populatedrugFacilityID(drugFacilityJSONOptions1) {
    var drugFacilityIDSelect = document.getElementById("drugInput2FacilityID");
    drugFacilityIDSelect.innerHTML = '';
    
    drugFacilityJSONOptions1.forEach(function(option) {
        var selected = option.value === facility ? ' selected' : '';
        drugFacilityIDSelect.innerHTML += '<option value="' + option.value + '"' + selected + '>' + option.label + '</option>';
    });
}

function populateconsumableFacilityID(consumableFacilityJSONOptions1) {
    var consumableFacilityIDSelect = document.getElementById("consumableInput2FacilityID");
    consumableFacilityIDSelect.innerHTML = '';
    
    consumableFacilityJSONOptions1.forEach(function(option) {
        var selected = option.value === facility ? ' selected' : '';
        consumableFacilityIDSelect.innerHTML += '<option value="' + option.value + '"' + selected + '>' + option.label + '</option>';
    });
}

       
       
        
 // Function to populate the ServicePriceIndicator select element
function populateServicePriceIndicator(ServicePriceIndicatorJSONOption1) {
    var ServicePriceIndicatorSelect = document.getElementById("PriceIndicator");
    ServicePriceIndicatorSelect.innerHTML = ''; // Clear existing options

    // Add the "All" option and select it by default
    var allOption = '<option value="A" selected>ALL</option>';
    ServicePriceIndicatorSelect.innerHTML += allOption;

    // Add other options from JSON
    ServicePriceIndicatorJSONOption1.forEach(function(option) {
        if (option.LIST_ELMT_VALUE !== 'A') { // Skip adding the "All" option again if it exists in JSON
            ServicePriceIndicatorSelect.innerHTML += '<option value="' + option.LIST_ELMT_VALUE + '">' + option.LIST_ELMT_LABEL + '</option>';
        }
    });

    // Add change event listener to the PriceIndicator dropdown
    ServicePriceIndicatorSelect.addEventListener('change', function() {
        updateGroupByOptions(ServicePriceIndicatorSelect.value);
    });
}
 // Function to populate the ServiceGroupBy select element
function populateServiceGroupBy(ServiceGroupByJSONOption1) {
    var ServiceGroupBySelect = document.getElementById("GroupBy");
    ServiceGroupBySelect.innerHTML = '';
    // Add the "Active" option and select it by default
    var groupByoption = '<option value="C" selected>Customer</option>';
    ServiceGroupBySelect.innerHTML += groupByoption;

    ServiceGroupByJSONOption1.forEach(function(option) {
        if (option.LIST_ELMT_VALUE !== 'C') { // Skip adding the "Active" option again if it exists in JSON
            ServiceGroupBySelect.innerHTML += '<option value="' + option.LIST_ELMT_VALUE + '">' + option.LIST_ELMT_LABEL + '</option>';
        }
    });
}

// Function to update the GroupBy options based on PriceIndicator selection
function updateGroupByOptions(priceIndicatorValue) {
    var ServiceGroupBySelect = document.getElementById("GroupBy");

    // Define the options for the GroupBy dropdown
    var options;
    if (priceIndicatorValue === 'S') { // Example condition for "Standard Price"
        options = [
			{ LIST_ELMT_VALUE: 'S', LIST_ELMT_LABEL: 'Service' },
            { LIST_ELMT_VALUE: 'C', LIST_ELMT_LABEL: 'Customer' }

        ];
        // Update the GroupBy dropdown with the new options
        populateServiceGroupBy(options);
        // Set the selected value to "Service"
        ServiceGroupBySelect.value = 'S';
    } else {
       /* options = [
			{ LIST_ELMT_VALUE: 'S', LIST_ELMT_LABEL: 'Service' },
            { LIST_ELMT_VALUE: 'C', LIST_ELMT_LABEL: 'Customer' }
           
        ];
        // Update the GroupBy dropdown with the new options
        populateServiceGroupBy(options);
        // Optionally, you can reset to a default value or keep it unchanged
        ServiceGroupBySelect.value = 'C'; // Default or initial value */
    }
}
    
	
	function populateServiceStatus(ServiceStatusJSONOption1) {
    var ServiceStatusSelect = document.getElementById("status");
    ServiceStatusSelect.innerHTML = '';

    ServiceStatusJSONOption1.forEach(function(option) {
        var isSelected = option.LIST_ELMT_VALUE === 'A' ? ' selected' : '';
        ServiceStatusSelect.innerHTML += '<option value="' + option.LIST_ELMT_VALUE + '"' + isSelected + '>' + option.LIST_ELMT_LABEL + '</option>';
    });
}

		
		function populatedrugStatus(drugStatusJSONOption1) {
       		    var drugStatusSelect = document.getElementById("drugInput1status");
       		    drugStatusSelect.innerHTML = ''; // Clear existing options
       		    // Add other options from JSON
       		    drugStatusJSONOption1.forEach(function(option) {
				var isSelected = option.LIST_ELMT_VALUE === 'A' ? ' selected' : '';
				drugStatusSelect.innerHTML += '<option value="' + option.LIST_ELMT_VALUE + '"' + isSelected + '>' + option.LIST_ELMT_LABEL + '</option>';

       		    });
       		}
			
		function populateconsumableStatus(consumableStatusJSONOption1) {
       		    var consumableStatusSelect = document.getElementById("consumableInput1status");
       		    consumableStatusSelect.innerHTML = ''; // Clear existing options
       		    // Add other options from JSON
       		    consumableStatusJSONOption1.forEach(function(option) {
       		     var isSelected = option.LIST_ELMT_VALUE === 'A' ? ' selected' : '';
				consumableStatusSelect.innerHTML += '<option value="' + option.LIST_ELMT_VALUE + '"' + isSelected + '>' + option.LIST_ELMT_LABEL + '</option>';

       		    });
       		}
       	
   	
  

     
   		 // Embedding selectOptionsJSON directly into JavaScript
   	   	 var serviceFacilityJSONOptions1 = <%= serviceFacilityJSON %>;
   	  	 var drugFacilityJSONOptions1 = <%= drugFacilityJSON %>;
		 var consumableFacilityJSONOptions1 = <%= consumableFacilityJSON %>;
   	  	 var ServicePriceIndicatorJSONOption1 = <%= ServicePriceIndicatorJSON %>;
   	 	 var ServiceStatusJSONOption1 = <%= ServiceStatusJSON %>;
   	 	 var drugStatusJSONOption1 = <%= drugStatusJSON %>;
		 var consumableStatusJSONOption1 = <%= consumableStatusJSON %>;
   	 	 var ServiceGroupByJSONOption1 = <%= ServicegroupByJSON %>;
		 
   	 	
   		 document.addEventListener("DOMContentLoaded", function() {
         populateServiceFacilityID(serviceFacilityJSONOptions1);
         populatedrugFacilityID(drugFacilityJSONOptions1);
         populateServicePriceIndicator(ServicePriceIndicatorJSONOptions1);
         populateServiceStatus(ServiceStatusJSONOption1);
         populatedrugStatus(drugStatusJSONOption1);
         populateServiceGroupBy(ServiceGroupByJSONOption1);
       
         
     });
    
	  flatpickr("#EffectiveDate", {
            dateFormat: "d-m-Y H:i", // Format the date as dd-mm-yyyy 00:00
            enableTime: true, // Enable time picker
            noCalendar: false, // Ensure calendar is visible
            defaultHour: 0, // Set default hour to 00
            defaultMinute: 0, // Set default minute to 00
            plugins: [new TimePlugin({})] // Use TimePlugin for time selection
        });

		
    
   
	    

        	function showAdditionalInputs() {
	            var reportType = document.getElementById("ReportType").value;
	            var parentDiv = document.getElementById("reportTypeContainer");

            // Remove all existing additional inputs
            var existingInputs = parentDiv.getElementsByClassName("additionalInput");
            while (existingInputs.length > 0) {
                parentDiv.removeChild(existingInputs[0]);
            }
            
         // Remove existing form if it exists
            var existingForm = document.getElementById("reportFormOption1");
            if (existingForm) {
                parentDiv.removeChild(existingForm);
            }
            
         // Remove existing submit button if it exists
            var existingSubmitButton = parentDiv.querySelector('button[type="submit"]');
            if (existingSubmitButton) {
                parentDiv.removeChild(existingSubmitButton.parentNode); 
            }

			
            
            if (reportType === "option1") {
            	$('#p_report_id').val("BLRPRLST");
            	var form = document.createElement('form');
                form.id = 'reportFormOption1';
                form.method = 'POST';
                form.action = '../../eBL/jsp/BLServItemReportOptions.jsp'; 
            	
                var serviceInput1 = document.createElement('div');
                serviceInput1.className = 'form-input additionalInput';
				serviceInput1.style.marginBottom = "10px";
                serviceInput1.innerHTML = '<select class="inputselect"  style="margin-right: 10px"; name="PriceIndicator" id="PriceIndicator" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value); PriceIndicatorOnChange(event); " >' +
                                          
                                          '</select>' +
                                          '<label class="label-select" for="PriceIndicator"><fmt:message key="eBL.PriceIndicator.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(serviceInput1);
             	// Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof ServicePriceIndicatorJSONOption1 !== 'undefined') { // Check if selectOptions is available
                	populateServicePriceIndicator(ServicePriceIndicatorJSONOption1);
                } else {
                  console.error("ServicePriceIndicatorJSONOption1 variable not available from server-side script.");
                }

                var serviceInput2 = document.createElement('div');
                serviceInput2.className = "form-input additionalInput";
                serviceInput2.innerHTML = '<select class="inputselect" style="margin-right: 10px"; name="status" id="status" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                        
                                          '</select>' +
                                          '<label class="label-select" for="status"><fmt:message key="eBL.Status.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(serviceInput2);
             
                // Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof ServiceStatusJSONOption1 !== 'undefined') { // Check if selectOptions is available
                	populateServiceStatus(ServiceStatusJSONOption1);
                } else {
                  console.error("ServiceStatusJSONOption1 variable not available from server-side script.");
                }
				
                var serviceInput3 = document.createElement('div');
                serviceInput3.className = "form-input additionalInput";
                serviceInput3.innerHTML = '<select class="inputselect" style="margin-right: 10px"; name="service_Facility_ID" id="service_Facility_ID" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);">' +                  
                                           '</select>' +
                                           '<label class="label-select" for="service_Facility_ID"><fmt:message key="eBL.FacilityID.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(serviceInput3);

                // Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof serviceFacilityJSONOptions1 !== 'undefined') { // Check if selectOptions is available
                  populateServiceFacilityID(serviceFacilityJSONOptions1);
                } else {
                  console.error("serviceFacilityJSONOptions1 variable not available from server-side script.");
                }

                var serviceInput4 = document.createElement('div');
                serviceInput4.className = "form-input additionalInput";
                serviceInput4.innerHTML = '<select class="inputselect" name="GroupBy" id="GroupBy" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                          
                                          '</select>' +
                                          '<label class="label-select" for="GroupBy"><fmt:message key="eBL.GroupBy.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(serviceInput4);
             // Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof ServiceGroupByJSONOption1 !== 'undefined') { // Check if selectOptions is available
                	populateServiceGroupBy(ServiceGroupByJSONOption1);
                } else {
                  console.error("ServiceGroupByJSONOption1 variable not available from server-side script.");
                }

                var serviceInput5 = document.createElement('div');
                serviceInput5.className = "form-input additionalInput"; 
                serviceInput5.innerHTML = '<input style="margin-top: 16px; width: 15px; height: 12px;" class="checkboxinput" type="checkbox" id="StandardPrice" name="StandardPrice" disabled>' +
                                          '<label style="font-family: Segoe UI, Regular; font-size: 14px; color: #171717;" class="checkboxlabel" for="StandardPrice"><fmt:message key="eBL.StandardPrice.label" bundle="${bl_labels}"/></label>';

                parentDiv.appendChild(serviceInput5);

                // Creating fieldset for 'From' section
                var fieldsetFrom = document.createElement('fieldset');
				fieldsetFrom.style.border = '1px solid #DADCE0';
				fieldsetFrom.style.width =  '45%';
				fieldsetFrom.style.marginRight = '10px'; 
                fieldsetFrom.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var legendFrom = document.createElement('legend');
                legendFrom.innerHTML = '<label for="From"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/></label>';
                fieldsetFrom.appendChild(legendFrom);

                // Create container for inputFrom and input1From
                var containerOne = document.createElement('div');
                containerOne.className = "flexcontainerone";
								
				// Create inputFrom (BillingServiceItemCode)
				var inputFrom = document.createElement('div');
				inputFrom.className = "form-input additionalInput";
				inputFrom.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="BillingServiceItemCode" name="BillingServiceItemCode" onblur="handleBlur(event);validateInputs(2);" >' +
					'<label class="floating-label" for="BillingServiceItemCode"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';
				containerOne.appendChild(inputFrom);

				// User input
				var isbillingPopupShown = false; // Flag to track if the popup is shown
				var billingServiceInput = inputFrom.querySelector('#BillingServiceItemCode');
				var searchIconFrom = inputFrom.querySelector('#fromBillingService');

				// Function to handle blur event
				function handleBlurPopup() {
					var inputValue = billingServiceInput.value.trim();
					if (inputValue !== '' && !isbillingPopupShown) {
						showPopup('fromBillingService', inputValue);
						isbillingPopupShown = true; // Mark popup as shown
					}
				}

				// Event listener for 'From' Billing Service search icon
				searchIconFrom.addEventListener('click', function() {
					var inputValue = billingServiceInput.value.trim();
					showPopup('fromBillingService', inputValue); 
				});
 

				// Event listener for input field
				billingServiceInput.addEventListener('input', function() {
					isbillingPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingServiceItemCode' input keydown event
				billingServiceInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = billingServiceInput.value.trim();
						if (inputValue !== '' && !isbillingPopupShown) {
							showPopup('fromBillingService', inputValue); 
							isbillingPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				billingServiceInput.addEventListener('blur', handleBlurPopup);

				// Reset isbillingPopupShown when focus is on the input field again
				billingServiceInput.addEventListener('focus', function() {
					isbillingPopupShown = false;
				});

              

             // Create input1From (CustomerCode)
                var input1From = document.createElement('div');
                input1From.className = "form-input additionalInput";
                input1From.innerHTML = '<input class="floating-input" style="width: 330px;" type="text" placeholder="" id="CustomerCode" name="CustomerCode" onblur="handleBlur(event);" >' +
                    '<label class="floating-label" for="CustomerCode"><fmt:message key="eBL.CustomerCode.label" bundle="${bl_labels}"/></label>' +
                    '<button class="search-icon" type="button" id="fromCustomerCode" >' +
                        '<span class="mdi mdi-magnify"></span>' +
                    '</button>';

				containerOne.appendChild(input1From);

				// User input
				var isPopupShown = false; // Flag to track if the popup is shown
				var CustomerCodeInput = input1From.querySelector('#CustomerCode');
				var searchIconFrom = input1From.querySelector('#fromCustomerCode');

				// Function to handle blur event
				function handleBlurPopupCustomerCode() {
					var inputValue = CustomerCodeInput.value.trim();
					if (inputValue !== '' && !isPopupShown) {
						showPopup('fromCustomerCode', inputValue);
						isPopupShown = true; // Mark popup as shown
					}
				}

				// Event listener for 'From' search icon
				searchIconFrom.addEventListener('click', function() {
					var inputValue = CustomerCodeInput.value.trim();
					showPopup('fromCustomerCode', inputValue); 
					
				});

				// Event listener for input field
				CustomerCodeInput.addEventListener('input', function() {
					isPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'CustomerCode' input keydown event
				CustomerCodeInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = CustomerCodeInput.value.trim();
						if (inputValue !== '' && !isPopupShown) {
							showPopup('fromCustomerCode', inputValue); 
							isPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				CustomerCodeInput.addEventListener('blur', handleBlurPopupCustomerCode);

				// Reset isPopupShown when focus is on the input field again
				CustomerCodeInput.addEventListener('focus', function() {
					isPopupShown = false;
				});


                // Append containerOne to fieldsetFrom
                fieldsetFrom.appendChild(containerOne);
                
                // Create container for input2From, input3From, input4From, and input5From
                var containerTwo = document.createElement('div');
                containerTwo.className = "flexcontainerone";

               // Create input2From (BillingGroup)
				var input2FromBilling = document.createElement('div');
				input2FromBilling.className = "form-input additionalInput";
				input2FromBilling.innerHTML = '<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="BillingGroupFrom" name="BillingGroupFrom" onblur="handleBlur(event);validateInputs(3);">' +
					'<label class="floating-label" for="BillingGroupFrom"><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromBillingGroup">' +
						'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerTwo.appendChild(input2FromBilling);

				// User input
				var isbillinggroupPopupShown = false; // Flag to track if the popup is shown
				var BillingGroupInput = input2FromBilling.querySelector('#BillingGroupFrom');
				var searchIconFrom = input2FromBilling.querySelector('#fromBillingGroup');

				// Function to handle blur event
				function handleBlurPopupBillingGroup() {
					var inputValue = BillingGroupInput.value.trim();
					if (inputValue !== '' && !isbillinggroupPopupShown) {
						showPopup('fromBillingGroup', inputValue);
						isbillinggroupPopupShown = true; // Mark popup as shown
					}
				}

				// Event listener for 'From' Billing Group search icon
				searchIconFrom.addEventListener('click', function() {
					var inputValue = BillingGroupInput.value.trim();
					showPopup('fromBillingGroup', inputValue); 
				});

				// Event listener for input field
				BillingGroupInput.addEventListener('input', function() {
					isbillinggroupPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingGroupFrom' input keydown event
				BillingGroupInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = BillingGroupInput.value.trim();
						if (inputValue !== '' && !isbillinggroupPopupShown) {
							showPopup('fromBillingGroup', inputValue); 
							isbillinggroupPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				BillingGroupInput.addEventListener('blur', handleBlurPopupBillingGroup);

				// Reset isbillinggroupPopupShown when focus is on the input field again
				BillingGroupInput.addEventListener('focus', function() {
					isbillinggroupPopupShown = false;
				});


				
				// Create input3From (BillingClass)
				var input3From = document.createElement('div');
				input3From.className = "form-input additionalInput";
				input3From.innerHTML = 
					'<input class="floating-input" style="width: 155px;" type="text" placeholder="" id="BillingClass" name="BillingClass" >' +
					'<label class="floating-label" for="BillingClass"><fmt:message key="eBL.BillingClass.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromBillingClass">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerTwo.appendChild(input3From);

				// User input
				var isbillingclassPopupShown = false; // Flag to track if the popup is shown
				var BillingClassInput = input3From.querySelector('#BillingClass');
				var searchIconFrom = input3From.querySelector('#fromBillingClass');

				// Function to handle blur event
				function handleBlurBillingClass() {
					var inputValue = BillingClassInput.value.trim();
					if (inputValue !== '' && !isbillingclassPopupShown) {
						showPopup('fromBillingClass', inputValue);
						isbillingclassPopupShown = true; // Mark popup as shown
					}
				}

				// Event listener for 'From' Billing Class search icon
				searchIconFrom.addEventListener('click', function() {
					var inputValue = BillingClassInput.value.trim();
					showPopup('fromBillingClass', inputValue); 
				});

				// Event listener for input field
				BillingClassInput.addEventListener('input', function() {
					isbillingclassPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingClass' input keydown event
				BillingClassInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = BillingClassInput.value.trim();
						if (inputValue !== '' && !isbillingclassPopupShown) {
							showPopup('fromBillingClass', inputValue); 
							isbillingclassPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				BillingClassInput.addEventListener('blur', handleBlurBillingClass);

				// Reset isbillingclassPopupShown when focus is on the input field again
				BillingClassInput.addEventListener('focus', function() {
					isbillingclassPopupShown = false;
				});

                // Create input4From (EffectiveDate)
                var input4From = document.createElement('div');
                input4From.className = "form-input additionalInput";
		input4From.innerHTML = '<input class="floating-input datetime-local" style="width: 160px;" type="datetime-local" id="EffectiveDate" name="EffectiveDate" onblur="dateValidation(1);">' +
                                       '<label class="floating-label" for="EffectiveDate"><fmt:message key="eBL.EffectiveDate.label" bundle="${bl_labels}"/></label>';
                containerTwo.appendChild(input4From);

                // Append containerTwo to fieldsetFrom
                fieldsetFrom.appendChild(containerTwo);

                // Create container for input5From
                var containerThree = document.createElement('div');
                containerThree.className = "flexcontainerthree";

				// Create input5From (CreatedAmendedby)
				var input5From = document.createElement('div');
				input5From.className = "form-input additionalInput";
				input5From.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="CreatedAmendedby" name="CreatedAmendedby" onblur="validateInputs(5);">' +
					'<label class="floating-label" for="CreatedAmendedby"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerThree.appendChild(input5From);

				// User input
				var isCreatedAmendedbyInputChanged = false; // Rename this if you need to track input changes
				var isCreatedAmendedbyPopupShown = false; // Add a flag to track if the popup is shown
				var CreatedAmendedbyInput = input5From.querySelector('#CreatedAmendedby');
				var searchIconFrom = input5From.querySelector('#fromAmendedby');

				// Function to handle blur event
				function handleBlurPopupCreatedAmendedby() {
					var inputValue = CreatedAmendedbyInput.value.trim();
					if (inputValue !== '' && !isCreatedAmendedbyPopupShown) {
						showPopup('fromAmendedby', inputValue);
						isCreatedAmendedbyPopupShown = true; // Mark popup as shown
					}
					isCreatedAmendedbyInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'From' CreatedAmendedby search icon
				searchIconFrom.addEventListener('click', function() {
					var inputValue = CreatedAmendedbyInput.value.trim();
					showPopup('fromAmendedby', inputValue);
				});

				// Event listener for input field
				CreatedAmendedbyInput.addEventListener('input', function() {
					isCreatedAmendedbyInputChanged = true; // Track input changes if needed
					isCreatedAmendedbyPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'CreatedAmendedby' input keydown event
				CreatedAmendedbyInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = CreatedAmendedbyInput.value.trim();
						if (inputValue !== '' && !isCreatedAmendedbyPopupShown) {
							showPopup('fromAmendedby', inputValue);
							isCreatedAmendedbyPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				CreatedAmendedbyInput.addEventListener('blur', handleBlurPopupCreatedAmendedby);

				// Reset isCreatedAmendedbyPopupShown when focus is on the input field again
				CreatedAmendedbyInput.addEventListener('focus', function() {
					isCreatedAmendedbyPopupShown = false;
				});

				
                var input6From = document.createElement('div');
                input6From.className = "form-input additionalInput";
                input6From.innerHTML = '<input class="floating-input datetime-local" style="width: 155px;" type="datetime-local" placeholder="" id="CreatedAmendedDate" name="CreatedAmendedDate" onblur="dateValidation(3);">' +
                                       '<label class="floating-label" for="CreatedAmendedDate"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
                containerThree.appendChild(input6From);

                // Append containerTwo to fieldsetFrom
                fieldsetFrom.appendChild(containerThree);

                // Append fieldsetFrom to parentDiv or wherever you need to add it
                parentDiv.appendChild(fieldsetFrom);
                
                

                // Creating fieldset for 'To' section
                var fieldsetTo = document.createElement('fieldset');
				fieldsetTo.style.border = '1px solid #DADCE0';
                fieldsetTo.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var legendTo = document.createElement('legend');
                legendTo.innerHTML = '<label for="To"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/></label>';
                fieldsetTo.appendChild(legendTo);

                // Create container for inputTo and input1To
                var containerOneTo = document.createElement('div');
                containerOneTo.className = "flexcontainerone";

							   // Create inputTo (BillingServiceItemCodeTo)
				var inputTo = document.createElement('div');
				inputTo.className = "form-input additionalInput";
				inputTo.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="BillingServiceItemCodeTo" name="BillingServiceItemCodeTo">' +
					'<label class="floating-label" for="BillingServiceItemCodeTo"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';    
				containerOneTo.appendChild(inputTo);

				// User input
				//var isBillingServiceItemCodeToInputChanged = false;
				var isBillingServiceItemCodeToPopupShown = false; // Add a flag to track if the popup is shown
				var BillingServiceItemCodeToInput = inputTo.querySelector('#BillingServiceItemCodeTo');
				var searchIconTo = inputTo.querySelector('#toBillingService');

				// Function to handle blur event
				function handleBlurPopupBillingServiceTo() {
					var inputValue = BillingServiceItemCodeToInput.value.trim();
					if (inputValue !== '' && !isBillingServiceItemCodeToPopupShown) {
						showPopup('toBillingService', inputValue);
						isBillingServiceItemCodeToPopupShown = true; // Mark popup as shown
					}
					//isBillingServiceItemCodeToInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Billing Service search icon
				searchIconTo.addEventListener('click', function() {
					var inputValue = BillingServiceItemCodeToInput.value.trim();
					showPopup('toBillingService', inputValue);
				});

				// Event listener for input field
				BillingServiceItemCodeToInput.addEventListener('input', function() {
					//isBillingServiceItemCodeToInputChanged = true; // Track input changes if needed
					isBillingServiceItemCodeToPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingServiceItemCodeTo' input keydown event
				BillingServiceItemCodeToInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = BillingServiceItemCodeToInput.value.trim();
						if (inputValue !== '' && !isBillingServiceItemCodeToPopupShown) {
							showPopup('toBillingService', inputValue);
							isBillingServiceItemCodeToPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				BillingServiceItemCodeToInput.addEventListener('blur', handleBlurPopupBillingServiceTo);

				// Reset isBillingServiceItemCodeToPopupShown when focus is on the input field again
				BillingServiceItemCodeToInput.addEventListener('focus', function() {
					isBillingServiceItemCodeToPopupShown = false;
				});

				
				
				
				
              // Create input1To (CustomerCodeTo)
				var input1To = document.createElement('div');
				input1To.className = "form-input additionalInput";
				input1To.innerHTML = 
					'<input class="floating-input" style="width: 340px;" type="text" placeholder="" id="CustomerCodeTo" name="CustomerCodeTo" ">' +
					'<label class="floating-label" for="CustomerCodeTo"><fmt:message key="eBL.CustomerCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toCustomerCode">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				// Append input1To to containerOneTo
				containerOneTo.appendChild(input1To);

				// User input
				var isCustomerCodeToInputChanged = false;
				var isCustomerCodeToPopupShown = false; // Add a flag to track if the popup is shown
				var CustomerCodeToInput = input1To.querySelector('#CustomerCodeTo');
				var searchIconTo = input1To.querySelector('#toCustomerCode');

				// Function to handle blur event
				function handleBlurPopupCustomerCodeTo() {
					var inputValue = CustomerCodeToInput.value.trim();
					if (inputValue !== '' && !isCustomerCodeToPopupShown) {
						showPopup('toCustomerCode', inputValue);
						isCustomerCodeToPopupShown = true; // Mark popup as shown
					}
					isCustomerCodeToInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Customer Code search icon
				searchIconTo.addEventListener('click', function() {
					var inputValue = CustomerCodeToInput.value.trim();
					showPopup('toCustomerCode', inputValue);
				});

				// Event listener for input field
				CustomerCodeToInput.addEventListener('input', function() {
					isCustomerCodeToInputChanged = true; // Track input changes if needed
					isCustomerCodeToPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'CustomerCodeTo' input keydown event
				CustomerCodeToInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = CustomerCodeToInput.value.trim();
						if (inputValue !== '' && !isCustomerCodeToPopupShown) {
							showPopup('toCustomerCode', inputValue);
							isCustomerCodeToPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				CustomerCodeToInput.addEventListener('blur', handleBlurPopupCustomerCodeTo);

				// Reset isCustomerCodeToPopupShown when focus is on the input field again
				CustomerCodeToInput.addEventListener('focus', function() {
					isCustomerCodeToPopupShown = false;
				});

				

				// Append containerOneTo to fieldsetTo
				fieldsetTo.appendChild(containerOneTo);

				// Initialize containerTwoTo for further use
				var containerTwoTo = document.createElement('div');
				containerTwoTo.className = "flexcontainerone";


								/// Create input1ToBilling (BillingGroupTo)
				var input1ToBilling = document.createElement('div');
				input1ToBilling.className = "form-input additionalInput";
				input1ToBilling.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="BillingGroupTo" name="BillingGroupTo" onblur="handleBlur(event);">' +
					'<label class="floating-label" for="BillingGroupTo"><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toBillingGroup">' +
						'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerTwoTo.appendChild(input1ToBilling);

				// User input
				var isBillingGroupToInputChanged = false;
				var isBillingGroupToPopupShown = false; // Add a flag to track if the popup is shown
				var BillingGroupToInput = input1ToBilling.querySelector('#BillingGroupTo');
				var searchIconToBilling = input1ToBilling.querySelector('#toBillingGroup');

				// Function to handle blur event
				function handleBlurPopupBillingGroupTo() {
					var inputValue = BillingGroupToInput.value.trim();
					if (inputValue !== '' && !isBillingGroupToPopupShown) {
						showPopup('toBillingGroup', inputValue);
						isBillingGroupToPopupShown = true; // Mark popup as shown
					}
					isBillingGroupToInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Billing Group search icon
				searchIconToBilling.addEventListener('click', function() {
					var inputValue = BillingGroupToInput.value.trim();
					showPopup('toBillingGroup', inputValue);
				});

				// Event listener for input field
				BillingGroupToInput.addEventListener('input', function() {
					isBillingGroupToInputChanged = true; // Track input changes if needed
					isBillingGroupToPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingGroupTo' input keydown event
				BillingGroupToInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = BillingGroupToInput.value.trim();
						if (inputValue !== '' && !isBillingGroupToPopupShown) {
							showPopup('toBillingGroup', inputValue);
							isBillingGroupToPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				BillingGroupToInput.addEventListener('blur', handleBlurPopupBillingGroupTo);

				// Reset isBillingGroupToPopupShown when focus is on the input field again
				BillingGroupToInput.addEventListener('focus', function() {
					isBillingGroupToPopupShown = false;
				});

				
							   // Create input2To (BillingClassTo)
				var input2To = document.createElement('div');
				input2To.className = "form-input additionalInput";
				input2To.innerHTML = 
					'<input class="floating-input" style="width: 155px;" type="text" placeholder="" id="BillingClassTo" name="BillingClassTo" >' +
					'<label class="floating-label" for="BillingClassTo"><fmt:message key="eBL.BillingClass.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toBillingClass">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerTwoTo.appendChild(input2To);

				// User input
				
				var isBillingClassToPopupShown = false; // Add a flag to track if the popup is shown
				var BillingClassToInput = input2To.querySelector('#BillingClassTo');
				var searchIconToBillingClass = input2To.querySelector('#toBillingClass');

				// Function to handle blur event
				function handleBlurPopupBillingClassTo() {
					var inputValue = BillingClassToInput.value.trim();
					if (inputValue !== '' && !isBillingClassToPopupShown) {
						showPopup('toBillingClass', inputValue);
						isBillingClassToPopupShown = true; // Mark popup as shown
					}
			
				}

				// Event listener for 'To' Billing Class search icon
				searchIconToBillingClass.addEventListener('click', function() {
					var inputValue = BillingClassToInput.value.trim();
					showPopup('toBillingClass', inputValue);
				});

				// Event listener for input field
				BillingClassToInput.addEventListener('input', function() {
					
					isBillingClassToPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'BillingClassTo' input keydown event
				BillingClassToInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = BillingClassToInput.value.trim();
						if (inputValue !== '' && !isBillingClassToPopupShown) {
							showPopup('toBillingClass', inputValue);
							isBillingClassToPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				BillingClassToInput.addEventListener('blur', handleBlurPopupBillingClassTo);

				// Reset isBillingClassToPopupShown when focus is on the input field again
				BillingClassToInput.addEventListener('focus', function() {
					isBillingClassToPopupShown = false;
				});


                var input3To = document.createElement('div');
                input3To.className = "form-input additionalInput";
                input3To.innerHTML = '<input class="floating-input datetime-local" style="width: 170px;" type="datetime-local" placeholder="" id="EffectiveDateTo" name="EffectiveDateTo" onblur="dateValidation(1);">' +
                                     '<label class="floating-label" for="EffectiveDateTo"><fmt:message key="eBL.EffectiveDate.label" bundle="${bl_labels}"/></label>';
                containerTwoTo.appendChild(input3To);

                fieldsetTo.appendChild(containerTwoTo);

                // Create container for input5From
                var containerThreeTo = document.createElement('div');
                containerThreeTo.className = "flexcontainerthree";

								// Create input5To (CreatedAmendedbyTo)
				var input5To = document.createElement('div');
				input5To.className = "form-input additionalInput";
				input5To.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="CreatedAmendedbyTo" name="CreatedAmendedbyTo" >' +
					'<label class="floating-label" for="CreatedAmendedbyTo"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				containerThreeTo.appendChild(input5To);

				// User input
				var isCreatedAmendedbyToInputChanged = false;
				var isCreatedAmendedbyToPopupShown = false; // Add a flag to track if the popup is shown
				var CreatedAmendedbyToInput = input5To.querySelector('#CreatedAmendedbyTo');
				var searchIconToAmendedby = input5To.querySelector('#toAmendedby');

				// Function to handle blur event
				function handleBlurPopupCreatedAmendedbyTo() {
					var inputValue = CreatedAmendedbyToInput.value.trim();
					if (inputValue !== '' && !isCreatedAmendedbyToPopupShown) {
						showPopup('toAmendedby', inputValue);
						isCreatedAmendedbyToPopupShown = true; // Mark popup as shown
					}
					isCreatedAmendedbyToInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Amendedby search icon
				searchIconToAmendedby.addEventListener('click', function() {
					var inputValue = CreatedAmendedbyToInput.value.trim();
					showPopup('toAmendedby', inputValue);
				});

				// Event listener for input field
				CreatedAmendedbyToInput.addEventListener('input', function() {
					isCreatedAmendedbyToInputChanged = true; // Track input changes if needed
					isCreatedAmendedbyToPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'CreatedAmendedbyTo' input keydown event
				CreatedAmendedbyToInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = CreatedAmendedbyToInput.value.trim();
						if (inputValue !== '' && !isCreatedAmendedbyToPopupShown) {
							showPopup('toAmendedby', inputValue);
							isCreatedAmendedbyToPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				CreatedAmendedbyToInput.addEventListener('blur', handleBlurPopupCreatedAmendedbyTo);

				// Reset isCreatedAmendedbyToPopupShown when focus is on the input field again
				CreatedAmendedbyToInput.addEventListener('focus', function() {
					isCreatedAmendedbyToPopupShown = false;
				});

				
                
                var input6To = document.createElement('div');
                input6To.className = "form-input additionalInput";
                input6To.innerHTML = '<input class="floating-input datetime-local" style="width: 155px;" type="datetime-local" placeholder="" id="CreatedAmendedDateTo" name="CreatedAmendedDateTo" onblur="dateValidation(2);dateValidation(4);">' +
                                     '<label class="floating-label" for="CreatedAmendedDateTo"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
                containerThreeTo.appendChild(input6To);

                // Append containerTwo to fieldsetFrom
                fieldsetTo.appendChild(containerThreeTo);

                parentDiv.appendChild(fieldsetTo);
                
			
				
/*                

                var buttonContainer = document.createElement('div');
                buttonContainer.className = 'button-container';
                
             // Create the submit button
                var SubmitButton = document.createElement('button');
                SubmitButton.type = 'submit'; 
                SubmitButton.className = 'btn btn-primary';
                SubmitButton.textContent = 'Submit';

                SubmitButton.addEventListener('click', function(event) {
					
                    event.preventDefault();
                    var customerCodeInput = document.getElementById('CustomerCode');
                    
                    /* if (customerCodeInput) {
                        var customerCodeValue = customerCodeInput.value.trim();
                        
                        if (customerCodeValue === '') {
                            alert('BLServItemPriceList.jsp Customer Code is required.');
                            return; 
                        }
						
                    } 
                    alert('Submit button clicked! Form is valid.');
                    getSessionID();
					
					reportPopup("Report Options");
					
                   // form.submit(); 
					
                });
                    
                    

                // Create the button container
                var buttonContainer = document.createElement('div');
                buttonContainer.className = 'button-container';

                // Append the submit button to the button container
                buttonContainer.appendChild(SubmitButton);

                // Append the button container to the form
                form.appendChild(buttonContainer);

                // Append the form to the parentDiv
                parentDiv.appendChild(form); */

              

            } else if (reportType === "option2") {

            	$('#p_report_id').val("BLRITLST");
            	$('#price_ind').val("N");			//Price Indicator value is "N" for Drugs based on the Item Price List -- Item type
            	var drugInput1 = document.createElement('div');
            	drugInput1.className = "form-input additionalInput";
            	drugInput1.innerHTML = '<select class="inputselect"  style="margin-right: 15px"; name="drugInput1status" id="drugInput1status" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                          '</select>' +
                                          '<label class="label-select" for="drugInput1status"><fmt:message key="eBL.Status.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(drugInput1);
                
                // Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof drugStatusJSONOption1 !== 'undefined') { // Check if selectOptions is available
                	populatedrugStatus(drugStatusJSONOption1);
                } else {
                  console.error("drugStatusJSONOption1 variable not available from server-side script.");
                }
				
                var drugInput2 = document.createElement('div');
                drugInput2.className = "form-input additionalInput";
                drugInput2.innerHTML = '<select class="inputselect" style="margin-right: 10px"; name="drugInput2FacilityID" id="drugInput2FacilityID" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                          
                                          '</select>' +
                                          '<label class="label-select" for="drugInput2FacilityID"><fmt:message key="eBL.FacilityID.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(drugInput2);
                // Assuming you have a way to access the server-side generated selectOptions variable
                if (typeof drugFacilityJSONOptions1 !== 'undefined') { // Check if selectOptions is available
                  populatedrugFacilityID(drugFacilityJSONOptions1);
                } else {
                  console.error("drugFacilityJSONOptions1 variable not available from server-side script.");
                }
                
               
                
                var drugInput3 = document.createElement('div');
                drugInput3.className = "form-input additionalInput "; 
				drugInput3.style.marginBottom = "10px";
                drugInput3.innerHTML = '<input style="margin-top: 16px; width: 15px; height: 12px;" class="checkboxinput" type="checkbox" id="checkboxByNameTradeBatch" name="checkboxByNameTradeBatch">' +
                                          '<label style="font-family: Segoe UI, Regular; font-size: 14px; color: #171717;" class="checkboxlabel" for="ByNameTradeBatch"><fmt:message key="eBL.TradeNameorBatch.label" bundle="${bl_labels}"/></label>';

                parentDiv.appendChild(drugInput3);
                
            	// Creating fieldset for 'drugInputFrom' section
                var drugInputfieldsetFrom = document.createElement('fieldset');
				drugInputfieldsetFrom.style.border = '1px solid #DADCE0';
				drugInputfieldsetFrom.style.width =  '48%';
				drugInputfieldsetFrom.style.marginRight = '10px';
				drugInputfieldsetFrom.style.paddingBottom = '50px';
                drugInputfieldsetFrom.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var drugInputlegendFrom = document.createElement('legend');
                drugInputlegendFrom.innerHTML = '<label for="From"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/></label>';
                drugInputfieldsetFrom.appendChild(drugInputlegendFrom);

                // Create container for drugInputFrom and drugInput1From
                var drugInputcontainerOne = document.createElement('div');
                drugInputcontainerOne.className = "flexcontainerone";

							   // Create drugInputFrom (drugInputBillingServiceItemCode)
				var drugInputFrom = document.createElement('div');
				drugInputFrom.className = "form-input additionalInput";
				drugInputFrom.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="drugInputBillingServiceItemCode" name="drugInputBillingServiceItemCode" onblur="drugvalidateInputs(2);">' +
					'<label class="floating-label" for="drugInputBillingServiceItemCode"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromDrugBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				drugInputcontainerOne.appendChild(drugInputFrom);

				// User input
				var isDrugInputChanged = false;
				var isDrugPopupShown = false; // Add a flag to track if the popup is shown
				var drugInputBillingServiceInput = drugInputFrom.querySelector('#drugInputBillingServiceItemCode');
				var searchIconFromDrugBillingService = drugInputFrom.querySelector('#fromDrugBillingService');

				// Function to handle blur event
				function handleBlurPopupDrugInput() {
					var inputValue = drugInputBillingServiceInput.value.trim();
					if (inputValue !== '' && !isDrugPopupShown) {
						showPopup('fromDrugBillingService', inputValue);
						isDrugPopupShown = true; // Mark popup as shown
					}
					isDrugInputChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'From' Drug Billing Service search icon
				searchIconFromDrugBillingService.addEventListener('click', function() {
					var inputValue = drugInputBillingServiceInput.value.trim();
					showPopup('fromDrugBillingService', inputValue);
				});
				// Event listener for input field
				drugInputBillingServiceInput.addEventListener('input', function() {
					isDrugInputChanged = true; // Track input changes if needed
					isDrugPopupShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'drugInputBillingServiceItemCode' input keydown event
				drugInputBillingServiceInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = drugInputBillingServiceInput.value.trim();
						if (inputValue !== '' && !isDrugPopupShown) {
							showPopup('fromDrugBillingService', inputValue);
							isDrugPopupShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				drugInputBillingServiceInput.addEventListener('blur', handleBlurPopupDrugInput);

				// Reset isDrugPopupShown when focus is on the input field again
				drugInputBillingServiceInput.addEventListener('focus', function() {
					isDrugPopupShown = false;
				});

					
				// Create drugInput1From (drugInputCreatedAmendedby)
				var drugInputCreatedAmendedby = document.createElement('div');
				drugInputCreatedAmendedby.className = "form-input additionalInput";
				drugInputCreatedAmendedby.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="drugInputCreatedAmendedby" name="drugInputCreatedAmendedby" onblur="drugvalidateInputs(1);">' +
					'<label class="floating-label" for="drugInputCreatedAmendedby"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromDrugAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				drugInputcontainerOne.appendChild(drugInputCreatedAmendedby);

				// User input tracking
				var isDrugInputAmendedbyChanged = false; // Track if the drug input value has changed
				var isDrugPopupAmendedbyShown = false;  // Track if the drug popup is currently shown

				var drugInputCreatedAmendedbyInput = drugInputCreatedAmendedby.querySelector('#drugInputCreatedAmendedby');
				var searchIconFromDrugAmendedby = drugInputCreatedAmendedby.querySelector('#fromDrugAmendedby');

				// Function to handle blur event
				function handleDrugInputAmendedbyBlur() {
					var inputValue = drugInputCreatedAmendedbyInput.value.trim();
					if (inputValue !== '' && !isDrugPopupAmendedbyShown) {
						showPopup('fromDrugAmendedby', inputValue);
						isDrugPopupAmendedbyShown = true; // Mark popup as shown
					}
					isDrugInputAmendedbyChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'From' Drug Amendedby search icon
				searchIconFromDrugAmendedby.addEventListener('click', function() {
					var inputValue = drugInputCreatedAmendedbyInput.value.trim();
					showPopup('fromDrugAmendedby', inputValue);
				});
				// Event listener for input field
				drugInputCreatedAmendedbyInput.addEventListener('input', function() {
					isDrugInputAmendedbyChanged = true; // Track input changes
					isDrugPopupAmendedbyShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'drugInputCreatedAmendedby' input keydown event
				drugInputCreatedAmendedbyInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = drugInputCreatedAmendedbyInput.value.trim();
						if (inputValue !== '' && !isDrugPopupAmendedbyShown) {
							showPopup('fromDrugAmendedby', inputValue);
							isDrugPopupAmendedbyShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				drugInputCreatedAmendedbyInput.addEventListener('blur', handleDrugInputAmendedbyBlur);

				// Reset isDrugPopupAmendedbyShown when focus is on the input field again
				drugInputCreatedAmendedbyInput.addEventListener('focus', function() {
					isDrugPopupAmendedbyShown = false;
				});

				
             	// Append containerOne to fieldsetFrom
                drugInputfieldsetFrom.appendChild(drugInputcontainerOne);
				
				

             	// Create container for drugInput2From
                var drugInputcontainerTwo = document.createElement('div');
                drugInputcontainerTwo.className = "flexcontainerTwo";

                // Create input2From (CreatedAmendedDate)
                var drugInput2From = document.createElement('div');
                drugInput2From.className = "form-input additionalInput";
                drugInput2From.innerHTML = '<input class="floating-input datetime-local drug" style="width: 180px;" type="datetime-local" placeholder="" id="drugInputCreatedAmendedDate" name="drugInputCreatedAmendedDate" onblur="drugDateValidation(2);drugDateValidation(3);">' +
                                       '<label class="floating-label" for="drugInputCreatedAmendedDate"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
             	drugInputcontainerTwo.appendChild(drugInput2From);
             	// Append drugInputcontainerTwo to fieldsetFrom
                drugInputfieldsetFrom.appendChild(drugInputcontainerTwo);
                
                parentDiv.appendChild(drugInputfieldsetFrom);//adding to parentDiv

            	// Creating fieldset for 'drugInputTo' section
                var drugInputfieldsetTo = document.createElement('fieldset');
				drugInputfieldsetTo.style.border = '1px solid #DADCE0';
				drugInputfieldsetTo.style.width =  '47%';
				drugInputfieldsetTo.style.paddingBottom = '50px';
                drugInputfieldsetTo.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var drugInputlegendTo = document.createElement('legend');
                drugInputlegendTo.innerHTML = '<label for="From"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/></label>';
                drugInputfieldsetTo.appendChild(drugInputlegendTo);

                // Create container for drugInputTo and drugInput1To
                var drugInputcontainerOneTo = document.createElement('div');
                drugInputcontainerOneTo.className = "flexcontainerone";

							   // Create drugInputTo (drugInputToBillingServiceItemCode)
				var drugInputToBillingServiceItemCode = document.createElement('div');
				drugInputToBillingServiceItemCode.className = "form-input additionalInput";
				drugInputToBillingServiceItemCode.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="drugInputToBillingServiceItemCode" name="drugInputToBillingServiceItemCode" >' +
					'<label class="floating-label" for="drugInputToBillingServiceItemCode"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toDrugBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				drugInputcontainerOneTo.appendChild(drugInputToBillingServiceItemCode);

				// User input tracking
				var isDrugInputToChanged = false; // Track if the drug input value has changed
				var isDrugPopupToShown = false;  // Track if the drug popup is currently shown

				var drugInputToBillingServiceInput = drugInputToBillingServiceItemCode.querySelector('#drugInputToBillingServiceItemCode');
				var searchIconToDrugBillingService = drugInputToBillingServiceItemCode.querySelector('#toDrugBillingService');

				// Function to handle blur event
				function handleDrugInputToBlur() {
					var inputValue = drugInputToBillingServiceInput.value.trim();
					if (inputValue !== '' && !isDrugPopupToShown) {
						showPopup('toDrugBillingService', inputValue);
						isDrugPopupToShown = true; // Mark popup as shown
					}
					isDrugInputToChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Drug Billing Service search icon
				searchIconToDrugBillingService.addEventListener('click', function() {
					var inputValue = drugInputToBillingServiceInput.value.trim();
					showPopup('toDrugBillingService', inputValue);
				});

				// Event listener for input field
				drugInputToBillingServiceInput.addEventListener('input', function() {
					isDrugInputToChanged = true; // Track input changes
					isDrugPopupToShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'drugInputToBillingServiceItemCode' input keydown event
				drugInputToBillingServiceInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = drugInputToBillingServiceInput.value.trim();
						if (inputValue !== '' && !isDrugPopupToShown) {
							showPopup('toDrugBillingService', inputValue);
							isDrugPopupToShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				drugInputToBillingServiceInput.addEventListener('blur', handleDrugInputToBlur);

				// Reset isDrugPopupToShown when focus is on the input field again
				drugInputToBillingServiceInput.addEventListener('focus', function() {
					isDrugPopupToShown = false;
				});

					
								// Create drugInput1To (drugInputToCreatedAmendedby)
				var drugInputToCreatedAmendedby = document.createElement('div');
				drugInputToCreatedAmendedby.className = "form-input additionalInput";
				drugInputToCreatedAmendedby.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="drugInputToCreatedAmendedby" name="drugInputToCreatedAmendedby" >' +
					'<label class="floating-label" for="drugInputToCreatedAmendedby"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toDrugAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				drugInputcontainerOneTo.appendChild(drugInputToCreatedAmendedby);

				// User input tracking
				var isDrugInputToCreatedAmendedbyChanged = false; // Track if the drug input value has changed
				var isDrugPopupToCreatedAmendedbyShown = false;  // Track if the drug popup is currently shown

				var drugInputToCreatedAmendedbyInput = drugInputToCreatedAmendedby.querySelector('#drugInputToCreatedAmendedby');
				var searchIconToDrugAmendedby = drugInputToCreatedAmendedby.querySelector('#toDrugAmendedby');

				// Function to handle blur event
				function handleDrugInputToCreatedAmendedbyBlur() {
					var inputValue = drugInputToCreatedAmendedbyInput.value.trim();
					if (inputValue !== '' && !isDrugPopupToCreatedAmendedbyShown) {
						showPopup('toDrugAmendedby', inputValue);
						isDrugPopupToCreatedAmendedbyShown = true; // Mark popup as shown
					}
					isDrugInputToCreatedAmendedbyChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'To' Drug Amendedby search icon
				searchIconToDrugAmendedby.addEventListener('click', function() {
					var inputValue = drugInputToCreatedAmendedbyInput.value.trim();
					showPopup('toDrugAmendedby', inputValue);
				});

				// Event listener for input field
				drugInputToCreatedAmendedbyInput.addEventListener('input', function() {
					isDrugInputToCreatedAmendedbyChanged = true; // Track input changes
					isDrugPopupToCreatedAmendedbyShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'drugInputToCreatedAmendedby' input keydown event
				drugInputToCreatedAmendedbyInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = drugInputToCreatedAmendedbyInput.value.trim();
						if (inputValue !== '' && !isDrugPopupToCreatedAmendedbyShown) {
							showPopup('toDrugAmendedby', inputValue);
							isDrugPopupToCreatedAmendedbyShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				drugInputToCreatedAmendedbyInput.addEventListener('blur', handleDrugInputToCreatedAmendedbyBlur);

				// Reset isDrugPopupToCreatedAmendedbyShown when focus is on the input field again
				drugInputToCreatedAmendedbyInput.addEventListener('focus', function() {
					isDrugPopupToCreatedAmendedbyShown = false;
				});

				
             	// Append drugInputcontainerOneTo to fieldsetFrom
                drugInputfieldsetTo.appendChild(drugInputcontainerOneTo);
				
				
			
             	
             	// Create container for drugInput2To
                var drugInputcontainerTwoTo = document.createElement('div');
                drugInputcontainerTwoTo.className = "flexcontainerTwo";

                // Create input2From (CreatedAmendedDate)
                var drugInput2To = document.createElement('div');
                drugInput2To.className = "form-input additionalInput";
                drugInput2To.innerHTML = '<input class="floating-input datetime-local drug" style="width: 180px;" type="datetime-local" placeholder="" id="drugInputToCreatedAmendedDate" name="drugInputToCreatedAmendedDate" onblur="drugDateValidation(2);drugDateValidation(4);">' +
                                       '<label class="floating-label" for="drugInputToCreatedAmendedDate"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
             	drugInputcontainerTwoTo.appendChild(drugInput2To);
             	// Append drugInputcontainerTwo to fieldsetFrom
                drugInputfieldsetTo.appendChild(drugInputcontainerTwoTo);
                
                parentDiv.appendChild(drugInputfieldsetTo);//adding to parentDiv
              
            } else if (reportType === "option3") {
            	$('#p_report_id').val("BLRITLST");
            	$('#price_ind').val("Y");				//Price Indicator value is "Y" for Consumables based on the Item Price List -- Item type
            	var consumableInput1 = document.createElement('div');
            	consumableInput1.className = "form-input additionalInput";
            	consumableInput1.innerHTML = '<select class="inputselect"  style="margin-right: 15px"; name="consumableInput1status" id="consumableInput1status" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                         
                                          '</select>' +
                                          '<label class="label-select" for="consumableInput1status"><fmt:message key="eBL.Status.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(consumableInput1);
				if (typeof consumableStatusJSONOption1 !== 'undefined') { // Check if selectOptions is available
                	populateconsumableStatus(consumableStatusJSONOption1);
                } else {
				console.error("consumableStatusJSONOption1 variable not available from server-side script");
				}
				

                var consumableInput2 = document.createElement('div');
                consumableInput2.className = "form-input additionalInput";
                consumableInput2.innerHTML = '<select class="inputselect"  style="margin-right: 10px"; name="consumableInput2FacilityID" id="consumableInput2FacilityID" onclick="this.setAttribute(\'value\', this.value);" onchange="this.setAttribute(\'value\', this.value);" >' +
                                          '</select>' +
                                          '<label class="label-select" for="consumableInput2FacilityID"><fmt:message key="eBL.FacilityID.label" bundle="${bl_labels}"/></label>';
                parentDiv.appendChild(consumableInput2);
				 if (typeof consumableFacilityJSONOptions1 !== 'undefined') { // Check if selectOptions is available
                  populateconsumableFacilityID(consumableFacilityJSONOptions1);
                } else {
                  console.error("consumableFacilityJSONOptions1 variable not available from server-side script.");
                }
                
                var consumableInput3 = document.createElement('div');
                consumableInput3.className = "form-input additionalInput"; 
				consumableInput3.style.marginBottom = "10px";
                consumableInput3.innerHTML = '<input style="margin-top: 16px; width: 15px; height: 12px;" class="checkboxinput" type="checkbox" id="consumablecheckboxByNameTradeBatch" name="consumablecheckboxByNameTradeBatch">' +
                                          '<label style="font-family: Segoe UI, Regular; font-size: 14px; color: #171717;" class="checkboxlabel" for="consumableByNameTradeBatch"><fmt:message key="eBL.TradeNameorBatch.label" bundle="${bl_labels}"/></label>';

                parentDiv.appendChild(consumableInput3);
                
            	// Creating fieldset for 'consumableInputFrom' section
                var consumableInputfieldsetFrom = document.createElement('fieldset');
				consumableInputfieldsetFrom.style.border = '1px solid #DADCE0';
				consumableInputfieldsetFrom.style.width =  '48%';
				consumableInputfieldsetFrom.style.paddingBottom = '50px';
				consumableInputfieldsetFrom.style.marginRight = '10px';
                consumableInputfieldsetFrom.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var consumableInputlegendFrom = document.createElement('legend');
                consumableInputlegendFrom.innerHTML = '<label for="From"><fmt:message key="eBL.From.label" bundle="${bl_labels}"/></label>';
                consumableInputfieldsetFrom.appendChild(consumableInputlegendFrom);

                // Create container for consumableInputFrom and consumableInput1From
                var consumableInputcontainerOne = document.createElement('div');
                consumableInputcontainerOne.className = "flexcontainerone";

                // Create consumableInputFrom (consumableInputBillingServiceItemCode)
				var consumableInputFrom = document.createElement('div');
				consumableInputFrom.className = "form-input additionalInput";
				consumableInputFrom.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="consumableInputBillingServiceItemCode" name="consumableInputBillingServiceItemCode" onblur="consumableValidateInputs(2);">' +
					'<label class="floating-label" for="consumableInputBillingServiceItemCode"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromConsumableBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				consumableInputcontainerOne.appendChild(consumableInputFrom);

				// User input tracking
				var isConsumableInputBillingServiceItemCodeChanged = false; // Track if the consumable input value has changed
				var isConsumablePopupBillingServiceItemCodeShown = false;  // Track if the consumable popup is currently shown

				var consumableInputBillingServiceInput = consumableInputFrom.querySelector('#consumableInputBillingServiceItemCode');
				var searchIconFromConsumableBillingService = consumableInputFrom.querySelector('#fromConsumableBillingService');

				// Function to handle blur event
				function handleConsumableInputBillingServiceItemCodeBlur() {
					var inputValue = consumableInputBillingServiceInput.value.trim();
					if (inputValue !== '' && !isConsumablePopupBillingServiceItemCodeShown) {
						showPopup('fromConsumableBillingService', inputValue);
						isConsumablePopupBillingServiceItemCodeShown = true; // Mark popup as shown
					}
					isConsumableInputBillingServiceItemCodeChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'From' Consumable Billing Service search icon
				searchIconFromConsumableBillingService.addEventListener('click', function() {
					var inputValue = consumableInputBillingServiceInput.value.trim();
					showPopup('fromConsumableBillingService', inputValue);
				});

				// Event listener for input field
				consumableInputBillingServiceInput.addEventListener('input', function() {
					isConsumableInputBillingServiceItemCodeChanged = true; // Track input changes
					isConsumablePopupBillingServiceItemCodeShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'consumableInputBillingServiceItemCode' input keydown event
				consumableInputBillingServiceInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = consumableInputBillingServiceInput.value.trim();
						if (inputValue !== '' && !isConsumablePopupBillingServiceItemCodeShown) {
							showPopup('fromConsumableBillingService', inputValue);
							isConsumablePopupBillingServiceItemCodeShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				consumableInputBillingServiceInput.addEventListener('blur', handleConsumableInputBillingServiceItemCodeBlur);

				// Reset isConsumablePopupBillingServiceItemCodeShown when focus is on the input field again
				consumableInputBillingServiceInput.addEventListener('focus', function() {
					isConsumablePopupBillingServiceItemCodeShown = false;
				});

								
								// Create consumableInput1From (CreatedAmendedby)
				var consumableInput1From = document.createElement('div');
				consumableInput1From.className = "form-input additionalInput";
				consumableInput1From.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="consumableInputCreatedAmendedby" name="consumableInputCreatedAmendedby" onblur="consumableValidateInputs(1);">' +
					'<label class="floating-label" for="consumableInputCreatedAmendedby"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="fromConsumableCreatedAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

				consumableInputcontainerOne.appendChild(consumableInput1From);

				// User input tracking
				var isConsumableInputCreatedAmendedbyChanged = false; // Track if the consumable input value has changed
				var isConsumablePopupCreatedAmendedbyShown = false;  // Track if the consumable popup is currently shown

				var consumableInputCreatedAmendedbyInput = consumableInput1From.querySelector('#consumableInputCreatedAmendedby');
				var searchIconFromConsumableCreatedAmendedby = consumableInput1From.querySelector('#fromConsumableCreatedAmendedby');

				// Function to handle blur event
				function handleConsumableInputCreatedAmendedbyBlur() {
					var inputValue = consumableInputCreatedAmendedbyInput.value.trim();
					if (inputValue !== '' && !isConsumablePopupCreatedAmendedbyShown) {
						showPopup('fromConsumableCreatedAmendedby', inputValue);
						isConsumablePopupCreatedAmendedbyShown = true; // Mark popup as shown
					}
					isConsumableInputCreatedAmendedbyChanged = false; // Reset input changed status on blur
				}

				// Event listener for 'From' Consumable Created Amendedby search icon
				searchIconFromConsumableCreatedAmendedby.addEventListener('click', function() {
					var inputValue = consumableInputCreatedAmendedbyInput.value.trim();
					showPopup('fromConsumableCreatedAmendedby', inputValue);
				});

				// Event listener for input field
				consumableInputCreatedAmendedbyInput.addEventListener('input', function() {
					isConsumableInputCreatedAmendedbyChanged = true; // Track input changes
					isConsumablePopupCreatedAmendedbyShown = false; // Reset popup shown flag when input changes
				});

				// Event listener for 'consumableInputCreatedAmendedby' input keydown event
				consumableInputCreatedAmendedbyInput.addEventListener('keydown', function(event) {
					if (event.key === 'Tab') {
						var inputValue = consumableInputCreatedAmendedbyInput.value.trim();
						if (inputValue !== '' && !isConsumablePopupCreatedAmendedbyShown) {
							showPopup('fromConsumableCreatedAmendedby', inputValue);
							isConsumablePopupCreatedAmendedbyShown = true; // Mark popup as shown
						}
					}
				});

				// Add blur event listener to the input
				consumableInputCreatedAmendedbyInput.addEventListener('blur', handleConsumableInputCreatedAmendedbyBlur);

				// Reset isConsumablePopupCreatedAmendedbyShown when focus is on the input field again
				consumableInputCreatedAmendedbyInput.addEventListener('focus', function() {
					isConsumablePopupCreatedAmendedbyShown = false;
				});

             	
                consumableInputfieldsetFrom.appendChild(consumableInputcontainerOne);

             	
             	// Create container for consumableInput2From
                var consumableInputcontainerTwo = document.createElement('div');
               consumableInputcontainerTwo.className = "flexcontainerTwo";

                // Create input2From (CreatedAmendedDate)
                var consumableInput2From = document.createElement('div');
                consumableInput2From.className = "form-input additionalInput";
                consumableInput2From.innerHTML = '<input class="floating-input datetime-local drug" style="width: 180px;" type="datetime-local" placeholder="" id="consumableInputCreatedAmendedDate" name="consumableInputCreatedAmendedDate" onblur="consumableDateValidation(2);consumableDateValidation(3);">' +
                                       '<label class="floating-label" for="consumableInputCreatedAmendedDate"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
             	consumableInputcontainerTwo.appendChild(consumableInput2From);
             	// Append consumableInputcontainerTwo to fieldsetFrom
               consumableInputfieldsetFrom.appendChild(consumableInputcontainerTwo);
                
                parentDiv.appendChild(consumableInputfieldsetFrom);//adding to parentDiv
                
            	// Creating fieldset for 'consumableInputTo' section
                var consumableInputfieldsetTo = document.createElement('fieldset');
				consumableInputfieldsetTo.style.border = '1px solid #DADCE0';
				consumableInputfieldsetTo.style.width =  '47%';
				consumableInputfieldsetTo.style.paddingBottom = '50px';
                consumableInputfieldsetTo.className = 'fieldsetStyling additionalInput'; // Adding a class to the fieldset element
                var consumableInputlegendTo = document.createElement('legend');
                consumableInputlegendTo.innerHTML = '<label for="From"><fmt:message key="eBL.To.label" bundle="${bl_labels}"/></label>';
                consumableInputfieldsetTo.appendChild(consumableInputlegendTo);

                // Create container for consumableInputTo and consumableInput1To
                var consumableInputcontainerOneTo = document.createElement('div');
                consumableInputcontainerOneTo.className = "flexcontainerone";

               // Create consumableInputTo (BillingServiceItemCode)
				var consumableInputTo = document.createElement('div');
				consumableInputTo.className = "form-input additionalInput";
				consumableInputTo.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="consumableInputToBillingServiceItemCode" name="consumableInputToBillingServiceItemCode" >' +
					'<label class="floating-label" for="consumableInputToBillingServiceItemCode"><fmt:message key="eBL.BillingServiceItemCode.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toConsumableBillingService">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

consumableInputcontainerOneTo.appendChild(consumableInputTo);

// User input tracking
var isConsumableInputToBillingServiceChanged = false; // Track if the consumable input value has changed
var isConsumablePopupToBillingServiceShown = false;  // Track if the consumable popup is currently shown

var consumableInputToBillingServiceInput = consumableInputTo.querySelector('#consumableInputToBillingServiceItemCode');
var searchIconToConsumableBillingService = consumableInputTo.querySelector('#toConsumableBillingService');

// Function to handle blur event
function handleConsumableInputToBillingServiceBlur() {
    var inputValue = consumableInputToBillingServiceInput.value.trim();
    if (inputValue !== '' && !isConsumablePopupToBillingServiceShown) {
        showPopup('toConsumableBillingService', inputValue);
        isConsumablePopupToBillingServiceShown = true; // Mark popup as shown
    }
    isConsumableInputToBillingServiceChanged = false; // Reset input changed status on blur
}

				// Event listener for 'To' Consumable Billing Service search icon
				searchIconToConsumableBillingService.addEventListener('click', function() {
					var inputValue = consumableInputToBillingServiceInput.value.trim();
					showPopup('toConsumableBillingService', inputValue);
				});

// Event listener for input field
consumableInputToBillingServiceInput.addEventListener('input', function() {
    isConsumableInputToBillingServiceChanged = true; // Track input changes
    isConsumablePopupToBillingServiceShown = false; // Reset popup shown flag when input changes
});

// Event listener for 'consumableInputToBillingServiceItemCode' input keydown event
consumableInputToBillingServiceInput.addEventListener('keydown', function(event) {
    if (event.key === 'Tab') {
        var inputValue = consumableInputToBillingServiceInput.value.trim();
        if (inputValue !== '' && !isConsumablePopupToBillingServiceShown) {
            showPopup('toConsumableBillingService', inputValue);
            isConsumablePopupToBillingServiceShown = true; // Mark popup as shown
        }
    }
});

// Add blur event listener to the input
consumableInputToBillingServiceInput.addEventListener('blur', handleConsumableInputToBillingServiceBlur);

// Reset isConsumablePopupToBillingServiceShown when focus is on the input field again
consumableInputToBillingServiceInput.addEventListener('focus', function() {
    isConsumablePopupToBillingServiceShown = false;
});

				

							   // Create consumableInput1To (CreatedAmendedby)
				var consumableInput1To = document.createElement('div');
				consumableInput1To.className = "form-input additionalInput";
				consumableInput1To.innerHTML = 
					'<input class="floating-input" style="width: 230px;" type="text" placeholder="" id="consumableInputToCreatedAmendedby" name="consumableInputToCreatedAmendedby" >' +
					'<label class="floating-label" for="consumableInputToCreatedAmendedby"><fmt:message key="eBL.CreatedAmendedby.label" bundle="${bl_labels}"/></label>' +
					'<button class="search-icon" type="button" id="toConsumableCreatedAmendedby">' +
					'<span class="mdi mdi-magnify"></span>' +
					'</button>';

consumableInputcontainerOneTo.appendChild(consumableInput1To);

// User input tracking
var isConsumableInputToCreatedAmendedbyChanged = false; // Track if the input value has changed
var isConsumablePopupToCreatedAmendedbyShown = false;  // Track if the popup is currently shown

var consumableInputToCreatedAmendedbyInput = consumableInput1To.querySelector('#consumableInputToCreatedAmendedby');
var searchIconToConsumableCreatedAmendedby = consumableInput1To.querySelector('#toConsumableCreatedAmendedby');

// Function to handle blur event
function handleConsumableInputToCreatedAmendedbyBlur() {
    var inputValue = consumableInputToCreatedAmendedbyInput.value.trim();
    if (inputValue !== '' && !isConsumablePopupToCreatedAmendedbyShown) {
        showPopup('toConsumableCreatedAmendedby', inputValue);
        isConsumablePopupToCreatedAmendedbyShown = true; // Mark popup as shown
    }
    isConsumableInputToCreatedAmendedbyChanged = false; // Reset input changed status on blur
}

				// Event listener for 'To' Consumable Created Amendedby search icon
				searchIconToConsumableCreatedAmendedby.addEventListener('click', function() {
					var inputValue = consumableInputToCreatedAmendedbyInput.value.trim();
					showPopup('toConsumableCreatedAmendedby', inputValue);
				});

// Event listener for input field
consumableInputToCreatedAmendedbyInput.addEventListener('input', function() {
    isConsumableInputToCreatedAmendedbyChanged = true; // Track input changes
    isConsumablePopupToCreatedAmendedbyShown = false; // Reset popup shown flag when input changes
});

// Event listener for 'consumableInputToCreatedAmendedby' input keydown event
consumableInputToCreatedAmendedbyInput.addEventListener('keydown', function(event) {
    if (event.key === 'Tab') {
        var inputValue = consumableInputToCreatedAmendedbyInput.value.trim();
        if (inputValue !== '' && !isConsumablePopupToCreatedAmendedbyShown) {
            showPopup('toConsumableCreatedAmendedby', inputValue);
            isConsumablePopupToCreatedAmendedbyShown = true; // Mark popup as shown
        }
    }
});

// Add blur event listener to the input
consumableInputToCreatedAmendedbyInput.addEventListener('blur', handleConsumableInputToCreatedAmendedbyBlur);

// Reset isConsumablePopupToCreatedAmendedbyShown when focus is on the input field again
consumableInputToCreatedAmendedbyInput.addEventListener('focus', function() {
    isConsumablePopupToCreatedAmendedbyShown = false;
});

				// Append the container to the fieldset
				//consumableInputfieldsetTo.appendChild(consumableInputcontainerOneTo);

                consumableInputfieldsetTo.appendChild(consumableInputcontainerOneTo);

             	
             	// Create container for consumableInput2To
                var consumableInputcontainerTwoTo = document.createElement('div');
                consumableInputcontainerTwoTo.className = "flexcontainerTwo";

                // Create input2From (CreatedAmendedDate)
                var consumableInput2To = document.createElement('div');
                consumableInput2To.className = "form-input additionalInput";
                consumableInput2To.innerHTML = '<input class="floating-input datetime-local drug" style="width: 180px;" type="datetime-local" placeholder="" id="consumableInputToCreatedAmendedDate" name="consumableInputToCreatedAmendedDate" onblur="consumableDateValidation(2);consumableDateValidation(4);">' +
                                       '<label class="floating-label" for="consumableInputToCreatedAmendedDate"><fmt:message key="eBL.CreatedAmendedDate.label" bundle="${bl_labels}"/></label>';
             	consumableInputcontainerTwoTo.appendChild(consumableInput2To);
             	// Append consumableInputcontainerTwo to fieldsetFrom
                consumableInputfieldsetTo.appendChild(consumableInputcontainerTwoTo);
                
                parentDiv.appendChild(consumableInputfieldsetTo);//adding to parentDiv
            }
        }

        function setAttributeValueOnClick() {
            var reportType = document.getElementById('ReportType');
            reportType.onclick = function() {
                this.setAttribute('value', this.value);
            };
        }
        
       
    </script>

</head>
<body>

	<div id="headerDiv" class="headerContainer" >
		<div class="title"><fmt:message key="eBL.ServiceItemPriceList.label" bundle="${bl_labels}" /></div>
		<div class="buttoncontainer">
			<input type="Button" class="icon-button btn-primary" value="Apply" onclick="run();">
			<input type="Button" class="icon-button btn-primary" value="Reset" onClick = "reset();">
		</div>
	</div>
	<div id="reportTypeContainer" class="containerReport" >
	    <div class="form-input">
	        <select class="inputselect" style="margin-right: 15px"; type="text" placeholder="" name="ReportType" id="ReportType" onclick="setAttributeValueOnClick()" onchange="showAdditionalInputs()" value="">
	            <option value=""> <fmt:message key="eBL.Select.label" bundle="${bl_labels}"/></option>
	            <option value="option1"><fmt:message key="eBL.ServicePriceList.label" bundle="${bl_labels}"/></option>
	            <option value="option2"><fmt:message key="eBL.DrugsPriceList.label" bundle="${bl_labels}"/></option>
	            <option value="option3"><fmt:message key="eBL.ConsumablesPriceList.label" bundle="${bl_labels}"/></option>
	        </select>
	        <label class="label-select" for="ReportType">
	            <fmt:message key="eBL.ReportType.label" bundle="${bl_labels}"/>
	        </label>
	    </div>
	</div>

<input type="hidden" id="facilityId" name="facilityId" value = "<%=facilityId%>" >
<input type="hidden" id="params"	name="params"	value="<%=params%>">
<input type="hidden" id="locale" name="locale" value="<%=locale%>">
<input type="hidden" id="self_submit" name="self_submit" value="yes">

<input type="hidden" id="p_module_id" name="p_module_id" value="<%=moduleId%>"	>
<input type="hidden" id="p_report_id" name="p_report_id" value="" >
<input type="hidden" id="price_ind" name="price_ind" value="!" >
<input type="hidden" id="pgm_id" name="pgm_id" 	value=""	> 		
<input type="hidden" id="p_session_id" name="p_session_id" 	value="">	
<input type="hidden" id="p_user_name" name="p_user_name" 	value="<%=p_user_name%>">
<input type="hidden" id="p_pgm_date" name="p_pgm_date"	   value="">

<input type="hidden" id="reportserver"	name="reportserver"	value="">
<input type="hidden" id="report"	name="report"		value="">
<input type="hidden" id="userid"	name="userid"		value="">
<input type="hidden" id="server"	name="server"		value="">
<input type="hidden" id="reportServerEnableFlag" name="reportServerEnableFlag" value="">
<input type="hidden" id="desformat"	name="desformat"		value="">
<input type="hidden" id="destype"	name="destype"		value="">
<input type="hidden" id="desname"	name="desname"		value="">
<input type="hidden" id="copies"	name="copies"		value="">
<input type="hidden" id="queue_name"	name="queue_name"		value="">
<input type="hidden" id="rep_server_key"	name="rep_server_key"		value="">
<input type="hidden" id="report_dir" name="report_dir" value="">


<script>

</script>


<%
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    if (conn != null) ConnectionManager.returnConnection(conn, request);
}
%>
</body>

</html>