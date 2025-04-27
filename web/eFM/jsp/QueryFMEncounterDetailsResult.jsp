<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import="java.sql.*,java.text.*,java.util.*,java.io.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/QueryFMEncounterDetails.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</HEAD>
		<BODY OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
		<SCRIPT>
			if(parent.frames[1].document.getElementById("tab").style.visibility = 'hidden')
				parent.frames[1].document.getElementById("tab").style.visibility = 'visible';
		</SCRIPT>
		<FORM name='QFMEDResultForm' id='QFMEDResultForm'>
			<TABLE border='1' cellpadding='0' cellspacing='0' width='100%'>
		<%
			Connection conn  = null;
			Statement stmt   = null;			
			ResultSet rst    = null;			

			String p_file_type_code			= "";
			String p_encounter_id			= "";
			
			String encounter_id				= "";
			String patline					= "";	
			String patient_id				= "";	
			String encounter_date_time		= "";	
			String volume_no				= "";	
		//	String attend_practitioner_id	= "";	
		//	String assign_care_locn_type	= "";	
		//	String assign_care_locn_code	= "";	
			String practitioner_name		= "";	
			String spacility_code_desc		= "";	
			String file_type_desc			= "";	
			String location					= "";	

			String mysql					= "";			
			String queryCriteria			= "";
			String class_value				= "QRYEVEN";

			int recordCount	= 0;
			int ind			= 0;
		
			try
			{
				String facility_id= (String) session.getValue("facility_id");

				conn = ConnectionManager.getConnection(request);
				stmt = conn.createStatement();				

				p_file_type_code = request.getParameter("file_type");
				p_encounter_id = request.getParameter("encounter_id");
				if(p_file_type_code == null || p_file_type_code.equals("null"))
					p_file_type_code = "";
				if(p_encounter_id == null || p_encounter_id.equals("null"))
					p_encounter_id = "";

				if(!p_file_type_code.equals(""))
					queryCriteria = "AND a.file_type_code = '"+p_file_type_code+"' ORDER BY a.encounter_id";
				if(!p_encounter_id.equals(""))
					queryCriteria = "AND a.encounter_id = '"+p_encounter_id+"' ";

				mysql = "SELECT a.patient_id,get_patient_line (a.patient_id,'"+localeName+"') patline, a.encounter_id,TO_CHAR (a.encounter_date_time, 'dd/hh/rrrr hh24:mi') encounter_date_time,a.volume_no,b.attend_practitioner_id, b.assign_care_locn_type,b.assign_care_locn_code,Decode(b.PATIENT_CLASS, 'IP', (select long_desc from ip_nursing_unit where facility_id = b.facility_id and nursing_unit_code = b.assign_care_locn_code), (select long_desc from Op_Clinic where facility_id = b.facility_id and clinic_code = b.assign_care_locn_code)) location,c.practitioner_name, d.short_desc spacility_code_desc,e.short_desc file_type_desc FROM fm_encounter_volume_link a, pr_encounter b, am_practitioner c, am_speciality d, mr_file_type e WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND b.attend_practitioner_id=c.practitioner_id(+) AND b.specialty_code = d.speciality_code(+) AND a.facility_id = e.facility_id AND a.file_type_code = e.file_type_code AND a.facility_id = '"+facility_id+"' "+queryCriteria+" ";
				
				rst = stmt.executeQuery(mysql);
				while(rst != null && rst.next())
				{
					patline					= checkForNull(rst.getString("patline"));
					patient_id				= checkForNull(rst.getString("patient_id"));
					encounter_id			= checkForNull(rst.getString("encounter_id"));
					encounter_date_time		= checkForNull(rst.getString("encounter_date_time"));	
					volume_no				= checkForNull(rst.getString("volume_no"));	
				//	attend_practitioner_id	= checkForNull(rst.getString("attend_practitioner_id"));	
				//	assign_care_locn_type	= checkForNull(rst.getString("assign_care_locn_type"));	
				//	assign_care_locn_code	= checkForNull(rst.getString("assign_care_locn_code"));	
					practitioner_name		= checkForNull(rst.getString("practitioner_name"));	
					spacility_code_desc		= checkForNull(rst.getString("practitioner_name"));
					file_type_desc			= checkForNull(rst.getString("file_type_desc"));
										
					location = checkForNull(rst.getString("location"));
					
					ind = patline.lastIndexOf(',');
					patline = patline.substring(0,ind);

					if(class_value.equals("QRYEVEN"))
						class_value = "QRYODD";
					else
						class_value = "QRYEVEN";
%>
					<TR>
						<TD class='<%=class_value%>' width='29%'><FONT 
						size=1><B><%=patient_id%></B><BR><%=patline%></FONT></TD>
						<TD class='<%=class_value%>' width='12%'><FONT size=1><%if(!p_encounter_id.equals("")){%><%=file_type_desc%><%}else if(!p_file_type_code.equals("")){%><%=encounter_id%><%}%></FONT></TD>
						<TD class='<%=class_value%>' width='15%'><FONT size=1><%=encounter_date_time%></FONT></TD>
						<TD class='<%=class_value%>' width='8%'><FONT 
						size=1><CENTER><%=volume_no%></CENTER></FONT></TD>
						<TD class='<%=class_value%>' width='12%'><FONT size=1><%=practitioner_name%></FONT></TD>
						<TD class='<%=class_value%>' width='12%'><FONT size=1><%=spacility_code_desc%></FONT></TD>
						<TD class='<%=class_value%>' width='12%'><FONT 
						size=1><%=location%></FONT></TD>
					</TR>				
<%
					recordCount++;
				}

%>				</TABLE>
				</FORM>
<%				
				if(recordCount == 0)
				{
%>
					<SCRIPT>
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
						parent.frames[1].location.reload();
						if(parent.frames[1].document.getElementById("tab").style.visibility == 'visible')
							parent.frames[1].document.getElementById("tab").style.visibility = 'hidden';
						parent.frames[2].location.href = "../../eCommon/html/blank.html";
						parent.frames[3].location.href = "../../eCommon/jsp/error.jsp?err_num=";

					</SCRIPT>
<%
				}
			if(rst   != null)  rst.close();			
			if(stmt  != null)  stmt.close();			
			}
			catch(Exception e)
			{
				out.println("Exception e"+e.toString());
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
		return( ((inputString == null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
%>

