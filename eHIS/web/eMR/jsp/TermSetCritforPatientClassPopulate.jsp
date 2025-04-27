<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.* " %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script src="../js/TermSetCritforPatientClass.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey();'>
<%
	Connection con 	      = null;
	PreparedStatement pstmt	      = null;
	ResultSet rs		      = null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String accuracyTemp="";
		//int i = 0;
		String accuracyVal = request.getParameter("accuracyVal");
		if(accuracyVal.equals("Certain"))
				accuracyTemp = "C";
		else if(accuracyVal.equals("Uncertain"))
				accuracyTemp = "U";
		if((accuracyVal.equals("Certain")) || (accuracyVal.equals("Uncertain")))
		{

			String sql1="Select accuracy_code ,long_desc from mr_accuracy where eff_status = 'E' and accuracy_indicator = '"+accuracyTemp+"' order by long_desc";
			pstmt =con.prepareStatement(sql1);
			rs=pstmt.executeQuery();

			
			while (rs!= null && rs.next())
			{
				%>
				<script>	
						var temp = "<%=rs.getString("accuracy_code")%>";
						var temp1="<%=rs.getString("long_desc")%>";
						var opt=parent.frames[1].frames[0].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].frames[0].document.forms[0].listValue1.add(opt);			
				</script>
		<%
			}
				
		%>
			<script>
			parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp";
			</script>
				

		<%}
		%>

	<%}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	 {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
	}
%>


</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

