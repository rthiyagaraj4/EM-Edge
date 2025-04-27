function reset()
{
	if(parent.frames[1].name == "f_query_add_mod")
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else
	{
		if(parent.frames[2].frames[2].name == "resultFrame")
		{
			parent.frames[2].frames[1].document.forms[0].reset();
			parent.frames[2].frames[2].document.location.href ='../../eCommon/html/blank.html';
		}
	}
			
	
}
