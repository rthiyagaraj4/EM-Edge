<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));
locale = "en"; %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>										    
  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>							  
<Script Language="JavaScript" src="../../eXH/js/AuthorizedUser.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD> 

<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
String mode=request.getParameter("mode");
String login_id="";
String view_yn="";
String replay_yn=""; 
String rebuild_yn="";
String user_id = "";

String reload_yn = "";
String debug_yn = "";
String audit_yn = "";
String comm_exc_yn = "";
String write_to_excel = "";
String notification = "";

String help="";
if(mode.equals("U"))
{
	login_id=request.getParameter("login_name");
	view_yn=request.getParameter("view_yn");
	replay_yn=request.getParameter("replay_yn");
	rebuild_yn=request.getParameter("rebuild_yn");

	reload_yn=request.getParameter("reload_yn");
	debug_yn=request.getParameter("debug_yn");
	audit_yn=request.getParameter("audit_yn");
	comm_exc_yn=request.getParameter("comm_exc_yn");
	write_to_excel=request.getParameter("write_to_excel");
	notification=request.getParameter("notification");
	help=request.getParameter("help"); 
} 
	user_id=request.getParameter("usr_name");


//Connection con=null;
%>
<form name="Master_authorised_user_form" id="Master_authorised_user_form" target='messageFrame' method='post' action='../../servlet/eXH.AuthorizedUsersAddModifyServlet'>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<!--	<td width='30%'></td>
	<td width='70%'></td> -->
	<td width='25%'></td>
	<td width='30%'></td>
	<td width='25%'></td>
	<td width='50%'></td> 
</tr>
<tr>
<td class=label ><fmt:message key="Common.login.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
<td class='fields' style='display:flex'>
 <input type='text' name='login_name' id='login_name' size=25 value='<%=login_id.equals("")?"":login_id%>' onBlur='GetLookup(login_name)'>
 <input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(login_name)'>
 <img src='../../eCommon/images/mandatory.gif' align=middle style='height:10px'>
 <input type=hidden id="user_id"  name ='user_id' value='<%=XHDBAdapter.checkNull(user_id)%>' ></td>	
 <td colspan=2> </td>
 </tr>

<tr>
<td class=label ><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=checkbox name =view_yn <%=view_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=view_yn.equals("Y")?"Y":"N"%>'></td>

<td class=label ><fmt:message key="eXH.Replay.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =replay_yn <%=replay_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=replay_yn.equals("Y")?"Y":"N"%>'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.Rebuild.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =rebuild_yn <%=rebuild_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=rebuild_yn.equals("Y")?"Y":"N"%>'></td>

 <td class=label ><fmt:message key="eXH.Reload.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =reload_yn <%=reload_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=reload_yn.equals("Y")?"Y":"N"%>'></td>
</tr>

<tr>
<%---<td class=label >Debug</td>
<td class='fields'><input type=checkbox name =debug_yn <%=debug_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=debug_yn.equals("Y")?"Y":"N"%>'></td>--%> 

<td class=label ><fmt:message key="eXH.Audit.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =audit_yn <%=audit_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=audit_yn.equals("Y")?"Y":"N"%>'></td>
<td class=label ><fmt:message key="Common.Review.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=checkbox name =comm_exc_yn <%=comm_exc_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=comm_exc_yn.equals("Y")?"Y":"N"%>'></td>

</tr>

<tr>


<td class=label ><fmt:message key="eXH.WriteToXls.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =write_to_excel <%=write_to_excel.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=write_to_excel.equals("Y")?"Y":"N"%>'></td>
<td class=label ><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =help <%=help.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=help.equals("Y")?"Y":"N"%>'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.NOTIFICATION.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name =help <%=help.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=help.equals("Y")?"Y":"N"%>'></td>
</tr>



<tr>
	<td width='25%'></td>
	<td width='30%'></td>
	<td width='25%'></td>
	<td width='50%'></td>
</tr>
</table>
<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=collected_string value=''>
<input type=hidden name='update_mode_login' id='update_mode_login' value=<%=login_id%>>
<input type=hidden name='locale' id='locale' value='<%=locale%>'>
<input type=hidden name=mode value='I'>
</body>
</form>
</html>	
	

