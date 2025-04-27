<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String params=request.getQueryString();
	
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	String encounter_id = request.getParameter("encounter_id"); 
	String patient_class = request.getParameter("patient_class"); 
	String main_tab = checkForNull(request.getParameter("main_tab")); 
	String chart_num = checkForNull(request.getParameter("chart_num")); 
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")); 
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn")); 
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn")); 
	String eval_active_yn = checkForNull(request.getParameter("eval_active_yn")); 
	String disable_record = checkForNull(request.getParameter("disable_record")); 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")); 
	String chart_date = checkForNull(request.getParameter("chart_date"));
	String chart_close_date = checkForNull(request.getParameter("chart_close_date"));
	String added_date = checkForNull(request.getParameter("added_date"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag")); 
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")); 
	String called_from_chart_tab_flag = checkForNull(request.getParameter("called_from_chart_tab_flag")); 
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String chart_hdr_insert_yn = checkForNull(request.getParameter("chart_hdr_insert_yn"));
	String insert_new_EC_yn = checkForNull(request.getParameter("insert_new_EC_yn"));
	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));

	String cur_chart_num = "1"; 

	chart_flag=chart_flag==null?"P":chart_flag;
	chart_flag=chart_flag.equals("null")?"P":chart_flag;

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

try{
	con = ConnectionManager.getConnection(request);
	if(!perio_chart.equals("")){
		//Get the Active Chart
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ?");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}
	}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script>

function checkForActiveChart(){
	var formObj					 = document.forms[0];
	var patient_id               = formObj.patient_id.value;
	var facility_id              = formObj.facility_id.value;
	var encounter_id             = formObj.encounter_id.value;
	var patient_class            = formObj.patient_class.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var chart_num_param               = formObj.chart_num.value;
	var chart_line_num_param               = formObj.chart_line_num.value;
	var cur_chart_num            = formObj.cur_chart_num.value;
	var oh_chart_level            = formObj.oh_chart_level.value;
	var chart_date            = formObj.chart_date.value;
	var chart_close_date            = formObj.chart_close_date.value;
	var added_date            = formObj.added_date.value;
	var other_chart_facility_id            = formObj.other_chart_facility_id.value;
	var other_facilitychart_yn = formObj.other_facilitychart_yn.value;

	if(cur_chart_num == "" || cur_chart_num == "null" || cur_chart_num == null){
		cur_chart_num = "1"; 
	}
	var show_new_active_yn       = formObj.show_new_active_yn.value; // when we are loading for the first time this value will be null
	var insert_new_EC_yn       = formObj.insert_new_EC_yn.value; // when we are loading for the first time this value will be null

	var main_tab                 = formObj.main_tab.value;
	var called_from_chart_tab_flag = formObj.called_from_chart_tab_flag.value;
	var perio_chart = formObj.perio_chart.value;
	var perio_arch = formObj.perio_arch.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var eval_active_yn = formObj.eval_active_yn.value;
	var disable_record = formObj.disable_record.value;
	
	var chart_num = chart_num_param;
	var chart_line_num = chart_line_num_param;

	if(show_new_active_yn != "Y"){
		show_new_active_yn = 'N';
	}
	if(insert_new_EC_yn != "Y"){
		insert_new_EC_yn = 'N';
	}
	
	if((main_tab == "BaselineChart" && baseline_closed_yn != "Y" && baseline_active_yn != "Y") || (main_tab == "EvaluationChart" && eval_active_yn != "Y" && eval_active_yn != "N")){// This shud not be executed when we load chart from LHS menu
		var closed_chart_yn = 'N';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		
		var params = "patient_id="+patient_id+"&perio_chart="+perio_chart+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForActiveChart&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[0] == "Y"){ //active_chart
					show_new_active_yn = "N";
					
					chart_num=code_desc_arr[2]; // This chart_num of perticular chart as we may have may active charts at a time..
				}
				else{
					show_new_active_yn = "Y";
				}
			}
		}
		else{
			show_new_active_yn = "Y";
		}
	}
	else{
		chart_num = chart_num_param;
	}

	if(main_tab == "EvaluationChart" && eval_active_yn != "Y" && eval_active_yn != "N"){ // This shud not be executed when we load chart from LHS menu

		//To check the for Active Evaluation Chart and set the parameters..
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&perio_chart="+perio_chart+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForECActiveChart&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[0] == "Y"){ //active_chart
					insert_new_EC_yn = 'N';
					chart_line_num = code_desc_arr[2];
				}
				else{
					insert_new_EC_yn = 'Y';
				}
			}
		}
		else{
			insert_new_EC_yn = 'Y';
		}
	}

	formObj.show_new_active_yn.value=show_new_active_yn;
	formObj.insert_new_EC_yn.value=insert_new_EC_yn;

	params = formObj.params.value; 
	params = parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain

	chart_hdr_insert_yn=show_new_active_yn;//initialize

	if(cur_chart_num=="1"){
		chart_hdr_insert_yn="Y";
	}

	formObj.chart_hdr_insert_yn.value=chart_hdr_insert_yn;

	var default_head_tab = "";

	if(called_from_chart_tab_flag==null || called_from_chart_tab_flag==""){
		if(main_tab != "" && main_tab != null){ //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			if(main_tab == "EvaluationChart"){
				called_from_chart_tab_flag="E";
			}
			else if(main_tab == "Compare"){
				called_from_chart_tab_flag="C";
			}
			else{
				called_from_chart_tab_flag="B";
			}
			default_head_tab = main_tab;
		}
		else{
			called_from_chart_tab_flag="B";
			default_head_tab = "BaselineChart";
		}
		
	}

	if(main_tab == "BaselineChart"){
		chart_line_num = "1";
	}

	parent.parent.perioChartHeaderFrame.document.forms[0].chart_line_num.value = chart_line_num;
	parent.parent.perioChartHeaderFrame.document.forms[0].chart_num.value = chart_num;

	var	called_from_BC_EV_yn = formObj.called_from_BC_EV_yn.value;
	if(called_from_chart_tab_flag=="E"){
		params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=E&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&eval_active_yn="+eval_active_yn+"&insert_new_EC_yn="+insert_new_EC_yn+"&chart_line_num="+chart_line_num+"&disable_record="+disable_record+"&called_from_BC_EV_yn="+called_from_BC_EV_yn+"&oh_chart_level="+oh_chart_level+"&chart_date="+chart_date+"&chart_close_date="+chart_close_date+"&added_date="+added_date+"&other_chart_facility_id="+other_chart_facility_id+"&other_facilitychart_yn="+other_facilitychart_yn;
		parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioEvaluationChart.jsp?"+params; //frames[1]
	}
	else if(called_from_chart_tab_flag=="C"){
		params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=C&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&baseline_closed_yn="+baseline_closed_yn+"&baseline_active_yn="+baseline_active_yn+"&disable_record="+disable_record+"&called_from_BC_EV_yn="+called_from_BC_EV_yn+"&oh_chart_level="+oh_chart_level+"&chart_date="+chart_date+"&chart_close_date="+chart_close_date+"&added_date="+added_date+"&other_chart_facility_id="+other_chart_facility_id+"&other_facilitychart_yn="+other_facilitychart_yn;
		parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioCompareChart.jsp?"+params; //frames[1]
	}
	else{
		params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=B&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&baseline_closed_yn="+baseline_closed_yn+"&baseline_active_yn="+baseline_active_yn+"&chart_line_num="+chart_line_num+"&disable_record="+disable_record+"&called_from_BC_EV_yn="+called_from_BC_EV_yn+"&oh_chart_level="+oh_chart_level+"&chart_date="+chart_date+"&chart_close_date="+chart_close_date+"&added_date="+added_date+"&other_chart_facility_id="+other_chart_facility_id+"&other_facilitychart_yn="+other_facilitychart_yn;
	parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioBaselineChart.jsp?"+params; //frames[1]
	}
	
	
}

</script>

<html>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="OHFrameForm" id="OHFrameForm">
	<input type = "hidden" name= "params" value = "<%=params%>">
	<input type = "hidden" name= "cur_chart_num" value = "<%=cur_chart_num%>">
	<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
	<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
	<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
	<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
	<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
	<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
	<input type = "hidden" name= "called_from_chart_tab_flag" value = "<%=called_from_chart_tab_flag%>">
	<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
	<input type = "hidden" name= "insert_new_EC_yn" value = "<%=insert_new_EC_yn%>">
	<input type = "hidden" name= "chart_hdr_insert_yn" value = "<%=chart_hdr_insert_yn%>">
	<input type = "hidden" name= "main_tab" value = "<%=main_tab%>">
	<input type = "hidden" name= "perio_chart" value = "<%=perio_chart%>">
	<input type = "hidden" name= "perio_arch" value = "<%=perio_arch%>">
	<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
	<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
	<input type = "hidden" name= "baseline_active_yn" value = "<%=baseline_active_yn%>">
	<input type = "hidden" name= "baseline_closed_yn" value = "<%=baseline_closed_yn%>">
	<input type = "hidden" name= "eval_active_yn" value = "<%=eval_active_yn%>">
	<input type = "hidden" name= "disable_record" value = "<%=disable_record%>">
	<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
	<input type = "hidden" name= "chart_date" value = "<%=chart_date%>">
	<input type = "hidden" name= "chart_close_date" value = "<%=chart_close_date%>">
	<input type = "hidden" name= "added_date" value = "<%=added_date%>">
	<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
	<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
	<input type = "hidden" name= "called_from_BC_EV_yn" value = "<%=request.getParameter("called_from_BC_EV_yn")%>">
	
</form>
	<script>
		checkForActiveChart();		
	</script>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>












