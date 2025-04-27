/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class RoleForUserServlet extends javax.servlet.http.HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(true);
		PrintWriter out = res.getWriter();
		RolesForUserObject insertIdo = null;
		RolesForUserObject recordsIdo = null;
		ArrayList insertList = new ArrayList();
		/* ArrayList updateList = new ArrayList();
		RolesForUserObject updateIdo = null; 
		StringBuffer sqlUpdate = new StringBuffer();
		String mode = ""; */  //Common-ICN-0055
		StringBuffer sqlInsert = new StringBuffer();
		StringBuffer sqlDelete = new StringBuffer();

		Connection con = null;
		PreparedStatement insertPstmt = null;
		PreparedStatement deletePstmt = null;
		int recordsModified = 0;
		String msg = "";
		int nRowIndex = 0;
		int setIndex = 0;

		String userId = "";
		String userName = "";
		String roleId = "";
		String roleDesc = "";
		String roleTypeDesc="";
		String applicability = "";
		String isDefault = "";

		try
		{
			String strFacilityId = (String) session.getAttribute("facility_id");
			Properties p = (Properties)session.getAttribute("jdbc");
			String locale = p.getProperty("LOCALE");
			String strClientAddress = p.getProperty("client_ip_address");
			String login_user = p.getProperty("login_user");

			nRowIndex = Integer.parseInt(req.getParameter("totalCount"));
			String user = (String)req.getParameter("user_id");
			System.err.println("===user==="+user);
			con = ConnectionManager.getConnection(req);

			sqlDelete.append("	DELETE FROM ot_roles_for_users b WHERE appl_user_id = ?	");
			deletePstmt = con.prepareStatement(sqlDelete.toString().trim());
			deletePstmt.setString(1, user);
			deletePstmt.executeUpdate();

			sqlInsert.append("	INSERT INTO OT_ROLES_FOR_USERS	");
			sqlInsert.append("	(appl_user_id, appl_user_name, role_id, role_desc, ");
			sqlInsert.append("	applicability, is_default, ");
			sqlInsert.append("	added_by_id, added_date, added_at_ws_no,	");
			sqlInsert.append("	added_facility_id, modified_by_id, modified_date,	");
			sqlInsert.append("	modified_at_ws_no, modified_facility_id,role_type	");//IN:050706
			sqlInsert.append("	)	");
			sqlInsert.append("	VALUES (?, ?, ?, ?,	");
			sqlInsert.append("	?, ?, 	");
			sqlInsert.append("	?, SYSDATE, ?,	");
			sqlInsert.append("	?, ?, SYSDATE,	");
			sqlInsert.append("	?, ?, ?	");//IN:050706
			sqlInsert.append("	)	");
			for(int i=1; i<nRowIndex; i++)
			{
				insertIdo = new RolesForUserObject();
				insertIdo.setUser(req.getParameter("user_id"));
				insertIdo.setUserName(req.getParameter("user_name"));
				insertIdo.setRole(req.getParameter("role_id_"+i));
				insertIdo.setRoleDesc(req.getParameter("role_desc_"+i));
				insertIdo.setRoleTypeDesc(req.getParameter("role_type_"+i));//IN:050706
				insertIdo.setApplicability(req.getParameter("role_applicable_"+i));
				insertIdo.setIsDefault(req.getParameter("chk_select_"+i));
				insertList.add(insertIdo);
			}
			if(insertList.size() > 0)
				insertPstmt = con.prepareStatement(sqlInsert.toString());
			for(int x=0; x<insertList.size(); x++)
			{
				recordsIdo = new RolesForUserObject();
				recordsIdo = (RolesForUserObject) insertList.get(x);
				userId = recordsIdo.getUser();
				userName = recordsIdo.getUserName();
				roleId = recordsIdo.getRole();
				roleDesc = recordsIdo.getRoleDesc();
				roleTypeDesc=recordsIdo.getRoleTypeDesc();
				applicability = recordsIdo.getApplicability();
				isDefault = recordsIdo.getIsDefault();
				setIndex = 0;
				insertPstmt.setString(++setIndex, userId);
				insertPstmt.setString(++setIndex, userName);
				insertPstmt.setString(++setIndex, roleId);
				insertPstmt.setString(++setIndex, roleDesc);
				insertPstmt.setString(++setIndex, applicability);
				insertPstmt.setString(++setIndex, isDefault);
				insertPstmt.setString(++setIndex, login_user);
				insertPstmt.setString(++setIndex, strClientAddress);
				insertPstmt.setString(++setIndex, strFacilityId);
				insertPstmt.setString(++setIndex, login_user);
				insertPstmt.setString(++setIndex, strClientAddress);
				insertPstmt.setString(++setIndex, strFacilityId);
				insertPstmt.setString(++setIndex, roleTypeDesc);//IN:050706
				recordsModified += insertPstmt.executeUpdate();
			}
			 MessageManager mm = new MessageManager();
			 con.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
			msg = ((String) mesg.get("message"));
			System.err.println("===========msg======servlet====="+msg);
			String error_value = "0" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg, "UTF-8"  ) + "&err_value=" + error_value );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(insertPstmt!=null)
					insertPstmt.close();
				if(deletePstmt!=null)
					deletePstmt.close();
				if(con!=null)
					ConnectionManager.returnConnection(con,req);
			}
			catch(Exception e)
			{

			}
		}
    }
 }
