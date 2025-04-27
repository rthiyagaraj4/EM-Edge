var isPartiallyErupted = false;
var isErupted = false;
var isSuperYN = false;
var isSprRecorded = false;


function getStaticImageForHistory(){
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
	var chart_num  = formObj.chart_num.value;				  
	var patient_id = formObj.patient_id.value;
	//var locale = formObj.locale.value;
	var baseline_chart_yn = "N";
	var status_int = 0;
	var j = 0;
	
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var treatment_condition_tab_flag = "T";//formObj.header_tab.value;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_numbering_system="+tooth_numbering_system+"&treatment_condition_tab_flag="+treatment_condition_tab_flag+"&baseline_chart_yn="+baseline_chart_yn;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllImagesForHistory&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText); 
	//commented by sridevi for IN009202 (CRF-0455)on 11/08/2009 becoz not able to find out the place from where these values r comming...... added chart_line_num For ROOT in getAllImagesForHistory
	//var retVal = formObj.applyTrmts.value;
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
						
				if((code_desc_arr[0]!=null && code_desc_arr[0]!="null") || (code_desc_arr[4] == "TOOTHTM" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "EXTRACT"  || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "PERIINV" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "DENTURE" || (code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A"))){// image_id will be null for ROOT and CROWN site_types
					var imageId = "";
					var site_type="";
					if (code_desc_arr[3]=="CROWN"){
					site_type = code_desc_arr[3];
					}else{
					site_type = code_desc_arr[2];
					}
					
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
										break;
									}
									else{ // For every next set of area
										image_count=1;
										concat = concat + code_desc_arr[1] + ":"  ;
										//commented by parul on 04/03/2010 for CRF-477
										//imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
                                         	if (code_desc_arr[9]!=null && code_desc_arr[9]!="null"){
												if(code_desc_arr[10]=="E"){
													if (code_desc_arr[4] == "DENTURE"){
														if (code_desc_arr[8]!="F"){
															imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalTool.gif />";
														}else if (code_desc_arr[8]=="F"){
															 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalFailTool.gif />";
														}
													}else if (code_desc_arr[4] == "ORTHO"){
														if (code_desc_arr[8]!="F"){
															imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternaTool.gif />";
														}else if (code_desc_arr[8]=="F"){
															 imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternalFailTool.gif />";
														}
													}
												
												}else{
													if(code_desc_arr[10]=="I"){
														if (code_desc_arr[4] == "DENTURE"){
															if (code_desc_arr[8]!="F"){
																imgDisplay_arch_quad ="<img src=../../eOH/images/Denture_indicator.gif />";
															}else if (code_desc_arr[8]=="F"){
																 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureFailTool.gif />";
															}
														}else if (code_desc_arr[4] == "ORTHO"){
															if (code_desc_arr[8]!="F"){
																imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho.gif />";
															}else if (code_desc_arr[8]=="F"){
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
								//commented by parul on 04/03/2010 for CRF-477
								//imgDisplay_arch_quad = "<img src='"+code_desc_arr[0]+"'  />";
								if (code_desc_arr[9]!=null && code_desc_arr[9]!="null"){
											if(code_desc_arr[10]=="E"){
												if (code_desc_arr[4] == "DENTURE"){
													if (code_desc_arr[8]!="F"){
														imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalTool.gif />";
													}else if (code_desc_arr[8]=="F"){
														 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureExternalFailTool.gif />";
													}
												}else if (code_desc_arr[4] == "ORTHO"){
													if (code_desc_arr[8]!="F"){
														imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternaTool.gif />";
													}else if (code_desc_arr[8]=="F"){
														 imgDisplay_arch_quad ="<img src=../../eOH/images/OrthoExternalFailTool.gif />";
													}
												}
											
											}else{
												if(code_desc_arr[10]=="I"){
													if (code_desc_arr[4] == "DENTURE"){
														if (code_desc_arr[8]!="F"){
															imgDisplay_arch_quad ="<img src=../../eOH/images/Denture_indicator.gif />";
														}else if (code_desc_arr[8]=="F"){
															 imgDisplay_arch_quad ="<img src=../../eOH/images/DentureFailTool.gif />";
														}
													}else if (code_desc_arr[4] == "ORTHO"){
														if (code_desc_arr[8]!="F"){
															imgDisplay_arch_quad ="<img src=../../eOH/images/Ortho.gif />";
														}else if (code_desc_arr[8]=="F"){
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
					else if(site_type == "TOOTH" || site_type == "THRNG" || (site_type == "ROOT" && code_desc_arr[4]=="PERIINV") || (code_desc_arr[3] == "CROWN" && code_desc_arr[5] == "*A")){
						if(code_desc_arr[4] == "MISSTH" || code_desc_arr[4] == "UNERTH" || code_desc_arr[4] == "EXFOLTH" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "EXTRACT" || code_desc_arr[4] == "DECITH" || code_desc_arr[4] == "IMPLANT" || code_desc_arr[4] == "PARERTH" || code_desc_arr[4] == "RTDESTH" || code_desc_arr[4] == "SUPRTH" || code_desc_arr[4] == "ERUPTH" || code_desc_arr[4] == "IMPACTN" || code_desc_arr[4] == "BRIDGE" || code_desc_arr[4] == "DENTURE" ||(code_desc_arr[4] == "CROWN" && code_desc_arr[5] == "*A") ){ //29FEB bshankar
							imageReplaceForHistory(code_desc_arr[4],code_desc_arr[1],code_desc_arr[6],show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,code_desc_arr[7],code_desc_arr[8] ,code_desc_arr[9],code_desc_arr[10],code_desc_arr[11]);

						}
						if(site_type == "ROOT" && code_desc_arr[4]=="PERIINV"){
							drawCircleForRootHistory(code_desc_arr[1],"ALL",formObj,code_desc_arr[4],code_desc_arr[5],code_desc_arr[1],code_desc_arr[6]);
						}
						else if(code_desc_arr[4] != "MISSTH" && code_desc_arr[4] != "EXFOLTH" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "EXTRACT" && code_desc_arr[4] != "DECITH" && code_desc_arr[4] != "IMPLANT" && code_desc_arr[4] != "DENTURE" && code_desc_arr[4] != "RTDESTH" && code_desc_arr[4] != "ERUPTH" && code_desc_arr[7] == "N" &&(code_desc_arr[4] != "CROWN" && code_desc_arr[5] != "*A")){
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
										
										//	imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;

										if (code_desc_arr[10]!=null && code_desc_arr[10]!="null"){
                                          
											if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
												code_desc_arr[10] = "../../eOH/images/TRMT_Planned.gif";
											}										
												imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[10]+"'  />" + imgDisplay_tooth_thrng;
											}else{
										       imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />" + imgDisplay_tooth_thrng;
											}
											
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
										//imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"' />";

										if (code_desc_arr[10]!=null && code_desc_arr[10]!="null"){

											if(code_desc_arr[4] == "TOOTHTM" && status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
												code_desc_arr[10] = "../../eOH/images/TRMT_Planned.gif";
											}										
												imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[10]+"'  />" ;
											}else{
										       imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />";
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
								imgDisplay_tooth_thrng = "<img src='"+code_desc_arr[0]+"'  />";
								document.getElementById(imageId).innerHTML = "<table border=0 cellpadding=0 cellspacing=0><tr><td  width='45'><tr><td width='45'>"+imgDisplay_tooth_thrng+"</td></tr></table>";
							}	
						}
					}
				else if(site_type == "CROWN"){
					if(code_desc_arr[5]!="*A"){
						var ind_crown = crown_concat.indexOf(":");
						if(ind_crown != -1){
							concat_val = crown_concat.split(":");
							concat_cond_val = concat_cond_type.split(":");
							for(m=0;m<concat_val.length-1;m++){
								if(concat_val[m] == code_desc_arr[0]){ // For the same area(Q,A,T)
									if(code_desc_arr[3] != "" && concat_cond_val[m] != "" && concat_cond_val[m] == "PULPINV" && code_desc_arr[4] != "PULPINV"){
										cond_type = "PULPINV";
									}
									else{
										cond_type = code_desc_arr[4];
									}
                                       //added by parul on 04/02/2010 for CRF-442
									
									    if (code_desc_arr[5].length>2){
										 var surface_ref_arr=code_desc_arr[5].split(",");
										for(var p=0;p<surface_ref_arr.length;p++){											   
											   fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);

												drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
										}
									  }else{
											fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);
											drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
									  }
									//fillCrownImagesForHistory("toothLayer"+code_desc_arr[0],code_desc_arr[3],formObj,cond_type,code_desc_arr[6],code_desc_arr[0],permanent_deciduous_flag);
									//drawCircleForCuspHistory(code_desc_arr[0],formObj,code_desc_arr[6],code_desc_arr[7],code_desc_arr[3]);//added by	 parul for crf 0483 on 25/08/2009									
								}
								else{
									crown_concat = crown_concat + code_desc_arr[0] + ":"  ;
									concat_cond_type = concat_cond_type + code_desc_arr[4] + ":"  ;
									  //added by parul on 04/02/2010 for CRF-442
										  if (code_desc_arr[5].length>2){
										 var surface_ref_arr=code_desc_arr[5].split(",");
										for(var p=0;p<surface_ref_arr.length;p++){											   
											   fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);
												drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
										}
									  }else{
											fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);
											drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
									  }
									
								}
							}
						}
						else{
							crown_concat = code_desc_arr[0] + ":"  ;
							concat_cond_type = code_desc_arr[4] + ":"  ;
							  //added by parul on 04/02/2010 for CRF-442
								  if (code_desc_arr[5].length>2){
										 var surface_ref_arr=code_desc_arr[5].split(",");
										for(var p=0;p<surface_ref_arr.length;p++){											   
											   fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],surface_ref_arr[p],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);
												drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],surface_ref_arr[p],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
										}
									  }else{
											fillCrownImagesForHistory("toothLayer"+code_desc_arr[1],code_desc_arr[5],formObj,cond_type,code_desc_arr[7],code_desc_arr[1],permanent_deciduous_flag,code_desc_arr[9]);
											drawCircleForCuspHistory(code_desc_arr[1],formObj,code_desc_arr[7],code_desc_arr[8],code_desc_arr[5],code_desc_arr[9]);//added by	 parul for crf 0483 on 25/08/2009
									  }
								}
							}
					}else if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						/*root_count = parseInt(root_count);
						root_count++;
						
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];*/
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
							
							if(retVal < code_desc_arr[9]){
								rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+code_desc_arr[13];
							}
						}else{
								rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+code_desc_arr[13];
						}

					}
				}
				else{
					/*var site_type = code_desc_arr[2];
					if(site_type == "ROOT" && code_desc_arr[4]!="PERIINV"){
						root_count = parseInt(root_count);
						root_count++;
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6];
					}*/
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
						
						if(parseInt(retVal) < parseInt(code_desc_arr[9])){
							rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+code_desc_arr[13];
						}
					}else{
						rootLineDisplayParams[root_count] = "rootLayer"+code_desc_arr[1]+"##"+code_desc_arr[8]+"##"+formObj+"##"+code_desc_arr[4]+"##"+code_desc_arr[5]+"##"+code_desc_arr[1]+"##"+code_desc_arr[6]+"##"+code_desc_arr[13];
					}
				}	


				}
		}
		if(root_count >0){	
			/*for(j=1;j<=root_count;j++){				
				var params_arr = rootLineDisplayParams[j].split("##");
				drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6]);
			}	*/
			
			for(j=1;j<=root_count;j++){	
				if(rootLineDisplayParams[j] != undefined && rootLineDisplayParams[j] != "undefined" && rootLineDisplayParams[j] != "" && rootLineDisplayParams[j] != "null" && rootLineDisplayParams[j] != null){
					var params_arr = rootLineDisplayParams[j].split("##");
					drawLineForRootImage(params_arr[0],params_arr[1],formObj,params_arr[3],params_arr[4],params_arr[5],params_arr[6],params_arr[7]);
				}
			}	
		}			
	}
	return retVal;
	
	
}

function imageReplaceForHistory(condition_type,tooth_no,status,show_RTDESTH_EXFOLTH_image_flag,show_SUPRTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,trmt_outcome,image_source,treatment_int_ext){
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
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
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
						//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
						//formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no +"," + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'>";
						formObj.document.getElementById(check_num_id).innerHTML = "<font style='background-color:gray;color:white'>" + disply_tooth_no +"</font>," + tooth_num + "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'>";
					}
					else{//End
						if(tooth_no>=1 && tooth_no<=16 || (tooth_no>=33 && tooth_no<=42)){
							//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
							//formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
							formObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='0' cellspacing='0' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' border='0' usemap='#MapRUR" + tooth_no + "' /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' border='0' usemap= '#MapTUR1' /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><font style='background-color:gray;color:white'>" + disply_tooth_no + "<input type='hidden' name='normalTh' id='normalTh' value = 'N'"+tooth_no+"'></font>," + tooth_num + "<input type='hidden' name='RDTh' id='RDTh' value = 'RD'"+tooth_no+"'><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'></td></tr><tr><td align='center' height='36' id='"+tooth_no+"'><table border=0 cellpadding=0 cellspacing=0><tr><td width='45' ></td></tr></table></td></tr></table>";
						}
						else{
							//Commented by Sharon Crasta on 1/13/2010 for IN010894(SRR20056-CRF-0481) for new SUPRTH changes
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
			var super_cnt = 0;
			var super_main = "";
			var super_str = "";
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
			xmlHttp.open("POST","../../eOH/jsp/CommonValidation.jsp?"+params,false);
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
			xmlHttp.open("POST","../../eOH/jsp/CommonValidation.jsp?"+params,false);
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

			/*var Rd_flag_ind = "";
			if(mixed_dent_deciduous_yn == "M"){
				Rd_flag_ind = "MR";
			}
			else if(mixed_dent_deciduous_yn == "D"){
				Rd_flag_ind = "D";
			}

			formObj.document.getElementById(check_num_id).innerHTML = disply_tooth_no + "+<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'>";
			*/

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
			var other_chart_facility_id =document.forms[0].other_chart_facility_id.value;

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
			var params_bridge_extract = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=EXTRACT";

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

				if(isPartiallyErupted && count_exf == 1){
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


 function fillCrownImagesForHistory(imageLayer,image_side,dentalChartFormObj,condition_type,status,tooth_no,permanent_deciduous_flag,treatments_outcome){

	var fill_color = "";
	var status_int = 0;

	if(status != "E"){
		//status_int = parseInt(status);
		status_int = isNaN(status_int = parseInt(status)) ? 0 : status;
	}
	if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
	//if(dentalChartFormObj.document.getElementById(imageLayer)!=null  && dentalChartFormObj.document.getElementById(imageLayer)!="" && dentalChartFormObj.document.getElementById(imageLayer)!="null"){
		//Selecing the fill color according to the condition_type
		if(condition_type == "PULPINV"){
			if (treatments_outcome=="F"){
				fill_color = "BROWN"
				image_side = "BR";
			}else{
				fill_color = "red"
				image_side = "BR";
			}
		}
		
		else if(condition_type == "CARIES"){
			//fill_color = "black" // commented by parul on 11/08/2009 for CRF 0494 (To change color indicator for caries condition to Blue color )
			if (treatments_outcome=="F"){
				fill_color = "BROWN"
			}else{
				fill_color = "blue";
			}
			
		}
		else{
			if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
				if (treatments_outcome=="F"){
					fill_color = "BROWN"
				}else{
					fill_color = "YELLOW";
				}
			}
			//else if(status_int != 85){
			else if(status_int != 85){
				if (treatments_outcome=="F"){
					fill_color = "BROWN"
				}else{
					fill_color = "LIGHTGREEN";
				}
			}
		}

		//To retrieve the Arch...
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/CommonValidation.jsp?func_mode=getArchSno&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arch_sno = localTrimString(retVal);
		

		 // Surface Decoding
		/*
		if(image_side == 1){
			image_side  = "T";
		}
		else if(image_side == 2){
			image_side  = "T";
		}
		*/
		if(image_side == 1){
			if(arch_sno == "L"){
				image_side  = "B";
			}
			else if(arch_sno == "U"){
				image_side  = "T";
			}
		}
		else if(image_side == 2){
			if(arch_sno == "L"){
				image_side  = "B";
			}
			else if(arch_sno == "U"){
				image_side  = "T";
			}
		}
		else if(image_side == 3){
			image_side  = "L";
		}
		else if(image_side == 4){
			image_side  = "R";
		}
		/*
		else if(image_side == 5){
			image_side  = "B";
		}
		else if(image_side == 6){
			image_side  = "B";
		}
		*/
		else if(image_side == 5){
			if(arch_sno == "L"){
				image_side  = "T";
			}
		}
		else if(image_side == 6){
			if(arch_sno == "U"){
				image_side  = "B";
			}
		}
		else if(image_side == 7){
			image_side  = "BR";
		}
		else if(image_side == 8){
			image_side  = "BR";
		}
		else if(image_side == 9){
			image_side  = "RO";
		}
		else if(image_side == 10){
			image_side  = "LO";
		}
		//Added By Sharon Crasta on 7/20/2009 for IN010839
		else if(image_side == 15){	//Mesio Incisal
			image_side  = "RI";
		}
		else if(image_side == 16){	//Disto Incisal
			image_side  = "LI";
		}
		//
		//If status is marked as error, filling is done with while color to erase the filing. 
		if(status == 'E'){
			fill_color = "white";
			if(image_side == "BR" ||condition_type == "PULPINV"){
				image_side = "";
				fillRect(imageLayer,9,9,11,7,fill_color);
				fillRect(imageLayer,21,9,11,7,fill_color);
			}
		}
		//Crown and Root filling with co-ordinates.
		/*if(image_side=="T")
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
		else if(image_side=="L")
			fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
		else if(image_side=="B")
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
		else if(image_side=="R")
			fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
		else if(image_side=="RO")
			fillRect(imageLayer,21,9,11,7,fill_color);
		else if(image_side=="LO")
			fillRect(imageLayer,9,9,11,7,fill_color);
		else if(image_side=="BR"){
			fillRect(imageLayer,9,9,11,7,fill_color);
			fillRect(imageLayer,21,9,11,7,fill_color);
		}
		else if(image_side=="ALL"){
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
			fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
			fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);

			fillRect(imageLayer,21,9,11,7,fill_color);
			fillRect(imageLayer,9,9,11,7,fill_color);
		}  */
		var tooth_no_int = parseInt(tooth_no);
		//Crown and Root filling with co-ordinates.
		if(image_side=="T")
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
		else if(image_side=="L"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "9" || tooth_no == "10" || tooth_no == "11" ||tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21" || tooth_no == "22" || tooth_no == "23" || tooth_no == "24"){
			if(permanent_deciduous_flag == "P" ){
				if(parseInt(tooth_no_int) >= "9" && parseInt(tooth_no_int) <= "24"){
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);	
				}else{
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
								
				}
			}
			if(permanent_deciduous_flag == "D" ){
				if((tooth_no_int >= "38" && tooth_no_int <= "47") || (tooth_no_int >= "14" && tooth_no_int <= "19")) {
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}
			}
		}
		else if(image_side=="B")
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
		else if(image_side=="R"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "9" || tooth_no == "10" || tooth_no == "11" ||tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21" || tooth_no == "22" || tooth_no == "23" || tooth_no == "24"){
			 if(permanent_deciduous_flag == "P"){
				if(tooth_no_int >= "9" && tooth_no_int <= "24"){
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "38" && tooth_no_int <= "47")|| (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}
			}
		}else if(image_side=="RO"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21"){
			 if(permanent_deciduous_flag == "P"){
				//if(tooth_no_int >= "12" && tooth_no_int <= "21"){
				if((tooth_no_int >= "1" && tooth_no_int <= "5") || (tooth_no_int >= "28" && tooth_no_int <= "32")){
					fillRect(imageLayer,21,9,11,7,fill_color);
				}else{
					fillRect(imageLayer,9,9,11,7,fill_color);		
				}
			}
			
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "41" && tooth_no_int <= "44") || (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillRect(imageLayer,9,9,11,7,fill_color);
				}else{
				//
					fillRect(imageLayer,21,9,11,7,fill_color);		
				}
			}
		}else if(image_side=="LO"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN		
			//if(tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21"){
			 if(permanent_deciduous_flag == "P"){
			//	if(tooth_no_int >= "12" && tooth_no_int <= "21"){
				if((tooth_no_int >= "1" && tooth_no_int <= "5") || (tooth_no_int >= "28" && tooth_no_int <= "32")){
					fillRect(imageLayer,9,9,11,7,fill_color);					
				}
				else{
					fillRect(imageLayer,21,9,11,7,fill_color);		
					}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "41" && tooth_no_int <= "44")|| (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillRect(imageLayer,21,9,11,7,fill_color);		
				}else{
				//
					fillRect(imageLayer,9,9,11,7,fill_color);	
				}
			}
		}
		//Added by Sharon Crasta on 5/14/2009 for IN010839
		else if(image_side=="RI"){
			 if(permanent_deciduous_flag == "P"){
				if((tooth_no_int >= "6" && tooth_no_int <= "8")||(tooth_no_int >= "25" && tooth_no_int <= "27")){
					//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);	
				}else{
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);
				}
			}
			if(permanent_deciduous_flag == "D"){
				//if((tooth_no_int >= "35" && tooth_no_int <= "40")||(tooth_no_int >= "45" && tooth_no_int <= "50")){
				if((tooth_no_int >= "35" && tooth_no_int <= "37")||(tooth_no_int >= "48" && tooth_no_int <= "50")){
						//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);		

				}else{
				//
					fillRect(imageLayer,9,9,11,7,fill_color);		
				}
			}
		}else if(image_side=="LI"){
			 if(permanent_deciduous_flag == "P"){
				if((tooth_no_int >= "6" && tooth_no_int <= "8")||(tooth_no_int >= "25" && tooth_no_int <= "27")){ //1st,4th quadrant
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);
				}
				else{
					//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);//2nd,3rd quadrant
				}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "35" && tooth_no_int <= "37")||(tooth_no_int >= "48" && tooth_no_int <= "50")){
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);	
				}else{
				//
					fillRect(imageLayer,21,9,11,7,fill_color);	
				}
			}
		}else if(image_side=="BR"){
			//fillRect(imageLayer,9,9,23,7,fill_color);
			fillRect(imageLayer,9,9,11,7,fill_color);
			fillRect(imageLayer,21,9,11,7,fill_color);
		}
		else if(image_side=="ALL"){
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
			fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
			fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);

			fillRect(imageLayer,21,9,11,7,fill_color);
			fillRect(imageLayer,9,9,11,7,fill_color);
		}
	}
		
  }

 /* function getCoordinates(tooth_no,image_side){
	var x1=0;  var y1=0;
	var x2=0;  var y2=0;
	var coordinates = "";
	
	//Format is x1#y1#x2#y2
	if(tooth_no=="1") coordinates = "20#1#20#29";
	//if(tooth_no=="2"){ 
	//	if(image_side=="11")
	//		coordinates = "19#3#11#29"; // Yet to Finalize
	//	else if(image_side=="12")
	//		coordinates = "21#2#27#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "19#3#11#29#21#2#27#29"; // Yet to Finalize
	//	}
	//} 
	if(tooth_no=="2"){ 
		if(image_side=="12")
			//coordinates = "12#3#12#29"; // Yet to Finalize
			coordinates = "19#22#19#8";
		else if(image_side=="13")
			//coordinates = "19#3#21#23"; // Yet to Finalize
			coordinates = "21#2#27#29";
		else if(image_side=="14")
			//coordinates = "29#9#28#29"; // Yet to Finalize
			coordinates = "19#3#11#29";
		else if(image_side == "ALL"){
			coordinates = "19#22#19#8#21#2#27#29#19#3#11#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="3"){ 
		if(image_side=="12")
			coordinates = "12#3#12#29"; // Yet to Finalize
		else if(image_side=="13")
			coordinates = "19#3#21#23"; // Yet to Finalize
		else if(image_side=="14")
			coordinates = "29#9#28#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "12#3#12#29#19#3#21#23#29#9#28#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="4" || tooth_no=="33") coordinates = "19#1#22#29";
	if(tooth_no=="5" || tooth_no=="34") coordinates = "19#0#22#29";
	if(tooth_no=="6" || tooth_no=="35") coordinates = "17#1#21#29";
	if(tooth_no=="7" || tooth_no=="36") coordinates = "19#1#19#29";
	if(tooth_no=="8" || tooth_no=="37") coordinates = "21#1#19#29";
	if(tooth_no=="9"  || tooth_no=="38") coordinates = "19#1#21#29";
	if(tooth_no=="10"  || tooth_no=="39") coordinates = "19#0#21#29";
	if(tooth_no=="11" || tooth_no=="40") coordinates = "23#1#18#29";
	if(tooth_no=="12" || tooth_no=="41") coordinates = "21#1#20#29";
	if(tooth_no=="13" || tooth_no=="42") coordinates = "19#0#21#29";

	//if(tooth_no=="14"){ 
	//	if(image_side=="12")
	//		coordinates = "12#6#10#29"; // Yet to Finalize
	//	else if(image_side=="13")
	//		coordinates = "20#3#18#23"; // Yet to Finalize
	//	else if(image_side=="14")
	//		coordinates = "30#5#23#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "12#6#10#29#20#3#18#23#30#5#23#29"; // Yet to Finalize
	//	}
	//} 

	if(tooth_no=="14"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="12")
		if(image_side=="14")
			//coordinates = "12#6#10#29"; // Yet to Finalize
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			//coordinates = "20#3#18#23"; // Yet to Finalize
			 coordinates = "12#6#10#29";
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="14")
		else if(image_side=="12")
			//coordinates = "30#5#23#29"; // Yet to Finalize
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}

	//if(tooth_no=="15"){ 
	//	if(image_side=="13")
	//		coordinates = "18#4#15#29"; // Yet to Finalize
	//	else if(image_side=="12")
	//		coordinates = "25#6#27#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "18#4#15#29#25#6#27#29"; // Yet to Finalize
	//	}
	//} 
	if(tooth_no=="15"){ 
		if(image_side=="12")
			coordinates = "22#24#22#8";
		else if(image_side=="13")
			coordinates = "18#4#15#29";
		else if(image_side=="14")
			coordinates = "25#6#27#29";
		else if(image_side == "ALL"){
			coordinates = "22#24#22#8#18#4#15#29#25#6#27#29"; // Yet to Finalize	
		}
	}
	if(tooth_no=="16") coordinates = "19#1#21#29";
	//if(tooth_no=="17"){ 
	//	if(image_side=="11")
	//		coordinates = "8#5#23#29"; // Yet to Finalize
	//	else if(image_side=="12")
	//		coordinates = "24#4#27#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "8#5#23#29#24#4#27#29"; // Yet to Finalize
	//	}
	//}
	//if(tooth_no=="18"){ 
	//	if(image_side=="11")
	//		coordinates = "10#2#19#29"; // Yet to Finalize
	//	else if(image_side=="12")
	//		coordinates = "28#2#27#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "10#2#19#29#28#2#27#29"; // Yet to Finalize
	//	}
	//}
	//if(tooth_no=="19"){ 
	//	if(image_side=="11")
	//		coordinates = "10#2#15#29"; // Yet to Finalize
	//	else if(image_side=="12")
	//		coordinates = "26#2#30#29"; // Yet to Finalize
	//	else if(image_side == "ALL"){
	//		coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
	//	}
	//}  
	if(tooth_no=="17"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "8#5#23#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "24#4#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "8#5#23#29#24#4#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="18"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#19#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "28#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#19#29#28#2#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="19"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="20" || tooth_no=="43") coordinates = "18#1#23#29";
	if(tooth_no=="21" || tooth_no=="44") coordinates = "20#2#19#29";
	if(tooth_no=="22" || tooth_no=="45") coordinates = "20#2#19#29";
	if(tooth_no=="23" || tooth_no=="46") coordinates = "18#1#21#29";
	if(tooth_no=="24" || tooth_no=="47") coordinates = "18#1#23#29";
	if(tooth_no=="25" || tooth_no=="48") coordinates = "21#1#17#29";
	if(tooth_no=="26" || tooth_no=="49") coordinates = "20#1#19#29";
	if(tooth_no=="27" || tooth_no=="50") coordinates = "20#1#19#29";
	if(tooth_no=="28" || tooth_no=="51") coordinates = "20#1#19#29";
	if(tooth_no=="29" || tooth_no=="52") coordinates = "22#2#17#29";

	if(tooth_no=="30"){ 
		if(image_side=="11")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="31"){ 
		if(image_side=="11")
			coordinates = "18#2#12#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "28#2#22#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#2#12#29#28#2#22#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="32"){ 
		if(image_side=="11")
			coordinates = "18#3#13#28"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "28#2#22#28"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#13#28#28#2#22#28"; // Yet to Finalize
		}
	}
	if(tooth_no=="33" || tooth_no=="34"){ 
		if(image_side=="12")
			coordinates = "19#3#21#23";
		else if(image_side=="13")
			coordinates = "29#9#28#29";
		else if(image_side=="14")
			coordinates = "12#3#12#29";
		else if(image_side == "ALL"){
			coordinates = "19#3#21#23#29#9#28#29#12#3#12#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="41" || tooth_no=="42"){ 
		if(image_side=="14")
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			 coordinates = "12#6#10#29";
		else if(image_side=="12")
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}
	if(tooth_no=="43" || tooth_no=="44"){ 
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		else if(image_side=="18")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="51" || tooth_no=="52"){ 
		if(image_side=="18")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	return coordinates;
} */

function getCoordinates(tooth_no,image_side){
	var x1=0;  var y1=0;
	var x2=0;  var y2=0;
	var coordinates = "";
	
	//Format is x1#y1#x2#y2
	if(tooth_no=="1") coordinates = "20#1#20#29";
	if(tooth_no=="2"){ 
		//Commented by Sharon Crasta on 5/14/2009 for IN010839
		/*if(image_side=="11")
			coordinates = "19#3#11#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "21#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "19#3#11#29#21#2#27#29"; // Yet to Finalize
		} */
		//
		if(image_side=="12")
			//coordinates = "12#3#12#29"; // Yet to Finalize
			coordinates = "19#22#19#8";
		else if(image_side=="13")
			//coordinates = "19#3#21#23"; // Yet to Finalize
			coordinates = "21#2#27#29";
		else if(image_side=="14")
			//coordinates = "29#9#28#29"; // Yet to Finalize
			coordinates = "19#3#11#29";
		else if(image_side == "ALL"){
			coordinates = "19#22#19#8#21#2#27#29#19#3#11#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="3"){ 
		if(image_side=="12")
			//coordinates = "12#3#12#29"; // Yet to Finalize
			coordinates = "19#3#21#23";
		else if(image_side=="13")
			//coordinates = "19#3#21#23"; // Yet to Finalize
			coordinates = "29#9#28#29";
		else if(image_side=="14")
			//coordinates = "29#9#28#29"; // Yet to Finalize
			coordinates = "12#3#12#29";
		else if(image_side == "ALL"){
			coordinates = "19#3#21#23#29#9#28#29#12#3#12#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="4" || tooth_no=="33") coordinates = "19#1#22#29";
	if(tooth_no=="5" || tooth_no=="34") coordinates = "19#0#22#29";
	if(tooth_no=="6" || tooth_no=="35") coordinates = "17#1#21#29";
	if(tooth_no=="7" || tooth_no=="36") coordinates = "19#1#19#29";
	if(tooth_no=="8" || tooth_no=="37") coordinates = "21#1#19#29";
	if(tooth_no=="9"  || tooth_no=="38") coordinates = "19#1#21#29";
	if(tooth_no=="10"  || tooth_no=="39") coordinates = "19#0#21#29";
	if(tooth_no=="11" || tooth_no=="40") coordinates = "23#1#18#29";
	if(tooth_no=="12" || tooth_no=="41") coordinates = "21#1#20#29";
	if(tooth_no=="13" || tooth_no=="42") coordinates = "19#0#21#29";

	if(tooth_no=="14"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="12")
		if(image_side=="14")
			//coordinates = "12#6#10#29"; // Yet to Finalize
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			//coordinates = "20#3#18#23"; // Yet to Finalize
			 coordinates = "12#6#10#29";
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="14")
		else if(image_side=="12")
			//coordinates = "30#5#23#29"; // Yet to Finalize
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}
	if(tooth_no=="15"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="13")
		/*Commented by Sharon Crasta on 5/14/2009 for IN010839*/
		/*if(image_side=="12")
			coordinates = "18#4#15#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="13")
			coordinates = "25#6#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#4#15#29#25#6#27#29"; // Yet to Finalize	*/
		/*End*/
		if(image_side=="12")
			coordinates = "22#24#22#8";
		else if(image_side=="13")
			coordinates = "18#4#15#29";
		else if(image_side=="14")
			coordinates = "25#6#27#29";
		else if(image_side == "ALL"){
			coordinates = "22#24#22#8#18#4#15#29#25#6#27#29"; // Yet to Finalize	
		}
	}
	if(tooth_no=="16") coordinates = "19#1#21#29";
	if(tooth_no=="17"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "8#5#23#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "24#4#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "8#5#23#29#24#4#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="18"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#19#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "28#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#19#29#28#2#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="19"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="20" || tooth_no=="43") coordinates = "18#1#23#29";
	if(tooth_no=="21" || tooth_no=="44") coordinates = "20#2#19#29";
	if(tooth_no=="22" || tooth_no=="45") coordinates = "20#2#19#29";
	if(tooth_no=="23" || tooth_no=="46") coordinates = "18#1#21#29";
	if(tooth_no=="24" || tooth_no=="47") coordinates = "18#1#23#29";
	if(tooth_no=="25" || tooth_no=="48") coordinates = "21#1#17#29";
	if(tooth_no=="26" || tooth_no=="49") coordinates = "20#1#19#29";
	if(tooth_no=="27" || tooth_no=="50") coordinates = "20#1#19#29";
	if(tooth_no=="28" || tooth_no=="51") coordinates = "20#1#19#29";
	if(tooth_no=="29" || tooth_no=="52") coordinates = "22#2#17#29";

	if(tooth_no=="30"){ 
		if(image_side=="18")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="31"){ 
		if(image_side=="18")
			coordinates = "18#2#12#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "28#2#22#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#2#12#29#28#2#22#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="32"){ 
		if(image_side=="18")
			coordinates = "18#3#13#28"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "28#2#22#28"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#13#28#28#2#22#28"; // Yet to Finalize
		}
	}

	//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
	if(tooth_no=="33" || tooth_no=="34"){ 
		if(image_side=="12")
			coordinates = "19#3#21#23";
		else if(image_side=="13")
			coordinates = "29#9#28#29";
		else if(image_side=="14")
			coordinates = "12#3#12#29";
		else if(image_side == "ALL"){
			coordinates = "19#3#21#23#29#9#28#29#12#3#12#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="41" || tooth_no=="42"){ 
		if(image_side=="14")
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			 coordinates = "12#6#10#29";
		else if(image_side=="12")
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}
	if(tooth_no=="43" || tooth_no=="44"){ 
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		else if(image_side=="18")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="51" || tooth_no=="52"){ 
		if(image_side=="18")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	return coordinates;
}

function drawLineForRootImage(imageLayer,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status,treatments_outcome){

	var status_int = 0;
	status_int = parseInt(status);
	
	if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		var color = "";
		if (treatments_outcome=="F"){
				color="BROWN";
		}else{
			if((tab_name=="DC" || tab_name=="C") && condition_type=="ROOTINV"){
				color="RED";
			}
			else if(condition_type=="ROOTINV"){
				color="RED";
			}
			else if(tab_name=="ET"){
				color="LIGHTGREEN";
			}
			else if(tab_name == "T" && (status_int == 60)){
				color="LIGHTGREEN";
			}
			else if((tab_name=="ET" && condition_type=="ROOTTMT") || (tab_name=="T" && condition_type=="ROOTTMT" && status_int == 60)){
				color="LIGHTGREEN";
			}
			else if(tab_name == "T" && (isNaN(status))){
				color="LIGHTGREEN";
			}
					

			if(status == 'E'){
				color = "WHITE";
			}
			else if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
				color="YELLOW";
			}
		}

		var x1=0;  var y1=0;
		var x2=0;  var y2=0;
		x1=20; y1=1; x2=20; y2=30;
		var coordinates = getCoordinates(tooth_no,image_side);
		//var coordinates = "10#7#12#4#14#6#14#11#14#16#15#20#20#23#22#24#22#29#19#30#16#29#13#30#11#25#10#21#10#15#10#9";
		var corrd_arr = coordinates.split("#");
		x1=parseInt(corrd_arr[0]); 
		y1=parseInt(corrd_arr[1]); 
		x2=parseInt(corrd_arr[2]); 
		y2=parseInt(corrd_arr[3]); 
		

		if(color != "" && color != null && color != "null" && color != "undefined"){
			drawLineForRoot(imageLayer,x1,y1,x2,y2,color); //	18 Line Coordinates of R1: 18,0,22,34
			drawLineForRoot(imageLayer,(x1+1),y1,(x2+1),y2,color); // Draw an adjacent line to make it dark line
		}
	}
  }

  function drawCircleForRootHistory(tooth_no,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status){

	  var imageLayer = "rootLayer"+tooth_no;
	  var color = "red";

	  if(status == 'E'){
			color = "WHITE";
		}
	  if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		//if((tooth_no >= 1 && tooth_no <= 16 ) || (tooth_no >= 33 && tooth_no <= 43)){//commented by parul on 26/04/2010 for IN020918
		  if((tooth_no >= 1 && tooth_no <= 16 ) || (tooth_no >= 33 && tooth_no <= 42)){
			 var coordinates = "7#1#25#8";  // For Upper Arch
		  }
		  else{
			   var coordinates = "7#20#25#12"; // For Lower Arch
		  }
		  var corrd_arr = coordinates.split("#");
		  x1=parseInt(corrd_arr[0]); 
		  y1=parseInt(corrd_arr[1]); 
		  x2=parseInt(corrd_arr[2]); 
		  y2=parseInt(corrd_arr[3]); 

		  
		  drawCircle(imageLayer,x1,y1,x2,y2,color);
		  drawCircle(imageLayer,(x1+1),y1,(x2),y2,color);
		  drawCircle(imageLayer,(x1+2),y1,(x2),y2,color);
	  }

  }
var shapesArray=new Array()

function fillPolygon(imageLayer, xCords,yCords, color,shapeId){
	//var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var obj = parent.DisplayResult;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	imageGraphics.setPrintable(true);
	imageGraphics.setColor(color)
	imageGraphics.HistFillPolygon(xCords,yCords);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

function clearShape(shapeId){
	shapesArray[shapeId].clear();
}

function fillRect(imageLayer, x,y,height,width,color,shapeId){
	var imageGraphics =new jsGraphics(imageLayer);
	imageGraphics.setPrintable(true);
	imageGraphics.setColor(color)
	imageGraphics.HistFillRect(x,y,height,width);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

function drawLineForRoot(imageLayer,x,y,w,h,color){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	imageGraphics.setPrintable(true);
	imageGraphics.setColor(color)
	imageGraphics.drawLine(x,y,w,h);
	imageGraphics.paint();
}

function drawCircle(imageLayer, x,y,height,width,color,shapeId){
	var imageGraphics =new jsGraphics(imageLayer);
	imageGraphics.setPrintable(true);
	imageGraphics.setColor(color)
	imageGraphics.HistDrawEllipse(x,y,height,width);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}



//Functions from FillImages.js

var jg_ok, jg_ie, jg_fast, jg_dom, jg_moz;


function chkDHTM(x, i)
{
	x = document.body || null;
	jg_ie = x && typeof x.insertAdjacentHTML != "undefined" && document.createElement;
	jg_dom = (x && !jg_ie &&
		typeof x.appendChild != "undefined" &&
		typeof document.createRange != "undefined" &&
		typeof (i = document.createRange()).setStartBefore != "undefined" &&
		typeof i.createContextualFragment != "undefined");
	jg_fast = jg_ie && document.all && !window.opera;
	jg_moz = jg_dom && typeof x.style.MozOpacity != "undefined";
	jg_ok = !!(jg_ie || jg_dom);
}

function pntCnvDom()
{
	var x = this.wnd.document.createRange();
	x.setStartBefore(this.cnv);
	x = x.createContextualFragment(jg_fast? this.htmRpc() : this.htm);
	if(this.cnv) this.cnv.appendChild(x);
	this.htm = "";
}

function pntCnvIe()
{
	if(this.cnv) this.cnv.insertAdjacentHTML("BeforeEnd", jg_fast? this.htmRpc() : this.htm);
	this.htm = "";
}

function pntDoc()
{
	this.wnd.document.write(jg_fast? this.htmRpc() : this.htm);
	this.htm = '';
}

function pntN()
{
	;
}

function mkDiv(x, y, w, h)
{
	this.htm += '<div style="position:absolute;'+
		'left:' + x + 'px;'+
		'top:' + y + 'px;'+
		'width:' + w + 'px;'+
		'height:' + h + 'px;'+
		'clip:rect(0,'+w+'px,'+h+'px,0);'+
		'background-color:' + this.color +
		(!jg_moz? ';overflow:hidden' : '')+
		';"><\/div>';
}

function mkDivIe(x, y, w, h)
{
	this.htm += '%%'+this.color+';'+x+';'+y+';'+w+';'+h+';';
}

function mkDivPrt(x, y, w, h)
{
	this.htm += '<div style="position:absolute;'+
		'border-left:' + w + 'px solid ' + this.color + ';'+
		'left:' + x + 'px;'+
		'top:' + y + 'px;'+
		'width:0px;'+
		'height:' + h + 'px;'+
		'clip:rect(0,'+w+'px,'+h+'px,0);'+
		'background-color:' + this.color +
		(!jg_moz? ';overflow:hidden' : '')+
		';"><\/div>';
}

var regex =  /%%([^;]+);([^;]+);([^;]+);([^;]+);([^;]+);/g;
function htmRpc()
{
	return this.htm.replace(
		regex,
		'<div style="overflow:hidden;position:absolute;background-color:'+
		'$1;left:$2;top:$3;width:$4;height:$5"></div>\n');
}

function htmPrtRpc()
{
	return this.htm.replace(
		regex,
		'<div style="overflow:hidden;position:absolute;background-color:'+
		'$1;left:$2;top:$3;width:$4;height:$5;border-left:$4px solid $1"></div>\n');
}

function mkLin(x1, y1, x2, y2)
{
	if(x1 > x2)
	{
		var _x2 = x2;
		var _y2 = y2;
		x2 = x1;
		y2 = y1;
		x1 = _x2;
		y1 = _y2;
	}
	var dx = x2-x1, dy = Math.abs(y2-y1),
	x = x1, y = y1,
	yIncr = (y1 > y2)? -1 : 1;

	if(dx >= dy)
	{
		var pr = dy<<1,
		pru = pr - (dx<<1),
		p = pr-dx,
		ox = x;
		while(dx > 0)
		{--dx;
			++x;
			if(p > 0)
			{
				this.mkDiv(ox, y, x-ox, 1);
				y += yIncr;
				p += pru;
				ox = x;
			}
			else p += pr;
		}
		this.mkDiv(ox, y, x2-ox+1, 1);
	}

	else
	{
		var pr = dx<<1,
		pru = pr - (dy<<1),
		p = pr-dy,
		oy = y;
		if(y2 <= y1)
		{
			while(dy > 0)
			{--dy;
				if(p > 0)
				{
					this.mkDiv(x++, y, 1, oy-y+1);
					y += yIncr;
					p += pru;
					oy = y;
				}
				else
				{
					y += yIncr;
					p += pr;
				}
			}
			this.mkDiv(x2, y2, 1, oy-y2+1);
		}
		else
		{
			while(dy > 0)
			{--dy;
				y += yIncr;
				if(p > 0)
				{
					this.mkDiv(x++, oy, 1, y-oy);
					p += pru;
					oy = y;
				}
				else p += pr;
			}
			this.mkDiv(x2, oy, 1, y2-oy+1);
		}
	}
}

function mkLin2D(x1, y1, x2, y2)
{
	if(x1 > x2)
	{
		var _x2 = x2;
		var _y2 = y2;
		x2 = x1;
		y2 = y1;
		x1 = _x2;
		y1 = _y2;
	}
	var dx = x2-x1, dy = Math.abs(y2-y1),
	x = x1, y = y1,
	yIncr = (y1 > y2)? -1 : 1;

	var s = this.stroke;
	if(dx >= dy)
	{
		if(dx > 0 && s-3 > 0)
		{
			var _s = (s*dx*Math.sqrt(1+dy*dy/(dx*dx))-dx-(s>>1)*dy) / dx;
			_s = (!(s-4)? Math.ceil(_s) : Math.round(_s)) + 1;
		}
		else var _s = s;
		var ad = Math.ceil(s/2);

		var pr = dy<<1,
		pru = pr - (dx<<1),
		p = pr-dx,
		ox = x;
		while(dx > 0)
		{--dx;
			++x;
			if(p > 0)
			{
				this.mkDiv(ox, y, x-ox+ad, _s);
				y += yIncr;
				p += pru;
				ox = x;
			}
			else p += pr;
		}
		this.mkDiv(ox, y, x2-ox+ad+1, _s);
	}

	else
	{
		if(s-3 > 0)
		{
			var _s = (s*dy*Math.sqrt(1+dx*dx/(dy*dy))-(s>>1)*dx-dy) / dy;
			_s = (!(s-4)? Math.ceil(_s) : Math.round(_s)) + 1;
		}
		else var _s = s;
		var ad = Math.round(s/2);

		var pr = dx<<1,
		pru = pr - (dy<<1),
		p = pr-dy,
		oy = y;
		if(y2 <= y1)
		{
			++ad;
			while(dy > 0)
			{--dy;
				if(p > 0)
				{
					this.mkDiv(x++, y, _s, oy-y+ad);
					y += yIncr;
					p += pru;
					oy = y;
				}
				else
				{
					y += yIncr;
					p += pr;
				}
			}
			this.mkDiv(x2, y2, _s, oy-y2+ad);
		}
		else
		{
			while(dy > 0)
			{--dy;
				y += yIncr;
				if(p > 0)
				{
					this.mkDiv(x++, oy, _s, y-oy+ad);
					p += pru;
					oy = y;
				}
				else p += pr;
			}
			this.mkDiv(x2, oy, _s, y2-oy+ad+1);
		}
	}
}

function mkLinDott(x1, y1, x2, y2)
{
	if(x1 > x2)
	{
		var _x2 = x2;
		var _y2 = y2;
		x2 = x1;
		y2 = y1;
		x1 = _x2;
		y1 = _y2;
	}
	var dx = x2-x1, dy = Math.abs(y2-y1),
	x = x1, y = y1,
	yIncr = (y1 > y2)? -1 : 1,
	drw = true;
	if(dx >= dy)
	{
		var pr = dy<<1,
		pru = pr - (dx<<1),
		p = pr-dx;
		while(dx > 0)
		{--dx;
			if(drw) this.mkDiv(x, y, 1, 1);
			drw = !drw;
			if(p > 0)
			{
				y += yIncr;
				p += pru;
			}
			else p += pr;
			++x;
		}
	}
	else
	{
		var pr = dx<<1,
		pru = pr - (dy<<1),
		p = pr-dy;
		while(dy > 0)
		{--dy;
			if(drw) this.mkDiv(x, y, 1, 1);
			drw = !drw;
			y += yIncr;
			if(p > 0)
			{
				++x;
				p += pru;
			}
			else p += pr;
		}
	}
	if(drw) this.mkDiv(x, y, 1, 1);
}

function mkOv(left, top, width, height)
{
	var a = (++width)>>1, b = (++height)>>1,
	wod = width&1, hod = height&1,
	cx = left+a, cy = top+b,
	x = 0, y = b,
	ox = 0, oy = b,
	aa2 = (a*a)<<1, aa4 = aa2<<1, bb2 = (b*b)<<1, bb4 = bb2<<1,
	st = (aa2>>1)*(1-(b<<1)) + bb2,
	tt = (bb2>>1) - aa2*((b<<1)-1),
	w, h;
	while(y > 0)
	{
		if(st < 0)
		{
			st += bb2*((x<<1)+3);
			tt += bb4*(++x);
		}
		else if(tt < 0)
		{
			st += bb2*((x<<1)+3) - aa4*(y-1);
			tt += bb4*(++x) - aa2*(((y--)<<1)-3);
			w = x-ox;
			h = oy-y;
			if((w&2) && (h&2))
			{
				this.mkOvQds(cx, cy, x-2, y+2, 1, 1, wod, hod);
				this.mkOvQds(cx, cy, x-1, y+1, 1, 1, wod, hod);
			}
			else this.mkOvQds(cx, cy, x-1, oy, w, h, wod, hod);
			ox = x;
			oy = y;
		}
		else
		{
			tt -= aa2*((y<<1)-3);
			st -= aa4*(--y);
		}
	}
	w = a-ox+1;
	h = (oy<<1)+hod;
	y = cy-oy;
	this.mkDiv(cx-a, y, w, h);
	this.mkDiv(cx+ox+wod-1, y, w, h);
}

function mkOv2D(left, top, width, height)
{
	var s = this.stroke;
	width += s+1;
	height += s+1;
	var a = width>>1, b = height>>1,
	wod = width&1, hod = height&1,
	cx = left+a, cy = top+b,
	x = 0, y = b,
	aa2 = (a*a)<<1, aa4 = aa2<<1, bb2 = (b*b)<<1, bb4 = bb2<<1,
	st = (aa2>>1)*(1-(b<<1)) + bb2,
	tt = (bb2>>1) - aa2*((b<<1)-1);

	if(s-4 < 0 && (!(s-2) || width-51 > 0 && height-51 > 0))
	{
		var ox = 0, oy = b,
		w, h,
		pxw;
		while(y > 0)
		{
			if(st < 0)
			{
				st += bb2*((x<<1)+3);
				tt += bb4*(++x);
			}
			else if(tt < 0)
			{
				st += bb2*((x<<1)+3) - aa4*(y-1);
				tt += bb4*(++x) - aa2*(((y--)<<1)-3);
				w = x-ox;
				h = oy-y;

				if(w-1)
				{
					pxw = w+1+(s&1);
					h = s;
				}
				else if(h-1)
				{
					pxw = s;
					h += 1+(s&1);
				}
				else pxw = h = s;
				this.mkOvQds(cx, cy, x-1, oy, pxw, h, wod, hod);
				ox = x;
				oy = y;
			}
			else
			{
				tt -= aa2*((y<<1)-3);
				st -= aa4*(--y);
			}
		}
		this.mkDiv(cx-a, cy-oy, s, (oy<<1)+hod);
		this.mkDiv(cx+a+wod-s, cy-oy, s, (oy<<1)+hod);
	}

	else
	{
		var _a = (width-(s<<1))>>1,
		_b = (height-(s<<1))>>1,
		_x = 0, _y = _b,
		_aa2 = (_a*_a)<<1, _aa4 = _aa2<<1, _bb2 = (_b*_b)<<1, _bb4 = _bb2<<1,
		_st = (_aa2>>1)*(1-(_b<<1)) + _bb2,
		_tt = (_bb2>>1) - _aa2*((_b<<1)-1),

		pxl = new Array(),
		pxt = new Array(),
		_pxb = new Array();
		pxl[0] = 0;
		pxt[0] = b;
		_pxb[0] = _b-1;
		while(y > 0)
		{
			if(st < 0)
			{
				pxl[pxl.length] = x;
				pxt[pxt.length] = y;
				st += bb2*((x<<1)+3);
				tt += bb4*(++x);
			}
			else if(tt < 0)
			{
				pxl[pxl.length] = x;
				st += bb2*((x<<1)+3) - aa4*(y-1);
				tt += bb4*(++x) - aa2*(((y--)<<1)-3);
				pxt[pxt.length] = y;
			}
			else
			{
				tt -= aa2*((y<<1)-3);
				st -= aa4*(--y);
			}

			if(_y > 0)
			{
				if(_st < 0)
				{
					_st += _bb2*((_x<<1)+3);
					_tt += _bb4*(++_x);
					_pxb[_pxb.length] = _y-1;
				}
				else if(_tt < 0)
				{
					_st += _bb2*((_x<<1)+3) - _aa4*(_y-1);
					_tt += _bb4*(++_x) - _aa2*(((_y--)<<1)-3);
					_pxb[_pxb.length] = _y-1;
				}
				else
				{
					_tt -= _aa2*((_y<<1)-3);
					_st -= _aa4*(--_y);
					_pxb[_pxb.length-1]--;
				}
			}
		}

		var ox = -wod, oy = b,
		_oy = _pxb[0],
		l = pxl.length,
		w, h;
		for(var i = 0; i < l; i++)
		{
			if(typeof _pxb[i] != "undefined")
			{
				if(_pxb[i] < _oy || pxt[i] < oy)
				{
					x = pxl[i];
					this.mkOvQds(cx, cy, x, oy, x-ox, oy-_oy, wod, hod);
					ox = x;
					oy = pxt[i];
					_oy = _pxb[i];
				}
			}
			else
			{
				x = pxl[i];
				this.mkDiv(cx-x, cy-oy, 1, (oy<<1)+hod);
				this.mkDiv(cx+ox+wod, cy-oy, 1, (oy<<1)+hod);
				ox = x;
				oy = pxt[i];
			}
		}
		this.mkDiv(cx-a, cy-oy, 1, (oy<<1)+hod);
		this.mkDiv(cx+ox+wod, cy-oy, 1, (oy<<1)+hod);
	}
}

function mkOvDott(left, top, width, height)
{
	var a = (++width)>>1, b = (++height)>>1,
	wod = width&1, hod = height&1, hodu = hod^1,
	cx = left+a, cy = top+b,
	x = 0, y = b,
	aa2 = (a*a)<<1, aa4 = aa2<<1, bb2 = (b*b)<<1, bb4 = bb2<<1,
	st = (aa2>>1)*(1-(b<<1)) + bb2,
	tt = (bb2>>1) - aa2*((b<<1)-1),
	drw = true;
	while(y > 0)
	{
		if(st < 0)
		{
			st += bb2*((x<<1)+3);
			tt += bb4*(++x);
		}
		else if(tt < 0)
		{
			st += bb2*((x<<1)+3) - aa4*(y-1);
			tt += bb4*(++x) - aa2*(((y--)<<1)-3);
		}
		else
		{
			tt -= aa2*((y<<1)-3);
			st -= aa4*(--y);
		}
		if(drw && y >= hodu) this.mkOvQds(cx, cy, x, y, 1, 1, wod, hod);
		drw = !drw;
	}
}

function mkRect(x, y, w, h)
{
	var s = this.stroke;
	this.mkDiv(x, y, w, s);
	this.mkDiv(x+w, y, s, h);
	this.mkDiv(x, y+h, w+s, s);
	this.mkDiv(x, y+s, s, h-s);
}

function mkRectDott(x, y, w, h)
{
	this.drawLine(x, y, x+w, y);
	this.drawLine(x+w, y, x+w, y+h);
	this.drawLine(x, y+h, x+w, y+h);
	this.drawLine(x, y, x, y+h);
}
function jsgFont()
{
	this.PLAIN = 'font-weight:normal;';
	this.BOLD = 'font-weight:bold;';
	this.ITALIC = 'font-style:italic;';
	this.ITALIC_BOLD = this.ITALIC + this.BOLD;
	this.BOLD_ITALIC = this.ITALIC_BOLD;
}
var Font = new jsgFont();

function jsgStroke()
{
	this.DOTTED = -1;
}
var Stroke = new jsgStroke();

function jsGraphics(cnv, wnd)
{
	this.setColor = new Function('arg', 'this.color = arg.toLowerCase();');

	this.setStroke = function(x)
	{
		this.stroke = x;
		if(!(x+1))
		{
			this.drawLine = mkLinDott;
			this.mkOv = mkOvDott;
			this.drawRect = mkRectDott;
		}
		else if(x-1 > 0)
		{
			this.drawLine = mkLin2D;
			this.mkOv = mkOv2D;
			this.drawRect = mkRect;
		}
		else
		{
			this.drawLine = mkLin;
			this.mkOv = mkOv;
			this.drawRect = mkRect;
		}
	};

	this.setPrintable = function(arg)
	{
		this.printable = arg;
		if(jg_fast)
		{
			this.mkDiv = mkDivIe;
			this.htmRpc = arg? htmPrtRpc : htmRpc;
		}
		else this.mkDiv = arg? mkDivPrt : mkDiv;
	};

	this.setFont = function(fam, sz, sty)
	{
		this.ftFam = fam;
		this.ftSz = sz;
		this.ftSty = sty || Font.PLAIN;
	};

	this.drawPolyline = this.drawPolyLine = function(x, y)
	{
		for (var i=x.length - 1; i;)
		{--i;
			this.drawLine(x[i], y[i], x[i+1], y[i+1]);
		}
	};

	this.HistFillRect = function(x, y, w, h)
	{
		this.mkDiv(x, y, w, h);
	};

	this.drawPolygon = function(x, y)
	{
		this.drawPolyline(x, y);
		this.drawLine(x[x.length-1], y[x.length-1], x[0], y[0]);
	};

	this.HistDrawEllipse = this.drawOval = function(x, y, w, h)
	{
		this.mkOv(x, y, w, h);
	};

	this.fillEllipse = this.fillOval = function(left, top, w, h)
	{
		var a = w>>1, b = h>>1,
		wod = w&1, hod = h&1,
		cx = left+a, cy = top+b,
		x = 0, y = b, oy = b,
		aa2 = (a*a)<<1, aa4 = aa2<<1, bb2 = (b*b)<<1, bb4 = bb2<<1,
		st = (aa2>>1)*(1-(b<<1)) + bb2,
		tt = (bb2>>1) - aa2*((b<<1)-1),
		xl, dw, dh;
		if(w) while(y > 0)
		{
			if(st < 0)
			{
				st += bb2*((x<<1)+3);
				tt += bb4*(++x);
			}
			else if(tt < 0)
			{
				st += bb2*((x<<1)+3) - aa4*(y-1);
				xl = cx-x;
				dw = (x<<1)+wod;
				tt += bb4*(++x) - aa2*(((y--)<<1)-3);
				dh = oy-y;
				this.mkDiv(xl, cy-oy, dw, dh);
				this.mkDiv(xl, cy+y+hod, dw, dh);
				oy = y;
			}
			else
			{
				tt -= aa2*((y<<1)-3);
				st -= aa4*(--y);
			}
		}
		this.mkDiv(cx-a, cy-oy, w, (oy<<1)+hod);

	};

	this.fillArc = function(iL, iT, iW, iH, fAngA, fAngZ)
	{
		var a = iW>>1, b = iH>>1,
		iOdds = (iW&1) | ((iH&1) << 16),
		cx = iL+a, cy = iT+b,
		x = 0, y = b, ox = x, oy = y,
		aa2 = (a*a)<<1, aa4 = aa2<<1, bb2 = (b*b)<<1, bb4 = bb2<<1,
		st = (aa2>>1)*(1-(b<<1)) + bb2,
		tt = (bb2>>1) - aa2*((b<<1)-1),
		// Vars for radial boundary lines
		xEndA, yEndA, xEndZ, yEndZ,
		iSects = (1 << (Math.floor((fAngA %= 360.0)/180.0) << 3))
				| (2 << (Math.floor((fAngZ %= 360.0)/180.0) << 3))
				| ((fAngA >= fAngZ) << 16),
		aBndA = new Array(b+1), aBndZ = new Array(b+1);
		
		// Set up radial boundary lines
		fAngA *= Math.PI/180.0;
		fAngZ *= Math.PI/180.0;
		xEndA = cx+Math.round(a*Math.cos(fAngA));
		yEndA = cy+Math.round(-b*Math.sin(fAngA));
		aBndA.mkLinVirt(cx, cy, xEndA, yEndA);
		xEndZ = cx+Math.round(a*Math.cos(fAngZ));
		yEndZ = cy+Math.round(-b*Math.sin(fAngZ));
		aBndZ.mkLinVirt(cx, cy, xEndZ, yEndZ);

		while(y > 0)
		{
			if(st < 0) // Advance x
			{
				st += bb2*((x<<1)+3);
				tt += bb4*(++x);
			}
			else if(tt < 0) // Advance x and y
			{
				st += bb2*((x<<1)+3) - aa4*(y-1);
				ox = x;
				tt += bb4*(++x) - aa2*(((y--)<<1)-3);
				this.mkArcDiv(ox, y, oy, cx, cy, iOdds, aBndA, aBndZ, iSects);
				oy = y;
			}
			else // Advance y
			{
				tt -= aa2*((y<<1)-3);
				st -= aa4*(--y);
				if(y && (aBndA[y] != aBndA[y-1] || aBndZ[y] != aBndZ[y-1]))
				{
					this.mkArcDiv(x, y, oy, cx, cy, iOdds, aBndA, aBndZ, iSects);
					ox = x;
					oy = y;
				}
			}
		}
		this.mkArcDiv(x, 0, oy, cx, cy, iOdds, aBndA, aBndZ, iSects);
		if(iOdds >> 16) // Odd height
		{
			if(iSects >> 16) // Start-angle > end-angle
			{
				var xl = (yEndA <= cy || yEndZ > cy)? (cx - x) : cx;
				this.mkDiv(xl, cy, x + cx - xl + (iOdds & 0xffff), 1);
			}
			else if((iSects & 0x01) && yEndZ > cy)
				this.mkDiv(cx - x, cy, x, 1);
		}
	};

/* fillPolygon method, implemented by Matthieu Haller.
This javascript function is an adaptation of the gdImageFilledPolygon for Walter Zorn lib.
C source of GD 1.8.4 found at http://www.boutell.com/gd/

THANKS to Kirsten Schulz for the polygon fixes!

The intersection finding technique of this code could be improved
by remembering the previous intertersection, and by using the slope.
That could help to adjust intersections to produce a nice
interior_extrema. */
	this.HistFillPolygon = function(array_x, array_y)
	{
		var i;
		var y;
		var miny, maxy;
		var x1, y1;
		var x2, y2;
		var ind1, ind2;
		var ints;

		var n = array_x.length;
		if(!n) return;

		miny = array_y[0];
		maxy = array_y[0];
		for(i = 1; i < n; i++)
		{
			if(array_y[i] < miny)
				miny = array_y[i];

			if(array_y[i] > maxy)
				maxy = array_y[i];
		}
		for(y = miny; y <= maxy; y++)
		{
			var polyInts = new Array();
			ints = 0;
			for(i = 0; i < n; i++)
			{
				if(!i)
				{
					ind1 = n-1;
					ind2 = 0;
				}
				else
				{
					ind1 = i-1;
					ind2 = i;
				}
				y1 = array_y[ind1];
				y2 = array_y[ind2];
				if(y1 < y2)
				{
					x1 = array_x[ind1];
					x2 = array_x[ind2];
				}
				else if(y1 > y2)
				{
					y2 = array_y[ind1];
					y1 = array_y[ind2];
					x2 = array_x[ind1];
					x1 = array_x[ind2];
				}
				else continue;

				 //  Modified 11. 2. 2004 Walter Zorn
				if((y >= y1) && (y < y2))
					polyInts[ints++] = Math.round((y-y1) * (x2-x1) / (y2-y1) + x1);

				else if((y == maxy) && (y > y1) && (y <= y2))
					polyInts[ints++] = Math.round((y-y1) * (x2-x1) / (y2-y1) + x1);
			}
			polyInts.sort(CompInt);
			for(i = 0; i < ints; i+=2)
				this.mkDiv(polyInts[i], y, polyInts[i+1]-polyInts[i]+1, 1);
		}
	};

	this.drawString = function(txt, x, y)
	{
		this.htm += '<div style="position:absolute;white-space:nowrap;'+
			'left:' + x + 'px;'+
			'top:' + y + 'px;'+
			'font-family:' +  this.ftFam + ';'+
			'font-size:' + this.ftSz + ';'+
			'color:' + this.color + ';' + this.ftSty + '">'+
			txt +
			'<\/div>';
	};

/* drawStringRect() added by Rick Blommers.
Allows to specify the size of the text rectangle and to align the
text both horizontally (e.g. right) and vertically within that rectangle */
	this.drawStringRect = function(txt, x, y, width, halign)
	{
		this.htm += '<div style="position:absolute;overflow:hidden;'+
			'left:' + x + 'px;'+
			'top:' + y + 'px;'+
			'width:'+width +'px;'+
			'text-align:'+halign+';'+
			'font-family:' +  this.ftFam + ';'+
			'font-size:' + this.ftSz + ';'+
			'color:' + this.color + ';' + this.ftSty + '">'+
			txt +
			'<\/div>';
	};

	this.drawImage = function(imgSrc, x, y, w, h, a)
	{
		this.htm += '<div style="position:absolute;'+
			'left:' + x + 'px;'+
			'top:' + y + 'px;'+
			'width:' +  w + 'px;'+
			'height:' + h + 'px;">'+
			'<img src="' + imgSrc + '" width="' + w + '" height="' + h + '"' + (a? (' '+a) : '') + '>'+
			'<\/div>';
	};

	this.clear = function()
	{
		this.htm = "";
		if(this.cnv) this.cnv.innerHTML = "";
	};

	this.mkOvQds = function(cx, cy, x, y, w, h, wod, hod)
	{
		var xl = cx - x, xr = cx + x + wod - w, yt = cy - y, yb = cy + y + hod - h;
		if(xr > xl+w)
		{
			this.mkDiv(xr, yt, w, h);
			this.mkDiv(xr, yb, w, h);
		}
		else
			w = xr - xl + w;
		this.mkDiv(xl, yt, w, h);
		this.mkDiv(xl, yb, w, h);
	};
	
	this.mkArcDiv = function(x, y, oy, cx, cy, iOdds, aBndA, aBndZ, iSects)
	{
		var xrDef = cx + x + (iOdds & 0xffff), y2, h = oy - y, xl, xr, w;

		if(!h) h = 1;
		x = cx - x;

		if(iSects & 0xff0000) // Start-angle > end-angle
		{
			y2 = cy - y - h;
			if(iSects & 0x00ff)
			{
				if(iSects & 0x02)
				{
					xl = Math.max(x, aBndZ[y]);
					w = xrDef - xl;
					if(w > 0) this.mkDiv(xl, y2, w, h);
				}
				if(iSects & 0x01)
				{
					xr = Math.min(xrDef, aBndA[y]);
					w = xr - x;
					if(w > 0) this.mkDiv(x, y2, w, h);
				}
			}
			else
				this.mkDiv(x, y2, xrDef - x, h);
			y2 = cy + y + (iOdds >> 16);
			if(iSects & 0xff00)
			{
				if(iSects & 0x0100)
				{
					xl = Math.max(x, aBndA[y]);
					w = xrDef - xl;
					if(w > 0) this.mkDiv(xl, y2, w, h);
				}
				if(iSects & 0x0200)
				{
					xr = Math.min(xrDef, aBndZ[y]);
					w = xr - x;
					if(w > 0) this.mkDiv(x, y2, w, h);
				}
			}
			else
				this.mkDiv(x, y2, xrDef - x, h);
		}
		else
		{
			if(iSects & 0x00ff)
			{
				if(iSects & 0x02)
					xl = Math.max(x, aBndZ[y]);
				else
					xl = x;
				if(iSects & 0x01)
					xr = Math.min(xrDef, aBndA[y]);
				else
					xr = xrDef;
				y2 = cy - y - h;
				w = xr - xl;
				if(w > 0) this.mkDiv(xl, y2, w, h);
			}
			if(iSects & 0xff00)
			{
				if(iSects & 0x0100)
					xl = Math.max(x, aBndA[y]);
				else
					xl = x;
				if(iSects & 0x0200)
					xr = Math.min(xrDef, aBndZ[y]);
				else
					xr = xrDef;
				y2 = cy + y + (iOdds >> 16);
				w = xr - xl;
				if(w > 0) this.mkDiv(xl, y2, w, h);
			}
		}
	};

	this.setStroke(1);
	this.setFont("verdana,geneva,helvetica,sans-serif", "12px", Font.PLAIN);
	this.color = "#000000";
	this.htm = "";
	this.wnd = parent.DisplayResult || wnd || window;

	if(!jg_ok) chkDHTM();
	if(jg_ok)
	{
		if(cnv)
		{
			if(typeof(cnv) == "string"){
				/*this.cont = document.all? (this.wnd.document.all[cnv] || null)
					: document.getElementById? (this.wnd.document.getElementById(cnv) || null)
					: null;
				*/
				this.cont = document.getElementById(cnv);
			}
			else if(cnv == window.document)
				this.cont = document.getElementsByTagName("body")[0];
			// If cnv is a direct reference to a canvas DOM node
			// (option suggested by Andreas Luleich)
			else this.cont = cnv;
			// Create new canvas inside container DIV. Thus the drawing and clearing
			// methods won't interfere with the container's inner html.
			// Solution suggested by Vladimir.
			this.cnv = this.wnd.document.createElement("div");
			this.cont.appendChild(this.cnv);
			this.paint = jg_dom? pntCnvDom : pntCnvIe;
		}
		else
			this.paint = pntDoc;
	}
	else
		this.paint = pntN;

	this.setPrintable(false);
}

Array.prototype.mkLinVirt = function(x1, y1, x2, y2)
{
	var dx = Math.abs(x2-x1), dy = Math.abs(y2-y1),
	x = x1, y = y1,
	xIncr = (x1 > x2)? -1 : 1,
	yIncr = (y1 > y2)? -1 : 1,
	p,
	i = 0;
	if(dx >= dy)
	{
		var pr = dy<<1,
		pru = pr - (dx<<1);
		p = pr-dx;
		while(dx > 0)
		{--dx;
			if(p > 0)    //  Increment y
			{
				this[i++] = x;
				y += yIncr;
				p += pru;
			}
			else p += pr;
			x += xIncr;
		}
	}
	else
	{
		var pr = dx<<1,
		pru = pr - (dy<<1);
		p = pr-dy;
		while(dy > 0)
		{--dy;
			y += yIncr;
			this[i++] = x;
			if(p > 0)    //  Increment x
			{
				x += xIncr;
				p += pru;
			}
			else p += pr;
		}
	}
	for(var len = this.length, i = len-i; i;)
		this[len-(i--)] = x;
};

function CompInt(x, y)
{
	return(x - y);
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


function drawCircle1(imageLayer, x,y,radius,color,shapeId){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	imageGraphics.setPrintable(true);
	imageGraphics.setColor("white") 
	imageGraphics.fillOval(x,y,radius*2,radius*2);
	imageGraphics.setColor(color)    
	imageGraphics.drawOval(x,y,radius*2,radius*2);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

//added by parul for crf 0483 on 25/08/2009
 function drawCircleForCuspHistory(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,treatments_outcome){
	  var imageLayer = "toothLayer"+tooth_no;
	  var color = "";
	  if (treatments_outcome=="F"){
          color = "BROWN";
	  }else{
	      color = "blue";
	  }
	  if(status == 'E'){
			color = "WHITE";
		}
		
if (cusptip_ref.indexOf(",")!=-1){
	var cusptip_ref_arr=cusptip_ref.split(",");
		 for(var i=0;i<cusptip_ref_arr.length;i++){
			 if(surface_code=="2" || surface_code=="6" || surface_code=="5"){
				var coordinates = getCrownCoordinates(cusptip_ref_arr[i],surface_code,tooth_no);
				 if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
					   if (coordinates!="undefined" && coordinates!=undefined) {
						  var corrd_arr = coordinates.split("#");

						  x1=parseInt(corrd_arr[0]); 
						  y1=parseInt(corrd_arr[1]); 
						  x2=parseInt(corrd_arr[2]); 
						  y2=parseInt(corrd_arr[3]);

						  drawCircle1(imageLayer,x1,y1,x2,color);
						//  drawCircle1(imageLayer,(x1+1),y1,(x2),color);
						  
						/*  if(status != null && status != "null" && status == "E"){
								var formObj = document.forms[0];
								var site_type = "CROWN";//formObj.oh_site.value;
								var tab_name = tab_name;
								var chart_num = formObj.chart_num.value;
								
								getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj);
								
							}*/
						
					   }
				 }
			}
	 }
}else{

 if(cusptip_ref!="" && cusptip_ref!="null" && cusptip_ref!=null){
	
	   if(surface_code=="2" || surface_code=="6" || surface_code=="5"){
		 var coordinates = getCrownCoordinates(cusptip_ref,surface_code,tooth_no);
		  if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
			 if (coordinates!="undefined" && coordinates!=undefined) {
				  var corrd_arr = coordinates.split("#");
				  x1=parseInt(corrd_arr[0]); 
				  y1=parseInt(corrd_arr[1]); 
				  x2=parseInt(corrd_arr[2]); 
				  y2=parseInt(corrd_arr[3]);

					drawCircle1(imageLayer,x1,y1,x2,color);
				//	drawCircle(imageLayer,x1,y1,x2,y2,color);
				//	drawCircle1(imageLayer,(x1+1),y1,(x2),color);
					//drawCircle(imageLayer,(x1+2),y1,(x2),color);

				 /* if(status != null && status != "null" && status == "E"){
						var formObj = document.forms[0];
						var site_type = "CROWN";//formObj.oh_site.value;
						var tab_name = tab_name;
						var chart_num = formObj.chart_num.value;				
						getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj);
						
					}*/
			  }
			 }
		}
	}
}
	 

  }
//added by parul for crf 0483 on 25/08/2009
  function getCrownCoordinates(cusptip_ref,surface_code,tooth_no){
	 
		var x1=0;  var y1=0;
		var x2=0;  var y2=0;
		var coordinates = "";
	if (tooth_no>=1 && tooth_no<=8){
	
		if (surface_code=="2"){
			if (cusptip_ref=="3"){
			//	var coordinates = "-1#0#6#6";//for 1st circle
				//var coordinates = "-1#0#3";//for 1st circle
				var coordinates = "-1#-1#3";//for 1st circle
			}else if (cusptip_ref=="1"){
				var coordinates = "34#0#3";//for 2nd circle				
			//	var coordinates = "34#0#6#6";//for 2nd circle				
			}else if (cusptip_ref=="5"){
				//var coordinates = "17#-1#6#6";//upper middle circle
				var coordinates = "17#-1#3";//upper middle circle
			}
		}else if (surface_code=="6"){
			if (cusptip_ref=="4"){
				//var coordinates = "-1#18#6#6";//lower 4th circle
				var coordinates = "-1#18#3";//lower 4th circle
			}else if (cusptip_ref=="2"){
				//var coordinates = "34#18#5#5";//for down circle 3rd
				var coordinates = "34#18#3";//for down circle 3rd
			}else if (cusptip_ref=="7"){
				//var coordinates = "16#19#6#6";//lower middle circle
				var coordinates = "16#19#3";//lower middle circle
			}else if (cusptip_ref=="6"){
				var coordinates = "16#19#3";//lower middle circle
			}else if (cusptip_ref=="9"){
				var coordinates = "-1#18#3";//lower middle circle
			}else if (cusptip_ref=="8"){
				var coordinates = "34#18#3";//lower middle circle
			}else if (cusptip_ref=="10"){
				var coordinates = "16#19#3";//lower middle circle
			}
		}
	}else if (tooth_no>=25 && tooth_no<=32){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "16#19#3";
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#18#3";
			   }else if (cusptip_ref=="1"){
				   var coordinates = "34#18#3";
			   } else if (cusptip_ref=="7") {
				   var coordinates = "16#19#3";
			   }
			}else if (surface_code=="5"){
				 if (cusptip_ref=="4"){
				var coordinates = "-1#0#3";
				 }else  if (cusptip_ref=="2"){
				var coordinates = "34#0#3";
				 }else  if (cusptip_ref=="6"){
				var coordinates = "17#-1#3";
				 }
				 
			}
	}else if (tooth_no>=17 && tooth_no<=25){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "16#19#3";
			   }else if (cusptip_ref=="3") {
				   var coordinates = "34#18#3";
			   }
			   else if (cusptip_ref=="1") {
				   var coordinates = "-1#18#3";
			   }else if (cusptip_ref=="7") {
				   var coordinates = "16#19#3";
			   }
			}else if (surface_code=="5"){
				if (cusptip_ref=="4"){
					var coordinates = "34#0#3";
				}else if (cusptip_ref=="2"){
					var coordinates = "-1#0#3";
				}else if (cusptip_ref=="6"){
					var coordinates = "17#-1#3";
				}
			}
	}else if (tooth_no>=9 && tooth_no<=16){
			 if (surface_code=="6"){
				if (cusptip_ref=="7"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="4"){
					var coordinates = "34#18#3";
				}else if (cusptip_ref=="2"){
					var coordinates = "-1#18#3";
				}else if (cusptip_ref=="6"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="10"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="9"){
					var coordinates = "34#18#3";
				}else if (cusptip_ref=="8"){
					var coordinates = "-1#18#3";
				}
			}else if (surface_code="2"){
					if (cusptip_ref=="3"){
						var coordinates = "34#0#3";
					}else if (cusptip_ref=="1"){
						var coordinates = "-1#0#3";
					}else if (cusptip_ref=="6"){
						var coordinates = "17#-1#3";
					}else if (cusptip_ref=="5"){
						var coordinates = "17#-1#3";//upper middle
					}
			}
	}else if (tooth_no>=33 && tooth_no<=41){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "17#-1#3";
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#0#3";//for 1st circle	
			   }else if (cusptip_ref=="1"){
				   var coordinates =  "34#0#3";//for 2nd circle			
			   }
		}else if (surface_code=="6"){
			   if (cusptip_ref=="10"){
				   var coordinates = "16#19#3";//lower middle circle
			   }else if (cusptip_ref=="9"){
				   var coordinates ="-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="8"){
				   var coordinates ="34#18#3";//for down circle 3rd
			   }
		}
	}else if (tooth_no==51 || tooth_no==52){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "17#-1#3";
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="1"){
				   var coordinates =  "34#18#3";//for down circle 3rd	
			   }else if (cusptip_ref=="7"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }
		}else if (surface_code=="5"){
			   if (cusptip_ref=="4"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }else if (cusptip_ref=="2"){
				   var coordinates ="34#0#3";//for 2nd circle	
			   }else if (cusptip_ref=="6"){
				   var coordinates ="17#-1#3";//upper middle
			   }
		}
	}else if (tooth_no<=42){
		 if (surface_code=="2"){
			   if (cusptip_ref=="3"){
				   var coordinates ="34#0#3";//for 2nd circle		
			   }else if (cusptip_ref=="1"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }
		 }else  if (surface_code=="6"){
			   if (cusptip_ref=="9"){
				   var coordinates = "34#18#3";//for down circle 3rd
			   }else if (cusptip_ref=="8"){
				   var coordinates =  "-1#18#3";//lower 4th circle
			   }
		 }
	}else if (tooth_no==44 || tooth_no==43){
		 if (surface_code=="2"){
			   if (cusptip_ref=="3"){
				   var coordinates ="34#18#3";//for down circle 3rd
			   }else if (cusptip_ref=="1"){
				   var coordinates = "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="7"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }
		 }else  if (surface_code=="5"){
			   if (cusptip_ref=="6"){
				   var coordinates =  "17#-1#3";//upper middle
			   }else if (cusptip_ref=="8"){
				   var coordinates =  "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="4"){
				   var coordinates = "34#0#3";//for 2nd circle		
			   }else if (cusptip_ref=="2"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }
		 }
	}
	    return coordinates;
}

	function onMouseClickOfImage(imgId){}

 
function printCurrentWindow()
{
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	//var chart_num = formObj.chart_num.value;
	var chart_num = formObj.as_on_date_chart_num.value;
	var dentist_comments = document.getElementById("dent_comm").value;
	//dentist_comments = checkSpl_print(dentist_comments);

	/*var dentist_comments_encode1 = encodeURIComponent(dentist_comments);
	var dentist_comments_encode2 = encodeURIComponent(dentist_comments_encode1);*/  
	//dentist_comments = encodeURIComponent(dentist_comments_spl);  
	
	formObj.dentist_comments.value = encodeURIComponent(dentist_comments); 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = formObj.elements;
	var frmObjs = new Array()
	if(formObj.name == null){
		frmObjs = formObj ;
	}
	else{
		frmObjs[0] = formObj ;
	}
	var xmlStr ="<root><SEARCH ";
	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		formObj = frmObjs[frmCount];
		var arrObj = formObj.elements;
		
		for(var i=0;i<arrObj.length;i++) {
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != ""){
				//xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
			}
		}
	}
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//beforePost(xmlStr) ;
	xmlHttp.open("POST", "PrintChartValidation.jsp?func_mode=updateDentistComments", false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	
	
	
	/*var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	//dentist_comments = encodeURIComponent(dentist_comments);
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&remarks="+dentist_comments_encode1;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PrintChartValidation.jsp?func_mode=updateDentistComments&"+params,false);
	xmlHttp.send(xmlDoc);
	//var update_dentist_comments_retVal = localTrimString(xmlHttp.responseText);
	var update_dentist_comments_retVal = trimString(xmlHttp.responseText);	  */
	//checkSpl_print();
	window.print();
	
}

function checkSpl_print(val) {
		//var val = document.forms[0].dentist_comments.value;
		//var val = document.getElementById("dent_comm").value;
		var result = "" ;
		var ch = "" ;
		var indVal = 0;
		while ( (indVal = val.indexOf('\n',indVal)) != -1 )
		{
			val = val.replace("\n","\"")
		}

		var spChars = new Array( "<", ">", "&", "\"", "'") ;
		var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;") ;
		for(i=0; i<val.length; i++) {
			for(j=0; j<spChars.length; j++) {
				if ( val.substring(i,i+1) == spChars[j] ) {
					ch = chChars[j] ;
					j=spChars.length ;
				} else {
					ch = val.substring(i,i+1) ;
				}
			}
			result += ch ;
		}
		//document.forms[0].dentist_comments.value = result;
		//document.getElementById("dent_comm").value = result;
		//document.forms[0].dentist_comments.value = result;
		return result ;
} 

