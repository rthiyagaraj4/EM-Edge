
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

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class GenerateCS_FS extends HttpServlet 
{ 

	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobScheduleCS_FS js =new JobScheduleCS_FS();
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
			
		/*This will make call to createCS_FS function which will create the JSON file*/
			GenerateCS_FS Gjson= new GenerateCS_FS();

			String CS_FS_fileCreated_flag =Gjson.createCS_FS(facility_id,from_date,to_date);

			String error="";
			if(CS_FS_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (CS_FS_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (CS_FS_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + CS_FS_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createCS_FS(String facility_id,String start_date,String end_date)					
	{ 
		
		Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
		HashMap<String, String> nur_code_map = new HashMap<String, String>();
		String mp_wrd_cd="";

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
			rset =  stmt.executeQuery("select VALUE_1 file_path, SITE_ID  from SM_FUNCTION_CONTROL where module_id='MR' and functionality_id='SMRP' and SITE_ID=(select customer_id from sm_site_param)");
			if(rset!= null && rset.next()){
				dir=rset.getString("file_path");
				Site_id=rset.getString("SITE_ID");
			}

			rset.close();
			stmt.close();

			if(dir.equals("") && def_duration==0) {
				fileCreated="2";
   			    //System.out.println(" No dir path --> "+dir +"or no def_duration "+def_duration+" -->"+filename);
			}else{
				
				def_duration=1;
				stmt =  con.createStatement();
				rset =  stmt.executeQuery("select DURATION def_duration from MR_SMRP_CONFIG where SMRP_ID='CS_FS'");

				if(rset!= null && rset.next()){
					def_duration=rset.getInt("def_duration");
					
				}

				rset.close();
				stmt.close();
				
				if (Site_id.equals("SGBL")){
					stmt =  con.createStatement();
					rset =  stmt.executeQuery("select KEY_VALUE,KEY_ID from mr_SMRP_OTH_MAP where MAIN_ID='NUR_CODE' and SUB_ID='"+facility_id+"'");

					 while(rset!=null && rset.next()) 	{
						  nur_code_map.put(rset.getString("KEY_VALUE"), rset.getString("KEY_ID"));
						
					}

					rset.close();
					stmt.close();
				}

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

				
				/*The View which is created for this CS_FSJson purpose*/

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

				
 
                String sqlQuery		  = "SELECT * FROM MR_CS_FS_VW  WHERE trunc(DEC_DATE) BETWEEN TO_DATE ('"+start_date+"','dd/mm/yyyy') AND TO_DATE ('"+end_date+"', 'dd/mm/yyyy') + 0.99999  and FACILITY_CODE='"+facility_id+"' ORDER BY VISIT_ADM_DATE_TIME";
				
				//String sqlQuery		  = "SELECT * FROM MR_CS_FS_VW ";//WHERE trunc(DEC_DATE) BETWEEN TO_DATE ('26/01/2022','dd/mm/yyyy') AND TO_DATE ('26/01/2022', 'dd/mm/yyyy') + 0.99999  and FACILITY_CODE='"+facility_id+"' and rownum <2 ORDER BY VISIT_ADM_DATE_TIME";
				
				stmt =  con.createStatement();
				
				System.out.println("sqlQuery-->"+sqlQuery);
				rset =  stmt.executeQuery(sqlQuery);


				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				String fl_name=filename+"_CSFS";
				
				System.out.println("filename-->"+filename);

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				
				StringBuffer str_head=new StringBuffer("");
				str_head.append("{\"filename\": \""+fl_name+"\",\"formType\": \"CS\",\"facilityCode\": \""+mapped_fac_id+"\",");
				str_head.append("\"dischargeFrom\": \""+from_date+"\",\"dischargeTo\": \""+to_date+"\",\"forms\": [");
			

				StringBuffer str_foot=new StringBuffer("");
				
				int i=0;
				
				String disch_pract_id="";
				String attend_pract_id="";
				String enc_id="";
				String filler="";
				String pm_yn="false";
				String postmortem_yn="N";
				String pat_class="";
				 while(rset!=null && rset.next()) 	{  	 // looping each ip encounter

					StringBuffer visit= new StringBuffer("");
					System.out.println("inisde encounter  loop i value-->"+i);
					if( i>0){						
						System.out.println("i value -->"+ i);
						visit.append(",");					
					}
					enc_id=checkForNull(rset.getString("REG_NBR"));
					visit.append("{ \"visit\": { \"rn\": \""+enc_id+"\",");
					pat_class=checkForNull(rset.getString("patient_class"));
					visit.append("\"refServiceTypeCode\": \""+pat_class+"\",");
										
					visit.append("\"clusterFacilityRn\": \""+checkForNull(rset.getString("clstr_fac_rn"))+"\",");
					// cluster facilty pass empty
					visit.append("\"mrn\": \""+checkForNull(rset.getString("PATIENT_MRN"))+"\",");
					visit.append("\"eventDate\": \""+checkForNull(rset.getString("EVENT_DATE"))+"\",");  // after mrn
					visit.append("\"isPoliceCase\": \""+checkForNull(rset.getString("POLICE_CASE"))+"\","); 
					//visit.append("\"isPoliceCase\": "+checkForNull(rset.getString("POLICE_CASE"))+","); 
					visit.append("\"letterOfGuarantee\": \""+checkForNull(rset.getString("GUARANTEE_LETTER"))+"\",");
					
					StringTokenizer stk_ref=new StringTokenizer(checkForNull(rset.getString("REFERAL_DTLS")),"~" );  // today

					System.out.println("174 FS");
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
					System.out.println("280 FS");
					//visit.append("\"internalReferral\": \""+v_internalReferral+"\",");
					visit.append("\"internalReferral\": "+v_internalReferral+",");
					visit.append("\"refReferralSourceCode\": \""+v_refReferralSourceCode+"\" ,");
					visit.append("\"externalFacilityCode\": \""+v_externalFacilityCode+"\" ,");
					visit.append("\"externalReferralDate\": \""+v_externalReferralDate+"\" ,");   // today end
					visit.append("\"otherExternalReferral\": \""+checkForNull(rset.getString("OTHEREXTERNALREFERRAL"))+"\" },");

					System.out.println("202 FS");
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
					String refOccupationSectorCode="99";
					person.append("\"refOccupationSectorCode\": \""+refOccupationSectorCode+"\" ,"); //today
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
					//String v_id_code="00";  changed as per ML-MMOH-SCF-1196.
					String v_id_code="99";  
					String v_id_no="0";
					String v_pp_exp="";
					String v_rel_cd="";
					System.out.println("320 FS");
					while (temp_tkn.hasMoreTokens()){
						v_id_code=temp_tkn.nextToken();
						v_id_no=temp_tkn.nextToken();
						v_pp_exp=temp_tkn.nextToken();
						if(v_pp_exp.equals(" ")){
							v_pp_exp="";
						}
						v_rel_cd=temp_tkn.nextToken();
						if(v_rel_cd.equals(" ")){
							v_rel_cd="";
						}
					
					}
					identifications.append("{\"refIdentificationTypeCode\": \""+v_id_code+"\" ,");// to build logic for pp dat eand other relation code
					identifications.append("\"identificationNo\": \""+v_id_no+"\" ,");
					identifications.append("\"passportExpiredDate\": \""+v_pp_exp+"\" ,");
					identifications.append("\"refRelationshipCode\":  \""+v_rel_cd+"\"}");
					 
					System.out.println("252 FS");
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
					System.out.println("280 FS");
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

					System.out.println("311 FS");
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
					//code1="00"; changed as per ML-MMOH-SCF-1196.
					code1="99";
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

					System.out.println("337 FS");
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
					System.out.println("465 FS");
					if(Site_id.equals("SLY")){
						pat_nk_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						pat_nk_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					pat_nk_addr.append("\"refPostCode\": \""+code8+"\" ,");
					pat_nk_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext country mapping is available

					pat_nk_addr.append("],");
					System.out.println("475 FS");
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
					System.out.println("504 FS");
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
					
					StringTokenizer temp_tkn_inner		= new StringTokenizer(checkForNull(rset.getString("DC_DETAILS")),"~" );
					
					admission.append(" \"daycare\": {");
					System.out.println("520 FS");
					while (temp_tkn_inner.hasMoreTokens()){
						admission.append("\"admissionDate\": \""+temp_tkn_inner.nextToken()+"\" ,");
						admission.append("\"refDisciplineCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
						admission.append("\"refSpecialityCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
						admission.append("\"refSubSpecialityCode\": \""+temp_tkn_inner.nextToken()+"\" ");
					
					}
					System.out.println("530 FS");
					admission.append("},");
					
					admission.append(" \"inpatient\": [");
					temp_tkn=null;

					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_AT_DETAILS")),"@" );
					//System.out.println("ADT_val-->"+ rset.getString("IP_ADT_DETAILS"));
					while (temp_tkn.hasMoreTokens()){
							temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
				
							while (temp_tkn_inner.hasMoreTokens()){
								admission.append("{\"refWardTransitionTypeCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								admission.append("\"wardDateTime\": \""+temp_tkn_inner.nextToken()+"\" ,");
								
								mp_wrd_cd=temp_tkn_inner.nextToken();
								
								if (Site_id.equals("SGBL")){
									mp_wrd_cd=nur_code_map.get(mp_wrd_cd);
								}
								
								admission.append("\"wardCode\": \""+mp_wrd_cd+"\" ,");
								
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
					System.out.println("560 FS");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_DISC_DETAILS")),"~" );
				
					while (temp_tkn.hasMoreTokens()){
						admission.append("{\"refWardTransitionTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						admission.append("\"wardDateTime\": \""+temp_tkn.nextToken()+"\" ,");
						
						mp_wrd_cd=temp_tkn.nextToken();
						
						if (Site_id.equals("SGBL")){
							mp_wrd_cd=nur_code_map.get(mp_wrd_cd);
						}
						
						admission.append("\"wardCode\": \""+mp_wrd_cd+"\" ,");
						
						
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

					System.out.println("598 FS");
					admission.append("\"dischargeDateTime\": \""+checkForNull(rset.getString("DISC_DATE_TIME"))+"\" ,");
					admission.append("\"refBillingCategoryCode\": \""+checkForNull(rset.getString("Billing_Category_Code"))+"\" ,");
					admission.append("\"remark\": \""+checkForNull(rset.getString("discharge_Remark"))+"\" ,");
					admission.append("\"deathDateTime\": \""+dec_date_time+"\" ,");
					admission.append("\"refHealthFundingTypeCode\": \""+checkForNull(rset.getString("Health_Funding_Type_Code"))+"\" ,");
					admission.append("\"healthFundingNumber\": \""+checkForNull(rset.getString("health_Funding_Number"))+"\" ,");

					/*admission.append("\"dischargeOfficers\":	[	{	");
					admission.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("position_type"))+"\" ,");
					admission.append("\"fullName\": \""+checkForNull(rset.getString("practitioner_name"))+"\" ,");
					admission.append("\"mmc\": \""+checkForNull(rset.getString("employee_id"))+"\" }	]	}	}	,");*/
					
					disch_pract_id=checkForNull(rset.getString("DISCH_PRACT_ID"));
					attend_pract_id=checkForNull(rset.getString("ATTEND_PRACT_ID"));
					
					admission.append("\"dischargeOfficers\":	[	{	");
					admission.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("DISCH_PRACT_POS"))+"\" ,");
					admission.append("\"fullName\": \""+checkForNull(rset.getString("DISCH_PRACT_NAME"))+"\" ,");
					admission.append("\"mmc\": \""+checkForNull(rset.getString("DISCH_PRACT_EMP_ID"))+"\" }");
					
					if (! disch_pract_id.equals(attend_pract_id)){
						admission.append(",{");
						admission.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("ATTEND_PRACT_POS"))+"\" ,");
						admission.append("\"fullName\": \""+checkForNull(rset.getString("ATTEND_PRACT_NAME"))+"\" ,");
						admission.append("\"mmc\": \""+checkForNull(rset.getString("ATTEND_PRACT_EMP_ID"))+"\" }");
					
					}
					
					admission.append("]	}	}	,");
					
					System.out.println("629 FS");
					
					StringBuffer OP_discharge= new StringBuffer(" \"admission\": {	");
					OP_discharge.append("\"totalDurationDay\": \""+checkForNull(rset.getString("TOTAL_DAY_DURATION"))+"\" ,");
					
					OP_discharge.append("\"discharge\": { ");
					OP_discharge.append("\"dischargeDateTime\": \""+checkForNull(rset.getString("DISC_DATE_TIME"))+"\" ,");
					OP_discharge.append("\"refDischargeTypeCode\": \""+checkForNull(rset.getString("DISPOSITION_TYPE"))+"\" ,");
			
					OP_discharge.append("\"dischargeToFacility\": \""+checkForNull(rset.getString("Discharge_To_Facility"))+"\" ,");
					
					dec_date_time=checkForNull(rset.getString("DECEASED_DATE_TIME"));
					OP_discharge.append("\"deathDateTime\": \""+dec_date_time+"\" ,");
					OP_discharge.append("\"dischargeOtherFacility\": \""+checkForNull(rset.getString("Discharge_Other_Facility"))+"\" ,");
						
					
					 

					if(dec_date_time.equals("")){
						dis_stp_cd=checkForNull(rset.getString("Discharge_Step_Code"));
					}
					OP_discharge.append("\"refDischargeStepCode\": \""+dis_stp_cd+"\" ,");
					OP_discharge.append("\"refBillingCategoryCode\": \""+checkForNull(rset.getString("Billing_Category_Code"))+"\" ,");
										
					
					
					OP_discharge.append("\"refHealthFundingTypeCode\": \""+checkForNull(rset.getString("Health_Funding_Type_Code"))+"\" ,");
					OP_discharge.append("\"healthFundingNumber\": \""+checkForNull(rset.getString("health_Funding_Number"))+"\" ,");
					OP_discharge.append("\"dischargeRemark\": \""+checkForNull(rset.getString("discharge_Remark"))+"\" ");
					
					/*OP_discharge.append("\"totalCharges\": \""+checkForNull(rset.getString("Total_Charges"))+"\" ,");
					OP_discharge.append("\"refReferralToCode\": \""+checkForNull(rset.getString("ref_Referral_to_code"))+"\" ,");					
					OP_discharge.append("\"refReferralToSubTypeCode\": \""+checkForNull(rset.getString("ref_Referral_to_sub_type_code"))+"\" ,");
					OP_discharge.append("\"wardDateTime\": \""+checkForNull(rset.getString("ward_date_time"))+"\" ,");
					OP_discharge.append("\"refWardDisciplineCode\": \""+checkForNull(rset.getString("ref_ward_discipline_code"))+"\" ");
					*/
					
					//discharge.append("\"dischargeOfficers\":	[	{	");
					//discharge.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("position_type"))+"\" ,");
					//discharge.append("\"fullName\": \""+checkForNull(rset.getString("practitioner_name"))+"\" ,");
					//discharge.append("\"mmc\": \""+checkForNull(rset.getString("employee_id"))+"\" }	]	}	}	,");
					OP_discharge.append("	}	}	,");
					
					StringBuffer outpatient= new StringBuffer(" \"outpatient\": {	");
					//outpatient.append("\"admissionDate\": \""+checkForNull(rset.getString("VISIT_ADM_DATE_TIME"))+"\" ,");
					outpatient.append("\"refServiceSubTypeCode\": \""+checkForNull(rset.getString("refServiceSubTypeCode"))+"\" ,");					
					outpatient.append("\"refVisitTypeCode\": \""+checkForNull(rset.getString("refVisitTypeCode_OP"))+"\" ,");
					outpatient.append("\"refModeOfArrivalCode\": \""+checkForNull(rset.getString("refModeOfArrivalCode"))+"\" ,");
					outpatient.append("\"refVisitActivityCode\": \""+checkForNull(rset.getString("refVisitActivityCode"))+"\" ,");
					outpatient.append("\"otherVisitActivity\": \""+checkForNull(rset.getString("otherVisitActivity"))+"\" ,");
					outpatient.append("\"refVisitActivityInsideFacilityCode\": \""+checkForNull(rset.getString("refVisitAct_In_Fac_cd"))+"\" ,");
					outpatient.append("\"otherVisitActivityInsideFacility\": \""+checkForNull(rset.getString("oth_VisitAct_In_Fac"))+"\" ,");
					outpatient.append("\"refHealthClinicActivityCategoryCode\": \""+checkForNull(rset.getString("ref_Hlth_Cln_Acti_Cat_Cd"))+"\" ,");
					outpatient.append("\"refHealthClinicActivityCategorySubCode\": \""+checkForNull(rset.getString("ref_Hlth_Cln_Acti_Cat_Sub_Cd"))+"\" ,");
					outpatient.append("\"refHealthClinicActivityEmergencySubCode\": \""+checkForNull(rset.getString("ref_Hlth_Cln_Acti_Emr_Sub_Cd"))+"\" ,");
					outpatient.append("\"refHealthClinicActivityEmergencySubTypeCode\": \""+checkForNull(rset.getString("ref_HCA_Emr_Sub_typ_Cd"))+"\" ,");
					outpatient.append("\"refHealthClinicActivityOutMethadoneSubCode\": \""+checkForNull(rset.getString("ref_HCA_Out_Meth_Sub_Cd"))+"\" ,");
					
					//outpatient.append("\"visitingSpecialist\": \""+checkForNull(rset.getString("visitingSpecialist"))+"\" ,");
					outpatient.append("\"visitingSpecialist\": "+checkForNull(rset.getString("visitingSpecialist"))+" ,");
					outpatient.append("\"medicalCheckup\": \""+checkForNull(rset.getString("medicalCheckup"))+"\" ,");
					//outpatient.append("\"medicalCheckup\": "+checkForNull(rset.getString("medicalCheckup"))+" ,");
					//outpatient.append("\"attendance\": \""+checkForNull(rset.getString("attendance"))+"\" ,");
					outpatient.append("\"attendance\": "+checkForNull(rset.getString("attendance"))+" ,");
					//outpatient.append("\"attGivenToPregnantWomen\": \""+checkForNull(rset.getString("attGivenToPregnantWomen"))+"\" ,");
					outpatient.append("\"attGivenToPregnantWomen\": "+checkForNull(rset.getString("attGivenToPregnantWomen"))+" ,");
					outpatient.append("\"refDisciplineCode\": \""+checkForNull(rset.getString("REFDISCIPLINECODE_OP"))+"\" ,");
					outpatient.append("\"refSpecialityCode\": \""+checkForNull(rset.getString("REFSPECIALITYCODE_OP"))+"\" ,");
					outpatient.append("\"refSubSpecialityCode\": \""+checkForNull(rset.getString("REFSUBSPECIALITYCODE_OP"))+"\" ,");
					outpatient.append("\"admissionDate\": \""+checkForNull(rset.getString("VISIT_ADM_DATE_TIME"))+"\" ,");
					//outpatient.append("\"clinicType\": \""+checkForNull(rset.getString("clinicType"))+"\" ,");
					outpatient.append("\"clinicType\": \"1\" },");
					
					StringBuffer clinicalsupport= new StringBuffer(" \"clinicalSupport\": {	");
					clinicalsupport.append("\"refClinicalSupportTypeCode\": \""+checkForNull(rset.getString("refClinicalSupportTypeCode"))+"\",");
					clinicalsupport.append("\"refVisitTypeCode\": \""+checkForNull(rset.getString("refVisitTypeCode"))+"\",");
					clinicalsupport.append("\"encounterDate\": \""+checkForNull(rset.getString("encounterDate"))+"\",");
					clinicalsupport.append("\"internalReferral\": "+v_internalReferral+",");
					clinicalsupport.append("\"refReferralSourceCode\": \""+v_refReferralSourceCode+"\" ,");
					clinicalsupport.append("\"externalFacilityCode\": \""+v_externalFacilityCode+"\" ,");
					clinicalsupport.append("\"externalReferralDate\": \""+v_externalReferralDate+"\" ,");   // today end
					clinicalsupport.append("\"otherExternalReferral\": \""+checkForNull(rset.getString("OTHEREXTERNALREFERRAL"))+"\" ,");
					
					System.out.println("641 FS");
					StringBuffer death= new StringBuffer(" \"forensic\": {	");
					death.append("\"dateOfDeath\": \""+checkForNull(rset.getString("DECEASED_DATE_TIME"))+"\" ,");
					death.append("\"mortuaryRegTime\": \""+checkForNull(rset.getString("MORT_REGN_DATE_TIME"))+"\" ,");
					death.append("\"medicoLegal\":  \""+checkForNull(rset.getString("MORT_MEDICO_LEGAL"))+"\" ,");
					
					pm_yn=checkForNull(rset.getString("MORT_AUTOPSY"));
					postmortem_yn=checkForNull(rset.getString("PM_YN"));
					death.append("\"autopsy\": "+pm_yn+" ,");
					death.append("\"autopsyNo\": \""+checkForNull(rset.getString("MORT_AUTOPSY_NUM"))+"\" ,");
					death.append("\"autopsyDateTime\": \""+checkForNull(rset.getString("autopsyDateTime"))+"\" ,");
					System.out.println("560");
					death.append("\"deathCertifier\":	{		");
					death.append("\"fullName\": \""+checkForNull(rset.getString("PRACT_FULL_NAME"))+"\" ,");
					death.append("\"otherName\": \""+checkForNull(rset.getString("PRACT_OTHE_NAME"))+"\" ,");
					death.append("\"mmc\": \""+checkForNull(rset.getString("PRACT_MMC_NO"))+"\" ,");
					death.append("\"permitRegistrationDate\": \""+checkForNull(rset.getString("PRACT_REGN_DATE"))+"\" ,");
					System.out.println("566");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("PRACT_IDENTITY_DTLS")),"~" );
					code1="99";
					//code2="";changed as per ML-MMOH-SCF-1196.
					code2="";
					while (temp_tkn.hasMoreTokens()){
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}

					death.append("\"identificationNo\": \""+code2+"\" ,");
					death.append("\"refIdentificationTypeCode\": \""+code1+"\" ,");
					death.append("\"refCertifierPositionCode\": \""+checkForNull(rset.getString("PRACT_POSITION_CODE"))+"\" },");
					
					System.out.println("672 FS");
					
					StringBuffer forensic= new StringBuffer(" \"forensics\": [{	");
					
					if(postmortem_yn.equals("Y")){
										
						forensic.append("\"bid\": \""+checkForNull(rset.getString("BID"))+"\" ,");
						forensic.append("\"refForensicCategoryCode\": \""+checkForNull(rset.getString("Forensic_Category_Code"))+"\" ,");
						forensic.append("\"refPostMortemTypeCode\": \""+checkForNull(rset.getString("Post_Mortem_Type_Code"))+"\" ,");
						forensic.append("\"refForensicMannerCode\": \""+checkForNull(rset.getString("Forensic_Manner_Code"))+"\" ,");
						forensic.append("\"refForensicCaseCode\": \""+checkForNull(rset.getString("Forensic_Case_Code"))+"\" ,");
						forensic.append("\"policeStation\": \""+checkForNull(rset.getString("police_Station"))+"\" ,");
						forensic.append("\"policeReportNo\": \""+checkForNull(rset.getString("police_Report_No"))+"\" ,");
						forensic.append("\"orderAutopsyFormTimestamp\": \""+checkForNull(rset.getString("order_AutopsyForm_Timestamp"))+"\" ,");
						forensic.append("\"refCorpseHandOverOrDisposalCode\": \""+checkForNull(rset.getString("CorpseHandOver_DisposalCode"))+"\" ,");
						forensic.append("\"refCorpseHandOverOrDisposalOthers\": \""+checkForNull(rset.getString("CorpseHandOver_DisposalOthers"))+"\" ,");
						forensic.append("\"labInvestigation\": \""+checkForNull(rset.getString("lab_Investigation"))+"\" },");
					}else{
						
						forensic.append("\"bid\": \""+filler+"\" ,");
						forensic.append("\"refForensicCategoryCode\": \""+filler+"\" ,");
						forensic.append("\"refPostMortemTypeCode\": \""+filler+"\" ,");
						forensic.append("\"refForensicMannerCode\": \""+filler+"\" ,");
						forensic.append("\"refForensicCaseCode\": \""+filler+"\" ,");
						forensic.append("\"policeStation\": \""+filler+"\" ,");
						forensic.append("\"policeReportNo\": \""+filler+"\" ,");
						forensic.append("\"orderAutopsyFormTimestamp\": \""+filler+"\" ,");
						forensic.append("\"refCorpseHandOverOrDisposalCode\": \""+filler+"\" ,");
						forensic.append("\"refCorpseHandOverOrDisposalOthers\": \""+filler+"\" ,");
						forensic.append("\"labInvestigation\": \""+filler+"\" },");
						
					}
					
					
					System.out.println("706 FS");
					StringBuffer diagnosis= new StringBuffer("{ \"diagnosis\": [	");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("DIAG_DETAILS")),"$" );
					int out_token=temp_tkn.countTokens();
					int j=0;
					while (temp_tkn.hasMoreTokens()){
							diagnosis.append("{");
							temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
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
								String start_cd="";
								if(sup_token>1){				
									
									support_dtls=temp_support.nextToken();
									
								}
								diagnosis.append("\"description\": \""+term_code_desc+"\" ,");
								diagnosis.append("\"diagnosisIcd10Codes\": [	{");
								diagnosis.append("\"refIcd10Main\": \""+term_code+"\" ");
								
								if (! support_dtls.equals("") ){
									start_cd=support_dtls.substring(0,1);
								}
								
								
								String sup_code="";
								String sup_type="";
								String sup_desc="";
								StringTokenizer temp_support_tkn;
								StringTokenizer temp_support_tkn1;

								if (start_cd.equals("V") ||start_cd.equals("W") ||start_cd.equals("X") ||start_cd.equals("Y") ){
									temp_support_tkn		= new StringTokenizer(support_dtls,"^" );

									while (temp_support_tkn.hasMoreTokens()){
										
										sup_code=temp_support_tkn.nextToken();
										sup_type= temp_support_tkn.nextToken();

										temp_support_tkn1		= new StringTokenizer(sup_type,"!" );
										sup_type= temp_support_tkn1.nextToken();
										sup_desc= temp_support_tkn1.nextToken();

									}
									//System.out.println(start_cd);
									diagnosis.append("}]},{");
									diagnosis.append("\"refDiagnosisItemTypeCode\": \"04\" ,");
									diagnosis.append("\"description\": \""+sup_desc+"\" ,");
									diagnosis.append("\"diagnosisIcd10Codes\": [	{");
									diagnosis.append("\"refIcd10Main\": \""+sup_code+"\" ");
									//diagnosis.append("}],");

								}else{
									System.out.println(support_dtls);
									temp_support_tkn		= new StringTokenizer(support_dtls,"^" );
									while (temp_support_tkn.hasMoreTokens()){
										
										sup_code=temp_support_tkn.nextToken();
										sup_type= temp_support_tkn.nextToken();

										temp_support_tkn1		= new StringTokenizer(sup_type,"!" );
										sup_type= temp_support_tkn1.nextToken();
										
										System.out.println(sup_code);
										System.out.println(sup_type);
										/*if(k==0){
											diagnosis.append("},");
										}
										diagnosis.append("{");*/
										diagnosis.append(",");
										k++;
										if(sup_type.equals("A")){
											diagnosis.append("\"refIcd10Asterisk\": \""+sup_code+"\" ");
										}else if (sup_type.equals("E")){
											diagnosis.append("\"refIcd10Supplementary\": \""+sup_code+"\" ");
										}else{
											diagnosis.append("\"refIcd10Zcode\": \""+sup_code+"\" ");
										}
										/*diagnosis.append("}");
										if(k  >2){
											diagnosis.append(",");
										}*/

									}
								}
								
								//if(sup_token<2){
									diagnosis.append(" }");
								//}
								diagnosis.append("]");
								
							}
							diagnosis.append(" }");
							if(j  <out_token){
									diagnosis.append(",");
							}
							
					}

					diagnosis.append(" ]	}	,");

					
						
		
						
						StringBuffer pmProviders= new StringBuffer("{ \"postMortemProviders\": [	");
						temp_tkn=null;
						temp_tkn		= new StringTokenizer(checkForNull(rset.getString("PM_TEAM_DTLS")),"@" );
						//System.out.println("pm temp_tkn-->"+ temp_tkn.countTokens());
						int out_tokenpm=temp_tkn.countTokens();
						int jpm=0;
						//pmProviders.append(" {");
						while (temp_tkn.hasMoreTokens()){
								if(jpm >0){
									pmProviders.append(" ,	");
								}
								pmProviders.append("{");
								StringTokenizer temp_tkn_innerr		= new StringTokenizer(temp_tkn.nextToken(),"~" );
								
								jpm	++;
								
								//System.out.println("pm temp_tkn_inner-->"+ temp_tkn_inner.countTokens());
								while (temp_tkn_innerr.hasMoreTokens()){
									String id=temp_tkn_innerr.nextToken();
									String nm=temp_tkn_innerr.nextToken();
									String desg=temp_tkn_innerr.nextToken();
									String regnbr=temp_tkn_innerr.nextToken();
									String fccd=mapped_fac_id;
									
									if(nm.equals("**")){
										nm="";
									}
									
									if(desg.equals("**")){
										desg="";
									}
									
									if(regnbr.equals("**")){
										regnbr="";
									}
									
																	
									if(postmortem_yn.equals("Y")){
										pmProviders.append("\"fullName\": \""+nm+"\" ,");
										pmProviders.append("\"refDesignationCode\": \""+desg+"\" ,");
										pmProviders.append("\"facilityCode\": \""+fccd+"\" ,");
										pmProviders.append("\"regNumber\": \""+regnbr+"\" ");
									}else{
										pmProviders.append("\"fullName\": \""+filler+"\" ,");
										pmProviders.append("\"refDesignationCode\": \""+filler+"\" ,");
										pmProviders.append("\"facilityCode\": \""+filler+"\" ,");
										pmProviders.append("\"regNumber\": \""+filler+"\" ");
									}
									
								}
								pmProviders.append(" }	");
									
									
						}
						
								 
						
						pmProviders.append(" ]	}	");
						
						
						
						
						forensic.append(diagnosis.toString());
						forensic.append(pmProviders.toString());
						forensic.append(" ]");
						death.append(forensic.toString());
						death.append("}}");
						
					clinicalsupport.append(death.toString());
					
					clinicalsupport.append("}");
					
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
					if (pat_class.equals("03")){
						str_head.append(OP_discharge.toString());
						str_head.append(outpatient.toString());
					}else{
						str_head.append(admission.toString());
					}
					//clinicalsupport.append(death.toString());
					
					str_head.append(clinicalsupport.toString());
					
						
					

					i++;
				 }// while loop for encounter 
				 str_foot.append(" ]	}");

				str_head.append(str_foot.toString());
				filename=filename+"_CSFS.json";

				if(i>0){
				
					try{
						
						//System.out.println("dir-->"+dir);
						//FileWriter file = new FileWriter(dir+"\\"+filename+"_CS_FS.json");/*File is Created with Json object as data in specific folder*/
						System.out.println("<-- CS_FS SRVLT-->"+str_head.toString());
						//System.out.println("filename-->"+filename);
						dir=dir+filename;
						System.out.println("dir-->"+dir);
						File CS_FSjson = new File (dir);
						FileWriter file = new FileWriter(CS_FSjson);/*File is Created with Json object as data in specific folder*/
						//System.out.println("CS_FSjson.getPath()-->"+CS_FSjson.getPath());
						//System.out.println("CS_FSjson.getAbsolutePath()-->"+CS_FSjson.getAbsolutePath());
						//System.out.println("CS_FSjson.getName()-->"+CS_FSjson.getName());

						
						//str_head.append(str_foot.toString());
						file.write(str_head.toString());
						fileCreated="1";
						//System.out.println("fileCreated@746-->"+fileCreated);
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"CS_FS",CS_FSjson.getAbsolutePath());
						file.flush();
						file.close();

						if(dir.equals("")){
							fileCreated="2";
							 System.out.println("Error while file obj  CS_FS generation. No dir path-->"+filename);
							 smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"CS_FS","File creation path is not defined");
						}

					} catch (IOException e) {
						fileCreated="2";
						System.err.println("Exception in createCS_FS function Inside try:"+e.toString());
						System.out.println("Error while file obj  CS_FS generation-->"+filename+"-->"+e.toString());
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"CS_FS","IO Error. Unable to create File for CS_RA generation");
						e.printStackTrace();
					}
				}else{ // no data for file generation
					System.out.println("No data for CS_FS generation-->"+filename);
					fileCreated="0";
					smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"CS_FS","No data for CS_FS generation");
				}
	}	 //check in function control		
		
		}catch (Exception e) {
			  System.err.println("Exception in createCS_FS function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"CS_FS",e.toString());
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
	


public static class JobScheduleCS_FS extends TimerTask {

 /*The main method will be invoked when Server is Started*/
  public  void main (String... arguments ) {
    TimerTask JobScheduleCS_FS = new JobScheduleCS_FS();
   
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
		rset =  stmt.executeQuery("select nvl(to_char(LAG_TIME,'HH24'),'00') hr,nvl(to_char(LAG_TIME,'mi'),'00') min from MR_SMRP_CONFIG where SMRP_ID='CS_FS'");
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
    timer.scheduleAtFixedRate(JobScheduleCS_FS, getTomorrowMorning12am(hr,mn), fONCE_PER_DAY);
	//timer.scheduleAtFixedRate(JobScheduleCS_FS, getTomorrowMorning12am(), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GenerateCS_FS Gjson= new GenerateCS_FS();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'	");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createCS_FS(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobScheduleCS_FS Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	  private final static long fONCE_PER_DAY = 1000*60*60*24;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 00;
	  private final static int fZERO_MINUTES = 45; 

	/*The function will retutn the time at which the process has to be run*/
	  private  Date getTomorrowMorning12am(int fZEROHOUR,int fZERO_MINUTES){
	  //private  Date getTomorrowMorning12am(){
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