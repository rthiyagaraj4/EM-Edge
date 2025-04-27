<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	13/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for marking the particular patient as arrived.
-->
    
	 <%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*" 
	 %>
	  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	 <html>
		 <head>
		
			<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
		 <% 	request.setCharacterEncoding("UTF-8");	
		 String Pageval = request.getParameter("Pageval");
		 String Patientid=request.getParameter("Patientid");
		 
		 String facility= (String) session.getValue( "facility_id" ) ;
		 
		 String userlocn=request.getParameter("user_locn");		 
		 String userlocntype=request.getParameter("userlocntype");

		 String encounterid=request.getParameter("encounter_id");		 
		 String encounterdttime=request.getParameter("enc_dt_time");
		 String pat_trn_time=request.getParameter("pat_trn_time");
		 String encountertype=request.getParameter("enc_type");
		 String locationtypedesc=request.getParameter("locationtypedesc");
		 if(locationtypedesc == null) locationtypedesc="";

		 String locationtype=request.getParameter("location_type");
		 if(locationtype == null) locationtype= "";
		 String locationcode=request.getParameter("location_code");
		 if(locationcode == null) locationcode="";
		 String locationcodedesc=request.getParameter("location_desc");
		 if(locationcodedesc == null) locationcodedesc="";
		locationcodedesc=java.net.URLDecoder.decode(locationcodedesc,"UTF-8");
		 
		 %>
		 <%if(Pageval.equals("A"))
		 {%>
		  <title><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/></title>
		  <%
		 }
		 else if(Pageval.equals("D"))
		 {%>
		  <title><fmt:message key="eOP.Departed.label" bundle="${op_labels}"/></title>
		 <%
		 }
		 %>
		   </head>
		 <iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling=no style='height:30vh;width:99vw'></iframe>
		 <%
		if(Pageval.equals("A"))
		{
		%>
		<iframe name='Arrived_main' id='Arrived_main' 	src='../../eOP/jsp/ArrivedMain.jsp?Patientid=<%=Patientid%>&location_type=<%=locationtype%>&locationtypedesc=<%=locationtypedesc%>&location_code=<%=locationcode%>&location_desc=<%=java.net.URLEncoder.encode(locationcodedesc)%>&user_locn=<%=userlocn%>&userlocntype=<%=userlocntype%>&encounter_id=<%=encounterid%>&enc_dt_time=<%=encounterdttime%>&pat_trn_time=<%=pat_trn_time%>&enc_type=<%=encountertype%>' frameborder=0 scrolling='no' style='height:60vh;width:100vw'></iframe> <!--Encoded 'locationcodedesc' by Thamizh selvi for ML-MMOH-SCF-0661 on 6th Mar 2017-->
			<%
		}
		else if(Pageval.equals("D"))
		{
			%>
			<iframe name='depart_main' id='depart_main' 	src='../../eOP/jsp/DepartedMain.jsp?Patientid=<%=Patientid%>&user_locn=<%=userlocn%>&userlocntype=<%=userlocntype%>&encounter_id=<%=encounterid%>&enc_dt_time=<%=encounterdttime%>&pat_trn_time=<%=pat_trn_time%>&enc_type=<%=encountertype%>' frameborder=0 scrolling='no'  style='height:62vh;width:99vw'></iframe>
			<%
		}
			%>

		<iframe name='dummyframe' id='dummyframe' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no'  style='height:0vh;width:99vw'></iframe>
	
   </html>


