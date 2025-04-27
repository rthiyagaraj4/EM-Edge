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
<title>Request Clinical Comments</title>
<script language="javascript" src="../js/RadiologyExam.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>

</script>
<%
	String cliniccmt="";
	String addInfo="";
		
	System.err.println("Request Clinical Comments");
	String index = checkForNull(request.getParameter("index"));
	String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
	System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
	String orderid = checkForNull(request.getParameter("orderid"));
	String order_line_num = checkForNull(request.getParameter("order_line_num"));
	String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
	String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
	String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
	String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
	String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
	String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
	
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
<%
	Connection con = ConnectionManager.getConnection();	
	try
	{
		PreparedStatement pstmt = null;
		//Statement stmt				= null;
		ResultSet rs = null;
		String Commenttype="C";
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("orderid--"+orderid);
			System.err.println(order_line_num);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt=con.prepareStatement("select RD_RESULT.GET_COMMENTS(?,?,?,?,?,?,?) from dual");			
				
				pstmt.setString(1,P_FACILITY_ID);
				pstmt.setString(2,orderid);
				pstmt.setString(3,order_line_num);
				pstmt.setString(4,P_REQUEST_NUM);
				pstmt.setString(5,P_REQUEST_LINE_NUM);
				pstmt.setString(6,P_LANGUAGE_ID);
				pstmt.setString(7,Commenttype);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cliniccmt =checkForNull(rs.getString(1));
					System.err.println("cliniccmt--"+cliniccmt);
				}
				

	}catch(Exception e)
		{
			System.out.println("Exception while executing cliniccmt :"+e);
		}
%>
			<textarea name="clinComm1" id="clinComm1" rows=20 cols=75 onkeyup="" onkeypress="" readOnly><%=cliniccmt%></textarea>
			</td>
  		</tr>
		<tr>
		<%
		try
	{
		PreparedStatement pstmt1 = null;
		//Statement stmt				= null;
		ResultSet rs1 = null;
		String Commenttype1="O";
		
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
					addInfo =rs1.getString(1);
					System.err.println("addInfo--"+addInfo);
				}
				

	}catch(Exception e)
		{
			System.out.println("Exception while executing Order line Additional Info :"+e);
		}
%>
			<td>
				<textarea name="clinComm2" id="clinComm2" rows=20 cols=75 onkeyup="" readOnly><%=addInfo%></textarea>
			</td>
  		</tr>
		<tr>
			<td align="right">
				<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}" />' class="button" onClick="window.close();" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="clinic1" id="clinic1" id="clinic1" value="<%=cliniccmt%>" />
	<input type="hidden" name="clinic2" id="clinic2" id="clinic2" value="<%=addInfo%>" />
</form>
</body>
</head>
</html>

