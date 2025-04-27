<!DOCTYPE html>
<HTML>
 
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle	="IeStyle.css";
//String function_id = (String)request.getParameter("function_id");


//String loggedUser = p.getProperty("login_user");

%> 

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ViewEventsFooter.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
 
<form name="application_setup_base_form" id="application_setup_base_form"  method="POST"   action=''>

<table width="100%">
<tr>
<td class='COLUMNHEADER' colspan=24 align=left><fmt:message key="eXH.QueryStatus.Label" bundle="${xh_labels}"/>($)</td>
</tr>
<tr> 
<td align=left class=label colspan=24>
<img src='../../eXH/images/green_square.jpg' width=40 height=15><fmt:message key="Common.Response.label" bundle="${common_labels}"/> <fmt:message key="eXH.Processed.Label" bundle="${xh_labels}"/>&nbsp;
<img src='../../eXH/images/red_square.jpg' width=40 height=15> <fmt:message key="eXH.ProcessingError.Label" bundle="${xh_labels}"/>&nbsp;
<img src='../../eXH/images/black_square.jpg' width=40 height=15 > <fmt:message key="Common.received.label" bundle="${common_labels}"/>&nbsp;  
<img src='../../eXH/images/yello_square.jpg' width=40 height=15 > <fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></td> 
</tr> 
 
<tr>
<td class='COLUMNHEADER' colspan=24 align=left><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/>(#)</td>
</tr>
<tr>
<td align=left class=label colspan=24>
<img src='../../eXH/images/green_square.jpg' width=40 height=15> <fmt:message key="eXH.CommSuccessfully.Label" bundle="${xh_labels}"/>&nbsp;
<img src='../../eXH/images/red_square.jpg' width=40 height=15> <fmt:message key="eXH.ErrorComm.Label" bundle="${xh_labels}"/>&nbsp;
<img src='../../eXH/images/yello_square.jpg' width=40 height=15> <fmt:message key="eXH.PendingComm.Label" bundle="${xh_labels}"/>&nbsp;
</tr>
<tr><td class='COLUMNHEADER'></td></tr>
</table>

</form>
</body>
</html>

