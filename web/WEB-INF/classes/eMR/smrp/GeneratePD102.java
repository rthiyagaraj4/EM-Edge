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
  

public class GeneratePD102 extends HttpServlet 
{ 

	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobSchedulePD102 js =new JobSchedulePD102();
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
			
		/*This will make call to createPD102 function which will create the JSON file*/
			GeneratePD102 Gjson= new GeneratePD102();

			String PD102_fileCreated_flag="";

			PD102_fileCreated_flag =Gjson.createPD102(facility_id,from_date,to_date);

			System.out.println("PD102_fileCreated_flag-->:"+PD102_fileCreated_flag);

			String error="";
			if(PD102_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (PD102_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (PD102_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + PD102_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createPD102(String facility_id,String start_date,String end_date)					
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
			rset =  stmt.executeQuery("select VALUE_1 file_path,SITE_ID  from SM_FUNCTION_CONTROL where module_id='MR' and functionality_id='SMRP' and SITE_ID=(select customer_id from sm_site_param)");
			if(rset!= null && rset.next()){
				dir=rset.getString("file_path");
				Site_id=rset.getString("SITE_ID");
			}

			rset.close();
			stmt.close();
			
			if(dir.equals("")&& def_duration==0) {
				fileCreated="2";				
   			    //System.out.println(" No dir path --> "+dir +" -->"+filename);
			}else{
				def_duration=1;
				stmt =  con.createStatement();				
				rset =  stmt.executeQuery("select DURATION def_duration from MR_SMRP_CONFIG where SMRP_ID='PD102'");
				if(rset!= null && rset.next()){
					def_duration=rset.getInt("def_duration");
					
				}

				rset.close();
				stmt.close();

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

				/*The View which is created for this PD102Json purpose*/

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
				//stmt =  con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				stmt =  con.createStatement();
				rset =  stmt.executeQuery("select EXT_PK_ID from  XH_OTH_APPL_DATA_SKEY WHERE table_id='AM_PATIENT_CLASS' and APPLICATION_ID='SMRP' and PK_VALUE='IP'");
				
				if(rset!=null && rset.next()){
					refServiceTypeCode=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				
				String sqlQuery		  = "SELECT * FROM MR_PD102_VW  WHERE time_of_birth BETWEEN TO_DATE ('"+start_date+"','dd/mm/yyyy') AND TO_DATE ('"+end_date+"', 'dd/mm/yyyy') + 0.99999 and FACILITY_CODE='"+facility_id+"' ORDER BY mrn_mother";

				stmt =  con.createStatement();
				
				System.out.println("sqlQuery-->"+sqlQuery);
				rset =  stmt.executeQuery(sqlQuery);


				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				String fl_name=filename+"_PD102";
				
				System.out.println("filename-->"+filename);

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				
				StringBuffer str_head=new StringBuffer("");
				str_head.append("{\"filename\": \""+fl_name+"\",\"refServiceTypeCode\": \""+refServiceTypeCode+"\",\"formType\": \"102\",\"facilityCode\": \""+mapped_fac_id+"\",");
				str_head.append("\"birthDateFrom\": \""+from_date+"\",\"birthDateTo\": \""+to_date+"\",\"forms\": [");
			

				StringBuffer str_foot=new StringBuffer("");
				StringBuffer babies= new StringBuffer("");

				String mother_id="";
				boolean append=false;

				int i=0;
				int no_of_babies=1;

				 while(rset!=null && rset.next()) 	{  	 // looping each mother encounter

					if(mother_id.equals(rset.getString("MRN_MOTHER"))){
						append=false;
						no_of_babies++;
					}else{
						append=true;
						no_of_babies=1;
					}

					mother_id=rset.getString("MRN_MOTHER");

					StringBuffer visit= new StringBuffer("");
					System.out.println("inisde mother loop visit string-->"+visit.toString());
					if( i>0){											
						visit.append(",");					
					}
					System.out.println("i value -->"+ i); 

					visit.append("{ \"visit\": { \"rn\": \""+checkForNull(rset.getString("REG_NBR"))+"\",");
					visit.append("\"clusterFacilityRn\": \""+checkForNull(rset.getString("clstr_fac_rn"))+"\",");
					// cluster facilty pass empty
					visit.append("\"mrn\": \""+checkForNull(rset.getString("MRN_MOTHER"))+"\",");
					visit.append("\"eventDate\": \""+checkForNull(rset.getString("EVENT_DATE"))+"\",");  // after mrn
					visit.append("\"isPoliceCase\": \""+checkForNull(rset.getString("POLICE_CASE"))+"\","); 
					visit.append("\"letterOfGuarantee\": \""+checkForNull(rset.getString("GUARANTEE_LETTER"))+"\",");
					//visit.append("\"facilitycode\": \""+checkForNull(rset.getString("facility_code"))+"\","); 
					//visit.append("\"refServiceTypeId\": \""+checkForNull(rset.getString("ref_service_type_id"))+"\",");



					
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

					//visit.append("\"internalReferral\": \""+v_internalReferral+"\",");
					visit.append("\"internalReferral\": "+v_internalReferral+",");
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
					//String lain_lain="00";
					//person.append("\"refEducationLevelCode\": \""+lain_lain+"\" ,"); // today down 3
					//person.append("\"refMonthlyHouseholdIncomeCode\": \""+lain_lain+"\" ,");
					//person.append("\"refOccupationSectorCode\": \""+lain_lain+"\" ,"); //today
					//person.append("\"occupationDesignation\": \""+lain_lain+"\" ,"); //today
					person.append("\"height\": \""+checkForNull(rset.getString("pat_height"))+"\" ,");
					person.append("\"weight\": \""+checkForNull(rset.getString("pat_weight"))+"\" ,");
					person.append("\"refForeignerOriginCountryCode\": \""+checkForNull(rset.getString("FRG_ORG_CNTRY_CD"))+"\" ,");
					person.append("\"refForeignerResidenceCountryCode\": \""+checkForNull(rset.getString("FRG_RES_CNTRY_CD"))+"\" ,");
					//person.append("\"foreignerResidenceCity\": \"" "\" ,");
					person.append("\"refPersonCategoryCode\": \"" +checkForNull(rset.getString("pat_cat_code"))+"\" ,"); // today
					//person.append("\"refMilitaryTypeRankCode\": \"" "\" ,");


					StringTokenizer temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IDENTITY_DTLS")),"~" );
					/*identifications -Start*/
					StringBuffer identifications= new StringBuffer(" \"identifications\": [");
					//System.out.println("temp.length  272-->:"+temp_tkn.countTokens());
					//String v_id_code="00";  // changed as per ML-MMOH-SCF-1196.
					String v_id_code="99";  // handle logic for passport and stuff.
					String v_id_no="0";
					String v_pp_exp="";
					String v_rel_cd="";
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
					
					
					identifications.append("],");


					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("ADDRESS_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer moth_addr= new StringBuffer(" \"addresses\": [");
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

					moth_addr.append("{\"refAddressTypeCode\": \""+code1+"\" ,");
					moth_addr.append("\"street1\": \""+code2+"\" ,");
					moth_addr.append("\"street2\": \""+code3+code4+"\" ,");
					
					if(Site_id.equals("SLY")){
						moth_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						moth_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					moth_addr.append("\"refPostCode\": \""+code8+"\" ,");
					moth_addr.append("\"refStateCode\": \""+code5+"\" ,");
					moth_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext mapping is available
					moth_addr.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("PAT_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer moth_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//moth_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//moth_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					moth_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					moth_cont.append("\"contactInfo\": \""+code2+"\" }");

					moth_cont.append("]},");


					StringBuffer next_kin= new StringBuffer(" \"nextOfKins\": { ");
					 //next_kin.append("\"refPersonTitleCode\": \"" "\" ,");
					 
					 next_kin.append("\"refPersonTitleCode\": \""+checkForNull(rset.getString("MOT_NXT_KN_TITLE"))+"\" ,");
					 next_kin.append("\"fullName\": \""+checkForNull(rset.getString("MOT_NXT_KN_NAME"))+"\" ,");
					 //next_kin.append("\"otherName\": \""+ +"\" ,");
					 next_kin.append("\"refRelationshipCode\": \""+checkForNull(rset.getString("MOT_NXT_KN_RLN"))+"\" ,");

					
					/*identifications -Start*/
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("M_NXT_KN_IDENTITY_DTLS")),"~" );
					/*identifications -Start*/
					StringBuffer nk_identifications= new StringBuffer(" \"identifications\": [");
					//code1="00"; changed as per ML-MMOH-SCF-1196.
					code1="99";
					code2="0";
					while (temp_tkn.hasMoreTokens()){
						//nk_identifications.append("{\"refIdentificationTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						//nk_identifications.append("\"identificationNo\": \""+temp_tkn.nextToken()+"\" }");
						code1=temp_tkn.nextToken();
						code2=temp_tkn.nextToken();
					}
					nk_identifications.append("{\"refIdentificationTypeCode\": \""+code1+"\" ,");
					nk_identifications.append("\"identificationNo\": \""+code2+"\" }");
					nk_identifications.append("],");


					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("M_NXT_KN_ADDRESS_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer nk_addr= new StringBuffer(" \"addresses\": [");
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
						/*nk_addr.append("{\"refAddressTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						nk_addr.append("\"street1\": \""+temp_tkn.nextToken()+"\" ,");
						nk_addr.append("\"street2\": \""+temp_tkn.nextToken()+"\" ,");
						String code3=temp_tkn.nextToken();
						nk_addr.append("\"refStateCode\": \""+temp_tkn.nextToken()+"\" ,");
						String code5=temp_tkn.nextToken();
						nk_addr.append("\"refCityCode\": \""+temp_tkn.nextToken()+"\" ,");
						nk_addr.append("\"refPostCode\": \""+temp_tkn.nextToken()+"\" ,");
						nk_addr.append("\"refCountryCode\": \""+temp_tkn.nextToken()+"\" }"); //to open when ext country mapping is available
						//nk_addr.append("\"refCountryCode\": \"--\" }");
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

					nk_addr.append("{\"refAddressTypeCode\": \""+code1+"\" ,");
					nk_addr.append("\"street1\": \""+code2+"\" ,");
					nk_addr.append("\"street2\": \""+code3+code4+"\" ,");
					
					if(Site_id.equals("SLY")){
						nk_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						nk_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					nk_addr.append("\"refPostCode\": \""+code8+"\" ,");
					nk_addr.append("\"refStateCode\": \""+code5+"\" ,");
					nk_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext country mapping is available

					nk_addr.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("M_NXT_KN_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer nk_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//nk_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//nk_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					nk_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					nk_cont.append("\"contactInfo\": \""+code2+"\" }");
					nk_cont.append("]},");
					
					StringBuffer emergency= new StringBuffer(" \"emergencyContacts\": [ {");
					//emergency.append("\"refPersonTitleCode\": \"" "\" ,");
					
					emergency.append("\"refPersonTitleCode\": \""+checkForNull(rset.getString("MOT_EMER_TITLE"))+"\" ,");
					emergency.append("\"fullName\": \""+checkForNull(rset.getString("EMER_CNT_NAME"))+"\" ,");
					//emergency.append("\"otherName\": \"" "\" ,");
					emergency.append("\"refRelationshipCode\": \""+checkForNull(rset.getString("EMER_CNT_RLN"))+"\" ,");
					//emergency.append("\"otherRelationship\": \"" "\" ,");
					
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("M_EMER_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer emer_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//emer_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//emer_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					emer_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					emer_cont.append("\"contactInfo\": \""+code2+"\" }");
					emer_cont.append("]}],");

					StringBuffer wrd_dtls= new StringBuffer(" \"admissions\": [");
					temp_tkn=null;
					
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_AT_DETAILS")),"@" );
					int ijk=0;
					//System.out.println("ADT_val-->"+ rset.getString("IP_ADT_DETAILS"));
					while (temp_tkn.hasMoreTokens()){
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );

							if(ijk>0){
									wrd_dtls.append(",");
							}
				
							while (temp_tkn_inner.hasMoreTokens()){								
								wrd_dtls.append("{\"refWardTransitionTypeCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								wrd_dtls.append("\"wardDateTime\": \""+temp_tkn_inner.nextToken()+"\" ,");
								wrd_dtls.append("\"wardCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								String service_code=temp_tkn_inner.nextToken();
								String room_no=temp_tkn_inner.nextToken();
								String bed_no=temp_tkn_inner.nextToken();
								String bed_class=temp_tkn_inner.nextToken();
								String bed_type=temp_tkn_inner.nextToken();
								String pract_id=temp_tkn_inner.nextToken();
								String spc_code=temp_tkn_inner.nextToken();

								wrd_dtls.append("\"refDisciplineCode\": \""+service_code+"\" ,");
								wrd_dtls.append("\"refSpecialityCode\": \""+spc_code+"\" ,");
								wrd_dtls.append("\"refSubSpecialityCode\": \""+spc_code+"\" ,");
								wrd_dtls.append("\"refWardClassCode\": \""+bed_class+"\" ,");
								wrd_dtls.append("\"refWardCategoryCode\": \""+bed_type+"\" }");
							}

							ijk++;
					}
					
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("IP_DISC_DETAILS")),"~" );
				
					while (temp_tkn.hasMoreTokens()){
						if(ijk>0){
									wrd_dtls.append(",");
								}
						wrd_dtls.append("{\"refWardTransitionTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
						wrd_dtls.append("\"wardDateTime\": \""+temp_tkn.nextToken()+"\" ,");
						wrd_dtls.append("\"wardCode\": \""+temp_tkn.nextToken()+"\" ,");
						String service_code=temp_tkn.nextToken();
						String room_no=temp_tkn.nextToken();
						String bed_no=temp_tkn.nextToken();
						String bed_class=temp_tkn.nextToken();
						String bed_type=temp_tkn.nextToken();
						String pract_id=temp_tkn.nextToken();
						String spc_code=temp_tkn.nextToken();

						wrd_dtls.append("\"refDisciplineCode\": \""+service_code+"\" ,");
						wrd_dtls.append("\"refSpecialityCode\": \""+spc_code+"\" ,");
						wrd_dtls.append("\"refSubSpecialityCode\": \""+spc_code+"\" ,");
						wrd_dtls.append("\"refWardClassCode\": \""+bed_class+"\" ,");
						wrd_dtls.append("\"refWardCategoryCode\": \""+bed_type+"\" }");
					}

					wrd_dtls.append("],");


					StringBuffer labour= new StringBuffer(" \"labour\": {");
					 labour.append("\"admissionDateTime\": \""+checkForNull(rset.getString("event_date"))+"\",");
					 labour.append("\"gravida\": \""+checkForNull(rset.getString("GRAVIDA"))+"\",");
					 labour.append("\"para\": \""+checkForNull(rset.getString("PARITY"))+"\",");
					 labour.append("\"periodOfGestationDay\": \""+checkForNull(rset.getString("GESTATION_DAYS"))+"\",");
					 labour.append("\"periodOfGestationWeek\": \""+checkForNull(rset.getString("GESTATION_WEEK"))+"\",");
					 labour.append("\"periodOfAmenorrhoeaDay\": \""+checkForNull(rset.getString("PRD_AMENOREA_DAY"))+"\",");
					 labour.append("\"periodOfAmenorrhoeaWeek\": \""+checkForNull(rset.getString("PRD_AMENOREA_WEEK"))+"\" ,");
					 //labour.append("\"miscarriageDateTime\":  \"\",");
					 //labour.append("\"isMotherAlive\": \""+checkForNull(rset.getString("mother_alive"))+"\",");
					 labour.append("\"isMotherAlive\": "+checkForNull(rset.getString("mother_alive"))+",");
					 labour.append("\"estimatedDeliveryDate\": \""+checkForNull(rset.getString("EST_DEL_DT"))+"\",");
					 labour.append("\"revisedDeliveryDate\": \""+checkForNull(rset.getString("REV_DEL_DT"))+"\",");
					 labour.append("\"lastMenstrualDate\": \""+checkForNull(rset.getString("lmp"))+"\",");
					 labour.append("\"refAntenatalCareCode\": \""+checkForNull(rset.getString("antenatal_care"))+"\",");
					 labour.append("\"refLabourStatusCode\": \""+checkForNull(rset.getString("labour_status"))+"\" ,");
					 //labour.append("\"refLabourTypeCode\": \"" "\" ,");
					 //labour.append("\"lastMenstrualDate\": \"" "\" ,");



					 StringBuffer father= new StringBuffer(" \"father\": {");
					father.append("\"refPersonTitleCode\": \""+checkForNull(rset.getString("FAT_TITLE_CODE_MAP"))+"\" ,");
					father.append("\"fullName\": \""+checkForNull(rset.getString("FATHER_NAME"))+"\" ,");
					//father.append("\"otherName\": \"" "\" ,");
					father.append("\"refOccupationSectorCode\": \""+checkForNull(rset.getString("occupation_sector"))+"\" ,");
					//father.append("\"occupationDesignation\": \"" "\" ,");
					father.append("\"refCitizenshipCode\": \""+checkForNull(rset.getString("FAT_CITIZEN_YN_MAP"))+"\" ,");
					father.append("\"refEthnicCode\": \""+checkForNull(rset.getString("FAT_ETHNIC_GRP_CODE_MAP"))+"\" ,");
					father.append("\"refForeignerOriginCountryCode\": \""+checkForNull(rset.getString("FAT_FRG_ORG_CNTRY_CD"))+"\" ,");
					father.append("\"refForeignerResidenceCountryCode\": \""+checkForNull(rset.getString("FAT_FRG_RES_CNTRY_CD"))+"\" ,");
					//father.append("\"foreignerResidenceCity\": \"" "\" ,");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("FAT_IDENTITY_DTLS")),"~" );
					System.out.println("checkForNull(rset.getString(FAT_IDENTITY_DTLS)-->:"+checkForNull(rset.getString("FAT_IDENTITY_DTLS")));
					StringBuffer fath_ident= new StringBuffer(" \"identifications\": [");
					//code1="00"; changed as per ML-MMOH-SCF-1196.
					code1="99";
					code2="0";
					while (temp_tkn.hasMoreTokens()){
							//fath_ident.append("{\"refIdentificationTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//fath_ident.append("\"identificationNo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					fath_ident.append("{\"refIdentificationTypeCode\": \""+code1+"\" ,");
					fath_ident.append("\"identificationNo\": \""+code2+"\" }");
					fath_ident.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("FAT_ADDRESS_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer fath_addr= new StringBuffer(" \"addresses\": [");
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
							/*fath_addr.append("{\"refAddressTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							fath_addr.append("\"street1\": \""+temp_tkn.nextToken()+"\" ,");
							fath_addr.append("\"street2\": \""+temp_tkn.nextToken()+"\" ,");
							String code3=temp_tkn.nextToken();
							fath_addr.append("\"refStateCode\": \""+temp_tkn.nextToken()+"\" ,");
							String code5=temp_tkn.nextToken();
							fath_addr.append("\"refCityCode\": \""+temp_tkn.nextToken()+"\" ,");
							fath_addr.append("\"refPostCode\": \""+temp_tkn.nextToken()+"\" ,");
							fath_addr.append("\"refCountryCode\": \""+temp_tkn.nextToken()+"\" }"); //to open when ext country mapping is available
							//fath_addr.append("\"refCountryCode\": \"--\" }");
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
					fath_addr.append("{\"refAddressTypeCode\": \""+code1+"\" ,");
					fath_addr.append("\"street1\": \""+code2+"\" ,");
					fath_addr.append("\"street2\": \""+code3+code4+"\" ,");
					fath_addr.append("\"refStateCode\": \""+code5+"\" ,");
					
					if(Site_id.equals("SLY")){
						fath_addr.append("\"refCityCode\": \""+code6+"\" ,"); // Selayang code 6. WCH code 7
					}else{
						fath_addr.append("\"refCityCode\": \""+code7+"\" ,"); // Selayang code 6. WCH code 7
					}
					fath_addr.append("\"refPostCode\": \""+code8+"\" ,");
					fath_addr.append("\"refCountryCode\": \""+code9+"\" }"); //to open when ext country mapping is available
					fath_addr.append("],");

					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("FAT_CONTACT_INFO")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					StringBuffer fath_cont= new StringBuffer(" \"contacts\": [");
					code1="";
					code2="";
					while (temp_tkn.hasMoreTokens()){
							//fath_cont.append("{\"refContactTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							//fath_cont.append("\"contactInfo\": \""+temp_tkn.nextToken()+"\" }");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					fath_cont.append("{\"refContactTypeCode\": \""+code1+"\" ,");
					fath_cont.append("\"contactInfo\": \""+code2+"\" }");
					fath_cont.append("]},");
					
					int enc_baby_count=Integer.parseInt(rset.getString("BABY_COUNT"));

					System.out.println("enc_baby_count  289-->"+enc_baby_count);
					System.out.println("no_of_babies  289-->"+no_of_babies);

					babies= new StringBuffer("");
					if(no_of_babies==1){					
						babies.append(" \"babies\": [");
					}

					System.out.println("fileCreated-->"+fileCreated);

					babies.append("{");
					babies.append("\"labourDateTime\": \""+checkForNull(rset.getString("LBR_DT_TM"))+"\" ,");
					//babies.append("\"bornBeforeArrival\": \""+((rset.getString("bba")).equals("B")?"true":"false")+"\" ,");
					babies.append("\"bornBeforeArrival\": "+((rset.getString("bba")).equals("B")?"true":"false")+",");
					//babies.append("\"isBabyAlive\": \""+checkForNull(rset.getString("BABY_ALIVE"))+"\" ,");
					babies.append("\"isBabyAlive\": "+checkForNull(rset.getString("BABY_ALIVE"))+",");
					babies.append("\"refLabourTypeCode\": \""+checkForNull(rset.getString("LBR_TYPE"))+"\" ,");
					babies.append("\"refLabourModeCode\": \""+checkForNull(rset.getString("LBR_MODE"))+"\" ,");
					babies.append("\"refGenderCode\": \""+checkForNull(rset.getString("BABY_GENDER"))+"\" ,");
					babies.append("\"birthWeight\": \""+checkForNull(rset.getString("BABY_WEIGHT_GRAM"))+"\" ,");
					babies.append("\"birthLength\": \""+checkForNull(rset.getString("BABY_LENGTH_CM"))+"\" ,");
					babies.append("\"birthHeadCircumference\": \""+checkForNull(rset.getString("BABY_CHEST_CIRCUM"))+"\" ,");
					babies.append("\"refBloodTypeCode\": \""+checkForNull(rset.getString("BLOOD_GRP"))+"\" ,");
					babies.append("\"refRhesusCode\": \""+checkForNull(rset.getString("RH_FACTOR"))+"\" ,");
					babies.append("\"refMin1ApgarScoreCode\": \""+checkForNull(rset.getString("APGAR_SCORE_IN_1_MIN"))+"\" ,");
					babies.append("\"refMin5ApgarScoreCode\": \""+checkForNull(rset.getString("APGAR_SCORE_IN_5_MINS"))+"\" ,");
					babies.append("\"refLabourComplicationCodes\": [\""+checkForNull(rset.getString("COMPLNS_1ST_STAGE_LABOUR_CODE"))+"\" ,");
					babies.append(" \""+checkForNull(rset.getString("COMPLNS_2ND_STAGE_LABOUR_CODE"))+"\" ,");
					babies.append(" \""+checkForNull(rset.getString("COMPLNS_3RD_STAGE_LABOUR_CODE"))+"\" ],");
					babies.append("\"labourComplicationOther\": \""+checkForNull(rset.getString("OTHER_COMPLICATIONS"))+"\" ,");
					babies.append("\"labourAttendant\": { ");
 
					System.out.println("line 662-");

					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("PRACT_IDENTY_DTLS")),"~" );
					//System.out.println("temp.length  289-->:"+temp_tkn.countTokens());
					//code1="00";changed as per ML-MMOH-SCF-1196.
					code2="99";
					code1="0";
					while (temp_tkn.hasMoreTokens()){
							//babies.append("\"identificationNo\": \""+temp_tkn.nextToken()+"\" ,");
							//babies.append("\"refIdentificationTypeCode\": \""+temp_tkn.nextToken()+"\" ,");
							code1=temp_tkn.nextToken();
							code2=temp_tkn.nextToken();
					}
					babies.append("\"identificationNo\": \""+code1+"\" ,");
					babies.append("\"refIdentificationTypeCode\": \""+code2+"\" ,");

									//System.out.println("line 677-");

					babies.append("\"fullName\": \""+checkForNull(rset.getString("PRACTITIONER_NAME"))+"\" ,");
					//babies.append("\"refLabourAttendantTypeCode\": \""+checkForNull(rset.getString("position_type"))+"\" },");
					// above line commented and below 2 lines added for ML-MMOH-SCF-1196 on 30 march 2019
					//String refLabourAttendantTypeCode="00";
					babies.append("\"refLabourAttendantTypeCode\": \""+checkForNull(rset.getString("pract_type"))+"\" },");
					//babies.append("\"otherLabourAttendantType\": \"" "\" ,");
					//babies.append("\"passportExpiredDate\": \"" "\" ,");
					StringTokenizer bby_trmt_tkn		= new StringTokenizer(checkForNull(rset.getString("baby_treatment")),"@" );
					babies.append("\"refBabyTreatmentCodes\": [");
					babies.append("\""+bby_trmt_tkn.nextToken()+"\" ,");
					babies.append("\""+bby_trmt_tkn.nextToken()+"\" ,");
					babies.append("\""+bby_trmt_tkn.nextToken()+"\" ]	}");

									//System.out.println("line 689-");
					
					if(enc_baby_count ==no_of_babies){
						babies.append("]	}	}");
					}else{
						babies.append(" 	,");
					}
					
					System.out.println("append-->"+append);
					if(append){
						str_head.append(visit.toString());
						str_head.append(person.toString());
						str_head.append(identifications.toString());
						str_head.append(moth_addr.toString());
						str_head.append(moth_cont.toString());
						str_head.append(next_kin.toString());
						str_head.append(nk_identifications.toString());
						str_head.append(nk_addr.toString());
						str_head.append(nk_cont.toString());
						str_head.append(emergency.toString());
						str_head.append(emer_cont.toString());
						str_head.append(wrd_dtls.toString());
						str_head.append(labour.toString());
						str_head.append(father.toString());
						str_head.append(fath_ident.toString());
						str_head.append(fath_addr.toString());
						str_head.append(fath_cont.toString());
					}
					str_head.append(babies.toString());

					i++;
				 }// end loop for mother
				 System.out.println("outside loop-->");
				 str_foot.append(" ]	}");

				str_head.append(str_foot.toString());
				 System.out.println("line 725 value of i-->"+i);
				 filename=filename+"_PD102.json";
				if(i>0){
				
					try{
						
						//System.out.println("dir-->"+dir);
						//FileWriter file = new FileWriter(dir+"\\"+filename+"_PD102.json");/*File is Created with Json object as data in specific folder*/
						//System.out.println("<-- PD102-->"+str_head.toString());
						//System.out.println("filename-->"+filename);
						dir=dir+filename;
						System.out.println("dir-->"+dir);
						File PD102json = new File (dir);
						FileWriter file = new FileWriter(PD102json);/*File is Created with Json object as data in specific folder*/
						//System.out.println("PD102json.getPath()-->"+PD102json.getPath());
						//System.out.println("PD102json.getAbsolutePath()-->"+PD102json.getAbsolutePath());
						//System.out.println("--------PD102json.getName()-->"+PD102json.getName()); 
						
						
						
						//str_head.append(str_foot.toString());
						file.write(str_head.toString());
						fileCreated="1";
						//System.out.println("fileCreated@746-->"+fileCreated);
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD102",PD102json.getAbsolutePath());
						file.flush();
						file.close();

						if(dir.equals("")){
							fileCreated="2";
							 System.out.println("Error while file obj  PD102 generation. No dir path-->"+filename);
							 smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD102","File creation path is not defined");
						}

					} catch (IOException e) {
						fileCreated="2";
						System.err.println("Exception in createPD102 function Inside try:"+e.toString());
						System.out.println("Error while file obj  PD102 generation-->"+filename+"-->"+e.toString());
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD102","IO Error. Unable to create File for PD102 generation");
						e.printStackTrace();
					}
				}else{ // no data for file generation
					System.out.println("No data for PD102 generation-->"+filename);
					fileCreated="0";
					smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD102","No data for PD102 generation");
				}
			} //check in function control
		
		}catch (Exception e) {
			  System.err.println("Exception in createPD102 function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PD102",e.toString());
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
	


public static class JobSchedulePD102 extends TimerTask {

 /*The main method will be invoked when Server is Started*/
  public  void main (String... arguments ) {
    TimerTask JobSchedulePD102 = new JobSchedulePD102();
   
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
		rset =  stmt.executeQuery("select nvl(to_char(LAG_TIME,'HH24'),'00') hr,nvl(to_char(LAG_TIME,'mi'),'00') min from MR_SMRP_CONFIG where SMRP_ID='PD102'");
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
    timer.scheduleAtFixedRate(JobSchedulePD102, getTomorrowMorning12am(hr,mn), fONCE_PER_DAY);
	//timer.scheduleAtFixedRate(JobSchedulePD102, getTomorrowMorning12am(), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GeneratePD102 Gjson= new GeneratePD102();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createPD102(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobSchedulePD102 Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	  private final static long fONCE_PER_DAY = 1000*60*60*24;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 01;
	  private final static int fZERO_MINUTES = 30;

	/*The function will retutn the time at which the process has to be run*/
	  private  Date getTomorrowMorning12am(int fZEROHOUR,int fZERO_MINUTES){
	 // private  Date getTomorrowMorning12am(){
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