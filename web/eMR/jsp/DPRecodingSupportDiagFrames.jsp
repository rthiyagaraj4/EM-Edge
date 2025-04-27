<!DOCTYPE html>
 <!-- 
	1.Page was created for SRR-CRF-303.2
	2.For Recoding astriks for a Dagger.
	3.Created On 1/28/2010
--> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%
		String sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		String associate_codes	= checkForNull(request.getParameter("associate_codes"));
		String activity				= checkForNull(request.getParameter("activity"));
		String calling_status		= checkForNull(request.getParameter("calling_status"));
		String term_set				= checkForNull(request.getParameter("term_set"));
		String term_code			= checkForNull(request.getParameter("term_code"));
		String encounter_id		= checkForNull(request.getParameter("EncounterId"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String occur_srl_no		= checkForNull(request.getParameter("occur_srl_no"));
		String stage_no_disp		= checkForNull(request.getParameter("stage_no_disp"));
		String support_seq_no	= checkForNull(request.getParameter("support_seq_no"));
		String Group_seq_no	= checkForNull(request.getParameter("Group_seq_no"));
		String group_YN			= checkForNull(request.getParameter("group_YN"));
		String trx_no					= checkForNull(request.getParameter("trx_no"));
		String supprt_diag_view	= checkForNull(request.getParameter("supprt_diag_view"));
		String diagprob_code_val		= checkForNull(request.getParameter("diagprob_code_val"));//diagprob_code_val value is only sent to  DPRecodingUnlinkedSupportDiag.jsp only because the Support Diagnosis is wil be recorded from Adding New Code & Recoding a Code.
		String record_assosicate_codes_0		= checkForNull(request.getParameter("record_assosicate_codes_0"));
		String record_assosicate_codes_1		= checkForNull(request.getParameter("record_assosicate_codes_1"));
		String record_assosicate_codes_2		= checkForNull(request.getParameter("record_assosicate_codes_2"));
		String hdr_modified_dt							= checkForNull(request.getParameter("hdr_modified_dt"));


		String FrameSettings		= "";

		if(activity.equals("RECORD")){
			FrameSettings	="4%,*,5%,3%,0%";
		}else if(activity.equals("RECODE")){
			FrameSettings	="46%,47%,4%,3%,0%";
		}

%>
<html>
	<head>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<title><fmt:message key="Common.SupportingDiagnosis.label" bundle="${common_labels}"/></title>
	</head>
	</html>
	<iframe name="Linked_Support_Diag_Frame" id="Linked_Support_Diag_Frame" frameborder="no" scrolling="NO" noresize src="../../eMR/jsp/DPRecodingLinkedSupportDiag.jsp?calling_status=<%=calling_status%>&associate_codes=<%=associate_codes%>&term_set=<%=term_set%>&term_code=<%=term_code%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&occur_srl_no=<%=occur_srl_no%>&stage_no_disp=<%=stage_no_disp%>&support_seq_no=<%=support_seq_no%>&Group_seq_no=<%=Group_seq_no%>&group_YN=<%=group_YN%>&trx_no=<%=trx_no%>&supprt_diag_view=<%=supprt_diag_view%>">
		</iframe>
		<%if(activity.equals("RECODE")){%>
			<iframe name="Unlinked_Support_Diag_Frame" id="Unlinked_Support_Diag_Frame" frameborder="no" scrolling="NO" noresize src="../../eMR/jsp/DPRecodingUnlinkedSupportDiag.jsp?calling_status=<%=calling_status%>&associate_codes=<%=associate_codes%>&term_set=<%=term_set%>&term_code=<%=term_code%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&occur_srl_no=<%=occur_srl_no%>&stage_no_disp=<%=stage_no_disp%>&support_seq_no=<%=support_seq_no%>&Group_seq_no=<%=Group_seq_no%>&group_YN=<%=group_YN%>&trx_no=<%=trx_no%>&diagprob_code_val=<%=diagprob_code_val%>&supprt_diag_view=<%=supprt_diag_view%>"/>
		<%}else{%>
			<iframe name="Record_Support_Diag_Frame" id="Record_Support_Diag_Frame" frameborder="no" scrolling="NO" noresize src="../../eMR/jsp/DPRecordSupportDiagnosis.jsp?calling_status=<%=calling_status%>&associate_codes=<%=associate_codes%>&term_set=<%=term_set%>&term_code=<%=term_code%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&occur_srl_no=<%=occur_srl_no%>&stage_no_disp=<%=stage_no_disp%>&support_seq_no=<%=support_seq_no%>&Group_seq_no=<%=Group_seq_no%>&group_YN=<%=group_YN%>&trx_no=<%=trx_no%>&diagprob_code_val=<%=diagprob_code_val%>&record_assosicate_codes_0=<%=record_assosicate_codes_0%>&record_assosicate_codes_1=<%=record_assosicate_codes_1%>&record_assosicate_codes_2=<%=record_assosicate_codes_2%>&supprt_diag_view=<%=supprt_diag_view%>"/>
		<%}%>
		</iframe>
		<iframe name="Support_Diag_BTN_Frame" id="Support_Diag_BTN_Frame" frameborder="no" scrolling="NO" noresize src="../../eMR/jsp/DPRecodingSupportDiagBtns.jsp?calling_status=<%=calling_status%>&term_set=<%=term_set%>&term_code=<%=term_code%>&encounter_id=<%=encounter_id%>&patient_id=<%=patient_id%>&occur_srl_no=<%=occur_srl_no%>&stage_no_disp=<%=stage_no_disp%>&support_seq_no=<%=support_seq_no%>&Group_seq_no=<%=Group_seq_no%>&group_YN=<%=group_YN%>&trx_no=<%=trx_no%>&activity=<%=activity%>&supprt_diag_view=<%=supprt_diag_view%>&hdr_modified_dt=<%=hdr_modified_dt%>">
		</iframe>
		<iframe name="messageFrame" src='../../eCommon/jsp/MstCodeError.jsp' name='messageFrame' id='messageFrame' noresize frameborder="no" scrolling='NO'></iframe><iframe name="targetFrame" src='../../eCommon/jsp/MstCodeError.jsp' name='targetFrame' id='targetFrame' noresize frameborder="no" scrolling='NO'></iframe>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


