/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOA.BookAppointment.* ;
import eOA.AppointmentDetails.* ;
import com.ehis.util.*; 
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;

public class BookAppointmentServlet extends javax.servlet.http.HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException{
		PrintWriter out =null;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		try{
			out = res.getWriter();
			String operation = req.getParameter("function_name");
			// code changed by Vedesh A D for Edge Conversion
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callBookAppointmentHTML() { ");
			if ( operation.equals("insert")){
				insertBookAppointment(req,res);
			}else if ( operation.equals("Link")){
				linkSecAppointment(req,res);
			}else if (operation.equals("GROUPAPPT")){
				insertGroupAppointment(req,res);
			}
			
			out.println("} callBookAppointmentHTML();</script><body></body></html>");
		}catch (Exception e)	{
			//out.println("ab"+e.toString());
			e.printStackTrace();
		}finally{
		}
	}
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		PrintWriter out =null;
		try	{
			out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}catch(Exception e)	{
			//out.println("118 era="+e);
			e.printStackTrace();
		}
	}
	private  void insertBookAppointment(HttpServletRequest req,HttpServletResponse res){
		
		PrintWriter out =null;
		java.util.Properties p =null;
		HttpSession session =null;
		String facilityId =null;
		String client_ip_address =null;
		String addedById ="";
		String locale="";
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String cliniccode ="";
		String practitionerid  ="";	
		String apptdate  ="";
		String appttime ="";
		String apptslabfmtime ="";
		String apptslabtotime ="";
		String patientid ="";
		String prefix ="";
		String firstname ="";
		String secondname ="";
		String thirdname ="";
		String familyname ="";
		String suffix ="";
		String patientname ="";
		String gender ="";
		String dateofbirth ="";
		String restelno=" ";
		String othtelno=" ";
		String nationalidno ="";
		String altid1no ="";
		String altid1typ ="";
		String altid1expdt ="";
		String altid2no ="";
		String altid2typ ="";
		String altid2expdt ="";
		String altid3no ="";
		String altid3typ ="";
		String altid3expdt ="";
		String altid4no ="";
		String altid4typ ="";
		String altid4expdt ="";
		String Othaltid1 ="";
		String Othaltid1typ ="";
		String ethnicGrp ="";
		String receivingDtTme ="";
		String prefdate1 ="";
		String prefenddate1 ="";
		String resaddrl1=" ";
		String resaddrl2=" ";
		String resaddrl3=" ";
		String resaddrl4=" ";
		String postalcode=" ";
		String countrycode=" ";
		String apptcode ="";
		String pat_cat="";
		String nationality_code="";
		String alcn_criteria="";
		String no_slots="";
		String apptcode1="";
		String ref_priority="";
		String visitind="";
		String overbooked ="";
		String refsourcetype ="";
		String refcode ="";
		String referral_id_old="";
		String emailid ="";
		String contactreason ="";
		String contactmode ="";
		String apptrem ="";
		String contdata=" ";	
		String timetabletype ="";
		String team_id="";		
		String inpatient_yn="";
		String vtemp_pat_id="";
		String forced="";
		String global="";
		String birthPlace="";
		String birthPlace_desc="";
		String or_catalogue_code="";
		String ordPractId="";
		String residency="";
		String status="";
		String ethnicSbGrp="";
		String res_addr1="";
		String res_addr2="";
		String res_addr3="";
		String res_addr4="";
		String res_town="";
		String res_area="";
		String res_postal="";
		String res_region="";
		String res_country="";
		String mail_addr1="";
		String mail_addr2="";
		String mail_addr3="";
		String mail_addr4="";
		String mail_town="";
		String mail_area="";
		String mail_postal="";
		String mail_region="";
		String mail_country="";
		String recurringDTTM="";
		String ApptStatus="";
		String res_class="";
		String clinic_type="";
		String speciality_code="";
		String pref_date="";
		String priority="";
		String from_wait_list="";
		String waitListNo="";
		String order_catalog_criteria="";
		String pre_admit_order_catalog_code="";
		String or_order_date="";
		String recurringdays="";	
		String order_id="";
		String order_line_num="";
		String order_catalog_code="";
		String req_id="";
		String entitlement_by_pat_cat_yn="";	
		String patient_name_local_lang ="";
		String name_prefix_oth_lang ="";
		String first_name_oth_lang ="";
		String second_name_oth_lang ="";
		String third_name_oth_lang ="";
		String name_suffix_oth_lang ="";
		String family_name_oth_lang ="";		
		String episode_type= "";
		String Function_id= "";
		String capture_fin_dtls_yn= "";
		String billing_group= "";
		String bl_operational= "";
		String apptrefnum="";
		String sel_service_code="";
		String from_facility_id="";
		String from_encounter_id="";
		String patient_name_long="";
		String patient_name_loc_lang_long="";
		java.util.ArrayList sec_reourses=null;
		String canldapptrefno="";
		String upt_contact_dtls_mp_yn="";//added changes for HSA-CRF-0226 [IN:050599]
		String upd_pat_dtls_referral_yn="";//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
		/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
		String altAddrLine1		= "";
		String altAddrLine2		= "";
		String altAddrLine3		= "";
		String altAddrLine4		= "";
		String altAreaCode		= "";
		String altTownCode		= "";
		String altPostalCode	= "";
		String altRegionCode	= "";
		String altCountryCode	= "";
		String ccNxtOfKinNo = ""; //Added by Ajay Hatwate for ML-MMOH-CRF-1930
		String nxtOfKinNo = "";//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		String patCountryCode= "";//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		String patTelCode= "";//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		/*End*/
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		try{
			out = res.getWriter();
			session = req.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			addedById 			= p.getProperty( "login_user" ) ;
			locale = p.getProperty("LOCALE");

			String rule_based_tr = checkForNull(req.getParameter("rule_based_tr"),"N");
			String language_id = checkForNull(req.getParameter("language_id"));
			String pract_override_reason = checkForNull(req.getParameter("pract_override_reason"));
			String alcn_category=req.getParameter("pat_cat")==null?"":req.getParameter("pat_cat");	
			String patient_cat_code = checkForNull(req.getParameter("pat_cat_code"));			
			String term_set_id = checkForNull(req.getParameter("term_set_id"));
			String term_code = checkForNull(req.getParameter("linking_code"));
			con = ConnectionManager.getConnection(req);				 
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc = eCommon.Common.CommonBean.isSiteSpecificforBiometric(con);
			if(smartCardFunc.equals("01")) {
			biometric_reason = (String) session.getValue( "biometric_reason" ) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends	
			sel_service_code=req.getParameter("sel_service_code");
			patCountryCode=checkForNull(req.getParameter("patCountryCode"));//Added by Ajay Hatwate for ML-MMOH-CRF-1930
			patTelCode=checkForNull(req.getParameter("patTelCode"));
			
			if(sel_service_code==null) sel_service_code="";
			String from_page=req.getParameter("from_page");
			if(from_page==null) from_page="";
			no_slots= req.getParameter("no_slots");
			pat_cat = req.getParameter("pat_cat");
			if(pat_cat==null) pat_cat="";
			String book_apt_acr_cat_yn=req.getParameter("book_apt_acr_cat_yn")==null?"N":req.getParameter("book_apt_acr_cat_yn");
			nationality_code = req.getParameter("nationality_code1");
			if(nationality_code==null) nationality_code="";
			alcn_criteria = req.getParameter("alcn_criteria");
			if(alcn_criteria==null) alcn_criteria="";
			ref_priority= req.getParameter("ref_priority");
			if(ref_priority==null) ref_priority="";
			team_id= req.getParameter("team_id");
			if(team_id==null) team_id="";
			inpatient_yn= req.getParameter("inpatient_yn");
			if(inpatient_yn==null) inpatient_yn="";
			cliniccode = req.getParameter("clinic_code");
			if(cliniccode ==null) cliniccode="";
			practitionerid=req.getParameter("practitioner_id");
			if(practitionerid == null) practitionerid="";
			order_id=req.getParameter("order_id");
			if(order_id ==null || order_id.equals("null")) order_id="";
			order_line_num=req.getParameter("order_line_num");
			if(order_line_num ==null || order_line_num.equals("null")) order_line_num="";
			order_catalog_code=req.getParameter("order_catalog_code");
			if(order_catalog_code ==null || order_catalog_code ==("null") ||  order_catalog_code.equals("null"))
			order_catalog_code="";
			appttime=req.getParameter("From_timeval");
			if(appttime == null || appttime.equals("")) appttime="00:00";
			apptslabfmtime=req.getParameter("From_timeval");
			if(apptslabfmtime == null || apptslabfmtime.equals("")) apptslabfmtime="00:00";
			apptslabtotime=req.getParameter("To_timeval");
			if(apptslabtotime == null || apptslabtotime.equals("") ) apptslabtotime="00:00";
			apptdate=req.getParameter("appt_date");
			if(apptdate == null) apptdate="";
			patientid=req.getParameter("patient_id");
			if(patientid == null) patientid="";
			vtemp_pat_id=patientid;
			prefix=req.getParameter("name_prefix");
			if(prefix == null) prefix="";
			firstname=req.getParameter("first_name");
			if(firstname == null) firstname="";
			secondname=req.getParameter("second_name");
			if(secondname == null) secondname="";
			thirdname=req.getParameter("third_name");
			if(thirdname == null) thirdname="";
			familyname=req.getParameter("family_name");
			if(familyname == null) familyname="";
			suffix=req.getParameter("name_suffix");
			if(suffix == null) suffix="";
			patientname=req.getParameter("patient_name");
			if(patientname !=null && patientname.length()>100){
				patientname=patientname.substring(0,100);
			}

			patient_name_long=checkForNull(req.getParameter("patient_name_long"));
			if(patient_name_long !=null && patient_name_long.length()>300){
				patient_name_long=patient_name_long.substring(0,300);
			}

			patient_name_loc_lang_long=checkForNull(req.getParameter("patient_name_loc_lang_long"));
			if(patient_name_loc_lang_long !=null && patient_name_loc_lang_long.length()>300){
				patient_name_loc_lang_long=patient_name_loc_lang_long.substring(0,300);
			}

			gender=req.getParameter("gen");
			dateofbirth=req.getParameter("date_of_birth");
			if(dateofbirth == null) dateofbirth="";
			nationalidno=req.getParameter("national_id_no");
			if(nationalidno == null) nationalidno="";
			altid1no=req.getParameter("alt_id1_no");
			if(altid1no == null) altid1no="";	
			altid1typ=req.getParameter("alt_id1_type");
			if(altid1typ == null) altid1typ="";
			altid1expdt=req.getParameter("alt_id1_exp_date");
			if(altid1expdt == null) altid1expdt="N";
			altid2no=req.getParameter("alt_id2_no");
			if(altid2no == null) altid2no="";	
			altid2typ=req.getParameter("alt_id2_type");
			if(altid2typ == null) altid2typ="";
			altid2expdt=req.getParameter("alt_id2_exp_date");
			if(altid2expdt == null) altid2expdt="N";
			altid3no=req.getParameter("alt_id3_no");
			if(altid3no == null) altid3no="";	
			altid3typ=req.getParameter("alt_id3_type");
			if(altid3typ == null) altid3typ="";
			altid3expdt=req.getParameter("alt_id3_exp_date");
			if(altid3expdt == null) altid3expdt="N";
			altid4no=req.getParameter("alt_id4_no");
			if(altid4no == null) altid4no="";	
			altid4typ=req.getParameter("alt_id4_type");
			if(altid4typ == null) altid4typ="";
			altid4expdt=req.getParameter("alt_id4_exp_date");
			if(altid4expdt == null) altid4expdt="N";	
			Othaltid1=req.getParameter("other_alt_Id"); 
			if(Othaltid1 == null) Othaltid1="";
			Othaltid1typ=req.getParameter("other_alt_type");
			if(Othaltid1typ == null) Othaltid1typ="";
			receivingDtTme=req.getParameter("rec_date");
			if(receivingDtTme == null) receivingDtTme="N";				
			prefdate1=req.getParameter("prefdate1");
			if(prefdate1 == null) prefdate1="";
			prefenddate1=req.getParameter("prefenddate1");
			if(prefenddate1 == null) prefenddate1=prefdate1;
			forced=req.getParameter("Forced");
			global=req.getParameter("Global");
			birthPlace=req.getParameter("Birth_place_code");
			if(birthPlace == null) birthPlace="";
			birthPlace_desc=req.getParameter("place_of_birth");
			if(birthPlace_desc == null) birthPlace_desc="";
			residency=req.getParameter("citizen_yn");
			if(residency == null) residency=residency;
			status=req.getParameter("legal_yn"); 
			if(status == null) status="Y";  //condition added for this incident[IN34969]
			
			ethnicGrp=req.getParameter("ethnic_group");
			if(ethnicGrp == null) ethnicGrp="";
			ethnicSbGrp=req.getParameter("race_code");
			if(ethnicSbGrp == null) ethnicSbGrp="";
			recurringDTTM=req.getParameter("recurringDTTM");
			if(recurringDTTM == null) recurringDTTM="";
			ApptStatus=req.getParameter("Appt_status");
			
			if(ApptStatus == null) ApptStatus="";
			apptrefnum=req.getParameter("apptrefno");
			if(apptrefnum == null) apptrefnum="";
			String clinic_name=req.getParameter("clinic_name");
			if(clinic_name == null) clinic_name="";
			String sec_sel=req.getParameter("sec_sel222");
			if(sec_sel==null) sec_sel="";
			res_class=req.getParameter("res_class");
			if(res_class==null) res_class="P";				
			clinic_type=req.getParameter("clinic_type");
			if(clinic_type==null) clinic_type="C";
			speciality_code=req.getParameter("speciality_code");
			if(speciality_code==null) speciality_code="";
			pref_date=req.getParameter("pref_date");
			if(pref_date==null) pref_date="";
			priority=req.getParameter("priorty");
			if(priority==null) priority="";
			from_wait_list=req.getParameter("from_wait_list");
			if(from_wait_list==null) from_wait_list="N";
			waitListNo=req.getParameter("waitListNo");
			if(waitListNo==null) waitListNo="";
			order_catalog_criteria=req.getParameter("order_catalog_criteria");
			if(order_catalog_criteria==null) order_catalog_criteria="";
			pre_admit_order_catalog_code=req.getParameter("pre_admit_order_catalog_code");
			if(pre_admit_order_catalog_code==null) pre_admit_order_catalog_code="";
			or_order_date=req.getParameter("or_order_date");
			if(or_order_date==null) or_order_date="";
			recurringdays=req.getParameter("recurringdays");
			if(recurringdays==null) recurringdays="";
			or_catalogue_code=req.getParameter("or_catalogue_code");
			if(or_catalogue_code ==null || or_catalogue_code ==("null") ||  or_catalogue_code.equals("null")) or_catalogue_code="";
			req_id=req.getParameter("req_id");
			if(req_id ==null) req_id="";
			name_prefix_oth_lang =req.getParameter("name_prefix_oth_lang");
			if(name_prefix_oth_lang ==null) name_prefix_oth_lang="";
			first_name_oth_lang  =req.getParameter("first_name_oth_lang");
			if(first_name_oth_lang ==null) first_name_oth_lang="";
			second_name_oth_lang =req.getParameter("second_name_oth_lang");
			if(second_name_oth_lang ==null) second_name_oth_lang="";
			third_name_oth_lang  =req.getParameter("third_name_oth_lang");
			if(third_name_oth_lang ==null) third_name_oth_lang="";
			family_name_oth_lang =req.getParameter("family_name_oth_lang");
			if(family_name_oth_lang ==null) family_name_oth_lang="";
			name_suffix_oth_lang =req.getParameter("name_suffix_oth_lang");
			if(name_suffix_oth_lang ==null) name_suffix_oth_lang="";
			patient_name_local_lang=req.getParameter("patient_name_local_lang");
			if(patient_name_local_lang ==null) patient_name_local_lang="";
			if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
				patient_name_local_lang=patient_name_local_lang.substring(0,100);
			}
			String patient_name_local_lang1=req.getParameter("patient_name_local_lang1");
			if(patient_name_local_lang1 ==null) patient_name_local_lang1="";
			entitlement_by_pat_cat_yn=req.getParameter("entitlement_by_pat_cat_yn");
			if(entitlement_by_pat_cat_yn==null) entitlement_by_pat_cat_yn="N";
			apptcode1=req.getParameter("visit_type_short_desc");
			from_facility_id=req.getParameter("from_facility_id");
			from_encounter_id=req.getParameter("from_encounter_id");
			String send_email_yn=req.getParameter("send_email_yn");
			String or_install_yn=req.getParameter("or_install_yn")==null?"N":req.getParameter("or_install_yn");
			String slot_appt_ctrl=req.getParameter("slot_appt_ctrl")==null?"":req.getParameter("slot_appt_ctrl");
			ordPractId=req.getParameter("ordPractId")==null?"":req.getParameter("ordPractId");
			if(send_email_yn == null) send_email_yn="N";			
			if(altid1expdt!="" && altid1expdt!="N" )
			altid1expdt=DateUtils.convertDate(altid1expdt,"DMY",locale,"en");
			if(altid2expdt!="" && altid2expdt!="N" )
			altid2expdt=DateUtils.convertDate(altid2expdt,"DMY",locale,"en");
			if(altid3expdt!="" && altid3expdt!="N" )
			altid3expdt=DateUtils.convertDate(altid3expdt,"DMY",locale,"en");
			if(altid4expdt!="" && altid4expdt!="N" )
			altid4expdt=DateUtils.convertDate(altid4expdt,"DMY",locale,"en");
			dateofbirth=DateUtils.convertDate(dateofbirth,"DMY",locale,"en");
			pref_date=DateUtils.convertDate(pref_date,"DMY",locale,"en");
			receivingDtTme=DateUtils.convertDate(receivingDtTme,"DMYHM",locale,"en");
			HashMap patInstructionsMap=(java.util.HashMap)session.getAttribute("patInstructionsMap");
			HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
			//session.removeAttribute("patInstructionsMap");
			//session.removeAttribute("prcInstructionMap");
			String patInsSelectYN=req.getParameter("patInsSelectYN");
			String procInsSelectYN=req.getParameter("procInsSelectYN");
			if(patInsSelectYN.equals("N") && patInstructionsMap!=null){
				//patInstructionsMap.clear();
			}
			if(procInsSelectYN.equals("N") && prcInstructionMap!=null){
				//prcInstructionMap.clear();
			}
			sec_reourses=new java.util.ArrayList();
			String trans_exceed_reason_code = checkForNull(req.getParameter("trans_exceed_reason_code"));
			if(from_page.equals("")){
				StringTokenizer sec_sel_st1 = new StringTokenizer(sec_sel,"@");
				StringTokenizer sec_sel_st2=null;
				while(sec_sel_st1.hasMoreTokens()){
					String sec_sel_str1=sec_sel_st1.nextToken();
					sec_sel_st2 = new StringTokenizer(sec_sel_str1,",");
					while(sec_sel_st2.hasMoreTokens()){
						String tmp=sec_sel_st2.nextToken();
						if(tmp.equals("*"))
							tmp="";
						sec_reourses.add(tmp);
					}			
				}
			}
			if(from_page.equals("")){
				StringTokenizer st1 = new StringTokenizer(apptcode1,"~");
				while(st1.hasMoreTokens()){
					apptcode=st1.nextToken();
					visitind=st1.nextToken();
				}
			}
			overbooked=req.getParameter("overbooked");
			refsourcetype=req.getParameter("source_type");
			if(refsourcetype == null) refsourcetype="";
			refcode=req.getParameter("source");
			if(refcode == null) refcode="";
			referral_id_old=req.getParameter("referral_id_old");
			if(referral_id_old == null) referral_id_old="";//			
			contactreason=req.getParameter("reason_for_contact");
			contactmode=req.getParameter("mode");
			if(contactmode == null) contactmode="";
			apptrem=req.getParameter("remarks");
			if(apptrem == null) apptrem="";
			restelno=req.getParameter("contact1_no");
			if(restelno == null) restelno="";
			othtelno=req.getParameter("contact2_no");
			if(othtelno == null) othtelno="";
			emailid=req.getParameter("email");
			if(emailid == null) emailid="";
			timetabletype=req.getParameter("time_table_type");
			res_addr1=req.getParameter("addr_line1");
			if(res_addr1 == null) res_addr1="";
			res_addr2=req.getParameter("addr_line2");
			if(res_addr2 == null) res_addr2="";
			res_addr3=req.getParameter("addr_line3");
			if(res_addr3 == null) res_addr3="";
			res_addr4=req.getParameter("addr_line4");
			if(res_addr4 == null) res_addr4="";
			res_town=req.getParameter("res_town_code");
			if(res_town == null) res_town="";
			res_area=req.getParameter("res_area_code");
			if(res_area == null) res_area="";
			res_postal=req.getParameter("postal_code");
			if(res_postal == null) res_postal="";
			res_region=req.getParameter("region_code");
			if(res_region == null) res_region="";
			res_country=req.getParameter("country_code");
			if(res_country == null) res_country="";
			mail_addr1=req.getParameter("mail_addr_line1");
			if(mail_addr1 == null) mail_addr1="";
			mail_addr2=req.getParameter("mail_addr_line2");
			if(mail_addr2 == null) mail_addr2="";
			mail_addr3=req.getParameter("mail_addr_line3");
			if(mail_addr3 == null) mail_addr3="";
			mail_addr4=req.getParameter("mail_addr_line4");
			if(mail_addr4 == null) mail_addr4="";
			mail_town=req.getParameter("mail_res_town_code");
			if(mail_town == null || mail_town.equals("null") ) mail_town="";
			mail_area=req.getParameter("mail_res_area_code");
			if(mail_area == null || mail_area.equals("null")) mail_area="";
			mail_postal=req.getParameter("mail_postal_code");
			if(mail_postal == null) mail_postal="";
			mail_region=req.getParameter("mail_region_code");
			if(mail_region == null) mail_region="";
			mail_country=req.getParameter("mail_country_code");
			if(mail_country == null) mail_country="";					
			episode_type=req.getParameter("episode_type");
			if(episode_type == null) episode_type="";
			Function_id=req.getParameter("Function_id");
			if(Function_id == null) Function_id="";
			capture_fin_dtls_yn=req.getParameter("capture_fin_dtls_yn");
			if(capture_fin_dtls_yn == null) capture_fin_dtls_yn="";
			billing_group=req.getParameter("billing_group");
			if(billing_group == null) billing_group="";
			bl_operational=req.getParameter("bl_operational");
			if(bl_operational == null) bl_operational="";
			contdata=req.getParameter("contactvals");
			canldapptrefno=req.getParameter("canldapptrefno")==null?"":req.getParameter("canldapptrefno");
			String rd_appt_yn=req.getParameter("rd_appt_yn")==null?"N":req.getParameter("rd_appt_yn");
			String multi_speciality_yn=req.getParameter("multi_speciality_yn")==null?"N":req.getParameter("multi_speciality_yn");//Added for the CRF Bru-HIMS-CRF 198
			String patCnclCount=req.getParameter("patCnclCount")==null?"":req.getParameter("patCnclCount");//changes for BruHIMS-CRF 169
			upt_contact_dtls_mp_yn=req.getParameter("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599]
			upd_pat_dtls_referral_yn=req.getParameter("upd_pat_dtls_referral_yn");//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			altAddrLine1	= checkForNull(req.getParameter("alt_addr_line1"));
			altAddrLine2	= checkForNull(req.getParameter("alt_addr_line2"));
			altAddrLine3	= checkForNull(req.getParameter("alt_addr_line3"));
			altAddrLine4	= checkForNull(req.getParameter("alt_addr_line4"));
			altAreaCode		= checkForNull(req.getParameter("alt_area_code"));
			altTownCode		= checkForNull(req.getParameter("alt_town_code"));
			altPostalCode	= checkForNull(req.getParameter("alt_postal_code"));
			altRegionCode	= checkForNull(req.getParameter("alt_region_code"));
			altCountryCode	= checkForNull(req.getParameter("alt_country_code"));
			/*End*/
			//ML-MMOH-CRF-1930
			nxtOfKinNo = checkForNull(req.getParameter("txtNxtOfKin"));
			ccNxtOfKinNo = checkForNull(req.getParameter("teleCodeHidden"));
			resaddrl1="";
			resaddrl1="";
			resaddrl2="";
			resaddrl3="";
			resaddrl4="";
			postalcode="";
			if(contdata == null) contdata="";
			if(contdata != " " || contdata != ""){
				contdata=java.net.URLDecoder.decode(contdata);
				StringTokenizer st = new StringTokenizer(contdata,"^");
				if (st.countTokens()>0){
					if (st.hasMoreTokens())
						resaddrl1=st.nextToken();
					if (st.hasMoreTokens())
						resaddrl2=st.nextToken();
					if (st.hasMoreTokens())
						resaddrl3=st.nextToken();
					if (st.hasMoreTokens())
						resaddrl4=st.nextToken();
					if (st.hasMoreTokens())
						postalcode=st.nextToken();
				}
				if(resaddrl1.equals("||"))
					  resaddrl1 = "";
				if(resaddrl2.equals("||"))
					  resaddrl2 = "";
				if(resaddrl3.equals("||"))
					  resaddrl3 = "";
				if(resaddrl4.equals("||"))
					  resaddrl4 = "";
				if(postalcode.equals("||"))
					  postalcode = "";
		
			}else{
				resaddrl1="";
				resaddrl1="";
				resaddrl2="";
				resaddrl3="";
				resaddrl4="";
				postalcode="";
			}
			String status_MP="";
			String addedFacilityId=facilityId;
			String pat_class="";
			pat_class="OP";
			if(entitlement_by_pat_cat_yn.equals("Y") &&  !patientid.equals("")){		
				pstmt=con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,?,?,?,?,?,?,'') from dual");
				pstmt.setString(1,patientid);
				pstmt.setString(2,apptdate);
				pstmt.setString(3,addedFacilityId);
				pstmt.setString(4,clinic_type);
				pstmt.setString(5,cliniccode);
				pstmt.setString(6,pat_class);
				pstmt.setString(7,speciality_code);
				rs=pstmt.executeQuery();
				if(rs != null){
					if(rs.next()){
						status_MP=rs.getString(1);
						if(status_MP == null) status_MP="";
					}
				}
				if(pstmt!=null)pstmt.close();
			}
			if(alcn_criteria.equals("NG")&&book_apt_acr_cat_yn.equals("Y")){
				//Below query modified for security issue by Kamatchi S against COMMON-ICN-0165
				//String stat_grp_sql="SELECT alcn_catg_code, max_patients, total_booked_patients,total_blocked_slots FROM oa_clinic_schedule_dtl WHERE clinic_date = TO_DATE ('"+apptdate+"', 'dd/mm/yyyy') AND facility_id = '"+addedFacilityId+"' AND clinic_code = '"+cliniccode+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitionerid+"', 'X') and MAX_PATIENTS!=(TOTAL_BOOKED_PATIENTS+TOTAL_BLOCKED_SLOTS) order by ALCN_CATG_CODE";
				String stat_grp_sql="SELECT alcn_catg_code, max_patients, total_booked_patients,total_blocked_slots FROM oa_clinic_schedule_dtl WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND facility_id = ? AND clinic_code = ? AND NVL (practitioner_id, 'X') = NVL (?, 'X') and MAX_PATIENTS!=(TOTAL_BOOKED_PATIENTS+TOTAL_BLOCKED_SLOTS) order by ALCN_CATG_CODE";
				if(rs!=null ) rs.close();
				pstmt=con.prepareStatement(stat_grp_sql);
				pstmt.setString(1,apptdate);
				pstmt.setString(2,addedFacilityId);
				pstmt.setString(3,cliniccode);
				pstmt.setString(4,practitionerid);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					alcn_category=rs.getString("alcn_catg_code");
				}
			}
			String addedAtWorkstation=client_ip_address;
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("cliniccode",cliniccode);
			passObjects.put("practitionerid",practitionerid);
			passObjects.put("appttime",appttime);
			passObjects.put("apptslabfmtime",apptslabfmtime);
			passObjects.put("apptslabtotime",apptslabtotime);
			passObjects.put("apptdate",apptdate);
			passObjects.put("patientid",patientid);
			passObjects.put("prefix",prefix);
			passObjects.put("firstname",firstname);
			passObjects.put("secondname",secondname);
			passObjects.put("thirdname",thirdname);
			passObjects.put("familyname",familyname);
			passObjects.put("suffix",suffix);
			passObjects.put("patientname",patientname);
			passObjects.put("patient_name_long",patient_name_long);
			passObjects.put("patient_name_loc_lang_long",patient_name_loc_lang_long);
			passObjects.put("gender",gender);
			passObjects.put("dateofbirth",dateofbirth);
			passObjects.put("nationalidno",nationalidno);
			passObjects.put("altid1no",altid1no);
			passObjects.put("apptcode1",apptcode1);
			passObjects.put("apptcode",apptcode);
			passObjects.put("visitind",visitind);
			passObjects.put("overbooked",overbooked);
			passObjects.put("refsourcetype",refsourcetype);
			passObjects.put("refcode",refcode);
			passObjects.put("referral_id_old",referral_id_old);
			passObjects.put("contactreason",contactreason);
			passObjects.put("contactmode",contactmode);
			passObjects.put("apptrem",apptrem);
			passObjects.put("restelno",restelno);
			passObjects.put("othtelno",othtelno);
			passObjects.put("emailid",emailid);
			passObjects.put("timetabletype",timetabletype);
			passObjects.put("contdata",contdata);
			passObjects.put("resaddrl1",resaddrl1);
			passObjects.put("resaddrl2",resaddrl2);
			passObjects.put("resaddrl3",resaddrl3);
			passObjects.put("resaddrl4",resaddrl4);
			passObjects.put("postalcode",postalcode);
			passObjects.put("countrycode",countrycode);
			passObjects.put("alcn_criteria",alcn_criteria);
			passObjects.put("pat_cat",pat_cat);
			passObjects.put("nationality_code",nationality_code);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("ref_priority",ref_priority);
			passObjects.put("no_slots",no_slots);
			passObjects.put("team_id",team_id);
			passObjects.put("inpatient_yn",inpatient_yn);
			passObjects.put("altid1typ",altid1typ);
			passObjects.put("altid1expdt",altid1expdt);
			passObjects.put("altid2no",altid2no);
			passObjects.put("altid2typ",altid2typ);
			passObjects.put("altid2expdt",altid2expdt);
			passObjects.put("altid3no",altid3no);
			passObjects.put("altid3typ",altid3typ);
			passObjects.put("altid3expdt",altid3expdt);
			passObjects.put("altid4no",altid4no);
			passObjects.put("altid4typ",altid4typ);
			passObjects.put("altid4expdt",altid4expdt);
			passObjects.put("Othaltid1",Othaltid1);
			passObjects.put("Othaltid1typ",Othaltid1typ);
			passObjects.put("ethnicGrp",ethnicGrp);
			passObjects.put("receivingDtTme",receivingDtTme);
			passObjects.put("prefdate1",prefdate1);
			passObjects.put("prefenddate1",prefenddate1);
			passObjects.put("forced",forced);
			passObjects.put("birthPlace",birthPlace);
			passObjects.put("residency",residency);
			
			passObjects.put("status",status);
			passObjects.put("ethnicSbGrp",ethnicSbGrp);
			passObjects.put("global",global);
			passObjects.put("res_addr1",res_addr1);
			passObjects.put("res_addr2",res_addr2);
			passObjects.put("res_addr3",res_addr3);
			passObjects.put("res_addr4",res_addr4);
			passObjects.put("res_town",res_town);
			passObjects.put("res_area",res_area);
			passObjects.put("res_postal",res_postal);
			passObjects.put("res_region",res_region);
			passObjects.put("res_country",res_country);
			passObjects.put("mail_addr1",mail_addr1);
			passObjects.put("mail_addr2",mail_addr2);
			passObjects.put("mail_addr3",mail_addr3);
			passObjects.put("mail_addr4",mail_addr4);
			passObjects.put("mail_town",mail_town);
			passObjects.put("mail_area",mail_area);
			passObjects.put("mail_postal",mail_postal);
			passObjects.put("mail_region",mail_region);
			passObjects.put("mail_country",mail_country);
			passObjects.put("birthPlace_desc",birthPlace_desc);
			passObjects.put("clinic_type",clinic_type);
			passObjects.put("res_class",res_class);
			passObjects.put("sec_reourses",sec_reourses);
			passObjects.put("speciality_code",speciality_code);
			passObjects.put("pref_date",pref_date);
			passObjects.put("priority",priority);
			passObjects.put("from_wait_list",from_wait_list);
			passObjects.put("waitListNo",waitListNo);
			passObjects.put("order_catalog_criteria",order_catalog_criteria);
			passObjects.put("pre_admit_order_catalog_code",pre_admit_order_catalog_code);
			passObjects.put("or_order_date",or_order_date);
			passObjects.put("recurringdays",recurringdays);
			passObjects.put("order_id",order_id);
			passObjects.put("order_line_num",order_line_num);
			passObjects.put("or_catalogue_code",or_catalogue_code);
			passObjects.put("ordPractId",ordPractId);
			passObjects.put("order_catalog_code",order_catalog_code);
			passObjects.put("req_id", req_id);
			passObjects.put("name_prefix_oth_lang",name_prefix_oth_lang);
			passObjects.put("first_name_oth_lang",first_name_oth_lang);
			passObjects.put("second_name_oth_lang",second_name_oth_lang);
			passObjects.put("third_name_oth_lang",third_name_oth_lang);
			passObjects.put("family_name_oth_lang",family_name_oth_lang);
			passObjects.put("name_suffix_oth_lang",name_suffix_oth_lang);
			passObjects.put("patient_name_local_lang",patient_name_local_lang);
			passObjects.put("Function_id",Function_id);
			passObjects.put("P_EPISODE_TYPE",episode_type);
			passObjects.put("P_MODE","I");
			passObjects.put("addedById",addedById);
			passObjects.put("capture_fin_dtls_yn",capture_fin_dtls_yn);
			passObjects.put("billing_group",billing_group);
			passObjects.put("bl_operational",bl_operational);
			passObjects.put("from_page",from_page);
			passObjects.put("apptrefnum",apptrefnum);
			passObjects.put("sel_service_code",sel_service_code);
			passObjects.put("from_facility_id",from_facility_id);
			passObjects.put("from_encounter_id",from_encounter_id);
			passObjects.put("send_email_yn",send_email_yn);
			passObjects.put("alcn_category",alcn_category);
			passObjects.put("patInstructionsMap",patInstructionsMap);	
			passObjects.put("prcInstructionMap",prcInstructionMap);
			passObjects.put("or_install_yn",or_install_yn);
			passObjects.put("slot_appt_ctrl",slot_appt_ctrl);
			passObjects.put("rule_based_tr",rule_based_tr);
			passObjects.put("language_id",language_id);
			passObjects.put("pract_override_reason",pract_override_reason);
			passObjects.put("patient_cat_code",patient_cat_code);
			passObjects.put("term_set_id",term_set_id);
			passObjects.put("term_code",term_code);
			passObjects.put("canldapptrefno",canldapptrefno);
			passObjects.put("rd_appt_yn",rd_appt_yn);
			passObjects.put("multi_speciality_yn",multi_speciality_yn);//Added for the CRF - Bru-HIMS-CRF-198
			passObjects.put("patCnclCount",patCnclCount);  //Bru-HIMS-CRF 169
			passObjects.put("upt_contact_dtls_mp_yn",upt_contact_dtls_mp_yn);//added changes for HSA-CRF-0226 [IN:050599]
			passObjects.put("upd_pat_dtls_referral_yn",upd_pat_dtls_referral_yn);//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
			passObjects.put("trans_exceed_reason_code",trans_exceed_reason_code); 
			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			passObjects.put("altAddrLine1",altAddrLine1);
			passObjects.put("altAddrLine2",altAddrLine2);
			passObjects.put("altAddrLine3",altAddrLine3);
			passObjects.put("altAddrLine4",altAddrLine4);
			passObjects.put("altAreaCode",altAreaCode);
			passObjects.put("altTownCode",altTownCode);
			passObjects.put("altPostalCode",altPostalCode);
			passObjects.put("altRegionCode",altRegionCode);
			passObjects.put("altCountryCode",altCountryCode);
			passObjects.put("ccNxtOfKinNo",ccNxtOfKinNo);
			passObjects.put("nxtOfKinNo",nxtOfKinNo);//Added by Ajay Hatwate for ML-MMOH-CRF-1930
			passObjects.put("patCountryCode",patCountryCode);//Added by Ajay Hatwate for ML-MMOH-CRF-1930
			passObjects.put("patTelCode",patTelCode);//Added by Ajay Hatwate for ML-MMOH-CRF-1930
			
			/*End*/
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023		
			passObjects.put("smartCardFunc",smartCardFunc);
			passObjects.put("biometric_reason",biometric_reason);
			//Ends
			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
			if(fin_dtls!=null){
				passObjects.put("fin_dtls",(HashMap)fin_dtls);
			}
	

			
			if(entitlement_by_pat_cat_yn.equals("Y") && !patientid.equals("")){
				if(status_MP.equals("0")){
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BookAppointment",BookAppointmentHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =p;
					argArray[1] =passObjects;
					Class [] paramArray = new Class[2];
					paramArray[0] =p.getClass();
					paramArray[1] =passObjects.getClass();					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertBookAppointment",paramArray)).invoke(busObj,argArray);	
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					String error = (String) results.get("error") ;
					String appt_ref_no="";
					if(inserted){
						appt_ref_no=(String) results.get("apptrefno");
						
						if(from_page.equals("")){
							if(from_wait_list.equals("Y")){// handling wait list
									// Passing addedById for updating audit columns::
								 waitListHandler(req,p,addedFacilityId,addedAtWorkstation,waitListNo,appt_ref_no,visitind,addedById);
							}
							if(forced.equals("N")){
								session.putValue("Pat_id",vtemp_pat_id);
							}else{
								session.putValue("Pat_id","N");
							}
							session.putValue("ref_id","N");
							session.putValue("CallMode","N");
							if(from_wait_list.equals("Y")){
								session.removeValue("from_wait_list");
								session.removeValue("waitListNo");
							}
							String ca_patient_id_new=(String)session.getValue("ca_patient_id_new");
							if(ca_patient_id_new != "")
								session.removeValue("ca_patient_id_new");
							if(req_id.equals("")){
								doOnlineReports(req,res,session,locale,appt_ref_no, cliniccode, patientid, facilityId,apptslabfmtime,apptslabtotime,from_page,rd_appt_yn);
							}else{
								session.removeAttribute("patInstructionsMap");
								session.removeAttribute("prcInstructionMap");
								java.util.Hashtable message = MessageManager.getMessage(locale,"OA_APPT_BOOKED","OA");
								String msg = ((String) message.get("message"));
								String msg1=msg+appt_ref_no;
								session.removeAttribute("referral_id_app");
								out.println("alert('"+msg1+"');parent.frames[0].Onsuccess1();const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
							}
						}else{
							session.removeAttribute("patInstructionsMap");
							session.removeAttribute("prcInstructionMap");
							java.util.Hashtable message = MessageManager.getMessage(locale,"APPTS_MODIFIED","OA");
							String msg = ((String) message.get("message"));
							out.println("alert('"+msg+"')");
							doOnlineReports(req,res,session,locale,apptrefnum, cliniccode, patientid, facilityId,apptslabfmtime,apptslabtotime,from_page,rd_appt_yn);
						}
					}else{
						session.removeAttribute("patInstructionsMap");
						session.removeAttribute("prcInstructionMap");
						error = error.replaceAll("\"","");
						error = error.replaceAll("\n","");
						int error1 = error.indexOf("20098");
						int error2 = error.indexOf("20099");
						if(error1 ==-1 && error2 ==-1){
							// Modified by Muthu on 12/03/2010 Issue :- Records are not getting saved during modify appointment 
							//out.println("<script>alert(\""+error.substring(0, error.length() - 4)+"\" );parent.window.close();</script>");
							if(error.indexOf("<br>")!=-1){
								out.println("alert(\""+error.substring(0, error.length()-4)+"\" );const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close()");
							}else{
								out.println("alert(\""+error.substring(0, error.length())+"\" );const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
							}
							// End of comment
						}else if(error2 ==-1 && error1 !=-1){
							java.util.Hashtable message = MessageManager.getMessage(locale,"OA0169","OA");
							String msg = ((String) message.get("message"));
							out.println("alert(\""+msg.substring(0, msg.length())+"\");const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
						}else if(error1 ==-1){
							java.util.Hashtable message = MessageManager.getMessage(locale,"OA0168","OA");
							String msg = ((String) message.get("message"));
							out.println("alert(\""+msg.substring(0,msg.length())+"\");const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
						}
					}
					results.clear();
					passObjects.clear();
				}else if(status_MP.equals("1")){
					 java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
					 String msg = ((String) message.get("message"));
					 out.println("alert('" + msg+ "');parent.frames[0].clearAll1();");		
				}else if(status_MP.equals("2")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.frames[0].clearAll1();");
					//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg) );
				}else if(status_MP.equals("3")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.frames[0].clearAll1();");	
				}else if(status_MP.equals("4")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.frames[0].clearAll1();");
				}
			}else{
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;			
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BookAppointment",BookAppointmentHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] =p;
				argArray[1] =passObjects;
				Class [] paramArray = new Class[2];
				paramArray[0] =p.getClass();
				paramArray[1] =passObjects.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertBookAppointment",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;		
				String appt_ref_no="";
				if(inserted){
					appt_ref_no=(String) results.get("apptrefno");
					if(from_page.equals("")){
					if(from_wait_list.equals("Y")){// handling wait list
					    // Passing addedById for updating audit columns::
						waitListHandler(req,p,addedFacilityId,addedAtWorkstation,waitListNo,appt_ref_no,visitind,addedById);
					}
					if(forced.equals("N")){
						session.putValue("Pat_id",vtemp_pat_id);
					}else{
						session.putValue("Pat_id","N");
					}
					session.putValue("ref_id","N");
					session.putValue("CallMode","N");
					if(from_wait_list.equals("Y")){
						session.removeValue("from_wait_list");
						session.removeValue("waitListNo");
					}
					
					String ca_patient_id_new=(String)session.getValue("ca_patient_id_new");
					if(ca_patient_id_new != "")
						session.removeValue("ca_patient_id_new");
					if(req_id.equals("")){
						doOnlineReports(req,res,session,locale,appt_ref_no, cliniccode, patientid, facilityId,apptslabfmtime,apptslabtotime,from_page,rd_appt_yn);
					}else{
						java.util.Hashtable message = MessageManager.getMessage(locale,"OA_APPT_BOOKED","OA");
						String msg = ((String) message.get("message"));
						String msg1=msg+appt_ref_no;
						session.removeAttribute("patInstructionsMap");
						session.removeAttribute("prcInstructionMap");
						//out.println("<script>alert('"+msg1+"');parent.window.close();</script>");
						session.removeAttribute("referral_id_app");
						out.println("alert('"+msg1+"');parent.frames[0].Onsuccess_mr();");
					}
				}else{
					session.removeAttribute("patInstructionsMap");
					session.removeAttribute("prcInstructionMap");
					java.util.Hashtable message = MessageManager.getMessage(locale,"APPTS_MODIFIED","OA");
					String msg = ((String) message.get("message"));
					out.println("alert('"+msg+"')");
					doOnlineReports(req,res,session,locale,apptrefnum, cliniccode, patientid, facilityId,apptslabfmtime,apptslabtotime,from_page,rd_appt_yn);
				}
			}else{
				session.removeAttribute("patInstructionsMap");
				session.removeAttribute("prcInstructionMap");
				error = error.replaceAll("\"","");
				error = error.replaceAll("\n","");
				int error1 = error.indexOf("20098");
				int error2 = error.indexOf("20099");
				if(error1 ==-1 && error2 ==-1){
					// Modified by Muthu on 12/03/2010 Issue :- Records are not getting saved during modify appointment 
					//out.println("<script>alert(\""+error.substring(0, error.length() - 4)+"\" );parent.window.close();</script>");
					if(error.indexOf("<br>")!=-1) {					
						out.println("alert(\""+error.substring(0,error.length()-4)+"\" );const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");			
					} else {
						out.println("alert(\""+error.substring(0,error.length())+"\" );const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");			
					}
					// End of comment
				}else if(error2 ==-1 && error1 !=-1){
					java.util.Hashtable message = MessageManager.getMessage(locale,"OA0169","OA") ;
					String msg = ((String) message.get("message"));
					out.println("alert(\""+msg.substring(0, msg.length())+"\");const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
				}else if(error1 ==-1){
					java.util.Hashtable message = MessageManager.getMessage(locale,"OA0168","OA") ;
					String msg = ((String) message.get("message"));
					out.println("alert(\""+msg.substring(0, msg.length())+"\");const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
				}
			}
				results.clear();
				passObjects.clear();
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}catch(Exception e){
			//out.println( "Exception Raised : " + e );
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}finally{
			if(con != null){
				ConnectionManager.returnConnection(con,req);
			}
		}
	}//method

	private  void insertGroupAppointment(HttpServletRequest req,HttpServletResponse res){
		PrintWriter out =null;
		java.util.Properties p =null;
		HttpSession session =null;
		String facilityId =null;
		String client_ip_address =null;
		String addedById ="";
		String locale="";
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rsds= null;
		con = ConnectionManager.getConnection(req);
		try{
			out 							= res.getWriter();
			session							= req.getSession(false);
			p 								= (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId 						= (String) session.getValue( "facility_id" ) ;
			client_ip_address 				= p.getProperty("client_ip_address");
			addedById 						= p.getProperty( "login_user" ) ;
			locale							= p.getProperty("LOCALE");
			
			
			
			String visit_type_short_desc	= req.getParameter("visit_type_short_desc")==null?"":req.getParameter("visit_type_short_desc");
			String practitioner_name		= req.getParameter("practitioner_name")==null?"":req.getParameter("practitioner_name");
			String priorty					= req.getParameter("priorty")==null?"":req.getParameter("priorty");
			String calling_mode					= req.getParameter("calling_mode")==null?"N":req.getParameter("calling_mode");
			String p_appt_type_code			= "";
			String p_visit_id				= "";
			if(!visit_type_short_desc.equals("")){
				StringTokenizer st1 = new StringTokenizer(visit_type_short_desc,"~");
				while(st1.hasMoreTokens()){
					p_appt_type_code=st1.nextToken();
					p_visit_id=st1.nextToken();
				}
			}
		
			
			
			String entitlement_by_pat_cat_yn= req.getParameter("entitlement_by_pat_cat_yn")==null?"":req.getParameter("entitlement_by_pat_cat_yn");
			String cliniccode				= req.getParameter("cliniccode")==null?"":req.getParameter("cliniccode");
			String p_care_locn_type_ind		= req.getParameter("p_care_locn_type_ind")==null?"":req.getParameter("p_care_locn_type_ind");
			String p_resource_class			= req.getParameter("p_resource_class")==null?"":req.getParameter("p_resource_class");
			String practitionerid			= req.getParameter("practitionerid")==null?"":req.getParameter("practitionerid");
			String appt_date				= req.getParameter("appt_date")==null?"":req.getParameter("appt_date");
			String appttime					= req.getParameter("From_timeval")==null?"":req.getParameter("From_timeval");
			String apptslabfmtime			= req.getParameter("From_timeval");
		//	String apptslabtotime			= req.getParameter("To_timeval")==null?"":req.getParameter("To_timeval");
			String apptslabtotime			= req.getParameter("To_timeval");
			String p_appt_duration			= "";
			String p_speciality_code		= req.getParameter("spec_code")==null?"":req.getParameter("spec_code");
			String sel_service_code			= req.getParameter("sel_service_code")==null?"":req.getParameter("sel_service_code");
			String p_time_table_type		= req.getParameter("time_table_type")==null?"":req.getParameter("time_table_type");
			String p_facility_id			= facilityId;
			String p_contact_reason_code	= req.getParameter("reason_for_contact")==null?"":req.getParameter("reason_for_contact");
			String p_mode_of_contact		= req.getParameter("mode")==null?"":req.getParameter("mode");
			String p_appt_remarks			= req.getParameter("remarks")==null?"":req.getParameter("remarks");
			String receivingDtTme			= req.getParameter("rec_date");
			
			
			
			
			String p_added_at_ws_no			= client_ip_address;
			String p_modified_at_ws_no		= client_ip_address;
			String p_added_facility_id		= facilityId;
			String p_modified_facility_id	= facilityId;
			String p_clinic_date			= appt_date;
			String group_id					= req.getParameter("group_id")==null?"":req.getParameter("group_id");
			
			String p_user_id				= addedById;
			
						
			if(appttime == null || appttime.equals("")) appttime="00:00";
			if(apptslabfmtime == null || apptslabfmtime.equals("")) apptslabfmtime="00:00";
			if(apptslabtotime == null || apptslabtotime.equals("")) apptslabtotime="00:00";
			/*
			appttime		= appt_date + " " +appttime;
			apptslabfmtime	= appt_date + " " +apptslabfmtime;
			apptslabtotime	= appt_date + " " +apptslabtotime;
			*/
			String apptDtToTime = appt_date+" "+apptslabtotime;
			String apptDtfrmTime = appt_date+" "+apptslabfmtime;
			
			//final String sqlds="select get_time_between(to_date('"+appt_date+" "+apptslabtotime+"',' dd/mm/yyyy hh24:mi'),to_date('"+appt_date+" "+apptslabfmtime+"','dd/mm/yyyy hh24:mi')) from dual ";
			final String sqlds="select get_time_between(to_date(?,' dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi')) from dual ";
			pstmt=con.prepareStatement(sqlds);
			pstmt.setString(1,apptDtToTime);
			pstmt.setString(2,apptDtfrmTime);
			rsds=pstmt.executeQuery();
	
			
			if(rsds !=null && rsds.next()){
				p_appt_duration=rsds.getString(1);
				p_appt_duration=appt_date+" "+p_appt_duration;
			}
			if (rsds !=null) rsds.close();
			if (pstmt!=null) pstmt.close();
			
			//System.err.println(" p_appt_duration==>"+ p_appt_duration);
			if(receivingDtTme == null) receivingDtTme="N";
			
			receivingDtTme=DateUtils.convertDate(receivingDtTme,"DMYHM",locale,"en");
			
			java.util.HashMap passObjects = new java.util.HashMap();

			passObjects.put("cliniccode",cliniccode);					
			passObjects.put("p_care_locn_type_ind",p_care_locn_type_ind);
			passObjects.put("p_resource_class",p_resource_class);			
			passObjects.put("practitionerid",practitionerid);			
			passObjects.put("appt_date",appt_date);					
			passObjects.put("appttime",appttime);					
			passObjects.put("apptslabfmtime",apptslabfmtime);				
			passObjects.put("apptslabtotime",apptslabtotime);
			passObjects.put("p_appt_duration",p_appt_duration);
			passObjects.put("p_speciality_code",p_speciality_code);			
			passObjects.put("sel_service_code",sel_service_code);			
			passObjects.put("p_time_table_type",p_time_table_type);	
			passObjects.put("p_facility_id",p_facility_id);
			passObjects.put("p_contact_reason_code",p_contact_reason_code);		
			passObjects.put("p_mode_of_contact",p_mode_of_contact);			
			passObjects.put("p_appt_remarks",p_appt_remarks);				
			passObjects.put("receivingDtTme",receivingDtTme);				
			passObjects.put("p_appt_type_code",p_appt_type_code);			
			passObjects.put("p_added_at_ws_no",p_added_at_ws_no);			
			passObjects.put("p_modified_at_ws_no",p_modified_at_ws_no);		
			passObjects.put("p_added_facility_id",p_added_facility_id);		
			passObjects.put("p_modified_facility_id",p_modified_facility_id);		
			passObjects.put("p_clinic_date",p_clinic_date);				
			passObjects.put("group_id",group_id);
			passObjects.put("p_visit_id",p_visit_id);
			passObjects.put("p_user_id",p_user_id);
			
			
		
			
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BookAppointment",BookAppointmentHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] =p;
			argArray[1] =passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] =p.getClass();
			paramArray[1] =passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertGroupAppointment",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;		
			String appt_ref_no="";
			String error_value = "0" ;

			if ( inserted ) 
			{
				 error_value = "1" ;
				//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
				out.println("alert('"+error+"');const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();let dialogBody = parent.parent.document.getElementById('dialog-body');dialogBody.contentWindow.returnValue = \""+calling_mode+"*"+apptslabfmtime+"*"+apptslabtotime+"\" ;");
		
			}else{
				 error = (String) results.get("error") ;
				 error_value = "0" ;
 				//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
				out.println("alert('"+error+"');const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
			}
			results.clear();
			passObjects.clear();
		
		}catch(Exception e){
			//System.out.println( "Exception Raised : " + e );
			//System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//System.out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}finally{
			 if (con != null)
		   {
				ConnectionManager.returnConnection(con,req);
		   }
		}
		
		
	}//Group method

	
	private void doOnlineReports(HttpServletRequest httpservletrequest,HttpServletResponse res,HttpSession session,String locale,String s, String s1, String patientid, String s3, String ftm, String ttm,String from_page,String rd_appt_yn)throws ServletException, IOException, SQLException{		
		PrintWriter out =null;
		out = res.getWriter();

		StringBuffer s12=new StringBuffer();
		String s4="";
		String s10 ="";
		if(rd_appt_yn.equals("Y")){
			s4 = "select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'RD' AND REPORT_ID = 'RDRORNTF' and language_id = '"+locale+"'";
			s10="ND_APPT_REF_NUM,ND_FACILITY_ID";				 
		}else{ 
			s4 = "select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OARAPSL' and language_id = '"+locale+"'";
			s10 = "p_appt_ref_no,p_facility_id";
		}

        String s5 = s;
        String s6 = s1;
		String calling_mode1=httpservletrequest.getParameter("CallingMode");
		session.putValue("CallMode1",calling_mode1);    
		session.putValue("patientid",patientid);
       
        String s11 = s5 + "," + s3;
		/*s12 = s12.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        s12 = s12.append("</head><body class='message' onload='reportsPrint()'>");
        s12 = s12.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		s12 = s12.append("<script language = 'JavaScript'>");
		s12 = s12.append("async function reportsPrint() {");*/
		if(from_page.equals(""))
            s12 = s12.append("var message = parent.frames[0].getMessage('OA_APPT_BOOKED','OA');");
        s12 = s12.append("  var dialogHeight    = '50vh' ;");
        s12 = s12.append(" var dialogWidth = '65vw';");
		s12 = s12.append("var dialogTop = '50vh';");
        s12 = s12.append("  var arguments =   ''; ");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			/* below line appt_no variable added by venkatesh.s on 25/03/2012 against RUT-CRF-0006.1 [IN036541] */
        s12 = s12.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=SCH_APPT&rep_id=OARAPSL&step=1&sqlString=" + URLEncoder.encode(s4,"UTF-8") + "&reportParamNames=" + s10 + "&reportParamValues=" + s11 + "&Patient_ID=" + patientid + "&dest_locn_type=C&dest_locn_code=" + s6 + "&appt_no="+s+"';");
        s12 = s12.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';");
        s12 = s12.append("retVal=   await top.window.showModalDialog(getUrl,arguments,features); ");
	  // s12 = s12.append("parent.frames[0].reportsPrint(\""+s4+"\",\""+s10+"\",\""+s11+"\",\""+s6+"\",\""+s+"\",\""+patientid+"\",\""+from_page+"\",\""+s5+"\",\""+ftm+"\",\""+ttm+"\");");
		if(from_page.equals(""))
           s12 = s12.append("alert(message + " + s5 + ");");
		s12 = s12.append("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= \""+s5+"*"+ftm+"*"+ttm+"\" ;");
		//System.out.println("-------inside bookapptservlet line 1265 parent.frames[0] : "+parent.frames[0]);
        //s12 = s12.append("alert(parent.frames[0]);parent.frames[0].Onsuccess1('"+calling_mode1+"','"+patientid+"'); }</script>");
		//s12 = s12.append("alert(parent.frames[0].onsuccess1);if(parent.frames[0] && typeof parent.frames[0].onsuccess1 !== 'undefined')  parent.frames[0].Onsuccess1('"+calling_mode1+"','"+patientid+"'); }</script>");
        s12 = s12.append("  if (parent.frames[0] && ((typeof parent.frames[0].onSuccess1 === 'function') || typeof parent.frames[0].Onsuccess1 === 'function')) {");
		s12 = s12.append("    parent.frames[0].Onsuccess1('" + calling_mode1 + "', '" + patientid + "');");
		s12 = s12.append("  } window.close();");
		/*s12 = s12.append("}</script>");*/
		out.println(s12);		
		session.removeAttribute("referral_id_app");		
		
    }

	private String waitListHandler(	HttpServletRequest req,java.util.Properties precc,String facilityIdrecc,String addedAtWorkstationrecc,String waitlst_n0,String appt_ref_no,String visitind,String userId)throws ServletException, IOException, SQLException{
		Connection conrecc=null;
		PreparedStatement pstmtrecc = null;
		Statement Stmtrecc = null;
		ResultSet rsdsrecc=null;
		String ret_flag="",sql="",booking_n0="",reasonforcancellation="",alcn_criteria="",pat_cat="";
		ret_flag =ret_flag;
		int ins_val=0;

		try{			
			conrecc = ConnectionManager.getConnection(precc);
			String addedFacilityIdrecc=facilityIdrecc;
			conrecc.setAutoCommit( false );
			Stmtrecc=conrecc.createStatement();
			sql="Select Contact_Reason_Code from AM_CONTACT_REASON where Cancel_Appointment_Yn = 'Y' and Eff_Status = 'E' order by 1";
			rsdsrecc=Stmtrecc.executeQuery(sql);
			if(rsdsrecc!=null)
			{
				if(rsdsrecc.next())
				{
					reasonforcancellation=rsdsrecc.getString("Contact_Reason_Code");
					if(reasonforcancellation==null) reasonforcancellation="";
				}
			}
			if(rsdsrecc == null) rsdsrecc.close();		
			sql="select BOOKING_REF_NO from pr_wait_list where facility_id='"+facilityIdrecc+"' and wait_list_no='"+waitlst_n0+"'";
			rsdsrecc=Stmtrecc.executeQuery(sql);
			if(rsdsrecc!=null)
			{
				if(rsdsrecc.next())
				{
					booking_n0=rsdsrecc.getString("BOOKING_REF_NO");
					if(booking_n0==null) booking_n0="";
				}
			}
			if(rsdsrecc !=null) rsdsrecc.close();		
			if(!booking_n0.equals("")){
				if(rsdsrecc == null) rsdsrecc.close();
				java.util.HashMap passObjects = new java.util.HashMap(); 
				passObjects.put("addedFacilityId",facilityIdrecc);
				passObjects.put("apptrefno",booking_n0);
				passObjects.put("visitind",visitind);
				passObjects.put("reasonforcancellation",reasonforcancellation);
				passObjects.put("alcn_criteria",alcn_criteria);
				passObjects.put("pat_cat",pat_cat);
				passObjects.put("addedFacilityId",addedFacilityIdrecc);
				passObjects.put("addedAtWorkstation",addedAtWorkstationrecc);
				passObjects.put("Forced","N");
				passObjects.put("referral_value","C");
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = precc;
				argArray[1] = passObjects;
				Class [] paramArray = new Class[2];
				paramArray[0] = precc.getClass();
				paramArray[1] = passObjects.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentDetails",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;	
                				
				//Updating audit columns::
				sql="update pr_wait_list set WAIT_LIST_STATUS='L',BOOKING_REF_NO='"+appt_ref_no+"' ,MODIFIED_BY_ID='"+userId+"',MODIFIED_AT_WS_NO='"+addedAtWorkstationrecc+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+facilityIdrecc+"' where  facility_id='"+facilityIdrecc+"' and wait_list_no='"+waitlst_n0+"'";

				pstmtrecc=conrecc.prepareStatement(sql);
				ins_val=pstmtrecc.executeUpdate();
				
				if(inserted &&  ins_val>0)
				{
					conrecc.commit();
					ret_flag="True";
				}else{
					conrecc.rollback();
					ret_flag="False";
				}
				results.clear();
				passObjects.clear();
				if(pstmtrecc!= null) pstmtrecc.close() ;

			}else{
			    //Updating audit columns::
				sql="update pr_wait_list set WAIT_LIST_STATUS='L',BOOKING_REF_NO='"+appt_ref_no+"', MODIFIED_BY_ID='"+userId+"',MODIFIED_AT_WS_NO='"+addedAtWorkstationrecc+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+facilityIdrecc+"' where  facility_id='"+facilityIdrecc+"' and wait_list_no='"+waitlst_n0+"'";

				pstmtrecc=conrecc.prepareStatement(sql);
				ins_val=pstmtrecc.executeUpdate();
				
				if(ins_val>0)
				{
					conrecc.commit();
					ret_flag="True";
				}else{
					conrecc.rollback();
					ret_flag="False";
				}
			}
			if(rsdsrecc!= null) rsdsrecc.close() ;
			if(Stmtrecc!= null) Stmtrecc.close() ;
			if(pstmtrecc!= null) pstmtrecc.close() ;
		}catch(Exception ex){
			ret_flag="False";
			ex.printStackTrace();
		}finally{
		   if (conrecc != null)
		   {
				ConnectionManager.returnConnection(conrecc,precc);
		   }
		}
		return  ret_flag="";
	}// method


	private  void linkSecAppointment(HttpServletRequest req,HttpServletResponse res){	
		PrintWriter out =null;
		java.util.ArrayList sec_reourses=null;
		String rec_appt_ref_no="";
		java.util.Properties p =null;
		HttpSession session =null;
		String facilityId =null;
		String client_ip_address =null;
		//String addedById ="";
		String locale="";		
		try{
			out = res.getWriter();
			session = req.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			locale = p.getProperty("LOCALE");	
			String addedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			rec_appt_ref_no=req.getParameter("appt_ref_no");
			String visit_ind =req.getParameter("visitind");
			if(visit_ind==null) visit_ind="";
			String clinic_type_pr=req.getParameter("clinic_type");
			if(clinic_type_pr==null) clinic_type_pr="";
			sec_reourses=new java.util.ArrayList();
			String sec_sel=req.getParameter("sec_sel222");
			if(sec_sel==null) sec_sel="";
			String cliniccode_for_sec= req.getParameter("clinic_code");
			if(cliniccode_for_sec==null) cliniccode_for_sec="";
			String patientid_for_sec= req.getParameter("patientid");
			if(patientid_for_sec==null) patientid_for_sec="";
			StringTokenizer sec_sel_st1 = new StringTokenizer(sec_sel,"@");
			while(sec_sel_st1.hasMoreTokens()){
				String sec_sel_str1=sec_sel_st1.nextToken();
				StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,",");
				while(sec_sel_st2.hasMoreTokens()){
					String tmp=sec_sel_st2.nextToken();
					if(tmp.equals("*"))
						tmp="";
					sec_reourses.add(tmp);
				}		
			} 		
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("rec_appt_ref_no",rec_appt_ref_no);
			passObjects.put("visitind",visit_ind);
			passObjects.put("clinic_type_pr",clinic_type_pr);
			passObjects.put("sec_reourses",sec_reourses);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BookAppointment",BookAppointmentHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("linkSecAppointment",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			String err_msg = (String) results.get( "error" )  ;
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						
			if(inserted)
			{
				doOnlineReportsSec(req,res,locale,rec_appt_ref_no, cliniccode_for_sec, patientid_for_sec, facilityId);
			} else{
					out.println("alert('"+err_msg+"');const dialogTag = parent.parent.document.getElementById('dialog_tag');    dialogTag.close();");
			}
			results.clear();
			passObjects.clear();
		}catch(Exception ex){
			//out.println("Exception  " + ex);
			ex.printStackTrace();
		}
	}// method


	private void doOnlineReportsSec( HttpServletRequest req,HttpServletResponse res,String locale,String s, String s1, String s2, String s3)throws ServletException, IOException, SQLException{
		PrintWriter out =null;
		try{
			out = res.getWriter();
			StringBuffer s12=new StringBuffer();
			String s4 = "select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OARAPSL' and language_id = '"+locale+"'";
			String s5 = s;
			String s6 = s1;
			String s9 = "";
			if(s2 == null || s2.equals(""))
				s9 = "";
			else
				s9 = s2;
			String s10 = "p_appt_ref_no,p_facility_id";
			String s11 = s5 + "," + s3;
			/*s12 = s12.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
			s12.append( "</head><body class='message' onload='reportsPrintSec()'>");
			s12.append("<script language = 'JavaScript'>");
			s12 = s12.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
			s12 = s12.append("async function reportsPrintSec() {");*/
			s12.append("var message = parent.frames[0].getMessage('RECORD_INSERTED','SM');");
			s12.append( "  var dialogHeight    = '50vh' ;");
			s12.append(" var dialogWidth = '55vw' ;");
			s12.append( "var dialogTop = 58;");
			s12.append( "  var arguments =   ''; ");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			/* below line appt_no variable added by venkatesh.s on 25/03/2012 against RUT-CRF-0006.1 [IN036541] */
			s12.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=SCH_APPT&rep_id=OARAPSL&step=1&sqlString=" + URLEncoder.encode(s4,"UTF-8") + "&reportParamNames=" + s10 + "&reportParamValues=" + s11 + "&Patient_ID=" + s9 + "&dest_locn_type=C&dest_locn_code=" + s6 + "&appt_no="+s+"';");
			s12.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';");
			s12.append( "  retVal            =   await window.showModalDialog(getUrl,arguments,features); ");
			//s12 = s12.append("parent.frames[0].reportsPrintSec(\""+s4+"\",\""+s10+"\",\""+s11+"\",\""+s9+"\",\""+s6+"\",\""+s+");");
			s12.append( "alert(message);"); 
			s12.append( "parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();");
			out.println(s12.toString());
			s12.setLength(0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}//method
	
		public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}



