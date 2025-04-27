<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");

	String generic_name	=	request.getParameter("generic_name")==null?"":request.getParameter("generic_name"); 
	String drug_name	=	request.getParameter("drug_name")==null?"":request.getParameter("drug_name"); 
	String generic_id	=	request.getParameter("generic_id");
	String patient_id	=	request.getParameter("patient_id");
	String encounter_id	=	request.getParameter("encounter_id");
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	bean.setLanguageId(locale);
	HashMap details				= null;
	ArrayList allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
	String ATC_allergy ="";
	if((allergyDetails==null || allergyDetails.size()==0 )){
		ATC_allergy = presBean.getATCAllergyAlertGeneric(patient_id,generic_id);
		if(ATC_allergy!=null && !ATC_allergy.equals("0")){
			generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
			generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
			allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
		}
	}
	String classValue	=	"";
	String strCausative = "", strAllergy_Alert_By="";	// Added for RUT-CRF-0065.1 [IN:43255] start
	if(allergyDetails!=null&&allergyDetails.size()>0){
		details	=(HashMap) allergyDetails.get(0);
		strCausative = (String)details.get("CAUSATIVE_SUBSTANCE");
		strAllergy_Alert_By = (String)details.get("ALLERGY_ALERT_BY");
		if(generic_name.equals(""))
			generic_name = (String)details.get("GENERIC_NAME");
	}		// Added for RUT-CRF-0065.1 [IN:43255] end
%>
	<html>
		<head>
			<title><fmt:message key="ePH.AllergyIndications.label" bundle="${ph_labels}"/></title>
			<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<% 
			if(allergyDetails.size()>0){
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
					<tr>
						<th class="QRYEVEN" colspan="4" width="100%"  style='text-align:left;'>
<%
						if(strAllergy_Alert_By.equals("D")){ //Added for RUT-CRF-0065.1 [IN:43255] 
%> 
							<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>:&nbsp;<b><%=drug_name%></b>
<%
						}
						else{ 
%>
							<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>:&nbsp;<b><%=generic_name%></b>
<%
						} 
%>
						<input type="hidden" name="dummy" id="dummy"></th>
					</tr>
					<tr>
						<td class="QRYEVEN" colspan="4" width="100%" style='text-align:center;' ><b><fmt:message key="ePH.AllergyDescription.label" bundle="${ph_labels}"/></b>
					</tr>
					<tr>
						<th class="QRYEVEN" width='3%'>&nbsp;</th>
						<th class="QRYEVEN" width="50%"  style='text-align:left;'>&nbsp;<fmt:message key="ePH.ReactionDetail.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th class="QRYEVEN" width="25%"  style='text-align:left;'>&nbsp;<fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;</th>
						<th class="QRYEVEN" width="25%"  style='text-align:left;'>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;</th>
					</tr>
<%
					 String allergic_indications	= "", severity="";

					 for(int i=0;i<allergyDetails.size();i++){

						if(i%2==0) 
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";

						details			  =(HashMap) allergyDetails.get(i);
						allergic_indications = (String)details.get("ALLERGIC_INDICATIONS")==null?"":(String)details.get("ALLERGIC_INDICATIONS");
						severity = (String)details.get("SEVERITY")==null?"":(String)details.get("SEVERITY");
						if(severity.equals("M")){
							severity=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
						}
						else if(severity.equals("O")){
							severity=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labelsels");
						}
						else if(severity.equals("S")){
							severity=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
						}
						else if(severity.equals("U")){
							severity=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}
						//int j=i+1;
						//if(allergic_indications != null && !allergic_indications.equals("")){
%>
							<tr>
								<td class="<%=classValue%>" width="3%" ><b>&nbsp;&nbsp;.&nbsp;</b></td>
								<td class="<%=classValue%>" width="50%" ><%=allergic_indications%>&nbsp;</td>
								<td class="<%=classValue%>" width="25%" ><%=severity%>&nbsp;</td>
								<td class="<%=classValue%>" width="25%" ><%=(String)details.get("REAC_DATE")%></td>
							</tr>
<%
						//}
					}//for
%>
				</table>
<%
			}//if
%>
		</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

