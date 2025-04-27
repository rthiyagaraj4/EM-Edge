/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import webbeans.eCommon.*;


public class LinkBabytoMotherServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	java.util.Properties p;
	boolean result				= true ;
	String nursing_unit_code	= "";
	String main_bed_no			= "";
	String bed_no				= "";
	String mother_pat_id		="";
	String mother_enc_id		="";
	String patientid			="";
	String outcome				="";
	int babyCount= 0;
	StringBuffer sbsql = new StringBuffer();
	String client_ip_address;
    String facilityId;
	HttpSession session;
	Connection con	= null;
	//PreparedStatement pstmt = null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);	
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}


	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		babyCount = req.getParameter("babyCount")==null ? 0 : Integer.parseInt(req.getParameter("babyCount"));
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			
			this.out = res.getWriter();
			con	= ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
						
				insertNursingUnitBed(req);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
	private void insertNursingUnitBed(HttpServletRequest req)
	{
		PreparedStatement pstmt = null;
		try
		{
 			String locale = p.getProperty("LOCALE");
			java.util.Hashtable results = new java.util.Hashtable() ;
			results.put( "error", "no error" ) ;
			results.clear();
			nursing_unit_code	=	checkForNull(req.getParameter("nurs_unit_code"));
			mother_pat_id		=	checkForNull(req.getParameter("mother_patient_id"));
			mother_enc_id		=	checkForNull(req.getParameter("mother_encounterid"));
			main_bed_no			=	checkForNull(req.getParameter("main_bed_no"));
			String addedById				=	checkForNull(p.getProperty( "login_user" ));
			String addedAtWorkstation		=	checkForNull(client_ip_address);

			int count=0;
			if(result)
			{
				try
				{
					
					for(int index = 0 ; index < babyCount ;index++)
					{
				
					if(sbsql.length() > 0 ) sbsql.delete(0,sbsql.length());
					
					outcome=checkForNull(req.getParameter("outcome"+index));
					
                    if(!outcome.equals("S"))
						{
                          sbsql.append(" update ip_nursing_unit_bed set ");
				    	sbsql.append("mothers_patient_id=?,mothers_encounter_id=?,current_status='O',occupying_patient_id = ?,modified_date=sysdate,modified_facility_id=?,modified_by_id=?,modified_at_ws_no=? ");
						 sbsql.append(" where facility_id=? and nursing_unit_code =?  and main_bed_no=? and bed_no=?");
							
								
					  pstmt = con.prepareStatement(sbsql.toString());
					  
					 pstmt.setString	( 1, mother_pat_id); //Mother Patient id
					pstmt.setString	( 2, mother_enc_id); // Mother Encounter id
					pstmt.setString	( 4, facilityId);
					pstmt.setString	( 5, addedById) ;
					pstmt.setString	( 6, addedAtWorkstation);
					pstmt.setString	( 7, facilityId);
					pstmt.setString	( 8, nursing_unit_code);//Mother Nursing nuit
					pstmt.setString	( 9, main_bed_no);  //Mother bed no
								
					
						patientid = req.getParameter("baby_patient_id"+index);
						bed_no =checkForNull(req.getParameter("to_bed_no"+index));
						pstmt.setString	( 10, bed_no);    
							
						pstmt.setString	( 3, patientid ) ;//Baby patient id
						
						count += pstmt.executeUpdate() ;
						/* CheckStyle Correction added by Munisekhar */ 
					     if(pstmt !=null) pstmt.close();
					
					}
					
			
				   	
				}
					
					
					
					if(count == 0)
					{
						try{
								con.rollback();
							}
						catch(Exception ee)
							{
								result = false;
								ee.printStackTrace();
							}
					}

					if(pstmt !=null) pstmt.close();
					if(count > 0) result = true; else result = false;
				}
				catch ( SQLException esql )
				{
					result = false;
					esql.printStackTrace();
				}
				finally
				{
					try
					{
						if(pstmt !=null) pstmt.close();
					}
					catch (Exception eS)
					{
					}
				}
			}

			if(result && count == babyCount)
			{
				try
				{
					if(sbsql.length() > 0 ) sbsql.delete(0,sbsql.length());
					
					sbsql.append(" update ip_open_encounter set ");
					sbsql.append("BABY_DELINKED_YN='N' ");
					sbsql.append(", modified_by_id = ? ,modified_at_ws_no = ?, modified_date = sysdate,modified_facility_id = ? ");
					sbsql.append(" where facility_id=? and ENCOUNTER_ID = ?");
					pstmt = con.prepareStatement(sbsql.toString());
					pstmt.setString	( 1, addedById) ;
					pstmt.setString	( 2, addedAtWorkstation);
					pstmt.setString	( 3, facilityId);
					pstmt.setString	( 4, facilityId);
					pstmt.setString	( 5, mother_enc_id); //mother encounter id
					count = pstmt.executeUpdate() ;
					if(pstmt !=null) pstmt.close();
					if(count > 0) result = true; else result = false;
				}
				catch ( SQLException exsql )
				{
					result = false;
					exsql.printStackTrace();
				}
				finally
				{
					try
					{
						if(pstmt !=null) pstmt.close();
					}
					catch (Exception eS)
					{
					}
				}
			}

				if (result)
				{
					con.commit();
					MessageManager mm = new MessageManager();
		            final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED","SM");
		            String msg1 = (String)mesg.get("message");
					out.println("<script>alert(\""+msg1+"\");</script>");
					out.print("<script>window.parent.close();</script>");
					mesg.clear();
				}
				else
				{
					con.rollback();
					result = false ;
				}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(pstmt !=null) pstmt.close();
			}
			catch (Exception eS)
			{
			}
			ConnectionManager.returnConnection(con,p);
		}	
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}
