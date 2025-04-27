var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var printRelatedInfo="";
var finalResponse ="";
var printFlag=false;
var deleteFlag=false;
var order_ids="";
var invalidCode="";
var global_dummy_token_no="";
var innerTextvalue="";
var	patient_id="";
var	patientName="";
var	patientGender="";
var	patientNationality="";
var	patientNationalityDesc="";
var	patientsex="";
var global_success_msg="";
var global_token_no="";

function query(){
	f_query_add_mod.location.href="../../ePH/jsp/RegPrescriptionsFrames.jsp";	
}

function reset(obj,pending_order_count, disp_locn_code,pat_arr_checked_yn,patmode) { // pat_arr_checked_yn added for TTM-SCF-169
	if (obj=="No records"){
		//Added for Bru-HIMS-CRF-142 [IN:030195] - Start
		var chk;
		var flag;
		 if((patmode!=undefined || disp_locn_code!=undefined) && pat_arr_checked_yn!=undefined && pat_arr_checked_yn=="Y"){ // if else condition added for ttm-scf-169
			if(patmode!=undefined){
				var disp_locn_code=disp_locn_code;
				if(patmode=="[P]"){
					chk=confirm(getMessage("PH_REG_PAT_ARRV","PH"));
					flag="2";
				}
				if(patmode=="[U]"){ 
					chk=confirm(getMessage("PH_REG_UNCOLLECT","PH"));
					flag="3";
				}
			}
			else if(disp_locn_code!=undefined){
				if((disp_locn_code!="[P]")&&(disp_locn_code!="[U]")){
					chk=confirm(getMessage("PH_REG_UNCOLL_PROCESS","PH"));
					flag="1";
				}
			}
		  }
		 else if((patmode!=undefined || disp_locn_code!=undefined) && pat_arr_checked_yn!=undefined && pat_arr_checked_yn=="N"){ // if else condition added for ttm-scf-169
			 var msg=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;	 
		 }
		
		if((disp_locn_code==undefined)&&(patmode==undefined)){
			var msg=getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
			if(parseInt(pending_order_count)>0){
				//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")+" ,  " +getLabel( "ePH.NO_PENDING_ORDERS","PH"));
				msg = msg+" ,  " +getLabel( "ePH.NO_PENDING_ORDERS","PH");
			}
			//else{
				//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			//}
			parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;	
			var autoCallReRoute_yn = parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.autoCallReRoute_yn.value; //Added for IN045320 -Start
			if(autoCallReRoute_yn!='Y') //if condition //Added for IN045320
				parent.parent.parent.f_query_add_mod.location.href="../../ePH/jsp/RegPrescriptionsFrames.jsp";
		}
		if(chk){
			callWindow(flag);
		}
		if(chk=="false"){
			parent.parent.document.reg_prescriptions_header.location.href="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp";
		}//Added for Bru-HIMS-CRF-142 [IN:030195] - End
		/*	//Commented for Bru-HIMS-CRF-142 [IN:030195]
		parent.parent.document.frames.reg_prescriptions_header.location.href="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp";
		if(parseInt(pending_order_count)>0){
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")+" ,  " +getLabel( "ePH.NO_PENDING_ORDERS","PH"));
		}
		else{
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		}*/
		var formObj = parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
		var homepage = formObj.homepage.value;
		patient_id=formObj.patient_id.value;
		disp_locn_code=formObj.disp_locn_code.value;
		if(parseInt(pending_order_count)>0 && patient_id!=null && disp_locn_code!=null){
			 parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.document.getElementById("pending_orders").style.visibility='visible';
		     parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.document.getElementById("pending_orders").click();
		}
		var autoCallReRoute_yn = formObj.autoCallReRoute_yn.value; //Added for IN045320 -Start
		var callFrom =	formObj.callFrom.value;//added for [IN:045320]
		if(autoCallReRoute_yn =='Y' && patient_id!="" && callFrom==""){
			formObj.disp_locn_code.disabled = false;
			formObj.callFrom.value='ReRoute';
			parent.parent.reg_prescriptions_query.document.getElementById("reRoutePrescription").click();
			return;
		}
		else{ //Added for IN045320 - End
			formObj.disp_locn_code.disabled = false;
			formObj.patient_id.disabled = false;
			formObj.btnPatientID.disabled = false;
			formObj.order_id.disabled = false;
			formObj.priority.disabled = false;
			formObj.order_status.disabled = false;
			formObj.order_date_from.disabled = false;
			formObj.order_date_to.disabled = false;
			formObj.ord_locn_desc.disabled = false;
			formObj.btnordLocn.disabled = false;
			formObj.ord_loc_type.disabled = false;
			formObj.CalFromDate.disabled = false;
			formObj.CalToDate.disabled = false;
			formObj.callFrom.value = "";
		}
		if(homepage =='Y')
			formObj.disp_locn_code.disabled = true;
	}
	else{//For resetting the query page...
		if(f_query_add_mod.reg_prescriptions_query!=null){
			var formObj = f_query_add_mod.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
			var homepage = formObj.homepage.value;
			formObj.disp_locn_code.disabled = false;
			formObj.patient_id.disabled = false;
			formObj.btnPatientID.disabled = false;
			formObj.order_id.disabled = false;
			formObj.priority.disabled = false;
			formObj.order_status.disabled = false;
			formObj.order_date_from.disabled = false;
			formObj.order_date_to.disabled = false;
			formObj.ord_locn_desc.disabled = false;
	        formObj.btnordLocn.disabled = false;
	        formObj.ord_loc_type.disabled = false;
			formObj.CalFromDate.disabled =	false;
			formObj.CalToDate.disabled	= false;
			formObj.reset();
			var formObj = f_query_add_mod.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
			formObj.querySelector('#no_of_patients').innerHTML = "";
			f_query_add_mod.reg_prescriptions_header.location.href="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp";
			formObj.callFrom.value="";
		}
		if(homepage =='Y')
			formObj.disp_locn_code.disabled = true;
	}
}

// This will call common patient search
async function callPatientSearch(){
	var formObj=document.RegPrescriptionsQueryCriteria;
	var patient_id = document.RegPrescriptionsQueryCriteria.patient_id.value
	if(patient_id == "")
		patient_id =await PatientSearch();
	//var patient_id = PatientSearch();
	if (patient_id!= "" && patient_id != undefined){
		formObj.patient_id.value = patient_id;
		//formObj.patient_id.disabled = true;
		//formObj.btnPatientID.disabled = true;

		var bean_id	= formObj.bean_id.value ;
		var bean_name = formObj.bean_name.value ;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH ";
		xmlStr +=" /></root>";
		//xmlDoc.loadXML( xmlStr);
		//xmlHttp.send(xmlDom);
		xmlHttp.open("POST","RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=nationalityHealthCardNo&patient_id="+patient_id, false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}

// This is to assign nationality and Health CardNo based on patient id
function assignNationalityHealthCardNo(nationality,healthCardNo){
	var formObj = document.RegPrescriptionsQueryCriteria;
	if(nationality==null || nationality == "null") {
		nationality="";
		}
	if(healthCardNo==null || healthCardNo == "null") {
		healthCardNo=""
	}
	formObj.national_id_no.value=nationality;
	formObj.health_card_num.value=healthCardNo;
}

// loading patient id locator jsp
function searchTheDataForHeaderAndFooter(){
	var formobj = document.RegPrescriptionsQueryCriteria;//added for ML-BRU-SCF-1447[IN052188]
	if(formobj.order_date_from.value==''||formobj.order_date_to.value==''){
		var msg = getMessage("PH_PRD_DATE_FM_TO_NOT_BLANK","PH");
		if(formobj.order_status.value=='R')	
			msg = msg.replace("$","Refill Start Date");
		else if(formobj.order_status.value=='B')
			msg = msg.replace("$",getLabel("ePH.CollectionDate.label","PH"));
		else
			msg = msg.replace("$",getLabel("Common.Period.label","Common"));
		alert(msg);
		return false;
	}//added for ML-BRU-SCF-1447[IN052188] ends
	
	if(parent.document.reg_prescriptions_header != undefined){ // if condition added for Bru-HIMS-CRF-073.1 [IN:047222]
		parent.document.reg_prescriptions_header.reg_prescriptions_header_patient_line.location.href="../../eCommon/html/blank.html";//added for ML-BRU-SCF-0169 [IN:032571] - Start
		parent.document.reg_prescriptions_header.reg_prescriptions_header_details.location.href="../../eCommon/html/blank.html"; 
		if(parent.document.reg_prescriptions_header.reg_prescriptions_footer_details.reg_prescriptions_footer_details1 != undefined){
			parent.document.reg_prescriptions_header.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../eCommon/html/blank.html";
			parent.document.reg_prescriptions_header.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../eCommon/html/blank.html";//added for ML-BRU-SCF-0169 [IN:032571] - End
		}
	}
	disableTheQueryCriteria();
	parent.document.reg_prescriptions_header.reg_prescriptions_header_patient_id_locator.location.href="../../ePH/jsp/RegPrescriptionsPatientIDLocator.jsp";
}

function disableTheQueryCriteria(){
	var formObj = document.RegPrescriptionsQueryCriteria;
	var homepage = formObj.homepage.value;
	if(formObj.autoCallReRoute_yn!='Y'){ //If condition added for IN045320
		formObj.disp_locn_code.disabled = true;
		formObj.patient_id.disabled = true;
		formObj.btnPatientID.disabled = true;
		formObj.order_id.disabled = true;
		formObj.priority.disabled = true;
		formObj.order_status.disabled = true;
		formObj.order_date_from.disabled = true;
		formObj.order_date_to.disabled = true;
		formObj.ord_locn_desc.disabled = true;
		formObj.btnordLocn.disabled = true;
		formObj.ord_loc_type.disabled = true;
		formObj.CalFromDate.disabled	    =	true;
		formObj.CalToDate.disabled	    =	true;
	}
}

// loading the patient id's
function loadPatientIdFrame(){
	parent.document.reg_prescriptions_header_patient_id.location.href="../../ePH/jsp/RegPrescriptionsPatientHeader.jsp";
}
//loading order details related to the patient
function loadOrderDetailsForThePatient(){
	parent.document.reg_prescriptions_header_details.location.href="../../ePH/jsp/RegPrescriptionsDetailsHeader.jsp?called_from=REGISTRATION";
}
//loading the status frame
function loadStatusDisplayFrame(){
	parent.document.reg_prescriptions_status.location.href="../../ePH/jsp/RegPrescriptionsStatus.jsp";
}

//After Loading the status frame the following function 'loadPatientRelatedInfo()' will be called.
function loadPatientRelatedInfo(){
	var formObj = parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var patient_id		= formObj.patient_id.value;
	var order_id		= formObj.order_id.value;
	var priority		= formObj.priority.value;
	var order_status	= formObj.order_status.value;
	//var order_date_from = formObj.order_date_from.value;convertDate(formObj.order_date_from.value,"DMY",Language_id,"en")
	var Language_id		= formObj.Language_id.value;
	var order_date_from = convertDate(formObj.order_date_from.value,"DMY",Language_id,"en");
	var order_date_to	= convertDate(formObj.order_date_to.value,"DMY",Language_id,"en");
	var disp_locn_code	= formObj.disp_locn_code.value;

	var ord_loc_type	= formObj.ord_loc_type.value;
	var ord_locn_code	= formObj.ord_locn_code.value;

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=patientDetails"+"&patient_id="+patient_id+"&order_id="+order_id+"&priority="+priority+"&order_status="+order_status+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&disp_locn_code="+disp_locn_code+"&ord_loc_type="+ord_loc_type+"&ord_locn_code="+ord_locn_code, false ) ;
	xmlHttp.send( xmlDoc ) ;
	respTst = xmlHttp.responseText;
	eval(respTst);
}

/* 
 This function is used to display the patient IDs
	obj1  -- PATIENT_ID
	obj2  -- PATIENT_NAME
	obj3  -- AGE
	obj4  -- SEX
	obj5  -- NATIONALITY_DESC
	obj6  -- TOTAL_PRES
	obj7  -- PATIENT_CLASS
	obj8  -- COUNTRY_CODE
*/
function assignDataToPatientFrame(obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,lock_status_return,disp_locn_code,user_id,locked_date_time,Unlock_all_records_yn,allow_disp_record_lock_yn,encounter_id){ //encounter_id added for SKR-SCF-1273.1

	
	 if(obj2!="")
		obj2=decodeURIComponent(obj2,"UTF-8").replace(/\+/g," ");
	var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	var formObjLocator = parent.document.reg_prescriptions_header_patient_id_locator.RegPrescriptionsPatientIDLocator;
	var formObjOrders  = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	var formObjStatus = parent.document.reg_prescriptions_status.RegPrescriptionsStatus;
	/*	The following statements helps to  show the tables if the patients are there for the 
		selected query criteria...	*/
	formObj.querySelector('#regprescriptionspatientheadertable').style.visibility="visible";
	formObjLocator.querySelector('#regprescriptionspatientidlocatorID').style.visibility="visible";
	formObjOrders.querySelector('#regprescriptionsdetailstable').style.visibility="visible";
	formObjStatus.querySelector('#regprescriptionsstatustable').style.visibility="visible";

	var queryFormObj=parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
	var row_no = formObj.querySelector('#regprescriptionspatientheadertable').rows.length-1;
	if(row_no % 2 == 0 )
		classval	=	"QRYEVEN";
	else
		classval	=	"QRYODD";

	curr_row	=	formObj.querySelector('#regprescriptionspatientheadertable').insertRow();
	var classval;

	cell	=	curr_row.insertCell();
	curr_row.cells[0].className	= classval;
	if (row_no==0){
		curr_row.cells[0].style.backgroundColor	= "#ffffcc";
	}

   	if(lock_status_return=='0'||lock_status_return==''){
		var Logout="";
		//encounter_id added for SKR-SCF-1273.1
		curr_row.cells[0].innerHTML = "<font   onmouseover=\"displayToolTip('"+escape(obj1)+"','"+escape(obj2)+"','"+escape(obj3)+"','"+escape(obj4)+"','"+escape(obj5)+"','"+lock_status_return+"')\" onmouseout='hideToolTip()' style='cursor:pointer;color:blue;font-size:9px' onClick=\"if(CheckLockStatus('"+obj1+"','"+disp_locn_code+"','"+row_no+"',this.innerText,'"+escape(obj2)+"','"+obj4+"','"+obj8+"','"+obj5+"','"+obj9+"','"+allow_disp_record_lock_yn+"','"+encounter_id+"')){getOrdersForSelectedPatient(this.innerText,'"+encounter_id+"');assignValuesForTokenSeries('"+obj1+"','"+escape(obj2)+"','"+obj4+"','"+obj8+"','"+obj5+"','"+obj9+"');}\">"+obj1+"</font>"+"<font style='font-size:9px'>&nbsp;&nbsp;("+obj6+")</font>"+"<input type='hidden' value='"+obj1+"' name='patient_id"+row_no+"' id='patient_id"+row_no+"'>"+"<input type='hidden' value=\""+(obj2)+"\" name='patient_name"+row_no+"' id='patient_name"+row_no+"'>"+"<input type='hidden' value=\""+obj3+"\">"+"<input type='hidden' value="+obj4+" name='gender"+row_no+"' id='gender"+row_no+"'>"+"<input type='hidden' value="+obj5+" name='nationality_desc"+row_no+"' id='nationality_desc"+row_no+"'>"+"<input type='hidden' value="+obj8+" name='nationality"+row_no+"' id='nationality"+row_no+"'><br>&nbsp;<font style='font-size:9px'> "+(obj2)+"</font>"+"<input type='hidden' value="+obj9+" name='sex_val"+row_no+"' id='sex_val"+row_no+"'>"+"<input type='hidden' value="+lock_status_return+" id='Logout"+row_no+"'><br>&nbsp;<font style='font-size:9px';display = 'inline'>"+(Logout)+"</font>";
		// Assigning the patient details to the hidden variables as to show these details in the token series
		// window if patient itself is collecting the medication...
		// Onload...first patient info will be saved

		/*formObj.patientID.value				=	formObj.patient_id0.value;
		formObj.patientName.value			=	formObj.patient_name0.value;
		formObj.patientGender.value			=	formObj.gender0.value;
		formObj.patientNationality.value	=	formObj.nationality0.value;
		formObj.patientNationalityDesc.value=	formObj.nationality_desc0.value;
		formObj.patientSex.value			=	formObj.sex_val0.value;	  
		formObj.Logout.value			    =	formObj.Logout0.value;	*/  
   }
   if(lock_status_return=='1'){
	  // if(allow_disp_record_lock_yn=='Y'){
	   var Logout="<img src='../../ePH/images/Locked.gif'onmouseover=displayToolTipLOckDetails(this,'"+user_id+"','"+escape(locked_date_time)+"');onmouseout='hideToolTip()' onClick=UnLockRecord('"+obj1+"','"+disp_locn_code+"','"+Unlock_all_records_yn+"','"+row_no+"'); id='lock_icon_"+row_no+"' style='cursor:pointer;color:blue;font-size:9px'>";
	  // }else if(allow_disp_record_lock_yn=='N'){
	   // Logout="";
	   //}
	   //encounter_id added for SKR-SCF-1273.1
	   curr_row.cells[0].innerHTML = "<font   onmouseover=\"displayToolTip('"+escape(obj1)+"','"+escape(obj2)+"','"+escape(obj3)+"','"+escape(obj4)+"','"+escape(obj5)+"','"+lock_status_return+"')\" onmouseout='hideToolTip()' style='cursor:pointer;color:blue;font-size:9px' onClick=\"if(CheckLockStatus('"+obj1+"','"+disp_locn_code+"','"+row_no+"',this.innerText,'"+escape(obj2)+"','"+obj4+"','"+obj8+"','"+obj5+"','"+obj9+"','"+allow_disp_record_lock_yn+"','"+encounter_id+"')){getOrdersForSelectedPatient(this.innerText,'"+encounter_id+"');assignValuesForTokenSeries('"+obj1+"','"+escape(obj2)+"','"+obj4+"','"+obj8+"','"+obj5+"','"+obj9+"');}\">"+obj1+"</font>"+"<font style='font-size:9px'>&nbsp;&nbsp;("+obj6+")</font>"+"<input type='hidden' value='"+obj1+"' name='patient_id"+row_no+"' id='patient_id"+row_no+"'>"+"<input type='hidden' value=\""+(obj2)+"\" name='patient_name"+row_no+"' id='patient_name"+row_no+"'>"+"<input type='hidden' value=\""+obj3+"\">"+"<input type='hidden' value="+obj4+" name='gender"+row_no+"' id='gender"+row_no+"'>"+"<input type='hidden' value="+obj5+" name='nationality_desc"+row_no+"' id='nationality_desc"+row_no+"'>"+"<input type='hidden' value="+obj8+" name='nationality"+row_no+"' id='nationality"+row_no+"'><br>&nbsp;<font style='font-size:9px'> "+(obj2)+"</font>"+"<input type='hidden' value="+obj9+" name='sex_val"+row_no+"' id='sex_val"+row_no+"'>"+"<input type='hidden' value="+lock_status_return+" id='Logout"+row_no+"'><br>&nbsp;<font style='font-size:9px'; display = 'inline'>"+(Logout)+"</font>";

	// Assigning the patient details to the hidden variables as to show these details in the token series
	// window if patient itself is collecting the medication...
	// Onload...first patient info will be saved
		/*formObj.patientID.value				=	obj1;
		formObj.patientName.value			=	obj2;
		formObj.patientGender.value			=	obj4;
		formObj.patientNationality.value	=	obj8;
		formObj.patientNationalityDesc.value=	obj5;
		formObj.patientSex.value			=	obj9;
		formObj.Logout.value			    =	lock_status_return;	*/
	}
}
  
//access unlocking record throw this function.

function UnLockRecord(obj1,disp_locn_code,Unlock_all_records_yn,row_no){
	row_no1=row_no
	if(Unlock_all_records_yn=='Y'){
		var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=checkunlockrecord&patient_id="+obj1+"&disp_locn_code="+disp_locn_code, false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
} 

//remove ICON throw this function
function Unlock_status_YN(Unlock_status_value_yn){
	if(Unlock_status_value_yn=='N'){
	  //alert("row_no1---->"+row_no1);
	  var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	  eval("formObj.lock_icon_"+row_no1).style.display='none';
	  //formObj.Logout.style.display='none';
	  //var l1= "display:'none'";
	  // var Logout="<img src='../../eCommon/images/Logout.gif'style='cursor:pointer;color:blue;font-size:9'"+l1+">";
	  // eval("formObj.Logout"+row_no1).style.display='none';
	  //formObj.rows(row_no).cells(0).Logout.style.display='none';
	  // alert( formObj.regprescriptionspatientheadertable.rows(row_no).cells(0).Logout.value)
      // eval("parent.document.frames.reg_prescriptions_header_patient_id.Logout"+row_no1).style.visibility = "hidden";

	 }
}
//Display ToolTip purpose only useing this method

function displayToolTipLOckDetails(obj,user_id,locked_date_time){
	obj.title=getLabel("Common.username.label",'Common')+" : "+user_id +"\n"+getLabel("Common.Date/Time.label",'Common')+" : "+decodeURIComponent(locked_date_time,"UTF-8");
}
	
//This method LookStatus Return						
function CheckLockStatus(obj1,disp_locn_code,row_no,innerTextvalue1,patientName1,patientGender1,patientNationality1,patientNationalityDesc1,patientsex1,allow_disp_record_lock_yn,encounter_id){
//encounter_id added for SKR-SCF-1273.1	
	var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	innerTextvalue=innerTextvalue1;
	patient_id=obj1;
	patientName=patientName1;
	patientGender=patientGender1;
	patientNationality=patientNationality1;
	patientNationalityDesc=patientNationalityDesc1;
	patientsex=patientsex1;
	
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//encounter_id added for SKR-SCF-1273.1
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=CHECKLOCK&patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&allow_disp_record_lock_yn="+allow_disp_record_lock_yn+"&row_no="+row_no+"&encounter_id="+encounter_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

 //Message Display purpose only useing this method
function checklockresult(count_patient,user_id,patient_id,allow_disp_record_lock_yn,row_no,encounter_id){
//encounter_id added for SKR-SCF-1273.1	
	if(count_patient=='1'){
		 alert(getMessage("PATIENT_RECORD_IS_OPENED_BY_ANOTHER_USER","PH")+" "+user_id+"."+getMessage("ACCESS_DENIED","PH"));
		//parent.document.frames.reg_prescriptions_header_patient_line.location.href="../../eCommon/html/blank.html";
		//parent.document.frames.reg_prescriptions_header_details.location.href="../../eCommon/html/blank.html"; //parent.document.frames.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../eCommon/html/blank.html";
		//parent.document.frames.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../eCommon/html/blank.html";	
		//changeColor('0')
		return false; 
	}
	else if(count_patient=='0'){
		//  changeColor(row_no);
		changeColor(row_no);
	//encounter_id added for SKR-SCF-1273.1
		getOrdersForSelectedPatient(innerTextvalue,encounter_id);
		assignValuesForTokenSeries(patient_id,patientName,patientGender,patientNationality,patientNationalityDesc,patientsex);
		return true; 
	}
}

function getOrdersForSelectedPatient(obj,encounter_id){ //encounter_id added for SKR-SCF-1273.1
	checkFirstOrder =true;
	var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	var queryFormObj=parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
	var order_id		= queryFormObj.order_id.value;
	var priority		= queryFormObj.priority.value;
	var order_status	= queryFormObj.order_status.value;

    var Language_id		= queryFormObj.Language_id.value;
	var order_date_from = convertDate(queryFormObj.order_date_from.value,"DMY",Language_id,"en");
	var order_date_to	= convertDate(queryFormObj.order_date_to.value,"DMY",Language_id,"en");

	//var order_date_from = queryFormObj.order_date_from.value;
	//var order_date_to	= queryFormObj.order_date_to.value;
	var disp_locn_code	= queryFormObj.disp_locn_code.value;

	var ord_loc_type	= queryFormObj.ord_loc_type.value;
	var ord_locn_code	= queryFormObj.ord_locn_code.value;

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//encounter_id added for SKR-SCF-1273.1
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=OrdersForSelectedPatient&patient_id="+obj+"&priority="+priority+"&order_id="+order_id+"&order_status="+order_status+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&disp_locn_code="+disp_locn_code+"&ord_loc_type="+ord_loc_type+"&ord_locn_code="+ord_locn_code+"&enc_id="+encounter_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	var respText =xmlHttp.responseText;
	eval(respText);		
}

function assignValuesForTokenSeries(patientID,patientName,patientGender,patientNationality,patientNationalityDesc,patientsex){
	var formObj = document.RegPrescriptionsPatientHeader;
	formObj.patientID.value = patientID;
	formObj.patientName.value=patientName;
	formObj.patientGender.value=patientGender;
	formObj.patientNationality.value=patientNationality;
	formObj.patientNationalityDesc.value=patientNationalityDesc;
	formObj.patientSex.value=patientsex;
}

function changeColor(row_no){
	var row_no = parseFloat(row_no)+1;
	var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	var len = formObj.querySelector('#regprescriptionspatientheadertable').rows.length-1;
	for (var i=1;i<=len ;i++ ){
		if(formObj.querySelector('#regprescriptionspatientheadertable').rows[i].cells[0].style.backgroundColor=="#ffffcc"){
			formObj.querySelector('#regprescriptionspatientheadertable').rows[i].cells[0].style.backgroundColor="";
		}
	}
	formObj.querySelector('#regprescriptionspatientheadertable').rows[row_no].cells[0].style.backgroundColor="#ffffcc";
}

function changeColorForOrder(row_no){
	var row_no = parseFloat(row_no)+1;
	var len	   = RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows.length-1;

	for (var i=1;i<=len ; i++){
		if(RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows[i].cells[1].style.backgroundColor=="#ffffcc"){
			RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows[i].cells[1].style.backgroundColor="";
		}
	}
	RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows[row_no].cells[1].style.backgroundColor="#ffffcc";
}

function hideToolTip() {
	var formObj = document.RegPrescriptionsPatientHeader;
	formObj.querySelector('#tooltiplayer').style.visibility='hidden';
}

/*
	obj1  -- PATIENT_ID
	obj2  -- PATIENT_NAME
	obj3  -- AGE
	obj4  -- SEX
	obj5  -- NATIONALITY_DESC
*/
function displayToolTip(obj1,obj2,obj3,obj4,obj5,lock_status_return) {
	
	var formObj = document.RegPrescriptionsPatientHeader;
	buildTable(obj1,obj2,obj3,obj4,obj5);
	bodwidth  = formObj.offsetWidth
	bodheight = formObj.offsetHeight

	bodwidth  = 60;
	bodheight = 10;

	var x 	  = event.x;
	var y 	  = event.y;
	var tooltiplayer = formObj.querySelector('#tooltiplayer');
	x 	  = x + (tooltiplayer.offsetWidth)
	y 	  = y + (tooltiplayer.offsetHeight)

	if(y<bodheight)
		y = event.y
	else
		y = y - (tooltiplayer.offsetHeight)

	tooltiplayer.style.posTop = y
	tooltiplayer.style.visibility='visible';
}

function buildTable(obj1,obj2,obj3,obj4,obj5){
	//alert(encodeURIComponent(obj5,"UTF-8").replace(/\+/g," "));
	//getLabel("Common.age.label","Common");Common.gender.label  Common.nationality.label
	var formObj = parent.document.reg_prescriptions_header_patient_id;
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' >"
	//tab_dat     += "<tr><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:20%'>Name</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+obj2+"</td></tr>";
	tab_dat     += "<tr><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:20%'>"+getLabel("Common.age.label","Common")+"</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+unescape(obj3)+"</td></tr>";
	
	tab_dat     += "<tr><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:20%'>"+getLabel("Common.gender.label","Common")+"</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+unescape(obj4)+"</td></tr>";
	
	if(obj5!="null" ){
			tab_dat     += "<tr><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:20%'>"+getLabel("Common.nationality.label","Common")+"</td><td align='left' style='font-size:xx-small' class='TOOLTIP' style='background-color:lightYellow;width:80%'>:&nbsp;"+unescape(obj5)+"</td></tr>";
	}
	tab_dat     += "</table>";
	formObj.RegPrescriptionsPatientHeader.querySelector('#t').innerHTML = tab_dat;
}

var checkFirstOrder=true;

/*
	obj0	--	PRIORITY    
	obj1	--	ORDER_TYPE_CODE
	obj2	--	ORDER_TYPE_DESC
	obj3	--	ORDER_ID
	obj4	--	ORD_DATE_TIME
	obj5	--	SOURCE_DESC
	obj6	--	ORD_PRACT_ID
	obj7	--	PRACTITIONER_NAME
	obj8	--	ORDER_LINE_STATUS
	obj9	--	CHILD_ORDER_YN
	obj10	--	DISCHARGE_IND
	obj11	--	ENCOUNTER_ID
	obj12   --  PRINT PRESCRIPTION(from dispense location setup) 
*/
function assignDataToPresDetailsFrame(obj0, obj1, obj2 , obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12){

    var Language_id		= parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria.Language_id.value;
	obj4				= convertDate(obj4,"DMY","en",Language_id);

	var order_status = parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria.order_status.options[parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria.order_status.selectedIndex].value;
	
	//alert("order_status--->"+order_status);
	if(obj5=="null")
		obj5	= "";

	if (parent.reg_prescriptions_header_details==undefined){
		var formObj = parent.reg_prescriptions_header.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	}
	else{
		var formObj = parent.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
		var formTable =parent.reg_prescriptions_header_details.document.getElementById('regprescriptionsdetailstable');
		var row_no	= formTable.rows.length-1;
		if (deleteFlag==false){
			deleteFlag=true;
			for (var i = row_no; i >= 1; i--){
				formTable.deleteRow(i);
			}
		}
	}
	var row_no	= formTable.rows.length-1;
	// this is to identify how many orders are there for the selected patient
	formObj.no_of_orders.value = row_no+1;
	curr_row	=	formTable.insertRow();

	var classval;
	if(row_no % 2 == 0 )
		classval	=	"QRYEVEN";
	else
		classval	=	"QRYODD";

	var status="";
	//Added AND condition for getting Refill orders onselecting scope=Discharge Medication Patients for the incident num:24640,24732 on 29/Oct/2010===By Sandhya
	if (obj10=='D' && obj9=='N' && obj8 !='DP'){  //added && obj8 !='DP' for BRU-SCF-0379(34810)
		status = "ADD8E6"
	}
	//Added OR condition for getting Refill orders onselecting scope=ALL for the incident num:24640 on 25/Oct/2010===By Sandhya
	else if (order_status=='R' || obj9=='Y'){
		status = "#CC9933"
	}
	else if (obj8 >= 'OS' && obj8 < 'RG'){
		status = "#FF0000"
	}
	else if (obj8=='DP'){
		status = "#990000"
	}
	else if (obj8>='OS' && obj8<'RG' && obj9=='Y'){
		status = "#CC9933"
	}

	for(i=0; i<8; i++)	{
		cell	=	curr_row.insertCell();
		if (i==0){
			curr_row.cells[0].className	= classval;
			if(obj0=="Urgent"){
				curr_row.cells[0].innerHTML = "<font style='font-size:9px;color:#B22222' >"+decodeURIComponent( obj2,"UTF-8")+"</font>" + "<input type='hidden' value='"+obj1+"'>"; //unescape(obj2)
			}
			else{
				curr_row.cells[0].innerHTML = "<font style='font-size:9px;' >"+decodeURIComponent( obj2,"UTF-8")+"</font>" + "<input type='hidden' value='"+obj1+"'>"; //unescape(obj2)
			}
		}
		else if (i==1){
			if (row_no==0){
				curr_row.cells[1].style.backgroundColor	= "#ffffcc";
			}
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].innerHTML = "<font style='color:blue;font-size:9px;cursor:pointer' onClick=\"displayPrescriptionDetails('"+obj3+"','"+row_no+"','"+obj10+"');changeColorForOrder('"+row_no+"');enableDisableRegister('"+row_no+"');storeOrderDetails()\" >"+obj3+"</font>"+"<input name='order_id"+row_no+"' id='order_id"+row_no+"'  type='hidden' value="+obj3+">"+"<input name='encounter_id"+row_no+"' id='encounter_id"+row_no+"' type='hidden' value="+obj11+">";
		}
		else if (i==2){
			curr_row.cells[2].className	= classval;
			curr_row.cells[2].innerHTML = "<font style='font-size:9px'>"+obj4+"</font>";
		}
		else if (i==3){
			curr_row.cells[3].className	= classval;
			curr_row.cells[3].innerHTML = "<font style='font-size:9px'>&nbsp;"+decodeURIComponent( obj5,"UTF-8")+"</font>"; // unescape(obj5)
		}
		else if (i==4){
			curr_row.cells[4].className	= classval;
			curr_row.cells[4].innerHTML = "<font style='font-size:9px'>"+decodeURIComponent( obj7,"UTF-8")+"</font>" + "<input type='hidden' value='"+obj6+"'>"; //unescape(obj7)
		}
		else if(i==5){
			curr_row.cells[5].style.backgroundColor = status;
		}
		else if (i==6){
			if (checkFirstOrder==true){
				checkFirstOrder = false;
				curr_row.cells[6].innerHTML = "<input type='checkbox' name='select"+row_no+"' id='select"+row_no+"' value='E' onClick='enableDisableRegister("+row_no+");storeOrderDetails()' checked >";
				curr_row.cells[6].align="center";
			}
			else {
				curr_row.cells[6].innerHTML = "<input type='checkbox' name='select"+row_no+"' id='select"+row_no+"' value='E' onClick='enableDisableRegister("+row_no+");storeOrderDetails()' checked>";
				curr_row.cells[6].align="center";
			}
		}
		else if (i==7){
			if(obj12=='Y'){
			     curr_row.cells[7].innerHTML = "<input type='checkbox' name='print"+row_no+"' id='print"+row_no+"' value='D' >";
			}
			else{
                 curr_row.cells[7].innerHTML = "<input type='checkbox' name='print"+row_no+"' id='print"+row_no+"' value='D' disabled >";
			}
			curr_row.cells[7].align="center";
		}
	}
}

//To assign the number of patients found...
function assignToNumberOfPatients(obj){
		parent.parent.reg_prescriptions_header.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader.querySelector('#no_of_patients').innerText=obj
}

//This is to display Prescription Details on click of order number
function displayPrescriptionDetails(order_id,row_no_to_check, dischargeIND_yn){
	var formObj = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	var disp_locn_code =parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria.disp_locn_code.value;
	var billing_interface_yn = formObj.billing_interface_yn.value;
	
	eval("formObj.select"+row_no_to_check).checked = true;
	var enableDisable = "disabled";
	if(dischargeIND_yn=='D')
		dischargeIND_yn = 'Y';
	else
		dischargeIND_yn = formObj.dischargeIND.value;
	var regprescriptionsdetailstableLength=parent.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows.length;

	for (var i=0;i<regprescriptionsdetailstableLength-1;i++){
		if (eval("formObj.select"+i).checked==true){
			enableDisable = "";
			break;
		}
	}
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//	beforePost(xmlStr);
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=DrugDosageDetails"+"&order_id="+order_id+"&disp_locn_code="+disp_locn_code+"&dischargeIND_yn="+dischargeIND_yn, false ) ;
	xmlHttp.send( xmlDoc ) ;
	var encounter_id =formObj.encounter_id0.value;
	parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../ePH/jsp/RegPrescriptionsDetailFooter.jsp?encounter_id="+encounter_id+"&enableDisable="+enableDisable+"&billing_interface_yn="+billing_interface_yn+"&dischargeIND_yn="+dischargeIND_yn;//Removed displayData for change in Register order data retrival
	if(billing_interface_yn != "Y"){
	   parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../ePH/jsp/RegPrescriptionsButtonsFooter.jsp?enableDisable="+enableDisable;//Removed displayData for change in Register order data retrival
	}
}

function beforePost(xmlStr){
	//alert("In Reg Prescriptions function:"+xmlStr)
}

var print_pres_value="N";
function assignPrintPresValue(obj){
	if(obj.checked==true){
		print_pres_value="Y";
	}
}

//This function is called on click of register button in Prescription details
async function registerPrescription(){
	var order_id	=	"";
	var calledfrom  =   ""; 
	var homePage="";//added for  Bru-HIMS-CRF-073.1 [IN:047222]
	parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
	if(parent.parent.parent.document.reg_prescriptions_query!=undefined){
	    var queryFormObj=parent.parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria;
		homePage = queryFormObj.homepage.value; //added for  Bru-HIMS-CRF-073.1 [IN:047222]
	}
	else{       
        var queryFormObj=parent.f_query_add_mod.document.TaskListQueryCriteria;
	}
    if(parent.parent.document.reg_prescriptions_header_patient_id!=undefined){
		var formObj= parent.parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
		 calledfrom  = "";
	}
	else{
       var formObj = parent.f_stage.document.regprescriptionsdetailfooter; 
	   calledfrom  = "TASKLIST";
	}

    if(parent.parent.document.reg_prescriptions_header_details!=undefined){
	   var formObjOrders = parent.parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	}
	else{
        var formObjOrders = parent.f_stage_2.document.RegPrescriptionsDetailsHeader;
	}

    if(parent.parent.document.reg_prescriptions_footer_details!=undefined){
	    var formPresDetailsObj = parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.regPrescriptionsButtonsFooter;
	}
	else{
		var formPresDetailsObj = parent.f_stage_1.document.regPrescriptionsButtonsFooter;
	}

    if(parent.parent.document.reg_prescriptions_footer_details!=undefined){
	     var formDrugDetailsObj = 	parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfooter;
	}
	else{
         var formDrugDetailsObj = formObj;  
	}
	var issue_token_on_regn_yn = trimString(formPresDetailsObj.issue_token_on_regn_yn.value);
	if(trimString(formPresDetailsObj.issue_token_on_regn_yn.value)=="Y"){
		var orders_selected     = "";
		var print_pres_orders	= "";
	
		
		
		var length = 	parent.parent.reg_prescriptions_header_details.document.getElementById('regprescriptionsdetailstable').rows.length-1;
			for (var i=0;i<length ; i++){
				if (eval("formObjOrders.select"+i).checked == true){
					orders_selected = orders_selected + eval("formObjOrders.order_id"+i).value +",";
					order_id		=	eval("formObjOrders.order_id"+i).value;
				}
				if( eval("formObjOrders.print"+i).checked ==true){
				   print_pres_orders = print_pres_orders + eval("formObjOrders.order_id"+i).value +",";
				}
			}
	  // var print_pres	="";
	   for(var i=0;i<length ; i++){
		  if( eval("formObjOrders.print"+i).checked ==true){
                  print_pres	=	"Y";
				 break;

		  }
		  else{
			  print_pres	=	"N";
		  }
	   }
		var patient_id		 = formObj.patientID.value;
		var patient_name	 = parent.parent.reg_prescriptions_header_patient_line.RegPrescriptionsPatientLine.patient_name.value;
		var gender			 = formObj.patientGender.value;
		var nationality		 = formObj.patientNationality.value;
		var nationalityDesc	 = formObj.patientNationalityDesc.value;
		var sex				 = formObj.patientSex.value;

		/*var print_pres	;	
			if(formPresDetailsObj.print_pres_on_regn_yn.checked) {
				print_pres	=	"Y";
			}	else {
				print_pres	=	"N";
			}*/
        if(parent.parent.document.reg_prescriptions_header_details!=undefined){
		   var encounter_id = parent.parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader.encounter_id0.value;
        }
		else{
           var encounter_id =formObj.encounter_id.value;
		}
		var dialogHeight= "45vh";
		var dialogWidth	= "35vw" ;
		var dialogTop = "2" ;
		var center = "2" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;		
		//var retVal =undefined;//added for CRF352		
		//if(orders_selected!=""){//added for CRF352 Starts
			var retVal =await top.window.showModalDialog("../../ePH/jsp/RegPrescriptionsIssueToken.jsp?disp_locn_code="+queryFormObj.disp_locn_code.value+"&patient_id="+patient_id+"&patient_name="+encodeURIComponent(patient_name,'UTF-8')+"&gender="+encodeURIComponent(gender)+"&nationality="+nationality+"&nationalityDesc="+encodeURIComponent(nationalityDesc)+"&encounter_id="+encounter_id+"&order_id="+order_id+"&print_pres="+print_pres+"&orders_selected="+orders_selected+"&print_pres_orders="+print_pres_orders+"&sex="+sex,arguments,features);
		//}	//added for CRF352 Ends
		if(retVal !=undefined){
			
			parent.parent.reg_prescriptions_header_patient_line.location.href="../../eCommon/html/blank.html";//added for ML-BRU-SCF-0169 [IN:032571] - Start
			parent.parent.reg_prescriptions_header_details.location.href="../../eCommon/html/blank.html"; 
			parent.parent.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../eCommon/html/blank.html";
			parent.parent.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../eCommon/html/blank.html";	//added for ML-BRU-SCF-0169 [IN:032571] - End			
			if(homePage=='Y'){ //Added for  Bru-HIMS-CRF-073.1 [IN:047222]
				parent.parent.parent.parent.parent.menuFrame.document.location.reload();
			}
			var resultArray = retVal.split("&");
			if (resultArray[0]==getLabel("ePH.TokenGenerated.label","PH")){
				//if(calledfrom!="TASKLIST"){
					parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+resultArray[1]+getLabel("ePH.TokenNo.label","PH")+" : <label style='font-size:18px'><b>"+resultArray[2]+"</b></label>";	
					//parent.parent.parent.parent.f_query_add_mod.location.href="../../ePH/jsp/RegPrescriptionsFrames.jsp";//added for the incident 37060
					autoCallReRoute_yn = parent.parent.parent.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.autoCallReRoute_yn.value; //added for [IN:045320]
					if(formObj.callFrom!=undefined)
						callFrom = formObj.callFrom.value;
					else
						callFrom ="";
					if(parent.parent.parent.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.patient_id.value!=""){
						parent.parent.parent.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.reset();
						parent.parent.parent.location.href="../../ePH/jsp/RegPrescriptionsFrames.jsp";
						parent.parent.location.href="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp";
					}
					else if ((autoCallReRoute_yn=='Y' && callFrom=="") || autoCallReRoute_yn != 'Y'){ //added for [IN:045320] // || condition added for HSA-SCF-0055 [IN:050086] 
					    queryFormObj.btnRefresh.click();	//commented for the incident 37060 
					}
				/*}else{
                	 parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+resultArray[1]+"Token No:<label style='font-size:18'><b>"+resultArray[2]+"</b></label>";
					 queryFormObj.btnProceed.click();	
				}*/
			}
			else{
              /*  if(calledfrom!="TASKLIST"){*/
					parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+retVal;		
					if(parent.parent.parent.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.patient_id.value!=""){
						parent.parent.parent.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.reset();
						parent.parent.parent.location.href="../../ePH/jsp/RegPrescriptionsFrames.jsp";
						parent.parent.location.href="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp";
					}
					else
						queryFormObj.btnRefresh.click();					
				/*}else{
                	 parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+retVal;
					 queryFormObj.btnProceed.click();	
				} */ 
			}
		}		
		/*else{//added for CRF352 Starts
			alert(getLabel("ePH.Atleastoneshouldbeselected.label","PH"));
		}*/	//added for CRF352 Ends
	}
	else{
		var orders_selected = "";
		var print_pres_orders	= "";
		var length = 	formObjOrders.querySelector('#regprescriptionsdetailstable').rows.length-1;
		for (var i=0;i<length ; i++){
			if (eval("formObjOrders.select"+i).checked == true){
				orders_selected = orders_selected + eval("formObjOrders.order_id"+i).value +",";
				order_id		=	eval("formObjOrders.order_id"+i).value;
			}
			if( eval("formObjOrders.print"+i).checked ==true){
			   print_pres_orders = print_pres_orders + eval("formObjOrders.order_id"+i).value +",";
			}
		}
		var print_pres	;
		for(var i=0;i<length ; i++){
			if( eval("formObjOrders.print"+i).checked ==true){
				print_pres	=	"Y";
				break;
			}
			else{
				print_pres	=	"N";
			}
		}
		formObjOrders.print_pres.value=print_pres;
		formObjOrders.orders_selected.value = orders_selected;
		formObjOrders.print_pres_orders.value = print_pres_orders;

		eval(formApply(formObjOrders,PH_CONTROLLER ));
		callPrintDialog(formObjOrders);
		//if(calledfrom!="TASKLIST"){
	 		parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+message;
			if(homePage=='Y' && result){ //added for  Bru-HIMS-CRF-073.1 [IN:047222]
				parent.parent.parent.parent.parent.menuFrame.document.location.reload();
			}
			parent.parent.reg_prescriptions_header_patient_line.location.href="../../eCommon/html/blank.html";//added for ML-BRU-SCF-0169 [IN:032571] - Start
			parent.parent.reg_prescriptions_header_details.location.href="../../eCommon/html/blank.html"; 
			parent.parent.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../eCommon/html/blank.html";
			parent.parent.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../eCommon/html/blank.html";	//added for ML-BRU-SCF-0169 [IN:032571] - End
			queryFormObj.btnRefresh.click();
			queryFormObj.callFrom.value = "Registered";
		//}else{
			// parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+message;
			// queryFormObj.btnProceed.click();
		//}
	}
}

function cancelIssueToken(){
	disableIssueToken();
}

function getTokenDetails(disp_locn_code,gender,nationality){
	var formObj = document.regprescriptionsissuetokenfooter;
	
	var len=formObj.token_series_code.length;
	for(var i=0;i<len;i++) {
		formObj.token_series_code.remove("token_series_code") ;
	}

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=TokenSeries"+"&disp_locn_code="+disp_locn_code+"&gender="+gender+"&nationality="+nationality, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function assignTokenSeriesDetails(token_series_code,token_series_desc,next_serial_no){
	var formObj=document.regprescriptionsissuetokenfooter;
	var tp =  token_series_desc;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = token_series_code ;
	formObj.token_series_code.add(opt1); 	
}

function assignSelTokenSeriesForPatient(obj){
	var formObj=document.regprescriptionsissuetokenfooter;
	formObj.hidden_token_series_desc.value = obj.options[obj.selectedIndex].text
	formObj.hidden_token_series_code.value = obj.value;
      
    var disp_locn_code	= formObj.disp_locn_code.value;
    var bean_id			= formObj.bean_id.value ;
	var bean_name		= formObj.bean_name.value ;
	var xmlDoc			= " ";
	var xmlHttp			= new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
   	xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
	xmlStr+= "token_series_code =\"" + obj.value + "\" " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=GenTokenYN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function DisplayTokenNO(gettokenyn,QMS_required_yn, QMS_edit_token_yn){ // ,QMS_required_yn, QMS_edit_token_yn  added for Bru-HIMS-CRF-076 [IN029942]
	document.regprescriptionsissuetokenfooter.gen_token_yn.value=gettokenyn;
	if(gettokenyn=='N'){
		document.getElementById("gen_token").style.display="display";
		// added for Bru-HIMS-CRF-076 [IN029942] - start
		if(QMS_required_yn=='Y'){
			document.regprescriptionsissuetokenfooter.btnGenerateToken.value=getLabel("Common.Register.label","Common");
			document.getElementById("QMS_gen_token").style.display="display";
			if(QMS_edit_token_yn != 'Y')
				document.regprescriptionsissuetokenfooter.token_no.readOnly = true;
	   }
	   else{
			document.regprescriptionsissuetokenfooter.btnGenerateToken.value=getLabel("ePH.GenerateToken.label","ph_labels");
			if(document.getElementById("QMS_gen_token")!=undefined)
				document.getElementById("QMS_gen_token").style.display="none";
			document.regprescriptionsissuetokenfooter.token_no.readOnly = false;
	   }
	   // added for Bru-HIMS-CRF-076 [IN029942] end
	}
	else{
      document.getElementById("gen_token").style.display="none";  
	}
}

function assignTokenSeriesDetailsForNonPatient(){
	var disp_locn_code = document.regprescriptionsissuetokenfooter.disp_locn_code.value;
	var gender	= document.regprescriptionsissuetokenfooter.med_pat_gender.value;
	var nationality = document.regprescriptionsissuetokenfooter.med_pat_nationality.value;
	if (gender !="" && nationality!=""){
		getTokenDetails(disp_locn_code,gender,nationality);
	}
}

function assignToPatientLine(patient_id,name,age,gender,nationality, genderCode, nationalityCode,patientclass,encounterid ){//code 'patientclass,encounterid' added for JD-CRF-0156[IN041737]
	printFlag =false;
	finalResponse="";
	//alert(decodeURIComponent(nationality,"UTF-8").replace(/\+/g," "));
	var disp_locn_code=parent.parent.document.reg_prescriptions_query.RegPrescriptionsQueryCriteria.disp_locn_code.value;
	 
	if (parent.document.reg_prescriptions_header_patient_line ==undefined){
		parent.document.reg_prescriptions_header.reg_prescriptions_header_patient_line.location.href="../../ePH/jsp/RegPrescriptionsPatientLine.jsp?name="+decodeURIComponent(name,"UTF-8")+"&age="+age+"&gender="+gender+"&nationality="+nationality+"&patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&patientclass="+patientclass+"&encounterid="+encounterid;//code '"&patientclass="+patientclass+"&encounterid="+encounterid' added for JD-CRF-0156[IN041737]
	}
	else{
		parent.document.reg_prescriptions_header_patient_line.location.href="../../ePH/jsp/RegPrescriptionsPatientLine.jsp?name="+decodeURIComponent(name,"UTF-8")+"&age="+age+"&gender="+gender+"&nationality="+nationality+"&patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&patientclass="+patientclass+"&encounterid="+encounterid;//code '"&patientclass="+patientclass+"&encounterid="+encounterid' added for JD-CRF-0156[IN041737]
	}
	var formObj = parent.reg_prescriptions_header_patient_id.document.RegPrescriptionsPatientHeader;
	formObj.patientID.value = patient_id;
	formObj.patientName.value=name;
	formObj.patientGender.value=gender;
	formObj.patientNationality.value=nationalityCode;
	formObj.patientNationalityDesc.value=nationality;
	formObj.patientSex.value=genderCode;
}

function clearTextFromPatientIdLocator(){
	var formObj = parent.document.reg_prescriptions_header_patient_id_locator.RegPrescriptionsPatientIDLocator.patient_id_locator;
	if (formObj.value==""){
		formObj.value=getLabel("ePH.EnterPatientIDTo.label","PH");
	}
}

function clearIssueTokenForNonPatient(pat_coll_med){
	var formObj = document.regprescriptionsissuetokenfooter
	//formObj.token_series_desc.value="";
	formObj.token_series_code.value="";
	if (pat_coll_med.checked==true){
		//name
		document.getElementById("lbl_med_pat_name").style.display="inline";
		document.getElementById("lbl_med_pat_name").style.visibility="visible";
		formObj.med_pat_name.style.display="none";
		formObj.mand_img_name.style.visibility="hidden";
		//gender
		document.getElementById("lbl_med_pat_gender").style.display="inline";
		document.getElementById("lbl_med_pat_gender").style.visibility="visible";
		formObj.med_pat_gender.style.display="none";
		formObj.mand_img_gender.style.visibility="hidden";
		//nationality
		document.getElementById("lbl_med_pat_nationality").style.display="inline";
		document.getElementById("lbl_med_pat_nationality").style.visibility="visible";
		formObj.med_pat_nationality.style.display="none";
		formObj.mand_img_nationality.style.visibility="hidden";
		//token series
		formObj.token_series_code.style.display="none";
		formObj.token_series_code_for_patient.style.display="inline";
		formObj.token_series_code_for_patient.style.visibility="visible";
	}
	else{
		//name
		document.getElementById("lbl_med_pat_name").style.display="none";
		formObj.med_pat_name.style.display="inline";
		formObj.med_pat_name.style.visibility="visible";
		formObj.mand_img_name.style.visibility="visible";
		//gender
		document.getElementById("lbl_med_pat_gender").style.display="none";
		formObj.med_pat_gender.style.display="inline";
		formObj.med_pat_gender.style.visibility="visible";
		formObj.mand_img_gender.style.visibility="visible";
		//nationality
		document.getElementById("lbl_med_pat_nationality").style.display="none";
		formObj.med_pat_nationality.style.display="inline";
		formObj.med_pat_nationality.style.visibility="visible";
		formObj.mand_img_nationality.style.visibility="visible";
		//token series
		formObj.token_series_code.style.display="inline";
		formObj.token_series_code.style.visibility="visible";
		formObj.token_series_code_for_patient.style.display="none";
	}
}

function generateToken(){
	var formObj = document.regprescriptionsissuetokenfooter ;
	if (formObj.token_series_code.display=="inline" && formObj.token_series_code.value==""){
		alert(getMessage("TOKEN_SERIES_CANNOT_BLANK","PH"));
		window.close();
		return false;
	}
	else{
		if (formObj.pat_coll_med.checked==false){
			
			var fields = "";
		    var names  = "";
			if(formObj.gen_token_yn.value==null||formObj.gen_token_yn.value=='Y'){
			     fields = new Array (formObj.med_pat_name,formObj.med_pat_gender,formObj.med_pat_nationality);
 			     names = new Array ( getLabel("Common.name.label","Common") ,getLabel("Common.gender.label","Common"),getLabel("Common.nationality.label","Common"));  
			   //  names = new Array ( "Name","Gender","Nationality");
			}
			else if(formObj.gen_token_yn.value=='N'){
				 fields = new Array (formObj.med_pat_name,formObj.med_pat_gender,formObj.med_pat_nationality,formObj.token_no);
 				 names = new Array ( getLabel("Common.name.label","Common") ,getLabel("Common.gender.label","Common"),getLabel("Common.Nationality.label","Common"),getLabel("ePH.TokenNo.label","PH"));
			     //names = new Array ( "Name","Gender","Nationality","Token No");
			}

			if(checkFlds( fields, names)) {
				eval(formApply( document.regprescriptionsissuetokenfooter,PH_CONTROLLER ));
				if( result ) {
					if(document.regprescriptionsissuetokenfooter.print_token_series.checked || document.regprescriptionsissuetokenfooter.print_pres.value=="Y"){
						callPrintDialog(document.regprescriptionsissuetokenfooter);
					}
				}
				var msg="";
				if( result ){                 
				   msg=getLabel("ePH.TokenGenerated.label","PH")+"&"+message+"&"+flag;
				   window.close();		
			       window.returnValue=msg;
			    }
				else{
                    msg=message; 
				    alert(message);
			    }		 
			}
		}
		else{
			var formObj = document.regprescriptionsissuetokenfooter;
			if (formObj.token_series_code_for_patient.value==""){
				alert(getMessage("TOKEN_SERIES_CANNOT_BLANK","PH"));
				window.close();
				return false;
			}
			if(formObj.gen_token_yn.value=='N'  && formObj.querySelector('#gen_token').style.display=='display'){
				if(formObj.token_no.value=="")
					alert(getMessage("TOKEN_CANNOT_BLANK","PH"));
			}
			if(formObj.patient_arrived.value=="N" && formObj.generate_actual_token_yn.value=="N"){
				if(formObj.gen_token_yn.value=='N'&&formObj.token_no.value=="") {
					var bean_id		= formObj.bean_id.value ;
					var bean_name	= formObj.bean_name.value ;
					var disp_locn_code=formObj.disp_locn_code.value;
					var token_series_code=formObj.hidden_token_series_code.value;
					var xmlDoc="";
					var xmlHttp = new XMLHttpRequest();
					xmlStr	="<root><SEARCH " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=getDummyTokenNo&token_series_code="+token_series_code+"&disp_locn_code="+disp_locn_code, false ) ;
					xmlHttp.send( xmlDoc ) ;
					eval(xmlHttp.responseText);
					formObj.token_no.value=global_dummy_token_no;
				}
			}
            
			if((formObj.gen_token_yn.value=='N'&&formObj.token_no.value!="")||(formObj.gen_token_yn.value=='Y')){
				eval(formApply( document.regprescriptionsissuetokenfooter,PH_CONTROLLER ));
				if( result ) {
					if(document.regprescriptionsissuetokenfooter.print_token_series.checked || document.regprescriptionsissuetokenfooter.print_pres.value=="Y"){
						callPrintDialog(document.regprescriptionsissuetokenfooter);
					}
				}
				var msg="";
				if( result ){
					msg=getLabel("ePH.TokenGenerated.label","PH")+"&"+message+"&"+flag;
					window.close();
					window.returnValue=msg;
				 }
				 else{
					   msg=message; 
					   alert(message);
				 }
			 }
		}		
	}
}

function callPrintDialog(obj) {
	    
		var bean_id		=	obj.bean_id.value;
		var bean_name	=	obj.bean_name.value;
		var patient_id  = "";
		if(obj.patient_id!=null)
			patient_id  =   obj.patient_id.value;
		
		//var order_id	=   obj.orders_selected.value;
		var order_id	= obj.print_pres_orders.value;
		var print_pres	= "N";
		if(obj.print_pres!=null){
			print_pres	=	obj.print_pres.value;			
		}else{
			print_pres = print_pres_value;
		}

		var print_token	=	"N";
		if(obj.print_token_series!=null && obj.print_token_series.checked) {
			print_token	=	"Y";
		}

		if(obj.token_series_code!=null && obj.token_series_code.display !="inline")
			var token_series_code = obj.hidden_token_series_code.value;
		else if(obj.token_series_code !=null)
			var token_series_code = obj.token_series_code.value;
		var disp_locn_code = "";
		if(obj.disp_locn_code!=null)
			disp_locn_code = obj.disp_locn_code.value;

		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id  =\"" + bean_id + "\" " ;
		xmlStr+= "bean_name =\"" + bean_name + "\" " ;
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "token_series_code =\"" + token_series_code + "\" " ;
		xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
		xmlStr+= "order_id =\"" + order_id + "\" " ;	
		xmlStr+= "print_pres =\"" + print_pres + "\" " ;	
		xmlStr+= "print_token =\"" + print_token + "\" " ;			
		xmlStr +=" /></root>";
		var temp_jsp="RegPrescriptionsValidate.jsp?identity=print_register&bean_id="+bean_id+"&bean_name="+bean_name;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,true);
		xmlHttp.send(xmlDoc);
}

//This method will be used to locate the patient based on patient id
function locatePatientID(){	
	var patient_id_locator	=	document.RegPrescriptionsPatientIDLocator.patient_id_locator.value;
	if(trimString(patient_id_locator) == '' || trimString(patient_id_locator)==getLabel("ePH.EnterPatientIDTo.label","PH")){
		parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NOT_VALID_PATIENT","PH");
		document.RegPrescriptionsPatientIDLocator.patient_id_locator.value="";
		clearTextFromPatientIdLocator();
		return false;
	}
	var formObj = parent.document.reg_prescriptions_header_patient_id.RegPrescriptionsPatientHeader;
	var row_no = formObj.regprescriptionspatientheadertable.rows.length-1;
	var RetainRowColor = "";
	for (var i=0;i<row_no ; i++){
		if(formObj.regprescriptionspatientheadertable.rows[i+1].cells[0].style.backgroundColor=="#ffffcc"){
			RetainRowColor = i+1;
			formObj.regprescriptionspatientheadertable.rows[i+1].cells[0].style.backgroundColor="";
		}
	}
	for (var i=0;i<row_no ; i++){
		if (eval("formObj.patient_id"+i).value==trimString(patient_id_locator)){
			eval("formObj.patient_id"+i).scrollIntoView();
			formObj.regprescriptionspatientheadertable.rows[i+1].cells[0].style.backgroundColor	= "#ffffcc";

			document.RegPrescriptionsPatientIDLocator.patient_id_locator.value="";	
			clearTextFromPatientIdLocator();
			formObj.patientID.value				=	patient_id_locator; 
			formObj.patientName.value			=	eval("formObj.patient_name"+i).value;
			formObj.patientGender.value			=	eval("formObj.gender"+i).value;
			formObj.patientNationality.value	=	eval("formObj.nationality"+i).value;
			formObj.patientNationalityDesc.value=	eval("formObj.nationality_desc"+i).value;
			formObj.patientSex.value            =	eval("formObj.sex_val"+i).value;

			getOrdersForSelectedPatient(trimString(patient_id_locator))
			return false;
		}
	}
	formObj.regprescriptionspatientheadertable.rows[parseFloat(RetainRowColor)].cells[0].style.backgroundColor	= "#ffffcc";
	parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");

	//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	document.RegPrescriptionsPatientIDLocator.patient_id_locator.value="";
	clearTextFromPatientIdLocator();
}

//function assignPrescriptionDetailsForTheFirstOrder(obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,obj10,obj11,obj12,obj13,obj14,lock_status_return, dischargeIND_yn, tapered_yn, taper_order_id,route_desc,route_color){ // added route_desc,route_color for CRF RUT-CRF-0034.1[IN:037389] 
function assignPrescriptionDetailsForTheFirstOrder( lock_status_return, dischargeIND_yn ){ // added route_desc,route_color for CRF RUT-CRF-0034.1[IN:037389] 
	//if(route_color=='') //added for  [IN:039409]
	//	route_color = 'DEFALUT';
	drug_yn=lock_status_return;
	var billing_interface_yn = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader.billing_interface_yn.value;
	//var response = obj1+"~"+obj2+"~"+obj3+"~"+obj4+"~"+obj5+"~"+obj6+"~"+obj7+"~"+obj8+"~"+obj9+"~"+obj10+"~"+obj11+"~"+obj12+"~"+obj13+"~"+obj14+"~"+"~"+drug_yn+"~"+tapered_yn+"~"+taper_order_id+"~"+route_desc+"~"+route_color+"~";
	if (printFlag==false){
		printFlag=true;
		//finalResponse += printRelatedInfo+response;
	}
	/*else{
		finalResponse += response;
	}*/
	var orderformobj =parent.parent.document.reg_prescriptions_header;
	//dischargeIND_yn=parent.document.frames.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader.dischargeIND.value;
	var encounter_id = parent.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader.encounter_id0.value;
	parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.location.href="../../ePH/jsp/RegPrescriptionsDetailFooter.jsp?encounter_id="+encounter_id+"&enableDisable=disabled&billing_interface_yn="+billing_interface_yn+"&dischargeIND_yn="+dischargeIND_yn;//Removed displayData for change in Register order data retrival
	if(billing_interface_yn != "Y")	{
		parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href="../../ePH/jsp/RegPrescriptionsButtonsFooter.jsp?enableDisable=disabled";//Removed displayData for change in Register order data retrival
	}
}

function assignPrintRelatedInfo(obj1,obj2){
	printRelatedInfo=obj1+"~"+obj2+"~";
}

// This function will enable/disable 'btnRegisterPres' button based on the order selection.
// If no order is selected then the button should be disabled else it should be enabled
function enableDisableRegister(obj){
	var row_no = parseFloat(obj);
	// order frame
	var formObj		= document.RegPrescriptionsDetailsHeader.regprescriptionsdetailstable;
	var lenFormObj	= RegPrescriptionsDetailsHeader.querySelector('#regprescriptionsdetailstable').rows.length-1;

	// order line frame
	var presFormObj		= parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfooter;
	var lenpresFormObj	= parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfootertable.rows.length-2;
	
	// For Register button
	var regFormObj	=	parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.regPrescriptionsButtonsFooter;

	var enableDisableFlag=true;
	for (var i=0;i<lenFormObj ;i++ ){
		if (eval("document.RegPrescriptionsDetailsHeader.select"+i).checked==true){
			enableDisableFlag = false;
	        if(row_no==i){
				if (eval("document.RegPrescriptionsDetailsHeader.order_id"+i).value==presFormObj.order_id.value){
					for (var j=0;j<lenpresFormObj ; j++){
						if(eval("presFormObj.prescriptionSelect"+j).style.display =='inline')  // Added for for 42663
							eval("presFormObj.prescriptionSelect"+j).disabled=false;
						if(row_no==i){
							eval("presFormObj.prescriptionSelect"+j).checked=true;
						}
					}
					if (enableDisableFlag == false){
						regFormObj.btnRegisterPres.disabled=false;
					}
					else{
						regFormObj.btnRegisterPres.disabled=true;
					}
					return false;
				}
			}
			/*else{
				for (var j=0;j<lenpresFormObj ; j++){
					eval("presFormObj.prescriptionSelect"+j).disabled=true;
					if(row_no==i){
					     eval("presFormObj.prescriptionSelect"+j).checked=false;
					}
				}				
			}*/
		}
		else{
			eval("document.RegPrescriptionsDetailsHeader.print"+i).checked =false;
			if (eval("document.RegPrescriptionsDetailsHeader.order_id"+i).value==presFormObj.order_id.value)	{
				for (var j=0;j<lenpresFormObj ; j++){
					if(eval("presFormObj.prescriptionSelect"+j).style.display =='inline') // Added for for 42663
						eval("presFormObj.prescriptionSelect"+j).disabled=true;
					if(row_no==i){
					    eval("presFormObj.prescriptionSelect"+j).checked=false;
						//eval("presFormObj.prescriptionSelect"+j).disabled=true;// commented for 42663
					}
				}
			}
		}
		parent.parent.document.reg_prescriptions_header.reg_prescriptions_header_patient_line.RegPrescriptionsPatientLine.select_all.checked=false;
	}
	if (enableDisableFlag == false){
		regFormObj.btnRegisterPres.disabled=false;
	}
	else{
		regFormObj.btnRegisterPres.disabled=true;
	}
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-PH00208 " + names[i] + getLabel("Common.Cannotbeblank.label","Common") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function validateDate(){
	var formObj = document.RegPrescriptionsQueryCriteria;
	if (formObj.order_date_from.value!="" && formObj.order_date_to.value!=""){
		if(!doDateCheck(formObj.order_date_from,formObj.order_date_to,parent.parent.messageFrame)){
			formObj.order_date_to.select();
		}
		else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result		= _result ;
    message		= _message ;
    flag		= _flag ;
    invalidCode = _invalidCode ;
}

function storeOrderDetails(){
	var formObj = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	var orderLength = 	formObj.querySelector('#regprescriptionsdetailstable').rows.length - 1;
	var order_ids="";
	for (var i=0;i<orderLength ;i++ ){
		if (eval("formObj.select"+i).checked==true){
			order_ids = order_ids+eval("formObj.order_id"+i).value + ":" + "Y,";
		}
		else{
			eval("formObj.print"+i).checked==false;
			order_ids = order_ids+eval("formObj.order_id"+i).value + ":" + "N,";
		}
	}
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storeOrderDetails"+"&order_ids="+order_ids, false ) ;
	xmlHttp.send( xmlDoc ) ;
}

function storePrescriptionDetails(callfrom, order_id){
    if(parent.parent.document.reg_prescriptions_footer_details!=undefined){
	   var formObjBean = parent.parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	   var formObj = parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfooter;
	}
	else{
		 var formObj = parent.f_stage.regprescriptionsdetailfooter;
		 var formObjBean =formObj;
	}
	var presLength = 	parent.parent.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfooter.querySelector('#regprescriptionsdetailfootertable').rows.length - 2;
	 if(parent.parent.document.reg_prescriptions_footer_details!=undefined){
	    var order_id=eval("formObj.order_id").value;
	 }
	 else{
        var order_id=order_id;
	 }
	var prescriptions="";
	var count=0;
	var dis="";//Added Bru-HIMS-CRF-352 [IN:038516]
	for (var i=0;i<presLength ; i++){
		prescriptions = prescriptions + eval("formObj.order_line_num"+i).value+":";
		dis = false;//added for MMS-MD-SCF-0101
		if(eval("formObj.registeredPres"+i)!=null){// added for Bru-HIMS-CRF-352 [IN:038516] Starts
			dis = eval("formObj.registeredPres"+i).disabled;
		}		// added for Bru-HIMS-CRF-352 [IN:038516] Ends
		if (eval("formObj.prescriptionSelect"+i).checked==true && dis==false){	// && dis==false added for Bru-HIMS-CRF-352 [IN:038516]
			prescriptions = prescriptions + "Y:";
		}
		else{
			prescriptions = prescriptions + "N:";
			count=count+1;
		}
	}
	//this code is used for unselecting corresponding order_id if all drugs belong to that order id are unchecked in the below frame
   var orderformobj =parent.parent.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
   var footerButtonObj =parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.regPrescriptionsButtonsFooter;//Niji - CRF 352
	var tot_orders=orderformobj.no_of_orders.value;
	var otherOrders = false;
	if(count==presLength){
        for(i=0;i<tot_orders;i++){
           var order_id_1 =eval("orderformobj.order_id"+i).value;
		   if(order_id !=order_id_1 && eval("orderformobj.select"+i).checked)
			   otherOrders = true;
		   if(order_id==order_id_1){
			   eval("orderformobj.select"+i).checked=false;
			   eval("orderformobj.print"+i).checked=false;
			   if(callfrom=='ONCLICK' && !otherOrders)
				  eval("footerButtonObj.btnRegisterPres").disabled=true;//Niji - CRF 352
		   }
		   else if(callfrom=='ONCLICK' && otherOrders)
			   eval("footerButtonObj.btnRegisterPres").disabled=false;//Niji - CRF 352
		}	
	}
	else{
        for(i=0;i<tot_orders;i++){
			var order_id_1 =eval("orderformobj.order_id"+i).value;
			if(order_id !=order_id_1 && eval("orderformobj.select"+i).checked)
			   otherOrders = true;
			if(order_id==order_id_1 ){
				eval("orderformobj.select"+i).checked=true;
				if(callfrom=='ONCLICK' && !otherOrders)
				   eval("footerButtonObj.btnRegisterPres").disabled=false;//Niji - CRF 352
		   }
		}	
	}
	prescriptions = order_id + ","+prescriptions;

	var bean_id		= formObjBean.bean_id.value ;
	var bean_name	= formObjBean.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=storePrescriptionDetails"+"&prescriptions="+prescriptions, false ) ;
	xmlHttp.send( xmlDoc ) ;
}

function changeLegend(obj) {
	if(obj.value=="B"){
		document.getElementById("frm_legend").innerText=getLabel("ePH.CollectionDateFrom.label","PH");	
	} 
	else if(obj.value=="R"){
		document.getElementById("frm_legend").innerText=getLabel("ePH.RefillStartDate.label","PH");	
	}
	else {
		document.getElementById("frm_legend").innerText=getLabel("Common.Period.label","Common")+" "+	getLabel("Common.from.label","Common");//code 'getLabel("Common.OrderDateFrom.label","Common")' replaced by 'getLabel("Common.Period.label","Common")+" "+	getLabel("Common.DateFrom.label","Common")' for Bru-HIMS-CRF-418[IN045564]   
	}

	if(obj.value=="A" || obj.value=="P"){ //if block added for ML-BRU-SCF-0356[IN034602]
		document.RegPrescriptionsQueryCriteria.ord_loc_type.selectedIndex = 0;
	}
	else if(obj.value=="D"){
		document.RegPrescriptionsQueryCriteria.ord_loc_type.selectedIndex=2; //value changed '1' to '2'  for ML-BRU-SCF-0356[IN034602]
	}
	else{
		document.RegPrescriptionsQueryCriteria.ord_loc_type.selectedIndex=1;//value changed '0' to '1'  for ML-BRU-SCF-0356[IN034602]
	}
}

function defaultorder_status(obj){
	if(obj.value!='' && obj.value!=null) {	 
		parent.parent.f_query_add_mod.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.order_status.selectedIndex=0;
	}
	else{
		parent.parent.f_query_add_mod.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.order_status.selectedIndex=1;
	}
}

async function showTaperDetails(patient_id,order_id,drug_code){
	var dialogTop		= "300";
 	var dialogHeight	= "10" ;
 	var dialogWidth		= "30" ;
	var center			= "1" ;
	var title           = "Tapering Details";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments		= "";
 	await window.showModalDialog("../../ePH/jsp/DisplayTaperDrugDetail.jsp?patient_id="+patient_id+"&order_id="+order_id+"&drug_code="+drug_code,arguments,features);
}

async function showDrugInfo(external_product_id,drug_desc){
	var dialogHeight	= "85" ;
	var dialogWidth	    = "70";
	var dialogTop	= "110";
	var dialogLeft	= "70";
	var center		= "0" ;
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+external_product_id+"&drugdesc="+drug_desc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

async function callIncludeExclude(recnum,drug_code,qty,batch_str,order_id,order_line_no){
	var  patient_id			 =  document.regprescriptionsdetailfooter.patient_id.value;
	var  encounter_id			 =  document.regprescriptionsdetailfooter.bl_encounter_id.value;
	var  sal_trn_type			 =  document.regprescriptionsdetailfooter.bl_patient_class.value;
	var  sysdate				 =  document.regprescriptionsdetailfooter.bl_sysdate.value;
	var  store_code			 =  document.regprescriptionsdetailfooter.disp_locn_code.value;	
	var tot_gross_charge_amount =  document.regprescriptionsdetailfooter.tot_gross_charge_amount.value;
	var tot_groos_pat_payable   =  document.regprescriptionsdetailfooter.tot_groos_pat_payable.value;

	var override_allowed_yn				 = eval("document.regprescriptionsdetailfooter.override_allowed_yn_"+recnum).value;
	var excl_incl_ind						 = eval("document.regprescriptionsdetailfooter.excl_incl_ind_"+recnum).value;
	var approval_reqd_yn					 = eval("document.regprescriptionsdetailfooter.approval_reqd_yn_"+recnum).value;
	var bl_incl_excl_override_reason_desc  = eval("document.regprescriptionsdetailfooter.bl_incl_excl_override_reason_desc_"+recnum).value;
	var bl_incl_excl_override_reason_code  = eval("document.regprescriptionsdetailfooter.bl_incl_excl_override_reason_code_"+recnum).value;
	var excl_incl_ind_default			     = eval("document.regprescriptionsdetailfooter.excl_incl_ind_default_"+recnum).value;
	var old_gross_charge_amount            = eval("document.regprescriptionsdetailfooter.gross_charge_amount_"+recnum).value;
	var old_groos_pat_payable              = eval("document.regprescriptionsdetailfooter.groos_pat_payable_"+recnum).value;
	// override_allowed_yn="Y";
	var dialogHeight	= "26vh" ;
	var dialogWidth	    = "75vw";
	var dialogTop	    = "30" ;
	var dialogLeft	    = "30" ;
	var center			= "0" ;
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await top.window.showModalDialog("../../ePH/jsp/BillingIncludeExclude.jsp?override_allowed_yn="+override_allowed_yn+"&excl_incl_ind="+excl_incl_ind+"&approval_reqd_yn="+approval_reqd_yn+"&bl_incl_excl_override_reason_desc="+encodeURIComponent(bl_incl_excl_override_reason_desc)+"&bl_incl_excl_override_reason_code="+bl_incl_excl_override_reason_code+"&recnum="+recnum+"&excl_incl_ind_default="+excl_incl_ind_default+"&order_id="+order_id+"&order_line_no="+order_line_no ,arguments,features);
	/*if(retVal!=undefined && retVal!="") {
		var billing_vals	=	retVal.split("::");

		var excl_incl_ind					 =billing_vals[1];
		var bl_incl_excl_override_reason_code =billing_vals[2];
		var bl_incl_excl_override_reason_desc =billing_vals[3];

		eval("document.regprescriptionsdetailfooter.excl_incl_ind_"+recnum).value					 = excl_incl_ind;
		eval("document.regprescriptionsdetailfooter.bl_incl_excl_override_reason_code_"+recnum).value = bl_incl_excl_override_reason_code;
		eval("document.regprescriptionsdetailfooter.bl_incl_excl_override_reason_desc_"+recnum).value = bl_incl_excl_override_reason_desc;
		   
		if(excl_incl_ind!=''){
			var xmlStr ="<root><SEARCH ";	
			xmlStr+= "order_id=\"" + order_id + "\" " ;
			xmlStr+= "order_line_no=\"" + order_line_no + "\" " ;
			xmlStr+= "Srl_no=\"" + recnum + "\" " ;	
			xmlStr+= "drug_code=\"" + drug_code + "\" " ;	
			xmlStr+= "excl_incl_ind=\"" + excl_incl_ind + "\" " ;	
			xmlStr+= "bl_incl_excl_override_reason_code=\"" + bl_incl_excl_override_reason_code + "\" " ;	
			xmlStr+= "bl_incl_excl_override_reason_desc=\"" + encodeURIComponent(bl_incl_excl_override_reason_desc) + "\" " ;
			xmlStr+= "tot_alloc_qty=\"" + qty + "\" " ;
			xmlStr+= "patient_id=\"" + patient_id + "\" " ;
			xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
			xmlStr+= "sal_trn_type=\"" + sal_trn_type + "\" " ;
			xmlStr+= "sysdate=\"" + sysdate + "\" " ;
			xmlStr+= "store_code=\"" + store_code + "\" " ;
			xmlStr+= "batch_str=\"" + batch_str + "\" " ;
			xmlStr+= "tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\" " ;
			xmlStr+= "tot_groos_pat_payable=\""   + tot_groos_pat_payable + "\" " ;
			xmlStr+= "old_gross_charge_amount=\"" + old_gross_charge_amount + "\" " ;
			xmlStr+= "old_groos_pat_payable=\""   + old_groos_pat_payable + "\" " ;
			//xmlStr+= "called_from=\"" + called_from +"\" ";
			xmlStr +=" /></root>";	
			
			  var bean_id  = document.regprescriptionsdetailfooter.bean_id.value;
			  var bean_name= document.regprescriptionsdetailfooter.bean_name.value;
			
			var  temp_jsp="RegPrescriptionsValidate.jsp?identity=StoreBillingDetails&bean_id="+bean_id+"&bean_name="+bean_name;


			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
	   }
	}*/
}

function setBillingAmounts(srl_no,gross_charge_amount,groos_pat_payable,tot_gross_charge_amount,tot_groos_pat_payable){
	eval(document.getElementById("gross_charge_amount_"+srl_no)).value=gross_charge_amount;
    eval(document.getElementById("groos_pat_payable_"+srl_no)).value=groos_pat_payable;	
	//alert("==srl_no===="+srl_no+"==gross_charge_amount===="+gross_charge_amount+"===="+document.regprescriptionsdetailfooter.gross_charge_amount_str_0.id);
	//alert(eval("document.getElementById("gross_charge_amount_str_")"+srl_no+".id") +"==gross_charge_amount===="+gross_charge_amount  );
	eval(document.getElementById("gross_charge_amount_str_"+srl_no)).innerHTML	="<label style='font-size:9px'>"+gross_charge_amount+"</label>";
    eval(document.getElementById("groos_pat_payable_str_"+srl_no)).innerHTML	="<label style='font-size:9px;'>"+groos_pat_payable+"</label>";

	var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
	var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
	
	parent.reg_prescriptions_footer_details2.document.getElementById("total_payable").innerHTML	="<label >"+total_payable+"      :"+tot_gross_charge_amount+"</label>";
    parent.reg_prescriptions_footer_details2.document.getElementById("patient_payable").innerHTML	="<label >"+patient_payable+"       :"+tot_groos_pat_payable+"</label>";
}
async function searchCode(target){
	var formObj= document.RegPrescriptionsQueryCriteria;
	var ord_loc_type = formObj.ord_loc_type.value;
	var language_id  = formObj.Language_id.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = formObj.facility_id.value;
	dataTypeArray[0]   = STRING ;
	if(ord_loc_type=='C'){
		  argumentArray[0]   = formObj.SQL_PH_ALT_DISP_LOCN_SELECT1E.value+"'"+language_id+"'";
	}
	else if(ord_loc_type=='N'){//if(ord_loc_type=='N') added for  ML-BRU-SCF-0356[IN034602]
		  argumentArray[0]   = formObj.SQL_PH_ALT_DISP_LOCN_SELECT1D.value+"'"+language_id+"'";
	}
	else // else part added for  ML-BRU-SCF-0356[IN034602]
		argumentArray[0]   = formObj.SQL_PH_REG_PRES_ALL_SOURCE_SELECT.value+"'"+language_id+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("Common.OrderingLocation.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.ord_locn_code.value = arr[0] ;
		target.value = arr[1] ;
	}	
}

function clearvalues(obj1,obj2){
	obj1.value ="";
	obj2.value="";
}

async function showImage(drug_code, trade_code){
	var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	if(trade_code == undefined)
		trade_code="";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?drug_code="+drug_code+"&trade_code="+trade_code,arguments,features);
}

function blinkText(name,textId,timeA,timeB,colourA,colourB){/* (C)2002 S Chalmers */
	if(document.getElementById){
		this.isEnabled=true;
		this.textId=document.getElementById(textId);
		this.name=name;
		this.timeA=timeA;
		this.timeB=timeB;
		this.colourA=colourA;
		this.colourB=colourB; 
		this.state=0;
		this.timer=null;
		setTimeout(this.name+'.tBlink()',10);
	}
}

blinkText.prototype.tBlink=function(){
	if(this.isEnabled)
	{
		this.textId.style.color = (this.state^=1) ? this.colourA : this.colourB;
		this.timer=setTimeout(this.name+".tBlink()", this.state ? this.timeA : this.timeB );
		}
	
}

blinkText.prototype.stopBlink=function(){
	this.isEnabled=false;
}

blinkText.prototype.startBlink=function(){
	if(this.isEnabled==false){
		this.isEnabled=true;
		this.tBlink();
	}
}

blinkText.prototype.toggleBlink=function(){
	if(this.isEnabled^=true);
	this.tBlink();
}

async function showPendingOrders(patient_id,disp_locn_code){
	var dialogHeight	= "300px" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "72" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await window.showModalDialog( "../../ePH/jsp/PendingMedicationOrderStatusOrderDetails.jsp?patient_id="+patient_id+"&disp_locn_code="+disp_locn_code+"&called_from=Dispensing", arguments, features );
	if(retVal=='NO_RECORD_FOUND_FOR_CRITERIA')
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

async function showDrug(drug_code){
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "11" ;
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/ViewDrugInfo.jsp?DrugCode="+drug_code,arguments,features);
}

function setvalues(obj){
	var formObjOrders = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	var regFormObj	=	parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.regPrescriptionsButtonsFooter;
	var indiDrugFrame	=	parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details1.regprescriptionsdetailfooter;// added for Bru-HIMS-CRF-352 [IN:038516]
	var length		   = formObjOrders.querySelector('#regprescriptionsdetailstable').rows.length-1;	
	var lengthDrugs		   = indiDrugFrame.querySelector('#regprescriptionsdetailfootertable').rows.length-2;	
	if(obj.checked==true){
		for (var i=0;i<length ; i++){
			eval("formObjOrders.select"+i).checked =true;
			regFormObj.btnRegisterPres.disabled=false;
		}
		for (var i=0;i<lengthDrugs ; i++){
			eval("indiDrugFrame.prescriptionSelect"+i).checked =true;
		}
	}
	else{
		for (var i=0;i<length ; i++){
			eval("formObjOrders.select"+i).checked =false;
			regFormObj.btnRegisterPres.disabled=true;
		}
		for (var i=0;i<lengthDrugs ; i++){
			eval("indiDrugFrame.prescriptionSelect"+i).checked =false;
		}
	}
	var selOrder_id = formObjOrders
	storeOrderDetails();
}

function assigndischargeIND(dischargeIND){
	var formObjOrders  = parent.document.reg_prescriptions_header_details.RegPrescriptionsDetailsHeader;
	formObjOrders.dischargeIND.value=dischargeIND; 
}
//the below method is  added  for Bru-HIMS-CRF-090 [IN:029956]
async function reRoutePrescription(){
	var patient_id = document.RegPrescriptionsQueryCriteria.patient_id.value;
	var disp_locn_code = document.RegPrescriptionsQueryCriteria.disp_locn_code.value;
	var dialogHeight= "95vh" ;
	var dialogWidth	= "95vw" ;
	var dialogTop = "10" ;
	var dialogLeft = "10" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
	var re_route_via_reg_ord="Y";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await  top.window.showModalDialog("../../ePH/jsp/ReRoutePrescription.jsp?menu_id=PH&module_id=PH&function_id=PH_REROUTE_ORDER&function_name=Re-route Prescription&function_type=F&access=NYNNN&desktopFlag=N&re_route_via_reg_ord=Y"+"&patient_id="+patient_id+"&disp_locn_code="+disp_locn_code ,arguments,features);
	autoCallReRoute_yn = document.RegPrescriptionsQueryCriteria.autoCallReRoute_yn.value;
	if(retVal=='Y' && autoCallReRoute_yn =='Y'){ //&& patient_id!="" removed for HAS-CRF-0166
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?";	
		document.RegPrescriptionsQueryCriteria.btnRefresh.click();
	}
	else if(retVal!='Y' && autoCallReRoute_yn =='Y'){
		document.RegPrescriptionsQueryCriteria.callFrom.value = "";
	}
}

// the below method is used for leap year calculation IN[031575]
function CheckDateT(obj){

	var locale=document.RegPrescriptionsQueryCriteria.p_language_id.value;
	//var locale="en";
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
		/*	obj.select();
			obj.focus();*/
			obj.value="";
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
function CheckDateN(obj){

	var locale=parent.parent.content.f_query_add_mod.reg_prescriptions_query.document.RegPrescriptionsQueryCriteria.p_language_id.value;
	//var locale="en";
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
		/*	obj.select();
			obj.focus();*/
			obj.value="";
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
//added for [IN:036157] -start
async function showDrugProfile(patient_id,disp_locn_code,pat_class){
	var dialogHeight	= "85vh";//"36" ;
	var dialogWidth		= "90vw";//"60" ;
	var dialogTop		= "10";//"152" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center:" + center +"; status:" + status + "; dialogTop:" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+patient_id+"&called_frm=Prescription&disp_locn_code="+disp_locn_code+"&pat_class="+pat_class, arguments, features );
/*	if(retVal=="Dispense"){
		parent.parent.parent.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.click();
	}*/
}

// added for Bru-HIMS-CRF-076 [IN029942] -start
function getQMSToken(){
	var formObj=document.regprescriptionsissuetokenfooter;
	if(formObj.QMS_gen_token.style.disabled == true)
		return false;
	var  patient_id			 =  formObj.patient_id.value;
	var  encounter_id			 =  formObj.encounter_id.value;
    var disp_locn_code	= formObj.disp_locn_code.value;
	var token_series_code = formObj.hidden_token_series_code.value;

    var bean_id			= formObj.bean_id.value ;
	var bean_name		= formObj.bean_name.value ;
	var xmlDoc			= "";
	var xmlHttp			= new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;	
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;	
   	xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
	xmlStr+= "token_series_code =\"" + token_series_code + "\" " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=GENQMSTOEKN", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function assignQMSResult(QMSstatus, QMStiket, QMSerrors){
	if(QMSstatus=='0'){
		document.regprescriptionsissuetokenfooter.token_no.value = QMStiket;
		document.regprescriptionsissuetokenfooter.QMS_gen_token.style.disabled = true;
		document.regprescriptionsissuetokenfooter.token_series_code_for_patient.style.disabled = true;
	}
	else if(QMSstatus =='1'){
		document.regprescriptionsissuetokenfooter.QMS_gen_token.style.disabled = false;
		document.regprescriptionsissuetokenfooter.token_series_code_for_patient.style.disabled = false;
		var msg = getMessage("PH_QMS_ERROR_REGISTER","PH") ;
		alert(msg+"\n"+QMSerrors);
	}
}
// added for Bru-HIMS-CRF-076 [IN029942] - end
//Added for Bru-HIMS-CRF-142 [IN:030195] - start

function ChkPatArrival(){
	var formobj=document.regprescriptionsissuetokenfooter;
	if(formobj.patient_arrived.checked){
		formobj.patient_arrived.value="Y";
	}
	if(formobj.patient_arrived.checked==false){
		formobj.patient_arrived.value="N";
	}
	if(formobj.patient_arrived.value=="N" && formobj.generate_actual_token_yn.value=="N"){
		document.getElementById("gen_token").style.display="none"; 
		formobj.token_no.value="";
	}
	else{
		if(formobj.gen_token_yn.value=='N'){
			document.getElementById("gen_token").style.display="display";
		}
		else{
			document.getElementById("gen_token").style.display="none";  
			formobj.token_no.value="";
		}
	}
}

async function onPatArrived(msgid){
	if(msgid=="RECORD_UPDATED"){
		if(parent.document.frameRegPresMarkPatArrvQryCriteria!=undefined){
			var formobj=parent.document.frameRegPresMarkPatArrvQryCriteria.MarkPatArrivalQryCriteriaForm;
		}
		if(parent.document.frameRegPresMarkPatArrvQryResult!=undefined){
			var formobj1=parent.document.frameRegPresMarkPatArrvQryResult.MarkPatArrivalQryResultForm;
		}
		if(parent.document.frameRegPresMarkPatArrvFooter!=undefined){
			var formobj2=parent.document.frameRegPresMarkPatArrvFooter.MarkPatArrivalFooter;
		}
		var disp_locn_code=formobj2.disp_locn_code.value;
		var patient_id=formobj1.patient_id.value;
		var patient_name=formobj.patient_name.value;
		var gender=formobj.gender.value;
		var age=formobj.age.value;
		var nationality=formobj.nationality.value;
		var nationality_code=formobj.nationality_code.value;
		var recsize=formobj1.recsize.value;
		var dialogHeight= "32vh";
		var dialogWidth	= "32vw" ;
		var dialogTop = "0vh" ;
		var center = "2" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retVal =await
		await top.window.showModalDialog("../../ePH/jsp/RegPresMarkPatArrvIssueToken.jsp?disp_locn_code="+disp_locn_code+"&patient_id="+patient_id+"&patient_name="+unescape(patient_name)+"&gender="+gender+"&nationality="+nationality+"&nationality_code="+nationality_code+"&len="+recsize,arguments,features);
		window.close();
	}
}

async function callWindow(obj){
	var dialogHeight			= "90vh";
	var dialogWidth				= "70vw";
	var dialogTop				= "100";
	var dialogLeft				= "200";
	var center					= "1";
	var status					= "no";
	var scrolling               = "yes";
	var patient_id			= parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.patient_id.value;
	var disp_locn_code	=parent.parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.disp_locn_code.value;
	var flag						=obj;
	var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling; 
	var arguments               = "";
	retVal =await top.window.showModalDialog("../../ePH/jsp/RegPresMarkPatArrvFrame.jsp?patient_id="+patient_id+"&flag="+flag+"&disp_locn_code="+disp_locn_code,arguments, features);
	return retVal;
}

// After generating dummy token no, assign it to a global variable
function dummytoken(obj){
	global_dummy_token_no=obj;
}

//This functions selects all the pending orders for patient arrival
function selectall(){
	document.MarkPatArrivalHeader.select_box.checked=true;
	document.MarkPatArrivalHeader.select_box.value="Y";
}

//below function added for Bru_HIMS-CRF-142(30195)
function callSearchPage(){
	var formObj = document.MarkPatArrivalQryCriteriaForm;
	var patient_id = formObj.patient_id.value;
	var order_date_from = formObj.order_date_from.value;
	var order_date_to = formObj.order_date_to.value;
	var token_no = formObj.token_no.value;
	var dispense_locn = formObj.dispense_locn.value;
	parent.frameRegPresMarkPatArrvHeader.location.href="../../ePH/jsp/RegPresMarkPatArrvHeader.jsp?patient_id="+patient_id+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&token_no="+token_no+"&dispense_locn="+dispense_locn;
	parent.frameRegPresMarkPatArrvQryResult.location.href="../../ePH/jsp/RegPresMarkPatArrvQryResult.jsp?patient_id="+patient_id+"&order_date_from="+order_date_from+"&order_date_to="+order_date_to+"&token_no="+token_no+"&dispense_locn="+dispense_locn;
}

// This function will check if dispense locations are the same and will uncheck and disabled records with different dispense locations
function chkdispense(){
	var formobj=document.MarkPatArrivalQryResultForm;
	var recsize=document.MarkPatArrivalQryResultForm.recsize.value;
	var dispense_locn=document.MarkPatArrivalQryResultForm.dispense_locn.value;
	var disp_locn="";
	for(var i=0;i<recsize;i++){
		disp_locn=eval('formobj.disp_locn_code_'+i).value;
		if(disp_locn!=dispense_locn){
			eval('formobj.check_'+i).value="N";
			eval('formobj.check_'+i).checked=false;
			eval('formobj.check_'+i).disabled=true;
		}	
	}
}

//Assign value to check boxes
function assignValue(obj){
	if(obj.checked==true){
		obj.value = "Y";
	}
	else{
		obj.value = "N";
	}
}

//This function is called on click of Patient Arrival button
function MarkPatArrival(obj){
	var xmlresult = "";
	var formobj=parent.document.frameRegPresMarkPatArrvQryResult.MarkPatArrivalQryResultForm;
	var sysdate=obj.sysdate.value;
	var patient_id=formobj.patient_id.value;
	var bean_id=formobj.bean_id.value;
	var bean_name=formobj.bean_name.value;
	var drug_name = "";
	var disp_locn	= "";
	var storage_locn="";
	var order_status="";
	var token_status="";
	var token_serial_no="";
	var queue_date="";
	var order_id="";
	var order_line_num="";
	var order_catalog_code="";
	var token_series_code="";
	var check	=	"";
	var pat_mode="";
	var disp_locn_code="";
	var chktoproceed = "1";
	var xmlString ="<root><SEARCH  /></root>" ;

	var recsize=formobj.recsize.value;
	var xmlStr ="<root><SEARCH ";
	for(var i=0;i<recsize;i++){
		if(parent.frameRegPresMarkPatArrvQryResult.document.getElementById('check_'+i).checked){
			
			drug_name=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('drug_name_'+i);
			disp_locn=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('disp_locn_'+i);
			storage_locn=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('storage_locn_'+i);
			order_status=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('order_status_'+i);
			token_status=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('token_status_'+i);
			token_series_code=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('token_series_code_'+i);
			token_serial_no=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('token_serial_no_'+i);
			queue_date=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('queue_date_'+i);
			pat_mode=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('pat_mode_'+i);
			order_id=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('order_id_'+i);
			order_line_num=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('order_line_num_'+i);
			order_catalog_code=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('order_catalog_code_'+i);
			disp_locn_code=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('disp_locn_code_'+i);
			check=parent.frameRegPresMarkPatArrvQryResult.document.getElementById('check_'+i);
			if(queue_date.value==sysdate.substr(0,10)){
			pat_mode.value="P";}else{
			pat_mode.value="U";}
			xmlStr += drug_name.id+"=\""+ escape(drug_name.innerText) +"\" " ;
			xmlStr += disp_locn.id+"=\""+ escape(disp_locn.innerText) +"\" " ;
			xmlStr += storage_locn.id+"=\""+ escape(storage_locn.innerText) +"\" " ;
			xmlStr += order_status.id+"=\""+ escape(order_status.innerText) +"\" " ;
			xmlStr += token_status.id+"=\""+ escape(token_status.innerText) +"\" " ;
			xmlStr += token_series_code.id+"=\""+ escape(token_series_code.value) +"\" " ;
			xmlStr += token_serial_no.id+"=\""+ escape(token_serial_no.value) +"\" " ;
			xmlStr += queue_date.id+"=\""+ escape(queue_date.value) +"\" " ;
			xmlStr += order_id.id+"=\""+ escape(order_id.value) +"\" " ;
			xmlStr += order_line_num.id+"=\""+ escape(order_line_num.value) +"\" " ;
			xmlStr += order_catalog_code.id+"=\""+ escape(order_catalog_code.value) +"\" " ;
			xmlStr += disp_locn_code.id+"=\""+ escape(disp_locn_code.value) +"\" " ;
			xmlStr += check.id+"=\""+ escape(check.value) +"\" " ;
			xmlStr += pat_mode.id+"=\""+ escape(pat_mode.value) +"\" " ;
		}
	}
	xmlStr +=" /></root>";
	if(xmlStr==xmlString) {
		alert("APP-PH0003 Atleast one record should be selected");
		chktoproceed = "2";
	}
	if(chktoproceed=="1"){
		var temp_jsp="RegPrescriptionsValidate.jsp?identity=storevalues&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&len="+recsize;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlresult = xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
	responseText =	xmlHttp.responseText;
	eval(responseText);
	}
}

//below function added for Bru_HIMS-CRF-142(30195)
function generateTokenonPatArrival(){
	var formObj = document.regprescriptionsissuetokenfooter ;
	if (formObj.token_series_code.display=="inline" && formObj.token_series_code.value==""){
		window.close();
		return false;
	}
	else{
		if (formObj.pat_coll_med.checked==false){
			var fields = "";
			var names  = "";
			if(formObj.gen_token_yn.value==null||formObj.gen_token_yn.value=='Y'){
				fields = new Array (formObj.med_pat_name,formObj.med_pat_gender,formObj.med_pat_nationality);
				names = new Array ( getLabel("Common.name.label","Common") ,getLabel("Common.gender.label","Common"),getLabel("Common.nationality.label","Common")); 
			}
			else if(formObj.gen_token_yn.value=='N'){
				fields = new Array (formObj.med_pat_name,formObj.med_pat_gender,formObj.med_pat_nationality,formObj.token_no);
				names =  new Array ( getLabel("Common.name.label","Common") ,getLabel("Common.gender.label","Common"),getLabel("Common.Nationality.label","Common"),getLabel("ePH.TokenNo.label","PH"));
			}
			if(checkFlds( fields, names)) {
				var disp_locn_code	= formObj.disp_locn_code.value;
				var patient_id	= formObj.patient_id.value;
				var bean_id			= formObj.bean_id.value ;
				var bean_name		= formObj.bean_name.value ;
				var token_series	=	formObj.hidden_token_series_code.value;
				var len	=	formObj.len.value;
				var token_serial_no="";
				var xmlDoc			="";
				var xmlHttp			= new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
				xmlStr+= "patient_id =\"" + patient_id + "\" " ;	
				xmlStr+= "token_series =\"" + token_series + "\" " ;	
				if(formObj.querySelector('#gen_token').style.display=="inline"){
					token_serial_no=formObj.token_no.value;
				}
				xmlStr+= "token_serial_no =\"" + token_serial_no + "\" " ;	
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=GenTokenonPatArrv", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				if(global_success_msg==getMessage("RECORD_MODIFIED", "PH")){
					result=true;
					alert(getMessage("RECORD_MODIFIED", "PH"));
					flag=global_token_no;
				}
				if( result ) {
					if(document.regprescriptionsissuetokenfooter.print_token_series.checked){
						callPrintDialog(document.regprescriptionsissuetokenfooter);
					}
				}
				var msg="";
				if( result ){                 
					alert(message+"\n"+"Token No: "+global_token_no);
					window.close();
				}
				else{
					msg=message; 
					alert(message);
				}		 
			}
		}
		else{
			var formObj = document.regprescriptionsissuetokenfooter;
			if (formObj.token_series_code_for_patient.value==""){
				alert(getMessage("TOKEN_SERIES_CANNOT_BLANK","PH"));
				window.close();
				return false;
			}
			if(formObj.gen_token_yn.value=='N'  && formObj.querySelector('#gen_token').display=='display'){
				if(formObj.token_no.value==""){
					alert(getMessage("TOKEN_CANNOT_BLANK","PH"));
					return false;
				}
			}
			if((formObj.gen_token_yn.value=='N'&&formObj.token_no.value!="")||(formObj.gen_token_yn.value=='Y')){
				var disp_locn_code	= formObj.disp_locn_code.value;
				var patient_id	= formObj.patient_id.value;
				var bean_id			= formObj.bean_id.value ;
				var bean_name		= formObj.bean_name.value ;
				var token_series	=	formObj.hidden_token_series_code.value;
				var len	=	formObj.len.value;
				var token_serial_no="";
				var xmlDoc			= " ";
				var xmlHttp			= new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
				xmlStr+= "patient_id =\"" + patient_id + "\" " ;	
				xmlStr+= "token_series =\"" + token_series + "\" " ;	
				if(formObj.querySelector('#gen_token').style.display=="display"){
					token_serial_no=formObj.token_no.value;
				}
				xmlStr+= "token_serial_no =\"" + token_serial_no + "\" " ;	
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=GenTokenonPatArrv", false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
				if(global_success_msg==getMessage("RECORD_MODIFIED", "PH")){
					result=true;
					message=getMessage("RECORD_MODIFIED", "PH");
					flag=global_token_no;
				}
				if( result ) {
					if(document.regprescriptionsissuetokenfooter.print_token_series.checked){
						callPrintDialog(document.regprescriptionsissuetokenfooter);
					}
				}
				var msg="";
				if( result ){
					alert(message+"\n"+"Token No: "+global_token_no);
					window.close();
				}
				else{
					msg=message; 
					alert(message);
				}
			}
		}	
	}
}

function displaygeneratedtoken(obj,obj1){
	global_success_msg=obj;
	global_token_no=obj1;
}

// This function checks all records by default
function toggleCheck(formObject){
	var allElements=	parent.document.frameRegPresMarkPatArrvQryResult.MarkPatArrivalQryResultForm.elements;
	var ischecked=formObject.select_box.checked;
	for (i=0; i<allElements.length; i++) {
		if (allElements[i].type=="checkbox"){
			if (allElements[i].checked!=ischecked) {
				allElements[i].click();
				if(allElements[i].checked){
					allElements[i].value="Y";
				}
				else{
					allElements[i].value="N";
				}
			}
		}
	}
}

//This function is called on click of clear method
function callClear(){
	parent.frameRegPresMarkPatArrvHeader.location.href="../../eCommon/html/blank.html";
	parent.frameRegPresMarkPatArrvQryResult.location.href="../../eCommon/html/blank.html";
}

function validate_date(Obj,ref) {
	var formObj = document.MarkPatArrivalQryCriteriaForm;
	var calendarIconFrom = document.getElementById('CalendarFrom'); // Calendar icon element
	var calendarIconTo = document.getElementById('CalendarTo'); // Calendar icon element
	if(formObj.order_date_from.value==''){ 
		var errors=getMessage('PH_ORD_DATE_FM_TO_NOT_BLANK','PH');
		alert(errors);
		formObj.order_date_from.value='';
		setTimeout(function() { // Use setTimeout to delay focus
			//formObj.order_date_from.focus();
			calendarIconFrom.click();
			
		},100);
		//formObj.order_date_from.focus();
		return false;
	}
	else if( formObj.order_date_to.value==''){
		var errors=getMessage('PH_ORD_DATE_FM_TO_NOT_BLANK','PH');
		alert(errors);
		formObj.order_date_to.value='';
		setTimeout(function() { // Use setTimeout to delay focus
			//formObj.order_date_from.focus();
			calendarIconTo.click();
			
		},100);		
		return false;
	}	
	return true;
}//Added for Bru-HIMS-CRF-142 [IN:030195] - End


function displayPayeeIndicator(display_yn){ //function added for Bru-HIMS-CRF-094 [IN:029959]
	var lblpayingPatient = parent.parent.reg_prescriptions_header_patient_line.document.getElementById("payingPatient");
	if(display_yn=='Y')
		lblpayingPatient.style.display='inline';
	else
		lblpayingPatient.style.display='none';
}

function checkChargeDetailsForOtherOrders(){
	var footrFormDtl =  parent.reg_prescriptions_footer_details1.document.regprescriptionsdetailfooter;
	var  patient_id			 =  footrFormDtl.patient_id.value;
	var  encounter_id			 =  footrFormDtl.bl_encounter_id.value;
	var bean_id			= footrFormDtl.bean_id.value ;
	var bean_name		= footrFormDtl.bean_name.value ;
	//var xmlDoc			= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	//var xmlHttp			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlStr	="<root><SEARCH " ;
	xmlStr+= "patient_id =\"" + patient_id + "\" " ;	
	xmlStr+= "encounter_id =\"" + encounter_id + "\" " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RegPrescriptionsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&identity=checkChargeDetailsForOtherOrders", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
// Added for ML-BRU-SCF-0987 [IN:042737]
function checkDispExpOrders(obj,dispExpOrders_yn){
	if(obj.value=='E' && dispExpOrders_yn=='N'){
		alert(getMessage("PH_DISP_EXP_ORDER", "PH"));
		parent.reg_prescriptions_query.RegPrescriptionsQueryCriteria.order_status.value = "A";
	}
}

function callFinancialDetailScreen(patient_id,episodeid, visitid)
{ //code added for JD-CRF-0156[IN041737] --Start
	ViewBLDtl(episodeid,visitid,patient_id);
	/*var visitid ="";
	var retVal       =  new String();
	var episode1     ="";
	var dialogTop    = "200";
	var dialogHeight = "42" ; 
	var dialogWidth  = "70" ; 
	var features     = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments    = "" ;
	var search_desc  =""; 
	var title   =getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	var column_sizes = escape("");               
	var column_descriptions ="";       
	var param =            "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episodeid="+	episodeid+"&visitid="+visitid+"&patientid="+patient_id+"&episode1="+episodeid;
	if(episodeid!="" && patient_id!=""){
		retVal=window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);
	}*/
}  //code added for JD-CRF-0156[IN041737] -- End

