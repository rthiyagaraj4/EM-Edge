/*Created by Thamizh selvi on 10th July 2017 against ML-MMOH-CRF-719*/
function getResult(){
	var cutOffDate = document.forms[0].p_cut_of_date.value;
	parent.frames[2].location.href= '../../eMR/jsp/MRBatchProcessResult.jsp?&cutOffDate='+cutOffDate+'';	
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

function apply(){
	frames[1].document.MRBatchProcessForm.method="POST";
	frames[1].document.MRBatchProcessForm.action="../../servlet/eMR.PrepareReportServlet";
	frames[1].document.MRBatchProcessForm.submit();
}

function reset(){
	parent.frames[2].location.reload();
}

function generateReport(){
	document.forms[0].method="GET";
	document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	document.forms[0].submit();
}

function disableButtons(){
	var incompReqCount = document.forms[0].incompReqCount.value;
	if(incompReqCount == "0"){
		document.forms[0].GenerateReport.disabled			= true;
		document.forms[0].DispIncompReq.disabled			= true;
		parent.frames[0].document.forms[0].apply.disabled	= true;
	}
	else{
		document.forms[0].GenerateReport.disabled			= false;
		document.forms[0].DispIncompReq.disabled			= false;
		parent.frames[0].document.forms[0].apply.disabled	= false;
	}
}

function onLocalSuccess(){
	parent.frames[2].location.href="../eMR/jsp/MRBatchProcess.jsp?home_required_yn=Y&menu_id=MR&module_id=MR&function_id=MR_BATCH_PROCESS&function_name="+getLabel('eMR.MRBatchProcess.label','MR')+"&function_type=F&access=NYNNN";
}
