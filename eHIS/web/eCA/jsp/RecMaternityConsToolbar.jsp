<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String modevalue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
			String p_max_ges_val = "";
			String p_min_ges_val = "";
			String p_ges_unit = ""; 
			 Connection con 		= null;
			 PreparedStatement pstmt 	= null;
			 ResultSet rs 		= null;
			 try {
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement("SELECT  NVL(UNIT_OF_GEST_NB,'D'),NVL(max_gestation,0),NVL(min_gestation,0) FROM MP_PARAM");
					rs = pstmt.executeQuery();
					while(rs.next()){
						p_max_ges_val = rs.getString(2);
						p_min_ges_val = rs.getString(3);
						p_ges_unit = rs.getString(1);
					}
					if(rs != null)rs.close();
					if(pstmt != null)pstmt.close();
					
			 }finally{				 
				 if(con != null) ConnectionManager.returnConnection(con,request);		 
			 }

		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/RecMaternityCons.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<center>
			<form name='RecMaternityConsToolbarForm' id='RecMaternityConsToolbarForm' action='../servlet/eCA.RecMatConsServlet'>
				<table border='0' cellpadding='3' cellspacing='0' width='100%' align='right'>
					<tr>
					<td align='right' width='100%'>
					<% if (modevalue.equals("V")){ %>
					<input type="button" class="BUTTON" name="close" id="close" onclick='return closep()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'>
					<%}
					else if(modevalue.equals("D")||modevalue.equals("T"))
					{
					%>
					<input type="button" class="BUTTON" name="Save" id="Save" onclick="recordF('N')" value='Save'>
					<input type="button" class="BUTTON" name="Record" id="Record" onclick="recordF('Y')" value='Finalize'>
					<%
					}
					else {%>
					<input type="button" class="BUTTON" name="Record" id="Record" onclick='record()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'>
					<%}%>
					</td></tr>
				</table>
				<input type="hidden" name="p_max_ges_val" id="p_max_ges_val" value="<%=p_max_ges_val%>">
				<input type="hidden" name="p_min_ges_val" id="p_min_ges_val" value="<%=p_min_ges_val%>">
				<input type="hidden" name="p_ges_unit" id="p_ges_unit" value="<%=p_ges_unit%>">
			</form>
		</center>
	</body>
</html>

