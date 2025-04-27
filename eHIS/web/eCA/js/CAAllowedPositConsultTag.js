/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------
*/ 

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/CAAllowedPositConsultTag.jsp?mode=insert';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'
}
function reset()
{
	f_query_add_mod.location.reload();
}
function resetValues(){
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
}
function chekcSplTxt(txtSpl)
{
	if(txtSpl.value == '')
	{
		parent.frames[0].document.forms[0].splCode.value='';
	}
}
function getSplCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].splCode.value='';
	}else{	
		populateSpl()
	}	 
}
function resetSearchResult()
{
	parent.frameMultiLocForPractitionerResult.location.href="../../eCA/jsp/blank.jsp";
	resetValues();
}

function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function apply()
{
	var formResultObj = f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm;
	if(formResultObj === undefined)
	{
	msg =getMessage("ALWD_PRACT_NOT_BLANK",'CA');
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
	return false;
	}
	var from = f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.fm_disp.value;	
	var to = f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.to_disp.value;	
	var optionValStr = "", position_code ="", position_desc = "", positionIU = "",position_restr_yn = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU="";
	for (i=from; i<=to; i++){
		position_code = eval("formResultObj.position_code"+i+".value");
		position_desc = eval("formResultObj.position_desc"+i+".value");
		positionIU = eval("formResultObj.positionIU"+i+".value");
		position_restr_yn = eval("formResultObj.position_restr_yn"+i+".value");		
		pract_type1 = eval("formResultObj.pract_type1"+i+".value");		
		optionValStr += position_code +"||"+position_desc+"||"+positionIU +" ||"+position_restr_yn+"||"+pract_type1+"||"+i+"~";
	}
	f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.optionValStr.value = optionValStr;
	f_query_add_mod.f_query_add_mod_res.document.forms[0].action="../../servlet/eCA.CAAllowedPositConsultTagServlet";
	f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.target="messageFrame";
	f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.method="post";
	f_query_add_mod.f_query_add_mod_res.document.CAAllowedPositConsultTagRusltFrm.submit();	
}

function populateData(){
	var practitioner_type= parent.frames[0].document.forms[0].practitioner_type.value;
	if(practitioner_type == "" || practitioner_type ==null)
	{
	msg =getMessage("ALWD_PRACT_NOT_BLANK",'CA');
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
	return false;
	}
	else
	{
		parent.f_query_add_mod_res.location.href='../../eCA/jsp/CAAllowedPositConsultTagResult.jsp?practitioner_type='+practitioner_type;
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}	
}

function selectChkBox(element,index){ 
	var chk_count=parseInt(document.getElementById('chk_count').value);
	if(element.checked){
		element.value="Y";
		document.getElementById('chk_count').value=chk_count+1;
		return;
	}else{
		element.value="N";
		document.getElementById('chk_count').value=chk_count-1;
		if(document.getElementById('allChecked').checked==true)
			document.getElementById('allChecked').checked = false;
	}
}

function selectAll(ele) 
{
	var fm_disp=parseInt(document.getElementById("fm_disp").value);
	var to_disp=parseInt(document.getElementById("to_disp").value);	
	var chk_count=parseInt(document.getElementById('chk_count').value);
	var checkboxes = document.getElementsByTagName('input');
    if (ele.checked) {
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = true;
				checkboxes[i].value="Y";
            }
        }
    } else {
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = false;
				checkboxes[i].value="N";
            }
        }
    }
	
}

function onSuccess()
{
	f_query_add_mod.location.reload();	
}
function callOnChange(obj)
{
	if(obj.value=="")
		parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
	else
		parent.frames[1].document.location.href ='../../eCommon/html/blank.html'; 
}

