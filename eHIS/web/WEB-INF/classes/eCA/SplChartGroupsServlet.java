/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
09/08/2017		IN058006	Prakash C		09/08/2017		Ramesh G		ML-MMOH-CRF-0461
------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
	
public class SplChartGroupsServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			update(request, response);
		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of ChartSetupServlet.java"+e);//common-icn-0181
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			doPost(req,response);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
{
	Connection con 		= null;
	String error = "" ;
	String locale="";
	PreparedStatement pstmt 	= null;	
	boolean update_spl_chart_group_flag=false;
	int totalNum = Integer.parseInt(request.getParameter("totalRecords"));
	try
	{
		con = ConnectionManager.getConnection(request); 
		String sql = "UPDATE CA_SPL_CHART_TYPE_GRP SET EFF_STATUS=? WHERE SPL_CHART_TYPE_GRP_ID=?";
		pstmt = con.prepareStatement(sql);	
		String spl_chart_id = "";
		String chk1 = "";
	
		for(int i=1;i<=totalNum;i++)
		{
				spl_chart_id  = (String) request.getParameter("spl_chart_id"+i); 
				chk1   = (String) (request.getParameter("chec"+i)== null ? "D" : request.getParameter("chec"+i)) ; 		          
				pstmt.setString(1,chk1);
				pstmt.setString(2,spl_chart_id);
				pstmt.addBatch();
		}
		int [] updateCounts = pstmt.executeBatch();	
		con.commit() ;
		for (int i=0;i<updateCounts.length ;i++ )
		{
			if(updateCounts[i]<0  && updateCounts[i] != -2 )
			{
				update_spl_chart_group_flag=false;
				break;
			}
			else
			{
				update_spl_chart_group_flag=true;
			}
		}
		if(update_spl_chart_group_flag)
			error = getMessage (locale, "RECORD_INSERTED","CA");
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8"));
		}
	catch(Exception m){
		m.printStackTrace();		
	}
	finally
		{

		if(pstmt != null)pstmt.close();
		if(con != null)	con.close();		
		}
	}
private String getMessage(String locale, String messageId, String moduleId)
{
	java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
	String mesg = (String) message.get("message");
	message.clear();
	return(mesg) ;
}
}
