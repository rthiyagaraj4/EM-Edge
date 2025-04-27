
/************************************************************
/*                  LINENTYPE.JS
/***********************************************************/

function create() {
content.location.href=contextPath+"/LinenTypeAction.do?method="+loadMethod+"&vo.functionId="+functionId
}
function update()
{
linenType=cotent.document.getElementById("vo.linenTypeCode");
content.location.href=contextPath+"/LinenTypeAction.do?method="+loadMethod+"&vo.linenTypeCode"+linenType+"&vo.functionId="+functionId
}
function apply() {
	if(checkNullLocal())
	content.LinenTypeForm.submit(); 
  
}
function query() {
	content.location.href=contextPath+"/LinenTypeAction.do?method="+queryMethod+"&vo.functionId="+functionId
	
}
function deleterecord() {
	content.LinenTypeForm.method.value=deleteMethod
	var flag=checkNull();
	if(flag==true)
	content.LinenTypeForm.submit();
	
	
}
function loadResult(linentype){
content.location.href=contextPath+"/LinenTypeAction.do?vo.linenTypeCode="+linentype+"&method="+loadMethod+"&vo.functionId="+functionId
}
function addCriteria()
{
	var criteria;
	criteria=content.QueryCriteriaForm.vo.orderBySelected.itemValue;
 }
 function reset()
 {
 	if(content.LinenTypeForm.method.value=='2')
  {
  var linentype=content.document.getElementById("vo.linenTypeCode").value;
  loadResult(linentype)
  }
  else
   	content.location.href=contextPath+"/LinenTypeAction.do?method="+loadMethod+"&vo.functionId="+functionId
 }

function checkNullLocal()
 { 
 	var flag;
    var fieldName=new Array("com.iba.ehis.lc.linenType", "com.iba.ehis.lc.description");
	var fields = new Array(content.document.LinenTypeForm["vo.linenTypeCode"], content.document.LinenTypeForm["vo.linenTypeDesc"]);
 	flag=checkNullDS(fieldName,fields);
	if(flag==false) return false; else return true;
 }



