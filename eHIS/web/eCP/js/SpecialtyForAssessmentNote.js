//This file is saved on 18/10/2005


/*********************************************************/
function apply()
{

	if (! checkIsValidForProceed() ) {
		
	     message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		 
		message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		
		//message  = getMessage("APPLY_NOT_VALID","CP");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//Modified on-------17/11/08-------------------------
		var frmobj=f_query_add_mod.f_query_header.document.form_add_mod;
		var fields = new Array (frmobj.assess_note_desc);
		var names = new Array (getLabel("eCP.AssessmentNote.label","CP"))
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
	}
	
	//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.SpecialtyForAssessmentNoteServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.SpecialtyForAssessmentNoteServlet";
	//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
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
	var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function checkIsValidForProceed2()
{		
	var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
/*********************************************************/
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/SpecialtyForAssessmentNoteFrameSet.jsp";
}


/*********************************************************/
function query(){

	frames[1].location.href='../../eCP/jsp/SpecialtyForAssessmentNoteQueryCriteria.jsp';
}

/*********************************************************/
function searchDetails()
  {
			
		
	   parent.frames[2].location.href='../../eCP/jsp/SpecialtyForAssessmentNoteDynamicValues.jsp';
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.assess_note_id);	
	 
	  var names = new Array (getLabel("eCP.AssessmentNote.label","CP"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		 
		  parent.frames[1].location.href='../../eCP/jsp/SpecialtyForAssessmentNoteDetail.jsp?assess_note_id='+frmobj.assess_note_id.value+'&fromSearch=true';
		  parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

			

		}
  }

/*********************************************************/
 async  function viewAgeGroup(target)
{
	var frmobj=parent.f_query_header.document.form_add_mod ;
	frmobj.assess_note_desc.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmobj.locale.value;
	dataTypeArray[0] = STRING;
 	argumentArray[0] ="Select assess_note_id code, assess_note_desc description from cp_assess_note_lang_vw where eff_status ='E' and language_id like ? AND UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc) LIKE UPPER(?) ORDER BY assess_note_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal =await  CommonLookup(getLabel("eCP.AssessmentNote.label","CP"), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			document.forms[0].assess_note_id.value = arr[0];
			
		}else
			target.value ="";
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

/*********************************************************/

function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[2].frames[1].f_query_header.document.forms[0].elements(0).focus();
				parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}

/*********************************************************/
function onSuccess() 
{
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}



    



 
