<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckInLodger && CheckOutLodger
/// Developer		:	SRIDHAR R
/// Created on		:	30 JULY 2004
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
    
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src='../../eCommon/js/CommonCalendar.js' language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../js/CheckinLodger.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<script> 

</script> 
<%

	String openWindow = checkForNull(request.getParameter("openWindow"));
	if(openWindow.equals("NO"))
	{
		out.println("<script>parent.window.close();</script>");
	}
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	//Statement PatIDStmt		= null;
	//ResultSet PatIDRS		= null;			
	Statement stmt			= null;
	ResultSet rs			= null;
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;
	Statement ParamStmt		= null;
	ResultSet ParamRS		= null;
	
	String locale			= (String)session.getAttribute("LOCALE");
	  
	String facility_id		= (String)session.getValue ( "facility_id" ) ;
	String loginUser		= (String)session.getValue("login_user");
	String p_oper_stn_id	= checkForNull(request.getParameter("oper_stn_id"));
	String encounter_id		= checkForNull(request.getParameter("EncounterId"));
 	
	String Category			= request.getParameter("Category");
	if(Category == null)  Category = "L" ;

	String mode = request.getParameter("mode") ;
	if( mode == null )  mode = "insert" ;

	StringBuffer sql			= new StringBuffer();
	String years				= "";
	String months				= "";
	String days					= "";
	String lodger_patient_name	= "";
	String reason_for_stay		= "";
	String alt_long_desc		= "";
	String check_in_date_time	= "";
	String Period_date_time_from= "";
	String Period_date_time_to	= "";
	String Period_dat_dis_tim_fr= "";
	String Period_dat_dis_tim_to= "";
	String authorized_by		= "";  
	String nursing_desc			= "";
	String patientID			= "";
	String rdonly				= "";
	String sysdateTime			= "";
	String lodger_ref_no		= "";			
	String remarks				= "";                			
	String patient_id			= "";
	String lodger_relation_code = "";
	String nameprefix			= "";
	String firstname			= "";
	String secondname			= "";
	String thirdname			= "";
	String familyname			= "";
	String namesuffix			= "";
	String gender				= "";
	String date_of_birth		= "";
	String place_of_birth_code	= "";
	String place_of_birth_desc	= "";
	String citizen				= "";
	String legal				= "";
	String email_id				= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String oth_alt_id_no		= ""; 
	String oth_alt_id_type		= "";
	String res_addr_line1		= "";
	String res_addr_line2		= "";
	String res_addr_line3		= "";
	String res_addr_line4		= "";
	String res_town_code		= "";
	String res_town_desc		= "";
	String res_area_code		= "";
	String res_area_desc		= "";
	String res_region_code		= "";
	String res_region_desc		= "";
	String postal_code			= "";
	String postal_code_desc		= "";
	String country_code			= "";
	String mail_addr_line1		= "";
	String mail_addr_line2		= "";
	String mail_addr_line3		= "";
	String mail_addr_line4		= "";
	String mail_country_code	= "";
	String mail_country_desc	= "";
	String mail_town_code		= "";
	String mail_town_desc		= "";
	String mail_area_code		= "";
	String mail_area_desc		= "";
	String mail_region_code		= "";	
	String mail_region_desc		= "";
	String mail_postal_code		= "";
	String mail_postal_code_desc= "";
	String other_tel_no			= "";
	String oth_contact_no		= "";
	String eth_grp				= "";
	String race_desc			= "";
	String ethnic_description	= "";
	String nationality_code		= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String nationality_long_desc= "";
	String Lodger_Max_RefNo		= "";
	String Lodger_Next_RefNo	= "";
	String Lodger_Period		= "";	
	String Acc_Period			= "";
	String Acc_Period_unit		= "";
	String name_prefix_loc_lang	= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang	= "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String name_suffix_loc_lang	= "";
	String lodger_name_loc_lang = "";

	/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1	= "";
	String alt_addr_line2	= "";
	String alt_addr_line3	= "";
	String alt_addr_line4	= "";
	String alt_postal_code  = "";
	String alt_postal_desc  = "";
	String alt_country_code = "";
	String alt_country_desc = "";
	String alt_area_code	= "";
	String alt_area_desc	= "";
	String alt_town_code	= "";
	String alt_town_desc	= "";
	String alt_region_code	= "";
	String alt_region_desc	= "";
	/*End*/

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	String currDate = dateFormat.format( dt ) ;
	String min = String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
	check_in_date_time = currDate ;   

	String patientId = checkForNull(request.getParameter("patientId"));

	try
	{
		con						= ConnectionManager.getConnection(request);
		StringBuffer paramSql	= new StringBuffer();
		paramSql.append(" select to_char(sysdate,'dd/mm/rrrr hh24:mi')sdate, LODGER_MAX_SRL_NO, LODGER_NEXT_SRL_NO, MAX_STAY_OF_LODGER_AFTER_DISC, DFLT_GATE_PASS_PERIOD, DFLT_GATE_PASS_UNIT from ip_param where facility_ID='"+facility_id+"' ");
		ParamStmt				= con.createStatement();
		ParamRS					= ParamStmt.executeQuery( paramSql.toString() );

		if(ParamRS!=null)
		{
			if ( ParamRS.next() )
			{
				sysdateTime			= ParamRS.getString("sdate");
				Lodger_Max_RefNo	= checkForNull(ParamRS.getString("LODGER_MAX_SRL_NO"));
				Lodger_Next_RefNo	= checkForNull(ParamRS.getString("LODGER_NEXT_SRL_NO"));
				Lodger_Period		= checkForNull(ParamRS.getString("MAX_STAY_OF_LODGER_AFTER_DISC"));
				Acc_Period			= checkForNull(ParamRS.getString("DFLT_GATE_PASS_PERIOD"));
				Acc_Period_unit		= checkForNull(ParamRS.getString("DFLT_GATE_PASS_UNIT"));
			}
		}

			if(ParamStmt != null) ParamStmt.close();
			if(ParamRS != null) ParamRS.close();
/* Thursday, June 10, 2010 venkats PE_EXE 
		int count=0;
		StringBuffer patIDSql = new StringBuffer();
		patIDSql.append(" select a.lodger_patient_id lodger_patient_id,a.lodger_ref_no lodger_ref_no, b.revised_yn revised_yn from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.lodger_ref_no=b.lodger_ref_no and a.lodger_patient_id is not null ");
		PatIDStmt = con.createStatement();
		PatIDRS = PatIDStmt.executeQuery( patIDSql.toString() );

		if(PatIDRS != null)
		{
			while( PatIDRS.next() )
			{
				count++;
			}
		}
		if(PatIDRS!=null)PatIDRS.close();
		if(PatIDStmt!=null)PatIDStmt.close();
	*/
if( mode.equals("update") )  
{
	lodger_ref_no	= checkForNull(request.getParameter("lodger_ref_no"));
	nursing_desc	= checkForNull(request.getParameter("nursing_desc"));
	patientID		= checkForNull(request.getParameter("PatID"));
	
	StringBuffer ExeSQL = new StringBuffer();
	
	ExeSQL.append(" SELECT a.PATIENT_ENCOUNTER_ID,");
	ExeSQL.append(" a.LODGER_RELATION_CODE,");
	ExeSQL.append(" a.REASON_FOR_STAY_CODE,");
	ExeSQL.append(" a.LODGER_NAME,");
	ExeSQL.append(" to_char(a.check_in_date_time,'dd/mm/rrrr hh24:mi')CHECK_IN_DATE_TIME,");
	ExeSQL.append(" to_char(a.PERIOD_FROM_DATE,'dd/mm/rrrr hh24:mi')PERIOD_FROM_DATE,");
	ExeSQL.append(" to_char(a.PERIOD_TO_DATE,'dd/mm/rrrr hh24:mi')PERIOD_TO_DATE,");
	ExeSQL.append(" a.ATTACHED_TO_INPATIENT_YN,");
	ExeSQL.append(" a.NURSING_UNIT_CODE,a.REMARKS,a.AUTHORISED_BY,a.LODGER_GENDER,");
	ExeSQL.append(" to_char(a.LODGER_DOB,'dd/mm/rrrr')LODGER_DOB,");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),1)years, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),2)months, ");
	ExeSQL.append(" calculate_age(to_char(LODGER_DOB,'dd/mm/rrrr'),3)days, ");
	ExeSQL.append(" get_age(a.LODGER_DOB) DOB, ");
	ExeSQL.append(" a.NAME_PREFIX, a.FIRST_NAME, a.SECOND_NAME, a.THIRD_NAME,");
	ExeSQL.append(" a.FAMILY_NAME, a.NAME_SUFFIX,");
	ExeSQL.append(" a.CITIZEN_YN, a.LEGAL_YN,");
	ExeSQL.append(" a.ALT_ID1_TYPE,a.ALT_ID1_NO,");
	ExeSQL.append(" to_char(a.ALT_ID1_EXP_DATE,'dd/mm/rrrr')ALT_ID1_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID2_TYPE,a.ALT_ID2_NO,");
	ExeSQL.append(" to_char(a.ALT_ID2_EXP_DATE,'dd/mm/rrrr')ALT_ID2_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID3_TYPE, a.ALT_ID3_NO,");
	ExeSQL.append(" to_char(a.ALT_ID3_EXP_DATE,'dd/mm/rrrr')ALT_ID3_EXP_DATE,");
	ExeSQL.append(" a.ALT_ID4_TYPE, a.ALT_ID4_NO,");
	ExeSQL.append(" to_char(a.ALT_ID4_EXP_DATE,'dd/mm/rrrr')ALT_ID4_EXP_DATE,");
	ExeSQL.append(" a.OTH_ALT_ID_TYPE OTH_ALT_ID_TYPE,");
	ExeSQL.append(" (CASE WHEN a.OTH_ALT_ID_TYPE IS NOT NULL THEN (mp_get_desc.mp_alternate_id_type(a.OTH_ALT_ID_TYPE,'"+locale+"',1)) END) alt_short_desc,");
	ExeSQL.append(" a.OTH_ALT_ID_NO OTH_ALT_ID_NO,");
	ExeSQL.append(" a.LN1_LODGER_ADD, a.LN2_LODGER_ADD,");
	ExeSQL.append(" a.LN3_LODGER_ADD, a.LN4_LODGER_ADD,");
	ExeSQL.append(" a.LODGER_RES_TEL_NUM, a.LODGER_OFF_TEL_NUM,"); 
	ExeSQL.append(" a.MAIL_ADDR_LINE1, a.MAIL_ADDR_LINE2,");
	ExeSQL.append(" a.MAIL_ADDR_LINE3, a.MAIL_ADDR_LINE4,");
	ExeSQL.append(" a.lodger_patient_id, a.national_id_no,");
	ExeSQL.append(" a.BIRTH_PLACE_CODE BIRTH_PLACE_CODE, (CASE WHEN a.BIRTH_PLACE_CODE IS NOT NULL THEN (mp_get_desc.MP_BIRTH_PLACE(a.BIRTH_PLACE_CODE,'"+locale+"',1)) END) birth_place_desc,");
	ExeSQL.append(" a.ETHNIC_GROUP_CODE, (CASE WHEN a.ETHNIC_GROUP_CODE IS NOT NULL THEN (mp_get_desc.MP_ETHNIC_GROUP(a.ETHNIC_GROUP_CODE,'"+locale+"',1)) END) ETHNIC_DESCRIPTION,");
	ExeSQL.append(" a.RACE_CODE, ");
	ExeSQL.append("(CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END) MAIL_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_REGION_CODE MAIL_REGION_CODE,  (CASE WHEN a.MAIL_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.MAIL_REGION_CODE,'"+locale+"',1)) END) MAIL_REGION_DESCRIPTION,");
	ExeSQL.append(" a.MAIL_POSTAL_CODE MAIL_POSTAL_CODE, mp_get_desc.mp_postal_code(a.mail_postal_code,'"+locale+"',2)mail_postal_code_desc,");
	ExeSQL.append(" a.MAIL_COUNTRY_CODE, (CASE WHEN a.MAIL_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.MAIL_COUNTRY_CODE,'"+locale+"',1)) END) MAIL_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.RES_AREA_CODE RES_AREA_CODE , (CASE WHEN a.RES_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.RES_AREA_CODE,'"+locale+"',1)) END) RES_AREA_DESCRIPTION,");
	ExeSQL.append(" a.RES_TOWN_CODE RES_TOWN_CODE, (CASE WHEN a.RES_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.RES_TOWN_CODE,'"+locale+"',1)) END) RES_TOWN_DESCRIPTION,");
	ExeSQL.append(" a.RES_REGION_CODE RES_REGION_CODE, (CASE WHEN a.RES_REGION_CODE IS NOT NULL THEN (mp_get_desc.MP_REGION(a.RES_REGION_CODE,'"+locale+"',1)) END) RES_REGION_DESCRIPTION,");
	ExeSQL.append(" a.RES_POSTAL_CODE RES_POSTAL_DESCRIPTION,mp_get_desc.mp_postal_code(a.res_postal_code,'"+locale+"',2)res_postal_code_desc,");
	ExeSQL.append(" a.RES_COUNTRY_CODE, (CASE WHEN a.RES_COUNTRY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.RES_COUNTRY_CODE,'"+locale+"',1)) END) RES_COUNTRY_DESCRIPTION,");
	ExeSQL.append(" a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc,");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
	ExeSQL.append(" a.LODGER_EMAIL,");
	ExeSQL.append(" (CASE WHEN a.NATIONALITY_CODE IS NOT NULL THEN (mp_get_desc.MP_COUNTRY(a.NATIONALITY_CODE,'"+locale+"',1)) END) NATIONALITY_DESC, a.NATIONALITY_CODE NATIONALITY_CODE");  
	ExeSQL.append("  , NAME_PREFIX_LOC_LANG ");
	ExeSQL.append("  , FIRST_NAME_LOC_LANG ");
	ExeSQL.append("  , SECOND_NAME_LOC_LANG ");
	ExeSQL.append("  , THIRD_NAME_LOC_LANG ");
	ExeSQL.append("  , FAMILY_NAME_LOC_LANG ");
	ExeSQL.append("  , NAME_SUFFIX_LOC_LANG ");
	ExeSQL.append("  , LODGER_NAME_LOC_LANG ");
	ExeSQL.append(" FROM ");
	ExeSQL.append(" IP_LODGER_DETAIL a");
	ExeSQL.append(" WHERE ");
	ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
	ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' "); 
	
	stmt = con.createStatement();
	rs = stmt.executeQuery(ExeSQL.toString());

	if(rs!=null && rs.next())
	{
		rdonly = "readonly" ;

		Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
		if(Category.equals("Y"))
			Category = "A" ;
		else
			Category = "L" ;

		years	= rs.getString( "years" );
			if(years ==null)	years ="";
		months  = rs.getString( "months" );
			if(months ==null)	months ="";
		days    = rs.getString( "days" );
			if(days ==null)	days ="";

		encounter_id         = String.valueOf( rs.getLong("patient_encounter_id") );
		if(encounter_id ==null)
			encounter_id ="";

		lodger_relation_code     = rs.getString( "lodger_relation_code" );
		if(lodger_relation_code ==null)
			lodger_relation_code ="";

		reason_for_stay      = rs.getString( "reason_for_stay_code" );
		if(reason_for_stay ==null)
			reason_for_stay ="";

		lodger_patient_name  = rs.getString( "lodger_name" );
		if(lodger_patient_name ==null)
			lodger_patient_name ="";

		check_in_date_time   = rs.getString( "check_in_date_time" );
		 if(check_in_date_time == null)  check_in_date_time = "";

		Period_date_time_from = rs.getString("PERIOD_FROM_DATE"); 
			if(Period_date_time_from == null)	Period_date_time_from = "";

		Period_date_time_to = rs.getString("PERIOD_TO_DATE"); 
			if(	Period_date_time_to == null)	Period_date_time_to = "";
		
		Period_dat_dis_tim_fr = DateUtils.convertDate(Period_date_time_from,"DMYHM","en",locale);
		Period_dat_dis_tim_to = DateUtils.convertDate(Period_date_time_to,"DMYHM","en",locale);

		remarks   = rs.getString( "REMARKS" );
			if(remarks ==null)     remarks ="";

		if (!remarks.equals("")) 
		{
			if (remarks.length() == 200)
				remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,200);
			else if (remarks.length() > 140)
				remarks = 	remarks.substring(0,70)+"\n"+remarks.substring(71,140)+"\n"+remarks.substring(141,remarks.length());
			else if (remarks.length() > 70)
				remarks = remarks.substring(0,70)+"\n"+remarks.substring(71,remarks.length());	
		}

			authorized_by      = rs.getString( "authorised_by" );
			if(authorized_by ==null)		authorized_by ="";  

			gender       = rs.getString( "lodger_gender" );
			if(gender==null) gender="";

			date_of_birth    = rs.getString( "LODGER_DOB" );
			if(date_of_birth==null) 
				date_of_birth = "";
			else
				date_of_birth = DateUtils.convertDate(date_of_birth,"DMY","en",locale);

			nameprefix= rs.getString( "NAME_PREFIX" );
			if(nameprefix==null) nameprefix = "";

			firstname= rs.getString( "FIRST_NAME" );
			if(firstname==null) firstname="";

			secondname= rs.getString( "SECOND_NAME");
			if(secondname==null) secondname="";

			thirdname= rs.getString( "THIRD_NAME" );
			if(thirdname==null) thirdname="";

			familyname = rs.getString( "FAMILY_NAME" );
			if(familyname == null) familyname = "";

			namesuffix= rs.getString( "NAME_SUFFIX" );
			if(namesuffix==null) namesuffix="";

			citizen = rs.getString("CITIZEN_YN");
			if(citizen == null) citizen = "";

			legal = rs.getString("LEGAL_YN");
			if(legal == null) legal = "";

			alt_id1_exp_date= rs.getString( "ALT_ID1_EXP_DATE");
			if(alt_id1_exp_date==null)
				alt_id1_exp_date="";
			else
				alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY","en",locale);

			alt_id2_exp_date= rs.getString( "ALT_ID2_EXP_DATE" );
			if(alt_id2_exp_date==null) 
				alt_id2_exp_date="";
			else
				alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY","en",locale);

			alt_id3_exp_date= rs.getString( "ALT_ID3_EXP_DATE" );
			if(alt_id3_exp_date==null) 
				alt_id3_exp_date="";
			else
				alt_id3_exp_date = DateUtils.convertDate(alt_id3_exp_date,"DMY","en",locale);

			alt_id4_exp_date= rs.getString( "ALT_ID4_EXP_DATE" );
			if(alt_id4_exp_date==null) 
				alt_id4_exp_date="";
			else
				alt_id4_exp_date = DateUtils.convertDate(alt_id4_exp_date,"DMY","en",locale);

			alt_id1_no= rs.getString( "ALT_ID1_NO" );
			if(alt_id1_no==null) alt_id1_no="";

			alt_id2_no	= rs.getString( "ALT_ID2_NO" );
			if(alt_id2_no==null) alt_id2_no="";

			alt_id3_no= rs.getString( "ALT_ID3_NO" );
			if(alt_id3_no==null) alt_id3_no="";

			alt_id4_no= rs.getString( "ALT_ID4_NO" );
			if(alt_id4_no==null) alt_id4_no="";

			oth_alt_id_no = rs.getString( "OTH_ALT_ID_NO" );
			if(oth_alt_id_no==null) oth_alt_id_no = "";

			oth_alt_id_type = rs.getString( "OTH_ALT_ID_TYPE" );
			if(oth_alt_id_type == null) oth_alt_id_type = "";

			alt_long_desc = rs.getString( "alt_short_desc" );
			if(alt_long_desc == null) alt_long_desc = "";

			place_of_birth_desc = rs.getString( "birth_place_desc" );
			if(place_of_birth_desc == null) place_of_birth_desc = "";

			place_of_birth_code = rs.getString( "BIRTH_PLACE_CODE" );
			if(place_of_birth_code == null) place_of_birth_code = "";

			eth_grp= rs.getString( "ETHNIC_GROUP_CODE" );
			if(eth_grp==null) eth_grp="";

			race_desc= rs.getString( "RACE_DESCRIPTION" );
			if(race_desc==null) race_desc="";

			ethnic_description= rs.getString( "ETHNIC_DESCRIPTION" );
			if(ethnic_description==null) ethnic_description="";

			national_id_no= rs.getString( "NATIONAL_ID_NO" );
			if(national_id_no==null) national_id_no="";

			nationality_code = rs.getString( "NATIONALITY_CODE" );
			if(nationality_code==null) nationality_code="";

			nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
			if(nationality_long_desc  == null) nationality_long_desc  = "";

			// RESIDENCE ADDRESS & CONTACT DETAILS 
			res_addr_line1  = rs.getString( "LN1_LODGER_ADD" );
			if(res_addr_line1==null) res_addr_line1="";

			res_addr_line2  = rs.getString( "LN2_LODGER_ADD" );
			if(res_addr_line2==null) res_addr_line2="";

			res_addr_line3  = rs.getString( "LN3_LODGER_ADD" );
			if(res_addr_line3==null) res_addr_line3="";

			res_addr_line4  = rs.getString( "LN4_LODGER_ADD" );
			if(res_addr_line4==null) res_addr_line4="";

			res_town_code= rs.getString( "RES_TOWN_CODE" );
			if(res_town_code==null) res_town_code="";

			res_town_desc= rs.getString( "RES_TOWN_DESCRIPTION" );
			if(res_town_desc==null) res_town_desc="";

			res_area_code= rs.getString( "RES_AREA_CODE" );
			if(res_area_code==null) res_area_code="";

			res_area_desc= rs.getString( "RES_AREA_DESCRIPTION" );
			if(res_area_desc==null) res_area_desc="";

			res_region_code		= rs.getString("RES_REGION_CODE");
			if(res_region_code==null) res_region_code="";

			res_region_desc		= rs.getString("RES_REGION_DESCRIPTION");
			if(res_region_desc==null) res_region_desc="";

			postal_code= rs.getString( "RES_POSTAL_DESCRIPTION" );
			if(postal_code==null) postal_code="";
			
			postal_code_desc= rs.getString( "res_postal_code_desc" );
			if(postal_code_desc==null) postal_code_desc="";

			country_code= rs.getString( "RES_COUNTRY_DESCRIPTION" );
			if(country_code==null) country_code="";

			// MAILING ADDRESS & CONTACT DETAILS 
			mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
			if(mail_addr_line1==null) mail_addr_line1="";

			mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
			if(mail_addr_line2==null) mail_addr_line2="";

			mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
			if(mail_addr_line3==null) mail_addr_line3="";

			mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
			if(mail_addr_line4==null) mail_addr_line4="";

			mail_town_code		= rs.getString("MAIL_TOWN_CODE");
			if(mail_town_code==null) mail_town_code="";

			mail_town_desc		= rs.getString("MAIL_TOWN_DESCRIPTION");
			if(mail_town_desc==null) mail_town_desc="";

			mail_area_code		= rs.getString("MAIL_AREA_CODE");
			if(mail_area_code==null) mail_area_code="";

			mail_area_desc		= rs.getString("MAIL_AREA_DESCRIPTION");
			if(mail_area_desc==null) mail_area_desc="";

			mail_region_code	= rs.getString("MAIL_REGION_CODE");
			if(mail_region_code==null) mail_region_code="";

			mail_region_desc	= rs.getString("MAIL_REGION_DESCRIPTION");
			if(mail_region_desc==null) mail_region_desc="";

			mail_postal_code	= rs.getString("MAIL_POSTAL_CODE");
			if(mail_postal_code==null) mail_postal_code="";

			mail_postal_code_desc	= rs.getString("mail_postal_code_desc");
			if(mail_postal_code_desc==null) mail_postal_code_desc="";

			mail_country_code	= rs.getString("MAIL_COUNTRY_CODE");
			if(mail_country_code==null) mail_country_code="";

			mail_country_desc	= rs.getString("MAIL_COUNTRY_DESCRIPTION");
			if(mail_country_desc==null) mail_country_desc="";

			// TEL NO & EMAIL-ID DETAILS 
			oth_contact_no       = rs.getString( "lodger_off_tel_num" );
			if(oth_contact_no ==null)		oth_contact_no ="";  

			other_tel_no       = rs.getString( "lodger_res_tel_num" );
			if(other_tel_no ==null)		other_tel_no ="";  

			email_id= rs.getString( "LODGER_EMAIL" );
			if(email_id==null) email_id="";

			String DOB= rs.getString( "DOB" );
			if(DOB==null) DOB="";

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(rs.getString("alt_area_code"));
			alt_area_desc		= checkForNull(rs.getString("alt_area_desc"));
			alt_town_code		= checkForNull(rs.getString("alt_town_code"));
			alt_town_desc		= checkForNull(rs.getString("alt_town_desc"));
			alt_region_code		= checkForNull(rs.getString("alt_region_code"));
			alt_region_desc		= checkForNull(rs.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(rs.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(rs.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(rs.getString("alt_country_code"));
			alt_country_desc	= checkForNull(rs.getString("alt_country_desc"));
			/*End*/

			name_prefix_loc_lang	= checkForNull(rs.getString("name_prefix_loc_lang"));
			first_name_loc_lang		= checkForNull(rs.getString("first_name_loc_lang"));
			second_name_loc_lang	= checkForNull(rs.getString("second_name_loc_lang"));
			third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang"));
			family_name_loc_lang	= checkForNull(rs.getString("family_name_loc_lang"));
			name_suffix_loc_lang	= checkForNull(rs.getString("name_suffix_loc_lang"));
			lodger_name_loc_lang	= checkForNull(rs.getString("LODGER_NAME_LOC_LANG"));
	}
}
%>

</head>

<body onLoad= 'FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='LodgerForm' id='LodgerForm' method='post' action='../../servlet/eIP.BookLodgerServlet' target='messageFrame'>
	<input type="hidden" name="hddCitizen" id="hddCitizen" value="<%=citizen%>" >
	<input type="hidden" name="hddLegal" id="hddLegal" value="<%=legal%>" >
	<input type='hidden' name='Lodger_Disc_Period' id='Lodger_Disc_Period' value= "<%=Lodger_Period%>">
	<input type='hidden' name='Lodger_Disc_Period_unit' id='Lodger_Disc_Period_unit' value= "H">
	<input type='hidden' name='Acc_Disc_Period' id='Acc_Disc_Period' value= "<%=Acc_Period%>">
	<input type='hidden' name='Acc_Disc_Period_unit' id='Acc_Disc_Period_unit' value= "<%=Acc_Period_unit%>">
	<input type='hidden' name='function_id' id='function_id' <%if(mode.equals("insert")){%>value= "CHECK_IN_LODGER"<%}else{%>value= "CHECK_OUT_LODGER"<%}%> >

<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
	<tr>
	<%	if(Category.equals("A"))
		{
		   out.println( "<td colspan='4' class='columnheader' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</td>" ) ;
		}
		else
		{
		   out.println( "<td colspan='4' class='COLUMNHEADER' 	align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerDetails.label","ip_labels")+"</td>" ) ;
		}	%>
	</tr>

<!-- ###### ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP ####### -->
<tr>
	<td colspan='4'>
<%	if(mode.equals("insert"))
	{	%>
		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="patient_id" value= "" /> 	
		<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
		<jsp:param name ="readonly_yn" value= "Y" /> 		
		<jsp:param name ="bodyFrame" value= "parent.frames[0]" /> 	
		<jsp:param name ="submitFrame" value= "parent.frames[1]" /> 	
		</jsp:include>
		<script>
			document.forms[0].patient_id.value		= "<%=patientId%>";
			checkPatient(document.forms[0].patient_id)
			document.forms[0].patient_id.disabled	= true;
			document.forms[0].search.disabled		= true;
			//setTimeout('disman()',1000);
	   		document.LodgerForm.race_desc.disabled = true;
			document.LodgerForm.race_desc_id.disabled = true;
		</script>
<%	}
	else
	{	%>	
		<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name ="patient_id" value= "<%=patientId%>" /> 	
		<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
		<jsp:param name ="readonly_yn" value= "Y" /> 		
		<jsp:param name ="bodyFrame" value= "parent.frames[0]"  /> 	
		<jsp:param name ="submitFrame" value= "parent.frames[1]"  />   
		</jsp:include>
<%	}	%>
	</td>  
</tr>   
</table>



<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->
<%
if(!mode.equals("insert")) 
{

%>
  <script>

		document.LodgerForm.patient_id.value 	= "<%=patientID%>";
		document.LodgerForm.patient_id.disabled = true;
		document.LodgerForm.search.disabled		= true;
		
		document.getElementById('patient_name1').innerHTML	= "<%=lodger_patient_name%>";
		
		document.getElementById('patient_name1').disabled	= true;

		/*Friday, July 03, 2009 modified for IN012078*/
		/*if(document.LodgerForm.name_prefix1)
		{
		
			document.LodgerForm.name_prefix1.value 		= "<%=nameprefix%>";
			document.LodgerForm.name_prefix1.disabled	= true;
		}*/
		if(document.LodgerForm.name_prefix)
		{
		
			document.LodgerForm.name_prefix.value 		= "<%=nameprefix%>";
			document.LodgerForm.name_prefix.disabled	= true;
		}
		
		
		if(document.LodgerForm.family_name)
		{
		document.LodgerForm.family_name.value 		= "<%=familyname%>";
		document.LodgerForm.family_name.disabled	= true;
		if(document.LodgerForm.bfam)
		document.LodgerForm.bfam.disabled	= true;//added by  munisekhar  for [IN:046231]
		
		
		}

		if(document.LodgerForm.first_name)
		{
			document.LodgerForm.first_name.value 	= "<%=firstname%>";
			document.LodgerForm.first_name.disabled = true;
			if(document.LodgerForm.bf)
			document.LodgerForm.bf.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.second_name)
		{
			document.LodgerForm.second_name.value 	= "<%=secondname%>";
			document.LodgerForm.second_name.disabled= true;
			if(document.LodgerForm.bs)
			document.LodgerForm.bs.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.third_name)
		{
			document.LodgerForm.third_name.value 	= "<%=thirdname%>";
			document.LodgerForm.third_name.disabled = true;
			if(document.LodgerForm.bt)
			document.LodgerForm.bt.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		/*Friday, July 03, 2009 modified for IN012078*/
		/*if(document.LodgerForm.name_suffix1)
		{
		
			document.LodgerForm.name_suffix1.value 	= "<%=namesuffix%>";
			document.LodgerForm.name_suffix1.disabled= true;
		}*/

		if(document.LodgerForm.name_suffix)
		{
		
			document.LodgerForm.name_suffix.value 	= "<%=namesuffix%>";
			document.LodgerForm.name_suffix.disabled= true;
		}
		


		if(document.LodgerForm.name_prefix_oth_lang)
	    {
			document.LodgerForm.name_prefix_oth_lang.value 	= "<%=name_prefix_loc_lang%>";
			document.LodgerForm.name_prefix_oth_lang.disabled = true;
		}

		if(document.LodgerForm.first_name_oth_lang)
	    {
			document.LodgerForm.first_name_oth_lang.value 	= "<%=first_name_loc_lang%>";
			document.LodgerForm.first_name_oth_lang.disabled = true;
			if(document.LodgerForm.bfo)
			document.LodgerForm.bfo.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.second_name_oth_lang)
	    {
			document.LodgerForm.second_name_oth_lang.value 	= "<%=second_name_loc_lang%>";
			document.LodgerForm.second_name_oth_lang.disabled = true;
			if(document.LodgerForm.bso)
			document.LodgerForm.bso.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.third_name_oth_lang)
	    {
			document.LodgerForm.third_name_oth_lang.value 	= "<%=third_name_loc_lang%>";
			document.LodgerForm.third_name_oth_lang.disabled = true;
			if(document.LodgerForm.bto)
			document.LodgerForm.bto.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.family_name_oth_lang)
	    {
			document.LodgerForm.family_name_oth_lang.value 	= "<%=family_name_loc_lang%>";
			document.LodgerForm.family_name_oth_lang.disabled = true;
			if(document.LodgerForm.bfamo)
			document.LodgerForm.bfamo.disabled	= true;//added by  munisekhar  for [IN:046231]
		}

		if(document.LodgerForm.name_suffix_oth_lang)
	    {
			document.LodgerForm.name_suffix_oth_lang.value 	= "<%=name_suffix_loc_lang%>";
			document.LodgerForm.name_suffix_oth_lang.disabled = true;
		}

		document.getElementById('patient_name_local_lang1').innerText 	= "<%=lodger_name_loc_lang%>";
		document.LodgerForm.patient_name_local_lang.value 	= "<%=lodger_name_loc_lang%>";

		document.LodgerForm.sex.value 		= "<%=gender%>";
		document.LodgerForm.sex.disabled	= true;

		document.LodgerForm.date_of_birth.value = "<%=date_of_birth%>";
		document.LodgerForm.date_of_birth.onblur();
		document.LodgerForm.date_of_birth.disabled = true;

		document.LodgerForm.b_birth.disabled	= true;
		document.getElementById('dob').disabled				= true;
		document.LodgerForm.b_age.disabled		= true;
		document.LodgerForm.b_months.disabled	= true;
		document.LodgerForm.b_days.disabled		= true;

		document.LodgerForm.Birth_place_code.value 	= "<%=place_of_birth_code%>";
	
		if((document.LodgerForm.Birth_place_code.value == null) || (document.LodgerForm.Birth_place_code.value == ""))
		{	
			document.LodgerForm.place_of_birth.value = "<%= place_of_birth_desc%>";
		}else
		document.LodgerForm.birth_place.value = "<%= place_of_birth_desc%>";

		document.LodgerForm.birth_place.disabled	= true;
		document.LodgerForm.place_of_birth.disabled	= true;

		document.LodgerForm.nationality_code1.value = "<%=nationality_code%>";
		document.LodgerForm.nationality_desc.value	= "<%=nationality_long_desc%>";
		document.LodgerForm.nationality_desc.disabled= true;
		document.LodgerForm.nationality_id.disabled = true;

		document.LodgerForm.national_id_no.value 	= "<%=national_id_no%>";
		document.LodgerForm.national_id_no.disabled = true;

		if(document.LodgerForm.myKadBtn)
			document.LodgerForm.myKadBtn.disabled = true;

		if(document.LodgerForm.alt_id1_no)
		{
			document.LodgerForm.alt_id1_no.value 	= "<%=alt_id1_no%>";
			document.LodgerForm.alt_id1_no.disabled = true;
		}
		if(document.LodgerForm.alt_id2_no)
		{
			document.LodgerForm.alt_id2_no.value 	= "<%=alt_id2_no%>";
			document.LodgerForm.alt_id2_no.disabled = true;
		}
		if(document.LodgerForm.alt_id3_no)
		{
			document.LodgerForm.alt_id3_no.value 	= "<%=alt_id3_no%>";
			document.LodgerForm.alt_id3_no.disabled = true;
		}
		if(document.LodgerForm.alt_id4_no)
		{
			document.LodgerForm.alt_id4_no.value 	= "<%=alt_id4_no%>";
			document.LodgerForm.alt_id4_no.disabled = true;
		}
		if(document.LodgerForm.alt_id1_exp_date)
		{
			document.LodgerForm.alt_id1_exp_date.value 	= "<%=alt_id1_exp_date%>";
			document.LodgerForm.alt_id1_exp_date.disabled = true;
		}
		
		if(document.LodgerForm.alt_id2_exp_date)
		{
			document.LodgerForm.alt_id2_exp_date.value 	= "<%=alt_id2_exp_date%>";
			document.LodgerForm.alt_id2_exp_date.disabled = true;
		}
		if(document.LodgerForm.alt_id3_exp_date)
		{	
			document.LodgerForm.alt_id3_exp_date.value = "<%=alt_id3_exp_date%>";
			document.LodgerForm.alt_id3_exp_date.disabled = true;
		}
		if(document.LodgerForm.alt_id4_exp_date)
		{
			document.LodgerForm.alt_id4_exp_date.value = "<%=alt_id4_exp_date%>";
			document.LodgerForm.alt_id4_exp_date.disabled = true;
		}
		if(document.LodgerForm.other_alt_type)
		{
			document.LodgerForm.other_alt_type.value = "<%=oth_alt_id_type%>";
			document.LodgerForm.other_alt_type.disabled = true;
		}
		if(document.LodgerForm.other_alt_Id)
		{
			document.LodgerForm.other_alt_Id.value = "<%=oth_alt_id_no%>";
			document.LodgerForm.other_alt_Id.disabled = true;
		}

		/*
		var obj =document.forms[0].race_code;
		var opt= document.createElement('Option');
		opt.text="<%=race_desc%>"; 
		obj.add(opt)
		opt.selected = true;
		document.LodgerForm.race_code.disabled = true;
		*/

		if(document.forms[0].race_desc)
		{
 			document.forms[0].race_desc.value="<%=race_desc%>";
			document.LodgerForm.race_desc.disabled = true;
			document.LodgerForm.race_desc_id.disabled = true;
		}

/*		// For populating Ethnicity...
		var n = document.forms[0].ethnic_group.options.length;
		for(var i=0;i<n;i++)
		document.forms[0].ethnic_group.remove("ethnic_group");
		var Ethobj =document.forms[0].ethnic_group;
		var Ethopt= document.createElement('Option');
		Ethopt.text="<%=ethnic_description%>"; 
		Ethobj.add(Ethopt)
		Ethobj.selected = true;
*/
		document.LodgerForm.ethnic_group.value = "<%=eth_grp%>";
		document.LodgerForm.ethnic_group.disabled = true;

		if(document.LodgerForm.hddCitizen.value == "Y")
			document.LodgerForm.citizen_yn[0].checked = true;
		else
			document.LodgerForm.citizen_yn[1].checked = true;

		document.LodgerForm.citizen_yn[0].disabled = true;		
		document.LodgerForm.citizen_yn[1].disabled = true;		

		if(document.LodgerForm.hddLegal.value == "Y")
			document.LodgerForm.legal_yn[0].checked = true;
		else
			document.LodgerForm.legal_yn[1].checked = true;

		document.LodgerForm.legal_yn[0].disabled = true;		
		document.LodgerForm.legal_yn[1].disabled = true;		

		// Patient contact details popup 
		// to disable the Contact Detail Button
		document.LodgerForm.addr_line1.value="<%=res_addr_line1%>";
		document.LodgerForm.addr_line1.disabled = true;

		document.LodgerForm.addr_line2.value="<%=res_addr_line2%>";
		document.LodgerForm.addr_line2.disabled = true;

		document.LodgerForm.addr_line3.value="<%=res_addr_line3%>";
		document.LodgerForm.addr_line3.disabled = true;

		document.LodgerForm.addr_line4.value="<%=res_addr_line4%>";
		document.LodgerForm.addr_line4.disabled = true;

		document.LodgerForm.res_town_code.value="<%=res_town_code%>";
		document.LodgerForm.res_town_desc.value="<%=res_town_desc%>";

		document.LodgerForm.res_area_code.value="<%=res_area_code%>";
		document.LodgerForm.res_area_desc.value="<%=res_area_desc%>";

		document.LodgerForm.region_code.value="<%=res_region_code%>";
		document.LodgerForm.region_desc.value="<%=res_region_desc%>";		

		document.LodgerForm.postal_code.value="<%=postal_code%>";
		document.LodgerForm.r_postal_code_desc.value="<%=postal_code_desc%>";

		document.LodgerForm.country_desc.value="<%=country_code%>";

		document.LodgerForm.contact1_name.value='';

		document.LodgerForm.addr2_type.value='';

		document.LodgerForm.mail_addr_line1.value="<%=mail_addr_line1%>";
		document.LodgerForm.mail_addr_line1.disabled = true;

		document.LodgerForm.mail_addr_line2.value="<%=mail_addr_line2%>";
		document.LodgerForm.mail_addr_line2.disabled = true;

		document.LodgerForm.mail_addr_line3.value="<%=mail_addr_line3%>";
		document.LodgerForm.mail_addr_line3.disabled = true;

		document.LodgerForm.mail_addr_line4.value="<%=mail_addr_line4%>";
		document.LodgerForm.mail_addr_line4.disabled = true;

		document.LodgerForm.mail_res_town_code.value="<%=mail_town_code%>";
		document.LodgerForm.mail_res_town_desc.value="<%=mail_town_desc%>";

		document.LodgerForm.mail_res_area_code.value="<%=mail_area_code%>";
		document.LodgerForm.mail_res_area_desc.value="<%=mail_area_desc%>";

		document.LodgerForm.mail_postal_code.value		= "<%=mail_postal_code%>";
		document.LodgerForm.m_postal_code_desc.value="<%=mail_postal_code_desc%>";
		document.LodgerForm.mail_region_code.value		= "<%=mail_region_code%>";
		document.LodgerForm.mail_region_desc.value		= "<%=mail_region_desc%>";
		document.LodgerForm.mail_region_desc.readOnly	= true; 

		document.LodgerForm.mail_country_code.value	= "<%=mail_country_code%>";
		document.LodgerForm.mail_country_desc.value	= "<%=mail_country_desc%>";

		document.LodgerForm.contact2_name.value	= "";
		document.LodgerForm.contact1_no.value	= "<%=other_tel_no%>";		
		document.LodgerForm.contact2_no.value	= "<%=oth_contact_no%>";
		document.LodgerForm.email.value			= "<%=email_id%>";
		
		/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		document.LodgerForm.alt_addr_line1.value	= "<%=alt_addr_line1%>";
		document.LodgerForm.alt_addr_line1.disabled = true;
		document.LodgerForm.alt_addr_line2.value	= "<%=alt_addr_line2%>";
		document.LodgerForm.alt_addr_line2.disabled = true;
		document.LodgerForm.alt_addr_line3.value	= "<%=alt_addr_line3%>";
		document.LodgerForm.alt_addr_line3.disabled = true;
		document.LodgerForm.alt_addr_line4.value	= "<%=alt_addr_line4%>";
		document.LodgerForm.alt_addr_line4.disabled = true;
		document.LodgerForm.alt_area_code.value		= "<%=alt_area_code%>";
		document.LodgerForm.alt_area_desc.value		= "<%=alt_area_desc%>";
		document.LodgerForm.alt_town_code.value		= "<%=alt_town_code%>";
		document.LodgerForm.alt_town_desc.value		= "<%=alt_town_desc%>";
		document.LodgerForm.alt_postal_code.value	= "<%=alt_postal_code%>";
		document.LodgerForm.alt_postal_desc.value	= "<%=alt_postal_desc%>";
		document.LodgerForm.alt_region_code.value	= "<%=alt_region_code%>";
		document.LodgerForm.alt_region_desc.value	= "<%=alt_region_desc%>";
		document.LodgerForm.alt_country_code.value	= "<%=alt_country_code%>";
		document.LodgerForm.alt_country_desc.value	= "<%=alt_country_desc%>";
		/*End*/
 </script>

<% } %>

<%
if(mode.equals("insert")) 
{
%>
  <script>
	 /* if(parent.frames[0].document.LodgerForm.race_required_yn.value == 'Y')
		{
	
		if(parent.frames[0].document.LodgerForm.hddCitizen=='Y')
		{
				document.getElementById('eth_gif').style.visibility='visible';
		}
		else
			{
				document.getElementById('eth_gif').style.visibility='hidden';

			}
		}
		else
	{
		///alert('11')
		document.getElementById('eth_gif').style.visibility='hidden';

	} */ 
			document.LodgerForm.race_desc.disabled = true;
			document.LodgerForm.race_desc_id.disabled = true;
	

  </script>

<% } %>

<%  String label ="";
%>

<table border="0" cellspacing="0" cellpadding="4" width="100%" align='center'>
	<tr><td colspan='4' align='left' class="COLUMNHEADER"><fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td></tr> 
	<tr>
    <% 			
	out.println("<td width='20%' class='label' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"</td><td width='30%' class='fields' nowrap>");
	 
	if(sql.length() > 0) sql.delete(0,sql.length());	
	sql.append(" select reason_for_stay_code, short_desc from IP_REASON_FOR_LOD_STAY_LANG_VW where language_id='"+locale+"' and eff_status = 'E'" );

	if (mode.equals("update"))
		sql.append(" and reason_for_stay_code='"+reason_for_stay+"' " );
	
	sql.append(" order by short_desc");
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql.toString()) ;

	if(rs!=null)
	{
		if(mode.equals ("insert"))
		{
			out.println( "<select name='reason_for_stay' id='reason_for_stay' >" ); 
			out.println("<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>") ;
		}

		while ( rs.next() )
		{
			if(mode.equals("insert"))
			{
				out.println( "<option value= \""+ rs.getString(1) +"\" >" + rs.getString(2) + "</option>" ) ;
			}
			else
			{
				out.println("<B> ");
				out.println(rs.getString(2)) ; 
				out.println("</B> ");
				//out.println(" <td width='25%'>&nbsp;</td>");
			}
		}
	}

	if(mode.equals("insert"))
		out.println( "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>");

	out.println("</td>");
	out.println("<td width='25%'class='label'>&nbsp;</td>");
	out.println("<td width='25%'class='label'>&nbsp;</td>");

	if(mode.equals("update"))
	{
	//	out.println(" <tr><td colspan='3'>&nbsp;</td><td >&nbsp;</td></tr>");
	}
	%>

</tr>

<tr>
	<td class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
	
<%	if(mode.equals("insert"))
	{	
		String sysdateTime_display = DateUtils.convertDate(sysdateTime,"DMYHM","en",localeName);
	%>
	    <td class='fields' nowrap>
		<input type="text" id='periodfrom' name="period_from" id="period_from" maxlength=16 size=16 onblur ="ComparePeriodTime(this,period_to);ValCheckinTime(this,'<%=sysdateTime%>')" onKeyPress='return(ChkNumberIP(this,event,2))'  value ="<%=sysdateTime_display%>"><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_from.focus();return showCalendar('periodfrom',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>  
<%	}
	else
	{    
		out.println("<td class='QUERYDATA'>");
		out.println( Period_dat_dis_tim_fr);
	}	%>   
</td>  
<td class="label"><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
<%	if(mode.equals("insert"))
	{	%>
	        <td class='fields' nowrap><input type="text" id='periodto' name="period_to" id="period_to" maxlength=16 size=16 onblur="ComparePeriodTime(period_from,this);" onKeyPress='return(ChkNumberIP(this,event,2))' value="<%=Period_date_time_to%>" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_to.focus();return showCalendar('periodto',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>  
<%	}
	else
	{
		if(mode.equals("update"))
		{   
			out.println("<td class='QUERYDATA'>");
			out.println(Period_dat_dis_tim_to) ;
		}
	}
%>
</td>
</tr>

<!-- NURSING UNIT -->
<tr>
	<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>	
	<%if(mode.equals("insert"))
	{%>
	    <td class='fields' nowrap>
		<input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=16 size=16  onblur="beforeGetNursingUnit(this, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup'  value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" >
		<input type=hidden name="lodger_nursing_unit" id="lodger_nursing_unit">
	<%}
	else
	{
        out.println("<td class='QUERYDATA'>");
		if(nursing_desc ==null || nursing_desc.equals("null"))
			nursing_desc ="";  
		out.println(nursing_desc) ;
	}
%>
</td>

<!-- AUTHORIZED BY -->

<td class="label" ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
	
		<%if(mode.equals("insert"))
		{%>
            <td class='fields' nowrap>
			<input type="text" name="authorised_by" id="authorised_by" maxlength=16 size=16 value="<%=authorized_by%>" <%=rdonly%> onBlur='makeValidString(this);'><img src='../../eCommon/images/mandatory.gif'></img>
		<%}
		else
		{  
			out.println("<td class='QUERYDATA'>");
			out.println( authorized_by ) ;
		}%> 
	</td>
</tr>

<!-- REMARKS -->
<tr>
	<td class="label"  nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<%if(mode.equals("insert"))
		{%>
			<td class='fields' wrap colspan='2'><textarea style="resize:none" name="remarks" rows=3  cols=70 maxLength='200' onKeypress="return CheckMaxLength(this,200)" onBlur="checkMax(this);"<%=rdonly%>><%=remarks%></textarea>
		<%}
		else
		{%>
			<td class='QUERYDATA' colspan='2'><%=remarks%>			
		<%}%>
		</td>		
        <td class='label'></td>
</tr>
<%if(mode.equals("update"))	
  {
	String currDate_display = DateUtils.convertDate(currDate,"DMYHM","en",localeName);			
%>
<!-- CHECK OUT DATE / TIME -->
	 <tr> 
		<td class="label" nowrap><%=label%><fmt:message key="eIP.checkoutdatetime.label" bundle="${ip_labels}"/></td>
		<input type="hidden" name="chk_in_dt_time" id="chk_in_dt_time" maxlength=16 size=16 onblur ="dateVal(this)" value ="<%=check_in_date_time%>">
		<td class='fields' nowrap><input type="text" id='chkoutdttime' name="chk_out_dt_time" id="chk_out_dt_time" maxlength=16 size=16 onKeyPress='return(ChkNumberIP(this,event,2))' onblur="compareDate(this,document.forms[0].chk_in_dt_time,'<%=sysdateTime%>');" value ="<%=currDate_display%>" ><img  src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].chk_out_dt_time.select();return showCalendar('chkoutdttime', null, 'hh:mm' );"/><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		</tr>  
	<%}%>

<%if(mode.equals("update"))
	{	%>
		<!-- <tr><td  class='button'></td></tr> -->
			<tr>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td  class='fields' nowrap><input type='button' value='Release Lodger' name='release_lodger' id='release_lodger' class='button' onClick="SubmitPage()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='window.close();'>
				</td>
			</tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'>&nbsp;</td></tr>
	<%}
	else
	{	%>
	<tr>
		<td  class='button'>&nbsp;</td>
		<td  class='button'>&nbsp;</td>
		<td  class='button'>&nbsp;</td>
		<td  class='fields' nowrap><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='chkIn_Lodger' class='button' onClick="apply()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='parent.parent.document.getElementById("dialog_tag").close();'>
		</td>
	</tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'></td></tr>
		<tr><td  class='button' colspan='4'>&nbsp;</td></tr>
	<%	}
	%> 
</table>
		<input type="hidden" name='Category' id='Category' value = "<%=Category%>"> 
		<input type="hidden" name='locale' id='locale' value = "<%=locale%>"> 
		<input type="hidden" name='lodger_ref_no' id='lodger_ref_no' value = "<%=lodger_ref_no%>"> 
		<input type="hidden" name='pat_id' id='pat_id' value = "<%=patient_id%>">  
		<input type="hidden" name='encounter_id' id='encounter_id' value = "<%=encounter_id%>"> 
		<input type="hidden" name="to_chk_in_dt_time" id="to_chk_in_dt_time" maxlength=16 size=16 onblur ="dateVal(this)" value ="<%=currDate%>"> 
		<input type='hidden' name='mode' id='mode' value= "<%=mode%>">
		<input type='hidden' name='label' id='label' value= "<%=label%>">
		<input type='hidden' name='pLine_Pat_id' id='pLine_Pat_id' value= "<%=patient_id%>">
		<input type='hidden' name='Lodger_Max_RefNo' id='Lodger_Max_RefNo' value= "<%=Lodger_Max_RefNo%>">
		<input type='hidden' name='Lodger_Next_RefNo' id='Lodger_Next_RefNo' value= "<%=Lodger_Next_RefNo%>">
		<input type='hidden' name='patientId' id='patientId' value= "<%=patientId%>">
		<input type='hidden' name='citizenvalue' id='citizenvalue' value= "">
		<input type='hidden' name='illegalvalue' id='illegalvalue' value= "">
	</form>
<%
if(openWindow.equals("NO"))
{
	out.println("<script>parent.window.close();</script>");
}
}catch(Exception e) {out.println(e.toString());}

finally
{
	try
	{
		if (rs != null)			rs.close();
		if (stmt != null)		stmt.close();
		if (rs_opn != null)		rs_opn.close();
		if (stmt_opn != null)	stmt_opn.close();
		//if (PatIDRS != null)	PatIDRS.close();
		// if (PatIDStmt != null)	PatIDStmt.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
	ConnectionManager.returnConnection(con,request);
}     %>
   </body>
</html>

<%!
	// By Sridhar R  added on 3/15/2005 ... to handle NullPointerException...
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

