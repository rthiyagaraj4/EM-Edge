<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
	String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");

	String facilityID		= (String) session.getValue( "facility_id" ) ;
	String EncounterId =	"";
	int diag_err_cnt  =	0;
	int proc_err_cnt  =	0;
	int diag_excodes_cnt    =	0;
	int proc_excodes_cnt   =	0;
	int diag_origerr_cnt		=	0;
	int proc_origerr_cnt		=	0;
	String view_from			=	"";
	EncounterId					=	checkForNull(request.getParameter("encounterID"));
	view_from					=	checkForNull(request.getParameter("view_from"));
	diag_err_cnt					=	Integer.parseInt(request.getParameter("diag_err_cnt"));
	proc_err_cnt				=	Integer.parseInt(request.getParameter("proc_err_cnt"));
	diag_excodes_cnt			=	Integer.parseInt(request.getParameter("diag_excodes_cnt"));
	proc_excodes_cnt		=	Integer.parseInt(request.getParameter("proc_excodes_cnt"));
	diag_origerr_cnt			=	Integer.parseInt(request.getParameter("diag_origerr_cnt"));
	proc_origerr_cnt			=	Integer.parseInt(request.getParameter("proc_origerr_cnt"));
	String FrameSettings	="";
	String DiagFrameScroll	 	="NO";
	String ProcFrameScroll	 	="NO";
	/*Based up on the Parameter SetUp frame Setting will Change*/
	if(allow_recode_diag_yn.equals("Y")&& allow_recode_proc_yn.equals("Y")){
		if(view_from.equals("MRK_ERR")){
			if(diag_err_cnt>0 && proc_err_cnt>0){
				FrameSettings	="8%,43%,43%,4%,3%";
				DiagFrameScroll		="AUTO";
				ProcFrameScroll		="AUTO";
			}else if(diag_err_cnt>0){
				FrameSettings	="8%,86%,0%,4%,3%";
				DiagFrameScroll		="AUTO";
			}else if(proc_err_cnt>0){
				FrameSettings	="8%,0%,86%,4%,3%";
				ProcFrameScroll		="AUTO";
			}
		}else if(view_from.equals("EX_CODES")){
				if(diag_excodes_cnt>0 && proc_excodes_cnt>0){
					FrameSettings	="8%,43%,43%,4%,3%";
					DiagFrameScroll		="AUTO";
					ProcFrameScroll		="AUTO";
				}else if(diag_excodes_cnt>0){
					FrameSettings	="8%,86%,0%,4%,3%";
					DiagFrameScroll		="AUTO";
				}else if(proc_excodes_cnt>0){
					FrameSettings	="8%,0%,86%,4%,3%";
					ProcFrameScroll		="AUTO";
				}
			}else if(view_from.equals("ORIG_MRK_ERR")){
				if(diag_origerr_cnt>0 && proc_origerr_cnt>0){
					FrameSettings	="8%,43%,43%,4%,3%";
					DiagFrameScroll		="AUTO";
					ProcFrameScroll		="AUTO";
				}else if(diag_origerr_cnt>0){
					FrameSettings	="8%,86%,0%,4%,3%";
					DiagFrameScroll		="AUTO";
				}else if(proc_origerr_cnt>0){
					FrameSettings	="8%,0%,86%,4%,3%";
					ProcFrameScroll		="AUTO";
				}
			}
	}else if(allow_recode_diag_yn.equals("Y")){
		FrameSettings	="8%,86%,0%,4%,3%";
		DiagFrameScroll		="AUTO";
	}else if(allow_recode_proc_yn.equals("Y")){
		FrameSettings	="8%,0%,86%,4%,3%";
		ProcFrameScroll		="AUTO";
	}

%>
<html>
	<head>
		<%if(view_from.equals("MRK_ERR")){%>
			<title><fmt:message key="eMR.ErrorHistory.label" bundle="${mr_labels}"/></title>
		<%}else if(view_from.equals("EX_CODES")){%>
			<title><fmt:message key="eMR.viewexcludedcodes.label" bundle="${mr_labels}"/></title>	
		<%}else if(view_from.equals("ORIG_MRK_ERR")){%>
			<title><fmt:message key="eMR.errorcodemarkedbypractitioner.label" bundle="${mr_labels}"/></title>	
		<%}%>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<frameset rows="<%=FrameSettings%>">
		<frame name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityID%>&EncounterId=<%=EncounterId%>' noresize  frameborder="0" scrolling='NO'/>
		<frame name="DiagErrorHisFrame" id="DiagErrorHisFrame"  src="../../eMR/jsp/DPDiagerrorhistory.jsp?encounterID=<%=EncounterId%>&view_from=<%=view_from%>" noresize frameborder="0" scrolling="<%=DiagFrameScroll%>" />
		<frame name="ProcErrorHisFrame" id="ProcErrorHisFrame"   src="../../eMR/jsp/DPProcerrorhistory.jsp?encounterID=<%=EncounterId%>&view_from=<%=view_from%>" noresize frameborder="0" scrolling="<%=ProcFrameScroll%>"/>
		<frame name="CloseFrame" id="CloseFrame"  src="../../eMR/jsp/DPEquiSpprtDiagClose.jsp"  noresize frameborder="0" scrolling="AUTO" />
		<frame src='../../eCommon/jsp/error.jsp' name='messageFrame' id='messageFrame' noresize frameborder="0" scrolling='NO'>

	</frameset>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

