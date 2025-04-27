<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@include file="../../eOT/jsp/StringUtil.jsp"%>

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
<script language='javascript' src='../../eOT/js/FunctionsForUser.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;"
class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%


Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=checkForNull(request.getParameter("mode"));
String l_user_id=checkForNull(request.getParameter("user_id"));
String user_id="";
String user_desc="";
String selected="";
String sql = "";
%>

<form name="functionsForUser_form" id="functionsForUser_form"  onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='50%'  align='center'>
<tr>
	<td class=label >
		<fmt:message key="Common.user.label" bundle="${common_labels}"/>
	</td>

	<td class="fields">
		<input type="text" name="user_description" id="user_description" value="<%=user_desc%>" size=20 maxlength=20
		onBlur="if(this.value!='')callUser(user_id,user_description); else user_id.value='' "><input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"><input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callUser(user_id,user_description);"><img src='../../eCommon/images/mandatory.gif'></img>
	</td> 
</tr>
<tr>
	<td class="fields"></td>
    <td align="left"class="label">
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvalues();">
	</td>	
</tr>
</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->


<% 
if(mode.equals("modify")){%>
   <script>document.forms[0].search.click();</script>
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

