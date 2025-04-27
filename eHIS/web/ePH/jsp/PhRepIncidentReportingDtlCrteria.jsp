<!DOCTYPE html>
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhRepIncidentReportingDtl.js"></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>	
<%
	String function_id	=	request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String Sysdate="";
	Sysdate		=com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	ArrayList reqCatg	=bean.getRequestCatg();
	ArrayList ptactTypeList	=bean.getPractType();
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="formDrugInfoRepCriteria" id="formDrugInfoRepCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<br><br><br>
			<table cellpadding="0" cellspacing="0"  border="0" width="90%" align="center">
				<tr>
					<th colspan="4" height='12'> <fmt:message key="ePH.DrugInformationEnquiryDetail.label" bundle="${ph_labels}"/> </th>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;&nbsp;</td></tr>
				<tr>
					<td class="label" width="35%" nowrap ><fmt:message key="ePH.EnquiryDate.label" bundle="${ph_labels}"/>&nbsp;&nbsp;  </td>  
					<td class="label" align="left" width="65%">
					<input type='text'  name='p_enq_date' id='p_enq_date' size='8' value="" maxlength="10" Onblur="CheckDateT(this);if(DateCheck(sysdate,p_enq_date))validate_date(this,'TO_DATE_LESS_FROM')">&nbsp;
					<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="adrreportdate" onclick="return showCalendar('p_enq_date');"onblur="document.forms[0].p_enq_date.focus();">&nbsp;
					<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td></tr>
				<tr>
					<td class="label" width="35%" ><fmt:message key="ePH.SourceOfRequest.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class="label" width='65%' >
					<SELECT name="p_src_req" id="p_src_req" >
						<OPTION value="">&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</OPTION>
						<OPTION VALUE="*P"><fmt:message key="ePH.Public.label" bundle="${ph_labels}"/></OPTION>
						<OPTION VALUE="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td>
				</tr>
				<tr> 
					<td class="label" width="35%" ><fmt:message key="ePH.EnquirerDesignation.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td class="label" width='65%' >
					<SELECT name="p_enq_type" id="p_enq_type" >
						<OPTION value="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</OPTION>
<%
						if(ptactTypeList!=null && ptactTypeList.size()>0){
							for(int i=0;i<ptactTypeList.size(); i+=2){
%>
								<OPTION VALUE="<%=(String)ptactTypeList.get(i) %>" ><%= (String)ptactTypeList.get(i+1) %></OPTION>
<%
							}
						}
%>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td>
				</tr>
				<tr>
					<TD  class="label" width="35%" nowrap ><fmt:message key="ePH.PriorityoftheRequest.label" bundle="${ph_labels}"/></td>
					<td class="label"  width='65%' >
					<SELECT name="p_req_priority" id="p_req_priority"  nowrap>
							<OPTION value="">&nbsp;&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;&nbsp;</OPTION> 
							<OPTION value="U" ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="I" ><fmt:message key="ePH.Immediatewithin1to2hours.label" bundle="${ph_labels}"/></OPTION>
							<OPTION value="H" ><fmt:message key="ePH.Within24Hours.label" bundle="${ph_labels}"/></OPTION>
							<OPTION value="W" ><fmt:message key="ePH.Inaweekstime.label" bundle="${ph_labels}"/></OPTION>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td>
				</tr>
				<tr>
					<TD  class="label" width="35%"  ><fmt:message key="ePH.ModeofRequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td  class="label" width='65%' >
					<SELECT name="p_req_mode" id="p_req_mode" >
						<OPTION value="">&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</OPTION>
						<OPTION value="P" ><fmt:message key="Common.InPerson.label" bundle="${common_labels}"/></OPTION>
						<OPTION value="T" ><fmt:message key="Common.telephone.label" bundle="${common_labels}"/></OPTION>
						<OPTION value="E"><fmt:message key="ePH.E-Mail/Letter.label" bundle="${ph_labels}"/></OPTION>
						<OPTION value="F" ><fmt:message key="ePH.Facsimile.label" bundle="${ph_labels}"/> </OPTION>
						<OPTION value="R" ><fmt:message key="Common.referral.label" bundle="${common_labels}"/></OPTION>
						<OPTION value="S" ><fmt:message key="Common.self.label" bundle="${common_labels}"/></OPTION>
						<OPTION value="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" width="35%" ><fmt:message key="ePH.Requestcategory.label" bundle="${ph_labels}"/></td>
					<td class="label" width='65%' >
					<SELECT name="p_req_cat_code" id="p_req_cat_code" >
						<OPTION value="">&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</OPTION>
<%	
						StringTokenizer st=null;
						String sys_def="", req_code="";
						String selOrderFcy = "";
						for (int i=0; i<reqCatg.size(); i += 2) {
							req_code = (String)reqCatg.get(i);
							st=new StringTokenizer(req_code,"**");
							req_code=st.nextToken();
							sys_def=st.nextToken();
							if(sys_def.equals("Y")){
%>
								<OPTION <%= selOrderFcy %> VALUE="<%= req_code %>" ><%= reqCatg.get(i+1) %></OPTION>
<%	
							}
						}	
%>
						<option value='*O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option></select>
					</td>
				</tr>
				<tr>
					<td colspan='4' class='label'>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" width="35%" ><fmt:message key="ePH.RequestNumber.label" bundle="${ph_labels}"/></td>
					<td class="label"><input type='text'  name='p_enqury_no' id='p_enqury_no' size='15'/></td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHDRGINFOENQ">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
			<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

