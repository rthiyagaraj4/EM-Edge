<!DOCTYPE html>
<%
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 6 SEP 2004
/// Function		: File used to define frames & will be called from Discharge Advice [IP] / Discharge Patient [IP] / CheckOut [OP/AE] Functions...  
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
%>

 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityID		= (String) session.getValue("facility_id");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%	
	String Transaction_type	= request.getParameter("Transaction_type");
		if(Transaction_type == null)	Transaction_type = "";
	
	/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
	String called_from	= request.getParameter("called_from");
		if(called_from == null)	called_from = "";

	String patient_class = request.getParameter("patient_class");
		if(patient_class == null)	patient_class = "";

	String encounterid = "";

	if(called_from.equals("CA")){
		encounterid	= request.getParameter("encounter_id");
			if(encounterid	== null	) encounterid = "";

		if(patient_class.equals("IP")){
			Transaction_type = "DP";
		}else if(patient_class.equals("DC")){
			Transaction_type = "DA";
		}else{
			Transaction_type = "CO";
		}
	}else{
		encounterid	= request.getParameter("EncounterId");
			if(encounterid	== null	) encounterid = "";
	}
	/*End MMS-DM-CRF-0187*/

	String patient_id		= request.getParameter("patient_id");
		if(patient_id	== null	) patient_id = "";
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
	String referral_id1		= request.getParameter("referral_id");
		if(referral_id1	== null	) referral_id1 = "";

	String recFun		= request.getParameter("recFun");
		if(recFun	== null	) recFun = "";

	String recFunVal		= request.getParameter("recFunVal");
		if(recFunVal	== null	) recFunVal = "";
	String EncounterId		= request.getParameter("EncounterId");
	if(EncounterId	== null	) EncounterId = "";	
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 	
	String Module			= request.getParameter("Module");
		if(Module == null)	Module = "";

	String discharge_indicator	= request.getParameter("discharge_indicator");
		if(discharge_indicator == null)	discharge_indicator = "";	

	String from_patient_id		= checkForNull(request.getParameter("from_patient_id"));
	String from_locn_type		= checkForNull(request.getParameter("from_locn_type"));
	String from_service_code	= checkForNull(request.getParameter("from_service_code"));
	String from_specialty_code	= checkForNull(request.getParameter("from_specialty_code"));
	String from_practitioner_id	= checkForNull(request.getParameter("from_practitioner_id"));
	String from_practitioner_name = checkForNull(request.getParameter("from_practitioner_name"));
	String from_nursing_unit_code = checkForNull(request.getParameter("from_nursing_unit_code"));
	String from_nursing_unit_short_desc	= checkForNull(request.getParameter("from_nursing_unit_short_desc"));
	String regOutref= checkForNull(request.getParameter("functions_id"));

	String function_id= checkForNull(request.getParameter("function_id")); //this line Added for this CRF-Bru-HIMS-CRF-261
   /*Below line modified for this CRF HSA-CRF-0263.1*/
	String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
	String height1="";
	String height2="";
	String height3="";
	String height4="";
	
	%>
		<title>
			 <%if(function_id.equals("RegPatRefFromAEAssessment")){%>
				<fmt:message key="eMP.RegisterPatientReferral.label" bundle="${mp_labels}"/>
			<%}else if(recFun.equals("ModifyReferral")) { %>
				<fmt:message key="eOT.edit.Label" bundle="${ot_labels}"/>&nbsp;
				<fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/>
			<%}else{ %>
				<fmt:message key="eMP.RegisterReferraldetails.label" bundle="${mp_labels}"/>
			<%} %>
		</title>
	<%	
	if(Transaction_type.equals("DP"))
	{	
	/*Below line modified for this CRF HSA-CRF-0263.1*/	
	%>
          <!--Below line  modified for this CRF-Bru-HIMS-CRF-261 -->
      <%if(!function_id.equals("RegPatRefFromAEAssessment")){
    	  /* <frameset rows='40%,175%,80%,0%'>  */
    	  height1="10vh";
		  height2="52vh";
		  height3="36vh";
		  height4="0vh";
	 }else{
		 /* 	<frameset rows='40%,175%,0%,0%'>*/
		 height1="10vh";
		 height2="85vh";
		 height3="0vh";
		 height4="0vh";
	  }%>
			<iframe NAME='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facilityID%>' noresize  frameborder='no' scrolling='no' style='height:<%=height1%>;width:99vw'></iframe>
			<iframe name='Referral_Detail_frame' 	 src='../../eMP/jsp/ReferralDetails.jsp?EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&Module=<%=Module%>&patient_id=<%=patient_id%>&discharge_indicator=<%=discharge_indicator%>&Transaction_type=<%=Transaction_type%>&regOutref=<%=regOutref%>&from_patient_id=<%=from_patient_id%>&from_locn_type=<%=from_locn_type%>&from_service_code=<%=from_service_code%>&from_specialty_code=<%=from_specialty_code%>&from_practitioner_id=<%=from_practitioner_id%>&from_practitioner_name=<%=from_practitioner_name%>&from_nursing_unit_code=<%=from_nursing_unit_code%>&from_nursing_unit_short_desc=<%=from_nursing_unit_short_desc%>&function_id=<%=function_id%>&allow_muti_bedside_review_yn=<%=allow_muti_bedside_review_yn%>&recFun=<%=recFun%>&recFunVal=<%=recFunVal%>' frameborder=0 scrolling='no' noresize style='height:<%=height2%>;width:99vw'></iframe> 
			<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 Start -->
			<%if(!function_id.equals("RegPatRefFromAEAssessment")){%>
				<iframe name='Referral_Result_frame' src='../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&Module=<%=Module%>&patient_id=<%=patient_id%>&Transaction_type=<%=Transaction_type%>&allow_muti_bedside_review_yn=<%=allow_muti_bedside_review_yn%>&recFun=<%=recFun%>&recFunVal=<%=recFunVal%>' frameborder=0 scrolling='no' noresize style='height:<%=height3%>;width:99vw'></iframe>
			<%}else{ %>
				<iframe name='Referral_Result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:<%=height3%>;width:99vw'></iframe>
			<%} %>
			<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 End -->
			
			<iframe name='messageFrame1' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:<%=height4%>;width:99vw'></iframe>
		<!-- </frameset> -->

	<%	
	}
	else if(Transaction_type.equals("DA") || Transaction_type.equals("CO"))
	{
	
	if(!function_id.equals("RegPatRefFromAEAssessment")){
		/* <frameset rows='40%,240%,60%,0%'> */
		height1="10vh";
		height2="52vh";
		height3="36vh";
		height4="0vh";
	}else{
		/* <frameset rows='40%,225%,0%,0%'> */
		height1="10vh";
		height2="85vh";
		height3="0vh";
		height4="0vh";
	}%> <!--Below line  modified for this CRF-Bru-HIMS-CRF-261 -->
			<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facilityID%>' noresize  frameborder='no' scrolling='no' style='height:<%=height1%>;width:99vw'></iframe>
			<iframe name='Referral_Detail_frame' id='Referral_Detail_frame' src='../../eMP/jsp/ReferralDetails.jsp?EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&Module=<%=Module%>&patient_id=<%=patient_id%>&discharge_indicator=<%=discharge_indicator%>&Transaction_type=<%=Transaction_type%>&regOutref=<%=regOutref%>&function_id=<%=function_id%>&allow_muti_bedside_review_yn=<%=allow_muti_bedside_review_yn%>&recFun=<%=recFun%>&recFunVal=<%=recFunVal%>&referral_id=<%=referral_id1 %>' frameborder=0 scrolling='auto' noresize style='height:<%=height2%>;width:99vw'></iframe>
			<!-- below "Referral_Result_frame" added by Venkatesh.S on 21/12/2012 againist 36866 -->
			<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 Start -->
			<%if(!function_id.equals("RegPatRefFromAEAssessment") && !recFun.equals("for_admission")){%>
				<iframe name='Referral_Result_frame' id='Referral_Result_frame' src='../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&Module=<%=Module%>&patient_id=<%=patient_id%>&Transaction_type=<%=Transaction_type%>&allow_muti_bedside_review_yn=<%=allow_muti_bedside_review_yn%>&recFun=<%=recFun%>&referral_id=<%=referral_id1 %>' frameborder=0 scrolling='no' noresize style='height:<%=height3%>;width:99vw'></iframe>
			<%}else{ %>
				<iframe name='Referral_Result_frame' id='Referral_Result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:<%=height3%>;width:99vw'></iframe>
			<%} %>
			<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 End -->
			<iframe name='messageFrame1' id='messageFrame1' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:<%=height4%>;width:99vw'></iframe>
		<!-- </frameset> -->
	<%	
	}	
	%>
</html>

<%!
public static String checkForNull(String inputString)
{
	return((inputString == null) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}	
%>
