function query()
{
	f_tmt_pat_search.location.href="../../eAE/jsp/AEPatientTMTLoadSearch.jsp"
}

function reset ()
{
	f_tmt_pat_search.frames[0].document.forms[0].reset();
	f_tmt_pat_search.frames[1].document.location.href ='../../eCommon/html/blank.html';
	f_tmt_pat_search.frames[2].document.location.href ='../../eCommon/html/blank.html';
}

