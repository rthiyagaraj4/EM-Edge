<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/MedicationAdministration.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
    <script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.RecordPRNDetails.label" bundle="${ph_labels}"/></title>
</head>
<%
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");

	String bean_id	= "MedicationAdministrationFTBean";
	String bean_name= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);
	HashMap prn_drugs = bean.getPRNDrugs(patient_id,encounter_id);
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="prn_details" id="prn_details" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
		<tr>
			<th><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/></th>
			<th><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			if(prn_drugs!=null){
				String classvalue	  = "";
				ArrayList drugs = new ArrayList();
				for (int i=1;i<=prn_drugs.size();i++){
					drugs = (ArrayList)prn_drugs.get(i+"");
					if ( i % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;	
		%>
		<tr>
			<td class="<%=classvalue%>">
				<%=drugs.get(1)%>
			</td>
			<td class="<%=classvalue%>">
				<%=drugs.get(2)%>
			</td>
			<td class="<%=classvalue%>">
				<%=drugs.get(3)%>
			</td>
			<td   class="<%=classvalue%>">
				<input type="checkbox" name="chk_prn_select_<%=i%>" id="chk_prn_select_<%=i%>" >
			</td>
		</tr>				
		<%
				}
			}
		%>
	</table>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

