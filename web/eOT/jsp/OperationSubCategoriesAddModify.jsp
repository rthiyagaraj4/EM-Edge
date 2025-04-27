<!DOCTYPE html>
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eOT/js/OperationSubCategories.js'></script>
<script language='javascript'>
function makeEmpty(obj)
{
	document.forms[0].oper_cat_desc.value="";
}

function enableApplyBtn(){
	parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onload="enableApplyBtn();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//String speciality_desc="";
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String speciality_desc_disable="";

String speciality_code=checkForNull(request.getParameter( "speciality_code" ));
String speciality_desc=checkForNull(request.getParameter( "speciality_desc" ));
String oper_cat_code=checkForNull(request.getParameter("oper_cat_code"));
String oper_cat_desc=checkForNull(request.getParameter("oper_cat_desc"));
String oper_sub_cat_code=checkForNull(request.getParameter("oper_sub_cat_code"));
String oper_sub_cat_desc=checkForNull(request.getParameter("oper_sub_cat_desc"));

String status="";
String sql="";
String oper_group_code= speciality_code;
String ph_module_yn="";
ph_module_yn=request.getParameter("ph_module_yn");
ph_module_yn="N";
con=ConnectionManager.getConnection(request);
		

if(mode.equals("modify")){
	try{
		
		//sql="select a.oper_group_code,b.short_desc speciality_desc, a.oper_cat_code, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY c where a.oper_group_code = b.speciality_code and a.oper_cat_code=c.oper_cat_code and a.oper_group_code=? and a.oper_cat_code=? and c.oper_sub_cat_code=? ";
		//sql="select a.oper_group_code,b.short_desc speciality_desc, a.oper_cat_code, a.long_desc, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY c where a.oper_group_code = b.speciality_code and a.oper_cat_code=c.oper_cat_code and a.oper_group_code=? and a.oper_cat_code=? and c.oper_sub_cat_code=? ";
	
		//sql="SELECT a.oper_group_code,get_desc(?,'AM_SPECIALITY_LANG_VW','long_desc','SPECIALITY_CODE',a.oper_group_code) speciality_desc, a.oper_cat_code, get_desc(?,'OT_OPER_CATEGORY_LANG_VW','long_desc','OPER_CAT_CODE',a.oper_cat_code) OPER_CAT_DESC, c.oper_sub_cat_code, get_desc(?,'OT_OPER_SUB_CATEGORY_LANG_VW','long_desc','OPER_SUB_CAT_CODE',c.oper_sub_cat_code) OPER_SUB_CAT_DESC, NVL(c.status,'E') status FROM  OT_OPER_CATEGORY a, AM_SPECIALITY b, OT_OPER_SUB_CATEGORY c  WHERE a.oper_group_code = b.speciality_code AND a.oper_cat_code=c.oper_cat_code AND a.oper_group_code=? AND a.oper_cat_code=?  AND  c.oper_sub_cat_code=?";
		sql="SELECT A.OPER_GROUP_CODE, C.LONG_DESC SPECIALITY_DESC,A.OPER_CAT_CODE, A.LONG_DESC OPER_SUB_CAT_DESC,NVL(A.STATUS,'E') STATUS FROM OT_OPER_SUB_CATEGORY_LANG_VW A, OT_OPER_CATEGORY_LANG_VW B, AM_SPECIALITY_LANG_VW C WHERE A.OPER_GROUP_CODE  = C.SPECIALITY_CODE AND A.OPER_GROUP_CODE = B.OPER_GROUP_CODE AND  A.OPER_CAT_CODE  = B.OPER_CAT_CODE AND  A.LANGUAGE_ID =  ? AND   A.LANGUAGE_ID= B.LANGUAGE_ID AND  A.LANGUAGE_ID= C.LANGUAGE_ID AND A.OPER_GROUP_CODE=? AND A.OPER_CAT_CODE=?  AND  A.OPER_SUB_CAT_CODE=?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		//stmt.setString(2,locale);
		//stmt.setString(3,locale);
		stmt.setString(2,oper_group_code);
		stmt.setString(3,oper_cat_code);
		stmt.setString(4,oper_sub_cat_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{   
            /*oper_group_code=rs.getString("oper_group_code");
           	oper_cat_code=rs.getString("oper_cat_code");
           	//oper_cat_code=rs.getString("long_desc");
            oper_sub_cat_code=rs.getString("oper_sub_cat_code");
            //long_desc=rs.getString("long_desc");
            oper_sub_cat_desc=rs.getString(6); //c.long_desc
           	speciality_desc=rs.getString("speciality_desc");
           	status=rs.getString("status");
			*/
			oper_group_code=rs.getString("oper_group_code");
			speciality_desc=rs.getString("speciality_desc");
			oper_cat_code=rs.getString("oper_cat_code");
			oper_sub_cat_desc=rs.getString("oper_sub_cat_desc");
			status=rs.getString("status");
		}

		if(status.equals("E")){
			chk_checked="checked";
     		disable_flag="";
		}else{
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
	
<form name="specialityForm" id="specialityForm"  onload='FocusFirstElement()'  action="../../servlet/eOT.SpecialitySubCatServlet" method="post" target="messageFrame"> 
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
		<td class='label' width="25%">
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width="25%" >
		<select name="speciality_desc" id="speciality_desc" onchange="makeEmpty(this);">
		<%

	try{
			//con=ConnectionManager.getConnection(request);

sql="SELECT B.SHORT_DESC SPECIALITY_DESC, A.SPECIALITY_CODE OPER_GROUP_CODE FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID=?  AND NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE ORDER BY 1 ";
    stmt=con.prepareStatement(sql);
	stmt.setString(1,locale);
	rs=stmt.executeQuery();

      while (rs.next())
	  {
          speciality_desc=rs.getString("SPECIALITY_DESC");
		  oper_group_code=rs.getString("OPER_GROUP_CODE");
	  
   %>
	<option value="<%=oper_group_code%>"><%=speciality_desc%></option>
	<%}
}catch(Exception e)
	{
		e.printStackTrace();
	//System.err.println("Err OperationSubCategoriesAddModify ::" +e);
	//out.println("exp"+e);
	}
finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e)
		{
			e.printStackTrace();
		//out.println("exp"+e);
		System.err.println("Err OperationSubCategoriesAddModify ::" +e);
		}
}
	}else if (mode.equals("modify"))
	{
	%>
	<td class='label'>
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
<%
if (mode.equals("insert"))
{
	%>

<tr>
	<td class='label'>
	<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text"  name="oper_cat_desc" id="oper_cat_desc" size='20' value="" onBlur="if(this.value!='')callOper_sub_cat(oper_cat_code,oper_cat_desc);" >
		<input type="hidden" name="oper_cat_code" id="oper_cat_code" value="">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callOper_sub_cat(oper_cat_code,oper_cat_desc);">
       <img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<% 
	if (ph_module_yn.equals("Y")) {
%>	
<tr>
	<td class='label'>
	<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>	
	</td>
	<td class='fields'>
		<input type="text" name="oper_sub_cat_code" id="oper_sub_cat_code" value="<%=oper_sub_cat_code%>"   size='4' maxlength='4' <%=disable_flag%>  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<%
	} else {
%>
<tr>
	<td class='label'>
	<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>	
	</td>
	<td class='fields'>
		<input type="text" name="oper_sub_cat_code" id="oper_sub_cat_code" value="<%=oper_sub_cat_code%>"   size='4' maxlength='4' <%=disable_flag%>  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%
	} 
}else if (mode.equals("modify")){
%>
	<tr>
	<td class='label'>
	<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields">
	<input type="text"  name="oper_cat_desc" id="oper_cat_desc" size='20' value="<%=oper_cat_desc%>" disabled>
	<input type="hidden" name="oper_cat_code" id="oper_cat_code" value="<%=oper_cat_code%>">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" disabled >
    <img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<% 
	if (ph_module_yn.equals("Y")) {
%>

<tr>
	<td class=label >
		<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
	<input type="text" name="oper_sub_cat_code" id="oper_sub_cat_code" value="<%=oper_sub_cat_code%>" disabled  size='4' maxlength='4' <%=disable_flag%>  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%
	} else {
%>
		<!-- <input type="hidden" name="oper_sub_cat_code" id="oper_sub_cat_code" value="<%=oper_sub_cat_code%>" > -->

		<tr>
	<td class=label >
		<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
	<input type="text" name="oper_sub_cat_code" id="oper_sub_cat_code" value="<%=oper_sub_cat_code%>" disabled  size='4' maxlength='4' <%=disable_flag%>  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<%
	} 
}
%>


<tr>
	<td class='label'>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<input type="text" name="long_desc" id="long_desc" value='<%=oper_sub_cat_desc%>' size='30' maxlength='30' <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label>
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td  class=fields >
	<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='speciality_desc1' id='speciality_desc1' value='<%=oper_group_code%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=oper_group_code%>'>
<input type='hidden' name='oper_sub_cat_code1' id='oper_sub_cat_code1' value='<%=oper_sub_cat_code%>'>
<input type='hidden' name='long_desc1' id='long_desc1' value='<%=oper_sub_cat_desc%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</body>
</html>


