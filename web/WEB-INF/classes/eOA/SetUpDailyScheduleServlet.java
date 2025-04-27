/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;  
  
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOA.SetUpDailySchedule.*;
import java.net.URLEncoder;
import com.ehis.util.*;
 
public class SetUpDailyScheduleServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out =null;
	Properties p = null;
	String  ws_no = "" ;
	String  uid    = "";
	String facilityId="";
	String alcncriteria = "";
	String resource_Type= "";
	String location_Type= "";
	String locale="";
	String schedule_extend_yn = "N";//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	
	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	String ext_all_slots_yn = "N";
	String ext_start_slots = "";
	String ext_mid_slots = "";
	String ext_end_slots = "";

	 HttpSession session=null;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
			session = request.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			locale=(String)session.getAttribute("LOCALE"); 
		try
		{
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			ws_no    = p.getProperty("client_ip_address");
			uid = p.getProperty( "login_user" ) ;
			String operation = request.getParameter("fmode");
			
			String clinic_code 	= request.getParameter("location") ==null?"":request.getParameter("location");
			if ( operation.equals("insert") )
			clinic_code = clinic_code.substring(0,clinic_code.indexOf("$"));
			alcncriteria = request.getParameter("alcn_criteria");
			
			resource_Type= request.getParameter("resourceType") ==null?"":request.getParameter("resourceType");
			location_Type= request.getParameter("location_type") ==null?"":request.getParameter("location_type");

			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			schedule_extend_yn = request.getParameter("schedule_extend_yn")==null?"N":request.getParameter("schedule_extend_yn");

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			ext_all_slots_yn = request.getParameter("ext_all_slots_yn")==null?"N":request.getParameter("ext_all_slots_yn");
			ext_start_slots = request.getParameter("ext_start_slots") ==null?"":request.getParameter("ext_start_slots");
			ext_mid_slots = request.getParameter("ext_mid_slots") ==null?"":request.getParameter("ext_mid_slots");
			ext_end_slots = request.getParameter("ext_end_slots") ==null?"":request.getParameter("ext_end_slots");
		
			if ( operation.equals("insert") )
				insertSetUpDailySchedule(request, res);


			else if(operation.equals("modify") )
				modifySetUpDailySchedule(request, res);


			else if(operation.equals("delete") )
				deleteSetUpDailySchedule(request, res);

		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	}

	private void insertSetUpDailySchedule(HttpServletRequest request, HttpServletResponse res)
	{
		try
		{
				request.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");
	            HashMap tabdata = new HashMap() ;

			String p_clinic_code1 	= request.getParameter("location") ==null?"":request.getParameter("location");
			String clinic_date=request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
			clinic_date=DateUtils.convertDate(clinic_date,"DMY",locale,"en");

			StringTokenizer token = new StringTokenizer(p_clinic_code1, "$");
			String p_clinic_code=token.nextToken();
			tabdata.put("clinic_code",p_clinic_code==null?"":p_clinic_code);
			tabdata.put("clinic_date",clinic_date);
			String p_practitioner_id1 = request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
			String p_practitioner_id="";



			if(p_practitioner_id1!=null && !(p_practitioner_id1.equals("")))
			{
				StringTokenizer token1 = new StringTokenizer(p_practitioner_id1, "$");
				p_practitioner_id=token1.nextToken();
			}
			tabdata.put("p_practitioner_id",p_practitioner_id==null?"":p_practitioner_id);
			tabdata.put("p_time_table_type",(request.getParameter("time_table_type")==null?"":request.getParameter("time_table_type")));
			tabdata.put("p_remarks",(request.getParameter("remarks")==null?"":request.getParameter("remarks")));
			tabdata.put("p_start_time",(request.getParameter("start_time")==null?"":request.getParameter("start_time")));
			tabdata.put("p_end_time",(request.getParameter("end_time")==null?"":request.getParameter("end_time")));	
			tabdata.put("p_time_per_patient",(request.getParameter("time_per_patient")==null?"":request.getParameter("time_per_patient")));
			tabdata.put("p_max_patients_per_day",(request.getParameter("max_patients_per_day")==null?"":request.getParameter("max_patients_per_day")));
			tabdata.put("p_time_per_slab",(request.getParameter("time_per_slab")==null?"":request.getParameter("time_per_slab")));	
			tabdata.put("p_max_patients_per_slab",(request.getParameter("max_patients_per_slab")==null?"":request.getParameter("max_patients_per_slab")));
			tabdata.put("max_new_patients",(request.getParameter("max_new_patients")==null?"0":request.getParameter("max_new_patients")));
			tabdata.put("max_old_patients",(request.getParameter("max_old_patients")==null?"0":request.getParameter("max_old_patients")));
			
			
			
			

			String final_string =   request.getParameter("final_string")==null?"":request.getParameter("final_string");

			
			if (final_string!=null || final_string!="null"|| final_string!="") final_string=final_string;
            if (final_string.equals("|*O~0"))final_string="";
			String day_no=   request.getParameter("day_no");
			if (day_no==null ) day_no="";
			if (day_no.equals("")) day_no="";
			if (day_no.equals("null")) day_no="";
			tabdata.put("day_no",day_no);
				

			tabdata.put("alcn_basis",(request.getParameter("alcn_basis")==null?"":request.getParameter("alcn_basis")));
			tabdata.put("final_string",final_string);
			String mfv = request.getParameter("max_first_visit")==null?"":request.getParameter("max_first_visit");
			if(mfv.equals("null")) mfv = "";
			tabdata.put("p_max_first_visit",mfv);
			tabdata.put("p_max_over_bookings",(request.getParameter("max_over_bookings")==null?"":request.getParameter("max_over_bookings")));
			tabdata.put("p_max_other_visits",(request.getParameter("max_other_visits")==null?"":request.getParameter("max_other_visits")));
			tabdata.put("p_max_slots_per_day",(request.getParameter("b_max_slots_per_day")==null?"":request.getParameter("b_max_slots_per_day")));
			tabdata.put("p_break_time_intervals",(request.getParameter("ftotstr")==null?"":request.getParameter("ftotstr")));

	

			String forced_book_YN=request.getParameter("forced_book_YN");
			String no_of_forced_booking=request.getParameter("no_of_forced_booking");
			String no_of_global_booking=request.getParameter("no_of_global_booking");

			if(forced_book_YN==null || forced_book_YN.equals("")){
				forced_book_YN="N";
			}else{
				forced_book_YN="Y";
			}

			if(no_of_forced_booking==null || no_of_forced_booking.equals("")){
				no_of_forced_booking="0";
			}

			if(no_of_global_booking==null || no_of_global_booking.equals("")){
				no_of_global_booking="0";
			}


			tabdata.put("resourceType",(request.getParameter("resourceType")==null?"":request.getParameter("resourceType")));
			tabdata.put("forced_book_YN",forced_book_YN);
			tabdata.put("no_of_forced_booking",no_of_forced_booking);
			tabdata.put("no_of_global_booking",no_of_global_booking);
			tabdata.put("added_by_id",uid);
			tabdata.put("added_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",ws_no);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("modified_by_id",uid);
			tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",ws_no);
			tabdata.put("modified_facility_id",facilityId);
			

			if (final_string.equals(""))
			{
				alcncriteria ="";
				
			}
			tabdata.put("alcn_criteria",alcncriteria);
			tabdata.put("resource_Type",resource_Type);
			tabdata.put("location_Type",location_Type);
			tabdata.put("schedule_extend_yn",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			tabdata.put("ext_all_slots_yn",ext_all_slots_yn);
			tabdata.put("ext_start_slots",ext_start_slots);
			tabdata.put("ext_mid_slots",ext_mid_slots);
			tabdata.put("ext_end_slots",ext_end_slots);

			tabdata.put("visit_limit_rule",(request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule")));

			

System.out.println("SetUpDailyScheduleServlet insertSetUpDailySchedule tabdata :"+tabdata.toString());
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SetUpDailySchedule",SetUpDailyScheduleHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;


			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertSetUpDailySchedule",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			
			

			if ( inserted )
			{
				error_value = "1" ;
				error = (String) results.get("ResultFromMessageManager") ;
			}

			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");

			results.clear();
			tabdata.clear();
			

		}
        catch(Exception e )
        {

          //  out.println("Error In Servlet:"+e.toString());
			e.printStackTrace();
        }
}
    private void modifySetUpDailySchedule(HttpServletRequest request, HttpServletResponse res)
    {
		try
		{
			
			String final_string=   request.getParameter("final_string");
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

			String clinic_date=request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
			clinic_date=DateUtils.convertDate(clinic_date,"DMY",locale,"en");
			


			HashMap tabdata = new HashMap() ;
			tabdata.put("clinic_code",(request.getParameter("location")==null?"":request.getParameter("location")));
			tabdata.put("clinic_date",clinic_date);
			tabdata.put("p_practitioner_id",(request.getParameter("practitioner")==null?"":request.getParameter("practitioner")));
			tabdata.put("p_time_table_type",(request.getParameter("time_table_type")==null?"":request.getParameter("time_table_type")));
			tabdata.put("p_remarks",(request.getParameter("remarks")==null?"":request.getParameter("remarks")));
			tabdata.put("p_start_time",(request.getParameter("start_time")==null?"":request.getParameter("start_time")));
			tabdata.put("p_end_time",(request.getParameter("end_time")==null?"":request.getParameter("end_time")));
			tabdata.put("p_time_per_patient",(request.getParameter("time_per_patient")==null?"":request.getParameter("time_per_patient")));
			tabdata.put("p_max_patients_per_day",(request.getParameter("max_patients_per_day")==null?"":request.getParameter("max_patients_per_day")));
			tabdata.put("p_time_per_slab",(request.getParameter("time_per_slab")==null?"":request.getParameter("time_per_slab")));
			tabdata.put("p_max_patients_per_slab",(request.getParameter("max_patients_per_slab")==null?"":request.getParameter("max_patients_per_slab")));
			tabdata.put("p_max_first_visit",(request.getParameter("max_first_visit")==null?"":request.getParameter("max_first_visit")));
			tabdata.put("p_max_over_bookings",(request.getParameter("max_over_bookings")==null?"":request.getParameter("max_over_bookings")));
			tabdata.put("p_break_time_intervals",(request.getParameter("ftotstr")==null?"":request.getParameter("ftotstr")));
			tabdata.put("added_facility_id",facilityId); 
			tabdata.put("modified_at_ws_no",ws_no);
			tabdata.put("modified_date",new java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_by_id",uid);
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("resource_Type",resource_Type);
			tabdata.put("location_Type",location_Type);
			tabdata.put("schedule_extend_yn",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			tabdata.put("ext_all_slots_yn",ext_all_slots_yn);
			tabdata.put("ext_start_slots",ext_start_slots);
			tabdata.put("ext_mid_slots",ext_mid_slots);
			tabdata.put("ext_end_slots",ext_end_slots);

			tabdata.put("final_string",final_string);
			tabdata.put("max_new_patients",(request.getParameter("max_new_patients")==null?"0":request.getParameter("max_new_patients")));
			tabdata.put("max_old_patients",(request.getParameter("max_old_patients")==null?"0":request.getParameter("max_old_patients")));



System.out.println("SetUpDailyScheduleServlet modifySetUpDailySchedule tabdata :"+tabdata.toString());
			if (final_string.equals(""))
			{
				alcncriteria = "";
				
			}
			tabdata.put("alcn_criteria",alcncriteria);
			

			tabdata.put("p_max_other_visits",(request.getParameter("max_other_visits")==null?"":request.getParameter("max_other_visits")));
			tabdata.put("p_max_slots_per_day",(request.getParameter("b_max_slots_per_day")==null?"":request.getParameter("b_max_slots_per_day")));

			String insert_detail = request.getParameter("insert_detail");
			if (insert_detail==null)insert_detail="";
			String final_values = request.getParameter("final_values");
			if (final_values==null)final_values="";
			String allocation_changed = request.getParameter("allocation_changed");
			if (allocation_changed==null)allocation_changed="";
			if ((!insert_detail.equals("Y")) && (allocation_changed.equals("Y")))
			{
				insert_detail ="A";
				final_values  = request.getParameter("final_string");
				if (final_values==null||final_values=="")final_values="";
				else
					final_values = final_values+"|";
			}
			

			if (final_values.equals("|")) final_values="";
			tabdata.put("p_insert_detail",insert_detail);
			tabdata.put("p_final_values",final_values);
			String forced_book_YN=request.getParameter("forced_book_YN");
			String no_of_forced_booking=request.getParameter("no_of_forced_booking");
			String no_of_global_booking=request.getParameter("no_of_global_booking");

			if(forced_book_YN==null || forced_book_YN.equals("")){
				forced_book_YN="N";
			}else{
				forced_book_YN="Y";
			}

			if(no_of_forced_booking==null || no_of_forced_booking.equals("")){
				no_of_forced_booking="0";
			}

			if(no_of_global_booking==null || no_of_global_booking.equals("")){
				no_of_global_booking="0";
			}


			tabdata.put("resourceType",(request.getParameter("resourceType")==null?"":request.getParameter("resourceType")));
			tabdata.put("forced_book_YN",forced_book_YN);
			tabdata.put("no_of_forced_booking",no_of_forced_booking);
			tabdata.put("no_of_global_booking",no_of_global_booking);
			tabdata.put("visit_limit_rule",(request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule")));

			
				
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SetUpDailySchedule",SetUpDailyScheduleHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;

				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();

java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifySetUpDailySchedule",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
                
				if ( inserted )
				{
					error_value = "1" ;
					error = (String) results.get("ResultFromMessageManager") ;
				}
                

			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");
			results.clear();
			tabdata.clear();

			
		}
        catch(Exception e )
        {
			//out.println("Error In Servlet:"+e.toString());
			e.printStackTrace();
        }
  }


    private void deleteSetUpDailySchedule(HttpServletRequest request, HttpServletResponse res){
		try{
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String clinic_date=request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
			clinic_date=DateUtils.convertDate(clinic_date,"DMY",locale,"en");
			HashMap tabdata = new HashMap() ;
			tabdata.put("clinic_code",(request.getParameter("location")==null?"":request.getParameter("location")));
			tabdata.put("clinic_date",clinic_date);
			tabdata.put("p_practitioner_id",(request.getParameter("practitioner")==null?"":request.getParameter("practitioner")));
			tabdata.put("facilityId",facilityId);
			tabdata.put("alcn_criteria",alcncriteria);			
			tabdata.put("resource_Type",resource_Type);
			tabdata.put("location_Type",location_Type);
			tabdata.put("visit_limit_rule",(request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule")));
			tabdata.put("time_table_type",(request.getParameter("time_table_type")==null?"":request.getParameter("time_table_type")));
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SetUpDailySchedule",SetUpDailyScheduleHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;
			Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteSetUpDailySchedule",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if(inserted){
				error_value = "1" ;
				error = (String) results.get("ResultFromMessageManager") ;
			}
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");
			results.clear();				
			tabdata.clear();
		}catch(Exception e ){
			//out.println("Error In Servlet:"+e.toString());
			e.printStackTrace();
		}
	}

}
 
