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
//	String locale					= checkForNull((String)session.getAttribute("LOCALE"));
//	String FacilityId				= checkForNull((String) session.getValue( "facility_id" ));
	String activity				= checkForNull(request.getParameter("activity" ));
	String calling_status		= checkForNull(request.getParameter("calling_status" ));
	String encounter_id		= checkForNull(request.getParameter("encounter_id"));
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String term_set				= checkForNull(request.getParameter("term_set"));
	String term_code			= checkForNull(request.getParameter("term_code"));
	String occur_srl_no		= checkForNull(request.getParameter("occur_srl_no"));
	String stage_no_disp		= checkForNull(request.getParameter("stage_no_disp"));
	String support_seq_no	= checkForNull(request.getParameter("support_seq_no"));
	String trx_no					= checkForNull(request.getParameter("trx_no"));
	String Group_seq_no	= checkForNull(request.getParameter("Group_seq_no"));
	String group_YN			= checkForNull(request.getParameter("group_YN"));
	String supprt_diag_view	= checkForNull(request.getParameter("supprt_diag_view"));
	String hdr_modified_dt		= checkForNull(request.getParameter("hdr_modified_dt"));
	String disp_save_btn		=	"";
	String disp_ok_btn		=	"";
	if(activity.equals("RECORD")){
		disp_save_btn	="none";
		disp_ok_btn		="inline";
	}else if(activity.equals("RECODE") && calling_status.equals("ORIGINAL") ){
		disp_save_btn	="none";
		disp_ok_btn		="none";
	}else if(activity.equals("RECODE")){
			if(supprt_diag_view.equals("E")){
				disp_save_btn	="inline";
			}else{
				disp_save_btn	="none";
			}
			disp_ok_btn		="none";
	}
	
%>
<html>
	<head>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	</head>
	<body>
		<form name="supprt_diag_btn_form" id="supprt_diag_btn_form">
				<table align='right' width='100%' cellspacing='0' cellpadding='0'>
					<tr><td align="right" colspan='0'><input type="button" class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' name ="ok" style="display:<%=disp_ok_btn%>" onclick='saverecordedSupportDiags();'>&nbsp;<input type="button" class='button' value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>' name ="save" style="display:<%=disp_save_btn%>" onclick='saverecodedSupportDiags();'>&nbsp;<input type="button" class='button'  value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name ="close" onclick='window.close();'></td></tr>
				</table>
				<input type='hidden' name="insert_unlinked_diag" id="insert_unlinked_diag" value="">
				<input type='hidden' name="delete_linked_diag" id="delete_linked_diag" value="">
				<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type='hidden' name="term_set" id="term_set" value="<%=term_set%>">
				<input type='hidden' name="occur_srl_no" id="occur_srl_no" value="<%=occur_srl_no%>">
				<input type='hidden' name="stage_no_disp" id="stage_no_disp" value="<%=stage_no_disp%>">
				<input type='hidden' name="support_seq_no" id="support_seq_no" value="<%=support_seq_no%>">
				<input type='hidden' name="term_code" id="term_code" value="<%=term_code%>">
				<input type='hidden' name="trx_no" id="trx_no" value="<%=trx_no%>">
				<input type='hidden' name="Group_seq_no" id="Group_seq_no" value="<%=Group_seq_no%>">
				<input type='hidden' name="group_YN" id="group_YN" value="<%=group_YN%>">
				<input type='hidden' name="hdr_modified_dt" id="hdr_modified_dt" value="<%=hdr_modified_dt%>">
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

