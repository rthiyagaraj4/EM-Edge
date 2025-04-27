<!DOCTYPE html>
<html>
<%@page import="java.util.*,eCA.PatTaskListRepository" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
<FORM name='patTaskListIntermediateForm' id='patTaskListIntermediateForm'>
<%
try
{
	String flagString = patTask.checkForNull(request.getParameter("flag"));
	
	boolean flag = false;

	flag = patTask.getPatientId(request,flagString);
	
	if(flag== true)
	{
				if(!flagString.equals("Patient"))		
				{
				out.println("<script>parent.patTaskListCriteriaFrame.document.getElementById('imgLocation').style.display='none'</script>");
					//imgLocation
				}
	}
	else
	{
	if(flagString.equals("Patient"))
		{	
//			out.println("<script>var msg = getMessage('INVALID_VALUE','COMMON')</script>");
//			out.println("<script>msg = msg.replace('#','PATIENT')</script>");;
//			out.println("<script>alert(msg)</script>");
//			out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.PatientId.value=''</script>");
		}
		else
		{
				
//			out.println("<script>alert(getMessage('ENCOUNTER_ID_INVALID','CA'))</script>");
//			out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.encounterId.value=''</script>");
			
			

		}	
	}
%>	
<%
}
catch(Exception ee)
{
	ee.printStackTrace() ;
}
%>
</form>
</html>

