var hasChanged = false;
var count=0;
var count_rmt=0;
var count_summary=0;
var count_ECsummary=0;

function populatePerioSurfaces(obj){ 
	if(obj.value == ""){
		//document.getElementById("tooth_surface1").innerHTML = "&nbsp";
		document.getElementById("tooth_surface1").innerHTML = ""; //Commented above and added by Sridevi Joshi on 3/30/2010 for IN020367
		//document.getElementById("tooth_surface2").innerHTML = "&nbsp";
		document.getElementById("tooth_surface2").innerHTML = ""; //Commented above and added by Sridevi Joshi on 3/30/2010 for IN020367
	}
	else{
		var formObj = document.forms[0];
		var component_code = formObj.perio_comp.value
		var tooth_no = formObj.perio_tooth.value
		var patient_id = formObj.patient_id.value
		var chart_num = formObj.chart_num.value
		var chart_line_num = formObj.chart_line_num.value
		var chart_code = formObj.perio_chart.value
		var header_tab = formObj.header_tab.value
		var bs1 = "";
		var bs2 = "";
		var bs3 = "";
		var ls1 = "";
		var ls2 = "";
		var ls3 = "";
		var value = "";
		var min_val= "";
		var max_val = "";
		var surfaces_appl = "";

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&component_code="+component_code+"&tooth_no="+tooth_no+"&header_tab="+header_tab+"&chart_line_num="+chart_line_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populateSurfaceValues&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >1){									   
			var retVal_arr = retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var surface_arr = retVal_arr[i].split("##");
				bs1 = surface_arr[0];
				bs2 = surface_arr[1];
				bs3 = surface_arr[2];
				ls1 = surface_arr[3];
				ls2 = surface_arr[4];
				ls3 = surface_arr[5];
				value = surface_arr[6];

				formObj.mode.value = "update";
			}
		}
		else{
			formObj.mode.value = "";
		}

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&component_code="+component_code+"&tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getMaxMinValues&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >1){
			var retVal_arr = retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var max_min_arr = retVal_arr[i].split("##");
				min_val = max_min_arr[0];
				max_val = max_min_arr[1];
				surfaces_appl = max_min_arr[2];
			}
		}

		formObj.min_val.value = min_val;
		formObj.max_val.value = max_val;
		formObj.surfaces_appl.value = surfaces_appl;

		if(surfaces_appl == "Y"){
			var sur_B_count = parseInt("1");
			var sur_L_count = parseInt("1");
			var buccal_sur = "N";
			var lingual_sur = "N";
			var tab_dat1 = "<table width='100%' cellpadding ='1' cellspacing='0' border='0'>";
			var tab_dat2 = "<table width='100%' cellpadding ='1' cellspacing='0' border='0'>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePerioSurfaces&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length >1){
				var retVal_arr = retVal.split("~");
				for(i=0;i<retVal_arr.length-1;i++){
					
					var code_desc_arr = retVal_arr[i].split("##");
					if(code_desc_arr[2] == "B"){
						buccal_sur = 'Y';
						var B_val = eval("bs"+sur_B_count);
						tab_dat1 = tab_dat1+"<tr>";
						tab_dat1 = tab_dat1+"<td width='25%' class='label'>"+code_desc_arr[1]+"</td>";
						tab_dat1 = tab_dat1+"<td td width='25%' class='field' ><input type='text' name='bs"+sur_B_count+"' id='bs"+sur_B_count+"' size='3' maxlength = '3' value = '"+B_val+"' onkeypress='return OHCheckForSpecChars(event);' onblur='checkMaxMinValue(this);'></td>";
						tab_dat1 = tab_dat1+"</tr>";
						sur_B_count++;
					}

					if(code_desc_arr[2] == "L"){
						lingual_sur = 'Y';
						var L_val = eval("ls"+sur_L_count);
						tab_dat2 = tab_dat2+"<tr>";
						tab_dat2 = tab_dat2+"<td width='25%' class='label'>"+code_desc_arr[1]+"</td>";
						tab_dat2 = tab_dat2+"<td td width='25%' class='field' ><input type='text' name='ls"+sur_L_count+"' id='ls"+sur_L_count+"' size='3' maxlength = '3' value = '"+L_val+"' onkeypress='return OHCheckForSpecChars(event);' onblur='checkMaxMinValue(this);'></td>";
						tab_dat2= tab_dat2+"</tr>";
						sur_L_count++;
					}

				}
			}
			//tab_dat1 = tab_dat1+"<tr><td style='background-color:white' colspan='2'>&nbsp;</td></tr></table>";
			tab_dat1 = tab_dat1+"<tr><td style='background-color:white' colspan='2'></td></tr></table>";
			tab_dat2 = tab_dat2+"</table>";

			if(buccal_sur == "Y"){
				document.getElementById("tooth_surface1").innerHTML = tab_dat1;
			}
			if(lingual_sur == "Y"){
				document.getElementById("tooth_surface2").innerHTML = tab_dat2;
			}
		}
		else{
			var tab_dat1 = "<table width='100%' cellpadding ='1' cellspacing='0'>";
			tab_dat1 = tab_dat1+"<tr>";
			tab_dat1 = tab_dat1+"<td width='25%' class='label'>Value</td>";
			tab_dat1 = tab_dat1+"<td td width='25%' class='field' ><input type='text' name='non_surface_value' id='non_surface_value' size='3' maxlength = '3' value = '"+value+"' onblur='checkMaxMinValue(this);' onkeypress='return OHCheckForSpecChars(event);'></td>";
			tab_dat1 = tab_dat1+"</tr>";
			tab_dat1 = tab_dat1+"</table>";
			document.getElementById("tooth_surface1").innerHTML = tab_dat1;
			document.getElementById("tooth_surface2").innerHTML = "&nbsp;";
		}
//	}  

	}
}


function actionToServlet(){	
	var DB_perio_comp = "";
	var CAL_bs1 = "";
	var CAL_bs2 = "";
	var CAL_bs3 = "";
	var CAL_ls1 = "";
	var CAL_ls2 = "";
	var CAL_ls3 = "";

	var bs1 = "";
	var bs2 = "";
	var bs3 = "";
	var ls1 = "";
	var ls2 = "";
	var ls3 = "";

	var bs1_title = "";
	var bs2_title = "";
	var bs3_title = "";
	var ls1_title = "";
	var ls2_title  = "";
	var ls3_title  = "";

	var formObj = document.forms[0];
	if(formObj.disable_record.value == "Y"){
		return;
	}
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var chart_num = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].main_chart_num.value;
	var chart_code = formObj.perio_chart.value;
	var component_code = formObj.perio_comp.value;
	var tooth_no = formObj.perio_tooth.value;
	var header_tab = formObj.header_tab.value;
	var show_new_active_yn = formObj.show_new_active_yn.value;
	var chart_hdr_insert_yn = formObj.chart_hdr_insert_yn.value;
	var insert_new_EC_yn = formObj.insert_new_EC_yn.value;
	var chart_line_num = formObj.chart_line_num.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var facility_id = formObj.facility_id.value;
	var facility_name = formObj.facility_name.value;

	//var facility_name=getFacilityName();
	//var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	if(formObj != null){
		var tooth_no_title=getLabel("eOH.ToothNo.Label","OH");
		var components_title = getLabel("Common.Components.label","Common");
		
		var fields = new Array (formObj.perio_tooth,formObj.perio_comp);
		var names = new Array ( tooth_no_title,components_title);

		if(checkFieldsofMst( fields, names, messageFrame)){	
			/*
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "";;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePerioSurfacesDesc&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length >1){
				var retVal_arr = retVal.split("~");
				 bs1_title = retVal_arr[0];
				 bs2_title = retVal_arr[1];
				 bs3_title = retVal_arr[2];
				 ls1_title = retVal_arr[3];
				 ls2_title  = retVal_arr[4];
				 ls3_title  = retVal_arr[5];
			}

			var fields = new Array (formObj.bs1,formObj.bs2,formObj.bs3,formObj.ls1,formObj.ls2,formObj.ls3);
			var names = new Array ( bs1_title,bs2_title,bs3_title,ls1_title,ls2_title,ls3_title);
			
			if(checkFieldsofMst( fields, names, messageFrame)){	
			*/		
			var perio_comp = formObj.perio_comp.value;
			var perio_tooth = formObj.perio_tooth.value;
			var surfaces_appl = formObj.surfaces_appl.value;
			
			var mode = formObj.mode.value;
			formObj.chart_hdr_insert_yn.value = parent.parent.parent.perioLoadParams.document.forms[0].chart_hdr_insert_yn.value; //PerioChartRecordFrame 
			if(surfaces_appl == "Y"){
				if((formObj.bs1.value == "" || formObj.bs1.value == "null" || formObj.bs1.value == null) && (formObj.bs2.value == "" || formObj.bs2.value == "null" || formObj.bs2.value == null) && (formObj.bs3.value == "" || formObj.bs3.value == "null" || formObj.bs3.value == null) && (formObj.ls1.value == "" || formObj.ls1.value == "null" || formObj.ls1.value == null) && (formObj.ls2.value == "" || formObj.ls2.value == "null" || formObj.ls2.value == null) && (formObj.ls3.value == "" || formObj.ls3.value == "null" || formObj.ls3.value == null)){
					alert(getMessage("APP-OH00085","OH"))
					return;
				}
			}
			else{
				if(formObj.non_surface_value.value == "" || formObj.non_surface_value.value == "null" || formObj.non_surface_value.value == null){
					alert(getMessage("APP-OH00086","OH"));
					return;
				}
			}
			
			// To get the Chart_num of the <chart_code>
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartNum&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length >0){
				parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].main_chart_num.value = retVal;
				formObj.cur_chart_num.value = retVal;
			}

			if(show_new_active_yn == "Y" && formObj.chart_hdr_insert_yn.value == "Y" && header_tab == "B"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=createNewChartNum&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				if(retVal.length >0){
					chart_num = retVal;
					formObj.chart_num.value = retVal;
					parent.parent.parent.parent.perioChartHeaderFrame.document.forms[0].chart_num.value = retVal;
				}
			}

			chart_num = formObj.chart_num.value;
			if(header_tab == "E" && insert_new_EC_yn == "Y"){
				if(header_tab == "B"){
					chart_line_num = '1';
				}
				else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=createNewChartLineNum&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					if(retVal.length >0){
						chart_line_num = retVal;
						formObj.chart_line_num.value = retVal;
						parent.parent.parent.parent.perioChartHeaderFrame.document.forms[0].chart_line_num.value = retVal;
						parent.parent.perioChartDisplay.document.forms[0].chart_line_num.value = retVal;
						
					}
				}
			}
			
			var min_val = "";
			var max_val = "";
			var cut_off = "";
			//get the MAX abd MIN values for CAL
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();

		/*	if(component_code=="CEJ" || component_code=="PD"){
					component_code="CAL";
			
			}else{	
				component_code=component_code;
			}  */
			//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&component_code=CAL"+"&tooth_no="+tooth_no;
			var params_cutoff = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&component_code="+component_code+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getCutOffValues&"+params_cutoff,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
		    cut_off	 = retVal;
			
			var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&component_code=CAL"+"&tooth_no="+tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getMaxMinValues&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length >1){
				var retVal_arr = retVal.split("~");
				for(i=0;i<retVal_arr.length-1;i++){
					var max_min_arr = retVal_arr[i].split("##");
					min_val = max_min_arr[0];
					max_val = max_min_arr[1];
					cut_off_cal = max_min_arr[3];
				}
			}
			//To check wether the CAL is linked to the chart or not..
			var element_id_B = "CAL"+perio_tooth+"B";
			var element_id_L = "CAL"+perio_tooth+"P";
			if(parent.parent.perioChartDisplay.document.getElementById(element_id_B) != null && parent.parent.perioChartDisplay.document.getElementById(element_id_B) != "null" && parent.parent.perioChartDisplay.document.getElementById(element_id_L) != null && parent.parent.perioChartDisplay.document.getElementById(element_id_L) != "null"){

				formObj.DB_insert_yn.value = 'Y';
			}

	
			if(checkForMissingTooth() == false){
				alert(getMessage("APP-OH00046","OH"));
				reset_record('servlet');
				return;
			} 
			/*
			//validation here 
			var submit_yn = "N";
			if(surfaces_appl == "Y"){
				if(checkMaxMinValue(formObj.bs1)){
					if(checkMaxMinValue(formObj.bs2)){
						if(checkMaxMinValue(formObj.bs3)){
							if(checkMaxMinValue(formObj.ls1)){
								if(checkMaxMinValue(formObj.ls2)){
									if(checkMaxMinValue(formObj.ls3)){
										submit_yn = "Y";
									}
								}
							}
						}
					}
				}
			}
			else{
				if(CheckNum(formObj.non_surface_value)){
					submit_yn = "Y";
				}
				else{
					submit_yn = "N";
					return;
				}
			}
			*/
			/*
			if(CheckForSpecChars(event) == false){
				return;
			}
			*/
			
			//Submit was Here
			
			if(perio_comp == "MITH"){
				var non_surface_value = formObj.non_surface_value.value;
				if(non_surface_value == "1"){
					var check_record_on_tooth_flag = checkForRecordings();
					if(check_record_on_tooth_flag == false){
						alert(getMessage("APP-OH000110","OH"));
						//formObj.perio_comp.focus();
						//reset_record('servlet');
						clearComponent();
						return;
					}
				}

				//To get the components recorded for a chart
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "perio_chart="+chart_code;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
				xmlHttp.send(xmlDoc);
				var component_codes_str = trimString(xmlHttp.responseText); //Components Codes------BOP~CAL~CALC~CEJ~DEB~FUIN~LOC~MITH~MOBL~PD~PLA~

				var component_codes_arr = component_codes_str.split("~");
				for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+perio_tooth+"B";
						var td_id_P = component_codes_arr[k]+perio_tooth+"P";
						var td_id_val = component_codes_arr[k]+perio_tooth;
						if(non_surface_value == "1"){
							if(parent.parent.perioChartDisplay.document.getElementById(td_id_B) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != undefined){
							
									parent.parent.perioChartDisplay.document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
									parent.parent.perioChartDisplay.document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
								}
							
								if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
									parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
								}
							}
						//}
						//Commented By Sharon Crasta on 5/18/2009 for IN010673
						else{ 
							if(parent.parent.perioChartDisplay.document.getElementById(td_id_B) != null &&	parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != undefined){
								var element_ref = parent.parent.perioChartDisplay.document.getElementById(td_id_B).innerHTML;
								if(element_ref.indexOf("MissingTeeth.gif") != -1){ //
									parent.parent.perioChartDisplay.document.getElementById(td_id_B).innerHTML = "&nbsp;&nbsp;"
									parent.parent.perioChartDisplay.document.getElementById(td_id_P).innerHTML = "&nbsp;&nbsp;"
								}
							}

							if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
								var element_ref = parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML;
								if(element_ref.indexOf("MissingTeeth.gif") != -1){
									parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;"
								}
							}
							/*
							if(parent.parent.perioChartDisplay.document.getElementById(td_id_B) != null &&	parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_B) != undefined){
								//parent.parent.perioChartDisplay.document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
								//parent.parent.perioChartDisplay.document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';
						
								parent.parent.perioChartDisplay.document.getElementById(td_id_B).innerHTML = "&nbsp;&nbsp;"
								parent.parent.perioChartDisplay.document.getElementById(td_id_P).innerHTML = "&nbsp;&nbsp;"
							}
						
							if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
								parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;"
							}
							*/	
						}
					}		
					
				}
			else if(perio_comp == "LOC"){
				var non_surface_value = formObj.non_surface_value.value;
				var td_id_val = perio_comp+perio_tooth;

				if(non_surface_value == "1"){
			
					if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
						parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />"
					}
				}
				else{
										
					if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
						parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;"
					}
				}
			}
			else if(perio_comp == "FUIN"){
				var non_surface_value = formObj.non_surface_value.value;
				var td_id_val = perio_comp+perio_tooth;

				if(non_surface_value == "1"){
					if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
						parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />"
					}
				}
				else if(non_surface_value == "2"){
					if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
						parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />"
					}
				}
				else if(non_surface_value == "3"){
					if(parent.parent.perioChartDisplay.document.getElementById(td_id_val) != null && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "null" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != "undefined" && parent.parent.perioChartDisplay.document.getElementById(td_id_val) != undefined){
						parent.parent.perioChartDisplay.document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />"
					}
				}
			}
			else{
				if(surfaces_appl == "Y"){//BOP,CEJ comng as Y
					 if(formObj.bs1.value!=null && formObj.bs1.value!=""){
						bs1 = formObj.bs1.value;
						if(bs1.substring(0,2) == "00" && bs1.length > 2){
							bs1 = bs1.substring(2);
						}else if(bs1.substring(0,1) == "0" && bs1.length > 1){
							bs1 = bs1.substring(1);
						}
						else if(bs1.substring(0,2) == "-0" && bs1.length > 2){
							bs1 = "-"+bs1.substring(2);
						}
						else if(bs1.substring(0,2) == "+0" && bs1.length > 2){
							bs1 = "+"+bs1.substring(2);
						}
						bs1 = parseInt(bs1);
					}
					else{
						bs1 = "";
					}

					if(formObj.bs2.value!=null && formObj.bs2.value!=""){
						bs2 = formObj.bs2.value;
						if(bs2.substring(0,2) == "00" && bs2.length > 2){
							bs2 = bs2.substring(2);
						}else if(bs2.substring(0,1) == "0" && bs2.length > 1){
							bs2 = bs2.substring(1);
						}else if(bs2.substring(0,2) == "-0" && bs2.length > 2){
							bs2 = "-"+bs2.substring(2);
						}else if(bs2.substring(0,2) == "+0" && bs2.length > 2){
							bs2 = "+"+bs2.substring(2);
						}
						bs2 = parseInt(bs2);
					}
					else{
						bs2 = "";
					}

					if(formObj.bs3.value!=null && formObj.bs3.value!=""){
						 bs3 = formObj.bs3.value;
						if(bs3.substring(0,2) == "00" && bs3.length > 2){
							bs3 = bs3.substring(2);
						}else if(bs3.substring(0,1) == "0" && bs3.length > 1){
							bs3 = bs3.substring(1);
						}else if(bs3.substring(0,2) == "-0" && bs3.length >2){
							bs3 = "-"+bs3.substring(2);
						}else if(bs3.substring(0,2) == "+0" && bs3.length >2){
							bs3 = "+"+bs3.substring(2);
						}
						bs3 = parseInt(bs3);
					}
					else{
						 bs3 = "";
					}

					if(formObj.ls1.value!=null && formObj.ls1.value!=""){
						ls1 = formObj.ls1.value;
						if(ls1.substring(0,2) == "00" && ls1.length > 2){
							ls1 = ls1.substring(2);
						}else if(ls1.substring(0,1) == "0" && ls1.length > 1){
							ls1 = ls1.substring(1);
						}else if(ls1.substring(0,2) == "-0" && ls1.length > 2){
							ls1 = "-"+ls1.substring(2);
						}else if(ls1.substring(0,2) == "+0" && ls1.length > 2){
							ls1 = "+"+ls1.substring(2);
						}
						ls1 = parseInt(ls1);
					}
					else{
						ls1 = "";
					}

					if(formObj.ls2.value!=null && formObj.ls2.value!=""){
						ls2 = formObj.ls2.value;
						if(ls2.substring(0,2) == "00" && ls2.length > 2){
							ls2 = ls2.substring(2);
						}else if(ls2.substring(0,1) == "0" && ls2.length > 1){
							ls2 = ls2.substring(1);
						}else if(ls2.substring(0,2) == "-0" && ls2.length > 2){
							ls2 = "-"+ls2.substring(2);
						}else if(ls2.substring(0,2) == "+0" && ls2.length > 2){
							ls2 = "+"+ls2.substring(2);
						}
						ls2 = parseInt(ls2);
					}
					else{
						ls2 = "";
					}

					if(formObj.ls3.value!=null && formObj.ls3.value!=""){
						ls3 = formObj.ls3.value;
						if(ls3.substring(0,2) == "00" && ls3.length > 2){
							ls3 = ls3.substring(2);
						}else if(ls3.substring(0,1) == "0" && ls3.length > 1){
							ls3 = ls3.substring(1);
						}else if(ls3.substring(0,2) == "-0" && ls3.length > 2){
							ls3 = "-"+ls3.substring(2);
						}else if(ls3.substring(0,2) == "+0" && ls3.length > 2){
							ls3 = "+"+ls3.substring(2);
						}
						ls3 = parseInt(ls3);
					}
					else{
						ls3 = "";
					}

					
					if(formObj.bs1.value.substring(0,1) == "+"){
						formObj.bs1.value = formObj.bs1.value.substring(1);
					}

					if(formObj.bs2.value.substring(0,1) == "+"){
						formObj.bs2.value = formObj.bs2.value.substring(1);
					}

					if(formObj.bs3.value.substring(0,1) == "+"){
						formObj.bs3.value = formObj.bs3.value.substring(1);
					}

					if(formObj.ls1.value.substring(0,1) == "+"){
						formObj.ls1.value = formObj.ls1.value.substring(1);
					}

					if(formObj.ls2.value.substring(0,1) == "+"){
						formObj.ls2.value = formObj.ls2.value.substring(1);
					}

					if(formObj.ls3.value.substring(0,1) == "+"){
						formObj.ls3.value = formObj.ls3.value.substring(1);
					}

					if(perio_comp == "PD" || perio_comp == "CEJ"){
						var element_id_B = "CAL"+perio_tooth+"B";
						var element_id_L = "CAL"+perio_tooth+"P";
						if(parent.parent.perioChartDisplay.document.getElementById(element_id_B) != null && parent.parent.perioChartDisplay.document.getElementById(element_id_B) != "null" && parent.parent.perioChartDisplay.document.getElementById(element_id_L) != null && parent.parent.perioChartDisplay.document.getElementById(element_id_L) != "null"){
							if(perio_comp == "PD"){
								DB_perio_comp = "CEJ";
							}
							else if(perio_comp == "CEJ"){
								DB_perio_comp = "PD";
							}

							//To get the PD/CEJ Values recorded for a chart
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "perio_chart="+chart_code+"&DB_perio_comp="+DB_perio_comp+"&perio_tooth="+perio_tooth+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&patient_id="+patient_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getPDCEJValues&"+params,false);
							xmlHttp.send(xmlDoc);
							var PDCEJ_values = trimString(xmlHttp.responseText); 
							if(PDCEJ_values.length >1){
								var PDCEJ_values_arr = PDCEJ_values.split("~");
								for(m=0;m<PDCEJ_values_arr.length-1;m++){
									var dtl_values_arr = PDCEJ_values_arr[m].split("##");
									if(dtl_values_arr[0] != "" && bs1 != ""){
										CAL_bs1 = parseInt(dtl_values_arr[0])+parseInt(bs1);
									}
									else if(dtl_values_arr[0] != "" && bs1 == ""){
										CAL_bs1 = parseInt(dtl_values_arr[0]);
									}
									else if(dtl_values_arr[0] == "" && (bs1 == "0" || bs1 != "" )){
										CAL_bs1 = parseInt(bs1);
									}
									else{
										CAL_bs1 =  "";
									}

									if(dtl_values_arr[1] != "" && bs2 !=""){
										CAL_bs2 = parseInt(dtl_values_arr[1])+parseInt(bs2);
									}
									else if(dtl_values_arr[1] != "" && bs2 ==""){
										CAL_bs2 = parseInt(dtl_values_arr[1]);
									}
									else if(dtl_values_arr[1] == "" && (bs2 == "0" || bs2 != "")){
										CAL_bs2 = parseInt(bs2);
									}
									else{
										CAL_bs2 =  "";
									}

									if(dtl_values_arr[2] != "" && bs3 != ""){
										CAL_bs3 = parseInt(dtl_values_arr[2])+parseInt(bs3);
									}
									else if(dtl_values_arr[2] != ""&& bs3 == ""){
										CAL_bs3 = parseInt(dtl_values_arr[2]);
									}
									else if(dtl_values_arr[2] == "" && (bs3 == "0" || bs3 != "")){
										CAL_bs3 = parseInt(bs3);
									}
									else{
										CAL_bs3 =  "";
									}

									if(dtl_values_arr[3] !="" && ls1 != ""){
										CAL_ls1 = parseInt(dtl_values_arr[3])+parseInt(ls1);
									}
									else if(dtl_values_arr[3] != "" && ls1 == ""){
										CAL_ls1 = parseInt(dtl_values_arr[3]);
									}
									else if(dtl_values_arr[3] == "" && (ls1 == "0" || ls1 != "")){
										CAL_ls1 = parseInt(ls1);
									}
									else{
										CAL_ls1 =  "";
									}

									if(dtl_values_arr[4] != "" && ls2 != ""){
										CAL_ls2 = parseInt(dtl_values_arr[4])+parseInt(ls2);
									}
									else if(dtl_values_arr[4] != "" && ls2 == ""){
										CAL_ls2 = parseInt(dtl_values_arr[4]);
									}
									else if(dtl_values_arr[4] == "" && (ls2 == "0" || ls2 !="")){
										CAL_ls2 = parseInt(ls2);
									}
									else{
										CAL_ls2 =  "";
									}

									if(dtl_values_arr[5] != "" && ls3 != ""){
										CAL_ls3 = parseInt(dtl_values_arr[5])+parseInt(ls3);
									}
									else if(dtl_values_arr[5] != ""&& ls3 == ""){
										CAL_ls3 = parseInt(dtl_values_arr[5]);
									}
									else if(dtl_values_arr[5] == "" && (ls3 == "0" || ls3 != "")){
										CAL_ls3 = parseInt(ls3);
									}
									else{
										CAL_ls3 =  "";
									}
								}
							}
							else{
								CAL_bs1 = bs1;
								CAL_bs2 = bs2;
								CAL_bs3 = bs3;
								CAL_ls1 = ls1;
								CAL_ls2 = ls2;
								CAL_ls3 = ls3;

							}
							
							if((parseInt(CAL_bs1) > max_val || parseInt(CAL_bs1) < min_val) || (parseInt(CAL_bs2) > max_val || parseInt(CAL_bs2) < min_val) || (parseInt(CAL_bs3) > max_val || parseInt(CAL_bs3) < min_val) || (parseInt(CAL_ls1) > max_val || parseInt(CAL_ls1) < min_val) || (parseInt(CAL_ls2) > max_val || parseInt(CAL_ls2) < min_val) || (parseInt(CAL_ls3) > max_val || parseInt(CAL_ls3) < min_val)){
								var msg = getMessage("APP-OH00083","OH");//value should be between ## and ##
								var msg_arr = msg.split("##");
								alert(msg_arr[0]+"CAL"+msg_arr[1]+min_val+msg_arr[2]+max_val+msg_arr[3]);
								formObj.perio_comp.focus();
								return;
							}

							var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
							tab_data1 = tab_data1+ "<tr>";
							var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
							tab_data2 = tab_data2+ "<tr>";
							//if(CAL_bs1 >= cut_off || CAL_bs1 >= cut_off_cal){		
								
					/* commented on 03/02/2010 by Muralee for 18556 */
						/*
						if(CAL_bs1 >= cut_off_cal){								
							//tab_data1 = tab_data1+ "<tr>";
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs1+"</td>";
							}else{
								tab_data1 = tab_data1+"<td nowrap>"+CAL_bs1+"</td>";
							}
							//if(CAL_bs2 >= cut_off || CAL_bs2 >= cut_off_cal){
							if(CAL_bs2 >= cut_off_cal){
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs2+"</td>";
							}else{
								tab_data1 = tab_data1+"<td nowrap>"+CAL_bs2+"</td>";
							}
							//if(CAL_bs3>= cut_off || CAL_bs3 >= cut_off_cal){
							if(CAL_bs3>= cut_off_cal){
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs3+"</td>";
							}else{
								tab_data1 = tab_data1+"<td nowrap>"+CAL_bs3+"</td>";
							}
							//if(CAL_ls1>= cut_off || CAL_ls1 >= cut_off_cal){
							if(CAL_ls1 >= cut_off_cal){								
								tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls1+"</td>";
							}else{
								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls1+"</td>";
							}
							//if(CAL_ls2 >= cut_off || CAL_ls2 >= cut_off_cal){
							if(CAL_ls2 >= cut_off_cal){
								tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls2+"</td>";
							}else{
								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls2+"</td>";
							}
							if(CAL_ls3>= cut_off_cal){
								tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls3+"</td>";
							}else{
								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls3+"</td>";
							}
							*/
							
							//if(CAL_bs1 >= cut_off || CAL_bs1 >= cut_off_cal){	
								
							if(CAL_bs1 >= cut_off_cal){								
							//tab_data1 = tab_data1+ "<tr>";
								if((CAL_bs1 == null || CAL_bs1 == "" || CAL_bs1 == "null")&& CAL_bs1 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs1+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs1+"</td>";
							}else{
								if((CAL_bs1 == null || CAL_bs1 == "" || CAL_bs1 == "null") && CAL_bs1 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap>"+CAL_bs1+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap>"+CAL_bs1+"</td>";
							}

							//if(CAL_bs2 >= cut_off || CAL_bs2 >= cut_off_cal){
							if(CAL_bs2 >= cut_off_cal){
								if((CAL_bs2 == null || CAL_bs2 == "" || CAL_bs2 == "null") && CAL_bs2 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs2+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs2+"</td>";
							}else{
								if((CAL_bs2 == null || CAL_bs2 == "" || CAL_bs2 == "null") && CAL_bs2 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap>"+CAL_bs2+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap>"+CAL_bs2+"</td>";
							}

							//if(CAL_bs3>= cut_off || CAL_bs3 >= cut_off_cal){
							if(CAL_bs3>= cut_off_cal){
								if((CAL_bs3 == null || CAL_bs3 == "" || CAL_bs3 == "null") && CAL_bs3 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs3+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap><font color='red'>"+CAL_bs3+"</td>";
							}else{
								if((CAL_bs3 == null || CAL_bs3 == "" || CAL_bs3 == "null") && CAL_bs3 != "0"){
									tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data1 = tab_data1+"<td nowrap>"+CAL_bs3+"</td>";
								}
								//tab_data1 = tab_data1+"<td nowrap>"+CAL_bs3+"</td>";
							}

							//if(CAL_ls1>= cut_off || CAL_ls1 >= cut_off_cal){
							if(CAL_ls1 >= cut_off_cal){
								if((CAL_ls1 == null || CAL_ls1 == "" || CAL_ls1 == "null") && CAL_ls1 != "0"){
									tab_data2 = tab_data2+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls1+"</td>";
								}
								//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls1+"</td>";
							}else{
								if((CAL_ls1 == null || CAL_ls1 == "" || CAL_ls1 == "null") && CAL_ls1 != "0"){
									tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap>"+CAL_ls1+"</td>";
								}
								//tab_data2 = tab_data2+"<td nowrap>"+CAL_ls1+"</td>";
							}

							//if(CAL_ls2 >= cut_off || CAL_ls2 >= cut_off_cal){
							if(CAL_ls2 >= cut_off_cal){
								if((CAL_ls2 == null || CAL_ls2 == "" || CAL_ls2 == "null") && CAL_ls2 != "0"){
									tab_data2 = tab_data2+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls2+"</td>";
								}
								//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls2+"</td>";
							}else{
								if((CAL_ls2 == null || CAL_ls2 == "" || CAL_ls2 == "null") && CAL_ls2 != "0"){
									tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap>"+CAL_ls2+"</td>";
								}
								//tab_data2 = tab_data2+"<td nowrap>"+CAL_ls2+"</td>";
							}
							if(CAL_ls3 >= cut_off_cal){
								//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls3+"</td>";
								if((CAL_ls3 == null || CAL_ls3 == "" || CAL_ls3 == "null") && CAL_ls3 != "0"){
									tab_data2 = tab_data2+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap><font color='red'>"+CAL_ls3+"</td>";
								}
							}else{
								if((CAL_ls3 == null || CAL_ls3 == "" || CAL_ls3 == "null") && CAL_ls3 != "0"){
									tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
								}else{
									tab_data2 = tab_data2+"<td nowrap>"+CAL_ls3+"</td>";
								}
								//tab_data2 = tab_data2+"<td nowrap>"+CAL_ls3+"</td>";
							}

						
								/*tab_data1 = tab_data1+"<td nowrap>"+CAL_bs1+"</td>";
								tab_data1 = tab_data1+"<td nowrap>"+CAL_bs2+"</td>";
								tab_data1 = tab_data1+"<td nowrap>"+CAL_bs3+"</td>";

								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls1+"</td>";
								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls2+"</td>";
								tab_data2 = tab_data2+"<td nowrap>"+CAL_ls3+"</td>";
					
					*/
								tab_data1 = tab_data1+"</tr>";
								tab_data1 = tab_data1+"</table>"
								tab_data2 = tab_data2+"</tr>";
								tab_data2 = tab_data2+"</table>"
							//parent.parent.perioChartDisplay.document.getElementById(element_id_B).style.backgroundColor = 'white';
							parent.parent.perioChartDisplay.document.getElementById(element_id_B).innerHTML = tab_data1; //frames[1]

							//parent.parent.perioChartDisplay.document.getElementById(element_id_L).style.backgroundColor = 'white';
							parent.parent.perioChartDisplay.document.getElementById(element_id_L).innerHTML = tab_data2; //frames[1]
						}
					}

					var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data1 = tab_data1+ "<tr>";
				
						/*tab_data1 = tab_data1+"<td nowrap>"+bs1+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+bs2+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+bs3+"</td>";*/

				/*	 commented on 03/02/2010 by Muralee for 18556 
				
					if(bs1 >= cut_off){
						tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs1+"</td>";
					}else{
                     	tab_data1 = tab_data1+"<td nowrap>"+bs1+"</td>";
					}
					if(bs2 >= cut_off){
						tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs2+"</td>";
					}else{
						tab_data1 = tab_data1+"<td nowrap>"+bs2+"</td>";
                    }
					if (bs3 >= cut_off){
					 tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs3+"</td>";
					}else{
						tab_data1 = tab_data1+"<td nowrap>"+bs3+"</td>";
					}*/

					if(bs1 >= cut_off){
						if((bs1 == null || bs1 == "" || bs1 == "null") && bs1 != "0"){
							tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs1+"</td>";
						}
					}else{
                     	if((bs1 == null || bs1 == "" || bs1 == "null") && bs1 != "0"){
							tab_data1 = tab_data1+"<td>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap>"+bs1+"</td>";
						}
					}
					if(bs2 >= cut_off){
						if((bs2 == null || bs2 == "" || bs2 == "null") && bs2 != "0"){
							tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs2+"</td>";
						}
						//tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs2+"</td>";
					}else{
						if((bs2 == null || bs2 == "" || bs2 == "null") && bs2 != "0"){
							tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap>"+bs2+"</td>";
						}
						//tab_data1 = tab_data1+"<td nowrap>"+bs2+"</td>";
                    }
					if (bs3 >= cut_off){
						//tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs3+"</td>";
						if((bs3 == null || bs3 == "" || bs3 == "null") && bs3 != "0"){
							tab_data1 = tab_data1+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+bs3+"</td>";
						}
					}else{
						//  tab_data1 = tab_data1+"<td nowrap>"+bs3+"</td>";
						if((bs3 == null || bs3 == "" || bs3 == "null") && bs3 != "0"){
							tab_data1 = tab_data1+"<td nowrap>&nbsp;&nbsp;</td>";
						}else{
							tab_data1 = tab_data1+"<td nowrap>"+bs3+"</td>";
						}
					}


					tab_data1 = tab_data1+"</tr>";
					tab_data1 = tab_data1+"</table>"

					var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data2 = tab_data2+ "<tr>";
					
					/* commented on 03/02/2010 by Muralee for 18556 */

				/*	if(ls1 >= cut_off){
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls1+"</td>";
					}else{					 
						tab_data2 = tab_data2+"<td nowrap>"+ls1+"</td>";
					}
					if(ls2 >= cut_off){
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls2+"</td>";
					}else{
					    tab_data2 = tab_data2+"<td nowrap>"+ls2+"</td>";
					}
					if(ls3 >= cut_off){
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls3+"</td>";
					}else{
						tab_data2 = tab_data2+"<td nowrap>"+ls3+"</td>";					
					}*/

					if(ls1 >= cut_off){
						if((ls1 == null || ls1 == "" || ls1 == "null") && ls1 != "0"){
							tab_data2 = tab_data2+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls1+"</td>";
						}
						//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls1+"</td>";
					}else{	
						if((ls1 == null || ls1 == "" || ls1 == "null") && ls1 != "0"){
							tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap>"+ls1+"</td>";
						}
						//tab_data2 = tab_data2+"<td nowrap>"+ls1+"</td>";
					}

					if(ls2 >= cut_off){
						if((ls2 == null || ls2 == "" || ls2 == "null") && ls2 != "0"){
							tab_data2 = tab_data2+"<td nowrap><font color='red'>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls2+"</td>";
						}
						//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls2+"</td>";
					}else{
						if((ls2 == null || ls2 == "" || ls2 == "null") && ls2 != "0"){
							tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap>"+ls2+"</td>";
						}
					    //tab_data2 = tab_data2+"<td nowrap>"+ls2+"</td>";
					}

					if(ls3 >= cut_off){
						if((ls3 == null || ls3 == "" || ls3 == "null") && ls3 != "0"){
							tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls3+"</td>";
						}
						//tab_data2 = tab_data2+"<td nowrap><font color='red'>"+ls3+"</td>";
					}else{
						if((ls3 == null || ls3 == "" || ls3 == "null") && ls3 != "0"){
							tab_data2 = tab_data2+"<td nowrap>&nbsp;&nbsp;</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap>"+ls3+"</td>";
						}
						//tab_data2 = tab_data2+"<td nowrap>"+ls3+"</td>";					
					}

						/* tab_data2 = tab_data2+"<td nowrap>"+ls1+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+ls2+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+ls3+"</td>";	*/
					tab_data2 = tab_data2+"</tr>";
					tab_data2 = tab_data2+"</table>"					

					var element_id_B = perio_comp+perio_tooth+"B";
					//parent.parent.perioChartDisplay.document.getElementById(element_id_B).style.backgroundColor = 'white';
					parent.parent.perioChartDisplay.document.getElementById(element_id_B).innerHTML = tab_data1; //frames[1]
					var element_id_L = perio_comp+perio_tooth+"P";
					//parent.parent.perioChartDisplay.document.getElementById(element_id_L).style.backgroundColor = 'white';
					parent.parent.perioChartDisplay.document.getElementById(element_id_L).innerHTML = tab_data2; //frames[1]
					 //frames[1]
				}
				else if(surfaces_appl == "N"){
					var non_surface_value = formObj.non_surface_value.value
					var element_id = perio_comp+perio_tooth;
					if (non_surface_value>=cut_off){
						parent.parent.perioChartDisplay.document.getElementById(element_id).innerHTML = "<font size='2.5' color='red'>"+non_surface_value+"</font>";
					}else{
						parent.parent.perioChartDisplay.document.getElementById(element_id).innerHTML = non_surface_value; //frames[1]
					}
				}
			}
		
			
		 //if(submit_yn == "Y"){
				formObj.method="post";
				formObj.target="messageFrame";

				if(mode == "update"){
					formObj.action="../../servlet/eOH.PerioChartAmendServlet";
					formObj.submit();
				}
				else{
					formObj.action="../../servlet/eOH.PerioChartServlet";
					formObj.submit();
				}
			//}

				var date_bc=currentDate();

				if(header_tab == "B"){//if condition added by parul for PE on 28/04/2010
					setTimeout("showOnAddRemarkLink()",200);

				}else if(header_tab == "E"){
					 setTimeout("showOnAddEvalRemarkLink()",200);
				}
				//added by parul on 17/11/2009 for IN016339
				//var sys_date = new Date();
				//var month = sys_date.getMonth();
				//var year = sys_date.getFullYear();
				//var date = sys_date.getDate();
				
				/*if(header_tab == "E"){ //Commented by Sridevi Joshi on 4/28/2010 for PE....values Not used any where		
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_1 = "facility_id="+facility_id;
					var xmlStr ="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=CurrentDate&"+params_1,false);
					xmlHttp.send(xmlDoc);
					var retVal_facility = trimString(xmlHttp.responseText);
					var operating_facility_id_ec="";
					var chart_code_ec="";
					var chart_date_start_ec="";
					var display_chart_num="";
					var chart_close_date_ec="";
					var chart_status_ec="";
					var chart_desc_ec="";
					var chart_type_ec="";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num;
					var xmlStr ="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartDetailsForHeaderEC&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_ec = trimString(xmlHttp.responseText);
					if(retVal_ec.length > 1){
						var retVal_arr = retVal_ec.split("##");
						operating_facility_id_ec = retVal_arr[0];
						chart_date_start_1 = retVal_arr[2];
						display_chart_num = retVal_arr[3];
						chart_close_date_1 = retVal_arr[4];
						chart_status_1 = retVal_arr[5];
						chart_type_ec = retVal_arr[7];
					}
				}*/

				 var BaselineChart_label=getLabel("eOH.BaselineChart.Label",'OH');
				 var ClosedDate_label=getLabel("eOH.ClosedDate.Label",'OH');
				 var ChartStartDate_label=getLabel("eOH.ChartStartDate.Label",'OH');
				 var CreatedAt_label=getLabel("eOH.CreatedAt.Label",'OH');
				 var EvaluationChart_label=getLabel("eOH.EvaluationChart.Label",'OH');
				 var CompletedDate_label=getLabel("eOH.CompletedDate.Label",'OH');
                 if (header_tab=="E") {
					parent.parent.perioChartDisplay.document.getElementById("header_id").innerHTML = '<td d="header_data"width= "100%" align="center" style="background-color:brown"><font color="white">'+EvaluationChart_label+' # '+chart_num+'.'+chart_line_num+' '+ChartStartDate_label+' '+date_bc+' '+CompletedDate_label+' '+','+' '+CreatedAt_label+''+facility_name+'</font></td>';

                 }else {
					parent.parent.perioChartDisplay.document.getElementById("header_id").innerHTML = '<td d="header_data"width= "100%" align="center" style="background-color:brown"><font color="white">'+BaselineChart_label+' # '+chart_num+', '+ChartStartDate_label+' '+date_bc+', '+ClosedDate_label+' '+','+CreatedAt_label+''+facility_name+'</font></td>';

				 }//END by parul on 17/11/2009 for IN016339
				

				formObj.insert_new_EC_yn.value = "N";
				parent.parent.parent.perioLoadParams.document.forms[0].chart_hdr_insert_yn.value = "N"; // frames[0]
				parent.parent.parent.perioLoadParams.document.forms[0].insert_new_EC_yn.value = "N";
				reset_record("servlet");
			//}
		}
	}
}

//Added by rajesh on 29012010 for CRF-491 UT issue 
/*function getFacilityName(){
	var params="";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getFacilityName&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}*/

function currentDate(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=CurrentDate&",false);
	xmlHttp.send(xmlDoc);
	var retVal= trimString(xmlHttp.responseText);
	return retVal;
}

function loadSurfaceValues(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var perio_chart = formObj.perio_chart.value;
	var component_codes_str = "";
			
	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&tab_code=BC"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >1){
			var retVal_arr = retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
					if(perio_chart != ""){
						//To get the components recorded for a chart
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "perio_chart="+perio_chart;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
						xmlHttp.send(xmlDoc);
						component_codes_str = trimString(xmlHttp.responseText); //Components Codes
					}
					var component_codes_arr = component_codes_str.split("~");
					for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
						var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
						var td_id_val = component_codes_arr[k]+code_desc_arr[1];

						if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
							//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
							//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

							//document.getElementById(td_id_B).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
							//document.getElementById(td_id_P).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />";
							}
						}
					}
				}
				//Commented by Sharon Crasta on 7/29/2009 for IN012543
			    //Commented By Sharon Crasta on 5/15/2009 for IN010673				
				/*else if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "0"){
					var component_codes_arr = component_codes_str.split("~");
					for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
						var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
						var td_id_val = component_codes_arr[k]+code_desc_arr[1];
						if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
							//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
							//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

							//document.getElementById(td_id_B).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_B).innerHTML = "&nbsp;&nbsp;"
							//document.getElementById(td_id_P).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_P).innerHTML = "&nbsp;&nbsp;"
						}

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
							}
						}
					}
				} */
				else if(code_desc_arr[0] == "LOC"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];
					if(code_desc_arr[8] == "1"){
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
							}
						}
					}
					else{
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
							}
						}
					}
				}else if(code_desc_arr[0] == "FUIN"){
					if(code_desc_arr[8] == "1"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "2"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "3"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
							}
						}
					}
				}
				else{
				var cut_off = "";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "chart_code="+perio_chart+"&component_code="+code_desc_arr[0];
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getCutOffValues&"+params,false);
				xmlHttp.send(xmlDoc);
				var cut_off = trimString(xmlHttp.responseText);
					var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
					var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
					var element_val_id = code_desc_arr[0]+code_desc_arr[1];
					//if(code_desc_arr[2] != "" || code_desc_arr[3] != "" ||  code_desc_arr[4] != ""){
						var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
						tab_data1 = tab_data1+ "<tr>";
						if (parseInt(code_desc_arr[2])>=parseInt(cut_off)){		
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[2]+"</td>";
						}else{
								tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
						}
						if (parseInt(code_desc_arr[3])>=parseInt(cut_off)){		
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[3]+"</td>";
						}else{
								tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
						}
						if (parseInt(code_desc_arr[4])>=parseInt(cut_off)){		
								tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[4]+"</td>";
						}else{
								tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
						}
											
						/*tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";*/
						tab_data1 = tab_data1+"</tr>";
						tab_data1 = tab_data1+"</table>"
					//}
					//if(code_desc_arr[5] != "" || code_desc_arr[6] != "" ||  code_desc_arr[7] != ""){
						var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
						tab_data2 = tab_data2+ "<tr>";
						/*tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";*/
						if (parseInt(code_desc_arr[5])>=parseInt(cut_off)){		
						 	tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[5]+"</td>";

                       }else{
						   tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
					   }
						if (parseInt(code_desc_arr[6])>=parseInt(cut_off)){		
					    	tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[6]+"</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
						}
						if (parseInt(code_desc_arr[7])>=parseInt(cut_off)){		
					    	tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[7]+"</td>";
						}else{
							tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
						}

						tab_data2 = tab_data2+"</tr>";
						tab_data2 = tab_data2+"</table>"
					//}
					if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
						//document.getElementById(element_B_id).style.backgroundColor = 'white';
						//document.getElementById(element_P_id).style.backgroundColor = 'white';
						document.getElementById(element_B_id).innerHTML = tab_data1;
						document.getElementById(element_P_id).innerHTML = tab_data2;
					}

					if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
						if(code_desc_arr[8] != ""){
							if(code_desc_arr[8]>=cut_off){
							document.getElementById(element_val_id).innerHTML = "<font size='2.5' color='red'>"+code_desc_arr[8]+"</font>";
							}else{
								document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
							}

						}
					}
				}
			}
		}
	//}
}



function loadEvalSurfaceValues(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var eval_active_yn = formObj.eval_active_yn.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&eval_active_yn="+eval_active_yn+"&tab_code=EC"+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
				//To get the components recorded for a chart
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "perio_chart="+perio_chart;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
				xmlHttp.send(xmlDoc);
				var component_codes_str = trimString(xmlHttp.responseText); //Components Codes
				var component_codes_arr = component_codes_str.split("~");
				for(k=0;k<component_codes_arr.length-1;k++){
					var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
					var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
					var td_id_val = component_codes_arr[k]+code_desc_arr[1];

					if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
						//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
						//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

						//document.getElementById(td_id_B).innerHTML = "<font size='4' color='red'>X</font>"
						document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						//document.getElementById(td_id_P).innerHTML = "<font size='4' color='red'>X</font>"
						document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
					}

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							//document.getElementById(td_id_val).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}
					}
				}
			}
			//Commented by Sharon Crasta on 7/29/2009 for IN012543
			//Commented By Sharon Crasta on 5/15/2009 for IN010673
			/*	else if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "0"){
					var component_codes_arr = component_codes_str.split("~");
					for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
						var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
						var td_id_val = component_codes_arr[k]+code_desc_arr[1];
						if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
							//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
							//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

							//document.getElementById(td_id_B).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_B).innerHTML = "&nbsp;&nbsp;"
							//document.getElementById(td_id_P).innerHTML = "<font size='4' color='red'>X</font>"
							document.getElementById(td_id_P).innerHTML = "&nbsp;&nbsp;"
						}

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
							}
						}
					}
				} 	 */
			else if(code_desc_arr[0] == "LOC"){
				var td_id_val = code_desc_arr[0]+code_desc_arr[1];
				if(code_desc_arr[8] == "1"){
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
						}
					}
				}
				else{
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
						}
					}
				}
			}else if(code_desc_arr[0] == "FUIN"){
				if(code_desc_arr[8] == "1"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "2"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "3"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
						}
					}
				}
			}
			else{
				var cut_off = "";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "chart_code="+perio_chart+"&component_code="+code_desc_arr[0];
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getCutOffValues&"+params,false);
				xmlHttp.send(xmlDoc);
				var cut_off = trimString(xmlHttp.responseText);
				var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
				var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
				var element_val_id = code_desc_arr[0]+code_desc_arr[1];
				//if(code_desc_arr[2] != "" || code_desc_arr[3] != "" ||  code_desc_arr[4] != ""){
					var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
					tab_data1 = tab_data1+ "<tr>";
					if (parseInt(code_desc_arr[2])>=parseInt(cut_off)){		
						tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[2]+"</td>";
					}else{
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
					}
					if (parseInt(code_desc_arr[3])>=parseInt(cut_off)){		
						tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[3]+"</td>";
					}else{
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
					}
					if (parseInt(code_desc_arr[4])>=parseInt(cut_off)){		
						tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[4]+"</td>";
					}else{
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
					}

				/*	tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";*/
					tab_data1 = tab_data1+"</tr>";
					tab_data1 = tab_data1+"</table>"
				//}
				//if(code_desc_arr[5] != "" || code_desc_arr[6] != "" ||  code_desc_arr[7] != ""){
					var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
					tab_data2 = tab_data2+ "<tr>";
					/*tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";*/
					if (parseInt(code_desc_arr[5])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[5]+"</td>";
					}else{
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
					}
				 	if (parseInt(code_desc_arr[6])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[6]+"</td>";
					}else{
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
					}
					if (parseInt(code_desc_arr[7])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[7]+"</td>";

					}else{
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
					}

					tab_data2 = tab_data2+"</tr>";
					tab_data2 = tab_data2+"</table>"
				//}
			
				if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
					//document.getElementById(element_B_id).style.backgroundColor = 'white';
					//document.getElementById(element_P_id).style.backgroundColor = 'white';
					document.getElementById(element_B_id).innerHTML = tab_data1;
					document.getElementById(element_P_id).innerHTML = tab_data2;
				}

				if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
					if(code_desc_arr[8] != ""){
						if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
							document.getElementById(element_val_id).innerHTML = "<font size='4' color='red'>X</font>";
						}
						else{
							if (code_desc_arr[8] >=cut_off){
								document.getElementById(element_val_id).innerHTML = "<font size='2.5' color='red'>"+code_desc_arr[8]+"</font>";
							}else{
							document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
							}
						}
					}
				}
			}
		}
	}
  //}
}

function checkMaxMinValue(obj){
//var surface_val = parseInt(obj.value);
	var surface_val = obj.value;
	if(surface_val.substring(0,1) == "0" && surface_val.length > 1){
		surface_val = surface_val.substring(1);
	}else if(surface_val.substring(0,2) == "-0" && surface_val.length > 2){
		surface_val = "-"+surface_val.substring(2);
	}
	
	surface_val = parseInt(surface_val);
	var formObj = document.forms[0];
	var min_val = formObj.min_val.value;
	var max_val = formObj.max_val.value;
	var val = obj.value;
	var negative_yn = "N";
	for(i=0;i<val.length;i++){
		if(val.charAt(i) == "-"){
			negative_yn = "Y";
			break;
		}
	}
	if(negative_yn == "Y"){
		//for(i=0;i<val.length;i++){
			if(val.charAt(0) == "-"){
				var str_val = val.substring(1);
				if(str_val.length > 0 && (str_val == "0" || str_val == "00" || str_val == "000")){
					hasChanged = true;
					if(hasChanged){
						alert(getMessage("APP-OH00056",'OH'));
						obj.focus();
						obj.select();
						hasChanged = false;
						return false;
					}
				}
				else if(str_val.length > 0){
					if(val.substring(0,2) == "--"){ //Validation for string "--0"
						alert(getMessage("NUM_ALLOWED", "SM"));
						obj.focus();
						obj.select();
						return false;
					}

					if(CheckForNumber(str_val) == true){
						if(surface_val < min_val || surface_val > max_val){
							hasChanged = true;
							if(hasChanged){
								var msg = getMessage("APP-OH00039","OH"); //Value should be between "+min_val+" - "+max_val
								var msg_arr = msg.split("##");
								alert(msg_arr[0]+min_val+msg_arr[1]+max_val+msg_arr[2]);
								obj.focus();
								obj.select();
								hasChanged = false;
								return false;
							}
						}
					}
					else{
						alert(getMessage("NUM_ALLOWED", "SM"));
						obj.focus();
						obj.select();
						return false;
					}
				}
				else{
					alert(getMessage("NUM_ALLOWED", "SM"));
					obj.focus();
					obj.select();
					return false;
				}
			}
			else{
				alert(getMessage("NUM_ALLOWED", "SM"));
				obj.focus();
				obj.select();
				return false;
			}
		//}
	}
	else{
		if(CheckNum(obj)){
			if(surface_val < min_val || surface_val > max_val){
				var msg = getMessage("APP-OH00039","OH"); //Value should be between "+min_val+" - "+max_val
				var msg_arr = msg.split("##");
				hasChanged = true;
				if(hasChanged){
					alert(msg_arr[0]+min_val+msg_arr[1]+max_val+msg_arr[2]);
					obj.focus();
					obj.select();
					hasChanged = false;
					return false;
				}
			}
		}
	}
}


function loadBaselineChart(chart_code,chart_date,chart_num,baseline_status){
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;
	var oh_chart_level = formObj.oh_chart_level.value;
	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
    var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&perio_arch=U&baseline_active_yn=Y&baseline_status="+baseline_status+"&called_from_BC_EV_yn=Y"+"&chart_date="+chart_date+"&oh_chart_level="+oh_chart_level;
	parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+params_hdr;
	//parent.parent.parent.parent.frames[1].location.href = "../../eOH/jsp/PerioChartRecordFrame.jsp?"+params_hdr;
}

function loadBaselineClosedChart(chart_code,chart_date,chart_num){
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;

	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
		
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&perio_arch=U&baseline_closed_yn=Y&baseline_status=CD"+"&chart_close_date="+chart_date;
	parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+params_hdr;
	//parent.parent.parent.parent.frames[1].location.href = "../../eOH/jsp/PerioChartRecordFrame.jsp?"+params_hdr;
}

function clearComponent(){
	var formObj = document.forms[0];
	formObj.perio_comp.value = "";
	
	populatePerioSurfaces(formObj.perio_comp);
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	
}

function closeChart(obj,called_from){
	var formObj = document.forms[0];
	var status = obj.value;
	var patient_id = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var chart_code = formObj.perio_chart.value;
	var perio_arch = formObj.perio_arch.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getHdrChartNum&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>0){
		chart_num = retVal;
	}
	else{
		chart_num = "";
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&status="+status+"&chart_num="+chart_num+"&called_from="+called_from+"&chart_line_num="+chart_line_num+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var DB_status = trimString(xmlHttp.responseText);
	
	//if(called_from == "BC"){
		if(status == 'CD'){
			if(chart_code == ""){
				return;
			}

			// Moved this code to completion stage			
			//if(checkValidations()){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&perio_chart="+chart_code+"&oh_chart_level="+oh_chart_level;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForECActiveChart&"+params,false);
				xmlHttp.send(xmlDoc);
				var DB_eval_status = trimString(xmlHttp.responseText);
				var DB_eval_status_arr = DB_eval_status.split("##");
				if(DB_eval_status_arr[0] == "Y" && called_from == "BC"){ //Active Chart
					alert(getMessage("APP-OH00045","OH"));
					formObj.perio_status.value = "";
					clearChartStatus(called_from);
					return false;
				}
				else{
					//var close_chart = confirm("Do you want to close the Chart?");
					if(chart_num == "" || chart_num == "null" || chart_num == null){
						alert(getMessage("APP-OH00051","OH"));
						formObj.perio_status.value = "";
						clearChartStatus(called_from);
						return;
					}

					//Check for Completed Evaluation Charts
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num+"&called_from="+called_from+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					if(retVal.length>1){
						if(retVal == "PE"){
							alert(getMessage("APP-OH00059",'OH')); //Only Completed Charts can be Closed
							clearChartStatus(called_from);
							return false;
						}
						
					}
					
					//Close the chart.Update the status as 'CD'
					var close_chart = confirm(getMessage("APP-OH00037","OH"));
					if(close_chart){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&status="+status+"&chart_num="+chart_num+"&called_from="+called_from+"&chart_line_num="+chart_line_num+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						reset_header();
					}
					else{
						formObj.perio_status.value = "";
						clearChartStatus(called_from);
						return false;
					}
				}
				/* Moved this code to completion stage
			}
			else{
				clearChartStatus(called_from);
			}
			*/
		}
		else if(status == "ME"){
			if(DB_status == "PE"){
				var mark_error = confirm(getMessage("APP-OH00038","OH"));
				if(mark_error){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&status="+status+"&chart_num="+chart_num+"&called_from="+called_from+"&chart_line_num="+chart_line_num+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					alert(getMessage("APP-OH00057","OH"));
					reset_header();
				}
				else{
					formObj.perio_status.value = "";
					clearChartStatus(called_from);
					return false;
				}
			}
			else if(DB_status == "CM" || DB_status == "CD"){
				alert(getMessage("APP-OH00043","OH"));
				formObj.perio_status.value = "";
				clearChartStatus(called_from);
				return false;
			}
			else{
				//if(chart_num == "" || chart_num == "null" || chart_num == null){
					alert(getMessage("APP-OH00053","OH"));
					formObj.perio_status.value = "";
					clearChartStatus(called_from);
					return;
				//}
			}
		}
		else if(status == "CM"){
			//var completed = confirm(getMessage("APP-OH00038","OH"));
			if(chart_num == "" || chart_num == "null" || chart_num == null){
				alert(getMessage("APP-OH00052","OH"));
				formObj.perio_status.value = "";
				clearChartStatus(called_from);
				return;
			}
			/*
			else if(chart_line_num == "" || chart_line_num =="null" || chart_line_num == null){
				alert(getMessage("APP-OH00052","OH"));
				formObj.perio_status.value = "";
				clearChartStatus(called_from);
				return;
			}
			*/
			if(DB_status != "CM" && DB_status == "PE"){
				if(checkValidations()){ // Moved from closechart 
					var completed = confirm(getMessage("APP-OH00044","OH"));
					if(completed){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&status="+status+"&chart_num="+chart_num+"&called_from="+called_from+"&chart_line_num="+chart_line_num+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&oh_chart_level="+oh_chart_level;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=updateChartStatus&"+params,false);
						xmlHttp.send(xmlDoc);
						formObj.perio_status.value = "CM";
						alert(getMessage("APP-OH00050","OH"));
						
						//To reset record Frame
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_tooth.value = "";
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_comp.value = "";
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].mode.value = "";
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].action="../../servlet/eOH.PerioChartServlet";

						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.getElementById("tooth_surface1").innerHTML = "&nbsp";
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.getElementById("tooth_surface2").innerHTML = "&nbsp";

						//To disable the record frame once the Chart is completed
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].save.disabled = true;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].reset.disabled = true;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_tooth.disabled = true;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_comp.disabled = true;


						if(called_from == "BC"){
							clear_list(formObj.perio_status); 
							optSel	= document.createElement("OPTION");
							optSel.text = getLabel("Common.completed.label","Common");
							optSel.value= 'CM'; 
							formObj.perio_status.add(optSel);

							optSel	= document.createElement("OPTION");
							optSel.text = getLabel("Common.closed.label","Common");
							optSel.value= 'CD'; 
							formObj.perio_status.add(optSel);
						}
						else if(called_from == "EC"){
							//reset_header();
						}

						if(called_from == "EC"){
							var hist_image_values = loadEvalSurfaceValuesForHistory();
							hist_image_values = escape(hist_image_values);
							storeImageClob(patient_id,chart_num,chart_line_num,tooth_numbering_system,"P",chart_code,perio_arch,'EC',hist_image_values);
						}
						else if(called_from == "BC"){
							var hist_image_values = loadSurfaceValuesForHistory();
							hist_image_values = escape(hist_image_values);
							storeImageClob(patient_id,chart_num,chart_line_num,tooth_numbering_system,"P",chart_code,perio_arch,'BC',hist_image_values);
						}
					}else{
						formObj.perio_status.value = "";
						clearChartStatus(called_from);
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].save.disabled = false;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].reset.disabled = false;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_tooth.disabled = false;
						parent.perioChartRecordFrame.perioChartRecordFrame.perioChartRecordDetails.perioChartRecord.document.forms[0].perio_comp.disabled = false;
						return false;
					}
				}
				else{
					formObj.perio_status.value = "";
					clearChartStatus(called_from);
				}
			}else if(DB_status == "CM"){
				alert(getMessage("APP-OH00058",'OH'));
				formObj.perio_status.value = "";
				clearChartStatus(called_from);
				return;
			}
			else{
				alert(getMessage("APP-OH00052","OH"));
				formObj.perio_status.value = "";
				clearChartStatus(called_from);
				return;
			}
		}

		
	//}
	
}

function checkValidations(){
	var flag = true;
	var formObj = document.forms[0];
	var status =formObj.perio_status.value;
	var patient_id = formObj.patient_id.value;
	var tooth_numering_system = formObj.perio_numbering_system.value;
	
	var tooth_no = "";
	var disp_tooth_no = "";
	var comp_desc = "";
	var comp_code = "";
	var tooth_no_arr = "";
	var retVal2 = "";
	var retVal3 = "";
	var other_cnt = "";
	var missing_cnt = "";

	var flag = true;
	var chart_code = formObj.perio_chart.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&tooth_numering_system="+tooth_numering_system+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioMandatoryValidation.jsp?func_mode=CompleteChartStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	/*
	if(retVal!=""){
		alert(getMessage("APP-OH00073","OH")+"{"+retVal+"}");
		flag= false;
	}
	else{
		flag= true;
	}
	*/

	if(retVal!=""){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		
		var retVal_arr = retVal.split(",");
		for(p=0;p<retVal_arr.length;p++){
			var tooth_desc_arr = retVal_arr[p].split("- #");
			comp_desc = trimString(tooth_desc_arr[0]);
			disp_tooth_no = trimString(tooth_desc_arr[1]);

			//To get the Component code
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "component_desc="+comp_desc;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getComponentCode&"+params,false);
			xmlHttp.send(xmlDoc);
			var comp_code = trimString(xmlHttp.responseText);

			//To get the Tooth_no
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "disp_tooth_no="+disp_tooth_no+"&tooth_numbering_system="+tooth_numering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var int_tooth_no = trimString(xmlHttp.responseText);

			//To check recorded Missing tooth for tooth no for which tooth applicability(Mandatory actions) is defined.
			var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&check_missing_for_completion=Y&perio_tooth="+int_tooth_no;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForMissingTooth&"+params,false);
			xmlHttp.send(xmlDoc);
			var ret_value = trimString(xmlHttp.responseText);
			if(ret_value.length >1){
				var ret_value_arr = ret_value.split("~");
				for(m=0;m<ret_value_arr.length-1;m++){
					var code_arr_desc = ret_value_arr[m].split("##");
					if(code_arr_desc[0] == "MITH" && code_arr_desc[1] == "1"){
						if(tooth_no_arr == ""){
							tooth_no_arr = disp_tooth_no;
						}
						else{
							if(tooth_no_arr.indexOf(disp_tooth_no) == -1){ //If tooth_no already exists...incase of 2 mandatory actions for a component
								tooth_no_arr = tooth_no_arr+","+disp_tooth_no;
							}
						}
					}
					else{ 
						if(code_arr_desc[0] != "" && comp_code != "MITH"){
							if(retVal3 == "" ||  retVal3 == "N"){
								retVal3 = retVal_arr[p];
							}
							else{
								if(retVal3.indexOf(retVal_arr[p]) == -1){
									retVal3 = retVal3+","+retVal_arr[p];
								}
							}
						}
						else{
							if(retVal3 == ""){
								retVal3 = 'N';
							}

							if(tooth_no_arr == ""){
								tooth_no_arr = disp_tooth_no;
							}
							else{
								if(tooth_no_arr.indexOf(disp_tooth_no) == -1){ //If tooth_no already exists...incase of 2 mandatory actions for a component
									tooth_no_arr = tooth_no_arr+","+disp_tooth_no;
								}
							}

							if(retVal3 == "" ||  retVal3 == "N"){
								retVal3 = retVal_arr[p];
							}
							else{
								if(retVal3.indexOf(retVal_arr[p]) == -1){
									retVal3 = retVal3+","+retVal_arr[p];
								}
							}
						}
					}
				}
			}
			else{
				if(retVal3 == "" ||  retVal3 == "N"){
					retVal3 = retVal_arr[p];
				}
				else{
					if(retVal3.indexOf(retVal_arr[p]) == -1){
						retVal3 = retVal3+","+retVal_arr[p];
					}
				}
			}
		}

		if(retVal3 != "" && retVal3 != "N"){
			alert(getMessage("APP-OH00073","OH")+"{"+retVal3+"}");
			flag= false;
		}
		else{
			if(retVal3 != "N"){
				var msg ="";
				if(tooth_no_arr.indexOf(",") != -1){
					//msg = getMessage("APP-OH000114","OH");
				}
				else{
					//msg = getMessage("APP-OH000115","OH");
				}
				
				//var msg_arr = msg.split("##");
				//alert(msg_arr[0]+tooth_no_arr+msg_arr[1]);
			}
			flag= true;
		}
	}
	
	return flag;
}

function reset_record(called_from){
	var formObj = document.forms[0];
	if(formObj.disable_record.value == "Y"){
		return;
	}
	formObj.perio_tooth.value = "";
	formObj.perio_comp.value = "";
	formObj.mode.value = "";
	formObj.action="../../servlet/eOH.PerioChartServlet";
	populatePerioSurfaces(formObj.perio_comp);
	if(called_from != "servlet"){
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	}
	document.getElementById("perioChartTable").focus();
 }

function reset_header(){
	var formObj = document.forms[0];
	var main_tab = formObj.main_tab.value;
	var ca_params = parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
	formObj.perio_numbering_system.value = "";
	formObj.perio_chart.value = "";
	formObj.perio_arch.value = "";
	if(main_tab == "EvaluationChart"){
		document.location.href = "../../eOH/jsp/PerioEvalChartHeader.jsp?"+ca_params;
	}
	else{
		document.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+ca_params;
	}

	/* Added by Sridevi Joshi on 3/30/2010 for IN018167 */
	var messageFrame = parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	/* End of IN018167*/
}

function assignDBValue(){
	var formObj = document.forms[0];
	var status = "";
	var active_closed_chart = "";
	var patient_id = formObj.patient_id.value;
	//var chart_code = formObj.chart_code.value;
	var perio_status = formObj.perio_status.value;

	status = formObj.perio_status.DB_Value;
	status = trimString(status);
	status = localTrimString(status);
	
	if(status == "CD"){
		optSel	= document.createElement("OPTION");
		optSel.text = getLabel("Common.closed.label","Common");
		optSel.value= 'CD'; 
		document.forms[0].perio_status.add(optSel);
	}

	if(perio_status == "" || perio_status == "null" || perio_status == null){
		
		if(status == ""){
			formObj.perio_status.value = "";
		}
		else{
			formObj.perio_status.value = status;
		}
	}

	if(status == "CM"){
		formObj.perio_numbering_system.disabled = true;
		formObj.perio_chart.disabled = true;
	}

	
}

function expandMenu(obj,img_name){
		buildTable(obj);
		switchMenu(obj,img_name);
}

function buildTable(obj){
	var formObj = document.perioChartBaselineForm;
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var locale = formObj.locale.value;
	var condition_date;
	var condition_type;
	var index;
	var closed_chart_label = getLabel("eOH.ClosedChart.Label","OH");//"Closed Chart";
	var active_chart_label = getLabel("eOH.ActiveChart.Label","OH");//"Active Chart";
	/*
		menuDC (Dental Conditions)
		menuET (External Treatment)
		menuBC (Baseline Chart)
		menuCN (Clinical Notes)
		menuOL (Other Links)
	*/
	var addnew_label = getLabel("Common.Add/New.label","Common");
	//var addnew_label = "Add/New";
	if(obj!=null && obj!=""){
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' >";
		/*
		if(obj=="menuBCC"){
			// Display the 1st row as Add/New
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
			tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:displayNewChart(\'NEW\',\''+addnew_label+'\');\">'+addnew_label+'</a></div></td>';
			tab_dat     += "</tr> ";
		}
		*/
		

	/*	if(obj == "menuBCC"){ // Baseline Chart Closed
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&status=CD"+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayBCClosedMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
					//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadBaselineClosedChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[2]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</a></div></td>';
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadBaselineClosedChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</a></div></td>';
					
					
					tab_dat     += "</tr> ";
				}
			}
		}else*/ if (obj=="menuFC"){//Other Facility Charts Baseline          //added by parul  for other facility chart CRF#0423
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
						var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&status=PE,CM"+"&facility_id="+code_desc_arr1[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayOtherBCActiveMenu&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
							if(retVal.length>1){
								tab_dat     += "<tr>";
								tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
								tab_dat     += "</tr> ";
							
								var retVal_arr = retVal.split("~");
								for(var i=0;i<retVal_arr.length-1;i++){
									var code_desc_arr = retVal_arr[i].split("##");
									code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
									tab_dat     += "<tr>";
									tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
									//tab_dat     += "&nbsp;&nbsp;";
									tab_dat  +='<a href=\"javascript:loadFacilityBaselineChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[4]+'\',\''+code_desc_arr1[1]+'\''+');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')['+code_desc_arr[4]+']</a>';
									tab_dat     += "</td></tr> ";

								}
						  }


						 var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&status=CD"+"&oh_chart_level="+oh_chart_level+"&facility_id="+code_desc_arr1[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayOtherBCClosedMenu&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						if(retVal.length>1){
							tab_dat     += "<tr>";
							tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
							tab_dat     += "</tr> ";
							var retVal_arr = retVal.split("~");
							for(var i=0;i<retVal_arr.length-1;i++){
							var code_desc_arr = retVal_arr[i].split("##");
							code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
							tab_dat     += "<tr>";
							//tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
							//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadFacilityBaselineClosedChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr1[1]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</a></div></td>';
							tab_dat     += '<td nowrap id="mouse" class="LABEL" ><div align="left"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="left" /></div>';
							tab_dat  +='<a href=\"javascript:loadFacilityBaselineClosedChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr1[1]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</a>';
							tab_dat     += "</td></tr> ";

						}
					}

				} 
			 }
		}else if (obj=="menuEFC"){
		//Eval Other Facility Charts           //added by parul  for other facility chart CRF#0423
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
							var params = "patient_id="+patient_id+"&status=CM"+"&oh_chart_level="+oh_chart_level+"&facility_id1="+code_desc_arr1[1];
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayOtherBECMenu&"+params,false);
							xmlHttp.send(xmlDoc);
							
							var retVal = trimString(xmlHttp.responseText);
							if(retVal.length>1){
								tab_dat     += "<tr>";
								tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
								tab_dat     += "</tr> ";
								var retVal_arr = retVal.split("~");
								for(var i=0;i<retVal_arr.length-1;i++){
									rownum=i;
									var code_desc_arr = retVal_arr[i].split("##");
									code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
									tab_dat     += "<tr>";
								//	tab_dat     += "<td nowrap id='mouse"+rownum+"menuBEC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuBEC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
									tab_dat     += "<td nowrap id='mouse"+rownum+"menuEFC' onclick=buildFaclityEvalTable('"+code_desc_arr1[1]+"','"+code_desc_arr[0]+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuEFC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
									
									tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</div></td>';
								
									tab_dat     += "</tr> ";

									tab_dat     +="<tr>";
									tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
									tab_dat     +="<div id=\"menuEval style='visibility:hidden;display:none'\">"
									tab_dat     +="<td id='eval_chart_row_"+rownum+"menuEFC' style='display:none'>"
									tab_dat     +="</td>"
									tab_dat     +="</div>"
									tab_dat     +="</tr>"
								}
							}
//closed

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&status=CM"+"&oh_chart_level="+oh_chart_level+"&facility_id1="+code_desc_arr1[1];
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayOtherECClosedMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;

					tab_dat     += "<tr>";
					//tab_dat     += "<td nowrap id='mouse"+rownum+"menuEBCC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuEBCC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
					tab_dat     += "<td nowrap id='mouse"+rownum+"menuEFCC' onclick=buildFaclityEvalTable('"+code_desc_arr1[1]+"','"+code_desc_arr[0]+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuEFCC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
					tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</div></td>';
					
					tab_dat     += "</tr> ";

					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuEval style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='eval_chart_row_"+rownum+"menuEFCC' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"
				}
			}

				} 
			 }
		}
		else if(obj == "menuBCA"){ // Baseline Chart Active
			//To display Active Baseline Charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&oh_chart_level="+oh_chart_level+"&status=PE,CM";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayBCActiveMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;

					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
					//tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadBaselineChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[4]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')['+code_desc_arr[4]+']</a></div></td>';
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadBaselineChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[4]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')['+code_desc_arr[4]+']</a></div></td>';
					
					tab_dat     += "</tr> ";
				}
			}

			//To display Closed Baseline Charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&status=CD"+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayBCClosedMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
					tab_dat     += "<tr>";
					tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';
					tab_dat     += '<td class="LABEL"><div align="left"><a href=\"javascript:loadBaselineClosedChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\');\">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</a></div></td>';
					tab_dat     += "</tr> ";
				}
			}
		}
		else if(obj == "menuBEC"){ // Baseline Charts/Evaluation Charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&status=CM"+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayBECMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+active_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
					tab_dat     += "<tr>";
				//	tab_dat     += "<td nowrap id='mouse"+rownum+"menuBEC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuBEC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
					tab_dat     += "<td nowrap id='mouse"+rownum+"menuBEC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuBEC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
					tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</div></td>';
					
					tab_dat     += "</tr> ";

					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuEval style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='eval_chart_row_"+rownum+"menuBEC' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"
				}
			}
		//}
		//else if(obj == "menuEBCC"){ // Baseline Charts/Evaluation Charts
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&status=CM"+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayBCClosedMenu&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				tab_dat     += "<tr>";
				tab_dat     += '<td class="LABEL" COLSPAN=2><div align="left">'+closed_chart_label+'</div></td>';
				tab_dat     += "</tr> ";
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					rownum=i;
					var code_desc_arr = retVal_arr[i].split("##");
					code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;

					tab_dat     += "<tr>";
					//tab_dat     += "<td nowrap id='mouse"+rownum+"menuEBCC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuEBCC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";
					tab_dat     += "<td nowrap id='mouse"+rownum+"menuEBCC' onclick=buildEvalTable('"+code_desc_arr[0]+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+rownum+"','"+obj+"','menuEBCC'); width='10%'><div align='center' style='cursor:pointer'><B>+</B></div></td>";

					tab_dat     += '<td class="LABEL"><div align="left">'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[2]+')</div></td>';
					
					tab_dat     += "</tr> ";

					tab_dat     +="<tr>";
					tab_dat     +="<div style='visibility:hidden;display:none'\"><td></td></div>";
					tab_dat     +="<div id=\"menuEval style='visibility:hidden;display:none'\">"
					tab_dat     +="<td id='eval_chart_row_"+rownum+"menuEBCC' style='display:none'>"
					tab_dat     +="</td>"
					tab_dat     +="</div>"
					tab_dat     +="</tr>"
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

function buildEvalTable(chart_code,chart_date,chart_num,rownum,obj,active_closed_chart){
	switchTasksMenu(rownum,obj,active_closed_chart);
	var formObj = document.perioChartBaselineForm;
	var patient_id = formObj.patient_id.value;
	var locale = formObj.locale.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	//var chart_details_arr	= chart_details.split(":");
	//var chart_num			= chart_details_arr[0];
	//var chart_line_num		= chart_details_arr[1];

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num+"&active_closed_chart="+active_closed_chart+"&oh_chart_level="+oh_chart_level+"&chart_date="+chart_date;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayEvalChartMenu&"+params,false);
	xmlHttp.send(xmlDoc);
	
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var tab_dat = "<table id ='evalChartTable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' background-color ='black'>";
		
		var retVal_arr = retVal.split("~");
		for(k=0;k<retVal_arr.length-1;k++){
			var code_desc_arr = retVal_arr[k].split("##");
			code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
			
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';	
			

			tab_dat     += '<td class="LABEL"><div align="left"><a href =\"javascript:loadEvalChart(\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[4]+'\',\''+code_desc_arr[5]+'\',\''+active_closed_chart+'\');\">&nbsp;&nbsp;'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[4]+')['+code_desc_arr[5]+']</a></div></td>';
			
			tab_dat     += "</tr>";
		}
		tab_dat  += "</table>";
		var eval_chart_row_num = "eval_chart_row_"+rownum+active_closed_chart;
		
		document.getElementById(eval_chart_row_num).innerHTML = tab_dat;
		
	}
}

function switchTasksMenu(obj,menu,active_closed_chart) {
	var task_row_num = "eval_chart_row_"+obj+active_closed_chart;
	var el = document.getElementById(task_row_num);

	if ( el.style.display != "none" ) {
		el.style.display = 'none';

		var image_id = "mouse"+obj+active_closed_chart;
		document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>+</B></div>';
	}
	else {
		el.style.display = '';

		var image_id = "mouse"+obj+active_closed_chart;
		document.getElementById(image_id).innerHTML = '<div align="center" style="cursor:pointer"><B>-</B></div>';
	}
}

function loadEvalChart(chart_code,chart_date,chart_num,chart_line_num,chart_status,active_closed_chart){
	//active_closed_chart//menuBEC
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;
	var oh_chart_level = formObj.oh_chart_level.value;
	
	var eval_active_yn = "N";
	if(chart_status == "PE"){
		eval_active_yn = "Y";
	}
	else{
		eval_active_yn = "N";
	}
	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
		
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	//params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_arch=U&eval_active_yn="+eval_active_yn+"&baseline_status="+chart_status+"&active_closed_chart="+active_closed_chart+"&chart_date="+chart_date+"&oh_chart_level="+oh_chart_level;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_arch=U&eval_active_yn="+eval_active_yn+"&baseline_status="+chart_status+"&active_closed_chart="+active_closed_chart+"&chart_date="+chart_date+"&oh_chart_level="+oh_chart_level;
	parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioEvalChartHeader.jsp?"+params_hdr;
	
}

function checkForMissingTooth(){
	var formObj = document.forms[0];
	var perio_comp = formObj.perio_comp.value;
	//if(perio_comp == "MITH"){
		var patient_id = formObj.patient_id.value;
		var chart_code = formObj.perio_chart.value;
		var header_tab = formObj.header_tab.value;
		var chart_num = formObj.chart_num.value;
		var perio_tooth = formObj.perio_tooth.value;
		
		//var non_surface_value = formObj.non_surface_value.value;
		var chart_line_num = formObj.chart_line_num.value;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&header_tab="+header_tab+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_tooth="+perio_tooth;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForMissingTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		//if((retVal != "0" && perio_comp != "MITH") || (retVal != "0" && perio_comp == "MITH" && formObj.non_surface_value != null && formObj.non_surface_value != "null" && formObj.non_surface_value.value == "1")){
		//if((retVal != "0" ) || (retVal != "0" && formObj.non_surface_value != null && formObj.non_surface_value != "null" && formObj.non_surface_value.value == "1")){
		if((retVal != "0" && perio_comp != "MITH") || (retVal != "0" && formObj.non_surface_value != null && formObj.non_surface_value != "null" && formObj.non_surface_value.value == "1")){
			return false;
		}
		
	//}
	return true;
}

//Added by Sharon Crasta on 5/15/2009 for IN010673
function checkForRecordings(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var perio_tooth = formObj.perio_tooth.value;
	var header_tab = formObj.header_tab.value;
	if(header_tab == "E"){
		tab_code = "EC";
	}else{
		tab_code = "BC";		
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&tab_code="+tab_code+"&oh_chart_level="+oh_chart_level+"&perio_tooth="+perio_tooth;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getRecordsForTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal=localTrimString(retVal);
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(k=0;k<retVal_arr.length-1;k++){
			var code_desc_arr = retVal_arr[k].split("##");
			perio_comp =   code_desc_arr[0];
			perio_value =   code_desc_arr[1];
			if(retVal_arr.length==2){
				if(perio_comp == "MITH" && perio_value == "0"){	
					return true;
				}else {
					return false;
					}
			}else{
				return false;
			}
		}
	}
	return true;
}
//

/*function callComponentCode(chart_code,chart_num,patient_id){
	//callComponentCode
		var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=callComponentCode&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}*/

async function showGraphDialog(chart_num,chart_line_num,chart_code,perio_arch,tooth_numbering_system,permanent_deciduous_flag){
	var formObj_Hdr = parent.parent.parent.perioChartHeaderFrame.document.perioChartHeaderForm;
	var chart_line_num = formObj_Hdr.chart_line_num.value;
	if(chart_num == null || chart_num == "null" || chart_num == ""){
		chart_num = formObj_Hdr.chart_num.value;
	}
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var components="";
	var sel_radio_val="PD";
	var load_flag="";
	var	pd_val="PD";
	var cej_val="CEJ";
	var cal_val="CAL";
	//var params = 'patient_id='+patient_id+'&chart_num='+chart_num+'&chart_line_num='+chart_line_num+'&chart_code='+chart_code+'&perio_arch='+perio_arch+'&tooth_numbering_system='+tooth_numbering_system+'&permanent_deciduous_flag='+permanent_deciduous_flag;
	//+"&pd_val=PD&cal_val=CAL&cej_val=CEJ&sel_radio_val=CAL"
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_code+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&cal_val="+cal_val+"&components="+components+"&sel_radio_val="+sel_radio_val+"&load_flag="+load_flag+"&pd_val="+pd_val+"&cej_val="+cej_val;
	//var url	= "../../eOH/jsp/PerioTestGraph.jsp?"+params;
	var url	= "../../eOH/jsp/PerioGraphFrames.jsp?"+params;
	var dialogHeight= "55vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop ="125";
	var dialogLeft ="525";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=yes; status:" + status;
	await window.showModalDialog(url,arguments,features);
	//window.open(url,arguments,features);
}

async function callPerioSummary(chart_num,chart_line_num,chart_code,perio_arch,tooth_numbering_system,permanent_deciduous_flag){
	var formObj_Hdr = parent.parent.parent.perioChartHeaderFrame.document.perioChartHeaderForm;
	var chart_line_num = formObj_Hdr.chart_line_num.value;
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var params = 'patient_id='+patient_id+'&chart_num='+chart_num+'&chart_line_num='+chart_line_num+'&chart_code='+chart_code+'&perio_arch='+perio_arch+'&tooth_numbering_system='+tooth_numbering_system+'&permanent_deciduous_flag='+permanent_deciduous_flag;
	var url	= "../../eOH/jsp/PerioSummaryActive.jsp?"+params;
	/*
	var dialogHeight= "50" ;
	var dialogWidth	= "60" ;
	var dialogTop ="125";
	var dialogLeft ="525";
	*/
	var dialogHeight= "50vh" ;  // 7
	var dialogWidth	= "65vw" ; // 22
	var dialogTop = (window.screen.availHeight-dialogHeight)/3;//"210" ;
	var dialogLeft = (window.screen.availWidth-dialogWidth)/4;// "240" ;
	var center = "1" ;

	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
	//window.open(url,arguments,features);
}

function getHeaderChartNum(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_code = formObj.perio_chart.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var header_tab = "";
	if(parent.frames[1].EvaluationChart.className == "tabClicked"){
		header_tab = "E";
	}
	else if(parent.frames[1].Compare.className == "tabClicked"){
		header_tab = "C";
	}
	else{
		header_tab = "B";
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getHdrChartNum&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>0){
		chart_num = retVal;
	}
	else{
		chart_num = "";
		/*
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=createNewChartNum&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length >0){
			chart_num = retVal;
			
		}
		*/
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getHdrChartNumAndLineNum&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length>0){
		chart_line_num = retVal;
	}
	else{
		chart_line_num = "";
		
	}
	
	formObj.chart_num.value = chart_num;
	formObj.chart_line_num.value = chart_line_num;

}

function clearChartStatus(called_from){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_code = formObj.perio_chart.value;
	var chart_line_num = formObj.chart_line_num.value;
	
	formObj.perio_status.value = "";
	//formObj.perio_arch.value = "";//commented by parul on 12/01/2010 for IN018098
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num+"&called_from="+called_from;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=getChartStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(called_from == "EC"){
		if(retVal.length>1){
			if(retVal == "CM"){ //To remove Active and Mark Error entries from the status list item when the chart is completed
				clear_list(formObj.perio_status); 
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.completed.label","Common");
				optSel.value= 'CM'; 
				formObj.perio_status.add(optSel);

			}
			else{
				clear_list(formObj.perio_status); 
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.active.label","Common");
				optSel.value= 'PE'; 
				formObj.perio_status.add(optSel);

				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.completed.label","Common");
				optSel.value= 'CM'; 
				formObj.perio_status.add(optSel);
				
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.MarkError.label","Common");
				optSel.value= 'ME'; 
				formObj.perio_status.add(optSel);
			}
			formObj.perio_status.value = retVal;
		}
		else{
			clear_list(formObj.perio_status); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.active.label","Common");
			optSel.value= 'PE'; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.completed.label","Common");
			optSel.value= 'CM'; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.MarkError.label","Common");
			optSel.value= 'ME'; 
			formObj.perio_status.add(optSel);
		}
	}
	else{
		if(retVal.length>1){
			if(retVal == "CM"){ //To remove Active and Mark Error entries from the status list item when the chart is completed
				clear_list(formObj.perio_status); 
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.completed.label","Common");
				optSel.value= 'CM'; 
				formObj.perio_status.add(optSel);

				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.closed.label","Common");
				optSel.value= 'CD'; 
				formObj.perio_status.add(optSel);
			}
			else{
				clear_list(formObj.perio_status); 
				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.active.label","Common");
				optSel.value= 'PE'; 
				formObj.perio_status.add(optSel);

				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.completed.label","Common");
				optSel.value= 'CM'; 
				formObj.perio_status.add(optSel);

				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.closed.label","Common");
				optSel.value= 'CD'; 
				formObj.perio_status.add(optSel);

				optSel	= document.createElement("OPTION");
				optSel.text = getLabel("Common.MarkError.label","Common");
				optSel.value= 'ME'; 
				formObj.perio_status.add(optSel);
			}
			formObj.perio_status.value = retVal;
		}
		else{
			clear_list(formObj.perio_status); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.active.label","Common");
			optSel.value= 'PE'; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.completed.label","Common");
			optSel.value= 'CM'; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.closed.label","Common");
			optSel.value= 'CD'; 
			formObj.perio_status.add(optSel);

			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("Common.MarkError.label","Common");
			optSel.value= 'ME'; 
			formObj.perio_status.add(optSel);
		}
	}
	
	
}

function CheckForNumber(val) {
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            //alert(getMessage("NUM_ALLOWED", "SM"));
            return false;
        }
}

function storeImageClob(patient_id,chart_num,chart_line_num,tooth_numbering_system,permanent_deciduous_flag,chart_code,perio_arch,tab_code,hist_image_values){
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&perio_chart="+chart_code+"&perio_arch="+perio_arch+"&tab_code="+tab_code+"&hist_image_values="+hist_image_values;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","HistPerioChart.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
}

//Function to disable all special characters in master codes.
function OHCheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


	function loadFacilityBaselineChart(chart_code,chart_date,chart_num,baseline_status,facility_id){
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;
	var oh_chart_level = formObj.oh_chart_level.value;
	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
	
    var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&perio_arch=U&baseline_active_yn=Y&baseline_status="+baseline_status+"&called_from_BC_EV_yn=Y"+"&chart_date="+chart_date+"&other_chart_facility_id="+facility_id+"&oh_chart_level="+oh_chart_level+"other_chart_facility_id="+facility_id+"&other_facilitychart_yn=Y";
	parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+params_hdr;
	//parent.parent.parent.parent.frames[1].location.href = "../../eOH/jsp/PerioChartRecordFrame.jsp?"+params_hdr;
}


function loadFacilityBaselineClosedChart(chart_code,chart_date,chart_num,other_chart_facility_id){
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;
	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&perio_arch=U&baseline_closed_yn=Y&baseline_status=CD"+"&chart_close_date="+chart_date+"&other_chart_facility_id="+other_chart_facility_id+"&other_facilitychart_yn=Y";
	//parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+params_hdr;
		parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioChartHeader.jsp?"+params_hdr;
	//parent.parent.parent.parent.frames[1].location.href = "../../eOH/jsp/PerioChartRecordFrame.jsp?"+params_hdr;
}



function buildFaclityEvalTable(facility_id,chart_code,chart_date,chart_num,rownum,obj,active_closed_chart){
	switchTasksMenu(rownum,obj,active_closed_chart);
	var formObj = document.perioChartBaselineForm;
	var patient_id = formObj.patient_id.value;
	var locale = formObj.locale.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	//var chart_details_arr	= chart_details.split(":");
	//var chart_num			= chart_details_arr[0];
	//var chart_line_num		= chart_details_arr[1];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num+"&active_closed_chart="+active_closed_chart+"&oh_chart_level="+oh_chart_level+"&chart_date="+chart_date+"&other_chart_facility_id="+facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=displayFacilityEvalChartMenu&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var tab_dat = "<table id ='evalChartTable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' background-color ='black'>";
		
		var retVal_arr = retVal.split("~");
		for(k=0;k<retVal_arr.length-1;k++){
			var code_desc_arr = retVal_arr[k].split("##");
			code_desc_arr[1] =   convertDate(code_desc_arr[1],'DMY','en',locale) ;
			
			tab_dat     += "<tr>";
			tab_dat     += '<td nowrap id="mouse" ><div align="center"><img src="../../eOH/images/Arrow.gif" alt="Arrow" width="11" height="9" align="middle" /></div></td>';	
			tab_dat     += '<td class="LABEL"><div align="left"><a href =\"javascript:loadEvalFacilityChart(\''+facility_id+'\',\''+code_desc_arr[0]+'\',\''+code_desc_arr[1]+'\',\''+code_desc_arr[2]+'\',\''+code_desc_arr[4]+'\',\''+code_desc_arr[5]+'\',\''+active_closed_chart+'\');\">&nbsp;&nbsp;'+code_desc_arr[1]+'('+code_desc_arr[3]+':'+code_desc_arr[4]+')['+code_desc_arr[5]+']</a></div></td>';
				tab_dat     += "</tr>";
		}
		tab_dat  += "</table>";
		var eval_chart_row_num = "eval_chart_row_"+rownum+active_closed_chart;
		document.getElementById(eval_chart_row_num).innerHTML = tab_dat;
	}
}


function loadEvalFacilityChart(facilty,chart_code,chart_date,chart_num,chart_line_num,chart_status,active_closed_chart){
	//active_closed_chart//menuBEC
	var formObj = document.forms[0];
	var perio_chart = chart_code;
	var chart_num = chart_num;
	var oh_chart_level=formObj.oh_chart_level.value
	var eval_active_yn = "N";
	if(chart_status == "PE"){
		eval_active_yn = "Y";
	}
	else{
		eval_active_yn = "N";
	}
	var ca_params = parent.parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
	
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	params_hdr = ca_params +"&perio_chart="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_arch=U&eval_active_yn="+eval_active_yn+"&baseline_status="+chart_status+"&active_closed_chart="+active_closed_chart+"&chart_date="+chart_date+"&other_chart_facility_id="+facilty+"&other_facilitychart_yn=Y"+"&oh_chart_level="+oh_chart_level;
	parent.parent.parent.parent.perioChartHeaderFrame.location.href = "../../eOH/jsp/PerioEvalChartHeader.jsp?"+params_hdr;
}

async function getPeriodontalDataEntry(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var q1_sno = formObj.q1_sno.value;
	var q2_sno = formObj.q2_sno.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var cur_chart_num = formObj.cur_chart_num.value;
	var header_tab = formObj.header_tab.value;
	var show_new_active_yn = formObj.show_new_active_yn.value;
	var chart_hdr_insert_yn = formObj.chart_hdr_insert_yn.value;
	var insert_new_EC_yn = formObj.insert_new_EC_yn.value;
	var disable_record = formObj.disable_record.value;
	var episode_type = formObj.episode_type.value;
	var episode_id = formObj.episode_id.value;
	var visit_id = formObj.visit_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var visit_id = formObj.visit_id.value;
	//var other_facilitychart_yn = formObj.other_facilitychart_yn.value;
	//var perio_arch = formObj.perio_arch.value;

	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&tab_code=BC"+"&oh_chart_level="+oh_chart_level+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&q1_sno="+q1_sno+"&q2_sno="+q2_sno+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&cur_chart_num="+cur_chart_num+"&header_tab="+header_tab+"&show_new_active_yn="+show_new_active_yn+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&insert_new_EC_yn="+insert_new_EC_yn+"&disable_record="+disable_record+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&oh_chart_level="+oh_chart_level+"&other_facilitychart_yn="+other_facilitychart_yn+"&perio_arch="+perio_arch;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&tab_code=BC"+"&oh_chart_level="+oh_chart_level+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&q1_sno="+q1_sno+"&q2_sno="+q2_sno+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&cur_chart_num="+cur_chart_num+"&header_tab="+header_tab+"&show_new_active_yn="+show_new_active_yn+"&chart_hdr_insert_yn="+chart_hdr_insert_yn+"&insert_new_EC_yn="+insert_new_EC_yn+"&disable_record="+disable_record+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&oh_chart_level="+oh_chart_level;

	var url	= "../../eOH/jsp/PerioChartDataEntry.jsp?"+params;
	/* Parameters are to be changed to the size of the Dental Chart.Commented on 19/02/08 by Sridevi Joshi
	var dialogHeight= "25" ;
	var dialogWidth	= "45" ;
	var dialogTop ="125";
	var dialogLeft ="525";
	*/

	var dialogHeight= "50vh" ;
	var dialogWidth	= "55vw" ;
	var dialogTop ="170";
	var dialogLeft ="15";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
}

function localTrimString(sInString){
  return sInString.replace(/^\s+|\s+$/g,"");
}

/*
function checkMissingForCompletion(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var chart_code = formObj.perio_chart.value;
	var perio_tooth = formObj.perio_tooth.value;
	var header_tab = formObj.header_tab.value;
	//var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var missing_count = 0;
	var missing_tooth_no = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();

	var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&header_tab="+header_tab+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_tooth="+perio_tooth;
	//var params = "patient_id="+patient_id+"&chart_code="+chart_code+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&tooth_numbering_system="+tooth_numbering_system;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkMissingForCompletion&"+params,false);
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=checkForMissingTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length > 1){
		var retVal_arr = retVal.split("~");
		for(m=0;m<retVal_arr.length-1;m++){
			var code_desc_arr = retVal_arr[m].split("##");
			missing_count = code_desc_arr[0];
			
			if(missing_count == "1"){
				if(missing_tooth_no == ""){
					missing_tooth_no = code_desc_arr[1];
				}
				else{
					missing_tooth_no = missing_tooth_no+","+code_desc_arr[1];
				}
				//return true;
			}
			else{
				//return false;
			}
		}
		if(missing_tooth_no != ""){
			return missing_tooth_no;
		}
		else{
			return false;
		}
	}
	
	
}
*/
/*Added by Suma for CRF *0703 Starts here*/
function expandMenuOther(obj,img_name){
		buildTableOther(obj);
		switchMenuOther(obj,img_name);
}
function buildTableOther(obj)
{

	var formObj =document.forms[0];
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var locale = formObj.locale.value; 
	var condition_date;
	var condition_type;
	var index;
	var diagnosis_label=getLabel("Common.diagnosis.label","Common");
	var clinical_notes_label=getLabel("Common.ClinicalNotes.label","Common");
	var restorative_chart_label=getLabel("eOH.RestorativeChart.Label","OH");
 if(obj == "menuOTHER")
		{
		var tab_dat  = "<table id ='tooltiptable' cellpadding='3' cellspacing=0 border='0' width='100%' height='100%' align='center' >";
	 	tab_dat     += "<tr>";
		tab_dat     += '<td class="LABEL" COLSPAN=2><a  href=\"javascript:open_diagnosis();\"><div align="left">'+diagnosis_label+'</div></a></td>';
		tab_dat     += "</tr> ";
		tab_dat     += '<td class="LABEL" COLSPAN=2><a href=\"javascript:open_clinical_notes();\"><div align="left">'+clinical_notes_label+'</div></a></td>';
		tab_dat     += "</tr> ";
		tab_dat     += '<td class="LABEL" COLSPAN=2><a  href=\"javascript:open_restorative_chart();\"><div align="left">'+restorative_chart_label+'</div></a></td>';
		tab_dat     += "</tr> ";
		tab_dat     += "</table> ";
		}
	document.getElementById(obj).innerHTML = tab_dat;

}

function switchMenuOther(obj,img_name) {
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

async function open_diagnosis()
{

	var formObj = document.forms[0];  // changed by Yadav
	var params = formObj.params.value;
	var oh_chart_num = formObj.chart_num.value;
	var facility_id = formObj.facility_id.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = facility_id+"||"+encounter_id+"||"+oh_chart_num;
	var url = "../../eMR/jsp/RecDiagnosis.jsp?"+params+"&modal_yn=Y&accession_num="+accession_num+"&oh_chart_num="+oh_chart_num+"&called_from_OH=OH";
	var dialogHeight = "80vh" ; // changed by Yadav
	var dialogWidth  = "80vw" ; // changed by Yadav
	var dialogTop    = "30";
	var dialogLeft   = "30";   
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;

	await top.window.showModalDialog(url,null,features);

}
function open_clinical_notes()
{
	var formObj = document.forms[0]; // changed by Yadav
	var params = formObj.params.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = formObj.chart_num.value;
	var speciality_code = formObj.speciality_code.value;
	var location_code = formObj.location_code.value;

	var note_type= "";//formObj.note_type.value;
	var contr_mod_accession_num = "";//formObj.contr_mod_accession_num.value;
	var function_id="";
	var event_class="$PHY$";
	var window_close="Y";
	var hide_header="Y";
	var tab_yn="N";
	var HTML="";
	var query_flag_yn = "N";
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


	var features			= "channelmode=yes";
	 window.open(url,"CAWindow",features);
}
function open_restorative_chart()
{
	var title = getLabel("eOH.RestorativeChart.Label","OH");
	var formObj = document.forms[0]; // changed by Yadav a
	//var params = formObj.params.value;
	var oh_chart_num = formObj.chart_num.value;
	var facility_id = formObj.facility_id.value;
	var patient_id = formObj.patient_id.value;
	var episode_id = formObj.episode_id.value;
	var patient_class = formObj.patient_class.value;
	var encounter_id = formObj.encounter_id.value;
	var accession_num = formObj.chart_num.value;
	var speciality_code = formObj.speciality_code.value;
	var location_code = formObj.location_code.value;
	var location_type = formObj.location_type.value;
	var episode_type = formObj.episode_type.value;
	var locale = formObj.locale.value;
	var function_id="OTH_LINK";

   	var accession_num = facility_id+"||"+encounter_id+"||"+oh_chart_num;
	var chart_flag="R";
	var url = "../../eOH/jsp/OH.jsp?modal_yn=Y&accession_num="+accession_num+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&oh_chart_num="+oh_chart_num+"&chart_flag="+chart_flag+"&speciality_code="+speciality_code+"&location_code="+location_code+"&location_type="+location_type+"&episode_type="+episode_type+"&locale="+locale+"&encounter_id="+encounter_id+"&function_id="+function_id+"&called_from=CA"+"&title="+title;


	var features			= "channelmode=yes";
	 window.open(url,"CAWindow",features);
}



function setTimeForPerio(){

}
//Added by yadav for CRF492 on 1/21/2010
async function showPerioRemarks(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);
	var remarks_hid = document.forms[0].remarks.value;
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].chart_num.value
	var chart_id = document.forms[0].perio_chart.value
	var chart_line_num = document.forms[0].chart_line_num.value
	
	remarks = encodeURIComponent(remarks);

	title = encodeURIComponent(title);
	
	if(remarks == null || remarks == "null"){
		remarks = ""; 
	}

	var retVal = await window.showModalDialog("../../eOH/jsp/TextAreaRemarksHistory.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_id,window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");

	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
		showRemarkLink();
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

} 
//Added by yadav for CRF492 on 1/21/2010
async function showPerioRemarksHistory(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);
	var remarks_hid = document.forms[0].remarks.value;
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].chart_num.value
	var chart_id = document.forms[0].perio_chart.value
	var chart_line_num = document.forms[0].chart_line_num.value
	remarks = encodeURIComponent(remarks);

	title = encodeURIComponent(title);
	if(remarks == null || remarks == "null"){
		remarks = ""; 
	}
	var retVal =await window.showModalDialog("../../eOH/jsp/PerioRemarksHistory.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_id,window,"dialogHeight: 50vh; dialogWidth:65vw; center: yes; help: no; resizable: no; status: no;");
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

} 
//Added by yadav for CRF492 on 1/21/2010
function delayRemarkLinkLoadTime(){
	var patient_id = document.getElementById("patient_id").value
	var chart_num = document.getElementById("chart_num").value
	var chart_id = document.getElementById("perio_chart").value
	var chart_line_num = document.getElementById("chart_line_num").value
	var languageId=document.getElementById("languageId").value
	var encounter_id=document.getElementById("encounter_id").value
	var patient_class=document.getElementById("patient_class").value
	var chart_code=document.getElementById("chart_code").value

	//var count=0;//commented by parul on 28/04/2010 for PE declared as global var
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkLink&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>0){
			count = retVal;
		}
		//added by parul on 03/05/2010 for IN021073	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePeriodontalSummary&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_summary = trimString(xmlHttp.responseText);
		

	//var remarks=getLabel("Common.remarks.label","common_labels");
	if(parseInt(count)==0){	
		document.getElementById("disableId").style.display='inline';
		document.getElementById("enableId").style.display='none';
		
	}else{
		document.getElementById("enableId").style.display='inline';
		document.getElementById("disableId").style.display='none';
	}
	if(retVal_summary==0){	
		document.getElementById("disablePerioLink").style.display='inline';
		document.getElementById("enablePerioLink").style.display='none';
	}else{
		document.getElementById("enablePerioLink").style.display='inline';
		document.getElementById("disablePerioLink").style.display='none';
	}
	showRemarkLink(retVal_summary);
}

function showRemarkLink(retVal_summary){
//	alert(retVal_summary)
	var patient_id = document.getElementById("patient_id").value
	var chart_num = document.getElementById("chart_num").value
	var chart_id = document.getElementById("perio_chart").value
	var chart_line_num = document.getElementById("chart_line_num").value
	var languageId=document.getElementById("languageId").value
	
	// for Remark History

	var remark="";
	if(parseInt(count_rmt)==0){
		var xmlDoc1 = "";
		var xmlHttp1 = new XMLHttpRequest();var params1 = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
		var xmlStr1 ="<root><SEARCH ";
		xmlStr1 +=" /></root>";
		xmlDoc1.loadXML(xmlStr1);
		xmlHttp1.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkHistoryLink&"+params1,false);
		xmlHttp1.send(xmlDoc1);
		var retVal1 = trimString(xmlHttp1.responseText);
		if(retVal1.length>0){
			count_rmt = retVal1;
		}
	}
	//var RemarksHistory=getLabel("eOH.RemarksHistory.Label","OH");
	//if(parseInt(retVal1.length)==0){//commented by parul on 28/04/2010 for PE declared  global var	count_rmt ,showRemarkHistoryLink query should run only on clk of "RemarksHistory" link
	if(parseInt(count_rmt)==0){	
		document.getElementById("disableHistId").style.display='inline';
		document.getElementById("enableHistId").style.display='none';
	}else{
		document.getElementById("enableHistId").style.display='inline';
		document.getElementById("disableHistId").style.display='none';
	}

	if(retVal_summary==0){	
		document.getElementById("disablePerioLink").style.display='inline';
		document.getElementById("enablePerioLink").style.display='none';
	}else{
		document.getElementById("enablePerioLink").style.display='inline';
		document.getElementById("disablePerioLink").style.display='none';
	}
}

function delayEvalRemarkLinkLoadTime(){
	   //setTimeout("showEvalRemarkLink()",300);
	   //var count=0;//commented by parul on 28/04/2010 for PE declared as global var
	var patient_id = document.getElementById("patient_id").value
	var chart_num = document.getElementById("chart_num").value
	var chart_id = document.getElementById("perio_chart").value
	var chart_line_num = document.getElementById("chart_line_num").value
	var languageId=document.getElementById("languageId").value
	var chart_code=document.getElementById("chart_code").value
	//if (count==0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkLink&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		
		if(retVal.length>0){
			count = retVal;
		}

	//var remarks=getLabel("Common.remarks.label","common_labels");
	//added by parul on 03/05/2010 for IN021073	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePeriodontalSummary&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_summary = trimString(xmlHttp.responseText);

	if(parseInt(count)==0){	
		document.getElementById("disableId").style.display='inline';
		document.getElementById("enableId").style.display='none';
	}else{
		document.getElementById("enableId").style.display='inline';
		document.getElementById("disableId").style.display='none';
	}

	if(retVal_summary==0){	//added by parul on 03/05/2010 for IN021073	
		document.getElementById("disablePerioLink").style.display='inline';
		document.getElementById("enablePerioLink").style.display='none';
	}else{
		document.getElementById("enablePerioLink").style.display='inline';
		document.getElementById("disablePerioLink").style.display='none';
	}

	   showEvalRemarkLink();
}

function showEvalRemarkLink(){
	var patient_id = document.getElementById("patient_id").value
	var chart_num = document.getElementById("chart_num").value
	var chart_id = document.getElementById("perio_chart").value
	var chart_line_num = document.getElementById("chart_line_num").value
	var languageId=document.getElementById("languageId").value
	
	// for Remark History Link
	if(parseInt(count_rmt)==0){
		var xmlDoc1 = "";
		var xmlHttp1 = new XMLHttpRequest();var params1 = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
		var xmlStr1 ="<root><SEARCH ";
		xmlStr1 +=" /></root>";
		xmlDoc1.loadXML(xmlStr1);
		xmlHttp1.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkHistoryLink&"+params1,false);
		xmlHttp1.send(xmlDoc1);
		var retVal1 = trimString(xmlHttp1.responseText);
		if(retVal1.length>0){
			count_rmt = retVal1;
		}
	}
//if(parseInt(retVal1.length)==0){//commented by parul on 28/04/2010 for PE declared  global var	count_rmt ,showRemarkHistoryLink query should run only on clk of "RemarksHistory" link
	if(parseInt(count_rmt)==0){	
		document.getElementById("disableHistId").style.display='inline';
		document.getElementById("enableHistId").style.display='none';
	}else{
		document.getElementById("enableHistId").style.display='inline';
		document.getElementById("disableHistId").style.display='none';
	}

}

//Added by yadav for CRF492 on 1/21/2010
async function showEvalPerioRemarks(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);
	var remarks_hid = document.forms[0].remarks.value;
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].chart_num.value
	var chart_id = document.forms[0].perio_chart.value
	var chart_line_num = document.forms[0].chart_line_num.value
	remarks = encodeURIComponent(remarks);

	title = encodeURIComponent(title);
	
	if(remarks == null || remarks == "null"){
		remarks = ""; 
	}

	var retVal = await window.showModalDialog("../../eOH/jsp/TextAreaRemarksHistory.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_id,window,"dialogHeight: 50vh; dialogWidth:55vw; center: yes; help: no; resizable: no; status: no;");
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

} 
//Added by yadav for CRF492 on 1/21/2010
async function showEvalPerioRemarksHistory(title,locale){
	var readOnlyYN = "N";
	var remarks = document.forms[0].remarks.value;
	remarks = encodeURIComponent(remarks);
	var remarks_hid = document.forms[0].remarks.value;
	var patient_id = document.forms[0].patient_id.value
	var chart_num = document.forms[0].chart_num.value
	var chart_id = document.forms[0].perio_chart.value
	var chart_line_num = document.forms[0].chart_line_num.value
	remarks = encodeURIComponent(remarks);

	title = encodeURIComponent(title);
	
	if(remarks == null || remarks == "null"){
		remarks = ""; 
	}
	var retVal = await window.showModalDialog("../../eOH/jsp/PerioRemarksHistory.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&chart_code="+chart_id,window,"dialogHeight: 50vh; dialogWidth:55vw; center: yes; help: no; resizable: no; status: no;");
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].remarks.value = remarks_hid;
	}
	else{
		document.forms[0].remarks.value = retVal;
	}

} 
function showOnAddRemarkLink(){
	var obj=parent.parent.document.frames[1].document.forms[0];
	var patient_id = obj.patient_id.value
	var chart_num = obj.chart_num.value
	var chart_id =  obj.perio_chart.value
	var chart_line_num =  obj.chart_line_num.value
	var languageId= obj.languageId.value
	var chart_code= obj.chart_code.value
	//var count=0;//commented by parul on 28/04/2010 for PE declared as global var
	if (count==0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkLink&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length>0){
			count = retVal;
		//}

		}
	}
	//added by parul on 03/05/2010 for IN021073
	if (count_summary==0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePeriodontalSummary&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_summary = trimString(xmlHttp.responseText);
	}

	if (retVal_summary==1){
			count_summary++;
	}

	var remarks=getLabel("Common.remarks.label","common_labels");

	if(parseInt(count)==0){	
		 obj.all.disableId.style.display='inline';
		 obj.all.enableId.style.display='none';
	}else{
		 obj.all.enableId.style.display='inline';
		 obj.all.disableId.style.display='none';
	}

	if(retVal_summary==0){	
		obj.all.disablePerioLink.style.display='inline';
		obj.all.enablePerioLink.style.display='none';
	}else{
		obj.all.enablePerioLink.style.display='inline';
		obj.all.disablePerioLink.style.display='none';
	}
	// for Remark History
	//commented by parul on 28/04/2010 for PE (this blk should be called only when we are entering remarks)

	//var remark="";
	/*var xmlDoc1 = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp1 = new ActiveXObject( "Microsoft.XMLHTTP" );
	var params1 = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var xmlStr1 ="<root><SEARCH ";
	xmlStr1 +=" /></root>";
	xmlDoc1.loadXML(xmlStr1);
	xmlHttp1.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkHistoryLink&"+params1,false);
	xmlHttp1.send(xmlDoc1);
	var retVal1 = trimString(xmlHttp1.responseText);

	var RemarksHistory=getLabel("eOH.RemarksHistory.Label","OH");
	if(parseInt(retVal1.length)==0)	{	
		 obj.all.disableHistId.style.display='inline';
		 obj.all.enableHistId.style.display='none';
		}
		else{
		 obj.all.enableHistId.style.display='inline';
		 obj.all.disableHistId.style.display='none';
		}
	*/
}
function showOnAddEvalRemarkLink(){
	var obj=parent.parent.document.frames[1].document.forms[0];
	var patient_id = obj.patient_id.value
	var chart_num = obj.chart_num.value
	var chart_id =  obj.perio_chart.value
	var chart_line_num =  obj.chart_line_num.value
	var languageId= obj.languageId.value
	var chart_code= obj.chart_code.value
	//var count=0;//commented by parul on 28/04/2010 for PE declared as global var
	if (count==0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkLink&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		
		if(retVal.length>0){
			count = retVal;
		}
	}
	if (count_ECsummary==0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_code="+chart_code+"&chart_line_num="+chart_line_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCommonValidation.jsp?func_mode=populatePeriodontalSummary&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal_summary = trimString(xmlHttp.responseText);
	}
	if (retVal_summary==1){
			count_ECsummary++;
	}
	var remarks=getLabel("Common.remarks.label","common_labels");

	if(parseInt(count)==0){	
		obj.all.disableId.style.display='inline';
		obj.all.enableId.style.display='none';
	}else{
		obj.all.enableId.style.display='inline';
		obj.all.disableId.style.display='none';
	}
	if(retVal_summary==0){	
		obj.all.disablePerioLink.style.display='inline';
		obj.all.enablePerioLink.style.display='none';
	}else{
		obj.all.enablePerioLink.style.display='inline';
		obj.all.disablePerioLink.style.display='none';
	}

	// for Remark History Link
	//commented by parul on 28/04/2010 for PE (this blk should be called only when we are entering remarks)
/*	var xmlDoc1 = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp1 = new ActiveXObject( "Microsoft.XMLHTTP" );
	var params1 = "patient_id="+patient_id+"&perio_chart="+chart_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var xmlStr1 ="<root><SEARCH ";
	xmlStr1 +=" /></root>";
	xmlDoc1.loadXML(xmlStr1);
	xmlHttp1.open("POST","PerioCommonValidation.jsp?func_mode=showRemarkHistoryLink&"+params1,false);
	xmlHttp1.send(xmlDoc1);
	var retVal1 = trimString(xmlHttp1.responseText);
	if(parseInt(retVal1.length)==0)
		{	
		obj.all.disableHistId.style.display='inline';
		obj.all.enableHistId.style.display='none';
		}
		else
		{
		obj.all.enableHistId.style.display='inline';
		obj.all.disableHistId.style.display='none';
		}
*/
}

