<!DOCTYPE html>
<HTML>  
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE")); 
 %>
<HEAD>  
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>					  
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<Script Language="JavaScript" src="../../eXH/js/AuthorizedUser.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Script>
function chkSelectFlag(obj){
//	alert("obj.value : "+obj.value);
	select_val = document.forms[0].select_flag.value;
//	alert("select_val : "+select_val);
    if(obj.value=='Y'){
		document.forms[0].select_flag.value = 'Y';
	}
	else if(select_val!='Y'){
		document.forms[0].select_flag.value = 'N';
	}
}
</Script>
<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
int i=0;
String   classValue="";
String   login_name="";
String	view_yn="";
String	replay_yn="";
String	rebuild_yn="";
String	usr_name="";

String   reload_yn = "";
String   debug_yn = "";
String   audit_yn = "";
String   comm_exc_yn = "";
String   write_to_excel = "";
String notification_yn="";
String help=""; 

String mode=request.getParameter("mode");
String user_id=XHDBAdapter.checkNull(request.getParameter("user_id"));
//	System.out.println("user_id : "+user_id);
String user_name=XHDBAdapter.checkNull(request.getParameter("login_name"));	
//	System.out.println("user_name : "+user_name);
%>
<form name="AuthorisedUsers_Result" id="AuthorisedUsers_Result" target='' method='post' action=''>
<!-- <input type="hidden" name="mode" id="mode" value='<%=mode%>'/>-->
<input type="hidden" name="mode" id="mode" value=''/>
<input type="hidden" name="login_name" id="login_name" />
<input type="hidden" name="view_yn" id="view_yn" />
<input type="hidden" name="replay_yn" id="replay_yn" />
<input type="hidden" name="usr_name" id="usr_name" />
<input type="hidden" name="rebuild_yn" id="rebuild_yn" />
<input type="hidden" name="usr_name" id="usr_name" />
<input type="hidden" name="select_flag" id="select_flag" value = 'Y' />
<input type="hidden" name="notification_yn" id="notification_yn" />
 <br>
<%

try{
		con=ConnectionManager.getConnection();
	//	System.out.println(locale+","+user_id+","+user_name);
		String sql="select  b.APPL_USER_NAME,b.APPL_USER_ID,VIEW_YN,REPLAY_YN,EDIT_YN,REBUILD_YN,RELOAD_YN,DEBUG_YN,AUDIT_YN,COMM_EXCEPTION_YN,WRITE_TO_EXCEL,ELEMENT_DESC_YN,ALLOW_NOTIFICATION_YN from xh_authorized_user a, sm_appl_user_lang_vw b where b.LANGUAGE_ID='"+locale+"' AND b.appl_user_id = a.LOGIN_NAME AND UPPER(B.APPL_USER_ID) LIKE UPPER('"+user_id+"%') AND  UPPER(B.APPL_USER_NAME) LIKE UPPER('"+user_name+"%')  order by 1 ";

		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.last(); 
		if(rs.getRow()==0)
	    { %>
		<script>
		this.document.forms[0].mode.value='E';
		alert(getMessage("XH1021","XH"));history.go(-1);
		</script>
		<%}
		else{
		
		rs.beforeFirst();
	   %>
		<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.login.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'  width='5%'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.Replay.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.Rebuild.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.Reload.Label" bundle="${xh_labels}"/></td>
<!--<td class='COLUMNHEADER' width='5%'>Debug</td>--->
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.Audit.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Review.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.WriteToXls.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.NOTIFICATION.Label" bundle="${xh_labels}"/></td>


<!---<td class='COLUMNHEADER' width='5%'>Select</td>--->

   	 <%
  
		while(rs.next()) 
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			usr_name=rs.getString(1);
			login_name=rs.getString(2);
			view_yn=XHDBAdapter.checkNull(rs.getString(3));
			replay_yn=XHDBAdapter.checkNull(rs.getString(4));
			rebuild_yn=XHDBAdapter.checkNull(rs.getString(6));

			reload_yn=XHDBAdapter.checkNull(rs.getString(7));
			debug_yn=XHDBAdapter.checkNull(rs.getString(8));
			audit_yn=XHDBAdapter.checkNull(rs.getString(9));
			comm_exc_yn=XHDBAdapter.checkNull(rs.getString(10));
			write_to_excel=XHDBAdapter.checkNull(rs.getString(11));
			help=XHDBAdapter.checkNull(rs.getString(12));
			notification_yn=XHDBAdapter.checkNull(rs.getString(13));	
				
			%>
			<tr>
		<!--	<td class='<%=classValue%>' align=left >
			<a id="link" href='#' onClick='funShow(this)' usr_name='<%=usr_name+""%>' login_name='<%=login_name+""%>'
				view_yn='<%=view_yn+""%>' replay_yn='<%=replay_yn+""%>'  rebuild_yn='<%=rebuild_yn+""%>'>
			<%=usr_name%>
			</a> 
			</b> 
			</td> -->
			<td class='<%=classValue%>' align=left ><%=usr_name%></td>	
			</td>
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_view_yn' id='<%=login_name%>_view_yn' <%=view_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=view_yn.equals("Y")?"Y":"N"%>' ></td>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_replay_yn' id='<%=login_name%>_replay_yn' <%=replay_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=replay_yn.equals("Y")?"Y":"N"%>' ></td>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_rebuild_yn' id='<%=login_name%>_rebuild_yn' <%=rebuild_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=rebuild_yn.equals("Y")?"Y":"N"%>'  ></td>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_reload_yn' id='<%=login_name%>_reload_yn' <%=reload_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=reload_yn.equals("Y")?"Y":"N"%>'  ></td>	

			<%---<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_debug_yn' id='<%=login_name%>_debug_yn' <%=debug_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=debug_yn.equals("Y")?"Y":"N"%>'  ></td>--%>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_audit_yn' id='<%=login_name%>_audit_yn' <%=audit_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=audit_yn.equals("Y")?"Y":"N"%>'  ></td>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_comm_exc_yn' id='<%=login_name%>_comm_exc_yn' <%=comm_exc_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=comm_exc_yn.equals("Y")?"Y":"N"%>'  ></td>	

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_write_to_excel' id='<%=login_name%>_write_to_excel' <%=write_to_excel.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=write_to_excel.equals("Y")?"Y":"N"%>'  ></td>	
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_help' id='<%=login_name%>_help' <%=help.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=help.equals("Y")?"Y":"N"%>'  ></td>	
 
 	
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_notification_yn' id='<%=login_name%>_notification_yn' <%=notification_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=notification_yn.equals("Y")?"Y":"N"%>'  ></td>
			
		<%---	<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=login_name%>_action' id='<%=login_name%>_action'
			 onClick='validatecheckbox1(this);chkSelectFlag(this);' value='return validatecheckbox1(this);'></td>	---%>
			</tr>
			<%
				i++;

		}
		}
}catch(Exception e1)
{
		System.out.println("(AuthorizedUserQueryResult.jsp:Error) :  "+e1.toString());
}
finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(AuthorizedUserQueryResult.jsp:Error) : "+e);
				}
			}
		
%>
</table>
</form>
</body>
</html>

