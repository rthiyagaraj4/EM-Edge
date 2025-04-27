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
	//////alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	//////alert("params="+source);
   f_query_add_mod.location.href='../../eOT/jsp/ConsumablePackFrameForCreate.jsp?'+source;
	
}
function chkForDuplicates(){
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame;
	var HdrformObj=masterframe.document.forms[0];
    var package_code=HdrformObj.package_code.value;
	var package_code_from_DB=HdrformObj.package_code_from_DB.value;
	var err_txt="";
    if(package_code_from_DB.indexOf(package_code)>=0){
            //err_txt="APP-OT40 Packs Code Cannot be Duplicated...";
			err_txt=getMessage("RECORD_ALREADY_EXISTS","Common")
	    	parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		    return false;
	 }else       
	  return true;
}
// function for checking mandatory fields in the Add Modify form
function chkMandatory(){
	var packcode=getLabel("Common.PackageCode.label","Common");
	var longdescription=getLabel("Common.longdescription.label","Common");
	var shortdescription=getLabel("Common.shortdescription.label","Common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame;
	var formObj=masterframe.document.forms[0];  //Add Modify form
	var fields = new Array ( formObj.package_code, formObj.long_description,formObj.short_description);
	var names = new Array (packcode,longdescription,shortdescription);
	//var messageFrame =window.parent.frames[1].frames[2];
	var messageFrame =parent.content.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))	
			return true
	
}
function apply(){	
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
    //var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
	//var detailframe = window.parent.frames[1].frames[1].frames[4];
	var detailframe = parent.content.f_query_add_mod.DetailFrame;
	var package_code=HdrformObj.package_code.value;
    var long_description = HdrformObj.long_description.value;
	var short_description = HdrformObj.short_description.value;
	var status = HdrformObj.status.value;
	var mode=HdrformObj.mode.value;
	// CRF-268 Consumable pack - Rajesh V
	var ss_code  = HdrformObj.ss_group_code.value;
	//alert("short_description--->"+short_description)
	var param = "package_code="+package_code+"&long_description="+long_description+"&short_description="+short_description+"&status="+status+"&mode="+mode+"&ss_code="+ss_code;
	// CRF-268 Consumable pack - Rajesh V	
	//var hiddenframe=window.parent.frames[1].frames[1].frames[1];
    var hiddenframe=parent.content.f_query_add_mod.hidden_frame;	
	//alert("59")
	if( chkMandatory() && chkForDuplicates() ){
		//alert("60")
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root>";
		var action = '../../servlet/eOT.ConsumablePackServlet?'+param;
		xmlStr+=hiddenframe.createXMLForOT_PACKAGE_Hdr();
		xmlStr+=hiddenframe.createXMLForOT_PACKAGE_Dtl();
		xmlStr+="</root>";
//		alert(xmlStr);
		
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var mesg = (retVal=="Operation Completed Successfully....")?getMessage("RECORD_INSERTED","SM"):retVal;
		//window.parent.frames[1].frames[1].frames[1].location.reload();
		//window.parent.frames[1].frames[1].frames[3].location.reload();
	    parent.content.f_query_add_mod.RecordFrame.location.href='../../eOT/jsp/ConsumablePackRecord.jsp?'; 
	    parent.content.f_query_add_mod.DetailFrame.location.href='../../eOT/jsp/ConsumablePackDetailForm.jsp?'; 
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
//		parent.content.f_query_add_mod.hidden_frame.rows.splice(0);

	 }
	}else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
   
}

function trimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

 function checkReturnString(str){
	var valid_str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:@#";
	var checked_str = "";
	for(var jj=0;jj<str.length;jj++){
		if( valid_str.indexOf( str.charAt(jj) )!=-1 )
			checked_str+=str.charAt(jj);
	}
	////alert(checked_str);
	return checked_str;
 }


/*function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ConsumablePackAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}*/

//function reset(){
//	//alert(parent.frames[1].frames[1].name);
//	f_query_add_mod.document.forms[0].reset();
//}


function reset() {
//	if(window.parent.parent.frames[2].frames[1].name=="ConsumablePacksHeader"){

	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ConsumablePackFrameForCreate.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("ConsumablePackAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}
	else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ConsumablePackQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
//}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	////alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;
    }
	f_query_add_mod.location.href='../../eOT/jsp/ConsumablePackQueryCriteria.jsp';
}

function setStatusValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

async function callItemCode(){
	var obj = document.forms[0].item_code; 
	//alert(obj.value)
	var target = document.forms[0].short_description;	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Items.label","Common")+" "+getLabel("Common.search.label","Common");
	var sql="SELECT ITEM_CODE CODE, SHORT_DESC DESCRIPTION FROM MM_ITEM WHERE NVL(EFF_STATUS,'E') = 'E'  AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) ORDER BY 1";
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
		getUom(obj.value);
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



function ChkNumber(obj){
	
//////alert(window.parent.parent.frames[1].frames[4].name);
	//CheckNum(obj);
	if(isNaN(obj.value)==true)
	{
		//alert("Enter a valid no");
	   alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
	   obj.select();
	   obj.focus();
	   
	}
	if(obj.value!="" && obj.value<=0){
	  //alert("Srl No should be > 0");
	  alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
	  obj.select();
	  obj.focus();
	}
}



function Class_checkListrow(){
     
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.item_code="";
	 this.short_description="";
	 this.reqd_qty="";
	 this.mode="";
	 this.recId ="";
}
function newRow(){
  var objrow = new Class_checkListrow(); // 
   return(objrow);
}

function alreadyExist(){
	var formObj = document.ConsumablePackRecordForm;
	var codeDtl =window.parent.parent.frames[1].frames[4].code; //detail frame
	codeDtl=","+codeDtl
	//var srl = window.parent.parent.frames[1].frames[4].srl; //detail frame
	var item_code=formObj.item_code.value;
	//var srl_no = formObj.srl_no.value;
	var codeRecord = ","+item_code+",";
   if(formObj.mode.value=="I" && codeDtl.indexOf(codeRecord)>=0)  {
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+"APP-OT40 Item Code Cannot be Duplicated...";
	}else       
	  return true;
	}

 function chkEmpty(){
	var formObj = document.ConsumablePackRecordForm;
	var item_desc=getLabel("Common.description.label","Common");
	var noOfUnits=getLabel("eOT.NoofUnits.Label","OT");
	var fields = new Array(formObj.short_description,formObj.reqd_qty);
	var names = new Array(item_desc,noOfUnits);
	var messageFrame = window.parent.parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
		return true;
}



function addRow(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var formObj = document.ConsumablePackRecordForm;
  var mode =formObj.mode.value;
  var uom=formObj.uom.value;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){         //if the row which is bieng inserted already does not exist
		   var objrow = newRow();
		   
		   objrow.item_code=formObj.item_code.value;
		   //alert("short_description in add row function =="+formObj.short_description.value);
		   objrow.short_description=formObj.short_description.value;
		   objrow.reqd_qty=formObj.reqd_qty.value;
		   objrow.uom=formObj.uom_desc.value;
		   objrow.mode="I";
		   //alert("mode in add row function=="+objrow.mode);
		   objrow.recId = rows.length+1;
		   
		   rows.push(objrow);
		   //alert("rows--->"+rows[3])
		   resetFields();
		   refresh();
		  
	} 
}else
	  updateRow();
  }
}



function updateRow(){
	//alert("304")
	var formObj = document.ConsumablePackRecordForm;
	var item_code = formObj.item_code.value;
	
	var short_description=formObj.short_description.value;
	var reqd_qty=formObj.reqd_qty.value;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	var uom=formObj.uom_desc.value;
	//alert("uom--->"+uom)
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
                        if(alreadyExist())
						
			            rows[jj].item_code=item_code;
						rows[jj].short_description=formObj.short_description.value;
						rows[jj].reqd_qty=formObj.reqd_qty.value;
						rows[jj].uom=formObj.uom_desc.value;
			            if(rows[jj].mode=='L' || rows[jj].mode=='I')
							rows[jj].mode='U';
                            //alert("rows[jj].mode in update function=="+rows[jj].mode);
						/*if(rows[jj].mode=='L')
							rows[jj].mode='U'
							break;*/
					
					}
		         }else  
			continue;
		 }
      resetFields();
	  refresh();
	 
 }
}

function removeRow(){
var formObj = document.ConsumablePackRecordForm;
var rows=window.parent.parent.frames[1].frames[1].rows;
//////alert(rows.length);
formObj.generic_search.disabled=false;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].mode=='L')
				rows[jj].mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 refresh();
}else
   resetFields();
}

function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.ConsumablePackRecordForm;
	
	frmObj.item_code.value=arr[0];
	
	frmObj.item_code.disabled=true;
	//alert("item_code--->"+arr[0])
	frmObj.short_description.value=arr[1];
	//alert("short_description--->"+arr[1])
	frmObj.reqd_qty.value=arr[2];
	frmObj.recId.value=arr[3];
	//alert("reqd_qty--->"+arr[2])
	frmObj.mode.value=arr[4];
	//alert("mode--->"+arr[4])
	frmObj.uom_desc.value=arr[5];
	//alert("uom--->"+arr[5])
	frmObj.item_code.disabled=true;
	frmObj.short_description.disabled=true;
	frmObj.generic_search.disabled=true;
	
	
	
}


function resetFields(){
	var frmObj = document.ConsumablePackRecordForm;
	frmObj.short_description.value='';
	frmObj.reqd_qty.value='';
	frmObj.item_code.value='';
	frmObj.uom_desc.value='';
	
	frmObj.mode.value='I';
	//frmObj.generic_search.disabled=false;
	frmObj.short_description.disabled=false;
	frmObj.item_code.disabled=false;
	//frmObj.checklist_item_srl_no.focus();
}

function refresh(){
 /*var frm =window.parent.frames[1].frames[1].frames[3];
 var params=frm.document.forms[0].params.value;
  ////alert(params);*/
  window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/ConsumablePackDetailForm.jsp?';              //+params;
//  parent.content.f_query_add_mod.hidden_frame.location.href='../../eOT/jsp/ConsumablePackObjectCollect.jsp?';              //+params;
}

function loadDBRows(item_code,short_description,reqd_qty,recId,uom,mode){ 
   var rows=window.parent.parent.frames[1].frames[1].rows;

    if(mode=='L'){
	 var objrow = newRow();		  
	 objrow.item_code = decodeURIComponent(item_code,"UTF-8").replace(/\+/g," ");
	 objrow.short_description =decodeURIComponent(short_description,"UTF-8").replace(/\+/g," ");
	 objrow.reqd_qty=decodeURIComponent(reqd_qty,"UTF-8").replace(/\+/g," ");
	 objrow.uom=decodeURIComponent(uom,"UTF-8").replace(/\+/g," ");
	 objrow.mode=mode;
	 objrow.recId=recId;
	 rows.push(objrow);

   }
}

function getUom(item_code)
{
	//var item_code1=obj.value; 
	var frmObj = document.ConsumablePackRecordForm;
	var item_code = document.forms[0].item_code.value; 
	var locale = document.forms[0].locale.value; 
	var short_description = document.forms[0].short_description.value;	
	var masterframe = window.parent.parent.frames[1].RecordFrame; 
	var HdrformObj=masterframe.document.forms[0];
	var package_code=HdrformObj.package_code.value;
	var short_desc1 = HdrformObj.short_description.value;
	var mode=HdrformObj.mode.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var sql="SELECT A.SHORT_DESC FROM  AM_UOM_LANG_VW A,MM_ITEM B WHERE NVL(GEN_UOM_CODE,PUR_UOM_CODE) = A.UOM_CODE AND   ITEM_CODE = '"+item_code+"' AND   A.LANGUAGE_ID = '"+locale+"'";
	var param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal!=null){
		document.getElementById("uom_desc").innerText=retVal;
	}
}


function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

//CRF-268 Consumable pack - Rajesh V
async function callSS_Group_Code(){
   	var locale=document.forms[0].locale.value;
	var obj = document.forms[0].ss_group_code;
	var target = 	document.forms[0].ss_group_desc;
	var retVal =    new String();
	var arr="";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("eOT.CrossRefSSGroup.Label","OT");
	var sql="SELECT SHORT_DESC DESCRIPTION, GROUP_CODE CODE FROM SS_GROUP WHERE  NVL(EFF_STATUS, 'D') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(GROUP_CODE) LIKE UPPER(?) ORDER BY 1  ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal!= null && retVal!= "" ){
		var ret1=unescape(retVal);
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
//CRF-268 Consumable pack - Rajesh V
