<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;;
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhMednOrderList.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
    <script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "SRRPHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.SRRPHRepDispStatisByDispBean";
	SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = (ArrayList) bean.getOrderingFacilities(p_user_name, locale);


	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");



//	out.println(dateList);

%>


<BODY onload="document.formSRRPhMednOrderListCriteria.p_facility_code.focus();" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="formSRRPhMednOrderListCriteria" id="formSRRPhMednOrderListCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onChange="populateDispLocs(this.value,p_language_id)">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
<%	
			if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) 
				{
%>
					 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

<% 		
				} 
%> 
	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> 
	</tr>
	
	
	
	<tr>
		<td class="label" width="25%" nowrap><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" >&nbsp;<input type="text" maxlength="16" size="16" name="p_dt_from1" id="p_dt_from1" OnBlur='ValidateTime(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_dt_from1',null,'hh:mm');document.formSRRPhMednOrderListCriteria.p_dt_from1.focus();return false;" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "hidden" name = "p_dt_from" value = "">
		<td class=" label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
		<td><input type="text" maxlength="16" size="16" name="p_dt_to1" id="p_dt_to1" OnBlur='ValidatetoTime(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('p_dt_to1',null,'hh:mm');document.formSRRPhMednOrderListCriteria.p_dt_to1.focus();return false;"  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<input type = "hidden" name = "p_dt_to" value = "">
	</tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" width="30%">&nbsp;<SELECT name="p_disp_loc_code" id="p_disp_loc_code">
		<OPTION VAlUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
		
	   	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>

	</tr>

	<tr>
						<td class="label"  width="25%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
						<td width="30%">&nbsp;<select name="p_locn_type" id="p_locn_type" onChange='clear1(this)'>
								<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</option>
								<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td><input type="text" name="p_locn_name" id="p_locn_name" maxlength="20" size="20"   ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_name)" onClick="locationLookup(p_locn_name)">
						<input type="hidden" name="p_locn_code" id="p_locn_code">
					</td>		
	</tr>

	<tr>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20"  onKeyPress="changeToUpper()" ><input type="button" class="button" value="?" name="pat_search" id="pat_search" onfocus="callPatientSearch(document.formSRRPhMednOrderListCriteria.p_patient_id)" onClick="callPatientSearch(document.formSRRPhMednOrderListCriteria.p_patient_id)"></td>
  		
	</tr>

	<tr>
			<td  class="label" ><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td width="30%" >&nbsp;<select name="p_drug_class" id="p_drug_class">
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
			<td class="label">&nbsp;</td>
	</tr>

	<tr>
		<td class="label"><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<select name="p_drug_med_supply" id="p_drug_med_supply" onChange='ChangeLegend(this)'>
				<option value="Y"> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/> &nbsp;&nbsp;</option>
				<option value="N"><fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</select>
		</td>
			<TD class="label" colspan="1"  id="drug_item_label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></TD>
				<TD colspan="3"><input type="text" name="p_drug_name" id="p_drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_item_code_search" id="drug_item_code_search" onfocus="Drug_ItemLookup(p_drug_name);" onclick="Drug_ItemLookup(p_drug_name);">
				<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
			</TD>	

	</tr>

	
	<tr>
		<td class="label"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td >&nbsp;<select name="p_order_status" id="p_order_status" onchange='qryCreate(this);'>
					<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
					<option value="OS"><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
					<option value="IR"><fmt:message key="ePH.PartialSupply.label" bundle="${ph_labels}"/></option>
					<option value="CD"><fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>

		<td class="label" colspan="1" id='tp1' nowrap ><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td ><select name="p_type_of_order" id="p_type_of_order" disabled >
					
					<option value=" " selected><fmt:message key="Common.all.label" bundle="${common_labels}"/><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></option>
					<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
					<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
					<% ArrayList IVlegends = (ArrayList)bean.getIVLegends();
	                	 if (IVlegends.size() > 0 )
				            for (int i=0; i<IVlegends.size(); i+=2) {
	                %>
			        <OPTION VALUE="<%= IVlegends.get(i) %>"><%= IVlegends.get(i+1) %></OPTION>

	                <% 	} %>  

					<option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
					<option value="TA"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
					<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
					</select>
		
					
		</td>
   </tr>
   <tr>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="p_order_by" id="p_order_by" onchange='showtypeoforder();'>
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
					<option value="O"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>
					<option value="T"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/></option>
					<option value="D"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td align="left" class="label"  id='tp1' nowrap ><fmt:message key="ePH.IncludeDiscontinuedOrder.label" bundle="${ph_labels}"/></td>
		<td><input type="checkbox" name="P_order_dc_chk" id="P_order_dc_chk" value="N" onClick="SetDiscontinueOrder(this,p_order_dc);" >
		<input type="hidden" name="p_order_dc" id="p_order_dc" value="N">
 </tr>
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHMEDORLT">
	<INPUT TYPE="hidden" name="p_orderstatus_qry" id="p_orderstatus_qry" VALUE="">
	<INPUT TYPE="hidden" name="p_type_of_order_val" id="p_type_of_order_val" VALUE="">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="Y">
	
</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
	<INPUT TYPE="hidden" name="drug_search_query" id="drug_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND DRUG_YN='Y' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
	<INPUT TYPE="hidden" name="item_search_query" id="item_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND DRUG_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
	<INPUT TYPE="hidden" name="drug_item_search_query" id="drug_item_search_query" VALUE="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID =">
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

