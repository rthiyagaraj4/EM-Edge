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
	<script LANGUAGE="javascript" src="../../ePH/js/SRRDispDrugSumm.js"></script>
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
	
	
	ArrayList drugCategoryList = bean1.getDrugCategory();

	String bean2_id			= "SRRPHDrugUsageByPractBean" ;
	String bean2_name		= "ePH.SRRPHDrugUsageByPractBean";
	SRRPHDrugUsageByPractBean bean2 = (SRRPHDrugUsageByPractBean)getBeanObject( bean2_id,bean2_name,request ) ;
	bean2.setLanguageId(locale);
	String bl_interface_yn = bean2.checkforbillinginterface();
	//out.println("bl_interface_yn=="+bl_interface_yn);
	String visibility = "";
	if (bl_interface_yn.equals("Y")){
	 visibility = "visibility:visible";
	}else
		visibility = "visibility:hidden";

	ArrayList classificationList = bean2.getEDLClassficationList();

	String sql_ph_drug_search_select	=	"SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND DISCONTINUED_YN='N' AND LANGUAGE_ID =";
	String sql_ph_generic_search_select	=	"select generic_id code,generic_name description from ph_generic_name_lang_vw where eff_status ='E' and UPPER(generic_id) LIKE UPPER(?) AND UPPER(generic_name) LIKE UPPER(?) and language_id = ";

//	String sql_ph_nursing_unit_select	=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
//	String sql_ph_clinic_select			=	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

%>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="loadReportType();loadPeriodFrom();populateDispLocs(formPhDispDrugSummary.p_disp_locn,'<%=locale%>')"> 

<form name="formPhDispDrugSummary" id="formPhDispDrugSummary" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="ePH.DispensedDrugsSummary.label" bundle="${ph_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_facility_id" id="p_facility_id"  onchange="populateDispLocs(this,'<%=locale%>')" >
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>">
				<%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	  </select>
	</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="report_by" id="report_by"  onChange="loadReportType();loadPeriodFrom();clearValues(this);" style="width:155px">
		   	<option value ="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
		   	<option value ="M" selected><fmt:message key="ePH.ByMonth.label" bundle="${ph_labels}"/></option>
		   	<option value ="Y"><fmt:message key="ePH.ByYear.label" bundle="${ph_labels}"/></option>		   	
    	  </select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" />
        </td>
    </tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>	 
		<td align="right" class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		
		<td COLSPAN="3" align="left" id ='daily' style="display:none">&nbsp;<input type="text" size="10" maxlength="10" name="p_enq_date_from" id="p_enq_date_from" Onblur="CheckDate(this);">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_enq_date_from');"  onblur="document.forms[0].p_enq_date_from.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" size="10" maxlength="10" name="p_enq_date_to" id="p_enq_date_to" Onblur="CheckDate(this);">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_enq_date_to');" onblur="document.forms[0].p_enq_date_to.focus();" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>

		<td COLSPAN="2" align="left" id ="month_year" style="display:inline">&nbsp;<input type='text' name='p_month_from' id='p_month_from' size='2' maxlength='2' value='' onBlur='checkMonth(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()' /> / <input type='text' name='p_year_from' id='p_year_from' size='4' maxlength='4' value='' onBlur='checkYear(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()'  />
		&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='p_month_to' id='p_month_to' size='2' maxlength='2' value='' onBlur='checkMonth(this)' onkeypress='return allowPositiveNumber()' /> / <input type='text' name='p_year_to' id='p_year_to' size='4' maxlength='4' value='' onBlur='checkYear(this)' onkeypress='return allowPositiveNumber()' />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">    

		</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	
	<tr><td class='label'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
   <td>&nbsp;<SELECT name="p_disp_locn" id="p_disp_locn" style="width:150px">
    </select></td>
  </tr>
  <tr><td class='label' colspan='4' height='4'></td></tr>
  <tr>
					<tr><td class='label'><fmt:message key="Common.locationtype.label" bundle="${ph_labels}"/></td>
					<td>&nbsp;<SELECT name="p_locn_type" id="p_locn_type" onChange ='clearLocation();'>						
						  <option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
						  <option VALUE="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						   <option VALUE="N"  ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						</select>
                    </td>					
					<td class="label">
						 <fmt:message key="ePH.Location.label" bundle="${ph_labels}"/> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" name="locn_text" id="locn_text" size="20" value="" > 
						<INPUT TYPE="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text);" >
						<input type="hidden" name="p_locn_code" id="p_locn_code" value ="" /> 
                    </td> 					
					
			</tr>
			<tr><td class='label' colspan='4' height='4'></td></tr>	
			<tr style= "<%=visibility%>">
				<td  class='label'><label><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
				<td >&nbsp<input type=text name="billing_from" id="billing_from"  maxlength="30"  size="30" value="" />
				<INPUT TYPE="button" name="billing_button_from" id="billing_button_from" VALUE="?" CLASS="button"  onClick='selectbilling(billing_from,"from");' >
				<input type ='hidden' name='p_fr_privilegde' id='p_fr_privilegde' value =''/>
				</td>
				<td  class="label" nowrap><label><fmt:message key="Common.to.label" bundle="${common_labels}"/></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=text name="billing_to" id="billing_to"  maxlength="30"  size="30" value="" /><INPUT TYPE="button" name="billing_button_to" id="billing_button_to" VALUE="?" CLASS="button"  onClick='selectbilling(billing_to,"to");' >
				<input type ='hidden' name='p_to_privilegde' id='p_to_privilegde' value =''/>			
				</td>
		  </tr>
		  <tr><td class='label' colspan='4' height='4'></td></tr>
		<tr><td class='label'><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
	   <td>&nbsp;<SELECT name="p_drug_class" id="p_drug_class"  >
	     <option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		 <option value ="G"> <fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
		 <option value ="N"> <fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
		 <option value ="C"> <fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
		</select></td>
	    <td class='label' nowrap><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<SELECT name="p_catg_code" id="p_catg_code" >
	     <option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		 <%for(int i=0; i<drugCategoryList.size();i+=2){%>
		 <option value ="<%=drugCategoryList.get(i).toString()%>"><%=drugCategoryList.get(i+1).toString()%></option>
		<% }
		 %>
		</select></td>
	  </tr>
	  <tr><td class='label' colspan='4' height='4'></td></tr>
	  <tr><td class='label'><fmt:message key="ePH.DRUG/MEDICALSUPPLY.label" bundle="${ph_labels}"/> </td>
	   <td nowrap>&nbsp;<SELECT name="drug_med_supply" id="drug_med_supply"  onChange = "callCriteriaChange();">
	    <option value=""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		 <option value ="Y"> <fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
		 <option value ="N"> <fmt:message key="ePH.MEDICALSUPPLY.label" bundle="${ph_labels}"/></option>
		<option value ="A" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
		<td class='label'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text'   name="generic_name_txt" id="generic_name_txt" value ='' size='30' readonly>&nbsp;<input type="button" class="button" value="?" name="generic_name_btn" id="generic_name_btn" onfocus="searchGenericName();" onclick="searchGenericName();" disabled>
		<input type="hidden" name="p_generic_id" id="p_generic_id" value="">
		</td>
	  </tr> 
	<tr><td class='label' colspan='4' height='4'></td></tr>
	 <tr ><td></td><td></td>
	<td class="label" nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60" readonly ><input type="button" class="button" value="?" name="drug_search_btn" id="drug_search_btn" onfocus="searchDrugName();" onclick="searchDrugName();">
	<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
	</td>	
   </tr>
	 <tr><td class='label' colspan='4' height='4'></td></tr>	
      <tr>
 	 <td align="right"  class="label" ><fmt:message key="Common.NationalItem.label" bundle="${common_labels}"/>&nbsp;</td>
	 <td align='left' >&nbsp;<SELECT name="p_national_item" id="p_national_item"  onchange='changeEDClassficationStatus(this)'>	
	     <option value ="Y"> <fmt:message key="Common.National.label" bundle="${common_labels}"/></option>
		 <option value ="N"> <fmt:message key="Common.NonNational.label" bundle="${common_labels}"/></option>
		<option value ="A" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>
	</td>		
	</tr>	
   <tr><td class='label' colspan='4' height='4'></td></tr>	
   <tr>  <td align="right"  class="label" colspan='4'nowrap><fmt:message key="Common.EDClassification.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <SELECT name="p_edl_codes" id="p_edl_codes"  disabled >	
	    <option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		<%
		  for(int i=0;i<classificationList.size();i+=2){%>
		     <option value ="<%=classificationList.get(i).toString()%>"> <%=classificationList.get(i+1).toString()%></option> 
		 <% }
		%>
		
		</select>
	</td>
	</tr>
	
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
 	 <td align="right"  class="label" ><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>&nbsp;</td>
	 <td align='left' >&nbsp;<SELECT name="p_item_type" id="p_item_type" >	
	     <option value ="O"> <fmt:message key="Common.Original.label" bundle="${common_labels}"/></option>
		 <option value ="G"> <fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
		<option value ="" selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>
	</td></tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
 	 <td align="right"  class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
	 <td align='left' >&nbsp;<SELECT name="p_report_type" id="p_report_type" style="width:152px">
	</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" />
	</td></tr>
	</table>


	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="bean1_id" id="bean1_id" VALUE="<%= bean1_id %>">
	<INPUT TYPE="hidden" name="bean1_name" id="bean1_name" VALUE="<%= bean1_name %>">
	<INPUT TYPE="hidden" name="bean2_id" id="bean2_id" VALUE="<%= bean2_id %>">
	<INPUT TYPE="hidden" name="bean2_name" id="bean2_name" VALUE="<%= bean2_name %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_fm_date" id="p_fm_date" VALUE="">
	<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHDISPDRUGSUMBYM">
	<INPUT TYPE="hidden" name="p_report_by" id="p_report_by" VALUE="">
	<INPUT TYPE="hidden" name="p_drug_yn" id="p_drug_yn" VALUE="">
	<INPUT TYPE="hidden" name="p_fm_month" id="p_fm_month" VALUE="">
	<INPUT TYPE="hidden" name="p_to_month" id="p_to_month" VALUE="">
	<INPUT TYPE="hidden" name="p_fm_year" id="p_fm_year" VALUE="">
	<INPUT TYPE="hidden" name="p_to_year" id="p_to_year" VALUE="">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	<INPUT TYPE="hidden" name="p_disp_loc" id="p_disp_loc" VALUE="">
</form>
	<input type="hidden" name="sql_ph_drug_search_select" id="sql_ph_drug_search_select" value="<%=sql_ph_drug_search_select%>">
	<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">
	<input type="hidden" name="sql_ph_generic_search_select" id="sql_ph_generic_search_select" value="<%=sql_ph_generic_search_select%>">

<% putObjectInBean(bean_id,bean,request); %> 
<% putObjectInBean(bean1_id,bean1,request); %>
<% putObjectInBean(bean2_id,bean2,request); %>
</body>
</html>

