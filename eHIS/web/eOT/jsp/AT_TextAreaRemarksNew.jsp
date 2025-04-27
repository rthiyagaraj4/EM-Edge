<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");	%>
<HTML>

<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script lanaguage='javascript'>
function windowClosing()
{
	//function crearted for function closgin
	var txtremarks=document.forms[0].txtCheck.value;
	var size=document.forms[0].remarks_size.value;
	var flag=document.forms[0].flag.value;
	if(flag=="1"){
		if(txtremarks.length > size){
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			window.returnValue=txtremarks.substring(0,size-1);
		}else{
			window.returnValue=txtremarks;
		}
	}
	window.close();
}

function SpecialCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = "\"`'&<>";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<% 

		String size=checkForNull(request.getParameter("size"));
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		String remarks_temp=checkForNull(request.getParameter("remarks_temp"));
		String remarks_temp_tt = java.net.URLDecoder.decode(remarks_temp,"UTF-8");
		if(remarks.equals("undefined")) remarks="";
		String chk_status=checkForNull(request.getParameter("chk_status"));
		String cancel_remarks=checkForNull(request.getParameter("cancel_remarks"));
		if(cancel_remarks ==null) cancel_remarks="";
		cancel_remarks = java.net.URLDecoder.decode(cancel_remarks,"UTF-8");
		title = java.net.URLDecoder.decode(title,"UTF-8");
		 String readOnly="readOnly";
		 String flag="";
		 flag=checkForNull(request.getParameter("flag"));
		 if(flag.equals("1")==true)	   readOnly="";
	 %>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>

<table  cellspacing='0'>
<tr>
	<td class="label" width='0%' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class="fields" width='0%' >
			<textarea name='txtCheck' rows='5' cols='67' <%=readOnly%> ><%=remarks%></textarea>
	</td>
	</tr>
		<%if(chk_status.equals("99")) {%>
		<tr>
		<td class="label"  width='0%' nowrap><fmt:message key="eOT.CancelledRemarks.Label" bundle="${ot_labels}"/></td>
	  <td class="fields" width='0%' ><textarea name='cancel_remark' rows='5' cols='67' <%=readOnly%> onkeypress="return SpecialCharRestriction(event);" Onblur="makeValidString(this);" ><%=cancel_remarks%></textarea></td>
	   </tr>

		<%}%>
<tr>
	<td class='MESSAGE' colspan='2' align='right'>

		<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='windowClosing();' >
		<input type='hidden' name='remarks' id='remarks' value="" >
		<input type='hidden' name='remarks_size' id='remarks_size' value="<%=size%>" >
		<input type='hidden' name='flag' id='flag' value="<%=flag%>" >
	</td>
</tr>
</table>
</form>
</body>
</HTML>

