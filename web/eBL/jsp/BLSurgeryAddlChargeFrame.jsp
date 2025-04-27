<!DOCTYPE html>
<%@ page import="eBL.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/Common.jsp" %>



<%
//	Connection con = null;	
	try
	{
			
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String params = request.getQueryString();
//		String title = request.getParameter("title");			
		//con	=	ConnectionManager.getConnection(request);

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	

		String for_pline = "Facility_Id="+facilityid+"&Patient_Id="+patient_id+"&EncounterId="+encounter_id+"&visit_id="+visit_id;

		//String function_id="rcpt_rfnd";	String strbilldoctypecode="";String strbilldocnum="";String strslmtidno="";	String strslmtpayername="";String strcashcountercode="";	String strblnggrpid="";				String strbillpayableamt="";

		String bean_id = "Bl_BLSurgeryAddlChargeBean" ;
		String bean_name = "eBL.BLSurgeryAddlChargeBean";

		BLSurgeryAddlChargeBean bean			= (BLSurgeryAddlChargeBean)getBeanObject( bean_id, bean_name, request ) ;
		String function_id="";
		function_id=request.getParameter("function_id");
		if(function_id == null) function_id="EDIT";		
	%>
		<script>
				
		</script>
<HTML>
<head>
			<%if (function_id.equals("VIEW"))
				{
			%><title><fmt:message key="eBL.VIEW_ADDL_CHARGE_DTL.label" bundle="${bl_labels}"/></title>
			<%}else{%>
			<title><fmt:message key="eBL.RECORD_ADDL_SUR_CHARGES.label" bundle="${bl_labels}"/></title>
			<%}%>
<!--	Surgery Aditional Charges-->

</head>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>	
		<script language="javascript" src="../../eBL/js/BLEnterServiceRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	


		  <iframe name='pat_banner_frame' id='pat_banner_frame' SRC="../../eCommon/jsp/pline.jsp?<%=for_pline%>" frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'> 	</iframe>	
		  <iframe name='search_frame' id='search_frame' src="../../eBL/jsp/BLSurgeryAddlChargeDtl.jsp?<%=params%>&bean_id=<%=bean_id%>&bean_name=<%=bean_name%>" frameborder=0 scrolling='yes' noresize style='height:83vh;width:100vw'></iframe>
		  <!-- <FRAME name='search_frame' id='search_frame' src="../../eBL/jsp/BLSurgeryAddlChargeBtn.jsp?<%=params%>" frameborder=0 scrolling='auto' noresize>	-->
		  <iframe SRC="../../eCommon/html/blank.html"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>	
		  <iframe SRC="../../eCommon/html/blank.html"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'>	</iframe>
    	  <iframe SRC="../../eBL/jsp/BLSurgeryAddlChargeLegend.jsp"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'>	</iframe>


<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception ee)
	{
		out.println("from main :"+ee);
	}
	/*finally
	{
		if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
	}*/
%>
</HTML>

