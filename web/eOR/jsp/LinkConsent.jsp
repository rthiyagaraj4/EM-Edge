<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="eOR.LinkConsent.label" bundle="${or_labels}"/></title>

<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="javascript" src="../../eCommon/js/messages.js"></script>
		 <script language="JavaScript" src="../../eOR/js/ConsentOrder.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		 <script language="JavaScript" src="../js/OrCommonFunction.js"></script>
		 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
	.accordionTabContentBox {
	BORDER-RIGHT: 0px ; 
	BORDER-TOP: 0px ; 
	FONT-SIZE: 11px; 
	BORDER-LEFT:  0px; 
	BORDER-BOTTOM:  0px ;
}
	</style>
	</head>

	
	<% 
		String patient_id	  = request.getParameter("patient_id");
		String encounter_id	  = request.getParameter("encounter_id");
		String facility_id	  = request.getParameter("facility_id");
		String consent_form_id	  = request.getParameter("consent_form_id");
		String current_link	  = request.getParameter("current_link")==null?"":request.getParameter("current_link");
		String link_ref_det	  = request.getParameter("link_ref_det")==null?"":request.getParameter("link_ref_det");
		String link_curr_dflt = request.getParameter("link_current");
		link_curr_dflt		  = (link_curr_dflt==null)?"YES":link_curr_dflt;

		String link_ref_no = request.getParameter("link_ref_no");
		String link_ref = request.getParameter("link_ref");
		if(link_ref.equals("C"))
			link_curr_dflt = "YES";
		else if(link_ref.equals("E"))
			link_curr_dflt = "NO";
		String style_visibility = !link_curr_dflt.equals("YES")?"visible":"hidden";

		String bean_id		 = "Or_ConsentOrders" ;
		String bean_name	 = "eOR.ConsentOrders";
		ConsentOrders bean	 = (ConsentOrders)getBeanObject( bean_id,  bean_name, request) ;
		bean.setLanguageId(localeName);
		String curr_week_date	= "";
		String last_week_date	= "";
		Properties properties	= (Properties) session.getValue( "jdbc" );

		ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
		for(int i=0;i<sysdate.size();i++){
			last_week_date =  (String)sysdate.get(0);
			curr_week_date =  (String)sysdate.get(1);
		}
		last_week_date = com.ehis.util.DateUtils.convertDate(last_week_date,"DMYHM","en",localeName);
		curr_week_date = com.ehis.util.DateUtils.convertDate(curr_week_date,"DMYHM","en",localeName);

		String existingConsentURL = "../../eCommon/html/blank.html";
		
		if(!current_link.equals("")){
			existingConsentURL = "../../eOR/jsp/LinkExistingConsent.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&consent_form_id="+consent_form_id+"&period_from=&period_to=&link_ref_no="+link_ref_no+"&link_ref_det="+link_ref_det+"&current_link="+current_link+"&curr_date="+last_week_date;

		}
			
	%>
	<body onload="<%= (link_ref.equals("E")||current_link.equals(""))?"linkConsent('Existing')":"" %>">
	<form name="LinkConsentForm" id="LinkConsentForm">
		<table width='100%'cellpadding=0 cellspacing=0 border='0'>
			<tr>
				<!-- <td class="label" align="right" width="40%"><B>Consents &nbsp;&nbsp;&nbsp;Current</B>&nbsp;</td>
				<td class="label" width="10%">&nbsp;<input type="radio" name="link_ref" id="link_ref" value='C' <%=link_curr_dflt.equals("YES")?"checked":(current_link.equals("")?"disabled":"")%> onClick="linkConsent('Curent')"></td>
				<td class="label" align="right" width="10%"><B>Existing</B>&nbsp;</td>
				<td class="label" width="40%" VALIGN='top'>&nbsp;<input type="radio" name="link_ref" id="link_ref" value='E' <%=!link_curr_dflt.equals("YES")?"checked":""%> onClick="linkConsent('Existing')"></td> -->
				<!-- <td class="label" align="right" width="40%" VALIGN='TOP'><B>Consents</b>&nbsp;<input type="radio" name="link_ref" id="link_ref" value='C' <%=link_curr_dflt.equals("YES")?"checked":(current_link.equals("")?"disabled":"")%> onClick="linkConsent('Curent')"></td>
				
				<td class="label"  width="10%">&nbsp;<B>Current</B>&nbsp;</td>
				
				<td class="label" align="right" width="10%">&nbsp;<input type="radio" name="link_ref" id="link_ref" value='E' <%=!link_curr_dflt.equals("YES")?"checked":""%> onClick="linkConsent('Existing')"></td>
				<td class="label" width="40%" >&nbsp;<B>Existing</B></td> -->

				<td class="label" align="center" width="40%" COLSPAN='4' VALIGN='TOP'><B><fmt:message key="eOR.Consents.label" bundle="${or_labels}"/></b>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="link_ref" id="link_ref" value='C' <%=link_curr_dflt.equals("YES")?"checked":(current_link.equals("")?"disabled":"")%> onClick="linkConsent('Curent')">&nbsp;<B><fmt:message key="Common.current.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;<input type="radio" name="link_ref" id="link_ref" value='E' <%=!link_curr_dflt.equals("YES")?"checked":""%> onClick="linkConsent('Existing')">&nbsp;<B><fmt:message key="eOR.Existing.label" bundle="${or_labels}"/></B></td>
			</tr>
			
			<tr id='encounter_link' Style="visibility:<%=style_visibility%>">
				<td class="label" align="left" width="" colspan='4' ><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>&nbsp;<!-- <INPUT TYPE="radio" name="encounter" id="encounter" onclick=''>All
				<INPUT TYPE="radio" name="encounter" id="encounter" onclick='' checked> Current-->
				<SELECT name="encounter" id="encounter">
					<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='C' selected><fmt:message key="Common.current.label" bundle="${common_labels}"/></option>
				</SELECT> &nbsp;&nbsp;&nbsp;&nbsp;
				<!-- </td>
				<td class="label" align="center" width="" colspan='3'> --><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/>&nbsp;<input type="text" name="period_from" id="period_from" value="<%=curr_week_date%>"  size="10" maxlength="10" onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'>&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_from',null,null,'modal');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>&nbsp;&nbsp;&nbsp;&nbsp;<!-- </td>
				<td class=label align='right'> --><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type=text name='period_to' id='period_to' value="<%=last_week_date%>" size="10" maxlength="10" onBlur="checkDateRange(this,'LinkConsentForm')" onKeyPress='return OrAllowDateFormat()'>&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('period_to',null,null,'modal');" style='cursor:pointer'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
	
				<!-- </td>
				<td class="label" width="" align='right' > -->&nbsp;<div style='' align='right'><input class="button" type="button" name="search" id="search" value='Search' onClick="callExistingConsent()">&nbsp;</div></td>
			</tr>
			<tr id='encounter_header' Style="visibility:<%=!current_link.equals("")?"visible":"hidden"%>">
				<td class="bodycolorfilled" align="left" width="" colspan='4' >
					<table width='97%' border='1' cellpadding=0 cellspacing=0 >
					<tr style='border:0px'>
						<th width="10%" colspan=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
						<th width="40%" colspan=''><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
						<th width="30%" colspan=''><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>
						<th width="20%" colspan=''><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></th> 
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="label" align="center" width="" colspan='4' >
				<iframe class='' id="existingConsentList" FRAMEBORDER=NO src='<%=(link_ref.equals("C")||!current_link.equals(""))?existingConsentURL:""%>' width="100%" height="113vh" onKeyPress='' style='overflow: auto'>
				</iframe>

				</td>
			</tr>
			<tr>
				<td class="label" align="right" width="" colspan='4'><input class="button" type="button" name="ok" id="ok" value='Ok' onClick="closeWindow()">&nbsp;<input class="button" type="button" name="rest" id="rest" value='Reset' onClick="callreset();">&nbsp;<input class="button" type="button" name="clear" id="clear" value='Clear' onClick="clearValues()">&nbsp;&nbsp;&nbsp;&nbsp;</td>
					
			</tr>

		</table>
		<input type=hidden name='total_recs' id='total_recs' value='<%//=i%>'>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="consent_form_id" id="consent_form_id" value="<%=consent_form_id%>">
		<input type="hidden" name="link_ref_no" id="link_ref_no" value="<%=link_ref_no%>">
		<input type="hidden" name="link_ref_det" id="link_ref_det" value="<%=link_ref_det%>">
		
		<input type="hidden" name="qry_string" id="qry_string" value="<%=existingConsentURL%>">
		
		
	</form>
	</body>
</html>

