  //saved on 27/10/2005
var function_id = "" ;
var result1 = false ;
var message = "" ;
var flag = "" ;
var globalCode="";
var invalidCode	=  "";

/********************************************************************************/
function create() {
      f_query_add_mod.location.href="../../ePH/jsp/RouteCodeAddModify.jsp?mode="+MODE_INSERT; 
}
/********************************************************************************/
function query() {
	f_query_add_mod.location.href="../../ePH/jsp/RouteCodeQueryCriteria.jsp" ;
}

/**************** apply()**********************************************************/

function apply() 
{
    formObj =   f_query_add_mod.document.formRouteCode;

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "route_code";
    arrFieldName[1]         =   "route_desc";
//	arrFieldName[2]         =   "route_local";
   
    arrLegends[0]           =   getLabel("Common.code.label","Common")
    arrLegends[1]           =   getLabel("Common.description.label","Common")
//	arrLegends[2]           =   "Local Language Description";

	if (formObj.exProductLink.value=='Y')
	{
		arrFieldName[2]         =   "ext_route_code";
		arrLegends[2]           =   "External Product Route";

	}
    
    var arrPKFieldNames     =   new Array();
    arrPKFieldNames[0]      =   "route_code";
    

    if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
    }
    var mode = formObj.mode.value;

/*insert begins*/
if( mode == MODE_INSERT )

    {

		resetDuplicateClass(formObj,arrPKFieldNames);
        var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (result){
			
            eval(formApply(formObj,PH_CONTROLLER));
			
            if( result1 ) {

                messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
                onSuccess();
            }
            if( invalidCode != "null" && invalidCode != "" ){
			//	alert(message);
			//	alert(arrPKFieldNames);
			//	alert(invalidCode);
                messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
                showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
                }
        }
        else
        {
            return false;
        }
    }
/*insert end*/
if( mode == MODE_MODIFY ) 
{
	var frmobj = f_query_add_mod.document.formRouteCode;

	if (formObj.exProductLink.value=='Y')
	{
	var fields = new Array (frmobj.route_code,frmobj.route_desc,frmobj.ext_route_code);
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("ePH.ExternalProductRoute.label","PH"));
	}
	else
	{
	var fields = new Array (frmobj.route_code,frmobj.route_desc);
	var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
	}
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

		globalCode= f_query_add_mod.document.formRouteCode.route_code.value;
		eval( formApply( f_query_add_mod.document.formRouteCode,PH_CONTROLLER ) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result1 ) {
			onSuccess();
		}
	}
}
/*modify ends*/	

}
/*******************************************************************************/
function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
	
}

/********************************   reset()   ******************************/
function reset(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("routecodequerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("routecodeaddmodify")!=-1) ) {
		if(f_query_add_mod.document.formRouteCode.mode.value == MODE_INSERT){
			
		    formObj =   f_query_add_mod.document.formRouteCode;

			var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "route_code";
//Added for  RUT-CRF-0034 ICN 29927 -start
			var elements = formObj.getElementsByTagName("input");
    		for(var i =0, l = elements.length; i < l; i++){ 
				var textEl = elements[i];
				if(textEl.name.substr(0,10) == 'routeColor'){
						textEl.style.backgroundColor="#000000";
			        	textEl.value="";
				}
				if(textEl.name.substr(0,6) == 'myDesc'){
						textEl.style.backgroundColor="#FFFFFF";
						textEl.style.color="#000000";
			        	textEl.value="";
				}
			}
//Added for  RUT-CRF-0034 ICN 29927 -End
			resetDuplicateClass(formObj,arrPKFieldNames);

			f_query_add_mod.document.formRouteCode.reset();
			//formReset() ;
		}
		else {
			f_query_add_mod.document.formRouteCode.reset();
		}
	}
}

/**********************************************************************/
function onSuccess() {
	var mode = f_query_add_mod.document.formRouteCode.mode.value;
	if( mode == MODE_INSERT ){
		reset();
		f_query_add_mod.document.formRouteCode.reset();
		f_query_add_mod.document.formRouteCode.route_code0.focus();
	}
	else if(mode == MODE_MODIFY ){
		//	alert("in modify of onsuccess");
		f_query_add_mod.location.href="../../ePH/jsp/RouteCodeAddModify.jsp?mode="+MODE_MODIFY+"&route_code="+globalCode;
		
	}
}
/*******************  formReset()  ***********************************************/
function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}

/********************   modify()   ******************************/

function Modify(obj) {
	var route_code=obj.cells[0].innerText;
	document.location.href="../../ePH/jsp/RouteCodeAddModify.jsp?mode="+MODE_MODIFY+"&route_code="+route_code;

}


/*************************************************************************************/
//In case of pressing Apply button from QueryCriteria page..the 'mode' would come null
//this is to avoid that 

function proceedOnApply() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("routecodequery")==-1) )
		return true;
	else
		return false;
}
/*************************************************************************************/
/*function not to check for special char's onBlur in AddModify*/
function RouteCodeCheck(obj){
	if(!CheckChars(obj)){
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
/************************************************************************/
function resetColorCode(obj){
    var arrPKFieldNames =   new Array();
    var formObj         =   parent.f_query_add_mod.document.formRouteCode;
    /**
      * specify the primary key columns
      */
    arrPKFieldNames[0]  =   "route_code";

    /**
      * if more than one columns exists in
      * the primary key, then the next columns
      * can be given like this
      */
    //arrPKFieldNames[0]    =   "long_desc";
//    arrPKFieldNames[1]    =   "route_desc";
//	arrPKFieldNames[2]    =   "route_local";

    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
//Code Added for  RUT-CRF-0034 ICN 29927
function copyDescToColor(){

	    var formObj =  parent.f_query_add_mod.document.formRouteCode;
        var arr = new Array();
		arr = formObj.getElementsByTagName("input");
		var color = "";
		 for(var i = 0; i < arr.length; i++)
        {
			  var textE2 = arr[i];
			  if(textE2.name.substr(0,10) == 'route_desc')
				{
				 color=textE2.value;
				}
	          if(textE2.name.substr(0,11) == 'routeColor')
				{
				textE2.value =color;
				}
        }
}
 function copyBackgroundAndFontColor(){
	var formObj =  parent.f_query_add_mod.document.formRouteCode;
    var	percent=80;
	var bckColor="";
	var combinedcolor="";
	var mode = formObj.mode.value;
	if(mode == MODE_INSERT)
	 {
	  for(var i = 0; i < 10; i++)
		 {
			  try {
        // Construct keys for accessing form elements
        const routeColorElem = parent.f_query_add_mod.document.getElementById('routeColor'+i);
        const myDescElem = parent.f_query_add_mod.document.getElementById('myDesc'+i);
        
        // Check if elements are valid and exist
        if (routeColorElem && myDescElem) {
            let formColor = routeColorElem.value.trim();

            // Expand shorthand hex color to full format
            if (/^#[0-9A-Fa-f]{3}$/.test(formColor)) {
                formColor = formColor.split('').map((char, i) => i === 0 ? char : char + char).join('');
            }
            
            // Ensure formColor starts with # and is in full hex format
            if (!/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                formColor = `#${formColor.replace(/^#/, '')}`;
            }

            // Validate the color format
            if (/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                // Apply background color to the element
                myDescElem.style.backgroundColor = formColor;

                // Determine a contrasting color for text to ensure readability
                const textColor = getContrastingColor(formColor);
                myDescElem.style.color = textColor;

                // Combine colors and store in form element
                const combinedColor = `${formColor} ${textColor}`;
                formObj['route_color'+i].value = combinedColor;
            } 
        } 
        
    } catch (error) {
        // Handle any unexpected errors
        alert("An error occurred while modifying colors: " + error.message);
    }
		 }
	 }
/*else if (mode === MODE_MODIFY) {
    try {
        // Construct keys for accessing form elements
        const routeColorElem = parent.f_query_add_mod.document.getElementById('routeColor');
        const myDescElem = parent.f_query_add_mod.document.getElementById('myDesc');
        
        // Check if elements are valid and exist
        if (routeColorElem && myDescElem) {
            let formColor = routeColorElem.value.trim();

            // Expand shorthand hex color to full format
            if (/^#[0-9A-Fa-f]{3}$/.test(formColor)) {
                formColor = formColor.split('').map((char, i) => i === 0 ? char : char + char).join('');
            }
            
            // Ensure formColor starts with # and is in full hex format
            if (!/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                formColor = `#${formColor}`;
            }

            // Validate the color format
            if (/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                // Apply text color to the element
                myDescElem.style.color = formColor;

                // Adjust brightness and apply background color
                const bckColor = increase_brightness(formColor, percent);
                myDescElem.style.backgroundColor = bckColor;

                // Combine colors and store in form element
                // Ensure combinedColor is meaningful
                const combinedColor = `${formColor} ${bckColor}`;
                formObj['route_color'].value = combinedColor;
            } else {
                // Handle invalid color format
                alert("Invalid color format. Please enter a valid hex color code.");
            }
        } else {
            // Handle case where elements are not found
            alert("Required form elements not found.");
        }
    } catch (error) {
        // Handle any unexpected errors
        alert("An error occurred while modifying colors: " + error.message);
    }
}
*/
else if (mode === MODE_MODIFY) {
    try {
        // Construct keys for accessing form elements
        const routeColorElem = parent.f_query_add_mod.document.getElementById('routeColor');
        const myDescElem = parent.f_query_add_mod.document.getElementById('myDesc');
        
        // Check if elements are valid and exist
        if (routeColorElem && myDescElem) {
            let formColor = routeColorElem.value.trim();

            // Expand shorthand hex color to full format
            if (/^#[0-9A-Fa-f]{3}$/.test(formColor)) {
                formColor = formColor.split('').map((char, i) => i === 0 ? char : char + char).join('');
            }
            
            // Ensure formColor starts with # and is in full hex format
            if (!/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                formColor = `#${formColor.replace(/^#/, '')}`;
            }

            // Validate the color format
            if (/^#[0-9A-Fa-f]{6}$/.test(formColor)) {
                // Apply background color to the element
                myDescElem.style.backgroundColor = formColor;

                // Determine a contrasting color for text to ensure readability
                const textColor = getContrastingColor(formColor);
                myDescElem.style.color = textColor;

                // Combine colors and store in form element
                const combinedColor = `${formColor} ${textColor}`;
                formObj['route_color'].value = combinedColor;
            } 
        } 
    } catch (error) {
        // Handle any unexpected errors
    }
}

// Function to get a contrasting color for better readability
function getContrastingColor(hex) {
    // Convert hex to RGB
    let r = parseInt(hex.substring(1, 3), 16);
    let g = parseInt(hex.substring(3, 5), 16);
    let b = parseInt(hex.substring(5, 7), 16);

    // Calculate luminance
    let luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;

    // Return black or white based on luminance
    return luminance > 127.5 ? '#000000' : '#FFFFFF';
}




}
function increase_brightness(color, percent)
{
    var r = parseInt(color.substr(1, 2), 16), g = parseInt(color.substr(3, 2), 16), b = parseInt(color.substr(5, 2), 16); 
    return  ((0|(1<<8) + r + (256 - r) * percent / 100).toString(16)).substr(1) + ((0|(1<<8) + g + (256 - g) * percent / 100).toString(16)).substr(1) +        ((0|(1<<8) + b + (256 - b) * percent / 100).toString(16)).substr(1); 
}



//Code Ended for  RUT-CRF-0034 ICN 29927
