<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title>Procedures</title>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con				= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	boolean func_appl_yn		= true;

	String past_visit="", firstFrameSrc	="", secondFrameSrc	= "", thirdFrameSrc="";
	String facility_id = (String) session.getValue("facility_id");
	String P_pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String P_patient_id = request.getParameter("patient_id");
	String P_encounter_id = request.getParameter("episode_id");
	String P_clinic_code = request.getParameter("location_code");
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String query_string = request.getQueryString() == null? "" :request.getQueryString();
	query_string = query_string + "&Encounter_Id="+P_encounter_id+"&Clinic_Code="+P_clinic_code+"&Patient_Id="+P_patient_id;
	query_string = query_string + "&p_called_from_widget="+p_called_from_widget ; 	//CHL-CRF [IN035950]
	
	String rows="";
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
			alert(getMessage("CA_DIAG_PROCEDURE","CA"));
			window.close();
		 </script>
		<%
       }
		if(rs!=null) rs.close();
		if(pstmt != null)pstmt.close();
	}
	catch(Exception e)
	{
	//	out.println("Execption in main try"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181

	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	if(func_appl_yn)
	{
		firstFrameSrc	=	"ProcQueryResult.jsp?"+query_string+"";
		secondFrameSrc	=	"AddModifyOPProc.jsp?"+query_string+"";
		thirdFrameSrc	=	"PatProcQueryTools.jsp?"+query_string+"";
	}
	else
	{
		firstFrameSrc	=	"../../eCommon/html/blank.html";
		secondFrameSrc	=	"../../eCommon/html/blank.html";
		thirdFrameSrc=	"../../eCommon/html/blank.html";
	}
	
	if(modal_yn.equals("Y"))
	{
		if(mode.equals("OR"))
		{
			rows="9%,*,8%,0%,6%";
		}
		else
		{
			rows="10%,20%,*,6%,0%,6%";
		}
	}else if(!p_called_from_widget.equals("")){  	//CHL-CRF [IN035950]
		rows="20%,66%,6%,0%,8%";					//CHL-CRF [IN035950]
	}else
	{
		rows="20%,70%,8%,0%";
	}
%>
 <frameset rows='<%=rows%>'>
	
	<%if(modal_yn.equals("Y")){%>
		<frame name='frame0' id='frame0' 	src='../../eCommon/jsp/pline.jsp?EncounterId=<%=P_encounter_id%>' frameborder=0 >
	<%}%>
	<%if(!mode.equals("OR")){%>
		<frame name='frame1' id='frame1' 	src='<%=firstFrameSrc%>' frameborder=0 >
	<%}%>
	<frame name='frame2' id='frame2' 	src='<%=secondFrameSrc%>' frameborder=0 noresize scrolling='yes' >
	<frame name='frame3' id='frame3' 	src='<%=thirdFrameSrc%>' frameborder=0 noresize scrolling='no' >
	<frame name='blankFrameIntermediate' id='blankFrameIntermediate' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' >
	
<%	
	//if(modal_yn.equals("Y")){												//CHL-CRF [IN035950]
	if(modal_yn.equals("Y")|| !p_called_from_widget.equals("")){			//CHL-CRF [IN035950]
	%>
		<frame name='messageFrame' id='messageFrame' 	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='yes' >
	<%}%>
</frameset>
</html>

