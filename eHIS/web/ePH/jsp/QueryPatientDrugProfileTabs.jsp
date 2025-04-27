<!DOCTYPE html>
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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	   // String params=request.getQueryString();
		String patient_id	= request.getParameter("patient_id");
		String dt_from		= request.getParameter("dt_from");
		String dt_to		= request.getParameter("dt_to");
		String generic_id	= request.getParameter("generic_id");
		String drug_code	= request.getParameter("drug_code");
		String pat_class	= request.getParameter("pat_class");
		String status		=	request.getParameter("status");
		String called_frm  = request.getParameter("called_frm");
		String disp_locn_code = request.getParameter("disp_locn_code");	
		String mode = request.getParameter("mode");
		String click_yn = request.getParameter("click_yn")==null?"":request.getParameter("click_yn");	//Added for Bru-HIMS-CRF-081 [IN:029947]- Start
		String type = request.getParameter("type")==null?"":request.getParameter("type");	//Added for Bru-HIMS-CRF-081 [IN:029947]- Start
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); // encounter_id added for AAKH-CRF-0088.2
		String ReqDb	    =	request.getParameter("ReqDb")==null?"":request.getParameter("ReqDb");//Added for MMS-DM-CRF-115.4
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
		String videHideCriteriaDisplay="display:none;";
		if(called_frm.equals("Dispense") ){
			videHideCriteriaDisplay="display:inline;";
		}	//Added for Bru-HIMS-CRF-081 [IN:029947] - end
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<!-- Added for Bru-HIMS-CRF-081 [IN:029947] -->
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<table cellpadding='0' cellspacing='0' align="left" width='100%'>
			<tr>
				<td class="white" nowrap >
					<ul id="tablist" class="tablist" style="padding-left:0px">
					<li class="tablistitem" title='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'>
					<a onclick="javascript:objClick('<%=patient_id%>','<%=dt_from%>','<%=dt_to%>','<%=generic_id%>','<%=drug_code%>','<%=pat_class%>','<%=status%>','<%=called_frm%>','<%=disp_locn_code%>','<%=called_frm%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>')" class="tabClicked" id="DrugProfile_link">
					<span class="tabSpanclicked" id="DrugProfile_link_aspan"><fmt:message  key="Common.DrugProfile.label" bundle="${common_labels}"/></span>
					</a>
					</li>
					<li class="tablistitem" title='<fmt:message key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/>'>
					<a onclick="javascript:objClick1('<%=patient_id%>','<%=dt_from%>','<%=dt_to%>','<%=mode%>','<%=called_frm%>','<%=pat_class%>','<%=encounter_id %>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>')"class="tabA" id="ExternalDrugProfile_link"><!-- pat_class,encounter_id added for AAKH-CRF-0088.2 -->
					<span class="tabAspan" id="ExternalDrugProfile_link_aspan"><fmt:message  key="ePH.EXTERNALDRUGPROFILE.label" bundle="${ph_labels}"/></span>
					</a>
					</li><!--Added for Bru-HIMS-CRF-404 [IN:044795]--start -->
					<li class="tablistitem" title='<fmt:message key="Common.MedicalItem.label" bundle="${ph_labels}"/>'>
					<a onclick="javascript:objClick2('<%=patient_id%>','<%=drug_code%>','<%=dt_from%>','<%=dt_to%>','<%=mode%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>')"class="tabA" id="MedicalItemProfile_link">
					<span class="tabAspan" id="MedicalItemProfile_link_aspan"><fmt:message  key="Common.MedicalItem.label" bundle="${common_labels}"/></span>
					</a>
					</li><!-- //Added for Bru-HIMS-CRF-404 [IN:044795]--start -->
					</ul>
				</td>
				<td class="button" width='*' style='text-align:top;'> <!-- td added for Bru-HIMS-CRF-081 [IN:029947] -->
					<img src="../../ePH/images/uparrow.gif" id ="idViewHideCriteria" style="cursor:pointer;<%=videHideCriteriaDisplay%>" onClick="ViewHideCriteria(this,'Y')" height='20'  width='20'  title="Hide Criteria" value='V'>
					<img src="../../ePH/images/max.gif" id ="expand" style="cursor:pointer;display:none;" onClick="MaxDrugProfile('<%=patient_id%>', '<%=disp_locn_code%>', '<%=pat_class%>','T','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>')" height="17" width='17' title="Maximize Drug Profile" >
					<img src="../../eCommon/images/disabled.gif" id="Closebutton" height='20'  width='20' onclick="MinimizeDrugProfile('T')" valign="right"  title='Close Drug Profile' style="cursor:pointer;display:none;"></img>&nbsp;
				</td>
			</tr>
		</table>
	</body>
	<script>
<%
		if(type.equals("M")){
%>
			objClick2('<%=patient_id%>','<%=drug_code%>','<%=dt_from%>','<%=dt_to%>','<%=mode%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>');
<%
		}
		else{
%>
			objClick('<%=patient_id%>','<%=dt_from%>','<%=dt_to%>','<%=generic_id%>','<%=drug_code%>','<%=pat_class%>','<%=status%>','<%=called_frm%>','<%=disp_locn_code%>','<%=called_frm%>','<%=ReqDb%>','<%=enc_id1%>','<%=called_from%>');
<%
		}
		if(click_yn.equals("Y") && called_frm.equals("Dispense") ){	//if block added for Bru-HIMS-CRF-081 [IN:029947]
%>
			ViewHideCriteria(document.getElementById("idViewHideCriteria"),'N');
<%
		}
%>
	</script>
</html>

