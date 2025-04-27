<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<form name="review_commprocess_image_form" id="review_commprocess_image_form" method="post" >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td width='20%'  class=label><img src='../../eCommon/images/dark_blue_square.jpg' width=40 height=15 > <fmt:message key="eXH.NoAction.Label" bundle="${xh_labels}"/></td>
<td width='20%'  class=label><img src='../../eCommon/images/yello_square.jpg' width=40 height=15 > <fmt:message key="eXH.WarmingUp.Label" bundle="${xh_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/green_square.jpg' width=40 height=15 > <fmt:message key="Common.Active.label" bundle="${common_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/pink_square.jpg' width=40 height=15 > <fmt:message key="eXH.AbouttoStop.Label" bundle="${xh_labels}"/></td> 
<td width='20%'  class=label><img src='../../eCommon/images/red_square.jpg' width=40 height=15 > <fmt:message key="eXH.Completed.Label" bundle="${xh_labels}"/></td> 
</tr>
</table>
</form>
</body>
</html>

