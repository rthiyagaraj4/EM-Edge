<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<script>
function Closewin()
                {
                        parent.window.returnValue = "FALSE";
                        parent.window.close();
                }
</script>

	<head>
		<%
		  request.setCharacterEncoding("UTF-8");
		  request= new XSSRequestWrapper(request);
		  response.addHeader("X-XSS-Protection", "1; mode=block");
		  response.addHeader("X-Content-Type-Options", "nosniff");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
    
		<%
			Connection con=null;
			Statement stmt_resp = null;
			try{
			con = ConnectionManager.getConnection(request);
		    String function_name = request.getParameter("function_name");;
		    String access = request.getParameter("access");
		    String resp_id = request.getParameter("resp_id");
			String menu_id = request.getParameter("menu_id");
			String function_id = request.getParameter("function_id");
			String sql = "select insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1 FROM SM_MENU_RSTRN_RESP WHERE RESP_ID ='"+resp_id+"' AND MENU_ID  = '"+menu_id+"' AND FUNCTION_ID = '"+function_id+"'";
				stmt_resp=con.createStatement();

				ResultSet rs_resp=stmt_resp.executeQuery(sql);
				if(rs_resp!=null)
				  {
				  while(rs_resp.next())
					{
						access =rs_resp.getString(1);
				    }
				  }
				  if(rs_resp!=null)rs_resp.close();
				  if(stmt_resp!=null)stmt_resp.close();
				  String yes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
				  String no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

			String insert_allowed=yes;
			String update_allowed=yes;
			String delete_allowed=yes;
			String query_allowed =yes;
			String print_allowed =yes;
            if (access.substring(0,1).equalsIgnoreCase("N"))
				insert_allowed=no;
            if (access.substring(1,2).equalsIgnoreCase("N"))
				update_allowed=no;
            if (access.substring(2,3).equalsIgnoreCase("N"))
				delete_allowed=no;
            if (access.substring(3,4).equalsIgnoreCase("N"))
			    query_allowed=no;
            if (access.substring(4,5).equalsIgnoreCase("N"))
				print_allowed=no;
			%>
        <title><fmt:message key="Common.AccessRights.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=function_name%></title>
			</head>

		<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'; class='CONTENT'>
		<form name='frame2_form' id='frame2_form'>
        <br>
			<table border=0 cellspacing=0 cellpadding=0 align=center width='80%'>
		<tr>
         <tr>
			<td width = '20%' class = 'White'>&nbsp;</td>
			<td class ='label' ><fmt:message key="eSM.InsertAllowed.label" bundle="${sm_labels}"/></td>
			<td class = 'querydata'><%=insert_allowed%></td> 
			<td width = '20%' class = 'White'>&nbsp;</td>
			</tr>
          <tr><td class='white'></td><td colspan = '2'></td><td class='white'></tr>
			<tr>
         
			<td width = '20%' class = 'White'>&nbsp;</td>
			<td class ='label'><fmt:message key="eSM.UpdateAllowed.label" bundle="${sm_labels}"/></td>
			<td class = 'querydata'><%=update_allowed%></td>
			<td width = '20%' class = 'White'>&nbsp;</td>
		</tr>
          <tr><td class='white'></td><td colspan = '2'></td><td class='white'></tr>
			<tr>
			<td width = '20%' class = 'White'>&nbsp;</td>
			<td class ='label' ><fmt:message key="eSM.DeleteAllowed.label" bundle="${sm_labels}"/></td>
			<td class = 'querydata'><%=delete_allowed%></td>
			<td width = '20%' class = 'White'>&nbsp;</td>
		</tr>
          <tr><td class='white'></td><td colspan = '2'></td><td class='white'></tr>
			<tr>
			<td width = '20%' class = 'White'>&nbsp;</td>
			<td class ='label' ><fmt:message key="eSM.QueryAllowed.label" bundle="${sm_labels}"/></td>
			<td class = 'querydata'><%=query_allowed%></td>
          <tr><td class='white'></td><td colspan = '2'></td><td class='white'></tr>
		</tr>
          <tr><td class='white'></td><td colspan = '2'></td><td class='white'></tr>
         <tr>
			<td width = '20%' class = 'White'>&nbsp;</td>
			<td class ='label' ><fmt:message key="eSM.PrintAllowed.label" bundle="${sm_labels}"/></td>
			<td class = 'querydata'><%=print_allowed%></td>
			<td width = '20%' class = 'White'>&nbsp;</td>
		</tr>
        </table>
         <br><br>
			<table align = 'center'>
		<INPUT TYPE="button" class = 'button' name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick ='Closewin()'>		
			</table>
			</form>
	</body>
<%if(stmt_resp!=null) stmt_resp.close();
}catch(Exception e){out.println(e);}
finally { 
	ConnectionManager.returnConnection(con,request);
}			
%>
</html>

