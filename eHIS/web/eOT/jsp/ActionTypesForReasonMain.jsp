<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
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

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eOT/js/ActionTypesForReason.js'></script>

<script language='javascript'>

function clearvalues()
{
	document.forms[0].reason_code.value='';
    document.forms[0].reason_description.value='';
    window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String reason_desc="";
String reason_code="";
String sql = "";
%>
<form name="ActionTypesForReason_form" id="ActionTypesForReason_form"  onload='FocusFirstElement()'  action="" method="" > 

<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>


<tr>
	<td class='label'  valign='top' >
		<!-- <fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/> Commented and added below legent by Muthu Against 44635 on 10/29/2013 -->
		<fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/>		
	</td>

	<td class='fields'>
	<input type="hidden" name="reason_code" id="reason_code" value="">
	<textarea  name="reason_description" rows='4' cols='30' onBlur="if(this.value!='')callReasons(reason_code,reason_description);"></textarea><input align=left valign=top type="button" class="button" name="generic_search" id="generic_search"  value="?" onclick="callReasons(reason_code,reason_description);">
    </td>
<td></td>
</tr>
<tr>
     <td width='25%'></td>  
     <td width='25%'></td>  
     <td width='25%' class="label">
			<input type='button' class='button' onClick='callDetailForm();' name='search' id='search' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' >
		<input type='button' class='"button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearvalues();'>
	</td>
   <td width='25%'></td>

</tr>
</table>

   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


