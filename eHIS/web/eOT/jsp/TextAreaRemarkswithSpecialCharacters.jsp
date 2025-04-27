<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");	%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<style>
textarea {
  resize: none;
}
</style>
<script lanaguage='javascript'>
	function windowClosing()
	{
		var size=document.forms[0].size.value;
		var txtremarks=document.forms[0].txtCheck.value;
		//alert("txtremarks==="+txtremarks)
	  if(txtremarks.length > size){
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			//APP-OT0025 # Remarks should not be more than # character
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			//alert("txtremarks==="+txtremarks.substring(0,size))
			//window.returnValue=txtremarks.substring(0,size);
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks.substring(0,size);
		}
		else{
			var remarks = txtremarks;
			//window.returnValue=remarks;
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = remarks;
		}
		//window.close();
		const dialogTag = parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}

	function setValue(){
		//var remarks = document.forms[0].txtCheck.value;
		//window.returnValue='CL_REM';
		//window.close();
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = 'CL_REM';
		const dialogTag = parent.document.getElementById("dialog_tag");    
		dialogTag.close();
	}


	function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading
	  return sInString.replace( /\s+$/g, "" );// strip trailing
	}

	function replaceGreaterThan(obj){
		obj.value = obj.value.replace(/>/,""); 
	}
	//End	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	<% 
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		String size=checkForNull(request.getParameter("size"));
		remarks = java.net.URLDecoder.decode(remarks,"UTF-8");//IN052628 //IN056028
		if(remarks.equals("undefined") )
			remarks = "";
		String readOnly="";
		String disabled="";
		String readOnlyYN=checkForNull(request.getParameter("readOnlyYN"));
		if(readOnlyYN.equals("Y")){	   
			readOnly="readOnly";
			disabled = "disabled";
		}
		String patient_id = request.getParameter("patient_id"); 	
	 %>
<TITLE><%=title%></title>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form>
<table  cellspacing='0'>
<tr>
	<td>
		<textarea name='txtCheck' rows='5' cols='67' <%=readOnly%>  onBlur="makeValidString(this)" id='remarks_txt'><%=remarks%></textarea>
	</td>
</tr>
<tr>
	<td class='MESSAGE' align='center'>
		<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowClosing();' <%=disabled%>>
		<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="setValue()">
</td>
</tr>
</table>
  <input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>" >
  <input type="hidden" name="remarks" id="remarks" value="<%=remarks%>" > 
  <input type='hidden' name='size' id='size' value="<%=size%>" >
</form>
</body>
</HTML>

