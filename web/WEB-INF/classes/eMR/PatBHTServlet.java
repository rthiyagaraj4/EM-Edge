//CRF Reference No     :  ML-MMOH-CRF-1959
//Detected Release  No      :  SEPTEMBER 2023 Release 
//File prepared by          :  SANTHOSH KUMAR N
//File prepared date        :  1-07-2023
//Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
//Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    

package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class PatBHTServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;

	String modifiedById;
	String locale;
	String modifiedAtWorkstation;
	String pageName;
	String buttonType;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try {
System.err.println("doPost called");
			session = req.getSession(true);
			this.p = (java.util.Properties) session.getValue("jdbc");
			this.client_ip_address = p.getProperty("client_ip_address");
			this.facilityId = (String) session.getValue("facility_id");

			modifiedById = p.getProperty("login_user");
			locale = p.getProperty("LOCALE");
			modifiedAtWorkstation = client_ip_address;

			pageName = checkForNull(req.getParameter("pageName"));
			buttonType = checkForNull(req.getParameter("buttonType"));

			updatePatBHTStatus(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // End of doPost

	private void updatePatBHTStatus(HttpServletRequest req, HttpServletResponse res) {
		try {
			String checkedEncId = checkForNull(req.getParameter("EncounterID_param"));
			String[] encounterList = checkedEncId.split(",");
			con = ConnectionManager.getConnection(req);
			PreparedStatement prep1 =null;
			boolean updated = false;
			System.err.println("updatePatBHTStatus called");
			for (int i = 0; i < encounterList.length; i++) {
				try {
					String remarks = checkForNull(req.getParameter("remarks_" + encounterList[i]));
					StringBuffer sql = new StringBuffer();
					sql.append("update MR_PATIENT_BHT_STATUS set REMARKS='" + remarks + "',MODIFIED_AT_WS_NO='"
							+ modifiedAtWorkstation + "',MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID='" + facilityId
							+ "'");
					if (buttonType.equalsIgnoreCase("Delvier")) {
						sql.append(", STATUS='D' , DELIVERED_BY = '" + modifiedById + "',DELIVERED_DATE=sysdate");
					} else if (buttonType.equalsIgnoreCase("Receive")) {
						sql.append(", STATUS='R' , RECEIVED_BY = '" + modifiedById + "',RECEIVED_DATE=sysdate");
					} else if (buttonType.equalsIgnoreCase("Return")) {
						sql.append(", STATUS='X' , RETURN_BY = '" + modifiedById + "',RETURN_DATE=sysdate");
					}
					sql.append(" where ENCOUNTER_ID='" + encounterList[i] + "'");
					prep1 = con.prepareStatement(sql.toString());
					prep1.executeUpdate();
					if(prep1!=null) prep1.close();
					updated=true;
				} catch (Exception e) {
					con.rollback();
					updated=false;
					e.printStackTrace();
				}
			}
			if(updated) {System.err.println("updated called");
				con.commit();
				Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String msg = ((String) message.get("message"));
				out.println("<script>alert('"+msg+"');parent.window.close();</script>");
				out.println("<script>parent.BHT_result.document.location.reload();</script>");
			}

		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}

	}

	private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

} 