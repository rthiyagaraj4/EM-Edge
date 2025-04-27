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
	 f_query_add_mod.location.href='../../eOT/jsp/BookingFinalisationStagesFrameForCreate.jsp?'+source;
	
}
//function for checking Duplicate entries for stage code, serial no., color indicator
function chkForDuplicates(){
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
    var stage_code=HdrformObj.stage_code.value;
	var srl_label=getLabel("Common.SerialNo.label","Common");
	var clr_label=getLabel("Common.Color.label","Common");
	var stg_label=getLabel("Common.StageCode.label","Common");
	var srl_no=HdrformObj.srl_no.value;
	var color_ind=HdrformObj.color_ind.value;
    var stage_code1=HdrformObj.stage_code1.value;
	var serial_no1=HdrformObj.serial_no1.value;
	var color_ind1=HdrformObj.color_ind1.value;
	var err_txt="";
	var txt_msg=getMessage('RECORD_ALREADY_EXISTS','Common');
	var arr_msg=txt_msg.split(" ");
	if(stage_code1.indexOf(stage_code)>=0 || serial_no1.indexOf(srl_no)>=0 || color_ind1.indexOf(color_ind)>=0){
         if(stage_code1.indexOf(stage_code)>=0){
			 //err_txt="APP-OT40 Stage Code Cannot be Duplicated...";
			 err_txt=arr_msg[0]+" "+stg_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
	}
	if(serial_no1.indexOf(srl_no)>=0){
              //err_txt+="APP-OT40 Serial Number Cannot be Duplicated...";
			err_txt+=arr_msg[0]+" "+srl_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
	}
      if(color_ind1.indexOf(color_ind)>=0){
             // err_txt+="APP-OT40 Color Cannot be Duplicated...";
              err_txt+=arr_msg[0]+" "+clr_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
	}
	if(err_txt.length>0){
			parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		 return false;
	 }
	 
	}else       
	  return true;
}
//Newly created for dup check in modify mode...,
// created by rajesh on 30/11/2007

function chkDupSerialNo(obj){
	if(obj.value!=""){
		if(ChkNumber(obj)){
			var formObj=document.forms[0];
			var masterframe = window.parent.frames[0]; 
			var HdrformObj=masterframe.document.forms[0];
			var srl_no=HdrformObj.srl_no.value;
			var serial_no1=HdrformObj.serial_no1.value;
			var serial_no_hiden=formObj.serial_no_hiden.value;
			var srl_label=getLabel("Common.SerialNo.label","Common");
			var err_txt="";
			var txt_msg=getMessage('RECORD_ALREADY_EXISTS','Common');
			var arr_msg=txt_msg.split(" ");	
			if(obj.value!=serial_no_hiden){
				if(serial_no1.indexOf(srl_no)>=0){
					err_txt+=arr_msg[0]+" "+srl_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
					alert(err_txt);
					obj.value="";
					obj.focus();
					//window.parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
					return false;
				}else{
					return true;
				}
			}
		}
	}

 }

 function chkDupStageCode(obj){
	if(obj.value!=""){
		if(ChkNumber(obj)){
			var formObj=document.forms[0];
			var masterframe = window.parent.frames[0]; 
			var HdrformObj=masterframe.document.forms[0];
			var stage_code=HdrformObj.srl_no.value;
			var stage_code1=HdrformObj.stage_code1.value;
			var stg_code_hdn=formObj.stage_code_hiden.value;
			var stg_label=getLabel("Common.StageCode.label","Common");
			var err_txt="";
			var txt_msg=getMessage('RECORD_ALREADY_EXISTS','Common');
			var arr_msg=txt_msg.split(" ");	
				if(obj.value!=stg_code_hdn){
					if(stage_code1.indexOf(stage_code)>=0){
						err_txt=arr_msg[0]+" "+stg_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
						alert(err_txt);
						obj.value="";
						obj.focus();
						//window.parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
						return false;
					}else{
						return true;
					}
				}
		}
	}

 }

 function chkDupColorCode(obj){
	if(obj.value!=""){
		var formObj=document.forms[0];
		var masterframe = window.parent.frames[0]; 
		var HdrformObj=masterframe.document.forms[0];
		var color_ind=HdrformObj.color_ind.value;
		var color_code_hiden=formObj.color_ind_hiden.value;
		var color_ind1=HdrformObj.color_ind1.value;
		var clr_label=getLabel("Common.Color.label","Common");
		var err_txt="";
		var txt_msg=getMessage('RECORD_ALREADY_EXISTS','Common');
		var arr_msg=txt_msg.split(" ");	
		if(obj.value!=color_code_hiden){
			if(color_ind1.indexOf(color_ind)>=0){
				err_txt=arr_msg[0]+" "+clr_label+" "+arr_msg[1]+" "+arr_msg[2]+" "+arr_msg[3];
				alert(err_txt);
				obj.value=color_code_hiden;
				obj.focus();
				//window.parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
				return false;
			}else{
				return true;
			}
		}
	}
 }

// function for checking mandatory fields in the Add Modify form
function chkMandatory(){
	var stageCode=getLabel("Common.StageCode.label","Common");
	var preStageDescription=getLabel("eOT.PreStageDescription.Label","OT");
	var postStageDescription=getLabel("eOT.PostStageDescription.Label","OT");
	var serialNo=getLabel("Common.SerialNo.label","common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var formObj=masterframe.document.forms[0];  //Add Modify form
	var fields = new Array ( formObj.stage_code, formObj.pre_stage_description, formObj.post_stage_description, formObj.srl_no);
	var names = new Array (stageCode,preStageDescription,postStageDescription,serialNo);
	//var messageFrame =window.parent.frames[1].frames[2];
	var messageFrame =parent.content.messageFrame;
	if(masterframe.checkFieldsofMst( fields, names, messageFrame))
		return true;
}
//To check whether the Specific Indicator is SPC or *ALL and than apply delete
function chkSpecific_Indicator(){
	//var recordFrame=window.parent.frames[1].frames[1].frames[0];
	var MasterFrame=parent.content.f_query_add_mod.MasterFrame;
	var recordFrame_formObj=MasterFrame.document.forms[0];
	var specific_ind=recordFrame_formObj.specific_indicator.value;
	var position_desc=recordFrame_formObj.position_desc.value;
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows;
	var count=0;
	var err_txt="";
    
	if(specific_ind=="SPC" && position_desc=='' && rows.length==0){
		//err_txt="Select The Apllicable Position And Create atleast One user"; 
		err_txt=getMessage("APP-OT0098","OT"); 
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return false;
	}else if(specific_ind=="SPC" && position_desc!='' && rows.length==0){
		//err_txt="Create atleast One user";
		err_txt=getMessage("APP-OT0099","OT");
        parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		return false;
	}else return true;
    for (var i=0;i<rows.length;i++){
		if(rows[i].mode=='D')
			count++;
	}
	
		if(count==rows.length){
			for (var i=0;i<count;i++){
			   if(specific_ind=="SPC" && rows[i].mode=='D'){
				 //err_txt="Change Specific Indicator To All Users And Than Apply";
				 err_txt=getMessage("APP-OT0102","OT");
				 parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
	             return false;
	      }else return true;
		}//end of for
    return;
  }else return true;//end of main if

}
function apply(){	
	//var msg = "No Changes to Commit..";
	if(typeof  parent.content.f_query_add_mod.DetailFrame!='undefined')
	{
	var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	//var masterframe = window.parent.frames[1].frames[1].frames[0]; 
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var HdrformObj=masterframe.document.forms[0];
	//var detailframe = window.parent.frames[1].frames[1].frames[4];
	var detailframe = parent.content.f_query_add_mod.DetailFrame;
    var message=getMessage('RECORD_ALREADY_EXISTS','Common');
	var stage_code=HdrformObj.stage_code.value;
	var mode=HdrformObj.mode.value;
	var specific_indicator=HdrformObj.specific_indicator.value;
	var user_id="";
	var mode1="";
	//var rows=window.parent.frames[1].frames[1].frames[1].rows;
	var rows=parent.content.f_query_add_mod.hidden_frame.rows;
	//var hiddenframe=window.parent.frames[1].frames[1].frames[1];
	 var hiddenframe=parent.content.f_query_add_mod.hidden_frame;
	if(chkMandatory()){
	if(mode=="insert"){
	  if(chkForDuplicates()){
		 if(chkSpecific_Indicator()){
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr="<root>";
			var action = '../../servlet/eOT.BookingFinalisationStagesServlet?specific_indicator='+specific_indicator;
			xmlStr+=hiddenframe.createXMLForBOOKING_FIN_STAGES_Hdr();
			xmlStr+=hiddenframe.createXMLForBOOKING_FIN_STAGES_Dtl();
			xmlStr+="</root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;
			var mesg=getMessage(trimString(retVal),"SM");
			parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+retVal;
			onSuccess();
		}//end of chkMode 
	  }	
	}else{
		if(chkSpecific_Indicator()){
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr="<root>";
			var action = '../../servlet/eOT.BookingFinalisationStagesServlet?specific_indicator='+specific_indicator;
			xmlStr+=hiddenframe.createXMLForBOOKING_FIN_STAGES_Hdr();
			xmlStr+=hiddenframe.createXMLForBOOKING_FIN_STAGES_Dtl();
			xmlStr+="</root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;
			var mesg=getMessage(trimString(retVal),"SM");
			parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+retVal;
			onSuccess();
		}
	}// end of else
  }//end of chkMandatory	
}else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
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


function onSuccess(){
	//var HdrformObj = window.parent.frames[1].frames[1].frames[0].document.forms[0]; 
	var HdrformObj = parent.content.f_query_add_mod.MasterFrame.document.forms[0]; 
	var code=HdrformObj.stage_code.value;
	var mode=HdrformObj.mode.value;
	if(f_query_add_mod.document.location.href.indexOf("BookingFinalisationStagesAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();

	parent.content.f_query_add_mod.location.href='../../eOT/jsp/BookingFinalisationStagesFrameForCreate.jsp?mode='+mode+'&stage_code='+code;
	
}

function reset() {
//	if(f_query_add_mod.document.forms[0].name=="BookingFinalisationStagesHdr"){
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BookingFinalisationStagesFrameForCreate.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("BookingFinalisationStagesAddModify.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("BookingFinalisationStagesQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}
//}
function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	/* if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    } */  //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/BookingFinalisationStagesQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].pac_stage_yn.checked==true)
		document.forms[0].pac_stage_yn.value="Y";
	else
		document.forms[0].pac_stage_yn.value="N";
}
/*function callUsercode(){
	var obj=document.forms[0];
	var facility_id=obj.facility_id.value;
	var masterframe=window.parent.frames[0];
	var applicable_position_code=masterframe.document.forms[0].position_code.value;
	var column_sizes = escape("60%,40%");               
	var column_descriptions = escape("Code,Description");
	var sql=escape("SELECT  A.APPL_USER_ID CODE, B.APPL_USER_NAME DESCRIPTION  FROM   SM_FACILITY_FOR_USER A, SM_APPL_USER B WHERE  A.APPL_USER_ID= B.APPL_USER_ID AND NVL(B.EFF_STATUS, 'E') = 'E' AND A.FACILITY_ID ='"+facility_id+"'  AND FUNC_ROLE_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACTITIONER WHERE  nvl(POSITION_CODE, 'X') = NVL('"+applicable_position_code+"', nvl(POSITION_CODE, 'X')))");
	var title=getLabel("Common.userid.label","common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].user_id.value = arr[0];
			document.forms[0].user_name.value = arr[1];	
		}
	else
		{
			document.forms[0].user_id.value = '';
			document.forms[0].user_name.value = '';
		}
}*/

function clearDesc(){
var frmObj=document.forms[0];
var user_name=frmObj.user_name.value;
if(user_name=="" ||user_name=="null" ||user_name==null)
	frmObj.user_id.value="";

}

async function callUsercode(obj,target){
	var locale = document.forms[0].locale.value;
	var facility_id=document.forms[0].facility_id.value;
	var masterframe=window.parent.frames[0];
	var applicable_position_code=masterframe.document.forms[0].position_code.value;
	var obj =      document.forms[0].user_id;
	var target = document.forms[0].user_name;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.userid.label","common");



	//var sql="SELECT  A.APPL_USER_ID CODE, B.APPL_USER_NAME DESCRIPTION  FROM   SM_FACILITY_FOR_USER A, SM_APPL_USER B WHERE  A.APPL_USER_ID= B.APPL_USER_ID AND NVL(B.EFF_STATUS, 'E') = 'E' AND A.FACILITY_ID ='"+facility_id+"'  AND FUNC_ROLE_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACTITIONER WHERE  nvl(POSITION_CODE, 'X') = NVL('"+applicable_position_code+"', nvl(POSITION_CODE, 'X') AND UPPER(B.APPL_USER_NAME) LIKE UPPER(?) AND UPPER(A.APPL_USER_ID) LIKE UPPER(?) ORDER BY 2)";

	var sql="SELECT  A.APPL_USER_ID CODE, B.APPL_USER_NAME DESCRIPTION  FROM   SM_FACILITY_FOR_USER A, SM_APPL_USER B WHERE  A.APPL_USER_ID= B.APPL_USER_ID AND NVL(B.EFF_STATUS, 'E') = 'E' AND A.FACILITY_ID ='"+facility_id+"'  AND UPPER(B.APPL_USER_NAME) LIKE UPPER(?) AND UPPER(A.APPL_USER_ID) LIKE UPPER(?) AND FUNC_ROLE_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND nvl(POSITION_CODE, 'X') = NVL('"+applicable_position_code+"', nvl(POSITION_CODE, 'X') )) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";

	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( title, argumentArray );
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

async function callApplicablePositionCode(obj,target){
	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Applicable Position Search" ;
	var tit=getLabel("eOT.ApplicablePosition.Label","OT");
	var sql="SELECT POSITION_DESC DESCRIPTION, POSITION_CODE CODE FROM AM_POSITION WHERE  NVL(EFF_STATUS, 'D') = 'E' AND UPPER(POSITION_DESC) LIKE UPPER(?) AND UPPER(POSITION_CODE) LIKE UPPER(?) ORDER BY 2 ";
	
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

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function ChkNumber(obj){
	var quantity=obj.value;

	if(isNaN(quantity)==true)
	{
		//alert(getMessage("Enter a valid no"));
		alert(getMessage("INVALID_NEXT_NUMBER","common"));
		obj.value="";
		obj.select();
		obj.focus();
		return false;
	}
	if(obj.value!="" && quantity<=0){
		//alert("Serial No Should be greater than zero");
		alert(getMessage("APP-OT0047","OT"));
		obj.value="";
		obj.select();
		obj.focus();
		return false;
	}else
		return true;

}

function Class_checkListrow(){
     this.user_id="";
	 //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete
     this.user_name="";
	 this.mode="";
	 this.recId ="";
}

function alreadyExist(){
	var formObj = document.BookingFinalisationStagesRecordForm;
	var codeDtl =window.parent.parent.frames[1].frames[4].user_code; //detail frame
	var codeRecord=formObj.user_id.value;
	
	if(codeDtl.indexOf(codeRecord)>=0)  {
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('RECORD_ALREADY_EXISTS','Common');
	return ;
    }else       
	  return true;
	}

 function chkEmpty(){
	 var username=getLabel("Common.username.label",'Common');
	var formObj = document.BookingFinalisationStagesRecordForm;
	var fields = new Array(formObj.user_name);
	var names = new Array(username);
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
  var masterframe=window.parent.frames[0];
  masterframe.document.forms[0].generic_search.disabled=true;
  masterframe.document.forms[0].position_desc.disabled=true;
  var formObj = document.BookingFinalisationStagesRecordForm;
  var mode =formObj.mode.value;
  if(mode=='I' && chkEmpty() && alreadyExist()){
	var objrow = newRow();
	objrow.user_id=formObj.user_id.value;
	objrow.user_name=unescape(formObj.user_name.value);
	objrow.mode="I";
	objrow.recId = rows.length+1;
	rows.push(objrow);	   
	resetFields();
	refresh();
}else
	updateRow();
}

function updateRow(){
	var formObj = document.BookingFinalisationStagesRecordForm;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	var rows=window.parent.parent.frames[1].frames[1].rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null){
					if(rows[jj].recId==recId){
                        rows[jj].user_id=formObj.user_id.value;
			            rows[jj].description=formObj.user_name.value;
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
var formObj = document.BookingFinalisationStagesRecordForm;
var masterFrame=window.parent.parent.frames[1].frames[0];
var HdrFormObj=masterFrame.document.forms[0];
var rows=window.parent.parent.frames[1].frames[1].rows;
var count=1;
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
	var frmObj = document.BookingFinalisationStagesRecordForm;
	frmObj.user_id.value=arr[0];
	frmObj.user_name.value=arr[1];
	frmObj.recId.value=arr[2];
	frmObj.mode.value=arr[3];
}

function resetFields(){
	var frmObj = document.BookingFinalisationStagesRecordForm;
	frmObj.user_id.value='';
	frmObj.user_name.value='';
	frmObj.mode.value='I';
	frmObj.generic_search.disabled=false;
	frmObj.user_name.disabled=false;
	frmObj.user_id.disabled=false;
}

function refresh(){
 window.parent.parent.frames[1].DetailFrame.location.href='../../eOT/jsp/BookingFinalisationStagesDetailForm.jsp?';              //+params;
}

function loadDBRows(user_id,user_name,recId,mode){ 
  var objrow = newRow();
  var rows=window.parent.parent.frames[1].frames[1].rows;
  var i=0;
  if(mode=='L'){
	 objrow.user_id = user_id;
	 objrow.user_name =unescape(user_name).replace(/\+/g," ");
	 objrow.mode=mode;
	 objrow.recId=recId;
	 rows.push(objrow);
  }
}
