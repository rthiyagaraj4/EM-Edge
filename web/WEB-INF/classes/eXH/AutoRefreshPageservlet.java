package eXH;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;

import webbeans.eCommon.ConnectionManager;

public class AutoRefreshPageservlet extends HttpServlet {

	boolean isDebugYN = false; // temporary variable for debug logging check,

	// should be removed once final testing is done

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Map<String, String> reqParams = XHUtil.getRequestParams(request);

			
			int ref_interval = Integer.parseInt(reqParams.get("ref_interval")== null ? "0": reqParams.get("ref_interval"));
			System.out.println("ref_interval..." + ref_interval);
			
			dbConn = ConnectionManager.getConnection();
			String sql = "update xh_param set LAST_NOTIFY_REFRESH_DATE_TIME = sysdate, NEXT_NOTIFY_REFRESH_DATE_TIME = sysdate + nvl(NOTIFICATION_REFRESH_INTERVAL,?)/1440";
			pstmt = dbConn.prepareStatement(sql);
			pstmt.setInt(1, ref_interval);
			int updated = pstmt.executeUpdate();
			System.out.println("Rows Updated.."+updated);
			if(updated>0){
				dbConn.commit();
			}
			pstmt.close();
			
			pstmt = dbConn.prepareStatement("select Last_Notify_Refresh_Date_Time,Next_Notify_Refresh_Date_Time from xh_param");
			rs = pstmt.executeQuery();
			
			String responseStr = "";
			if(rs!=null){
				while(rs.next()){
					responseStr = rs.getString("Last_Notify_Refresh_Date_Time")+"$!^"+rs.getString("Next_Notify_Refresh_Date_Time");
				}
			}
			
			if(rs!=null)
				rs.close();
			
			pstmt.close();
			
			PrintWriter resp = response.getWriter();
			resp.write(responseStr);
			resp.flush();
			resp.close();
			
		} catch (Exception exp) {
			System.out.println("(AutoRefreshPageservlet) Exception at executing update query...");
			exp.printStackTrace(System.err);
		} finally {
			XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
	}
}
