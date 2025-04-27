<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<%
	String bean_id				= "ReleaseBatchesBean";
	String bean_name			= "ePH.ReleaseBatchesBean";
	ReleaseBatchesBean bean		= (ReleaseBatchesBean)getBeanObject( bean_id,bean_name,request);
    bean.setLanguageId(locale);
	String order_id				= request.getParameter("order_id");
	String ord_line_no			= request.getParameter("ord_line_no");	
	String disp_no				= request.getParameter("disp_no");	
	
	ArrayList batch_dtls		= bean.getBatchDetails(order_id,ord_line_no);
	String classValue			=	"";

%>
<form name="formReleaseBatchesDtls" id="formReleaseBatchesDtls">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<tr>
	<td class='COLUMNHEADER' ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
</tr>
<% for(int i=0; i<batch_dtls.size(); i+=4) { 
			if(i%2==0)
			classValue = "QRYEVENSMALL";
		else
			classValue = "QRYODDSMALL";
%>
  <tr>
  <td class="<%=classValue%>"><%=disp_no%></td>
  <td class="<%=classValue%>"><%=(String)batch_dtls.get(i)%></td>
  <td class="<%=classValue%>"><%=(String)batch_dtls.get(i+1)%></td>
  <td class="<%=classValue%>"><%=com.ehis.util.DateUtils.convertDate((String)batch_dtls.get(i+2),"DMY","en",locale)%></td>
  <td class="<%=classValue%>"><%=(String)batch_dtls.get(i+3)%></td>
  </tr>
<% 	} 
%>
</table>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

