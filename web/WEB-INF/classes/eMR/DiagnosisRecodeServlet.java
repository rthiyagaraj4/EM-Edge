/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Module		: Medical Records...(MR)
Coded by	: SRIDHAR R
Coded on	: 27 JULY 2004
Servlet Function :- 
	if(functionName = Diagnosis Recode)
		Insert the details into mr_diag_recoding table ...
*/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import webbeans.eCommon.*;

public class DiagnosisRecodeServlet extends HttpServlet 
{
	PrintWriter out;
	java.util.Properties p;
	String client_ip_address;
	String sStyle="";
	String locale="";
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException 
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale=p.getProperty("LOCALE");
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		try 
		{
			this.out = res.getWriter();
			insertDiagnosisRecode(req);		
		}
		catch (Exception e)	
		{
			 out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/TerminalDigit.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}
	private void insertDiagnosisRecode(HttpServletRequest req)	
	{			
		Connection con =null;
//		int j;
		boolean proceed = true;
		String error ="";
		StringBuffer StrBuff = new StringBuffer();
		StringBuffer StrBuff1 = new StringBuffer();
		String encounter_id=checkForNull(req.getParameter("encounter_id"));
		String tr_srl_no=checkForNull(req.getParameter("trn_srl_no"));
	
		try 
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			PreparedStatement stmt_asscociate_code	=	null;
			ResultSet rset		= null;
			int count=0;
			boolean exist=true;
			String record_type			= "";
			String cause_indicator		= "";
			String diag_scheme			="";
			String trn_srl_no			="";
			String facilityId		=  checkForNull(req.getParameter("facilityId"));
			String x_patient_id			= "";
			String x_srl_no				= "";			
			String x_associate_codes	= "";
			x_patient_id = req.getParameter("patient_id") != null ? req.getParameter("patient_id") : "";
			x_associate_codes = req.getParameter("associate_codes") != null ? req.getParameter("associate_codes") : "";
            x_associate_codes = URLDecoder.decode(x_associate_codes);	



			//j = Integer.parseInt(req.getParameter("NumRecords"));
			if(StrBuff.length() > 0) StrBuff.delete(0,StrBuff.length());
			StrBuff.append("select DIAG_CODE,RECORD_TYPE,CAUSE_INDICATOR,DIAG_CODE_SCHEME ");
			StrBuff.append("from mr_icd_code where DIAG_CODE=?");
			pstmt = con.prepareStatement( StrBuff.toString() ) ;

			if(StrBuff1.length() > 0) StrBuff1.delete(0,StrBuff1.length());
			StrBuff1.append("update mr_diag_recoding set ");
			StrBuff1.append("RECODED_DIAG_CODE =?,RECODED_RECORD_TYPE=?,RECODED_CAUSE_INDICATOR=?,");
			StrBuff1.append("RECODED_DIAG_CODE_SCHEME=?,REMARKS=?,MODIFIED_BY_ID =?,");
			StrBuff1.append(" MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?,");
			//StrBuff1.append("MODIFIED_FACILITY_ID=?  where TRN_SRL_NO = ? ");
			StrBuff1.append("MODIFIED_FACILITY_ID=?  where TRN_SRL_NO = ?  and ORIG_DIAG_CODE != ? and RECODED_DIAG_CODE != ?");

			pstmt1 = con.prepareStatement( StrBuff1.toString()) ;

			//for(int i=1;i<j;i++)
			//{
				//if(exist)
				//{
					//trn_srl_no		=  checkForNull(req.getParameter("trn_srl_no"+i));
					trn_srl_no		=  checkForNull(req.getParameter("trn_srl_no"));
					//String recodedCode	=  checkForNull(req.getParameter("recodedCode"+i));
					String recodedCode	=  checkForNull(req.getParameter("code"));
					//String remarks		=  checkForNull(req.getParameter("remarks"+i));
					String remarks		=  checkForNull(req.getParameter("remarks"));
					String addedById = p.getProperty("login_user");
					String modifiedById = addedById ;
					String addedFacilityId=facilityId;
					String modifiedFacilityId = addedFacilityId ;
					String addedAtWorkstation=client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation ;
					//Transaction Start here
					
					pstmt.setString (1,recodedCode);
					rset	= pstmt.executeQuery();
					if(rset.next())
					{
						record_type		= checkForNull(rset.getString("RECORD_TYPE"));
						cause_indicator	=checkForNull(rset.getString("CAUSE_INDICATOR"));
						diag_scheme		=checkForNull(rset.getString("DIAG_CODE_SCHEME"));
					}
					else
					{
						error= "Invalid Diagnosis code ";
						exist=false;
					}
					
					if ( rset	!= null ) rset.close();
					if ( pstmt	!= null ) pstmt.close();


					//if(exist & !trn_srl_no.equals(""))
					if(exist)
					{


						//String print = " update mr_diag_recoding set recoded_diag_code ='"+recodedCode+"', recoded_record_type='"+record_type+"', recoded_cause_indicator='"+cause_indicator+"', recoded_diag_code_scheme='"+diag_scheme+"', remarks='"+remarks+"', modified_by_id ='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+modifiedFacilityId+"' where trn_srl_no = '"+trn_srl_no+"' ";


						pstmt1.setString (1,recodedCode);
						pstmt1.setString (2,record_type);
						pstmt1.setString (3,cause_indicator);
						pstmt1.setString( 4, diag_scheme) ;
						pstmt1.setString(5,remarks);
						pstmt1.setString( 6, modifiedById);
						pstmt1.setString( 7, modifiedAtWorkstation) ;
						pstmt1.setString( 8, modifiedFacilityId) ;
						pstmt1.setString( 9, trn_srl_no) ;
						pstmt1.setString (10,recodedCode);
						pstmt1.setString (11,recodedCode);
					
						count=0;
						try
						{
							count	= pstmt1.executeUpdate();
							if(count>0)
								proceed = true;
							else
								proceed= false;
						}
						catch(Exception e)
						{
							con.rollback();
							proceed=false;
							error+= e.getMessage();
						}
					//}
				//}
		//}
			if(pstmt1 != null) pstmt1.close();
		
					
			////////////added for support diagnosis
		if((!x_associate_codes.equals("")) && proceed)
					{
			if(StrBuff.length() > 0) StrBuff.delete(0,StrBuff.length());
			StrBuff.append("select SRL_NO from ");
			StrBuff.append("mr_diag_recoding where TRN_SRL_NO = ?");
			pstmt = con.prepareStatement( StrBuff.toString() ) ;
			pstmt.setString( 1, trn_srl_no) ;
			rset	= pstmt.executeQuery();
			if(rset.next())
				{
					x_srl_no		= checkForNull(rset.getString("SRL_NO"));					
				}
				if ( rset	!= null ) rset.close();
				if ( pstmt	!= null ) pstmt.close();
						String splitsupportcodes = "";
						int supp_code_updated = 0;
						String insert_associate_codes = "insert into pr_problem_detail(patient_id,srl_no,diag_code,support_diag_code,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
						
						stmt_asscociate_code = con.prepareStatement( insert_associate_codes );
                       
						StringTokenizer str1 = new StringTokenizer(x_associate_codes,"|");
							while(str1.hasMoreTokens())
							{
								splitsupportcodes = str1.nextToken();
								StringTokenizer str2 = new StringTokenizer(splitsupportcodes,"~");
								while(str2.hasMoreTokens())
								{
									String x_support_diag_code = str2.nextToken();
									//String x_support_diag_desc = str2.nextToken();
                                    str2.nextToken(); 
									if(str2.hasMoreTokens())
                                    str2.nextToken();  
									stmt_asscociate_code.clearParameters();

									stmt_asscociate_code.setString(1, x_patient_id);
									stmt_asscociate_code.setString(2, x_srl_no);
									stmt_asscociate_code.setString(3, recodedCode);
									stmt_asscociate_code.setString(4, x_support_diag_code);
									stmt_asscociate_code.setString(5, addedById);									
									stmt_asscociate_code.setString(6, facilityId);
									stmt_asscociate_code.setString(7, addedAtWorkstation);
									stmt_asscociate_code.setString(8, modifiedById);									
									stmt_asscociate_code.setString(9, facilityId);
									stmt_asscociate_code.setString(10, modifiedAtWorkstation);	
									supp_code_updated += stmt_asscociate_code.executeUpdate();	
								}								
							
							}
							if(stmt_asscociate_code!=null) stmt_asscociate_code.close();
						}

/////////////////ended for support diagnosis
					}

			
			if(proceed && exist)
			{
				java.util.Hashtable message=MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
				con.commit();
				error = (String) message.get("message") ;
				//error= error.substring(0,error.indexOf("<br>")) ;
				out.println("<script>alert(\""+error+"\");</script>") ;			
				out.println("<script>parent.window.close();</script>");
				if ( message != null) message.clear();

				out.println("<script> parent.Diagresultframe.location.href=\"../eMR/jsp/DiagRecodeaddmodify.jsp?Encounter_Id="+encounter_id+"&trn_srl_no="+tr_srl_no+"\"</script>");
				out.println("<script> parent.messageFrame.location.href='../eCommon/jsp/error.jsp' </script>");

			}
			else
			{
				if(con != null) con.rollback();
				//if(count == 0)
					//error="DiagnosisCode doesn't exist in mr_diag_recoding, Trasaction Failed....";
				if(count == 0)
				{
					java.util.Hashtable message=MessageManager.getMessage(locale,"CANNOT_RECODE_AGAIN","MR");
					error = (String) message.get("message") ;
					//error="APP-MR0017 Cannot Re-code the same diagnosis code again";	
				}						
				else
					error="Trasaction failed";
				out.println("<script>alert(\""+error+"\");</script>") ;	
				out.println("<script> parent.messageFrame.location.href='../eCommon/jsp/error.jsp' </script>");

			}
		}
		catch ( Exception e )
		{
				e.printStackTrace();
			try
			{
			con.rollback();}
			catch(Exception ex)
			{
				System.out.println(e.getMessage());
			}
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}


	private String checkForNull(String inputString)
	{
		return (inputString==null) ? "" : inputString;
	}

}
