<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>


<html>
<head>
<%
  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>
<title><fmt:message key="ePH.OtherOrders.label" bundle="${ph_labels}"/></title>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="activeOrderDetailsForm" id="activeOrderDetailsForm" >
<%

		String patient_id			=	request.getParameter("patient_id");
		String disp_locn_code		=	request.getParameter("disp_locn_code");
	    String encounter_id			=	request.getParameter("encounter_id");
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String freq_code			=	"";
		String qty_value			=   "";
		String qty_unit				=   "";
		String ordered_practioner   =   "";
		String ordering_location	=   "";
		String performing_location	=   "";
		String facility_name		=   "";
		String	bean_id				= "@DispMedicationBean"+patient_id+encounter_id;
		String bean_name			= "ePH.DispMedicationBean";
		String class_name			= "";

		ArrayList OtherOrders		= new ArrayList();		

		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			//bean.setLanguageId(locale);
        
	    OtherOrders =	bean.getOtherOrders( disp_locn_code, patient_id);
	
%>
    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
	<tr>
			<td class="COLUMNHEADER" align="center" class="small" width="9%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="9%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="32%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="8%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="12%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="12%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="10%"><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="12%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" align="center" class="small" width="8%"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
	</tr>
<%
		for (int i=0; i<OtherOrders.size(); i++) {

			if(i%2==0)
				class_name	=	"QRYEVENSMALL";
			else
				class_name	=	"QRYODDSMALL";

			HashMap record	=	(HashMap)	OtherOrders.get(i);
			start_date			=	CommonBean.checkForNull((String)record.get("start_date"));
			end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
			drug_desc			=	CommonBean.checkForNull((String) record.get("drug_name"));

//			strength			=	CommonBean.checkForNull((String) record.get("order_catalog_code"));
			
			qty_value	        =	CommonBean.checkForNull((String) record.get("qty_value"));
			qty_unit			=	CommonBean.checkForNull((String) record.get("qty_unit"));
			freq_code	        =	CommonBean.checkForNull((String) record.get("freq_code"));
			ordered_practioner		=	CommonBean.checkForNull((String) record.get("ordered_practioner"));

//			location			=	CommonBean.checkForNull((String) record.get("locn_code"));
			
			ordering_location	=	CommonBean.checkForNull((String) record.get("ordering_location"));

//			performing_deptloc_code			=	CommonBean.checkForNull((String) record.get("performing_deptloc_code"));
			
			performing_location	=	CommonBean.checkForNull((String) record.get("performing_location"));

//			facility_id		=	CommonBean.checkForNull((String) record.get("facility_id"));
			
			facility_name		=	CommonBean.checkForNull((String) record.get("facility_name"));%>
		<tr >
			<td  class="<%=class_name%>" nowrap><%=start_date%></td>
			<td  class="<%=class_name%>" nowrap><%=end_date%></td>
			<td  class="<%=class_name%>" nowrap><%=drug_desc%></td>
			<td  class="<%=class_name%>" nowrap><%=qty_value%>&nbsp;<%=qty_unit%> </td>
			<td  class="<%=class_name%>" nowrap><%=freq_code%></td>
			<td  class="<%=class_name%>" nowrap><%=ordered_practioner%></td>
			<td  class="<%=class_name%>" nowrap><%=ordering_location%></td>
			<td  class="<%=class_name%>" nowrap><%=performing_location%></td>
			<td  class="<%=class_name%>" nowrap><%=facility_name%></td>
			<td  class="<%=class_name%>"></td>
		</tr>
<%
		}
%>
	</table>

</form>
</body>
</html>

<%
//putObjectInBean(bean_id,bean,request);
%>

