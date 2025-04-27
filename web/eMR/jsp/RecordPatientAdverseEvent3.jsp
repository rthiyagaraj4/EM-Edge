<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
%>

<html>
<head><title><fmt:message key="eMR.ReactionSearch.label" bundle="${mr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/messages.js"></script>
 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String allergen=request.getParameter("allergen")==null?"":request.getParameter("allergen");
	String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String adv_event_ind=request.getParameter("adv_event_ind")==null?"":request.getParameter("adv_event_ind");
	String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
	String oth_reaction=request.getParameter("oth_reaction")==null?"":request.getParameter("oth_reaction");
	String event_done=request.getParameter("event_done")==null?"":request.getParameter("event_done");
	String reaction_date=request.getParameter("reaction_date")==null?"":request.getParameter("reaction_date");
	String reactCodes3=request.getParameter("reactCodes3")==null?"":request.getParameter("reactCodes3");
	String onblurRec=request.getParameter("onblurRec")==null?"N":request.getParameter("onblurRec");
	 /*Avoid the Duplicate Reaction code added by Senthil on 12-08-2011*/
	String reactcode=request.getParameter("reactcode")==null?"":request.getParameter("reactcode");	
	String oldreactionvalue_count=request.getParameter("oldreactionvalue_count")==null?"":request.getParameter("oldreactionvalue_count");
	
%>
		<iframe scrolling="no" name='criteria_page' id='criteria_page' src='../../eMR/jsp/RecordPatientAdverseEvent12.jsp?allergen=<%=allergen%>&react_val=<%=react_val%>&mode=<%=mode%>&flag=<%=flag%>&search_text=<%=search_text%>&patient_id=<%=patient_id%>&adv_event_ind=<%=adv_event_ind%>&adv_event_type=<%=adv_event_type%>&event_done=<%=event_done%>&checkedRec=<%=reactCodes3%>&reactcode=<%=reactcode%>&oldreactionvalue_count=<%=oldreactionvalue_count%>' noresize frameborder=0 style='height:10vh;width:100vw'></iframe>
		<iframe name='detailpage' id='detailpage' src='../../eMR/jsp/RecordPatientAdverseEvent10.jsp?allergen=<%=allergen%>&react_val=<%=react_val%>&mode=<%=mode%>&flag=<%=flag%>&search_text=<%=search_text%>&patient_id=<%=patient_id%>&adv_event_ind=<%=adv_event_ind%>&adv_event_type=<%=adv_event_type%>&event_done=<%=event_done%>&checkedRec=<%=reactCodes3%>&onblurRec=<%=onblurRec%>' frameborder='0' style="height:83vh; width:100vw; overflow-x:hidden;overflow-y: visible;" noresize></iframe>
		<iframe scrolling="no" name='viewdetailpage' id='viewdetailpage' src='../../eMR/jsp/RecordPatientAdverseEvent11.jsp?react_val=<%=react_val%>&oth_reaction=<%=oth_reaction%>&event_done=<%=event_done%>&reaction_date=<%=reaction_date%>' noresize frameborder=0 style='height:8vh;width:100vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

