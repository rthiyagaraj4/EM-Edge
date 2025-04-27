<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import = "java.net.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src='../../eCommon/js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function writeLog
function writeLog()
{
	alert();
  var dir=this.document.forms[0].dir_name.value;
  var logtext=this.document.forms[0].PROCEDUREPARAMETER.value;
  var fileobject = new ActiveXObject("Scripting.FileSystemObject");
  var fileS =dir+"prolog.txt";
  alert(fileS);
  var create = fileobject.OpenTextFile(fileS, 8, true);
  alert(create);
  create.Write(logtext);
  alert();
  create.Close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con = null;
con =  ConnectionManager.getConnection(request);
String curr_user_id=(String)session.getValue("login_user");
String hostname1=InetAddress.getLocalHost().getHostName();	
String comm_client=hostname1.toUpperCase();
String dir_name="c:\\ehis\\reports\\";
CallableStatement ostmt = null; 
try{
    
        ostmt =con.prepareCall("{ call appprint.get_report_output_directory(?,?,?,?) }" ); 
		ostmt.setString(1,curr_user_id);
		ostmt.setString(2,comm_client);
		ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);

		ostmt.execute(); 
		dir_name =ostmt.getString(3);
		ostmt.close();
	
    }catch(Exception e ){System.out.println(" exception review comm process ");e.printStackTrace(System.err);}
	finally{
			try{
						
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e.toString());
				}
	       }
%>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="procedure_footer_form" id="procedure_footer_form">
<input type=hidden name=dir_name value='<%=dir_name%>'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
		<td class=label ><fmt:message key="eXH.ProcedureParameters.Label" bundle="${xh_labels}"/></td><td></td>
</tr>
<tr>
	<td colspan=2 align=center class='fields'><textarea rows=3 cols=100   id="PROCEDUREPARAMETER"name="PROCEDUREPARAMETER"><%=request.getParameter("PROCEDUREPARAMETER").equals("null")?"":request.getParameter("PROCEDUREPARAMETER")%>
   </textarea></td></tr>
<tr>
	<td></td>
	<td class='BUTTON'><input  class='BUTTON' type="button"  name=writelog value='<fmt:message key="Common.WriteLog.label" bundle="${common_labels}"/>' onClick="writeLog();"></td>
</tr>
<tr>
<td></td>
<td></td>
</tr>
</table>
</form>
</body>
</html>

