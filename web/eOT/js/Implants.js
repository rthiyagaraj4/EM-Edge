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
	var params = formObj.params.value;
	f_query_add_mod.location.href="../../eOT/jsp/ImplantsAddModify.jsp?"+params+"&mode=insert";
}

function apply(){
   var frm=f_query_add_mod.document.forms[0];
   var l_mm_module_installed_yn = frm.l_mm_module_installed_yn.value;
   frm.consignment_item_yn.disabled=false;
   frm.deposit_reqd_yn.disabled=false;
   //alert(frm);
	if(frm.mode.value=="modify"){
		//frm.submit();
		var prosthesis_code=getLabel("eOT.ProsthesisCode.Label","OT");
		var longdescription=getLabel("Common.longdescription.label","Common");
		var shortdescription=getLabel("Common.shortdescription.label","Common");
		if(l_mm_module_installed_yn=="Y"){
			var fields = new Array (f_query_add_mod.document.forms[0].prosthesis_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		//	var crossref_mmitem=getLabel("eOT.CrossRefMMItem.Label","OT");
			var names = new Array ( prosthesis_code,longdescription,shortdescription);
		}else{
			var fields = new Array (f_query_add_mod.document.forms[0].prosthesis_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
			var names = new Array ( prosthesis_code,longdescription,shortdescription);
		}
		if(checkFieldsofMst( fields, names, messageFrame)) {	
			f_query_add_mod.document.forms[0].submit();
		}
	}else{
		var prosthesis_code=getLabel("eOT.ProsthesisCode.Label","OT");
		var longdescription=getLabel("Common.longdescription.label","Common");
		var shortdescription=getLabel("Common.shortdescription.label","Common");
		if(l_mm_module_installed_yn=="Y"){
			var fields = new Array (f_query_add_mod.document.forms[0].prosthesis_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
		//	var crossref_mmitem=getLabel("eOT.CrossRefMMItem.Label","OT");
			var names = new Array ( prosthesis_code,longdescription,shortdescription);
		}else{
			var fields = new Array (f_query_add_mod.document.forms[0].prosthesis_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc);
			var names = new Array ( prosthesis_code,longdescription,shortdescription);
		}
		if(checkFieldsofMst( fields, names, messageFrame)) {	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href="../../eOT/jsp/ImplantsAddModify.jsp?"+params+"&mode=insert";
	else
        f_query_add_mod.location.reload();
}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {

if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ImplantsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("Implants.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ImplantsQueryCriteria.jsp") != -1)
	{
		 f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href="../../eOT/jsp/ImplantsQueryCriteria.jsp?"+params;
}
function consignmentYN()
{
	if(document.forms[0].consignment_item_yn.checked==true)
		document.forms[0].consignment_item_yn.value="Y";

	else
		document.forms[0].consignment_item_yn.value="N";
}
function depositYN()
{
	if(document.forms[0].deposit_reqd_yn.checked==true)
		document.forms[0].deposit_reqd_yn.value="Y";
	else
		document.forms[0].deposit_reqd_yn.value="N";
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}



async function callSpeciality_Code(){
   	var locale=document.forms[0].locale.value;
	var obj = document.forms[0].speciality_code;
	var target = 	document.forms[0].speciality_desc;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.speciality.label","Common");
	var sql="SELECT A.SHORT_DESC DESCRIPTION ,B.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X') = 'E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(B.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 1  ";
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
		////alert("return value from LOV=="+ret1);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


async function callMM_Item_Code(){
   	var locale=document.forms[0].locale.value;
	var obj = document.forms[0].mm_item_code;
	var target = 	document.forms[0].mm_item_desc;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("eOT.CrossRefMMItem.Label","OT");
	var sql="SELECT SUBSTR(SHORT_DESC,1,15) DESCRIPTION, ITEM_CODE CODE FROM MM_ITEM WHERE  NVL(EFF_STATUS, 'D') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) ORDER BY 1  ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup(tit,argumentArray);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		//alert("return value from LOV=="+ret1);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}

}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

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

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

function callClear(obj){

	var obj = document.forms[0].prosthesis_cat_code;
	var target = 	document.forms[0].prosthesis_cat_desc;
	if(target.value=="")obj.value="";
}

async function callProsthesis_cat_Code(){
	
	 	var locale=document.forms[0].locale.value;
	var obj = document.forms[0].prosthesis_cat_code;
	var target = 	document.forms[0].prosthesis_cat_desc;
	if (target.value==""){
		callClear(target);
	}
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.category1.label","Common");
	var sql="SELECT PROSTHESIS_CAT_DESC DESCRIPTION, PROSTHESIS_CAT_CODE CODE FROM OT_PROSTHESIS_CATEGORY WHERE NVL(STATUS,'E') = 'E' AND UPPER(PROSTHESIS_CAT_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_CAT_CODE) LIKE UPPER(?) ORDER BY 1  ";
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
		////alert("return value from LOV=="+ret1);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
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

async function callProsthesis_type_Code(){
	var locale=document.forms[0].locale.value;
	var obj = document.forms[0].prosthesis_type_code;
	var target = 	document.forms[0].prosthesis_type_desc;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.type.label","Common");
	var sql="SELECT PROSTHESIS_TYPE_DESC DESCRIPTION, PROSTHESIS_TYPE CODE FROM OT_PROSTHESIS_TYPE WHERE NVL(STATUS,'E') = 'E' AND UPPER(PROSTHESIS_TYPE_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_TYPE) LIKE UPPER(?) ORDER BY 1  ";
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
		////alert("return value from LOV=="+ret1);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		
		target.value="";
		obj.value="";
	}

}

function checkMaxLimit1(field, limit){
	 if (field.value.length > limit){
		   //alert(limit+' characters only allowed');
		    //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		 //  var msg = getMessage("MAX_LENGTH_DATA","OT");
		   //var msgArray = msg.split("#");
		   //alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
			var description = getLabel("Common.description.label","Common");
		   var msg=getMessage("REMARKS_CANNOT_EXCEED","Common");
		  // alert(msg);
		  //"APP-000002 $ cannot exceed # characters"
			var msgArr=msg.replace("#",limit).split("$");
			alert( msgArr[0]+ description +msgArr[1]);
		    // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

/*function checkMaxLimit1(obj,maxSize)	
	{
		var len  = obj.value;
	   	if ( len.length > maxSize )
    		{
			//("APP-OT0016 Value Should be within the specified limit of "+maxSize+" characters" );
			var msg=getMessage("OBJ_CANNOT_EXCEED","Common");
			var msgArr=msg.split("$");
			alert( msgArr[0] + maxSize +  msgArr[1]);
	  	  	event.returnValue = false;
   	  		obj.focus();
    		}	
	}	*/
