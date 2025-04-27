function codeCheck(Obj){
var u=Obj ;
if(u==' '){
parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
}
if(u=='D'){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileNotReturnedToMRDByDate_SRR.jsp";
}
if(u=='F'){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileNotReturnedToMRDByLocationIdentity_SRR.jsp";
}

}
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
						if(Date.parse(todt) > Date.parse(fromdt)) {
					//	if(isBefore(fromdate,todate,"DMY",localeName)) {
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
				//}
						}
			return true;
	 }
	return true;

}



function run()
{
	
		var maintain_doc_or_file = searchResultFrame.document.forms[0].maintain_doc_or_file.value;
		var fields;
		var names;
		if(searchResultFrame.document.reportDate)
		{
			fields = new Array (searchResultFrame.document.reportDate.p_date_criteria);
			//fields = new Array (searchResultFrame.document.reportDate.p_no_of_days);
			
			
			names = new Array (getLabel("Common.date.label","Common")+" "+getLabel("Common.criteria.label","Common"));
			if(maintain_doc_or_file == 'F')
			{
			//	names = new Array (getLabel("eFM.Filespendingformorethan.label","FM"))
				if(searchResultFrame.document.reportDate.p_include_ip.checked == true)
					searchResultFrame.document.reportDate.p_include_ip.value = "Y";
				else
					searchResultFrame.document.reportDate.p_include_ip.value = "N";
			}
			else if(maintain_doc_or_file == 'D')
			{
			//	names = new Array (getLabel("eFM.Documentspendingformorethan.label","FM"))
			}
							
			if(searchResultFrame.document.forms[0].p_to_iss_date){
			if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_iss_date,
								searchResultFrame.document.forms[0].p_fm_iss_date))			
			if(checkFields( fields, names, messageFrame))			
				searchResultFrame.document.reportDate.submit();
			}else{
				if(checkFields( fields, names, messageFrame))			
						searchResultFrame.document.reportDate.submit();
			}
			
		}

		if(searchResultFrame.document.reportFSLocationIdentity)
		{
				//fields = new Array (searchResultFrame.document.reportFSLocationIdentity.p_no_of_days);
				fields = new Array (searchResultFrame.document.reportFSLocationIdentity.p_date_criteria);
				names = new Array (getLabel("Common.date.label","Common")+" "+getLabel("Common.criteria.label","Common"));
				if(maintain_doc_or_file == 'F')
				{
					//names = new Array (getLabel("eFM.Filespendingformorethan.label","FM"))
					if(searchResultFrame.document.reportFSLocationIdentity.p_include_ip.checked == true)
						searchResultFrame.document.reportFSLocationIdentity.p_include_ip.value = "Y";
					else
						searchResultFrame.document.reportFSLocationIdentity.p_include_ip.value = "N";
				}
				else if(maintain_doc_or_file == 'D')
				{
					//names = new Array (getLabel("eFM.Documentspendingformorethan.label","FM"))
				}
				if(searchResultFrame.document.forms[0].p_to_iss_date){
				if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_iss_date,
								searchResultFrame.document.forms[0].p_fm_iss_date))	
				if(checkFields( fields, names, messageFrame))
					 searchResultFrame.document.reportFSLocationIdentity.submit();
				}
				else{
					if(checkFields( fields, names, messageFrame))
					 searchResultFrame.document.reportFSLocationIdentity.submit();
				}

				
				
		}
}

 function reset()
 {
	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href = '../../eCommon/html/blank.html'; 
 }
