
function run(){	

if( f_query_add_mod.document.repImmunizationStatus.p_outcome_type[1].checked == true)
{
	var fields = new Array( f_query_add_mod.document.repImmunizationStatus.p_frmDate,
                            f_query_add_mod.document.repImmunizationStatus.p_toDate,
		                     f_query_add_mod.document.repImmunizationStatus.p_age_range_code)

    var names = new Array( getLabel('Common.periodfrom.label','common'),      getLabel('Common.to.label','common'),getLabel('Common.AgeRange.label','common'))
}
else if ( f_query_add_mod.document.repImmunizationStatus.p_outcome_type[0].checked == true)
{
	var fields = new Array(f_query_add_mod.document.repImmunizationStatus.p_age_range_code)

    var names = new Array(getLabel('Common.AgeRange.label','common'))

}

										
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if(f_query_add_mod.document.forms[0])
			alert(f_query_add_mod.getMessage('GEN_REP','CA'));	

	 if ( f_query_add_mod.document.repImmunizationStatus.p_outcome_type[1].checked == true)
	
	 {
	if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repImmunizationStatus.p_frmDate, f_query_add_mod.document.repImmunizationStatus.p_toDate, messageFrame,'DMY' ))	
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repImmunizationStatus.submit() ;
		}
} else if( f_query_add_mod.document.repImmunizationStatus.p_outcome_type[0].checked == true)
	 {
	   f_query_add_mod.document.repImmunizationStatus.submit() ;
	
}
	}
}

function reset(){
	//f_query_add_mod.document.repImmunizationStatus.reset();
	//SelectRadio;
	if(f_query_add_mod.document.repImmunizationStatus)
		{
			f_query_add_mod.document.repImmunizationStatus.reset();
			f_query_add_mod.document.repImmunizationStatus.p_outcome_type[0].checked=true; 
			f_query_add_mod.document.getElementById("referralrow").style.display	= 'none';
			f_query_add_mod.document.getElementById("notreferral").style.display='inline';
		}
}


function checkingDate(obj,format,locale)
{
	var from =document.repImmunizationStatus.p_frmDate;	
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.select();
			obj.focus();
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.periodto.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}
	}
	}
}


function Change_mode(obj)
{
	
	var formobj=document.repImmunizationStatus
		
	if (obj.value=='')
	{
		obj.value=="M"
	}
	if(obj.value=="M")
	{
		//alert("M");
		document.getElementById("referralrow").style.display	= 'none';
		document.getElementById("notreferral").style="display";
		document.repImmunizationStatus.p_outcome_type.value="M"
	}
	else if(obj.value=="R")
	{
		//alert("R");
		
		document.getElementById("referralrow").style="display";
		document.getElementById("notreferral").style.display='none';
		document.repImmunizationStatus.p_outcome_type.value="R"
	}
}

/*function Change_mode(obj)
	{
	if(obj.value == "M")
		parent.f_query_add_mod.document.repImmunizationStatus.p_indicator_level.value='M';
	else if(obj.value == "R")
		parent.f_query_add_mod.document.repImmunizationStatus.p_indicator_level.value='R';

	parent.f_query_add_mod.location.href='../../eCA/jsp/RepImmunizationStatusMain.jsp?mode=Update&p_outcome_type='+document.repImmunizationStatus.p_indicator_level.value;

	}*/

function SelectRadio()
{
	document.repImmunizationStatus.p_outcome_type[0].checked=true;
	document.getElementById("referralrow").style.display	= 'none';
	document.getElementById("notreferral").style="display";
	
}
function Check_Date(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.periodfrom.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			obj.select();
			obj.focus();
			return false;
		}
	}	
	}
}



function DateChk(Object2,focusflag) 
{
	var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}
    if (chDate(Object2) == false) {
        alert(getMessage("INVALID_DATE_FMT", "SM"));
        if (datefield.value != undefined && focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
		var current=document.repImmunizationStatus.currentMonthYear.value;
		var arr=current.split("/");
		var textVal=document.repImmunizationStatus.p_toMonth.value;		
		var arr1=textVal.split("/");
		var txtyear=parseInt(arr1[1],10);
		var txtmonth=parseInt(arr1[0],10);
		var curyear=parseInt(arr[1],10);
		var curmonth=parseInt(arr[0],10);		
		if(textVal==null || textVal==undefined ||textVal==""){}		
		else
		{
			if(txtyear < curyear)
			{
				return true;
			}
			else if(txtyear==curyear)
			{					
				if(txtmonth<=curmonth){return true}
				else{ 				
					alert(getMessage("MON_YEAR_GREATER_CURR_MON_YEAR","CA"));
					datefield.select();
					datefield.focus();
					return false;				
				}
			}
			else
			{
				alert(getMessage("MON_YEAR_GREATER_CURR_MON_YEAR","CA"));
				datefield.select();
				datefield.focus();
				return false;
			}
		}
				
    }
}


function chDate(Object3) {
	if (Object3.value != undefined)
    {
		Object3 = Object3.value;
    }
	else
	{
		Object3 = Object3;
	}
    var strDate;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

    strDate = datefield;
    if (strDate.length == 0) return true;

if(Object3.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 2) {
        return false;
    }
    else {
        strMonth = trimString(strDateArray[0]);
        strYear = trimString(strDateArray[1]);
    }
    if (strYear.length < 4 || strYear.length > 4) return false;  
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;
    return true;
}
