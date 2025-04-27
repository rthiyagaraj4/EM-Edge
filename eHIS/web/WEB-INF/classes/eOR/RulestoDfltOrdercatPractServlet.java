package eOR;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class RulestoDfltOrdercatPractServlet extends HttpServlet {

	PrintWriter out;
    Properties p;
	Connection con;
	Hashtable message=null;
   	String facilityId;
    String client_ip_address;
	String watinglistcatcode="";
    int res=0;
	String practitionertype="";
	String ordercategory="";
	String facyid="";
    StringBuffer  sql=new StringBuffer();
	PreparedStatement pstmt=null;
	StringTokenizer strToken1=null;
	StringTokenizer strToken2=null;
   

    public void init(ServletConfig servletconfig) throws ServletException {
     super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
    
	try {
			 
			 
			HttpSession session;
			session = httpservletrequest.getSession(false);
			facilityId = (String)session.getValue("facility_id");
			p = (Properties)session.getValue("jdbc");
			con					                   = ConnectionManager.getConnection(p);
			client_ip_address = p.getProperty("client_ip_address");

			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			out = httpservletresponse.getWriter();
	        ordercategory=httpservletrequest.getParameter("ordercat")==null?"":httpservletrequest.getParameter("ordercat");
			practitionertype=httpservletrequest.getParameter("practtype")==null?"":httpservletrequest.getParameter("practtype");
			facyid = httpservletrequest.getParameter("fac")==null?"":httpservletrequest.getParameter("fac");
		   
			RulestoDfltOrdercatPractServlet(httpservletrequest,httpservletresponse);
		}
        catch(Exception exception) {
        out.println(exception.toString());
		exception.printStackTrace();
        }finally
		{
		ConnectionManager.returnConnection(con,p);
		}
    
	
	}

    
 private void RulestoDfltOrdercatPractServlet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) {
     try {
		String s = p.getProperty("login_user");
		String s6 = client_ip_address;
		String locale = p.getProperty("LOCALE");
		
		strToken1= new StringTokenizer(ordercategory,"~");
		strToken2= new StringTokenizer(practitionertype,"~");
		
	   if(strToken1!=null && strToken2!=null)
	   {
	   sql.setLength(0);
	   sql.append("delete from OR_ONE_DAY_CONT_ORDER where FACILITY_ID='"+facyid+"'");
	   pstmt = con.prepareStatement(sql.toString());
	   pstmt.executeUpdate();
	  
	   if(pstmt!=null)pstmt.close(); 
	   sql.setLength(0);
	   sql.append("insert into OR_ONE_DAY_CONT_ORDER(FACILITY_ID,PRACTI_TYPE,ORDER_CATEGORY,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
	   pstmt = con.prepareStatement(sql.toString());
	   
	   while(strToken1.hasMoreElements() && strToken2.hasMoreElements())
	   {
	   String ord=(String)strToken1.nextElement();
	   String prac=(String)strToken2.nextElement();
	  
	   if(!ord.equals("") && !prac.equals(""))
	   {
     	pstmt.setString(1,facyid);
     	pstmt.setString(2,prac);
		pstmt.setString(3,ord);
		pstmt.setString(4,s);
		pstmt.setString(5,s6);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,s);
		pstmt.setString(8,s6);
		pstmt.setString(9,facilityId);
	   res=pstmt.executeUpdate();

	}  	
	}
	}
     
	String error_value="";
	if(res>0)
	{
	con.commit();
	message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
	String error=(String) message.get("message");
	error_value = "1" ;
    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value );
	}else
	{
	error_value = "0" ;
    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value="+error_value );
	}
	
	if(pstmt!=null)pstmt.close();
    if(pstmt!=null)pstmt.close();
}catch(Exception e)
{

e.printStackTrace();
}
}
}