<!DOCTYPE html>
 <%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	 <%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
	
	<script src="../../eCA/js/FlowSheetComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String sql="";
	String chart_id = "";
	String l_desc="",s_desc="";

	chart_id=request.getParameter("chart_id")==null ? "" :request.getParameter("chart_id");
	
	con=ConnectionManager.getConnection(request);
	//sql = "select substr(long_desc,0,30) long_desc,substr(short_desc,0,20) short_desc from ca_chart where chart_id=?";
	sql = "select substr(long_desc,0,30) long_desc,substr(short_desc,0,20) short_desc from ca_chart_LANG_VW where chart_id=? AND LANGUAGE_ID = ?";
	try{
		stmt=con.prepareStatement(sql);
		stmt.setString(1,chart_id);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();

		while(rs.next())
		{
			l_desc = rs.getString("long_desc");
			s_desc = rs.getString("short_desc");
			
		}
		%>
	<script>
		parent.frames[1].document.FlowSheetComp.short_desc.value= "<%=s_desc%>";
		parent.frames[1].document.FlowSheetComp.long_desc.value="<%=l_desc%>"; 
	</script>

	<%	if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		

		if(s_desc==null) s_desc="";
		if(l_desc==null) l_desc="";
		} catch(Exception e){ 
			//out.println("Exception in FlowSheetComponent="+e.getMessage());//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}

	
	%>
</html>


