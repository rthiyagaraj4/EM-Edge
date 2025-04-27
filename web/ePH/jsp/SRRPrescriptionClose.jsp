<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/Prescription_2.js"></script>
	<script language="JavaScript" src="../js/Prescription_1.js"></script>	
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>	
	<script language="JavaScript" src="../js/IVPrescription.js"></script>	
	<!-- <script language="Javascript" src="../js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/SRRPhRepPrescription.js"></script>	
		<script language="JavaScript" src="../js/SRRPhDispLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="SRRPrescriptionClose" id="SRRPrescriptionClose">
<%



    String bean_id				= "SRROnlineReportSet1Bean" ;
	String bean_name			= "ePH.SRROnlineReportSet1Bean";
	SRROnlineReportSet1Bean bean		= (SRROnlineReportSet1Bean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);


	String called_from	=	request.getParameter("called_from");
	if(called_from == null)	called_from = "";
	
	String patient_id	=   request.getParameter("patient_id");
	String encounter_id	=   request.getParameter("encounter_id");
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//out.println("p_facility_id-------------------"+p_facility_id);

%>



<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
<tr> 

		<td  nowrap  class="IVFLUID" width="22%" align='center'><label style="font-size:9;font-weight:bold;color:white"><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/></label></td>
		<td  nowrap  class="IVINGREDIENT" width="22%" align='center'><label style="font-size:9;font-weight:bold">&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/></label></td>
		<td  nowrap  class="DISCHARGEMED" width="22%" align='center'><label style="font-size:9;font-weight:bold">&nbsp;<fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></label></td>
		<td  nowrap  class="FORMULARY" width="22%" align='center'><label style="font-size:9;font-weight:bold;color:white">&nbsp;<fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></label></td>
		<% if(called_from.equals("PH")){ %>
		<td  class="white" width="4%"><input type="button" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="Printforpre(SRRPrescriptionClose,'<%=p_facility_id%>');"></td>
			<% }else { %>
			<td  class="white" width="4%"><input type="button" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' class="button" onClick="showPrint(SRRPrescriptionClose,'<%=p_facility_id%>');"></td>

				<% }  %>

		<td  class="white" width="4%"><input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="window.close()">&nbsp;&nbsp;&nbsp;
		</td>

</tr>
   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</table>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

