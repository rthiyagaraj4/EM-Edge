<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String title = request.getParameter("title");
if (title == null) title = "";
%>
<head><title><%=(title.equals("")) ? "ttNew Procedure":(title)%></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%
	Connection con				= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	boolean func_appl_yn		= true;

	String past_visit="", tabFrameSrc = "",detfisrtFrameSrc="",detsecondFrameSrc="",detthirdFrameSrc="";
	String facility_id = (String) session.getValue("facility_id");
	String P_pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String P_patient_id = request.getParameter("patient_id");
	String P_encounter_id = request.getParameter("episode_id");
	String P_clinic_code = request.getParameter("location_code");
	//String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	//String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String query_string = request.getQueryString() == null? "" :request.getQueryString();
	//query_string = query_string + "&Encounter_Id="+P_encounter_id+"&Clinic_Code="+P_clinic_code+"&Patient_Id="+P_patient_id;
	query_string = query_string +"&Clinic_Code="+P_clinic_code;
	//String rows="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
  	    pstmt = con.prepareStatement("select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmt.setString(1,facility_id);		// facid
        pstmt.setString(2,"PROCEDURE");		// p_function
        pstmt.setString(3,P_encounter_id);  // p_episode_id
        pstmt.setString(4,P_pat_class);     // p_episode_type
        pstmt.setString(5,P_patient_id);

		rs = pstmt.executeQuery();
        while(rs!=null && rs.next())
        {
          past_visit = rs.getString(1);
        }
		
        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();

       if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE"))
       {
         func_appl_yn = false;
		 %>
		 <script>
	 		alert('APP-CA0052 You cannot access this function beyond the limit specified in IP/OP parameter');
		 </script>
		<%
       }
		if(rs!=null) rs.close();
		if(pstmt != null)pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Execption in main try"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181		
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}

	
	if(func_appl_yn)
	{
		tabFrameSrc			=	"../../eOR/jsp/NewProcedureTabs.jsp?"+query_string+"";
	//	detfisrtFrameSrc	=	"../../eOR/jsp/NewProcedureSearch.jsp?"+query_string+"";
	//	detsecondFrameSrc	=	"../../eOR/jsp/NewProcedureQueryResult.jsp?"+query_string+"";
	//	detthirdFrameSrc	=	"../../eOR/jsp/NewProcedureLegend.jsp"+query_string+"";
		
	}
	else
	{
		
		tabFrameSrc			=	"../../eCommon/html/blank.html";
		//detfisrtFrameSrc	=	"../../eCommon/html/blank.html";
		//detsecondFrameSrc	=	"../../eCommon/html/blank.html";
		//detthirdFrameSrc	=	"../../eCommon/html/blank.html";
		
	}
	%>
	<!-- <frameset rows="5%,95%" framespacing=0 frameborder="0">
 		<frame name="procMainTab" src= "../../eOR/jsp/NewProcedureTabs.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
		<frameset rows="17.5%,79%,3.5%,0%,0%,0%" framespacing=0 name="procDetailFrame" frameborder="0">
			<frame src="../../eOR/jsp/NewProcedureSearch.jsp?<%=request.getQueryString()%>" name="proc_main_search" scrolling='no' noresize>	

			<frame src="../../eOR/jsp/NewProcedureQueryResult.jsp?<%=request.getQueryString()%>" name="proc_main_result" scrolling='auto' frameborder="0" noresize> 

			<frame src= "../../eOR/jsp/NewProcedureLegend.jsp" framespacing="0"noresize frameborder="0"  name="proc_main_label" scrolling="auto">
			
			<frame src="../../eCommon/html/blank.html" name="proc_main_desc"  scrolling='auto' frameborder="0" noresize>

			<frame src="../../eCommon/html/blank.html" name="proc_main_butn"  scrolling='no' frameborder="0" noresize>

			<frame src="../../eCommon/html/blank.html" name="proc_temp_frame"  scrolling='no' frameborder="0" noresize>
		</frameset>
	</frameset> -->
	<!-- <frameset rows="5%,95%" framespacing=0 frameborder="0">
 		<frame name="procMainTab" src= "<%=tabFrameSrc%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
		<frameset rows="17.5%,79%,3.5%,0%,0%,0%" framespacing=0 name="procDetailFrame" frameborder="0">
			<frame src="<%=detfisrtFrameSrc%>" name="proc_main_search" scrolling='no' noresize>	

			<frame src="<%=detsecondFrameSrc%>" name="proc_main_result" scrolling='auto' frameborder="0" noresize> 

			<frame src= "<%=detthirdFrameSrc%>" framespacing="0"noresize frameborder="0"  name="proc_main_label" scrolling="auto">
			
			<frame src="../../eCommon/html/blank.html" name="proc_main_desc"  scrolling='auto' frameborder="0" noresize>

			<frame src="../../eCommon/html/blank.html" name="proc_main_butn"  scrolling='no' frameborder="0" noresize>

			<frame src="../../eCommon/html/blank.html" name="proc_temp_frame"  scrolling='no' frameborder="0" noresize>
		</frameset>
	</frameset> -->
	<frameset rows="5%,95%" framespacing=0 frameborder="0">
 		<frame name="procMainTab" src= "<%=tabFrameSrc%>" framespacing="0" noresize frameborder="0"  scrolling="no"></frame>
		<frameset rows="17.5%,79%,3.5%,0%,0%,0%" framespacing=0 name="procDetailFrame" frameborder="0">
			<frame src="../../eCommon/html/blank.html" name="proc_main_search" scrolling='no' noresize>	

			<!-- <frame src="../../eCommon/html/blank.html" name="proc_main_result" scrolling='auto' frameborder="0" noresize>  -->

			<frameset cols="100%,0%" framespacing=0 name="procTermFrame" frameborder="0">
				<frame src= "../../eCommon/html/blank.html" framespacing="0"noresize frameborder="0"  name="proc_main_result" scrolling="auto" noresize>
				
				<frame src="../../eCommon/html/blank.html" name="proc_term_info"  scrolling='no' frameborder="0" noresize>
			</frameset>

			<frameset cols="100%,0%" framespacing=0 name="procPractFrame" frameborder="0">
				<frame src= "../../eCommon/html/blank.html" framespacing="0"noresize frameborder="0"  name="proc_main_label" scrolling="auto" noresize>
				
				<frame src="../../eCommon/html/blank.html" name="proc_main_desc"  scrolling='no' frameborder="0" noresize>
			</frameset>
			<!-- <frame src="../../eCommon/html/blank.html" name="proc_main_desc"  scrolling='auto' frameborder="0" noresize> -->

			<frame src="../../eCommon/html/blank.html" name="proc_main_butn"  scrolling='no' frameborder="0" noresize>

			<frame src="../../eCommon/html/blank.html" name="proc_temp_frame"  scrolling='no' frameborder="0" noresize>
		</frameset>
	</frameset>
</form>
</html>
