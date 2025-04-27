/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var effStatus= new Array();
var selected= new Array();

function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/RolesForUserInCreateMode.jsp?mode=insert';
}

function apply()
{
	var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	var totalCount = formObj.totalCount.value;
	var y=0;
	var i=1;
	//IN:050336
	if(chkApp(totalCount))
	{
		if(typeof parent.content.f_query_add_mod.detail_frame!="undefined")
		{
			if(formObj != "" && formObj != null && formObj != undefined )
			{
				formObj.method="post";
				formObj.action="../../servlet/eOT.RoleForUserServlet";
				formObj.submit();
			}
		}
		else
		{
			 parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function reset()
{
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RolesForUserInCreateMode.jsp") != -1)
	{
		var hash = new Hashtable();
		hash = parent.content.hidden_frame.hash;
		hash.clear();
		if(f_query_add_mod.document.location.href.indexOf("RolesForUserMain.jsp") != -1)
			return false;
		else
		{
			//f_query_add_mod.detail_frame.document.location.reload();//IN:050336
			f_query_add_mod.document.location.reload();
		}
	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("RolesForUserQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	var source=document.forms[0].source.value;
	if(cmf.apply != "undefined" && cmf.apply != null )
	{
			if(cmf.apply.disabled==false)
			{
				 cmf.apply.disabled=true;
			}
	}
	//050736
	if(cmf.reset != "undefined" && cmf.reset != null )
	{
			if(cmf.reset.disabled==true)
			{
				 cmf.reset.disabled=false;
			}
	}
    var source=document.forms[0].source.value;
	f_query_add_mod.location.href="../../eOT/jsp/RolesForUserQueryCriteria.jsp?"+source+"&mode=modify";
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function callDetailForm(){
	var frmObj=window.parent.frames[0];
	var frm=frmObj.document.forms[0];
	var user_id= frm.user_id.value;
	var user_name= frm.user_name.value;
	//var messageFrame= window.parent.parent.document.frames.messageFrame;
	var messageFrame= parent.parent.messageFrame;
	var category_value=getLabel("Common.user.label","Common");
	var fields = new Array (frm.user_id);
	var names = new Array (category_value);
	if(checkFieldsofMst( fields, names, messageFrame)) {
		var frmObj = window.parent.frames[1];
		frmObj.location.href="../../eOT/jsp/RolesForsUserDetailForm.jsp?user_id="+user_id+"&user_name="+user_name;
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function validateCheckBox(obj){
	var formObj = document.forms[0];
	if(formObj.chk_select.checked==true){
	}
	 var i = 0;
	    while (!formValid && i < radios.length) {
	        if (radios[i].checked) formValid = true;
	        i++;
    }
}

function getCheckBoxValue(key){
	var hash = new Hashtable();
	var hash_obj = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
	hash_obj = parent.parent.frames[3].hash;
	var formObj = document.forms[0];
	var sel = (eval("formObj.allow_verif"+key).checked==true)?"Y":"N";
	if(hash.get(key)==null){
		hash.put(key,sel);
	}else
		hash.remove(key);
}

function callAllowVerificationChkBox(key){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
	var formObj = document.forms[0];
	var chkBoxobj = eval("formObj.allow_verif"+key);
	chkBoxobj.checked = (hash.get(key)=="Y")?true:false;
}

function assignCheckBoxValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	verify_hash = parent.parent.frames[3].dupChk;
	if(hash.get(key)!=null ){
		var val = hash.get(key).split("@@");
		var allow_verify = (verify_hash.get(key)!=null)?verify_hash.get(key):val[1];
		eval("formObj.allow_verif"+key).checked=(allow_verify=="Y")?true:false;
		eval("formObj.chk_select"+key).checked= (val[2]=="I")?true:false
	}
}
/*function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
*/
function clearvalues() {
    // Reset the form
    //document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
    window.location.reload();
}

function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

async function callUser(obj,target, user_name){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.user.label","common");

	var sql="SELECT APPL_USER_ID CODE,APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'E') = 'E'  AND UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 2 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
 	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value = arr[1];
		user_name.value = arr[1];
	}else{
		target.value = "";
		user_name.value = "";
		obj.value="";
	}
}
function callAlertFunction(msg_id) {
	alert(getMessage(msg_id,'OT'));
	parent.parent.parent.frames[1].expand(this);
	return false;
	window.close();
}
function callEnableRadio(obj, recordCount)
{
	if(obj.value=="N")
	{
		document.getElementById('chk_select_'+recordCount).disabled = true;
		document.getElementById('chk_select_'+recordCount).checked = false;
	}
	else
	{
		document.getElementById('chk_select_'+recordCount).disabled = false;
	}
}
function chkRadio(obj, recordCount){
	var totalCount=document.getElementById('totalCount').value;
	for(i=1;i<totalCount;i++)
	{
		if(i!=recordCount){
				document.getElementById('chk_select_'+i).checked = false;
				document.getElementById('chk_select_'+i).value='N';
		 }
			document.getElementById('chk_select_'+recordCount).checked = true;
			document.getElementById('chk_select_'+recordCount).value='Y';
	}
}

function chkApp(totalCount)//IN:050336
{
	var formObj = parent.content.f_query_add_mod.detail_frame;
	var applFlag = false;
	for(var i=1; i<totalCount; i++)
	{
		var selectedItem = formObj.document.getElementById('role_applicable_'+i).value;
		if(selectedItem == 'A')
		{
			applFlag = true;
			break;
		}
	}
	if(!applFlag)
	{
		var msg = getMessage("APP-OT0226","OT");
		alert(msg);
		return false;
	}
	return true;
}
//050736
function disableApply(){
	//parent.parent.commontoolbarFrame.document.forms[0].reload();
	var cmf = parent.parent.commontoolbarFrame.document.forms[0];
	if(cmf == null)
		setTimeout('disableApply()', 2);
	else
{
		//var source=document.forms[0].source.value;
		if(cmf.apply != "undefined" && cmf.apply != null )
		{
				if(cmf.apply.disabled==false)
				{
				  cmf.apply.disabled=true;
				}
	}
}
}
