function create()
{	
	f_query_add_mod.location.href="../../eBL/jsp/PkgUserAccessAddModify.jsp?mode=insert";	
}


function query()
{
	f_query_add_mod.location.href="../../eBL/jsp/PkgUserAccessQueryCriteria.jsp?mode=modify"
}
function reset(){
	if(f_query_add_mod){
		if(f_query_add_mod.document.PkgUserAccessAddModify!=null){
			f_query_add_mod.document.PkgUserAccessAddModify.reset();			
		}
		else if(f_query_add_mod.document.forms[0]!=null){
			f_query_add_mod.document.forms[0].reset();
		}else{
			f_query_add_mod.location.reload();
			return false;
		}
	}
}
/***************************************/
function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}
/***************************************/
function apply() {
	if (! checkIsValidForProceed() ) {
	//	message  = getMessage("NOT_VALID","BL");
	//	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	//	messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num="+message;
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return false ;
	}
	if(f_query_add_mod.document.PkgUserAccessAddModify!=null){
	var	formObj	= f_query_add_mod.document.PkgUserAccessAddModify ;
	var err_mess="";
	if(formObj.user_id.value==""){
		err_mess += getMessage("BL9112","BL")+"<br>";
		
	}
	if(formObj.user_name.value==""){
	err_mess += getMessage("BL8646","BL")+"<br>";
		
	}
	if(formObj.user_grp_id.value==""){
		err_mess += getMessage("BL8647","BL")+"<br>";
		
	}
	if(formObj.user_grp_name.value==""){
	err_mess += getMessage("BL8648","BL")+"<br>";
	
	}
	if(err_mess=="")
	{
		f_query_add_mod.document.forms[0].submit();
	}
	else
	{
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num="+err_mess;
	//	parent.frames[2].sslocation.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}
	
}
	
}

function onSuccess() {

	var mode = f_query_add_mod.document.PkgUserAccessAddModify.mode.value;
	
	if( mode == "insert" ) {
			f_query_add_mod.location.href ="../../eBL/jsp/PkgUserAccessAddModify.jsp?mode=1";	
	}
	if(mode == "modify"){
	
		f_query_add_mod.location.reload();
	}
}
async function UserIdLookUp(user_name,user_id){	
	var formObj=document.PkgUserAccessAddModify;
	if(formObj!=null){
		if(formObj.user_id_temp.value != user_id.value)
		{
			if(formObj.user_id.value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.user.label","common");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "select appl_user_id code, appl_user_name description from sm_appl_user_lang_vw where language_id='"+locale+"' and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by 2 ";				
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = user_id.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				formObj.user_grp_id.value= "";	
				formObj.user_grp_name.value= "";	
				formObj.user_grp_id_temp.value= "";	
				formObj.user_grp_name_temp.value= "";	
				retVal = await CommonLookup( title, argumentArray );
				var ret1=unescape(retVal);
				//alert("ret1"+ret1);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
				if(retVal != null && retVal != ""){
					user_name.value = arr[1];
					user_id.value =arr[0] ;
					formObj.user_id_temp.value= arr[0];
					formObj.user_name_temp.value= arr[1];						
				}else{
					user_name.value = "";
					user_id.value ="";
					formObj.user_id_temp.value= "";
					formObj.user_name_temp.value="";			
				}
			}
		}
	}
	
}
function UserNameLookUp(user_name,user_id){
	var formObj=document.PkgUserAccessAddModify;
	if(formObj!=null){
		if(formObj.user_name_temp.value != formObj.user_name.value)
		{	
			if(formObj.user_name.value != "")
				
				show_UserLookUp(user_name,user_id);
		}
	}
}
function UserLookUp(user_name,user_id){
	var formObj=document.PkgUserAccessAddModify;
		if(formObj!=null){
			if(formObj.user_name.value == ""){
			show_UserLookUp(user_name,user_id);
			}
		}
}
async function show_UserLookUp(user_name,user_id){	
	var formObj=document.PkgUserAccessAddModify;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.user.label","common");
	var locale=formObj.locale.value;	
	argumentArray[0]	=   "select appl_user_id code, appl_user_name description from sm_appl_user_lang_vw where language_id='"+locale+"' and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by 2 ";					
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = user_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	formObj.user_grp_id.value= "";	
	formObj.user_grp_name.value= "";	
	formObj.user_grp_id_temp.value= "";	
	formObj.user_grp_name_temp.value= "";	
 	if(retVal != null && retVal != ""){
   		user_name.value = arr[1];
 		user_id.value =arr[0] ;
		formObj.user_id_temp.value= arr[0];
		formObj.user_name_temp.value= arr[1];		
 	}else{
		user_name.value = "";
		user_id.value ="";
		formObj.user_id_temp.value= "";
		formObj.user_name_temp.value="";		
	}
}
async function UserGrpIdLookUp(user_grp_name,user_grp_id){	
	var formObj=document.PkgUserAccessAddModify;
	if(formObj!=null){
		if(formObj.user_grp_id_temp.value != user_grp_id.value)
		{
			if(formObj.user_grp_id.value != ""){		
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.userGroup.label","BL");
				var locale=formObj.locale.value;				
				argumentArray[0]	=  "select user_group_id code, short_desc description from bl_user_group_lang_vw where language_id='"+locale+"' and upper(user_group_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";				
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = user_grp_id.value ;
				argumentArray[6]   = CODE_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				var ret1=unescape(retVal);
				//alert("ret1"+ret1);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
				if(retVal != null && retVal != ""){
					user_grp_name.value = arr[1];
					user_grp_id.value =arr[0] ;
					formObj.user_grp_id_temp.value= arr[0];
					formObj.user_grp_name_temp.value= arr[1];						
				}else{
					user_grp_name.value = "";
					user_grp_id.value ="";
					formObj.user_grp_id_temp.value= "";
					formObj.user_grp_name_temp.value="";			
				}
			}
		}
	}
	
}
function UserGrpNameLookUp(user_grp_name,user_grp_id){
	var formObj=document.PkgUserAccessAddModify;
	if(formObj!=null){
		if(formObj.user_grp_name_temp.value != formObj.user_grp_name.value)
		{	
			if(formObj.user_grp_name.value != "")
				
				show_UserGrpLookUp(user_grp_name,user_grp_id);
		}
	}
}
function UserGrpLookUp(user_grp_name,user_grp_id){
	var formObj=document.PkgUserAccessAddModify;
		if(formObj!=null){
			if(formObj.user_grp_name.value == ""){
			show_UserGrpLookUp(user_grp_name,user_grp_id);
			}
		}
}
async function show_UserGrpLookUp(user_grp_name,user_grp_id){	
	var formObj=document.PkgUserAccessAddModify;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.userGroup.label","BL");
	var locale=formObj.locale.value;	
	argumentArray[0]	=   "select user_group_id code, short_desc description from bl_user_group_lang_vw where language_id='"+locale+"' and upper(user_group_id) like upper(?) and upper(short_desc) like upper(?) order by 2";					
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = user_grp_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
 	if(retVal != null && retVal != ""){
   		user_grp_name.value = arr[1];
 		user_grp_id.value =arr[0] ;
		formObj.user_grp_id_temp.value= arr[0];
		formObj.user_grp_name_temp.value= arr[1];		
 	}else{
		user_grp_name.value = "";
		user_grp_id.value ="";
		formObj.user_grp_id_temp.value= "";
		formObj.user_grp_name_temp.value="";		
	}
}

function chkUserAccess(obj){
	if(obj.checked){
		obj.value="Y";
	}else{
		obj.value="N";
	}
	
}
