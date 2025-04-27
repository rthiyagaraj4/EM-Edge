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
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class CATranscriptionServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = null;

		try
		{
			out = response.getWriter();
			insert(request,response,out);
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	{
		Properties p;
		HttpSession session;
		Connection connection = null;
		PreparedStatement pstmt = null,pstmt_del=null;		 
		CATranscriberSetupBean bean = null;
		CAMultiRecordBean multiRecBean = null;
		
		session = request.getSession(false);
		p = (java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		String login_by_id				= ((String)session.getValue("login_user")).trim();
		String login_facility_id		=	((String)session.getValue("facility_id")).trim();
		String login_at_ws_no		= ((String)p.getProperty("client_ip_address")).trim();
		String valid= "", associate_yn="";
						
		HashMap map = new HashMap() ;
		HashMap split = new HashMap();
		map.put( "result", new Boolean( false ) ) ;

		boolean insert_flag = false ;
		boolean delete_flag = false ;

		String transcriber			= request.getParameter("transcriber_id");
		String bean_id				= request.getParameter("bean_id");
		String group_by				= request.getParameter("group_by_id");		
		String code					= "";		
		ArrayList allRecords		= new ArrayList();

		int [] insertCounts ;
		int [] deleteCounts ;
		
		String sqlInsert = "insert into CA_DFLT_TRANSCRIBER(TRANSCRIBE_PRACT_ID,RESOURCE_TYPE,RESOURCE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";		

		String sqlDelete = "Delete from CA_DFLT_TRANSCRIBER where TRANSCRIBE_PRACT_ID=? and RESOURCE_TYPE = ? and RESOURCE_CODE = ?";
	
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();
		
		try
		{
			bean = (CATranscriberSetupBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( bean_id,"CATranscriberSetupBean",session ) ;		
			multiRecBean  = (CAMultiRecordBean)bean.getMultiRecBean();
			allRecords = multiRecBean.getAllDBRecords();
			
			if(group_by.equals("PC"))
			{
				allRecords = multiRecBean.getAllSelectRecords();
			}
			
			if(allRecords.size()>0)
			{
				for(int j=0;j<allRecords.size();j++)
				{
					split			= (HashMap)allRecords.get(j);
					valid			= (String) split.get("valid");
					associate_yn	= (String) split.get("associate_yn");

					if(valid.equals("Y"))
					{
						if(associate_yn.equals("D"))
						{
							deleteArrList.add(split);
						}
					}
					else if(valid.equals("N"))
					{
						if(associate_yn.equals("Y"))
						{
							insertArrList.add(split);
						}
					}
				}
			}
			else
			{				
				Hashtable tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
				String errorMsg= (String) tabdata.get("message");				
				tabdata.clear();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
			}	

			connection = ConnectionManager.getConnection(request);
			
			if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;			

			if(insertArrList.size() >0)
			{
				pstmt = connection.prepareStatement(sqlInsert);
				HashMap tabData  = new HashMap();

				for(int j=0 ; j < insertArrList.size() ; j++)
				{
					tabData  = (HashMap)insertArrList.get(j);
					code     =  (String)tabData.get("code");
					pstmt.setString(1 ,transcriber);
					pstmt.setString(2 ,group_by);						
					pstmt.setString(3 ,code);
					pstmt.setString(4 ,login_by_id);
					pstmt.setString(5 ,login_at_ws_no);
					pstmt.setString(6 ,login_facility_id);
					pstmt.setString(7 ,login_by_id);
					pstmt.setString(8 ,login_at_ws_no);
					pstmt.setString(9 ,login_facility_id);
					pstmt.addBatch();
				}
						
				insertCounts = pstmt.executeBatch();
				for (int i=0;i<insertCounts.length ;i++ )
				{
					if(insertCounts[i]<0  && insertCounts[i] != -2 )
					{						
						insert_flag=false;
						break;
					}
					else
					{						
						insert_flag=true;
					}						
				}
			}

			if(insert_flag && deleteArrList.size() >0 )
			{
				pstmt_del	= connection.prepareStatement(sqlDelete);
				HashMap delMapData  = new HashMap();
				
				for(int k=0 ; k < deleteArrList.size() ; k++)
				{
					delMapData  = (HashMap)deleteArrList.get(k);
					code  = (String)delMapData.get("code");

					pstmt_del.setString(1 ,transcriber);
					pstmt_del.setString(2 ,group_by);						
					pstmt_del.setString(3 ,code);

					pstmt_del.addBatch();
				}

				deleteCounts = pstmt_del.executeBatch();

				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 )
					{					
						delete_flag=false;
						break;
					}
					else
					{					
						delete_flag=true;
					}
				} 
			}

			if (pstmt != null) pstmt.close();
			if (pstmt_del != null) pstmt_del.close();
			
			if(insert_flag && delete_flag)
			{
				connection.commit();
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");				
				tabdata.clear();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");				
			}
			else
			{
				connection.rollback();
				Hashtable tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
				String errorMsg= (String) tabdata.get("message");				
				tabdata.clear();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
			}  
		}
		catch(Exception e)
		{
			try
			{
				connection.rollback();	
			}
			catch (Exception rb)
			{
				rb.printStackTrace();
			}
			
			e.printStackTrace();
		}
		finally
		{
		   try
		   {
		  		if (pstmt != null) pstmt.close();
				if (pstmt_del != null) pstmt_del.close();
				if(connection != null) ConnectionManager.returnConnection(connection,request);
			}
			catch ( Exception fe )
			{
				
				fe.printStackTrace() ;			
			}
		}
	}
}
