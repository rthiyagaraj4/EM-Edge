<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../ePH/js/PhBalMednSheet.js"></script>
		 <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="frmPrintDispSheetResult" id="frmPrintDispSheetResult" >
<%
			String bean_id = "PrintPrescriptionReportBean" ;
			String bean_name = "ePH.PrintPrescriptionReportBean";
			PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;
			try{
				String callFrom		= CommonBean.checkForNull(request.getParameter("callFrom"));
				if(callFrom.equals("SEARCH"))
					bean.clear();
				bean.setLanguageId(locale);
				String patient_id	= CommonBean.checkForNull(request.getParameter("patient_id"));
				String disp_no		= CommonBean.checkForNull(request.getParameter("disp_no"));
				String facility_id=(String) session.getValue( "facility_id" );
				String from = CommonBean.checkForNull(request.getParameter("from"));
				String to = CommonBean.checkForNull(request.getParameter("to"));
				String selected = "";
				ArrayList result = bean.getDispenseLabelReport(patient_id,disp_no,facility_id,from,to);
				ArrayList selectedDispNos = bean.getSelectedDispNos();  //added for Bru-HIMS-CRF-415 [IN:045556] 
				if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 align="center">
					<tr>
						<td width="80%" class="white">&nbsp;</td>
					<td width="20%" class="white">&nbsp;
<%
					out.println(result.get(0));// For display the previous/next link
%>
					</td>
				</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th width='15%'><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
				<th width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th width='15%'><fmt:message key="ePH.DispDate/Time.label" bundle="${ph_labels}"/></th>
				<th width='20%'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
				<th width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th width='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
<%
				String classvalue	= "";
				for (int i=1;i<result.size();i+=5){
					if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
					selected = "";
					if(selectedDispNos!=null && selectedDispNos.contains((String)result.get(i)))  //added for Bru-HIMS-CRF-415 [IN:045556] -start
						selected = "checked";
					else
						selected="";  //added for Bru-HIMS-CRF-415 [IN:045556] -end
%>
					<tr>
						<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i)%></td>
						<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+1)%></td>
						<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+2),"DMYHM","en",locale)%></td>
						<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+3)%></td>
						<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+4)%></td>
						<td class="<%=classvalue%>" style="font-size=9"><input type='checkbox' name='<%=(String)result.get(i)%>' id='<%=(String)result.get(i)%>' <%=selected%> onclick="storeSeleciton(this, '<%=(String)result.get(i)%>');"></td><!-- //added for Bru-HIMS-CRF-415 [IN:045556] -->
					</tr>
<%
					}
				}
				else{
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<% 
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
%>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="from" id="from" value="">
			<input type="hidden" name="to" id="to" value="">
			<input type="hidden" name="patient_id" id="patient_id" value="">
			<input type="hidden" name="disp_no" id="disp_no" value="">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

