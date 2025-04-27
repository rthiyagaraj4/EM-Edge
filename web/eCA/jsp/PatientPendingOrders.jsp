<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- PatientPendingOrders.jsp -->

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String discharge_indicator = request.getParameter("discharge_indicator") ;
	if(discharge_indicator == null || discharge_indicator.equals("null")) discharge_indicator =""; else discharge_indicator = discharge_indicator.trim();

String Patient_id = request.getParameter("Patient_id") ;
	if(Patient_id == null || Patient_id.equals("null")) Patient_id =""; else Patient_id = Patient_id.trim();

String encounter_id = request.getParameter("encounter_id") ;
	if(encounter_id == null || encounter_id.equals("null")) encounter_id =""; else encounter_id = encounter_id.trim();

String patient_class = request.getParameter("patient_class") ;
	if(patient_class == null || patient_class.equals("null")) patient_class =""; else patient_class = patient_class.trim();
String discharge=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeCheckList.label","ip_labels");
String completed=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CompletedOrders.label","or_labels");
String Previous=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PreviousOrders.label","ph_labels");
String PendingSpecimen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PendingForSpecimenCollection.label","or_labels");
String Expires=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Expires/ExpiredOrderforRenewing.label","or_labels");
String frmSum = request.getParameter("frmSum") ;
	if(frmSum == null || frmSum.equals("null")) frmSum =""; else frmSum = frmSum.trim();
%>

<title><%=(!Patient_id.equals(""))?((!encounter_id.equals("")) ? ((!discharge_indicator.equals(""))?discharge:completed):Previous):((!patient_class.equals("")) ? PendingSpecimen :Expires )%></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
if(frmSum.equals("Y"))
{
%>
	<frameset rows='6%,*'>
<%
}
else
{
%>
	<frameset rows='6%,*,12%'>
<%
}
%>
	<frame name='framePatientPendingOrdersHdr'
	src="../../eOR/jsp/PatientPendingOrdersHdr.jsp"	frameborder=0  noresize scrolling='auto'>

	<Frame name='framePatientPendingOrdersResult' src="../../eOR/jsp/PatientPendingOrdersResult.jsp?Patient_id=<%=Patient_id%>&encounter_id=<%=encounter_id%>&patient_class=<%=patient_class%>&discharge_indicator=<%=discharge_indicator%>" FrameBorder='0' scrolling='auto' noresize>
	<%
	if(!frmSum.equals("Y"))
	{
	%>
		<Frame name='framePatientPendingOrdersClose' src="../../eOR/jsp/PatientPendingOrdersClose.jsp"
		FrameBorder='0' scrolling='no' noresize>
	<%
	}
	%>

</frameset>
<html>
