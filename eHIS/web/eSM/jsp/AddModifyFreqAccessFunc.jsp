<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eSM/js/FreqAccessFunc.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	Connection conn = null;
	try{
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;

	Statement stmt = conn.createStatement();
	 int count=0;
	String Log_user= (String) session.getValue("login_user");
	String responsibility_id= (String) session.getValue("responsibility_id");
	int i=0;
	
	String menu=request.getParameter("menu");
	String menu_id=request.getParameter("menu_id");
	String resp_name="";

	menu_id=menu_id.trim();
	
	String sql_resp=" Select resp_name from sm_resp where resp_id='"+responsibility_id+"'";
	rs = stmt.executeQuery(sql_resp);
	if(rs!=null)
	{
		while(rs.next())
		{
			resp_name=rs.getString(1);
		}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	}
try{
		String sql="select a.APPL_USER_ID,RESP_ID ,a.FREQ_FUNC_SRL_NO  ,b.function_name from sm_freq_func_by_user a,sm_function b where a.module_id=b.module_id and a.function_id=b.function_id  and a.appl_user_id='"+Log_user+"' and a.Resp_id='"+responsibility_id+"'  order by freq_func_srl_no";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	}
catch (Exception ce) 
{
	out.println("Here "+ce);
}
try
{
%>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='delete_func' id='delete_func' method=post ACTION='../../servlet/eSM.FreqAccessFuncServlet' target='messageFrame'   >
<table border="0" align='center' width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<td>&nbsp;</td>
		<td width='10%' class=label><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td width='30%'><input type='text' name='resp' id='resp' size='30' maxlength='60' value='<%=resp_name%>' readonly></td>
		 <td width='10%' class=label><fmt:message key="Common.menu.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td width='30%'><input type='text' name='menu' id='menu' size='30' maxlength='60' value='<%=menu%>' readonly></td>
		<td>&nbsp;</td>
	</tr>
</table>
<table border="1" align='center' width="100%" cellspacing='0' cellpadding='0'>
<th align=left width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
<th align=left width='40%' align=center>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Remove.label" bundle="${common_labels}"/></th>
<%
	   String classValue = "" ; 
		while ( rs.next()  )  
		{
			if ( i % 2 == 0 )
	 	  	classValue = "QRYODD" ;
	 		 else
	 	  	classValue = "QRYEVEN" ;

			String id = rs.getString("APPL_USER_ID"); 
			int freq_func_srl_no = rs.getInt("FREQ_FUNC_SRL_NO"); 

			out.println("<tr width='100%'><td width='60%' class='"+classValue+"'>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("function_name")+"</td><td width='20%'  class='"+classValue+"'>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name=Incchkbox_val id=Incchkbox_val value='"+id+"|"+freq_func_srl_no+"' ");
			out.println("</td></tr>");
			i++;
			count++;
		}
		if ( rs != null ) rs.close() ;
		if ( stmt != null ) stmt.close() ;
%>
</table>
<input type='hidden' name='nochbox1' id='nochbox1' value='<%=count%>'>
<input type='hidden' name='checkval1' id='checkval1'  >
<input type='hidden' name='checkval' id='checkval'  >
<input type='hidden' name='operationDelete' id='operationDelete' value="delete">
<input type='hidden' name='operation' id='operation' >
<input type='hidden' name='Log_user' id='Log_user' value='<%=Log_user%>'>
<input type='hidden' name='responsibility_id' id='responsibility_id' value='<%=responsibility_id%>'>
<input type='hidden' name='menu_id' id='menu_id' value='<%=menu_id%>'>
<%
}
catch ( Exception e ){ out.println("Exception "+e);}
finally
{
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
}

}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>

