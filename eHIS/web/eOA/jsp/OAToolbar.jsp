<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %> 
<html>
<head>
<title><fmt:message key="eOA.CreateAppointmentWaitList.label" bundle="${oa_labels}"/></title>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> 
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>   
        <script language='javascript' src='../../eOA/js/ApptWaitList.js'></script>
</head>

<script>

function onApply() {
		//parent.commontoolbarFrame.location.href='../../eCommon/html/process.html';
		//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		
			parent.apply() ;

		}

function onReset() {
		
			parent.reset() ;

		}
	</script>
</head>
<%
request.setCharacterEncoding("UTF-8");
String calling_mode=request.getParameter("calling_mode");
String from=request.getParameter("from");
if(calling_mode ==null) calling_mode="";
if(from ==null) from="";

%>
<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown = 'lockKey()'>

<form name="CommonToolbar_form" id="CommonToolbar_form">
<table width="100%" cellspacing='0' cellpading='0'>
	<tr class="COMMONTOOLBARFUNCTION">
		<td align="left" class="COMMONTOOLBARFUNCTION">
			<fmt:message key="eOA.CreateAppointmentWaitList.label" bundle="${oa_labels}"/>
		</td>
	</tr>
	<tr class="COMMON_TOOLBAR">
		<td class="COMMON_TOOLBAR">
			<table width="100%" cellspacing='0' cellpading='0'>
				<tr class="COMMON_TOOLBAR">
					<td class="COMMON_TOOLBAR" align="left" width="50%">
						<table cellspacing='0' cellpading='0'>
							<tr class="COMMON_TOOLBAR">


								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onApply();" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' name='apply' class='BUTTON'></input>

								</td>
								<%if(calling_mode.equals("") && from.equals("ScheduleAppt")) {								 
									%>
								<td class="COMMON_TOOLBAR">
									<input type='button' onclick="onReset();" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' name='reset' class='BUTTON'></input>

								</td>
									<%}%>
								<!-- <td class="COMMON_TOOLBAR">
									<input type='button' onclick="parent.close();"value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' name='home' class='BUTTON'></input>
								</td> -->

							</tr>
						</table>
					</td><td class='label'>&nbsp;</td>

				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>

