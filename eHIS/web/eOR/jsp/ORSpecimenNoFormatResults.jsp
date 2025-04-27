<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	Connection con=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eOR/js/ORSpecimenFmt.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="SpecFmtResults" id="SpecFmtResults">
	<%try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT SPEC_NO_FRMT_CODE, DESCRIPTION, SPEC_NO_FORMAT FROM OR_SPECIMEN_NO_FORMAT ORDER BY DESCRIPTION";
			int i =1;
			stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
		%>
		<br/>
	<table class='grid' width="90%" align="center">		
	<tr>
	<td width="10%" class="gridHeader">Sno</td>
	<td width="30%" class="gridHeader"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td width="60%" class="gridHeader"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	</tr>
	<%
			while(rs.next())
			{%>
				<tr>
					<td width="10%" class="gridData"><a class="gridLink" href="javaScript:loadSpecimenFormat('<%=rs.getString("SPEC_NO_FRMT_CODE")%>','<%=java.net.URLEncoder.encode(rs.getString("DESCRIPTION"))%>','<%=rs.getString("SPEC_NO_FORMAT")%>','M')"><%=i%></td>					
					<td width="30%" class="gridData"><%=rs.getString("SPEC_NO_FRMT_CODE")%></td>									
					<td width="60%" class="gridData"><%=rs.getString("DESCRIPTION")%></td>					
				</tr>
	<%	i++;}
	%>	
	</table> 
	<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con);
	}%>
</form>
</body>
</html>

