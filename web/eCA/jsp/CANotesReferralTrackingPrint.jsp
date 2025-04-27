<!DOCTYPE html>
<%
/*  							 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date	Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           							created

26/11/2014	IN050580		Nijitha 								MO-CRF-20080
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
---------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.lang.*,java.util.Date,java.text.SimpleDateFormat,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<TITLE>Clinical Notes Referral Tracking Print</TITLE>
<jsp:useBean id="beanObj"  scope="page"  class="eCA.CARefferralNotesBean"/>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	try
	{
	beanObj.setLocale(localeName);
	String login_user = (String)session.getValue("login_user");
	String pract = request.getParameter("practitioner");
	String practitioner_name  = request.getParameter("practitioner_name");
	String status = request.getParameter("status");
	String facility = request.getParameter("facility");
	String facility_From_Name = request.getParameter("facility_From_Name");
	String facility_To_Name = request.getParameter("facility_To_Name");
	String patientId = request.getParameter("patientId");
	if(patientId==null || "".equals(patientId))
		patientId="";
	String resp_id = (String)session.getValue("responsibility_id");
	String specialty_name = request.getParameter("specialty_name");
	String toSpecialty_name =request.getParameter("toSpecialty_name");  //IN052857
	String patientclassName = request.getParameter("patientclassName");  //IN052857
	String noteStatusName = request.getParameter("noteStatusName");  //IN052857
	String refferalStatusName = request.getParameter("refferalStatusName");  //IN052857
	String locationName = request.getParameter("locationName"); //IN052857
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String dispCriteriaFrom = request.getParameter("dispCriteriaFrom")==null?"":request.getParameter("dispCriteriaFrom");
	String dispCriteriaTo = request.getParameter("dispCriteriaTo")==null?"":request.getParameter("dispCriteriaTo");
	String repGeneratedFor = "";
	String print_date_time = "";
	beanObj.setPatient_id(patientId);
	beanObj.setClinician_id(pract);
	beanObj.setFacility_id(facility);
	beanObj.setSpeciality_code(request.getParameter("specialty_code"));
	beanObj.setPeriod_from(fromDate);
	beanObj.setPeriod_to(toDate);
	beanObj.setStatus(status);
	beanObj.setResp_id(resp_id);
	beanObj.setForwardToFacility(request.getParameter("forward_to_facility"));
	beanObj.setReferralStatus(request.getParameter("referral_status"));
	beanObj.setPatientClass(request.getParameter("patientclass"));
	beanObj.setToSpecialityCode(request.getParameter("to_specialty_code"));
	beanObj.setLocation_code(request.getParameter("locn_code"));
	if("Y".equals(dispCriteriaFrom) && "Y".equals(dispCriteriaTo))
	{
		repGeneratedFor = "Both";
	}
	else if ("Y".equals(dispCriteriaFrom) && "N".equals(dispCriteriaTo))
	{
		repGeneratedFor = "Referred From";
	}
	else if ("N".equals(dispCriteriaFrom) && "Y".equals(dispCriteriaTo))
	{
		repGeneratedFor = "Referred To";
	}
	
	String optionDesc = "";
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement pstmt  = null;
	con =  ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT nvl(USER_DEF_LONG_DESC,LONG_DESC) USER_DEF_LONG_DESC FROM CA_OPTION WHERE OPTION_ID=?");
	pstmt.setString(1,"CA_NOTES_REF_TRACKING");

	oRs = pstmt.executeQuery();
	while(oRs.next())
	{
		optionDesc	=  oRs.getString("USER_DEF_LONG_DESC") == null ? "" : oRs.getString("USER_DEF_LONG_DESC");
	}
	if(oRs!=null) oRs.close();
	if(pstmt!=null) pstmt.close();
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCA/js/SinglePageConsultation.js"
	language="javascript"></script>
	<script type="text/javascript" src="../../eCA/js/CANotesRefferalTracking.js"></script>
	<script Language="vbscript">
		Dim WSHShell
		Dim myHeader
		Dim myFooter
		Dim myMarginleft 
		Dim myMarginright 
		Set WSHShell = CreateObject("WScript.Shell")

		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function printtext(called_from)
	{
		window.print();
		//window.close();
		setTimeout(() => {         window.close();     }, 2000);
	}
	</script>
		<title><%=optionDesc%></title>
</head>
<body class='CONTENT' onload="printtext('<%=called_from%>')" onScroll=false>
<form>
<%
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
	
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale			= (String) p.getProperty("LOCALE");
		String facilityid = (String) session.getValue("facility_id");
		String siteName	=	"";
		String facilityName = "ALL";
		String patient_name = "";
		String imageLogoHeader = "";
		String LOGO_HDR_HEIGHT="40";//IN068669
		String LOGO_HDR_WIDTH="40";//IN068669
		int paramIndex = 0;
		
		
		pstmt = con.prepareStatement("SELECT SF.FACILITY_NAME FACILITY_NAME,SS.SITE_NAME SITE_NAEM,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time FROM SM_FACILITY_PARAM_LANG_VW SF,SM_SITE_PARAM_LANG SS WHERE SF.SITE_ID = SS.SITE_ID AND SF.LANGUAGE_ID = SS.LANGUAGE_ID ANd SF.FACILITY_ID=? AND SF.LANGUAGE_ID=?");
		pstmt.setString(1,facilityid);
		pstmt.setString(2,locale);

		oRs = pstmt.executeQuery();
		while(oRs.next())
		{
			siteName	=  oRs.getString("SITE_NAEM") == null ? "" : oRs.getString("SITE_NAEM");
			facilityName = oRs.getString("FACILITY_NAME") == null ? "ALL" : oRs.getString("FACILITY_NAME");
			print_date_time = oRs.getString("print_date_time") == null ? "" : oRs.getString("print_date_time");
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
	
		pstmt	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
		oRs = pstmt.executeQuery();
		if(oRs.next()){
			imageLogoHeader="Y";				
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		//IN068669 starts
		pstmt =	con.prepareStatement("select LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT FROM ca_note_param");
		oRs = pstmt.executeQuery();
		while(oRs.next())
		{
			LOGO_HDR_WIDTH	= oRs.getString("LOGO_HDR_WIDTH") == null ? "40" : oRs.getString("LOGO_HDR_WIDTH");
			LOGO_HDR_HEIGHT	= oRs.getString("LOGO_HDR_HEIGHT") == null ? "40" : oRs.getString("LOGO_HDR_HEIGHT");
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		//IN068669 ends
		if (con != null)
			ConnectionManager.returnConnection(con, request);
%>	
	<%if("Y".equals(imageLogoHeader)){%>
	<TABLE width='100%' cellpadding=0 cellspacing=0 border='0'>
		<TR>
			<TD width='100%'>
				<TABLE width='100%' style='height:100px;' border=0 cellpadding=0 cellspacing=0 align=center >
					<TR>
						<TD  class='HEADER'  align='center' id='headerImageID'>
							<img src='../../eCA/jsp/CADisplayImages.jsp' >
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD width='100%' align='center'><h3><%=siteName%></h3></TD>				
		</TR>
		<TR>
			<TD width='100%'  align='center'><h4><%=facilityName%></h4></TD>				
		</TR>
		<TR>
			<TD align='center'><h4><%=optionDesc%></h4></TD>
		</TR>
	</TABLE>
<%}else{%>
	<TABLE width='100%' cellpadding=3 cellspacing=0 border='0'>
		<TR>
			<!--<TD width='20%' rowspan='3' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></TD>-->
			<TD width='20%' rowspan='3' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='<%=LOGO_HDR_WIDTH%>' height='<%=LOGO_HDR_HEIGHT%>'></TD><!--IN068669-->
			<TD width='60%' align='center'><h3><%=siteName%></h3></TD>
			<TD width='20%' align='center'>&nbsp;</TD>
		</TR>
		<TR>
			
			<TD width='60%' align='center'><h4><%=facilityName%></h4></TD>
			<TD width='20%' align='center'>&nbsp;</TD>
		</TR>
		<TR>
			
			<TD width='60%' align='center'><h4><%=optionDesc%></h4></TD>
			<TD width='20%' align='center'>&nbsp;</TD>
		</TR>
		<TR>
			<TD width='100%' align='center' colspan='3'>&nbsp;</TD>
		</TR>
	</TABLE>
<%}%>
	<TABLE cellpadding=0 cellspacing=0 border='1' width='100%' style="font-family:Verdana;">
		<TR>
			<TD width='100%'>
				<TABLE  cellpadding=0 cellspacing=0  border='0' width='100%' style="font-family:Verdana;">
					<TR>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="eCA.reportgenerated.label" bundle="${ca_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%' ><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=repGeneratedFor%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(locationName)%></font></TD>						
					</TR>
					<TR>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(practitioner_name)%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=fromDate%></font>&nbsp;<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></font>&nbsp;<font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=toDate%></font></TD>
					</TR>
					<TR>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=patientId%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=patientclassName%></font></TD>
					</TR>
					<TR>
						
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="eOR.note.label" bundle="${or_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=noteStatusName%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=refferalStatusName%></font></TD>												
					</TR>
					<TR>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(specialty_name)%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(toSpecialty_name)%></font></TD>
					</TR>
					<TR>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp<fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(facility_From_Name)%></font></TD>
						<TD width='20%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp<fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></font></TD>
						<TD width='2%' valign='top'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">&nbsp;:</font></TD>
						<TD width='28%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=java.net.URLDecoder.decode(facility_To_Name)%></font></TD>
					</TR>					
				</TABLE>
			</TD>
		</TR>
	</TABLE>
	<TABLE><TR><TD height="5px">&nbsp;</TD></TR></TABLE>
	<%if("Y".equals(dispCriteriaFrom) && "Y".equals(dispCriteriaTo)){%>
		<TABLE cellpadding=1 cellspacing=0  width='100%' style="font-family:Verdana;FONT-SIZE:9pt;">
			<TR>
				<TD width='50%' valign='top'>
					<jsp:include page="CANotesReferralTracking.jsp" >
						<jsp:param name="flush" value="true" />		
						<jsp:param name ="called_from" value= "PRINT" />  
						<jsp:param name ="called_from_func" value= "REFERREDFROM" /> 
					</jsp:include>
				</TD>
				<TD width='50%' valign='top'style='padding-left:10px'>
					<jsp:include page="CANotesReferralTracking.jsp" >
						<jsp:param name="flush" value="true" />
						<jsp:param name ="called_from" value= "PRINT" /> 
						<jsp:param name ="called_from_func" value= "REFERREDTO" />									
					</jsp:include>
				</TD>
			</TR>
		</TABLE>
	<%}else if("Y".equals(dispCriteriaFrom) && "N".equals(dispCriteriaTo)){%>
		<TABLE cellpadding=0 cellspacing=0  width='100%'>
			<TR>
				<TD width='100%' valign='top'>
					<jsp:include page="CANotesReferralTracking.jsp" >
						<jsp:param name="flush" value="true" />		
						<jsp:param name ="called_from" value= "PRINT" /> 
						<jsp:param name ="called_from_func" value= "REFERREDFROM" />  
					</jsp:include>
				</TD>	
			</TR>	
		</TABLE>	
	<%} else if("N".equals(dispCriteriaFrom) && "Y".equals(dispCriteriaTo)){%>
		<TABLE cellpadding=0 cellspacing=0  width='100%'>
			<TR>
				<TD width='100%' valign='top'>
					<jsp:include page="CANotesReferralTracking.jsp" >
						<jsp:param name="flush" value="true" />
						<jsp:param name ="called_from" value= "PRINT" />  
						<jsp:param name ="called_from_func" value= "REFERREDTO" /> 
					</jsp:include>
				</TD>	
			</TR>	
		</TABLE>
	<%}%>
	<TABLE><TR><TD height="5px">&nbsp;</TD></TR></TABLE>
	<TABLE cellpadding=0 cellspacing=0 border='1' width='100%' style="font-family:Verdana;">
		<TR>
			<TD width='100%'>
				<TABLE cellpadding=0 cellspacing=0 border='0' width='100%' style="font-family:Verdana;">
					<TR>
						<TD  width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">Report Generating For :</font></TD>
						<TD  width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=practitioner_name%></font></TD>
						<TD  width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.PrintDateTime.label" bundle="${common_labels}"/> :</font></TD>
						<TD  width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=print_date_time%></font></TD>
					</TR>
					<TR>
						<TD width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;"><fmt:message key="Common.LoggedUser.label" bundle="${common_labels}"/> :</font></TD>
						<TD width='25%'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:normal;"><%=login_user%></font></TD>
						<TD width='50%' colspan='2'><font style="COLOR:NAVY;FONT-SIZE:9pt;font-weight:bold;">Signature :</font></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
	
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</form>
</body>
</html>

