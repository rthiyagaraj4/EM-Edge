//This file is saved on 18/10/2005

function create(){
	frames[1].location.href='../../eCP/jsp/PractTypeForAssessmentNoteFrameSet.jsp?mode=1';
}
/*********************************************************/
function query(){
	frames[1].location.href='../../eCP/jsp/PractTypeForAssessmentNoteQueryCriteria.jsp';
}
/*********************************************************/
function reset(){
	
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		
		if(url.indexOf("Query")==-1){
			
				parent.frames[2].frames[1].frameSearch.document.forms[0].reset();
				parent.frames[2].frames[1].frameResult.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}
/*********************************************************/
function apply(){

	var message="";
	var messageFrame = parent.frames[2].frames[2]; 
	//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if (! checkIsValidForProceed() ) 
		{
			
			message  = getMessage("APPLY_NOT_VALID","CP");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
			return false ;
	}
	 if (!checkIsValidForProceed1()){
		
		//message  = getMessage("APPLY_NOT_VALID","CP");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		
		var frmobj=f_query_add_mod.frameSearch.document.formSearch;
		var fields = new Array (frmobj.assess_note_desc);
		var names = new Array (getLabel("eCP.AssessmentNote.label","CP"))
		if(f_query_add_mod.frameSearch.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
	}
	//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.PractTypeForAssessmentNoteServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.PractTypeForAssessmentNoteServlet";
	//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}
/*********************************************************/
function onSuccess(){
	
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
/*********************************************************/
function checkIsValidForProceed()
{	
	var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/*********************************************************/
function checkIsValidForProceed1()
{		
	var url = f_query_add_mod.frameResult.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
async function searchAssessNote(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var frmObj		=parent.frameSearch.document.formSearch;
	var prev_id=frmObj.assess_note_id.value;
	if(!(frmObj.assess_note_id.value=="")){
		frmObj.assess_note_id.value='';
		frmObj.assess_note_desc.value='';
	}
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmObj.locale.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] ="select assess_note_id code, assess_note_desc description from cp_assess_note_lang_vw where eff_status = 'E' and language_id like ? and upper(assess_note_id) like upper(?) and upper(assess_note_desc) like upper(?) order by assess_note_desc";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal =await CommonLookup(getLabel("eCP.AssessmentNote.label","CP"), argumentArray );
	if(retVal != null && retVal != "") {
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		target.value = arr[1] ;
		frmObj.assess_note_id.value = arr[0];
	}else{
		target.value ="";
		frmObj.assess_note_id.value = "";
		parent.Dummy.location.href='../../eCommon/html/blank.html';
	}
	if(prev_id != frmObj.assess_note_id.value)
		parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/*********************************************************/
function searchPractType(){
	var assess_note=document.forms[0].assess_note_id;
	var fields = new Array (assess_note);			    
	var names = new Array (getLabel("eCP.AssessmentNote.label","CP"));		
	var messageFrame = parent.parent.frames[2]; 
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var assess_note_id=assess_note.value;
		parent.frames[2].location.href='../../eCP/jsp/PractTypeForAssessmentNoteDynamicValues.jsp';
		parent.frames[1].location.href='../../eCP/jsp/PractTypeForAssessmentNoteDetail.jsp?assess_note_id='+assess_note_id+'&fromSearch=true';
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
}
/*********************************************************/
function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
/*********************************************************/

function selectAll(Obj,start,end){

	if(Obj.checked){

		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=true;
			}
		var assess_note_id = document.forms[0].assess_note_id.value;
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PractTypeForAssessmentNoteDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='assess_note_id' id='assess_note_id' value='"+assess_note_id+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			}
	
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PractTypeForAssessmentNoteDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}
/*********************************************************/
function chkForSelectAll(start,end){
	if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
		document.forms[0].selectall.checked=true;
		alert(document.forms[0].selectall.checked);
		selectAll(document.forms[0].selectall,start,end)
	}
}
/*********************************************************/
function onuncheck(obj){
	var frmObj=document.forms[0];
	if(obj.checked == false)
		frmObj.selectall.checked=false;
}

