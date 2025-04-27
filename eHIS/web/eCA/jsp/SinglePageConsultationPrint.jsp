<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.lang.*,java.util.Date,java.text.SimpleDateFormat,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
	String optionDesc = "";
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement pstmt  = null;
	con =  ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT nvl(USER_DEF_LONG_DESC,LONG_DESC) USER_DEF_LONG_DESC FROM CA_OPTION WHERE OPTION_ID=?");
	pstmt.setString(1,option_id);

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
		if("PRINT"==called_from)
		{
			window.print();
			window.close();
		}	
	}
	</script>
		<title><%=optionDesc%></title>
</head>
<body class='CONTENT' onload="printtext('<%=called_from%>')" onScroll=false>
<form>
<%
	try
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String practitioner_id	 = (String)session.getValue("ca_practitioner_id");
		Date currentDate = new Date();
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id_spc") == null ? "" : request.getParameter("encounter_id_spc");
		String widgetHeaderShade = request.getParameter("widgetHeaderShade") == null ? "" : request.getParameter("widgetHeaderShade");
		String reloadWidgetCount = request.getParameter("reloadWidgetCount") == null ? "" : request.getParameter("reloadWidgetCount");
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		
		String locale			= (String) p.getProperty("LOCALE");
		StringBuilder patient_detail = new StringBuilder();
		String attending_practitioner = "";
		String admitting_practitioner = "";
		String practitioner_name = "";
		String siteName	=	"";
		String facilityName = "";
		
		String print_date_time = "";
		String patient_name = "";
		String imageLogoHeader = "";
		int paramIndex = 0;
		
		
		pstmt = con.prepareStatement("SELECT SF.FACILITY_NAME FACILITY_NAME,SS.SITE_NAME SITE_NAEM FROM SM_FACILITY_PARAM_LANG_VW SF,SM_SITE_PARAM_LANG SS WHERE SF.SITE_ID = SS.SITE_ID AND SF.LANGUAGE_ID = SS.LANGUAGE_ID ANd SF.FACILITY_ID=? AND SF.LANGUAGE_ID=?");
		pstmt.setString(1,facilityId);
		pstmt.setString(2,locale);

		oRs = pstmt.executeQuery();
		while(oRs.next())
		{
			siteName	=  oRs.getString("SITE_NAEM") == null ? "" : oRs.getString("SITE_NAEM");
			facilityName = oRs.getString("FACILITY_NAME") == null ? "" : oRs.getString("FACILITY_NAME");
		}
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		
		patient_detail = patient_detail.append("SELECT AM_GET_DESC.AM_PRACTITIONER(?,?,1) practitioner_name,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(SELECT SHORT_NAME FROM am_practitioner WHERE practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM PR_ENCOUNTER a, MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND a.patient_id = ?");
		pstmt = con.prepareStatement(patient_detail.toString());
		pstmt.setString(++paramIndex,practitioner_id);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,encounter_id);
		pstmt.setString(++paramIndex,patient_id);
		oRs = pstmt.executeQuery();
		if (oRs.next())
		{
			attending_practitioner = oRs.getString("attending_practitioner");
			admitting_practitioner = oRs.getString("admitting_practitioner")==null?"":oRs.getString("admitting_practitioner");
			print_date_time = oRs.getString("print_date_time")==null?"":oRs.getString("print_date_time");
			patient_name = oRs.getString("PATIENT_NAME")==null?"":oRs.getString("PATIENT_NAME");
			practitioner_name = oRs.getString("practitioner_name")==null?"":oRs.getString("practitioner_name");
			
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
		if (con != null)
			ConnectionManager.returnConnection(con, request);
%>	
		<%if("Y".equals(imageLogoHeader)){
		%>
		<table width='100%' cellpadding=3 cellspacing=0 border='0'>
			<tr>
				<td>
					<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center >
						<tr>
							<td  align='center' id='headerImageID'>
								<img src='../../eCA/jsp/CADisplayImages.jsp' >
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width='100%' align='center'><h3><%=siteName%></h3></td>				
			</tr>
			<tr>
				<td width='100%'  align='center'><h4><%=facilityName%></h4></td>				
			</tr>
			<tr>
				<td align='center'><h4><%=optionDesc%></h4></td>
			</tr>
		</table>
		<%}else{%>
			<table width='100%' cellpadding=3 cellspacing=0 border='0'>
			<tr>
				<td width='20%'  align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>
				<td width='60%' align='center'><h3><%=siteName%></h3></td>
				<td width='20%' align='center'>&nbsp;</td>
			</tr>
			<tr>
				<td width='20%' align='center'>&nbsp;</td>
				<td width='60%' align='center'><h4><%=facilityName%></h4></td>
				<td width='20%' align='center'>&nbsp;</td>
			</tr>
			<tr>
				<td width='20%' align='center'>&nbsp;</td>
				<td width='60%' align='center'><h4><%=optionDesc%></h4></td>
				<td width='20%' align='center'>&nbsp;</td>
			</tr>
			</table>
		<%}%>
		
		<table cellpadding=0 cellspacing=0  width='100%'>
						<div 
							 width='100%' style='overflow:auto'>
		<jsp:include page="SinglePageConsultationHeader.jsp" ><jsp:param name="flush" value="true" />
			
			<jsp:param name ="patient_id" value= "<%=patient_id%>" />  
			<jsp:param name ="encounter_id" value= "<%=encounter_id%>" />  
			<jsp:param name ="patient_name" value= "<%=patient_name%>" />
		</jsp:include>
						</div>
		</table>
		
		<table cellpadding=0 cellspacing=0  width='100%'>
						<div 
							 width='100%' style='overflow:auto;'>
		<jsp:include page="SinglePageConsultation.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="patient_id" value= "<%=patient_id%>" />  
			<jsp:param name ="encounter_id_spc" value= "<%=encounter_id%>" />  
			<jsp:param name ="widgetHeaderShade" value= "<%=widgetHeaderShade%>" /> 
			<jsp:param name ="reloadWidgetCount" value= "<%=reloadWidgetCount%>" />			
		</jsp:include>
						</div>
		</table>
		
		<table cellpadding=0 cellspacing=0  width='100%'>
						<div 
							 width='100%' style='overflow:auto'>
		<jsp:include page="SinglePageConsultationFooter.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="practitioner_name" value= "<%=practitioner_name%>" />
			<jsp:param name ="print_date_time" value= "<%=print_date_time%>" />  
			
		</jsp:include>
						</div>
		</table>
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

