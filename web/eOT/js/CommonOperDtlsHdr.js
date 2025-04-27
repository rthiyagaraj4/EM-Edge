/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function setInitialValue(tab){
		if(tab=="record_nursing"){
			getSTInterfaceFlag();
		}			
	/*Commented by Suma on jan 08 2010 against incident 18017(This peice of code is not required as the sex value is taken from the database and is assigned to the hidden field in CommonOperDtlsHdr.jsp so no need to ressign this) */
//	var obj=document.CommonOperDtlsHdrForm;	
//		obj.sex.value=obj.sex.DB_VALUE;
		/*ends here*/
	}
async function openDialogWindow(strVal,obj,remarks_size){
    var readOnlyYN = "Y";
	var remarks = document.forms[0].pre_oper_diag.value;
	var remarks_hid = document.forms[0].pre_oper_diag.value;
	remarks = trimString(remarks);
	remarks = encodeURIComponent(remarks);
	title =encodeURIComponent(strVal);
	remarks = encodeURIComponent(remarks);
	var retVal =await  window.showModalDialog("../../eOT/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&size="+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	//retVal = encodeURIComponent(retVal);
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM"){ // This when the user closed the TeaxtArea window with above 'X' 
		document.forms[0].pre_oper_diag.value = remarks_hid;
	}
	else{
		document.forms[0].pre_oper_diag.value = retVal;
	}
}

function setAssignValue(dat){
	return dat;
}



	function docDisableEnable(){
		var formObj = document.CommonOperDtlsHdrForm;
		var document_level = formObj.document_level.value;
		if(document_level!=null && document_level!="" && document_level!="null"){
			formObj.doc_level.value = document_level;
			formObj.doc_level.disabled=true;
		}
	}

	function checkICDPCSMandatoryOperation(){
	    var rows = parent.ObjectCollect.mandatory_proc;
		var flag = true;
		var tab_hide_yn = parent.tab_frame.document.forms[0].tab_hide_yn.value;
		//alert("tab_hide_yn :" +tab_hide_yn);
		//alert("rows[j] :" +rows[j]);
		for(var j in rows) {
			//alert("rows[j] :" +rows[j]);
			//alert("j==== " +j);
			if(rows[j]=="N"){
					//alert("73===")
				flag=false;
				break
			}else
				continue;
		}
		//alert("flag==="+flag)
		return flag;
  }

	function validateSurgeonDocComplete(tab){
	var rows = parent.parent.parent.ObjectCollect.rows;
		var len = parent.parent.parent.ObjectCollect.rowLength;

		var doc_oper_line_sent= parent.parent.frames[4].document.forms[0].doc_oper_line_sent.value;
			var Speciality_code_val= parent.parent.frames[4].document.forms[0].Speciality_code_val.value;

		var len=doc_oper_line_sent.length;
		var oper_line_num="";
		if(len >1)
		{
		 oper_line_num = doc_oper_line_sent.substring(0,len-1);
		}else
		{
			oper_line_num=doc_oper_line_sent;
		}
		/*	var role_id_pract_id="";
		for(var i=0;i<len;i++){
			role_id_pract_id=role_id_pract_id+"@@"+rows[i].role_id+"||"+rows[i].practitioner_id;
			}*/
		 if( tab=="record_surgeon"){ 
			//var formObj = document.CommonOperDtlsHdrForm;  commented by sathish.K on 11-03-2009 for Amazon Changes 
			//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
			var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
			var contr_mod_accession_num = formObj.contr_mod_accession_num.value;
			var oper_num = formObj.oper_num.value;
			var doc_level = formObj.doc_level.value;
			var flag = checkICDPCSMandatoryOperation();	
			if(flag==false){
				//alert("ICD10PCS Details are not entered \n for an Operation");
				alert(getMessage("APP-OT0094","OT"));
				parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
				return false;
			}
			var retVal =  getStatus(contr_mod_accession_num,oper_num,doc_level,oper_line_num,Speciality_code_val);
			retVal = trimString(retVal);
			if(retVal!=null && retVal!="OK" ){
				document.forms[0].doc_complete.checked = false;
				alert(retVal);				
				return false;
			}else
			 {
				validateCheckBox(tab);
			 }
		 } 

	}

/*	function checkICDPCSMandatoryOperation(){
		var rows = parent.ObjectCollect.proc_mandatory
		var tab_hide_yn = parent.tab_frame.document.forms[0].tab_hide_yn.value;
		var checked_flag = true;
		if(tab_hide_yn.value=="N"){
			for(var j in rows){
				if(rows[j]=="Y"){
					continue;
				}else{
					alert("No Association ICDPCS code for Mandatory Operation");
					checked_flag=false;
					break;
				}
			}
		}
		return checked_flag;
	}*/

	function getStatus(str,oper_num,doc_level,oper_line_num,Speciality_code_val){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="TempSurgeonNotesValidation.jsp?contr_mod_accession_num="+str+"&oper_num="+oper_num+"&doc_level="+doc_level+"&oper_line_num="+oper_line_num+"&Speciality_code_val="+Speciality_code_val;
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		return trimString(responseText);
}

	function validateCheckBox(tab){
		 if(tab=="record_nursing" || tab=="record_surgeon" ){ 
			//var formObj = document.CommonOperDtlsHdrForm;commented by sathish.K on 11-03-2009 for Amazon Changes 
			//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
			var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
			var oper_num = formObj.oper_num.value;
			var facility_id = formObj.facility_id.value;
			var rows = parent.ObjectCollect.personnelrows;
			var doc_comp_flag1 = "OFF";
			var doc_comp_flag2 = "OFF";
			//var msg = "AtLeast One Surgeon is required to Complete Documentation";
			var msg = getMessage("APP-OT0095","OT");
			
			var role="";
			var role_1="";
			if(rows!=null && rows.length>0){
				for(i=0;i<rows.length;i++){
					if(rows[i]!=null && rows[i].db_mode!='D') role+=rows[i].role_type+",";
				}
			}
			if(role.length>0){
				if(role.indexOf("OS")>=0 ){
					doc_comp_flag1="ON"
					//formObj.doc_complete.checked = true;
				}
			}
			if( rows.length==0 && doc_comp_flag1=="OFF"){
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var temp_jsp="TempPersonnelValidation.jsp?oper_num="+oper_num+"&facility_id="+facility_id;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				var role_1 = trimString(responseText);
				if(role_1.length>0 && role_1!="NO_REC"){
					//commented subramanian on 23/01/2005 for excluding Anesthestist as Mandatory for documentation complete check box
					//if(role_1.indexOf("OS")>=0 && role_1.indexOf("MA")>=0){
					if(role_1.indexOf("OS")>=0 ){
							//formObj.doc_complete.checked = true;
							doc_comp_flag2="ON";
					}
				}
			}
			
			/*if(rows.length==0){
				alert(msg);
				formObj.doc_complete.checked = false;
				return;
			}*/

			
			/*if(!rows.length>0){
			alert(msg);
			formObj.doc_complete.checked = false;
			return;
			}*/
			
			
			
			//commented subramanian on 23/01/2005 for excluding Anesthestist as Mandatory for documentation complete check box
			/*if(role.length>0){
				if(role.indexOf("OS")>=0 && role.indexOf("MA")>=0){
					doc_comp_flag1="ON"
					//formObj.doc_complete.checked = true;
				}
			}*/
			
			/*else{
				formObj.doc_complete.checked = false;
				alert(msg);
				//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
				//alert(msg);
				//return false;
			}*/
			if(doc_comp_flag1=='OFF' && doc_comp_flag2=='OFF' ) {
				alert(msg);
				document.forms[0].doc_complete.checked = false;
				return;
			}

		
		if(doc_comp_flag1=="ON" || doc_comp_flag2=="ON"){
			var retArray=new Array();
			//var formObj = document.CommonOperDtlsHdrForm;commented by sathish.K on 11-03-2009 for Amazon Changes 
			//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
			var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
			var doc_complete_yn=document.forms[0].doc_complete;
			
			if(doc_complete_yn.checked){
				doc_complete_yn.value="Y";
			}else{
				doc_complete_yn.value="N";
			}
			var	bill_interface_flag_yn =formObj.bill_interface_flag_yn.value; 
			var bill_sub_services_yn=formObj.bill_sub_services_yn.value;
			var patient_id=formObj.patient_id.value;
			var episode_type="";
			var episode_id=formObj.episode_id.value;
			var visit_id=formObj.visit_id.value;
			var encounter_id=formObj.encounter_id.value;
			var pract_id=formObj.surgeon_code.value;
			var locn_code=formObj.source_code.value;
			var patient_class=formObj.patient_class.value;
			var order_catalog_code=formObj.order_catalog_code.value;
			var order_catalog_code=formObj.order_catalog_code.value;
			var surgeon_doc_comp_yn=(document.forms[0].surgeon_doc_comp_yn.checked);
			var oper_num=formObj.oper_num.value;
			var order_id=formObj.order_id.value;
			var sec_key_main_oper_num=oper_num;
			var sec_key_main_order_id=order_id;
			if(patient_class=="DC"){
				episode_type="D";
			}else if(patient_class=="EM"){
				episode_type="E";
			}else if(patient_class=="IP"){
				episode_type="I";
			}else if(patient_class=="OP"){
				episode_type="O";
			}else if(patient_class=="XT"){
				episode_type="R";
			}
		//Newly created for Billing on 03/*11/2008 for SPR 6089 by Rajesh

  		  var oper_rows = parent.ObjectCollect.rows;
		  var insert_oper_flag=false;
		  var len1 = oper_rows.length;		
		  for(var i=0;i<len1;i++){
			  if(oper_rows[i]!=null){
			insert_oper_flag=(oper_rows[i].db_mode=="I" || oper_rows[i].db_mode=="U")?true:false;
			if(insert_oper_flag) break;
			  }
		  }

	/* Commented by DhanasekarV against incident 25572  on 1/11/2012
		  if(insert_oper_flag==true){
		   alert(getMessage("APP-OT0126","OT"));
		   document.forms[0].doc_complete.checked = false;
		   return;
		   } */
		  
			 
		  var rows = parent.ObjectCollect.personnelrows;
		  var len = rows.length;
		  var role_pract_id="";
		  		 

		  for(var i=0;i<len;i++){
				role_pract_id=role_pract_id+rows[i].role_type+"||"+rows[i].practitioner_id+"@@";
		   }

			if(bill_interface_flag_yn=="Y" && bill_sub_services_yn=="Y" && doc_complete_yn.value=="Y"){
					var src_oper_num_yn=chkSourceOperNum();
					if(src_oper_num_yn!=("")){
					sec_key_main_order_id="";
					}
					
retArray=funSurgeryAddlCharges(patient_id,episode_type,episode_id,visit_id,encounter_id,pract_id,locn_code,sec_key_main_oper_num,sec_key_main_order_id,order_catalog_code,role_pract_id);
			
				}
			//formObj.doc_complete.checked = true;
			}else{
				document.forms[0].doc_complete.checked = false;
			}
	}//if condition
}//function



function validatesurgeonchkbox(obj,tab,st_interface_flag)
{
	if(obj.name=="pros_implants_comp")	
	{
		var rows=parent.parent.parent.ObjectCollect.implants_rows;
		var flag=true;
		if(obj.checked==false && document.forms[0].doc_complete.checked==true)
		{
		//alert("Please uncheck Documentation Completion Check Box");
		document.forms[0].doc_complete.checked=false;
		obj.checked=false;
		obj.value="N";
		return false;
		}
		if(obj.checked==true )
		{
			if(st_interface_flag=="Y")
			{
		for(var jj=0;jj<rows.length;jj++) {
		if(rows[jj])
		{
		
		if((rows[jj].Stockavail =="" || rows[jj].Stockavail =="0") && rows[jj].db_mode!='D')
		{
		flag=false;
		alert(getMessage("PRC-OT0054","OT"));
		obj.checked=false;
		break;
		}else
		{
			flag=true;
			obj.checked=true
		}
		}
	    }
		}else
		{
			flag=true;
			obj.checked=true
		}
		}
	if(flag == true)
	{
		obj.value="Y";
	}
	else
	{
		obj.value="N";
	}
	
	}else
	{
			if(obj.checked==true)
			{		
			obj.value="Y";
		}
		else
		{
			obj.value="N";
		}
	}
	
}
	function loadToFrame(){
		var formObj = document.CommonOperDtlsHdrForm;
		var discr_msr_id = formObj.discr_msr_id.value;
		//alert(discr_msr_id);
		var params = formObj.params.value+"&discr_msr_id="+discr_msr_id;
		parent.recovery_frame.location.href="../../eOT/jsp/ChkInRecoveryRoom.jsp?"+params;
		parent.tab_frame.location.href ="../../eOT/jsp/ChkInRecoveryTab.jsp?"+params; 
		//alert(parent.tab_frame.name);
	}

	function loadToSecondFrame(){
		var formObj = document.CommonOperDtlsHdrForm;
		var discr_msr_id = formObj.discr_msr_id.value;
		var speciality_code = formObj.speciality_code.value;
		//alert(discr_msr_id);
		//var params = formObj.params.value+"&discr_msr_id="+discr_msr_id;
		var params = "discr_msr_id="+discr_msr_id+"&speciality_code="+speciality_code+"&"+formObj.params.value ;
		parent.holding_area_frame.location.href ="../../eOT/jsp/HoldingArea.jsp?"+params; 
		//alert(parent.tab_frame.name);
	}

async function searchTheatre(){
	var retVal =  new String();
	var obj=document.forms[0].theatre_code;
	var target=document.forms[0].theatre_desc;
	var argumentArray  = new Array();	
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var tit=encodeURIComponent(getLabel("Common.Theatre.label","Common"));
	var locale = document.forms[0].locale.value;
	var sql="SELECT SHORT_DESC DESCRIPTION, OPER_ROOM_CODE CODE FROM OT_OPER_ROOM_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'  AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 1";
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
		obj.value=arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}

function changeSpeciality(){
	var obj = document.CommonOperDtlsHdrForm.doc_level;
	var doc_level = document.CommonOperDtlsHdrForm.doc_level.value;
	var frmObj = parent.RecordFrame.RecordFrame;
	//alert(parent.RecordFrame.ChildBaseFrame.RecordFrame.name);	//frmObj = 
	if(frmObj==null)
	{

		frmObj = parent.RecordFrame.ChildBaseFrame.RecordFrame;
	}

	if(frmObj!=null){

		frmObj.callPopulateList(doc_level);
	}
	
}

function assignDiagnosistxt(){
	var formObj = document.CommonOperDtlsHdrForm;
	//alert(formObj.diagnosis.value);
	parent.ObjectCollect.diagnosis_text=formObj.diagnosis.value;

	 //alert(parent.ObjectCollect.diagnosis_text);
}

function getSTInterfaceFlag(){
	var formobj=document.forms[0];
/*	var locale=formobj.locale.value;
	var facility_id=formobj.facility_id.value;
	var sql="select st_interface_flag from ot_param_for_facility where operating_facility_id='"+facility_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal= trimString(xmlHttp.responseText);*/
	//var retVal="N";
	/*
	if(retVal=="Y"){
		formobj.document.getElementById("sl_intfc").style.visibility='visible';
	else 	
		formobj.document.getElementById("sl_intfc").style.visibility='hidden';
	*/
	// Commented the above code and modified below by bshankar on 20th Nov 2007 against SCR-2395 
	var nursing_doc_comp_yn = formobj.nursing_doc_comp_yn.value;
	var st_interface_flag = formobj.st_interface_flag.value;

	/* Commented by Bharathi against 44115 on 10/18/2013
		if(st_interface_flag=="Y" && nursing_doc_comp_yn=="N")
			{
				formobj.document.getElementById("sl_intfc").style.visibility='visible';
				formobj.document.getElementById("sl_intfc_vw").style.visibility='visible';
			}
		else if(st_interface_flag=="Y" && nursing_doc_comp_yn=="Y")
			{
				formobj.document.getElementById("sl_intfc_vw").style.visibility='visible';
			}
	*/
	//Added by bharathi against 44115 on 10/18/2013
	if(st_interface_flag=="Y" && nursing_doc_comp_yn=="N" && formobj.document.getElementById("sl_intfc")!=null && 		formobj.document.getElementById("sl_intfc_vw")!=null)
		{
		   document.getElementById("sl_intfc").style.visibility='visible';
	 	   document.getElementById("sl_intfc_vw").style.visibility='visible';
		}
	 else if(st_interface_flag=="Y" && nursing_doc_comp_yn=="Y" && formobj.document.getElementById("sl_intfc_vw")!=null)
	 	{
	 		document.getElementById("sl_intfc_vw").style.visibility='visible';
	 	}
	//Added by bharathi against 44115 on 10/18/2013
//	return retVal;
}
	
async function funSurgeryAddlCharges(patient_id,episode_type,episode_id,visit_id,encounter_id,pract_id,locn_code,sec_key_main_oper_num,sec_key_main_order_id,order_catalog_code,role_pract_id)
{ 
  //var formObj = document.CommonOperDtlsHdrForm;commented by sathish.K on 11-03-2009 for Amazon Changes 
  //NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
  var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
  var oper_num=formObj.oper_num.value;
  var rows = parent.ObjectCollect.personnelrows;
  var len = rows.length;
  var role_pract_id="";
  for(var i=0;i<len;i++){
		role_pract_id=role_pract_id+"@@"+rows[i].role_type+"||"+rows[i].practitioner_id;
   }
  var formObj1 = document.forms[0];
  var center='1';
  var dialogTop = "70";
  var dialogHeight = "42" ;
  var dialogWidth = "70" ;
  var retVal="";
  var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;  

  var arguments = "" ;
  if( rows.length==0){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="TempSurgeonValidation.jsp?func_mode=getPractRoleType&oper_num="+oper_num;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		var retVal = trimString(responseText)
		role_pract_id=retVal;
		var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&pract_id="+pract_id+"&locn_code="+locn_code+"&sec_key_main_oper_num="+sec_key_main_oper_num+"&sec_key_main_order_id="+sec_key_main_order_id+"&str_order_catalog_code="+order_catalog_code+"&role_pract_id="+role_pract_id+"&function_id=EDIT"; 
}else{
        var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&pract_id="+pract_id+"&locn_code="+locn_code+"&sec_key_main_oper_num="+sec_key_main_oper_num+"&sec_key_main_order_id="+sec_key_main_order_id+"&str_order_catalog_code="+order_catalog_code+"&role_pract_id="+role_pract_id+"&function_id=EDIT"; 
}
  retVal=await window.showModalDialog("../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?"+param,arguments,features);
if(retVal!="success"){
		formObj1.doc_complete.checked = false;
  }
  return retVal;
 }

function setChkValue(obj){
	var formObj = document.forms[0];
	var tab=formObj.doc_complete.value;
	if(obj.checked)
		obj.value="Y";
	else{
		obj.value="N";
	}
	return true;
}

async function funSurgeryAddlChargesView(patient_id,episode_type,episode_id,visit_id,encounter_id,pract_id,locn_code,sec_key_main_oper_num,sec_key_main_order_id,order_catalog_code,role_pract_id)
{
 //var formObj = document.CommonOperDtlsHdrForm;commented by sathish.K on 11-03-2009 for Amazon Changes 
 //NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
  var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
  var oper_num=formObj.oper_num.value;
//  var rows = parent.ObjectCollect.personnelrows;
  var rows = parent.ObjectCollect.personnelrows;
  var len = rows.length;
  var role_pract_id="";
  for(var i=0;i<len;i++){
		role_pract_id=role_pract_id+"@@"+rows[i].role_type+"||"+rows[i].practitioner_id;
   }
  //var formObj = document.forms[0];
  var center='1';
  var dialogTop = "70";
  var dialogHeight = "42" ;
  var dialogWidth = "70" ;
  var retVal="";
  var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;  
  if( rows.length==0){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="TempSurgeonValidation.jsp?func_mode=getPractRoleType&oper_num="+oper_num;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		var retVal = trimString(responseText)
		role_pract_id=retVal;
		var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&pract_id="+pract_id+"&locn_code="+locn_code+"&sec_key_main_oper_num="+sec_key_main_oper_num+"&sec_key_main_order_id="+sec_key_main_order_id+"&str_order_catalog_code="+order_catalog_code+"&role_pract_id="+role_pract_id+"&function_id=VIEW"; 
}else{
  var arguments = "" ;
  var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&pract_id="+pract_id+"&locn_code="+locn_code+"&sec_key_main_oper_num="+sec_key_main_oper_num+"&sec_key_main_order_id="+sec_key_main_order_id+"&str_order_catalog_code="+order_catalog_code+"&role_pract_id="+role_pract_id+"&function_id=VIEW"; 
}
 await window.showModalDialog("../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?"+param,arguments,features);
 
 }

function setChkValue(obj){
	var formObj = document.forms[0];
	var tab=formObj.doc_complete.value;
	if(obj.checked)
		obj.value="Y";
	else{
		obj.value="N";
	}
	return true;
}


function chkSourceOperNum(){
	//var formObj = document.CommonOperDtlsHdrForm;commented by sathish.K on 11-03-2009 for Amazon Changes 
	//NOTE:DocumentaionCompleted check box transfered to SurgeonDocStatus.jsp
	var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var oper_num = formObj.oper_num.value;
	var facility_id = formObj.facility_id.value;
	var sql="select source_oper_num from ot_post_oper_hdr where operating_facility_id='"+facility_id+"' and oper_num='"+oper_num+"'";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal= trimString(xmlHttp.responseText);
	return retVal;
}

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

async function callOTSalesWindow() {
        var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
    var oper_num=formObj.oper_num.value;
    var facility_id=formObj.facility_id.value;
        var facility_opernum=facility_id+'@'+oper_num;

//Modified by DhanasekarV against issueIN026316 on 8/02/2011

 var user_id = formObj.slate_user_id.value;
        user_id = user_id.toUpperCase();

var encounter_id= parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.encounter_id.value;

var patient_id =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.patient_id.value;
var p_ord_practitioner_id =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.p_ord_practitioner_id.value;
var store_code="";
var patient_class=parent.common_patient_hdr_frame.CommonOperDtlsHdrForm.patient_class.value;



                var sal_trn_type = "I";
        if (patient_class == "IP") {
                sal_trn_type = "I";
        }
        if (patient_class == "OP") {
                sal_trn_type = "O";
        }
        if (patient_class == "EM") {
                sal_trn_type = "E";
        }
        if (patient_class == "DC") {
                sal_trn_type = "D";
        }


        var retVal = "";
        var dialogHeight = "35";
        var dialogWidth = "65";
        var dialogTop = "140";
        var center = "1";
        var status = "no";
        var tit=encodeURIComponent(getLabel("eOT.ConsumablesUsed.Label","OT"));

        var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";title:"+tit;
        var arguments = "";
        var url = "../../eST/jsp/Sales.jsp?tit="+tit+"&mode=" + MODE_INSERT + "&function_id=ST_SALES&module_id=OT&ref_no="+facility_opernum+"&patient_id="+patient_id+"&encounter="+encounter_id+"&store_code="+ store_code + "&sal_trn_type=" + sal_trn_type+"&p_ord_practitioner_id="+p_ord_practitioner_id+"&slate_user_id="+user_id;



//CS00000010 10003864   
        retVal = await window.showModalDialog(url, arguments, features);
        
}

async function callOTSalesWindowview()
{
	var formObj =parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	    var oper_num=formObj.oper_num.value;
	    var facility_id=formObj.facility_id.value;

	var facility_opernum=facility_id+'@'+oper_num;
	var retVal = "";
	var dialogHeight = "10";
	var dialogWidth = "65";
	var dialogTop = "160";
	var center = "1";
	var status = "no";
	var tit=encodeURIComponent(getLabel("eOT.ViewConsumablesUsed.Label","OT"));

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";title:"+tit;
	var arguments = "";

	var url = "../../eOT/jsp/SalesQuerypage.jsp?tit="+tit+"&mode=" + MODE_INSERT + "&function_id=ST_SALES&module_id=OT&ref_no="+facility_opernum+"&oper_num="+oper_num;
	retVal = await window.showModalDialog(url, arguments, features);
}

function allow_surg_acc(tab,obj2,obj3)
{
	var doc_status_frame_obj = parent.parent.doc_status_frame.SurgeonDocStatusForm;
	var chk_box1 = doc_status_frame_obj.pros_implants_comp;
	var chk_box2 = doc_status_frame_obj.cons_packs_comp;
	var chk_box3 = doc_status_frame_obj.equip_comp;
	var chk_box4 = doc_status_frame_obj.instr_css_comp;
	var flag=true;
if(tab=="record_surgeon")
	{
	/* //Added Against PMG2023-MMS-CRF-0002		
	surgeon_update_notes = doc_status_frame_obj.surgeon_update_notes_yn.value;	
	if(surgeon_update_notes == 'N' || surgeon_update_notes == null || surgeon_update_notes == ''){	
	doc_status_frame_obj.update_notes2.value = 'N';
	}
	//Added Against PMG2023-MMS-CRF-0002 */	
	var chk_box5 = doc_status_frame_obj.oper_proc;
	if(obj3 =="S")
		{
			if(chk_box5.checked==false)
			{
	alert(getMessage("APP-OT0167","OT"));
	document.forms[0].doc_complete.checked=false;
	flag=false;
	return false;
	}else
	{
		flag=true;
	}
		}
if(obj2 =="RS" && flag==true)
{
  if(chk_box1.checked==false)
	{
	alert(getMessage("APP-OT0144","OT"));
	document.forms[0].doc_complete.checked=false;
	flag=false;
	return false;
	}
   else{
	flag=true;
	validateSurgeonDocComplete(tab);
	return true;
  }
}else
		{
	    validateSurgeonDocComplete(tab);
		}
	}
	
	//Added against ML-MMOH-CRF-1936-starts
	var rowsTimeAndDetails = parent.parent.parent.ObjectCollect.time_rows;
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	var facility_id=document.forms[0].facility_id.value;
	var record_surgeon_notes_yn = "";
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
				record_surgeon_notes_yn=arr[1];
				}
		}
		if(rowsTimeAndDetails.length==0 && record_surgeon_notes_yn=='Y')
			{
				alert("Time and Details is not entered!, Please enter.")
				return false;
			}
	//Added against ML-MMOH-CRF-1936-ends

}
