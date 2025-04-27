package eMR.smrp;
 
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class GeneratePSPRO extends HttpServlet 
{ 

	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobSchedulePSPRO js =new JobSchedulePSPRO();
		// to call a sub routine which will call the main mathod based on preset intervals.
		js.main();

	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{ 
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			doPost(req,res);
			
		}
		catch(Exception e)	{
			System.err.println("Exception in doGet function:"+e.toString());
			  e.printStackTrace();

			}
	}
				

	/* called when the report is generatede form application*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{
			

			String from_date 	  = req.getParameter("rep_date");
			String to_date   	  = req.getParameter("rep_date");
			String facility_id    = req.getParameter("hmis_hospital");
			String locale    = req.getParameter("locale");
			
			
			String dir  		  = System.getProperty("user.dir");	

			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			
		/*This will make call to createPSPRO function which will create the JSON file*/
			GeneratePSPRO Gjson= new GeneratePSPRO();

			String PSPRO_fileCreated_flag =Gjson.createPSPRO(facility_id,from_date,to_date);

			String error="";
			if(PSPRO_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (PSPRO_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (PSPRO_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + PSPRO_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createPSPRO(String facility_id,String start_date,String end_date)					
	{ 
		
		Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;

		String fileCreated = "0";
		
		int Count  				= 0;
		String filename="";
		LogSMRP smrpLogger=new LogSMRP();
		String Site_id="";
		try {			
		
			Date currentdate = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			int def_duration=0;
			
			//String dir="\\\\cscappche608\\eHIS\\WCHSMRP"; //This has to be read from the db.
			String dir=""; //This has to be read from the db.

			con =   ConnectionManager.getConnection();
			stmt =  con.createStatement();
			//System.out.println("");
			rset =  stmt.executeQuery("select VALUE_1 file_path, nvl(VALUE_2,0) def_duration ,SITE_ID from SM_FUNCTION_CONTROL where module_id='MR' and functionality_id='SMRP' and SITE_ID=(select customer_id from sm_site_param)");
			if(rset!= null && rset.next()){
				dir=rset.getString("file_path");
				def_duration=rset.getInt("def_duration");
				Site_id=rset.getString("SITE_ID");
			}

			rset.close();
			stmt.close();

			if(dir.equals("") && def_duration==0) {
				fileCreated="2";
   			    System.out.println(" No dir path --> "+dir +"or no def_duration "+def_duration+" -->"+filename);
			}else{
			
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - 1);
				currentdate=cal.getTime();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - def_duration);
				Date pastdate = cal.getTime();


				/*when Date is not passed from Front end, it will consider Current Date and Current Date - 7*/
				String from_date 	  = start_date.equals("") ? ft.format(pastdate):start_date; 
				//String to_date   	   = end_date.equals("") ? ft.format(currentdate):end_date;
				String to_date   	   = end_date.equals("") ? ft.format(pastdate):end_date;

				start_date=from_date;
				end_date=to_date;

				
				/*The View which is created for this PSPROJson purpose*/

				String mapped_fac_id=facility_id;

				stmt =  con.createStatement();
				rset =  stmt.executeQuery("SELECT ext_pk_id  FROM xh_oth_appl_data_skey WHERE table_id = 'SM_FACILITY_PARAM' AND pk_value ='"+facility_id+"' AND application_id = 'SMRP'");
				
				if(rset!=null && rset.next()){
					mapped_fac_id=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				filename       = mapped_fac_id+"_"+from_date.replaceAll("/","")+"_"+to_date.replaceAll("/",""); 
				String refServiceTypeCode="01";
					
				
				/*This query will return the service code for which JSON file need to be generated*/
				
				stmt =  con.createStatement();
				rset =  stmt.executeQuery("select EXT_PK_ID from  XH_OTH_APPL_DATA_SKEY WHERE table_id='AM_PATIENT_CLASS' and APPLICATION_ID='SMRP' and PK_VALUE='IP'");
				
				

			
				if(rset!=null && rset.next()){
					refServiceTypeCode=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				

				String sqlQuery		  = "SELECT * FROM MR_PDRH301_VW  WHERE trunc(DISCHARGE_DATE_TIME) BETWEEN TO_DATE ('"+start_date+"','dd/mm/yyyy') AND TO_DATE ('"+end_date+"', 'dd/mm/yyyy') + 0.99999 and patient_class='IP' and FACILITY_CODE='"+facility_id+"' ORDER BY VISIT_ADM_DATE_TIME";

				stmt =  con.createStatement();
				
				System.out.println("sqlQuery-->"+sqlQuery);
				rset =  stmt.executeQuery(sqlQuery);


				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				String fl_name=filename+"_PSPRO";
				
				System.out.println("filename-->"+filename);

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				
				StringBuffer str_head=new StringBuffer("");
				str_head.append("{\"filename\": \""+fl_name+"\",\"refServiceTypeCode\": \""+refServiceTypeCode+"\",\"formType\": \"301\",\"facilityCode\": \""+mapped_fac_id+"\",");
				str_head.append("\"dischargeFrom\": \""+from_date+"\",\"dischargeTo\": \""+to_date+"\",\"forms\": [");
			

				StringBuffer str_foot=new StringBuffer("");
				
				int i=0;

				 while(rset!=null && rset.next()) 	{  	 // looping each ip encounter

					StringBuffer visit= new StringBuffer("");
					System.out.println("inisde encounter  loop i value-->"+i);
					if( i>0){						
						System.out.println("i value -->"+ i);
						visit.append(",");					
					}

					visit.append("{ \"visit\": { \"rn\": \""+checkForNull(rset.getString("REG_NBR"))+"\",");
					visit.append("\"clusterFacilityRn\": \""+checkForNull(rset.getString("clstr_fac_rn"))+"\",");
					// cluster facilty pass empty
					visit.append("\"mrn\": \""+checkForNull(rset.getString("PATIENT_MRN"))+"\",");
					visit.append("\"eventDate\": \""+checkForNull(rset.getString("EVENT_DATE"))+"\",");  // after mrn
					visit.append("\"isPoliceCase\": \""+checkForNull(rset.getString("POLICE_CASE"))+"\","); 
					visit.append("\"letterOfGuarantee\": \""+checkForNull(rset.getString("GUARANTEE_LETTER"))+"\",");
					
					StringTokenizer stk_ref=new StringTokenizer(checkForNull(rset.getString("REFERAL_DTLS")),"~" );  // today

					
					String v_internalReferral="";
					String v_refReferralSourceCode="";
					String v_externalFacilityCode="";
					String v_externalReferralDate="";

					while(stk_ref.hasMoreTokens()){
						v_internalReferral=stk_ref.nextToken();
						v_refReferralSourceCode=stk_ref.nextToken();
						v_externalFacilityCode=stk_ref.nextToken();						
						v_externalReferralDate=stk_ref.nextToken();

						if(v_externalFacilityCode.equals(" ")){
							v_externalFacilityCode="";
						}
						if(v_externalReferralDate.equals(" ")){
							v_externalReferralDate="";
						}
					}

					visit.append("\"internalReferral\": \""+v_internalReferral+"\",");
					visit.append("\"refReferralSourceCode\": \""+v_refReferralSourceCode+"\" ,");
					visit.append("\"externalFacilityCode\": \""+v_externalFacilityCode+"\" ,");
					visit.append("\"externalReferralDate\": \""+v_externalReferralDate+"\" ,");   // today end
					visit.append("\"otherExternalReferral\": \""+checkForNull(rset.getString("OTHEREXTERNALREFERRAL"))+"\" },");


					StringBuffer person= new StringBuffer(" \"person\": { \"unknownPersonFlag\": "+checkForNull(rset.getString("UNKNOWN_PRSN"))+",\"refPersonTitleCode\": \""+checkForNull(rset.getString("TITLE_CODE_MAP"))+"\",");
					person.append("\"fullName\": \""+checkForNull(rset.getString("PATIENT_NAME"))+"\",");
					person.append("\"otherName\": \""+checkForNull(rset.getString("OTH_NAME"))+"\",");
					person.append("\"refGenderCode\": \""+checkForNull(rset.getString("GENDER_TO_MAP"))+"\",");
					person.append("\"dob\": \""+checkForNull(rset.getString("DOB"))+"\",");
					person.append("\"refMaritalStatusCode\": \""+checkForNull(rset.getString("MARITALSTATUSCODE_MAP"))+"\",");
					person.append("\"refReligionCode\": \""+checkForNull(rset.getString("RELIGIONCODE_MAP"))+"\" ,");
					person.append("\"refCitizenshipCode\": \""+checkForNull(rset.getString("CITIZEN_YN_MAP"))+"\" ,");
					person.append("\"refEthnicCode\": \""+checkForNull(rset.getString("ETHNIC_GRP_CODE_MAP"))+"\" ,");
					//person.append("\"refEducationLevelCode\": \""+checkForNull(rset.getString("ETHNIC_GRP_CODE_MAP"))+"\" ,"); // today down 3
					//person.append("\"refMonthlyHouseholdIncomeCode\": \""+checkForNull(rset.getString("ETHNIC_GRP_CODE_MAP"))+"\" ,");
					//person.append("\"refOccupationSectorCode\": \""+checkForNull(rset.getString("ETHNIC_GRP_CODE_MAP"))+"\" ,"); //today
					//person.append("\"occupationDesignation\": \"" "\" ,");
					person.append("\"height\": \""+checkForNull(rset.getString("pat_height"))+"\" ,");
					person.append("\"weight\": \""+checkForNull(rset.getString("pat_weight"))+"\" ,");
					person.append("\"refForeignerOriginCountryCode\": \""+checkForNull(rset.getString("FRG_ORG_CNTRY_CD"))+"\" ,");
					person.append("\"refForeignerResidenceCountryCode\": \""+checkForNull(rset.getString("FRG_RES_CNTRY_CD"))+"\" ,");
					//person.append("\"foreignerResidenceCity\": \"" "\" ,");
					person.append("\"refPersonCategoryCode\": \"" +checkForNull(rset.getString("pat_cat_code"))+"\" ,"); // mapped in view

					//person.append("\"refMilitaryTypeRankCode\": \"" "\" ,");


					StringTokenizer temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IDENTITY_DTLS")),"~" );
					/*identifications -Start*/
					StringBuffer identifications= new StringBuffer(" \"identifications\": [");
					//System.out.println("temp.length  272-->:"+temp_tkn.countTokens());
					String v_id_code="00";  // handle logic for passport and stuff.
					String v_id_no="0";
					while (temp_tkn.hasMoreTokens()){
						v_id_code=temp_tkn.nextToken();
						v_id_no=temp_tkn.nextToken();
						//identificationsobj.put("passportExpiredDate","");	
						//identificationsobj.put("refRelationshipCode","");	
						//identificationsobj.put("otherRelationship","");
					}
					identifications.append("{\"refIdentificationTypeCode\": \""+v_id_code+"\" ,");// to build logic for pp dat eand other relation code
					identifications.append("\"identificationNo\": \""+v_id_no+"\" ,");
					//identifications.append("\"passportExpiredDate\":  \"\",");
					identifications.append("\"refRelationshipCode\":  \"\"}");
					
					
					identifications.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("ADDRESS_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer pat_addr= new StringBuffer(" \"addresses\": [");
					String code1="";
					String code2="";
					String code3="";
					String code4="";
					String code5="";
					String code6="";
					String code7="";
					String code8="";
					String code9="000";
					while (temp_tkn.hasMoreTokens()){
						code1=temp_tkn.nextToken();
						code2=temp_tkn.nextToken();
						code3=temp_tkn.nextToken();
						code4=temp_tkn.nextToken();
						code5=temp_tkn.nextToken();
						code6=temp_tkn.nextToken();
						code7=temp_tkn.nextToken();
						code8=temp_tkn.nextToken();
						code9=temp_tkn.nextToken();
					}

					pat_addr.append("{\"refAddressTypeCode\": \""+code1+"\" ,");
					pat_addr.append("\"street1\": \""+code2+"\" ,");
					pat_addr.append("\"street2\": \""+code3+code4+"\" ,");
					pat_addr.append("\"refStateCode\": \""+code5+"\" ,");
					if(Site_id.equals("SLY")){
						pat_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						pat_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					pat_addr.append("\"refPostCode\": \""+code8+"\" ,");
					pat_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext mapping is available
					pat_addr.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("PAT_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer pat_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//pat_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//pat_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					pat_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					pat_cont.append("\"contactInfo\": \""+code2+"\" }");

					pat_cont.append("]},");


					StringBuffer pat_next_kin= new StringBuffer(" \"nextOfKins\": { ");
					 pat_next_kin.append("\"refPersonTitleCode\": \""+checkForNull(rset.getString("pat_nxt_kn_title"))+"\" ,");
					 pat_next_kin.append("\"fullName\": \""+checkForNull(rset.getString("PAT_NXT_KN_NAME"))+"\" ,");
					 //next_kin.append("\"otherName\": \""+ +"\" ,");
					 pat_next_kin.append("\"refRelationshipCode\": \""+checkForNull(rset.getString("PAT_NXT_KN_RLN"))+"\" ,");

					
					/*identifications -Start*/
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("P_NXT_KN_IDENTITY_DTLS")),"~" );
					/*identifications -Start*/
					StringBuffer pat_nk_identifications= new StringBuffer(" \"identifications\": [");
					code1="00";
					code2="0";
					while (temp_tkn.hasMoreTokens()){
						//pat_nk_identifications.append("{\"refIdentificationTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						//pat_nk_identifications.append("\"identificationNo\": \""+temp_tkn.nextToken()+"\" }");
						code1=temp_tkn.nextToken();
						code2=temp_tkn.nextToken();
					}
					pat_nk_identifications.append("{\"refIdentificationTypeCode\": \""+code1+"\" ,");
					pat_nk_identifications.append("\"identificationNo\": \""+code2+"\" }");
					pat_nk_identifications.append("],");


					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("P_NXT_KN_ADDRESS_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer pat_nk_addr= new StringBuffer(" \"addresses\": [");
					code1="";
					code2="";
					code3="";
					code4="";
					code5="";
					code6="";
					code7="";
					code8="";
					code9="000";
					while (temp_tkn.hasMoreTokens()){
						/*pat_nk_addr.append("{\"refAddressTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						pat_nk_addr.append("\"street1\": \""+temp_tkn.nextToken()+"\" ,");
						pat_nk_addr.append("\"street2\": \""+temp_tkn.nextToken()+"\" ,");
						String code3=temp_tkn.nextToken();
						pat_nk_addr.append("\"refStateCode\": \""+temp_tkn.nextToken()+"\" ,");
						String code5=temp_tkn.nextToken();
						pat_nk_addr.append("\"refCityCode\": \""+temp_tkn.nextToken()+"\" ,");
						pat_nk_addr.append("\"refPostCode\": \""+temp_tkn.nextToken()+"\" ,");
						pat_nk_addr.append("\"refCountryCode\": \""+temp_tkn.nextToken()+"\" }"); //to open when ext country mapping is available
						//pat_nk_addr.append("\"refCountryCode\": \"--\" }");
						*/
						code1=temp_tkn.nextToken();
						code2=temp_tkn.nextToken();
						code3=temp_tkn.nextToken();
						code4=temp_tkn.nextToken();
						code5=temp_tkn.nextToken();
						code6=temp_tkn.nextToken();
						code7=temp_tkn.nextToken();
						code8=temp_tkn.nextToken();
						code9=temp_tkn.nextToken();
					}

					pat_nk_addr.append("{\"refAddressTypeCode\": \""+code1+"\" ,");
					pat_nk_addr.append("\"street1\": \""+code2+"\" ,");
					pat_nk_addr.append("\"street2\": \""+code3+code4+"\" ,");
					pat_nk_addr.append("\"refStateCode\": \""+code5+"\" ,");
					
					if(Site_id.equals("SLY")){
						pat_nk_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						pat_nk_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					pat_nk_addr.append("\"refPostCode\": \""+code8+"\" ,");
					pat_nk_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext country mapping is available

					pat_nk_addr.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("P_NXT_KN_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer pat_nk_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//pat_nk_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//pat_nk_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					pat_nk_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					pat_nk_cont.append("\"contactInfo\": \""+code2+"\" }");
					pat_nk_cont.append("]},");
					
					StringBuffer pat_emergency= new StringBuffer(" \"emergencyContacts\": [ {");
					pat_emergency.append("\"refPersonTitleCode\": \""+checkForNull(rset.getString("p_emer_cnt_title"))+"\" ,");
					pat_emergency.append("\"fullName\": \""+checkForNull(rset.getString("P_EMER_CNT_NAME"))+"\" ,");
					//emergency.append("\"otherName\": \"" "\" ,");
					pat_emergency.append("\"refRelationshipCode\": \""+checkForNull(rset.getString("P_EMER_CNT_RLN"))+"\" ,");
					//emergency.append("\"otherRelationship\": \"" "\" ,");
					
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("P_EMER_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer pat_emer_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//pat_emer_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//pat_emer_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					pat_emer_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					pat_emer_cont.append("\"contactInfo\": \""+code2+"\" }");
					pat_emer_cont.append("]}],");

					StringBuffer admission= new StringBuffer(" \"admission\": {	");
					admission.append("\"totalDurationDay\": \""+checkForNull(rset.getString("TOTAL_DAY_DURATION"))+"\" ,");

					admission.append(" \"inpatient\": [");
					temp_tkn=null;

					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_AT_DETAILS")),"@" );
					//System.out.println("ADT_val-->"+ rset.getString("IP_ADT_DETAILS"));
					while (temp_tkn.hasMoreTokens()){
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
				
							while (temp_tkn_inner.hasMoreTokens()){
								admission.append("{\"refWardTransitionTypeCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								admission.append("\"wardDateTime\": \""+temp_tkn_inner.nextToken()+"\" ,");
								admission.append("\"wardCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								String service_code=temp_tkn_inner.nextToken();
								String room_no=temp_tkn_inner.nextToken();
								String bed_no=temp_tkn_inner.nextToken();
								String bed_class=temp_tkn_inner.nextToken();
								String bed_type=temp_tkn_inner.nextToken();
								String pract_id=temp_tkn_inner.nextToken();
								String spc_code=temp_tkn_inner.nextToken();

								admission.append("\"refDisciplineCode\": \""+service_code+"\" ,");
								admission.append("\"refSpecialityCode\": \""+spc_code+"\" ,");
								admission.append("\"refSubSpecialityCode\": \""+spc_code+"\" ,");
								admission.append("\"refWardClassCode\": \""+bed_class+"\" ,");
								admission.append("\"refWardCategoryCode\": \""+bed_type+"\" },");
							}
					}
					
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_DISC_DETAILS")),"~" );
				
					while (temp_tkn.hasMoreTokens()){
						admission.append("{\"refWardTransitionTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						admission.append("\"wardDateTime\": \""+temp_tkn.nextToken()+"\" ,");
						admission.append("\"wardCode\": \""+temp_tkn.nextToken()+"\" ,");
						String service_code=temp_tkn.nextToken();
						String room_no=temp_tkn.nextToken();
						String bed_no=temp_tkn.nextToken();
						String bed_class=temp_tkn.nextToken();
						String bed_type=temp_tkn.nextToken();
						String pract_id=temp_tkn.nextToken();
						String spc_code=temp_tkn.nextToken();

						admission.append("\"refDisciplineCode\": \""+service_code+"\" ,");
						admission.append("\"refSpecialityCode\": \""+spc_code+"\" ,");
						admission.append("\"refSubSpecialityCode\": \""+spc_code+"\" ,");
						admission.append("\"refWardClassCode\": \""+bed_class+"\" ,");
						admission.append("\"refWardCategoryCode\": \""+bed_type+"\" }");
					}

					admission.append("],");

					admission.append("\"discharge\": { ");
					admission.append("\"refDischargeTypeCode\": \""+checkForNull(rset.getString("DISPOSITION_TYPE"))+"\" ,");

					String dec_date_time="";
					String dis_stp_cd="";

					dec_date_time=checkForNull(rset.getString("DECEASED_DATE_TIME"));

					if(dec_date_time.equals("")){
						dis_stp_cd=checkForNull(rset.getString("Discharge_Step_Code"));
					}
					admission.append("\"refDischargeStepCode\": \""+dis_stp_cd+"\" ,");

					
					admission.append("\"dischargeDateTime\": \""+checkForNull(rset.getString("DISC_DATE_TIME"))+"\" ,");
					admission.append("\"refBillingCategoryCode\": \""+checkForNull(rset.getString("Billing_Category_Code"))+"\" ,");
					admission.append("\"remark\": \""+checkForNull(rset.getString("discharge_Remark"))+"\" ,");
					admission.append("\"deathDateTime\": \""+dec_date_time+"\" ,");
					admission.append("\"refHealthFundingTypeCode\": \""+checkForNull(rset.getString("Health_Funding_Type_Code"))+"\" ,");
					admission.append("\"healthFundingNumber\": \""+checkForNull(rset.getString("health_Funding_Number"))+"\" ,");

					admission.append("\"dischargeOfficers\":	[	{	");
					admission.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("position_type"))+"\" ,");
					admission.append("\"fullName\": \""+checkForNull(rset.getString("practitioner_name"))+"\" ,");
					admission.append("\"mmc\": \""+checkForNull(rset.getString("employee_id"))+"\" }	]	}	}	,");

					StringBuffer diagnosis= new StringBuffer(" \"diagnosis\": [	");
				temp_tkn=null;
				temp_tkn		= new StringTokenizer(checkForNull(rset.getString("DIAG_DETAILS")),"$" );
				int out_token=temp_tkn.countTokens();
				int j=0;
				while (temp_tkn.hasMoreTokens()){
						diagnosis.append("{");
						StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
						j	++;
						while (temp_tkn_inner.hasMoreTokens()){
							
							diagnosis.append("\"refDiagnosisItemTypeCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
							String term_code=temp_tkn_inner.nextToken();
							String term_code_details=temp_tkn_inner.nextToken();
							StringTokenizer temp_support		= new StringTokenizer(term_code_details,"#" );
							int sup_token=temp_support.countTokens();

							int k=0;
							String term_code_desc=temp_support.nextToken();
							String support_dtls="";
							if(sup_token>1){
								support_dtls=temp_support.nextToken();
							}
							diagnosis.append("\"description\": \""+term_code_desc+"\" ,");
							diagnosis.append("\"diagnosisIcd10Codes\": [	{");
							diagnosis.append("\"refIcd10Main\": \""+term_code+"\" ");

							StringTokenizer temp_support_tkn		= new StringTokenizer(support_dtls,"^" );
							while (temp_support_tkn.hasMoreTokens()){
								
								String sup_code=temp_support_tkn.nextToken();
								String sup_type= temp_support_tkn.nextToken();
								if(k==0){
									diagnosis.append("},");
								}
								diagnosis.append("{");
								k++;
								if(sup_type.equals("A")){
									diagnosis.append("\"refIcd10Asterisk\": \""+sup_code+"\" ");
								}else if (sup_type.equals("E")){
									diagnosis.append("\"refIcd10Supplementary\": \""+sup_code+"\" ");
								}else{
									diagnosis.append("\"refIcd10Zcode\": \""+sup_code+"\" ");
								}
								diagnosis.append("}");
								if(k  >2){
									diagnosis.append(",");
								}

							}
							if(sup_token<2){
								diagnosis.append(" }");
							}
							diagnosis.append("]");
							
						}
						diagnosis.append(" }");
						if(j  <out_token){
								diagnosis.append(",");
						}
						
				}

				diagnosis.append(" ]	,	");

					StringBuffer ot_procedures= new StringBuffer(" \"procedures\": [	");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("OT_PROC_DTLS")),"@" );
					System.out.println("val-->"+ rset.getString("OT_PROC_DTLS"));
					out_token=temp_tkn.countTokens();
					j=0;
					while (temp_tkn.hasMoreTokens()){
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
							j	++;
							while (temp_tkn_inner.hasMoreTokens()){
								String enc_id=temp_tkn_inner.nextToken();
								ot_procedures.append("{\"oper_num\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"oper_code\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"oper_line_num\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"oper_added_in_surgeon_notes_yn\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"oper_desc\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"diag_code_scheme\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"class_code\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_procedures.append("\"surgery_type\": \""+temp_tkn_inner.nextToken()+"\" }	");

								if(j  <out_token){
									ot_procedures.append(",");
								}
								
							}
					}

					ot_procedures.append(" ]	}	");

					/*StringBuffer ot_cancel_procedures= new StringBuffer(" \"procedureCancelled\": [	");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("OT_CNCL_PROC_DTLS")),"@" );
					System.out.println("val-->"+ rset.getString("OT_CNCL_PROC_DTLS"));
					out_token=temp_tkn.countTokens();
					j=0;
					while (temp_tkn.hasMoreTokens()){
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
							j	++;
							while (temp_tkn_inner.hasMoreTokens()){
								String enc_id=temp_tkn_inner.nextToken();
								ot_cancel_procedures.append("{\"oper_num\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"oper_line_num\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"oper_added_in_surgeon_notes_yn\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"oper_desc\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"diag_code_scheme\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"class_code\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"surgery_type\": \""+temp_tkn_inner.nextToken()+"\" ,");
								ot_cancel_procedures.append("\"cancel_reason\": \""+temp_tkn_inner.nextToken()+"\" }	");

								if(j  <out_token){
									ot_cancel_procedures.append(",");
								}
								
							}
					}

					ot_cancel_procedures.append(" ]		}");*/


					
					str_head.append(visit.toString());
					str_head.append(person.toString());
					str_head.append(identifications.toString());
					str_head.append(pat_addr.toString());
					str_head.append(pat_cont.toString());
					str_head.append(pat_next_kin.toString());
					str_head.append(pat_nk_identifications.toString());
					str_head.append(pat_nk_addr.toString());
					str_head.append(pat_nk_cont.toString());
					str_head.append(pat_emergency.toString());
					str_head.append(pat_emer_cont.toString());
					str_head.append(admission.toString());
					str_head.append(diagnosis.toString());
					str_head.append(ot_procedures.toString());
					//str_head.append(ot_cancel_procedures.toString());
						
					

					i++;
				 }// while loop for encounter 
				 str_foot.append(" ]	}");

				str_head.append(str_foot.toString());
				filename=filename+"_PSPRO.json";

				if(i>0){
				
					try{
						
						System.out.println("dir-->"+dir);
						//FileWriter file = new FileWriter(dir+"\\"+filename+"_PSPRO.json");/*File is Created with Json object as data in specific folder*/
						
						System.out.println("filename-->"+filename);
						dir=dir+filename;
						System.out.println("dir-->"+dir);
						File PSPROjson = new File (dir);
						FileWriter file = new FileWriter(PSPROjson);/*File is Created with Json object as data in specific folder*/
						System.out.println("PSPROjson.getPath()-->"+PSPROjson.getPath());
						System.out.println("PSPROjson.getAbsolutePath()-->"+PSPROjson.getAbsolutePath());
						System.out.println("PSPROjson.getName()-->"+PSPROjson.getName());

						
						//str_head.append(str_foot.toString());
						file.write(str_head.toString());
						fileCreated="1";
						System.out.println("fileCreated@746-->"+fileCreated);
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PSPRO",PSPROjson.getAbsolutePath());
						file.flush();
						file.close();

						if(dir.equals("")){
							fileCreated="2";
							 System.out.println("Error while file obj  PSPRO generation. No dir path-->"+filename);
							 smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PSPRO","File creation path is not defined");
						}

					} catch (IOException e) {
						fileCreated="2";
						System.err.println("Exception in createPSPRO function Inside try:"+e.toString());
						System.out.println("Error while file obj  PSPRO generation-->"+filename+"-->"+e.toString());
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PSPRO","IO Error. Unable to create File for PSPRO generation");
						e.printStackTrace();
					}
				}else{ // no data for file generation
					System.out.println("No data for PSPRO generation-->"+filename);
					fileCreated="0";
					smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PSPRO","No data for PSPRO generation");
				}
				
			}	 //check in function control				
		
		}catch (Exception e) {
			  System.err.println("Exception in createPSPRO function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PSPRO",e.toString());
			  fileCreated="0";
			  e.printStackTrace();
		}finally{
			try{
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			}
		}

		return fileCreated;
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	


public static class JobSchedulePSPRO extends TimerTask {

 /*The main method will be invoked when Server is Started*/
  public  void main (String... arguments ) {
    TimerTask JobSchedulePSPRO = new JobSchedulePSPRO();
   
    Timer timer = new Timer();
    /*After main mehtod is invoked, it will check for the time at which the run method has to be invoked */
		Connection con = null;
	ResultSet rset = null;
	Statement stmt =  null;
	int hr=0;
	int mn=0;
    
    con =   ConnectionManager.getConnection();
		 
		try {
			stmt =  con.createStatement();
		
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select nvl(to_char(LAG_TIME,'HH24'),'00') hr,nvl(to_char(LAG_TIME,'mi'),'00') min from MR_SMRP_CONFIG where SMRP_ID='PSPRO'");
		String hr_lag = "00";
		String min_lag = "00";
		if(rset!=null && rset.next()){
			hr_lag = rset.getString("hr");
			min_lag = rset.getString("min");
			hr=Integer.parseInt(hr_lag);  
			mn=Integer.parseInt(min_lag);
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			try {
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    timer.scheduleAtFixedRate(JobSchedulePSPRO, getTomorrowMorning12am(hr,mn), fONCE_PER_DAY);
  //  timer.scheduleAtFixedRate(JobSchedulePSPRO, getTomorrowMorning12am(), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GeneratePSPRO Gjson= new GeneratePSPRO();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'	");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createPSPRO(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobSchedulePSPRO Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	  private final static long fONCE_PER_DAY = 1000*60*60*24;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 00;
	  private final static int fZERO_MINUTES = 20; 

	/*The function will retutn the time at which the process has to be run*/
	//  private  Date getTomorrowMorning12am(){
	  private  Date getTomorrowMorning12am(int fZEROHOUR,int fZERO_MINUTES){
		Calendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DATE, fONE_DAY);
		Calendar result = new GregorianCalendar(
		  tomorrow.get(Calendar.YEAR),
		  tomorrow.get(Calendar.MONTH),
		  tomorrow.get(Calendar.DATE),
		  fZEROHOUR,
		  fZERO_MINUTES
		);
		return result.getTime();
	  }
}


	
	
	
}