<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
   Connection con = null; 
    Statement stmt =null;
    ResultSet rs =null;
 %>


<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOA/js/repOACodeCheck.js" language="javascript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% String locale = (String)session.getAttribute("LOCALE"); %>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('code');codeCheck('code');" >
<form name="menu_form" id="menu_form">
<BR>
<div align="left">

  <table border="0" cellpadding="0" cellspacing="0"  align='center'>

      <tr>
     <td width='10%'>&nbsp;</td>
      <td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
      <td align="left"><select name="code" id="code" onChange="codeCheck(this.value)" >
    <option value=' ' selected>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;
<%
request.setCharacterEncoding("UTF-8");
try {
con = ConnectionManager.getConnection(request); 
          stmt = con.createStatement();
          String sql = "Select  table_id,master_code_desc from sm_master_code_lang_vw where module_id='OA' and language_id='"+locale+"' order by master_code ";
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
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
} catch(Exception e) {  
//out.println("in else "+e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}

finally{

if(con!=null)
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

