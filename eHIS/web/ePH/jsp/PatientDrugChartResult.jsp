<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PatientDrugChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="patientDrugChartReportResult" id="patientDrugChartReportResult" >
<%
			String bean_id = "PrintPrescriptionReportBean" ;
			String bean_name = "ePH.PrintPrescriptionReportBean";
			String lbl_locn_type=""; // Added for ML-BRU-SCF-0498 [IN035593]
			PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject(bean_id,bean_name, request);
			bean.setLanguageId(locale);
			String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
			String locn_code = CommonBean.checkForNull(request.getParameter("locn_code"));
			String locn_type = CommonBean.checkForNull(request.getParameter("locn_type"));
			String locn_name = CommonBean.checkForNull(request.getParameter("locn_name"));
			String from = CommonBean.checkForNull(request.getParameter("from"));
			String to   = CommonBean.checkForNull(request.getParameter("to"));
			if("C".equals(locn_type.trim()))
				lbl_locn_type=MessageManager.getLabel(locale,"Common.clinic.label","Common");
			else if("N".equals(locn_type))
				lbl_locn_type=MessageManager.getLabel(locale,"Common.nursingUnit.label","Common");
			else 
				lbl_locn_type=MessageManager.getLabel(locale,"Common.Location.label","Common");
			//ArrayList result = bean.getPatientDrugOnQuery(patient_id,nursing_unit_code,from,to,locale);  // Commented and added ML-BRU-SCF-0498 [IN035593]
			ArrayList result = bean.getPatientDrugOnQuery(patient_id,locn_code,from,to,locale,locn_type);
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
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th><%=lbl_locn_type%></th><th ><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
<%  
					if("N".equals(locn_type.trim())){    // added for ML-BRU-SCF-0498 [IN035593]
%>
						<th><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
<%
					}
					String room_no="";
					String bed_no="";
					String []record=new String[10];
					for (int i=1;i<result.size();i++){
						record= (String[])result.get(i);
						String classvalue="";
						if ( i % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
%>
						<tr>
							<td class="<%=classvalue%>" style="font-size=9"><font class="HYPERLINK" style="cursor:pointer" onClick="showPrintReport('<%=record[0]%>')"><%=record[0]%></font></td>
							<td class="<%=classvalue%>" style="font-size=9"><%=record[1]%></td>
							<td class="<%=classvalue%>" style="font-size=9"><%=record[3]%></td>
							<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate(record[4],"DMYHM","en",locale) %></td><!--code  is replaced by record[4] com.ehis.util.DateUtils.convertDate(record[4],"DMYHM","en",locale) for SKR-SCF-1015[IN048694]  -->
<% 			   
							if("N".equals(locn_type.trim())){  // added for ML-BRU-SCF-0498 [IN035593]
							   room_no=record[5];
							   bed_no=record[6];
							   if(room_no == null || room_no.trim().equals(""))// added for ML-BRU-SCF-0498 [IN035593]
								   room_no="";  
							   if(bed_no  == null || bed_no.trim().equals(""))
								   bed_no="";
%>
								<td class="<%=classvalue%>" style="font-size=9;borderWidth=thin"><%=room_no%></td>			
								<td class="<%=classvalue%>" style="font-size=9"><%=bed_no%></td>			
<%
							}
						}
%>
					</tr>
				</table>
<%
			}
			else{
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
			}
%>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="from" id="from" value="">
			<input type="hidden" name="to" id="to" value="">
			<input type="hidden" name="patient_id" id="patient_id" value="">
			<input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="">
		</form>
		<% putObjectInBean(bean_id,bean,request ) ; %>
	</body>
</html>

