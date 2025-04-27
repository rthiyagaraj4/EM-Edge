<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script src="../js/SkillForPosition.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode	   = request.getParameter( "mode" )==null?"":request.getParameter( "mode" );
	String skill ="";

	Connection con 	      = null;
	PreparedStatement pstmt	      = null;
	ResultSet rs		      = null;
	try{
		con = ConnectionManager.getConnection(request);
%>
	<body  onload='FocusFirstElement();' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="form_bySkill" id="form_bySkill">		
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>			
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="eRS.Skill.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<select name="skill_code" id="skill_code" onchange="skillchange()">
					<option value="" selected> &nbsp&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
<%
					//skill = "select skill_code, skill_desc from rs_skill where eff_status='E' order by skill_desc";
					skill = "select skill_code, skill_desc from rs_skill_lang_vw where eff_status='E' and language_id = ? order by skill_desc";
					pstmt =con.prepareStatement(skill);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next())
					{
					out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					}
					if (pstmt != null) pstmt.close();
					if (rs != null) rs.close();
%>					 
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="Common.Role.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<select name="role_type" id="role_type" onchange='populateStaffType()'>
					<option value="" selected> &nbsp&nbsp----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
					<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.OtherStaffType.label" bundle="${common_labels}"/></option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp</td>
			</tr>
			<tr>
				<td align="right" class="label" width="30%"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="70%">&nbsp;&nbsp;&nbsp;<select name="staff_type" id="staff_type" onchange="">
					<option value="" selected>&nbsp&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=button class=button value='<fmt:message key="eRS.ShowPositions.label" bundle="${rs_labels}"/>' name='show_posit' onclick='showPositionList();'>
				</td>
			</tr>
		</table>	
		<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
	</form>
</body>
<%
	}catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

