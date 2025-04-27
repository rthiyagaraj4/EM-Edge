function codeCheck(Obj){
var u=Obj ;
if(u==' '){
parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
}
if(u=='D'){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileNotReturnedToMRDByDate.jsp";
}
if(u=='F'){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileNotReturnedToMRDByLocationIdentity.jsp";
}

}

function run()
{
		var maintain_doc_or_file = searchResultFrame.document.forms[0].maintain_doc_or_file.value;
		var fields;
		var names;
		if(searchResultFrame.document.reportDate)
		{
			fields = new Array (searchResultFrame.document.reportDate.p_no_of_days);
			if(maintain_doc_or_file == 'F')
			{
				names = new Array (getLabel("eFM.Filespendingformorethan.label","FM"))
				if(searchResultFrame.document.reportDate.p_include_ip.checked == true)
					searchResultFrame.document.reportDate.p_include_ip.value = "Y";
				else
					searchResultFrame.document.reportDate.p_include_ip.value = "N";
			}
			else if(maintain_doc_or_file == 'D')
			{
				names = new Array (getLabel("eFM.Documentspendingformorethan.label","FM"))
			}
			
			if(checkFields( fields, names, messageFrame))
			{
			searchResultFrame.document.reportDate.submit();
			}
		}

		if(searchResultFrame.document.reportFSLocationIdentity)
		{
				fields = new Array (searchResultFrame.document.reportFSLocationIdentity.p_no_of_days);
				if(maintain_doc_or_file == 'F')
				{
					names = new Array (getLabel("eFM.Filespendingformorethan.label","FM"))
					if(searchResultFrame.document.reportFSLocationIdentity.p_include_ip.checked == true)
						searchResultFrame.document.reportFSLocationIdentity.p_include_ip.value = "Y";
					else
						searchResultFrame.document.reportFSLocationIdentity.p_include_ip.value = "N";
				}
				else if(maintain_doc_or_file == 'D')
				{
					names = new Array (getLabel("eFM.Documentspendingformorethan.label","FM"))
				}
				if(checkFields( fields, names, messageFrame))
				{
				 searchResultFrame.document.reportFSLocationIdentity.submit();
				}
				
		}
}

 function reset()
 {
	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href = '../../eCommon/html/blank.html'; 
 }
