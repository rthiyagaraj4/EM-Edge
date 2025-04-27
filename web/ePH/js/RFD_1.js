  
function loadInfo()
{
	var val	=window.dialogArguments[0].value;
	if(val!=undefined || val!="undefined")
	document.RFDSUBINFO.RFDINFO.value=val;

}
function clickOK()
{
	//window.returnValue=document.RFDSUBINFO.RFDINFO.value;
	//window.close();
	parent.document.getElementById('dialog-body').contentWindow.returnValue = document.RFDSUBINFO.RFDINFO.value;
	parent.document.getElementById("dialog_tag").close(); 
}
function clickClose()
{
	//window.returnValue="&";
	//window.close();
	parent.document.getElementById('dialog-body').contentWindow.returnValue = "&";
	parent.document.getElementById("dialog_tag").close(); 
}


