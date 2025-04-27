<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

 request.setCharacterEncoding("UTF-8"); %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	String facility_id = (String)session.getValue("facility_id") ;
	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668				
	String date_diff_flag  = checkForNull(request.getParameter( "date_diff_flag" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668				

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id)|| baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
		status_disabled = "disabled";	
	}
%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
		<script language='javascript' src='../../eOH/js/RecordDiagForTrmt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name="recordDiagLinkCond" id="recordDiagLinkCond">
			<table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'>
				<tr>
					<td class="button" colspan="6" width='20%'><input type="button" class="button" name="accept" id="accept" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="acceptOptions();" <%=status_disabled%>>&nbsp;&nbsp;<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearOptions();" <%=status_disabled%>>&nbsp;&nbsp;<input type="button" class="button" name="accept" id="accept" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();"></td>
				</tr>
			</table>
			<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
			<input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value="<%=other_chart_facility_id%>" >
			<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>" >
			
		</form>
	</body>
</html>

