/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;



/**
 * Servlet implementation class BLMaintainServservlet
 */
@SuppressWarnings("serial")
public class BLDailyCashServlet extends HttpServlet {
	PrintWriter out;
	HttpSession session;
	Connection con = null;
	String msg = "";
	Boolean isUpdateSuccess = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BLDailyCashServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error_value = "0";
		String error = "";
		String facId = (String) request.getParameter("FacilityId");
		String loginUser = (String) request.getParameter("user");
		String WS_NO = (String) request.getParameter("WS_NO");
		String saveMode = (String) request.getParameter("modeType");

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			int row = 0;
			int idCount = 0;
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			
			System.err.println("saveMode-" + saveMode);
			if (saveMode.equals("setupSplGrp")) {
				int len = 0;
				String finArrValues = (String) request.getParameter("grpArrCode");
				len = Integer.parseInt(request.getParameter("countval"));
				System.err.println(len + " -length");
				String[] arrOfStr = finArrValues.split("@");
				String[] arrOfIds = new String[len];

				for (int k = 0; k < arrOfStr.length; k++) {
					PreparedStatement pstmt1 = null;
					try{
					arrOfIds = arrOfStr[k].split("~");
					System.err.println("arrOfStr" + k + "-" + arrOfStr[k]);
					idCount = arrOfIds.length;
					System.err.println("idCount-" + idCount);
					int col = 0;

					String serv_grp_code = arrOfIds[0];
					String LongDesc = arrOfIds[1];
					String ShortDesc = arrOfIds[2];
					String checkboxundef = arrOfIds[3];
					String checkboxexempt = arrOfIds[4];

					System.err.println("serv_grp_code-" + serv_grp_code);
					System.err.println("LongDesc-" + LongDesc);
					System.err.println("ShortDesc-" + ShortDesc);
					System.err.println("checkboxundef-" + checkboxundef);
					System.err.println("checkboxexempt-" + checkboxexempt);

					String strQuery = "INSERT INTO BL_REPORT_SERV_GROUP (SERV_GROUP_CODE,SHORT_DESC,LONG_DESC, ADDED_BY_ID,USE_FOR_UNDEFINED_ITEM,"
							+ "ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,"
							+ "EXEMPTED_RECEIPT_YN) VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";
					pstmt1 = con.prepareStatement(strQuery);
					pstmt1.setString(1, serv_grp_code);
					pstmt1.setString(2, ShortDesc);
					pstmt1.setString(3, LongDesc);
					pstmt1.setString(4, loginUser);
					pstmt1.setString(5, checkboxundef);
					pstmt1.setString(6, WS_NO);
					pstmt1.setString(7, facId);
					pstmt1.setString(8, loginUser);
					pstmt1.setString(9, WS_NO);
					pstmt1.setString(10, facId);
					pstmt1.setString(11, checkboxexempt);
					col = pstmt1.executeUpdate();
					System.err.println("strQuery-" + strQuery);
					row += col;
					}catch (SQLException eX) {
						System.err.println("sqlException in inserting service values ->" + eX);
						eX.printStackTrace();
					} catch (Exception e) {
						System.err.println("Exception in inserting service values ->" + e);
						e.printStackTrace();
					}finally{
						pstmt1.close();
					}
				}
				System.err.println("row-" + row);
				System.err.println("len-" + len);
				if (row == len) {
					isUpdateSuccess = true;
					con.commit();
				} else {
					isUpdateSuccess = false;
					con.rollback();
				}
			}
			else if (saveMode.equals("MaintainServIns")) {
				int length = 0;
				String finArrValues = (String) request.getParameter("servArrCode");
				length = Integer.parseInt(request.getParameter("count"));
				System.err.println("finArrValues "+finArrValues);
				System.err.println(length + " -length");
				String servGrpCode = (String) request.getParameter("servGrpCode");
				String[] arrOfStr1 = finArrValues.split("@");
				
					for (int k = 0; k < arrOfStr1.length; k++) {
						PreparedStatement pstmt = null;
						try {
						System.err.println("next k--"+k );
						String[] arrOfIds = new String[3];
						arrOfIds = arrOfStr1[k].split("~");
						System.err.println("arrOfStr1 " + k + "-" + arrOfStr1[k]);
						idCount = arrOfIds.length;
						System.err.println("idCount in maintain serv-" + idCount);
						int col = 0;
						String serv_itm_ind = arrOfIds[0];
						String serv_itm_code = arrOfIds[1];
						String serv_itm_desc = arrOfIds[2];
	
						System.err.println("serv_itm_ind-" + serv_itm_ind);
						System.err.println("serv_itm_code-" + serv_itm_code);
						System.err.println("serv_itm_desc-" + serv_itm_desc);
	
						String strQuery = "INSERT INTO bl_serv_by_report_serv_group (FACILITY_ID,SERV_GROUP_CODE,SERV_ITEM_IND, SERV_ITEM_CODE,ADDED_BY_ID,"
								+ "ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)"
								+ " VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
						
						pstmt = con.prepareStatement(strQuery);
						pstmt.setString(1, facId);
						pstmt.setString(2, servGrpCode);
						pstmt.setString(3, serv_itm_ind);
						pstmt.setString(4, serv_itm_code);
						pstmt.setString(5, loginUser);
						pstmt.setString(6, WS_NO);
						pstmt.setString(7, facId);
						pstmt.setString(8, loginUser);
						pstmt.setString(9, WS_NO);
						pstmt.setString(10, facId);
						col = pstmt.executeUpdate();
						System.err.println("after execution" );
						row += col;
					
					
				}catch (SQLException eX) {
					System.err.println("sqlException in inserting service values ->" + eX);
					eX.printStackTrace();
				} catch (Exception e) {
					System.err.println("Exception in inserting service values ->" + e);
					e.printStackTrace();
				} finally {
					pstmt.close();
				}
			}
				if (row == length) {
					isUpdateSuccess = true;
					con.commit();
				} else {
					isUpdateSuccess = false;
					con.rollback();
				}

			}

			if (isUpdateSuccess) {
				error_value = "1";
				error = "APP-SM0070 Operation Completed Successfully ....";
			} else {
				System.err.println(" isUpdateSuccess false->");
				error_value = "0";
				error = "Record has not been saved. Please try again";
			}
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error, "UTF-8") + "&err_value=" + error_value);

			
		} catch (SQLException sqle) {
			System.err.println("164,SQLException in BLDailyCashServlet.java" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		} catch (Exception e) {
			System.err.println("168,Exception in BLDailyCashServlet.java" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		} finally {
			try {
				if (isUpdateSuccess) {
					con.commit();
				} else {
					con.rollback();
				}
				if (con != null) {
					// ConnectionManager.returnConnection(con);
					con.close();
				} else {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Final catch excep in BLDailyCashServlet.java" + e.toString());
			}
		}
	}
}
