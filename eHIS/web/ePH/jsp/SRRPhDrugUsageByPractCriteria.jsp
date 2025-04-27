<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


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
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugUsageByPract.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!--	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
</head>

<%
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_MODIFIED_SELECT");

	String sql_ph_reports_atc1_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC1_LOOKUP");
	String sql_ph_reports_atc2_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC2_LOOKUP");
	String sql_ph_reports_atc3_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC3_LOOKUP");
	String sql_ph_reports_atc4_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC4_LOOKUP");
	String sql_ph_reports_atc5_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC5_LOOKUP");

	String bean_id				= "SRRPHDrugUsageByPractBean" ;
	String bean_name			= "ePH.SRRPHDrugUsageByPractBean";
	SRRPHDrugUsageByPractBean bean	= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList      = bean.getMednFacilityList();
	//ArrayList dateList          = bean.getMednDateList();
	ArrayList jobtitle          = bean.getTitle();

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	
	//Code for billing lookup----starts 28/12/09--****
	String	billingYN       =   "";
	String	visible         =   "";
	billingYN					  =  bean.checkforbillinginterface();//Check from DB
	bean.setBillingYN(billingYN);//Set to bean
    if(billingYN.equals("Y")){
		visible = "visibility:visible";}
	else{
		 visible = "visibility:hidden";}
		 String blng_grp_id=request.getParameter("blng_grp_id")== null ? "":request.getParameter("blng_grp_id");
		 /*Creating New Array List for EDL List box values*/
		// ArrayList Item_Classlist=new ArrayList();
		// ArrayList EDL_Classification_List=new ArrayList();
		 //Item_Classlist=bean.getItemclassList();
		 ArrayList EDL_Classification_List=bean.getEDLClassficationList();
		// HashMap itemanalysislistvalues=new HashMap();
		 HashMap EDLlistvalues=new HashMap();
		 String code="";	
		String desc="";

%>


<!-- <BODY onload="document.formPhDrugUsageByPractCriteria.p_facility_code.focus();"> -->
<BODY onload="document.formPhDrugUsageByPractCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> -->

<form name="formPhDrugUsageByPractCriteria" id="formPhDrugUsageByPractCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="5">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onchange='callLocation(this)'>
		   	<OPTION VALUE="" > <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	
	</select>
	</td>
	<td colspan='4'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<!-- <td>&nbsp;</td> -->
		<td>&nbsp;<input type="text" size="10" maxlength=10 name="dt_from1" id="dt_from1" Onblur="CheckDate(this);if(DateCheck(sysdate,dt_from1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>&nbsp;&nbsp;<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To</td>
		<td>&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" Onblur="CheckDate(this);if(DateCheck(sysdate,dt_to1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="p_job_title" id="p_job_title" DISABLED onchange='clear1(this)'>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<jobtitle.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= jobtitle.get(i) %>"><%= jobtitle.get(i+1) %></OPTION>

	<% 	} %>
	</select>
		</td>
		<td colspan='4'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="pract_name" id="pract_name" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="pract_search" id="pract_search" disabled onClick="parent.searchPractitionerName(formPhDrugUsageByPractCriteria.pract_name, 1)"></td>
		<input type="hidden" name="pract_id" id="pract_id" value=""> 
		<td width="5%" class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tpract_name" id="tpract_name" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tpract_search" id="tpract_search" disabled onClick="parent.searchPractitionerName(formPhDrugUsageByPractCriteria.tpract_name, 2)"></td>
		<input type="hidden" name="tpract_id" id="tpract_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<!-- Adding new legend billing group 28/12/09 -->
	<tr>
				<td  width="15%" class='label' colspan='1'><label style="<%=visible%>"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
				<td width="30%">&nbsp<input type=text name="billing_from" id="billing_from" readonly maxlength="30" style="<%=visible%>" size="30" value=""><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>" onClick='selectbilling(billing_from,"from");'>
				 <input type="hidden" name="p_fr_privilegde" id="p_fr_privilegde" value="<%=blng_grp_id%>">   
				</td>
				<td width="15%" class="label" ><label style="<%=visible%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
				<td width="30%">&nbsp<input type=text name="billing_to" id="billing_to" readonly maxlength="30" style="<%=visible%>" size="30" value=""><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>" onClick='selectbilling(billing_to,"to");'>
				<input type="hidden" name='p_to_privilegde' id='p_to_privilegde' value="<%=blng_grp_id%>">
				</td>
				<td colspan='2'></td> 
			  </tr>			

		<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
				<td  class="label"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;<select name="order_type" id="order_type" onChange="">
				    <option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
                    <option value=""><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
					<option value="6"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
					<option value="7"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="9"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
					<option value="8"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
					<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
				</select>
				</td>
				<td colspan='4'></td>
	</tr>				

		<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" id="drug_from">&nbsp;<input type="text" name="drug_name" id="drug_name"readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.drug_name, 1)"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<td width="5%" class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%" id="drug_to">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.tdrug_name, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label" nowrap><fmt:message key="ePH.TermCodeforDrugItems.label" bundle="${ph_labels}"/></td>
	<td colspan="1"><input type="checkbox" name="p_termcode" id="p_termcode"value="N" onClick="checkStatus(this,Term_Code_For_drugItem)">
	</td>
	<!-- <input type="hidden" name="p_termcode" id="p_termcode" value="N"> -->
	<input type="hidden" name="Term_Code_For_drugItem" id="Term_Code_For_drugItem" value="N">
	<td colspan='4'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<select name="p_atc_level" id="p_atc_level" onChange='callATC(this);'>
		<OPTION VALUE="ALL">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="ATC1"><fmt:message key="Common.AnatomicalClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC2"><fmt:message key="Common.TherapeuticMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC3"><fmt:message key="Common.TherapeuticSubClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC4"><fmt:message key="Common.ChemicalMainClass.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ATC5"><fmt:message key="Common.ChemicalSubClass.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td width="15%" class="label" nowrap><fmt:message key="ePH.ATCClassificationFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" id="atc_from">&nbsp;<input type="text" name="p_atc_from_id" id="p_atc_from_id" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="narrationFrom" id="narrationFrom" onClick="search1(document.forms[0].p_atc_from_id,'1')" disabled></td>
		<td width="10%" class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%" id="atc_to">&nbsp;<input type="text" name="p_atc_to_id" id="p_atc_to_id" maxlength="30" readonly size="30" value=""><input type="button" class="button" value="?" name="narrationTo" id="narrationTo" onClick="search1(document.forms[0].p_atc_to_id,'2')" disabled></td>
		<input type="hidden" name="p_atc_from" id="p_atc_from" value="">
	<input type="hidden" name="p_atc_to" id="p_atc_to" value="">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUSBYPRA">
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label"><fmt:message key="Common.NationalItem.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="nat_item" id="nat_item" onChange='callNational(this);'>
		<OPTION VALUE="ALL">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<OPTION VALUE="NAT"><fmt:message key="Common.National.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="NONAT"><fmt:message key="Common.NonNational.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
		<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="item_type" id="item_type" onChange=''>
		<OPTION VALUE="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="ORG"><fmt:message key="Common.Original.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="GEN"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></OPTION>
		</select>
	</td>
		<td colspan='2'>&nbsp;</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label" nowrap><fmt:message key="Common.EDClassification.label" bundle="${common_labels}"/></td>
		<td colspan="5">&nbsp;<select name="ed_class" id="ed_class" style="width:550px" disabled>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<% 
		for(int i=0; i<EDL_Classification_List.size(); i+=2)
				{	
					//EDLlistvalues = (HashMap)EDL_Classification_List.get(i);
					//code = (String)EDLlistvalues.get("code");
                   // desc = (String)EDLlistvalues.get("desc");
			
			%>
            <OPTION value="<%=EDL_Classification_List.get(i).toString()%>"><%=EDL_Classification_List.get(i+1).toString()%></OPTION>
			<%
			
			}
		
			%>
		
		</select>
		</td>
		</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label" nowrap><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		&nbsp;<td>&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="PT" nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	<td class="label" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		&nbsp;<td>&nbsp;<select name="p_report_by" id="p_report_by">
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	</table>



<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<INPUT TYPE="hidden" name="billingYN" id="billingYN" VALUE="<%=billingYN%>">
<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	
	



</form>
<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
<INPUT TYPE="hidden" name="sql_ph_reports_atc1_lookup" id="sql_ph_reports_atc1_lookup" VALUE="<%=sql_ph_reports_atc1_lookup%>">
<INPUT TYPE="hidden" name="sql_ph_reports_atc2_lookup" id="sql_ph_reports_atc2_lookup" VALUE="<%=sql_ph_reports_atc2_lookup%>">
<INPUT TYPE="hidden" name="sql_ph_reports_atc3_lookup" id="sql_ph_reports_atc3_lookup" VALUE="<%=sql_ph_reports_atc3_lookup%>">
<INPUT TYPE="hidden" name="sql_ph_reports_atc4_lookup" id="sql_ph_reports_atc4_lookup" VALUE="<%=sql_ph_reports_atc4_lookup%>">
<INPUT TYPE="hidden" name="sql_ph_reports_atc5_lookup" id="sql_ph_reports_atc5_lookup" VALUE="<%=sql_ph_reports_atc5_lookup%>">
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

