<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<HEAD>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
    <%
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		
		String tit=request.getParameter("title");
        if(tit==null)
            tit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
          
    %>
	<title><%=tit%></title>
	<%  
		
		String encounterid=request.getParameter("p3");
		String practitionerid = request.getParameter("p6");
        String locationcode = request.getParameter("p5");
        String patientid = request.getParameter("p2");
        String locationtype = request.getParameter("p4");
        String facility= (String) session.getValue( "facility_id" ) ;
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
       	String module_id = request.getParameter("module_id");
		String oper_id = request.getParameter("oper_id")==null?"":request.getParameter("oper_id");

		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");	
		String package_bl_install_YN = request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");
		String five_level_triage_appl_yn = request.getParameter("five_level_triage_appl_yn")==null?"N":request.getParameter("five_level_triage_appl_yn");
        /*Below line added for this CRF Bru-HIMS-CRF-133*/         	
		 String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		 String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");		 
		 
		 //End Bru-HIMS-CRF-133

		if(module_id==null) module_id="";
		 String height1="";
		 String height2="";
		 String height3="";
		 String height4="";
	try{
		
		 if(bl_install_yn.equals("Y")){
			    height1="11vh";
			    height2="86vh";
			    height3="0vh";
			    height4="0vh";
			 %> 
			 
				<!-- <FRAMESET ROWS='9%,88%,0%,0%' framespacing=0> -->  
				
		 <%} else {
				height1="11vh";
			    height2="86vh";
			    height3="0vh";
			    height4="0vh";
			 
			 %>	
				<!-- <FRAMESET ROWS='9%,88%,0%' framespacing=0> -->  
				
				
		<%}%>				
				<iframe NAME='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:<%=height1%>;width:99vw'></iframe>
				<iframe name='detail' src='../../eOP/jsp/PatCheckoutModel.jsp?function_id=<%=function_id%>&encounterid=<%=encounterid%>&practitionerid=<%=practitionerid%>&locationcode=<%=locationcode%>&patientid=<%=patientid%>&locationtype=<%=locationtype%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&<%=request.getQueryString()%>&oper_id=<%=oper_id%>&package_bl_install_YN=<%=package_bl_install_YN%>&isPatientEncMovement=<%=isPatientEncMovement%>&Sydate=<%=Sydate%>&five_level_triage_appl_yn=<%=five_level_triage_appl_yn%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:<%=height2%>;width:99vw'></iframe>
				<iframe name='Dummy_frame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no' style='height:<%=height3%>;width:99vw'></iframe>
				<iframe name='messageFrame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no' style='height:<%=height3%>;width:99vw'></iframe>
			<% if(bl_install_yn.equals("Y")) { %>
				 <iframe name='billingfr' src='../../eBL/jsp/BLSessionValuesReset.jsp' frameborder=0 noresize scrolling='no' style='height:<%=height4%>;width:99vw'></iframe>
			<% } %>
			<!-- </FRAMESET> -->
	<%
		
	}catch(Exception e){out.println("Errorr"+e);
			e.printStackTrace();					
	} 
	    
	%>

    </HEAD>
</html>
