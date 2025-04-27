var tab_name; 
var arch_quad;
var quad_desc;
var arch_desc;
var selected_tooth_count = 0;
var selected_quad_count = 0;
var selected_arch_count = 0;
var site_colchk_val = "";
var site_rowchk_quad_val;
var site_rowchk_arch_val;
var thrng_nos = "";
var name_tooth_no = "";
var thrng_nos_arr;
var thrng_nos_ref = "";											 
var selected_first_thno = "";
var selected_site = "";
var quad_desc_1="";
var retained_normal=false;
var retained_deciduous=false;
var isSprRecorded = false;


//Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475
var flag_for_bridge_thrng = "";
//End
var isMissing = false;//Added by SRidevi Joshi for 16115 on 11/27/2009
//Added by Sharon Crasta on 10/9/2009 for IN015202

var isPartiallyErupted = false;
var isErupted = false;
var isDeciduousTooth = false;

//For getAllImages Function
var duplicate = new Array();
var show_new_active_yn = "N";
var j = 0;
var count=0;

// Not used in any of the function 
function onMouseOverFunctionRoot(name){
	hideToolTip();
}

function onMouseOverFunctionCrown(name){
	hideToolTip();
}

function onMouseOverFunctionNumber(name){
	hideToolTip();
}

function onMouseOutFunctionRoot(){
}

function onMouseOutFunctionCrown(){
}

function onMouseOutFunctionNumber(){
}

function getCalledFromGingSummaryYN(){
	var called_from_ging_summary  = "N";
	var called_from_perio_summary  = "N";
	if(parent.conditionDentalChartDataEntry != null && parent.conditionDentalChartDataEntry != "null" && parent.conditionDentalChartDataEntry != undefined && parent.conditionDentalChartDataEntry != "undefined"){ //this is bcoz in Treatments tab the data entry frame is 'trmtDentalChartDataEntry'
		var summaryFrameObj = parent.conditionDentalChartDataEntry.perioSummaryFrame;
		var perioSummaryFrameObj = parent.conditionDentalChartDataEntry.PerioSummaryHeaderFrame;
		if(summaryFrameObj != null && summaryFrameObj != "null" && summaryFrameObj != undefined && summaryFrameObj != "undefined"){ //this is bcoz the perioSummaryFrame exists only when we are calling GingivalSummary from RHS menu
			called_from_ging_summary = summaryFrameObj.document.forms[0].called_from_ging_summary.value;
		}
		
	}
	else if(parent.trmtDentalChartDataEntry != null && parent.trmtDentalChartDataEntry != "null" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry != "undefined"){ //this is bcoz in Treatments tab the data entry frame is 'trmtDentalChartDataEntry'
		var summaryFrameObj = parent.trmtDentalChartDataEntry.perioSummaryFrame;
		var perioSummaryFrameObj = parent.trmtDentalChartDataEntry.PerioSummaryHeaderFrame;
		if(summaryFrameObj != null && summaryFrameObj != "null" && summaryFrameObj != undefined && summaryFrameObj != "undefined"){ //this is bcoz the perioSummaryFrame exists only when we are calling GingivalSummary from RHS menu
			called_from_ging_summary = summaryFrameObj.document.forms[0].called_from_ging_summary.value;
		}
		
	}
	return called_from_ging_summary;
}

function getCalledFromPerioSummaryYN(){
	var called_from_ging_summary  = "N";
	var called_from_perio_summary  = "N";
	if(parent.conditionDentalChartDataEntry != null && parent.conditionDentalChartDataEntry != "null" && parent.conditionDentalChartDataEntry != undefined && parent.conditionDentalChartDataEntry != "undefined"){ //this is bcoz in Treatments tab the data entry frame is 'trmtDentalChartDataEntry'
		var summaryFrameObj = parent.conditionDentalChartDataEntry.perioSummaryFrame;
		var perioSummaryFrameObj = parent.conditionDentalChartDataEntry.PerioSummaryHeaderFrame;
		if(perioSummaryFrameObj != null && perioSummaryFrameObj != "null" && perioSummaryFrameObj != undefined && perioSummaryFrameObj != "undefined"){ //this is bcoz the perioSummaryFrame exists only when we are calling GingivalSummary from RHS menu
			called_from_perio_summary = perioSummaryFrameObj.document.forms[0].called_from_perio_summary.value;
		}
	}
	else if(parent.trmtDentalChartDataEntry != null && parent.trmtDentalChartDataEntry != "null" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry != "undefined"){ //this is bcoz in Treatments tab the data entry frame is 'trmtDentalChartDataEntry'
		var summaryFrameObj = parent.trmtDentalChartDataEntry.perioSummaryFrame;
		var perioSummaryFrameObj = parent.trmtDentalChartDataEntry.PerioSummaryHeaderFrame;
		if(perioSummaryFrameObj != null && perioSummaryFrameObj != "null" && perioSummaryFrameObj != undefined && perioSummaryFrameObj != "undefined"){ //this is bcoz the perioSummaryFrame exists only when we are calling GingivalSummary from RHS menu
			called_from_perio_summary = perioSummaryFrameObj.document.forms[0].called_from_perio_summary.value;
		}
	}
	return called_from_perio_summary;
}

function setCheckValue(obj,tooth_num){
	var check_count = 0;
	var count_decith = 0;
	var count_total = 0;
	var count_total1 = 0;
	var count_exfolth = 0;
	
	var called_from_viewchart_yn_DC_ET = "";
	var formobj = document.forms[0];
	var header_hid_tab = formobj.header_tab.value;
	var called_from_viewchart_yn  = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag  = document.forms[0].date_diff_flag.value;
	var patient_id  = document.forms[0].patient_id.value;
	var chart_num  = document.forms[0].chart_num.value;
	var mixed_dentition_YN  = document.forms[0].mixed_dentition_YN.value;
	var permanent_deciduous_flag  = document.forms[0].permanent_deciduous_flag.value;
	var other_facilitychart_yn  = document.forms[0].other_facilitychart_yn.value;
	var tab_name = getTabNames();
	var called_from_ging_summary = getCalledFromGingSummaryYN();
	var called_from_perio_summary = getCalledFromPerioSummaryYN();
    //Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
    //End
	for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
		if(eval("document.forms[0].selcol"+i) != null){
			if(eval("document.forms[0].selcol"+i).checked){
				check_count++;
			}
		}
	}
	
	if(header_hid_tab == "C"){ // Disable the checkboxes when record from the RHS menu is selected(For Condition Tab)
		if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined"&&parent.conditionDentalChartDataEntry.qa_query_result!=undefined){
			
			called_from_viewchart_yn_DC_ET =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_yn.value;
			var called_from_viewchart_yn_GS =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_gingival.value;
		}
	}
	else{ // Disable the checkboxes when record from the RHS menu is selected(For Treatment Tab)
	    if(parent.trmtDentalChartDataEntry!="undefined"&&parent.trmtDentalChartDataEntry!=undefined && parent.trmtDentalChartDataEntry.document.forms[0]!="null" && parent.trmtDentalChartDataEntry.document.forms[0]!=null){
			called_from_viewchart_yn_DC_ET =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_yn.value;

			var called_from_viewchart_yn_GS =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_gingival.value;
	    }
	}

	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	//if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" ||called_from_viewchart_yn_GS =='Y' || called_from_perio_summary == "Y" || called_from_ging_summary == "Y" || other_facilitychart_yn.equals=="Y"){
	if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" ||called_from_viewchart_yn_GS =='Y' || called_from_perio_summary == "Y" || called_from_ging_summary == "Y" || other_facilitychart_yn.equals=="Y" || chart_disable_from_main == "Y"){ //End
		obj.checked = false;
		obj.value = 'N';
	}else{
		var elements  = formobj.elements;
		var thrng_arr = "";//thrng_nos.split(",");
		var thrng_ref_arr = "";//thrng_nos_ref.split(",");
		var tooth_ref = tooth_num.substring(0,tooth_num.indexOf("#"));
		tooth_num = tooth_num.substring(tooth_num.indexOf("#")+1);
		if(obj.checked == true){
			if(selected_tooth_count == 0){
				if(document.forms[0].UR_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else if(document.forms[0].UL_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else if(document.forms[0].LR_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else if(document.forms[0].LL_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else if(document.forms[0].lower_arch_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else if(document.forms[0].upper_arch_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
					//selected_tooth_count =0;
				}
				else{
					obj.checked = true;
					obj.value = 'Y';
				}
			}

			if(obj.checked == true){
				obj.value = 'Y';
				var reset_done = document.forms[0].reset_done.value;
				if(reset_done == "Y"){
					selected_tooth_count = 0;
					document.forms[0].reset_done.value = "N";
				}

				selected_tooth_count++;
				/*
				if(document.forms[0].header_tab.value == "C" && selected_tooth_count >1){
					selected_tooth_count = 1;
					obj.checked == false;
					obj.value = 'N';
				}
				*/
				
				if(selected_tooth_count >1){
					if(tab_name == "DC"){
						site_colchk_val = "TOOTH";
					}
					else{
						site_colchk_val = "THRNG";
					}
					//if(thrng_nos_ref != tooth_ref){
						thrng_nos = thrng_nos + "," +tooth_num ;
						thrng_nos_ref = thrng_nos_ref + "," +tooth_ref ;
					//}
				}
				else{
					site_colchk_val = "TOOTH";
					thrng_nos = tooth_num;
					thrng_nos_ref = tooth_ref;
					selected_first_thno = tooth_ref;
					/*
					if(document.forms[0].header_tab.value == "C"){
						toothSelectedMenuRules(selected_tooth_count);
						selected_tooth_count=0;
					}
					*/
				}
				//tab_name == "ET" is added By sridevi Joshi on 09/10/2008 to restrict treatment for a range with SUPRTH and RETDESTH
				//if(check_count > 1 && (tab_name == "DC" || tab_name == "ET")){ //commented by sridevi Joshi on 29/12/2008 to restrict treatment for a range with SUPRTH and RETDESTH
				if(check_count > 1){
					if(thrng_nos_ref == "" || thrng_nos_ref.indexOf(",") == -1){ //Added by Sridevi Joshi on 5/3/2010 for IN021121...tooth nos were getting updated twice in thrng_nos_ref //Condition thrng_nos_ref.indexOf(",") == -1 is added by Sridevi Joshi on 6/17/2010 for IN022176...on click of tooth no checkbox is checked and it was not added to thrng_nos_ref 
						if(thrng_nos_ref.indexOf(",") == -1){// This is to clear the values so that we can build it with below logic  when check box is checked on click of tooth no  .added by Sridevi Joshi on 6/17/2010 for IN022176
							thrng_nos_ref = "";
						}
						for(i=1;i<=52;i++){ // This block of code is to get the tooth nos for which checkbox is checked added by Sridevi Joshi on 1/8/2010
							if(eval("document.forms[0].selcol"+i) != null){
								if(eval("document.forms[0].selcol"+i).checked){
									if(thrng_nos_ref == ""){
										thrng_nos_ref = i;
									}
									else{
										thrng_nos_ref = thrng_nos_ref+","+i;
									}
									
								}
							}
						}
					}

					var thrng_nos_ref_arr = thrng_nos_ref.split(",");
					var thrng_nos_arr = thrng_nos.split(",");

					for(i=0;i<thrng_nos_ref_arr.length;i++){ //Commented by Sridevi joshi and passed tooth_ref for tooth_no by Sridevi Joshi on 5/3/2010 for IN021121...System was checking condition for all tooth whenever a range is selected..instaed i am checking for tooth whichever is selected
                         
						//To restict Multiple tooth selection on SUPRTH and RETDESTH
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						
						var params = "tooth_no="+thrng_nos_ref_arr[i]+"&patient_id="+patient_id+"&chart_num="+chart_num;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 

						if(retVal.length > 0){
							var retVal_arr = retVal.split("##");
							if(retVal_arr[0] == "Y"){ //SuperRDyn
								alert(getMessage("APP-OH00040","OH")); 
								//obj.checked = false;
								//obj.value = 'N';
								thrng_nos_ref = thrng_nos_ref_arr[i];

								selected_tooth_count--;
								for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
									if(eval("document.forms[0].selcol"+i) != null){
										if(eval("document.forms[0].selcol"+i).checked == true){
											eval("document.forms[0].selcol"+i).checked = false;
											selected_tooth_count = 0;
										}	
									}
								}
								break;
							}
							else{ 
								if(mixed_dentition_YN == "Y"){
									if(permanent_deciduous_flag == "P"){
										var exfolth_yn = 'N';
											
										//To restict Multiple tooth selection if tooth are in different Dentition Period(After recording EXFOLTH on one of the tooth)
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+thrng_nos_ref_arr[i]+"&patient_id="+patient_id+"&chart_num="+chart_num;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal = trimString(xmlHttp.responseText); 
										retVal = localTrimString(retVal); 
										count_total1++;
										count_total++;
										if(retVal.length > 0){
											var retVal_arr = retVal.split("##");
										
											if(retVal_arr[2] == "Y"){
												count_exfolth ++;
												exfolth_yn = "Y";
											}
											else{
												//To restict Multiple tooth selection if tooth are in different Dentition Period(After recording DECITH on one of the tooth)
												var xmlDoc = "" ;
												var xmlHttp = new XMLHttpRequest();
												var params = "tooth_no="+thrng_nos_ref_arr[i]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&site_type="+site_colchk_val;
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithYN&"+params,false);
												xmlHttp.send(xmlDoc);
												var retVal = trimString(xmlHttp.responseText); 
												retVal = localTrimString(retVal); 
												//count_total++;
												if(retVal.length > 0){
													var retVal_arr = retVal.split("~");
													for(n=0;n<retVal_arr.length-1;n++){
														var retVal_arr1 = retVal_arr[n].split("##");
													
														if(retVal_arr1[0] == "DECITH"){
															count_decith ++;
														}
													}
												}
											}
										}
											
										//if(count_total != count_decith && count_decith != 0 && (count_total1 != count_exfolth && exfolth_yn != "Y")){
										if(count_total != count_decith && count_decith != 0 && count_exfolth != 0){
											alert(getMessage("APP-OH000103","OH"));
											//obj.checked = false;
											//obj.value = 'N';
											thrng_nos_ref = thrng_nos_ref_arr[i];
											count_total = 0;
											count_decith = 0;
											selected_tooth_count--;
											for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
												if(eval("document.forms[0].selcol"+i) != null){
													if(eval("document.forms[0].selcol"+i).checked == true){
														eval("document.forms[0].selcol"+i).checked = false;
														selected_tooth_count = 0;
													}	
												}
											}
											break;
										}
									}
									else if(permanent_deciduous_flag == "D"){
										//To restict Multiple tooth selection if tooth are in different Dentition Period(After recording EXFOLTH on one of the tooth)
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+thrng_nos_ref_arr[i]+"&patient_id="+patient_id+"&chart_num="+chart_num;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal = trimString(xmlHttp.responseText); 
										retVal = localTrimString(retVal); 
										count_total++;
										if(retVal.length > 0){
											var retVal_arr = retVal.split("##");
										
											if(retVal_arr[2] == "Y"){
												count_decith ++;
											}
										}
											
										if(count_total != count_decith && count_decith != 0){
											alert(getMessage("APP-OH000103","OH"));
											//obj.checked = false;
											//obj.value = 'N';
											thrng_nos_ref = thrng_nos_ref_arr[i];
											count_total = 0;
											count_decith = 0;
											selected_tooth_count--;
											for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
												if(eval("document.forms[0].selcol"+i) != null){
													if(eval("document.forms[0].selcol"+i).checked == true){
														eval("document.forms[0].selcol"+i).checked = false;
														selected_tooth_count = 0;
													}	
												}
											}
											break;
										}
									}
								}
							}
						}
					}
				}

				//if(document.forms[0].header_tab.value == "T"){
					toothSelectedMenuRules(selected_tooth_count);
					//selected_tooth_count = 0;
				//}
			}
		}else{
			obj.value = 'N';
			site_colchk_val = "";
			selected_first_thno = "";
			// Code to remove the tooth number from the range list
			if(thrng_nos != "" && thrng_nos_ref != "" && thrng_nos != "null" && thrng_nos_ref != "null"  && thrng_nos != null && thrng_nos_ref != null && thrng_nos != "undefined" && thrng_nos_ref != "undefined"){
				if(thrng_nos.indexOf(",") != -1){
					thrng_arr=thrng_nos.split(",");
					thrng_ref_arr=thrng_nos_ref.split(",");
				}
				else{
					thrng_arr=thrng_nos;
					thrng_ref_arr=thrng_nos_ref;
				}
			}
				
			thrng_nos="";
			thrng_nos_ref = "";
			var k = 0;
			for(i=0;i<selected_tooth_count;i++){
				if(thrng_arr[i]!=tooth_num){
					if(k==0){
						thrng_nos = thrng_arr[i];
						
					}
					else
						thrng_nos = thrng_nos + "," + thrng_arr[i];
					k++;
				}
			}
			k=0;
			for(i=0;i<selected_tooth_count;i++){
				if(thrng_ref_arr[i]!=tooth_ref){
					if(k==0){
						thrng_nos_ref = thrng_ref_arr[i];
						selected_first_thno = thrng_nos_ref;
					}
					else
						thrng_nos_ref = thrng_nos_ref + "," + thrng_ref_arr[i];
					k++;
				}
			}
			selected_tooth_count--;
			/*
			if(document.forms[0].header_tab.value == "C"){
				selected_tooth_count = 0;
			}
			*/
			if(selected_tooth_count == 0){
				site_colchk_val = ""
				selected_first_thno = "";
				
			}
			else if(selected_tooth_count >1){
				site_colchk_val = "THRNG";
			}
			else{
				site_colchk_val = "TOOTH";
				//toothSelectedMenuRules(selected_tooth_count);
			}
			//}
			toothSelectedMenuRules(check_count);
		}
	}
}
function setCheckvalForQuad(obj,tooth_num){
	var check_count = 0;
	var quad_check_count = 0;
	var quad_desc_1 = "";
	var quad_desc_2 = "";
	var arch_desc_1 = "";
	var called_from_viewchart_yn_DC_ET = "";
	var header_hid_tab = document.forms[0].header_tab.value;
	var called_from_viewchart_yn  = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag  = document.forms[0].date_diff_flag.value;
	var other_facilitychart_yn  = document.forms[0].other_facilitychart_yn.value;
	var called_from_ging_summary = getCalledFromGingSummaryYN();
	var called_from_perio_summary = getCalledFromPerioSummaryYN();
	if(header_hid_tab == "C"){ // Disable the checkboxes when record from the RHS menu is selected(For Condition Tab)
        if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined"&&parent.conditionDentalChartDataEntry.qa_query_result!=undefined){
		called_from_viewchart_yn_DC_ET =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_yn.value;
	    }
   }
	else{ // Disable the checkboxes when record from the RHS menu is selected(For Treatment Tab)

				if(parent.trmtDentalChartDataEntry != "undefined" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry.document.forms[0] != "null" && parent.trmtDentalChartDataEntry.document.forms[0] != null ){
					called_from_viewchart_yn_DC_ET =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_yn.value;
				}
	}
	 //Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	//if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" || called_from_ging_summary == "Y" || called_from_perio_summary == "Y"){
	//added by parul  for other facility chart CRF#0423
	if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" || called_from_ging_summary == "Y" || called_from_perio_summary == "Y" || other_facilitychart_yn=="Y" || chart_disable_from_main == "Y"){//End
		obj.checked = false;
		obj.value = 'N';
	}else{
		if(obj.checked == true){
			selected_site = "QUAD";
			if(document.forms[0].UR_quadrant_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			else if(document.forms[0].UL_quadrant_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			else if(document.forms[0].LR_quadrant_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			else if(document.forms[0].LL_quadrant_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			else{
				obj.checked = true;
				obj.value = 'Y';
			}
		
			// Function to uncheck the non applicable Quadrants
			for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
				if(eval("document.forms[0].selcol"+i) != null){
					if(eval("document.forms[0].selcol"+i).checked){
						check_count++;
					}
				}
			}
			
           
			quadrantSelectedMenuRules(tooth_num);

			if(obj.checked == true){
				obj.value = 'Y';
				selected_quad_count++;
				if(selected_quad_count >1){
					quad_desc = quad_desc + "," +tooth_num ;
				}
				else{
					quad_desc = tooth_num;
				}
				site_rowchk_quad_val = "QUAD";

				thrng_nos = "";
				thrng_nos_ref = "";
			}
			if (check_count==1){//added by parul on 12/08/2009  tooth and quad checkbox should be not checked at a time
				  if(document.forms[0].UR_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
				}
				else if(document.forms[0].UL_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
				}
				else if(document.forms[0].LR_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
				}
				else if(document.forms[0].LL_quadrant_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
				}
				else{
					obj.checked = true;
					obj.value = 'Y';
				}
			}
		}
	//}
		else{
			selected_site = "";
			quadrantDeSelectedMenuRules(tooth_num)
			obj.value = 'N'

			// Code to remove the tooth number from the range list
			quad_desc_arr=quad_desc.split(",");
			quad_desc="";
			var k = 0;
			for(i=0;i<selected_quad_count;i++){
				if(quad_desc_arr[i]!=tooth_num){
					if(k==0)
						quad_desc = quad_desc_arr[i];
					else
						quad_desc = quad_desc + "," + quad_desc_arr[i];
					k++;
				}
			}
			selected_quad_count--;
			if(selected_quad_count == 0){
				site_rowchk_quad_val = "";
			}
			site_rowchk_quad_val = "QUAD";
		}
	}
	//To set site_type and tooth_no in Tool Header Frame for Image selection recording
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].site_type.value = "QUAD";
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].tooth_no.value = tooth_num;
	
}

function setCheckvalForArch(obj,tooth_num){
	var check_count = 0;
	var quad_check_count = 0;
	var called_from_viewchart_yn_DC_ET = "";
	var header_hid_tab = document.forms[0].header_tab.value;
	var called_from_viewchart_yn  = document.forms[0].called_from_viewchart_yn.value;
	var date_diff_flag  = document.forms[0].date_diff_flag.value;
	var other_facilitychart_yn  = document.forms[0].other_facilitychart_yn.value;

	var called_from_ging_summary = getCalledFromGingSummaryYN();
	var called_from_perio_summary = getCalledFromPerioSummaryYN();
	for(i=1;i<=52;i++){ // This block of code isto get the count of checked CheckBoxes
			if(eval("document.forms[0].selcol"+i) != null){
				if(eval("document.forms[0].selcol"+i).checked){
					check_count++;
			}
		}
	}
	if(header_hid_tab == "C"){ // Disable the checkboxes when record from the RHS menu is selected(For Condition Tab)
			if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined"&&parent.conditionDentalChartDataEntry.qa_query_result!=undefined){
				called_from_viewchart_yn_DC_ET =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_yn.value;

				var called_from_viewchart_yn_GS =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_gingival.value;
	   }
	}
	else{ // Disable the checkboxes when record from the RHS menu is selected(For Treatment Tab)
	       if(parent.trmtDentalChartDataEntry != "undefined" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry.document.forms[0] != "null" && parent.trmtDentalChartDataEntry.document.forms[0] != null){
		     called_from_viewchart_yn_DC_ET =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_yn.value;

			var called_from_viewchart_yn_GS =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_gingival.value;
	      }
	}
	 //Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	//if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" || called_from_viewchart_yn_GS == 'Y' || called_from_ging_summary == "Y" || called_from_perio_summary == "Y"){
	//added by parul  for other facility chart CRF#0423
	if(called_from_viewchart_yn == 'Y' || called_from_viewchart_yn_DC_ET == 'Y' || date_diff_flag == "disable" || called_from_viewchart_yn_GS == 'Y' || called_from_ging_summary == "Y" || called_from_perio_summary == "Y" || other_facilitychart_yn=="Y" || chart_disable_from_main == "Y"){
		obj.checked = false;
		obj.value = 'N';
	}else{
		if(obj.checked == true){
			selected_site = "ARCH";
			if(document.forms[0].lower_arch_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			else if(document.forms[0].upper_arch_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
			}
			// Function to un check the non applicable arch
			archSelectedMenuRules(tooth_num);
			if(document.forms[0].lower_arch_applicable_yn.value == "Y" ){
				obj.checked = true;
				obj.value = 'Y';
				selected_arch_count++;
				if(selected_arch_count >1){
					arch_desc = arch_desc + "," +tooth_num ;
				}
				else{
					arch_desc = tooth_num;
				}
				thrng_nos = "";
				thrng_nos_ref = "";
			}
			else if(document.forms[0].upper_arch_applicable_yn.value == "Y"){
				obj.checked = true;
				obj.value = 'Y';
				selected_arch_count++;
				if(selected_arch_count >1){
					arch_desc = arch_desc + "," +tooth_num ;
				}
				else{
					arch_desc = tooth_num;
				}
				thrng_nos = "";
				thrng_nos_ref = "";
			}
			site_rowchk_arch_val = "ARCH";

			if (check_count==1){//added by parul on 12/08/2009  tooth and arch checkbox should be not checked at a time
				if(document.forms[0].lower_arch_applicable_yn.value == "N"){
				obj.checked = false;
				obj.value = 'N';
				}
				else if(document.forms[0].upper_arch_applicable_yn.value == "N"){
					obj.checked = false;
					obj.value = 'N';
				}
			}
		}
		else{
			selected_site = "";
			archDeSelectedMenuRules(tooth_num);
			obj.value = 'N'

			// Code to remove the tooth number from the range list
			arch_desc_arr=arch_desc.split(",");
			arch_desc="";
			var k = 0;
			for(i=0;i<selected_arch_count;i++){
				if(arch_desc_arr[i]!=tooth_num){
					if(k==0)
						arch_desc = arch_desc_arr[i];
					else
						arch_desc = arch_desc + "," + arch_desc_arr[i];
					k++;
				}
			}
			selected_arch_count--;

			if(selected_arch_count == 0){
				site_rowchk_arch_val = "";
			}
			site_rowchk_arch_val = "ARCH";
		}	
}
	//To set site_type and tooth_no in Tool Header Frame for Image selection recording
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].site_type.value = "ARCH";
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].tooth_no.value = tooth_num;
}

function getTabNames(){
	var header_hid_tab = document.forms[0].header_tab.value;
	if(header_hid_tab == "C"){
		var formObj = parent.conditionDentalChartDataEntry.document.frames[0];
		if(formObj.DentalCondition != null && formObj.DentalCondition != "null" && formObj.DentalCondition != "undefined"){
			if(formObj.DentalCondition.className == "tabClicked"){
				tab_name = "DC";
			}
			else if(formObj.ExtTreatment.className == "tabClicked"){
				tab_name = "ET";
			}
			//Added by Sharon Crasta on 5/21/2009 for IN010748 to disable the menu when clicking on C or ET and then on Gingival.
			else if(formObj.GingivalStatus.className == "tabClicked"){
				tab_name = "";			
			}
			//
		}
	}
	else{
		tab_name = "";
	}
	return tab_name;
}

function onMouseClickFunctionCrown(name,flag,flag1){
	var tooth_no_arr = name.split("#");
	var tooth_no = tooth_no_arr[0];

	window.event.returnValue = false ;
	document.forms[0].teethClickedOn.value = name;
	var header_hid_tab = document.forms[0].header_tab.value;
	var chart_num = document.forms[0].chart_num.value;
	var patient_id = document.forms[0].patient_id.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value;
	var super_tooth_no="";
	var retained_tooth_no="";
	var chart_line_num="";
	var isSuperYN = "N";
	var isRetainedYN = "N";

	if(header_hid_tab == "C"){ // Disable the checkboxes when record from the RHS menu is selected(For Condition Tab)
		if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined"&&parent.conditionDentalChartDataEntry.qa_query_result!=undefined){
			var called_from_viewchart_yn_GS =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_gingival.value;
		}
	}
	else{ // Disable the checkboxes when record from the RHS menu is selected(For Treatment Tab)
		if(parent.trmtDentalChartDataEntry != "undefined" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry.document.forms[0] != "null" && parent.trmtDentalChartDataEntry.document.forms[0] != null){
			var called_from_viewchart_yn_GS =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_gingival.value;
		}
	}

	//if (code_desc_arr[11].length>=2){//added by parul on 08/12/2009 for super change 
		//	isCond_super_tooth_no=flag1.substring(flag1.length-1,flag1.length);
	//}
	getTabNames();

	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	//added by parul on 05/02/2010 for CRF-442
     var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=checkForRTDESTH&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		chart_line_num = trimString(xmlHttp.responseText); 
		chart_line_num = localTrimString(chart_line_num);

	if (chart_line_num>=1 && flag=="MR"){
		flag1="RD";
	}	
	if(flag1!=undefined && flag1!="undefined" && flag1!="RD" && flag1!=""){
		  super_tooth_no=tooth_no+""+flag1.substring(flag1.length-1,flag1.length);
	}
	if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
		   var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_cond = trimString(xmlHttp.responseText); 
			retVal_cond = localTrimString(retVal_cond); 
			var retVal_cond_arr = retVal_cond.split("##");
			var condition_type_ref = retVal_cond_arr[1];
			if(condition_type_ref == "SUPRTH"){
				isSuperYN = "Y";
			}else if(condition_type_ref == "RTDESTH"){
				isRetainedYN = "Y";
			}
			if (isRetainedYN=="Y" && (flag1 != "RD" && (flag1 == "" || flag1 == "undefined" || flag1 == undefined))){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=getMappedToothNo&"+params,false);
				xmlHttp.send(xmlDoc);
				var mapped_tooth_no = trimString(xmlHttp.responseText);
				mapped_tooth_no=localTrimString(mapped_tooth_no);

				var ns_tooth_no = "";
				//To get Display_tooth_no
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+tooth_numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0){
					retained_tooth_no = retVal;
				}

				retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/12/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
			}

	   }else{
			if(flag1 == "RD"){//Added by parul on 12/17/2009 for RTDESTH new changes
			//Added by parul on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retained_tooth_no = trimString(xmlHttp.responseText); 
				retained_tooth_no = localTrimString(retained_tooth_no); 
			}
	   }
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=I";
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurfacePopulation&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_surface = localTrimString(xmlHttp.responseText);
	 if(header_hid_tab=='T'){
		 retVal_surface="";
	 }
	//Added by Sharon Crasta on 3/15/2010 for SRR20056-CRF-0475(IN010868)
	//If the Bridge Treatment is registered in the Trmt Tab, then crown related menu should not be seen
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no+"&treatment_int_ext=I"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getStatusForBridge&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_status_for_bridge = localTrimString(xmlHttp.responseText);
	//End

	if(called_from_viewchart_yn_GS != "Y" && chart_disable_from_main != "Y" ){//End
	//added by parul on 29/01/2010 for CRF-442
	//populateMenuItems('CROWN',flag,tooth_no,flag1);
		// if (retVal_surface!="*A") {
		 //Added by Sharon Crasta on 3/15/2010 for SRR20056-CRF-0475(IN010868)
		 if(retVal_status_for_bridge >= 10){
			 alert(getMessage("APP-OH000180",'OH'));
		 }//End
		 else if (retVal_surface!="*A") {
			populateMenuItems('CROWN',flag,tooth_no,flag1);
		 }else{
			if(header_hid_tab!='T'){
				alert(getMessage("APP-OH000165",'OH'));
			 } 
			 
	   
		 }
	}
	

	//To set site_type and tooth_no in Tool Header Frame for Image selection recording
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].site_type.value = "CROWN";
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].tooth_no.value = tooth_no;
}
function onMouseClickFunctionRoot(name,flag,flag1){
	var tooth_no_arr = name.split("#");
	var tooth_no = tooth_no_arr[0];

	window.event.returnValue = false ;
	document.forms[0].teethClickedOn.value = name;

	var header_hid_tab = document.forms[0].header_tab.value;

	if(header_hid_tab == "C"){ // Disable the checkboxes when record from the RHS menu is selected(For Condition Tab)
	      if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined" && parent.conditionDentalChartDataEntry.qa_query_result!=undefined){
		      var called_from_viewchart_yn_GS =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_gingival.value;
	     }
	}
	else{ // Disable the checkboxes when record from the RHS menu is selected(For Treatment Tab)

	      if(parent.trmtDentalChartDataEntry != "undefined" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry.document.forms[0] != "null" && parent.trmtDentalChartDataEntry.document.forms[0] != null){
		    var called_from_viewchart_yn_GS =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_gingival.value;
	     }
	 }

	getTabNames();
	//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;

	if(called_from_viewchart_yn_GS != "Y" && chart_disable_from_main != "Y"){//End
		populateMenuItems('ROOT',flag,tooth_no,flag1);
	}


	//To set site_type and tooth_no in Tool Header Frame for Image selection recording
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].site_type.value = "ROOT";
	parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].tooth_no.value = tooth_no;
}

function onMouseClickFunctionNumber(name,flag,flag1){ //flag1 added by sridevi jsohi on 12/4/2009 for SUPRTH changes
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	
	var tooth_no_arr = name.split("#");
	var tooth_no = tooth_no_arr[0];
	
	window.event.returnValue = false ;
	formObj.teethClickedOn.value = name;
	var tab_name = getTabNames();
	var count=1;
	thrng_nos="";
	thrng_nos_ref="";
	for(i=1;i<=52;i++){
		if(eval("formObj.selcol"+i)!= null){
			if(eval("formObj.selcol"+i).checked==true){
				if(count==1){
					site_colchk_val = "TOOTH";
					thrng_nos = eval("formObj.selcol_hidden"+i).value;
					thrng_nos_ref = i;
				}
				else {
					if(tab_name == "DC"){
						site_colchk_val = "TOOTH";
					}
					else{
						site_colchk_val = "THRNG";
					}
					thrng_nos = thrng_nos+","+eval("formObj.selcol_hidden"+i).value;
					thrng_nos_ref = thrng_nos_ref+","+i;
				}
				count++;
			}
		}
	}
			
	var quad_check_count=0;

	for(i=1;i<=4;i++){ // This block of code isto get the count of checked CheckBoxes
		if(eval("document.forms[0].sel"+i) != null){
			if(eval("document.forms[0].sel"+i).checked){
				quad_check_count++;
				
			}
		}
	}

	if(count==1){
		if (quad_check_count==0 && (arch_desc=="" || arch_desc==null || arch_desc=="null")){
			site_colchk_val = "TOOTH";
			thrng_nos_arr=name.split("#");
			thrng_nos_ref=thrng_nos_arr[0];
			thrng_nos=thrng_nos_arr[1];

			 if(thrng_nos_ref !=""){
				eval("formObj.selcol"+thrng_nos_ref).checked=true;
			 }
		}else if (arch_desc=="U" || arch_desc=="L" || quad_check_count!=0){
			site_colchk_val = "";
			thrng_nos_arr=name.split("#");
			thrng_nos_ref=thrng_nos_arr[0];
			thrng_nos=thrng_nos_arr[1];
			eval("formObj.selcol"+thrng_nos_ref).checked=false;
		}
	}
	
	name_tooth_no = name;

	
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message

	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	
	refreshCondTreatments(tooth_no,site_colchk_val,flag1,flag);

	if(chart_disable_from_main != "Y"){//End
		populateMenuItems(site_colchk_val,flag,tooth_no,flag1);//flag1 added by sridevi jsohi on 12/4/2009 for SUPRTH changes
	}
}


function onMouseClickFunctionArchQuad(name){
	var formObj = document.forms[0];
	window.event.returnValue = false ;
	name_tooth_no = name;
	getTabNames();
	var count=1;
	var quad_desc_1="";
	var arch_desc_1="";
	var check_count=0;
	var msg = getMessage("APP-OH000112","OH");
	var msg_arr = msg.split("##");
	
	if(name == "U" || name == "L" ){
		if(site_rowchk_arch_val != "undefined" && site_rowchk_arch_val != null && site_rowchk_arch_val != ""){
			arch_quad = arch_desc;
			//Added by Sharon Crasta on 1/11/2010 for IN017822
			//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
			var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;

			if(chart_disable_from_main != "Y"){//End
				populateMenuItems(site_rowchk_arch_val);
			}
		}
	}
	else{
		if(site_rowchk_quad_val != "undefined" && site_rowchk_quad_val != null && site_rowchk_quad_val != ""){
			arch_quad = quad_desc;
			//Added by Sharon Crasta on 1/11/2010 for IN017822
			//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
			var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;

			if(chart_disable_from_main != "Y"){//End
				populateMenuItems(site_rowchk_quad_val);
			}
		}
	}
}

function populateMenuItems(site,flag,tooth_no,flag1){	
	var formObj = document.forms[0];
	site_colchk_val = "";
	var params = "";
	var Disable_menu = "N";
	var header_hid_tab = document.forms[0].header_tab.value;
	var called_from_viewchart_yn_DC_ET = "";
	var called_from_viewchart_yn  = document.forms[0].called_from_viewchart_yn.value;
	var other_facilitychart_yn  = document.forms[0].other_facilitychart_yn.value;
	var oh_chart_level  = document.forms[0].oh_chart_level.value;
	var date_diff_flag  = document.forms[0].date_diff_flag.value;
	var called_from_ging_summary = getCalledFromGingSummaryYN();
	var called_from_perio_summary = getCalledFromPerioSummaryYN();

	if(header_hid_tab == "C"){ // To Disable the menu population when record from the RHS menu is selected(For Condition Tab)
	   if(parent.conditionDentalChartDataEntry.qa_query_result!="undefined"&&parent.conditionDentalChartDataEntry.qa_query_result!=undefined){

			called_from_viewchart_yn_DC_ET =  parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0].called_from_viewchart_yn.value;
	   }
  }
	else{ //  To Disable the menu population when record from the RHS menu is selected(For Treatment Tab)

	     if(parent.trmtDentalChartDataEntry != "undefined" && parent.trmtDentalChartDataEntry != undefined && parent.trmtDentalChartDataEntry.document.forms[0] != "null" && parent.trmtDentalChartDataEntry.document.forms[0] != null){
		   called_from_viewchart_yn_DC_ET =  parent.trmtDentalChartDataEntry.document.forms[0].called_from_viewchart_yn.value;
	    }
	}

	if((site == "ROOT" || site == "CROWN") && (formObj.selL.checked == true || formObj.selU.checked == true || formObj.sel1.checked == true || formObj.sel2.checked==true || formObj.sel3.checked == true || formObj.sel4.checked == true)){ // To Disable the menu population for Root and crown when Arch or Quadrant checkboxes are checked..
		Disable_menu = "Y";
	}
	else{
		Disable_menu = "N";
	}

	var upper_arch_applicable_yn  = formObj.upper_arch_applicable_yn.value;
	var lower_arch_applicable_yn  = formObj.lower_arch_applicable_yn.value;
	var UR_quadrant_applicable_yn = formObj.UR_quadrant_applicable_yn.value;
	var UL_quadrant_applicable_yn = formObj.UL_quadrant_applicable_yn.value;
	var LL_quadrant_applicable_yn = formObj.LL_quadrant_applicable_yn.value;
	var LR_quadrant_applicable_yn = formObj.LR_quadrant_applicable_yn.value;

	//added by parul  for other facility chart CRF#0423
	if(called_from_viewchart_yn != 'Y' && called_from_viewchart_yn_DC_ET != 'Y' && date_diff_flag != "disable" && Disable_menu != "Y" && called_from_ging_summary != "Y" && called_from_perio_summary != "Y" && other_facilitychart_yn!="Y"){
	   	var formObj = document.forms[0];
		// get the Menu Items
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(tab_name != null && tab_name != "null" && tab_name != "" && tab_name != "undefined"){
			params = "func_mode=getMenu&tab_name="+tab_name+"&site="+site;
		}
		else{
			params = "func_mode=getMenu&tab_name="+header_hid_tab+"&site="+site;
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalRules.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
		clearBean();

		// get the list of function_id's (menu_id)
		var function_id_list = formObj.function_id_list.value;
		var function_id_list_array  = function_id_list.split("##"); // the functions are separated by ##
		var menu_id_list = "";
		for (var i=0;i<function_id_list_array.length-1;i++ ){
			if(i==0)
				menu_id_list = function_id_list_array[i];
			else{
				menu_id_list += "~";
				menu_id_list += function_id_list_array[i];
			}
		}

		// get the list of function_names (menu_names)
		var function_name_list = formObj.function_name_list.value;
		var function_name_list_array  = function_name_list.split("##"); // the functions are separated by ##
		var menu_name_list = "";
		for (var i=0;i<function_name_list_array.length-1;i++ ){
			if(i==0)
				menu_name_list = function_name_list_array[i];
			else{
				menu_name_list += "~";
				menu_name_list += function_name_list_array[i];
			}
		}

		// get the list of function_types for each menu
		var function_type_list = formObj.function_type_list.value;
		var function_type_list_array  = function_type_list.split("##"); // the functions are separated by ##
		var menu_type_list = "";
		for (var i=0;i<function_type_list_array.length-1;i++ ){
			if(i==0)
				menu_type_list = function_type_list_array[i];
			else{
				menu_type_list += "~";
				menu_type_list += function_type_list_array[i];
			}
		}

		// get the list of function_types_desc for each menu
		var function_type_desc_list = formObj.function_type_desc_list.value;
		var function_type_desc_list_array  = function_type_desc_list.split("##"); // the functions are separated by ##
		var menu_type_desc_list = "";
		for (var i=0;i<function_type_desc_list_array.length-1;i++ ){
			if(i==0)
				menu_type_desc_list = function_type_desc_list_array[i];
			else{
				menu_type_desc_list += "~";
				menu_type_desc_list += function_type_desc_list_array[i];
			}
		}

		// get the list of function_cat_code for each menu
		var function_cat_code_list = formObj.function_cat_code_list.value;
		var function_cat_code_list_array  = function_cat_code_list.split("##"); // the functions are separated by ##
		var menu_cat_code_list = "";
		for (var i=0;i<function_cat_code_list_array.length-1;i++ ){
			if(i==0)
				menu_cat_code_list = function_cat_code_list_array[i];
			else{
				menu_cat_code_list += "~";
				menu_cat_code_list += function_cat_code_list_array[i];
			}
		}

		// To populate menu only for the tooth number on which the user clicks !
		if(site != null && site != "" && site != "undefined"){
			if(site == "TOOTH" || site == "THRNG"){
				if(name_tooth_no.indexOf('#') != -1){
					name_tooth_no_ref	= name_tooth_no.substring(0,name_tooth_no.indexOf('#')) ;
					name_tooth_no	= name_tooth_no.substring(name_tooth_no.indexOf('#')+1) ;

				}

				if(thrng_nos.indexOf(',') != -1){
					thrng_nos_arr = thrng_nos.split(",");
					for(var k=0;k<thrng_nos_arr.length;k++){
						if(thrng_nos_arr[k] == name_tooth_no){
							var retVal = buildTable(tab_name,site,arch_quad,menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,name_tooth_no_ref,flag,thrng_nos,oh_chart_level,tooth_no,flag1); 

							if(retVal != ""){
								resizeWindow(site);
							}
							break;//Added by Sridevi Joshi on 5/4/2010 for IN021121 and to improve PE also
						}
					}
				}
				else{
					if(thrng_nos == name_tooth_no){
							var retVal = buildTable(tab_name,site,arch_quad,menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,name_tooth_no_ref,flag,thrng_nos,oh_chart_level,tooth_no,flag1); 

							if(retVal != ""){
								resizeWindow(site);
							}
					}
				}
			}
			else if(site == "CROWN" || site == "ROOT"){
				var retVal = buildTable(tab_name,site,arch_quad,menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,tooth_no,flag,"",oh_chart_level,tooth_no,flag1); 
						if(retVal != ""){
							resizeWindow(site);
						}
			}
			else {
				if(arch_quad != "null" && arch_quad != null && arch_quad != "undefined" && arch_quad != undefined && arch_quad.indexOf(',') != -1){
					arch_quad_arr2 = arch_quad.split(",");
					for(var k=0;k<arch_quad_arr2.length;k++){
						if(eval("formObj.sel"+name_tooth_no).checked == true){
							if(arch_quad_arr2[k] == name_tooth_no){
								var retVal = buildTable(tab_name,site,arch_quad_arr2[k],menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,"","","",oh_chart_level,tooth_no);
								if(retVal != ""){
									//Added by Sharon Crasta on 7/16/2009 for IN012454
									resizeWindow(site,arch_quad);
								}
							}
						}
					}
				}
				else{
					if(eval("formObj.sel"+name_tooth_no).checked == true){
						if(arch_quad == name_tooth_no){
							var retVal = buildTable(tab_name,site,arch_quad,menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,"","","",oh_chart_level,tooth_no); 
							if(retVal != ""){
								//Added by Sharon Crasta on 7/16/2009 for IN012454
								resizeWindow(site,arch_quad);
							}
						}
					}
				}
			}
		}
	}
}

function assignFunctionIDList(function_id_list){
	var formObj = document.forms[0];
	formObj.function_id_list.value = function_id_list;
}
function assignFunctionNameList(function_name_list){
	var formObj = document.forms[0];
	formObj.function_name_list.value = function_name_list;
}
function assignFunctionTypeList(function_type_list){
	var formObj = document.forms[0];
	formObj.function_type_list.value = function_type_list;
}
function assignFunctionTypeDescList(function_type_desc_list){
	var formObj = document.forms[0];
	formObj.function_type_desc_list.value = function_type_desc_list;
}
function assignFunctionCatCodeList(function_cat_code_list){
	var formObj = document.forms[0];
	formObj.function_cat_code_list.value = function_cat_code_list;
}


function buildTable(tab_name,site,arch_quad,menu_id_list,menu_name_list,menu_type_list,menu_type_desc_list,menu_cat_code_list,tooth_no,flag,thrng_nos,oh_chart_level,tooth_no,flag1){
	//Added by Sharon Crasta on 5/21/2009 for IN010748 to disable the menu when clicking on C or ET and then on Gingival.
	tab_name = getTabNames();
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var header_tab = document.forms[0].header_tab.value;
	var retained_tooth_no = "";
	var super_tooth_ref = "";

	var retVal_trmt = "";
	var show_menu = "Y";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	if(isNaN(tooth_no) == true){
		tooth_no = "";
	}
	
	menu_id_list		= trimString(menu_id_list);
	menu_name_list		= trimString(menu_name_list);
	menu_type_list	    = trimString(menu_type_list);
	menu_type_desc_list	    = trimString(menu_type_desc_list);
	menu_cat_code_list	    = trimString(menu_cat_code_list);

	//var deciduous_tooth = "";

	var id_rowval		= menu_id_list.split ("~"); // function_id
	var id_name_rowval  = menu_name_list.split ("~"); // function_name
	var id_type_rowval  = menu_type_list.split ("~"); // function_type
	var id_type_desc_rowval  = menu_type_desc_list.split ("~"); // function_type_desc
	var id_cat_code_rowval  = menu_cat_code_list.split ("~"); // function_cat_code

	if(flag1 == "RD"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		retained_tooth_no = trimString(xmlHttp.responseText); 
		retained_tooth_no = localTrimString(retained_tooth_no); 
	}

	if(header_tab == "C" && tab_name == "DC"){
		var applicable_cond_types = id_type_rowval;
		var applicable_cond_desc = id_type_desc_rowval;
		if((thrng_nos != null && thrng_nos != "" && thrng_nos.indexOf(",") == -1) || (site == "ROOT" || site == "CROWN" || site == "ARCH" || site == "QUAD")){ // This code is for single tooth selection 
			//This function is to check the applicable menu options..
			//Added arch_quad by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
			var display_yn = checkApplicableMenuOptions(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,flag,site,thrng_nos_ref,tab_name,flag1,arch_quad);
			//End
			var applicable_yn = display_yn.split("~~");
			var display_menu_yn = applicable_yn[0];
		
			applicable_cond_types = resultMenuOptions(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,tab_name,flag);

			//Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH new changes 
			var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;

			if(flag1 != "" && flag1 != "undefined" && flag1 != undefined){
			   super_tooth_ref = flag1;
			}

			if(flag1 == "RD"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retained_tooth_no = trimString(xmlHttp.responseText); 
				retained_tooth_no = localTrimString(retained_tooth_no); 
			}

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkForExtractionSupernumerary&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			retVal_trmt = trimString(xmlHttp.responseText); 
			retVal_trmt = localTrimString(retVal_trmt);
			
			if(parseInt(retVal_trmt) >= 1){ 
				applicable_cond_types = "";
			}
			/*}
			else {
				var xmlDoc = "" ;	  
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&RD_Normal_yn="+flag+"&isSuperCondYN="+isSuperCondYN+"&isRetndCondYN="+isRetndCondYN+"&header_tab="+header_tab;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retVal_trmt = trimString(xmlHttp.responseText); 
				retVal_trmt = localTrimString(retVal_trmt); 
				
				if(retVal_trmt > 0){ 
					applicable_cond_types = "";
				}
			}*///End
		}
		else if(thrng_nos != null && thrng_nos != "" && thrng_nos.indexOf(",") != -1){ // This code is for multiple tooth selection 
			var nors_arr = thrng_nos_ref.split(",");
			for(j=0;j<nors_arr.length;j++){
				
				//This function is to check the applicable menu options..
				var display_yn = checkApplicableMenuOptions(nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,flag,site,thrng_nos_ref,tab_name,flag1);
				var applicable_yn = display_yn.split("~~")
				var display_menu_yn = applicable_yn[0];
				
				applicable_cond_types = resultMenuOptions(applicable_yn,applicable_cond_types,applicable_cond_desc,nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,tab_name,flag);
				
				//Added by Sharon Crasta on 11/6/2009 for IN016114
				//Added to display the menu on the non-extracted tooth and not to display the menu on the extracted tooth.
				/*var isSuperCondYN = "";
				var isRetndCondYN = "";
				var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_cond = trimString(xmlHttp.responseText); 
				retVal_cond = localTrimString(retVal_cond); 

				var retVal_cond_arr = retVal_cond.split("##");
				var condition_type_ref = retVal_cond_arr[1];
				if(condition_type_ref == "SUPRTH"){
					isSuperCondYN = "Y";
					isRetndCondYN = "N";
				}else if(condition_type_ref == "RTDESTH"){
					isRetndCondYN = "Y";
					isSuperCondYN = "N";
				}
				if(isSuperCondYN == "Y" || isRetndCondYN == "Y"){ */
				//Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH new changes 
				var super_tooth_ref = "";
				var retained_tooth_no = "";

				if(flag1 != "" && flag1 != "undefined" && flag1 != undefined){
				   super_tooth_ref = flag1;
				}

				if(flag1 == "RD"){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retained_tooth_no = trimString(xmlHttp.responseText); 
					retained_tooth_no = localTrimString(retained_tooth_no); 
				}

				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkForExtractionSupernumerary&tooth_no="+nors_arr[j]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&super_tooth_ref="+flag1+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retVal_trmt = trimString(xmlHttp.responseText); 
				retVal_trmt = localTrimString(retVal_trmt); 

				if(parseInt(retVal_trmt) >= 1){ 
					applicable_cond_types = "";
				}
			/*	}
				else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=checkForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&RD_Normal_yn="+flag+"&isSuperCondYN="+isSuperCondYN+"&isRetndCondYN="+isRetndCondYN+"&header_tab="+header_tab;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retVal_trmt = trimString(xmlHttp.responseText); 
					retVal_trmt = localTrimString(retVal_trmt); 

					if(retVal_trmt > 0){ 
						applicable_cond_types = "";
					}
				}*/
			} //End
		}


		
		var count_conds = 0; // This count is to count the conditions available. If this count = 0 then dont show the menu.
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
		for(j=0;j<applicable_cond_types.length;j++){
			if(applicable_cond_types[j] != "undefined" && applicable_cond_types[j] != undefined){
				count_conds++;
				
				tab_dat     += "<tr id ='tooltiprow'>";
				tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id='tooltiplink' href = \"javascript:showMe('','','"+applicable_cond_types[j]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_cond_desc[j] + " </a></td>";
				tab_dat     += "</tr> ";
			  
			}
		}
		tab_dat     += "</table> ";	

		for(z=0;z<applicable_yn.length;z++){
			if(applicable_yn[z] == "missth_applicable" && retVal_trmt >= 1){
				tab_dat = "";
				document.getElementById("menu_table").innerHTML = tab_dat;
				
			}else if(applicable_yn[z] == "missth_applicable" && retVal_trmt == 0){//added by parul if we recorded only missing condition on 05/01/2010
				tab_dat = "";
				document.getElementById("menu_table").innerHTML = tab_dat;
				
			}
			else if((applicable_yn[z] == "parer_er_applicable" && mixed_dentition_YN == "N" && display_menu_yn == "N") || (count_conds == "0")){
				tab_dat = "";
				document.getElementById("menu_table").innerHTML = tab_dat;
			}
			else if((applicable_yn[z] == "parer_er_applicable" && display_menu_yn == "N") || (count_conds == "0")){
			
				tab_dat = "";
				document.getElementById("menu_table").innerHTML = tab_dat;
			}
			else{
				document.getElementById("menu_table").innerHTML = tab_dat;
			}

		}
	}
	else if(header_tab == "T" || (header_tab == "C" && tab_name == "ET")){
		var applicable_trmt_types = id_type_rowval;
		var applicable_trmt_desc = id_type_desc_rowval;

		if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
			if(flag1 != "RD"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retained_tooth_no = trimString(xmlHttp.responseText); 
				retained_tooth_no = localTrimString(retained_tooth_no); 
			}
		}
		else{
			if(flag1 == "RD"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				retained_tooth_no = trimString(xmlHttp.responseText); 
				retained_tooth_no = localTrimString(retained_tooth_no); 
			}
		}

		if((site == "TOOTH" && thrng_nos.indexOf(",") == -1) || (site == "ROOT" || site == "CROWN" || site == "ARCH" || site == "QUAD")){ // This code is for single tooth selection
			//This function is to check the applicable menu options..
			var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,flag,site,thrng_nos_ref,'','','','',flag1,retained_tooth_no);
			//Added arch_quad,site by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
			applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,arch_quad,site);
			//End
			//Added by Sharon Crasta on 11/6/2009 for IN016114
			//Added to display the menu on the non-extracted tooth and not to display the menu on the extracted tooth.
			var isSuperCondYN = "";
			var isRetndCondYN = "";			
			if(header_tab == "C" && tab_name == "ET"){
				var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_cond = trimString(xmlHttp.responseText); 
				retVal_cond = localTrimString(retVal_cond); 
				
				var retVal_cond_arr = retVal_cond.split("##");
				var condition_type_ref = retVal_cond_arr[1];
				if(condition_type_ref == "SUPRTH"){
					isSuperCondYN = "Y";
					isRetndCondYN = "N";
				}else if(condition_type_ref == "RTDESTH"){
					isRetndCondYN = "Y";
					isSuperCondYN = "N";
				}
				if(isSuperCondYN == "Y" || isRetndCondYN == "Y"){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();

					params = "func_mode=checkForExtractionSupernumerary&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&super_tooth_ref="+flag1+"&isSuperCondYN="+isSuperCondYN+"&isRetndCondYN="+isRetndCondYN+"&header_tab="+header_tab+"&retained_tooth_no="+retained_tooth_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					retVal_trmt = trimString(xmlHttp.responseText); 
					retVal_trmt = localTrimString(retVal_trmt);		
					if(retVal_trmt >= 1 && (site == "CROWN" || site == "ROOT")){ //The site is added because as of now when exfoliated the primary tooth in case of Supernumerary Tooth and treament order placed on the super tooth, the supernumerary tooth is not replaced by the missing tooth. so to hide the menu from the root and crown.
					 applicable_trmt_types = "";
					}
				}
			}//End	  
		}
		else if(thrng_nos != null && thrng_nos != "" && thrng_nos.indexOf(",") != -1){ // This code is for multiple tooth selection 
			var nors_arr = thrng_nos_ref.split(",");
			// Added flag_not_consecutive by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868) for Bridge Trmt to check if consecutive tooth are selected.
			var flag_not_consecutive = false;
			var nos_length = nors_arr.length;
					
			for(j=0;j<nors_arr.length;j++){

			   var tooth1 = parseInt(nors_arr[j]);
				var tooth2 = parseInt(nors_arr[j+1]);
				var tooth_add = parseInt(tooth1 + 1);
				
				if(nors_arr[j+1] != "" && nors_arr[j+1] != "undefined" && nors_arr[j+1] != "null" && nors_arr[j+1] != null && nors_arr[j+1] <= nors_arr[nos_length-1]){
					//if(parseInt(nors_arr[j+1]) != ((parseInt(nors_arr[j]) + 1))) {
					if(tooth_add != tooth2) {
					   flag_not_consecutive = true;
					}
				}//End
				
				var len = nors_arr.length;
				var no_of_tooth = parseInt(nors_arr[len-1])-parseInt(nors_arr[0])-1;
				//This function is to check the applicable menu options..
				var applicable_trmt_types_arr = applicableTrmtMenuOptions(applicable_trmt_types,nors_arr[j],patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,flag,site,thrng_nos_ref,j,nors_arr.length-1,no_of_tooth,'',flag1,retained_tooth_no,flag_not_consecutive); 
				applicable_trmt_types = resultTrmtMenuOptions(applicable_trmt_types_arr,applicable_trmt_desc,nors_arr[j],mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,arch_quad,site);

				//Added by Sharon Crasta on 11/6/2009 for IN016114
				//Added to display the menu on the non-extracted tooth and not to display the menu on the extracted tooth.
				var isSuperCondYN = "";
				var isRetndCondYN = "";
				var retVal_trmt = "";
				if(header_tab == "C" && tab_name == "ET"){
					var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_cond = trimString(xmlHttp.responseText); 
					retVal_cond = localTrimString(retVal_cond); 
					
					var retVal_cond_arr = retVal_cond.split("##");
					var condition_type_ref = retVal_cond_arr[1];
					if(condition_type_ref == "SUPRTH"){
						isSuperCondYN = "Y";
						isRetndCondYN = "N";
					}else if(condition_type_ref == "RTDESTH"){
						isRetndCondYN = "Y";
						isSuperCondYN = "N";
					}

					if(isSuperCondYN == "Y" || isRetndCondYN == "Y"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkForExtractionSupernumerary&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&super_tooth_ref="+flag1+"&isSuperCondYN="+isSuperCondYN+"&isRetndCondYN="+isRetndCondYN+"&header_tab="+header_tab+"&retained_tooth_no="+retained_tooth_no;
					
							
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						retVal_trmt = trimString(xmlHttp.responseText); 
						retVal_trmt = localTrimString(retVal_trmt);
					}
				}//End 
			}
		}
		var count_trmts = 0; // This count is to count the conditions available. If this count = 0 then dont show the menu.
		//var check_cat_type = ""; //Added by Sridevi Jsohi on 2/12/2010 for IN010871(SRR20056-CRF-0478)
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
		for(p=0;p<applicable_trmt_types.length;p++){
			if(applicable_trmt_types[p] != "undefined" && applicable_trmt_types[p] != undefined && applicable_trmt_types[p] != ""){
				//Commented and Added by Sharon Crasta on 12/2/2009 for IN016794
				//Added because once the tooth is missing in case a trmt order is placed, the menu getting displayed was Extraction, TOOTHTM and IMPLANT. Only IMPLANT should be displayed.
				//count_trmts++;
				if(retVal_trmt >= 1) {
					if(applicable_trmt_types[p] == "IMPLANT"){
						count_trmts++;
						tab_dat     += "<tr id ='tooltiprow'>";
						tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
						tab_dat     += "</tr> ";
					} 
					else{
						if(mixed_dentition_YN == "Y" || (mixed_dentition_YN == "N" && permanent_deciduous_flag == "D" )) {
							count_trmts = 0; // Added by Sharon Crasta on 11/30/2009 for IN016114. Added because the empty table was getting displayed on the extracted tooth(No menu hould be displayed in case of charts other than permanent)
						}
					}
				}else{//End
					
				/*	if(applicable_trmt_types[p] == "DENTURE"){ //Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=DENTURE&header_tab="+header_tab;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_trmt1 = trimString(xmlHttp.responseText); 
						retVal_trmt1 = localTrimString(retVal_trmt1); 

						if(retVal_trmt1.length > 1){
							var retVal_trmt1_arr = retVal_trmt1.split("~");
							for(var h=0;h<retVal_trmt1_arr.length-1;h++){
								var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
								var denture_removable = rec_trmt_arr[1];
								var treatments_outcome = rec_trmt_arr[2];

								if(treatments_outcome == "S" && denture_removable != "Y"){
									show_menu = "N"; 
									break;
								}
							}
						}

						if(retVal_trmt1.length > 1){
							var retVal_trmt1_arr = retVal_trmt1.split("~");
							for(var h=0;h<retVal_trmt1_arr.length-1;h++){
								var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
								var denture_removable = rec_trmt_arr[1];
								var treatments_outcome = rec_trmt_arr[2];

								if((denture_removable == "Y" || treatments_outcome == "F") && show_menu == "Y"){
									count_trmts++;
									tab_dat     += "<tr id ='tooltiprow'>";
									tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
									tab_dat     += "</tr> ";
									break;
								}
							}
						}
						else{
							count_trmts++;
							tab_dat     += "<tr id ='tooltiprow'>";
							tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
							tab_dat     += "</tr> ";
						}
					}*/
				//	if(applicable_trmt_types[p] == "DENTURE"){ //Added by Sridevi joshi on 2/11/2010 for IN010871(SRR20056-CRF-0478)
						//if((site == "TOOTH" && thrng_nos.indexOf(",") == -1) || (site == "ROOT" || site == "CROWN" || site == "ARCH" || site == "QUAD")){ // This code is for single tooth selection-- added by Sridevi Joshi on 2/21/2010 for IN010871(SRR20056-CRF-0478)

						

						var retVal_trmt1="";
						if((site == "TOOTH" && thrng_nos.indexOf(",") == -1) || (site == "ARCH" || site == "QUAD" || site == "MAXFS")){ // This code is for single tooth selection-- added by Sridevi Joshi on 2/21/2010 for IN010871(SRR20056-CRF-0478)
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type="+applicable_trmt_types[p]+"&header_tab="+header_tab+"&arch_quad="+arch_quad+"&site="+site+"&super_tooth_ref="+flag1+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_trmt1 = trimString(xmlHttp.responseText); 
							retVal_trmt1 = localTrimString(retVal_trmt1); 
							if(retVal_trmt1.length > 1){
								var retVal_trmt1_arr = retVal_trmt1.split("~");
								for(var h=0;h<retVal_trmt1_arr.length-1;h++){
									var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
									var denture_removable = rec_trmt_arr[1];
									var trmt_outcome = rec_trmt_arr[2];
									var treatments_status = rec_trmt_arr[5];

									if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
										var tooth_chart_arr = tooth_range.split(",");
										for(var g=0;g<tooth_chart_arr.length;g++){
											var tooth_range_arr = tooth_chart_arr[g].split("$$");
											if(thrng_val == ""){
												thrng_val = tooth_range_arr[1];
											}
											else{
												thrng_val = thrng_val+","+tooth_range_arr[1];
											}
										}
									}
									else{
										thrng_val = tooth_no;
										
									}
									
									if(applicable_trmt_types[p] == "DENTURE"){
										if(parseInt(treatments_status) < 25){ //Addded by Sridevi Joshi on 3/10/2010 for IN019920
											show_menu = "N"; 
										}
										else if(trmt_outcome != "F" && denture_removable != "Y" ){
											show_menu = "N"; //If Denture is not recorded on any one of the tooth in case of range
											break;
										}
										else{
											show_menu = "Y";//Added by Sridevi Joshi on 3/30/2010 for IN020407
										}
									}else{//added by parul on 27/02/2010 for CRF-477
									   if(trmt_outcome != "F"){
										   show_menu = "N"; 
											break;
									   }
									   else{
											show_menu = "Y";//Added by Sridevi Joshi on 3/30/2010 for IN020407
										}
									}
								}
							}

							if(retVal_trmt1.length > 1){
									var retVal_trmt1_arr = retVal_trmt1.split("~");
									for(var h=0;h<retVal_trmt1_arr.length-1;h++){
										var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
										var denture_removable = rec_trmt_arr[1];
										var treatments_outcome = rec_trmt_arr[2];
										var treatments_status = rec_trmt_arr[5];
										var trmt_cond = rec_trmt_arr[6];
										var treatment_int_ext = rec_trmt_arr[7];
										
										if((denture_removable == "Y" || treatments_outcome == "F") && show_menu == "Y" && applicable_trmt_types[p] == "DENTURE"){
											
											if(header_tab == "T" && trmt_cond == "T" && treatment_int_ext == "I"){ //only for treatments tab by Sridevi Joshi
												if(parseInt(treatments_status) >= 25 && ((treatments_outcome == "F" && denture_removable != "Y") || denture_removable == "Y")){
													count_trmts++;
													tab_dat     += "<tr id ='tooltiprow'>";
													tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
													tab_dat     += "</tr> ";
													break; //commented by SRidevi Joshi
												
												}
											}
											else{ //only for conditions tab by Sridevi Joshi
												count_trmts++;
												tab_dat     += "<tr id ='tooltiprow'>";
												tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
												tab_dat     += "</tr> ";
												break;
												
											}
										}else{//else part added by parul on 12/02/2010 for CRf -477 & 496
											if(show_menu != "N"){
												count_trmts++;
												tab_dat     += "<tr id ='tooltiprow'>";
												tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
												tab_dat     += "</tr> ";
												break;
											}
										}
									}
								}
								else{
									count_trmts++;
									tab_dat     += "<tr id ='tooltiprow'>";
									tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
									tab_dat     += "</tr> ";
								}
							/*else{//Added by Sridevi Joshi on 3/19/2010 for IN020148
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkCondTrmtRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&arch_quad="+tooth_no+"&site="+site+"&header_tab="+header_tab+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_trmt2 = trimString(xmlHttp.responseText); 
								retVal_trmt2 = localTrimString(retVal_trmt2);
								if(retVal_trmt2.length>1){
									var retVal_trmt2_arr = retVal_trmt2.split("~");
									for(var m=0;m<retVal_trmt2_arr.length-1;m++){
										var code_trmt_arr = retVal_trmt2_arr[m].split("##");
										//if(code_trmt_arr[6]=="THRNG" || code_trmt_arr[6]=="TOOTH" || code_trmt_arr[6] == "ARCH" || code_trmt_arr[6] == "QUAD"){ // Addded by Sridevi Joshi on 3/18/2010
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
							
											params = "func_mode=checkForTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&trmt_category_type="+code_trmt_arr[4]+"&other_chart_facility_id="+other_chart_facility_id+"&header_tab="+header_tab+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;

											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
											xmlHttp.send(xmlDoc);
											var retVal_trmt1 = trimString(xmlHttp.responseText); 

											retVal_trmt1 = localTrimString(retVal_trmt1);
											var retVal_trmt1_arr = retVal_trmt1.split("~");
											for(var h=0;h<retVal_trmt1_arr.length-1;h++){
												var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
												var denture_removable = rec_trmt_arr[1];
												var treatments_outcome_ext = rec_trmt_arr[2];
												var treatments_status = rec_trmt_arr[5];

												if(parseInt(treatments_status) < 25){
													show_menu = "N"; 
													break;
												}
											}
										//}
									}
								}
							} */
						}
						else if(thrng_nos != null && thrng_nos != "" && thrng_nos.indexOf(",") != -1){ // This code is for multiple tooth selection 
						    var display_menu="N";
							var nors_arr = thrng_nos_ref.split(",");
							for(var d=0;d<nors_arr.length;d++){
								//check_cat_type = populateConditionCode(formObj.oh_category,formObj.oh_treatment);
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=checkForTreatments&tooth_no="+nors_arr[d]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type="+applicable_trmt_types[p]+"&header_tab="+header_tab+"&super_tooth_ref="+flag1+"&retained_tooth_no="+retained_tooth_no+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_trmt1 = trimString(xmlHttp.responseText); 
								retVal_trmt1 = localTrimString(retVal_trmt1); 
								if(retVal_trmt1.length > 1){
									var retVal_trmt1_arr = retVal_trmt1.split("~");
									for(var h=0;h<retVal_trmt1_arr.length-1;h++){
										var thrng_val = "";
										var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
										var denture_removable = rec_trmt_arr[1];
										var trmt_outcome = rec_trmt_arr[2];
										var tooth_range = rec_trmt_arr[4];
										var treatments_status = rec_trmt_arr[5];
										if(tooth_range != "" && tooth_range != "null" && tooth_range != null){
											var tooth_chart_arr = tooth_range.split(",");
											for(var g=0;g<tooth_chart_arr.length;g++){
												var tooth_range_arr = tooth_chart_arr[g].split("$$");
												if(thrng_val == ""){					
													thrng_val = tooth_range_arr[1];
												}
												else{
													thrng_val = thrng_val+","+tooth_range_arr[1];
												}
												
											}
											if(applicable_trmt_types[p] == "DENTURE"){//Added by Sridevi Joshi on 3/4/2010 for CRF-478
												if(parseInt(treatments_status) < 25){//Addded by Sridevi Joshi on 3/10/2010 for IN019920
													show_menu = "N"; 
												}
												else if(thrng_val != nors_arr && trmt_outcome != "F" ){
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else if(thrng_val == nors_arr && trmt_outcome != "F" && denture_removable != "Y"){ // denture_removable is added by Sridevi Joshi on 3/4/2010 for CRF-478
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else{
													show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
												}
											}
											else{
												/*if(thrng_val != nors_arr && trmt_outcome != "F" ){
													//show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}*/
												//else if(thrng_val == nors_arr && trmt_outcome != "F" ){
												if(trmt_outcome != "F" ){
													show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
												}
												else{
													show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
												}
											}
										}
										else{
											thrng_val = nors_arr;
											if(trmt_outcome != "F"){
												show_menu = "N"; //If Denture is recorded on any one of the tooth in case of range
											}
											else{
												show_menu = "Y"; //If Denture is recorded on any one of the tooth in case of range
											}
										}										
									}
									break;//parul on 13/04/2010 for IN20573
								}
								else{
									show_menu = "N"; //If Denture is not recorded on any one of the tooth in case of range
								}
							}
								if(retVal_trmt1.length > 1){
									var retVal_trmt1_arr = retVal_trmt1.split("~");
									for(var h=0;h<retVal_trmt1_arr.length-1;h++){
										var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
										var denture_removable = rec_trmt_arr[1];
										var treatments_outcome = rec_trmt_arr[2];
										var treatments_status = rec_trmt_arr[5];
										var trmt_cond = rec_trmt_arr[6];
										var treatment_int_ext = rec_trmt_arr[7];
										
										if((denture_removable == "Y" || treatments_outcome == "F") && show_menu == "Y" && applicable_trmt_types[p] == "DENTURE"){
											
											if(header_tab == "T" && trmt_cond == "T" && treatment_int_ext == "I"){ //only for treatments tab by Sridevi Joshi
												if(parseInt(treatments_status) >= 25 && ((treatments_outcome == "F" && denture_removable != "Y") || denture_removable == "Y")){
													count_trmts++;
													display_menu="Y";
													break; //commented by SRidevi Joshi
												
												}
											}
											else{ //only for conditions tab by Sridevi Joshi
												count_trmts++;
												display_menu="Y";
												break;
												
											}
										}else{//else part added by parul on 12/02/2010 for CRf -477 & 496
											if(show_menu != "N"){
												count_trmts++;
												display_menu="Y";
												break;
											}
										}
									}							
								}
								else{
									count_trmts++;
									display_menu="Y";

								}
							if (	display_menu=="Y"){
								tab_dat     += "<tr id ='tooltiprow'>";
								tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
								tab_dat     += "</tr> ";
							}

						}else{
							//added by parul on 14/04/2010 for 20693 (not getting menu on root and crown for Treatment and external treatment)
							count_trmts++;
							tab_dat     += "<tr id ='tooltiprow'>";
							tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
							tab_dat     += "</tr> ";
						}
                     //commented by parul on 13/04/2010 for IN20573 ,written sepretly on tooth blk and tooth range blk
						/*if(retVal_trmt1.length > 1){
							var retVal_trmt1_arr = retVal_trmt1.split("~");
							for(var h=0;h<retVal_trmt1_arr.length-1;h++){
								var rec_trmt_arr = retVal_trmt1_arr[h].split("##");
								var denture_removable = rec_trmt_arr[1];
								var treatments_outcome = rec_trmt_arr[2];
								var treatments_status = rec_trmt_arr[5];
								var trmt_cond = rec_trmt_arr[6];
								var treatment_int_ext = rec_trmt_arr[7];
								
								if((denture_removable == "Y" || treatments_outcome == "F") && show_menu == "Y" && applicable_trmt_types[p] == "DENTURE"){
									
									if(header_tab == "T" && trmt_cond == "T" && treatment_int_ext == "I"){ //only for treatments tab by Sridevi Joshi
										if(parseInt(treatments_status) >= 25 && ((treatments_outcome == "F" && denture_removable != "Y") || denture_removable == "Y")){
											count_trmts++;
											tab_dat     += "<tr id ='tooltiprow'>";
											tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
											tab_dat     += "</tr> ";
											break; //commented by SRidevi Joshi
										
										}
									}
									else{ //only for conditions tab by Sridevi Joshi
										count_trmts++;
										tab_dat     += "<tr id ='tooltiprow'>";
										tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
										tab_dat     += "</tr> ";
										break;
										
									}
								}else{//else part added by parul on 12/02/2010 for CRf -477 & 496
								    if(show_menu != "N"){
										count_trmts++;
										tab_dat     += "<tr id ='tooltiprow'>";
										tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
										tab_dat     += "</tr> ";
										break;
									}
								}
							}
						}
						else{
							count_trmts++;
							tab_dat     += "<tr id ='tooltiprow'>";
							tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id ='tooltiplink' href = \"javascript:showMe('','','"+applicable_trmt_types[p]+"','','" +tab_name+"','"+site+"','"+arch_quad+"','"+thrng_nos+"','"+thrng_nos_ref+"','"+flag+"','"+selected_first_thno+"','"+oh_chart_level+"','"+flag1+"');\"> "+applicable_trmt_desc[p] + " </a></td>";
							tab_dat     += "</tr> ";
						}*/
					}
				}
			}
		tab_dat     += "</table> ";	
		if(count_trmts > 0){
			document.getElementById("menu_table").innerHTML = tab_dat;
		}
		else{
			tab_dat = "";
			document.getElementById("menu_table").innerHTML = tab_dat;
		}
	}
	else{//Added by Sharon Crasta on 5/21/2009 for IN010748 to disable the menu when clicking on C or ET and then on Gingival.
		tab_dat = "";
	}

	return tab_dat;
}

//Commented and added by Sharon Crasta on 7/16/2009 for IN012454
//function resizeWindow(site){
function resizeWindow(site,arch_quad){
	if(site=="CROWN" || site=="ROOT"){
		window.pageX = window.event.pageX | window.event.clientX;
		window.pageY = window.event.pageY |  window.event.clientY;

		var x =window.pageX + document.body.scrollLeft
		var y = window.pageY + document.body.scrollTop
		if(window.pageX > 750){
			x = x - 150
		}
		else if(window.pageX > 642 && window.pageX < 750){ //Added on 05MAR2008
			x = x - 150
		}
			
		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible'
	}else{
		bodwidth = parent.frames[1].document.body.offsetWidth
		bodheight = parent.frames[1].document.body.offsetHeight

		var x =  event.x;
		var y =  event.y;

		x = x + (document.getElementById("tooltiplayer").offsetWidth)
		y = y + (document.getElementById("tooltiplayer").offsetHeight)

		if(x<bodwidth)
			x =event.x
		else
			x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

		if(y<bodheight || event.y<150){
			if(event.y<150){
			  y =event.y-20
			}else if(event.y> 230){
			  y =event.y-20
			}
		}else{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
		}
		

		//Added by Sharon Crasta on 7/16/2009 for IN012454
		if((site=="QUAD") && (arch_quad == "1" || arch_quad == "2")){
		 	y = event.y + 5;
		}

		if(site == "ARCH" && arch_quad == "U"){
			y = event.y + 5;		 
		}

		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
			
		document.getElementById("tooltiplayer").style.visibility='visible'
	}
}

function resizeWindow1(site,arch_quad){
	if(site=="CROWN" || site=="ROOT"){
		window.pageX = window.event.pageX | window.event.clientX;
		window.pageY = window.event.pageY |  window.event.clientY;

		var x =window.pageX + document.body.scrollLeft
		var y = window.pageY + document.body.scrollTop
		if(window.pageX > 750){
			x = x - 150
		}
		else if(window.pageX > 642 && window.pageX < 750){ //Added on 05MAR2008
			x = x - 150
		}
			
		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible'
	}else{
		//x="217";
		//y="120";
		x = document.getElementById("tooltiplayer1").offsetWidth
		y = document.getElementById("tooltiplayer1").offsetHeight


			x=x+document.getElementById("tooltiptable_rec").offsetWidth+40;
			y=y+170

		document.getElementById("tooltiplayer").style.visibility='visible'
		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
	}
}

function clearBean(){
	var dummy="dummy";
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" dummy=\""+ dummy + "\" ";
	xmlStr +=" /></root>";
	return fieldValidation(xmlStr,"clearBean");
}

function fieldValidation(xmlStr,source){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalRules.jsp?func_mode="+source,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(trimString(responseText));
    return true;
}

function showMe(code,name,type,cat_code,tab_name,site,arch_quad,thrng_nos,thrng_nos_ref,flag,selected_first_thno,oh_chart_level,flag1){
	var formObj = document.dentalChartMainForm;
	var messageFrame = parent.parent.parent.parent.messageFrame;
	var header_tab = formObj.header_tab.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var chart_type = formObj.chart_type.value;
	var chart_num = formObj.chart_num.value;
	var show_new_active_yn = formObj.show_new_active_yn.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;

	var episode_id = formObj.episode_id.value;
	var episode_type = formObj.episode_type.value;
	var visit_id = formObj.visit_id.value;
	var location_code = formObj.location_code.value;
	var location_type = formObj.location_type.value;

	var params;
	var url;
	var ref_tooth_no;
	var toothClickedOn=document.forms[0].teethClickedOn.value ;
	if( toothClickedOn.indexOf('#') != -1 ){
		ref_tooth_no = toothClickedOn.substring(0,toothClickedOn.indexOf('#'));
		toothNumber	= toothClickedOn.substring(toothClickedOn.indexOf('#')+1) ;
	}	
	else{ 
		toothNumber	= toothClickedOn;
	}
	params = "patient_id="+patient_id+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&ToothNumber="+toothNumber+"&ref_tooth_no="+ref_tooth_no+"&code="+code+"&site="+site+"&type="+type+"&arch_quad="+arch_quad+"&thrng_nos="+thrng_nos+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&patient_class="+patient_class+"&chart_type="+chart_type+"&chart_num="+chart_num+"&header_tab="+header_tab+"&show_new_active_yn="+show_new_active_yn+"&thrng_nos_ref="+thrng_nos_ref+"&cat_code="+cat_code+"&flag="+flag+"&selected_first_thno="+selected_first_thno+"&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_id="+visit_id+"&location_code="+location_code+"&location_type="+location_type+"&mixed_dentition_YN="+mixed_dentition_YN+"&oh_chart_level="+oh_chart_level+"&flag1="+flag1;


	if(tab_name == "DC"){
		url = "../../eOH/jsp/DentalCondition.jsp?";
	}
	else if(tab_name == "ET"){
		
		url = "../../eOH/jsp/DentalExtTreatment.jsp?";
	}
	if(header_tab == "C"){
		parent.conditionDentalChartDataEntry.document.frames[1].location.href=url+params; 
	}
	else{
		params = params+"&treatment_status=PLAN";
		url = "../../eOH/jsp/DentalTreatment.jsp?";
		parent.trmtDentalChartDataEntry.document.location.href=url+params; 
	}

	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;

}

async function getDialogFeaturesForNoImage(tooth_no,display_tooth_no,site_type){

	var chart_num = document.forms[0].chart_num.value;
	var patient_id = document.forms[0].patient_id.value;
	var title_desc = "";
	var site_type = site_type;
	var tooth_no = tooth_no;
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
    var decith_recorded="N";


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "site_type="+site_type+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateQuadArchDesc&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	if(retVal.length > 1){
		title_desc = encodeURIComponent(retVal)
	}
	
    //decith_recorded is used for checking the decith condition is recorded on tooth or not.added by parul for super changes
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithCondition&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_decith = trimString(xmlHttp.responseText);
	if(retVal_decith.length > 1){
		var retVal_arr = retVal_decith.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "DECITH" || code_desc_arr[0] =="PARERTH"){
				decith_recorded="Y";
			}
		}
	}
	var exfolth_count=0;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_exfo = trimString(xmlHttp.responseText);
	retVal_exfo = localTrimString(retVal_exfo);
	
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var chart_num = document.forms[0].chart_num.value;
	var treatment_condition_tab_flag = document.forms[0].header_tab.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var baseline_chart_yn = document.forms[0].baseline_chart_yn.value;
	var patient_class = document.forms[0].patient_class.value;
	
	var params = '&patient_id='+patient_id+'&treatment_condition_tab_flag='+treatment_condition_tab_flag+'&tooth_no='+tooth_no+'&title_desc='+title_desc+"&display_tooth_no="+display_tooth_no+"&called_from_viewchart_yn="+called_from_viewchart_yn+"&chart_num="+chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&site_type="+site_type+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&retVal_exfo="+retVal_exfo+"&decith_recorded="+decith_recorded+"&baseline_chart_yn="+baseline_chart_yn+"&patient_class="+patient_class;
	var url	= "../../eOH/jsp/showAllImages.jsp?"+params;
	
	var dialogHeight= "40vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop ="170";
	var dialogLeft ="10";  	
 		
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
}

//function getDialogFeatures(site_type,patient_id,tooth_no,display_tooth_no,tab_name){
async function getDialogFeatures(site_type,patient_id,tooth_no,display_tooth_no,tab_name,permanentdeciduous_flag,numbering_system,super_retained_flag){

	var title_desc = "";
	var decith_recorded = "N";
	var site_type = site_type;
	var tooth_no = tooth_no;
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var chart_num=document.forms[0].chart_num.value;
	var baseline_chart_yn=document.forms[0].baseline_chart_yn.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "site_type="+site_type+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateQuadArchDesc&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	if(retVal.length > 1){
		title_desc = encodeURIComponent(retVal)
	}
	//decith_recorded is used for checking the decith condition is recorded on tooth or not.added by parul for super changes
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&site_type="+site_type+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithCondition&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_decith = trimString(xmlHttp.responseText);
	if(retVal_decith.length > 1){
		var retVal_arr = retVal_decith.split("~");
		for(var i=0;i<retVal_arr.length;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "DECITH" || code_desc_arr[0] =="PARERTH"){
				decith_recorded="Y";
			}
		}
	}
	var exfolth_count=0;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_exfo = trimString(xmlHttp.responseText);
	retVal_exfo = localTrimString(retVal_exfo);
	//end 
	//Mark error any condition on tooth on which only one condition is recorded (display_tooth_no is null in this case)....
	if(display_tooth_no == "" || display_tooth_no == "null" || display_tooth_no == null){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "mixed_dentition_YN="+mixed_dentition_YN+"&tooth_no="+tooth_no+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText); 
		if(retVal.length > 0){
			display_tooth_no = retVal;
		}
	}
	
	var called_from_viewchart_yn = document.forms[0].called_from_viewchart_yn.value;
	var chart_num = document.forms[0].chart_num.value;
	var treatment_condition_tab_flag = document.forms[0].header_tab.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var baseline_chart_yn=document.forms[0].baseline_chart_yn.value;
	var patient_class = document.forms[0].patient_class.value;

	

	var params = 'site_type='+site_type+'&patient_id='+patient_id+'&treatment_condition_tab_flag='+treatment_condition_tab_flag+'&tooth_no='+tooth_no+'&title_desc='+title_desc+"&display_tooth_no="+display_tooth_no+"&called_from_viewchart_yn="+called_from_viewchart_yn+"&chart_num="+chart_num+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&super_retained_flag="+super_retained_flag+"&decith_recorded="+decith_recorded+"&exfolth_count="+retVal_exfo+"&baseline_chart_yn="+baseline_chart_yn+"&patient_class="+patient_class;
	var url	= "../../eOH/jsp/showAllImages.jsp?"+params;
	
	var dialogHeight= "35vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop ="170";
	var dialogLeft ="10";  
	
	var status = "no";
	var arguments	= "" ;

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	
	await window.showModalDialog(url,arguments,features);

}  

function imageReplacementForCond(condition_type,tooth_no,status,show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,formObj,super_key_num,image_source,treatment_int_ext,trmt_outcome){
	
	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var header_tab = document.forms[0].header_tab.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var status_int = parseInt(status); //Removed from EXTRACT block and added here by Sridevi Joshi on 24/22/09 for IN016115
	var mixed_dent_tooth_no = "";

	var isSuperCondYN = "";
	var isRetndCondYN = "";
	var isDeciCondYN = "";
	 var tooth_sn = tooth_no;
	 var count=0;
	 var super_yn = "";
	 var RD_yn = "";

	//To retrieve the display tooth_no and the tooth_name...
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 1){
		var retVal_arr = retVal.split("##");
		tooth_num = retVal_arr[0];
		tooth_name = retVal_arr[1];
		mapped_tooth_no = retVal_arr[2];
		mixed_dent_tooth_no = retVal_arr[3];
	}

	//Added by Sridevi Joshi for IN016115 on 24/11/09
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 1){
		var retVal_arr = retVal.split("##");
		super_yn = retVal_arr[0];			
		RD_yn  = retVal_arr[1];			
	}

	//added by parul on 251108 for SCR-6103
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type="+condition_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 0 && parseInt(retVal) > 0){ 
		var retVal_arr = retVal.split("##");
		count = retVal_arr[0];			
	}

	//var formObj = document.forms[0];
	if(condition_type == "MISSTH"){
		var imageId = "T"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";  
	}
	else if(condition_type == "UNERTH"){
		//When recording REtained Deciduous in Permanent Chart, dont show Root and Crown images.
		var imageId = "T"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
	}
	else if(condition_type=="IMPACTN"){
		if(!isPartiallyErupted){//Added by Sridevi Joshi on 12/17/2009 for IN017296 to show Crown image after recording imaction on PARERTH
			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

			var imageId = "R"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
		}
	}
	else if(condition_type == "EXFOLTH"){
		//commeted by parul script error on 01/02/2010
		var exfolth_count = 0;
		var super_recorded = "N";
		var retVal_SuperKey_count = 0;
		var total_SuperKey_count = 0;

		var RD_Normal_yn = "";
	
		RD_Normal_yn = mixed_dent_deciduous_yn;

		//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_SuperKey = trimString(xmlHttp.responseText); 
		retVal_SuperKey = localTrimString(retVal_SuperKey); 
		var retVal_SuperKey_arr = retVal_SuperKey.split("~");

		retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
	
		total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

		//Added to count the number of Exfoliated conditions recorded in case of Retained.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_Normal_yn;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
		xmlHttp.send(xmlDoc);
		var count_Exf = trimString(xmlHttp.responseText);
		count_Exf = localTrimString(count_Exf);
		if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
			var exfolth_retVal_arr = count_Exf.split("##");
			exfolth_count = exfolth_retVal_arr[0];			
		}

		//To retrieve chart_line_num if SUPRTH is recorded
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
		xmlHttp.send(xmlDoc);
		var suprth_chart_line_num = trimString(xmlHttp.responseText);
		suprth_chart_line_num = localTrimString(suprth_chart_line_num);
		if(suprth_chart_line_num.length > 0){
			super_recorded = "Y";
		}

		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = mapped_tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			var check_num_id = "check_num"+tooth_no;
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == total_SuperKey_count && (retVal_SuperKey_arr != "" && retVal_SuperKey_arr != "null" && retVal_SuperKey_arr != null)){ // For Mixed Dentition - Permanent Chart
			query_tooth_no = mapped_tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			var check_num_id = "check_num"+tooth_no;
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count && (retVal_SuperKey_arr != "" && retVal_SuperKey_arr != "null" && retVal_SuperKey_arr != null)){ // For Mixed Dentition - Permanent Chart
			query_tooth_no = tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			var check_num_id = "check_num"+tooth_no;
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
			query_tooth_no = tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			var check_num_id = "check_num"+tooth_no;
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
		}
		//Commented by Sridevi Joshi on 3/31/2010 for IN020456
		/*else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "R" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Permanent Chart
			query_tooth_no = tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			var check_num_id = "check_num"+tooth_no;
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
		}*/

		
		var imageId = "T"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
	}
	else if(condition_type == "DECITH"){ //Not applicable for MD-D Chart
		var numbering_system = document.forms[0].tooth_numbering_system.value;
		var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
		var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		if(retVal.length > 1){
			var retVal_arr = retVal.split("##")
			if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
				var imageId = "decith_table"+tooth_no;
				var tooth_sn = retVal_arr[1];
				var tooth_num = retVal_arr[0];
				var tooth_name = "";
				if(tooth_no>=1 && tooth_no<=16){
					//Added getDialogFeaturesForNoImage() by Sridevi Joshi for IN016694 on 26/22/09
					formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/R" + tooth_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'></td></tr></table></td></tr></table>";
				}else{
					//Added getDialogFeaturesForNoImage() by Sridevi Joshi for IN016694 on 26/22/09
					formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/R" + tooth_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'></td></tr></table></td></tr></table>";
				}
			}
		}
	}
	else if(condition_type == "RTDESTH"){
		var disply_tooth_no = "";
		var MDD_flag = "";
		var checked_yn = "";
		var numbering_system = document.forms[0].tooth_numbering_system.value;
		var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
		var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		if(retVal.length >=1){
			disply_tooth_no = retVal;
		}

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		if(retVal.length > 1){
			var retVal_arr = retVal.split("##")
			if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
				var imageId = "decith_table"+tooth_no;
				var tooth_sn = retVal_arr[1];
				var tooth_num = retVal_arr[0];
				var tooth_name = "";
				if(mixed_dentition_YN =="Y" && permanent_deciduous_flag =="D"){ //MD-D Chart
					if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
						if(tooth_no == "33" || tooth_no == "34"){
							root_img_no = "3";
						}
						else if(tooth_no == "41" || tooth_no == "42"){
							root_img_no = "14";
						}
						else if(tooth_no == "43" || tooth_no == "44"){
							root_img_no = "19";
						}
						else if(tooth_no == "51" || tooth_no == "52"){
							root_img_no = "30";
						}
						else{
							root_img_no = tooth_sn;
						}
					}
					else{
						root_img_no = tooth_sn;
					}
					
					// This condition is used when RTDESTH is recorded in MIXD Dent Dec case, where the DEC tooth is displayed 1st and then permanent tooth (51,11). In case of permanent chart, When RTDESTH is recorded, the permanent tooth is displayed 1st and then the dectooth (11,51)
					var rd_flag = 'RD';			//(51,11 case)
					var rd_normal_flag = "NR";
					MDD_flag = "RD"
				}else{
					root_img_no = tooth_no;
					var rd_flag = 'NR';			//(11,51 case)
					var rd_normal_flag = "RD";
				}

				if(eval("formObj.selcol"+tooth_no).checked == true){
					checked_yn = "checked";
				}

				//Added by Sharon Crasta on 10/28/2009 for IN012514
				//Added to display only the tooth no and not to replace the crown and root on Retained Deciduous.
				var check_num_id = "check_num"+tooth_no;
				if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="P"){
					formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
				}
				else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="D"){
					formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
				}
				else{
					if(tooth_no>=1 && tooth_no<=16 || (tooth_no>=33 && tooth_no<=42)){
						formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a><input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+"></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+disply_tooth_no+"');\" style='cursor:pointer'></td></tr></table></td></tr></table>";
					}
					else{
						formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a><input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\"  "+checked_yn+"></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+disply_tooth_no+"');\" style='cursor:pointer'></td></tr></table></td></tr></table>";
					}
				}
			}
		}
	}
	else if(condition_type == "SUPRTH"){
		isSprRecorded = true;
		var disply_tooth_no = "";
		var super_cnt = "";
		var checked_yn = "";
		var numbering_system = document.forms[0].tooth_numbering_system.value;

		//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		//params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
		params = "func_mode=checkSuperCount&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+mixed_dent_deciduous_yn;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_cond = trimString(xmlHttp.responseText); 
		retVal_cond = localTrimString(retVal_cond); 
		var retVal_cond_arr = retVal_cond.split("##");
		var condition_type_ref = retVal_cond_arr[1];
		if(condition_type_ref == "SUPRTH"){
			super_cnt = retVal_cond_arr[2];
		}

		//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+mixed_dent_deciduous_yn;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_SuperKey = trimString(xmlHttp.responseText); 
		retVal_SuperKey = localTrimString(retVal_SuperKey); 
		var retVal_SuperKey_arr = retVal_SuperKey.split("~");

		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && mixed_dent_deciduous_yn == "D"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				var retVal_arr = retVal.split("##");
				disply_tooth_no = retVal_arr[0];
			}
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mixed_dent_deciduous_yn != "D" && mixed_dent_deciduous_yn != "M" && mixed_dent_deciduous_yn != "R"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				var retVal_arr = retVal.split("##");
				disply_tooth_no = retVal_arr[0];
			}
			if(disply_tooth_no == "" || disply_tooth_no == "null" || disply_tooth_no == null){ //For extream tooth on MD-D chart
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0){
					var retVal_arr = retVal.split("##");
					disply_tooth_no = retVal_arr[0];
				}
			}
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}
		}
		var imageId = "decith_table"+tooth_no;
		if(permanent_deciduous_flag == "D"){ 
			if(mixed_dentition_YN == "Y" && (mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") || mixed_dentition_YN == "N"){
				if(tooth_no == "33" || tooth_no == "34"){
					var imgSrc = "../../eOH/images/R3.gif";
				}
				else if(tooth_no == "41" || tooth_no == "42"){
					var imgSrc = "../../eOH/images/R14.gif";
				}
				else if(tooth_no == "43" || tooth_no == "44"){
					var imgSrc = "../../eOH/images/R19.gif";
				}
				else if(tooth_no == "51" || tooth_no == "52"){
					var imgSrc = "../../eOH/images/R30.gif";
				}
				else{
					var imgSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
				}
			}
			else{
				var imgSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
			}
			
			//This is to get the root image if the condition is recorded on the permanent tooth(extreme tooth) in MD-D chart
			if(mapped_tooth_no == "" || mapped_tooth_no == "null" || mapped_tooth_no == null){ 
				imgSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
		}
		else{ //For Permanent Chart
			var imgSrc = "../../eOH/images/R"+tooth_no+".gif";
		}

		//Added by Sharon Crasta on 10/26/2009 for IN012514
		//On Supernumerary, should not replace the crown and root.
		var check_num_id = "check_num"+tooth_no;
		// 33/R4  34/R5  35/R6  36/R7  37/R8  
		// 38/R9  39/R10 40/R11 41/R12 42/R13
		// 47/R24 46/R23 45/R22 44/R21 43/R20
		// 52/R29 51/R28 50/R27 49/R26 48/R25
		//MR & MRS--- When conditions are recorded on the deciduous tooth in MD-D case
		//NS & S ----- When conditions are recorded on the permanent tooth after exfoliated in MD-D case
		if(eval("formObj.selcol"+tooth_no).checked == true){
			checked_yn = "checked";
		}

		if(mixed_dent_deciduous_yn == "M"){
			if(super_cnt == "2"){
				super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>";
				for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
					if(z==0){
						super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
					else{
						super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
				}

				super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";

				formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
			}
			else{
				formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
			}
		}
		else if(mixed_dent_deciduous_yn == "D"){//added by parul (record Deciduoud,supernum.....than trauma on same toothâ?¦Deciduous tooth no is C,super it will C,Cs â?¦.than truma tooth no is comng 6,6s )
			if(super_cnt == "2"){
				super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>";
				for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
					if(z==0){
						super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
					else{
						super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
				}

				super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\""+checked_yn+" >";

				formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
			}
			else{
				formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
			}
		}
		else{
			if(super_cnt == "2"){
				super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>";
				for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
					if(z==0){
						super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
					else{
						super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
					}
				}

				super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";

				formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
			}
			else{
				formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"' style='background-color:gray;color:white'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
			}

			/*var Rd_flag_ind = "";
			if(mixed_dent_deciduous_yn == "M"){
				Rd_flag_ind = "MR";
			}
			else if(mixed_dent_deciduous_yn == "D"){
				Rd_flag_ind = "D";
			}
			
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','"+Rd_flag_ind+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+Rd_flag_ind+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" "+checked_yn+">";
			*/
		}
	}
	else if( condition_type == "EXTRACT"){
		var status_int = parseInt(status);
		if (treatment_int_ext=="I"){
			if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
			}else{
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img width='40' height='25'  src='../../eOH/images/Extraction-CrownGreen_F.gif'>";
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_F.gif'>";
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
				
				}
			}

		}
		else{
			/*var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

			var imageId = "R"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";*/
			if (treatment_int_ext=="E"){
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_EF.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
				}else{
				    var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_E.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
				}
			}
		}
			
	}
	else if(condition_type == "IMPLANT"){
		/*var imageId = "T"+tooth_no;
		//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height='25'/>";
		formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";


		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif' width='45' height=34'/>";*/


		//formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='34' src=' "+image_source+" '>";

			if (treatment_int_ext=="E"){
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_EF.gif'>";
                  
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif'/>";
				}else{
				    var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_E.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif'>";
				}
			}else if (treatment_int_ext=="I"){
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_F.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_F.gif'>";				
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root.gif'>";
				
				}
			}
	}
	else if(condition_type == "CROWN"){
		var imageId = "T"+tooth_no;
		if(permanent_deciduous_flag=="P"){
			 if (treatment_int_ext=="E"){
				if (tooth_no>=1 && tooth_no<=16){
					if(trmt_outcome=="F"){
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif' width='45' height='25'/>";
					}else{
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif' width='45' height='25'/>";
					}
				}else{
					formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
				}
			 }else if (treatment_int_ext=="I"){
				 if (tooth_no>=1 && tooth_no<=16){
					 if(trmt_outcome=="F"){
							formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif' width='45' height='25'/>";
						}else{
							formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif' width='45' height='25'/>";
						}
				 }else{
					formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
				}
			 }
		}else{
			 if (treatment_int_ext=="E"){
				if (tooth_no>=33 && tooth_no<=42){
					if(trmt_outcome=="F"){
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif' width='45' height='25'/>";
					}else{
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif' width='45' height='25'/>";
					}
				}else{
					formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
				}
			 }else if (treatment_int_ext=="I"){
				 if (tooth_no>=33 && tooth_no<=42){
					 if(trmt_outcome=="F"){
							formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif' width='45' height='25'/>";
						}else{
							formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif' width='45' height='25'/>";
						}
				 }else{
					formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
				}
			 }
				
		}
	}
	else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
		//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
		//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
		/*var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height=34'/>";*/
		var s = 0;
		var j = 0;
		var oh_chart_level = document.forms[0].oh_chart_level.value;
		var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
		xmlHttp.send(xmlDoc);
		var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
		retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params_bridge_extract = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
		xmlHttp.send(xmlDoc);
		var retVal_bridge = trimString(xmlHttp.responseText); 
		retVal_bridge = localTrimString(retVal_bridge);
		if(retVal_bridge.length > 0){
			/*var retVal_pontic = retVal_bridge.split("~");
			for(i = 0;i <= retVal_pontic.length-1;i++){
				var code_desc_arr = retVal_pontic[i].split("##");
				var pontic_tooth_cut_values = code_desc_arr[0].split("$$");
				if(pontic_tooth_cut_values.length > 0){
					for(j = 0; j <= pontic_tooth_cut_values.length-1;j++){
					//for(j = pontic_tooth_cut_values.length; j > 0;j--){
						var imageId = "T"+pontic_tooth_cut_values[j];
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						
						var imageId = "R"+pontic_tooth_cut_values[j];
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
					}
				}  */
			var retVal_pontic = retVal_bridge.split("##");
			var code_desc_arr = retVal_pontic[0].split("$$");
			var code_desc_arr_str = code_desc_arr.join("~~");
			if(code_desc_arr_str.length > 0){
			   for(var k=0;k<code_desc_arr.length;k++){
				   if(tooth_no == code_desc_arr[k]){
					    if(treatment_int_ext == "E"){
							if (trmt_outcome == "F"){
								var imageId = "T"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
													
								var imageId = "R"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								break;
							}else{
								var imageId = "T"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
													
								var imageId = "R"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								break;
							}
						}else  if(treatment_int_ext == "I"){
							if (trmt_outcome == "F"){
								var imageId = "T"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
													
								var imageId = "R"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								break;
							}else{
								var imageId = "T"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
													
								var imageId = "R"+code_desc_arr[k];
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								break;
							}
						}
				   }else{
					   if(treatment_int_ext == "E"){
							if (trmt_outcome == "F"){
								var imageId = "T"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							
							}
					   }else if(treatment_int_ext == "I"){
							if (trmt_outcome == "F"){
								var imageId = "T"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
						
								var imageId = "R"+tooth_no;
								formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
					   }
				   }
			   }
			}
			//}
			else{
				if(treatment_int_ext == "E"){
					if (trmt_outcome == "F"){
						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
				
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}else{
						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
				
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
				}else if(treatment_int_ext == "I"){
					if (trmt_outcome == "F"){
						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
				
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}else{
						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
				
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
				}
				
			} 
	   	}else{
			 if(treatment_int_ext == "E"){
				if (trmt_outcome == "F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
		
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
		
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
			 }else if(treatment_int_ext == "I"){
				if (trmt_outcome == "F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
		
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
		
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
			 }
		}
	}
	else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
		if(treatment_int_ext == "E"){
			if (trmt_outcome == "F"){
				var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
			}else{
				var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
			}
		}else if(treatment_int_ext == "I"){
			if (trmt_outcome == "F"){
				var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
			}else{
				var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
			}
		}
		
	} //End
	else if(condition_type == "DENTURE"){
		/*var imageId = "T"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture2.gif'>";
		//formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";


		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture1.gif'>";
		//formObj.document.getElementById(imageId).innerHTML ="<img width='45' height='34' src=' "+image_source+" '>";*/

			if (treatment_int_ext=="E"){
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_EF.gif'>";
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

				}else{
				    var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_E.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
				}
			}else if (treatment_int_ext=="I"){
				if (trmt_outcome=="F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_F.gif'>";
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_F.gif'>";
				
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture.gif'>";

					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root.gif'>";
				
				}
			}

	}
	else if(condition_type == "PARERTH"){
		var imageId = "R"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";

		var imageId = "T"+tooth_no;
		//Added by Sharon Crasta on 10/28/2009 for IN012514
		//Record Caries -> Retained Deciduous -> The crown and root should not be replaced.
		var root_layer = "rootLayer"+tooth_no;
		var tooth_layer = "toothLayer"+tooth_no;
		if(formObj.document.getElementById(tooth_layer) == "null" || formObj.document.getElementById(tooth_layer) == null || formObj.document.getElementById(tooth_layer) == "" ){

			formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
		} 
		
		isPartiallyErupted = true;//Added by Sharon Crasta on 10/9/2009 for IN015202
	}
	else if(condition_type == "ERUPTH"){
		var imageId = "R"+tooth_no;
		
		//Added by Sharon Crasta on 10/27/2009 for IN012514
		//Added to count the number of Exfoliated conditions recorded in case of Retained.
		var count_exf = 0;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		if(retVal.length > 0 && parseInt(retVal) > 0){ 
			var retVal_arr = retVal.split("##");
			count_exf = retVal_arr[0];			
		}

		//Added by Sharon Crasta on 11/4/2009 for IN015475
		//Added to count the number of Partially ERupted Conditions conditions recorded in case of Retained.
		var count_partially_erupted = 0;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=PARERTH";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_partially_erupted = trimString(xmlHttp.responseText);
		retVal_partially_erupted = localTrimString(retVal_partially_erupted);
		if(retVal_partially_erupted.length > 0 && parseInt(retVal_partially_erupted) > 0){ 
			var retVal_partially_erupted_arr = retVal_partially_erupted.split("##");
			count_partially_erupted = retVal_partially_erupted_arr[0];			
		}

		if(count_partially_erupted != 0){
			isPartiallyErupted = true;
		}
		//End
        //added by parul on 08/01/2010 for super changes(Retained-> partially->implant trmt on permanent tooth->Erupted condition after eruption implant image was coming in place of crown)
		var count_impant = 0;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&trmt_category_type=IMPLANT";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_imp = trimString(xmlHttp.responseText);
		retVal_imp = localTrimString(retVal_imp);
		if(retVal_imp.length > 0 && parseInt(retVal_imp) > 0){ 
			var retVal_arr = retVal_imp.split("##");
			count_impant = retVal_arr[0];			
		}//end
					
		if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
		
			if(mixed_dentition_YN == "Y" && (mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") || mixed_dentition_YN == "N"){
				if(tooth_no == "33" || tooth_no == "34"){
					var imageSrc = "../../eOH/images/R3.gif";
				}
				else if(tooth_no == "41" || tooth_no == "42"){
					var imageSrc = "../../eOH/images/R14.gif";
				}
				else if(tooth_no == "43" || tooth_no == "44"){
					var imageSrc = "../../eOH/images/R19.gif";
				}
				else if(tooth_no == "51" || tooth_no == "52"){
					var imageSrc = "../../eOH/images/R30.gif";
				}
				else{
					var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
				}
			}else{
				var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
			}
		}
		else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
			var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
		}
		else{
			if(tooth_no == "33" || tooth_no == "34"){
				var imageSrc = "../../eOH/images/R3.gif";
			}
			else if(tooth_no == "41" || tooth_no == "42"){
				var imageSrc = "../../eOH/images/R14.gif";
			}
			else if(tooth_no == "43" || tooth_no == "44"){
				var imageSrc = "../../eOH/images/R19.gif";
			}
			else if(tooth_no == "51" || tooth_no == "52"){
				var imageSrc = "../../eOH/images/R30.gif";
			}
			else{
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
		}
		
		//Added by Sharon Crasta on 10/28/2009 for IN012514
		//On Eruption only the root should be erupted in case of already Partially Erupted and root and crown should appear in case of unerupted condition.
		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
			if(mixed_dent_tooth_no == "" || mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null"){
				/*
				if(isPartiallyErupted && count_exf == 1){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";
				}
			 	else if(isPartiallyErupted && count_exf == 2){//Added by Sharon Crasta on 11/4/2009 for IN015475--//In case of Supernumerary -> Exfoliate both -> PArtially Erupt-> Caries -> ERupt
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";
				}
				else if(count_exf == 2 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){//Added by Sridevi Joshi on 02/11/09 for IN015475
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				}
				else if (count_exf == 1){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				}*/
				if(isPartiallyErupted){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";
				}
				else{
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				}
			}
			else{
				var count_partially_erupted = 0;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=PARERTH";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 0 && parseInt(retVal) > 0){ 
					var retVal_arr = retVal.split("##");
					count_partially_erupted = retVal_arr[0];			
				}

				if(count_partially_erupted == 1){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
				}
				else{
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				}
			}
		}
		else{
			var count_partially_erupted = 0;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=PARERTH";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 0 && parseInt(retVal) > 0){ 
				var retVal_arr = retVal.split("##");
				count_partially_erupted = retVal_arr[0];			
			}
			
			if(count_partially_erupted == 1){
				var root_layer = "rootLayer"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
                if (count_impant>0) {  //added by parul on 08/01/2010 for super changes(Retained-> partially->implant trmt on permanent tooth->Erupted condition after eruption implant image was coming in place of crown)

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
                }
			}
			else{
				var root_layer = "rootLayer"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
			}
		}
		
		isErupted = true;//Added by Sharon Crasta on 10/9/2009 for IN015202
		isPartiallyErupted = false;//Added by Sharon Crasta on 10/9/2009 for IN015202*/
	}
	/*else{
		var root_layer = "rootLayer"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

		var imageId = "T"+tooth_no;
		formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
	}*/
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function checkApplicableMenuOptions(tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_SUPR_yn,site,thrng_nos_ref,tab_name,flag1,arch_quad){
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var super_tooth_ref = flag1;//added by parul for super changes
	var arr_prev = "";
	var miss_uner_applicable = "";
	var parer_uner_applicable = "";
	var missth_applicable = "";
	var rtd_decith_applicable = "";
	var parer_er_applicable = "";
	var uner_applicable = "";
	var erup_applicable = "";
	var mixed_parer_applicable = "";
	var decith_applicable = "";
	var impact_applicable = "";
	var trauma_applicable = "";
	var super_applicable = "";
	var atrarer_applicable = "";
	var display_menu_yn = "N";
	var deci_supr_tooth_selected = "";
	var parer_er_not_applicable = "";
	var pulpinv_not_applicable = "";
	var periinv_not_applicable = "";
	var super_not_applcable = "";
	var show_exfolth = "";
	var rootinvtooth_not_applicable = "";
	var cariestooth_not_applicable = "";
	var no_records = "";
	var retVal = "";
	var mobility_applicable="";
	var extract_applicable = "";//Added by Sharon Crasta on 5/22/2009
	var mixed_dent_num = "";
	var retained_tooth_no = "";
	var isSuperYN = "N";
	var isRetainedYN = "N";
	var super_cnt = "";
	//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
	var malposn_applicable ="";
	var malocclusion_applicable ="";
	//End
	//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
	var abutment_applicable = "";
	//End

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=populateDisplayToothNoAndName&tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_mixed = trimString(xmlHttp.responseText); 
	retVal_mixed = localTrimString(retVal_mixed); 

	if(retVal_mixed.length > 1){
		var retVal_mixed_arr = retVal_mixed.split("##");
		mixed_dent_num = retVal_mixed_arr[3];
	}

	/*//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
   	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
	xmlHttp.send(xmlDoc);
	var retVal_bridge_extract = trimString(xmlHttp.responseText); 
	retVal_bridge_extract = localTrimString(retVal_bridge_extract);
	if(retVal_bridge_extract.length > 0){
		abutment_applicable = "abutment_applicable" ;
	}*/

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)
	if(site == "QUAD"){ //Added by Sridevi Joshi on 4/21/2010 for IN020809
		tooth_no = arch_quad;
	}

	if(site == "ARCH"){
		params = "func_mode=allConditionsRecordedForArchQuad&arch_quad="+arch_quad+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText); 
		retVal = localTrimString(retVal); 
	}else{//End
	//Passed site by Sridevi Joshi on 4/21/2010 for IN020809
		params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&site="+site ;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText); 
		retVal = localTrimString(retVal); 
	}
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(m=0;m<retVal_arr.length-1;m++){
			var code_desc_arr = retVal_arr[m].split("##");
			if((code_desc_arr[0] != "" && code_desc_arr[0] != "null" && code_desc_arr[0] != null)||(code_desc_arr[2] != "" && code_desc_arr[2] != "null" && code_desc_arr[2] != null)){
				//added by parul for retained changes on 11/01/2010
               if (mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				   var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_cond = trimString(xmlHttp.responseText); 
					retVal_cond = localTrimString(retVal_cond); 
					var retVal_cond_arr = retVal_cond.split("##");
					var condition_type_ref = retVal_cond_arr[1];
					if(condition_type_ref == "SUPRTH"){
						isSuperYN = "Y";
						//super_cnt = retVal_cond_arr[2];
					}else if(condition_type_ref == "RTDESTH"){
						isRetainedYN = "Y";
					}

					//if (isRetainedYN=="Y" && (flag1 != "RD" && flag1 != "s1" && flag1 != "s2")){
					if (isRetainedYN=="Y" && (flag1 != "RD" && (flag1 == "" || flag1 == "undefined" || flag1 == undefined))){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=getMappedToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var mapped_tooth_no = trimString(xmlHttp.responseText);
						mapped_tooth_no=localTrimString(mapped_tooth_no);

						var ns_tooth_no = "";
						//To get Display_tooth_no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							retained_tooth_no = retVal;
						}

						retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/12/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					}

			   }else{
					if(flag1 == "RD"){//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes
					//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						retained_tooth_no = trimString(xmlHttp.responseText); 
						retained_tooth_no = localTrimString(retained_tooth_no); 
					}
			   }


				if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
					if(super_tooth_ref == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
						deci_supr_tooth_selected = "deci_tooth_selected";
					}
					/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH)
						deci_supr_tooth_selected = "supr_tooth_selected";
					}*/
					else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
					  deci_supr_tooth_selected = "supr_tooth_selected";
					}
					/*else if(RD_SUPR_yn == "" && super_tooth_ref != "s1" && super_tooth_ref != "s2"){ //On Permanent_tooth after recording SUPRTH added by Sridevi Joshi on 12/15/2009 for new SUPRTH changes
						deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
					}*/
					else{
						if(code_desc_arr[0] == "RTDESTH"){
							rtd_decith_applicable = "rtd_decith_applicable";
						}
						else if(code_desc_arr[0] == "SUPRTH"){
							deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
						}
					}
					
					 if(code_desc_arr[0] == "ATRARER"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ATRARER"){
							atrarer_applicable = "atrarer_applicable";
						}
					}
					else if(code_desc_arr[0] == "MISSTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MISSTH"){
							missth_applicable = "missth_applicable"; 
						}

					}
					else if(code_desc_arr[2] == "EXTRACT"){ //Added by Sharon Crasta on 5/22/2009
						extract_applicable = "extract_applicable"; 
					}
					else if(code_desc_arr[0] == "TRUMTH"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "TRUMTH"){
							trauma_applicable = "trauma_applicable";
						}
					}
					else if(code_desc_arr[0] == "MOBLTY"){//commented by parul on 03/09/2009 for CRF#699 added mobility_applicable 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MOBLTY"){
							mobility_applicable = "mobility_applicable"; 
						}
					}
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
					else if(code_desc_arr[0] == "MALPOSN"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MALPOSN"){
							malposn_applicable = "malposn_applicable"; 
						}
					} 
					else if(code_desc_arr[0] == "MALOCLN"){
						malocclusion_applicable = "malocclusion_applicable";
					}//End
					else if(code_desc_arr[0] == "IMPACTN"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "IMPACTN"){
							impact_applicable = "impact_applicable"; 
						}
						//impact_applicable = "impact_applicable"; 
					}
					else if(code_desc_arr[0] == "RTDESTH"){ 
						if(code_desc_arr[2] == "R"){
							display_menu_yn = "Y";
						}
					}
					else if(code_desc_arr[0] == "UNERTH" && super_tooth_ref != "RD"){//super_tooth_ref != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.This condition is not to get menu on retained tooth
						uner_applicable = "uner_applicable"; 
						/*added by parul for super changes if u recod root or crown-->super num --> on unerupted tooth menu was not coming*/
						rootinvtooth_not_applicable="";
						pulpinv_not_applicable="";
						periinv_not_applicable="";
						cariestooth_not_applicable="";
						//end 
					}
					else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){ // super_tooth_ref != "RD" This condition is not to get menu on retained tooth
						parer_uner_applicable = "parer_uner_applicable"; 
					}
					else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){//super_tooth_ref != "RD" This condition is not to get menu on retained tooth
						erup_applicable = "erup_applicable";
						//added by parul for super changes parer_uner_applicable,uner_applicable sholud be null after erupted
						parer_uner_applicable = "";
						uner_applicable="";
						impact_applicable = "";
						rootinvtooth_not_applicable = "";
						periinv_not_applicable = "";
						pulpinv_not_applicable = "";
						cariestooth_not_applicable = "";
					}
					else if(code_desc_arr[0] == "EXFOLTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "EXFOLTH"){
							parer_er_applicable = "parer_er_applicable";
							display_menu_yn = "N";
						}
					}
					else if(code_desc_arr[0] == "PULPINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}
					/*else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
					}
					else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
						cariestooth_not_applicable = "cariestooth_not_applicable"; 
					}*/
					else if((site == "CROWN" || site == "ROOT")){
						parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition
					}
					
					if(parer_uner_applicable != "parer_uner_applicable" && uner_applicable != "uner_applicable"){
						miss_uner_applicable = "miss_uner_applicable"; 
					}
					else{
						miss_uner_applicable = "miss_uner_impact_applicable"; 
					}

					if(impact_applicable == "impact_applicable"){
						miss_uner_applicable = "miss_uner_applicable"; 
					}
					
				}
				else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){
					/*if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH) added by Parul on 12/15/2009 for new SUPRTH changes
						deci_supr_tooth_selected = "supr_tooth_selected";
					}*/
					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
					  deci_supr_tooth_selected = "supr_tooth_selected";
					}
					/*else if(RD_SUPR_yn == "" && super_tooth_ref != "s1" && super_tooth_ref != "s2"){ //On Permanent_tooth after recording SUPRTH added by Sridevi Joshi on 12/15/2009 for new SUPRTH changes
						deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
					}*/
					else{
						if(code_desc_arr[0] == "SUPRTH"){
							deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
						}
					}
				
					if(code_desc_arr[0] == "ATRARER"){// Added by Sridevi joshi for IN013794	
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ATRARER"){
							atrarer_applicable = "atrarer_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "MISSTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MISSTH"){
							missth_applicable = "missth_applicable"; 
						}
						
					}
					else if(code_desc_arr[0] == "EXTRACT"){ //Added by Sharon Crasta on 5/22/2009
						extract_applicable = "extract_applicable"; 
					}
					else if(code_desc_arr[0] == "TRUMTH"){// Added by Sridevi joshi for IN013794	
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "TRUMTH"){
							trauma_applicable = "trauma_applicable";
							erup_applicable = "";//Added by Sridevi Joshi for IN015362
						}
					}
					else if(code_desc_arr[0] == "MOBLTY"){ // Added By Sridevi Joshi For IN013794
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MOBLTY"){
							mobility_applicable = "mobility_applicable"; 
						}
					}
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
					else if(code_desc_arr[0] == "MALPOSN"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "MALPOSN"){
							malposn_applicable = "malposn_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "MALOCLN"){
						malocclusion_applicable = "malocclusion_applicable";
					}//End
					else if(code_desc_arr[0] == "UNERTH"){
						uner_applicable = "uner_applicable"; 
					}
					else if(code_desc_arr[0] == "PARERTH"){ 
						parer_uner_applicable = "parer_uner_applicable"; 
					}
					else if(code_desc_arr[0] == "ERUPTH"){
						erup_applicable = "erup_applicable"; 
						//added by parul for super changes parer_uner_applicable,uner_applicable sholud be null after erupted
						parer_uner_applicable = "";
						uner_applicable="";
						impact_applicable = "";
					}
					else if(code_desc_arr[0] == "EXFOLTH"){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "EXFOLTH"){
							parer_er_applicable = "parer_er_applicable"; 
							display_menu_yn = "N";
						}
					}
					else if(code_desc_arr[0] == "PULPINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}
					/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH"){
						pulpinv_not_applicable = "pulpinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH"){
						periinv_not_applicable = "periinv_not_applicable"; 
					}
					else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH"){
						rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
					}
					else if(code_desc_arr[0] == "CARIES" && site == "TOOTH"){
						cariestooth_not_applicable = "cariestooth_not_applicable"; 
					}*/
					else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
						parer_er_not_applicable = "parer_er_not_applicable";
					}
					miss_uner_applicable = "miss_uner_applicable"; 
				}
				else if(mixed_dentition_YN == "Y"){
					if(permanent_deciduous_flag == "D"){
						if(super_tooth_ref == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
							deci_supr_tooth_selected = "deci_tooth_selected";
						}
						/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH) added by Parul on 12/15/2009 for new SUPRTH changes
							deci_supr_tooth_selected = "supr_tooth_selected";
						}*/
						else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
						  deci_supr_tooth_selected = "supr_tooth_selected";
						}
						else{
							if(code_desc_arr[0] == "RTDESTH"){
								parer_uner_applicable = "parer_uner_applicable"; //This is for the permanent tooth (RTDESTH)
								
								rtd_decith_applicable = "rtd_decith_applicable";
								periinv_not_applicable = "";//Added by Sharon Crasta on 12/1/2009 --//Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
								//End
							}
							else if(code_desc_arr[0] == "SUPRTH"){
								deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
							}
						}
				
						if(code_desc_arr[0] == "ATRARER"){ // Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ATRARER"){
								atrarer_applicable = "atrarer_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
							
						}
						else if(code_desc_arr[0] == "MISSTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MISSTH"){
								missth_applicable = "missth_applicable"; 
							}
							
						}
						else if(code_desc_arr[0] == "EXTRACT"){ //Added by Sharon Crasta on 5/22/2009
							extract_applicable = "extract_applicable"; 
						}
						else if(code_desc_arr[0] == "TRUMTH"){// Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "TRUMTH"){
								trauma_applicable = "trauma_applicable";
							}
						}
						else if(code_desc_arr[0] == "MOBLTY"){ // Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MOBLTY"){
								mobility_applicable = "mobility_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
						//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
						else if(code_desc_arr[0] == "MALPOSN"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MALPOSN"){
								malposn_applicable = "malposn_applicable";
							}
						} 
						else if(code_desc_arr[0] == "MALOCLN"){
							malocclusion_applicable = "malocclusion_applicable";
						}//End
						else if(code_desc_arr[0] == "RTDESTH"){ 
							if(code_desc_arr[2] == "R"){
								display_menu_yn = "Y";
							}
						}
						else if(code_desc_arr[0] == "UNERTH"){
							uner_applicable = "uner_applicable"; 
						}
						else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){//RD_SUPR_yn != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.
							parer_uner_applicable = "parer_uner_applicable";
						}
						else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){
							erup_applicable = "erup_applicable"; 
							impact_applicable = "";
							uner_applicable = ""; //temprorary added to get the menu on exfolth----> erupted toooth
							parer_er_applicable = "";//temprorary added to get the menu on exfolth----> erupted toooth
							if(parer_uner_applicable != ""){
								parer_uner_applicable = "";
							}

							deci_supr_tooth_selected = "";
							mobility_applicable = "";
							trauma_applicable = "";
							atrarer_applicable = "";
							//Added by Sharon Crasta on 12/1/2009 Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
							periinv_not_applicable = "";
							pulpinv_not_applicable = "";
							//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							malposn_applicable = "";	
							//End
						}
						else if(code_desc_arr[0] == "EXFOLTH"){
							var exfolth_count = 0;
							var retVal_SuperKey_count = 0;
							var total_SuperKey_count = 0;

							//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_SUPR_yn;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_SuperKey = trimString(xmlHttp.responseText); 
							retVal_SuperKey = localTrimString(retVal_SuperKey); 
							var retVal_SuperKey_arr = retVal_SuperKey.split("~");

							if(retVal_SuperKey_arr.length >1){

								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
								
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var exfolth_retVal = trimString(xmlHttp.responseText); 
							exfolth_retVal = localTrimString(exfolth_retVal); 
							if(exfolth_retVal == "EXFOLTH"){
								//To retrieve chart_line_num if SUPRTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var suprth_chart_line_num = trimString(xmlHttp.responseText);
								suprth_chart_line_num = localTrimString(suprth_chart_line_num);
								if(suprth_chart_line_num.length > 0){
									//Added to count the number of Exfoliated conditions recorded in case of Retained.
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_SUPR_yn;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
									xmlHttp.send(xmlDoc);
									var count_Exf = trimString(xmlHttp.responseText);
									count_Exf = localTrimString(count_Exf);
									if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
										var exfolth_retVal_arr = count_Exf.split("##");
										exfolth_count = exfolth_retVal_arr[0];			
									}

									/*if(exfolth_count == "1"){
										if (code_desc_arr[2]=="M"){//added by parul on 13/01/2010 for super changes ,exfoliate-->erupted-->super num-->not able to record any condition
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable = "";	
											//End
										}else{
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										}
									}
									else if(exfolth_count == "2"){ //Commented by Sridevi Joshi on 1/27/2010 for SUPRTH-->EXFOLTH all 3 --> was getting all menu items on permanent tooth
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable = "";	
										//End
									}*/
									if(exfolth_count == total_SuperKey_count){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable = "";	
										//End
									}
									else{
										/*if (code_desc_arr[2]=="M"){//added by parul on 13/01/2010 for super changes ,exfoliate-->erupted-->super num-->not able to record any condition
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable = "";	
											//End
										}else{*/
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										//}
									}
									
								}
								else{
									uner_applicable = "uner_applicable";
									mobility_applicable = "";
									trauma_applicable = "";
									atrarer_applicable = "";
									display_menu_yn = "Y";
									//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
									malposn_applicable = "";	
									//End
								}
							}
						}
						/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
						else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}*/
						else if(code_desc_arr[0] == "PULPINV"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PULPINV"){
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "PERIINV"){
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "PERIINV"){
							periinv_not_applicable = "periinv_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
						var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "CARIES"){
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}
					}
					else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
                        var exfolth_count = 0;
						//Added to count the number of Exfoliated conditions recorded in case of Retained.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var count_Exf = trimString(xmlHttp.responseText);
						count_Exf = localTrimString(count_Exf);
						if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
							var exfolth_retVal_arr = count_Exf.split("##");
							exfolth_count = exfolth_retVal_arr[0];			
						}

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=D&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal); 
						if(retVal == "ROOTINV"){
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
					}

						else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
							parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition
						}
						
						miss_uner_applicable = "miss_uner_applicable"; 
					}
					else if(permanent_deciduous_flag == "P"){
						if(super_tooth_ref == "RD" || RD_SUPR_yn=="D"){//added by parul on 13/11/2009 for IN016204
							show_exfolth = "show_exfolth";
						}
						else{
							show_exfolth = "";
						}

						if(super_tooth_ref == "RD"){ //This is for the deciduous(primary) tooth (RTDESTH)
							deci_supr_tooth_selected = "deci_tooth_selected";
						}
						/*else if(super_tooth_ref == "s1" || super_tooth_ref == "s2"){ //This is for the supernumarary tooth (SUPRTH) added by Parul on 12/15/2009 for new SUPRTH changes
							deci_supr_tooth_selected = "supr_tooth_selected";
						}*/
						else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
						  deci_supr_tooth_selected = "supr_tooth_selected";
						}
						else{
							if(code_desc_arr[0] == "RTDESTH"){
								parer_uner_applicable = "parer_uner_applicable"; //This is for the permanent tooth (RTDESTH)

								rtd_decith_applicable = "rtd_decith_applicable";

								//Added by Sharon Crasta on 12/1/2009 Peri Apical -> Retained -> Erupt -> New root -> should be able to record periapical condition on the newly erupted root.
								periinv_not_applicable = "";
							}
							else if(code_desc_arr[0] == "SUPRTH"){
								deci_supr_tooth_selected = "supr_normal_tooth"; //This is for the permanent tooth (SUPRTH)
							}
						}

						
						 if(code_desc_arr[0] == "ATRARER"){//Added by Sridevi Joshi for IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_SUPR_yn;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ATRARER"){
								atrarer_applicable = "atrarer_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
						else if(code_desc_arr[0] == "MISSTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MISSTH"){
								missth_applicable = "missth_applicable"; 
							}
							
						}
						else if(code_desc_arr[0] == "EXTRACT"){ //Added by Sharon Crasta on 5/22/2009
							extract_applicable = "extract_applicable"; 
						}
						
						else if(code_desc_arr[0] == "TRUMTH"){//Added by Sridevi Joshi for IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "TRUMTH"){
								trauma_applicable = "trauma_applicable";
							}
						}
						else if(code_desc_arr[0] == "MOBLTY"){// Added By Sridevi Joshi For IN013794
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MOBLTY"){
								mobility_applicable = "mobility_applicable"; //Attrition,Abrasion and Erosion Tooth Condition
							}
						}
						//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
						else if(code_desc_arr[0] == "MALPOSN"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "MALPOSN"){
								malposn_applicable = "malposn_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "MALOCLN"){
							malocclusion_applicable = "malocclusion_applicable";
						}//End
						else if(code_desc_arr[0] == "DECITH"){ 
							//commented by parul on 21/12/2009 for super changes ,DECITH--->SUPRTH--->EXFOLT on super tooth it was going on if blk,becoz of  "uner_applicable" menu was not comng now this blk is not requird becoz we r handling this in exfolation blk
							/*if(code_desc_arr[4] == "D"){//Added by Sridevi Joshi on 12/16/2009--DECITH--->SUPRTH--->EXFOLTH both
								//uner_applicable = "uner_applicable"; 
								//display_menu_yn = "Y";
							}
							else{
								decith_applicable = "decith_applicable"; 
							}*/
							decith_applicable = "decith_applicable";
						}
						else if(code_desc_arr[0] == "RTDESTH"){ 
							if(code_desc_arr[2] == "R"){
								display_menu_yn = "Y";
							}
						}
						else if(code_desc_arr[0] == "UNERTH" && super_tooth_ref != "RD"){
							uner_applicable = "uner_applicable"; 
						}
						else if(code_desc_arr[0] == "PARERTH" && super_tooth_ref != "RD"){//RD_SUPR_yn != "RD" is added bcoz we are adding one UNERTH record forcibly in to table when RTDESTH is recorded in case of Permanent  chart.
							parer_uner_applicable = "parer_uner_applicable"; 
						}
						else if(code_desc_arr[0] == "ERUPTH" && super_tooth_ref != "RD"){
							erup_applicable = "erup_applicable"; 
							uner_applicable = "";
							parer_uner_applicable = "";
							impact_applicable = "";
							parer_er_applicable = "";
							decith_applicable = "";
						}
						else if(code_desc_arr[0] == "EXFOLTH"){
							var exfolth_count = 0;
							var retVal_SuperKey_count = 0;
							var total_SuperKey_count = 0;

							//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_SUPR_yn;

							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_SuperKey = trimString(xmlHttp.responseText); 
							retVal_SuperKey = localTrimString(retVal_SuperKey); 
							var retVal_SuperKey_arr = retVal_SuperKey.split("~");

							if(retVal_SuperKey_arr.length >1){

								retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
								
								total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=Y&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var exfolth_retVal = trimString(xmlHttp.responseText); 
							exfolth_retVal = localTrimString(exfolth_retVal);

							if(exfolth_retVal == "EXFOLTH"){
								//To retrieve chart_line_num if SUPRTH is recorded
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
								xmlHttp.send(xmlDoc);
								var suprth_chart_line_num = trimString(xmlHttp.responseText);
								suprth_chart_line_num = localTrimString(suprth_chart_line_num);
								if(suprth_chart_line_num.length > 0){
									//Added to count the number of Exfoliated conditions recorded in case of Retained.
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+RD_SUPR_yn;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
									xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
									xmlHttp.send(xmlDoc);
									var count_Exf = trimString(xmlHttp.responseText);
									count_Exf = localTrimString(count_Exf);
									if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
										var exfolth_retVal_arr = count_Exf.split("##");
										exfolth_count = exfolth_retVal_arr[0];			
									}

									/*if(exfolth_count == "1"){
										if (code_desc_arr[2]=="D"){//added by parul on 17/12/2009 for super changes ,deciduous-->exfoliate-->super num-->menu was not coming on normal tooth.
											//uner_applicable = "uner_applicable";
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable ="";
											//End
										}else{
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										}
									}
									else if(exfolth_count == "2"){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										malposn_applicable ="";
										//End
									}*/
									if(total_SuperKey_count == exfolth_count){
										uner_applicable = "uner_applicable";
										deci_supr_tooth_selected = "";
										mobility_applicable = "";
										trauma_applicable = "";
										atrarer_applicable = "";
										display_menu_yn = "Y";
										
										malposn_applicable ="";//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										decith_applicable = "";
										
									}else{
										/*if(code_desc_arr[2]=="D"){//added by parul on 17/12/2009 for super changes ,deciduous-->exfoliate-->super num-->menu was not coming on normal tooth.
											//uner_applicable = "uner_applicable";
											uner_applicable = "uner_applicable";
											mobility_applicable = "";
											trauma_applicable = "";
											atrarer_applicable = "";
											display_menu_yn = "Y";
											//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											malposn_applicable ="";
											//End
										}else{*/
											parer_er_applicable = "parer_er_applicable"; 
											display_menu_yn = "N";
										//}
									}
								}
								else{
									uner_applicable = "uner_applicable";
									display_menu_yn = "Y";

									decith_applicable = "";
								}
							}
						}
						/*else if(code_desc_arr[0] == "PULPINV" && site == "CROWN"){ 
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "ROOT"){ 
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PULPINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							pulpinv_not_applicable = "pulpinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "PERIINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							periinv_not_applicable = "periinv_not_applicable"; 
						}
						else if(code_desc_arr[0] == "ROOTINV" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
						}
						else if(code_desc_arr[0] == "CARIES" && site == "TOOTH" && RD_SUPR_yn != "NR"){ //RD_SUPR_yn condition is for permanent tooth after RETDESTH condition
							cariestooth_not_applicable = "cariestooth_not_applicable"; 
						}*/
						else if(code_desc_arr[0] == "PULPINV"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "PULPINV"){
								pulpinv_not_applicable = "pulpinv_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "PERIINV"){
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "PERIINV"){
								periinv_not_applicable = "periinv_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "CARIES" && site=="TOOTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "CARIES"){
								cariestooth_not_applicable = "cariestooth_not_applicable"; 
							}
						}
						else if(code_desc_arr[0] == "ROOTINV" && site=="TOOTH"){ 
							var exfolth_count = 0;
							//Added to count the number of Exfoliated conditions recorded in case of Retained.
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
							xmlHttp.send(xmlDoc);
							var count_Exf = trimString(xmlHttp.responseText);
							count_Exf = localTrimString(count_Exf);
							if(count_Exf.length > 0 && parseInt(count_Exf) > 0){ 
								var exfolth_retVal_arr = count_Exf.split("##");
								exfolth_count = exfolth_retVal_arr[0];			
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							params = "func_mode=getConditionsOnSuprth&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&condition_type="+code_desc_arr[0]+"&permanent_deciduous_flag=P&mixed_dentition_YN=N&RD_Normal_yn="+RD_SUPR_yn+"&super_tooth_ref="+super_tooth_ref+"&retained_tooth_no="+retained_tooth_no+"&exfolth_count="+exfolth_count;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText); 
							retVal = localTrimString(retVal); 
							if(retVal == "ROOTINV"){
								rootinvtooth_not_applicable = "rootinvtooth_not_applicable"; 
							}
						}
						else if((site == "CROWN" || site == "ROOT")){/* If Root and Crown related Condition is recorded */
							parer_er_not_applicable = "parer_er_not_applicable"; // for Root and Crown related Condition
						}
						miss_uner_applicable = "miss_uner_applicable"; 
					}
				}
			}
		}
	}
	else{
		no_records = "no_records";
	}

	if(mixed_dentition_YN == "Y"){
		if(mixed_dent_num != null && mixed_dent_num != "null" && mixed_dent_num != ""){
			mixed_parer_applicable = "mixed_parer_applicable";
		}
	}

	//Added by Sharon Crasta on 2/19/2010 for SRR20056-CRF-0475
	var retVal_bridge_extract="";//added by parul on 07/05/2010 for IN021229
	if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
		xmlHttp.send(xmlDoc);
		 retVal_bridge_extract = trimString(xmlHttp.responseText); 
		retVal_bridge_extract = localTrimString(retVal_bridge_extract);
		if(retVal_bridge_extract.length > 0){
			abutment_applicable = "abutment_applicable" ;
		}
	} //End	
	
	if(no_records == "no_records"){
		retVal = no_records;
		if(retVal_bridge_extract.length > 0){//Added by Sridevi Joshi on 4/26/2010 for PE..Written common block for query above
			retVal =  abutment_applicable;
		}
		//Added by Sharon Crasta on 2/19/2010 for SRR20056-CRF-0475
		/*if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_bridge_extract = trimString(xmlHttp.responseText); 
			retVal_bridge_extract = localTrimString(retVal_bridge_extract);
			if(retVal_bridge_extract.length > 0){
				abutment_applicable = "abutment_applicable" ;
				retVal =  abutment_applicable;
			}
		} //End	*/
	}
	else{
		if(mixed_dentition_YN == "Y"){
			//Pls dont change the order..Sridevi Joshi 14/07/09
			var return_val = display_menu_yn+"~~"+show_exfolth+"~~"+super_not_applcable+"~~"+miss_uner_applicable+"~~"+parer_uner_applicable+"~~"+missth_applicable+"~~"+uner_applicable+"~~"+parer_er_applicable+"~~"+rtd_decith_applicable+"~~"+erup_applicable+"~~"+atrarer_applicable+"~~"+super_applicable+"~~"+trauma_applicable+"~~"+decith_applicable+"~~"+deci_supr_tooth_selected+"~~"+parer_er_not_applicable+"~~"+pulpinv_not_applicable+"~~"+impact_applicable+"~~"+periinv_not_applicable+"~~"+rootinvtooth_not_applicable+"~~"+cariestooth_not_applicable+"~~"+extract_applicable+"~~"+mobility_applicable+"~~"+malposn_applicable+"~~"+malocclusion_applicable;
			//Added malposn_applicable,malocclusion_applicable by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
		}
		else{
			//Pls dont change the order..Sridevi Joshi 14/07/09
			//Added abutment_applicable by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
			//Added malposn_applicable,malocclusion_applicable by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
			var return_val = display_menu_yn+"~~"+show_exfolth+"~~"+super_not_applcable+"~~"+miss_uner_applicable+"~~"+parer_uner_applicable+"~~"+missth_applicable+"~~"+uner_applicable+"~~"+parer_er_applicable+"~~"+rtd_decith_applicable+"~~"+erup_applicable+"~~"+mixed_parer_applicable+"~~"+atrarer_applicable+"~~"+super_applicable+"~~"+trauma_applicable+"~~"+decith_applicable+"~~"+deci_supr_tooth_selected+"~~"+parer_er_not_applicable+"~~"+pulpinv_not_applicable+"~~"+impact_applicable+"~~"+periinv_not_applicable+"~~"+rootinvtooth_not_applicable+"~~"+cariestooth_not_applicable+"~~"+extract_applicable+"~~"+mobility_applicable+"~~"+malposn_applicable+"~~"+malocclusion_applicable+"~~"+abutment_applicable;
		}
		var ret_arr  = return_val.split("~~");
		for(l=0;l<ret_arr.length;l++){
			if(ret_arr[l] != ""){
				if(l==0){
					retVal = ret_arr[l];
				}
				else{
					retVal = retVal+"~~"+ret_arr[l];
				}
			}
		}
	}
	return retVal;
}

function resultMenuOptions(applicable_yn,applicable_cond_types,applicable_cond_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,tab_name,flag){
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var super_not_applcable = "";
	var erupth_yn = "N";
	var super_cnt = "";
	var ispartially_erupted = false;	//added by parul on 10/09/2009 for IN014257(record Partially Erupted,any condition on crown after that menu was not coming on tooth for MP,MD chart,passed flag "ispulp_recorded" in caries,root involvement,periapical)
	var isExfoliated = false;	//added by parul on 10/09/2009 for IN014257(record Partially Erupted,any condition on crown after that menu was not coming on tooth for MP,MD chart,passed flag "ispulp_recorded" in caries,root involvement,periapical)
    
	//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=checkSuperCount&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_cond = trimString(xmlHttp.responseText); 
	retVal_cond = localTrimString(retVal_cond); 
	var retVal_cond_arr = retVal_cond.split("##");
	var condition_type_ref = retVal_cond_arr[1];
	if(condition_type_ref == "SUPRTH"){
		super_cnt = retVal_cond_arr[2];
	}

	for(z=0;z<applicable_yn.length;z++){
		temp_array = new Array();
		temp_array_desc = new Array();
		
		show_exfolth = applicable_yn[1];
		if(applicable_yn[z] == "rtd_decith_applicable"){
			super_not_applcable = "super_not_applcable";	
		}
		if(applicable_yn[z] != "N" && applicable_yn[z] != "Y" && applicable_yn[z] != "show_exfolth"  && 		applicable_yn[z] != "super_not_applcable" && applicable_yn[z] != "rtd_decith_applicable"){ // This necessary bcoz we are not checking for the conditions applicable_yn[z] == "N" and applicable_yn[z] == "Y".. So its better to remove these from the list
			for(i=0; i<applicable_cond_types.length; i++ ){
				if(mixed_dentition_YN == "Y"){  // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
						if(applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "IMPACTN"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
								ispartially_erupted=true;
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)

										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								
								}
							
							} 
							else if(applicable_yn[z] == "supr_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "trauma_applicable" ){ // Deciduous Tooth case
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "MALPOSN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							} 
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "atrarer_applicable"){ // Attrition,Abration and Erosion Tooth case
									if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable" ){ // Exfoliated Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case and if RTDESTH is not recorded previously...
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case  and if RTDESTH is recorded previously...
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "SUPRTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mixed_parer_applicable"){ // Erupted Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after PULPINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "pulpinv_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES" ){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after PERIINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "periinv_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Pulp Involvement Condition
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
								if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after ROOTHINV-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
									if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							/* Added by Sridevi Joshi for IN013769(Not getting ERUPTH in the menu after CARIES-->Retained-->Exfolth on deciduous tooth) on 22/08/09 */
							else if(applicable_yn[z] == "cariestooth_not_applicable" && super_not_applcable == "super_not_applcable"){ // For Caries Condition when menu select from Site TOOTH
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
									if(ispartially_erupted==true){
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else{
								//This condition was not there...bcoz of which we were getting the menu on Missing tooth also(content of If block was there ....added only if condition) by Sridevi Joshi on 17/12/2008 
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
									if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}									
								}
								//Added by Sharon Crasta on 11/27/2009 for IN016114
								//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
								else{
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
						}
					}
					else {
						//For Mixed Dentition - Permanent Chart
					 	if(applicable_cond_types[i] != "IMPACTN"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										ispartially_erupted = true;
										
								}
							}
							else if(applicable_yn[z] == "decith_applicable"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH"  && applicable_cond_types[i] != "ATRARER"){// && applicable_cond_types[i] != "ATRARER" added by parul for super changes,attrition should not come in menu on deciduous
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							
							} 
							else if(applicable_yn[z] == "trauma_applicable" && show_exfolth == "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "trauma_applicable" && show_exfolth != "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 10/29/2009 for IN015697
							//If mobility is recorded on Deciduous tooth and Retained Deciduous tooth, then Exfoliation should appear. On a permanent tooth, on mobility exfoliation shoudl not appear.
							else if(applicable_yn[z] == "mobility_applicable" && show_exfolth == "show_exfolth"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH"){	
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mobility_applicable" && show_exfolth != "show_exfolth"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"&& applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable" && show_exfolth == "show_exfolth"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "MALPOSN"){	
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable" && show_exfolth != "show_exfolth"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "MALPOSN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "super_applicable"){ // Deciduous Tooth case
								///if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
								if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
										
								}
							}
							//Added by Sharon Crasta on 10/29/2009 for IN015697
							//If attrition is recorded on Deciduous tooth and Retained Deciduous tooth, then Exfoliation should appear. On a permanent tooth, on attrition exfoliation should not appear.
							else if(applicable_yn[z] == "atrarer_applicable"  && show_exfolth == "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//else if(applicable_yn[z] == "atrarer_applicable"){ // Deciduous Tooth case
							else if(applicable_yn[z] == "atrarer_applicable"   && show_exfolth != "show_exfolth"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
								//if(applicable_cond_types[i] == "PARERTH" || applicable_cond_types[i] == "ERUPTH"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case //Added EXFOLTH on 070208 by Sridevi Joshi
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_tooth_selected" && show_exfolth != "show_exfolth"){ // SUPRTH condition for deciduous tooth //Added EXFOLTH by sridevi joshi on 070208
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "supr_tooth_selected" && show_exfolth == "show_exfolth"){ // SUPRTH condition for deciduous tooth //Added EXFOLTH by sridevi joshi on 070208
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth" && show_exfolth != "show_exfolth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth" && show_exfolth != "show_exfolth"){ // SUPRTH condition for permanent tooth //added by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth"  && show_exfolth == "show_exfolth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "supr_normal_tooth"  && show_exfolth == "show_exfolth"){ // SUPRTH condition for permanent tooth//added by parul on 13/11/2009 for IN016204
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "SUPRTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "mixed_parer_applicable"){ // Erupted Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								 // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(Mobility should not appear as a condition type if the tooth is un-erupted)
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH"&& applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							else if(applicable_yn[z] == "pulpinv_not_applicable" && display_menu_yn == "Y"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(ispartially_erupted==true){
										if(applicable_cond_types[i] != "PARERTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										//Removed EXFOLTH from condition by Sridevi Joshi on 4/8/2010 IN020566
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							else if(applicable_yn[z] == "periinv_not_applicable" && show_exfolth == "show_exfolth"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							else if(applicable_yn[z] == "periinv_not_applicable" && show_exfolth != "show_exfolth"){ // For Pulp Involvement Condition
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(ispartially_erupted==true){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							//else if(applicable_yn[z] == "rootinvtooth_not_applicable" && display_menu_yn == "Y"){ // For Root Involvement Condition when menu select from Site TOOTH
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && show_exfolth == "show_exfolth"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							else if(applicable_yn[z] == "rootinvtooth_not_applicable" && show_exfolth != "show_exfolth"){ // For Root Involvement Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(ispartially_erupted==true){
										if(applicable_cond_types[i] != "PARERTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
									//	if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){//commented by parul for super changes,exfoliation was not comng on ,deciduous-->root involves
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){

											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							} 
							//Added by Sharon Crasta on 10/13/2009 for IN015312
							else if(applicable_yn[z] == "cariestooth_not_applicable" && display_menu_yn == "Y"){ // For Caries Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							} //End
							else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
								if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}

									if(ispartially_erupted==true){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXFOLTH"){
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else{
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
									if(tooth_no == 2 || tooth_no == 3 || tooth_no == 14 || tooth_no == 15 || tooth_no == 18 || tooth_no == 19 || tooth_no == 30 || tooth_no == 31){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "EXFOLTH" ){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								//Added by Sharon Crasta on 11/27/2009 for IN016114
								//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
								else{
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
						}
					}
				}
				else { // Other than Mixed Dentition case
					if(permanent_deciduous_flag == "D") { // For Deciduous Chart
						if(applicable_cond_types[i] != "IMPACTN"){
							if(applicable_cond_types[i] != "DECITH" && applicable_cond_types[i] != "RTDESTH"){
								if(applicable_yn[z] == "miss_uner_applicable"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}else if(applicable_yn[z] == "missth_applicable"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "parer_uner_applicable"){ //Partially Erupted Condition
									ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "supr_tooth_selected"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "supr_normal_tooth"){
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "trauma_applicable"){ 
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH"){
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by parul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
								//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
								else if(applicable_yn[z] == "malposn_applicable"){
									if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
								}
								else if(applicable_yn[z] == "malocclusion_applicable"){
								 if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else if(applicable_yn[z] == "super_applicable"){ // Deciduous Tooth case
									if(applicable_cond_types[i] != "SUPRTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "atrarer_applicable"){ // Deciduous Tooth case
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "PARERTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
									ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "erup_applicable"){ // Erupted Case
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" ){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										//if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
								else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
									ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								} 
								else{
									if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
										if(applicable_cond_types[i] != "ERUPTH"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									//Added by Sharon Crasta on 11/27/2009 for IN016114
									//When the tooth is extracted from the treatment tab, the condition type is taken as missing tooth.
									else{
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
						}
					}
					else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
						if(applicable_cond_types[i] != "DECITH"){
							if(applicable_yn[z] == "miss_uner_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "missth_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//added by parul on 21/04/2010 for IN020794
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "miss_uner_impact_applicable"){
								//Condition added for 3rd molar also by Sridevi Joshi on 12/17/2009 for IN017296
								if(tooth_no == 6 || tooth_no == 11 || tooth_no == 22 || tooth_no == 27 || tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
								 	if(applicable_cond_types[i] == "IMPACTN" || applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];							
									}
								}else if(tooth_no != 6 || tooth_no != 11 || tooth_no != 22 || tooth_no != 27){
									if(applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];		
									} 
								}
							} 
							else if(applicable_yn[z] == "uner_applicable"){ // Un Erupted Case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "impact_applicable"){ // Impaction Condition Case it is only applicable in Permanent chart
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982) // 03 MAR Sridevi
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable" && display_menu_yn == "Y"){ // Exfoliated Case
								ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207

								//Mobility Condition added by Sridevi Joshi for IN012602(CRF-699)
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_er_applicable"){ // Exfoliated Case
								ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207
								isExfoliated=true;//Added by Sharon Crasta on 10/10/2009 for IN015207
								
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "parer_uner_applicable" && display_menu_yn != "D"){ //Partially Erupted Condition
								ispartially_erupted = true;//Added by Sharon Crasta on 10/10/2009 for IN015207
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "EXTRACT"  && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "deci_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" ){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_tooth_selected"){ // Deciduous Tooth case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" && super_cnt == "1"){ //Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To allow SUPRTH 2nd time.
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "supr_normal_tooth" ){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							} 
							else if(applicable_yn[z] == "trauma_applicable"){ // Trauma Tooth case
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "TRUMTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}else if(applicable_yn[z] == "mobility_applicable"){ // MOBILITY Tooth case for CRF#699 added by aprul on 03/09/2009(If Mobility is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.)
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)
							//If malposition condition is recorded, the new menu option should be provided by attrition, abrasion, trauma, exfoliation or erosion.
							else if(applicable_yn[z] == "malposn_applicable"){
								if(applicable_cond_types[i] != "MISSTH"  && applicable_cond_types[i] != "SUPRTH"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MALPOSN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
							}
							else if(applicable_yn[z] == "malocclusion_applicable"){
							   if(applicable_cond_types[i] != "MALOCLN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else if(applicable_yn[z] == "super_applicable"){ // Supernumarary Tooth case
								if(applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "atrarer_applicable"){ // Attrition,Abrasion and Erosion case
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER"  && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"  && applicable_cond_types[i] != "EXTRACT"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable != "super_not_applcable"){ // Erupted Case
								erupth_yn = "Y";
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "IMPACTN" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];

								}
							}
							else if(applicable_yn[z] == "erup_applicable" && super_not_applcable == "super_not_applcable"){ // Erupted Case
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "SUPRTH" ){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}

							}
							else if(applicable_yn[z] == "pulpinv_not_applicable"){ // For Pulp Involvement Condition
								/* commented by sridevi after removing 3rd molar images on 09/07/09*/
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32) && erupth_yn != "Y"){//erupth_yn is to get the menu after ERUPTH. If it is 'N' menu will be poulated for PARERTH for the 3rd molars 
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "EXTRACT"){ //unerrupted is applicable only for extream tooth //added CARIES condition to remove CARIES menu once PULPINV is recorded
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
									   	if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "PULPINV" && applicable_cond_types[i] != "IMPACTN" && applicable_cond_types[i] != "CARIES"){ //added CARIES condition to remove CARIES menu once PULPINV is recorded
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							else if(applicable_yn[z] == "periinv_not_applicable"){ // For Pulp Involvement Condition
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32) && erupth_yn != "Y"){//erupth_yn is to get the menu after ERUPTH. If it is 'N' menu will be poulated for PARERTH for the 3rd molars 
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{ 
									
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "PERIINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							else if(applicable_yn[z] == "rootinvtooth_not_applicable"){ // For Root Involvement Condition when menu select from Site TOOTH
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32) && erupth_yn != "Y"){//erupth_yn is to get the menu after ERUPTH. If it is 'N' menu will be poulated for PARERTH for the 3rd molars
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "ROOTINV" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
							}
							else if(applicable_yn[z] == "cariestooth_not_applicable"){ // For Caries Condition when menu select from Site TOOTH
								if((tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32) && erupth_yn != "Y"){//erupth_yn is to get the menu after ERUPTH. If it is 'N' menu will be poulated for PARERTH for the 3rd molars
									if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT"){ //unerrupted is applicable only for extream tooth
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
									}
								}
								else{
									//Added by Sharon Crasta on 10/10/2009 for IN015207
									//Added to display Eruption menu option once any condition is recorded on the partially erupted condition(crown)
									if(!ispartially_erupted){
										
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH"  && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){ 
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{ //End
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "CARIES" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}
							}
							else if(applicable_yn[z] == "parer_er_not_applicable"){ // For Crown and Root related Conditions
								//Added by Sharon Crasta on 10/10/2009 for IN015207
								ispartially_erupted = true;
								//
								if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "IMPACTN"){
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
							//Added by Sharon Crasta on 2/18/2010 for SRR20056-CRF-0475
							else if(applicable_yn[z] == "abutment_applicable"){
								if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN" && applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
									temp_array[i] = applicable_cond_types[i];
									temp_array_desc[i] = applicable_cond_desc[i];
								}
							}//End
							else{								
								if(applicable_yn[z] == "no_records"){ // No conditions are recorded.
									if(tooth_no == 1 || tooth_no == 16 || tooth_no == 17 || tooth_no == 32){
										if(applicable_cond_types[i] != "MISSTH" && applicable_cond_types[i] != "TRUMTH" && applicable_cond_types[i] != "SUPRTH" && applicable_cond_types[i] != "ATRARER" && applicable_cond_types[i] != "EXFOLTH" && applicable_cond_types[i] != "RTDESTH" && applicable_cond_types[i] != "EXTRACT" && applicable_cond_types[i] != "MOBLTY" && applicable_cond_types[i] != "MALPOSN"){	//Added MALPOSN by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0498(IN010982)//unerrupted is applicable only for extream tooth
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else if(tooth_no == 6 || tooth_no == 11 || tooth_no == 22 || tooth_no == 27){
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH"){
										
												temp_array[i] = applicable_cond_types[i];
												temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
									else{
										if(applicable_cond_types[i] != "PARERTH" && applicable_cond_types[i] != "ERUPTH" && applicable_cond_types[i] != "UNERTH" && applicable_cond_types[i] != "IMPACTN"){
											temp_array[i] = applicable_cond_types[i];
											temp_array_desc[i] = applicable_cond_desc[i];
										}
									}
								}else{
										temp_array[i] = applicable_cond_types[i];
										temp_array_desc[i] = applicable_cond_desc[i];
								}
							}
						}
					}
				}
			}
			applicable_cond_types = temp_array;
			applicable_cond_desc = temp_array_desc;
		}
	}
	return applicable_cond_types;
}

//Added arch_quad by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982)

function applicableTrmtMenuOptions(applicable_trmt_types,tooth_no,patient_id,chart_num,numbering_system,permanent_deciduous_flag,mixed_dentition_YN,RD_SUPR_yn,site,thrng_nos_ref,counter,len,no_of_tooth,arch_quad,flag1,retained_tooth_no,flag_not_consecutive){
	var formObj = document.forms[0]; 
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var arr_prev = "";
	var miss_uner_applicable = "";
	var parer_uner_applicable = "";
	var missth_applicable = "";
	var rtd_decith_applicable = "";
	var parer_er_applicable = "";
	var uner_applicable = "";
	var erup_applicable = "";
	var mixed_parer_applicable = "";
	var decith_applicable = "";
	var impact_applicable = "";
	var trauma_applicable = "";
	var super_applicable = "";
	var atrarer_applicable = "";
	var display_menu_yn = "N";
	var deci_supr_tooth_selected = "";
	var parer_er_not_applicable = "";
	var pulpinv_not_applicable = "";
	var no_records = "";
	var retVal = "";
	var mixed_dent_num = "";
	var return_surface_alert ='N';

	
	//var trmt_arr = new Array();
	var applicable_trmt_types_arr = new Array();
	var applicable_trmt_types_arr1 = new Array();

	if(site == "THRNG"){ // For Tooth Range
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;
		if(len >1){ //This is exclusively for Bridge Treatment
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurface&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}//end

			//Added by Sharon Crasta on 3/17/2010 for IN019944
			//Added so that Bridge is not displayed when Implant, Denture, Impaction(condition) is recorded on a tooth.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkForTrmtForMenu&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_trmt_menu = trimString(xmlHttp.responseText); 
			retVal_trmt_menu = localTrimString(retVal_trmt_menu); 

			//Added by Sharon Crasta on 3/23/2010 for IN019944
			//Bridge should not be displayed while Impaction Condition has been recorded.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForImpactionCondForMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_impactn = trimString(xmlHttp.responseText);
			retVal_impactn = localTrimString(retVal_impactn);
			//End
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+flag1+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome = trimString(xmlHttp.responseText); 
			retVal_outcome = localTrimString(retVal_outcome);
			if(retVal_outcome.length > 1){
				var retVal_outcome_arr = retVal_outcome.split("~");
				for(var j=0;j<retVal_outcome_arr.length-1;j++){
						var code_desc_arr = retVal_outcome_arr[j].split("##");
						var trmt_type = code_desc_arr[0];
						var trmt_outcome = code_desc_arr[1];
						var denture_removable = code_desc_arr[2];
						//Added by Sharon Crasta on 3/23/2010 for IN019944
						//We are considering trmt_outcome as "S", when it is null.
						if(trmt_outcome == "" || trmt_outcome == "null" || trmt_outcome == null || trmt_outcome == "undefined" || trmt_outcome == undefined) {
							trmt_outcome = "S";
						}
						//End
						
						if(trmt_outcome=="F" || (trmt_outcome=="" || trmt_outcome=="null" || trmt_outcome==null) || trmt_outcome=="undefined" || trmt_outcome==undefined){
							
							for(k=0;k<applicable_trmt_types.length;k++){
								//Added by Sharon Crasta on 3/10/2010 for SRR20056-CRF-0475
								// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt. 
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					  	 xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_eruption = trimString(xmlHttp.responseText);
								retVal_eruption = localTrimString(retVal_eruption);
								//End
								//if((counter == "0" || counter == len) && applicable_trmt_types[k] == "BRIDGE" && (retVal_trmt_menu < 1)){
								if((counter == "0" || counter == len) && applicable_trmt_types[k] == "BRIDGE" && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")){

									if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
										//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
										
										if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
											if(!flag_not_consecutive){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
											if(!flag_not_consecutive){
											
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}								
										} //End
									}
									else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){
										   for(k=0;k<applicable_trmt_types.length;k++){//Added by Parul on 27/02/2010 for SRR20056-CRF-0477
										   	
												if (trmt_type=="BRIDGE" && (retVal_trmt_menu < 1)){
												  //Added mixed_dentition_YN , permanent_deciduous_flag by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - to make bridge applicable only for the permanent chart.
													if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
														if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
														if(!flag_not_consecutive){
														
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}								
													} //End
												}
										   }
									} 
									else{
										if(applicable_trmt_types[k] != "BRIDGE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								else if((counter == "0" || counter == len) && applicable_trmt_types[k] == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020203
									if((document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined") && (document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined")){
										if(applicable_trmt_types[k] == "DENTURE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								else if(counter > 0  && counter < len && applicable_trmt_types[k] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")) {
									if((document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined") && (document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined")){
										//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
										if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
											if(!flag_not_consecutive){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
											if(!flag_not_consecutive){
											
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}								
										} //End
									}
									else{
										if(applicable_trmt_types[k] != "BRIDGE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								} 								
								else{
									
									if(return_surface_alert =="Y"){//if blk added by parul on 03/02/2010 for CRF-442
										for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}	
									}
									else{
										
										if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined" ){
											for(k=0;k<applicable_trmt_types.length;k++){
												if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}		
										}
										else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){
										   for(k=0;k<applicable_trmt_types.length;k++){//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868) ---//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
										  
												if (trmt_type=="BRIDGE" && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")) {
												
													//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
													if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32 ) {
														
														if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
														if(!flag_not_consecutive){
														  	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}								
													} //End
												}else{//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868) ---//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
													 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" ||		applicable_trmt_types[k] == "ORTHO"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													 }
												}
										   }
										} //End
										//Added by Sharon Crasta on 3/23/2010 for IN019944
										//Added so that Bridge is not seen when Impaction condition /trmt is recorded on a tooth.
										else if(trmt_type == "IMPACT" || retVal_impactn == "IMPACTN"){
										 for(y=0;y<applicable_trmt_types.length;y++){
												if(applicable_trmt_types[y] == "BRIDGE"){
													applicable_trmt_types = "";
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}	
										}//End
										else{
											for(k=0;k<applicable_trmt_types.length;k++){
												if (trmt_type=="BRIDGE"  && (trmt_type != "IMPACT" || retVal_impactn != "IMPACTN")) {
													//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
													if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
														if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
														if(!flag_not_consecutive){
														
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}								
													} //End
												}else{//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868) ---//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
													  if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture is added by Sridevi JOshi on 2/27/2010
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}	
										}
									}
								}
							}
						}else{
							if(denture_removable=="Y"){
									for(y=0;y<applicable_trmt_types.length;y++){
										if(applicable_trmt_types[y] == "DENTURE" ){
												applicable_trmt_types_arr[y] = applicable_trmt_types[y];
										}
									}
						   }
						   //Added by Sharon Crasta on 3/23/2010 for IN019944
						   //If the Denture is not removaable and is a success then Bridge should not be recorded on that range of tooth.
						   else if(denture_removable=="N"){
							  for(y=0;y<applicable_trmt_types.length;y++){
									if(applicable_trmt_types[y] == "BRIDGE"){
										applicable_trmt_types = "";
										applicable_trmt_types_arr[y] = applicable_trmt_types[y];
									}
								}
							
						   } //End
						   else{
								if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT" || trmt_type=="MAXILLA" || trmt_type=="ORTHO"){
									for(y=0;y<applicable_trmt_types.length;y++){
										
										//Added by Sharon Crasta on 3/10/2010 for SRR20056-CRF-0475
										// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt. 
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");					  	 xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
										xmlHttp.send(xmlDoc);
										var retVal_eruption = trimString(xmlHttp.responseText);
										retVal_eruption = localTrimString(retVal_eruption);
										//End

										if((counter == "0" || counter == len) && applicable_trmt_types[y] == "BRIDGE" && (retVal_trmt_menu < 1)){
										
											if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
												//Added by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868)
												if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
													if(!flag_not_consecutive){
														applicable_trmt_types_arr[y] = applicable_trmt_types[y];
													}
												} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
													if(!flag_not_consecutive){
													
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}								
												} //End
											}
											else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){
												   for(k=0;k<applicable_trmt_types.length;k++){//Added by Parul on 27/02/2010 for SRR20056-CRF-0477
													
														if (trmt_type=="BRIDGE"){
														  //Added  by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - 
														  if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
															if(applicable_trmt_types[k] == "BRIDGE" && !flag_not_consecutive){
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
																}
															} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
																if(!flag_not_consecutive){
																
																	applicable_trmt_types_arr[k] = applicable_trmt_types[k];
																}								
															} 
														} 
														else{
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														} //End
												   }
											} 
											else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && (document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined")){//Added by Sridevi Jsohi on 3/5/2010 for SRR20056-CRF-0478
												for(k=0;k<applicable_trmt_types.length;k++){
													if(applicable_trmt_types[k] == "DENTURE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
											else{
												if(applicable_trmt_types[y] != "BRIDGE"){
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}
										}
										else if((counter == "0" || counter == len) && applicable_trmt_types[y] == "DENTURE"){//Added by Sridevi Joshi on 4/5/2010 for IN020203
											if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && (document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined")){//Added by Sridevi Jsohi on 3/5/2010 for SRR20056-CRF-0478
												for(k=0;k<applicable_trmt_types.length;k++){
													if(applicable_trmt_types[k] == "DENTURE"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
										}
										else if(counter > 0  && counter < len && applicable_trmt_types[y] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && (retVal_trmt_menu < 1)) {
											
											if((document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined") && (document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined")){
												//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
												if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
													if(!flag_not_consecutive){
														applicable_trmt_types_arr[y] = applicable_trmt_types[y];
													}
												} else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
													if(!flag_not_consecutive){
													
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}								
												} //End
											}
											else{
												if(applicable_trmt_types[y] != "BRIDGE"){
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}
										}
										else if( applicable_trmt_types[y] != "ORTHO"  && (retVal_trmt_menu < 1)){
											applicable_trmt_types_arr[y] = applicable_trmt_types[y];
										}
										//Added by Sharon Crasta on 3/23/2010 for IN019944
									   //If the Impaction,Implant,Denture are recorded and are a success then Bridge should not be recorded on that range of tooth.
										else if(retVal_trmt_menu > 1) {
											 applicable_trmt_types = "";
											 applicable_trmt_types_arr[y] = applicable_trmt_types[y];
										} //End
									}
								}
								//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
								if (trmt_type=="BRIDGE" ){
									for(k=0;k<applicable_trmt_types.length;k++){
										if(applicable_trmt_types[k] != "BRIDGE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}else{
										   //applicable_trmt_types = "";
										   //applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}									
								} //End
							}
						}

						if(applicable_trmt_types_arr!=""){
							applicable_trmt_types=applicable_trmt_types_arr;
						}
				}
				
			}else{//this bolck is for if first time we are recording the tooth range added by parul on 27/02/2010 for CRF-477
				
			      for(k=0;k<applicable_trmt_types.length;k++){
						//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
					    //Bridge should not be displayed while Impaction Condition has been recorded.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForImpactionCondForMenu&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_impactn = trimString(xmlHttp.responseText);
						retVal_impactn = localTrimString(retVal_impactn);

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkForERUPTHForMenu&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_eruption = trimString(xmlHttp.responseText);
						retVal_eruption = localTrimString(retVal_eruption);
						//End
						
						if((counter == "0" || counter == len) && applicable_trmt_types[k] == "BRIDGE" && retVal_impactn != "IMPACTN"  && (retVal_trmt_menu < 1)){
						
							if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
								//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
								if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32){
									if(!flag_not_consecutive){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
								else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
									if(!flag_not_consecutive){
									
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}								
								}//End
							}
							else{
								if(applicable_trmt_types[k] != "BRIDGE"){
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}
						}
						else if(counter > 0  && counter < len && applicable_trmt_types[k] == "BRIDGE" && no_of_tooth == (parseInt(len)-1) && retVal_impactn != "IMPACTN"  && (retVal_trmt_menu < 1)){
							
							if((document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined") && (document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined")){

								//Added tooth_no by Sharon Crasta on 3/1/2010 for SRR20056-CRF-0475(IN010868) - not to display the bridge menu on the 3rd molars.
								if(tooth_no != 1 && tooth_no != 16 && tooth_no != 17 && tooth_no != 32  && !flag_not_consecutive){
									 
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}else if(retVal_eruption > 0){// If the 3rd molars are ERupted, then should be able to record the Bridge Trmt.
									if(!flag_not_consecutive){
									
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}								
								}//End
							}
							else{
								if(applicable_trmt_types[k] != "BRIDGE"){
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}
						}
						else{
						
							if(return_surface_alert =="Y"){//if blk added by parul on 03/02/2010 for CRF-442
								for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){
									
									//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}	
							}
							else{
								if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined" ){
									for(k=0;k<applicable_trmt_types.length;k++){
										//if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										
										//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
								//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
								//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
								else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){
								//else if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined") {
								   for(k=0;k<applicable_trmt_types.length;k++){
									 
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								} //End
								else{
									for(k=0;k<applicable_trmt_types.length;k++){
										//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){
										if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture condition is added by Sridevi Joshi on 3/2/2010 for IN010871(SRR20056-CRF-0478)
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}	
								}
							}
						}
				  }
			}
		}
		else{ 
             var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=ChkAllsurface&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}//end


			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+flag1+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome = trimString(xmlHttp.responseText); 
			retVal_outcome = localTrimString(retVal_outcome); 
			if(retVal_outcome.length > 1){
				var retVal_outcome_arr = retVal_outcome.split("~");
					for(var j=0;j<retVal_outcome_arr.length-1;j++){
						var code_desc_arr = retVal_outcome_arr[j].split("##");
						var trmt_type = code_desc_arr[0];
						var trmt_outcome = code_desc_arr[1];
						var denture_removable = code_desc_arr[2];
						//Added by Sharon Crasta on 3/23/2010 for IN019944
						//We are considering trmt_outcome as "S", when it is null.
						if(trmt_outcome == "" || trmt_outcome == "null" || trmt_outcome == null || trmt_outcome == "undefined" || trmt_outcome == undefined) {
							trmt_outcome = "S";
						}
						//End
						if(trmt_outcome=="F" || (trmt_outcome=="" || trmt_outcome=="null" || trmt_outcome==null) || trmt_outcome=="undefined" || trmt_outcome==undefined){
								if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
									for(k=0;k<applicable_trmt_types.length;k++){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];

										}
									}		
								}
								else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
									//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
										 for(k=0;k<applicable_trmt_types.length;k++){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
									 }
								} 
							else{
								//added by parul on 03/02/2010 for CRF-442
									if(return_surface_alert=="Y"){
										for(k=0;k<applicable_trmt_types.length;k++){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){ //Denture is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
										//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
										}//end		
									}else{
										for(k=0;k<applicable_trmt_types.length;k++){
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
											params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
											xmlHttp.send(xmlDoc);
											var retVal = trimString(xmlHttp.responseText); 
											retVal = localTrimString(retVal); 
											if(retVal.length >1){
												var retVal_arr = retVal.split("~");
												for(m=0;m<retVal_arr.length-1;m++){
													var code_desc_arr = retVal_arr[m].split("##");
													if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
														if(code_desc_arr[0] == "PARERTH"){
															if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
															else{
																applicable_trmt_types_arr[k] = "";
															}
														}
														else{
															if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
															}
														}
													}
													else{
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
												}
											}
											else{
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" ||applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}
									}//parul
							}
						}else{
							 if(denture_removable=="Y"){
									for(k=0;k<applicable_trmt_types.length;k++){
										if(applicable_trmt_types[k] == "DENTURE" ){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}else{
									//if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT" || trmt_type =="MAXILLA"){ //Commented by Sridevi Joshi on 3/5/2010 for CRF-478
									if(trmt_type=="EXTRACT" || trmt_type =="IMPLANT"){
										
										for(y=0;y<applicable_trmt_types.length;y++){
											if( applicable_trmt_types[y] != "BRIDGE" && applicable_trmt_types[y] != "ORTHO"){
												applicable_trmt_types_arr[y] = applicable_trmt_types[y];
											}
										}
									}
									else if(trmt_type=="MAXILLA" || trmt_type=="ORTHO"){ //Added by Sridevi Joshi on 3/5/2010 for IN10871(CRF-478)
										if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && (document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined")){
											
											for(y=0;y<applicable_trmt_types.length;y++){

												if(applicable_trmt_types[y] == "DENTURE"){
													applicable_trmt_types_arr[y] = applicable_trmt_types[y];
												}
											}
										}
									}
									//Added by Sharon Crasta on 3/3/2010 for SRR20056-CRF-0475(IN010868)
									else if(trmt_type == "BRIDGE"){
										for(var z = 0;z < applicable_trmt_types.length; z++){
											if(applicable_trmt_types[z] != "BRIDGE"){
												applicable_trmt_types_arr[z] = applicable_trmt_types[z];
											}
										}
									}//End
								}
						}
					}
			}else{
				 if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
							for(k=0;k<applicable_trmt_types.length;k++){
								if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
								//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];

								}
							}		
						}
						else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
							//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
								 for(k=0;k<applicable_trmt_types.length;k++){
									
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								 }
						}
					else{
						
						//added by parul on 03/02/2010 for CRF-442
							if(return_surface_alert=="Y"){
								for(k=0;k<applicable_trmt_types.length;k++){
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" || applicable_trmt_types[k] == "DENTURE"){ //Denture is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}//end		
							}else{
								for(k=0;k<applicable_trmt_types.length;k++){
									var xmlDoc = "" ;
									var xmlHttp = new XMLHttpRequest();
									params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal = trimString(xmlHttp.responseText); 
									retVal = localTrimString(retVal); 

									if(retVal.length >1){
										var retVal_arr = retVal.split("~");
										for(m=0;m<retVal_arr.length-1;m++){
											var code_desc_arr = retVal_arr[m].split("##");
											if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
												if(code_desc_arr[0] == "PARERTH"){
													if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														applicable_trmt_types_arr[k] = "";
													}
												}
												else{
													if(applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE"){ //Denture condition is added by Sridevi Joshi on 2/24/2010 for IN010871(SRR20056-CRF-0478)
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
											}
											else{
												if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT" ||applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							}
					}
			}
		}
	}
	else if(site == "TOOTH"){ // For site type other than Tooth Range
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;

		var applicable_trmt_types_temp = applicable_trmt_types;//Added by Sridevi Joshi on 3/12/2010 for IN019934 only for Extraction case to get the Implant in the menu on Extraction failure--->Extraction Success
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=ChkOutComeTreatments&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&super_tooth_ref="+flag1+"&retained_tooth_no="+retained_tooth_no+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_outcome = trimString(xmlHttp.responseText); 
		retVal_outcome = localTrimString(retVal_outcome); 

		if(retVal_outcome.length > 1){
			var retVal_outcome_arr = retVal_outcome.split("~");
				for(var j=0;j<retVal_outcome_arr.length-1;j++){
					var code_desc_arr = retVal_outcome_arr[j].split("##");
					var trmt_type = code_desc_arr[0];
					var trmt_outcome = code_desc_arr[1];
					var denture_removable = code_desc_arr[2];
					
					if(trmt_outcome != "F"){
						if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
							for(k=0;k<applicable_trmt_types.length;k++){
								if (trmt_type=="TOOTHTM"){//if TOOTHTM is S ,should not populate on menu
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "ORTHO"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}else{
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}		
						}
						//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
						else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){
						  for(k=0;k<applicable_trmt_types.length;k++){
								if (trmt_type=="TOOTHTM"){//if TOOTHTM is S ,should not populate on menu
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "ORTHO"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}else{
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
							}		
						}
						//End
						else{
							for(k=0;k<applicable_trmt_types.length;k++){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText); 
								retVal = localTrimString(retVal);
								if(retVal.length >1){
									var parerth_YN = "N"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
									var retVal_arr = retVal.split("~");
									for(m=0;m<retVal_arr.length-1;m++){
										var code_desc_arr = retVal_arr[m].split("##");
										/* Commented to add status != "Z" for unerruted tooth when retained deciduous tooth is recorded */
										//if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
										
										if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
											if(code_desc_arr[0] == "PARERTH"){
												if(trmt_type =="DENTURE"){
													if(applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												}
												else{
													if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}

												parerth_YN = "Y"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
											}
											else{
												if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
													if(trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}
													else{
														if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
												}
												else{
													if(trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}
													else{
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
												}
											}
										}
										//else if(((code_desc_arr[0] == "UNERTH" && code_desc_arr[5] != "Z") || (code_desc_arr[0] == "PARERTH" && code_desc_arr[5] != "Z") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
										else if(((code_desc_arr[0] == "UNERTH") || (code_desc_arr[0] == "PARERTH" ) || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
											if(code_desc_arr[0] == "PARERTH"){
												if(trmt_type =="IMPACT" ){
													if(applicable_trmt_types[k] == "IMPLANT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												
												}else if (trmt_type =="DENTURE"){
													if(applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												}
												else{
													if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
												}
												parerth_YN = "Y"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
											}
											else{
												if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
													if(trmt_type =="IMPACT" ){
														if(applicable_trmt_types[k] == "IMPLANT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													
													}else if (trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}
													else{
														if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
												}
												else{
													if(trmt_type =="IMPACT" ){
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													
													}else if (trmt_type =="DENTURE"){
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
														else{
															 applicable_trmt_types_arr[k] = "";
														 }
													}
													else{
														if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}
													}
												}
											}
										}
										else{
											if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
												if(trmt_type =="DENTURE"){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
													if(applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												 }
												 else if(trmt_type =="IMPLANT" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
													if(applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												 }
												 else if (trmt_type =="TOOTHTM"){
													if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/30/2010 for IN020375
														if(applicable_trmt_types[k] == "EXTRACT"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
																applicable_trmt_types_arr[k]="";
														}
													}
													else{
														if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
																applicable_trmt_types_arr[k]="";
														}
													}
													
												}
												else{
													if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}else{
														 applicable_trmt_types_arr[k] = "";									
													}
													
												}
											}
											else{
												if(trmt_type =="DENTURE"){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
													if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												 }
												 else if(trmt_type =="IMPLANT" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
													if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
															applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}
													else{
														 applicable_trmt_types_arr[k] = "";
													 }
												 }
												 else if (trmt_type =="TOOTHTM"){
													if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/30/2010 for IN020375
														if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "DENTURE"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
																applicable_trmt_types_arr[k]="";
														}
													}
													else{
														if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
																applicable_trmt_types_arr[k] = applicable_trmt_types[k];
														}else{
																applicable_trmt_types_arr[k]="";
														}
													}
													
												}
												else{
													if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
													}else{
														 applicable_trmt_types_arr[k] = "";									
													}
													
												}
											}
										}
									}
								}
								else{
									if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
										if (trmt_type =="IMPACT" ){
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
											else{
												 applicable_trmt_types_arr[k] = "";
											 }
										}else if (trmt_type =="DENTURE"){
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
											else{
												 applicable_trmt_types_arr[k] = "";
											 }
										}
										else{
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
									}
									else{
										if(trmt_type=="IMPLANT"){
											 if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											 }
											 else{
												 applicable_trmt_types_arr[k] = "";
											 }
											
										 } 
										 else if (trmt_type =="DENTURE" ){//Added by Sridevi Joshi on 2/26/2010 for IN010871(SRR20056-CRF-0478)
											 if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE"){ 
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											 }
											 else{
												 applicable_trmt_types_arr[k] = "";
											 }
										 } 
										 else if (trmt_type =="EXTRACT" ){//Added by Sridevi Joshi on 3/12/2010 for IN019934
											 if(applicable_trmt_types_temp[k] == "DENTURE" || applicable_trmt_types_temp[k] == "BRIDGE" || applicable_trmt_types_temp[k] == "IMPLANT"){ 
												applicable_trmt_types_arr[k] = applicable_trmt_types_temp[k];
											 }
											 else{
												 applicable_trmt_types_arr[k] = "";
											 }
										 } 
										 else if (trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
											 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											 } 
											 else if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];

											 }
										 }	//End
										 else{
											 if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];

											 }
										 }
									}
								}
							}	
						}
				}else{
					for(k=0;k<applicable_trmt_types.length;k++){
						//Added by SrideviJoshi on 5/7/2010 for IN021149
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText); 
						retVal = localTrimString(retVal);

						if(retVal.length >1){
							//var parerth_YN = "N"; //Added by Sridevi Joshi on 4/1/2010 for IN020441--for IMPACTION cond-->PARERTH-->IMPACTION cond-->IMPACTION trmt
							var retVal_arr = retVal.split("~");
							for(m=0;m<retVal_arr.length-1;m++){
								var code_desc_arr = retVal_arr[m].split("##");
								if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
									if(code_desc_arr[0] == "PARERTH"){
										if(trmt_type=="EXTRACT"){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
										else if (trmt_type =="ORTHO"){
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}else{
													applicable_trmt_types_arr[k]="";
											}
										}
										else if (trmt_type =="TOOTHTM"){
											if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/12/2010
												if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}else{
														applicable_trmt_types_arr[k]="";
												}
											}
											else{
												if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}else{
														applicable_trmt_types_arr[k]="";
												}
											}
											
										}
										else if(trmt_type=="IMPACT"){//added by parul on 11/03/2010 for IN19552
											if(applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
										else{
											if(trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
												 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
														applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												 } 
												 else if(applicable_trmt_types[k] == "BRIDGE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];

												 }
											}//End
											else{
												if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}
										}	
									}
									else{
									}
								}
								else{
									if(trmt_type=="EXTRACT"){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "TOOTHTM"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
										
									}else if (trmt_type =="ORTHO"){
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}else{
												applicable_trmt_types_arr[k]="";
										}
										
									}
									else if (trmt_type =="TOOTHTM"){
										if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/12/2010
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "DENTURE"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}else{
													applicable_trmt_types_arr[k]="";
											}
										}
										else{
											if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}else{
													applicable_trmt_types_arr[k]="";
											}
										}
										
									}
									else if(trmt_type=="IMPACT"){//added by parul on 11/03/2010 for IN19552
										if(applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									else{
										if(trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
										
											 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											 } 
											 else if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];

											 }
										}//End
										else if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
											if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
											}
										}
										
										else{
											if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){
											   if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}
											}else{
												if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
													applicable_trmt_types_arr[k] = applicable_trmt_types[k];
												}									
											}									
										}
									}
								}
							}
						}
						else{//Added by Sridevi Joshi on 5/14/2010 for IN021395.. was not getting menu on Abutment tooth
							if(trmt_type=="EXTRACT"){
								if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "TOOTHTM"){
									applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}else if (trmt_type =="ORTHO"){
								if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}else{
										applicable_trmt_types_arr[k]="";
								}
								
							}
							else if (trmt_type =="TOOTHTM"){
								if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){//Addded by Sridevi Joshi on 3/12/2010
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "DENTURE"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}else{
											applicable_trmt_types_arr[k]="";
									}
								}
								else{
									if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}else{
											applicable_trmt_types_arr[k]="";
									}
								}
								
							}
							else if(trmt_type=="IMPACT"){//added by parul on 11/03/2010 for IN19552
								if(applicable_trmt_types[k] == "IMPACT" || applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
								}
							}
							else{
								if(trmt_type == "BRIDGE" ){//Added by Sharon Crasta on 3/2/2010 for IN010868(SRR20056-CRF-0475)
								
								 	 if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO" ){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									 } 
									 else if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];

									 }
								}//End
								else if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
									if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
								}
								
								else{
                                    if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" ) && document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" ){
                                       if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}else{
										if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}									
									}									
								}
							}
						}
					}
				}

				if(applicable_trmt_types_arr!=""){
					applicable_trmt_types=applicable_trmt_types_arr;
				}
			}
		}
		else{
			if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
					for(k=0;k<applicable_trmt_types.length;k++){
							if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];
							}
					}
				}
				else if((document.getElementById(tooth_layer) == null || document.getElementById(tooth_layer) == "null" || document.getElementById(tooth_layer) == undefined || document.getElementById(tooth_layer) == "undefined") && document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined"){//Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
					//When Bridge is recorded on case of Abutments, the menu to be displayed on them are Extaction and Tooth Trmt.
				  for(k=0;k<applicable_trmt_types.length;k++){
						if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
							applicable_trmt_types_arr[k] = applicable_trmt_types[k];
						}
					}		
				} //End
				else{
				for(k=0;k<applicable_trmt_types.length;k++){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					params = "func_mode=allConditionsRecorded&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText); 
					retVal = localTrimString(retVal); 
					if(retVal.length >1){
						var parerth_YN = "N"; //Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
						var retVal_arr = retVal.split("~");
						for(m=0;m<retVal_arr.length-1;m++){
							var code_desc_arr = retVal_arr[m].split("##");
							/* Commented to add status != "Z" for unerruted tooth when retained deciduous tooth is recorded */
							//if((code_desc_arr[0] == "UNERTH" || code_desc_arr[0] == "PARERTH" || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
							if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
								if(code_desc_arr[0] == "PARERTH"){
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									else{
										applicable_trmt_types_arr[k] = "";
									}
									parerth_YN = "Y";//Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
								}
								else{
									if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
										if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									parerth_YN = "N";//Added by Sridevi Joshi on 4/1/2010 for IN020441-- not to get denture menu if Impaction--->Parerth---> impaction is recorded
								}
							}
							//else if(((code_desc_arr[0] == "UNERTH" && code_desc_arr[5] != "Z") || (code_desc_arr[0] == "PARERTH" && code_desc_arr[5] != "Z") || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
							else if(((code_desc_arr[0] == "UNERTH") || (code_desc_arr[0] == "PARERTH" ) || code_desc_arr[0] == "IMPACTN") && code_desc_arr[4] != "Y"){
								if(code_desc_arr[0] == "PARERTH"){
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
											applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									}
									else{
										applicable_trmt_types_arr[k] = "";
									}
									parerth_YN = "Y";//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
								}
								else{
									if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
										if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
									else{
										if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
												applicable_trmt_types_arr[k] = applicable_trmt_types[k];
										}
									}
								}
							}
							else{
								if(parerth_YN == "Y"){//Added by Sridevi Joshi on 4/1/2010 for IN020441(for Retained deciduous case)
									if(applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									 }
								}
								else{
									if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
										applicable_trmt_types_arr[k] = applicable_trmt_types[k];
									 }
								}
							}
						}
					}
					else{
						if(tooth_no == '1' || tooth_no == '16' || tooth_no == '17' || tooth_no == '32'){
							if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPACT"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];
							}
						}
						else{
							 if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT"){
								applicable_trmt_types_arr[k] = applicable_trmt_types[k];

							 }
						}
					}
				}	
			}
		}
	}
	else{ // for site other than Tooth and THRNG
		var oh_chart_level = document.forms[0].oh_chart_level.value;
		
		for(k=0;k<applicable_trmt_types.length;k++){
			applicable_trmt_types_arr[k] = applicable_trmt_types[k];
		}  
	}
	applicable_trmt_types = applicable_trmt_types_arr

	
		/*
		tooth_layer = "toothLayer"+tooth_no;
		root_layer = "rootLayer"+tooth_no;

		if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
			for(k=0;k<applicable_trmt_types.length;k++){
				if(applicable_trmt_types[k] == "EXTRACT" || applicable_trmt_types[k] == "TOOTHTM" || applicable_trmt_types[k] == "ORTHO"){
				//if(applicable_trmt_types_arr[k] != "DENTURE" && applicable_trmt_types_arr[k] != "BRIDGE" && applicable_trmt_types_arr[k] != "IMPLANT" && applicable_trmt_types_arr[k] != "IMPACT"){
					applicable_trmt_types_arr1[k] = applicable_trmt_types[k];
				}
			}		
		}
		else{
			for(k=0;k<applicable_trmt_types.length;k++){
				//if(applicable_trmt_types_arr[k] != "EXTRACT" && applicable_trmt_types_arr[k] != "TOOTHTM" && applicable_trmt_types_arr[k] != "ORTHO"){
				if(applicable_trmt_types[k] == "DENTURE" || applicable_trmt_types[k] == "BRIDGE" || applicable_trmt_types[k] == "IMPLANT" || applicable_trmt_types[k] == "IMPACT"){
					applicable_trmt_types_arr1[k] = applicable_trmt_types[k];
				}
			}	
		}
		*/
	
/*
	for(k=0;k<applicable_trmt_types_arr.length;k++){
		//if(applicable_trmt_types_arr[k] == "BRIDGE"){
			if(site == "THRNG"){
				var thrng_nos_ref_arr = thrng_nos_ref.split(",");
				for(j=0;j<thrng_nos_ref_arr.length;j++){
					tooth_layer = "toothLayer"+thrng_nos_ref_arr[j];
					root_layer = "rootLayer"+thrng_nos_ref_arr[j];
					if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
						
						//if(applicable_trmt_types_arr[k] != "BRIDGE"){
							applicable_trmt_types_arr1[k] = applicable_trmt_types_arr[k];
						//}
					}
					
				}
			}
		//}
	}
	
*/

	return applicable_trmt_types;

}

function resultTrmtMenuOptions(applicable_trmt_types,applicable_trmt_desc,tooth_no,mixed_dentition_YN,permanent_deciduous_flag,display_menu_yn,arch_quad,site){
	temp_array = new Array();
	temp_array_desc = new Array();
	//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0498(IN010982) to filter Denture when MAlOCLN is recorded on the Arch
	//for(i=0; i<applicable_trmt_types.length; i++ ){
		var patient_id= document.forms[0].patient_id.value;
		var chart_num= document.forms[0].chart_num.value;
		var oh_chart_level= document.forms[0].oh_chart_level.value;
		var other_chart_facility_id= document.forms[0].other_chart_facility_id.value;

		if(site == "ARCH"){
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_quad_arch = "func_mode=allConditionsRecordedForArchQuad&arch_quad="+arch_quad+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_quad_arch,false);
			xmlHttp.send(xmlDoc);
			var retVal_quad_arch = trimString(xmlHttp.responseText); 
			retVal_quad_arch = localTrimString(retVal_quad_arch);
			if(retVal_quad_arch.length > 1){
				var retVal_quad_arch_arr = retVal_quad_arch.split("~");
				for(m = 0; m < retVal_quad_arch_arr.length-1; m++){
					var code_desc_quad_arch_arr = retVal_quad_arch_arr[m].split("##");
					temp_array = new Array();
					temp_array_desc = new Array();
					for(i=0; i<applicable_trmt_types.length; i++ ){
					
					if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
						if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
							if(code_desc_quad_arch_arr[m] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){ //Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
						else{ //For Mixed Dentition - Permanent Chart
							if(code_desc_quad_arch_arr[m] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
							  if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
					}
					else{ // Other than Mixed Dentition case
						if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
							if(code_desc_quad_arch_arr[0] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
								if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
										
								}
							}
							else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
								if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
										
								}
							}
						}
						else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
								if(code_desc_quad_arch_arr[0] == "MALOCLN" && applicable_trmt_types[i] != "DENTURE"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
								else if(code_desc_quad_arch_arr[0] != "MALOCLN"){
									temp_array[i] = applicable_trmt_types[i];
									temp_array_desc[i] = applicable_trmt_desc[i];
								}
							}
						}
					}
					applicable_trmt_types = temp_array;
					applicable_trmt_desc = temp_array_desc;
					
				}
			} 
			else{
				for(i=0; i<applicable_trmt_types.length; i++ ){
				  if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
							if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
							}
						}
						else{ //For Mixed Dentition - Permanent Chart
							if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE"){//Denture condition is added by Sridevi Joshi on 4/26/2010 for IN020926
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
							}
						}
					}
					else{ // Other than Mixed Dentition case
						if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
							if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
								temp_array[i] = applicable_trmt_types[i];
								temp_array_desc[i] = applicable_trmt_desc[i];
									
							}
						}
						else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
				}
			}
		} //End
		else{
			//Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475
			//Menu should be displayed once the pontic is cut or when the Bridge is marked as Failure.
			var pontic_tooth = new Array();
			var pontic_tooth_split_values = new Array();

			var flag_for_bridge = "";
			var flag_for_bridge_thrng_pontic = "";
			var flag_for_bridge_thrng_abutment = "";
			var return_surface_alert = "N";

			var abutment_tooth_values = new Array();
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
			xmlHttp.send(xmlDoc);
			var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
			retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getOutcomeForExtraction&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_outcome_ext = trimString(xmlHttp.responseText); 
			retVal_outcome_ext = localTrimString(retVal_outcome_ext);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
			xmlHttp.send(xmlDoc);
			var retVal_category_type = trimString(xmlHttp.responseText); 
			retVal_category_type = localTrimString(retVal_category_type);
			pontic_tooth = retVal_category_type.split(",") ;
			var j =0;

			for (var i = 0; i < pontic_tooth.length;i++)
			{
				pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
			}
			var bridge_length =  pontic_tooth_split_values.length-1;
			/*if(site == "THRNG"){ // Tooth Range
				var nos_array = thrng_nos_ref.split(",");
				for(var k = 0; k < nos_array.length;k++){
					 if((pontic_tooth_split_values[0] == nos_array[k]) || (pontic_tooth_split_values[bridge_length] == nos_array[k])) 
					 { 
						flag_for_bridge_thrng_abutment = "A";
						break;
					 }
					 else{
						flag_for_bridge_thrng_pontic = "P";
					 }
					 
				}
				 flag_for_bridge_thrng = flag_for_bridge_thrng_abutment+"##"+flag_for_bridge_thrng_pontic;
			}
			else{*/
				for(var j = 0; j < pontic_tooth_split_values.length;j++){
					if((pontic_tooth_split_values[j] == tooth_no) && (j == 0 || j == pontic_tooth_split_values.length-1)) { 
						flag_for_bridge = "A";
						break;
					}else{
						flag_for_bridge = "P";
						 }		    
					} 
				//}
			var pontic_tooth_no = "";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params_pontic = "func_mode=getPonticValuesForMenu&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic,false);
			xmlHttp.send(xmlDoc);
			var retVal_pontic_arr = trimString(xmlHttp.responseText); 
			retVal_pontic_arr = localTrimString(retVal_pontic_arr);
			var retVal_pontic = retVal_pontic_arr.split("$$");
			for(var j =0; j < retVal_pontic.length; j++){
				if(retVal_pontic[j] == tooth_no){
					pontic_tooth_no = retVal_pontic[j];
					break;
				}
			}
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=ChkAllsurfaceForMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_surface = localTrimString(xmlHttp.responseText);
			if (retVal_surface=="*A"){
				return_surface_alert = "Y";
			}

			var root_layer = "rootLayer"+tooth_no;
			var tooth_layer = "toothLayer"+tooth_no;
			//End
			for(i=0; i<applicable_trmt_types.length; i++ ){
				if(mixed_dentition_YN == "Y"){ // For Mixed Dentition Case
					if(permanent_deciduous_flag == "D"){ // For Mixed Dentition - Deciduous Chart
						if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE"){ //Denture condition is Added by Sridevi Joshi on 3/1/2010 for IN010871(SRR20056-CRF-0478)
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
					else{ //For Mixed Dentition - Permanent Chart
						if(applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE"){//Denture condition is Added by Sridevi Joshi on 3/1/2010 for IN010871(SRR20056-CRF-0478)
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
					}
				}
				else{ // Other than Mixed Dentition case
					if(permanent_deciduous_flag == "D"){ // For Deciduous Chart
						if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "BRIDGE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
							temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
								
						}
					}
					else if(permanent_deciduous_flag == "P"){ //For Permanent Chart
						//Added by Sharon Crasta on 3/2/2010 for SRR20056-CRF-0475
						// Only if the pontic is cut, then the menu should be displayed for it.
						if(retVal_category_type.length != 0){ //Bridge recording done.
							if(flag_for_bridge == "A"){
								//Written this code so that if Bridge is recorded in Trmt Tab, then not showing Extraction in the menu for External Trmt Tab
								
								if((retVal_outcome_ext != "F" &&  document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined") || return_surface_alert == "Y" ) {
									if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" &&  applicable_trmt_types[i] != "EXTRACT" ){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								}//End
								 else if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" ){
									if(applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								}
								else if(document.getElementById(root_layer) == null || document.getElementById(root_layer) == "null" || document.getElementById(root_layer) == undefined || document.getElementById(root_layer) == "undefined" ){
								  // if(applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
								   if(applicable_trmt_types[i] != "ORTHO"){
									  temp_array[i] = applicable_trmt_types[i];
									  temp_array_desc[i] = applicable_trmt_desc[i];
									}
								} 
							}else{
								//if(retVal_pontic_arr.length > 0){	// if pontic is cut.
									//for(var j =0; j < retVal_pontic.length; j++){
									if(pontic_tooth_no == tooth_no){  // Cut pontic
										if(applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM"){
											
												temp_array[i] = applicable_trmt_types[i];
												temp_array_desc[i] = applicable_trmt_desc[i];
											}
										} 
										
									else if(flag_for_bridge == "P"  && (pontic_tooth_no == tooth_no)) {
											//if (applicable_trmt_types[i] != "ORTHO" || applicable_trmt_types[i] == "DENTURE") {
											
											if (applicable_trmt_types[i] != "ORTHO") {
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
											}
										}
										//else if(flag_for_bridge_thrng.indexOf("A") != -1){
										
										else if(retVal_outcome_ext != "F" &&  flag_for_bridge == "P" && (pontic_tooth_no != tooth_no)) {
											
											//if (applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPLANT" ) {
											if (applicable_trmt_types[i] != "ORTHO" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM") {
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
											}
										}
										
										else if(retVal_outcome_ext == "F" &&  flag_for_bridge == "P" && applicable_trmt_types[i] != "EXTRACT" && applicable_trmt_types[i] != "TOOTHTM"  && (applicable_trmt_types[i] == "DENTURE" || applicable_trmt_types[i] == "IMPACT" || applicable_trmt_types[i] == "IMPLANT" || applicable_trmt_types[i] == "BRIDGE")) {
										
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];		
										}
										else if(flag_for_bridge != "P" &&  applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT" && applicable_trmt_types[i] != "ORTHO"){
											
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
										}
										else if(retVal_category_type.length == 0){	// Not Bridge
											  temp_array[i] = applicable_trmt_types[i];
											  temp_array_desc[i] = applicable_trmt_desc[i];
										
										}
										else if (flag_for_bridge != "P" && applicable_trmt_types[i] != "DENTURE" && applicable_trmt_types[i] != "IMPACT" && applicable_trmt_types[i] != "IMPLANT"){
											
										  temp_array[i] = applicable_trmt_types[i];
										  temp_array_desc[i] = applicable_trmt_desc[i];
									}
									
								}
						}else{  
						    temp_array[i] = applicable_trmt_types[i];
							temp_array_desc[i] = applicable_trmt_desc[i];
						}
						
					}
				}
			}
		}
		applicable_trmt_types = temp_array;
		applicable_trmt_desc = temp_array_desc;

		return applicable_trmt_types;
}

/* Added by Sridevi Joshi on 12/8/2009 to refresh each cell when clicked on tooth_no (SUPRTH new Changes)*/
function refreshCondTreatments(thrng_nos_ref,site_type,flag1,flag){
	var formObj = document.forms[0];
	var super_tooth_count = "";
	var super_tooth_no = "";
	var retained_tooth_no = "";
	var imageSrc = "";
	var isSuperYN = "N";
	var isRetainedYN = "N";
	var exfolth_count = "0";
	var rd_super_flag="";
	var retVal_SuperKey_count = 0;
	var total_SuperKey_count = 0;
	var super_recorded = "N";

	var tooth_no = thrng_nos_ref;

	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;

	var tab_name = getTabNames();

	if(flag1 != "" && flag1 != "undefined" && flag1 != undefined && flag1 != "RD"){ //Added by Sridevi Joshi on 1/22/2010 for IN010894
		super_tooth_count = flag1.substring(1);
	}

	if(super_tooth_count != ""){
		super_tooth_no = thrng_nos_ref+super_tooth_count;
	}

	//Added by Sridevi Joshi on 12/8/2009 for SUPRTH new changes
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_cond = trimString(xmlHttp.responseText); 
	retVal_cond = localTrimString(retVal_cond); 
	var retVal_cond_arr = retVal_cond.split("##");
	var condition_type_ref = retVal_cond_arr[1];
	if(condition_type_ref == "SUPRTH"){
		isSuperYN = "Y";
	}else if(condition_type_ref == "RTDESTH"){
		isRetainedYN = "Y";
	}

	if (flag1=="RD"){
		 rd_super_flag="RD";
	}
	/*else if(flag1 != "" && flag1 != "undefined" && flag1 != undefined){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
		//rd_super_flag = flag1;
	}*/
	else if(isRetainedYN == "Y" && flag1 != "RD"){
		rd_super_flag="NR";
	}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y" && isSuperYN=="Y" && flag == "MR"){
        rd_super_flag="MR";
	}
	else{
		 rd_super_flag="";
	}
        
	if(isSuperYN == "Y" || isRetainedYN == "Y"){
		//To retrieve chart_line_num if SUPRTH is recorded
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
		xmlHttp.send(xmlDoc);
		var suprth_chart_line_num = trimString(xmlHttp.responseText);
		suprth_chart_line_num = localTrimString(suprth_chart_line_num);
		if(suprth_chart_line_num.length > 0){
			super_recorded = "Y";
		}

		if(flag != ""){ //Added by Sridevi Joshi on 5/4/2010 for IN021121
			//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_SuperKey = trimString(xmlHttp.responseText); 
			retVal_SuperKey = localTrimString(retVal_SuperKey); 
			var retVal_SuperKey_arr = retVal_SuperKey.split("~");

			retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
			
			total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
		}
		
		if(flag1 == "RD"){//Added by Sridevi Joshi on 5/4/2010 for IN021121
			//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes TO GET mapped tooth no
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=getMappedToothNo&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var mapped_tooth_no = trimString(xmlHttp.responseText); 
			mapped_tooth_no = localTrimString(mapped_tooth_no); 
			if(mapped_tooth_no.length > 0 && !(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y")){
				if(flag1 == "RD"){//Added by Sridevi Joshi on 12/17/2009 for RTDESTH new changes
					retained_tooth_no = mapped_tooth_no;
				}
			}
		}
		//To retrieve the display tooth_no and the tooth_name...
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		if(retVal.length > 1){
			var retVal_arr = retVal.split("##");
			tooth_num = retVal_arr[0];
			tooth_name = retVal_arr[1];
			mapped_tooth_no = retVal_arr[2];
			mixed_dent_tooth_no = retVal_arr[3];
		}

		if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
			//To retrieve chart_line_num if ERUPTH is recorded
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=RTDESTH";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
			xmlHttp.send(xmlDoc);
			var rtdesth_chart_line_num = trimString(xmlHttp.responseText);
			rtdesth_chart_line_num = localTrimString(rtdesth_chart_line_num);


			//To retrieve chart_line_num if ERUPTH is recorded
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=ERUPTH";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
			xmlHttp.send(xmlDoc);
			var erupth_chart_line_num = trimString(xmlHttp.responseText);
			erupth_chart_line_num = localTrimString(erupth_chart_line_num);

			if(erupth_chart_line_num.length > 0){ //This is to change the ROOT image if tooth is Erupted(specially when we click on super tooth)
				if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				else if(rtdesth_chart_line_num > 0 && flag1 != "RD"){
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				else{
					var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
				}
			}
			else{
				if(tooth_no == "33" || tooth_no == "34"){
					var imageSrc = "../../eOH/images/R3.gif";
				}
				else if(tooth_no == "41" || tooth_no == "42"){
					var imageSrc = "../../eOH/images/R14.gif";
				}
				else if(tooth_no == "43" || tooth_no == "44"){
					var imageSrc = "../../eOH/images/R19.gif";
				}
				else if(tooth_no == "51" || tooth_no == "52"){
					var imageSrc = "../../eOH/images/R30.gif";
				}
				else{
					if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}else{
						var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
					}
				}
			}
		}
		else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "N"){
			if(tooth_no == "33" || tooth_no == "34"){
				var imageSrc = "../../eOH/images/R3.gif";
			}
			else if(tooth_no == "41" || tooth_no == "42"){
				var imageSrc = "../../eOH/images/R14.gif";
			}
			else if(tooth_no == "43" || tooth_no == "44"){
				var imageSrc = "../../eOH/images/R19.gif";
			}
			else if(tooth_no == "51" || tooth_no == "52"){
				var imageSrc = "../../eOH/images/R30.gif";
			}
			else{
				if(tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31"){
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}else{
					var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
				}
			}
		}
		else{
			var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
		}
	
		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){
			//To retrieve chart_line_num if DECITH is recorded
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=DECITH";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
			xmlHttp.send(xmlDoc);
			var decith_chart_line_num = trimString(xmlHttp.responseText);
			decith_chart_line_num = localTrimString(decith_chart_line_num);
			if(decith_chart_line_num.length > 0){
				//Added to count the number of Exfoliated conditions recorded in case of Retained.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+flag;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 0 && parseInt(retVal) > 0){ 
					var retVal_arr = retVal.split("##");
					exfolth_count = retVal_arr[0];			
				}

				//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_SuperKey = trimString(xmlHttp.responseText); 
				retVal_SuperKey = localTrimString(retVal_SuperKey); 
				var retVal_SuperKey_arr = retVal_SuperKey.split("~");

				retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
				
				total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also

				/*if(exfolth_count == 3){
					//Added to count the number of SUPRTH conditions recorded in case of Retained.
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal = localTrimString(retVal);
					if(retVal.length > 0 && parseInt(retVal) > 0){ 
						var retVal_arr = retVal.split("##");
						suprth_count = retVal_arr[0];			
					}

					if(suprth_count.length > 0 && parseInt(suprth_count) > 1){ //Refresh if more than one SUPRTH conitions are recorded(DECITH--->SUPRTH--->EXFOLTH both--->ERUPTH--->SUPRTH)
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

						formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
					}
				}
				else{*/
				if(exfolth_count != total_SuperKey_count){
					//To retrieve chart_line_num if SUPRTH is recorded
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithChrtLineNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var suprth_chart_line_num = trimString(xmlHttp.responseText);
					suprth_chart_line_num = localTrimString(suprth_chart_line_num);
					if(suprth_chart_line_num.length > 0 && flag == "D"){
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";
					}
					else{
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

					}
				}

				formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
			}else{
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

				formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
			}
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
			var ns_tooth_no = "";
			//To get Display_tooth_no
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+mapped_tooth_no+"&numbering_system="+tooth_numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				ns_tooth_no = retVal;
			}

			//if(flag1 != "RD" && flag1 != "s1" && flag1 != "s2" && isRetainedYN == "Y"){
			if(flag1 != "RD" && (flag1 == "" || flag1 == "undefined" || flag1 == undefined) && isRetainedYN == "Y"){
				//retained_tooth_no = ns_tooth_no;
				retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
			}

			//Added to count the number of Exfoliated conditions recorded in case of Retained.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=EXFOLTH&RD_Normal_yn="+flag;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfToothForSUPRTH&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 0 && parseInt(retVal) > 0){ 
				var retVal_arr = retVal.split("##");
				exfolth_count = retVal_arr[0];			
			}

			//Added by SRidevi Joshi on 1/27/2010 for IN010894(SRR20056-CRF-0481). To get super_key_val
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal_SuperKey = trimString(xmlHttp.responseText); 
			retVal_SuperKey = localTrimString(retVal_SuperKey); 
			var retVal_SuperKey_arr = retVal_SuperKey.split("~");

			retVal_SuperKey_count = parseInt(retVal_SuperKey_arr.length)-1;
			
			total_SuperKey_count = parseInt(retVal_SuperKey_count)+1; //this is to include tooth_no count also
			/*if(exfolth_count == 3){ //Coomented for SUPRTH--->EXFOLTH all 3--->click on permanent tooth getting root and crown images
				//Added to count the number of SUPRTH conditions recorded in case of Retained.
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 0 && parseInt(retVal) > 0){ 
					var retVal_arr = retVal.split("##");
					suprth_count = retVal_arr[0];			
				}

				if(suprth_count.length > 0 && parseInt(suprth_count) > 1){ //Refresh if more than one SUPRTH conitions are recorded(SUPRTH--->EXFOLTH both--->ERUPTH--->SUPRTH)
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

					//formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeaturesForNoImage('"+tooth_no+"','"+tooth_num+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
					formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
				}
			}
			else{*/
				if(exfolth_count != total_SuperKey_count){
					var imageId = "R"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

				}

				formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
		}
		else{
			if(flag1 == "RD"){
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

				formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
			}
			else{
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML = "<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+"','"+rd_super_flag+"','"+flag1+"')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";

				formObj.document.getElementById(tooth_no).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' onclick=\"getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+tooth_num+"','"+''+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+flag1+"');\" style='cursor:pointer'>&nbsp;</td></tr></table>";
			}
			
		}

		//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_SuperKey = trimString(xmlHttp.responseText); 
		retVal_SuperKey = localTrimString(retVal_SuperKey); 
		var retVal_SuperKey_arr = retVal_SuperKey.split("~");

		if(flag1 != "" && flag1 != "undefined" && flag1 != undefined && flag1 != "RD"){//Added by Sridevi Joshi on 1/22/2010 for IN010894
			document.getElementById(flag1 + "_super_font" + tooth_no).style.backgroundColor = "gray";
			document.getElementById(flag1 + "_super_font" + tooth_no).style.color = "white";
			document.getElementById("normal_font" + tooth_no).style.backgroundColor = "white";
			document.getElementById("normal_font" + tooth_no).style.color = "black";
			
			for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
				if(retVal_SuperKey_arr[y] != flag1){
					if(document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no) !== null){
						document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no).style.backgroundColor = "white";
						document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no).style.color = "black";
					}
				}
			}
		}
		else if(flag1 == "RD"){
			document.getElementById("retained_font" + tooth_no).style.backgroundColor = "gray";
			document.getElementById("retained_font" + tooth_no).style.color = "white";
            document.getElementById("normal_font"+tooth_no).style.backgroundColor = "white";
			document.getElementById("normal_font"+tooth_no).style.color = "black";
		}
		else{
			if(document.getElementById("normal_font"+tooth_no) != null){
				document.getElementById("normal_font"+tooth_no).style.backgroundColor = "gray";
				document.getElementById("normal_font"+tooth_no).style.color = "white";
			}
			
			if(document.getElementById("retained_font"+tooth_no) != null){
				document.getElementById("retained_font"+tooth_no).style.backgroundColor = "white";
				document.getElementById("retained_font"+tooth_no).style.color = "black";
			}

			for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
				if(retVal_SuperKey_arr[y] != flag1){
					if(document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no) !== null){
						document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no).style.backgroundColor = "white";
						document.getElementById(retVal_SuperKey_arr[y] + "_super_font" + tooth_no).style.color = "black";
					}
				}
			}
		}
		getAllImagesFromDB(thrng_nos_ref,super_tooth_no,'Y',exfolth_count,retained_tooth_no,flag1,total_SuperKey_count,super_recorded,flag);
	}
}

function showSuperTooth(site_colchk_val,tooth_no,flag,flag1){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	
	//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	params = "func_mode=checkSuperKey&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+flag;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_SuperKey = trimString(xmlHttp.responseText); 
	retVal_SuperKey = localTrimString(retVal_SuperKey); 
	var retVal_SuperKey_arr = retVal_SuperKey.split("~");

	/*if(retVal_SuperKey_arr.length > 1){
		var tab_dat = "<table id ='tooltiptable_rec' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
		for(var x=0;x<retVal_SuperKey_arr.length-1;x++){
			tab_dat     += "<tr id ='tooltiprow1'>";
			//tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id='tooltiplink1' href = \"javascript:populateMenuItems('"+site_colchk_val+"','" +flag+"','"+tooth_no+"','"+flag1+"');\"> "+retVal_SuperKey_arr[x]+ " </a></td>";
			tab_dat     += "<td class = 'OTMENULAYER' nowrap id='mouse' ><a id='tooltiplink1' href = \"javascript:refreshCondTreatments('"+tooth_no+"','" +site_colchk_val+"','"+flag1+"','"+flag+"');\"> "+retVal_SuperKey_arr[x]+ " </a></td>";
			tab_dat     += "</tr> ";
		}
		tab_dat     += "</table>";
	}*/
	//else{
		populateMenuItems(site_colchk_val,flag,tooth_no,flag1);//flag1 added by sridevi jsohi on 12/4/2009 for SUPRTH changes
	//}

	/*if(retVal_SuperKey_arr.length > 1){
		var tab_dat = "<ul id='menu'>"
		for(var x=0;x<retVal_SuperKey_arr.length-1;x++){
			tab_dat     += "<li><a href='#' title='Projects'>Projects</a>";
			//tab_dat     += "<a href = \"javascript:populateMenuItems('"+site_colchk_val+"','" +flag+"','"+tooth_no+"','"+flag1+"');\"> "+retVal_SuperKey_arr[x]+ " </a></td>";
			//tab_dat     += "<a href = \"javascript:dummyfunc();\"> "+retVal_SuperKey_arr[x]+ " </a></td>";
			tab_dat = "<ul><li>Sridevi</ul></li>"
			tab_dat     += "</li> ";
		}
		tab_dat     += "</ul>";
	}*/
	
	//var tab_dat ='<ul id="menu"><li><a href="#" title="Homepage" class="selected">Homepage</a></li><li><a href="#" title="About us">About us</a></li><li><a href="#" title="Projects">Projects</a><ul><li><a href="#" title="Older projects">Older projects</a><ul><li><a href="#" title="2003 projects">2003 projects</a></li><li><a href="#" title="2004 projects">2004 projects</a></li><li><a href="#" title="2005 projects">2005 projects</a></li></ul></li><li><a href="#" title="Active projects">Active projects</a><ul><li><a href="#" title="Leaf industries">Leaf industries</a></li><li><a href="#" title="Omnicron">Omnicron</a></li><li><a href="#" title="Unkown.com">Unkown.com</a></li></ul></li></ul>	</li><li><a href="#" title="Contact">Contact</a></li></ul>';
	//var tab_dat ='<ul id="menu"><a href = \"javascript:populateMenuItems();\" title="Older projects">Older projects</a><ul><li><a href = \"javascript:populateMenuItems();\" title="2003 projects">2003 projects</a></li><li><a href="#" title="2004 projects">2004 projects</a></li><li><a href="#" title="2005 projects">2005 projects</a></li></ul></ul>';
	


	//var schedule_label = "s1";

	

	//document.getElementById("menu_table1").innerHTML = tab_dat;
	//resizeWindow();
	//resizeSuperWindow1();

}

function dummyfunc(){

	document.getElementById("menu").style.display='none'
}

function resizeSuperWindow2(){
	
	document.getElementById("tooltiplayer1").style.visibility='visible'
}



function resizeSuperWindow1(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight
	var x =  event.x;
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*2)

	if(y<bodheight || event.y<150){
		if(event.y<150){
		  y =event.y-20
		}else if(event.y> 230){
		  y =event.y-20
		}
	}else{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*2)
	}

	
	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer1").style.posLeft= x
	document.getElementById("tooltiplayer1").style.posTop = y
		
	document.getElementById("tooltiplayer1").style.visibility='visible'
}

async function populateMenuOnSuper(tooth_no,disply_tooth_no,mixed_dent_deciduous_yn){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var super_tooth_ref = "";

	var url = "../../eOH/jsp/SelectSuperTooth.jsp?chart_num="+chart_num+"&patient_id="+patient_id+"&tooth_no="+tooth_no+"&disply_tooth_no="+disply_tooth_no+"&RD_Normal_yn="+mixed_dent_deciduous_yn;
	
	var dialogHeight = "15vh" ;
	var dialogWidth  = "45vw" ;
	var dialogTop    = "390";
	var dialogLeft   = "410";   
		
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	var super_tooth = await window.showModalDialog(url,null,features);

	var check_num_id = "check_num"+tooth_no;
	if(super_tooth != "" && super_tooth != "undefined" && super_tooth != undefined){
		if(super_tooth != tooth_no){
			super_tooth_ref = super_tooth;
		}

		if(super_tooth_ref == ""){
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+super_tooth_ref+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + super_tooth + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+mixed_dent_deciduous_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\">";
		}
		else{
			formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+super_tooth_ref+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+super_tooth_ref+"_super_font"+tooth_no+"' style='background-color:gray;color:white'>" + super_tooth + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+mixed_dent_deciduous_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\">";
		}

		refreshCondTreatments(tooth_no,"TOOTH",super_tooth_ref,mixed_dent_deciduous_yn);
	}
}

