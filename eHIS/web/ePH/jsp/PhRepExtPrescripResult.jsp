<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%><!-- Added for Ml-mmoh-crf-0510 -->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<%
	request.setCharacterEncoding("UTF-8");
				
				//Added by Himanshu for MMS-ME-SCF-0097 Starts 
				request= new XSSRequestWrapper(request); 
				response.addHeader("X-XSS-Protection", "1; mode=block"); 
				response.addHeader("X-Content-Type-Options", "nosniff"); 
				//Added by Himanshu for MMS-ME-SCF-0097 ends
				
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/PhRepExtPrescription.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmExtPrescriptionResult" id="frmExtPrescriptionResult" >
<%
	String bean_id = "PrintPrescriptionReportBean" ;
	String bean_name = "ePH.PrintPrescriptionReportBean";

	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);

	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String orig_order_id = CommonBean.checkForNull(request.getParameter("orig_order_id"));
	String order_date_from = CommonBean.checkForNull(request.getParameter("order_date_from"));
	String order_date_to = CommonBean.checkForNull(request.getParameter("order_date_to"));
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	String order_by = CommonBean.checkForNull(request.getParameter("order_by"));
	 //Added for Ml-mmoh-crf-0510 start 
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");
	
	 //Added for Ml-mmoh-crf-0510 end

	ArrayList result = bean.getAllExtPresBasedOnQuery(patient_id,orig_order_id,order_date_from,order_date_to,from,to,order_by);

	if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(0));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th ><fmt:message key="ePH.PrescriptionNo.label" bundle="${ph_labels}"/></th>
		<th ><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			
         <%	if(site){
		%>
		<th><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th><!--added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] -->
		<%}else{%>
			<th><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
	<%	}
		%>
		
	<%
		//String []record=new String[11];//commented for ml-mmoh-crf-0510
		String []record=new String[13];
		for (int i=1;i<result.size();i++){
			record= (String[])result.get(i);
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		record[1]=com.ehis.util.DateUtils.convertDate(record[1],"DMY","en",locale);
		record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en",locale);
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9"><font class="HYPERLINK" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=record[8]%>')"><%=record[0]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[1]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[2]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[10]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[4]%></td>			
				<!-- Added for ml-mmoh-crf-0510 start-->
		<%	if(site){
			if(record[11] == null ){%>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[6]%></td>	
		<%	}else{%>
			<td class="<%=classvalue%>" style="font-size=9"><%=record[11]%></td>
		<%}%>
			
			<td class="<%=classvalue%>" style="font-size=9"><%=record[12]%></td>	
		<%		}
			else{%>	
			<td class="<%=classvalue%>" style="font-size=9"><%=record[6]%></td>	
		<%	}%>
			<!-- Added for ml-mmoh-crf-0510 end-->	
		</tr>
	<%
		}
	}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
	}
	%>

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="order_id" id="order_id" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="order_date_from" id="order_date_from" value="">
	<input type="hidden" name="order_date_to" id="order_date_to" value="">
	<input type="hidden" name="order_by" id="order_by" value="">
	<% putObjectInBean(bean_id,bean,request); %>

</form>
</body>
</html>

