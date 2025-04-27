<!DOCTYPE html>
<%@ page import="java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");

%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eBL/js/BLInsAgeLimit.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>

<script language='javascript'>

function enableAppy()
{
//	alert("load apply");
parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  OnLoad="enableAppy();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//out.println(mode);
String age_group_code=checkForNull(request.getParameter("age_group_code"));
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String short_desc_disable="";
String strLongDesc="";
String status="";
String sql="";
String strShortDescValue="";
String strShortDesc="";
String frmYear="";
String frmMonth="";
String frmDay="";

String toYear="";
String toMonth="";
String toDay="";



if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
	//	sql="select a.age_group_code,b.short_desc short_desc, a.oper_cat_code, a.long_desc, nvl(a.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b where a.age_group_code = b.speciality_code and  a.age_group_code =? and a.oper_cat_code=? ";

		//sql="select a.age_group_code,b.short_desc short_desc, a.oper_cat_code, a.long_desc, nvl(a.status,'E') status from  OT_OPER_CATEGORY_LANG_VW a, am_speciality b where a.age_group_code = b.speciality_code and  a.age_group_code =? and a.oper_cat_code=? and language_id='"+locale+"' ";
		/*sql="SELECT A.age_group_code,B.LONG_DESC short_desc,A.OPER_CAT_CODE,A.LONG_DESC OPER_CAT_DESC,NVL(A.STATUS,'E') STATUS FROM  OT_OPER_CATEGORY_LANG_VW A, AM_SPECIALITY_LANG_VW B WHERE A.LANGUAGE_ID=B.LANGUAGE_ID AND A.age_group_code = B.SPECIALITY_CODE AND B.LANGUAGE_ID=? AND  A.age_group_code =? AND A.OPER_CAT_CODE=?";
		*/

		sql = "SELECT LONG_DESC,SHORT_DESC,FROM_YEAR,FROM_MONTH,FROM_DAY,TO_YEAR,TO_MONTH,TO_DAY,NVL(status,'E') status1 FROM BL_INS_AGE_GROUP where age_group_code =? ";


		//sql = "SELECT A.age_group_code,GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',A.age_group_code) short_desc,A.OPER_CAT_CODE,GET_DESC(?,'OT_OPER_CATEGORY_LANG_VW','LONG_DESC','OPER_CAT_CODE',A.OPER_CAT_CODE) OPER_CAT_DESC,NVL(A.STATUS,'E') STATUS FROM  OT_OPER_CATEGORY A, AM_SPECIALITY B WHERE A.age_group_code = B.SPECIALITY_CODE AND  A.age_group_code =? AND A.OPER_CAT_CODE=?";

		stmt=con.prepareStatement(sql);
//		stmt.setString(1,locale);
		//stmt.setString(1,locale);
		stmt.setString(1,age_group_code);
		//stmt.setString(3,oper_cat_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{   
			strLongDesc=rs.getString("LONG_DESC");
			strShortDesc=rs.getString("SHORT_DESC");
			frmYear=rs.getString("FROM_YEAR");
			frmMonth=rs.getString("FROM_MONTH");
			frmDay = rs.getString("FROM_DAY");
			toYear=rs.getString("TO_YEAR");
			toMonth=rs.getString("TO_MONTH");
			toDay = rs.getString("TO_DAY");
			status=rs.getString("status1");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
		}
		else
		{
			chk_checked="";
			disable_flag="readonly onfocus='this.blur()'";;
			chk_value="D";
		}
		
	short_desc_disable="disabled";	

}catch(Exception e)
	{
	out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			out.println("Exception is "+e);
			}
		
		}
}

%>
	
<form name="speciality_form" id="speciality_form"  onload='FocusFirstElement();'  action="../../servlet/eBL.BLInsAgeLimitServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
			<tr >
				<th  class="columnheader" align='left'><fmt:message key="eBL.AGELIMIT.label" bundle="${bl_labels}"/></th>
			</tr>	
</TABLE>	
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
										
			 <tr>
			 	<td class="label" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type="text" name="code" id="code" id="age_group_code" 	size=20 maxlength="30"    value ="<%=age_group_code%>" onBlur="ChangeUpperCase( this );"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();"  <%=disable_flag%> >			
					<img src='../../eCommon/images/mandatory.gif'>
				</td>				
				<td class="label" colspan='3'></td>				
			 </tr>

			<tr>
			 	<td class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type="text" name="long_desc" id="long_desc" id="long_desc" 	size=40	 maxlength="60"  value ="<%=strLongDesc%>" >		
				<img src='../../eCommon/images/mandatory.gif'>
				</td>				
				<td class="label" colspan='3'></td>				
			 </tr>


			 <tr>
			 	<td class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type="text" name="short_desc" id="short_desc" id="short_dses" 	size=40	 maxlength="30"  value ="<%=strShortDesc%>" >		
				<img src='../../eCommon/images/mandatory.gif'>
				</td>				
				<td class="label" colspan='3'></td>				
			 </tr>
			 
			 <tr>
				<td class='label' ><fmt:message key="eBL.AGELIMITFROM.label" bundle="${bl_labels}"/></td>	
				<td class='fields'>
				<input type='text' name='frmYear' id='frmYear' size='3' maxlength="3"  value ="<%=frmYear%>"  onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'><fmt:message key="Common.year.label" bundle="${common_labels}"/>
				<input type='text' name='frmMonth' id='frmMonth' size='2' maxlength="2"   value ="<%=frmMonth%>"  onBlur='numberCheck(this,"M")' 
				onKeyPress='return(	ChkNumberInput(this,event,"0"))'><fmt:message key="Common.month.label" bundle="${common_labels}"/>
				<input type='text' name='frmDay' id='frmDay' size='2' maxlength="2"    value ="<%=frmDay%>"  onBlur='numberCheck(this,"D")' 
				onKeyPress='return(ChkNumberInput(this,event,"0"))'><fmt:message key="Common.day.label" bundle="${common_labels}"/>
				<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			 <tr>
				<td class='label' ><fmt:message key="eBL.AGELIMITTO.label" bundle="${bl_labels}"/></td>	
				<td class='fields'>
				<input type='text' name='toYear' id='toYear' size='3' maxlength="3"    value ="<%=toYear%>"  onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'><fmt:message key="Common.year.label" bundle="${common_labels}"/>
				<input type='text' name='toMonth' id='toMonth' size='2' maxlength="2"   value ="<%=toMonth%>"  onBlur='numberCheck(this,"M")' 
				onKeyPress='return(	ChkNumberInput(this,event,"0"))'><fmt:message key="Common.month.label" bundle="${common_labels}"/>
				<input type='text' name='toDay' id='toDay' size='2' maxlength="2"   value ="<%=toDay%>"  onBlur='numberCheck(this,"D")' 
				onKeyPress='return(ChkNumberInput(this,event,"0"))'><fmt:message key="Common.day.label" bundle="${common_labels}"/>
				<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>			

			<tr>
				<td class=label>
					<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
				</td>
				<td class='fields'>
				<%
				if(!(mode.equals("modify")))	  chk_checked = "checked   readonly";
				%>
					

					<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
				</td>
			</tr>
		</table>

<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name=age_group_code1 id=age_group_code1 value="<%=age_group_code%>">
<input type='hidden' name=long_desc1 id=long_desc1 value="<%=strLongDesc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


