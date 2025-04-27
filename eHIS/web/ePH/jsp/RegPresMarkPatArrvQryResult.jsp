<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
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
		String dispense_locn = request.getParameter("dispense_locn");
			if(dispense_locn == null) dispense_locn = "";
		String token_serial_no	=	"";
		String queue_date	 =	 "";
		String order_id	=	"";
		String order_line_num	=	"";	
		String order_catalog_code	 =	 "";
		String drug_name = "";
		String disp_locn	 =	 "";
		String storage_locn	=	"";
		String order_status	=	"";
		String token_status	=	"";
		String token_series_code="";
		String disp_locn_code	=	"";
		ArrayList records = new ArrayList();

		records = (ArrayList)bean.getPatientOrderDet(patient_id,order_date_from,order_date_to,token_no);
		String  classValue   = "";
		int recsize	=	records.size()/12;

	%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="chkdispense();"> 
<form name="MarkPatArrivalQryResultForm" id="MarkPatArrivalQryResultForm">
<%	
	if(records.size() > 0){
%>
<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center" scrolling="auto">
<%
	int	j	=0;
	for(int i=0; i<records.size(); i+=12)	{	
		
		if(j%2==0)
			classValue	=	"QRYEVEN";
		else
			classValue	=	"QRYODD";

	token_serial_no		=	(String)records.get(i);
	queue_date		=	(String)records.get(i+1);
	order_id  =   (String)records.get(i+2);
	order_line_num	=	(String)records.get(i+3);
	order_catalog_code		=	(String)records.get(i+4);
	drug_name =	(String)records.get(i+5);
	disp_locn		=   (String)records.get(i+6);
	storage_locn		=   (String)records.get(i+7);
	order_status		=   (String)records.get(i+8);
	token_status		=   (String)records.get(i+9);
	token_series_code		=   (String)records.get(i+10);
	disp_locn_code			= (String)records.get(i+11);
%>

<tr>
	<td align="left" width="30%" class="<%=classValue%>"><label   name="drug_name_<%=j%>" id="drug_name_<%=j%>">&nbsp;<%=drug_name%>&nbsp;</label></td>
	<td align="left" width="12%" class="<%=classValue%>" name="disp_locn_<%=j%>" id="disp_locn_<%=j%>">&nbsp;<%=disp_locn%>&nbsp;</td>
	<td align="left" width="13%" class="<%=classValue%>" name="storage_locn_<%=j%>" id="storage_locn_<%=j%>">&nbsp;<%=storage_locn%>&nbsp;</td>
	<td align="left" width="10%" class="<%=classValue%>" name="order_status_<%=j%>" id="order_status_<%=j%>">&nbsp;<%=order_status%>&nbsp;</td>
	<td align="left" width="30%" class="<%=classValue%>" name="token_status_<%=j%>" id="token_status_<%=j%>">&nbsp;<%=token_status%>&nbsp;</td>
	<td align="left" width="3%" class="<%=classValue%>">
	<input type="checkbox" name="check_<%=j%>" id="check_<%=j%>" 
	value="Y" onClick="assignValue(this);" checked></td>
	<input type="hidden" name="token_series_code_<%=j%>" id="token_series_code_<%=j%>" id="token_series_code_<%=j%>" value="<%=token_series_code%>">
	<input type="hidden" name="disp_locn_code_<%=j%>" id="disp_locn_code_<%=j%>" id="disp_locn_code_<%=j%>" value="<%=disp_locn_code%>">
	<input type="hidden" name="token_serial_no_<%=j%>" id="token_serial_no_<%=j%>" id="token_serial_no_<%=j%>" value="<%=token_serial_no%>">
	<input type="hidden" name="queue_date_<%=j%>" id="queue_date_<%=j%>" id="queue_date_<%=j%>" value="<%=queue_date%>">
	<input type="hidden" name="order_id_<%=j%>" id="order_id_<%=j%>" id="order_id_<%=j%>" value="<%=order_id%>">
	<input type="hidden" name="order_line_num_<%=j%>" id="order_line_num_<%=j%>"  id="order_line_num_<%=j%>" value="<%=order_line_num%>">
	<input type="hidden" name="order_catalog_code_<%=j%>" id="order_catalog_code_<%=j%>" id="order_catalog_code_<%=j%>" value="<%=order_catalog_code%>">
	<input type="hidden" name="pat_mode_<%=j%>" id="pat_mode_<%=j%>" id="pat_mode_<%=j%>" value="">
</tr>

<%j++;
}} else {
%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA")); </script>
<% }
	%>
	<input type="hidden" name="recsize" id="recsize" value="<%=recsize%>" >
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="dispense_locn" id="dispense_locn" value="<%=dispense_locn%>">

<%	putObjectInBean(bean_id,bean,request);
%>

</table>
</form>
</body>
</html>

