<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

 %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>  -->
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRPhCertificateOfReimbursementSpecial.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
	<form name = "formCRForSpecialResult">

	<%
		String classValue = "";
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String p_report_type = CommonBean.checkForNull(request.getParameter("p_report_type"));
		String p_search_by = CommonBean.checkForNull(request.getParameter("p_search_by"));
		String p_bill_date = CommonBean.checkForNull(request.getParameter("p_bill_date"));
		String p_bill_number = CommonBean.checkForNull(request.getParameter("p_bill_number"));
		String p_bill_number1 = CommonBean.checkForNull(request.getParameter("p_bill_number1"));
		String p_receipt_date = CommonBean.checkForNull(request.getParameter("p_receipt_date"));
		String p_receipt_number = CommonBean.checkForNull(request.getParameter("p_receipt_number"));   
		String p_receipt_number1 = CommonBean.checkForNull(request.getParameter("p_receipt_number1"));   
		String p_patient_id = CommonBean.checkForNull(request.getParameter("p_patient_id"));
		String p_privilege = CommonBean.checkForNull(request.getParameter("p_privilege"));
		String p_payer = CommonBean.checkForNull(request.getParameter("p_payer"));
		String p_report_option = CommonBean.checkForNull(request.getParameter("p_report_option"));
		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);

	
		ArrayList searchList= bean.searchReimbursementList(p_search_by,p_report_type,p_bill_date,p_receipt_date,p_bill_number,p_bill_number1,p_receipt_number,p_receipt_number1,p_privilege,p_payer,p_patient_id);
		bean.setReimbursementList(searchList);
		//out.println("searchList"+searchList);
		
		if (searchList != null && searchList.size() > 0){
				%>
		<input type='hidden' name="listSize" id="listSize" value="<%=searchList.size()%>"/>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<th><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/>/<fmt:message key="ePH.BillDate.label" bundle="${common_labels}"/></th>  
		<th><fmt:message key="Common.receiptno.label" bundle="${common_labels}"/>./<fmt:message key="ePH.BillNo.label" bundle="${ph_labels}"/>.</th>
		<th><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/>.</th>
		<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>		
		<th><fmt:message key="Common.PatientName_fs.label" bundle="${common_labels}"/></th>	
		<th><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> <input type="checkbox" name="p_print_all" id="p_print_all" value="N" onClick="assignAll(this);"></th>
		<%
		   for(int i=0;i<searchList.size();i++){
			HashMap map= (HashMap)searchList.get(i);
			String Doc_Date = (String)map.get("doc_date");
			String doctype_code = (String)map.get("doctype_code");
			//Date conversion related to doc_date is added on 12/1/2010 by Archanan Dhal related to incident no. IN0 23829
			Doc_Date = com.ehis.util.DateUtils.convertDate(Doc_Date,"DMY","en",locale);
		%>
			<tr>
				 <td class="label"><%=Doc_Date%></td>
				<td class="label"><%=map.get("doctype_code")%>/<%=map.get("doc_num")%></td> <!-- Display Bill number for the incident num:23829==By Sandhya on 13/DEC/2010-->
				<%//out.println("Token=====>" +map.get("token").toString());%>
				<td class="label"><%=map.get("token").toString()%>&nbsp;</td>
				<td class="label"><%=map.get("patient_id")%></td>
				<td class="label"><%=map.get("patient_name")%></td>
				<td class="label"><input type="checkbox" name="p_print_yn<%=i%>" id="p_print_yn<%=i%>" value="<%=map.get("check").toString()%>" onClick="assignValue(this,'<%=i%>');updateList('<%=i%>');">
				
				</td> 			

		<%}			
	}	
		else{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		reset1();
		</script>
		<%}
		

		%>
	
	<input type='hidden' name="bean_id" id="bean_id" value="<%=bean_id%>"/>
	<input type='hidden' name="bean_name" id="bean_name" value="<%=bean_name%>"/>
	<input type='hidden' name="p_report_option" id="p_report_option" value="<%=p_report_option%>"/>
	
	
	</form>
</body>
</html>

