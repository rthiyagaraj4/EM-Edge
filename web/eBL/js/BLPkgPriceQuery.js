function create() {
	parent.frames[2].f_query_add_mod.location.href = "../../eBL/jsp/BLPkgPriceQueryFrame.jsp";
}

function reset() {
	BLPkgPriceQueryFrame.document.location.reload();
}

function query() {	
	parent.frames[2].f_query_add_mod.location.href ="../../eBL/jsp/BLPkgPriceQueryFrame.jsp";
}

function apply() {
	
}

function onSuccess()
{
	parent.frames[2].f_query_add_mod.location.href = "../../eBL/jsp/BLPkgPriceQueryFrame.jsp";
}

function OnExecute(){
	var params="?userId="+document.frmPrevilageCardMaster.userId.value + "&status=" + document.frmPrevilageCardMaster.status.value  + "&date="+document.frmPrevilageCardMaster.date.value ;
	parent.f_query_add_mod.location.href = "../../eBL/jsp/BLPkgPriceQueryResult.jsp" + params;
}

function dateOnBlur(targetDate){	
 	var dateCorrect=false;

		if(targetDate.value==""){
			dateCorrect=true;
		}
		else{
		dateCorrect=checkDt(targetDate);
		}

	if(dateCorrect==false){
		alert(getMessage("INVALID_DATE_FMT","SM"));
		targetDate.value="";
	}
}

async function fetchCodeDescriptionForUser(codeDesc) {
	var sql=document.frmBLPkgPriceQueryForm.getUserQry.value;
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = getLabel("Common.userid.label", 'Common');

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = document.frmBLPkgPriceQueryForm.userId.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = document.frmBLPkgPriceQueryForm.userName.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}	
	retVal = await CommonLookup(tit, argumentArray);
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}
	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		document.frmBLPkgPriceQueryForm.userId.value= arr[0];
		document.frmBLPkgPriceQueryForm.userName.value= arr[1];
	} else {
		document.frmBLPkgPriceQueryForm.userId.value = "";
		document.frmBLPkgPriceQueryForm.userName.value= "";
	}
}

 async function fetchJobId() {
	var sql= "select code,description from (select distinct JOB_NO code,JOB_NO description from BL_PACKAGE_PRICE_UPDTN_REQ WHERE 1=1 ";
	var userId = document.frmBLPkgPriceQueryForm.userId.value;
	var sysDate = document.frmBLPkgPriceQueryForm.dateId.value;
//	if(userId != ''){
//		sql= "select code,description from (select distinct oracle_job_no code,oracle_job_no description from BL_PACKAGE_PRICE_UPDTN_REQ where TO_CHAR(added_date, 'dd/mm/yyyy')='"+sysDate+"' and user_id = '"+userId+"') where upper(description) like upper(?) and  upper(code) like upper(?)";
//	}
//	else{
//		sql= "select code,description from (select distinct oracle_job_no code,oracle_job_no description from BL_PACKAGE_PRICE_UPDTN_REQ where TO_CHAR(added_date, 'dd/mm/yyyy')='"+sysDate+"') where upper(description) like upper(?) and  upper(code) like upper(?)";
//	}
	
	
	if(userId != ''){
		sql+= " AND user_id = '"+userId+"' ";
	}
	if(sysDate!= ''){
		sql+= "  AND TO_CHAR(added_date, 'dd/mm/yyyy')='"+sysDate+"' ";
	}

	sql+=" ) where upper(description) like upper(?) and  upper(code) like upper(?)";
	
	var retVal = new String();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var tit = getLabel("eBL.JobId.label", 'Common');
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.frmBLPkgPriceQueryForm.jobId.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup(tit, argumentArray);
	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
	if (retVal != null && retVal != "") {
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		document.frmBLPkgPriceQueryForm.jobId.value= arr[0];
	} else {
		document.frmBLPkgPriceQueryForm.jobId.value = "";
	}
}
 
 function fnClearCode(obj){
		obj.value = '';
}
