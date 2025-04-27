//This file is saved on 18/10/2005



var message="";
function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/PositionForInterventionFrameSet.jsp";
}

function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/PositionForInterventionQueryCriteria.jsp";
}



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
		   //if(f_query_add_mod.document.forms[0])
	       //f_query_add_mod.document.forms[0].reset();
	}
}

function searchDetails()
  {
	parent.frames[2].location.href='../../eCP/jsp/PositionForInterventionDynamicValues.jsp';		
      var frmobj=parent.f_query_header.document.form_add_mod ;
	var fields = new Array (frmobj.role_type,frmobj.staff_type,frmobj.position_code);	
    var names = new Array (getLabel("Common.RoleType.label","common"),getLabel("Common.StaffType.label","Common"),getLabel("Common.Position.label","common"));	
    var	msgFrame=parent.parent.messageFrame;

	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
 parent.frames[1].location.href='../../eCP/jsp/PositionForInterventionDetail.jsp?role_type='+frmobj.role_type.value+'&staff_type='+frmobj.staff_type.value+' &position_code='+frmobj.position_code.value+'&fromSearch=true';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	
		}
  }

async function viewPositionGroup(target)
{
var frmobj=parent.f_query_header.document.form_add_mod ;
	//frmobj.position_desc.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmobj.locale.value;
	dataTypeArray[0] = STRING;
// 	argumentArray[0] ="Select  position_code code,  position_desc  description from am_position  where eff_status ='E' AND UPPER(position_code) LIKE UPPER(?) AND UPPER(position_desc) LIKE UPPER(?) ORDER BY position_desc";
 	argumentArray[0] ="SELECT  position_code code,  position_desc  description FROM am_position_lang_vw  WHERE eff_status ='E' and language_id like ? AND UPPER(position_code) LIKE UPPER(?) AND UPPER(position_desc) LIKE UPPER(?) ORDER BY position_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.PositionNote.label","CP"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "") {
			target.value = arr[1] ;
			document.forms[0].position_code.value = arr[0];
			
		}else
			target.value ="";
}

function apply()
{
if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.PositionForInterventionServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	//alert("after submitt");
}


function onSuccess() 
{
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}
/*function onSuccess() 
{
	alert("on succ");
	//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frames[1].document.forms[0].location.reload();
}*/

function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function clearDetail()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
}
