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
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOT/jsp/SurgicalAccessoriesFrameForCreate.jsp';
}
function chkForDuplicates()
{
	var masterframe = parent.content.f_query_add_mod.MasterFrame;
	var HdrformObj=masterframe.document.forms[0];
    var appl_desc=HdrformObj.appl_desc.value;
	var speciality_code=HdrformObj.speciality_code.value;
	var category_code=HdrformObj.category_code.value;
    var subCategory_code=HdrformObj.subCategory_code.value;
	var operation_code=HdrformObj.operation_code.value;
	var dtlString=HdrformObj.dtlString.value;
	var arr=dtlString.split("#");
	var err_txt="";
	for (var i=0;i<arr.length;i++ )
	{
		var chkString=arr[i];
		if(appl_desc=="AOPR"){
	      	if(chkString.indexOf(appl_desc)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","Common");
		    }
	   }else if(appl_desc=="SSPL"){
		   if(speciality_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","Common");
				alert(msgArray[0]+speciality+msgArray[1]);
		   } else{
	      	if(chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","Common");
		    }
		   }
	   }else if(appl_desc=="SCAT"){
		   if(speciality_code==''){
			   err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","Common");
				alert(msgArray[0]+speciality+msgArray[1]);
		   } else if(category_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","Common");
				alert(msgArray[0]+category1+msgArray[1]);
		   }else{	
			if(chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","Common");
		    }
		   }
	   }else if(appl_desc=="SSUB"){
		     if(speciality_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var speciality=getLabel("Common.speciality.label","Common");
				alert(msgArray[0]+speciality+msgArray[1]);
		   } else if(category_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","Common");
				alert(msgArray[0]+category1+msgArray[1]);
		   }else if(subCategory_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var category1=getLabel("Common.category1.label","Common");
				alert(msgArray[0]+category1+msgArray[1]);
		   }else{
	      	if(chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","Common");
		    }
		   }
	   }else if(appl_desc=="SOPR"){
		   if(operation_code==''){
				err_txt=getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = err_txt.split("&");
				var operation=getLabel("Common.operation.label","Common");
				alert(msgArray[0]+operation+msgArray[1]);
		   }else{
	      	if(chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0){
			err_txt=getMessage("CODE_ALREADY_EXISTS","Common");
		    }
		   }
	   }

	}//for loop end
		if(err_txt.length>0){
			parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		 return false;
	 }
	else       
	  return true;
}

function apply()
{
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
	var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
	var detailframe = parent.content.f_query_add_mod.DetailFrame;
	var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
	var mode=HdrformObj.mode.value;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
	if(chkFields_inMainForm()){
		if(chkForDuplicates()){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.SurgicalAccessoriesServlet?mode='+mode;
	if(mode=='insert'){
  		xmlStr+=hiddenframe.createXMLForOT_OPER_SURGICAL_ACCESSORIES();
		xmlStr+="</root>";	
	}else if (mode=='modify'){
		xmlStr+=hiddenframe.createXMLForOT_OPER_PACKAGE();
		xmlStr+=hiddenframe.createXMLForOT_OPER_EQUIPMENT();
		xmlStr+=hiddenframe.createXMLForOT_OPER_INSTRUMENT();
		xmlStr+=hiddenframe.createXMLForOT_OPER_PROSTHESIS();
		xmlStr+=hiddenframe.createXMLForOT_OPER_PERSONNEL_REQD();
		xmlStr+="</root>";
		}
		
	if(xmlStr.indexOf("<root></root>")==-1){
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
				//Changes Done by Sanjay for IN:028261 on 28-Jul-2011. Below Line Commented and alert added.
				//parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+retVal;
				alert(retVal);
	}else {
			//Changes Done by Sanjay for IN:028261 on 28-Jul-2011. Below Line Commented and alert added.
			//parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			alert(msg);
	}
		}//end of chkForDuplicates()
	}//end of chkFields_inMainForm() function
	}else
	{
		//Changes Done by Sanjay for IN:028261 on 28-Jul-2011. Below Line Commented and alert added.
		//parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		alert("");//sanjay
	}
	//Changes Done by Sanjay for IN:028261 on 28-Jul-2011. Below Line Commented and alert added.
	f_query_add_mod.location.reload();
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/SurgicalAccessoriesFrameInCreateMode.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

function reset() {
//if(f_query_add_mod.document.forms[0].name=="equipment_form"){
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SurgicalAccessoriesFrameForCreate.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("SurgicalAccessoriesMain.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SurgicalAccessoriesQueryCriteria.jsp") != -1){
	f_query_add_mod.document.forms[0].reset();
}
}
function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  	 // commontoolbarFrame.document.forms[0].reset.disabled=true;

    }
	f_query_add_mod.location.href='../../eOT/jsp/SurgicalAccessoriesQueryCriteria.jsp';
}
function setCheckValue(obj)
{
	if(obj.checked==true){
		obj.value="Y";
	   	}else{
		obj.value="N";
	   }
}


function isNull(retVal)
{
if(retVal==null||retVal=='')
	return true;
else
	return false;
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

async function callSearchcode(code,obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="" ;
	var sql="";
	var locale = document.forms[0].locale.value;

    if(code=="C"){
		////alert("inside if");
		//sql="SELECT SHORT_DESC DESCRIPTION, PACKAGE_CODE CODE FROM   OT_PACKAGE_HDR WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(PACKAGE_CODE) LIKE UPPER(?) ORDER BY 1";
//		sql="SELECT SHORT_DESC DESCRIPTION, PACKAGE_CODE CODE FROM   OT_PACKAGE_HDR_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(PACKAGE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
		sql="SELECT LONG_DESC DESCRIPTION, PACKAGE_CODE CODE FROM   OT_PACKAGE_HDR_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(PACKAGE_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
		tit=getLabel("eOT.ConsumablePacks.Label","OT");
	}
	if(code=="P"){
		sql="SELECT ROLE_DESC DESCRIPTION, ROLE_ID CODE FROM   OT_ROLES_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E')='E' AND UPPER(ROLE_DESC) LIKE UPPER(?) AND UPPER(ROLE_ID) LIKE UPPER(?) ORDER BY 1";
		tit=getLabel("eOT.PersonnelRequired.Label","OT");
	}
	if(code=="PI"){
		//sql="SELECT SHORT_DESC DESCRIPTION, PROSTHESIS_CODE CODE FROM   OT_PROSTHESIS WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_CODE) LIKE UPPER(?) ORDER BY 1";
		sql="SELECT SHORT_DESC DESCRIPTION, PROSTHESIS_CODE CODE FROM   OT_PROSTHESIS_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(PROSTHESIS_CODE) LIKE UPPER(?)AND LANGUAGE_ID='"+locale+"'  ORDER BY 1";

		tit=getLabel("eOT.Prosthesis.Label","OT");
	}
	if(code=="E"){
		//Code altered by Selvam for PHASE 3 Delivery
//		sql="SELECT SHORT_DESC DESCRIPTION, EQUIPMENT_CODE CODE FROM OT_EQUIPMENT_LANG_VW where LANGUAGE_ID ='"+locale+"'  AND  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(EQUIPMENT_CODE) LIKE UPPER(?) ORDER BY 1";
		sql="SELECT LONG_DESC DESCRIPTION, EQUIPMENT_CODE CODE FROM OT_EQUIPMENT_LANG_VW where LANGUAGE_ID ='"+locale+"'  AND  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(EQUIPMENT_CODE) LIKE UPPER(?) ORDER BY 1";
		tit=getLabel("eOT.Equipments.Label","OT");
	}
	if(code=="I"){
		//sql="SELECT SHORT_DESC DESCRIPTION, INSTR_CODE CODE FROM  OT_INSTRUMENT WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) ORDER BY 1";
		// Code altered by rajesg for PHASE 3.
		//sql="SELECT SHORT_DESC DESCRIPTION, INSTR_CODE CODE FROM  OT_INSTRUMENT_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
		sql="SELECT LONG_DESC DESCRIPTION, INSTR_CODE CODE FROM  OT_INSTRUMENT_LANG_VW WHERE  NVL(STATUS,'E')='E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
		tit=getLabel("eOT.InstrumentsCSSDPacks.Label","OT");
	}
	
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

 async function callCodeSearch(code,title,obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=title ;
	var sql="";
   	var locale=document.forms[0].locale.value;

	if(code=="S"){
        sql="SELECT A.SHORT_DESC DESCRIPTION, B.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.LANGUAGE_ID='"+locale+"' AND  NVL(EFF_STATUS,'X') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(B.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	if(code=="C"){
	//	sql="SELECT LONG_DESC DESCRIPTION, OPER_CAT_CODE CODE FROM   OT_OPER_CATEGORY WHERE  NVL(STATUS,'E')='E' AND OPER_GROUP_CODE='"+document.forms[0].speciality_code.value+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) ORDER BY 1";
		sql="SELECT LONG_DESC DESCRIPTION, OPER_CAT_CODE CODE FROM   OT_OPER_CATEGORY_LANG_VW WHERE  NVL(STATUS,'E')='E' AND OPER_GROUP_CODE='"+document.forms[0].speciality_code.value+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) and language_id='"+locale+"' ORDER BY 1";
	}
	if(code=="SC"){
		//sql="SELECT LONG_DESC DESCRIPTION, OPER_SUB_CAT_CODE CODE FROM  OT_OPER_SUB_CATEGORY WHERE  NVL(STATUS,'E')='E' AND OPER_GROUP_CODE='"+document.forms[0].speciality_code.value+"' AND OPER_CAT_CODE='"+document.forms[0].category_code.value+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_SUB_CAT_CODE) LIKE UPPER(?) ORDER BY 1";
		sql="SELECT LONG_DESC DESCRIPTION, OPER_SUB_CAT_CODE CODE FROM  OT_OPER_SUB_CATEGORY_LANG_VW WHERE  NVL(STATUS,'E')='E' AND OPER_GROUP_CODE='"+document.forms[0].speciality_code.value+"' AND OPER_CAT_CODE='"+document.forms[0].category_code.value+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_SUB_CAT_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"'  ORDER BY 1";
				
		
	}
	if(code=="O"){
		/*Commented against MMS-QH-CRF-0199
		sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM  OT_OPER_MAST WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 1";*/

		//Added  against MMS-QH-CRF-0199
		sql="SELECT LONG_DESC DESCRIPTION, OPER_CODE CODE FROM  OT_OPER_MAST WHERE  NVL(STATUS,'E')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 1";
		
	}
	
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

 function checkReturnString(str){
	var valid_str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:@#";
	var checked_str = "";
	for(var jj=0;jj<str.length;jj++){
		if( valid_str.indexOf( str.charAt(jj) )!=-1 )
			checked_str+=str.charAt(jj);
	}
	return checked_str;
 }
 
function chkFields_inMainForm(){

	var speciality=getLabel("Common.speciality.label","Common");
	var category1=getLabel("Common.category1.label","Common");
	var subCategory=getLabel("eOT.SubCategory.Label","OT");
	var operation=getLabel("Common.operation.label","Common");
	var appl=getLabel("Common.Applicability.label","common");
	var master_frame = parent.content.f_query_add_mod.MasterFrame; 
	var formObj = master_frame.document.forms[0];
	var appl_desc=formObj.appl_desc.value;
	if(appl_desc=="SSPL"){
          var fields=new Array(formObj.speciality_desc);
		   var names= new Array(speciality);
	}else if(appl_desc=="SCAT"){
		  var fields=new Array(formObj.speciality_desc,formObj.category_desc);
		  var names= new Array(speciality,category1);
	}else if(appl_desc=="SSUB"){
		  var fields=new Array(formObj.speciality_desc,formObj.category_desc,formObj.subCategory_desc);
		  var names= new Array(speciality,category1,subCategory);
	}else if(appl_desc=="SOPR"){
          var fields=new Array(formObj.operation_desc);
		  var names= new Array(operation);
	}//else if(appl_desc=="AOPR"){
	else {
		if (appl_desc=="" || appl_desc==null)
	{
		var fields=new Array(formObj.appl_desc);
		  var names= new Array(appl);
	}
	}
	var messageFrame =parent.content.messageFrame;
	
if (appl_desc!="AOPR")
	{
	//Commented by rajesh after confiromg with dilip for SCF-2645
//		if(checkFieldsofMst( fields, names, messageFrame) && chksubform()) {
		if(checkFieldsofMst( fields, names, messageFrame)) {
			return true;
		}
	} else { 
		//if(chksubform()) {
		return true;
		//} 
	}	

	
}

/*
//Commented by rajesh after confiromg with dilip for SCF-2645
function chksubform() {
	var RecordFrame=parent.content.f_query_add_mod.RecordFrame;
	var formObj = RecordFrame.document.forms[0];
	var code=getLabel("Common.code.label","common");
    var role=getLabel("Common.Role.label","common");
	if (formObj.name=="SurgicalAccessoriesConsumablePacksRecordForm") {
		var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
		 if (formObj.packs_code.value==""  && rows.length==0 ) {
			err_txt=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = err_txt.split("&");
			alert(msgArray[0]+code+msgArray[1]);
			parent.content.commontoolbarFrame.location.reload();
			return;
		} else {
		return true;
		}
	} else if (formObj.name=="SurgicalAccessoriesEquipmentsRecordForm")	{
		var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
		 if (formObj.equipment_code.value=="" && rows.length==0) {
			err_txt=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = err_txt.split("&");
			alert(msgArray[0]+code+msgArray[1]);
			//window.parent.frames[1].frames[0].location.reload();
			return;
		} else {
		return true;
		}
	} else if (formObj.name=="SurgicalAccessoriesInstrumentsRecordForm")	{
		var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
			 if (formObj.instr_code.value=="" && rows.length==0) {
			err_txt=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = err_txt.split("&");
			alert(msgArray[0]+code+msgArray[1]);
		//	window.parent.frames[1].frames[0].location.reload();
			return;
		} else {
		return true;
		}
	} else if (formObj.name=="SurgicalAccessoriesProsthesisRecordForm")	{
			var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
		 if (formObj.prosthesis_code.value=="" && rows.length==0) {
			err_txt=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = err_txt.split("&");
			alert(msgArray[0]+code+msgArray[1]);
		//	window.parent.frames[1].frames[0].location.reload();
			return;
		} else {
		return true;
		}
	} else if (formObj.name=="SurgicalAccessoriesPersonnelRequiredRecordForm") {
		var rows=parent.content.f_query_add_mod.hidden_frame.rows_for_consumables;
		if (formObj.role_id.value=="" && rows.length==0) {
			err_txt=getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = err_txt.split("&");
			alert(msgArray[0]+role+msgArray[1]);
		//	window.parent.frames[1].frames[0].location.reload();
			return;
		} else {
		return true;
		}
	}
}*/


/*function modeCheck(){
	var formObj = document.SurgicalAccessoriesConsumablePacksRecordForm;
	var master_frame = window.parent.frames[0];
	var hdr_frm = master_frame.document.forms[0];
	var packsCodeDtl =window.parent.frames[4].packs_code;
	var frmPacks_code=formObj.packs_code.value;
	var appl_desc=hdr_frm.appl_desc.value;
	var splty_code=hdr_frm.speciality_code.value;
	var cat_code=hdr_frm.category_code.value;
	var sub_cat_code=hdr_frm.subCategory_code.value;
	var tab="package"
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "appl_desc="+appl_desc+"&splty_code="+splty_code+"&cat_code="+cat_code+"&sub_cat_code="+sub_cat_code+"&tab="+tab;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ValidationOT.jsp?func_mode=fromSurgicalAcmaster&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal1 = trimString(xmlHttp.responseText);
	var err_txt="";
	var dtl_arr = retVal1.split(",");
	var dtl_arr_length = dtl_arr.length;
	var err_flag = "false";
	var i = 0;
		if(dtl_arr_length>0){
			while(i<=dtl_arr_length-2 && err_flag=="false"){
				if(dtl_arr[i] == frmPacks_code){
					err_flag = "true";
					err_txt="Update";
				}
				i++;
			}
		}
	 if(err_txt.length>0){
	     	  return false;
		}else return true;
}*/
