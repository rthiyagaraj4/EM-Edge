
function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
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
						if (isBefore(fromdate,todate,"DMY",localeName))
						if(Date.parse(fromdate)<Date.parse(todate) )
						{
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							today.focus();
							today.select();
					    	return false;
						}
						/*if(Date.parse(todt) > Date.parse(fromdt)) {
							
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							today.focus();
							today.select();
							return false;
						}*/
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?' ;
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
						if(Date.parse(todt) > Date.parse(fromdt)) {
							
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							parent.frames[3].location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }

	 return true;
}

		
function search()
{
	var doc_or_file = document.forms[0].doc_or_file.value;
	var from		= document.forms[0].from.value ;
	var to			= document.forms[0].to.value ;

	if(from != "")
	{
		from=convertDate(from,"DMY",localeName,"en");
	}

	if(to != "")
	{
		to=convertDate(to,"DMY",localeName,"en");
	}
	var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	var criteria    ="L";
	if(document.forms[0].criteria[0].checked)
	criteria =  document.forms[0].criteria[0].value ;

	if(document.forms[0].criteria[1].checked)
	criteria =  document.forms[0].criteria[1].value ;


	if( doDateCheckFrom(document.forms[0].to,document.forms[0].from) && CheckSystemDateLesser(document.forms[0].from,document.forms[0].today.value)
		&& CheckSystemDateLesser(document.forms[0].to,document.forms[0].today.value))
	 {
		parent.frames[1].document.forms[0].Search.disabled=true;
	
	if(doc_or_file == 'D')
		 {
		parent.frames[2].document.location.href='../../eFM/jsp/QueryDTLostSearchResult.jsp?from=' + from + '&to=' + to +'&criteria=' + criteria + '&flag=next&nextRecord=0&previousRecord=0';       
		 }
	else
		 {
		parent.frames[2].document.location.href='../../eFM/jsp/QueryFMLostSearchResult.jsp?from=' + from + '&to=' + to +'&criteria=' + criteria + '&file_type_appl_yn=' + file_type_appl_yn +'&flag=next&nextRecord=0&previousRecord=0';                               
		 }
	 }
	
}

function clearResultFrame()
  {	 
		  parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html" ;
  }

function getNext(flagSelect)
	{
	   var from				= document.forms[0].from.value ;
	   var to				= document.forms[0].to.value ;
	/*	if(from != "")
		{
			from=convertDate(from,"DMY",localeName,"en");
		}

		if(to != "")
		{
			to=convertDate(to,"DMY",localeName,"en");
		} */

	   var criteria			= document.forms[0].criteria.value ;
	   var flag				= flagSelect ;
	   var previousRecord	= document.forms[0].previousRecord.value ;
	   var nextRecord		= document.forms[0].nextRecord.value ;
	   var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	   document.location.href='../../eFM/jsp/QueryFMLostSearchResult.jsp?from=' + from + '&to=' + to +'&criteria=' + criteria + '&file_type_appl_yn=' + file_type_appl_yn +'&flag=' + flag + '&nextRecord=' +  nextRecord         + '&previousRecord=' + previousRecord ;   
	}

function getNextDT(flagSelect)
	{
	   var from				= document.forms[0].from.value ;
	   var to				= document.forms[0].to.value ;
	   var criteria			= document.forms[0].criteria.value ;
	   var flag				= flagSelect ;
	   var previousRecord	= document.forms[0].previousRecord.value ;
	   var nextRecord		= document.forms[0].nextRecord.value ;
	   document.location.href='../../eFM/jsp/QueryDTLostSearchResult.jsp?from=' + from + '&to=' + to +'&criteria=' + criteria + '&flag=' + flag + '&nextRecord=' +  nextRecord         + '&previousRecord=' + previousRecord ;   
	}

 function reset()
 {
    searchFrame.document.forms[0].Search.disabled=false;
	searchFrame.document.forms[0].reset();
	searchResultFrame.document.location.href = 	'../../eCommon/html/blank.html';
	searchFrame.document.forms[0].from.focus();

 }
	
