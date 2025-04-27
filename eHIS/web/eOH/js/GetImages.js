var tab_name; 
var arch_quad;
var quad_desc;
var arch_desc;
var selected_tooth_count = 0;
var selected_quad_count = 0;
var selected_arch_count = 0;
var site_colchk_val;
var site_rowchk_quad_val;
var site_rowchk_arch_val;
var thrng_nos = "";
var name_tooth_no;
var thrng_nos_arr;
//var thrng_nos_ref = "";

//For getAllImages Function						    
var duplicate = new Array();
var j = 0;
var m = 0;
   
function getAllImagesFromDB(tooth_no,super_tooth_no,refresh_cell,exfolth_count,retained_tooth_no,super_retained_flag,total_SuperKey_count,super_recorded,flag){
	var formObj = document.forms[0];

	//if(dentalChartFrameObj != undefined && dentalChartFrameObj != "undefined"){
		//formObj = dentalChartFrameObj;
	//}
	
	var alt_text = getLabel("eOH.ImagesInfoTitleForChart.Label","OH");
	var imgDisplay_arch_quad = "";
	var imgDisplay_arch = "";

	//added by parul for SCR#6115
	var imgDisplay_arch_quad_1 = "";
	var imgDisplay_arch_quad_2 = "";
	var imgDisplay_arch_quad_3 = "";
	var imgDisplay_arch_quad_4 = "";
	var imgDisplay_arch_quad_u = "";
	var imgDisplay_arch_quad_l = "";
	//
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
	var asOnDate = "";
	var baseline_chart_yn = "";
	var status_int = 0;
	var classId= "";
	var chart_num  = formObj.chart_num.value;
	var patient_id = formObj.patient_id.value;
	var chart_status_from_view = formObj.chart_status_from_view.value;
	var locale = formObj.locale.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;

	//Added by Sharon Crasta on 11/7/2008 for SCR #6141
   // Take the asOnDate value depending on if the treatment is marked as error in the Treatment or Ext. Treatment tab.
	if(tab_name != "null" && tab_name != null && tab_name != "undefined" && tab_name != "" && (tab_name == "ET" || tab_name == "DC")){
		//if(tab_name != "null" && tab_name != null && tab_name != "undefined" && tab_name != "" && tab_name == "ET"){
		if(parent.parent.parent.parent.frames[0] == null || parent.parent.parent.parent.frames[0] == "null"){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		else if(parent.parent.parent.parent.frames[0].document.forms[0] == undefined || parent.parent.parent.parent.frames[0].document.forms[0] == "undefined" || parent.parent.parent.frames[0].document.forms[0] == "null" || parent.parent.parent.frames[0].document.forms[0] == null){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		//else if(parent.parent.parent.parent.frames[0].document.forms[0].asOnDate.value == undefined || parent.parent.parent.parent.frames[0].document.forms[0].asOnDate.value == "undefined" || parent.parent.parent.frames[0].document.forms[0] == "null" || parent.parent.parent.frames[0].document.forms[0] == null){
		else if(parent.parent.parent.parent.frames[0].document.forms[0].asOnDate == null || parent.parent.parent.parent.frames[0].document.forms[0].asOnDate == "null" || parent.parent.parent.parent.frames[0].document.forms[0].asOnDate.value == undefined || parent.parent.parent.parent.frames[0].document.forms[0].asOnDate.value == "undefined" || parent.parent.parent.frames[0].document.forms[0] == "null" || parent.parent.parent.frames[0].document.forms[0] == null){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		else{
			asOnDate = parent.parent.parent.parent.frames[0].document.forms[0].asOnDate.value;
		}
	}	
	else{  
	//End
		if(parent.parent.parent.frames[0] == null || parent.parent.parent.frames[0] == "null"){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		else if(parent.parent.parent.frames[0].document.forms[0] == undefined || parent.parent.parent.frames[0].document.forms[0] == "undefined" || parent.parent.parent.frames[0].document.forms[0] == "null" || parent.parent.parent.frames[0].document.forms[0] == null){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		else if(parent.parent.parent.frames[0].document.forms[0].asOnDate.value == undefined || parent.parent.parent.frames[0].document.forms[0].asOnDate.value == "undefined" || parent.parent.parent.frames[0].document.forms[0].asOnDate.value == "null" || parent.parent.parent.frames[0].document.forms[0].asOnDate.value == null){
			asOnDate = getCurrentDate("DMYHM","<%=locale%>");
		}
		else{
			asOnDate = parent.parent.parent.frames[0].document.forms[0].asOnDate.value;
		}
		
	}

	if(asOnDate.indexOf(" ") != -1){ //Added By sridevi joshi on 12/7/2009 while SUPRTH new Changes
		var asOnDateTimeArray = asOnDate.split(" ");
		asOnDate = asOnDateTimeArray[0];
	 }

	if(checkAsOnDateNotGreaterThanActiveChartDate(asOnDate)){
		  chart_status_from_view = "";
	} 

	baseline_chart_yn = formObj.baseline_chart_yn.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;// //added by parul  for other facility chart CRF#0423
	var oh_chart_level = formObj.oh_chart_level.value;// //added by parul  for other facility chart CRF#0423
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = formObj.header_tab.value;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&asOnDate="+asOnDate+"&baseline_chart_yn="+baseline_chart_yn+"&chart_status_from_view="+chart_status_from_view+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&refresh_cell="+refresh_cell+"&super_tooth_no="+super_tooth_no+"&tooth_no="+tooth_no+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no+"&super_recorded="+super_recorded+"&flag="+flag;
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&asOnDate="+asOnDate+"&baseline_chart_yn="+baseline_chart_yn+"&chart_status_from_view="+chart_status_from_view;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonImagesValidation.jsp?func_mode=getAllImagesFromDB&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert("retVal------>"+retVal)

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
			var site_type="";
			if (code_desc_arr[3]=="CROWN"){
				site_type = code_desc_arr[3];
			}else{
				site_type = code_desc_arr[2];
			}
			
			 
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
			if((code_desc_arr[0]!=null && code_desc_arr[0]!="null") || (code_desc_arr[4] == "TOOTHTM" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "EXTRACT"  || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "PERIINV" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DENTURE" ||  code_desc_arr[4] =="ORTHO" ||  code_desc_arr[4] =="DECITH" || (code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A"))){// image_id will be null for ROOT and CROWN site_types
			
			 //code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A") added by parul on 23/01/2010 for CRF-442
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
							formObj.document.getElementById(imageId).style.backgroundColor = fill_color;
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
									
									//Commented by Parul on 02/03/2010 forCRF-477
									//imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  /> " + imgDisplay_arch_quad;
									if (code_desc_arr[9]!=null && code_desc_arr[9]!="null"){
										if(code_desc_arr[10]=="E"){
											if (code_desc_arr[4] == "DENTURE"){
												if (code_desc_arr[8]!="F"){
													imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureExternalTool.gif>"+imgDisplay_arch_quad;
												}else if (code_desc_arr[8]=="F"){
													 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureExternalFailTool.gif>"+imgDisplay_arch_quad;
												}
											}else if (code_desc_arr[4] == "ORTHO"){
												if (code_desc_arr[8]!="F"){
													imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternaTool.gif>"+imgDisplay_arch_quad;
												}else if (code_desc_arr[8]=="F"){
													 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternalFailTool.gif>"+imgDisplay_arch_quad;
												}
											}
										
										}else{
											if(code_desc_arr[10]=="I"){
												if (code_desc_arr[4] == "DENTURE"){
													if (code_desc_arr[8]!="F"){
														imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Denture_indicator.gif>"+imgDisplay_arch_quad;
													}else if (code_desc_arr[8]=="F"){
														 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureFailTool.gif>"+imgDisplay_arch_quad;
													}
												}else if (code_desc_arr[4] == "ORTHO"){
													if (code_desc_arr[8]!="F"){
														imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho.gif>"+imgDisplay_arch_quad;
													}else if (code_desc_arr[8]=="F"){
														 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho_F.gif>"+imgDisplay_arch_quad;
													}
												}
											}
										}
									}else{
										  imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  /> " + imgDisplay_arch_quad;
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
									//document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;						
									// document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
									 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+super_retained_flag+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";

									break;
								}
								else{ // // For every next set of area
									image_count=1;
									concat = concat + code_desc_arr[1] + ":"  ;
									 
									//Commented by Sharon Crasta on 11/24/2008 for SCR #6755
									/*	imgDisplay_arch_quad = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"'));\" />";
									document.getElementById(imageId).innerHTML = imgDisplay_arch_quad;	   */
								 
									//imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />";

								  if (code_desc_arr[9]!=null && code_desc_arr[9]!="null"){
									if(code_desc_arr[10]=="E"){
										if (code_desc_arr[4] == "DENTURE"){
											if (code_desc_arr[8]!="F"){
												imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureExternalTool.gif>";
											}else if (code_desc_arr[8]=="F"){
												 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer' src=../../eOH/images/DentureExternalFailTool.gif>";
											}
										}else if (code_desc_arr[4] == "ORTHO"){
											if (code_desc_arr[8]!="F"){
												imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternaTool.gif>";
											}else if (code_desc_arr[8]=="F"){
												 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternalFailTool.gif>";
											}
										}
									
									}else{
										if(code_desc_arr[10]=="I"){
											if (code_desc_arr[4] == "DENTURE"){
												if (code_desc_arr[8]!="F"){
													imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Denture_indicator.gif>";
												}else if (code_desc_arr[8]=="F"){
													 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureFailTool.gif>";
												}
											}else if (code_desc_arr[4] == "ORTHO"){
												if (code_desc_arr[8]!="F"){
													imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho.gif>";
												}else if (code_desc_arr[8]=="F"){
													 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho_F.gif>";
												}
											}
										}
									}
								  }else{
										imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />";

								  }

									formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+super_retained_flag+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
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
                              if (code_desc_arr[9]!=null && code_desc_arr[9]!="null"){
								if(code_desc_arr[10]=="E"){
									if (code_desc_arr[4] == "DENTURE"){
										if (code_desc_arr[8]!="F"){
                                            imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureExternalTool.gif>";
										}else if (code_desc_arr[8]=="F"){
											 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer' src=../../eOH/images/DentureExternalFailTool.gif>";
										}
									}else if (code_desc_arr[4] == "ORTHO"){
										if (code_desc_arr[8]!="F"){
                                            imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternaTool.gif>";
										}else if (code_desc_arr[8]=="F"){
											 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/OrthoExternalFailTool.gif>";
										}
									}
								
								}else{
									if(code_desc_arr[10]=="I"){
										if (code_desc_arr[4] == "DENTURE"){
											if (code_desc_arr[8]!="F"){
												imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Denture_indicator.gif>";
											}else if (code_desc_arr[8]=="F"){
												 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/DentureFailTool.gif>";
											}
										}else if (code_desc_arr[4] == "ORTHO"){
											if (code_desc_arr[8]!="F"){
												imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho.gif>";
											}else if (code_desc_arr[8]=="F"){
												 imgDisplay_arch_quad ="<img alt='"+alt_text+"'style='cursor:pointer'  src=../../eOH/images/Ortho_F.gif>";
											}
										}
									}
								}
							}else{
							   	imgDisplay_arch_quad ="<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />";

							}
							//formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+super_retained_flag+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
                        
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+super_retained_flag+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
						}
					}
				}

				else if(site_type == "TOOTH" || site_type == "THRNG" || (site_type == "ROOT" && code_desc_arr[4]=="PERIINV") || (code_desc_arr[3] == "CROWN" && code_desc_arr[5] == "*A")){
					if(code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "UNERTH" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "EXTRACT" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "PARERTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "IMPACTN" || code_desc_arr[4] == "BRIDGE" || code_desc_arr[4] == "DENTURE" ||(code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A") ){ //29FEB bshankar
                     //code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A") added by parul on 23/01/2010 for CRF-442
							imageReplacementForCond(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8],formObj,code_desc_arr[9],code_desc_arr[12],code_desc_arr[13],code_desc_arr[11]);								
							
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
						//drawCircleForRoot(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						drawCircleForRoot(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6],'','','','','',code_desc_arr[10]);
					}  

					//Uncommented by Sharon Crasta on 11/23/2009 for IN016505
					//The below code was uncommented since inc ase Supernumerary condition wasnt entering the loop and displaying the supernumerary icon on refresh.
					else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE"  && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[7] == "N" ){
					//else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE"  && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && (code_desc_arr[7] == "N" && code_desc_arr[4] != "SUPRTH")){

						if(ind != -1){
							concat_val = concat.split(":");
							/* j=0 is added by Sridevi joshi on 12/7/2009 while SUPRTH new chnages */
							if(refresh_cell == "Y"){
								j=0;
							}
							for(;j<concat_val.length-1;j++){
								if(concat_val[j] == code_desc_arr[1] && site_type == code_desc_arr[2]){ // For the same area(Q,A,T)
									image_count++;
									status_int = parseInt(code_desc_arr[6]);

									if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
										code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
									}
                                    //added by parul on 01/03/2010 for CRF-477
									//imgDisplay_tooth_thrng = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
									if (code_desc_arr[12]!=null && code_desc_arr[12]!="null"){

										if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[12] = "../../eOH/images/TRMT_Planned.gif";
										}										
										imgDisplay_tooth_thrng = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[12]+"' />" + imgDisplay_tooth_thrng;
									}else{
                                      
									   imgDisplay_tooth_thrng = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'/>" + imgDisplay_tooth_thrng;
									}
									
									if(image_count >= 4){
										var imgDisplay_tooth_thrng_arr = imgDisplay_tooth_thrng.split("<img");
										var imgDisplay_tooth_thrng_temp = "";
										
										for(k=1;k<=3;k++){
											imgDisplay_tooth_thrng_temp = imgDisplay_tooth_thrng_temp+"<img"+imgDisplay_tooth_thrng_arr[k];
										}
										imgDisplay_tooth_thrng = imgDisplay_tooth_thrng_temp + "..."
										
									}
									formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_retained_flag+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>"


									break;
								}
								else{ // // For every next set of area
									status_int = parseInt(code_desc_arr[6]);

									if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
										code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
									}

									image_count=1;
									concat = concat + code_desc_arr[1] + ":"  ;

									//imgDisplay_tooth_thrng = "";
									 //added by parul on 01/03/2010 for CRF-477
									//imgDisplay_tooth_thrng  =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"' />";

									if (code_desc_arr[12]!=null && code_desc_arr[12]!="null"){
                                        if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[12] = "../../eOH/images/TRMT_Planned.gif";
										}
										imgDisplay_tooth_thrng  =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[12]+"'/>";

									}else{
                                     
										 imgDisplay_tooth_thrng  =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'/>";
									}

									formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_retained_flag+"'));\" style='cursor:pointer'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
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
							 //added by parul on 01/03/2010 for CRF-477
								//imgDisplay_tooth_thrng =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'  />";
								if (code_desc_arr[12]!=null && code_desc_arr[12]!="null"){
                                    if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
											code_desc_arr[12] = "../../eOH/images/TRMT_Planned.gif";
									}
									imgDisplay_tooth_thrng =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[12]+"'/>";

								}else{
                           			 imgDisplay_tooth_thrng =  "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'/>";
								}	
								
							formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_retained_flag+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>";
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
										formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_retained_flag+"'));\">"+imgDisplay_tooth_thrng+"</td></tr></table>"
										break;
									}
									else{
										concat = concat + code_desc_arr[1] + ":"  ;
										imgDisplay_tooth_thrng = "";
										//added height=80% to expand the image area to show the had cursor fully by sridevi Joshi on 06-JULY-09
										formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45'  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_retained_flag+"'));\" style='cursor:pointer'>"+imgDisplay_tooth_thrng+"</td></tr></table>";

									}
								}
							}
						}
					}

					/* Reverse Loop was here. Backup in 17092007 */
				}
				else if(site_type == "CROWN"){
					if(code_desc_arr[5]!="*A"){
						var ind_crown = crown_concat.indexOf(":");
						if(ind_crown != -1){
							concat_val = crown_concat.split(":");
							concat_cond_val = concat_cond_type.split(":");
							/* m=0 is added by SRidevi Joshi on 12/7/2009 while SUPRTH new changes*/
							if(refresh_cell == "Y"){
								m=0;
							}
							for(;m<concat_val.length-1;m++){
								
								if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
									if(code_desc_arr[3] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
										cond_type = "PULPINV";
									}
									else{
										cond_type = code_desc_arr[4];
									}
									 //commented and added by parul on 23/01/2010 for CRF-442
									 //fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,cond_type,code_desc_arr[6],code_desc_arr[0]);
									//drawCircleForCusp(code_desc_arr[0],formObj,code_desc_arr[6],code_desc_arr[7],code_desc_arr[3],tab_name);//added by	 parul for crf 0483 on 25/08/2009

									 if (code_desc_arr[5].length>2){
										 var surface_ref_arr=code_desc_arr[5].split(",");
										for(var p=0;p<surface_ref_arr.length;p++){											   
											//fillCrownImages("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
											fillCrownImages("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
											drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],tab_name,'','','','','',code_desc_arr[11]);
										}
									  }else{
											 //fillCrownImages("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],code_desc_arr[10]);
										    fillCrownImages("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
											drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],tab_name,'','','','','',code_desc_arr[11]);

									  }

									break;//Added by sridevi on 11/11/08 as it was going in to loop multiple times.
								}
								else{
									crown_concat = crown_concat + code_desc_arr[0] + ":"  ;
									concat_cond_type = concat_cond_type + code_desc_arr[4] + ":" ;
								 //commented and added by parul on 23/01/2010 for CRF-442							 //fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0]);
								 //drawCircleForCusp(code_desc_arr[0],formObj,code_desc_arr[6],code_desc_arr[7],code_desc_arr[3],tab_name);//added by parul for crf 0483 on 25/08/2009	
									 if (code_desc_arr[5].length>2){
									   var surface_ref_arr=code_desc_arr[5].split(",");
										for(var p=0;p<surface_ref_arr.length;p++){	
											
											fillCrownImages("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
											drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],tab_name,'','','','','',code_desc_arr[11]);
										}
									 }else{
											
											fillCrownImages("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
											drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],tab_name,'','','','','',code_desc_arr[11]);
									 }
								}
							}
						}
						else{
							crown_concat = code_desc_arr[0] + ":"  ;
							concat_cond_type = code_desc_arr[4] + ":"  ;
							 //commented and added by parul on 23/01/2010 for CRF-442
							 //  drawCircleForCusp(code_desc_arr[0],formObj,code_desc_arr[6],code_desc_arr[7],code_desc_arr[3],tab_name);//added by parul for crf 0483 on 25/08/2009	
							 //fillCrownImages("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,code_desc_arr[4],code_desc_arr[6],code_desc_arr[0]);
							
							   if (code_desc_arr[5].length>2){
								   var surface_ref_arr=code_desc_arr[5].split(",");
									for(var p=0;p<surface_ref_arr.length;p++){											   
										fillCrownImages("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
                                         drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],tab_name,'','','','','',code_desc_arr[11]);
									}
								  }else{
										fillCrownImages("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,code_desc_arr[4],code_desc_arr[7],code_desc_arr[1],'','','','','','',code_desc_arr[11]);
									   drawCircleForCusp(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],tab_name,'','','','','',code_desc_arr[11]);
								  }
							}
						}
				}else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
					root_count = parseInt(root_count);
					root_count++;
					//removed all checkForEXFOLTH block and made one common block for checkForERUPTH by parul for super/retained changes 

					var xmlDoc = "" ;  
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1]+"&super_retained_flag="+super_retained_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_root = trimString(xmlHttp.responseText);
					retVal_root = localTrimString(retVal_root); //chart_line_num of ERUPTH
			
					if(parseInt(retVal_root) < parseInt(code_desc_arr[9])){
						//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+''+"##"+''+"##"+''+"##"+''+"##"+''+"##"+code_desc_arr[11];
					}else{
						//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
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
					/* By Sridevi Joshi for IN009202(SRR20056-CRF-0454-OH) on 06/08/09... To retrieve the chart_line_num of ERUPTH.If this value is less than the conditions/Treatments recorded on ROOT then 'drawLineForRootImage' fumction will not be called which will hide representation of all previous records on ROOT in MD-D chart.*/
					//checkForERUPTH , checkForEXFOLTH addedd by sridevi for IN016322
					//removed all checkForEXFOLTH block and made one common block for checkForERUPTH by parul for super/retained changes
					var xmlDoc = "" ;  
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+code_desc_arr[1]+"&super_retained_flag="+super_retained_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_root = trimString(xmlHttp.responseText);
					retVal_root = localTrimString(retVal_root); //chart_line_num of ERUPTH
				
					if(parseInt(retVal_root) < parseInt(code_desc_arr[9])){
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+''+"##"+''+"##"+''+"##"+''+"##"+''+"##"+code_desc_arr[11];
					}else{
						//rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];

					}				
				}	
			}
			
			//added by parul for SCR#6115
			if (code_desc_arr[1]=="L"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="U" &&		code_desc_arr[1]!="3" && code_desc_arr[1]!="1" && code_desc_arr[1]!="2" && code_desc_arr[1]!="4"){
					if ((imgDisplay_arch_quad_l=="" || imgDisplay_arch_quad_l=="null" || imgDisplay_arch_quad_l==null ) && (imgDisplay_arch_quad_l!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_l="&nbsp;";

						if (imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_l=="&nbsp;"))	{
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_l+"</A>";
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_l+"</td></tr></table>";

						}

						if (imgDisplay_arch_quad=="&nbsp;&nbsp;")	{
						 //Commented by Sharon Crasta on 12/1/2008 for SCR #6755
						//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_l+"</A>";
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_l+"</td></tr></table>";

						}

						if ((imgDisplay_arch_quad_l=="&nbsp;") &&( imgDisplay_arch_quad_l=="null" ||  imgDisplay_arch_quad_l=="" || imgDisplay_arch_quad_l==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
							 //Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_u+"</A>";
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad_u+"</td></tr></table>";

						}

						if (imgDisplay_arch_quad_l!="&nbsp;" )	{
							if (imgDisplay_arch_quad_1=="" ||imgDisplay_arch_quad_2=="" ||imgDisplay_arch_quad_4=="" ){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";
								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}

							if ((imgDisplay_arch_quad_l=="&nbsp;" || imgDisplay_arch_quad_l==null) && imgDisplay_arch_quad!=""){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";
								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
							}
						}
					}
				}	
			}
			if (code_desc_arr[1]=="U"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="L" &&		code_desc_arr[1]!="3" && code_desc_arr[1]!="1" && code_desc_arr[1]!="2" && code_desc_arr[1]!="4"){
					if ((imgDisplay_arch_quad_u=="" || imgDisplay_arch_quad_u=="null" || imgDisplay_arch_quad_u==null ) && (imgDisplay_arch_quad_u!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
									 
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_u="&nbsp;";

						if (imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_u=="&nbsp;"))	{
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_u+"</A>";

							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_u+"</td></tr></table>";

						}

						if (imgDisplay_arch_quad=="&nbsp;&nbsp;"){
						 //Commented by Sharon Crasta on 12/1/2008 for SCR #6755
						//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_u+"</A>";

						formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_u+"</td></tr></table>";


						}
						if ((imgDisplay_arch_quad_u=="&nbsp;") &&( imgDisplay_arch_quad_u=="null" ||  imgDisplay_arch_quad_u=="" || imgDisplay_arch_quad_u==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_u+"</A>";
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_u+"</td></tr></table>";
						}
						if (imgDisplay_arch_quad_u!="&nbsp;" ){
							if(imgDisplay_arch_quad_1=="" ||imgDisplay_arch_quad_2=="" ||imgDisplay_arch_quad_4=="" ){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";

								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}
						
							if ((imgDisplay_arch_quad_u=="&nbsp;" || imgDisplay_arch_quad_u==null) && imgDisplay_arch_quad!=""){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";

							  formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";

					
							}
						}
					}
				}	
			}
			if (code_desc_arr[1]=="3"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="L" &&		code_desc_arr[1]!="U" && code_desc_arr[1]!="1" && code_desc_arr[1]!="2" && code_desc_arr[1]!="4"){
					if ((imgDisplay_arch_quad_3=="" || imgDisplay_arch_quad_3=="null" || imgDisplay_arch_quad_3==null ) && (imgDisplay_arch_quad_3!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_3="&nbsp;";

						if (imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_3=="&nbsp;")){
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_3+"</A>";
								
							 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_3+"</td></tr></table>";

						}
						if (imgDisplay_arch_quad=="&nbsp;&nbsp;")	{
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_3+"</A>";
											
							 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_3+"</td></tr></table>";
						}
						if ((imgDisplay_arch_quad_3=="&nbsp;" && imgDisplay_arch_quad_3=="null" ||  imgDisplay_arch_quad_3=="" || imgDisplay_arch_quad_3==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
					  
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_3+"</A>";

							 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_3+"</td></tr></table>";
						}
						if (imgDisplay_arch_quad_3!="&nbsp;" ){
							if (imgDisplay_arch_quad_1=="" ||imgDisplay_arch_quad_2=="" ||imgDisplay_arch_quad_4=="" ){	  
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";
							   				
								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}
						
							if ((imgDisplay_arch_quad_3=="&nbsp;" || imgDisplay_arch_quad_3==null) && imgDisplay_arch_quad!=""){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";
							  							
								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
							}
						}
					}
				}	
			}
			if (code_desc_arr[1]=="2"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="L" &&		code_desc_arr[1]!="U" && code_desc_arr[1]!="1" && code_desc_arr[1]!="3" && code_desc_arr[1]!="4"){
					if ((imgDisplay_arch_quad_2=="" || imgDisplay_arch_quad_2=="null" || imgDisplay_arch_quad_2==null ) && (imgDisplay_arch_quad_2!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_2="&nbsp;";

						if(imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_2=="&nbsp;")){
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_2+"</A>";
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_2+"</td></tr></table>";
						}
						if (imgDisplay_arch_quad=="&nbsp;&nbsp;"){
							//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_2+"</A>";

							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_2+"</td></tr></table>";
						}

						//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
						/* if ((imgDisplay_arch_quad_2=="&nbsp;") ||( imgDisplay_arch_quad_2=="null" ||  imgDisplay_arch_quad_2=="" || imgDisplay_arch_quad_2==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_2+"</A>";	  */

						if ((imgDisplay_arch_quad_2=="&nbsp;") &&( imgDisplay_arch_quad_2=="null" ||  imgDisplay_arch_quad_2=="" || imgDisplay_arch_quad_2==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_2+"</td></tr></table>";
						}

						if (imgDisplay_arch_quad_2!="&nbsp;" ){
							if(imgDisplay_arch_quad_1=="" ||imgDisplay_arch_quad_3=="" ||imgDisplay_arch_quad_4=="" ){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";

								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}
							if ((imgDisplay_arch_quad_2=="&nbsp;" || imgDisplay_arch_quad_2==null) && imgDisplay_arch_quad!=""){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";

								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
							}
						}
					}
				}		
			}
			if (code_desc_arr[1]=="1"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="L" &&		code_desc_arr[1]!="U" && code_desc_arr[1]!="2" && code_desc_arr[1]!="3" && code_desc_arr[1]!="4"){
					if ((imgDisplay_arch_quad_1=="" || imgDisplay_arch_quad_1=="null" || imgDisplay_arch_quad_1==null ) && (imgDisplay_arch_quad_1!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
							 
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_1="&nbsp;";

						//Commented by sharon Crasta on 12/1/2008 for SCR #6755
						/*if (imgDisplay_arch_quad=="&nbsp;" || (imgDisplay_arch_quad_1=="&nbsp;"))	{
						document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_1+"</A>";	  */

						if (imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_1=="&nbsp;")){
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_1+"</td></tr></table>";

						}

						if (imgDisplay_arch_quad=="&nbsp;&nbsp;"){
							//Commented by sharon Crasta on 12/1/2008 for SCR #6755
							//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_1+"</A>";
							   
							 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_1+"</td></tr></table>";
						}

						if ((imgDisplay_arch_quad_1=="&nbsp;") &&( imgDisplay_arch_quad_1=="" || imgDisplay_arch_quad_1=="null" ||  imgDisplay_arch_quad_1==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
					  
							//Commented by sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_1+"</A>";
							
							 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_1+"</td></tr></table>";
						}

						if (imgDisplay_arch_quad_1!="&nbsp;" ){
							if (imgDisplay_arch_quad_2=="" ||imgDisplay_arch_quad_3=="" ||imgDisplay_arch_quad_4=="" ){
								//Commented by sharon Crasta on 12/1/2008 for SCR #6755
								//	document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";
											
								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}

							if ((imgDisplay_arch_quad_1=="&nbsp;" || imgDisplay_arch_quad_1==null) && imgDisplay_arch_quad!=""){
						 
								 //Commented by sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";

								 formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
							}
						}
					}
				}	
			}
			if (code_desc_arr[1]=="4"){
				if ((code_desc_arr[4]=="PERIO"||code_desc_arr[4]=="ORALCVT") && code_desc_arr[1]!="L" &&		code_desc_arr[1]!="U" && code_desc_arr[1]!="2" && code_desc_arr[1]!="3" && code_desc_arr[1]!="1"){
					if ((imgDisplay_arch_quad_4=="" || imgDisplay_arch_quad_4=="null" || imgDisplay_arch_quad_4==null ) && (imgDisplay_arch_quad_4!="&nbsp;") && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						imgDisplay_arch_quad+="&nbsp;";
						imgDisplay_arch_quad_4="&nbsp;";

						if (imgDisplay_arch_quad=="&nbsp;" && (imgDisplay_arch_quad_4=="&nbsp;"))	{
							//Commented by sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_4+"</A>";

							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_4+"</td></tr></table>";
						}
						if (imgDisplay_arch_quad=="&nbsp;&nbsp;"){
					  
							//Commented by sharon Crasta on 12/1/2008 for SCR #6755
							//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_4+"</A>";

							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_4+"</td></tr></table>";
						}

						//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
						/*if ((imgDisplay_arch_quad_4=="&nbsp;") ||( imgDisplay_arch_quad_4=="" || imgDisplay_arch_quad_4=="null" ||  imgDisplay_arch_quad_4==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
						document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad_4+"</A>";	*/

						if ((imgDisplay_arch_quad_4=="&nbsp;") && ( imgDisplay_arch_quad_4=="" || imgDisplay_arch_quad_4=="null" ||  imgDisplay_arch_quad_4==null )  && (imgDisplay_arch_quad!="" || imgDisplay_arch_quad!="null" || imgDisplay_arch_quad!=null)) {
							formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay_arch_quad_4+"</td></tr></table>";
						}

						if (imgDisplay_arch_quad_4!="&nbsp;" ){
							if (imgDisplay_arch_quad_1=="" ||imgDisplay_arch_quad_3=="" ||imgDisplay_arch_quad_4=="" ){
							 
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">&nbsp;</A>";

								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">&nbsp;</td></tr></table>";
							}
							if ((imgDisplay_arch_quad_4=="&nbsp;" || imgDisplay_arch_quad_4==null) && imgDisplay_arch_quad!=""){
								//Commented by Sharon Crasta on 12/1/2008 for SCR #6755
								//document.getElementById(imageId).innerHTML = "<A style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\">"+imgDisplay_arch_quad+"</A>";

								formObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[3]+"','"+code_desc_arr[5]+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay_arch_quad+"</td></tr></table>";
							}
						}
					}
				}		
			}
			//end //added by parul for SCR#6115
	 
		}
		
		if(root_count >0){
			for(j=1;j<=root_count;j++){
				if(rootLineDisplayParams[j] != undefined && rootLineDisplayParams[j] != "undefined" && rootLineDisplayParams[j] != "" && rootLineDisplayParams[j] != "null" && rootLineDisplayParams[j] != null){	  
					var params_arr = rootLineDisplayParams[j].split("##");
				//	drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);
				 drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6],'','','','','',params_arr[12]);

				}
			}				
		}	
	}/*else{ //Added by Sridevi Joshi on 12/7/2009 for SUPRTH new changes
		var imgDisplay_others = "&nbsp;";
		imageId = tooth_no;

		if(tooth_no != ""  && tooth_no != "null" && tooth_no != null && tooth_no != "undefined" && tooth_no != undefined){
			formObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0 width=100% style='cursor:pointer' align='center' height='80%'><tr><td  width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures());\">"+imgDisplay_others+"</td></tr></table>"
		}
	}*/

}


//Added by sharon Crasta on 3/4/2009
//Added to get the Label depending on the tabs.
function getLabel1( tab_name,label_ref, moduleId, status, called_from) {
	var xmlHttp = "";
	if(navigator.appName.indexOf("Internet") ==-1)
		xmlHttp = new XMLHttpRequest();
	else
		xmlHttp= new XMLHttpRequest();;
	
	message_ref=label_ref.toUpperCase();
	moduleId = moduleId.toLowerCase();
	if(tab_name == "C"){
		xmlHttp.open("POST", "../../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId, false);
	}else if(tab_name == "T"){
		/*if(status == 10 || status == 15){
			xmlHttp.open("POST", "../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId, false);
		}else{
				xmlHttp.open("POST", "../../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId, false);
		}  */
		if(called_from == "servlet_menu"){
			xmlHttp.open("POST","../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId,false);
		}else{
		   xmlHttp.open("POST","../../eCommon/jsp/LabelContainer.jsp?labelId="+label_ref+"&moduleId="+moduleId,false);
		}
	
	}
	xmlHttp.setRequestHeader("Content-Type","text/html;charset=UTF-8")
	xmlHttp.send("");

	var xmlText = xmlHttp.responseText
	return(TrimStr(xmlText));
		    
}
//

//To get the images for a perticular tooth when you record a condition on that tooth.
function  getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFrameObj,called_from,super_tooth_ref,exfolth_count,retained_tooth_no,isSuprthError,total_SuperKey_count,super_recorded,isExfolthError,isRetainedError){
	var imageId = "";
	var imgDisplay = "&nbsp;";
	var j=0;
	var code_desc_arr;
	var concat = "";
	var concat_val = "";
	var count1 = 0;
	var count2 = 0;
	var status_int = 0;
	var show_RTDESTH_EXFOLTH_image_flag = "";
	var super_tooth_no = "";
	var super_tooth_count = "";

	//Added by Sharon Crasta on 11/28/2008 for SCR #6755
	var classId = "";
	//End
	
	
	var site_type = site_type;
	if(site_type == "QUAD"){
		imageId = "Q"+tooth_no;
		//Added by Sharon Crasta on 11/28/2008 for SCR #6755
		classId = "QUADRANT"; 
		//
	}
	else if(site_type == "ARCH"){
		imageId = "A"+tooth_no;
		//Added by Sharon Crasta on 11/28/2008 for SCR #6755
		classId = "ARCH";
		//
	}
	else{
		imageId = tooth_no;
	}


	/*if(super_tooth_ref == "s1"){
		super_tooth_no = tooth_no+"1";
	}else if(super_tooth_ref == "s2"){
		super_tooth_no = tooth_no+"2";
	}*/

	if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){ //Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
		super_tooth_count = super_tooth_ref.substring(1);
	}

	if(super_tooth_count != ""){//Added by SRidevi Joshi on 1/24/2010 for (CRF-481 )IN010894
		super_tooth_no = tooth_no+super_tooth_count;
	}

	var patient_id = formObj.patient_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var	permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var RD_Normal_yn = formObj.RD_Normal_yn.value;
	var	oh_chart_level = formObj.oh_chart_level.value;
	var	status = formObj.oh_status.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = "T";
	if(tab_name=="DC" || tab_name=="ET"){
		treatment_condition_tab_flag = "C";
	}
	if(super_tooth_ref == "RD" && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
		retained_tooth_no = "";
	}
	//added by parul becoz some time going as undefined
	if (exfolth_count=="undefined" || exfolth_count==undefined){
		exfolth_count="";
	}
	if (retained_tooth_no=="undefined" || retained_tooth_no==undefined){
		retained_tooth_no="";
	}//end
	var params = "patient_id="+patient_id+"&tooth_no="+tooth_no+"&site_type="+site_type+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&tab_name="+tab_name+"&oh_chart_level="+oh_chart_level+"&super_tooth_no="+super_tooth_no+"&exfolth_count="+exfolth_count+"&retained_tooth_no="+retained_tooth_no+"&status="+status+"&isSuprthError="+isSuprthError+"&total_SuperKey_count="+total_SuperKey_count+"&RD_Normal_yn="+RD_Normal_yn+"&super_recorded="+super_recorded+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&isExfolthError="+isExfolthError+"&isRetainedError="+isRetainedError;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(called_from == "servlet_menu"){
		xmlHttp.open("POST","../eOH/jsp/CommonImagesValidation.jsp?func_mode=getImageFromDB&"+params,false);
	}else{
		xmlHttp.open("POST","../../eOH/jsp/CommonImagesValidation.jsp?func_mode=getImageFromDB&"+params,false);
	}
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	//alert("retVal--------->"+retVal)
	if(retVal.length>1){
		if(site_type == "THRNG" || (site_type == "TOOTH" && tooth_no.indexOf(",") != -1)){				
			var retVal_arr = retVal.split("~");
			for(i=retVal_arr.length-2;i>=0;i--){
				code_desc_arr = retVal_arr[i].split("##");
				var status = code_desc_arr[4];
				/*	if (status == "60" || status == "85" ){//added by parul on 18/03/2010 for CRF-477(if u update the status from S to F ,code_desc_arr[12] was coming as S only)
						if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
							code_desc_arr[10]=formObj.oh_outcome.value;
						}
					}*/
				var alt_text = getLabel1(treatment_condition_tab_flag,"eOH.ImagesInfoTitleForChart.Label","OH",status,called_from);
				if(code_desc_arr[3] == "SUPRTH"){
					//commented and added by parul on 23/02/2010 for CRF-477 & 496 //imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','','',code_desc_arr[8],'',code_desc_arr[9],isSuprthError);
					imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','','',code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[7],'','',code_desc_arr[10],code_desc_arr[11],code_desc_arr[12]);

				}
				else if(code_desc_arr[1] == "undefined" || code_desc_arr[1] == null || code_desc_arr[1] == "null" || code_desc_arr[1] == ""){
						imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','',code_desc_arr[6],code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[7],'','',code_desc_arr[10],code_desc_arr[11],code_desc_arr[12]);
				}
				else{
						//imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','',code_desc_arr[6],code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[11]);
						imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','',code_desc_arr[6],code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[7],'','',code_desc_arr[10],code_desc_arr[11],code_desc_arr[12]);
					
				}

				var ind = concat.indexOf(":");

				if(code_desc_arr[0]!=null && code_desc_arr[0]!="null" && code_desc_arr[3] != "MISSTH" && code_desc_arr[3] != "IMPLANT" && code_desc_arr[3] != "EXTRACT" && code_desc_arr[3] != "DENTURE" && (code_desc_arr[0] != "" && code_desc_arr[0] != null && code_desc_arr[0] != "null") && code_desc_arr[6] == "N" &&(code_desc_arr[3] != "CROWN" && code_desc_arr[7] != "*A" )){// image_id will be null for ROOT and CROWN site_types
					// Placed this peace of code here which was at the bottom after else to get the images for supernumarary tooth
					if(code_desc_arr[1] == "undefined" || code_desc_arr[1] == null || code_desc_arr[1] == "null" || code_desc_arr[1] == ""){
							//imageReplace(code_desc_arr[3],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[4],formObj,code_desc_arr[6],'','',code_desc_arr[7],'',code_desc_arr[9],isSuprthError,code_desc_arr[7]);
						imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','',code_desc_arr[6],code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[7],'','',code_desc_arr[10],code_desc_arr[11],code_desc_arr[12]);
					}
					else{
							//imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,code_desc_arr[6],'','',code_desc_arr[7],'',code_desc_arr[9],isSuprthError,code_desc_arr[7]);
						imageReplace(code_desc_arr[3],code_desc_arr[1],dentalChartFrameObj,site_type,code_desc_arr[4],formObj,'','',code_desc_arr[6],code_desc_arr[8],'',code_desc_arr[9],isSuprthError,code_desc_arr[7],'','',code_desc_arr[10],code_desc_arr[11],code_desc_arr[12]);

					}
					status_int = parseInt(code_desc_arr[4]);
					if(code_desc_arr[3] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
						code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
					}
					
					if(ind != -1){
						concat_val = concat.split(":");
						for(j=0;j<concat_val.length-1;j++){
							if(concat_val[j] == code_desc_arr[1]){ // For the same area(Q,A,T)
								count1++;
								if(count1 >= 4){
									var imgDisplay_arr = imgDisplay.split("<img");
									var imgDisplay_temp = "";
									
									for(k=1;k<3;k++){
										imgDisplay_temp = imgDisplay_temp+"<img"+imgDisplay_arr[k];
									}
									imgDisplay = imgDisplay_temp + "..."
									
								}
								  //added by parul on 23/02/2010 for CRF-477

								//imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[0]+"'/>"+imgDisplay;
								imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer'  src='"+code_desc_arr[11]+"'/>"+imgDisplay;
								dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";
								break;

								
							}
							else{ // // For every next set of area
								count1=1;
								concat = code_desc_arr[1] + ":" ;
                              
							    //added by parul on 23/02/2010 for CRF-477
								//imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"' />";
								imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[11]+"' />";
								dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";
							}
						}
					}
					else{
						count1=1;
						concat = code_desc_arr[1] + ":" ;
                        //added by parul on 23/02/2010 for CRF-477
						//imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'/>";
						imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[11]+"'/>";
						dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";
					}
				}
				else{
					//if(code_desc_arr[0] == "" || code_desc_arr[0] == "null" || code_desc_arr[0] == null){
						concat = concat + code_desc_arr[1] + ":" ;
						if(ind != -1){
							concat_val = concat.split(":");
							
							for(j=0;j<concat_val.length-1;j++){
								if(concat_val[j] == code_desc_arr[1]){ // For the same area(Q,A,T)

									imgDisplay = imgDisplay+"&nbsp;";
									dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";

									break;
								}
								else{ 
									concat = code_desc_arr[1] + ":" ;

									imgDisplay = "&nbsp;";
									dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";
								}
							}
						}
						else{
							concat = code_desc_arr[1] + ":" ;
							imgDisplay = "&nbsp;";
							if(code_desc_arr[1] != "" && code_desc_arr[1] != "null" && code_desc_arr[1] != null){
								dentalChartFrameObj.document.getElementById(code_desc_arr[1]).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+code_desc_arr[1]+"','"+code_desc_arr[2]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\">"+imgDisplay+"</td></tr></table>";
							}
						}
					//}
					
					
				
					if(code_desc_arr[5] == "ROOT" && code_desc_arr[3] == "PERIINV"){
								drawCircleForRoot(code_desc_arr[1],code_desc_arr[7],dentalChartFrameObj,code_desc_arr[3],tab_name,code_desc_arr[1],code_desc_arr[4]);
					}

					if(code_desc_arr[5] == "ROOT" && code_desc_arr[3] != "PERIINV"){ 
							
						drawLineForRootImage('rootLayer'+code_desc_arr[1],code_desc_arr[7],dentalChartFrameObj,code_desc_arr[3],tab_name,code_desc_arr[1],code_desc_arr[4]);
					}

					if(code_desc_arr[5] == "CROWN"){ 
							fillCrownImages('toothLayer'+code_desc_arr[1],code_desc_arr[7],dentalChartFrameObj,code_desc_arr[3],code_desc_arr[4],code_desc_arr[1]);
						if (code_desc_arr[9]!="undefined" && code_desc_arr[9]!=undefined){							
						drawCircleForCusp(tooth_no,dentalChartFrameObj,code_desc_arr[3],code_desc_arr[9],code_desc_arr[4],tab_name);//added by parul for crf 0483 on 25/08/2009
						}
					}
					
				}
		//	}
		}
		
	}
		else if(site_type == "TOOTH" || site_type == "ROOT" || site_type == "CROWN"){
			if(retVal.length>0){
				var retVal_arr = retVal.split("~");
				for(m=retVal_arr.length-2;m>=0;m--){
					
					code_desc_arr = retVal_arr[m].split("##");
				
					
					if(code_desc_arr[2]=="RTDESTH"){ 
						// bshankar/FEB2008 done for Displaying the root/crown images when EXFOLTH is recorded for the 1st time after recording the RTDESTH.
						show_RTDESTH_EXFOLTH_image_flag=tooth_no+"RTDESTH";
					}else if(code_desc_arr[2]=="EXFOLTH" && show_RTDESTH_EXFOLTH_image_flag!=""){
						// bshankar/FEB2008 done for Displaying the root/crown images when EXFOLTH is recorded for the 1st time after recording the RTDESTH.
						show_RTDESTH_EXFOLTH_image_flag=show_RTDESTH_EXFOLTH_image_flag+"EXFOLTH";
					}

					if(site_type == "TOOTH"){ // Initialuze the flag
						if(show_RTDESTH_EXFOLTH_image_flag.indexOf(tooth_no+"RTDESTH")<0){ // Initialuze the flag
							show_RTDESTH_EXFOLTH_image_flag="";
						}
					}
					var status = code_desc_arr[3];
					//Added by sharon Crasta on 3/4/2009
					//var alt_text = getLabel("eOH.ImagesInfoTitleForChart.Label","OH");
					var alt_text = getLabel1(treatment_condition_tab_flag,"eOH.ImagesInfoTitleForChart.Label","OH",status,called_from);
					
					//if(code_desc_arr[0]!=null && code_desc_arr[0]!="null" && code_desc_arr[2] != "MISSTH" && code_desc_arr[2] != "IMPLANT" && code_desc_arr[2] != "EXTRACT" && code_desc_arr[0]!="" && (code_desc_arr[6] == "N" )&& code_desc_arr[2] != "DENTURE"){// image_id will be null for ROOT and CROWN site_types//parul 442
					
					if (code_desc_arr[4]!="*A" && code_desc_arr[2] == "CROWN"){//added by parul on 03/02/2010 for CRF-442
						code_desc_arr[0]="";
					}
					
					if(code_desc_arr[0]!=null && code_desc_arr[0]!="null" && code_desc_arr[2] != "MISSTH" && code_desc_arr[2] != "IMPLANT" && code_desc_arr[2] != "EXTRACT" && code_desc_arr[0]!="" && (code_desc_arr[6] == "N" )&& code_desc_arr[2] != "DENTURE" &&(code_desc_arr[2] != "CROWN" && code_desc_arr[4] != "*A" )){// image_id will be null for ROOT and CROWN site_types
					
						status_int = parseInt(code_desc_arr[3])
						if (status_int == "60" || status_int == "85" ){//added by parul on 18/03/2010 for CRF-477(if u update the status from S to F ,code_desc_arr[12] was coming as S only)
						if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
							code_desc_arr[12]=formObj.oh_outcome.value;
						}
					}
						if(code_desc_arr[2] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
							code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
						}
						//added by parul on 23/02/2010 for CRF-477
						//imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'  />"+imgDisplay;
						if(code_desc_arr[2] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
							code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
							imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'  />"+imgDisplay;

						}else{
							imgDisplay = "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[13]+"'  />"+imgDisplay;
						}
						count1++;
						if(count1 >= 4){
							var imgDisplay_arr = imgDisplay.split("<img");
							var imgDisplay_temp = "";
								for(k=1;k<=3;k++){
								imgDisplay_temp = imgDisplay_temp+"<img"+imgDisplay_arr[k];
							}
							imgDisplay = imgDisplay_temp + "..."
						}	
						//imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[7],'',code_desc_arr[11],isSuprthError,code_desc_arr[10],isExfolthError);
						imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[7],code_desc_arr[10],code_desc_arr[11],isSuprthError,code_desc_arr[4],isExfolthError,'',code_desc_arr[12],code_desc_arr[13],code_desc_arr[14]);

					}
					else{
						if(code_desc_arr[5] == "ROOT" || (code_desc_arr[5] == "CROWN" && code_desc_arr[4]!="*A" && (code_desc_arr[0]==null || code_desc_arr[0]=="null" || code_desc_arr[0]==""))){
							if (status_int == "60" || status_int == "85" ){//added by parul on 18/03/2010 for CRF-477(if u update the status from S to F ,code_desc_arr[12] was coming as S only)
								if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
									code_desc_arr[12]=formObj.oh_outcome.value;
								}
							}
						}
						if(code_desc_arr[0] == ""){
							imgDisplay = imgDisplay + "&nbsp;"
							
						}


						if(code_desc_arr[5] == "ROOT" && code_desc_arr[2] == "PERIINV"){ 
							drawCircleForRoot(tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],tab_name,tooth_no,code_desc_arr[3],super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);
						}

						if(code_desc_arr[5] == "ROOT" && code_desc_arr[2] != "PERIINV"){
							if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
								var xmlDoc = "" ;  
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForERUPTH&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);
								retVal = localTrimString(retVal); //chart_line_num of ERUPTH
								
								if(parseInt(retVal) < parseInt(code_desc_arr[8])){
									drawLineForRootImage('rootLayer'+tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],tab_name,tooth_no,code_desc_arr[3],super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);
								}
							}else{								
								
								drawLineForRootImage('rootLayer'+tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],tab_name,tooth_no,code_desc_arr[3],super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);

							}
						}
						
					//if(code_desc_arr[5] == "CROWN" && code_desc_arr[4]!="*A"){
					if(code_desc_arr[5] == "CROWN" && code_desc_arr[4]!="*A" && (code_desc_arr[0]==null || code_desc_arr[0]=="null" || code_desc_arr[0]=="")){
						 if (code_desc_arr[4].length>2){
							   var surface_ref_arr=code_desc_arr[4].split(",");
								for(var p=0;p<surface_ref_arr.length;p++){											   
									  fillCrownImages('toothLayer'+tooth_no,surface_ref_arr[p],dentalChartFrameObj,code_desc_arr[2],code_desc_arr[3],tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);
									drawCircleForCusp(tooth_no,dentalChartFrameObj,code_desc_arr[3],code_desc_arr[9],code_desc_arr[4],tab_name,'','','',total_SuperKey_count,super_recorded,code_desc_arr[12]);//added by	 parul for crf 0483 on 25/08/2009	
								}
						   }else{
									//fillCrownImages('toothLayer'+tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],code_desc_arr[3],tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);
									fillCrownImages('toothLayer'+tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],code_desc_arr[3],tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,code_desc_arr[12]);
									drawCircleForCusp(tooth_no,dentalChartFrameObj,code_desc_arr[3],code_desc_arr[9],code_desc_arr[4],tab_name,'','','',total_SuperKey_count,super_recorded,code_desc_arr[12]);//added by	 parul for crf 0483 on 25/08/2009	
						   }

							//fillCrownImages('toothLayer'+tooth_no,code_desc_arr[4],dentalChartFrameObj,code_desc_arr[2],code_desc_arr[3],tooth_no,'',super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded);
							//drawCircleForCusp(tooth_no,dentalChartFrameObj,code_desc_arr[3],code_desc_arr[9],code_desc_arr[4],tab_name,'','','');//added by	 parul for crf 0483 on 25/08/2009	
						}
					
						//imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[4],code_desc_arr[10],code_desc_arr[11],code_desc_arr[4]);
							imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[7],code_desc_arr[10],code_desc_arr[11],isSuprthError,code_desc_arr[4],isExfolthError,'',code_desc_arr[12],code_desc_arr[13],code_desc_arr[14])


							//imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,code_desc_arr[5],code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[7]);
					}
				}
			}else{
					if (status == "60" || status == "85" ){//added by parul on 18/03/2010 for CRF-477(if u update the status from S to F ,code_desc_arr[12] was coming as S only)
						if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
							code_desc_arr[12]=formObj.oh_outcome.value;
						}
					}
				imgDisplay = "&nbsp;"
				imageReplace(code_desc_arr[2],tooth_no,dentalChartFrameObj,site_type,code_desc_arr[3],formObj,'',show_RTDESTH_EXFOLTH_image_flag,code_desc_arr[6],code_desc_arr[7],code_desc_arr[10],code_desc_arr[11],isSuprthError,code_desc_arr[4],isExfolthError,'',code_desc_arr[12],code_desc_arr[13],code_desc_arr[14]);
			}
			//Added by Sharon Crasta on 10/30/2009 for IN012514
			//If Retained Deciduous is recorded, then on impaction the root and the crown were getting displayed.
			tooth_layer = "toothLayer"+tooth_no;
			root_layer = "rootLayer"+tooth_no; 
			//if(formObj.header_tab.value == "C"){//commented by parul on 24/11/2009 if u mark as error of recorded tooth trmt icon of tooth trmt was not gettng refreshed.
				if(document.getElementById(root_layer) != null && document.getElementById(root_layer) != "null" && document.getElementById(root_layer) != undefined && document.getElementById(root_layer) != "undefined" && document.getElementById(tooth_layer) != null && document.getElementById(tooth_layer) != "null" && document.getElementById(tooth_layer) != undefined && document.getElementById(tooth_layer) != "undefined"){
					dentalChartFrameObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" >"+imgDisplay+"</td></tr></table>";
				}
				else {
					if(code_desc_arr[2] == "IMPACT"){
						//Added to count the number of Implant treatments recorded in case of Retained.
						var count_implant = 0;
						var count_partillay = 0;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=IMPLANT";
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?func_mode=countTreatmentOnTooth&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_implant = trimString(xmlHttp.responseText);
						retVal_implant = localTrimString(retVal_implant);
						if(retVal_implant.length > 0 && parseInt(retVal_implant) > 0){ 
							var retVal_implant_arr = retVal_implant.split("##");
							count_implant = retVal_implant_arr[0];			
						}
                       //added by parul on 11/01/2010 for super changes (retained-->partially-->Impaction on permanent tooth, after impaction crown image was going)
						var xmlDoc = "" ;  
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=checkForPartially&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_partially = trimString(xmlHttp.responseText);
						retVal_partially = localTrimString(retVal_partially); //chart_line_num of Partially

						if(count_implant == 0 && retVal_partially==0){

							var imageId_tooth = "T"+tooth_no;
							dentalChartFrameObj.document.getElementById(imageId_tooth).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId_root = "R"+tooth_no;
							dentalChartFrameObj.document.getElementById(imageId_root).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}

						dentalChartFrameObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" >"+imgDisplay+"</td></tr></table>";
					}
					else{  //End

						dentalChartFrameObj.document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45' style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" >"+imgDisplay+"</td></tr></td></tr></table>";
					}
				}
			//}
		}
		else {
			var retVal_arr = retVal.split("~");
			for(k=0;k<retVal_arr.length-1;k++){
				code_desc_arr = retVal_arr[k].split("##");
				var status = code_desc_arr[1];
					if (status == "60" || status == "85" ){//added by parul on 18/03/2010 for CRF-477(if u update the status from S to F ,code_desc_arr[12] was coming as S only)
						if(formObj.oh_outcome != null && formObj.oh_outcome != "null"){
							code_desc_arr[12]=formObj.oh_outcome.value;
						}
					}
				//Added by sharon Crasta on 3/4/2009
				//var alt_text = getLabel("eOH.ImagesInfoTitleForChart.Label","OH");
				var alt_text = getLabel1(treatment_condition_tab_flag,"eOH.ImagesInfoTitleForChart.Label","OH",status,called_from);
				//
				if(code_desc_arr[0]!=null && code_desc_arr[0]!="null" && code_desc_arr[0]!="undefined" && code_desc_arr[0] != ""){
					if(code_desc_arr[0]==null || code_desc_arr[0]=="null" || code_desc_arr[0] == "" ){
						imgDisplay = imgDisplay + "&nbsp;"
					}
					else{
						if(count2 < 4 ){
							if(count2 == 3){
								imgDisplay = imgDisplay + "...";
							}
							else{
								status_int = parseInt(code_desc_arr[3]);
								if(code_desc_arr[2] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
									code_desc_arr[0] = "../../eOH/images/TRMT_Planned.gif";
								}
								//added by parul on 23/02/2010 for CRf-477
							//	imgDisplay = imgDisplay + "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'  />";
								if ((code_desc_arr[7]!=null && code_desc_arr[7]!="null") &&(code_desc_arr[2] == "DENTURE" || code_desc_arr[2] == "ORTHO")){
										if(code_desc_arr[9]=="E"){
											if (code_desc_arr[2] == "DENTURE"){
												if (code_desc_arr[8]!="F"){
													imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/DentureExternalTool.gif'>";
												}else{
													 imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/DentureExternalFailTool.gif'>";
												}
											}else if (code_desc_arr[2] == "ORTHO"){
												if (code_desc_arr[8]!="F"){
													imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/OrthoExternaTool.gif'>";
												}else{
													 imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/OrthoExternalFailTool.gif'>";
												}
											}
										
										}else{
											if(code_desc_arr[9]=="I"){
												if (code_desc_arr[2] == "DENTURE"){
													if (code_desc_arr[8]!="F"){
														imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/Denture_indicator.gif'>";
													}else{
														 imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/DentureFailTool.gif'>";
													}
												}else if (code_desc_arr[2] == "ORTHO"){
													if (code_desc_arr[8]!="F"){
														imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/Ortho.gif'>";
													}else{
														 imgDisplay = imgDisplay +"<img alt='"+alt_text+"'style='cursor:pointer'  src='../../eOH/images/Ortho_F.gif'>";
													}
												}
											}
										}
									}else{
										imgDisplay = imgDisplay + "<img alt='"+alt_text+"' style='cursor:pointer' src='"+code_desc_arr[0]+"'  />";
									}
							}
						}
						count2++;
					}

					//Commented by Sharon Crasta on 11/24/2008 for SCR #6755
					//dentalChartFrameObj.document.getElementById(imageId).innerHTML ="<a style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\"  >"+imgDisplay+"</a>";
					setTimeout("setTimeForImage()", 5000);
					dentalChartFrameObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay+"</td></tr></table>";

				}else{
					if(code_desc_arr[2]=="TOOTHTM"){
					}else{

						//  parul on 231008 for SCR#6115
						//added " if (count2==0) " To retain the images when condition/treatment is recorded (When one condition/treatment having an image is recorded and the other without image is recorded.)
						if (count2==0) {
							imgDisplay = "&nbsp;";
							 //Commented by Sharon Crasta on 11/28/2008	for SCR #6755
							 //dentalChartFrameObj.document.getElementById(imageId).innerHTML = "<a style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" >"+imgDisplay+"</a>";
							 setTimeout("setTimeForImage()", 5000);							
							 dentalChartFrameObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'><img src=\"../../eOH/images/spacer.gif\" height=\"16.5\" width=\"18\">"+imgDisplay+"</td></tr></table>";
						}else{
							//Commented by Sharon Crasta on 11/28/2008 for SCR #6755
							//	dentalChartFrameObj.document.getElementById(imageId).innerHTML = "<a style='cursor:pointer' onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"'));\" >"+imgDisplay+"</a>";
							setTimeout("setTimeForImage()", 5000);
							dentalChartFrameObj.document.getElementById(imageId).innerHTML ="<table border=\"0\"  width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"  onclick=\"eval(getDialogFeatures('"+site_type+"','"+patient_id+"','"+tooth_no+"','"+code_desc_arr[1]+"','"+tab_name+"','"+permanent_deciduous_flag+"','"+tooth_numbering_system+"','"+super_tooth_ref+"'));\" style='cursor:pointer'><tr><td class = '"+classId+"'>"+imgDisplay+"</td></tr></table>";
						}
					}
				}
			}
		}
	}
	
	//Added by SRidevi Joshi on 1/22/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
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
	
	if((isSuprthError == "Y" || isExfolthError == "Y") && retVal_SuperKey_arr.length > 1){
		//if(retVal_SuperKey_arr.length > 0){
			if(eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')") != null){
				eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
				eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
			}

			for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
				if(retVal_SuperKey_arr[y] != super_tooth_ref){
					if(eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
						eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
						eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
					}
				}
			}
		//}
	}
	else if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined && super_tooth_ref != "RD"){//Added by Sridevi Joshi on 1/22/2010 for IN010894
		if(eval("dentalChartFrameObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')") != null){
			eval("dentalChartFrameObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.backgroundColor = "gray";
			eval("dentalChartFrameObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.color = "white";
		}

		if(eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')") != null){
			eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
			eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
		}
		
		for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
			if(retVal_SuperKey_arr[y] != super_tooth_ref){
				if(eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
					eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
					eval("dentalChartFrameObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
				}
			}
		}
	}
	else if(super_tooth_ref == "RD"){
		if(eval("dentalChartFrameObj.document.getElementById('retained_font"+tooth_no+"')") != null){
			eval("dentalChartFrameObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "gray";
			eval("dentalChartFrameObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "white";
		}

		if(eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')") != null){
			eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
			eval("dentalChartFrameObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
		}
	}
}

function setTimeForImage(){}


function getCurrentDate(format, locale){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=getCurrentDate&format="+format+"&locale="+locale;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = trimString(xhr.responseText)
	return(xmlText);
}

function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new XMLHttpRequest();;
		}catch (othermicrosoft) {
			try {
				request= new XMLHttpRequest();;
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
} 

function checkAsOnDateNotGreaterThanActiveChartDate(asOnDate) 
{
	 var sys_date = new Date();
	 var month = sys_date.getMonth();
	 var year = sys_date.getFullYear();
	 var date = sys_date.getDate();
		
	 if(asOnDate != ""){
		 var asOnDateArray = asOnDate.split("/");
		  
		 var enteredDateObject =new Date(eval(asOnDateArray[2]), eval(asOnDateArray[1])-1, 
			 eval(asOnDateArray[0]));
		 var sysDateObject = new Date(eval(year),eval(month),eval(date));
		 if(Date.parse(enteredDateObject) < Date.parse(sysDateObject)){
				return true;
		}
		else {
			return false;
		}
	}
	return true;
}
