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
   f_query_add_mod.location.href='../../eOT/jsp/SetComponentsFrameForCreate.jsp?'+source;
}
function apply()
{	
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined'){
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		var masterframe = parent.content.f_query_add_mod.MasterFrame;
		var detailframe = parent.content.f_query_add_mod.DetailFrame;
		var HdrformObj=masterframe.document.forms[0];
		var instr_code=HdrformObj.instr_code.value;
		var mode=HdrformObj.mode.value;
		var item_code="";
		var quantity="";
		var mode1="";
		//added for the location
		var st_location="";
		var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root>";
		var action = '../../servlet/eOT.SetComponentsServlet?';
		xmlStr+=hiddenframe.createXMLForInstrumentComponents();
		xmlStr+="</root>";
			if(xmlStr.indexOf("<root></root>")==-1){
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",action,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var mesg = (retVal=="Operation Completed Successfully....")?getMessage("RECORD_INSERTED","SM"):retVal;
				autoSearch(instr_code,mode,mesg);
				//parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
			}else {
				parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
	
			}else {
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
	 
   }

  function checkQuantity(){
	var formObj=document.forms[0];
	var qty=formObj.qty.value;
	if(qty=="0" || qty=="00"){
		var lbl=getLabel("Common.Quantity.label","Common");
		var msg=getMessage("CANNOT_BE_ZERO","OT");
		var err_msg=msg.split("&");
		alert(err_msg[0]+""+lbl+""+err_msg[1]);
		formObj.qty.select();
		return;
	}
  }

 function autoSearch(code,mode,mesg){
	if(mode=="modify") {					
	 parent.content.f_query_add_mod.location.href="../../eOT/jsp/SetComponentsFrameForCreate.jsp?instr_code="+code+"&update_mode_yn="+mode;
	 parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+mesg;
	} else {
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/SetComponentsFrameForCreate.jsp?update_mode_yn=insert&mesg="+mesg;
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+mesg;
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


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ChecklistsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/


function reset() {

//	 if(f_query_add_mod.document.location.href.indexOf("SetComponentsAddModify.jsp") != -1)
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SetComponentsFrameForCreate.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("SetComponentsAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SetComponentsQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}

}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];

	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    }

	f_query_add_mod.location.href='../../eOT/jsp/SetComponentsQueryCriteria.jsp';
}
function setStatusValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="Y";
	else
		document.forms[0].status.value="N";
}
/*function callInstrumentCode(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Instrument Search" ;
	var sql="SELECT SHORT_DESC DESCRIPTION, INSTR_CODE CODE FROM OT_INSTRUMENT WHERE  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) ORDER BY 1";

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
*/
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
/*function callItemCode(){
	var code=getLabel("Common.code.label","common");
	var description=getLabel("Common.description.label","common");
	var column_sizes = escape("60%,40%");               
	var column_descriptions = escape("Code,Description");
	var sql=escape("SELECT ITEM_CODE ITEMCODE, ITEM_DESC DESCRIPTION  FROM OT_SS_COMPONENTS");
	var title=getLabel("eST.ItemSearch.label","ST");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
			arr=retVal.split("::");
			document.forms[0].item_code.value = arr[0];
			document.forms[0].description.value = arr[1];	
	}else{
			document.forms[0].item_code.value = '';
			document.forms[0].description.value = '';
	}
}*/
function chkHdrForm(obj,target){
	var HdrformObj=window.parent.parent.frames[1].frames[0].document.forms[0];
	var instr_code=HdrformObj.instr_code.value;
	var err_msg=getMessage("CANNOT_BE_BLANK","OT");
	var err_mesg=err_msg.split("&");
	var instr_label=getLabel("Common.Instrument.label","Common");
	if(instr_code=="" || instr_code==null || instr_code=="null" || instr_code=="undefined"){
		alert(err_mesg[0]+""+instr_label+""+err_mesg[1]);
		obj.value="";
		target.value="";
		return false;
	}else{
		return true;
	}
}

async function callItemCode(obj,target){
	if(chkHdrForm(obj,target)){
	var obj =      document.forms[0].item_code;
	var target = document.forms[0].description;
	var st_location = document.forms[0].st_location;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eST.ItemSearch.label","ST");
	var sql="SELECT ITEM_CODE  CODE, ITEM_DESC  DESCRIPTION  FROM   OT_SS_COMPONENTS WHERE  UPPER(ITEM_DESC) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) ORDER BY 1";
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
//Added newly 29-05-2013 - 091
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=call_item_code&item_code="+obj.value,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[0]==undefined) { 
		arr[0]="";
		}
		st_location.value = arr[0];
	}
	else {
		st_location.value="";	
	}
	//Added newly 29-05-2013 -091
}

function ChkNumber(obj){
	var quantity=obj.value;
	if(isNaN(quantity)==true){
	//alert("Enter a valid no");
	   obj.select();
	   obj.focus();
	}
	if(obj.value!="" && quantity<0){
	  //alert("Quantity cannot be entered negative");
	  obj.select();
	  obj.focus();
	}
}



function Class_checkListrow(){
    //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.item_code="";
	 this.description="";
	 this.quantity="";
	 this.mode="";
	 this.recId ="";
}

function alreadyExist(){
	var itemCode=getLabel("Common.ItemCode.label","Common");
	var formObj = document.SetComponentsRecordForm;
	var codeDtl =window.parent.parent.frames[1].frames[4].code; //detail frame
	//alert(codeDtl);
	var item_code=formObj.item_code.value;
	var flag=true;
	var codeRecord = item_code;
	//alert(codeRecord);
	//alert(codeDtl.indexOf("@"+codeRecord+"@"));
	if(codeDtl.indexOf("@"+codeRecord+"@")>=0){
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("RECORD_ALREADY_EXISTS","Common");
		flag = false;
	}
	return flag;
}

	
function chkEmpty(){
	var itemDesc=getLabel("Common.description.label","Common");
	var quantity =getLabel("Common.Quantity.label","Common");
	var formObj = document.SetComponentsRecordForm;
	var fields = new Array(formObj.description,formObj.qty);
	var names = new Array(itemDesc,quantity);
	var messageFrame = window.parent.parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
		return true;
}

function newRow(){
  var objrow = new Class_checkListrow(); // 
   return(objrow);
}

function addRow(){
  var rows=window.parent.parent.frames[1].frames[1].rows;
   var formObj = document.SetComponentsRecordForm;
  var mode =formObj.mode.value;
  if(mode=='I' && chkEmpty() && alreadyExist()){
	     var objrow = newRow();
		 objrow.item_code=formObj.item_code.value;
		 objrow.description=formObj.description.value;
		 objrow.quantity=formObj.qty.value;
		 if(formObj.st_location!=null){  
			 objrow.st_location=formObj.st_location.value;//RUT-CRF-0091 by MuthuN
		 }
		 objrow.mode="I";
		 objrow.recId = rows.length+1;
		 rows.push(objrow);
		 resetFields();
		 refresh();
  }else
	updateRow();
}

function updateRow(){
	var formObj = document.SetComponentsRecordForm;
	var mode =formObj.mode.value
	var customer_id =formObj.customer_id.value;//RUT-CRF-0091 by MuthuN	
	var recId = formObj.recId.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(rows.length>0 && mode=='U' && chkEmpty() ){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null){
					if(rows[jj].recId==recId){
                        rows[jj].item_code=formObj.item_code.value;
						rows[jj].description=formObj.description.value;
						rows[jj].quantity=formObj.qty.value;
						if(customer_id =="RTN"){
						rows[jj].st_location=formObj.st_location.value;//RUT-CRF-0091 by MuthuN	
						}
			            if(rows[jj].mode=='L')
							rows[jj].mode='U';
                 }else  
			continue;
		 }
      resetFields();
	  refresh();
	}
	}
}

function removeRow(){
	var formObj = document.SetComponentsRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows;
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
				  rows.splice(jj,1);
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
	var frmObj = document.SetComponentsRecordForm;
	var customer_id =frmObj.customer_id.value;//RUT-CRF-0091 by MuthuN	
	frmObj.item_code.value=arr[0];
	frmObj.description.value=arr[1];
	frmObj.qty.value=arr[2];
	frmObj.recId.value=arr[3];
	frmObj.mode.value=arr[4];
	if(customer_id =="RTN"){
	frmObj.st_location.value=arr[5];//RUT-CRF-0091 by MuthuN
	}
	frmObj.description.disabled=true;
	frmObj.generic_search.disabled=true;
}


function resetFields(){
	var frmObj = document.SetComponentsRecordForm;
	frmObj.item_code.value='';
	frmObj.description.value='';
	frmObj.qty.value='';
if(frmObj.st_location!=null){	
	frmObj.st_location.value='';//RUT-CRF-0091 by MuthuN
}	
	frmObj.mode.value='I';
	frmObj.description.disabled=false;
	frmObj.item_code.disabled=false;
	frmObj.generic_search.disabled=false;
	
}

function refresh(){
 window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/SetComponentsDetailForm.jsp?';              
}

function loadDBRows(item_code,item_desc,item_qty,st_location,recId,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
   var i=0;
    if(mode=='L'){
	 objrow.item_code = item_code;
	 objrow.description =unescape(item_desc);
	 objrow.quantity=item_qty;
	 if(st_location !='undefined' ){
	 objrow.st_location=st_location;
	 }else{
	 }
	 objrow.mode=mode;
	 objrow.recId=recId;
     rows.push(objrow);
  }
}

function assignValues(obj){
	var rows=window.parent.frames[1].rows;
	if(rows.length!=0) rows.length=0;
	var RecordFrame=window.parent.frames[3];
	var update_mode_yn=RecordFrame.document.forms[0].mode.value;
	window.parent.frames[3].location.href="../../eOT/jsp/SetComponentsRecord.jsp?instr_code="+obj.value+"&update_mode_yn="+update_mode_yn;
}

function ChkPositiveNumber(obj) {
	var REG_EX  = /^[1-9]|[0-9]{2}$/
	if (obj.value!='' && !REG_EX.exec(obj.value)){
		alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
		obj.focus();
	}
	
 }

function clearDesc(){
var frmObj = document.SetComponentsRecordForm;
var desc=frmObj.description.value;
if(desc=="" ||desc=="null" ||desc==null)
	frmObj.item_code.value="";

}
