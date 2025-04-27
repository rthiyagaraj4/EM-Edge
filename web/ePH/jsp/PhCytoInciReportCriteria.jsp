<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.CytoInciReportingBean, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>


<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%String mode=request.getParameter("mode");
if(mode==null) mode="";
if(!mode.equals("")){%>
	<script language="JavaScript" src="../../ePH/js/CytoInciReporting.js"></script>
<%}%>
<html>

<head>
<title></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

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
	<script language="Javascript" src="../../ePH/js/CytoInciReporting.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCytoInciReport.js"></script>   
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%  
	String dis="";
	
	String dateString 	= "";


	String bean_id			= "CytoInciReportingBean" ;
	String bean_name		= "ePH.CytoInciReportingBean";
	
	CytoInciReportingBean bean = (CytoInciReportingBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	
	dateString		=com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	
	String logged_fcy = bean.getLoggedInFacility();

%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<form name="formPhCytoInciReportCriteria" id="formPhCytoInciReportCriteria" TARGET="messageFrame">
 <table cellpadding="0" cellspacing="0"  border="0" width="100%" align="center">
	<tr>
	<th colspan="6" width="100%"> &nbsp; &nbsp <fmt:message key="ePH.CytotoxicIncidentReporting.label" bundle="${ph_labels}"/> </th>
	</tr>

	<tr>
  
		 <td class="label" width="18%" nowrap><fmt:message key="ePH.ReportingDateFrom.label" bundle="${ph_labels}"/></td>
		 <td class="label" width="30%">&nbsp;<input type='text'  name='cyto_reported_fromdate' id='cyto_reported_fromdate' size='8' onBlur="checkDateRange(this,'formPhCytoInciReportCriteria')" value="<%=dateString%>" maxlength="10"  >&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="cytoreportfromdate" onclick="return showCalendar('cyto_reported_fromdate');" onBlur="callFocus(cyto_reported_fromdate)">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif' ></img>&nbsp;&nbsp;&nbsp;&nbsp;
		 <label class='label' width="18%" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type='text'  name='cyto_reported_todate' id='cyto_reported_todate' size='8' value="<%=dateString%>" maxlength="10"  onBlur="checkDateRange(this,'formPhCytoInciReportCriteria')">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="cytoreporttodate" onclick="return showCalendar('cyto_reported_todate');" onBlur="callFocus(cyto_reported_todate)">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif' onblur="callFocus(this)"></img>
		</td>

		 <td class='label' colspan="3">&nbsp;<td>
	</tr>

	<tr>
		 <td class="label" width="18%"><fmt:message key="ePH.ReportingNo.label" bundle="${ph_labels}"/></td>
		 <td class="label" width="25%">&nbsp;<input type='text'  name='cyto_no' id='cyto_no' size=20  value="" maxlength="20"  >
		 </td>
		 <td class='label' colspan ="1">&nbsp;<td>
		 <td class="label" width="25%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
	    <td width="30%"><input type="text" name="drug_name" id="drug_name" maxlength="40" size="40"	value="">&nbsp;<input type="button" class="button" value="?" name="drug_desc" id="drug_desc"
	         onClick="callDrugSearch(document.formPhCytoInciReportCriteria.drug_name)">
		<input type="hidden" name="drug_code" id="drug_code" value=""></td>
	</tr>
	<tr>
		<TD width="18%" class='label'><font id='pn'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></font>
		<TD width="30%">&nbsp;<select name="locn_type" id="locn_type"<%=dis%> onchange='LocationQueryDisabled(locn_type)'>
			<option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			<option value="N" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>		</option>
			<OPTION value="P" ><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></OPTION>
		</select>&nbsp;&nbsp;&nbsp;
		<input type="text" disabled name="location1" id="location1" maxlength="25" size="25"  readonly ><input type="button" disabled class="button" value="?" name="location_desc1" id="location_desc1" onClick="lookUpLocationQuery(locn_type)">
		 <INPUT TYPE="hidden" name="locations" id="locations" VALUE="">
	
		<td class='label'>&nbsp;<td>
	 <td class="label" width="18%"><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/></td>
	 <td class="label" width="30%">
	   <input type=text name="ReportedBy" id="ReportedBy" value="" onBlur="checkUser2(this.value)" size=15><input valign="top" type=button name="rprtby_search" id="rprtby_search" class="button" value="?" onClick="searchUserNames2(ReportedBy)"></input>
	 </td>
	</tr>
	<tr>
		<td class="button" colspan="5"></td>
		<td class="button"><input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()"></td>
	 </tr>
 </table>


	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="sys_dt" id="sys_dt" VALUE="<%=dateString%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%=logged_fcy%>"> <!-- newly added for leap year calculation on 24/02/2012-->
	<input type="hidden" name="user_id_sql" id="user_id_sql" value="<%=PhRepository.getPhKeyValue("SQL_PH_PIN_AUTH_RIGHTS_SELECT1")%>"> 
	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
<script>
if(document.forms[0].mode.value!="2")
{
}
</script>
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

