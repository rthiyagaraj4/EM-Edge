<!DOCTYPE html>
 <%-- saved on 04/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>

<% 
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhBalMednHand.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<!-- <script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->


		
		
</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

	String bean_id				= "PHRepMednOrdStatBySrcBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
	PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id,bean_name , request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();

	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= dtSystemFormat.format(date_time); 

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");

	String bean1_id			= "SRRPHRepDispStatisByDispBean" ;
	String bean1_name		= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean1 = (SRRPHRepDispStatisByDispBean)getBeanObject( bean1_id,bean1_name,request ) ;
	bean1.setLanguageId(locale);	
	ArrayList dispLocationList = bean1.getDispLocnList(p_facility_id);

	String sql_ph_drug_search_select	=	"SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DISCONTINUED_YN='N' AND LANGUAGE_ID =";

%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhBalMednHand.p_facility_code.focus();populateDispLocs(formPhBalMednHand.p_disp_locn,'<%=locale%>');"> 

<form name="formPhBalMednHand" id="formPhBalMednHand" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="ePH.BalanceMedicationReportCriteria.label" bundle="${ph_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_facility_code" id="p_facility_code"  onchange="populateDispLocs(this,'<%=locale%>')">
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>">
				<%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label" ><fmt:message key="ePH.DispenseDateFrom.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left" >&nbsp;<input type="text" size="10" maxlength="10" name="p_enq_date_from1" id="p_enq_date_from1" Onblur="CheckDate(this);">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_enq_date_from1');"  onblur="document.forms[0].p_enq_date_from1.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;
		<input type="text" size="10" maxlength="10" name="p_enq_date_to1" id="p_enq_date_to1" Onblur="CheckDate(this);">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_enq_date_to1');" onblur="document.forms[0].p_enq_date_to1.focus();" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>

	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr><td class='label'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
   <td>&nbsp;<SELECT name="p_disp_locn" id="p_disp_locn" >  
   </select></td>
  </tr>
  <tr><td class='label' colspan='4' height='4'></td></tr>
  <tr><td class='label'><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td>
   <td>&nbsp;<SELECT name="drug_med_supply" id="drug_med_supply"  onChange = "callCriteriaChange();">  
     <option value ="Y"> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
	 <option value ="N"> <fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
    <option value ="" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select></td>
  </tr>
  <tr><td class='label' colspan='4' height='4'></td></tr>
   <tr >
	<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
	<td colspan="3">&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
	<input type="hidden" name="drug_code" id="drug_code" value="">
	</td>	
   </tr>
   <tr><td class='label' colspan='4' height='4'></td></tr>
   <tr>
 	 <td align="right"  class="label" width="35%" colspan='1'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	 <td align='left'   >&nbsp;<SELECT name="p_report_type" id="p_report_type" >
	 <OPTION VALUE="DT" selected><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></OPTION>
	<OPTION VALUE="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></OPTION> 
	</select>
	</td></tr>
	</table>


	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_frdate" id="p_frdate" VALUE="">
	<INPUT TYPE="hidden" name="p_todate" id="p_todate" VALUE="">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBALMEDNHAND">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_drug_from" id="p_drug_from" VALUE="">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" value="Y">
	<INPUT TYPE="hidden" name="p_enq_date_from" id="p_enq_date_from" value="">
	<INPUT TYPE="hidden" name="p_enq_date_to" id="p_enq_date_to" value="">
</form>
<input type="hidden" name="sql_ph_drug_search_select" id="sql_ph_drug_search_select" value="<%=sql_ph_drug_search_select%>">

<% putObjectInBean(bean_id,bean,request); %> 
<% putObjectInBean(bean1_id,bean1,request); %>
</body>
</html>

