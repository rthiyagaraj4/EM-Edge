<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%

	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String strd="";
%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/repCpMasterList.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code')" >
<form name="menu_form" id="menu_form" >


<BR>
<div align="left">

  <table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>

     <tr >
      <td width="20%" align="right" class="label"> </td>
      <td width="20%"></td>

    <td width="50%" align="left" class="label">
    <%=strd%>
    </td>

     </tr>
     <tr>
      <td width="30%" align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
	        <td width="20%" align="left" colspan="2">
			<select name="code" id="code"  onChange="codeCheck(this.value)" >
	<option value=' ' selected>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;
<%
try {
		con = ConnectionManager.getConnection(request);
	      if(con==null)out.println("one");
	      
	      String sql = "Select  table_id,master_code_desc from sm_master_code where module_id='CP' order by master_code_desc";
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

} catch(Exception e) {  
	//out.println("in else "+e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
finally {
  if (rs    != null)    rs.close();
  if (pstmt != null) pstmt.close();
  ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
    </tr>
    <tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
   </table>
</form>
<script>document.forms[0].code.focus();</script>
</div>
</body>
</html>


