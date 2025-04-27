<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<%

   request.setCharacterEncoding("UTF-8");
	String facilityId		= (String)session.getValue("facility_id");
	String patientId		= checkForNull(request.getParameter("patientId"));
	String encounter_id		= checkForNull(request.getParameter("encounterId"));
	String frfunction		= checkForNull(request.getParameter("p_fr_function"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String ENC_MODIFIED_YN	="N";
	String title			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CurrentEncounterDetails.label","ip_labels");
	if(frfunction.equals("IP"))
	title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.staydetails.label","common_labels");
%>
<%
		//String url="../../eCommon/jsp/commonToolbar.jsp?";
		//String params = request.getQueryString() ;
		//String source = url + params ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		Connection con					= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

	try{
	con = ConnectionManager.getConnection(request);
	String MODIFIED_YN_Qry		=	"Select ENC_MODIFIED_YN from ip_open_encounter where facility_id='"+facilityId+"' and encounter_id='"+encounter_id+"'";
	pstmt=con.prepareStatement(MODIFIED_YN_Qry);
	rs=pstmt.executeQuery();
	if(rs.next()&&rs!=null){
		ENC_MODIFIED_YN	=checkForNull(rs.getString("ENC_MODIFIED_YN"),"N");
	}else{
		ENC_MODIFIED_YN	="N";
	}
	}catch(Exception ex){
		
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con,request); 
	}

%>
<head>
<title><%=title%></title>
	
	<%
		if(ENC_MODIFIED_YN.equals("N")){ 
		%>
			
	<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:8.5vh;width:100vw'></iframe><iframe name='CurEnc' id='CurEnc' src='../jsp/MRCurrentEncounter2.jsp?LastDet=1&patientId=<%=patientId%>&encounterId=<%=encounter_id%>' noresize  frameborder=no scrolling=no style='height:25%;width:100vw'></iframe><iframe name='LastAdmissionRes' id='LastAdmissionRes'  src='../jsp/LastAdmissionResult2.jsp?function_id=<%=function_id%>&Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>' noresize  frameborder=no scrolling=auto style='height:50vh;width:100vw'></iframe>
	<%}else{%>
	<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:8.5vh;width:100vw'></iframe><iframe name='CurEnc' id='CurEnc' src='../jsp/MRCurrentEncounter2.jsp?LastDet=1&patientId=<%=patientId%>&encounterId=<%=encounter_id%>' noresize  frameborder=no scrolling=no style='height:25%;width:100vw'></iframe><iframe name='LastAdmissionRes' id='LastAdmissionRes'  src='../jsp/LastAdmissionResult2.jsp?function_id=<%=function_id%>&Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>' noresize  frameborder=no scrolling=auto style='height:35%;width:100vw'></iframe><iframe name='ChangeAdmisonDtlsFrame' id='ChangeAdmisonDtlsFrame'  src='../jsp/ChangedAdmissionResult2.jsp?encounter_id=<%=encounter_id%>&patientId=<%=patientId%>' noresize  frameborder=no scrolling=auto style='height:100vh;width:100vw'></iframe>
<%
		}
	 %>
</head>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>

