/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function run()
{
	var reportIDObj = reportCriteriaFrame.document.getElementById('p_report_id');
	var procDateObj = reportCriteriaFrame.document.getElementById('P_DOC_DATE');
	var locale = reportCriteriaFrame.document.getElementById('locale').value;

	var fields = new Array(reportIDObj,procDateObj) ;
	var names = new Array(getLabel("Common.Function.label","common"), getLabel("eXH.ProcessDate.Label","xh"));  
	if(!reportCriteriaFrame.checkFields( fields, names, messageFrame))
	{
		return false;
	}	
	else
	{		
		if(reportIDObj.value == "ACCPACCSV")
		{
			reportCriteriaFrame.document.accPACCReport.target = "reportCriteriaFrame";
			reportCriteriaFrame.document.accPACCReport.action = "../../servlet/eXB.ACCPACFinanceServlet";
		}
		else
		{
			reportCriteriaFrame.document.accPACCReport.target = "messageFrame";
			reportCriteriaFrame.document.accPACCReport.action = "../../eCommon/jsp/report_options.jsp";
		}		
		reportCriteriaFrame.document.accPACCReport.submit();
	}
}

function changeFunc()
{
	accPACCleanup();
}

function accPACCleanup()
{
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}

function initFunc()
{
	document.getElementById("p_report_id").focus();
	parent.messageFrame.location.href = "../../eXH/jsp/DisplayRefResult.jsp?message="+document.getElementById("resultMessage").value;
}
