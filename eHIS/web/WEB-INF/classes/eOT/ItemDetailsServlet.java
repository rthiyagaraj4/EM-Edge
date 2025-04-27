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

public class ItemDetailsServlet extends javax.servlet.http.HttpServlet
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
		ItemDetailsObject insertIdo = null;
		ItemDetailsObject updateIdo = null;
		ItemDetailsObject recordsIdo = null;
		ArrayList insertList = new ArrayList();
		ArrayList updateList = new ArrayList();
		StringBuffer sqlUpdate = new StringBuffer();
		StringBuffer sqlInsert = new StringBuffer();
		
		Connection con = null;
		PreparedStatement insertPstmt = null;
		PreparedStatement updatePstmt = null;
		int recordsModified = 0;
		String msg = "";
		String mode = "";
		int nRowIndex = 0;
		int setIndex = 0;
		
		String orderId = (String) req.getParameter("orderid");
		String bookingNo = (String) req.getParameter("booking_no");
		
		String itemCode = "";
		String itemQuantity = "";
		String requestedDate = "";
		String cancel = "";
		String cancelledRemark = "";
		String itemSpecRemark = "";
		
		sqlUpdate.append("	UPDATE ot_manage_item_request	");
		sqlUpdate.append("	SET item_code = ?,	");
		sqlUpdate.append("	quantity = ?,	");
		sqlUpdate.append("	requested_date = TO_DATE (?, 'dd/mm/yyyy'),	");
		sqlUpdate.append("	cancel_status = ?,	");
		sqlUpdate.append("	cancel_remarks = ?,	");
		sqlUpdate.append("	item_spec_remarks = ?	");
		sqlUpdate.append("	WHERE operating_facility_id = ?	");
		sqlUpdate.append("	AND order_id = ?	");
		sqlUpdate.append("	AND item_code = ?	");
		sqlUpdate.append("	AND booking_num = ?	");

		sqlInsert.append("	INSERT INTO ot_manage_item_request	");
		sqlInsert.append("	(operating_facility_id, order_id, booking_num, item_code,	");
		sqlInsert.append("	quantity, requested_date, cancel_status, cancel_remarks,	");
		sqlInsert.append("	item_spec_remarks, added_by_id, added_date, added_at_ws_no,	");
		sqlInsert.append("	added_facility_id, modified_by_id, modified_date,	");
		sqlInsert.append("	modified_at_ws_no, modified_facility_id	");
		sqlInsert.append("	)	");
		sqlInsert.append("	VALUES (?, ?, ?, ?,	");
		sqlInsert.append("	?, TO_DATE (?, 'dd/mm/yyyy'), ?, ?,	");
		sqlInsert.append("	?, ?, SYSDATE, ?,	");
		sqlInsert.append("	?, ?, SYSDATE,	");
		sqlInsert.append("	?, ?	");
		sqlInsert.append("	)	");

		try 
		{
			String strFacilityId = (String) session.getAttribute("facility_id");	
			Properties p = (Properties)session.getAttribute("jdbc");
			String locale = p.getProperty("LOCALE");
			String strClientAddress = p.getProperty("client_ip_address");
			String login_user = p.getProperty("login_user");

			nRowIndex = Integer.parseInt(req.getParameter("rowIndex"));
			con = ConnectionManager.getConnection(req);

			System.out.println("===========nRowIndex======servlet====="+nRowIndex);
			for(int i=1; i<=nRowIndex; i++)
			{
				mode = req.getParameter("mode_"+i);
				System.out.println("===========mode======servlet====="+mode);
				if(mode != null && mode.equalsIgnoreCase("A"))
				{
					insertIdo = new ItemDetailsObject();
					insertIdo.setItemCode(req.getParameter("itemCode_"+i));
					insertIdo.setItemQuantity(req.getParameter("itemQuantity_"+i));
					insertIdo.setRequestedDate(req.getParameter("requestedDate_"+i));
					insertIdo.setCancel(req.getParameter("cancel_"+i));
					insertIdo.setCancelledRemark(req.getParameter("cancelledRemark_"+i));
					insertIdo.setItemSpecRemark(req.getParameter("itemSpecRemark_"+i));
					insertList.add(insertIdo);
				}
				else if(mode != null && mode.equalsIgnoreCase("U"))
				{
					updateIdo = new ItemDetailsObject();
					updateIdo.setItemCode(req.getParameter("itemCode_"+i));
					updateIdo.setItemQuantity(req.getParameter("itemQuantity_"+i));
					updateIdo.setRequestedDate(req.getParameter("requestedDate_"+i));
					updateIdo.setCancel(req.getParameter("cancel_"+i));
					updateIdo.setCancelledRemark(req.getParameter("cancelledRemark_"+i));
					updateIdo.setItemSpecRemark(req.getParameter("itemSpecRemark_"+i));
					updateList.add(updateIdo);
				}
			}
			System.out.println("===========insertList======servlet====="+insertList.size());
			System.out.println("===========updateList======servlet====="+updateList.size());

			if(insertList.size() > 0)
				insertPstmt = con.prepareStatement(sqlInsert.toString());
			if(updateList.size() > 0)
				updatePstmt = con.prepareStatement(sqlUpdate.toString());

			for(int x=0; x<insertList.size(); x++)
			{
				recordsIdo = new ItemDetailsObject();
				recordsIdo = (ItemDetailsObject) insertList.get(x);
				itemCode = recordsIdo.getItemCode();
				itemQuantity = recordsIdo.getItemQuantity();
				requestedDate = recordsIdo.getRequestedDate();
				cancel = recordsIdo.getCancel();
				cancelledRemark = recordsIdo.getCancelledRemark();
				itemSpecRemark = recordsIdo.getItemSpecRemark();
				System.out.println("===========itemCode====insert==servlet====="+itemCode);
				System.out.println("===========itemQuantity==insert====servlet====="+itemQuantity);
				System.out.println("===========requestedDate===insert===servlet====="+requestedDate);
				System.out.println("===========cancel===insert===servlet====="+cancel);
				System.out.println("===========cancelledRemark===insert===servlet====="+cancelledRemark);
				System.out.println("===========itemSpecRemark===insert===servlet====="+itemSpecRemark);
				setIndex = 0;
				insertPstmt.setString(++setIndex, strFacilityId);
				insertPstmt.setString(++setIndex, orderId);
				insertPstmt.setString(++setIndex, bookingNo);
				insertPstmt.setString(++setIndex, itemCode);
				insertPstmt.setString(++setIndex, itemQuantity);
				insertPstmt.setString(++setIndex, requestedDate);
				insertPstmt.setString(++setIndex, cancel);
				insertPstmt.setString(++setIndex, cancelledRemark);
				insertPstmt.setString(++setIndex, itemSpecRemark);
				insertPstmt.setString(++setIndex, login_user);
				insertPstmt.setString(++setIndex, strClientAddress);
				insertPstmt.setString(++setIndex, strFacilityId);
				insertPstmt.setString(++setIndex, login_user);
				insertPstmt.setString(++setIndex, strClientAddress);
				insertPstmt.setString(++setIndex, strFacilityId);
				recordsModified += insertPstmt.executeUpdate();
			}
			for(int x=0; x<updateList.size(); x++)
			{
				recordsIdo = new ItemDetailsObject();
				recordsIdo = (ItemDetailsObject) updateList.get(x);
				itemCode = recordsIdo.getItemCode();
				itemQuantity = recordsIdo.getItemQuantity();
				requestedDate = recordsIdo.getRequestedDate();
				cancel = recordsIdo.getCancel();
				cancelledRemark = recordsIdo.getCancelledRemark();
				itemSpecRemark = recordsIdo.getItemSpecRemark();
				System.out.println("===========itemCode====update==servlet====="+itemCode);
				System.out.println("===========itemQuantity==update====servlet====="+itemQuantity);
				System.out.println("===========requestedDate===update===servlet====="+requestedDate);
				System.out.println("===========cancel===update===servlet====="+cancel);
				System.out.println("===========cancelledRemark===update===servlet====="+cancelledRemark);
				System.out.println("===========itemSpecRemark===update===servlet====="+itemSpecRemark);
				setIndex = 0;
				updatePstmt.setString(++setIndex, itemCode);
				updatePstmt.setString(++setIndex, itemQuantity);
				updatePstmt.setString(++setIndex, requestedDate);
				updatePstmt.setString(++setIndex, cancel);
				updatePstmt.setString(++setIndex, cancelledRemark);
				updatePstmt.setString(++setIndex, itemSpecRemark);
				updatePstmt.setString(++setIndex, strFacilityId);
				updatePstmt.setString(++setIndex, orderId);
				updatePstmt.setString(++setIndex, itemCode);
				updatePstmt.setString(++setIndex, bookingNo);
				recordsModified += updatePstmt.executeUpdate();
			}

			 MessageManager mm = new MessageManager();
			 
			 System.out.println("===========recordsModified======servlet====="+recordsModified);
			/* if(recordsModified == insertList.size() + updateList.size())
			 {
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
			 }
			 else
			 {
				con.rollback();
				java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
			 }*/
			 con.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
			msg = ((String) mesg.get("message"));
			System.out.println("===========msg======servlet====="+msg);
//			out.println(msg);
			out.println("<script>alert('Operation Completed Successfully');window.close();</script>");
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
				if(updatePstmt!=null)
					updatePstmt.close();
				if(con!=null)
					ConnectionManager.returnConnection(con,req);
			}
			catch(Exception e)
			{
				
			}
		}
    }
 }


