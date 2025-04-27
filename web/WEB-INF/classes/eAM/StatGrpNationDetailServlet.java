/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
 * @todo Class data members should be moved to method level scope
 */
public class StatGrpNationDetailServlet extends HttpServlet {//implements SingleThreadModel{
	Connection con  = null;
	boolean   can_commit = true;

	PrintWriter out;
	
	Properties p;
	String facilityId ;
	String client_ip_address ;
	HttpSession session;

	String addedById = "";
	String addedAtWorkstation = "";
	String addedFacilityId = "";
	String modifiedById= "";
	String modifiedAtWorkstation = "";
	String modifiedFacilityId = "";

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		String locale="";
		locale= p.getProperty("LOCALE");
		try
		{
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			InsertStatGrpNationDetail(req);
			if(can_commit) {
				con.commit();
 				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
                String s20 = (String)hashtable1.get("message");
				hashtable1.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode( s20 ,"UTF-8" )+"&err_value=1") ;
			}
			else {
				con.rollback();
			}
			
		}catch(Exception e){
			out.println("Post method failed:"+e.toString());
		}finally{
			ConnectionManager.returnConnection(con,req);
		}
	}


	/**
	 * Inserts Statistics Group Details 
	 */
	private void InsertStatGrpNationDetail(HttpServletRequest req) throws java.sql.SQLException{
		Statement stat = con.createStatement();
		ResultSet rs=null;
		StringBuffer sbQuery = new StringBuffer();
		can_commit = true;
		addedById = p.getProperty( "login_user" ) ;
		
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		modifiedById = addedById ;
		String modifiedDate = addedDate ;
		addedFacilityId=facilityId;
		modifiedFacilityId = addedFacilityId ;
		addedAtWorkstation=client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation ;

		String stat_group_id = req.getParameter("stat_group")==null ? "" :req.getParameter("stat_group");
		String insert_data = req.getParameter("insert_to_db")==null ? "" : req.getParameter("insert_to_db");
		
		try{
			StringTokenizer stat_grp_tkn = new StringTokenizer(insert_data,"~");
			if(stat_grp_tkn != null) {
				String tokens="";
				StringTokenizer stat_grp_tkn_dtl=null;
				while(stat_grp_tkn.hasMoreTokens()) {
					tokens = stat_grp_tkn.nextToken();
					stat_grp_tkn_dtl = new StringTokenizer(tokens,"|");
					if(stat_grp_tkn_dtl.hasMoreTokens()){
						String country = stat_grp_tkn_dtl.nextToken();
					
						sbQuery.append("delete from am_stat_grp_detail where stat_grp_id = '");
						sbQuery.append(stat_group_id);
						sbQuery.append("' and member_id='");
						sbQuery.append(country);
						sbQuery.append("' ");
										
						 stat.executeUpdate(sbQuery.toString());
						sbQuery.setLength(0);						
					}
				}
			}
			StringTokenizer stat_grp_tkn_dtl1 = null;
			String tokens  = "";
			String country = "";
			String incl_yn  = "";
			StringTokenizer stat_grp_tkn2 = null;
			
			ArrayList arrayList = new ArrayList();
			int count = 0;
			if(!insert_data.equals("")){
				stat_grp_tkn2 = new StringTokenizer(insert_data,"~");					
				while(stat_grp_tkn2.hasMoreTokens()) {
					tokens = stat_grp_tkn2.nextToken().trim();
					arrayList.add(count,tokens);					
					count++;
				 }
			}			  
			for(count=0;count <arrayList.size();count++){			  
				stat_grp_tkn_dtl1 = new StringTokenizer((String)arrayList.get(count),"|");	
				country = stat_grp_tkn_dtl1.nextToken().trim();
				incl_yn = stat_grp_tkn_dtl1.nextToken().trim();
				sbQuery.append("select count(*) cnt from am_stat_grp_detail where STAT_GRP_ID='");				
				sbQuery.append(stat_group_id);
				sbQuery.append("' and MEMBER_ID='");
				sbQuery.append(country);
				sbQuery.append("'");
			
                rs = stat.executeQuery(sbQuery.toString());
				sbQuery.setLength(0);				
				rs.next();
				
				if(rs.getInt("cnt")==0){					
					if(incl_yn.equals("Y")){		
						sbQuery.append("insert into am_stat_grp_detail (STAT_GRP_ID,MEMBER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values ('");
						sbQuery.append(stat_group_id);
						sbQuery.append("','");
						sbQuery.append(country);
						sbQuery.append("', '");
						sbQuery.append(addedById);
						sbQuery.append("', ");
						sbQuery.append("to_date('");
						sbQuery.append(addedDate);
						sbQuery.append("','yyyy-mm-dd'),'");
						sbQuery.append(addedAtWorkstation);
						sbQuery.append("','");
						sbQuery.append(addedFacilityId);
						sbQuery.append("', '");
						sbQuery.append(modifiedById);
						sbQuery.append("', to_date('");
						sbQuery.append(modifiedDate);
						sbQuery.append("','yyyy-mm-dd'),'");
						sbQuery.append(modifiedAtWorkstation);
						sbQuery.append("', '");
						sbQuery.append(modifiedFacilityId);
						sbQuery.append("')");

						stat.executeUpdate(sbQuery.toString());
						sbQuery.setLength(0);
						
					}	
					
				}if(rs !=null) rs.close();
			}	arrayList.clear();
			
			if(stat !=null) stat.close();
		}catch (Exception e2){
			out.println("insert 2 failed"+e2);
			e2.printStackTrace();
		}
	}
}
