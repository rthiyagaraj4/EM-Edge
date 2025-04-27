function printOverview(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
//	var trmt_code = formObj.oh_treatment.value;
//	var order_id = formObj.order_id.value;
//	var order_line_num = formObj.order_line_num.value;

	var DentalChartFormObj = parent.trmtDentalChartDetails.document.forms[0];
	var header_tab = DentalChartFormObj.header_tab.value;
	var tooth_numbering_system = DentalChartFormObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = DentalChartFormObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = DentalChartFormObj.mixed_dentition_YN.value;
	var upper_arch_desc = DentalChartFormObj.upper_arch_desc.value;
	var lower_arch_desc = DentalChartFormObj.lower_arch_desc.value;
	var Q1_id = DentalChartFormObj.Q1_id.value;
	var Q2_id = DentalChartFormObj.Q2_id.value;		   
	var Q3_id = DentalChartFormObj.Q3_id.value;
	var Q4_id = DentalChartFormObj.Q4_id.value;
	var Q1_desc = DentalChartFormObj.Q1_desc.value;
	var Q2_desc = DentalChartFormObj.Q2_desc.value;				 
	var Q3_desc = DentalChartFormObj.Q3_desc.value;
	var Q4_desc = DentalChartFormObj.Q4_desc.value;

	var qry_string = "patient_id="+patient_id+"&header_tab="+header_tab+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN+"&upper_arch_desc="+upper_arch_desc+"&lower_arch_desc="+lower_arch_desc+"&Q1_id="+Q1_id+"&Q2_id="+Q2_id+"&Q3_id="+Q3_id+"&Q4_id="+Q4_id+"&Q1_desc="+Q1_desc+"&Q2_desc="+Q2_desc+"&Q3_desc="+Q3_desc+"&Q4_desc="+Q4_desc+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num;
	var url	= "../../eOH/jsp/PrintChart.jsp?"+qry_string;

	//var testwindow= window.open (url, "WindowTitle","location=0,status=0,scrollbars=2,width=800,height=450");

	var testwindow= window.open (url, "WindowTitle","location=0,status=0,scrollbars=4,width=880,height=670");

	//testwindow.moveTo(95,100);

}  


function getImageForHistoryDummy(){
	var formObj = document.forms[0];
	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var root_count = 0;
	var crown_count = 0;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	var asOnDatePrint = formObj.asOnDatePrint.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var baseline_chart_yn = formObj.baseline_chart_yn.value;
	var as_on_date_chart_num = formObj.as_on_date_chart_num.value;
	//var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = "C";//formObj.header_tab.value;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag=T"+"&baseline_chart_yn="+baseline_chart_yn+"&asOnDatePrint="+asOnDatePrint+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&as_on_date_chart_num="+as_on_date_chart_num;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/PrintChartValidation.jsp?func_mode=getAllImagesForHistoryForPrint&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
	
}  

/*function getStaticImageForHistoryDummy(){
	var formObj = document.forms[0];

	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var crownLineDisplayParams = new Array();
	var imageReplaceDisplayParams = new Array();
	var root_count = 0;
	var crown_count = 0;
	var image_replace_count = 0;

	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	var k = 0;
	var m = 0;
	//var l = 0;
	

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	
	//var xmlDoc = "" ;
	//var xmlHttp = new XMLHttpRequest();
	//var treatment_condition_tab_flag = "T";//formObj.header_tab.value;
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	//var xmlStr ="<root><SEARCH ";
	//xmlStr +=" /></root>";
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	//xmlHttp.send(xmlDoc);
	//var retVal = trimString(xmlHttp.responseText); 
	
	//var retVal = formObj.applyTrmts.value;
	var retVal = getImageForHistoryDummy();

	//retVal = "../../eOH/images/Trauma.gif##3##TOOTH##16##TRUMTH##C##null##N##null~../../eOH/images/Extraction-CrownGreen.gif##5##TOOTH##14##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##11##TOOTH##23##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##13##TOOTH##25##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##25##TOOTH##41##EXTRACT##T##60##N##N~";
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		var show_RTDESTH_EXFOLTH_image_flag="";
		var show_SUPRTH_EXFOLTH_image_flag="";
		var image_count=0;
		for(i=retVal_arr.length-2;i>=0;i--){
			
			code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[4]=="RTDESTH"){ 
					show_RTDESTH_EXFOLTH_image_flag=code_desc_arr[1]+"RTDESTH";
				}else if(code_desc_arr[4]=="EXFOLTH" && show_RTDESTH_EXFOLTH_image_flag!=""){
					show_RTDESTH_EXFOLTH_image_flag=show_RTDESTH_EXFOLTH_image_flag+"EXFOLTH";
				}

				if(code_desc_arr[2] == "TOOTH"){ // Initialuze the flag
					if(show_RTDESTH_EXFOLTH_image_flag.indexOf(code_desc_arr[1]+"RTDESTH")<0){ // Initialuze the flag
						show_RTDESTH_EXFOLTH_image_flag="";
					}
				}
						
				if((code_desc_arr[0]!=null && code_desc_arr[0]!="null") || (code_desc_arr[4] == "TOOTHTM" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "EXTRACT"  || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "PERIINV" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DENTURE")){// image_id will be null for ROOT and CROWN site_types
					var imageId = "";
					var site_type = code_desc_arr[2];
					
					if(site_type == "QUAD"){
						imageId = "Q"+code_desc_arr[1];
					}
					else if(site_type == "ARCH"){
						imageId = "A"+code_desc_arr[1];
					}
					else{
						imageId = code_desc_arr[1];
					}
					status_int = parseInt(code_desc_arr[6]);

					if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ //This is to get the status from OR table with respect to the status is stored in the chart_dtl table..
						var fill_color = "YELLOW";
					}
					else{
						var fill_color = "LIGHTGREEN";
					}
					if(site_type == "ARCH" || site_type == "QUAD" ){

						if(code_desc_arr[4] == "TOOTHTM"){
							if(code_desc_arr[7] != "null"&& code_desc_arr[7] != null){ //code_desc_arr[7]: This is to get the status which is stored in the chart_dtl table..
								if(site_type == "ARCH"){
									var imageId = "COLORA"+code_desc_arr[1];
								}else if(site_type == "QUAD"){
									var imageId = "COLORQ"+code_desc_arr[1];
								}
								document.getElementById(imageId).style.backgroundColor = fill_color;
						   }
						}
						else{
							var ind = concat.indexOf(":");
							if(ind != -1){
								concat_val = concat.split(":");
								for(;j<concat_val.length-1;j++){
									if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
										image_count++;
										status_int = parseInt(code_desc_arr[6]);
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_arch_quad;
											
										if(image_count >= 4){
											var imgDisplay_arch_quad_arr = imgDisplay_arch_quad.split("<img");
											var imgDisplay_arch_quad_temp = "";
										
											for(k=1;k<=3;k++){
												imgDisplay_arch_quad_temp = imgDisplay_arch_quad_temp+"<img"+imgDisplay_arch_quad_arr[k];
											}
											imgDisplay_arch_quad = imgDisplay_arch_quad_temp + "...";
												
										}
										document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
										break;
									}
									else{ // For every next set of area
										image_count=1;
										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
										document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
									}
								}
							}
							else{
								image_count=1;
								concat = code_desc_arr[1] + ":" ;
								imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
								document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
							}
						}
					}
					else if(site_type == "TOOTH" || site_type == "THRNG" || (site_type == "ROOT" && code_desc_arr[4]=="PERIINV")){
						if(code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "UNERTH" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "EXTRACT" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "PARERTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "IMPACTN" || code_desc_arr[4] == "BRIDGE" || code_desc_arr[4] == "DENTURE"){ //29FEB bshankar

							/*image_replace_count = parseInt(image_replace_count);
							image_replace_count++; 
							imageReplaceForHistory(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[8],code_desc_arr[9]);
							//imageReplaceDisplayParams[image_replace_count] = code_desc_arr[4]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+show_RTDESTH_EXFOLTH_image_flag+"##"+show_SUPRTH_EXFOLTH_image_flag+"##"+code_desc_arr[8]+"##"+code_desc_arr[9];
							
							//crown_count = parseInt(crown_count);	
							/*crownLineDisplayParams = "";
							crown_count = 0;

							//rootLineDisplayParams[root_count] = "";
							rootLineDisplayParams = "";
							root_count = 0;	  

							
						}
						if(site_type == "ROOT" && code_desc_arr[4]=="PERIINV"){
							drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						}
						else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE" && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[8] == "N"){

							var ind = concat.indexOf(":");
							if(ind != -1){
								concat_val = concat.split(":");
								for(;j<concat_val.length-1;j++){
									if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
										image_count++;
										status_int = parseInt(code_desc_arr[6]);
											if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
												code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
											}
											imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
											
											if(image_count >= 4){
												var imgDisplay_tooth_thrng_arr = imgDisplay_tooth_thrng.split("<img");
												var imgDisplay_tooth_thrng_temp = "";
												
												for(k=1;k<=3;k++){
													imgDisplay_tooth_thrng_temp = imgDisplay_tooth_thrng_temp+"<img"+imgDisplay_tooth_thrng_arr[k];
												}
												imgDisplay_tooth_thrng = imgDisplay_tooth_thrng_temp + "...";
												
											}
											document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
										
										break;

									}
									else{ // For every next set of area
										status_int = parseInt(code_desc_arr[6]);

										if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
										}
										image_count=1;
										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";
										
										document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >"+imgDisplay_tooth_thrng+"</td></tr></table>";
									}
								}
							}
							else{
								image_count=1;
								concat = code_desc_arr[1] + ":" ;
								status_int = parseInt(code_desc_arr[6]);

								if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
									code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
								}
								imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />";
								document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
							}	
						}
					}
					/*else if(site_type == "CROWN"){
						crown_count = parseInt(crown_count);
						crown_count++; 
						/*var ind_crown = crown_concat.indexOf(":");
						//crown_count = parseInt(crown_count);
						//crown_count++; 	

						if(ind_crown != -1){
							concat_val = crown_concat.split(":");
							concat_cond_val = concat_cond_type.split(":");
							
							for(m=0;m<concat_val.length-1;m++){
								if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
									if(code_desc_arr[10] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
										cond_type = "PULPINV";
									}
									else{
										cond_type = code_desc_arr[4];
									}
									//crownLineDisplayParams[crown_count] = "toothLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[6]+"##"+code_desc_arr[1]+"##"+permanent_deciduous_flag;
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);
								}
								else{
									crown_concat = crown_concat + code_desc_arr[1] + ":"  ;
									concat_cond_type = concat_cond_type + code_desc_arr[4] + ":"  ;
									
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
									//crownLineDisplayParams[crown_count] = "toothLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[6]+"##"+code_desc_arr[1]+"##"+permanent_deciduous_flag;
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);
								}
							}
						}
						else{
							crown_concat = code_desc_arr[1] + ":"  ;
							concat_cond_type = code_desc_arr[4] + ":"  ;
							fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
							//crownLineDisplayParams[crown_count] = "toothLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[6]+"##"+code_desc_arr[1]+"##"+permanent_deciduous_flag;
							drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);
						}  
						fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);  
						//crownLineDisplayParams[crown_count] = "toothLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[6]+"##"+code_desc_arr[1]+"##"+permanent_deciduous_flag;
						//drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);
					//}
					
					else if(site_type == "CROWN"){
						var ind_crown = crown_concat.indexOf(":");
						if(ind_crown != -1){
							concat_val = crown_concat.split(":");
							concat_cond_val = concat_cond_type.split(":");
							for(;m<concat_val.length-1;m++){
								if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
									if(code_desc_arr[3] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
										cond_type = "PULPINV";
									}
									else{
										cond_type = code_desc_arr[4];
									}
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by	 parul for crf 0483 on 25/08/2009

									break;//Added by sridevi on 11/11/08 as it was going in to loop multiple times.
								}
								else{
									crown_concat = crown_concat + code_desc_arr[0] + ":"  ;
									concat_cond_type = concat_cond_type + code_desc_arr[4] + ":" ;
										fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
									 drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by	 parul for crf 0483 on 25/08/2009

								}
							}
						}
						else{
							crown_concat = code_desc_arr[0] + ":"  ;
							concat_cond_type = code_desc_arr[4] + ":"  ;
							fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
								 drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by parul for crf 0483 on 25/08/2009						
						}
					}
					else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						
						/*root_count = parseInt(root_count);
						root_count++;
						
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];	
						root_count = parseInt(root_count);
						root_count++;
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.
							var xmlDoc = "" ;  
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal = localTrimString(retVal); //chart_line_num of ERUPTH
							
							if(retVal < code_desc_arr[10]){
								rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
							}
						}else{
								rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						}

					}
				}
				else{
					var site_type = code_desc_arr[2];
					if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						root_count = parseInt(root_count);
						root_count++;
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.
						var xmlDoc = "" ;  
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal = localTrimString(retVal); //chart_line_num of ERUPTH
						
						if(parseInt(retVal) < parseInt(code_desc_arr[10])){
							rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						}
					}else{
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
					}
				}	


				}
		}
		if(root_count >0){	
			for(j=1;j<=root_count;j++){	
				if(rootLineDisplayParams[j] != undefined && rootLineDisplayParams[j] != "undefined" && rootLineDisplayParams[j] != "" && rootLineDisplayParams[j] != "null" && rootLineDisplayParams[j] != null){
					var params_arr = rootLineDisplayParams[j].split("##");
					drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);
				}
			}	
		}
		/*if(crown_count >0){	
			for(k=1;k<=crown_count;k++){
				if(crownLineDisplayParams[k] != undefined && crownLineDisplayParams[k] != "undefined" && crownLineDisplayParams[k] != "" && crownLineDisplayParams[k] != "null" && crownLineDisplayParams[k] != null){
					var params_arr = crownLineDisplayParams[k].split("##");
					fillCrownImagesForHistory(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);

				}
			}	
		} */
		/*if(image_replace_count > 0){	
			for(l=1;l<=image_replace_count;l++){
				if(imageReplaceDisplayParams[l] != undefined && imageReplaceDisplayParams[l] != "undefined" && imageReplaceDisplayParams[l] != "" && imageReplaceDisplayParams[l] != "null" && imageReplaceDisplayParams[l] != null){
					var params_arr = imageReplaceDisplayParams[l].split("##");
					imageReplaceForHistory(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);
				}
			}	
		}  
	}
	return retVal;
} */

function getStaticImageForHistoryDummy(){
	var formObj = document.forms[0];

	var imgDisplay_arch_quad = "";
	var imgDisplay_tooth_thrng = "";
	var crown_concat = ""; // Crown
	var concat = ""; //For Tooth_Range, Tooth
	var concat_val = "";
	var code_desc_arr;
	var concat_cond_val = "";
	var concat_cond_type = "";
	var cond_type = "";
	var rootLineDisplayParams = new Array();
	var crownLineDisplayParams = new Array();
	var imageReplaceDisplayParams = new Array();
	var root_count = 0;
	var crown_count = 0;
	var image_replace_count = 0;

	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	var k = 0;
	var m = 0;
	//var l = 0;
	

	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;

	
	//var xmlDoc = "" ;
	//var xmlHttp = new XMLHttpRequest();
	//var treatment_condition_tab_flag = "T";//formObj.header_tab.value;
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	//var xmlStr ="<root><SEARCH ";
	//xmlStr +=" /></root>";
	//xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	//xmlHttp.send(xmlDoc);
	//var retVal = trimString(xmlHttp.responseText); 
	
	//var retVal = formObj.applyTrmts.value;
	var retVal = getImageForHistoryDummy();
	//retVal = "../../eOH/images/Trauma.gif##3##TOOTH##16##TRUMTH##C##null##N##null~../../eOH/images/Extraction-CrownGreen.gif##5##TOOTH##14##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##11##TOOTH##23##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##13##TOOTH##25##EXTRACT##T##60##N##N~../../eOH/images/Extraction-CrownGreen.gif##25##TOOTH##41##EXTRACT##T##60##N##N~";
	if(retVal.length>1){	
	 var retVal_arr = retVal.split("~");
		var show_RTDESTH_EXFOLTH_image_flag="";
		var show_SUPRTH_EXFOLTH_image_flag="";
		var image_count=0;
		for(i=retVal_arr.length-2;i>=0;i--){
			code_desc_arr = retVal_arr[i].split("##");
			
			if(code_desc_arr[4]=="RTDESTH"){ 
				// bshankar/FEB2008 done for Displaying the root/crown images when EXFOLTH is recorded for the 1st time after recording the RTDESTH.
				show_RTDESTH_EXFOLTH_image_flag=code_desc_arr[1]+"RTDESTH";
			}else if(code_desc_arr[4]=="EXFOLTH" && show_RTDESTH_EXFOLTH_image_flag!=""){
				// bshankar/FEB2008 done for Displaying the root/crown images when EXFOLTH is recorded for the 1st time after recording the RTDESTH.
				show_RTDESTH_EXFOLTH_image_flag=show_RTDESTH_EXFOLTH_image_flag+"EXFOLTH";
			}

			if(code_desc_arr[2] == "TOOTH"){ // Initialuze the flag
				if(show_RTDESTH_EXFOLTH_image_flag.indexOf(code_desc_arr[1]+"RTDESTH")<0){ // Initialuze the flag
					show_RTDESTH_EXFOLTH_image_flag="";
				}
			}
			var imageId = "";
			var site_type = code_desc_arr[2];
			 
			if(site_type == "QUAD"){
				imageId = "Q"+code_desc_arr[1];
				classId = "QUADRANT";
			}
			else if(site_type == "ARCH"){
				imageId = "A"+code_desc_arr[1];
				classId = "ARCH";
			}
			else{
				imageId = code_desc_arr[1];
			}
			if((code_desc_arr[0]!=null && code_desc_arr[0]!="null") || (code_desc_arr[4] == "TOOTHTM" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "EXTRACT"  || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "PERIINV" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DENTURE" ||  code_desc_arr[4] =="ORTHO" ||  code_desc_arr[4] =="DECITH" ||(code_desc_arr[4] == "CROWN" && code_desc_arr[10] == "*A"))){// image_id will be null for ROOT and CROWN site_types
				status_int = parseInt(code_desc_arr[6]);

				if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ //This is to get the status from OR table with respect to the status is stored in the chart_dtl table..
					var fill_color = "YELLOW";
				}
				else{
					var fill_color = "LIGHTGREEN";
				}
				if(site_type == "ARCH" || site_type == "QUAD" ){
					if(code_desc_arr[4] == "TOOTHTM"){
						if(code_desc_arr[7] != "null"&& code_desc_arr[7] != null){ //code_desc_arr[7]: This is to get the status which is stored in the chart_dtl table..
							if(site_type == "ARCH"){
								var imageId = "COLORA"+code_desc_arr[1];
							}else if(site_type == "QUAD"){
								var imageId = "COLORQ"+code_desc_arr[1];
							}
							document.getElementById(imageId).style.backgroundColor = fill_color;
						}
					}
					else{
						var ind = concat.indexOf(":");
						if(ind != -1){
							concat_val = concat.split(":");
							for(;j<concat_val.length-1;j++){
								if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
									image_count++;
									//Commented by Sharon Crasta on 11/24/2008 for SCR #6755
									//imgDisplay_arch_quad = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" />" + imgDisplay_arch_quad;
									
									//imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  /> " + imgDisplay_arch_quad;
									//imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_arch_quad;

										  if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){
										  if(code_desc_arr[15]=="E"){
											if (code_desc_arr[4] == "DENTURE"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalTool.gif />" + imgDisplay_arch_quad;
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalFailTool.gif />" + imgDisplay_arch_quad;
												}
											}else if (code_desc_arr[4] == "ORTHO"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternaTool.gif />" + imgDisplay_arch_quad;
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternalFailTool.gif />" + imgDisplay_arch_quad;
												}
											}
										
										}else{
											
											if(code_desc_arr[15]=="I"){
												if (code_desc_arr[4] == "DENTURE"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img  src=../../eOH/images/Denture_indicator.gif />" + imgDisplay_arch_quad;
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img  src=../../eOH/images/DentureFailTool.gif />" + imgDisplay_arch_quad;
													}
												}else if (code_desc_arr[4] == "ORTHO"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho.gif />" + imgDisplay_arch_quad;
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho_F.gif />" + imgDisplay_arch_quad;
													}
												}
											}
										}

									  }else{
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_arch_quad;
									  }
																											
									if(image_count >= 4){
										var imgDisplay_arch_quad_arr = imgDisplay_arch_quad.split("<img");
										var imgDisplay_arch_quad_temp = "";
										for(k=1;k<=3;k++){
											imgDisplay_arch_quad_temp = imgDisplay_arch_quad_temp+"<img"+imgDisplay_arch_quad_arr[k];
										}
										imgDisplay_arch_quad = imgDisplay_arch_quad_temp + "..."
									}

									//Commented by Sharon Crasta on 11/24/2008 for SCR #6755
									document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;						
									// document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
									// document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";

									break;
								}
								else{ // // For every next set of area
									image_count=1;
									concat = concat + code_desc_arr[1] + ":"  ;
									 
									//Commented by Sharon Crasta on 11/24/2008 for SCR #6755
									/*	imgDisplay_arch_quad = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" />";
									document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;	   */
								 
									//imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />";
									//document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
									  if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){
										  if(code_desc_arr[15]=="E"){
											if (code_desc_arr[4] == "DENTURE"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalTool.gif />";
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalFailTool.gif />";
												}
											}else if (code_desc_arr[4] == "ORTHO"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternaTool.gif />";
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternalFailTool.gif />";
												}
											}
										
										}else{
											
											if(code_desc_arr[15]=="I"){
												if (code_desc_arr[4] == "DENTURE"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img  src=../../eOH/images/Denture_indicator.gif />";
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img  src=../../eOH/images/DentureFailTool.gif />";
													}
												}else if (code_desc_arr[4] == "ORTHO"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho.gif />";
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho_F.gif />";
													}
												}
											}
										}

									  }else{
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
									  }
										document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
								}
							}
						}
						else{
							image_count=1;
							concat = code_desc_arr[1] + ":" ;
						
							//Commented by Sharon Crasta on 11/24/2008	for SCR #6755
							/*	imgDisplay_arch_quad = "<img alt='"+alt_text+"' style='cursor:pointer'   src='"+code_desc_arr[0]+"' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" />";
							document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;	*/
						  
							//imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />";

							//document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";

							//imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";

								  if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){
									
										  if(code_desc_arr[15]=="E"){
											if (code_desc_arr[4] == "DENTURE"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalTool.gif />";
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalFailTool.gif />";
												}
											}else if (code_desc_arr[4] == "ORTHO"){
												if (code_desc_arr[13]!="F"){
													imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternaTool.gif />";
												}else if (code_desc_arr[13]=="F"){
													 imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternalFailTool.gif />";
												}
											}
										
										}else{
											
											if(code_desc_arr[15]=="I"){
												
												if (code_desc_arr[4] == "DENTURE"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img  src=../../eOH/images/Denture_indicator.gif />";
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img  src=../../eOH/images/DentureFailTool.gif />";
													}
												}else if (code_desc_arr[4] == "ORTHO"){
													if (code_desc_arr[13]!="F"){
														imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho.gif />";
													}else if (code_desc_arr[13]=="F"){
														 imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho_F.gif />";
													}
												}
											}
										}

									  }else{
										imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
									  }


							document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;
						}
					}
				}
				else if(site_type == "TOOTH" || site_type == "THRNG" || (site_type == "ROOT" && code_desc_arr[4]=="PERIINV") || (code_desc_arr[2]=="CROWN" && code_desc_arr[10]=="*A")){
					if(code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "UNERTH" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "EXTRACT" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "PARERTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "IMPACTN" || code_desc_arr[4] == "BRIDGE" || code_desc_arr[4] == "DENTURE" ||(code_desc_arr[4] == "CROWN" && code_desc_arr[10] == "*A") ){ //29FEB bshankar				
					//imageReplacementForCond(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8]);
						imageReplaceForHistoryForPrint(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[8],code_desc_arr[9],code_desc_arr[10],code_desc_arr[11],code_desc_arr[13],code_desc_arr[14],code_desc_arr[15]);



						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						  	var xmlDoc = "" ;  
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","../../eOH/jsp/PrintChartValidation.jsp?func_mode=getExfoliationCase&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal_chart_line_num = localTrimString(retVal); //chart_line_num of EXFOLTH
							if(code_desc_arr[4] == "EXFOLTH" && retVal_chart_line_num > 1){
								var xmlDoc = "" ;  
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&chart_line_num="+retVal_chart_line_num;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","../../eOH/jsp/PrintChartValidation.jsp?func_mode=getConditions&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal_conditions = localTrimString(retVal); 
								if(retVal_conditions.length > 1){
									var retVal_conditions_arr = retVal_conditions.split("~");
									for(n=0;n < retVal_conditions_arr.length-1;n++){
										var retVal_arr1 = retVal_conditions_arr[n].split("##");
										//condition_type+"##"+chart_line_num+"##"+site_type+"##"+supernumerary_yn+"##"+mixed_dent_deciduous_yn+"##"+surface_code+"##"+treatment_condition+"##"+status
										
										if(retVal_arr1[2] == "ROOT" && retVal_arr1[0]=="PERIINV"){
											drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],code_desc_arr[13]);
										}
										if(retVal_arr1[2] == "ROOT" && retVal_arr1[0]!="PERIINV"){
											drawLineForRootImage('rootLayer'+code_desc_arr[1],retVal_arr1[5],formObj,retVal_arr1[0],retVal_arr1[6],code_desc_arr[1],retVal_arr1[7],code_desc_arr[13]);
										} 
										/*if(retVal_arr1[2] == "CROWN"){
											if(code_desc_arr[4] != "EXFOLTH"){				
												fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
												drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);
											}
										} */
									}	 
								}

							}
						} 
						//imageReplaceForHistory(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8]);
						/*
						if(code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DECITH"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=getDecithYN&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_rootinv = trimString(xmlHttp.responseText); 
							if(retVal_rootinv.length>1){
								var retVal_rootinv_arr = retVal_rootinv.split("~");
								for(n=0;n<retVal_rootinv_arr.length-1;n++){
									var retVal_rootinv_arr1 = retVal_rootinv_arr[n].split("##");
									if(retVal_rootinv_arr1[0] == "ROOTINV"){
										root_count --;
									}
								}
							}

							//root_count --;
						}*/
											
					} 
					
					var ind = concat.indexOf(":");
					if(site_type == "ROOT" && code_desc_arr[4]=="PERIINV"){
						drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
					}  

					//else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE"  && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[8] == "N" ){
					else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE"  && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[8] == "N" && (code_desc_arr[4] != "CROWN" && code_desc_arr[10] != "*A")){
						if(ind != -1){
							concat_val = concat.split(":");
							for(;j<concat_val.length-1;j++){
								if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
									image_count++;
									status_int = parseInt(code_desc_arr[6]);

									if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
										code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
									}

									//imgDisplay_tooth_thrng = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
									//commented by parul on 04/03/2010 for CRF-477
									//imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
									if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){

										if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[14] = "../../eOH/images/TRMT_Planned.gif";
										}										
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[14]+"' />" + imgDisplay_tooth_thrng;
									}else{
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />" + imgDisplay_tooth_thrng;
									}
                                      
									
									if(image_count >= 4){
										var imgDisplay_tooth_thrng_arr = imgDisplay_tooth_thrng.split("<img");
										var imgDisplay_tooth_thrng_temp = "";
										
										for(k=1;k<=3;k++){
											imgDisplay_tooth_thrng_temp = imgDisplay_tooth_thrng_temp+"<img"+imgDisplay_tooth_thrng_arr[k];
										}
										imgDisplay_tooth_thrng = imgDisplay_tooth_thrng_temp + "..."
										
									}

									//document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>"
									document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
									break;
								}
								else{ // // For every next set of area
									status_int = parseInt(code_desc_arr[6]);

									if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
										code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
									}

									image_count=1;
									concat = concat + code_desc_arr[1] + ":"  ;

									//commented by parul on 04/03/2010 for CRF-477

									//	imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";

									if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){

										if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[14] = "../../eOH/images/TRMT_Planned.gif";
										}										
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[14]+"' />";

										
									}else{
										imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";
									}
										
									document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' >"+imgDisplay_tooth_thrng+"</td></tr></table>";
								}
							}
						}
						else{
							image_count=1;
							concat = code_desc_arr[1] + ":" ;
							status_int = parseInt(code_desc_arr[6]);
							if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
								code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
							}
                    		//commented by parul on 04/03/2010 for CRF-477
							//imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />";
                           	if (code_desc_arr[14]!=null && code_desc_arr[14]!="null"){

								if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
									code_desc_arr[14] = "../../eOH/images/TRMT_Planned.gif";
								}										
								imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[14]+"' />";
							}else{
								imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";
							}
                                      
							document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
						}	
					}
					else{ //This else block is added by Sridevi Joshi on 26/12/2008 -- After TOOTHTM/ORTHO --> DECITH,  to get the TOOTHTM/ORTHO image icon
						if(code_desc_arr[0] == "" || code_desc_arr[0] == "null" || code_desc_arr[0] == null){
							concat = concat + code_desc_arr[1] + ":" ;

							if(ind != -1){
								concat_val = concat.split(":");
								for(;j<concat_val.length-1;j++){
									if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)

										imgDisplay_tooth_thrng = imgDisplay_tooth_thrng;
										//added height=80% to expand the image area to show the had cursor fully by sridevi Joshi on 06-JULY-09
										//document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>"
										//document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>"
										document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% align='center' height='80%'><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
										break;
									}
									else{

										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_tooth_thrng = "";
										//added height=80% to expand the image area to show the had cursor fully by sridevi Joshi on 06-JULY-09
										//document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45'  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
										document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100%  align='center' height='80%'><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
									}
								}
							}
						}
					}

					/* Reverse Loop was here. Backup in 17092007 */
				}
			else if(site_type == "CROWN"){
				//if(code_desc_arr[10]!="*A"){
					var ind_crown = crown_concat.indexOf(":");
					if(ind_crown != -1){
						concat_val = crown_concat.split(":");
						concat_cond_val = concat_cond_type.split(":");
						for(;m<concat_val.length-1;m++){
							if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
								if(code_desc_arr[3] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
									cond_type = "PULPINV";
								}
								else{
									cond_type = code_desc_arr[4];
								}
								//fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,cond_type,code_desc_arr[6],code_desc_arr[0]);
								//fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
								//drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by	 parul for crf 0483 on 25/08/2009
								if (code_desc_arr[10].length>2){
								   var surface_ref_arr=code_desc_arr[10].split(",");
									for(var p=0;p<surface_ref_arr.length;p++){											   
										 fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
										drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],surface_ref_arr[p],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
									}
							   }else{
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
							   }

								break;//Added by sridevi on 11/11/08 as it was going in to loop multiple times.
							}
							else{
								crown_concat = crown_concat + code_desc_arr[0] + ":"  ;
								concat_cond_type = concat_cond_type + code_desc_arr[4] + ":" ;
									//fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0]);
									//fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);
								 //drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by	 parul for crf 0483 on 25/08/2009
								 if (code_desc_arr[10].length>2){
								   var surface_ref_arr=code_desc_arr[10].split(",");
									for(var p=0;p<surface_ref_arr.length;p++){											   
										 fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
										drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],surface_ref_arr[p],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
									}
							   }else{
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
							   }

							}
						}
					}
					else{
						crown_concat = code_desc_arr[0] + ":"  ;
						concat_cond_type = code_desc_arr[4] + ":"  ;
						//fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0]);
                          if (code_desc_arr[10].length>2){
								   var surface_ref_arr=code_desc_arr[10].split(",");
									for(var p=0;p<surface_ref_arr.length;p++){											   
										 fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
										drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],surface_ref_arr[p],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
									}
							   }else{
									fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[13]);
									drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10],code_desc_arr[13]);//added by parul for crf 0483 on 25/08/2009		
							   }
							//fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[1],permanent_deciduous_flag);


							//drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[6],code_desc_arr[11],code_desc_arr[10]);//added by parul for crf 0483 on 25/08/2009						
					}
				//}
			}
				
			/*	else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
					root_count = parseInt(root_count);
					root_count++;
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						// By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.
						var xmlDoc = "" ;  
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal = localTrimString(retVal); //chart_line_num of ERUPTH
					
						if(retVal < code_desc_arr[10]){
							//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
							drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						}
					}else{
							//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						 	drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
					}
				}
				//if(site_type == "TOOTH" && (code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "RTDESTH")){
					//root_count = 0;
				//}
			}else{
				var site_type = code_desc_arr[2];

				if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
					root_count = parseInt(root_count);
					root_count++;
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						// By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.
						var xmlDoc = "" ;  
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal = localTrimString(retVal); //chart_line_num of ERUPTH
						
						if(parseInt(retVal) < parseInt(code_desc_arr[10])){
							//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];

							drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						}
					}else{
						//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
					
						drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
					}
				}	
			}	*/
		   else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						/*root_count = parseInt(root_count);
						root_count++;
						
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];	*/
						root_count = parseInt(root_count);
						root_count++;
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.*/
							var xmlDoc = "" ;  
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal = localTrimString(retVal); //chart_line_num of ERUPTH
							
							if(retVal < code_desc_arr[10]){
								//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
								drawLineForRootImage('rootLayer'+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],code_desc_arr[13]);
							}
						}else{
								//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
								drawLineForRootImage('rootLayer'+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],code_desc_arr[13]);
						}

					}
				}
				else{
					var site_type = code_desc_arr[2];
					if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						root_count = parseInt(root_count);
						root_count++;
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.*/
						var xmlDoc = "" ;  
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1];
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal = localTrimString(retVal); //chart_line_num of ERUPTH
					
						if(parseInt(retVal) < parseInt(code_desc_arr[12])){
						//	rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						 drawLineForRootImage('rootLayer'+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],code_desc_arr[13]);
						}
					}else{
						//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[10]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						drawLineForRootImage('rootLayer'+code_desc_arr[1],code_desc_arr[10],formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],code_desc_arr[13]);
					}
				}	
			}
		}
	}
}

function imageReplaceForHistoryForPrint(condition_type,tooth_no,status,show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,surface_code,cusp_tip_code,trmt_outcome,image_source,treatment_int_ext){
	var numbering_system = document.forms[0].tooth_numbering_system.value;
	var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
	var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
//	var header_tab = document.forms[0].header_tab.value;
	var patient_id = document.forms[0].patient_id.value;
	var chart_num = document.forms[0].chart_num.value;
	var count=0;
	 var mixed_dent_tooth_no = "";
	 var tooth_sn = tooth_no;
	//To retrieve the display tooth_no and the tooth_name...
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateDisplayToothNoAndName&"+params,false);
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
	//added by parul on 251108 for SCR-6103
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type="+condition_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal.length > 0 && parseInt(retVal) > 0){ 
		var retVal_arr = retVal.split("##");
		count = retVal_arr[0];			
	}
		var formObj = document.forms[0];

		if(condition_type == "MISSTH"){
			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

			var imageId = "R"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
		}
		else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){
			var show_img_yn = "N";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&chart_num="+chart_num+"&patient_id="+patient_id;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 0){
				var retVal_arr = retVal.split("##");
				if(retVal_arr[1] == "RTDESTH"){
					show_img_yn = "Y";
				}
				else{
					show_img_yn = "N";
				}
			}
			//if(show_img_yn == "N"){
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
			//}
		}
		else if(condition_type == "EXFOLTH"){
			
		var super_yn = "";
		var RD_yn = "";
		// This code is to get the value of the column SUPERNUMERARY_YN.This is to find out wether the tooth is supernumerary or not.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&tooth_no="+tooth_no+"&chart_num="+chart_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
		
		if(retVal.length >= 1){
			var retVal_arr = retVal.split("##");
			super_yn = retVal_arr[0];
			RD_yn = retVal_arr[1];
		}
		//added by Sharon Crasta on 11/19/2009
		var super_yn_1 ="";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&tooth_no="+tooth_no+"&chart_num="+chart_num;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal=localTrimString(retVal);
			
		if(retVal.length >= 1){
			var retVal_arr = retVal.split("##");
			super_yn_1 = retVal_arr[0];
		}//End
		var query_tooth_no = tooth_no;

		//Added by Sharon Crasta on 10/27/2009 for IN012514
		//Added to count the number of Exfoliated conditions recorded in case of Retained.
		var count_exf = 0;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type="+condition_type;

		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);
		if(retVal.length > 0 && parseInt(retVal) > 0){ 
			var retVal_arr = retVal.split("##");
			count_exf = retVal_arr[0];			
		}
		//
		//Added by Sridevi Joshi on 30/10/09 for IN015475
		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && (RD_yn == "M" && super_yn != "Y") && count == "1" && isSprRecorded == true){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}

			disply_tooth_no = disply_tooth_no +"s";
		}
		//Added by Sridevi Joshi on 30/10/09 for IN015475
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && (RD_yn == "M" && super_yn != "Y") && count == "2"){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = mapped_tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}
		}
		//Added by Sridevi Joshi on 30/10/09 for IN015475
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && (RD_yn == "M" && super_yn == "Y") && count == "2"){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = mapped_tooth_no;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length > 0){
				disply_tooth_no = retVal;
			}
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && super_yn != "N" && RD_yn != "R"){ // For Mixed Dentition - Deciduous Chart
			if(isSuperYN){
				query_tooth_no = tooth_no;
				
			}else{
				query_tooth_no = mapped_tooth_no;			
			}
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length !=0){
				disply_tooth_no = retVal;
			}
			
		}
		
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && super_yn != "N" && RD_yn == "R"){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = mapped_tooth_no;

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length !=0){
				disply_tooth_no = retVal;
			}
		}
		else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P" && RD_yn == "N" && count_exf < 2){ // For Mixed Dentition - Deciduous Chart
			query_tooth_no = mapped_tooth_no;

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			if(retVal.length !=0){
				disply_tooth_no = retVal;
			}
		}
		else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){ // For Deciduous Chart
			disply_tooth_no = tooth_num;
		}
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && RD_yn == "D" && count==1 && super_yn_1=="Y"){ // For Mixed Dentition - Deciduous Chart
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
			if(retVal.length !=0){
				disply_tooth_no = retVal;
			}
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+query_tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal=localTrimString(retVal);
			
			if(retVal.length !=0 ){
				disply_tooth_no = retVal;

			}
		}
		
		//
		//written by  parul on 251108 for SCR-6103
		if(show_RTDESTH_EXFOLTH_image_flag=="" || show_RTDESTH_EXFOLTH_image_flag=="null" || show_RTDESTH_EXFOLTH_image_flag==null || show_RTDESTH_EXFOLTH_image_flag==tooth_no+"RTDESTHEXFOLTHEXFOLTH"){ 
			if (count_exf!=1){
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
			}  
			if (count_exf=="1" && super_yn=="")	{
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
			}
		}
		var check_num_id = "check_num"+tooth_no;
	
		if(super_yn == "N"){ // Only For Supernumerary cases this value will be 'N' (For permanent tooth).For Other cases (Directly if we record exfolth then this value will be NULL)
			if(permanent_deciduous_flag == "D"){
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
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>";

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"  ;

				formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "s<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";
		}
		else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "P" && RD_yn == "N" && count_exf <= 1){ // For Mixed Dentition - Deciduous Chart
			//Added by Sharon Crasta on 10/13/2009 for IN015312
			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif'  border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"  

			if(permanent_deciduous_flag == "D"){
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
			}
			else{
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
			
			var imageId = "R"+tooth_no;
			//formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"  
			formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>";
			//formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"

						
			//End

			//formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
			formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";
		}
		//Added by Sharon Crasta on 10/28/2009 for IN012514
		else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "R" && count_exf < 1){//REtained Deciduous -> ERupt Permanent Tooth -> Exfoliate primary tooth
			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'></div>";

			if(permanent_deciduous_flag == "D"){
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
			}
			else{
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
			var imageId = "R"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>";
		
			formObj.document.getElementById(check_num_id).innerHTML =  disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";
		} //End
		else{

			//Added by Sridevi Joshi for IN013770(To remove the Root Image when Retained---> exfolth deciduous tooth) on 22/08/09
			//Commented and Added by Sharon Crasta on 10/9/2009 for IN015202
			//if(mixed_dentition_YN == "N" && RD_yn == "R" ){
			if(mixed_dentition_YN == "N" && RD_yn == "R" && !(isPartiallyErupted) && !(isErupted)){

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
			}
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "R" && isPartiallyErupted && isErupted){
				//var imageId = "R"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

				//Added by Sharon Crasta on 9/22/2009 for IN014727
				//To get a new crown on Retained-->exfolth deciduous tooth
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "'  width='41' height='25'/></div>"  ;
				
				isPartiallyErupted = false;
				isErupted = false;
			}
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "R" && isPartiallyErupted && !(isErupted)){
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

				//Added by Sharon Crasta on 9/22/2009 for IN014727
				//To get a new crown on Retained-->exfolth deciduous tooth
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"

				isPartiallyErupted = false;
				isErupted = false;
			}
			/*else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "R"){
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

				//Added by Sharon Crasta on 9/22/2009 for IN014727
				//To get a new crown on Retained-->exfolth deciduous tooth
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
			} */
			else if(RD_yn == "R" && !(isErupted)) {
				
				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

				//Added by Sharon Crasta on 9/22/2009 for IN014727
				//To get a new crown on Retained-->exfolth deciduous tooth
				var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				//
			}
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "M" && super_yn != "Y" && count == 1 && isSprRecorded == true){//Added by Sridevi Joshi on 30/10/09 for IN015475
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"  ;

				if(permanent_deciduous_flag == "D"){
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
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'  width='41' height='34'/></div>";

				isSprRecorded = false;
			
			}
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "M" && isSuperYN && count_exf == 1){
				//var imageId = "T"+tooth_no;
				//formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif'  border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"  

				if(permanent_deciduous_flag == "D"){
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
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				
				var imageId = "R"+tooth_no;
				
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>";
				
				formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";

				isPartiallyErupted = false;
				isErupted = false;
				isSprRecorded = false;
			} 
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "M" && isSuperYN && count_exf == 2){
				/*var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif'  border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"  

				if(permanent_deciduous_flag == "D"){
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
				}
				else{
					var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
				}
				
				var imageId = "R"+tooth_no;
				
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>";   */
				
				formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";
			}
			//Added by Sharon Crasta on 11/19/2009
			else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && RD_yn == "D"&& count==1 && super_yn=="Y"){//added by parul on 16/11/2009 for IN16204
					  if(permanent_deciduous_flag == "D"){
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
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						//formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','S')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'></div>";  
						formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'></div>";  
						
					//	if (super_yn=="Y"){
							 formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";

					//	}else{
							//formObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','DRS')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						//}

				  }else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && RD_yn == "D"&& count==1 && super_yn!="Y" && super_yn_1=="Y" ){//added by parul on 16/11/2009 for IN16204
					  if(permanent_deciduous_flag == "D"){
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
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>";

						var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'></div>";  
						

						formObj.document.getElementById(check_num_id).innerHTML =  disply_tooth_no + "s<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";

				  }else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && RD_yn == "D"&& count==1 && super_yn!="Y" && super_yn_1=="N" ){//added by parul on 16/11/2009 for IN16204
						 var imageId = "T"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='44' height='31'/>";

						var imageId = "R"+tooth_no;
						formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='44' height='31'/>";
					
						formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";


				  }
			else{//End
			//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && RD_yn == "R" && super_yn != "Y"){
			/*else if(super_yn != "Y"){

				var imageId = "R"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

				//Added by Sharon Crasta on 9/22/2009 for IN014727
				//To get a new crown on Retained-->exfolth deciduous tooth
				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"
			}*/
			//
			formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "<input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'>";

			/*isPartiallyErupted = false;
			isErupted = false; */
			}
			isPartiallyErupted = false;
			isErupted = false;
			isSuperYN = false;
			isSprRecorded = false;
		}
		}
		else if(condition_type == "DECITH"){
			var numbering_system = document.forms[0].tooth_numbering_system.value;
			var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
			var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
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
						formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' 			width='45'></td></tr></table></td></tr></table>";
					}else{
						formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' 					width='45'></td></tr></table></td></tr></table>";
					}
				}
			}
		}
	else if(condition_type == "RTDESTH"){
			var disply_tooth_no = "";
			var numbering_system = document.forms[0].tooth_numbering_system.value;
			var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
			var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
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
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
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

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
						//root_img_no = tooth_sn;
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
						MDD_flag = "RD"; //Recorded on Deciduous Tooth

					}
					else{
						//root_img_no = tooth_no;
						root_img_no = tooth_no;
						var rd_flag = 'NR';			//(11,51 case)
						var rd_normal_flag = "RD";
					}
					
					if(mixed_dentition_YN =="Y" && permanent_deciduous_flag =="D"){ 
						// This condition is used when RTDESTH is recorded in MIXD Dent Dec case, where the DEC tooth is displayed 1st and then permanent tooth (51,11). In case of permanent chart, When RTDESTH is recorded, the permanent tooth is displayed 1st and then the dectooth (11,51)
						var rd_flag = 'RD';			//(51,11 case)
						var rd_normal_flag = "NR";
					}else{
						var rd_flag = 'NR';			//(11,51 case)
						var rd_normal_flag = "RD";
					}
					//Added by Sharon Crasta on 10/28/2009 for IN012514
					//Added to display only the tooth no and not to replace the crown and root on Retained Deciduous.
					var check_num_id = "check_num"+tooth_no;
					//if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
					if(mixed_dentition_YN == "Y"){
						//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new RTDESTH changes
						//formObj.document.getElementById(check_num_id).innerHTML = "disply_tooth_no +"," + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'>";
						formObj.document.getElementById(check_num_id).innerHTML = "<font style='background-color:gray;color:white'>" + disply_tooth_no +"</font>," + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'>";
					}
					else{//End
						if(tooth_no>=1 && tooth_no<=16 || (tooth_no>=33 && tooth_no<=42)){
							//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new RTDESTH changes
							//formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
							formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><font style='background-color:gray;color:white'>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'></font>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
						}
						else{
							//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new RTDESTH changes
							//formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "'  /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
							formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "'  /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><font style='background-color:gray;color:white'>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'></font>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
						}
					}
				}
			}
		}
		/*else if(condition_type == "SUPRTH"){
			var disply_tooth_no = "";
			var numbering_system = document.forms[0].tooth_numbering_system.value;
			var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;//parul
			var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;//parul
			
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && mixed_dent_deciduous_yn == "D"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 1){
					var retVal_arr = retVal.split("##");
					disply_tooth_no = retVal_arr[0];
				}
			}
			else{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 1){
					disply_tooth_no = retVal;
				}
			}
			var imageId = "decith_table"+tooth_no;
			if(permanent_deciduous_flag == "D"){
				//var imgSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";

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
			else{
				var imgSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
			if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
				formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imgSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1'  /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + disply_tooth_no + "," + disply_tooth_no + "s<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
			}
			else{
				formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imgSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + disply_tooth_no + "," + disply_tooth_no + "s<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
			}
		} */
		else if(condition_type == "SUPRTH"){
			isSprRecorded = true;
			var disply_tooth_no = "";
			var super_main = "";
			var super_str = "";
			var super_cnt = 0;
			var numbering_system = document.forms[0].tooth_numbering_system.value;
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && mixed_dent_deciduous_yn == "D"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
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
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0){
					var retVal_arr = retVal.split("##");
					disply_tooth_no = retVal_arr[0];
				}
				//if(disply_tooth_no == "" || disply_tooth_no == "null" || disply_tooth_no == null || mixed_dent_deciduous_yn=="" || mixed_dent_deciduous_yn=="null"||mixed_dent_deciduous_yn==null){ //For extream tooth on MD-D chart // Commented by Sridevi on 06/08/09 to display the permanent tooth no after recording EXFOLTH--->ERUPTH--->SUPRTH
				if(disply_tooth_no == "" || disply_tooth_no == "null" || disply_tooth_no == null){ //For extream tooth on MD-D chart
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no+"&numbering_system="+numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
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
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal=localTrimString(retVal);
				if(retVal.length > 0){
					disply_tooth_no = retVal;
				}
			}

			//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//params = "func_mode=SuperRDyn&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
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

			//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH key  count.
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
			var check_num_id = "check_num"+tooth_no;
			if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
				// 33/R4  34/R5  35/R6  36/R7  37/R8  
				// 38/R9  39/R10 40/R11 41/R12 42/R13
				// 47/R24 46/R23 45/R22 44/R21 43/R20
				// 52/R29 51/R28 50/R27 49/R26 48/R25
				
				//MR & MRS--- When conditions are recorded on the deciduous tooth in MD-D case
				//NS & S ----- When conditions are recorded on the permanent tooth after exfoliated in MD-D case
				if(mixed_dent_deciduous_yn == "M"){
					//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";

					}
				}
				else if(mixed_dent_deciduous_yn == "DR"|| mixed_dent_deciduous_yn == "DRS" || mixed_dent_deciduous_yn == "D"){//added by parul (record Deciduoud,supernum.....than trauma on same toothâ?¦Deciduous tooth no is C,super it will C,Cs â?¦.than truma tooth no is comng 6,6s )
				//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
					}
				}
				else{
					//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
					}
				}
			}
			else{
				if(mixed_dent_deciduous_yn == "M"){
					//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
					}
				}
				else if(mixed_dent_deciduous_yn == "DR"|| mixed_dent_deciduous_yn == "DRS" || mixed_dent_deciduous_yn == "D"){//added by parul (record Deciduoud,supernum.....than trauma on same toothâ?¦Deciduous tooth no is C,super it will C,Cs â?¦.than truma tooth no is comng 6,6s )
					//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
					}
				}
				else{
					//Added by SRidevi Joshi on 2/2/2010 for IN010894(SRR20056-CRF-0481)
					if(super_cnt == "2"){
						super_main = "<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>";
						for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
							if(z==0){
								super_str = "<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
							else{
								super_str = super_str+",<font style='background-color:white;color:black'>"+retVal_SuperKey_arr[z]+"</font></a>";
							}
						}

						formObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str;
					}
					else{
						formObj.document.getElementById(check_num_id).innerHTML ="<font style='background-color:gray;color:white'>" + disply_tooth_no + "</font>,"+retVal_SuperKey_arr[0]+"<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
					}
				}
			}

			/*//Commented above and added by Sridevi Joshi on 3/1/2010 for IN010894(SRR20056-CRF-0481)
			var Rd_flag_ind = "";
			if(mixed_dent_deciduous_yn == "M"){
				Rd_flag_ind = "MR";
			}
			else if(mixed_dent_deciduous_yn == "D"){
				Rd_flag_ind = "D";
			}

			formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "+<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";*/

			isSuperYN = true;
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
		/*else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";

			var imageId = "R"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";
		} */
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
								} else{
									 var imageId = "T"+code_desc_arr[k];
									 formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
															
									 var imageId = "R"+code_desc_arr[k];
									 formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									 break;
								}
						   }else if(treatment_int_ext == "I"){
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
					 }else if(treatment_int_ext=="I"){
					 	if (trmt_outcome=="F"){
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
		}
		else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
			if(treatment_int_ext == "E"){
				if (trmt_outcome == "F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
				}
			}else if(treatment_int_ext == "I"){
				if (trmt_outcome == "F"){
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
				}else{
					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
				}
			}

		} //End
		else if(condition_type == "DENTURE"){
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
		
		else if(condition_type == "PARERTH"){
			var imageId = "R"+tooth_no;
			if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){
				var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
			}
			else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
			else{
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}

			var show_img_yn = "N";
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no+"&chart_num="+chart_num+"&patient_id="+patient_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 0){
					var retVal_arr = retVal.split("##");
					if(retVal_arr[1] == "RTDESTH"){
						show_img_yn = "Y";
					}
					else{
						show_img_yn = "N";
					}
				}
			}
			if(show_img_yn == "N"){
				formObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";
			}

			var imageId = "T"+tooth_no;
			//Added by Sharon Crasta on 10/28/2009 for IN012514
			//Record Caries -> Retained Deciduous -> The crown and root should not be replaced.
			var root_layer = "rootLayer"+tooth_no;
			var tooth_layer = "toothLayer"+tooth_no;
			if(formObj.document.getElementById(tooth_layer) == "null" || formObj.document.getElementById(tooth_layer) == null){ //End
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div>";
			}
			isPartiallyErupted = true;

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
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
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
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
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
			if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){
				//var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";

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
			else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
				var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
			}
			else{
				//var imageSrc = "../../eOH/images/R"+tooth_no+".gif";

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
			/*var root_layer = "rootLayer"+tooth_no;
			if(formObj.document.getElementById(root_layer) == "null" || formObj.document.getElementById(root_layer) == null){
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' width='41' height='34'/></div>"
			}

			var imageId = "T"+tooth_no;
			formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "'  width='41' height='25'/></div>" */
			//Added by Shron Crasta on 10/28/2009 for IN012514
		if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D") {

			  //if(isPartiallyErupted && RD_Normal_yn != "NR"){
			if(mixed_dent_tooth_no == "" || mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null"){

			  /*if(isPartiallyErupted && count_exf < 1){
				var root_layer = "rootLayer"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
				
				var imageId = "T"+tooth_no;
				dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"

			  }	
			 
			 else{ */
			  
				//Commented by Sharon Crasta on 1/18/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH and RTDESTH changes.
				//if(isPartiallyErupted && count_exf == 1){
				if(isPartiallyErupted){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>";
				}
				//Added by Sharon Crasta on 11/4/2009 for IN015475
			  //In case of Supernumerary -> Exfoliate both -> PArtially Erupt-> Caries -> ERupt
			  else if(isPartiallyErupted && count_exf == 2){
				var root_layer = "rootLayer"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'  width='41' height='34'/></div>";
			  }
				else if(count_exf == 2){//Added by Sridevi Joshi on 02/11/09 for IN015475
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"
			  }
			  else if (count_exf == 1)
			  {
					var root_layer = "rootLayer"+tooth_no;	 					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"
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
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length > 0 && parseInt(retVal) > 0){ 
					var retVal_arr = retVal.split("##");
					count_partially_erupted = retVal_arr[0];			
				}
				if(count_partially_erupted == 1){
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'  width='41' height='34'/></div>"

					//var imageId = "T"+tooth_no;
					//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"

				}
				else{
					var root_layer = "rootLayer"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>"

					var imageId = "T"+tooth_no;
					formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"
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
			xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=countExfTooth&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			retVal = localTrimString(retVal);
			if(retVal.length > 0 && parseInt(retVal) > 0){ 
				var retVal_arr = retVal.split("##");
				count_partially_erupted = retVal_arr[0];			
			}
			if(count_partially_erupted == 1){
				var root_layer = "rootLayer"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>"

				//var imageId = "T"+tooth_no;
				//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
				// isPartiallyErupted = false;
			}
			else{
				var root_layer = "rootLayer"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' border='0' usemap='#MapRUR" + tooth_no + "'   width='41' height='34'/></div>"

				var imageId = "T"+tooth_no;
				formObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap='#MapTUR1" + tooth_no + "' width='41' height='25'/></div>"
			}
		}

			isErupted = true;
		}
	
}

