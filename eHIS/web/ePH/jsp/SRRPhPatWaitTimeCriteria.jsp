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
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 --><!-- 	<script language="JavaScript" src="../js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/SRRPhPatWaitTime.js"></script> 
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	
	
   
	</head>	
<%
	
	String function_id	=	request.getParameter("function_id");
	String facility_id  =	session.getValue( "facility_id" ).toString();	
	if(function_id ==null) function_id="";

	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id,bean_name , request ) ;
    bean.setLanguageId(locale);

	String sys_date="";	
	sys_date		=bean.getSysdate();
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date 	date_time			= dtSystemFormat.parse(sys_date);
	String dateString 			= dtSystemFormat.format(date_time);
	dateString = com.ehis.util.DateUtils.convertDate(dateString,"DMY","en",locale);
	String bean1_id			= "SRRPHRepDispStatisByDispBean" ;
	String bean1_name		= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean1 = (SRRPHRepDispStatisByDispBean)getBeanObject( bean1_id,bean1_name,request ) ;
	bean1.setLanguageId(locale);	
	ArrayList dispLocationList = bean1.getDispLocnList(facility_id);			
	%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<form name="formPhWaitTimeCriteria" id="formPhWaitTimeCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
<br><br><br>
<table cellpadding="0" cellspacing="0"  border="0" width="50%" align ='center' >

  <tr><td class='label'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
   <td>&nbsp;<SELECT name="disp_locn" id="disp_locn" onChange="" >
    <option value ="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
	<%
	   for (int i=0;i<dispLocationList.size();i+=2){
    %>
	   <option value ="<%=dispLocationList.get(i).toString()%>"><%=dispLocationList.get(i+1).toString()%></option>
	<%}
	%>   
   </select></td>
  </tr>
  <tr><td class='label'  height='4'></td></tr>
   <tr><td  class='label'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
   <td>&nbsp;<SELECT name="p_pat_class" id="p_pat_class" onChange="" >
    <option value ="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
	 <option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
	 <option value ="XT"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	 <option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
	 <option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
   </select></td>
   </tr>
   <tr><td class='label'  height='4'></td></tr>
   <tr>
	 <td align="right"  class="label"  nowrap colspan='1'><fmt:message key="ePH.EnquiryDateFrom.label" bundle="${ph_labels}"/></td>  
	 <td class="label" align="left" width="65%"><input type='text'  name='p_enq_date_from' id='p_enq_date_from' size='10' value="" maxlength="10" Onblur="if(CheckDate(this))if(DateCheck('<%=dateString%>',p_enq_date_from))validate_date(this,'TO_DATE_LESS_FROM');" onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate" onclick="return showCalendar('p_enq_date_from');" onblur="document.forms[0].p_enq_date_from.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='p_enq_date_to' id='p_enq_date_to' size='10' value="" maxlength="10" Onblur="if(CheckDate(this))if(DateCheck('<%=dateString%>',p_enq_date_to))validate_date(this,'TO_DATE_LESS_FROM')"   onKeyPress='return AllowDateFormat()'>&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="phdate1" onclick="return showCalendar('p_enq_date_to');"  onblur="document.forms[0].p_enq_date_to.focus();">&nbsp;<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
  </td>
  </tr>
  <tr><td class='label'  height='4'></td></tr>
  <tr>
	 <td align="right"  class="label" width="35%" nowrap colspan='1'><fmt:message key="ePH.RegisterTime.label" bundle="${ph_labels}"/></td>  
	 <td class="label" align="left" width="65%"><input type='text'  name='register_from' id='register_from' size='10' value="" maxlength="10" onkeypress="return allowPositiveNumber()" onblur="appendzero(this);validtime(this,register_to);ChkSplChars(this);"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='text'  name='register_to' id='register_to' size='10' value="" maxlength="10" onkeypress="return allowPositiveNumber()" onblur="appendzero(this);validtime(this,register_from);ChkSplChars(this);">
  </td>
  </tr>
  <tr><td class='label'  height='4'></td></tr>
   <tr>
 	 <td align="right"  class="label" width="35%" colspan='1'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	 <td align='left'  >&nbsp;<SELECT name="p_report_type" id="p_report_type" onChange="setTOandFromDate(p_enq_date_from)" >
	<OPTION VALUE="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></OPTION>
	<OPTION VALUE="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></OPTION> 
	</select>
	</td></tr>
	<tr><td class='label'  height='4'></td></tr>
	<tr><td align="right"  class="label" width="35%" nowrap ><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/>&nbsp;</td>
	<td align='left' colspan='1'  >&nbsp;<SELECT name="p_report_option" id="p_report_option" >
	<OPTION VALUE="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
	<OPTION VALUE="OD"><fmt:message key="ePH.OnlyDischargeOrder.label" bundle="${ph_labels}"/></OPTION> 
	<OPTION VALUE="ND"><fmt:message key="ePH.NonDischargeOrder.label" bundle="${ph_labels}"/></OPTION> 
	</select>
	</td>
	</tr>	
  
 </table>
 
  
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 

	<input type="hidden" name="bean1_id" id="bean1_id" value="<%=bean1_id%>">
	<input type="hidden" name="bean1_name" id="bean1_name"	value="<%=bean1_name%>"> 	
	
		
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">

	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="sys_dt" id="sys_dt" VALUE="<%=dateString%>">
	<INPUT TYPE="hidden" name="from_dt" id="from_dt" VALUE="">
	<INPUT TYPE="hidden" name="to_dt" id="to_dt" VALUE="">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
    <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
    <INPUT TYPE="hidden" name="p_reg_time_fm" id="p_reg_time_fm" VALUE="">
    <INPUT TYPE="hidden" name="p_reg_time_to" id="p_reg_time_to" VALUE="">
    <INPUT TYPE="hidden" name="p_locn_code" id="p_locn_code" VALUE="">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" value="Y">


   </form>
   	
</body>
<% putObjectInBean(bean_id,bean,request); %>
<% putObjectInBean(bean1_id,bean1,request); %>
</html>

