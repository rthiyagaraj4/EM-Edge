<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatientGI.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
</head>
<body onLoad="disableHome();" onMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
<center>
<form name='AEMPSearchCriteriaForm' id='AEMPSearchCriteriaForm'>
<%

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	StringBuffer query_operator_station	= new StringBuffer();	
	String facility_id				=	"";
	String	login_user_id			=	"",		clinic_type				=	"";
	String	oper_stn_id				=	"";
	String	clinic_code				=	"",		clinic_desc				=	"";
	StringBuffer query_location  = new StringBuffer();		
	String open_to_all_pract_yn	 =	"";
	String	queue_refresh_interval	=	"";

	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	practitioner_name		=	"";
	StringBuffer	query_treatment_area	=new StringBuffer();
	String	treatment_area_gender	=	"",		selected_prop			=	"";
	String  checkout_yn				=	"";
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	first_clinic_code				=	"";		
	String	first_open_to_all_pract_yn		=	"";
	String where_condition					=	"";
	String pid_length						=	"";
	String called_from_ca					=	"";
	String locale							=	"";
	String p_cutoff_hours_prv_day_visit     =	"";
	int		rowIndex				=	1;
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	Boolean isAppearAsTabEnable  =false; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		locale= (String)session.getAttribute("LOCALE");

		con				=	(Connection)	ConnectionManager.getConnection(request);
		
		isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023

		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
        oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");
		called_from_ca	=	(request.getParameter("called_from_ca")==null)? "" : request.getParameter("called_from_ca");
	
		if(called_from_ca .equals("Y")) 
		{
				String sql= "select a.func_role_id, AM_GET_DESC.AM_PRACTITIONER(b.practitioner_id,'"+locale+"','2') practitioner_name, b.pract_type,(select TAB_MENU_YN from ca_encntr_param) TAB_MENU_YN from sm_appl_user a, am_practitioner b where a.func_role_id=b.practitioner_id and a.appl_user_id =? and a.func_role ='P'";
			
				String func_role_id="",pract_type="";

				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,login_user_id);
				rs=pstmt.executeQuery();
				if(rs !=null && rs.next()){
					func_role_id=rs.getString(1);

					if(func_role_id == null) func_role_id="";
					practitioner_name=rs.getString(2);
					if(practitioner_name == null) practitioner_name="";

					pract_type = rs.getString(3);
					if(pract_type == null) pract_type="";

					session.putValue("ca_practitioner_id",func_role_id);
					session.putValue("practitioner_name",practitioner_name);
					session.putValue("practitioner_type",pract_type);

					String resp_name="";

					if(rs!=null){
						if(rs.next())
							resp_name = rs.getString(1);
						
						session.putValue("resp_name",resp_name);
					}
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
		}

	/*	Monday, May 17, 2010 Venkats PE_EXE 
	sqlstr			=	"select patient_id_length from mp_param where module_id='MP' ";
		stmt			=	con.createStatement();
		rs				=	stmt.executeQuery(sqlstr);
	    if(rs	 != null)
		if(rs.next())
			pid_length	=	rs.getString(1);
        if(pid_length==null || pid_length.equals(""))
			pid_length	= "20";
		*/
		pid_length	=	(request.getParameter("pid_length")==null)? "20" : request.getParameter("pid_length");
		session.removeAttribute("AEUSER");
		queue_refresh_interval	=	(request.getParameter("queue_refresh_interval")==null)? "300" : request.getParameter("queue_refresh_interval");
		p_cutoff_hours_prv_day_visit=	(request.getParameter("p_cutoff_hours_prv_day_visit")==null)? "" : request.getParameter("p_cutoff_hours_prv_day_visit");
		checkout_yn	=	request.getParameter("checkout_yn") ;
		where_condition=(checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ";
		//if(stmt!=null)stmt.close();
		//if(rs!=null)rs.close();
	%>
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>
       	<tr><td colspan=4 class=label height=5></td></tr>
	<tr>
	
 <input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<td class='LABEL' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><select name='clinic_code' id='clinic_code' onChange="clear_chk_select1();popTreatmentCode(this,'','');" >
			<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
		<%
		
				query_location.append("select a.CLINIC_CODE, a.long_desc clinic_desc,  a.CLINIC_TYPE, OPEN_TO_ALL_PRACT_YN,a.SPECIALITY_CODE  from OP_CLINIC_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b where 	 language_id='"+locale+"' and decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y'   and a.facility_id = ? and a.clinic_type in  (select locn_type  from am_care_locn_type where care_locn_type_ind='C')   and a.level_of_care_ind = 'E'   and a.eff_status = 'E'  and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = ? and Oper_stn_id = ? and  appl_user_id = ? ");
				query_location.append(" ");
				query_location.append(where_condition);
				query_location.append(")  order by 2 ");
				pstmt		=	con.prepareStatement(query_location.toString());
				pstmt.setString	(	1,	facility_id		);
				pstmt.setString	(	2,	facility_id		);
				pstmt.setString	(	3,	oper_stn_id		);
				pstmt.setString	(	4,	login_user_id	);
				

				rs			=	pstmt.executeQuery();
				String spec_code="";
				while(rs.next()) 
				{
					clinic_code				=	rs.getString("clinic_code");
					clinic_desc				=	rs.getString("clinic_desc");
					clinic_type				=	rs.getString("clinic_type");
					open_to_all_pract_yn	=	rs.getString("open_to_all_pract_yn");
					spec_code=rs.getString("speciality_code");
					if(rowIndex==1) 
					{
						first_clinic_code			=	clinic_code;
						first_open_to_all_pract_yn	=	open_to_all_pract_yn;
						//selected_prop				=	" SELECTED ";
					}
					else
					{
						//selected_prop	=	"";
					}
		%>
				<option value='<%=clinic_code%>' <%=selected_prop%>><%=clinic_desc%></option>
				<script>parent.AEMPSearchCriteriaFrame.openToAllPractionerYN[<%=rowIndex%>]='<%=open_to_all_pract_yn%>';
				parent.AEMPSearchCriteriaFrame.clinicType[<%=rowIndex%>]='<%=clinic_type%>';
				parent.AEMPSearchCriteriaFrame.specialtyForClinc[<%=rowIndex%>]='<%=spec_code%>';
				</script> 
		<%			
					rowIndex++;
				}
		
				if(rs!=null)rs.close();
				if(pstmt!=null)	pstmt.close();

		%>
			</select></td>
			
			<td class='LABEL' width='25%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
				<select name='treatment_area_code' id='treatment_area_code' onChange='checkTreatmentGender()'>
				<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		<%
		
				rowIndex				=	1;
				clinic_code				=	first_clinic_code;
	            
				query_treatment_area.append(" select treatment_area_code, short_desc treatment_area_desc,  gender treatment_area_gender, open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw   where language_id='"+locale+"' and facility_id = ? and CLINIC_CODE = ? and  eff_status = 'E' order by 2 ");

				pstmt		=	con.prepareStatement(query_treatment_area.toString());

				pstmt.setString	(	1,	facility_id		);
				pstmt.setString	(	2,	clinic_code		);

				rs			=	pstmt.executeQuery();

				while(rs.next())
				{
					treatment_area_code				=	rs.getString("treatment_area_code");
					treatment_area_desc				=	rs.getString("treatment_area_desc");
					treatment_area_gender			=	rs.getString("treatment_area_gender");
					open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");

					if(treatment_area_gender==null)				treatment_area_gender			=	"";
					if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
					//<!-- parent.f_query_add_mod.AEMPSearchCriteriaFrame.-- >
				%>
					<!-- <option value='<%=treatment_area_code%>'><%=treatment_area_desc%></option>
					<script language='javascript'> -->
					<script>
					self.treatmentGender[<%=rowIndex%>] = '<%=treatment_area_gender%>';
				 	self.openToAllPractForClnYN[<%=rowIndex%>] = '<%=open_to_all_prac_for_clinic_yn %>'; 
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%
					rowIndex++;
				} // end of while
		
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		
			%>
			</select></td>
      </tr>
      <tr>
			<td class='LABEL'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name="patient_id" id="patient_id" value="" size='20'  maxlength="<%=pid_length%>" onKeyPress="return(CheckForSpecChars(event))" onBlur="ChangeToUpper(this)"><input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'callPatientSearch()'></td>
			<td class='LABEL'  width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type=text name=practitioner_desc size=30 maxlength=30 onBlur="beforeGetPractitioner2(practitioner_id,practitioner_desc);" ><input type=hidden name="practitioner_id" id="practitioner_id"  ><input type=button class=button value='?' name=Practitioner_lookup_button onClick="getPractitioner2(practitioner_id,practitioner_desc);">
		<% 
		
				clinic_code						=	first_clinic_code;
				open_to_all_pract_yn			=	first_open_to_all_pract_yn;
				open_to_all_prac_for_clinic_yn	=	"";
				treatment_area_code				=	"";
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

		%>
			</td>
	</tr>
    <tr>
			<td width="25%" class="LABEL" id='bayStatus_lab' ><fmt:message key="eAE.BedBayStatus.label" bundle="${ae_labels}"/></td>
			<td width="25%" class="fields" id='bayStatus_sel' ><select name="bed_status1" id="bed_status1" onchange="storeBedStatus(this);">
			<!-- <option value="" >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option> -->
			<option value="A" ><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></option>
			<option value="O" selected><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/></option>
			<option value="R"><fmt:message key="Common.Reserved.label" bundle="${common_labels}"/></option>
			<option value="B"   ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<td class="LABEL" >&nbsp;</td>
			<td class='BUTTON'  width="25%"><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>' name='refresh' onClick="callShowQueryResult('refresh')"></td>	
	</tr>	
	<tr><td colspan=4 class=label height=5></td></tr>
				
	    <input type="hidden" name="gender" id="gender">
		<input type="hidden" name="bed_status" id="bed_status" value='O'>
		<input type="hidden" name="priority" id="priority" value="">
	</table>
<%	
		session.removeAttribute("checkVal");

	query_operator_station.setLength(0);
    query_location.setLength(0);
    query_treatment_area.setLength(0); 
	
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
    <input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='called_from_ca' id='called_from_ca' value="<%=called_from_ca%>"> 
	<input type='hidden' name='queue_refresh_interval' id='queue_refresh_interval' value="<%=queue_refresh_interval%>">
	<input type='hidden' name='p_cutoff_hours_prv_day_visit' id='p_cutoff_hours_prv_day_visit' value="<%=p_cutoff_hours_prv_day_visit%>">
	<input type='hidden' name='patient_gender' id='patient_gender' value="">
	<input type='hidden' name='clinic_type' id='clinic_type' value="">
	<input type='hidden' name='checkout_yn' id='checkout_yn' value="<%=checkout_yn%>">
	<input type='hidden' name='first_open_to_all_pract_yn' id='first_open_to_all_pract_yn' value="<%=first_open_to_all_pract_yn%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='tabIndicator' id='tabIndicator' value='char_tab'>
	<input type='hidden' name='chk_Select1' id='chk_Select1' value=''>
	<input type='hidden' name='priority_zone' id='priority_zone' value="">
	<input type='hidden' name='orderCriteria' id='orderCriteria' value='queueDate'>
	<input type='hidden' name='orderCriteria_sensor' id='orderCriteria_sensor' value='queueDate'>
	<input type='hidden' name='asc_desc' id='asc_desc' value=' asc'>
	<input type='hidden' name='asc_desc_sensor' id='asc_desc_sensor' value=''>
	<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>
	<!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->
<!--	<input type='hidden' name='appear_as_tab_yn' id='appear_as_tab_yn' value='' >-->
	<input type='hidden' name='treatment_area_code1' id='treatment_area_code1' value='' > 
	<input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value="<%=isAppearAsTabEnable%>"> 
 
</form>
</center> 
<script>
showQueryResult();
</script>
</body>
</html>

