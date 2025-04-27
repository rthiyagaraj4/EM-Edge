<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
 		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
   <%
	try{
		String discharge_ind = request.getParameter("discharge_ind")==null?"":request.getParameter("discharge_ind");//Added for BRU-HIMS-CRF-403--start
		String patient_id = request.getParameter("pat_id");
		String enc_id = request.getParameter("enc_id");
		String bean_id		= "@PrescriptionBean_1"+patient_id+enc_id;
		String bean_name	= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
		String copyDischMednDisplay="display:none";
		String disabled="", copyDischMedn = bean.getCopyPrevOrderForDishargeMedn();
		if(copyDischMedn!=null && copyDischMedn.equalsIgnoreCase("Y") && discharge_ind.equalsIgnoreCase("Y")){
			copyDischMednDisplay = "display:inline";
			disabled="disabled";//Added for BRU-HIMS-CRF-403--end
		}
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="frmPrescriptionPrevOrdersButton" id="frmPrescriptionPrevOrdersButton" >
				<table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="1">
					<tr>
						<td class='CANCELLED' width='2%'>&nbsp;</td>
						<td class='label' >&nbsp;&nbsp;
							<label style="font-size:9;font-weight:bold"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></label>
						</td>
						<td class='DISCONTINUED' width='2%'>&nbsp;</td>
						<td class='label' >&nbsp;&nbsp;
							<label style="font-size:9;font-weight:bold"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></label>
						</td>
						<td   >
							<input type="button" class="button" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' onClick="prevOrdersPreview()"  ></input>
							<input type="button" id = "disbutton" class="button" value='Discharge Medication' onClick="copiedDischargeDrugs()" style='<%=copyDischMednDisplay%>' ></input>
							<input type="button" id = "copybutton" class="button" <%=disabled%> value='<fmt:message key="Common.Copy.label"  bundle="${common_labels}"/>' onClick="copiedDrugs()"  ></input>
							<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="toCloseTopShowModal();"  ></input>
						</td>
					</tr>
				</table>   
				<input type='hidden' name='order_id' id='order_id'>
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"><!--Added for BRU-HIMS-CRF-403-->
				<input type="hidden" name="enc_id" id="enc_id" value="<%=enc_id%>"><!--Added for BRU-HIMS-CRF-403-->
			</form>
		</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

