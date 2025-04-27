function create()
{
	frames[1].location.href = '../../eDR/jsp/DRUserRightsAddMod.jsp?operation=insert';
	//parent.frames[1].frames[2].location.href = '../../eDR/jsp/dummy.jsp';
	frames[2].location.href = '../../eDR/jsp/dummy.jsp';
}

function query()
{
	frames[1].location.href = '../../eDR/jsp/DRUserRightsCriteria.jsp?';
	frames[2].location.href = '../../eDR/jsp/dummy.jsp';
}

function changeVal()
{
	if (parent.frames[1].document.forms[0].p_enabled.checked == true)
	{
			parent.frames[1].document.forms[0].p_enabled.value= 'E';
	}
	else if (parent.frames[1].document.forms[0].p_enabled.checked == false)
	{
			parent.frames[1].document.forms[0].p_enabled.value= 'D';
	}
}

function printUserName()
{
	var p_user_id = parent.frames[1].document.forms[0].p_user_name.value;
	parent.frames[1].location.href = '../../eDR/jsp/DRUserRightsAddMod.jsp?operation=insert&p_appl_user_id='+p_user_id;
}

function apply()
{
	if(frames[1].document.forms[0].name == 'DRUserRights')
	{

	//var p_appl_user = parent.frames[1].frames[1].document.forms[0].p_user_name.value ;
	var p_appl_user = frames[1].document.forms[0].p_user_name.value ;

	if(p_appl_user.length == 0)
	{
		var ErrorText = getMessage('ANY_ONE_CRITERIA','Common');
		//parent.frames[1].frames[3].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num="+ErrorText;	
		frames[3].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num="+ErrorText;	
	}
	else
	{
		//parent.frames[1].frames[1].document.forms[0].submit();
		frames[1].document.forms[0].submit();
	}
}	
else
	{
	//parent.frames[1].frames[3].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	frames[3].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}

}

function PopEmpNo(p_user_name,user_id)
{
	document.forms[0].EMPNO.value='';
	var  HTMLVal = new String();

	HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dum_form' id='dum_form' method='post' action='../../eDR/jsp/DRUserRightspopulate.jsp'><input type='hidden' name='user_id' id='user_id' value='"+user_id+"'><input type='hidden' name='p_user_name' id='p_user_name' value='"+p_user_name+"'><input type='hidden' name='step' id='step' value='1'></form></body></html>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.dum_form.submit();
	
}

function getUserId(obj)
{
	var EmpNo=document.forms[0].EMPNO.value;
	var  HTMLVal = new String();

	HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dum_form' id='dum_form' method='post' action='../../eDR/jsp/DRUserRightspopulate.jsp'><input type='hidden' name='EmpNo' id='EmpNo' value='"+EmpNo+"'><input type='hidden' name='step' id='step' value='2'></form></body></html>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.dum_form.submit();
}

/*function displayUser(obj,target,target_id)
{
	var retVal = new String();

	var dialogHeight	= "28";
	var dialogWidth		= "43";
	var dialogLeft		= "500";
	var status			= "no";
	var arguments		= "";
	var sql				= "";
	var search_code		= "";
	var search_desc		= document.forms[0].userID.value;
	var dispDescFirst	= "dispDescFirst";
	var tit				= encodeURIComponent(getLabel("Common.username.label","Common"));
	var practtype		= "";
		
	sql			= " select appl_user_id, APPL_USER_NAME from sm_appl_user where  eff_status = `E` and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) ";
	search_code	= "appl_user_id";
	search_desc = "APPL_USER_NAME";
			
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
	retVal			= window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst="+dispDescFirst,arguments,features);
	var arr			= new Array();
		
	if(!(retVal == null))
	{
		var ret1		= unescape(retVal);
		arr				= ret1.split("::");
		target.value	= arr[0];
		target_id.value	= arr[1];
		PopEmpNo(arr[0], arr[1]);
	}
	else
	{
		target.value	= "";
		target_id.value	= "";
		document.forms[0].EMPNO.readonly	= false;
		document.forms[0].EMPNO.disabled	= false;
		document.forms[0].EMPNO.value		= '';
	}
}
*/

async function displayUser(obj,target,target_id)
{


	
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("Common.username.label","Common");
		var sql="";

		


	    
		sql			= " select appl_user_id code, APPL_USER_NAME description from sm_appl_user where  eff_status = 'E' and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) and upper(appl_user_id) like upper(?) and upper(APPL_USER_NAME)  like upper(?) ";
	
	
		
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].userID.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		} 
	 	
		if (!(retVal == null||retVal == ""))
		{
				
		var ret1=unescape(retVal);
		arr=ret1.split(",");
			target.value=arr[1];
			target_id.value=arr[0];

			PopEmpNo(arr[0], arr[1]);
			
			
			
		}
		else
	{	
		target.value	= arr[1];
		target_id.value	= arr[0];
		document.forms[0].EMPNO.readonly	= false;
		document.forms[0].EMPNO.disabled	= false;
		document.forms[0].EMPNO.value		= '';
		
	}

}




function touppercase(obj)
{
	obj.value = obj.value.toUpperCase();
}

function callDummy()
{
	parent.frames[2].location.href = '../../eDR/jsp/dummy.jsp';
}

function reset()
{ 
	if(frames[1].name!="query_form_results")
{
	if(frames[1].document.getElementById('EMPNO')!=null){
		frames[1].document.getElementById('EMPNO').readonly=false;
		frames[1].document.getElementById('').reset();
		
	}
	
}
}

function onSuccess()
{
	frames[1].location.reload();
}

