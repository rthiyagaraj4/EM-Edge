<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try
		{
			con=ConnectionManager.getConnection(request);
			//String sql="select  CALC_ID, EXECUTABLE_NAME, CALC_DESC from  ca_clinical_calc";

			String sql = "select  CALC_ID, EXECUTABLE_NAME, CALC_DESC from  ca_clinical_calc_lang_vw WHERE LANGUAGE_ID = ? ORDER BY CALC_DESC ";			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			rset = pstmt.executeQuery();
	
%>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table width='100%' height='100%' border='0' cellspacing='0' cellpadding='3' align='center'>
	<tr></tr>
		<tr>
			<td class=label width='25%'><fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/>
			<select name='CACalc' id='CACalc' onChange='calculateResult(this)'>
				<option value=''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> <fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/> ---------</option>
<%
		while(rset.next())
		{
			out.println("<option name='"+rset.getString("CALC_ID")+"'  value='"+rset.getString("EXECUTABLE_NAME")+"'>"+rset.getString("CALC_DESC")+"</option>");
		}
%>
			</select>
			</td>
		</tr>
	<tr></tr>
	</table>
</body>
</html>
		<%
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
		{
				//out.println("Exception in CACalcultorSelect.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

	%>

