/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	var formObj = document.forms[0];
	var params=formObj.params.value;
	f_query_add_mod.location.href="../../eOT/jsp/ComponentsAddModify.jsp?"+params+"&mode=insert";
}

function apply()
{
	//var description = getLabel("Common.description.label","common");
	//var itemcode = getLabel("Common.ItemCode.label","common");
	var frm=f_query_add_mod.document.forms[0];

	if(frm.mode.value=="modify"){
		//f_query_add_mod.document.forms[0].submit();
		var fields = new Array (f_query_add_mod.document.forms[0].item_code,f_query_add_mod.document.forms[0].item_desc);
		var names = new Array ("Item Code","Description");

		if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}else{

	var fields = new Array (f_query_add_mod.document.forms[0].item_code,f_query_add_mod.document.forms[0].item_desc);
	//var names = new Array (itemcode,description);
	var names = new Array ("Item Code","Description");
	if(f_query_add_mod.checkFieldsofMst( fields, names,messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}
function onSuccess()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href="../../eOT/jsp/ComponentsAddModify.jsp?"+params+"&mode=insert";
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
		f_query_add_mod.document.forms[0].reset();
}
*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ComponentsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("Components.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ComponentsQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}	
}

function query()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href="../../eOT/jsp/ComponentsQueryCriteria.jsp?"+params;
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="Y";
	else
		document.forms[0].status.value="N";
}



function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

async function callCrossRefCode(obj,target){
	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit="Items Search" ;
	var tit=getLabel("Common.item.label","common");
	var sql="SELECT B.SHORT_DESC DESCRIPTION,A.ITEM_CODE CODE FROM MM_ITEM B, ST_ITEM A WHERE A.ITEM_CODE  = B.ITEM_CODE AND NVL(B.EFF_STATUS,'E')='E' AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.ITEM_CODE) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }



async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function emptyCode(){
	//alert("B4"+document.forms[0].code.value);
	document.forms[0].code.value="";
	//alert("Aftr"+document.forms[0].code.value);
}	

// Added by Rajesh 28-8-12
function fnSetImage(obj){
	var imageName = obj.value;
	//Commented by rajesh
	/*var img = document.createElement("IMG");
	var node = document.getElementById('compImg');
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

async function openDialogWindow_comp_image_display(obj){
	if(!obj == "")
		{
			var dialogHeight 		= "0";
			var dialogWidth  		= "40";
			var dialogTop   		= "200";
			var dialogLeft   		= "100";
			var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
			var arguments			= "";
			var	param="sql_image_flag="+obj;
			//retVal=window.showModalDialog("../../eOT/jsp/AdminEquipmentImageFrame.jsp?"+param,arguments,features);
			retVal=await window.showModalDialog("../../eOT/jsp/AdminInstrumentImageFrame.jsp?"+param,arguments,features);
			//Added by MuthuN against 39402 on 17-04-2013
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
		var node = document.getElementById('compImg');
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
