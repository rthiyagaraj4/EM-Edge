<!DOCTYPE html>


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*, eST.*, eST.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/SRRPhFillListbyNursingUnit.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<!-- Added event onload="run Button Disabled for the incident num:23846 in spira on 20/Sept/2010---Sandhya -->
<form name="SRRPhFillListbyNursingUnitCriteriaForm" id="SRRPhFillListbyNursingUnitCriteriaForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onload="parent.frames[0].document.forms[0].run.disabled = true">
<%
  	
	String patient_id	=	request.getParameter("patient_id");
	String sOrderType	=	request.getParameter("order_type");

	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	String facility					= (String)	session.getValue( "facility_id" );

	String bean_id2				=		"ReportsStockStatusBean";
	String bean_name2			=		"eST.ReportsStockStatusBean";
	ReportsStockStatusBean bean2 =		(ReportsStockStatusBean) getBeanObject( bean_id2,  bean_name2,request  );  

	ArrayList params = new ArrayList();
		params.add(facility);
		params.add(locale);

	//String p_buliding	=	bean2.getListOptionTag(bean2.getListOptionArrayList("SELECT DISTINCT I.bldng_code BLDNG_CODE, c.SHORT_DESC FROM ip_nursing_unit_location i, IP_NURSING_UNIT_LANG_VW A, PH_ORDER_ROUTING B, AM_BLDNG_LANG_VW c WHERE A.NURSING_UNIT_CODE=B.ORDERING_SOURCE_CODE  AND A.FACILITY_ID LIKE ? AND A.EFF_STATUS='E' AND B.ORDERING_SOURCE_TYPE='N' AND I.NURSING_UNIT_CODE=A.NURSING_UNIT_CODE  AND A.LANGUAGE_ID = ? and i.BLDNG_CODE = c.BLDNG_CODE  and i.FACILITY_ID = c.OPERATING_FACILITY_ID and a.LANGUAGE_ID = c.LANGUAGE_ID order  by upper(c.short_desc) ",params)); //commented and added below sql for SRR20056-SCF-7186 [IN:027144] (Ref: Modified query by Naveen===Regarding incident num:26055 on21/jan/2011(Displaying all buildings) ->in ipfillall.js-NursingUnitSearch())
	String p_buliding	=	bean2.getListOptionTag(bean2.getListOptionArrayList("SELECT DISTINCT i.bldng_code code, c.short_desc description FROM ip_nursing_unit_location i, ip_nursing_unit_lang_vw a,	am_bldng_lang_vw c WHERE a.facility_id LIKE ? AND a.eff_status = 'E'   AND i.nursing_unit_code = a.nursing_unit_code  AND a.language_id =?  AND i.bldng_code = c.bldng_code AND i.facility_id = c.operating_facility_id  AND a.language_id = c.language_id order  by upper(c.short_desc) ",params));

	bean2.clear();
	bean2.setLanguageId(locale);

	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
	
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="prescriptionquerycriteriatable" >
	<tr>
       <td class="label" nowrap><fmt:message key="ePH.FillID.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<input type="text" name=	"p_disp_facility_id" maxlength="15" size="20" onKeyPress="return CheckForSpecChars(event);">

		</td>
		<td class="label" nowrap><fmt:message key="ePH.FillProcessType.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;
			<select name="p_fill_proc_ty" id="p_fill_proc_ty" onChange="resetLocation()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="I"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/></option>
				<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
			</select>
		</td>
			 
		<td class="label" nowrap><fmt:message key="ePH.FillProcessDate.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" name="p_fill_proc_fr_dt" id="p_fill_proc_fr_dt" value="" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(sysdate,p_fill_proc_fr_dt))validate_date(this,'TO_DATE_LESS_FROM');" >
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_fill_proc_fr_dt');"  onblur='p_fill_proc_fr_dt.focus()'></td>
		<td>&nbsp;
		<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_fill_proc_to_dt" id="p_fill_proc_to_dt" value="" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(sysdate,p_fill_proc_to_dt))validate_date(this,'TO_DATE_LESS_FROM');">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_fill_proc_to_dt');" onblur='p_fill_proc_to_dt.focus()' ></td>   
				
	</tr>

	<tr>
	<td class="label" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td>&nbsp;
			<select name="p_select" id="p_select" onChange="resetNursingBuilding()">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="L"><fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/></option>
			</select>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td>
		<!-- return CheckForSpecChars(event)Passed Hidden var's for locn_code,locn_code1 for Nursing Unit regdng incident num:25068 on 1/Dec/2010,25485==corrected==By Sandhya  -->
			<td class="label" nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>

			<td>&nbsp;&nbsp;<input type="text" name="p_fr_nurs_unit" id="p_fr_nurs_unit" maxlength="20" size="20"  disabled onKeyPress=""><input type="button" name="btnnur" id="btnnur" class="button" value="?" onfocus="searchNursingUnit(p_fr_nurs_unit,locn_code)" onClick="searchNursingUnit(p_fr_nurs_unit,locn_code)" disabled onKeyPress=""><input type="hidden" name="locn_code" id="locn_code">
		</td>

		<td class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
<td>&nbsp;&nbsp;<input type="text" name="p_to_nurs_unit" id="p_to_nurs_unit" maxlength="20" size="20"  disabled onKeyPress=""><input type="button" name="btntonurs" id="btntonurs" class="button" value="?" onfocus="searchNursingUnit(p_to_nurs_unit,locn_code1)" onClick="searchNursingUnit(p_to_nurs_unit,locn_code1)" disabled onKeyPress=""><input type="hidden" name="locn_code1" id="locn_code1">
		</td>
		</tr>
		<tr>
<td colspan="2">&nbsp;</td>	
<td class="label" nowrap><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
		<td class=fields >&nbsp;&nbsp;<SELECT name="p_build" id="p_build" disabled><%=p_buliding%>
					</select>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>




<td colspan="4">&nbsp;</td>
</tr>
		<tr>
		
		<td class="label" nowrap><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
<td>&nbsp;
			<select name="p_rep_type" id="p_rep_type" >		 <BR>
			<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="ePH.ByPatient.label" bundle="${ph_labels}"/></option>
				<option value="P"><fmt:message key="ePH.ByDrugMedicalSupply.label" bundle="${ph_labels}"/></option>
			</select>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td>
		
		<td colspan="4"></td>
		<td colspan="2"> 
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()" >
		</td>
	</tr>
		

		
</table>
<input type="hidden" name="P_FILL_PROC_DT" id="P_FILL_PROC_DT" value="">
<input type="hidden" name="P_FILL_PROC_ID" id="P_FILL_PROC_ID" value="">
<input type="hidden" name="P_FILL_PROC_TY" id="P_FILL_PROC_TY" value="">
<input type="hidden" name="p_nurs_unit" id="p_nurs_unit" value="">

<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">

<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="P_reprint" id="P_reprint" VALUE="Y">
    
</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
<INPUT TYPE="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>">
</body>
<%
	if(sOrderType != null && !sOrderType.equals(""))
	{
		if(sOrderType.equals("ALL"))
			sOrderType = "All";
%>
	<script>
		document.PhRepPrescriptionCriteriaForm.order_type.value = '<%=sOrderType%>';
	</script>
<%
	}

%>

<script>

 <% if(!patient_id.equals("")){ %>
 showResults()
 <%	}	%>
 </script>
</html>

