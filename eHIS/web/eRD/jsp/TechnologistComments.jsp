<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/
%>
<%@page import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eAE.resources.*,eCA.resources.*,eCA.*,eRD.* ,eRD.Common.*,webbeans.eCommon.*, eCommon.Common.*,java.util.*,java.lang.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Technical Comments</title>
<script language="javascript" src="../js/RadiologyExam.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
	String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
	String orderid = checkForNull(request.getParameter("orderid"));
	String order_line_num = checkForNull(request.getParameter("order_line_num"));
	String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
	String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
	String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
	String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
	String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
	
	Connection con = ConnectionManager.getConnection();
	String comment="";
	try
	{
		PreparedStatement pstmt1 = null;
		//Statement stmt				= null;
		ResultSet rs1 = null;
		String Commenttype1="T";
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("orderid--"+orderid);
			System.err.println(order_line_num);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt1=con.prepareStatement("select RD_RESULT.GET_COMMENTS(?,?,?,?,?,?,?) from dual");			
				
				pstmt1.setString(1,P_FACILITY_ID);
				pstmt1.setString(2,orderid);
				pstmt1.setString(3,order_line_num);
				pstmt1.setString(4,P_REQUEST_NUM);
				pstmt1.setString(5,P_REQUEST_LINE_NUM);
				pstmt1.setString(6,P_LANGUAGE_ID);
				pstmt1.setString(7,Commenttype1);
				
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					comment =checkForNull(rs1.getString(1));
					System.err.println("comment--"+comment);
				}
				

	}catch(Exception e)
		{
			System.out.println("Exception while executing Tech comment :"+e);
		}
	System.err.println("technical Clinical Comments");
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>
<body>
<form>
	<table>
 		<tr>
			<td>
				<textarea name="clinComm1" id="clinComm1" rows=17 cols=55 onkeyup="" readOnly ><%=comment%></textarea>
			</td>
  		</tr>
		<tr>
  			<td align="right">				
				<input name="close" id="close" id="close" type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}" />' class="button" onClick="window.close();" />
			</td>
  		</tr>
	</table>
	<input type="hidden" name="techcom" id="techcom" id="techcom" value="<%=comment%>" />
</form>
</body>
</head>
</html>

