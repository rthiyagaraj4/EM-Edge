<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>                                
	<head>                                
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>    
	<body>
		<form name="TaperDrugDetailsForm" id="TaperDrugDetailsForm">
<%
			String patient_id		= request.getParameter("patient_id");
			String drug_code		= request.getParameter("drug_code");
			String order_id         = request.getParameter("order_id");
			String dosage			="";	
			String dosage_uom		="";
			String frequency		="";
			String start_date		="";
			String end_date			="";
			String bean_id					= "RegPrescriptionsBean" ;
			String bean_name				= "ePH.RegPrescriptionsBean";	
			
			HashMap record					= null;
			
			RegPrescriptionsBean bean = (RegPrescriptionsBean)getBeanObject(bean_id,bean_name,request) ;	
			bean.setLanguageId(locale);
			String drug_desc = (String)bean.getDrugDescription(drug_code);
			ArrayList taper_drug_details = (ArrayList)bean.getTaperDrugDetails(patient_id,drug_code,order_id);
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" >
				<title><%=drug_desc%>(<fmt:message key="ePH.TaperDetails.label" bundle="${ph_labels}"/>)</title>
				<tr>
					<th width='25%'> <fmt:message key="Common.Dosage.label" bundle="${common_labels}"/> </th>                                                    
					<th width='35%'> <fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> </th>
					<th width='20%'> <fmt:message key="Common.StartDate.label" bundle="${common_labels}"/> </th>
					<th width='20%'> <fmt:message key="Common.enddate.label" bundle="${common_labels}"/> </th>
				</tr>
<%
				for(int i=0;i<taper_drug_details.size();i++){
					record=new HashMap();
					record=(HashMap)taper_drug_details.get(i);
				
					dosage			=	(String)record.get("DOSAGE")==null?"":(String)record.get("DOSAGE"); // ==null?"":(String)record.get("DOSAGE") Added for IN65121
					//dosage_uom		=	(String)record.get("DOSAGE_UOM_CODE");
					dosage_uom		=	(String)record.get("DOSAGE_UOM")==null?"":(String)record.get("DOSAGE_UOM"); //added for PHIS-PH-Tapper Details window[IN037218] // ==null?"":(String)record.get("DOSAGE_UOM"); added for IN65121
					frequency		=	(String)record.get("FREQ_DESC");
					start_date		=	(String)record.get("START_DATE");
					end_date		=	(String)record.get("END_DATE");
%>
					<tr nowrap >
						
						<td  align="left"  class="label" width='25%' nowrap><%=dosage%>&nbsp;&nbsp;<%=dosage_uom%></td>
						<td  align="left"  class="label" width='35%' nowrap><%=frequency%></td>
						<td  align="left"  class="label" width='20%' nowrap><%=start_date%></td>
						<td  align="left"  class="label" width='20%' nowrap><%=end_date%></td>		
					</tr>
<% 
				}
%>
				<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
			</table>
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</BODY>
</html>

