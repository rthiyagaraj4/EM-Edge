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
	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOT/jsp/ListItemsFrameForCreate.jsp?'+source;
	
}

//function for checking duplicate ListID already there
function chkForDuplicates(){
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
    var list_id=encodeURIComponent(HdrformObj.list_id.value);
	var list_id_from_DB=HdrformObj.list_id_from_DB.value;
	
	list_id_from_DB = list_id_from_DB.split(",");

	var err_txt="";

	for(var i = 0 ; i < list_id_from_DB.length; i++){
		if(list_id_from_DB[i] == list_id){
			err_txt=getMessage("RECORD_ALREADY_EXISTS","Common");
	    	parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		    return false;
		}
	 }
	//  if(list_id_from_DB.indexOf(list_id)>=0){	
	/*if(list_id_from_DB.indexOf(list_id,0)==-1){
			return true;
	 }else{
           // err_txt="APP-OT40 List ID Cannot be Duplicated...";
			err_txt=getMessage("RECORD_ALREADY_EXISTS","Common");
	    	parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		    return false;
	 }*/
	
   return true;
}
// function for checking mandatory fields in the Add Modify form(HdrForm)
function chkMandatory(){
	var listID=getLabel("Common.ListID.label","Common");
	var description=getLabel("Common.description.label","Common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var formObj=masterframe.document.forms[0];  //Add Modify form
	var fields = new Array ( formObj.list_id, formObj.description);
	var names = new Array (listID,description);
	//var messageFrame =window.parent.frames[1].frames[2];
	var messageFrame =parent.content.messageFrame;
	if(masterframe.checkFieldsofMst( fields, names, messageFrame))
		return true;
}

function apply(){
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
    //var masterframe = window.parent.frames[1].frames[1].frames[0]; 
    var masterframe = parent.content.f_query_add_mod.MasterFrame;  
	var HdrformObj=masterframe.document.forms[0];
	var list_id = HdrformObj.list_id.value;
	var description = HdrformObj.description.value;
	var mode=HdrformObj.mode.value;
	var item_description="";
	var item_value="";
	var default_value_yn="";
	var mode1="";
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows;
	//alert(rows.length)
	if(rows.length==0){
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false;
	}
		for (var i=0;i<rows.length;i++)
	{
	 item_description=rows[i].item_description;
	 item_value=rows[i].item_value;
	 default_value_yn=rows[i].default_value_yn;
	 mode1=rows[i].mode;
	 }
	var param = "list_id="+list_id+"&description="+description+"&mode="+mode+"&item_description="+item_description+"&item_value="+item_value+"&default_value_yn="+default_value_yn+"&mode1="+mode1;
	//var hiddenframe=window.parent.frames[1].frames[1].frames[1];
	var hiddenframe=parent.content.f_query_add_mod.hidden_frame;;

		if(chkMandatory() && chkForDuplicates()){
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr="<root>";
			var action = '../../servlet/eOT.ListItemsServlet?'+param;
			xmlStr+=hiddenframe.createXMLForListItemsHdr();
			xmlStr+=hiddenframe.createXMLForListItemsDtl();
			xmlStr+="</root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;
			var mesg=retVal;
			//Added by Sharon Crasta on 6/5/2009 for IN010539
			var mesg = (retVal=="Operation Completed Successfully....")?retVal:getMessage("RECORD_INSERTED","SM");
			autoRefresh(list_id,mode,retVal);
			//
			f_query_add_mod.location.reload();
			parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}//end of chkMandatory	 
	}else{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

//Added by Sharon Crasta on 6/5/2009 for IN010539
function autoRefresh(code,mode,mesg){
	 if(mode=="modify"){
			parent.content.f_query_add_mod.location.href="../../eOT/jsp/ChecklistsFrameForCreate.jsp?checklist_code="+code+"&update_mode_yn="+mode+"&mesg="+mesg;
	 }else{
			parent.content.f_query_add_mod.location.href="../../eOT/jsp/ChecklistsFrameForCreate.jsp";
	 }
 
 }
//
function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ListItemsFrameForCreate.jsp") != -1){
     if(f_query_add_mod.document.location.href.indexOf("ListItemsAddModify.jsp") != -1)
		  return false;
	 else
	 if(f_query_add_mod) f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ListItemsQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query(){
	var cmf=commontoolbarFrame.document.forms[0];
	/* if(!cmf.apply.disabled)
	{
      cmf.apply.disabled=true;
	   //commontoolbarFrame.document.forms[0].reset.disabled=true;

    } */ //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/ListItemsQueryCriteria.jsp';
}

function Class_checkListrow(){
     this.item_description="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.item_value="";
	 this.default_value_yn="";
	 this.mode="";
	 this.recId ="";
}

//This method is used to Validate Default Value
function chkBoxValidate(){
	var formObj = document.ListItemsRecordForm;
	var DtlFrame =window.parent.parent.frames[1].frames[4];
	var default_ynDtl =DtlFrame.default_value_yn; 
	var dftLstItem = DtlFrame.dftLstItem;
	var default_yn=(formObj.default_value_yn.checked==true)?"Y":"N";
	var listItemVal = formObj.item_value.value;
	var indx = (default_yn=="Y" && listItemVal!=dftLstItem)?default_ynDtl.indexOf(default_yn):-1;
	if(indx>=0)	{
			var err_txt=getMessage("APP-OT0116","OT");	
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt
			return false;
	}
	return true;
}  

function alreadyExist(){
	var formObj = document.ListItemsRecordForm;
	var item_valueDtl =window.parent.parent.frames[1].frames[4].item_value; //detail frame
	var item_descriptionDtl = window.parent.parent.frames[1].frames[4].item_description;//detail frame
	var item_value=formObj.item_value.value;
	var item_description=formObj.item_description.value;
	var flag = (item_descriptionDtl.indexOf(item_description)>=0)?true:(item_valueDtl.indexOf(item_value)>=0)?true:false; 
	if(flag){
			var err_txt=getMessage("RECORD_ALREADY_EXISTS","Common");
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	        return false;
	}
	return true;
}

 function chkEmpty(){
	var itemDescription=getLabel("Common.ItemDescription.label","Common");
	var itemValue=getLabel("Common.ItemValue.label","Common");
	var formObj = document.ListItemsRecordForm;
	var fields = new Array(formObj.item_description,formObj.item_value);
	var names = new Array(itemDescription,itemValue);
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
 // alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
   //alert(window.parent.parent.frames[1].frames[0].name);//masterFrame
  
  var formObj = document.ListItemsRecordForm;
  var mode =formObj.mode.value;
  //alert("mode in addrow=="+mode);
  if(chkBoxValidate()) {
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){         //if the row which is bieng inserted already does not exist
		   var objrow = newRow();
		   objrow.item_description=formObj.item_description.value;
		   objrow.item_value=formObj.item_value.value;
		   objrow.default_value_yn=(formObj.default_value_yn.checked)?"Y":"N";
		   objrow.mode="I";
		   objrow.recId = rows.length+1;
		  // checkDefaultValue();
		   rows.push(objrow);
		   resetFields();
		   refresh();
	} 
}else
	  updateRow();
  }
  }
}

function updateRow(){
	var formObj = document.ListItemsRecordForm;
	var item_description = formObj.item_description.value;
	var item_value =  formObj.item_value.value;
	var default_value_yn=formObj.default_value_yn.value;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj].recId==recId){
					 with(formObj){
						rows[jj].item_description=item_description.value;	
				         rows[jj].item_value=item_value.value;
				         rows[jj].default_value_yn=(default_value_yn.checked)?"Y":"N";
					   }
			           if(rows[jj].mode=='L' ) rows[jj].mode='U';
						break;
					}else  
		         		continue;
	        }
            resetFields();
	        refresh();
        }
}

function removeRow(){
var formObj = document.ListItemsRecordForm;
var rows=window.parent.parent.frames[1].frames[1].rows;
//alert(rows.length);
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].mode=='L' || rows[jj].mode=='U')
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

function resetFields(){
	var frmObj = document.ListItemsRecordForm;
	frmObj.item_description.value='';
	frmObj.item_value.value='';
	frmObj.default_value_yn.value='';
	frmObj.default_value_yn.checked=false;
	frmObj.mode.value='I';
	frmObj.item_description.disabled=false;
	frmObj.item_value.disabled=false;
}

function refresh(){
 /*var frm =window.parent.frames[1].frames[1].frames[3];
 var params=frm.document.forms[0].params.value;
  alert(params);*/
window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/ListItemsDetailForm.jsp?';              //+params;
}

function loadDBRows(item_desc,item_value,default_value_yn,recId,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
  if(default_value_yn=="Y") rows.DEF_FLAG="ON";
  var i=0;
   if(mode=='L'){	  
	 objrow.item_description = unescape(item_desc);
	 objrow.item_value =item_value;
	 objrow.default_value_yn=default_value_yn;
	 objrow.mode=mode;
	 objrow.recId=recId;
	 rows.push(objrow);
	}
}


