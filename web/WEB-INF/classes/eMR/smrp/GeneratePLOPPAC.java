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

import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class 	GeneratePLOPPAC extends HttpServlet 
{ 

	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobSchedulePLOPPAC js =new JobSchedulePLOPPAC();
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
			
		/*This will make call to createPLOPPAC function which will create the JSON file*/
			GeneratePLOPPAC Gjson= new GeneratePLOPPAC();

			String PLOPPAC_fileCreated_flag =Gjson.createPLOPPAC(facility_id,from_date,to_date);

			String error="";
			if(PLOPPAC_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (PLOPPAC_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (PLOPPAC_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + PLOPPAC_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createPLOPPAC(String facility_id,String start_date,String end_date)					
	{ 
		
		Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
		ResultSet rset1 = null;
		Statement stmt1 =  null;
		String prov_Dtls="";
		StringTokenizer prov_Dtls_tkn		= new StringTokenizer(prov_Dtls,"#" );

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

				
				/*The View which is created for this PLOPPACJson purpose*/

				String mapped_fac_id=facility_id;

				stmt =  con.createStatement();
				rset =  stmt.executeQuery("SELECT ext_pk_id  FROM xh_oth_appl_data_skey WHERE table_id = 'SM_FACILITY_PARAM' AND pk_value ='"+facility_id+"' AND application_id = 'SMRP'");
				
				if(rset!=null && rset.next()){
					mapped_fac_id=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				filename       = mapped_fac_id+"_"+from_date.replaceAll("/","")+"_"+to_date.replaceAll("/",""); 
				String refServiceTypeCode="03";
					
				
				/*This query will return the service code for which JSON file need to be generated*/
				
				/*stmt =  con.createStatement();
				rset =  stmt.executeQuery("select EXT_PK_ID from  XH_OTH_APPL_DATA_SKEY WHERE table_id='AM_PATIENT_CLASS' and APPLICATION_ID='SMRP' and PK_VALUE='IP'");
				
				

			
				if(rset!=null && rset.next()){
					refServiceTypeCode=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();
				*/
				

				String sqlQuery		  = "SELECT * FROM MR_PLOP_VW  WHERE trunc(DISCHARGE_DATE_TIME) BETWEEN TO_DATE ('"+start_date+"','dd/mm/yyyy') AND TO_DATE ('"+end_date+"', 'dd/mm/yyyy') + 0.99999 and patient_class ='OP' and FACILITY_CODE='"+facility_id+"' and refServiceSubTypeCode='11' ORDER BY VISIT_ADM_DATE_TIME";

				stmt =  con.createStatement();
				
				System.out.println("sqlQuery-->"+sqlQuery);
				rset =  stmt.executeQuery(sqlQuery);


				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				String fl_name=filename+"_PLPAC";
				
				System.out.println("filename-->"+filename);

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				
				StringBuffer str_head=new StringBuffer("");
				str_head.append("{\"filename\": \""+fl_name+"\",\"refServiceTypeCode\": \""+refServiceTypeCode+"\",\"formType\": \"PL\",\"facilityCode\": \""+mapped_fac_id+"\",");
				str_head.append("\"dischargeFrom\": \""+from_date+"\",\"dischargeTo\": \""+to_date+"\",\"forms\": [");
			

				StringBuffer str_foot=new StringBuffer("");
				
				int i=0;
				String enc_id="";
				 while(rset!=null && rset.next()) 	{  	 // looping each ip encounter

					StringBuffer visit= new StringBuffer("");
					System.out.println("inisde encounter  loop i value-->"+i);
					if( i>0){						
						System.out.println("i value -->"+ i);
						visit.append(",");					
					}
					
					enc_id =checkForNull(rset.getString("REG_NBR"));
					visit.append("{ \"visit\": { \"rn\": \""+enc_id+"\",");
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

					/*StringBuffer admission= new StringBuffer(" \"admission\": {	");
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

					admission.append("],");*/
					
					StringBuffer discharge= new StringBuffer(" \"admission\": {	");

					discharge.append("\"discharge\": { ");
					discharge.append("\"refDischargeTypeCode\": \""+checkForNull(rset.getString("DISPOSITION_TYPE"))+"\" ,");
					discharge.append("\"dischargeDateTime\": \""+checkForNull(rset.getString("DISC_DATE_TIME"))+"\" ,");
					
					discharge.append("\"dischargeToFacility\": \""+checkForNull(rset.getString("Discharge_To_Facility"))+"\" ,");
					discharge.append("\"dischargeOtherFacility\": \""+checkForNull(rset.getString("Discharge_Other_Facility"))+"\" ,");
						
					
					String dec_date_time="";
					String dis_stp_cd="";

					dec_date_time=checkForNull(rset.getString("DECEASED_DATE_TIME"));

					if(dec_date_time.equals("")){
						dis_stp_cd=checkForNull(rset.getString("Discharge_Step_Code"));
					}
					discharge.append("\"refDischargeStepCode\": \""+dis_stp_cd+"\" ,");
					discharge.append("\"refBillingCategoryCode\": \""+checkForNull(rset.getString("Billing_Category_Code"))+"\" ,");
					discharge.append("\"dischargeRemark\": \""+checkForNull(rset.getString("discharge_Remark"))+"\" ,");					
					
					discharge.append("\"deathDateTime\": \""+dec_date_time+"\" ,");
					discharge.append("\"refHealthFundingTypeCode\": \""+checkForNull(rset.getString("Health_Funding_Type_Code"))+"\" ,");
					discharge.append("\"healthFundingNumber\": \""+checkForNull(rset.getString("health_Funding_Number"))+"\" ,");
					
					discharge.append("\"totalCharges\": \""+checkForNull(rset.getString("Total_Charges"))+"\" ,");
					discharge.append("\"refReferralToCode\": \""+checkForNull(rset.getString("ref_Referral_to_code"))+"\" ,");					
					discharge.append("\"refReferralToSubTypeCode\": \""+checkForNull(rset.getString("ref_Referral_to_sub_type_code"))+"\" ,");
					discharge.append("\"wardDateTime\": \""+checkForNull(rset.getString("ward_date_time"))+"\" ,");
					discharge.append("\"refWardDisciplineCode\": \""+checkForNull(rset.getString("ref_ward_discipline_code"))+"\" ");
					
					
					//discharge.append("\"dischargeOfficers\":	[	{	");
					//discharge.append("\"refDischargeOfficerTypeCode\": \""+checkForNull(rset.getString("position_type"))+"\" ,");
					//discharge.append("\"fullName\": \""+checkForNull(rset.getString("practitioner_name"))+"\" ,");
					//discharge.append("\"mmc\": \""+checkForNull(rset.getString("employee_id"))+"\" }	]	}	}	,");
					discharge.append("	}	}	,");
					
					StringBuffer outpatient= new StringBuffer(" \"outpatient\": {	");
					//outpatient.append("\"admissionDate\": \""+checkForNull(rset.getString("VISIT_ADM_DATE_TIME"))+"\" ,");
					outpatient.append("\"refServiceSubTypeCode\": \""+checkForNull(rset.getString("refServiceSubTypeCode"))+"\" ,");					
					outpatient.append("\"refVisitTypeCode\": \""+checkForNull(rset.getString("refVisitTypeCode"))+"\" ,");
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
					outpatient.append("\"refDisciplineCode\": \""+checkForNull(rset.getString("refDisciplineCode"))+"\" ,");
					outpatient.append("\"refSpecialityCode\": \""+checkForNull(rset.getString("refSpecialityCode"))+"\" ,");
					outpatient.append("\"refSubSpecialityCode\": \""+checkForNull(rset.getString("refSubSpecialityCode"))+"\" ,");
					outpatient.append("\"admissionDate\": \""+checkForNull(rset.getString("VISIT_ADM_DATE_TIME"))+"\" ,");
					outpatient.append("\"clinicType\": \""+checkForNull(rset.getString("clinicType"))+"\" ,");
					
					/*StringBuffer emergency= new StringBuffer(" \"emergency\": {	");
					emergency.append("\"refEmergencyCaseCode\": \""+checkForNull(rset.getString("refEmergencyCaseCode"))+"\" ,");
					emergency.append("\"height\": \""+checkForNull(rset.getString("PAT_HEIGHT"))+"\" ,");
					emergency.append("\"weight\": \""+checkForNull(rset.getString("PAT_WEIGHT"))+"\" ,");
					emergency.append("\"attendingDateTime\": \""+checkForNull(rset.getString("attendingDateTime"))+"\" ,");
					emergency.append("\"observationWard\": \""+checkForNull(rset.getString("observationWard"))+"\" ,");
					emergency.append("\"amiThrombolyticTherapyDateTime\": \""+checkForNull(rset.getString("amiThrombolyticTherapyDateTime"))+"\" ,");
					emergency.append("\"psaComplication\": \""+checkForNull(rset.getString("psaComplication"))+"\" ,");
					emergency.append("\"bloodCultureSensitivityDateTime\": \""+checkForNull(rset.getString("bloodCul_Sen_DT_Tm"))+"\" ,");
					emergency.append("\"antibioticGivenDateTime\": \""+checkForNull(rset.getString("antibioticGivenDateTime"))+"\" ,");
					
					String triage_dtls=checkForNull(rset.getString("triage_dtls"));
					System.out.println("triage_dtls"+triage_dtls);
					StringTokenizer triage_tkn		= new StringTokenizer(triage_dtls,"$" );
										
					while (triage_tkn.hasMoreTokens()){
						emergency.append("\"refTriageCode\": \""+triage_tkn.nextToken()+"\" ,");
						System.out.println("--1");
						emergency.append("\"refReTriageCode\": \""+triage_tkn.nextToken()+"\" ,");
						System.out.println("--2");
						emergency.append("\"refSubReTriageCode\": \""+triage_tkn.nextToken()+"\" ,");
						System.out.println("--3");
					}
					
					emergency.append("\"refOSCCCaseCode\": \""+checkForNull(rset.getString("refOSCCCaseCode"))+"\" ,");
					emergency.append("\"refOSCCCaseTypeCode\": \""+checkForNull(rset.getString("refOSCCCaseTypeCode"))+"\" ,");
					emergency.append("\"refOSCCCaseSubTypeCode\": \""+checkForNull(rset.getString("refOSCCCaseSubTypeCode"))+"\" ,");
					emergency.append("\"refAbuserCode\": \""+checkForNull(rset.getString("refAbuserCode"))+"\" ,");
					emergency.append("\"refAbuserSubCode\": \""+checkForNull(rset.getString("refAbuserSubCode"))+"\" ,");
					emergency.append("\"refLocationCode\": \""+checkForNull(rset.getString("refLocationCode"))+"\" ");
					emergency.append("},");*/
					
					StringBuffer diagnosis= new StringBuffer(" \"diagnosisItems\": [	");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("DIAG_DETAILS")),"$" );
					int out_token=temp_tkn.countTokens();
					int j=0;
					StringBuffer diagnosis_provider=new StringBuffer("");
					while (temp_tkn.hasMoreTokens()){
							diagnosis.append("{");
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
							j	++;
							while (temp_tkn_inner.hasMoreTokens()){
								
								diagnosis.append("\"refDiagnosisItemTypeCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
								String term_code=temp_tkn_inner.nextToken();
								String[] tokens=term_code.split("@"); 
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
								diagnosis.append("\"refIcd10Main\": \""+tokens[0]+"\" ");
								diagnosis_provider.append(tokens[1]+",");
								
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
										tokens=sup_code.split("@"); 
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
									diagnosis.append("\"refIcd10Main\": \""+tokens[0]+"\" ");
									diagnosis_provider.append(tokens[1]+",");
									//diagnosis.append("}],");
								}else{
									System.out.println(support_dtls);
									temp_support_tkn		= new StringTokenizer(support_dtls,"^" );
									
									while (temp_support_tkn.hasMoreTokens()){
										
										sup_code=temp_support_tkn.nextToken();
										tokens=sup_code.split("@"); 
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
											diagnosis.append("\"refIcd10Asterisk\": \""+tokens[0]+"\" ");
										}else if (sup_type.equals("E")){
											diagnosis.append("\"refIcd10Supplementary\": \""+tokens[0]+"\" ");
										}else{
											diagnosis.append("\"refIcd10Zcode\": \""+tokens[0]+"\" ");
										}
										diagnosis_provider.append(tokens[1]+",");
									
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

					diagnosis.append(" ]	,	");
					
					System.out.println("diagnosis_provider"+diagnosis_provider);
					
					StringBuffer diagnosis_provider_deatils=new StringBuffer(" \"diagnosisProviders\": [	");
					
					if (diagnosis_provider.length()>0){
					
						stmt1 =  con.createStatement();
						rset1 =  stmt1.executeQuery("select MR_PROV_DTLS('"+diagnosis_provider.toString()+"') prov_dtls from dual");
						
						prov_Dtls="";
						
						if(rset1!=null && rset1.next()){
							prov_Dtls=rset1.getString("prov_dtls");
						}
						
						
						
						prov_Dtls_tkn		= new StringTokenizer(prov_Dtls,"#" );
						
						
						int kk=0;
								
						while (prov_Dtls_tkn.hasMoreTokens()){
							
							
							StringTokenizer prov_Dtls_tkn_dtls		= new StringTokenizer(prov_Dtls_tkn.nextToken(),"@" );
							while (prov_Dtls_tkn_dtls.hasMoreTokens()){
								
								if (kk >0){
									diagnosis_provider_deatils.append(",");
								}
									
								diagnosis_provider_deatils.append("{\"fullName\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" ,");
								System.out.println("--1");
								diagnosis_provider_deatils.append("\"refDesignationCode\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" ,");
								System.out.println("--2");
								diagnosis_provider_deatils.append("\"regNumber\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" }");
								System.out.println("--3");
								
								
							}
							kk++;
						}
					}
					
					diagnosis_provider_deatils.append("],");
					System.out.println("line 660");
					
						
					
					StringBuffer procedure_provider=new StringBuffer("");

					StringBuffer ot_procedures= new StringBuffer(" \"procedures\": [	");
					temp_tkn=null;
					temp_tkn		= new StringTokenizer(checkForNull(rset.getString("OT_PROC_DTLS")),"@" );
					System.out.println("val-->"+ rset.getString("OT_PROC_DTLS"));
					out_token=temp_tkn.countTokens();
					j=0;
					String main_proc="";
					String ordr_ctlg="";
					StringBuffer ordr_ctlg_lst=new StringBuffer("");
					
					int jk=0;
					
					while (temp_tkn.hasMoreTokens()){
							StringTokenizer temp_tkn_inner		= new StringTokenizer(temp_tkn.nextToken(),"~" );
							j	++;
							while (temp_tkn_inner.hasMoreTokens()){
								ordr_ctlg=temp_tkn_inner.nextToken();
								main_proc=temp_tkn_inner.nextToken();
								if(j>1){
									main_proc="false";
								}else{
									main_proc="true";
								}
								
								if(! ordr_ctlg_lst.toString().contains(ordr_ctlg)){
									ordr_ctlg_lst.append(ordr_ctlg);
									//ot_procedures.append("{\"isMainProcedure\": \""+main_proc+"\" ,");
									ot_procedures.append("{\"isMainProcedure\": "+main_proc+" ,");
									ot_procedures.append("\"description\": \""+temp_tkn_inner.nextToken()+"\" ,");
									ot_procedures.append("\"surgicalType\": \""+temp_tkn_inner.nextToken()+"\" ,");
									ot_procedures.append("\"refSurgicalClassCode\": \""+temp_tkn_inner.nextToken()+"\" ,");
									ot_procedures.append("\"refIcd9MainCode\": \""+temp_tkn_inner.nextToken()+"\" }");
									procedure_provider.append(temp_tkn_inner.nextToken()+",");
									//ot_procedures.append("\"diag_code_scheme\": \""+temp_tkn_inner.nextToken()+"\" ,");
									//ot_procedures.append("\"class_code\": \""+temp_tkn_inner.nextToken()+"\" ,");
									//ot_procedures.append("\"surgery_type\": \""+temp_tkn_inner.nextToken()+"\" }	");
									jk=1;
									
									//System.out.println("jk"+jk);
									//System.out.println("out_token"+out_token);
									
								}else{
									temp_tkn_inner.nextToken();
									temp_tkn_inner.nextToken();
									temp_tkn_inner.nextToken();
									temp_tkn_inner.nextToken();
									temp_tkn_inner.nextToken();
									jk=0;
								}

								if(j  <out_token){
									ot_procedures.append(",");
								}
								
							}
					}
					
					if (j>0){
						//System.out.println("693-->"+ot_procedures.toString());
						//System.out.println("694-->"+ot_procedures.charAt(ot_procedures.length()-1));
						if(ot_procedures.charAt(ot_procedures.length()-1)==','){
							ot_procedures.delete(ot_procedures.length()-1, ot_procedures.length());
						}
						//System.out.println("695-->"+ot_procedures.toString());
						
					}
					ot_procedures.append(" ],");
					
					System.out.println("procedure_provider"+procedure_provider);
					
					
					StringBuffer procedure_provider_deatils=new StringBuffer(" \"procedureProviders\": [	");
					
					if (procedure_provider.length()>0){
					
						stmt1 =  con.createStatement();
						rset1 =  stmt1.executeQuery("select MR_PROV_DTLS('"+procedure_provider.toString()+"') prov_dtls from dual");
						
								
						prov_Dtls="";
						
						if(rset1!=null && rset1.next()){
							prov_Dtls=rset1.getString("prov_dtls");
						}
						
						
						
						prov_Dtls_tkn		= new StringTokenizer(prov_Dtls,"#" );
						
						
						int jkk=0;					
						while (prov_Dtls_tkn.hasMoreTokens()){
							
							
							StringTokenizer prov_Dtls_tkn_dtls		= new StringTokenizer(prov_Dtls_tkn.nextToken(),"@" );
							while (prov_Dtls_tkn_dtls.hasMoreTokens()){
								
								if(jkk>0){
									procedure_provider_deatils.append(",");
								}
									
								procedure_provider_deatils.append("{\"fullName\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" ,");
								System.out.println("--1");
								procedure_provider_deatils.append("\"refDesignationCode\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" ,");
								System.out.println("--2");
								procedure_provider_deatils.append("\"regNumber\": \""+prov_Dtls_tkn_dtls.nextToken()+"\" }");
								System.out.println("--3");
								
							}
							jkk++;
						}
					}
					procedure_provider_deatils.append("] }	}");
					System.out.println("line 743");
					

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
						str_head.append(discharge.toString());
						str_head.append(outpatient.toString());
						//str_head.append(emergency.toString());
						str_head.append(diagnosis.toString());
						str_head.append(diagnosis_provider_deatils.toString());
						str_head.append(ot_procedures.toString());
						str_head.append(procedure_provider_deatils.toString());
					
					//str_head.append(ot_cancel_procedures.toString());
						
					

					i++;
				 }// while loop for encounter 
				 str_foot.append(" ]	}");

				str_head.append(str_foot.toString());
				filename=filename+"_PLPAC.json";

				if(i>0){
				
					try{
						
						//System.out.println("dir-->"+dir);
						//FileWriter file = new FileWriter(dir+"\\"+filename+"_PLOPPAC.json");/*File is Created with Json object as data in specific folder*/
						System.out.println("<-- PLOPPAC-->"+str_head.toString());
						//System.out.println("filename-->"+filename);
						//System.out.println("json content-->"+str_head.toString());
						dir=dir+filename;
						System.out.println("dir-->"+dir);
						File PLOPPACjson = new File (dir);
						FileWriter file = new FileWriter(PLOPPACjson);/*File is Created with Json object as data in specific folder*/
						//System.out.println("PLOPPACjson.getPath()-->"+PLOPPACjson.getPath());
						//System.out.println("PLOPPACjson.getAbsolutePath()-->"+PLOPPACjson.getAbsolutePath());
						//System.out.println("PLOPPACjson.getName()-->"+PLOPPACjson.getName());

						
						//str_head.append(str_foot.toString());
						file.write(str_head.toString());
						fileCreated="1";
						//System.out.println("fileCreated@746-->"+fileCreated);
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PLOPPAC",PLOPPACjson.getAbsolutePath());
						file.flush();
						file.close();

						if(dir.equals("")){
							fileCreated="2";
							 System.out.println("Error while file obj  PLOPPAC generation. No dir path-->"+filename);
							 smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PLOPPAC","File creation path is not defined");
						}

					} catch (IOException e) {
						fileCreated="2";
						System.err.println("Exception in createPLOPPAC function Inside try:"+e.toString());
						System.out.println("Error while file obj  PLOPPAC generation-->"+filename+"-->"+e.toString());
						smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PLOPPAC","IO Error. Unable to create File for PLOPPAC generation");
						e.printStackTrace();
					}
				}else{ // no data for file generation
					System.out.println("No data for PLOPPAC generation-->"+filename);
					fileCreated="0";
					smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PLOPPAC","No data for PLOPPAC generation");
				}
				
			}	 //check in function control				
		
		}catch (Exception e) {
			  System.err.println("Exception in createPLOPPAC function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,filename,start_date,"PLOPPAC",e.toString());
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
	


public static class JobSchedulePLOPPAC extends TimerTask {

 /*The main method will be invoked when Server is Started*/
  public  void main (String... arguments ) {
    TimerTask JobSchedulePLOPPAC = new JobSchedulePLOPPAC();
   
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
		rset =  stmt.executeQuery("select nvl(to_char(LAG_TIME,'HH24'),'00') hr,nvl(to_char(LAG_TIME,'mi'),'00') min from MR_SMRP_CONFIG where SMRP_ID='PLOPPAC'");
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
    timer.scheduleAtFixedRate(JobSchedulePLOPPAC, getTomorrowMorning12am(hr,mn), fONCE_PER_DAY);
    //timer.scheduleAtFixedRate(JobSchedulePLOPPAC, getTomorrowMorning12am(), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GeneratePLOPPAC Gjson= new GeneratePLOPPAC();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		/*for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file*/
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'	");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createPLOPPAC(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobSchedulePLOPPAC Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	  private final static long fONCE_PER_DAY = 1000*60*60*24;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 00;
	  private final static int fZERO_MINUTES = 20; 

	/*The function will retutn the time at which the process has to be run*/
	  //private  Date getTomorrowMorning12am(){
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