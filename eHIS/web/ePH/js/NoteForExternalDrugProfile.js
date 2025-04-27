
var result = false ;
var message = "" ;
var flag = "" ;

function create(){
		parent.frames[2].NoteForExternalDrugFrameset.rows="42,128,*,30";
		f_query_add_mod.location.href="../../ePH/jsp/NoteForExternalDrugProfileHeader.jsp?mode="+MODE_INSERT;
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function apply(){
	var url=f_add_mod_detail.location.href;
	if(url.indexOf('Detail') == -1 || f_add_mod_detail.document.noteTypedetailforGroupform.maxRecord.value<=0 ){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
    	return false;
	}
	else{
		f_add_mod_detail.document.noteTypedetailforGroupform.mode.value=MODE_INSERT;
		frmobj  =f_add_mod_detail.document.noteTypedetailforGroupform;
		eval(formApply(frmobj,PH_CONTROLLER ));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		onSuccess();		
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}


function reset() {
	url = f_query_add_mod.location.href;

	if(url.indexOf('blank') != -1){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
		return false;
	}
	else{
		f_query_add_mod.document.forms[0].reset();
		f_add_mod_detail.location.href="../../eCommon/html/blank.html";
	}
}

function onSuccess() {
	f_query_add_mod.location.href="../../ePH/jsp/NoteForExternalDrugProfileHeader.jsp?mode="+MODE_INSERT;
	f_add_mod_detail.location.href="../../eCommon/html/blank.html";
}

function searchNoteGroup(target){
	var formObj = document.frames.NoteForExternalDrugheaderform;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = "SELECT note_group code, note_group_desc description FROM ca_note_group where eff_status='E' and appl_task_id='PH_NOTES' and upper(note_group) like upper(?) and  upper(note_group_desc) like upper(?) order by 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[7]   = CODE_DESC ;
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;

	var retVal = await CommonLookup( getLabel("eCA.NoteGroup.label","CA"), argumentArray );
	
	if(retVal != null && retVal != "" )  {
		formObj.note_group_code.value=retVal[0];
		target.value = retVal[1];
	} 		
} 

function popNoteTypeforGroup(note_group_code)
{
	var formObj=document.NoteForExternalDrugheaderform;	
	
	var fields = new Array ( formObj.note_group_name);
	var names = new Array (getLabel("eCA.NoteGroup.label","CA"));
	var messageFrame	=	parent.messageFrame;
	
	if(parent.f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
	parent.f_add_mod_detail.location.href="../../ePH/jsp/NoteForExternalDrugProfileDetail.jsp?note_group_code="+note_group_code.value;
		return true;
	 }
	else
	   return false;
	
}

function selectAll(obj,to){
	
	if(obj.checked == true)
		obj.value='Y';
	else
		obj.value='N';
	
	for( i=0; i<to; i++){
		if(eval("document.noteTypedetailforGroupform.check"+i).disabled!=true){
			eval("document.noteTypedetailforGroupform.check"+i).value = obj.value;
			eval("document.noteTypedetailforGroupform.check"+i).checked = obj.checked;
		}
		
	}
}
  
function dispTypeCheck(obj, disp_type_code){

	if(obj.checked == true)
        obj.value="Y";
	else
		obj.value="N";
} 
    
  
  
 
