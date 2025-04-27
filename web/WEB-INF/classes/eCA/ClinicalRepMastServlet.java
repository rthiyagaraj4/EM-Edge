/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import com.ehis.eslp.ServiceLocator;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import oracle.sql.*;
import java.net.URLEncoder;
import webbeans.eCommon.*;
import webbeans.eCA.*;
import webbeans.eCommon.MessageManager;

public class ClinicalRepMastServlet extends HttpServlet
{
  public void init(ServletConfig config) throws ServletException
  {
        super.init(config);
  }   

  public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
  {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");		

		try
        {
			String mode = httpservletrequest.getParameter("mode").trim() == null ?"": httpservletrequest.getParameter("mode");
		
			if(mode.trim().equalsIgnoreCase("insert"))
				insertClinicalRep(httpservletrequest, httpservletresponse);
			
			if(mode.trim().equalsIgnoreCase("batch"))
				insertClinicalRepBatch(httpservletrequest, httpservletresponse);

			if(mode.trim().equalsIgnoreCase("relink"))
				insertClinicalRepRelink(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            
            exception.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        doPost(httpservletrequest, httpservletresponse);
    }

	
	private void insertClinicalRep(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	{
		Properties p;

		String longdesc				="";
		String shortdesc			="";
		String event_code			="";
		String contr_system			="";
		String contr_sys_id			="";
		String contr_sys_event_code	="";
		String hist_rec_type		="";
		String mode					="";
		String facilityId			="";
		String client_ip_address	="";
		String modifiedById			="";
		String addedId				="";
		String modifiedFacilityId	="";
		String modifiedAtWorkstation="";
		String locale				="";

		RecordSet associateDiscreteBean =new RecordSet();
		HttpSession httpsession; 
		
		PreparedStatement ps = null;
		PreparedStatement pslPrepStmt = null;
		Connection con = null;
		ResultSet rs = null;
		Hashtable tabdata;
		
		httpsession = httpservletrequest.getSession(false);
		
		associateDiscreteBean =(RecordSet)httpsession.getValue("associateDiagBean");
		
		facilityId				= (String)httpsession.getValue("facility_id");
		p						= (Properties)httpsession.getValue("jdbc");
		locale					= (String) p.getProperty("LOCALE");
		client_ip_address		= (String) p.getProperty("client_ip_address");
		modifiedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		addedId					= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;

		modifiedFacilityId		= facilityId != null ? facilityId : "";
		modifiedAtWorkstation	= client_ip_address != null ? client_ip_address : "";
		
		String errVal = "0";
		String errorMsg = "";
		
		int count = 0;
		
		boolean bInsert = false;
		boolean bCommit = true;
		
        try
        {
			con = ConnectionManager.getConnection(httpservletrequest);
			
			hist_rec_type		=	httpservletrequest.getParameter("hist_rec_type1") != null ? httpservletrequest.getParameter("hist_rec_type1") : "";
			contr_system		=	httpservletrequest.getParameter("contr_system1") != null ? httpservletrequest.getParameter("contr_system1") : "";
			shortdesc			=	httpservletrequest.getParameter("short_desc1") != null ? httpservletrequest.getParameter("short_desc1") : "";
			longdesc			=	httpservletrequest.getParameter("long_desc1") != null ? httpservletrequest.getParameter("long_desc1") : "";
    		event_code			=	httpservletrequest.getParameter("event_code1") != null ? httpservletrequest.getParameter("event_code1") : "";
			mode				=	httpservletrequest.getParameter("mode") ;

			ps = con.prepareStatement("select count(*) from CR_CLIN_EVENT_MAST where HIST_REC_TYPE=? and EVENT_CODE=? and EVENT_CODE_TYPE=?  ");
		
			ps.setString(1,hist_rec_type);
			ps.setString(2,event_code);
			ps.setString(3,contr_system);
			rs = ps.executeQuery();

			if(rs.next())
				count  = rs.getInt(1);
			
			if(ps != null)ps.close();
			if(rs != null)rs.close();
		
		    if(count == 0 )
			{
				ps = con.prepareStatement("insert into CR_CLIN_EVENT_MAST (HIST_REC_TYPE, EVENT_CODE, LONG_DESC, SHORT_DESC, ADDED_BY_ID, ADDED_DATE,  ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID,EVENT_CODE_TYPE,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO) values(?,?,?,?,?,sysdate,?,?,sysdate,?,?,?,?) ");

				ps.setString(1,hist_rec_type);
				ps.setString(2,event_code);
				ps.setString(3,longdesc);
				ps.setString(4,shortdesc);
				ps.setString(5,addedId);
				ps.setString(6,facilityId);
				ps.setString(7,addedId);
				ps.setString(8,facilityId);
				ps.setString(9,contr_system);
				ps.setString(10,client_ip_address);
				ps.setString(11,client_ip_address);
				
				int inserted = ps.executeUpdate();
				
				if(ps != null)ps.close();
				if(rs != null)rs.close();
				
				if(inserted > 0)
					bInsert = true;
			}
			else
			{
				con.rollback();
				tabdata = MessageManager.getMessage(locale,"DUPLICATE_CODE_EXISTS","COMMON");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
			}
   
			if(bInsert)
			{
				String s18 = "INSERT INTO CR_CLIN_EVENT_MAST_LINK ( HIST_REC_TYPE,CONTR_SYS_ID,CONTR_SYS_EVENT_CODE,EVENT_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,EVENT_CODE_TYPE) values (?,?,?,?,?,sysdate,?,?,sysdate,?,?)";
		
				pslPrepStmt = con.prepareStatement(s18);
		
				int size=associateDiscreteBean.getSize();
		
				for(int e=0;e<size;e+=3)
				{
					contr_sys_id			=	associateDiscreteBean.getObject(e).toString();
					contr_sys_event_code	=	associateDiscreteBean.getObject(e+2).toString();

					pslPrepStmt.setString(1,hist_rec_type);
					pslPrepStmt.setString(2,contr_sys_id);
					pslPrepStmt.setString(3,contr_sys_event_code);
					pslPrepStmt.setString(4,event_code);
					pslPrepStmt.setString(5, addedId);
					pslPrepStmt.setString(6, facilityId);
					pslPrepStmt.setString(7, addedId);
					pslPrepStmt.setString(8, facilityId);
					pslPrepStmt.setString(9, contr_sys_id);
					pslPrepStmt.addBatch();
				}
				
				int [] nUpdStat = pslPrepStmt.executeBatch();
				
				if(pslPrepStmt!=null)		pslPrepStmt.close();

				if(nUpdStat.length == -3 || nUpdStat.length != (size /3 ) )
					bCommit = false;
			
			if(bCommit)
			{
				con.commit();
				tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "1";
			}
			else
			{
				con.rollback();
				tabdata = MessageManager.getMessage(locale,"DUPLICATE_CODE_EXISTS ","COMMON");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
			}
		}
								
		httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
		
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception exception)
	{
		
		exception.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
 }

	private void insertClinicalRepBatch(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	{
		Properties p;
		
		String contr_system="";
		String data_set="";
		String hist_rec_type="";
		String facilityId="";
		String client_ip_address="";
		String addedId;
		String errVal = "0";
		String errorMsg = "";
		String event_code="";
		String short_desc="";
		String long_desc="";
		String eventcode = "";
		String code="";
		String locale="";

		HttpSession httpsession; 
		
		Connection con = null;

		PreparedStatement ps = null;
		PreparedStatement mstPrepStmt = null;
		PreparedStatement lnkPrepStmt = null;
		
		ResultSet rs = null;
		
		Hashtable tabdata;
		
		httpsession = httpservletrequest.getSession(false);
		
		int inserted=0;
		int insert_chk=0;
		int count = 0;

		StringBuffer sql = new StringBuffer();

		p					= (java.util.Properties) httpsession.getValue( "jdbc" ) ;
		locale				= (String) p.getProperty("LOCALE");
		facilityId			= (String) httpsession.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		addedId				= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;

		webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)httpsession.getValue("BatchBean");
		
        try
        {
			con = ConnectionManager.getConnection(httpservletrequest);
			hist_rec_type = httpservletrequest.getParameter("hist_rec_type1") != null ? httpservletrequest.getParameter("hist_rec_type1") : "";
			contr_system = httpservletrequest.getParameter("contr_system1") != null ? httpservletrequest.getParameter("contr_system1") : "";
			data_set = httpservletrequest.getParameter("data_set") != null ? httpservletrequest.getParameter("data_set") : "";

			StringBuffer sbevent=new StringBuffer();
			StringBuffer subevnt=new StringBuffer();
			StringTokenizer valCodes=null;
			
		
			if(recordSet.getSize() > 0)
			{
	       		for(int k =0;k<recordSet.getSize();k+=2)
				{
					eventcode = (String)recordSet.getObject(k+1).toString();

					valCodes = new StringTokenizer(eventcode,"|");

					while(valCodes.hasMoreTokens())
					{
						code=valCodes.nextToken().trim();
						sbevent.append(code);
						sbevent.append(","); 
						valCodes.nextToken();
					}
				}
			 }
		
			String sbevent_str="";
			String conv1="";
			
			StringBuffer sbevent_delete=new StringBuffer();
			String select_query="Select EVENT_CODE from CR_CLIN_EVENT_MAST where HIST_REC_TYPE=? AND EVENT_CODE_TYPE=?";

			ps = con.prepareStatement(select_query);

			ps.setString(1,hist_rec_type);
			ps.setString(2,contr_system);

			rs = ps.executeQuery();
		
			String element_bean1="";
			String sbevent_delete_str="";
			String sbevent_str11="";

			String[] sbevent_insert1=null;
			
			while(rs.next())
			{
				event_code=rs.getString("EVENT_CODE");
				sbevent_str=sbevent.toString();
				
				StringBuffer sbevent_insert=new StringBuffer();
								
				valCodes = new StringTokenizer(sbevent_str,",");
				boolean flag=false;

								
				while(valCodes.hasMoreTokens())
				{
					element_bean1=valCodes.nextToken();
											
					if((element_bean1.equalsIgnoreCase(event_code)))
					{
						flag=true;
						sbevent_str11=sbevent.toString();

						if(sbevent_str11.length()!=0)
						
						sbevent_delete_str=sbevent_str11.substring(0,sbevent_str11.length()-1);
					
						sbevent_insert1=sbevent_delete_str.split(",");
					
						for(int i=0;i<sbevent_insert1.length;i++)
						{
							if(!(element_bean1.equalsIgnoreCase(sbevent_insert1[i])))
							{
								sbevent_insert.append(sbevent_insert1[i]);
								sbevent_insert.append(",");
							}
						}

						sbevent=sbevent_insert;
					}
				}
											
				if(flag == false)
				{
					sbevent_delete.append("'");
					sbevent_delete.append(event_code);
					sbevent_delete.append("'");
					sbevent_delete.append(",");
				}
			}

			if(rs != null)rs.close();
			if(ps != null)ps.close();

			sbevent_delete.append("'");
			sbevent_delete.append("#####$");
			sbevent_delete.append("'");

			sbevent_str=sbevent.toString();
			if(sbevent_str.length()!=0)
			conv1=sbevent_str.substring(0,sbevent_str.length()-1);
			else conv1=sbevent_str;
			valCodes = new StringTokenizer(conv1,",");

			while(valCodes.hasMoreTokens())
			{
				code=valCodes.nextToken().trim();

				subevnt.append("'");
 				subevnt.append(code);
				subevnt.append("'");
				subevnt.append(","); 
			}

			subevnt.append("'");
			subevnt.append("######$");
			subevnt.append("'");
				
			ps=con.prepareStatement("delete from CR_CLIN_EVENT_MAST_LINK where  HIST_REC_TYPE=? AND EVENT_CODE_TYPE=? and EVENT_CODE IN("+sbevent_delete.toString()+")" );
			ps.setString(1,hist_rec_type);
			ps.setString(2,contr_system);

			int nDel = ps.executeUpdate();

			if(rs != null)rs.close();
			if(ps != null)ps.close();

			if (nDel >= 0)
			{
				ps=con.prepareStatement("delete from CR_CLIN_EVENT_MAST where  HIST_REC_TYPE=? AND EVENT_CODE_TYPE=? and EVENT_CODE IN("+sbevent_delete.toString()+")" );
				ps.setString(1,hist_rec_type);
				ps.setString(2,contr_system);
				ps.executeUpdate();

				if(rs != null)rs.close();
				if(ps != null)ps.close();
			}

			if(contr_system.equals("CA"))
			{
				sql.append("SELECT NOTE_TYPE EVENT_CODE, NOTE_TYPE_DESC SHORT_DESC, NOTE_TYPE_DESC LONG_DESC FROM CA_NOTE_TYPE A ");

				if(data_set.equals("S"))
				  sql.append("WHERE  NOTE_TYPE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("BT"))
			{	
				sql.append("SELECT PRODUCT_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC  LONG_DESC FROM BT_PRODUCT_MAST A ");

				if(data_set.equals("S"))
				  sql.append("WHERE PRODUCT_CODE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("OR"))
			{
				sql.append("SELECT DISCR_MSR_ID EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM AM_DISCR_MSR A ");
				
				if(data_set.equals("S"))
				  sql.append("WHERE  DISCR_MSR_ID IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("M9"))
			{
				sql.append("SELECT DIAG_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM MR_ICD_CODE A  ");
			
				if(data_set.equals("S"))
				  sql.append("WHERE  DIAG_CODE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("MC"))
			{
				sql.append("SELECT CPT_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM MR_CPT_CODE A  ");
			
				if(data_set.equals("S"))
				  sql.append("WHERE  CPT_CODE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("LB"))
			{
				sql.append("SELECT TEST_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM RL_TEST_CODE A ");
			
				if(data_set.equals("S"))
				  sql.append("WHERE  TEST_CODE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("RD"))
			{
				sql.append("SELECT EXAM_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM RD_EXAMINATION A ");
			
				if(data_set.equals("S"))
				  sql.append("WHERE  EXAM_CODE IN ("+subevnt.toString()+")");
			}
			else if(contr_system.equals("OT"))
			{
				sql.append("SELECT OPER_CODE EVENT_CODE, SHORT_DESC SHORT_DESC, LONG_DESC LONG_DESC FROM OT_OPER_MAST A ");
			
				if(data_set.equals("S"))
				  sql.append("WHERE  OPER_CODE IN ("+subevnt.toString()+")");
			}
			
			ps = con.prepareStatement(sql.toString());
							
			rs = ps.executeQuery();

			String mastersql = "INSERT INTO CR_CLIN_EVENT_MAST ( HIST_REC_TYPE ,EVENT_CODE ,LONG_DESC ,SHORT_DESC ,EVENT_CODE_TYPE ,ADDED_BY_ID ,ADDED_DATE ,ADDED_FACILITY_ID ,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_AT_WS_NO )values(?,?,?,?,?,?,SYSDATE,?,?,SYSDATE,?,?,?)";

			String lnksql ="INSERT INTO CR_CLIN_EVENT_MAST_LINK (HIST_REC_TYPE ,CONTR_SYS_ID ,CONTR_SYS_EVENT_CODE ,EVENT_CODE ,EVENT_CODE_TYPE ,STATUS ,ADDED_BY_ID ,ADDED_DATE ,ADDED_FACILITY_ID ,MODIFIED_BY_ID ,MODIFIED_DATE ,MODIFIED_FACILITY_ID) values(?,?,?,?,?,'',?,SYSDATE,?,?,SYSDATE,?)";

			mstPrepStmt = con.prepareStatement(mastersql);
			lnkPrepStmt = con.prepareStatement(lnksql);
			
			while(rs.next())
			{
				event_code =rs.getString("EVENT_CODE");	
				short_desc =rs.getString("SHORT_DESC");	
				long_desc =rs.getString("LONG_DESC");
								
				mstPrepStmt.setString (1,hist_rec_type);
				mstPrepStmt.setString (2,event_code);
				mstPrepStmt.setString (3,long_desc);
				mstPrepStmt.setString (4,short_desc);
				mstPrepStmt.setString (5,contr_system);
				mstPrepStmt.setString (6,addedId);
				mstPrepStmt.setString (7,facilityId);
				mstPrepStmt.setString (8,addedId);
				mstPrepStmt.setString (9,facilityId);
				mstPrepStmt.setString (10,client_ip_address);
				mstPrepStmt.setString (11,client_ip_address);
				
				insert_chk = mstPrepStmt.executeUpdate();

				if(insert_chk >=0)
				{
					lnkPrepStmt.setString (1,hist_rec_type);
					lnkPrepStmt.setString (2,contr_system);
					lnkPrepStmt.setString (3,event_code);
					lnkPrepStmt.setString (4,event_code);
					lnkPrepStmt.setString (5,contr_system);
					lnkPrepStmt.setString (6,addedId);
					lnkPrepStmt.setString (7,facilityId);
					lnkPrepStmt.setString (8,addedId);
					lnkPrepStmt.setString (9,facilityId);
					inserted = lnkPrepStmt.executeUpdate();
					count++;
				}
			}
		
		if(insert_chk != 0 ||  nDel!=0)
		{
			con.commit();
			tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
			errorMsg= (String) tabdata.get("message");
			errVal = "1";
		}
		else
		{
			con.rollback();
			tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
			errorMsg= (String) tabdata.get("message");
			errVal = "0";
		}

        if(rs != null)rs.close();
		if(ps != null)ps.close();
		if(mstPrepStmt != null)mstPrepStmt.close();
		if(lnkPrepStmt != null)lnkPrepStmt.close();
		
		httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+errVal);
		
	}
	catch(Exception exception)
	{
		
		exception.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
  }

    private void insertClinicalRepRelink(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	{
		Properties p;
		
		String contr_system			="";
		String contrsyseventgroup	= "";
		String hist_rec_type="";
		String facilityId="";
		String client_ip_address="";
		String addedId;
		
		boolean bCommitFlag = true;

		HttpSession httpsession; 
		PreparedStatement ps = null;
		PreparedStatement pslPrepStmt = null;
		PreparedStatement mstPrepStmt = null;
		PreparedStatement lnkPrepStmt = null;
		Connection con = null;
		ResultSet rs = null;
		Hashtable tabdata;
		httpsession = httpservletrequest.getSession(false);
		
		
		String errVal		= "0";
		String errorMsg		= "";
		String event_code	= "";
		String locale		= "";

		p					= (java.util.Properties) httpsession.getValue( "jdbc" ) ;
		locale				= (String) p.getProperty("LOCALE");
		facilityId			= (String) httpsession.getValue( "facility_id" ) ;
		client_ip_address	= (String) p.getProperty("client_ip_address");
		addedId				= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		httpsession			= httpservletrequest.getSession(false);

		int cnt = 0;
		String beanval = "";
		
		webbeans.eCommon.RecordSet recordSet = (webbeans.eCommon.RecordSet)httpsession.getValue("RelinkBean");

		try
        {
			con = ConnectionManager.getConnection(httpservletrequest);
			
			hist_rec_type	= httpservletrequest.getParameter("hist_rec_type1") != null ? httpservletrequest.getParameter("hist_rec_type1") : "";
			contr_system	= httpservletrequest.getParameter("contr_system") != null ? httpservletrequest.getParameter("contr_system") : "";
			event_code		= httpservletrequest.getParameter("event_code") != null ? httpservletrequest.getParameter("event_code") : "";
		
			ps = con.prepareStatement("Delete cr_clin_event_mast_link where HIST_REC_TYPE=? and EVENT_CODE_TYPE=? and EVENT_CODE=?");
			ps.setString(1,hist_rec_type);
			ps.setString(2,contr_system);
			ps.setString(3,event_code);
			rs = ps.executeQuery();

			if(ps != null)ps.close(); 
				
			String relinksql = "INSERT INTO CR_CLIN_EVENT_MAST_LINK ( HIST_REC_TYPE,CONTR_SYS_ID,CONTR_SYS_EVENT_CODE,EVENT_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,EVENT_CODE_TYPE) values (?,?,?,?,?,sysdate,?,?,sysdate,?,?)";
			pslPrepStmt = con.prepareStatement(relinksql);
			
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

					pslPrepStmt.setString(1,hist_rec_type);
					pslPrepStmt.setString(2,contr_system);
					pslPrepStmt.setString(3,contrsyseventgroup);
					pslPrepStmt.setString(4,event_code);
					pslPrepStmt.setString(5, addedId);
					pslPrepStmt.setString(6, facilityId);
					pslPrepStmt.setString(7, addedId);
					pslPrepStmt.setString(8, facilityId);
					pslPrepStmt.setString(9, contr_system);

					pslPrepStmt.addBatch();
					cnt++;
				}

				int [] nInsert = pslPrepStmt.executeBatch();
			
				if(nInsert.length == -3 || nInsert.length < cnt)
					bCommitFlag = false;
			}

			if(pslPrepStmt!=null)
				pslPrepStmt.close();

		if(bCommitFlag)
		{
			con.commit();
			tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
			errorMsg= (String) tabdata.get("message");
			errVal = "1";
		}
		else
		{
			con.rollback();
			tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
			errorMsg= (String) tabdata.get("message");
			errVal = "0";
		}

        if(rs != null)rs.close();
		if(ps != null)ps.close();
		if(mstPrepStmt != null)mstPrepStmt.close();
		if(lnkPrepStmt != null)lnkPrepStmt.close();
		
		httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+errVal);
		
	}
	catch(Exception exception)
	{
		
		exception.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
   } 
}
