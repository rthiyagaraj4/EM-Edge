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
import eCommon.Common.*;
import webbeans.eCommon.*;
import  eCommon.SingleTableHandler.*;
import  eRS.RSShiftPattern.*;

public class ShiftPatternServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;

	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";

	String shift_pattern_id = "";
	String short_desc = "";
	String long_desc= "";
	String locn_type="";
	String eff_status="";
	String week_no="";
	String day_no = "";
	String shift_code = "";
	String shift_mnemonic= "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";
	String locale				="";
	int week_count =0;
	int day_count=0;
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}
	/**************************************************/

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");
		

		try{
			
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			String mode = request.getParameter("mode");
			if ( mode.equals("1")) insert(request, response);
			if ( mode.equals("2")) modify(request, response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		try{

			String query1 = "insert into rs_shift_pattern (facility_id,shift_pattern_id,long_desc,short_desc,locn_type,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String query2 = "insert into rs_shift_pattern_dtl (facility_id,shift_pattern_id,week_no,day_no,shift_code,shift_mnemonic,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String dupchk1="select count(*) count from rs_shift_pattern where shift_pattern_id =? and facility_id =?";
			String dupchk2="select count(*) count from rs_shift_pattern_dtl where facility_id =? and shift_pattern_id =? and week_no=? and day_no=?";

			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap insertData = new HashMap() ;
			HashMap insertData1 = new HashMap() ;
					
			added_by_id 	= p.getProperty( "login_user" ) ;
			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = facility_id ;
			locale = locale ;

			shift_pattern_id = request.getParameter("shift_pattern_id")==null ? "":request.getParameter("shift_pattern_id");
			short_desc = request.getParameter("shift_short_desc")==null ? "":request.getParameter("shift_short_desc");
			long_desc = request.getParameter("shift_short_desc")==null ? "":request.getParameter("shift_long_desc");
			locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			tabData.put("facility_id",facility_id);
			tabData.put("shift_pattern_id",shift_pattern_id);
			insertData.put("long_desc",long_desc);
			insertData.put("short_desc",short_desc);
			insertData.put("locn_type",locn_type);
			insertData.put("eff_status",eff_status);
			insertData.put("locale",locale);
			tabData.put( "InsertData1",insertData);
			
			week_count=Integer.parseInt((String)request.getParameter("week_count"));
			day_count=Integer.parseInt((String)request.getParameter("day_count"));
			tabData.put("week_count",String.valueOf(week_count));
			tabData.put("day_count",String.valueOf(day_count));

			for(int i=0;i<week_count;i++){

				HashMap insertData2 = new HashMap() ;
				week_no=String.valueOf(i);

				for(int j=0;j<day_count;j++){
					ArrayList shift	 = new	 ArrayList();
					day_no=request.getParameter(("day_no"+i+j))==null ? "":request.getParameter(("day_no"+i+j));
					shift_code=request.getParameter(("shift_code"+i+j))==null ? "":request.getParameter(("shift_code"+i+j));
					shift_mnemonic=request.getParameter(("shift_mnemonic"+i+j))==null ? "":request.getParameter(("shift_mnemonic"+i+j));

					if((shift_mnemonic.equals(""))||(shift_mnemonic==null))
		   				continue;
					shift.add(shift_code);
					shift.add(shift_mnemonic);
					insertData2.put(day_no,shift);
			}
			
			if(!insertData2.isEmpty())
				insertData1.put(week_no,insertData2);
			}

			tabData.put("InsertData2",insertData1);
			tabData.put("added_by_id",added_by_id);
			tabData.put("added_at_ws_no",added_at_ws_no);
			tabData.put("added_facility_id",added_facility_id);
			tabData.put("modified_by_id",modified_by_id);
			tabData.put("modified_at_ws_no",modified_at_ws_no);
			tabData.put("modified_facility_id",modified_facility_id);
			tabData.put("locale",locale);

			sqlMap.put("InsertSQL1",query1);
			sqlMap.put("InsertSQL2",query2 );
			sqlMap.put("DupchkSQL1",dupchk1 );
			sqlMap.put("DupchkSQL2",dupchk2 );
			tabData.put("properties", p);
	
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSShiftPattern", eRS.RSShiftPattern.RSShiftPatternLocalHome.class, local_ejbs);

			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			String err_num="";

			if(result.equals("true")){
				error_value ="1";
			}
			else{
				error_value="0";
			}
			err_num=(String)map.get("message");
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/*****************************************************************/

	public void modify(HttpServletRequest request,HttpServletResponse response)	throws Exception{

		try{
			String UpdateSql1 = "update rs_shift_pattern set long_desc=?,short_desc=?,locn_type=?,eff_status=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where facility_id=? and shift_pattern_id=?";
			String InsertSql1 = "insert into rs_shift_pattern_dtl (facility_id,shift_pattern_id,week_no,day_no,shift_code,shift_mnemonic,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String UpdateSql2 = "update rs_shift_pattern_dtl set shift_code=?,shift_mnemonic=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where facility_id=? and shift_pattern_id=? and week_no=? and day_no=?";
			String DeleteSql1 = "delete from rs_shift_pattern_dtl where  facility_id=? and shift_pattern_id=? and week_no=? and day_no=?";

			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap UpdateData = new HashMap() ;
			HashMap UpdateData1 = new HashMap() ;
					
			added_by_id 	= p.getProperty( "login_user" ) ;
			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = facility_id ;
			//locale = locale ;

			shift_pattern_id = request.getParameter("shift_pattern_id")==null ? "":request.getParameter("shift_pattern_id");
			short_desc = request.getParameter("shift_short_desc")==null ? "":request.getParameter("shift_short_desc");
			long_desc = request.getParameter("shift_long_desc")==null ? "":request.getParameter("shift_long_desc");
			locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			eff_status = request.getParameter("eff_status")==null ? "D":request.getParameter("eff_status");

			tabData.put("facility_id",facility_id);
			tabData.put("shift_pattern_id",shift_pattern_id);
			UpdateData.put("long_desc",long_desc);
			UpdateData.put("short_desc",short_desc);
			UpdateData.put("locn_type",locn_type);
			UpdateData.put("eff_status",eff_status);
			tabData.put( "UpdateData1",UpdateData);

			week_count=Integer.parseInt((String)request.getParameter("week_count"));
			day_count=Integer.parseInt((String)request.getParameter("day_count"));
			tabData.put("week_count",String.valueOf(week_count));
			tabData.put("day_count",String.valueOf(day_count));

			for(int i=0;i<week_count;i++){

				HashMap UpdateData2 = new HashMap() ;
				week_no=String.valueOf(i);
				for(int j=0;j<day_count;j++){

					ArrayList shift	 = new	 ArrayList();
					day_no=request.getParameter(("day_no"+i+j))==null ? "":request.getParameter(("day_no"+i+j));
					shift_code=request.getParameter(("shift_code"+i+j))==null ? "":request.getParameter(("shift_code"+i+j));
					shift_mnemonic=request.getParameter(("shift_mnemonic"+i+j))==null ? "":request.getParameter(("shift_mnemonic"+i+j));
					String update=request.getParameter(("update"+i+j))==null ? "":request.getParameter(("update"+i+j));

					if((shift_mnemonic.equals(""))||(shift_mnemonic==null))
						continue;
					shift.add(shift_code);
					shift.add(shift_mnemonic);
					shift.add(update);
					UpdateData2.put(day_no,shift);
			}
			if(!UpdateData2.isEmpty())
				UpdateData1.put(week_no,UpdateData2);
			}

			tabData.put("UpdateData2",UpdateData1);
			tabData.put("added_by_id",added_by_id);
			tabData.put("added_at_ws_no",added_at_ws_no);
			tabData.put("added_facility_id",added_facility_id);
			tabData.put("modified_by_id",modified_by_id);
			tabData.put("modified_at_ws_no",modified_at_ws_no);
			tabData.put("modified_facility_id",modified_facility_id);
			tabData.put("locale",locale);
			tabData.put("properties", p);

			sqlMap.put("UpdateSQL1",UpdateSql1 );
			sqlMap.put("UpdateSQL2",UpdateSql2 );
			sqlMap.put("InsertSQL1",InsertSql1 );
			sqlMap.put("DeleteSql1",DeleteSql1 );

		/*	RSShiftPatternHome home = null;
			RSShiftPatternRemote remote = null;
			InitialContext context = new InitialContext() ;

			Object object = context.lookup("java:comp/env/ejb/eRS/RSShiftPattern");
			home = (RSShiftPatternHome) PortableRemoteObject.narrow( object, RSShiftPatternHome.class ) ;
			remote = home.create() ;

			HashMap map = remote.modify(tabData, sqlMap ) ;
		*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSShiftPattern", eRS.RSShiftPattern.RSShiftPatternLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			String err_num="";
			if(result.equals("true")){
				error_value ="1";
			}
			else{
				error_value="0";
			}
			err_num=(String)map.get("message");
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
