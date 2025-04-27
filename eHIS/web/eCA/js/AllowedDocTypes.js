function scrollTitle()
{
	  var scrollXY = document.body.scrollTop;
	  if(scrollXY == 0)
	  {
					document.getElementById("divDataTitle").style.position = 'static';
					document.getElementById("divDataTitle").style.posTop  = 0;
	  }
	  else
	  {
				document.getElementById("divDataTitle").style.position = 'relative';
				document.getElementById("divDataTitle").style.posTop  = scrollXY;
	 }
}

function apply()
{
	f_query_add_mod.document.allowed_doc_form.submit();

}
function reset() {
		if(f_query_add_mod.document.allowed_doc_form.name == "allowed_doc_form") 
			f_query_add_mod.document.allowed_doc_form.reset() ;
}
function onSuccess()
{
	f_query_add_mod.location.reload();
}
