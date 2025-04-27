<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	String params=request.getQueryString();
	

	String facility_id = (String)session.getValue("facility_id");
	//String patient_id = "SD00000085";//request.getParameter("patient_id");
	String patient_id = request.getParameter("patient_id");
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	String chart_flag = request.getParameter("chart_flag"); // to be passed from the calling place, from CA
	String encounter_id = request.getParameter("encounter_id"); 
	String patient_class = request.getParameter("patient_class"); 
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag")); 
	String main_tab = checkForNull(request.getParameter("main_tab")); 
	String add_new_yn = checkForNull(request.getParameter("add_new_yn")); 
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")); 
//	String cur_chart_num = checkForNull(request.getParameter("cur_chart_num")); 
//	String new_chart_num = checkForNull(request.getParameter("new_chart_num")); 
	String new_chart_num = "1"; 
	String cur_chart_num = ""; 

	String mixed_dentition_YN = checkForNull(request.getParameter("MD_yn")); 
	String permanent_deciduous_flag = checkForNull(request.getParameter("PD_flag")); 
	String deciduous_grace_period_valid = checkForNull(request.getParameter("deciduous_grace_period_valid")); 
	String called_from_cond_trt_tab_flag = checkForNull(request.getParameter("called_from_cond_trt_tab_flag")); 
	String show_new_active_yn = checkForNull(request.getParameter("show_new_active_yn"));
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String other_facilitychart_yn  = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;			
	String add_new_done_flag = checkForNull(request.getParameter( "add_new_done_flag" )) ;			
	String old_facility_id = checkForNull(request.getParameter( "old_facility_id" )) ;			
	String change_tab_validity_yn = checkForNull(request.getParameter( "change_tab_validity_yn" )) ;			
	//String other_facility_yn = checkForNull(request.getParameter( "other_facility_yn" )) ;			
	// When clicked from the Add/New link in BaseLine Chart on RHS Menu of Dental Condition Tab
	String new_baseline_yn = checkForNull(request.getParameter("new_baseline_yn"));

	new_baseline_yn=new_baseline_yn==null?"N":new_baseline_yn;
	new_baseline_yn=new_baseline_yn.equals("null")?"N":new_baseline_yn;
	new_baseline_yn=new_baseline_yn.equals("")?"N":new_baseline_yn;

		//String chart_name = "";
	chart_flag=chart_flag==null?"R":chart_flag;
	chart_flag=chart_flag.equals("null")?"R":chart_flag;
	
	if(add_new_yn.equals("Y") || add_new_done_flag.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "";
	}
 	String default_head_tab_add_new =checkForNull(request.getParameter("default_head_tab_add_new"));
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}
			
	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
    String loaded_from_main_tab = checkForNull(request.getParameter( "loaded_from_main_tab" )) ;
    String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;
	//
	
	//Added by Sharon Crasta on 1/7/2010 for IN017822
	//If passed from treatment tab, Add New , The value will be "Y".
	String loaded_from_trmt_tab = checkForNull(request.getParameter( "loaded_from_trmt_tab" )) ;
	String date_diff_chart_num = checkForNull(request.getParameter( "date_diff_chart_num" )) ;//Added by Sridevi Joshi on 6/15/2010 for IN022000
	

/*
	if(chart_flag.equals("R")){ // Restorative Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RestorativeChart.Label","oh_labels"); 
	}else if(chart_flag.equals("P")){ // Periodontal Chart
		chart_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChart.Label","oh_labels"); 
	}
*/
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

try{
	con = ConnectionManager.getConnection(request);
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}
	if(oh_chart_level.equals("E")){

		//Get the Active Chart
	//	pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM,CHART_NUM CUR_CHART_NUM, CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,SYSDATE FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}

	}
	else{
		//Get the Active Chart
		//pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM,CHART_NUM CUR_CHART_NUM, CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,SYSDATE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID,CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		if(add_new_yn.equals("Y")){
			pstmt.setString(1,facility_id);
		
		}else{
				pstmt.setString(1,other_chart_facility_id);
		}
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
			other_chart_facility_id = rs.getString("OPERATING_FACILITY_ID");
		}
	}
		
		
		pstmt = con.prepareStatement("SELECT CHART_NUM+1 NEW_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ?  ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			new_chart_num = rs.getString("NEW_CHART_NUM");
		}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script>

var deciduous_grace_period_valid = '<%=deciduous_grace_period_valid%>';
function checkForActiveChart(){

	var date_diff_flag           = document.forms[0].date_diff_flag.value
	var formObj					 = document.OHFrameForm;
	var patient_id               = formObj.patient_id.value;
	var facility_id              = formObj.facility_id.value;
	var encounter_id             = formObj.encounter_id.value;
	var patient_class            = formObj.patient_class.value;
	var mixed_dentition_YN       = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var cur_chart_num            = formObj.cur_chart_num.value;
	var new_chart_num            = formObj.new_chart_num.value;
	var show_new_active_yn       = formObj.show_new_active_yn.value;
	var main_tab                 = formObj.main_tab.value;
	var called_from_cond_trt_tab_flag = formObj.called_from_cond_trt_tab_flag.value;
	var add_new_yn                 = formObj.add_new_yn.value;
	var old_facility_id                 = formObj.old_facility_id.value;
	if(show_new_active_yn != "Y"){
		show_new_active_yn = 'N';
	}
	var episode_id				= formObj.episode_id.value;
	var episode_type            = formObj.episode_type.value;
	var visit_id				= formObj.visit_id.value;
	var location_code				= formObj.location_code.value;
	var location_type				= formObj.location_type.value;
	var new_baseline_yn				= formObj.new_baseline_yn.value;
	formObj.new_baseline_yn.value="N"; //Initialize to NO after calling
	var chart_num = new_chart_num;

	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var add_new_done_flag = formObj.add_new_done_flag.value;
	var default_head_tab_add_new = formObj.default_head_tab_add_new.value;
	var change_tab_validity_yn = formObj.change_tab_validity_yn.value;
	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	var dflt_mixed_dentition_chart = formObj.dflt_mixed_dentition_chart.value;
	var chart_type = formObj.chart_type.value;
	//
	//Added by Sharon Crasta on 1/7/2010 for IN017822
	//If passed from treatment tab, Add New , The value will be "Y".
	var loaded_from_trmt_tab = formObj.loaded_from_trmt_tab.value;
	var date_diff_chart_num = formObj.date_diff_chart_num.value;//Added by Sridevi Joshi on 6/15/2010 for IN022000

	var dentist_comments = "";

	if(cur_chart_num != ""){ //Added by Sridevi Joshi on 4/23/2010 for PE
		//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
		var loaded_from_main_tab = formObj.loaded_from_main_tab.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getDentistComments&"+params,false);
		xmlHttp.send(xmlDoc);
		var dentist_comments = trimString(xmlHttp.responseText);
	}

	 //added by parul on 15/06/2010 for IN022086
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+cur_chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=CheckChartStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_status = trimString(xmlHttp.responseText);
	
	//Added by Sharon Crasta on 1/6/2010 for IN017822
	//Not to load anything if the Chart Type flags are not in the forward sequence
	var flag_disable = false;
	//End
	/*if(add_new_done_flag=="Y"){
		add_new_yn = "Y";
	} */
		//if(add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined"){
		if(show_new_active_yn=="Y"){
			chart_num=new_chart_num;
		}else if(called_from_cond_trt_tab_flag == 'P'){ // Bcoz we shud not get alert msg in case of periodontal summary tab (added on 14/12/07)
			chart_num=cur_chart_num;
			show_new_active_yn = "N";
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForActiveChart&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(code_desc_arr[2] == "Y"){ //active_chart
						//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
						//Added so that the permanent_deciduous_flag can be set on refresh if the chart is "RM".

						if(code_desc_arr[3]=="RM"){
							if(code_desc_arr[4] == "D"){
							 permanent_deciduous_flag = "D";
							}
							else{
							 permanent_deciduous_flag = "P";
							}
						} 
						if(chart_type == "RA"){
							 permanent_deciduous_flag = "P";				
						}
						//
						//Addded by Sharon Crasta on 1/6/2010 for IN017822
						//If the active chart is Mixed and the chart_type is Deciduous then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. 
						if(code_desc_arr[3] == "RM" && (chart_type == "RD" && deciduous_grace_period_valid == "N")) {
						   //	var allow_flag = confirm("The Active chart should be closed. Do you want to create a new chart?");
						   	var allow_flag = confirm(getMessage("APP-OH000153","OH"));
							if(allow_flag){
								chart_num=new_chart_num;
								show_new_active_yn = "N";
								params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&chart_type="+chart_type;
								
								xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
								xmlHttp.send(xmlDoc);
								retVal = trimString(xmlHttp.responseText);
								permanent_deciduous_flag = "D"; // Deciduous
								/*if(dflt_mixed_dentition_chart=="D"){
									permanent_deciduous_flag = "D"; // Deciduous
								}
								else{
									permanent_deciduous_flag = "P"; // Permament
								}*/
								//
							
							}
							else{
								//parent.frames[0].location.href="../../eCommon/html/blank.html";
								//parent.parent.condTabDentalChartFrame.location.href="../../eCommon/html/blank.html";
								flag_disable = true;
								chart_type = code_desc_arr[3];
								if(dflt_mixed_dentition_chart=="D"){
									permanent_deciduous_flag = "D"; // Deciduous
								}
								else{
									permanent_deciduous_flag = "P"; // Permament
								}
								chart_num = cur_chart_num;
								mixed_dentition_YN = "Y";
								//top.history.back();
							}
						}
						//If the active chart is Permanent and the chart_type is Deciduous then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. 
						else if(code_desc_arr[3] == "RA" && (chart_type == "RD" && deciduous_grace_period_valid == "N")){
						   //	var allow_flag = confirm("The Active chart should be closed. Do you want to create a new chart?");
						   	var allow_flag = confirm(getMessage("APP-OH000153","OH"));
							if(allow_flag){
								chart_num=new_chart_num;
								show_new_active_yn = "N";
								params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&chart_type="+chart_type;
								
								xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
								xmlHttp.send(xmlDoc);
								retVal = trimString(xmlHttp.responseText);
								permanent_deciduous_flag = "D"; // Deciduous
								/*if(dflt_mixed_dentition_chart=="D"){
									permanent_deciduous_flag = "D"; // Deciduous
								}
								else{
									permanent_deciduous_flag = "P"; // Permament
								} */
								//
							
							}
							else{
								//parent.frames[0].location.href="../../eCommon/html/blank.html";
								//parent.parent.condTabDentalChartFrame.location.href="../../eCommon/html/blank.html";
								flag_disable = true;
								chart_type = code_desc_arr[3];
								permanent_deciduous_flag = "P"; // Permament
								chart_num = cur_chart_num;
								mixed_dentition_YN = "N";
								//top.history.back();
							}
						}
						//If the active chart is Permanent and the chart_type is Mixed then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. 
						else if(code_desc_arr[3] == "RA" && (chart_type == "RD" && deciduous_grace_period_valid == "Y")){
						   //	var allow_flag = confirm("The Active chart should be closed. Do you want to create a new chart?");
						   	var allow_flag = confirm(getMessage("APP-OH000153","OH"));
							if(allow_flag){
								chart_num=new_chart_num;
								show_new_active_yn = "N";
								params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&chart_type=RM";
								
								xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
								xmlHttp.send(xmlDoc);
								retVal = trimString(xmlHttp.responseText);
								if(dflt_mixed_dentition_chart=="D"){
									permanent_deciduous_flag = "D"; // Deciduous
								}
								else{
									permanent_deciduous_flag = "P"; // Permament
								}
								//
							
							}
							else{
								//parent.frames[0].location.href="../../eCommon/html/blank.html";
								//parent.parent.condTabDentalChartFrame.location.href="../../eCommon/html/blank.html";
								flag_disable = true;
								chart_type = code_desc_arr[3];
								permanent_deciduous_flag = "P"; // Permament
								chart_num = cur_chart_num;
								mixed_dentition_YN = "N";
								//top.history.back();
							}
						}
						//If the active chart is Permanent and the chart_type is Mixed then, a confirm message will be given, If click on OK, then a new chart should be created taking the flag as chart_type. 
						else if(code_desc_arr[3] == "RA" && chart_type == "RM"){
						   //	var allow_flag = confirm("The Active chart should be closed. Do you want to create a new chart?");
						   	var allow_flag = confirm(getMessage("APP-OH000153","OH"));
							if(allow_flag){
								chart_num=new_chart_num;
								show_new_active_yn = "N";
								params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&chart_type="+chart_type;
								
								xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
								xmlHttp.send(xmlDoc);
								retVal = trimString(xmlHttp.responseText);
								if(dflt_mixed_dentition_chart=="D"){
									permanent_deciduous_flag = "D"; // Deciduous
								}
								else{
									permanent_deciduous_flag = "P"; // Permament
								}
								//
							
							}
							else{
								//parent.frames[0].location.href="../../eCommon/html/blank.html";
								//parent.parent.condTabDentalChartFrame.location.href="../../eCommon/html/blank.html";
								flag_disable = true;
								chart_type = code_desc_arr[3];
								permanent_deciduous_flag = "P"; // Permament
								chart_num = cur_chart_num;
								mixed_dentition_YN = "N";
								//top.history.back();
							}
						}//End
						else if(mixed_dentition_YN == "Y" && code_desc_arr[3] == "RD"){
							if(deciduous_grace_period_valid == 'Y'){
								//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
								//if(other_chart_facility_id == facility_id){

								//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)	//if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined"))) {
								if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined")) && (loaded_from_main_tab == "Y" || loaded_from_main_tab == "" || loaded_from_main_tab == "null" || loaded_from_main_tab == null || loaded_from_main_tab == "undefined")) {
								 if (retVal_status>0){	//added by parul on 15/06/2010 for IN022086
									var msg=getMessage("APP-OH000186","OH");
									chart_num=cur_chart_num;
									chart_type="RD"
									mixed_dentition_YN="N"		
									permanent_deciduous_flag = "D";
								 }else{
										var new_old = confirm(getMessage("APP-OH0007",'OH'));
										if(new_old){
											chart_num=new_chart_num;
											//show_new_active_yn = "Y";
											show_new_active_yn = "N";
											//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
											//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
											//params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&chart_type=RM";
											params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&chart_type=RM";
											
											xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal = trimString(xmlHttp.responseText);
											if(dflt_mixed_dentition_chart=="D"){
												permanent_deciduous_flag = "D"; // Deciduous
											}
											else{
												permanent_deciduous_flag = "P"; // Permament
											}
											//
									  	}else{
											show_new_active_yn = "N";
											chart_num=cur_chart_num;
											mixed_dentition_YN = "N";
											permanent_deciduous_flag = "D";
										}
								 }
								}
									else{
										show_new_active_yn = "N";
										chart_num=cur_chart_num;
										mixed_dentition_YN = "N";
										permanent_deciduous_flag = "D";
									}
								/*}else{

									show_new_active_yn = "N";
									chart_num=cur_chart_num;
									mixed_dentition_YN = "N";
									permanent_deciduous_flsg = "D";
								} */
							}
							else{
								//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
								//if(other_chart_facility_id == facility_id){
								
								//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
								//if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined"))) {
								if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined")) && (loaded_from_main_tab == "Y" || loaded_from_main_tab == "" || loaded_from_main_tab == "null" || loaded_from_main_tab == null || loaded_from_main_tab == "undefined")) {
								  if (retVal_status>0){	//added by parul on 15/06/2010 for IN022086
									var msg=getMessage("APP-OH000186","OH");
									alert(msg)
									chart_type="RD"
									mixed_dentition_YN="N"		
									permanent_deciduous_flag = "D";
									chart_num=cur_chart_num;
									}else{
										alert(getMessage("APP-OH0008",'OH'));
										//show_new_active_yn = "Y";
										show_new_active_yn = "N";
										//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
										params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&chart_type=RM";

										xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
										xmlHttp.send(xmlDoc);
										retVal = trimString(xmlHttp.responseText);

										if(dflt_mixed_dentition_chart=="D"){
											permanent_deciduous_flag = "D"; // Deciduous
										}
										else{
											permanent_deciduous_flag = "P"; // Permament
										} 
										
									}//
								}
							}
						}
						else if(permanent_deciduous_flag == "P" && (code_desc_arr[3] == "RD" || code_desc_arr[3] == "RM") && (mixed_dentition_YN == "N")){
							//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
							//if(other_chart_facility_id == facility_id){
							
							//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
							//if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined"))) {
							if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined")) && (loaded_from_main_tab == "Y" || loaded_from_main_tab == "" || loaded_from_main_tab == "null" || loaded_from_main_tab == null || loaded_from_main_tab == "undefined")) {
								 if (retVal_status>0){	//added by parul on 15/06/2010 for IN022086
									alert(getMessage("APP-OH000186",'OH'));
									chart_num=cur_chart_num;
									//chart_type="RM"
									mixed_dentition_YN="Y"
									if(code_desc_arr[4]=="D"){
									   permanent_deciduous_flag="D";
									}else{
									    permanent_deciduous_flag="P";
									}

								 }else{
										alert(getMessage("APP-OH0009",'OH'));
										/*commented on 03/09/07 and added the below uncommented line
										params = "patient_id="+patient_id;
										xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=paintNewChart&"+params,false);
										xmlHttp.send(xmlDoc);
										*/
										//show_new_active_yn = "Y";
										show_new_active_yn = "N";
										//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
										params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&chart_type=RA";

										xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
										xmlHttp.send(xmlDoc);
										retVal = trimString(xmlHttp.responseText);
									}
							}
						} 
						else if((permanent_deciduous_flag == "D" && code_desc_arr[3] == "RD") || (permanent_deciduous_flag == "P" && code_desc_arr[3] == "RA") || mixed_dentition_YN == "Y"){
							code_desc_arr[0] = parseInt(code_desc_arr[0]);
							code_desc_arr[1] = parseInt(code_desc_arr[1]);
							if(code_desc_arr[0] < code_desc_arr[1]){ //chart_days < rest_chrt_val_days
								show_new_active_yn = "N";
								chart_num=cur_chart_num; // added this line after uncommenting the chart_days in CommomValidation
							}
							else if(code_desc_arr[0] >= code_desc_arr[1] && code_desc_arr[1] > 0){  //chart_days >= rest_chrt_val_days //condition for code_desc_arr[1] > 0 is added by Sridevi Joshi on 6/2/2010 for IN021769
							//else if(code_desc_arr[0] >= code_desc_arr[1]){  //chart_days >= rest_chrt_val_days //condition for code_desc_arr[1] > 0 is added by Sridevi Joshi on 6/2/2010 for IN021769
								if((other_chart_facility_id == facility_id) && ((add_new_yn == "N" || add_new_yn == "" || add_new_yn == "null" || add_new_yn == null || add_new_yn == "undefined") || (add_new_done_flag == "N" || add_new_done_flag == "" || add_new_done_flag == "null" || add_new_done_flag == null || add_new_done_flag == "undefined") || (change_tab_validity_yn == "Y")) && (loaded_from_main_tab == "Y" || loaded_from_main_tab == "" || loaded_from_main_tab == "null" || loaded_from_main_tab == null || loaded_from_main_tab == "undefined")) {
									
                                 if (retVal_status>0){	//added by parul on 15/06/2010 for IN022086
										var msg=getMessage("APP-OH000187","OH");
										alert(msg);												
										chart_num=cur_chart_num;
									}else{//end added by parul on 15/06/2010 for IN022086

										var new_old = confirm(getMessage("APP-OH00010",'OH'));
										if(new_old){
											chart_num=new_chart_num;
											/*
											params = "patient_id="+patient_id;
											xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=paintNewChart&"+params,false);
											xmlHttp.send(xmlDoc);
											*/
											var copy_yn = confirm(getMessage("APP-OH00022","OH")) 
											if(copy_yn){
											//Added by Sharon Crasta on 4/1/2009 for CRF #0423
												copy_yn = "Y";
												show_new_active_yn = "N";
											}
											else{
												copy_yn = "N";
												//show_new_active_yn = "Y";
												show_new_active_yn = "N";
												add_new_yn = "Y"; // This is to clear the clinical group code for new chart...
											}
											//
											//Commented by sharon Crasta on 4/1/2009 for CRF #0423
											//params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type;
											//Commented and Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
											//params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&copy_yn="+copy_yn;
											params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&old_facility_id="+facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments+"&copy_yn="+copy_yn;
											xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=copyPrevTrmtCond&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal = trimString(xmlHttp.responseText);

												//show_new_active_yn = "N";
											//}
											/*else{
												show_new_active_yn = "Y";
												add_new_yn = "Y"; // This is to clear the clinical group code for new chart...
											} */
										}
										else{
											show_new_active_yn = "N";
											chart_num=cur_chart_num;
										}
									}

								}else{
											show_new_active_yn = "N";
										   chart_num=cur_chart_num;
											//chart_num=new_chart_num;
									//}
								}
							}
							else{ //Added by Sridevi Joshi on 6/7/2010 for IN021769
								show_new_active_yn = "N";
								chart_num=cur_chart_num;
							}
						}
					//}
				}else{								
						//chart_num=cur_chart_num;
						show_new_active_yn = "N";
					}
				}
			}
		}
	//}
		if(date_diff_flag == "disable"){//Addded by Sridevi Joshi on 6/15/2010 for IN022000
			chart_num = date_diff_chart_num;
		}
		formObj.show_new_active_yn.value=show_new_active_yn;
		/* modified by bshankar for Add/New logic from BaseLine chart
		// Modified to parent.parent.condTabDentalChartFrame.location.search
		params = formObj.params.value; 
		*/

		//params = parent.parent.condTabDentalChartFrame.location.search;
		// above line is modified by bshankar on 14th Jan 2008. The frame parent.parent.parent.condTabDentalChartFrame will be used for Periodontal Chart Summary Tab. Initially this is being called from single Tab and now it has been called from Secondary Tab Under the Summary Tab.
		// Changed from here
		if(parent.parent.parent.condTabDentalChartFrame!=null){
			// Used for Summary Tab
			params = parent.parent.parent.condTabDentalChartFrame.location.search;
		}else{
			// Used for Condition Tab and Treatments Tab
			params = parent.parent.condTabDentalChartFrame.location.search;

		}
		// Changed till here
		chart_hdr_insert_yn=show_new_active_yn;//initialize
		if(cur_chart_num=="0" || cur_chart_num==null ||cur_chart_num=="")
			chart_hdr_insert_yn="Y";
		//parent.conditionDentalChart.location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp?"+params;
		var default_head_tab = "";
		
		if(called_from_cond_trt_tab_flag==null || called_from_cond_trt_tab_flag==""){
			if(main_tab != "" && main_tab != null){ //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
				if(main_tab == "Treatment"){
					called_from_cond_trt_tab_flag="T";
				}
				//Commented and Added by Sharon Crasta on 1/7/2010 for IN017822
				//Added to display the treatment related frames when Add new done from Trmt Tab. After some continuous iterations of Add New, the condition frames were getting loaded.
				//else if(main_tab == "Condition"){
				else if(main_tab == "Condition" && loaded_from_trmt_tab != "Y"){
					called_from_cond_trt_tab_flag="C";
				}
				else if(loaded_from_trmt_tab == "Y"){
					called_from_cond_trt_tab_flag="T";
					main_tab = "Treatment";
				}//End
				else{
					called_from_cond_trt_tab_flag="P";
				}
				default_head_tab = main_tab;
			}
			else{// Added by Sharon Crasta on 1/7/2010 for IN017822
				//Added to display the treatment related frames when Add new done from Trmt Tab. After some continuous iterations of Add New, the condition frames were getting loaded.
				if(loaded_from_trmt_tab == "Y"){
					called_from_cond_trt_tab_flag="T";
					default_head_tab = "Treatment";
				}else{//End
					called_from_cond_trt_tab_flag="C";
					default_head_tab = "Condition";
				}
			}
	
		
		//parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab;
		// above line is modified by bshankar on 14th Jan 2008. The frame parent.parent.parent.mainTabHeaderFrame will be used for Periodontal Chart Summary Tab. Initially this is being called from single Tab and now it has been called from Secondary Tab Under the Summary Tab.
		// Changed from here

		if(parent.parent.parent.mainTabHeaderFrame!=null){	
			// Used for summary Tab
			if(flag_disable){
				parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&chart_disable_from_main=Y";
			}else{
				parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab;
			}
		}
		//Added by Sharon Crasta on 1/6/2010 for IN017822
		//This flag is not to load the Tabs when the Chart Type flags are not in the forward sequence. For e.g., if the active chart is RM and the DOB is changed to a deciduous chart, then the tabs should not be loaded.
		/*else if(flag_disable){
			//parent.parent.mainTabHeaderFrame.location.href="../../eCommon/html/blank.html";
			top.history.back();
		}*///End
		else{			
			// Used for Condition Tab and Treatments Tab
			//parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab;
			//parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab_add_new="+default_head_tab_add_new+"&add_new_yn="+add_new_yn;
			if(flag_disable){
				parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&add_new_yn="+add_new_yn+"&chart_disable_from_main=Y";
			}else{
				parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&add_new_yn="+add_new_yn;
				}
			}
			
		}
		/*
		if((called_from_cond_trt_tab_flag!=null || called_from_cond_trt_tab_flag!="") && (add_new_done_flag == "Y" || add_new_yn == "Y")){
			if(called_from_cond_trt_tab_flag == "C"){
				default_head_tab="Condition";
			}else if(called_from_cond_trt_tab_flag == "T"){
				default_head_tab="Treatment";
			}
			parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab;
		
		} */

		//alert("called_from_cond_trt_tab_flag:=="+called_from_cond_trt_tab_flag);
		if(called_from_cond_trt_tab_flag=="C"){
			//params1=parent.parent.mainTabHeaderFrame.location.search;
			//params1=parent.parent.conditionDentalChartView.frames[0].frames[2].location.search;
				//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)
				//Commented and added by Sharon Crasta on 1/6/2010 for IN017822
				//A new parameter params_cond is written so that the newly craeted params are placed 1st in the query string 
				//params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=C&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn;
				var params_cond ="&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=C&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn;

			
				params =  params_cond + params;
				if(flag_disable){
					params = params + "&chart_disable_from_main=Y";
					parent.parent.frames[0].document.getElementById("numbering_system").disabled = true;
					parent.parent.frames[0].document.getElementById("asOnDate").disabled = true;
					parent.parent.frames[0].document.getElementById("asOnDateCal").disabled = true;
					parent.parent.frames[0].document.getElementById("refresh_icon").disabled = true;
				}
				//End
			   	//params="&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=C&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn+"&"+params;
				parent.conditionDentalChart.location.href="../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?"+params;
		}
		else if(called_from_cond_trt_tab_flag=="T"){
			//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)
			//params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn;
			//var params1="&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn+"&"+params;
			var params1="&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn+"&default_head_tab="+default_head_tab+"&main_tab="+main_tab+"&"+params;
			//var params1="&"+params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn;

			//alert("params1:=="+params1);
			//parent.frames[1].location.href="../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?"+params;
			//Added by Sharon Crasta on 1/8/2010 for IN017822
			//Sometimes the trmtDentalChart frame is not got. So if it is null, then load the higher frame in the else loop.
			if(flag_disable){
				params1 = params1 + "&chart_disable_from_main=Y";
			}
			if(parent.trmtDentalChart != null){
				parent.trmtDentalChart.location.href="../../eOH/jsp/OHDentalChartTrmtDetailsFrame.jsp?"+params1;
			}else{
			   parent.frames[1].location.href="../../eOH/jsp/OHDentalChartTrmtDetailsFrame.jsp?"+params1;
			}  //End
		}
		else{			
			//added by parul on 311008 for SCR-6059(Baseline chart was not working properly)
			//params=params+"&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn;

			params="&show_new_active_yn="+show_new_active_yn+"&chart_num="+chart_num+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&header_tab=T&new_chart_num="+new_chart_num+"&cur_chart_num="+cur_chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&date_diff_flag="+date_diff_flag+"&add_new_yn="+add_new_yn+"&"+params;

			//parent.frames[1].location.href="../../eOH/jsp/OHDentalChartCondDetailsFrame.jsp?"+params;
			//parent.perioSummaryFrame.location.href="../../eOH/jsp/PeriodontalSummary.jsp?"+params;
			// Modified the below code by bshankar as the Tab is changed. Backup is taken (Folder: D:\Work\1_Projects\10.2\OH\Backups\12012008)
			parent.parent.SummaryTabDetailsFrame.perioSummaryFrame.location.href="../../eOH/jsp/PeriodontalSummary.jsp?"+params;
		}

	//changeTabColor(called_from_cond_trt_tab_flag);
	
}
/*
function changeTabColor(called_from_cond_trt_tab_flag){
	//var main_tab = document.forms[0].main_tab.value;
	var cond_label = getLabel("eOH.Conditions.Label","OH");
	var trmt_label = getLabel("eOH.Treatments.Label","OH");
	if(called_from_cond_trt_tab_flag == "T"){
		if(parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != "null" && parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != null){
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").innerHTML = '<font color="white"><b>'+trmt_label+'</b></font>';
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.backgroundColor = "green";
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.color="red";
		}
	}
	else if(called_from_cond_trt_tab_flag == "C"){
		if(parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != "null" && parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != null){
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").innerHTML = '<font color="white"><b>'+cond_label+'</b></font>';
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.backgroundColor = "brown";
			parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.color = "white";
		}
	}
	else{
		if(parent.parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != "null" && parent.parent.parent.mainTabHeaderFrame.document.getElementById("tabColor") != null){
			parent.parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").innerHTML = "";
			parent.parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.backgroundColor = "white";
			parent.parent.parent.mainTabHeaderFrame.document.getElementById("tabColor").style.color = "white";
		}
	}
}
*/
</script>

<html>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="OHFrameForm" id="OHFrameForm"  >
     <input type="hidden" name='locale' id='locale' value=<%=locale%> >
	<input type = "hidden" name= "params" value = "<%=params%>">
	<input type = "hidden" name= "cur_chart_num" value = "<%=cur_chart_num%>">
	<input type = "hidden" name= "new_chart_num" value = "<%=new_chart_num%>">
	<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
	<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
	<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
	<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
	<input type = "hidden" name= "mixed_dentition_YN" value = "<%=mixed_dentition_YN%>">
	<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
	<input type = "hidden" name= "called_from_cond_trt_tab_flag" value = "<%=called_from_cond_trt_tab_flag%>">

	<input type = "hidden" name= "show_new_active_yn" value = "<%=show_new_active_yn%>">
	<input type = "hidden" name= "date_diff_flag" value = "<%=date_diff_flag%>">
	<input type = "hidden" name= "main_tab" value = "<%=main_tab%>">
	<input type = "hidden" name= "add_new_yn" value = "<%=add_new_yn%>">

	<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
	<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
	<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
	<input type = "hidden" name= "location_code" value = "<%=location_code%>">
	<input type = "hidden" name= "location_type" value = "<%=location_type%>">
	<input type = "hidden" name= "new_baseline_yn" value = "<%=new_baseline_yn%>">
	<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
	<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
	<input type = "hidden" name= "add_new_done_flag" value = "<%=add_new_done_flag%>">
	<input type = "hidden" name= "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
	<input type = "hidden" name= "old_facility_id" value = "<%=old_facility_id%>">
	<input type = "hidden" name= "default_head_tab_add_new" value = "<%=default_head_tab_add_new%>">
	<input type = "hidden" name= "change_tab_validity_yn" value = "<%=change_tab_validity_yn%>">
	<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->
	<input type="hidden" name="dflt_mixed_dentition_chart" id="dflt_mixed_dentition_chart" value="<%=dflt_mixed_dentition_chart%>">
	<input type="hidden" name="chart_type" id="chart_type" value="<%=chart_type%>">
	<!-- -->
	<!--Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)-->
	<input type="hidden" name = "loaded_from_main_tab" value = "<%=loaded_from_main_tab%>">
	<input type="hidden" name = "dentist_comments" value = "<%=dentist_comments%>">
	<!-- -->
	<!--Added by Sharon Crasta on 1/7/2010 for IN017822-->
	<input type="hidden" name = "loaded_from_trmt_tab" value = "<%=loaded_from_trmt_tab%>">
	<input type="hidden" name = "date_diff_chart_num" value = "<%=date_diff_chart_num%>">
	
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

