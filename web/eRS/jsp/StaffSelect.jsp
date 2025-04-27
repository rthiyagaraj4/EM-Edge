<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmy. K
*	Created On		:	18 Oct 2004-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	String mode	   = request.getParameter("mode") ;
	String function_id = request.getParameter( "function_id") ;
%>
<%request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
 <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
		<script language='javascript' src='../../eCommon/js/common.js' ></script>
  		<script language='javascript' src='../../eRS/js/StaffProfile.js'></script>
		<!-- <script language='javascript' src='../../eCommon/js/messages.js' ></script>
		<script language='javascript'src='../../eRS/js/RSMessages.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>		
	<body  onload='FocusFirstElement()' onMouseDown="" onKeyDown="lockKey()" >
		<form name="form_selectStaff" id="form_selectStaff">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td align="right" class="label" width="15%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
				<td align="left" class="label" width="35%">&nbsp;&nbsp;
				<select name="role_type" id="role_type" onchange="listStaffType(staff_name);">
					<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
					<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>			
				<td align="right" class="label" width="10%"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
				<td align="left" class="label" width="15%">&nbsp;&nbsp;
				<select name="staff_type" id="staff_type" onchange="clearIdName(staff_name);">
					<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				</select>
				</td>
				<td align='center' width="*%">
					<input type=button class=button value='<fmt:message key="eRS.ShowDetails.label" bundle="${rs_labels}"/>'onclick='showdetails()'>
				</td>
			</tr>
				<tr>
					<td colspan="5">&nbsp</td>
				</tr>
				<tr>
					<td align="right" class="label" width="15%"><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></td>
					<td align="left" class="label" width="35%">&nbsp;&nbsp;
						<input type=text name="staff_id" id="staff_id" size=20 maxlength=15 value=''  readonly><input type=button class=button value='?' name='staffid_lookup' id='staffid_lookup' onclick='viewstaff(staff_id, staff_name);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
					</td>
					<td align="right" class="label" width="10%"><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></td>
					<td  id='staff_name' align="left" class="label" width="15%">
						<!-- <input type=text name="staff_name" id="staff_name" size=20 maxlength=15 readonly> -->						
					</td>
					<td align='center' width="*%">
						<input type=button class=button value='<fmt:message key="eRS.ShowProfile.label" bundle="${rs_labels}"/>'onclick='showprofile()'>
					</td>
				</tr>
				</table>				
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			</form>
		</body>
	</html>

