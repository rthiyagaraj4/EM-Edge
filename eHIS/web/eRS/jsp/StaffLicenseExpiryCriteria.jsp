<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	18 Oct 2004
-->
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
 <head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js' ></script>		
<!-- <script language='javascript' src='../../eCommon/js/messages.js' ></script> -->
<script language='javascript' src='../../eRS/js/StaffLicenseExpiry.js'></script>
<!-- <script language='javascript'src='../../eRS/js/RSMessages.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>	
		function ChangeType(form,target)
		{
			var role_type=target.value;
			if(role_type=="role_type")
			
			document.forms[0].role_type.value='';
					removeitems(form.staff_type);

					var HTMLVal = "<HTML><HEAD></HEAD><BODY CLASS='MESSAGE'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eRS/jsp/StaffLicenseExpiryFetchStaffType.jsp'>";
					HTMLVal = HTMLVal +"<input name='role_type' id='role_type' type='hidden' value= '"+role_type +"'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.forms[0].submit();

		}

		function removeitems(obj)
			{
				var len=obj.length;
				var i=1;
				while(i<len)
				{
					len=obj.length
					obj.remove(i)
				}
			}

		</script>
	</head>		
	<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=form_StaffLicenseExpiry >
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="98%">
				<tr>
					<td align="right" class="label" width="5%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
					<td align="left"  width="15%">&nbsp;
						<select name="role_type" id="role_type" onChange='ChangeType(this.form,this)'>
							<option value="" selected>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
							<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
							<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
						</select>					
					</td>	
					<td align="right" width="5%" class="label"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
					<td align="left" width="15%">&nbsp;
						<select name="staff_type" id="staff_type">
							<option value="" selected>-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
					</td>
				</tr>
				<tr>
					<td width="5%" class="label" align="right"><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></td>
					<td width="15%" align="left">&nbsp;&nbsp;<input type="text"  name=staff_id size="20" maxlength="15" onKeyPress="return CheckForSpecChars(event)"  value='' readonly><input type=button class=button value='?' name='staff_lookup' id='staff_lookup' onclick='ViewStaffDetails(staff_id)'></td>
					<td width="5%" class="label" align="right">&nbsp;&nbsp;<fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></td>
					<td width="15%"  align="left">&nbsp;&nbsp;<input type="text" name="staff_name" id="staff_name" value="" readonly size='30'></td>
				</tr>
				<tr>
					<td width="5%" class="label" align="right"><fmt:message key="eRS.ExpiringWithin.label" bundle="${rs_labels}"/></td>
					<td width ="15%" align="left" class="label">&nbsp;&nbsp;<input type="text" name="expiring_within" id="expiring_within" size="4" maxlength="3"  onkeypress="return allowPositiveNumber();"><font color="navy">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></font>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
					<td width="10%" align="right"></td>
					<td width="15%" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'name='search_lookup' onclick='searchstaff()'></td>
			</tr>
</body>
</html>

