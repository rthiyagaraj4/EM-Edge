 //********************************************************************************************
//  function create method
//********************************************************************************************
function create()
{	 	 
	
	window.f_query_add_mod.location.href="../../eXH/jsp/AuthorizedUserMaster.jsp?mode=I";
	//window.f_query_add_mod.document.forms[0].mode.value='C';
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	 //window.commontoolbarFrame.document.forms[0].apply.style.display='block';
	//window.commontoolbarFrame.document.forms[0].Delete.style.display='block';

}
//********************************************************************************************
//  function query method
//********************************************************************************************
function query()
{
	//window.commontoolbarFrame.document.forms[0].apply.style.display='none';
	//window.commontoolbarFrame.document.forms[0].Delete.style.display='none';
	window.f_query_add_mod.location.href="../../eXH/jsp/AuthorizedUserQueryCriteria.jsp";
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
//  function apply method
//********************************************************************************************
function apply()
{
    window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

	if(window.f_query_add_mod.document.Master_authorised_user_form)	{

	var fields = new Array ( f_query_add_mod.document.forms[0].login_name); 
	var names = new Array (getLabel("Common.login.label","common")+" "+getLabel("Common.name.label","common"));

	var tempModee=window.f_query_add_mod.document.forms[0].mode.value;
	//alert(tempModee);
	if((tempModee!='E')&&(tempModee!='D')&&(tempModee!='null')){
		if((tempModee=='I')){
			if(!f_query_add_mod.checkFields( fields, names, messageFrame))
			{	  
			}
			else
			{				//window.f_query_add_mod.document.forms[0].collected_string.value=window.f_query_add_mod.document.forms[0].view_yn.value+"[|]"+window.f_query_add_mod.document.forms[0].replay_yn.value+"[|]"+window.f_query_add_mod.document.forms[0].rebuild_yn.value;
			window.f_query_add_mod.document.forms[0].submit();
                window.f_query_add_mod.document.forms[0].reset();
			}
		} // end if 'I'
	}
	
	} // end  of Master_authorised_user_form

	else if(f_query_add_mod.document.AuthorisedUsers_Result){
		var select_flag = f_query_add_mod.document.forms[0].select_flag.value;
		//if(select_flag=='Y'){
	 
			window.f_query_add_mod.document.forms[0].mode.value='U';
			window.f_query_add_mod.document.forms[0].target = 	'messageFrame';
			window.f_query_add_mod.document.forms[0].action =' ../../servlet/eXH.AuthorizedUsersAddModifyServlet';
			window.f_query_add_mod.document.forms[0].submit();
		//} // end of select_flag
		//else{
		//		alert("Atleast one record should be selected");
		//}
//		window.f_query_add_mod.document.forms[0].target='';
         
		//window.f_query_add_mod.document.location.href='../../eXH/jsp/AuthorizedUserQueryResult.jsp?';
//		window.f_query_add_mod.document.forms[0].submit();
	} // AuthorisedUsers_Result
//window.f_query_add_mod.document.location.reload();
window.commontoolbarFrame.document.location.reload();	
}
//********************************************************************************************
// function reset 
//************************ *******************************************************************
function reset()
{
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}

}
//***********************************************************************************
// function DELETE
//********************************************************************************************
function deleterecord()
{
    window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

		if(window.f_query_add_mod.document.AuthorisedUsers_Result)	{
			var select_flag = f_query_add_mod.document.forms[0].select_flag.value;
			if(select_flag=='Y'){
				if(this.confirm(getMessage('XH1020'))==true){
					window.f_query_add_mod.document.forms[0].mode.value='D';
					window.f_query_add_mod.document.forms[0].target = 'messageFrame';
					window.f_query_add_mod.document.forms[0].action =' ../../servlet/eXH.AuthorizedUsersAddModifyServlet';
					window.f_query_add_mod.document.forms[0].submit();
				}// end of  delete confirm
			} // end of select_flag
			else{
				  alert("Atleast one record should be selected"); 
			}
		} // end of AuthorisedUsers_Result
//	window.f_query_add_mod.document.location.reload();	
	window.commontoolbarFrame.document.location.reload();	
}
//********************************************************************************************
// function validatecheckbox
//********************************************************************************************
function validatecheckbox(obj)
{
if(obj.checked==true) 	obj.value="Y";
else  obj.value="N";
	
}
//********************************************************************************************
// function validatecheckbox
//********************************************************************************************
function validatecheckbox1(obj)
{

if(obj.checked==true) 
	{
	obj.value="Y";
//	this.document.forms[0].mode.value='D';
	}
else obj.value="N";
	
}

//********************************************************************************************
// function check_status_fac
//********************************************************************************************

function check_status_fac(obj)
{
	if(document.forms[0].act_mode.value=='U')
		obj.value=document.forms[0].update_mode_login.value;

}
//********************************************************************************************
// function funShow
//********************************************************************************************

function funShow(obj)
{	
	this.document.forms[0].login_name.value = obj.getAttribute('login_name');
	this.document.forms[0].view_yn.value = obj.getAttribute('view_yn');
	this.document.forms[0].replay_yn.value = obj.getAttribute('replay_yn');
   // this.document.forms[0].edit_yn.value = obj.getAttribute('edit_yn');
	this.document.forms[0].rebuild_yn.value = obj.getAttribute('rebuild_yn');
   parent.commontoolbarFrame.document.forms[0].apply.style.display='block';
//	parent.commontoolbarFrame.document.forms[0].Delete.style.display='block';
	
   	this.document.forms[0].action =' ../../eXH/jsp/AuthorizedUserMaster.jsp';
	this.document.forms[0].mode.value='U';
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	
}
//********************************************************************************************
 async function GetLookup(target){
	
	        var locale=	this.document.forms[0].locale.value;
			var mode=this.document.forms[0].act_mode.value;
			
			var sql="";			
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;			
           var tit= getLabel("Common.login.label","common")+" "+getLabel("Common.name.label","common");			 
//			sql="SELECT appl_user_id code,appl_user_name description FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and upper(appl_user_id) like upper(?) and  upper(appl_user_name) like upper(?) AND  APPL_USER_ID NOT IN (SELECT LOGIN_NAME FROM XH_AUTHORIZED_USER) order by upper(appl_user_name)";

			sql="	SELECT A.APPL_USER_ID code,B.APPL_USER_NAME description FROM SM_RESP_FOR_USER A,SM_APPL_USER B WHERE		 A.RESP_ID = 'XH_JG_MANAGER'  and upper(A.appl_user_id) like upper(?) and  upper(B.appl_user_name) like upper(?)  AND A.APPL_USER_ID = B.APPL_USER_ID order by upper(B.appl_user_name)";

			if(mode=='U') {
				sql="	SELECT A.APPL_USER_ID code,B.APPL_USER_NAME description FROM SM_RESP_FOR_USER A,SM_APPL_USER B WHERE		 A.RESP_ID = 'XH_JG_MANAGER'  and upper(A.appl_user_id) like upper(?) and  upper(B.appl_user_name) like upper(?)  AND A.APPL_USER_ID = B.APPL_USER_ID order by upper(B.appl_user_name)";
			}
								 
			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2";
			argumentArray[5]	=target.value;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;
			if(mode!='U') {
			retVal = await CommonLookup( tit, argumentArray );
			}
			if(retVal != null && retVal != "" )
			{
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				target.value=arr[0];
				//target_id.value=arr[0];
				//clearValues();
				document.forms[0].user_id.value=arr[0];
			}
			else
			{
				//target.value="";
				//target_id.value="";
				//clearValues();

			}
	
}

//
