<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	//Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
	String resp_id     = (String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	String diag_code="";
	String diag_desc="";
    String fid = "";
	String fname = "";
	String free_text_applicable_yn = "";
	String pat_length = ""; // Added Against [IN:043072] By Saanthaakumar


%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js"></script>
		<script src='../js/MRReports.js' language='javascript'></script>
		<script src="../../eCommon/js/DateUtils.js"></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<script>
		function aaabbb(event){
			//var strCheck1 = '"+%?@#';
			var strCheck = '~`!@#$%^&*()-_=+{[}]|:;",./?\'<>';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode); // Get key value from key code
			if (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key
			else
				alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
			if( (event.keyCode >= 97) && (event.keyCode <= 122))
				return (event.keyCode);
			return false ;
		}
		</script>
<%

	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;

  Connection con =null;
  ResultSet rs   = null;
  Statement stmt = null;

  con =  ConnectionManager.getConnection(request);
  stmt	= con.createStatement();
     // Below modified Against [IN:043072] By Saanthaakumar
  	 rs	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD10','2','ICD9CM') SCHEME_DESC, DIAG_CODE_SCHEME,(select patient_id_length from mp_param)pat_length FROM MR_PARAMETER");
		
	if ((rs != null) && (rs.next()))
	{
		diag_code = rs.getString("DIAG_CODE_SCHEME");
		diag_desc = rs.getString("SCHEME_DESC");
		pat_length = rs.getString("pat_length"); // Added Against [IN:043072] By Saanthaakumar
	}
	if(rs != null) rs.close();


%>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="related_diagnosis" id="related_diagnosis" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='75%' cellpadding="3" cellspacing="0"  align='center'>

	<tr>
		<td class='label' width="30%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><select name='p_all_facility_id' id='p_all_facility_id'>

		<%
			String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");
			
			String facility_query = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+resp_id+"') order by 2";
			rs	= stmt.executeQuery(facility_query);
		
			while ((rs != null) && (rs.next()))
			{
					fid=rs.getString("facility_id");
					fname=rs.getString("facility_name");
					if(fid.equals(facility_id))
					out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
					else
					out.println("<option value='"+fid+ "' >"+fname+"</option>");
			}
			if(rs != null) rs.close();

		%>
				</select></td>
	</tr>
	<tr>
		<td class='label' width="30%"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><select name='P_Patient_Class' id='P_Patient_Class'>
				<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
				<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
				<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
				<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
				</select></td>
	</tr>
	<!-- Pat Id Field Modified Against [IN:043072] By Saanthaakumar -->
    <tr>
		<td class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='p_patient_id' id='p_patient_id'  value="" size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='return CheckForSpecChars(event);'  ><input type='button' class='button' value='?' name='pat_id' id='pat_id' onClick="funPatient1();" >
		</td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><select name='P_Gender' id='P_Gender'>
				<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/>
				<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
		<td class='fields'>		
		<input type='text' name='P_From_Date' id='P_From_Date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_From(this);" maxLength='10'></input><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_From_Date');"/><img src='../../eCommon/images/mandatory.gif'>
		&nbsp;-&nbsp;
		<input type='text' name='P_To_Date' id='P_To_Date' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validatePeriod_To(this);" maxLength='10'></input><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_To_Date');"/><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
<tr>
			<td class=label><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select name="P_Term_Set_Id" id="P_Term_Set_Id" onchange = "enable_code()"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<%
					 
					String term_set_id   = "";
					String term_set_desc = "";
					String sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";

					rs = stmt.executeQuery(sql);
					/* Below condition modified by Venkatesh.S on 08/Oct/2013 against ML-BRU-SCF-1070 [IN:043980]*/
					if( rs != null)
					{
						while( rs.next())
						{
	        				term_set_id = rs.getString("term_set_id") ;
	        				term_set_desc=rs.getString("term_set_desc");
	        				
				%>
				
					<option value='<%= term_set_id %>'><%= term_set_desc %></option>
					
				<%
			  }
		  }
			%>

				</select><img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<td class=label ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='P_From_Term_Code' id='P_From_Term_Code' value="" size='15' maxlength='15' disabled><input type='button' class='button' value='?' name='diag_frmbutton' id='diag_frmbutton' onClick="call_Diagnosis(P_From_Term_Code,this);" disabled><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id = 'frm_diag_code'></img>
			&nbsp;-&nbsp;&nbsp;
			<!-- </td>
			<td class=label ><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
			<td class='fields'> -->
			<input type='text' name='P_To_Term_Code' id='P_To_Term_Code' value="" size='15' maxlength='15' disabled><input type='button' class='button' value='?' name='diag_tobutton' id='diag_tobutton' onClick="call_Diagnosis(P_To_Term_Code,this);" disabled><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id = 'to_diag_code'></img>
			</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="eMR.FreeText.label" bundle="${mr_labels}"/></td>
				<td class='fields'><select name='start_ends_contains' id='start_ends_contains' disabled><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select><input type='text' name='P_Free_Text' id='P_Free_Text'  value="" size='100' maxlength="100" onKeyPress="return aaabbb(event);" disabled></td>
			</tr>
			<tr>
				<td class=label><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
				<td class="querydata" width="35%"><select name='P_Group_By' id='P_Group_By'>
					<option value="P"><fmt:message key="Common.patient.label" bundle="${common_labels}"/>
					<option value="D"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
		</td>
	</tr>

	<input type='hidden' name='CurrentDate' id='CurrentDate' value = "<%=currentdate%>"></input>
	<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>"></input>
	<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>"></input>
    <input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">





</table>
</form>
</body>
</html>

