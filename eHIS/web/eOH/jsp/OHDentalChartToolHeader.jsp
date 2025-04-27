<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	String disable = "";
	String numbering_system_selected = "";
	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");

	String tooth_numbering_system = request.getParameter("tooth_numbering_system");
	
	String numbering_system_desc = request.getParameter("numbering_system_desc");
	String patient_id = request.getParameter("patient_id");
	String chart_flag = request.getParameter("chart_flag");
	String encounter_id = request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));
	String baseline_date = checkForNull(request.getParameter("baseline_date"));
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String baseline_new_chart = checkForNull(request.getParameter("baseline_new_chart"));
	//String refresh_hdr_flag = checkForNull(request.getParameter("refresh_hdr_flag"));
	//String tab_clicked = checkForNull(request.getParameter("tab_clicked"));
	String chart_status_from_view = checkForNull(request.getParameter("chart_status_from_view"));
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));
	//String baseline_new_char = checkForNull(request.getParameter("baseline_new_char"));
	String add_new_done_flag = checkForNull(request.getParameter( "add_new_done_flag" )) ;			
	String add_new_yn = checkForNull(request.getParameter( "add_new_yn" )) ;			
	String called_from = checkForNull(request.getParameter( "called_from" )) ;	
	
	//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
	String upper_arch_desc			= request.getParameter("upper_arch_desc");
	String lower_arch_desc			= request.getParameter("lower_arch_desc");
	String Q1_id					= request.getParameter("Q1_id");
	String Q2_id					= request.getParameter("Q2_id");
	String Q3_id					= request.getParameter("Q3_id");
	String Q4_id					= request.getParameter("Q4_id");
	String Q1_desc					= request.getParameter("Q1_desc");
	String Q2_desc					= request.getParameter("Q2_desc");
	String Q3_desc					= request.getParameter("Q3_desc");
	String Q4_desc					= request.getParameter("Q4_desc");
	String permanent_deciduous_flag = request.getParameter("permanent_deciduous_flag");
	String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String header_tab        =  checkForNull(request.getParameter("header_tab"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));

	//out.println("oh_chart_level:=="+oh_chart_level);
	String cur_chart_num="";
	/*if(baseline_chart_yn.equals("Y")){//added by parul  for other facility chart CRF#0423
		disable = "disabled";
	}*/
	//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
	String chart_num_baseline_yn = request.getParameter("chart_num_baseline_yn");
	String asOnDatePrint_Baseline_YN = request.getParameter("asOnDatePrint");
	String loaded_from_main_tab = request.getParameter("loaded_from_main_tab");
	String dentist_comments = request.getParameter("dentist_comments");
	//

	//Added by Sharon Crasta on 1/7/2010 for IN017822
	//If passed from treatment tab, Add New , The value will be "Y".
	String loaded_from_trmt_tab = request.getParameter("loaded_from_trmt_tab");
	//
	if(add_new_done_flag.equals("Y") || add_new_yn.equals("Y")){
	   other_chart_facility_id = facility_id;
	   other_facilitychart_yn = "N";
	   add_new_yn = "Y";
	}
	if(baseline_chart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){
		disable = "disabled";
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rst=null;


%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
		<script type='text/javascript' src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<script>
			function onMouseClickOfImage(imgId){
			}

			function assignDBValue(tooth_numbering_system,locale){
				var formObj = document.forms[0];
				if(formObj.baseline_chart_yn.value != "Y"){
					var cur_date = getCurrentDate("DMY","<%=locale%>")
					formObj.asOnDate.value = cur_date;
				}
			}

			function changeNumberingSystem(){ // This function is to rebuild the query without tooth_numbering_system parameter...
				var formObj = document.forms[0];

				var str = "";
				var main_tab = "";
				var numbering_system = formObj.numbering_system.value; // OnChange parameter
				var tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..
				var asOnDate = formObj.asOnDate.value;
				var params_hid = formObj.params.value;
				var baseline_chart_yn = formObj.baseline_chart_yn.value;
				var operating_facility_id_1 = formObj.operating_facility_id_1.value;//Added by Sridevi Joshi on 6/1/2010 for IN021653

				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				var oh_chart_level = formObj.oh_chart_level.value;
				//
				parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				//xmlHttp.open("POST","CommonValidation.jsp?func_mode=selectUserPrefferences&"+params,false);
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=selectUserPrefferences&"+params+"&oh_chart_level="+oh_chart_level,false);
				//
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var retVal=localTrimString(retVal);
				if(retVal.length > 1){
					retVal_arr = retVal.split("##");
					if(retVal_arr[0] == "" && (tooth_numbering_system == null || tooth_numbering_system == "null")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table
						tooth_numbering_system = retVal_arr[1];
						formObj.tooth_numbering_system.value = retVal_arr[1];
						formObj.numbering_system.value = retVal_arr[1];
					}
					else if(retVal_arr[0] != "" && (tooth_numbering_system == null || tooth_numbering_system == "null")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table
						tooth_numbering_system = retVal_arr[0];
						formObj.tooth_numbering_system.value = retVal_arr[0];
						formObj.numbering_system.value = retVal_arr[0];
					}
					else{ // Loding page when you click on the refresh button and tooth_numbering_system is not null
						if(tooth_numbering_system != numbering_system){
							var copy_as_defult  = confirm(getMessage("APP-OH00032","OH"))
							if(copy_as_defult){ // If you want to set this numbering system as default numbering system

								// Insert a record in to OH_USER_PREFERENCES table
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_numbering_system="+numbering_system;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=updateUserPrefferences&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								var retVal=localTrimString(retVal);
								

								if(retVal != 0){
									formObj.tooth_numbering_system.value = numbering_system;
									tooth_numbering_system = numbering_system;
								}
							}
							else{ //If you dont want to set this numbering system as default numbering system
								formObj.tooth_numbering_system.value = numbering_system;
								tooth_numbering_system = numbering_system;
							}
						}
					}
				}
				//Added by Sharon Crasta on 1/19/2010 for IN018302
				//If the ASonDate field is made blank, then it should be populated with the Sysdate on click of refresh
				if(asOnDate == ""){
				   var sys_date = new Date();
				   var month = sys_date.getMonth();												
				   var year = sys_date.getFullYear();
				   var date = sys_date.getDate();
				   month = (month < 9) ? ("0" + (1+month)) : (1+month);
				   date = (date <= 9) ? ("0" + date) : date;
				   asOnDate = date+"/"+month+"/"+year;
				   document.getElementById("asOnDate").value = asOnDate; 
				}
				//Added by Sharon Crasta on 4/8/2010 for IN020567
				//If asOnDate is given as a date for whihc no chart exists then, the message no chart exists should be given.
				else{
					var other_chart_facility_id = formObj.other_chart_facility_id.value;
					var patient_id = formObj.patient_id.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&asOnDate="+asOnDate+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkChartExists&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length == 0){
						//alert("No Chart exists for the given date");
						alert(getMessage("APP-OH000183","OH"));
						var sys_date = new Date();
					    var month = sys_date.getMonth();												
					    var year = sys_date.getFullYear();
					    var date = sys_date.getDate();

					    month = (month < 9) ? ("0" + (1+month)) : (1+month);
						date = (date <= 9) ? ("0" + (date)) : date;
					    asOnDate = date+"/"+month+"/"+year;
					    document.getElementById("asOnDate").value = asOnDate;
						return false;
					}

				} 
				//End
				// This is to validate the as on date field
				if(!checkDateNotGraterThanSysDate(formObj.asOnDate)){
					return;
				}
				
				if(parent.frames[1].Treatment != null && parent.frames[1].Treatment != "null" && parent.frames[1].Treatment != "undefined" && parent.frames[1].Treatment != undefined){
					if(parent.frames[1].Treatment.className == "tabClicked"){
						main_tab = "Treatment";
					}
					else{
						main_tab = "Condition";
					
					}
				}
				//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
				//Added to display the print image icon only when Treatment tab is clicked.
				else{
						main_tab = "Condition";				
				}
				
				//Commented and added by Sharon Crasta on 11/20/2009 for IN016476
				//Was gettign a script error when clicking on the refresh icon.
				/*if(main_tab == "Condition"){
					document.getElementById("print_img").style.visibility='hidden';
				}*/
				var chart_num_print = formObj.chart_num_for_print.value;
				if(chart_num_print != "" && chart_num_print != "null" && chart_num_print != null && chart_num_print != "undefined" && chart_num_print != undefined){
					if(main_tab == "Treatment"){
						document.getElementById("print_img").style.visibility='visible';
					}
				}
				//End

				var params_str = formObj.params.value;
				var patient_id = formObj.patient_id.value;
				var chart_flag = formObj.chart_flag.value;

				//alert(oh_chart_level);

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "numbering_system="+tooth_numbering_system+"&patient_id="+patient_id+"&chart_flag="+chart_flag+"&oh_chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","buildOHParameters.jsp?func_mode=buildOHParameters&"+params,false);
				xmlHttp.send(xmlDoc);
				//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
				/*var retVal = trimString(xmlHttp.responseText);
				var ret_params=localTrimString(retVal);	  */
				var retVal_print_params=localTrimString(xmlHttp.responseText);
				var retVal_arr = retVal_print_params.split("~~");
				var ret_params=retVal_arr[0];
				var code_desc_arr = retVal_arr[1].split("##");

				formObj.upper_arch_desc.value = code_desc_arr[1];
				formObj.lower_arch_desc.value = code_desc_arr[2];
				formObj.Q1_id.value = code_desc_arr[3];
				formObj.Q2_id.value = code_desc_arr[4];
				formObj.Q3_id.value = code_desc_arr[5];
				formObj.Q4_id.value = code_desc_arr[6];
				formObj.Q1_desc.value = code_desc_arr[7];
				formObj.Q2_desc.value = code_desc_arr[8];
				formObj.Q3_desc.value = code_desc_arr[9];
				formObj.Q4_desc.value = code_desc_arr[10];
				formObj.permanent_deciduous_flag.value = code_desc_arr[11];
				formObj.mixed_dentition_YN.value = code_desc_arr[12];

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var query_params = "asOnDate="+asOnDate;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				//Commented and Added by Sharon Crasta on 1/19/2010 for IN018302
				// If the AsOnDate was changed to a lesser value than the sysdate then recordings were being allowed. 
				//Done to disable the chart.
				//xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getCountOfCharts&"+query_params,false);
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDiffDate&"+query_params,false);
				//End
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var date_diff_flag=localTrimString(retVal);
				//End

				//Added by sridevi Joshi on 6/1/2010 for IN021668
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var query_params = "asOnDate="+asOnDate+"&patient_id="+patient_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=getClosedCharNum&"+query_params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var date_diff_chart_num=localTrimString(retVal);

				var chart_num_lebel = getLabel("eOH.Chart.Label","OH");

				if(oh_chart_level == "E"){
					chart_num_lebel = chart_num_lebel+" "+date_diff_chart_num+"("+operating_facility_id_1+")";
				}
				else{
					chart_num_lebel = chart_num_lebel+" "+date_diff_chart_num+"("+other_chart_facility_id+")";
				}

				//if(date_diff_flag == "disable"){
					document.getElementById("chart_identity").innerHTML = chart_num_lebel;//Added by sridevi Joshi on 6/1/2010 for IN021668
				//}

				params=ret_params+"&"+params_str+"&main_tab="+main_tab+"&date_diff_flag="+date_diff_flag+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_chart_num="+date_diff_chart_num; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.	

	
				if(main_tab == "Treatment"){
					//parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+params;
					parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+params;
				}
				else{
					parent.frames[2].location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp?"+params;
				}
			}

			
			function localTrimString(sInString) {
				sInString = sInString.replace( /^\s+/g, "" );// strip leading
				return sInString.replace( /\s+$/g, "" );// strip trailing
			}

			function printOverview(){

				var formObj = document.forms[0];
				var patient_id = formObj.patient_id.value;
				//var chart_num = formObj.chart_num.value;
				var chart_flag = formObj.chart_flag.value;

				//var chart_line_num = formObj.chart_line_num.value;
				//var DentalChartFormObj = parent.trmtDentalChartDetails.document.forms[0];
				//var header_tab = formObj.header_tab.value;
				var tooth_numbering_system = formObj.tooth_numbering_system.value;
				var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
				var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
				var upper_arch_desc = formObj.upper_arch_desc.value;
				var lower_arch_desc = formObj.lower_arch_desc.value;
				var Q1_id = formObj.Q1_id.value;
				var Q2_id = formObj.Q2_id.value;
				var Q3_id = formObj.Q3_id.value;
				var Q4_id = formObj.Q4_id.value;
				var Q1_desc = formObj.Q1_desc.value;
				var Q2_desc = formObj.Q2_desc.value;
				var Q3_desc = formObj.Q3_desc.value;
				var Q4_desc = formObj.Q4_desc.value;  
				var chart_num_print = formObj.chart_num_for_print.value;
				var asOnDatePrint = formObj.asOnDate.value;
				var oh_chart_level = formObj.oh_chart_level.value;
				var other_chart_facility_id = formObj.other_chart_facility_id.value;
				var baseline_chart_yn = formObj.baseline_chart_yn.value;
				var chart_num = "";
				//Added by Sharon Crasta on 1/19/2010 for IN018302
				//If the ASonDate field is made blank, then it should be populated with the Sysdate on click of refresh
				if(asOnDatePrint == ""){
				   var sys_date = new Date();
				   var month = sys_date.getMonth();												
				   var year = sys_date.getFullYear();
				   var date = sys_date.getDate();

				   month = (month < 9) ? ("0" + (1+month)) : (1+month);
				   date = (date <= 9) ? ("0" + (date)) : date;
				   asOnDatePrint = date+"/"+month+"/"+year;
				   document.getElementById("asOnDate").value = asOnDatePrint; 


				}
				//Added by Sharon Crasta on 4/8/2010 for IN020567
				//If asOnDate is given as a date for whihc no chart exists then, the message no chart exists should be given.
				else{
					var other_chart_facility_id = formObj.other_chart_facility_id.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&asOnDate="+asOnDatePrint+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkChartExists&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length == 0){
						alert(getMessage("APP-OH000183","OH"));
						var sys_date = new Date();
					    var month = sys_date.getMonth();												
					    var year = sys_date.getFullYear();
					    var date = sys_date.getDate();

					    month = (month < 9) ? ("0" + (1+month)) : (1+month);
					    date = (date <= 9) ? ("0" + (date)) : date;
					    asOnDatePrint = date+"/"+month+"/"+year;
					    document.getElementById("asOnDate").value = asOnDatePrint;
						return false;
					}

				}
				//End
				if(baseline_chart_yn == "Y"){
					
					chart_num = formObj.chart_num_baseline_yn.value;
					
				}else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_status=A"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getMaxChartNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					
					if(retVal != "null" && retVal != "" && retVal != null && retVal.length >= 1){
						
						chart_num= retVal;
					}
					//chart_num = formObj.chart_num_for_print.value;
				//	asOnDatePrint = formObj.asOnDatePrint_Baseline_YN.value;
				}
				//formObj.dentist_comments.value = checkSpl(formObj.dentist_comments.value);
				//var qry_string = "patient_id="+patient_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
				var qry_string = "patient_id="+patient_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&asOnDatePrint="+asOnDatePrint+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&baseline_chart_yn="+baseline_chart_yn+"&tooth_numbering_system="+tooth_numbering_system;
				
				var url	= "../../eOH/jsp/PrintChart.jsp?"+qry_string;
				
				//location.href =  "../../eOH/jsp/PrintChart.jsp?"+qry_string;

				//var testwindow= window.open (url, "WindowTitle","location=0,status=0,scrollbars=2,width=800,height=450");

				var testwindow= window.open (url, "PrintChart","location=0,status=0,scrollbars=4,width=850,height=670");

				testwindow.moveTo(49,20);

			} 
			
			//Added by Sharon Crasta on 1/22/2010 for IN018302
			//Added to display an alert message if the asOnDate value is blank.
			//Added to display an alert message if no chart exists for the given date.
			function checkForBlank(asOnDate,asOnDatCal){
				var formObj = document.forms[0];
				var flag_blank = false;
				var asOn_title = getLabel("eOH.Chartason.Label","OH");
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				var msgArray = msg.split("$");
				var patient_id = formObj.patient_id.value;
				var asOnDate = formObj.asOnDate.value;
				var oh_chart_level = formObj.oh_chart_level.value;
				var other_chart_facility_id = formObj.other_chart_facility_id.value;
				if(asOnDate == "" || asOnDate == "null"){
					//alert(msgArray[0]+ asOn_title + msgArray[1]);
					document.forms[0].asOnDate.focus();
					flag_blank = true;
					return false;
				}
				/*else if(asOnDatCal == "Cal"){
					return true;				
				}*/
				else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&asOnDate="+asOnDate+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkChartExists&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(parseInt(retVal) >= 1){
						changeNumberingSystem();
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&asOnDate="+asOnDate+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkasOnDateChartNum&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_ason_chart_num = trimString(xmlHttp.responseText);
						retVal_ason_chart_num = localTrimString(retVal_ason_chart_num);

						if(retVal_ason_chart_num.length > 0){
							document.getElementById("asondate_chart_num").value = retVal_ason_chart_num;
						}
						return true;					
					}
					else{
						//alert("No Chart exists for the given date");
						//alert(getMessage("APP-OH000183","OH"))
						return false;
					}

				}
				
			}
			 function CheckDate(Object2,focusflag) {
				var datefield = Object2;
				if (Object2.value != undefined)
				{
					Object2 = Object2.value;
				}
				else
				{
					Object2 = Object2;
				}

				hasChanged= true;
				if (ChkDate(Object2) == false) {
					if(hasChanged){
						alert(getMessage("INVALID_DATE_FMT", "SM"));
						if (datefield.value != undefined && focusflag == null)
						{
							datefield.select();
							datefield.focus();
						}
						hasChanged = false;
						return false;
					}
				}
				else {
					return true;
				}
			}
			//Date Validation Check
			function checkDateValidity(obj){
				if(obj.value!=null && obj.value!=""){
					var retVal = CheckDate(obj.value);
					if(retVal==false){
						obj.focus();
						obj.select();
						//return false;
						return false;
					}
				}
				return true;
			}
			//End
		</script>
	</head>
	<%
	try{
			con=ConnectionManager.getConnection(request);
			//String oh_chart_level="";
			String operating_facility_id_1="";
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
		}
		pstmt1 = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rst = pstmt1.executeQuery();
				while (rst != null && rst.next()){
					oh_chart_level = checkForNull(rst.getString("CHART_LEVEL"));
				}

	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE PATIENT_ID = ? AND CHART_STATUS = 'A'  ");
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
	}else{

		pstmt = con.prepareStatement("SELECT CHART_NUM CUR_CHART_NUM FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A' ");
		//pstmt.setString(1,facility_id);
		pstmt.setString(1,other_chart_facility_id);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
	}
		while(rs.next()){
			cur_chart_num = rs.getString("CUR_CHART_NUM");
		}	
		
		pstmt = con.prepareStatement("SELECT OPERATING_FACILITY_ID FROM OH_RESTORATIVE_CHART_HDR WHERE CHART_NUM=? AND PATIENT_ID=? ");
		//pstmt.setString(1,facility_id);
		if (chart_num.equals("")||chart_num.equals("null")|| chart_num.equals(null)){
			pstmt.setString(1,cur_chart_num);
		}else{
			pstmt.setString(1,chart_num);
		}
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			operating_facility_id_1 = rs.getString("OPERATING_FACILITY_ID");
		}	

	%>
	 
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload ="assignDBValue('<%=tooth_numbering_system%>','<%=locale%>');">

		<form name="toolHeaderForm" id="toolHeaderForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" align=center>
				<tr></tr><tr></tr><tr></tr>
				<tr>
					<td width="15%" valign="top">
						<table cellpadding="0" cellspacing="0" border="1" frame="below" width="90%" BORDERCOLOR="GRAY" >
							<tr>
								<td colspan="10" class="LABEL">
									<table cellpadding="0" cellspacing="0" border="1" frame="below" > 
										<tr>
											<td width="7%"><img border="1" style="border-color:white" id="TRUMTH" src="../../eOH/images/Trauma.gif" alt='<fmt:message key="Common.Trauma.label" bundle="${common_labels}"/>' onclick="onMouseClickOfImage('TRUMTH');"/></td>
											<td width="7%"><img border="1" style="border-color:white" id="ATRARER" src="../../eOH/images/AttritionAbrationErotion.gif" alt='<fmt:message key="eOH.AttritionAbrationErotion.Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('ATRARER');"/></td> 
											<td width="7%"><img border="1" style="border-color:white" id="SUPRTH" src="../../eOH/images/SuperNumerary.gif" alt='<fmt:message key="eOH.SuperNumerary.Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('SUPRTH');"/></td>
											<td width="7%"><img border="1" style="border-color:white" id="MISSTH" src="../../eOH/images/MissingTeeth.gif" alt='<fmt:message key="eOH.MissingTeeth.Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('MISSTH');"/></td>
											<td width="7%"><img border="1" style="border-color:white" id="PARERTH" src="../../eOH/images/PartialEruption.gif" alt='<fmt:message key="eOH.PartialEruption.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('PARERTH');"/></td>
											<td width="7%"><img border="1" style="border-color:white" id="UNERTH" src="../../eOH/images/Uneruption.gif" alt='<fmt:message key="eOH.Uneruption.Label" bundle="${oh_labels}"/>'    onclick="onMouseClickOfImage('UNERTH');"/></td>
											<td width="7%"><img border="1" style="border-color:white" id="IMPACTN" src="../../eOH/images/Impaction-Normal.gif" alt='<fmt:message key="eOH.ImpactionNormal.Label" bundle="${oh_labels}"/>'    onclick="onMouseClickOfImage('IMPACTN');"/></td> 
											<td width="7%"><img border="1" style="border-color:white" id="MOBILITY" src="../../eOH/images/Mobility.gif" alt='<fmt:message key="eOH.Mobility.Label" bundle="${oh_labels}"/>'    onclick="onMouseClickOfImage('IMPACTN');"/></td>
											<!-- Added by Sharon Crasta on 1/28/2010 for SRR20056-CRF-0498(IN010982)-->
											<!-- Added to display the images for Mal position and Mal Occlusion-->
											<td width="7%"><img border="1" style="border-color:white" id="MALOCLN" src="../../eOH/images/MalOcclution.gif" alt='<fmt:message key="eOH.Malocclusion.Label" bundle="${oh_labels}"/>'    onclick="onMouseClickOfImage('MALOCLN');"/></td> 
											 <td width="7%"><img border="1" style="border-color:white" id="MALPOSN" src="../../eOH/images/MalPosition.gif" alt='<fmt:message key="eOH.Malposition.Label" bundle="${oh_labels}"/>'    onclick="onMouseClickOfImage('MALPOSN');"/></td> 
											<!-- -->
											
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<!-- <td width="20%" valign="top"> -->
					<td width="12%" valign="top">
						<table align="left" cellpadding="0" cellspacing="0" border="1" frame="below"  width="90%" bordercolor="GRAY">
							<tr>
								<td colspan="10" class="LABEL">
									<table cellpadding="0" cellspacing="0" border="1" frame="below"> 
										<tr>
										  <td width="7%"><img src="../../eOH/images/Extraction-CrownYellow.gif" alt='<fmt:message key="eOH.Extraction(Planned).Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Extraction');" width="18" height="16"/></td>
										  <td width="7%"><img src="../../eOH/images/Extraction-CrownGreen.gif" alt='<fmt:message key="eOH.Extraction(Performed).Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('Extraction');" width="18" height="16"/></td>
										  <td width="7%"><img src="../../eOH/images/Implantindicator.gif" alt='<fmt:message key="Common.Implant.label" bundle="${common_labels}"/>'   onclick="onMouseClickOfImage('Implant');"/></td>
										 <td width="7%"><img src="../../eOH/images/Denture_indicator.gif" alt='<fmt:message key="eOH.Denture.Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('Denture');"/></td> 
										  <td width="7%"><img src="../../eOH/images/Bridge.gif" alt='<fmt:message key="eOH.Bridge.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Bridge');"/></td> 
										  <td width="7%"><img src="../../eOH/images/Ortho.gif" alt='<fmt:message key="eOH.OrthodonticAppliance.Label" bundle="${oh_labels}"/>' onclick="onMouseClickOfImage('Ortho');"/></td> 
										  <td width="7%"><img src="../../eOH/images/Impaction-Treatment.gif" alt='<fmt:message key="eOH.ImpactionTreatment.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Impaction-Treatment');"/></td> 
										  <td width="7%"><img src="../../eOH/images/TRMT_Planned.gif"  alt='<fmt:message key="eOH.ToothTrmt(Planned).Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('ToothTreatment');"/></td> 
										  <td width="7%"><img src="../../eOH/images/TRMT_Perf.gif"  alt='<fmt:message key="eOH.ToothTrmt(Performed).Label" bundle="${oh_labels}"/>'   onclick="onMouseClickOfImage('ToothTreatment');"/></td> 
										   <td width="7%"><img src="../../eOH/images/CrownDownTool.gif"  alt='<fmt:message key="eOH.CrownForUA.Label" bundle="${oh_labels}"/>' onclick="onMouseClickOfImage('Crownup');"/></td>
										  <td width="7%"><img src="../../eOH/images/CrownUpTool.gif"  alt='<fmt:message key="eOH.CrownForLA.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Crowndown');"/></td>
										  <!--<td width="7%"><img src="../../eOH/images/AbutmentIcon.gif"  alt='<fmt:message key="eOH.Abutment.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Abutment');"/></td>
										  <td width="7%"><img src="../../eOH/images/PonticIcon.gif"  alt='<fmt:message key="eOH.Pontic.Label" bundle="${oh_labels}"/>'  onclick="onMouseClickOfImage('Pontic');"/></td>	-->
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<!-- <td width="43%" valign="top"> -->
					<td width="43%" valign="top">
						<table align="right" cellpadding="0" cellspacing="0" >
							 <tr>
								<!-- Commented and Added by Sharon Crasta on 1/28/2010 forSRR20056-CRF-0498(IN010982)-->
								<!-- Added to display the images for Mal position and Mal Occlusion-->
								<!-- <td width="2%"><font class="HYPERLINK" style="font-size:15pt;color:blue;cursor:pointer;font-weight:normal" title='<fmt:message key="eOH.ImagesInfoTitle.Label" bundle="${oh_labels}"/>' onClick="window.open('showCondTrmtImages.jsp','','height=400,width=230,top=100,left=770,status=NO,toolbar=no,menubar=no,location=no,scrollbar=auto,resize=yes');">...&nbsp;</font> -->

								<td width="2%" ><font class="HYPERLINK" style="font-size:15pt;color:blue;cursor:pointer;font-weight:normal" title='<fmt:message key="eOH.ImagesInfoTitle.Label" bundle="${oh_labels}"/>' onClick="window.open('showCondTrmtImages.jsp','','height=500,width=350,top=100,left=640,status=NO,toolbar=no,menubar=no,location=no,scrollbar=auto,resize=yes');">...&nbsp;</font>
								<!-- End -->
								</td>
								<td class="LABEL" style="text-align:center">
									<select name="numbering_system" id="numbering_system" <%=disable%>>
									<%
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
										pstmt=con.prepareStatement("SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY 2");
										pstmt.setString(1,locale);
										rs=pstmt.executeQuery();
										while(rs.next()){
											String DB_numbering_system = rs.getString("NUMBERING_SYSTEM");
											String DB_numbering_system_desc = rs.getString("NUMBERING_SYSTEM_DESC");
											if(baseline_chart_yn.equals("Y") && tooth_numbering_system.equals(DB_numbering_system)){ //Closed baseline Chart
												numbering_system_selected = "selected";
											}
											else if(baseline_new_chart.equals("Y") && tooth_numbering_system.equals(DB_numbering_system)){ // New Baseline Chart
												numbering_system_selected = "selected";
											}
											else if(chart_status_from_view.equals("A") && tooth_numbering_system.equals(DB_numbering_system)){ //Active Baseline Chart
												numbering_system_selected = "selected";
											}
											else{
												numbering_system_selected = "";
											}
									%>
											<option value="<%=DB_numbering_system%>" <%=numbering_system_selected%>><%=DB_numbering_system_desc%></option>
									<%
										}
									%>
									</select>
								</td>
								<td class="LABEL" style="text-align:center" id="chart_identity">
							<%if(oh_chart_level.equals("E")){%>
								<%if (chart_num.equals("") || chart_num.equals("null") || chart_num.equals(null)){%>
									<fmt:message key="eOH.Chart.Label" bundle="${oh_labels}"/> <%=cur_chart_num%>(<%=operating_facility_id_1%>)

                                    <%}else{%>
									  <fmt:message key="eOH.Chart.Label" bundle="${oh_labels}"/> <%=chart_num%>(<%=operating_facility_id_1%>)

								  <%}%>				
							<%}else{%>
								<%if (chart_num.equals("") || chart_num.equals("null") || chart_num.equals(null)){%>
									<fmt:message key="eOH.Chart.Label" bundle="${oh_labels}"/> <%=cur_chart_num%>(<%=operating_facility_id_1%>)

                                  <%}else{%>
									  <fmt:message key="eOH.Chart.Label" bundle="${oh_labels}"/> <%=chart_num%>(<%=other_chart_facility_id%>)

								  <%}%>		

							<%}%>
							</td>
								<td class="LABEL" style="text-align:center">
									<fmt:message key="eOH.Chartason.Label" bundle="${oh_labels}"/>
									<%
										if(baseline_chart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){
										//if(baseline_chart_yn.equals("Y")){
									%>
											<input type="text" name="asOnDate" id="asOnDate" value="<%=baseline_date%>" size=10 disabled>
											<input type='image' src='../../eCommon/images/CommonCalendar.gif' disabled >
									<%
										}
										else{
									%>
											<input type="text" name="asOnDate" id="asOnDate" value="" size=10 onKeyPress = "NumberCheck(this);" onBlur="checkDateNotGraterThanSysDate(this);checkDateValidity(this);">
											<input type='image' id="asOnDateCal" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('asOnDate');" >
									<%
										}
									%>
								</td>
								<td id="print_chart">
									<img id='print_img' src="../../eOR/images/print-Preview.gif" alt="Print" style="cursor:pointer;" onclick="printOverview();" />
									<img id="refresh_icon" src="../../eOH/images/Refresh.gif" alt="Refresh" onclick="changeNumberingSystem()" <%=disable%>/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value="<%=tooth_numbering_system%>">
			<input type="hidden" name="numbering_system_desc" id="numbering_system_desc" value="<%=numbering_system_desc%>">
			<input type="hidden" name="params" id="params" value="<%=params%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="chart_flag" id="chart_flag" value="<%=chart_flag%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="baseline_chart_yn" id="baseline_chart_yn" value="<%=baseline_chart_yn%>">
			<input type="hidden" name="chart_num" id="chart_num" value="<%=chart_num%>">
			<input type="hidden" name="baseline_new_chart" id="baseline_new_chart" value="<%=baseline_new_chart%>">
			<input type="hidden" name = "image_selected" value = "">
			<input type="hidden" name = "params_hid" value = "">
			<input type="hidden" name = "tooth_no" value = "">
			<input type="hidden" name = "site_type" value = "">
			<input type="hidden" name = "chart_status_from_view" value = "<%=chart_status_from_view%>">
			<input type="hidden" name = "other_facilitychart_yn" value = "<%=other_facilitychart_yn%>">
			<input type="hidden" name = "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
			<input type="hidden" name = "add_new_done_flag" value = "<%=add_new_done_flag%>">
			<input type="hidden" name = "add_new_yn" value = "<%=add_new_yn%>">
			<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->
			<input type="hidden" name = "oh_chart_level" value = "<%=oh_chart_level%>">
			<!--Added by Sharon Crasta on 7/28/2009 for PMG20089-CRF-0700-->
			<input type="hidden" name = "upper_arch_desc" value = "<%=upper_arch_desc%>">
			<input type="hidden" name = "lower_arch_desc" value = "<%=lower_arch_desc%>">
			<input type="hidden" name = "Q1_id" value = "<%=Q1_id%>">
			<input type="hidden" name = "Q2_id" value = "<%=Q2_id%>">
			<input type="hidden" name = "Q3_id" value = "<%=Q3_id%>">
			<input type="hidden" name = "Q4_id" value = "<%=Q4_id%>">
			<input type="hidden" name = "Q1_desc" value = "<%=Q1_desc%>">
			<input type="hidden" name = "Q2_desc" value = "<%=Q2_desc%>">
			<input type="hidden" name = "Q3_desc" value = "<%=Q3_desc%>">
			<input type="hidden" name = "Q4_desc" value = "<%=Q4_desc%>">
			<input type="hidden" name = "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
			<input type="hidden" name = "mixed_dentition_YN" value = "<%=mixed_dentition_YN%>">
			<!--Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700-->
			<input type="hidden" name = "chart_num_for_print" value = "<%=cur_chart_num%>">
			<input type="hidden" name = "chart_num_baseline_yn" value = "<%=chart_num_baseline_yn%>">
			<input type="hidden" name = "asOnDatePrint_Baseline_YN" value = "<%=asOnDatePrint_Baseline_YN%>">
			<input type="hidden" name = "loaded_from_main_tab" value = "<%=loaded_from_main_tab%>">
			<input type="hidden" name = "dentist_comments" value = "<%=dentist_comments%>">
			<input type="hidden" name = "called_from" value = "<%=called_from%>">
			<input type="hidden" name = "header_tab" value = "<%=header_tab%>">
			<!--Added by Sharon Crasta on 1/7/2010 for IN017822-->
			<input type="hidden" name = "loaded_from_trmt_tab" value = "<%=loaded_from_trmt_tab%>">
			<input type="hidden" name = "operating_facility_id_1" value = "<%=operating_facility_id_1%>">
		</form>
		<script>
			/*
			var called_from_ot = '<%=called_from%>';
			if(called_from_ot != "OT"){
				var formObj = document.forms[0];
			}else{
				var formObj = document.forms[1];
			}*/
			var formObj = document.forms[0];
			var baseline_chart_yn = formObj.baseline_chart_yn.value;
			var baseline_new_chart = formObj.baseline_new_chart.value;
			var chart_status_from_view = formObj.chart_status_from_view.value;
			//Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
			var header_tab = formObj.header_tab.value;
			if(baseline_chart_yn == "Y"){
				cur_chart_num = formObj.chart_num_baseline_yn.value;
			}
			//
		
			if(baseline_chart_yn != "Y" && baseline_new_chart != "Y"){
				changeNumberingSystem();
			}
			//Added by Sharon Crasta on 11/2/2009 for Print Chart PMG20089-CRF-0700
			//When clicking from the baseline, the print icon was getting displayed in the Condition Tab. The print icon should be displayed only when the Treatment Tab is clicked.
			if(parent.frames[1].Treatment != null && parent.frames[1].Treatment != "null" && parent.frames[1].Treatment != "undefined" && parent.frames[1].Treatment != undefined){
				if(parent.frames[1].Treatment.className == "tabClicked"){
					main_tab = "Treatment";
				}
				else{
					main_tab = "Condition";
				
				}
			}
			//Added by Sharon Crasta on 9/23/2009 for IN012603(PMG20089-CRF-0700)
			//Added to display the print image icon only when Treatment tab is clicked.
			else{
					main_tab = "Condition";				
			}
			
			if(main_tab == "Condition"){
				document.getElementById("print_img").style.visibility='hidden';
			}
			//Added by Sharon Crasta on 1/7/2010 for IN017822
			//If passed from treatment tab, Add New , The value will be "Y".
			var params = formObj.params.value;
			var loaded_from_trmt_tab = formObj.loaded_from_trmt_tab.value;
			params = params+"&loaded_from_trmt_tab="+loaded_from_trmt_tab;
			//End
		</script>
	</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

