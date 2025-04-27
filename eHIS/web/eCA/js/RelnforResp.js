function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyRelnForResp.jsp';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaRelnForResp.jsp';
}

function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null && f_query_add_mod.document.forms[0].mode!=null)
	{
		if(f_query_add_mod.document.forms[0].mode.value != 'insert')
		{
			f_query_add_mod.document.forms[0].mode.value = 'delete';
			
			var confmsg = f_query_add_mod.getMessage("DELETE_RECORD",'common');
			var confirmDelete = window.confirm(confmsg);

			if(confirmDelete==true)
			{
				f_query_add_mod.document.forms[0].submit();
			}
			else
				commontoolbarFrame.location.reload();
		}
		else
		{
				var errorMsg = f_query_add_mod.getMessage("RECORD_CANNOT_DELETE",'CA');
				messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
		}
	}
	else
	{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_val=1&err_num= ';
	}
}


function apply(){
	if(f_query_add_mod.document.forms[0] !=null)
	{

	if(f_query_add_mod.document.forms[0].canAssign.checked)
		f_query_add_mod.document.forms[0].can_asgn_val.value='Y'
	 else
		f_query_add_mod.document.forms[0].can_asgn_val.value='N'


	 if(f_query_add_mod.document.forms[0].canHold.checked)
		f_query_add_mod.document.forms[0].can_hold_val.value='Y'
	 else
		f_query_add_mod.document.forms[0].can_hold_val.value='N'

	if(f_query_add_mod.document.forms[0].canTerminate.checked)
		f_query_add_mod.document.forms[0].can_terminate_val.value='Y'
	 else
		f_query_add_mod.document.forms[0].can_terminate_val.value='N'

	if(f_query_add_mod.document.forms[0].mode.value == "insert"){
		var fields = new Array (f_query_add_mod.document.RelnForResp_form.resp_id,f_query_add_mod.document.RelnForResp_form.pract_reln_id);
		var names = new Array ( getLabel("Common.responsibility.label",'common'),getLabel("Common.relationship.label",'common'));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			f_query_add_mod.document.RelnForResp_form.submit();		
		}
	}
	
	else if(f_query_add_mod.document.forms[0].mode.value == "modify"){
		var fields = new Array (f_query_add_mod.document.RelnForResp_form.resp_id,f_query_add_mod.document.RelnForResp_form.pract_reln_id);	

		var names = new Array ( getLabel("Common.responsibility.label",'common'),getLabel("Common.relationship.label",'common'));
		
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
			f_query_add_mod.document.RelnForResp_form.submit();		
		}
	}
	}
	else{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_val=1&err_num= ';
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyRelnForResp.jsp';
	else if(f_query_add_mod.document.forms[0].mode.value=="delete")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyRelnForResp.jsp';
	else
         f_query_add_mod.location.reload();
}

function reset(){	
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

function checkRelationship(relObject)
	{
		var target  = document.forms[0].pract_reln_name;	
		if(relObject.name=='pract_reln_name')
		{				
			if((target.value) == "null" || (target.value ==""))
			{
				return false;			
			}
			else
			{
				checkRelationshipWindow();
			}
		}
		else if(relObject.name=='reln_desc_search')
		{		
			checkRelationshipWindow();
		}
		
		/*var target			= document.forms[0].pract_reln_name;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			=getLabel('Common.relationship.label','COMMON'); 
		var sql="Select  pract_reln_id,pract_reln_name from ca_pract_reln where eff_status=`E` AND DIRECT_YN = `Y`";

		search_code="pract_reln_id";
		search_desc="pract_reln_name";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);
		   	arr=retVal.split("::");
			document.forms[0].pract_reln_name.value=arr[0];
		   	document.forms[0].pract_reln_id.value=arr[1];
			document.forms[0].pract_reln_name.focus();
		}
		else
		{
			document.forms[0].pract_reln_name.value="";
			document.forms[0].pract_reln_id.value="";
			target.focus();
		}*/
	}

async function checkRelationshipWindow()
{
		var target = document.forms[0].pract_reln_name;		
		//var search_code="pract_reln_id";
		//var search_desc="pract_reln_name";
		var sql = "Select  pract_reln_id code,pract_reln_name description from ca_pract_reln where eff_status='E' AND DIRECT_YN = 'Y' and upper(pract_reln_id) like upper(?) and upper(pract_reln_name) like upper(?) order by 2 ";
		var title	= getLabel('Common.relationship.label','COMMON');
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.forms[0].pract_reln_name.value = arr[1];
			document.forms[0].pract_reln_id.value = arr[0];
			
		}
		else
		{
			document.forms[0].pract_reln_name.value="";
			document.forms[0].pract_reln_id.value="";
			target.focus();
		}

}

function checkResponsibility(respObject)
	{
		var target  = document.forms[0].resp_name;	
		if(respObject.name=='resp_name')
		{				
			if((target.value) == "null" || (target.value ==""))
			{
				return false;			
			}
			else
			{
				checkResponsibilityWindow();
			}
		}
		else if(respObject.name=='resp_desc_search')
		{		
			checkResponsibilityWindow();
		}
		
	}

	async function checkResponsibilityWindow()
	{		
		var target			= document.forms[0].resp_name;		
		var search_code="resp_name";
		var search_desc="resp_name";
		var sql = "Select resp_id code, resp_name description from sm_resp where eff_status='E' and nvl(eff_date_from,trunc(sysdate))<=trunc(sysdate) and nvl(eff_date_to,trunc(sysdate))>=trunc(sysdate) and upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by 2 ";
		var title			= getLabel('Common.responsibility.label','COMMON');
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.forms[0].resp_name.value = arr[1];
			document.forms[0].resp_id.value = arr[0];
		}
		else
		{
			document.forms[0].resp_name.value="";
			document.forms[0].resp_id.value="";
			target.focus();
		}

	}

	function CheckForSpecCharsWithSpaceBlur(ObjText)
	{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;
	}


	function resetValues()
	{
	   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		
	}
