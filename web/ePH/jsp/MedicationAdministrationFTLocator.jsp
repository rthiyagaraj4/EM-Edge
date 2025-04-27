<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
			String locale = (String) session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></SCRIPT> -->
			<!-- <script language="Javascript" src="../../ePH/js/PhMessages.js"></script> -->
			<script language="javascript" src="../js/PhCommon.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		</head>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name="MedicationAdministrationFTLocator" id="MedicationAdministrationFTLocator" >
<%  
				String mode				= request.getParameter("mode");
				String bean_id			   = "MedicationAdministrationFTBean";
				String bean_name		   = "ePH.MedicationAdministrationFTBean";
				String disa                =request.getParameter("disa")==null?"":request.getParameter("disa");
				disa=disa.trim();
				MedicationAdministrationFTBean bean			= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name , request);
				bean.setLanguageId(locale);
				String med_bean_id				= "MedicationAdministrationBean";
				String med_bean_name			= "ePH.MedicationAdministrationBean";
				MedicationAdministrationBean med_bean	= (MedicationAdministrationBean)getBeanObject( med_bean_id, med_bean_name, request );
				med_bean.setLanguageId(locale);
				String patient_class				= request.getParameter("patient_class").trim();
				String MAR_skip_pat_butn_disp_yn	= med_bean.getMARSkipPatButnDisp(); //Added for SKR-SCF-1033 [IN:051790] - start, 
				String disp_skip_pat_butn = "display:inline;";
				if(MAR_skip_pat_butn_disp_yn.equals("N")) //Hidden for AAKH-CRF-0023[IN:038259]
					disp_skip_pat_butn = "display:none;"; //added for SKR-SCF-1033 [IN:051790] -end
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
<%	
					if(disa.equals("N") || disa.equals("")){
%>
						<td  width="15%" class="white">
							<input type='text' name='bed_no' id='bed_no'  style="color:red" size='14' maxlength='8' class='number' value='<fmt:message key="ePH.EnterBedNoto.label" bundle="${ph_labels}"/>' onfocus="clearField(this);" onBlur="assignDisplayText(this)">
						</td>
					
						<td   width="25%" class="white">
							<input type='button' class='button' value='<fmt:message key="ePH.Locate.label" bundle="${ph_labels}"/>' name='locate1' id='locate1' onclick="locateBedNo()">
						</td>
						<td class="white" width="15%">
							<input type='text' name='patient_id' id='patient_id'  style="color:red" size='14'  maxlength="<%=med_bean.getPatientIDLength()%>" value='<fmt:message key="ePH.EnterPatientIDTo.label" bundle="${ph_labels}"/>' onKeyPress="uppercase()" onkeydown="pressKeyLocatePatientID(event)" onfocus="clearField(this);" onBlur="assignDisplayText(this)">
						</td>
						<td class="white"  >
							<input type='button' class='button' value='<fmt:message key="ePH.Locate.label" bundle="${ph_labels}"/>' name='locate' id='locate' onclick="locatePatientID()">
						</td>

						<td class="white"  >			
							<input type="button" name="btnSkipPatient" id="btnSkipPatient" class="button" value='<fmt:message key="ePH.SkipPatient.label" bundle="${ph_labels}"/>'  onClick="skipToNextPatient()" style="<%=disp_skip_pat_butn%>"><!-- Hidden for AAKH-CRF-0023[IN:038259] -->				
						</td>
						<td  class="white">
							<img src="../../ePH/images/max.gif"  name="btImg" id="btImg" height="20" title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RestoreDown.label", "ph_labels")%>" onClick="return expand('<%=mode%>')" style="visibility:hidden">
						</td>
<%
					}
%>
					</tr>
				</table>
			<input type='hidden' value='<%=patient_class%>' name='patient_class' id='patient_class'>
			<script>
				if(document.MedicationAdministrationFTLocator.patient_class.value=="IP" || document.MedicationAdministrationFTLocator.patient_class.value=="DC"){
					document.MedicationAdministrationFTLocator.bed_no.disabled=false;
					document.MedicationAdministrationFTLocator.locate1.disabled=false;
				}
				else{
					document.MedicationAdministrationFTLocator.bed_no.disabled=true;
					document.MedicationAdministrationFTLocator.locate1.disabled=true;
				}
			</script>
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(med_bean_id,med_bean,request);
%>
</html>

