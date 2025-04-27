/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
20/06/2012	  IN033489		Menaka V	 Report header blank in clinical event history.			
14/05/2013	  IN037793		Karthi L	To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.					
04/06/2013    IN001679    Chowminya G     PACS LIVE issue		
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/03/2014	IN047204			Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
01/04/2014	IN048253			Karthi L		01/04/2014		Akbar			Getting Script error when click on External Application link icon.
15/05/2014	IN047205			Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
12/11/2018	IN068797			Prakash C 		15/12/2018		Ramesh G		MMS-DM-SCF-0568
04/03/2019	IN069028		Ramesh G		04/03/2019		Ramesh G		ML-MMOH-CRF-1293
---------------------------------------------------------------------------------------------------------
*/ 
var arrObjects = new Array();
var arrValues = new Array();
var arrClassValues = new Array();

function getMessageFrame()
{
	if(top.content!=null)
	{
	//IN068797 starts
		if(top.content.messageFrame!=undefined)
			return top.content.messageFrame;
		else if(top.messageFrame!=null && top.messageFrame!=undefined)
			return top.messageFrame;
	//IN068797 ends	
	}
	else if(parent.messageFrame != null)
	{
		return parent.messageFrame;
	}
	else if(parent.parent.parent.parent.messageFrame != null)
	{
		return parent.parent.parent.parent.messageFrame;
	}
	else if(parent.parent.parent.parent.parent.messageFrame != null)
	{
		return parent.parent.parent.parent.parent.messageFrame;
	}
}

var messageFrameReference = getMessageFrame();
//included encounter_id IN001679
//IN068797 starts
//function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid,patient_id,completed_date_time,event_desc,encounter_id)
function getFile(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,extimageapplid,patient_id,completed_date_time,event_desc,encounter_id,RepDb,clob_data,facility_id)
//IN068797 ends
{
	
	var completed_date = "";
	var completed_time = "";
	if(patient_id == undefined)
		patient_id = "";
	if(event_desc == undefined)
		event_desc = "";
	if(encounter_id == undefined) //IN001679
		encounter_id = "";	//IN001679
	if(completed_date_time != "" && completed_date_time != undefined ){
		completed_date= completed_date_time.substring(0,10);
		completed_time= completed_date_time.substring(11,19);
	}
	//included encounter_id as hidden value IN001679
//IN068797 starts	
	if(RepDb == undefined){
		RepDb = "";
	}
	if(clob_data == undefined){
		clob_data = "";
	}
//IN068797 ends	
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAOpenExternalApplication.jsp'><input type=hidden name=Histrectype value='"+Histrectype+"'><input type=hidden name=Contrsysid value='"+Contrsysid+"'><input type=hidden name=Accessionnum value='"+encodeURIComponent(Accessionnum)+"'><input type=hidden name=Contrsyseventcode value='"+Contrsyseventcode+"'><input type=hidden name=extimageapplid value='"+extimageapplid+"'><input type=hidden name=patient_id value='"+patient_id+"'><input type=hidden name=completed_date value='"+completed_date+"'><input type=hidden name=completed_time value='"+completed_time+"'><input type=hidden name=event_desc value='"+event_desc+"'><input type=hidden name=encounter_id value='"+encounter_id+"'><input type=hidden name=RepDb value='"+RepDb+"'><input type=hidden name=clob_data value='"+clob_data+"'><input type=hidden name=facility_id value='"+facility_id+"'></form></body></html>"//added Repdb,facility_id and clob_data for IN068797
	
	
	messageFrameReference.document.write(htmlVal);
	messageFrameReference.document.tempForm.submit();
}
// added for IN037793
async function viewUploadedImg(showImageLocn)
{
	var dialogHeight	= "32" ;
	var dialogWidth		= "42" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "140";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	var arguments		="";
	await window.showModalDialog(showImageLocn,"",arguments,features);
}
async function enterQuickText(eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,singleMultiFlag){

	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].enc_id.value;
	var fac_id = document.forms[0].fac_id.value;//IN033489
	var enctr_id = document.forms[0].enctr_id.value;//IN033489
	
	//if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;

	if(singleMultiFlag == null){
		singleMultiFlag='M';
	}

	document.forms[0].txtFlagQuickText.value = 'Y';
	var tempValues = "";
	var count=0;
	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			count++;
		}
	}

/*	if(count == 0 && singleMultiFlag == "M"){
		alert('here');
		alert(getMessage("EVENTS_FOR_QUICKTEXT",'CA'));
		return false;
	}*/
	count =0;

	for(var i=0;i<arrObjects.length;i++){
		if(arrObjects[i] != null){
			tempValues+= "~"+arrValues[i];
			count++;
		}
	}

	if(count == 0){
		tempValues+= "~"+eventDate+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
		count =1;
	}
	if(tempValues != ""){
		tempValues = tempValues.substring(1);
	}
	var dialogHeight= "90vh" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;	
	
	//var retVal = window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&fromFunction=CLINICAL_EVENTS&quickTextCodes="+escape(tempValues)+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count,'',features);
	var retVal = await top.window.showModalDialog("../../eCA/jsp/FlowSheetEventsQuickTextMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&fromFunction=CLINICAL_EVENTS&quickTextCodes="+escape(tempValues)+"&singleMultiFlag="+singleMultiFlag+"&noOfEvents="+count+"&fac_id="+fac_id+"&enctr_id="+enctr_id,'',features);//IN033489
	if(retVal != null && retVal != undefined && retVal != ""){
		self.location.reload();
	}
	return false;
}

/*
function changeColor(sortEventDateTime,classValue,obj,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,rowNum)
 {
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var enc_id = document.forms[0].enc_id.value;
	
//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;
	if(enc_id == "" || enc_id == null) enc_id = "0";
	//encounter_id = enc_id;
	if(encounter_id == "" || encounter_id == null) encounter_id = "0";
	
	rowNum = parseInt(rowNum,10);
	colNum = parseInt(colNum,10);
	
	var addRemove = "Add";
    var comImg = eval("document.getElementById("commImage")"+rowNum);

 	 if(comImg.style.display == 'inline')
	 {
		addRemove = "Remove";
		comImg.style.display = 'none';
	 }
	 else
	 {
		addRemove = "Add";
		comImg.style.position = 'absolute';
		comImg.style.posLeft = 690;
		comImg.style.display = 'inline';
	 }

	var valsToRemove = Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	var valsToSort = Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.parent.parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&sortEventDateTime='+sortEventDateTime+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+encounter_id;
}
*/
function changeColor(obj,encounter_id,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,histDataType,eventDesc,resultNum,textCount,classValue,sortEventDateTime,rowNum,colNum){

	var patient_id = document.dataForm.patient_id.value;
	var enc_id = document.dataForm.enc_id.value;
	
	if(enc_id == "" || enc_id == null) enc_id = "0";	
	if(encounter_id == "" || encounter_id == null) encounter_id = "0";

	rowNum = parseInt(rowNum,10);
	colNum = parseInt(colNum,10);

	
	Accessionnum = unescape(Accessionnum);

	 var addRemove = "Add";
	 var tdObj = document.getElementById("visibility"+rowNum+"ID"+colNum);


	 if(tdObj.className == 'gridDataSelect')
	 {
		addRemove = "Remove";
		tdObj.className = 'gridDataChart';
	 }
	 else
	 {
		 addRemove = "Add";		
		 tdObj.className = 'gridDataSelect';
	 }


	var valsToRemove = encounter_id+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	var valsToSort = encounter_id+"`"+Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+enc_id;

}

function openDoc(patient_id,event_code,event_group,event_desc,facility_id,specimen_no,template_name)
{
	parent.viewResultDataFrame.document.body.innerHTML = '';
	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='OpenDocForm' id='OpenDocForm' method='get' action='../../eCA/jsp/ViewLabWordResultData.jsp'>"+
		"<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>"+
		"<input type='hidden' name='event_code' id='event_code' value='"+event_code+"'>"+
		"<input type='hidden' name='event_group' id='event_group' value='"+event_group+"'>"+
		"<input type='hidden' name='event_desc' id='event_desc' value='"+event_desc+"'>"+
		"<input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'>"+
		"<input type='hidden' name='specimen_no' id='specimen_no' value='"+specimen_no+"'>"+
		"<input type='hidden' name='template_name' id='template_name' value='"+template_name+"'>"+
		"</form></body></html>";
		parent.viewResultDataFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.viewResultDataFrame.document.OpenDocForm.submit();
}
// IN047204 - Start
//function getExtLink(patient_id, encounter_id, accession_no, order_id, facility_id, locale, login_user, resp_id, login_at_ws_no, order_type_code, op_episode_visit_num, attend_practitioner_id, assign_care_locn_type, assign_care_locn_code, visit_adm_date,  patient_class, locn_desc) { // commented for Bru-HIMS-CRF-195.3 - IN047205	
function getExtLink(patient_id, encounter_id, accession_no, order_id, facility_id, locale, login_user, resp_id, login_at_ws_no, order_type_code, op_episode_visit_num, attend_practitioner_id, assign_care_locn_type, assign_care_locn_code, visit_adm_date,  patient_class, locn_desc,ext_image_appli_id, ext_image_obj_id, ext_image_source, ext_srce_doc_ref_no, ext_srce_doc_ref_line_no) {
	//var Ext_Application_ID = 'DMS'; //added for IN048253 
	var Ext_Application_ID = ext_image_appli_id; //IN047205
	var Ext_Function = 'VIEW'; //added for IN048253 
	//var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+accession_no+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class; //commented for IN048253 
	var qry_string =  'P_PATIENT_ID='+patient_id+'&P_EPISODE_ID='+encounter_id+'&P_ACCESSION_NUM='+escape(accession_no)+'&P_ORDER_ID='+order_id+'&P_FACILITY_ID='+facility_id+'&P_LANGUAGE_ID='+locale+'&P_USE_ID='+login_user+'&P_RESP_ID='+resp_id+'&P_WS_NO='+login_at_ws_no+'&P_ORDER_TYPE_CODE='+order_type_code+'&P_ENCNTR_DATE=' +visit_adm_date+'&P_VISIT_ID='+op_episode_visit_num+'&P_PHYSICIAN_ID='+attend_practitioner_id+'&P_LOCN_TYPE='+assign_care_locn_type+'&P_LOCN_CODE='+assign_care_locn_code+'&P_LOC_DESC='+locn_desc+'&P_EPISODE_TYPE='+patient_class+'&P_Ext_Application_ID='+Ext_Application_ID+'&P_Ext_Function='+Ext_Function+'&P_DOC_ID='+ext_image_obj_id; //modified for IN048253 
	dispExtApp(qry_string);	  //dispExtApp function avalible on ExternalApplication.js of eXH Module. 
}
// IN047204 - End
//IN069028 Start.
function getFile_SH(Accessionnum)
{
	var url = "../../eCA/jsp/CAExternalDisplayNotes.jsp?accession_num="+Accessionnum
	window.open(url,'ExternalNotes','toolbar=yes,menubar=yes,scrollbars=yes,height='+screen.height+',width='+screen.width+',top=0,left=0,location=no,fullscreen=no');
}
//IN069028 End.

