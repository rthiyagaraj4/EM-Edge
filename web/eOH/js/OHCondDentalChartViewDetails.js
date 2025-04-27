//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
var isExfoliated = false;
var count_GS = 0;
var isStatus = false;
var tooth_no_GS = false;
var tooth_no_status_Z = "";
var count_GS = 0;
var isNonSuperExfoliate = false;
var isSuperYN = false; 
var flag_permanent_deciduous_tooth = 0; 
var isDeciduous = false; 
var hasChanged = false;
var isDeciduousTooth = false;
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
	var formObj = document.condViewDetailsForm;
	var disable_fields_YN = "";
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
    var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var asondate = parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].asOnDate.value;
	var baseline_chart_yn = parent.parent.parent.conditionDentalChartToolHeader.document.forms[0].baseline_chart_yn.value;
	//var chart_num =formObj.chart_num.value;
	var chart_num =formObj.cur_chart_num.value;
	var oh_chart_level =formObj.oh_chart_level.value;
	var other_chart_facility_id =formObj.other_chart_facility_id.value;
	var locale = formObj.locale.value;
	var gingival_recording_by = formObj.gingival_recording_by.value;
	var record_gingival_status_yn_param = formObj.record_gingival_status_yn_param.value; 
	var condition_date;
	var condition_type;
	var index;
	/*
		menuDC (Dental Conditions)
		menuET (External Treatment)
		menuBC (Baseline Chart)
		menuCN (Clinical Notes)
		menuOL (Other Links)
		menuFC (Other Facility Charts)
		menuGS (Gingival Status)
	*/
	var addnew_label = getLabel("Common.Add/New.label","Common");
	var closed_chart_label = getLabel("eOH.ClosedChart.Label","OH");//"Closed Chart";
	var active_chart_label = getLabel("eOH.ActiveChart.Label","OH");//"Active Chart";
	if(obj!=null && obj!=""){
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' >";
		if(obj=="menuBC"){
			// Display the 1st row as Add/New
			tab_dat     += "<tr>";
			//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
			//tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
			var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
			if(chart_disable_from_main == "Y"){
				tab_dat     += '<td class="LABEL"><div align="left"></div></td>';
			}else{//End
				tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
				tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayNewChart(\'NEW\',\''+addnew_label+'\');\">'+addnew_label+'</a></div></td>';
			}
			tab_dat     += "</tr> ";
		}
		
		if(obj=="menuOL"){ // Other Links
			//Display Individual Links, Diagnosis comes 1st
			var diagnosis_label = getLabel("Common.diagnosis.label","Common");
			var clinicalnotes_label = getLabel("Common.ClinicalNotes.label","Common");
			var progressnotes_label = getLabel("eOH.ProgressNotes.Label","OH");  // Added by Yadav fro CRF499 on 1/25/2010
			var maxilaFacialDetail_label = getLabel("eOH.MaxilaFacialDetails.Label","OH");  // Added by Yadav fro CRF476
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openDiagnosis();\">'+diagnosis_label+'</a></div></td>';
			tab_dat     += "</tr> ";
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openClinicalNotes();\">'+clinicalnotes_label+'</a></div></td>';
			tab_dat     += "</tr> ";
			tab_dat     += "<tr>";
		 // Added by Yadav fro CRF499 on 1/25/2010   for ProgressNotes
		
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openProgressNotes();\">'+progressnotes_label+'</a></div></td>';
			tab_dat     += "</tr> ";
		// Added by Yadav for CRF476
			var rFlag="";
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
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getMaxillaConditionFlag&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal="";
			retVal= trimString(xmlHttp.responseText);
			if(parseInt(retVal)>0){
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:showMaxilaFacialDtl();\">'+maxilaFacialDetail_label+'</a></div></td>';
			tab_dat     += "</tr> ";
			}
		
		}

		if(obj == "menuDC"){ // Dental Conditions
            //var  isCond_super_tooth_no=0;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&asondate="+asondate+"&baseline_chart_yn="+baseline_chart_yn+"&chart_num="+chart_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateConditionDateType&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;

			if(retVal.length>1){
			// Commented by Sharon Crasta on 1/13/2009 for CRF #0377 because the delimiters used here are OH_SEP_2 and OH_SEP_1 to take care of special characters.
				var retVal_arr = retVal.split("OH_SEP_2");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("OH_SEP_1");
					var supr_key_num = code_desc_arr[14];
					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';

					code_desc_arr[9] = escape(code_desc_arr[9]);
					code_desc_arr[9] = encodeURIComponent(code_desc_arr[9]);
					// testing for Maxilla  and tooth range
					
					if(code_desc_arr[7] == "THRNG" || (code_desc_arr[7]=="MAXFS" &&(code_desc_arr[13]==("TNGAB") || code_desc_arr[13]==("TNGGM") || code_desc_arr[13]==("TNGAG") || code_desc_arr[13]==("TNGGAM") || code_desc_arr[13]==("TNGMF")))){
						if(code_desc_arr[4] == "NA"  && (code_desc_arr[2] == "null" || code_desc_arr[2] == null || code_desc_arr[2] == "")){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == ""){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[9] != "M" && code_desc_arr[9] != "D" && code_desc_arr[9] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[7]!="MAXFS"){
							if(code_desc_arr[10] == "" || code_desc_arr[10] == null || code_desc_arr[10] == "null"){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
							}
						}
						else if((code_desc_arr[9] == "D" || code_desc_arr[9] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")  && code_desc_arr[7]!="MAXFS"){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[11] == "Y"){
							/*tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+'s:'+code_desc_arr[1]+')</a></div></td>';	*/					
						}else if(code_desc_arr[7]=="MAXFS" ){
							var code_desc_arr_max="";
							var code_desc_arr_max_1="";
							var max_changed_num="";
							var retVal_num="";
							var retVal_num_1="";
							var tooth_no_num="";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var tootn_num=code_desc_arr[14];
							if(tootn_num.indexOf(",") != -1){
								var tootn_num_1=tootn_num.split(",");
								for(var x=0;x<tootn_num_1.length;x++){
									var code_desc_arr_num = tootn_num_1;
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr_num[x]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_condition = trimString(xmlHttp.responseText);
										
									if(retVal_condition.length!=1){
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+code_desc_arr_num[x]+"&numbering_system="+tooth_numbering_system;
											
										if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = localTrimString(xmlHttp.responseText);
											
											for(var y=0;y<retVal_num.length;y++){
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
												// retVal_num_1=retVal_num_1+"s";
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
												if(code_desc_arr_1[0] == "RTDESTH" ){
													isRetainedDeciduous = "true";
												}
											}
										}

										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+code_desc_arr_num[x]+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
										if(code_desc_arr_1[0]=="EXFOLTH"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = trimString(xmlHttp.responseText);
											for(var q=0;q<retVal_num.length;q++){
												code_desc_arr_max = retVal_num.split("##");	
											}
										}else if (code_desc_arr_1[0]=="DECITH"  && permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = trimString(xmlHttp.responseText);
											for(var z=0;z<retVal_num.length;z++){
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
											for(var s=0;s<retVal_num.length;s++){
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

									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
								}else if (isSuperYN=="true" && permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
								}else if (isSuperYN_super=="true" && permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						

								}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									if(isDeciduous){
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
									}else if (isExfoliatedRD!="true"){ 
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';	
									}else {
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
									}
								}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
							
									if (isRetainedDeciduous!="true" && isExfoliatedNorm=="true"){
										//max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';
										isExfoliatedNorm="false";
									}else{
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
									}
								}
								else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';

								}
							}
						}
						else{
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
						}
					}

					// by Sharon Crasta on 1/7/2009 for CRF #0377 and added code_desc_arr[9](remarks) as argument to displayThisChart
					if(code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == ""){
						if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+'['+supr_key_num+']:'+code_desc_arr[1]+')</a></div></td>';
						}
						else{
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a></div></td>';
						}
					}
					else if((code_desc_arr[6] == "D" || code_desc_arr[6] == "R") && code_desc_arr[7] == "Y"){
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							 if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\')</a></div></td>';
							 }
							 else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+supr_key_num+']'+':'+code_desc_arr[1]+',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\')</a></div></td>';
							 }
							 else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
							 }
						}
						else{
							  if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[5]+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+'['+supr_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
							  }
							 else{
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';

							 
							 }
						}
					}
					else if((code_desc_arr[6] == "D" || code_desc_arr[6] == "R")){
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						   tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else{
							 if (code_desc_arr[12]!=null && code_desc_arr[12]!="null" && code_desc_arr[12]!=""){//added by parul on 22/12/2009 for retained changes for Permanent,Deciduous chart.
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';
							}else{
								//Commented by Sridevi Joshi on 4/13/2010 for IN020641...Permanent tooth no was getting displyed after DECITH condition
								/*if(code_desc_arr[1]=="Deciduous Tooth" && code_desc_arr[6] == "D"){
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';	
								}else{*/
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';	
								//}
							}
						}
					}
					else if(code_desc_arr[6] != "M" && code_desc_arr[6] != "D" && code_desc_arr[6] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[7] == "Y"){
						if(code_desc_arr[10] == "2" ||  code_desc_arr[10] == "3" || code_desc_arr[10] == "14" || code_desc_arr[10] == "15" || code_desc_arr[10] == "18" || code_desc_arr[10] == "19" || code_desc_arr[10] == "30" || code_desc_arr[10] == "31"){
							  if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+supr_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else{
							    tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';

							 }
						
						}
						else{
							  if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[5]+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+'['+supr_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else{
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';							 
							 }
						}
					}
					else if(code_desc_arr[6] != "M" && code_desc_arr[6] != "D" && code_desc_arr[6] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						if(code_desc_arr[5] == "" || code_desc_arr[5] == null || code_desc_arr[5] == "null"||code_desc_arr[5] =="undefined"){ //for extreame tooth
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
							if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){ //Added by Sridevi Joshi on 2/15/2010 for IN019343
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+supr_key_num+']:'+code_desc_arr[1]+')</a></div></td>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
							}
						}
						else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+'['+supr_key_num+']:'+code_desc_arr[1]+')</a></div></td>';
						}
						else{
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';
						}
					}
					//Added by Sharon Crasta on 10/28/2009 for IN012514
					//code_desc_arr[7] is added by Sridevi Joshi on 02/10/09 for IN015475
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[6] == "M" && code_desc_arr[7] == "Y"){
						 if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a></div></td>';
						 }
						 else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
							 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+supr_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
						 }
						 else{
							 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
						 
						 }
					}//End
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[6] == "M"){//Added by Sridevi Joshi on 30/10/09 for IN015475
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
					}
					//else if(code_desc_arr[7] == "Y"){// commented and added by parul on 11/12/2009 for super changes for Permanent,Deciduous chart.
					else if(code_desc_arr[11] != "" && code_desc_arr[11] != "null" && code_desc_arr[11] != null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+supr_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a></div></td>';
				   }
				   else if (code_desc_arr[12]!=null && code_desc_arr[12]!="null" && code_desc_arr[12]!=""){//added by parul on 22/12/2009 for retained changes for Permanent,Deciduous chart.
					   		tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[5]+':'+code_desc_arr[1]+')</a></div></td>';
				   }
				   else if(supr_key_num != "" && supr_key_num != "null" && supr_key_num != null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+supr_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
				   }
				   else if(code_desc_arr[7]=="MAXFS"){
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[13]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
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
											if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[1] == "N"&& code_desc_arr_1[4] == "Y"){
												isSuperYN_super = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N" && code_desc_arr_1[4] == "Y"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "UNERTH" && code_desc_arr_1[3] == "N" && code_desc_arr_1[4] == "N"){
												isUNErupted="true";

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
											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}
											if(code_desc_arr_1[0] == "SUPRTH" ){
												
												isSuperYN = "true";
											}
										}
									}
									if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
										if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
											isExfoliatedNorm="false"
										}
										else if (isRetainedDeciduous=="true" && isUNErupted=="true" && isExfoliatedRD!="true" &&	isExfoliatedNorm!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
											isExfoliatedRD="false"
										}
										else if (isRetainedDeciduous=="true" && (isExfoliatedRD!="true" || isExfoliatedNorm!="true")){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else if(isSuperYN=="true" && isSuperYN_super=="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else if(isSuperYN=="true" && isSuperYN_super!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
										if(isSuperYN=="true" && isSuperYN_super_1=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}else if(isExfoliatedNorm=="true" && isSuperYN!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isExfoliatedNorm=="true" && isSuperYN=="true" && isSuperYN_super_1!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
										if (isDeciduous=="true")	{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										
										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"  && isExfoliatedRD!="true"  &&	isDeciduous!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';

										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm!="true"  && isExfoliatedRD=="true"  &&	isDeciduous!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';

										}else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}

									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
										if (isExfoliatedNorm=="true" && isRetainedDeciduous=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isUNErupted=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isExfoliatedNorm=="true" && isRetainedDeciduous!=true && isUNErupted!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}
								}else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
								}
							}
				   else{
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[9]+'\',\''+code_desc_arr[6]+'\',\'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[7]+'\',\''+code_desc_arr[11]+'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[14]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
					}

					tab_dat     += "</tr> ";
				}
			}
			
		}
		else if(obj == "menuBC"){ // BaseLine Charts
			//active charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&chart_status=A";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateBaseLineChart&"+params,false);
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
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += "</tr> ";
					}
					else if(code_desc_arr[3] == "RM"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += "</tr> ";
					}
					else{
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
				
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
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
           
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ;
					if(code_desc_arr[3] == "RD"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
						tab_dat     += "</tr> ";
					}
					else if(code_desc_arr[3] == "RM"){
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
						tab_dat     += "</tr> ";
					}
					else{
						tab_dat     += "<tr>";
						tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
						tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C\');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a></div></td>';
					
						tab_dat     += "</tr> ";

					}
				}
			}
		}
	else if(obj == "menuET"){ // Ext treatments
	       // var isCond_super_tooth_no=0;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&asondate="+asondate+"&baseline_chart_yn="+baseline_chart_yn+"&chart_num="+chart_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateExtTreatments&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length>1){
				var retVal_arr = retVal.split("OH_SEP_2");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("OH_SEP_1");
					var super_key_num = code_desc_arr[17];
					code_desc_arr[0] =   convertDate(code_desc_arr[0],'DMY','en',locale) ; //
					if(code_desc_arr[5] == null || code_desc_arr[5] == "null"){
						code_desc_arr[5] = "";
					}
					code_desc_arr[5] = escape(code_desc_arr[5]);
					code_desc_arr[5] = encodeURIComponent(code_desc_arr[5]);

					var chart_details_arr	= code_desc_arr[3].split(":");
					var trmt_location=chart_details_arr[16];
					trmt_location = escape(trmt_location);
					trmt_location = encodeURIComponent(trmt_location);
					chart_details_arr[16]=trmt_location;
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';

					/*if (code_desc_arr[15].length>=2){//added by parul on 08/12/2009 for super change 
						isCond_super_tooth_no=code_desc_arr[15].substring(code_desc_arr[15].length-1,code_desc_arr[15].length);
					}*/

					if(code_desc_arr[7] == "THRNG" || (code_desc_arr[7]=="MAXFS" &&(code_desc_arr[13]==("TNGAB") || code_desc_arr[13]==("TNGGM") || code_desc_arr[13]==("TNGAG") || code_desc_arr[13]==("TNGGAM") || code_desc_arr[13]==("TNGMF")))){	
						if(code_desc_arr[4] == "NA"  && (code_desc_arr[2] == "null" || code_desc_arr[2] == null || code_desc_arr[2] == "")){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == ""){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[9] != "M" && code_desc_arr[9] != "D" && code_desc_arr[9] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[7]!="MAXFS"){
							if(code_desc_arr[10] == "" || code_desc_arr[10] == null || code_desc_arr[10] == "null"){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
							}
						}
						else if((code_desc_arr[9] == "D" || code_desc_arr[9] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")  && code_desc_arr[7]!="MAXFS"){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[11] == "Y"){
							/*tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+'s:'+code_desc_arr[1]+')</a></div></td>';	*/					
						}else if(code_desc_arr[7]=="MAXFS" ){
							var code_desc_arr_max="";
							var code_desc_arr_max_1="";
							var max_changed_num="";
							var retVal_num="";
							var retVal_num_1="";
							var tooth_no_num="";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var tootn_num=code_desc_arr[14];
							if(tootn_num.indexOf(",") != -1){
								var tootn_num_1=tootn_num.split(",");
								for(var x=0;x<tootn_num_1.length;x++){
									var code_desc_arr_num = tootn_num_1;
									var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr_num[x]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
									var xmlStr ="<root><SEARCH ";
									xmlStr +=" /></root>";
									xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
									xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
									xmlHttp.send(xmlDoc);
									var retVal_condition = trimString(xmlHttp.responseText);
										
									if(retVal_condition.length!=1){
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+code_desc_arr_num[x]+"&numbering_system="+tooth_numbering_system;
											
										if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = localTrimString(xmlHttp.responseText);
											
											for(var y=0;y<retVal_num.length;y++){
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
												// retVal_num_1=retVal_num_1+"s";
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
												if(code_desc_arr_1[0] == "RTDESTH" ){
													isRetainedDeciduous = "true";
												}
											}
										}

										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "tooth_no="+code_desc_arr_num[x]+"&numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
										if(code_desc_arr_1[0]=="EXFOLTH"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = trimString(xmlHttp.responseText);
											for(var q=0;q<retVal_num.length;q++){
												code_desc_arr_max = retVal_num.split("##");	
											}
										}else if (code_desc_arr_1[0]=="DECITH"  && permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
											var xmlStr ="<root><SEARCH ";
											xmlStr +=" /></root>";
											xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
											xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
											xmlHttp.send(xmlDoc);
											retVal_num = trimString(xmlHttp.responseText);
											for(var z=0;z<retVal_num.length;z++){
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
											for(var s=0;s<retVal_num.length;s++){
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

									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
								}else if (isSuperYN=="true" && permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
								}else if (isSuperYN_super=="true" && permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						

								}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
									if(isDeciduous){
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
									}else if (isExfoliatedRD!="true"){ 
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';	
									}else {
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';						
									}
								}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
									max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
							
									if (isRetainedDeciduous!="true" && isExfoliatedNorm=="true"){
										//max_changed_num=retVal_num_1+","+code_desc_arr_max_1;
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+max_changed_num+':'+code_desc_arr[1]+')</a></div></td>';
										isExfoliatedNorm="false";
									}else{
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
									}
								}
								else{
									tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';

								}
							}
						}
						else{
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[6]+':'+code_desc_arr[1]+')</a></div></td>';
						}
					}//end THRNG
					else{
						if(code_desc_arr[4] == "NA"  && (code_desc_arr[2] == "null" || code_desc_arr[2] == null || code_desc_arr[2] == "")){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a></div></td>';
						}
						else if((code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == "") && code_desc_arr[7]!="MAXFS"){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[4]+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else if(code_desc_arr[9] != "M" && code_desc_arr[9] != "D" && code_desc_arr[9] != "R" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && code_desc_arr[7]!="MAXFS"){
							 if(code_desc_arr[15] != "" && code_desc_arr[15] != "null" && code_desc_arr[15] != null){//added by parul on 11/12/2009 for super change
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[10]+']'+':'+code_desc_arr[1]+')</a></div></td>';
							 }
							 else if (code_desc_arr[16]!="" && code_desc_arr[16]!="null" && code_desc_arr[16]!=null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';

							}else{
								 //tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
								 tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
							 }
						}
						else if((code_desc_arr[9] == "D" || code_desc_arr[9] == "R") && !(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D")){
							if(code_desc_arr[15] != "" && code_desc_arr[15] != "null" && code_desc_arr[15] != null){//added by parul on 11/12/2009 for super change
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[10]+']:'+code_desc_arr[1]+')</a></div></td>';
							}
							else{
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
							}
						}
						//else if(code_desc_arr[11]!=("") && super_key_num != "s0"){//added by parul on 11/12/2009 for super num changes	
						else if(code_desc_arr[15] != "" && code_desc_arr[15] != "null" && code_desc_arr[15] != null){//added by parul on 11/12/2009 for super num changes	
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+'['+code_desc_arr[2]+']'+':'+code_desc_arr[1]+')</a></div></td>';

						}
						else if (code_desc_arr[16]!="" && code_desc_arr[16]!="null" && code_desc_arr[16]!=null){
							tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';

						}
						else if(super_key_num != "" && super_key_num != "null" && super_key_num != null){
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+'['+super_key_num+']'+':'+code_desc_arr[1]+')</a></div></td>';
						}
						else{
							if(code_desc_arr[7]=="MAXFS"){
							
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[13]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
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
											if(code_desc_arr_1[0] == "EXFOLTH" &&code_desc_arr_1[1] == "N"&& code_desc_arr_1[4] == "Y"){
												isSuperYN_super = "true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "N" && code_desc_arr_1[4] == "Y"){
												isExfoliatedRD="true";

											}
											if(code_desc_arr_1[0] == "EXFOLTH" && code_desc_arr_1[2] == "R"){
												isExfoliatedNorm="true";

											}
											if(code_desc_arr_1[0] == "UNERTH" && code_desc_arr_1[3] == "N" && code_desc_arr_1[4] == "N"){
												isUNErupted="true";

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
											}
											if(code_desc_arr_1[0] == "RTDESTH" ){
												isRetainedDeciduous = "true";
											}
											if(code_desc_arr_1[0] == "SUPRTH" ){
												
												isSuperYN = "true";
											}
										}
									}
								    
									 if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="N"){
										if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
											isExfoliatedNorm="false"
										}
										else if (isRetainedDeciduous=="true" && isUNErupted=="true" && isExfoliatedRD!="true" &&	isExfoliatedNorm!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
											isExfoliatedRD="false"
										}
										else if (isRetainedDeciduous=="true" && (isExfoliatedRD!="true" || isExfoliatedNorm!="true")){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else if(isSuperYN=="true" && isSuperYN_super=="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else if(isSuperYN=="true" && isSuperYN_super!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="N"){
										if(isSuperYN=="true" && isSuperYN_super_1=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}else if(isExfoliatedNorm=="true" && isSuperYN!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isExfoliatedNorm=="true" && isSuperYN=="true" && isSuperYN_super_1!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+super_key_num+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}else if(permanent_deciduous_flag=="P" && mixed_dentition_YN=="Y"){
										if (isDeciduous=="true" && isExfoliatedDec != "true"){// isExfoliatedDec is addded by Sridevi Joshi on 4/7/2010
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										
										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm=="true"  && isExfoliatedRD!="true"  &&	isDeciduous!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';

										}else if (isRetainedDeciduous=="true" && isExfoliatedNorm!="true"  && isExfoliatedRD=="true"  &&	isDeciduous!="true") {
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';

										}else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}

									}else if(permanent_deciduous_flag=="D" && mixed_dentition_YN=="Y"){
										if (isExfoliatedNorm=="true" && isRetainedDeciduous=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isUNErupted=="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}else if (isExfoliatedNorm=="true" && isRetainedDeciduous!=true && isUNErupted!="true"){
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[10]+':'+code_desc_arr[1]+')</a></div></td>';
										}
										else{
											tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
										}
									}
								}else{
									 if(code_desc_arr[2] == null || code_desc_arr[2] == "null" || code_desc_arr[2] == ""){
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[1]+')</a></div></td>';
									 }else{
										tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
									 }
								}
							}else{
								
								tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayThisChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[3]+'\',\''+obj+'\',\''+code_desc_arr[5]+'\',\''+code_desc_arr[9]+'\',\'\',\''+code_desc_arr[12]+'\',\''+code_desc_arr[8]+'\',\'\',\'\',\'\',\'\',\''+code_desc_arr[15]+'\',\''+code_desc_arr[16]+'\',\''+super_key_num+'\',\''+code_desc_arr[18]+'\');\">'+code_desc_arr[0]+'('+code_desc_arr[2]+':'+code_desc_arr[1]+')</a></div></td>';
							}
						}
					}

					tab_dat     += "</tr> ";
				}
			}
		}
		else if(obj == "menuGS"){ // Gingival Status
			var date_label = getLabel("Common.date.label","Common");
			var tooth_label = getLabel("eOH.Th.Label","OH");
			var GS_label = getLabel("eOH.GS.Label","OH");
			var Id_label = getLabel("eOH.Id.Label","OH");

			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&tooth_numbering_system="+tooth_numbering_system+"&asondate="+asondate+"&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&chart_num="+chart_num;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ChatViewValidation.jsp?func_mode=populateGingivalStatus&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;
		
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td nowrap id="mouse" ><div align="center">&nbsp;</div></td>';
				tab_dat     += '<td class="LABEL" width="">'+Id_label+'</td><td class="LABEL">'+tooth_label+'</td><td class="LABEL">'+GS_label+'</td><td class="LABEL">'+date_label+'</td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[5] =   convertDate(code_desc_arr[5],'DMY','en',locale) ;
					var exfoliate_deciduous_tooth = code_desc_arr[2];
					//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					var disply_tooth_no_exfoliation = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+code_desc_arr[8]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_exf = trimString(xmlHttp.responseText);
					retVal_exf=localTrimString(retVal_exf);
					if(retVal_exf.length > 0){
						disply_tooth_no_exfoliation = retVal_exf;
					}
					var disply_tooth_no_deciduous = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+code_desc_arr[6]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith= trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");
					disply_tooth_no_deciduous = retVal_decith_arr[0];	
							
					if(mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D"){
						if(code_desc_arr[9] == "A"){
						   code_desc_arr[2]	= disply_tooth_no_exfoliation;
						 }
						 if(code_desc_arr[9] == "S"){
						   code_desc_arr[2]	= code_desc_arr[2];
						 }
						 if(code_desc_arr[9] == "R"){
							code_desc_arr[2] = 	disply_tooth_no_deciduous;
						 }
						 if(code_desc_arr[9] == "S"){
						   code_desc_arr[2]	= disply_tooth_no_deciduous;
						 }							 
					}else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P"){
						if(code_desc_arr[9] == "D"){
							 code_desc_arr[2] =  disply_tooth_no_deciduous;
						}
						if(code_desc_arr[9] == "C"){
							 code_desc_arr[2] =  disply_tooth_no_deciduous;
						}
					} 
					else{
						if(code_desc_arr[9] == "S"){
							 code_desc_arr[2] =  code_desc_arr[2];
						}
						if(code_desc_arr[9] == "R"){
							code_desc_arr[2] = 	divsply_tooth_no_deciduous;
						}
					} 	
					isExfoliated = false;
					isStatus = false;
					count_GS = 0;
					isNonSuperExfoliate = false;

					tab_dat     += "<tr>";

					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
					
					tab_dat     += '<div align="left"><td class="LABEL">'+code_desc_arr[7]+'</td><td class="LABEL"><a href=\"javascript:displayGSChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[3]+'\',\''+code_desc_arr[4]+'\',\''+code_desc_arr[6]+'\',\''+code_desc_arr[9]+'\');\">'+code_desc_arr[2]+'</a></td><td class="LABEL">'+code_desc_arr[3]+'</td><td class="LABEL">'+code_desc_arr[5]+'</td></div>';					
					tab_dat     += "</tr> ";
				}
			}
		}
		else if(obj=="menuSummary"){    //Summary
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
					tab_dat     += '<td class="LABEL"><div align="left" onClick=\"javascript:GSSummaryNoData();\">'+gingivalstatussummary_label+'</div></td>';
				}else{
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openGingivalStatusSummary();\">'+gingivalstatussummary_label+'</a></div></td>';
				}
				tab_dat     += "</tr> ";
			}

			//if(record_gingival_status_yn_param == "Y" && (permanent_deciduous_flag == "P" && mixed_dentition_YN == "N")){
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
					tab_dat     += '<td class="LABEL"><div align="left" onClick=\"javascript:PerioSummaryNoData();\">'+periodontalsummary_label+'</div></td>';
				}
				else{
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:openPeriodontalSummary();\">'+periodontalsummary_label+'</a></div></td>';
				}
				tab_dat     += "</tr> ";
			}
		}else if (obj=="menuFC"){//Other Facility Charts           //added by parul  for other facility chart CRF#0423
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
								tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
								tab_dat     += "</tr> ";
							}
							else if(code_desc_arr[3] == "RM"){
								tab_dat     += "<tr>";
								tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
								tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
								tab_dat     += "</tr> ";
							}
							else{
								tab_dat     += "<tr>";
								tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
								tab_dat     += "&nbsp;&nbsp;";
								tab_dat  +='<a aligh="center"  href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'A'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>';

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
								tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[D]</div></td>';
								tab_dat     += "</tr> ";
							}
							else if(code_desc_arr[3] == "RM"){
								tab_dat     += "<tr>";
								tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
								tab_dat     += '<td class="LABEL"><div align="middle"><a href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>[M]</div></td>';
								tab_dat     += "</tr> ";
							}
							else{
								tab_dat     += "<tr>";
								tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
								tab_dat     += "&nbsp;&nbsp;";
								tab_dat  +='<a aligh="center"  href=\"javascript:displayFacilityChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\'\',\''+obj+'\',\''+code_desc_arr[2]+'\',\'\',\''+code_desc_arr[3]+'\',\'\',\'\',\'C'+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'-'+code_desc_arr[0]+'</a>';

								tab_dat     += "</td></tr> ";
							
							}
						}
					}
				}
			}
		}
		
		tab_dat     += "</table> ";	
		document.getElementById(obj).innerHTML = tab_dat;
	}
}

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


function displayThisChart(date,desc,chart_details,obj,clinical_group_or_remarks,RD_D_yn,chart_type,cusp_tip_code,ext_trmt_status,chart_status,display_tooth_no,super_yn,super_yn1,super_tooth_no,retained_tooth_no,super_key_num,failure_reason){
	/*
	Order of elements in chart_details:		
	CHART_NUM:CHART_LINE_NUM:CHART_STATUS:CHART_DATE:SITE_TYPE:TOOTH_NO:NS_TOOTH_NO:ARCH_SNO:QUADRANT_SNO:SURFACE_CODE:CONDITION_TYPE:CONDITION_CODE
	*/
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;//End
	if(obj == "menuDC" || obj == "menuET"){
		var formObj = document.forms[0];

		//Add date_diff_flag by Sharon Crasta on 3/30/2010 for IN018302
		//On click from RHS, the fields are not getting disabled 
		var date_diff_flag = formObj.date_diff_flag.value; 
		//End
		var chart_details_arr	= chart_details.split(":");
		var chart_num			= chart_details_arr[0];
		var chart_line_num		= chart_details_arr[1];
		var chart_status		= chart_details_arr[2];
		var chart_date			= chart_details_arr[3];
		var site_type			= chart_details_arr[4];
		var tooth_no			= chart_details_arr[5];
		var ns_tooth_no			= chart_details_arr[6];
		var arch_sno			= chart_details_arr[7];
		var quadrant_sno		= chart_details_arr[8];
		var surface_code		= chart_details_arr[9];
		if(obj == "menuDC"){
			var condition_type		= chart_details_arr[10];
			var condition_code		= chart_details_arr[11];
		}
		else{
			var trmt_category_type		= chart_details_arr[10];
			var trmt_code		= chart_details_arr[11];
		}

		var thrng_ref       = chart_details_arr[12];
		var thrng_nos           = chart_details_arr[13];

		var clinical_code		= chart_details_arr[14]; 
		var trmt_location           = chart_details_arr[16];
		var status           = chart_details_arr[17];
		var outcome           = chart_details_arr[18];
		var maxila_area				= chart_details_arr[19];
		var maxila_parts				= chart_details_arr[20];
		var maxila_sub_parts				= chart_details_arr[21];
		var supernumerary_yn				= chart_details_arr[22];

		if(obj == "menuDC"){
			if(chart_details_arr[13]=="null"||chart_details_arr[13]==null){ chart_details_arr[13]=" ";}
			/*var maxila_area           = chart_details_arr[13];
			var maxila_parts				= chart_details_arr[14];
			var maxila_sub_parts				= chart_details_arr[15];*/

			var maxila_area           = chart_details_arr[15];
			var maxila_parts				= chart_details_arr[16];
			var maxila_sub_parts				= chart_details_arr[17];
			var thrng_nos       = chart_details_arr[6];
			
		}


		var flag = "";
		var patient_id = document.forms[0].patient_id.value;
		var tooth_numbering_system = document.forms[0].tooth_numbering_system.value;
		var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
		var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
		if(RD_D_yn == "D"){ // This is to check the deciduous Condition
				flag = "D";
		}
		else if(RD_D_yn == "R"){ // This is to check the deciduous Condition
				flag = "RD";
		}
		else if(RD_D_yn == "M" && super_yn != "Y" && permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y"){
			//flag = "S"; On 13/11/07
			flag = "MRP";
		}
		else if(RD_D_yn == "M"){
			//flag = "S"; On 13/11/07
			flag = "MR";
		}
		else if(RD_D_yn == "Y" ){
			//flag = "S"; On 13/11/07
			flag = "N";
		}
		else{
			flag = "";
		}
		var thrng_nos_ref = "";
		//if(site_type=="THRNG"){
			
		if(site_type=="THRNG" || (site_type=="MAXFS" &&(maxila_sub_parts=="TNGAB" || maxila_sub_parts=="TNGGM" || maxila_sub_parts=="TNGAG"  || maxila_sub_parts=="TNGGAM" || maxila_sub_parts=="TNGMF")) ){
			var tooth_range_arr = thrng_ref.split(",");
			tooth_range_arr = tooth_range_arr[0].split("$$");
			//chart_line_num = tooth_range_arr[0]; // store Chart_line_num of the Starting Tooth NO of the TOOTH_TANGE column
			var k=0;
			if(RD_D_yn == "D" || RD_D_yn == "R" || RD_D_yn == "Y"){ // This is to check the deciduous Condition
				
				tooth_range_arr = thrng_ref.split(",");
				var temp_arr = "";
				for(i=0;i<tooth_range_arr.length;i++){
					temp_arr = tooth_range_arr[i].split("$$");
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+temp_arr[1]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 1){
						var retVal_arr = retVal.split("##");
						if(k==0){
							thrng_nos = retVal_arr[0];
						}else{
							thrng_nos = thrng_nos+","+retVal_arr[0];
						}
						k++;
					}
				}
			}
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
		}else{	
			if(permanent_deciduous_flag!="D" && (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
				if( RD_D_yn == "R" || RD_D_yn == "Y"){
						tooth_no=tooth_no+"r";
							
				}else if (RD_D_yn == "D"){
					tooth_no=tooth_no+"d";
				}
			}
			if (supernumerary_yn=="Y" && (site_type=="MAXFS" &&(maxila_sub_parts!="TNGAB" || maxila_sub_parts!="TNGGM" || maxila_sub_parts!="TNGAG"  || maxila_sub_parts!="TNGGAM" || maxila_sub_parts!="TNGMF"))){
				//tooth_no=tooth_no+"s";
				tooth_no=tooth_no+super_key_num;//Added by Sridevi Joshi on 2/8/2010 for IN010894
			}
			
		}
	
		var formObj = document.condViewDetailsForm;
		var old_params = formObj.params.value;
		var patient_id = formObj.patient_id.value;
		var encounter_id = formObj.encounter_id.value;
		var patient_class = formObj.patient_class.value;
		var patient_class = formObj.patient_class.value;
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
		var baseline_chart_yn = formObj.baseline_chart_yn.value;
		var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
		var oh_chart_level = formObj.oh_chart_level.value;
		var super_tooth_ref = "";

		var arch_quad_desc = "";
		if(site_type == "QUAD"){
			arch_quad_desc = quadrant_sno;
		}
		else if(site_type == "ARCH"){
			arch_quad_desc = arch_sno;
		}

		super_tooth_ref = super_key_num;

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
		//added by parul on 02/03/2010 for CRF-477
		failure_reason = unescape(failure_reason);
		failure_reason= encodeURIComponent(failure_reason);

	//arch_quad is the arch or quad desc
	if(obj == "menuDC"){	
				//Added by Sharon Crasta on 1/7/2009 for CRF #0377 to pass the remarks field to the params.
				clinical_group_or_remarks = unescape(clinical_group_or_remarks);
				clinical_group_or_remarks= encodeURIComponent(clinical_group_or_remarks);
				
				if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && (RD_D_yn == "" || RD_D_yn == "null" || RD_D_yn == null)){
					//tooth_no = display_tooth_no;
				}
			
				// Commented  by Sharon Crasta on 1/7/2009 for CRF #0377
				// Added	 clinical_group_or_remarks to the params in case of Dental Condition. //params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+condition_type+"&site="+site_type+"&code="+condition_code+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&flag="+flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&cusp_tip_code="+cusp_tip_code+"&baseline_chart_yn="+baseline_chart_yn+"&remarks="+clinical_group_or_remarks;
			
			// commented  by parul  for other facility chart CRF#0423
					//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+condition_type+"&site="+site_type+"&code="+condition_code+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&flag="+flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&cusp_tip_code="+cusp_tip_code+"&baseline_chart_yn="+baseline_chart_yn+"&remarks="+clinical_group_or_remarks;
				
				//Added chart_disable_from_main on 1/11/2010 by Sharon Crasta for IN017822
				params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+condition_type+"&site="+site_type+"&code="+condition_code+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&surface="+surface_code+"&flag="+flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&cusp_tip_code="+cusp_tip_code+"&baseline_chart_yn="+baseline_chart_yn+"&remarks="+clinical_group_or_remarks+"&other_facilitychart_yn="+other_facilitychart_yn+"&oh_chart_level="+oh_chart_level+"&flag1="+super_tooth_ref+"&chart_disable_from_main="+chart_disable_from_main+"&super_key_num="+super_key_num+"&maxila_area="+maxila_area+"&maxila_parts="+maxila_parts+"&maxila_sub_parts="+maxila_sub_parts+"&date_diff_flag="+date_diff_flag;	

			
				//parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalConditionAmend.jsp?"+params;

			/* COMMENTED BY SRIDEVI JOSHI ON 10/JUL/08 AND INCLUDED BELOW LINE AS REPLACEMENT
			parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalCondition.jsp?"+params;
			//parent.conditionDentalChartDataEntry.f_query_add_mod_middle.location.href="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?defaultTab=DentalCondition&clinical_group_code="+clinical_code+"&chart_hdr_insert_yn=N&"+params;
			*/
			parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=DentalCondition&clinical_group_code="+clinical_code+"&chart_hdr_insert_yn=N&"+params;
			
	}
	else{
		clinical_group_or_remarks = unescape(clinical_group_or_remarks);
		clinical_group_or_remarks= encodeURIComponent(clinical_group_or_remarks);

		trmt_location = unescape(trmt_location);
		trmt_location= encodeURIComponent(trmt_location);
		
		// commented  by parul  for other facility chart CRF#0423
		//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+trmt_category_type+"&site="+site_type+"&code="+trmt_code+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&performed_date="+date+"&surface="+surface_code+"&trmt_location="+trmt_location+"&status="+status+"&outcome="+outcome+"&mixed_dentition_YN="+mixed_dentition_YN+"&remarks="+clinical_group_or_remarks+"&baseline_chart_yn="+baseline_chart_yn+"&ext_trmt_status="+ext_trmt_status+"&flag="+flag;
		
		//+"&cusp_tip_code="+cusp_tip_code;	 on params added by parul 24/08/2009 for CRF#0483
	
		
		//Added chart_disable_from_main on 1/11/2010 by Sharon Crasta for IN017822	
		params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&type="+trmt_category_type+"&site="+site_type+"&code="+trmt_code+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&arch_quad="+arch_quad_desc+"&thrng_nos="+thrng_nos+"&thrng_nos_ref="+thrng_nos_ref+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&ref_tooth_no="+tooth_no+"&chart_line_num="+chart_line_num+"&performed_date="+date+"&surface="+surface_code+"&trmt_location="+trmt_location+"&status="+status+"&outcome="+outcome+"&mixed_dentition_YN="+mixed_dentition_YN+"&remarks="+clinical_group_or_remarks+"&baseline_chart_yn="+baseline_chart_yn+"&ext_trmt_status="+ext_trmt_status+"&flag="+flag+"&other_facilitychart_yn="+other_facilitychart_yn+"&oh_chart_level="+oh_chart_level+"&cusp_tip_code="+cusp_tip_code+"&maxila_area="+maxila_area+"&maxila_parts="+maxila_parts+"&maxila_sub_parts="+maxila_sub_parts+"&flag1="+super_tooth_ref+"&chart_disable_from_main="+chart_disable_from_main+"&super_key_num="+super_key_num+"&failure_reason="+failure_reason+"&date_diff_flag="+date_diff_flag;	
		
		//parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalExtTreatmentAmend.jsp?"+params;
		/*
		parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalExtTreatment.jsp?"+params;
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.location.href="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?defaultTab=ExtTreatment&clinical_group_code="+clinical_code+"&chart_hdr_insert_yn=N&"+params;
		*/

		//Commented and Added called_from_Ext_Trmt=Y parameter to display the External Tab when Clickedon RHS Data	//parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=ExtTreatment&clinical_group_code="+clinical_code+"&chart_hdr_insert_yn=N&"+params;
	parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=ExtTreatment&clinical_group_code="+clinical_code+"&chart_hdr_insert_yn=N&called_from_Ext_Trmt=Y&"+params;
	}	

		
		/*
		Parameters Meanings/Descriptions
			thrng_nos: is display value(Ex: 18,17,16....)
			thrng_nos_ref: is internal no (Ex:1,2,3,4 .....)
			arch_quad: arch or quad description
			code: condition_code
			type: Condition_type
			site: site_type
			show_new_active_yn: Used in Mixed Dentition Case, whether to active chart or not
		*/
	}
		
	else if(obj == "menuBC"){
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
		var oh_chart_level = formObj.oh_chart_level.value;
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
	   //Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
		var dflt_mixed_dentition_chart = formObj.dflt_mixed_dentition_chart.value;
		//

		var mixed_dentition_YN = "";
		if(chart_type == "RD"){
			mixed_dentition_YN = "N";
			permanent_deciduous_flag = "D";
		}
		else if(chart_type == "RM" ){
			mixed_dentition_YN = "Y";
			//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
			if(dflt_mixed_dentition_chart == "D"){
			   permanent_deciduous_flag = "D";
			}
			else{
			  permanent_deciduous_flag = "P";
			}
			//
		}
		else{
			//Commented and Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
			//mixed_dentition_YN = formObj.mixed_dentition_YN.value;
			mixed_dentition_YN = "N";
			permanent_deciduous_flag = "P"; // Permament
			//
		}
		var chart_type = formObj.chart_type.value;
		var header_tab = formObj.header_tab.value;
		if (chart_status=="A"){
			
			//commented by parul on 201008 for SCR#6059

			//params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status;

			// commented  by parul  for other facility chart CRF#0423

			//params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status;
			params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status+"&oh_chart_level="+oh_chart_level;
		}else{
			// commented  by parul  for other facility chart CRF#0423
			//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code;
			//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&oh_chart_level="+oh_chart_level;
			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&oh_chart_level="+oh_chart_level+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart;


		}
		var params1 = params+"&baseline_date="+date;
	    parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params1;
		//parent.conditionDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;

		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945
		parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalCondition.jsp?"+params;*/
		

		/* Added by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945 as an replacement for above line*/
		parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?"+params;
		

		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945		
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.location.href="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+params;
		*/

		parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params;

		if (chart_status!="A"){
			parent.conditionDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;
		}

		document.location.href="../../eOH/jsp/OHCondDentalChartViewDetails.jsp?"+params;
		
		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.DentalCondition.disabled=true;
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.ExtTreatment.disabled=true;
		*/
		//parent.conditionDentalChartDataEntry.f_query_add_mod_middle.PeriodontalCondition.disabled=true;
		parent.parent.parent.mainTabHeaderFrame.Condition.disabled=true;
		parent.parent.parent.mainTabHeaderFrame.Treatment.disabled=true;
		//parent.parent.parent.mainTabHeaderFrame.PeriodontalSummary.disabled=true;

	}
	
	
}
/*
function openClinicalNotes(){
	var patient_id = "";
	var facility_id = "";
	var encounter_id = "";
	var p_note_type = "";
	var p_date_time = "";
	var episode_type = "";
	var visit_adm_date = "";
	var patient_class = "";
//	var params =s "treatment_condition_date="+date+"&mode=modify&tooth_numbering_system=<%=tooth_numbering_system%>&permanent_deciduous_flag=<%=permanent_deciduous_flag%>&patient_id_new=<%=patient_id%>&upper_arch_desc=<%=upper_arch_desc%>&lower_arch_desc=<%=lower_arch_desc%>&Q1_id=<%=Q1_id%>&Q2_id=<%=Q2_id%>&Q3_id=<%=Q3_id%>&Q4_id=<%=Q4_id%>&Q1_desc=<%=Q1_desc%>&Q2_desc=<%=Q2_desc%>&Q3_desc=<%=Q3_desc%>&Q4_desc=<%=Q4_desc%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>";
    qry_string = "patient_id="+patient_id+"&facility_id="+facility_id+"&episode_id="+encounter_id+"&p_note_type="+p_note_type+"&p_date_time="+p_date_time+"&episode_type="+episode_type+"&visit_adm_date="+visit_adm_date+"&patient_class="+patient_class;

	var url = "../../eCA/jsp/RecClinicalNotesModal.jsp?"+params;
	window.open(url,null,"align=center, height=450,width=790,top=120,left=30,status=NO,toolbar=no,menubar=no,location=no");

}*/

async function openClinicalNotes(){
	var formObj = document.condViewDetailsForm;
	var params = formObj.params.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = formObj.chart_num.value;
	var speciality_code = formObj.speciality_code.value;
	var location_code = formObj.source_code.value;
	
	var note_type= "";//formObj.note_type.value;
	var contr_mod_accession_num = "";//formObj.contr_mod_accession_num.value;
	//var function_id="SPCL_NOTE";
	var function_id = "";
	//var function_id="";
	var event_class="$PHY$";
	var window_close="Y";
	var hide_header="Y";
	var tab_yn="N";
	//var speciality_code = "";//Before SCR-4511
	//var speciality_code = "OH";
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
	//var features			= "channelmode=yes";
	var dialogHeight = "80vh" ;
	var dialogWidth  = "80vw" ;
	//var dialogWidth  		= window.screen.availWidth;
	var dialogTop    = "10";
	var dialogLeft   = "50";
	


	/*var dialogHeight= "32" ;
	var dialogWidth	= "78" ;
	var dialogTop ="29";
	var dialogLeft ="15";	*/
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await top.window.showModalDialog(url,"CAWindow",features);

}
async function openDiagnosis(){ 
	var formObj = document.condViewDetailsForm;
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
	var ca_practitioner_id = formObj.ca_practitioner_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var accession_num = facility_id+"||"+encounter_id+"||"+oh_chart_num;
	//var params = "treatment_condition_date="+date+"&mode=modify&tooth_numbering_system=<%=tooth_numbering_system%>&permanent_deciduous_flag=<%=permanent_deciduous_flag%>&patient_id_new=<%=patient_id%>&upper_arch_desc=<%=upper_arch_desc%>&lower_arch_desc=<%=lower_arch_desc%>&Q1_id=<%=Q1_id%>&Q2_id=<%=Q2_id%>&Q3_id=<%=Q3_id%>&Q4_id=<%=Q4_id%>&Q1_desc=<%=Q1_desc%>&Q2_desc=<%=Q2_desc%>&Q3_desc=<%=Q3_desc%>&Q4_desc=<%=Q4_desc%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>";
	//var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num;
	//Added called_from as requested from PAS

	
//eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&encounter_id="+encID+"&practitioner_id="+practitioner_id+"&episode_id="+encID+"&FacilityId="+FacilityId+"&patient_id="+PatID+"&Function="+call_function+"&location_code="+ln_code+"&location_type="+loc_type+"&patient_class="+Patient_Class+"&Sex="+sex+"&Dob="+dob+"&IP_YN=N&practitioner_type="+pract_type+"&speciality_code="+speciality_code+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+enc_date;
	//"eMR/jsp/RecDiagnosis.jsp?encounter_id="+encounter_id+"&practitioner_id="+ca_practitioner_id+"&episode_id="+episode_id+"&FacilityId="+facility_id+"&patient_id="+patient_id+"&Function="+call_function+"&location_code="+location_code+"&location_type="+location_type+"&patient_class="+patient_class+"&IP_YN=N&speciality_code="+speciality_code;
	//var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&called_from_OH=OH";

	var sex = formObj.sex.value;
	var dob = formObj.dob.value;
	var bed_num = formObj.bed_num.value;
	var room_num = formObj.room_num.value;
	var visit_adm_date = formObj.visit_adm_date.value;
	
	//var url = "../../eMR/jsp/RecDiagnosis.jsp?encounter_id="+encounter_id+"&practitioner_id="+ca_practitioner_id+"&episode_id="+episode_id+"&FacilityId="+facility_id+"&patient_id="+patient_id+"&location_code="+location_code+"&location_type="+location_type+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+visit_adm_date+"&IP_YN=N&speciality_code="+speciality_code+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&called_from_OH=OH&Function=&option_id="+option_id;
	var url = "../../eMR/jsp/RecDiagnosis.jsp?encounter_id="+encounter_id+"&practitioner_id="+ca_practitioner_id+"&episode_id="+episode_id+"&FacilityId="+facility_id+"&patient_id="+patient_id+"&location_code="+location_code+"&location_type="+location_type+"&patient_class="+patient_class+"&Sex="+sex+"&Dob="+dob+"&bed_num="+bed_num+"&room_num="+room_num+"&visit_adm_date="+visit_adm_date+"&IP_YN=N&speciality_code="+speciality_code+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&called_from_OH=OH&Function=&option_id="+option_id;

	//var url = "../../eMR/jsp/RecDiagnosis.jsp?&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&called_from_OH=OH";
	//var url = "../../eOH/jsp/DentalExtTreatment.jsp?accession_num="+accession_num+"&oh_chart_num="+oh_chart_num;
	
	var dialogHeight = "80vh" ;
	var dialogWidth  = "80vw" ;
	//var dialogWidth  		= window.screen.availWidth;
	var dialogTop    = "10";
	var dialogLeft   = "50";
	


	/*var dialogHeight= "32" ;
	var dialogWidth	= "78" ;
	var dialogTop ="29";
	var dialogLeft ="15";	*/
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	//window.open(url,null,"align=center, height=450,width=790,top=120,left=30,status=NO,toolbar=no,menubar=no,location=no");
	await top.window.showModalDialog(url,null,features)
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


function displayNewChart(){
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
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var other_facility_yn = formObj.other_facility_yn.value;
	var locale = formObj.locale.value;
	var chart_num_int = parseInt(chart_num);
	chart_num_int = chart_num_int+1;
    var chart_date="";
	var copy_yn = "N";
		
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
			chart_type=retVal_arr_1[3];
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
  
  
  if (retVal_status>0){	//added by parul on 15/06/2010 for IN022086
		var msg=getMessage("APP-OH000186","OH");
		alert(msg);
    }else{
		var new_chart = confirm(getMessage("APP-OH00068","OH"));//Current Chart will be closed. Do you want to continue creating a New Chart
		//var initial_params = parent.parent.parent.condTabDentalChartFrame.location.search;
		if(new_chart){
			var msg=getMessage("APP-OH00095","OH");//Do you want to copy the Conditions and Treatments
			var msgArray = msg.split("##");
			//Added by Sharon Crasta on 3/17/2010 for IN019604 - thai conversion
			chart_date = convertDate(chart_date,'DMY','en',locale) ;
			//End
			//var copy_chart = confirm(getMessage("APP-OH00011","OH"));
		//	APP-OH00095 Do you want to copy the Conditions and Treatments of chart ## created on ## ?
			var copy_chart = confirm(msgArray[0]+chart_num+msgArray[1]+chart_date+msgArray[2]);
			if(copy_chart){
				copy_yn = "Y";
			}
			else{
				copy_yn = "N";
			}

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
		//	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn;
			//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_type="+chart_type+"&old_facility_id="+old_facility_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&episode_id="+episode_id+"&visit_id="+visit_id+"&episode_type="+episode_type+"&source_code="+source_code+"&source_type="+source_type+"&copy_yn="+copy_yn+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
			var xmlStr ="<root><SEARCH ";
			
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");			
			xmlHttp.open("POST","DentalChartCommonValidation.jsp?func_mode=newChartFromBaselineMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var add_new_done_flag = "Y";

			var initial_params = parent.parent.dummyFrame.location.search;
			
			//var params_add_new="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status+"&oh_chart_level="+oh_chart_level+"&show_new_active_yn=N&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;
			var params_add_new="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view=A"+"&oh_chart_level="+oh_chart_level+"&show_new_active_yn=N&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;
			//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y";
			
			//Commented by Sharon Crasta on 4/15/2009	//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params+"&baseline_new_chart=Y"+"&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag;
			 //
			
			//initial_params has ? in the beginning
			/*  commented on 290708 by sridevi joshi..If show_new_active_yn=Y then blank chrt will be displayed..If show_new_active_yn=N then chart with new chart num wil be displayed*/
			//initial_params=initial_params+"&show_new_active_yn=Y&add_new_yn=Y"; //// add_new_yn = "Y" is to clear the clinical group code for new chart...
			//Added flag to disbale calling the message APP-OH00010 after clicking Add New
			//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y"; //// add_new_yn = "Y" is to clear the clinical group code for new chart...
			//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y"+"&add_new_done_flag="+add_new_done_flag; //// add_new_yn = "Y" is to clear the clinical group code for new chart...
			
			//Commented by Sharon Crasta on 4/15/2009
			//initial_params=initial_params+"&show_new_active_yn=N&add_new_yn=Y";
			//
			
			//Instead of calling the OHCondDentalChartFrame.jsp, call OHMixedDentAlertFrame.jsp where ur setting the value of show_new_active_yn ..

			//parent.parent.parent.condTabDentalChartFrame.location.href="../../eOH/jsp/OHCondDentalChartFrame.jsp"+initial_params;
			//parent.parent.dummyFrame.location.href="../../eOH/jsp/OHMixedDentAlertFrame.jsp"+initial_params;
	//parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp"+initial_params;
			
			//Commented by Sharon Crasta on 4/15/2009	parent.parent.dummyFrame.location.href="../../eOH/jsp/OHMixedDentAlertFrame.jsp"+initial_params+"&add_new_done_flag="+add_new_done_flag;
			//

			/*if(parent.parent.parent.mainTabHeaderFrame!=null){
			var default_head_tab = "Condition";	
			parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params+"&default_head_tab="+default_head_tab+"&add_new_yn=Y";	
			} */
					//parent.conditionDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;

			/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945
			parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalCondition.jsp?"+params;*/
			
			parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params_add_new;

			parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?"+params_add_new;
			

			parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params_add_new;

			document.location.href="../../eOH/jsp/OHCondDentalChartViewDetails.jsp?"+params_add_new;

		}
	}
}

//function displayGSChart(chart_num,quadrant_sno,tooth_no,gingival_status_code,clinical_group_code,val_tooth_no){
function displayGSChart(chart_num,quadrant_sno,tooth_no,gingival_status_code,clinical_group_code,val_tooth_no,status_before_after){
	//var formObj = document.condViewDetailsForm;
    var formObj = document.forms[0];
	//var old_params = formObj.params.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var baseline_chart_yn = formObj.baseline_chart_yn.value;
	var called_from = formObj.called_from.value;

   //Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
	var chart_type= formObj.chart_type.value;
	
	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
	var chart_disable_from_main = document.forms[0].chart_disable_from_main.value;
	
	//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&quadrant_sno="+quadrant_sno+"&tooth_no="+tooth_no+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&gingival_status_code="+gingival_status_code+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&val_tooth_no="+val_tooth_no+"&baseline_chart_yn="+baseline_chart_yn;
	params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&quadrant_sno="+quadrant_sno+"&tooth_no="+tooth_no+"&chart_num="+chart_num+"&show_new_active_yn=N&called_from_viewchart_yn=Y&gingival_status_code="+gingival_status_code+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&val_tooth_no="+val_tooth_no+"&baseline_chart_yn="+baseline_chart_yn+"&chart_type="+chart_type+"&status_before_after="+status_before_after+"&chart_disable_from_main="+chart_disable_from_main;
	// End
	//parent.conditionDentalChartDataEntry.frames[0].location.href="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?defaultTab=GingivalStatus&chart_hdr_insert_yn=N&clinical_group_code="+clinical_group_code+"&"+params;
	

	/* COMMENTED BY SERIDEVI JOSHI ON 120208.. DEFAULT VALUES ARE NOT REQUIRED IN THE MARK ERROR CASE.. */
		//var gsObj = parent.conditionDentalChartDataEntry.qa_query_result.document.forms[0];
		
		var gs_dflt_tooth_no_Q1 = formObj.gs_dflt_tooth_no_q1.value;
		var gs_dflt_tooth_no_Q2 = formObj.gs_dflt_tooth_no_q2.value;
		var gs_dflt_tooth_no_Q3 = formObj.gs_dflt_tooth_no_q3.value;
		var gs_dflt_tooth_no_Q4 = formObj.gs_dflt_tooth_no_q4.value;

		var gs_dflt_tooth_no_s1 = formObj.gs_dflt_tooth_no_s1.value;
		var gs_dflt_tooth_no_s2 = formObj.gs_dflt_tooth_no_s2.value;
		var gs_dflt_tooth_no_s3 = formObj.gs_dflt_tooth_no_s3.value;
		var gs_dflt_tooth_no_s4 = formObj.gs_dflt_tooth_no_s4.value;
		var gs_dflt_tooth_no_s5 = formObj.gs_dflt_tooth_no_s5.value;
		var gs_dflt_tooth_no_s6 = formObj.gs_dflt_tooth_no_s6.value;

		//params=params+"&gs_dflt_tooth_no_Q1="+gs_dflt_tooth_no_Q1+"&gs_dflt_tooth_no_Q2="+gs_dflt_tooth_no_Q2+"&gs_dflt_tooth_no_Q3="+gs_dflt_tooth_no_Q3+"&gs_dflt_tooth_no_Q4="+gs_dflt_tooth_no_Q4+"&gs_dflt_tooth_no_s1="+gs_dflt_tooth_no_s1+"&gs_dflt_tooth_no_s2="+gs_dflt_tooth_no_s2+"&gs_dflt_tooth_no_s3="+gs_dflt_tooth_no_s3+"&gs_dflt_tooth_no_s4="+gs_dflt_tooth_no_s4+"&gs_dflt_tooth_no_s5="+gs_dflt_tooth_no_s5+"&gs_dflt_tooth_no_s6="+gs_dflt_tooth_no_s6;
		params=params+"&gs_dflt_tooth_no_Q1="+gs_dflt_tooth_no_Q1+"&gs_dflt_tooth_no_Q2="+gs_dflt_tooth_no_Q2+"&gs_dflt_tooth_no_Q3="+gs_dflt_tooth_no_Q3+"&gs_dflt_tooth_no_Q4="+gs_dflt_tooth_no_Q4+"&gs_dflt_tooth_no_s1="+gs_dflt_tooth_no_s1+"&gs_dflt_tooth_no_s2="+gs_dflt_tooth_no_s2+"&gs_dflt_tooth_no_s3="+gs_dflt_tooth_no_s3+"&gs_dflt_tooth_no_s4="+gs_dflt_tooth_no_s4+"&gs_dflt_tooth_no_s5="+gs_dflt_tooth_no_s5+"&gs_dflt_tooth_no_s6="+gs_dflt_tooth_no_s6+"&oh_chart_level="+oh_chart_level+"&other_facilitychart_yn="+other_facilitychart_yn+"&other_chart_facility_id="+other_chart_facility_id;
		//parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=GingivalStatus&chart_hdr_insert_yn=N&clinical_group_code="+clinical_group_code+"&"+params;
		
		//Commented and Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)	//parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=GingivalStatus&chart_hdr_insert_yn=N&clinical_group_code="+clinical_group_code+"&"+params;
		parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?defaultTab=GingivalStatus&called_from_Ging_Sts=Y&chart_hdr_insert_yn=N&called_from="+called_from+"&clinical_group_code="+clinical_group_code+"&"+params;
		//
		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	
		//parent.frames[3].frames[1].location.href="../../eOH/jsp/GingivalStatus.jsp?"+params;
			
}


function openGingivalStatusSummary(){
	var formObj = document.condViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var chart_num = formObj.cur_chart_num.value;
	var gingival_recording_by  = formObj.gingival_recording_by.value;
	var oh_chart_level  = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	//Added by Sharon Crasta on 8/7/2009 for IN009739(SRR20056-CRF-0457)
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	//var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system+"&chart_num="+chart_num+"&title_name=GINGIVAL&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system+"&chart_num="+chart_num+"&title_name=GINGIVAL&gingival_recording_by="+gingival_recording_by+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&mixed_dentition_YN="+mixed_dentition_YN;
	//
	 //var params ="patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system;
   // parent.conditionDentalChartDataEntry.f_query_add_mod_middle.location.href="../../eOH/jsp/PeriodontalSummaryTitle.jsp?"+params;
    parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+params;
  //  parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/dummyFrame.jsp?"+params;
	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function openPeriodontalSummary(){
	var formObj = document.condViewDetailsForm;
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;


    var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&tooth_numbering_system="+tooth_numbering_system+"&title_name=PERIODONTAL"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
   parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/PerioSummaryFrames.jsp?"+params;
   //parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/PerioSummaryFrames.jsp?"+params;
	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

//function added by parul  for other facility chart CRF#0423
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
		if (chart_status=="A"){
			
			//commented by parul on 201008 for SCR#6059
			//params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=N&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status;
			params="&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=N&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&chart_status_from_view="+chart_status+"&other_chart_facility_id="+facility_id+"&other_facilitychart_yn=Y"+"&oh_chart_level="+oh_chart_level;
		}else{
					// commented  by parul  for other facility chart CRF#0423
			//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code;
			//params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&oh_chart_level="+oh_chart_level;

			params="patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+desc+"&show_new_active_yn=N&called_from_viewchart_yn=Y&permanent_deciduous_flag="+permanent_deciduous_flag+"&tooth_numbering_system="+tooth_numbering_system+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type+"&header_tab="+header_tab+"&clinical_group_code="+clinical_group_or_remarks+"&chart_hdr_insert_yn=N&baseline_chart_yn=Y&defaultTab=DentalCondition&record_gingival_status_yn_param="+record_gingival_status_yn_param+"&location_code="+source_code+"&location_type="+source_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+facility_id;
		}
		var params1 = params+"&baseline_date="+date;				parent.parent.parent.conditionDentalChartToolHeader.location.href="../../eOH/jsp/OHDentalChartToolHeader.jsp?"+params1;
		//parent.conditionDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;

		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945
		parent.conditionDentalChartDataEntry.qa_query_result.location.href="../../eOH/jsp/DentalCondition.jsp?"+params;*/
		

		/* Added by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945 as an replacement for above line*/
		parent.conditionDentalChartDataEntry.location.href="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?"+params;
		
		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945		
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.location.href="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+params;
		*/
		parent.parent.parent.mainTabHeaderFrame.location.href="../../eOH/jsp/OHDentalChartTabSearch.jsp?"+params;
	if (chart_status!="A"){
			parent.conditionDentalChartDetails.location.href="../../eOH/jsp/OHDentalChart.jsp?"+params;
	}

		document.location.href="../../eOH/jsp/OHCondDentalChartViewDetails.jsp?"+params;
		/* Commented by Sridevi Joshi on 09/10/2008 for SCF-2415 and SPR-5945
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.DentalCondition.disabled=true;
		parent.conditionDentalChartDataEntry.f_query_add_mod_middle.ExtTreatment.disabled=true;
		*/
		//parent.conditionDentalChartDataEntry.f_query_add_mod_middle.PeriodontalCondition.disabled=true;

		parent.parent.parent.mainTabHeaderFrame.Condition.disabled=true;
		parent.parent.parent.mainTabHeaderFrame.Treatment.disabled=true;
		//parent.parent.parent.mainTabHeaderFrame.PeriodontalSummary.disabled=true;

	}
}

	function callMouseOver(obj)	{

		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}
		
	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}

//function reasonToolTip(obj){
/*function reasonToolTip(date,closed_date){
	//var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
			var tab_dat  = "<table id ='tooltiptable1' cellpadding='1' cellspacing=0 border='0'  width='100%' height='100%' align='center' >";

			tab_dat     += "<tr>"
			//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class='contextMenuLink' href = > "+date+"-"+closed_date+ "  </a> </td>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class='contextMenuItem' href = > "+date+"-"+closed_date+ "  </a>	</td>"



			//<font class="HYPERLINK" style="font-size:15pt;color:blue;cursor:pointer;font-weight:normal" title='<fmt:message key="eOH.ImagesInfoTitle.Label" bundle="${oh_labels}"/>' onClick="window.open('showCondTrmtImages.jsp','','height=400,width=230,top=100,left=770,status=NO,toolbar=no,menubar=no,location=no,scrollbar=auto,resize=yes');">
			tab_dat     += "</tr> ";
		tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow1();
}*/

function reasonToolTip(date,closed_date){
	//var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
			var tab_dat  = "<table id ='tooltiptable1' cellpadding='1' cellspacing=0 border='0'  width='100%' height='100%' align='center' >";
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class='contextMenuLink' href = > "+date+"-"+closed_date+ "  </a> </td>"
			//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class='contextMenuItem' href = > "+date+"-"+closed_date+ "  </a>	</td>"
			tab_dat     += "</tr> ";
		tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow1();
}

function resizeWindow1(){

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
			if(event.y<150)
			  y =event.y-30
		}else{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
		}

	    y+=document.body.scrollTop
		x+=document.body.scrollRight

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		document.getElementById("tooltiplayer").style.visibility='visible'
}
//Progress  Notes  added By Yadav for CRF499 on 1/23/2010
async function openProgressNotes(){
	var formObj = document.condViewDetailsForm;
	var params = formObj.params.value;
	var title = getLabel("eOH.ProgressNotes.Label","OH");
	var url="../../eCA/jsp/ProgressNotesModal.jsp?title="+title+"&module_id=OH&called_from=OH_CHARTING&appl_task_id=PROGRESS_NOTES"+params;
	var dialogHeight = "80vh" ;
	var dialogWidth  = "80vw" ;
	//var dialogWidth  		= window.screen.availWidth;
	var dialogTop    = "10";
	var dialogLeft   = "50";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" + ";title:" +title ;
	await top.window.showModalDialog(url,"CAWindow",features);
	
}

function GSSummaryNoData(){
	//var gingivalstatussummary_message = getMessage("APP-OH000163","OH");
	//alert(gingivalstatussummary_message);
	return;
}

function PerioSummaryNoData(){
	//var periodontalsummary_message = getMessage("APP-OH000164","OH");
	//alert(periodontalsummary_message);
	return;
}

async function showMaxilaFacialDtl()
{
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].cur_chart_num.value
	var header_tab = document.forms[0].header_tab.value
	var oh_chart_level = document.forms[0].oh_chart_level.value
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value

	var maxilaFacialDetail_label = getLabel("eOH.MaxilaFacialDetails.Label","OH");
	var retVal = await window.showModalDialog("../../eOH/jsp/MaxilaFacialDetails.jsp?heading="+maxilaFacialDetail_label+"&patient_id="+patient_id+"&chart_num="+chart_num+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level+"&tooth_numbering_system="+tooth_numbering_system,window,"dialogHeight: 55vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
					
}

