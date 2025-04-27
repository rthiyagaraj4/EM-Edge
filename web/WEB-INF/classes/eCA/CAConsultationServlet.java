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

public class CAConsultationServlet extends javax.servlet.http.HttpServlet
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
		PreparedStatement pstmt = null,pstmt_del=null,ps=null;		 
		PreparedStatement stmt = null,stmt_upd=null;		 
		CAConsultationBean bean = null;
		CAMultiRecordBean multiRecBean = null;
		ResultSet rs=null;
		
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
		boolean insert_flags = false ;
		boolean delete_flag = false ;

		String order_catalog		= request.getParameter("order_catalog");
		String order_catalog_code		= request.getParameter("order_catalog_code");
		String bean_id					= request.getParameter("bean_id");
		String group_by				= request.getParameter("group_by");		
		String resource_type		= "";		
		String code		= "";		
		ArrayList allRecords		= new ArrayList();
		int total=0;
		int upd=0;

		int [] insertCounts ;
		int [] insertCount ;
		int [] deleteCounts ;
		
		//int k = 0;
			try
			{
				connection				= ConnectionManager.getConnection(request);
				connection.setAutoCommit( false ) ;
			}
			catch (Exception e)
			{
				
				e.printStackTrace() ;
			}


		if((group_by.equalsIgnoreCase("S")) || (group_by.equalsIgnoreCase("P")))
		{
			
			try
			{
				bean = (CAConsultationBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( bean_id,  "CAConsultationBean", session ) ;
				resource_type    = bean.getResourceType();
				String update_query="update CA_CONS_CATALOG_FOR_RESOURCE set order_catalog_code=?  where resource_code=? and resource_type=?";
				String select_query="select count(*) total from CA_CONS_CATALOG_FOR_RESOURCE where  resource_code=? and resource_type=?";

				String sqlInsert = "insert into CA_CONS_CATALOG_FOR_RESOURCE(RESOURCE_TYPE,ORDER_CATALOG_CODE,RESOURCE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";	
				ps=connection.prepareStatement(select_query);
				ps.setString(1,order_catalog.trim());
				ps.setString(2,resource_type.trim());
				rs=ps.executeQuery();
				while(rs.next())
				{
					total=Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));
				}
				if(total>0)
				{
					stmt_upd					= connection.prepareStatement(update_query);
					stmt_upd.setString(1,order_catalog_code.trim());
					stmt_upd.setString(2,order_catalog.trim());
					stmt_upd.setString(3,resource_type.trim());
					upd=stmt_upd.executeUpdate();
				}
				else
				{
			
					stmt					= connection.prepareStatement(sqlInsert);
					stmt.setString(1,resource_type.trim());
					stmt.setString(2,order_catalog_code.trim());
					stmt.setString(3,order_catalog.trim());
					stmt.setString(4 ,login_by_id.trim());
					stmt.setString(5 ,login_at_ws_no.trim());
					stmt.setString(6 ,login_facility_id.trim());
					stmt.setString(7 ,login_by_id.trim());
					stmt.setString(8 ,login_at_ws_no.trim());
					stmt.setString(9 ,login_facility_id.trim());
					stmt.addBatch();
							//insertCounts[j] = pstmt.executeUpdate();
						
					insertCount = stmt.executeBatch();
					for (int i=0;i<insertCount.length ;i++ )
					{
						if(insertCount[i]<0  && insertCount[i] != -2 )
						{						
							insert_flags=false;
							break;
						}
						else
						{						
							insert_flags=true;
						}						
					}
			}
			if(insert_flags||(upd>0))
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
		catch (Exception Se)
		{
				try{
					connection.rollback();	
				}
				catch (Exception rb)
				{
					rb.printStackTrace();
				}								
				Se.printStackTrace();
			
		}
		finally{
		   try{
					if (rs != null) rs.close();
					if (ps != null) ps.close();					
					if (stmt != null) stmt.close();					
					if (stmt_upd != null) stmt_upd.close();
					if (pstmt != null) pstmt.close();
					if (pstmt_del != null) pstmt_del.close();
					if(connection != null) ConnectionManager.returnConnection(connection,request);
				}catch ( Exception fe ) {
					
					fe.printStackTrace() ;			
				}
			}
		}
		else
		{
		String sqlInsert = "insert into CA_CONS_CATALOG_FOR_RESOURCE(RESOURCE_TYPE,ORDER_CATALOG_CODE,RESOURCE_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";		

		String sqlDelete = "Delete from CA_CONS_CATALOG_FOR_RESOURCE where RESOURCE_TYPE=? and ORDER_CATALOG_CODE = ? and RESOURCE_CODE = ?";
		

		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();
		
		try{
				bean = (CAConsultationBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( bean_id,  "CAConsultationBean", session ) ;		
				multiRecBean  = (CAMultiRecordBean)bean.getMultiRecBean();
				allRecords = multiRecBean.getAllDBRecords();

				if(allRecords.size()>0){
					for(int j=0;j<allRecords.size();j++){

						split			= (HashMap)allRecords.get(j);
						valid			= (String) split.get("valid");
						associate_yn	= (String) split.get("associate_yn");

						if(valid.equals("Y")){
							if(associate_yn.equals("D")){
								deleteArrList.add(split);
							}
						}else if(valid.equals("N")){
							if(associate_yn.equals("Y")){
								insertArrList.add(split);
							}
						}

					}
				}else{				
					Hashtable tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					String errorMsg= (String) tabdata.get("message");				
					tabdata.clear();
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
				}	

			//	group_by				=	bean.getGroupBy();				
				resource_type    = bean.getResourceType();			

				// connection				= ConnectionManager.getConnection(request);
				// connection.setAutoCommit( false ) ;
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
					//insertCounts = new int[insertArrList.size()];

					pstmt					= connection.prepareStatement(sqlInsert);
					HashMap tabData  = new HashMap();

					if (group_by.equals("P") || group_by.equals("S"))
					{
						tabData  = (HashMap)insertArrList.get(0);
						code        =  (String)tabData.get("code");
						pstmt.setString(1 ,resource_type);
						pstmt.setString(2 ,code);						
						pstmt.setString(3 ,order_catalog);
						pstmt.setString(4 ,login_by_id);
						pstmt.setString(5 ,login_at_ws_no);
						pstmt.setString(6 ,login_facility_id);
						pstmt.setString(7 ,login_by_id);
						pstmt.setString(8 ,login_at_ws_no);
						pstmt.setString(9 ,login_facility_id);
						pstmt.addBatch();
						
					}else if (group_by.equals("O"))
					{	
						for(int j=0 ; j < insertArrList.size() ; j++)
						{
							tabData  = (HashMap)insertArrList.get(j);
							code        =  (String)tabData.get("code");
														
							pstmt.setString(1 ,resource_type);
							pstmt.setString(2 ,order_catalog);
							pstmt.setString(3 ,code);							
							pstmt.setString(4 ,login_by_id);
							pstmt.setString(5 ,login_at_ws_no);
							pstmt.setString(6 ,login_facility_id);
							pstmt.setString(7 ,login_by_id);
							pstmt.setString(8 ,login_at_ws_no);
							pstmt.setString(9 ,login_facility_id);

							pstmt.addBatch();
							//insertCounts[j] = pstmt.executeUpdate();
						}
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
				if (group_by.equals("P") || group_by.equals("S"))
				{					
						delMapData  = (HashMap)deleteArrList.get(0);
						code        =  (String)delMapData.get("code");
						
					
						
						pstmt_del.setString(1 ,resource_type);
						pstmt_del.setString(2 ,code);						
						pstmt_del.setString(3 ,order_catalog);
						
						pstmt_del.addBatch();
					
				}else if (group_by.equals("O"))
				{
					for(int k=0 ; k < deleteArrList.size() ; k++)
					{
						delMapData  = (HashMap)deleteArrList.get(k);
						code  = (String)delMapData.get("code");

					

						pstmt_del.setString(1 ,resource_type);
						pstmt_del.setString(2 ,order_catalog);						
						pstmt_del.setString(3 ,code);

						pstmt_del.addBatch();
					}
				}

				deleteCounts = pstmt_del.executeBatch();

				for (int i=0;i<deleteCounts.length ;i++ )
				{
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 ){					
						delete_flag=false;
						break;
					}
					else{					
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

		}catch(Exception e)
		{
			try{
					connection.rollback();	
				}
				catch (Exception rb)
				{
					rb.printStackTrace();
				}								
				e.printStackTrace();
			}
	finally{
		   try{
					if (pstmt != null) pstmt.close();
					if (pstmt_del != null) pstmt_del.close();
					if(connection != null) ConnectionManager.returnConnection(connection,request);
				}catch ( Exception fe ) {
					
					fe.printStackTrace() ;			
				}
		}
	
		}
	
		
	}
}
