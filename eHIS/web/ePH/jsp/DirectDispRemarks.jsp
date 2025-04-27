<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String bean_id      = "DirectDispensingBean" ;
	String bean_name    = "ePH.DirectDispensingBean";
	DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
	String order_remarks=(String)bean.getPresRemarks();

%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_remarks" id="prescription_remarks">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
 <td  class="label"><textarea cols="78" rows="10" name="order_remarks"><%=order_remarks%></textarea><input type="hidden" value="<%=bean_id%>" name="bean_id"><input type="hidden" value="<%=bean_name%>" name="bean_name"></td>
</tr>
</table>
</form>
<script>
document.prescription_remarks.order_remarks.focus();
</script>
</body>
</html>

