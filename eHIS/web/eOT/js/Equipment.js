/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var equipImgName = "";

function create(){
	f_query_add_mod.location.href='../../eOT/jsp/EquipmentAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	//var Ot_param_eq = document.forms[0].Ot_param_eq.value;
	if(frm.mode.value=='modify'){
		//if(Ot_param_eq=='Y' || Ot_param_eq=='y'){
		//Added by Muthu for RUT-CRF-0057
		var fields = new Array (f_query_add_mod.document.forms[0].equipment_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		var equipmentCode_title=getLabel("eOT.EquipmentCode.Label","OT");
		var longdescription_title=getLabel("Common.longdescription.label","Common");
		var shortdescription_title=getLabel("Common.shortdescription.label","Common");
		var names = new Array ( equipmentCode_title,longdescription_title,shortdescription_title);
			if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				frm.submit();
			}
	 //frm.submit();
}else{
	//Added by Muthu for RUT-CRF-0057	
	var fields = new Array (f_query_add_mod.document.forms[0].equipment_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
	var equipmentCode_title=getLabel("eOT.EquipmentCode.Label","OT");
	var longdescription_title=getLabel("Common.longdescription.label","Common");
	var shortdescription_title=getLabel("Common.shortdescription.label","Common");
	//var imagefile_title=getLabel("Common.ImageFilename.label","Common");//Added by Muthu for RUT-CRF-0057
	var names = new Array ( equipmentCode_title,longdescription_title,shortdescription_title);
		if(checkFieldsofMst( fields, names, messageFrame)) 
		{	
			frm.submit();
		}
}
}
function onSuccess(){	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/EquipmentAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/* function reset(){
	f_query_add_mod.document.forms[0].reset(); 
}
*/
function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("EquipmentAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("Equipments.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("EquipmentQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}


function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/EquipmentQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

// Added by Rajesh 28-8-12
/*function checkForImageFile(obj){
	var imageName = obj.value;
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var responseText = "";
    
    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    equipImgName = "";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "GET", "../../eOT/jsp/EquipmentImageCheck.jsp?imgName=" + imageName , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = trimString(responseText);
	eval(responseText) ;
	
	if(equipImgName == "01"){
		var img = document.createElement("IMG");
		var node = document.getElementById('equipImgDiv');
		img.src = "../../eOT/images/"+imageName;
		img.style.height = 17;
		img.style.width = 17;


		while (node.hasChildNodes()) {
		    node.removeChild(node.lastElementChild);
		}
		node.appendChild(img);
	}
	else
	{
		var node = document.getElementById('equipImgDiv');
		while (node.hasChildNodes()) {
		    node.removeChild(node.lastElementChild);
		}
		alert('Image doesn\'t exists');	
		
	}
}

function fnLoadImages(){
	alert('Inside fnLoadImages');
    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var responseText = "";
    
    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;
    equipImgName = "";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    alert('Beofre call');
	xmlHttp.open( "GET", "../../eOT/jsp/EquipmentImageCheck.jsp?refreshImages=yes" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = trimString(responseText);
	eval(responseText) ;
	alert('All the Images are Refreshed');
}*/

function fnSetImage(obj){
	var imageName = obj.value;
	//Commented by rajesh
	/*var img = document.createElement("IMG");
	var node = document.getElementById('equipImgDiv');
	img.src = "../../eOT/images/"+imageName;
	img.style.height = 17;
	img.style.width = 17;
	while (node.hasChildNodes()) {
	    node.removeChild(node.lastElementChild);
	}
	node.appendChild(img);*/
	//Commented by rajesh
	valueForImage = imageName;
}

//function openDialogWindow_comp_image_display(obj,equip_code){
function openDialogWindow_comp_image_display(obj){
	if(!obj == "")
		{
			var dialogHeight 		= "0";
			var dialogWidth  		= "40";
			var dialogTop   		= "200";
			var dialogLeft   		= "100";
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			var arguments			= "";
			var	param="sql_image_flag="+obj;
			//param=param+"&image="+image_eq;
			//param=param+"&location="+loc_eq;
			retVal=window.showModalDialog("../../eOT/jsp/AdminEquipmentImageFrame.jsp?"+param,arguments,features);
		}
		else
		{
			alert(getMessage("NO_RECORD_FOUND","Common"));
		}	
	}

function fnSetImgOnLoad(){
	valueForImage = document.getElementById('image_file').value;
	//Commented by rajesh
	/*if(!valueForImage == ""){
		var imageName = valueForImage;
		var img = document.createElement("IMG");
		var node = document.getElementById('equipImgDiv');
		img.src = "../../eOT/images/"+imageName;
		img.style.height = 17;
		img.style.width = 17;
		while (node.hasChildNodes()) {
		    node.removeChild(node.lastElementChild);
		}
		node.appendChild(img);
	}*/
	//Commented by rajesh
}
// Added by Rajesh 28-8-12
