function reset()
{
frames[1].frames[2].document.location.reload();
}
function onSuccess()
{
parent.frames[1].document.location.reload();
parent.frames[2].document.location.reload();
}
// added from RecordPatOtherMedEvents.jsp
function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/mrblank.jsp?step_1=9";
}
