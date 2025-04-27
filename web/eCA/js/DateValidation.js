 src='../../eCommon/js/messages.js';
function DateValidation(from,to,foc,message)
{
	var fromarray;
	var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var name = from.name;
	var get_message = message

	if(fromdate.length > 0 && todate.length > 0 )
	{
	fromarray = fromdate.split("/");
	toarray = todate.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(toarray[2],toarray[1],toarray[0]);

	if(Date.parse(todt) < Date.parse(fromdt))
	{
			foc.focus();
			alert(getMessage(get_message));
			return false;
	}
	else if(Date.parse(todt) >= Date.parse(fromdt))
		//parent.parent.parent.parent.frames[2].window.location.href='/eCIS/ca/jsp/error1.jsp?err_num=';
		null;
	return true;
	}
return true;
}
