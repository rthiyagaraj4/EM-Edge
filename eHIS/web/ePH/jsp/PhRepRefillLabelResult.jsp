<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepRefillLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="PhRepPrescriptionResultForm" id="PhRepPrescriptionResultForm" >
<%
			String bean_id = "PrintPrescriptionReportBean" ;
			String bean_name = "ePH.PrintPrescriptionReportBean";

			PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
			bean.setLanguageId(locale);

			String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
			String order_id = CommonBean.checkForNull(request.getParameter("order_id"));
			String order_date_from = CommonBean.checkForNull(request.getParameter("order_date_from"));
			String order_date_to = CommonBean.checkForNull(request.getParameter("order_date_to"));
			String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
			String facility_id=(String) session.getValue( "facility_id" );
			String from = CommonBean.checkForNull(request.getParameter("from"));
			String to = CommonBean.checkForNull(request.getParameter("to"));   
			System.err.println("patient_id@@@==="+patient_id);
			ArrayList result =new ArrayList();
		result=bean.getRefillOrders(patient_id,order_id,order_date_from,order_date_to,facility_id,locn_code,from,to,locale);
		System.err.println("result@@==="+result);

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
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="99%" align="left">
                <th><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
				
<%
				String []record=new String[7];
				String classvalue="";
				for (int i=1;i<result.size();i++){
					record= (String[])result.get(i);
					if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;

					
					record[3]=com.ehis.util.DateUtils.convertDate(record[3],"DMYHM","en",locale);
					record[4]=com.ehis.util.DateUtils.convertDate(record[4],"DMYHM","en",locale);
				
%>
						<tr>
							<td class="<%=classvalue%>" style="font-size=9"><B><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>','<%=record[7]%>')"><%=record[0]%></font></B></td>
							<td class="<%=classvalue%>" style="font-size=9"><B><%=record[2]%></B></td>
							<td class="<%=classvalue%>" style="font-size=9"><B><%=record[3]%></B></td>
							<td class="<%=classvalue%>" style="font-size=9"><B><%=record[4]%></B></td>			
							<td class="<%=classvalue%>" style="font-size=9"><B><%=record[5]%></B></td>			
							<td class="<%=classvalue%>" style="font-size=9"><B><%=record[6]%></B></td>			
							
						</tr>
<%
				}
			}else{
				 
	%>
	             
		     <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));</script>
	<%
	}
	%>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="from" id="from" value="">
			<input type="hidden" name="to" id="to" value="">
			<input type="hidden" name="patient_id" id="patient_id" value="">
			<input type="hidden" name="order_date_from" id="order_date_from" value="">
			<input type="hidden" name="order_date_to" id="order_date_to" value="">
			<input type="hidden" name="locn_code" id="locn_code" value="">
			<input type="hidden" name="facility_id" id="facility_id" value="">
			<input type="hidden" name="order_id" id="order_id" value="">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHPRREFLB">
			<% putObjectInBean(bean_id,bean,request); %>
		</form>
	</body>
</html>

