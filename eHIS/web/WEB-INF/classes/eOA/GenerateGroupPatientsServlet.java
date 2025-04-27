/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;
 

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;
import com.ehis.util.*;

public class GenerateGroupPatientsServlet extends javax.servlet.http.HttpServlet	{

	PrintWriter out;
    Properties p;
    String facilityId;
    String login_user;
    String client_ip_address;
    String mode;
    boolean inserted;
    Connection con;
    
public void init(ServletConfig config) throws ServletException	{ 
	super.init(config);
	}
public  void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws javax.servlet.ServletException,IOException
	{
	try {
	    
			HttpSession httpsession = httpservletrequest.getSession(false);
            facilityId = (String)httpsession.getValue("facility_id");
            
            p = (Properties)httpsession.getValue("jdbc");
            client_ip_address = p.getProperty("client_ip_address");
            login_user = p.getProperty("login_user");
            out = httpservletresponse.getWriter();
            mode	= httpservletrequest.getParameter("mode");
            if(mode.equals("insert")){
            	GenerateGroupPatients(httpservletrequest, httpservletresponse);	
            }else if(mode.equals("delete")){
            	DeleteGroupPatients(httpservletrequest, httpservletresponse);
            }
            
            
	}
	catch (Exception e){
		out.println(e.toString());
		e.printStackTrace();

	}
	}
private void DeleteGroupPatients(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)	{
	
	try{
		con = ConnectionManager.getConnection(httpservletrequest);
		String Allpatientid=httpservletrequest.getParameter("HidSelectedPatIds");
		String groupid		= httpservletrequest.getParameter("group_id");
		String group_name	= httpservletrequest.getParameter("group_name");
		String locale = p.getProperty("LOCALE");
		String StrDelIds	= "";
		int executableCount=0;
		
		int result=0;
		for(StringTokenizer stringtokenizer = new StringTokenizer(Allpatientid, "|"); stringtokenizer.hasMoreTokens();)	{
			if(executableCount!=0){
				StrDelIds +=",";
			}
			StrDelIds +="'"+stringtokenizer.nextToken()+"'";
			executableCount = executableCount+1;
		}
		
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		
		String sql	="delete from OA_GROUP_DTLS where PATIENT_ID in ("+StrDelIds+") and GROUP_ID='"+groupid+"'";
		PreparedStatement prep =  con.prepareStatement(sql);
		
		if(executableCount >0){
			 result = prep.executeUpdate(sql);
		}
		prep.close();
		if(result > 0){ 
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
			String error = ((String) message.get("message"));
			String s5 = "1";
			out.println("<script>parent.frames[1].onSuccess(\""+mode+"\",\""+groupid+"\",\""+group_name+"\");</script>");
		}else{ 
			con.rollback();
			java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
			String error =((String) message.get("message"));
		
			out.println("<html><script>parent.frames[3].location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");

		}
		
		
	}catch ( Exception e ) {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
	}finally{
		if(con != null)  ConnectionManager.returnConnection(con, httpservletrequest);
	}
	
}


private void GenerateGroupPatients(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)	{
	
	try {
		con = ConnectionManager.getConnection(httpservletrequest);
        con.setAutoCommit(false);
		String s = "";
		String locale = p.getProperty("LOCALE");
	    String Allpatientid=httpservletrequest.getParameter("HidSelectedPatIdsInsert");
	    String patientid="";
	    String groupid=httpservletrequest.getParameter("group_id");
	    String group_name	= httpservletrequest.getParameter("group_name");
	    int executableCount=0;
	    int result=0;
     
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		
		String sql	="insert into OA_GROUP_DTLS values ( ?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		PreparedStatement prep =  con.prepareStatement(sql);
		
		for(StringTokenizer stringtokenizer = new StringTokenizer(Allpatientid, "|"); stringtokenizer.hasMoreTokens();)	{
			executableCount=executableCount+1;
			patientid = stringtokenizer.nextToken();
			prep.setString(1, groupid);
			prep.setString(2, patientid);
			prep.setString(3, login_user);
			prep.setString(4, client_ip_address);
			prep.setString(5, facilityId);
			prep.setString(6, login_user);
			prep.setString(7, client_ip_address);
			prep.setString(8, facilityId);
			prep.addBatch();
		}
		if(executableCount >0){
			int[] no = prep.executeBatch();
			result	 = no.length;
		}
		prep.close();
		//System.out.println("rows updated:"+result);
		
		if(result > 0){ 
				con.commit();
				
				out.println("<script>parent.frames[0].onSuccess(\""+mode+"\",\""+groupid+"\",\""+group_name+"\");</script>");
			
		}else{
			con.rollback();
			java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
			String error =((String) message.get("message"));
			out.println("<html><script>parent.parent.frames[2].document.location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");

		}

	} catch ( Exception e ) {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
	}finally{
		if(con != null)  ConnectionManager.returnConnection(con, httpservletrequest);
	}



}	// end mehod
} // end class
