var isPartiallyErupted = false;
var isErupted = false;
/*
 req_id				: null
call_func			: null
pat_id 				: patient_id
appt_date			: can be passed as null
P_practitioner_id		: practitioner_id (From CA)
P_locn_code			: location_code (from CA)
recall_date			: can be passed as null
P_locn_code			: location_code (from CA)
P_locn_type			: location_type (from CA)
splty_code			: speciality_code (from CA)
selectedPractId			: practitioner_id (from CA)
selectedLocnCode		:location_code (from CA)
callingMode			: OH
module_id 			: OH
no_dwm				: initially pass it as null
visittype			: from CA	
dwm_desc			: initialy pass it as null
*/

async function getApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,module_id,no_dwm,visittype,dwm_desc,chart_num,chart_line_num,trmt_category_type,tooth_no,dentalchartFormObj,site_type,surface_code,arch,quadrant,tooth_range_nos,order_id,order_line_num,trmt_code,task_code,seq_no){

	var old_trmt_code = trmt_code;
	var appt_scheduled_yn = "N";
	var retVal  =  new String();				    
	var dialogHeight= "50vh" ;
	var dialogWidth = "70vw" ;
	var dialogTop  = "71";
	var center  = "1" ;
	var status  = "no";
	
	var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

	//var referral_id = "N" ;
	var referral_id = "" ; //Channged to null as requested by OA(Sudhakar and Marimuttu) for IN017535

	var parameters = "i_practitioner_id="+P_practitioner_id+"&practitioner_id="+P_practitioner_id+"&patient_id="+pat_id+"&i_clinic_code="+P_locn_code+"&clinic_code="+P_locn_code+"&recall_date="+recall_date+"&location_code="+P_locn_code+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+"&request_id="+req_id+"&appt_date="+appt_date+"&callingMode=OH&module_id=OH&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&order_id="+order_id+"&order_line_num="+order_line_num;

    var OSName="Unknown OS";
	if (navigator.appVersion.indexOf("Win")!=-1){ 
		OSName="Windows";
	}else if (navigator.appVersion.indexOf("Mac")!=-1){
		OSName="MacOS";
		
	}else if (navigator.appVersion.indexOf("X11")!=-1){
		OSName="UNIX";
	}else if (navigator.appVersion.indexOf("Linux")!=-1){
		OSName="Linux";
	}

	if(isBeforeNow(appt_date,'DMY','en')){
		alert(getMessage('APPT_LESS_THAN_SYSDATE_CANT_PROCEED','MR'));
	}else{
		var varcontext=document.forms[0].ohContext.value;
		if (OSName=="Windows"){
			retVal = await window.showModalDialog(varcontext+"/eOA/jsp/CAOAAppointment.jsp?"+parameters,arguments,features);
		}else if (OSName="Linux"){
			retVal = await window.showModalDialog(varcontext+"\\eOA/jsp/CAOAAppointment.jsp?"+parameters,arguments,features);
		}
	}

	if(retVal != null && retVal != "" && retVal!="undefined" && retVal!=undefined && retVal!="Abort"){
		var Val = retVal.split("^");
		var mode = Val[0];
		parameters = Val[1];
		if (mode=="1"){
			parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
			returnVal = await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+parameters,arguments,features);
		}else if (mode=="2"){
			parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
			returnVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+parameters,arguments,features);   
		}else if (mode=="3"){
			parameters=parameters+ "&title="+encodeURIComponent(getLabel("eMR.AppointmentforMedicalBoardRequest.label","MR"));
			returnVal = await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+parameters,arguments,features);
	   } 
		if(returnVal != null && returnVal != "" && returnVal!="undefined" && returnVal!=undefined && returnVal!="Abort"){
			var arr=new Array();
			arr=returnVal.split("&");
			var i=0;
			while(arr[i]!=null){
				var arrayElement =arr[i];
				if(arrayElement.indexOf("specialty_code")!=-1){
					var arrayOfValue = new Array();
					arrayOfValue = arrayElement.split("=");
					splty_code = arrayOfValue[1];
				}
				if(arrayElement.indexOf("practitioner_id")!=-1){
					var arrayOfValue = new Array();
					arrayOfValue = arrayElement.split("=");
					P_practitioner_id = arrayOfValue[1];
				}
				if(arrayElement.indexOf("clinic_code")!=-1){
					var arrayOfValue = new Array();
					arrayOfValue = arrayElement.split("=");
					P_locn_code = arrayOfValue[1];
				}
				 if(arrayElement.indexOf("recall_date")!=-1)
				 {
				   var arrayOfValue = new Array();
				   arrayOfValue = arrayElement.split("=");
				   recall_date = arrayOfValue[1];
				 } 
				 if(arrayElement.indexOf("care_locn_ind")!=-1)
				 {
				   var arrayOfValue = new Array();
				   arrayOfValue = arrayElement.split("=");
				   P_locn_type = arrayOfValue[1];
				 } 
				 if(arrayElement.indexOf("no_dwm")!=-1)
				 {
				   var arrayOfValue = new Array();
				   arrayOfValue = arrayElement.split("=");
				   no_dwm = arrayOfValue[1];
				 } 
				 if(arrayElement.indexOf("visittype")!=-1)
				 {
				   var arrayOfValue = new Array();
				   arrayOfValue = arrayElement.split("=");
				   visittype = arrayOfValue[1];
				 } 
				 if(arrayElement.indexOf("dwm_desc")!=-1)
				 {
				   var arrayOfValue = new Array();
				   arrayOfValue = arrayElement.split("=");
				   dwm_desc = arrayOfValue[1];
				 } 
				 i++;
			}
				
			if(returnVal !=""){
				if(returnVal.indexOf("*") != -1 && returnVal.indexOf("&") == -1){
					 var result = returnVal.split("*");
					 if(result[0] != "MR"){
						var ApptNo  = result[0];     
						appt_scheduled_yn="Y";
					 }
				}
			}

			/*if(returnVal !="" && appt_scheduled_yn=="N"){
				getApptDetails(req_id, call_func, pat_id, appt_date,P_practitioner_id,P_locn_code,recall_date,P_locn_code,P_locn_type,splty_code,selectedPractId,selectedLocnCode,callingMode,"OA",no_dwm,visittype,dwm_desc,chart_num,chart_line_num,trmt_category_type,tooth_no,dentalchartFormObj,site_type,surface_code,arch,quadrant,tooth_range_nos,order_id,order_line_num,trmt_code,task_code,seq_no);        
			}*/

	   }else{ //  else block for the 2nd returnVal condition, after calling the booking appt screen
		appt_scheduled_yn="N";
	   }
	}else{ // else block for the 1st retVal condition, after calling the OA schedule screen
		appt_scheduled_yn="N"; 
	}

	var status = "";
	if(top.content!=null){
		var frameObj = top.content.workAreaFrame.frames[2].frames[1].frames[1]; //DentalChartFrame
		var trmtFrameObj = top.content.workAreaFrame.frames[2].frames[1].frames[3]; // Data Entry Frame

	}else{
		var frameObj = parent.parent.frames[1].frames[1]; //DentalChartFrame
		var trmtFrameObj = parent.parent.frames[1].frames[3].name; // Data Entry Frame

	}
	var chart_line_num_int = parseInt(chart_line_num);
	if(appt_scheduled_yn == "Y"){
		status = updateTreatmentStatus(site_type,tooth_range_nos,pat_id,chart_num,chart_line_num,"15",chart_line_num_int,order_id,trmt_code,task_code,'','','',order_line_num, '',seq_no);
	}
	
	return appt_scheduled_yn;
}

async function placeOrder(patient_id,chart_num,chart_line_num,tooth_range_count,practitioner_id,encounter_id,location_type,location_code,patient_class,order_catalog_code,order_type_code,facility_id,trmt_code,called_from,trmt_category_type,site_type,surface_code,tooth_no,thrng_ref_nos,arch,quadrant,cusptip_ref,RD_Normal_yn,super_tooth_ref,exfolth_count,retained_tooth_no,surface_arr1,multiple_surfaces_applicable){
	var dialogHeight ='55vh' ;
	var dialogWidth = '65vw' ;
	var dialogTop	= '105';
	var dialogLeft = '147' ;
	var title = 'rewe'
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var bean_id = "externalordersbean";
	var bean_name = "eOR.ExternalOrdersBean";
	var finalString = 'patient_id='+patient_id+'&practitioner_id='+practitioner_id+'&function_from=EXTERNAL_ORDER&p_start_date_time=&p_order_catalog_code='+order_catalog_code+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&accession_type=OH&location_code='+location_code+'&location_type='+location_type+'&patient_class='+patient_class+'&called_from=OH&ext_order_category=OH&order_type_code='+order_type_code;

	if(called_from == "RHS_MENU"){
		var order_id =await  window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	}
	else{
		var order_id = await window.showModalDialog("../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	}
	if(order_id != "undefined" && order_id != undefined){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		if(multiple_surfaces_applicable=="Y"){
				var params = "order_id="+order_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&tooth_range_count="+tooth_range_count+"&trmt_code="+trmt_code;

				
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				if(called_from == "RHS_MENU"){
					xmlHttp.open("POST","../../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateOrderDetails&"+params,false);
				}else{
					xmlHttp.open("POST","../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateOrderDetails&"+params,false);
				}

				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
			//	chart_line_num++;//added by parul for multiple surface..

		}else{
			var params = "order_id="+order_id+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&tooth_range_count="+tooth_range_count+"&trmt_code="+trmt_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				if(called_from == "RHS_MENU"){
					xmlHttp.open("POST","../../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateOrderDetails&"+params,false);
				}else{
					xmlHttp.open("POST","../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateOrderDetails&"+params,false);
			}
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
		}

		var status = localTrimString(retVal);
		if(status != "" && status != "null" && status != null){ //Status
			if(top.content!=null) //added by yadav
			{
				var frameObj = top.content.workAreaFrame.frames[2].frames[1].frames[1]; //DentalChartFrame
				var frame_view_Obj = top.content.workAreaFrame.frames[2].frames[1].frames[2]; //View Details Frame
				var trmtFrameObj = top.content.workAreaFrame.frames[2].frames[1].frames[3]; // Data Entry Frame
			}
			else
			{
				var frameObj = parent.parent.frames[2].frames[1].frames[1]; //DentalChartFrame
				var frame_view_Obj = parent.parent.frames[2].frames[1].frames[2]; //View Details Frame
				var trmtFrameObj = parent.parent.frames[2].frames[1].frames[3]; // Data Entry Frame
			}
			
			trmtFrameObj.document.forms[0].RD_Normal_yn.value = RD_Normal_yn;

			frame_view_Obj.expandMenu('menu1',frame_view_Obj.document.forms[0].T_arrow);
			frame_view_Obj.expandMenu('menu1',frame_view_Obj.document.forms[0].T_arrow);

			if(site_type == "THRNG"){
				tooth_no = thrng_ref_nos
			}
			else if(site_type == "ARCH"){
				tooth_no = arch;
			}
			else if(site_type == "QUAD"){
				tooth_no = quadrant;
			}
			else{
				tooth_no = tooth_no;
			}

			if(site_type == "TOOTH" || site_type == "THRNG"){
				if(called_from == "RHS_MENU"){
					getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'rhs_menu',super_tooth_ref,exfolth_count,retained_tooth_no);
				}
				else{
					getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'servlet_menu',super_tooth_ref,exfolth_count,retained_tooth_no);
				}
				//imageReplace(trmt_category_type,tooth_no,frameObj,site_type,status,trmtFrameObj.document.forms[0],'',surface_code,arch,quadrant);
				//imageReplace(trmt_category_type,tooth_no,frameObj,site_type,status,trmtFrameObj.document.forms[0],'',surface_code);
			}
			else if(site_type == "ARCH" || site_type == "QUAD"){
				if(trmt_category_type != "TOOTHTM"){
					if(called_from == "RHS_MENU"){
						getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'rhs_menu');
					}
					else{
						getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'servlet_menu');
					}
				}
			}
			else if(site_type == "CROWN"){
				if (exfolth_count=="undefined" || exfolth_count==undefined){
					exfolth_count="";
				}
				if (retained_tooth_no=="undefined" || retained_tooth_no==undefined){
					retained_tooth_no="";
				}

				var imageId = 'toothLayer'+tooth_no;
               
				if (multiple_surfaces_applicable!="Y"){//condition added by parul for multiple surface
					if (surface_arr1=="*A"){

						if(called_from == "RHS_MENU"){
						getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'rhs_menu',super_tooth_ref,exfolth_count,retained_tooth_no);
					}
					else{
						getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'servlet_menu',super_tooth_ref,exfolth_count,retained_tooth_no);
					}

						//getImageFromDB(tooth_no,site_type,chart_num,"T",trmtFrameObj.document.forms[0],frameObj.document.forms[0],'servlet_menu',super_tooth_ref,exfolth_count,retained_tooth_no);

					}else{
						//fillCrownImages(imageId,surface_arr1,frameObj,trmt_category_type,status,tooth_no,'SERVLET_RECORD',trmtFrameObj.document.forms[0]);//commented by parul for CRF-442 on 22/01/2010
						fillCrownImages(imageId,surface_arr1,frameObj,trmt_category_type,status,tooth_no,'SERVLET_RECORD',super_tooth_ref,exfolth_count,retained_tooth_no);

						drawCircleForCusp(tooth_no,frameObj,status,cusptip_ref,surface_arr1,'SERVLET_RECORD',super_tooth_ref,exfolth_count,retained_tooth_no);//added by parul for CRF#0483 on 27/08/2009

					}
				}else{
					var surface_arr1_ref=surface_arr1.split(",");
					for(var j=0;j<surface_arr1_ref.length;j++){											
						fillCrownImages(imageId,surface_arr1_ref[j],frameObj,trmt_category_type,status,tooth_no,'SERVLET_RECORD',super_tooth_ref,exfolth_count,retained_tooth_no);

						drawCircleForCusp(tooth_no,frameObj,status,cusptip_ref,surface_arr1_ref[j],'SERVLET_RECORD',super_tooth_ref,exfolth_count,retained_tooth_no);//added by parul for CRF#0483 on 27/08/2009

					}
				}
				//drawCircleForCusp(tooth_no,frameObj,status,cusptip_ref,surface_code,'SERVLET_RECORD');//added by parul for CRF#0483 on 27/08/2009
			}else if(site_type=="ROOT"){
				if (multiple_surfaces_applicable!="Y"){	//condition added by parul for multiple surface	
					drawLineForRootImage('rootLayer'+tooth_no,surface_code,frameObj.document.forms[0],trmt_category_type,"T",tooth_no,status);
				}else{
					var surface_arr1_ref=surface_arr1.split(",");
					for(var j=0;j<surface_arr1_ref.length;j++){	
						drawLineForRootImage('rootLayer'+tooth_no,surface_arr1_ref[j],frameObj.document.forms[0],trmt_category_type,"T",tooth_no,status);
					}
				}
			}
		}
	}
}


//function imageReplace(condition_type,tooth_no,frameObj,site_type,status,formObj,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,surface_code,quadrant,arch,mixed_dent_deciduous_yn,super_yn_1,super_key_num){// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )
function imageReplace(condition_type,tooth_no,frameObj,site_type,status,formObj,super_before,show_RTDESTH_EXFOLTH_image_flag,hide_image_yn,mixed_dent_deciduous_yn,super_yn_1,super_key_num,isSuprthError,surface_code,isExfolthError,retained_tooth_no,treatments_outcome,image_source,treatment_int_ext){// added by parul(added mixed_dent_deciduous_yn becoz when u record tooth trmt,supernum,Deciduoud now tooth no is D,Ds if u mark tooth trmt as error that tooth no is gong to change as 6,6s..it should be D,Ds so that we added mixed_dent_deciduous_yn in  imageReplace function )
	var dentalchartFormObj = frameObj.document.forms[0];

	var numbering_system = dentalchartFormObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = dentalchartFormObj.permanent_deciduous_flag.value;
	var mixed_dentition_YN = dentalchartFormObj.mixed_dentition_YN.value;
	var patient_id = dentalchartFormObj.patient_id.value;
	var chart_num = dentalchartFormObj.chart_num.value;
	var super_tooth_ref = document.forms[0].super_tooth_ref.value;
	var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
	var ref_tooth_no = document.forms[0].ref_tooth_no.value;

	var tooth_num = "";
	var tooth_name = "";
	var mapped_tooth_no = "";													  
	var mixed_dent_tooth_no = "";	
	var isSuperCondYN = "";
	var isRetndCondYN = "";
	var super_cnt = "";
	var status_int = 0;

	if(condition_type != null && condition_type != "null" && condition_type != "" && condition_type != "undefined"){

		if(ref_tooth_no == "" || ref_tooth_no == "null" || ref_tooth_no == null || ref_tooth_no == "undefined" || ref_tooth_no == undefined){ //Added by Sridevi Joshi when recording conditions from data entry
			if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
				RD_Normal_yn = "MR";
			}
		}

		//Added by SRidevi Joshi on 1/19/2010 for IN010894(SRR20056-CRF-0481). To get SUPRTH count.
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		params = "func_mode=checkSuperCount&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&RD_Normal_yn="+RD_Normal_yn;
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

		if(site_type == "ARCH"){
			var imageId = "A"+tooth_no;
		}else if(site_type == "QUAD"){
			var imageId = "Q"+tooth_no;
		}else if(site_type == "TOOTH"){
			var imageId = tooth_no;
		}
		if(site_type == "TOOTH" && tooth_no.indexOf(",") != -1 || site_type == "THRNG"){ 
			var selected_first_thno = document.forms[0].selected_first_thno.value;
			var tooth_no_arr = tooth_no.split(",");
			for(var k=0;k<tooth_no_arr.length;k++){
				var tooth_sn = tooth_no_arr[k];

				//To retrieve the display tooth_no and the tooth_name...
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
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

				if(status == 'E'){
					if( condition_type == "MISSTH"){
						var imageId = "T"+tooth_no_arr[k];
						var imageSrc = "../../eOH/images/T.gif";	

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='45' height='25'/></div>";
						var imageId = "R"+tooth_no_arr[k];

						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){ // 29feb BSHANKAR
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							var imageId = "T"+tooth_no_arr[k];

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						}
					}
					else if(condition_type == "EXFOLTH"){
						//var RD_Normal_yn  = document.forms[0].RD_Normal_yn.value; // This value will be 'S' if we record any condition on supernumary tooth (ex : on 12s)

						var query_tooth_no = tooth_no_arr[k];
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){ // For Mixed Dentition - Deciduous Chart
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
							if(retVal.length > 1){
								disply_tooth_no = retVal;
							}
						}
						else if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){ // For Deciduous Chart
							disply_tooth_no = tooth_num;
						}
						else{
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
							if(retVal.length > 1){
								disply_tooth_no = retVal;
							}
						}
						//if(RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						//}

						var check_num_id = "check_num"+tooth_no_arr[k];
						
						if(RD_Normal_yn == "NS"){
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else if(condition_type == "DECITH" || condition_type == "RTDESTH" || condition_type == "SUPRTH"){
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNoForJS&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 1){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = tooth_no_arr[k];
								var tooth_num = retVal;
								var tooth_name = "";

								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imgSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imgSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imgSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imgSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imgSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imgSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imgSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imgSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imgSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imgSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imgSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}

								if(tooth_no_arr[k]>=1 && tooth_no_arr[k]<=16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imgSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}
					else if(condition_type == "PARERTH"){
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							}
							else{
								var imageId = "R"+tooth_no_arr[k];
								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}
							
								var root_layer = "rootLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
								}

								if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									var imageSrc = "../../eOH/images/T.gif";	
								}
								var imageId = "T"+tooth_no_arr[k];
								var tooth_layer = "toothLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
								}
							}
						}
						else{
							var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
					}
					else if(condition_type == "ERUPTH"){
						if(tooth_no_arr[k] != '1' && tooth_no_arr[k] != '16' && tooth_no_arr[k] != '17' && tooth_no_arr[k] != '32' ){
							if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
								
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							}
							else{
								var imageId = "R"+tooth_no_arr[k];
								if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
									}
								}
								else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
										var imageSrc = "../../eOH/images/R3.gif";
									}
									else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
										var imageSrc = "../../eOH/images/R14.gif";
									}
									else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
										var imageSrc = "../../eOH/images/R19.gif";
									}
									else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
										var imageSrc = "../../eOH/images/R30.gif";
									}
									else{
										var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
									}
								}
							
								var root_layer = "rootLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
								}

								if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
									var imageSrc = "../../eOH/images/spacer.gif";	
								}
								else{
									var imageSrc = "../../eOH/images/T.gif";	
								}
								var imageId = "T"+tooth_no_arr[k];
								var tooth_layer = "toothLayer"+tooth_no_arr[k];
								if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
								}
							}
						}
						else{
							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";
							
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
					}

					if( condition_type == "EXTRACT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "IMPLANT"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D"){
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					}
					else if(condition_type == "BRIDGE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
					else if(condition_type == "DENTURE"){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

							var imageId = "R"+tooth_no_arr[k];
							if(permanent_deciduous_flag == "D"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}

							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
						}
					}
					/*else if(condition_type == "TOOTHTM"){
						var imageId = "toothLayer"+tooth_no_arr[k];
						fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no_arr[k]);

						var imageId = "rootLayer"+tooth_no_arr[k];
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no_arr[k],status);
					}*/
				}
				else{
					if(condition_type == "MISSTH"){
						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

						var imageId = "R"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
					}
					else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){// 29FEB BSHANKAR
						var show_img_yn = "N";
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num+"&patient_id="+patient_id;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
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
						if(show_img_yn == "N"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

							var imageId = "R"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
						}
					}
					else if(condition_type == "EXFOLTH"){
						var exfolth_count = 0;
						var super_recorded = "N";
						var retVal_SuperKey_count = 0;
						var total_SuperKey_count = 0;

						// This code is to get the value of the column SUPERNUMERARY_YN.This is to find out wether the tooth is supernumerary or not.
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "patient_id="+patient_id+"&tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateSuperYN&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						
						if(retVal.length >= 1){
							var retVal_arr = retVal.split("##");
							super_yn = retVal_arr[0];
							RD_yn = retVal_arr[1];
						}

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
						//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
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
						var params = "tooth_no="+tooth_no_arr[k]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&condition_type=SUPRTH";
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

						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && exfolth_count == "1" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
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

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

						}
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" & exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
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

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
							query_tooth_no = tooth_no_arr[k];
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

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
							query_tooth_no = tooth_no_arr[k];
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

							var check_num_id = "check_num"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}


						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

						var imageId = "R"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
					else if(condition_type == "RTDESTH"){ //Not Applicable to Deciduous Chart
						//Added by Sharon Crasta on 7/27/2009 for IN012514
							//	isSuperRD = true;
						//
						var disply_tooth_no = "";
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
						var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
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
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&mixed_dentition_YN="+mixed_dentition_YN+"&permanent_deciduous_flag="+permanent_deciduous_flag;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = retVal_arr[1];
								var tooth_num = retVal_arr[0];
								var tooth_name = "";
								if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
									//root_img_no = tooth_sn;
									// This condition is used when RTDESTH is recorded in MIXD Dent Dec case, where the DEC tooth is displayed 1st and then permanent tooth (51,11). In case of permanent chart, When RTDESTH is recorded, the permanent tooth is displayed 1st and then the dectooth (11,51)
									var rd_flag = 'RD';			//(51,11 case)
									var rd_normal_flag = "N";
									if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
										if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
											root_img_no = "3";
										}
										else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
											root_img_no = "14";
										}
										else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
											root_img_no = "19";
										}
										else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
											root_img_no = "30";
										}
										else{
											root_img_no = tooth_sn;
										}
									}
									else{
										root_img_no = tooth_sn;
									}
								}
								else{
									root_img_no = tooth_no_arr[k];
									var rd_flag = 'N';			//(11,51 case)
									var rd_normal_flag = "RD";
								}
								
								if(tooth_no_arr[k] >= 1 && tooth_no_arr[k] <= 16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+root_img_no+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
								else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
						
					}
					else if(condition_type == "DECITH"){ //Not Applicable for MD-D chart
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
						var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag+"&mixed_dentition_YN="+mixed_dentition_YN;
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateNSToothNo&"+params,false);
						xmlHttp.send(xmlDoc);
						var retVal = trimString(xmlHttp.responseText);
						retVal=localTrimString(retVal);
						if(retVal.length > 0){
							var retVal_arr = retVal.split("##")
							if(retVal_arr[0] !="" && retVal_arr[0] != null && retVal_arr[0] != "null"){
								var imageId = "decith_table"+tooth_no_arr[k];
								var tooth_sn = retVal_arr[1];
								var tooth_num = retVal_arr[0];
								var tooth_name = "";
								if(tooth_no_arr[k]>=1 && tooth_no_arr[k]<=16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/R" + tooth_no_arr[k] + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}
					else if(condition_type == "SUPRTH"){
						var disply_tooth_no = "";
						var numbering_system = document.forms[0].tooth_numbering_system.value;
						
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params = "tooth_no="+tooth_no_arr[k]+"&numbering_system="+numbering_system;
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
						var imageId = "decith_table"+tooth_no_arr[k];

						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
							//if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							//}
							//else{
								//var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							//}
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						else{
							if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
						}
						
						if(selected_first_thno == tooth_no_arr[k]){
							if(tooth_no_arr[k] >= 1 && tooth_no_arr[k] <= 16 || (tooth_no_arr[k]>=33 && tooth_no_arr[k]<=42)){
								if(super_before == "Y"){
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>";

								}
								else{
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>"

								}
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
							}
							else{
								if(super_before == "Y"){
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>"
								}
								else{
									inter_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "s</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" >" + disply_tooth_no + "</a>";
								}
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no_arr[k]+"' align='center'><div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td id='R"+tooth_no_arr[k]+ "' align='center'><div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" /></div></td></tr><tr><td align='center' id = 'check_num"+tooth_no_arr[k]+"' id="+tooth_no_arr[k]+"D id="+tooth_no_arr[k]+"RD id="+tooth_no_arr[k]+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','N')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "</a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + disply_tooth_no + "s</a><input type='hidden' name='selcol_hidden"+ tooth_no_arr[k] +"' id='selcol_hidden"+ tooth_no_arr[k] +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no_arr[k] +"' id='selcol"+ tooth_no_arr[k] +"' value='' onClick = \"setCheckValue(this,'"+tooth_no_arr[k]+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no_arr[k]+"' width='45'></td></tr></table></td></tr></table>";
							}
						}
						//Added by Sharon Crasta on 7/27/2009 for IN012514
						//isSuperRD = true;
						//
					}
					else if(condition_type == "PARERTH"){
						var root_layer = "rootLayer"+tooth_no_arr[k];
						var tooth_layer = "toothLayer"+tooth_no_arr[k];
						var imageId = "R"+tooth_no_arr[k];
						var show_img_yn = "N";
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_no="+tooth_no_arr[k]+"&chart_num="+chart_num+"&patient_id="+patient_id;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=SuperRDyn&"+params,false);
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
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";
						}

						var imageId = "T"+tooth_no_arr[k];
						
						if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
						}
					}
					else if(condition_type == "ERUPTH"){
					
						var imageId = "R"+tooth_no_arr[k];
						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
							if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
								var imageSrc = "../../eOH/images/R3.gif";
							}
							else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
								var imageSrc = "../../eOH/images/R14.gif";
							}
							else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
								var imageSrc = "../../eOH/images/R19.gif";
							}
							else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
								var imageSrc = "../../eOH/images/R30.gif";
							}
							else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){//For Permanent Tooth no's in MD Chart
							var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
						}
						else{
							if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
								if(tooth_no_arr[k] == "33" || tooth_no_arr[k] == "34"){
									var imageSrc = "../../eOH/images/R3.gif";
								}
								else if(tooth_no_arr[k] == "41" || tooth_no_arr[k] == "42"){
									var imageSrc = "../../eOH/images/R14.gif";
								}
								else if(tooth_no_arr[k] == "43" || tooth_no_arr[k] == "44"){
									var imageSrc = "../../eOH/images/R19.gif";
								}
								else if(tooth_no_arr[k] == "51" || tooth_no_arr[k] == "52"){
									var imageSrc = "../../eOH/images/R30.gif";
								}
								else{
									var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
								}
							}
							else{
								var imageSrc = "../../eOH/images/R"+tooth_no_arr[k]+".gif";
							}
						}
						
						var root_layer = "rootLayer"+tooth_no_arr[k];
						if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no_arr[k]+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no_arr[k] + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
						}

						var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
					}

					if(condition_type == "EXTRACT"){
						/*var imageId = "T"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

						var imageId = "R"+tooth_no_arr[k];
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";*/
						if (treatment_int_ext=="I"){
							status_int = parseInt(status);
							if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
							}
							else if(status_int == 60){
								if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='40' height='25'  src='../../eOH/images/Extraction-CrownGreen_F.gif'>";                          


									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_F.gif'>";

								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
								
								}
							}
						}else{			
							if (treatment_int_ext=="E"){
								if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_EF.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_E.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
								}
							}
						}
					}
					else if(condition_type == "IMPLANT"){
						if (treatment_int_ext=="I"){
							var imageId = "T"+tooth_no_arr[k];
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
							var imageId = "R"+tooth_no_arr[k];
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_F.gif' width='45' height=34'/>";
							}else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root.gif' width='45' height=34'/>";						
							}
						}else  if (treatment_int_ext=="E"){
							 if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_EF.gif'>";
							  
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_E.gif'>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif'>";
							}
						}

					}
					else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
						/*if (treatment_int_ext=="I"){
							if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
							
								//var imageId = "R"+tooth_no_arr[k];
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
							
								//var imageId = "R"+tooth_no_arr[k];
								//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
						} else if (treatment_int_ext=="E"){
                              if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
							
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
							
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
							
								var imageId = "R"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}

						} */
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
										if(treatments_outcome=="F"){
											var imageId = "T"+code_desc_arr[k];
											dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
																
											var imageId = "R"+code_desc_arr[k];
											dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											break;
										}else{
											var imageId = "T"+code_desc_arr[k];
											dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
																
											var imageId = "R"+code_desc_arr[k];
											dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											break;
										}
									}else{
										 if(treatment_int_ext == "E"){
											if (treatments_outcome == "F"){
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}else{
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											
											}
									   }else if(treatment_int_ext == "I"){
											if (treatments_outcome == "F"){
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}else{
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif'/>";
												
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

												
											}
									   }
								 }
							   }
							}
							else{
								if(treatment_int_ext == "E"){
									if (treatments_outcome == "F"){
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}else{
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}
								}else if(treatment_int_ext == "I"){
									if (treatments_outcome == "F"){
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}else{
										var imageId = "T"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif'/>";
								
										var imageId = "R"+tooth_no;
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
									}
								}
							} 
						}else{
							 if(treatment_int_ext == "E"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
						
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
						
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}
							 }else if(treatment_int_ext == "I"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
						
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif'/>";
						
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}
							 }
						}
					}
					else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
						if (treatment_int_ext=="I"){
							if(treatments_outcome=="F"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
							}else{
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif' width='45' height='25'/>";
							}
						  }else if (treatment_int_ext=="E"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
							}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
							}
						  }
					}
					else if(condition_type == "DENTURE"){
							if (treatment_int_ext=="I"){
								var imageId = "T"+tooth_no_arr[k];
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
									var imageId = "R"+tooth_no_arr[k];
									if(treatments_outcome=="F"){
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_F.gif'>";
									}else{
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root.gif'>";
									}
							}else if (treatment_int_ext=="E"){
								 if (treatments_outcome=="F"){
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_EF.gif'>";
									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

								}else{
									var imageId = "T"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_E.gif'>";

									var imageId = "R"+tooth_no_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
								}
							}
						}
					/*else if(condition_type == "TOOTHTM"){
						var imageId = "toothLayer"+tooth_no_arr[k];
						fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no_arr[k]);
						var imageId = "rootLayer"+tooth_no_arr[k];
						drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no_arr[k],status);
					}*/
				}
			}
		}
		else if(site_type=="TOOTH" && tooth_no.indexOf(",") == -1 ||(site_type=="CROWN")||(site_type=="ROOT")){
			//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value
			var header_tab = document.forms[0].header_tab.value

			var tooth_sn = tooth_no;
			var super_yn = "";
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

            //SCR-6103
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
			
			if(status == 'E'){	
				if(condition_type == "MISSTH"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
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
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='34'/></div>"
                
				}
				else if(condition_type == "UNERTH" || condition_type=="IMPACTN"){ // 29FEB BSHANKAR
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

						var imageId = "R"+tooth_no;
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
							}else{
								var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}

						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>"
					}
				}
				else if(condition_type == "EXFOLTH"){
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value
					var query_tooth_no = tooth_no;
					if(mixed_dentition_YN == "N" && permanent_deciduous_flag == "D"){ // For Deciduous Chart
						disply_tooth_no = tooth_num;
					}
					else{
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
					}
					//if(RD_Normal_yn != "S" && RD_Normal_yn != "N" && RD_Normal_yn != ""){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";
							var imageId = "R"+tooth_no;
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
						
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"   
					//}
				
					var check_num_id = "check_num"+tooth_no;
					/*if(RD_Normal_yn == "NS"){ //Mark error of condition recorded on supernumerary tooth
					  dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "','S')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					else{
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}*/
				}
				else if(condition_type == "DECITH" || condition_type == "RTDESTH" || condition_type == "SUPRTH"){
					var numbering_system = document.forms[0].tooth_numbering_system.value;
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
						var imageId = "decith_table"+tooth_no;
						var tooth_sn = tooth_no;
						var tooth_num = retVal;
						var tooth_name = "";

						if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ //For Deciduous or MD-P Chart
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
						else if((permanent_deciduous_flag =="D" || permanent_deciduous_flag =="P" ) && mixed_dentition_YN=="Y" &&(mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							var check_num_id = "check_num"+tooth_no;						
						}
						else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanet Tooth no's in MD chart
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
							}else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
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
							}else{
								var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
							}
						}

					//added if ()  condition block for issue---Make any of extream 3 tooth as erupted, supernum than mark first erupted as error than suernum as error Before refresh root and crown is present,but after refresh its not coming.(previously else bolck was thr only )//parul on 6/29/2009

					if((permanent_deciduous_flag=="D" || permanent_deciduous_flag=="P") && mixed_dentition_YN=="Y"){
						var rd_flag = "";
						if(permanent_deciduous_flag=="D"){
							rd_flag = "MR";
						}
					
						if (tooth_no>=1 &&tooth_no<=3 ||tooth_no>=14 &&tooth_no<=19 ||tooth_no>=30 &&tooth_no<=32 ){
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + tooth_num +"</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
						else if((tooth_no>=4 && tooth_no<=13) || (tooth_no>=33 && tooth_no<=42)){
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}
					}else{
						if((tooth_no>=1 && tooth_no<=16) || (tooth_no>=33 && tooth_no<=42)){
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
						}else{
							dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
							}
										
						}
					}
				}
				else if(condition_type == "PARERTH"){
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "")){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
							
						}
						else{
							var imageId = "R"+tooth_no;
							if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For Deciduous or MD-P chart
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
								}else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
								var imageSrc = "../../eOH/images/spacer.gif";	
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
								}else{
									var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
								}
							}
						
							var root_layer = "rootLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}

							var imageId = "T"+tooth_no;
							if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								var imageSrc = "../../eOH/images/T.gif";	
							}

							var tooth_layer = "toothLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
							}
						}
					}
					else{
						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
					}
					
				}
				else if(condition_type == "ERUPTH"){
					if(tooth_no != '1' && tooth_no != '16' && tooth_no != '17' && tooth_no != '32'){
						if(mixed_dentition_YN == "Y" && (mapped_tooth_no == null || mapped_tooth_no == "null" || mapped_tooth_no == "" )){//This is to remove images for extream 3 tooth (in case of MD chart) when we record mark error on any of the treatments..
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						}
						else{
							var imageId = "R"+tooth_no;
							if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For Deciduous or MD-P chart
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
								}else{
									var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
								}
							}
							else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's in MD Chart
								var imageSrc = "../../eOH/images/spacer.gif";	
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
								}else{
									var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
								}
							}
						
							var root_layer = "rootLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(root_layer) == "null" || dentalchartFormObj.document.getElementById(root_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}

							var imageId = "T"+tooth_no;
							if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){
								var imageSrc = "../../eOH/images/spacer.gif";	
							}
							else{
								var imageSrc = "../../eOH/images/T.gif";	
							}

							var tooth_layer = "toothLayer"+tooth_no;
							if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='"+imageSrc+"' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>";
							}
						}
					}
					else{
						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='34'/>";

						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
					}
				}

				if( condition_type == "EXTRACT"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }/></div>";

					var imageId = "R"+tooth_no;
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
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
					//Added by Sharon Crasta on 2/23/2010 for SRR20056-CRF-0475 (IN010868)
					var pontic_tooth_split_values = new Array();
					var modalReturnedVal = "";
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
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
						}
					}
					pontic_tooth = retVal_bridge_extract.split(",") ;
					if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
						for(i = pontic_tooth.length-1;i >= 0;i--,j++){

							pontic_tooth_split_values[j] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;

						} 
					}else{
						for(i = 0; i < pontic_tooth.length;i++){
							pontic_tooth_split_values[i] = pontic_tooth[i].substring((pontic_tooth[i].lastIndexOf("$")+1),pontic_tooth[i].length) ;
						} 
					}
					if(retVal_bridge_extract.length > 0){
						var retVal_pontic = document.forms[0].pontic_tooth_values.value;
						var code_desc_arr = retVal_pontic.split("$$");
						var code_desc_arr_str = code_desc_arr.join("~~");
						if(code_desc_arr_str.length > 0){
						   for(var k=0;k<code_desc_arr.length;k++){
							   	if(treatments_outcome=="F"){
									var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							   }else{
							   	   var imageId = "T"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif' width='45' height='25'/>";
															
									var imageId = "R"+code_desc_arr[k];
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							   }
						   }
						}
					}//End	
				}
				else if(condition_type == "IMPLANT"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } /></div>";

					var imageId = "R"+tooth_no;
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
						}else{
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else{
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}

					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

				}else if(condition_type == "CROWN" && surface_code=="*A"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_sn+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } /></div>";
				
				}
				/*else if(condition_type == "TOOTHTM" && site_type == "TOOTH"){
					var imageId = "toothLayer"+tooth_no;
					fillCrownImages(imageId,"ALL",dentalchartFormObj,condition_type,status,tooth_no);
					var imageId = "rootLayer"+tooth_no;
					drawLineForRootImage(imageId,"ALL",dentalchartFormObj,condition_type,"ET",tooth_no,status);
				}*/
			}
			else{
				if(condition_type == "MISSTH"){
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img height= '25' src='../../eOH/images/MissingTeeth.gif'>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='3' height='34'/><img height= '25' src='../../eOH/images/MissingTeeth.gif'>";
				}
				else if(condition_type == "UNERTH"){ 
					//When recording REtained Deciduous in Permanent Chart, dont show Root and Crown images.
					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
				else if(condition_type=="IMPACTN"){ 
					if(!isPartiallyErupted){//Added by Sridevi Joshi on 12/17/2009 for IN017296 to show Crown image after recording imaction on PARERTH
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";

					}
				}
				else if(condition_type == "EXFOLTH"){
					var exfolth_count = 0;
					var super_recorded = "N";
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
						//xmlHttp.open("POST","CommonValidation.jsp?func_mode=countExfTooth&"+params,false);
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

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && mapped_tooth_no != null && mapped_tooth_no != "null" && super_yn != "Y" && RD_yn == "M" && exfolth_count == "1" && super_recorded == "N"){ // For Mixed Dentition - Deciduous Chart
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
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";

					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
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
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == "3"){ // For Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && exfolth_count == total_SuperKey_count){ // For Mixed Dentition - Permanent Chart
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
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}
					//else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && exfolth_count == "1" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
					else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "P" && super_yn != "Y" && RD_yn == "D" && super_recorded == "N"){ // Exfoliation on Deciduous Tooth Condition in Mixed Dentition - Permanent Chart
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
						dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }>" + disply_tooth_no + "</a><input type='hidden' name='selcol_hidden"+ tooth_sn +"' id='selcol_hidden"+ tooth_sn +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_sn +"' id='selcol"+ tooth_sn +"' value='' onClick = \"setCheckValue(this,'"+tooth_sn+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
					}


					var imageId = "T"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";

					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
				}
				else if(condition_type == "RTDESTH"){ //Not Applicable for Deciduous Chart
					var disply_tooth_no = "";
					var MDD_flag = "";
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;

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
							if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){
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
							}
							else{
								root_img_no = tooth_no;
								var rd_flag = 'NR';			//(11,51 case)
								var rd_normal_flag = "RD";
							
							}
							//Added by Sharon Crasta on 10/28/2009 for IN012514
							//Added to display only the tooth no and not to replace the crown and root on Retained Deciduous.
							var check_num_id = "check_num"+tooth_no;
							if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="P"){
								dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
							}
							else if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="D"){
								dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" >";
							}
							else{
								if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
								}
								else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/R" + root_img_no + ".gif' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','"+MDD_flag+"')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"' id="+tooth_no+"D id="+tooth_no+"RD id="+tooth_no+"S><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_flag+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','"+rd_normal_flag+"','RD')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='retained_font"+tooth_no+"'>" + tooth_num + "</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
								}
							}
						}
					}

					if(super_tooth_ref == "RD"){
						eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "gray";
						eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
					}
					else{
						if(mixed_dentition_YN == "Y" && permanent_deciduous_flag=="D"){
							if(eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "gray";
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "white";
							}
							else if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
							}
						}
						else{
							if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
								eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
							}

							else if(eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')") != null){
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.backgroundColor = "white";
								eval("dentalchartFormObj.document.getElementById('retained_font"+tooth_no+"')").style.color = "black";
							}
						}
					}
				}
				else if(condition_type == "SUPRTH"){
					var disply_tooth_no = "";
					var super_str = "";
					var super_main = "";
					var super_check = "";
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
					var super_tooth_ref = document.forms[0].super_tooth_ref.value; //Added by Sridevi Joshi on 12/9/2009 for SUPRTH new changes

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
					
					if(mixed_dentition_YN == "Y" && (tooth_no == "2" || tooth_no == "3" || tooth_no == "14" || tooth_no == "15" || tooth_no == "18" || tooth_no == "19" || tooth_no == "30" || tooth_no == "31")){//Added by Sridevi Joshi on 2/19/2010 for extreame tooth in Mixed Chart
						//This is to get display tooth no
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
					else if(permanent_deciduous_flag == "P" && mixed_dentition_YN == "Y" && RD_Normal_yn == "D"){
						//This is to get display tooth no
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
					else if(permanent_deciduous_flag == "D" && mixed_dentition_YN == "Y" && (RD_Normal_yn == "undefined" || RD_Normal_yn == undefined || RD_Normal_yn == "") &&( ref_tooth_no != "" && ref_tooth_no != "undefined" && ref_tooth_no != undefined)){
						if(tooth_no != "2" && tooth_no != "3" && tooth_no != "14" && tooth_no != "15" && tooth_no != "18" && tooth_no != "19" && tooth_no != "30" && tooth_no != "31"){ //Added by Sridevi Joshi on 2/17/2010 for IN019368 for tooth other than Extream tooth in MD-D case
							//This is to get display tooth no
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
						else{
							//This is to get display tooth no
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
					}else{
						//This is to get display tooth no
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


					if(permanent_deciduous_flag == "D" && (mixed_dentition_YN != "Y" || (mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null" || mixed_dent_tooth_no == ""))){ // For MD-P or Deciduous Chart
						if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
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
							var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
						}
					}
					else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ // For Permanent Tooth no's in MD-Chart
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					else{
						if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
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
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
					}

					var imageId = "decith_table"+tooth_no;
					var check_num_id = "check_num"+tooth_no;
					if(RD_Normal_yn == "MR"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','MR','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else if(RD_Normal_yn == "D"){
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','D','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}
					else{
						if(super_cnt == "2"){//To disply both Super tooth if SUPRTH is recorded twice
							super_main = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>";

							for(var z=0;z<retVal_SuperKey_arr.length-1;z++){
								if(z==0){
									super_str = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
								else{
									super_str = super_str+",<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+retVal_SuperKey_arr[z]+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[z]+"_super_font"+tooth_no+"'>"+retVal_SuperKey_arr[z]+"</font></a>";
								}
							}

							super_check = "<input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";

							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = super_main+","+super_str+super_check;
						}
						else{
							dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a>,<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='"+retVal_SuperKey_arr[0]+"_super_font"+tooth_no+"'>"+super_key_num+"</font></a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
						}
					}

					if(super_tooth_ref != "" && super_tooth_ref != "undefined" && super_tooth_ref != undefined){//Added by Sridevi Joshi on 1/22/2010 for IN010894
						eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.backgroundColor = "gray";
						eval("dentalchartFormObj.document.getElementById('"+super_tooth_ref+"_super_font"+tooth_no+"')").style.color = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "white";
						eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "black";
						
						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
								}
							}
						}
					}
					else{
						if(eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')") != null){
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.backgroundColor = "gray";
							eval("dentalchartFormObj.document.getElementById('normal_font"+tooth_no+"')").style.color = "white";
						}

						for(var y=0;y<retVal_SuperKey_arr.length-1;y++){//Added by Sridevi Joshi on 1/24/2010 for IN010894
							if(retVal_SuperKey_arr[y] != super_tooth_ref){
								if(eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')") != null){
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.backgroundColor = "white";
									eval("dentalchartFormObj.document.getElementById('"+retVal_SuperKey_arr[y]+"_super_font"+tooth_no+"')").style.color = "black";
								}
							}
						}
					}

					/*if(RD_Normal_yn == "undefined" || RD_Normal_yn == undefined){
						RD_Normal_yn = "";
					}

					dentalchartFormObj.document.getElementById(check_num_id).innerHTML = "<A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +disply_tooth_no+ "','"+RD_Normal_yn+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'><font id='normal_font"+tooth_no+"'>" + disply_tooth_no + "</font></a><A onclick=\"populateMenuOnSuper('"+tooth_no+ "','" +disply_tooth_no+ "','"+RD_Normal_yn+"','"+super_key_num+"')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>+</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+disply_tooth_no+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +disply_tooth_no+ "')\" onMouseOver = \"hideToolTip();\" >";
					*/
				}
				else if(condition_type == "DECITH"){ //Not Applicable for MD-D Chart
					var numbering_system = document.forms[0].tooth_numbering_system.value;
					var permanent_deciduous_flag = document.forms[0].permanent_deciduous_flag.value;
					var mixed_dentition_YN = document.forms[0].mixed_dentition_YN.value;
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
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

							var imageSrc = "../../eOH/images/R" + tooth_no + ".gif";
							if(tooth_no >= 1 && tooth_no <= 16 || (tooth_no>=33 && tooth_no<=42)){
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";								
							}
							else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML = "<table border='0' cellpadding='1' cellspacing='1' ><tr><td id='T"+tooth_no+"' align='center'><div id='toothLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='../../eOH/images/T.gif' alt='"+tooth_name+"' border='0' usemap= '#MapTUR1' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td id='R"+tooth_no+ "' align='center'><div id='rootLayer"+tooth_no+"' style='position:relative;cursor:pointer'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_no+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_no+ "#" +tooth_num+ "','D')\" /></div></td></tr><tr><td align='center' id='check_num"+tooth_no+"'><A onclick=\"onMouseClickFunctionNumber('"+tooth_no+ "#" +tooth_num+ "','D')\" onmouseover=\"this.style.color='blue'\" onmouseout = \"this.style.color=''\" style='cursor:pointer'>" + tooth_num + "</a><input type='hidden' name='selcol_hidden"+ tooth_no +"' id='selcol_hidden"+ tooth_no +"' value='"+tooth_num+"'><input type='checkbox' name='selcol"+ tooth_no +"' id='selcol"+ tooth_no +"' value='' onClick = \"setCheckValue(this,'"+tooth_no+ "#" +tooth_num+ "')\" onMouseOver = \"hideToolTip();\" ></td></tr><tr><td align='center' height='36' ><table border=0 cellpadding=0 cellspacing=0><tr><td id='"+tooth_no+"' width='45'></td></tr></table></td></tr></table>";
							}
						}
					}
				}
				else if(condition_type == "PARERTH"){
					var imageId = "R"+tooth_no;
					dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='41' height='34'/>";

					var tooth_layer = "toothLayer"+tooth_no;
					var imageId = "T"+tooth_no;
					if(dentalchartFormObj.document.getElementById(tooth_layer) == "null" || dentalchartFormObj.document.getElementById(tooth_layer) == null){
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
					}

					isPartiallyErupted = true;//Added by Sharon Crasta on 7/29/2009 for IN012514
				}
				else if(condition_type == "ERUPTH"){
					//var RD_Normal_yn = document.forms[0].RD_Normal_yn.value;
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
						//if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
						if(((mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R") && mixed_dentition_YN == "Y") || mixed_dentition_YN == "N"){
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
							if(permanent_deciduous_flag == "D" && mixed_dentition_YN =="Y"){//commented by parul changed for 16115 on 12/11/2009
								 var imageSrc = "../../eOH/images/R"+mapped_tooth_no+".gif";
							}
						}
					}
					else if(mixed_dentition_YN == "Y" && (mixed_dent_tooth_no != null && mixed_dent_tooth_no != "null" && mixed_dent_tooth_no != "")){ //For Permanent Tooth no's In MD Chart
						var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
					}
					else{
					
						if(mixed_dent_deciduous_yn == "M" || mixed_dent_deciduous_yn == "R"){
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
						else{
							var imageSrc = "../../eOH/images/R"+tooth_no+".gif";
						}
					}
					//Added by Sharon Crasta on 7/29/2009 for IN012514
					//On Eruption only the root should be erupted in case of already Partially Erupted and root and crown should appear in case of unerupted condition.

					if(mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D") {
						if(mixed_dent_tooth_no == "" || mixed_dent_tooth_no == null || mixed_dent_tooth_no == "null"){
							if(isPartiallyErupted && count_exf == 1){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							}
							else if(isPartiallyErupted && count_exf == 2){//Added by Sharon Crasta on 11/4/2009 for IN015475 --//In case of Supernumerary -> Exfoliate both -> PArtially Erupt-> Caries -> ERupt
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>";
							  }
							  else if(count_exf == 2 && mixed_dentition_YN == "Y" && permanent_deciduous_flag == "D"){//Added by Sridevi Joshi on 02/11/09 for IN015475
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							  }
							  else if (count_exf == 1){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							  }
							  else if(isPartiallyErupted){ //Added by Sridevi Joshi on 1/11/2010 for IN010894 Retained-->Erupth on Permanent tooth
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							  }
						}else{
							if(isPartiallyErupted){
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							}
							else{
								var root_layer = "rootLayer"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						}
					}
					else{  
						if(isPartiallyErupted && count_exf!=0){		
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							if (RD_Normal_yn=="N"){//condition added by parul on 19/11/2009 for IN016389
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "','NR')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						} 
						else if(count_partially_erupted == 1){
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "','NR')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"
							if (count_impant>0){ //added by parul on 08/01/2010 for super changes(Retained-> partially->implant trmt on permanent tooth->Erupted condition after eruption implant image was coming in place of crown)

								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
							}
						} 
						else{
							var root_layer = "rootLayer"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='rootLayer"+tooth_no+"' style='position:relative;'><img src='"+imageSrc+"' alt='" + tooth_name + "' border='0' usemap='#MapRUR" + tooth_no + "' onMouseOver=\"onMouseOverFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionRoot()\" onclick=\"onMouseClickFunctionRoot('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' }  width='41' height='34'/></div>"

							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<div id='toothLayer"+tooth_no+"' style='position:relative;'><img src='../../eOH/images/T.gif' alt='" + tooth_name + "' border='0' usemap='#MapTUR1" + tooth_no + "' onMouseOver=\"onMouseOverFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" onmouseout=\"onMouseOutFunctionCrown()\" onclick=\"onMouseClickFunctionCrown('"+tooth_sn+ "#" +tooth_num+ "')\" if(!called_from_viewchart_yn.equals('Y')){ style='cursor:pointer' } width='41' height='25'/></div>"
						}
					}
					isErupted = true;
				}
				else if(condition_type == "EXTRACT"){
					if (treatment_int_ext!="E"){
						status_int = parseInt(status);
						if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownYellow.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootYellow.gif'>";
						}
						else if(status_int == 60){
							if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='40' height='25'  src='../../eOH/images/Extraction-CrownGreen_F.gif'>";                          
								
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_F.gif'>";

							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen.gif'>";
							
							}
						}
					}else{			
						if (treatment_int_ext=="E"){
							if (treatments_outcome=="F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_EF.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_EF.gif'>";
							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-CrownGreen_E.gif'>";

								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Extraction-RootGreen_E.gif'>";
							}
						}
					}
				}
				else if(condition_type == "IMPLANT"){ //Applicable only for Permanent Chart
					if (treatment_int_ext!="E"){
						//commented by patul on 17/05/2010 for 21386
						//var imageId = "T"+tooth_no;
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
						
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_F.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_F.gif' width='45' height=34'/>";

						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src=' "+image_source+" '>";
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root.gif' width='45' height=34'/>";						
						}
					}else  if (treatment_int_ext=="E"){
                         if (treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_EF.gif'>";
						  
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_EF.gif'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_E.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Implant_root_E.gif'>";
						}
					}
				}
				else if(condition_type == "DENTURE"){/* starts(marking error on any condition after denture/bridge on same tooth ) by parul */
					if (treatment_int_ext!="E"){
						var imageId = "T"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
							var imageId = "R"+tooth_no;
							if(treatments_outcome=="F"){
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_F.gif'>";
							}else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root.gif'>";
							}
					}else if (treatment_int_ext=="E"){
                         if (treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_EF.gif'>";
							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_EF.gif'>";

						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_E.gif'>";

							var imageId = "R"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Denture_root_E.gif'>";
						}
					}
				}
			/*	else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					if(treatments_outcome=="F"){
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif' width='45' height='25'/>";
					
						//var imageId = "R"+tooth_no_arr[k];
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}else{
						var imageId = "T"+tooth_no;
						//Commented and Added by Sharon Crasta on 2/8/2010 for SRR20056-CRF-0475(IN010868)
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height='25'/>";
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
					
						//var imageId = "R"+tooth_no_arr[k];
						//dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Bridge.gif' width='45' height=34'/>";

						var imageId = "R"+tooth_no;
						dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img width='45' height='25' src='../../eOH/images/spacer.gif' width='45' height=34'/>";
					}
				} 
				else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
					  if (treatment_int_ext=="I"){
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif' width='45' height='25'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
						}
					  }else if (treatment_int_ext=="E"){
							if (treatments_outcome == "F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif' width='45' height='25'/>";
						}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif' width='45' height='25'/>";
						}
					  }
				}*///End
				else if(condition_type == "BRIDGE" && hide_image_yn == "Y"){
					
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
									if(treatments_outcome=="F"){
										var imageId = "T"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
															
										var imageId = "R"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
										break;
									}else{
										var imageId = "T"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height='25'/>";
															
										var imageId = "R"+code_desc_arr[k];
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
										break;
									}
								}else{
									 if(treatment_int_ext == "E"){
											if (treatments_outcome == "F"){
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}else{
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'>";
											
											}
									   }else if(treatment_int_ext == "I"){
											if (treatments_outcome == "F"){
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}else{
												var imageId = "T"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif'/>";
										
												var imageId = "R"+tooth_no;
												dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
											}
									   }
								 }
						   }
						}
						else{
							if(treatment_int_ext == "E"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
							
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
							
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}
							}else if(treatment_int_ext == "I"){
								if (treatments_outcome == "F"){
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
							
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}else{
									var imageId = "T"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
							
									var imageId = "R"+tooth_no;
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
								}
							}
						} 
					}else{
						 if(treatment_int_ext == "E"){
							if (treatments_outcome == "F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_EF.gif'/>";
					
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_E.gif'/>";
					
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
						 }else if(treatment_int_ext == "I"){
							if (treatments_outcome == "F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic_F.gif'/>";
					
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Pontic.gif' width='45' height='25'/>";
					
								var imageId = "R"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/spacer.gif' width='45' height=34'/>";
							}
						 }
					}
				}
				else if(condition_type == "BRIDGE" && hide_image_yn == "N"){
					if (treatment_int_ext=="I"){
						if(treatments_outcome=="F"){
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_F.gif'/>";
						}else{
							var imageId = "T"+tooth_no;
							dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment.gif'/>";
						}
					  }else if (treatment_int_ext=="E"){
							if (treatments_outcome == "F"){
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_EF.gif'/>";
						}else{
								var imageId = "T"+tooth_no;
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/Abutment_E.gif'/>";
						}
					  }
				} //End
				else if (surface_code=="*A" && (site_type=="CROWN" || site_type=="TOOTH")){//Added by parul on 21/01/2010 for CRF-422
					var imageId = "T"+tooth_no;
					if(permanent_deciduous_flag=="P"){
                         if (treatment_int_ext=="I"){
							if (tooth_no>=1 && tooth_no<=16){
								if(treatments_outcome=="F"){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif'>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif'>";
								}
							}else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img  src=' "+image_source+" '>";
							}
						 }else  if (treatment_int_ext=="E"){
								if (tooth_no>=1 && tooth_no<=16){
									if(treatments_outcome=="F"){
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif'>";
									}else{
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif' >";
									}
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
								}
						 }
					}else{
						  if (treatment_int_ext=="I"){
								if (tooth_no>=33 && tooth_no<=42){
									if(treatments_outcome=="F"){
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_F.gif'>";
									}else{
										dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown.gif'>";
									}
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
								}
						  }else  if (treatment_int_ext=="E"){
							  if (tooth_no>=33 && tooth_no<=42){
								if(treatments_outcome=="F"){
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_EF.gif'>";
								}else{
									dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src='../../eOH/images/CrownDown_E.gif'>";
								}
							}else{
								dentalchartFormObj.document.getElementById(imageId).innerHTML ="<img src=' "+image_source+" '>";
							}
						  }
					}
				}
			}
		}
	}
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function updateTreatmentStatus(site_type,tooth_range_nos,pat_id,chart_num,chart_line_num,order_status_type,chart_line_num_int,order_id,trmt_code,task_code,reasonforcancel,encounter_id,trmt_code1,order_line_num,task_order_catalog_code,seq_no,bl_episode_id,bl_encounter_id,bl_visit_id,bl_episode_type,patient_class,surgeon_code,task_desc,bl_key,bl_key_line_no,bl_panel_str,bl_service_date,billing_appl_yn,start_date_time,end_date_time,order_catalog_bill_yn,ext_perm_loc_param,trmt_yn,trmt_done_yn,reg_date_time,performed_In_OT){
	
		var order_status_type_int = parseInt(order_status_type);
		if(ext_perm_loc_param == "Y" || (order_status_type_int>25 && trmt_yn !="Y" && trmt_done_yn != "Y")){//Added by Sridevi Joshi for CRF-702(IN012606)
			var messageFrame = parent.parent.parent.parent.parent.messageFrame;
		}
		else{
			var messageFrame = parent.parent.parent.parent.messageFrame;
		}

		if(site_type == "THRNG" ||(site_type == "MAXFS"  && tooth_range_nos.indexOf(",") != -1)){
			var tooth_rang_arr = tooth_range_nos.split(",");
			for(var i=0;i<tooth_rang_arr.length;i++){
				chart_line_num = chart_line_num_int+"";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
		
				var params = "patient_id="+pat_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_status_type="+order_status_type+"&order_id="+order_id+"&trmt_code="+trmt_code+"&task_code="+task_code+"&reasonforcancel="+reasonforcancel+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&order_line_num="+order_line_num+"&start_date_time="+start_date_time+"&end_date_time="+end_date_time+"&order_catalog_bill_yn="+order_catalog_bill_yn+"&OH_billing_appl_yn="+billing_appl_yn+"&task_seq_no="+seq_no+"&reg_date_time="+reg_date_time+"&performed_In_OT="+performed_In_OT;
			
				var bl_params = "&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn+"&task_order_catalog_code="+task_order_catalog_code;

				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST","../../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateTrmtTaskStatus&"+params,false);
				xmlHttp.send(xmlDoc);
				var trmt_task_status = trimString(xmlHttp.responseText);
				trmt_task_status = localTrimString(trmt_task_status);
				chart_line_num_int ++;
			}
			var status_arr = trmt_task_status.split("##");
			var status = status_arr[0];
			var status_task = status_arr[1];
			var frame_msg = status_arr[2];

			var msg = getMessage("RECORD_INSERTED", "SM");
			
			if(frame_msg == "GET_MSG"){
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			}

			var formObj=document.forms[0];
			formObj.treatment_status_param.value = status_task;

			var result_complete = "N";
			if(status_task == "85" || status_task == "60" || status_task == "75" || status_task == "90"){
				result_complete = "Y";
			}
	
			if(document.getElementById("confirm_complete_charges")!=null){
				if(result_complete == "Y"){
					document.getElementById("confirm_complete_charges").disabled = false;
					document.getElementById("record_button").disabled = true;
				}
				else{
					document.getElementById("confirm_complete_charges").disabled = true;
				}
			}			
		}
		else{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+pat_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&order_status_type="+order_status_type+"&order_id="+order_id+"&trmt_code="+trmt_code+"&task_code="+task_code+"&reasonforcancel="+reasonforcancel+"&encounter_id="+encounter_id+"&trmt_code="+trmt_code+"&order_line_num="+order_line_num+"&start_date_time="+start_date_time+"&end_date_time="+end_date_time+"&order_catalog_bill_yn="+order_catalog_bill_yn+"&OH_billing_appl_yn="+billing_appl_yn+"&task_seq_no="+seq_no+"&reg_date_time="+reg_date_time+"&performed_In_OT="+performed_In_OT;

			var bl_params = "&bl_episode_id="+bl_episode_id+"&bl_encounter_id="+bl_encounter_id+"&bl_visit_id="+bl_visit_id+"&bl_episode_type="+bl_episode_type+"&patient_class="+patient_class+"&surgeon_code="+surgeon_code+"&task_desc="+task_desc+"&bl_key="+bl_key+"&bl_key_line_no="+bl_key_line_no+"&bl_panel_str="+bl_panel_str+"&bl_service_date="+bl_service_date+"&billing_appl_yn="+billing_appl_yn+"&task_order_catalog_code="+task_order_catalog_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eOH/jsp/DentalTrmtCommonValidation.jsp?func_mode=updateTrmtTaskStatus&"+params,false);
			xmlHttp.send(xmlDoc);
			var trmt_task_status = trimString(xmlHttp.responseText);
			trmt_task_status = localTrimString(trmt_task_status);

			var status_arr = trmt_task_status.split("##");
			var status = status_arr[0];
			var status_task = status_arr[1];
			var frame_msg = status_arr[2];
			var msg = getMessage("RECORD_INSERTED", "SM");
			
			if(frame_msg == "GET_MSG"){
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			}

			var formObj=document.forms[0];
			formObj.treatment_status_param.value = status_task;

			var result_complete = "N";
			if(status_task == "85" || status_task == "60" || status_task == "75" || status_task == "90"){
				result_complete = "Y";
			}
			if(document.getElementById("confirm_complete_charges")!=null){
				if(result_complete == "Y"){
					document.getElementById("confirm_complete_charges").disabled = false;
					document.getElementById("record_button").disabled = true;
				}
				else{
					document.getElementById("confirm_complete_charges").disabled = true;
				}

				
			}			
		}
		return status;
}

async function resultViewOrder(colval1,colval,orderId,order_line_num,cont_order_ind,patient_id, ord_cat){
		var dialogHeight ='40vh' ;
		var dialogWidth = '65vw' ;
		var dialogTop	= '129';
		var dialogLeft = '11' ;
 
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +colval+"&orderId="+ orderId+"&order_line_num="+ order_line_num+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id+"&ord_cat="+ord_cat;
		var retVals =await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

