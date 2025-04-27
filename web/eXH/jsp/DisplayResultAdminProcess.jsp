<!DOCTYPE html>
<html> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.*,oracle.jdbc.driver.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language="JavaScript">
function formLoad()
{

	if(document.getElementById("rule").value=='I')
	{
	    location.href ="../eXH/jsp/AdminQueryExceptionPage.jsp?proc_id="+document.getElementById("proc_id").value;  
	}
	else				   
	{
		 location.href ="../eXH/jsp/AdminOracleJobProcessList.jsp?functionID="+document.getElementById("functionID").value;
	}
		
}										    
</script>

		 
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='formLoad();'>
<form>
<p align="left">
<%															  
												   
	String result=(String)request.getParameter( "message" );
	String functionID=(String)request.getParameter("functionID");
	String rule=XHDBAdapter.checkNull((String)request.getParameter("rule"));
	String proc_id=XHDBAdapter.checkNull((String)request.getParameter("proc_id"));

	//System.out.println("result 19"+result);
 																		   					 
%>															    
<script>
alert('<%=result%>');
</script>
</p>
<input type=hidden name="functionID" id="functionID" id="functionID" value='<%=functionID%>'>
<input type=hidden name="rule" id="rule" id="rule" value='<%=rule%>'>
<input type=hidden name="proc_id" id="proc_id" id="proc_id" value='<%=proc_id%>'>
</form>
</BODY>

</html>

