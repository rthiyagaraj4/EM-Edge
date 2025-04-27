/**
 * --------------------------------------------------------------------------------------------------------------
 * Date     	  Edit History      	Name     			Description
 * --------------------------------------------------------------------------------------------------------------
 * 23-OCT-2018      100           	Subha Sundari M          Created
 * ---------------------------------------------------------------------------------------------------------------
*/
/**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2            V210830             23243        	AAKH-SCF-0526-TF	           MuthukumarN
*/

package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class BLAutoBillGenServlet
 */
public class BLAutoBillGenServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; //commented V210416
 
    public BLAutoBillGenServlet() {
        super();
    }
    
    Connection con = null;
	CallableStatement cstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	String sql = "";
	String sessionId = null;
	String pgmDate = null;
	HttpSession session = null;
	String cust_group = "";
	String cust_group_code = "";
	String cust_name = "";
	String cust_name_code = "";
	String visit_from_date = "";
	String visit_to_date = "";
	String episodeType = "";
	String patientId = "";
	String status = "";
	String facilityId="";
	String errorCode = "";
	String sysmsgId = "";
	String errorText = "";
	String mode = "";
	String functionId = "";
	String loginUser = "";
	String clientIp = "";
	String episodeId = "";
	String visitId = "";
	String jobId = "";
	String billSelectedYN = "";
	String sqlJobId = "";
	String genJobId = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
		try {
			System.out.println("Reached Servlet BLAutoBillGenServlet.java");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			con = ConnectionManager.getConnection(request);
			out = response.getWriter();
			mode = request.getParameter("mode");
			jobId = request.getParameter("jobId");
			if("search".equals(mode)) {
				insertAutoBillGenData(request, response);
			}
			else if("selectUnselect".equals(mode)) {
				selectunselectBillGenData(request, response);
			} else if ("apply".equals(mode)) {
				applyBillGenData(request, response);
			} else if("delete".equals(mode)) {
				deleteAutoBillGenData(request, response);
			}
		} catch(Exception e) {
			System.out.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		}finally{//Added V210416
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error in auto bill connection close: " + e);
			}
		}//Added V210416
	}

	private void insertAutoBillGenData(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		try {
			sql = "SELECT USERENV ('SESSIONID') session_id, TO_CHAR (SYSDATE, 'YYMMDDHH24MISS') pgm_date FROM DUAL";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				sessionId = rs.getString("session_id");
				pgmDate = rs.getString("pgm_date");
			}
			System.out.println("In BLAutoBillGenServlet.java --> session_id: " + sessionId + " " + "pgm_date: " + pgmDate);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in getting sessionId and pgmDate: " + e);
		}finally{//Added V210416
			try{
				//V210830 - con.close() has been removed.
				if(stmt!=null){ 
					stmt.close();
				}
				if(rs!=null){ 
					rs.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error in auto bill con close: " + e);
			}
			
		}  //Added V210416
		try {
			facilityId = checkForNull(request.getParameter("facility_id"));
			functionId = checkForNull(request.getParameter("functionId"));
			loginUser = checkForNull(request.getParameter("loginUser"));
			clientIp = checkForNull(request.getParameter("clientIp"));
			cust_group = checkForNull(request.getParameter("cust_group"));
			cust_group_code = checkForNull(request.getParameter("cust_group_code"));
			cust_name = checkForNull(request.getParameter("cust_name"));
			cust_name_code = checkForNull(request.getParameter("cust_name_code"));
			visit_from_date = checkForNull(request.getParameter("visit_from_date"));
			visit_to_date = checkForNull(request.getParameter("visit_to_date"));
			episodeType = checkForNull(request.getParameter("episode_type"));
			patientId = checkForNull(request.getParameter("patient_id"));
			status = checkForNull(request.getParameter("status"));
			cstmt = con.prepareCall("{call BL_PROC_AUTO_BILLGENERATION.bl_proc_populate_opem_bills(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, cust_group_code);
			cstmt.setString(5, cust_name_code);
			cstmt.setDate(6, new Date(getDateInLong(visit_from_date)));
			cstmt.setDate(7, new Date(getDateInLong(visit_to_date)));
			cstmt.setString(8, status);
			cstmt.setString(9, pgmDate);
			cstmt.setString(10, "BLAUOEBL");
			cstmt.setString(11, sessionId);
			cstmt.setString(12, clientIp);
			cstmt.setString(13, loginUser);
			cstmt.setString(14, functionId);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);
			cstmt.registerOutParameter(17, Types.VARCHAR);
			cstmt.execute();
			errorCode = checkForNull(cstmt.getString(15));
			sysmsgId = checkForNull(cstmt.getString(16));
			errorText = checkForNull(cstmt.getString(17));
			if("".equals(errorCode) && "".equals(errorText)) {
				con.commit();
				response.sendRedirect("../eBL/jsp/BLAutoBillGenDtls.jsp?sessionId="+sessionId+"&pgmDate="+pgmDate+"&facilityId="
										+facilityId+"&visit_from_date="+visit_from_date+"&visit_to_date="+visit_to_date
										+"&cust_group="+cust_group+"&cust_group_code="+cust_group_code+"&cust_name="+cust_name
										+"&cust_name_code="+cust_name_code+"&episodeType="+episodeType+"&patientId="+patientId
										+"&status="+status);
			}else {
				con.rollback();
				out.println("<script>parent.parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+errorText+"' </script>");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in BL_PROC_AUTO_BILLGENERATION.bl_proc_populate_opem_bills calling : " + e);
		}finally{//Added V210416
			try{
				if(cstmt != null){ 
					cstmt.close();
				}
				if(con != null){ 
					ConnectionManager.returnConnection(con, request);//V210830
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error in clsing statement : " + e);
			}//Added for V210416
		}
	}
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	private long getDateInLong(String dateString){ 
		System.out.println("dateString in getDateInLong ::: "+dateString);
		if(dateString==null){
			return 0; 
		}
		else{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
				return inputTimestamp.getTime();
			} catch (ParseException e) {
				System.out.println("Error in Input Date Format");
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	private void selectunselectBillGenData(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			facilityId = checkForNull(request.getParameter("facility_id"));
			patientId = checkForNull(request.getParameter("patientId"));
			episodeType = checkForNull(request.getParameter("episode_type"));
			episodeId = checkForNull(request.getParameter("episodeId"));
			visitId = checkForNull(request.getParameter("visitId"));
			jobId = checkForNull(request.getParameter("jobId"));
			sessionId = checkForNull(request.getParameter("sessionId"));
			billSelectedYN = checkForNull(request.getParameter("billSelectedYN"));
			cstmt = con.prepareCall("{call BL_PROC_AUTO_BILLGENERATION.update_bill_selected_temp(?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, visitId);
			cstmt.setString(6, jobId);
			cstmt.setString(7, sessionId);
			cstmt.setString(8, billSelectedYN);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.execute();
			errorCode = checkForNull(cstmt.getString(9));
			sysmsgId = checkForNull(cstmt.getString(10));
			errorText = checkForNull(cstmt.getString(11));
			if("".equals(errorCode) && "".equals(errorText)) {
				con.commit();
			}else {
				con.rollback();
				out.println("<script>parent.parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+errorText+"' </script>");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in BL_PROC_AUTO_BILLGENERATION.update_bill_selected_temp calling : " + e);
		}finally{//Added V210416
			try{
				if(cstmt != null){ 
					cstmt.close();
				}
				if(con != null){ 
					ConnectionManager.returnConnection(con, request);//V210830
				}//Added for V210416
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println("exception in closing con "+ex);
			}
		}
	}
	
	private void applyBillGenData(HttpServletRequest request,
			HttpServletResponse response) {
				PreparedStatement pstmt=null;//Added V210416
		try {
			facilityId = checkForNull(request.getParameter("facilityId"));
			sessionId = checkForNull(request.getParameter("sessionId"));
			loginUser = checkForNull(request.getParameter("loginUser"));
			genJobId = checkForNull(request.getParameter("jobId"));
			clientIp = checkForNull(request.getParameter("clientIp"));
			functionId = checkForNull(request.getParameter("functionId"));
			cust_group_code = checkForNull(request.getParameter("custGrpCode"));
			cust_name_code = checkForNull(request.getParameter("custCode"));
			episodeType = checkForNull(request.getParameter("episodeType"));
			if("**".equals(cust_name_code)) {
				cust_name_code = "";
			}
			
			pstmt = con.prepareStatement("insert into bl_background_process (OPERATING_FACILITY_ID, EPISODE_TYPE, FUNCTION_ID, USER_ID, ORAJOBID, ORASESSIONID, " +
					" SUBMISSION_DATE, CUST_CODE, CUST_GROUP_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, " +
					" MODIFIED_FACILITY_ID) values ('"+facilityId+"', '"+episodeType+"', '"+functionId+"', '"+loginUser+"', '"+genJobId+"', '"+sessionId+"', " +
					" sysdate, '"+cust_name_code+"', '"+cust_group_code+"', '"+loginUser+"', sysdate, '"+clientIp+"', '"+facilityId+"', '"+loginUser+"', sysdate, '"+clientIp+"', " +
					" '"+facilityId+"')");
			pstmt.executeUpdate();
			
			cstmt = con.prepareCall("{call BL_PROC_AUTO_BILLGENERATION.proc_main(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, sessionId);
			cstmt.setString(3, genJobId);
			cstmt.setString(4, loginUser);
			cstmt.setString(5, clientIp);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.execute();
			
			errorCode = checkForNull(cstmt.getString(6));
			sysmsgId = checkForNull(cstmt.getString(7));
			errorText = checkForNull(cstmt.getString(8));
			if("".equals(errorCode) && "".equals(errorText)) {
				con.commit();
			}else {
				con.rollback();
				out.println("<script>parent.parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+errorText+"' </script>");
			}
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0070 Operation Completed Successfully ....","UTF-8" ));
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("BL_PROC_AUTO_BILLGENERATION.proc_main: " + e);
		}finally{//Added V210416
		   try{
			if(pstmt != null){ 
				pstmt.close();
			}			   
			if(cstmt != null){ 
				cstmt.close();
			}
			if(con != null){ 
				ConnectionManager.returnConnection(con, request);//V210830
			}
		  }catch(Exception ex)
		  {
			System.out.println("Exception in  autobillgenserv"+ex);
			ex.printStackTrace();
		  }
		}//Added V210416
	}
	
	private void deleteAutoBillGenData(HttpServletRequest request, HttpServletResponse response) {
		String delBackGroundProcQry = "", delFolioTempQry = "";
		PreparedStatement pstmt = null;//Added V210416
		try {
			sessionId = (String) request.getParameter("sessionId");
			System.err.println("deleteAutoBillGenData -> SessionId: "+sessionId);
			
			delBackGroundProcQry = "DELETE FROM bl_pat_autobil_folio_temp WHERE job_id = 'XXXXX' AND session_id = ?";
			delFolioTempQry = "DELETE FROM bl_background_process WHERE orajobid = 'XXXXX' AND orasessionid = ?";
			
			pstmt = con.prepareStatement(delFolioTempQry);
			pstmt.setString(1, sessionId);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(delBackGroundProcQry);
			pstmt.setString(1, sessionId);
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch(Exception ex) {
			System.err.println("Error in BLAutoBillGenServlet -> deleteAutoBillGenData: "+ex);
			ex.printStackTrace();
		} finally {//Added V210416
			try {
				if(con != null) ConnectionManager.returnConnection(con, request);//V210830
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(Exception e) {
				System.err.println("Error in BLAutoBillGenServlet -> deleteAutoBillGenData finally block: "+e);
				e.printStackTrace();
			}
		}//Added V210416
	}
	
}
