<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../js/CheckinAccmpPerson.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<%
	Connection con			= null;
	Statement PatIDStmt		= null;
	ResultSet PatIDRS		= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	Statement stmt_opn		= null;
	ResultSet rs_opn		= null;
	Statement AccStmt		= null;
	ResultSet AccRS			= null;
	String facility_id		= (String)session.getValue ( "facility_id" );
	String loginUser		= (String)session.getValue("login_user");
	//String patId_for_accID	= checkForNull(request.getParameter("patId_for_accID"));
	String p_oper_stn_id	= checkForNull(request.getParameter("oper_stn_id"));
	String encounter_id		= checkForNull(request.getParameter("EncounterId"));
	String location_code	= checkForNull(request.getParameter("location_code"));

	String Category = request.getParameter("Category");
	if(Category == null)	Category = "A" ;

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
	String eth_sub_grp			= "";
	String nationality_code		= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String Acc_person_age		= "";
	String name_prefix_loc_lang	= "";
	String first_name_loc_lang	= "";
	String second_name_loc_lang	= "";
	String third_name_loc_lang	= "";
	String family_name_loc_lang	= "";
	String name_suffix_loc_lang	= "";
	String patient_name_loc_lang= "";
	String max_patient_age		= "";
	int IP_param_No_Acc_Persons	= 0;

	/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
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

	String Lodger_Max_RefNo				= checkForNull(request.getParameter("Lodger_Max_RefNo"));
	String Lodger_Next_RefNo			= checkForNull(request.getParameter("Lodger_Next_RefNo"));
	String Lodger_Period				= checkForNull(request.getParameter("Lodger_Period"));
	String Acc_Period					= checkForNull(request.getParameter("Acc_Period"));
	String Acc_Period_unit				= checkForNull(request.getParameter("Acc_Period_unit"));
	String IP_param_No_Acc_Persons_str	= checkForNull(request.getParameter("IP_param_No_Acc_Persons"));

	if(!IP_param_No_Acc_Persons_str.equals(""))
		IP_param_No_Acc_Persons			= Integer.parseInt(IP_param_No_Acc_Persons_str);

	String nationality_long_desc		= "";
	int Available_Acc_persons			= 0;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt					= new java.util.Date();
	String currDate						= dateFormat.format(dt);

	String min = String.valueOf(dt.getMinutes());
	if(min.length() == 1)   min = "0"+min ;
	currDate=currDate + " "+String.valueOf(dt.getHours())+":"+min;
	check_in_date_time = currDate ;   

	String mode = request.getParameter("mode");
	if(mode == null)
		mode = "insert";

	try
	{
		con = ConnectionManager.getConnection(request);

		if(mode.equals("insert"))
		{
			if(Acc_Period.equals("") || Acc_Period.equals("0"))
			{	
				out.println("<script>alert(getMessage('RENEW_GATE_PASS_NOT_DEF','IP'));parent.window.close();</script>"); 
			}

			StringBuffer AccTotalSql = new StringBuffer();
			AccTotalSql.append("SELECT count(*) FROM IP_LODGER_DETAIL WHERE facility_id = '"+facility_id+"' and PATIENT_ENCOUNTER_ID = '"+encounter_id+"' and CHECK_OUT_YN = 'N' ");

			AccStmt = con.createStatement();
			AccRS = AccStmt.executeQuery( AccTotalSql.toString() );

			if(AccRS!=null)
			{
				if ( AccRS.next() )
				{
					Available_Acc_persons = AccRS.getInt(1);
				}
			}

			if(IP_param_No_Acc_Persons == 0)
			{
				out.println("<script>alert(getMessage('ACC_PERS_PARAM_NOT_DEF','IP'));parent.window.close();</script>");
			}
			else if(IP_param_No_Acc_Persons <= Available_Acc_persons)
			{
				out.println("<script>alert(getMessage('MAX_ACC_PERS_EXCEEDED','IP'));parent.window.close();</script>");
			}

			if(AccRS != null)		AccRS.close();
			if(AccStmt != null)		AccStmt.close();
		}


		/* 	int count=0;
			StringBuffer patIDSql = new StringBuffer();
			patIDSql.append("select a.LODGER_PATIENT_ID LODGER_PATIENT_ID,a.LODGER_REF_NO LODGER_REF_NO, b.REVISED_YN REVISED_YN from IP_LODGER_DETAIL a, IP_LODGER_GATE_PASS b where a.facility_ID='"+facility_id+"' and a.facility_ID=b.facility_ID and a.LODGER_REF_NO=b.LODGER_REF_NO and a.LODGER_PATIENT_ID is not null");

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
Monday, June 14, 2010 PE_EXE venkat s**/

			sql.append("select patient_id_length, to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, pat_name_as_multipart_yn,max_patient_age from mp_param ");
			stmt = con.createStatement();
			rs  = stmt.executeQuery(sql.toString());

			if (rs.next())
			{
				sysdateTime	= rs.getString(2);
				max_patient_age	= rs.getString(4);
			}
			
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(Category!=null && !Category.equals("L"))
			{
				
				sql.append("select PATIENT_ID from PR_ENCOUNTER where facility_id='"+facility_id+"' and encounter_id='"+encounter_id+"'" );    
				rs = stmt.executeQuery( sql.toString() );
				if(rs!=null && rs.next())
				{
					patient_id = checkForNull(rs.getString("PATIENT_ID"));
				}
			}
		if(mode.equals("update"))
		{
			lodger_ref_no = request.getParameter("lodger_ref_no") ;
			if(lodger_ref_no.equals("null"))  lodger_ref_no ="" ;

			nursing_desc = request.getParameter("nursing_desc") ;
			if(nursing_desc.equals("null"))  nursing_desc ="" ;

			patientID = request.getParameter("PatID") ;
			if(patientID.equals("null"))  patientID ="" ;

			try
			{
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
				ExeSQL.append(" get_age(a.LODGER_DOB)Acc_person_age,");
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
				ExeSQL.append(" a.RACE_CODE, (CASE WHEN a.race_code IS NOT NULL THEN (mp_get_desc.mp_race(a.race_code,'"+locale+"',1)) END) RACE_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_AREA_CODE MAIL_AREA_CODE, (CASE WHEN a.MAIL_AREA_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_AREA(a.MAIL_AREA_CODE,'"+locale+"',1)) END) MAIL_AREA_DESCRIPTION,");
				ExeSQL.append(" a.MAIL_TOWN_CODE MAIL_TOWN_CODE, (CASE WHEN a.MAIL_TOWN_CODE IS NOT NULL THEN (mp_get_desc.MP_RES_TOWN(a.MAIL_TOWN_CODE,'"+locale+"',1)) END)  MAIL_TOWN_DESCRIPTION,");
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
				ExeSQL.append(" ip_lodger_detail a"); 
				ExeSQL.append(" WHERE ");
				ExeSQL.append(" a.facility_id = '"+facility_id+"' AND");
				ExeSQL.append(" a.lodger_ref_no ='"+lodger_ref_no+"' ");

				stmt = con.createStatement();
				rs = stmt.executeQuery(ExeSQL.toString());

			}catch(Exception e) 
			{
				out.println("Error while querying data : "+e.toString());
				e.printStackTrace();
			}
			if(rs!=null)
			{
				if ( rs.next() )
				{
					rdonly = "readonly" ;

					Category = rs.getString("ATTACHED_TO_INPATIENT_YN") ; 
					if(Category.equals("Y"))
						Category = "A" ;
					else
						Category = "L" ;

					years	= checkForNull(rs.getString( "years" ));
					months  = checkForNull(rs.getString( "months" ));
					days    = checkForNull(rs.getString( "days" ));

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
					
					authorized_by        = rs.getString( "authorised_by" );
					if(authorized_by ==null)		authorized_by ="";  

					gender       = rs.getString( "lodger_gender" );
					if(gender==null) gender="";

					Acc_person_age    = rs.getString("Acc_person_age");
					if(Acc_person_age==null) Acc_person_age="";

					date_of_birth    = rs.getString("LODGER_DOB");
					if(date_of_birth==null) date_of_birth = "";

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

					eth_sub_grp= rs.getString( "RACE_DESCRIPTION" );
					if(eth_sub_grp==null) eth_sub_grp="";

					national_id_no= rs.getString( "NATIONAL_ID_NO" );
					if(national_id_no==null) national_id_no="";

					nationality_code = rs.getString( "NATIONALITY_CODE" );
					if(nationality_code==null) nationality_code="";

					nationality_long_desc = rs.getString( "NATIONALITY_DESC" );
					if(nationality_long_desc  == null) nationality_long_desc  = "";

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
				
					mail_addr_line1= rs.getString( "MAIL_ADDR_LINE1" );
					if(mail_addr_line1==null) mail_addr_line1="";

					mail_addr_line2= rs.getString( "MAIL_ADDR_LINE2" );
					if(mail_addr_line2==null) mail_addr_line2="";

					mail_addr_line3= rs.getString( "MAIL_ADDR_LINE3" );
					if(mail_addr_line3==null) mail_addr_line3="";

					mail_addr_line4= rs.getString( "MAIL_ADDR_LINE4" );
					if(mail_addr_line4==null) mail_addr_line4="";

					mail_town_code		= checkForNull(rs.getString("MAIL_TOWN_CODE"));
					mail_town_desc		= checkForNull(rs.getString("MAIL_TOWN_DESCRIPTION"));
					mail_area_code		= checkForNull(rs.getString("MAIL_AREA_CODE"));
					mail_area_desc		= checkForNull(rs.getString("MAIL_AREA_DESCRIPTION"));
					mail_region_code	= checkForNull(rs.getString("MAIL_REGION_CODE"));
					mail_region_desc	= checkForNull(rs.getString("MAIL_REGION_DESCRIPTION"));
					mail_postal_code	= checkForNull(rs.getString("MAIL_POSTAL_CODE"));
					mail_postal_code_desc	= checkForNull(rs.getString("mail_postal_code_desc"));
					mail_country_code	= checkForNull(rs.getString("MAIL_COUNTRY_CODE"));
					mail_country_desc	= checkForNull(rs.getString("MAIL_COUNTRY_DESCRIPTION"));
					oth_contact_no       = checkForNull(rs.getString( "lodger_off_tel_num" ));
					other_tel_no       = checkForNull(rs.getString( "lodger_res_tel_num" ));
					email_id= checkForNull(rs.getString( "LODGER_EMAIL" ));

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
					patient_name_loc_lang	= checkForNull(rs.getString("LODGER_NAME_LOC_LANG"));
				}//E.o RS
			}// E.o RS !null
		}
	%>
	</head>


	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='AccPersonForm' id='AccPersonForm' method='post' action='../../servlet/eIP.BookLodgerServlet' target='messageFrame'>
		<input type="hidden" name="hddCitizen" id="hddCitizen" value="<%=citizen%>">
		<input type="hidden" name="hddLegal" id="hddLegal" value="<%=legal%>">
		<input type='hidden' name='Lodger_Disc_Period' id='Lodger_Disc_Period' value= "<%=Lodger_Period%>">
		<input type='hidden' name='Lodger_Disc_Period_unit' id='Lodger_Disc_Period_unit' value= "H">
		<input type='hidden' name='Acc_Disc_Period' id='Acc_Disc_Period' value= "<%=Acc_Period%>">
		<input type='hidden' name='Acc_Disc_Period_unit' id='Acc_Disc_Period_unit' value= "<%=Acc_Period_unit%>">
	<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
	<!--  ADDED TO DISPLAY [ ACCOMPANYING DETAILS ] FRAME FROM eMP -->
	<!--  ADDED BY SRIDHAR ON 17 FEB 2004 --> 

	<tr>
			<td colspan=7 align='left' class= "COLUMNHEADER">&nbsp;<fmt:message key="eIP.AccompanyingPersonDetails.label" bundle="${ip_labels}"/></td>
		</tr>	
		<tr><td colspan=7 class=label height=5></td></tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" align='center'>
	<%	if(mode.equals("insert"))
		{	%>
		<tr>		
			<td colspan='7'>
				
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="function_id" value= "CHECK_IN_ACCMP_PERSON" /> 	
				<jsp:param name ="patient_id" value= "" /> 	
				<jsp:param name ="alert_reqd_yn" value= "Y" /> 		
				</jsp:include>
			</td>
		</tr>
	<%	}
		else
		{	%>	
		<tr>		
			<td colspan='7'>
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="function_id" value= "CHECK_IN_ACCMP_PERSON" /> 
				<jsp:param name ="lodger_relation_code" value= "<%=lodger_relation_code%>" />
				<jsp:param name ="patient_id" value= "" /> 	
				<jsp:param name ="alert_reqd_yn" value= "Y" /> 	
				<jsp:param name ="readonly_yn" value= "Y" /> 		
				<jsp:param name ="bodyFrame" value= "parent.frames[0]"  /> 	
				<jsp:param name ="submitFrame" value= "parent.frames[1]"  />   
				</jsp:include>
			</td>
		</tr>
	<%	}
	%>
	</table>

	<!-- ADDED FOR LOCALLY ASIGNING THE VALUES TO THE MP FORM IN THE UPDATE MODE  -->
	<!-- ADDED BY SRIDHAR ON 9th FEB 2004   -->
	<%
	try
	{
		if(!mode.equals("insert"))
		{	%>
		  <script>
			
				document.AccPersonForm.patient_id.value = "<%=patientID%>";
				document.AccPersonForm.patient_id.disabled = true;
				document.AccPersonForm.search.disabled = true;
				document.getElementById('patient_name1').innerHTML = "<%=lodger_patient_name%>";
				//document.getElementById('patient_name').disabled = true; 
			
				if(document.AccPersonForm.name_prefix1)
				{
					document.AccPersonForm.name_prefix1.value	= "<%=nameprefix%>";
					document.AccPersonForm.name_prefix1.disabled = true;
				}
				if(document.AccPersonForm.name_prefix)
				{
					document.AccPersonForm.name_prefix.value = 	"<%=nameprefix%>";
					document.AccPersonForm.name_prefix.disabled = true;
				}
				
				if(document.AccPersonForm.family_name)
				{
					document.AccPersonForm.family_name.value = "<%=familyname%>";
					document.AccPersonForm.family_name.disabled = true;
					if(document.AccPersonForm.bfam)
					document.AccPersonForm.bfam.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.first_name)
				{
					document.AccPersonForm.first_name.value = "<%=firstname%>";
					document.AccPersonForm.first_name.disabled = true;
					if(document.AccPersonForm.bf)
					document.AccPersonForm.bf.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.second_name)
				{
					document.AccPersonForm.second_name.value	= "<%=secondname%>";
					document.AccPersonForm.second_name.disabled = true;
					if(document.AccPersonForm.bs)
					document.AccPersonForm.bs.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.third_name)
				{
					document.AccPersonForm.third_name.value	= "<%=thirdname%>";
					document.AccPersonForm.third_name.disabled = true;
					if(document.AccPersonForm.bt)
					document.AccPersonForm.bt.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.name_suffix)
				{
					document.AccPersonForm.name_suffix.value = "<%=namesuffix%>";	
					document.AccPersonForm.name_suffix.disabled = true;
				}

				if(document.AccPersonForm.name_suffix1)
				{
					document.AccPersonForm.name_suffix1.value = "<%=namesuffix%>";
					document.AccPersonForm.name_suffix1.disabled = true;
				}

				


				if(document.AccPersonForm.name_prefix_oth_lang)
				{
					document.AccPersonForm.name_prefix_oth_lang.value 	= "<%=name_prefix_loc_lang%>";
					document.AccPersonForm.name_prefix_oth_lang.disabled = true;
				}

				if(document.AccPersonForm.first_name_oth_lang)
				{
					document.AccPersonForm.first_name_oth_lang.value 	= "<%=first_name_loc_lang%>";
					document.AccPersonForm.first_name_oth_lang.disabled = true;
					if(document.AccPersonForm.bfo)
					document.AccPersonForm.bfo.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.second_name_oth_lang)
				{
					document.AccPersonForm.second_name_oth_lang.value 	= "<%=second_name_loc_lang%>";
					document.AccPersonForm.second_name_oth_lang.disabled = true;
					if(document.AccPersonForm.bso)
					document.AccPersonForm.bso.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.third_name_oth_lang)
				{
					document.AccPersonForm.third_name_oth_lang.value 	= "<%=third_name_loc_lang%>";
					document.AccPersonForm.third_name_oth_lang.disabled = true;
					if(document.AccPersonForm.bto)
					document.AccPersonForm.bto.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.family_name_oth_lang)
				{
					document.AccPersonForm.family_name_oth_lang.value 	= "<%=family_name_loc_lang%>";
					document.AccPersonForm.family_name_oth_lang.disabled = true;
					if(document.AccPersonForm.bfamo)
					document.AccPersonForm.bfamo.disabled	= true;//added by  munisekhar  for [IN:046231]
				}

				if(document.AccPersonForm.name_suffix_oth_lang)
				{
					document.AccPersonForm.name_suffix_oth_lang.value 	= "<%=name_suffix_loc_lang%>";
					document.AccPersonForm.name_suffix_oth_lang.disabled = true;
				}

				document.getElementById('patient_name_local_lang1').innerText 	= "<%=patient_name_loc_lang%>";
				document.AccPersonForm.patient_name_local_lang.value= "<%=patient_name_loc_lang%>";

				document.AccPersonForm.sex.value 	= "<%=gender%>";
				document.AccPersonForm.sex.disabled = true;

				//// Alternative for date of bith ...using sql function...
				document.AccPersonForm.b_age.value	= "<%=years%>";
				document.AccPersonForm.b_months.value	= "<%=months%>";
				document.AccPersonForm.b_days.value	= "<%=days%>";

				if(document.AccPersonForm.b_birth)
				{
					document.AccPersonForm.b_birth.disabled = true;
				}

				if(document.getElementById('dob'))
					document.getElementById('dob').disabled = true;

				if(document.AccPersonForm.b_age)
				{
					document.AccPersonForm.b_age.disabled = true;
					document.AccPersonForm.b_months.disabled = true;
					document.AccPersonForm.b_days.disabled = true;
				}
				document.AccPersonForm.national_id_no.value 	= "<%=national_id_no%>";
				document.AccPersonForm.national_id_no.disabled =true;
				if(document.AccPersonForm.myKadBtn)
					document.AccPersonForm.myKadBtn.disabled =true;
				if(document.AccPersonForm.alt_id1_no)
				{
					document.AccPersonForm.alt_id1_no.value 	= "<%=alt_id1_no%>";
					document.AccPersonForm.alt_id1_no.disabled = true;
				}
				if(document.AccPersonForm.alt_id2_no)
				{
					document.AccPersonForm.alt_id2_no.value 	= "<%=alt_id2_no%>";
					document.AccPersonForm.alt_id2_no.disabled = true;
				}
				if(document.AccPersonForm.alt_id3_no)
				{
					document.AccPersonForm.alt_id3_no.value 	= "<%=alt_id3_no%>";
					document.AccPersonForm.alt_id3_no.disabled = true;
				}
				if(document.AccPersonForm.alt_id4_no)
				{
					document.AccPersonForm.alt_id4_no.value 	= "<%=alt_id4_no%>";
					document.AccPersonForm.alt_id4_no.disabled = true;
				}
				if(document.AccPersonForm.alt_id1_exp_date)
				{
					document.AccPersonForm.alt_id1_exp_date.value 	= "<%=alt_id1_exp_date%>";
					document.AccPersonForm.alt_id1_exp_date.disabled = true;
				}
				
				if(document.AccPersonForm.alt_id2_exp_date)
				{
					document.AccPersonForm.alt_id2_exp_date.value 	= "<%=alt_id2_exp_date%>";
					document.AccPersonForm.alt_id2_exp_date.disabled = true;
				}
				if(document.AccPersonForm.alt_id3_exp_date)
				{	
					document.AccPersonForm.alt_id3_exp_date.value = "<%=alt_id3_exp_date%>";
					document.AccPersonForm.alt_id3_exp_date.disabled = true;
				}
				if(document.AccPersonForm.alt_id4_exp_date)
				{
					document.AccPersonForm.alt_id4_exp_date.value = "<%=alt_id4_exp_date%>";
					document.AccPersonForm.alt_id4_exp_date.disabled = true;
				}

				if(document.AccPersonForm.other_alt_type)
				{
					document.AccPersonForm.other_alt_type.value = "<%=oth_alt_id_type%>";
					document.AccPersonForm.other_alt_type.disabled = true;
				}

				if(document.AccPersonForm.other_alt_Id)
				{
					document.AccPersonForm.other_alt_Id.value = "<%=oth_alt_id_no%>";
					document.AccPersonForm.other_alt_Id.disabled = true;
				}

				// Patient contact details popup 
				// to disable the Contact Detail Button

				document.AccPersonForm.addr_line1.value="<%=res_addr_line1%>";
				document.AccPersonForm.addr_line1.disabled = true;

				document.AccPersonForm.addr_line2.value="<%=res_addr_line2%>";
				document.AccPersonForm.addr_line2.disabled = true;

				document.AccPersonForm.addr_line3.value="<%=res_addr_line3%>";
				document.AccPersonForm.addr_line3.disabled = true;

				document.AccPersonForm.addr_line4.value="<%=res_addr_line4%>";
				document.AccPersonForm.addr_line4.disabled = true;

				document.AccPersonForm.res_town_code.value="<%=res_town_code%>";
				document.AccPersonForm.res_town_desc.value="<%=res_town_desc%>";

				document.AccPersonForm.res_area_code.value="<%=res_area_code%>";
				document.AccPersonForm.res_area_desc.value="<%=res_area_desc%>";

				document.AccPersonForm.region_code.value="<%=res_region_code%>";
				document.AccPersonForm.region_desc.value="<%=res_region_desc%>";		

				document.AccPersonForm.postal_code.value="<%=postal_code%>";
				document.AccPersonForm.r_postal_code_desc.value="<%=postal_code_desc%>";

				document.AccPersonForm.country_desc.value="<%=country_code%>";

				document.AccPersonForm.contact1_name.value='';

				document.AccPersonForm.addr2_type.value='';

				document.AccPersonForm.mail_addr_line1.value="<%=mail_addr_line1%>";
				document.AccPersonForm.mail_addr_line1.disabled = true;

				document.AccPersonForm.mail_addr_line2.value="<%=mail_addr_line2%>";		
				document.AccPersonForm.mail_addr_line2.disabled = true;

				document.AccPersonForm.mail_addr_line3.value="<%=mail_addr_line3%>";
				document.AccPersonForm.mail_addr_line3.disabled = true;

				document.AccPersonForm.mail_addr_line4.value="<%=mail_addr_line4%>";
				document.AccPersonForm.mail_addr_line4.disabled = true;

				document.AccPersonForm.mail_res_town_code.value="<%=mail_town_code%>";
				document.AccPersonForm.mail_res_town_desc.value="<%=mail_town_desc%>";
				
				document.AccPersonForm.mail_res_area_code.value="<%=mail_area_code%>";
				document.AccPersonForm.mail_res_area_desc.value="<%=mail_area_desc%>";
				
				document.AccPersonForm.mail_postal_code.value="<%=mail_postal_code%>";
				document.AccPersonForm.m_postal_code_desc.value="<%=mail_postal_code_desc%>";

				document.AccPersonForm.mail_region_code.value="<%=mail_region_code%>";
				document.AccPersonForm.mail_region_desc.value="<%=mail_region_desc%>";
				document.AccPersonForm.mail_region_desc.readOnly = true; 

				document.AccPersonForm.mail_country_code.value="<%=mail_country_code%>";
				document.AccPersonForm.mail_country_desc.value="<%=mail_country_desc%>";

				document.AccPersonForm.contact2_name.value="";
				document.AccPersonForm.contact1_no.value="<%=other_tel_no%>";
				document.AccPersonForm.contact2_no.value="<%=oth_contact_no%>";
				document.AccPersonForm.email.value="<%=email_id%>";

				/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				document.AccPersonForm.alt_addr_line1.value		= "<%=alt_addr_line1%>";
				document.AccPersonForm.alt_addr_line1.disabled	= true;
				document.AccPersonForm.alt_addr_line2.value		= "<%=alt_addr_line2%>";
				document.AccPersonForm.alt_addr_line2.disabled	= true;
				document.AccPersonForm.alt_addr_line3.value		= "<%=alt_addr_line3%>";
				document.AccPersonForm.alt_addr_line3.disabled	= true;
				document.AccPersonForm.alt_addr_line4.value		= "<%=alt_addr_line4%>";
				document.AccPersonForm.alt_addr_line4.disabled	= true;
				document.AccPersonForm.alt_area_code.value		= "<%=alt_area_code%>";
				document.AccPersonForm.alt_area_desc.value		= "<%=alt_area_desc%>";
				document.AccPersonForm.alt_town_code.value		= "<%=alt_town_code%>";
				document.AccPersonForm.alt_town_desc.value		= "<%=alt_town_desc%>";
				document.AccPersonForm.alt_postal_code.value	= "<%=alt_postal_code%>";
				document.AccPersonForm.alt_postal_desc.value	= "<%=alt_postal_desc%>";
				document.AccPersonForm.alt_region_code.value	= "<%=alt_region_code%>";
				document.AccPersonForm.alt_region_desc.value	= "<%=alt_region_desc%>";
				document.AccPersonForm.alt_country_code.value	= "<%=alt_country_code%>";
				document.AccPersonForm.alt_country_desc.value	= "<%=alt_country_desc%>";
				/*End*/
		 </script>
	<%	}
	}catch(Exception eass) 
	{
		out.println("Error while assigning data : "+eass.toString());
		eass.printStackTrace();
	}
	%>
	<%  String label =""; %>	

	<table align='center' border="0" cellspacing="0" cellpadding="4" width="100%" >
		<tr><td colspan=10 class=label height=5></td></tr>
		<tr><td align='left' colspan='10' class="COLUMNHEADER"><fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td></tr> 
		<tr><td colspan=10 class=label height=5></td></tr>
		<!-- PERIOD FROM -->
		<tr>
		<td class="label" width=20% nowrap><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>        
		<td class='fields' width=30% nowrap>
	<%	if(mode.equals("insert"))
		{	
			String sysdateTime_display = DateUtils.convertDate(sysdateTime,"DMYHM","en",localeName);
	%>
			<input type="text" id='periodfrom' name="period_from" id="period_from" maxlength=16 size=16 onblur ="ComparePeriodTime(this,period_to);ValCheckinTime(this,'<%=sysdateTime%>')" onKeyPress='return(ChkNumberIP(this,event,2))' value="<%=sysdateTime_display%>"><img  src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_from.focus();return showCalendar('periodfrom',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'></img>  
	<%	}
		else
		{  
			out.println("<b>");
			out.println(Period_dat_dis_tim_fr); 
			out.println("</b>");
		} %>   
		</td>  
		<!-- PERIOD TO -->
		<td class="label" width=25%> <fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class='fields' width=25% colspan='7' nowrap>
	<%	if(mode.equals("insert"))
		{	%>
			<input type="text" id='periodto' name="period_to" id="period_to" maxlength=16 size=16 onblur="ComparePeriodTime(period_from,this);" onKeyPress='return(ChkNumberIP(this,event,2))' value="<%=Period_date_time_to%>" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].period_to.focus();return showCalendar('periodto',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'align='center'></img>  
	<%	}
		else
		{
			if(mode.equals("update"))
			{
				out.println("<b>");
				out.println(Period_dat_dis_tim_to) ;
				out.println("</b>");
			}
		}	%>
        </td>		
		</tr>
			
		
		<!-- AUTHORIZED BY -->

		<tr>
			<td class="label" ><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
				<%if(mode.equals("insert"))
				{%>
					<input type="text" name="Authorised_lookup" id="Authorised_lookup" maxlength=16 size=16 value="" onBlur='beforeGetAuthorised(document.forms[0].Authorised_hid,this);enableDisable(this,Authorised_text);'><input type=button class='button' name='search_Authorised' id='search_Authorised' value='?' onclick="getAuthoriser(document.forms[0].Authorised_hid,document.forms[0].Authorised_lookup)">
					<input type="text" name="Authorised_text" id="Authorised_text" maxlength=16 size=16 value="" onBlur='makeValidString(this);enableDisable(Authorised_lookup,this);'><img src='../../eCommon/images/mandatory.gif'align='center'></img><input type=hidden name="Authorised_hid" id="Authorised_hid" value=''>

			<%	}
				else
				{
					out.println("<b>");
					out.println( authorized_by ) ;	
					out.println("</b>");
				}%> 
			</td>

            <!-- NURSING UNIT -->
			<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='7'>
			<%if(mode.equals("insert"))
			{%>
				<input type=text name="nursing_unit_desc" id="nursing_unit_desc" width="16" maxlength=16 size=16  onblur="beforeGetNursingUnit(this, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=button class='button' name='nursing_unit_lookup' id='nursing_unit_lookup'  value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" >
				<input type=hidden name="lodger_nursing_unit" id="lodger_nursing_unit" width="15" >
		<%	}
			else
			{
				out.println("<b>");
				out.println(nursing_desc);	
				out.println("</b>");
			}
		%>
		</td>		
		</tr>

		<!-- REMARKS -->
		<tr>
			<td class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<%if(mode.equals("insert"))
				{%>
					<td class='fields' colspan='9' wrap>
					<textarea style = "resize:none" name="remarks" rows=3  cols=84 maxLength='200' onKeypress="return CheckMaxLength(this,200)" onBlur="checkMax(this);"<%=rdonly%> ><%=remarks%></textarea></td>
				<%}
				else
				{%>
					<td class='QUERYDATA'><%=remarks%></td><td colspan='8' ></td>								
				<%}%> 				
		</tr>

	<%	if(mode.equals("update"))	
		{	
			String currDate_display = DateUtils.convertDate(currDate,"DMYHM","en",localeName);	
	%>
		<!-- CHECK OUT DATE / TIME --> 
		 <tr>
			<td class="label"><%=label%><fmt:message key="eIP.checkoutdatetime.label" bundle="${ip_labels}"/></td>
            <td class='fields'><input type="hidden" name="chk_in_dt_time" id="chk_in_dt_time" maxlength=16 size=16 onblur ="dateVal(this)" value ="<%=check_in_date_time%>">
			<input type="text" id='chkoutdttime' name="chk_out_dt_time" id="chk_out_dt_time" maxlength=16 size=16 onKeyPress='return(ChkNumberIP(this,event,2))' onblur="compareDate(this,document.forms[0].chk_in_dt_time,'<%=sysdateTime%>');" value ="<%=currDate_display%>" ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].chk_out_dt_time.select();return showCalendar('chkoutdttime', null, 'hh:mm' );"/><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
            <td colspan='8' ></td>
		 </tr>  
	<%	}	%>	
	<%	if(mode.equals("update"))
		{	%>
			<tr><td colspan='10' class='button'></td></tr>
			<tr>
				<td colspan='3' class='buton'></td>
				<td colspan='6' class='fields'><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels")%>' name='release_lodger' class='button' onClick="SubmitPage()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='const dialogTag = parent.parent.document.getElementById("dialog_tag"); dialogTag.close();'>
				</td>
			</tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
	<%	}
		else
		{	%>
			<tr>
			    <td class='button'>&nbsp;</td>
			    <td class='button'>&nbsp;</td>
			    <td class='button'>&nbsp;</td>
			    <td class='fields' colspan='7'>
				<input type='button'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='chkIn_Lodger' class='button' onClick="apply()"><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' name='cancel' class='button' onclick='window.close();'>
				</td>                 
			</tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
			<tr><td colspan='10' class='button'>&nbsp;</td></tr>
	<%	}	%> 
	</table>
			<input type="hidden" name="to_chk_in_dt_time" id="to_chk_in_dt_time" value ="<%=currDate%>"> 
			<input type="hidden" name='Category' id='Category' value = "<%=Category%>"> 
			<input type="hidden" name='encounter_id' id='encounter_id' value = "<%=encounter_id%>"> 
			<input type="hidden" name='locale' id='locale' value = "<%=locale%>"> 
			<input type="hidden" name='lodger_ref_no' id='lodger_ref_no' value = "<%=lodger_ref_no%>"> 
			<input type="hidden" name='pat_id' id='pat_id' value = "<%=patient_id%>">  
			<input type='hidden' name='citizenvalue' id='citizenvalue' value= "">
			<input type='hidden' name='Dobs' id='Dobs' value= "">
			<input type='hidden' name='facility_id' id='facility_id' value= "<%=facility_id%>">
			<input type='hidden' name='function_id' id='function_id' value= "CHECK_IN_ACCMP_PERSON">
			<input type='hidden' name='illegalvalue' id='illegalvalue' value= "">
			<input type='hidden' name='label' id='label' value= "<%=label%>">
			<input type='hidden' name='Lodger_Max_RefNo' id='Lodger_Max_RefNo' value= "<%=Lodger_Max_RefNo%>">
			<input type='hidden' name='Lodger_Next_RefNo' id='Lodger_Next_RefNo' value= "<%=Lodger_Next_RefNo%>">
			<input type='hidden' name='mode' id='mode' value= "<%=mode%>">
			<input type='hidden' name='patientId' id='patientId' value= "">
			<input type='hidden' name='pLine_Pat_id' id='pLine_Pat_id' value= "<%=patient_id%>">
			<input type='hidden' name='location_code' id='location_code' value= "<%=location_code%>">
			<input type='hidden' name='maxPatAge' id='maxPatAge' value= "<%=max_patient_age%>">
		</form>
	<%		

	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if (rs != null)			rs.close();
			if (stmt != null)		stmt.close();
			if (rs_opn != null)		rs_opn.close();
			if (stmt_opn != null)	stmt_opn.close();
			if (PatIDRS != null)	PatIDRS.close();
			if (PatIDStmt != null)	PatIDStmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	}	%>
   </body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

