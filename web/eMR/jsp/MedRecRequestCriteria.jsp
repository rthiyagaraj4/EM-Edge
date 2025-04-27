<!DOCTYPE html>
<!-- 
	Module			:	eMR
	Modified On		:	12/05/2005
	Modified By		:   Vinod Babu for View Death Register
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%
	String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css");
%>
<head>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript'
	src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript'
	src="../../eMR/js/MedRecRequestCriteria.js"></script>
<script language='javascript' src="../../eMR/js/MedRecRequestMain.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script>
function CompareDates(from, to)
{
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
		var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
		if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			document.forms[0].to_date.value = '';
			document.forms[0].to_date.select();
		}
	}
}

function validate_date(obj) {
		var locale = document.forms[0].locale.value;
		var from = convertDate(obj.value,"DMY",locale,"en");
	   var to   = document.forms[0].SystemDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("eMR.EncPeriod.label","MR"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

function validateDate(obj){

if(obj.value!="")
	{
	if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			
			return ;
		}
	}
}

function callcheck_val()
{ 
	if (document.forms[0].discharge_val.checked==true)
		document.forms[0].discharge_val.value="Y";
	else
		document.forms[0].discharge_val.value="N";
}

//Func will return an alert message if FROM DATE is null and TO Date is selected
function checkFromDt(to,frmDt)
{
	if ( (frmDt.value=='') && (to.value!='') )
	{
		error  = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.fromdate.label","Common"));		
		alert(error);
		to.value='';
		frmDt.focus();
		return false;
	}
}

function doDcsdDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			
            if(Date.parse(todt) <= Date.parse(fromdt)) {
                return false;
            }
            else if(Date.parse(todt) > Date.parse(fromdt)) return true;
    }
	return true;
}

function DscdPeriodChk(Dt)
{	
	if(Dt.value!="")	
	{
		var SystemDate	= document.forms[0].SystemDate.value;
		if(validDate(Dt.value,"DMY","en"))
		{
			var toDt	= convertDate(Dt.value,"DMY",localeName,"en");
			if(!isAfter(SystemDate,toDt,'DMY',localeName))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));		
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	}
	return;
}

function doDischargeDateCheck(obj1,obj2)
{
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		return false;
	}
	else
		return true;
}

function disChargePeriodChk(Dt)
{
	if(Dt.value!="")
	{	
		if(validDate(Dt.value,"DMYHM","en"))
		{
			var toDt	= convertDate(Dt.value,"DMYHM",localeName,"en");
			if(!isBeforeNow(toDt,"DMYHM","en"))// DateUtils.js
			{
				error=getMessage("MRDATE1_GT_DATE2","MR");
				//error = error.replace('$', getLabel("eMR.DeceasedPeriod.label","MR"));	
				error = error.replace('$', getLabel("eMR.DischPeriod.label","MR"));	
				error = error.replace('#', getLabel("Common.CurrentDate.label","Common"));	
				alert(error);
				Dt.value='';
				Dt.focus();
			}
		}
	}
	return;
}


//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value = '';
				to.focus();
			}
		}
	}
}

function CompareDisPeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )// DateUtils.js
	{
		if(validDate(frdt,"DMYHM","en") && validDate(tdt,"DMYHM","en"))
		{
			var fromDt	= convertDate(frdt,"DMYHM",localeName,"en");
			var toDt	= convertDate(tdt,"DMYHM",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMYHM',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}


function CompareAltPeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='')
	{
		t1 =false;
		t1 = CheckDate(from);
		if(!t1)
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			from.value="";
			from.focus();
			return;
		}
		
	}
	if(tdt !='')
	{
		t1 =false;

		t1 = CheckDate(to);	
		
		if(!t1)
		{
			//alert(getMessage("INVALID_DATE_TIME","SM"));
			to.value=""; 
			to.focus();
			return;
		}
	}

	if (!PeriodcheckDateTime(frdt,tdt) )
	{
		  to.focus();
		  to.select();
	}
	
}


//FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//Func will return an alert message if TO DATE is Less than FROM DATE
//This function only used for Comparison of Deceased Period only
function CompareDeceasedPeriod(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='')
	{
		var t1 =false;
		t1 = CheckDate(from);
		if(!t1)
		{
			from.value="";
			from.focus();
			return;
		}
		
	}
	if(tdt !='')
	{
		var t1 =false;
		t1 = CheckDate(to);	
		
		if(!t1)
		{
			to.value=""; 
			to.focus();
			return;
		}
	}

	if (!PeriodcheckDateTime(frdt,tdt) )
	{
		  
		  to.focus();
		  to.select();
	}
	
}





</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_user_name = (String) session.getValue("login_user");
	String locale = (String) session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific = eCommon.Common.CommonBean.isSiteSpecific(
			con, "MR", "MLC_TO_MEDICO_LEGAL_CASE");
	/*end ML-MMOH-CRF-0354 [IN057191] */
	boolean isPrePractinReprintAppl = eCommon.Common.CommonBean
			.isSiteSpecific(con, "MR", "ALLOW_PREP_PRACT_REPRINT"); //added by mujafar for ML-MMOH-SCF-1365

	ResultSet rs = null;
	ResultSet rs1 = null;
	Statement stmt = null;
	Statement stmt1 = null;
	String pat_id_length = "";
	try {
		String jsp_name = request.getParameter("jsp_name");
		if (jsp_name == null)
			jsp_name = "";
		String window_styl = request.getParameter("window_styl");
		if (window_styl == null)
			window_styl = "";
		String close_yn = request.getParameter("close_yn");
		if (close_yn == null)
			close_yn = "";
		String win_top = request.getParameter("win_top");
		if (win_top == null)
			win_top = "";
		String win_height = request.getParameter("win_height");
		if (win_height == null)
			win_height = "";
		String win_width = request.getParameter("win_width");
		if (win_width == null)
			win_width = "";

		String call_function = request.getParameter("call_function");
		if (call_function == null)
			call_function = "";

		String modal = request.getParameter("modal");
		if (modal == null)
			modal = "";
		String dialogTop = request.getParameter("dialogTop");
		if (dialogTop == null)
			dialogTop = "";

		String module = request.getParameter("module");
		if (module == null)
			module = "";

		String model_window = request.getParameter("model_window");
		if (model_window == null)
			model_window = "";

		String function_id = request.getParameter("function_id");
		if (function_id == null)
			function_id = "";

		String prog_id = request.getParameter("prog_id");
		if (prog_id == null)
			prog_id = "";

		String practitioner_id = request
				.getParameter("practitioner_id");
		if (practitioner_id == null)
			practitioner_id = "";

		String wherecondn = request.getParameter("wherecondn");
		if (wherecondn == null)
			wherecondn = "";

		String operstn = request.getParameter("wherecondn");
		if (wherecondn == null)
			wherecondn = "";

		String oper_stn_id = request.getParameter("oper_stn_id");
		if (oper_stn_id == null)
			oper_stn_id = "";

		String oper_stn_id1 = request.getParameter("oper_stn_id1");
		if (oper_stn_id1 == null)
			oper_stn_id1 = "";

		String reportname = request.getParameter("reportname");
		if (reportname == null)
			reportname = "";
		String encounterID_repDischargeAdvice = request
				.getParameter("encounter_id");
		if (encounterID_repDischargeAdvice == null)
			encounterID_repDischargeAdvice = "";
		String loginUser = (String) session.getValue("login_user");
		String p_facility_id = (String) session.getValue("facility_id");
		String SystemDate = "";
		String SystemDate_op = "";
		String SystemDate_ip = "";
		String recode_for_op_yn = "";
		String recode_for_ip_yn = "";
		String recode_for_em_yn = "";
		String recode_for_dc_yn = "";
		String SDate = "";
		String stage_no = "";
		String recode_OP_yn = "";
		String recode_IP_yn = "";
		int op_visit = 0;
		int ip_disch = 0;

		String max_level_for_op_yn = "";
		String max_level_for_ip_yn = "";
		String max_level_for_input = "";
		String max_level_for_dc_yn = "";
		String max_level_for_em_yn = "";
		int grace_period = 0;

		String op_grace = "";
		String ip_grace = "";
		String create_file_yn = "";
		try {
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select patient_id_length, to_char(sysdate+1 - "
							+ op_visit
							+ ",'dd/mm/yyyy')SystemDate_op, to_char(sysdate+1 - "
							+ ip_disch
							+ ",'dd/mm/yyyy')SystemDate_ip,to_char(sysdate,'dd/mm/yyyy')SystemDate,to_char(sysdate,'dd/mm/yyyy')SDate,to_char(sysdate+1 - "
							+ (op_visit + grace_period)
							+ ",'dd/mm/yyyy')op_grace,to_char(sysdate+1 - "
							+ (ip_disch + grace_period)
							+ ",'dd/mm/yyyy')ip_grace,create_file_yn  from mp_param");
			if (rs.next() && rs != null) {
				pat_id_length = rs.getString(1);
				SystemDate_op = rs.getString(2);
				SystemDate_ip = rs.getString(3);
				SystemDate = rs.getString(4);
				SDate = rs.getString(5);
				op_grace = rs.getString(6);
				ip_grace = rs.getString(7);
				create_file_yn = rs.getString(8);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
		}

		//out.println("<script>alert(\"op_visit :"+SystemDate_op+SystemDate_ip+"\");</script>");

		SystemDate_op = DateUtils.convertDate(SystemDate_op, "DMY",
				"en", localeName);
		SystemDate_ip = DateUtils.convertDate(SystemDate_ip, "DMY",
				"en", localeName);
		String SystemDate_display = DateUtils.convertDate(SystemDate,
				"DMY", "en", localeName);
		String SystemDischarge_display = DateUtils.convertDate(SDate,
				"DMY", "en", localeName);
		op_grace = DateUtils.convertDate(op_grace, "DMY", "en",
				localeName);
		ip_grace = DateUtils.convertDate(ip_grace, "DMY", "en",
				localeName);
		String serialNo = "";
		int cutOffVisit = 0;
		String cutOffDischarge = "";
		//String authorize_yn = "";
		//String grace_period = "";
%>
<body onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()"
	onKeyDown='lockKey()'>
	<form name='search_form' action="../../eCommon/jsp/report_options.jsp"
		target="messageFrame">
		<%
			if (!call_function.equals("RECORD_DIAGNOSIS")
						&& !call_function.equals("PROCEDURE_RECORDING")
						&& !call_function.equals("VISITS_WITHOUT_MDS")) {
		%>
		<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp"><jsp:param
				name="flush" value="true" />
			<jsp:param name="patient_id" value="" />
			<jsp:param name="alert_reqd_yn" value="" />
			<jsp:param name="mr_transaction" value="Y" />
		</jsp:include>
		<%
			}
				//out.println("<script>alert(\""+call_function+"\");</script>");
		%>
		<table cellpadding='2' border='0' cellspacing='0' width='100%'>
			<tr>
				<td width="25%" class="label"><fmt:message
						key="Common.patientId.label" bundle="${common_labels}" /><br></td>
				<td width="25%" class="fields"><input type=text
					name='PatientId' id='PatientId' size=""
					maxlength="<%=pat_id_length%>"
					onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);"
					onKeypress='return CheckForSpecChars(event);' align="center"><input
					type='button' name='patient_id' id='patient_id' value='?'
					class='button' onclick='callSearchScreen()'>
					<%
						if (!call_function.equals("QUERY_MARK_MLC_OSCC")
									&& !call_function.equals("QUERY_MATERNAL_REPORT")
									&& !call_function.equals("MR_VIEW_DTH_REG")
									&& !call_function.equals("DIAG_RECODE")) {
					%>
					<img src='../../eCommon/images/mandatory.gif' align='center' id='patID_img' style="visibility: visible"></img>
					<%
						}
					%></td>
					<%if(!call_function.equals("PROCEDURE_RECORDING")){ %>

						<td width="25%" class='label'>&nbsp;</td>
						<td width="25%" class='label'>&nbsp;</td>
					<%
						}
					%>
				<%
					if (!call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("QUERY_MATERNAL_REPORT")
								&& !call_function.equals("MR_VIEW_DTH_REG")
								&& !call_function.equals("DIAG_RECODE")
								&& !call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("MEDICAL_REPORT_REQUEST")
								&& !call_function.equals("TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("MARK_MLC_OSCC")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				%>
				<td width="25%" class='label'>&nbsp;</td>
				<td width="25%" class='label'>&nbsp;</td>
				<%
					}
				%>


				<!--PatValidations(document.forms[0].PatientId); added on 31-07-08 for SCR 4964-->
				<%
					if (call_function.equals("QUERY_MATERNAL_REPORT")) {
				%>
				<td width="25%" class='label' nowrap><fmt:message key="Common.CauseIndicator.label" bundle="${common_labels}" /></td>
				<td width="25%" class="fields"><select name="cause_ind" id="cause_ind">
						<option>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>
						<%
							//rs = stmt.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from ip_discharge_type where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' order by 2 ")  ;
									rs = stmt
											.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from IP_DISCHARGE_TYPE_LANG_VW  where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' AND language_id='"
													+ locale + "' order by 2 ");
									if (rs != null) {
										while (rs.next()) {
						%>
						<option value='<%=rs.getString("DISCHARGE_TYPE_CODE")%>'><%=rs.getString("SHORT_DESC")%></option>
						<%
							}
									}
						%>
				</select></td>
				<%
					}

						if (!call_function.equals("QUERY_MATERNAL_REPORT")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("DIAG_RECODE")
								&& !call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("MEDICAL_REPORT_REQUEST")
								&& !call_function.equals("TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("MR_VIEW_DTH_REG")
								&& !call_function.equals("MARK_MLC_OSCC")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				%>
				<td width="25%" class='label'>&nbsp;</td>
				<td width="25%" class='label'>&nbsp;</td>
				
				<%
					}
				%>
				<%
					if (call_function.equals("QUERY_MARK_MLC_OSCC")) {
				%>
				<td width="25%" class='label'><fmt:message
						key="eMR.MarkedStatus.label" bundle="${mr_labels}" /></td>
				<td width="25%" class="fields"><select name='marked_status'
					id='marked_status'>
						<option value=''>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>
						<option value='O'>
							<fmt:message key="Common.oscc.label" bundle="${common_labels}" />
						</option>
						<%
							if (siteSpecific) {
						%>
						<option value='M'>
							<fmt:message key="Common.MedicalLegalCase.label"
								bundle="${common_labels}" />
						</option>
						<%
							} else {
						%>
						<option value='M'>
							<fmt:message key="Common.mlc.label" bundle="${common_labels}" />
						</option>
						<%
							}
						%>
				</select></td>
				<%
					}
						if (!call_function.equals("DIAG_RECODE")
								&& !call_function.equals("QUERY_MARK_MLC_OSCC")
								&& !call_function.equals("QUERY_MATERNAL_REPORT")) {
				%>
				<!-- <td width="25%" class='label'>&nbsp;</td>
				<td width="25%" class='label'>&nbsp;</td> -->
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (!call_function.equals("QUERY_MATERNAL_REPORT")
								&& !reportname.equals("MR")) {
				%>
				<td width="25%" class="label"><fmt:message
						key="Common.encountertype.label" bundle="${common_labels}" /></td>
				<td class="fields">
					<%
						if (rs != null)
									rs.close();
								if (call_function.equals("MR_REC_PAT_VAL")
										|| call_function.equals("REPRINT_PAT_VAL")
										|| call_function
												.equals("MR_INTERNAL_REPORTS_REPRINT")) {
									if (call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
											&& reportname.equals("MRDGRCSM")) {
					%> <select name="lstPatientClass" id="lstPatientClass"
					onchange="clearResultPage(this)">
						<option value='IP'>
							<fmt:message key="Common.inpatient.label"
								bundle="${common_labels}" />
						</option>
						<%
							} else {

											//rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS where patient_class not in ('XT') order by 1");
						%>
						<select name="lstPatientClass" id="lstPatientClass"
						onchange="clearResultPage(this)">
							<option value="">
								---
								<fmt:message key="Common.defaultSelect.label"
									bundle="${common_labels}" />
								---
							</option>
							<%
								rs = stmt
														.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW where patient_class not in ('XT') AND language_id='"
																+ locale + "' order by 1");

												if (rs != null) {
													while (rs.next()) {
							%>
							<option value='<%=rs.getString("PATIENT_CLASS")%>'><%=rs.getString("short_desc")%></option>
							<%
								}
												}
												if (rs != null)
													rs.close();
											}
										} else {
							%>
							<select name="lstPatientClass" id="lstPatientClass"
							onchange="clearPage()">
								<option value="">
									---
									<fmt:message key="Common.defaultSelect.label"
										bundle="${common_labels}" />
									---
								</option>
								<%
									//rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS order by 1");
												rs = stmt
														.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW WHERE language_id='"
																+ locale + "' order by 1");

												if (rs != null) {
													while (rs.next()) {
								%>
								<option value='<%=rs.getString("PATIENT_CLASS")%>'><%=rs.getString("short_desc")%></option>
								<%
									}
												}
												if (rs != null)
													rs.close();
											}
								%>
						</select>
						<img src='../../eCommon/images/mandatory.gif' align='center'
							id='encType_img' style="visibility: hidden"></img>
				</td>
				
				<%
					} else {
				%>
				<!-- <td width="25%" class='label'>&nbsp;</td>
				<td width="25%" class='label'>&nbsp;</td> -->
				<%
					}
						if (!call_function.equals("MR_REC_PAT_VAL")
								&& !call_function.equals("REPRINT_PAT_VAL")
								&& !call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
							SystemDate_display = "";
						}
				%>
				<%
					if (!reportname.equals("MR")) {
				%>
				<td class="label" width="25%"><fmt:message
						key="eMR.EncPeriod.label" bundle="${mr_labels}" /><br></td>
				<td class="fields" width="25%"><input type="text"
					name="alt_id1_exp_date" id="alt_id1_exp_date" size="10"
					maxlength='10' id='altidexpdt1'
					onblur='validDateObj(this,"DMY","<%=locale%>");validate_date(this);ComparePeriodFromToTime(this,alt_id2_exp_date);'
					onkeypress="return Valid_DT(event)" value="<%=SystemDate_display%>"></input><img
					id='enc1' src='../../eCommon/images/CommonCalendar.gif'
					onClick="document.forms[0].alt_id1_exp_date.focus();return showCalendar('alt_id1_exp_date');">-<input
					type="text" name="alt_id2_exp_date" id="alt_id2_exp_date" size="10"
					maxlength='10' id='altidexpdate2'
					onblur='validDateObj(this,"DMY","<%=locale%>");validate_date(this);ComparePeriodFromToTime(alt_id1_exp_date,this);'
					onkeypress="return Valid_DT(event)" value="<%=SystemDate_display%>"></input><img
					id='enc2' src='../../eCommon/images/CommonCalendar.gif'
					onClick="document.forms[0].alt_id2_exp_date.focus();return showCalendar('alt_id2_exp_date');"><img
					src='../../eCommon/images/mandatory.gif' align='center'
					id='encDate_img' style="visibility: hidden"></img></td>
					<!-- <td>&nbsp;</td>
					<td>&nbsp;</td>		 -->			
					<%
					if (call_function.equals("RECORD_DIAGNOSIS")) {
					%>
						<td>&nbsp;</td>
						<td>&nbsp;</td>						
					<%
					}
					%>
					
				<%
					}
				%>

				<%
					if (call_function.equals("MR_REC_PAT_VAL")
								|| call_function.equals("REPRINT_PAT_VAL")
								|| call_function.equals("MR_INTERNAL_REPORTS_REPRINT")) {
				%>
				<script>
				document.getElementById("patID_img").style.visibility = "hidden";
//				document.forms[0].alt_id1_exp_date.value = "<%=SystemDate_display%>";
//				document.forms[0].alt_id2_exp_date.value = "<%=SystemDate_display%>";
			</script>
				<%
					}
				%>


			</tr>

			<%
				if (call_function.equals("QUERY_MATERNAL_REPORT")
							|| call_function.equals("MR_VIEW_DTH_REG")) {
			%>
			<tr>
				<%
					if (call_function.equals("MR_VIEW_DTH_REG")) {
				%>
				<td class="label"><fmt:message key="eMR.DeceasedPeriod.label"
						bundle="${mr_labels}" /></td>
				<td class="fields"><input name='p_discharge_date_from'
					id='p_discharge_date_from' id='dischargedatefrom'
					onblur='validDateObj(this,"DMY","<%=locale%>");ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);'
					value='' size='10' maxlength='10'
					onkeypress="return Valid_DT(event)"></input><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="document.forms[0].p_discharge_date_from.focus();return showCalendar('p_discharge_date_from');"></input>-<input
					name='p_discharge_date_to' id='p_discharge_date_to'
					id='dischargedateto' value='' size='10' maxlength='10'
					onblur='validDateObj(this,"DMY","<%=locale%>");ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);'
					onkeypress="return Valid_DT(event)"></input><img
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="document.forms[0].p_discharge_date_to.focus();return showCalendar('p_discharge_date_to');"></input></td>

				<%
					} else {
				%>
				<td class="label"><fmt:message key="eMR.DischPeriod.label"
						bundle="${mr_labels}" /></td>
				<td class="fields"><input name='p_discharge_date_from'
					id='p_discharge_date_from' id='dischargedatefrom' value=''
					size='12' maxlength='16'
					onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);/*validateDate(this)*/'><img
					id='d1' src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('p_discharge_date_from',null,'hh:mm' );"></input>-<input
					name='p_discharge_date_to' id='p_discharge_date_to'
					id='dischargedateto' value='' size='12' maxlength='16'
					onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);'
					onkeypress="return Valid_DT(event)"><img id='d2'
					src="../../eCommon/images/CommonCalendar.gif"
					onClick="return showCalendar('p_discharge_date_to',null,'hh:mm' );"></input><img
					src='../../eCommon/images/mandatory.gif' align='center'
					id='discDate_img' style="visibility: hidden"></td>
				<%
					}
				%>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>

			</tr>
			<%
				}
			%>
			<tr>



			</tr>
			<%
				if (!reportname.equals("MR")) {
			%>
			<tr>
				<td class="label" width="25%"><fmt:message
						key="Common.encounterid.label" bundle="${common_labels}" /></td>
				<td class="fields" width="25%"><input type=text
					name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12"
					onKeyPress='return(ChkNumberInput(this,event,0))'
					onBlur="CheckNumVal(this)" align="center"></td>
				<td class="label" width="25%">
					<%
						if (call_function.equals("VISITS_WITHOUT_MDS")) {
					%> Min Data Set Type <%
						} else {
					%> <fmt:message key="Common.orderBy.label"
						bundle="${common_labels}" /> <%
 	}
 %>
				</td>
				<td class="fields" width="25%">
					<%
						if (call_function.equals("VISITS_WITHOUT_MDS")) {
					%> <%
 	} else {
 %><select name="orderBy" id="orderBy"
					onchange='clearResultPage(this)'><option>
							---
							<fmt:message key="Common.defaultSelect.label"
								bundle="${common_labels}" />
							---
						</option>
						<option value="ED" selected>
							<fmt:message key="Common.encounterdate.label"
								bundle="${common_labels}" />
						</option>
						<option value="ET">
							<fmt:message key="Common.encountertype.label"
								bundle="${common_labels}" />
						</option>
				</select> <%
 	}
 %>
				</td>
				<%
					if (call_function.equals("RECORD_DIAGNOSIS")) {
				%>
						<!-- <td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td> -->
				<%
					}
				%>
				<!-- <td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td> -->
			</tr>
			<%
				}
			%>
			<%%>


			<%
				if (call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
							&& reportname.equals("MR")) {
			%>
			<tr>
				<td class='label' width="23%"><fmt:message
						key="eMR.MedicalReportStatus.label" bundle="${mr_labels}" /></td>
				<td class='fields'><select name='status_to_show'
					id='status_to_show'>

						<option value="1">
							<fmt:message key="Common.Requested.label"
								bundle="${common_labels}" />
						</option>
						<option value="7">
							<fmt:message key="Common.status.label" bundle="${common_labels}" />
							&nbsp;
							<fmt:message key="Common.incomplete.label"
								bundle="${common_labels}" />
						</option>
						<option value="2">
							<fmt:message key="eMR.StatusCompleted.label"
								bundle="${mr_labels}" />
						</option>
						<%
							if (isPrePractinReprintAppl) { //added by mujafar for ML-MMOH-SCF-1365
						%>
						<option value="4">
							<fmt:message key="eMR.PreparedbyPractitioner.label"
								bundle="${mr_labels}" />
						</option>
						<%
							}
						%>
						<option value="5">
							<fmt:message key="eMR.ReceivedbyMedicalRecord.label"
								bundle="${mr_labels}" />
						</option>
						<option value="6">
							<fmt:message key="eMR.ReportDelivered.label"
								bundle="${mr_labels}" />
						</option>
						<option value="0">
							<fmt:message key="Common.Overdue.label" bundle="${common_labels}" />
						</option>
						<option value="" selected>
							<fmt:message key="Common.all.label" bundle="${common_labels}" />
						</option>
				</select></td>

				<td class='label'><fmt:message
						key="Common.RequestDateFrom.label" bundle="${common_labels}" /></td>
				<td class='fields'><input type='text'
					onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,to_date);'
					id="req_date_from" maxlength='10' size='10' name='from_date'
					value="" onkeypress="return Valid_DT(event)"><img
					src='../../eCommon/images/CommonCalendar.gif'
					onClick="document.forms[0].req_date_from.focus();return showCalendar('req_date_from');">
					- <input type='text'
					onblur='validDateObj(this,"DMY","<%=locale%>");CompareDates(this,from_date);'
					id="req_date_to" value="" maxlength='10' size='10' name='to_date'
					onkeypress="return Valid_DT(event)"><img
					src='../../eCommon/images/CommonCalendar.gif'
					onClick="document.forms[0].req_date_to.focus();return showCalendar('req_date_to');"></td>
			</tr>
			<%
				}
			%>

			<tr >
				<%
					if (call_function.equals("MR_REC_PAT_VAL")) {
				%>
				<td class='label'><fmt:message key="Common.discharged.label"
						bundle="${common_labels}" /></td>
				<td class="fields"><input type="checkbox" name="discharge_val"
					id="discharge_val" onclick="callcheck_val();"></td>
				<%
					} else {
				%>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<%
					}
				%>
				<td class='label'>&nbsp;</td>
				<td class="button" style="text-align: right;"><input type='button' id='search'
					name='search' id='search'
					value='<%=com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.search.label", "common_labels")%>'
					class='button' onclick='submitPage()'>
				<!--id added for ML-MMOH-SCF-1854--> <input type='button' style="margin-right: 10px;"
					name='clear' id='clear'
					value='<%=com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.clear.label", "common_labels")%>'
					class='button' onclick='clearAll()'></td>
					<%
					if (call_function.equals("RECORD_DIAGNOSIS")) {
					%>
						<!-- <td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td> -->
					<%
					}
					%>
					<!-- <td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td> -->
			</tr>
		</table>
		<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>"> 
		<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>"> 
		<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>">
		<input type='hidden' name='param' id='param' value="<%=call_function%>"> 
		<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>">
		<input type='hidden' name='modal' id='modal' value="<%=modal%>"> 
		<input type='hidden' name='module' id='module' value="<%=module%>">
		<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>"> 
		<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
		<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>"> 
		<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>"> 
		<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>"> 
		<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>"> 
		<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>">
		<input type='hidden' name='SystemDate' id='SystemDate' value="<%=SystemDate%>"> 
		<input type='hidden' name='qerString' id='qerString' value="<%=request.getQueryString()%>">
		<input type='hidden' name='p_report_id' id='p_report_id'value='MRBIPFFPRC'></input> 
		<input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input> 
		<input type='hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
		<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input> 
		<input type='hidden' name='sys_date' id='sys_date' value=''></input> 
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'></input>
		<input type='hidden' name='oper_stn_id1' id='oper_stn_id1' value='<%=oper_stn_id1%>'></input> 
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input> 
		<input type='hidden' name='SystemDischarge_display' id='SystemDischarge_display' value='<%=SystemDischarge_display%>'></input> 
		<input type='hidden' name='serialNo' id='serialNo' value='<%=serialNo%>'></input>
		<input type='hidden' name='cutOffVisit' id='cutOffVisit' value='<%=cutOffVisit%>'></input> 
		<input type='hidden' name='cutOffDischarge' id='cutOffDischarge' value='<%=cutOffDischarge%>'></input> 
		<input type='hidden' name='SystemDate_op' id='SystemDate_op' value='<%=SystemDate_op%>'></input>
		<input type='hidden' name='SystemDate_ip' id='SystemDate_ip' value='<%=SystemDate_ip%>'></input> 
		<input type='hidden' name='stage_no' id='stage_no' value='<%=stage_no%>'></input> 
		<input type='hidden' name='op_visit' id='op_visit' value='<%=op_visit%>'></input>
		<input type='hidden' name='ip_disch' id='ip_disch' value='<%=ip_disch%>'></input>
		<input type='hidden' name='grace_period' id='grace_period' value='<%=grace_period%>'></input>
		<input type='hidden' name='max_level_for_op_yn' id='max_level_for_op_yn' value='<%=max_level_for_op_yn%>'></input> 
		<input type='hidden' name='max_level_for_ip_yn' id='max_level_for_ip_yn' value='<%=max_level_for_ip_yn%>'></input> 
		<input type='hidden' name='max_level_for_input' id='max_level_for_input' value='<%=max_level_for_input%>'> 
		<input type='hidden' name='max_level_for_em_yn' id='max_level_for_em_yn' value='<%=max_level_for_em_yn%>'></input> 
		<input type='hidden' name='op_grace' id='op_grace' value='<%=op_grace%>'></input>
		<input type='hidden' name='ip_grace' id='ip_grace' value='<%=ip_grace%>'></input>
		<input type='hidden' name='create_file_yn' id='create_file_yn' value='<%=create_file_yn%>'></input> 
		<input type='hidden' name='reportname' id='reportname' value='<%=reportname%>'></input> 
		<input type='hidden' name='statusFlag' id='statusFlag' value='N'></input>
		<!--Added for ML-MMOH-SCF-1854-->
		<%if (call_function.equals("MR_REC_PAT_VAL")
						|| call_function.equals("REPRINT_PAT_VAL")
						|| call_function.equals("MR_INTERNAL_REPORTS_REPRINT")
						&& !reportname.equals("MR")) {%>
		<script>
			 document.getElementById("encType_img").style.visibility = 'visible';
			 //document.forms[0].all.encDate_img.style.visibility = 'visible';
		</script>
		<%} else if (call_function.equals("RECORD_DIAGNOSIS")
						|| call_function.equals("PROCEDURE_RECORDING")) {%>
		<script>
			document.getElementById("encType_img").style.visibility = 'visible';
		</script>
		<%}%>

		<%} catch (Exception e) {
				e.printStackTrace();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				ConnectionManager.returnConnection(con, request);
			}%>
	</form>
</body>

</html>
<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null")))
				? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null")))
				? defaultValue
				: inputString);
	}%>

