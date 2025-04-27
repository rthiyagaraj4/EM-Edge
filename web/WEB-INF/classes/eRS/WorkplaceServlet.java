/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTableHandler.*;

public class WorkplaceServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;
	PrintWriter out = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String err_num="";
	String error_value="0";
	String locale="";
	private String locn_type = "";
	private String workplace_code = "";
	private String workplace_desc = "";
	
	private String wday_from_time = "";
	private String wday_to_time = "";
	private String nwday_from_time = "";
	private String nwday_to_time = "";
	private String hday_from_time = "";
	private String hday_to_time = "";

	private String wday_from_hh = "";
	private String wday_from_mm = "";
	private String wday_to_hh = "";
	private String wday_to_mm = "";
	private String nwday_from_hh = "";
	private String nwday_from_mm = "";
	private String nwday_to_hh = "";
	private String nwday_to_mm = "";
	private String hday_from_hh = "";
	private String hday_from_mm = "";
	private String hday_to_hh = "";
	private String hday_to_mm = "";
	private String staff_util = "";
	private String work_cycle_basis = "";
	private String eff_status = "";
	private String facility_id1 = "";

	private String week_1_day_1 = "";
	private String week_1_day_2 = "";
	private String week_1_day_3 = "";
	private String week_1_day_4 = "";
	private String week_1_day_5 = "";
	private String week_1_day_6 = "";
	private String week_1_day_7 = "";

	private String week_2_day_1 = "";
	private String week_2_day_2 = "";
	private String week_2_day_3 = "";
	private String week_2_day_4 = "";
	private String week_2_day_5 = "";
	private String week_2_day_6 = "";
	private String week_2_day_7 = "";

	private String week_3_day_1 = "";
	private String week_3_day_2 = "";
	private String week_3_day_3 = "";
	private String week_3_day_4 = "";
	private String week_3_day_5 = "";
	private String week_3_day_6 = "";
	private String week_3_day_7 = "";

	private String week_4_day_1 = "";
	private String week_4_day_2 = "";
	private String week_4_day_3 = "";
	private String week_4_day_4 = "";
	private String week_4_day_5 = "";
	private String week_4_day_6 = "";
	private String week_4_day_7 = "";

	private String week_5_day_1 = "";
	private String week_5_day_2 = "";
	private String week_5_day_3 = "";
	private String week_5_day_4 = "";
	private String week_5_day_5 = "";
	private String week_5_day_6 = "";
	private String week_5_day_7 = "";

	String added_by_id = "";
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	/*************************************************************************/

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		locale = (String) session.getAttribute( "LOCALE" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		

		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			String mode = request.getParameter("mode");
			if ( mode.equals("1")) insert(request, response);
			if ( mode.equals("2")) modify(request, response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	
	{
		this.out = response.getWriter();
		response.setContentType("text/html");
		doPost(request,response);
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	
			ArrayList insertData = new ArrayList() ;
			ArrayList whereData = new ArrayList() ;
			HashMap tabData = new HashMap() ;
			HashMap sqlMap = new HashMap() ;
			HashMap map			= new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;

			added_by_id 	= p.getProperty( "login_user" ) ;

			String query = "insert into rs_workplace(facility_id,workplace_code,workplace_desc,locn_type,working_day_start_time,working_day_end_time,nonworking_day_start_time,nonworking_day_end_time,holiday_start_time,holiday_end_time,staff_util_review_opt,work_cycle_basis,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,week_1_day_1,week_1_day_2,week_1_day_3,week_1_day_4,week_1_day_5,week_1_day_6,week_1_day_7,week_2_day_1,week_2_day_2,week_2_day_3,week_2_day_4,week_2_day_5,week_2_day_6,week_2_day_7,week_3_day_1,week_3_day_2,week_3_day_3,week_3_day_4,week_3_day_5,week_3_day_6,week_3_day_7,week_4_day_1,week_4_day_2,week_4_day_3,week_4_day_4,week_4_day_5,week_4_day_6,week_4_day_7,week_5_day_1,week_5_day_2,week_5_day_3,week_5_day_4,week_5_day_5,week_5_day_6,week_5_day_7)values(?,?,?,?,		to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String query_dup="SELECT COUNT(*)FROM RS_WORKPLACE WHERE workplace_code = (?)";

			workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
					
			facility_id1 = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
	        workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			workplace_desc = request.getParameter("workplace_desc")==null ? "":request.getParameter("workplace_desc");
			locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			
			wday_from_hh = request.getParameter("wday_from_hh")==null ? "":request.getParameter("wday_from_hh");
			wday_from_mm = request.getParameter("wday_from_mm")==null ? "":request.getParameter("wday_from_mm");
            wday_to_hh = request.getParameter("wday_to_hh")==null ? "":request.getParameter("wday_to_hh");
			wday_to_mm = request.getParameter("wday_to_mm")==null ? "":request.getParameter("wday_to_mm");
			
			nwday_from_hh = request.getParameter("nwday_from_hh")==null ? "":request.getParameter("nwday_from_hh");
			nwday_from_mm = request.getParameter("nwday_from_mm")==null ? "":request.getParameter("nwday_from_mm");
			nwday_to_hh = request.getParameter("nwday_to_hh")==null ? "":request.getParameter("nwday_to_hh");
			nwday_to_mm = request.getParameter("nwday_to_mm")==null ? "":request.getParameter("nwday_to_mm");
			
			hday_from_hh = request.getParameter("hday_from_hh")==null ? "":request.getParameter("hday_from_hh");
			hday_from_mm = request.getParameter("hday_from_mm")==null ? "":request.getParameter("hday_from_mm");
			hday_to_hh = request.getParameter("hday_to_hh")==null ? "":request.getParameter("hday_to_hh");
			hday_to_mm = request.getParameter("hday_to_mm")==null ? "":request.getParameter("hday_to_mm");
			
			staff_util = request.getParameter("staff_util")==null ? "":request.getParameter("staff_util");
			work_cycle_basis = request.getParameter("work_cycle_basis")==null ? "":request.getParameter("work_cycle_basis");
			eff_status = request.getParameter("eff_status")==null ? "":request.getParameter("eff_status");

			if(!(wday_from_hh.equals("") || wday_from_mm.equals("")))
			{
				wday_from_time	 =	 wday_from_hh+":"+wday_from_mm;
				wday_from_time	 =	 com.ehis.util.DateUtils.convertDate(wday_from_time,"HM",locale,"en");
			}

			if(!wday_from_time.equals("")){
				if(!(wday_to_hh.equals("") || wday_to_mm.equals("")))
				{
					wday_to_time	=	wday_to_hh+":"+wday_to_mm;
					wday_to_time	 =	 com.ehis.util.DateUtils.convertDate(wday_to_time,"HM",locale,"en");
				}
			}
			
			if(!(nwday_from_hh.equals("") || nwday_from_mm.equals("")))
			{
				nwday_from_time	=	nwday_from_hh+":"+nwday_from_mm;
				nwday_from_time	 =	 com.ehis.util.DateUtils.convertDate(nwday_from_time,"HM",locale,"en");
			}

			if(!nwday_from_time.equals("")){
				if(!(nwday_to_hh.equals("") || nwday_to_mm.equals("")))
				{
					nwday_to_time	=	nwday_to_hh+":"+nwday_to_mm;
					nwday_to_time	 =	 com.ehis.util.DateUtils.convertDate(nwday_to_time,"HM",locale,"en");
				}
			}
			
			if(!(hday_from_hh.equals("") || hday_from_mm.equals("")))
			{
				hday_from_time	=	hday_from_hh+":"+hday_from_mm;
				hday_from_time	 =	 com.ehis.util.DateUtils.convertDate(hday_from_time,"HM",locale,"en");
			}
			if(!hday_from_time.equals("")){
				if(!(hday_to_hh.equals("") || hday_to_mm.equals("")))
				{
					hday_to_time	=	hday_to_hh+":"+hday_to_mm;
					hday_to_time	 =	 com.ehis.util.DateUtils.convertDate(hday_to_time,"HM",locale,"en");
				}
			}
			
			if(eff_status.equalsIgnoreCase("on"))
				eff_status = "E";
			else
				eff_status = "D";

			week_1_day_1 = request.getParameter("week_1_day_1")==null ? "":request.getParameter("week_1_day_1");
			week_1_day_2 = request.getParameter("week_1_day_2")==null ? "":request.getParameter("week_1_day_2");
			week_1_day_3 = request.getParameter("week_1_day_3")==null ? "":request.getParameter("week_1_day_3");
			week_1_day_4 = request.getParameter("week_1_day_4")==null ? "":request.getParameter("week_1_day_4");
			week_1_day_5 = request.getParameter("week_1_day_5")==null ? "":request.getParameter("week_1_day_5");
			week_1_day_6 = request.getParameter("week_1_day_6")==null ? "":request.getParameter("week_1_day_6");
			week_1_day_7 = request.getParameter("week_1_day_7")==null ? "":request.getParameter("week_1_day_7");

			week_2_day_1 = request.getParameter("week_2_day_1")==null ? "":request.getParameter("week_2_day_1");
			week_2_day_2 = request.getParameter("week_2_day_2")==null ? "":request.getParameter("week_2_day_2");
			week_2_day_3 = request.getParameter("week_2_day_3")==null ? "":request.getParameter("week_2_day_3");
			week_2_day_4 = request.getParameter("week_2_day_4")==null ? "":request.getParameter("week_2_day_4");
			week_2_day_5 = request.getParameter("week_2_day_5")==null ? "":request.getParameter("week_2_day_5");
			week_2_day_6 = request.getParameter("week_2_day_6")==null ? "":request.getParameter("week_2_day_6");
			week_2_day_7 = request.getParameter("week_2_day_7")==null ? "":request.getParameter("week_2_day_7");

			week_3_day_1 = request.getParameter("week_3_day_1")==null ? "":request.getParameter("week_3_day_1");
			week_3_day_2 = request.getParameter("week_3_day_2")==null ? "":request.getParameter("week_3_day_2");
			week_3_day_3 = request.getParameter("week_3_day_3")==null ? "":request.getParameter("week_3_day_3");
			week_3_day_4 = request.getParameter("week_3_day_4")==null ? "":request.getParameter("week_3_day_4");
			week_3_day_5 = request.getParameter("week_3_day_5")==null ? "":request.getParameter("week_3_day_5");
			week_3_day_6 = request.getParameter("week_3_day_6")==null ? "":request.getParameter("week_3_day_6");
			week_3_day_7 = request.getParameter("week_3_day_7")==null ? "":request.getParameter("week_3_day_7");

			week_4_day_1 = request.getParameter("week_4_day_1")==null ? "":request.getParameter("week_4_day_1");
			week_4_day_2 = request.getParameter("week_4_day_2")==null ? "":request.getParameter("week_4_day_2");
			week_4_day_3 = request.getParameter("week_4_day_3")==null ? "":request.getParameter("week_4_day_3");
			week_4_day_4 = request.getParameter("week_4_day_4")==null ? "":request.getParameter("week_4_day_4");
			week_4_day_5 = request.getParameter("week_4_day_5")==null ? "":request.getParameter("week_4_day_5");
			week_4_day_6 = request.getParameter("week_4_day_6")==null ? "":request.getParameter("week_4_day_6");
			week_4_day_7 = request.getParameter("week_4_day_7")==null ? "":request.getParameter("week_4_day_7");
			
			week_5_day_1 = request.getParameter("week_5_day_1")==null ? "":request.getParameter("week_5_day_1");
			week_5_day_2 = request.getParameter("week_5_day_2")==null ? "":request.getParameter("week_5_day_2");
			week_5_day_3 = request.getParameter("week_5_day_3")==null ? "":request.getParameter("week_5_day_3");
			week_5_day_4 = request.getParameter("week_5_day_4")==null ? "":request.getParameter("week_5_day_4");
			week_5_day_5 = request.getParameter("week_5_day_5")==null ? "":request.getParameter("week_5_day_5");
			week_5_day_6 = request.getParameter("week_5_day_6")==null ? "":request.getParameter("week_5_day_6");
			week_5_day_7 = request.getParameter("week_5_day_7")==null ? "":request.getParameter("week_5_day_7");
			
    		whereData.add(workplace_code) ;	
			insertData.add(facility_id1.trim());
			insertData.add(workplace_code.trim());
			insertData.add(workplace_desc.trim());
			insertData.add(locn_type.trim());
			insertData.add(wday_from_time);
			insertData.add(wday_to_time);
		    insertData.add(nwday_from_time);
			insertData.add(nwday_to_time);
			insertData.add(hday_from_time);
			insertData.add(hday_to_time);
			
			insertData.add(staff_util.trim());
	     	insertData.add(work_cycle_basis.trim());
	        insertData.add(eff_status.trim());

	     	insertData.add(added_by_id.trim());
			insertData.add(client_ip_address.trim());
			insertData.add(facility_id.trim());
			insertData.add(added_by_id.trim());
			insertData.add(client_ip_address.trim());
			insertData.add(facility_id.trim());

			insertData.add(week_1_day_1.trim());
			insertData.add(week_1_day_2.trim());
			insertData.add(week_1_day_3.trim());
			insertData.add(week_1_day_4.trim());
			insertData.add(week_1_day_5.trim());
			insertData.add(week_1_day_6.trim());
			insertData.add(week_1_day_7.trim());

			insertData.add(week_2_day_1.trim());
			insertData.add(week_2_day_2.trim());
			insertData.add(week_2_day_3.trim());
			insertData.add(week_2_day_4.trim());
			insertData.add(week_2_day_5.trim());
			insertData.add(week_2_day_6.trim());
			insertData.add(week_2_day_7.trim());
			
			insertData.add(week_3_day_1.trim());
			insertData.add(week_3_day_2.trim());
			insertData.add(week_3_day_3.trim());
			insertData.add(week_3_day_4.trim());
			insertData.add(week_3_day_5.trim());
			insertData.add(week_3_day_6.trim());
			insertData.add(week_3_day_7.trim());

			insertData.add(week_4_day_1.trim());
			insertData.add(week_4_day_2.trim());
			insertData.add(week_4_day_3.trim());
			insertData.add(week_4_day_4.trim());
			insertData.add(week_4_day_5.trim());
			insertData.add(week_4_day_6.trim());
			insertData.add(week_4_day_7.trim());

			insertData.add(week_5_day_1.trim());
			insertData.add(week_5_day_2.trim());
			insertData.add(week_5_day_3.trim());
			insertData.add(week_5_day_4.trim());
			insertData.add(week_5_day_5.trim());
			insertData.add(week_5_day_6.trim());
			insertData.add(week_5_day_7.trim());


			tabData.put( "InsertData", insertData);
			tabData.put( "properties",	p ) ;
			sqlMap.put( "InsertSQL",query);
			sqlMap.put( "SelectSQL",query_dup);
			tabData.put( "WhereData",whereData);

			if(!(tabData.isEmpty()) && !(sqlMap.isEmpty()))
			{
				try 
				{
					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =tabData;
					argArray[1] =sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] =tabData.getClass();
					paramArray[1] =sqlMap.getClass();

					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					//System.out.println("map---------->"+map);
					if( ((Boolean) map.get( "result" )).booleanValue() ){
						
						String result = ((Boolean)map.get("result")).toString();
						if(result.equals("true")){
							error_value ="1";
							err_num= "APP-SM0002 Operation Completed Successfully ....";
						}
					}
					else{
			
						if(((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS")){
							err_num = "APP-002005 Record Already Exists... ";
							error_value="1";
						}
						else{
							map.put( "message", (map.get("msgid"))) ;
							err_num = "Exception Occured... "+ (String)map.get("msgid");
							error_value="0";
						}
					}
				}
				catch(Exception e) {
					map.put( "message", e.getMessage()) ;
					e.printStackTrace() ;
				} 
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
			}
			
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
		}
	} // End insert

  public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{	

			ArrayList insertData = new ArrayList() ;
			HashMap tabData = new HashMap() ;
			HashMap sqlMap = new HashMap() ;
			HashMap map			= new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;

			added_by_id 	= p.getProperty( "login_user" ) ;

			String query = "update rs_workplace set facility_id = ?,workplace_code = ?,workplace_desc = ?,locn_type = ?,working_day_start_time = to_date(?,'hh24:mi'),working_day_end_time = to_date(?,'hh24:mi') ,nonworking_day_start_time = to_date(?,'hh24:mi') ,nonworking_day_end_time =to_date(?,'hh24:mi') ,holiday_start_time = to_date(?,'hh24:mi') ,holiday_end_time = to_date(?,'hh24:mi') ,staff_util_review_opt = ? ,work_cycle_basis = ?,eff_status = ?,added_by_id = ?,added_date = sysdate,added_at_ws_no = ?,added_facility_id = ?,modified_by_id=?,modified_date = sysdate,modified_at_ws_no=?,modified_facility_id=?,week_1_day_1=?,week_1_day_2=?,week_1_day_3=?,week_1_day_4=?,week_1_day_5=?,week_1_day_6=?,week_1_day_7=?,week_2_day_1=?,week_2_day_2=?,week_2_day_3=?,week_2_day_4=?,week_2_day_5=?,week_2_day_6=?,week_2_day_7=?,week_3_day_1=?,week_3_day_2=?,week_3_day_3=?,week_3_day_4=?,week_3_day_5=?,week_3_day_6=?,week_3_day_7=?,week_4_day_1=?,week_4_day_2=?,week_4_day_3=?,week_4_day_4=?,week_4_day_5=?,week_4_day_6=?,week_4_day_7=?,week_5_day_1=?,week_5_day_2=?,week_5_day_3=?,week_5_day_4=?,week_5_day_5=?,week_5_day_6=?,week_5_day_7 = ? where  workplace_code = ?";

			workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			
			facility_id1 = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
	        workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			workplace_desc = request.getParameter("workplace_desc")==null ? "":request.getParameter("workplace_desc");
			locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			
			wday_from_hh = request.getParameter("wday_from_hh")==null ? "":request.getParameter("wday_from_hh");
			wday_from_mm = request.getParameter("wday_from_mm")==null ? "":request.getParameter("wday_from_mm");
            wday_to_hh = request.getParameter("wday_to_hh")==null ? "":request.getParameter("wday_to_hh");
			wday_to_mm = request.getParameter("wday_to_mm")==null ? "":request.getParameter("wday_to_mm");
			
			nwday_from_hh = request.getParameter("nwday_from_hh")==null ? "":request.getParameter("nwday_from_hh");
			nwday_from_mm = request.getParameter("nwday_from_mm")==null ? "":request.getParameter("nwday_from_mm");
			nwday_to_hh = request.getParameter("nwday_to_hh")==null ? "":request.getParameter("nwday_to_hh");
			nwday_to_mm = request.getParameter("nwday_to_mm")==null ? "":request.getParameter("nwday_to_mm");
			
			hday_from_hh = request.getParameter("hday_from_hh")==null ? "":request.getParameter("hday_from_hh");
			hday_from_mm = request.getParameter("hday_from_mm")==null ? "":request.getParameter("hday_from_mm");
			hday_to_hh = request.getParameter("hday_to_hh")==null ? "":request.getParameter("hday_to_hh");
			hday_to_mm = request.getParameter("hday_to_mm")==null ? "":request.getParameter("hday_to_mm");
			
			staff_util = request.getParameter("staff_util")==null ? "":request.getParameter("staff_util");
			work_cycle_basis = request.getParameter("work_cycle_basis")==null ? "":request.getParameter("work_cycle_basis");
			eff_status = request.getParameter("eff_status")==null ? "":request.getParameter("eff_status");

			if(!(wday_from_hh.equals("") || wday_from_mm.equals("")))
			{
				wday_from_time	 =	 wday_from_hh+":"+wday_from_mm;
				wday_from_time	 =	 com.ehis.util.DateUtils.convertDate(wday_from_time,"HM",locale,"en");
			}

			if(!wday_from_time.equals("")){
				if(!(wday_to_hh.equals("") || wday_to_mm.equals("")))
				{
					wday_to_time	=	wday_to_hh+":"+wday_to_mm;
					wday_to_time	 =	 com.ehis.util.DateUtils.convertDate(wday_to_time,"HM",locale,"en");
				}
			}
			
			if(!(nwday_from_hh.equals("")||nwday_from_mm.equals("")))
			{
				nwday_from_time	=	nwday_from_hh+":"+nwday_from_mm;
				nwday_from_time	 =	 com.ehis.util.DateUtils.convertDate(nwday_from_time,"HM",locale,"en");
			}

			if(!nwday_from_time.equals("")){
				if(!(nwday_to_hh.equals("") || nwday_to_mm.equals("")))
				{
					nwday_to_time	=	nwday_to_hh+":"+nwday_to_mm;
					nwday_to_time	 =	 com.ehis.util.DateUtils.convertDate(nwday_to_time,"HM",locale,"en");
				}
			}
			
			if(!(hday_from_hh.equals("") || hday_from_mm.equals("")))
			{
				hday_from_time	=	hday_from_hh+":"+hday_from_mm;
				hday_from_time	 =	 com.ehis.util.DateUtils.convertDate(hday_from_time,"HM",locale,"en");
			}
			if(!hday_from_time.equals("")){
				if(!(hday_to_hh.equals("") || hday_to_mm.equals("")))
				{
					hday_to_time	=	hday_to_hh+":"+hday_to_mm;
					hday_to_time	 =	 com.ehis.util.DateUtils.convertDate(hday_to_time,"HM",locale,"en");
				}
			}
			
			if(eff_status.equalsIgnoreCase("on"))
			eff_status = "E";
			else
			eff_status = "D";

			week_1_day_1 = request.getParameter("mweek_1_day_1")==null ? "":request.getParameter("mweek_1_day_1");
			week_1_day_2 = request.getParameter("mweek_1_day_2")==null ? "":request.getParameter("mweek_1_day_2");
			week_1_day_3 = request.getParameter("mweek_1_day_3")==null ? "":request.getParameter("mweek_1_day_3");
			week_1_day_4 = request.getParameter("mweek_1_day_4")==null ? "":request.getParameter("mweek_1_day_4");
			week_1_day_5 = request.getParameter("mweek_1_day_5")==null ? "":request.getParameter("mweek_1_day_5");
			week_1_day_6 = request.getParameter("mweek_1_day_6")==null ? "":request.getParameter("mweek_1_day_6");
			week_1_day_7 = request.getParameter("mweek_1_day_7")==null ? "":request.getParameter("mweek_1_day_7");

			week_2_day_1 = request.getParameter("mweek_2_day_1")==null ? "":request.getParameter("mweek_2_day_1");
			week_2_day_2 = request.getParameter("mweek_2_day_2")==null ? "":request.getParameter("mweek_2_day_2");
			week_2_day_3 = request.getParameter("mweek_2_day_3")==null ? "":request.getParameter("mweek_2_day_3");
			week_2_day_4 = request.getParameter("mweek_2_day_4")==null ? "":request.getParameter("mweek_2_day_4");
			week_2_day_5 = request.getParameter("mweek_2_day_5")==null ? "":request.getParameter("mweek_2_day_5");
			week_2_day_6 = request.getParameter("mweek_2_day_6")==null ? "":request.getParameter("mweek_2_day_6");
			week_2_day_7 = request.getParameter("mweek_2_day_7")==null ? "":request.getParameter("mweek_2_day_7");

			week_3_day_1 = request.getParameter("mweek_3_day_1")==null ? "":request.getParameter("mweek_3_day_1");
			week_3_day_2 = request.getParameter("mweek_3_day_2")==null ? "":request.getParameter("mweek_3_day_2");
			week_3_day_3 = request.getParameter("mweek_3_day_3")==null ? "":request.getParameter("mweek_3_day_3");
			week_3_day_4 = request.getParameter("mweek_3_day_4")==null ? "":request.getParameter("mweek_3_day_4");
			week_3_day_5 = request.getParameter("mweek_3_day_5")==null ? "":request.getParameter("mweek_3_day_5");
			week_3_day_6 = request.getParameter("mweek_3_day_6")==null ? "":request.getParameter("mweek_3_day_6");
			week_3_day_7 = request.getParameter("mweek_3_day_7")==null ? "":request.getParameter("mweek_3_day_7");

			week_4_day_1 = request.getParameter("mweek_4_day_1")==null ? "":request.getParameter("mweek_4_day_1");
			week_4_day_2 = request.getParameter("mweek_4_day_2")==null ? "":request.getParameter("mweek_4_day_2");
			week_4_day_3 = request.getParameter("mweek_4_day_3")==null ? "":request.getParameter("mweek_4_day_3");
			week_4_day_4 = request.getParameter("mweek_4_day_4")==null ? "":request.getParameter("mweek_4_day_4");
			week_4_day_5 = request.getParameter("mweek_4_day_5")==null ? "":request.getParameter("mweek_4_day_5");
			week_4_day_6 = request.getParameter("mweek_4_day_6")==null ? "":request.getParameter("mweek_4_day_6");
			week_4_day_7 = request.getParameter("mweek_4_day_7")==null ? "":request.getParameter("mweek_4_day_7");
			
			week_5_day_1 = request.getParameter("mweek_5_day_1")==null ? "":request.getParameter("mweek_5_day_1");
			week_5_day_2 = request.getParameter("mweek_5_day_2")==null ? "":request.getParameter("mweek_5_day_2");
			week_5_day_3 = request.getParameter("mweek_5_day_3")==null ? "":request.getParameter("mweek_5_day_3");
			week_5_day_4 = request.getParameter("mweek_5_day_4")==null ? "":request.getParameter("mweek_5_day_4");
			week_5_day_5 = request.getParameter("mweek_5_day_5")==null ? "":request.getParameter("mweek_5_day_5");
			week_5_day_6 = request.getParameter("mweek_5_day_6")==null ? "":request.getParameter("mweek_5_day_6");
			week_5_day_7 = request.getParameter("mweek_5_day_7")==null ? "":request.getParameter("mweek_5_day_7");
			
			
			insertData.add(facility_id1.trim());
			insertData.add(workplace_code.trim());
			insertData.add(workplace_desc.trim());
			insertData.add(locn_type.trim());
			insertData.add(wday_from_time);
			insertData.add(wday_to_time);
		    insertData.add(nwday_from_time);
			insertData.add(nwday_to_time);
			insertData.add(hday_from_time);
			insertData.add(hday_to_time);
			insertData.add(staff_util.trim());
	     	insertData.add(work_cycle_basis.trim());
	        insertData.add(eff_status.trim());
	     	insertData.add(added_by_id.trim());
			insertData.add(client_ip_address.trim());
			insertData.add(facility_id.trim());
			insertData.add(added_by_id.trim());
			insertData.add(client_ip_address.trim());
			insertData.add(facility_id.trim());

			insertData.add(week_1_day_1.trim());
			insertData.add(week_1_day_2.trim());
			insertData.add(week_1_day_3.trim());
			insertData.add(week_1_day_4.trim());
			insertData.add(week_1_day_5.trim());
			insertData.add(week_1_day_6.trim());
			insertData.add(week_1_day_7.trim());
			insertData.add(week_2_day_1.trim());
			insertData.add(week_2_day_2.trim());
			insertData.add(week_2_day_3.trim());
			insertData.add(week_2_day_4.trim());
			insertData.add(week_2_day_5.trim());
			insertData.add(week_2_day_6.trim());
			insertData.add(week_2_day_7.trim());
			insertData.add(week_3_day_1.trim());
			insertData.add(week_3_day_2.trim());
			insertData.add(week_3_day_3.trim());
			insertData.add(week_3_day_4.trim());
			insertData.add(week_3_day_5.trim());
			insertData.add(week_3_day_6.trim());
			insertData.add(week_3_day_7.trim());
			insertData.add(week_4_day_1.trim());
			insertData.add(week_4_day_2.trim());
			insertData.add(week_4_day_3.trim());
			insertData.add(week_4_day_4.trim());
			insertData.add(week_4_day_5.trim());
			insertData.add(week_4_day_6.trim());
			insertData.add(week_4_day_7.trim());
			insertData.add(week_5_day_1.trim());
			insertData.add(week_5_day_2.trim());
			insertData.add(week_5_day_3.trim());
			insertData.add(week_5_day_4.trim());
			insertData.add(week_5_day_5.trim());
			insertData.add(week_5_day_6.trim());
			insertData.add(week_5_day_7.trim());
			insertData.add(workplace_code.trim());
			tabData.put( "ModifyData", insertData);
			tabData.put( "properties",	p ) ;
			sqlMap.put( "ModifySQL",query);
         
           
			if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
				

				try {
					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
					if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =tabData;
					argArray[1] =sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] =tabData.getClass();
					paramArray[1] =sqlMap.getClass();
					
					map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

                   
					if( ((Boolean) map.get( "result" )).booleanValue() )	
					{
						
						String result = ((Boolean)map.get("result")).toString();
						if(result.equals("true"))
						{
						error_value ="1";
						err_num= "APP-SM0002 Operation Completed Successfully ....";
						}
					}
					else
					{
							map.put( "message", (map.get("msgid"))) ;
							err_num = "Exception Occured... "+ (String)map.get("msgid");
							error_value="0";
					
					}
				} catch(Exception e) {
					map.put( "message", e.getMessage()) ;
					e.printStackTrace() ;
				} 
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
			}
		
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
		}
	} // End modify
}		
