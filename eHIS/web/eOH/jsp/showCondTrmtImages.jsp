<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String title = "";
	try{
		con=ConnectionManager.getConnection(request);
	%>

<html>
	<head>
	<!-- <title><%=title%></title>  -->
		<title>
			<fmt:message key='eOH.ImagesDefinition.Label' bundle='${oh_labels}'/>
		</title> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	
	<div STYLE=" height: 500px; width: 350px; font-size: 12px; overflow: auto;">
	  	<table border=1 cellpadding=0 cellspacing=0 width="100%" align="left" >
			<!-- <tr>
				<td class="CAGROUPHEADING" colspan="2" style="text-align:center"><fmt:message key='eOH.ImageDescriptionForConditions.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td class='columnHeader' WIDTH="10%" style="text-align:center"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' WIDTH="25%" style="text-align:center"><fmt:message key='Common.Condition.label' bundle='${common_labels}'/></td>
			</tr>
			<!-- <tr>
				<td width="7%" align="center" class="QRYODD"><img align="center" src="../../eOH/images/Cavity.gif"   border="0" alt="Cavity"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Cavity.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img align="center" src="../../eOH/images/Trauma.gif" alt="Trauma"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='Common.Trauma.label' bundle='${common_labels}'/></td>
			</tr>
			<!-- <tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/CrownEffected.gif" alt="Crown Effected"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.CrownEffected.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Root-Effected.gif" alt="Root Effected"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.RootEffected.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/WholeToothEffected.gif" alt="Whole Tooth Effected"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.WholeToothEffected.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/AttritionAbrationErotion.gif" alt="Attrition/Abration/Erosion"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.AttritionAbrationErotion.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/SuperNumerary.gif" alt="Super Numary"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.SuperNumerary.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/MissingTeeth.gif" alt="Missing Teeth"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.MissingTooth.Label' bundle='${oh_labels}'/></td>
			</tr>
			<!-- <tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Impaction.gif" alt="Impaction"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Impaction.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/PartialEruption.gif" alt="Partial Eruption"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.PartialEruption.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Uneruption.gif" alt="Uneruption"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Uneruption.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Impaction-Normal.gif" alt="Impaction-Normal"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.ImpactionNormal.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Mobility.gif" alt="Mobility"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Mobility.Label' bundle='${oh_labels}'/></td>
			</tr>
			<!-- Added by Sharon Crasta on 1/28/2010 for SRR20056-CRF-0498(IN010982)-->
			<!-- Added to display the images for Mal position and Mal Occlusion-->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/MalOcclution.gif" alt="Mal Occlusion"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Malocclusion.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/MalPosition.gif" alt="Mal Position"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Malposition.Label' bundle='${oh_labels}'/></td>
			</tr>
			
			<!-- -->
			<!-- <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Mobility.gif" alt="Mobility"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Mobility.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Exfoliation.gif" alt="Exfoliation"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Exfoliation.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Decedious.gif" alt="Decedious Dentition"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Decedious.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Decedious-Retained.gif" alt="Retained Decedious"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.DecediousRetained.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr></tr> <tr></tr> <tr></tr> <tr></tr> <tr></tr> 
			<tr></tr> <tr></tr> <tr></tr> <tr></tr> <tr></tr> 
			<!-- <tr>
				<td class="CAGROUPHEADING" colspan="2" style="text-align:center"><fmt:message key='eOH.ImageDescriptionForTreatments.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td class="columnHeader" WIDTH="10%" style="text-align:center"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
				<td class="columnHeader" WIDTH="25%" style="text-align:center"><fmt:message key='Common.Treatment.label' bundle='${common_labels}'/></td>
			</tr>
			<!-- <tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/CavityFilling.gif" alt="Cavity Filling"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.CavityFilling.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/RootFilling.gif" alt="Root Filling"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.RootFilling.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Extraction-CrownYellow.gif" alt="Extraction" height="16" width="18"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Extraction(Planned).Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Extraction-CrownGreen.gif" alt="Extraction" height="16" width="18"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Extraction(Performed).Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/ExtractionFailTool.gif" alt="ExtractionFail" height="16" width="18"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Extraction(Performed)Fail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/ImplantTool.gif" alt="Implant"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='Common.Implant.label' bundle='${common_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/ImplantFailTool.gif" alt="ImplantFail"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImplantFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<!-- <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Surgery.gif" alt="Surgery"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='Common.Surgery.label' bundle='${common_labels}'/></td>
			</tr> -->
			<!-- <tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Crown.gif" alt="Crown"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Crown.Label' bundle='${oh_labels}'/></td>
			</tr> -->
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/DentureTool.gif" alt="Denture"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Denture.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/DentureFailTool.gif" alt="DentureFail"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.DentureFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Bridge.gif" alt="Bridge"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Bridge.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Bridge_F.gif" alt="BridgeFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.BridgeFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Ortho.gif" alt="Ortho"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.OrthodonticAppliance.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Ortho_Fail.gif" alt="OrthoFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.OrthodonticApplianceFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Impaction-Treatment_F.gif" alt="Impaction-TreatmenFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImpactionTreatmentFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Impaction-Treatment.gif" alt="Impaction-Treatment"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImpactionTreatment.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/TRMT_Perf.gif" alt="Impaction-Treatment"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ToothTrmt(Performed).Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/TRMT_Perf_F.gif" alt="Impaction-TreatmentFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ToothTrmt(Performed)Fail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/TRMT_Planned.gif" alt="Impaction-Normal"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.ToothTrmt(Planned).Label' bundle='${oh_labels}'/></td>
			</tr>
			 <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownUpTool.gif" alt="CrownUP"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForLA.Label' bundle='${oh_labels}'/></td>
			</tr>
			 <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownUpFailTool.gif" alt="CrownUPFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForLAFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownDownTool.gif" alt="CrownDown"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForUA.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownDownToolfail.gif" alt="CrownDownFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForUAFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<!--Added by Sharon Crasta on 2/26/2010 for SRR20056-CRF-0475-->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/AbutmentTool.gif" alt="Abutment"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Abutment.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/AbutmentFailTool.gif" alt="AbutmentFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.AbutmentFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/PonticTool.gif" alt="Pontic"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Pontic.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/ponticFailTool.gif" alt="PonticFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.PonticFail.Label' bundle='${oh_labels}'/></td>
			</tr>
               

			  <tr></tr> <tr></tr> <tr></tr> <tr></tr> <tr></tr> 
			<tr></tr> <tr></tr> <tr></tr> <tr></tr> <tr></tr> 
		
			<tr>
				<td class="columnHeader" WIDTH="10%" style="text-align:center"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
				<td class="columnHeader" WIDTH="25%" style="text-align:center"><fmt:message key='eOH.ExternalTreatment.Label' bundle='${oh_labels}'/></td>
			</tr>
			
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/ExtractionExternalTool.gif" alt="ExtractionExternal" height="16" width="18"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Extraction(Performed).Label' bundle='${oh_labels}'/></td>
			</tr>
			
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/ExtractionExternalFailTool.gif" alt="ExtractionFail" height="16" width="18"/></td>
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Extraction(Performed)Fail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/ImplantExternalTool.gif" alt="Implant"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='Common.Implant.label' bundle='${common_labels}'/></td>
			</tr>

			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/ImplantExternalFailTool.gif" alt="ImplantFail"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImplantFail.Label' bundle='${oh_labels}'/></td>
			</tr>
		
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/DentureExternalTool.gif" alt="Denture"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.Denture.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/DentureExternalFailTool.gif" alt="DentureFail"/></td>
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.DentureFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/BridgeExternalTool.gif" alt="Bridge"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Bridge.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/BridgeExternalFailTool.gif" alt="BridgeFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.BridgeFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Ortho_E.gif" alt="Ortho"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.OrthodonticAppliance.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/Ortho_EF.gif" alt="OrthoFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.OrthodonticApplianceFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Impaction-Treatment_E.gif" alt="Impaction-Treatment"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImpactionTreatment.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/Impaction-Treatment_EF.gif" alt="Impaction-TreatmenFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ImpactionTreatmentFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/TRMT_Perf_ExternalTool.gif" alt="Impaction-Treatment"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ToothTrmt(Performed).Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYODD"><img src="../../eOH/images/TRMT_Perf_ExtarnalFailTool.gif" alt="Impaction-TreatmentFail"/></td> 
				<td width="25%"  class="QRYODD"><fmt:message key='eOH.ToothTrmt(Performed)Fail.Label' bundle='${oh_labels}'/></td>
			</tr>
			
			 <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownUpExternaTool.gif" alt="CrownUP"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForLA.Label' bundle='${oh_labels}'/></td>
			</tr>
			 <tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownUpExternalFailureTool.gif" alt="CrownUPFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForLAFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownDownExternalTool.gif" alt="CrownDown"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForUA.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/CrownDownExternalfailureTool.gif" alt="CrownDownFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.CrownForUAFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<!--Added by Sharon Crasta on 2/26/2010 for SRR20056-CRF-0475-->
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/AbutmentExternalTool.gif" alt="Abutment"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Abutment.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/AbutmenExternalFailTool.gif" alt="AbutmentFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.AbutmentFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/PonticExternalTool.gif" alt="Pontic"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.Pontic.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="7%" align="center" class="QRYEVEN"><img src="../../eOH/images/PonticExternalFailTool.gif" alt="PonticFail"/></td> 
				<td width="25%"  class="QRYEVEN"><fmt:message key='eOH.PonticFail.Label' bundle='${oh_labels}'/></td>
			</tr>
			<tr>
				<td width="25%" colspan="2" class="button"> 
					<input class="button" type="button" name="" id="" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();">
				</td>
			</tr>
		</table>
		 </div>
	</body>
</html>

<%
}catch ( Exception e ) {							    
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

