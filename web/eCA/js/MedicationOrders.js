/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
12/11/2020		IN073728	Nijithas		12/11/2020		Ramesh G		MO-CRF-20101.16
---------------------------------------------------------------------------------------------------------------
*/ 
// lookup for Generic Name 
async function searchGenericName(){ 
	var formObj = document.eventDetailsFrame;
								
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var language_id=document.eventDetailsFrame.locale.value;

	argumentArray[0]   = "SELECT  GENERIC_ID  code,  GENERIC_NAME  description  FROM  PH_GENERIC_NAME_LANG_VW  PH_GENERIC_NAME    WHERE   UPPER(GENERIC_ID)  LIKE  UPPER(?)  AND  UPPER(GENERIC_NAME)  LIKE  UPPER(?) AND LANGUAGE_ID = '"+language_id+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";	
   	argumentArray[5]   = formObj.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal=await CommonLookup(getLabel("Common.GenericName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var retVal=unescape(retVal);
	    arr=retVal.split(",");
		formObj.generic_name.value = arr[1] ;
		formObj.generic_id.value = arr[0];
	   	//formObj.drug_name.value = "" ;
		//formObj.drug_code.value = "" ;
		formObj.drug_name.disabled  = false;
		formObj.drug_name_search.disabled = false;
		populateDates("medTab");//Adding start for  IN073884//IN073728
	}else{
      
		formObj.generic_name.value = "" ;
		formObj.generic_id.value = "";
		populateDates("medTab");//IN073728
	}//Adding end for  IN073884
}

// lookup for Drug Name
async function searchDrugName(){
	var formObj =document.eventDetailsFrame;
	var generic_id =formObj.generic_id.value;
	
	var type= 'D';
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		var language_id=document.eventDetailsFrame.locale.value;
		if(type=='D'){
			if(generic_id != "")
			     argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='Y' AND LANGUAGE_ID ='"+language_id+"' and generic_id like upper('"+generic_id+"') ";
			else
				argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='Y' AND LANGUAGE_ID ='"+language_id+"' ";


		}else
			argumentArray[0]   = "SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DRUG_YN='N' AND LANGUAGE_ID ='"+language_id+"'";

		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.drug_name.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ; 
		retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var retVal=unescape(retVal);
	    arr=retVal.split(",");
		formObj.drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		formObj.ql_evntItm.value = arr[0];
		
		//formObj.generic_name.value = "";
		//formObj.generic_id.value = "";
		populateDates("medTab");//Adding start for  IN073884//IN073728
	}else{
		formObj.drug_name.value = "" ;
		formObj.drug_code.value = "";
		formObj.ql_evntItm.value = "";
		populateDates("medTab");//IN073728
	}//Adding end for  IN073884
}


async function showRemarks(order_id,order_line_num,sr_no,line_status,split_dose_yn,sliding_scale_yn,amended_by_id,amended_date,amend_reason,amend_reason_code,allocate_finding,fill_finding,delivery_finding, allocate_remarks_code, fill_remarks_code, delivery_remarks_code,ReqDb,enc_id1,called_from,ref_sent_remarks, verify_remarks,patient_id){ 
	var dialogHeight= "20" ;
	var dialogWidth	= "45" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?patient_id="+patient_id+"&sr_no="+sr_no+"&order_id="+order_id+"&order_line_num="+order_line_num+"&line_status="+line_status+"&split_dose_yn="+split_dose_yn+"&sliding_scale_yn="+sliding_scale_yn+"&amended_by_id="+amended_by_id+"&amended_date="+amended_date+"&amend_reason="+encodeURIComponent(amend_reason,'UTF-8')+"&amend_reason_code="+amend_reason_code+"&allocate_finding="+allocate_finding+"&fill_finding="+fill_finding+"&delivery_finding="+delivery_finding+"&allocate_remarks_code="+allocate_remarks_code+"&fill_remarks_code="+fill_remarks_code+"&delivery_remarks_code="+delivery_remarks_code+"&ref_sent_remarks="+ref_sent_remarks+"&verify_remarks="+verify_remarks+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1+"&called_from="+called_from,arguments,features);
}

function closeRemarks(){
	window.close();
}

async function showMedicationDetails(order_id){

	var dialogHeight= "22" ;
	var dialogWidth	= "40" ;
	var dialogTop = "180" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileMedication.jsp?order_id="+order_id,arguments,features);
}

function closeMedicationDetails(){
	window.close();
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
	var retVal = await top.window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?chk=N&title=Discontinue Remarks&order_id="+order_id+"&order_line_no="+order_line_no+"&called_frm="+called_frm,arguments,features);
	if(retVal=="OK"){
		window.close();
	}
	else if(retVal=="Dispense" || retVal=="DispenseMax"){ 
		window.returnValue="Dispense";
		window.close();
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
	var retVal = await top.window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?chk=C&title=Cancel Remarks&order_id="+order_id+"&order_line_no="+order_line_no+"&called_frm="+called_frm,arguments,features);
	if(retVal=="OK"){
		window.close();
	}
	else if(retVal=="Dispense" || retVal=="DispenseMax"){
		window.returnValue="Dispense";
		window.close();
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
	window.close();
}
async function showDetails(order_id,order_line_no,line_status_text,allocate_finding,fill_finding, allocate_remarks_code, fill_remarks_code, flag, verify_remarks,ReqDb,enc_id1,patient_id){
	
	var dialogHeight= "15" ;
	var dialogWidth	= "55" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	
	var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id="+patient_id+"&order_id="+order_id+"&order_line_no="+order_line_no+"&line_status_text="+line_status_text+"&allocate_finding="+allocate_finding+"&fill_finding="+fill_finding+"&allocate_remarks_code="+allocate_remarks_code+"& fill_remarks_code="+fill_remarks_code+"&flag="+flag+"&verify_remarks="+verify_remarks+"&ReqDb="+ReqDb+"&enc_id1="+enc_id1,arguments,features);
}

async function showDispDetails(item_name,dispense_Qty,ordered_By,Status,order_quantity_uom, order_id, order_line_num, disp_date, disp_locn_desc){
	var dialogHeight= "15" ;
	var dialogWidth	= "55" ;
	var dialogTop = "240" ;
	var center = "1" ;
	var status="no";
	var flag="MI"
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?item_name="+item_name+"&dispense_Qty="+dispense_Qty+"&ordered_By="+ordered_By+"&Status="+Status+"&order_quantity_uom="+order_quantity_uom+"&flag="+flag+"&order_id="+order_id+"&order_line_no="+ order_line_num+ "&disp_date="+disp_date+"&disp_locn_desc="+ disp_locn_desc,arguments,features);
}

function closeDetails(){
	window.close();
}

function disableGeneric(obj){
	var formObj = document.frames.queryPatientDrugProfileCriteria;
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


function objClick(patient_id,encounter_id,patient_class,from_date,to_date,generic_id,eventItem,status,facility_id,pract_id,selTab,eventCls,date_Ordr,selHistType,eventGrp){
	
	
		//parent.parent.eventDetailsFrame.location ="../../eCA/jsp/ClinicalEventHistoryTabs.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&event_group="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//keys modified for IN073751//commented for IN073884

	parent.parent.eventDateFrame.location ="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&item_type="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//added for IN073884
	document.getElementById("ExternalDrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabA";
	document.getElementById("DrugProfile_link").className = "tabClicked";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";
	document.getElementById("DrugProfile_link_aspan").className = "tabSpanclicked";
	
}

function objClick1(patient_id,encounter_id,patient_class,from_date,to_date,generic_id,eventItem,status,facility_id,pract_id,selTab,eventCls,date_Ordr,selHistType,eventGrp){ 

	//parent.parent.eventDetailsFrame.location ="../../eCA/jsp/ClinicalEventHistoryTabs.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&event_group="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//keys modified for IN073751//commented for IN073884
	

	parent.parent.eventDateFrame.location ="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&item_type="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//added for IN073884
	
	
	document.getElementById("DrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabA";
	document.getElementById("ExternalDrugProfile_link").className = "tabClicked";
	document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabSpanclicked";
	
 }

function objClick2(patient_id,encounter_id,patient_class,from_date,to_date,generic_id,eventItem,status,facility_id,pract_id,selTab,eventCls,date_Ordr,selHistType,eventGrp){

		//parent.parent.eventDetailsFrame.location ="../../eCA/jsp/ClinicalEventHistoryTabs.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&event_group="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//keys modified for IN073751 //commented for IN073884

		parent.parent.eventDateFrame.location.href="../../eCA/jsp/ClinicalEventHistoryResultDates.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&generic_id="+generic_id+"&event_Item="+eventItem+"&ql_patClass="+patient_class+"&status="+status+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&pract_id="+pract_id+"&selTab="+selTab+"&event_class="+eventCls+"&date_Ordr="+date_Ordr+"&selHistType="+selHistType+"&item_type="+eventGrp+"&grphistory_type="+selHistType+"&personal_view="+selTab;//added for IN073884

	document.getElementById("DrugProfile_link").className = "tabA";
	document.getElementById("ExternalDrugProfile_link").className = "tabA";
	document.getElementById("MedicalItemProfile_link").className = "tabClicked";
	document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
	document.getElementById("MedicalItemProfile_link_aspan").className = "tabSpanclicked";
 }



async function openPPNDisplay(patientId,orderId,dispLocn, disChargeInd){
	var dialogHeight	= "10" ;
	var dialogWidth		= "40";
	var dialogTop		= "290" ;
	var dialogLeft		= "200" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	var retVal			= await top.window.showModalDialog("../../ePH/jsp/PPNOrderDeails.jsp?patientId="+patientId+"&orderId="+orderId+"&disp_locn_code="+dispLocn+"&disChargeInd="+disChargeInd,arguments,features);
}

async function showMultipleFlowRate(patient_id,order_id){

	var bean_id			= "@IVPrescriptionBean"+patient_id;
	var bean_name		= "ePH.IVPrescriptionBean";

	var dialogTop		= "310";
 	var dialogHeight	= "20";
 	var dialogWidth		= "65";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
 	var arguments		= "";
 	var retVal 			= await top.window.showModalDialog("../jsp/IVPrescriptionMFRView.jsp?patient_id="+patient_id+"&order_id="+order_id+"&bean_id="+bean_id+"&bean_name="+bean_name,arguments,features);
 }
 
async function showSlidingDetails(order_id, order_line_num, sliding_scale_yn,blTempFound, recCount){
	if(blTempFound == 'true' || blTempFound == true){
		hideSlidingDtl(recCount);
		var dialogHeight= "13" ;
		var dialogWidth	= "35" ;
		var dialogTop = "400" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retVal = await top.window.showModalDialog("../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&sliding_scale_yn="+sliding_scale_yn+"&called_frm=SlidingScale",arguments,features);
	}
}

function dispSlidingDtl(recCount){

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
		y = (bodheight+document.body.document.getElementById('table_container_right').scrollTop) - (divSlidingDtlObj.offsetHeight+40);
		if(y < document.body.document.getElementById('table_container_right').scrollTop)
			y = document.body.document.getElementById('table_container_right').scrollTop+5;
		divSlidingDtlObj.style.posTop = y;
	}
	else
		divSlidingDtlObj.style.posTop = y+10;
}

function hideSlidingDtl(recCount){
	var divSlidingDtlObj = document.getElementById('divSlidingdetail'+recCount)
	divSlidingDtlObj.style.display = "none" ;
}

async function callAuditTrail(orderId,patient_id){
	var bean_id = "Or_ViewOrder";
	var bean_name = "eOR.ViewOrder";
	var dialogHeight ='36' ;
	var dialogWidth = '48' ; 
	var dialogTop	= '129';
	var dialogLeft = '110' ;
	var title = ''
	var finalString = "bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&orderId="+orderId;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments = "";
	var retVals = await top.window.showModalDialog("../../eOR/jsp/ViewOrderHistoryFrameset.jsp?"+finalString,arguments,features);
          
}   

async function viewOutsourceDtls(orderId, orderLineNum){
	var dialogHeight= "46" ;
	var dialogWidth	= "45" ;
	var dialogTop	= "275" ;
	var dialogLeft	= "200" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "auto";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../ePH/jsp/TrackingOutsourceMedicationFrameSet.jsp?callFrom=VIEWOUTSOURCEDTL&orderId="+orderId+"&orderLineNum="+orderLineNum,arguments,features);
}

async function showClinicalNotes(patient_id,drug_code,srl_no,pat_class,accession_no,facility_id,encounter_id){	
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "40" ;
 	var dialogWidth		= "80" ;
	var dialogLeft		= "180" ;	

 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	var search = "Add"; 
	
 	if(accession_no!="")
 		search = "Search";

 	retVal 			= await top.window.showModalDialog("../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=PH_NOTES&appl_task_id=PH_NOTES&patient_id="+patient_id+"&patient_class="+pat_class+"&accession_num="+accession_no+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&drug_code="+drug_code+"&srl_no="+srl_no+"&appl_task_id=PH_NOTES&title=Pharmacy Notes&window_close=Y&hide_header=N&tab_yn=N&callback_mode="+search+"&called_from=PH_NOTES", arguments, features);
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
async function showAltDrugRemarks(stkey,alt_drug_remarks_ind){
	var dialogHeight= "15" ;
	var dialogWidth	= "40" ;
	var dialogTop = "195" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retRem = await top.window.showModalDialog("../../ePH/jsp/DispMedicationRemarks.jsp?called_from=VIEW&id=Q&alt_drug_remarks_ind="+alt_drug_remarks_ind+"&stkey="+stkey,arguments,features);
}

function checkRemarksMaxLimit(obj,maxLeng, label) {  
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
async function  showFinding(allocate_remarks,fill_remarks,delivery_remarks, allocate_remarks_code, fill_remarks_code, delivery_remarks_code, verify_remarks){ 
	var dialogHeight= "18" ;
	var dialogWidth	= "30" ;
	var dialogTop = "238" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	await top.window.showModalDialog("../../ePH/jsp/DispMedicationFillingRemarks.jsp?called_frm=VIEW&allocate_remarks="+allocate_remarks+"&fill_remarks="+fill_remarks+"&delivery_remarks="+delivery_remarks+"&allocate_remarks_code="+allocate_remarks_code+"&fill_remarks_code="+fill_remarks_code+"&delivery_remarks_code="+delivery_remarks_code+"&title="+getLabel("Common.Findings.label","Common")+"&verify_remarks="+verify_remarks,arguments,features);
}

function ViewHideCriteria(obj, Click_yn){ 
	if(obj.value=='V'){
		obj.value='H';
		obj.title='View Criteria';
		obj.src='../../ePH/images/downarrow.gif';
		parent.parent.QueryPatientDrugProfileFrames.rows="0,*,8%";
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
		parent.parent.QueryPatientDrugProfileFrames.rows="21%,*,8%";
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
} 

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
	var dialogHeight	= '15' ;
	var dialogWidth		= "80";
	var dialogTop		= "190" ;
	var dialogLeft		= "150" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal=await top.window.showModalDialog("../../ePH/jsp/DiscCancelledDrugDetailsDisplay.jsp?disc_cancelled_orders="+encodeURIComponent(disc_cancelled_orders,'UTF-8')+"&drug_name="+drug_name,arguments,features);
}
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

function cleardrug(obj){

	    formObj.drug_name.value = "" ;
		formObj.drug_code.value = "" ;

}

