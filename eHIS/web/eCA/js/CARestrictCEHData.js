
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
function apply() {
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var xmlStr		= "<root><SEARCH ";		
	xmlStr	   += " Mode=\"GETRESTRICTDATA\" ";
	xmlStr     += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
    xmlHttp.open("POST","CARestrictCEHDataValidate.jsp",false);
    xmlHttp.send(xmlDoc);    
    responseText = trimString(xmlHttp.responseText);
	CARestrictCEHDataResultFrame.document.CARestrictCEHDataResultForm.restrictData.value=responseText;
	CARestrictCEHDataResultFrame.document.CARestrictCEHDataResultForm.restrictDesc.value=CARestrictCEHDataHDRFrame.document.CARestrictCEHDataHeaderForm.restrictDesc.value;
	CARestrictCEHDataResultFrame.document.CARestrictCEHDataResultForm.histFunction.value=CARestrictCEHDataHDRFrame.document.CARestrictCEHDataHeaderForm.histFunction.value;
	
	CARestrictCEHDataResultFrame.document.CARestrictCEHDataResultForm.submit();
			
}
function reset() {
	CARestrictCEHDataHDRFrame.document.location.reload();
}
function chageRestrictDataType(){
	var restrictDataType;
	var recHistType;
	var restrictId=document.CARestrictCEHDataHeaderForm.restrictId.value;
	
	var restrictData = document.getElementsByName('restrictData');
	
	for(var i = 0; i < restrictData.length; i++){
		if(restrictData[i].checked){
			document.CARestrictCEHDataHeaderForm.restrictDataType.value = restrictData[i].value;
		}
	}
	restrictDataType =document.CARestrictCEHDataHeaderForm.restrictDataType.value;
	if(restrictDataType=='E'){
		document.getElementById('historyDetails').style.display='';
		recHistType=document.CARestrictCEHDataHeaderForm.historyType.value;
	}else if(restrictDataType=='H'){
		document.getElementById('historyDetails').style.display='none';
		recHistType='*ALL'
	}
	parent.CARestrictCEHDataResultFrame.document.location.href= "../../eCA/jsp/CARestrictCEHDataResult.jsp?restrictId="+restrictId+"&restrictDataType="+restrictDataType+"&recHistType="+recHistType;
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
} 
function checkedObj(obj){
	var objValue="N";
	var restrictDataType =document.getElementById("restrictDataType").value;
	if(obj.checked){
		objValue="Y";
	}else{
		if(restrictDataType=="H")
			document.getElementById("totalHCheck").checked=false;
		else if(restrictDataType=="E")
			document.getElementById("totalECheck").checked=false;
	}
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var xmlStr		= "<root><SEARCH ";	
	xmlStr	   += " ObjectKey=\""+ obj.name + "\" ";
	xmlStr	   += " ObjectValue=\""+ objValue + "\" ";
	xmlStr	   += " Mode=\"UPDATERESTRICTDATA\" ";
	xmlStr     += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
    xmlHttp.open("POST","CARestrictCEHDataValidate.jsp",false);
    xmlHttp.send(xmlDoc);    
    responseText = trimString(xmlHttp.responseText);
	if(responseText!="SUCCESS")
		alert("ERROR:"+responseText);
}
function checkAll(obj,obj1,obj2,obj3)
{
	var selectall="";
	if(obj3.checked==true)
		selectall="Y";
	else
		selectall="N";     
	var resType=obj;
	var resEvent=obj1;
	var hisType=obj2;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr		= "<root><SEARCH ";	
	xmlStr	   += " resId=\""+ obj + "\" ";
	xmlStr	   += " resType=\""+ obj1 + "\" ";
	xmlStr	   += " hisType=\""+ obj2 + "\" ";
	xmlStr	   += " selectall=\""+ selectall + "\" ";
	xmlStr	   += " Mode=\"SELECTALL\" ";
	xmlStr     += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
    xmlHttp.open("POST","CARestrictCEHDataValidate.jsp",false);
    xmlHttp.send(xmlDoc);    
    responseText = trimString(xmlHttp.responseText);
    if(responseText=="SUCCESS" ) {
    	document.location.reload();
    }else{
    	alert("ERROR:"+responseText);
    }
    
}

