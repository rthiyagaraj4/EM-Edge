function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {

				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						//if(Date.parse(todt) > Date.parse(fromdt)) 
						if(isBefore(fromdate,todate,"DMY",localeName)) 
						{
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}

 function doDateCheckto(from,today) { //args objects 1st is this object & second is the date object
 if(today.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
					//	if(Date.parse(todt) > Date.parse(fromdt)) 
						if(isBefore(fromdate,todate,"DMY",localeName))
						{
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}
   
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
						//if(Date.parse(todt) < Date.parse(fromdt))
						if(!isBefore(fromdate,todate,"DMY",localeName))
						{
							var msg =getMessage("DATE_LESS_SYS_DATE","FM");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}




 function reset()
 {
//	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href="../../eFM/jsp/FMRequestFileListDetail.jsp"; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
 }

 function run() 
 {
	
			
				//if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
				if(
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
						  searchResultFrame.document.forms[0].today.value)&&
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
							searchResultFrame.document.forms[0].today.value))

				/*var fields = new Array (searchResultFrame.document.forms[0].p_iss_fs_locn);
				var names = new Array ( getLabel('eFM.IssuingFSLocation.label','FM'))*/
				var fields = new Array();
				var names = new Array ();
				fields[fields.length] = searchResultFrame.document.forms[0].p_iss_fs_locn;
				names[names.length] = getLabel('eFM.IssuingFSLocation.label','FM');
				if(checkFields( fields, names, messageFrame))
				{
					searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					searchResultFrame.document.forms[0].target="messageFrame";
					searchResultFrame.document.forms[0].submit();
				}				
			
		 
 }

 function DateCompare(from,to,messageFrame,getVal) 
{
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	///	if(Date.parse(todt) < Date.parse(fromdt)) 
		if(!isBefore(fromdate,todate,"DMY",localeName))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.select();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
	}
	return true;
}

function callreport(obj)
{
	if (obj.value=='1')
	{
		document.forms[0].p_report_id.value='FMBREQLS';
	}else
	{
		document.forms[0].p_report_id.value='FMBREQPT';
	}

}
