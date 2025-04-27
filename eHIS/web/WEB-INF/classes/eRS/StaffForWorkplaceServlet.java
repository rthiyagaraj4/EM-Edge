/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;
import java.io.* ;
import java.rmi.*;
import java.util.* ;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import javax.servlet.http.*;
import  eCommon.SingleTableHandler.*;

public class StaffForWorkplaceServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;

	PrintWriter out = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";
	String role_type = "";
	String chk_flag = "";
	String STAFF_TYPE = "";
	String eff_status = "";
	String eff_fr = "";
	String eff_to = "";
	String staff_id = "";
	String workplace_code = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String locale ="";
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
		locale=(String)session.getAttribute("LOCALE");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		
		
		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			out = response.getWriter();
			String mode = request.getParameter("mode");
			if(mode==null) mode ="";
					
			if (!mode.equals("2")) 
				forWorkPlace(request);
			else
				forStaff(request);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void forWorkPlace(HttpServletRequest request)throws Exception{		
		try{
			System.err.println("entering into servlet forworkplace");
			workplace_code = request.getParameter("workplace_code");
			System.err.println("workplace_code--->" +workplace_code);
			if(workplace_code==null) workplace_code ="";
			HashMap map=new HashMap();
			String sql_insert = "insert into rs_staff_for_workplace (facility_id,WORKPLACE_CODE,STAFF_TYPE,STAFF_ID,ROLE_TYPE,EFF_DATE_FROM, EFF_DATE_TO,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,eff_status) values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
			String sql_delete = "update  rs_staff_for_workplace set eff_status =? where facility_id=? and workplace_code=? and ROLE_TYPE=? and STAFF_ID=? and STAFF_TYPE=?";

			
			String sql_update="update rs_staff_for_workplace set  eff_status=?,EFF_DATE_FROM =?,EFF_DATE_TO=?,added_by_id=?,added_date=sysdate,added_at_ws_no=?,added_facility_id=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where facility_id=? and WORKPLACE_CODE=? and STAFF_ID =? and ROLE_TYPE=? ";

		
			String select_yn;
			String db_action;
			String totalRecords;
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
					
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			totalRecords=request.getParameter("record_Count");
			int record_Count = Integer.parseInt(totalRecords);
			System.err.println("record_Count--->" +record_Count+ "in servlet");
			/*****************************insert by Workplace*********************/

				java.sql.Date credit_doc_date_d = null;
					java.sql.Date credit_doc_date_d1 = null;
					String arr3[] ;
					String arr4[] ;
					StringTokenizer toks3 = null;
					StringTokenizer toks4 = null;


				for(int i=0; i<record_Count; i++){

					arr3 =new String[3] ; 
					arr4 =new String[3] ;
					STAFF_TYPE = request.getParameter("staff_type"+i)==null ? "":request.getParameter("staff_type"+i);
					eff_status = request.getParameter("eff_status"+i)==null ? "":request.getParameter("eff_status"+i);
					if(eff_status.equals("")) 
						eff_status ="D";							
					role_type	= request.getParameter("role_type"+i)==null ? "":request.getParameter("role_type"+i);
					staff_id		= request.getParameter("staff_id"+i)==null ? "":request.getParameter("staff_id"+i);
					eff_fr			= request.getParameter("eff_fro"+i)==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("eff_fro"+i),"DMY",locale,"en");
					eff_to			= request.getParameter("eff_to"+i)==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("eff_to"+i),"DMY",locale,"en");					
					select_yn	= request.getParameter("chkd"+i)==null ? "":request.getParameter("chkd"+i);
					db_action	= request.getParameter("db_action"+i)==null ? "":request.getParameter("db_action"+i);
					System.err.println("db_action in servlet 123--->" +db_action);
					if(select_yn==null ||select_yn.equals(""))
					{	System.err.println("chking if whnn select equals space and null");
						select_yn="N";
						System.err.println("select_yn-->" +select_yn);
					}
					if (db_action.equals("")||(db_action==null))
					{
						System.err.println("chking if whnn db_action equals space and null");
						select_yn="N";
						System.err.println("select_yn-->" +select_yn);
					}
					
					if(!eff_fr.equals("")){
						System.err.println("!eff_fr-->" );
						toks3 = new StringTokenizer (eff_fr,"/") ;
						for( int u=0;u<3;u++){
							 arr3[u] = toks3.nextToken() ;
						}
						String attend_dob = arr3[2]+"-"+arr3[1]+"-"+arr3[0];
						credit_doc_date_d = java.sql.Date.valueOf(attend_dob) ;
						System.err.println("attend_dob in servlet -->" +attend_dob);
						System.err.println("credit_doc_date_d in servlet -->" +credit_doc_date_d);
					}
					
					
					if(!eff_to.equals(""))	{
						System.err.println("!eff_to-->" );
						toks4 = new StringTokenizer (eff_to,"/") ;
						for( int l=0;l<3;l++){
							 arr4[l] = toks4.nextToken() ;
						}
						String attend_dob1 = arr4[2]+"-"+arr4[1]+"-"+arr4[0];
						credit_doc_date_d1 = java.sql.Date.valueOf(attend_dob1) ;
						System.err.println("attend_dob1 in servlet in 155-->" +attend_dob1);
						System.err.println("credit_doc_date_d in servlet 156-->" +credit_doc_date_d);

					}
					
					 if(db_action.equalsIgnoreCase("I")){
						 System.err.println("db_action in servlet ignorecase chkin");
					
						if(select_yn.equalsIgnoreCase("Y")){
							System.err.println("select_yn in servlet ignorecase chkin");
							if(eff_fr.equals("")){
								System.err.println("eff_fr in servlet equals('') chkin");
								error_value = "From Date cannot be Blank";
								out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");	
							}

							insertData.clear();
							tabData.clear();
							chk_flag ="Y";
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(STAFF_TYPE);
							insertData.add(staff_id);
							insertData.add(role_type);
							System.err.println("facility_id----|" +facility_id+ "|---workplace_code--|" +workplace_code+ "|--STAFF_TYPE--|" +STAFF_TYPE+ "|--staff_id--|" +staff_id+ "|--role_type--|" +role_type+ "|--");
							if(!eff_fr.equals("")){
								System.err.println("chking !eff_fr");
								insertData.add(credit_doc_date_d);
								System.err.println("credit_doc_date_d-->" +credit_doc_date_d);
							}
							

							if(!eff_to.equals(""))	{
								System.err.println("chking !eff_to");
								insertData.add(credit_doc_date_d1);
								System.err.println("credit_doc_date_d-->" +credit_doc_date_d);
							}else{
								insertData.add("");
								System.err.println("");
							}

							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							insertData.add(eff_status);
							System.err.println("added_by_id----|" +added_by_id+ "|---added_at_ws_no--|" +added_at_ws_no+ "|--added_facility_id--|" +added_facility_id+ "|--added_by_id--|" +added_by_id+ "|--added_at_ws_no--|" +added_at_ws_no+ "|--added_facility_id--|" +added_facility_id+ "|---eff_status--|" +eff_status+ "|--");
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							System.err.println("tabData in servlet--->" +tabData);
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_insert);
							}catch(Exception e){
								e.printStackTrace();
							}
						}else if (select_yn.equalsIgnoreCase("N")){
							System.err.println("chking Elseif condition in servlet");
							insertData.clear();
							tabData.clear();
							sqlMap.clear();
						}
					}else if(db_action.equalsIgnoreCase("U")){
						System.err.println("chcking db_action equals of ignorecase");
						if(select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							chk_flag ="Y";
							System.err.println("chk_flag--->" +chk_flag);
							insertData.add(eff_status);
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(role_type);
							insertData.add(staff_id);
							insertData.add(STAFF_TYPE);

							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p) ;
							System.err.println("dbction=='u'");
							System.err.println("facility_id----|" +facility_id+ "|---workplace_code--|" +workplace_code+ "|--STAFF_TYPE--|" +STAFF_TYPE+ "|--staff_id--|" +staff_id+ "|--role_type--|" +role_type+ "|--");
							System.err.println("tabData in servlet--->" +tabData);
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_delete);
							}catch(Exception e){
								e.printStackTrace();
							}
						 }else if (select_yn.equalsIgnoreCase("Y")){
							 System.err.println("chking select_yn equals ignorecase='y'");
							 if(eff_fr.equals("")){ 
								 error_value = "From Date cannot be Blank";
								out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");	
						}

						insertData.clear();
						tabData.clear();
						insertData.add(eff_status);
						System.err.println("eff_status-- in 252--->" +eff_status);
						if(!eff_fr.equals(""))
							 { System.err.println("chking eff_fr- in 254");
								
								insertData.add(credit_doc_date_d);
							 }
						if(!eff_to.equals(""))
							 {
								System.err.println("chking eff_to- in 254");
								insertData.add(credit_doc_date_d1);
							 }
						else
							insertData.add("");
						 chk_flag="Y";
						 
						System.err.println("chk_flag in 267" +chk_flag);	
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_facility_id);
						insertData.add(workplace_code);
						insertData.add(staff_id);
						insertData.add(role_type);
						System.err.println("added_by_id---|"+added_by_id+"|----added_at_ws_no--|"+added_at_ws_no+"|--added_facility_id--|"+added_facility_id+"|--added_by_id--|"+added_by_id+"|--added_at_ws_no--|"+added_at_ws_no+"|--added_facility_id--|"+added_facility_id+"|--added_facility_id--|"+added_facility_id+"|--workplace_code--|"+workplace_code+"|--staff_id--|"+staff_id+"|--role_type--|"+role_type+"|in servlet 278--|");
						
						tabData.put( "InsertData", insertData);
						System.err.println("tabData--- in 281-->" +tabData);
						tabData.put( "properties",	p) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_update);
						}catch(Exception e){
							e.printStackTrace();
						}							
					}
				}
					
				if((chk_flag.equals("Y"))&&!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
					System.err.println("chk_flag.equals y and tabdata is empty condition");
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

					String err_value ="";
					String result = ((Boolean)map.get("result")).toString();
					System.err.println("result in 314-->" +result);
					if(result.equals("true")){
						System.err.println("chking result is true");
						error_value = "APP-SM0001 Operation Completed Successfully...";
						err_value = "0";
					}
					else{
							System.err.println("chking result is false");
						error_value = "Exception Occured... "+ (String)map.get("msgid");
						err_value = "1";
					}
					out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value="+err_value+"&err_num=" +error_value+ "\"</script>");
				}
			}
			
			if((sqlMap.isEmpty())||(tabData.isEmpty())){
				error_value = "No Changes to Save";
				out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");
			}
		
	}catch(Exception e){
		e.printStackTrace();
		}
	}

	public void forStaff(HttpServletRequest request)throws Exception{		
		try{
			System.err.println("forstaff function in servlet");
			String staff_code = request.getParameter("staff");
			String role_type = request.getParameter("role_type");
			if(staff_code==null) staff_code ="";
			if(role_type==null) role_type ="";
			STAFF_TYPE = request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			
			HashMap map=new HashMap();
			String sql_insert = "insert into rs_staff_for_workplace (facility_id,WORKPLACE_CODE,STAFF_ID,ROLE_TYPE,EFF_DATE_FROM, EFF_DATE_TO,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,staff_type,eff_status) values (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";
			String sql_delete = "update  rs_staff_for_workplace set eff_status =? where facility_id=?  and ROLE_TYPE=? and STAFF_ID=? and WORKPLACE_CODE=?";
			String sql_update="update rs_staff_for_workplace set  eff_status=?,EFF_DATE_FROM =?,EFF_DATE_TO=?,added_by_id=?,added_date=sysdate,added_at_ws_no=?,added_facility_id=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where facility_id=? and WORKPLACE_CODE=? and STAFF_ID =? and ROLE_TYPE=? ";
		
			String select_yn;
			String db_action;
			String totalRecords;
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;					
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			totalRecords=request.getParameter("record_Count");
			int record_Count = Integer.parseInt(totalRecords);
			/*****************************insert by Workplace*********************/
			java.sql.Date credit_doc_date_d = null;
			java.sql.Date credit_doc_date_d1 = null;
			String arr3[] ;
			String arr4[] ;
			StringTokenizer toks3 = null;
			StringTokenizer toks4 = null;

			for(int i=0; i<record_Count; i++){

				arr3 =new String[3] ; 
				arr4 =new String[3] ; 			
				eff_fr = request.getParameter("eff_fro"+i)==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("eff_fro"+i),"DMY",locale,"en");				
				eff_status = request.getParameter("eff_status"+i)==null ? "":request.getParameter("eff_status"+i);
				if(eff_status.equals(""))
					eff_status ="D";			

				workplace_code = request.getParameter("workplace_code"+i)==null ? "":request.getParameter("workplace_code"+i);
				eff_to = request.getParameter("eff_to"+i)==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("eff_to"+i),"DMY",locale,"en");
				select_yn		= request.getParameter("chkd"+i)==null ? "":request.getParameter("chkd"+i);
				db_action		= request.getParameter("db_action"+i)==null ? "":request.getParameter("db_action"+i);
				
				if(select_yn==null ||select_yn.equals(""))
					select_yn="N";
				if (db_action.equals("")||(db_action==null))
					select_yn="N";

				if(!eff_fr.equals("")){
					toks3 = new StringTokenizer (eff_fr,"/") ;
					for( int u=0;u<3;u++){
						 arr3[u] = toks3.nextToken() ;
					}
					String attend_dob = arr3[2]+"-"+arr3[1]+"-"+arr3[0];
					credit_doc_date_d = java.sql.Date.valueOf(attend_dob) ;
				}
				if(!eff_to.equals(""))	{
					toks4 = new StringTokenizer (eff_to,"/") ;
					for( int l=0;l<3;l++){
					 arr4[l] = toks4.nextToken() ;
					}
					String attend_dob1 = arr4[2]+"-"+arr4[1]+"-"+arr4[0];
					credit_doc_date_d1 = java.sql.Date.valueOf(attend_dob1) ;
				}

				 if(db_action.equalsIgnoreCase("I")){

					if(select_yn.equalsIgnoreCase("Y")){
						if(eff_fr.equals("")){

							error_value = "From Date cannot be Blank";
							out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");	
						 }

						insertData.clear();
						tabData.clear();
						chk_flag ="Y";
						insertData.add(facility_id);
						insertData.add(workplace_code);
						insertData.add(staff_code);
						insertData.add(role_type);

						if(!eff_fr.equals(""))
							insertData.add(credit_doc_date_d);
						if(!eff_to.equals(""))	
							insertData.add(credit_doc_date_d1);
						else
							insertData.add("");

						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(STAFF_TYPE);
						insertData.add(eff_status);

						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;
							
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_insert);
						}catch(Exception e){
							e.printStackTrace();
						}
					}else if (select_yn.equalsIgnoreCase("N")){
						insertData.clear();
						tabData.clear();
						sqlMap.clear();
					}
				}else if(db_action.equalsIgnoreCase("U")){
					if(select_yn.equalsIgnoreCase("N")){
						insertData.clear();
						tabData.clear();
			
						insertData.add(eff_status);
						insertData.add(facility_id);
						insertData.add(role_type);
						insertData.add(staff_code);
						insertData.add(workplace_code);
						chk_flag ="Y";
						
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_delete);
						}catch(Exception e){
							e.printStackTrace();
						}

					 }else if (select_yn.equalsIgnoreCase("Y")){
						 if(eff_fr.equals("")){ 
							error_value = "From Date cannot be Blank";
							out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");	
						 }
						chk_flag ="Y";
						insertData.clear();
						tabData.clear();
						insertData.add(eff_status);

						if(!eff_fr.equals(""))
							insertData.add(credit_doc_date_d);
						if(!eff_to.equals(""))
							insertData.add(credit_doc_date_d1);
						else
							insertData.add("");

						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_facility_id);
						insertData.add(workplace_code);
						insertData.add(staff_code);
						insertData.add(role_type);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_update);
						}catch(Exception e){
							e.printStackTrace();
						}						
					}
				}
				
				if((chk_flag.equals("Y"))&&!(tabData.isEmpty()) && !(sqlMap.isEmpty())){

					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
					if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ejb/eCommon/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
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
 
					String result = ((Boolean)map.get("result")).toString();
					
					if(result.equals("true"))
						error_value = "APP-SM0001 Operation Completed Successfully...";
					else
						error_value = "Exception Occured... "+ (String)map.get("msgid");
					out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");
				}
			}
			if((sqlMap.isEmpty())||(tabData.isEmpty())){
				error_value = "No Changes to Save";
				out.println("<script>location.href =\"../eCommon/jsp/MstCodeError.jsp?err_value=1&err_num=" +error_value+ "\"</script>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
