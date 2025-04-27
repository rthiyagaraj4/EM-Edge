//This file is saved on 18/10/2005


var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;


//Function to create a value in insert mode...
function create()
{
    f_query_add_mod.location.href="../../eCP/jsp/PatientClassForStageFrameSet.jsp";
}
//*******************************************************************

//Function to create a value in update mode...
function query() 
{
	f_query_add_mod.location.href="../../eCP/jsp/PatientClassForStageQueryCriteria.jsp";
}
//*******************************************************************
//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		//var url = parent.frames[1].frames[1].location.href;
		var url = parent.frames[2].frames[1].location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
		return false;
}
//*******************************************************************

function checkIfApply()
{
	
	var url=parent.frames[2].frames[1].frames[1].location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}
//**********************************************************************
//Changes made by SANDHYA-------dt---17/11/08
function apply()
{
    // var messageFrame = parent.frames[1].frames[2]; 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
  if((! checkIsValidForProceed()) || (! checkIfApply()) )
     {
		if(!checkIsValidForProceed())
		{
		var message=getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
		}
	  	//message  = getMessage("APPLY_NOT_VALID","CP");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//frmobj=f_query_add_mod.f_query_header.document.TermcodeEvalMeasureHeaderForm;
		//alert(f_query_add_mod.f_query_header.document.PatientClassForStage_Form.name);
		var frmobj=f_query_add_mod.f_query_header.document.PatientClassForStage_Form;
		var fields = new Array (frmobj.Stage_code);
		var names = new Array (getLabel("Common.Stage.label","Common"))
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false ;
		
     }
        
	var frmObj=parent.frames[2].frames[1].frames[1].document.forms[0];
	var tot_rec=frmObj.total_records.value;
	for(i=0;i<tot_rec;i++)
	{
		var select=eval("frmObj.select_yn"+i).checked;
		if(select==true)
			eval("frmObj.select_yn"+i).value='Y';
		else
			eval("frmObj.select_yn"+i).value='N';
		
	}
	parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eCP.PatientClassForStageServlet';
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}
//*******************************************************************
function onSuccess() 
{
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}

//*******************************************************************
function searchDetails()
{
	 var frmobj=parent.f_query_header.document.PatientClassForStage_Form ;
	  var fields = new Array (frmobj.Stage_code);			    
	  var names = new Array (getLabel("Common.Stage.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst(fields, names, msgFrame))
          {	
  parent.frames[1].location.href='../../eCP/jsp/PatientClassForStageDetail.jsp?stage_code='+frmobj.Stage_code.value;
   	}
}
//********************************************************************************
function reset()
{
	var url = f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1){
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
		else if(f_query_add_mod.f_query_header.document.forms[0]){
			f_query_add_mod.f_query_header.document.forms[0].reset();
			f_query_add_mod.frames[1].location.href='../../eCommon/html/blank.html';
		}
	}
}
//**********************************************************************************
function clearDetails(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/************************************************************************************/
