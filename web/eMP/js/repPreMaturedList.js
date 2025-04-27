function reset()
{
	f_query_add_mod.document.PrematuredList.reset() ;
} 	

function chkFromToDate(Obj)
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
}


function run()
{ 
	var fields = new Array( f_query_add_mod.document.PrematuredList.p_date_from, f_query_add_mod.document.PrematuredList.p_date_to,f_query_add_mod.document.PrematuredList.p_wk_gest_period);
    var names = new Array(getLabel('eMP.ChildBirthDateFrom.label','MP'), getLabel('eMP.ChildBirthDateTo.label','MP'),getLabel('eMP.PrematureCutOffPeriod.label','MP'));
	
		
		
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.PrematuredList.p_date_from, f_query_add_mod.document.PrematuredList.p_date_to, messageFrame ,'DMY') ) 
			{
				if(f_query_add_mod.checkFields(fields ,names , messageFrame))
				{
		        f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		    f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.PrematuredList.submit() ;
				}
			}else
				f_query_add_mod.document.PrematuredList.p_date_to.focus();
		
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
