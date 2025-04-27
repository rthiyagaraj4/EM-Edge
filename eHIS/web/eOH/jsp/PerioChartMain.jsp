<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String ca_params = request.getQueryString();
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String chart_type_for_alert = checkForNull(request.getParameter("chart_type_for_alert"));//Added by Sridevi Joshi on 4/27/2010 for PE ...the qry for this value was getting executed in all frames mentioned in OH.jsp
	
	try{
		con=ConnectionManager.getConnection(request);
		
%>
<html>
<head>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="PerioChartMainForm" id="PerioChartMainForm" >
		
		<input type = "hidden" name= "ca_params" value = "<%=ca_params%>">
		<input type = "hidden" name= "chart_type_for_alert" value = "<%=chart_type_for_alert%>">
		<input type = "hidden" name= "main_chart_num" value = "">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
			
				
	</form>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

