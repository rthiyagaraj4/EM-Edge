//var new_encounter_already_created = false;

var hasChanged = false;
var isExfoliated = false;
var isDeciduousTooth = false;
var isDeciduous = false;
var isSuperYN = false;
var isRetainedDeciduous = false;
var isExfoliatedNorm = false;
var isExfoliatedRD = false;
var isSuperYN_super = false;
var isSuperYN_super_1 = false;
var isSuperYN_norm = false;																  
var isUNErupted = false;
var isExfoliatedDec = false;//Added by Sridevi Joshi on 4/7/2010

function expandMenu(obj,img_name){
	buildTable(obj);
	switchMenu(obj,img_name);
}

function buildTable(obj){
	var formObj = document.trmtViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var episode_type = formObj.episode_type.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var billing_appl_yn = formObj.billing_appl_yn.value;
	var chart_num = formObj.cur_chart_num.value;
	var otFlag = formObj.otFlag.value;
	
	var baseline_chart_yn = formObj.baseline_chart_yn.value;
	var locale = formObj.locale.value;
	var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value; 
	var treatment_date;
	var treatment_type;
	var index;

	//Added by Sharon Crasta on 3/14/2009 for Other Facility Chart CRF #0423
	var facility_id = formObj.facility_id.value;
	var tab_name = formObj.header_tab.value;
	var oh_chart_level =formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var other_facilitychart_yn = "Y";

	var dentist_comments = formObj.dentist_comments.value;
	/*
		menu1 (Treatments To Do)
		menu2....menu4 -> Kept it for future menus(if any)
		menu5 (Treatments Done)
		menuBC (Baseline Chart)
	*/
	var addnew_label = getLabel("Common.Add/New.label","Common");
	var closed_chart_label = getLabel("eOH.ClosedChart.Label","OH");//"Closed Chart";
	var active_chart_label =  getLabel("eOH.ActiveChart.Label","OH");//"Active Chart";

	if(obj!=null && obj!=""){
		//Added onMouseOver by Sharon Crasta on 1/22/2010 for SRR20056-CRF-0485(IN010920)
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center'  onMouseOver= 'hideToolTip();' >";//End
		if(obj=="menuBC"){
			// Display the 1st row as Add/New
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayNewChart(\'NEW\',\''+addnew_label+'\');\">'+addnew_label+'</a></div></td>';
			tab_dat     += "</tr> ";
		}

		if(obj=="menuOL"){ // Other Links
			//Display Individual Links, Diagnosis comes 1st
			var diagnosis_label = getLabel("Common.diagnosis.label","Common");
			var clinicalnotes_label = getLabel("Common.ClinicalNotes.label","Common");
			var lab_label = getLabel("Common.Laboratory.label","Common");
			var radiology_label = getLabel("Common.Radiology.label","Common");
			var link_orders_label = getLabel("eOH.LinkLabRadiologyOrders.Label","OH");
			
			var dentist_comments_label = getLabel("eOH.DentistComments.Label","OH");//Added by Sharon Crasta on 10/9/2009 for (IN012603)PMG20089-CRF-0700

			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openDiagnosis();\">'+diagnosis_label+'</a></div></td>';
			tab_dat     += "</tr> ";

			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openClinicalNotes();\">'+clinicalnotes_label+'</a></div></td>';
			tab_dat     += "</tr> ";
			
			//Added by Sharon Crasta on 10/8/2009 for PMG20089-CRF-0700
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=checkActiveChartExists&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
		
			if(retVal > 0){
				tab_dat     += "<tr>";
				tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				tab_dat     += '<td class="LABEL"><div align="left"><a id="dentist_comments" href=\"javascript:showDentistComments(\''+locale+'\');\">'+dentist_comments_label+'</a></div></td>';
				tab_dat     += "</tr> ";	
			} 
			// added by yadav for 476
			var maxilaFacialDetail_label = getLabel("eOH.MaxilaFacialDetails.Label","OH");
			var patient_id = document.forms[0].patient_id.value
			var chart_num = document.forms[0].cur_chart_num.value
			chart_num=trimString(chart_num)
			var locale = document.forms[0].locale.value
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&locale="+locale;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getMaxillaTreatmentFlag&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal="";
			retVal= trimString(xmlHttp.responseText);
			if(parseInt(retVal)>0){
			
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:showMaxilaFacialDtlTrmt();\">'+maxilaFacialDetail_label+'</a></div></td>';
			tab_dat     += "</tr> ";

			}


		}
		
		if(obj=="menu1"){ // Treatments To DO
		    //var isTrmt_super_tooth_no=0;
			var super_key_num = "";
			var total_payable_label = getLabel("eBL.TOTAL_PAYABLE.label","BL");
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Added by Sharon Crasta on 1/23/2010 for IN018302
			var asOnDate = parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].asOnDate.value;
			//End

			var params = "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&chart_num="+chart_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&patient_class="+patient_class+"&otFlag="+otFlag+"&asOnDate="+asOnDate+"&baseline_chart_yn="+baseline_chart_yn;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=populateTreatmentsToDo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			//alert("retVal------"+retVal)
			if(retVal.length>1){
				var retVal_arr = retVal.split("OH_SEP_2");
				var rownum=0;
				for(var i=0;i<retVal_arr.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arr[i].split("OH_SEP_1");
					if(code_desc_arr[9] == "THRNG" || (code_desc_arr[9]=="MAXFS" &&(code_desc_arr[15]==("TNGAB") || code_desc_arr[15]==("TNGGM") || code_desc_arr[15]==("TNGAG") || code_desc_arr[15]==("TNGGAM") || code_desc_arr[15]==("TNGMF")))){
						super_key_num = "";
					}
					else{
						super_key_num = code_desc_arr[19];
					}

					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;

					if(code_desc_arr[8] == null || code_desc_arr[8] == "null"){
						code_desc_arr[8] = "";
					}
					code_desc_arr[8] = escape(code_desc_arr[8]); //This is decode special characters.. In this case to decode space to %20
					
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse'+rownum+'" onclick=buildTasksTable("'+code_desc_arr[7]+'","'+rownum+'","'+code_desc_arr[3]+'","'+obj+'","'+code_desc_arr[6]+'","'+code_desc_arr[8]+'","'+code_desc_arr[11]+'","'+code_desc_arr[12]+'","'+code_desc_arr[13]+'","","'+super_key_num+'"); width="10%"><div align="center" style="cursor:pointer"><B>+</B></div></td>';
					
                    /*if (code_desc_arr[16].length>=2){//added by parul on 08/12/2009 for super change 
						isTrmt_super_tooth_no=code_desc_arr[16].substring(code_desc_arr[16].length-1,code_desc_arr[16].length);
					}*/
				//	alert("tab_dat------"+tab_dat)
					if(code_desc_arr[9] == "THRNG" || (code_desc_arr[9]=="MAXFS" &&(code_desc_arr[15]==("TNGAB") || code_desc_arr[15]==("TNGGM") || code_desc_arr[15]==("TNGAG") || code_desc_arr[15]==("TNGGAM") || code_desc_arr[15]==("TNGMF")))){
						if(code_desc_arr[4] == "NA"){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] != null && code_desc_arr[4] != "null" && code_desc_arr[4] != "")){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] == null || code_desc_arr[4] == "null" || code_desc_arr[4] == "")){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>';
						}
						else if(code_desc_arr[12] != "M" && code_desc_arr[12] != "D" && code_desc_arr[12] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[13] == "Y"){
							/*tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+'s:'+code_desc_arr[1]+')</a>';*/
						}
						else if(code_desc_arr[12] != "M" && code_desc_arr[12] != "D" && code_desc_arr[12] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[9]!="MAXFS"){ 
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
							}
						}
						else if((code_desc_arr[12] == "D" || code_desc_arr[12] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D") && code_desc_arr[9]!="MAXFS"){
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
							}
						}
						else if(code_desc_arr[13] == "Y"){
							/*tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':s'+code_desc_arr[1]+')</a>';*/

						}else if(code_desc_arr[9]=="MAXFS" ){
							var code_desc_arr_max="";
							var code_desc_arr_max_1="";
							var max_changed_num="";
							var retVal_num="";
							var retVal_num_1="";
							var tooth_no_num="";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var tootn_num=code_desc_arr[16];
								if (tootn_num.indexOf(",") != -1){
									var tootn_num_1=tootn_num.split(",");
									for(var p=0;p<tootn_num_1.length;p++){
										var code_desc_arr_num = tootn_num_1;
										var params1 = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr_num[p]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params1,false);
										xmlHttp.send(xmlDoc);
										var retVal_condition = trimString(xmlHttp.responseText);

										if(retVal_condition.length!=1){
											var xmlDoc = "" ;
											var xmlHttp = new XMLHttpRequest();
											var params2 = "tooth_no="+code_desc_arr_num[p]+"&numbering_system="+tooth_numbering_system;
											if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params2,false);
												xmlHttp.send(xmlDoc);
												retVal_num = localTrimString(xmlHttp.responseText);
												for(var b=0;b<retVal_num.length;b++){
													retVal_num_1 = retVal_num.split("##");										
												}

												if(isSuperYN_super_1!="true"){
														 retVal_num_1=retVal_num_1[0]
												}else{
													 //retVal_num_1=retVal_num_1[0]+"s";
												}
											}else{
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
												xmlHttp.send(xmlDoc);
												retVal_num_1 = localTrimString(xmlHttp.responseText);
												if (isSuperYN_super_1!="true"){
													 retVal_num_1=retVal_num_1
												}else{
													 //retVal_num_1=retVal_num_1+"s";
												}
											}
										}	
										
										if(retVal_condition.length > 1){
											var retVal_condition_arr = retVal_condition.split("~");
											for(var j=0;j<retVal_condition_arr.length-1;j++){
											var code_desc_arr_1 = retVal_condition_arr[j].split("##");
											if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
												
												if(code_desc_arr_1[0] == "SUPRTH"){
													isSuperYN = "true";
												}
												if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[4] == "Y"&& code_desc_arr_1[1] == "N"){
													isSuperYN_super = "true";

												}
												if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[4] == "Y"){
													isSuperYN_super_1 = "true";

												}
												if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
													isExfoliatedRD="true";

												}
												if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
													isExfoliatedNorm="true";

												}
												if(code_desc_arr_1[0] == "RTDESTH" ){
													isRetainedDeciduous = "true";
												}
											}
											else if (permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
											
											if(code_desc_arr_1[0] == "DECITH" &&  code_desc_arr_1[2] == "D" &&  code_desc_arr_1[4] == "N"){
												isDeciduous = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}
											
										
											}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
											
												if(code_desc_arr_1[0] == "DECITH" &&  code_desc_arr_1[2] == "D" &&  code_desc_arr_1[4] == "N"){
													isDeciduous = "true";

												}
												if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
													isExfoliatedRD="true";

												}
												if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "M"){
													isExfoliatedNorm="true";

												}
												if(code_desc_arr_1[0] == "PARERTH" && code_desc_arr_1[3] == "N"){
												isUNErupted="true";

												}
												if(code_desc_arr_1[0] == "RTDESTH" ){
													isRetainedDeciduous = "true";
												}
										
											}
										}
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+code_desc_arr_num[i]+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
											if (code_desc_arr_1[0]=="EXFOLTH" && permanent_deciduous_flag=="P"){
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
												xmlHttp.send(xmlDoc);
												retVal_num = trimString(xmlHttp.responseText);
												for(var g=0;g<retVal_num.length;g++){
													code_desc_arr_max = retVal_num.split("##");										
												}
											}else if (code_desc_arr_1[0]=="DECITH"  && permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y")
											{
												var xmlStr ="<root><SEARCH ";
												xmlStr +=" /></root>";
												xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
												xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
												xmlHttp.send(xmlDoc);
												retVal_num = trimString(xmlHttp.responseText);
												for(var u=0;u<retVal_num.length;u++){
													code_desc_arr_max = retVal_num.split("##");	
													code_desc_arr_max_1=code_desc_arr_max[0];
												}
											}
											
											
											else{
													var xmlStr ="<root><SEARCH ";
													xmlStr +=" /></root>";
													xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
													xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
													xmlHttp.send(xmlDoc);
													retVal_num = trimString(xmlHttp.responseText);
													for(var e=0;e<retVal_num.length;e++){
													code_desc_arr_max = retVal_num.split("##");
													
												}
											
											}
										
										if (isSuperYN_super=="true"){
											 //code_desc_arr_max_1=code_desc_arr_max[0]+"s";
										}else{
											 code_desc_arr_max_1=code_desc_arr_max[0];
										}
										
									}
																
								}
						
						if(isRetainedDeciduous=="true" && isExfoliatedRD=="true" && isExfoliatedNorm!="true" ){
								max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a>';
							}else if (isSuperYN=="true" && permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
								max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a>';

							//}else if (isSuperYN_super!="true" && permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
							}else if (isSuperYN_super=="true" && permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
								max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a>';

							}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
                               if(isDeciduous){
								max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a>';
							   }else {
							     	tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';

							   
							   }
							
							}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
								if (isRetainedDeciduous!="true" && isExfoliatedNorm=="true"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a>';
								}else if (isUNErupted=="true" && isRetainedDeciduous=="true"){
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';

								}
								else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';

								
								}

							}
							else {
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';

								}

							}
						}
						else{							
							//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')';

							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>';

						}	
					}
					else{
						if(code_desc_arr[4] == "NA"){
							//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[1]+')';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>';

						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] != null && code_desc_arr[4] != "null" && code_desc_arr[4] != "")){
							//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')';

							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] == null || code_desc_arr[4] == "null" || code_desc_arr[4] == "")){
							//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[1]+')';

							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>';
						}
						else if(code_desc_arr[12] != "M" && code_desc_arr[12] != "D" && code_desc_arr[12] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[13] == "Y"){
							//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[14]+'s:'+code_desc_arr[1]+')';
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[14]+']'+':'+code_desc_arr[1]+')</a>';
							}
						}else if(code_desc_arr[12] == "D" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){//added by parul on 02/12/2009 for IN16816
                           if (code_desc_arr[13] == "Y") {
							   if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
							   		tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>';
							   }
							   else{
								   tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[14]+']'+':'+code_desc_arr[1]+')</a>';
							   }

                           }else{
							   if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
							   }
							   else{
								   tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
							   }
						   }
						}
						else if(code_desc_arr[12] != "M" && code_desc_arr[12] != "D" && code_desc_arr[12] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[9]!="MAXFS"){
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case
							
								//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')';

								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
							}
							else{
							
								//tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')';

								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
							}
						}
						else if((code_desc_arr[12] == "D" || code_desc_arr[12] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
							}
						}
						else if(code_desc_arr[16] != "" && code_desc_arr[16] != "null" && code_desc_arr[16] != null){//added by parul on 11/12/2009 for super num changes
							if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>';
							}
							else{
								//commented by parul on 05/05/2010 for IN021153
								//	tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[14]+']'+':'+code_desc_arr[1]+')</a>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>';
							}
						}
						else{
							if(code_desc_arr[9]=="MAXFS"){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[15]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal_condition = trimString(xmlHttp.responseText);
								if(retVal_condition.length > 1){
									var retVal_condition_arr = retVal_condition.split("~");
									for(var j=0;j<retVal_condition_arr.length-1;j++){
									var code_desc_arr_1 = retVal_condition_arr[j].split("##");
									if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
											if(code_desc_arr_1[0] == "SUPRTH"){
												isSuperYN = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[1] != "N"&& code_desc_arr_1[3] == "N"){
												isSuperYN_super = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}
										}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
											if(code_desc_arr_1[0] == "SUPRTH" &&  code_desc_arr_1[3] == "N" && code_desc_arr_1[4] == "N"){
												isSuperYN = "true";

											}
				
											if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[1] == "N" && code_desc_arr_1[3]=="N"){
												isSuperYN_super_1 = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[1] == "Y" && code_desc_arr_1[3]=="N"){
												isExfoliatedNorm="true";
												//isSuperYN_super = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[4] == "N"){
												isSuperYN_super = "true";

											}

										
										}else if (permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
											
											if(code_desc_arr_1[0] == "DECITH" &&  code_desc_arr_1[2] == "D" &&  code_desc_arr_1[4] == "N"){
												isDeciduous = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}

											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] != "N" && code_desc_arr_1[2] != "R"){// Addded by Sridevi Joshi on 4/7/2010
												isExfoliatedDec="true";
											}
											
										
										}else if (permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
											
											if(code_desc_arr_1[0] == "DECITH" &&  code_desc_arr_1[2] == "D" &&  code_desc_arr_1[4] == "N"){
												isDeciduous = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "M"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "PARERTH" && code_desc_arr_1[3] == "N"){
												isUNErupted="true";
												//isRetainedDeciduous = "true";

											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}
											
										
										}
									}
									
								if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
										if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											isExfoliatedNorm="false"

										}else if (isRetainedDeciduous=="true" && isExfoliatedRD=="true"){
											if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											}
											else{
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
											}
											isExfoliatedRD="false"

										}else if (isRetainedDeciduous=="true" && (isExfoliatedRD!="true" || isExfoliatedNorm!="true")){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

										}else if(isSuperYN=="true" && isSuperYN_super=="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a>';
										}else if(isSuperYN=="true" && isSuperYN_super!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+code_desc_arr[21]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
										
										}else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+code_desc_arr[21]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

										}
									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
										if(isSuperYN=="true" && isSuperYN_super_1=="true"){
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+code_desc_arr[21]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a>';

										}else if(isExfoliatedNorm=="true" && isSuperYN!="true"){
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+code_desc_arr[21]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

										
										}else if (isExfoliatedNorm=="true" && isSuperYN=="true" && isSuperYN_super_1!="true")
										{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a>';

										}
										
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

										}
									}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
										if (isDeciduous=="true" && isExfoliatedDec != "true"){// isExfoliatedDec is addded by Sridevi Joshi on 4/7/2010
											if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											}
											else{
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
											}
										
										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"  && isExfoliatedRD!="true"  && isDeciduous!="true") {
											 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm!="true"  && isExfoliatedRD=="true"  && isDeciduous!="true") {
											if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											}
											else{
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
											}

										}else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
										}

									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
										if (isExfoliatedNorm=="true" && isRetainedDeciduous=="true"){
											if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											}
											else{
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
											}

										}else if (isExfoliatedNorm=="true" && isRetainedDeciduous!=true && isUNErupted!="true"){
											if(code_desc_arr[14] == "" || code_desc_arr[14] == null || code_desc_arr[14] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
											}
											else{
												tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[14]+':'+code_desc_arr[1]+')</a>';
											}

										}else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
										}


									}


								}else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';

								
								
								}
							}else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[18]+'\',\''+super_key_num+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>';
							}

						}
					
					}
					/*
					//To check wether the Order Catalog is Billable
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "task_code="+task_code;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateOrderCatalog&"+params,false);
					xmlHttp.send(xmlDoc);
					var order_catalog_bill_yn = trimString(xmlHttp.responseText);
					*/
					if(code_desc_arr[11] == ""){
						//Commented by Sridevi Joshi on 8/25/2010 for IN023131(SRR20056-SCF-4951)
						/*var msg_total_pay = getMessage("APP-OH000131","OH");
						if(billing_appl_yn == "Y"){
							tab_dat     += '\n<font color="brown">['+total_payable_label+':'+msg_total_pay+']</font>';
						}*/

					}
					else{
						if(billing_appl_yn == "Y"){
							tab_dat     += '\n<font color="brown">['+total_payable_label+':'+code_desc_arr[11]+']</font>';
						}
					}

					tab_dat     += '</div></td>';

					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuTasks1 style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='task_row_"+rownum+"' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"
				}
			}
		}
		 if(obj=="menuSummary"){    //Summary
		
			if(record_gingival_status_yn_param == "Y"){
				var gingivalstatussummary_label = getLabel("eOH.GingivalStatusSummary.Label","OH");
				
				//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490). To check wether GS is recorded for the Chart 
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=checkGSRecorded&"+params,false);
				xmlHttp.send(xmlDoc);
				var GS_retVal = trimString(xmlHttp.responseText);
				GS_retVal = localTrimString(GS_retVal);


				tab_dat     += "<tr>";
				tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				if(parseInt(GS_retVal) == 0){//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490). To remove hyperlink if there is no data to view.
					tab_dat     += '<td class="LABEL"><div align="left">'+gingivalstatussummary_label+'</div></td>';
				}
				else{
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openGingivalStatusSummary();\">'+gingivalstatussummary_label+'</a></div></td>';
				}
				tab_dat     += "</tr> ";
			}

			if(permanent_deciduous_flag == "P" && mixed_dentition_YN == "N"){
				var periodontalsummary_label = getLabel("eOH.PeriodontalSummary.Label","OH");

				//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490). To check wether Perio Chart is recorded
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=checkPerioRecorded&"+params,false);
				xmlHttp.send(xmlDoc);
				var perio_retVal = trimString(xmlHttp.responseText);
				perio_retVal = localTrimString(perio_retVal);

				tab_dat     += "<tr>";
				tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				if(parseInt(perio_retVal) == 0){
					tab_dat     += '<td class="LABEL"><div align="left">'+periodontalsummary_label+'</div></td>';
				}
				else{
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openPeriodontalSummary();\">'+periodontalsummary_label+'</a></div></td>';
				}
				tab_dat     += "</tr> ";
			}
			
			//('+patient_id+','+facility_id+')  
		}
		if(obj=="menu5"){ // Treatments Done
		    //var isTrmt_super_tooth_no=0;
			var super_key_num = "";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Added by Sharon Crasta on 1/23/2010 for IN018302
			var asOnDate = parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].asOnDate.value;
			var params = "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&asOnDate="+asOnDate+"&baseline_chart_yn="+baseline_chart_yn+"&chart_num="+chart_num;
			//End
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=populateTreatmentsDone&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("OH_SEP_2");
				var rownum=0;
				for(var i=0;i<retVal_arr.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arr[i].split("OH_SEP_1");

					if(code_desc_arr[9] == "THRNG" || (code_desc_arr[9]=="MAXFS" &&(code_desc_arr[18]==("TNGAB") || code_desc_arr[18]==("TNGGM") || code_desc_arr[18]==("TNGAG") || code_desc_arr[18]==("TNGGAM") || code_desc_arr[18]==("TNGMF")))){	
						super_key_num = "";
					}
					else{
						var super_key_num = code_desc_arr[22];
					}

					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;

					if(code_desc_arr[8] == null || code_desc_arr[8] == "null" || code_desc_arr[8] == "undefined" || code_desc_arr[8] == undefined){
						code_desc_arr[8] = "";
					}

					code_desc_arr[8] = escape(code_desc_arr[8]); //This is decode special characters.In this case to decode space to %20
					var rem_hid = escape(code_desc_arr[8]);

					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="trmtDone'+rownum+'" onclick=buildTasksTable("'+code_desc_arr[7]+'","'+rownum+'","'+code_desc_arr[3]+'","'+obj+'","'+code_desc_arr[6]+'","'+code_desc_arr[8]+'","","'+code_desc_arr[15]+'","'+code_desc_arr[16]+'","'+code_desc_arr[17]+'","'+super_key_num+'"); width="10%"><div align="center" style="cursor:pointer"><B>+</B></div></td>';

					/*if (code_desc_arr[19].length>=2){//added by parul on 11/12/2009 for super change 
						isTrmt_super_tooth_no=code_desc_arr[19].substring(code_desc_arr[19].length-1,code_desc_arr[19].length);
					}*/

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var diag_params = "patient_id="+patient_id+"&chart_num="+code_desc_arr[13]+"&ind_chart_line_num="+code_desc_arr[14]+"&trmt_code="+code_desc_arr[7]+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","RecordLinkCondDiagValidation.jsp?func_mode=checkDiagnosisLink&"+diag_params,false);
					xmlHttp.send(xmlDoc);
					var diag_count = trimString(xmlHttp.responseText);
					var diag_data = "";
					/*
					if(diag_count.length >0){
						if(diag_count != "0" && parseInt(diag_count) != 0 ){
							var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params;
							diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\">[D]</a>';
						}
						else{
							diag_data = "";
						}
					}
					*/
					//if(code_desc_arr[9] == "THRNG" || code_desc_arr[9] == "MAXFS"){

					if(code_desc_arr[9] == "THRNG" || (code_desc_arr[9]=="MAXFS" &&(code_desc_arr[18]==("TNGAB") || code_desc_arr[18]==("TNGGM") || code_desc_arr[18]==("TNGAG") || code_desc_arr[18]==("TNGGAM") || code_desc_arr[18]==("TNGMF")))){		
						if(code_desc_arr[4] == "NA"){
							var diag_label = code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] != null && code_desc_arr[4] != "null" && code_desc_arr[4] != "")){
							var diag_label = code_desc_arr[4]+':'+code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] == null || code_desc_arr[4] == "null" || code_desc_arr[4] == "")){
							var diag_label = code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if(code_desc_arr[15] != "M" && code_desc_arr[15] != "D" && code_desc_arr[15] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[16] == "Y"){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								var diag_label = code_desc_arr[10]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+'s:'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+'s:'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[17]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
						}
						else if(code_desc_arr[15] != "M" && code_desc_arr[15] != "D" && code_desc_arr[15] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){
								var diag_label = code_desc_arr[10]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';

							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
						}
						else if((code_desc_arr[15] == "D" || code_desc_arr[15] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								var diag_label = code_desc_arr[10]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
						}
						else if(code_desc_arr[16] == "Y"){
							var diag_label = code_desc_arr[10]+':'+code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+'s:'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';	
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[10]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';	
						}
						else{
							var diag_label = code_desc_arr[10]+':'+code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//	tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+super_key_num+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+''+'\',\''+super_key_num+'\',\''+''+'\',\''+code_desc_arr[19]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
					}
					else{
						if(code_desc_arr[4] == "NA"){
							var diag_label = code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[10]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[10]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] != null && code_desc_arr[4] != "null" && code_desc_arr[4] != "")){
							var diag_label = code_desc_arr[4]+':'+code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && (code_desc_arr[4] == null || code_desc_arr[4] == "null" || code_desc_arr[4] == "")){
							var diag_label = code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
						else if(code_desc_arr[15] != "M" && code_desc_arr[15] != "D" && code_desc_arr[15] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[16] == "Y"){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+'s:'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+'s:'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[17]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
						}
						else if(code_desc_arr[15] != "M" && code_desc_arr[15] != "D" && code_desc_arr[15] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';

							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';							
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';							
							}
						}
						else if((code_desc_arr[15] == "D" || code_desc_arr[15] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){//for extream tooth in MD-D case added by Sridevi Joshi on 2/14/2010 for IN019316
								var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								if (code_desc_arr[16] == "Y"){//added by parul on 03/12/2009 for IN16816
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';

								}else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								}
							}
							else{
								var diag_label = code_desc_arr[17]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								if (code_desc_arr[16] == "Y"){//added by parul on 03/12/2009 for IN16816
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[17]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';

								}else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[17]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
								}
							}
						}
						else if(code_desc_arr[19] != "" && code_desc_arr[19] != "null" && code_desc_arr[19] != null){//added by parul on 11/12/2009 for super num changes	
							if(code_desc_arr[17] == "" || code_desc_arr[17] == null || code_desc_arr[17] == "null"){
								var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
							else{
								var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
								if(diag_count.length >0){
									if(diag_count != "0" && parseInt(diag_count) != 0 ){
										var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
										diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
									}
									else{
										diag_data = "";
									}
								}
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							}
						}
						else{
							var diag_label = code_desc_arr[2]+':'+code_desc_arr[1];
							if(diag_count.length >0){
								if(diag_count != "0" && parseInt(diag_count) != 0 ){
									var url = "../../eOH/jsp/OHDiagViewDetails.jsp?"+diag_params+"&diag_label="+diag_label;
									diag_data = '&nbsp;<a href=\"javascript:showLinkedDiagDetails(\''+url+'\');\"><B>[D]</B></a>';
								}
								else{
									diag_data = "";
								}
							}
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+code_desc_arr[17]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChartForTrmt(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+rem_hid+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+code_desc_arr[17]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[21]+'\',\''+super_key_num+'\',\''+code_desc_arr[20]+'\',\''+code_desc_arr[23]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a>'+diag_data+'</div></td>';
						}
					}

					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuTasks5 style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='taskDone_row_"+rownum+"' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"
				}
			}
			/*
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
					if(code_desc_arr[4] == "NA"){
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a></div></td>';
					}
					else if(code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == ""){
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a></div></td>';
					}
					else{
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
					}
					tab_dat     += "</tr> ";
				}
			}
			*/
	 }
	 else if(obj == "menuBC"){ // BaseLine Charts
		//active charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//var params = "patient_id="+patient_id+"&chart_status=A";
			var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_status=A";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateBaseLineChart&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){

				tab_dat     += "<tr>";
				//tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;
					if(code_desc_arr[3] == "RD"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += "</tr> ";
					}
					else if(code_desc_arr[3] == "RM"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += "</tr> ";
					}
					else{
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						tab_dat     += "</tr> ";

					}
				}
			}

			//closed charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_status=C";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateBaseLineChart&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
					tab_dat     += "<tr>";
				//tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;
					if(code_desc_arr[3] == "RD"){
						
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += "</tr> ";
					}
					else if(code_desc_arr[3] == "RM"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += "</tr> ";
					}
					else{
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						//Commented and Added by Sharon Crasta on 9/16/2009 for PMG20089-CRF-0700
						//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayBCChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\''+oh_chart_level+'\',\''+code_desc_arr[4]+'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
						tab_dat     += "</tr> ";

					}
				}
			}
		} else if (obj=="menuFC"){//Other Facility Charts       //Added by Sharon Crasta on 3/14/2009 for other facility chart CRF#0423
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "facility_id="+facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateFacilityChart&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal1 = trimString(xmlHttp.responseText);
			if(retVal1.length>1){
				var retVal_arr1 = retVal1.split("~");
					 for( var j=0;j<retVal_arr1.length-1;j++){
						var code_desc_arr1 =retVal_arr1[j].split("##");
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse"  width="10%"><div>'+code_desc_arr1[0]+'</div></td>';	
						
						tab_dat     += "</tr> ";

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&facility_id="+code_desc_arr1[1]+"&chart_status=A";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateOtherBaseLineChart&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						if(retVal.length>1){
							tab_dat     += "<tr>";
							tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
							tab_dat     += "</tr> ";
							var retVal_arr = retVal.split("~");
							for(var i=0;i<retVal_arr.length-1;i++){
								var code_desc_arr = retVal_arr[i].split("##");
								code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;

								if(code_desc_arr[3] == "RD"){
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
									//	tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
									tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';

									tab_dat     += "</tr> ";
								}
								else if(code_desc_arr[3] == "RM"){
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
									//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
									tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
									tab_dat     += "</tr> ";
								}
								else{
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
									tab_dat     += "&nbsp;&nbsp;";
									tab_dat  +='<a aligh="center"  href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>';

									//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
									tab_dat     += "</td></tr> ";
								
								}
							}
					  }	
					  var xmlDoc = "" ;
					  var xmlHttp = new XMLHttpRequest();
					  var params = "patient_id="+patient_id+"&facility_id="+code_desc_arr1[1]+"&chart_status=C";
					   var xmlStr ="<root><SEARCH ";
					  xmlStr +=" /></root>";
					  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					  xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateOtherBaseLineChart&"+params,false);
					  xmlHttp.send(xmlDoc);
					  var retVal = trimString(xmlHttp.responseText);
					  if(retVal.length>1){
					    tab_dat     += "<tr>";
						tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
						tab_dat     += "</tr> ";
							var retVal_arr = retVal.split("~");
							for(var i=0;i<retVal_arr.length-1;i++){
								var code_desc_arr = retVal_arr[i].split("##");
								code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;

								if(code_desc_arr[3] == "RD"){
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
									//	tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
									tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';

									tab_dat     += "</tr> ";
								}
								else if(code_desc_arr[3] == "RM"){
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
									//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
									tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
									tab_dat     += "</tr> ";
								}
								else{
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
									tab_dat     += "&nbsp;&nbsp;";
									tab_dat  +='<a aligh="center"  href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>';

									//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
									tab_dat     += "</td></tr> ";
									tab_dat     += "<tr>";
				
							
								}
							}
					  }
				} 
			}
		}else if (obj=="menuNT"){//added by parul on 23/08/2010 for SRR20056-CRF-0501 (IN010990)
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateNoteGroup",false);
			xmlHttp.send(xmlDoc);
			var retVal_nt= trimString(xmlHttp.responseText);
			if (retVal_nt.length>1){
				var retVal_arrnt = retVal_nt.split("~");
				var rownum=0;
					for(var i=0;i<retVal_arrnt.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arrnt[i].split("##");
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse'+rownum+'" onclick=buildNoteTable("'+code_desc_arr[0]+'","'+rownum+'","'+obj+'"); width="10%"><div align="center" style="cursor:pointer"><B>+</B></div></td>';

					tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+code_desc_arr[1]+'</div></td>';
					tab_dat     += '</div></td>';
					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuTasks1 style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='task_row_"+rownum+"' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"

					}

			}

		}
		/*
		else if(obj == "menuLBRD"){ // LAB/RADIOLOGY
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left">Laboratory</div></td>';
			tab_dat     += "</tr> ";
		
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left">Radiology</div></td>';
			tab_dat     += "</tr> ";
		}
		*/
		tab_dat     += "</table> ";	
		document.getElementById(obj).innerHTML = tab_dat;
	}
}

//added by parul on 23/08/2010 for SRR20056-CRF-0501 (IN010990)
function buildNoteTable(note_group,rownum,obj){
		switchNTMenu(rownum,obj);
		var patient_id = document.forms[0].patient_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "note_group="+note_group+"&patient_id="+patient_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateNoteType&"+params,false);
		xmlHttp.send(xmlDoc);
		var nt_retVal = trimString(xmlHttp.responseText);
		nt_retVal = localTrimString(nt_retVal);

		if (nt_retVal.length>1){
			var tab_dat = "<table id ='tasksTable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' background-color ='black'>";


		var retVal_arrnt = nt_retVal.split("~");
			for(var i=0;i<retVal_arrnt.length-1;i++){
				tab_dat     += "<td nowrap id='mouse' ><div align='center'><img src='../../eOH/images/Arrow.gif' alt='Arrow' width='11' height='9' align='middle' /></div></td>";	
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+retVal_arrnt[i]+'</div></td>';
				tab_dat     += "</tr>";

				
				tab_dat     +="<tr>";
				tab_dat     +="<div style='visibility:hidden;display:none'><td></td><td></td></div>";
				tab_dat     +="<div id='menuCharges' style='visibility:hidden;display:none'>"
				tab_dat     +="<td wrap id='charges_"+i+"_"+rownum+"' style='display:none'>"
				tab_dat     +="</td>"
				tab_dat     +="</div>";
				tab_dat     +="</tr>";
			
			}
			tab_dat  += "</table>";
			var note_row_num = "task_row_"+rownum;
		   document.getElementById(note_row_num).innerHTML = tab_dat;

		}
}//end

//added by parul on 23/08/2010 for SRR20056-CRF-0501 (IN010990)
function switchNTMenu(obj,menu) {
		var task_row_num = "task_row_"+obj;
		var el = document.getElementById(task_row_num);
		if ( el.style.display != "none" ) {
			el.style.display = 'none';
			var image_id = "mouse"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>+</B></div>';
		}
		else {
			el.style.display = '';
			var image_id = "mouse"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>-</B></div>';
		}
	}//end



function switchMenu(obj,img_name) {
	var el = document.getElementById(obj);
	if ( el.style.display != "none" ) {
		el.style.display = 'none';
		img_name.src = "../../eOH/images/arrow-down.gif";
	}
	else {
		el.style.display = '';
		img_name.src = "../../eOH/images/arrow-up.gif";
	}
}

function displayThisChart(desc,chart_details,obj,order_id, order_line_num,task_code,task_desc,task_order_status, appt_ref_no,remarks,appt_reqd_yn,seq_no,total_payable_for_trmt,bl_key,bl_data_exists_yn,episode_id,billed_yn,billing_appl_yn,start_date_time,end_date_time,RD_D_yn,super_yn,oh_chart_level,other_chart_facility_id,display_tooth_no,cusp_tip_code,task_seq_no,super_tooth_no,retained_tooth_no,super_key_num){
	// task_code,task_desc come from the function buildTasksTable.
	/*
	Order of elements in chart_details:		
	CHART_NUM:CHART_LINE_NUM:CHART_STATUS:CHART_DATE:SITE_TYPE:TOOTH_NO:NS_TOOTH_NO:ARCH_SNO:QUADRANT_SNO:SURFACE_CODE:CONDITION_TYPE:CONDITION_CODE
	*/
	//Added date_diff_flag by Sharon Crasta on 1/22/2010 for IN018302
	//On click from RHS, the fields were not getting disabled 	
	var date_diff_flag = document.forms[0].date_diff_flag.value; 
	//End
	if(obj == "menu1" || obj == "menu5"){
		var chart_details_arr	= chart_details.split(":");
		var chart_num			= chart_details_arr[0];
		var chart_line_num		= chart_details_arr[1];
		var ind_chart_line_num	= chart_details_arr[1]; // This is for Indivisual chart_line_num in case of tooth range...
		var chart_status		= chart_details_arr[2];
		var chart_date			= chart_details_arr[3];
		var site_type			= chart_details_arr[4];
		var tooth_no			= chart_details_arr[5];
		var ns_tooth_no			= chart_details_arr[6];
		var arch_sno			= chart_details_arr[7];
		var quadrant_sno		= chart_details_arr[8];
		var surface_code		= chart_details_arr[9];
		var trmt_category_type	= chart_details_arr[10];
		var trmt_code			= chart_details_arr[11];
		var thrng_ref			= chart_details_arr[12];
		var thrng_nos           = chart_details_arr[13];
		var status				= chart_details_arr[14]; // This is a status of Treatment(Order_Set)
		var outcome				= chart_details_arr[15];
		var maxila_area				= chart_details_arr[16];
		var maxila_parts				= chart_details_arr[17];
		var maxila_sub_parts				= chart_details_arr[18];
		var supernumerary_yn				= chart_details_arr[19];

		var thrng_nos_ref		= "";
		var flag = "";
		var disabled = "disabled";
		var flag_schedule = false;
		var flag_register = false;

		//Added by Sharon Crasta on 12/11/2009 for IN016953
		var trmt_status_for_extraction = "";
		var isSuperCondYN = "";
		var isRetndCondYN = "";
		//End

		if(RD_D_yn == "D" || RD_D_yn == "R"){ // This is to check the deciduous Condition
				flag = "RD";
		}
		else if(RD_D_yn == "M" ){
			flag = "MR";

			if(site_type=="THRNG"){
				display_tooth_no = thrng_nos;
			}
			else{
				display_tooth_no = ns_tooth_no;
			}
		}
		else if(RD_D_yn == "Y" ){
			//flag = "S"; On 13/11/07
			flag = "N";
		}
		else{
			flag = "";
		}
	   //Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH changes. 
		var super_tooth_ref = super_key_num;
		
		/*if(super_tooth_no != "" && super_tooth_no != "null" && super_tooth_no != null && super_tooth_no != "undefined" && super_tooth_no != undefined){
			super_tooth_ref = super_tooth_no.substring(super_tooth_no.length-1,super_tooth_no.length);
			if(super_tooth_ref = "1"){
				super_tooth_ref = "s1";
			}else if(super_tooth_ref = "2"){
				super_tooth_ref = "s2";
			}
		}*/

		if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
			if( RD_D_yn == "R"){
				if(retained_tooth_no == "" || retained_tooth_no == "null" || retained_tooth_no == null || retained_tooth_no == "undefined" || retained_tooth_no == undefined){
					super_tooth_ref = "RD";
				}
			}
		}
		else{
			if(retained_tooth_no != "" && retained_tooth_no != "null" && retained_tooth_no != null && retained_tooth_no != "undefined" && retained_tooth_no != undefined){
				super_tooth_ref = "RD";
			}
		}

		//End
		var facility_id = document.forms[0].facility_id.value;
		if(site_type=="THRNG" || (site_type=="MAXFS" && thrng_ref.indexOf(",")!=-1)){
			var tooth_range_arr = thrng_ref.split(",");
			tooth_range_arr = tooth_range_arr[0].split("$$");
			chart_line_num = tooth_range_arr[0]; // store Chart_line_num of the Starting Tooth NO of the TOOTH_TANGE column

			tooth_range_arr = thrng_ref.split(",");
			var temp_arr = "";
			for(i=0;i<tooth_range_arr.length;i++){
				temp_arr = tooth_range_arr[i].split("$$");
				if(i==0){
					//chart_line_num = temp_arr[0];
					thrng_nos_ref = temp_arr[1];
				}
				else
					thrng_nos_ref = thrng_nos_ref+","+temp_arr[1];
			}
		}

			if((RD_D_yn == "R" || RD_D_yn == "Y" )&& (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
					tooth_no=tooth_no+"r";
										
			}else if (RD_D_yn == "D" && (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
				tooth_no=tooth_no+"d";
			}
			
			if (supernumerary_yn=="Y"&& (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
				//tooth_no=tooth_no+"s";
				tooth_no=tooth_no+super_key_num;//Added by Sridevi Joshi on 2/8/2010 for IN010894
			}
		
		
		var formObj = document.trmtViewDetailsForm;
		var old_params = formObj.params.value;
		old_params=old_params+"&thrng_ref="+thrng_ref;/* Added for CRF-0487 inc.10936*/
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var patient_class = formObj.patient_class.value;
		var patient_class = formObj.patient_class.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var location_code = formObj.location_code.value;
		var location_type = formObj.location_type.value;
		var remarks_param = formObj.remarks.value;
		var baseline_chart_yn = formObj.baseline_chart_yn.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var episode_type = formObj.episode_type.value;
		var episode_id = formObj.episode_id.value;
		var visit_id = formObj.visit_id.value;
		var otFlag = formObj.otFlag.value;
		
		var arch_quad_desc = "";
		if(site_type == "QUAD"){
			arch_quad_desc = quadrant_sno;
		}
		else if(site_type == "ARCH"){
			arch_quad_desc = arch_sno;
		}

		remarks = unescape(remarks);
		remarks = encodeURIComponent(remarks);
		//Added by Sharon Crasta on 2/4/2010 for SRR20056-CRF-0485(IN010920)
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no;
		//
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getTaskStatus&"+params,false);
		xmlHttp.send(xmlDoc);
		var returnVal_task_status = trimString(xmlHttp.responseText);

		//Added by Sharon Crasta on 12/11/2009 for IN016953
		//Only cancel should be seen in the Status field when a tooth is EXFOLTH on which the an extraction order is in Ordered / Planned Stage. Once the trmt is registered, and the tooth exfoliated, then a message should be given and no cancellation will be done.
		
		if(trmt_category_type == "EXTRACT"){
			if(task_order_status == "10" || task_order_status == "15" || task_order_status == "25" || task_order_status == "52" || task_order_status == "55"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var count_condition_type = "";
				var cond_chart_line_num = "";

				var params_extraction = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&super_tooth_no="+super_tooth_no+"&retained_tooth_no="+retained_tooth_no;

			   	var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=forExtractionRecording&"+params_extraction,false);
				xmlHttp.send(xmlDoc);
				count_condition_type = trimString(xmlHttp.responseText);
				cond_chart_line_num	 = localTrimString(count_condition_type);

				if(parseInt(cond_chart_line_num)  > 0){
					if(task_order_status == "15"  && parseInt(chart_line_num) < parseInt(cond_chart_line_num)){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						
						var params_facility = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_code="+task_code+"&seq_no="+task_seq_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getFacilityId&"+params_facility,false);
						xmlHttp.send(xmlDoc);
						other_chart_facility_id = trimString(xmlHttp.responseText);
						other_chart_facility_id = localTrimString(other_chart_facility_id);
						
						if((other_chart_facility_id != facility_id ) && oh_chart_level == "E"){
							alert(getMessage("APP-OH000108","OH"));
							document.location.href = "../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+old_params;
							flag_schedule = true;
						}else{
							alert(getMessage("APP-OH000146","OH"));
							trmt_status_for_extraction = "E";
						}
					}
					else if(task_order_status == "10" && parseInt(chart_line_num) < parseInt(cond_chart_line_num))
					{
					 alert(getMessage("APP-OH000146","OH"));
					 trmt_status_for_extraction = "E";				
					}
					else if((task_order_status == "25" || task_order_status == "52" || task_order_status == "55") && parseInt(chart_line_num) < parseInt(cond_chart_line_num)){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						
						var params_facility = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_code="+task_code+"&seq_no="+task_seq_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getFacilityId&"+params_facility,false);
						xmlHttp.send(xmlDoc);
						other_chart_facility_id = trimString(xmlHttp.responseText);
						other_chart_facility_id = localTrimString(other_chart_facility_id);
						
						if((other_chart_facility_id != facility_id ) && oh_chart_level == "E"){
							alert(getMessage("APP-OH000109","OH"));
							document.location.href = "../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+old_params;
							flag_register = true;
						}else{
							alert(getMessage("APP-OH000146","OH"));
							document.location.href = "../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+old_params;
							flag_register = true;
							//trmt_status_for_extraction = "E";
						}
					}
					else
					{
					  trmt_status_for_extraction = "";								
					}
				}
			} 
		}
		//Commented and Added by Sharon Crasta on 12/11/2009 for IN016953
		//A new block is added if trmt_status_for_extraction flag is "E", then the encounter message should not be shown.
		//if(task_order_status == "15"){
		if(task_order_status == "15" && trmt_status_for_extraction != "E"){//End
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			
			var params_facility = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_code="+task_code+"&seq_no="+task_seq_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getFacilityId&"+params_facility,false);
			xmlHttp.send(xmlDoc);
			other_chart_facility_id = trimString(xmlHttp.responseText);
			other_chart_facility_id = localTrimString(other_chart_facility_id);
			
			if((other_chart_facility_id != facility_id ) && oh_chart_level == "E"){
				alert(getMessage("APP-OH000108","OH"));
				document.location.href = "../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+old_params;
				flag_schedule = true;

			}else{
				if(other_chart_facility_id == facility_id){

					// Check for current encounter status  
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_id="+order_id+"&order_line_num="+order_line_num+"&seq_no="+task_seq_no;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=checkCurrentEncounterValidity&"+params,false);
					xmlHttp.send(xmlDoc);
					var retValue = trimString(xmlHttp.responseText);
					var retValue_arr = retValue.split("::");
					var curr_encntr_active_yn_flag = retValue_arr[0];
					if(curr_encntr_active_yn_flag=="N"){
					  // var task_code = formObj.task_code.value;
						// Check for current encounter status  
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						
						xmlHttp.open("POST","DentalTrmtCommonValidation.jsp?func_mode=updateNewEncounter&"+params,false);
						xmlHttp.send(xmlDoc);
						var retValue = trimString(xmlHttp.responseText);
						var retValue_arr = retValue.split("::");
						var encounter_created_yn_flag = retValue_arr[0];
						if(encounter_created_yn_flag=="E"){
							var v_lang_err_msg_id = retValue_arr[2];
							// language id message to be written here.
							//return;
						}else if(encounter_created_yn_flag=="NO_NEW_ENCOUNTER"){
						}else if(encounter_created_yn_flag=="NEW_ENCOUNTER_CREATED"){
							var p_new_order_id = retValue_arr[1];
							formObj.ord_id0.value=p_new_order_id;
							formObj.order_id.value=p_new_order_id;
							order_id = formObj.order_id.value;
							var p_old_encounter_id = retValue_arr[2];
							var p_new_encounter_id = retValue_arr[3];
							//if(p_old_encounter_id != "null" && p_old_encounter_id != null && p_old_encounter_id != "" ){
								if((p_old_encounter_id != p_new_encounter_id ) && (other_chart_facility_id == 	facility_id )){
									if(p_new_encounter_id!=""){
										var info_alert_msg = getMessage("PRC-OH0002","OH");
										var info_alert_msg_arr = info_alert_msg.split("#");
										alert(info_alert_msg_arr[0]+p_old_encounter_id+info_alert_msg_arr[1]+p_new_encounter_id);

										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=updateFacilityId&"+params,false);
										xmlHttp.send(xmlDoc);
										var returnVal = trimString(xmlHttp.responseText);
									}
								}
							//}
							//	new_encounter_already_created = true;
						} 
					}		
						//}
				}
			}
		}

		 if(task_order_status == "25" || task_order_status == "52" || task_order_status =="55"){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Commented by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
			//var params_facility = 		"patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_code="+task_code;
			var params_facility = 		"patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&task_code="+task_code+"&seq_no="+task_seq_no;
			//
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getFacilityId&"+params_facility,false);
			xmlHttp.send(xmlDoc);
			other_chart_facility_id = trimString(xmlHttp.responseText);
			other_chart_facility_id = localTrimString(other_chart_facility_id);
			if((other_chart_facility_id != facility_id ) && (oh_chart_level == "E")) {
				alert(getMessage("APP-OH000109","OH"));
				document.location.href = "../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+old_params;
				flag_register = true;
			}
		}

		//Check for Order Catalog Billable Flag
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "task_code="+task_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateOrderCatalog&"+params,false);
		xmlHttp.send(xmlDoc);
		var order_catalog_bill_yn = trimString(xmlHttp.responseText);
		//Added by Sathish K for SRR20056-CRF-0479
		var baseline_chart_yn = formObj.baseline_chart_yn.value;
		//End
		if(obj == "menu1"){
			//Added  trmt_status_for_extraction param for IN016953 on 12/11/2009.
			//To cancel the order once the tooth is EXFOLTH,PARERTH,MISSTH,UNERUPTH
			//Added escape(task_desc) for 9/14/2010
			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+trmt_category_type+"&site="+site_type+"&code="+trmt_code+"&chart_num="+chart_num+"&show_new_active_yn=N&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&treatment_status="+task_order_status+"&outcome="+outcome+"&called_from_viewchart_yn=Y"+"&location_code="+location_code+"&location_type="+location_type+"&order_id="+order_id+"&order_line_num="+order_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_desc="+unescape(task_desc)+"&appt_ref_no="+appt_ref_no+"&appt_reqd_yn="+appt_reqd_yn+"&remarks="+remarks+"&ind_chart_line_num="+ind_chart_line_num+"&display_tooth_no="+display_tooth_no+"&seq_no="+seq_no+"&trmt_done_yn=N&total_payable_for_trmt="+total_payable_for_trmt+"&bl_key="+bl_key+"&bl_data_exists_yn="+bl_data_exists_yn+"&bl_episode_id="+episode_id+"&billed_yn="+billed_yn+"&billing_appl_yn="+billing_appl_yn+"&baseline_chart_yn="+baseline_chart_yn+"&start_date_time="+start_date_time+"&end_date_time="+end_date_time+"&order_catalog_bill_yn="+order_catalog_bill_yn+"&flag="+flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&cusp_tip_code="+cusp_tip_code+"&task_seq_no="+task_seq_no+"&episode_id="+episode_id+"&maxila_area="+maxila_area+"&maxila_parts="+maxila_parts+"&maxila_sub_parts="+maxila_sub_parts+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&called_from="+otFlag+"&trmt_status_for_extraction="+trmt_status_for_extraction+"&flag1="+super_tooth_ref+"&super_key_num="+super_key_num+"&task_status_orig="+returnVal_task_status+"&date_diff_flag="+date_diff_flag;


			if(other_chart_facility_id != facility_id){
				params = params	+"&status_disabled="+disabled;
			}
		}

		else if(obj == "menu5"){
							
			//Added escape(task_desc) for 9/14/2010
			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+trmt_category_type+"&site="+site_type+"&code="+trmt_code+"&chart_num="+chart_num+"&show_new_active_yn=N&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&treatment_status="+task_order_status+"&outcome="+outcome+"&called_from_viewchart_yn=Y"+"&location_code="+location_code+"&location_type="+location_type+"&order_id="+order_id+"&order_line_num="+order_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_desc="+unescape(task_desc)+"&appt_ref_no="+appt_ref_no+"&remarks="+remarks+"&ind_chart_line_num="+ind_chart_line_num+"&display_tooth_no="+display_tooth_no+"&seq_no="+seq_no+"&trmt_done_yn=Y&billed_yn="+billed_yn+"&billing_appl_yn="+billing_appl_yn+"&order_catalog_bill_yn="+order_catalog_bill_yn+"&start_date_time="+start_date_time+"&end_date_time="+end_date_time+"&flag="+flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&cusp_tip_code="+cusp_tip_code+"&task_seq_no="+task_seq_no+"&episode_type="+episode_type+"&maxila_area="+maxila_area+"&maxila_parts="+maxila_parts+"&maxila_sub_parts="+maxila_sub_parts+"&episode_id="+episode_id+"&visit_id="+visit_id+"&called_from="+otFlag+"&flag1="+super_tooth_ref+"&super_key_num="+super_key_num+"&baseline_chart_yn="+baseline_chart_yn+"&date_diff_flag="+date_diff_flag;
			if(other_chart_facility_id != facility_id){
				params = params	+"&status_disabled="+disabled;
			}
		}
		params=params+"&thrng_ref="+thrng_ref;/* Added by for CRF-0487 inc.10936*/
		if(task_order_status == "15" || task_order_status == "25" || task_order_status == "52" || task_order_status =="55" || task_order_status =="80" || task_order_status =="60"){ //Added status '60' by Sridevi Joshi for CRF-702(IN012606) on 051009
			if(flag_schedule){
				parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+old_params+"&called_from="+otFlag;
			}
			else if(flag_register){
				parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+old_params+"&called_from="+otFlag;
			}
			else{
				var task_order_status_int = parseInt(task_order_status);
				if(task_order_status_int >= "25"){ //Added by Sridevi Joshi for CRF-702(IN012606) on 230909
					/*
					//check the External Location Flag
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_task = "task_code="+task_code;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","OHTrmtSendOutAckValidation.jsp?func_mode=checkForExtLoc&"+params_task,false);
					xmlHttp.send(xmlDoc);
					var ext_perm_loc = trimString(xmlHttp.responseText);
					ext_perm_loc = localTrimString(ext_perm_loc);
					//ext_perm_loc = 'N';
					//if(ext_perm_loc == "Y"){*/
						parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/OHTrmtSendOutAcknwoledgeFrame.jsp?"+params;
					
					//}
					//else{
						//parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params;
					//}
				}
				else{
					parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params;
				}
			} 
		}else{

				parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params;
		}

		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
}
	
function openClinicalNotes(){
	var formObj = document.trmtViewDetailsForm;
	var params = formObj.params.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = formObj.chart_num.value;
	var speciality_code = formObj.speciality_code.value;
//	var location_code = formObj.location_code.value;
	var location_code = formObj.source_code.value;


	var note_type= "";//formObj.note_type.value;
	var contr_mod_accession_num = "";//formObj.contr_mod_accession_num.value;
	//var function_id="SPCL_NOTE";
	var function_id="";
	var event_class="$PHY$";
	var window_close="Y";
	var hide_header="Y";
	var tab_yn="N";
	//var speciality_code = ""; //b4 SCR-4511
	var HTML="";
	var query_flag_yn = "N";
	//var update_mode = formObj.update_mode.value; // This is being used only for Anaesthesia.
	var title = getLabel("Common.ClinicalNotes.label","Common");
	var url="";
	var HTML="";
	HTML += "<html>";
	HTML += "<form>";
	HTML += "<body>";
	if(query_flag_yn=="N"){
		HTML = "<form name='historyForm' id='historyForm' action='../../eCA/jsp/RecClinicalNotesModal.jsp'>";
	}else if(query_flag_yn=="Y"){
		HTML = "<form name='historyForm' id='historyForm' action='../../eCA/jsp/PhysicanNotesDetails.jsp'>";
	}
	if(query_flag_yn=="N"){
		 url = "../../eCA/jsp/RecClinicalNotesModal.jsp?title="+title+"&appl_task_id=OH&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&location_code="+location_code;
	}else if(query_flag_yn=="Y"){
			 url = "../../eCA/jsp/PhysicanNotesDetails.jsp?title="+title+"&appl_task_id=OH&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&location_code="+location_code;
	}
	//parent.parent.parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
	//parent.parent.parent.parent.messageFrame.document.historyForm.submit()

	var features			= "channelmode=yes";
	 window.open(url,"CAWindow",features);

}
/*
function openDiagnosis(){
	var formObj = document.condViewDetailsForm;
	var params = formObj.params.value;
//	var params = "treatment_condition_date="+date+"&mode=modify&tooth_numbering_system=<%=tooth_numbering_system%>&permanent_deciduous_flag=<%=permanent_deciduous_flag%>&patient_id_new=<%=patient_id%>&upper_arch_desc=<%=upper_arch_desc%>&lower_arch_desc=<%=lower_arch_desc%>&Q1_id=<%=Q1_id%>&Q2_id=<%=Q2_id%>&Q3_id=<%=Q3_id%>&Q4_id=<%=Q4_id%>&Q1_desc=<%=Q1_desc%>&Q2_desc=<%=Q2_desc%>&Q3_desc=<%=Q3_desc%>&Q4_desc=<%=Q4_desc%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>";
	var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params;
	window.open(url,null,"align=center, height=450,width=790,top=120,left=30,status=NO,toolbar=no,menubar=no,location=no");

}
*/
async function openDiagnosis(){
	var formObj = document.trmtViewDetailsForm;
	var params = formObj.params.value;
	var oh_chart_num = formObj.cur_chart_num.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var episode_id = formObj.episode_id.value;
	var location_code = formObj.location_code.value;
	var location_type = formObj.source_type.value;
	var patient_class = formObj.patient_class.value;
	var speciality_code = formObj.speciality_code.value;
	var option_id = formObj.option_id.value;
	var ca_practitioner_id = formObj.practitioner_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var accession_num = facility_id+"||"+encounter_id+"||"+oh_chart_num;
//	var params = "treatment_condition_date="+date+"&mode=modify&tooth_numbering_system=<%=tooth_numbering_system%>&permanent_deciduous_flag=<%=permanent_deciduous_flag%>&patient_id_new=<%=patient_id%>&upper_arch_desc=<%=upper_arch_desc%>&lower_arch_desc=<%=lower_arch_desc%>&Q1_id=<%=Q1_id%>&Q2_id=<%=Q2_id%>&Q3_id=<%=Q3_id%>&Q4_id=<%=Q4_id%>&Q1_desc=<%=Q1_desc%>&Q2_desc=<%=Q2_desc%>&Q3_desc=<%=Q3_desc%>&Q4_desc=<%=Q4_desc%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>";
	//var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y";
	//var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num;

	var sex = formObj.sex.value;
	var dob = formObj.dob.value;
	var bed_num = formObj.bed_num.value;
	var room_num = formObj.room_num.value;
	var visit_adm_date = formObj.visit_adm_date.value;

	//var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&called_from_OH=OH";
	var url = "../../eMR/jsp/RecDiagnosis.jsp?encounter_id="+encounter_id+"&practitioner_id="+ca_practitioner_id+"&episode_id="+episode_id+"&FacilityId="+facility_id+"&patient_id="+patient_id+"&location_code="+location_code+"&location_type="+location_type+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+visit_adm_date+"&IP_YN=N&speciality_code="+speciality_code+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&called_from_OH=OH&Function=&option_id="+option_id;
	
	var dialogHeight = "80vh" ;
	var dialogWidth  = "80vw" ;
	//var dialogWidth  		= window.screen.availWidth;
	var dialogTop    = "10";
	var dialogLeft   = "50";   
	
	//Commented by Sharon Crasta on 5/6/2009
	/*var dialogHeight= "32" ;
	var dialogWidth	= "78" ;
	var dialogTop ="29";
	var dialogLeft ="15"; */
	
	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	//window.open(url,null,"align=center, height=450,width=790,top=120,left=30,status=NO,toolbar=no,menubar=no,location=no");
	await top.window.showModalDialog(url,null,features)
}
/*function displayNewChart(){
	// parent is OHDentalChartCondDetailsFrame.jsp
	// parent.parent is OHMixedDentAlertFrame.jsp
	// parent.parent.parent is OHCondDentalChartFrame.jsp or OHTrmtDentalChartFrame.jsp
	// parent.parent.parent.parent is OHDentalChartTabSearch.jsp

	var formObj = document.forms[0];

	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_type = formObj.chart_type.value;
	var old_facility_id = formObj.facility_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	var episode_type = formObj.episode_type.value;
	var source_code = formObj.source_code.value;
	var source_type = formObj.source_type.value;
	var chart_num_int = parseInt(chart_num);
	chart_num_int = chart_num_int+1;

	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value;
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

	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var chart_type = formObj.chart_type.value;
	var header_tab = formObj.header_tab.value;
	var speciality_code = formObj.speciality_code.value;

	var chart_date="";

	var copy_yn = "N";

	var chart_num_closed = "";

	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
	var facility_id = formObj.facility_id.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_status=A";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateBaseLineChart&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr =retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
		var retVal_arr_1 = retVal_arr[i].split("##");
			chart_date= retVal_arr_1[0];
			chart_num= retVal_arr_1[1];
		}
	}
	
	var new_chart = confirm(getMessage("APP-OH00068","OH"));
	if(new_chart){

		var msg=getMessage("APP-OH00095","OH");
		var msgArray = msg.split("##");
		//var copy_chart = confirm(getMessage("APP-OH00011","OH"));
		var copy_chart = confirm(msgArray[0]+chart_num+msgArray[1]+chart_date+msgArray[2]);
		if(copy_chart){
			copy_yn = "Y";
		}
		else{
			copy_yn = "N";
		}

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_status=A";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getMaxChartNum&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		if(retVal != "null" && retVal != "" && retVal != null && retVal.length >1){
			chart_num= retVal;
		}
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
		//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn;
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=newChartFromBaselineMenu&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var initial_params = parent.parent.dummyFrame.location.search;
		var initial_params1 = parent.parent.parent.mainTabHeaderFrame.location.search;
		//Added flag to disbale calling the message APP-OH00010 after clicking Add New
		var add_new_done_flag = "Y";
		//initial_params has ? in the beginning
		//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y";
		//var params_add_new="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&chart_hdr_insert_yn=Y&baseline_chart_yn=N"+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view=A"+"&default_head_tab=Treatment"+"&oh_chart_level="+oh_chart_level;
	
		parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y"+"&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;
		/*  commented on 290708 by sridevi joshi..If show_new_active_yn=Y then blank chrt will be displayed..If show_new_active_yn=N then chart with new chart num wil be displayed*/
		//initial_params=initial_params+"&show_new_active_yn=Y";
		//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y"; //// add_new_yn = "Y" is to clear the clinical group code for new chart...;
		
		//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y";
		/*initial_params=initial_params+"&show_new_active_yn=N";
		//// add_new_yn = "Y" is to clear the clinical group code for new chart...;
	
		//Instead of calling the OHCondDentalChartFrame.jsp, call OHMixedDentAlertFrame.jsp where ur setting the value of show_new_active_yn
		//parent.parent.parent.condTabDentalChartFrame.location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp"+initial_params;
		parent.parent.dummyFrame.location.href="../../eOH/jsp/OHMixedDentAlertFrame.jsp"+initial_params+"&add_new_done_flag="+add_new_done_flag;
	

		if(parent.parent.parent.mainTabHeaderFrame!=null){
		
		//parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&add_new_yn=Y";	
		//parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+initial_params+"&add_new_yn=Y"+"&default_head_tab=Treatment"+"&add_new_done_flag="+add_new_done_flag;	
		}
		
	}
}  */

function displayNewChart(){
	// parent is OHDentalChartCondDetailsFrame.jsp
	// parent.parent is OHMixedDentAlertFrame.jsp
	// parent.parent.parent is OHCondDentalChartFrame.jsp or OHTrmtDentalChartFrame.jsp
	// parent.parent.parent.parent is OHDentalChartTabSearch.jsp
    var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	
	var chart_type = formObj.chart_type.value;
	var old_facility_id = formObj.facility_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	var episode_type = formObj.episode_type.value;
	var source_code = formObj.source_code.value;
	var source_type = formObj.source_type.value;
	var locale = formObj.locale.value;
	var chart_num_int = parseInt(chart_num);
	chart_num_int = chart_num_int+1;
	var otFlag = formObj.otFlag.value;

	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value;
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

	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var chart_type = formObj.chart_type.value;
	var header_tab = formObj.header_tab.value;
	var speciality_code = formObj.speciality_code.value;

	var chart_date="";

	var copy_yn = "N";

	var chart_num_closed = "";

	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
	var facility_id = formObj.facility_id.value;
	var cur_chart_num = formObj.cur_chart_num.value;
    var locale = formObj.locale.value;
	/* NOTE: Below Code is useful for checking whether All Treatments are  Completed? if not to allow to create new Chart*/
   /* 
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_num="+cur_chart_num+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getStausCountforAddNew&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_Count = trimString(xmlHttp.responseText);
    retVal_Count=localTrimString(retVal_Count)
	
	if(retVal_Count!=0)
	{   
		alert("All Treatments are not Completed,Can not create new Chart");
		return;
	}*/
    
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_status=A";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateBaseLineChart&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr =retVal.split("~");

		for(i=0;i<retVal_arr.length-1;i++){
		var retVal_arr_1 = retVal_arr[i].split("##");
			//chart_date= retVal_arr_1[0];
			chart_date= convertDate(retVal_arr_1[0],'DMY',"en",locale);
			chart_num= retVal_arr_1[1];
			//Added by Sharon Crasta on 1/5/2010 for IN017815
			//Chart Type was going wrong.
			chart_type=retVal_arr_1[3];
			//
		}
		
	}
	

	//Added by Sharon Crasta on 1/5/2010 for IN017815
	//If Active chart is Permanent Chart,select any Deciduous / Mixed chart and click on Add New, then once the chart is loaded, the new chart was shown as the previous visible chart. On refresh works fine.
	var dflt_mixed_dentition_chart = formObj.dflt_mixed_dentition_chart.value;
	if(chart_type == "RA"){
		mixed_dentition_YN = "N";
	   permanent_deciduous_flag = "P";
	}
	if(chart_type == "RM"){
		mixed_dentition_YN = "Y";
	   if(dflt_mixed_dentition_chart == "D"){
  		   permanent_deciduous_flag = "D";
	   }
	   else{
		   permanent_deciduous_flag = "P";
	   }
	}
	if(chart_type == "RD"){
		mixed_dentition_YN = "N";
	   permanent_deciduous_flag = "D";
	}
	//End
	
  
  //added by parul on 15/06/2010 for IN022086
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=CheckChartStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_status = trimString(xmlHttp.responseText);  
  if (retVal_status>0 ){	//added by parul on 15/06/2010 for IN022086
		var msg=getMessage("APP-OH000186","OH");
		alert(msg);
    }else{
		var new_chart = confirm(getMessage("APP-OH00068","OH"));
		if(new_chart){
			var msg=getMessage("APP-OH00095","OH");
			var msgArray = msg.split("##");
			//Added by Sharon Crasta on 3/17/2010 for IN019604 - thai conversion
			//chart_date = convertDate(chart_date,'DMY','en',locale) ;
			//End
			//var copy_chart = confirm(getMessage("APP-OH00011","OH"));
			var copy_chart = confirm(msgArray[0]+chart_num+msgArray[1]+chart_date+msgArray[2]);
			if(copy_chart){
				copy_yn = "Y";
			}
			else{
				copy_yn = "N";
			}

			//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
			var dentist_comments = formObj.dentist_comments.value;
			var cur_chart_num = formObj.cur_chart_num.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_num="+cur_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getDentistComments&"+params,false);
			xmlHttp.send(xmlDoc);
			var dentist_comments_retVal = localTrimString(xmlHttp.responseText);
			//
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
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Commented by Sharon Crasta on 3/21/2009 for CRF #0423
			//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn;
			//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&dentist_comments="+dentist_comments_retVal;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=newChartFromBaselineMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var initial_params = parent.parent.dummyFrame.location.search;
			
			//Added flag to disbale calling the message APP-OH00010 after clicking Add New
			var add_new_done_flag = "Y";
			//Added by Sharon Crasta on 1/7/2010 for IN017822
			//Added flag to display the Treatment frames once the Add new is done from Treatment Tab. 
			var loaded_from_trmt_tab = "Y";
			//End
			//initial_params has ? in the beginning
			//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y";
			//var params_add_new="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&chart_hdr_insert_yn=Y&baseline_chart_yn=N"+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view=A"+"&default_head_tab=Treatment"+"&oh_chart_level="+oh_chart_level+"&show_new_active_yn=N&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;

			//Added loaded_from_trmt_tab by Sharon Crasta on 1/7/2010 for IN017822

			var params_add_new="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&chart_hdr_insert_yn=Y&baseline_chart_yn=N"+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view=A"+"&default_head_tab=Treatment"+"&oh_chart_level="+oh_chart_level+"&show_new_active_yn=N&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag+"&dentist_comments="+dentist_comments_retVal+"&called_from="+otFlag+"&loaded_from_trmt_tab="+loaded_from_trmt_tab;
		
			//Commented by Sharon Crasta on 4/15/2009	//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y"+"&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;
			//
			/*  commented on 290708 by sridevi joshi..If show_new_active_yn=Y then blank chrt will be displayed..If show_new_active_yn=N then chart with new chart num wil be displayed*/
			//initial_params=initial_params+"&show_new_active_yn=Y";
			//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y"; //// add_new_yn = "Y" is to clear the clinical group code for new chart...;
			
			//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y";
			//Commented by Sharon Crasta on 4/15/2009
			//initial_params=initial_params+"&show_new_active_yn=N";
			//
			//// add_new_yn = "Y" is to clear the clinical group code for new chart...;
		
			//Instead of calling the OHCondDentalChartFrame.jsp, call OHMixedDentAlertFrame.jsp where ur setting the value of show_new_active_yn
			//parent.parent.parent.condTabDentalChartFrame.location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp"+initial_params;
			//Commented by Sharon Crasta on 4/15/2009	//parent.parent.dummyFrame.location.href="../../eOH/jsp/OHMixedDentAlertFrame.jsp"+initial_params+"&add_new_done_flag="+add_new_done_flag;
			//

			//parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&add_new_yn=Y";	
			//parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+initial_params+"&add_new_yn=Y"+"&default_head_tab=Treatment"+"&add_new_done_flag="+add_new_done_flag;	
			parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params_add_new;
			parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params_add_new;
			//parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params_add_new;

			document.location.href="../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+params_add_new;
					
		}
	}
}

function buildTasksTable(trmt,rownum,chart_details,obj,order_set_id,remarks,total_payable_for_trmt,RD_D_yn,super_yn,display_tooth_no,super_key_num){

	//document.getElementById(obj).innerHTML = '<div align="center"><B>-</B></div>'
	switchTasksMenu(rownum,obj);
//facility_id,'OH',key,chrt_line_num,episode_type,patient_id,episode_id,visit_id,encounter_id,serv_panel_ind,serv_panel_code,'1',pract_staff_id,locale);
	var formObj = document.trmtViewDetailsForm;
	formObj.remarks.value = remarks;

	//var remarks = encodeURIComponent(remarks);
	var remarks = escape(remarks);
	//var remarks_param = formObj.remarks.value

	var patient_id = formObj.patient_id.value;
	var episode_type = formObj.episode_type.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	//var patient_class=formObj.patient_class.value;  //added  by yadav on 10/6/2009 fot crf-707
	var facility_id=formObj.facility_id.value;  
	var otFlag=formObj.otFlag.value;  
	var super_tooth_ref=super_key_num;
	var locale = formObj.locale.value;
	//var visit_id = "";
	var encounter_id = formObj.encounter_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var billing_appl_yn = formObj.billing_appl_yn.value;

	var chart_details_arr	= chart_details.split(":");
	var chart_num			= chart_details_arr[0];
	var chart_line_num		= chart_details_arr[1];

	//Added by Sharon Crasta on 3/14/2009 for Other Facility Chart CRF #0423
	var oh_chart_level =formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	//

	//Added by Sharon Crasta on 1/25/2010 for SRR20056-CRF-0485(IN010920)
	var baseline_chart_yn = formObj.baseline_chart_yn.value;
	var date_diff_flag = formObj.date_diff_flag.value;
	//End

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_code="+trmt+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&facility_id="+facility_id+"&otFlag="+otFlag+"&trmtYn="+obj;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=populateTreatmentTasks&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var tab_dat = "<table id ='tasksTable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' background-color ='black'>";
		
		var retVal_arr = retVal.split("~");
		for(k=0;k<retVal_arr.length-1;k++){
			var task_multiple_arr = retVal_arr[k].split("##");
			var task_code=task_multiple_arr[0];   // added by Yadav on 10/14/2009
			var task_seq_no=task_multiple_arr[14]; // added by Yadav on 10/14/2009
			var order_id = task_multiple_arr[2];
			var task_order_status = task_multiple_arr[3];
			var display_status_identifier = "";
			if(task_order_status=="10"){
				display_status_identifier = "[OS]"; //  Outstanding
			}
			else if(task_order_status=="15"){
				display_status_identifier = "[SC]"; //Scheduled
			}
			else if(task_order_status=="25"){
				display_status_identifier = "[RG]"; //Registered
			}
			else if(task_order_status=="52"){
				display_status_identifier = "[IM]"; //In Progress
			} 
			else if(task_order_status=="55" || task_order_status=="80"){ // Partial
				display_status_identifier = "[IR]"; //Registered
			}
			else if(task_order_status=="85" || task_order_status=="60" || task_order_status=="75" || task_order_status=="90"){
				display_status_identifier = "[RS]"; //ResultEntry(Result completed)
			}
					
			var appt_ref_no = task_multiple_arr[4];
			var order_line_num = task_multiple_arr[5];
			var appt_reqd_yn = task_multiple_arr[6];
			var seq_no = task_multiple_arr[7];
			var billed_yn = task_multiple_arr[10];
			var start_date_time = task_multiple_arr[11];
			var end_date_time = task_multiple_arr[12];
			var disabled = "";

			//Added by Sharon Crasta on 9/11/2009 for IN011250
			var appt_date_time =  task_multiple_arr[15];
			var patient_class =  task_multiple_arr[16];//added  by Sridevi Joshi on 10/29/2009 fot crf-707
		
			//Added by Sharon Crasta on 12/22/2009 for SUPRTH and RTDESTH changes.
			var super_tooth_no = task_multiple_arr[17];
			var retained_tooth_no = task_multiple_arr[18];

			var task_desc = escape(task_multiple_arr[1]);
			//var task_desc = encodeURIComponent(task_multiple_arr[1]);

			var appt_label = getLabel("eOH.Appt.Label","OH");

		
			//if(task_multiple_arr[2] == "Y"){
				tab_dat     += "<tr>";
				if(obj == "menu1"){
					tab_dat     += "<td nowrap id='mouse' ><div align='center'><img src='../../eOH/images/Arrow.gif' alt='Arrow' width='11' height='9' align='middle' /></div></td>";	
				}
				else if(obj == "menu5"){
					tab_dat     += "<td nowrap id='trmtDone' ><div align='center'><img src='../../eOH/images/Arrow.gif' alt='Arrow' width='11' height='9' align='middle' /></div></td>";	
				}
				
				//====================Added By Yadav CRF-707 on 10/6/2009========================
				var formObj = document.trmtViewDetailsForm;		
				var encounter = formObj.encounter_id.value;
				var otEncounter = '';
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var param_from_ot="";
				var params = "encounter_id="+encounter+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt+"&task_code="+task_code+"&task_seq_no="+task_seq_no;
				var  retVal_arr_for_OT;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=TreatmentRHSTooltip&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_for_OT = trimString(xmlHttp.responseText);
				if(retVal_for_OT.length >1){
					retVal_arr_for_OT =retVal_for_OT.split(":");
					 param_from_ot=retVal_arr_for_OT[3];
						otEncounter=retVal_arr_for_OT[4];
				}

				var name="";
				var name1="";
				if(patient_class == "IP" || patient_class == "DC")name='Inpatient.gif'
				else if(patient_class == "OP"|| patient_class == "EM")name='op.gif'
				param_from_ot=trimString(param_from_ot);
				if(param_from_ot != "Y" ){
					tab_dat     +="<td><img src='../../eOH/images/"+name+"' onmouseover=\"reasonToolTip('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+task_code+"','"+task_seq_no+"','"+otEncounter+"')\" onmouseout='UnTip()' /></td>";
				}
				else{
					if(patient_class == "IP" || patient_class == "DC"){	
						name1='Inpatient.gif'
						tab_dat     +="<td><img src='../../eOH/images/"+name1+"' onmouseover=\"reasonToolTip('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+task_code+"','"+task_seq_no+"','"+otEncounter+"')\" onmouseout='UnTip()' /><img src='../../eOH/images/OT.gif' onmouseover=\"reasonToolTip('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+task_code+"','"+task_seq_no+"','"+otEncounter+"')\" onmouseout='UnTip()' /></td>";
					}
					else if(patient_class == "OP"|| patient_class == "EM"){	
						name1='op.gif'
						tab_dat     +="<td width=10><img src='../../eOH/images/"+name1+"' onmouseover=\"reasonToolTip('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+task_code+"','"+task_seq_no+"','"+otEncounter+"')\" onmouseout='UnTip()' /><img src='../../eOH/images/OT.gif' onmouseover=\"reasonToolTip('"+patient_id+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+task_code+"','"+task_seq_no+"','"+otEncounter+"')\" onmouseout='UnTip()' /></td>";
					}
				}

				//==================== end ================

				if(appt_ref_no != "null" && appt_ref_no != null){
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920)
					if(task_order_status == "10" && baseline_chart_yn != "Y" && date_diff_flag != "disable"){
								
						tab_dat     += "<td class='LABEL' id='task_data'><div align='left' style='cursor:pointer;' onmouseover=\"reasonToolTipMenu('"+chart_details+"','"+obj+"','"+task_multiple_arr+"','"+task_order_status+"','"+appt_ref_no+"','"+remarks+"','"+appt_reqd_yn+"','"+seq_no+"','"+total_payable_for_trmt+"','"+episode_id+"','"+billed_yn+"','"+billing_appl_yn+"','"+start_date_time+"','"+end_date_time+"','"+RD_D_yn+"','"+super_yn+"','"+oh_chart_level+"','"+other_chart_facility_id+"','"+display_tooth_no+"','"+super_tooth_no+"','"+retained_tooth_no+"','"+super_key_num+"')\" onmouseout='UnTip()' onMouseDown= 'hideToolTip();'>";
					}else{
						tab_dat     += '<td class="LABEL" id="task_data"><div align="left" >';
					}//End
					

					if(billed_yn == "Y" && billing_appl_yn == "Y"){ //This is to show the billing image only after Processing the Charges
						tab_dat     += '<a href=\"javascript:showCharges(\''+task_multiple_arr[0]+'\',\''+k+'\',\''+chart_num+'\',\''+chart_line_num+'\',\''+trmt+'\',\''+order_id+'\');\"><img src=../../eOH/images/Billing.gif /></a>';
						//
					}
					
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920)
					if(task_order_status != "10" || (task_order_status == "10" && (baseline_chart_yn == "Y" || date_diff_flag == "disable"))){ //If the task status > OS OR if the task status is OS and is a baseline chart or asondate is backdated, then the schedule/register menu should not be shown.
					//added by rajesh for 19604 on 160310
					appt_date_time=convertDate(appt_date_time,"DMYHM","en",locale);
						tab_dat     +='<a href =\"javascript:displayThisChart(\'\',\''+chart_details+'\',\''+obj+'\',\''+task_multiple_arr[2]+'\',\''+task_multiple_arr[5]+'\',\''+task_multiple_arr[0]+'\',\''+task_desc+'\',\''+task_order_status+'\',\''+appt_ref_no+'\',\''+remarks+'\',\''+appt_reqd_yn+'\',\''+seq_no+'\',\''+total_payable_for_trmt+'\',\''+task_multiple_arr[8]+'\',\''+task_multiple_arr[9]+'\',\''+episode_id+'\',\''+billed_yn+'\',\''+billing_appl_yn+'\',\''+start_date_time+'\',\''+end_date_time+'\',\''+RD_D_yn+'\',\''+super_yn+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+display_tooth_no+'\',\''+task_multiple_arr[13]+'\',\''+task_multiple_arr[14]+'\',\''+super_tooth_no+'\',\''+retained_tooth_no+'\',\''+super_key_num+'\');\">'+task_multiple_arr[1]+display_status_identifier+'['+appt_label+''+appt_ref_no+' '+' '+appt_date_time+']</a></div></td>';
					}
					else{
						 tab_dat     +=	 task_multiple_arr[1]+display_status_identifier+'</font></div></td>';
					} //End
				}
				else{
					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920)
					//Added escape(task_multiple_arr[1] 9/14/2010
					if(task_order_status == "10" && baseline_chart_yn != "Y" && date_diff_flag != "disable"){
						tab_dat     += "<td class='LABEL'><div align='left' style='cursor:pointer;' onclick = \"reasonToolTipMenu('"+chart_details+"','"+obj+"','"+order_id+"','"+order_line_num+"','"+task_code+"','"+task_desc+"','"+task_order_status+"','"+appt_ref_no+"','"+remarks+"','"+appt_reqd_yn+"','"+seq_no+ "','"+total_payable_for_trmt+"','"+task_multiple_arr[8]+"','"+task_multiple_arr[9]+"','"+episode_id+"','"+billed_yn+"','"+billing_appl_yn+"','"+start_date_time+"','"+end_date_time+"','"+RD_D_yn+"','"+super_yn+"','"+oh_chart_level+"','"+other_chart_facility_id+"','"+display_tooth_no+"','"+task_multiple_arr[13]+"','"+task_multiple_arr[14]+ "','"+super_tooth_no+"','"+retained_tooth_no+"','"+super_key_num+"')\" onMouseDown= 'hideToolTip();'><font color='BLUE'>";
					}else{
												

						tab_dat     += '<td class="LABEL"><div align="left" >';
					}  //End

					if(billed_yn == "Y" && billing_appl_yn == "Y"){ //This is to show the billing image only after Processing the Charges
						tab_dat     += "<a href=\"javascript:showCharges('"+task_multiple_arr[0]+"','"+k+"','"+chart_num+"','"+chart_line_num+"','"+trmt+"','"+order_id+"');\"><img src=../../eOH/images/Billing.gif /></a>";
					}

					//Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920)
					if(task_order_status != "10" || (task_order_status == "10" && (baseline_chart_yn == "Y" || date_diff_flag == "disable"))){

						//tab_dat     += "<a href =\"javascript:displayThisChart('','"+chart_details+"','"+obj+"','"+task_multiple_arr[2]+"','"+task_multiple_arr[5]+"','"+task_multiple_arr[0]+"','"+task_desc+"','"+task_order_status+"','"+appt_ref_no+"','"+remarks+"','"+appt_reqd_yn+"','"+seq_no+ "','"+total_payable_for_trmt+"','"+task_multiple_arr[8]+"','"+task_multiple_arr[9]+ "','"+episode_id+"','"+billed_yn+"','"+billing_appl_yn+"','"+start_date_time+"','"+end_date_time+"','"+RD_D_yn+"','"+super_yn+"','"+oh_chart_level+"','"+other_chart_facility_id+"','"+display_tooth_no+"','"+task_multiple_arr[13]+"','"+task_multiple_arr[14]+ "','"+super_tooth_no+"','"+retained_tooth_no+"','"+super_key_num+"');\">"+task_multiple_arr[1]+display_status_identifier+"</a></div></td>";

						tab_dat     += '<a href =\'javascript:displayThisChart("","'+chart_details+'","'+obj+'","'+task_multiple_arr[2]+'","'+task_multiple_arr[5]+'","'+task_multiple_arr[0]+'","'+task_desc+'","'+task_order_status+'","'+appt_ref_no+'","'+remarks+'","'+appt_reqd_yn+'","'+seq_no+ '","'+total_payable_for_trmt+'","'+task_multiple_arr[8]+'","'+task_multiple_arr[9]+'","'+episode_id+'","'+billed_yn+'","'+billing_appl_yn+'","'+start_date_time+'","'+end_date_time+'","'+RD_D_yn+'","'+super_yn+'","'+oh_chart_level+'","'+other_chart_facility_id+'","'+display_tooth_no+'","'+task_multiple_arr[13]+'","'+task_multiple_arr[14]+'","'+super_tooth_no+'","'+retained_tooth_no+'","'+super_key_num+'");\'>'+task_multiple_arr[1]+display_status_identifier+'</a></div></td>';
						//alert('tab_dat-->'+tab_dat);
					}
					else{
						 tab_dat     += task_multiple_arr[1]+display_status_identifier+"</font></div></td>";	
					} //End
					
				}

				tab_dat     += "</tr>";				
				tab_dat     +="<tr>";
				tab_dat     +="<div style='visibility:hidden;display:none'><td></td><td></td></div>";
				tab_dat     +="<div id='menuCharges' style='visibility:hidden;display:none'>"
				tab_dat     +="<td wrap id='charges_"+k+"_"+chart_num+"_"+chart_line_num+"' style='display:none'>"
				tab_dat     +="</td>"
				tab_dat     +="</div>";
				tab_dat     +="</tr>";

			//}
		}
		
		tab_dat  += "</table>";
		
		if(obj == "menu1"){
			var task_row_num = "task_row_"+rownum;
		}
		else if(obj == "menu5"){
			var task_row_num = "taskDone_row_"+rownum;
		}

		document.getElementById(task_row_num).innerHTML = tab_dat;

				
	}
}
//Added by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)
function reasonToolTipMenu(chart_details,obj,order_id,order_line_num,task_code,task_desc,task_order_status,appt_ref_no,remarks,appt_reqd_yn,seq_no,total_payable_for_trmt,bl_key,bl_data_exists_yn,episode_id,billed_yn,billing_appl_yn,start_date_time,end_date_time,RD_D_yn,super_yn,oh_chart_level,other_chart_facility_id,display_tooth_no,cusp_tip_code,task_seq_no,super_tooth_no,retained_tooth_no,super_key_num){

	var schedule_label =  getLabel("Common.Schedule.label","Common");
	var register_label =  getLabel("Common.Register.label","Common");

	var tab_dat = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
	tab_dat		+= "<tr>";
	tab_dat     += '<td nowrap id="mouse"><a href =\"javascript:displayThisChart(\'\',\''+chart_details+'\',\''+obj+'\',\''+order_id+'\',\''+order_line_num+'\',\''+task_code+'\',\''+encodeURIComponent(task_desc)+'\',\''+task_order_status+'\',\''+appt_ref_no+'\',\''+remarks+'\',\''+appt_reqd_yn+'\',\''+seq_no+ '\',\''+total_payable_for_trmt+'\',\''+bl_key+'\',\''+bl_data_exists_yn+ '\',\''+episode_id+'\',\''+billed_yn+'\',\''+billing_appl_yn+'\',\''+start_date_time+'\',\''+end_date_time+'\',\''+RD_D_yn+'\',\''+super_yn+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+display_tooth_no+'\',\''+cusp_tip_code+'\',\''+task_seq_no+ '\',\''+super_tooth_no+'\',\''+retained_tooth_no+'\',\''+super_key_num+'\');\" onMouseUp= "hideToolTip();">'+schedule_label+'</a></td>';
	tab_dat     += "</tr> ";

	tab_dat		+= "<tr>";
	
	tab_dat     += '<td class = "OTMENULAYER" nowrap id="mouse"><a href =\"javascript:displayThisChart(\'\',\''+chart_details+'\',\''+obj+'\',\''+order_id+'\',\''+order_line_num+'\',\''+task_code+'\',\''+encodeURIComponent(task_desc)+'\',\''+'15'+'\',\''+appt_ref_no+'\',\''+remarks+'\',\''+appt_reqd_yn+'\',\''+seq_no+ '\',\''+total_payable_for_trmt+'\',\''+bl_key+'\',\''+bl_data_exists_yn+ '\',\''+episode_id+'\',\''+billed_yn+'\',\''+billing_appl_yn+'\',\''+start_date_time+'\',\''+end_date_time+'\',\''+RD_D_yn+'\',\''+super_yn+'\',\''+oh_chart_level+'\',\''+other_chart_facility_id+'\',\''+display_tooth_no+'\',\''+cusp_tip_code+'\',\''+task_seq_no+ '\',\''+super_tooth_no+'\',\''+retained_tooth_no+'\',\''+super_key_num+'\');\" onMouseUp= "hideToolTip();">'+register_label+'</a></td>';
	tab_dat     += "</tr></table>";
	//Tip(tab_dat,STICKY,true);

	document.getElementById("menu_table").innerHTML = tab_dat;
	resizeWindow();
}
function resizeWindow(){
	window.pageX = window.event.pageX | window.event.clientX;
	window.pageY = window.event.pageY |  window.event.clientY;

	var x =window.pageX + document.body.scrollLeft
	var y = window.pageY + document.body.scrollTop
	if(window.pageX > 750){
		x = x - 150
	}
	else if(window.pageX > 642 && window.pageX < 750){
		x = x - 150
	}
	else{
		x = x - 50;
	}
	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}
function hideToolTip()	{
  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

//End
//===========================Added By Yadav CRF-707 on 10/6/2009========================
function reasonToolTip(patient_id,chart_num,chart_line_num,trmt_code,task_code,task_seq_no,encounter_id){
	var formObj = document.trmtViewDetailsForm;		
	//var encounter_id = formObj.encounter_id.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "encounter_id="+encounter_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&task_seq_no="+task_seq_no;
	var  retVal_ot_arr;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=TreatmentRHSTooltip&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		 retVal_ot_arr =retVal.split(":");
		var encounter = getLabel("Common.encounter.label","Common");
		var parctitioner = getLabel("Common.practitioner.label","Common");
		var patientclass = getLabel("eOH.Performedin.Label","OH");
		var stringClass='';
		var otclass='OT';

		if(retVal_ot_arr[2]=='IP') 
			 {stringClass = getLabel("Common.inpatient.label","Common");}
		else if(retVal_ot_arr[2]=='OP') 
			 {stringClass = getLabel("Common.Outpatient.label","Common");}
		else if(retVal_ot_arr[2]=='EM') 
			 {stringClass = getLabel("Common.emergency.label","Common");}
		else if(retVal_ot_arr[2]=='DC') 
			 {stringClass = getLabel("Common.daycare.label","Common");}

		if(retVal_ot_arr[3]=='Y'){
			Tip("<b>"+encounter+"</b>&nbsp&nbsp&nbsp&nbsp:"+retVal_ot_arr[0]+"<br><b>"+parctitioner+"</b>&nbsp:"+retVal_ot_arr[1]+"<br><b>"+patientclass+"</b>:"+stringClass+"+"+otclass)
		}
		else{
			Tip("<b>"+encounter+"</b>&nbsp&nbsp&nbsp&nbsp:"+retVal_ot_arr[0]+"<br><b>"+parctitioner+"</b>&nbsp:"+retVal_ot_arr[1]+"<br><b>"+patientclass+"</b>:"+stringClass)
		 }
	}
}
//=========================   end  ====================================


function switchTasksMenu(obj,menu) {
	if(menu == "menu1"){
		var task_row_num = "task_row_"+obj;
		var el = document.getElementById(task_row_num);
		if ( el.style.display != "none" ) {
			el.style.display = 'none';

			var image_id = "mouse"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>+</B></div>';
		}
		else {
			el.style.display = '';

			var image_id = "mouse"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>-</B></div>';
		}
	}
	else if(menu == "menu5"){
		var task_row_num = "taskDone_row_"+obj;
		var el = document.getElementById(task_row_num);
		if ( el.style.display != "none" ) {
			el.style.display = 'none';

			var image_id = "trmtDone"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>+</B></div>';
		}
		else {
			el.style.display = '';

			var image_id = "trmtDone"+obj;
			document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>-</B></div>';
		}
	}
}

	
function displayThisChartForTrmt(type_desc,chart_details,obj,status,remarks,complication_code,RD_D_yn,super_yn,oh_chart_level,other_chart_facility_id,display_tooth_no,order_id,cusp_tip_code,super_key_num,retained_tooth_no,failure_reason){
	/*
	Order of elements in chart_details:		
	CHART_NUM:CHART_LINE_NUM:CHART_STATUS:CHART_DATE:SITE_TYPE:TOOTH_NO:NS_TOOTH_NO:ARCH_SNO:QUADRANT_SNO:SURFACE_CODE:CONDITION_TYPE:CONDITION_CODE
	*/
		//Added date_diff_flag by Sharon Crasta on 3/30/2010 for IN018302
		//On click from RHS, the fields were not getting disabled 	
		var date_diff_flag = document.forms[0].date_diff_flag.value; 
		//End

		var chart_details_arr	= chart_details.split(":");
		var chart_num			= chart_details_arr[0];
		var chart_line_num		= chart_details_arr[1];
		var ind_chart_line_num	= chart_details_arr[1]; // This is for Indivisual chart_line_num in case of tooth range...
		var chart_status		= chart_details_arr[2];
		var chart_date			= chart_details_arr[3];
		var site_type			= chart_details_arr[4];
		var tooth_no			= chart_details_arr[5];
		var ns_tooth_no			= chart_details_arr[6];
		var arch_sno			= chart_details_arr[7];
		var quadrant_sno		= chart_details_arr[8];
		var surface_code		= chart_details_arr[9];
		var trmt_category_type	= chart_details_arr[10];
		var trmt_code			= chart_details_arr[11];
		var thrng_ref			= chart_details_arr[12];
		var thrng_nos           = chart_details_arr[13];
		//var clinical_code		= chart_details_arr[14];
		//var surface_code      = chart_details_arr[15];
		//var trmt_location     = chart_details_arr[16];
		var status				= chart_details_arr[14]; // This is a status of Treatment(Order_Set)
		var outcome				= chart_details_arr[15];
		var maxila_area				= chart_details_arr[16];
		var maxila_parts				= chart_details_arr[17];
		var maxila_sub_parts				= chart_details_arr[18];
		var supernumerary_yn				= chart_details_arr[19];
		
		
		var thrng_nos_ref		= "";
		var super_tooth_ref = super_key_num;
		var flag = "";
		if(RD_D_yn == "D" || RD_D_yn == "R"){ // This is to check the deciduous Condition
				flag = "RD";
		}
		else if(RD_D_yn == "M" ){
			flag = "MR";

			if(site_type=="THRNG"){
				display_tooth_no = thrng_nos;
			}
			else{
				display_tooth_no = ns_tooth_no;
			}
		}
		else if(RD_D_yn == "Y" ){
			//flag = "S"; On 13/11/07
			flag = "N";
		}
		else{
			flag = "";
		}

		//if(site_type=="THRNG" ){
			//THAB,THGM,THAG,THGAM,THMF
			//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
		if(site_type=="THRNG" || (site_type=="MAXFS" &&(maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG" || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF")) ){
			var tooth_range_arr = thrng_ref.split(",");
			tooth_range_arr = tooth_range_arr[0].split("$$");
			chart_line_num = tooth_range_arr[0]; // store Chart_line_num of the Starting Tooth NO of the TOOTH_TANGE column

			tooth_range_arr = thrng_ref.split(",");
			var temp_arr = "";
			for(i=0;i<tooth_range_arr.length;i++){
				temp_arr = tooth_range_arr[i].split("$$");
				if(i==0){
					//chart_line_num = temp_arr[0];
					thrng_nos_ref = temp_arr[1];
				}
				else
					thrng_nos_ref = thrng_nos_ref+","+temp_arr[1];
			}
		}
	//	if(RD_D_yn == "D" || RD_D_yn == "R" || RD_D_yn == "Y"){
		if((RD_D_yn == "R" || RD_D_yn == "Y" )&& (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
					tooth_no=tooth_no+"r";
					
		}
		if (supernumerary_yn=="Y"&& (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
			//tooth_no=tooth_no+"s";
			tooth_no=tooth_no+super_key_num;//Added by Sridevi Joshi on 2/8/2010 for IN010894
		}

		var formObj = document.trmtViewDetailsForm;
		var old_params = formObj.params.value;
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var patient_class = formObj.patient_class.value;
		var patient_class = formObj.patient_class.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var location_code = formObj.location_code.value;
		var location_type = formObj.location_type.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var facility_id = formObj.facility_id.value;
		var otFlag = formObj.otFlag.value;
		var disabled = "disabled";
		var arch_quad_desc = "";
		if(site_type == "QUAD"){
			arch_quad_desc = quadrant_sno;
		}
		else if(site_type == "ARCH"){
			arch_quad_desc = arch_sno;
		}

		if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
			if( RD_D_yn == "R"){
				if(retained_tooth_no == "" || retained_tooth_no == "null" || retained_tooth_no == null || retained_tooth_no == "undefined" || retained_tooth_no == undefined){
					super_tooth_ref = "RD";
				}
			}
		}
		else{
			if(retained_tooth_no != "" && retained_tooth_no != "null" && retained_tooth_no != null && retained_tooth_no != "undefined" && retained_tooth_no != undefined){
				super_tooth_ref = "RD";
			}
		}


		remarks = unescape(remarks);
		remarks = encodeURIComponent(remarks);
		
		//Added by Sathish on 1/27/2010 for SRR20056-CRF-0479
		var baseline_chart_yn = formObj.baseline_chart_yn.value;

		//added by parul on 02/03/2010 for CRF-477
		failure_reason = unescape(failure_reason);
		failure_reason= encodeURIComponent(failure_reason);

		params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+trmt_category_type+"&site="+site_type+"&code="+trmt_code+"&chart_num="+chart_num+"&show_new_active_yn=N&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&treatment_status="+status+"&outcome="+outcome+"&called_from_viewchart_yn=Y"+"&location_code="+location_code+"&location_type="+location_type+"&trmt_code="+trmt_code+"&remarks="+remarks+"&display_tooth_no="+display_tooth_no+"&ind_chart_line_num="+ind_chart_line_num+"&complication_code="+complication_code+"&mixed_dentition_YN="+mixed_dentition_YN+"&flag="+flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&order_id="+order_id+"&maxila_area="+maxila_area+"&maxila_parts="+maxila_parts+"&maxila_sub_parts="+maxila_sub_parts+"&cusp_tip_code="+cusp_tip_code+"&called_from="+otFlag+"&super_key_num="+super_key_num+"&flag1="+super_tooth_ref+"&baseline_chart_yn="+baseline_chart_yn+"&failure_reason="+failure_reason+"&thrng_ref="+thrng_ref+"&date_diff_flag="+date_diff_flag;


		if(other_chart_facility_id != facility_id){
				params = params	+"&status_disabled="+disabled;
		}

		if(obj == "menu1"){
			params = params	+"&treatment_flag=Y&trmt_level_flag=Y"; //trmt_level_flag is added by Sridevi Joshi on 3/19/2010 for IN018200
		} 
		else if(obj == "menu5"){
			params = params	+"&trmt_done_yn=Y&trmt_level_flag=Y";//trmt_level_flag is added by Sridevi Joshi on 3/19/2010 for IN018200
		}

		parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params;	
		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function showCharges(task_code,rownum,chart_num,chart_line_num,trmt_code,order_id){
	switchChargesMenu(rownum,chart_num,chart_line_num);

	var include_yn = "";
	var approval_reqd_yn = "";

	var payable_label = getLabel("eOH.Payable.Label","OH");
	var paid_label = getLabel("eOH.Paid.Label","OH");
	var total_label = getLabel("eOH.Total.Label","OH");
	var Include_Exclude_label = getLabel("Common.Included.label","Common")+"?";
	var approval_label = getLabel("eOH.ApprovalRequired.Label","OH")+"?";

	var formObj = document.trmtViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var episode_type = formObj.episode_type.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	var encounter_id = formObj.encounter_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var order_id_value = "";

	//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params_facility = 		"patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&order_id="+order_id;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getSeqNoOfTask&"+params_facility,false);
	xmlHttp.send(xmlDoc);
	var seq_no_retVal = trimString(xmlHttp.responseText);
	seq_no_retVal = localTrimString(seq_no_retVal);
	seq_no_retVal_arr = seq_no_retVal.split("##");
	var seq_no = seq_no_retVal_arr[0];
	var task_seq_no = seq_no_retVal_arr[1];

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var encounter_params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&trmt_code="+trmt_code+"&task_code="+task_code+"&seq_no="+task_seq_no;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=getEncounterDetails&"+encounter_params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length >1){
		var retVal_arr =  retVal.split("##");
		encounter_id = retVal_arr[0];
		episode_id = retVal_arr[1];
		visit_id = retVal_arr[2];
		order_id_value = retVal_arr[3];
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	

	var params = "trmt_code="+trmt_code+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&task_code="+task_code+"&seq_no="+task_seq_no+"&order_id="+order_id_value;
 
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","TreatmentsViewValidation.jsp?func_mode=getChargeDetails&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	var tab_dat = "<table id ='tasksTable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' background-color ='black'>";
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(k=0;k<retVal_arr.length-1;k++){
			var charges_arr = retVal_arr[k].split("##");
			if(charges_arr[5] == "S"){
				if(charges_arr[3] == "I"){
					include_yn = getLabel("Common.yes.label","Common");
				}
				else{
					include_yn = getLabel("eOH.No.Label","OH");
				}

				if(charges_arr[4] == "Y"){
					approval_reqd_yn = getLabel("Common.yes.label","Common");
				}
				else{
					approval_reqd_yn = getLabel("eOH.No.Label","OH");
				}
			}

			tab_dat     +="<tr><td class='label' nowrap><font color='brown'>&nbsp;"+total_label+":"+charges_arr[2]+"</font></td></tr>";
			tab_dat     +="<tr ><td class='label' nowrap><font color='brown'>&nbsp;"+payable_label+":"+charges_arr[0]+"</font></td></tr>";
			tab_dat     +="<tr ><td class='label' nowrap><font color='brown'>&nbsp;"+paid_label+":"+charges_arr[1]+"</font></td></tr>";
			tab_dat     +="<tr ><td class='label' nowrap><font color='brown'>&nbsp;"+Include_Exclude_label+"&nbsp;"+include_yn+"</font></td></tr>";
			tab_dat     +="<tr ><td class='label' nowrap><font color='brown'>&nbsp;"+approval_label+"&nbsp;"+approval_reqd_yn+"</font></td></tr>";
		}
	}
	
	tab_dat     +="</table>";
	var charges_id = "charges_"+rownum+"_"+chart_num+"_"+chart_line_num;
	document.getElementById(charges_id).innerHTML = tab_dat;
}

function switchChargesMenu(obj,chart_num,chart_line_num) {
	var charges_id = "charges_"+obj+"_"+chart_num+"_"+chart_line_num;
	var el = document.getElementById(charges_id);
	if ( el.style.display != "none" ) {
		el.style.display = 'none';
	}
	else {
		el.style.display = '';
	}
}

function openGingivalStatusSummary(){
	var formObj = document.trmtViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var chart_num = formObj.cur_chart_num.value;
	var gingival_recording_by  = formObj.gingival_recording_by.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;

	var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system+"&chart_num="+chart_num+"&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

    parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/PeriodontalSummaryTitle.jsp?"+params;
    parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+params;
	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function openPeriodontalSummary(){
	var formObj = document.trmtViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
    var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/PerioSummaryFrames.jsp?"+params;
	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function displayBCChart(date,desc,chart_details,obj,clinical_group_code,order_id,chart_type,oh_chart_level,chart_closed_date,chart_status){
	 if(obj == "menuBC"){
		var formObj = document.forms[0];
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var patient_class = formObj.patient_class.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value;
		var upper_arch_desc = formObj.upper_arch_desc.value;
		var lower_arch_desc = formObj.lower_arch_desc.value;
		var otFlag = formObj.otFlag.value;
		var Q1_id = formObj.Q1_id.value;
		var Q2_id = formObj.Q2_id.value;
		var Q3_id = formObj.Q3_id.value;
		var Q4_id = formObj.Q4_id.value;
		var Q1_desc = formObj.Q1_desc.value;
		var Q2_desc = formObj.Q2_desc.value;
		var Q3_desc = formObj.Q3_desc.value;
		var Q4_desc = formObj.Q4_desc.value;

		var header_tab = formObj.header_tab.value;

		var source_code = formObj.source_code.value;
		var source_type = formObj.source_type.value;
		var visit_id = formObj.visit_id.value;
		var episode_id = formObj.episode_id.value;
		var episode_type = formObj.episode_type.value;
		var speciality_code = formObj.speciality_code.value;

		//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
		var dflt_mixed_dentition_chart = formObj.dflt_mixed_dentition_chart.value;

		var mixed_dentition_YN = "";
		if(chart_type == "RD"){
			mixed_dentition_YN = "N";
			permanent_deciduous_flag = "D";
		}
		else if(chart_type == "RM" ){
			mixed_dentition_YN = "Y";
			//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
			if(dflt_mixed_dentition_chart == "D"){
				permanent_deciduous_flag = "D"; // Deciduous
			}
			else{
				permanent_deciduous_flag = "P"; // Permament
			}
		}
		else{
			mixed_dentition_YN = "N";
			permanent_deciduous_flag = "P"; // Permament
		}

		if(chart_status=="A"){
			params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&chart_hdr_insert_yn=N&baseline_chart_yn=N"+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status+"&default_head_tab=Treatment"+"&oh_chart_level="+oh_chart_level+"&called_from="+otFlag;
		
        }else{
			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y"+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&default_head_tab=Treatment"+"&oh_chart_level="+oh_chart_level+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&asOnDatePrint_Baseline_YN="+chart_closed_date+"&chart_num_baseline_yn="+desc+"&called_from="+otFlag;

		}

		params=params;/* Added for CRF-0487 inc.10936*/
		var params1 = params+"&baseline_date="+date;
		parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params1;
        
		if(chart_status!="A"){
			parent.trmtDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;
		}
		parent.trmtDentalChartDataEntry.location.href="../../eOH/jsp/DentalTreatment.jsp?"+params;
		parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params;
		
		document.location.href="../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+params;
     
		parent.parent.parent.mainTabHeaderFrame.Condition.disabled=true;
		parent.parent.parent.mainTabHeaderFrame.Treatment.disabled=true;
        
     }
}

async function placeLBOrders(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var episode_id = formObj.episode_id.value;
	var encounter_id = formObj.encounter_id.value;
	var facility_id = formObj.facility_id.value;
	var location_code = formObj.location_code.value;
	var location_type = formObj.location_type.value;
	var patient_class = formObj.patient_class.value;
	var order_catalog_code = "";//formObj.order_catalog_code.value;
	var order_type_code = "";//formObj.order_type_code.value;
	var dialogHeight ='70vh' ;
	var dialogWidth = '75vw' ;
	var dialogTop	= '105';
	var dialogLeft = '147' ;

	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var bean_id = "externalordersbean";
	var bean_name = "eOR.ExternalOrdersBean";
	var finalString = 'patient_id='+patient_id+'&practitioner_id='+practitioner_id+'&function_from=EXTERNAL_ORDER&p_start_date_time=&p_order_catalog_code='+order_catalog_code+'&episode_id='+episode_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&location_code='+location_code+'&location_type='+location_type+'&patient_class='+patient_class+'&ext_order_category=LB&order_type_code='+order_type_code;
	var order_id = await window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	
}

async function linkLBRDOrders(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.cur_chart_num.value;
	var dialogHeight ='70vh' ;
	var dialogWidth = '70vw' ;
	var dialogTop	= '105';
	var dialogLeft = '147' ;

	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var finalString = "patient_id="+patient_id+"&chart_num="+chart_num;
	var order_id = await window.showModalDialog("../../eOH/jsp/LinkLBRDOrdersFrame.jsp?"+finalString,arguments,features);

}

//Added by Sharon Crasta on 3/14/2009  for other facility chart CRF#0423
function displayFacilityChart(date,desc,chart_details,obj,clinical_group_or_remarks,RD_D_yn,chart_type,cusp_tip_code,ext_trmt_status,chart_status,facility_id){
	/*
	Order of elements in chart_details:		
	CHART_NUM:CHART_LINE_NUM:CHART_STATUS:CHART_DATE:SITE_TYPE:TOOTH_NO:NS_TOOTH_NO:ARCH_SNO:QUADRANT_SNO:SURFACE_CODE:CONDITION_TYPE:CONDITION_CODE
	*/	
	 if(obj == "menuFC"){//Other Facility Charts
		var formObj = document.forms[0];
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var patient_class = formObj.patient_class.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value;
		var source_code = formObj.source_code.value;
		var source_type = formObj.source_type.value;
		var visit_id = formObj.visit_id.value;
		var episode_id = formObj.episode_id.value;
		var episode_type = formObj.episode_type.value;
		var speciality_code = formObj.speciality_code.value;
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
		var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
		var oh_chart_level = formObj.oh_chart_level.value;

		var default_header_tab = "";

		var mixed_dentition_YN = "";
		if(chart_type == "RD"){
			mixed_dentition_YN = "N";
			permanent_deciduous_flag = "D";
		}
		else if(chart_type == "RM" ){
			mixed_dentition_YN = "Y";
		}
		else{
			mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		}
		var chart_type = formObj.chart_type.value;
		var header_tab = formObj.header_tab.value;
		if (header_tab == "T")
		{
			default_header_tab = "Treatment";
		}
		if (chart_status=="A"){
			params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status+"&other_chart_facility_id="+facility_id+"&other_facilitychart_yn=Y"+"&oh_chart_level="+oh_chart_level;
		}else{
			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+facility_id;
		}
		var params1 = params+"&baseline_date="+date+"&default_head_tab="+default_header_tab;

		parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params1;

		parent.parent.trmtDentalChart.location.href="../../eOH/jsp/OHDentalChartTrmtDetailsFrame.jsp?"+params;

		if(chart_status!="A"){
			parent.trmtDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;
		}

		parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params1;

		document.location.href="../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?"+params;

		parent.parent.parent.mainTabHeaderFrame.Condition.disabled=true;
		parent.parent.parent.mainTabHeaderFrame.Treatment.disabled=true;

	}
}



async function showDentistComments(locale){
	var readOnlyYN = "N";
	var dentistComments = document.getElementById("dentist_comments").value;
	var dentistComments_hid = document.getElementById("dentist_comments").value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].cur_chart_num.value;
	var oh_chart_level = document.forms[0].oh_chart_level.value;
	var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
	var baseline_chart_yn = document.forms[0].baseline_chart_yn.value;
	var asOnDate = parent.parent.parent.frames[0].document.forms[0].asOnDate.value;
	
	dentistComments = encodeURIComponent(dentistComments);
	
	title = getLabel("eOH.DentistComments.Label","OH");
	
	dentistComments = encodeURIComponent(dentistComments); 
	if(baseline_chart_yn == "Y"){
		readOnlyYN = "Y";
	}
	if(dentistComments == null || dentistComments == "null"){
		dentistComments = ""; 
	}
	
	if(baseline_chart_yn != "Y"){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var treatment_condition_tab_flag = "C";//formObj.header_tab.value;
		var params = "patient_id="+patient_id+"&asOnDate="+asOnDate;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/PrintChartValidation.jsp?func_mode=getAsOnChartStatus&"+params,false);
		xmlHttp.send(xmlDoc);
		var chart_status = localTrimString(xmlHttp.responseText);
		var chart_status_arr = chart_status.split("##");
		if(chart_status_arr[0] == "C" ){
			readOnlyYN = "Y";  
		}
		chart_num =  chart_status_arr[1];
	}
	var retVal = await window.showModalDialog("../../eOH/jsp/TextArea.jsp?heading="+title+"&remarks="+dentistComments+"&readOnlyYN="+readOnlyYN+"&flagForPrint=Y"+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id,window,"dialogHeight: 55vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	//retVal = encodeURIComponent(retVal);

	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.getElementById("dentist_comments").value = dentistComments;
	}
	else{
		document.getElementById("dentist_comments").value = retVal;
	}

}		


async function showMaxilaFacialDtlTrmt(){
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].cur_chart_num.value
	var maxilaFacialDetail_label = getLabel("eOH.MaxilaFacialDetails.Label","OH");
	var oh_chart_level = document.forms[0].oh_chart_level.value
	var header_tab = document.forms[0].header_tab.value
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value
	var retVal = await window.showModalDialog("../../eOH/jsp/MaxilaFacialDetails.jsp?heading="+maxilaFacialDetail_label+"&patient_id="+patient_id+"&chart_num="+chart_num+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level+"&tooth_numbering_system="+tooth_numbering_system,window,"dialogHeight: 55vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
					
}

