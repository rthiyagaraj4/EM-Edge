/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
	var CODE_LINK       = "1"   ;
	var DESC_LINK       = "2"   ;
	var CODE_DESC_LINK  = "1,2" ;
	var CODE_DESC       = "CODE_DESC" ;
	var DESC_CODE       = "DESC_CODE" ;
	var radioval    = "D"         ;
	var firstCodeVal = "" ;
	var firstDescVal = "" ;
	var code=new String();
	

function class_row(){
	this.line_no="";
	this.oper_code="";
	this.oper_desc="";
	this.coding_scheme="";
	this.proc_code="";
	this.old_proc_code="";
	this.proc_desc="";
	this.proc_desc="";
	this.color="";
	this.link_enable="";
	this.db_mode="";
	this.rec_id="";
}

function newRow(){
	return new class_row()
}
	
function loadDBRows(strval){ 
  var frmRef = parent.parent.ObjectCollect;
  var rows=frmRef.ICD_PCS_ROWS;
   var rows1=parent.parent.ObjectCollect.rows;
  var arr = strval.split('::');
  var flag=true;
  for(j in rows){

               if (arr[1] == rows[j].oper_code && arr[4] == rows[j].proc_code){

                        flag=false;
						break;
			   }else{
				if(rows1[j].oper_line_status !="99" )
				{
					if(rows1[j].db_mode =="I")
					{
						 flag=true;
					}else
					{ 
						 flag=true;
					}
				}else if(rows1[j].oper_line_status =="99" )
				{
					if(rows1[j].db_mode =="I")
					{
						
						 flag=false;
					}else
					{
						 
						 flag=false;
					}
				}
   }
  }

  if(flag==true ){
	var obj = newRow();
	obj.line_no=arr[0];
	obj.oper_code=arr[1];
	obj.oper_desc=arr[2]
	obj.coding_scheme=arr[3];
	obj.proc_code=arr[4];
	obj.proc_desc=arr[5];
	obj.color=arr[6];
	arr[6]=="AUTO"?obj.link_enable="N":obj.link_enable="Y";
	arr[6]=="MANDATORY"?frmRef.mandatory_proc[code]="Y":"";
	obj.db_mode="L";
	obj.rec_id=rows.length+1;
	rows.push(obj);
  }

}


function assignLength(){
   var len = parent.parent.ObjectCollect.ICD_PCS_ROWS.length;
   if(len!=null)
	   parent.parent.ObjectCollect.ICD_PCS_LEN=len;
}

function addRow(){
   var mode = document.forms[0].mode.value;
   if(mode=="I"){
	   if(!isFldsEmpty() && !isRecordExist()){
		   var target = parent.parent.ObjectCollect;
		   var source_rows = parent.parent.ObjectCollect.rows;
		   var target_rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
		   var formObj = document.forms[0];
		   var code = formObj.operation.value;
		   var indx = getRowIndex(code);
		   var obj = new newRow();
		   obj.line_no=source_rows[indx].line_no;
		   obj.oper_code=source_rows[indx].oper_code;
		   obj.oper_desc=source_rows[indx].oper_desc
		   obj.coding_scheme=formObj.coding_scheme.value;
		   obj.proc_code=formObj.proc_code.value;
		   obj.proc_desc=formObj.proc_desc.value;
		   obj.color=source_rows[indx].color;
		   if(source_rows[indx].color=="MANDATORY" && target.mandatory_proc[code]=="N")
			   target.mandatory_proc[code]="Y";
		   obj.link_enable="Y";
		   obj.db_mode="I";
		   obj.rec_id=target_rows.length+1;
		   target_rows.push(obj);
		   resetFields();
		   refresh();
	   }
	 }else
		updateRow();
   }

  
function resetFields(){
	  with(document.forms[0]){
		proc_code.value="";
		proc_desc.value="";
		coding_scheme.value="";
		operation.disabled=false;
		mode.value='I';
	  }
}

function publishMessage(str){
	  parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+str;
}



function searchProcCode(obj,target){
	var locale = document.forms[0].locale.value;
	var order_catalog_code=getOrderCatlogCode();
	var tcode = obj.value;
	var tdesc = target.value;
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("65%,15%,20%");               

     var column_descriptions = getLabel('Common.code.label','common')+','+getLabel('Common.description.label','common')+','+getLabel('eOT.CodingScheme.Label','OT');

	column_descriptions = encodeURIComponent(column_descriptions);
	
	var sql=escape("SELECT A.PROC_CODE CODE, B.SHORT_DESC DESCRIPTION, A.PROC_CODING_SCHEME CODING_SCHEME FROM OR_ORDER_CATALOG_PROC_LINK A, MR_TERM_CODE B WHERE ORDER_CATALOG_CODE ='"+order_catalog_code+"' AND A.PROC_CODING_SCHEME = B.TERM_SET_ID AND A.PROC_CODE = B.TERM_CODE");
	var title = encodeURIComponent(getLabel("eOT.ProcedureCoding.Label","OT"));
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&sql="+sql+"&search_criteria="+tdesc;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	var formObj = document.forms[0];
	
	if(retVal!=null){
		var arr = retVal.split('::');
		target.value=arr[0];
		obj.value=arr[1];
		formObj.coding_scheme.value=arr[2];
	}else{
		obj.value="";
		target.value="";
	}
}


 function refresh(){
	var params = document.forms[0].params.value;
	parent.DetailFrame.location.href='../../eOT/jsp/ICDPCSDtls.jsp?'+params;
}



 function splitString(inStr){
	var formObj = document.forms[0];
    var arr = inStr.split("::");
	formObj.operation.value=arr[0];
	formObj.proc_code.value=arr[1];
	formObj.old_proc_code.value=arr[1];
	formObj.proc_desc.value=arr[2];
	formObj.recId.value=arr[3];
	formObj.mode.value = "U";
	formObj.coding_scheme.value=arr[4];
	formObj.operation.disabled=true;
 }

 function loadOperListItem(){
    var rows=parent.parent.ObjectCollect.rows;
	var selObj=document.forms[0].operation;
	if(selObj!=null){
		var count =0;
		for( var j in rows){
			if(rows[j].oper_line_status !="99")
			{
            if((rows[j].db_mode=="L" && rows[j].proc_link=="R") ||(rows[j].db_mode=="U" && rows[j].proc_link=="R" && rows[j].chk_status!='99')||(rows[j].db_mode=="I" && rows[j].proc_link=="R" && rows[j].chk_status!='99')){
				 selObj.options[count]=new Option(rows[j].oper_desc,rows[j].oper_code);
			//Correction  On process - incident SRR20056-SCF-5188 (Incident No:23742)  21/09/2010
			  // alert(rows[j].color);
				 selObj.options[count].className=rows[j].color;
			//	selObj.options[count].className  = 'MANDATORY';
				 	var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=proc_def_icd&oper_code="+rows[j].oper_code,false);
				xmlHttp.send(xmlDoc);
				var retVal = xmlHttp.responseText; 
					retVal=trimString(xmlHttp.responseText);
					if(retVal !="false"){
					if(document.forms[0].proc_code.value =="")
					{	
					var arr = retVal.split('::');
					document.forms[0].proc_desc.value=arr[0];
					document.forms[0].proc_code.value=arr[1];
					document.forms[0].coding_scheme.value=arr[2];
					}
					}else
					{
					document.forms[0].proc_desc.value="";
					document.forms[0].proc_code.value="X";
					document.forms[0].coding_scheme.value="";
					}
			
		

				 count++; 
			}
		}
		}

		if(count==0){
			selObj.options[count]=new Option("---Select---","x");
			selObj.disabled=true;
		}
	}
 }

 function getRowIndex(val){
	var rows=parent.parent.ObjectCollect.rows;
	for(var j in rows){
		if(rows[j].oper_code == val) return j;
	}
 }
function isFldsEmpty(){
var msg=getMessage('CANNOT_BE_BLANK','OT');
var msgArray = msg.split("&");
var procedure=getLabel("Common.Procedure.label","Common");

	var formObj = document.forms[0]; 
	var proc_desc = formObj.proc_desc.value;
	var proc_code = formObj.proc_code.value;
    if(proc_desc==""){
		formObj.proc_code.value="";
        msg=msgArray[0]+procedure+msgArray[1];
		publishMessage(msg);
		return true
	}else
		return false;
}
function isRecordExist(){
	var msg=getMessage('RECORD_ALREADY_EXISTS','Common');
	var formObj = document.forms[0];
	var code = parent.DetailFrame.code;
	var code_rec = formObj.operation.value+formObj.proc_code.value;
	var flag = (code.indexOf(code_rec)>=0)?true:false;
	if(flag) publishMessage(msg);
	return flag;
}

function getOrderCatlogCode(){
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE ='"+formObj.operation.value+"'";
	var params = "sql="+sql+"&flag=MED_SER";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	return responseText;
}

/**
  Remove the Leading and trailing whitespace characters 
  including space,\r\t\n using the regular expresssion 
*/

function trimString(inString){
    return inString.replace(/^\s+|\s+$/g,"");
}

function getMatchedRow(){
	var oper_code = document.forms[0].operation.value;
	var proc_code = document.forms[0].old_proc_code.value;
	var recId = document.forms[0].recId.value;
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	for(j in rows){
		if (oper_code == rows[j].oper_code && proc_code == rows[j].proc_code){
			return j;
		}
	}
}

function resetCode(obj){


			var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=proc_def_icd&oper_code="+obj.value,false);
				xmlHttp.send(xmlDoc);
				var retVal = xmlHttp.responseText; 
				retVal=trimString(xmlHttp.responseText);

					if(retVal!="false"){
					var arr = retVal.split('::');
					document.forms[0].proc_desc.value=arr[0];
					document.forms[0].proc_code.value=arr[1];
					document.forms[0].coding_scheme.value=arr[2];
				}else
				{
					document.forms[0].proc_desc.value="";
					document.forms[0].proc_code.value="";
					document.forms[0].coding_scheme.value="";
				}
}

function updateRow(){
	var formObj = document.forms[0];
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var indx = getMatchedRow(); 
	if(!isFldsEmpty()) {
	if(rows[indx].db_mode=="L"){	
			rows[indx].db_mode="U";
			rows[indx].proc_code=formObj.proc_code.value;
			rows[indx].proc_desc=formObj.proc_desc.value;
			rows[indx].coding_scheme=formObj.coding_scheme.value;
			rows[indx].old_proc_code = formObj.old_proc_code.value;
	}else{
			rows[indx].proc_code=formObj.proc_code.value;
			rows[indx].proc_desc=formObj.proc_desc.value;
			rows[indx].coding_scheme=formObj.coding_scheme.value;
	}
	resetFields();
	refresh();
	}
}

function deleteRow(){
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
	var target = parent.parent.ObjectCollect.mandatory_proc;
	if(document.forms[0].mode.value=="U"){
		var indx= getMatchedRow();
		var code = (rows[indx].color=="MANDATORY")?rows[indx].oper_code:"";
		if(rows[indx].db_mode=="L" || rows[indx].db_mode=="U"){
			rows[j].db_mode="D";
		}else
			rows.splice(j,1);
		resetFields();
		refresh();
	checkMandatoryFlag(code);
	}else
		resetFields();
}

function checkMandatoryFlag(code){
	if(code!=""){
		var code_oper="";
		var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS;
		var target = parent.parent.ObjectCollect.mandatory_proc;
		for(var j in rows){
		  if(rows[j].db_mode!='D')	
			code_oper+=rows[j].oper_code+",";
		  }
		if(code_oper.indexOf(code)==-1){
			target[code]="N";
			 parent.parent.parent.doc_status_frame.SurgeonDocStatusForm.doc_complete.checked = false;
		}

	}
}



function showRemarks(obj,str){
	if(str!=""){
	str = split_string(str,20);
	var tabdata = "<html><body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK><tr><th><font size=2><b>Description</b></font></th><tr><td class=SEN nowrap>"+str+"</td></tr></table></body></html>";
		document.getElementById("tooltip").innerHTML = tabdata;
		document.getElementById("tooltip").style.top  = obj.offsetTop+15;
		document.getElementById("tooltip").style.left  = obj.offsetLeft+15;
		document.getElementById("tooltip").style.visibility="visible" ;
	}
}

function hidePopUp(){
	document.getElementById("tooltip").style.visibility="hidden" ;
}

/*
This function splits the string in to given length of sub strings
 and adding the marker<BR> for each splitted string
function split_string(s)
param: String to be splitted;
param:no_constant##length of the splitting string
*/

function split_string(str,chars){
	var arr =new Array();
	var count=k=0;
	for(var j=0;j<str.length;){
		arr[count++]=str.slice(j,k+chars);
		j=k=k+chars;
	 }
	 return arr.join("<BR>");
}


function sendparams(index){
	var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS[index]; 
	var formObj =parent.RecordFrame.document.forms[0];
		formObj.operation.value=rows.oper_code
		formObj.proc_code.value=rows.proc_code
		formObj.old_proc_code.value=rows.proc_code
		formObj.proc_desc.value=rows.proc_desc
		formObj.recId.value=rows.rec_id
		formObj.mode.value = "U";
		formObj.coding_scheme.value=rows.coding_scheme
		formObj.operation.disabled=true;
}


function createTable(){    
  var rows = parent.parent.ObjectCollect.ICD_PCS_ROWS; 
  var color="";
  var link_enable="";
  var font_color="";
  var qry_val="";
  tab_data="<table border='1' cellpadding='0' cellspacing='0' width='100%'>"
  tab_data+="<th align='center' width='10%'>&nbsp;&nbsp;&nbsp;</th>";
  tab_data+="<th width='50%' align='center' nowrap>Operation</th>";
  tab_data+="<th align='center' width='50%' nowrap>Procedure Code</th>";
  tab_data+="<th align='center' width='10%' nowrap>Coding Scheme</th>";
   for(var j in rows){
		if( rows[j].db_mode!="D"){
			color = rows[j].color;	
			font_color = rows[j].color=="OPTIONAL"?"BROWN":"WHITE";
			code+=rows[j].oper_code+rows[j].proc_code+",";	
			qryVal=(j%2==0)?"QRYEVEN":"QRYODD";
			tab_data+="<tr>";
			tab_data+="<td width='5%' class="+color+"></td>";
			if(rows[j].link_enable=="Y" && document.forms[0].doc_comp.value!="Y"){
				tab_data+="<td class="+qryVal+">";
				tab_data+="<a href=\"javascript:sendparams("+j+");\">"+rows[j].oper_desc+"</a></td>";
			}else{
				tab_data+="<td class="+qryVal+">"+rows[j].oper_desc+"</td>";
			}
			tab_data+="<td class="+qryVal+" onMouseOver=\"javascript:showRemarks(this,'"+rows[j].proc_desc+"');\" onMouseOut=\"javascript:hidePopUp();\">"+rows[j].proc_code+"</td>";
			tab_data+="<td class="+qryVal+">"+rows[j].coding_scheme+"</td>";
			tab_data+="</tr>"; 
		}//END OF IF
  }//end of for 
    tab_data+="</table>";
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility="visible";
  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}
