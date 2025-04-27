<!DOCTYPE html>
<%@ page import= "java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale = (String)session.getAttribute("LOCALE"); 
   	    String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	    String isCalledFromCA = checkForNull(request.getParameter("CA")); 
		String patient_id= request.getParameter("patient_id");	
		String encounter_id= request.getParameter("episode_id");	//out.println("encounter_id"+encounter_id);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
	%>
<html>
<head>
	<%
		String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<%
		String sql="select count(*) from mr_death_register_hdr where patient_id = '"+patient_id+"' and finalize_yn = 'N' ";
		int count =0;
		String patient_class = "";
		String encid = "";
		String sex = "";
		String practId = "";
		String pract_type = "";
		String specialty_code = "";
		String dob = "";
		String pat_curr_locn_code = "";
		try
			{
				con=ConnectionManager.getConnection(request);
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
		
				if(rs!=null)
				{
					rs.next();
					count=rs.getInt(1);
				}

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(count>0)
				{

					String sql2="select a.encounter_id, a.patient_id,decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex, a.attend_practitioner_id, a.patient_class, d.pract_type, a.specialty_code,  To_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, a.pat_curr_locn_code from PR_ENCOUNTER a, MP_PATIENT b, MR_DEATH_REGISTER_HDR c,  AM_PRACTITIONER d, AM_PRACT_TYPE e where b.patient_id  = a.patient_id  and a.encounter_id = c.encounter_id and a.facility_id = '"+p_facility_id+"' and a.facility_id =c.facility_id and d.practitioner_id = a.attend_practitioner_id and d.pract_type = e.pract_type and nvl(c.finalize_yn,'N')='N' and a.patient_id='"+patient_id+"'";
				
					pstmt=con.prepareStatement(sql2);
					rs=pstmt.executeQuery();
					while(rs.next())
					{
						encid = rs.getString("encounter_id");
						patient_class = rs.getString("patient_class");
						sex = rs.getString("sex");
						practId = rs.getString("attend_practitioner_id");
						pract_type = rs.getString("pract_type");
						specialty_code = rs.getString("specialty_code");
						dob = rs.getString("date_of_birth");
						pat_curr_locn_code = rs.getString("pat_curr_locn_code");
					}

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();


	%>

			<frameset rows='*'>
			<frame name='f_query_add_mod' id='f_query_add_mod' 				src="../../eMR/jsp/RecDiagnosis.jsp?CA=<%=isCalledFromCA%>&cause_of_death=Y&modal_yn=Y&Locn_Code=<%=pat_curr_locn_code%>&Sex=<%=sex%>&Dob=<%=dob%>&speciality_code=<%=specialty_code%>&patient_id=<%=patient_id%>&encounter_id=<%=encid%>&episode_id=<%=encid%>&practitioner_id=<%=practId%>&practitioner_type=<%=pract_type%>&patient_class=<%=patient_class%>&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I" frameborder=0 scrolling='no'> 

<!-- <frame name='f_query_add_mod' id='f_query_add_mod' 				src='../../eMR/jsp/PaintDeathRegisterPatient.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>' frameborder=0 scrolling='no'> 
 -->				<!-- <frame name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'>  -->
			</frameset>
<%
				}
				else
				{
					%>
						<script>
							alert(getMessage('DEATH_REG_NOT_APPL','CA'));
						</script>
					<%
				}
			}catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
					%>
				
				</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

