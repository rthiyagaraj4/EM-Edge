<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes st art --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>		
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	   
		String pat_class =  request.getParameter("pat_class");
		String ord_status = request.getParameter("ord_status");
		String dt_from		= request.getParameter("dt_from");
		String dt_to	    = request.getParameter("dt_to");
		String patient_id	= request.getParameter("patient_id");
		String encounter_id	= request.getParameter("encounter_id");
		String rx_type = request.getParameter("rx_type");
		String log_pract_id = request.getParameter("log_pract_id");
		String patient_name =request.getParameter("patient_name");
		String age =  request.getParameter("patient_age");
		String sex= request.getParameter("gender");
		String pract_id = request.getParameter("pract_id");
		String discharge_ind = request.getParameter("discharge_ind"); // Added for #70618
		if(sex.equalsIgnoreCase("M")) // Added for INC#70594 - Start
			sex="Male";
		else if(sex.equalsIgnoreCase("F"))
			sex = "Female";
		else if(sex.equalsIgnoreCase("U"))
			sex="Unknow"; // Added for INC#70594 - End
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/MedicationReconciliation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		
		<table cellpadding='0' cellspacing='0' align="left" width='100%'>
 
		
		    <tr>
		    <th class="commontoolbarfunction"  >&nbsp;<%=patient_name%>&nbsp;,&nbsp;<%=sex%>&nbsp;,&nbsp;<%=age%>,&nbsp;<%=patient_id%></th>
		    </tr>
		    <tr>&nbsp;&nbsp;</tr>
		    <tr>&nbsp;&nbsp;</tr>		    
			<tr>
				<td class="white" nowrap >
					<ul id="tablist" class="tablist">
					<li class="tablistitem" title='<fmt:message key="ePH.PreviousOrders.label" bundle="${ph_labels}"/>' >
					<a name= "previousOrders" onclick="javascript:objClick('<%=pat_class%>','<%=ord_status%>','<%=dt_from%>','<%=dt_to%>','<%=patient_id%>','<%=encounter_id%>','<%=rx_type%>','<%=log_pract_id%>','<%=pract_id%>','<%=discharge_ind%>','')" class="tabClicked" id="DrugProfile_link"> <!-- discharge_ind Added for #70618, '' Added for Inc#70652 -->
					<span class="tabSpanclicked" id="DrugProfile_link_aspan"><fmt:message  key="ePH.PreviousOrders.label" bundle="${ph_labels}"/></span>
					</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/>'>
					<a onclick="javascript:objClick1('<%=patient_id%>','<%=encounter_id %>','<%=dt_from%>','<%=dt_to%>','<%=log_pract_id%>')"class="tabA" id="ExternalDrugProfile_link"> <!-- log_pract_id added for Inc#70652 -->
					<span class="tabAspan" id="ExternalDrugProfile_link_aspan"><fmt:message key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/></span>
					</a>
					</li>					
					</ul>
				</td>				
			</tr>
		</table>
	</body>
	<script>
	objClick('<%=pat_class%>','<%=ord_status%>','<%=dt_from%>','<%=dt_to%>','<%=patient_id%>','<%=encounter_id%>','<%=rx_type%>','<%=log_pract_id%>','<%=pract_id%>','<%=discharge_ind%>','<%="SEARCH"%>'); <!-- discharge_ind Added for #70618, SEARCH Added for Inc#70652 -->
	</script>
</html>

