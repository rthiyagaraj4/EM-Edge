/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class ConfigDispCritServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		HttpSession session = req.getSession(false);
		Properties prop	= (Properties) session.getAttribute("jdbc") ;
		String locale = (String) prop.getProperty("LOCALE");

		try
		{
			out = res.getWriter();
			insertConfigFlds(req, out, prop, session);
			String error_value = "0" ;		
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode((String)MessageManager.getMessage(locale,"RECORD_INSERTED","CA").get("message") ,"UTF-8") +"&err_value="+error_value);
		}
		catch(Exception e)
		{
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode((String)MessageManager.getMessage(locale, "TRANSACTION_FAILED", "CA").get("message") ,"UTF-8") +"&err_value=1");
			out.println(e.toString());
			
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);		
	}


   private void insertConfigFlds(HttpServletRequest req, PrintWriter out, Properties prop, HttpSession session)
   {
		String facilityId = (String) session.getAttribute("facility_id") ;
		String client_ip_address = (String) prop.getProperty("client_ip_address");
		String addedById = prop.getProperty("login_user");
		String applicable = req.getParameter("applicable");

		eCA.SectionConfigDispFldBean confBean = (eCA.SectionConfigDispFldBean)session.getAttribute("ConfigDispFldBean");
		HashMap<String, ArrayList<String>> data = confBean.getSelectedData();
		Set<String> keys = data.keySet();
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		String delSql = "DELETE FROM CA_LINK_CATEG_DEF WHERE RESULT_CATEGORY = ? AND RESULT_SUB_CATEGORY = ?";	
		String insertSql = "INSERT INTO CA_LINK_CATEG_DEF (RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, ORDER_SEQ_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		
		try
		{
			con = ConnectionManager.getConnection(req);	

			if(applicable.equals("NA"))
			{
				pst1 = con.prepareStatement(delSql);
			}
			else
			{
				pst1 = con.prepareStatement(delSql);
				pst = con.prepareStatement(insertSql);
			}


			for(String str : keys)
			{
				ArrayList<String> row = data.get(str);
				String result_category = row.get(0);
				String result_sub_category = row.get(1);

				pst1.setString(1,result_category);
				pst1.setString(2,result_sub_category);
				pst1.executeUpdate();
				
			}

			if(applicable.equals("A"))
			{
				
				for(String str : keys)
				{
					ArrayList<String> row = data.get(str);
					String result_category = row.get(0);
					String result_sub_category = row.get(1);
					String field_ref = row.get(2);
					String default_order_seq = row.get(3);

					pst.setString(1, result_category);
					pst.setString(2, result_sub_category);
					pst.setString(3, field_ref);
					pst.setInt(4, Integer.parseInt(default_order_seq));
					pst.setString(5, addedById);
					pst.setString(6, client_ip_address);
					pst.setString(7, facilityId);
					pst.setString(8, addedById);
					pst.setString(9, client_ip_address);
					pst.setString(10,facilityId);
					pst.executeUpdate();
				}
			}
		
			con.commit();
			if(pst != null)
			{
				pst.close();
			}
			if(pst1 != null)
			{
				pst1.close();
			}
		}
		catch (Exception e)
		{
			try
			{
				con.rollback();
			}
			catch (Exception exs)
			{
			}
			//out.println(" Exception raised ...  Error Received : "+e.toString());//common-icn-0181
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst != null)
				{
					pst.close();
				}
				if(pst1 != null)
				{
					pst1.close();
				}
				if(con != null)
				{
				   con.close();
				}
			}
			catch (SQLException se)
			{
				//out.println(" Exception raised ... Error Received : "+se.toString());//common-icn-0181
				
				se.printStackTrace();
			}
		}
		List list = (List) session.getAttribute("OrderSeq");
		if(list != null)
		{
			Iterator itr = list.iterator();
			while(itr.hasNext())
			{
				itr.next();
				itr.remove();
			}
		}
		confBean.clearBean();
			 
   } // end of insertConfigFlds
}
