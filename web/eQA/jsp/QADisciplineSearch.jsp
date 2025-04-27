<!DOCTYPE html>
<html>
<%@ page import =" oracle.jdbc.driver.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
    <head>
<title> Indicator List Entry </title>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script src="../../eQA/js/QAMessages.js" language="JavaScript"></Script>
<script src="../../eCommon/js/Common.js" language="javascript"> </script>
<Script src="../../eQA/js/QADirRecordOfClinIndicators.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <body class='content'  topmargin='0' onKeyDown = 'lockKey()'>
  <form name="Discipline_Frame" id="Discipline_Frame">

<%!
 String queryString="";
 %>
 <%

    session.removeAttribute("collectData");
	session.removeAttribute("arr");
 	queryString=request.getQueryString();	
 %>
<input type='hidden' name='QIND_QUERY' id='QIND_QUERY' value='<%=queryString%>'>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
<td align="right" width="30%" class="label">        
  <b align="left">
	Discipline&nbsp;
	</b>
	</td>
	<td align="left" width="40%" class="label">        
		<select name='QIND_DISCIPLINE_ID' id='QIND_DISCIPLINE_ID' onChange='funDisiplineList()'>
					<option value='-1'>&nbsp;&nbsp;-------- Select --------&nbsp;&nbsp;</option>
	<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

    StringBuffer sqlQindDispId= new StringBuffer();
	sqlQindDispId.append("SELECT  QIND_DISCIPLINE_ID QIND_ID,");
	sqlQindDispId.append(" QIND_DISCIPLINE_DESC QIND_DESC ");
	sqlQindDispId.append(" FROM QA_QIND_DISCIPLINE");

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt=conn.prepareStatement(sqlQindDispId.toString());
		rs=pstmt.executeQuery();

		while(rs.next())
		{	 
		out.println("<option value='"+rs.getString("QIND_ID")+"'>");
		out.println(rs.getString("QIND_DESC")+"</option>");
		}	
		out.println("</select>");
        if (rs != null) rs.close();
        if (pstmt != null)  pstmt.close();
        if((sqlQindDispId != null) && (sqlQindDispId.length() > 0))
		{
			sqlQindDispId.delete(0,sqlQindDispId.length());
		}
	}catch(Exception ee)
	{
	  %>
			Exception occured <%=ee%>
      <%
	}
	finally
	{
		 ConnectionManager.returnConnection(conn, request);
	}
%>
 </td>
 <td align='right'><input type='button' class='button' value='Record' onClick='apply()'></td>
 <td align='left'><input type='button' class='button' value='Cancel' onClick='cancel()'></td>
 </tr>
</table>
</form>
</body>
</html>

