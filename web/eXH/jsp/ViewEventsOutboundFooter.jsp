<!DOCTYPE html>
<HTML>

<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<HEAD> 
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String function_id = (String)request.getParameter("function_id");

//Properties p = (Properties) session.getValue("jdbc");
//String loggedUser = p.getProperty("login_user");
String commType = request.getParameter("commType");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ViewEventsFooter.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
 
<form name="application_setup_base_form" id="application_setup_base_form"  method="POST"   action=''>

<table width="100%">
<% if(commType != null && !commType.equalsIgnoreCase("inbound")) { %>
<th class='COLUMNHEADER' align=left COLSPAN=5>
<fmt:message key="Common.EventStatus.label" bundle="${common_labels}"/>($)
</th>
<tr>
<td align=left class=label width="15%">
<img src='../../eXH/images/blue_square.jpg' width=40 height=15> <fmt:message key="eXH.Unprocessed.Label" bundle="${xh_labels}"/>&nbsp;
</td>
<td align=left class=label width="20%">
<img src='../../eXH/images/green_square.jpg' width=40 height=15> <fmt:message key="eXH.SuccessfullyProcessed.Label" bundle="${xh_labels}"/>&nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/red_square.jpg' width=40 height=15> <fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/yello_square.jpg' width=40 height=15 ><fmt:message key="eXH.AbouttoSplit.Label" bundle="${xh_labels}"/> 
</td>
<!-- <img src='../../eXH/images/black_square.jpg' width=40 height=15 > Not Required&nbsp; -->
</tr>

<%}else{%>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<%}%>
<th class='COLUMNHEADER' align=left COLSPAN=5><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/>(#)</th>
<tr>
<td align=left class=label width="15%">
<% if(commType != null && commType.equalsIgnoreCase("inbound")) { %>
<!-- <img src='../../eXH/images/blue_square.jpg' width=40 height=15> Pending&nbsp; -->
<img src='../../eXH/images/green_square.jpg' width=40 height=15> <fmt:message key="eXH.LoadedSuccessfully.Label" bundle="${xh_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/red_square.jpg' width=40 height=15> <fmt:message key="eXH.ErrorInLoading.Label" bundle="${xh_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/yello_square.jpg' width=40 height=15> <fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/black_square.jpg' width=40 height=15> <fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;
<%}else{%>
<img src='../../eXH/images/blue_square.jpg' width=40 height=15> <fmt:message key="Common.Pending.label" bundle="${common_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/green_square.jpg' width=40 height=15> <fmt:message key="eXH.Communicated.Label" bundle="${xh_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/red_square.jpg' width=40 height=15> <fmt:message key="eXH.TransmissionError.Label" bundle="${xh_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/darkgreen.jpg' width=40 height=15> <fmt:message key="Common.Accept.label" bundle="${common_labels}"/>&nbsp;</td>
<td align=left class=label width="15%"><img src='../../eXH/images/black_square.jpg' width=40 height=15> <fmt:message key="Common.Rejected.label" bundle="${common_labels}"/>&nbsp;
<%}%>
</td>
</tr>
<tr><td class='COLUMNHEADER' COLSPAN=5></td></tr>
</table>

</form>
</body>
</html>

