function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
                         var fldname=from.name;
					
						if (!isBeforeNow(fromdate,"DMY", localeName))
						{
							if(fldname=="from")
							{
							var msg =getMessage('FROM_DT_NGE_CURR_DATE','SM');
							}
							if(fldname=="to")
							{
							var msg =getMessage('TO_DT_NGE_CURR_DATE','SM');
							}
							parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						/*if(Date.parse(todt) < Date.parse(fromdt))
						{
							//var msg ="APP-FM0041 Date Entered should be lesser than System Date"
							var msg = getMessage('DATE_LESS_EQL_SYS_DATE','FM');
							parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}*/
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}


function CheckSystemDateGreater(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt))
						{
							//var msg ="APP-FM0041 Date Entered should be greater than  or  equal to System Date"
							var msg = getMessage('DATE_GT_EQ_SYS_DATE','FM');
							parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	 return true;
}
