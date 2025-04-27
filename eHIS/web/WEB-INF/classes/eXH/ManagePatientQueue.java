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
import java.io.PrintWriter;
import java.util.Map;
import java.util.List;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import eXH.XHUtil;
import webbeans.eCommon.ConnectionManager;

/**
 * Class used to handle transactions for patient queue management
 */
public class ManagePatientQueue extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {        
        HttpSession session = request.getSession(false);
		Properties p = (Properties) session.getAttribute("jdbc");	
		String locale = p.getProperty("LOCALE");		

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");		
		String message = processRequest(request,locale);
		System.out.println("message "+message);
		String action = request.getParameter("actionType");
		
		if("SAVE".equals(action))
		{
			RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+message);
			reqDis.forward(request,response);
		}
		else
		{			
			PrintWriter resp = response.getWriter();
			resp.write(message);
			resp.flush();
			resp.close();
		}
    }

	private String processRequest(HttpServletRequest request,String locale)
	{
		String retMsg = "";
		try
		{
			Map<String,String> requestParams = XHUtil.getRequestParams(request);
			String action = request.getParameter("actionType");
			String siteID = request.getParameter("siteID");
			String[] response = null;
			QueueManager queueManager = new QueueManager();
			
			addAuditInfo(requestParams, request);
		
			System.out.println("Action "+action);
			if("REGISTER".equals(action)) 
			{
				String assignedRoom = requestParams.get("roomNo");
				String practitionerID = requestParams.get("practitionerID");
				String serviceNo = requestParams.get("serviceNo");
				requestParams.put("locStatus","RE");
				response = queueManager.issueTicket(assignedRoom, serviceNo, practitionerID, requestParams);
				String statusCode = response[0];
				System.out.println("Status code "+statusCode);
				if("0".equals(statusCode))
				{
					String updateQry = "UPDATE xq_queue_simulate_trans SET queue_num='" + response[1] 
										+ "' WHERE patient_id='" + requestParams.get("patientID") + "'";
					if(QueueManager.BRUNEI_SITE_ID.equals(siteID))
					{
						updateQry += " AND service_no = '" + serviceNo + "'";
					}
					boolean isUpdated = executeQuery(updateQry, null);
					if(isUpdated) retMsg = XHUtil.getMessage("0", locale);
					else retMsg = XHUtil.getMessage("1", locale);
					updateQueueStatus(requestParams, response);
				}
				else
				{
					retMsg = response[2];
				}
			}
			else if("CANCEL".equals(action)) 
			{
				requestParams.put("locStatus","CA");
				response = queueManager.cancelTicket(requestParams.get("ticketNo"), requestParams);
			}
			else if("CALL".equals(action)) 
			{
				requestParams.put("locStatus","CL");
				response = queueManager.callTicket(requestParams.get("ticketNo"), requestParams);
			}
			else if("RECALL".equals(action))  
			{
				requestParams.put("locStatus","RC");
				response = queueManager.callTicket(requestParams.get("ticketNo"), requestParams);
			}
			else if("FINISH".equals(action))  
			{
				requestParams.put("locStatus","FN");
				response = queueManager.finishConsultation(requestParams.get("roomNo"), requestParams);
			}
			else if("CALLNEXT".equals(action))  
			{
				requestParams.put("locStatus","CN");
				response = queueManager.callNextTicket(requestParams.get("roomNo"), requestParams);
			}
			else if("SAVE".equals(action))  
			{
				requestParams.put("locStatus","S");
				retMsg = saveRecord(requestParams, locale);
			}
			else if("PENDING".equals(action))  
			{
				requestParams.put("locStatus","PN");
				response = queueManager.sendToWaitList(requestParams.get("ticketNo"), 
														requestParams.get("workStation"), 
														requestParams.get("userName"), requestParams);
			}
			else if("TRANSFER".equals(action))  
			{
				requestParams.put("locStatus","TR");
				response = queueManager.transferPatient(requestParams.get("ticketNo"), 
														requestParams.get("workStation"), 
														requestParams.get("userName"), 
														requestParams.get("nextStation"), requestParams);
			}
			else 
			{
				retMsg = "Invalid Action !!!";
			}
			
			if(!"REGISTER".equals(action) && !"SAVE".equals(action))
			{
				retMsg = processResponse(response, requestParams, locale);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			
		}
		return retMsg;
	}

	private String processResponse(String[] response, Map<String, String> requestParams, String locale) 
	{
		String retMsg = "";
		
		String resCode = response[0];
		if(resCode == "0") 
		{
			retMsg = XHUtil.getMessage("0", locale);
			updateQueueStatus(requestParams, response);
		}
		else 
		{
			retMsg = response[2];
		}
		
		return retMsg;
	}

	private String saveRecord(Map<String,String> requestParams, String locale)
	{
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		String qry = "INSERT INTO xq_queue_simulate_trans "
					+ "(patient_id, facility_id, queue_num, encounter_id, room_no, service_no, practitioner_id, workstation, workflow, username, scheduled_time, next_station) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		String message = "";
		try
		{
			String patientID = XHDBAdapter.checkNull(requestParams.get("patientID"));
			String encounterID = XHDBAdapter.checkNull(requestParams.get("encounterID"));
			String facilityID = XHDBAdapter.checkNull(requestParams.get("facilityID"));
			String ticketNo = XHDBAdapter.checkNull(requestParams.get("ticketNo"));
			String roomNo = XHDBAdapter.checkNull(requestParams.get("roomNo"));
			String serviceNo = XHDBAdapter.checkNull(requestParams.get("serviceNo"));
			String practitionerID = XHDBAdapter.checkNull(requestParams.get("practitionerID"));
			String workStation = XHDBAdapter.checkNull(requestParams.get("workStation"));
			String workflow = XHDBAdapter.checkNull(requestParams.get("workflow"));
			String userName = XHDBAdapter.checkNull(requestParams.get("userName"));
			String sheduledTime = XHDBAdapter.checkNull(requestParams.get("sheduledTime"));
			String nextStation = XHDBAdapter.checkNull(requestParams.get("nextStation"));

			String sopData = "patientID ["+patientID+"]"
								+" encounterID ["+encounterID+"]"
								+" facilityID ["+facilityID+"]"
								+" ticketNo ["+ticketNo+"]"
								+" serviceNo ["+serviceNo+"]"
								+" roomNo ["+roomNo+"]"
								+" practitionerID ["+practitionerID+"]"
								+" workStation ["+workStation+"]"
								+" workflow ["+workflow+"]"
								+" userName ["+userName+"]"
								+" sheduledTime ["+sheduledTime+"]"
								+" nextStation ["+nextStation+"]";

			System.out.println(sopData);

			dbConn = ConnectionManager.getConnection();
			pstmt = dbConn.prepareStatement(qry);
			pstmt.setString(1, patientID);
			pstmt.setString(2, facilityID);
			pstmt.setString(3, ticketNo);
			pstmt.setString(4, encounterID);
			pstmt.setString(5, roomNo);
			pstmt.setString(6, serviceNo);
			pstmt.setString(7, practitionerID);
			pstmt.setString(8, workStation);
			pstmt.setString(9, workflow);
			pstmt.setString(10, userName);
			pstmt.setString(11, sheduledTime);
			pstmt.setString(12, nextStation);
			int i = pstmt.executeUpdate();

			if(i > 0)
			{
				dbConn.commit();
				message = XHUtil.getMessage("0",locale);
			}
			else
			{
				dbConn.rollback();
				message = XHUtil.getMessage("1",locale);
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			XHUtil.closeDBResources(null, pstmt, dbConn);
		}
		return message;
	}
	
	/**
	 * 
	 */
	public boolean executeQuery(String qry,Connection dbConn)
	{		
		Statement stmt = null;
		boolean isNewDBConn = false;
		boolean isSuccess = false;
		try
		{
			if(dbConn == null) 
			{
				dbConn = ConnectionManager.getConnection();
				isNewDBConn = true;
			}
			stmt = dbConn.createStatement();
			int i = stmt.executeUpdate(qry);

			if(i > 0)
			{
				dbConn.commit();
				isSuccess = true;
			}
			else
			{
				dbConn.rollback();				
			}
		}
		catch (Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(null, stmt, null);
			if(dbConn != null && isNewDBConn) ConnectionManager.returnConnection(dbConn);
		}
		return isSuccess;
	}

	private boolean updateQueueStatus(Map<String,String> requestParams, String [] response)
	{		
		String facilityID = requestParams.get("facilityID");
		String patientID = requestParams.get("patientID");
		String locStatus = requestParams.get("locStatus");
		String serviceNo = requestParams.get("serviceNo");
		String siteID = requestParams.get("siteID");
		String ticketNo = XHDBAdapter.checkNull(response[1]);
		String query = "UPDATE xq_queue_simulate_trans SET loc_status = '"+locStatus+"', queue_num = '"+ticketNo+"' WHERE facility_id = '" + facilityID + "' AND patient_id = '"+patientID+"'";
		if(QueueManager.BRUNEI_SITE_ID.equals(siteID))
		{
			query += " AND service_no = '" + serviceNo + "'";
		}

		boolean isUpdated = XHUtil.executeUpdate(query, null);
				
		return isUpdated;
	}

	private void addAuditInfo(Map<String,String> requestParams, HttpServletRequest request)
	{
		List<String> auditInfo = ArrayAuditInfo.getArrayAuditInfo(request.getSession(false));
		if(auditInfo != null && !auditInfo.isEmpty())
		{
			requestParams.put("loggedUser", auditInfo.get(0));
			requestParams.put("clientMachine", requestParams.get("roomNo"));
			requestParams.put("facilityID", auditInfo.get(2));
		}
		requestParams.put("sessionID", request.getSession(false).getId());
	}
	
}
