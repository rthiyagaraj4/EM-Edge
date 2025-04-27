
function onSuccess(){
	var diff_mode =top.frames[0].document.forms[0].diff_mode.value;
	var path = parent.frames[0].document.forms[0].qryStr.value;
	if(diff_mode =='Y')
		window.close();
	else
	{
		top.content.workAreaFrame.RecDiagnosisMain.reload();
	}
}
