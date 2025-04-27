<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/FunctionsForStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String status_code="";
String status_desc="";
String sql = "";
%>
<form name="functionsForStatus_form" id="functionsForStatus_form"  onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='80%'  align=center>
<tr>
	<td class=label>
		<fmt:message key="Common.status.label" bundle="${common_labels}"/>
	</td>
	<td>
		<select name="status_description" id="status_description" onchange='clearvalues();'>
		<option value='' selected>-------------------- -------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------- --------------------

   <% try
      {
        con=ConnectionManager.getConnection(request);
	//	sql="SELECT STATUS_DESC, STATUS_CODE FROM OT_STATUS ORDER BY 1 ";

		sql="SELECT STATUS_DESC, STATUS_CODE FROM OT_STATUS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 1 ";

		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        status_desc=rs.getString(1);
			        status_code=rs.getString(2);
                    %>	
	               <option value="<%=status_code%>"><%=status_desc%>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){e.printStackTrace();}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("exp"+e);
		}
}
%>

</td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
    <td class="label">
		
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();"  >
	</td>
	<td class="label">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/> 'onClick="clearvalues();">
	</td>
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


