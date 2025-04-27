<!DOCTYPE html>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href ='../../eCommon/html/IeStyle.css'> </link> -->
<%
//This file is saved on 18/10/2005.
String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../js/AgeGroupForIntervention.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown="lockKey()">
<%
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="91%">
			  <tr><td colspan="5">&nbsp</td></tr>
			    <tr>
				<td align="left" class="label" width="15%">&nbsp<fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="36%">&nbsp;&nbsp;
				<select name="age_group_code" id="age_group_code" >
				<option value="" selected> &nbsp&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				<%
					String age_group1 ="";
					 //age_group1 = "select age_group_code, long_desc from am_age_group where eff_status = 'E' order by long_desc";
					 age_group1 = "SELECT age_group_code, long_desc FROM am_age_group_lang_vw WHERE eff_status = 'E' and language_id = ? ORDER BY long_desc";
					pstmt =con.prepareStatement( age_group1);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery( );
					while(rs!=null  && rs.next())
					 {
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
				%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'></td>
					<td class = "label" colspan="1">
					</td>
			  </tr>
			 <tr><td colspan="5">&nbsp</td></tr>
		  </table>	
	  </form>
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
finally
  {
	  		if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
  }
%>
</body>
</html>

