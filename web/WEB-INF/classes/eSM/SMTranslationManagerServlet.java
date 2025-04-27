/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class SMTranslationManagerServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;

	java.util.Properties p;
	Connection con ;
	PreparedStatement pslPrepStmt = null;	 
	int pkDataCnt=0;
	ResultSet rs=null;
	String facilityId="";
	int rscnt=0;  
	String client_ip_address="";
	String table_id=""; 
	String language="";
	String count="";
	StringBuffer sql=new StringBuffer();
	StringBuffer sql1=new StringBuffer();
	String pk_value="";
	String desc1="";
	String desc2="";
	String desc3="";
	String trans_table_id="";
	String pk_value1="";
	ArrayList columnNames=null;
	int cnt=0;
	HttpSession session;
    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
        req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");				
        
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		
		if(facilityId==null) facilityId="";
	    client_ip_address = p.getProperty("client_ip_address");
		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			insertRecords(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	finally
		{
			ConnectionManager.returnConnection(con, req);
		}

	}


	private void insertRecords(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{columnNames=new ArrayList();
			String addedById = p.getProperty( "login_user" ) ;
    		String modifiedById = addedById ;
	    	String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String table_or_from="";

			table_id=req.getParameter("master_table_id")==null?"":req.getParameter("master_table_id");
			table_or_from=req.getParameter("table_or_from")==null?"":req.getParameter("table_or_from");
			language = req.getParameter("language")==null?"":req.getParameter("language");
			trans_table_id = req.getParameter("trans_tab_id")==null?"":req.getParameter("trans_tab_id");
			count= req.getParameter("cnt");
			pkDataCnt= Integer.parseInt(req.getParameter("pkDataCnt"));
			cnt=Integer.parseInt(count);
           int countOrder1=0;
		    sql.setLength(0);
			sql.append("SELECT trans_column_id  FROM  sm_mapping WHERE  master_table_id=? order by srl_no");
			pslPrepStmt=con.prepareStatement(sql.toString());
            pslPrepStmt.setString(1,table_id);
		     rs=pslPrepStmt.executeQuery();
		   
		   while(rs.next())
			{
			columnNames.add(rs.getString("trans_column_id"));
          
			}
			if(rs!=null)	rs.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();
			for(int i=0;i<cnt;i++)
			{
			sql.setLength(0);
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			sql.append("SELECT COUNT(*) count FROM "+trans_table_id+ "  WHERE  TABLE_ID=? AND LANGUAGE_ID =?   "); 
				}else
				{
				sql.append("SELECT COUNT(*) count FROM "+trans_table_id+ "  WHERE  LANGUAGE_ID =?   "); 
				}
			int inparam1=1;
			for( int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			  sql.append("and  "+(String)columnNames.get(pkcnt)+"=?"); 
			}
		//	pk_value=req.getParameter("pk"+i)==null?"":req.getParameter("pk"+i);
			
			pslPrepStmt=con.prepareStatement(sql.toString());
            if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			pslPrepStmt.setString(inparam1,table_id);
			inparam1++;
				}
			pslPrepStmt.setString(inparam1,language);
			inparam1++;
			for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			pslPrepStmt.setString(inparam1,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
			inparam1++;
			}
			rs=pslPrepStmt.executeQuery();
			rs.next();
			if(rs!=null)	rs.close();
			
			int countOrder=0;
		/*	if(rs.getInt("count")>0)
			{*/
				sql.setLength(0);
        
           sql.append("update " + trans_table_id+ "  set  ");
			for(int k=pkDataCnt;k<columnNames.size();k++)
			{
			sql.append((String )columnNames.get(k)+"=?,");
			}
		   if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			sql.append("  MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where  TABLE_ID=? and LANGUAGE_ID=?  ");
				}else
				{
					sql.append("  MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  where  LANGUAGE_ID=?  ");
		
				}
			for( int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			  sql.append("and  "+(String)columnNames.get(pkcnt)+"=?"); 
			}
			
			
			 desc1=req.getParameter("desc0"+i)==null?"":req.getParameter("desc0"+i);
			 if(!desc1.equals(""))
				{
			pslPrepStmt=con.prepareStatement(sql.toString());
			int  inparam=1;
			for(int k=0;k<columnNames.size()-pkDataCnt;k++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("desc"+countOrder+""+i)==null?"":req.getParameter("desc"+countOrder+""+i));
		   countOrder++;	
		   inparam++;
			}
		   pslPrepStmt.setString(inparam,modifiedById);
		   inparam++;
		   pslPrepStmt.setString(inparam,modifiedAtWorkstation);
			inparam++;
			pslPrepStmt.setString(inparam,modifiedFacilityId);
            inparam++;
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			pslPrepStmt.setString(inparam,table_id);
			inparam++;
				}
			pslPrepStmt.setString(inparam,language);
			inparam++;
	        for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
			inparam++;
			}

			countOrder1++;
			rscnt= pslPrepStmt.executeUpdate();
			}else
			{ 



            pslPrepStmt=con.prepareStatement(sql.toString());
			int  inparam=1;
			for(int k=0;k<columnNames.size()-pkDataCnt;k++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("desc"+countOrder+""+i)==null?"":req.getParameter("desc"+countOrder+""+i));
		   countOrder++;	
		   inparam++;
			}
		   pslPrepStmt.setString(inparam,modifiedById);
		   inparam++;
		   pslPrepStmt.setString(inparam,modifiedAtWorkstation);
			inparam++;
			pslPrepStmt.setString(inparam,modifiedFacilityId);
            inparam++;
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			pslPrepStmt.setString(inparam,table_id);
			inparam++;
				}
			pslPrepStmt.setString(inparam,language);
			inparam++;
	        for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
			inparam++;
			}

			countOrder1++;
			rscnt= pslPrepStmt.executeUpdate();





		  /*    int inparam=1;
	    	sql.setLength(0);
			sql.append("delete from  " + trans_table_id);
		   if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
			{
			sql.append("    where  TABLE_ID=? and LANGUAGE_ID=?  ");
				}else
				{
					sql.append("  where  LANGUAGE_ID=?  ");
		
				}
			for( int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			  sql.append("and  "+(String)columnNames.get(pkcnt)+"=?"); 
			}
		   
		 	pslPrepStmt=con.prepareStatement(sql.toString());
		   
		   if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			pslPrepStmt.setString(inparam,table_id);
			inparam++;
				}
			pslPrepStmt.setString(inparam,language);
			inparam++;
	        for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
			inparam++;
			}
            rscnt= pslPrepStmt.executeUpdate();
		  
		  if(table_or_from.equals("F"))
				{
		    con.commit();
	      	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value=1");
			
			}
		 countOrder1++;*/
		 }
		   
		/*	}/*else
			{
			 desc1=req.getParameter("desc0"+i);
			if(!desc1.equals(""))
				{
			sql.setLength(0);
		   sql1.setLength(0);
			sql1.append("values(");
			
			sql.append("insert into  " +trans_table_id+"(   ");
			for (int k=0;k<columnNames.size() ;k++ )
			{
			sql.append(columnNames.get(k)+",");
			sql1.append("?"+",");
			}
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
		 sql.append("TABLE_ID, LANGUAGE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)");
		sql1.append("?,?,?,sysdate,?,?,?,sysdate,?,?)");
				}else
					{
		 sql.append(" LANGUAGE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)");
		sql1.append("?,?,sysdate,?,?,?,sysdate,?,?)");
					}
		 sql.append(sql1.toString());
			pslPrepStmt=con.prepareStatement(sql.toString());
            
			 int  inparam=1;
			for(int pkcnt=0;pkcnt<pkDataCnt;pkcnt++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("pk"+countOrder1+""+pkcnt)==null?"":req.getParameter("pk"+countOrder1+""+pkcnt));
			inparam++;
			}

			countOrder1++;
			for(int k=0;k<columnNames.size()-pkDataCnt;k++)
			{
			pslPrepStmt.setString(inparam,req.getParameter("desc"+countOrder+""+i)==null?"":req.getParameter("desc"+countOrder+""+i));
		   countOrder++;	
		   inparam++;
			}
			if(trans_table_id.equals("SM_OTH_LANG_DATA_SKEY")||trans_table_id.equals("SM_OTH_LANG_DATA_DKEY"))
				{
			pslPrepStmt.setString(inparam,table_id);
			
			inparam++;
				}
			pslPrepStmt.setString(inparam,language);
			inparam++;
			pslPrepStmt.setString(inparam,addedById);
			inparam++;
            pslPrepStmt.setString(inparam,addedAtWorkstation);
			inparam++;
			pslPrepStmt.setString(inparam,addedFacilityId);
			inparam++;
			pslPrepStmt.setString(inparam,modifiedById);
			inparam++;
            pslPrepStmt.setString(inparam,modifiedAtWorkstation);
			inparam++;
			pslPrepStmt.setString(inparam,modifiedFacilityId);
			rscnt= pslPrepStmt.executeUpdate();
			}	else
				{
				countOrder1++;
				}
			
			}*/
			if(pslPrepStmt!=null) pslPrepStmt.close();
						
			}
			
	con.commit();
	 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value=1");
		
	}
	catch ( Exception e )
	{  try
		{con.rollback();
		
		e.printStackTrace();
		
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}catch(Exception e1)
		{e.printStackTrace();
		}
	}


}

}
