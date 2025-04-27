<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<%

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	
	String term_set		=	"";
	String term_code	=	"";
	String cal_from		=	"";
	String EncounterId =	"";
	String stg_srl_no	=	"";
	String procedureYN	=	"";
	String accession_num	=	"";
	String contr_mod_id	=	"";
	
	cal_from		=	checkForNull(request.getParameter("cal_from"));   
	term_set		=	checkForNull(request.getParameter("term_set"));   
	term_code	=	checkForNull(request.getParameter("term_code"));
	EncounterId	=	checkForNull(request.getParameter("EncounterId"));
	stg_srl_no	 	=	checkForNull(request.getParameter("stg_srl_no"));
	procedureYN	 =	checkForNull(request.getParameter("procedureYN"));
	accession_num	 =	checkForNull(request.getParameter("accession_num"));
	contr_mod_id	 =	checkForNull(request.getParameter("contr_mod_id"));
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%if(cal_from.equals("Eq_Term_cd")){%>
				<title><fmt:message key="eMR.EquivalentCode.label" bundle="${mr_labels}"/></title>	
		<%}else if(cal_from.equals("Sprt_Diag")){%>
				<title><fmt:message key="eMR.SupportingDiagnosisCode.label" bundle="${mr_labels}"/></title>	
		<%}else if(cal_from.equals("Remarks")){%>
				<title><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></title>	 <!--modified by mujafar for ML-MMOH-CRF-1270 -->
		<%}else if(cal_from.equals("AcessionNum")){%>
				<title><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></title>	
		<%}%>
	</head>
	<iframe name="EquiSpptResultFrame" id="EquiSpptResultFrame"  src="../../eMR/jsp/DPDisplayEquivalentCode.jsp?cal_from=<%=cal_from%>&term_set=<%=term_set%>&term_code=<%=term_code%>&EncounterId=<%=EncounterId%>&stg_srl_no=<%=stg_srl_no%>&procedureYN=<%=procedureYN%>&accession_num=<%=accession_num%>&contr_mod_id=<%=contr_mod_id%>" noresize frameborder="0" scrolling="AUTO" / style="height:66vh;width:100vw"></iframe>
	<iframe name="CloseFrame" id="CloseFrame"  src="../../eMR/jsp/DPEquiSpprtDiagClose.jsp"  noresize frameborder="0" scrolling="AUTO" / style="height:16vh;width:100vw"></iframe>
	<iframe src='../../eCommon/jsp/error.jsp' name='messageFrame' id='messageFrame' noresize frameborder="0" scrolling='NO' style='height:10vh;width:100vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

