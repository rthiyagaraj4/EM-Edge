<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eRS/js/RSMessages.js"></script>
	<script language="javascript" src="../js/OtherStaffType.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
  	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
request.setCharacterEncoding("UTF-8");
	String mode = request.getParameter("mode");
    String OTHER_STAFF_TYPE = "";
	String LONG_DESC = "";
	String SHORT_DESC = "";
	String EFF_STATUS = "";
	String readonly = "";
	String checked = "";
	String readonly1="";
	String operation_type = "";
	String eventFunctionForCase="";


	if(mode.equals("2")){
		operation_type = "modify";
		OTHER_STAFF_TYPE = request.getParameter("OTHER_STAFF_TYPE");
		LONG_DESC = request.getParameter("LONG_DESC");
		SHORT_DESC = request.getParameter("SHORT_DESC");
		EFF_STATUS = request.getParameter("EFF_STATUS");
		readonly1="readOnly";
		if(EFF_STATUS.equalsIgnoreCase("E")){
			readonly = "";
			checked	=	"checked";
		}
		else{
			readonly = "readOnly";
			checked	="";
		}
	}
else
{
	operation_type="insert";
	eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	checked = "CHECKED";
}
	%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement();">

<form name='form_AddModifyOtherStaffType' id='form_AddModifyOtherStaffType'  action='../../servlet/eAM.OtherStaffTypeServlet'  method='post' target='messageFrame'>
	<br><br><br><br><br><br><br><br>
	<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
			<tr><td colspan='2' class="label">&nbsp;</td></tr>
			<tr>
				<td class='label' width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>		
				<td class='fields' width='50%'  align='left'>
				<input type=text  name='StaffTypeCode' id='StaffTypeCode' size=2 value='<%=OTHER_STAFF_TYPE%>' maxlength='2' <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event);" onBlur=" makeValidString(this); " <%=readonly1%>><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			</tr>
			<tr><td colspan='2' class="label">&nbsp;</td></tr>
			<tr>
				<td class='label' width='50%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>		
				<td class="fields" width='50%'>
				<input type=text name='LongDescription' id='LongDescription' size='35' value='<%=LONG_DESC%>' maxlength='30' <%=readonly%> onBlur='makeValidString(this);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			</tr>
			<tr><td colspan='2' class="label">&nbsp;</td></tr>
			<tr>
				<td class='label' width='50%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>		
				<td class="fields" width='50%'>
				<input type=text name='ShortDescription' id='ShortDescription' size='18' value='<%=SHORT_DESC%>' maxlength='15' <%=readonly%> onBlur='makeValidString(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			</tr>
			<tr><td colspan='2' class="label">&nbsp;</td></tr>
			<tr>
				<td class='label' width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class="fields" width='50%'>
				<input type=checkbox name='eff_status' id='eff_status' value='<%=EFF_STATUS%>' onclick='checkActive(this)' <%=checked%>></td>
			</tr>
			<tr><td colspan='2' class="label">&nbsp;</td></tr>
		</table>

		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='operation_type' id='operation_type' value='<%=operation_type%>'>
	</form>
</body>
</html>

