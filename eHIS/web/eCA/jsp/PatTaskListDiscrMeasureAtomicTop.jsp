<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
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
<form name='PatTaskListPerformTopForm' id='PatTaskListPerformTopForm'>
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" >
<%

	
			 Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");

	String queryString = request.getQueryString();
	
	String taskType = patTask.checkForNull(request.getParameter("task"));
	String task = patTask.checkForNull(request.getParameter("taskType"));
	ArrayList retArray = patTask.getInterventionType(task,taskType,request,locale);
	try
	{
%>
<tr>
<td  colspan='4' class='label' align='left' width='100%' >
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.InterventionType.label" bundle="${common_labels}"/>&nbsp;
<%
if(retArray  != null)
{
	out.println("<input type='text' name='taskType' id='taskType' value='"+retArray.get(1).toString()+"' size='30' readOnly>");
}
%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Intervention&nbsp;
<%
if(retArray  != null)
{
	out.println("<input type='text' name='taskType' id='taskType' value='"+retArray.get(0).toString()+"' size='30' readOnly>");
}
%>
</td>
</tr>
 <tr>
 <td class='label' colspan='2' align='right' width='18%'>
 <fmt:message key="eCA.GuideLines.label" bundle="${ca_labels}"/>
 </td>
<td colspan='2' align ='left' class='label'  valign='top' id='td' width='82%'>
&nbsp;
<textarea cols='75' rows='3' readOnly>
<%
if(retArray  != null)
{
	out.println(retArray.get(2).toString());
}
%>
</textarea>
</td> 
</tr>
<tr>
<td colspan='4' width='100%' align='left' class='label'>
		&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.ActionType.label" bundle="${common_labels}"/>&nbsp;
	<fmt:message key="Common.Performed.label" bundle="${common_labels}"/>
<input type='radio' name='status' id='status' value='P' OnClick='loadPerformForAtomic(this.value)' checked>
	Not Performed 
<input type='radio' name='status' id='status' value='N' OnClick='loadPerformForAtomic(this.value)'>
</td>
</tr>
<tr>
<td colspan='4' width='100%' align='center'>
&nbsp;
</td>
</tr>
<input type='hidden' name='queryString' id='queryString' value='<%=queryString%>'>
<script>
loadPerformForAtomic(document.forms[0].status[0].value)
</script>
</form>
</table>
</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception @ PatTaskListDiscrMeasureAtomicTop.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	retArray.clear();
}
%>

