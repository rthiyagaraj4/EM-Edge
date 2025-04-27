<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleWeekButtons.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id	= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	int week_count =Integer.parseInt(request.getParameter("week_count"));
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=formButtons>
		<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
			<tr><td width='13%'>&nbsp;</td>
			<% for(int i=0; i<week_count; i++){%>
				<td width='7%'><input type='button' class='button' name='week<%=i%>' id='week<%=i%>' value='Week<%=i+1%>' onclick='showWeek(<%=i+1%>);'></td>
			<%}%>
			<td align ='right'><input type='button' class='button' name='allweeks' id='allweeks' value='<fmt:message key="eRS.AllWeeks.label" bundle="${rs_labels}"/>'onclick='showAllWeek();'></td>
			<td width='2%'>&nbsp;</td>
			</tr>
		</table>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
		<input type='hidden' name='requirement_id' id='requirement_id' value='<%=requirement_id%>'>
		<input type='hidden' name='locn_type' id='locn_type' value='<%=locn_type%>'>
		<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
		<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
		<input type='hidden' name='position_code' id='position_code' value='<%=position_code%>'>
		<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
		<input type='hidden' name='view' id='view' value='<%=view%>'>
		<input type='hidden' name='week_count' id='week_count' value='<%=week_count%>'>
	</form>
</body>
</html>

