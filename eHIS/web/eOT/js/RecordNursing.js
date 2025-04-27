/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function recordCharges(){
	frmObj = parent.parent.ObjectCollect; 
	var flag2=true;
	var msg = getMessage("NO_CHANGE_TO_SAVE","common");
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var doc_status_frame_obj = parent.parent.doc_status_frame.SurgeonDocStatusForm;
	var params = HdrformObj.params.value;
	var doc_level = HdrformObj.doc_level.value;
	var slate_user_id = frmObj.OperCollectForm.slate_user_id.value;
	var theatre_code = HdrformObj.theatre_code.value
	var surgeon_code = HdrformObj.surgeon_code.value;
	var trfr_to_ot_flag = HdrformObj.trfr_to_ot_flag.value;
	var booking_num=HdrformObj.booking_num.value;
	var patient_id=HdrformObj.patient_id.value;
	/*var nursing_doc_comp_yn=HdrformObj.nursing_doc_comp_yn.value;
	var chk_box = HdrformObj.doc_complete;
	commented by sathish.K on 11-03-2009 for Amazon Changes */
	//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
    var nursing_doc_comp_yn=doc_status_frame_obj.nursing_doc_comp_yn.value;
	var surgeon_doc_comp_yn=doc_status_frame_obj.surgeon_doc_comp_yn.value;
	var chk_box = doc_status_frame_obj.doc_complete;
	var chk_box1 = doc_status_frame_obj.pros_implants_comp;
	var chk_box2 = doc_status_frame_obj.cons_packs_comp;
	var chk_box3 = doc_status_frame_obj.equip_comp;
	var chk_box4 = doc_status_frame_obj.instr_css_comp;
	var implant_entry_cmp_yn1=doc_status_frame_obj.implant_entry_cmp_yn.value;
	var consumable_entry_cmp_yn1=doc_status_frame_obj.consumable_entry_cmp_yn.value;
	var equipment_entry_cmp_yn1=doc_status_frame_obj.equipment_entry_cmp_yn.value;
	var instrument_entry_cmp_yn1=doc_status_frame_obj.instrument_entry_cmp_yn.value;
	var st_interface_flag =HdrformObj.st_interface_flag.value;
	var locale =HdrformObj.locale.value;
	//HdrformObj.st_interface_flag.value;
	var nur_doc_comp_flag="N";
	var doc_complete = "N";
	var pros_implants_compyn="N"; 
	var cons_packs_compyn="N";
	var instr_css_compyn="N";
    var equip_compyn="N";

/*added by Suma ends here*/
		   if(chk_box)
			{
			 if(chk_box.checked==true){
				  nur_doc_comp_flag="Y";
				  doc_complete = "Y";
			 }else{
				  nur_doc_comp_flag="N";
				  doc_complete = "N";
					 
			 }
			}
			 if(chk_box1)
			{
			  if(chk_box1.checked==true){
				 pros_implants_compyn="Y";
			  }else
			{
				   pros_implants_compyn="N";
			  }
			}
		if(chk_box2)
			{
		  if(chk_box2.checked==true){
				 cons_packs_compyn="Y";
			  }else
			{
				   cons_packs_compyn="N";
			  }
			}
		if(chk_box3)
			{
		  if(chk_box3.checked==true){
				 
				equip_compyn="Y";
			  }else
			{
				   equip_compyn="N";
			  }
			}

		if(chk_box4)
			{
		  if(chk_box4.checked==true){
				 instr_css_compyn="Y";
			  }else
			{
				   instr_css_compyn="N";
			  }
			}
/*Added by Suma for checking sales finalization part added on 01/03/2010*/
if(chk_box2)
	{	
		var facility_id=HdrformObj.facility_id.value;
		var oper_num=parent.parent.ObjectCollect.OperCollectForm.oper_num.value;
		var accession_num=facility_id+"@"+ oper_num;
		 if(chk_box2.checked==true){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_for_sales_finalize&accession_num="+accession_num,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal !="0")
		  {
				var msg = getMessage("APP-OT0186","OT");
				flag2=false;
				chk_box2.checked=false;
				cons_packs_compyn="N";
				chk_box.checked=false;
				nur_doc_comp_flag="N";
				 doc_complete = "N";
		  }
	  }
	}
	var flag1=true;
	if(pros_implants_compyn =="Y")
	{
		var rows=parent.parent.parent.ObjectCollect.implants_rows;
			if(st_interface_flag=="Y")
				{
			for(var jj=0;jj<rows.length;jj++) {
			if(rows[jj])
			{
				if((rows[jj].Stockavail =="" || rows[jj].Stockavail =="0") && 	rows[jj].db_mode!='D')
			{
				flag1=false;
				alert(getMessage("PRC-OT0054","OT"));
				chk_box1.checked=false;
				break;
			}else
			{
				flag1=true;
				chk_box1.checked=true
			}
			}
			}
	}
	}
	var DtlformObj = parent.parent.ObjectCollect.OperCollectForm;
	var oper_num = DtlformObj.oper_num.value;
	var checkInTime = '';
	var customerId = '';	
	if(parent.parent.RecordFrame.ImplantsRecordForm != null && parent.parent.RecordFrame.ImplantsRecordForm != "" && parent.parent.RecordFrame.ImplantsRecordForm != "undefined")//Added against 047321 [IN:48637]
	{
		checkInTime = parent.parent.RecordFrame.ImplantsRecordForm.checkInTime.value;
		customerId = parent.parent.RecordFrame.ImplantsRecordForm.customer_id.value;
	}
	//var param = params+"&doc_level="+doc_level+"&oper_num="+oper_num+"&theatre_code="+theatre_code+"&doc_complete="+doc_complete+"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+"&nursing_doc_comp_yn="+nur_doc_comp_flag;
	var param = 	"slate_user_id="+slate_user_id+
					"&doc_level="+doc_level+
					"&oper_num="+oper_num+
					"&theatre_code="+theatre_code+
					"&doc_complete="+doc_complete+
					"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+
					"&nursing_doc_comp_yn="+nur_doc_comp_flag+
					"&surgeon_code="+surgeon_code+
					"&order_id="+HdrformObj.order_id.value+
					"&trfr_to_ot_flag="+trfr_to_ot_flag+
					"&booking_num="+booking_num+
					"&pros_implants_compyn="+pros_implants_compyn+
					"&cons_packs_compyn="+cons_packs_compyn+
					"&equip_compyn="+equip_compyn+
					"&instr_css_compyn="+instr_css_compyn+
					"&st_interface_flag="+st_interface_flag+
					"&locale="+locale+
					"&checkInTime="+checkInTime+
					"&customerId="+customerId+
					"&patient_id="+patient_id;

	if(flag1==true && flag2==true)
	{
	if( ( isRowCommit() && isTheatreNotEmpty() ) || ( chk_box.checked==true && nursing_doc_comp_yn !="Y") || ( chk_box1.checked==true && pros_implants_compyn=="Y") ||( chk_box2.checked==true && cons_packs_compyn=="Y") ||( chk_box3.checked==true && equip_compyn=="Y") || ( chk_box4.checked==true && instr_css_compyn=="Y") ) {
		if(chk_box.checked==false){
			//if(window.confirm("Documentation not completed, Do you want to continue?")==false){
				if(window.confirm(getMessage("APP-OT0078","OT"))==false){
				parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.RecordNursingServlet?'+param;
	// flag variables to decide whether to load at commit time or not.
	var cssd_load_yn	= "N";
	var eqp_load_yn		= "N";
	var cons_load_yn	= "N";
	var imp_load_yn		= "N";

	if(equipment_entry_cmp_yn1 !="Y")
		xmlStr+=frmObj.createXMLForEquipments();
	if(instrument_entry_cmp_yn1 !="Y")
	xmlStr+=frmObj.createXMLForInstruments();
	if(consumable_entry_cmp_yn1 !="Y")
	xmlStr+=frmObj.createXMLForPackage();
	if(implant_entry_cmp_yn1 !="Y")
	xmlStr+=frmObj.createXMLForImplants();

	xmlStr+=frmObj.createXMLForPersonnel();
	xmlStr+=frmObj.createXMLForVisitPersonnel();
	//xmlStr+=frmObj.callSQLVisitTimeInsert();
	xmlStr+=frmObj.createXMLForSpecimenDtls();
	xmlStr+=frmObj.createXMLForDisposalDtls();
	xmlStr+=frmObj.createXMLForTimeAndDetails();
	xmlStr+="</root>";
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	  xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal!=null && retVal!=""){
		  if(retVal == "RECORD_INSERTED"){
			   alert(getMessage("RECORD_INSERTED","SM"));
			   window.returnValue=getMessage("RECORD_INSERTED","SM");
			  window.close();
		   }else{
			   alert(retVal);
			  window.close();
			}
		}
	}else
	{				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	}else
	{							parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
}

function autoPopulate(str){
}

function reset(){
	parent.parent.frames[5].frames[1].document.forms[0].reset();
	parent.parent.frames[5].frames[2].document.forms[0].reset();
	parent.frames[6].document.forms[0].reset();
}

function isTheatreNotEmpty(){
	var theatre=getLabel("Common.Theatre.label","common");
	var HdrformObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var fields = new Array(HdrformObj.theatre_code);
	var names = new Array(theatre);
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function isRowCommit(){
	var per_rows = parent.parent.ObjectCollect.personnelrows;
	var disp_rows = parent.parent.ObjectCollect.disposal_rows;
	var spec_rows = parent.parent.ObjectCollect.specimen_rows;
	var instr_rows = parent.parent.ObjectCollect.instrument_rows;
	var equip_rows = parent.parent.ObjectCollect.equipment_rows;
	var packs_rows = parent.parent.ObjectCollect.packs_rows;
	var implant_rows = parent.parent.ObjectCollect.implants_rows;
	var time_rows = parent.parent.ObjectCollect.time_rows;
	var visit_pers_rows = parent.parent.ObjectCollect.visit_pers_rows;
	var submit_flag = "F";
	var falg_doc_chk="F";

	if(isModified(per_rows)){
		submit_flag = "T";
	}
	if(isModified(disp_rows)){
		submit_flag = "T";
	}
	if(isModified(spec_rows)){
		submit_flag = "T";
	}
	if(isModified(instr_rows)){
		submit_flag = "T";
	}
	if(isModified(equip_rows)){
		submit_flag = "T";
	}
	if(isModified(packs_rows)){
		submit_flag = "T";
	}
	if(isModified(implant_rows)){
		submit_flag = "T";
	}

	if(isModified(time_rows)){
		submit_flag = "T";
	}
	if(isModified(visit_pers_rows)){
		submit_flag = "T";
	}
	if(parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.doc_level.value=="AS")
	{
		falg_doc_chk ="T";
	}
	if(submit_flag.indexOf("T")>=0 || falg_doc_chk.indexOf("T")>=0)
		return true;
	else
		return false;
}

function isModified(rows){
	var modified_flag=false;
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if(rows[i].db_mode!='L'){
					modified_flag=true;
					break;
				}
			} 
			continue;
		}
	}
	return modified_flag;
}

function validateStartDate(obj){
	var	formObj = document.forms[0];
	var procedure_date=formObj.procedure_start_date.value;
	var procedure_time=formObj.procedure_start_time.value;
	var anaesthesia_date = formObj.anaesthesia_start_date.value;
	var anaesthesia_time = formObj.anaesthesia_start_time.value;
	var surgery_date = formObj.surgery_start_date.value;
	var surgery_time = formObj.surgery_start_time.value;

	//Added by Arthi for ML-MMOH-CRF-1936
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	if(isTimeDtlsSurNurAppl=="true"){
		var prep_date = formObj.prep_start_date.value;
		var prep_time = formObj.prep_start_time.value;
	}//End ML-MMOH-CRF-1936

	if(obj.name=="procedure_end_date"){
		if(procedure_date=="" || procedure_time==""){
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  var msgArray = msg.split("&");
		   var anaesthesia_value=getLabel("Common.Anaesthesia.label","common");
		  var procedure_value=getLabel("Common.Procedure.label","common");
		  var startDate_value=getLabel("Common.startdatetime.label","common");
		  alert(msgArray[0]+anaesthesia_value+" "+procedure_value+" "+startDate_value+msgArray[1]);
		}else{
		   showCalendar(obj.name);
		}
	}else if(obj.name=="anaesthesia_end_date"){
		if(anaesthesia_date=="" || anaesthesia_time=="" ){
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 var anaesthesia_value=getLabel("Common.Anaesthesia.label","common");
		  var startDate_value=getLabel("Common.startdatetime.label","common");
		  alert(msgArray[0]+anaesthesia_value+" "+startDate_value+msgArray[1]);
		}else
		  showCalendar(obj.name);
	}else if(obj.name=="surgery_end_date"){
		if(surgery_date=="" || surgery_time=="" ){
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			 if(isTimeDtlsSurNurAppl=="true"){
				 var procedure_value=getLabel("Common.Surgery.label","common");
			 }else{
				 var procedure_value=getLabel("Common.Procedure.label","common");
			 }
			 var startDate_value=getLabel("Common.startdatetime.label","common");
			alert(msgArray[0]+procedure_value+" "+startDate_value+msgArray[1]);

		}else
			showCalendar(obj.name);
	}
	else if(obj.name=="prep_end_date"){
		if(prep_date=="" || prep_time=="" ){
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			 var preparation_value=getLabel("eOT.Preparation.Label","OT");
			 var startDate_value=getLabel("Common.startdatetime.label","common");
			alert(msgArray[0]+preparation_value+" "+startDate_value+msgArray[1]);

		}else
			showCalendar(obj.name);
	}
	  return false;
}


async function searchAnatomicalSite(obj,target){
	var locale = document.forms[0].locale.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Anatomical Site Search";
	var tit=getLabel("Common.AnatomicalSite.label","common");
	var sql="SELECT SHORT_DESC description, ANATOMICAL_SITE_CODE code FROM AM_ANATOMICAL_SITE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E'  and upper(SHORT_DESC) like upper(?) and upper(ANATOMICAL_SITE_CODE) like upper(?) order by 1";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}


async function searchDisposal(obj,target){
	var locale = document.forms[0].locale.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("eOT.Disposal.Label","OT");
	// var sql="SELECT DISPOSAL_DESC DESCRIPTION, DISPOSAL_CODE CODE FROM OT_ORGAN_DISPOSAL WHERE NVL(STATUS,'E') = 'E'  and upper(DISPOSAL_DESC) like upper(?) and upper(DISPOSAL_CODE) like upper(?) order by 1";
   	var sql="SELECT DISPOSAL_DESC DESCRIPTION, DISPOSAL_CODE CODE FROM OT_ORGAN_DISPOSAL_LANG_VW WHERE NVL(STATUS,'E') = 'E'  and upper(DISPOSAL_DESC) like upper(?) and upper(DISPOSAL_CODE) like upper(?) AND LANGUAGE_ID ='"+locale+"' order by 1";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}
async function searchOperations()
{
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("20%,40%,10%,10%");
	var column_descriptions = getLabel('Common.operation.label','common')+','+getLabel('eOT.OperationCode.Label','OT')+','+getLabel('eOT.SideApplicable.Label','OT')+','+getLabel('Common.SpecialtyCode.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT OPER_CODE OPER_CODE1,SHORT_DESC SHORT_DESC1, NVL(APPL_RIGHT_LEFT_FLAG,'N') APPL_RIGHT_LEFT_FLAG1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'");
	var title=getLabel("Common.operation.label","common");
	title=encodeURIComponent(title);
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].oper_code.value=arr[0];
		document.forms[0].oper_desc.value=arr[1];
		document.forms[0].side_applicable.value=arr[2];
		document.forms[0].mode.value='I';
		if(arr[2]!='Y'){
				formObj.side_applicable.value='';
				formObj.side_applicable.disabled=true;
				formObj.imageflag.src="../../eCommon/images/Blank1.gif";
		}else
		  formObj.side_applicable.disabled=false;
		document.forms[0].collect_speciality_code.value+=arr[3]+",";
	}else{
	document.forms[0].oper_code.value='';
	document.forms[0].oper_desc.value='';
	document.forms[0].side_applicable.value='';
	document.forms[0].collect_speciality_code.value='';
	}
}

async function searchDoctor(obj,target){
	var locale = document.forms[0].locale.value;
	var role=getLabel("Common.Role.label","common");
	var role_type=document.forms[0].role_type.value;
	if(role_type!=null && role_type!="" && role_type!="undefined"){
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Selected Role Search" ;
	var tit=role;
	var sql="";

	//Added by Rajesh - 10-Sep-2012
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
    xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_for_speciality",false);
	xmlHttp.send(xmlDoc);
	var facilityVal = trimString(xmlHttp.responseText);
	//Added by Rajesh - 10-Sep-2012
	var splty_value;
	if ( document.forms[0].speciality == null || document.forms[0].speciality == 'undefined')
		 splty_value = '*ALL';
	else
		 splty_value = document.forms[0].speciality.value;

	//Added by lakshmi against SCF-IN26699 filtering by speciality


   // Modified by DhanasekarV against  SCF-IN26699
	//Added by Rajesh - 10-Sep-2012
	if(facilityVal == "SS"){
	  sql = "SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND ( ('*ALL'  = '"+splty_value+"') OR PRACTITIONER_ID IN ( SELECT PRACTITIONER_ID FROM AM_PRACT_SPECIALITIES where SPECIALITY_CODE = '"+splty_value+"' UNION SELECT PRACTITIONER_ID FROM AM_PRACTITIONER where  PRIMARY_SPECIALITY_CODE ='"+splty_value+"' AND PRACT_TYPE IN  ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"') AND NVL(EFF_STATUS,'E') = 'E' )) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
	}
	else{
	  sql = "SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role_type+"')	AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
	}
   
    //Below code is commented by lakshmi against SCF-IN26699 filtering by speciality

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}else{
	//var msg="APP-OT35 Role Cannot be blank...";
	var msg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArr=msg.split("&");
	msg=msgArr[0] + role +msgArr[1];
	parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
}}

async function searchDepartment(obj,target){
	var locale = document.forms[0].locale.value;
	var formObj = document.forms[0];
	var lab_module_yn = formObj.lab_module_yn.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Department"
	var tit=getLabel("Common.department.label","Common");
	//tit=encodeURIComponent(tit);
	tit=decodeURIComponent(tit,"UTF-8").replace(/\+/g," ")

	if(lab_module_yn.indexOf("RL|")!=-1){
			sql="SELECT SHORT_NAME description, SECTION_CODE code FROM RL_SECTION_CODE WHERE NVL(STATUS,'E') = 'E' and  upper(SHORT_NAME) like upper(?) and upper(SECTION_CODE) like upper(?) order by 1";
	}else{
			sql="SELECT SHORT_DESC description, DEPT_CODE code FROM AM_DEPT_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(DEPT_CODE) like upper(?) order by 1";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		obj.value = arr[0];
	}else{
		target.value='';
		obj.value='';
	}
}

function checkLimit(field, limit){
  if (field.value.length > limit){
		   //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

async function searchInstrument(obj,target){
	var frmObj	=document.forms[0];//Added by lakshmi against CRF-0058
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;

	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Instrument";
	var tit=getLabel("Common.Instrument.label","Common");
	var locale = document.forms[0].locale.value;
	
	//Modified by lakshmi against CRF-0058 starts here
	if(frmObj.Ot_param.value=="Y"){
	//Added by Rajesh for CRF-0058 to enable search tro OTGeneralSearch
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "50";
		var arguments = "";
		var desc=target.value;
		if(desc=="%") desc="*All";
		if(desc=="&") desc="~";
		var column_sizes = escape("40%,30%,30%");
		var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common')+','+getLabel('Common.Location.label','Common');
		var column_descriptions=encodeURIComponent(tit);
		var sql_temp ="SELECT LONG_DESC DESCRIPTION, INSTR_CODE CODE,DECODE(LOCATION,NULL,'',LOCATION) LOCATION FROM OT_INSTRUMENT_LANG_VW WHERE NVL(STATUS,'E') = 'E'  AND LANGUAGE_ID='"+locale+"' ";
		var sql=escape(sql_temp);
		var title=getLabel("Common.Instrument.label","common");
		title=encodeURIComponent(title);
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+desc;
		retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
		if(retVal != null && retVal != "" ){
			var arr_loc = retVal.split("::");
			target.value=arr_loc[0];
			if(target.name == desc_name){
				obj.value = arr_loc[1];
				if(arr_loc[2].length>0){
					frmObj.tray_no.value =arr_loc[2];
				}
				else{
					arr_loc[2]='';//
					frmObj.tray_no.value =arr_loc[2];//
				}
			}			
		}else{
				target.value="";
				obj.value="";
				frmObj.tray_no.value ="";
		}
	//Added by Rajesh for CRF-0058 to enable search tro OTGeneralSearch
	}
else{
		var sql="SELECT LONG_DESC DESCRIPTION, INSTR_CODE CODE FROM OT_INSTRUMENT_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"'  ORDER BY 2";

		argumentArray[0] =sql;

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
			if(target.name == desc_name){
				obj.value = arr[0];
				document.forms[0].target.disabled=true;
			}
		}else{
			target.value="";
			obj.value="";
		}
	}
}
//Modified by lakshmi against CRF-0058 ends here

async function searchEquipments(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var customer_id =document.forms[0].customer_id.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var locale = document.forms[0].locale.value;
	var tit=getLabel("eOT.Equipments.Label","OT");
	var sql="SELECT LONG_DESC description, EQUIPMENT_CODE code FROM OT_EQUIPMENT_LANG_VW where LANGUAGE_ID ='"+locale+"'  AND NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(EQUIPMENT_CODE) like upper(?) order by 2";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].equip_id.value = arr[0]; //Changed against 39535 by RameezSK
			document.forms[0].equip_id.disabled=true;  //Changed against 39535 by RameezSK
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}
	//Added newly 29-05-2013 - 091
	if(customer_id =="RTN"){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=call_eq_code&equip_code="+obj.value,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		document.forms[0].st_location.value = ret1;
		document.forms[0].st_location.disabled=true;
		document.forms[0].target.disabled=true;
	}
	else {
		document.forms[0].st_location.value="";
		document.forms[0].st_location.disabled=true;
		document.forms[0].target.disabled=true;
	}
	}
	//Added newly 29-05-2013 -091
}

async function searchPackage(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Package";
	var tit=getLabel("Common.Package.label","Common");
	var locale = document.forms[0].locale.value;
	var sql="SELECT LONG_DESC description, PACKAGE_CODE code FROM OT_PACKAGE_HDR_LANG_VW WHERE NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(PACKAGE_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	var locale = document.forms[0].locale.value;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}
}

function ChkNumber(obj){
	var quantity_value=getLabel("eOT.ActualUnits.Label","OT");
	var stock_val=getLabel("eOT.StockAvailable.Label","OT");
	var quantity=obj.value;
	var fromval=document.forms[0].fromval.value;
	var st_interface_flag=document.forms[0].st_interface_flag.value;
	CheckNum(obj);
	if(obj.value!="" ){


	  if(quantity==0)
		{
	  alert(quantity_value + getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
	  obj.select();
	  obj.focus();
		}
		if(fromval  =="prosimplants" && st_interface_flag =="Y")
		{
			var Stock_avail=document.forms[0].Stockavail.value;
		if(parseInt(Stock_avail) >0)
		{
		if( parseInt(quantity) > parseInt(Stock_avail))
		{
			var msg=getMessage("APP-OT0156","OT");
			alert(msg);
			obj.value="";
		}
		}
	}
	}
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

async function searchProsthesis(obj,target){

	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var locale=document.forms[0].locale.value;
	var formObj = document.forms[0];
	var st_interface_flag=formObj.st_interface_flag.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=encodeURIComponent(getLabel("Common.Implant.label","Common"));

	var sql="SELECT A.SHORT_DESC description, A.PROSTHESIS_CODE code FROM OT_PROSTHESIS_LANG_VW  A WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(PROSTHESIS_CODE) like upper(?) order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}

	if(st_interface_flag=="Y")
	{
		formObj.conns_store.value="";
		formObj.Stockavail.value="";
	}
  }


function assignListItems(code,desc){
	  var formObj=document.forms[0];
	  var descArr=new Array();
	  var codeArr=new Array();
	  descArr=desc.split(",");
	  codeArr=code.split(",");
	  listObj=formObj.speciality;
	  var len=0;
	  len=listObj.length-1;
	  //Added by Selvin against 26700 on 2/18/2013
	  if(isNaN(len)){
	   }else{
	  //List Box length starts from 1 where as array starts from 0
	  for( var co=len;co>=0; co--){
		listObj.remove(co);
	  }
	  for(len=0;len<=codeArr.length-1;len++){
			listObj.options[len]=new Option(descArr[len],codeArr[len]);
		  }
		  }
}

function callPopulateList(flag){
   	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var params = formObj.params.value;
	params = params+"&flag="+flag;
	var temp_jsp="../../servlet/eOT.PopulateListItemServlet?"+params;
	//var temp_jsp="../../servlet/eOT.PopulateListItem.jsp?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	eval(responseText);
}

function checkTimeFormat(obj1,obj2){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	if(obj1.value!=null && obj1.value!="" && obj2.value!=null && obj2.value!=""){
	var time=obj2.value;
	var anaes_strt_dt_time=obj1.value+" "+obj2.value;
	if (chkTime(obj2.value)==false ){
		var errors= getMessage("INVALID_TIME_FMT","SM");
		alert(errors);
		obj2.value='';
		//obj2.focus();
		return false;
	}else{
		if(time.length==5){
		var arr=time.split(":");
			if(arr[0].length!=2 || arr[1].length!=2){
			var errors= getMessage("INVALID_TIME_FMT","SM");
			alert(errors);
			obj2.value='';
			//obj2.focus();
			return false;
			}
		}else{
			var errors= getMessage("INVALID_TIME_FMT","SM");
			alert(errors);
			obj2.value='';
			//obj2.focus();
			return false;
		}
	}

	if(isBeforeNow(anaes_strt_dt_time,'DMYHM',locale)){
			return true;
		}else{
			var msg_1 = getMessage("APP-OT0147","OT");
			alert(msg_1);
			obj2.value='';
			//obj2.focus();
			return false;
		if(obj2.value.substring(4,5) =="")
		{
			obj2.value=obj.value +"0";
		}
		}
	}else{
	alert("Date/Time Field Cannot Be Blank....")
		obj2.select();
	}

}





function chkAnaesProcFromToTime()
{
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.procedure_start_date.value;
	var from_time=formObj.procedure_start_time.value;
	var to_date=formObj.procedure_end_date.value;
	var to_time=formObj.procedure_end_time.value;
	var anaest_strt_in_out_time=from_date+" "+from_time;
	var anaest_end_in_out_time=to_date+" "+to_time;
	if(to_time!="")
	{
		if(!isAfter(anaest_end_in_out_time, anaest_strt_in_out_time, "DMYHM", locale))
		{
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaProcedureStartTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaProcedureEndTime.Label","OT");
				alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
				formObj.procedure_end_date.value="";
			formObj.procedure_end_time.value="";
			return false;
		}
	}

}
//added By Yadav for- 13109
function chkAnPrStTimeAnStTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.procedure_start_date.value;
	var from_time=formObj.procedure_start_time.value;
	var to_date=formObj.anaesthesia_start_date.value;
	var to_time=formObj.anaesthesia_start_time.value;
	var anaest_strt_in_out_time=from_date+" "+from_time;
	var anaest_end_in_out_time=to_date+" "+to_time;
	if(to_time!=""){
	if(!isAfter(anaest_end_in_out_time,anaest_strt_in_out_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaProcedureStartTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaStartTime.Label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
			formObj.anaesthesia_start_time.value="";
			return false;
		}
	else if(anaest_end_in_out_time==anaest_strt_in_out_time){
			var msg_1 = getMessage("APP-OT0103","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaStartTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaProcedureStartTime.Label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
			formObj.anaesthesia_start_time.value="";
			return false;
		}

	}

}
function chkAnPrEdTimeAnEdTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.procedure_end_date.value;
	var from_time=formObj.procedure_end_time.value;
	var to_date=formObj.anaesthesia_end_date.value;
	var to_time=formObj.anaesthesia_end_time.value;
	var anaest_strt_in_out_time=from_date+" "+from_time;
	var anaest_end_in_out_time=to_date+" "+to_time;
	if(to_time!=""){
	if(!isAfter(anaest_end_in_out_time,anaest_strt_in_out_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaProcedureEndTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaEndTime.Label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
			formObj.anaesthesia_end_time.value="";
			return false;
		}
		else if(anaest_end_in_out_time==anaest_strt_in_out_time){
			var msg_1 = getMessage("APP-OT0103","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaEndTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaProcedureEndTime.Label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);
			formObj.anaesthesia_end_time.value="";
			return false;
		}
	}

}

//===========================  13109  ===============================

function chkAnaesFromToTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.anaesthesia_start_date.value;
	var from_time=formObj.anaesthesia_start_time.value;
	var to_date=formObj.anaesthesia_end_date.value;
	var to_time=formObj.anaesthesia_end_time.value;
	var anaest_strt_in_out_time=from_date+" "+from_time;
	var anaest_end_in_out_time=to_date+" "+to_time;
	if(to_time!=""){
	if(!isAfter(anaest_end_in_out_time,anaest_strt_in_out_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.AnaesthesiaStartTime.Label","OT");
			var chk_out_dt_time =getLabel("eOT.AnaesthesiaEndTime.Label","OT");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										formObj.anaesthesia_end_date.value="";
			formObj.anaesthesia_end_time.value="";
			return false;
		}
	}

}




function chkProcFromToTime(){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.surgery_start_date.value;
	var from_time=formObj.surgery_start_time.value;
	var to_date=formObj.surgery_end_date.value;
	var to_time=formObj.surgery_end_time.value;
	var anaest_strt_in_out_time=from_date+" "+from_time;
	var anaest_end_in_out_time=to_date+" "+to_time;

	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936

	if(to_time!=""){
	if(!isAfter(anaest_end_in_out_time,anaest_strt_in_out_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			if(isTimeDtlsSurNurAppl=="true"){
				var checkin_time = getLabel("Common.Surgery.label","common")+" "+getLabel("Common.StartTime.label","common");
				var chk_out_dt_time =getLabel("Common.Surgery.label","common")+" "+getLabel("Common.EndTime.label","common");
			}else{
				var checkin_time = getLabel("eOT.ProcedureStartTime.Label","OT");
				var chk_out_dt_time =getLabel("eOT.ProcedureEndTime.Label","OT");
			}
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);										
			formObj.surgery_end_date.value="";
			formObj.surgery_end_time.value="";
			return false;
		}
	}

}


function formatTime(obj)
{

			if (obj.value.length == 2)
	{
		if (obj.value.substring(1,2) == ':')
		{
			obj.value = '0' + obj.value ;
		}

	}

	if (obj.value.length == 3)
	{
		if (obj.value.substring(0,1) == ':')
		{
			obj.value = '00' + obj.value ;
		}

	}
}

function convertMts(){
	var mts = document.forms[0].preparation_time.value;
	var responseText="";
	if(mts!="" && mts!=null && mts!="null" && mts!="undefined"){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="HoldingAreaValidation.jsp?func_mode=convertMts"+"&mts="+mts;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		trimString(responseText);
	}
	return responseText;
}

function validateEndDate()
{
	//compareDates funciton directly from this js only. not using OTCommon.js compareDates function
	var anaesthesiaProcedureEndTime=getLabel("eOT.AnaesthesiaProcedureEndTime.Label","OT");
	var anaesthesiaProcedureStartTime=getLabel("eOT.AnaesthesiaProcedureStartTime.Label","OT");
	var anaesthesiaEndTime=getLabel("eOT.AnaesthesiaEndTime.Label","OT");
	var anaesthesiaStartTime=getLabel("eOT.AnaesthesiaStartTime.Label","OT");
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	
	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
		var preparationEndTime=getLabel("eOT.Preparation.Label","OT")+" "+getLabel("Common.EndTime.label","common");
		var preparationStartTime=getLabel("eOT.Preparation.Label","OT")+" "+getLabel("Common.StartTime.label","common");
	}
	
	if(isTimeDtlsSurNurAppl=="true"){
		var surgeryEndTime=getLabel("Common.Surgery.label","common")+" "+getLabel("Common.EndTime.label","common");
		var surgeryStartTime=getLabel("Common.Surgery.label","common")+" "+getLabel("Common.StartTime.label","common");
	}else{
		var procedureEndTime=getLabel("eOT.ProcedureEndTime.Label","OT");
		var procedureStartTime=getLabel("eOT.ProcedureStartTime.Label","OT");
	}
	var CheckIntoOR=getLabel("eOT.CheckIntoORTime.Label","OT");

	var formObj = document.NursingTimeRecordForm;
	var locale = formObj.locale.value;
	var flag = true;
	var start_procedure_date = formObj.procedure_start_date.value+" "+formObj.procedure_start_time.value;
	var end_procedure_date = formObj.procedure_end_date.value+" "+formObj.procedure_end_time.value;
	var start_anaesthesia_date = formObj.anaesthesia_start_date.value+" "+formObj.anaesthesia_start_time.value;
	var end_anaesthesia_date =  formObj.anaesthesia_end_date.value+" "+formObj.anaesthesia_end_time.value;
	var start_surgery_date = formObj.surgery_start_date.value+" "+formObj.surgery_start_time.value;
	var end_surgery_date = formObj.surgery_end_date.value+" "+formObj.surgery_end_time.value;
	var check_into_or_time= formObj.check_into_or_time.value
	var procedure_date=formObj.procedure_start_date.value;
	var procedure_time=formObj.procedure_start_time.value;
	var anaesthesia_date = formObj.anaesthesia_start_date.value;
	var anaesthesia_time = formObj.anaesthesia_start_time.value;
	var surgery_date = formObj.surgery_start_date.value;
	var surgery_time = formObj.surgery_start_time.value;
	var sysdate1 = formObj.sysdate1.value;

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
		var start_prep_date = formObj.prep_start_date.value+" "+formObj.prep_start_time.value;
		var end_prep_date =  formObj.prep_end_date.value+" "+formObj.prep_end_time.value;
		var prepr_date = formObj.prep_start_date.value;
		var prepr_time = formObj.prep_start_time.value;
	}

	if(procedure_date !="")
	{
		if( procedure_time=="")
		{
		  //alert("Procedure Start Date/Time Cannot be blank");
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  var procedure_value=getLabel("eOT.AnaesthesiaProcedureStartTime.Label","OT");
		   var msgArray = msg.replace("&",procedure_value);
		  msg=msgArray;
		  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		  flag = false;
		}
	}

   if(trimString(start_procedure_date)=="")
	{
	if(trimString(end_procedure_date)!="")
		{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var anaesthesia_value=getLabel("Common.Anaesthesia.label","common");
		var procedure_value=getLabel("Common.Procedure.label","common");
		var startDate_value=getLabel("Common.startdatetime.label","common");
		var msg1=msgArray[0]+anaesthesia_value+" "+procedure_value+" "+startDate_value+msgArray[1];
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg1;
		flag = false;
		}
	}
    if(trimString(start_anaesthesia_date)=="")
	{
	if(trimString(end_anaesthesia_date)!="")
		{
	    var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var anaesthesia_value=getLabel("Common.Anaesthesia.label","common");
		var startDate_value=getLabel("Common.startdatetime.label","common");
		var msg1=msgArray[0]+anaesthesia_value+" "+startDate_value+msgArray[1];
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg1;
		flag = false;
		}
	}
	 if(trimString(start_surgery_date)=="")
	{
	if(trimString(end_surgery_date)!="")
		{
	    var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		if(isTimeDtlsSurNurAppl=="true"){
			var procedure_value=getLabel("Common.Surgery.label","common");
		}else{
			var procedure_value=getLabel("Common.Procedure.label","common");
		}
		var startDate_value=getLabel("Common.startdatetime.label","common");
		var msg1=msgArray[0]+procedure_value+" "+startDate_value+msgArray[1];
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg1;
		flag = false;
		}
	}
	if(anaesthesia_date !="")
	{
		if( anaesthesia_time=="")
		{
		  //alert("Procedure Start Date/Time Cannot be blank");
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  //var msgArray = msg.split("&");
		   var anaesthesia_value=getLabel("eOT.AnaesthesiaStartTime.Label","OT");
		     var msgArray = msg.replace("&",anaesthesia_value);
		//   msg=msg + " "+msgArray[0]+anaesthesia_value+msgArray[1];
		  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msgArray;
		  flag = false;
		}
	}

	if(surgery_date !="")
	{
		if( surgery_time=="")
		{
		  //alert("Procedure Start Date/Time Cannot be blank");
		  var msg = getMessage("CANNOT_BE_BLANK","OT");
		  if(isTimeDtlsSurNurAppl=="true"){
		    var time_val=getLabel("Common.Surgery.label","common")+" "+getLabel("Common.StartTime.label","common");
		  }else{
			var time_val=getLabel("eOT.ProcedureStartTime.Label","OT");
		  }
		     var msgArray = msg.replace("&",time_val);
		  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msgArray;
		  flag = false;
		}
	}

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
	if(prepr_date !="")
	{
	if( prepr_time=="")
	{
	  var msg = getMessage("CANNOT_BE_BLANK","OT");
	  var prepr_value=getLabel("eOT.Preparation.Label","OT")+" "+getLabel("Common.StartTime.label","common");
	  var msgArray = msg.replace("&",prepr_value);
	  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msgArray;
	  flag = false;
	}
	}

	if(trimString(start_prep_date)=="")
	{
	if(trimString(end_prep_date)!="")
		{
	    var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var prepr_value=getLabel("eOT.Preparation.Label","OT");
		var startDate_value=getLabel("Common.startdatetime.label","common");
		var msg1=msgArray[0]+prepr_value+" "+startDate_value+msgArray[1];
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg1;
		flag = false;
		}
	}
	}//End ML-MMOH-CRF-1936

var returnVal_or_time1 =  compareDates1(check_into_or_time,start_procedure_date,locale,"DMYHM");
	if(returnVal_or_time1==false)
	{
		//var msg = " Anaesthesia Procedure End Time should be >Anaesthesia Procedure Start Time";
		//# Cannot Be Greater Than Or Equal To #----Message key value
		var msg =getMessage("APP-OT0157","OT");
		 msg=msg.replace("#",anaesthesiaProcedureStartTime);
		 msg=msg.replace("$",CheckIntoOR);
		msg=msg + "("+check_into_or_time+")";
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		flag = false;
	}

var returnVal_or_time2 =  compareDates1(check_into_or_time,start_anaesthesia_date,locale,"DMYHM");
	if(returnVal_or_time2==false)
	{
		//var msg = " Anaesthesia Procedure End Time should be >Anaesthesia Procedure Start Time";
		//# Cannot Be Greater Than Or Equal To #----Message key value
		var msg =getMessage("APP-OT0157","OT");
		 msg=msg.replace("#",anaesthesiaStartTime);
		 msg=msg.replace("$",CheckIntoOR);
		msg=msg + "("+check_into_or_time+")";
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		flag = false;
	}

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
		var returnVal_or_time4 =  compareDates1(check_into_or_time,start_prep_date,locale,"DMYHM");
		if(returnVal_or_time4==false)
		{
			var msg =getMessage("APP-OT0157","OT");
			 msg=msg.replace("#",preparationStartTime);
			 msg=msg.replace("$",CheckIntoOR);
			msg=msg + "("+check_into_or_time+")";
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			flag = false;
		}
	}//End ML-MMOH-CRF-1936

	var returnVal_or_time3 =  compareDates1(check_into_or_time,start_surgery_date,locale,"DMYHM");
	if(returnVal_or_time3==false){
		//var msg = " Anaesthesia Procedure End Time should be >Anaesthesia Procedure Start Time";
		//# Cannot Be Greater Than Or Equal To #----Message key value
		var msg =getMessage("APP-OT0157","OT");
		if(isTimeDtlsSurNurAppl=="true"){
			msg=msg.replace("#",surgeryStartTime);
		}else{
			msg=msg.replace("#",procedureStartTime);
		}
		 msg=msg.replace("$",CheckIntoOR);
		msg=msg + "("+check_into_or_time+")";
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		flag = false;
	}
	var returnVal =  compareDates(start_procedure_date,end_procedure_date,locale,"DMYHM");
	if(returnVal==false){
		//var msg = " Anaesthesia Procedure End Time should be >Anaesthesia Procedure Start Time";
		//# Cannot Be Greater Than Or Equal To #----Message key value
		var msg =getMessage("APP-OT0163","OT");
		 msg=msg.replace("#",anaesthesiaProcedureStartTime);
		 msg=msg.replace("$",anaesthesiaProcedureEndTime);
		//msg=mseg + " "+anaesthesiaProcedureStartTime + msgArr[1] + anaesthesiaProcedureEndTime;
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		flag = false;
	}

	if(flag==true){
		var returnVal1 =  compareDates(start_anaesthesia_date,end_anaesthesia_date,locale,"DMYHM");
		if(returnVal1==false){
			//var mesg = "Anaesthesia End Time should be > Anaesthesia  Start Time";
			var mesg =getMessage("APP-OT0163","OT");

			mesg=mesg.replace("#",anaesthesiaStartTime);
			mesg=mesg.replace("$",anaesthesiaEndTime);
			//alert("mesg===="+mesg)
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			flag = false;
		}

		//validation anesthesia start time should be > procedure start time
		var returnVal2 =  compareDates1(start_procedure_date,start_anaesthesia_date,locale,"DMYHM");
		if(returnVal2==false){
			var mesg =getMessage("APP-OT0157","OT");
			 mesg=mesg.replace("#",anaesthesiaStartTime);
			 mesg=mesg.replace("$",anaesthesiaProcedureStartTime);


			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			flag = false;
		}
		/* modifies by yadav 26-08-2009 */
		/*var returnVal3 =  compareDates(start_procedure_date,end_anaesthesia_date,locale,"DMYHM");
		if(returnVal3==false){
			//var mesg = "Anaesthesia End Time should be > Anaesthesia Procedure Start Time";
			var mesg =getMessage("APP-OT0163","OT");
			mesg=mesg.replace("#",anaesthesiaProcedureStartTime);
			mesg=mesg.replace("$",procedureEndTime);
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			flag = false;
		}*/


	}

	if(flag==true){

var returnValone =  compareDates1(start_procedure_date,sysdate1,locale,"DMYHM");
		if(returnValone==false){
			var mesg =getMessage("APP-OT0147","OT");
			//parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			//flag = false;
		}
var returnValtwo =  compareDates1(start_anaesthesia_date,sysdate1,locale,"DMYHM");
		if(returnValtwo==false){
			var mesg =getMessage("APP-OT0147","OT");
		//	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
		//	flag = false;
		}

		var returnValthree =  compareDates1(start_surgery_date,sysdate1,locale,"DMYHM");
		if(returnValthree==false){
			var mesg =getMessage("APP-OT0147","OT");
		//	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
		//	flag = false;
		}

		//Added by Arthi for ML-MMOH-CRF-1936
		if(isTimeDtlsSurNurAppl=="true"){
			var returnValfour =  compareDates1(start_prep_date,sysdate1,locale,"DMYHM");
			if(returnValfour==false){
				var mesg =getMessage("APP-OT0147","OT");
			}
		}//End ML-MMOH-CRF-1936



		if(trimString(start_anaesthesia_date)!="")
		{
		var returnVal1 =  compareDates1(start_anaesthesia_date,start_surgery_date,locale,"DMYHM");
		if(returnVal1==false){
			//var mseg = "Procedure Start Time should be > Anaesthesia Start Time";
			var mesg =getMessage("APP-OT0157","OT");
			if(isTimeDtlsSurNurAppl=="true"){
				mesg=mesg.replace("#",surgeryStartTime);
			}else{
				mesg=mesg.replace("#",procedureStartTime);
			}
			 mesg=mesg.replace("$",anaesthesiaStartTime);

			//mseg=mseg + " "+procedureStartTime + msgArr[1] + anaesthesiaStartTime;

			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			flag = false;
		}
		}
	    else
		{
		var returnVal1 =  compareDates1(start_procedure_date,start_surgery_date,locale,"DMYHM");
		if(returnVal1==false){
			//var mseg = "Procedure Start Time should be > Anaesthesia Start Time";
			var mesg =getMessage("APP-OT0157","OT");
			if(isTimeDtlsSurNurAppl=="true"){
				mesg=mesg.replace("#",surgeryStartTime);
			}else{
				mesg=mesg.replace("#",procedureStartTime);
			}
			 mesg=mesg.replace("$",anaesthesiaProcedureStartTime);

			//mseg=mseg + " "+procedureStartTime + msgArr[1] + anaesthesiaStartTime;

			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
			flag = false;
		}
		}


		var returnVal2 =  compareDates(start_surgery_date,end_surgery_date,locale,"DMYHM");
			if(returnVal2==false){
			//var mseg = "Procedure End Time should be > Procedure Start Time";
			var mesg =getMessage("APP-OT0163","OT");

			//Added by Arthi for ML-MMOH-CRF-1936
			if(isTimeDtlsSurNurAppl=="true"){
				mesg=mesg.replace("#",surgeryStartTime);
				mesg=mesg.replace("$",surgeryEndTime);
			}else{
				mesg=mesg.replace("#",procedureStartTime);
				mesg=mesg.replace("$",procedureEndTime);
			}
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;

			flag = false;
		}
	}

	return flag;
}

async function openDialogWindow(strVal,obj){
  var remarks=obj.remarks;
var size='2000' ;
	await window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function getSysTime(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	return responseText;
}

function assingTime(obj){
	if(obj.value=="")
	obj.value = trimString(getSysTime());
}

function getPositionDesc(practitioner_id){
	var locale = document.forms[0].locale.value;
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT POSITION_DESC FROM AM_PRACTITIONER A,AM_POSITION_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID = '"+practitioner_id+"' AND  A.POSITION_CODE  = B.POSITION_CODE (PLUS) ";
	var params = "sql="+sql+"&flag=PERS_RECORD";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	return responseText;

}

/*function callSQLVisitTimeInsert(){
	var xmlString="";
	var rows_pers=parent.ObjectCollect.visit_pers_rows;
	var rows_time=parent.ObjectCollect.time_rows;
	if( rows_pers!=null && rows_time!=null && rows_pers.length>0 && rows_time.length>0 ){
		for(var i=0;i<rows_time.length;i++){
			if( rows_time[i]!=null && rows_time[i].db_mode=='I'
				&& rows_time[i]!=null && rows_pers[i].db_mode=='I' ) {
			//rows_time[i].verify_flag="ON";
			//rows_pers[i].verify_flag="ON";
			xmlString+=callClubVisitTimeSQL(i);
			}else
				continue;
		}

   }
	return xmlString;
}

function callClubVisitTimeSQL(indx){
	var rows_pers=parent.ObjectCollect.visit_pers_rows[indx];
	var rows_time=parent.ObjectCollect.time_rows[indx];
	var table_name="OT_POST_OPER_DTL2";
	var xmlString="<TIME_DTL"+indx+" ";
	xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
	xmlString+="speciality_code=\""+rows_pers.speciality_code+"\""+" ";
	xmlString+="visit_desc=\""+rows_pers.visit_desc+"\""+" ";
	xmlString+="preparation_time=\""+rows_time.db_preparation_time+"\""+" ";
	xmlString+="procedure_start_time=\""+rows_time.db_procedure_start_time+"\""+" ";
	xmlString+="procedure_end_time=\""+rows_time.db_procedure_end_time+"\""+" ";
	xmlString+="anaesthesia_start_time=\""+rows_time.db_anaesthesia_start_time+"\""+" ";
	xmlString+="anaesthesia_end_time=\""+rows_time.db_anaesthesia_end_time+"\""+" ";
	xmlString+="surgery_start_time=\""+rows_time.db_surgery_start_time+"\""+" ";
	xmlString+="surgery_end_time=\""+rows_time.db_surgery_end_time+"\""+" ";
	xmlString+="db_mode=\""+rows_time.db_mode+"\""+" ";
	xmlString+="table_name=\""+table_name+"\""+" />";
	return xmlString;
}
*/

function showRemarks(obj,str){
	var str = (str.length>35)?split_string(str,35):str;
	var tabdata = "<html><body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=2><b>Visiting Personnel</b></font></th><tr><td class=SEN WRAP>"+str+"</td></tr></table></body></html>";
		document.getElementById("tooltip").innerHTML = tabdata;
		document.getElementById("tooltip").style.top  = obj.offsetTop+15;
		document.getElementById("tooltip").style.left  = obj.offsetLeft+10;
		document.getElementById("tooltip").style.visibility="visible" ;
}

function split_string(str,no_const){
	var arr =new Array();
	var count=k=0;
	for(var j=0;j<str.length;){
		arr[count++]=str.slice(j,k+no_const);
		j=k=k+no_const;
	 }
	 return arr.join("<BR>");
}

function hidePopUp(){
	document.getElementById("tooltip").style.visibility="hidden" ;
}

function assignAutoLength(){}

function CodeArrest()
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4))
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));

}

function compareDates(fromdate,todate,locale,format) {

    var fromarray; var toarray;
	var fromdate = dateUtils(fromdate,locale,format);
	var todate = dateUtils(todate,locale,format);
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");

            var fromtimearray = from_time.split(":");
            var totimearray = to_time.split(":");

			//Commented by lakshmi against skr-scf-0546
			//var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            //var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0],totimearray[0],totimearray[1]);

			//Modified by lakshmi against skr-scf-0546
			var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0],totimearray[0],totimearray[1]);
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}

function compareDates1(fromdate,todate,locale,format) {

    var fromarray; var toarray;
	var fromdate = dateUtils(fromdate,locale,format);
	var todate = dateUtils(todate,locale,format);
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");

            var fromtimearray = from_time.split(":");
            var totimearray = to_time.split(":");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}




function loadDBRows_conspack(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str_conspack,panel_str,key,key_line,req_store_code,reserved_qty, requested_qty,frm_pick_list){
	var objrow = newRow_cons();
	var rows_copk=parent.parent.parent.ObjectCollect.packs_rows;
  var rowLength=parent.parent.parent.parent.ObjectCollect.packs_len;

 if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.package_code=package_code;
	  objrow.package_desc=unescape(package_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;

	  objrow.reserved_qty=reserved_qty;
	  objrow.requested_qty=requested_qty;
	  objrow.frm_pick_list=frm_pick_list;

	  //objrow.remarks=unescape(remarks);
      //objrow.remarks=remarks;Anitha
  	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");

	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str_conspack=bill_str_conspack;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";

	  objrow.req_store_code=req_store_code;
	  rows_copk.push(objrow);

	  }
}

function loadDBRows_pi(tab,oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode,order,bill_str,panel_str,key,key_line,req_store_code,reserved_qty, requested_qty,no_of_units,sale_document_no,sale_document_type,Stockavail,Store_desc,frm_pick_list,db_mode,oper_code_new){
	var objrow = newRow();
	var rows=parent.parent.parent.ObjectCollect.implants_rows;
    var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;
	//alert(rowLength + " / Mode " + mode );
	var row_length_new=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.row_length.value;
	var oper_num=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.oper_num.value;
	var facility_id=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.facility_id.value;


  if(mode=='L'  && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.implant_code=implant_code;
	  objrow.implant_desc=unescape(implant_desc);
	  objrow.Store_desc=unescape(Store_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	  objrow.sale_document_no=sale_document_no;
	  objrow.sale_document_type=sale_document_type;
	  objrow.Stockavail=Stockavail;
		  objrow.frm_pick_list=frm_pick_list;
			var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_for_pick_list&implant_code="+implant_code+"&booking_num="+document.forms[0].booking_num.value+"&facility_id="+facility_id,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
if(retVal !="")
	  {
var arr1=retVal.split(",");
objrow.reserved_qty=arr1[0];
objrow.requested_qty=arr1[1];
	  }

	  objrow.manufacturer=mfgr
	  objrow.batch=batch;
	  //10/18/2010 objrow.remarks=remarks;Anitha
  	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.order=order;
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  objrow.req_store_code=req_store_code;
	  rows.push(objrow);

 if(tab == "record_surgeon")
	{
	 	var oper_code_up=parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_all.value;

	if(oper_code_up !="")
	  {
				var flag_val="N";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=new_operation_acc_value&oper_code="+oper_code_up+"&oper_num="+oper_num+"&facility_id="+facility_id+"&flag="+flag_val,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
	  }
	}

	}else
		{

		 if(tab== "record_surgeon")
	{

			 var oper_code_val_chk=oper_code;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_newacc_exist&oper_code="+oper_code_val_chk+"&oper_num="+oper_num+"&facility_id="+facility_id,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
		if(retVal =="Y" )
			{


			  objrow.oper_code=oper_code;
			  objrow.oper_desc=unescape(oper_desc);
			  objrow.implant_code=implant_code;
			  objrow.implant_desc=unescape(implant_desc);
			  objrow.Store_desc=unescape(Store_desc);
			  objrow.oper_line_no=line_no;
			  objrow.quantity=quantity;
			  objrow.sale_document_no=sale_document_no;
			  objrow.sale_document_type=sale_document_type;
			  objrow.Stockavail=Stockavail;
			  objrow.reserved_qty=reserved_qty;
			  objrow.requested_qty=requested_qty;
			  objrow.frm_pick_list=frm_pick_list;
			  objrow.manufacturer=mfgr
			  objrow.batch=batch;
			  objrow.remarks=unescape(remarks);
			  objrow.order=order;
			  objrow.recId = index;
			  objrow.db_mode=(order==1)?"L":"I";
			  objrow.bill_str=bill_str;
			  objrow.panel_str=panel_str;
			  objrow.key=key;
			  objrow.key_line=key_line;
			  objrow.rate="";
			  objrow.req_store_code=req_store_code;
			  rows.push(objrow);




			}
	}

		}
 if(tab== "record_surgeon")
	{
		if(rowLength ==index)
	{
				var oper_code_up=parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_all.value;

				var flag_val="N";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=new_operation_acc_value&oper_code="+oper_code_up+"&oper_num="+oper_num+"&facility_id="+facility_id+"&flag="+flag_val,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);

	}
	}

}

function loadDBRows_eq(oper_code,oper_desc,line_no,instr_code,equip_desc,tray_no,remarks,oper_line_status,index,mode,order,bill_str,panel_str,key,key_line,frm_pick_list,quantity,st_location, desiredDate){//Added for AMRI CRF 294
  var objrow = newRow_eq();
  var rows=parent.parent.parent.ObjectCollect.equipment_rows;
  var rowLength=parent.parent.parent.ObjectCollect.equipment_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.equip_code=instr_code;
	  objrow.equip_desc=decodeURIComponent(equip_desc,"UTF-8").replace(/\+/g," ");
	  objrow.st_location=st_location;
	  objrow.desiredDate=desiredDate;
	  objrow.oper_line_no=line_no;
	  /*commented by Suma for CRF PMG20089-CRF-0677-OT */ //objrow.equip_id=tray_no;
	  objrow.equip_id=tray_no;
	  objrow.quantity=quantity;
	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_status=oper_line_status; //Added for AMRI CRF 294
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.frm_pick_list=frm_pick_list;
	  objrow.rate="";
	  rows.push(objrow);
	 }

}
function loadDBRows_ic(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,oper_num,mode,order,bill_str,panel_str,key,key_line,frm_pick_list,quantity){

 var objrow = newRow_ic();
  var rows=parent.parent.parent.ObjectCollect.instrument_rows;
  var rowLength=parent.parent.parent.ObjectCollect.instrument_len;


   if(mode=='L' && rowLength==0){

	  var objrow = newRow();
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.instr_code=instr_code;
	  objrow.instr_desc=decodeURIComponent(instr_desc,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_no=line_no;
	  /* commented by Suma for CRF PMG20089-CRF-0677-OT */// objrow.tray_no=tray_no;
	  objrow.tray_no=tray_no;
	  objrow.quantity=quantity;
	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order=order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	   objrow.frm_pick_list=frm_pick_list;
	  objrow.rate="";
	  rows.push(objrow);
	}
}
/*function refresh(){
	 var formObj = document.ImplantsRecordForm;
	 var params = formObj.params.value;
	 parent.ResultsFrame.location.href='../../eOT/jsp/ImplantsDtls.jsp?'+params;

}*/


function refresh_acc(flag_acc,rec_implants_in_nurs_notes_yn,rec_equp_in_nurs_notes_yn,rec_instr_in_nurs_notes_yn,rec_packs_in_nurs_notes_yn,st_interface_flag){
	 var formObj = document.forms[0];
	 var params = formObj.params.value;
		 //commented by Anitha on 11/24/2010 for scf-5515
		 //params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;


	if(flag_acc=="")
	{
		if(parent.ResultsFrame != "undefined")
		parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
	}
}




async function searchStore(obj,target,obj2)
{
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var room_code = document.forms[0].oper_room_code.value;
	var implant_desc=document.forms[0].implant_desc.value;
	if(implant_desc=='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Implant = getLabel("Common.Implant.label","Common");
		msg=msgArray[0]+Implant+msgArray[1];
		alert(msg);
		return false;
	}
	else
	{

   // var room_code = document.forms[0].oper_room_code.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Anatomical Site Search";
	var tit=getLabel("eOT.ConsumptionStore.Label","OT");


	var sql="SELECT B.SHORT_DESC description,A.STORE_CODE  Code FROM OT_STORES_FOR_THEATRE A,MM_STORE_LANG_VW B WHERE A.STORE_CODE   = B.STORE_CODE AND   A.OPERATING_FACILITY_ID ='"+facility_id+"'  AND   OPER_ROOM_CODE ='"+room_code+"' AND   STORE_TYPE   ='R' AND   B.LANGUAGE_ID  = '"+locale+"' AND   B.EFF_STATUS   ='E' and upper(b.SHORT_DESC) like upper(?) and upper(a.STORE_CODE) like upper(?) order by 1 ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].conns_store.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].req_store_code.value = arr[0];
		document.forms[0].conns_store.value=arr[1];
	}else{
		document.forms[0].conns_store.value="";
		document.forms[0].req_store_code.value="";
	}

	var item_id=document.forms[0].implant_code.value;
	var store_code=document.forms[0].req_store_code.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+store_code,false);
	xmlHttp.send(xmlDoc);

	var retVal = localTrimString(xmlHttp.responseText);

	if(retVal =="false")
	{
			alert(getMessage("ITEM_STORE_NOT_FOUND","ST"));
			document.forms[0].conns_store.value="";
			document.forms[0].Stockavail.value="";

	}else if(retVal =="false1")
	{
		alert(getMessage("APP-OT0143","OT"));
		document.forms[0].conns_store.value="";
		document.forms[0].Stockavail.value="";
	}else
	{
	document.forms[0].Stockavail.value=retVal;
	document.forms[0].Stockavail.disabled=true;
	}

	}


}


function expandselec(obj)
{
	 var formObj = parent.ResultsFrame.document.Resultform;
	 var params = "";
	 var fromval="";
	 var from_val_overload="Y";
	 fromval=obj;
	  /*Added by Suma for the incident 16685 to pass the new operation values to Surgical Accessories tab inorder to add the new operation realted surgical accessories. */
	  var oper_code_new="";
	 if(document.forms[0].tab.value == "record_surgeon")
	{
	  oper_code_new= parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_new.value;

	}
	/*16685 changes ends here*/
	  //Added code to check null on 11/23/2010 by Anitha for scf-5515
	if(oper_code_new == null)
		oper_code_new="";

	 //commemted below 2 lines on 11/25/2010 for scf-5515 by Anitha11/25/2010
	 //params=formObj.paramsval.value+"&oper_code_new1="+oper_code_new;
 	 //var url="../../eOT/jsp/ProsthesisImplants.jsp?from_val_overload="+from_val_overload+"&from_values="+obj+"&flag_acc="+flag+"&params="+params;  //commented on 11/25/2010

	 var flag="yes";
	 var url="../../eOT/jsp/ProsthesisImplants.jsp?from_val_overload="+from_val_overload+"&from_values="+obj+"&flag_acc="+flag+"&oper_code_new1="+oper_code_new+"&onLoadFlag=Y";
     parent.ChildBaseFrame.location.href=url;
	 buildTable(obj);
}
function buildTable(obj)
{
	var formObj = parent.ResultsFrame.document.forms[0];
    var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
	var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
	var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
	var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var tab=formObj.tab.value;

	var disable_fields_YN = "";
	var index;
	var addnew_label = getLabel("Common.Add/New.label","Common");

	if(obj!=null && obj!=""){

		if(tab !="record_surgeon")
		{
			if(obj=="prosimplants"){
	        var expand_flag=formObj.flag_PI.value;

			if(expand_flag=="Y")
			{
			//parent.document.getElementById("tab_frame").rows="33%,*";
			parent.ResultsFrame.document.getElementById("menuExpand1").style.display='Inline';
			if(rec_packs_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("Conspack").style.display='none';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='hidden';
			}
			if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='none';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='hidden';
            }
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='none';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='hidden';
			}
			formObj.flag_PI.value="N";
			parent.ResultsFrame.document.getElementById("PI_arrow").src="../../eCommon/images/tree_handledownmiddle.gif";
			}
			else
			{
			parent.ResultsFrame.document.getElementById("menuExpand1").style.display='none';
			if(rec_packs_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("Conspack").style.display='Inline';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='visible';
			}
			if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='Inline';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='visible';
			}
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='Inline';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='visible';
			}
			formObj.flag_PI.value="Y";
			parent.ResultsFrame.document.getElementById("PI_arrow").src="../../eCommon/images/iGridNextNOR16.gif";
			}

		}else if(obj=="Conspack")
		{
			var expand_flag=formObj.flag_CO.value;

			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			parent.ResultsFrame.document.getElementById("menuExpand2").style.display='Inline';


			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='none';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='hidden';
			}
			if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='none';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='hidden';
			}
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='none';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='hidden';
			}
			formObj.flag_CO.value="N";
			parent.ResultsFrame.document.getElementById("CO_arrow").src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			parent.ResultsFrame.document.getElementById("menuExpand2").style.display='none';
			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='Inline';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='visible';
			}
            if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='Inline';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='visible';
			}
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='Inline';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='visible';
			}
			formObj.flag_CO.value="Y";
			parent.ResultsFrame.document.getElementById("CO_arrow").src="../../eCommon/images/iGridNextNOR16.gif";
			}
		}else if(obj=="equipments")
		{
			var expand_flag=formObj.flag_EQ.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			parent.ResultsFrame.document.getElementById("menuExpand3").style.display='Inline';
			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='none';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='hidden';
			}
            if(rec_packs_in_nurs_notes_yn=="Y")
            {
			parent.ResultsFrame.document.getElementById("Conspack").style.display='none';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='hidden';
			}
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='none';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='hidden';
			}
			formObj.flag_EQ.value="N";
			parent.ResultsFrame.document.EQ_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			parent.ResultsFrame.document.getElementById("menuExpand3").style.display='none';
			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='Inline';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='visible';
			}
			 if(rec_packs_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("Conspack").style.display='Inline';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='visible';
			}
			if(rec_instr_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.display='Inline';
			parent.ResultsFrame.document.getElementById("InstruCSSD").style.visibility='visible';
			}
			formObj.flag_EQ.value="Y";
			parent.ResultsFrame.document.EQ_arrow.src="../../eCommon/images/iGridNextNOR16.gif";
			}
		}else if(obj=="InstruCSSD")
		{
			var expand_flag=formObj.flag_IC.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			parent.ResultsFrame.document.getElementById("menuExpand4").style.display='Inline';
			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='none';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='hidden';
			}
			if(rec_packs_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("Conspack").style.display='none';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='hidden';
			}
			 if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='none';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='hidden';
			}

			formObj.flag_IC.value="N";
			parent.ResultsFrame.document.IC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			parent.ResultsFrame.document.getElementById("menuExpand4").style.display='none';
			if(rec_implants_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("prosimplants").style.display='Inline';
			parent.ResultsFrame.document.getElementById("prosimplants").style.visibility='visible';
			}
			if(rec_packs_in_nurs_notes_yn=="Y"){
			parent.ResultsFrame.document.getElementById("Conspack").style.display='Inline';
			parent.ResultsFrame.document.getElementById("Conspack").style.visibility='visible';
			}
			 if(rec_equp_in_nurs_notes_yn=="Y")
			{
			parent.ResultsFrame.document.getElementById("equipments").style.display='Inline';
			parent.ResultsFrame.document.getElementById("equipments").style.visibility='visible';
			}

			formObj.flag_IC.value="Y";
			parent.ResultsFrame.document.IC_arrow.src="../../eCommon/images/iGridNextNOR16.gif";
			}
		}

	}else
	{

	        var expand_flag=formObj.flag_PI.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			parent.ResultsFrame.document.getElementById("menuExpand1").style.display='Inline';
			formObj.flag_PI.value="N";
			parent.ResultsFrame.document.getElementById("PI_arrow").src="../../eCommon/images/tree_handledownmiddle.gif";
			}else
		{
				parent.ResultsFrame.document.getElementById("menuExpand1").style.display='none';
				formObj.flag_PI.value="Y";
				parent.ResultsFrame.document.getElementById("PI_arrow").src="../../eCommon/images/iGridNextNOR16.gif";
			}
	}

	}
 }




 function callBillingWindow_pi(index,frm_pick_list){
	var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var index_val=parseInt(index)+1;

	if(frm_pick_list=="Y")
	 {
	var param = "order_id="+key+"&order_line_num="+index_val+"&called_from=SURG_ACC";
	 }else
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";

	 }
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow_pi(responseText,index,"prosthesis_implants",frm_pick_list);
}

 function callBillingWindow_eq(index,frm_pick_list){
	var rows = parent.parent.parent.ObjectCollect.equipment_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var index_val=parseInt(index)+1;
	if(frm_pick_list =="Y")
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	 }else
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";

	 }
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow_pi(responseText,index,"equipments",frm_pick_list);
}

 function callBillingWindow_inst(index,frm_pick_list){
	var rows = parent.parent.parent.ObjectCollect.instrument_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
		var index_val=parseInt(index)+1;
	if(frm_pick_list =="Y")
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	 }else
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";

	 }
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow_pi(responseText,index,"instruments",frm_pick_list);
}

function callBillingWindow_cp(index,frm_pick_list){
	var rows = parent.parent.parent.ObjectCollect.packs_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var index_val=parseInt(index)+1;

	if(frm_pick_list =="Y")
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	 }else
	 {
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";

	 }

	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow_pi(responseText,index,"consumablepacks",frm_pick_list);
}

async function showBillingWindow_pi(str,index,obj2,frm_pick_list){
	var from_value=obj2;
	var episode_type=parent.frames[1].document.forms[0].episode_type.value;

	if(from_value =="prosthesis_implants")
	{
		var rows =parent.parent.parent.ObjectCollect.implants_rows[index];
	}else if(from_value =="consumablepacks")
	{
		var rows =parent.parent.parent.ObjectCollect.packs_rows[index];
	}else if(from_value =="equipments")
	{
		var rows =parent.parent.parent.ObjectCollect.equipment_rows[index];
	}else if(from_value =="instruments")
	{
		var rows =parent.parent.parent.ObjectCollect.instrument_rows[index];
	}
	var module_id = (rows.order==1)?"OT":"OR"
	var arr = str.split("::");
	var order_id_arr = rows.key.split("@");

	var key=arr[0];
	var key_line_no=rows.key_line;

	var order_id=key;
	var order_line_no=key_line_no;
	var order_catalog_code=arr[2];
	var patient_id = arr[3];
	var episode_type =episode_type;
	var episode_id=arr[5];
	var visit_id=arr[6];
	var encounter_id=arr[7];
	var service_date=arr[8];
	var pract_staff_ind=arr[9];
	var pract_staff_id=arr[10];
	var service_panel_ind=arr[11];
	var service_panel_code=arr[12];
	//var original_qty = rows.quantity;//Commented against SKR-SCF-1233_Muthu-190619
	var original_qty = 1;//Added against SKR-SCF-1216_Muthu-190611
	var revised_qty = rows.quantity;
	var total_qty = rows.quantity;
	var bl_panel_str = rows.panel_str;
	var bean_id="";
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var index_val="";
	//var key_val="";
	if(frm_pick_list =="Y")
	{
		index_val=parseInt(index)+1;
	}else
	{
		index_val=key_line_no;
	}

	var column_descriptions ="";
  var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+rows.key+"&key_line_no="+key_line_no+"&order_id="+rows.key+"&order_line_no="+key_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str;
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);

	if(retVal!=null){
	var retArray  = retVal;

	if(from_value !="consumablepacks")
	{
		var arr = rows.bill_str.split("::");
	if(arr[6]=='L')
	{
		retArray[6]=null;
		retArray[7]=null;
	}

	if(retArray[6]=="")
	{
		rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];
	}else
	{
		rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];
	}
	}else
	{
		var arr = rows.bill_str_conspack.split("::");
	if(arr[6]=='L')
	{
		retArray[6]=null;
		retArray[7]=null;
	}

	if(retArray[6]=="")
	{
		rows.bill_str_conspack = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];
	}else
	{
		rows.bill_str_conspack = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];
	}
	}
	rows.rate = retArray[5];

	if(rows.db_mode!="I"){
		rows.db_mode = (rows.order==1 || rows.order==null || rows.order=="")?"U":"I";
		var pnl_str =  getPanelStr(patient_id,index,from_value);
		rows.panel_str =pnl_str.split("::")[13];
	}
	var pnl_str =  getPanelStr(patient_id,index,from_value);
	rows.panel_str =pnl_str.split("::")[13];

	parent.ResultsFrame.document.forms[0].flag_PI.value="Y";
	parent.ResultsFrame.document.forms[0].flag_CO.value="Y";
	parent.ResultsFrame.document.forms[0].flag_EQ.value="Y";
	parent.ResultsFrame.document.forms[0].flag_IC.value="Y";

	createTable();
	}
}

async function callBillingWindow_st(index,Appr_reqd,include_exclude,total_amt,pat_pay,pat_paid,reason_code,req_store_code,quantity,item_code,tab,override_value,sale_document_no,sale_document_type){
	var patient_id=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.patient_id.value;
	var encounter_id=parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.encounter_id.value;

	if(tab !="record_surgeon")
	{
		var patient_class=parent.parent.frames[4].frames[1].ImplantsRecordForm.patient_class.value;
		var facility_id=parent.parent.frames[4].frames[1].ImplantsRecordForm.facility_id.value;
	}else
	{
		var patient_class=parent.parent.RecordFrame.ChildBaseFrame.ImplantsRecordForm.patient_class.value;
		var facility_id=parent.parent.RecordFrame.ChildBaseFrame.ImplantsRecordForm.facility_id.value;
	}

	var rows =parent.parent.parent.ObjectCollect.implants_rows[index];
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var index_val="";
	var param = "title="+title+"&"+"Appr_reqd="+Appr_reqd+"&"+"include_exclude="+include_exclude+"&"+"total_amt="+total_amt+"&"+"pat_pay="+pat_pay+"&"+"pat_paid="+pat_paid+"&"+"reason_code="+reason_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&req_store_code="+req_store_code+"&quantity="+quantity+"&item_code="+item_code+"&patient_class="+patient_class+"&facility_id="+facility_id+"&sale_doc_no="+sale_document_no+"&sale_doc_type="+sale_document_type+"&override_value="+override_value;
	var retVal = await window.showModalDialog("../../eOT/jsp/ShowbillingST.jsp?"+param,arguments,features);

	if(retVal!=null){
	if(retVal !="CANCEL")
	{
		var retArray  = retVal.split("*");
		var arr = rows.bill_str.split("::");

		rows.bill_str = retArray[2]+"::"+retArray[3]+"::"+retArray[4]+"::"+arr[3]+"::"+retArray[1]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[0]+"::"+retArray[1]+"::"+arr[9];
	}else
	{
		var arr = rows.bill_str.split("::");
		rows.bill_str = arr[0]+"::"+arr[1]+"::"+arr[2]+"::"+arr[3]+"::"+arr[4]+"::"+arr[5]+"::"+arr[6]+"::"+arr[7]+"::"+arr[8]+"::"+arr[9];
	}
	if(rows.db_mode!="I"){
		rows.db_mode = (rows.order==1 || rows.order==null || rows.order=="")?"U":"I";
	}
	parent.ResultsFrame.document.forms[0].flag_PI.value="Y";
	parent.ResultsFrame.document.forms[0].flag_CO.value="Y";
	parent.ResultsFrame.document.forms[0].flag_EQ.value="Y";
	parent.ResultsFrame.document.forms[0].flag_IC.value="Y";
	createTable();
	}
}

function getPanelStr(patient_id,index,from){
	if(from=="prosthesis_implants")
	var rows=parent.parent.parent.ObjectCollect.implants_rows[index];
	else if(from=="consumablepacks")
	var rows=parent.parent.parent.ObjectCollect.packs_rows[index];
	else if(from=="equipments")
	var rows=parent.parent.parent.ObjectCollect.equipment_rows[index];
	else if(from=="instruments")
	var rows=parent.parent.parent.ObjectCollect.instrument_rows[index];

	var order_id = "";
	var order_line_num = "";
	var oper_code = rows.oper_code;
	var key = rows.key;
	var key_line = rows.key_line;

	var param = "key="+key+"&key_line="+key_line+"&order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=SURG_ACC_EDIT";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function allow_surg_acc_nursing(tab,obj1,obj2,obj3,obj4)
{
	var doc_status_frame_obj = parent.parent.doc_status_frame.SurgeonDocStatusForm;
	var chk_box1 = doc_status_frame_obj.pros_implants_comp;
	var chk_box2 = doc_status_frame_obj.cons_packs_comp;
	var chk_box3 = doc_status_frame_obj.equip_comp;
	var chk_box4 = doc_status_frame_obj.instr_css_comp;
	var flag=true;

	//Added against ML-MMOH-CRF-1936-starts
	var rowsTimeAndDetails = parent.parent.parent.ObjectCollect.time_rows;
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	var facility_id=document.forms[0].facility_id.value;
	var record_nursing_notes_yn = "";

		if(isTimeDtlsSurNurAppl=="true"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=getNurSurYn&facility_id="+facility_id;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				if(retVal!=''){
				var arr=retVal.split("::");
				if(arr[0]!=null && arr[0]!="" && arr[0]!="undefined")
				record_nursing_notes_yn=arr[0];
				}
		}
		if(rowsTimeAndDetails.length==0 && record_nursing_notes_yn=='Y')
			{
				alert("Time and Details is not entered!, Please enter.")
				return false;
			}
	//Added against ML-MMOH-CRF-1936-ends

	if((obj1 =="RN" && chk_box1.checked==false) ||  (obj2 =="RN" && chk_box2.checked==false) || (obj3 =="RN" && chk_box3.checked==false) || (obj4 =="RN" && chk_box4.checked==false))
	{
		flag=false;
	}else
	{
		flag=true;
	}

	if(flag==false)
	{
		alert(getMessage("APP-OT0145","OT"));
		flag=false;
		return false;
	}
}

function checkForSpecCharsforIDTime(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

async function viewStaffAssignment(assignmentDate, operRoomCode)
{
	var dialogUrl       = "../../eOT/jsp/StaffAssignmentView.jsp?title=Audit History"+"&assignmentDate="+assignmentDate+"&operRoomCode="+operRoomCode ;
	var dialogArguments = '';
	var dialogFeatures  = "dialogHeight:" + 20 + "; dialogWidth:" + 50 +" ; scroll=auto;resizable:yes; status:" + status;
	await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
}
function showCalWithTime(id, format, showsTime, showsOtherMonths, name) {
	fmt = format;
	{
		calend = format;
	if (showsTime) {
		time = true;
	} else {
		time = false;
	}
	var cal;
	currentDateElement = document.getElementById(id);
	cal = new PopupWindow();
	cal.offsetX = 50;
	cal.offsetY = 50;
	cal.setSize(250, 200);
	cal.autoHide();
	cal.setUrl("../../framework/jsp/Calendar.jsp");
	cal.refresh();
	cal.showPopup(name);
	return false;
	}
}

function validateDate(val){
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;
	if(isValidDateTime(val))
	{

	}
	else
	{
		document.getElementById("desiredDate").value="";
	}
	return false;
}

function isValidDateTime(obj){
	var flag=true;
	if(obj!=""){
		var str=obj;
		var dateValArr = str.split(' ');
		if (dateValArr[0] =="" || dateValArr[1]=="")
		{
			alert(getMessage('INVALID_DATE_FMT','SM'));
			flag=false;
		}
		else
		{
			if(checkDate1(dateValArr[0])==true && checkTime(dateValArr[1])==true)
			{flag=true;}
			else
			{flag=false;}
		}
	}
	return flag;
}

function checkDate1(objval)
{
	var flag=true;
	var RE_NUM =  /^\/?\d+$/;
	var str_date = objval;
	var arr_date = str_date.split('/');
	if (arr_date.length != 3)
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		flag=false;
	}
	else
	{
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		var alphaFilter =/^[0-9]+$/;
	   	if (!(alphaFilter.test(arr_date[2])))  flag=false;

		if (flag==false){
			alert(getMessage('INVALID_DATE_FMT','SM'));
		}
	}

	return flag;
}

function checkTime(timeBox){
	if(timeBox=="" || timeBox==null || typeof timeBox=='undefined' )
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		return false;
	}else
	{
		if(parseInt(timeBox.length)<=parseInt(5))
		{
			time=timeBox;
			time1=time.split(':')
		if (!/\d{2}:\d{2}/.test(time)){
			alert(getMessage('INVALID_DATE_FMT','SM'));
			return false;
		}
		else if (time1[0] >23 || time1[1]>59) {
			alert(getMessage('INVALID_DATE_FMT','SM'));
			return false;
		}
		else
			return true;
		}
	}
}

function chkDateRangeValidity(val)
{
	var locale = document.forms[0].locale.value;
	var checkInDateTime = document.forms[0].checkInTime.value;
	var valDate = val.substring(0, 10);
	if(checkInDateTime!=undefined){
	var checkInTime = checkInDateTime.substring(0, 10);
	}
	var oneWeekDate = document.forms[0].oneWeekDate.value;
	if(isAfter(valDate, oneWeekDate, "DMY", locale))
	{
		alert(getMessage("APP-OT0222","OT"));
		return false;
	}
	else if(isAfter(checkInDateTime, val, "DMYHM", locale))
	{
		alert(getMessage("APP-OT0223","OT") + " " + checkInDateTime);//47546
		return false;
	}
	else
		return true;
}

function checkFieldsOt( fields, names, messageFrame,val) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ )
    {
        if(trimCheck(fields[i].value))
        {
            fields[i].value = trimString(fields[i].value);
			if (val=="Y")
				fields[i].style.backgroundColor='#FFFFFF';
        }
        else
        {
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
			if (val=="Y")
				fields[i].style.backgroundColor='#FFFF66';
		}
    }
    if (errors.length != 0 )
	{
		errors = encodeURIComponent(errors);
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		return false ;
	}
	return true ;
}

//Added for AMRI CRF 294
function deleteRow(oper_code,chk_status){
        var icd_pcs_rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
        var flag=true;
        if(chk_status=='99')
	{
        	getMatchedRow(oper_code);
	}else{
        	reAutoPopulate(oper_code);
	}
}

function getMatchedRow(oper_code){
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var frmRef = parent.parent.ObjectCollect;
	for(j in rows){
	if (oper_code == rows[j].oper_code){
		rows[j].db_mode="D";                       
	}
	}
	if(frmRef.mandatory_proc[oper_code]=="N")
	{
		frmRef.mandatory_proc[oper_code]="Y";
	}
}

function reAutoPopulate(oper_code)
{
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var frmRef = parent.parent.ObjectCollect;
	var count=0;
	for(j in rows){
	if (oper_code == rows[j].oper_code){
	if(rows[j].color=="AUTO" ){}
	else if(rows[j].color=="MANDATORY"){                             
		frmRef.mandatory_proc[oper_code]="N";
	if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked==true)
		parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
	}
	//return j;
	}
	//count++;
	}
	if(frmRef.mandatory_proc[oper_code]=="Y")
	{
  		frmRef.mandatory_proc[oper_code]="N";
      if(parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked==true)
		parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
	}
}
//Added for AMRI CRF 294

//Added by Arthi for ML-MMOH-CRF-1936
function surNurMandatory(){
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	if(isTimeDtlsSurNurAppl=="true"){
	var anes_proc_start_end_time_yn = document.forms[0].anes_proc_start_end_time_yn.value;
	var anes_start_end_time_yn = document.forms[0].anes_start_end_time_yn.value;
	var preparation_start_end_time_yn = document.forms[0].preparation_start_end_time_yn.value;
	var surgery_start_end_time_yn = document.forms[0].surgery_start_end_time_yn.value;
	var record_surgeon_notes_yn = document.forms[0].record_surgeon_notes_yn.value;
	var record_nursing_notes_yn = document.forms[0].record_nursing_notes_yn.value;
	var function_id = document.forms[0].function_id.value;

	if(function_id == '07' && anes_proc_start_end_time_yn == 'Y' && record_surgeon_notes_yn == 'Y'){
		document.getElementById("anesProcmandImgStart").style.visibility='visible';
		document.getElementById("anesProcmandImgEnd").style.visibility='visible';
	}

	if(function_id == '07' && anes_start_end_time_yn == 'Y' && record_surgeon_notes_yn == 'Y'){
		document.getElementById("anesmandImgStart").style.visibility='visible';	
		document.getElementById("anesmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '07' && preparation_start_end_time_yn == 'Y' && record_surgeon_notes_yn == 'Y'){
		document.getElementById("prepmandImgStart").style.visibility='visible';	
		document.getElementById("prepmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '07' && surgery_start_end_time_yn == 'Y' && record_surgeon_notes_yn == 'Y'){
		document.getElementById("surgmandImgStart").style.visibility='visible';	
		document.getElementById("surgmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '08' && anes_proc_start_end_time_yn == 'Y' && record_nursing_notes_yn == 'Y'){
		document.getElementById("anesProcmandImgStart").style.visibility='visible';
		document.getElementById("anesProcmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '08' && anes_start_end_time_yn == 'Y' && record_nursing_notes_yn == 'Y'){
		document.getElementById("anesmandImgStart").style.visibility='visible';	
		document.getElementById("anesmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '08' && preparation_start_end_time_yn == 'Y' && record_nursing_notes_yn == 'Y'){
		document.getElementById("prepmandImgStart").style.visibility='visible';	
		document.getElementById("prepmandImgEnd").style.visibility='visible';	
	}

	if(function_id == '08' && surgery_start_end_time_yn == 'Y' && record_nursing_notes_yn == 'Y'){
		document.getElementById("surgmandImgStart").style.visibility='visible';	
		document.getElementById("surgmandImgEnd").style.visibility='visible';		
	}
	}
}

function chkPrepFromToTime(){

	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var from_date=formObj.prep_start_date.value;
	var from_time=formObj.prep_start_time.value;
	var to_date=formObj.prep_end_date.value;
	var to_time=formObj.prep_end_time.value;
	var prepa_strt_in_out_time=from_date+" "+from_time;
	var prepa_end_in_out_time=to_date+" "+to_time;
	if(to_time!=""){
	if(!isAfter(prepa_end_in_out_time,prepa_strt_in_out_time,"DMYHM",locale)){
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.Preparation.Label","OT")+" "+getLabel("Common.StartTime.label","common");
			var chk_out_dt_time =getLabel("eOT.Preparation.Label","OT")+" "+getLabel("Common.EndTime.label","common");
			alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);									
			formObj.prep_end_date.value="";
			formObj.prep_end_time.value="";
			return false;
		}
	}
}
//End ML-MMOH-CRF-1936

//Added against PMG2023-MMS-CRF-0002
function updatingNotes(){
	var doc_status_frame_obj = parent.parent.doc_status_frame.SurgeonDocStatusForm;
	var doc_complete = doc_status_frame_obj.doc_complete;
	var surgeon_update_notes_yn = doc_status_frame_obj.surgeon_update_notes_yn;
	var update_notes = document.getElementById('update_notes');
	var result = confirm("Documentation Completed will be reverted . Please Confirm");
	if (result == true) {
		update_notes.checked = true;
	}else {
		update_notes.checked = false;
		surgeon_update_notes_yn.value = '';
	}

	if(update_notes.checked == true){
		doc_complete.checked = false;
		doc_complete.disabled = false;
		update_notes.checked = true;
		update_notes.disabled = true;
		surgeon_update_notes_yn.value = 'Y';
	}
}
//Added against PMG2023-MMS-CRF-0002
