<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//endss
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	String bean_name	= "ePH.PrescriptionBean_1";
	String bean_id=request.getParameter("bean_id");
	PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	//String order_remarks=(String)bean.getPresRemarks();
	String order_remarks=(String)bean.getPresRemarks()==null?"":(String)bean.getPresRemarks();	// Check  value  in order_remarks  for SRR20056-SCF-6664[IN026181]  
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prescription_remarks" id="prescription_remarks">
<table  border=0 align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 
 <td  class="label"><textarea cols="78" rows="10" name="order_remarks" id="order_remarks" onkeypress="return CheckRemMaxLen(<%=called_from%>)"  onblur=" CheckRemMaxLen(<%=called_from%>,'blr')"><%=order_remarks%></textarea><input type="hidden" value="<%=bean_id%>" name="bean_id" id="bean_id"><input type="hidden" value="<%=bean_name%>" name="bean_name" id="bean_name"></td><!-- removed java.net.URLDecoder.decode(order_remarks,"UTF-8") for SKR-SCF-0965 [IN:047665] -->
 
</tr>
</table>
</form>
<script>
document.prescription_remarks.order_remarks.focus();
</script>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

