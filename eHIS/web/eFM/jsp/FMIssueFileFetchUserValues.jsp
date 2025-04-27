<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();' class='message'>
<%
	Connection conn				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	
	int x = 0;

	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");	
	String selFacility	= request.getParameter("Facility");

	if((selFacility == null) || (selFacility.equals("null"))) selFacility = "";
	
	try
	{
		String moreCriteria = "";
		String sql			= "";
	//	String Code			= "";
	//	String Desc			= "";

		if(facility_id.equals(selFacility))
			moreCriteria = " AND APPL_USER_ID != '"+user_id+"' ";
		
		stmt = conn.createStatement();
		sql = "Select APPL_USER_ID, SUBSTR(APPL_USER_NAME,1,30) APPL_USER_NAME from SM_FACILITY_FOR_USER_VW  where FACILITY_ID ='"+selFacility+"' "+moreCriteria+" order by 2";
		
		rs = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
	//		Code = rs.getString("APPL_USER_ID");
	//		Desc = rs.getString("APPL_USER_NAME");
			x++;
		}
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}catch(Exception e) {out.println("Main :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

