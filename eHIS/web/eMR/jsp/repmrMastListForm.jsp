<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con =null;
	Statement stmt  = null;
	ResultSet rs = null;

try 
{
	con=ConnectionManager.getConnection(request);
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eMR/js/repcodeCheck.js" language="javascript">
</script>
<script src='../../eMR/js/repResetRunlist.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code');FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="menu_form" id="menu_form">
<BR>
<div align="left">

  <table border="0" cellpadding="3" cellspacing="0"  align='center'>

      <tr>
     <td width='10%' class='label'>&nbsp;</td>
      <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td class='fields'><select name="code" id="code" onChange="codeCheck(this.value);" >
	<option value=' ' selected>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;
<%
	     stmt=null;
 
	      rs=null;

	      stmt = con.createStatement();
	      //String sql = "Select  master_code_desc, table_id from sm_master_code where module_id='MR' order by master_code_desc";
		  String sql="Select  master_code_desc, table_id from sm_master_code_lang_vw  where language_id='"+localeName+"' AND module_id='MR' and table_id not like 'QA%' order by master_code_desc";
		  
	      rs = stmt.executeQuery(sql);
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname = rs.getString("table_id") ;
	        	String classname1=rs.getString("master_code_desc");

%>
			<option value='<%= classname %>'><%= classname1 %>
<%
	          }
	      }

%>
    </select></td>
    <td width='10%' class='label'>&nbsp;</td>
    </tr>

   </table>
</div>
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace(); }
finally
{
	try
	{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	}
	 catch(Exception e) { }
	ConnectionManager.returnConnection(con,request);
}
%>
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

