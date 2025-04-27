<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<%request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%

			Connection con=null;
			Statement stmt = null;
			try{
			con = ConnectionManager.getConnection(request);

			
			ResultSet rs =null;
			
			stmt	=	con.createStatement();
			String resp_group_id=request.getParameter("resp_group_id");
			String headeryn=request.getParameter("headeryn")==null?"":request.getParameter("headeryn");
			String module_id="";
			String module_name="";
			String function_name="";
			String function_id="";
			int num=0;
			int i=0;
			int j=1;
			String classValue = "" ;
		%>
	</head>
	<body  class='CONTENT' onKeyDown = 'lockKey()';  OnMouseDown='CodeArrest()'>
	<form name='form2' id='form2'>
		
		<table border=1 cellspacing=0 cellpadding=0 align=center width='100%'>
		<%if(headeryn.equals("Y")){%>
		<th WIDTH='240px' ><fmt:message key="Common.ModuleName.label" bundle="${common_labels}"/></th>
		<th  width='300px'align=center><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.Remove.label" bundle="${common_labels}"/></th>
		<%}else
				{%>
			<b><fmt:message key="eSM.CurrentFunctions.label" bundle="${sm_labels}"/></b>
				<%}
		
		num=1;
		
		String sql_count="Select count(*) from sm_func_by_resp_grp    where resp_group_id='"+resp_group_id+"'";
		rs=stmt.executeQuery(sql_count);
		if(rs!=null)
		{
			while(rs.next())
			{
				i=rs.getInt(1);
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();%>
		
		<%String sql="Select a.module_id,b.function_name,b.function_id,c.module_name  from sm_func_by_resp_grp a , sm_function b, sm_module c where a.resp_group_id='"+resp_group_id+"'   and a.module_id=b.module_id and a.function_id=b.function_id and a.module_id=c.module_id order by module_id,function_name";

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
		if(rs!=null)
		{
			while(rs.next() &&  j<=i )
			{
				if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
			
				module_id=rs.getString("module_id");
				module_name=rs.getString("module_name");
				function_name=rs.getString("function_name");
				function_id=rs.getString("function_id");
				%>
				
				<tr>
				<td align=left class='<%=classValue%>' width='240px'><%=module_name%></td>
				<td align=left class='<%=classValue%>' width='300px'><%=function_name%></td>
				<td align=center class='<%=classValue%>'><input id=RC<%=num%>  type=checkbox name=RC<%=num%> value='Y'>
				<input id=RM<%=num%>  type=hidden name=RM<%=num%> value='<%=module_id%>'>
				<input id=RF<%=num%>  type=hidden name=RF<%=num%> value='<%=function_id%>'>
				</tr>
				<%
				num++;
				j++;
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		%>
		<input type=hidden name='resp_group_id' id='resp_group_id' value='<%=resp_group_id%>'>
		</table>
		</form>
	</body>
</html>
<%
if(stmt!=null)stmt.close();
}catch(Exception e){out.println(e);}
			finally {
						ConnectionManager.returnConnection(con,request);
					}			
%>

