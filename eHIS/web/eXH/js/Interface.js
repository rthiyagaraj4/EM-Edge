async function invokeEMExternalAppServlet()
{
	//http://localhost:8888/eHIS/eXH/jsp/TestExternalApp.jsp?EM_INT_HEADER=DMS Simulator Page&P_USERNAME=DocuArch Username&P_PAT_ID=Patient ID
	var dataElements = 'P_Ext_Application_ID=DMS_LINK&P_USE_ID=TESTING&P_pwd=URLVIEWER123&P_PATIENT_ID=BN00026854&P_EPISODE_ID=100008860001&P_RESP_ID=CA&P_FACILITY_ID=KB';
	var retData = "";
	var url = "";

	var dialogHeight = "55vh";			    
	var dialogWidth  = "40vw";
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
 
	var retVal = await window.showModalDialog(url,arguments,features);
}

function invokeExternalApp(exePath, exeParams)
{
	exePath = decodeURIComponent(exePath);
	exeParams = decodeURIComponent(exeParams);
	exePath = exePath.replace(/\//g,"\\");
	alert(exePath+ " " + exeParams);
	var oShell = new ActiveXObject("Shell.Application");
	var commandtoRun = "\\\\10.209.59.160\\Poetic\\ClinicalViewer.exe"; 
	oShell.ShellExecute(exePath, exeParams,"","open","1");
	window.close();
}