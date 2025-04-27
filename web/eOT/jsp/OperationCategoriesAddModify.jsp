<!DOCTYPE html>
<%@page  import="java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,java.sql.Connection,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/OperationCategories.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//out.println(mode);
String oper_group_code=checkForNull(request.getParameter("oper_group_code"));
String oper_cat_code=checkForNull(request.getParameter("oper_cat_code"));
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String speciality_desc_disable="";
String long_desc="";
String status="";
String sql="";
String speciality_desc_value="";
String speciality_desc="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
	//	sql="select a.oper_group_code,b.short_desc speciality_desc, a.oper_cat_code, a.long_desc, nvl(a.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b where a.oper_group_code = b.speciality_code and  a.oper_group_code =? and a.oper_cat_code=? ";

		//sql="select a.oper_group_code,b.short_desc speciality_desc, a.oper_cat_code, a.long_desc, nvl(a.status,'E') status from  OT_OPER_CATEGORY_LANG_VW a, am_speciality b where a.oper_group_code = b.speciality_code and  a.oper_group_code =? and a.oper_cat_code=? and language_id='"+locale+"' ";
		sql="SELECT A.OPER_GROUP_CODE,B.LONG_DESC SPECIALITY_DESC,A.OPER_CAT_CODE,A.LONG_DESC OPER_CAT_DESC,NVL(A.STATUS,'E') STATUS FROM  OT_OPER_CATEGORY_LANG_VW A, AM_SPECIALITY_LANG_VW B WHERE A.LANGUAGE_ID=B.LANGUAGE_ID AND A.OPER_GROUP_CODE = B.SPECIALITY_CODE AND B.LANGUAGE_ID=? AND  A.OPER_GROUP_CODE =? AND A.OPER_CAT_CODE=?";

		//sql = "SELECT A.OPER_GROUP_CODE,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',A.OPER_GROUP_CODE) SPECIALITY_DESC,A.OPER_CAT_CODE,GET_DESC(?,'OT_OPER_CATEGORY_LANG_VW','LONG_DESC','OPER_CAT_CODE',A.OPER_CAT_CODE) OPER_CAT_DESC,NVL(A.STATUS,'E') STATUS FROM  OT_OPER_CATEGORY A, AM_SPECIALITY B WHERE A.OPER_GROUP_CODE = B.SPECIALITY_CODE AND  A.OPER_GROUP_CODE =? AND A.OPER_CAT_CODE=?";

		stmt=con.prepareStatement(sql);
//		stmt.setString(1,locale);
		stmt.setString(1,locale);
		stmt.setString(2,oper_group_code);
		stmt.setString(3,oper_cat_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{   
			long_desc=rs.getString("OPER_CAT_DESC");
			speciality_desc=rs.getString("SPECIALITY_DESC");
			status=rs.getString("status");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	speciality_desc_disable="disabled";	

}catch(Exception e)
	{
	e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		}
}

%>
	
<form name="speciality_form" id="speciality_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.SpecialityServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
    
  <%
	if(mode.equals("insert"))
	{
	%>
		<td class=label>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			<select name="speciality_desc" id="speciality_desc" >
		<%

	try{
			con=ConnectionManager.getConnection(request);

	//sql="SELECT A.SHORT_DESC SPECIALITY_DESC, B.SPECIALITY_CODE OPER_GROUP_CODE FROM AM_SPECIALITY A, OT_SPECIALITIES B WHERE NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE=B.SPECIALITY_CODE ORDER BY 1";
	sql="SELECT B.SHORT_DESC SPECIALITY_DESC, A.SPECIALITY_CODE OPER_GROUP_CODE FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID=?  AND NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE ORDER BY 1 ";
    stmt=con.prepareStatement(sql);
	stmt.setString(1,locale);
	rs=stmt.executeQuery();

      while (rs.next())
	  {
          speciality_desc=rs.getString("SPECIALITY_DESC");
		  oper_group_code=rs.getString("OPER_GROUP_CODE");
	      speciality_desc_value=oper_group_code;
	

   %>
	   
	<option value="<%=speciality_desc_value%>"><%=speciality_desc%></option>
	  
	  
	<%}
}catch(Exception e){e.printStackTrace();}

	}else if (mode.equals("modify"))
	{
	%>
	<td class=label>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<select name="speciality_desc" id="speciality_desc" disabled >
	<option value="<%=oper_group_code%>"><%=speciality_desc%></option>
	<%

	}%>

	   </select>
	   <img src='../../eCommon/images/mandatory.gif'>
	 </td>

</tr>

<tr>
<%
if(mode.equals("insert"))
{
	%>
	<td class=label>
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="category" id="category"  value="<%=oper_cat_code%>"  size=4 maxlength=4 <%=disable_flag%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
		<img src='../../eCommon/images/mandatory.gif'>
	</td>

	<%
}else if(mode.equals("modify"))
	{
		%>
	<td class=label>
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="category" id="category"  value="<%=oper_cat_code%>"  size=4 maxlength=4 disabled onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}%>

</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"   size='20' maxlength='30' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
		</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name=oper_cat_code1 value="<%=oper_cat_code%>">
<input type='hidden' name=oper_group_code1 value="<%=oper_group_code%>">
<input type='hidden' name=long_desc1 value="<%=long_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


