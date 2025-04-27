<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String	selection_mode	=	"",		modal_title			=	"";
	Boolean isStartConsultationAppl	= false;//Modified by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
	Connection con 					= null;
	String bl_install_yn= (String) session.getValue( "bl_operational" ) ;

	selection_mode	=	(request.getParameter("selection_mode")==null)? "" : request.getParameter("selection_mode");
	String  encounter_id    =(request.getParameter("encounter_id")==null)? "" : request.getParameter("encounter_id");

	String	facilityId 			= (String) session.getValue( "facility_id" ) ;
		
	modal_title	                = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManagePatQ.label","common_labels");
 
	if(selection_mode.equals("AssignTreatmentArea"))		
	        modal_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignTreatArea.label","ae_labels");	
	if(selection_mode.equals("AssignReassignPractitioner"))	
	        modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReassignPract.label","common_labels");
	if(selection_mode.equals("ReassignTreatmentArea"))		
	         modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ReassignTreatArea.label","ae_labels");
	if(selection_mode.equals("StartConsultation"))			
	         modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartConsult.label","common_labels");		 
	try
	{
		con						= ConnectionManager.getConnection(request);  
		isStartConsultationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_START_CONSULTATION");//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623
%>
	<title><%=modal_title%></title>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String height1="";
	String height2="";
	String height3="";
	String height4="";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
	if(selection_mode.equals(""))
	{
		height1="80vh";
		height4="10vh";
%>  <!-- <frameset rows='100%,0%' > -->
	<iframe name='AEMPAllowedOperationsFrame' id='AEMPAllowedOperationsFrame' src='../../eAE/jsp/AEMPAllowedOperations.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:<%=height1 %>;width:98vw'></iframe>
<%
	}
	else if(selection_mode.equals("AssignTreatmentArea") || selection_mode.equals("AssignReassignPractitioner") || selection_mode.equals("ReassignTreatmentArea"))
	{

		if(bl_install_yn.equals("Y")){
		 	
			height1="20vh";
			height2="60vh";
			height3="0vh";
			height4="10vh";		
		%>
			<!-- <frameset rows='20%,130%,0%,0%' > -->
		<%}else{
			height1="20vh";
			height2="60vh";
			height4="10vh";
		
		%>
		<!-- <frameset rows='20%,120%,0%' > -->
<%}%>
	<iframe name='PatientLine' id='PatientLine' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>' frameborder=no scrolling='no' noresize style='height:<%=height1 %>;width:98vw'></iframe>
	<iframe name='AEMPAssignTreatmentAreaFrame' id='AEMPAssignTreatmentAreaFrame' src='../../eAE/jsp/AEMPAssignTreatmentArea.jsp?<%=request.getQueryString()%>&selection_mode=<%=selection_mode%>&isStartConsultationAppl=<%=isStartConsultationAppl%>' frameborder=0 scrolling='no' noresize style='height:<%=height2 %>;width:98vw'></iframe><!--Modified by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623-->
<%
			if(bl_install_yn.equals("Y")){%>
			<iframe name='billingfr' id='billingfr' src='../../eBL/jsp/BLSessionValuesReset.jsp' frameborder=0 noresize scrolling='no' style='height:<%=height3 %>;width:98vw'></iframe>
		<%}
	}
	else if(selection_mode.equals("StartConsultation"))
	{
		height1="80vh";
		height4="10vh";
		
%> <!--  <frameset rows='100%,0%' > -->
	<iframe name='AEMPStartConsultationFrame' id='AEMPStartConsultationFrame' src='../../eAE/jsp/AEMPStartConsultationMain.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:<%=height1 %>;width:98vw'></iframe>
<%
	}
%>  
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' noresize style='height:<%=height4 %>;width:98vw'></iframe>
<!-- </frameset>	 -->	
<%
	}catch(Exception e){ e.printStackTrace();}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</html>

