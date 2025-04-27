/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//Created by Marimuthu on 05/02/2008

package eMP;

import java.sql.*; 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class RelationshipLevelServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	RecordSet associateDiagBean = new RecordSet(); 

	String addedFacilityId ;
	String client_ip_address ;

	String relationship_code = "";
	String linked_relationship_code = "";
	String relationship_level = "";
	String checked_flag = "";	

	String addedById = "";
	String addedAtWorkstation = "";
	String modifiedById = "";
	String modifiedFacilityId = "";	
	String modifiedAtWorkstation = "";

	boolean insertable = true;

	String relnship_level_code = "";
	String relnship_level_desc = "";
	String linked_relnship_level_code = "";
	String combined_rel_level_code = "";

	ArrayList session_arr = new ArrayList();
	ArrayList insert_arr = new ArrayList();
	ArrayList update_arr = new ArrayList();	

	java.sql.Date added_date = null;
	java.sql.Date modified_date = null;	

	int inserted_rec = 0;	
	int updated_rec  = 0;	

	Connection con;
	PreparedStatement pstmt;

	StringBuffer sb = new StringBuffer();
	String locale = "";
	String addedDate = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc") ;
		this.addedFacilityId = (String) session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		associateDiagBean = (RecordSet) session.getValue("associateDiagBean");

		addedById = p.getProperty( "login_user" ) ;
		modifiedById = addedById ;
		modifiedFacilityId = addedFacilityId ;
		addedAtWorkstation = client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation ;

		locale = p.getProperty("LOCALE");

		addedDate = dateFormat.format(new java.util.Date());

		added_date = java.sql.Date.valueOf(addedDate);
		modified_date = java.sql.Date.valueOf(addedDate);

		try 
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			this.out = res.getWriter();	
			
			getRecords(req, res);			

			if(insertable)
				insertRelationshipLevel();
			if(insertable)
				modifyRelationshipLevel();

			String error_value = "0" ;

			if(inserted_rec>0 || updated_rec>0)
			{
				con.commit();
				error_value = "1" ;
				
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM");
                String error = (String)hashtable1.get("message");

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value);
			}
			else if(insertable == false)
			{
				con.rollback();
				error_value = "0";
				String error = sb.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value);
			}
			
		} catch (Exception e) {

			//out.println("Exception in doPost Method of Relationship Level Servlet...."+e.toString());
			e.printStackTrace();

		} finally {

			update_arr.clear();
			session_arr.clear();
			insert_arr.clear();
			sb.setLength(0);
			//if(pstmt != null)pstmt.close();
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try	
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/RelationshipLevel.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='relnshp_lvl_res' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} 
		catch(Exception e)	
		{	

		}

	}

	public void getRecords(HttpServletRequest req, HttpServletResponse res)
	{
		try {	
				relationship_code		    = req.getParameter("relationship_code")==null?"":req.getParameter("relationship_code");
				linked_relationship_code	=  req.getParameter("linked_relationship_code")==null?"": 						                                            req.getParameter("linked_relationship_code");
				relationship_level		    = req.getParameter("relationship_level")==null?"":req.getParameter("relationship_level");	
				checked_flag		        = req.getParameter("checked_flag")==null?"":req.getParameter("checked_flag");
				
				StringTokenizer strTok = new StringTokenizer(checked_flag,"|");	
				
				String strTok_1 = "";

				int pos;
				String chk_flag = "";	

				while(strTok.hasMoreTokens())
				{					
					strTok_1 = strTok.nextToken();					
					StringTokenizer strTok_2 = new StringTokenizer(strTok_1,"~");					
					while(strTok_2.hasMoreTokens())
					{
						pos = Integer.parseInt(strTok_2.nextToken());
						chk_flag = strTok_2.nextToken();					

						if(chk_flag.equals("Y"))
						{	
							session_arr.add( associateDiagBean.getObject(pos) );
							session_arr.add( associateDiagBean.getObject(pos+1) );
							session_arr.add( associateDiagBean.getObject(pos+2) );

							if(relationship_level.equals("2"))
							{
								session_arr.add( associateDiagBean.getObject(pos+3) );
								session_arr.add( associateDiagBean.getObject(pos+4) );
							}
						}
					}
				}								

				int arr_size = session_arr.size();				

				String mode = "";

				for(int i=0;i<arr_size;i++)
				{
					mode = session_arr.get(i).toString();

					if(mode.equals("I"))
					{
						insert_arr.add( session_arr.get(++i).toString() );
						insert_arr.add( session_arr.get(++i).toString() );

						if(relationship_level.equals("2"))
						{
							insert_arr.add( session_arr.get(++i).toString() );
							insert_arr.add( session_arr.get(++i).toString() );
						}
					}
					else if(mode.equals("M"))
					{
						update_arr.add( session_arr.get(++i).toString() );
						update_arr.add( session_arr.get(++i).toString() );

						if(relationship_level.equals("2"))
						{
							update_arr.add( session_arr.get(++i).toString() );
							update_arr.add( session_arr.get(++i).toString() );
						}
					}
					else if(mode.equals("U"))
					{
						if(relationship_level.equals("1"))
							i=i+2;	
						else if(relationship_level.equals("2"))
							i=i+4;
					}
				}				

				insertable = true;						

		} catch ( Exception e ) {			
			//out.println("Exception in getRecords Method of Relationship Level Servlet..."+e.toString());
			e.printStackTrace();
			sb.append("Exception in getRecords Method of Relationship Level Servlet..."+e.toString());
		}

	}

	public void insertRelationshipLevel()
	{
		try
		{			
			String insert_sql = "INSERT INTO MP_RELATIONSHIP_LEVEL(RELATIONSHIP_CODE, ASSOCIATED_RELATIONSHIP_CODE, RELATIONSHIP_LEVEL_CODE, RELATIONSHIP_LEVEL_DESC, RELATIONSHIP_LEVEL_CODE2, COMBINED_REL_LEVEL_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(insert_sql);
			
			int size=insert_arr.size();

			for(int e=0;e<size;e++)
			{
				relnship_level_code	= insert_arr.get(e).toString();				
				relnship_level_desc	= insert_arr.get(++e).toString();

				if(relationship_level.equals("1"))
				{
					combined_rel_level_code = relationship_code+relnship_level_code;					
				}
				else if(relationship_level.equals("2"))
				{
					linked_relnship_level_code = insert_arr.get(++e).toString();
					combined_rel_level_code = relationship_code+linked_relationship_code+relnship_level_code+linked_relnship_level_code;
					e++;
				}			

				pstmt.clearParameters();			
				pstmt.setString(1,relationship_code);
				pstmt.setString(2,linked_relationship_code);
				pstmt.setString(3,relnship_level_code);
				pstmt.setString(4,relnship_level_desc);
				pstmt.setString(5,linked_relnship_level_code);
				pstmt.setString(6,combined_rel_level_code);
				pstmt.setString(7,addedById);
				pstmt.setDate(8,added_date);
				pstmt.setString(9,addedAtWorkstation);
				pstmt.setString(10,addedFacilityId);
				pstmt.setString(11,modifiedById);
				pstmt.setDate(12,modified_date);
				pstmt.setString(13,modifiedAtWorkstation);
				pstmt.setString(14,modifiedFacilityId);

				inserted_rec = pstmt.executeUpdate(); 			
					
			}
				
			if(pstmt != null)pstmt.close();

		} catch (Exception e) {

			insertable = false;
			sb.append("Exception in insertRelationshipLevel Method of Relationship Level Servlet..."+e.toString());
			
			e.printStackTrace();


		} finally {
			//if(pstmt != null)pstmt.close();
			insert_arr.clear();
		}
	}

	public void modifyRelationshipLevel()
	{
		try
		{	
			String update_sql = "UPDATE MP_RELATIONSHIP_LEVEL SET RELATIONSHIP_CODE = ?, ASSOCIATED_RELATIONSHIP_CODE = ?, RELATIONSHIP_LEVEL_CODE = ?, RELATIONSHIP_LEVEL_DESC = ?, RELATIONSHIP_LEVEL_CODE2 = ?, COMBINED_REL_LEVEL_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE COMBINED_REL_LEVEL_CODE = ?";	

			pstmt = con.prepareStatement(update_sql);
			
			int size=update_arr.size();
				
			for(int e=0;e<size;e++)
			{
				relnship_level_code	= update_arr.get(e).toString();				
				relnship_level_desc	= update_arr.get(++e).toString();
				if(relationship_level.equals("1"))
				{
					combined_rel_level_code = relationship_code+relnship_level_code;					
				}
				else if(relationship_level.equals("2"))
				{
					linked_relnship_level_code = update_arr.get(++e).toString();
					combined_rel_level_code = relationship_code+linked_relationship_code+relnship_level_code+linked_relnship_level_code;
					e++;
				}	
				
				pstmt.clearParameters();			
				pstmt.setString(1,relationship_code);
				pstmt.setString(2,linked_relationship_code);
				pstmt.setString(3,relnship_level_code);
				pstmt.setString(4,relnship_level_desc);
				pstmt.setString(5,linked_relnship_level_code);
				pstmt.setString(6,combined_rel_level_code);
				pstmt.setString(7,modifiedById);
				pstmt.setDate(8,modified_date);
				pstmt.setString(9,modifiedAtWorkstation);
				pstmt.setString(10,modifiedFacilityId);
				pstmt.setString(11,combined_rel_level_code);	

				updated_rec = pstmt.executeUpdate(); 				
					
			}
				
			if(pstmt != null)pstmt.close();

		} catch (Exception e) {
			sb.append("Exception in modifyRelationshipLevel Method of Relationship Level Servlet..."+e.toString());
			insertable = false;
			
			e.printStackTrace();
		} finally {
			//if(pstmt != null)pstmt.close();			
		}
	}

};
