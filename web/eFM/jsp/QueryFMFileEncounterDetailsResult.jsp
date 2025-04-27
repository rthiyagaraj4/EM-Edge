<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import='java.sql.*,java.text.*,java.util.*,webbeans.eCommon.*' contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	</HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileEncounterDetails.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<HEAD>
	<BODY OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
		<SCRIPT>
			//if(parent.QFMFEDSearchFrame.document.getElementById("tab").style.visibility == 'hidden') <!--Below commented by Mano Aganist SCF-0761 -->
				//parent.QFMFEDSearchFrame.document.getElementById("tab").style.visibility = 'visible'; <!--Below commented by Mano Aganist SCF-0761 -->
		</SCRIPT>
		<FORM name='QFMFEDResultForm' id='QFMFEDResultForm'>
			
<%
	Connection conn = null;
	Statement stmt  = null;
	Statement stmt1 = null;
	ResultSet rst   = null;
	ResultSet rst1  = null;

	try
	{
		conn	= ConnectionManager.getConnection(request);

		String facility_id		 = (String) session.getValue("facility_id");
		String patient_id		 = checkForNull(request.getParameter("patient_id"));
		String p_encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String encounterCriteria = "";

		if(!p_encounter_id.equals(""))
		{
			encounterCriteria = " AND a.encounter_id = '"+p_encounter_id+"' ";
		}
		if(!patient_id.equals(""))
		{
				webbeans.op.PatientData patdata = new webbeans.op.PatientData();
				patdata.setFacility_id(facility_id);
				String patient_status = patdata.CheckStatus(conn,patient_id);
				if(patient_status.equals("INVALID_PATIENT"))
				{
%>
					<SCRIPT>
						var msg = getMessage('INVALID_VALUE','Common'); 
						msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
						alert(msg);
						parent.frames[2].location.href = "../../eCommon/html/blank.html";
						parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
						parent.frames[1].document.forms[0].patient_id.select();
					</SCRIPT>
				<%
				}
				else
				{
					String file_type_appl_yn  = checkForNull(request.getParameter("file_type_appl_yn"));
					String class_value		     = "QRYEVEN";
					String mysql                 = "";					
					String encounter_type	     = ""; 
					String encounter_id		     = ""; 
					String encounter_date_time   = ""; 
					String practitioner_name     = ""; 
					String specialty		     = ""; 
					String volume_no		     = "";
					String file_no			     = "";
				//	String assign_care_locn_type = "";
				//	String assign_care_locn_code = "";
					String location				 = "";
					String file_type_desc	     = "";

					int recordCount = 0; // To count no of rows reterived from "mysql" query.
					
					stmt  = conn.createStatement();
					stmt1 = conn.createStatement();
					if(file_type_appl_yn.equals("N"))
					{
					//	mysql = "SELECT b.short_desc encounter_type, e.encounter_id,TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time,c.practitioner_name, d.short_desc specialty, 		a.assign_care_locn_type,a.assign_care_locn_code,Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, e.volume_no, e.file_no FROM pr_encounter a,am_patient_class b,am_practitioner c,am_speciality d,fm_encounter_volume_link e WHERE a.encounter_id = e.encounter_id(+) AND a.facility_id = e.facility_id AND a.attend_practitioner_id = c.practitioner_id(+) AND a.specialty_code = d.speciality_code AND a.patient_class = b.patient_class AND a.facility_id = '"+facility_id+"' "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"' ";
						mysql = "SELECT  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') encounter_type  , a.encounter_id  ,TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time  ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name  , AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') specialty  , a.assign_care_locn_type  ,a.assign_care_locn_code  ,Decode(a.assign_care_locn_type, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, a.assign_care_locn_code,'"+localeName+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, a.assign_care_locn_code, '"+localeName+"','1'))) location  , e.volume_no  , e.file_no  FROM  pr_encounter a  ,fm_encounter_volume_link e  WHERE a.encounter_id = e.encounter_id   AND a.facility_id = e.facility_id  AND a.facility_id = '"+facility_id+"' "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"'";
					}
					else if(file_type_appl_yn.equals("Y"))
					{
					//	mysql = "SELECT b.short_desc encounter_type, e.encounter_id,TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time,c.practitioner_name, d.short_desc specialty, 		a.assign_care_locn_type,a.assign_care_locn_code,Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, e.volume_no, e.file_no, f.short_desc file_type_desc FROM pr_encounter a,am_patient_class b,am_practitioner c,am_speciality d,fm_encounter_volume_link e,mr_file_type f WHERE a.encounter_id = e.encounter_id(+) AND a.facility_id = e.facility_id AND e.facility_id = f.facility_id(+) AND a.attend_practitioner_id = c.practitioner_id(+) AND a.specialty_code = d.speciality_code AND a.patient_class = b.patient_class AND e.file_type_code = f.file_type_code AND a.facility_id = '"+facility_id+"' "+encounterCriteria+" AND a.patient_id = '"+patient_id+"' ";
						mysql = "SELECT  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') encounter_type  , a.encounter_id  ,TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time  ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name  , AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') specialty  , a.assign_care_locn_type  ,a.assign_care_locn_code  ,Decode(a.assign_care_locn_type, 'N', (IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, a.assign_care_locn_code,'"+localeName+"','1')), (OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, a.assign_care_locn_code, '"+localeName+"','1'))) location  , e.volume_no  , e.file_no  ,MR_GET_DESC.MR_FILE_TYPE(E.FACILITY_ID, E.FILE_TYPE_CODE,'"+localeName+"','2') file_type_desc  FROM  pr_encounter a  ,fm_encounter_volume_link e WHERE a.encounter_id = e.encounter_id   AND a.facility_id = e.facility_id   AND a.facility_id = '"+facility_id+"'  "+encounterCriteria+"  AND a.patient_id = '"+patient_id+"' ";
					}
						rst  = stmt.executeQuery(mysql);
						
						System.out.println(" **************** Inside QueryFMFileEncounterResult 100 : mysql "+mysql);
					while(rst !=null && rst.next())
					{
						encounter_type		  = checkForNull(rst.getString("encounter_type"));
						encounter_id		  = checkForNull(rst.getString("encounter_id"));
						encounter_date_time   = checkForNull(rst.getString("encounter_date_time"));
						if(!encounter_date_time.equals("&nbsp;"))
						{
							encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM","en",localeName);
						}

						practitioner_name	  = checkForNull(rst.getString("practitioner_name"));
						specialty			  = checkForNull(rst.getString("specialty"));
						volume_no			  = checkForNull(rst.getString("volume_no"));
					//	assign_care_locn_type = checkForNull(rst.getString("assign_care_locn_type"));
					//	assign_care_locn_code = checkForNull(rst.getString("assign_care_locn_code"));
												
						location = checkForNull(rst.getString("location"));
						
						if(file_type_appl_yn.equals("N"))
						{
							file_no	= checkForNull(rst.getString("file_no"));
						}
						if(file_type_appl_yn.equals("Y"))
						{
							file_type_desc	= checkForNull(rst.getString("file_type_desc"));
						}
						if(class_value.equals("QRYEVEN"))
							class_value = "QRYODD";
						else
							class_value = "QRYEVEN";
					%>
					
					<!--below banner added by Mano aganist ML-MMOH-SCF-0761 -->
					<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%" >
	<tr>
		<td colspan='4'>
		<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Patient_ID" value="<%=patient_id%>"/>
		</jsp:include>
		</td>
	</tr>
</table>
<br>
<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' >
			
				<TR>
					<%if(file_type_appl_yn.equals("N")){%>
					<Th width="15%" class='columnheader'><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></Th>
					<%}else if(file_type_appl_yn.equals("Y")){%>
					<Th class='columnheader' width="15%"><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></Th>
					<%}%>
					<Th class='columnheader' width="8%"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></Th>
					<th class='columnheader' width="15%"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></Th>
					<Th class='columnheader' width="15%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></Th>
					<Th class='columnheader' width="12%"><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></Th>
					<Th class='columnheader' width="15%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></Th>
					<Th class='columnheader' width="10%">Specialty</Th>
					<Th class='columnheader' width="10%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></Th>
				</TR>
			<TABLE>

					
					
					<TABLE border='1' cellpadding='0' cellspacing='0' width='100%'>
					<!-- End of ML-MMOH-SCF-0761 by mano -->
						<TR>
							<%if(file_type_appl_yn.equals("N")){%>
							<TD class="<%=class_value%>" width='15%'><FONT size=1><%=file_no%></FONT></TD>	
							<%}else if(file_type_appl_yn.equals("Y")){%>
							<TD class="<%=class_value%>" width='15%'><FONT size=1><%=file_type_desc%></TD>
							<%}%>
							<TD class="<%=class_value%>" width='8%'><FONT size=1><CENTER><%=volume_no%></CENTER></FONT></TD>
							<TD class="<%=class_value%>" width='15%'><FONT size=1><%=encounter_type%></FONT></TD>
							<TD class="<%=class_value%>" width='15%'><FONT 
							size=1><%=encounter_id%></FONT></TD>
							<TD class="<%=class_value%>" width='12%'><FONT size=1><%=encounter_date_time%></FONT></TD>
							<TD class="<%=class_value%>" width='15%'><FONT size=1><%=practitioner_name%></FONT></TD>
							<TD class="<%=class_value%>" width='10%'><FONT 
							size=1><%=specialty%></FONT></TD>
							<TD class="<%=class_value%>" width='10%'><FONT 
							size=1><%=location%></FONT></TD>
						</TR>
					<%	
						recordCount++;
					}
					if(recordCount == 0)
					{
					%>
						<SCRIPT>
							alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
							parent.frames[1].location.reload();
							parent.frames[2].location.href = "../../eCommon/html/blank.html";
							parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
						</SCRIPT>
					<%
					}
					%>
					</TABLE>
				</FORM>
		<%
				}
			}
			if(rst   != null) rst.close();
			if(rst1  != null) rst1.close();
			if(stmt  != null) stmt.close();
			if(stmt1 != null) stmt1.close();
		}
		catch(Exception e)
		{
			out.println("Exception e :"+e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}
		%>
	</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

