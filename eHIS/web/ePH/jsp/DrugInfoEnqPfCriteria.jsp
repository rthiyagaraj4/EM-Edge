<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugInfoEnqPf.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	
	
   
	</head>	
<%
	
	String function_id	=	request.getParameter("function_id");
	if(function_id ==null) function_id="";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";

	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id,  bean_name,request ) ;
	bean.setLanguageId(locale);
	String Sysdate="";
	
	Sysdate		=bean.getSysdate();

			
	%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<form name="formDrugInfoEnqPfCriteria" id="formDrugInfoEnqPfCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
<br><br><br>
<table cellpadding="0" cellspacing="0"  border="0" width="50%" align="center">
<tr>
<th align="left" colspan="3" height='12'> <fmt:message key="ePH.DrugInformationReportCriteria.label" bundle="${ph_labels}"/> </th>
</tr>
  <tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
   <tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
<tr>
 <td align="right"  class="label" width="35%" nowrap colspan='1'>&nbsp;<fmt:message key="ePH.EnquiryDateFrom.label" bundle="${ph_labels}"/>&nbsp;&nbsp;  </td>  
 <td class="label" align="left" width="65%"> <input type='text'  name='p_enq_date_from' id='p_enq_date_from' size='8' value="" maxlength="10" Onblur="CheckDate(this);DateCheck(sysdate,p_enq_date_from);validate_date(this,'TO_DATE_LESS_FROM')">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate" onclick="return showCalendar('p_enq_date_from');"onblur="document.forms[0].p_enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='p_enq_date_to' id='p_enq_date_to' size='8' value="" maxlength="10" onblur="CheckDate(this);DateCheck(sysdate,p_enq_date_to);validate_date(this,'TO_DT_GR_EQ_FM_DT');">&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate1" onclick="return showCalendar('p_enq_date_to');"onblur="document.forms[0].p_enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
  </td>
  </tr>

  <tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
 <tr><td colspan='3' class='label'>&nbsp;&nbsp;</td></tr>
 </table>
 
  
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
	
		
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="PHDRUGINFO56A">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
	<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">



   </form>
   	
</body>
<% 
putObjectInBean(bean_id,bean,request);%>

</html>

