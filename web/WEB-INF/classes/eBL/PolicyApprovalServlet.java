package eBL;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

import com.ehis.persist.PersistenceHelper;

import eCommon.Common.CommonAdapter;

/**
 * Servlet implementation class PolicyApprovalServlet.java
 */
public class PolicyApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PolicyApprovalServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached Servlet PolicyApprovalServlet.java");
		try {
			insertData(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertData(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		String bean_id = "bl_PolicyApprovalBean";
		String bean_name = "eBL.PolicyApprovalBean";
		PolicyApprovalBean bean = (PolicyApprovalBean) PersistenceHelper
				.getBeanObject(bean_id, bean_name, request);
		String errorCode = "";
		Connection con = null;
		CallableStatement cstmt = null;
		
		HttpSession session = request.getSession(false);
		@SuppressWarnings("deprecation")
		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String loginUser = p.getProperty( "login_user" ) ;
		
		try {
			con = ConnectionManager.getConnection(request);
			cstmt = con.prepareCall("{ call BL_PROC_UPD_POLICY_APPROVAL(?,?,?,?,?,?,?) }");
			Set<String> hMapKeySet = bean.gethMap().keySet();
			if(hMapKeySet.size() > 0) {
				HashMap<String, PolicyApprovalBean> hMap = bean.gethMap();
				for (String itr : hMapKeySet) {
					PolicyApprovalBean appBean = hMap.get(itr);
				   
					cstmt.setString(1, bean.getFacilityId());
					cstmt.setString(2, appBean.getCustomerGroup());
					cstmt.setString(3, appBean.getCustomer());
					cstmt.setString(4, appBean.getPolicy());
					cstmt.setString(5, appBean.getChkBox());
					cstmt.setString(6, loginUser);
					
									
					cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
					
					cstmt.execute();
	
					errorCode += CommonAdapter.checkForNull(cstmt.getString(7));
					
					if (!"".equals(errorCode)) {
						System.err.println("Error in policyApprovalServlet: "+errorCode);
						con.rollback();
						break;
					}
				}
	
				con.commit();
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0070 Operation Completed Successfully ....", "UTF-8"));
			} else {
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-BL0842 No Changes to save...", "UTF-8"));
			}

		} catch (Exception e) {
			System.err.println("Error in PolicyApprovalServlet.java: " + e);
			con.rollback();
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + e);
			e.printStackTrace();
		} finally {
			bean.clearBean();
			if(con != null) {
				ConnectionManager.returnConnection(con, request);
			} if(cstmt != null) {
				cstmt.close();
			}
		}
	}
	
	
}
