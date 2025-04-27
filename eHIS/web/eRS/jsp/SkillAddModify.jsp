<!DOCTYPE html>
<!--SkillAddModify.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04 Oct 04-->
<%-- JSP Page specific attributes start --%>
<%@ page language="java"  contentType="text/html;charset=UTF-8" import="eRS.*,eCommon.Common.*,java.sql.*,java.util.*, java.net.*,java.text.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Skill.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	String mode				= request.getParameter("mode");
%>
<BR>
<br><br>
<form name=form_add_mod  method='POST' action='../../servlet/eRS.SkillServlet'
target='messageFrame'>	
<%
	if(mode.equalsIgnoreCase("1")){
%>
	<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>
	<br>
	<br>
	<br>
	<tr>
		<td class='label' width='30%' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='60%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value='' name='skill_code' id='skill_code' onkeypress="return CheckForSpecChars(event);" onBlur=ChangeUpperCase(this); >
			<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value='' name='skill_desc' id='skill_desc'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td  width='30%' align="right" class="label"><fmt:message key="Common.ExplanatoryText.label"  bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;<textarea name="skill_expl_text"  rows='5'cols='40' onblur='checkForMax(this);'></textarea>
		
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;<input type='checkbox' checked value='E' name='eff_status' id='eff_status' onclick='onenable(this);'></td>
	</tr>
	</table> 
<%	} else{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_skill="";
	conn = ConnectionManager.getConnection(request);
	String skill_code=request.getParameter("skill_code")==null ? "":request.getParameter("skill_code");
	String skill_desc="";
	String eff_status="";
	String skill_expl_text="";

	try
	{	
		//sql_skill="select skill_desc,eff_status,skill_expl_text from rs_skill where skill_code=?";
		sql_skill="select skill_desc,eff_status,skill_expl_text from rs_skill_lang_vw where skill_code=? And language_id = ?";
		pstmt=conn.prepareStatement(sql_skill);
		pstmt.setString(1,skill_code);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		while(rs.next())
			{
			skill_desc=rs.getString("skill_desc")==null ? "":rs.getString("skill_desc");
			eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
			skill_expl_text=rs.getString("skill_expl_text")==null ? "":rs.getString("skill_expl_text");
			}
	
	}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		if (rs!= null)   rs.close();
		if (pstmt!= null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		}
	%>

<table cellpadding=0 cellspacing=0 border=0 width="98%" align='center'>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='4' maxlength='4' value="<%=skill_code%>" readonly name='skill_code' onkeypress="return CheckForSpecChars(event);" >
			<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
	<%if(eff_status.equals("E"))
		{
		%>
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=skill_desc%>" name='skill_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td  width='30%' align="right" class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;<textarea name="skill_expl_text"  rows='5'cols='40' onblur='checkForMax(this);'><%=skill_expl_text%></textarea>
		</tr>
		 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>
<% }else{ %>	
		<tr>
			<td class='label' width='30%' align='right'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td width='70%' align='left'>&nbsp;&nbsp;&nbsp;<input type='text' size='30' maxlength='30' value="<%=skill_desc%>" readonly name='skill_desc'><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td  width='30%' align="right" class="label"><fmt:message key="Common.ExplanatoryText.label"  bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;<textarea name="skill_expl_text" readonly rows='5'cols='40' maxlength='4000'><%=skill_expl_text%></textarea>
		</tr>
				 <tr><td colspan=2>&nbsp;</td></tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick='onenable(this);'></td>
		</tr>

	<% } %>
      	</table>
<%}%>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>	
</form>
</body>
</html>	

