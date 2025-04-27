/*function Checkcurrdate(from,to,str,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Visit Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/

function reset() {
	
	if(f_query_add_mod.document.RepStatistics){
	   f_query_add_mod.document.RepStatistics.reset() ;
	}

}


function run() 
{
		var locale=f_query_add_mod.document.RepStatistics.localeName;

var fields = new Array (f_query_add_mod.document.RepStatistics.p_fm_visit_date,f_query_add_mod.document.RepStatistics.p_to_visit_date);
var names  = new Array ( getLabel("Common.VisitDateFrom.label","Common"),getLabel("Common.VisitDateTo.label","Common"));

if(f_query_add_mod.document.RepStatistics){
   if(f_query_add_mod.checkFields( fields, names, messageFrame)){

			if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepStatistics.p_fm_visit_date.value,"DMY",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepStatistics.p_to_visit_date.value,"DMY",locale)){
					if(f_query_add_mod.isBefore(f_query_add_mod.document.RepStatistics.p_fm_visit_date.value,f_query_add_mod.document.RepStatistics.p_to_visit_date.value,"DMY",locale)){
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
                        f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.RepStatistics.submit() ;
					}else{
						var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
						var visit=f_query_add_mod.getLabel("Common.VisitDate.label","Common");
						var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
						error=error.replace("$",visitto);
						error=error.replace("#",visit);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
						return false;

		}

			 }else{
                 var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

		 }else{
                 var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}


        /*if((Checkcurrdate( f_query_add_mod.document.RepStatistics.visitfromdate, f_query_add_mod.document.RepStatistics.p_curr_date, getLabel("Common.from.label","Common"), messageFrame )) &&
           (Checkcurrdate( f_query_add_mod.document.RepStatistics.visittodate, f_query_add_mod.document.RepStatistics.p_curr_date, getLabel("Common.to.label","Common"), messageFrame ))){
		       if((doDateCheck(f_query_add_mod.document.RepStatistics.visitfromdate, f_query_add_mod.document.RepStatistics.visittodate, messageFrame ))){
			      f_query_add_mod.document.RepStatistics.submit() ;		   
			   }
		}*/
  }
}

/*if(f_query_add_mod.document.RepStatistics){
    if((doDateCheck(f_query_add_mod.document.RepStatistics.p_fm_visit_date, f_query_add_mod.document.RepStatistics.p_to_visit_date, messageFrame ))){
        if((Checkcurrdate( f_query_add_mod.document.RepStatistics.p_fm_visit_date, f_query_add_mod.document.RepStatistics.p_curr_date, "From", messageFrame )) &&
           (Checkcurrdate( f_query_add_mod.document.RepStatistics.p_to_visit_date, f_query_add_mod.document.RepStatistics.p_curr_date, "To", messageFrame ))){

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			f_query_add_mod.document.RepStatistics.submit() ;	
	}
}
}
}*/
}//e.o.run

