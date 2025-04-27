<!DOCTYPE html>
<!--
 Below mentioned two points added by Venkatesh.S (EM:ID=1554454) on 18/Oct/2013 against Bru-HIMS-CRF-362[39365]
 ===============================================================================================================
 1. In this file entire TD class modified as "contextMenuItem" instead of "QRYODD".
 2. onMouseOver and  onMouseOut methods added in entire TD.
-->

<%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.http.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</head>
<body onKeyDown = 'lockKey()'>
<center>
<form name='AEMPAllowedOperationsForm' id='AEMPAllowedOperationsForm'>
<table border='1' class='contextMenu' cellpadding='0' cellspacing='0' width='100%' height='100%' >

<%
	String	queue_status	=	"";
	String	triage_area		=	"";
	String  brought_dead ="";    
	String ca_install_yn="N";

    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	queue_status	=	checkForNull(request.getParameter("queue_status"));
	brought_dead	=	checkForNull(request.getParameter("brought_dead"));
	triage_area		=	checkForNull(request.getParameter("triage_area")); 
	ca_install_yn		=	checkForNull(request.getParameter("CA_installed")); 

	/*Added by Dharma on Aug 7th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
	String treatment_area_code	= (request.getParameter("treatment_area_code")==null)? "" : request.getParameter("treatment_area_code");
	String patient_gender	= (request.getParameter("patient_gender")==null)? "" : request.getParameter("patient_gender");
	String reg_new_born_yn	= (request.getParameter("regnew_born_yn")==null)? "N" : request.getParameter("regnew_born_yn");
	String inv_reg_new_born_yn	= (request.getParameter("inv_reg_new_born_yn")==null)? "N" : request.getParameter("inv_reg_new_born_yn");
	/*Added by Dharma on Aug 7th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
	
	String pendngAdmDateTime = checkForNull(request.getParameter("pendngAdmDateTime"));//Added by Thamizh selvi on 2nd May 2018 against ML-MMOH-CRF-0658

	if(brought_dead.equals("N")) 	{
		if(queue_status.equals("01")) {
		%>
		<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
			<a href='javascript:callOperation("Triage","<%=ca_install_yn%>")'><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/></a>
		 </td></tr>
		 <tr><td class='contextMenuItem'>
			<a href='javascript:callOperation("AssignTreatmentArea","<%=ca_install_yn%>")'><fmt:message key="eAE.AssignTreatArea.label" bundle="${ae_labels}"/></a>
		 </td></tr>
		<% }	 else if( (queue_status.compareTo("02")>=0)  && triage_area.equals("B") ) { %>
			<!-- Added on 30/04/04  -->	
			<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
					<a href='javascript:callOperation("Triage","<%=ca_install_yn%>")'><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/></a>
				</td></tr>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
					<a href='javascript:callOperation("AssignReassignPractitioner","<%=ca_install_yn%>")'><fmt:message key="Common.ReassignPract.label" bundle="${common_labels}"/></a>
				</td></tr>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
					<a href='javascript:callOperation("ReassignTreatmentArea","<%=ca_install_yn%>")'><fmt:message key="eAE.ReassignTreatArea.label" bundle="${ae_labels}"/></a>
				</td></tr>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
					<a href='javascript:callOperation("StartConsultation","<%=ca_install_yn%>")'><fmt:message key="Common.StartConsult.label" bundle="${common_labels}"/></a>
				</td></tr>
		  <% } else if (queue_status.equals("07")) { %>
					<tr><td class='contextMenuItem'>
					</td></tr>
			<%} else if( (queue_status.compareTo("02")>=0) ) { 	%>
					<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("Triage","<%=ca_install_yn%>")'><fmt:message key="eAE.SecondaryTriage.label" bundle="${ae_labels}"/></a>
					</td></tr>
					<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("AssignReassignPractitioner","<%=ca_install_yn%>")'><fmt:message key="Common.ReassignPract.label" bundle="${common_labels}"/></a>
					</td></tr>
					<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("ReassignTreatmentArea","<%=ca_install_yn%>")'><fmt:message key="eAE.ReassignTreatArea.label" bundle="${ae_labels}"/></a>
					</td></tr>	
					<!-- <tr><td class='QRYODD'>
						<a href='javascript:callOperation("PrimaryAssessment","<%=ca_install_yn%>")'><fmt:message key="eAE.PrimaryAssessment.label" bundle="${ae_labels}"/></a>
					</td></tr>
					<tr><td class='QRYODD'>
						<a href='javascript:callOperation("TraumaScore","<%=ca_install_yn%>")'><fmt:message key="eAE.TraumaScore.label" bundle="${ae_labels}"/></a>
					</td></tr>
					<tr><td class='QRYODD'>
						<a href='javascript:callOperation("TraumaAssessment","<%=ca_install_yn%>")'><fmt:message key="eAE.TraumaAssessment.label" bundle="${ae_labels}"/></a>
					</td></tr> -->
				<% if(!queue_status.equals("04")){
						%>
						<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
							<a href='javascript:callOperation("StartConsultation","<%=ca_install_yn%>")'><fmt:message key="Common.StartConsult.label" bundle="${common_labels}"/></a>
						</td></tr>
				 <% }
			}	
		    if (!queue_status.equals("07")) { %>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("CheckOut","<%=ca_install_yn%>")'><fmt:message key="Common.CheckOut.label" bundle="${common_labels}"/></a>
						</td></tr>
		    <%}
			/*Added by Dharma on Aug 7th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		    if ("Y".equals(reg_new_born_yn) && !("").equals(treatment_area_code) && "F".equals(patient_gender) && "Y".equals(inv_reg_new_born_yn)) { %>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("RegisterNewBornForAE","<%=ca_install_yn%>")'><fmt:message key="eAE.RegisterNewBornForAE.label" bundle="${ae_labels}"/></a>
						</td></tr>
		    <%}
			/*Added by Dharma on Aug 7th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
			
			/*Added by Thamizh selvi on 2nd May 2018 against ML-MMOH-CRF-0658 Start*/
		    if (("").equals(pendngAdmDateTime) && queue_status.equals("04")) { %>
				<tr>
					<td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
						<a href='javascript:callOperation("for_admission","<%=ca_install_yn%>")'><fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.admission.label" bundle="${common_labels}"/>
						</a>
					</td>
				</tr>
		    <%}/*End*/

		} else  {
				if (queue_status.equals("07")) {
						out.println("test 1" );
			%>
				<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
				</td></tr>
			<%
				} else {
					%>
					 <tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
							<a href='javascript:callOperation("CheckOut","<%=ca_install_yn%>")'><fmt:message key="Common.CheckOut.label" bundle="${common_labels}"/></a>
						</td></tr> 
					<%
				}
			}
					%>
						<tr><td class='contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>
							<a href='javascript:callOperation("MovementHistory")'><fmt:message key="eAE.MovementHistory.label" bundle="${ae_labels}"/></a>
						</td></tr>

</table>
</center>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
%>
</html>


