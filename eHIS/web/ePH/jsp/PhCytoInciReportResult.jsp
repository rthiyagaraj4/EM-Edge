<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
<title></title>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />

	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
</head>

<%


String  classValue   = "";


//String params = request.getQueryString();
String bean_id			= "CytoInciReportingBean" ;
String bean_name		= "ePH.CytoInciReportingBean";
	
CytoInciReportingBean bean = (CytoInciReportingBean)getBeanObject( bean_id, bean_name ,request ) ;
bean.setLanguageId(locale);

String mode=request.getParameter("mode");
if(mode==null) mode="";
if(!mode.equals("")){%>
	<script language="JavaScript" src="../../ePH/js/CytoInciReporting.js"></script>
<%}else{%>
	<script language="JavaScript" src="../../ePH/js/PhCytoInciReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}

		String cyto_no = request.getParameter("cyto_no");
			if(cyto_no == null) cyto_no = "";
		String cyto_reported_fromdate = request.getParameter("cyto_reported_fromdate");
			if(cyto_reported_fromdate == null) cyto_reported_fromdate = "";
		String cyto_reported_todate = request.getParameter("cyto_reported_todate");
			if(cyto_reported_todate == null) cyto_reported_todate = "";
		String ReportedBy = request.getParameter("ReportedBy");
			if(ReportedBy == null) ReportedBy = "";
		String drug_code = request.getParameter("drug_code");
			if(drug_code == null) drug_code = "";
		String locn_type = request.getParameter("locn_type");
			if(locn_type == null) locn_type = "";
		String locations = request.getParameter("locations");
		if (locations == null ) locations = "";
		


%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="formPhReportQueryResult" id="formPhReportQueryResult" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

<table cellpadding="0" cellspacing="0"  border="1" width="100%" align="center">
<tr>
<td class="COLUMNHEADERCENTER"><fmt:message key="ePH.ReportingNo.label" bundle="${ph_labels}"/></td>
<td class="COLUMNHEADERCENTER"><fmt:message key="Common.ReportedDate.label" bundle="${common_labels}"/></td>
<td class="COLUMNHEADERCENTER"><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/></td>
<td class="COLUMNHEADERCENTER"><fmt:message key="ePH.ReportedLocation.label" bundle="${ph_labels}"/></td>
<td class="COLUMNHEADERCENTER"><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/></td>
</tr>

<% 
ArrayList getDetails = bean.getSearchDetails(cyto_reported_fromdate,cyto_reported_todate,drug_code,
	cyto_no,ReportedBy,locn_type,locations);
	
	if(getDetails.size() > 0){
	
		String[] record = null;
		for(int i=0; i<getDetails.size(); i+=1)	{	
			record = (String[])getDetails.get(i);
			
			if(i%2==0)
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
			record[3]=com.ehis.util.DateUtils.convertDate(record[3],"DMY","en",locale);
			%>
			<tr>
				<%if(mode.equals("2")){%>
				<td class="<%=classValue%>" align='' ><a href="#" onCLick="showDetails('<%=record[0]%>');"><%=record[0]%></a></td>
		<%	}else{%>
				<td class="<%=classValue%>" align='' ><a href="#" onCLick="showReport('<%=record[0]%>');"><%=record[0]%></a></td>
					<%}%>
				<td class="<%=classValue%>" align='' ><%=record[3]%></td>
				<td class="<%=classValue%>" align='' ><%=record[4]%></td>
				<td class="<%=classValue%>" align='' ><%=record[5]%></td>

				<!--td class="<%=classValue%>" align='' ><%=record[6]%></td-->

				<td class="<%=classValue%>" align='' ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+record[6]+".label","ph_labels")%>
				</td>
			</tr>
			<%

		}
	
		putObjectInBean(bean_id,bean,request);
		}
	else{%>
		
	<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		parent.f_query_report_result.location.href="../../eCommon/html/blank.html";		
	</script>
 <%}
 %>
</tr>

</table>


<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="p_incident_no" id="p_incident_no" VALUE="">
<input type="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>

</html>

