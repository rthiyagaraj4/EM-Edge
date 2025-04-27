/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
******************************************************************************************
* @MODULE			:	InPatient Management..(IP)
* @Author			:	SRIDHAR R
* @Created On		:	11 MAR 2004
* @Function Name	:	Lodger -> CheckInLodger and
						Lodger -> CheckOutLodger and
						Lodger -> CheckIn Accompanying Person and
						Lodger -> CheckOut Accompanying Person and
						Lodger -> RenewGatePass.

* @Servlet Function : To Check-In & Check-Out & Revise the Gate Pass for a Patient & the Accompanying Person who is in Lodger....
******************************************************************************************
* @Method Name  : insertLodgerDetail(req, res);
* @Fuctionality : To insert details from Check-In Lodger into IP_LODGER_DETAIL table.
******************************************************************************************
* @Method Name  : updateLodgerDetail(req, res);
* @Fuctionality : To Update IP_LODGER_DETAIL table from Check-Out Lodger.
******************************************************************************************
* @Method Name  : insertReviseGatePass(req, res);
* @Fuctionality : To insert details from Check In Lodger into IP_LODGER_GATE_PASS table.
******************************************************************************************
* @Method Name  : updateReviseGatePass(req, res);
* @Fuctionality : To Update IP_LODGER_DETAIL table from Renew Gate Pass.
******************************************************************************************
* @Method Name  : insertNewValuesGatePass(req, res);
* @Fuctionality : To insert details from Amend Gate Pass into IP_LODGER_GATE_PASS table.
******************************************************************************************
* @BUSINESS LOGIC : LODGER is a patient who is discharged from Hospital & still remains in Hospital Premises ...

******************************************************************************************

*/

package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
import com.ehis.util.*;

public class BookLodgerServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
    java.util.Properties p;
	String sStyle;
	/*String function_id				= "";
	String table_name				= "";
    String attached_to_inpatient_yn = "N" ;
	String period_from_date_time;
	String period_to_date_time;
	String authorised_by ;
	String Authorised_lookup ;
	String Authorised_text ;
	String lodger_patient_id  ;

	String citizen= "";
	String legal = "";
	String alt_id1_exp_date ;
	String alt_id2_exp_date ;
	String alt_id3_exp_date ;
	String alt_id4_exp_date ;
	String dateofbirth ;
	String encounter_id;
	String client_ip_address ;
	String facilityId;
	String locale;

	Statement UpdateStmt = null;
	Statement stmt = null;
	ResultSet PatIDRs = null;
	Statement PatIDStmt = null ;
	Statement SrlStmt= null;

	String name_prefix           = "";
	String first_name            = "";
	String second_name           = "";
	String third_name            = "";
	String family_name           = "";
	String name_suffix			 = "";
	String name_prefix_loc_lang  = "";
	String first_name_loc_lang	 = "";
	String second_name_loc_lang  = "";
	String third_name_loc_lang	 = "";
	String family_name_loc_lang  = "";
	String name_suffix_loc_lang	 = "";
	String patient_name_loc_lang = "";
	String nursing_unit			 = "";*/

    HttpSession session;
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

	//	String function_id			= "";
		String facilityId			= "";
		String client_ip_address	= "";
		String locale				= "";
        session						= req.getSession(false);
        this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
        facilityId					= (String) session.getValue( "facility_id" ) ;
		sStyle						= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
        client_ip_address			= p.getProperty("client_ip_address");
		locale						= p.getProperty("LOCALE");


        try
        {
            this.out = res.getWriter();

			String mode = checkForNull(req.getParameter("mode"));

	//		function_id = checkForNull(req.getParameter("function_id")) ;
			String func ="";
			func = checkForNull(req.getParameter("ReviseGatePass"));

			if( mode.equals("insert") )
			{
			    insertLodgerDetail(req);
			}
			else
			if( mode.equals("update") && func.equals("PASS"))
			{
				updateReviseGatePass(req);
				insertNewValuesGatePass(req);
			}
			else
			{
				updateLodgerDetail(req);
			}

		}catch(Exception e)
        {
            e.printStackTrace();
        }
    }

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	try
	{
		doPost(req,res);
	}
	catch(Exception e)	{
		System.out.println("Exception in line no 162 : "+e.getMessage());
		e.printStackTrace();
	}
}

private void insertLodgerDetail(HttpServletRequest req)
{
	String function_id			= "";
	String facilityId			= "";
	String client_ip_address	= "";
	String locale				= "";
	String table_name			= "";
    String attached_to_inpatient_yn = "N" ;
	String period_from_date_time	= "";
	String period_to_date_time	= "";
	String authorised_by		= "";
	String Authorised_lookup	= "";
	String Authorised_text		= "";
	String lodger_patient_id	= "";

	String citizen				= "";
	String legal				= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String dateofbirth			= "";
	String encounter_id			= "";
	Statement UpdateStmt		= null;
	Statement stmt				= null;
	ResultSet PatIDRs			= null;
	Statement PatIDStmt			= null ;
	/* CheckStyle Violation Commented by Munisekhar */
	//Statement SrlStmt			= null;
	Connection con				= null;
	String name_prefix           = "";
	String first_name            = "";
	String second_name           = "";
	String third_name            = "";
	String family_name           = "";
	String name_suffix			 = "";
	String name_prefix_loc_lang  = "";
	String first_name_loc_lang	 = "";
	String second_name_loc_lang  = "";
	String third_name_loc_lang	 = "";
	String family_name_loc_lang  = "";
	String name_suffix_loc_lang	 = "";
	String patient_name_loc_lang = "";
	String nursing_unit			 = "";
	String lodger_name="";
	String lodger_name_long="";
	String lodger_name_loc_lang_long="";
	session						= req.getSession(false);
    this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
    facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	locale						= p.getProperty("LOCALE");
	try
	{

		con = ConnectionManager.getConnection(req);
		if( req.getParameter("Category").equals("A") )
		{
			attached_to_inpatient_yn = "Y" ;
		}
		else
			attached_to_inpatient_yn = "N" ;

		lodger_patient_id       =  checkForNull(req.getParameter("patientId"));
		encounter_id            =  checkForNull(req.getParameter("encounter_id"));
		authorised_by           =  checkForNull(req.getParameter("authorised_by"));
		Authorised_lookup		=  checkForNull(req.getParameter("Authorised_lookup"));
		Authorised_text         =  checkForNull(req.getParameter("Authorised_text"));
		nursing_unit			=  checkForNull(req.getParameter("location_code"));

		function_id = checkForNull(req.getParameter("function_id")) ;

			if(!Authorised_text.equals(""))
				authorised_by = Authorised_text ;
			else
			if(!Authorised_lookup.equals(""))
				authorised_by = Authorised_lookup ;

		period_from_date_time      =  checkForNull(req.getParameter("period_from"));
		period_to_date_time      =  checkForNull(req.getParameter("period_to"));

		period_from_date_time = DateUtils.convertDate(period_from_date_time,"DMYHM",locale,"en");
		period_to_date_time = DateUtils.convertDate(period_to_date_time,"DMYHM",locale,"en");
		
		if(function_id.equals("CHECK_IN_ACCMP_PERSON") || function_id.equals("CHECK_IN_LODGER"))
		{

			citizen	= "";
			legal	= "";

			//Statement StatusStmt = null;
			//ResultSet StatusRS	= null;
			//StringBuffer StatusSql = new StringBuffer();

			//StatusSql.append(" select CITIZEN_YN, LEGAL_YN from mp_patient where patient_id='"+lodger_patient_id+"' ");
			/*StatusSql.append(" select CITIZEN_YN, LEGAL_YN,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG from mp_patient where patient_id='"+lodger_patient_id+"' ");

			StatusStmt = con.createStatement();
			StatusRS = StatusStmt.executeQuery(StatusSql.toString());
			if(StatusRS != null)
			{
				if(StatusRS.next())
				{*/
					citizen					= checkForNull(req.getParameter("citizen"));
					legal					= checkForNull(req.getParameter("legal"));
					name_prefix				= checkForNull(req.getParameter("name_prefix"));
					first_name				= checkForNull(req.getParameter("first_name"));
					second_name				= checkForNull(req.getParameter("second_name"));
					third_name				= checkForNull(req.getParameter("third_name"));
					family_name				= checkForNull(req.getParameter("family_name"));
					name_suffix				= checkForNull(req.getParameter("name_suffix"));
					name_prefix_loc_lang	=  checkForNull(req.getParameter("name_prefix_oth_lang"));
					first_name_loc_lang		= checkForNull(req.getParameter("first_name_oth_lang"));
					second_name_loc_lang	= checkForNull(req.getParameter("second_name_oth_lang"));
					third_name_loc_lang		= checkForNull(req.getParameter("third_name_oth_lang"));
					family_name_loc_lang	= checkForNull(req.getParameter("family_name_oth_lang"));
					name_suffix_loc_lang	= checkForNull(req.getParameter("name_suffix_oth_lang"));
					patient_name_loc_lang	= checkForNull(req.getParameter("patient_name_local_lang"));
					if(patient_name_loc_lang !=null && patient_name_loc_lang.length()>100){
						patient_name_loc_lang=patient_name_loc_lang.substring(0,100);
					}
					
				/*
				}
			}*/

			//if(StatusRS != null) StatusRS.close();
			//if(StatusStmt != null) StatusStmt.close();

		}
		else
		{
			citizen	= checkForNull(req.getParameter("citizenvalue"));
			legal	= checkForNull(req.getParameter("illegalvalue"));

		}
		citizen	= checkForNull(req.getParameter("citizenvalue"));
		legal	= checkForNull(req.getParameter("illegalvalue"));

		if( citizen == null || citizen.equals("") )
				citizen = "N";

			if( legal == null || legal.equals("") )
				legal = "N";

		alt_id1_exp_date = checkForNull(req.getParameter("alt_id1_exp_date"));
		alt_id2_exp_date = checkForNull(req.getParameter("alt_id2_exp_date"));
		alt_id3_exp_date = checkForNull(req.getParameter("alt_id3_exp_date"));
		alt_id4_exp_date = checkForNull(req.getParameter("alt_id4_exp_date"));

		alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");
		alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");
		alt_id3_exp_date = DateUtils.convertDate(alt_id3_exp_date,"DMY",locale,"en");
		alt_id4_exp_date = DateUtils.convertDate(alt_id4_exp_date,"DMY",locale,"en");

		dateofbirth	= checkForNull(req.getParameter("date_of_birth"));
		if(dateofbirth == null || dateofbirth.equals(""))
		{
			dateofbirth	= req.getParameter("Dobs");
		}
		dateofbirth = DateUtils.convertDate(dateofbirth,"DMY",locale,"en");

		String addedById			 = p.getProperty( "login_user" ) ;
		String addedFacilityId		 = facilityId;
		String addedAtWorkstation	 = client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String error				 = "";

		String error_value = "0" ;

		Timestamp added_date = new Timestamp(System.currentTimeMillis() );
		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		int countVal = 0;
		StringBuffer PatIDSql = new StringBuffer();
		PatIDSql.append("select count(*) from ip_open_encounter where patient_id = '"+lodger_patient_id+"' and facility_id='"+facilityId+"' ");
		PatIDStmt = con.createStatement () ;
		PatIDRs = PatIDStmt.executeQuery(PatIDSql.toString()) ;
		if(PatIDRs != null)
		{
			while(PatIDRs.next())
			{
				countVal = PatIDRs.getInt(1);
			}
		}

		if(countVal > 0 )
			error_value = "1" ;
		else
			error_value = "0" ;

 		if(PatIDRs !=null)	PatIDRs.close();
		if(PatIDStmt!=null)	PatIDStmt.close();

	if(error_value.equals("0"))
	{
		ResultSet rs = null;
		String p_check_out_yn = "Y";
		String p_check_inpatient_yn="";
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT check_out_yn,attached_to_inpatient_yn FROM IP_LODGER_DETAIL WHERE facility_id='"+facilityId+"' AND lodger_patient_id='"+lodger_patient_id+"' AND lodger_ref_no=(SELECT MAX(lodger_ref_no) FROM IP_LODGER_DETAIL WHERE facility_id='"+facilityId+"' AND lodger_patient_id='"+lodger_patient_id+"') ");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql.toString());
		while (rs.next())
		{
			p_check_out_yn=rs.getString("check_out_yn");
			p_check_inpatient_yn=rs.getString("attached_to_inpatient_yn");
		}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if (p_check_out_yn.equals("Y"))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select to_char(sysdate,'rrrr') || ltrim(to_char(LODGER_NEXT_SRL_NO,'00000009'))lodger_ref_no  from ip_param where facility_id= '"+addedFacilityId+"' " );
		stmt = con.createStatement();

		rs = stmt.executeQuery(sql.toString());
		String lodger_ref_no = "0" ;
		if( rs!=null )
		{
			if( rs.next() )
			{
				lodger_ref_no = rs.getString(1) ;
			}
		}
		if(rs!=null) rs.close();
		if(stmt != null) stmt.close();

		HashMap tabdata=new HashMap();

		tabdata.put("facility_id",facilityId);

		if(attached_to_inpatient_yn.equals("N"))
			tabdata.put("reason_for_stay_code",checkForNull(req.getParameter("reason_for_stay")));

		if(encounter_id!=null &&  !encounter_id.equals(""))
			tabdata.put("patient_encounter_id", new Long (Long.parseLong(encounter_id)));
		else
		tabdata.put("patient_encounter_id", "null" );
		tabdata.put("lodger_patient_id",lodger_patient_id);
		lodger_name=checkForNull(req.getParameter("patient_name"));
		if(lodger_name !=null && lodger_name.length()>100){
			lodger_name=lodger_name.substring(0,100);
		}
		
		lodger_name_long=checkForNull(req.getParameter("patient_name_long"));
		if(lodger_name_long !=null && lodger_name_long.length()>300){
			lodger_name_long=lodger_name_long.substring(0,300);
		}

		lodger_name_loc_lang_long=checkForNull(req.getParameter("patient_name_loc_lang_long"));
		if(lodger_name_loc_lang_long !=null && lodger_name_loc_lang_long.length()>300){
			lodger_name_loc_lang_long=lodger_name_loc_lang_long.substring(0,300);
		}

		tabdata.put("lodger_name",lodger_name);
		tabdata.put("LODGER_LONG_NAME",lodger_name_long);
		tabdata.put("LODGER_LONG_NAME_LOC_LANG",lodger_name_loc_lang_long);
		tabdata.put("attached_to_inpatient_yn",attached_to_inpatient_yn);
		tabdata.put("lodger_relation_code",checkForNull(req.getParameter("reln_with_patient")));
		tabdata.put("check_out_yn","N");
		tabdata.put("lodger_ref_no",lodger_ref_no);
		tabdata.put("lodger_gender",checkForNull(req.getParameter("sex")));
		StringTokenizer tokenfrom1 = new StringTokenizer(period_from_date_time," ") ;
		if(tokenfrom1.hasMoreTokens())
		{
			StringTokenizer tokenfrom2 = new StringTokenizer(tokenfrom1.nextToken(),"/");
			String fromarr[] =new String[3] ;
			for( int a=0;a<3;a++ )
			{
				if(tokenfrom2.hasMoreTokens())
				{
				fromarr[a] = tokenfrom2.nextToken() ;
				}
			}
			while (tokenfrom1.hasMoreTokens())
			period_from_date_time = fromarr[2] + "-" + fromarr[1] + "-" + fromarr[0] + " " + tokenfrom1.nextToken() + ":00";
		}

		Timestamp PeriodFromStamp = Timestamp.valueOf(period_from_date_time);
		tabdata.put("PERIOD_FROM_DATE",PeriodFromStamp);
		tabdata.put("check_in_date_time",PeriodFromStamp);

	/* PERIOD TO DATE TIME VALIDATIONS */
		if(period_to_date_time != null && !period_to_date_time.equals(""))
		{
			StringTokenizer tokento1 = new StringTokenizer(period_to_date_time," ") ;
			if(tokento1.hasMoreTokens())
			{
				StringTokenizer tokento2 = new StringTokenizer(tokento1.nextToken(),"/");
				String toarr[] =new String[3] ;
				for( int m=0;m<3;m++ )
				{

					if(tokento2.hasMoreTokens())
					{
					toarr[m] = tokento2.nextToken() ;
					}
				}

				while (tokento1.hasMoreTokens())
				period_to_date_time = toarr[2] + "-" +toarr[1]+ "-" +toarr[0]+ " "+tokento1.nextToken() + ":00";
			}

			Timestamp PeriodToStamp = Timestamp.valueOf(period_to_date_time);
			tabdata.put("PERIOD_TO_DATE",PeriodToStamp);
		}

		tabdata.put("NURSING_UNIT_CODE",checkForNull(req.getParameter("lodger_nursing_unit")));
		tabdata.put("REMARKS",checkForNull(req.getParameter("remarks")));
		tabdata.put("AUTHORISED_BY",authorised_by);
		tabdata.put("NATIONAL_ID_NO",checkForNull(req.getParameter("national_id_no")));
		tabdata.put("BIRTH_PLACE_CODE",checkForNull(req.getParameter("Birth_place_code")));
		tabdata.put("CITIZEN_YN",citizen);
		tabdata.put("LEGAL_YN",legal);
		tabdata.put("NATIONALITY_CODE",checkForNull(req.getParameter("nationality_code1")));

		/* DATE OF BIRTH VALIDATIONS */
		if (dateofbirth != null && !dateofbirth.equals(""))
		{
			StringTokenizer birth2 = new StringTokenizer(dateofbirth,"/");
			String DobArr[] =new String[3] ;
			for( int p=0;p<3;p++ )
			{
				if(birth2.hasMoreTokens())
				{
				DobArr[p] = birth2.nextToken();
				}
			}
			dateofbirth = DobArr[2] + "-" + DobArr[1] + "-" + DobArr[0];

			java.sql.Date DobDate = java.sql.Date.valueOf( dateofbirth ) ;
			tabdata.put("LODGER_DOB",DobDate);
		}

		tabdata.put("ETHNIC_GROUP_CODE",checkForNull(req.getParameter("ethnic_group")));
		tabdata.put("RACE_CODE",checkForNull(req.getParameter("race_code")));
		tabdata.put("ALT_ID1_NO",checkForNull(req.getParameter("alt_id1_no")));
		tabdata.put("ALT_ID2_NO",checkForNull(req.getParameter("alt_id2_no")));
		tabdata.put("ALT_ID3_NO",checkForNull(req.getParameter("alt_id3_no")));
		tabdata.put("ALT_ID4_NO",checkForNull(req.getParameter("alt_id4_no")));

/*!!!!!!!!!!!!!!! DATE VALIDATIONS For Alternate Date's !!!!!!!!!!!!!!*/
	/*!!!!!!!!!!!! ADDED ON 01 MARCH BY SRIDHAR !!!!!!!!!!!!!*/


	if (alt_id1_exp_date != null && !alt_id1_exp_date.equals(""))
	{
		StringTokenizer Alt1token = new StringTokenizer(alt_id1_exp_date,"/");
		String Alt1Arr[] =new String[3] ;
		for( int a=0;a<3;a++ )
		{
			if(Alt1token.hasMoreTokens())
			{
			Alt1Arr[a] = Alt1token.nextToken();
			}
		}
		alt_id1_exp_date = Alt1Arr[2] + "-" + Alt1Arr[1] + "-" + Alt1Arr[0];
		java.sql.Date alt_id1_date = java.sql.Date.valueOf( alt_id1_exp_date ) ;
		tabdata.put("ALT_ID1_EXP_DATE",alt_id1_date);
	}


	if (alt_id2_exp_date != null && !alt_id2_exp_date.equals(""))
	{
		StringTokenizer Alt2token = new StringTokenizer(alt_id2_exp_date,"/");
		String Alt2Arr[] =new String[3] ;
		for( int b=0;b<3;b++ )
		{
			if(Alt2token.hasMoreTokens())
			{
			Alt2Arr[b] = Alt2token.nextToken();
			}
		}
		alt_id2_exp_date = Alt2Arr[2] + "-" + Alt2Arr[1] + "-" + Alt2Arr[0];
		java.sql.Date alt_id2_date = java.sql.Date.valueOf( alt_id2_exp_date ) ;
		tabdata.put("ALT_ID2_EXP_DATE",alt_id2_date);
	}


	if (alt_id3_exp_date != null && !alt_id3_exp_date.equals(""))
	{
		StringTokenizer Alt3token = new StringTokenizer(alt_id3_exp_date,"/");
		String Alt3Arr[] =new String[3] ;
		for( int c=0;c<3;c++ )
		{
			if(Alt3token.hasMoreTokens())
			{
			Alt3Arr[c] = Alt3token.nextToken();
			}
		}
		alt_id3_exp_date = Alt3Arr[2] + "-" + Alt3Arr[1] + "-" + Alt3Arr[0];
		java.sql.Date alt_id3_date = java.sql.Date.valueOf( alt_id3_exp_date ) ;
		tabdata.put("ALT_ID3_EXP_DATE",alt_id3_date);
	}


	if (alt_id4_exp_date != null && !alt_id4_exp_date.equals(""))
	{
		StringTokenizer Alt4token = new StringTokenizer(alt_id4_exp_date,"/");
		String Alt4Arr[] =new String[3] ;
		for( int d=0;d<3;d++ )
		{
		if(Alt4token.hasMoreTokens())
			{
			Alt4Arr[d] = Alt4token.nextToken();
			}
		}
		alt_id4_exp_date = Alt4Arr[2] + "-" + Alt4Arr[1] + "-" + Alt4Arr[0];
		java.sql.Date alt_id4_date = java.sql.Date.valueOf( alt_id4_exp_date ) ;
		tabdata.put("ALT_ID4_EXP_DATE",alt_id4_date);

	}
	/*!!!!!! DATE VALIDATIONS ADDED ON 01 MARCH BY SRIDHAR !!!!!*/


		tabdata.put("ALT_ID1_TYPE",checkForNull(req.getParameter("alt_id1_type")));
		tabdata.put("ALT_ID2_TYPE",checkForNull(req.getParameter("alt_id2_type")));
		tabdata.put("ALT_ID3_TYPE",checkForNull(req.getParameter("alt_id3_type")));
		tabdata.put("ALT_ID4_TYPE",checkForNull(req.getParameter("alt_id4_type")));

		tabdata.put("OTH_ALT_ID_TYPE",checkForNull(req.getParameter("other_alt_type")));
		tabdata.put("OTH_ALT_ID_NO",checkForNull(req.getParameter("other_alt_Id")));

		/*
		tabdata.put("NAME_PREFIX",checkForNull(req.getParameter("name_prefix")));
		tabdata.put("FIRST_NAME",checkForNull(req.getParameter("first_name")));
		tabdata.put("SECOND_NAME",checkForNull(req.getParameter("second_name")));
		tabdata.put("THIRD_NAME",checkForNull(req.getParameter("third_name")));
		tabdata.put("FAMILY_NAME",checkForNull(req.getParameter("family_name")));
		tabdata.put("NAME_SUFFIX",checkForNull(req.getParameter("name_suffix")));

		tabdata.put("NAME_PREFIX_LOC_LANG",checkForNull(req.getParameter("name_prefix_oth_lang")));
		tabdata.put("FIRST_NAME_LOC_LANG",checkForNull(req.getParameter("first_name_oth_lang")));
		tabdata.put("SECOND_NAME_LOC_LANG",checkForNull(req.getParameter("second_name_oth_lang")));
		tabdata.put("THIRD_NAME_LOC_LANG",checkForNull(req.getParameter("third_name_oth_lang")));
		tabdata.put("FAMILY_NAME_LOC_LANG",checkForNull(req.getParameter("family_name_oth_lang")));
		tabdata.put("NAME_SUFFIX_LOC_LANG",checkForNull(req.getParameter("name_suffix_oth_lang")));
		tabdata.put("LODGER_NAME_LOC_LANG",checkForNull(req.getParameter("patient_name_local_lang")));
		*/

		tabdata.put("NAME_PREFIX",name_prefix);
		tabdata.put("FIRST_NAME",first_name);
		tabdata.put("SECOND_NAME",second_name);
		tabdata.put("THIRD_NAME",third_name);
		tabdata.put("FAMILY_NAME",family_name);
		tabdata.put("NAME_SUFFIX",name_suffix);

		tabdata.put("NAME_PREFIX_LOC_LANG",name_prefix_loc_lang );
		tabdata.put("FIRST_NAME_LOC_LANG",first_name_loc_lang );
		tabdata.put("SECOND_NAME_LOC_LANG",second_name_loc_lang );
		tabdata.put("THIRD_NAME_LOC_LANG",third_name_loc_lang );
		tabdata.put("FAMILY_NAME_LOC_LANG",family_name_loc_lang );
		tabdata.put("NAME_SUFFIX_LOC_LANG",name_suffix_loc_lang );
		tabdata.put("LODGER_NAME_LOC_LANG",patient_name_loc_lang);

		tabdata.put("LN1_LODGER_ADD",checkForNull(req.getParameter("addr_line1")));
		tabdata.put("LN2_LODGER_ADD",checkForNull(req.getParameter("addr_line2")));
		tabdata.put("LN3_LODGER_ADD",checkForNull(req.getParameter("addr_line3")));
		tabdata.put("LN4_LODGER_ADD",checkForNull(req.getParameter("addr_line4")));
		tabdata.put("RES_TOWN_CODE",checkForNull(req.getParameter("res_town_code")));
		tabdata.put("RES_AREA_CODE",checkForNull(req.getParameter("res_area_code")));
		tabdata.put("RES_REGION_CODE",checkForNull(req.getParameter("region_code")));
		tabdata.put("RES_POSTAL_CODE",checkForNull(req.getParameter("postal_code")));
		tabdata.put("RES_COUNTRY_CODE",checkForNull(req.getParameter("country_code")));

		tabdata.put("MAIL_ADDR_LINE1",checkForNull(req.getParameter("mail_addr_line1")));
		tabdata.put("MAIL_ADDR_LINE2",checkForNull(req.getParameter("mail_addr_line2")));
		tabdata.put("MAIL_ADDR_LINE3",checkForNull(req.getParameter("mail_addr_line3")));
		tabdata.put("MAIL_ADDR_LINE4",checkForNull(req.getParameter("mail_addr_line4")));
		tabdata.put("MAIL_TOWN_CODE",checkForNull(req.getParameter("mail_res_town_code")));
		tabdata.put("MAIL_AREA_CODE",checkForNull(req.getParameter("mail_res_area_code")));
		tabdata.put("MAIL_REGION_CODE",checkForNull(req.getParameter("mail_region_code")));
		tabdata.put("MAIL_POSTAL_CODE",checkForNull(req.getParameter("mail_postal_code")));
		tabdata.put("MAIL_COUNTRY_CODE",checkForNull(req.getParameter("mail_country_code")));
		
		/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
		tabdata.put("alt_addr_line1",checkForNull(req.getParameter("alt_addr_line1")));
		tabdata.put("alt_addr_line2",checkForNull(req.getParameter("alt_addr_line2")));
		tabdata.put("alt_addr_line3",checkForNull(req.getParameter("alt_addr_line3")));
		tabdata.put("alt_addr_line4",checkForNull(req.getParameter("alt_addr_line4")));
		tabdata.put("alt_town_code",checkForNull(req.getParameter("alt_town_code")));
		tabdata.put("alt_area_code",checkForNull(req.getParameter("alt_area_code")));
		tabdata.put("alt_region_code",checkForNull(req.getParameter("alt_region_code")));
		tabdata.put("alt_postal_code",checkForNull(req.getParameter("alt_postal_code")));
		tabdata.put("alt_country_code",checkForNull(req.getParameter("alt_country_code")));
		/*End*/

		tabdata.put("lodger_res_tel_num",checkForNull(req.getParameter("contact1_no")));
        tabdata.put("lodger_off_tel_num",checkForNull(req.getParameter("contact2_no")));
		tabdata.put("LODGER_EMAIL",checkForNull(req.getParameter("email")));

		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",added_date);
		tabdata.put("added_facility_id", facilityId);
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("modified_by_id",addedById);
		tabdata.put("modified_date",modified_date);
		tabdata.put("modified_facility_id",facilityId);
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

		String dupflds[]={"facility_id","check_in_date_time","lodger_ref_no"};
		table_name			= "IP_LODGER_DETAIL";
		boolean local_ejbs	= false;


		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
		error_value = "0" ;

		UpdateStmt = con.createStatement();
			if(inserted)
			{
				if( req.getParameter("Category").equals("A") )
				{
					insertReviseGatePass(req);
				}
				if(sql.length() > 0) sql.delete(0,sql.length());
				//Added Audit column
				sql.append(" update IP_PARAM set LODGER_NEXT_SRL_NO = (LODGER_NEXT_SRL_NO+1), MODIFIED_BY_ID= '"+addedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_FACILITY_ID ='"+facilityId+"'  where facility_id='"+ facilityId +"'  " );

				int res11 = 0;
				res11 = UpdateStmt.executeUpdate(sql.toString());
				if ( res11!=0 )
				{
					con.commit();
					error_value = "1" ;
				}
			///// ADDITION FOR REPORTS on 23 JUNE 2004 by Srdhar R
				if( req.getParameter("Category").equals("A") )
				{
					doOnlineReports( encounter_id,nursing_unit,locale );
				}
			}// E.O If(inserted)
			tabdata.clear();
			results.clear();
		}
		else
		{
		   /* IP_CURRENTLY_ATTENDANT  IP_PATIENT_LODGER*/
			if( p_check_inpatient_yn.equals("Y"))
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "IP_CURRENTLY_ATTENDANT","IP" );
				error = (String) message.get("message");
				message.clear();
			}
			else
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "IP_PATIENT_LODGER","IP" );
				error = (String) message.get("message") ;
				message.clear();
			}
			error_value = "0" ;
		}

		if(error.lastIndexOf("<br>")>=0)
			error= error.substring(0,error.indexOf("<br>")) ;
		out.println("<script>alert(\""+error+"\");parent.document.getElementById('dialog_tag').close();</script>") ;
    }
	else
	{
		java.util.Hashtable message = MessageManager.getMessage( locale, "CURRENTLY_IN_PATIENT","IP");

		error = (String) message.get("message") ;

		error_value = "0" ;
		if(error.lastIndexOf("<br>")>=0)
		error= error.substring(0,error.indexOf("<br>")) ;
		out.println("<script>alert(\""+error+"\");parent.document.getElementById('dialog_tag').close();</script>") ;

		message.clear();
	}

	}catch ( Exception e )
	{
		e.printStackTrace();
	}
    finally
	{
		try
		{
			if(stmt != null)		stmt.close();
			if(UpdateStmt != null)	UpdateStmt.close();

		}catch(Exception ee)
		{
            ee.printStackTrace();
		}
			if(con != null) ConnectionManager.returnConnection(con,req);
	}
}

/**********************************************************************/
  /********************** REVISE GATE PASS ************************/
/**********************************************************************/

private void insertReviseGatePass(HttpServletRequest req)
{
	//String function_id			= "";
	String facilityId			= "";
	String client_ip_address	= "";
	String locale				= "";
	String table_name			= "";
	/* CheckStyle Violation Commented by Munisekhar */
    //String attached_to_inpatient_yn = "N" ;  
	String period_from_date_time	= "";
	/* CheckStyle Violation Commented by Munisekhar */
	String period_to_date_time	= "";
	//String authorised_by		= "";  
	//String Authorised_lookup	= "";   
	//String Authorised_text		= "";  
	String lodger_patient_id	= "";
/* CheckStyle Violation Commented by Munisekhar */
	//String citizen				= "";  
	//String legal				= ""; 
	//String alt_id1_exp_date		= ""; 
	//String alt_id2_exp_date		= "";  
	//String alt_id3_exp_date		= "";  
	//String alt_id4_exp_date		= ""; 
	//String dateofbirth			= "";  
	//String encounter_id			= "";
	//Statement UpdateStmt		= null;  
	Statement stmt				= null;
	/* CheckStyle Violation Commented by Munisekhar */
	//ResultSet PatIDRs			= null;  
	//Statement PatIDStmt			= null ; 
	Statement SrlStmt			= null;
	Connection con				= null;
	/* CheckStyle Violation Commented by Munisekhar */
	//String name_prefix           = "";
	//String first_name            = "";
	//String second_name           = "";
	//String third_name            = "";
	//String family_name           = "";
	//String name_suffix			 = "";
	//String name_prefix_loc_lang  = "";
	//String first_name_loc_lang	 = "";
	//String second_name_loc_lang  = "";
	//String third_name_loc_lang	 = "";
	//String family_name_loc_lang  = "";
	//String name_suffix_loc_lang	 = "";
	//String patient_name_loc_lang = "";
	//String nursing_unit			 = "";
	session						= req.getSession(false);
    this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
	facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	locale						= p.getProperty("LOCALE");
	try
	{
		con = ConnectionManager.getConnection(req);

		String Revised_yn = "N";

		period_from_date_time	=  checkForNull(req.getParameter("period_from"));
		period_to_date_time     =  checkForNull(req.getParameter("period_to"));


		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedFacilityId=facilityId;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String error ="";

		Timestamp added_date = new Timestamp(System.currentTimeMillis() );
		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT check_out_yn,attached_to_inpatient_yn FROM IP_LODGER_DETAIL WHERE facility_id='"+facilityId+"' AND lodger_patient_id='"+lodger_patient_id+"' AND lodger_ref_no=(SELECT MAX(lodger_ref_no) FROM IP_LODGER_DETAIL WHERE facility_id='"+facilityId+"' AND lodger_patient_id='"+lodger_patient_id+"') ");
		stmt = con.createStatement();

		rs =stmt.executeQuery(sql.toString());

		while(rs.next())
		{
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(sql.length() > 0) sql.delete(0,sql.length());


		sql.append(" select to_char(sysdate,'rrrr') || ltrim(to_char(LODGER_NEXT_SRL_NO,'00000009'))lodger_ref_no  from ip_param where facility_id= '"+addedFacilityId+"' " );
		stmt = con.createStatement();

		rs =stmt.executeQuery(sql.toString());

		String lodger_ref_no = "0" ;
		if( rs!=null )
		{
			if( rs.next() )
			{
				lodger_ref_no = rs.getString(1) ;
			}
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		int SRL_NO = 1;

	HashMap gatetabdata=new HashMap();

	if(period_from_date_time != null && !period_from_date_time.equals(""))
	{
		StringTokenizer tokenfrom1 = new StringTokenizer(period_from_date_time," ") ;

		if(tokenfrom1.hasMoreTokens())
		{
			StringTokenizer tokenfrom2 = new StringTokenizer(tokenfrom1.nextToken(),"/");
			String fromarr[] =new String[3] ;
			for( int a=0;a<3;a++ )
			{
				if(tokenfrom2.hasMoreTokens())
					fromarr[a] = tokenfrom2.nextToken() ;
			}
			while (tokenfrom1.hasMoreTokens())
			period_from_date_time = fromarr[2] + "-" + fromarr[1] + "-" + fromarr[0] + " " + tokenfrom1.nextToken() + ":00";
		}
		Timestamp PeriodFromStamp = Timestamp.valueOf(period_from_date_time);
		gatetabdata.put("PERIOD_FROM_DATE",PeriodFromStamp);
}

	if(period_to_date_time != null && !period_to_date_time.equals(""))
	{
		StringTokenizer tokento1 = new StringTokenizer(period_to_date_time," ") ;
		if(tokento1.hasMoreTokens())
		{
			StringTokenizer tokento2 = new StringTokenizer(tokento1.nextToken(),"/");
			String toarr[] =new String[3] ;
			for( int m=0;m<3;m++ )
			{
				if(tokento2.hasMoreTokens())
					toarr[m] = tokento2.nextToken() ;
			}
		while (tokento1.hasMoreTokens())
		period_to_date_time = toarr[2] + "-" + toarr[1] + "-" + toarr[0] + " " + tokento1.nextToken() + ":00";
		}
		Timestamp PeriodToStamp = Timestamp.valueOf(period_to_date_time);
		gatetabdata.put("PERIOD_TO_DATE",PeriodToStamp);
	}

		gatetabdata.put("Remarks",checkForNull(req.getParameter("remarks")));
		gatetabdata.put("facility_id",facilityId);
		gatetabdata.put("lodger_ref_no",lodger_ref_no);
		gatetabdata.put("added_by_id",addedById);
		gatetabdata.put("added_date",added_date);
		gatetabdata.put("added_at_facility_id", facilityId);
		gatetabdata.put("added_at_ws_no",addedAtWorkstation);
		gatetabdata.put("modified_by_id",modifiedById);
		gatetabdata.put("modified_date",modified_date);
		gatetabdata.put("modified_at_facility_id",facilityId);
		gatetabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		gatetabdata.put("REVISED_YN",Revised_yn);

		Integer I_SRL_NO =new Integer(SRL_NO);
		String Str_Srl_No =I_SRL_NO.toString();
		gatetabdata.put("SRL_NO",Str_Srl_No);


		String dupflds[]={"facility_id","lodger_ref_no","SRL_NO"};

		table_name			= "ip_lodger_gate_pass";
		boolean local_ejbs	= false;


		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = gatetabdata;
		argArray[2] = dupflds;
		argArray[3] = table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = gatetabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
		if(!inserted)
		{
			if(error.lastIndexOf("<br>")>=0)
			error= error.substring(0,error.indexOf("<br>")) ;
			out.println("<script>alert(\""+error+"\");document.getElementById('dialog_tag').close();;</script>") ;
		}
		else
		{
			con.commit();
		    if(error.lastIndexOf("<br>")>=0)
			error= error.substring(0,error.indexOf("<br>")) ;
			// commented by marwan to avoid two alerts appearing,
			// this function is only called from insertLodgerDetail() so alert from insertLodgerDetail() fn is enough
			// out.println("<script>alert(\""+error+"\");</script>") ;
		
		}
		gatetabdata.clear();
		results.clear();

	}catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{

		if(stmt != null) stmt.close();
		if(SrlStmt != null) SrlStmt.close();
		if(con != null)
		ConnectionManager.returnConnection(con,req);
		}
		catch(Exception ee)
		{
            ee.printStackTrace();
		}
	}
}

private void updateLodgerDetail(HttpServletRequest req)
{

	//String function_id			= "";
	String facilityId			= "";
	String client_ip_address	= "";
	String locale				= "";
	String table_name			= "";
	Connection con				= null;
	/* CheckStyle Violation Commented by Munisekhar */
    //String attached_to_inpatient_yn = "N" ;
      //  String period_from_date_time	= "";
//String period_to_date_time	= "";
	//String authorised_by		= "";
	//String Authorised_lookup	= "";
	//String Authorised_text		= "";
	//String lodger_patient_id	= "";
	//String citizen				= "";
	//String legal				= "";
	//String alt_id1_exp_date		= "";
	//String alt_id2_exp_date		= "";
	//String alt_id3_exp_date		= "";
	//String alt_id4_exp_date		= "";
	//String dateofbirth			= "";
	//String encounter_id			= "";
	//Statement UpdateStmt		= null;
	//Statement stmt				= null;
	//ResultSet PatIDRs			= null;
	//Statement PatIDStmt			= null ;
	//Statement SrlStmt			= null;
	//String name_prefix           = "";
	//String first_name            = "";
	//String second_name           = "";
	//String third_name            = "";
	//String family_name           = "";
	//String name_suffix			 = "";
	//String name_prefix_loc_lang  = "";
	//String first_name_loc_lang	 = "";
	//String second_name_loc_lang  = "";
	//String third_name_loc_lang	 = "";
        //String family_name_loc_lang  = "";
	//String name_suffix_loc_lang	 = "";
	//String patient_name_loc_lang = "";
	//String nursing_unit			 = "";
	session						= req.getSession(false);
    this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
	facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	locale						= p.getProperty("LOCALE");
	try
	{

		con = ConnectionManager.getConnection(req);
		String check_out_date_time  =  req.getParameter("chk_out_dt_time");
		if(check_out_date_time==null || check_out_date_time.equals("") || check_out_date_time=="")
			check_out_date_time= "";
		else
			check_out_date_time = DateUtils.convertDate(check_out_date_time,"DMYHM",locale,"en");

		String check_in_date_time   =  req.getParameter("chk_in_dt_time");
		if(check_in_date_time==null || check_in_date_time.equals("") || check_in_date_time=="")
			check_in_date_time= "";
		/*else
			check_in_date_time = DateUtils.convertDate(check_in_date_time,"DMYHM",locale,"en");*/

		String lodger_ref_no        =  req.getParameter("lodger_ref_no");

		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;

		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		StringTokenizer toks = new StringTokenizer (check_in_date_time," ") ;
		StringTokenizer tok1 = new StringTokenizer (toks.nextToken(), "/" ) ;
		String arr[] =new String[3] ;
		for( int o=0;o<3;o++ )
				arr[o] = tok1.nextToken() ;

		check_in_date_time = arr[2] +"-"+arr[1]+"-"+ arr[0]+" "+toks.nextToken()+":00"   ;
		Timestamp timestamp= Timestamp.valueOf(check_in_date_time);

		toks =null;
		tok1 =null ;
		arr =null;
		toks = new StringTokenizer (check_out_date_time," ") ;
		tok1 = new StringTokenizer (toks.nextToken(), "/" ) ;
		arr =new String[3] ;
		for( int o=0;o<3;o++ )
				arr[o] = tok1.nextToken() ;

		check_out_date_time = arr[2]    +"-"+arr[1]+"-"+ arr[0]+" "+toks.nextToken()+":00"   ;
		Timestamp timestamp1 = Timestamp.valueOf(check_out_date_time);

	 HashMap tabdata=new HashMap();

	tabdata.put("check_out_date_time",timestamp1);
	tabdata.put("check_out_yn","Y");
	tabdata.put("modified_by_id",modifiedById);
	tabdata.put("modified_date",modified_date);
	tabdata.put("modified_facility_id",facilityId);
	tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

	HashMap condflds=new HashMap();
	condflds.put("facility_id",facilityId);
	condflds.put("check_in_date_time",timestamp);
	condflds.put("lodger_ref_no",lodger_ref_no);

	table_name			= "ip_lodger_detail";
	boolean local_ejbs	= false;

	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[4];
	argArray[0] = p;
	argArray[1] = tabdata;
	argArray[2] = condflds;
	argArray[3] = table_name;

	Class [] paramArray = new Class[4];
	paramArray[0] = p.getClass();
	paramArray[1] = tabdata.getClass();
	paramArray[2] = condflds.getClass();
	paramArray[3] = table_name.getClass();

	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

	String error = (String) results.get("error") ;

	if ( inserted )
	{
		java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
		error = (String) message.get("message") ;
		message.clear();
	}
	else
	{
		error = (String) results.get("error") ;
		error = "Errors Encountered..";
	}
	if(error.lastIndexOf("<br>")>=0)
	error= error.substring(0,error.indexOf("<br>")) ;
	out.println("<script>alert(\""+error+"\");parent.document.getElementById('dialog_tag').close();</script>") ;
	tabdata.clear();
	condflds.clear();
	results.clear();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,req);
	}
}

private void updateReviseGatePass(HttpServletRequest req)
{
	//String function_id			= "";
	String facilityId			= "";
	String client_ip_address	= "";
	String locale				= "";
	String table_name			= "";
	/* CheckStyle Violation Commented by Munisekhar */
    // String attached_to_inpatient_yn = "N" ;
	//String period_from_date_time	= "";
	//String period_to_date_time	= "";
	String authorised_by		= "";
	String Authorised_lookup	= "";
	String Authorised_text		= "";
	/* CheckStyle Violation Commented by Munisekhar */
	//String lodger_patient_id	= "";
	//String citizen				= "";
	//String legal				= "";
	//String alt_id1_exp_date		= "";
	//String alt_id2_exp_date		= "";
	//String alt_id3_exp_date		= "";
	//String alt_id4_exp_date		= "";
	//String dateofbirth			= "";
	//String encounter_id			= "";
	//Statement UpdateStmt		= null;
	//Statement stmt				= null;
	//ResultSet PatIDRs			= null;
	//Statement PatIDStmt			= null ;
	//Statement SrlStmt			= null;
	Connection con				= null;
	/* CheckStyle Violation Commented by Munisekhar */
	//String name_prefix           = "";
	//String first_name            = "";
	//String second_name           = "";
	//String third_name            = "";
	//String family_name           = "";
	//String name_suffix			 = "";
	//String name_prefix_loc_lang  = "";
	//String first_name_loc_lang	 = "";
	//String second_name_loc_lang  = "";
	//String third_name_loc_lang	 = "";
	//String family_name_loc_lang  = "";
	//String name_suffix_loc_lang	 = "";
	//String patient_name_loc_lang = "";
	//String nursing_unit			 = "";
	session						= req.getSession(false);
    this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
	facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	locale						= p.getProperty("LOCALE");
	try
	{

		con = ConnectionManager.getConnection(req);

		authorised_by           =  req.getParameter("authorised_by");
		if(authorised_by==null || authorised_by.equals("") || authorised_by=="")
			authorised_by= "";

		Authorised_lookup		=  req.getParameter("Authorised_lookup");
		if(Authorised_lookup==null || Authorised_lookup.equals("") || Authorised_lookup=="")
			Authorised_lookup= "";

		Authorised_text         =  req.getParameter("Authorised_text");
		if(Authorised_text==null || Authorised_text.equals("") || Authorised_text=="")
			Authorised_text= "";

			if(!Authorised_text.equals(""))
				authorised_by = Authorised_text ;
			else
			if(!Authorised_lookup.equals(""))
				authorised_by = Authorised_lookup ;


		String Revise_period_from_date = req.getParameter("revise_period_from");
		if(Revise_period_from_date==null || Revise_period_from_date.equals("") || Revise_period_from_date=="")
			Revise_period_from_date= "";

		Revise_period_from_date = DateUtils.convertDate(Revise_period_from_date,"DMYHM",locale,"en");

		String Revise_period_to_date = req.getParameter("revise_period_to");
		if(Revise_period_to_date==null || Revise_period_to_date.equals("") || Revise_period_to_date=="")
			Revise_period_to_date= "";

		Revise_period_to_date = DateUtils.convertDate(Revise_period_to_date,"DMYHM",locale,"en");


		String lodger_ref_no        =  req.getParameter("lodger_ref_no");
		if(lodger_ref_no==null || lodger_ref_no.equals("") || lodger_ref_no=="")	lodger_ref_no= "";

		String modifiedById = p.getProperty( "login_user" ) ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;

		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		HashMap tabdata=new HashMap();

		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",modified_date);
		tabdata.put("modified_facility_id",facilityId);
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		tabdata.put("REMARKS",checkForNull(req.getParameter("ReviseRemarks")));
		tabdata.put("AUTHORISED_BY",authorised_by);

if(Revise_period_from_date != null && !Revise_period_from_date.equals(""))
{
	StringTokenizer ReviseTokenFrom1 = new StringTokenizer(Revise_period_from_date," ") ;

	if(ReviseTokenFrom1.hasMoreTokens())
	{

		StringTokenizer ReviseTokenFrom2 = new StringTokenizer(ReviseTokenFrom1.nextToken(),"/");
		String ToArr[] =new String[3] ;
		for( int j=0;j<3;j++ )
		{
			if(ReviseTokenFrom2.hasMoreTokens())
			{
			ToArr[j] = ReviseTokenFrom2.nextToken() ;
			}
		}
		while (ReviseTokenFrom1.hasMoreTokens())
		Revise_period_from_date = ToArr[2] + "-" + ToArr[1] + "-" + ToArr[0] + " " + ReviseTokenFrom1.nextToken() + ":00";
	}
	Timestamp RevisePeriodFrom = Timestamp.valueOf(Revise_period_from_date);
	tabdata.put("PERIOD_FROM_DATE",RevisePeriodFrom);
}


if(Revise_period_to_date != null && !Revise_period_to_date.equals(""))
{
	StringTokenizer ReviseTokenTo1 = new StringTokenizer(Revise_period_to_date," ") ;

	if(ReviseTokenTo1.hasMoreTokens())
	{
		StringTokenizer ReviseTokenTo2 = new StringTokenizer(ReviseTokenTo1.nextToken(),"/");
		String ToArr[] =new String[3] ;
		for( int i=0;i<3;i++ )
		{
			if(ReviseTokenTo2.hasMoreTokens())
			{
			ToArr[i] = ReviseTokenTo2.nextToken() ;
			}
		}

		while (ReviseTokenTo1.hasMoreTokens())
		Revise_period_to_date = ToArr[2] + "-" + ToArr[1] + "-" + ToArr[0] + " " + ReviseTokenTo1.nextToken() + ":00";
	}
	Timestamp RevisePeriodTo = Timestamp.valueOf(Revise_period_to_date);
	tabdata.put("PERIOD_TO_DATE",RevisePeriodTo);
}


			HashMap condflds=new HashMap();
			condflds.put("facility_id",facilityId);
			condflds.put("lodger_ref_no",lodger_ref_no);

			table_name			= "ip_lodger_detail";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			if ( inserted )
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM") ;
				error = (String) message.get("message") ;
				message.clear();
			}
			else
			{
				error = (String) results.get("error") ;
				error = "Errors Encountered..";
		}
		if(error.lastIndexOf("<br>")>=0)
		error= error.substring(0,error.indexOf("<br>")) ;


		results.clear();
		condflds.clear();
		tabdata.clear();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	 ConnectionManager.returnConnection(con,req);
	}
}


private void insertNewValuesGatePass(HttpServletRequest req)
{
	//  method inserting new values for same lodger_ref_no with incremented srl_no, values taken from AmendGatePasDetail.jsp in query mode..");

	//String function_id			= "";
	String facilityId			= "";
	String client_ip_address	= "";
	String locale				= "";
	String table_name			= "";
	/* CheckStyle Violation Commented by Munisekhar */
       // String attached_to_inpatient_yn = "N" ;
	String period_from_date_time	= "";
	String period_to_date_time	= "";
	/* CheckStyle Violation Commented by Munisekhar */
	//String authorised_by		= "";
	//String Authorised_lookup	= "";
	//String Authorised_text		= "";
	//String lodger_patient_id	= "";

	//String citizen				= "";
	//String legal				= "";
	//String alt_id1_exp_date		= "";
	//String alt_id2_exp_date		= "";
	//String alt_id3_exp_date		= "";
	//String alt_id4_exp_date		= "";
	//String dateofbirth			= "";
	//String encounter_id			= "";
	//Statement UpdateStmt		= null;
	Statement stmt				= null;
	/* CheckStyle Violation Commented by Munisekhar */
	//ResultSet PatIDRs			= null;
	//Statement PatIDStmt			= null ;
	//Statement SrlStmt			= null;
	Connection con				= null;
	/* CheckStyle Violation Commented by Munisekhar */
	//String name_prefix           = "";
	//String first_name            = "";
	//String second_name           = "";
	//String third_name            = "";
	//String family_name           = "";
	//String name_suffix			 = "";
	//String name_prefix_loc_lang  = "";
	//String first_name_loc_lang	 = "";
	//String second_name_loc_lang  = "";
	//String third_name_loc_lang	 = "";
	//String family_name_loc_lang  = "";
	//String name_suffix_loc_lang	 = "";
	//String patient_name_loc_lang = "";
	String nursing_unit			 = "";
	session						= req.getSession(false);
    this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
	facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	locale						= p.getProperty("LOCALE");
	ResultSet SRLrs = null;
	Statement SRLstmt = null;
	try
	{
		con = ConnectionManager.getConnection(req);

		String Revised_yn = "N";
		String lodger_ref_no = checkForNull(req.getParameter("lodger_ref_no"));

		String enc_id = checkForNull(req.getParameter("encounter_id"));

		period_from_date_time =  checkForNull(req.getParameter("revise_period_from"));


		period_from_date_time = DateUtils.convertDate(period_from_date_time,"DMYHM",locale,"en");


		period_to_date_time =  checkForNull(req.getParameter("revise_period_to"));

		period_to_date_time = DateUtils.convertDate(period_to_date_time,"DMYHM",locale,"en");


		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String error ="";

		Timestamp added_date = new Timestamp(System.currentTimeMillis() );
		Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

		ResultSet rs = null;
		int SRL_NO = 0;

		StringBuffer Sql = new StringBuffer();
		if(Sql.length() > 0) Sql.delete(0,Sql.length());

		Sql.append("SELECT (max(SRL_NO)+1)SRL_NO FROM IP_LODGER_GATE_PASS WHERE facility_id='"+facilityId+"' and lodger_ref_no='"+lodger_ref_no+"' ");
		stmt = con.createStatement();
		rs = stmt.executeQuery(Sql.toString()) ;
		if( rs !=null )
		{
			while(rs.next())
			{
				SRL_NO=rs.getInt(1);
			}
		}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

	HashMap gatetabdata=new HashMap();

	if(period_from_date_time != null && !period_from_date_time.equals(""))
	{
		StringTokenizer tokenfrom1 = new StringTokenizer(period_from_date_time," ") ;

		if(tokenfrom1.hasMoreTokens())
		{
			StringTokenizer tokenfrom2 = new StringTokenizer(tokenfrom1.nextToken(),"/");
			String fromarr[] =new String[3] ;
			for( int a=0;a<3;a++ )
			{
				if(tokenfrom2.hasMoreTokens())
					fromarr[a] = tokenfrom2.nextToken() ;
			}
			while (tokenfrom1.hasMoreTokens())
			period_from_date_time = fromarr[2] + "-" + fromarr[1] + "-" + fromarr[0] + " " + tokenfrom1.nextToken() + ":00";
		}
		Timestamp PeriodFromStamp = Timestamp.valueOf(period_from_date_time);
		gatetabdata.put("PERIOD_FROM_DATE",PeriodFromStamp);
}

	if(period_to_date_time != null && !period_to_date_time.equals(""))
	{
		StringTokenizer tokento1 = new StringTokenizer(period_to_date_time," ") ;
		if(tokento1.hasMoreTokens())
		{
			StringTokenizer tokento2 = new StringTokenizer(tokento1.nextToken(),"/");
			String toarr[] =new String[3] ;
			for( int m=0;m<3;m++ )
			{
				if(tokento2.hasMoreTokens())
					toarr[m] = tokento2.nextToken() ;

			}
		while (tokento1.hasMoreTokens())
		period_to_date_time = toarr[2] + "-" + toarr[1] + "-" + toarr[0] + " " + tokento1.nextToken() + ":00";
		}
		Timestamp PeriodToStamp = Timestamp.valueOf(period_to_date_time);
		gatetabdata.put("PERIOD_TO_DATE",PeriodToStamp);
	}

		gatetabdata.put("Remarks",checkForNull(req.getParameter("ReviseRemarks")));
		gatetabdata.put("facility_id",facilityId);
		gatetabdata.put("lodger_ref_no",lodger_ref_no);
		gatetabdata.put("added_by_id",addedById);
		gatetabdata.put("added_date",added_date);
		gatetabdata.put("added_at_facility_id", facilityId);
		gatetabdata.put("added_at_ws_no",addedAtWorkstation);
		gatetabdata.put("modified_by_id",modifiedById);
		gatetabdata.put("modified_date",modified_date);
		gatetabdata.put("modified_at_facility_id",facilityId);
		gatetabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		gatetabdata.put("REVISED_YN",Revised_yn);

		Integer I_SRL_NO =new Integer(SRL_NO);
		String Str_Srl_No =I_SRL_NO.toString();
		gatetabdata.put("SRL_NO",Str_Srl_No);


		String dupflds[]={"facility_id","lodger_ref_no","SRL_NO"};

		table_name			= "ip_lodger_gate_pass";
		boolean local_ejbs	= false;


		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = gatetabdata;
		argArray[2] = dupflds;
		argArray[3] = table_name;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = gatetabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;

		if ( inserted )
		{
			StringBuffer SRSql = new StringBuffer();
			SRSql.append("select (max(srl_no)-1)Srl_No from ip_lodger_gate_pass where facility_id='"+facilityId+"' and lodger_ref_no='"+lodger_ref_no+"' ");
			int New_Srl_no=0;
			SRLstmt = con.createStatement() ;
			SRLrs = SRLstmt.executeQuery(SRSql.toString());

			if(SRLrs != null)
			{
				if(SRLrs.next())
				{
					New_Srl_no=SRLrs.getInt("Srl_No");
				}
			}

			if(SRLrs!=null) SRLrs.close();
			if(SRLstmt!=null) SRLstmt.close();
			StringBuffer sql = new StringBuffer();
			//Added Audit column
			sql.append(" update ip_lodger_gate_pass set REVISED_YN='Y', MODIFIED_BY_ID= '"+modifiedById+"', MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO ='"+addedAtWorkstation+"' , MODIFIED_AT_FACILITY_ID ='"+facilityId+"' where facility_id='"+facilityId+"' and srl_no='"+New_Srl_no+"' and lodger_ref_no='"+lodger_ref_no+"' " );
			stmt = con.createStatement();

			int res11 = stmt.executeUpdate(sql.toString());
			if ( res11 != 0 )
			{
				con.commit();
                java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
                error = (String) message.get("message") ;
				message.clear();
            }
            else
			{
                 con.rollback();
				 error = (String) results.get("error") ;
                 error = "Errors Encountered while Updating..";
			}
		if(error.lastIndexOf("<br>")>=0)
		error= error.substring(0,error.indexOf("<br>")) ;
		out.println("<script>alert(\""+error+"\");</script>") ;

		//// REPORT FOR GATE PASS

		doOnlineReports( enc_id,nursing_unit,locale );

		}// E.O if(inserted)

		gatetabdata.clear();
		results.clear();

	}catch ( Exception e )
	{
		e.printStackTrace();
	}

	finally
	{
		try
		{
			if(SRLstmt != null) SRLstmt.close();
			if(stmt != null) stmt.close();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		if(con != null)	ConnectionManager.returnConnection(con,req);
	}
}

private void doOnlineReports(String encounter_id,String nursingunitcode,String locale) throws ServletException, IOException, SQLException
{
	StringBuffer sqlString = new StringBuffer();
	try
	{
		String locn_type = "N";
		sqlString.append("SELECT b.report_id, b.report_desc, 1 no_of_copies, b.module_id FROM SM_REPORT_LANG_VW  b  WHERE  b.language_id='"+locale+"' and   b.module_id = 'IP' AND b.report_id = 'IPBGTPAS'");
		String reportParamNames = "p_encounter_id";
		String reportParamValues = ""+encounter_id+"";
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		htmlFor.append("</head><body class	='message'> <script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		htmlFor.append("<script language	= 'JavaScript'>" );
		htmlFor.append("  var dialogHeight	= '450px';");
		htmlFor.append(" var dialogWidth	= '750px';");
		htmlFor.append("var dialogTop		= '58';");
		htmlFor.append("  var arguments		=	'';");
		htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString.toString())+"&EncounterId="+encounter_id+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&dest_locn_type="+locn_type+"&dest_locn_code="+nursingunitcode+"';");
		htmlFor.append(" var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
		htmlFor.append("  retVal = showModalDialog(getUrl,arguments,features); parent.document.getElementById('dialog_tag').close();");
		htmlFor.append(" </script>" );
		out.println(htmlFor.toString());
		out.println("</body></html>");
	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}// E.O class BookLodgerServlet method
