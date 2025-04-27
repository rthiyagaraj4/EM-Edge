package eXH;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import webbeans.eCommon.*;

public class NotificationEventsToXLServlet extends HttpServlet {
    @SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
        	
            // Set the response content type and header to indicate an Excel file.
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=NotificationEvents.xls");

            // Initialize the workbook and sheet.
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("Notification Events");
            HSSFRow row = null;
            HSSFCellStyle cs = wb.createCellStyle();
            HSSFFont font = wb.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            cs.setFont(font);
			
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sqlQry = null;
 
			try {
				// Add your parameter values
				String app_id = request.getParameter("app_id");
				String event_type = request.getParameter("event_type");
				String notification_status = request.getParameter("notification_status");
				String specimen_from_date = request.getParameter("specimen_from_date");
				String specimen_to_date = request.getParameter("specimen_to_date");
				String onlyRequiredColumnCompleteQuery = request.getParameter("onlyRequiredColumnCompleteQuery");

				System.out.println("onlyRequiredColumnCompleteQuery..."+onlyRequiredColumnCompleteQuery);
				System.out.println("app_id..."+app_id+" event_type..."+event_type+" notification_status..."+notification_status+" specimen_from_date..."+specimen_from_date+" specimen_to_date..."+specimen_to_date);
	 

				if ("Failed".equals(notification_status)) {
					// Construct your query for Failed notification events
//					sqlQry = "SELECT LOCATION, SPECIMEN_NO, ENCOUNTER_ID, APPOINTMENT_NO, RELEASED_DATE_TIME, " +
//								 "TEST_NAME, NOTIFIED_TO, MOBILE_NO, SUBMISSION_STATUS, DELIVERY_STATUS, " +
//								 "SMS_SUBMITTED_ON, LAST_RESUBMIT_DATE, LAST_RESUBMITTED_BY, FAILED_REASON ," + onlyRequiredColumnCompleteQuery + 
//								 " FROM XH_NOTIFY_EVENT_MESSAGE_VW " +
//								 "WHERE APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') " +
//								 "AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? " +
//								 "AND (SUBMISSION_STATUS IN ('Not Submitted', 'Failed') OR DELIVERY_STATUS = 'Failed')";
					sqlQry = "SELECT " + onlyRequiredColumnCompleteQuery + " FROM XH_NOTIFY_EVENT_MESSAGE_VW " +
							 "WHERE APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') " +
							 "AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? " +
							 "AND (SUBMISSION_STATUS IN ('Not Submitted', 'Failed') OR DELIVERY_STATUS = 'Failed')";
				} else if ("Success".equals(notification_status)) {
					// Construct your query for Success notification events
//					sqlQry = "SELECT LOCATION, SPECIMEN_NO, ENCOUNTER_ID, APPOINTMENT_NO, RELEASED_DATE_TIME, " +
//								 "TEST_NAME, NOTIFIED_TO, MOBILE_NO, SUBMISSION_STATUS, DELIVERY_STATUS, " +
//								 "SMS_SUBMITTED_ON, LAST_RESUBMIT_DATE, LAST_RESUBMITTED_BY, FAILED_REASON ," + onlyRequiredColumnCompleteQuery + 
//								 " FROM XH_NOTIFY_EVENT_MESSAGE_VW " +
//								 "WHERE APPLICATION_ID = ? AND SUBMISSION_STATUS = 'Success' " +
//								 "AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') " +
//								 "AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					sqlQry = "SELECT " + onlyRequiredColumnCompleteQuery + " FROM XH_NOTIFY_EVENT_MESSAGE_VW " +
							 "WHERE APPLICATION_ID = ? AND SUBMISSION_STATUS = 'Success' " +
							 "AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') " +
							 "AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
				} else if ("All".equals(notification_status)) {
					// Construct your query for All notification events
					sqlQry = "SELECT " + onlyRequiredColumnCompleteQuery + " FROM XH_NOTIFY_EVENT_MESSAGE_VW " +
								 "WHERE APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') " +
								 "AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
				}

				System.out.println("(NotificationEventsToXLServlet:Query)... "+sqlQry);
	 
				connection = ConnectionManager.getConnection();
				pstmt = connection.prepareStatement(sqlQry);
				pstmt.setString(1, app_id);
				pstmt.setString(2, specimen_from_date);
				pstmt.setString(3, specimen_to_date);
				pstmt.setString(4, event_type);
				rs = pstmt.executeQuery();

				// Create headers in the Excel sheet
				row = sheet.createRow(0);
//				String[] columnNames = {"LOCATION", "SPECIMEN_NO", "ENCOUNTER_ID", "APPOINTMENT_NO", "RELEASED_DATE_TIME", "TEST_NAME", "NOTIFIED_TO", "MOBILE_NO", "SUBMISSION_STATUS", "DELIVERY_STATUS", "SMS_SUBMITTED_ON", "LAST_RESUBMIT_DATE", "LAST_RESUBMITTED_BY", "FAILED_REASON" , "EPISODE_TYPE", "STATUS_TEXT", "FACILITY_NAME", "MESSAGE_ID", "FACILITY_ID", "MESSAGE_DATE", "PATIENT_NAME", "EVENT_TYPE", "PATIENT_ID", "MERGED_PATIENT_ID", "EPISODE_ID", "VISIT_ID", "ACCESSION_NUM", "ACTION_TYPE", "LAST_PROC_DATE", "EVENT_STATUS", "NOT_REQ_REASON", "EXT_ACCESSION_NUM", "MESSAGE_STATUS", "MESSAGE_STATUS_DESC", "OUTBOUND_COMM_MODE", "PROTOCOL_LINK_ID", "PROTOCOL_LINK_NAME", "SOLICITED_YN", "ERR_MSG", "MESSAGE_LENGTH", "LAST_COMM_START_TIME", "LAST_COMM_END_TIME", "LAST_COMM_RETRIES", "QUERY_ID", "APPLICATION_NAME"};
				String[] columnNames = onlyRequiredColumnCompleteQuery.split(",");
				for (int i = 0; i < columnNames.length; i++) {
					HSSFCell cell = row.createCell(i);
					cell.setCellValue(columnNames[i].trim());
					cell.setCellStyle(cs);
				}

	 

				// Load data into the Excel sheet
				int rowNum = 1;
				while (rs.next()) {
					row = sheet.createRow(rowNum++);
					for (int i = 0; i < columnNames.length; i++) {
						HSSFCell cell = row.createCell(i);
						cell.setCellValue(rs.getString(columnNames[i].trim()));
					}
				}

				ServletOutputStream op = response.getOutputStream();
				wb.write(op);
				op.flush();
				op.close();
				
			} catch(Exception exp) {
				System.out.println("(NotificationEventsToXLServlet:Exception) "+exp.getMessage());
				exp.printStackTrace(System.err);
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
				} catch(Exception exp) {
					exp.printStackTrace(System.err);
				}
			}
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    
    public String getStrClobData(Clob clobData)
	{		
		StringBuffer sbClobData	= new StringBuffer();
		try
		{
			if(clobData!=null)
			{
				sbClobData.append(clobData.getSubString(1,(int)clobData.length()));
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return sbClobData.toString();
	}
}