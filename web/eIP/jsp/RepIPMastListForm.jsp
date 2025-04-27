<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
    Connection con = null;
	Statement stmt =null;
	ResultSet rs = null ;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/RepMasterList.js" language="javascript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'  onLoad="codeCheck('code')" >
<form name="menu_form" id="menu_form">
<BR>
<div align="left">
  <table border="0" cellpadding="0" cellspacing="0"  align='center'>
      <tr>
     <td width='10%'>&nbsp;</td>
      <td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
      <td align="left">
	  <select name="code" id="code" onChange="codeCheck(this.value);" >
	<option value='' selected>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
<%
try {		
	con = ConnectionManager.getConnection(request);		
	      stmt = con.createStatement();
		  StringBuffer sql = new StringBuffer();
	      //sql.append("Select  table_id,master_code_desc from sm_master_code where module_id='IP' order by master_code_desc");
		  sql.append("Select  table_id,master_code_desc from sm_master_code_lang_vw where module_id='IP' and language_id='"+locale+"' order by master_code_desc");
	      rs = stmt.executeQuery(sql.toString());
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname = rs.getString("table_id") ;
	        	String classname1=rs.getString("master_code_desc");
%>
			<option value='<%= classname %>'><%= classname1 %></option>
<%
	          }
	      }
			if (stmt != null) stmt.close();
			if (rs != null)   rs.close();
	}catch(Exception e) {  out.println("in else "+e);}
	finally 
	{
		try
		{
			if (stmt != null) stmt.close();
			if (rs != null)   rs.close();
		}
		catch(Exception e)
		{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request);
	}
%>
    </select></td>
    <td width='10%'>&nbsp</td>
    </tr>
   </table>
</div>
</form>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

