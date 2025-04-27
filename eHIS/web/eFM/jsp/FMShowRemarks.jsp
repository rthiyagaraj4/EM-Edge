<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>

<%
	request.setCharacterEncoding("UTF-8");
	String curr_remarks = request.getParameter("curr_remarks");
	String title = request.getParameter("title");
	String editable = request.getParameter("editable");
	String rows = request.getParameter("rows");
	String cols = request.getParameter("cols");
	String maxLimit = request.getParameter("maxLimit");
	String chkBlank = request.getParameter("chkBlank");
   String funct= request.getParameter("funct");
	
	if(funct==null) funct="";
	if (rows == null) rows = "5";
	if (cols == null) cols = "60";
	if (maxLimit == null) maxLimit= "100";
	if (chkBlank == null) chkBlank= "false";
	if (editable == null) editable="";
	
	if (curr_remarks==null) curr_remarks="";
 /* if(funct.equals("req"))
	{
	curr_remarks=java.net.URLDecoder.decode(curr_remarks,"UTF-8");
	}  */
%>

<HEAD>
	<TITLE><%= title %></TITLE>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
    overflow-y: scroll;
    height: 100px;
    resize: none; /* Remove this if you want the user to resize the textarea */
}
</style>

	<SCRIPT>
		var chkBlank = "<%= chkBlank %>";
		function checkMaxLimit(obj, maxSize, keycode) {

			
			// code added for icn:19422 date:Wednesday, February 24, 2010  charcter restrict for 19717
		
  		
		//	keycode == 37  || keycode == 43 || keycode == 35||
			
			if (keycode == 96 || keycode == 126 ||  keycode == 39 ||
				keycode == 34 || obj.value.length >= maxSize) return false;
			else return true;
		}

		function chkForBlank() {
			if (trimCheck(document.getElementById("comments").value)) {
				return true;
			}
			else {
				//alert("APP-000001 - Remarks cannot be blank");
				var errmsg=getMessage("CAN_NOT_BE_BLANK","common");
				errmsg=errmsg.replace('$',getLabel("Common.remarks.label","common"));
				alert(errmsg);
				document.getElementById("comments").focus();
				return false;
			}
		}

		function closeWin() {
			if (chkBlank == "true") {
				if (chkForBlank()) {
					if (document.getElementById("comments").value.length > <%= maxLimit %>) {
					//	alert("APP-SM0045 - Remarks cannot exceed " + <%= maxLimit %>  + " characters");
						var errmsg=getMessage("REMARKS_CANNOT_EXCEED","common");
						errmsg=errmsg.replace('$',getLabel("Common.remarks.label","common"));
						errmsg=errmsg.replace('#',<%= maxLimit %>);
						alert(errmsg);
						document.getElementById("comments").focus();
					}
					else {
						window.returnValue = document.getElementById("comments").value;
						parent.document.getElementById("dialog_tag").close(); 
					}
				}
			}
			else {
				if (document.getElementById("comments").value.length > <%= maxLimit %>) {
					//alert("APP-SM0045 - Remarks cannot exceed " + <%= maxLimit %>  + " characters");
					var errmsg=getMessage("REMARKS_CANNOT_EXCEED","common");
					errmsg=errmsg.replace('$',getLabel("Common.remarks.label","common"));
					errmsg=errmsg.replace('#',<%= maxLimit %>);
				
					alert(errmsg);
					document.getElementById("comments").focus();
				
				}
				else {
					window.returnValue = document.getElementById("comments").value;
					parent.document.getElementById("dialog_tag").close(); 
				}
			}
		}

		

	</SCRIPT>
</HEAD>

<BODY onUnload="closeWin()" onKeyDown = 'lockKey()' >
<!-- <p style="margin-bottom: 0px;">Request Remarks</p> -->
<TABLE WIDTH="100%" BORDER="0" CELLSPACING="0" CELLPADDING="3" ALIGN="center" >
	<TR>
		<TD CLASS="label" WIDTH="10%"></TD>
	</TR>
	<TR>
		<TD WIDTH="90%" CLASS="label">&nbsp;<TEXTAREA id="comments" NAME="comments" ROWS="<%= rows %>" COLS="<%= cols %>" <%= editable %> onKeyPress="return checkMaxLimit(this,'<%=maxLimit%>', event.keyCode);" onBlur="makeValidString(this);"><%= curr_remarks%></TEXTAREA>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id="mand" style="Visibility:'Hidden'"></img></TD>
	</TR>
	
	
	<tr>
	<td align="center" class='labelcenter'><INPUT  TYPE="button" CLASS="button" name="Ok" id="Ok" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="closeWin()"></td>
	</tr>
	<!-- <tr><td class='label'>&nbsp;</td></tr> -->
</TABLE>
<!-- <CENTER><INPUT TYPE="button" CLASS="button" name="Ok" id="Ok" VALUE="    Ok    " onClick="closeWin()"></CENTER> -->
<script>
	if ("<%=chkBlank%>"=="true")
		 document.getElementById("mand").style.visibility='Visible';
	else document.getElementById("mand").style.visibility='Hidden';
</script>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

