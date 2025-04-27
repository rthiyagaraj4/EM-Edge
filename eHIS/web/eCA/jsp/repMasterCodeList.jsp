<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/repResetRunList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body>
<form>
<table border=0 cellspacing=0 cellpadding=3 width='30%' align=center>
<tr>
	<td align=right class=label><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td align=left><select name=code onChange="codeCheck(this.value);" >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<%
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");

			Connection con =null;
			try {
					 con=ConnectionManager.getConnection(request);
					 PreparedStatement stmt=null;
					 ResultSet rs=null;
					  if(con==null)out.println("one");
					  
					  String sql = "Select  master_code,SM_GET_DESC.SM_MASTER_CODE(A.MODULE_ID,a.master_code,?,'1') master_code_desc from sm_master_code a where module_id=? order by master_code_desc";
						stmt = con.prepareStatement(sql);
						stmt.setString(1,locale);
						stmt.setString(2,"CA");
						rs = stmt.executeQuery();
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
					}
			%>
	</select></td>
</tr>
</table>
<form>
</body>
</html>
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
			}
			catch(Exception e){
				//out.println(e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
				}		
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>

