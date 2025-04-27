<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
	<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/PhMessages.js"></script>
    <script language="javascript" src="../js/RegPrescriptions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>

    </script>
	</head>	
	<%
		String	bean_id			=	"RegPrescriptionsBean" ;
		String	bean_name		=	"ePH.RegPrescriptionsBean";
		
   		RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject(bean_id,bean_name ,request) ;
		
		String patient_id = request.getParameter("patient_id");
		    if(patient_id == null) patient_id = "";
		String order_date_from = request.getParameter("order_date_from");
			if(order_date_from == null) order_date_from = "";
		String order_date_to = request.getParameter("order_date_to");
			if(order_date_to == null) order_date_to = "";
		String token_no = request.getParameter("token_no");
			if(token_no == null) token_no = "";
		
		/*String token_serial_no	=	"";
		String queue_date	 =	 "";
		String order_id	=	"";
		String order_line_num	=	"";	
		String order_catalog_code	 =	 "";
		String drug_name = "";
		String disp_locn	 =	 "";
		String storage_locn	=	"";
		String order_status	=	"";
		String token_status	=	"";*/
	//	ArrayList records = new ArrayList();

	//	records = (ArrayList)bean.getPatientOrderDet(patient_id,order_date_from,order_date_to,token_no);
	//	String  classValue   = "";
	//	int recsize	=	records.size();
//	if(records.size()>0){
	%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="selectall();"> 
<%//}else{%>
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<%//}%>
<form name="MarkPatArrivalHeader" id="MarkPatArrivalHeader">
<%	
//	if(records.size() > 0){
%>
<table cellpadding="0" cellspacing="0"  border="1" width="100%" align="center">
<tr>
<th align="left" width="30%">Drug</th>
<th align="left" width="12%">Dispense Location</th>
<th align="left" width="13%">Storage Location</th>
<th align="left" width="10%">Order Status</th>
<th align="left" width="30%">Token Status</th>
<th align="left" width="4%">Select<input type="checkbox" name="select_box" id="select_box" value="Y"
		onclick="toggleCheck(MarkPatArrivalHeader);"></th>
</tr>
</table>
<%//}
	%>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<%	putObjectInBean(bean_id,bean,request);
%>

</form>
</body>
</html>

