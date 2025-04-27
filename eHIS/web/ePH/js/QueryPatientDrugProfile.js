 //saved on 29/10/2005    
  /*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
22/07/2020		IN:073286	        Manickavasagam J			     SKR-SCF-1370
25/05/2022		31686				Pranay					25/05/2022		Ramesh G				NMC-JD-SCF-0287
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/    
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?called_frm= ";
}

function reset(){

	var formObj = document.f_query_add_mod.f_query_criteria.queryPatientDrugProfileCriteria;
	formObj.patient_id.disabled = false;
	formObj.patient_search.disabled = false;
	formObj.generic_name.disabled  = false;
	formObj.generic_name_search.disabled = false;
	formObj.drug_name.disabled  = false;
	formObj.drug_name_search.disabled = false;
	formObj.reset();
	document.f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
	document.f_query_add_mod.f_query_status.location.href="../../eCommon/html/blank.html";
}

// This will call common patient search
async function callPatientSearchQ(){
	var formObj = document.queryPatientDrugProfileCriteria;
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		formObj.patient_search.disabled = true;
	} 
}

// lookup for Generic Name 
async function searchGenericName(){ 

	var formObj = document.queryPatientDrugProfileCriteria;
								
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

//var id=formObj.locale.value;
	
	var language_id=document.queryPatientDrugProfileCriteria.locale.value;

	argumentArray[0]   = document.queryPatientDrugProfileCriteria.sql_ph_drug_search_select1.value+"'"+language_id+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	
	/*argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[0]   = formObj.sql_ph_drug_search_select1.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	*/
   	argumentArray[5]   = formObj.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal=await CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "" )  {
		formObj.generic_name.value = arr[1] ;
		formObj.generic_id.value = arr[0];
	/*	formObj.generic_name.disabled  = true;
		formObj.generic_name_search.disabled = true;*/
	   	formObj.drug_name.value = "" ;
		formObj.drug_code.value = "" ;
		formObj.drug_name.disabled  = false;
		formObj.drug_name_search.disabled = false;
	}
}

// lookup for Drug Name
async function searchDrugName(){
	var formObj = document.queryPatientDrugProfileCriteria;
	var type= 'D';
	if(formObj.ItemType[1].checked==true)
		type='M';
	var tpn_val;
    if(formObj.tpnCkBox.checked == true && type == 'D'){
	    tpn_val    =  'Y';
	}
	else{
		tpn_val='N';
	}
	if(tpn_val == 'Y'){
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var language_id=document.queryPatientDrugProfileCriteria.locale.value;
		argumentArray[0]   = document.queryPatientDrugProfileCriteria.sql_ph_tpn_drug_search_select.value+"'"+language_id+"'";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		
		argumentArray[5]   = formObj.drug_name.value  ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ; 
		retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	 } 
	else { 
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		var language_id=document.queryPatientDrugProfileCriteria.locale.value;
		if(type=='D')
			argumentArray[0]   = document.queryPatientDrugProfileCriteria.sql_ph_drug_search_select2.value+"'"+language_id+"'";
		else
			argumentArray[0]   = document.queryPatientDrugProfileCriteria.sql_ph_medicalitem_search_select.value+"'"+language_id+"'";

		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.drug_name.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ; 
		retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
   }
	var ret1=unescape(retVal);
	var arr=ret1.split(",");   
	if(retVal != null && retVal != "" )  {
		formObj.drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		/*formObj.drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;
		formObj.generic_name.disabled  = true;
		formObj.generic_name_search.disabled = true;*/
		formObj.generic_name.value = "";
		formObj.generic_id.value = "";
	}
}

function validateDate(){
	var formObj = document.queryPatientDrugProfileCriteria;
	if (formObj.dt_from.value!="" && formObj.dt_to.value!=""){
		if(!doDateCheck(formObj.dt_from,formObj.dt_to,parent.parent.messageFrame)){
			formObj.dt_to.select();
			return false;
		}
		else{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function callResultPage(called_frm,mode, click_yn,encounter_id,ReqDb,enc_id1,called_from){  // encounter_id added for AAKH-CRF-0088.2//ReqDb,enc_id1,called_from added for MMS-DM-CRF-115.4
	 if(mode==null||mode=="null"){
		 mode="";
	 }
	 if(encounter_id == null || encounter_id == "null" || encounter_id=="undefined" || encounter_id==undefined ){ // Added for AAKH-CRF-0088.2
		 encounter_id="";
	 }
	var formObj	=	document.queryPatientDrugProfileCriteria;
	if (formObj.dt_from.value!="" && formObj.dt_to.value!=""){
		if(!doDateCheck(formObj.dt_from,formObj.dt_to,parent.parent.messageFrame)){
			formObj.dt_to.select();
			return false;
		}
	}

	if (formObj.drug_name.value == ''){		
		formObj.drug_code.value = '';
	}
	if (formObj.generic_name.value == ''){		
		formObj.generic_id.value ='';
	}	
	var patient_id	=	formObj.patient_id.value;
	var locale				=	formObj.locale.value;
	var dt_from				=	convertDate(formObj.dt_from.value,'DMY',locale,"en"); 
	var dt_to				=	convertDate(formObj.dt_to.value,'DMY',locale,"en");
	var generic_id	=	formObj.generic_id.value;
	var drug_code	=	formObj.drug_code.value;
	var pat_class	=	formObj.pat_class.value;
	var status		=	formObj.status.value;
	var disp_locn_code		=	formObj.disp_locn_code.value;	
	var tpn_val;
	
	if(formObj.tpnCkBox.checked){
	    tpn_val    =  'Y';
	}
	else{
		 tpn_val='N';
	}
	var type ='D';
	if(formObj.ItemType[1].checked == true)
		type = 'M';

	var fields = new Array ( formObj.patient_id );
	var names= new Array (getLabel("Common.patientId.label","Common")); 
	if(called_frm=="Dispense" || called_frm=="DispenseMax" || called_from == 'CDR') { 
		parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileResultFrame.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&called_frm="+called_frm+"&disp_locn_code="+disp_locn_code+"&tpn_val="+tpn_val+"&mode="+mode+"&click_yn="+click_yn+"&type="+type+"&encounter_id="+encounter_id+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from; // encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	}
	else if(called_frm=="Prescription"){
		parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileResultFrame.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&called_frm="+called_frm+"&disp_locn_code="+disp_locn_code+"&tpn_val="+tpn_val+"&mode="+mode+"&type="+type+"&encounter_id="+encounter_id+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from; // encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	}
	else {
		if(parent.checkFields( fields, names, parent.parent.messageFrame)){
			if (pat_class.trim() === "---Select---")
			{
				pat_class="";
			}
			//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";  //Commentted for 31686
			parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileResultFrame.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&called_frm=QUERY"+"&tpn_val="+tpn_val+"&mode="+mode+"&type="+type+"&encounter_id="+encounter_id+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from; // encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
		}
	}
}

async function showRemarks(order_id,order_line_num,sr_no,line_status,split_dose_yn,sliding_scale_yn,amended_by_id,amended_date,amend_reason,amend_reason_code,allocate_finding,fill_finding,delivery_finding, allocate_remarks_code, fill_remarks_code, delivery_remarks_code,ReqDb,enc_id1,called_from,ref_sent_remarks, verify_remarks,ivprep){ // amended_by_id,amended_date,amend_reason,amend_reason_code added for ML-BRU-SCF-0098 [IN031837] && code ",allocate_finding,fill_finding,delivery_finding " added for ML-BRU-SCF-0971[IN042220] && ref_sent_remarks Added for HSA-CRF-0155 [IN048487]//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4//added ivprep for SKR-SCF-1370
//alert("ReqDb==="+ReqDb+"enc_id1==="+enc_id1)
	var patient_id	=	parent.parent.f_query_criteria.queryPatientDrugProfileCriteria.patient_id.value;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?patient_id="+patient_id+"&sr_no="+sr_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&line_status="+line_status+"&split_dose_yn="+split_dose_yn+"&sliding_scale_yn="+sliding_scale_yn+"&amended_by_id="+amended_by_id+"&amended_date="+amended_date+"&amend_reason="+encodeURIComponent(amend_reason,'UTF-8')+"&amend_reason_code="+amend_reason_code+"&allocate_finding="+allocate_finding+"&fill_finding="+fill_finding+"&delivery_finding="+delivery_finding+"&allocate_remarks_code="+allocate_remarks_code+"&fill_remarks_code="+fill_remarks_code+"&delivery_remarks_code="+delivery_remarks_code+"&ref_sent_remarks="+ref_sent_remarks+"&verify_remarks="+verify_remarks+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from+"&ivprep="+ivprep,arguments,features);//code '"&allocate_finding="+decodeURIComponent(allocate_finding,'UTF-8')+"&fill_finding="+decodeURIComponent(fill_finding,'UTF-8')+"&delivery_finding="+decodeURIComponent(delivery_finding,'UTF-8')' added for ML-BRU-SCF-0971[IN042220]	 && ref_sent_remarks Added for HSA-CRF-0155 [IN048487] //verify_remarks Added for ML-MMOH-SCF-0327 [IN:058772] //ADDED IVPREP FOR SKR-SCF-1370
}

function closeRemarks(){
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

async function showMedicationDetails(order_id){

	var dialogHeight= "22" ;
	var dialogWidth	= "40" ;
	var dialogTop = "180" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileMedication.jsp?order_id="+order_id,arguments,features);
}

function closeMedicationDetails(){
	//window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function showDiscCancelLink(obj,disc_link,cancel_link,order_id,order_line_no){
	buildTable(disc_link,cancel_link,order_id,order_line_no);
}

function hideDiscCancelLink(obj){
	var tab_dat  = "";
	document.getElementById("t").innerHTML = tab_dat;
}

function buildTable(disc_link,cancel_link,order_id,order_line_no){
	
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='1'   class='BOX' width='100%' height='100%' align='center' >";
	if(disc_link=="Y"){
		tab_dat     += "<tr onClick=\"javascript:discontinueTheDrug('"+order_id+"','"+order_line_no+"')\"><th align='left' nowrap class='TOOLTIP' title='Discontinue'>&nbsp;Discontinue&nbsp;</th></tr>";
	}
	if(cancel_link=="Y"){
		tab_dat     += "<tr onClick=\"javascript:cancelTheDrug('"+order_id+"','"+order_line_no+"')\"><th align='left' nowrap class='TOOLTIP' title='Cancel'>&nbsp;Cancel&nbsp;</th></tr>";
	}
	tab_dat     += "</table>";
	document.getElementById("t").innerHTML = tab_dat;

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	var x 	  = event.x;
	var y 	  = event.y;
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
	y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x = event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
	if(y<bodheight)
		y = event.y
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer").style.posLeft= x-15;
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible';
}

async function discontinueTheDrug(order_id,order_line_no,called_frm){
	var dialogHeight	= "13" ;
	var dialogWidth		= "31";
	var dialogTop		= "300" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?chk=N&title=Discontinue Remarks&order_id="+order_id+"&order_line_no="+order_line_no+"&called_frm="+called_frm,arguments,features);
	if(retVal=="OK"){
		//window.close();
	
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
	else if(retVal=="Dispense" || retVal=="DispenseMax"){ //"DispenseMax" added for Bru-HIMS-CRF-081 [IN:029947]
//		window.returnValue="Dispense";
//		window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = "Dispense";
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
}

async function cancelTheDrug(order_id,order_line_no,called_frm){
	var dialogHeight	= "13" ;
	var dialogWidth		= "31";
	var dialogTop		= "300" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal = await window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?chk=C&title=Cancel Remarks&order_id="+order_id+"&order_line_no="+order_line_no+"&called_frm="+called_frm,arguments,features);
	if(retVal=="OK"){
		//window.close();
		
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	}
	else if(retVal=="Dispense" || retVal=="DispenseMax"){
//		window.returnValue="Dispense";
//		window.close();
		
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = "Dispense";
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();  
	} 
}
function callDiscCancel(order_id,order_line_no,frmObj,status,called_frm){

	if(frmObj.remarks.value.length < 500){
		var fields  = new Array() ;
		var names   = new Array() ;
		fields[1]   = frmObj.remarks ;
		fields[0]	= frmObj.reason;
		names[1]    = "Remarks" ;
		names[0]	= "Reason";
		if(checkFlds( fields, names)){
			var xmlStr ="<root><SEARCH ";
			xmlStr+= "reason  =\"" + frmObj.reason.value + "\" " ;
			xmlStr+= "remarks =\"" + frmObj.remarks.value + "\" " ;
			xmlStr+= "order_id =\"" + order_id + "\" " ;
			xmlStr+= "order_line_no =\"" + order_line_no + "\" " ;
			xmlStr+= "status=\"" + status + "\" " ;
			xmlStr+= "called_frm=\"" + called_frm + "\" " ;
			xmlStr +=" /></root>";
			var temp_jsp="QueryPatientDrugProfileValidation.jsp?func_mode=DiscCancel";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;		
			eval(responseText);
		}			
	}else{
		alert(getMessage("PH_REMARKS_NOT_EXCEED","PH"));
	}
}

function alertMessage(message,called_frm){
	alert(message);	
	//window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}
//ReqDb,enc_id1added parameters fror mms-icn-0115
async function showDetails(order_id,order_line_no,line_status_text,allocate_finding,fill_finding, allocate_remarks_code, fill_remarks_code, flag, verify_remarks,ReqDb,enc_id1){//  delivery_remarks_code not called any where and called_from added for ML-BRU-SCF-1394[IN0501010] line_status_text is Added for Bru-HIMS-CRF-082 [IN:029948] 
	
	var patient_id	=	parent.parent.f_query_criteria.queryPatientDrugProfileCriteria.patient_id.value;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "20" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
		//ReqDb,enc_id1 added parameters fror mms-icn-0115
	
	var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&line_status_text="+line_status_text+"&allocate_finding="+allocate_finding+"&fill_finding="+fill_finding+"&allocate_remarks_code="+allocate_remarks_code+"& fill_remarks_code="+fill_remarks_code+"&flag="+flag+"&verify_remarks="+verify_remarks+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1,arguments,features);
}

async function showDispDetails(item_name,dispense_Qty,ordered_By,Status,order_quantity_uom, order_id, order_line_num, disp_date, disp_locn_desc){//Added for Medical Item--start
	var dialogHeight= "700px" ;
	var dialogWidth	= "900px" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var flag="MI"
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?item_name="+item_name+"&dispense_Qty="+dispense_Qty+"&ordered_By="+ordered_By+"&Status="+Status+"&order_quantity_uom="+order_quantity_uom+"&flag="+flag+"&order_id="+order_id+"&order_line_no="+ order_line_num+ "&disp_date="+disp_date+"&disp_locn_desc="+ disp_locn_desc,arguments,features);
}//Added for Medical Item--end

function closeDetails(){
	//window.close();
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function disableGeneric(obj){
	var formObj = document.forms[0];
	formObj.ItemType[0].checked=true;
	formObj.ItemType.value= 'D';
	if( obj.checked == true ){
		formObj.generic_name.value="";
		formObj.generic_name.disabled  = true;
		formObj.generic_name_search.disabled = true;
	}
    else if( obj.checked == false) {
	  	formObj.generic_name.value="";
		formObj.generic_name.disabled  = false;
		formObj.generic_name_search.disabled = false;
	}
 }

async function showTPNDetails(order_id){
	var dialogTop		= "150";
 	var dialogHeight	= "22" ;
 	var dialogWidth		= "30" ;
	var center			= "1" ;
	var title           ="aaaa";
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + "; center: " + center +';  dialogTop:'+dialogTop +';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments		= "";
	
 	await window.showModalDialog("../../ePH/jsp/TPNConstituentDetails.jsp?order_id="+order_id,arguments,features);

}
function validate_date(Obj,ref) {
                
//	var formObj = document.frames.f_query_add_mod.f_query_criteria.queryPatientDrugProfileCriteria;
var formObj = document.forms[0];
	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = formObj.dt_to;
	  to = formObj.dt_from;
	  error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");  
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = formObj.dt_from;
	  to = formObj.dt_to;
	  error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH"); 
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
//	  from = parent.frames[1].formObj.dt_to;
//	  to = parent.frames[1].formObj.dt_from;
 from = formObj.dt_to;
 to = formObj.dt_from;
	  error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			from.value="";
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/


	if(formObj.dt_from.value=='' || formObj.dt_to.value==''){ 
		return false;
	}
	else{
		if(!isBefore(formObj.dt_from.value,formObj.dt_to.value,"DMY",formObj.locale.value)) {
			
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			formObj.dt_from.select();
			return false;
		}
	}
	return true;
}
function validate_date1(Obj,ref) {
                
	var formObj = document.frames.PatientExternalDrug;
	
	if (CheckDate(Obj)){
		if(ref == "TO_DT_GR_EQ_FM_DT"){
			from = formObj.dt_to;
			to = formObj.dt_from;
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");  
	 	 
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
			from = formObj.dt_from;
			to = formObj.dt_to;
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH"); 
	 	 
		}
		else if(ref == "TO_DATE_LESS_FROM"){
			//	  from = parent.frames[1].formObj.dt_to;
			//	  to = parent.frames[1].formObj.dt_from;
			from = formObj.dt_to;
			to = formObj.dt_from;
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
		}
	
		var fromarray;
		var toarray;
		var fromdate = eval(from).value ;
		var todate = eval(to).value ;
	
		if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
		
			if(Date.parse(todt) > Date.parse(fromdt)) {		   
				alert(error_id);
				from.value="";
				from.focus();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)){
				//parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
				return true;
			} 
		}
		return true;
	}
}

function DateCheck(from,to) {

   /* var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
//========================================================================================================	
	if(from.value=="" || to.value==""){ 
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].locale.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.select();
			return false;
		}
	}
    return true;
}

function objClick(patient_id,dt_from,dt_to,generic_id,drug_code,pat_class,status, called_frm,disp_locn_code,called_frm,ReqDb,enc_id1,called_from){//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	//alert("ReqDb=="+ReqDb)
 	var tpn_val;
 	var formObj = parent.parent.f_query_criteria.queryPatientDrugProfileCriteria;//Added for Bru-HIMS-CRF-404 [IN:044795]
	formObj.ItemType[0].checked=true;
	formObj.ItemType.value= 'D';
	if(parent.parent.f_query_criteria.document.queryPatientDrugProfileCriteria.tpnCkBox.checked){
	    tpn_val    =  'Y';
		parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileTPNResult.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&disp_locn_code="+disp_locn_code+"&called_frm="+called_frm+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from;//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	}
	else{
		tpn_val='N';
		parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileResult.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&generic_id="+generic_id+"&drug_code="+drug_code+"&pat_class="+pat_class+"&status="+status+"&disp_locn_code="+disp_locn_code+"&called_frm="+called_frm+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from;//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	}
	parent.parent.f_query_criteria.document.getElementById("itemname").style.display = 'none';//Added for Bru-HIMS-CRF-404 [IN:044795]
	parent.parent.f_query_criteria.document.getElementById("drugname").style.display = 'inline';//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("ExternalDrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabA";//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("DrugProfile_link").className = "tabClicked";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("DrugProfile_link_aspan").className = "tabSpanclicked";
	//document.getElementById("Drugid").style.display = "inline";
	//document.getElementById("ExternalId").style.display = "none";
	//document.getElementById("drugprofileid").style.visibility = "visible";
}

function objClick1(patient_id,dt_from,dt_to,mode, called_frm,pat_class,encounter_id,ReqDb,enc_id1,called_from){ // pat_class,encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	var formObj = parent.parent.f_query_criteria.queryPatientDrugProfileCriteria;//Added for Bru-HIMS-CRF-404 [IN:044795]
	formObj.ItemType[0].checked=true;
	formObj.ItemType.value= 'D';
	parent.f_query_result.location.href="../../ePH/jsp/QueryPatientExternalDrugProfileResult.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&mode="+mode+"&called_frm="+called_frm+"&pat_class="+pat_class+"&encounter_id="+encounter_id+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from; // // pat_class,encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	//alert("called_frm==="+called_frm+"called_from=="+called_from)
	parent.parent.f_query_criteria.document.getElementById("itemname").style.display = 'none';//Added for Bru-HIMS-CRF-404 [IN:044795]
	parent.parent.f_query_criteria.document.getElementById("drugname").style.display = 'inline';//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("DrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabA";//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("ExternalDrugProfile_link").className = "tabClicked";
	document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";//Added for Bru-HIMS-CRF-404 [IN:044795]
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabSpanclicked";
	//document.getElementById("Drugid").style.display = "none";
	//document.getElementById("drugprofileid").style.visibility = "hidden";
	//document.getElementById("ExternalId").style.display = "inline";
 }

function objClick2(patient_id, item_code, dt_from,dt_to,mode,ReqDb,enc_id1,called_from){//Added for Bru-HIMS-CRF-404 [IN:044795]--start//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	var formObj = parent.parent.f_query_criteria.queryPatientDrugProfileCriteria;
	formObj.ItemType[1].checked=true;
	formObj.ItemType.value= 'M';
	parent.parent.f_query_criteria.document.getElementById("itemname").style.display = 'inline';
	parent.parent.f_query_criteria.document.getElementById("drugname").style.display = 'none';
	parent.f_query_result.location.href="../../ePH/jsp/QueryPatientDrugProfileMedicalItems.jsp?patient_id="+patient_id+"&dt_from="+dt_from+"&dt_to="+dt_to+"&mode="+mode+"&item_code="+item_code+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from;//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
	document.getElementById("DrugProfile_link").className = "tabA";
	document.getElementById("ExternalDrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabClicked";
	document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabSpanclicked";
 }//Added for Bru-HIMS-CRF-404 [IN:044795]--end

 async function AddDrugsPage(patient_id){
	var url="../../ePH/jsp/QueryPatientDrugProfileExternalDrug.jsp?patient_id="+patient_id;
	var dialogHeight  = "50vh" ;
    var dialogWidth = "60vw" ;
	var dialogTop	= '40';
	var dialogLeft = '8' ;
	var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	onSuccess(patient_id);
	       parent.f_query_result.location.href=parent.f_query_result.location.href;  // Added for AAKH-CRF-0088.2
}

async function DrugsearchCode(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
	var id=document.PatientExternalDrug.language_id.value;
	var formObj		   = document.PatientExternalDrug;
	    argumentArray[0]   =formObj.SQL_PH_DRUG_SEARCH_DRUG.value+"'"+formObj.language_id.value+"'";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.drug_desc.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		var retVal = await CommonLookup( getLabel("ePH.DrugNameLookup.label","PH"), argumentArray );
		var ret1=unescape(retVal);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "" ){
			formObj.drug_code.value = arr[0];
		    formObj.drug_desc.value = arr[1];
		   //added for IN070786 start
		    var	bean_id			= "QueryPatientDrugProfileBean" ;
			var	bean_name		= "ePH.QueryPatientDrugProfileBean";
			var xmlStr ="<root><SEARCH ";	
			xmlStr+= "drug_code=\"" + arr[0] + "\" " ;
			xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
			xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
			xmlStr +=" /></root>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=fetchDrugDetails&bean_id=" + bean_id + "&bean_name=" +bean_name, false ) ;	
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;		
			//alert(responseText);
			eval(responseText);	
			//added for IN070786 end
		}
		else
			formObj.drug_code.value = "";
  }
//added for IN070786 start
function addDefaultValues(form_code){

	//var formObj		   = document.PatientExternalDrug;
	document.PatientExternalDrug.form_code.value=form_code;
}
function dosageChange(obj){
	var form_code=document.PatientExternalDrug.form_code.value;
	var drug_code=document.PatientExternalDrug.drug_code.value;
	var dosage=document.PatientExternalDrug.dosage.value;
	
	//alert(document.PatientExternalDrug.form_code.value+""+dosage);
if(drug_code !=""){
	var	bean_id			= "QueryPatientDrugProfileBean" ;

	var	bean_name		= "ePH.QueryPatientDrugProfileBean";
	var xmlStr ="<root><SEARCH ";	
	xmlStr+= "form_code=\"" + form_code + "\" " ;
	xmlStr+= "drug_code=\"" + drug_code + "\" " ;
	xmlStr+= "dosage_type=\"" + dosage + "\" " ;
	xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=changeuomDetails&bean_id=" + bean_id + "&bean_name=" +bean_name, false ) ;	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);	
}
}//added for IN070786 end
 
  async function PrescribeSearchCode(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
	
	var id=document.PatientExternalDrug.language_id.value;
	var formObj		   = document.PatientExternalDrug;
	    argumentArray[0]   =formObj.SQL_PH_DISP_LOCN_SELECT.value;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.pract_name.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "" )
			{
			formObj.pract_name.value = arr[1];
		    formObj.pract_id.value = arr[0];
		}
}
var message = "" ;
var result = false ;

function assignResult( _result, _message, _flag ){
	result		=	 _result ;
	message		=	_message ;
	flag		=	_flag ;
}

function AddDrugRecord(){
		
	var formObj = document.PatientExternalDrug;
	var patient_id=document.getElementById('patient_id').value;
	if(formObj.drug_desc.value==""){
	  alert(getMessage("DRUG_CANT_BE_BLANK","PH")); 
	  return;
	}
 	//commented for IN070786
	/*else if (formObj.pract_name.value == "") {
		alert(getMessage("PH_PRACT_NAME_CANT_RIGHTS", "PH"));
		return;
	}*/
	else if(formObj.dt_from.value==""){			
	   alert(getMessage("PH_START_DATE","PH")); 
		return;
		
	}
	else if(formObj.Instructions.value==""){
		alert(getMessage("PH_INST_CANT_RIGHTS","PH"));
		 return;
	}
	var mode=formObj.mode.value;
	eval(formApply(formObj,PH_CONTROLLER ));
	if( result ) {
		alert(getMessage("RECORD_INSERTED","PH"))
		//window.close();
	
	parent.document.querySelectorAll("#dialog_tag")[parent.document.querySelectorAll("#dialog_tag").length -1].close();  
	}
}

function onSuccess(patient_id){
	 parent.f_query_result.location.href="../../ePH/jsp/QueryPatientExternalDrugProfileResult.jsp?patient_id="+patient_id;
}

function ValidateTime(obj, Sysdate){
	dt_to = document.PatientExternalDrug.dt_to;
	locale = document.PatientExternalDrug.language_id.value;
	if(locale!='en') //if block added for RUT-SCF-0378 [IN:046858]
		Sysdate = convertDate(Sysdate,'DMY',"en",locale); 
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.focus;
			return false;
		}
		dt_fr = obj.value;
		dt_from = "";
		if(dt_fr.indexOf(' ')!=-1){
			frDatelst = dt_fr.split(" ");
			dt_from = frDatelst[0];
		}
		if(!isBefore(dt_from,Sysdate, "DMY",locale)){
			alert(getMessage("FROM_DATE_LESS_THAN_SYSDATE", "PH"));
			obj.value="";
			obj.focus();
			return false;
		}		
		if (dt_to.value!=""){
			if(!ValidateDateTime(obj,dt_to)){
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				//document.formPhMednOrderListCriteria.dt_to.value="";
				obj.value="";
				return false;
			}
		}
	}
}

function ValidatetoTime(obj){
	fr_dt = document.PatientExternalDrug.dt_from;
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.value="";
			obj.focus;
			return false;
		}
		else
			if (fr_dt.value!=""){
				if(!ValidateDateTime(fr_dt,obj)) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				obj.value="";
				obj.select();
				return false;
				}
			}
	}
	return true;
}

function checkMaxLength(obj){
	var str	=	obj.value;
	if(str.length>4000)	{
		var fieldname = getLabel("Common.Instructions.label","Common");
		var msg = getMessage("PH_INSTRUCTIONS_MAX_LENGTH", "PH");
		msg		= msg.replace('PRN Remarks', fieldname);
		alert(msg);
		obj.focus();
	}
}

async function openPPNDisplay(patientId,orderId,dispLocn, disChargeInd){
	var dialogHeight	= "30vh" ;
	var dialogWidth		= "40vw";
	var dialogTop		= "290" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var retVal			= await window.showModalDialog("../../ePH/jsp/PPNOrderDeails.jsp?patientId="+patientId+"&orderId="+orderId+"&disp_locn_code="+dispLocn+"&disChargeInd="+disChargeInd,arguments,features);
}

async function showMultipleFlowRate(patient_id,order_id){

	var bean_id			= "@IVPrescriptionBean"+patient_id;
	var bean_name		= "ePH.IVPrescriptionBean";

	var dialogTop		= "310";
 	var dialogHeight	= "40vh";
 	var dialogWidth		= "65vw";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/IVPrescriptionMFRView.jsp?patient_id="+patient_id+"&order_id="+order_id+"&bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
 }
// Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- start
 async function showSlidingDetails(order_id, order_line_num, sliding_scale_yn,blTempFound, recCount){
	if(blTempFound == 'true' || blTempFound == true){
		hideSlidingDtl(recCount);
		var dialogHeight= "43vh" ;
		var dialogWidth	= "65vw" ;
		var dialogTop = "400" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retVal = await window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&sliding_scale_yn="+sliding_scale_yn+"&called_frm=SlidingScale",arguments,features);
	}
}

function dispSlidingDtl(recCount){

   // bodwidth  = parent.parent.frames[1].document.body.offsetWidth;
   // bodheight = parent.parent.frames[1].document.body.offsetHeight;
    bodwidth  = document.body.document.getElementById('table_container_right').offsetWidth;
    bodheight = document.body.document.getElementById('table_container_right').offsetHeight;
	var divSlidingDtlObj = document.getElementById('divSlidingdetail'+recCount);
    divSlidingDtlObj.style.display='inline';

    var x     = event.x;
    var y     = event.y;

    y += document.body.document.getElementById('table_container_right').scrollTop;
    x += document.body.document.getElementById('table_container_right').scrollLeft;

	divSlidingDtlObj.style.posLeft= x+10;

	if((y+20) > (bodheight - divSlidingDtlObj.offsetHeight ) ){
		//divSlidingDtlObj.style.posTop = y - (divSlidingDtlObj.offsetHeight+10);
		y = (bodheight+document.body.document.getElementById('table_container_right').scrollTop) - (divSlidingDtlObj.offsetHeight+40);
		if(y < document.body.document.getElementById('table_container_right').scrollTop)
			y = document.body.document.getElementById('table_container_right').scrollTop+5;
		//if((y+divSlidingDtlObj.offsetHeight) >  bodheight)
		divSlidingDtlObj.style.posTop = y;
	}
	else
		divSlidingDtlObj.style.posTop = y+10;
}

function hideSlidingDtl(recCount){
	var divSlidingDtlObj = document.getElementById('divSlidingdetail'+recCount);
	divSlidingDtlObj.style.display = "none" ;
} // Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
 // added for ML-BRU-SCF-0430 IN[035169] --start --
async function callAuditTrail(orderId,patient_id){
	var bean_id = "Or_ViewOrder";
	var bean_name = "eOR.ViewOrder";
	var dialogHeight ='65vh' ;
	var dialogWidth = '70vw' ; 
	var dialogTop	= '19';
	var dialogLeft = '10' ;
	var title = ''
	var finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderHistoryFrameset.jsp?"+finalString,arguments,features);      
}   // added for ML-BRU-SCF-0430 IN[035169]-- End 

//added for Bru-HIMS-CRF-087 [IN:029953] -start
async function viewOutsourceDtls(orderId, orderLineNum){
	var dialogHeight= "46vh" ;
	var dialogWidth	= "45vw" ;
	var dialogTop	= "275" ;
	var dialogLeft	= "200" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "auto";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?callFrom=VIEWOUTSOURCEDTL&orderId="+orderId+"&orderLineNum="+orderLineNum,arguments,features);
}
//added for Bru-HIMS-CRF-087 [IN:029953] - end
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.queryPatientDrugProfileCriteria.patient_id.value; 
	if((patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;		
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}		
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.queryPatientDrugProfileCriteria.patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */

async function showClinicalNotes(patient_id,drug_code,srl_no,pat_class,accession_no,facility_id,encounter_id){	// Added for AAKH-CRF-0088.2 [IN:061987]
	var retVal;
	var dialogTop		= "";
 	var dialogHeight	= "60vh" ;
 	var dialogWidth		= "80vw" ;
	var dialogLeft		= "180" ;	

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	var search = "Add"; 
 	if(accession_no!="")
 		search = "Search";

 	retVal 			= await window.showModalDialog("../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=PH_NOTES&appl_task_id=PH_NOTES&patient_id="+patient_id+"&patient_class="+pat_class+"&accession_num="+accession_no+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&srl_no="+srl_no+"&appl_task_id=PH_NOTES&title=Pharmacy Notes&window_close=Y&hide_header=N&tab_yn=N&callback_mode="+search+"&called_from=PH_NOTES", arguments, features);
 	if(retVal != null && retVal!="" && retVal!=undefined)
 	{
		if(retVal=="MakeAsError")
           accession_no = "";
		else
		   accession_no = retVal;
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;		
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr+= "drug_code=\"" + drug_code + "\" " ; 
		xmlStr+= "srl_no=\"" + srl_no + "\" " ;
		xmlStr+= "facility_id=\"" + facility_id + "\" " ;
		xmlStr+= "retVal=\"" + accession_no + "\" " ;
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=update_accession_num&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patient_id="+patient_id+"&drug_code="+drug_code+"&srl_no="+srl_no+"&retVal="+accession_no+"&facility_id="+facility_id, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
		alert(getMessage("RECORD_INSERTED","PH"));
        parent.f_query_result.location.href=parent.f_query_result.location.href;
	}
}
async function showAltDrugRemarks(stkey,alt_drug_remarks_ind){// Added for Bru-HIMS-CRF-082 [IN:029948] 
	var dialogHeight= "35vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retRem = await window.showModalDialog("../../ePH/jsp/DispMedicationRemarks.jsp?called_from=VIEW&id=Q&alt_drug_remarks_ind="+alt_drug_remarks_ind+"&stkey="+stkey,arguments,features);
}

function checkRemarksMaxLimit(obj,maxLeng, label) {  //function checkRemarksMaxLimit added for [IN:039007]
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
async function  showFinding(allocate_remarks,fill_remarks,delivery_remarks, allocate_remarks_code, fill_remarks_code, delivery_remarks_code, verify_remarks){ // code added for ML-BRU-SCF-0971[IN042220]-- Start	
	var dialogHeight= "38vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "238" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	await window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?called_frm=VIEW&allocate_remarks="+allocate_remarks+"&fill_remarks="+fill_remarks+"&delivery_remarks="+delivery_remarks+"&allocate_remarks_code="+allocate_remarks_code+"&fill_remarks_code="+fill_remarks_code+"&delivery_remarks_code="+delivery_remarks_code+"&title="+getLabel("Common.Findings.label","Common")+"&verify_remarks="+verify_remarks,arguments,features);//code ',arguments' removed for IN046252
}// code added for ML-BRU-SCF-0971[IN042220]-- End

function ViewHideCriteria(obj, Click_yn){ //Added for Bru-HIMS-CRF-081 [IN:029947] End
	if(obj.value=='V'){
		obj.value='H';
		obj.title='View Criteria';
		obj.src='../../ePH/images/downarrow.gif';
		//parent.parent.QueryPatientDrugProfileFrames.rows="0,*,8%";
		document.getElementById("expand").style.display='inline';
		document.getElementById("Closebutton").style.display='inline';
		if(Click_yn=='Y'  && parent.f_query_result.document.getElementById("table_container_left")!=undefined){
			parent.f_query_result.document.getElementById("table_container_left").style.height="230px";
			parent.f_query_result.document.getElementById("table_container_right").style.height="248px";
		}
	}
	else{
		obj.value='V';
		obj.title='Hide Criteria';
		obj.src='../../ePH/images/uparrow.gif';
		//parent.parent.QueryPatientDrugProfileFrames.rows="21%,*,8%";
		document.getElementById("expand").style.display='none';
		document.getElementById("Closebutton").style.display='none';
		if(Click_yn=='Y' && parent.f_query_result.document.getElementById("table_container_left")!=undefined ){
			parent.f_query_result.document.getElementById("table_container_left").style.height="165px";
			parent.f_query_result.document.getElementById("table_container_right").style.height="183px";
		}
	}
}

function adjustTableHeight(){
	ViewHideCriteria = parent.f_query_result1.document.getElementById("idViewHideCriteria");
	if(ViewHideCriteria.style.display=='inline' && ViewHideCriteria.value=='V'){
		parent.f_query_result.document.getElementById("table_container_left").style.height="165px";
		parent.f_query_result.document.getElementById("table_container_right").style.height="183px";
	}
	else if(ViewHideCriteria.style.display=='inline' && ViewHideCriteria.value=='H'){
		parent.f_query_result.document.getElementById("table_container_left").style.height="230px";
		parent.f_query_result.document.getElementById("table_container_right").style.height="248px";
	}
} //Added for Bru-HIMS-CRF-081 [IN:029947] -End

function SubmitLink(from,to,patient_id){
	var obj=parent.f_query_result.document.forms[0];
	obj.from.value=from;
	obj.to.value=to;
    obj.patient_id.value=patient_id;
	obj.submit();
}

function changeName(){
	var formObj = document.queryPatientDrugProfileCriteria;
	if(formObj.ItemType[0].checked == true){
		document.getElementById("itemname").style.display = 'none';
		document.getElementById("drugname").style.display = 'inline';
	}
	else{
		document.getElementById("itemname").style.display = 'inline';
		document.getElementById("drugname").style.display = 'none';
		formObj.tpnCkBox.checked=false;
	}
}

async function callDiscCancelledOrders(disc_cancelled_orders, drug_name){
	var dialogHeight	= '45vh' ;
	var dialogWidth		= "80vw";
	var dialogTop		= "190" ;
	var dialogLeft		= "150" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal=await window.showModalDialog("../../ePH/jsp/DiscCancelledDrugDetailsDisplay.jsp?disc_cancelled_orders="+encodeURIComponent(disc_cancelled_orders,'UTF-8')+"&drug_name="+drug_name,arguments,features);
}
//added for IN070786 start
function addDataDefault(code, desc, obj,sel) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	if(sel == "selected") 
		opt.selected = true; 
	obj.add(opt);
}
function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	//opt.value =	"";
	//opt.text = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--Select--";
	//obj.add(opt);
}

function ExternalDrug(obj){
	var formobj=document.QueryPatientExternalDrugProfileResultform;
	var formobjQry = parent.parent.f_query_criteria.queryPatientDrugProfileCriteria;
	if(obj.checked){
			
		formobj.ADDDRUGS.disabled=true;
	}
	else{
		formobj.ADDDRUGS.disabled=false;
	}
	if(obj.checked){
		obj.value="Y";
		chk_status	=	"Y";
	} else {
		obj.value="N";
		chk_status	=	"N";
	}
	
	formobjQry.no_ext_drug1.value=obj.value;


}

function ExternalDrugInsert(){
	var formobj = document.queryPatientDrugProfileCriteria;
	no_ext_drug=document.queryPatientDrugProfileCriteria.no_ext_drug.value;
	no_ext_drug1=document.queryPatientDrugProfileCriteria.no_ext_drug1.value;
		
	
	bean_id="@PrescriptionBean_1";
	bean_name="ePH.PrescriptionBean_1";
	if(no_ext_drug =="Y" && no_ext_drug1==""){//added for IN009448
		no_ext_drug1="Y";
	}
	 if(no_ext_drug != no_ext_drug1){
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patient_id  =\"" + formobj.patient_id.value+ "\" " ;
	xmlStr+= "encounter_id =\"" + formobj.encounter_id.value + "\" " ;
	xmlStr+= "no_extrnal_drug =\"" + no_ext_drug1 + "\" " ;
	xmlStr+= "chk_status  =\"" + no_ext_drug1 + "\" " ;
	xmlStr+= "bean_id =\"" + bean_id + "\" " ;
	xmlStr+= "bean_name=\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	
	 var temp_jsp="PrescriptionValidation_1.jsp?func_mode=UPDATE_EXTERNAL_STATUS";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 responseText=xmlHttp.responseText ;   

	 eval(responseText);
	 }
	
}//added for IN070786 end
