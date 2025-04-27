package ePH ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class QuotaaLimitApprovalServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
			updateStatusRecord(request, response , out);
			
		}
		catch(Exception e){
			out.println("Exception in try of doPost() of CAVitalSignServlet.java"+e);
			e.printStackTrace();
		}
	}
	public void updateStatusRecord(HttpServletRequest request, HttpServletResponse response,PrintWriter out) throws SQLException, IOException
	{
		Connection con 	= null;
		String locale = "";
		PreparedStatement pstmt = null;	
		PreparedStatement pstmt1 = null;	
		PreparedStatement pstmt2 = null;	
		ResultSet rs=null;
		String error_value="";
		String errormsg="";
		HttpSession session = request.getSession(false);
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE"); 
		String client_ip_address = p.getProperty("client_ip_address");
		
		String modifiedById = p.getProperty("login_user");
		String facilityId		= (String)session.getValue("facility_id");
			try
			{
				con = ConnectionManager.getConnection(request); 
				Integer totalRecords	= request.getParameter("total_recs")== null ? 0 :Integer.parseInt((String)request.getParameter("total_recs"));
				int [] result			= null;
				int [] result1			= null;
				int [] result2			= null;
				
				pstmt = con.prepareStatement("DELETE FROM OR_ORDER_PEND_STATUS_LOG WHERE ORDER_ID=?");
				pstmt1 = con.prepareStatement("UPDATE OR_ORDER_LINE  SET ORDER_LINE_STATUS = ?, MODIFIED_BY_ID =?, MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
				pstmt2 = con.prepareStatement("UPDATE OR_ORDER  SET ORDER_STATUS = ?, MODIFIED_BY_ID =?, MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE ORDER_ID=?");
				
				
				for(int i=0;i<totalRecords;i++){
					System.out.println(i+"<----QuotaaLimitApprovalServlet.java-------------->"+request.getParameter("chkval"+i));
					if("Y".equals((String)request.getParameter("chkval"+i))){
							System.out.println((String)request.getParameter("ord_id"+i)+"<-------QuotaaLimitApprovalServlet.java----------->"+(String)request.getParameter("ord_auth_reqd_yn"+i));
							String StatusCode="OS";
							if ("Y".equals((String)request.getParameter("ord_auth_reqd_yn"+i))){
								StatusCode="PO";
							}		
							if("OS".equals(StatusCode)){
								pstmt.setString(1,(String)request.getParameter("ord_id"+i).trim());		
								pstmt.addBatch();
							}
							pstmt2.setString(1,StatusCode);
							pstmt2.setString(2,modifiedById); 
							pstmt2.setString(3,client_ip_address);
							pstmt2.setString(4,facilityId);
							pstmt2.setString(5,(String)request.getParameter("ord_id"+i).trim());							
							pstmt2.addBatch();
							
							pstmt1.setString(1,StatusCode);
							pstmt1.setString(2,modifiedById); 
							pstmt1.setString(3,client_ip_address);
							pstmt1.setString(4,facilityId);
							pstmt1.setString(5,(String)request.getParameter("ord_id"+i).trim());							
							pstmt1.addBatch();
							
							pstmt.clearParameters();
							pstmt2.clearParameters();
							pstmt1.clearParameters();
							
					}
				}
				result = pstmt.executeBatch();
				result2 = pstmt2.executeBatch();
				result1 = pstmt1.executeBatch();
				
				if(result1.length>0 && result2.length>0){
					con.commit();
					error_value = "1";
					errormsg = "APP-SM0001 Operation Completed Successfully ....";
					out.println("<script language=\"javascript\">");
					out.println("alert('"+errormsg+"')");
					out.println("if(top.content.workAreaFrame!=undefined){");
					out.println("top.content.workAreaFrame.QuotaLimitApprovalBottom.document.location.reload();");
					out.println("}else{");
					out.println("parent.parent.document.location.reload();");
					out.println("}");				
					out.println("</script>");				
				
				}else{
					con.rollback();
					error_value = "0";
					errormsg = "Unable to complete the operation, Please Retry....";
					out.println("<script language=\"javascript\">");
					out.println("alert('"+errormsg+"')");
					out.println("top.content.workAreaFrame.QuotaLimitApprovalBottom.document.location.reload();");
					out.println("</script>");
				}
			}catch(Exception m){
				m.printStackTrace();		
			}finally{
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
				if(con != null)	con.close();		
			}
	}
}