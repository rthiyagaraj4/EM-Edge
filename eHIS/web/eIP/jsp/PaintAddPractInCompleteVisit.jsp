<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String P_patient_id			= checkForNull(request.getParameter("Patient_Id"));
	String P_practitioner_id	= checkForNull(request.getParameter("Practitioner_Id"));
	String NursingUnitCode		= checkForNull(request.getParameter("nurs_unit_code"));
	String P_clinic_code		= checkForNull(request.getParameter("Clinic_Code"));
	String P_locn_type			= checkForNull(request.getParameter("Location_Type"));
	String P_Modval				= checkForNull(request.getParameter("Modval"));
	String P_practitioner_role	= checkForNull(request.getParameter("practitioner_role"));
	String P_role				= checkForNull(request.getParameter("role"));
	String P_Remarks			= checkForNull(request.getParameter("Remarks"));
	String P_specialtycode		= checkForNull(request.getParameter("specialtycode"));
	String P_shortdesc			= checkForNull(request.getParameter("shortdesc"));
	String IPval				= checkForNull(request.getParameter("IPval"));
	String P_encounter_id = "";
	String fromServlet			= checkForNull(request.getParameter("fromServlet"));
	if(IPval.equals("ip"))
		 P_encounter_id			= checkForNull(request.getParameter("EncounterId"));
	else
		 P_encounter_id			= checkForNull(request.getParameter("Encounter_Id"));
%>
</head>

<%
	if(IPval.equals("ip"))
	{               		
%>	<iframe name ='query' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO noresize scrolling='auto' src='../../eIP/jsp/PaintPractInCompleteResult.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&IPval=<%=IPval%>&NursingUnitCode=<%=NursingUnitCode%>'   style='height:40vh;width:99vw'></iframe>
	<iframe name ='add_modify' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO noresize scrolling='NO' src='../../eIP/jsp/addPractInCompleteVisit.jsp?&aclass=S&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&Modval=<%=P_Modval%>&practitioner_role=<%=P_practitioner_role%>&role=<%=P_role%>&Remarks=<%=P_Remarks%>&specialtycode=<%=P_specialtycode%>&shortdesc=<%=P_shortdesc%>&IPval=<%=IPval%>&fromServlet=<%=fromServlet%>&NursingUnitCode=<%=NursingUnitCode%>'  style='height:50vh;width:99vw'></iframe>
    <iframe name ='tools'  MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO  noresize scrolling='NO' src='../../eIP/jsp/PractInCompleteQueryTools.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&IPval=<%=IPval%>&NursingUnitCode=<%=NursingUnitCode%> ' style='height:8vh;width:99vw'></iframe>
  
<%
	}

	else
	{				
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;

		try{
			
			conn				=  ConnectionManager.getConnection(request);	
			StringBuffer sqlQuery= new StringBuffer();	
			stmt				=  conn.createStatement();
			sqlQuery.append("select pract_type from am_practitioner where practitioner_id = '"+P_practitioner_id+"' ");
			rs=stmt.executeQuery(sqlQuery.toString());

			if( rs != null )
			 {
			   while(rs.next())
			   {
				 String P_pract_type=rs.getString("pract_type");	

				 if ((P_pract_type.equals("MD"))||(P_pract_type.equals("SG"))||(P_pract_type.equals("PS"))||(P_pract_type.equals("DN")))
				  {

	%>		   <iframe name ='query' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO   src='../../eIP/jsp/PaintPractInCompleteResult.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&IPval=<%=IPval%>&NursingUnitCode=<%=NursingUnitCode%>'   style='height:12vh;width:100vw'></iframe>
			     <iframe name ='add_modify' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO src='../../eIP/jsp/addPractInCompleteVisit.jsp?&aclass=S&Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&Modval=<%=P_Modval%>&practitioner_role=<%=P_practitioner_role%>&role=<%=P_role%>&Remarks=<%=P_Remarks%>&specialtycode=<%=P_specialtycode%>&shortdesc=<%=P_shortdesc%>&IPval=<%=IPval%>&NursingUnitCode=<%=NursingUnitCode%>'  style='height:39%;width:100vw'></iframe>
			     <iframe name ='tools'  MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO src='../../eIP/jsp/PractInCompleteQueryTools.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&IPval=<%=IPval%>&NursingUnitCode=<%=NursingUnitCode%>'   style='height:11%;width:100vw'></iframe>
			   
	<%	      }
		      else
		      {            	%>
			<script>
			if("<%=IPval%>" !="ip")
			{
				self.location.href='/../../eCommon/html/blank.html';
				alert(getMessage("CONS_NOT_APPL",'IP'));
				parent.window.close();
			}

			</script>
	<%
		      }
		   }
		 }
		if (sqlQuery.length() > 0)
          	sqlQuery.delete(0, sqlQuery.length());
		}
		catch(Exception e)
		{out.println("Exception in tryCatch : "+ e.toString());}
		finally
		{
			try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			ConnectionManager.returnConnection(conn,request);
			}
			catch(Exception ee){out.println("Error while closing the connections:"+ee.toString());}
		}
	}
%>

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>

