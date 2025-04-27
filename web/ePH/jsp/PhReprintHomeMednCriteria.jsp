<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>

	<script language="JavaScript" src="../../eST/js/ItemSearch.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhReprintHomeMdn.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	String p_facility_id		= session.getValue( "facility_id" ).toString() ;
	String p_user_name= session.getValue( "login_user" ).toString();	

	String bean_id1				= "PhReprintHomeMednBean" ;
	String bean_name1			= "ePH.PhReprintHomeMednBean";
	PhReprintHomeMednBean bean		= (PhReprintHomeMednBean)getBeanObject( bean_id1,bean_name1,request) ;
	bean.setLanguageId(locale);
	bean.clear();
    ArrayList displocation  = bean.getDispLocation();
	bean.setLoginFacilityId(p_facility_id);
	ArrayList iv_legend=new ArrayList();
	iv_legend=bean.getIVLegends();

%>
<script>
	parent.frames[0].document.forms[0].run.disabled = true;
	</script>
<body onMouseDown="" onKeyDown="lockKey()">

<form name="ReprintHomeMednReportCriteriaform" id="ReprintHomeMednReportCriteriaform" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
 <table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
    <tr>
        <td class="label" align="right"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;<input type="text"  maxlength="60" size="20" name="p_patient_id" id="p_patient_id">
		<input type="button"  class="button" value="?" onclick="callPatientSearch(document.ReprintHomeMednReportCriteriaform.p_patient_id);"onfocus=""  ></td>
		<td></td>
		<td class="label" align="left" ><fmt:message key="ePH.DispensedDateFrom.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td align="left">&nbsp;&nbsp;<input type="text" size="10" maxlength=10 name="p_disp_dt_from" id="p_disp_dt_from" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,p_disp_dt_from))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td> 
		<td class="label" align="right"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td align="left">&nbsp;&nbsp;<input type="text" size="10" name="p_disp_dt_to" id="p_disp_dt_to" Onblur="if(CheckDateT(this))if(DateCheck(sysdate,p_disp_dt_to))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		</td>			
		
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
	  	
</tr>
	<tr><td class='label' colspan='8' height='4'></td></tr>

	  <tr>	
		<td class="label" align="left"><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/> </td>
		<td >&nbsp;<input type="text"  maxlength="60" size="20" name="p_prescription_id" id="p_prescription_id"></td><td></td>
		<td  class="label" align="right"><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="text" name="p_token_no" id="p_token_no" size="6" maxlength="6" onBlur="CheckNum(this);" onkeyPress='return allowValidNumber(this,event,6,0)' class="NUMBER" value=""></td>
		<td class="label" align="right"><fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td align="left">&nbsp;
		<select name="p_language" id="p_language">
						<option value="en"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
						<option value="bm"><fmt:message key="ePH.BehasaMelayu.label" bundle="${ph_labels}"/></option>
		</select>
		</td>
	</tr>
	<tr><td class='label' colspan='8' height='4'></td></tr>
	<tr>
		<td class="label" align="left"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_encounter" id="p_encounter" maxlength="20" size="20"  onKeyPress="return allowValidNumber(this,event,20,0);" onblur="checkForPositiveNumber(this);" ></td><!--Added NumberValidation for [IN46130]-->
		<td  class="label" align="right"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;<SELECT name="p_disp_locn_code" id="p_disp_locn_code"><BR>
		   	<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
			<%	 if (displocation.size() > 0 )
			for (int i=0; i<displocation.size(); i+=2) {
			%>
			<OPTION VALUE="<%= displocation.get(i) %>"><%= displocation.get(i+1) %></OPTION>

			<% 	} %>
	  </SELECT>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>	
		<td class="label" ><fmt:message key="ePH.DrugOrdType.label" bundle="${ph_labels}"/> &nbsp;</td>
		<td class='label'>&nbsp;&nbsp;
				<select name="p_drug_ord_type" id="p_drug_ord_type" onChange="changeReportOptStatus(this)" id="p_drug_ord_type">
					<option value="N" selected><fmt:message key="ePH.NormalRx.label" bundle="${ph_labels}"/></option>
					<option value="T" ><fmt:message key="ePH.TaperOrder.label" bundle="${ph_labels}"/></option>
					
				</select>
				</td>
				<td class="label" id="p_reportOpt"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
		<td align="left" >&nbsp;
				<select name="p_med_type_ind" id="p_med_type_ind" onChange="" id="p_med_type_ind" style="visibility:'visible'">
					<option value="I"><fmt:message key="ePH.Include.label" bundle="${ph_labels}"/></option>
					<option value="S"><fmt:message key="ePH.Separate.label" bundle="${ph_labels}"/></option>
					<option value="O"><fmt:message key="ePH.Only.label" bundle="${ph_labels}"/></option>
				</select>
				</td>
				
	</tr>
	<tr><td class='label' colspan='8' height='4'></td></tr>
	<tr >
	<td class="label" align="left" ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td><select name="p_locn_type" id="p_locn_type" onChange="checklocncode();">		 <BR>
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td></td>
		<td class="label" align="left"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="p_locn_code" id="p_locn_code" STYLE='overflow:visible;' onKeyPress="return CheckForSpecChars(event);"><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(p_locn_code)" onclick="locationLookup(p_locn_code)"><!--size="20" maxlength="20" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
		<input type="hidden" name="locn_code" id="locn_code" value="">
		</td>
		<td class="label" align="left"><fmt:message key="ePH.Orientation.label" bundle="${ph_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="p_Orientation" id="p_Orientation" onChange="">		
				<option value="L"><fmt:message key="ePH.Landscape.label" bundle="${ph_labels}"/></option>
				<option value="P"><fmt:message key="ePH.Portrairt.label" bundle="${ph_labels}"/></option>
			</select>
		</td>
		</td>
	</tr>
	<tr><td class='label' colspan='8' height='4'></td></tr>
	<tr><td></td><td></td><td></td><td></td>
	<td colspan="2" > &nbsp;</td>
			<td align="right"> &nbsp;
			<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onclick="showDtlResults()" >
		</td>
	</tr>
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%=p_user_name%>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=p_facility_id%>">
	<INPUT TYPE="hidden" name="p_print_seq_no" id="p_print_seq_no" VALUE="">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	<INPUT TYPE="hidden" name="p_from_date" id="p_from_date" VALUE="">
	<INPUT TYPE="hidden" name="p_to_date" id="p_to_date" VALUE="">
	<INPUT TYPE="hidden" name="p_add_drug_yn" id="p_add_drug_yn" VALUE=""> <!--Added for RUT-SCF-0384[IN46988] -->
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
	



</form>
</body>
</html>

