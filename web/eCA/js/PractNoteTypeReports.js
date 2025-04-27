function run(){
	alert(f_query_rep.getMessage('GEN_REP','CA'));
if(f_query_rep.document.practNoteTypeReports)
{
	if( f_query_rep.document.practNoteTypeReports.fm_pract1.value==''||  f_query_rep.document.practNoteTypeReports.fm_pract1.value==null){
		 f_query_rep.document.practNoteTypeReports.fm_pract.value='';
	}
	if( f_query_rep.document.practNoteTypeReports.to_pract1.value==''||  f_query_rep.document.practNoteTypeReports.to_pract1.value==null){
		 f_query_rep.document.practNoteTypeReports.to_pract.value='';
	}
	if( f_query_rep.document.practNoteTypeReports.fm_noteType1.value==''||  f_query_rep.document.practNoteTypeReports.fm_noteType1.value==null){
		 f_query_rep.document.practNoteTypeReports.fm_noteType.value='';
	}
	if( f_query_rep.document.practNoteTypeReports.to_noteType1.value==''||  f_query_rep.document.practNoteTypeReports.to_noteType1.value==null){
		 f_query_rep.document.practNoteTypeReports.to_noteType.value='';
	}



	f_query_rep.document.practNoteTypeReports.submit();
}
}

function reset(){
	f_query_rep.document.practNoteTypeReports.reset();
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

function search_Code(obj,target) {
	var p_facility_id	= document.forms[0].p_facility_id.value;
	if(obj.name=='fm_pract1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='fmpractnotetypelist'><input type=hidden name='PageName' id='PageName' value='ReportspractNoteTypeList'></form></body></html>";
			parent.f_query_notetypelist_intermediate.document.write(HTMLVal);				
			if(parent.f_query_notetypelist_intermediate.document.tempform1)
				parent.f_query_notetypelist_intermediate.document.tempform1.submit(); 
		}
	}
	if(obj.name=='to_pract1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='topractnotetypelist'><input type=hidden name='PageName' id='PageName' value='ReportspractNoteTypeList'></form></body></html>";
			parent.f_query_notetypelist_intermediate.document.write(HTMLVal);				
			if(parent.f_query_notetypelist_intermediate.document.tempform1)
				parent.f_query_notetypelist_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='fm_noteType1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='fmnotetypelist'><input type=hidden name='PageName' id='PageName' value='ReportspractNoteTypeList'></form></body></html>";
			parent.f_query_notetypelist_intermediate.document.write(HTMLVal);				
			if(parent.f_query_notetypelist_intermediate.document.tempform1)
				parent.f_query_notetypelist_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='to_noteType1')
	{
		if((obj.value) == "null" || (obj.value ==""))
		{
			return false;			
		}
		else
		{
			//searchCode(obj,target);
			var objname=obj.name;
			var descriptionval=obj.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/CAMasterCodeListIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type=hidden name='selFunVal' id='selFunVal' value='tonotetypelist'><input type=hidden name='PageName' id='PageName' value='ReportspractNoteTypeList'></form></body></html>";
			parent.f_query_notetypelist_intermediate.document.write(HTMLVal);				
			if(parent.f_query_notetypelist_intermediate.document.tempform1)
				parent.f_query_notetypelist_intermediate.document.tempform1.submit(); 
		}
	}
	else if(obj.name=='fm_pract_src' || obj.name=='to_pract_src'||obj.name=='fm_noteType_src' || obj.name=='to_noteType_src')
	{		
		searchCode(obj,target);
	}
}
async function searchCode(obj,target ) {
	
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var SQL_SELECT		= "";
	var win_title		= "";
	var fld_name		= target.name;
	var fac_id			= document.forms[0].p_facility_id.value;
	var locale			= document.practNoteTypeReports.locale.value;

	if(fld_name =="fm_pract1" || fld_name=="to_pract1")
	{
		SQL_SELECT ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+fac_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";
		win_title  =  getLabel('Common.practitioner.label','COMMON');	
	}
	else if(fld_name =="fm_noteType1" || fld_name=="to_noteType1")
	{
		SQL_SELECT ="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?)";
		win_title  = getLabel('Common.NoteType.label','COMMON'); 	
	}

	argumentArray[0] = SQL_SELECT;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray =await CommonLookup( win_title, argumentArray );

	if(retArray != null && retArray != "" )  {
		var str =unescape(retArray);
	 	var arr = str.split(",");
		if(obj.name=="fm_pract_src")
		{							
			document.practNoteTypeReports.fm_pract1.value= arr[1];						
			document.practNoteTypeReports.fm_pract.value= arr[0];						
		}
		else if(obj.name=="to_pract_src")
		{
			document.practNoteTypeReports.to_pract1.value= arr[1];
			document.practNoteTypeReports.to_pract.value= arr[0];
		}
		else if(obj.name=="fm_noteType_src")
		{							
			document.practNoteTypeReports.fm_noteType1.value= arr[1];						
			document.practNoteTypeReports.fm_noteType.value= arr[0];						
		}
		else if(obj.name=="to_noteType_src")
		{
			document.practNoteTypeReports.to_noteType1.value= arr[1];
			document.practNoteTypeReports.to_noteType.value= arr[0];
		}
	}
	else
	{
		if(obj.name=="fm_pract_src")
		{							
			document.practNoteTypeReports.fm_pract1.value="";						
			document.practNoteTypeReports.fm_pract.value="";						
		}
		else if(obj.name=="to_pract_src")
		{
			document.practNoteTypeReports.to_pract1.value="";
			document.practNoteTypeReports.to_pract.value="";
		}
		else if(obj.name=="fm_noteType_src")
		{							
			document.practNoteTypeReports.fm_noteType1.value="";						
			document.practNoteTypeReports.fm_noteType.value="";						
		}
		else if(obj.name=="to_noteType_src")
		{
			document.practNoteTypeReports.to_noteType1.value="";
			document.practNoteTypeReports.to_noteType.value="";
		}
	}
}

