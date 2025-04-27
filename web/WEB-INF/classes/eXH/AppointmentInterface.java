/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

public class AppointmentInterface extends HttpServlet
{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private String facilityID = "RT";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		String oaURL = getURL(request);
		System.out.println("(AppointmentInterface:doPost) oaURL: "+oaURL);
		response.sendRedirect(oaURL);
    }

	private String getURL(HttpServletRequest request)
	{
		String url = null;

		try
		{
			String function = changeFunctionName(request.getParameter("functionCall"));
			String userID = request.getParameter("login_user");
			String password = request.getParameter("p_user_password");
			String patientID = request.getParameter("patient_id");
			String apptNo = request.getParameter("i_appt_ref_no");
			
			System.out.println("function "+function);
			System.out.println("userID "+userID);
			System.out.println("password "+password);
			System.out.println("patientID "+patientID);
			System.out.println("apptNo "+apptNo);

			url = buildURL(function, userID, password, patientID, apptNo);
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}

		return url;
	}

	private String changeFunctionName(String function) 
	{
		if("NewAppointment".equalsIgnoreCase(function))
		{
			function = "SCHAPPT";
		}
		else if("RescheduleAppointment".equalsIgnoreCase(function))
		{
			function = "RESCHEDULE";
		}
		else if("CancelAppointment".equalsIgnoreCase(function))
		{
			function = "CANCEL";
		}
		return function;
	}
	public String buildURL(String function, String userID, String password, String patientID, String apptNo)
	{
		String url = buildCommonParams(function, userID, password);

		if("SCHAPPT".equals(function))
		{
			url = appendScheduleParams(url, patientID);
		}
		else if("RESCHEDULE".equals(function))
		{
			url = appendReScheduleParams(url, apptNo);
		}
		else if("CANCEL".equals(function))
		{
			url = appendCancelParams(url, apptNo);
		}

		return url;
	}

	private String buildCommonParams(String function, String userID, String password) 
	{
		String emEncrptedPassword = encryptPassword(password);
		StringBuilder url = new StringBuilder("../eOA/jsp/OAApptSchedulingForRD.jsp?locale=en&responsibility_id=OA_MANAGER&bl_operational=Y&visit_type_ind=F&tfr_appt_across_catg_yn=N&login_user=");
		url.append(userID);
		url.append("&p_user_password=");
		url.append(emEncrptedPassword);
		url.append("&functionCall=");
		url.append(function);
		url.append("&facility_id=");
		url.append(facilityID);
		return url.toString();
	}
	private String appendCancelParams(String url, String apptNo) 
	{
		url = appendCancelRescheduleParams(url, apptNo);
		return url;
	}
	
	private String appendCancelRescheduleParams(String url, String apptNo) 
	{
		Map<String, String> apptDetails = getApptDetails(apptNo, facilityID);
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append("&i_appt_ref_no=");
		urlBuilder.append(apptNo);
		urlBuilder.append("&i_from_time=");
		urlBuilder.append(apptDetails.get("i_from_time"));
		urlBuilder.append("&i_to_time=");
		urlBuilder.append(apptDetails.get("i_to_time"));
		urlBuilder.append("&i_clinic_code=");
		urlBuilder.append(apptDetails.get("i_clinic_code"));
		urlBuilder.append("&i_practitioner_id=");
		urlBuilder.append(apptDetails.get("i_practitioner_id"));
		urlBuilder.append("&i_appt_date=");
		urlBuilder.append(apptDetails.get("i_appt_date"));
		urlBuilder.append("&i_team_id=");
		urlBuilder.append(apptDetails.get("i_team_id"));
		urlBuilder.append("&over_booked=");
		urlBuilder.append(apptDetails.get("over_booked"));
		urlBuilder.append("&Forced=");
		urlBuilder.append(apptDetails.get("Forced"));
		urlBuilder.append("&clinic_type=");
		urlBuilder.append(apptDetails.get("clinic_type"));
		return urlBuilder.toString();
	}
	private String appendReScheduleParams(String url, String apptNo) 
	{
		url = appendCancelRescheduleParams(url, apptNo);
		return url;
	}
	
	private String appendScheduleParams(String url, String patientID)
	{
		url = url + "&i_practitioner_id=VS2402&clinic_code=C001&locn_type=C&callingMode=RD&resource_class=P&from_wait_list=Y&from_AE=N&order_catalog_code=&customer_id=RTN&care_locn_ind=C&rd_appt_yn=N&called_from=BD&patient_id=" + patientID;
		return url;
	}
	
	public Map<String, String> getApptDetails(String apptNo, String facilityID)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Map<String, String> apptDetails = new HashMap<String, String>();
		String qry = "SELECT to_char(appt_slab_from_time, 'hh24:mi') appt_slab_from_time, to_char(appt_slab_to_time, 'hh24:mi') appt_slab_to_time, clinic_code, practitioner_id, to_char(appt_date, 'dd/mm/yyyy') appt_date, team_id, overbooked_yn, forced_appt_yn, care_locn_type_ind, rd_appt_yn FROM oa_appt WHERE facility_id = ? AND appt_ref_no = ?";
		try
		{
			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, facilityID);
			pstmt.setString(2, apptNo);
			resultSet = pstmt.executeQuery();

			if(resultSet.next())
			{
				apptDetails.put("i_from_time", resultSet.getString("appt_slab_from_time"));
				apptDetails.put("i_to_time", resultSet.getString("appt_slab_to_time"));
				apptDetails.put("i_clinic_code", resultSet.getString("clinic_code"));
				apptDetails.put("i_practitioner_id", resultSet.getString("practitioner_id"));
				apptDetails.put("i_appt_date", resultSet.getString("appt_date"));
				apptDetails.put("i_team_id", resultSet.getString("team_id"));
				apptDetails.put("over_booked", resultSet.getString("overbooked_yn"));
				apptDetails.put("Forced", resultSet.getString("forced_appt_yn"));
				apptDetails.put("clinic_type", resultSet.getString("care_locn_type_ind"));
				apptDetails.put("rd_appt_yn", resultSet.getString("rd_appt_yn"));
			}
			System.out.println("apptDetails "+apptDetails);
		}
		catch (Exception exp)
		{
			System.out.println("(AppointmentInterface:getApptDetails) Exception - " + exp.getMessage());
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(resultSet, pstmt, dbConn);
		}
		return apptDetails;
	}

	public String encryptPassword(String base64EncodedPwd)
	{
		String encryptedPwd = "";
		try
		{
			String decodedPwd = XHUtil.decodeBase64String(base64EncodedPwd, "UTF-8");
			encryptedPwd = XHUtil.emPasswordEncrypt(decodedPwd);
		}
		catch(Exception exp)
		{
			System.out.println("(AppointmentInterface:encryptPassword) base64EncodedPwd: " + base64EncodedPwd);
			exp.printStackTrace(System.err);
		}
		
		return encryptedPwd;
	}
}
