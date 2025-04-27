package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public final class __blservitempricelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/ebl/jsp/BLServItemPriceList.jsp", 1732167386000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\r\n<html style=\"background: #F7F7F7; margin:10px;\">\r\n<head>\r\n    ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n    \r\n    \r\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyleBL.css\'></link>\r\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\r\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\r\n    <script language=\'javascript\' src=\'../js/BLServItemPriceList.js\'></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\r\n    \r\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n    \r\n    \r\n\t\r\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n    \r\n    \r\n    \r\n    <script type=\"text/javascript\" >\r\n        // Embed the facilityId from JSP into JavaScript\r\n        var facilityId = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\r\n        console.log(\"Facility ID from Javascript:\", facilityId);\r\n        var facility = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"; \r\n\t\t console.log(\"facility=\",facility);\r\n        var locale = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\r\n        console.log(\"Locale from Javascript:\", locale);\r\n\t\t\r\n        \r\n    </script>\r\n    <script src=\"../js/BLServItemPriceList.js\" type=\"text/javascript\"></script>\r\n    \r\n        <script> \t\r\n\t     // Function to populate the ServiceFacilityID select element\r\n       \t\t\r\n\t\t\r\n\tfunction populateServiceFacilityID(serviceFacilityJSONOptions1) {\r\n    var ServiceFacilityIDSelect = document.getElementById(\"service_Facility_ID\");\r\n    ServiceFacilityIDSelect.innerHTML = \'\';\r\n    \r\n    serviceFacilityJSONOptions1.forEach(function(option) {\r\n        var selected = option.value === facility ? \' selected\' : \'\';\r\n        ServiceFacilityIDSelect.innerHTML += \'<option value=\"\' + option.value + \'\"\' + selected + \'>\' + option.label + \'</option>\';\r\n    });\r\n}\r\n\r\n\tfunction populatedrugFacilityID(drugFacilityJSONOptions1) {\r\n    var drugFacilityIDSelect = document.getElementById(\"drugInput2FacilityID\");\r\n    drugFacilityIDSelect.innerHTML = \'\';\r\n    \r\n    drugFacilityJSONOptions1.forEach(function(option) {\r\n        var selected = option.value === facility ? \' selected\' : \'\';\r\n        drugFacilityIDSelect.innerHTML += \'<option value=\"\' + option.value + \'\"\' + selected + \'>\' + option.label + \'</option>\';\r\n    });\r\n}\r\n\r\nfunction populateconsumableFacilityID(consumableFacilityJSONOptions1) {\r\n    var consumableFacilityIDSelect = document.getElementById(\"consumableInput2FacilityID\");\r\n    consumableFacilityIDSelect.innerHTML = \'\';\r\n    \r\n    consumableFacilityJSONOptions1.forEach(function(option) {\r\n        var selected = option.value === facility ? \' selected\' : \'\';\r\n        consumableFacilityIDSelect.innerHTML += \'<option value=\"\' + option.value + \'\"\' + selected + \'>\' + option.label + \'</option>\';\r\n    });\r\n}\r\n\r\n       \r\n       \r\n        \r\n // Function to populate the ServicePriceIndicator select element\r\nfunction populateServicePriceIndicator(ServicePriceIndicatorJSONOption1) {\r\n    var ServicePriceIndicatorSelect = document.getElementById(\"PriceIndicator\");\r\n    ServicePriceIndicatorSelect.innerHTML = \'\'; // Clear existing options\r\n\r\n    // Add the \"All\" option and select it by default\r\n    var allOption = \'<option value=\"A\" selected>ALL</option>\';\r\n    ServicePriceIndicatorSelect.innerHTML += allOption;\r\n\r\n    // Add other options from JSON\r\n    ServicePriceIndicatorJSONOption1.forEach(function(option) {\r\n        if (option.LIST_ELMT_VALUE !== \'A\') { // Skip adding the \"All\" option again if it exists in JSON\r\n            ServicePriceIndicatorSelect.innerHTML += \'<option value=\"\' + option.LIST_ELMT_VALUE + \'\">\' + option.LIST_ELMT_LABEL + \'</option>\';\r\n        }\r\n    });\r\n\r\n    // Add change event listener to the PriceIndicator dropdown\r\n    ServicePriceIndicatorSelect.addEventListener(\'change\', function() {\r\n        updateGroupByOptions(ServicePriceIndicatorSelect.value);\r\n    });\r\n}\r\n // Function to populate the ServiceGroupBy select element\r\nfunction populateServiceGroupBy(ServiceGroupByJSONOption1) {\r\n    var ServiceGroupBySelect = document.getElementById(\"GroupBy\");\r\n    ServiceGroupBySelect.innerHTML = \'\';\r\n    // Add the \"Active\" option and select it by default\r\n    var groupByoption = \'<option value=\"C\" selected>Customer</option>\';\r\n    ServiceGroupBySelect.innerHTML += groupByoption;\r\n\r\n    ServiceGroupByJSONOption1.forEach(function(option) {\r\n        if (option.LIST_ELMT_VALUE !== \'C\') { // Skip adding the \"Active\" option again if it exists in JSON\r\n            ServiceGroupBySelect.innerHTML += \'<option value=\"\' + option.LIST_ELMT_VALUE + \'\">\' + option.LIST_ELMT_LABEL + \'</option>\';\r\n        }\r\n    });\r\n}\r\n\r\n// Function to update the GroupBy options based on PriceIndicator selection\r\nfunction updateGroupByOptions(priceIndicatorValue) {\r\n    var ServiceGroupBySelect = document.getElementById(\"GroupBy\");\r\n\r\n    // Define the options for the GroupBy dropdown\r\n    var options;\r\n    if (priceIndicatorValue === \'S\') { // Example condition for \"Standard Price\"\r\n        options = [\r\n\t\t\t{ LIST_ELMT_VALUE: \'S\', LIST_ELMT_LABEL: \'Service\' },\r\n            { LIST_ELMT_VALUE: \'C\', LIST_ELMT_LABEL: \'Customer\' }\r\n\r\n        ];\r\n        // Update the GroupBy dropdown with the new options\r\n        populateServiceGroupBy(options);\r\n        // Set the selected value to \"Service\"\r\n        ServiceGroupBySelect.value = \'S\';\r\n    } else {\r\n       /* options = [\r\n\t\t\t{ LIST_ELMT_VALUE: \'S\', LIST_ELMT_LABEL: \'Service\' },\r\n            { LIST_ELMT_VALUE: \'C\', LIST_ELMT_LABEL: \'Customer\' }\r\n           \r\n        ];\r\n        // Update the GroupBy dropdown with the new options\r\n        populateServiceGroupBy(options);\r\n        // Optionally, you can reset to a default value or keep it unchanged\r\n        ServiceGroupBySelect.value = \'C\'; // Default or initial value */\r\n    }\r\n}\r\n    \r\n\t\r\n\tfunction populateServiceStatus(ServiceStatusJSONOption1) {\r\n    var ServiceStatusSelect = document.getElementById(\"status\");\r\n    ServiceStatusSelect.innerHTML = \'\';\r\n\r\n    ServiceStatusJSONOption1.forEach(function(option) {\r\n        var isSelected = option.LIST_ELMT_VALUE === \'A\' ? \' selected\' : \'\';\r\n        ServiceStatusSelect.innerHTML += \'<option value=\"\' + option.LIST_ELMT_VALUE + \'\"\' + isSelected + \'>\' + option.LIST_ELMT_LABEL + \'</option>\';\r\n    });\r\n}\r\n\r\n\t\t\r\n\t\tfunction populatedrugStatus(drugStatusJSONOption1) {\r\n       \t\t    var drugStatusSelect = document.getElementById(\"drugInput1status\");\r\n       \t\t    drugStatusSelect.innerHTML = \'\'; // Clear existing options\r\n       \t\t    // Add other options from JSON\r\n       \t\t    drugStatusJSONOption1.forEach(function(option) {\r\n\t\t\t\tvar isSelected = option.LIST_ELMT_VALUE === \'A\' ? \' selected\' : \'\';\r\n\t\t\t\tdrugStatusSelect.innerHTML += \'<option value=\"\' + option.LIST_ELMT_VALUE + \'\"\' + isSelected + \'>\' + option.LIST_ELMT_LABEL + \'</option>\';\r\n\r\n       \t\t    });\r\n       \t\t}\r\n\t\t\t\r\n\t\tfunction populateconsumableStatus(consumableStatusJSONOption1) {\r\n       \t\t    var consumableStatusSelect = document.getElementById(\"consumableInput1status\");\r\n       \t\t    consumableStatusSelect.innerHTML = \'\'; // Clear existing options\r\n       \t\t    // Add other options from JSON\r\n       \t\t    consumableStatusJSONOption1.forEach(function(option) {\r\n       \t\t     var isSelected = option.LIST_ELMT_VALUE === \'A\' ? \' selected\' : \'\';\r\n\t\t\t\tconsumableStatusSelect.innerHTML += \'<option value=\"\' + option.LIST_ELMT_VALUE + \'\"\' + isSelected + \'>\' + option.LIST_ELMT_LABEL + \'</option>\';\r\n\r\n       \t\t    });\r\n       \t\t}\r\n       \t\r\n   \t\r\n  \r\n\r\n     \r\n   \t\t // Embedding selectOptionsJSON directly into JavaScript\r\n   \t   \t var serviceFacilityJSONOptions1 = ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";\r\n   \t  \t var drugFacilityJSONOptions1 = ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\r\n\t\t var consumableFacilityJSONOptions1 = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =";\r\n   \t  \t var ServicePriceIndicatorJSONOption1 = ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\r\n   \t \t var ServiceStatusJSONOption1 = ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";\r\n   \t \t var drugStatusJSONOption1 = ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";\r\n\t\t var consumableStatusJSONOption1 = ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";\r\n   \t \t var ServiceGroupByJSONOption1 = ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";\r\n\t\t \r\n   \t \t\r\n   \t\t document.addEventListener(\"DOMContentLoaded\", function() {\r\n         populateServiceFacilityID(serviceFacilityJSONOptions1);\r\n         populatedrugFacilityID(drugFacilityJSONOptions1);\r\n         populateServicePriceIndicator(ServicePriceIndicatorJSONOptions1);\r\n         populateServiceStatus(ServiceStatusJSONOption1);\r\n         populatedrugStatus(drugStatusJSONOption1);\r\n         populateServiceGroupBy(ServiceGroupByJSONOption1);\r\n       \r\n         \r\n     });\r\n    \r\n\t  flatpickr(\"#EffectiveDate\", {\r\n            dateFormat: \"d-m-Y H:i\", // Format the date as dd-mm-yyyy 00:00\r\n            enableTime: true, // Enable time picker\r\n            noCalendar: false, // Ensure calendar is visible\r\n            defaultHour: 0, // Set default hour to 00\r\n            defaultMinute: 0, // Set default minute to 00\r\n            plugins: [new TimePlugin({})] // Use TimePlugin for time selection\r\n        });\r\n\r\n\t\t\r\n    \r\n   \r\n\t    \r\n\r\n        \tfunction showAdditionalInputs() {\r\n\t            var reportType = document.getElementById(\"ReportType\").value;\r\n\t            var parentDiv = document.getElementById(\"reportTypeContainer\");\r\n\r\n            // Remove all existing additional inputs\r\n            var existingInputs = parentDiv.getElementsByClassName(\"additionalInput\");\r\n            while (existingInputs.length > 0) {\r\n                parentDiv.removeChild(existingInputs[0]);\r\n            }\r\n            \r\n         // Remove existing form if it exists\r\n            var existingForm = document.getElementById(\"reportFormOption1\");\r\n            if (existingForm) {\r\n                parentDiv.removeChild(existingForm);\r\n            }\r\n            \r\n         // Remove existing submit button if it exists\r\n            var existingSubmitButton = parentDiv.querySelector(\'button[type=\"submit\"]\');\r\n            if (existingSubmitButton) {\r\n                parentDiv.removeChild(existingSubmitButton.parentNode); \r\n            }\r\n\r\n\t\t\t\r\n            \r\n            if (reportType === \"option1\") {\r\n            \t$(\'#p_report_id\').val(\"BLRPRLST\");\r\n            \tvar form = document.createElement(\'form\');\r\n                form.id = \'reportFormOption1\';\r\n                form.method = \'POST\';\r\n                form.action = \'../../eBL/jsp/BLServItemReportOptions.jsp\'; \r\n            \t\r\n                var serviceInput1 = document.createElement(\'div\');\r\n                serviceInput1.className = \'form-input additionalInput\';\r\n\t\t\t\tserviceInput1.style.marginBottom = \"10px\";\r\n                serviceInput1.innerHTML = \'<select class=\"inputselect\"  style=\"margin-right: 10px\"; name=\"PriceIndicator\" id=\"PriceIndicator\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value); PriceIndicatorOnChange(event); \" >\' +\r\n                                          \r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"PriceIndicator\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label>\';\r\n                parentDiv.appendChild(serviceInput1);\r\n             \t// Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof ServicePriceIndicatorJSONOption1 !== \'undefined\') { // Check if selectOptions is available\r\n                \tpopulateServicePriceIndicator(ServicePriceIndicatorJSONOption1);\r\n                } else {\r\n                  console.error(\"ServicePriceIndicatorJSONOption1 variable not available from server-side script.\");\r\n                }\r\n\r\n                var serviceInput2 = document.createElement(\'div\');\r\n                serviceInput2.className = \"form-input additionalInput\";\r\n                serviceInput2.innerHTML = \'<select class=\"inputselect\" style=\"margin-right: 10px\"; name=\"status\" id=\"status\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                        \r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"status\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</label>\';\r\n                parentDiv.appendChild(serviceInput2);\r\n             \r\n                // Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof ServiceStatusJSONOption1 !== \'undefined\') { // Check if selectOptions is available\r\n                \tpopulateServiceStatus(ServiceStatusJSONOption1);\r\n                } else {\r\n                  console.error(\"ServiceStatusJSONOption1 variable not available from server-side script.\");\r\n                }\r\n\t\t\t\t\r\n                var serviceInput3 = document.createElement(\'div\');\r\n                serviceInput3.className = \"form-input additionalInput\";\r\n                serviceInput3.innerHTML = \'<select class=\"inputselect\" style=\"margin-right: 10px\"; name=\"service_Facility_ID\" id=\"service_Facility_ID\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\">\' +                  \r\n                                           \'</select>\' +\r\n                                           \'<label class=\"label-select\" for=\"service_Facility_ID\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</label>\';\r\n                parentDiv.appendChild(serviceInput3);\r\n\r\n                // Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof serviceFacilityJSONOptions1 !== \'undefined\') { // Check if selectOptions is available\r\n                  populateServiceFacilityID(serviceFacilityJSONOptions1);\r\n                } else {\r\n                  console.error(\"serviceFacilityJSONOptions1 variable not available from server-side script.\");\r\n                }\r\n\r\n                var serviceInput4 = document.createElement(\'div\');\r\n                serviceInput4.className = \"form-input additionalInput\";\r\n                serviceInput4.innerHTML = \'<select class=\"inputselect\" name=\"GroupBy\" id=\"GroupBy\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                          \r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"GroupBy\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</label>\';\r\n                parentDiv.appendChild(serviceInput4);\r\n             // Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof ServiceGroupByJSONOption1 !== \'undefined\') { // Check if selectOptions is available\r\n                \tpopulateServiceGroupBy(ServiceGroupByJSONOption1);\r\n                } else {\r\n                  console.error(\"ServiceGroupByJSONOption1 variable not available from server-side script.\");\r\n                }\r\n\r\n                var serviceInput5 = document.createElement(\'div\');\r\n                serviceInput5.className = \"form-input additionalInput\"; \r\n                serviceInput5.innerHTML = \'<input style=\"margin-top: 16px; width: 15px; height: 12px;\" class=\"checkboxinput\" type=\"checkbox\" id=\"StandardPrice\" name=\"StandardPrice\" disabled>\' +\r\n                                          \'<label style=\"font-family: Segoe UI, Regular; font-size: 14px; color: #171717;\" class=\"checkboxlabel\" for=\"StandardPrice\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</label>\';\r\n\r\n                parentDiv.appendChild(serviceInput5);\r\n\r\n                // Creating fieldset for \'From\' section\r\n                var fieldsetFrom = document.createElement(\'fieldset\');\r\n\t\t\t\tfieldsetFrom.style.border = \'1px solid #DADCE0\';\r\n\t\t\t\tfieldsetFrom.style.width =  \'45%\';\r\n\t\t\t\tfieldsetFrom.style.marginRight = \'10px\'; \r\n                fieldsetFrom.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var legendFrom = document.createElement(\'legend\');\r\n                legendFrom.innerHTML = \'<label for=\"From\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</label>\';\r\n                fieldsetFrom.appendChild(legendFrom);\r\n\r\n                // Create container for inputFrom and input1From\r\n                var containerOne = document.createElement(\'div\');\r\n                containerOne.className = \"flexcontainerone\";\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t// Create inputFrom (BillingServiceItemCode)\r\n\t\t\t\tvar inputFrom = document.createElement(\'div\');\r\n\t\t\t\tinputFrom.className = \"form-input additionalInput\";\r\n\t\t\t\tinputFrom.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"BillingServiceItemCode\" name=\"BillingServiceItemCode\" onblur=\"handleBlur(event);validateInputs(2);\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingServiceItemCode\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\t\t\t\tcontainerOne.appendChild(inputFrom);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isbillingPopupShown = false; // Flag to track if the popup is shown\r\n\t\t\t\tvar billingServiceInput = inputFrom.querySelector(\'#BillingServiceItemCode\');\r\n\t\t\t\tvar searchIconFrom = inputFrom.querySelector(\'#fromBillingService\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopup() {\r\n\t\t\t\t\tvar inputValue = billingServiceInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isbillingPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromBillingService\', inputValue);\r\n\t\t\t\t\t\tisbillingPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Billing Service search icon\r\n\t\t\t\tsearchIconFrom.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = billingServiceInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromBillingService\', inputValue); \r\n\t\t\t\t});\r\n \r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tbillingServiceInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisbillingPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingServiceItemCode\' input keydown event\r\n\t\t\t\tbillingServiceInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = billingServiceInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isbillingPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromBillingService\', inputValue); \r\n\t\t\t\t\t\t\tisbillingPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tbillingServiceInput.addEventListener(\'blur\', handleBlurPopup);\r\n\r\n\t\t\t\t// Reset isbillingPopupShown when focus is on the input field again\r\n\t\t\t\tbillingServiceInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisbillingPopupShown = false;\r\n\t\t\t\t});\r\n\r\n              \r\n\r\n             // Create input1From (CustomerCode)\r\n                var input1From = document.createElement(\'div\');\r\n                input1From.className = \"form-input additionalInput\";\r\n                input1From.innerHTML = \'<input class=\"floating-input\" style=\"width: 330px;\" type=\"text\" placeholder=\"\" id=\"CustomerCode\" name=\"CustomerCode\" onblur=\"handleBlur(event);\" >\' +\r\n                    \'<label class=\"floating-label\" for=\"CustomerCode\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</label>\' +\r\n                    \'<button class=\"search-icon\" type=\"button\" id=\"fromCustomerCode\" >\' +\r\n                        \'<span class=\"mdi mdi-magnify\"></span>\' +\r\n                    \'</button>\';\r\n\r\n\t\t\t\tcontainerOne.appendChild(input1From);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isPopupShown = false; // Flag to track if the popup is shown\r\n\t\t\t\tvar CustomerCodeInput = input1From.querySelector(\'#CustomerCode\');\r\n\t\t\t\tvar searchIconFrom = input1From.querySelector(\'#fromCustomerCode\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupCustomerCode() {\r\n\t\t\t\t\tvar inputValue = CustomerCodeInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromCustomerCode\', inputValue);\r\n\t\t\t\t\t\tisPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' search icon\r\n\t\t\t\tsearchIconFrom.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = CustomerCodeInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromCustomerCode\', inputValue); \r\n\t\t\t\t\t\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tCustomerCodeInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'CustomerCode\' input keydown event\r\n\t\t\t\tCustomerCodeInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = CustomerCodeInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromCustomerCode\', inputValue); \r\n\t\t\t\t\t\t\tisPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tCustomerCodeInput.addEventListener(\'blur\', handleBlurPopupCustomerCode);\r\n\r\n\t\t\t\t// Reset isPopupShown when focus is on the input field again\r\n\t\t\t\tCustomerCodeInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\r\n                // Append containerOne to fieldsetFrom\r\n                fieldsetFrom.appendChild(containerOne);\r\n                \r\n                // Create container for input2From, input3From, input4From, and input5From\r\n                var containerTwo = document.createElement(\'div\');\r\n                containerTwo.className = \"flexcontainerone\";\r\n\r\n               // Create input2From (BillingGroup)\r\n\t\t\t\tvar input2FromBilling = document.createElement(\'div\');\r\n\t\t\t\tinput2FromBilling.className = \"form-input additionalInput\";\r\n\t\t\t\tinput2FromBilling.innerHTML = \'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"BillingGroupFrom\" name=\"BillingGroupFrom\" onblur=\"handleBlur(event);validateInputs(3);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingGroupFrom\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromBillingGroup\">\' +\r\n\t\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerTwo.appendChild(input2FromBilling);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isbillinggroupPopupShown = false; // Flag to track if the popup is shown\r\n\t\t\t\tvar BillingGroupInput = input2FromBilling.querySelector(\'#BillingGroupFrom\');\r\n\t\t\t\tvar searchIconFrom = input2FromBilling.querySelector(\'#fromBillingGroup\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupBillingGroup() {\r\n\t\t\t\t\tvar inputValue = BillingGroupInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isbillinggroupPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromBillingGroup\', inputValue);\r\n\t\t\t\t\t\tisbillinggroupPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Billing Group search icon\r\n\t\t\t\tsearchIconFrom.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = BillingGroupInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromBillingGroup\', inputValue); \r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tBillingGroupInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisbillinggroupPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingGroupFrom\' input keydown event\r\n\t\t\t\tBillingGroupInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = BillingGroupInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isbillinggroupPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromBillingGroup\', inputValue); \r\n\t\t\t\t\t\t\tisbillinggroupPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tBillingGroupInput.addEventListener(\'blur\', handleBlurPopupBillingGroup);\r\n\r\n\t\t\t\t// Reset isbillinggroupPopupShown when focus is on the input field again\r\n\t\t\t\tBillingGroupInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisbillinggroupPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\r\n\t\t\t\t\r\n\t\t\t\t// Create input3From (BillingClass)\r\n\t\t\t\tvar input3From = document.createElement(\'div\');\r\n\t\t\t\tinput3From.className = \"form-input additionalInput\";\r\n\t\t\t\tinput3From.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 155px;\" type=\"text\" placeholder=\"\" id=\"BillingClass\" name=\"BillingClass\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingClass\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromBillingClass\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerTwo.appendChild(input3From);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isbillingclassPopupShown = false; // Flag to track if the popup is shown\r\n\t\t\t\tvar BillingClassInput = input3From.querySelector(\'#BillingClass\');\r\n\t\t\t\tvar searchIconFrom = input3From.querySelector(\'#fromBillingClass\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurBillingClass() {\r\n\t\t\t\t\tvar inputValue = BillingClassInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isbillingclassPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromBillingClass\', inputValue);\r\n\t\t\t\t\t\tisbillingclassPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Billing Class search icon\r\n\t\t\t\tsearchIconFrom.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = BillingClassInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromBillingClass\', inputValue); \r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tBillingClassInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisbillingclassPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingClass\' input keydown event\r\n\t\t\t\tBillingClassInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = BillingClassInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isbillingclassPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromBillingClass\', inputValue); \r\n\t\t\t\t\t\t\tisbillingclassPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tBillingClassInput.addEventListener(\'blur\', handleBlurBillingClass);\r\n\r\n\t\t\t\t// Reset isbillingclassPopupShown when focus is on the input field again\r\n\t\t\t\tBillingClassInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisbillingclassPopupShown = false;\r\n\t\t\t\t});\r\n\r\n                // Create input4From (EffectiveDate)\r\n                var input4From = document.createElement(\'div\');\r\n                input4From.className = \"form-input additionalInput\";\r\n\t\tinput4From.innerHTML = \'<input class=\"floating-input datetime-local\" style=\"width: 160px;\" type=\"datetime-local\" id=\"EffectiveDate\" name=\"EffectiveDate\" onblur=\"dateValidation(1);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"EffectiveDate\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label>\';\r\n                containerTwo.appendChild(input4From);\r\n\r\n                // Append containerTwo to fieldsetFrom\r\n                fieldsetFrom.appendChild(containerTwo);\r\n\r\n                // Create container for input5From\r\n                var containerThree = document.createElement(\'div\');\r\n                containerThree.className = \"flexcontainerthree\";\r\n\r\n\t\t\t\t// Create input5From (CreatedAmendedby)\r\n\t\t\t\tvar input5From = document.createElement(\'div\');\r\n\t\t\t\tinput5From.className = \"form-input additionalInput\";\r\n\t\t\t\tinput5From.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"CreatedAmendedby\" name=\"CreatedAmendedby\" onblur=\"validateInputs(5);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"CreatedAmendedby\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerThree.appendChild(input5From);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isCreatedAmendedbyInputChanged = false; // Rename this if you need to track input changes\r\n\t\t\t\tvar isCreatedAmendedbyPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar CreatedAmendedbyInput = input5From.querySelector(\'#CreatedAmendedby\');\r\n\t\t\t\tvar searchIconFrom = input5From.querySelector(\'#fromAmendedby\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupCreatedAmendedby() {\r\n\t\t\t\t\tvar inputValue = CreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isCreatedAmendedbyPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromAmendedby\', inputValue);\r\n\t\t\t\t\t\tisCreatedAmendedbyPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisCreatedAmendedbyInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' CreatedAmendedby search icon\r\n\t\t\t\tsearchIconFrom.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = CreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tCreatedAmendedbyInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisCreatedAmendedbyInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisCreatedAmendedbyPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'CreatedAmendedby\' input keydown event\r\n\t\t\t\tCreatedAmendedbyInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = CreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isCreatedAmendedbyPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromAmendedby\', inputValue);\r\n\t\t\t\t\t\t\tisCreatedAmendedbyPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tCreatedAmendedbyInput.addEventListener(\'blur\', handleBlurPopupCreatedAmendedby);\r\n\r\n\t\t\t\t// Reset isCreatedAmendedbyPopupShown when focus is on the input field again\r\n\t\t\t\tCreatedAmendedbyInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisCreatedAmendedbyPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n                var input6From = document.createElement(\'div\');\r\n                input6From.className = \"form-input additionalInput\";\r\n                input6From.innerHTML = \'<input class=\"floating-input datetime-local\" style=\"width: 155px;\" type=\"datetime-local\" placeholder=\"\" id=\"CreatedAmendedDate\" name=\"CreatedAmendedDate\" onblur=\"dateValidation(3);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"CreatedAmendedDate\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</label>\';\r\n                containerThree.appendChild(input6From);\r\n\r\n                // Append containerTwo to fieldsetFrom\r\n                fieldsetFrom.appendChild(containerThree);\r\n\r\n                // Append fieldsetFrom to parentDiv or wherever you need to add it\r\n                parentDiv.appendChild(fieldsetFrom);\r\n                \r\n                \r\n\r\n                // Creating fieldset for \'To\' section\r\n                var fieldsetTo = document.createElement(\'fieldset\');\r\n\t\t\t\tfieldsetTo.style.border = \'1px solid #DADCE0\';\r\n                fieldsetTo.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var legendTo = document.createElement(\'legend\');\r\n                legendTo.innerHTML = \'<label for=\"To\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</label>\';\r\n                fieldsetTo.appendChild(legendTo);\r\n\r\n                // Create container for inputTo and input1To\r\n                var containerOneTo = document.createElement(\'div\');\r\n                containerOneTo.className = \"flexcontainerone\";\r\n\r\n\t\t\t\t\t\t\t   // Create inputTo (BillingServiceItemCodeTo)\r\n\t\t\t\tvar inputTo = document.createElement(\'div\');\r\n\t\t\t\tinputTo.className = \"form-input additionalInput\";\r\n\t\t\t\tinputTo.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"BillingServiceItemCodeTo\" name=\"BillingServiceItemCodeTo\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingServiceItemCodeTo\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';    \r\n\t\t\t\tcontainerOneTo.appendChild(inputTo);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\t//var isBillingServiceItemCodeToInputChanged = false;\r\n\t\t\t\tvar isBillingServiceItemCodeToPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar BillingServiceItemCodeToInput = inputTo.querySelector(\'#BillingServiceItemCodeTo\');\r\n\t\t\t\tvar searchIconTo = inputTo.querySelector(\'#toBillingService\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupBillingServiceTo() {\r\n\t\t\t\t\tvar inputValue = BillingServiceItemCodeToInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isBillingServiceItemCodeToPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'toBillingService\', inputValue);\r\n\t\t\t\t\t\tisBillingServiceItemCodeToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\t//isBillingServiceItemCodeToInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Billing Service search icon\r\n\t\t\t\tsearchIconTo.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = BillingServiceItemCodeToInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toBillingService\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tBillingServiceItemCodeToInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\t//isBillingServiceItemCodeToInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisBillingServiceItemCodeToPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingServiceItemCodeTo\' input keydown event\r\n\t\t\t\tBillingServiceItemCodeToInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = BillingServiceItemCodeToInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isBillingServiceItemCodeToPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toBillingService\', inputValue);\r\n\t\t\t\t\t\t\tisBillingServiceItemCodeToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tBillingServiceItemCodeToInput.addEventListener(\'blur\', handleBlurPopupBillingServiceTo);\r\n\r\n\t\t\t\t// Reset isBillingServiceItemCodeToPopupShown when focus is on the input field again\r\n\t\t\t\tBillingServiceItemCodeToInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisBillingServiceItemCodeToPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n              // Create input1To (CustomerCodeTo)\r\n\t\t\t\tvar input1To = document.createElement(\'div\');\r\n\t\t\t\tinput1To.className = \"form-input additionalInput\";\r\n\t\t\t\tinput1To.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 340px;\" type=\"text\" placeholder=\"\" id=\"CustomerCodeTo\" name=\"CustomerCodeTo\" \">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"CustomerCodeTo\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toCustomerCode\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\t// Append input1To to containerOneTo\r\n\t\t\t\tcontainerOneTo.appendChild(input1To);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isCustomerCodeToInputChanged = false;\r\n\t\t\t\tvar isCustomerCodeToPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar CustomerCodeToInput = input1To.querySelector(\'#CustomerCodeTo\');\r\n\t\t\t\tvar searchIconTo = input1To.querySelector(\'#toCustomerCode\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupCustomerCodeTo() {\r\n\t\t\t\t\tvar inputValue = CustomerCodeToInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isCustomerCodeToPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'toCustomerCode\', inputValue);\r\n\t\t\t\t\t\tisCustomerCodeToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisCustomerCodeToInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Customer Code search icon\r\n\t\t\t\tsearchIconTo.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = CustomerCodeToInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toCustomerCode\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tCustomerCodeToInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisCustomerCodeToInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisCustomerCodeToPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'CustomerCodeTo\' input keydown event\r\n\t\t\t\tCustomerCodeToInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = CustomerCodeToInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isCustomerCodeToPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toCustomerCode\', inputValue);\r\n\t\t\t\t\t\t\tisCustomerCodeToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tCustomerCodeToInput.addEventListener(\'blur\', handleBlurPopupCustomerCodeTo);\r\n\r\n\t\t\t\t// Reset isCustomerCodeToPopupShown when focus is on the input field again\r\n\t\t\t\tCustomerCodeToInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisCustomerCodeToPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n\r\n\t\t\t\t// Append containerOneTo to fieldsetTo\r\n\t\t\t\tfieldsetTo.appendChild(containerOneTo);\r\n\r\n\t\t\t\t// Initialize containerTwoTo for further use\r\n\t\t\t\tvar containerTwoTo = document.createElement(\'div\');\r\n\t\t\t\tcontainerTwoTo.className = \"flexcontainerone\";\r\n\r\n\r\n\t\t\t\t\t\t\t\t/// Create input1ToBilling (BillingGroupTo)\r\n\t\t\t\tvar input1ToBilling = document.createElement(\'div\');\r\n\t\t\t\tinput1ToBilling.className = \"form-input additionalInput\";\r\n\t\t\t\tinput1ToBilling.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"BillingGroupTo\" name=\"BillingGroupTo\" onblur=\"handleBlur(event);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingGroupTo\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toBillingGroup\">\' +\r\n\t\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerTwoTo.appendChild(input1ToBilling);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isBillingGroupToInputChanged = false;\r\n\t\t\t\tvar isBillingGroupToPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar BillingGroupToInput = input1ToBilling.querySelector(\'#BillingGroupTo\');\r\n\t\t\t\tvar searchIconToBilling = input1ToBilling.querySelector(\'#toBillingGroup\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupBillingGroupTo() {\r\n\t\t\t\t\tvar inputValue = BillingGroupToInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isBillingGroupToPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'toBillingGroup\', inputValue);\r\n\t\t\t\t\t\tisBillingGroupToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisBillingGroupToInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Billing Group search icon\r\n\t\t\t\tsearchIconToBilling.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = BillingGroupToInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toBillingGroup\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tBillingGroupToInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisBillingGroupToInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisBillingGroupToPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingGroupTo\' input keydown event\r\n\t\t\t\tBillingGroupToInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = BillingGroupToInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isBillingGroupToPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toBillingGroup\', inputValue);\r\n\t\t\t\t\t\t\tisBillingGroupToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tBillingGroupToInput.addEventListener(\'blur\', handleBlurPopupBillingGroupTo);\r\n\r\n\t\t\t\t// Reset isBillingGroupToPopupShown when focus is on the input field again\r\n\t\t\t\tBillingGroupToInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisBillingGroupToPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n\t\t\t\t\t\t\t   // Create input2To (BillingClassTo)\r\n\t\t\t\tvar input2To = document.createElement(\'div\');\r\n\t\t\t\tinput2To.className = \"form-input additionalInput\";\r\n\t\t\t\tinput2To.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 155px;\" type=\"text\" placeholder=\"\" id=\"BillingClassTo\" name=\"BillingClassTo\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"BillingClassTo\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toBillingClass\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerTwoTo.appendChild(input2To);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\t\r\n\t\t\t\tvar isBillingClassToPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar BillingClassToInput = input2To.querySelector(\'#BillingClassTo\');\r\n\t\t\t\tvar searchIconToBillingClass = input2To.querySelector(\'#toBillingClass\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupBillingClassTo() {\r\n\t\t\t\t\tvar inputValue = BillingClassToInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isBillingClassToPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'toBillingClass\', inputValue);\r\n\t\t\t\t\t\tisBillingClassToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Billing Class search icon\r\n\t\t\t\tsearchIconToBillingClass.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = BillingClassToInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toBillingClass\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tBillingClassToInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\t\r\n\t\t\t\t\tisBillingClassToPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'BillingClassTo\' input keydown event\r\n\t\t\t\tBillingClassToInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = BillingClassToInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isBillingClassToPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toBillingClass\', inputValue);\r\n\t\t\t\t\t\t\tisBillingClassToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tBillingClassToInput.addEventListener(\'blur\', handleBlurPopupBillingClassTo);\r\n\r\n\t\t\t\t// Reset isBillingClassToPopupShown when focus is on the input field again\r\n\t\t\t\tBillingClassToInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisBillingClassToPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\r\n                var input3To = document.createElement(\'div\');\r\n                input3To.className = \"form-input additionalInput\";\r\n                input3To.innerHTML = \'<input class=\"floating-input datetime-local\" style=\"width: 170px;\" type=\"datetime-local\" placeholder=\"\" id=\"EffectiveDateTo\" name=\"EffectiveDateTo\" onblur=\"dateValidation(1);\">\' +\r\n                                     \'<label class=\"floating-label\" for=\"EffectiveDateTo\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</label>\';\r\n                containerTwoTo.appendChild(input3To);\r\n\r\n                fieldsetTo.appendChild(containerTwoTo);\r\n\r\n                // Create container for input5From\r\n                var containerThreeTo = document.createElement(\'div\');\r\n                containerThreeTo.className = \"flexcontainerthree\";\r\n\r\n\t\t\t\t\t\t\t\t// Create input5To (CreatedAmendedbyTo)\r\n\t\t\t\tvar input5To = document.createElement(\'div\');\r\n\t\t\t\tinput5To.className = \"form-input additionalInput\";\r\n\t\t\t\tinput5To.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"CreatedAmendedbyTo\" name=\"CreatedAmendedbyTo\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"CreatedAmendedbyTo\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tcontainerThreeTo.appendChild(input5To);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isCreatedAmendedbyToInputChanged = false;\r\n\t\t\t\tvar isCreatedAmendedbyToPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar CreatedAmendedbyToInput = input5To.querySelector(\'#CreatedAmendedbyTo\');\r\n\t\t\t\tvar searchIconToAmendedby = input5To.querySelector(\'#toAmendedby\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupCreatedAmendedbyTo() {\r\n\t\t\t\t\tvar inputValue = CreatedAmendedbyToInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isCreatedAmendedbyToPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'toAmendedby\', inputValue);\r\n\t\t\t\t\t\tisCreatedAmendedbyToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisCreatedAmendedbyToInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Amendedby search icon\r\n\t\t\t\tsearchIconToAmendedby.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = CreatedAmendedbyToInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tCreatedAmendedbyToInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisCreatedAmendedbyToInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisCreatedAmendedbyToPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'CreatedAmendedbyTo\' input keydown event\r\n\t\t\t\tCreatedAmendedbyToInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = CreatedAmendedbyToInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isCreatedAmendedbyToPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toAmendedby\', inputValue);\r\n\t\t\t\t\t\t\tisCreatedAmendedbyToPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tCreatedAmendedbyToInput.addEventListener(\'blur\', handleBlurPopupCreatedAmendedbyTo);\r\n\r\n\t\t\t\t// Reset isCreatedAmendedbyToPopupShown when focus is on the input field again\r\n\t\t\t\tCreatedAmendedbyToInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisCreatedAmendedbyToPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n                \r\n                var input6To = document.createElement(\'div\');\r\n                input6To.className = \"form-input additionalInput\";\r\n                input6To.innerHTML = \'<input class=\"floating-input datetime-local\" style=\"width: 155px;\" type=\"datetime-local\" placeholder=\"\" id=\"CreatedAmendedDateTo\" name=\"CreatedAmendedDateTo\" onblur=\"dateValidation(2);dateValidation(4);\">\' +\r\n                                     \'<label class=\"floating-label\" for=\"CreatedAmendedDateTo\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</label>\';\r\n                containerThreeTo.appendChild(input6To);\r\n\r\n                // Append containerTwo to fieldsetFrom\r\n                fieldsetTo.appendChild(containerThreeTo);\r\n\r\n                parentDiv.appendChild(fieldsetTo);\r\n                \r\n\t\t\t\r\n\t\t\t\t\r\n/*                \r\n\r\n                var buttonContainer = document.createElement(\'div\');\r\n                buttonContainer.className = \'button-container\';\r\n                \r\n             // Create the submit button\r\n                var SubmitButton = document.createElement(\'button\');\r\n                SubmitButton.type = \'submit\'; \r\n                SubmitButton.className = \'btn btn-primary\';\r\n                SubmitButton.textContent = \'Submit\';\r\n\r\n                SubmitButton.addEventListener(\'click\', function(event) {\r\n\t\t\t\t\t\r\n                    event.preventDefault();\r\n                    var customerCodeInput = document.getElementById(\'CustomerCode\');\r\n                    \r\n                    /* if (customerCodeInput) {\r\n                        var customerCodeValue = customerCodeInput.value.trim();\r\n                        \r\n                        if (customerCodeValue === \'\') {\r\n                            alert(\'BLServItemPriceList.jsp Customer Code is required.\');\r\n                            return; \r\n                        }\r\n\t\t\t\t\t\t\r\n                    } \r\n                    alert(\'Submit button clicked! Form is valid.\');\r\n                    getSessionID();\r\n\t\t\t\t\t\r\n\t\t\t\t\treportPopup(\"Report Options\");\r\n\t\t\t\t\t\r\n                   // form.submit(); \r\n\t\t\t\t\t\r\n                });\r\n                    \r\n                    \r\n\r\n                // Create the button container\r\n                var buttonContainer = document.createElement(\'div\');\r\n                buttonContainer.className = \'button-container\';\r\n\r\n                // Append the submit button to the button container\r\n                buttonContainer.appendChild(SubmitButton);\r\n\r\n                // Append the button container to the form\r\n                form.appendChild(buttonContainer);\r\n\r\n                // Append the form to the parentDiv\r\n                parentDiv.appendChild(form); */\r\n\r\n              \r\n\r\n            } else if (reportType === \"option2\") {\r\n\r\n            \t$(\'#p_report_id\').val(\"BLRITLST\");\r\n            \t$(\'#price_ind\').val(\"N\");\t\t\t//Price Indicator value is \"N\" for Drugs based on the Item Price List -- Item type\r\n            \tvar drugInput1 = document.createElement(\'div\');\r\n            \tdrugInput1.className = \"form-input additionalInput\";\r\n            \tdrugInput1.innerHTML = \'<select class=\"inputselect\"  style=\"margin-right: 15px\"; name=\"drugInput1status\" id=\"drugInput1status\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"drugInput1status\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</label>\';\r\n                parentDiv.appendChild(drugInput1);\r\n                \r\n                // Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof drugStatusJSONOption1 !== \'undefined\') { // Check if selectOptions is available\r\n                \tpopulatedrugStatus(drugStatusJSONOption1);\r\n                } else {\r\n                  console.error(\"drugStatusJSONOption1 variable not available from server-side script.\");\r\n                }\r\n\t\t\t\t\r\n                var drugInput2 = document.createElement(\'div\');\r\n                drugInput2.className = \"form-input additionalInput\";\r\n                drugInput2.innerHTML = \'<select class=\"inputselect\" style=\"margin-right: 10px\"; name=\"drugInput2FacilityID\" id=\"drugInput2FacilityID\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                          \r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"drugInput2FacilityID\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</label>\';\r\n                parentDiv.appendChild(drugInput2);\r\n                // Assuming you have a way to access the server-side generated selectOptions variable\r\n                if (typeof drugFacilityJSONOptions1 !== \'undefined\') { // Check if selectOptions is available\r\n                  populatedrugFacilityID(drugFacilityJSONOptions1);\r\n                } else {\r\n                  console.error(\"drugFacilityJSONOptions1 variable not available from server-side script.\");\r\n                }\r\n                \r\n               \r\n                \r\n                var drugInput3 = document.createElement(\'div\');\r\n                drugInput3.className = \"form-input additionalInput \"; \r\n\t\t\t\tdrugInput3.style.marginBottom = \"10px\";\r\n                drugInput3.innerHTML = \'<input style=\"margin-top: 16px; width: 15px; height: 12px;\" class=\"checkboxinput\" type=\"checkbox\" id=\"checkboxByNameTradeBatch\" name=\"checkboxByNameTradeBatch\">\' +\r\n                                          \'<label style=\"font-family: Segoe UI, Regular; font-size: 14px; color: #171717;\" class=\"checkboxlabel\" for=\"ByNameTradeBatch\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label>\';\r\n\r\n                parentDiv.appendChild(drugInput3);\r\n                \r\n            \t// Creating fieldset for \'drugInputFrom\' section\r\n                var drugInputfieldsetFrom = document.createElement(\'fieldset\');\r\n\t\t\t\tdrugInputfieldsetFrom.style.border = \'1px solid #DADCE0\';\r\n\t\t\t\tdrugInputfieldsetFrom.style.width =  \'48%\';\r\n\t\t\t\tdrugInputfieldsetFrom.style.marginRight = \'10px\';\r\n\t\t\t\tdrugInputfieldsetFrom.style.paddingBottom = \'50px\';\r\n                drugInputfieldsetFrom.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var drugInputlegendFrom = document.createElement(\'legend\');\r\n                drugInputlegendFrom.innerHTML = \'<label for=\"From\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</label>\';\r\n                drugInputfieldsetFrom.appendChild(drugInputlegendFrom);\r\n\r\n                // Create container for drugInputFrom and drugInput1From\r\n                var drugInputcontainerOne = document.createElement(\'div\');\r\n                drugInputcontainerOne.className = \"flexcontainerone\";\r\n\r\n\t\t\t\t\t\t\t   // Create drugInputFrom (drugInputBillingServiceItemCode)\r\n\t\t\t\tvar drugInputFrom = document.createElement(\'div\');\r\n\t\t\t\tdrugInputFrom.className = \"form-input additionalInput\";\r\n\t\t\t\tdrugInputFrom.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"drugInputBillingServiceItemCode\" name=\"drugInputBillingServiceItemCode\" onblur=\"drugvalidateInputs(2);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"drugInputBillingServiceItemCode\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromDrugBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tdrugInputcontainerOne.appendChild(drugInputFrom);\r\n\r\n\t\t\t\t// User input\r\n\t\t\t\tvar isDrugInputChanged = false;\r\n\t\t\t\tvar isDrugPopupShown = false; // Add a flag to track if the popup is shown\r\n\t\t\t\tvar drugInputBillingServiceInput = drugInputFrom.querySelector(\'#drugInputBillingServiceItemCode\');\r\n\t\t\t\tvar searchIconFromDrugBillingService = drugInputFrom.querySelector(\'#fromDrugBillingService\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleBlurPopupDrugInput() {\r\n\t\t\t\t\tvar inputValue = drugInputBillingServiceInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromDrugBillingService\', inputValue);\r\n\t\t\t\t\t\tisDrugPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisDrugInputChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Drug Billing Service search icon\r\n\t\t\t\tsearchIconFromDrugBillingService.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = drugInputBillingServiceInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromDrugBillingService\', inputValue);\r\n\t\t\t\t});\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tdrugInputBillingServiceInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisDrugInputChanged = true; // Track input changes if needed\r\n\t\t\t\t\tisDrugPopupShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'drugInputBillingServiceItemCode\' input keydown event\r\n\t\t\t\tdrugInputBillingServiceInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = drugInputBillingServiceInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromDrugBillingService\', inputValue);\r\n\t\t\t\t\t\t\tisDrugPopupShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tdrugInputBillingServiceInput.addEventListener(\'blur\', handleBlurPopupDrugInput);\r\n\r\n\t\t\t\t// Reset isDrugPopupShown when focus is on the input field again\r\n\t\t\t\tdrugInputBillingServiceInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisDrugPopupShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\t\r\n\t\t\t\t// Create drugInput1From (drugInputCreatedAmendedby)\r\n\t\t\t\tvar drugInputCreatedAmendedby = document.createElement(\'div\');\r\n\t\t\t\tdrugInputCreatedAmendedby.className = \"form-input additionalInput\";\r\n\t\t\t\tdrugInputCreatedAmendedby.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"drugInputCreatedAmendedby\" name=\"drugInputCreatedAmendedby\" onblur=\"drugvalidateInputs(1);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"drugInputCreatedAmendedby\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromDrugAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tdrugInputcontainerOne.appendChild(drugInputCreatedAmendedby);\r\n\r\n\t\t\t\t// User input tracking\r\n\t\t\t\tvar isDrugInputAmendedbyChanged = false; // Track if the drug input value has changed\r\n\t\t\t\tvar isDrugPopupAmendedbyShown = false;  // Track if the drug popup is currently shown\r\n\r\n\t\t\t\tvar drugInputCreatedAmendedbyInput = drugInputCreatedAmendedby.querySelector(\'#drugInputCreatedAmendedby\');\r\n\t\t\t\tvar searchIconFromDrugAmendedby = drugInputCreatedAmendedby.querySelector(\'#fromDrugAmendedby\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleDrugInputAmendedbyBlur() {\r\n\t\t\t\t\tvar inputValue = drugInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupAmendedbyShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromDrugAmendedby\', inputValue);\r\n\t\t\t\t\t\tisDrugPopupAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisDrugInputAmendedbyChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Drug Amendedby search icon\r\n\t\t\t\tsearchIconFromDrugAmendedby.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = drugInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromDrugAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tdrugInputCreatedAmendedbyInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisDrugInputAmendedbyChanged = true; // Track input changes\r\n\t\t\t\t\tisDrugPopupAmendedbyShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'drugInputCreatedAmendedby\' input keydown event\r\n\t\t\t\tdrugInputCreatedAmendedbyInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = drugInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupAmendedbyShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromDrugAmendedby\', inputValue);\r\n\t\t\t\t\t\t\tisDrugPopupAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tdrugInputCreatedAmendedbyInput.addEventListener(\'blur\', handleDrugInputAmendedbyBlur);\r\n\r\n\t\t\t\t// Reset isDrugPopupAmendedbyShown when focus is on the input field again\r\n\t\t\t\tdrugInputCreatedAmendedbyInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisDrugPopupAmendedbyShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n             \t// Append containerOne to fieldsetFrom\r\n                drugInputfieldsetFrom.appendChild(drugInputcontainerOne);\r\n\t\t\t\t\r\n\t\t\t\t\r\n\r\n             \t// Create container for drugInput2From\r\n                var drugInputcontainerTwo = document.createElement(\'div\');\r\n                drugInputcontainerTwo.className = \"flexcontainerTwo\";\r\n\r\n                // Create input2From (CreatedAmendedDate)\r\n                var drugInput2From = document.createElement(\'div\');\r\n                drugInput2From.className = \"form-input additionalInput\";\r\n                drugInput2From.innerHTML = \'<input class=\"floating-input datetime-local drug\" style=\"width: 180px;\" type=\"datetime-local\" placeholder=\"\" id=\"drugInputCreatedAmendedDate\" name=\"drugInputCreatedAmendedDate\" onblur=\"drugDateValidation(2);drugDateValidation(3);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"drugInputCreatedAmendedDate\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\';\r\n             \tdrugInputcontainerTwo.appendChild(drugInput2From);\r\n             \t// Append drugInputcontainerTwo to fieldsetFrom\r\n                drugInputfieldsetFrom.appendChild(drugInputcontainerTwo);\r\n                \r\n                parentDiv.appendChild(drugInputfieldsetFrom);//adding to parentDiv\r\n\r\n            \t// Creating fieldset for \'drugInputTo\' section\r\n                var drugInputfieldsetTo = document.createElement(\'fieldset\');\r\n\t\t\t\tdrugInputfieldsetTo.style.border = \'1px solid #DADCE0\';\r\n\t\t\t\tdrugInputfieldsetTo.style.width =  \'47%\';\r\n\t\t\t\tdrugInputfieldsetTo.style.paddingBottom = \'50px\';\r\n                drugInputfieldsetTo.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var drugInputlegendTo = document.createElement(\'legend\');\r\n                drugInputlegendTo.innerHTML = \'<label for=\"From\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</label>\';\r\n                drugInputfieldsetTo.appendChild(drugInputlegendTo);\r\n\r\n                // Create container for drugInputTo and drugInput1To\r\n                var drugInputcontainerOneTo = document.createElement(\'div\');\r\n                drugInputcontainerOneTo.className = \"flexcontainerone\";\r\n\r\n\t\t\t\t\t\t\t   // Create drugInputTo (drugInputToBillingServiceItemCode)\r\n\t\t\t\tvar drugInputToBillingServiceItemCode = document.createElement(\'div\');\r\n\t\t\t\tdrugInputToBillingServiceItemCode.className = \"form-input additionalInput\";\r\n\t\t\t\tdrugInputToBillingServiceItemCode.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"drugInputToBillingServiceItemCode\" name=\"drugInputToBillingServiceItemCode\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"drugInputToBillingServiceItemCode\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toDrugBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tdrugInputcontainerOneTo.appendChild(drugInputToBillingServiceItemCode);\r\n\r\n\t\t\t\t// User input tracking\r\n\t\t\t\tvar isDrugInputToChanged = false; // Track if the drug input value has changed\r\n\t\t\t\tvar isDrugPopupToShown = false;  // Track if the drug popup is currently shown\r\n\r\n\t\t\t\tvar drugInputToBillingServiceInput = drugInputToBillingServiceItemCode.querySelector(\'#drugInputToBillingServiceItemCode\');\r\n\t\t\t\tvar searchIconToDrugBillingService = drugInputToBillingServiceItemCode.querySelector(\'#toDrugBillingService\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleDrugInputToBlur() {\r\n\t\t\t\t\tvar inputValue = drugInputToBillingServiceInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupToShown) {\r\n\t\t\t\t\t\tshowPopup(\'toDrugBillingService\', inputValue);\r\n\t\t\t\t\t\tisDrugPopupToShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisDrugInputToChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Drug Billing Service search icon\r\n\t\t\t\tsearchIconToDrugBillingService.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = drugInputToBillingServiceInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toDrugBillingService\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tdrugInputToBillingServiceInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisDrugInputToChanged = true; // Track input changes\r\n\t\t\t\t\tisDrugPopupToShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'drugInputToBillingServiceItemCode\' input keydown event\r\n\t\t\t\tdrugInputToBillingServiceInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = drugInputToBillingServiceInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupToShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toDrugBillingService\', inputValue);\r\n\t\t\t\t\t\t\tisDrugPopupToShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tdrugInputToBillingServiceInput.addEventListener(\'blur\', handleDrugInputToBlur);\r\n\r\n\t\t\t\t// Reset isDrugPopupToShown when focus is on the input field again\r\n\t\t\t\tdrugInputToBillingServiceInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisDrugPopupToShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t// Create drugInput1To (drugInputToCreatedAmendedby)\r\n\t\t\t\tvar drugInputToCreatedAmendedby = document.createElement(\'div\');\r\n\t\t\t\tdrugInputToCreatedAmendedby.className = \"form-input additionalInput\";\r\n\t\t\t\tdrugInputToCreatedAmendedby.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"drugInputToCreatedAmendedby\" name=\"drugInputToCreatedAmendedby\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"drugInputToCreatedAmendedby\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toDrugAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tdrugInputcontainerOneTo.appendChild(drugInputToCreatedAmendedby);\r\n\r\n\t\t\t\t// User input tracking\r\n\t\t\t\tvar isDrugInputToCreatedAmendedbyChanged = false; // Track if the drug input value has changed\r\n\t\t\t\tvar isDrugPopupToCreatedAmendedbyShown = false;  // Track if the drug popup is currently shown\r\n\r\n\t\t\t\tvar drugInputToCreatedAmendedbyInput = drugInputToCreatedAmendedby.querySelector(\'#drugInputToCreatedAmendedby\');\r\n\t\t\t\tvar searchIconToDrugAmendedby = drugInputToCreatedAmendedby.querySelector(\'#toDrugAmendedby\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleDrugInputToCreatedAmendedbyBlur() {\r\n\t\t\t\t\tvar inputValue = drugInputToCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupToCreatedAmendedbyShown) {\r\n\t\t\t\t\t\tshowPopup(\'toDrugAmendedby\', inputValue);\r\n\t\t\t\t\t\tisDrugPopupToCreatedAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisDrugInputToCreatedAmendedbyChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'To\' Drug Amendedby search icon\r\n\t\t\t\tsearchIconToDrugAmendedby.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = drugInputToCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toDrugAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tdrugInputToCreatedAmendedbyInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisDrugInputToCreatedAmendedbyChanged = true; // Track input changes\r\n\t\t\t\t\tisDrugPopupToCreatedAmendedbyShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'drugInputToCreatedAmendedby\' input keydown event\r\n\t\t\t\tdrugInputToCreatedAmendedbyInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = drugInputToCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isDrugPopupToCreatedAmendedbyShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'toDrugAmendedby\', inputValue);\r\n\t\t\t\t\t\t\tisDrugPopupToCreatedAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tdrugInputToCreatedAmendedbyInput.addEventListener(\'blur\', handleDrugInputToCreatedAmendedbyBlur);\r\n\r\n\t\t\t\t// Reset isDrugPopupToCreatedAmendedbyShown when focus is on the input field again\r\n\t\t\t\tdrugInputToCreatedAmendedbyInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisDrugPopupToCreatedAmendedbyShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\r\n             \t// Append drugInputcontainerOneTo to fieldsetFrom\r\n                drugInputfieldsetTo.appendChild(drugInputcontainerOneTo);\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\r\n             \t\r\n             \t// Create container for drugInput2To\r\n                var drugInputcontainerTwoTo = document.createElement(\'div\');\r\n                drugInputcontainerTwoTo.className = \"flexcontainerTwo\";\r\n\r\n                // Create input2From (CreatedAmendedDate)\r\n                var drugInput2To = document.createElement(\'div\');\r\n                drugInput2To.className = \"form-input additionalInput\";\r\n                drugInput2To.innerHTML = \'<input class=\"floating-input datetime-local drug\" style=\"width: 180px;\" type=\"datetime-local\" placeholder=\"\" id=\"drugInputToCreatedAmendedDate\" name=\"drugInputToCreatedAmendedDate\" onblur=\"drugDateValidation(2);drugDateValidation(4);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"drugInputToCreatedAmendedDate\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</label>\';\r\n             \tdrugInputcontainerTwoTo.appendChild(drugInput2To);\r\n             \t// Append drugInputcontainerTwo to fieldsetFrom\r\n                drugInputfieldsetTo.appendChild(drugInputcontainerTwoTo);\r\n                \r\n                parentDiv.appendChild(drugInputfieldsetTo);//adding to parentDiv\r\n              \r\n            } else if (reportType === \"option3\") {\r\n            \t$(\'#p_report_id\').val(\"BLRITLST\");\r\n            \t$(\'#price_ind\').val(\"Y\");\t\t\t\t//Price Indicator value is \"Y\" for Consumables based on the Item Price List -- Item type\r\n            \tvar consumableInput1 = document.createElement(\'div\');\r\n            \tconsumableInput1.className = \"form-input additionalInput\";\r\n            \tconsumableInput1.innerHTML = \'<select class=\"inputselect\"  style=\"margin-right: 15px\"; name=\"consumableInput1status\" id=\"consumableInput1status\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                         \r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"consumableInput1status\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</label>\';\r\n                parentDiv.appendChild(consumableInput1);\r\n\t\t\t\tif (typeof consumableStatusJSONOption1 !== \'undefined\') { // Check if selectOptions is available\r\n                \tpopulateconsumableStatus(consumableStatusJSONOption1);\r\n                } else {\r\n\t\t\t\tconsole.error(\"consumableStatusJSONOption1 variable not available from server-side script\");\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\r\n                var consumableInput2 = document.createElement(\'div\');\r\n                consumableInput2.className = \"form-input additionalInput\";\r\n                consumableInput2.innerHTML = \'<select class=\"inputselect\"  style=\"margin-right: 10px\"; name=\"consumableInput2FacilityID\" id=\"consumableInput2FacilityID\" onclick=\"this.setAttribute(\\\'value\\\', this.value);\" onchange=\"this.setAttribute(\\\'value\\\', this.value);\" >\' +\r\n                                          \'</select>\' +\r\n                                          \'<label class=\"label-select\" for=\"consumableInput2FacilityID\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</label>\';\r\n                parentDiv.appendChild(consumableInput2);\r\n\t\t\t\t if (typeof consumableFacilityJSONOptions1 !== \'undefined\') { // Check if selectOptions is available\r\n                  populateconsumableFacilityID(consumableFacilityJSONOptions1);\r\n                } else {\r\n                  console.error(\"consumableFacilityJSONOptions1 variable not available from server-side script.\");\r\n                }\r\n                \r\n                var consumableInput3 = document.createElement(\'div\');\r\n                consumableInput3.className = \"form-input additionalInput\"; \r\n\t\t\t\tconsumableInput3.style.marginBottom = \"10px\";\r\n                consumableInput3.innerHTML = \'<input style=\"margin-top: 16px; width: 15px; height: 12px;\" class=\"checkboxinput\" type=\"checkbox\" id=\"consumablecheckboxByNameTradeBatch\" name=\"consumablecheckboxByNameTradeBatch\">\' +\r\n                                          \'<label style=\"font-family: Segoe UI, Regular; font-size: 14px; color: #171717;\" class=\"checkboxlabel\" for=\"consumableByNameTradeBatch\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</label>\';\r\n\r\n                parentDiv.appendChild(consumableInput3);\r\n                \r\n            \t// Creating fieldset for \'consumableInputFrom\' section\r\n                var consumableInputfieldsetFrom = document.createElement(\'fieldset\');\r\n\t\t\t\tconsumableInputfieldsetFrom.style.border = \'1px solid #DADCE0\';\r\n\t\t\t\tconsumableInputfieldsetFrom.style.width =  \'48%\';\r\n\t\t\t\tconsumableInputfieldsetFrom.style.paddingBottom = \'50px\';\r\n\t\t\t\tconsumableInputfieldsetFrom.style.marginRight = \'10px\';\r\n                consumableInputfieldsetFrom.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var consumableInputlegendFrom = document.createElement(\'legend\');\r\n                consumableInputlegendFrom.innerHTML = \'<label for=\"From\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</label>\';\r\n                consumableInputfieldsetFrom.appendChild(consumableInputlegendFrom);\r\n\r\n                // Create container for consumableInputFrom and consumableInput1From\r\n                var consumableInputcontainerOne = document.createElement(\'div\');\r\n                consumableInputcontainerOne.className = \"flexcontainerone\";\r\n\r\n                // Create consumableInputFrom (consumableInputBillingServiceItemCode)\r\n\t\t\t\tvar consumableInputFrom = document.createElement(\'div\');\r\n\t\t\t\tconsumableInputFrom.className = \"form-input additionalInput\";\r\n\t\t\t\tconsumableInputFrom.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"consumableInputBillingServiceItemCode\" name=\"consumableInputBillingServiceItemCode\" onblur=\"consumableValidateInputs(2);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"consumableInputBillingServiceItemCode\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromConsumableBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tconsumableInputcontainerOne.appendChild(consumableInputFrom);\r\n\r\n\t\t\t\t// User input tracking\r\n\t\t\t\tvar isConsumableInputBillingServiceItemCodeChanged = false; // Track if the consumable input value has changed\r\n\t\t\t\tvar isConsumablePopupBillingServiceItemCodeShown = false;  // Track if the consumable popup is currently shown\r\n\r\n\t\t\t\tvar consumableInputBillingServiceInput = consumableInputFrom.querySelector(\'#consumableInputBillingServiceItemCode\');\r\n\t\t\t\tvar searchIconFromConsumableBillingService = consumableInputFrom.querySelector(\'#fromConsumableBillingService\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleConsumableInputBillingServiceItemCodeBlur() {\r\n\t\t\t\t\tvar inputValue = consumableInputBillingServiceInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isConsumablePopupBillingServiceItemCodeShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromConsumableBillingService\', inputValue);\r\n\t\t\t\t\t\tisConsumablePopupBillingServiceItemCodeShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisConsumableInputBillingServiceItemCodeChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Consumable Billing Service search icon\r\n\t\t\t\tsearchIconFromConsumableBillingService.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = consumableInputBillingServiceInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromConsumableBillingService\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tconsumableInputBillingServiceInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisConsumableInputBillingServiceItemCodeChanged = true; // Track input changes\r\n\t\t\t\t\tisConsumablePopupBillingServiceItemCodeShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'consumableInputBillingServiceItemCode\' input keydown event\r\n\t\t\t\tconsumableInputBillingServiceInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = consumableInputBillingServiceInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isConsumablePopupBillingServiceItemCodeShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromConsumableBillingService\', inputValue);\r\n\t\t\t\t\t\t\tisConsumablePopupBillingServiceItemCodeShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tconsumableInputBillingServiceInput.addEventListener(\'blur\', handleConsumableInputBillingServiceItemCodeBlur);\r\n\r\n\t\t\t\t// Reset isConsumablePopupBillingServiceItemCodeShown when focus is on the input field again\r\n\t\t\t\tconsumableInputBillingServiceInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisConsumablePopupBillingServiceItemCodeShown = false;\r\n\t\t\t\t});\r\n\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t// Create consumableInput1From (CreatedAmendedby)\r\n\t\t\t\tvar consumableInput1From = document.createElement(\'div\');\r\n\t\t\t\tconsumableInput1From.className = \"form-input additionalInput\";\r\n\t\t\t\tconsumableInput1From.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"consumableInputCreatedAmendedby\" name=\"consumableInputCreatedAmendedby\" onblur=\"consumableValidateInputs(1);\">\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"consumableInputCreatedAmendedby\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"fromConsumableCreatedAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\n\t\t\t\tconsumableInputcontainerOne.appendChild(consumableInput1From);\r\n\r\n\t\t\t\t// User input tracking\r\n\t\t\t\tvar isConsumableInputCreatedAmendedbyChanged = false; // Track if the consumable input value has changed\r\n\t\t\t\tvar isConsumablePopupCreatedAmendedbyShown = false;  // Track if the consumable popup is currently shown\r\n\r\n\t\t\t\tvar consumableInputCreatedAmendedbyInput = consumableInput1From.querySelector(\'#consumableInputCreatedAmendedby\');\r\n\t\t\t\tvar searchIconFromConsumableCreatedAmendedby = consumableInput1From.querySelector(\'#fromConsumableCreatedAmendedby\');\r\n\r\n\t\t\t\t// Function to handle blur event\r\n\t\t\t\tfunction handleConsumableInputCreatedAmendedbyBlur() {\r\n\t\t\t\t\tvar inputValue = consumableInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tif (inputValue !== \'\' && !isConsumablePopupCreatedAmendedbyShown) {\r\n\t\t\t\t\t\tshowPopup(\'fromConsumableCreatedAmendedby\', inputValue);\r\n\t\t\t\t\t\tisConsumablePopupCreatedAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t}\r\n\t\t\t\t\tisConsumableInputCreatedAmendedbyChanged = false; // Reset input changed status on blur\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Event listener for \'From\' Consumable Created Amendedby search icon\r\n\t\t\t\tsearchIconFromConsumableCreatedAmendedby.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = consumableInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'fromConsumableCreatedAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for input field\r\n\t\t\t\tconsumableInputCreatedAmendedbyInput.addEventListener(\'input\', function() {\r\n\t\t\t\t\tisConsumableInputCreatedAmendedbyChanged = true; // Track input changes\r\n\t\t\t\t\tisConsumablePopupCreatedAmendedbyShown = false; // Reset popup shown flag when input changes\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Event listener for \'consumableInputCreatedAmendedby\' input keydown event\r\n\t\t\t\tconsumableInputCreatedAmendedbyInput.addEventListener(\'keydown\', function(event) {\r\n\t\t\t\t\tif (event.key === \'Tab\') {\r\n\t\t\t\t\t\tvar inputValue = consumableInputCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\t\tif (inputValue !== \'\' && !isConsumablePopupCreatedAmendedbyShown) {\r\n\t\t\t\t\t\t\tshowPopup(\'fromConsumableCreatedAmendedby\', inputValue);\r\n\t\t\t\t\t\t\tisConsumablePopupCreatedAmendedbyShown = true; // Mark popup as shown\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t});\r\n\r\n\t\t\t\t// Add blur event listener to the input\r\n\t\t\t\tconsumableInputCreatedAmendedbyInput.addEventListener(\'blur\', handleConsumableInputCreatedAmendedbyBlur);\r\n\r\n\t\t\t\t// Reset isConsumablePopupCreatedAmendedbyShown when focus is on the input field again\r\n\t\t\t\tconsumableInputCreatedAmendedbyInput.addEventListener(\'focus\', function() {\r\n\t\t\t\t\tisConsumablePopupCreatedAmendedbyShown = false;\r\n\t\t\t\t});\r\n\r\n             \t\r\n                consumableInputfieldsetFrom.appendChild(consumableInputcontainerOne);\r\n\r\n             \t\r\n             \t// Create container for consumableInput2From\r\n                var consumableInputcontainerTwo = document.createElement(\'div\');\r\n               consumableInputcontainerTwo.className = \"flexcontainerTwo\";\r\n\r\n                // Create input2From (CreatedAmendedDate)\r\n                var consumableInput2From = document.createElement(\'div\');\r\n                consumableInput2From.className = \"form-input additionalInput\";\r\n                consumableInput2From.innerHTML = \'<input class=\"floating-input datetime-local drug\" style=\"width: 180px;\" type=\"datetime-local\" placeholder=\"\" id=\"consumableInputCreatedAmendedDate\" name=\"consumableInputCreatedAmendedDate\" onblur=\"consumableDateValidation(2);consumableDateValidation(3);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"consumableInputCreatedAmendedDate\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</label>\';\r\n             \tconsumableInputcontainerTwo.appendChild(consumableInput2From);\r\n             \t// Append consumableInputcontainerTwo to fieldsetFrom\r\n               consumableInputfieldsetFrom.appendChild(consumableInputcontainerTwo);\r\n                \r\n                parentDiv.appendChild(consumableInputfieldsetFrom);//adding to parentDiv\r\n                \r\n            \t// Creating fieldset for \'consumableInputTo\' section\r\n                var consumableInputfieldsetTo = document.createElement(\'fieldset\');\r\n\t\t\t\tconsumableInputfieldsetTo.style.border = \'1px solid #DADCE0\';\r\n\t\t\t\tconsumableInputfieldsetTo.style.width =  \'47%\';\r\n\t\t\t\tconsumableInputfieldsetTo.style.paddingBottom = \'50px\';\r\n                consumableInputfieldsetTo.className = \'fieldsetStyling additionalInput\'; // Adding a class to the fieldset element\r\n                var consumableInputlegendTo = document.createElement(\'legend\');\r\n                consumableInputlegendTo.innerHTML = \'<label for=\"From\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</label>\';\r\n                consumableInputfieldsetTo.appendChild(consumableInputlegendTo);\r\n\r\n                // Create container for consumableInputTo and consumableInput1To\r\n                var consumableInputcontainerOneTo = document.createElement(\'div\');\r\n                consumableInputcontainerOneTo.className = \"flexcontainerone\";\r\n\r\n               // Create consumableInputTo (BillingServiceItemCode)\r\n\t\t\t\tvar consumableInputTo = document.createElement(\'div\');\r\n\t\t\t\tconsumableInputTo.className = \"form-input additionalInput\";\r\n\t\t\t\tconsumableInputTo.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"consumableInputToBillingServiceItemCode\" name=\"consumableInputToBillingServiceItemCode\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"consumableInputToBillingServiceItemCode\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toConsumableBillingService\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\nconsumableInputcontainerOneTo.appendChild(consumableInputTo);\r\n\r\n// User input tracking\r\nvar isConsumableInputToBillingServiceChanged = false; // Track if the consumable input value has changed\r\nvar isConsumablePopupToBillingServiceShown = false;  // Track if the consumable popup is currently shown\r\n\r\nvar consumableInputToBillingServiceInput = consumableInputTo.querySelector(\'#consumableInputToBillingServiceItemCode\');\r\nvar searchIconToConsumableBillingService = consumableInputTo.querySelector(\'#toConsumableBillingService\');\r\n\r\n// Function to handle blur event\r\nfunction handleConsumableInputToBillingServiceBlur() {\r\n    var inputValue = consumableInputToBillingServiceInput.value.trim();\r\n    if (inputValue !== \'\' && !isConsumablePopupToBillingServiceShown) {\r\n        showPopup(\'toConsumableBillingService\', inputValue);\r\n        isConsumablePopupToBillingServiceShown = true; // Mark popup as shown\r\n    }\r\n    isConsumableInputToBillingServiceChanged = false; // Reset input changed status on blur\r\n}\r\n\r\n\t\t\t\t// Event listener for \'To\' Consumable Billing Service search icon\r\n\t\t\t\tsearchIconToConsumableBillingService.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = consumableInputToBillingServiceInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toConsumableBillingService\', inputValue);\r\n\t\t\t\t});\r\n\r\n// Event listener for input field\r\nconsumableInputToBillingServiceInput.addEventListener(\'input\', function() {\r\n    isConsumableInputToBillingServiceChanged = true; // Track input changes\r\n    isConsumablePopupToBillingServiceShown = false; // Reset popup shown flag when input changes\r\n});\r\n\r\n// Event listener for \'consumableInputToBillingServiceItemCode\' input keydown event\r\nconsumableInputToBillingServiceInput.addEventListener(\'keydown\', function(event) {\r\n    if (event.key === \'Tab\') {\r\n        var inputValue = consumableInputToBillingServiceInput.value.trim();\r\n        if (inputValue !== \'\' && !isConsumablePopupToBillingServiceShown) {\r\n            showPopup(\'toConsumableBillingService\', inputValue);\r\n            isConsumablePopupToBillingServiceShown = true; // Mark popup as shown\r\n        }\r\n    }\r\n});\r\n\r\n// Add blur event listener to the input\r\nconsumableInputToBillingServiceInput.addEventListener(\'blur\', handleConsumableInputToBillingServiceBlur);\r\n\r\n// Reset isConsumablePopupToBillingServiceShown when focus is on the input field again\r\nconsumableInputToBillingServiceInput.addEventListener(\'focus\', function() {\r\n    isConsumablePopupToBillingServiceShown = false;\r\n});\r\n\r\n\t\t\t\t\r\n\r\n\t\t\t\t\t\t\t   // Create consumableInput1To (CreatedAmendedby)\r\n\t\t\t\tvar consumableInput1To = document.createElement(\'div\');\r\n\t\t\t\tconsumableInput1To.className = \"form-input additionalInput\";\r\n\t\t\t\tconsumableInput1To.innerHTML = \r\n\t\t\t\t\t\'<input class=\"floating-input\" style=\"width: 230px;\" type=\"text\" placeholder=\"\" id=\"consumableInputToCreatedAmendedby\" name=\"consumableInputToCreatedAmendedby\" >\' +\r\n\t\t\t\t\t\'<label class=\"floating-label\" for=\"consumableInputToCreatedAmendedby\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</label>\' +\r\n\t\t\t\t\t\'<button class=\"search-icon\" type=\"button\" id=\"toConsumableCreatedAmendedby\">\' +\r\n\t\t\t\t\t\'<span class=\"mdi mdi-magnify\"></span>\' +\r\n\t\t\t\t\t\'</button>\';\r\n\r\nconsumableInputcontainerOneTo.appendChild(consumableInput1To);\r\n\r\n// User input tracking\r\nvar isConsumableInputToCreatedAmendedbyChanged = false; // Track if the input value has changed\r\nvar isConsumablePopupToCreatedAmendedbyShown = false;  // Track if the popup is currently shown\r\n\r\nvar consumableInputToCreatedAmendedbyInput = consumableInput1To.querySelector(\'#consumableInputToCreatedAmendedby\');\r\nvar searchIconToConsumableCreatedAmendedby = consumableInput1To.querySelector(\'#toConsumableCreatedAmendedby\');\r\n\r\n// Function to handle blur event\r\nfunction handleConsumableInputToCreatedAmendedbyBlur() {\r\n    var inputValue = consumableInputToCreatedAmendedbyInput.value.trim();\r\n    if (inputValue !== \'\' && !isConsumablePopupToCreatedAmendedbyShown) {\r\n        showPopup(\'toConsumableCreatedAmendedby\', inputValue);\r\n        isConsumablePopupToCreatedAmendedbyShown = true; // Mark popup as shown\r\n    }\r\n    isConsumableInputToCreatedAmendedbyChanged = false; // Reset input changed status on blur\r\n}\r\n\r\n\t\t\t\t// Event listener for \'To\' Consumable Created Amendedby search icon\r\n\t\t\t\tsearchIconToConsumableCreatedAmendedby.addEventListener(\'click\', function() {\r\n\t\t\t\t\tvar inputValue = consumableInputToCreatedAmendedbyInput.value.trim();\r\n\t\t\t\t\tshowPopup(\'toConsumableCreatedAmendedby\', inputValue);\r\n\t\t\t\t});\r\n\r\n// Event listener for input field\r\nconsumableInputToCreatedAmendedbyInput.addEventListener(\'input\', function() {\r\n    isConsumableInputToCreatedAmendedbyChanged = true; // Track input changes\r\n    isConsumablePopupToCreatedAmendedbyShown = false; // Reset popup shown flag when input changes\r\n});\r\n\r\n// Event listener for \'consumableInputToCreatedAmendedby\' input keydown event\r\nconsumableInputToCreatedAmendedbyInput.addEventListener(\'keydown\', function(event) {\r\n    if (event.key === \'Tab\') {\r\n        var inputValue = consumableInputToCreatedAmendedbyInput.value.trim();\r\n        if (inputValue !== \'\' && !isConsumablePopupToCreatedAmendedbyShown) {\r\n            showPopup(\'toConsumableCreatedAmendedby\', inputValue);\r\n            isConsumablePopupToCreatedAmendedbyShown = true; // Mark popup as shown\r\n        }\r\n    }\r\n});\r\n\r\n// Add blur event listener to the input\r\nconsumableInputToCreatedAmendedbyInput.addEventListener(\'blur\', handleConsumableInputToCreatedAmendedbyBlur);\r\n\r\n// Reset isConsumablePopupToCreatedAmendedbyShown when focus is on the input field again\r\nconsumableInputToCreatedAmendedbyInput.addEventListener(\'focus\', function() {\r\n    isConsumablePopupToCreatedAmendedbyShown = false;\r\n});\r\n\r\n\t\t\t\t// Append the container to the fieldset\r\n\t\t\t\t//consumableInputfieldsetTo.appendChild(consumableInputcontainerOneTo);\r\n\r\n                consumableInputfieldsetTo.appendChild(consumableInputcontainerOneTo);\r\n\r\n             \t\r\n             \t// Create container for consumableInput2To\r\n                var consumableInputcontainerTwoTo = document.createElement(\'div\');\r\n                consumableInputcontainerTwoTo.className = \"flexcontainerTwo\";\r\n\r\n                // Create input2From (CreatedAmendedDate)\r\n                var consumableInput2To = document.createElement(\'div\');\r\n                consumableInput2To.className = \"form-input additionalInput\";\r\n                consumableInput2To.innerHTML = \'<input class=\"floating-input datetime-local drug\" style=\"width: 180px;\" type=\"datetime-local\" placeholder=\"\" id=\"consumableInputToCreatedAmendedDate\" name=\"consumableInputToCreatedAmendedDate\" onblur=\"consumableDateValidation(2);consumableDateValidation(4);\">\' +\r\n                                       \'<label class=\"floating-label\" for=\"consumableInputToCreatedAmendedDate\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</label>\';\r\n             \tconsumableInputcontainerTwoTo.appendChild(consumableInput2To);\r\n             \t// Append consumableInputcontainerTwo to fieldsetFrom\r\n                consumableInputfieldsetTo.appendChild(consumableInputcontainerTwoTo);\r\n                \r\n                parentDiv.appendChild(consumableInputfieldsetTo);//adding to parentDiv\r\n            }\r\n        }\r\n\r\n        function setAttributeValueOnClick() {\r\n            var reportType = document.getElementById(\'ReportType\');\r\n            reportType.onclick = function() {\r\n                this.setAttribute(\'value\', this.value);\r\n            };\r\n        }\r\n        \r\n       \r\n    </script>\r\n\r\n</head>\r\n<body>\r\n\r\n\t<div id=\"headerDiv\" class=\"headerContainer\" >\r\n\t\t<div class=\"title\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</div>\r\n\t\t<div class=\"buttoncontainer\">\r\n\t\t\t<input type=\"Button\" class=\"icon-button btn-primary\" value=\"Apply\" onclick=\"run();\">\r\n\t\t\t<input type=\"Button\" class=\"icon-button btn-primary\" value=\"Reset\" onClick = \"reset();\">\r\n\t\t</div>\r\n\t</div>\r\n\t<div id=\"reportTypeContainer\" class=\"containerReport\" >\r\n\t    <div class=\"form-input\">\r\n\t        <select class=\"inputselect\" style=\"margin-right: 15px\"; type=\"text\" placeholder=\"\" name=\"ReportType\" id=\"ReportType\" onclick=\"setAttributeValueOnClick()\" onchange=\"showAdditionalInputs()\" value=\"\">\r\n\t            <option value=\"\"> ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option>\r\n\t            <option value=\"option1\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</option>\r\n\t            <option value=\"option2\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option>\r\n\t            <option value=\"option3\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</option>\r\n\t        </select>\r\n\t        <label class=\"label-select\" for=\"ReportType\">\r\n\t            ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\r\n\t        </label>\r\n\t    </div>\r\n\t</div>\r\n\r\n<input type=\"hidden\" id=\"facilityId\" name=\"facilityId\" value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\r\n<input type=\"hidden\" id=\"params\"\tname=\"params\"\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\r\n<input type=\"hidden\" id=\"locale\" name=\"locale\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\r\n<input type=\"hidden\" id=\"self_submit\" name=\"self_submit\" value=\"yes\">\r\n\r\n<input type=\"hidden\" id=\"p_module_id\" name=\"p_module_id\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"\t>\r\n<input type=\"hidden\" id=\"p_report_id\" name=\"p_report_id\" value=\"\" >\r\n<input type=\"hidden\" id=\"price_ind\" name=\"price_ind\" value=\"!\" >\r\n<input type=\"hidden\" id=\"pgm_id\" name=\"pgm_id\" \tvalue=\"\"\t> \t\t\r\n<input type=\"hidden\" id=\"p_session_id\" name=\"p_session_id\" \tvalue=\"\">\t\r\n<input type=\"hidden\" id=\"p_user_name\" name=\"p_user_name\" \tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\r\n<input type=\"hidden\" id=\"p_pgm_date\" name=\"p_pgm_date\"\t   value=\"\">\r\n\r\n<input type=\"hidden\" id=\"reportserver\"\tname=\"reportserver\"\tvalue=\"\">\r\n<input type=\"hidden\" id=\"report\"\tname=\"report\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"userid\"\tname=\"userid\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"server\"\tname=\"server\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"reportServerEnableFlag\" name=\"reportServerEnableFlag\" value=\"\">\r\n<input type=\"hidden\" id=\"desformat\"\tname=\"desformat\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"destype\"\tname=\"destype\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"desname\"\tname=\"desname\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"copies\"\tname=\"copies\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"queue_name\"\tname=\"queue_name\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"rep_server_key\"\tname=\"rep_server_key\"\t\tvalue=\"\">\r\n<input type=\"hidden\" id=\"report_dir\" name=\"report_dir\" value=\"\">\r\n\r\n\r\n<script>\r\n\r\n</script>\r\n\r\n\r\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\r\n</body>\r\n\r\n</html>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

    /* String sStyle = (session.getAttribute("PREFERRED_STYLE") != null && !((String)session.getAttribute("PREFERRED_STYLE")).isEmpty()) ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyleBL.css";
    String locale = 	(String)session.getAttribute("LOCALE"); */
    String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
    
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

    
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
        
        

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( facilityId ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( facility ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( serviceFacilityJSON ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( drugFacilityJSON ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( consumableFacilityJSON ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( ServicePriceIndicatorJSON ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( ServiceStatusJSON ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( drugStatusJSON ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( consumableStatusJSON ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( ServicegroupByJSON ));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(params));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block73Bytes, _wl_block73);

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

            _bw.write(_wl_block74Bytes, _wl_block74);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PriceIndicator.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Status.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FacilityID.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.GroupBy.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.StandardPrice.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.From.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CustomerCode.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveDate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.To.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CustomerCode.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroup.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveDate.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Status.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FacilityID.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TradeNameorBatch.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.From.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.To.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Status.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FacilityID.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TradeNameorBatch.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.From.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.To.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingServiceItemCode.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedby.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreatedAmendedDate.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceItemPriceList.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Select.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServicePriceList.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DrugsPriceList.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ConsumablesPriceList.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReportType.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }
}
