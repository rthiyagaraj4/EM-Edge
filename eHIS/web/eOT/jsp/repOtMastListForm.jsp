<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%
   Connection con = ConnectionManager.getConnection(request); 
    Statement stmt =null;
    ResultSet rs =null;
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>

<script src="../../eOT/js/Booking.js" language="javascript"></script>
<script language="JavaScript" src="../../eOT/js/repOTCodeCheck.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('code');codeCheck('code')" >
<form name="menu_form" id="menu_form">
<BR>
<div align="left">

  <table border="0" cellpadding=3 cellspacing="0"  align='center'>

      <tr>
     <td width='10%'>&nbsp;</td>
      <td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
      <td align="left"><select name="code" id="code" onChange="codeCheck(this.value)" >
    <option value=' ' selected>&nbsp;------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- -------&nbsp;
<%
try {

          if(con==null)out.println("one");
          stmt = con.createStatement();
          String sql = "Select  table_id,master_code_desc from sm_master_code where module_id='OT' order by master_code ";
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

} catch(Exception e) {  out.println("in else "+e);}

finally{
if(stmt != null) stmt.close();
if(rs != null) rs.close();
if(con!=null)
    ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>
    <td width='10%'>&nbsp</td>
    </tr>

   </table>
</div>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

