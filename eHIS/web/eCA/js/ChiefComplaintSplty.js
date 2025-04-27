var linkContent = "";

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/ChiefComplaintSplty.jsp?';
}

function reset(){
f_query_add_mod.ChiefComplaintSplty.document.forms[0].reset();
}

function query(){
	f_query_add_mod.location.href="../../eCA/jsp/ChiefComplaintSpltySearch.jsp";
}

function apply(){
f_query_add_mod.detailFrame.document.forms[0].submit();
}

function show_complnt_lookup_blur(target,code){

	show_complnt_lookup(target,code);

}

async function show_complnt_lookup(target,code){
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();

	argumentArray[0]="SELECT complaint_id code, complaint_DESC description FROM CA_CHIEF_COMPLAINT WHERE EFF_STATUS = 'E' and upper(complaint_id) like upper(?) and upper(complaint_DESC) like upper(?) ORDER BY 2";
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.ChiefComplaint.label","common"),argumentArray);

	if(retval !=null && retval != ""){
		code.value=retval[0];
		target.value=retval[1];
		parent.parent.f_query_add_mod.ChiefComplaintSplty.document.ChiefComplaintSpltyCriteriafrm.temp_complnt_desc.value=retval[1];
		}
}

function displayLink(obj){
	var complnt_code=document.ChiefComplaintSpltyCriteriafrm.complnt_code.value;
	if(complnt_code!=""){
		var buttonVal=obj;
		if(buttonVal=="S"){
			document.getElementById("SelectTab").className="clicked";
			document.getElementById("AssociateTab").className="normal";
			document.ChiefComplaintSpltyCriteriafrm.sel_mode.value="S";
		}else if(buttonVal=="A"){
			document.getElementById("SelectTab").className="normal";
			document.getElementById("AssociateTab").className="clicked";
			document.ChiefComplaintSpltyCriteriafrm.sel_mode.value="A";
		}
		var formObj=document.forms[0];
		formObj.complnt_desc.disabled="true";
		formObj.complnt_button.disabled="true";
		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
		if(buttonVal=="A"){
			//document.forms[0].all.linkId.className ="";
			//document.forms[0].all.linkId.innerHTML = "&nbsp;";
			document.getElementById(linkId).className ="";
			document.getElementById(linkId).innerHTML = "&nbsp;";
			 clearAssctList();
			 //alert('45')
			//parent.frames[0].document.forms[0].action = "../../eCA/jsp/ChiefComplaintSpltyDetails.jsp?tabVal="+obj+"&complnt_code="+complnt_code;

			//parent.frames[0].document.forms[0].target = 'detailFrame';

			//parent.frames[0].document.forms[0].submit();
			parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintSpltyDetails.jsp?tabVal="+buttonVal+"&complnt_code="+complnt_code+"&mode="+document.forms[0].mode.value;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			//document.forms[0].all.linkId.innerHTML = linkContent;
			document.getElementById(linkId).innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}

	}else{
		var msg = getMessage("SERVICE_BLANK","OR");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}


 function callOnAlphaLink(obj, obj2){
	 
	changeAlphaColor(obj2);
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		//var flag = latestUpdate();
	}
		var complnt_code=document.ChiefComplaintSpltyCriteriafrm.complnt_code.value;

	if(complnt_code !=""){
	parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintSpltyDetails.jsp?complnt_code="+complnt_code+"&index="+obj+"&tabVal=S";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		document.forms[0].complnt_desc.disabled=true;
		document.forms[0].complnt_button.disabled=true;
	}
	else{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		var msg = getMessage("SERVICE_BLANK","OR");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}
}


function checksplt(chk,obj,sp_desc){
	if(chk.checked)
		var chck="Y"
	else
		var chck="N";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/ChiefComplaintSpltyIntermediate.jsp?specialty_code="+obj+"&chck="+chck+"&ass_sel="+document.forms[0].tabVal.value+"&spec_desc="+sp_desc, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	return;
}

function checkVal(obj){	

parent.frames[1].location.href="../../eCA/jsp/ChiefComplaintSpltyDetails.jsp?complnt_code="+document.forms[0].complnt_code.value+"&index="+document.forms[0].index.value+"&tabVal="+document.forms[0].tabVal.value+"&from="+document.forms[0].from.value+"&to="+document.forms[0].to.value+"&dispMode="+obj+"&sel_mode="+document.forms[0].sel_mode.value;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";

}


function onSuccess(){
	parent.frames[1].frames[1].location.reload();
}

function clearAssctList(){
		var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "ass_sel=\"" +document.forms[0].sel_mode.value+ "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/ChiefComplaintSpltyIntermediate.jsp?clear=clear", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);
	return;
}
