<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script> <!--Added for this CRF ML-MMOH-CRF-0566-->
<html>
<%
	request.setCharacterEncoding("UTF-8");
   int bed_block_period_dis_int = 0;
   int dis_date_chk_days_int	= 0;

    String facilityId			= (String)session.getValue("facility_id");
	String encounterid			= checkForNull(request.getParameter("encounterId"));
	String patientid			= checkForNull(request.getParameter("patientid"));
	String called_from			= checkForNull(request.getParameter("called_from"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String function_id		= checkForNull(request.getParameter("function_id"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	
	//Added for this CRF ML-MMOH-CRF-0566
	String callfrom = checkForNull(request.getParameter("callfrom"));
	

	String bed_block_period_dis	= checkForNull(request.getParameter("bed_block_period_dis"));
	if(!bed_block_period_dis.equals(""))
		bed_block_period_dis_int = Integer.parseInt(bed_block_period_dis);

	String dis_date_chk_days	= checkForNull(request.getParameter("dis_date_chk_days"));
	if(!dis_date_chk_days.equals(""))
		dis_date_chk_days_int = Integer.parseInt(dis_date_chk_days);

	String title = "";
	if(call_function.equals("BedSideReferral"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmBedsideReferral.label","common_labels");
	}
	else
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterInpatientReferral.label","common_labels");
	}

	if(function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AssignPractitionerBedsideReferral.label","ip_labels");
	}

	String wherecondn	= "ADMIT_PAT_YN";
    String referral_id	= checkForNull(request.getParameter("referralID"));

	if(call_function.equals("ReferralPatientDetails") && called_from.equals("CA") )
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedSideReferral.label","common_labels");
		
//Below line frameset modified  for this CRF ML-MMOH-CRF-0566 
%>
	<head><title><%=title%></title></head>
	<iframe name="PatientLine_frame" id="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounterid%>"  scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	   <iframe name="Transfer_frame" id="Transfer_frame" src="../../eIP/jsp/addModifyRefPatientDtls.jsp?function_id=<%=function_id%>&encounter_id=<%=encounterid%>&function_id=<%=function_id%>&call_function=<%=call_function%>&wherecondn=<%=wherecondn%>&referral_id=<%=referral_id%>&bed_block_period_dis=<%=bed_block_period_dis_int%>&dis_date_chk_days=<%=dis_date_chk_days_int%>&oper_stn_id=<%=oper_stn_id%>&called_from=<%=called_from%>&patientid=<%=patientid%>&callfrom=<%=callfrom%>"  scrolling='auto' noresize style='height:85vh;width:100vw'></iframe>
	   <iframe src="../../eCommon/jsp/error.jsp" name="Dummy_frame" id="Dummy_frame" scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
	
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>

