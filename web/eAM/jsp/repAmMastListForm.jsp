<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.ConnectionManager,java.sql.*"%>

<%
	//String locale = (String)session.getAttribute("LOCALE");
    Connection con = null; 
	Statement stmt = null;
	ResultSet rs = null;
%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eAM/js/repcodeCheck.js" language="javascript">
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onLoad="codeCheck('code');Focusing('code')" onKeyDown = 'lockKey()'>
		<form name="menu_form" id="menu_form">
		<BR>
		<div align="left">
		  <table border="0" cellpadding="0" cellspacing="0"  align='center'>
			 <tr>
			 <td width='10%'>&nbsp;</td>
			 <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
			 <td class='fields'><select name="code" id="code" onChange="codeCheck(this.value);" >
			 <option value=' ' selected> ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- 
			 <%
			try {
				  con = ConnectionManager.getConnection(request);
				
				  if(con == null){
						out.print("Unable to connect to the database.<br>Please contact system administrator.");
						return;
				  }				  
				  stmt = con.createStatement();
				 // String sql = "Select  master_code,master_code_desc, table_id from sm_master_code_lang_vw where module_id='AM' and language_id='"+locale+"' order by master_code_desc";
				 String sql = "Select  master_code,master_code_desc, table_id from sm_master_code where module_id='AM' order by master_code_desc";
				  if(stmt == null){
						out.print("Problem in executing the query.<br>Please contact system administrator.");
						return;
				  }
				  rs = stmt.executeQuery(sql);
				  if( rs != null )
				  {
					  while(rs.next())
					  {
						String strTableId = rs.getString("table_id") ;
						String strCodeDesc=rs.getString("master_code_desc");
			%>			
						<option value='<%= strTableId %>'><%= strCodeDesc %>
			<%
					  }
				}
				if (stmt != null) stmt.close();
				if (rs != null)  rs.close();
			}catch(Exception e) { 
				out.println(e.toString());
				e.printStackTrace();
			}finally {			  
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

