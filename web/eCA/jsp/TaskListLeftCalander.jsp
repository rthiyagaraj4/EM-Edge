<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.PatTaskListRepository,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='patTaskCalForm' id='patTaskCalForm'>
<%
//eCA.PatTaskListRepository patTask = (eCA.PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
eCA.PatTaskListRepository patTask =(eCA.PatTaskListRepository) session.getValue("patTask");

java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) property.getProperty("LOCALE");
String sysdate = "";
sysdate = patTask.getSysdateTime();
sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale);
%>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
<td class='fields' width='25%'><INPUT TYPE="Text" name="toDate" id="toDate" id='toDate' size='16' maxlength='16' OnBlur='CheckDateTime(this);toDateChecknew(fromDate,this,"DMYHM","<%=locale%>")' value='<%=sysdate%>'></td>
</tr>
</table>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
<td class='label'>Sun</td>

</tr>
</table>
</form>
</body>
</html>
<%putObjectInBean("patTask",patTask,request);	%>


