function Checkcurrdate(from,to,str,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("DECEASE_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Deceased Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}

function reset() {
	
	if(f_query_add_mod.document.RepDeathRegister){
	   f_query_add_mod.document.RepDeathRegister.reset() ;
	}

}

function run() 
{
if(f_query_add_mod.document.RepDeathRegister){
if((doDateCheck(f_query_add_mod.document.RepDeathRegister.p_fm_deceased_date, f_query_add_mod.document.RepDeathRegister.p_to_deceased_date, messageFrame ))){
if((Checkcurrdate( f_query_add_mod.document.RepDeathRegister.p_fm_deceased_date, f_query_add_mod.document.RepDeathRegister.p_curr_date,getLabel("Common.from.label","Common"),messageFrame )) &&
  (Checkcurrdate( f_query_add_mod.document.RepDeathRegister.p_to_deceased_date, f_query_add_mod.document.RepDeathRegister.p_curr_date, getLabel("Common.to.label","Common"),messageFrame ))){
			f_query_add_mod.document.RepDeathRegister.submit() ;	
}
}
}
}//e.o.run

