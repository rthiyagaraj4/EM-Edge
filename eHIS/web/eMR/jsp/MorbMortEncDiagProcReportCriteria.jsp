<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
    Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmtt = null;
	ResultSet rst = null;

	String facility_id	= (String) session.getValue("facility_id");
    String resp_id		= (String) session.getValue("responsibility_id");
	String user_id		= (String) session.getValue("login_user");
	String locale		= (String)session.getAttribute("LOCALE");

	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
	String currentdate = dateFormat.format(new java.util.Date()) ;

	String p_module_id		= "MR";
	String report_id		= "";
	String sql				= "";
	String diag_term_set_id		= "";
	String diag_term_set_desc	= "";
	String proc_term_set_id		= "";
	String proc_term_set_desc	= "";
	
try 
{
	con = ConnectionManager.getConnection(request);
%>

<html>

<head>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src="../../eMR/js/MorbMortEncDiagProcReport.js"></script>

</head>

<body OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();" onKeyDown ='lockKey();'>

<form name="MorbMortEncDiagProcForm" id="MorbMortEncDiagProcForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<BR><BR><BR><BR>

<table border="0" width='80%' cellpadding="0" cellspacing="0" align='center'>

<th align='left' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

<tr>
	<td width="100%" class="Border" align='center'>

	<table width='80%' cellPadding="0" cellSpacing="0" align='center'>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<select name='p_patient_class' id='p_patient_class' onChange="getLocationType(this);">
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				pstmt = con.prepareStatement("SELECT patient_class, short_desc FROM am_patient_class_lang_vw WHERE patient_class in ('EM','DC','OP','IP') and language_id='"+locale+"' order by 1");

				rs = pstmt.executeQuery();

				if(rs != null){									
					while (rs.next()){%>
						<option value='<%=rs.getString("patient_class")%>'><%=rs.getString("short_desc")%></option>
					<%}
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>

			<td class="fields" width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<input type='text' id='from_speciality' name='from_speciality' id='from_speciality' maxLength='15' size='15' OnBlur="BeforesearchCodeDRG1(fromSpecialty,this)"><input type='button' name='fromSpecialty' id='fromSpecialty' value='?' class='button' onclick="searchCodeDRG(this,from_speciality)"><input type="hidden" name="p_fr_specialty_code" id="p_fr_specialty_code" id='p_fr_specialty_code'>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<select name='locationType' id='locationType' onChange='clearLocation(this);'>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				</select>
			</td>

			<td class="fields" width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<input type='text' size='15' maxlength='30' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="getValues();" class='button'><input type="hidden" name="p_location_code" id="p_location_code" value="">
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width="25%">&nbsp;</td>
			<td class="fields" width="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>							

		<tr>
			<td class="label" width='25%' nowrap><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>/<fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<input type=text id="p_from_dis_date" name='p_from_dis_date' id='p_from_dis_date' size="10" maxlength="10" align="center" onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateDischargeCheckoutFromDate(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_dis_date');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class="fields" width='25%'> 
				<input type=text id="p_to_dis_date" name='p_to_dis_date' id='p_to_dis_date' size="10" maxlength="10" align="center"  onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateDischargeCheckoutToDate(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_dis_date');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width="25%">&nbsp;</td>
			<td class="label" width="25%">&nbsp;</td>
			<td class="fields" width="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<select name='p_diag_set' id='p_diag_set' onChange='termCodeMand(this);'>	
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				sql = " select term_set_id, term_set_desc from mr_term_set where diag_spec_yn='Y' and eff_status='E' order by term_set_desc ";

				pstmtt = con.prepareStatement(sql);
				rst = pstmtt.executeQuery();

				if( rst != null ){
					while( rst.next()){
						diag_term_set_id = rst.getString("term_set_id") ;
						diag_term_set_desc = rst.getString("term_set_desc");
					%>
						<option value='<%= diag_term_set_id %>'><%= diag_term_set_desc %></option>
					<%}
				}

				if(pstmtt != null) pstmtt.close();
				if(rst != null) rst.close();
				%>
				</select>&nbsp;&nbsp;
			</td>

			<td class="fields" width='25%'>
				<input type=text  name='p_fr_term_code' id='p_fr_term_code' size="10" maxlength="20" align="center" disabled><input type='button' name='from_term_code' id='from_term_code' value='?' class='button' onclick='diagprocTermCodeLookup(this, p_fr_term_code)' disabled>
				<img src="../../eCommon/images/mandatory.gif" id='frm_term_mand' style="visibility:hidden"></img>
			</td>

			<td class="fields" width='25%'>
				<input type=text  name='p_to_term_code' id='p_to_term_code' size="10" maxlength="20" align="center" disabled><input type='button' name='to_term_code' id='to_term_code' value='?' class='button' onclick='diagprocTermCodeLookup(this, p_to_term_code)' disabled>
				<img src="../../eCommon/images/mandatory.gif" id='to_term_mand' style="visibility:hidden"></img>
			</td>

			<td class="label" width='25%'><fmt:message key="Common.main.label" bundle="${common_labels}"/>/<fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Condition.label" bundle="${common_labels}"/>:</td>
			<td class="fields" width='25%' nowrap>
				<select name='p_diag_class_type' id='p_diag_class_type'>
				<option value="PD"><fmt:message key="Common.main.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Condition.label" bundle="${common_labels}"/></option>
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Condition.label" bundle="${common_labels}"/>s</option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" id='main_all_mand' style="visibility:hidden"></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width="25%">&nbsp;</td>
			<td class="label" width="25%">&nbsp;</td>
			<td class="fields" width="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<select name='p_proc_set' id='p_proc_set' onChange='procCodeMand(this);'>	
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%
				sql = " select term_set_id, term_set_desc from mr_term_set where proc_spec_yn='Y' and eff_status='E' order by term_set_desc ";

				pstmtt = con.prepareStatement(sql);
				rst = pstmtt.executeQuery();

				if( rst != null ){
					while( rst.next()){
						proc_term_set_id = rst.getString("term_set_id") ;
						proc_term_set_desc = rst.getString("term_set_desc");
					%>
						<option value='<%= proc_term_set_id %>'><%= proc_term_set_desc %></option>
					<%}
				}

				if(pstmtt != null) pstmtt.close();
				if(rst != null) rst.close();
				%>
				</select>&nbsp;&nbsp;
			</td>

			<td class="fields" width='25%'>
				<input type=text  name='p_fr_proc_code' id='p_fr_proc_code' size="10" maxlength="20" align="center" disabled><input type='button' name='from_proc_code' id='from_proc_code' value='?' class='button' onclick='diagprocTermCodeLookup(this, p_fr_proc_code)' disabled>
				<img src="../../eCommon/images/mandatory.gif" id='frm_proc_mand' style="visibility:hidden"></img>
			</td>

			<td class="fields" width='25%'>
				<input type=text  name='p_to_proc_code' id='p_to_proc_code' size="10" maxlength="20" align="center" disabled><input type='button' name='to_proc_code' id='to_proc_code' value='?' class='button' onclick='diagprocTermCodeLookup(this, p_to_proc_code)' disabled>
				<img src="../../eCommon/images/mandatory.gif" id='to_proc_mand' style="visibility:hidden"></img>
			</td>
		</tr>
		
		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="eMR.Mortality.label" bundle="${mr_labels}"/>/<fmt:message key="eMR.Morbidity.label" bundle="${mr_labels}"/></td>
			<td class="fields" width='25%'>
				<select name='p_morb_mort' id='p_morb_mort'>
				<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<option value="Y"><fmt:message key="eMR.Mortality.label" bundle="${mr_labels}"/></option>
				<option value="N"><fmt:message key="eMR.Morbidity.label" bundle="${mr_labels}"/></option>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

	</table>
	
	</td>

</tr>

</table>

<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=report_id%>">
<input type="hidden" name="p_user_id" id="p_user_id"		value="<%=user_id%>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
<input type="hidden" name="p_current_date" id="p_current_date"	value="<%=currentdate%>">

</form>
</body> 
</html>

<%
}catch(Exception e){  
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

