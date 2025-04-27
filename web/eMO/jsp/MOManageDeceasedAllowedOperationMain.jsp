<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<%
    request.setCharacterEncoding("UTF-8");
	String	selection_mode		=  "",		modal_title			=	"";
	String	select_registration	=  "";
	String	select_name			=  "";
	String	select_sex			=  "";
	String	select_area_desc	=  "";
	String select_pmyn			=  ""; 	
	String assign_area_code		=  "";
	String select_pmstatus		=  "";
	String area_type			=  "";
	String bed_no               =  "";
    String patient_id           =  "";
	String or_installyn         ="";
	String order_catalog_code="";
	String function_id="";
	String encounterId=	(request.getParameter("encounterId")==null)? "" : request.getParameter("encounterId");
	selection_mode		=	(request.getParameter("selection_mode")==null)? "" : request.getParameter("selection_mode");
	select_registration	=	request.getParameter("select_registration");
	select_name			=	request.getParameter("select_name");
	select_sex			=	request.getParameter("select_sex");
	select_area_desc	=	request.getParameter("select_area_desc");
	select_pmyn			=	request.getParameter("select_pmyn");
	assign_area_code	=	request.getParameter("assign_area_code");
	select_pmstatus		=	request.getParameter("select_pmstatus");
	select_pmyn			=	((select_pmyn==null) || (select_pmyn.equals(""))) ? "" : select_pmyn;
	select_pmstatus		=	((select_pmstatus==null) || (select_pmstatus.equals(""))) ? "" : select_pmstatus;
	assign_area_code	=	((assign_area_code==null) || (assign_area_code.equals(""))) ? "" : assign_area_code;
	area_type			=	request.getParameter("area_type")==null?"":request.getParameter("area_type");
	bed_no				=	request.getParameter("bed_no")==null?"":request.getParameter("bed_no");
	patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	function_id			=	request.getParameter("function_id")==null?"":request.getParameter("function_id");
 	order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	or_installyn=request.getParameter("or_installyn")==null?"":request.getParameter("or_installyn");
	String CLAIMANT_TYPE=	(request.getParameter("CLAIMANT_TYPE")==null)? "" : request.getParameter("CLAIMANT_TYPE"); // Bru-HIMS-CRF-366 [IN-039612]
	String RELEASE_TO_FACILITY=	(request.getParameter("RELEASE_TO_FACILITY")==null)? "" : request.getParameter("RELEASE_TO_FACILITY"); // Bru-HIMS-CRF-366 [IN-039612]
	modal_title			=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ManageDeceasedPatients.label","mo_labels");//	"Manage Deceased Patients";

	if(selection_mode.equals("AssignArea"))			
	modal_title		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.assignarea.label","common_labels"); //"Assign Area";

	if(selection_mode.equals("PostmortemRequest"))			
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemRequest.label","mo_labels");	//"Postmortem Request";
	
	if(selection_mode.equals("starAtpm"))			
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StartPM.label","mo_labels");//	"Start PM";

	if(selection_mode.equals("endpm"))				
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.EndPM.label","mo_labels"); //	"End PM";

	if(selection_mode.equals("reldec"))		
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseDeceased.label","mo_labels"); //	"Release Deceased";

	if(selection_mode.equals("expdoc"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ExportationDocument.label","mo_labels");//	"Exportation Document";

	if(selection_mode.equals("ReassignArea"))
	modal_title		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReassignArea.label","mo_labels");	//"Reassign Area";

	if(selection_mode.equals("StartConsultation"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartConsult.label","common_labels"); //	"Start Consultation";

	if(selection_mode.equals("UnAssignArea"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnAssignLocation.label","mo_labels");//	"UnAssign Location";

	
%>
	<title><%=modal_title%></title>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!-- <frameset rows='100%,0%' > -->
<%  //Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
	if(selection_mode.equals("a"))
	{
%>	<!--Below Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
	<iframe name='AEMPAllowedOperationsFrame' id='AEMPAllowedOperationsFrame' src='../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)  %>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&or_installyn=<%=java.net.URLEncoder.encode(or_installyn)%>&order_catalog_code=<%=java.net.URLEncoder.encode(order_catalog_code)%>&encounterId=<%=java.net.URLEncoder.encode(encounterId)%>&CLAIMANT_TYPE=<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>&RELEASE_TO_FACILITY=<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%
	}
//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
	else if(selection_mode.equals("AssignArea")||selection_mode.equals("ReassignArea"))
	{	
%>	<!--Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
	<iframe name='AEMPAssignAreaFrame' id='AEMPAssignAreaFrame' src='../../eMO/jsp/MOAssignAreaFrameset.jsp?function_id=<%=function_id%>&selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)%>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>&bed_no=<%=java.net.URLEncoder.encode(bed_no)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&CLAIMANT_TYPE=<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>&RELEASE_TO_FACILITY=<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%} 
	else if(selection_mode.equals("startpm"))
	{
	%>
	<iframe name='AEMPStartConsultationFrame' id='AEMPStartConsultationFrame' src='../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?&selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)%>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%
	}
	else if(selection_mode.equals("p"))
	{		
	%>
	<iframe name='AEMPAllowedOperationsFrame' id='AEMPAllowedOperationsFrame' src='../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?&selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)%>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%
	} else if(selection_mode.equals("bs") || selection_mode.equals("pam"))
	{
%>
	<iframe name='AEMPAllowedOperationsFrame' id='AEMPAllowedOperationsFrame' src='../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?&selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)%>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%} else if(selection_mode.equals("b")) 
{
%>	<!--Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->
	<iframe name='AEMPAllowedOperationsFrame' id='AEMPAllowedOperationsFrame' src='../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?function_id=<%=function_id%>&selection_mode=<%=java.net.URLEncoder.encode(selection_mode)%>&select_registration=<%=java.net.URLEncoder.encode(select_registration)%>&select_name=<%=java.net.URLEncoder.encode(select_name)%>&select_sex=<%=java.net.URLEncoder.encode(select_sex)%>&select_area_desc=<%=java.net.URLEncoder.encode(select_area_desc)%>&select_pmyn=<%=java.net.URLEncoder.encode(select_pmyn)%>&assign_area_code=<%=java.net.URLEncoder.encode(assign_area_code)%>&select_pmstatus=<%=java.net.URLEncoder.encode(select_pmstatus)%>&area_type=<%=java.net.URLEncoder.encode(area_type)%>&or_installyn=<%=java.net.URLEncoder.encode(or_installyn)%>&order_catalog_code=<%=java.net.URLEncoder.encode(order_catalog_code)%>&encounterId=<%=java.net.URLEncoder.encode(encounterId)%>&patient_id=<%=java.net.URLEncoder.encode(patient_id)%>&CLAIMANT_TYPE=<%=java.net.URLEncoder.encode(CLAIMANT_TYPE)%>&RELEASE_TO_FACILITY=<%=java.net.URLEncoder.encode(RELEASE_TO_FACILITY)%>' frameborder=0 scrolling='no' style='height:95vh;width:99vw'></iframe>
<%}%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' style='height:0vh;width:0vw'></iframe>
</frameset>		
</html>


