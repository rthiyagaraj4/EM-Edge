<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import = "webbeans.eCommon.*,java.util.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String facilityId		= (String)session.getValue("facility_id");	//Checkstyle 4.0 Beta 6
	//String loginUser		= (String)session.getValue("login_user");	//Checkstyle 4.0 Beta 6
	
	String patient_id		= request.getParameter("patient_id");
	String encounterid	= request.getParameter("encounter_id");
		if(encounterid == null)	encounterid = "";
	String Transaction_type	= request.getParameter("Transaction_type");
		if(Transaction_type == null)	Transaction_type = "";
	String Module			= request.getParameter("Module");
		if(Module == null)	Module = "";
	
%>	
<html>

	<iframe name='PLINE' id='PLINE' SRC='../../eCommon/html/blank.html' noresize  frameborder=no scrolling='no' style='height:0%;width:100vw'></iframe><iframe name='detail' id='detail' src="../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&Module=<%=Module%>&patient_id=<%=patient_id%>&Transaction_type=<%=Transaction_type%>" frameborder="0" nowrap noresize scrolling='auto' style='height:88%;width:100vw'></iframe><iframe name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no' style='height:0%;width:100vw'></iframe>
</html>
	

