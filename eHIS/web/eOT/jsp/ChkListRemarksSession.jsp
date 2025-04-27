<!DOCTYPE html>
<% //"java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*, java.io.*" 
%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<% request.setCharacterEncoding("UTF-8"); %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language = 'javascript'>
 
 function submit1()
 {
	 document.forms[0].submit();
 }

</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ChecklistRemarksSession" id="ChecklistRemarksSession"  action="../../eOT/jsp/ChkListRemarksSession.jsp" method ="post">



<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% 
  String previous_remarks =checkForNull(request.getParameter("previous_remarks"));
  String checklist_remarks =checkForNull(request.getParameter("checklist_remarks"));
  String mode = checkForNull(request.getParameter("mode"));

    if (mode.equals("LOAD")== true)
	{
	      session.putValue("previous_remarks",previous_remarks);
		  session.putValue("checklist_remarks",checklist_remarks);	
		  System.err.println("eOT checklist remarks are inserted 123");
    }
	else  if (mode.equals("UNLOAD")== true)
	{
		  session.putValue("previous_remarks",null);
		  session.putValue("checklist_remarks",null);	
	}	
	
%>
<input type='hidden' name='previous_remarks' id='previous_remarks' value="">
<input type='hidden' name='checklist_remarks' id='checklist_remarks' value="">
<input type='hidden' name='mode' id='mode' value="">

</form>
</body>

