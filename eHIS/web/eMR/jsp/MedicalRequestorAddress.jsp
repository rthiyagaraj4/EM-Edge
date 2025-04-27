
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%


	Connection con			= null;
	Properties prts			= (java.util.Properties) session.getValue("jdbc");
	String facilityId		= (String)session.getValue("facility_id");
	String locale			= (String)session.getAttribute("LOCALE");
	String RelationShipType = checkForNull(request.getParameter("RelationShipType"));	
	String Requestor_Type	= checkForNull(request.getParameter("requestor_Type"));	
	String call_function	= checkForNull(request.getParameter("call_function"));	
	String patient_id		= checkForNull(request.getParameter("patient_id"));	
	//'Oth_appl_postal_desc'String reln_type		= checkForNull(request.getParameter("reln_type"));	
	String request_id		= checkForNull(request.getParameter("request_id"));	
	String requestor_code	= checkForNull(request.getParameter("requestor_code"));	
	String indicator		= checkForNull(request.getParameter("requestor_Type"));	
	String mode				= checkForNull(request.getParameter("mode"));
	String disp_appl_addr_line1		= ""; 
	String disp_appl_addr_line2		= ""; 
	String disp_appl_addr_line3		= ""; 
	String disp_appl_addr_line4		= ""; 
	String disp_appl_res_town_desc	= ""; 
	String disp_appl_res_area_desc	= ""; 
	String disp_appl_region_desc	= ""; 
	String disp_appl_postal_code	= ""; 
	String disp_appl_postal_desc	= "";
	String disp_appl_country_desc	= ""; 
	
	

	//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
	String disp_contact_no1			= "";
	String disp_contact_no2			= "";
	String disp_appl_email_id		= "";

	Statement stmt = null;
	ResultSet rs = null;
	String Sql="";
	
try
{
	con = ConnectionManager.getConnection(request);
	try
	{
		if(!call_function.equals("") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
		{
			if(!patient_id.equals(""))
			{
				//Sql=" SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4, appl_area_short_desc, appl_country_long_desc, appl_postal_code,  appl_region_short_desc, appl_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and patient_id ='"+patient_id+"' and REQUEST_ID = '"+request_id+"' ";

				Sql= "SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4, mp_get_desc.MP_RES_AREA(APPL_AREA_CODE,'"+locale+"','1')appl_area_short_desc, mp_get_desc.MP_COUNTRY(APPL_COUNTRY_CODE,'"+locale+"','2')appl_country_long_desc, appl_postal_code, 				mp_get_desc.MP_POSTAL_CODE(appl_postal_code,'"+locale+"','2') appl_postal_desc, mp_get_desc.MP_REGION(appl_region_code,'"+locale+"','2')appl_region_short_desc, mp_get_desc.MP_RES_TOWN(appl_town_code,'"+locale+"','1')appl_town_short_desc, contact_no1, contact_no2, appl_email_id FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and patient_id ='"+patient_id+"' and REQUEST_ID = '"+request_id+"'"; 

				//Above query modified by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707

			}
			else
			{
				//Sql=" SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4,appl_area_short_desc,	appl_country_long_desc, appl_postal_code, appl_region_short_desc, appl_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";

				Sql= "SELECT appl_addr_line1, appl_addr_line2, appl_addr_line3, appl_addr_line4,				mp_get_desc.MP_RES_AREA(APPL_AREA_CODE,'"+locale+"','1')appl_area_short_desc,				mp_get_desc.MP_COUNTRY(APPL_COUNTRY_CODE,'"+locale+"','2')appl_country_long_desc, appl_postal_code,	mp_get_desc.MP_POSTAL_CODE(appl_postal_code,'"+locale+"','2') appl_postal_desc,			mp_get_desc.MP_REGION(appl_region_code,'"+locale+"','2')appl_region_short_desc,				mp_get_desc.MP_RES_TOWN(appl_town_code,'"+locale+"','1')appl_town_short_desc, contact_no1, contact_no2, appl_email_id FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";
				
				//Above query modified by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707



			}
			stmt	= con.createStatement();
			rs		= stmt.executeQuery(Sql);

			if(rs.next() && rs != null)
			{
				disp_appl_addr_line1	= checkForNull(rs.getString("appl_addr_line1"));
				disp_appl_addr_line2	= checkForNull(rs.getString("appl_addr_line2"));	
				disp_appl_addr_line3	= checkForNull(rs.getString("appl_addr_line3"));	
				disp_appl_addr_line4	= checkForNull(rs.getString("appl_addr_line4"));	
				disp_appl_res_town_desc	= checkForNull(rs.getString("appl_town_short_desc"));	
				disp_appl_res_area_desc	= checkForNull(rs.getString("appl_area_short_desc"));	
				disp_appl_region_desc	= checkForNull(rs.getString("appl_region_short_desc"));	
				disp_appl_postal_code	= checkForNull(rs.getString("appl_postal_code"));	
				disp_appl_postal_desc	= checkForNull(rs.getString("appl_postal_desc"));	
				disp_appl_country_desc	= checkForNull(rs.getString("appl_country_long_desc"));	

				//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
				disp_contact_no1		= checkForNull(rs.getString("contact_no1"));
				disp_contact_no2		= checkForNull(rs.getString("contact_no2"));
				disp_appl_email_id		= checkForNull(rs.getString("appl_email_id"));
			}

			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}
	}catch(Exception e) 
	{
		//out.println("Exception in Query : "+e);
		e.printStackTrace();
	}


String appl_addr_line1		= checkForNull(request.getParameter("appl_addr_line1"));
String appl_addr_line2		= checkForNull(request.getParameter("appl_addr_line2"));	
String appl_addr_line3		= checkForNull(request.getParameter("appl_addr_line3"));	
String appl_addr_line4		= checkForNull(request.getParameter("appl_addr_line4"));	
String appl_res_town_code	= checkForNull(request.getParameter("appl_res_town_code"));	
String appl_res_town_desc	= checkForNull(request.getParameter("appl_res_town_desc"));	
String appl_res_area_code	= checkForNull(request.getParameter("appl_res_area_code"));	
String appl_res_area_desc	= checkForNull(request.getParameter("appl_res_area_desc"));	
String appl_region_code		= checkForNull(request.getParameter("appl_region_code"));	
String appl_region_desc		= checkForNull(request.getParameter("appl_region_desc"));	
String appl_postal_code		= checkForNull(request.getParameter("appl_postal_code"));	

/*For others...*/
String  Oth_appl_addr_line1	= checkForNull(request.getParameter("Oth_appl_addr_line1"));
String  Oth_appl_addr_line2	= checkForNull(request.getParameter("Oth_appl_addr_line2"));
String  Oth_appl_addr_line3	= checkForNull(request.getParameter("Oth_appl_addr_line3"));
String  Oth_appl_addr_line4	= checkForNull(request.getParameter("Oth_appl_addr_line4"));
String  Oth_appl_res_town_desc	= checkForNull(request.getParameter("Oth_appl_res_town_desc"));
String  Oth_appl_res_town_code	= checkForNull(request.getParameter("Oth_appl_res_town_code"));
String  Oth_appl_res_area_desc	= checkForNull(request.getParameter("Oth_appl_res_area_desc"));
String  Oth_appl_res_area_code	= checkForNull(request.getParameter("Oth_appl_res_area_code"));
String  Oth_appl_region_desc = checkForNull(request.getParameter("Oth_appl_region_desc"));
String  Oth_appl_region_code = checkForNull(request.getParameter("Oth_appl_region_code"));
String  Oth_appl_postal_code = checkForNull(request.getParameter("Oth_appl_postal_code"));
String  Oth_appl_postal_desc = checkForNull(request.getParameter("Oth_appl_postal_desc"));
String  Oth_appl_country_desc = checkForNull(request.getParameter("Oth_appl_country_desc"));
String  Oth_appl_country_code = checkForNull(request.getParameter("Oth_appl_country_code"));

/*For Self...*/
String  self_addr_line1	= checkForNull(request.getParameter("appl_addr_line1"));
String  self_addr_line2	= checkForNull(request.getParameter("appl_addr_line2"));
String  self_addr_line3	= checkForNull(request.getParameter("appl_addr_line3"));
String  self_addr_line4	= checkForNull(request.getParameter("appl_addr_line4"));
String  self_res_town_desc	= checkForNull(request.getParameter("appl_res_town_desc"));
String  self_res_town_code	= checkForNull(request.getParameter("appl_res_town_code"));
String  self_res_area_desc	= checkForNull(request.getParameter("appl_res_area_desc"));
String  self_res_area_code	= checkForNull(request.getParameter("appl_res_area_code"));
String  self_region_desc = checkForNull(request.getParameter("appl_region_desc"));
String  self_region_code = checkForNull(request.getParameter("appl_region_code"));
String  self_postal_code = checkForNull(request.getParameter("appl_postal_code"));
String  self_postal_desc = checkForNull(request.getParameter("appl_postal_desc"));
String  self_country_desc = checkForNull(request.getParameter("appl_country_desc"));
String  self_country_code = checkForNull(request.getParameter("appl_country_code"));

/*For NKIN...*/
String  nkin_addr_line1	= checkForNull(request.getParameter("nkin_addr_line1"));
String  nkin_addr_line2	= checkForNull(request.getParameter("nkin_addr_line2"));
String  nkin_addr_line3	= checkForNull(request.getParameter("nkin_addr_line3"));
String  nkin_addr_line4	= checkForNull(request.getParameter("nkin_addr_line4"));
String  nkin_res_town_desc	= checkForNull(request.getParameter("nkin_res_town_desc"));
String  nkin_res_town_code	= checkForNull(request.getParameter("nkin_res_town_code"));
String  nkin_res_area_desc	= checkForNull(request.getParameter("nkin_res_area_desc"));
String  nkin_res_area_code	= checkForNull(request.getParameter("nkin_res_area_code"));
String  nkin_region_desc = checkForNull(request.getParameter("nkin_region_desc"));
String  nkin_region_code = checkForNull(request.getParameter("nkin_region_code"));
String  nkin_postal_code = checkForNull(request.getParameter("nkin_postal_code"));
String  nkin_postal_desc = checkForNull(request.getParameter("nkin_postal_desc"));
String  nkin_country_desc = checkForNull(request.getParameter("nkin_country_desc"));
String  nkin_country_code = checkForNull(request.getParameter("nkin_country_code"));

/*For FTON...*/
String  fton_addr_line1	= checkForNull(request.getParameter("fton_addr_line1"));
String  fton_addr_line2	= checkForNull(request.getParameter("fton_addr_line2"));
String  fton_addr_line3	= checkForNull(request.getParameter("fton_addr_line3"));
String  fton_addr_line4	= checkForNull(request.getParameter("fton_addr_line4"));
String  fton_res_town_desc	= checkForNull(request.getParameter("fton_res_town_desc"));
String  fton_res_town_code	= checkForNull(request.getParameter("fton_res_town_code"));
String  fton_res_area_desc	= checkForNull(request.getParameter("fton_res_area_desc"));
String  fton_res_area_code	= checkForNull(request.getParameter("fton_res_area_code"));
String  fton_region_desc = checkForNull(request.getParameter("fton_region_desc"));
String  fton_region_code = checkForNull(request.getParameter("fton_region_code"));
String  fton_postal_code = checkForNull(request.getParameter("fton_postal_code"));
String  fton_postal_desc = checkForNull(request.getParameter("fton_postal_desc"));
String  fton_country_desc = checkForNull(request.getParameter("fton_country_desc"));
String  fton_country_code = checkForNull(request.getParameter("fton_country_code"));

/*For EMPLR...*/
String  emplr_addr_line1	= checkForNull(request.getParameter("emplr_addr_line1"));
String  emplr_addr_line2	= checkForNull(request.getParameter("emplr_addr_line2"));
String  emplr_addr_line3	= checkForNull(request.getParameter("emplr_addr_line3"));
String  emplr_addr_line4	= checkForNull(request.getParameter("emplr_addr_line4"));
String  emplr_res_town_desc	= checkForNull(request.getParameter("emplr_res_town_desc"));
String  emplr_res_town_code	= checkForNull(request.getParameter("emplr_res_town_code"));
String  emplr_res_area_desc	= checkForNull(request.getParameter("emplr_res_area_desc"));
String  emplr_res_area_code	= checkForNull(request.getParameter("emplr_res_area_code"));
String  emplr_region_desc = checkForNull(request.getParameter("emplr_region_desc"));
String  emplr_region_code = checkForNull(request.getParameter("emplr_region_code"));
String  emplr_postal_code = checkForNull(request.getParameter("emplr_postal_code"));
String  emplr_postal_desc = checkForNull(request.getParameter("emplr_postal_desc"));
String  emplr_country_desc = checkForNull(request.getParameter("emplr_country_desc"));
String  emplr_country_code = checkForNull(request.getParameter("emplr_country_code"));

/*for personal Delivery address...*/
String personal_del_addr_line1		= checkForNull(request.getParameter("personal_del_addr_line1"));	
String personal_del_addr_line2		= checkForNull(request.getParameter("personal_del_addr_line2"));	
String personal_del_addr_line3		= checkForNull(request.getParameter("personal_del_addr_line3"));	
String personal_del_addr_line4		= checkForNull(request.getParameter("personal_del_addr_line4"));	
String personal_del_res_town_code	= checkForNull(request.getParameter("personal_del_res_town_code"));	
String personal_del_res_town_desc	= checkForNull(request.getParameter("personal_del_res_town_desc"));	
String personal_del_res_area_code	= checkForNull(request.getParameter("personal_del_res_area_code"));	
String personal_del_res_area_desc	= checkForNull(request.getParameter("personal_del_res_area_desc"));	
String personal_del_region_code		= checkForNull(request.getParameter("personal_del_region_code"));	
String personal_del_region_desc		= checkForNull(request.getParameter("personal_del_region_desc"));	
String personal_del_postal_code		= checkForNull(request.getParameter("personal_del_postal_code"));
String personal_del_postal_desc		= checkForNull(request.getParameter("personal_del_postal_desc"));
String personal_del_country_desc	= checkForNull(request.getParameter("personal_del_country_desc"));
String personal_del_country_code	= checkForNull(request.getParameter("personal_del_country_code"));

/*for other Delivery address...*/
String other_del_addr_line1			= checkForNull(request.getParameter("other_del_addr_line1"));	
String other_del_addr_line2			= checkForNull(request.getParameter("other_del_addr_line2"));	
String other_del_addr_line3			= checkForNull(request.getParameter("other_del_addr_line3"));	
String other_del_addr_line4			= checkForNull(request.getParameter("other_del_addr_line4"));	
String other_del_res_town_code		= checkForNull(request.getParameter("other_del_res_town_code"));	
String other_del_res_town_desc		= checkForNull(request.getParameter("other_del_res_town_desc"));	
String other_del_res_area_code		= checkForNull(request.getParameter("other_del_res_area_code"));	
String other_del_res_area_desc		= checkForNull(request.getParameter("other_del_res_area_desc"));	
String other_del_region_code		= checkForNull(request.getParameter("other_del_region_code"));	
String other_del_region_desc		= checkForNull(request.getParameter("other_del_region_desc"));	
String other_del_postal_code		= checkForNull(request.getParameter("other_del_postal_code"));
String other_del_postal_desc		= checkForNull(request.getParameter("other_del_postal_desc"));
String other_del_country_desc		= checkForNull(request.getParameter("other_del_country_desc"));
String other_del_country_code		= checkForNull(request.getParameter("other_del_country_code"));

/*For REQUESTOR...*/
String  requestor_addr_line1	= checkForNull(request.getParameter("requestor_addr_line1"));
String  requestor_addr_line2	= checkForNull(request.getParameter("requestor_addr_line2"));
String  requestor_addr_line3	= checkForNull(request.getParameter("requestor_addr_line3"));
String  requestor_addr_line4	= checkForNull(request.getParameter("requestor_addr_line4"));
String  requestor_res_town_desc	= checkForNull(request.getParameter("requestor_res_town_desc"));
String  requestor_res_town_code	= checkForNull(request.getParameter("requestor_res_town_code"));
String  requestor_res_area_desc	= checkForNull(request.getParameter("requestor_res_area_desc"));
String  requestor_res_area_code	= checkForNull(request.getParameter("requestor_res_area_code"));
String  requestor_region_desc = checkForNull(request.getParameter("requestor_region_desc"));
String  requestor_region_code = checkForNull(request.getParameter("requestor_region_code"));
String  requestor_postal_code = checkForNull(request.getParameter("requestor_postal_code"));
String  requestor_postal_desc = checkForNull(request.getParameter("requestor_postal_desc"));
String  requestor_country_desc = checkForNull(request.getParameter("requestor_country_desc"));
String  requestor_country_code = checkForNull(request.getParameter("requestor_country_code"));

/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/

String  self_contact_no1	= checkForNull(request.getParameter("self_contact_no1"));
String  self_contact_no2	= checkForNull(request.getParameter("self_contact_no2"));
String  self_appl_email_id  = checkForNull(request.getParameter("self_appl_email_id"));

String  nkin_contact_no1	= checkForNull(request.getParameter("nkin_contact_no1"));
String  nkin_contact_no2	= checkForNull(request.getParameter("nkin_contact_no2"));
String  nkin_appl_email_id  = checkForNull(request.getParameter("nkin_appl_email_id"));

String  fton_contact_no1	= checkForNull(request.getParameter("fton_contact_no1"));
String  fton_contact_no2	= checkForNull(request.getParameter("fton_contact_no2"));
String  fton_appl_email_id  = checkForNull(request.getParameter("fton_appl_email_id"));

String  emplr_contact_no1	= checkForNull(request.getParameter("emplr_contact_no1"));
String  emplr_contact_no2	= checkForNull(request.getParameter("emplr_contact_no2"));
String  emplr_appl_email_id	= checkForNull(request.getParameter("emplr_appl_email_id"));

String  other_contact_no1	= checkForNull(request.getParameter("other_contact_no1"));
String  other_contact_no2	= checkForNull(request.getParameter("other_contact_no2"));
String  other_appl_email_id	= checkForNull(request.getParameter("other_appl_email_id"));

String  requestor_contact_no1	= checkForNull(request.getParameter("requestor_contact_no1"));
String  requestor_contact_no2	= checkForNull(request.getParameter("requestor_contact_no2"));
String  requestor_appl_email_id = checkForNull(request.getParameter("requestor_appl_email_id"));

/*ML-MMOH-CRF-0707*/

if((call_function.equals("MEDICAL_REPORT_REQUEST") && mode.equals("insert")) || (call_function.equals("MEDICAL_BOARD_REQUEST") && mode.equals("insert")))
{
	try
	{
		StringBuffer sqlBuff = new StringBuffer();
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		if(sqlBuff.length() > 0) sqlBuff.delete(0,sqlBuff.length());
		/*sqlBuff.append(" SELECT addr_line1, addr_line2, addr_line3, addr_line4, town_code,town_short_desc, area_code, area_short_desc, region_code, region_short_desc, postal_code, postal_short_desc, country_code, country_name, contact1_no, contact2_no, email_id ");
		sqlBuff.append(" FROM MR_REQUESTOR_VW where facility_id = '"+facilityId+"' and INDICATOR = '"+indicator+"' and requestor_code = '"+requestor_code+"' ");
		*/

		sqlBuff.append(" SELECT addr_line1, addr_line2, addr_line3, addr_line4, town_code,"); sqlBuff.append("mp_get_desc.MP_RES_TOWN(Town_Code,'"+locale+"','1') town_short_desc,"); 
		sqlBuff.append("area_code, mp_get_desc.MP_RES_AREA(Area_Code,'"+locale+"','1') area_short_desc,");
		sqlBuff.append("region_code, mp_get_desc.MP_REGION(Region_Code,'"+locale+"','2') region_short_desc,");
		sqlBuff.append("postal_code, mp_get_desc.MP_POSTAL_CODE(Postal_Code,'"+locale+"','2') postal_short_desc,");
		sqlBuff.append("country_code, mp_get_desc.MP_COUNTRY(country_code,'"+locale+"','2') country_name,");
		sqlBuff.append("contact1_no, contact2_no, email_id FROM   MR_REQUESTOR_VW WHERE  facility_id = '"+facilityId+"' AND INDICATOR = '"+indicator+"' AND requestor_code = '"+requestor_code+"'");

		
		stmt= con.createStatement();
		rs	= stmt.executeQuery(sqlBuff.toString());

		if(rs.next() && rs != null)
		{
			requestor_addr_line1	= checkForNull(rs.getString("addr_line1"));
			requestor_addr_line2	= checkForNull(rs.getString("addr_line2"));
			requestor_addr_line3	= checkForNull(rs.getString("addr_line3"));
			requestor_addr_line4	= checkForNull(rs.getString("addr_line4"));
			requestor_res_town_desc	= checkForNull(rs.getString("town_short_desc"));
			requestor_res_town_code	= checkForNull(rs.getString("town_code"));
			requestor_res_area_desc	= checkForNull(rs.getString("area_short_desc"));
			requestor_res_area_code	= checkForNull(rs.getString("area_code"));
			requestor_region_desc	= checkForNull(rs.getString("region_short_desc"));
			requestor_region_code	= checkForNull(rs.getString("region_code"));
			requestor_postal_code	= checkForNull(rs.getString("postal_code"));
			requestor_postal_desc	= checkForNull(rs.getString("postal_short_desc"));
			requestor_country_desc	= checkForNull(rs.getString("country_name"));
			requestor_country_code	= checkForNull(rs.getString("country_code"));
			

			//Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707
			
			requestor_contact_no1	= checkForNull(rs.getString("contact1_no"));
			
			requestor_contact_no2	= checkForNull(rs.getString("contact2_no"));
			
			requestor_appl_email_id	= checkForNull(rs.getString("email_id"));
			
		}

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception e) 
	{
		//out.println("Exception in Query 3 : "+e);
		e.printStackTrace();
	}
}


String[] contact_col_names = null ;
String[] contact_prompts = null ;
String[] contact_fields = null ;
ArrayList contact_addr = fetchContactAddresses(con, out,"parent.messageFrame",prts) ;
contact_col_names = (String[])contact_addr.get(1) ;
contact_prompts   = (String[])contact_addr.get(2) ;
contact_fields    = (String[])contact_addr.get(3) ;
contact_addr = null;

%>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	
	
<!-- 	<script src='../js/Requestor.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 -->
<script>

async function searchCountry(obj,target)
{
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code" || obj.name=="r_country_desc")
	{
		if(target.name=="r_country_desc")
		{
			tit=getLabel("Common.country.label","Common");
			
			sql="Select country_code code,long_name description from MP_COUNTRY_LANG_VW where language_id = '"+locale+"' and eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) and eff_status = 'E'";
		}
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'r_country_desc')
		document.forms[0].r_country_desc.value= arr[1];
		document.forms[0].r_country_code.value=arr[0];
	}
	else
	{
		target.value='';
	}
}

function CloseME()
{
	var condition = '';

	if(document.forms[0].r_addr_line1)
		condition += document.forms[0].r_addr_line1.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line2)
		condition += document.forms[0].r_addr_line2.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line3)
		condition += document.forms[0].r_addr_line3.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line4)
		condition += document.forms[0].r_addr_line4.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_town_code)
	{
		condition += document.forms[0].r_town_code.value +"~";
		condition += document.forms[0].r_town.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

	if(document.forms[0].r_area_code)
	{	
		condition += document.forms[0].r_area_code.value +"~";
		condition += document.forms[0].r_area.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

	if(document.forms[0].r_region_code)
	{
		condition += document.forms[0].r_region_code.value +"~";
		condition += document.forms[0].r_region.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}
	
	if(document.forms[0].r_postal_code1)
	{
		condition += document.forms[0].r_postal_code1.value +"~";
		condition += document.forms[0].r_postal_code.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

		condition += document.forms[0].r_country_desc.value +"~";
		condition += document.forms[0].r_country_code.value +"~";

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		condition += document.forms[0].r_contactno_1.value +"~";
		condition += document.forms[0].r_contactno_2.value +"~";
		condition += document.forms[0].r_emailid.value +"~";
		/*ML-MMOH-CRF-0707*/

	window.returnValue=condition;
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
	//window.close();
}


</script>
</head>

<body onKeyDown='lockKey()'>
<form name="address_form" id="address_form" >
	<table cellspacing=0 border='0' cellpadding=2 align='center' width='100%'>
 		<th  colspan='2'>&nbsp;&nbsp;&nbsp;<th> 
		<%  
		
			for(int i=0;i<contact_col_names.length; i++)
			{
				out.println("<tr>") ;                                    
				out.println("<td class='label' align='right' width='50%' nowrap>"+contact_prompts[i]+"&nbsp;&nbsp</td>") ;
				String val  = contact_fields[i] ;
				StringBuffer sb1 = new StringBuffer(val);

				StringBuffer fieldVal = new StringBuffer("");
				for(int z=0;z<val.length();z++)
				{
					String tempVal=sb1.substring(z,z+1);
					if(tempVal.equals("@"))
					{
						fieldVal.append("");
					}
					else
					{
						fieldVal.append(tempVal);
					}
				}

				val = fieldVal.toString();
				out.println("<td class='label' width='50%'>&nbsp;&nbsp;&nbsp;&nbsp;"+val+"</td>");
			}

		%>
		<tr>
			<td align='right' class='label' ><fmt:message key="Common.country.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class='label' width='50%'>&nbsp;&nbsp;&nbsp;&nbsp;<input align='left' type='text' name='r_country_desc' id='r_country_desc' size='20' maxlength='20'  onblur='if(this.value !="")searchCountry(contry_code,r_country_desc);'  value=''><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,r_country_desc)'>
			<input type='hidden' name='r_country_code' id='r_country_code' value=''>
		   </td>
		</tr>
		
		<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
		<tr>
			<td align='right' class='label' ><fmt:message key="eMR.ContactNumber.label" bundle="${mr_labels}"/></td>
 			<td class='label' width='50%'>&nbsp;&nbsp;&nbsp;&nbsp;<input align='left' type='text' maxlength='20' name='r_contactno_1' id='r_contactno_1' value='' size='20'> / <input align='left' type='text' maxlength='20' name='r_contactno_2' id='r_contactno_2' value='' size='20'> 
			</td>
		</tr>
		<tr>
			<td align='right' class='label' ><fmt:message key="Common.email.label" bundle="${common_labels}"/></td>
			<td class='label' width='50%'>&nbsp;&nbsp;&nbsp;&nbsp;<input align='left' type='text' maxlength='50' name='r_emailid' id='r_emailid' value='' size='40'> 
			</td>
		</tr>
		<!--End ML-MMOH-CRF-0707-->
		<tr>
			<td >&nbsp;&nbsp;</td><td align='right'>&nbsp;&nbsp;<input type='button' class ='button' onclick='CloseME()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" name='Close' id='Close'></td>
		</tr> 

		<input type='hidden' name='postal_code' id='postal_code'>
		<input type='hidden' name='town_code' id='town_code'>
		<input type='hidden' name='region_code' id='region_code'>
		<input type='hidden' name='area_code' id='area_code'>
		<input type='hidden' name='r_area' id='r_area' value=''>
		<input type='hidden' name='r_town' id='r_town' value=''>
		<input type='hidden' name='r_region' id='r_region' value=''>
		<input type='hidden' name='r_postal_code' id='r_postal_code' value=''>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		
		<tr><td class=label colspan='4' height='5%'>&nbsp;</td></tr>
		<tr><td class=label colspan='4' height='5%'>&nbsp;</td></tr>
		<tr><td class=label colspan='4' height='5%'>&nbsp;</td></tr>
		<tr><td class=label colspan='4' height='5%'>&nbsp;</td></tr>
		<tr><td class=label colspan='4' height='5%'>&nbsp;</td></tr>

	</table>
	<script>
		if(document.forms[0].r_addr_line1)
		document.forms[0].r_addr_line1.value = "<%=appl_addr_line1%>";

		if(document.forms[0].r_addr_line2)
		document.forms[0].r_addr_line2.value = "<%=appl_addr_line2%>";

		if(document.forms[0].r_addr_line3)
		document.forms[0].r_addr_line3.value = "<%=appl_addr_line3%>";

		if(document.forms[0].r_addr_line4)
		document.forms[0].r_addr_line4.value = "<%=appl_addr_line4%>";

		if(document.forms[0].r_town_code)
		{
			document.forms[0].r_town_code.value = "<%=appl_res_town_desc%>";
			document.forms[0].r_town.value = "<%=appl_res_town_code%>";
		}

		if(document.forms[0].r_area_code)
		{
			document.forms[0].r_area_code.value = "<%=appl_res_area_desc%>";
			document.forms[0].r_area.value = "<%=appl_res_area_code%>";
		}

		if(document.forms[0].r_region_code)
		{
			document.forms[0].r_region_code.value = "<%=appl_region_desc%>";
			document.forms[0].r_region.value = "<%=appl_region_code%>";
		}

		if(document.forms[0].r_postal_code1)
		{
			document.forms[0].r_postal_code1.value = "<%=appl_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=appl_postal_code%>";
		}

	</script>

<%	
	if(!Requestor_Type.equals(""))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements(i).disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=requestor_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=requestor_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=requestor_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=requestor_addr_line4%>";

			if(document.forms[0].r_town_code)
			{
				document.forms[0].r_town_code.value = "<%=requestor_res_town_desc%>";
				document.forms[0].r_town.value = "<%=requestor_res_town_code%>";
			}
			if(document.forms[0].r_area_code)
			{
				document.forms[0].r_area_code.value = "<%=requestor_res_area_desc%>";
				document.forms[0].r_area.value = "<%=requestor_res_area_code%>";
			}
			if(document.forms[0].r_region_code)
			{
				document.forms[0].r_region_code.value = "<%=requestor_region_desc%>";
				document.forms[0].r_region.value = "<%=requestor_region_code%>";
			}
			if(document.forms[0].r_postal_code1)
			{
				document.forms[0].r_postal_code1.value = "<%=requestor_postal_code%>";
				document.forms[0].r_postal_code.value = "<%=requestor_postal_code%>";
			}
			document.forms[0].r_country_desc.value = "<%=requestor_country_desc%>";
			document.forms[0].r_country_code.value = "<%=requestor_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=requestor_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=requestor_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=requestor_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}	
	if(RelationShipType.equals("Self"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}
			document.forms[0].Close.disabled = false;

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=self_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=self_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=self_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=self_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=self_res_town_desc%>";
			document.forms[0].r_town.value = "<%=self_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=self_res_area_desc%>";
			document.forms[0].r_area.value = "<%=self_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=self_region_desc%>";
			document.forms[0].r_region.value = "<%=self_region_code%>";

			

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=self_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=self_postal_code%>";*/
			
			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=self_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=self_postal_code%>";



			document.forms[0].r_country_desc.value = "<%=self_country_desc%>";
			document.forms[0].r_country_code.value = "<%=self_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=self_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=self_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=self_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}else if(RelationShipType.equals("Others"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=Oth_appl_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=Oth_appl_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=Oth_appl_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=Oth_appl_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=Oth_appl_res_town_desc%>";
			document.forms[0].r_town.value = "<%=Oth_appl_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=Oth_appl_res_area_desc%>";
			document.forms[0].r_area.value = "<%=Oth_appl_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=Oth_appl_region_desc%>";
			document.forms[0].r_region.value = "<%=Oth_appl_region_code%>";

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=Oth_appl_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=Oth_appl_postal_code%>";*/

			

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=Oth_appl_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=Oth_appl_postal_code%>";

			document.forms[0].r_country_desc.value = "<%=Oth_appl_country_desc%>";
			document.forms[0].r_country_code.value = "<%=Oth_appl_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=other_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=other_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=other_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}else if(RelationShipType.equals("FTON"))
	{ %>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=fton_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=fton_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=fton_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=fton_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=fton_res_town_desc%>";
			document.forms[0].r_town.value = "<%=fton_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=fton_res_area_desc%>";
			document.forms[0].r_area.value = "<%=fton_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=fton_region_desc%>";
			document.forms[0].r_region.value = "<%=fton_region_code%>";

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=fton_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=fton_postal_code%>";*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=fton_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=fton_postal_code%>";

			document.forms[0].r_country_desc.value = "<%=fton_country_desc%>";
			document.forms[0].r_country_code.value = "<%=fton_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=fton_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=fton_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=fton_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}else if(RelationShipType.equals("NKIN"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=nkin_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=nkin_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=nkin_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=nkin_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=nkin_res_town_desc%>";
			document.forms[0].r_town.value = "<%=nkin_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=nkin_res_area_desc%>";
			document.forms[0].r_area.value = "<%=nkin_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=nkin_region_desc%>";
			document.forms[0].r_region.value = "<%=nkin_region_code%>";

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=nkin_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=nkin_postal_code%>";
			*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=nkin_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=nkin_postal_code%>";

			document.forms[0].r_country_desc.value = "<%=nkin_country_desc%>";
			document.forms[0].r_country_code.value = "<%=nkin_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=nkin_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=nkin_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=nkin_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}else if(RelationShipType.equals("EMPLR"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=emplr_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=emplr_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=emplr_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=emplr_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=emplr_res_town_desc%>";
			document.forms[0].r_town.value = "<%=emplr_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=emplr_res_area_desc%>";
			document.forms[0].r_area.value = "<%=emplr_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=emplr_region_desc%>";
			document.forms[0].r_region.value = "<%=emplr_region_code%>";

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=emplr_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=emplr_postal_code%>";*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=emplr_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=emplr_postal_code%>";

			document.forms[0].r_country_desc.value = "<%=emplr_country_desc%>";
			document.forms[0].r_country_code.value = "<%=emplr_country_code%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].r_contactno_1.value = "<%=emplr_contact_no1%>";
			document.forms[0].r_contactno_2.value = "<%=emplr_contact_no2%>";
			document.forms[0].r_emailid.value	  = "<%=emplr_appl_email_id%>";
			/*ML-MMOH-CRF-0707*/

		</script>
<%	}else if(RelationShipType.equals("PersonalDeliveryAddress"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=personal_del_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=personal_del_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=personal_del_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=personal_del_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=personal_del_res_town_desc%>";
			document.forms[0].r_town.value = "<%=personal_del_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=personal_del_res_area_desc%>";
			document.forms[0].r_area.value = "<%=personal_del_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=personal_del_region_desc%>";
			document.forms[0].r_region.value = "<%=personal_del_region_code%>";

			
			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=personal_del_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=personal_del_postal_code%>";*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=personal_del_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=personal_del_postal_code%>";
		
			document.forms[0].r_country_desc.value = "<%=personal_del_country_desc%>";
			document.forms[0].r_country_code.value = "<%=personal_del_country_code%>";
	
		</script>
<%	}else if(RelationShipType.equals("OtherDeliveryAddress"))
	{	%>
		<script>
			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = false;
			}

			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=other_del_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=other_del_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=other_del_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=other_del_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=other_del_res_town_desc%>";
			document.forms[0].r_town.value = "<%=other_del_res_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=other_del_res_area_desc%>";
			document.forms[0].r_area.value = "<%=other_del_res_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=other_del_region_desc%>";
			document.forms[0].r_region.value = "<%=other_del_region_code%>";
			
			
			//other_del_postal_desc
			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=other_del_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=other_del_postal_code%>";*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=other_del_postal_desc%>";
			document.forms[0].r_postal_code.value = "<%=other_del_postal_code%>";
		
			document.forms[0].r_country_desc.value = "<%=other_del_country_desc%>";
			document.forms[0].r_country_code.value = "<%=other_del_country_code%>";
	
		</script>
	<%	}


//else if(!call_function.equals("") && !call_function.equals("MEDICAL_BOARD_REQUEST"))

	if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_BOARD_REQUEST") && !RelationShipType.equals("OtherDeliveryAddress") && !RelationShipType.equals("PersonalDeliveryAddress"))
	{	
		%>
		<script>
			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=disp_appl_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=disp_appl_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=disp_appl_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=disp_appl_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=disp_appl_res_town_desc%>";
//			document.forms[0].r_town.value = "<disp_appl_res_town_code>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=disp_appl_res_area_desc%>";
//			document.forms[0].r_area.value = "<disp_appl_res_area_code>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=disp_appl_region_desc%>";
//			document.forms[0].r_region.value = "<disp_appl_region_code>";

			

			/*if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=disp_appl_postal_code%>";*/

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=disp_appl_postal_desc%>";
			
//			document.forms[0].r_postal_code.value = "<disp_appl_postal_code>";
		
			document.forms[0].r_country_desc.value = "<%=disp_appl_country_desc%>";

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			
			document.forms[0].r_contactno_1.value = "<%=disp_contact_no1%>";

			document.forms[0].r_contactno_2.value = "<%=disp_contact_no2%>";

			document.forms[0].r_emailid.value = "<%=disp_appl_email_id%>";

			/*ML-MMOH-CRF-0707*/

		</script>
<%//		if(!call_function.equals("DELIVER_MEDICAL_REPORT"))
	//	{	%>
			<script>
				for(var i=0; i<document.forms[0].length;i++)
				{
					document.forms[0].elements[i].disabled = true;
				}
				document.forms[0].Close.disabled = false;
			</script>
	<%//	}	%>

<%	}

	if((call_function.equals("MEDICAL_BOARD_COMPLETED") || call_function.equals("MEDICAL_REPORT_COMPLETED") ) && (RelationShipType.equals("OtherDeliveryAddress") || RelationShipType.equals("PersonalDeliveryAddress") ))
	{	
		
		//String DeliverSql=" SELECT posted_addr_line1, posted_addr_line2, posted_addr_line3, posted_addr_line4, posted_area_code, posted_area_short_desc, posted_country_code, posted_country_long_desc, posted_postal_code, posted_postal_short_desc, posted_region_code, posted_region_short_desc, posted_town_code, posted_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE  facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";

		String DeliverSql=" SELECT posted_addr_line1, posted_addr_line2, posted_addr_line3,posted_addr_line4, posted_area_code, MP_GET_DESC.MP_RES_AREA(POSTED_AREA_CODE,'"+locale+"','1') posted_area_short_desc,	posted_country_code,MP_GET_DESC.MP_COUNTRY(POSTED_COUNTRY_CODE,'"+locale+"','1') posted_country_long_desc,posted_postal_code, MP_GET_DESC.MP_POSTAL_CODE(POSTED_REGION_CODE,'"+locale+"','2')	posted_postal_short_desc, posted_region_code, MP_GET_DESC.MP_REGION(POSTED_REGION_CODE,'"+locale+"','2') posted_region_short_desc, posted_town_code, MP_GET_DESC.MP_RES_TOWN(POSTED_TOWN_CODE,'"+locale+"','1') posted_town_short_desc FROM MR_REPORT_REQUEST_HDR_VW WHERE facility_id='"+facilityId+"' and REQUEST_ID = '"+request_id+"' ";
		
	

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(DeliverSql);

		if(rs.next() && rs != null)
		{
			String posted_addr_line1	= checkForNull(rs.getString("posted_addr_line1"));
			String posted_addr_line2	= checkForNull(rs.getString("posted_addr_line2"));
			String posted_addr_line3	= checkForNull(rs.getString("posted_addr_line3"));
			String posted_addr_line4	= checkForNull(rs.getString("posted_addr_line4"));
			String posted_area_code		= checkForNull(rs.getString("posted_area_code"));
			String posted_area_short_desc	= checkForNull(rs.getString("posted_area_short_desc"));
			String posted_country_code	= checkForNull(rs.getString("posted_country_code"));
			String posted_country_long_desc	= checkForNull(rs.getString("posted_country_long_desc"));
			String posted_postal_code	= checkForNull(rs.getString("posted_postal_code"));
//			String posted_postal_short_desc	= checkForNull(rs.getString("posted_postal_short_desc"));
			String posted_region_code	= checkForNull(rs.getString("posted_region_code"));
			String posted_region_short_desc	= checkForNull(rs.getString("posted_region_short_desc"));
			String posted_town_code	= checkForNull(rs.getString("posted_town_code"));
			String posted_town_short_desc	= checkForNull(rs.getString("posted_town_short_desc"));
		%>
		<script>
			if(document.forms[0].r_addr_line1)
			document.forms[0].r_addr_line1.value = "<%=posted_addr_line1%>";

			if(document.forms[0].r_addr_line2)
			document.forms[0].r_addr_line2.value = "<%=posted_addr_line2%>";

			if(document.forms[0].r_addr_line3)
			document.forms[0].r_addr_line3.value = "<%=posted_addr_line3%>";

			if(document.forms[0].r_addr_line4)
			document.forms[0].r_addr_line4.value = "<%=posted_addr_line4%>";

			if(document.forms[0].r_town_code)
			document.forms[0].r_town_code.value = "<%=posted_town_short_desc%>";
			document.forms[0].r_town.value = "<%=posted_town_code%>";

			if(document.forms[0].r_area_code)
			document.forms[0].r_area_code.value = "<%=posted_area_short_desc%>";
			document.forms[0].r_area.value = "<%=posted_area_code%>";

			if(document.forms[0].r_region_code)
			document.forms[0].r_region_code.value = "<%=posted_region_short_desc%>";
			document.forms[0].r_region.value = "<%=posted_region_code%>";

			if(document.forms[0].r_postal_code1)
			document.forms[0].r_postal_code1.value = "<%=posted_postal_code%>";
			document.forms[0].r_postal_code.value = "<%=posted_postal_code%>";
		
			document.forms[0].r_country_desc.value = "<%=posted_country_long_desc%>";
			document.forms[0].r_country_code.value = "<%=posted_country_code%>";

			for(var i=0; i<document.forms[0].length;i++)
			{
				document.forms[0].elements[i].disabled = true;
			}
			document.forms[0].Close.disabled = false;
		</script>
<%	}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
}	%>

<%	if(!Requestor_Type.equals(""))
	{	
		if(!call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MEDICAL_BOARD_REQUEST"))
		{	
			%>
			<script>
				for(var i=0; i<document.forms[0].length;i++)
				{
					document.forms[0].elements[i].disabled = true;
				}
				document.forms[0].Close.disabled = false;
			</script>
	<%	}	
	}

}catch(Exception e)
{
	//out.println("Exception in MedicalRequestorAddress.jsp"+e.toString());
	e.printStackTrace();
}
finally
{
	if ( con != null ) ConnectionManager.returnConnection(con,request);
}
	%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

