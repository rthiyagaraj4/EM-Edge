/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	 Description
-------------------------------------------------------------------------------------------------------------------------------------
19/11/2020		IN067370			Durga Natarajan   A new field by name Speciality will be introduced in �Unsigned Notes List� screen
-------------------------------------------------------------------------------------------------------------------------------------
*/

function reset() {
	if(f_query_add_mod.document.repSectionForNoteType){
	f_query_add_mod.document.repSectionForNoteType.reset() ;
	}
	if(f_query_add_mod.document.repNoteTypeByService){
	f_query_add_mod.document.repNoteTypeByService.reset() ;
	}
	if(f_query_add_mod.document.repNoteTypeForResp){
	f_query_add_mod.document.repNoteTypeForResp.reset() ;
	}
	if(f_query_add_mod.document.repSubSection){
	f_query_add_mod.document.repSubSection.reset() ;
	}
	if(f_query_add_mod.document.repSection){
	f_query_add_mod.document.repSection.reset() ;
	}
	if(f_query_add_mod.document.repNoteType){
	f_query_add_mod.document.repNoteType.reset() ;
	}
	if(f_query_add_mod.document.repTextBlock){
	f_query_add_mod.document.repTextBlock.reset() ;
	}
	if(f_query_add_mod.document.repLocnForPract){
	f_query_add_mod.document.repLocnForPract.reset() ;
	}
	if(f_query_add_mod.document.repUnsignedNote){
	f_query_add_mod.document.repUnsignedNote.reset() ;
	}
}//e.o.reset

function run()
{
	alert(f_query_add_mod.getMessage('GEN_REP','CA'));
if(f_query_add_mod.document.repSectionForNoteType)
{
	if( f_query_add_mod.CheckString('Note Type', f_query_add_mod.document.repSectionForNoteType.p_fr_note_type,f_query_add_mod.document.repSectionForNoteType.p_to_note_type, messageFrame )  )
	f_query_add_mod.document.repSectionForNoteType.submit() ;
}
if(f_query_add_mod.document.repNoteTypeByService)
{
	if( f_query_add_mod.CheckString('Service', f_query_add_mod.document.repNoteTypeByService.p_fr_note_type,f_query_add_mod.document.repNoteTypeByService.p_to_note_type, messageFrame )  )
	//if( f_query_add_mod.CheckString('Note Type', f_query_add_mod.document.repNoteTypeByService.note_type_from,f_query_add_mod.document.repNoteTypeByService.note_type_to, messageFrame )  )
	f_query_add_mod.document.repNoteTypeByService.submit() ;
}

if(f_query_add_mod.document.repNoteTypeForResp)
{
//	if( f_query_add_mod.CheckString('Responsibility', f_query_add_mod.document.repNoteTypeForResp.resp_from,f_query_add_mod.document.repNoteTypeForResp.resp_to, messageFrame )  )
	if( f_query_add_mod.CheckString('Note Type', f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id,f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id, messageFrame )  )
	f_query_add_mod.document.repNoteTypeForResp.submit() ;
}

if(f_query_add_mod.document.repSubSection)
{
	if( f_query_add_mod.CheckString('Sub-Section', f_query_add_mod.document.repSubSection.p_fr_header_code,f_query_add_mod.document.repSubSection.p_to_header_code, messageFrame )  )
	//if( f_query_add_mod.CheckString('Sub-Section', f_query_add_mod.document.repSubSection.ssec_hdg_code_from,f_query_add_mod.document.repSubSection.ssec_hdg_code_to, messageFrame )  )
	f_query_add_mod.document.repSubSection.submit() ;
}

if(f_query_add_mod.document.repSection)
{
	if( f_query_add_mod.CheckString('Section', f_query_add_mod.document.repSection.p_fr_sec_hdg_code,f_query_add_mod.document.repSection.p_to_sec_hdg_code, messageFrame )  )
	f_query_add_mod.document.repSection.submit() ;
}

if(f_query_add_mod.document.repNoteType){
if( f_query_add_mod.CheckString('Note Type', f_query_add_mod.document.repNoteType.p_fr_note_type,f_query_add_mod.document.repNoteType.p_to_note_type, messageFrame )  )
f_query_add_mod.document.repNoteType.submit() ;
}

if(f_query_add_mod.document.repTextBlock){
if( f_query_add_mod.CheckString('Text Block', f_query_add_mod.document.repTextBlock.p_fr_text_blk_id,f_query_add_mod.document.repTextBlock.p_to_text_blk_id, messageFrame )  )
f_query_add_mod.document.repTextBlock.submit() ;
}

if(f_query_add_mod.document.repLocnForPract){
if( f_query_add_mod.CheckString('Practitioner ', f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id,f_query_add_mod.document.repLocnForPract.p_to_practitioner_id, messageFrame )  )
f_query_add_mod.document.repLocnForPract.submit() ;
}
if(f_query_add_mod.document.repUnsignedNote){
	if( f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value==''|| f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value==null){
		f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value='';
	}
	if( f_query_add_mod.document.repUnsignedNote.p_note_type1.value==''|| f_query_add_mod.document.repUnsignedNote.p_note_type1.value==null){
		f_query_add_mod.document.repUnsignedNote.p_note_type.value='';
	}
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.repUnsignedNote.submit() ;
}

}//e.o.run
//GeneralSearch changed to commonlookup
function call_CommonLookup(obj,check)
{
	var p_facility_id=document.repUnsignedNote.p_facility_id.value;
	if(obj.name=='p_practitioner_id1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{			
			//callCommonLookup("P");
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='PractUnsignednote'><input type=hidden name='PageName' id='PageName' value='repUnsignedNote'></form></body></html>";
			//alert(HTMLVal);
			parent.f_query_unsignintermediate.document.write(HTMLVal);				
			if(parent.f_query_unsignintermediate.document.tempform1)
				parent.f_query_unsignintermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='p_note_type1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//callCommonLookup("NT");
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='NoteTypeUnsignednote'><input type=hidden name='PageName' id='PageName' value='repUnsignedNote'></form></body></html>";
			parent.f_query_unsignintermediate.document.write(HTMLVal);				
			if(parent.f_query_unsignintermediate.document.tempform1)
				parent.f_query_unsignintermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='practitioner_type')
	{		
		callCommonLookup("P");
	}	
	else if(obj.name=='btnNoteType')
	{
		callCommonLookup("NT");
	}
}

async function callCommonLookup(check)
{			
			var p_facility_id=document.repUnsignedNote.p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var title="";		
			var  fac_id='';
				/*if(check=="F")
				{
					title="Facility"
					sql="select facility_id code,facility_name description from sm_facility_param where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";
					search_code="facility_id";
					search_desc= "facility_name";
					target=document.forms[0].p_facility;
				}				
				else*/ 
				if(check=="P")
				{
					title="Practitioner";					
					sql=" select distinct b.practitioner_id code, b.practitioner_name description ";
					sql+=" from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where ";
					sql+=" b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2 ";	
					search_code="practitioner_id";
					search_desc= "practitioner_name";
					target=document.repUnsignedNote.p_practitioner_id1;					
				}
				else if(check=="NT")
				{
					title="Note Type";
					sql=" select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2 ";
					search_code="note_type";
					search_desc= "note_type_desc";
					target=document.repUnsignedNote.p_note_type1;
				}
				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = CODE_DESC;
				retArray =await CommonLookup( title,argArray );
				var str =unescape(retArray);
			 	var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{	
					if(check=="P")
					{	
						document.repUnsignedNote.p_practitioner_id1.value= arr[1];						
						document.repUnsignedNote.p_practitioner_id.value= arr[0];
					}
					else if(check=="NT")
					{
						document.repUnsignedNote.p_note_type1.value= arr[1];
						document.repUnsignedNote.p_note_type.value= arr[0];
					}
				}
				else
				{
					if(check=="P")
					{							
						document.repUnsignedNote.p_practitioner_id1.value="";						
						document.repUnsignedNote.p_practitioner_id.value="";						
					}
					else if(check=="NT")
					{
						document.repUnsignedNote.p_note_type1.value="";
						document.repUnsignedNote.p_note_type.value="";
					}	
				}
}
//Function for CA Report
async function callFunction(sql,title,target)
{
	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup(title, argArray );
	return retArray;
 }

//Function for the file name RepUnsignedNoteSearch.jsp-start


async function callPatientSearch()
		{
			var pat_id =await   PatientSearch();

			if(pat_id != null)
			document.forms[0].p_patient_id.value = pat_id;							
		}

function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_frmDate;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			/*obj.select();
			obj.focus();*/
			obj.value="";
		}
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
			msg = msg.replace('$$',label);
			alert(msg);
			/*obj.select();
			obj.focus();*/
			obj.value="";
			return false;
		}
	}
	
	}

}

function Check_Date(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			//obj.select();
			//obj.focus();
			obj.value="";
			return false;
		}
	}	
	}
}


//Function for the file name RepUnsignedNoteSearch.jsp-end

async function getSpecialty(target,code)
{
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= "";
	var sql = "";
		 sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
 		 title =getLabel("Common.speciality.label","Common");
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray =await CommonLookup( title, argArray );
	var str =unescape(retArray);
 	var arr = str.split(",");
	if(retArray != null && retArray !="")
	{
		
		document.forms[0].grp_by_name.value = arr[1];
		document.forms[0].p_specialty_code.value = arr[0];
	}
	else
	{
		document.forms[0].grp_by_name.value = '';
		document.forms[0].p_specialty_code.value = '';
	}
}

