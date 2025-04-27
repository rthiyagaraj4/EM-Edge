<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/NoteTypeForSpecialities.js'></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String speciality_code="";
String long_desc="";
String sql = "";
%>
<form name="NoteTypeForSpecialityMain_form" id="NoteTypeForSpecialityMain_form"  onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='80%'  align='center'>
<tr>
	<td class=label><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td><select name="speciality_description" id="speciality_description" onchange='clearDtl_Frame();'> 
	<option value='' selected>----------
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
   
<% try
      {
        con=ConnectionManager.getConnection(request);
		
		sql="SELECT A.LONG_DESC, A.SPECIALITY_CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.LANGUAGE_ID= ? AND NVL(A.EFF_STATUS,'E') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 1 ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        long_desc=rs.getString(1);
			        speciality_code=rs.getString(2);
                    %>	
	               <option value="<%=speciality_code%>"><%=long_desc%>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){
			e.printStackTrace();
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					ConnectionManager.returnConnection(con);
				}catch(Exception e){
					e.printStackTrace();
				}
}
%>

</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
    <td align="right" class="label">
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();"  >
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvalues();"   ></td>
	<td>&nbsp;</td>
		
</tr>
</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


