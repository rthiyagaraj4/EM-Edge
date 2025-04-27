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
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhPresPattern.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRESC_PATT_PRACT_SELECT1");
	//String sql_ph_nursing_unit_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1"); //added query for Nursing and clinic.
	//String sql_ph_clinic_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
	String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

	String bean_id				= "SRRPhUncollDrugBean" ;
	String bean_name			= "ePH.SRRPhUncollDrugBean";
	SRRPhUncollDrugBean bean	= (SRRPhUncollDrugBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
//	ArrayList displocationlist  = bean.getDispLocationList();

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
	// out.println("blng_grp_id=====>" +blng_grp_id);
	  /*Creating New Array List for EDL List box values*/
		 ArrayList EDL_Classification_List=new ArrayList();
		 EDL_Classification_List=bean.getEDLClassficationList();
		 HashMap EDLlistvalues=new HashMap();
		 String code="";	
		String desc="";

		 



%>


<!-- <BODY onload="document.formPhPresPatternCriteria.p_facility_code.focus();"> -->
<BODY onload="document.formPhPresPatternCriteria.p_facility_code.focus();checkLocationLookup();callNational(this);" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhPresPatternCriteria.p_facility_code.focus();"> -->

<form name="formPhPresPatternCriteria" id="formPhPresPatternCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td class="label" width='25%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td COLSPAN="1" width='25%'><SELECT name="p_facility_code" id="p_facility_code" onchange='enableLocation(this); checkLocationLookup()'>
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>

	</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
		
	<tr>
		<td class="label" ><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td COLSPAN="1"><input type="text" maxlength="10" size="10" name="dt_from1" id="dt_from1" Onblur="CheckDate(this);DateCheck(sysdate,dt_from1);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> 
		<td COLSPAN="1" width="15%" class='label'nowrap><fmt:message key="ePH.OrderDateTo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
		<td COLSPAN="1" width="35%"><input type="text" maxlength="10" size="10" name="dt_to1" id="dt_to1" Onblur="CheckDate(this);DateCheck(sysdate,dt_to1);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<TD class='label' ><font id='pn'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</font></td>
	<TD width="35%" colspan="1"><select name="locn_type" id="locn_type" onchange='callLocation(this)' disabled>
			<option value="ALL"  >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			<option value="N" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select>
     </td>
	 <td class="label"><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;<input type="text" name="loc_name" id="loc_name" maxlength="30" size="30" value="" onblur="chkloc();" ><input type="button" class="button" value="?" name="loc_search" id="loc_search" onClick="parent.searchLocationName(formPhPresPatternCriteria.loc_name, 1);"></td>
		<input type="hidden" name="loc_id" id="loc_id" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tloc_name" id="tloc_name" maxlength="30" size="30" value="" onblur="chkloc();" ><input type="button" class="button" value="?" name="tloc_search" id="tloc_search"  onClick="parent.searchLocationName(formPhPresPatternCriteria.tloc_name, 2);"></td>
		<input type="hidden" name="tloc_id" id="tloc_id" value="">
		<td colspan='2'></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<!-- Adding new legend billing group 28/12/09 -->
	<tr>
				<td class='label'><label style="<%=visible%>"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
				<td ><input type=text name="billing_from" id="billing_from"  maxlength="30" style="<%=visible%>" size="30" value="" onblur="chkbill();"><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>" onClick='selectbilling(billing_from,"from");'>
				 <input type="hidden" name="p_billgrp_fm1" id="p_billgrp_fm1" value=""/>   
				</td>
				<td class="label" ><label style="<%=visible%>"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
				<td >&nbsp<input type=text name="billing_to" id="billing_to"  maxlength="30" style="<%=visible%>" size="30" value="" onblur="chkbill();"><input class='button' type=button name="billing_button" id="billing_button" value="?"  style="<%=visible%>" onClick='selectbilling(billing_to,"to");'>
				<input type="hidden" name="p_billgrp_to1" id="p_billgrp_to1" value="">
				</td>
				<td colspan='2'></td> 
			  </tr>	
	<tr>

	<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td class="label"><fmt:message key="ePH.SelectBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td  colspan='1' width='25%'><select name="p_select_by" id="p_select_by" onChange="changeLegend(this)">
					<option value="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</option>
					<option value="PT"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td  class='label' COLSPAN="1"><label id='PR'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
		<td  width="35%" COLSPAN="1"><input type="text"  name="dyn_name" id="dyn_name" maxlength="30" size="30" value="" onblur="chktxt(this);" ><input type="button" class="button" value="?" name="drug_search" id="drug_search" disabled onClick="callFunc(this);"></td>

		<!-- onClick="callDrugSearch(document.formPhPresPatternCriteria.drug_name, 1)"></td> -->
		<input type="hidden" name="dyn_code" id="dyn_code" value="">
		
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label"><fmt:message key="Common.NationalItem.label" bundle="${common_labels}"/></td>
		<td><select name="p_national_item" id="p_national_item" onChange='callNational(this)'>
		<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="Y"><fmt:message key="Common.National.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="N"><fmt:message key="Common.NonNational.label" bundle="${common_labels}"/></OPTION>
		
		</select>
		</td>
		<td class="label"><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
		<td><select name="p_item_type" id="p_item_type" onChange=''>
		<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="O"><fmt:message key="Common.Original.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></OPTION>
		</select>
		</td>
		
		<td colspan='2'>&nbsp;</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label" nowrap><fmt:message key="Common.EDClassification.label" bundle="${common_labels}"/></td>
		<td colspan="5"><select name="p_edl_code" id="p_edl_code" style="width:550px" disabled>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
		<% 
		for(int i=0; i<EDL_Classification_List.size(); i++)
				{	
					EDLlistvalues = (HashMap)EDL_Classification_List.get(i);
					code = (String)EDLlistvalues.get("code");
                    desc = (String)EDLlistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
		
		</select>
		</td>
	
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width='25%' colspan='1'><select name="p_order_by" id="p_order_by">
					<option value="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</option>
					<option value="PR"><fmt:message key="ePH.Practitoner.label" bundle="${ph_labels}"/></option>
					<option value="UP"><fmt:message key="ePH.UsagePercent.label" bundle="${ph_labels}"/></option> 
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td class="label" width="15%" ><fmt:message key="Common.ascending.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class="label" width='35%' nowrap><input type="radio" name="choose_service" id="choose_service"  value="A"  checked>
		&nbsp;&nbsp;&nbsp;<fmt:message key="Common.descending.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="radio" name="choose_service" id="choose_service"   value="D" > </input></td>
		<!--		<label class="label" >Base Unit</label> -->
			</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
	<td class="label" colspan='1'><fmt:message key="ePH.CalculateUsage%By.label" bundle="${ph_labels}"/></td>
	<td class="label" width="15%" colspan='1'><fmt:message key="ePH.QtyOrdered.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
	<input type="radio" name="p_usage" id="p_usage"  value="QO"  checked></td>
	<td class="label" width="15%" colspan='1' nowrap><fmt:message key="ePH.NoOfOrders.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
	<input type="radio" name="p_usage" id="p_usage"  value="NO"></td>
	<td class="label" width="15%" colspan='1' nowrap><fmt:message key="ePH.NoofPatients.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
	<input type="radio" name="p_usage" id="p_usage"  value="NP"></td>
	<td colspan='2'></td>
	</tr>
	</table>
		
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRESPAT_SRR">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_locn_type" id="p_locn_type" VALUE="">
	 <INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="billingYN" id="billingYN" VALUE="<%=billingYN%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	<INPUT TYPE="hidden" name="p_location_fm" id="p_location_fm" VALUE="">
	<INPUT TYPE="hidden" name="p_location_to" id="p_location_to" VALUE="">
	 <INPUT TYPE="hidden" name="P_BILLGRP_FM" id="P_BILLGRP_FM" VALUE="">
	<INPUT TYPE="hidden" name="P_BILLGRP_TO" id="P_BILLGRP_TO" VALUE=""> 
	<input type="hidden" name="dt_from" id="dt_from" value="">
	<input type="hidden" name="dt_to" id="dt_to" value="">


</form>
 <input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>"> <!-- added queries for clinic and nursing unit for the lookup location from and to on 29/12/09 -->
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>"> 
	<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

