/*Created by Thamizh selvi on Oct 24th 2016 against MO-CRF-20113*/
function reset()
{
	//resultFrame.location.href="../../eCommon/html/blank.html";
	mainFrame.location.reload();
	setTimeout(function(){resultFrame.location.href = '../../eSM/jsp/ReleaseLockedUserSessionResults.jsp'},10);
	messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
}
function apply()
{	
	
	var userLists	= "";
	$('input[name="userChkBox"]',resultFrame.document).filter(':checked').each(function() {
		var id = $(this).val();
		userLists	+= id+",";
	});
	
	if(userLists != ""){
		userLists	= userLists.slice(0,-1);
		resultFrame.document.forms[0].finalData.value=userLists;
		resultFrame.document.forms[0].submit();	
	}
	else{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
	
}

function onSuccess(){
	
	parent.frames[2].location.href="../eSM/jsp/ReleaseLockedUserSession.jsp?home_required_yn=Y&menu_id=SM&module_id=SM&function_id=RELEASE_LOCKED_USER&function_name=Release Locked User Session&function_type=F&access=NYNNN";
}

function GetLookupBlur(target) {
	if(target.value != "") {
		GetLookup(target);
	} else {
		document.forms[0].userID.value="";
		//parent.resultFrame.location.href="../../eCommon/html/blank.html";
	}
}

async function GetLookup(target){
	
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.user.label",'Common');
				
	//sql="select a.APPL_USER_ID code,a.APPL_USER_NAME description from sm_appl_user a,sm_appl_user_audit b where a.APPL_USER_ID=b.APPL_USER_ID and upper(a.APPL_USER_ID) like upper(nvl(?,a.APPL_USER_ID)) and upper(a.APPL_USER_NAME) like upper(nvl(?,a.APPL_USER_NAME)) GROUP BY a.appl_user_id,a.appl_user_name order by 2";
	sql="select distinct a.APPL_USER_ID code,a.APPL_USER_NAME description from sm_appl_user a,sm_appl_user_audit b where a.APPL_USER_ID=b.APPL_USER_ID and upper(a.APPL_USER_ID) like upper(nvl(?,a.APPL_USER_ID)) and upper(a.APPL_USER_NAME) like upper(nvl(?,a.APPL_USER_NAME)) order by 2";
				

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ) {
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[0].userID.value=arr[0];
		submitPage(arr[0]);
	} else {
		target.value="";
	}
				
}

function submitPage(userID){
	parent.resultFrame.location.href="../../eSM/jsp/ReleaseLockedUserSessionResults.jsp?userID="+userID;
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
