/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;


public class VisitRuleForPractServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	java.util.Properties p;
	String  pract ;	
	String facilityId;	
	String facilityID="";
	String finalPractList="";
	Connection con;
	String client_ip_address ;
	String locale="";
	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		
		locale= p.getProperty("LOCALE");
		try	{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if(operation.equals("insert")) insertVisitRuleForPract(req, res);
		}
		catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
		finally	{
			ConnectionManager.returnConnection(con, req);
       	}
	}	

	private void insertVisitRuleForPract(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
			PreparedStatement pslPrepStmtdel=null;
			PreparedStatement stmtdel=null;			
			String practId="",selectYN="",delInsYN="";
			PreparedStatement pslPrepStmt = null;
			RecordSet	accessRightRecSet	=	null;
			accessRightRecSet	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AXSRightRecSet");
System.out.println("accessRightRecSet--->"+accessRightRecSet);
			finalPractList = req.getParameter("finalPractList");
			if(finalPractList == null) finalPractList="";
System.out.println("finalPractList--->"+finalPractList);
			out.println("finalPractList "+ finalPractList);
			StringTokenizer mainTkn = new StringTokenizer(finalPractList,"~");
System.out.println("mainTkn--->"+finalPractList);
			int maintkns= mainTkn.countTokens();
			for(int main=0;main<maintkns;main++)
			{
				String sub1=mainTkn.nextToken();
System.out.println("sub1--->"+sub1);
				accessRightRecSet.putObject(sub1);
		    }			
			String RuleID=req.getParameter("RuleID");
			facilityID=req.getParameter("facility_id");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

				HashMap tabdata=new HashMap();
				tabdata.put("facility_id",addedFacilityId);
				tabdata.put("rule_id",RuleID);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("facilityID",facilityID);

				String totCount	=	""+accessRightRecSet.getSize();
					if(totCount.equals("")) totCount="0";
System.out.println("totCount--->"+totCount);
				tabdata.put("totCount", new Integer(totCount) );
				out.println("Count "+ accessRightRecSet.getSize());

			for(int j=0;j<accessRightRecSet.getSize();j++)
			{
				out.println((String)accessRightRecSet.getObject(j));
				tabdata.put(("chk"+j),(String)accessRightRecSet.getObject(j));
			}

				int ilStatus = 0;
				String sql=	" insert into op_visit_rule_for_pract(rule_id,practitioner_id,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id )values(?,?,?,sysdate,?,?,?,sysdate,?,?) ";

				System.out.println("sql--->"+sql);
				pslPrepStmt = con.prepareStatement(sql);

				String delSql= "delete from op_visit_rule_for_pract where practitioner_id= ? ";
				pslPrepStmtdel = con.prepareStatement(delSql);
				stmtdel = con.prepareStatement(delSql);
				
				String chkYN = "";
               if (Integer.parseInt(totCount) != 0)
				   {
					for(int i=0; i<Integer.parseInt(totCount); i++)
						{
						chkYN = (String)tabdata.get("chk"+i);
				System.out.println("chkYN--->"+chkYN);
						StringTokenizer st =new StringTokenizer(chkYN,"$");
						practId=st.nextToken();
			System.out.println("practId--->"+practId);			
			System.out.println("tabdata--->"+tabdata);			
						selectYN=st.nextToken();
						delInsYN=st.nextToken();
				System.out.println("selectYN--->"+selectYN);		
				System.out.println("delInsYN--->"+delInsYN);		
						if(selectYN.equals("Y") && (delInsYN.equals("N") || delInsYN.equals("Y"))){
							//stmtdel.setString(1,(String)tabdata.get("rule_id"));
							stmtdel.setString(1,practId);					 
							ilStatus = stmtdel.executeUpdate();
				System.out.println("ilStatus 111--->"+ilStatus);
                    
						pslPrepStmt.setString(1,(String)tabdata.get("rule_id"));
						pslPrepStmt.setString(2,practId);
					
						pslPrepStmt.setString(3,addedById);
						pslPrepStmt.setString(4,modifiedAtWorkstation);
						pslPrepStmt.setString(5,modifiedFacilityId);
						pslPrepStmt.setString(6,addedById);
						pslPrepStmt.setString(7,modifiedAtWorkstation);
						pslPrepStmt.setString(8,modifiedFacilityId);
						ilStatus = pslPrepStmt.executeUpdate();
                     
 				System.out.println("ilStatus 222--->"+ilStatus);
						}
						else if(selectYN.equals("N") && (delInsYN.equals("Y")|| delInsYN.equals("N")))
						{
							//pslPrepStmtdel.setString(1,(String)tabdata.get("rule_id"));
							pslPrepStmtdel.setString(1,practId);						
							ilStatus=pslPrepStmtdel.executeUpdate();
								System.out.println("ilStatus 333--->"+ilStatus);
				
						}

					}
						if(pslPrepStmt!=null) pslPrepStmt.close();
						if(pslPrepStmtdel!=null) pslPrepStmtdel.close();
				}
				String s20 = "";
				if(ilStatus == 1){
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				s20 = (String)message.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
                message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=1");
				}

				tabdata.clear();
		
		 if(stmtdel!=null) stmtdel.close();
		if(pslPrepStmt!=null) pslPrepStmt.close();
		}
		catch (Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( pract );
			e.printStackTrace();
		}
	}
}
