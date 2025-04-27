<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = ((String)session.getAttribute("LOCALE"));
String facility_id=(String) session.getAttribute("facility_id");
//String position_code=" ";

request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script language="javascript" src="../../eOT/js/OTMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>


<body onLoad="/*auth_disable();*/ " onKeyDown='lockKey()' OnMouseDown='CodeArrest()'>
<%

String falgDis="";
String flag=checkForNull(request.getParameter("flag"));
if(flag.equals("d")){
	falgDis="disabled";
	
}
	else
	{
	falgDis="";
	
	}

String check_auth="";
String p_string_val	= checkForNull(request.getParameter("p_string_val"));	


	
String user_id	= checkForNull(request.getParameter("user_id"));	
String user_name	= checkForNull(request.getParameter("user_name"));	
String auth_user	= checkForNull(request.getParameter("auth_user"));
String authorise	= checkForNull(request.getParameter("authorise"));



//String allow	= checkForNull(request.getParameter("_allow_authorization_yn"));
/*
String _flagAllow="";

if(allow.equals("Y"))
	_flagAllow="";
else
_flagAllow="disabled";

*/
String _update_mode_yn	= checkForNull(request.getParameter("_update_mode_yn"));	
String _spec_user_id	= "";
String _specific_ind	= "";

if(_update_mode_yn.equals("update_db")){
_spec_user_id=checkForNull(request.getParameter("_spec_user_id"));
_specific_ind=checkForNull(request.getParameter("_specific_ind"));
}

String auth_disabled="";
if(authorise.equals("Y")){
	
auth_disabled="";

}
else{
	
auth_disabled="disabled";

}


if(auth_user.equals("Y")){
	check_auth="checked";
}
else
check_auth="";

String p_mode	= checkForNull(request.getParameter("p_mode"));	
String all_User	= checkForNull(request.getParameter("all_user"));
String all_User_chk="";
if(all_User.equals("*ALL")||_specific_ind.equals("*ALL")){
all_User_chk="disabled";
}
else
	all_User_chk="";
String modify	= checkForNull(request.getParameter("modify"));
String update_modify_string="";
if(modify.equals("modify")){
	
	String p_string_user_id=checkForNull(request.getParameter("p_string_user_id"));
	String user_id_mod="";
   String user_name_mod="";
   String auth_user_mod="";
	StringTokenizer splitedtoken = null;
	String tokenvalue = "";
	tokenvalue="";
	int j = 0;
   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
   update_modify_string=update_modify_string;
	while(token1.hasMoreTokens()){
			j++ ;
			tokenvalue      = token1.nextToken();
			splitedtoken=new StringTokenizer(tokenvalue,"`");
		while (splitedtoken.hasMoreTokens()){
			user_id_mod		        =	splitedtoken.nextToken();
			user_name_mod			=	splitedtoken.nextToken();
			auth_user_mod			=	splitedtoken.nextToken();
			if(!p_string_user_id.equals(user_id_mod)) update_modify_string=update_modify_string+user_id_mod+"`"+user_name_mod+"`"+auth_user_mod+"~";
		}
	}
}

%>


<form name="RecodePrivilegeSetupUserDetail" id="RecodePrivilegeSetupUserDetail"    action="" method="" target="">

					
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>

<tr>
	<td class="label" width='25%'>
		<fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="user_id" id="user_id" value="<%=user_id%>" <%=all_User_chk%> size='6' maxlength='30' onBlur="if(this.value!='')callUsercode(user_id,user_name);">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" <%=all_User_chk%> onClick='callUsercode(user_id,user_name);' >
	<%if(all_User.equals("*ALL")||_specific_ind.equals("*ALL")){%>

	<img src='../../eCommon/images/mandatory.gif' id='user_id_img' style="visibility:hidden"></img>
	<%}
	else{
	%>
	<img src='../../eCommon/images/mandatory.gif' id='user_id_img' style="visibility"></img>
	<%}
		%>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="user_name" id="user_name" value="<%=user_name%>"  size=30 maxlength=30 readonly >
	</td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="checkbox"   name="authorise" id="authorise" id='authorise'  <%=check_auth%> <%=all_User_chk%> <%=falgDis%> > 
	<!-- <%=auth_disabled%>_flagAllow we have removed this one (2/23/2009) -->
	</td>
</tr>

<tr>
	<td></td>
	<td></td>
</tr>
<tr>
   <td></td>
    <td class='fields' width='25%'>
	<input type='button' class='button' name='select' id='select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow_Select();' <%=all_User_chk%>  >
	<input type='button' class='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancelDetails();' <%=all_User_chk%> ></td>
	
</tr>



<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='p_string_val' id='p_string_val' value="<%=p_string_val%>">
<input type='hidden' name='update_modify_string' id='update_modify_string' value="<%=update_modify_string%>">
<input type='hidden' name='modify' id='modify' value="<%=modify%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='_spec_user_id' id='_spec_user_id' value="<%=_spec_user_id%>">
<input type='hidden' name='_update_mode_yn' id='_update_mode_yn' value="<%=_update_mode_yn%>">
<input type='hidden' name='_specific_ind' id='_specific_ind' value="<%=_specific_ind%>">
<%
if(!p_mode.equals("mod"))
out.println("<script>refresh()</script>");
%>

</table>
</form>
</body>

</html>

