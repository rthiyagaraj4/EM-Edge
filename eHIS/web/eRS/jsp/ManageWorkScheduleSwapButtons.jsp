<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleSwap.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body>
<form name="ManageWorkScheduleButtons_form" id="ManageWorkScheduleButtons_form" action='' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="103%" align='right'>
<tr>
<td>&nbsp;</td>
<td align='right'><INPUT TYPE="button" class='button' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onclick="apply()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onclick="resetVals()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'onclick="wincls()"></td>
</tr>
</table>
</form>
</body>
</html>

