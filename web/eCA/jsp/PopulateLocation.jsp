<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<%
	String  locn_type= (request.getParameter("locn_type")==null?"":request.getParameter("locn_type"));
	
	String facility_id=(String) session.getValue("facility_id");

	String	sql=" Select locn_code, short_desc from ca_locn_vw  where facility_id=? and locn_type=? order by 2 ";
	String id="";
	String dat="";
	
	
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sql);
		stmt.setString(1, facility_id);
		stmt.setString(2, locn_type);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				id=rs.getString(1);
				dat=rs.getString(2);
%>
	<script>
	var id="<%=id%>";
	var dat="<%=dat%>";
	var opt=parent.document.frames[1].frames[1].document.createElement("OPTION");
	opt.text=dat;
	opt.value=id;
    parent.document.frames[1].frames[1].document.forms[0].locn_code.add(opt);
	</script>
<%
			}
		}
	}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
		}		
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

<body class=message  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>

