<!--[if IE 6]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if IE 7]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if gte IE 7]>  
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<![endif]-->

<%@ page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>	
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	
		<style>
		u {    
		    border-bottom: 1px dotted #000;
		    text-decoration: none;
		}
		
		.tableTemp { table-layout:fixed; }
		
		td.thickBorder{ 
			border: solid #000 1px;
			word-break:break-all;
		}		
		
		@media screen {	
			div#footer_wrapper {       
				display: none;      
			}   
		}
		
		@media print { 	
			.tableTemp { page-break-before:auto;page-break-inside:auto; page-break-after:auto} 
			.breakMainTable { page-break-before:always}
			.breakMainTempTable { page-break-before:auto;page-break-inside:avoid; page-break-after:auto}
			.lastTable { page-break-before:auto;page-break-inside:auto; page-break-after:always}  
			.breakTable { page-break-before:auto;page-break-inside:auto; page-break-after:auto}  
			.breakTrNotes    { page-break-before:auto; page-break-inside:auto; page-break-after:auto}
			.breakTr    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}
			.breakTableLC { page-break-before:avoid;page-break-inside:avoid; page-break-after:auto}  
			.breakTrLC    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}
			.breakSignTable    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}
			
			/*
			tfoot { 
				visibility: hidden; 
			}  
			*/ 
			th {
				font-family:Arial;		
			}
			thead {
				display:table-header-group;
			}
			tbody {
				display:table-row-group;
			}
			tfoot {
				display:table-footer-group;		
				
			}	
			
			div#footer_wrapper {       
				display: none;      
			}  
			
			/*			
			div#footer_content {   
				overflow: hidden;
				zoom: 1;		
			}   
			
			div#footer_wrapper {    
				position: fixed;
				bottom: 0;     
				clear:both;
			}  
			  	
			*/
			div#print_wrapper {       
				display: none;      
			} 		
		
		}
		</style>
	</head>
	<%	
	StringBuffer htmlData = new StringBuffer();
	PatientContext oPatientContext = new PatientContext();
	oPatientContext.request = request;
	String xmlSql = "";
	String demoSql = "", bloodSql = "", encounterSql = "", complaintSql = "", vitalSql = "", encSummSql="", authSplSql="";
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	CallableStatement cstmt = null;

	String notesHtmlData = "";
	String strHtmlData = "";

	//Patient Demographic Information variables
	String patientNamePrefix = "", patientFirstName = "", patientSecondName = "", patientThirdName = "", patientFamilyName = "", gender = "", dateOfBirth = "", ageInYears = "";
	String patientName = "", bloodGroup = "";
	//Patient Encounter Information variables
	String facilityId = "", attendPractitionerId = "", visitDateTime = "", practitionerName = "";
	boolean encResFlag = false;
	//Facility Details
	String facilityName = "", addrLine1="", addrLine2="", addrLine3="", addrLine4="", postalCode="", countryName="";
	String telephone1="", telephone2="", telephone3="", telephone4="";
	String emailId="", website="", address="";
	
	//Summary Details
	String v_summ_code = "", v_summ_desc = "";
	
	//Authorised By Doctor Details
	String vAuthoriseById = "", vAuthoriseName = "", vAuthoriseBySplty = "", vAuthoriseDegree="";

	// Chart Type: 1 - Text, 2 - Table, 3 - Linear Gauge, 4 - Line Graph
	int chartType = 0;

	String pageSource = "";
	String gaugeID = "";

	int nCount = 0;
	int nListCount = 0;
	int nListSize = 0;
	int nDisCount = 0;
	
	int v_age_num = 0;
	String v_age_unit = "", v_agegroup = "" ;

	double dValue = 0.0;
	double dNormalLow = 0.0;
	double dNormalHigh = 0.0;

	String alignTable = "";
	String chartID = "";
	String divID = "";

	String columnColor = "";
	String sValueRep = "";

	// XML String
	String xmlString = "";
	Blob blobImage = null;
	String facilityImageName = "";
	
	String printFlag = "0";
	
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	
	//patientid = "DU00000692";
	//encounterid = "101024040001";
		
	String appl_user_id=(String)session.getValue("login_user");	

	v_summ_code = request.getParameter("summCode")==null?"":request.getParameter("summCode");
	
	printFlag = request.getParameter("printFlag")==null?"0":request.getParameter("printFlag");
	
	if (facilityId != null){
		oPatientContext.sFacilityId = facilityId;
	}

	if (patientid != null){
		oPatientContext.sPatientId = patientid;
	}

	if (encounterid != null){
		oPatientContext.sEncounterId = encounterid;
	}
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		
		// To get the Facility Information
		demoSql="select facility_name, addr_line1, addr_line2, addr_line3, addr_line4, addr_postal_code, tel_no1, tel_no2, tel_no3, tel_no4, email_id, website_id, "+
					" long_name country_name, facility_logo, facility_image_file_name  from sm_facility_param a, mp_country b "+
					" where facility_id = ? and a.country_code = b.country_code(+)  ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,facilityId);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityName = rs.getString("facility_name")==null?"":rs.getString("facility_name");
				addrLine1 = rs.getString("addr_line1")==null?"":rs.getString("addr_line1")+",";
				addrLine2 = rs.getString("addr_line2")==null?"":rs.getString("addr_line2")+",";
				addrLine3 = rs.getString("addr_line3")==null?"":rs.getString("addr_line3")+",";
				addrLine4 = rs.getString("addr_line4")==null?"":rs.getString("addr_line4")+",";
				postalCode = rs.getString("addr_postal_code")==null?"":rs.getString("addr_postal_code")+",";
				telephone1 = rs.getString("tel_no1")==null?"":rs.getString("tel_no1");
				telephone2 = rs.getString("tel_no2")==null?"":rs.getString("tel_no2");
				telephone3 = rs.getString("tel_no3")==null?"":rs.getString("tel_no3");
				telephone4 = rs.getString("tel_no4")==null?"":rs.getString("tel_no4");
				emailId = rs.getString("email_id")==null?"":rs.getString("email_id");
				website = rs.getString("website_id")==null?"":rs.getString("website_id");
				countryName = rs.getString("country_name")==null?"":rs.getString("country_name");
				blobImage = rs.getBlob("facility_logo");   
				facilityImageName = rs.getString("facility_image_file_name")==null?"":rs.getString("facility_image_file_name");
				
				address = facilityName+", "+ addrLine1 + " " + addrLine2 +" "+ addrLine3 + " " + addrLine4+ " " + postalCode + " " +countryName +".";

				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		/** BLOB to Image **/
		
		long blobLength = blobImage.length();
		System.out.println(" - - - blobLength: "+blobLength);
		if (blobLength>0){
			
			StringBuffer image_folder = new StringBuffer();
			String path	= "";		
			String strFileSep =	"";		
	
			java.util.Properties pFileSep	= null;
			
			try
			{					
				
				path = application.getRealPath("/");
	
				image_folder.append(path);
	
				pFileSep	= System.getProperties();
				strFileSep	= (String) pFileSep.getProperty("file.separator");
				image_folder.append("eCA");
				image_folder.append(strFileSep);
				image_folder.append("images");
				image_folder.append(strFileSep);			
				image_folder.append(facilityImageName);	
								
				File filecreate ;		
				String filename	= "";
				boolean fcre = false;
				
				filename = image_folder.toString();
				
				System.out.println(" - - - facilityImageName: "+facilityImageName);
				
				filecreate = new File(filename);			
				if(!filecreate.exists())
				{
					System.out.println(" - - - filename: "+filename);
					
					InputStream is = blobImage.getBinaryStream();   
		            FileOutputStream fos = new FileOutputStream(filename);   
		  
					int b = 0;   
					while ((b = is.read()) != -1)   
					{   
					    fos.write(b);    
					}   
					fos.close();
				}				
			}		
			catch ( IOException e )
			{
				out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
			}
			catch ( Exception e )
			{
				out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
			}
		}
		// To get the Patient Demographic Information
		demoSql="select patient_id, name_prefix, first_name, second_name, third_name, family_name, sex, date_of_birth, "+
				" round((trunc(sysdate) - trunc(to_date(to_char(date_of_birth, 'dd/MM/YYYY'),'DD/MM/YYYY')))/  365) age_in_years "+
				" from mp_patient where patient_id = ? ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,patientid);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				patientNamePrefix = rs.getString("name_prefix")==null?"":rs.getString("name_prefix");
				patientFirstName = rs.getString("first_name")==null?"":rs.getString("first_name");
				patientSecondName = rs.getString("second_name")==null?"":rs.getString("second_name");
				patientThirdName = rs.getString("third_name")==null?"":rs.getString("third_name");
				patientFamilyName = rs.getString("family_name")==null?"":rs.getString("family_name");
				gender = rs.getString("sex");
				dateOfBirth = rs.getString("date_of_birth");
				ageInYears = rs.getString("age_in_years");	
				patientName = patientNamePrefix + " " + patientFirstName +" "+ patientSecondName + " " + patientThirdName+ " " + patientFamilyName;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		// To get the Patient Blood Group Details
		rs = null;
		stmt = null;

		bloodSql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A, "+     
				" MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) "+ 
				" AND C.LANGUAGE_ID = ?" ;
		stmt=con.prepareStatement(bloodSql);
		stmt.setString(1,patientid);
		stmt.setString(2,locale);

		rs=stmt.executeQuery();

		while(rs.next())
		{
			bloodGroup = rs.getString("blood_grp");
		}

		// To get the Patient Encounter Details
		rs = null;
		stmt = null;
		encounterSql = "select facility_id, encounter_id, attend_practitioner_id, to_char(visit_adm_date_time, 'DD MON YYYY') visit_date_time, practitioner_name "+  
				" from pr_encounter, am_practitioner where attend_practitioner_id = practitioner_id and patient_id = ? and encounter_id = ? ";
		stmt=con.prepareStatement(encounterSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
				attendPractitionerId = rs.getString("attend_practitioner_id")==null?"":rs.getString("attend_practitioner_id");
				visitDateTime = rs.getString("visit_date_time")==null?"":rs.getString("visit_date_time");
				practitionerName = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");	
				encResFlag = true;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// To get the Encounter Summary title
		rs = null;
		stmt = null;
		encSummSql = "Select ES_SUMM_TITLE from CR_ES_SUMM_HDR where ES_SUMM_CODE = ? and ES_SUMM_STATUS = 'E' ";
		
		stmt=con.prepareStatement(encSummSql);
		stmt.setString(1,v_summ_code);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				v_summ_desc = rs.getString("ES_SUMM_TITLE")==null?"":rs.getString("ES_SUMM_TITLE");					
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();			
		
		System.out.println(" - v_summ_code: "+v_summ_code+" - v_summ_desc: "+v_summ_desc);
		
		// To get the Authorized Doctor Name and Speciality
		/*
		rs = null;
		stmt = null;
		authSplSql = "select practitioner_name, degree, long_desc speciality_name  from am_practitioner a, am_speciality b "+ 
				" where a.primary_speciality_code = b.speciality_code and a.practitioner_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,attendPractitionerId);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				vAuthoriseName = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");					
				vAuthoriseDegree = rs.getString("degree")==null?"":rs.getString("degree");
				vAuthoriseBySplty = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		*/
		// To get the Authorized Doctor Name and Speciality
		rs = null;
		stmt = null;
		authSplSql = "select long_desc speciality_name  from pr_encounter a, am_speciality b "+ 
				" where a.specialty_code = b.speciality_code and patient_id = ? and encounter_id = ? ";
		
		System.out.println(" - authSplSql: "+authSplSql);
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{				
				vAuthoriseBySplty = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		
	
	%>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
		var docReadyCount = 0;
		var divCount = 0;
		
		function printPage(){
			
			if (<%=printFlag%> == "1")
			{	
				
				docReadyCount = docReadyCount + 1;	
				if (docReadyCount == divCount) 
				{				
					if(PrintCommandObject)
					{		
						try{	
							PrintCommandObject.ExecWB(6,2);
					 		PrintCommandObject.outerHTML = "";
					 		window.close();
					 	}
					 	catch(e){			
					 		window.print();
					 	}
					}
					else{
					 	window.print();
					}
				}
			}
			
		}
			 
		
		$(document).ready(function() {
			
			divCount = document.getElementById("divCount").value;	
			
			if (navigator.appName == "Microsoft Internet Explorer"){			
			 	// attach and initialize print command ActiveX object
				try{
			 		var PrintCommand = '<object id="PrintCommandObject" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" width="0" height="0"></object>';		 		
			 		document.body.insertAdjacentHTML('afterbegin', PrintCommand);
				}
			 	catch(e){}
			}	
				
		});
		
		$(window).load(function() 
		{		
			if (<%=printFlag%> == "1")
			{	
				if (divCount == 0)
				{		
					if(PrintCommandObject)
					{
						try{			
							PrintCommandObject.ExecWB(6,2);
					 		PrintCommandObject.outerHTML = "";
					 		window.close();
					 	}
					 	catch(e){	 		
					 		window.print();
					 	}
					}
					else{
					 	window.print();
					}
				}
			}
		});
		
		function pagePrint(){
			window.print();	
		}
	</script>
	<body class='CONTENT' scroll="auto" style="background-color:transparent">
		<div id="footer_wrapper">   
			<div id="footer_content">
				<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">   			
					<tr><th>
						<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
							<tbody>
								<tr><hr style="color:#000080"/></tr> 
								<tr>
									<td>
										<span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif">24X7 hot-line: <%=telephone1%>&nbsp;</span></span></strong></span></td>
									<td>
										<span style="font-size: 12px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080">Emergency: <%=telephone2%></span></span></strong>&nbsp;&nbsp;</span></td>
									<td>
										<span style="font-size: 12px"><span style="font-family: verdana, geneva, sans-serif"><strong><span style="color: #808080">Email: </span><span style="color: #808080"><%=emailId%></span></strong></span></span></td>
									
								</tr>
							</tbody>
						</table>
						<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
							<tbody>
								<tr>
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif"><%=address%></span></span></strong></span></td>
									
									<td width="50%" valign="top">
										&nbsp;<span style="font-size: 12px"><span style="color: #ff0000"><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"><%=website%></span></strong></span></span><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"></span></strong></span></span></td>
									<!-- 
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080"> </span></span></strong></span></td>
									 -->
									<!-- 	
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080"> Medanta, The Mediclinic: E-18 Defence Colony, New Delhi 110024</span></span></strong></span></td>
									 -->
									
								</tr>
							</tbody>
						</table>				
					</th></tr> 
				</table>
			</div>	
		</div> 

		<form name="EncounterSummaryGH_form" id="EncounterSummaryGH_form">
			<div id="print_wrapper"> 
				<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
						<tr>
							<td>
								<input type='button' class='button' name='print' id='print' id='print' onClick="pagePrint()" 
															value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>'></td>
						</tr>
				</table>
			</div>	 
			<table align="center" border="0" cellpadding="0" cellspacing="0" style="width: 900px"> 
				<thead> 
					<tr><th> 
						<table align="center" border="0" cellpadding="0" cellspacing="0" style="width: 900px">
							<tbody>
								<tr>
									<td align="center">
										<span style="color: #808080"><span style="font-size: 14pt"><span style="font-family: verdana, geneva, sans-serif"><%=facilityName%></span></span></span>				
									</td>	
								</tr>
							</tbody>
						</table>
					</th></tr>
					<tr><th>  
						<table align="center" border="0" cellpadding="0" cellspacing="0" style="width: 900px">
							<tbody>
								<tr>
									<td style="border-bottom:2px solid green" valign="center">							
										<table align="right" border="0" cellpadding="3" cellspacing="8" style="width: 300px">
											<tbody>
												<tr>
													<td align="center">											
														<!-- <img src="../../eCommon/jsp/DisplayImages.jsp?param=facilityimage" title='Logo' width="100px" height="100px"> -->
														<img src="../../eCA/images/<%=facilityImageName %>" title='Logo' width="100px" height="100px">
													</td>									
												</tr>
												<tr>
													<td align="left">
														<span style="font-family: verdana, geneva, sans-serif; color: red; font-size: 14pt; font-weight: bold;">
														<%=v_summ_desc %> 
														</span>										
													</td>
												</tr>									
											</tbody>
										</table>								
									</td>
									<td align="right" style="border-bottom:2px solid green" valign="center">
										<table align="right" border="0" cellpadding="3" cellspacing="8" style="width: 385px">
											<tbody>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Name:</span></span></span>
														<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=patientName %></span></span>
													</td>									
												</tr>
												<tr>
													<td align="left">
													<table border="0" cellpadding="0" cellspacing="0" style="width: 300px">
														<tr>
															<td align="left">
																<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Gender:</span></span></span>
																<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=gender %></span></span> 
															</td>
															<td align="left">
																<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Blood Group:</span></span></span>
																<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=bloodGroup %></span></span> 
															</td>
														</tr>
													</table>
													</td>
												</tr>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Age:</span></span></span>
														<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=ageInYears %> years</span></span>
													</td>
												</tr>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Doctor:</span></span></span>
														 <span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=practitionerName %></span></span> 
													</td>									
												</tr>
											</tbody>
										</table>
									</td>
									<td align="right" style="border-bottom:2px solid green" valign="center">
										<table  align="right" border="0" cellpadding="3" cellspacing="8" style="width: 215px">
											<tbody>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</span></span></span>
														<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=patientid %></span></span> 
													</td>
												</tr>
												<tr>
													<td align="left">
														<table border="0" cellpadding="0" cellspacing="0" style="width: 300px">
															<tr>
																<td align="left">
																	<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>:</span></span></span>
																	<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=encounterid %> </span></span> 
																</td>
															</tr>
														</table>														
													</td>
												</tr>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">Date:</span></span></span>
														<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"><%=visitDateTime %></span></span> 
													</td>
												</tr>
												<tr>
													<td align="left">
														<span style="color: #808080"><span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif">&nbsp;</span></span></span>
														<span style="font-size: 13pt"><span style="font-family: verdana, geneva, sans-serif"></span></span> 
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>		
					</th></tr>		
					<tr><th> 
						<table align="right" border="0" cellpadding="3" cellspacing="3" style="width: 540px">
							<tbody>					
								<tr>
									<td width="340px" valign="center"><span style="color: #808080"><span style="font-size: 11pt"><span style="font-family: verdana, geneva, sans-serif">Colors Indicate:&nbsp;</span></span></span></td>
									<td width="200px" valign="center">
										<table align="right" border="0" cellpadding="3" cellspacing="3" style="width: 200px">
											<tbody>
												<tr>
													<td  width="65px" valign="bottom"><span style="color: #808080"><span style="font-size: 12pt"><span style="font-family: verdana, geneva, sans-serif">&nbsp;&nbsp;&nbsp;Optimal&nbsp;&nbsp;&nbsp;</span></span></span></td>
													<td  width="65px" valign="bottom"><span style="color: #808080"><span style="font-size: 12pt"><span style="font-family: verdana, geneva, sans-serif">&nbsp;&nbsp;&nbsp;Borderline&nbsp;&nbsp;&nbsp;</span></span></span></td>
													<td  width="65px" valign="bottom"><span style="color: #808080"><span style="font-size: 12pt"><span style="font-family: verdana, geneva, sans-serif">&nbsp;&nbsp;&nbsp;Abnormal&nbsp;&nbsp;&nbsp;</span></span></span></td>
												</tr>
												<tr>
													<td width="65px" style="border-top:3px solid green" valign="top">&nbsp;</td>
													<td width="65px" style="border-top:3px solid yellow" valign="top">&nbsp;</td>
													<td width="65px" style="border-top:3px solid red" valign="top">&nbsp;</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>			
					</th></tr> 
				</thead>    
				<tbody> 
					<tr><td>
						<div id="body_wrapper">   
							<div id="body_content">
								<%
									rs = null;
									stmt = null;
					
									//eCA.EncounterSummaryXMLHTML esXMLHtml = new eCA.EncounterSummaryXMLHTML();	
									eCA.EncounterSummaryXMLHTML_V2 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V2();
									facilityId = (String) session.getValue("facility_id");
					
					 				//System.out.println(" - - - 1 - - - ");
					 				
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM(?,?,?,?,?)}");
					 				cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V2(?,?,?,?,?)}");
									cstmt.setString(1,patientid);
									cstmt.setString(2,encounterid);
									cstmt.setString(3,locale);	
									cstmt.setString(4,v_summ_code);
									cstmt.registerOutParameter(5,java.sql.Types.CLOB);
									
									cstmt.execute();				
									
									//System.out.println(" - - - 2 - - - ");
									
									xmlString = cstmt.getString(5);	
									
									//System.out.println(" - - - 3 - - - ");
									
									//xmlString = " <GraphicalDisplay>	<ReportHeader referrence= 'PRYMHCK' name= 'Primary Master Health Checkup'><MainGroup referrence='CHIEFCOMPL' name='Chief Complaint' ImageUrl='' Remarks=''>	<Template referrence='1' name='NORMAL TEXT'><ResultDesc1 ResultText='Abdominal Pain' ResultVal='- None'></ResultDesc1>	</Template>	</MainGroup><MainGroup referrence='LBIOLFT004' name='Liver Function Test' ImageUrl='' Remarks=''><SubGroup referrence='BLRB' name='Bilirubin' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Bilirubin Direct' ColumnName2='mg/dl' bgcolor='' ColumnName3='.2' ColumnName4='' ColumnName5='0-.3'></RowNo1><RowNo2  ColumnName1='Bilirubin Total' ColumnName2='mg/dl' bgcolor='' ColumnName3='.9' ColumnName4='' ColumnName5='.2-1.2'></RowNo2><RowNo3  ColumnName1='Bilirubin Indirect' ColumnName2='mg/dl' bgcolor='' ColumnName3='1.2' ColumnName4='' ColumnName5='-'></RowNo3></RowNo></Template></SubGroup><SubGroup referrence='ENZY' name='Enzymes' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='SGOT (AST)' ColumnName2='U/L' bgcolor='' ColumnName3='37' ColumnName4='' ColumnName5='0-37'></RowNo1><RowNo2  ColumnName1='Gamma GT' ColumnName2='U/L' bgcolor='H' ColumnName3='115' ColumnName4='H' ColumnName5='8-61'></RowNo2><RowNo3  ColumnName1='SGPT (ALT)' ColumnName2='U/L' bgcolor='H' ColumnName3='59' ColumnName4='H' ColumnName5='0-41'></RowNo3><RowNo4  ColumnName1='Alkaline Phosphatase' ColumnName2='U/L' bgcolor='' ColumnName3='106' ColumnName4='' ColumnName5='40-129'></RowNo4></RowNo></Template></SubGroup><SubGroup referrence='SRPRT' name='Serum Proteins' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Globulin' ColumnName2='gm/dl' bgcolor='' ColumnName3='' ColumnName4='' ColumnName5='2-4'></RowNo1><RowNo2  ColumnName1='Total Protein' ColumnName2='gm/dl' bgcolor='' ColumnName3='7.6' ColumnName4='' ColumnName5='6.4-8.3'></RowNo2><RowNo3  ColumnName1='Albumin' ColumnName2='Ã?Âµmol/L' bgcolor='' ColumnName3='4.2' ColumnName4='' ColumnName5='3.5-7'></RowNo3></RowNo></Template></SubGroup></MainGroup><MainGroup referrence='CLINICEXAM' name='Clinical Examination' ImageUrl='' Remarks=''><Template referrence='5' name='NOTES'><NotesText notesType='CA' queryColumn='HIST_DATA' columnName='HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE' columnData='CLNT~CA~CN13$0000000000002841~OPS' dataTable='CR_ENCOUNTER_DETAIL_TXT' /> </Template></MainGroup></ReportHeader></GraphicalDisplay>";
					
									if ((xmlString != null) && (xmlString.length() != 0))
									{
										System.out.println(" - - - xmlString generated - - - "+xmlString);
										
										xmlString = xmlString.replace('&', '^');
										
										htmlData = esXMLHtml.getXMLHtml(xmlString);										
										
										System.out.println(" - - - htmlData generated- - - "+htmlData);		
										strHtmlData = htmlData.toString();
										
										strHtmlData = strHtmlData.replace('^', '&');
										
									}		
					
									if(rs!=null)rs.close();
									if(stmt!=null)stmt.close();		
					
								%>
								
								<p><%=strHtmlData%></p>
								
								<%
									}
									catch(Exception e){
										out.println("Exception"+e.toString());					
									}
									finally
									{
										if(con!=null)ConnectionManager.returnConnection(con,request);
									}	
								%>
						</div>
					<div>
			
					</td></tr>						
					<tr>
						<td>		
							<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
								<tbody>									 
									<tr>
										<td width="100%" align="center">
											<span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif">***** End of Report *****</span></span></strong></span>
										</td>										
									</tr>
								</tbody>
							</table>
						</td>
					</tr>	
					<tr>
						<td>		
							<table class="breakSignTable" align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
								<tbody>	
									<tr>
										<td style="border-top:1px solid blue" valign="top"></td>									
									</tr>								 
									<tr>
										<td class='label'><u><span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif">Authorised Signatory</span></span></strong></span></u></td>									
									</tr>
									<tr>
										<td class='label'><br></td>									
									</tr>
									<tr>
										<td class='label'><br></td>									
									</tr>
									<!-- 
									<tr>
										<td  class='label'><span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif"><%=vAuthoriseName %>&nbsp;&nbsp;(&nbsp;<%=vAuthoriseDegree %>&nbsp;)</span></span></strong></span></td>									
									</tr>
									 -->
									<tr>
										<td  class='label'><span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif"><%=vAuthoriseBySplty %></span></span></strong></span></td>									
									</tr>
								</tbody>
							</table>
						</td>
					</tr>						
				</tbody> 
				<tfoot  id="table_footer"> 		
					<tr><th>		
						<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
							<tbody>
								<tr><hr style="color:#000080"/></tr> 
								<tr>
									<td width="30%">
										<span style="font-size: 12px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif">24X7 hot-line: <%=telephone1%>&nbsp;</span></span></strong></span></td>
									<td width="30%">
										<span style="font-size: 12px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080">Emergency: <%=telephone2%></span></span></strong>&nbsp;&nbsp;</span></td>
									<td width="40%">
										<span style="font-size: 12px"><span style="font-family: verdana, geneva, sans-serif"><strong><span style="color: #808080">Email: </span><span style="color: #808080"><%=emailId%></span></strong></span></span></td>
									<!-- 		
									<td width="30%">
										&nbsp;<span style="font-size: 12px"><span style="color: #ff0000"><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"><%=website%></span></strong></span></span><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"></span></strong></span></span></td>
									 -->
								</tr>
							</tbody>
						</table>
						<table align="center" border="0" cellpadding="1" cellspacing="1" style="width: 900px;">
							<tbody>
								<tr>
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="color: #808080"><span style="font-family: verdana, geneva, sans-serif"><%=address%></span></span></strong></span></td>
									<td width="50%">
										&nbsp;<span style="font-size: 12px"><span style="color: #ff0000"><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"><%=website%></span></strong></span></span><span style="font-size: 14px"><strong><span style="font-family: verdana, geneva, sans-serif"></span></strong></span></span></td>
									<!-- 
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080"> </span></span></strong></span></td>
									-->
									<!-- 	
									<td width="50%" valign="top">
										<span style="font-size: 10px"><strong><span style="font-family: verdana, geneva, sans-serif"><span style="color: #808080"> Medanta, The Mediclinic: E-18 Defence Colony, New Delhi 110024</span></span></strong></span></td>
									 -->
									
								</tr>
							</tbody>
						</table>
					</th> </tr> 
				</tfoot>
			</table>
		</form>
	</body>
</html>

