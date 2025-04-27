<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
		<%
		  request.setCharacterEncoding("UTF-8");
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
				con=ConnectionManager.getConnection(request);
				ResultSet rs =null;
				stmt	=	con.createStatement();
    			String resp_group_id=request.getParameter("resp_group_id");
					int num=0;
					num=1;
			String sql="Select a.module_id,b.function_name from sm_func_by_resp_grp a , sm_function b where a.resp_group_id='"+resp_group_id+"'   and a.module_id=b.module_id and a.function_id=b.function_id";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null){
			while(rs.next())
			{
				num++;
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		%>
	</head>
	<body class=message onKeyDown = 'lockKey()'>
		<form>
		</form>
	</body>

</html>
	<%
	}catch(Exception e){//out.println(e);
		e.printStackTrace();
	}
			finally { 
				if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}

%>

