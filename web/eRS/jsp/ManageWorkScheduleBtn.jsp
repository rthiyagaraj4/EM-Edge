<!DOCTYPE html>
<%
/*
 *	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
 *	Application		:	eRS
 *   File Name		:	ManageWorkScheduleBtn.jsp
 *	Purpose 		:	To display the Back Button & the Navigation Buttons
 *	Created By		:	Subbulakshmy. K
 *	Created On		:	24-11-2004
 */
%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../js/ManageWorkSchedule.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	String groupby				=request.getParameter("groupby")==null?"":request.getParameter("groupby");
	String from_date				=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date				=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String new_fromdate=request.getParameter("new_from_date")==null?"":request.getParameter("new_from_date");
	String new_todate= request.getParameter("new_to_date")==null?"":request.getParameter("new_to_date");
	String onclick_of				=request.getParameter("onclick_of")==null?"":request.getParameter("onclick_of");
	String productive_flag=request.getParameter("productive_flag")==null?"W":request.getParameter("productive_flag");
	int DAYS=Integer.parseInt(request.getParameter("DAYS")==null?"0":request.getParameter("DAYS"));
	System.err.println("facility_id in managebtn jsp--->" +facility_id);
	System.err.println("user_id--->" +user_id);
	System.err.println("function_id--->" +function_id);
	System.err.println("role_type--->" +role_type);
	System.err.println("staff_type--->" +staff_type);
	System.err.println("role_type--->" +role_type);
	System.err.println("locn_type--->" +locn_type);
	System.err.println("position_code--->" +position_code);
	System.err.println("staff_id--->" +staff_id);
	System.err.println("view--->" +view);
	System.err.println("groupby--->" +groupby);
	System.err.println("from_date--->" +from_date);
	System.err.println("to_date--->" +to_date);
	System.err.println("new_fromdate--->" +new_fromdate);
	System.err.println("new_todate--->" +new_todate);
	System.err.println("onclick_of--->" +onclick_of);
	System.err.println("productive_flag--->" +productive_flag);
	System.err.println("DAYS--->" +DAYS);
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name='formManageWorkScheduleBtn' id='formManageWorkScheduleBtn' >
		<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
			<tr>		
				<input type='hidden' name='p_from_date' id='p_from_date' value='' >
				<input type='hidden' name='p_to_date' id='p_to_date' value='' >
				<input type='hidden' name='p_next_direction' id='p_next_direction' value='F' >
				<input type='hidden' name='p_prev_direction' id='p_prev_direction' value='B' >
				<input type='hidden' name='p_end' id='p_end' value='' >
				<input type='hidden' name='DAYS' id='DAYS' value='<%=DAYS%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
				<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
				<input type='hidden' name='locn_type' id='locn_type' value='<%=locn_type%>'>
				<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
				<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
				<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
				<input type='hidden' name='position_code' id='position_code' value='<%=position_code%>'>
				<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
				<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'>
				<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'>
				<input type='hidden' name='view' id='view' value='<%=view%>'>
				<input type='hidden' name='groupby' id='groupby' value='<%=groupby%>'>
				<input type='hidden' name='onclick_of' id='onclick_of' value='<%=onclick_of%>'>
				<td width='10%' class='BELOWOPTIMAL' align='center'><fmt:message key="eRS.BelowOptimal.label" bundle="${rs_labels}"/></td>
				<td width='10%' class='OPTIMAL' align='center'><fmt:message key="eRS.Optimal.label" bundle="${rs_labels}"/></td>
				<td width='10%' class='ABOVEOPTIMAL' align='center'><fmt:message key="eRS.AboveOptimal.label" bundle="${rs_labels}"/> </td>
				<td width='10%' class='StaffOtherWP' align='center'><fmt:message key="eRS.ExternelWorkplace(s).label" bundle="${rs_labels}"/></td>
				<td width='10%' class='LeaveStaff' align='center'><fmt:message key="eRS.Unavailability.label" bundle="${rs_labels}"/></td>
				<td align='right' width='15%'><input type='button' name='back' id='back' value='<--' onClick="moveBack()" class='button' style='font-size=8pt;'><input type='button' name='forward' id='forward' value='-->' onClick='moveNext()' class='button' style='font-size=8pt;'></td>
				<td width='2%'>&nbsp;</td>
</tr>
</table>
</form>
<script>
parent.frames[1].location.href='../../eRS/jsp/ManageWorkScheduleHdr.jsp?facility_id=<%=facility_id%>&user_id=<%=user_id%>&function_id=<%=function_id%>&workplace_code=<%=workplace_code%>&locn_type=<%=locn_type%>&role_type=<%=role_type%>&staff_type=<%=staff_type%>&position_code=<%=position_code%>&staff_id=<%=staff_id%>&view=<%=view%>&groupby=<%=groupby%>&from_date=<%=from_date%>&to_date=<%=to_date%>&new_from_date=<%=new_fromdate%>&new_to_date=<%=new_todate%>&onclick_of=<%=onclick_of%>&productive_flag=<%=productive_flag%>&DAYS=<%=DAYS%>';
</script>
</body>
</html>

