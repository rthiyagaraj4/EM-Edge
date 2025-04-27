<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------

05/08/2020  IN072762    chandrashekar                                   MO-CRF-20101.11
03/12/2020	IN073728	Nijithas		12/11/2020		Ramesh G		MO-CRF-20101.16
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
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	    String params=request.getQueryString();
		//System.err.println("params@@@@ tabspages"+params);
		String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String from_date		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String to_date		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String generic_id	= request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String pat_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");;
		String status		=	request.getParameter("status")==null?"":request.getParameter("status");
		String encounter_id	    =	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String facility_id		=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String pract_id		=	request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selTab		=	request.getParameter("selTab")==null?"":request.getParameter("selTab");
		String eventCls				= request.getParameter("order_type")==null?"":request.getParameter("order_type");
		String eventGrp				= request.getParameter("item_type")==null?"":request.getParameter("item_type");
		String eventItem			= request.getParameter("drug_id")==null?"":request.getParameter("drug_id");
		String date_Ordr			= request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
		String selHistType			= request.getParameter("selHistType")==null	?"MEDN":request.getParameter("selHistType");
		String patient_class		= request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	     if(date_Ordr.equals(""))
		    date_Ordr ="D";
		
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCA/js/MedicationOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='medicationTabs' id='medicationTabs'>
		<table cellpadding='0' cellspacing='0' align="left" width='100%'>
			<tr>
				<td class="white" nowrap >
					<ul style=padding-left:0px; id="tablist" class="tablist" >
					<li class="tablistitem" title='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'>
					<a onClick="javascript:objClick('<%=patient_id%>','<%=encounter_id%>','<%=patient_class%>','<%=from_date%>','<%=to_date%>','<%=generic_id%>','<%=eventItem%>','<%=status%>','<%=facility_id%>','<%=pract_id%>','<%=selTab%>','<%=eventCls%>','<%=date_Ordr%>','<%=selHistType%>','D')" class="tabClicked" id="DrugProfile_link">
					<span class="tabSpanclicked" id="DrugProfile_link_aspan"><fmt:message  key="Common.DrugProfile.label" bundle="${common_labels}"/></span>
					</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/>'>
					<a onClick="javascript:objClick1('<%=patient_id%>','<%=encounter_id%>','<%=patient_class%>','<%=from_date%>','<%=to_date%>','<%=generic_id%>','<%=eventItem%>','<%=status%>','<%=facility_id%>','<%=pract_id%>','<%=selTab%>','<%=eventCls%>','<%=date_Ordr%>','<%=selHistType%>','E')"class="tabA" id="ExternalDrugProfile_link"><!-- pat_class,encounter_id added for AAKH-CRF-0088.2 -->
					<span class="tabAspan" id="ExternalDrugProfile_link_aspan"><fmt:message  key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/></span>
					</a>
					</li><!--Added for Bru-HIMS-CRF-404 [IN:044795]--start -->
					<li class="tablistitem" title='<fmt:message key="Common.MedicalItem.label" bundle="${ph_labels}"/>'>
					<a onClick="javascript:objClick2('<%=patient_id%>','<%=encounter_id%>','<%=patient_class%>','<%=from_date%>','<%=to_date%>','<%=generic_id%>','<%=eventItem%>','<%=status%>','<%=facility_id%>','<%=pract_id%>','<%=selTab%>','<%=eventCls%>','<%=date_Ordr%>','<%=selHistType%>','M')"class="tabA" id="MedicalItemProfile_link">
					<span class="tabAspan" id="MedicalItemProfile_link_aspan"><fmt:message  key="Common.MedicalItem.label" bundle="${common_labels}"/></span>
					</a>
					</li><!-- //Added for Bru-HIMS-CRF-404 [IN:044795]--start -->
					</ul>
				</td>
				
			</tr>
		</table>

		<script>
<%
		if(eventGrp.equals("M")){
%>
		        document.getElementById("DrugProfile_link").className = "tabA";
				document.getElementById("ExternalDrugProfile_link").className = "tabA";
				document.getElementById("MedicalItemProfile_link").className = "tabClicked";
				document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
				document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
				document.getElementById("MedicalItemProfile_link_aspan").className = "tabSpanclicked";
					  
<%
		}else if(eventGrp.equals("E")){
%>
                document.getElementById("DrugProfile_link").className = "tabA";
				document.getElementById("MedicalItemProfile_link").className = "tabA";
				document.getElementById("ExternalDrugProfile_link").className = "tabClicked";
				document.getElementById("DrugProfile_link_aspan").className = "tabAspan";
				document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";
				document.getElementById("ExternalDrugProfile_link_aspan").className = "tabSpanclicked";	      

<%
        }else{
%>
                document.getElementById("ExternalDrugProfile_link").className = "tabA";
				document.getElementById("MedicalItemProfile_link").className = "tabA";
				document.getElementById("DrugProfile_link").className = "tabClicked";
				document.getElementById("ExternalDrugProfile_link_aspan").className = "tabAspan";
				document.getElementById("MedicalItemProfile_link_aspan").className = "tabAspan";
				document.getElementById("DrugProfile_link_aspan").className = "tabSpanclicked";		

<%
		}
		
%>
	</script>
		            <input type='hidden' value="<%=request.getQueryString()%>" name='queryString' />
		             <input type='hidden' value="<%=eventGrp%>" name='item_type' /><!-- IN073728  -->
					
    </form>
	</body>

</html>

