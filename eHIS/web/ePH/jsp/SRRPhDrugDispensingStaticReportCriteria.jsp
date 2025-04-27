<!DOCTYPE html>
	 <%-- saved on 16/2/2010 --%>
	<%-- JSP Page specific attributes start --%>
	<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
    //ends
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
			(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugDispensingStaticReport.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String sql_ph_drug_search_select2 =	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
		//String bean_id				= "PHRepMednOrdStatBySrcBean" ;
		//String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
		//PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id,bean_name , request) ;
		//bean.setLanguageId(locale);

		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		String bl_interface_yn = bean.checkforbillinginterface();
		String visibility = "";
		ArrayList facilityList      = bean.getMednFacilityList();
		if (bl_interface_yn.equals("Y")){
		 visibility = "visibility:visible";
		}else
			visibility = "visibility:hidden";
			SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	String blng_grp_id=request.getParameter("blng_grp_id")== null ? "":request.getParameter("blng_grp_id");
	
	//out.println("Sysdate------line--45---------->"+Sysdate);
		String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

		String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
%>

	<BODY onload="document.FormDrugDispensingStasticreportCriteria.p_facility_code.focus();disablebilling();" onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="populateDispLocs()">
	
	<form name="FormDrugDispensingStasticreportCriteria" id="FormDrugDispensingStasticreportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="5">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onchange=''>
		   	<OPTION VALUE="" > <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	
	</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
	</td>
	<td colspan='4'></td>
	</tr>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<!-- <td>&nbsp;</td> -->
		<td>&nbsp;<input type="text" size="10" maxlength=10 name="dt_from1" id="dt_from1" Onblur="if(CheckDate(this))if(DateCheck(sysdate,dt_from1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td><td class="label" colspan='1'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<input type="text" size="10" name="dt_to1" id="dt_to1" Onblur="if(CheckDate(this))if(DateCheck(sysdate,dt_to1))validate_date(this,'TO_DATE_LESS_FROM')">&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
	</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td class="label" nowrap><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
		&nbsp;<td>&nbsp;<select name="p_report_by" id="p_report_by" onchange='disablebilling();changeTop();' >
					<option value="BG" nowrap><fmt:message key="ePH.BillingGroup.label" bundle="${common_labels}"/></option>
					<option value="AC"><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/></option>
					<option value=""><fmt:message key="ePH.BillingGroupVsATCClassification.label" bundle="${ph_labels}"/></option>
					</select>
		</td>
 	<td class="label" nowrap><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" onchange='changeTop();'>
					<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td></td>
	</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
				<td  width="15%" class='label' colspan='1'><label><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
				<td width="30%">&nbsp<input type=text name="billing_from" id="billing_from" readonly maxlength="30"  size="30" value="">&nbsp;<input class='button' type=button name="billing_button" id="billing_button" value="?"   onClick='selectbilling(billing_from,"from");'>
				 <input type="hidden" name="p_fr_privilegde" id="p_fr_privilegde" value="<%=blng_grp_id%>">   
				</td>
				<td width="15%" class="label" nowrap ><label><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name="billing_to" id="billing_to" readonly maxlength="30" size="30" value="">&nbsp;<input class='button' type=button name="billing_to_button" id="billing_to_button" value="?" onClick='selectbilling(billing_to,"to");'>
				<input type="hidden" name='p_to_privilegde' id='p_to_privilegde' value="<%=blng_grp_id%>">
				</td>
				<td colspan='2'></td> 
			  </tr>			

		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td class="label"><fmt:message key="Common.NationalItem.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="p_national_item" id="p_national_item" onChange=''>
		<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="Y"><fmt:message key="Common.National.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="N"><fmt:message key="Common.NonNational.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td width="15%" class="label" nowrap><fmt:message key="ePH.ATCClass(Level 1).label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="p_atc_from" id="p_atc_from" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="p_atc_from_search" id="p_atc_from_search" onClick='ATCClassificationLookup(p_atc_from,"from")'></td>
		<input type="hidden" name="p_atc_from_id" id="p_atc_from_id" value=""> 
		<td width="5%" class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="p_atc_to" id="p_atc_to" readonly maxlength="30" size="30" value="">&nbsp;<input type="button" class="button" value="?" name="p_atc_to_search" id="p_atc_to_search"  onClick='ATCClassificationLookup(p_atc_to,"to")'></td>
		<input type="hidden" name="p_atc_to_id" id="p_atc_to_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='6'></td></tr>
	<tr >
		<td align='right' class="label" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="30" size="30" readonly >&nbsp;<input type="button" class="button" value="?" name="p_drug_name_search" id="p_drug_name_search" onfocus="searchDrugName();" onclick="searchDrugName();">
		<input type="hidden" name="p_drug_code" id="p_drug_code" value=""></td>
		<td class="label" nowrap><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;<select name="p_item_type" id="p_item_type" onChange=''>
		<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="O"><fmt:message key="Common.Original.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></OPTION>
		</select>
	</td>
	</tr>
	<tr><td class='label' colspan='4' height='6'></td></tr>
	<tr>
	<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td>&nbsp;<SELECT name="p_locn_type" id="p_locn_type" style="width:150px" onChange ='clearLocation();'>
	<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
	<option value ="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
    <option value ="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	<input type="text" name="locn_text" id="locn_text" size="20" value="" >&nbsp;<INPUT TYPE="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text);" ><input type="hidden" name="p_locn_code" id="p_locn_code" value ="" /></td>
	</tr>
	<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
		<td align='right' class="label" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_speciality_name" id="p_speciality_name" maxlength="30" size="30" readonly >&nbsp;<input type="button" class="button" value="?" name="p_speciality_search" id="p_speciality_search" onfocus="selectspeciality();" onclick="selectspeciality();">
		<input type="hidden" name="p_speciality_code" id="p_speciality_code" value=""></td>
		<td align='right' class="label" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_pract_name" id="p_pract_name" maxlength="30" size="30" readonly >&nbsp;<input type="button" class="button" value="?" name="p_pract_search" id="p_pract_search" onfocus="searchPractitioner();" onclick="searchPractitioner();">
		<input type="hidden" name="pract_id" id="pract_id" value=""></td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.Top.label" bundle="${ph_labels}"/></td>	
			<td  align="left">&nbsp;<input type='text' name='p_top' id='p_top' size='3' maxlength='2' value='' onKeyPress='allowPositiveNumber();' onBlur = 'ChkSplChars(this);' disabled /> &nbsp; <label class="label"><fmt:message key="Common.Items.label" bundle="${common_labels}"/></label>				
			</td>
		</tr>
		
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
	<input type="hidden" name="p_disp_date_from" id="p_disp_date_from" value="">
	<input type="hidden" name="p_disp_date_to" id="p_disp_date_to" value="">
	<input type="hidden" name="p_privilege_fm" id="p_privilege_fm" value="">
	<input type="hidden" name="p_privilege_to" id="p_privilege_to" value="">
	<input type="hidden" name="p_fm_atc_class_lev" id="p_fm_atc_class_lev" value="">
	<input type="hidden" name="p_to_atc_class_lev" id="p_to_atc_class_lev" value="">
	<input type="hidden" name="p_primary_speciality_code" id="p_primary_speciality_code" value="">
	<input type="hidden" name="p_pract_id" id="p_pract_id" value="">
	</form>
	<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">
	<input type="hidden" name="sql_ph_drug_search_select2" id="sql_ph_drug_search_select2" value="<%=sql_ph_drug_search_select2%>">
	<% putObjectInBean(bean_id,bean,request); %>
	</body>
	</html>

