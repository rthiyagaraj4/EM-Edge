<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		    request.setCharacterEncoding("UTF-8");
			Connection con=null;
			Statement stmt = null;
			try{
			con = ConnectionManager.getConnection(request);
	
			ResultSet rs =null;
			String module_id=request.getParameter("module_id");
			String resp_group_id=request.getParameter("resp_group_id");
			String module_name="";
			String function_name=request.getParameter("function_name");
			String headeryn=request.getParameter("headeryn")==null?"":request.getParameter("headeryn");
			if(function_name==null) function_name="";
			String function_id="";
			int num=0;
			int j=1;
			String classValue = "" ;
			%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'   class='CONTENT'>
	<form name='form4' id='form4'>
		<table border=1 cellspacing=0 cellpadding=0 align=center width='100%'>
	<%	if(headeryn.equals("Y")){%>
		<th width='240px'><fmt:message key="Common.ModuleName.label" bundle="${common_labels}"/></th>
		<th  align=center width='300px'><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.Add.label" bundle="${common_labels}"/></th>
		
			<%headeryn="";}
		if(!function_name.equals(""))
		{
			num=1;
			/*String sql_count="Select count(*) from sm_function where module_id=nvl('"+module_id+"',module_id) and upper(function_name) like upper('"+function_name+"%"+"' ) and function_id not in(select function_id from sm_func_by_resp_grp where resp_group_id ='"+resp_group_id+"')   and function_type='F' order by module_id,function_name";*/
		
			stmt=con.createStatement();
			/*rs=stmt.executeQuery(sql_count);
			if(rs!=null)
			{
				while(rs.next())
				{
					i=rs.getInt(1);
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();*/
			String sql="Select a.module_id,a.function_id,a.function_name,b.module_name from sm_function a, sm_module b where a.module_id=nvl('"+module_id+"', a.module_id) and upper(a.function_name) like upper('"+function_name+"%"+"' ) and a.function_id not in(select function_id from sm_func_by_resp_grp  where resp_group_id ='"+resp_group_id+"')  and a.module_id=b.module_id  and a.function_type='F' order by a.module_id,a.function_name";

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null)
			{
				while(rs.next())
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
					<td class='<%=classValue%>' width='210px'><%=module_name%></td>
					<td class='<%=classValue%>' width='275px'><%=function_name%></td>
					<td class='<%=classValue%>' align=center width='50px'><input type=checkbox name=AC<%=num%> value='Y'>
					<input type=hidden name=AM<%=num%> value=<%=module_id%>>
					<input type=hidden name=AF<%=num%> value=<%=function_id%>>
					</tr>
					<%
					num++;
					j++;
				}
			}
		}
		else 
		{
			num=1;
			/*String sql_count="Select count(*) from sm_function where module_id=nvl('"+module_id+"',module_id) and function_id not in(select function_id from sm_func_by_resp_grp where resp_group_id ='"+resp_group_id+"')  and function_type='F' order by module_id,function_name";*/
			stmt=con.createStatement();
			/*rs=stmt.executeQuery(sql_count);
			if(rs!=null)
			{
				while(rs.next())
				{
					i=rs.getInt(1);
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();*/
		
			String sql="Select a.module_id,a.function_id,a.function_name, b.module_name from sm_function a,  sm_module b where a.module_id=nvl('"+module_id+"',a.module_id) and a.function_id not in(select function_id from sm_func_by_resp_grp where resp_group_id ='"+resp_group_id+"') and a.module_id=b.module_id and a.function_type='F' order by a.module_id,a.function_name";

			stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs!=null)
		{
			while(rs.next())
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
				<td class='<%=classValue%>' width='240px'><%=module_name%></td>
				<td class='<%=classValue%>' width='300px'><%=function_name%></td>
				<td class='<%=classValue%>' align=center ><input type=checkbox name=AC<%=num%> value='Y'>
				<input type=hidden name=AM<%=num%> value=<%=module_id%>>
				<input type=hidden name=AF<%=num%> value=<%=function_id%>>
				</tr>
				<%
				num++;
				j++;
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		}
		if(rs!=null)rs.close();
		if(stmt != null) stmt.close();
		%>
		</table>
		</form>
	</body>
</html>

<%
	
	}catch(Exception e){out.println(e);}
			finally {				
						ConnectionManager.returnConnection(con,request);
				}	
%>

