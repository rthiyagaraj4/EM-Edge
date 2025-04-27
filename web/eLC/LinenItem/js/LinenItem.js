
/***********************************************************
/*                  LinenItem.JS
/***********************************************************/

function create() {
content.location.href=contextPath+"/LinenItemAction.do?method="+loadMethod+"&vo.functionId="+functionId
}

function apply() {
	content.document.getElementById("vo.linenType.linenTypeCode").disabled=false;
	if(checkNullLocal())
	content.LinenItemForm.submit(); 

}
function query() {
	content.location.href=contextPath+"/LinenItemAction.do?method="+queryMethod+"&vo.functionId="+functionId
	
}
//========== TEXT AREA VALIDATION==========
function textAreaLimit(field, maxlen) {
if (field.value.length > maxlen + 1)
	{
		var textVal=field.value.substring(0, maxlen);
		field.value=textVal;
		getServerMessage("APP-LC00015");
		var msg = dwrMessage;
		splitMsg = msg.split("#");
		getServerMessage("com.iba.ehis.lc.characters")
		var lable = dwrMessage;
		alert(splitMsg[0]+" "+splitMsg[1]+" "+maxlen+" "+lable);
		//alert('Should not be more than  '+maxlen+" characters");
	}
	return textVal;

}
//============================
function loadResult(linenitem){
content.location.href=contextPath+"/LinenItemAction.do?vo.linenItem="+linenitem+"&method="+loadMethod+"&vo.functionId="+functionId
}
function addCriteria()
{
	var criteria;
	criteria=content.QueryCriteriaForm.vo.orderBySelected.itemValue;
 }
 function reset()
 {
 if(content.LinenItemForm.method.value==updateMethod)
  {
  var linenItem=content.document.getElementById("vo.linenItem").value;
  loadResult(linenItem)
  }
  else
  {
   	content.location.href=contextPath+"/LinenItemAction.do?method="+loadMethod+"&vo.functionId="+functionId
   }	
 }
 
function checkNullLocal()
 { 
 	var flag;
   var fieldName = new Array("com.iba.ehis.lc.linenItem", "com.iba.ehis.lc.longDesc", "com.iba.ehis.lc.shortDesc","com.iba.ehis.lc.linenType");
	var fields = new Array(content.document.LinenItemForm["vo.linenItem"], content.document.LinenItemForm["vo.longDesc"], content.document.LinenItemForm["vo.shortDesc"],content.document.LinenItemForm["vo.linenType.linenTypeCode"]);
 	flag=checkNullDS(fieldName,fields);
	if(flag==false) return false; else return true;
 }
//============================= DISABLE FILEDS=================
function disable()
 {
 	 if(document.getElementById("method").value==2)
 	 {
	 	document.getElementById("vo.linenItem").readOnly="readonly";
	  	
		if(document.getElementById("vo.effStatus").checked==false)
	 		{
	 		    document.getElementById("vo.shortDesc").readOnly="readonly";
	 		    document.getElementById("vo.longDesc").readOnly="readonly";
				document.getElementById("vo.linenType.linenTypeCode").disabled=true;
				document.getElementById("vo.disposable").disabled=true;
	 			
			 }
	 }else 
	 {
 		document.getElementById("vo.disposable").checked=true;
 		document.getElementById("vo.effStatus").checked=true;
		document.getElementById("vo.effStatus").value="E";

	 }
 }
 //============= END OF SCRIPT================