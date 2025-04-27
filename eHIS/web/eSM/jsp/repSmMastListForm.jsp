<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%

	Connection con=null ;
	Statement stmt = null ;
	ResultSet rs ;
	String strd="";
	
%>
<html>
<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/codeCheck.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code'); FocusFirstElement()"; onKeyDown = 'lockKey()';  >
<form name="menu_form" id="menu_form"  method="post" target="messageFrame">
<div>
  <table border="0" cellpadding="0" cellspacing="0" width="auto" align='center'>

     <tr>
     
      <td  class="label"> </td>
      <td></td>
      

      <td class="label">
      <%=strd%>
      </td>

     </tr>

      <tr>
      <td width='10%'>&nbsp;</td>
      <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td class='fields'><select name="code" id="code" onChange="codeCheck(this.value)">
	<option value=' ' selected>--------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------
<%
try {
	        request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
	      if(con==null)out.println("one");
	      stmt = con.createStatement();
	      String sql = "Select  master_code,master_code_desc from sm_master_code where module_id='SM' order by master_code_desc";
	      rs = stmt.executeQuery(sql);
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname = rs.getString("master_code") ;
	        	String classname1=rs.getString("master_code_desc");
	    
%>
			<option value='<%= classname %>'><%= classname1 %>
<%
	          }
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	      }

} catch(Exception e) {  out.println("in else "+e);}
finally { 
	if(stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
    <td width='10%'>&nbsp;</td>
    </tr>
    </table>
</div>
</form>
</body>
</html>

