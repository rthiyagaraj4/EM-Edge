<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String sql = "";
	String age_group_appl_yn = "";
	String sensitivity_appl_yn = "";
	String term_set_desc = "";
	String notification_appl_yn = "";
	String defn_levels = "";
	String dfltSearchYn = "N";
	
	try
	{
		con=ConnectionManager.getConnection(request);
		
		String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	
		sql = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN ,DEFN_LEVELS,(select DFLT_TAB_IN_DIAG_SEL from mr_parameter) DFLT_TAB_IN_DIAG_SEL from mr_term_set where TERM_SET_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,term_set_id);
		rs = pstmt.executeQuery();

		
		while(rs.next())
		{
			age_group_appl_yn = rs.getString("AGE_GROUP_APPL_YN");
			sensitivity_appl_yn = rs.getString("SENSITIVITY_APPL_YN");
			term_set_desc = rs.getString("TERM_SET_DESC");
			notification_appl_yn = rs.getString("NOTIFICATION_APPL_YN");
			defn_levels = rs.getString("DEFN_LEVELS");
			dfltSearchYn = rs.getString("DFLT_TAB_IN_DIAG_SEL");
			
		}
	}
	catch(Exception e){
		 e.printStackTrace();
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	}


%>
<title><%=term_set_desc%></title>
</head>
<%
	String queryString=request.getQueryString();
		//out.println("<script>alert(\"option_id 1888 :"+queryString+"\");</script>");			


	
%>
	<!-- <frameset rows='4%,*,10%' id='TermCodeSearchMain' name='TermCodeSearchMain'> -->
		<iframe name='TermCodeSearchMainFrame' id='TermCodeSearchMainFrame' src="TermCodeSearchMain.jsp?<%=queryString%>&term_set_desc=<%=term_set_desc%>&sensitivity_appl_yn=<%=sensitivity_appl_yn%>&age_group_appl_yn=<%=age_group_appl_yn%>&notification_appl_yn=<%=notification_appl_yn%>&defn_levels=<%=defn_levels%>&dfltSearchYn=<%=dfltSearchYn%>" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=no style="height:4vh;width:99vw"></iframe>
		<!-- 
			Commented On 10/20/2009.
			F.Y.I:1.Old code.
		-->
		<!-- <frame name='TermCodeSearchByFrame' id='TermCodeSearchByFrame' src="TermCodeSearchByCL.jsp?<%=queryString%>&term_set_desc=<%=term_set_desc%>&sensitivity_appl_yn=<%=sensitivity_appl_yn%>&age_group_appl_yn=<%=age_group_appl_yn%>&notification_appl_yn=<%=notification_appl_yn%>&defn_levels=<%=defn_levels%>" noresize  scrolling=no  frameborder=no  marginheight=0 marginwidth=0> -->

		<iframe name='TermCodeSearchByFrame' id='TermCodeSearchByFrame' src='../../eCommon/html/blank.html'  noresize  frameborder="no" scrolling="no"  marginheight="0" marginwidth="0" style="height:88vh;width:99vw"></iframe>
		
		<iframe name='TermCodeSearchToolbarFrame' id='TermCodeSearchToolbarFrame' src='TermCodeSearchToolbar.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style="height:10vh;width:99vw"></iframe>
	
</html>

