
/***********************************************************
/*                   LaundryUser.JS
/***********************************************************/
//Global variables
var pageNum = 1;
var checkArray = new Array();
var userArray = new Array();
var flag=false;
var AUserArray = new Array();

function disable()
{
 if(document.getElementById("method").value==2)
	{
	
	 if(!document.getElementById("vo.overRideWardConf").checked)
		{
	     document.getElementById("lookup").disabled=true;
		 document.getElementById("vo.user").readOnly=true;
		 } 
	}else
		document.getElementById("vo.overRideWardConf").checked=true
}
function create() {
	content.location.href = contextPath + "/LaundryUserAction.do?method=" + loadMethod+"&vo.functionId="+functionId;
}
function apply() {
if(checkNullLocal()) {
		content.document.LaundryUserForm.submit();
	}
}
function deleterecord() {
	if(checkNullLocal()){
	content.LaundryUserForm.method.value=deleteMethod
	content.LaundryUserForm.submit();
	
	}
	
	
}
function query() {
	content.location.href=contextPath+"/LaundryUserAction.do?method="+queryMethod+"&vo.functionId="+functionId
	
}
function loadResult(user,overRideWardConf){
		content.location.href=contextPath+"/LaundryUserAction.do?vo.user="+user+"&vo.overRideWardConf="+overRideWardConf+"&method="+loadMethod+"&vo.functionId="+functionId
}
function reset()
 {
 if(content.LaundryUserForm.method.value==updateMethod)
  {
	var user=content.document.getElementById("vo.user").value;
	var overRideWardConf=content.document.getElementById("vo.overRideWardConf");
			if(!overRideWardConf.checked)
			 {
				overRideWardConf.value='N';
				 loadResult(user,overRideWardConf.value);
			 }else
			 {
				 overRideWardConf.value='Y';
				 loadResult(user,overRideWardConf.value);
			 }
 
  }
  else
  {
   	content.location.href=contextPath+"/LaundryUserAction.do?method="+loadMethod
   }	
 }

function showLookup() {
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = "ehis.lc.laundryUser.getUser";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("vo.user").value;
	getServerMessage("com.iba.ehis.lc.usercode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.getElementById("vo.user");
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];
			}
			else
			{
			document.getElementById("vo.user").value="";
			}
	
}
function checkNullLocal()
 { 
 	var flag;
    var fieldName = new Array("com.iba.ehis.lc.laundryUser.user");
	var fields = new Array(content.document.getElementById("vo.user"));
 	flag=checkNullDS(fieldName,fields);
	if(flag==false) return false; else return true;
 }
