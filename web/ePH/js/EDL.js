var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var invalidCode="";

function query() {

	f_query_add_mod.location.href="../../ePH/jsp/EDLFrames.jsp" ;
}

function reset() {
	query();
}

/***************************apply()****************************************************/

function apply()
{	
    formObj =   document.forms[0];
    var mode = formObj.mode.value;

/*    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "EDLCode";
    arrFieldName[1]         =   "EDLDescription";

   
    arrLegends[0]           =   getLabel("Common.code.label","Common")
    arrLegends[1]           =   getLabel("Common.description.label","Common")
//	arrLegends[2]           =   "Local Language Description";

*/
    var arrPKFieldNames     =   new Array();
    arrPKFieldNames[0]      =   "EDLCode";

	if( mode == MODE_INSERT )
    {
		//resetDuplicateClass(formObj,arrPKFieldNames);
		eval(formApply(formObj,PH_CONTROLLER));
		//alert(result);
		//alert(message);
		//alert(invalidCode);
		if( result ) {

			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			onSuccess();
		}
		else if( invalidCode != "null" && invalidCode != "" ){
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
			showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',parent.parent.parent.messageFrame);
		}
		else
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	else if (mode == MODE_MODIFY)
	{
		if(formObj.name == 'EDLModifyForm')
		{
			eval(formApply(formObj,PH_CONTROLLER));
		if( result ) {

			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			onSuccess();
		}
		else if( invalidCode != "null" && invalidCode != "" ){
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
		}
		else
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}

	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
}

function onSuccess() 
{

    formObj =   document.forms[0];
    var mode = formObj.mode.value;
	//alert(message);	
	if( mode == MODE_INSERT ) 
	{
		formObj.reset();
		parent.parent.EDLTreeFrame.location.href="../../ePH/jsp/EDLTree.jsp";
	}
	else if(mode == MODE_MODIFY )
	{
		parent.parent.EDLTreeFrame.location.href="../../ePH/jsp/EDLTree.jsp";
	}
}

function checkForEmptyValues()
{
	var oneSelected = false;
	//alert('insie check for null edl.js');
	for(var i=0;i<document.EDLAddForm.totalRecords.value;i++)
	{
		if(eval('document.EDLAddForm.EDLSelect'+i).checked==true)
		{
			if(eval('document.EDLAddForm.EDLCode'+i).value=='')
			{
				alert(getMessage("CODE_CANNOT_BLANK","PH"));
				eval('document.EDLAddForm.EDLCode'+i).focus();
				return false;
			}

			else if(eval('document.EDLAddForm.EDLDescription'+i).value=='')
			{
				alert(getMessage("DESC_CANNOT_BLANK","PH"));
				eval('document.EDLAddForm.EDLDescription'+i).focus();
				return false;
			}
			oneSelected = true;
		}
	}
	if(!oneSelected)
	{
		alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
		return false;
	}
	return true;
}

function checkDescriptionNull(obj)
{
	for(var i=0;i<document.EDLModifyForm.MaxSeqNumber.value;i++)
	{
		try
		{	
			if(trimString(eval('document.EDLModifyForm.EDLDescription'+i).value)=='')
			{
				alert(getMessage("DESC_CANNOT_BLANK","PH"));
				eval('document.EDLModifyForm.EDLDescription'+i).focus();
				return false;
			}
		}
		catch (e){}
	}
	return true;
}

function EDLAssociate()
{
	var formObj = parent.EDLLookUpDetailsFrame.document.EDLAssociateLookUpForm;
	var associatedCodes ="";
	var associatedDescs ="";
  
  
	if(formObj.EffectiveStatus!=null && formObj.EffectiveStatus.length != undefined) {   // undefined if only one check box is available
		for(var i=0;i<formObj.EffectiveStatus.length;i++)
		{
			if(formObj.EffectiveStatus[i].checked==true)
			{
				associatedCodes= associatedCodes + formObj.EDLCode[formObj.EffectiveStatus[i].value].value +",";
				associatedDescs= associatedDescs + formObj.EDLDescription[formObj.EffectiveStatus[i].value].value +", ";
			}
		}
	} else { 
		if(formObj.EffectiveStatus && formObj.EffectiveStatus.checked==true)
		{
			// SCF SKR-SCF-0062  
		 	//associatedCodes= associatedCodes + formObj.EDLCode[formObj.EffectiveStatus.value].value +",";
			//associatedDescs= associatedDescs + formObj.EDLDescription[formObj.EffectiveStatus.value].value +", ";
			associatedCodes= associatedCodes + formObj.EDLCode.value +",";
			associatedDescs= associatedDescs + formObj.EDLDescription.value +", ";
		}
	   

	}	
	associatedCodes = associatedCodes.substring(0,associatedCodes.length-1);
	associatedDescs = associatedDescs.substring(0,associatedDescs.length-1);
     
	window.returnValue = associatedCodes +"::::"+associatedDescs;
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnValue;
    
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();  
	//window.close();
}

async function openEDLDetails(DrugCode)
{
	var dialogHeight	= "60";
	var dialogWidth		= "35";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status;
	var arguments		= "";
	
	await window.showModalDialog("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode, arguments, features);
	//window.open("../jsp/EDLAssociateListViewFrames.jsp?DrugCode="+DrugCode);
}

