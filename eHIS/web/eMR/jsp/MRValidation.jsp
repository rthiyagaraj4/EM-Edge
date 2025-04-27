<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>

<script src='../js/RecDiagnosis.js' language='javascript'></script>	
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null; 
	PreparedStatement stmt=null;
	ResultSet rs = null;
		
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	term_set_code = term_set_code.toUpperCase();

	String short_desc = "";
	int recordcnt = 0;
	String sql = "";
	try
	{
		con = ConnectionManager.getConnection(request);

		sql = "select short_desc from MR_D_"+term_set_id+"_VW where term_code = ?";

		stmt = con.prepareStatement(sql);
		stmt.setString(1,term_set_code);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			short_desc = rs.getString("short_desc");
			recordcnt++;
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	
		if(recordcnt == 0)
		{
			out.println("<script>alert(getMessage('INVALID_DIAGCODE'));parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");
		}
		else
		{
			out.println("<script>parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value=\""+short_desc+"\";parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value=\""+term_set_code+"\";</script>");
		}

	}
	catch(Exception e)
	{
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	

%>
</body>
</html>

