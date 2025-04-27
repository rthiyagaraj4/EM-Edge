/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	commontoolbarFrame.document.forms[0].apply.disabled=false;
	f_query_add_mod.location.href='../../eOT/jsp/PreOpIndicatorAddModify.jsp?mode=insert';
}

function apply(){	
		var fields = new Array (f_query_add_mod.document.forms[0].SHORT_DESC);
		var discreteMeasureDesc = getLabel("Common.description.label","common");
		var names = new Array (discreteMeasureDesc);
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) {	
			f_query_add_mod.document.forms[0].submit();
		}
		
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/PreOpIndicatorAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PreOpIndicatorAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("PreOpIndicator.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PreOpIndicatorQueryCriteria.jsp") != -1)
	{
	f_query_add_mod.document.forms[0].reset();
	}

}
function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/PreOpIndicatorQueryCriteria.jsp';
}
function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function clearDesc(obj){
	var frmobj=document.forms[0];
	frmobj.DISCR_MSR_ID.value='';
	if(obj.value=""){
	frmobj.SHORT_DESC.value="";
	}
}
async function callLOVForDISCR_MSR_ID(obj,target){

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var tit="Discrete Measurer" ;
	var tit=getLabel("Common.DiscreteMeasure.label","common");	
	var sql="SELECT  SHORT_DESC DESCRIPTION,DISCR_MSR_ID CODE  FROM  AM_DISCR_MSR WHERE  NVL(EFF_STATUS, 'D') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(DISCR_MSR_ID) LIKE UPPER(?) ORDER BY SHORT_DESC";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
		
	retVal = await CommonLookup(tit, argumentArray );
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
function deleterecord()
{    
	var frm=f_query_add_mod.document.forms[0];
	if(frm.name=='query_form' || frm.name=='QueryResult'){
		commontoolbarFrame.location.reload();
    }else{
		var frmobj=window.parent.frames[1].frames[1].document.forms[0];
		if(frmobj.mode.value=='insert'){
		//var msg="Not a valid operation";
		window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return;
		}else{
			if(f_query_add_mod.document.forms[0]!=null){
			var DISCR_MSR_ID=f_query_add_mod.document.forms[0].DISCR_MSR_ID.value;
			var status =f_query_add_mod.document.forms[0].mode.value;
			if(status != "insert"){
			//var answer =window.confirm("APP-002417 Do you want to Delete the Record?" );
			var answer =window.confirm(getMessage("DELETE_RECORD","common"));
			if(answer == true){
			var xmlStr ="<root></root>";
			var action="../../servlet/eOT.PreOpIndicatorDeleteServlet?DISCR_MSR_ID="+DISCR_MSR_ID;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var responseText=xmlHttp.responseText ;
			window.parent.frames[1].frames[0].location.reload();
			window.parent.frames[1].frames[1].location.href="../../eOT/jsp/PreOpIndicatorAddModify.jsp?mode=insert";
			window.parent.frames[1].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+responseText;
			}
			else{
				commontoolbarFrame.location.reload();
		        }	
     }
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
	}

	}
}
}
