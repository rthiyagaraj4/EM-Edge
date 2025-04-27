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
			con = ConnectionManager.getConnection(request);
			ResultSet rs =null;
			String long_desc="";
			String proc_srt_cmd="";
			String proc_id=request.getParameter("proc_id");
			
			String sql="select long_desc, proc_srt_cmd  from sm_proc_id where controllable_yn='Y' and proc_id='"+proc_id+"'";
	
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null)
			{
				while(rs.next())
				{
					long_desc=rs.getString("long_desc");
					proc_srt_cmd=rs.getString("proc_srt_cmd");
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		
%>
<script>
			var long_desc="<%=long_desc%>";
			var proc_srt_cmd="<%=proc_srt_cmd%>";
			parent.frames[1].frames[2].document.forms[0].proc_name.disabled=false;
			parent.frames[1].frames[2].document.forms[0].proc_name.value='<%=long_desc%>';
			parent.frames[1].frames[2].document.forms[0].proc_srt_cmd.value='<%=proc_srt_cmd%>';
			parent.frames[1].frames[2].document.forms[0].Submit.disabled=false;
	</script>
	</head>
<body class=message onKeyDown = 'lockKey()'>
		<form name='dummyform' id='dummyform'>
		</form>
	</body>
<%
	if(stmt!=null) stmt.close();
	
	}catch(Exception e){out.println(e);}
	finally { 
	
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

