<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<title><fmt:message key="eCA.PerformedDetails.label" bundle="${ca_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name='patTaskListPerformForm' id='patTaskListPerformForm' action='../../servlet/eCA.PatTaskListServlet' method='post' target='messageFrame'>
<%
String status = request.getParameter("status")==null ? "" :request.getParameter("status");
String dateTime =request.getParameter("dateTime")==null ? "" :request.getParameter("dateTime");

String task  =request.getParameter("task")==null ? "" :request.getParameter("task");
String taskType  =request.getParameter("taskType")==null ? "" :request.getParameter("taskType");
String patientId =request.getParameter("patientId")==null ? "" :request.getParameter("patientId");
String pract_type =(String) session.getValue("practitioner_type");
String taskSrlNo =request.getParameter("taskSrlNo")==null ? "" :request.getParameter("taskSrlNo");
String sysdate = patTask.getSysdate();
String performedId=request.getParameter("performedId")==null ? "" :request.getParameter("performedId");
String detail  =request.getParameter("detail")==null ? "" :request.getParameter("detail");
String readOnly ="";
if(!detail.equals(""))
{
	readOnly="ReadOnly";
}
try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		String practitioner_id ="";
		practitioner_id = (String) session.getValue("ca_practitioner_id");
		String name="";
		if(performedId.equals(""))
		{
			name	=(String)session.getValue("practitioner_name");
		}
		else
		{
			name = performedId;
		}

		String remarks= "";
		if(!status.equals(""))
		{

				if(status.equals("P"))
				{
						remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
					
		
%>

<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%">
	<tr>
		<td colspan='4'align='right' class='label'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<td align='left'>	
				<INPUT TYPE="text" name="dateTime" id="dateTime" value='<%=dateTime%>' size='20' maxlength='16' OnBlur='checkForCurrentDate();CheckDateTime(this);' <%=readOnly%>>
				<%if(detail.equals("")){ %>
				<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('dateTime')">		
				<img align=center src='../../eCommon/images/mandatory.gif' ></img>
				<%}%>		
		</td>
	</tr>
	<tr>
		<td colspan='4'align='right' class='label'>	
			<fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/>
		</td>
		<td align='left'>	
				<INPUT TYPE="text" name="practitonerName" id="practitonerName" value='<%=name%>' size='20' maxlength='16' readOnly>
				<INPUT TYPE="hidden" name="practitonerId" id="practitonerId" value='<%=practitioner_id%>'>

				<INPUT TYPE="hidden" name="locale" id="locale" value='<%=locale%>'>

				<%if(detail.equals("")){ %>
				<input type='button' class='button' name='buttonPractitioner' id='buttonPractitioner' value='?' OnClick='getPractitioner()' >
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
				<%} %>
		</td>
	</tr>
	<tr>
		<td colspan='4'align='right' class='label'>	
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp; 
		</td>
		<td align='left'>	

				<TEXTAREA NAME="remarks" ROWS="3" COLS="50" <%=readOnly%> OnKeyDown='return checkTheLength(this)' ><%=remarks%></TEXTAREA>
					<%if(detail.equals("")){ %>
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
					<%} %>
		</td>
	</tr>
	<tr>
	<td colspan='6'>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>	
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'>
		<%if(detail.equals("")){ %>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' OnClick='recording()'>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%}else
		{
		%>
		<input type='button' name='buttonClose' id='buttonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%
		}
		%>

	</td>
	</tr>
	
</table>

<%			}
				else
				{
					remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
		
%>
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" >

	<%if(!detail.equals("")){ %>
	<tr>

	<td colspan='4'align='right' class='label'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/>	</td>
	<td align='left'><INPUT TYPE="text" name="dateTime" id="dateTime" value='<%=dateTime%>' size='20' maxlength='16'  readOnly></td>
	</tr>
<%} 
%>
		<tr>
		<td colspan='4'align='right' class='label'><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
		<td align='left'>	
				<INPUT TYPE="text" name="practitonerName" id="practitonerName" value='<%=name%>' size='<%=name.length()%>' maxlength='16'  readOnly>
				<INPUT TYPE="hidden" name="practitonerId" id="practitonerId" value='<%=practitioner_id%>'>
			<%if(detail.equals("")){ %>
				<!-- <input type='button' class='button' name='buttonPractitioner' id='buttonPractitioner' value='?' OnClick='getPractitioner()'><img align=center src='../../eCommon/images/mandatory.gif'></img> -->
			<%}%>
		</td>
	</tr>
	<tr>
		<td colspan='4'align='right' class='label'>	
			<fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;&nbsp; 
		</td>
			<td align='left'>	
				<TEXTAREA NAME="remarks" ROWS="3" COLS="50" <%=readOnly%> OnKeyDown='return checkTheLength(this)' STYLE="overflow:hidden"><%=remarks%></TEXTAREA>
				<%if(detail.equals("")){ %>
			<img align=center src='../../eCommon/images/mandatory.gif'></img>
			<%}%>
		</td>
	</tr>
	
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>	
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'>
		<%if(detail.equals("")){ %>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' OnClick='recording()'>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%}else
		{
		%>
		<input type='button' name='buttonClose' id='buttonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%
		}
		%>



	</td>
	</tr>

</table>
<%			}
		}
%>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception from PatTaskListPerform.jsp :"+ee.toString());//COMMON-ICN-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
%>
<INPUT TYPE="hidden" name="status" id="status" value='<%=status%>'>
<INPUT TYPE="hidden" name="patientId" id="patientId" value='<%=patientId%>'>
<INPUT TYPE="hidden" name="taskCode" id="taskCode" value='<%=taskType%>'>
<INPUT TYPE="hidden" name="taskType" id="taskType" value='<%=task%>'>
<INPUT TYPE="hidden" name="pract_type" id="pract_type" value='<%=pract_type%>'>
<INPUT TYPE="hidden" name="sysdate" id="sysdate" value='<%=sysdate%>'>
<INPUT TYPE="hidden" name="taskSrlNo" id="taskSrlNo" value='<%=taskSrlNo%>'>
</form>
</body>
</html>

