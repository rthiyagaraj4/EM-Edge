function searchData(){ 
	var formObj =  document.forms[0];
	var chart_num = formObj.chart_num1.value; 
	var chart_desc = formObj.chart_desc1.value; 
	var sql_string = formObj.sql_string.value; 
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "chart_num="+chart_num+"&chart_desc="+chart_desc+"&sql_string="+sql_string;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioSummaryHeader.jsp?func_mode=populateArea&"+params,false);
	xmlHttp.send(xmlDoc);				
}  

function callPerioChartSummary(){ 
	var formObj			= document.PerioSummaryHeaderForm;
	var patient_id		= formObj.patient_id.value;
	var tooth_numbering_system		= formObj.tooth_numbering_system.value;
	var chart_code_str	= formObj.chart_row.value;
	var chart_code_arr = chart_code_str.split("##");
	var chart_code		= chart_code_arr[0];
	var chart_num		= chart_code_arr[1];
	var chart_line_num	= chart_code_arr[2];
	var params			= "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&chart_code="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	parent.PerioSummaryDetailsFrame.location.href="../../eOH/jsp/PerioSummary.jsp?"+params;
}
