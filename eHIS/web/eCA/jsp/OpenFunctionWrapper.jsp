<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title><fmt:message key="eOR.OrderEntry.label" bundle="${or_labels}"/></title>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%@page import="java.sql.*, java.util.*,webbeans.eCommon.*,eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection  con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	String function_id = "OR";
	String fileName = "../../eOR/jsp/EnterOrder.jsp";
	String patient_id = checkForNull(request.getParameter("patient_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String from_service_yn = checkForNull(request.getParameter("from_service_yn"));
	String from_module = checkForNull(request.getParameter("from_module"));
	String invoke_function_id = checkForNull(request.getParameter("invoke_function_id"));
	if(invoke_function_id.equals("ORDER_ENTRY") ) function_id = "OP"; 
	
	
	fileName = "../../eOR/jsp/EnterOrder.jsp";
	

	if (patient_class.equals("") && from_module.equals("AE") )
		 patient_class = "EM";

	StringBuffer queryString = new StringBuffer();

	String episode_id = checkForNull(request.getParameter("encounter_id"));
	String facility_id = checkForNull((String)session.getValue("facility_id"));
	
	String login_user = checkForNull((String)session.getValue("login_user"));
	String practitioner_name = checkForNull((String)session.getValue("practitioner_name"));
	String ca_practitioner_id = checkForNull((String)session.getValue("ca_practitioner_id"));

	String query = "";
	
	if(!episode_id.equals("") && !patient_class.equals(""))
	{

		try
		{
			con = ConnectionManager.getConnection(request);

			if(!patient_id.equals("") && episode_id.equals(""))
			{
				query =  " select sex, get_age(date_of_birth) age, TO_CHAR(date_of_birth,'DD/MM/YYYY') date_of_birth  from mp_patient where patient_id=? ";
				stmt = con.prepareStatement(query);
				stmt.setString(1, patient_id);
				try
				{
					rs = stmt.executeQuery();
					if (rs.next())
					{
						queryString.append("Sex="+checkForNull(rs.getString("sex"))+"&Age="+checkForNull(rs.getString("age"))+"&Dob="+checkForNull(rs.getString("date_of_birth"))+"&patient_class="+patient_class+"&from_service_yn="+from_service_yn+"&function_id="+function_id);
					}
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			else
			{
				// Query modified from above one which is commented part
				query =  "SELECT A.PATIENT_ID PATIENT_ID, A.ENCOUNTER_ID ENCOUNTER_ID,A.ASSIGN_CARE_LOCN_CODE LOCN_CODE,A.ASSIGN_CARE_LOCN_TYPE LOCN_TYPE,A.ASSIGN_ROOM_NUM ROOM_NUM,A.ASSIGN_BED_NUM BED_NUM ,TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME ,DECODE(A.PATIENT_CLASS, 'IP',ADT_STATUS,'DC',ADT_STATUS, VISIT_STATUS) ADT_STATUS,B.SEX SEX,TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ? AND B.PATIENT_ID=A.PATIENT_ID ";

				stmt = con.prepareStatement(query);
				stmt.setString(1, facility_id);
				stmt.setString(2, episode_id);

				try
				{
					rs = stmt.executeQuery();
					if (rs.next())
					{
						queryString.append("patient_id="+checkForNull(rs.getString("PATIENT_ID"))+"&episode_id="+checkForNull(rs.getString("ENCOUNTER_ID"))+"&encounter_id="+checkForNull(rs.getString("ENCOUNTER_ID"))+"&location_code="+checkForNull(rs.getString("LOCN_CODE"))+"&location_type="+checkForNull(rs.getString("LOCN_TYPE"))+"&bed_num="+checkForNull(rs.getString("BED_NUM"))+"&room_num="+checkForNull(rs.getString("ROOM_NUM"))+"&discharge_date="+checkForNull(rs.getString("DISCHARGE_DATE_TIME"))+"&visit_adm_date="+checkForNull(rs.getString("VISIT_ADM_DATE_TIME"))+"&Sex="+checkForNull(rs.getString("SEX"))+"&Dob="+checkForNull(rs.getString("DATE_OF_BIRTH"))+"&episode_Status="+checkForNull(rs.getString("ADT_STATUS"))+"&patient_class="+patient_class+"&function_id="+function_id);
					}
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

			}
			
			if(practitioner_name==null || practitioner_name.equals(""))
			{
				query = "SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, login_user);

				rs = stmt.executeQuery();
				if (rs.next())
				{
					ca_practitioner_id = rs.getString("FUNC_ROLE_ID");
				}

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();

				query = "SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, ca_practitioner_id);

				rs = stmt.executeQuery();
				if (rs.next())
				{
					practitioner_name = rs.getString("PRACTITIONER_NAME");
				}

				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			session.setAttribute("ca_practitioner_id",ca_practitioner_id.toUpperCase()) ;
			session.setAttribute("practitioner_name",practitioner_name.toUpperCase()) ;
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	}
	else
	{
		out.println("<script>alert(getMessage('PAT_CLASS_ENC_ID_NOT_PASSED','OR'));");
		out.println("window.close();</script>");
	}
%>
	
	<frameset frameborder=0 framespacing=0 rows='7%,*,5%,0%' scrolling='auto' id="mainFrameSet">	
		<frame name='CommonToolbar' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facility_id%>&EncounterId=<%=episode_id%>' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING='no' noresize>
		<frameset frameborder=0 framespacing=0 cols="0%,*,0%" scrolling='auto' id='workArea'>
				<frame name='menuFrame' src='../../eCommon/html/blank.html' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='yes' BORDERCOLOR='red'>
				<frame name='workAreaFrame' src='<%=fileName%>?<%=queryString.toString()%>'   frameborder=1  marginheight=0 marginwidth=0 SCROLLING='no' BORDERCOLOR='green'>
				<frame name='lookupMenuFrame' src='../../eCommon/html/blank.html'   frameborder=1  marginheight=1 marginwidth=1 SCROLLING='auto' BORDERCOLOR='red'>
		</frameset>
        <frame name='messageFrame' src='../../eCommon/jsp/error.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' noresize> 
	</frameset>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>
<html>
