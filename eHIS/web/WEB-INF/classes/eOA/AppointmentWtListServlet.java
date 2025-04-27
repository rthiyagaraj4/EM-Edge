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
import com.ehis.util.*;
import eOA.AppointmentWtList.* ;


public class AppointmentWtListServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
java.util.Properties p;
String cliniccode="",practitionerid ="",apptdatetime="",clinic_type="",res_class="",patientid="",prefix="",firstname="",secondname="",thirdname="",familyname="",suffix="",patientname="",gender="",dateofbirth="",restelno=" ",othtelno=" ",nationalidno="",altid1no="",altid1typ="",altid1expdt="",altid2no="",altid2typ="",altid2expdt="",altid3no="",altid3typ="",altid3expdt="",altid4no="",altid4typ="",altid4expdt="",Othaltid1="",Othaltid1typ="",ethnicGrp="",resaddrl1=" ",resaddrl2=" ",resaddrl3=" ",resaddrl4=" ",postalcode=" ",nationality_code="";
HttpSession session;
String priority="",emailid="",contdata=" ",facilityId="",client_ip_address="",birthPlace="",birthPlace_desc="",residency="",status="",ethnicSbGrp="",res_addr1="",res_addr2="",res_addr3="",res_addr4="",res_town="",res_area="" ,res_postal="",res_region="",res_country="",mail_addr1="",mail_addr2="",mail_addr3="",mail_addr4="", mail_town="",mail_area="",mail_postal="",mail_region="",mail_country="",specality="",wtlt_category="",from="",walst_category_code="",name_prefix_oth_lang="",first_name_oth_lang="",second_name_oth_lang="",third_name_oth_lang="",name_suffix_oth_lang="",family_name_oth_lang="",patient_name_local_lang="",locale="",reason_create_waitlist="",fromencounterid="",fromfacilityid="",wait_list_ref_no="",rd_waitlist_yn="";
String patient_name_long="";
String patient_name_loc_lang_long="";
String multi_speciality_yn="N";//Added for the CRf - Bru-HIMS-CRF-0198

String remarks_create_waitlist = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
String alt_addr_line1 = "",alt_addr_line2="",alt_addr_line3="";
String alt_addr_line4 = "",alt_country_code="", alt_country_desc="", alt_postal_code="";
String alt_postal_desc = "", alt_area_desc	= "", alt_area_code="",alt_town_code="";
String alt_town_desc = "",alt_region_code="", alt_region_desc = ""; 
/*End*/
//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
String smartCardFunc ="";
String biometric_reason="";
//Ends

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	
	{
			session = req.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			locale=(String)session.getAttribute("LOCALE"); 
			client_ip_address = p.getProperty("client_ip_address");
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");

		try {
			this.out = res.getWriter();
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");
			String operation = req.getParameter("Operation"); 
			if ( operation.equals("insert") )
			{
				insertWaitList(req);
			}else if(operation.equals("invitation"))
			{
				invitationWaitList(req);
			}
			else if(operation.equals("Reschedule"))
			{
				canclApptReschedule(req);
				
			}
			}catch (Exception e)	{
			//out.println("ab"+e.toString());
						e.printStackTrace();
			}
		finally{
			}
	}



private synchronized void insertWaitList(HttpServletRequest req)	
{

	try {	
 


					
			nationality_code = req.getParameter("nationality_code1");
			if(nationality_code==null || nationality_code.equals("null")) nationality_code="";
			priority= req.getParameter("priority");
			if(priority==null) priority="";
			cliniccode = req.getParameter("location");
			if(cliniccode == null) cliniccode="";
			if(! cliniccode.equals(""))
				{
					StringTokenizer stclc = new StringTokenizer(cliniccode,"$");
					cliniccode=stclc.nextToken();
				}
			wtlt_category=req.getParameter("or_catalogue_code");
			practitionerid=req.getParameter("practitioner");
			if(practitionerid == null) practitionerid="";
			walst_category_code=req.getParameter("walst_category_code");
			if(walst_category_code ==null) walst_category_code="";
			specality=req.getParameter("speciality");
			if(specality == null) specality="";
			apptdatetime=req.getParameter("rec_date");
			if(apptdatetime == null) apptdatetime=""; //System.out.println("apptdatetime==>"+apptdatetime);
			apptdatetime=DateUtils.convertDate(apptdatetime,"DMY",locale,"en");
            //System.out.println("apptdatetime convert==>"+apptdatetime);
			patientid=req.getParameter("patient_id");
			if(patientid == null) patientid="";
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

			gender=req.getParameter("sex");
			dateofbirth=req.getParameter("date_of_birth"); 
			if(dateofbirth == null) dateofbirth=""; 
			dateofbirth=DateUtils.convertDate(dateofbirth,"DMY",locale,"en");
			nationalidno=req.getParameter("national_id_no");
			if(nationalidno == null) nationalidno="";
			altid1no=req.getParameter("alt_id1_no");
			if(altid1no == null) altid1no="";	
			altid1typ=req.getParameter("alt_id1_type");
			if(altid1typ == null) altid1typ="";
			altid1expdt=req.getParameter("alt_id1_exp_date");
			if(altid1expdt == null) altid1expdt="";
			altid2no=req.getParameter("alt_id2_no");
			if(altid2no == null) altid2no="";	
			altid2typ=req.getParameter("alt_id2_type");
			if(altid2typ == null) altid2typ="";
			altid2expdt=req.getParameter("alt_id2_exp_date");
			if(altid2expdt == null) altid2expdt="";
			altid3no=req.getParameter("alt_id3_no");
			if(altid3no == null) altid3no="";	
			altid3typ=req.getParameter("alt_id3_type");
			if(altid3typ == null) altid3typ="";
			altid3expdt=req.getParameter("alt_id3_exp_date");
			if(altid3expdt == null) altid3expdt="";
			altid4no=req.getParameter("alt_id4_no");
			if(altid4no == null) altid4no="";	
			altid4typ=req.getParameter("alt_id4_type");
			if(altid4typ == null) altid4typ="";
			altid4expdt=req.getParameter("alt_id4_exp_date");
			if(altid4expdt == null) altid4expdt="";	
			Othaltid1=req.getParameter("other_alt_Id"); 
			if(Othaltid1 == null) Othaltid1="";
			Othaltid1typ=req.getParameter("other_alt_type");
			if(Othaltid1typ == null) Othaltid1typ="";
			birthPlace=req.getParameter("Birth_place_code");
			if(birthPlace == null) birthPlace="";
			birthPlace_desc=req.getParameter("place_of_birth");
			if(birthPlace_desc == null) birthPlace_desc="";
			residency=req.getParameter("citizen_yn");
			if(residency == null) residency=residency;
			status=req.getParameter("legal_yn");
			if(status == null) status=status;
			ethnicGrp=req.getParameter("race_code");
			if(ethnicGrp == null) ethnicGrp="";
			ethnicSbGrp=req.getParameter("ethnic_group");
			if(ethnicSbGrp == null) ethnicSbGrp="";
			res_class=req.getParameter("resourceType");
			if(res_class==null) res_class="";
			clinic_type=req.getParameter("locationType");
			if(clinic_type==null) clinic_type="";
			restelno=req.getParameter("contact1_no");
			if(restelno == null) restelno="";
			othtelno=req.getParameter("contact2_no");
			if(othtelno == null) othtelno="";
			emailid=req.getParameter("email");
			if(emailid == null) emailid="";
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
    		from=req.getParameter("from");
			if(from == null) from="";
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
			
			if(patient_name_local_lang !=null && patient_name_local_lang.length()>100){
				patient_name_local_lang=patient_name_local_lang.substring(0,100);
			}
			if(patient_name_local_lang ==null) patient_name_local_lang="";
			reason_create_waitlist=req.getParameter("reason_code");
			if(reason_create_waitlist ==null) reason_create_waitlist ="";
			
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			remarks_create_waitlist = req.getParameter("other_remarks");
			if(remarks_create_waitlist == null) remarks_create_waitlist = "";
			/*End ML-MMOH-CRF-1114*/
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023			
			smartCardFunc=checkForNull(req.getParameter("smartCardFunc"));
			if(smartCardFunc.equals("01")) {
			biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends	

			/*Added by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1	= checkForNullvalue(req.getParameter("alt_addr_line1"));
			alt_addr_line2	= checkForNullvalue(req.getParameter("alt_addr_line2"));
			alt_addr_line3	= checkForNullvalue(req.getParameter("alt_addr_line3"));
			alt_addr_line4	= checkForNullvalue(req.getParameter("alt_addr_line4"));
			alt_town_code	= checkForNullvalue(req.getParameter("alt_town_code"));
			alt_area_code	= checkForNullvalue(req.getParameter("alt_area_code"));
			alt_region_code	= checkForNullvalue(req.getParameter("alt_region_code"));
			alt_postal_code	= checkForNullvalue(req.getParameter("alt_postal_code"));
			alt_country_code= checkForNullvalue(req.getParameter("alt_country_code"));
			/*End*/

			fromfacilityid=req.getParameter("fromfacilityid");
			if(fromfacilityid ==null) fromfacilityid="";
			fromencounterid=req.getParameter("fromencounterid");
			if(fromencounterid ==null) fromencounterid ="";
			multi_speciality_yn=req.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF - 0198
			if(multi_speciality_yn ==null) multi_speciality_yn ="N";
			multi_speciality_yn=multi_speciality_yn.trim();
			

				if(altid1expdt!="" && altid1expdt!="N" )
				altid1expdt=DateUtils.convertDate(altid1expdt,"DMY",locale,"en");
				if(altid2expdt!="" && altid2expdt!="N" )
				altid2expdt=DateUtils.convertDate(altid2expdt,"DMY",locale,"en");
				if(altid3expdt!="" && altid3expdt!="N" )
				altid3expdt=DateUtils.convertDate(altid3expdt,"DMY",locale,"en");
				if(altid4expdt!="" && altid4expdt!="N" )
				altid4expdt=DateUtils.convertDate(altid4expdt,"DMY",locale,"en");

				wait_list_ref_no=req.getParameter("wait_list_ref_no");
			if(wait_list_ref_no ==null) wait_list_ref_no ="";
			rd_waitlist_yn=req.getParameter("rd_waitlist_yn");
			if(rd_waitlist_yn ==null) rd_waitlist_yn ="N";
			contdata=req.getParameter("contactvals");

			if(contdata == null) contdata="";
		if(contdata != " " || contdata != "") 
		{
			contdata=java.net.URLDecoder.decode(contdata);
			StringTokenizer st = new StringTokenizer(contdata,"^");
			if (st.countTokens()>0)
				{
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
			if(resaddrl1.equals("||")) resaddrl1 = "";
			if(resaddrl2.equals("||")) resaddrl2 = "";
			if(resaddrl3.equals("||"))  resaddrl3 = "";
			if(resaddrl4.equals("||")) resaddrl4 = "";
			if(postalcode.equals("||")) postalcode = "";
		}else{
			resaddrl1="";
			resaddrl1="";
			resaddrl2="";
			resaddrl3="";
			resaddrl4="";
			postalcode="";
		}		

			String addedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			String calling_mode=req.getParameter("calling_mode");
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("cliniccode",cliniccode);
			passObjects.put("practitionerid",practitionerid);
			passObjects.put("apptdatetime",apptdatetime);
			passObjects.put("patientid",patientid);
			passObjects.put("prefix",prefix);
			passObjects.put("firstname",firstname);
			passObjects.put("secondname",secondname);
			passObjects.put("thirdname",thirdname);
			passObjects.put("familyname",familyname);
			passObjects.put("suffix",suffix);
			passObjects.put("patientname",patientname);
			passObjects.put("gender",gender);
			passObjects.put("dateofbirth",dateofbirth);
			passObjects.put("nationalidno",nationalidno);
			passObjects.put("altid1no",altid1no);
			passObjects.put("restelno",restelno);
			passObjects.put("othtelno",othtelno);
			passObjects.put("emailid",emailid);
			passObjects.put("nationality_code",nationality_code);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("priority",priority);
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
			passObjects.put("birthPlace",birthPlace);
			passObjects.put("residency",residency);
			passObjects.put("status",status);
			passObjects.put("ethnicSbGrp",ethnicSbGrp);
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
			passObjects.put("specality",specality);
			passObjects.put("wtlt_category",wtlt_category);
			passObjects.put("walst_category_code",walst_category_code);
			passObjects.put("name_prefix_oth_lang",name_prefix_oth_lang);
			passObjects.put("first_name_oth_lang",first_name_oth_lang);
			passObjects.put("second_name_oth_lang",second_name_oth_lang);
			passObjects.put("third_name_oth_lang",third_name_oth_lang);
			passObjects.put("family_name_oth_lang",family_name_oth_lang);
			passObjects.put("name_suffix_oth_lang",name_suffix_oth_lang);
			passObjects.put("patient_name_local_lang",patient_name_local_lang);
			passObjects.put("patient_name_long",patient_name_long);
			passObjects.put("patient_name_loc_lang_long",patient_name_loc_lang_long);
			passObjects.put("reason_create_waitlist",reason_create_waitlist);
			passObjects.put("fromfacilityid",fromfacilityid);
			passObjects.put("fromencounterid",fromencounterid);
			passObjects.put("wait_list_ref_no",wait_list_ref_no);
			passObjects.put("rd_waitlist_yn",rd_waitlist_yn);
			passObjects.put("multi_speciality_yn",multi_speciality_yn);//Added for the CRF - Bru-HIMS-CRF - 0198
			/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			passObjects.put("altAddrLine1",alt_addr_line1);
			passObjects.put("altAddrLine2",alt_addr_line2);
			passObjects.put("altAddrLine3",alt_addr_line3);
			passObjects.put("altAddrLine4",alt_addr_line4);
			passObjects.put("altAreaCode",alt_area_code);
			passObjects.put("altTownCode",alt_town_code);
			passObjects.put("altPostalCode",alt_postal_code);
			passObjects.put("altRegionCode",alt_region_code);
			passObjects.put("altCountryCode",alt_country_code);
			/*End*/
			passObjects.put("remarks_create_waitlist",remarks_create_waitlist); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			passObjects.put("smartCardFunc",smartCardFunc);
			passObjects.put("biometric_reason",biometric_reason);
			//Ends
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentWtList",AppointmentWtListManagerRemote.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentWtList",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			session.putValue("calling_mode",calling_mode);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;			 
			 
			if(from.equals("")){
				if ( inserted ){
					
						error_value = "1" ;
						out.println("<script>parent.f_query_add_mod.onSuccess();</script>");
						out.println("<html><script>parent.messageFrame.location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\";</script><body class='message'></html>");
						
				} else{	
					
					//	out.println("<script>parent.f_query_add_mod.location.href ='../eOA/jsp/ApptWaitListlMainPage.jsp'</script>");
						 out.println("<html><script>parent.messageFrame.location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\"</script><body class='message'></html>");
				}
			}else{
				if ( inserted ){
					
						error_value = "1" ;
						if(!calling_mode.equals("OP") )
					{
							out.println("<script>parent.f_query_add_mod.onSuccess('scheduleappt');</script>");					
					//	out.println("<script>parent.commontoolbarFrame.location.href ='../eOA/jsp/OAToolbar.jsp';</script>");
					//	out.println("<script>parent.f_query_add_mod.location.href ='../eOA/jsp/ApptWaitListlMainPage.jsp?from=ScheduleAppt'</script>");
					//	out.println("<script>alert('"+error +"');</script>");
					//	out.println("<script>parent.messageFrame.location.href ='../eOA/jsp/OAMsg.jsp';</script>");
					out.println("<script>parent.messageFrame.location.href ='../eOA/jsp/OAMsg.jsp?successyn=Y&errorValue="+java.net.URLEncoder.encode( error,"UTF-8" )+ "';</script>");

					}else{
						
					//	out.println("<script>parent.commontoolbarFrame.location.href ='../eOA/jsp/OAToolbar.jsp';</script>");
					//	out.println("<script>parent.f_query_add_mod.location.href ='../eOA/jsp/ApptWaitListlMainPage.jsp?from=ScheduleAppt'</script>");
						//out.println("<script>alert('"+error +"');</script>");
						out.println("<script>parent.messageFrame.location.href ='../eOA/jsp/OAMsg.jsp?successyn=Y&callingMode=OP&errorValue="+java.net.URLEncoder.encode( error,"UTF-8" )+ "';</script>");
						out.println("<script>parent.window.close();</script>");
					}
				} else{
					
						//out.println("<script>parent.commontoolbarFrame.location.href ='../eOA/jsp/OAToolbar.jsp';</script>");
						//out.println("<script>parent.f_query_add_mod.location.href ='../eOA/jsp/ApptWaitListlMainPage.jsp?from=ScheduleAppt'</script>");
						out.println("<script>alert('"+error +"')</script>");
						out.println("<script>parent.messageFrame.location.href ='../eOA/jsp/OAMsg.jsp';</script>");
				}
			}
			
			results.clear();
			passObjects.clear();
	}catch ( Exception e )
	{
		//out.println( "Exception Raised : " + e );
		e.printStackTrace();
	}
   }//method
   private synchronized void invitationWaitList(HttpServletRequest req)
   {
	   String wait_date_value="",wait_list_value="",final_vals="";
	   try
	   {
		    
            RecordSet waitlistinvitation1 = null;
			//RecordSet waitlistinvitation2 = null;
			//RecordSet waitlistinvitation3 = null;
			RecordSet waitlistinvitation = null;
			int maxrecord1=0;
			HashMap		passObjects				= new HashMap();
			passObjects.put("facilityId", facilityId); //Passing facilityid for updating audit columns
			
			wait_date_value=req.getParameter("wait_date_value");
			if(wait_date_value ==null) wait_date_value="";
			wait_date_value=DateUtils.convertDate(wait_date_value,"DMY",locale,"en");

			
			
			wait_list_value=req.getParameter("wait_list_value");
			if(wait_list_value ==null)	 wait_list_value="";
			final_vals=req.getParameter("final_vals");
			if(final_vals ==null) final_vals="";
			String record_status=req.getParameter("record_status");
			if(record_status ==null)  record_status="";
			String maxrecord=req.getParameter("maxrecord" );
			maxrecord1=Integer.parseInt(maxrecord);
			String from = req.getParameter("from") != null ? req.getParameter("from") : "0";
			String to = req.getParameter("to") != null ? req.getParameter("to") : "0";
			int			n_from				= Integer.parseInt(from.trim());
			int			n_to				= Integer.parseInt(to.trim());
			waitlistinvitation1 = (RecordSet)session.getAttribute("waitlistinvitation1");
			//waitlistinvitation2 = (RecordSet)session.getAttribute("waitlistinvitation2");
			//waitlistinvitation3 = (RecordSet)session.getAttribute("waitlistinvitation3");
			waitlistinvitation = (RecordSet)session.getAttribute("waitlistinvitation");
			String		checkedOnes			= "";
			String invitationdateval="";
			String waitliststatus="";
			String dummy_checked="";
			int count=0;
			boolean inserted = false ;
			String error = "";
			
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023		
			String clinic_type=checkForNull(req.getParameter("clinic_type"));
			String patient_id=checkForNull(req.getParameter("ca_patient_id"));
			smartCardFunc=checkForNull(req.getParameter("smartCardFunc"));			
			if(smartCardFunc.equals("01")) {
			biometric_reason							    = (String) session.getValue( "biometric_reason" ) ;
			session.removeAttribute("biometric_reason");
			}
			//Ends
			
			java.util.HashMap results=new HashMap();
		java.util.HashMap hashwait=new HashMap();	
			boolean flag2=false;
			hashwait = (HashMap)waitlistinvitation.getObject(0);
		if(from != null && to != null)
		{
			
				for( int i= n_from; i<=n_to; i++)
				{

					
					if(req.getParameter(("checkBox"+i)) != null)
					{
						checkedOnes = req.getParameter(("checkBox"+i));
						invitationdateval= req.getParameter("invitation_date"+(i));
						waitliststatus=req.getParameter("status_val"+(i));
						dummy_checked=req.getParameter("remove_Code"+(i));
						
						if(dummy_checked ==null) dummy_checked="N";
						if(checkedOnes!=null)dummy_checked="Y";
					

						

						invitationdateval=DateUtils.convertDate(invitationdateval,"DMY",locale,"en");

						

						flag2=true;
						

					/*	if(!(waitlistinvitation1.containsObject(checkedOnes)))
						{
							waitlistinvitation1.putObject(checkedOnes);
							waitlistinvitation2.putObject(invitationdateval);
							waitlistinvitation3.putObject(waitliststatus);
						}*/

						if(hashwait !=null && hashwait.containsKey("key"+checkedOnes) )
						 {
							  hashwait.put("key"+checkedOnes, dummy_checked);
							  hashwait.put("date"+checkedOnes, invitationdateval);
							  hashwait.put("status"+checkedOnes, waitliststatus);

						}
				
					}
					

					String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
					{
						String wait_num = req.getParameter("wait_num"+(i));
						if((waitlistinvitation1.containsObject(wait_num)))
						{
							int removeCodeIndex = waitlistinvitation1.indexOfObject(wait_num);
								waitlistinvitation1.removeObject(removeCodeIndex);
								//waitlistinvitation2.removeObject(removeCodeIndex);
								//waitlistinvitation3.removeObject(removeCodeIndex);
						}
					}
				}

				/* if(hashwait!=null && hashwait.size()>0){
 						waitlistinvitation.putObject(hashwait);	
					 }*/
			}



String waitlistinviteddate1="";
String waitliststatus1="";

	Set final_val=hashwait.keySet();
	Iterator final_val1=final_val.iterator();
count=0;
while(final_val1.hasNext())
 {
	String one=(String)final_val1.next();
	String wait_list_num_main=one.substring(3,one.length());
	if(one.indexOf("key")!=-1)
	 {
	String two=(String) hashwait.get(one);
	if(two ==null) two="N";
	if(two.equals("Y"))
	{
		
		waitlistinviteddate1 = (String)hashwait.get("date"+wait_list_num_main);
		waitliststatus1 =(String)hashwait.get("status"+wait_list_num_main);
	
	if(waitlistinviteddate1 ==null) waitlistinviteddate1="";
	
	

	if(waitliststatus1 ==null) waitliststatus1="";
	passObjects.put("waitlistnum"+count, wait_list_num_main);
	passObjects.put("inviteddate"+count, waitlistinviteddate1);
	passObjects.put("status"+count, waitliststatus1);
	count++;
	}
	 }
}

		passObjects.put("count",new Integer(count) );


		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		passObjects.put("smartCardFunc",smartCardFunc);
		passObjects.put("biometric_reason",biometric_reason);
		passObjects.put("clinic_type",clinic_type);
		passObjects.put("patient_id",patient_id);		
		//Ends

			if(count >0)
		   {
				passObjects.put("count",new Integer(count) );
				boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentWtList",AppointmentWtListManagerRemote.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			 results = (java.util.HashMap)(busObj.getClass().getMethod("invitationWaitList",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			 inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			 error = (String) results.get("error") ;
			
	   }else
	  {
			inserted=false;
	  }
			if(inserted)
			{
				doOnlineReportsinvitation(wait_date_value, wait_list_value);
			
			} else{
				
				out.println("<script>parent.frames[3].OnSuccess('false');</script>");

			}

			results.clear();
			passObjects.clear();
			waitlistinvitation1.clearAll();
			//waitlistinvitation2.clearAll();
			//waitlistinvitation3.clearAll();

			
	   }
	   catch (Exception e)
	   {

   			e.printStackTrace();
	   }
   }//Method
   
   
/*Below Method Added for this CRF [Bru-HIMS-CRF-0166]*/
private synchronized void canclApptReschedule(HttpServletRequest req)	{
Connection conn=null; Statement stmt=null; ResultSet rs=null;
PreparedStatement pstmt=null;
try {	
String apptreffno = req.getParameter("apptrefno");
//String sql_query="select * from oa_appt_del_tr where APPT_REF_NO='"+apptreffno+"' and FACILITY_ID='"+facilityId+"'";
//String sql_query="select CLINIC_CODE,PRACTITIONER_ID,appt_date,PATIENT_ID,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,PATIENT_NAME,GENDER,DATE_OF_BIRTH,NATIONAL_ID_NO,ALT_ID1_NO,RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID,COUNTRY_CODE,ALT_ID1_TYPE,ALT_ID1_EXP_DATE,ALT_ID2_NO,ALT_ID2_TYPE,ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,ETHNIC_GROUP_CODE,BIRTH_PLACE_CODE,CITIZEN_YN,ETHNIC_GROUP_CODE,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MAIL_AREA_CODE,MAIL_POSTAL_CODE,MAIL_REGION_CODE,MAIL_COUNTRY_CODE,BIRTH_PLACE_DESC,CARE_LOCN_TYPE_IND,RESOURCE_CLASS,SPECIALITY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG,REASON_FOR_CANCEL,FACILITY_ID,ENCOUNTER_ID,multi_speciality_yn,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_area_code,alt_town_code,alt_region_code,alt_postal_code,alt_country_code from oa_appt_del_tr where APPT_REF_NO='"+apptreffno+"' and FACILITY_ID='"+facilityId+"'";//included multi_speciality_yn for the CRF - Bru-HIMS-CRF-0198
String sql_query="select CLINIC_CODE,PRACTITIONER_ID,appt_date,PATIENT_ID,NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,PATIENT_NAME,GENDER,DATE_OF_BIRTH,NATIONAL_ID_NO,ALT_ID1_NO,RES_TEL_NO,OTH_CONTACT_NO,EMAIL_ID,COUNTRY_CODE,ALT_ID1_TYPE,ALT_ID1_EXP_DATE,ALT_ID2_NO,ALT_ID2_TYPE,ALT_ID2_EXP_DATE,ALT_ID3_TYPE,ALT_ID3_NO,ALT_ID3_EXP_DATE,ALT_ID4_TYPE,ALT_ID4_NO,ALT_ID4_EXP_DATE,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,ETHNIC_GROUP_CODE,BIRTH_PLACE_CODE,CITIZEN_YN,ETHNIC_GROUP_CODE,RES_ADDR_LINE1,RES_ADDR_LINE2,RES_ADDR_LINE3,RES_ADDR_LINE4,RES_TOWN_CODE,RES_AREA_CODE,RES_TOWN_CODE,RES_REGION_CODE,COUNTRY_CODE,MAIL_ADDR_LINE1,MAIL_ADDR_LINE2,MAIL_ADDR_LINE3,MAIL_ADDR_LINE4,MAIL_TOWN_CODE,MAIL_AREA_CODE,MAIL_POSTAL_CODE,MAIL_REGION_CODE,MAIL_COUNTRY_CODE,BIRTH_PLACE_DESC,CARE_LOCN_TYPE_IND,RESOURCE_CLASS,SPECIALITY_CODE,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,PATIENT_NAME_LOC_LANG,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG,REASON_FOR_CANCEL,FACILITY_ID,ENCOUNTER_ID,multi_speciality_yn,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_area_code,alt_town_code,alt_region_code,alt_postal_code,alt_country_code from oa_appt_del_tr where APPT_REF_NO=? and FACILITY_ID=?";//included multi_speciality_yn for the CRF - Bru-HIMS-CRF-0198
//Modified above query by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 --alternate address
 conn = ConnectionManager.getConnection(req);
 stmt	 = conn.createStatement();
 //rs	= stmt.executeQuery(sql_query);
 pstmt = conn.prepareStatement(sql_query);
 pstmt.setString(1,apptreffno);
 pstmt.setString(2,facilityId);
 rs = pstmt.executeQuery();
  String addedFacilityId=facilityId; 
		   String addedAtWorkstation=client_ip_address;
		   String calling_mode=req.getParameter("calling_mode");
           java.util.HashMap passObjects = new java.util.HashMap(); 
		   
if(rs !=null && rs.next())
{
		 
		    cliniccode=checkForNullvalue(rs.getString("CLINIC_CODE"));
			practitionerid=checkForNullvalue(rs.getString("PRACTITIONER_ID"));
			//apptdatetime=checkForNull(rs.getString("appt_date"));
			patientid=checkForNullvalue(rs.getString("PATIENT_ID"));			
			prefix=checkForNullvalue(rs.getString("NAME_PREFIX"));			
			firstname=checkForNullvalue(rs.getString("FIRST_NAME"));
			secondname=checkForNullvalue(rs.getString("SECOND_NAME"));
			thirdname=checkForNullvalue(rs.getString("THIRD_NAME"));
			familyname=checkForNullvalue(rs.getString("FAMILY_NAME"));
			suffix=checkForNullvalue(rs.getString("NAME_SUFFIX"));
			patientname=checkForNullvalue(rs.getString("PATIENT_NAME"));
			gender=checkForNullvalue(rs.getString("GENDER"));
			// dateofbirth=checkForNull(rs.getString("DATE_OF_BIRTH"));
			nationalidno=checkForNullvalue(rs.getString("NATIONAL_ID_NO"));
			altid1no=checkForNullvalue(rs.getString("ALT_ID1_NO"));
			restelno=checkForNullvalue(rs.getString("RES_TEL_NO"));
			othtelno=checkForNullvalue(rs.getString("OTH_CONTACT_NO"));
			emailid=checkForNullvalue(rs.getString("EMAIL_ID"));
			nationality_code=checkForNullvalue(rs.getString("COUNTRY_CODE"));
			
			altid1typ=checkForNullvalue(rs.getString("ALT_ID1_TYPE"));
			altid1expdt=checkForNullvalue(rs.getString("ALT_ID1_EXP_DATE"));
			altid2no=checkForNullvalue(rs.getString("ALT_ID2_NO"));
			altid2typ=checkForNullvalue(rs.getString("ALT_ID2_TYPE"));
			altid2expdt=checkForNullvalue(rs.getString("ALT_ID2_EXP_DATE"));
			altid3typ=checkForNullvalue(rs.getString("ALT_ID3_TYPE")); 
			altid3no=checkForNullvalue(rs.getString("ALT_ID3_NO"));
			altid3expdt=checkForNullvalue(rs.getString("ALT_ID3_EXP_DATE"));			
			altid4typ=checkForNullvalue(rs.getString("ALT_ID4_TYPE")); 
			altid4no=checkForNullvalue(rs.getString("ALT_ID4_NO"));
			altid4expdt=checkForNullvalue(rs.getString("ALT_ID4_EXP_DATE"));			
			Othaltid1=checkForNullvalue(rs.getString("OTH_ALT_ID_NO"));
			Othaltid1typ=checkForNullvalue(rs.getString("OTH_ALT_ID_TYPE"));
			ethnicGrp=checkForNullvalue(rs.getString("ETHNIC_GROUP_CODE"));
			
			birthPlace=checkForNullvalue(rs.getString("BIRTH_PLACE_CODE"));
			residency=checkForNullvalue(rs.getString("CITIZEN_YN"));
			
			ethnicSbGrp=checkForNullvalue(rs.getString("ETHNIC_GROUP_CODE"));
			res_addr1=checkForNullvalue(rs.getString("RES_ADDR_LINE1"));
			res_addr2=checkForNullvalue(rs.getString("RES_ADDR_LINE2"));
			res_addr3=checkForNullvalue(rs.getString("RES_ADDR_LINE3"));
			res_addr4=checkForNullvalue(rs.getString("RES_ADDR_LINE4"));
			res_town=checkForNullvalue(rs.getString("RES_TOWN_CODE"));
			res_area=checkForNullvalue(rs.getString("RES_AREA_CODE"));
			res_postal=checkForNullvalue(rs.getString("RES_TOWN_CODE"));
			res_region=checkForNullvalue(rs.getString("RES_REGION_CODE"));
			res_country=checkForNullvalue(rs.getString("COUNTRY_CODE"));
		    mail_addr1=checkForNullvalue(rs.getString("MAIL_ADDR_LINE1"));
			mail_addr2=checkForNullvalue(rs.getString("MAIL_ADDR_LINE2"));
			mail_addr3=checkForNullvalue(rs.getString("MAIL_ADDR_LINE3"));
			mail_addr4=checkForNullvalue(rs.getString("MAIL_ADDR_LINE4"));
			mail_town=checkForNullvalue(rs.getString("MAIL_TOWN_CODE"));
			mail_area=checkForNullvalue(rs.getString("MAIL_AREA_CODE"));
			mail_postal=checkForNullvalue(rs.getString("MAIL_POSTAL_CODE"));
			mail_region=checkForNullvalue(rs.getString("MAIL_REGION_CODE"));
			mail_country=checkForNullvalue(rs.getString("MAIL_COUNTRY_CODE"));
			birthPlace_desc=checkForNullvalue(rs.getString("BIRTH_PLACE_DESC"));
			clinic_type=checkForNullvalue(rs.getString("CARE_LOCN_TYPE_IND")); 
			res_class=checkForNullvalue(rs.getString("RESOURCE_CLASS"));
			specality=checkForNullvalue(rs.getString("SPECIALITY_CODE"));
			//wtlt_category=rs.getString("ETHNIC_GROUP_CODE");//modify
			//walst_category_code=rs.getString("ETHNIC_GROUP_CODE");//modify
			name_prefix_oth_lang=checkForNullvalue(rs.getString("NAME_PREFIX_LOC_LANG"));
			first_name_oth_lang=checkForNullvalue(rs.getString("FIRST_NAME_LOC_LANG"));
			second_name_oth_lang=checkForNullvalue(rs.getString("SECOND_NAME_LOC_LANG"));
			third_name_oth_lang=checkForNullvalue(rs.getString("THIRD_NAME_LOC_LANG"));
			family_name_oth_lang=checkForNullvalue(rs.getString("FAMILY_NAME_LOC_LANG"));
			name_suffix_oth_lang=checkForNullvalue(rs.getString("NAME_SUFFIX_LOC_LANG"));
			patient_name_local_lang=checkForNullvalue(rs.getString("PATIENT_NAME_LOC_LANG")); 
			patient_name_long=checkForNullvalue(rs.getString("PATIENT_LONG_NAME"));
			patient_name_loc_lang_long=checkForNullvalue(rs.getString("PATIENT_LONG_NAME_LOC_LANG"));
		    reason_create_waitlist=checkForNullvalue(rs.getString("REASON_FOR_CANCEL"));
			fromfacilityid=checkForNullvalue(rs.getString("FACILITY_ID"));  
			fromencounterid=checkForNullvalue(rs.getString("ENCOUNTER_ID")); 
			multi_speciality_yn=checkForNullvalue(rs.getString("multi_speciality_yn"));//Added for the CRF - Bru-HIMS-CRF-0198 
			
			/*Added by Thamizh selvi on 5th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNullvalue(rs.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNullvalue(rs.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNullvalue(rs.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNullvalue(rs.getString("alt_addr_line4"));
			alt_area_code		= checkForNullvalue(rs.getString("alt_area_code"));
			alt_region_code		= checkForNullvalue(rs.getString("alt_region_code"));
			alt_town_code		= checkForNullvalue(rs.getString("alt_town_code"));
			alt_postal_code		= checkForNullvalue(rs.getString("alt_postal_code"));
			alt_country_code	= checkForNullvalue(rs.getString("alt_country_code"));
			/*End*/
			
			  java.util.Date appt_date1 = rs.getDate("appt_date");
			 if(appt_date1 != null )
			{
				java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("dd/MM/yyyy");
				apptdatetime=formatter1.format(appt_date1);
				formatter1 = null;
			 }	
			
			 java.util.Date date1 = rs.getDate("date_of_birth");
			 if(date1 != null )
			{
				java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("dd/MM/yyyy");
				 dateofbirth=formatter1.format(date1);
				 formatter1 = null;
			 }
			
			
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("cliniccode",cliniccode);
			passObjects.put("practitionerid",practitionerid);
			passObjects.put("apptdatetime",apptdatetime);
			passObjects.put("patientid",patientid);
			passObjects.put("prefix",prefix);
			passObjects.put("firstname",firstname);
			passObjects.put("secondname",secondname);
			passObjects.put("thirdname",thirdname);
			passObjects.put("familyname",familyname);
			passObjects.put("suffix",suffix);
			passObjects.put("patientname",patientname);
			passObjects.put("gender",gender);
			passObjects.put("dateofbirth",dateofbirth);
			passObjects.put("nationalidno",nationalidno);
			passObjects.put("altid1no",altid1no);
			passObjects.put("restelno",restelno);
			passObjects.put("othtelno",othtelno);
			passObjects.put("emailid",emailid);
			passObjects.put("nationality_code",nationality_code);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("priority","U");
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
			passObjects.put("birthPlace",birthPlace);
			passObjects.put("residency",residency);
			passObjects.put("status","A");
			passObjects.put("ethnicSbGrp",ethnicSbGrp);
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
			passObjects.put("specality",specality);
			passObjects.put("wtlt_category",wtlt_category);
			passObjects.put("walst_category_code",walst_category_code);
			passObjects.put("name_prefix_oth_lang",name_prefix_oth_lang);
			passObjects.put("first_name_oth_lang",first_name_oth_lang);
			passObjects.put("second_name_oth_lang",second_name_oth_lang);
			passObjects.put("third_name_oth_lang",third_name_oth_lang);
			passObjects.put("family_name_oth_lang",family_name_oth_lang);
			passObjects.put("name_suffix_oth_lang",name_suffix_oth_lang);
			passObjects.put("patient_name_local_lang",patient_name_local_lang);
			passObjects.put("patient_name_long",patient_name_long);
			passObjects.put("patient_name_loc_lang_long",patient_name_loc_lang_long);
			passObjects.put("reason_create_waitlist",reason_create_waitlist);
			passObjects.put("fromfacilityid",fromfacilityid);
			passObjects.put("fromencounterid",fromencounterid);
			passObjects.put("wait_list_ref_no",wait_list_ref_no);
			passObjects.put("apptreffno",apptreffno);
			passObjects.put("rescheduleflag","Y");
			passObjects.put("multi_speciality_yn",multi_speciality_yn);//Added for the crf - BRU-HIMS-CRF-0198
			/*Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			passObjects.put("altAddrLine1",alt_addr_line1);
			passObjects.put("altAddrLine2",alt_addr_line2);
			passObjects.put("altAddrLine3",alt_addr_line3);
			passObjects.put("altAddrLine4",alt_addr_line4);
			passObjects.put("altAreaCode",alt_area_code);
			passObjects.put("altTownCode",alt_town_code);
			passObjects.put("altPostalCode",alt_postal_code);
			passObjects.put("altRegionCode",alt_region_code);
			passObjects.put("altCountryCode",alt_country_code);
			/*End*/
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentWtList",AppointmentWtListManagerRemote.class,local_ejbs);
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			
			argArray[0] = p;
			argArray[1] = passObjects; 
			Class [] paramArray = new Class[2]; 
			paramArray[0] = p.getClass();  
			paramArray[1] = passObjects.getClass(); 

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentWtList",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			session.putValue("calling_mode",calling_mode); 
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ; 
			String error = (String) results.get("error") ; 
			 /* CheckStyle Violation Commented by Munisekhar */ 
             //String error_value = "0" ;		 
			 //out.println("<html><script>parent.messageFrame.location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\";</script><body class='message'></html>");
			if ( inserted ){			
			
			out.println("<html><script>alert('"+error+"');</script></html>");
			out.println("<script>parent.frames[1].document.forms[0].select.click();</script>");			
			//out.println("<html><script>parent.messageFrame.location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\";</script><body class='message'></html>");
			}
		
			
			results.clear();
			passObjects.clear();
			
			
			
   }
    /* CheckStyle Correction by Munisekhar */  
   if(rs !=null) rs.close();
   if(stmt !=null) stmt.close();
   if(pstmt !=null) pstmt.close();//Added for Checkstyle issue DEC23
	}catch (Exception e)	{
			
						e.printStackTrace();
	}
		finally{
		if(conn !=null) ConnectionManager.returnConnection(conn,req);
			}

}

// End CRF [Bru-HIMS-CRF-0166]
   
   
 public static String checkForNullvalue(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}  

public static String checkForNull(String s)
    {
        return s != null && !s.equals("null") ? s : "";
    }
   private void doOnlineReportsinvitation( String s, String s1)
        throws ServletException, IOException, SQLException
    {
		StringBuffer s12=new StringBuffer();
        s12 = s12.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        s12.append( "</head><body class='message'>");
		s12.append("<script language = 'JavaScript'>");
      //  s12.append("var message = getMessage('RECORD_INSERTED','SM')");
        s12.append( "parent.query_search_result.OnSuccess('true');");
		s12.append( "</script>");
        out.println(s12.toString());
		s12.setLength(0);
   }//method



}



