<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode			= request.getParameter( "mode" ) ;
	String bean_id		= "problem_stage" ;
	String bean_name	= "ePH.ProblemStage";
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ProblemStage bean =
	(ProblemStage)getBeanObject(bean_id,bean_name,request );  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

%>

<form name='Problem_Stage_header' id='Problem_Stage_header' target='messageFrame' >
<BR>

<table cellpadding=0 cellspacing=0 border=0 width='80%'  align='center'>

<tr>
	<td colspan="2">&nbsp;</td>
</tr>


<tr>
	<td align="right" class="label" ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td align="left"  >&nbsp;<select name="indicator" id="indicator"><option>&nbsp;&nbsp;&nbsp;&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;&nbsp;&nbsp;&nbsp;</option><option value="O" selected><fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></option></select>
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>



<tr>
	<td colspan="2">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

