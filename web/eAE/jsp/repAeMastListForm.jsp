<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String strd="";
%>
<html>
<head>
	<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/AECodeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck(document.forms[0].code.value)" onKeyDown = 'lockKey()'>
<form name="menu_form" id="menu_form" >
<BR>
<div align="left">

  <table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>
<tr><td colspan='2' ></td></tr>
	<tr><td colspan='2' class='label' height='5'></td></tr>

     <tr >
      <td width="20%" align="right" class="label"> </td>
      <td width="20%"></td>

    <td width="50%" align="left" class="label">
    <%=strd%>
    </td>

     </tr>
     <tr>
      <td width="30%"  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> </td>
	        <td width="20%"  colspan='2'><select name="code" id="code"  onChange="codeCheck(this.value)" >
	<option value=' ' selected>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;
<%
try {
		con = ConnectionManager.getConnection(request);
	      if(con==null)out.println("one");
	      
	      String sql = "Select  table_id,master_code_desc from sm_master_code_lang_vw where language_id ='"+locale+"' and module_id='AE' order by master_code";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	String classname  = rs.getString("table_id") ;
	        	String classname1 = rs.getString("master_code_desc");
%>
			<option value='<%= classname %>'><%= classname1 %>
<%
	          }
	      }

if (rs    != null)    rs.close();
if (pstmt != null) pstmt.close();

} catch(Exception e) {e.printStackTrace();}
finally {
  if(con != null)  
  ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
	<td class='label' height='5'></td>
    </tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr> 
	<tr><td  class='label' height='5'></td></tr>
   </table>
</form>
<script>document.forms[0].code.focus();</script>
</div>
</body>
</html>

