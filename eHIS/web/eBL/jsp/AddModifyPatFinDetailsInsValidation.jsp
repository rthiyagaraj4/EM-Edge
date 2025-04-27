<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,oracle.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006

-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		

		   	
%>
<html>	
<head>

	
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>


	<script language='javascript'>
		
	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<form name='' id='' method='post'   scrolling=no >


<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<%	 
	try
		{	
			System.out.println("TEst");
		}
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
	}
	finally
	{
//		if(pstmt != null)pstmt.close();
//		ConnectionManager.returnConnection(con, request);
	}
%>


</table>
 


</form>
</body>
</html>

