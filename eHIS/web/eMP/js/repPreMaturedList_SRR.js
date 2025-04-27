function reset()
{
	f_query_add_mod.document.PrematuredList.reset() ;
} 	

/*function chkFromToDate(Obj)
{
	var currdate = document.getElementById("currdate").value;
	
	currdate = convertDate(currdate,"DMY","en",localeName);		

	if(Obj.value != '')
    {
		if(!validDateObj(Obj,"DMY",localeName))
		{			
			Obj.select();
			return false;
		}
		else 
		if(!isBefore(Obj.value,currdate,"DMY",localeName))
		{
			var err1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");			
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		}
		else
		{
		if((PrematuredList.p_date_from.value!="")&&(PrematuredList.p_date_to.value!=""))
			{
			var from  = PrematuredList.p_date_from;
			var to	  = PrematuredList.p_date_to;
				if(!isBefore(from.value,to.value,"DMY",localeName))
				{
					var err1 = getMessage("TO_DT_GR_EQ_FM_DT","SM");					
					alert(err1);
					Obj.value = "";	
					Obj.focus();
					return false;
				}
			}

		}
    }
}*/


function run()
{ 
	var fields = new Array( f_query_add_mod.document.PrematuredList.p_date_from, f_query_add_mod.document.PrematuredList.p_date_to,f_query_add_mod.document.PrematuredList.p_wk_gest_period);
    var names = new Array(getLabel('eMP.ChildBirthDateFrom.label','MP'), getLabel('eMP.ChildBirthDateTo.label','MP'),getLabel('eMP.PrematureCutOffPeriod.label','MP'));
				
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			if(doDateChkWithLabel( f_query_add_mod.document.PrematuredList.p_date_from, f_query_add_mod.document.PrematuredList.p_date_to, messageFrame ,'DMY',getLabel('eMP.child.label','MP')+" "+getLabel('Common.birthDate.label','Common') ) ) 
			{				
				//var newborn_wt=f_query_add_mod.document.PrematuredList.p_newbornwt.value;
				var newborn_wt=f_query_add_mod.document.PrematuredList.p_newborn_weight.value;
				var min_weight=f_query_add_mod.document.PrematuredList.min_weight.value;
				var max_weight=f_query_add_mod.document.PrematuredList.max_weight.value;
					if(parseFloat(newborn_wt) < min_weight || parseFloat(newborn_wt) > max_weight){						
						var error=getMessage("CANNOT_EXCEED_NB_WEIGHT","MP") ;							
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
					}
					else
						f_query_add_mod.document.PrematuredList.submit() ;			
			}		
       }
	}
function validateDate(obj){
	
	if (obj.value>6)
	{
		alert(getMessage("GESTATION_DAYS_EXCEED","MP"));
		obj.value = "";
		document.PrematuredList.p_wk_gest_period.focus();
		
		/*
		var days=obj.value;
		var week=document.PrematuredList.p_wk_gest_period.value;
		var weekdays=7;
        var week1=parseInt(days/weekdays);
		if(week=='')
		week=0;
        week2=parseInt(week)+week1;
		document.PrematuredList.p_wk_gest_period.value=week2;
        var remindays=parseInt(days%weekdays);
		obj.value=remindays;
		*/		
	}
}

function enableGestDays(Obj) {
	
		var unit_of_gest_nb=document.PrematuredList.unit_of_gest_nb.value;
		if(Obj.value != "") {
		if(document.PrematuredList.p_gest_period)
			document.PrematuredList.p_gest_period.disabled = false;
	      if(unit_of_gest_nb=="W")
			{ 
		    document.PrematuredList.p_gest_period.focus();
			}
	} else {
		if(document.PrematuredList.p_gest_period) {
			document.PrematuredList.p_gest_period.value = "";
			document.PrematuredList.p_gest_period.disabled = true;
		}
	}
}

function setDate(Object){ 

    if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
}

function doDateChkWithLabel(from,to,messageFrame,format,stringLabel) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}
	 if(!f_query_add_mod.isBefore(from,to,format,f_query_add_mod.document.forms[0].locale.value)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;		
		error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +stringLabel);
		error=error.replace("#",stringLabel);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}

function CheckPositiveNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }
        
    }
}
