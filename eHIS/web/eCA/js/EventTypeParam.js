/*var chk1;
var chk2;
var chk3;
var chk4;
var chk5;
var chk6;
var chk7;
var chk8;
var chk9;
var chk10;
var chk11;
var chk12;
var chk13;
var chk14;
var chk15;
var chk16;
var chk17;
 */

function apply() {
	/*docFrame = f_query_add_mod.document.event_type_param_frm;
	
	getVals(docFrame);
	getVals_a(docFrame);
   
	if(chk1.checked == false && chk2.checked == false||chk9.checked == false && chk10.checked == false ){
		alert(getMessage("MIN_ONE_EVENT_TYPE","CA"));
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_val=1&err_num= ';
	}else{*/

		f_query_add_mod.document.forms[0].action="../../servlet/eCA.EventTypeParamServlet";
		f_query_add_mod.document.forms[0].submit();
	//}

	
}


/*function manageRoles1(docFrame)
{
		getVals(docFrame);
	
		if(chk1.value == "ADMN" && chk1.checked == false)
		{
			chk3.checked = false;			chk3.disabled = true;			
			chk4.checked = false;			chk4.disabled = true;
			chk6.checked = false;			chk6.disabled = true;
			chk7.checked = false;			chk7.disabled = true;
		}
		else 
		{
			chk3.disabled = false;			
			chk4.disabled = false;
			chk6.disabled = false;
			chk7.disabled = false;
		}  

		if(chk2.value == "VIST" && chk2.checked == false)
		{
			chk5.checked = false; 			chk5.disabled = true;
			chk8.checked = false; 			chk8.disabled = true;
		}
		else
		{
			chk5.disabled = false;
			chk8.disabled = false;
		}  
}*/


/*function manageRoles1_a(docFrame)
{
		getVals_a(docFrame);
	
		if(chk9.value == "ADMN" && chk9.checked == false)
		{
			chk11.checked = false;			chk11.disabled = true;			
			chk12.checked = false;			chk12.disabled = true;
			chk14.checked = false;			chk14.disabled = true;
			chk15.checked = false;			chk15.disabled = true;
		}
		else 
		{
			chk11.disabled = false;			
			chk12.disabled = false;
			chk14.disabled = false;
			chk15.disabled = false;
		}  

		if(chk10.value == "VIST" && chk10.checked == false)
		{
			chk13.checked = false; 			chk13.disabled = true;
			chk16.checked = false; 			chk16.disabled = true;
		}
		else
		{
			chk13.disabled = false;
			chk16.disabled = false;
		}  
}*/

/*
*	Function Name	:	getVals(docFrame)
*	Param			:	docFrame - will have  the form name
*
*	This function is used to get the values of different checkboxes
*/

/*function getVals(docFrame)
{
	var count = docFrame.count.value;
	
	for (cnt=0; cnt<count; cnt++)
	{
		val = eval("docFrame.event_type"+cnt);
		if(val.value == "ADMN")			chk1 = val;
		if(val.value == "VIST" )		chk2 = val;	 
		if(val.value == "DISC")			chk3 = val;
		if(val.value == "ACAN" )		chk4 = val;	 
		if(val.value == "VCAN")			chk5 = val;
		if(val.value == "BIRT")			chk6 = val;
		if(val.value == "DETH")			chk7 = val;
		if(val.value == "VOUT")			chk8 = val;
	}
}*/


/*function getVals_a(docFrame)
{
	var count = docFrame.count.value;
	
	for (cnt=0; cnt<count; cnt++)
	{
		val = eval("docFrame.direct_regn"+cnt);
		if(val.value == "ADMN")			chk9 = val;
		if(val.value == "VIST" )		chk10 = val;	 
		if(val.value == "DISC")			chk11 = val;
		if(val.value == "ACAN" )		chk12 = val;	 
		if(val.value == "VCAN")			chk13 = val;
		if(val.value == "BIRT")			chk14 = val;
		if(val.value == "DETH")			chk15 = val;
		if(val.value == "VOUT")			chk16 = val;
	}
}*/

/*
*	Function Name	:	manageRoles()chk_obj
*	Param			:	chk_obj - checkbox Object which is checked
*
*	This function is used to enable/disable the roles based on the checking of 
*	Inpatient Admission/Outpatient Visit
*/

/*function manageRoles_a(chk_obj)
	{
	docFrame = document.event_type_param_frm;

	getVals_a(docFrame);
	
	if(chk_obj.value == "ADMN")
		{
		if(chk_obj.checked == false)
			{
			chk11.checked = false;				chk11.disabled = true;				
			chk12.checked = false;				chk12.disabled = true;
			chk14.checked = false;				chk14.disabled = true;
			chk15.checked = false;				chk15.disabled = true;
			}else 
				{
			chk11.disabled = false;							
			chk12.disabled = false;
			chk14.disabled = false;
			chk15.disabled = false;
			}  
		}
	if(chk_obj.value == "VIST")
		{
		if(chk_obj.checked == false)
			{						
			chk13.checked = false;							chk13.disabled = true;
			chk16.checked = false;							chk16.disabled = true;
		}
		else
			{
			chk13.disabled = false;
			chk16.disabled = false;
			}  
		}
}*/


/*function manageRoles(chk_obj)
{
docFrame = document.event_type_param_frm;

	getVals(docFrame);
	
	if(chk_obj.value == "ADMN"){
		if(chk_obj.checked == false)
			{
			chk3.checked = false;				chk3.disabled = true;				
			chk4.checked = false;				chk4.disabled = true;
			chk6.checked = false;				chk6.disabled = true;
			chk7.checked = false;				chk7.disabled = true;
		}else {
			chk3.disabled = false;							
			chk4.disabled = false;
			chk6.disabled = false;
			chk7.disabled = false;
				}  
	}
	if(chk_obj.value == "VIST")
		{
		if(chk_obj.checked == false)
			{						
			chk5.checked = false;							chk5.disabled = true;
			chk8.checked = false;							chk8.disabled = true;
		}else{
			chk5.disabled = false;
			chk8.disabled = false;
			}  
		}
}*/


function reset()
{
    f_query_add_mod.document.forms[0].reset();
	//docFrame = f_query_add_mod.document.event_type_param_frm;

	//manageRoles1(docFrame);
	//manageRoles1_a(docFrame);
}

function onSuccess()
{
	f_query_add_mod.location.reload();

}



