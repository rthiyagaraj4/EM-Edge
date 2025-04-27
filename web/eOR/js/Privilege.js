/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;

var flagGlobal = true;
var atleastOne = false;
var atleastOneModify = false;
var atleastOnePrivilege = false;
var levelChk = false;
var mode="";
/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
/*******************************************************************/
function create() {

	f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeAddModify.jsp?mode=1&function_id="+function_id ;
 
}
/******************************************************************************/
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/PrivilegeQueryCriteria.jsp?mode=MODE_MODIFY&function_id="+function_id;

}
/**************function to fill combo Box Dynamically********************/
function fillComboOptions(obj) {
	getHandleDetail();
	getHandleHeader();
	var privilege_ctx = "";
	
	var bean_id				= formObjHeader.bean_id.value ;
	if(obj.value == "" ) {
	 removePrevCtxHtml();
	 return ;		
	}else{
	 privilege_ctx = obj.value ;	
	 if(privilege_ctx == "U"){
		var applUserHTML = "<input type='text' name='appl_user_name' id='appl_user_name' value='' size=30 maxlength=40 onblur='parent.parent.showApplUserWindow(this)'><input type='hidden' name='appl_user_id' id='appl_user_id' value=''><input type='button' name='appl_button' id='appl_button' class='button'   value='?' onClick='parent.parent.showApplUserWindow(document.privilegeHeader.appl_user_id)'>&nbsp<img src='../../eCommon/images/mandatory.gif'>";//onmouseover='this.focus();'
		showPrevCtxHtml("U",applUserHTML);
		return ;
	   }else if(privilege_ctx == "R"){
		 
			var relnHTML = "<input type='text' name='pract_reln_name' id='pract_reln_name' value='' size=30 maxlength=40 onblur='parent.parent.showRelnWindow(this)'><input type='hidden' name='reln_id' id='reln_id' value=''><input type='button' name='reln_button' id='reln_button' class='button'   value='?' onClick='parent.parent.showRelnWindow(document.privilegeHeader.reln_id)'>&nbsp<img src='../../eCommon/images/mandatory.gif'>";//onmouseover='this.focus();'
		showPrevCtxHtml("R",relnHTML);
		return ;
	   }else if(privilege_ctx == "P"){
		 
			var respHTML = "<input type='text' name='resp_name' id='resp_name' value='' size=30 maxlength=40 onblur='parent.parent.showRespWindow(this)'><input type='hidden' name='resp_id' id='resp_id' value=''><input type='button' name='resp_button' id='resp_button' class='button'   value='?' onClick='parent.parent.showRespWindow(document.privilegeHeader.resp_id)'>&nbsp<img src='../../eCommon/images/mandatory.gif'>";//onmouseover='this.focus();'
		showPrevCtxHtml("P",respHTML);
		return ;
	   }
	}

}
/***************************************************************************/
function showPrevCtxHtml(ctx ,html){
 getHandleHeader();
  var label = "";
 if(ctx == "U") label=getLabel("eOR.ApplicationUser.label","OR");
 if(ctx == "R") label=getLabel("Common.relationship.label","Common");
 if(ctx == "P") label=getLabel("eOR.Responsibilty.label","OR"); 
  headerDoc.level_for_label.innerHTML = label;
 headerDoc.level_for_value.innerHTML = html;
}
/***************************************************************************/
function removePrevCtxHtml(){
 getHandleHeader();
 headerDoc.level_for_label.innerHTML = "";
 headerDoc.level_for_value.innerHTML = "";
}
/************************User window*********************************/
function showApplUserWindow(target){
getHandleHeader();
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

var frmObj = f_query_add_mod.f_query_add_mod_header.document.privilegeHeader;

argumentArray[0]   = formObjHeader.appl_user_sql.value;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";

if(target.value != "" && target.value != " " && target.value != null)
	{
	argumentArray[5]   = target.value;
	}
else
	argumentArray[5]   = "";
argumentArray[6]   = CODE_LINK ;
argumentArray[7]   = CODE_DESC ; 

retVal = await CommonLookup( getLabel("eOR.ApplicationUser.label","OR"), argumentArray );

if(retVal != null && retVal != ""){
target.value = retVal[1];
formObjHeader.appl_user_id.value = retVal[0];
formObjHeader.appl_user_name.value = retVal[1];
}
else
	{
		target.value = "";
	}
}
/********************Relationship window****************************************/
function showRelnWindow(target){
getHandleHeader();
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

var frmObj = f_query_add_mod.f_query_add_mod_header.document.privilegeHeader;

argumentArray[0]   = formObjHeader.reln_sql.value;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";

if(target.value != "" && target.value != " " && target.value != null)
	{
	argumentArray[5]   = target.value;
	}
else
	argumentArray[5]   = "";
argumentArray[6]   = CODE_LINK ;
argumentArray[7]   = CODE_DESC ; 

retVal = await CommonLookup( getLabel("Common.relationship.label","Common"), argumentArray );

if(retVal != null && retVal != ""){
target.value = retVal[1];
formObjHeader.reln_id.value = retVal[0];
formObjHeader.pract_reln_name.value = retVal[1];
}
else
	{
		target.value = "";
	}
}
/********************Responsibility window****************************************/
function showRespWindow(target){
getHandleHeader();
var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

var frmObj = f_query_add_mod.f_query_add_mod_header.document.privilegeHeader;

argumentArray[0]   = formObjHeader.resp_sql.value;
argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";

if(target.value != "" && target.value != " " && target.value != null)
	{
	argumentArray[5]   = target.value;
	}
else
	argumentArray[5]   = "";
argumentArray[6]   = CODE_LINK ;
argumentArray[7]   = CODE_DESC ; 

retVal = await CommonLookup( getLabel("eOR.Responsibilty.label","OR"), argumentArray );

if(retVal != null && retVal != ""){
target.value = retVal[1];
formObjHeader.resp_id.value = retVal[0];
formObjHeader.resp_name.value = retVal[1];
}
else
	{
		target.value = "";
	}
}

/******************************************************************************/
function deleterecord(){
	
	if (! checkIsValidForProceed() ) {		
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandleDetail();
	getHandleHeader();
		
	if((formObjDetail) && headerDoc.mode.value != MODE_INSERT){
		
		 detailDoc.mode.value = MODE_DELETE;
		eval(formApply(formObjDetail,OR_CONTROLLER));
		f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeAddModify.jsp?mode=1&function_id="+function_id ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if( resultGlobal ) {
			
			f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeAddModify.jsp?mode=1&function_id="+function_id ;
		}
	}else{
		
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}
/******************************************************************************/
function apply() {
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	getHandleDetail();
	getHandleHeader();
	var privilege_id_string = "";
	/*Tranfer all  the values to  be transferred to bean form  Header Page to detail Page*/
	formObjDetail.privilege_ctx.value   =formObjHeader.privilege_ctx.value;
	formObjDetail.facility_id.value		=formObjHeader.facility_id.value;
//alert("MODE"+mode);
	var optObj		= formObjDetail.privilege_id;
	var optObjLabel = getLabel("eOR.Privilege.label","OR");
	
	if(formObjHeader.resp_id != undefined && formObjHeader.resp_id != null)
	{
		
		formObjDetail.resp_id.value	      =	formObjHeader.resp_id.value ;
		optObj = formObjDetail.resp_id ;
		optObjLabel = getLabel("eOR.Responsibilty.label","OR");
		formObjDetail.reln_id.value	      ="";
		formObjDetail.appl_user_id.value  ="";

	}
	else
		if(formObjHeader.reln_id != undefined && formObjHeader.reln_id != null)
		{
		
			formObjDetail.reln_id.value	      =	formObjHeader.reln_id.value	;	
			optObj = formObjDetail.reln_id ; 
			optObjLabel = getLabel("Common.relationship.label","Common");
			formObjDetail.appl_user_id.value  ="";
			formObjDetail.resp_id.value	="";

		}
	else
	if(formObjHeader.appl_user_id != undefined && formObjHeader.appl_user_id != null)
	{
		
		formObjDetail.appl_user_id.value  = formObjHeader.appl_user_id.value ;
		
		optObj = formObjDetail.appl_user_id ;//modified by Subhash.Y actual value "formObjHeader." 
		
		optObjLabel = getLabel("eOR.ApplicationUser.label","OR");
		formObjDetail.reln_id.value	      ="";
		formObjDetail.resp_id.value	="";
		//modified by Subhash.Y on 5th May 2004 actual value "Application User"
	}

	/****************/
		
	if(headerDoc.mode.value == MODE_INSERT) 
	{

		//alert(levelChk);
		if(levelChk == false)
		{
			
			var	fields = new Array (formObjHeader.privilege_ctx,formObjHeader.facility_id);
			var	names =	new	Array (getLabel("eOR.Level.label","OR"),getLabel("Common.facility.label","Common"));	
		}
		else
		{
			//alert(formObjHeader.privilege_ctx.value+"====="+optObj.value+"==="+formObjHeader.facility_id.value);
			var	fields = new Array (formObjHeader.privilege_ctx,optObj,formObjHeader.facility_id);
			var	names =	new	Array (getLabel("eOR.Level.label","OR"),optObjLabel,getLabel("Common.facility.label","Common"));	
		}
	//alert(messageFrame.value);
	//messageFrame=parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp
	if(!f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
		{
		
		return ;
		}
	}
	
	if(headerDoc.mode.value == MODE_INSERT)
	{
		//alert("formObjDetail.noOfRecords.value"+formObjDetail.noOfRecords.value);
		var noOfRecords = formObjDetail.noOfRecords.value;
		var latest =applyupdate();
		if(latest){
				//alert(formObjDetail.value);
				//alert(eval(formApply(formObjDetail,OR_CONTROLLER)));
				eval( formApply(formObjDetail,OR_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
				atleastOne = false;
				messageGlobal = "";
				if(resultGlobal){
				onSuccess();
				
				return true ;
				}else{
					//alert("here");
				return false ;	
				}		
		}
   }//if
  
  if(headerDoc.mode.value == MODE_MODIFY)
	{
		
		var latest =applyupdate();
		if(latest){

			eval( formApply(formObjDetail,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			atleastOne = false;
			messageGlobal = "";
			if(resultGlobal){
			onSuccess();
			return true ;
			}else{
			return false ;	
			}
		}

	}//end of if -- MODIFY condition...
	
}
/******************************************************************************/
function onSuccess() {
	
	getHandleHeader();
	if( headerDoc.mode.value == MODE_INSERT ) 
	create();
	if( headerDoc.mode.value == MODE_MODIFY ) {
	f_query_add_mod.document.location.href="../../eOR/jsp/PrivilegeAddModify.jsp?"+formObjHeader.qry_str.value ;
	}
}
/******************************************************************************/
function beforePost()
{
	alert("RRRR"+xmlstr);
}

function reset() {
	var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if ( (url.indexOf("queryresult.jsp")!=-1) ||  (url.indexOf("blank")!=-1) )
		 return ;
	if(f_query_add_mod.f_query_add_mod_header !=null){
	getHandleDetail();
	getHandleHeader();

	if(headerDoc.mode.value == MODE_INSERT) 
	create();
	
	if(headerDoc.mode.value == MODE_MODIFY) {
	f_query_add_mod.document.location.href="../../eOR/jsp/PrivilegeAddModify.jsp?"+formObjHeader.qry_str.value ;
	}
	
	}else{
    f_query_add_mod.document.forms[0].reset(); //reset in query mode
	}

	levelChk = false;

}
/******************************************************************************/
function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
}
/**************************************************************************/
function resetLower(){
	
}
/*********************Header Handle*****************************/
function getHandleHeader(){
if(f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;	
 formObjHeader   =headerDoc.privilegeHeader ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	{
	 
	 return false;
	}
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;	
 //alert("detailDoc"+f_query_add_mod.f_query_add_mod_detail.document.value);
 formObjDetail	 =detailDoc.privilegeDetail;
}
/******************************************************************/
//Added by Subhash.Y to assign the privilege value to the hidden variable from the list box
function assignPrivilege(target)
{
	getHandleDetail();
	var name = target.name;
	var len = name.length;
	var character = name.charAt(len-1);
}
function checkActive(target)
{
	//alert(target.checked);
	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
		
	}

}

function checkFlag()
{
	levelChk = true;
}
/*******************************************************************/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/***************************************************************************/
function applyupdate()
{
	getHandleDetail();
	getHandleHeader();
	if(f_query_add_mod.location.href.indexOf(".jsp") != -1){
		
		var bean_id		= formObjDetail.bean_id.value;
		var bean_name	= formObjDetail.bean_name.value;
		var incld;
		var value_str	= "";var c=new Array;var d=new Array;
		var privilege_id_string = "";
		var privilege_value_string="";
		var noOfRecords = formObjDetail.noOfRecords.value;
		var oldvalue = formObjDetail.oldvalues.value;
				
		var flag="";
		for(var i=0;i<noOfRecords;i++)
		{	
		var grp_exception_id=eval("formObjDetail.grp_exception_id"+i).value;
		
			for(var j=1;j<=9;j++)
			{	
																			
					if(j==1)
						{															
							privilege_id_string = privilege_id_string + "O,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						}

					else if(j==2)
						{
						
							privilege_id_string = privilege_id_string + "V,";						privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";

						}
					else if(j==3)
						{

							privilege_id_string = privilege_id_string + "C,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						}

					else if(j==4)
						{
							privilege_id_string = privilege_id_string + "A,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";					
						
						}
					else if(j==5)
						{
							privilege_id_string = privilege_id_string + "U,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						}
					else if(j==6)
						{
							privilege_id_string = privilege_id_string + "S,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						
						}
					else if(j==7)
						{
							privilege_id_string = privilege_id_string + "P,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						
						}
					else if(j==8) 
						{
							privilege_id_string = privilege_id_string + "H,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						
						}
					else if(j==9)
						{
							privilege_id_string = privilege_id_string + "D,";							privilege_value_string=privilege_value_string+eval("formObjDetail.privilege_value"+i+j).value+",";
						}				
			}
			
			if(privilege_id_string != "")
				{
					value_str += i+"||"+grp_exception_id+","+privilege_value_string+","+privilege_id_string+"~";
					privilege_id_string="";
					privilege_value_string="";
				}

		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FLAG_VALUES=\""+ flag + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " CLASS_NAME=\"PrivilegeBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PrivilegeAssignValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;
	}
	else
	{
		return true;
	}
   
}
/***************************************************************************/
/**Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	Privilege.jsp---->Privilege.js
		|
		|------MstToolBar
		|
		|------PrivilegeAddModify.jsp  
		|		|
		|		|---PrivilegeAddModifyHeader.jsp 
		|		|		Document ---headerDoc			
		|		|		FormObect---formObjHeader		
		|		|
		|		|---PrivilegeAddModifyDetail.jsp =>insert mode
		|		|		Document ---detailDoc				
		|		|		FormObect---formObjDetail			   
		|
		|------MessageFrame
		|
**/



