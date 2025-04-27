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
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs   = null;
	String sql_query = "", hist_rec_type = "", short_desc = "";
	try
	{
		con = ConnectionManager.getConnection(request);
		sql_query="select hist_rec_type, short_desc from cr_hist_rec_type order by 2";
		stmt = con.prepareStatement(sql_query);
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type	= rs.getString("hist_rec_type");
			short_desc		= rs.getString("short_desc");
			if((hist_rec_type == null) || hist_rec_type.equals("null"))hist_rec_type="";
			if((short_desc == null) || short_desc.equals("null"))short_desc="";
			%>
			<script>
			var element = parent.frames[1].document.createElement('OPTION');
			element.text = '<%=short_desc%>';
			element.value= '<%=hist_rec_type%>';
			parent.frames[1].document.forms[0].result_linked_rec_type.add(element);
			</script>
			<%
	
		}
		%>
		<script>top.content.frames[4].location.href = '../../eCommon/jsp/MstCodeError.jsp';</script><%
		
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();	
	}
	catch(Exception e)
	{
		//out.println("Exception in main try"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con, request);
	}
	
%>
	<script>
</script>
<body class=message  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>

