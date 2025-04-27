<!DOCTYPE html>

<%@page  import ="eCommon.XSSRequestWrapper,eOT.ChkInOutRecoveryBean"  %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
	<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
	<script type='text/javascript' src='../../eOT/js/CheckInOutRecoveryRoom.js'></script>
<script language='javascript'>
function checkDuplicateCode(){
	var formObj = parent.untowards_evt_detail_frame.document.UntowardEvtDetailForm;
	var UntowardEvtDetailCode =formObj.code.value;
	var UntowardEvtRecordcode = document.UntowardEvtRecordForm.unusual_occur_code.value;
	if(chkEmpty()){
	  var k = UntowardEvtDetailCode.indexOf(UntowardEvtRecordcode);
		 if(k>=0){
			var message =  trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
		    parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+message
			return k
		}else
			return 1;
	}
}

function chkEmpty(){
	var formObj = document.forms[0]; 
	var fields = new Array(formObj.unusual_occur_code);
	var names = new Array(getLabel("eOT.UnusualOccurrence.Label","OT"));
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

async function openNewDialogWindow(strVal,obj,size){
	var remarks = encodeURIComponent(obj.value);
	var param='heading='+encodeURIComponent(strVal)+'&para='+remarks+'&size='+size;
	var retext= await window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param,window,"dialogHeight: 143px; dialogWidth:498px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'||retext==''||retext==null)
		retext=obj.value;
	obj.value=retext;
}


function resetFields()
{
	var frmObj = document.forms[0];
	frmObj.unusual_occur_code.value='';
	frmObj.unusual_occur_desc.value='';
	frmObj.action_remarks.value='';
	frmObj.general_remarks.value=''
	frmObj.mode.value='I';
	frmObj.UnusualOccuranceLookUp.disabled=false;
	frmObj.UnusualOccuranceLookUp.focus();
}

function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.unusual_occur_code.value=arr[0];
	frmObj.unusual_occur_desc.value=arr[1];
	frmObj.action_remarks.value=arr[2];
	frmObj.general_remarks.value=arr[3];
	frmObj.recId.value=arr[4];
	frmObj.mode.value=arr[5];
	frmObj.UnusualOccuranceLookUp.disabled=true;
	
}

function cancelUntowardEvtsDtls()
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "oper_num=\""+ document.getElementById("oper_num").value + "\" ";
	xmlStr += "slate_user_id=\""+ document.getElementById("slate_user_id").value + "\" ";
	xmlStr += "unusual_occur_code=\""+ document.getElementById("unusual_occur_code").value + "\" ";
	xmlStr += "unusual_occur_desc=\""+ document.getElementById("unusual_occur_desc").value + "\" ";
	xmlStr += "action_remarks=\""+ checkSpl(document.getElementById("action_remarks").value) + "\" ";
	xmlStr += "general_remarks=\""+ checkSpl(document.getElementById("general_remarks").value) + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mode=document.getElementById("mode").value;
	var recId=document.getElementById("recId").value;
	xmlHttp.open("POST","ChkInOutRecoveryValidation.jsp?func_mode=cancelUntowardEvtsDtls&mode="+mode+"&recId="+recId,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	parent.untowards_evt_detail_frame.location.href='../../eOT/jsp/UntowardEvtsDtls.jsp';
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	resetFields();
}


  function funCheckDeletion(){

		frmObj = document.UntowardEvtRecordForm;
		var mode = frmObj.mode.value;
		if(mode=='I'){
		frmObj.unusual_occur_code.value='';
		frmObj.unusual_occur_desc.value='';
		frmObj.action_remarks.value='';
		frmObj.general_remarks.value=''
		} else 
			cancelUntowardEvtsDtls();
   }

	function callRecordfunction(){		
		var mode = document.UntowardEvtRecordForm.mode.value;
		if(mode=='I'){
			var p = checkDuplicateCode();
			if(p==1) recordUntowardEvtsDtls();
			return;
		}
		recordUntowardEvtsDtls();
}

function recordUntowardEvtsDtls(){
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += "oper_num=\""+ document.getElementById("oper_num").value + "\" ";
	xmlStr += "slate_user_id=\""+ document.getElementById("slate_user_id").value + "\" ";
	xmlStr += "unusual_occur_code=\""+ document.getElementById("unusual_occur_code").value + "\" ";
	xmlStr += "unusual_occur_desc=\""+ document.getElementById("unusual_occur_desc").value + "\" ";
	xmlStr += "action_remarks=\""+ checkSpl(document.getElementById("action_remarks").value) + "\" ";
	xmlStr += "general_remarks=\""+ checkSpl(document.getElementById("general_remarks").value) + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mode=document.getElementById("mode").value;
	var recId=document.getElementById("recId").value;
	xmlHttp.open("POST","ChkInOutRecoveryValidation.jsp?func_mode=recordUntowardEvtsDtls&mode="+mode+'&recId='+recId,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	parent.untowards_evt_detail_frame.location.href='../../eOT/jsp/UntowardEvtsDtls.jsp';
	resetFields();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
		String bean_id = "ChkInOutRecoveryBean";
		String bean_name = "eOT.ChkInOutRecoveryBean";
		ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
		String oper_num = checkForNull(request.getParameter("oper_num"));
		String order_id = checkForNull(request.getParameter("source_order_id"));
		String postop_done_yn = checkForNull(request.getParameter("postop_done_yn"),"N");
		String disabled_flag=("Y".equals(postop_done_yn))?"disabled":"";
		String locale = ((String)session.getAttribute("LOCALE"));
		String slate_user_id = checkForNull(request.getParameter("slate_user_id"));
		oper_num = ("".equals(oper_num))?bean.getOperNum(order_id):oper_num;
		int sz = bean.getUntowardEventsDtls().size();
		if(sz==0){
			bean.loadUntowardEvtDtls(oper_num);
		}
%>
<form name='UntowardEvtRecordForm' id='UntowardEvtRecordForm'>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td class="label" width='25%'>
		<fmt:message key="eOT.UnusualOccurrence.Label" bundle="${ot_labels}"/>
	</td>
	<td class="label" width='25%'>
			<input type='text' name='unusual_occur_desc' id='unusual_occur_desc' size='20'  value='' onblur="if(this.value!='')searchUnusalOccurance(unusual_occur_code,unusual_occur_desc); else unusual_occur_code.value=''" <%=disabled_flag%>>
			<input type='hidden' name='unusual_occur_code' id='unusual_occur_code'>
			<input type='button' class='button' value='?' name='UnusualOccuranceLookUp' id='UnusualOccuranceLookUp' onClick='searchUnusalOccurance(unusual_occur_code,unusual_occur_desc);' <%=disabled_flag%> > 
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td  class='gridLink' width='25%'>
		<a class="gridLink" href="javascript:openNewDialogWindow('<fmt:message key='Common.ActionRemarks.label' bundle='${common_labels}'/>',document.forms[0].action_remarks,99)"> 
		<fmt:message key="Common.ActionRemarks.label" bundle="${common_labels}"/> </a>
	</td> 
	<td  class='gridLink' width='25%'>
		<a class="gridLink" href="javascript:openNewDialogWindow('<fmt:message key='Common.generalRemarks.label' bundle='${common_labels}'/>',document.forms[0].general_remarks,99)"> <fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/> </a>
	</td> 
	<td class="label" width='25%'>
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='callRecordfunction()' <%=disabled_flag%>>
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funCheckDeletion()' <%=disabled_flag%>>
	</td> 
</tr>
</table>
<!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
	<input type='hidden' name='action_remarks' id='action_remarks' value=''>
	<input type='hidden' name='general_remarks' id='general_remarks' value=''>
	<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
	<input type='hidden' name='mode' id='mode' value='I'>
	<input type='hidden' name='recId' id='recId' value=''>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>	

<script>
	var params = '<%=request.getQueryString()%>';
	parent.untowards_evt_detail_frame.location.href="../../eOT/jsp/UntowardEvtsDtls.jsp?"+params;
</script>
</form>
</html>

