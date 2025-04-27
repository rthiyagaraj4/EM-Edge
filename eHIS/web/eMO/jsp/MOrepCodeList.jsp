<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String strd="";
%>
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/MOCodeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code')" onKeyDown="lockKey()">
<form name="menu_form" id="menu_form">
<BR>
<div align="left">
  <table border="0" cellpadding="0" cellspacing="0" width="50%" align='center'>
  <tr>
     <td width="20%"  class="label"> </td>
     <td width="20%" class='label'></td>
	 <td width="50%"  class="label"><%=strd%></td>
 </tr>
 <tr>
    <td width="30%"  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
    <td width="20%" class='fields' colspan="2">
		<select name="code" id="code"  onChange="codeCheck(this.value)" >
				<option value=' ' selected>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;
				<%
					try {
							con = ConnectionManager.getConnection(request);
							if(con==null)out.println("one");
						    //String sql = "select MASTER_CODE,TABLE_ID,MASTER_CODE_DESC  from sm_master_code where module_id='MO' order by MASTER_CODE";
							String sql = "select MASTER_CODE,TABLE_ID,MASTER_CODE_DESC  from SM_MASTER_CODE_LANG_VW where module_id='MO' and LANGUAGE_ID ='"+localeName+"' order by MASTER_CODE";
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
						if (pstmt != null) pstmt.close();
						if (rs    != null) rs.close();
						} 
						catch(Exception e) 
						{ out.println("in else "+e);}
						finally 
						{ 
							 ConnectionManager.returnConnection(con,request);
						}
				%>
		</select>
		</td>
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


