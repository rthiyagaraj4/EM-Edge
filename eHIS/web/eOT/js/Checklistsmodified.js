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
   f_query_add_mod.location.href='../../eOT/jsp/ChecklistsFrameForCreate.jsp?'+source;
	
}
function chkForDuplicates()
{
	//alert("Check For Duplicates");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
    var checklist_code=HdrformObj.checklist_code.value;
	var checklist_code_from_DB=HdrformObj.checklist_code_from_DB.value;
	var err_txt="";
    if(checklist_code_from_DB.indexOf(checklist_code)>=0){
            //err_txt="APP-OT40 Code Cannot be Duplicated...";
			err_txt=getMessage('RECORD_ALREADY_EXISTS','Common');
	    	parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		    return false;
	 }
	 else {      
	  return true;
	 }
}
// function for checking mandatory fields in the Add Modify form

function chkMandatory(){
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var code=getLabel("Common.code.label","Common");
	var description=getLabel("Common.description.label","Common");
	var formObj=masterframe.document.forms[0];  //Add Modify form
	var fields = new Array ( formObj.checklist_code, formObj.description);
	var names = new Array (code,description);
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
	var checklist_code = HdrformObj.checklist_code.value;
	var description = HdrformObj.description.value;
	var status=HdrformObj.status.value;
	var mode=HdrformObj.mode.value;
	var checklist_item_srl_no="";
	var checklist_item_code="";
	var mode1="";
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows;
	/*if(rows.length==0){
		var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
		window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false;*/
	//}else{
			/*for (var i=0;i<rows.length;i++)
			{
			 checklist_item_srl_no=rows[i].checklist_item_srl_no;
			 checklist_item_code=rows[i].checklist_item_code;
			 mode1=rows[i].mode;
			}*/
			var param = "&checklist_code="+checklist_code+"&description="+description+"&status="+status+"&mode="+mode+"&checklist_item_srl_no="+checklist_item_srl_no+"&checklist_item_code="+checklist_item_code+"&mode="+mode1;
			//var hiddenframe=window.parent.frames[1].frames[1].frames[1];
			var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
			if(chkMandatory()){
			if(chkForDuplicates()){
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr="<root>";
			var action = '../../servlet/eOT.ChecklistsServlet?'+param;
			xmlStr+=hiddenframe.createXMLForChecklistHdr();
			xmlStr+=hiddenframe.createXMLForChecklistDtl();
			xmlStr+="</root>";
			if(xmlStr.indexOf("<root></root>")!=-1){
				var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	     		parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				return false;
			}
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var mesg=retVal;
			//alert(mesg)
			var mesg = (retVal=="Operation Completed Successfully....")?retVal:getMessage("RECORD_INSERTED","SM");
//			alert(mode)
			autoRefresh(checklist_code,mode,retVal);
			parent.content.f_query_add_mod.DetailFrame.location.reload();commontoolbarFrame
			//parent.content.f_query_add_mod.location.reload();
			
			parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				
		   }//end of chkForDuplicates
		 }//end of chkMandatory	 
	//}
	}else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
	
function trimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function autoRefresh(code,mode,mesg){
	 if(mode=="modify"){
			parent.content.f_query_add_mod.location.href="../../eOT/jsp/ChecklistsFrameForCreate.jsp?checklist_code="+code+"&update_mode_yn="+mode+"&mesg="+mesg;
	 }else{
			parent.content.f_query_add_mod.location.href="../../eOT/jsp/ChecklistsFrameForCreate.jsp";
	 }
 
 }

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ChecklistsAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ChecklistsFrameForCreate.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("ChecklistsAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ChecklistsQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	
	var cmf=commontoolbarFrame.document.forms[0];
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	////alert("commontoolbarFrame document==="+cmf.name);
	/*if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }*/
		  //commontoolbarFrame.document.forms[0].reset.disabled=true;

  	f_query_add_mod.location.href='../../eOT/jsp/ChecklistsQueryCriteria.jsp?querymode=query';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function ChkNumber(obj){
	var quantity=obj.value;
////alert(window.parent.parent.frames[1].frames[4].name);
	//CheckNum(obj);
	if(isNaN(quantity)==true)
	{
		//alert("Enter a valid no");
		alert(getMessage("NUM_ALLOWED","CA"));
	   obj.select();
	   obj.focus();
	   
	}
	if(obj.value!="" && quantity==0){
	  //alert("Srl No should be > 0");
	  alert(getMessage("APP-OT0047","OT"));
	  obj.select();
	  obj.focus();
	}
}

/*function callChecklistcode()
{
	var column_sizes = escape("60%,40%");  
	
	//var column_descriptions = escape("Code,Description");
	
	var column_descriptions = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT CHECKLIST_ITEM_CODE CHECKLISTITEMCODE, DESCRIPTION DESCRIPTION FROM OT_CHECKLIST_ITEMS WHERE NVL(STATUS,'E') = 'E' ");
//	var title='User Search';
	var title=getLabel("Common.user.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].checklist_item_code.value = arr[0];
			document.forms[0].description.value = arr[1];	
		}
	else
		{
			document.forms[0].checklist_item_code.value = '';
			document.forms[0].description.value = '';
		}
}*/

async function callChecklistcode(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.ChecklistItemCode.Label","OT");
	//var sql="SELECT POSITION_DESC DESCRIPTION, POSITION_CODE CODE FROM AM_POSITION WHERE  NVL(EFF_STATUS, 'D') = 'E' AND UPPER(POSITION_DESC) LIKE UPPER(?) AND UPPER(POSITION_CODE) LIKE UPPER(?) ORDER BY 2 ";
	var sql="SELECT DESCRIPTION DESCRIPTION,CHECKLIST_ITEM_CODE CODE FROM OT_CHECKLIST_ITEMS WHERE  NVL(STATUS, 'E') = 'E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_ITEM_CODE) LIKE UPPER(?) ORDER BY 2 ";
	//SELECT CHECKLIST_ITEM_CODE CHECKLISTITEMCODE, DESCRIPTION DESCRIPTION FROM OT_CHECKLIST_ITEMS WHERE NVL(STATUS,'E') = 'E'
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

function Class_checkListrow(){
     this.checklist_item_srl_no="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.checklist_item_code="";
	 this.description="";
	 this.mode="";
	 this.recId ="";
}

function alreadyExist(){
	var formObj = document.ChecklistRecordForm;
	var codeDtl =window.parent.parent.frames[1].frames[4].code; //detail frame
	var srl = window.parent.parent.frames[1].frames[4].srl;
	var checklist_item_code=formObj.checklist_item_code.value;
	var checklist_item_srl_no = formObj.checklist_item_srl_no.value;
	var codeRecord = checklist_item_code+",";
    var srlRecord = checklist_item_srl_no+",";
	//alert(codeDtl);
	//alert(codeDtl.indexOf(codeRecord)>=0);

/*	alert('code '+ codeDtl);
	alert('code rec'+codeRecord);
	alert('srlno '+ srl);*/

//Modified by dhanasekarV against incident IN026788 on 7/03/2011
 var codenum=codeDtl.indexOf(codeRecord);
 var srlnum = srl.indexOf(srlRecord);
 // alert(codeDtl.charAt(codenum-1));
//alert(' codenum '+codenum+' srlnum '+srlnum);



if (codenum==0 || codeDtl.charAt(codenum-1)==',')  
{
parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("eOT.ChecklistItemCode.Label","OT ");
return false;
}
else
	if(srlnum==0 || srl.charAt(srlnum-1)==',')
	{
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("Common.SerialNo.label","Common");
	return false;
	}
else
	  return true;


/*    if(codeDtl.indexOf(codeRecord)>=0 || srl.indexOf(srlRecord)>=0){
	if(codeDtl.indexOf(codeRecord)>=0)  {
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("eOT.ChecklistItemCode.Label","OT ");
	 return false;
	}
	else if(srl.indexOf(srlRecord)>=0){
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage("DUPLICATE_CODE_EXISTS","Common")+" : "+getLabel("Common.SerialNo.label","Common");
	return ;
	}
	}else       
	  return true;
	  */
	}

 function chkEmpty(){
	//var frmObj=document.checklistsHdr;
	var formObj = document.ChecklistRecordForm;
	var serial_no = getLabel("Common.SerialNo.label","Common");
	var chklist_desc=getLabel("Common.description.label","Common");
	var fields = new Array(formObj.checklist_item_srl_no,formObj.description);
	var names = new Array(serial_no,chklist_desc);
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
  //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame
   //alert(window.parent.parent.frames[1].frames[0].name);//masterFrame
  
  var formObj = document.ChecklistRecordForm;
  var mode =formObj.mode.value;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){         //if the row which is bieng inserted already does not exist
		   var objrow = newRow();
		   objrow.checklist_item_srl_no=formObj.checklist_item_srl_no.value;
		   objrow.checklist_item_code=formObj.checklist_item_code.value;
		   objrow.description=formObj.description.value;
		   //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		   //Start
		   var w = formObj.intra_operative_sel.selectedIndex;
   		   objrow.intra_operative_sel_val=formObj.intra_operative_sel.value;
		   objrow.intra_operative_sel_name=formObj.intra_operative_sel.options[w].text;
		   //End
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
	var formObj = document.ChecklistRecordForm;
	var checklist_item_srl_no = formObj.checklist_item_srl_no.value;
	var checklist_item_code =  formObj.checklist_item_code.value;
	var mode =formObj.mode.value;
	//alert("mode in update func=="+mode);
	var recId = formObj.recId.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].checklist_item_srl_no=checklist_item_srl_no;	
			            rows[jj].checklist_item_code=checklist_item_code;
						rows[jj].description=formObj.description.value;
			            rows[jj].mode=formObj.mode.value;
						//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		   //Start
		   rows[jj].intra_operative_sel=formObj.intra_operative_sel.value;
		   
		   //End
						if(rows[jj].mode=='L' || rows[jj].mode=='I')
							rows[jj].mode='U';
                             //alert("rows[jj].mode=="+rows[jj].mode);
							//break;
					}
		         }else  
			continue;
		 }
      resetFields();
	  refresh();
	 
 }
}

function removeRow(){
	var formObj = document.ChecklistRecordForm;
	var rows=window.parent.parent.frames[1].frames[1].rows;
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
	var frmObj = document.ChecklistRecordForm;
	frmObj.checklist_item_srl_no.disabled=true;
	frmObj.generic_search.disabled=true;
	frmObj.checklist_item_srl_no.value=arr[0];
	frmObj.checklist_item_code.value=arr[1];
	frmObj.description.value = arr[2];
	frmObj.recId.value=arr[3];
	frmObj.mode.value=arr[4];
	//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 25/02/2013
	//Start
	var intra_operative_sel=arr[5];
	if(intra_operative_sel=='N')
		{
		if(frmObj.intra_operative_chk.checked==true)
		frmObj.intra_operative_chk.checked=false;
		document.getElementById('intra_operative_sel_id').style.visibility='hidden';		
		}
	else
		{
		if(frmObj.intra_operative_chk.checked==false)
		frmObj.intra_operative_chk.checked=true;
		//var selectobject=document.getElementById('myselect'); 
		var selectobject=document.getElementById('intra_operative_sel'); 
		for (var i=0; i<selectobject.length; i++){ if (selectobject.options[i].value == 'N' ) selectobject.remove(i);	}
		document.getElementById('intra_operative_sel_id').style.visibility='';		
		}

	frmObj.intra_operative_sel.value=intra_operative_sel;
	//frmObj.intra_operative_sel.disabled=true;
	//frmObj.intra_operative_chk.disabled=true;
	//End
	frmObj.checklist_item_code.disabled=true;
	frmObj.description.disabled=true;
}


function resetFields(){
	var frmObj = document.ChecklistRecordForm;
	frmObj.checklist_item_code.value='';
	frmObj.checklist_item_srl_no.value='';
	frmObj.description.value='';
	frmObj.mode.value='I';
	frmObj.intra_operative_sel.value='N';
	//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 25/02/2013
	//Start
	//var selectobject=document.getElementById('myselect'); 
	var selectobject=document.getElementById('intra_operative_sel'); 
	for (var i=0; i<selectobject.length; i++)
		{
		if (selectobject.options[i].value == 'N' ) 
			{
			break;
			}
		else
			{
			//document.getElementById('myselect').options[2] = new Option('Select', 'N',true,true);
			document.getElementById('intra_operative_sel').options[2] = new Option('Select', 'N',true,true);
			}
		}
	document.getElementById('intra_operative_sel_id').style.visibility = 'hidden';
	frmObj.intra_operative_chk.checked=false;
	frmObj.intra_operative_chk.disabled=false;
	frmObj.intra_operative_sel.disabled=false;
	frmObj.description.disabled=false;
	//End
	frmObj.generic_search.disabled=false;
	frmObj.checklist_item_code.disabled=false;
	frmObj.checklist_item_srl_no.disabled=false;
	if (frmObj.select!=null)
	{
	frmObj.select.disabled=false;
	}
}

function refresh(){

	window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/ChecklistsDetailForm.jsp?'; 
	

}

function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}
//Maheshwaran K added 'intra_operative_sel' for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
function loadDBRows(checklist_item_srl_no,checklist_item_code,description,recId,mode,intra_operative_sel){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
 // alert(rows.length);
 var i=0;
  //alert("rowLength="+rowLength);
   if(mode=='L'){
	   objrow.checklist_item_srl_no = checklist_item_srl_no;
	   objrow.checklist_item_code =checklist_item_code;
	   objrow.description=unescape(description);
	   objrow.mode=mode;
	   objrow.recId=recId;
	   //Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		//Start
	    objrow.intra_operative_sel=intra_operative_sel;
		//End
	   rows.push(objrow);
	  // alert(rows.length);
   }
}

