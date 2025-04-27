/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
15/12/2011    IN029312      Menaka V 	 Incident No: IN029312 - <Report is printed either through
										 order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
24/02/2012	 IN031116	  Ramesh G	  Report header is overlapping the hospital letter heads & deliverable.
15/03/2012	 IN030419	  Menaka V	  		Clinical Note Logo Header and Report Header .
15/09/2012   IN029712	  Nijithas			Spell check functionality implemented for section templates.
22/09/2012   IN35334	  NijithaS       CRF-CA- AMS-CRF-0020 & Bru-HIMS-CRF-001/06 - Default Spell Checker options are not displayed if "Reset"
05/04/2013	 IN039182	  Chowminya G	 Restrict all users from result linking all diagnosis which are sensitive only  in the clinical notes
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory  results in a clinical note section template does not display neatly .	
23/05/2016	  IN055439		 Karthi L										MO_CRF_20102
28/07/2016	  IN059747		 Karthi L										JD-CRF-0199
20/02/2017	  IN061882		 Karthi L									    ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865		 Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
18/03/2020	IN071264		Nijitha S	 18/03/2020		Ramesh G	   		GHL-CRF-0604
18/11/2020	7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
19/04/2021	6484			Durga Natarajan		19/04/2021		RAMESH G	MO-CRF-20147.7 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/   

function show() {
	parent.window.document.title =getLabel('eCA.EncounterParameter.label','CA');
	//parent.window.document.title = "Encounter Parameter" ;
}
function apply() {
	var fields = new Array (f_query_add_mod.document.note_param_form.days_back_date);
	var names = new Array (getLabel("eCA.Backdate.label",'CA'));	
	//IN071264 starts
	var flag=false;
	if(f_query_add_mod.document.getElementById('allowAutoSaveInNotes_yn').value=='Y'&& f_query_add_mod.document.getElementById('allowAutoSaveInNotes_yn').checked==true){
		if(f_query_add_mod.document.getElementById('auto_Save_Time').value!="")
			 flag=true;
		else 
			{	
			var errors = "" ;	
			  var i="Allow Auto Save For Every ";
				 errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent([i])))+"<br>";
					 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
				return false ;
				}
	}
	else if( f_query_add_mod.document.getElementById("allowAutoSaveInNotes_yn").value=='N'||f_query_add_mod.document.getElementById("allowAutoSaveInNotes_yn").checked==false)
		flag=true;
	//IN071264 ends
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
		if (checkRange('callFromApply'))
		{
			var spell_checker_yn = f_query_add_mod.document.note_param_form.spell_checker_yn.value;
			f_query_add_mod.document.note_param_form.file_size.value = trimString(f_query_add_mod.document.note_param_form.file_size.value)
			f_query_add_mod.document.note_param_form.txtMaxNoImgAllowed.value = trimString(f_query_add_mod.document.note_param_form.txtMaxNoImgAllowed.value)
			if(spell_checker_yn == 'N'){
				f_query_add_mod.document.note_param_form.spell_chk_def_opt.value = "";
			}
			if(flag)//IN071264
			f_query_add_mod.document.note_param_form.submit();
		}
		else{			
			var err_msg = getMessage("FILE_SIZE_LIMIT","CA");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
			return false ;
		}
	}
}
function reset() {
			
				f_query_add_mod.location.reload();
			//f_query_add_mod.document.note_param_form.reload() ;
			//IN35334 Starts
			var spell_cheker_ = f_query_add_mod.document.note_param_form.SpellChecker.value;
			var spell_chk_opt_   = f_query_add_mod.document.note_param_form.spell_chk_def_opt.value;
			if(spell_cheker_ == 'Y'){	
				f_query_add_mod.document.getElementById('SpellCheckDefOptId').style.display='';
				/*f_query_add_mod.document.getElementById('SpellCheckDefOptId1').style.display='';*/
				if(spell_chk_opt_ == 'P')
					f_query_add_mod.document.getElementById("pop").checked=true;
				/*else if(spell_chk_opt_ == 'I')	
					f_query_add_mod.document.getElementById("inl").checked=true;*/
			}else{
				f_query_add_mod.document.getElementById('SpellCheckDefOptId').style.display='none';
				/*f_query_add_mod.document.getElementById('SpellCheckDefOptId1').style.display='none';*/
				}//IN35334 Ends
			allowAutoSave();//IN071264
			
}
//IN071264 starts
function allowAutoSave(){
	 
		if(f_query_add_mod.document.getElementById("allowAutoSaveInNotes_yn").checked){
			f_query_add_mod.document.getElementById("allowAutoSaveForEvery").style='display';	
			f_query_add_mod.document.getElementById("allowAutoSaveInNotes_yn").value="Y";
			 
		}
		else{
			f_query_add_mod.document.getElementById("allowAutoSaveForEvery").style.display='none';
			f_query_add_mod.document.getElementById("allowAutoSaveInNotes_yn").value="N";
		}
		
	
}
//IN071264 ends

/*function checkDuplicate(){
	var dischargSelectedVal =f_query_add_mod.document.note_param_form.dschg_summ_note.value
	var visitSelectedVal =f_query_add_mod.document.note_param_form.visit_summ_note.value
	if(dischargSelectedVal == visitSelectedVal){
		alert('Visit Summary Note should be different from Discharge Summary Note');
		f_query_add_mod.document.note_param_form.visit_summ_note.focus();
		return false;
	}
	return true;
}*/
function onSuccess() {	
	f_query_add_mod.location.reload();
}
function callFingerPrint(obj){
		if (obj.checked ==true)
		{	
				obj.value='Y';
		}else	{
				obj.value='N';
		}
}

//functions for addNoteParam.jsp-starts
function allowPositiveNum(objText)
{
	//alert();
	if(window.event.keyCode >=48 && window.event.keyCode <=57 )
		return true
	
	return false
}
function checkSequence(objSequence)
{
	var errorMessage =""
	 if(parseInt((trimString(objSequence.value),10)) <= 0)
			{
				errorMessage= getMessage["SEQUENCE_NOT_ZERO",'CA'];
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
	if(trimString(objSequence.value) == '-')
	{
				errorMessage= getMessage["NO_SPECIAL_CHARACTER",'CA'];
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
	}
		
}
//functions for addNoteParam.jsp-ends
//added by jupitora on 7/6/2005
	function chopText(elem,limit)
	{
		if(elem.value.length>limit){
		elem.value=elem.value.substring(0,limit);
		//alert('U have typed more than maximum num of characters');
		}
	}

	function OndischargeChange(obj)
{
	
	if(obj.checked)
	{
		
		document.note_param_form.print_dischar.value = 'Y'
		
	}
	else
	{
		
		document.note_param_form.print_dischar.value = 'N'
		
	}

}
//IN029312 Starts
function OnclinicalEvthdrChange(obj)
{
	
	if(obj.checked)
	{
		
		document.note_param_form.print_clinical_evt_hrd.value = 'Y'
		
	}
	else
	{
		
		document.note_param_form.print_clinical_evt_hrd.value = 'N'
		
	}

}
//IN029312 Ends
//IN030419 Starts
function OnlogoHdrChange(obj)
{
	if(obj.checked)
	{
		document.note_param_form.print_logo_hdr_in_all_pages.value = 'Y'
	}
	else
	{
		document.note_param_form.print_logo_hdr_in_all_pages.value = 'N'
	}
}
function OnRptHdrChange(obj)
{
	if(obj.checked)
	{
		document.note_param_form.print_rpt_hdr_in_all_pages.value = 'Y'
	}
	else
	{
		document.note_param_form.print_rpt_hdr_in_all_pages.value = 'N'
	}
}
//IN030419 Ends
function checkNumber(obj)
{
	if (obj.value !='')
	{
		obj.value = trimString(obj.value)
		var no = parseInt(obj.value);

		if (no == 0)
		{
			obj.value = 1;
			return;
		}

		if( no < 1 || no > 25)
		{
			var msg =  getMessage("MIN_MAX_VALUE_RANGE","CA");
			msg = msg.replace("(1)", "1");
			msg = msg.replace("(2)", "25");
			alert(msg);
			obj.focus();
		}

		if (obj.value == '')
		{
			obj.value = 1;
		}

	}
	else
	{
		obj.value = 1;
	}
}
//IN068669 starts
function checkNumberRange(obj)
{
	var logo_value = parseInt(obj.value);//IN068669
		
	if(!(logo_value>=40&&logo_value<=96))
	{
		var msg =  getMessage("NUMBER_TO_BE_ENTERED","CA");
		alert(msg);
		obj.focus();		
	}
}
//IN068669 ends
function checkRange(callFrom)
{
	var obj;
	var sizeUnit;
	if (callFrom != undefined && callFrom == 'callFromApply')
	{
		obj =  f_query_add_mod.document.getElementById('file_size');
		sizeUnit = f_query_add_mod.document.getElementById('email_size_unit').value;
	}
	else
	{
		obj =  document.getElementById('file_size');
		sizeUnit = document.getElementById('email_size_unit').value;
	}
	
	var size;
	if (obj.value != '')
	{		
		size = parseFloat(trimString(obj.value));
		if (sizeUnit == 'K')
		{
			size = size/1024;
		}
	}
	return size > 20? false:true;
}
//[IN031116] Starts
function OnHdrFooterChange(obj)
{
	
	if(obj.checked)
	{
		
		document.note_param_form.hdrfoot_margin_val.value = 'Y'
		
	}
	else
	{
		
		document.note_param_form.hdrfoot_margin_val.value = 'N'
		
	}

}
//[IN031116] Ends
//IN029712 Starts
function OnSpellCheckerChange(obj){
	if(obj.checked)
	{
		document.note_param_form.spell_checker_yn.value = 'Y';
		document.getElementById('SpellCheckDefOptId').style.display='';
		/*document.getElementById('SpellCheckDefOptId1').style.display='';
		var spell_chk_opt_   = document.note_param_form.spell_chk_def_opt.value;
		if(spell_chk_opt_ == 'I'){	
			document.getElementById("inl").checked=true;
			document.note_param_form.spell_chk_def_opt.value = "I";
		}else{
			document.getElementById("pop").checked=true;
			document.note_param_form.spell_chk_def_opt.value = "P";
		}*/
		document.getElementById("pop").checked=true;
		document.note_param_form.spell_chk_def_opt.value = "P";
	}
	else
	{
		document.note_param_form.spell_checker_yn.value = 'N';
		document.getElementById('SpellCheckDefOptId').style.display='none';
		/*document.getElementById('SpellCheckDefOptId1').style.display='none';*/
	}
}

function spellCheckerDefaultChange(obj){
	document.note_param_form.spell_chk_def_opt.value = obj.value;
	if(document.note_param_form.spell_checker_yn.value == 'N'){
		document.note_param_form.spell_chk_def_opt.value = "";
	}
}
//IN029712 Ends

//IN039182 - Start
function linkSensitiveChange(obj){
	if(obj.checked)
	{
		document.note_param_form.rstl_lnk_sensidiag_yn.value = 'Y'
	}
	else
	{
		document.note_param_form.rstl_lnk_sensidiag_yn.value = 'N'
	}
}
//IN039182 - End
//IN041284 - Start
function DisplayResultLinkinHTMLChange(obj){
	if(obj.checked)
	{
		document.note_param_form.display_result_linkin_HTML_yn.value = 'Y';
	}
	else
	{
		document.note_param_form.display_result_linkin_HTML_yn.value = 'N';
	}
}
//IN041284 - End
function checkTextFormatDflt(obj){ // MO_CRF_20102[IN055439] - Start		
	if(obj.checked)
	{
		document.note_param_form.text_format_default_yn.value = 'Y';
	}
	else
	{
		document.note_param_form.text_format_default_yn.value = 'N';
	}
}
//MO_CRF_20102[IN055439] - End		
//JD-CRF-0199 [IN059747] - Start
function checkAmendClinResultNote(obj) {
	if(obj.checked == true)
		document.forms[0].amend_result_note_yn.value = 'Y';
	else
		document.forms[0].amend_result_note_yn.value = 'N';
}
//JD-CRF-0199 [IN059747] - End
//ML-MMOH-CRF-0534 [IN061882] - Start
function checkDispRefRange(obj){
	if(obj.checked == true)
		document.forms[0].disable_ref_range_yn.value = 'Y';
	else
		document.forms[0].disable_ref_range_yn.value = 'N';
}
function checkDispSpecType(obj){
	if(obj.checked == true)
		document.forms[0].disable_spec_type_yn.value = 'Y';
	else
		document.forms[0].disable_spec_type_yn.value = 'N';
}
//ML-MMOH-CRF-0534 [IN061882] - End
//ML-MMOH-CRF-0534.1 [IN063865] - Start
function checkDateTimeFormat(obj){
	if(obj.checked == true)
		document.forms[0].datetime_format_yn.value = 'Y';
	else
		document.forms[0].datetime_format_yn.value = 'N';
}
//ML-MMOH-CRF-0534.1 [IN063865] - End

//IN066108 start
function checkInError(obj){
	if(obj.checked == true){
		document.forms[0].access_inError_yn.value = 'Y';
	}
	else{
		document.forms[0].access_inError_yn.value = 'N';
	}
}
function checkUnsign(obj){
	if(obj.checked == true){
		document.forms[0].accessRightsUnsignedNotes_yn.value = 'Y';
	}
	else{
		document.forms[0].accessRightsUnsignedNotes_yn.value = 'N';
	}
}

//IN066108 end
//IN071264 starts
function checkAutoSave(obj){
	var chk = obj.checked;

	if(chk){
		document.note_param_form.auto_Save_YN.value = "Y";
		document.getElementById("allowAutoSaveForEvery").style='display';
	}else{
		document.note_param_form.auto_Save_YN.value = "N";
		document.getElementById("allowAutoSaveForEvery").style.display='none';
		
	}
				
}
function autoSaveForEvery(obj){
	
	document.note_param_form.auto_Save_Time.value=obj.value;
}
function isValidInteger() {
	var key = window.event.keyCode;
	if (!(key > 48 && key <= 57)) {
		return false;
	} else {
		return true;
	}
} 
 function copyPasteChk(obj){
	
	 if(!(obj.value>0 && obj.value<=9)){
		 obj.value="";
		 obj.focus();
	 }
		 
 }
 function checkForMandatory(obj){
     var errors = "" ;	
	  var i="Allow Auto Save For Every ";
	   if(obj.value==""){
		 errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent([i])))+"<br>";
			parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
		 obj.focus();
		
	 }
}

  //IN071264 ends
  //7605 starts
function SelectBox(obj)
{
	if(obj.checked==true){
		document.getElementById("disp_note_description").value='Y';
		document.getElementById("disp_note_description").checked=true;
	}
	else{
		document.getElementById("disp_note_description").value='N';
		document.getElementById("disp_note_description").checked=false;	
	}
}// 7605 ends

//6484 starts
function checkBox(obj)
{
	if(obj.checked==true){
		document.getElementById("comp_note_content_YN").value='Y';
		document.getElementById("comp_note_content_YN").checked=true;
	}
	else{
		document.getElementById("comp_note_content_YN").value='N';
		document.getElementById("comp_note_content_YN").checked=false;	
	}
}
//6484 ends
 
