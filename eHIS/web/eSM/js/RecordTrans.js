var valser;
function create() {
    f_query_add_mod.location.href = "../../eSM/jsp/RecordTrans.jsp" ;
}

function edit() {
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function apply()
{
	var leng =	frames[1].frames[3].document.forms[0].elements.length;
	var submit = "Y";
	var msg = "";
	for(i=0;i<leng;i++)
		{
		  if (frames[1].frames[3].document.forms[0].elements(i).type=="text")
		  {
		    if (frames[1].frames[3].document.forms[0].elements(i).value=="")
		    {
			
			msg=frames[1].frames[3].getMessage('CAN_NOT_BE_BLANK','Common');
			msg = msg.replace('$',frames[1].frames[3].document.forms[0].elements(i-1).value);
			msg=msg+" <br>";
			submit = "N";
			}
		  }
		}
    if (submit=="Y")
    document.frames[1].frames[3].document.forms[0].submit();
	else
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	return false;
}

function onSuccess() {

var table_id =document.frames[1].frames[0].document.forms[0].tableid.value;
var module_id =document.frames[1].frames[0].document.forms[0].module_id.value;
var code = document.frames[1].frames[2].document.forms[0].code.value;
var criteria_String= document.frames[1].frames[0].document.forms[0].criteria.value;
document.frames[1].frames[2].document.location.href="../../eSM/jsp/RecordTransResult.jsp?tableid="+table_id+"&moduled_id="+module_id+"&criteria_String="+criteria_String;
}

function reset() {
	if(frames[1].frames[3].document.forms[0])
	   {
		frames[1].frames[3].document.forms[0].reset()
	   }
}


