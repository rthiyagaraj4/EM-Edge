/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class ClinicalEventGroupServlet extends javax.servlet.http.HttpServlet implements Serializable 
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	Connection          con = null;

    String from = req.getParameter("from")==null?"":req.getParameter("from");
    con = ConnectionManager.getConnection(); 
	
	

	if(from.equals("ind"))
	insertIndivdual(req,res,con);
	else if(from.equals("batch"))
	insertBatch(req,res,con);
    else if(from.equals("relink"))
	insertRelink(req,res,con);

	}
	public void insertIndivdual(HttpServletRequest req, HttpServletResponse res, Connection con) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		Properties p = null;
		String histype = "";
		String contrid = "";
		String eventgroup = "";
		String longdesc = "";
		String shortdesc = "";
		String contrsysid = "";
		String contrsyseventgroup = "";
		String addedById = "";
		String addedAtWorkstation = "";
		String addedFacilityId = "";
		String modifiedById = "";
		String modifiedAtWorkstation = "";
		String msg = "";
		String msg2 = "";
		String client_ip_address = "";
		String facilityId = "";

		PreparedStatement pstmt = null;
  
		res.setContentType("text/html");
		out = res.getWriter();
		HttpSession session = req.getSession(false);
       	webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)session.getValue("EventBean");
		
		p = (Properties)session.getValue("jdbc") ;
		client_ip_address = p.getProperty("client_ip_address");
		facilityId = (String)session.getValue( "facility_id" ) ;
        	
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		
			
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;          
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;   
		
		String error_value	= "" ;
		String error		= "";
		java.util.Hashtable message = null;

	try
	{
			con.setAutoCommit(false) ;
			message = MessageManager.getMessage(con, "RECORD_INSERTED");
		
			msg=(String) message.get("message");
			message.clear();
			message = MessageManager.getMessage(con,"RECORD_EXISTS");
			msg2=(String) message.get("message");
			message.clear();

			histype=(req.getParameter("histype")==null)?"":req.getParameter("histype");

			contrid=(req.getParameter("contr")==null)?"":req.getParameter("contr");

			eventgroup=(req.getParameter("groupcodeval")==null)?"":req.getParameter("groupcodeval");

			longdesc=(req.getParameter("long_desc")==null)?"":req.getParameter("long_desc");
			shortdesc=(req.getParameter("short_desc")==null)?"":req.getParameter("short_desc");


			String checksql = "select 1 from cr_clin_event_group where HIST_REC_TYPE = ? and EVENT_GROUP = ? AND EVENT_GROUP_TYPE = ?";
			pstmt = con.prepareStatement(checksql);
			pstmt.setString(1,histype);
			pstmt.setString(2,eventgroup);
			pstmt.setString(3,contrid);
            
			ResultSet rs =pstmt.executeQuery();

			 int insert_chk = 0;
			 int cnt = 0;

			if(rs != null && rs.next())
		{
		error_value	= "0" ;
		error		= msg2;

		}
		else
		{		
			if(pstmt != null)pstmt.close();

			String insertsql = "insert into cr_clin_event_group (HIST_REC_TYPE,EVENT_GROUP,EVENT_GROUP_TYPE,LONG_DESC,SHORT_DESC,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO) values (?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?)";


			
			pstmt = con.prepareStatement(insertsql);
			pstmt.setString(1,histype);
			pstmt.setString(2,"$"+eventgroup);
			pstmt.setString(3,contrid);
			pstmt.setString(4,longdesc);
			pstmt.setString(5,shortdesc);
			pstmt.setString(6,addedById);
			pstmt.setString(7,addedFacilityId);
			pstmt.setString(8,modifiedById);
			pstmt.setString(9,addedFacilityId);
			pstmt.setString(10,client_ip_address);
			pstmt.setString(11,client_ip_address);
			
			pstmt.executeUpdate();
			

            if(pstmt != null)pstmt.close();  
		
            
			  String beansql = "INSERT INTO CR_CLIN_EVENT_GROUP_LINK(HIST_REC_TYPE,EVENT_GROUP,EVENT_GROUP_TYPE,CONTR_SYS_ID,CONTR_SYS_EVENT_GROUP,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID)values(?,?,?,?,?,'',?,SYSDATE,?,?,SYSDATE,?)";
			   pstmt = con.prepareStatement(beansql);
			if(recordSet.getSize() > 0)
		   {

	       		  
			for(int k =0;k<recordSet.getSize();k+=3)
			{
							                   
					contrsysid = (String)recordSet.getObject(k).toString();
					contrsyseventgroup = (String)recordSet.getObject(k+1).toString();
					
					
					pstmt.clearParameters();
						
					pstmt.setString (1,histype);
					pstmt.setString (2,"$"+eventgroup);
					pstmt.setString (3,contrid);
					pstmt.setString (4,contrsysid);
					pstmt.setString (5,contrsyseventgroup);
					pstmt.setString (6,addedById);
					pstmt.setString (7,addedFacilityId);
					pstmt.setString (8,modifiedById);
					pstmt.setString (9,addedFacilityId);
										
					
					insert_chk+= pstmt.executeUpdate();
					cnt++;
						
					}
			
			}
			else
		    {
           

            pstmt.clearParameters();
						
			pstmt.setString (1,histype);
	      	pstmt.setString (2,"$"+eventgroup);
			pstmt.setString (3,contrid);
			pstmt.setString (4,contrid);
			pstmt.setString (5,eventgroup);
			pstmt.setString (6,addedById);
			pstmt.setString (7,addedFacilityId);
			pstmt.setString (8,modifiedById);
			pstmt.setString (9,addedFacilityId);
						
			
			insert_chk = pstmt.executeUpdate();
			cnt++;

			}
		
			

			error_value			= "1" ;
			error				= msg;
	}

	if (rs != null) rs.close();

				boolean flag=false;	
				
				if(cnt == insert_chk){
					flag=true;
						con.commit();						
					}else{
						con.rollback();					
					}

				if (flag){
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
					}

}

	catch ( Exception e )
	{
		e.printStackTrace();
		try{
				con.rollback();
			}catch(Exception ex){
			
			}
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181

	}
									
	

	finally
		{
			try{
				
						if(pstmt!=null) 
						pstmt.close();
						if(con!=null)ConnectionManager.returnConnection(con, req);
			    
				}
			catch(Exception ei)
			{ 
				out.println(ei.toString()); 
				ei.printStackTrace();
			}
		}
	
	}

    public void insertBatch(HttpServletRequest req, HttpServletResponse res, Connection con) throws javax.servlet.ServletException,IOException
	{
		PreparedStatement pstmbat= null ,pstmtmas = null ,pstmtdet = null;
		ResultSet rset = null ; 	
	
		Properties p = null;
		PrintWriter out = null;
	
	 String eventcode = "";
	 String longdesc = "";
	 String shortdesc = "";
	 String histype = "";
	 String contrid = "";
	 String dataset = "";
	 String facilityId = "";
	 String client_ip_address = "";
	 String addedById = "";
	 String addedAtWorkstation = "";
	 String addedFacilityId = "";
	 String modifiedById = "";
	 String modifiedAtWorkstation = "";
	 String msg = "";
	 String msg2 = "";

	 java.util.Hashtable message = null;


    res.setContentType("text/html");
	out = res.getWriter();
	HttpSession session = req.getSession(false);
    webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)session.getValue("BatchBean");

	p = (Properties)session.getValue("jdbc") ;
	facilityId = (String)session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
        	
	addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		
			
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;          
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;   
		
		String error_value	= "" ;
		String error		= "";

	try
	{

			con.setAutoCommit(false) ;

			message = MessageManager.getMessage(con, "RECORD_INSERTED");		
			msg=(String) message.get("message");
			message.clear();
			message = MessageManager.getMessage(con,"RECORD_EXISTS");
			msg2=(String) message.get("message");
			message.clear();

			histype=(req.getParameter("histype")==null)?"":req.getParameter("histype");

			contrid=(req.getParameter("contr")==null)?"":req.getParameter("contr");

			dataset=(req.getParameter("datasetval")==null)?"":req.getParameter("datasetval");

            String concat = "";
			String code="";
            StringBuffer strsql1 = new StringBuffer();
			
			if(recordSet.getSize() > 0)
		   {
	       	for(int k =0;k<recordSet.getSize();k+=2)
			{
				                   
			eventcode = (String)recordSet.getObject(k+1).toString();

			StringTokenizer valCodes = new StringTokenizer(eventcode,"|");
			code=valCodes.nextToken().trim();
 		    concat=concat+"'"+code+"'";
			valCodes.nextToken(); 
	       
			if((k+2) < recordSet.getSize())
            concat=concat+","; 
							
			}
			}

  
	if(histype.equals("CLNT") && contrid.equals("CA"))
	{
    strsql1.append("SELECT NOTE_GROUP EVENT_GROUP_CODE, NOTE_GROUP_DESC SHORT_DESC,NOTE_GROUP_DESC  LONG_DESC FROM CA_NOTE_GROUP A WHERE EFF_STATUS='E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.NOTE_GROUP AND EVENT_GROUP_TYPE=?)");

	if(dataset.equals("S"))
    strsql1.append(" and NOTE_GROUP in("+concat+")");
	
    }
	else if((histype.equals("PTCR") && contrid.equals("OR")) || (histype.equals("TRET") && contrid.equals("OR")) || (histype.equals("LBIN") && contrid.equals("OR")) || (histype.equals("RDIN" ) && contrid.equals("OR")) || (histype.equals("SUNT") && contrid.equals("OR")))
	{
     strsql1.append("SELECT discr_msr_id EVENT_GROUP_CODE,short_desc,long_desc from am_discr_msr  A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE=?)");

	 if(dataset.equals("S"))
     strsql1.append(" and discr_msr_id in("+concat+")");
      		
	}
	else if(histype.equals("RDIN") && contrid.equals("RD"))
	{
		 strsql1.append("SELECT EXAM_CODE EVENT_GROUP_CODE,short_desc ,long_desc  from rd_examination A where NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.EXAM_CODE AND EVENT_GROUP_TYPE=?)");

		 if(dataset.equals("S"))
         strsql1.append(" and EXAM_CODE in("+concat+")");

		
	}
	else if(histype.equals("LBIN") && contrid.equals("LB"))
	{
    
	strsql1.append("SELECT test_code EVENT_GROUP_CODE, short_desc,long_desc from rl_test_code a where group_test_yn = 'Y' and nvl(status,'E') = 'E' AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE=? AND EVENT_GROUP=A.TEST_CODE AND EVENT_GROUP_TYPE=?)");

	 if(dataset.equals("S"))
     strsql1.append(" and test_code in("+concat+")");
    	 	
	}

    
	
     //"SELECT discr_msr_id EVENT_GROUP_CODE,short_desc,long_desc from am_discr_msr  A where eff_status = 'E' and result_type in ('Z','V','G') AND NOT EXISTS(SELECT 1 FROM CR_CLIN_EVENT_GROUP WHERE HIST_REC_TYPE='PTCR' AND EVENT_GROUP=A.discr_msr_id AND EVENT_GROUP_TYPE='OR') and discr_msr_id in('ARTLNINST','ARTLNOFF')"

     pstmbat = con.prepareStatement(strsql1.toString());
	 pstmbat.setString(1,histype.trim());
	 pstmbat.setString(2,contrid.trim());
	 
	
            
	rset = pstmbat.executeQuery();

	
			
	String mastersql = "INSERT INTO CR_CLIN_EVENT_GROUP (HIST_REC_TYPE,EVENT_GROUP,LONG_DESC,SHORT_DESC,EVENT_GROUP_TYPE,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO)VALUES(?,?,?,?,?,null,?,SYSDATE,?,?,SYSDATE,?,?,?)";		

	pstmtmas = con.prepareStatement(mastersql);		
	String detailsql = "INSERT INTO CR_CLIN_EVENT_GROUP_link(HIST_REC_TYPE,CONTR_SYS_ID, CONTR_SYS_EVENT_GROUP, EVENT_GROUP, EVENT_GROUP_TYPE,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE   ,MODIFIED_FACILITY_ID)values(?,?,?,?,?,null,?,SYSDATE,?,?,SYSDATE,?)";	
	pstmtdet = con.prepareStatement(detailsql);		
    int norec = 0;
    int suc = 0;
    int sucs = 0;
    while(rset.next())
		{
  
		eventcode = rset.getString("EVENT_GROUP_CODE")==null?"":rset.getString("EVENT_GROUP_CODE");
		longdesc = rset.getString("LONG_DESC")==null?"":rset.getString("LONG_DESC");
		shortdesc = rset.getString("SHORT_DESC")==null?"":rset.getString("SHORT_DESC");
	    
				
	  	pstmtmas.clearParameters();
						
		pstmtmas.setString (1,histype);
		pstmtmas.setString (2,eventcode);
		pstmtmas.setString (3,longdesc);
		pstmtmas.setString (4,shortdesc);
		pstmtmas.setString (5,contrid);
		pstmtmas.setString (6,addedById);
		pstmtmas.setString (7,addedFacilityId);
		pstmtmas.setString (8,modifiedById);
		pstmtmas.setString (9,addedFacilityId);
		pstmtmas.setString (10,client_ip_address);
		pstmtmas.setString (11,client_ip_address);

		suc=suc + pstmtmas.executeUpdate();

		pstmtdet.clearParameters();
						
		pstmtdet.setString (1,histype);
		pstmtdet.setString (2,contrid);
		pstmtdet.setString (3,eventcode);
		pstmtdet.setString (4,eventcode);
		pstmtdet.setString (5,contrid);
		pstmtdet.setString (6,addedById);
		pstmtdet.setString (7,addedFacilityId);
		pstmtdet.setString (8,modifiedById);
		pstmtdet.setString (9,addedFacilityId);
											
		sucs=sucs + pstmtdet.executeUpdate();	
		
		norec++;	
		}	
		boolean flag=false;	
		
		if(norec == sucs)
		{
		flag=true;
		con.commit();						
		}
		else
		{
		con.rollback();					
		}
       
	   if(rset!=null)rset.close();
	   if(pstmtdet != null)pstmtdet.close();
	   if(pstmtmas != null)pstmtmas.close();

				if (flag){
					error_value			= "1" ;
		             error				= msg;
	
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
					}

}

	catch ( Exception e )
	{
		e.printStackTrace();
		try{
				con.rollback();
			}catch(Exception ex){
			
			}
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
	}
									
	

	finally
		{
			try{
				
						if(pstmbat!=null) 
						pstmbat.close();
						if(con!=null)ConnectionManager.returnConnection(con, req);
			    
				}
			catch(Exception ei)
			{ 
				//out.println(ei.toString()); //common-icn-0181
				ei.printStackTrace();
			}
		}


 
	}//insertbatch end



	 public void insertRelink(HttpServletRequest req, HttpServletResponse res, Connection con) throws javax.servlet.ServletException,IOException
	{
		PreparedStatement pstmt = null;
	 
	 String groupcode = "";
	 String beanval = "";
	 String histype = "";
	 String contrid = "";
	 String contrsyseventgroup = "";
	 String addedById = "";
	 String addedAtWorkstation = "";
	 String addedFacilityId = "";
	 String modifiedById = "";
	 String modifiedAtWorkstation = "";
	 String 	facilityId = "";
	 String 	client_ip_address = "";
	 String 	msg = "";
	 String 	msg2 = "";

	 Properties p = null;
	 PrintWriter out = null;
	

    res.setContentType("text/html");
	out = res.getWriter();
	HttpSession session = req.getSession(false);
    webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)session.getValue("RelinkBean");
		
	p = (Properties)session.getValue("jdbc") ;
	facilityId = (String)session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
        	
	addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		
			
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;          
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;   
		
		String error_value	= "" ;
		String error		= "";

		java.util.Hashtable message = null;

	try
	{
			con.setAutoCommit(false) ;

			message = MessageManager.getMessage(con, "RECORD_INSERTED");
		
			msg=(String) message.get("message");
			message.clear();
			message = MessageManager.getMessage(con,"RECORD_EXISTS");
			msg2=(String) message.get("message");
			message.clear();

			histype=(req.getParameter("histype")==null)?"":req.getParameter("histype");

			contrid=(req.getParameter("contr")==null)?"":req.getParameter("contr");
			groupcode=(req.getParameter("groupcode")==null)?"":req.getParameter("groupcode");

			//dataset=(req.getParameter("datasetval")==null)?"":req.getParameter("datasetval");

            
			String checksql = "delete cr_clin_event_GROUP_link where HIST_REC_TYPE=? and EVENT_GROUP_TYPE=? and EVENT_GROUP=?";
			pstmt = con.prepareStatement(checksql);
			pstmt.setString(1,histype);
			pstmt.setString(2,contrid);
			pstmt.setString(3,groupcode);
            
			pstmt.executeUpdate();
           
			if(pstmt != null)pstmt.close(); 
			int insert_chk = 0;
			int cnt = 0;
			
       
			String beansql = "INSERT INTO CR_CLIN_EVENT_GROUP_LINK(HIST_REC_TYPE,EVENT_GROUP,EVENT_GROUP_TYPE,CONTR_SYS_ID,CONTR_SYS_EVENT_GROUP,STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID)values(?,?,?,?,?,'',?,SYSDATE,?,?,SYSDATE,?)";
			pstmt = con.prepareStatement(beansql);
			
			if(recordSet.getSize() > 0)
		   {

	       		  
			for(int k =0;k<recordSet.getSize();k+=2)
			{
							                   
				beanval = (String)recordSet.getObject(k+1).toString();

                StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					if(valCodes.hasMoreTokens())
				{
					
				   contrsyseventgroup=valCodes.nextToken(); 
	               valCodes.nextToken();  
	               valCodes.nextToken();  
				}
				
						
					pstmt.clearParameters();
						
					pstmt.setString (1,histype);
					pstmt.setString (2,groupcode);
					pstmt.setString (3,contrid);
					pstmt.setString (4,contrid);
					pstmt.setString (5,contrsyseventgroup);
					pstmt.setString (6,addedById);
					pstmt.setString (7,addedFacilityId);
					pstmt.setString (8,modifiedById);
					pstmt.setString (9,addedFacilityId);
										
					
					insert_chk+= pstmt.executeUpdate();
					cnt++;
						
					}
			error_value			= "1" ;
			error				= msg;
			
			}
					
				boolean flag=false;	
				
				if(cnt == insert_chk){
					flag=true;
						con.commit();						
					}else{
						con.rollback();					
					}

				if (flag){
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
					}

}

	catch ( Exception e )
	{
		e.printStackTrace();
		try{
				con.rollback();
			}catch(Exception ex){
			
			}
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181

	}
									
	

	finally
		{
			try{
				
						if(pstmt!=null) 
						pstmt.close();
						if(con!=null)ConnectionManager.returnConnection(con, req);
			    
				}
			catch(Exception ei)
			{ 
				//out.println(ei.toString()); //common-icn-0181
				ei.printStackTrace();
			}
		}
	
	}




}



