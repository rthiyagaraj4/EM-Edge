<!DOCTYPE html>
<!--[if IE 6]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if IE 7]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if gte IE 7]>  
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<![endif]-->

<%@ page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*,eCommon.XSSRequestWrapper"%>
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
			border: solid #CECEC9 1px;
			word-break:break-all;
		}		
		
		@media screen {	
			div#footer_wrapper {       
				display: none;      
			}   
		}
		
		
		@media print { 	
			.tableTemp { page-break-before:auto;page-break-inside:auto; page-break-after:auto} 
			.breakMainTable { page-break-before:auto}
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
	String demoSql = "", bloodSql = "", encounterSql = "", complaintSql = "",  orderSql = "", encSummSql="", authSplSql="", patientSql = "", headerFooterSql = "";
	String locnSql = "", payerSql = "";
	
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
	String facilityId = "", attendPractitionerId = "", visitDateTime = "", practitionerName = "", specialtyName = "";
	String locnType = "", locnCode = "", locnDesc = "";
	String payerCode ="", payerName = "";
	
	boolean encResFlag = false;
	//Facility Details
	String facilityName = "", addrLine1="", addrLine2="", addrLine3="", addrLine4="", postalCode="", countryName="";
	String telephone1="", telephone2="", telephone3="", telephone4="", fax= "";
	String emailId="", website="", address="";
	
	//Summary Details
	String v_summ_code = "", v_summ_desc = "", v_summ_type = "";
	
	//Signature Doctor Details
	String attendPractName = "", attendPractDegree = "", attendPractSplty ="";
	String admitPractName = "", admitPractDegree = "", admitPractSplty = ""; 
    String authPractName = "", authPractDegree = "", authPractSplty = ""; 

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
	char charAtEnd = '\u0000';	
	
	//Order Specific Details
	String specimenNo = "", specimenType = "", orderNo = "", orderDate="";
	String collectedDate = "", registeredDate = "", authorisedBy = "", authorisedDate="", printedDate="";

	// HTML header String
	String htmlHeaderString = "", htmlFooterString = ""; 
	int footer_sign_flag = 0, footer_sign_posn = 0; 
	String footer_sign_1_label = "", footer_sign_2_label = "", footer_sign_3_label = ""; 
	int footer_sign_1_flag = 0, footer_sign_1_practid = 0, footer_sign_1_splty = 0;
	int footer_sign_2_flag = 0, footer_sign_2_practid = 0, footer_sign_2_splty = 0;
	int footer_sign_3_flag = 0, footer_sign_3_practid = 0, footer_sign_3_splty = 0;
	int tbl_cell_color_fill = 0, tbl_cell_bborder_fill = 0; 
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//String patientid = org.owasp.esapi.ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
		
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
		con	= ConnectionManager.getConnection(request);
		
		headerFooterSql = "select es_header_code, es_footer_code, es_footer_sign_flag, es_footer_sign_posn, "+				 
							" nvl(es_footer_sign_1_flag, 0) es_footer_sign_1_flag, nvl(es_footer_sign_1_label,'') es_footer_sign_1_label, "+ 
							" nvl(es_footer_sign_1_practid, 0) es_footer_sign_1_practid, nvl(es_footer_sign_1_splty, 0) es_footer_sign_1_splty, "+
							" nvl(es_footer_sign_2_flag, 0) es_footer_sign_2_flag,  nvl(es_footer_sign_2_label,'') es_footer_sign_2_label, "+
							" nvl(es_footer_sign_2_practid, 0) es_footer_sign_2_practid, nvl(es_footer_sign_2_splty, 0)  es_footer_sign_2_splty, "+
							" nvl(es_footer_sign_3_flag, 0) es_footer_sign_3_flag, nvl(es_footer_sign_3_label, '')  es_footer_sign_3_label, "+
							" nvl(es_footer_sign_3_practid, 0) es_footer_sign_3_practid, nvl(es_footer_sign_3_splty, 0) es_footer_sign_3_splty, "+
							" nvl(es_tbl_cell_color_fill,0) es_tbl_cell_color_fill, nvl(es_tbl_cell_bborder_fill,0) es_tbl_cell_bborder_fill "+
							" from cr_es_summ_layout_hdr where ES_SUMM_CODE = ?";
		
		stmt=con.prepareStatement(headerFooterSql);
		stmt.setString(1, v_summ_code);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{
				Clob headerClob = rs.getClob("es_header_code");
				Clob footerClob  = rs.getClob("es_footer_code");
				
				if (headerClob != null) {  
			    	htmlHeaderString = headerClob.getSubString(1, (int) headerClob.length());
			   	}
				
				if (footerClob != null) {  
					htmlFooterString = footerClob.getSubString(1, (int) footerClob.length());
			   	}		
				
				footer_sign_flag = rs.getInt("es_footer_sign_flag"); 
				footer_sign_posn = rs.getInt("es_footer_sign_posn");   
				
				footer_sign_1_flag =  rs.getInt("es_footer_sign_1_flag");  
				footer_sign_1_label = rs.getString("es_footer_sign_1_label")==null?"":rs.getString("es_footer_sign_1_label"); 
				footer_sign_1_practid =  rs.getInt("es_footer_sign_1_practid");  
				footer_sign_1_splty =  rs.getInt("es_footer_sign_1_splty"); 
				
				footer_sign_2_flag =  rs.getInt("es_footer_sign_2_flag");  
				footer_sign_2_label = rs.getString("es_footer_sign_2_label")==null?"":rs.getString("es_footer_sign_2_label"); 
				footer_sign_2_practid =  rs.getInt("es_footer_sign_2_practid");  
				footer_sign_2_splty =  rs.getInt("es_footer_sign_2_splty");  
				
				footer_sign_3_flag =  rs.getInt("es_footer_sign_3_flag");  
				footer_sign_3_label = rs.getString("es_footer_sign_3_label")==null?"":rs.getString("es_footer_sign_3_label"); 
				footer_sign_3_practid =  rs.getInt("es_footer_sign_3_practid");  
				footer_sign_3_splty =  rs.getInt("es_footer_sign_3_splty");  
				
				tbl_cell_color_fill = rs.getInt("es_tbl_cell_color_fill");  
				tbl_cell_bborder_fill = rs.getInt("es_tbl_cell_bborder_fill");  
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		
		// To get the Facility Information
		demoSql="select facility_name, addr_line1, addr_line2, addr_line3, addr_line4, addr_postal_code, tel_no1, tel_no2, tel_no3, tel_no4, fax_no, email_id, website_id, "+
					" long_name country_name, facility_logo, facility_image_file_name  from sm_facility_param a, mp_country b "+
					" where facility_id = ? and a.country_code = b.country_code(+)  ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,facilityId);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityName = rs.getString("facility_name")==null?"":rs.getString("facility_name");
				addrLine1 = rs.getString("addr_line1")==null?"":rs.getString("addr_line1");
				addrLine2 = rs.getString("addr_line2")==null?"":rs.getString("addr_line2");
				addrLine3 = rs.getString("addr_line3")==null?"":rs.getString("addr_line3");
				addrLine4 = rs.getString("addr_line4")==null?"":rs.getString("addr_line4");
				postalCode = rs.getString("addr_postal_code")==null?"":rs.getString("addr_postal_code");
				telephone1 = rs.getString("tel_no1")==null?"":rs.getString("tel_no1");
				telephone2 = rs.getString("tel_no2")==null?"":rs.getString("tel_no2");
				telephone3 = rs.getString("tel_no3")==null?"":rs.getString("tel_no3");
				telephone4 = rs.getString("tel_no4")==null?"":rs.getString("tel_no4");
				fax = rs.getString("fax_no")==null?"":rs.getString("fax_no");
				emailId = rs.getString("email_id")==null?"":rs.getString("email_id");
				website = rs.getString("website_id")==null?"":rs.getString("website_id");
				countryName = rs.getString("country_name")==null?"":rs.getString("country_name");
				blobImage = rs.getBlob("facility_logo");   
				facilityImageName = rs.getString("facility_image_file_name")==null?"":rs.getString("facility_image_file_name");				

				if (addrLine1.length()>0){
					charAtEnd = addrLine1.charAt(addrLine1.length() - 1);
					if (!(charAtEnd == ','))
					{
						addrLine1 += ',';
							
					}
				}
				
				if (addrLine2.length()>0){
					charAtEnd = addrLine2.charAt(addrLine2.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine2 += ',';
					}
				}

				if (addrLine3.length()>0){
					charAtEnd = addrLine3.charAt(addrLine3.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine3 += ',';
					}
				}
				
				if (addrLine4.length()>0){
					charAtEnd = addrLine4.charAt(addrLine4.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine4 += ',';
					}
				}
				
				address = addrLine1 + " " + addrLine2 +" "+ addrLine3 + " " + addrLine4+ " " + postalCode + " " +countryName +".";

			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		/** BLOB to Image **/
		
		long blobLength = blobImage.length();

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
				
				filecreate = new File(filename);			
				if(!filecreate.exists())
				{
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
				//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			catch ( Exception e )
			{
				//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
		}
		// To get the Patient Demographic Information
		demoSql="select patient_id, name_prefix, first_name, second_name, third_name, family_name, sex, to_char(date_of_birth, 'dd/MM/YYYY') date_of_birth, "+
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
		encounterSql = "select facility_id, encounter_id, attend_practitioner_id, to_char(visit_adm_date_time, 'DD MON YYYY') visit_date_time, practitioner_name, "+ 
						" assign_care_locn_type, assign_care_locn_code "+
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
				locnType = rs.getString("assign_care_locn_type")==null?"":rs.getString("assign_care_locn_type");
				locnCode = rs.getString("assign_care_locn_code")==null?"":rs.getString("assign_care_locn_code");
				encResFlag = true;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		if ((locnType.equalsIgnoreCase("n")) || (locnType.equalsIgnoreCase("c"))){
			if (locnType.equalsIgnoreCase("n")) {
				locnSql = "select nursing_unit_code, long_desc, short_desc  from ip_nursing_unit where facility_id = ? and nursing_unit_code = ? ";
			}
			else if (locnType.equalsIgnoreCase("c")){
				locnSql = "select clinic_code, long_desc, short_desc from op_clinic where facility_id = ? and clinic_code = ? ";
			}
			stmt=con.prepareStatement(locnSql);
			stmt.setString(1,facilityId);
			stmt.setString(2,locnCode);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					locnDesc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();		
		}
		
		// To get the Patient Payer Details
		rs = null;
		stmt = null;
		payerSql = "Select a.cust_code, b.long_name, b.short_name from bl_episode_fin_dtls a, ar_customer b "+ 
						" where patient_id = ? and encounter_id = ? "+
						" and a.cust_code = b.cust_code ";
		stmt=con.prepareStatement(payerSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				payerCode = rs.getString("cust_code")==null?"":rs.getString("cust_code");
				payerName = rs.getString("long_name")==null?"":rs.getString("long_name");
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// To get the Encounter Summary title
		rs = null;
		stmt = null;
		encSummSql = "Select ES_SUMM_TITLE, ES_SUMM_TYPE from CR_ES_SUMM_HDR where ES_SUMM_CODE = ? and ES_SUMM_STATUS = 'E' ";
		
		stmt=con.prepareStatement(encSummSql);
		stmt.setString(1,v_summ_code);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				v_summ_desc = rs.getString("ES_SUMM_TITLE")==null?"":rs.getString("ES_SUMM_TITLE");	
				v_summ_type = rs.getString("ES_SUMM_TYPE")==null?"":rs.getString("ES_SUMM_TYPE");	
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();			
		
		//Singature Doctor Name, Speciality			
		rs = null;
		stmt = null;
		authSplSql = "select facility_id, encounter_id, "+ 
						" attend_practitioner_id,  nvl(b.practitioner_name,'') attend_pract_name,  nvl(b.degree,'') attend_pract_degree, nvl(e.long_desc,'') attend_splty_name, "+
						" admit_practitioner_id, nvl(c.practitioner_name,'') admit_pract_name, nvl(c.degree,'') admit_pract_degree, nvl(f.long_desc,'') admit_splty_name, "+
						" disp_auth_practitioner_id,  nvl(d.practitioner_name,'') auth_pract_name, nvl(d.degree,'') auth_pract_degree, nvl(g.long_desc,'') auth_splty_name "+
					" from pr_encounter a, am_practitioner b, am_practitioner c, am_practitioner d, am_speciality e, am_speciality f, am_speciality g "+
					" where attend_practitioner_id = b.practitioner_id "+
							" and admit_practitioner_id = c.practitioner_id(+) "+
							" and disp_auth_practitioner_id = d.practitioner_id(+) "+
							" and b.primary_speciality_code = e.speciality_code(+) "+
							" and c.primary_speciality_code = f.speciality_code(+) "+
							" and d.primary_speciality_code = g.speciality_code(+) "+
							" and patient_id = ? and encounter_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{
				attendPractName = rs.getString("attend_pract_name")==null?"":rs.getString("attend_pract_name");					
				attendPractDegree = rs.getString("attend_pract_degree")==null?"":rs.getString("attend_pract_degree");
				attendPractSplty = rs.getString("attend_splty_name")==null?"":rs.getString("attend_splty_name");
				
				admitPractName = rs.getString("admit_pract_name")==null?"":rs.getString("admit_pract_name");					
				admitPractDegree = rs.getString("admit_pract_degree")==null?"":rs.getString("admit_pract_degree");
				admitPractSplty = rs.getString("admit_splty_name")==null?"":rs.getString("admit_splty_name");
				
				authPractName = rs.getString("auth_pract_name")==null?"":rs.getString("auth_pract_name");					
				authPractDegree = rs.getString("auth_pract_degree")==null?"":rs.getString("auth_pract_degree");
				authPractSplty = rs.getString("auth_splty_name")==null?"":rs.getString("auth_splty_name");
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		// To get the Authorized Doctor Name and Speciality
		rs = null;
		stmt = null;
		authSplSql = "select long_desc speciality_name  from pr_encounter a, am_speciality b "+ 
				" where a.specialty_code = b.speciality_code and patient_id = ? and encounter_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{				
				specialtyName = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// Order related information
		rs = null;
		stmt = null;
		
		if (v_summ_type.equalsIgnoreCase("rdin")){
			orderSql = " select a.patient_id, a.encounter_id, a.order_id, to_char(c.ord_date_time, 'DD/MM/YYYY') ord_date_time, "+ 
						" null specimen_no, null spec_colltd_date_time, null spec_regd_date_time, null specimen_type_code, null specimen_desc, "+
						" physician_id verified_by_id, null verified_date, null result_printed_date "+
						" from rd_request a, or_order c "+
						" where a.patient_id = ? and a.encounter_id = ?   "+
						" and a.added_date in (select max(added_date) from rd_request d "+ 
	                                			" where d.patient_id = a.patient_id and d.encounter_id = a.encounter_id) "+
	                    " and a.order_id = c.order_id ";
		}
		else
		{
			orderSql = " select a.patient_id, a.encounter_id, a.order_id, to_char(c.ord_date_time, 'DD/MM/YYYY') ord_date_time, "+ 
						" specimen_no, to_char(spec_colltd_date_time, 'DD/MM/YYYY') spec_colltd_date_time, to_char(spec_regd_date_time, 'DD/MM/YYYY') spec_regd_date_time, "+
						" a.specimen_type_code, b.specimen_desc, "+
						" verified_by_id, to_char(verified_date, 'DD/MM/YYYY') verified_date, to_char(result_printed_date, 'DD/MM/YYYY') result_printed_date "+
						" from rl_request_header a, rl_specimen_type_code b, or_order c "+
						" where a.patient_id = ? and a.encounter_id = ?   "+
						" and a.added_date in (select max(added_date) from rl_request_header d "+ 
	                                			" where d.patient_id = a.patient_id and d.encounter_id = a.encounter_id) "+
						" and a.specimen_type_code = b.specimen_type_code "+
	                    " and a.order_id = c.order_id ";
		}
		
		stmt=con.prepareStatement(orderSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{	
				orderNo 		= rs.getString("order_id")==null?"":rs.getString("order_id");
				orderDate 		= rs.getString("ord_date_time")==null?"":rs.getString("ord_date_time");
				specimenNo 		= rs.getString("specimen_no")==null?"":rs.getString("specimen_no");	
				specimenType 	= rs.getString("specimen_desc")==null?"":rs.getString("specimen_desc");	
					
				collectedDate 	= rs.getString("spec_colltd_date_time")==null?"":rs.getString("spec_colltd_date_time");	
				registeredDate 	= rs.getString("spec_regd_date_time")==null?"":rs.getString("spec_regd_date_time");	
				authorisedBy 	= rs.getString("verified_by_id")==null?"":rs.getString("verified_by_id");	
				authorisedDate 	= rs.getString("verified_date")==null?"":rs.getString("verified_date");	
				printedDate 	= rs.getString("result_printed_date")==null?"":rs.getString("result_printed_date");						
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		if (htmlHeaderString.length() > 0){
		
			htmlHeaderString =  htmlHeaderString.replace("XYZ", "#"); 
			htmlHeaderString =  htmlHeaderString.replace("^", "'"); 
			htmlHeaderString =  htmlHeaderString.replace("*", "&"); 
			htmlHeaderString =  htmlHeaderString.replace("facilityName", facilityName); 
			htmlHeaderString =  htmlHeaderString.replace("facilityImageName", facilityImageName);
			htmlHeaderString =  htmlHeaderString.replace("address", address);
			htmlHeaderString =  htmlHeaderString.replace("telephone1", telephone1);
			htmlHeaderString =  htmlHeaderString.replace("telephone2", telephone2);
			htmlHeaderString =  htmlHeaderString.replace("telephone3", telephone3);
			htmlHeaderString =  htmlHeaderString.replace("telephone4", telephone4);
			htmlHeaderString =  htmlHeaderString.replace("fax", fax);
			htmlHeaderString =  htmlHeaderString.replace("emailId", emailId);
			htmlHeaderString =  htmlHeaderString.replace("website", website);
			
			htmlHeaderString =  htmlHeaderString.replace("patientName", patientName);
			htmlHeaderString =  htmlHeaderString.replace("gender", gender);
			htmlHeaderString =  htmlHeaderString.replace("bloodGroup", bloodGroup);
			htmlHeaderString =  htmlHeaderString.replace("dateOfBirth", dateOfBirth);
			htmlHeaderString =  htmlHeaderString.replace("ageInYears", ageInYears);
			htmlHeaderString =  htmlHeaderString.replace("practitionerName", practitionerName);
			htmlHeaderString =  htmlHeaderString.replace("payerName", payerName);
			
			htmlHeaderString =  htmlHeaderString.replace("patientid", patientid);
			htmlHeaderString =  htmlHeaderString.replace("encounterid", encounterid);
			htmlHeaderString =  htmlHeaderString.replace("visitDateTime", visitDateTime);
			htmlHeaderString =  htmlHeaderString.replace("specialtyName", specialtyName);
			htmlHeaderString =  htmlHeaderString.replace("locationName", locnDesc);
			
			htmlHeaderString =  htmlHeaderString.replace("specimenNo", specimenNo);
			htmlHeaderString =  htmlHeaderString.replace("specimenType", specimenType);
			htmlHeaderString =  htmlHeaderString.replace("orderNo", orderNo);
			htmlHeaderString =  htmlHeaderString.replace("orderDate", orderDate);
			htmlHeaderString =  htmlHeaderString.replace("collectedDate", collectedDate);
			htmlHeaderString =  htmlHeaderString.replace("registeredDate", registeredDate);			
			htmlHeaderString =  htmlHeaderString.replace("authorisedBy", authorisedBy);
			htmlHeaderString =  htmlHeaderString.replace("authorisedDate", authorisedDate);
			htmlHeaderString =  htmlHeaderString.replace("printedDate", printedDate);
			
			htmlHeaderString =  htmlHeaderString.replace("v_summ_desc", v_summ_desc);		
		
		}
		
		if (htmlFooterString.length() > 0){
		
			htmlFooterString =  htmlFooterString.replace("XYZ", "#"); 
			htmlFooterString =  htmlFooterString.replace("^", "'"); 
			htmlFooterString =  htmlFooterString.replace("*", "&"); 
			htmlFooterString =  htmlFooterString.replace("facilityName", facilityName); 
			htmlFooterString =  htmlFooterString.replace("facilityImageName", facilityImageName);
			htmlFooterString =  htmlFooterString.replace("address", address);
			htmlFooterString =  htmlFooterString.replace("telephone1", telephone1);
			htmlFooterString =  htmlFooterString.replace("telephone2", telephone2);
			htmlFooterString =  htmlFooterString.replace("telephone3", telephone3);
			htmlFooterString =  htmlFooterString.replace("telephone4", telephone4);
			htmlFooterString =  htmlFooterString.replace("fax", fax);
			htmlFooterString =  htmlFooterString.replace("emailId", emailId);
			htmlFooterString =  htmlFooterString.replace("website", website);
			
			htmlFooterString =  htmlFooterString.replace("patientName", patientName);
			htmlFooterString =  htmlFooterString.replace("gender", gender);
			htmlFooterString =  htmlFooterString.replace("bloodGroup", bloodGroup);
			htmlFooterString =  htmlFooterString.replace("dateOfBirth", dateOfBirth);
			htmlFooterString =  htmlFooterString.replace("ageInYears", ageInYears);
			htmlFooterString =  htmlFooterString.replace("practitionerName", practitionerName);
			htmlFooterString =  htmlFooterString.replace("payerName", payerName);
			
			htmlFooterString =  htmlFooterString.replace("patientid", patientid);
			htmlFooterString =  htmlFooterString.replace("encounterid", encounterid);
			htmlFooterString =  htmlFooterString.replace("visitDateTime", visitDateTime);
			htmlFooterString =  htmlFooterString.replace("specialtyName", specialtyName);
			htmlFooterString =  htmlFooterString.replace("locationName", locnDesc);
			
			htmlFooterString =  htmlFooterString.replace("specimenNo", specimenNo);
			htmlFooterString =  htmlFooterString.replace("specimenType", specimenType);
			htmlFooterString =  htmlFooterString.replace("orderNo", orderNo);
			htmlFooterString =  htmlFooterString.replace("orderDate", orderDate);
			htmlFooterString =  htmlFooterString.replace("collectedDate", collectedDate);
			htmlFooterString =  htmlFooterString.replace("registeredDate", registeredDate);			
			htmlFooterString =  htmlFooterString.replace("authorisedBy", authorisedBy);
			htmlFooterString =  htmlFooterString.replace("authorisedDate", authorisedDate);
			htmlFooterString =  htmlFooterString.replace("printedDate", printedDate);
		    
		    htmlFooterString =  htmlFooterString.replace("attendPractName", attendPractName);
			htmlFooterString =  htmlFooterString.replace("attendPractDegree", attendPractDegree);
			htmlFooterString =  htmlFooterString.replace("attendPractSplty", attendPractSplty);
			htmlFooterString =  htmlFooterString.replace("admitPractName", admitPractName);
			htmlFooterString =  htmlFooterString.replace("admitPractDegree", admitPractDegree);
			htmlFooterString =  htmlFooterString.replace("admitPractSplty", admitPractSplty);			
			htmlFooterString =  htmlFooterString.replace("authPractName", authPractName);
			htmlFooterString =  htmlFooterString.replace("authPractDegree", authPractDegree);
			htmlFooterString =  htmlFooterString.replace("authPractSplty", authPractSplty);
			
			htmlFooterString =  htmlFooterString.replace("v_summ_desc", v_summ_desc);	
		}
		
	
	%>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript\"></Script>



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
				<%= htmlFooterString%>				
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
				<%= htmlHeaderString%>				
				</thead>    
				<tbody> 
					<tr><td>
						<div id="body_wrapper">   
							<div id="body_content" class="testbody">
								<%
									rs = null;
									stmt = null;
					
									//eCA.EncounterSummaryXMLHTML esXMLHtml = new eCA.EncounterSummaryXMLHTML();	
									//eCA.EncounterSummaryXMLHTML_V2 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V2();
									eCA.EncounterSummaryXMLHTML_V3 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V3();
									facilityId = (String) session.getValue("facility_id");

									System.out.println(patientid + " ::: " + encounterid + " ::: " + locale + " ::: " + v_summ_code);
					
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM(?,?,?,?,?)}");
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V2(?,?,?,?,?)}");


									cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V3(?,?,?,?,?)}");
									cstmt.setString(1,patientid);
									cstmt.setString(2,encounterid);
									cstmt.setString(3,locale);	
									cstmt.setString(4,v_summ_code);
									cstmt.registerOutParameter(5,java.sql.Types.CLOB);
									
									cstmt.execute();				
									
									xmlString = cstmt.getString(5);	

									/*
									
									xmlString = "<GraphicalDisplay><ReportHeader referrence= 'HealthCheck' name= 'Executive Health Check'><MainGroup referrence= 'CHIEFCOMPL' name= 'Chief Complaint' ImageUrl='' Remarks=''><Template referrence='1' name='Textual'><ResultDesc1 ResultText='Chest Pain' ResultVal='- None' /></Template></MainGroup><MainGroup referrence= 'VITALINF' name= 'Vital Information' ImageUrl='' Remarks=''><Template referrence='1' name='Textual'><ResultDesc1 ResultText='Temperature' ResultVal=''></ResultDesc1><ResultDesc2 ResultText='Pulse' ResultVal='72/min'></ResultDesc2><ResultDesc3 ResultText='Respiratory Rate' ResultVal=''></ResultDesc3><ResultDesc4 ResultText='Height' ResultVal='173 cms'></ResultDesc4><ResultDesc5 ResultText='Weight' ResultVal='63 Kg'></ResultDesc5></Template><Group EG2='1' referrence= 'BLP' name = 'Blood Pressure' UOM='mmHG' remarks=''><SubGroup referrence= 'SP' name = 'Systolic BP' remarks=''><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='90' RangeTo='150' TemplateSplit='3'><TemplateSplit1 RangeFrom='90' RangeTo='120' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='120' RangeTo='140' bgcolor='Yellow'></TemplateSplit2><TemplateSplit3 RangeFrom='140' RangeTo='150' bgcolor='Red'></TemplateSplit3></TemplateRange><ResultVal Result='140' bgcolor='Red' ResultStr='Your Value is Pre-Hypertension' > </ResultVal><ResultNormal    ResultNormal='Optimum :90-120'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'DP' name = 'Diastolic BP' remarks=''> <Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='60' RangeTo='90' TemplateSplit='2'><TemplateSplit1 RangeFrom='60' RangeTo='80' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='80' RangeTo='90' bgcolor='Yellow'></TemplateSplit2></TemplateRange><ResultVal Result='80' bgcolor='Green' ResultStr='Your Value is Optimal' > </ResultVal><ResultNormal    ResultNormal='Optimum :60-80'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'BP' name = 'General BP' remarks=''><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='80' RangeTo='220' TemplateSplit='3'><TemplateSplit1 RangeFrom='80' RangeTo='120' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='120' RangeTo='140' bgcolor='Yellow'></TemplateSplit2><TemplateSplit3 RangeFrom='140' RangeTo='220' bgcolor='Red'></TemplateSplit3></TemplateRange><ResultVal Result='120' bgcolor='Green' ResultStr='Your Value is Optimal' > </ResultVal><ResultNormal ResultNormal='Optimum :80-120'> </ResultNormal></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'LIVFUNC' name= 'Liver Function Test' ImageUrl='' Remarks='This test help assess the health of the Liver. Infections, alcoholism, cancer and drug damage are usual causes for liver Diseases.'><Group G1='1' referrence='PHYSICEXAM' name='31/05/2012 - Physical Examin' UOM='Milli Liter' remarks=''><SubGroup ES1='1' referrence='EMPTY' name='EMPTY' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><ColumnType><ColumnType1>P</ColumnType1><ColumnType2>U</ColumnType2><ColumnType3>V</ColumnType3><ColumnType4>Y</ColumnType4><ColumnType5>R</ColumnType5></ColumnType><Column><ColumnName1>Parameter</ColumnName1><ColumnName2>Units</ColumnName2><ColumnName3>Values</ColumnName3><ColumnName4>Your value is </ColumnName4><ColumnName5>Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Quantity' ColumnName2='Milli Liter' bgcolor='' ColumnName3='20 ml' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo1><RowNo2  ColumnName1='Reaction (pH)' ColumnName2='' bgcolor='' ColumnName3='5.0' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo2><RowNo3  ColumnName1='Specific Gravity' ColumnName2='' bgcolor='' ColumnName3='1.015' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo3></RowNo></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'LIPIDPF' name= 'Lipid Profile Test' ImageUrl='LipidProfile.gif' Remarks='Lipid Profile function test'><Group EG2='1'  referrence= 'LDL' name = 'LDL or Bad Cholestrol' UOM='mg/dl' numericresult='116' bgcolor='yellow' remarks='LDL Description to displayed here'><SubGroup referrence= 'LDL' name = 'LDL or Bad Cholestrol' remarks='LDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='40' RangeTo='200' TemplateSplit='3'><TemplateSplit1 RangeFrom='40' RangeTo='100' bgcolor='Green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='100' RangeTo='130' bgcolor='Yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='130' RangeTo='160' bgcolor='Red'>  </TemplateSplit3></TemplateRange><ResultVal Result='116' bgcolor='Yellow' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :0-100'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'HDL' name = 'HDL or Good Cholestrol' remarks='HDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='10' RangeTo='140' TemplateSplit='3'><TemplateSplit1 RangeFrom='10' RangeTo='40' bgcolor='red'>  </TemplateSplit1><TemplateSplit2 RangeFrom='40' RangeTo='60' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='60' RangeTo='140' bgcolor='green'>  </TemplateSplit3></TemplateRange><ResultVal Result='69' bgcolor='green' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :60-120'> </ResultNormal></Template></SubGroup><SubGroup referrence= '' name = 'Cholestrol' remarks='LDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='20' RangeTo='280' TemplateSplit='3'><TemplateSplit1 RangeFrom='20' RangeTo='200' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='200' RangeTo='239' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='240' RangeTo='280' bgcolor='red'>  </TemplateSplit3></TemplateRange><ResultVal Result='100' bgcolor='green' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :20-200'> </ResultNormal></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'VITLINF' name= 'Vitals Information' ImageUrl='Vitals.gif' Remarks='Vitals Recorded'><Group referrence= 'TEMP1' name = 'Temperature' UOM='Celius' remarks=''><SubGroup referrence= 'TEMP1' name = 'Temperature' remarks=''><Template referrence='4' name='Line Graph'><TemplateRange RangeFrom='32' RangeTo='60' TemplateSplit='3' ><TemplateSplit1 RangeFrom='32' RangeTo='40' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='40' RangeTo='49' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='49' RangeTo='60' bgcolor='red'>  </TemplateSplit3></TemplateRange><ValueRange dataPlot='3' xDataType='Date' yDataType='Temperature'><GraphValue1 xAxis='2013/01/01' yAxis='45'/><GraphValue2 xAxis='2013/01/02' yAxis='42'/><GraphValue3 xAxis='2013/01/03' yAxis='46'/></ValueRange></Template></SubGroup><SubGroup referrence= 'PULSE' name = 'Pulse' remarks=''><Template referrence='4' name='Line Graph'><TemplateRange RangeFrom='40' RangeTo='120' TemplateSplit='2' ><TemplateSplit1 RangeFrom='60' RangeTo='80' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='80' RangeTo='110' bgcolor='red'>  </TemplateSplit2></TemplateRange><ValueRange dataPlot='2' xDataType='Date' yDataType='Pulse'><GraphValue1 xAxis='2013/01/01' yAxis='70'/><GraphValue2 xAxis='2013/01/02' yAxis='72'/></ValueRange></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'NOTES' name='NOTES' ImageUrl='' Remarks=''><Template referrence='5' name='Notes'><NotesText notesType='LB' queryColumn='HIST_DATA' columnName='HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE' columnData='LBIN~LB~FKH#3012009984@CULT10~CULT10' dataTable='CR_ENCOUNTER_DETAIL_TXT' /></Template></MainGroup></ReportHeader></GraphicalDisplay>";

									*/

									System.out.println(" ************************************************************************************************** ");				
									
									System.out.println(xmlString);

					
									if ((xmlString != null) && (xmlString.length() != 0))
									{
										xmlString = xmlString.replace('&', '^');
										
										htmlData = esXMLHtml.getXMLHtml(xmlString, tbl_cell_color_fill, tbl_cell_bborder_fill);										
										
										strHtmlData = htmlData.toString();
										
										strHtmlData = strHtmlData.replace('^', '&');
										
									}	

									//System.out.println(" ************************************************************************************************** ");

									//System.out.println(strHtmlData);

									//System.out.println(" ************************************************************************************************** ");

								%>

									<!--

									<table class="breakTable" align="center" border="0" cellpadding="0"
										cellspacing="0" style="width: 900px">
										<tbody>
											<tr class="breakTrNotes">
												<td><div id="EMPTY11"> </div>													
													<script> $('#EMPTY11').load('../../eCA/jsp/ES_Notes.jsp?divID=EMPTY11&queryColumn=HIST_DATA&columnName=HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE&columnData=LBIN~~FKH>3012001507@CULT10~CULT10&dataTable=CR_ENCOUNTER_DETAIL_TXT', function() {});
													</script>														
												</td>
											</tr>
										</tbody>
									</table>
									<br><input type="hidden" name="divCount" id="divCount" id="divCount" value=1>

									-->

								<%
					
									if(rs!=null)rs.close();
									if(stmt!=null)stmt.close();		
					
								%>
								
								<p><%=strHtmlData%></p>
								
								<%
									}
									catch(Exception e){
									//	out.println("Exception"+e.toString());	//COMMON-ICN-0181
                                                                             e.printStackTrace();//COMMON-ICN-0181				
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
					<%					
					if (footer_sign_flag > 0){
						if (footer_sign_posn > 0){
							if ((footer_sign_1_flag > 0) || (footer_sign_2_flag > 0) || (footer_sign_3_flag > 0))
							{
					%>
					<tr>
						<td>	
							<table  class='breakSignTable' align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'> 
								<tbody>	
									<tr>
										<hr style='color:#0101DF'/>									
									</tr>	
									<tr>
									<% 
									if (footer_sign_1_flag > 0){
									%>	
										<td valign='left' align='left' width='300px'>
											<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>
												<tbody>
													<tr>
														<td class='label'>
															<u><span style='font-size: 12px'><strong>
																<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'><%=footer_sign_1_label %></span></span>
															</strong></span></u>
														</td>									
													</tr>
													<tr><td class='label'><br></td></tr>
													<tr><td class='label'><br></td></tr>
													<tr>
														<td class='label'>
															<span style='font-size: 12px'><strong><span style='color: #808080'>
															<%
															if (footer_sign_1_practid == 1){
															%>
																<span style='font-family: verdana, geneva, sans-serif'><%=attendPractName%> &nbsp;&nbsp;(&nbsp; <%=attendPractDegree%> &nbsp;)</span>
															<%
															}															 
															if (footer_sign_1_practid == 2){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=admitPractName%> &nbsp;&nbsp;(&nbsp; <%=admitPractDegree%> &nbsp;)</span>
															<%
															}
															if (footer_sign_1_practid == 3){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=authPractName%> &nbsp;&nbsp;(&nbsp; <%=authPractDegree%> &nbsp;)</span>
															<%
															}
															%>
															</span></strong></span>
														</td>									
													</tr>
													<%
													if (footer_sign_1_splty == 1){
													%>
													<tr><td class='label'>
														<span style='font-size: 12px'><strong><span style='color: #808080'>
														<%
														if (footer_sign_1_practid == 1){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=attendPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_1_practid == 2){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=admitPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_1_practid == 3){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=authPractSplty%> &nbsp;</span>
														<%
														}
														%>											
														</span></strong></span>
													</td></tr>
													<%
													}
													%>
												</tbody>
											</table>
										</td>
									<%										
									}
									%>
									
									<% 
									if (footer_sign_2_flag > 0){
									%>	
										<td valign='left' align='left' width='300px'>
											<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>
												<tbody>
													<tr>
														<td class='label'>
															<u><span style='font-size: 12px'><strong>
																<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'><%=footer_sign_2_label %></span></span>
															</strong></span></u>
														</td>									
													</tr>
													<tr><td class='label'><br></td></tr>
													<tr><td class='label'><br></td></tr>
													<tr>
														<td class='label'>
															<span style='font-size: 12px'><strong><span style='color: #808080'>
															<%
															if (footer_sign_2_practid == 1){
															%>
																<span style='font-family: verdana, geneva, sans-serif'><%=attendPractName%> &nbsp;&nbsp;(&nbsp; <%=attendPractDegree%> &nbsp;)</span>
															<%
															}															 
															if (footer_sign_2_practid == 2){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=admitPractName%> &nbsp;&nbsp;(&nbsp; <%=admitPractDegree%> &nbsp;)</span>
															<%
															}
															if (footer_sign_2_practid == 3){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=authPractName%> &nbsp;&nbsp;(&nbsp; <%=authPractDegree%> &nbsp;)</span>
															<%
															}
															%>
															</span></strong></span>
														</td>									
													</tr>
													<%
														if (footer_sign_2_splty == 1){
													%>
													<tr><td class='label'>
														<span style='font-size: 12px'><strong><span style='color: #808080'>
														<%
														if (footer_sign_2_practid == 1){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=attendPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_2_practid == 2){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=admitPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_2_practid == 3){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=authPractSplty%> &nbsp;</span>
														<%
														}
														%>											
														</span></strong></span>
													</td></tr>
													<%
													}
													%>
												</tbody>
											</table>
										</td>
									<%										
									}
									%>
									<% 
									if (footer_sign_3_flag > 0){
									%>	
										<td valign='left' align='left' width='300px'>
											<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>
												<tbody>
													<tr>
														<td class='label'>
															<u><span style='font-size: 12px'><strong>
																<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'><%=footer_sign_3_label %></span></span>
															</strong></span></u>
														</td>									
													</tr>
													<tr><td class='label'><br></td></tr>
													<tr><td class='label'><br></td></tr>
													<tr>
														<td class='label'>
															<span style='font-size: 12px'><strong><span style='color: #808080'>
															<%
															if (footer_sign_3_practid == 1){
															%>
																<span style='font-family: verdana, geneva, sans-serif'><%=attendPractName%> &nbsp;&nbsp;(&nbsp; <%=attendPractDegree%> &nbsp;)</span>
															<%
															}															 
															if (footer_sign_3_practid == 2){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=admitPractName%> &nbsp;&nbsp;(&nbsp; <%=admitPractDegree%> &nbsp;)</span>
															<%
															}
															if (footer_sign_3_practid == 3){
											 				%>
																<span style='font-family: verdana, geneva, sans-serif'><%=authPractName%> &nbsp;&nbsp;(&nbsp; <%=authPractDegree%> &nbsp;)</span>
															<%
															}
															%>
															</span></strong></span>
														</td>									
													</tr>
													<%
														if (footer_sign_3_splty == 1){
													%>
													<tr><td class='label'>
														<span style='font-size: 12px'><strong><span style='color: #808080'>
														<%
														if (footer_sign_3_practid == 1){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=attendPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_3_practid == 2){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=admitPractSplty%> &nbsp;</span>
														<%
														}
														if (footer_sign_3_practid == 3){
														%>
															<span style='font-family: verdana, geneva, sans-serif'><%=authPractSplty%> &nbsp;</span>
														<%
														}
														%>											
														</span></strong></span>
													</td></tr>
													<%
													}
													%>
												</tbody>
											</table>
										</td>
									<%										
									}
									%>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<%		
								}
							}
						}
					%>	
									
				</tbody> 
				<tfoot  id="table_footer"> 		
					<tr><th>	
						<%= htmlFooterString%>							
					</th> </tr> 
				</tfoot>
			</table>
		</form>
	</body>
</html>

