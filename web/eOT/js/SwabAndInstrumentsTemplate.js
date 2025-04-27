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
	////alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	////alert("params="+source);
   f_query_add_mod.location.href='../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?'+source;
	
}
function chkForDuplicates()
{
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
    var template=HdrformObj.template.value;
	var template_id_from_DB=HdrformObj.template_id_from_DB.value;
	var err_txt="";
    if(template_id_from_DB.indexOf(template)>=0){
           //err_txt="APP-OT40 Template ID Cannot be Duplicated...";
			err_txt=getMessage("RECORD_ALREADY_EXISTS","Common");

	    	parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		    return false;
	 }else       
	  return true;
}
// function for checking mandatory fields in the Add Modify form
function chkMandatory(){
	var description=getLabel("Common.description.label","Common");
	var templateID=getLabel("Common.TemplateID.label","Common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var formObj=masterframe.document.forms[0];  //Add Modify form
	var fields = new Array ( formObj.template, formObj.description);
	var names = new Array (templateID,description);
	//var messageFrame =window.parent.frames[1].frames[2];
	var messageFrame =parent.content.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
		return true;
}


function apply()
{	
	//var msg = "No Changes to Commit..";
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
	var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame;
	var HdrformObj=masterframe.document.forms[0];
	var detailframe = parent.content.f_query_add_mod.DetailFrame;
	var template_id=HdrformObj.template.value;
	var description = HdrformObj.description.value;
	var status = HdrformObj.status.value;
	var mode=HdrformObj.mode.value;
	var srl_no="";
	var item_code="";
	var initial_count="";
	var mode1="";
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows;
	for (var i=0;i<rows.length;i++)
	{
     srl_no=rows[i].srl_no;
	 item_code=rows[i].item_code;
	 initial_count=rows[i].initial_count;
	 mode1=rows[i].mode;
	}
	
    var param = "template_id="+template_id+"&description="+description+"&status="+status+"&mode="+mode+"&item_code="+item_code+"&srl_no="+srl_no+"&initial_count="+initial_count+"&mode1="+mode1;
	//var hiddenframe=window.parent.frames[1].frames[1].frames[1];
	var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
	if(chkMandatory()){
	if(chkForDuplicates()){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.SwabAndInstrumentsTemplateServlet?'+param;
	xmlStr+=hiddenframe.createXMLForSWAB_INSTR_TMPL_Hdr();
	xmlStr+=hiddenframe.createXMLForSWAB_INSTR_TMPL_Dtl();
	xmlStr+="</root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
    var mesg=retVal;
	autoRefresh(template_id,mode,status,mesg);
	       /* window.parent.frames[1].frames[1].frames[1].location.reload();
			window.parent.frames[1].frames[0].location.reload();
			window.parent.frames[1].frames[1].frames[0].location.reload();
		    window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;*/
   }//end of chkForDuplicates
 }//end of chkMandatory	 
 }else{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function autoRefresh(code,mode,status,mesg){
	var params ="template_id="+code+"&status="+status+"&update_mode_yn="+mode+"&mesg="+mesg;
	if(mode=="modify")
		//parent.frames[1].frames[1].location.href="../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?"+params;
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?"+params;
	  else
		//parent.frames[1].frames[1].location.href="../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?mesg="+mesg;	
		parent.content.f_query_add_mod.location.href="../../eOT/jsp/SwabAndInstrumentsTemplateFrameForCreate.jsp?mesg="+mesg;	
	 }

 function checkReturnString(str){
	var valid_str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:@#";
	var checked_str = "";
	for(var jj=0;jj<str.length;jj++){
		if( valid_str.indexOf( str.charAt(jj) )!=-1 )
			checked_str+=str.charAt(jj);
	}
	//alert(checked_str);
	return checked_str;
 }
 
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ChecklistsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	   		f_query_add_mod.document.forms[0].reset();  
}*/

function reset() {
   if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SwabAndInstrumentsTemplateFrameForCreate.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("SwabAndInstrumentsTemplateAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
   }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SwabAndInstrumentsTemplateQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	//alert("commontoolbarFrame document==="+cmf.name);
	/* if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
 	  //commontoolbarFrame.document.forms[0].reset.disabled=true;
    } */ //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/SwabAndInstrumentsTemplateQueryCriteria.jsp';
}
function setStatusValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}
async function callSwabAndInstrumentsTemplatecode(obj,target){
	
	//var obj =      document.forms[0].item_code;
	//var target = document.forms[0].description;
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit='Swab And Instruments Template Search';
	var tit=getLabel("eOT.SwabandInstrumentCount.Label","OT");
//	var sql="SELECT ITEM_CODE  CODE, DESCRIPTION  DESCRIPTION  FROM   OT_SWAB_INSTR_TMPL_ITEMS WHERE NVL(STATUS,'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) ORDER BY 1";
	var sql="SELECT ITEM_CODE  CODE, DESCRIPTION  DESCRIPTION  FROM   OT_SWAB_INSTR_ITEMS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(STATUS,'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(ITEM_CODE) LIKE UPPER(?) ORDER BY 1";
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
/*var column_sizes = escape("60%,40%");               
	var column_descriptions = escape("Code,Description");
	var sql=escape("SELECT  ITEM_CODE ITEMCODE, DESCRIPTION DESCRIPTION FROM OT_SWAB_INSTR_TMPL_ITEMS WHERE NVL(STATUS,'E') = 'E' ");
	var title='Swab And Instruments Template Search';
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].item_code.value = arr[0];
			document.forms[0].description.value = arr[1];	
		}
	else
		{
			document.forms[0].item_code.value = '';
			document.forms[0].description.value = '';
		}*/
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
	var quantity=obj.value;
////alert(window.parent.parent.frames[1].frames[4].name);
	//CheckNum(obj);
	if(isNaN(quantity)==true){
		//alert("Enter a valid no");
		alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
		obj.select();
		obj.focus();
	}
	if(obj.value!="" && quantity<=0){
	//alert("Initial Count cannot be less than or equal to zero");
	var msg_1 = getMessage("APP-OT0068","OT");
	var msgArr = msg_1.split("#");
	var initialCount=getLabel("eOT.InitialCount.Label","OT");
	alert(msgArr[0]+initialCount+msgArr[1]);
	  obj.select();
	  obj.focus();
	}
}

function Class_checkListrow(){
     this.srl_no="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.item_code="";
	 this.description="";
	 this.initial_count="";
	 this.mode="";
	 this.recId ="";
}

function alreadyExist(){
	var formObj = document.SwabAndInstrumentsTemplateRecordForm;
	var codeDtl =window.parent.parent.frames[1].frames[4].code; //detail frame
	//alert("codeDtl=="+codeDtl);
	var srl = window.parent.parent.frames[1].frames[4].srl;
	//alert("serial no=="+srl);
	var item_code=formObj.item_code.value;
	var srl_no = formObj.srl_no.value;
	var codeRecord = item_code;
    var srlRecord = srl_no;
	
    if(codeDtl.indexOf(codeRecord)>=0 || srl.indexOf(srlRecord)>=0){
	if(codeDtl.indexOf(codeRecord)>=0)  {
		//parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+"APP-OT40 Item Code Cannot be Duplicated...";
parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("Common.ItemCode.label","Common");
	
    }else if(srl.indexOf(srlRecord)>=0){
		//parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+"APP-OT41 Srl no Cannot be Duplicated...";
parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("Common.SerialNo.label","Common");
	return ;
	}

	}else       
	  return true;
	}

 function chkEmpty(){
	 var srlNo=getLabel("Common.SerialNo.label","Common");
	 var itemDesc=getLabel("Common.description.label","Common");
	var formObj = document.SwabAndInstrumentsTemplateRecordForm;
	var fields = new Array(formObj.srl_no,formObj.description);
	var names = new Array(srlNo,itemDesc);
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
  
  var formObj = document.SwabAndInstrumentsTemplateRecordForm;
  var mode =formObj.mode.value;
  //alert(mode);
  if(chkEmpty()){
	if(mode=='I'){
		 if(alreadyExist()){         //if the row which is bieng inserted already does not exist
		   var objrow = newRow();
		   objrow.srl_no=formObj.srl_no.value;
		   objrow.item_code=formObj.item_code.value;
		   objrow.description=formObj.description.value;
		  /* if(formObj.initial_count.value=='' || formObj.initial_count.value==null)
              formObj.initial_count.value="&nbsp;";*/
		   objrow.initial_count=formObj.initial_count.value;
		   objrow.mode="I";
		   objrow.recId = rows.length+1;
		   
		   rows.push(objrow);
		   resetFields();
		   refresh();
		  
	} 
	}else
	  updateRow();
  }
}

function updateRow(){
	var formObj = document.SwabAndInstrumentsTemplateRecordForm;
	var item_code = formObj.item_code.value;
	var srl_no =  formObj.srl_no.value;
	var description=formObj.description.value;
	var initial_count=formObj.initial_count.value;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	formObj.srl_no.disabled=false;
	formObj.item_code.disabled=false;
	formObj.generic_search.disabled=false;
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
                        rows[jj].srl_no=srl_no;	
			            rows[jj].item_code=item_code;
						rows[jj].description=formObj.description.value;
						
						/*if(formObj.initial_count.value=='' || formObj.initial_count.value==null)
                               formObj.initial_count.value="&nbsp;";*/
						
						rows[jj].initial_count=formObj.initial_count.value;
			            if(rows[jj].mode=='L' || rows[jj].mode=='I')
							rows[jj].mode='U';
                     }
		         }else  
			continue;
		 }
      resetFields();
	  refresh();
	}
}

function removeRow(){
var formObj = document.SwabAndInstrumentsTemplateRecordForm;
var rows=window.parent.parent.frames[1].frames[1].rows;
////alert(rows.length);
formObj.srl_no.disabled=false;
formObj.item_code.disabled=false;
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
	var frmObj = document.SwabAndInstrumentsTemplateRecordForm;
	
	frmObj.item_code.value=arr[0];
	frmObj.srl_no.value=arr[1];
	frmObj.srl_no.disabled=true;
	frmObj.description.value=arr[2];
	frmObj.initial_count.value=arr[3];
	frmObj.recId.value=arr[4];
	frmObj.mode.value=arr[5];
	frmObj.item_code.disabled=true;
	frmObj.description.disabled=true;
	frmObj.generic_search.disabled=true;
		
}

function resetFields(){
	var frmObj = document.SwabAndInstrumentsTemplateRecordForm;
	frmObj.description.value='';
	frmObj.srl_no.value='';
	frmObj.item_code.value='';
	frmObj.initial_count.value='';
	frmObj.mode.value='I';
	//frmObj.generic_search.disabled=false;
	frmObj.description.disabled=false;
	frmObj.item_code.disabled=false;
	//frmObj.checklist_item_srl_no.focus();
}

function refresh(){
	params = document.forms[0].params.value;
	window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/SwabAndInstrumentsTemplateDetailForm.jsp?'+params;
}

function loadDBRows(item_code,description,srl_no,initial_count,recId,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
 // //alert(rows.length);
 var i=0;
  ////alert("rowLength="+rowLength);
   if(mode=='L')
	{
	  
	 objrow.item_code = item_code;
	 objrow.description =decodeURIComponent(description,"UTF-8").replace(/\+/g," ");
	 objrow.srl_no=srl_no;
	 objrow.initial_count=initial_count;
	  objrow.mode=mode;
	  objrow.recId=recId;
	   rows.push(objrow);
	   ////alert(rows.length);
	    
	 
	}
}
