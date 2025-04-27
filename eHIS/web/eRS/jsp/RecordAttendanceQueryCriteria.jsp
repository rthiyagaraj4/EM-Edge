<!DOCTYPE html>
<!-- RecordAttendance.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmky. k
*	Created On		:	29 Nov 2004
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 

<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
	<script language="javascript" src="../js/RecordAttendance.js"></script>
   	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/RSCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");
	String duration_to_mark = request.getParameter("duration_to_mark")==null?"":request.getParameter("duration_to_mark");
	String duration_to_mark_hh="";
	String duration_to_mark_mm="";
	if(duration_to_mark.equals("")){
		duration_to_mark_hh="00";
		duration_to_mark_mm="00";
	}else{
		duration_to_mark_hh=duration_to_mark.substring(0,2);
		duration_to_mark_mm=duration_to_mark.substring(3);
	}
	int int_duration_hh=Integer.parseInt(duration_to_mark_hh);
	int int_duration_mm=Integer.parseInt(duration_to_mark_mm);
	int max_duration_in_mints=(int_duration_hh*60)+int_duration_mm;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_RACriteria' id='form_RACriteria'>
	<table cellpadding=0 cellspacing=0 border='0' width="100%" align=center>
		<tr> 
			<td class='label' align='right' width='15%'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
			<td align='left' width='30%'><input type='text' name='workplace_desc' id='workplace_desc' value='' size='30' readonly><input type='button' class='button' value='?' name='workplace_lookup' id='workplace_lookup' onclick='showWorkplace(workplace_desc);'>&nbsp;<img src="../../eCommon/images/mandatory.gif">
			<input type='hidden' name='workplace_code' id='workplace_code' value=''></td>
			<td width='20%'>&nbsp;</td>
			<td class='label' align='right' width='10%'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align='left' width='20%'><select name='shift_code' id='shift_code' >
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select>
			<td width='20%'>&nbsp;</td>			
		</tr>
		<tr> 
			<td class='label' align='right' width='15%'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;</td>
			<td align='left' width='30%'><input type='text' name='staff_id' id='staff_id' value='' size='30' readonly><input type='button' class='button' value='?' name='staff_lookup' id='staff_lookup' onclick='listStaff(staff_id);display(role);'></td>
			<input type='hidden' name='staff_name' id='staff_name' value=''>
			<input type='hidden' name='role_type' id='role_type' value=''>
			<td width='20%' id='role' class='label'></td>
			<td colspan='3'>&nbsp;</td>
		</tr>
		<tr> 
			<td colspan='4'></td>
			<td width='20%' align='right'>
			<input type='button' class='button' value='<fmt:message key="eRS.ShowStaff.label" bundle="${rs_labels}"/>'name='show_staff' onclick='showStaff();'></td>
			<td width='20%' align='left'>&nbsp;&nbsp;<input type='button' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'name='clear' onclick='clearall();'></td>
		</tr>
	</table>
	<input type='hidden' value='<%=mode%>' name='mode'>
	<input type='hidden' value='<%=facility_id%>' name='facility_id'>
	<input type='hidden' value='<%=locale%>' name='locale'>
	<input type='hidden' value='<%=max_duration_in_mints%>' name='max_duration_in_mints'>
</form>
</body>
</html>

