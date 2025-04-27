/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
09/08/2017		IN058006	Prakash C		09/08/2017		Ramesh G		ML-MMOH-CRF-0461
------------------------------------------------------------------------------------------------------------------------------
*/
function resetValues()
{
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}
function changeValue(obj)
{
if(obj.checked)
	
	obj.value="E";
else
	obj.value="D";
}

function apply()
{
	SplChartGroupsMain.document.spl_chart_groups.action='../../servlet/eCA.SplChartGroupsServlet';
	SplChartGroupsMain.document.spl_chart_groups.target='messageFrame';
	SplChartGroupsMain.document.spl_chart_groups.method='post';
	SplChartGroupsMain.document.spl_chart_groups.submit();
}

function reset()
{
location.reload();	
}