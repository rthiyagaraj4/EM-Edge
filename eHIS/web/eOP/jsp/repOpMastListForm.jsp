<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8"); 
    Connection con =null;
    Statement stmt =null;
    ResultSet rs =null;    
%>


<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOP/js/repOPCodeCheck.js" language="javascript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code')" onKeyDown = 'lockKey();' >
<form name="menu_form" id="menu_form">
<BR>
<div align="left">

  <table border="0" cellpadding="2" cellspacing="0"  align='center' width='40%'>

     <tr>
      <td class="label" colspan='2' width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td class='fields' colspan='2' width='60%'><select name="code" id="code" onChange="codeCheck(this.value)" >
      <option value=' ' selected>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
<%
try {
		con = ConnectionManager.getConnection(request);
          
          stmt = con.createStatement();
          //String sql = "Select  master_code_desc, table_id from sm_master_code where module_id='OP'  and master_code < 7 order by master_code";
		  String sql = "Select  master_code_desc, table_id from sm_master_code_lang_vw where language_id='"+localeName+"' AND module_id='OP'  and master_code < 7 order by master_code";
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

} catch(Exception e) {  
	
	//out.println("in else "+e);
	e.printStackTrace();

	}

finally{
if(stmt != null) stmt.close();
if(rs != null) rs.close();
if(con!=null)
    ConnectionManager.returnConnection(con,request);
}
%>
    </select></td>   
    </tr>
   </table>
</div>
</form>
</body>
</html>

