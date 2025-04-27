<!DOCTYPE html>
<%@page import = "eCommon.Common.*" contentType=" text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<HTML>
<HEAD>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/CheckInOutRecoveryRoom.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>


<script language='javascript'>
function checkDuplicateCode(){
	    var formObj = parent.disposal_detail_frame.document.DisposalDetailForm;
		var DisposalDetailCode =  formObj.code.value;
		var disposal_code = document.DisposalRecordForm.disposal_code.value;
		var anatomical_site_code = document.DisposalRecordForm.anatomical_site_code.value;
		var DisposalRecordcode =  document.DisposalRecordForm.anatomical_site_code.value+document.DisposalRecordForm.disposal_code.value;
		if(chkEmpty()){
		var k = DisposalDetailCode.indexOf(DisposalRecordcode);
		 if(k>=0){
			var message =  trimString(getMessage("CODE_ALREADY_EXISTS","Common"));//'operations already selected';
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+message
			return k;
		} else
			return 1; //returns one not alphabet 'l'
	}
	
}

function chkEmpty(){
	var formObj = document.forms[0]; 
	var fields = new Array(formObj.anatomical_site_code,formObj.disposal_code);
	var disposalDetails_title=getLabel("eOT.DisposalDetails.Label","OT");
	var disposal_title=getLabel("eOT.Disposal.Label","OT");
	var names = new Array(disposalDetails_title,disposal_title);
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function resetFields()
{
	var frmObj = document.forms[0];
	frmObj.anatomical_site_code.value='';
	frmObj.anatomical_site_desc.value='';
	frmObj.disposal_code.value='';
	frmObj.disposal_desc.value='';
	frmObj.given_by.value='';
	frmObj.received_by.value='';
	frmObj.mode.value='I';
	frmObj.anatomicalLookUp.disabled=false;
	frmObj.disposalLookUp.disabled=false;
	frmObj.anatomicalLookUp.focus();
}

function splitString(resultString){
 
    var arr = resultString.split('::');
	var frmObj = document.forms[0];
	frmObj.anatomical_site_code.value=arr[0];
	frmObj.anatomical_site_desc.value=arr[1];
	frmObj.disposal_code.value=arr[2];
	frmObj.disposal_desc.value=arr[3];
	frmObj.given_by.value=arr[4];
	frmObj.received_by.value=arr[5];
	frmObj.recId.value=arr[6];
	frmObj.mode.value=arr[7];
	frmObj.anatomicalLookUp.disabled=true;
	frmObj.disposalLookUp.disabled=false;
	//alert(frmObj.recId.value);
}



function cancelDisposalDtls()
{
	//var bean_id   = document.getElementById("bean_id").value;
	//var bean_name = document.getElementById("bean_name").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "oper_num=\""+ document.getElementById("oper_num").value + "\" ";
	xmlStr += "slate_user_id=\""+ document.getElementById("slate_user_id").value + "\" ";
	xmlStr += "anatomical_site_code=\""+ document.getElementById("anatomical_site_code").value + "\" ";
	xmlStr += " anatomical_site_desc=\""+ document.getElementById("anatomical_site_desc").value + "\" ";
	xmlStr += "disposal_code=\""+ document.getElementById("disposal_code").value + "\" ";
	xmlStr += " disposal_desc=\""+ document.getElementById("disposal_desc").value + "\" ";
	xmlStr += "given_by=\""+ document.getElementById("given_by").value + "\" ";
	xmlStr += "received_by=\""+ document.getElementById("received_by").value + "\" ";
	xmlStr +=" /></root>";
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mode=document.getElementById("mode").value;
	var recId=document.getElementById("recId").value;
	xmlHttp.open("POST","ChkInOutRecoveryValidation.jsp?func_mode=cancelDisposalDtls&mode="+mode+"&recId="+recId,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	parent.disposal_detail_frame.location.href='../../eOT/jsp/DisposalDtls.jsp';
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	resetFields();
}

function funCheckDeletion(){
	frmObj = document.DisposalRecordForm;
	var mode = frmObj.mode.value;
	if(mode=='I'){
		frmObj.anatomical_site_code.value='';
		frmObj.anatomical_site_desc.value='';
		frmObj.disposal_code.value='';
		frmObj.disposal_desc.value='';
		frmObj.given_by.value='';
		frmObj.received_by.value='';
	} else 
		cancelDisposalDtls()
}

	function callRecordfunction(){		
		var mode = document.DisposalRecordForm.mode.value;
		if(mode=='I'){
			var p = checkDuplicateCode();
			if(p==1) recordDisposalDtls();
			return;
		}
		recordDisposalDtls();
}

function recordDisposalDtls(){

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "oper_num=\""+ document.getElementById("oper_num").value + "\" ";
	xmlStr += "slate_user_id=\""+ document.getElementById("slate_user_id").value + "\" ";
	xmlStr += "anatomical_site_code=\""+ document.getElementById("anatomical_site_code").value + "\" ";
	xmlStr += "anatomical_site_desc=\""+ document.getElementById("anatomical_site_desc").value + "\" ";
	xmlStr += "disposal_code=\""+ document.getElementById("disposal_code").value + "\" ";
	xmlStr += "disposal_desc=\""+ document.getElementById("disposal_desc").value + "\" ";
	xmlStr += "given_by=\""+ document.getElementById("given_by").value + "\" ";
	xmlStr += "received_by=\""+ document.getElementById("received_by").value + "\" ";
	xmlStr +=" /></root>";
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mode=document.getElementById("mode").value;
	var recId=document.getElementById("recId").value;
	xmlHttp.open("POST","ChkInOutRecoveryValidation.jsp?func_mode=recordDisposalDtls&mode="+mode+'&recId='+recId,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	parent.disposal_detail_frame.location.href='../../eOT/jsp/DisposalDtls.jsp';
	resetFields();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DisposalRecordForm' id='DisposalRecordForm' action=''>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 
	<td class="label" width="25%"><fmt:message key="eOT.DisposedItem.Label" bundle="${ot_labels}"/> </td> 
	<td class="fields" width="25%" colspan="3">
	   <input type='hidden' name='anatomical_site_code' id='anatomical_site_code'>
	   <input type='text' name='anatomical_site_desc' id='anatomical_site_desc' size='30'  value='' >
		<input type='button' class='button' value='?' name='anatomicalLookUp' id='anatomicalLookUp' onClick='searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);' > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
 </tr>

<tr>
	<td class="label" width="25%"><fmt:message key="eOT.Disposal.Label" bundle="${ot_labels}"/> </td> 
	<td class="fields" width="25%" colspan="3">
			<input type='hidden' name='disposal_code' id='disposal_code'>
			<input type='text' name='disposal_desc' id='disposal_desc' size='30'  value=''  >
			<input type='button' class='button' value='?' name='disposalLookUp' id='disposalLookUp' onClick='searchDisposal(disposal_code,disposal_desc);' > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="label" width="25%" >
		<fmt:message key="Common.givenby.label" bundle="${common_labels}"/> 
	</td> 
	<td class="fields" width="25%" colspan="3">
		<input type='text' name='given_by' id='given_by' size='15' maxlength='100'>
		<img src='../../eCommon/images/mandatory.gif'></img>			
	</td>
</tr>
<tr>
	<td class="label" width="25%">
		<fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/> 
	</td> 
	<td class="fields" width="25%" colspan="3">
		<input type='text' name='received_by' id='received_by' size='15' maxlength='100'>			
	</td>
</tr>
<tr>
	<td class="fields" width="25%">
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='callRecordfunction();' >
	</td>
	<td class="fields" width="25%" colspan="3">
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funCheckDeletion();' >
	</td>
</tr>
</table>
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
</form>
</body>
</html>

