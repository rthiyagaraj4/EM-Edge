<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>

<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/SkillForPosition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<%
	String form_name = request.getParameter( "form_name" ) ;
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formSkillForPositionHdr' id='formSkillForPositionHdr' target='messageFrame' >
<table border='1' cellpadding='0' cellspacing='0' align='center' width="100%">
<%
		if(form_name.equalsIgnoreCase("form_bySkill")){
%>
			<tr>
				<th align='left' width='15%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
				<th align='left' width='30%'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></th>
				<th align='left' width='35%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
				<th align='left' width='10%'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>
				<th align='left' width='15%' nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name=selectall value="" onclick='return click_selectall();'></th>
			</tr>
<%
		}
		else if(form_name.equalsIgnoreCase("form_byPosition")){
%>
			<tr>
				<th align='left' width='30%'><fmt:message key="eRS.Skill.label" bundle="${common_labels}"/></th>
				<th align='left' width='30%'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> <input type='checkbox' name=selectall value="" onclick='return click_selectall();'></th>
			</tr>
<% 
		}
%>
</table>
</form>
</body>
</html>

