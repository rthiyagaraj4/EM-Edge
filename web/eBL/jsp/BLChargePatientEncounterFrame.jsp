<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*,org.apache.commons.codec.binary.Base64" %>
<HTML>
<HEAD>
<script language='javascript' src='../../eBL/js/BLChargeEncounterNewOrder.js'></script>
<% 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String FacilityId = (String)session.getAttribute("facility_id");
String call_from  = request.getParameter("call_from");
String encounter_date	= request.getParameter("encounter_date");
String patient_id	="";
String encounter_id	="";
//V220412
System.err.println("encounter_date-"+encounter_date);
System.err.println("compressed,BLChargePatientEncounterFrame.jsp-"+request.getParameter("encoded"));
if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patient_id	= request.getParameter("patient_id");
	encounter_id	= request.getParameter("encounter_id");
}

System.err.println("BLChargePatientEncounterFrame.jsp-patient_id "+patient_id);
//V220412

String blng_grp_id	= request.getParameter("blng_grp_id");
String episode_id	= request.getParameter("episode_id");
String visit_id	= request.getParameter("visit_id");
String episode_type = request.getParameter("episode_type");
String payerGroup = request.getParameter("payerGroup");
String payer = request.getParameter("payer");

String userId = (String) session.getValue("login_user");
String reqParam = request.getQueryString();
call_from="IP";
//Encounter_Id="101044860001";
//patient_id=	"DU00002195";

System.out.println("BLChargePatientEncounterMainFrame.jsp1////////FacilityId/call_from/encounter_date/encounter_id/patient_id/blng_grp_id/episode_i/visit_idd"+FacilityId+"/"+call_from+"/"+encounter_date+"/"+encounter_id+"/"+patient_id+"/"+blng_grp_id+"/"+episode_id+"/"+visit_id);	

%>
    <title>Charge Patient</title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<input type='hidden' id='allFramesExisting' name='allFramesExisting'  value='7%,0%,0%,6%,25%,28%,28%,0%,4%'>
	<input type='hidden' id='allFramesNew' 		name='allFramesNew'  	 value='7%,0%,0%,6%,19%,30%,30%,0%,4%'>
	<input type='hidden' id='allFramesNewDtl' 	name='allFramesNewDtl' 	 value='7%,0%,0%,6%,0%,51%,32%,0%,4%'>
	<input type='hidden' id='allFramesNewRcrd' 	name='allFramesNewRcrd'   value='7%,0%,0%,6%,0%,32%,52%,0%,4%'>
	<input type='hidden' id='allFramesMessage' 	name='allFramesMessage'   value='7%,0%,0%,6%,25%,6%,28%,23%,4%'>
	<input type='hidden' id='framesAltered' 	name='framesAltered'   value='no'>
	<input type='hidden' id='reqParam' 	name='reqParam' id='reqParam'  value='<%=reqParam%>'>
	<script>
	function refresh(){
		var reqParam = BLChargePatientEncounterTabPage.document.forms[0].queryString.value;
		BLChargePatientEncounterTab.document.location.href = 'BLChargePatientEncounterTabs.jsp?selectedTab=ExistingOrder';
		BLChargePatientEncounterTabPage.document.location.href = "BLChargePatientEncounterExistingOrder.jsp?"+reqParam;
		BLChargePatientExisOrderTraverse.document.location.href = '../../eCommon/html/blank.html';
		BLChargePatientExisOrderServDetails.document.location.href = '../../eCommon/html/blank.html';
		BLChargePatientExisOrderServEdit.document.location.href = '../../eCommon/html/blank.html';
		messageFrame1.document.location.href = '../../eCommon/jsp/error.jsp';
	}

	function closeWindow(){
		//window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
	}
	</script>
</HEAD>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		    <iframe name='pline' id='pline' 	frameborder='0'	src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>&episode_type=<%=episode_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&EncounterId=<%=encounter_id %>'  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='BillingBanner' id='BillingBanner'	src='../../eCommon/html/blank.html'  frameborder=0  noresize style='height:0vh;width:100vw'></iframe> 				
			<iframe name='BillingMenu' id='BillingMenu' 	frameborder='0'	src="../../eCommon/html/blank.html"  scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
			<iframe name='BLChargePatientEncounterTab' id='BLChargePatientEncounterTab'	 src='BLChargePatientEncounterTabs.jsp?selectedTab=ExistingOrder'  frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw;margin-top: -15px;'></iframe>
			<iframe name='BLChargePatientEncounterTabPage' id='BLChargePatientEncounterTabPage'	src='BLChargePatientEncounterExistingOrder.jsp?<%=reqParam %>' frameborder=0 noresize scrolling='no' noresize style='height:22vh;width:100vw'></iframe>
			<iframe name='BLChargePatientExisOrderTraverse' id='BLChargePatientExisOrderTraverse'				src='../../eCommon/html/blank.html'  frameborder=0  noresize style='height:25vh;width:100vw'></iframe> 
			<iframe name='BLChargePatientExisOrderServDetails' id='BLChargePatientExisOrderServDetails'	src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:26vh;width:100vw'></iframe>
			<iframe name='BLChargePatientExisOrderServEdit' id='BLChargePatientExisOrderServEdit'	src='../../eCommon/html/blank.html'  frameborder=0 noresize style='height:0vh;width:100vw'></iframe>
			<iframe name='messageFrame1' id='messageFrame1'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
			
			
<!-- 			<iframe name='messageFrame1' id='messageFrame1'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
 -->		
		<%-- <FRAMESET id="BL_mainFrame" name="BL_mainFrame"  ROWS ='5%,0%,0%,5%,50%,29%,29%,0%,5%' framespacing=0 >			
			<frame name='pline'  id='pline' 		frameborder='0'	src="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>&episode_type=<%=episode_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&EncounterId=<%=encounter_id %>"  scrolling='no' noresize>
			<FRAME name='BillingBanner' id='BillingBanner'	src='../../eCommon/html/blank.html'  frameborder=0  noresize> 				
			<frame name='BillingMenu' id='BillingMenu' 	frameborder='0'	src="../../eCommon/html/blank.html"  scrolling='no' noresize>
			<FRAME name='BLChargePatientEncounterTab'  id='BLChargePatientEncounterTab'	 src='BLChargePatientEncounterTabs.jsp?selectedTab=ExistingOrder'  frameborder=0 scrolling='no' noresize>
			<FRAME name='BLChargePatientEncounterTabPage'  id='BLChargePatientEncounterTabPage'	src='BLChargePatientEncounterExistingOrder.jsp?<%=reqParam %>' frameborder=0 noresize scrolling='no' noresize>
			<FRAME name='BLChargePatientExisOrderTraverse'   id='BLChargePatientExisOrderTraverse'				src='../../eCommon/html/blank.html'  frameborder=0  noresize> 
			<FRAME name='BLChargePatientExisOrderServDetails'  id='BLChargePatientExisOrderServDetails'	src='../../eCommon/html/blank.html'  frameborder=0 noresize>
			<FRAME name='BLChargePatientExisOrderServEdit'  id='BLChargePatientExisOrderServEdit'	src='../../eCommon/html/blank.html'  frameborder=0 noresize>
			<frame name='messageFrame'  id='messageFrame'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='no' noresize>
		</FRAMESET> --%>
	
		
</HTML>


