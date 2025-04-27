var function_id = "";

function create()
{
	f_query_add_mod.location.href='../../eRS/jsp/SkillForPositionFrameSet.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
/********************************************************/
function query()
{
	f_query_add_mod.location.href = "../../eRS/jsp/SkillForPositionQueryCriteria.jsp?mode=1&function_id="+function_id;
}
/***********************************************************/
function apply(){

	if (!checkIsValidForProceed()){
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.f_query_add_mod_select.document.forms[0];
		if(frmobj==f_query_add_mod.f_query_add_mod_select.document.form_byPosition)
		{
			var fields = new Array (frmobj.role_type1,frmobj.position_desc);
			var names = new Array (getLabel("Common.RoleType.label","Common"),getLabel("Common.Position.label","Common"));
			if(f_query_add_mod.f_query_add_mod_select.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}

		else if(frmobj==f_query_add_mod.f_query_add_mod_select.document.form_bySkill)
		{
		
			var fields = new Array (frmobj.skill_code);
			var names = new Array (getLabel("eRS.Skill.label","RS"));
			if(f_query_add_mod.f_query_add_mod_select.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		return false ;
	}
	var frmObj=frames[1].frames[3].document.forms[0];
	var frmName=frmObj.name;

	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var select=eval("frmObj.select"+cnt);
		if(select.checked==true){
				select.value="Y";
		}else{
			select.value="N"
		}
	}
	for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
		var mandatory_yn=eval("frmObj.mandatory_yn"+cnt);
		if(mandatory_yn.checked==true){
				mandatory_yn.value="Y";
		}else{
			mandatory_yn.value="N"
		}
	}
	frmObj.submit();
	/*messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		onSuccess();
	}*/
}
/**********************************************************/
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
			url=frames[1].f_query_add_mod_select.location.href;
			if(url.indexOf("blank")==-1) {
				var frmObj=frames[1].f_query_add_mod_select.document.forms[0]
				url=frames[1].f_query_add_mod_listhdr .location.href;
				if(url.indexOf("blank")==-1) {
					frames[1].f_query_add_mod_list.document.forms[0].reset();
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				}
				else{
					frmObj.reset();
					var i=0;
					while(frmObj.elements(i)!=null){
						frmObj.elements(i).disabled=false;
						i++;
					}
					frmObj.elements(0).focus()
				}
			}
			else
				f_query_add_mod.location.href='../../eCommon/html/blank.html';
			}
		else
			f_query_add_mod.document.forms[0].reset();
	}
}
/*************************************************/
function showPosition()
{
	parent.f_query_add_mod_select.location.href='../../eRS/jsp/SkillForPositionByPosition.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	parent.f_query_add_mod_listhdr.location.href='../../eCommon/html/blank.html';
	parent.f_query_add_mod_list.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
/*****************************************************/
function showSkill()
{
	parent.f_query_add_mod_select.location.href='../../eRS/jsp/SkillForPositionBySkill.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	parent.f_query_add_mod_listhdr.location.href='../../eCommon/html/blank.html';
	parent.f_query_add_mod_list.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
/*************************************************/
function showSkillList()
{
	var frmObj		=parent.f_query_add_mod_select.document.form_byPosition;
	var mode		= frmObj.mode.value;
	var role_type1		= frmObj.role_type1.value;
	var position_desc		= frmObj.position_desc.value;
	var position_code		= frmObj.position_code.value;

	var fields = new Array (frmObj.role_type1, frmObj.position_code);
	var names = new Array (getLabel("Common.RoleType.label","Common"),getLabel("Common.Position.label","Common"));	
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) {	
		frmObj.role_type1.disabled='true';
		frmObj.staff_type.disabled='true';
		frmObj.position_desc.disabled='true';
		frmObj.position_lookup.disabled='true';
		frmObj.show_skill.disabled='true';
		parent.f_query_add_mod_listhdr.location.href="../../eRS/jsp/SkillForPositionHdr.jsp?form_name="+frmObj.name;
		parent.f_query_add_mod_list.location.href="../../eRS/jsp/SkillForPositionShowSkill.jsp?position_code="+position_code+"&position_desc="+position_desc+"&mode="+mode;
		parent.parent.messageFrame.location.href =  "../../eCommon/jsp/MstCodeError.jsp";
	}
}
/**********************************************/
function showPositionList()
{ 
	var frmObj=parent.f_query_add_mod_select.document.form_bySkill;
	var mode		= frmObj.mode.value;
	var skill_code=frmObj.skill_code[frmObj.skill_code.selectedIndex].value;
	var skill_desc=frmObj.skill_code[frmObj.skill_code.selectedIndex].text;
	var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	var role_type		= frmObj.role_type.value;
	var fields = new Array (frmObj.skill_code);
	var names = new Array (getLabel("eRS.Skill.label","RS"));	
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)) {	

		frmObj.skill_code.disabled='true';
		frmObj.role_type.disabled='true';
		frmObj.staff_type.disabled='true';
		frmObj.show_posit.disabled='true';
		parent.f_query_add_mod_listhdr.location.href="../../eRS/jsp/SkillForPositionHdr.jsp?form_name="+frmObj.name;
		parent.f_query_add_mod_list.location.href='../../eRS/jsp/SkillForPositionShowPosition.jsp?skill_code='+skill_code+"&skill_desc="+skill_desc+"&staff_type="+staff_type+"&role_type="+role_type+"&mode="+mode;
		parent.parent.messageFrame.location.href =  "../../eCommon/jsp/MstCodeError.jsp?";
	}
}
/**************************************************/
function click_selectall()
{
	var frmObj=parent.f_query_add_mod_list.document.forms[0];
	var select=parent.f_query_add_mod_listhdr.document.forms[0].selectall;
	if(select.checked == true){
		for(cnt=0;cnt<frmObj.totalRecords.value; cnt++){
			val = eval("frmObj.select"+cnt);
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<frmObj.totalRecords.value; cnt++){
			val = eval("frmObj.select"+cnt);
			val.checked = false;
		}
	}
}
/**********************************************/
function viewPosition(call_mode, target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=parent.f_query_add_mod_select.document.form_byPosition;
	var locale=frmObj.locale.value;
	
	if((call_mode == 'T')&&(frmObj.position_desc.value=="")){
		frmObj.position_code.value='';
		return false;
	}

	if(!(frmObj.position_code.value=="")){
		frmObj.position_code.value='';
		frmObj.position_desc.value='';
	}
	var role_type1=frmObj.role_type1[frmObj.role_type1.selectedIndex].value;
	var staff_type=frmObj.staff_type[frmObj.staff_type.selectedIndex].value;
	if(!((role_type1==null)||(role_type1==''))){
		msg='';
		dataNameArray[0]="role_type";
		dataNameArray[1]="staff_type";
	
		dataValueArray[0]=role_type1;
		dataValueArray[1]=staff_type;

		dataTypeArray[0]="String";
		dataTypeArray[1]="String";

		argumentArray[0] = "select position_code code ,position_desc description from am_position_lang_vw where eff_status = 'E'  and upper(role_type) like upper(?) and upper(staff_type) like upper(?) and upper(position_code) like upper(?) and upper(position_desc) like upper(?) and  language_id ='"+locale+"' order by position_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3,4";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.Positions.label","RS"),argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.position_code.value = retVal[0];
		}
	}
	else
		msg='Role Type can not be null...';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
}
/*****************************************************/
function populateStaffType(){
	clearStaffType();
	var frmObj=parent.f_query_add_mod_select.document.form_bySkill;
	var role_type=frmObj.role_type.value;
	  
		if(!role_type==""){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/SkillForPositionValidate.jsp?role_type="+role_type, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
		}
}
/************************************************************************/


function populateStaffType1(){
	//alert("populateStaffType1");
	clearStaffType();
	var frmObj=parent.f_query_add_mod_select.document.form_byPosition;
	var role_type1=frmObj.role_type1.value;
//	frmObj.Position_text.value="";
//	frmObj.staff_text.value="";
		
		if(!role_type1==""){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/SkillForPositionValidate.jsp?role_type="+role_type1, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
	}

}
/************************************************************************/
function addStaffType(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	parent.f_query_add_mod_select.document.forms[0].staff_type.add(element);
}
/************************************************************************/
function skillchange(){
	var role=document.forms[0].role_type;
	role.selectedIndex=0;
	clearStaffType();
}
/************************************************************************/
function clearStaffType( ) {
	var len = eval("document.forms[0].staff_type.options.length") ;
	//alert("len---in RS---" +len)
	for(var i=0;i<len;i++)
	{
		
		eval("document.forms[0].staff_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.forms[0].staff_type.add(opt)") ;
}
/*********************************************/
function clearPositionDesc()
{
	var frmObj=parent.f_query_add_mod_select.document.form_byPosition;
	frmObj.position_code.value="";
	frmObj.position_desc.value="";
}
/****************************************/
function checkIsValidForProceed()
{		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}
/*********************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_add_mod_select.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}
/**************************************************/
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_add_mod_list.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}

/*************************************************************************/
function oncheck(target)
{
	if(target.checked == false){
		target.value = "N";
	}	else	{
		target.value = "Y";
		target.checked = true;
	}
}
/*************************************************************************/
function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
	
}
/****************************************************************************/
function onSuccess() {
	
var mode = parent.frames[2].frames[1].frames[3].document.forms[0].mode.value
// var mode =parent.frames[2].f_query_add_mod.f_query_add_mod_list.document.form_skillList.mode.value//Changed by Sandhya on 19/11/08
	if( mode == "1" ) {
			parent.frames[2].f_query_add_mod.f_query_add_mod_list.location.href='../../eCommon/html/blank.html';	
			parent.frames[2].f_query_add_mod.f_query_add_mod_listhdr.location.href='../../eCommon/html/blank.html';
			parent.frames[2].f_query_add_mod.f_query_add_mod_select.document.forms[0].reset();
			var frmObj=frames[1].f_query_add_mod_select.document.forms[0]
			frmObj.reset();
			var i=0;
			while(frmObj.elements(i)!=null)
			{
				frmObj.elements(i).disabled=false;
				i++;
			}
			frmObj.elements(0).focus()
	}
}
/****************************************************************************/
