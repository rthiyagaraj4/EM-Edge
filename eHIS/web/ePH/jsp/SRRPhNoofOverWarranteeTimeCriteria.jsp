<!DOCTYPE html>
	 <%-- saved on 16/2/2010 --%>
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
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
			(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhNoofOverWarranteeTime.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String bean_id1			= "SRRPHRepDispStatisByDispBean";
		String bean_name1		= "ePH.SRRPHRepDispStatisByDispBean";

		ArrayList dispLocnList=new ArrayList();
		SRRPHRepDispStatisByDispBean bean1 = (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id1, bean_name1,request) ;
		bean1.setLanguageId(locale);
		dispLocnList = bean1.getDispLocnList(p_facility_id);
		
		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

		String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown=""> 
	<form name="FormNoOfWarranteeTimeCriteria" id="FormNoOfWarranteeTimeCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.Month/Year.label" bundle="${common_labels}"/></td>	
			<td  align="left">
				<input type='text' name='p_month' id='p_month' size='2' maxlength='2' value='' onBlur='checkMonth(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()' /> / 
				<input type='text' name='p_year' id='p_year' size='4' maxlength='4' value='' onBlur='checkYear(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()'  />
				&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td>
				</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"> <fmt:message key="ePH.WarranteeTimeHH:MM.label" bundle="${ph_labels}"/> </td>	
			<td  align="left">
				<input type='text' name='p_wr_time' id='p_wr_time' size='15' maxlength='5' value='' onBlur='ChkSplChars_time(this);' onkeypress='return allowPositiveNumber();' /> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td>
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<TR >
		<TD CLASS="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
				<TD><select name='p_disp_locn' id='p_disp_locn'style="width:150px">
						<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
							for(int i=0; i<dispLocnList.size();i+=2){
%>
								<option value = <%= dispLocnList.get(i)%>><%= dispLocnList.get(i+1)%></option>
<%
							}
%>
					</select>&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
				</TD>
		<TD colspan="4"></TD>
</TR>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td>
				<SELECT name="p_locn_type" id="p_locn_type" style="width:150px" onChange ='clearLocation(this);'>
					<option value ="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option>
					<option value ="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					<option value="L"><fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/>
					
				</select>
			</td>
			</tr>
			<tr><td class='label' colspan='4' height='6'></td></tr>
			
			<tr>
			<td class="label"><fmt:message key="Common.Location.label"  bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				</td>
				<td>
				<input type="text" name="locn_text_from" id="locn_text_from" size="20" value=""  onblur="clearHiddenvalues(locn_text_from,p_frm_locn_code)"><INPUT TYPE="button" name="locn_text_from_btn" id="locn_text_from_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text_from,p_frm_locn_code);" >
				<input type="hidden" name="p_frm_locn_code" id="p_frm_locn_code" value ="" /> 
			</td>
			<td class="label"><fmt:message key="Common.Location.label"   bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
				<td>
				<input type="text" name="locn_text_to" id="locn_text_to" size="20" value="" onblur="clearHiddenvalues(locn_text_to,p_to_locn_code)"><INPUT TYPE="button" name="locn_text_to_btn" id="locn_text_to_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text_to,p_to_locn_code);" >
				<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" value ="" /> 
			</td>
		</tr>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td class="label"><fmt:message key="Common.PhysicalLocation.label"  bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td>
				<input type="text" name="phy_locn_text_from" id="phy_locn_text_from" size="20" value="" onblur="clearHiddenvalues(phy_locn_text_from,p_frm_building)"><INPUT TYPE="button" name="phy_locn_text_from_btn" id="phy_locn_text_from_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(phy_locn_text_from,p_frm_building);" >
				<input type="hidden" name="p_frm_building" id="p_frm_building" value ="" /> 
			</td>
			<td class="label"><fmt:message key="Common.PhysicalLocation.label"   bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>
			<td>
				
				<input type="text" name="phy_locn_text_to" id="phy_locn_text_to" size="20" value=""onblur="clearHiddenvalues(phy_locn_text_to,p_to_building)" ><INPUT TYPE="button" name="phy_locn_text_to_btn" id="phy_locn_text_to_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(phy_locn_text_to,p_to_building);" >
				<input type="hidden" name="p_to_building" id="p_to_building" value ="" /> 
			</td>
		</tr>
		
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id1 %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name1 %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">	
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="PHNOWRFL">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_name" id="p_report_name" value="">
	<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">

	
	</form>
	<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">
	
	</body>
	<%putObjectInBean(bean_id1,bean1,request);%>
	</html>

