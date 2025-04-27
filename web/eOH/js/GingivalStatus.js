//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
var isExfoliated = false;
var isSuper = false;
var isErupted = false;
var isDeciduousTooth = false;
var tooth_no_RD = "";
var count_GS = 0;
var count_Recorded_GS = 0;
var isExfoliatedMissing = false;
var flag_for_previous_recording = "";
var isDeciduous = false;
var isExfoliatedAfter = false;
var isEruptedAfter = false;
var isEruptedBeforeAfter = false;
var isExfoliatedDeciduous = false;
var GS_overridden = false;
var isSuperYN = false;
var isRetainedDeciduous = false;
//

//for getting tooth which is depends on quadrant
function getToothnumber(obj){
	//clear MessageFrame
	var messageFrame = parent.parent.parent.parent.parent.messageFrame;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
    
	var formObj = document.GingivalStatus;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var gingival_recording_by = formObj.gingival_recording_by.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	//Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var chart_type = formObj.chart_type.value;
	var disply_tooth_no = "";
	var erupted_yn="";
	var super_yn="";
	var MD_yn="";
	var	exfolth_yn="";
	var	decith_yn="";
	
	//
	var ns_quadrant = obj.value;
	var ns_quadrant_val = "";
   
    var storeSuperData = "";

	clear_list(formObj.oh_tooth);  
	var optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	formObj.oh_tooth.add(optSel);

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "ns_quadrant="+ns_quadrant+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&gingival_recording_by="+gingival_recording_by+"&mixed_dentition_YN="+mixed_dentition_YN;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	if(retVal.length >1){
		var retVal_arr =retVal.split("~");
		//Commented by parul and added conditions for IN009737 & IN009739 on 7/17/2009(for populating toothno according to selected chart )
	   /* for(i=0;i<retVal_arr.length-1;i++){
			var tooth_no_arr = retVal_arr[i].split("##");	
			var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
			element.value 	= tooth_no_arr[0];
			element.text 	= tooth_no_arr[1];
			
			formObj.oh_tooth.add(element);
		}
	}*/
		 if(gingival_recording_by == "Q") {
			 //if (mixed_dentition_YN=="Y" &&(ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
			 if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" &&(ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					
				 	var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							var condition_type = retVal_condition_arr[0];
					
					
						if(code_desc_arr[2] == "D" && code_desc_arr[0] != "EXFOLTH") {
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith_tooth_no = trimString(xmlHttp.responseText);
							var retVal_decith_tooth_no_arr = retVal_decith_tooth_no.split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= retVal_decith_tooth_no_arr[0];
							ns_quadrant_val 	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = retVal_decith_tooth_no_arr[0];
						}
					
						else if(code_desc_arr[0] == "EXFOLTH"){
											
							element.value 	= tooth_no_arr[0];
							//element.text 	= tooth_no_arr[3];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val	= tooth_no_arr[2];
							//formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
					   else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
						
					 }
					 formObj.oh_tooth.add(element);
				   	}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					    formObj.oh_tooth.add(element);
					}
				}
			 } else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
								
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//var element1 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
 							if(code_desc_arr[0] == "SUPRTH"){
							  isSuper = true;							
							}
							if(isExfoliated){
								
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
								formObj.mapped_tooth_no.value = disply_tooth_no;
							}
							else if(code_desc_arr[1] == "R"){
								
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
							}
							else if((code_desc_arr[1] == "" || code_desc_arr[1] == "null" || code_desc_arr[1] == null)  &&(code_desc_arr[2] == "" || code_desc_arr[2] == "null" || code_desc_arr[2] == null)){ 
								
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1];
							   ns_quadrant_val  = tooth_no_arr[2];
							 }
							//else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" ){//Exfoliated
							else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" && !isSuper){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
								isExfoliated = true;
								//isRetainedDeciduous = false;
								formObj.mapped_tooth_no.value = disply_tooth_no;
							}  
							else {
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
								ns_quadrant_val = tooth_no_arr[2];
								formObj.mapped_tooth_no.value = tooth_no_arr[1];
							}
						}
						formObj.oh_tooth.add(element);
					
					}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					    formObj.oh_tooth.add(element);
					}
					isExfoliated = false;
					isSuper = false;
				  }
			}else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" &&(ns_quadrant=='2' || ns_quadrant=='4')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-1;i++){
					if(i!=7){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							var condition_type = retVal_condition_arr[0];
						
						
						if(code_desc_arr[2] == "D" && code_desc_arr[0] != "EXFOLTH") {
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith_tooth_no = trimString(xmlHttp.responseText);
							var retVal_decith_tooth_no_arr = retVal_decith_tooth_no.split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= retVal_decith_tooth_no_arr[0];
							ns_quadrant_val 	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = retVal_decith_tooth_no_arr[0];
						}
					
						else if(code_desc_arr[0] == "EXFOLTH"){
											
							element.value 	= tooth_no_arr[0];
							//element.text 	= tooth_no_arr[3];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val	= tooth_no_arr[2];
							//formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
					   else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
						
					 }
					 formObj.oh_tooth.add(element);
				   	}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					    formObj.oh_tooth.add(element);
					}
				}
			 }
			} else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='2' || ns_quadrant=='4')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-1;i++){
					if(i!=7){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//var element1 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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
					
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							
								if(code_desc_arr[0] == "SUPRTH"){
									isSuper = true;							
								}
								if(isExfoliated){
									element.value 	= tooth_no_arr[0];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}
								else if(code_desc_arr[1] == "R"){
									element.value 	= tooth_no_arr[0];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
								}
							
								//else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" && !isSuper){//Exfoliated
									element.value 	= tooth_no_arr[0];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									isExfoliated = true;
									//isRetainedDeciduous = false;
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}  
								else {
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = tooth_no_arr[1];
								}
							}
							formObj.oh_tooth.add(element);
						
						}
						else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
							formObj.oh_tooth.add(element);
						}
						isExfoliated = false;
						isSuper = false;
					}
					}
				}
			 else {
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
					
				
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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
					
					var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
						}
						formObj.oh_tooth.add(element);
					}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
					    formObj.oh_tooth.add(element);
					}
				}
			}
		}
		else{
			//if (mixed_dentition_YN=="Y" &&(ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
			 if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" &&(ns_quadrant=='1' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					/*var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					element.value 	= tooth_no_arr[0];
					element.text 	= tooth_no_arr[1];
					ns_quadrant_val 	= tooth_no_arr[2];
					formObj.oh_tooth.add(element);*/
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							var condition_type = retVal_condition_arr[0];
						
						
						
						if(code_desc_arr[2] == "D" && code_desc_arr[0] != "EXFOLTH") {
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith_tooth_no = trimString(xmlHttp.responseText);
							var retVal_decith_tooth_no_arr = retVal_decith_tooth_no.split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= retVal_decith_tooth_no_arr[0];
							ns_quadrant_val 	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = retVal_decith_tooth_no_arr[0];
						}
					
						else if(code_desc_arr[0] == "EXFOLTH"){
											
							element.value 	= tooth_no_arr[0];
							//element.text 	= tooth_no_arr[3];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val	= tooth_no_arr[2];
							//formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
					   else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
						
					 }
					 formObj.oh_tooth.add(element);
				   	}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					    formObj.oh_tooth.add(element);
					}
				}
					
			 } else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='1' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//var element1 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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
					
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							if(code_desc_arr[0] == "SUPRTH"){
								isSuper = true;							
							}
							if(isExfoliated){
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
								formObj.mapped_tooth_no.value = disply_tooth_no;
							}
							else if (code_desc_arr[2] == "R")
							{
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
								isExfoliated = true;
							}
					
							//else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
							else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" && !isSuper){//Exfoliated
								element.value 	= tooth_no_arr[0];
								element.text 	= disply_tooth_no;
								ns_quadrant_val = tooth_no_arr[2];
								isExfoliated = true;
								//isRetainedDeciduous = false;
								formObj.mapped_tooth_no.value = disply_tooth_no;
							}
							
							else {
								element.value 	= tooth_no_arr[0];
								element.text 	= tooth_no_arr[1];
								ns_quadrant_val = tooth_no_arr[2];
								formObj.mapped_tooth_no.value = tooth_no_arr[1];
							}
						}
						formObj.oh_tooth.add(element);
					
					}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					    formObj.oh_tooth.add(element);
					}
					isExfoliated = false;
					isSuper = false;
				}
			}else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" &&(ns_quadrant=='3' || ns_quadrant=='6')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-2;i++){
					if(i!=7){
						/*var tooth_no_arr = retVal_arr[i].split("##");
						var element 	= document.createElement("OPTION");
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val 	= tooth_no_arr[2];
						formObj.oh_tooth.add(element);
						}
					 } */

					

					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							var condition_type = retVal_condition_arr[0];
						
					
						if(code_desc_arr[2] == "D" && code_desc_arr[0] != "EXFOLTH") {
						
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith_tooth_no = trimString(xmlHttp.responseText);
							var retVal_decith_tooth_no_arr = retVal_decith_tooth_no.split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= retVal_decith_tooth_no_arr[0];
							ns_quadrant_val 	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = retVal_decith_tooth_no_arr[0];
						}
						
						else if(code_desc_arr[0] == "EXFOLTH"){
											
							element.value 	= tooth_no_arr[0];
							//element.text 	= tooth_no_arr[3];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
					   else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
						
					 }
					 formObj.oh_tooth.add(element);

					}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
						formObj.oh_tooth.add(element);
						formObj.mapped_tooth_no.value = tooth_no_arr[1];
					}
				}
				 }
			 }
			 else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='3' || ns_quadrant=='6')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-2;i++){
				
					if(i!=7){
						//isPartErupted = false;
						isExfoliated = false;
						var tooth_no_arr = retVal_arr[i].split("##");
						var element 	= document.createElement("OPTION");
						//var element1 	= document.createElement("OPTION");
						//Check for Deciduous Tooth
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_RD = trimString(xmlHttp.responseText);
						var retVal_RD_arr = retVal_RD.split("##");

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_condition = trimString(xmlHttp.responseText);
						if(retVal_condition.length > 1){
							var retVal_condition_arr = retVal_condition.split("~");
							for(var j=0;j<retVal_condition_arr.length-1;j++){
								var code_desc_arr = retVal_condition_arr[j].split("##");
								if(code_desc_arr[0] == "SUPRTH"){
									isSuper = true;							
								}
								if(isExfoliated){
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[3];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}
								else if(code_desc_arr[1] == "R"){
									element.value 	= tooth_no_arr[0];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
								}
							
								//else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" && !isSuper){//Exfoliated
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[3];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									isExfoliated = true;
									//isRetainedDeciduous = false;
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}
								else {
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = tooth_no_arr[1];
								}
							}
							 formObj.oh_tooth.add(element);
							
						}
						else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
							formObj.oh_tooth.add(element);
						}
						isExfoliated = false;
						isSuper = false;
						}
					}
				}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" &&(ns_quadrant=='2' || ns_quadrant=='5')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-1;i++){
					if(i!=7){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
							var condition_type = retVal_condition_arr[0];
						
					
						if(code_desc_arr[2] == "D" && code_desc_arr[0] != "EXFOLTH")  {	 //Deciduous tooth
					
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith_tooth_no = trimString(xmlHttp.responseText);
							var retVal_decith_tooth_no_arr = retVal_decith_tooth_no.split("##");
							element.value 	= tooth_no_arr[0];
							element.text 	= retVal_decith_tooth_no_arr[0];
							ns_quadrant_val 	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = retVal_decith_tooth_no_arr[0];

						}
						
						else if(code_desc_arr[0] == "EXFOLTH"){
											
							element.value 	= tooth_no_arr[0];
							//element.text 	= tooth_no_arr[3];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val	= tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
					   else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
						}
						
					 }
					 formObj.oh_tooth.add(element);

					}
					else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
						    formObj.oh_tooth.add(element);
						}
					}
				 }
			 }
			 else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='2' || ns_quadrant=='5')) {//this bolck is for if mixed_dentition_YN=="Y" than skip the end tooth no 
				 for(i=0;i<retVal_arr.length-1;i++){
			
					if(i!=7){
						//isPartErupted = false;
					//	isSuperYN = false;
						isExfoliated = false;
						var tooth_no_arr = retVal_arr[i].split("##");
						var element 	= document.createElement("OPTION");
						//var element1 	= document.createElement("OPTION");
						//Check for Deciduous Tooth
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_RD = trimString(xmlHttp.responseText);
						var retVal_RD_arr = retVal_RD.split("##");


						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_condition = trimString(xmlHttp.responseText);
						if(retVal_condition.length > 1){
							var retVal_condition_arr = retVal_condition.split("~");
							for(var j=0;j<retVal_condition_arr.length-1;j++){
								var code_desc_arr = retVal_condition_arr[j].split("##");
								if(code_desc_arr[0] == "SUPRTH"){
									isSuper = true;							
								}			
								if(isExfoliated){
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[3];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}
								else if(code_desc_arr[1] == "R"){
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[3];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];						
								}
														
								//else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH"){//Exfoliated
								else if(code_desc_arr[1] != "Y" && code_desc_arr[1] != "N" && code_desc_arr[0] == "EXFOLTH" && !isSuper){//Exfoliated
									element.value 	= tooth_no_arr[0];
									//element.text 	= tooth_no_arr[3];
									element.text 	= disply_tooth_no;
									ns_quadrant_val = tooth_no_arr[2];
									isExfoliated = true;
								//	isRetainedDeciduous = false;
									formObj.mapped_tooth_no.value = disply_tooth_no;
								}
								else {
									element.value 	= tooth_no_arr[0];
									element.text 	= tooth_no_arr[1];
									ns_quadrant_val = tooth_no_arr[2];
									formObj.mapped_tooth_no.value = tooth_no_arr[1];
								}
							}
							 formObj.oh_tooth.add(element);
							
						}
						else{
							element.value 	= tooth_no_arr[0];
							element.text 	= tooth_no_arr[1];
							ns_quadrant_val = tooth_no_arr[2];
							formObj.mapped_tooth_no.value = tooth_no_arr[1];
							formObj.oh_tooth.add(element);
						}
						isExfoliated = false;
						isSuper = false;
						}
					}
				}
			 else {
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
					//var element1 	= document.createElement("OPTION");
					//Check for Deciduous Tooth
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
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
					
					var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_RD = trimString(xmlHttp.responseText);
					var retVal_RD_arr = retVal_RD.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateConditions&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_condition = trimString(xmlHttp.responseText);
					if(retVal_condition.length > 1){
						var retVal_condition_arr = retVal_condition.split("~");
						for(var j=0;j<retVal_condition_arr.length-1;j++){
							var code_desc_arr = retVal_condition_arr[j].split("##");
						 element.value 	= tooth_no_arr[0];
						 element.text 	= tooth_no_arr[1];
						 ns_quadrant_val = tooth_no_arr[2];
						}
						formObj.oh_tooth.add(element);
						
					}
					else{
						element.value 	= tooth_no_arr[0];
						element.text 	= tooth_no_arr[1];
						ns_quadrant_val = tooth_no_arr[2];
					    formObj.oh_tooth.add(element);
					}
				}
			}
		}
	}
	//if(gingival_recording_by == "Q" && permanent_deciduous_flag=="P"){
	//if(chart_type == "RA" || chart_type == "RD") {
		if(gingival_recording_by == "Q"){
			var gs_dflt_tooth_no_q1 = trimString(formObj.gs_dflt_tooth_no_q1.value);
			var gs_dflt_tooth_no_q2 = trimString(formObj.gs_dflt_tooth_no_q2.value);
			var gs_dflt_tooth_no_q3 = trimString(formObj.gs_dflt_tooth_no_q3.value);
			var gs_dflt_tooth_no_q4 = trimString(formObj.gs_dflt_tooth_no_q4.value);
			
			if(ns_quadrant == "1"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_q1;
			}else if(ns_quadrant == "2"){
				formObj.oh_tooth.value=gs_dflt_tooth_no_q2;

			}else if(ns_quadrant == "4"&&tooth_numbering_system == 'FDI'){
				formObj.oh_tooth.value=gs_dflt_tooth_no_q3;
			}
			else if (ns_quadrant == "4"&&tooth_numbering_system == 'UNI'){
				// formObj.oh_tooth.value=gs_dflt_tooth_no_q4;
				formObj.oh_tooth.value=gs_dflt_tooth_no_q3;
			}
			else if (ns_quadrant == "3"&&tooth_numbering_system == 'FDI'){
			    formObj.oh_tooth.value=gs_dflt_tooth_no_q4;
			}else if (ns_quadrant == "3"&&tooth_numbering_system == 'UNI'){
				  // formObj.oh_tooth.value=gs_dflt_tooth_no_q3;
				   formObj.oh_tooth.value=gs_dflt_tooth_no_q4;
			}
		}
		else{
			var gs_dflt_tooth_no_s1 = trimString(formObj.gs_dflt_tooth_no_s1.value);
			var gs_dflt_tooth_no_s2 = trimString(formObj.gs_dflt_tooth_no_s2.value);
			var gs_dflt_tooth_no_s3 = trimString(formObj.gs_dflt_tooth_no_s3.value);
			var gs_dflt_tooth_no_s4 = trimString(formObj.gs_dflt_tooth_no_s4.value);
			var gs_dflt_tooth_no_s5 = trimString(formObj.gs_dflt_tooth_no_s5.value);
			var gs_dflt_tooth_no_s6 = trimString(formObj.gs_dflt_tooth_no_s6.value);
			if(ns_quadrant=="1"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s1;
			}else if(ns_quadrant=="2"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s2;
			}else if(ns_quadrant=="3"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s3;
			}else if (ns_quadrant=="4"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s4;
			}else if (ns_quadrant=="5"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s5;
			}else if (ns_quadrant=="6"){
				formObj.oh_tooth.value = gs_dflt_tooth_no_s6;
			}
		}
	//}
	var dflt_tooth = formObj.oh_tooth.value;
	//Commented and added on top
	//var patient_id = formObj.patient_id.value;
	//var chart_num = formObj.chart_num.value;
	//	
	//Check for Missing Tooth
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&dflt_tooth="+dflt_tooth+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=checkForMissingTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	/*var missing_yn = trimString(xmlHttp.responseText);
	if(missing_yn == "Y"){
		//alert("Gingival Status can not be recorded as tooth "+dflt_tooth+" is Missing.Record Gingival Status for Adjacent tooth ");
		var msg = getMessage("APP-OH00074","OH");
		var msg_arr = msg.split("##");
		alert(msg_arr[0]+dflt_tooth+msg_arr[1]);
		//formObj.oh_tooth.value = parseInt(dflt_tooth)+1;
	}*/ 
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_missing_arr = retVal.split("##");
		missing_yn = retVal_missing_arr[0];
		
		display_tooth_no = retVal_missing_arr[1];
		//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		erupted_yn = retVal_missing_arr[2];
		super_yn = retVal_missing_arr[3];
		MD_yn = retVal_missing_arr[4];
		exfolth_yn = retVal_missing_arr[5];
		decith_yn = retVal_missing_arr[6];
	}
	if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D"){
	 	if(exfolth_yn == "Y"){
			isExfoliatedMissing = true;
		}
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
	 }
	 else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P"){
		if(decith_yn == "Y"){
			isDeciduousTooth = true;
		}
		if(exfolth_yn == "Y"){
			 isExfoliatedMissing = true;
		} 
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
	 }
	 else if (missing_yn == "Y" || exfolth_yn == "Y")
	 {
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
		if(exfolth_yn == "Y" ){
			isExfoliatedMissing = true;
		}
	}  
}
		 
function clear_list(obj){
	while(obj.options.length > 0){
		obj.remove(obj.options[0]);
	}
}


// Function for tab Reset
function GS_Tab_Reset_button(formObj,oh_area,oh_tooth){
	//To reset Error Msg Frame
	parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

	//formObj.reset();
	GS_Tab_Reset(formObj,oh_area,oh_tooth);
}

//function for reset  button
function GS_Tab_Reset(formObj,oh_area,oh_tooth){
    var formObj = document.GingivalStatus;
    var oh_area = formObj.oh_area.value;
	var oh_tooth = formObj.oh_tooth.value;
	//var oh_gingival = formObj.oh_gingival.value;
	var oh_status = formObj.oh_status.value;
	var oh_site = formObj.oh_site.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var gingival_recording_by = formObj.gingival_recording_by.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var chart_type = formObj.chart_type.value;

	if(oh_area == "null" || oh_area == null || oh_area == "" || oh_tooth == "" || oh_tooth == "null" || oh_tooth == null ||oh_tooth == "undefined" || oh_tooth == undefined){
		
		formObj.oh_area.value = "";
		formObj.oh_tooth.value = "";
		//formObj.oh_gingival.value = "";
		formObj.oh_status.value = "";
	}

	var gs_dflt_tooth_no_q1 = formObj.gs_dflt_tooth_no_q1.value;
	var gs_dflt_tooth_no_q2 = formObj.gs_dflt_tooth_no_q2.value;
	var gs_dflt_tooth_no_q3 = formObj.gs_dflt_tooth_no_q3.value;
	var gs_dflt_tooth_no_q4 = formObj.gs_dflt_tooth_no_q4.value;
	

	var gs_dflt_tooth_no_s1 = formObj.gs_dflt_tooth_no_s1.value;
	var gs_dflt_tooth_no_s2 = formObj.gs_dflt_tooth_no_s2.value;
	var gs_dflt_tooth_no_s3 = formObj.gs_dflt_tooth_no_s3.value;
	var gs_dflt_tooth_no_s4 = formObj.gs_dflt_tooth_no_s4.value;
	var gs_dflt_tooth_no_s5 = formObj.gs_dflt_tooth_no_s5.value;
	var gs_dflt_tooth_no_s6 = formObj.gs_dflt_tooth_no_s6.value;
    
	
	//Refreshing the form values with the original params
	var old_params = parent.parent.frames[2].document.forms[0].params.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_numbering_system="+tooth_numbering_system+"&gingival_recording_by="+gingival_recording_by+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=restrictQuadrantGS&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);


	 if(retVal.length >1){
		//var retVal_arr =retVal.split("~");
		var retVal_arr = retVal.split("##");
		if(gingival_recording_by == "Q"){
			gs_no_of_tooth_for_q1 	= retVal_arr[0];
			gs_no_of_tooth_for_q2	= retVal_arr[1];
			gs_no_of_tooth_for_q3	= retVal_arr[2];
			gs_no_of_tooth_for_q4	= retVal_arr[3];

			gs_dflt_tooth_no_q1	    = retVal_arr[4];
			gs_dflt_tooth_no_q2	    = retVal_arr[5];
			gs_dflt_tooth_no_q3	    = retVal_arr[6];
			gs_dflt_tooth_no_q4	    = retVal_arr[7];
		}
		else{
			
			gs_dflt_tooth_no_s1	= retVal_arr[6];
			gs_dflt_tooth_no_s2	= retVal_arr[7];
			gs_dflt_tooth_no_s3	= retVal_arr[8];
			gs_dflt_tooth_no_s4	= retVal_arr[9];
			gs_dflt_tooth_no_s5	= retVal_arr[10];
			gs_dflt_tooth_no_s6	= retVal_arr[11];
		}
	  }
    	if(gingival_recording_by == "Q"){
			if(gs_dflt_tooth_no_q1=='0')gs_dflt_tooth_no_q1="";
			if(gs_dflt_tooth_no_q2=='0')gs_dflt_tooth_no_q2="";
			if(gs_dflt_tooth_no_q3=='0')gs_dflt_tooth_no_q3="";
			if(gs_dflt_tooth_no_q4=='0')gs_dflt_tooth_no_q4="";
		}else{
			if(gs_dflt_tooth_no_s1=='0')gs_dflt_tooth_no_s1="";
			if(gs_dflt_tooth_no_s2=='0')gs_dflt_tooth_no_s2="";
			if(gs_dflt_tooth_no_s3=='0')gs_dflt_tooth_no_s3="";
			if(gs_dflt_tooth_no_s4=='0')gs_dflt_tooth_no_s4="";
			if(gs_dflt_tooth_no_s5=='0')gs_dflt_tooth_no_s5="";
			if(gs_dflt_tooth_no_s6=='0')gs_dflt_tooth_no_s6="";
		}
	//Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)
	//parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=GingivalStatus";
	parent.f_query_add_mod_middle.document.location.href = "../../eOH/jsp/OHDentalChartSubTabSearch.jsp?"+old_params+"&defaultTab=GingivalStatus"+"&called_from_Ging_Sts=Y";
	//
    old_params = old_params+"&gs_dflt_tooth_no_Q1="+gs_dflt_tooth_no_q1+"&gs_dflt_tooth_no_Q2="+gs_dflt_tooth_no_q2+"&gs_dflt_tooth_no_Q3="+gs_dflt_tooth_no_q3+"&gs_dflt_tooth_no_Q4="+gs_dflt_tooth_no_q4+"&gs_dflt_tooth_no_s1="+gs_dflt_tooth_no_s1+"&gs_dflt_tooth_no_s2="+gs_dflt_tooth_no_s2+"&gs_dflt_tooth_no_s3="+gs_dflt_tooth_no_s3+"&gs_dflt_tooth_no_s4="+gs_dflt_tooth_no_s4+"&gs_dflt_tooth_no_s5="+gs_dflt_tooth_no_s5+"&gs_dflt_tooth_no_s6="+gs_dflt_tooth_no_s6;
	document.location.href = "../../eOH/jsp/GingivalStatus.jsp?"+old_params;
	
    var dentalChartFormObj = parent.parent.frames[1].document.dentalChartMainForm;
	
	//To reset Error Msg Frame
	//parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	

   // This code is to reset the Arch checkboxes
	dentalChartFormObj.selL.checked=false; // Lower Arch
	dentalChartFormObj.selU.checked=false;	// Upper Arch
  //This code is to reset the Quadrant checkboxes
	dentalChartFormObj.sel1.checked=false; // Upper Right
	dentalChartFormObj.sel2.checked=false; // Upper Left
	dentalChartFormObj.sel3.checked=false; // Lower Left
	dentalChartFormObj.sel4.checked=false; // Lower Right

   if(document.getElementById("status_show_yn") != null){
		document.getElementById("status_show_yn").innerHTML = "&nbsp;";
		document.getElementById("status_legend").innerHTML = "&nbsp;";
	}
}

//when click on record actionToServlet() will call
function actionToServlet(){
	var frm=document.forms[0];
	var params = frm.params.value;
	var dentalChartFormObj = parent.parent.conditionDentalChartDetails;
	var clinical_group_code = parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.value;

	if(frm != null){
		var site_label=getLabel("Common.Site.labe","Common");
		var area_label=getLabel("Common.area.label","Common");
		var tooth_label=getLabel("eOH.ToothNo.Label","OH");
		var status_label=getLabel("eOH.GingivalStatus.Label","OH");

		var called_from_viewchart_yn = frm.called_from_viewchart_yn.value;
		frm.clinical_group_code.value = clinical_group_code
		
		
		//var names = new Array (site_label, area_label,tooth_label,gingival_label,status_label);
		//var fields = new Array (frm.oh_site,frm.oh_area,frm.oh_tooth,frm.oh_gingival,frm.oh_status);
		var names = new Array (site_label, area_label,tooth_label, status_label);
		var fields = new Array (frm.oh_site,frm.oh_area,frm.oh_tooth,frm.oh_status);
		var messageFrame = parent.parent.parent.parent.parent.messageFrame;
		if(checkFieldsofMst( fields, names, messageFrame)){
			var dentalchartFormObj = parent.parent.conditionDentalChartDetails.document.forms[0];
			frm.chart_hdr_insert_yn.value  = dentalchartFormObj.chart_hdr_insert_yn.value;
			var tooth_not_present = "N";
			/*
			if(status == "E"){
				checkStatusGS();
				GS_Tab_Reset(document.forms[0]);
			 }
			 */
			 if(called_from_viewchart_yn == "Y"){
				 //Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)			
				 //var status=frm.status_mark.value;
				 	//var status="O";
					//checkStatusGS(status);
					checkBeforeAfterCondition(frm.oh_tooth);
					checkStatusGS(frm.status_before_after.value);
					GS_Tab_Reset(document.forms[0]);
			 }
			 else{
				 if(checkBeforeAfterCondition(frm.oh_tooth)) {
					 if(checkPopulateGS()==true){
						 if(checkRestrictToothGS(frm.oh_tooth.value)==true){
							if(checkMissingTooth(frm.oh_tooth)){
							  	tooth_not_present = "Y";
								frm.submit();
								GS_Tab_Reset(document.forms[0]);
								dentalchartFormObj.chart_hdr_insert_yn.value = "N";
							}
						}
						else{
							tooth_not_present = "N";
						}
					}
			    }
				
			 }

			if(clinical_group_code != ""){ //Added inside Mandatory check by Sridevi Joshi on 5/27/2010 for IN021651
				parent.f_query_add_mod_middle.document.forms[0].oh_clinical_group.disabled = "true";
			}

			var view_frame = parent.parent.conditionDentalChartView;
			view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);
			view_frame.expandMenu('menuGS',view_frame.document.forms[0].GS_arrow);

			//Added by Sridevi Joshi on 1/19/2010 for IN010939(SRR20056-CRF-0490).To refresh the Summary Menu once GS is recorded.
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);
			view_frame.expandMenu('menuSummary',view_frame.document.forms[0].GS_arrow);
		}
	}

	isExfoliatedAfter = false;
	isEruptedBeforeAfter = false;
	isExfoliatedDeciduous = false;
	isExfoliatedMissing = false;
	isErupted = false;
	isDeciduousTooth = false;
}

//for checking Duplicate values ,quadrant,tooth,condition should not be duplicate
function checkPopulateGS(){
	

    var formObj = document.GingivalStatus;
	var err_value=1;
    var patient_id=formObj.patient_id.value;
    var chart_num=formObj.chart_num.value;
    var quadrant_sno=formObj.oh_area.value;
	var tooth_no=formObj.oh_tooth.value;
	var gingival_status_code=formObj.oh_status.value;
	var gingival_recording_by=formObj.gingival_recording_by.value;
	var other_chart_facility_id=formObj.other_chart_facility_id.value;
	var oh_chart_level=formObj.oh_chart_level.value;

	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var mapped_tooth_no = formObj.mapped_tooth_no.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	//var status_value = formObj.status_before_after_GS.value;
	//
	var disply_tooth_no_exfoliation = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&numbering_system="+tooth_numbering_system;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal=localTrimString(retVal);
	if(retVal.length > 0){
		disply_tooth_no_exfoliation = retVal;
	}
	var disply_tooth_no_deciduous = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_decith= trimString(xmlHttp.responseText);
	var retVal_decith_arr = retVal_decith.split("##");
	disply_tooth_no_deciduous = retVal_decith_arr[0];  

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&gingival_recording_by="+gingival_recording_by+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateGSArea&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr =retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var area_arr = retVal_arr[i].split("##");
		      if(quadrant_sno==area_arr[0]){
				 if(tooth_no==area_arr[1]){
					//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					// if(isErupted && area_arr[4] != "R"){
					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P"){
						//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
						  //if(area_arr[4] != "P"  && area_arr[4] != "N"  && area_arr[4] != "C" && ((isDeciduousTooth  &&  area_arr[4] != "D") || (isExfoliatedMissing && isErupted))) {
						  if(area_arr[4] != "P" && ((isDeciduousTooth  &&  area_arr[4] != "D") || (isExfoliatedMissing && isErupted))) {
					 		checkStatusGS("Y");//Status is updated to Y if an already recorded GS is ignored upon eRuption
							
							var msg = getMessage("APP-OH000117","OH");
							var msg_arr = msg.split("##");
							if(area_arr[4] == "D"){
							   tooth_no =  disply_tooth_no_deciduous;
							}
							else{
								tooth_no =  disply_tooth_no_exfoliation;
							}
							alert(msg_arr[0] + tooth_no + msg_arr[1]);
							parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						}
						else
						{
							//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
							//if(area_arr[4] != "N"  && area_arr[4] != "C"){
								alert(getMessage("DUPLICATE_CODE_EXISTS","COMMON"));
								err_value=0;
							//}
						}
					}
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){ 
					    //if(isExfoliatedMissing && isErupted && area_arr[4] != "A"){
						//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					    //if(isExfoliatedMissing && isErupted && area_arr[4] != "A" && area_arr[4] != "N"  && area_arr[4] != "C"){
					    if(isExfoliatedMissing && isErupted && area_arr[4] != "A"){

					 		checkStatusGS("Y");//Status is updated to Y if an already recorded GS is ignored upon eRuption
							var msg = getMessage("APP-OH000117","OH");
							var msg_arr = msg.split("##");
							alert(msg_arr[0]+disply_tooth_no_exfoliation+msg_arr[1]);
							parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						}
						else{
							//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
							//if(area_arr[4] != "N" && area_arr[4] != "C"){
								alert(getMessage("DUPLICATE_CODE_EXISTS","COMMON"));
								err_value=0;
							//}
						}
					}
					 else{
										
							alert(getMessage("DUPLICATE_CODE_EXISTS","COMMON"));
							err_value=0;
							
					 
					 }
					
			   }
		    }
       }
  }
	if(err_value==1){
		return  true;
	}
	else{
		parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
		return  false;
	  }  
}

//for loading tooth when we clicked on R.H.S. menu
function loadToothNo(val_tooth_no){
	var formObj= document.forms[0];
    var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var ns_quadrant = formObj.quadrant_sno.value;
	var gingival_recording_by = formObj.gingival_recording_by.value;
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	
	//Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var oh_chart_level = formObj.oh_chart_level.value;
	var other_chart_facility_id = formObj.other_chart_facility_id.value;
	//

    clear_list(formObj.oh_tooth);  
	var optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= ''; 
	formObj.oh_tooth.add(optSel);


    var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = "ns_quadrant="+ns_quadrant+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&gingival_recording_by="+gingival_recording_by+"&mixed_dentition_YN="+mixed_dentition_YN;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=populateToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr =retVal.split("~");
		/*for(i=0;i<retVal_arr.length-1;i++){
			var tooth_no_arr = retVal_arr[i].split("##");															
			var element 	= document.createElement('OPTION');
			element.value 	= tooth_no_arr[0];
			element.text 	= tooth_no_arr[1];
			formObj.oh_tooth.add(element);
			
	   	}*/
		
		if(gingival_recording_by == "Q"){
			if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
				
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					var disply_tooth_no_exfoliation = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no_exfoliation = retVal;
					}
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}*/
					if(retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "A"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= disply_tooth_no_exfoliation;
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					else if(retVal_Status == "R"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					/*else {
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];											
					} */
					 formObj.oh_tooth.add(element);
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='2' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					if(i!=7){
					
										
					var disply_tooth_no_exfoliation = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no_exfoliation = retVal;
					}
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}*/
					if(retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "A"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= disply_tooth_no_exfoliation;
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					else if(retVal_Status == "R"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					formObj.oh_tooth.add(element);
					}
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" && (ns_quadrant=='1' || ns_quadrant=='3')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
									
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
				
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(formObj.status_before_after.value == "C"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val  = tooth_no_arr[2];
					} */
					if(retVal_Status == "P"  || retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "A" ){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "D"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					formObj.oh_tooth.add(element);
				//	}
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" && (ns_quadrant=='2' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					if(i!=7){
										
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(formObj.status_before_after.value == "C"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val  = tooth_no_arr[2];
					}*/
					if(retVal_Status == "P"  || retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "D"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					
					 formObj.oh_tooth.add(element);
					}
				}
			}
			else{
			
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");


					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);

					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}  */
					if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s" ;
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "R"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0] ;
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else{
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] ;
					   ns_quadrant_val  = tooth_no_arr[2];				
					}
					formObj.oh_tooth.add(element);
								
				}
			}
		}else{
			if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='1' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					
					var disply_tooth_no_exfoliation = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					retVal=localTrimString(retVal);
					if(retVal.length > 0){
						disply_tooth_no_exfoliation = retVal;
					}
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}  */
					if(retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "A"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= disply_tooth_no_exfoliation;
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					else if(retVal_Status == "R"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					 formObj.oh_tooth.add(element);
				  		
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='3' || ns_quadrant=='6')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-2;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
						if(i!=7){
						   var disply_tooth_no_exfoliation = "";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no_exfoliation = retVal;
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith = trimString(xmlHttp.responseText);
							var retVal_decith_arr = retVal_decith.split("##");

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_Status = trimString(xmlHttp.responseText);
							//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
						/*	if(formObj.status_before_after.value == "N"){  //Coming from RHS
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1];
							   ns_quadrant_val  = tooth_no_arr[2];
							} */
							if(retVal_Status == "B"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1];
							   ns_quadrant_val  = tooth_no_arr[2];
							}
							else if(retVal_Status == "A"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= disply_tooth_no_exfoliation;
							   ns_quadrant_val = tooth_no_arr[2];											
							}
							else if(retVal_Status == "S"){
							  element.value 	= tooth_no_arr[0];
							  element.text 	= tooth_no_arr[1] + "s";
							  ns_quadrant_val  = tooth_no_arr[2];											
							}
							else if(retVal_Status == "R"){
							  element.value 	= tooth_no_arr[0];
							  element.text 	    = retVal_decith_arr[0];
							  ns_quadrant_val  = tooth_no_arr[2];											
							}
						 formObj.oh_tooth.add(element);
						}
				}
			} 
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D" && (ns_quadrant=='2' || ns_quadrant=='5')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
						if(i!=7){
							var disply_tooth_no_exfoliation = "";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[3]+"&numbering_system="+tooth_numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							retVal=localTrimString(retVal);
							if(retVal.length > 0){
								disply_tooth_no_exfoliation = retVal;
							}

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_decith = trimString(xmlHttp.responseText);
							var retVal_decith_arr = retVal_decith.split("##");

							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal_Status = trimString(xmlHttp.responseText);
							//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
							/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1];
							   ns_quadrant_val  = tooth_no_arr[2];
							} */
							if(retVal_Status == "B"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1];
							   ns_quadrant_val  = tooth_no_arr[2];
							}
							else if(retVal_Status == "A"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= disply_tooth_no_exfoliation;
							   ns_quadrant_val = tooth_no_arr[2];											
							}
							else if(retVal_Status == "S"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= tooth_no_arr[1] + "s";
							   ns_quadrant_val  = tooth_no_arr[2];											
							}
							else if(retVal_Status == "R"){
							   element.value 	= tooth_no_arr[0];
							   element.text 	= retVal_decith_arr[0];
							   ns_quadrant_val  = tooth_no_arr[2];											
							}
							 formObj.oh_tooth.add(element);
						}
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" && (ns_quadrant=='1' || ns_quadrant=='4')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=1;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					
					
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_decith = trimString(xmlHttp.responseText);
					var retVal_decith_arr = retVal_decith.split("##");

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal_Status = trimString(xmlHttp.responseText);
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					} */
					if(retVal_Status == "P"  || retVal_Status == "B"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1];
					   ns_quadrant_val  = tooth_no_arr[2];
					}
					else if(retVal_Status == "D"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= retVal_decith_arr[0];
					   ns_quadrant_val = tooth_no_arr[2];											
					}
					else if(retVal_Status == "S"){
					   element.value 	= tooth_no_arr[0];
					   element.text 	= tooth_no_arr[1] + "s";
					   ns_quadrant_val  = tooth_no_arr[2];											
					}
					 formObj.oh_tooth.add(element);
				}
			}
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" && (ns_quadrant=='3' || ns_quadrant=='6')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-2;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					if(i!=7){
						
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_decith = trimString(xmlHttp.responseText);
						var retVal_decith_arr = retVal_decith.split("##");

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_Status = trimString(xmlHttp.responseText);
						//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
						/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1];
						   ns_quadrant_val  = tooth_no_arr[2];
						}  */
						if(retVal_Status == "P"  || retVal_Status == "B"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1];
						   ns_quadrant_val  = tooth_no_arr[2];
						}
						else if(retVal_Status == "D"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= retVal_decith_arr[0];
						   ns_quadrant_val = tooth_no_arr[2];											
						}
						else if(retVal_Status == "S"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1] + "s";
						   ns_quadrant_val  = tooth_no_arr[2];											
						}
						 formObj.oh_tooth.add(element);
					}
				}
			} 
			else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P" && (ns_quadrant=='2' || ns_quadrant=='5')){//this block is for if mixed_dentition_YN=="Y" than skip the starting tooth no 
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");
					var element 	= document.createElement("OPTION");
					if(i!=7){
						
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_decith = trimString(xmlHttp.responseText);
						var retVal_decith_arr = retVal_decith.split("##");

						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal_Status = trimString(xmlHttp.responseText);
						//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
						/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1];
						   ns_quadrant_val  = tooth_no_arr[2];
						}*/
						if(retVal_Status == "P" || retVal_Status == "B"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1];
						   ns_quadrant_val  = tooth_no_arr[2];
						}
						else if(retVal_Status == "D"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= retVal_decith_arr[0];
						   ns_quadrant_val = tooth_no_arr[2];											
						}
						else if(retVal_Status == "S"){
						   element.value 	= tooth_no_arr[0];
						   element.text 	= tooth_no_arr[1] + "s";
						   ns_quadrant_val  = tooth_no_arr[2];											
						}
						 formObj.oh_tooth.add(element);
					}
				}
			} else{
			
				for(i=0;i<retVal_arr.length-1;i++){
					var tooth_no_arr = retVal_arr[i].split("##");	
					var element 	= document.createElement("OPTION");//for getting the tooth becoz its depends on quadrent
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no_arr[0]+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal_decith = trimString(xmlHttp.responseText);
				var retVal_decith_arr = retVal_decith.split("##");


				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no_arr[0]+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getToothStatus&"+params,false);
				xmlHttp.send(xmlDoc);

				var retVal_Status = trimString(xmlHttp.responseText);
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				/*if(formObj.status_before_after.value == "N"){  //Coming from RHS
				   element.value 	= tooth_no_arr[0];
				   element.text 	= tooth_no_arr[1];
				   ns_quadrant_val  = tooth_no_arr[2];
				} */
				if(retVal_Status == "S"){
				   element.value 	= tooth_no_arr[0];
				   element.text 	= tooth_no_arr[1] + "s" ;
				   ns_quadrant_val  = tooth_no_arr[2];
				}
				else if(retVal_Status == "R"){
				   element.value 	= tooth_no_arr[0];
				   element.text 	= retVal_decith_arr[0] ;
				   ns_quadrant_val  = tooth_no_arr[2];
				}
				else{
				   element.value 	= tooth_no_arr[0];
				   element.text 	= tooth_no_arr[1] ;
				   ns_quadrant_val  = tooth_no_arr[2];				
				}
				formObj.oh_tooth.add(element);
				}
			}
		}
	}
	formObj.oh_tooth.value=val_tooth_no; 
}  

// if staus is selected as  "E" then this function will call
function checkStatusGS(status){
	var formObj= document.GingivalStatus;
	var  patient_id=formObj.patient_id.value;

	var  quadrant_sno=formObj.oh_area.value;
	var  tooth_no=formObj.oh_tooth.value;
	var  gingival_status_code=formObj.oh_status.value;
	var  gingival_recording_by=formObj.gingival_recording_by.value;
	//var  status=formObj.status_mark.value;


	formObj.quadrant_sno_hid.value = quadrant_sno;
	formObj.tooth_no_hid.value=tooth_no;
	formObj.gingival_status_code_hid.value=gingival_status_code;
	formObj.status_hid.value=status;

	var quadrant_sno_hid=  formObj.quadrant_sno_hid.value;
	var tooth_no_hid=  formObj.tooth_no_hid.value;
	var gingival_status_code_hid=  formObj.gingival_status_code_hid.value;
	var status_hid=  formObj.status_hid.value;
	
	//Added by Sharon Crasta on 4/7/2010 for IN018169
	//While updating the status, the chart_num also should be taken into consideration else if there is a deciduous chart GS for tooth no 75 and Active chart is MD , while updating the GS status of tooth 75 will get updated even for the Deciduous chart.
	var chart_num = formObj.chart_num.value;
	//End
	var xmlDoc = "" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&quadrant_sno_hid="+quadrant_sno_hid+"&tooth_no_hid="+tooth_no_hid+"&gingival_status_code_hid="+gingival_status_code_hid+"&status_hid="+status_hid+"&status="+status+"&gingival_recording_by="+gingival_recording_by+"&chart_num="+chart_num;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=updateStatus&"+params,false);
	xmlHttp.send(xmlDoc);
	var status_msg = trimString(xmlHttp.responseText);

	var msg = getMessage("RECORD_INSERTED", "SM");
	if(status_msg == "UPDATE"){
		parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
}


//for checking the restrict no of tooth
function checkRestrictToothGS(tooth_no){
	var formObj = document.GingivalStatus;
    var  patient_id=formObj.patient_id.value;
    var tooth_numbering_system = formObj.tooth_numbering_system.value;
    var chart_num = formObj.chart_num.value;
	var quadrant_sno = formObj.oh_area.value;
	var called_from_viewchart_yn = formObj.called_from_viewchart_yn.value;
	var gingival_recording_by = formObj.gingival_recording_by.value;
	var  other_chart_facility_id=formObj.other_chart_facility_id.value;
	var  oh_chart_level=formObj.oh_chart_level.value;
	var  permanent_deciduous_flag=formObj.permanent_deciduous_flag.value;
   //Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
	var  mixed_dentition_YN=formObj.mixed_dentition_YN.value;
	var  chart_type=formObj.chart_type.value;
  	//
	var err_value=1;
   
	var gs_no_of_tooth_for_q1="";
    var gs_no_of_tooth_for_q2="";
    var gs_no_of_tooth_for_q3="";
    var gs_no_of_tooth_for_q4="";

	var gs_dflt_tooth_no_q1="";
    var gs_dflt_tooth_no_q2="";
    var gs_dflt_tooth_no_q3="";
    var gs_dflt_tooth_no_q4="";

    var gs_no_of_tooth_for_s1="";
    var gs_no_of_tooth_for_s2="";
    var gs_no_of_tooth_for_s3="";
    var gs_no_of_tooth_for_s4="";
    var gs_no_of_tooth_for_s5="";
    var gs_no_of_tooth_for_s6="";

	var gs_dflt_tooth_no_s1="";
    var gs_dflt_tooth_no_s2="";
    var gs_dflt_tooth_no_s3="";
    var gs_dflt_tooth_no_s4="";
    var gs_dflt_tooth_no_s5="";
    var gs_dflt_tooth_no_s6="";

    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
    //Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
	//var params = "tooth_numbering_system="+tooth_numbering_system+"&gingival_recording_by="+gingival_recording_by+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var params = "tooth_numbering_system="+tooth_numbering_system+"&gingival_recording_by="+gingival_recording_by+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&mixed_dentition_YN="+mixed_dentition_YN+"&chart_type="+chart_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=restrictQuadrantGS&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	 if(retVal.length >1){
		//var retVal_arr =retVal.split("~");
		var retVal_arr = retVal.split("##");
		if(gingival_recording_by == "Q"){
			gs_no_of_tooth_for_q1 	= retVal_arr[0];
			gs_no_of_tooth_for_q2	= retVal_arr[1];
			gs_no_of_tooth_for_q3	= retVal_arr[3];
			gs_no_of_tooth_for_q4	= retVal_arr[2];

			gs_dflt_tooth_no_q1	= retVal_arr[4];
			gs_dflt_tooth_no_q2	= retVal_arr[5];
			gs_dflt_tooth_no_q3	= retVal_arr[7];
			gs_dflt_tooth_no_q4	= retVal_arr[6];

		}
		else{
			gs_no_of_tooth_for_s1 	= retVal_arr[0];
			gs_no_of_tooth_for_s2	= retVal_arr[1];
			gs_no_of_tooth_for_s3	= retVal_arr[2];
			gs_no_of_tooth_for_s4	= retVal_arr[3];
			gs_no_of_tooth_for_s5	= retVal_arr[4];
			gs_no_of_tooth_for_s6	= retVal_arr[5];

			gs_dflt_tooth_no_s1	= retVal_arr[6];
			gs_dflt_tooth_no_s2	= retVal_arr[7];
			gs_dflt_tooth_no_s3	= retVal_arr[8];
			gs_dflt_tooth_no_s4	= retVal_arr[9];
			gs_dflt_tooth_no_s5	= retVal_arr[10];
			gs_dflt_tooth_no_s6	= retVal_arr[11];
		}
	}

    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&gingival_recording_by="+gingival_recording_by+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=restrictToothGS&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);

	var dflt_recorded = "N";
	var msg = "";

	if(gingival_recording_by == "Q"){
		gs_no_of_tooth=eval("gs_no_of_tooth_for_q"+quadrant_sno);
		gs_dflt_tooth_no=eval("gs_dflt_tooth_no_q"+quadrant_sno);
		//msg = getMessage("APP-OH00042","OH");
	}
	else{
		gs_no_of_tooth=eval("gs_no_of_tooth_for_s"+quadrant_sno);
		gs_dflt_tooth_no=eval("gs_dflt_tooth_no_s"+quadrant_sno);
		//msg = getMessage("APP-OH00091","OH");
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "dflt_tooth="+gs_dflt_tooth_no+"&tooth_numbering_system="+tooth_numbering_system;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=getDisplayToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	//var display_tooth_no = trimString(xmlHttp.responseText);
	var display_tooth_no = localTrimString(xmlHttp.responseText);
	
	var disply_ns_tooth_no_1 = "";
	var disply_ns_tooth_no_2 = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+gs_dflt_tooth_no+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_decith= localTrimString(xmlHttp.responseText);
	var retVal_decith_arr = retVal_decith.split("##");

	disply_ns_tooth_no_1 = retVal_decith_arr[0];
	disply_ns_tooth_no_2 = retVal_decith_arr[1];

	if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" ){
		if(isDeciduousTooth ){
			display_tooth_no = 	display_tooth_no + "(P) / " + disply_ns_tooth_no_1 + "(D)";
		}
	}
	
	if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" ){
		if(isExfoliatedMissing){
			display_tooth_no = 	display_tooth_no + "(D) / " + disply_ns_tooth_no_1 + "(P)";
		}
		
	}

	if(gs_no_of_tooth == "1" && retVal.length == 0){
		//if(checkMissingTooth(tooth_no,"RS_VAL")){
			if(tooth_no == gs_dflt_tooth_no){
				err_value=1;
			}
			else{
				//if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){
				   //Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
					//if(mixed_dentition_YN == "N" && (chart_type == "RA" || chart_type == "RD")){
					if(gs_dflt_tooth_no != 0) {
						//Condition added by Sridevi Joshi on 090909 for CRF-457(IN009739) to ignore default tooth check on missing or exfoliated tooth
						if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){
							var msg = getMessage("APP-OH00090","OH")+ " " +display_tooth_no;
							alert(msg);
							err_value=0;
							parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						}else{
							err_value=1;
						}
					}
				//}
				else{
					err_value=1;		
			}
		}
	//}
}


	 if(retVal.length >1){
		var retVal_arr =retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var quadrant_val = retVal_arr[i].split("##");
			if(gingival_recording_by == "Q"){
				gs_no_of_tooth=eval("gs_no_of_tooth_for_q"+quadrant_sno);
				gs_dflt_tooth_no=eval("gs_dflt_tooth_no_q"+quadrant_sno);
				msg = getMessage("APP-OH00042","OH");
			}
			else{
				gs_no_of_tooth=eval("gs_no_of_tooth_for_s"+quadrant_sno);
				gs_dflt_tooth_no=eval("gs_dflt_tooth_no_s"+quadrant_sno);
				msg = getMessage("APP-OH00091","OH");
			}
			
			//if(mixed_dentition_YN == "Y" && chart_type == "RM"){
			//In case of MD cases, if no default tooth is specified, gs_dflt_tooth_no will be 0.
			if(gs_dflt_tooth_no == 0){
				if(quadrant_sno == quadrant_val[0]){
					if (quadrant_val[1] >= gs_no_of_tooth){ 
						if(called_from_viewchart_yn != "Y"){
							alert(msg);
							parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
							err_value=0;
							break;
						}
						else{
							err_value=1;
						}
					}
					else{
						err_value=1;
					}
				}
			}
			else{
			
			
			if(quadrant_sno == quadrant_val[0]){
				if (quadrant_val[1] >= gs_no_of_tooth){ 
					if(called_from_viewchart_yn != "Y"){
						alert(msg);
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						err_value=0;
						break;
					}
					else{
						err_value=1;
					}
				}
				else{
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&gingival_recording_by="+gingival_recording_by+"&quadrant_sno="+quadrant_sno+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=selectToothNoRecordedForGS&"+params,false);
					xmlHttp.send(xmlDoc);
					var retVal = trimString(xmlHttp.responseText);
					if(retVal.length >1){
						var retVal_arr =retVal.split("~");
						for(i=0;i<retVal_arr.length-1;i++){
							if(retVal_arr[i] != gs_dflt_tooth_no){  //To check default tooth is recorded
								dflt_recorded = 'N';
							}
							else{
								dflt_recorded = 'Y';
								break;
							}
						}

						if(dflt_recorded == "Y"){
							err_value=1;
						}
						else{
							if(parseInt(quadrant_val[1])+1 == gs_no_of_tooth){
								//if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){

									if(tooth_no == gs_dflt_tooth_no){
										err_value=1;
									}
									else{
										 //Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
										//if(mixed_dentition_YN == "N" && (chart_type == "RA" || chart_type == "RD")){
										if(gs_dflt_tooth_no != 0) {
										//
										//Condition added by Sridevi Joshi on 090909 for CRF-457(IN009739) to ignore default tooth check on missing or exfoliated tooth
										if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){
											var msg = getMessage("APP-OH00090","OH")+ " " +display_tooth_no;
											alert(msg);
											err_value=0;
											parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
											break;
										}
										else{
											err_value=1;
										}
										}
									}
								//}
							}
						}
					}
				}
			}
			else{

				if(gs_no_of_tooth == "1"){
				//	if(checkMissingTooth(tooth_no,"RS_VAL",gs_dflt_tooth_no,gs_no_of_tooth)){
						if(tooth_no == gs_dflt_tooth_no){
							err_value=1;
						}
						else{
							//if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){
								
								var xmlDoc = "" ;
								var xmlHttp = new XMLHttpRequest();
								var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&gingival_recording_by="+gingival_recording_by+"&quadrant_sno="+quadrant_sno+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
								var xmlStr ="<root><SEARCH ";
								xmlStr +=" /></root>";
								xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
								xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=selectToothNoRecordedForGS&"+params,false);
								xmlHttp.send(xmlDoc);
								var retVal = trimString(xmlHttp.responseText);

								if(retVal.length >1){
									var retVal_arr =retVal.split("~");
									var count = 0;
									for(i=0;i<retVal_arr.length-1;i++){
										count++;
										if(retVal_arr[i] != gs_dflt_tooth_no){  //To check default tooth is recorded
											dflt_recorded = 'N';
										}
										else{
											dflt_recorded = 'Y';
											break;
										}
										
									}
								}
								if(dflt_recorded == "N"){
									 //Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
									//if(mixed_dentition_YN == "N" && (chart_type == "RA" || chart_type == "RD")){
									 if(gs_dflt_tooth_no != 0) {
									
										//Condition added by Sridevi Joshi on 090909 for CRF-457(IN009739) to ignore default tooth check on missing or exfoliated tooth
										if(checkMissingTooth(gs_dflt_tooth_no,"RS_VAL")){
											var msg = getMessage("APP-OH00090","OH")+ " " +display_tooth_no;
											alert(msg);
											parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
											err_value=0;
											break;
										}
										else{
											err_value=1;
										}
									}
								}
								else{
									if(count >=1){
										if(gingival_recording_by == "Q"){
											gs_no_of_tooth=eval("gs_no_of_tooth_for_q"+quadrant_sno);
											gs_dflt_tooth_no=eval("gs_dflt_tooth_no_q"+quadrant_sno);
											msg = getMessage("APP-OH00042","OH");
										}
										else{
											gs_no_of_tooth=eval("gs_no_of_tooth_for_s"+quadrant_sno);
											gs_dflt_tooth_no=eval("gs_dflt_tooth_no_s"+quadrant_sno);
											msg = getMessage("APP-OH00091","OH");
										}
										if(called_from_viewchart_yn != "Y"){
											parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
											alert(msg);
											err_value=0;

											break;
										}
									}
								}
							/*}
							else{
								err_value=1;
							} */
						}
					//}
				}
			}
		}
	 }//Added by Sharon Crasta
	 }

	 if(err_value==1){
		 return  true;
	 }
	 else{
		return  false;
	 }  
}
	  
	
function checkMissingTooth(obj,called_from,gs_dflt_tooth_no,gs_no_of_tooth){
	var formObj = document.forms[0]
	if(called_from == "RS_VAL"){
		var dflt_tooth = obj;
	}
	else{
		var dflt_tooth = obj.value;
	}
	var patient_id = formObj.patient_id.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var chart_num = formObj.chart_num.value;
	var display_tooth_no = "";
	var missing_yn = "";
	var other_chart_facility_id=formObj.other_chart_facility_id.value;
	var oh_chart_level=formObj.oh_chart_level.value;
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	var erupted_yn="";
	var super_yn="";
	var MD_yn="";
	var	exfolth_yn="";
	var	decith_yn="";
	var	mapped_tooth_no="";
	var	exfolth_RD="";
	var	super_exfol_deci_tooth="";
	
	
	//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
	var mixed_dentition_YN = formObj.mixed_dentition_YN.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	//

	//Check for Missing Tooth
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	//var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&dflt_tooth="+dflt_tooth+"&tooth_numbering_system="+tooth_numbering_system+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&dflt_tooth="+dflt_tooth+"&tooth_numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=checkForMissingTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr = retVal.split("##");
		missing_yn = retVal_arr[0];
		display_tooth_no = retVal_arr[1];
		//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		erupted_yn = retVal_arr[2];
		super_yn = retVal_arr[3];
		MD_yn = retVal_arr[4];
		exfolth_yn = retVal_arr[5];
		decith_yn = retVal_arr[6];
		mapped_tooth_no =  retVal_arr[7];
		super_exfol_deci_tooth = retVal_arr[9];

	}
	var disply_tooth_no_exfoliation = "";
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
		disply_tooth_no_exfoliation = retVal;
	}
	var disply_tooth_no_deciduous = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "tooth_no="+dflt_tooth+"&numbering_system="+tooth_numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal_decith= trimString(xmlHttp.responseText);
	var retVal_decith_arr = retVal_decith.split("##");
	disply_tooth_no_deciduous = retVal_decith_arr[0];

	if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "D"){
		if(exfolth_yn == "Y" && super_exfol_deci_tooth != "Y"){
			isExfoliatedMissing = true;
			display_tooth_no = 	disply_tooth_no_exfoliation;
		}
		if(exfolth_yn == "Y" && super_exfol_deci_tooth == "Y"){
			isExfoliatedMissing = true;
		}
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
		if ((exfolth_yn == "Y" && erupted_yn == "N") || missing_yn == "Y")
		{
			if(super_yn == "" || super_yn == "null" || super_yn == null){
				if(called_from != "RS_VAL"){
					var msg = getMessage("APP-OH00074","OH");
					var msg_arr = msg.split("##");
					alert(msg_arr[0]+display_tooth_no+msg_arr[1]);
					//formObj.oh_tooth.value = parseInt(dflt_tooth)+1; 
					parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				}
				isErupted = false;
				isExfoliatedMissing = false;
				return false;
			}
			else{
				return true
			}
			isErupted = false;
			isExfoliatedMissing = false;
			return false;
		}
		
	 }
	 else if (mixed_dentition_YN=="Y" && permanent_deciduous_flag == "P"){
		if(decith_yn == "Y"){
			isDeciduousTooth = true;
		}
		if(exfolth_yn == "Y"){
			 isExfoliatedMissing = true;
		} 
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
		if ((exfolth_yn == "Y" && erupted_yn == "N") || missing_yn == "Y")
		
		{
		
			if(super_yn == "" || super_yn == "null" || super_yn == null){
				if(called_from != "RS_VAL"){
					var msg = getMessage("APP-OH00074","OH");
					var msg_arr = msg.split("##");
					alert(msg_arr[0]+display_tooth_no+msg_arr[1]);
					//formObj.oh_tooth.value = parseInt(dflt_tooth)+1; 
					parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				}
			}
			isErupted = false;
			isExfoliatedMissing = false;
			isDeciduousTooth  = false;
			return false;
		}
		
	 }
	 else if (missing_yn == "Y" || exfolth_yn == "Y")
	 {	
		if(erupted_yn == "Y" ){
			isErupted = true;
		}
		if(exfolth_yn == "Y" ){
			isExfoliatedMissing = true;
		}
		
		//if(exfolth_yn == "Y" || missing_yn == "Y"){
		if((exfolth_yn == "Y" && erupted_yn == "N") || missing_yn == "Y"){
				if(called_from != "RS_VAL"){
					var msg = getMessage("APP-OH00074","OH");
					var msg_arr = msg.split("##");
					alert(msg_arr[0]+display_tooth_no+msg_arr[1]);
					//formObj.oh_tooth.value = parseInt(dflt_tooth)+1; 
					parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				}
				return false;
			//}
		}

		if(exfolth_RD == "Y"){
		   isExfoliatedMissing = false;
		}
	 }
	
	return true;
}
//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
function checkBeforeAfterCondition(obj){
	var formObj= document.GingivalStatus;
	
	var patient_id=formObj.patient_id.value;
	var chart_num=formObj.chart_num.value;
	var other_chart_facility_id=formObj.other_chart_facility_id.value;
	var oh_chart_level=formObj.oh_chart_level.value;
	
    var tooth_no = obj.value;

	var xmlDoc = "" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&tooth_no="+tooth_no+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","GingivalStatusValidation.jsp?func_mode=checkForErupthExfolthTooth&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length > 1){
		var retVal_arr = retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[3] != "D"){
				isExfoliatedAfter = true;
			}
			if(code_desc_arr[0] == "ERUPTH" || code_desc_arr[0] == "PARERTH"){
				isEruptedAfter = true;
			}
			/*if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[3] == "R"){
				  formObj.status_before_after.value = "R";	//Display deciduous tooth
				  isExfoliatedAfter = true;
			}*/ 
			if(isExfoliatedAfter && isEruptedAfter){
				 formObj.status_before_after.value = "A";
			}
			else if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[2] == "Y"){	 //Supernumerary tooth
				// formObj.status_before_after.value = "B";			
				 formObj.status_before_after.value = "A";			
			}
			else if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[2] == "N"){
				 formObj.status_before_after.value = "S";			
			}
			else if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[3] == "D"){
				 isExfoliatedDeciduous = true;					
			}
			else if(code_desc_arr[0] == "EXFOLTH" && code_desc_arr[3] == "R"){
				  formObj.status_before_after.value = "A";	//Display deciduous tooth
				 // isExfoliatedAfter = true;
			}
			else if(isExfoliatedDeciduous && isEruptedAfter){
				 formObj.status_before_after.value = "P"; //Display permanent tooth
				// formObj.status_before_after_GS.value = "";
			}
			else if(code_desc_arr[0] == "DECITH"){
				 formObj.status_before_after.value = "D";	//Display deciduous tooth								
			}
		}
	}else{
		
			formObj.status_before_after.value = "B";
		
	}
	return true;
}
//
