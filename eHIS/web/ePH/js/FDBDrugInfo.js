  //saved on 07/11/2005

function hideAll()
{
/*doc=parent.f_info.document;
doc.TblFood.style.display="none";
doc.TblPrecautions.style.display="none";
doc.TblIndications.style.display="none";
doc.TblADE.style.display="none";
doc.TblEquiv.style.display="none";
doc.TblContra.style.display="none";
doc.TblInteractions.style.display="none";
doc.TblInfo.style.display="none";
doc.TblCounsel.style.display="none";*/
//Set back th filters

document.getElementById("LbDrugClaas").style.fontWeight="normal";
document.getElementById("LbDrugInt").style.fontWeight="normal";
document.getElementById("LbDrugPre").style.fontWeight="normal";
document.getElementById("LbDrugFood").style.fontWeight="normal";
document.getElementById("LbDrugCont").style.fontWeight="normal";
document.getElementById("LbDrugSide").style.fontWeight="normal";
document.getElementById("LbDrugOverDose").style.fontWeight="normal";
document.getElementById("LbDrugCommonOrd").style.fontWeight="normal";
document.getElementById("LbDrugPatEdu").style.fontWeight="normal";
}
function showTab(tabname,linkname,extprodid)
{
hideAll();
 document.getElementById(linkname).style.fontWeight="bold";
window.parent.f_info.document.location.href = "DisplayDrugInfo.jsp?infoparam="+tabname+"&extprodid="+extprodid;
}

function showAll()
{
//called from header frame
	hideAll();
	doc=parent.f_info.document;
	doc.TblFood.style.display="inline";
	doc.TblPrecautions.style.display="inline";
	doc.TblIndications.style.display="inline";
	doc.TblADE.style.display="inline";
	doc.TblEquiv.style.display="inline";
	doc.TblContra.style.display="inline";
	doc.TblInteractions.style.display="inline";
	doc.TblInfo.style.display="inline";
	doc.TblCounsel.style.display="inline";
	
	//Set back th filters
	document.getElementById("THAll").style.backgroundColor="#FFA6A6";


}

function showAllFirstTime()
{
//called from header frame
	/*doc=parent.f_infoheader.document;
	document.getElementById("TblFood").style.display="inline";
	document.getElementById("TblPrecautions").style.display="inline";
	document.getElementById("TblIndications").style.display="inline";
	document.getElementById("TblADE").style.display="inline";
	document.getElementById("TblEquiv").style.display="inline";
	document.getElementById("TblContra").style.display="inline";
	document.getElementById("TblInteractions").style.display="inline";
	document.getElementById("TblInfo").style.display="inline";
	document.getElementById("TblCounsel").style.display="inline";*/
	//Set back th filters


}

function showDrugInformation(prodid){
	hideAll();
	document.getElementById("THInfo").style.backgroundColor="#FFA6A6";
	window.parent.f_info.document.location.href = "drugInformation.jsp?extprodid="+prodid;
}

function showDrugInteraction(prodid){
	hideAll();
	document.getElementById("THInteractions").style.backgroundColor="#FFA6A6";
	window.parent.f_info.document.location.href = "drugInteractionDetail.jsp?extprodid="+prodid;
}

function showCounselMessage(prodid){
	hideAll();
	document.getElementById("THCounsel").style.backgroundColor="#FFA6A6";
	window.parent.f_info.document.location.href = "drugCounselMessage.jsp?extprodid="+prodid;
}

function showMedCondDrugs(prodid){
	hideAll();
	document.getElementById("THMedCond").style.backgroundColor="#FFA6A6";
	window.parent.f_info.document.location.href = "MedicalCondition.jsp?extprodid="+prodid;
}

function showDrugInteractionDetails(currentdrugid, drugid){
	//window.parent.druginteractiondetail.document.location.href = "druginteractiondesc.jsp?currentdrugid="+currentdrugid+"&extprodid="+drugid;
	var xmlStr ="<root><SEARCH " ;
	
	xmlStr +=" /></root>" ;		
	var temp_jsp="druginteractiondesc.jsp?currentdrugid="+currentdrugid+"&extprodid="+drugid;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr);
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	//alert(responseText);
	//eval(responseText);
	//alert(eval("document.getElementById("drug_")"+drugid));
	var obj	=	document.getElementById("drug_"+drugid);
	obj.innerText = trimString(responseText);
	//alert(obj.value);
}

function displayMedicalCond( frmObj ) {
	frmObj.submit();
//	window.parent.f_info.header2.document.location.href = "MedicalConditionHeaderResult.jsp?searc_cont="+searc_cont;
	
}

function addToMedRelated(str1,str2)	{

//	alert(str1);
//	alert(str2);
	var formObj = document.medicalcondheaderform;		
	var element1 = document.createElement('OPTION') ;		
	element1.value		=  str1 ;		
	element1.text		=  str2 ;		
	formObj.result.add(element1);
}

function showRecommended(obj)
{
	objval=obj.value;
window.parent.fb_view1.document.location.href = "MedicalConditionRecommon.jsp?result="+objval;
window.parent.fb_view2.document.location.href = "MedicalConditionNonRecommon.jsp?result="+objval;
}


async function viewDrugMedicalCondition(){
	var dialogHeight	="25" ;
	var dialogWidth	="40";
	var dialogTop	= "270" ;
	var dialogLeft	= "200" ;
	var center			= "0" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var bean_id = document.preview.beanid.value;
	retVal = await window.showModalDialog("CurrentDiagnosisDrugValidate.jsp?beanid="+bean_id,arguments,features);
}

function setfocus(){
	window.parent.currentdiagnosislist.document.getElementById("diagnosislist").focus();
}

function getDrugsList(){
	var val = window.parent.currentdiagnosislist.document.getElementById("diagnosislist").value;
	var beanid = window.parent.currentdiagnosislist.document.getElementById("beanid").value;
	window.parent.currentdiagnosislist.document.getElementById("druglist").innerHTML = "";
	//alert(beanid);
	if(!(val==0)){
		window.parent.currentdiagnosislistheader.document.location.href = "CurrentDiagnosisListHeader.jsp";
		window.parent.fb_view1.document.location.href = "CurrentDiagnosisRecommonended.jsp?icdcode="+val;
		window.parent.fb_view2.document.location.href = "CurrentDiagnosisNotRecommonended.jsp?icdcode="+val+"&beanid="+beanid;
	}else{
		window.parent.currentdiagnosislistheader.document.location.href = "../../eCommon/html/blank.html";
		window.parent.fb_view1.document.location.href = "../../eCommon/html/blank.html";
		window.parent.fb_view2.document.location.href = "../../eCommon/html/blank.html";
	}
}


function highlight(str){
	//alert(str);
	//alert(window.parent.currentdiagnosislist.name);
	window.parent.currentdiagnosislist.document.getElementById("druglist").innerHTML = str;
}
