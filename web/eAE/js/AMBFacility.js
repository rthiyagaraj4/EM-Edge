/* Created by Vinod Babu M V - 4/13/2009    */

function create(){}

function query(){}

function apply()
{
    var fields;
    var names;

    if (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value == 'F' 
        || f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value == 'Y' 
		|| f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value == 'N')
    {
        fields = new Array
            (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind,
            f_query_add_mod.document.AMBFacility_form.amb_mileage_uom,
            f_query_add_mod.document.AMBFacility_form.start_case_no,
            f_query_add_mod.document.AMBFacility_form.next_case_no
         //   f_query_add_mod.document.AMBFacility_form.end_case_no
		);

		//names = new Array("Incident Numbering By", "Odometer Units", "Start Number", "Next Number", "End Number" );
		names=new Array(getLabel("eAE.IncidentNumberingBy.label","AE"),getLabel("eAE.OdometerUnits.label","AE"),getLabel("eOP.StartNumber.label","OP"),getLabel("eAM.NextNumber.label","AM"));
    }
    else if (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value == 'A')
    {
        fields = new Array
            (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind,
            f_query_add_mod.document.AMBFacility_form.amb_mileage_uom);

		//names = new Array("Incident Numbering By", "Odometer Units");
		names= new Array(getLabel("eAE.IncidentNumberingBy.label","AE"),getLabel("eAE.OdometerUnits.label","AE"));
    }
    else if (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value == 'U')
    {
        fields = new Array
            (f_query_add_mod.document.AMBFacility_form.amb_prefix_ind,
            f_query_add_mod.document.AMBFacility_form.amb_mileage_uom,
            f_query_add_mod.document.AMBFacility_form.amb_user_prefix,
            f_query_add_mod.document.AMBFacility_form.start_case_no,
            f_query_add_mod.document.AMBFacility_form.next_case_no
         //   f_query_add_mod.document.AMBFacility_form.end_case_no
			);
       //names = new Array("Incident Numbering By", "Odometer Units", "Prefix", "Start Number", "Next Number", "End Number");
		names=new Array(getLabel("eAE.IncidentNumberingBy.label","AE"),getLabel("eAE.OdometerUnits.label","AE"),getLabel("eMP.prefix.label","MP"),getLabel("eOP.StartNumber.label","OP"),getLabel("eAM.NextNumber.label","AM"));
		
    }




    if (f_query_add_mod.checkFields(fields, names, messageFrame))
	{
    	f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.disabled=false;
    	f_query_add_mod.document.AMBFacility_form.amb_user_prefix.disabled=false;
    	f_query_add_mod.document.AMBFacility_form.start_case_no.disabled=false;
    	f_query_add_mod.document.AMBFacility_form.next_case_no.disabled=false;
	//f_query_add_mod.document.AMBFacility_form.end_case_no.disabled=false;
    	
    	
		if(f_query_add_mod.document.AMBFacility_form.amb_prefix_ind.value!='A')
		{
			if(isValidRangeNumbers(f_query_add_mod.document.AMBFacility_form.start_case_no,messageFrame))
				f_query_add_mod.document.AMBFacility_form.submit();
		}else{
			f_query_add_mod.document.AMBFacility_form.submit();
		}
	}
}

function onSuccess()
{
    f_query_add_mod.location.reload();
}

function reset()
{
	/*var uomvalue	=	f_query_add_mod.document.forms[0].uom_backup.value;

	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].amb_mileage_uom.value = uomvalue;*/
		f_query_add_mod.location.reload();
}

function CheckSpecChars(event)
{
    var strCheck =
        '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); // Get key value from key code
    if (strCheck.indexOf(key) ==  - 1)
        return false;
    // Not a valid key
    if ((event.keyCode >= 97) && (event.keyCode <= 122))
        return (event.keyCode);
    return true;
}

function checkEqual()
{
	var stno = document.forms[0].start_case_no.value;
	var edno = document.forms[0].end_case_no.value;

	if(stno == edno)
	{
		alert(getMessage("START_NOT_EQUAL_END","AE"));
		document.forms[0].end_case_no.focus();
		return false;
	}
}
function CheckNumbers(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); // Get key value from key code
    if (strCheck.indexOf(key) ==  - 1)
        return false;



    // Not a valid key

    return true;
}

function onChangePrefixInd(prefixInd)
{
    /*
    Prefix Identifier	  
    (Valid are values F- Facility, U- Userdefined ,A- Ambulance Id, Y - By Year - N- None ) 

    By Default - F- Facility) 
    If A- Ambulance is selected then do not display Start No and End No.
    If User Defined is selected then display User defined prefix column 
     */
    if (document.forms[0].amb_user_prefix)
        document.forms[0].amb_user_prefix.value = "";
    document.forms[0].start_case_no.value = "";
    document.forms[0].next_case_no.value = "";
  //  document.forms[0].end_case_no.value = "";

    switch (prefixInd.value)
    {

        case 'F':
            document.getElementById("case_no_tab").style.visibility = 'visible';
            document.getElementById("prefix_row").style.visibility = 'hidden';
            document.getElementById("prefix_row").style.display = 'none';
            document.forms[0].prefixStr.value = document.forms[0].facility_id.value;
            break;
        case 'A':
            document.getElementById("case_no_tab").style.visibility = 'hidden';
			document.getElementById("prefix_row").style.visibility = 'hidden';
			document.getElementById("prefix_row").style.display = 'none';
            document.forms[0].prefixStr.value = 'AMB';
            break;
        case 'U':
			document.getElementById("prefix_row").style.visibility = 'visible';
          	document.getElementById("prefix_row").style.display = 'inline';
            document.getElementById("case_no_tab").style.visibility = 'visible';
            break;
        case 'Y':
			document.getElementById("prefix_row").style.visibility = 'hidden';
            document.getElementById("prefix_row").style.display = 'none';
            document.getElementById("case_no_tab").style.visibility = 'visible';
            var myDate = (new Date()).getFullYear() + ' ';
            document.forms[0].prefixStr.value = myDate.substring(2, 4);
            break;
        case 'N':
            document.forms[0].prefixStr.value = "";
			document.getElementById("prefix_row").style.visibility = 'hidden';
            document.getElementById("prefix_row").style.display = 'none';
			document.getElementById("case_no_tab").style.visibility = 'visible';
            break;
        default:
			document.getElementById("prefix_row").style.visibility = 'hidden';
            document.getElementById("prefix_row").style.display = 'none';
            document.getElementById("case_no_tab").style.visibility = 'visible';
           break;
    }
}



function onStartCaseNum(prefixInd)
{
    if (prefixInd == 'A')
    {
      //  document.forms[0].next_case_no.value = document.forms[0].prefixStr.value + Number(document.forms[0].start_case_no.value);
        document.forms[0].next_case_no.value =  Number(document.forms[0].start_case_no.value);
    }
    else if (prefixInd == 'F')
    {
     //   document.forms[0].next_case_no.value = document.forms[0].prefixStr.value + Number(document.forms[0].start_case_no.value);
        document.forms[0].next_case_no.value =  Number(document.forms[0].start_case_no.value);
    }
    else if (prefixInd == 'U')
    {
      //  document.forms[0].next_case_no.value = document.forms[0].amb_user_prefix.value + Number(document.forms[0].start_case_no.value);
        document.forms[0].next_case_no.value =  Number(document.forms[0].start_case_no.value);
    }
    else
    {
      //  document.forms[0].next_case_no.value = document.forms[0].prefixStr.value + Number(document.forms[0].start_case_no.value);
        document.forms[0].next_case_no.value =  Number(document.forms[0].start_case_no.value);
    }
}

function checkNum(obj)
{
	var flag = true;

	if ( ( obj.value !=''  && (Number(obj.value)==0) ) || obj.value == '' )
	{
		flag = false;
		obj.value='';
		
		if(obj.name == "start_case_no")
			document.forms[0].next_case_no.value='';
			
            alert(getMessage("AE_NUMBER_ZERO","AE"));
		

//		obj.focus();
	}

	if ( (document.forms[0].start_case_no.value!='' && document.forms[0].end_case_no.value!='') && (Number(document.forms[0].start_case_no.value) > Number(document.forms[0].end_case_no.value) ))
	{
		flag = false;
		obj.value='';

		if(obj.name == 'start_case_no' )
		{   
		   alert(getMessage("AE_AMB_START_NUM_LS_END_NUM","AE"));
			document.forms[0].next_case_no.value='';
		}
		else
		    alert(getMessage("AE_AMB_END_NUM_GT_START_NUM","AE"));
			

//		obj.focus();
	}

	if ((obj.name=='start_case_no') &&(obj.value!='') && (flag))
	{
		onStartCaseNum(document.forms[0].amb_prefix_ind.value);
	}

	return flag;
}

function switchVal(obj)
{
	if (obj.checked==true)
		obj.value='Y';
	else
		obj.value = 'N';

}

function isValidRangeNumbers(start,messageFrame)
{
	var errors = "";


	if ( ( start.value !=''  && (Number(start.value)==0) ) || start.value == '' )
	{
	//	if(start.name == "start_case_no")
		//	f_query_add_mod.document.AMBFacility_form.next_case_no.value='';
		 errors =getMessage("AE_AMB_START_NUM_GT_ZERO","AE");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false;
	}
/*
	if ( ( end.value !=''  && (Number(end.value)==0) ) || end.value == '' )
	{
	
		errors = "APP-AE0101 End Number should be greater than zero.";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false;
	}


	if ( (start.value!='' && end.value!='') && (Number(start.value) > Number(end.value) ))
	{
		errors = "APP-AE0100 End number must be greater than Start number.";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false;
	}
	
	if ( (start.value!='' && end.value!='') && (Number(start.value) == Number(end.value) ))
	{
		
		errors = f_query_add_mod.getMessage("START_NOT_EQUAL_END","AE");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false;
	}
*/
	return true;
}

function fillNextNo(obj)
{
	if ((obj.name=='start_case_no') &&(obj.value!='') )
	{
		onStartCaseNum(document.forms[0].amb_prefix_ind.value);
	}
}

