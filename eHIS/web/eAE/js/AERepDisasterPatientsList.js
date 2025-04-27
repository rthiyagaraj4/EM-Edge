function Checkcurrdate(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("DATE_GT_CURR",'AE');
				error=error.replace("$",getLabel("Common.Registration.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - Registration Date should be not greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true; 
}
function reset() {
	
	if(f_query_add_mod.document.repDisasterPatList){
	   f_query_add_mod.document.repDisasterPatList.reset() ;
	   f_query_add_mod.document.forms[0].elements(0).focus();
 
	}
} 



function run() 
{
	//var fields = new Array ( parent.parent.frames[1].frames[1].document.repDisasterPatList.p_registration_date);
	var fields = new Array ( parent.parent.frames[2].frames[1].document.repDisasterPatList.p_registration_date);
    var names  = new Array ( getLabel("Common.RegistrationDate.label","Common"));
	var error_page = "../../eCommon/jsp/error.jsp";	
    if(f_query_add_mod.document.repDisasterPatList)
    {
	if (f_query_add_mod.checkFields(fields,names,messageFrame)) { 
		
			if(isBeforeNow(f_query_add_mod.document.repDisasterPatList.p_registration_date.value,"DMY",f_query_add_mod.document.repDisasterPatList.locale.value ))
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
			    f_query_add_mod.document.repDisasterPatList.submit() ;	
			 }
				
				
		else
		{	
				 var error=f_query_add_mod.getMessage("DATE_GT_CURR",'AE');
				error=error.replace("$",getLabel('Common.Registration.label','Common'));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;	
				return false;
		}
				
		}	
    }
}
 
 
